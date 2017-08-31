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
 * Collection of all test files from test/SemaTemplate folder
 * @author Vladimir Voskresensky
 */
public class AllSemaTemplateTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/";
  public AllSemaTemplateTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.sema/test/unit/src/org/clang/sema/test/AllSemaTemplateTest.txt");
  }  
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_ackermann_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ackermann.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ackermann.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_address_spaces_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/address-spaces.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/address-spaces.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alias_church_numerals_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-church-numerals.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-church-numerals.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alias_nested_nontag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-nested-nontag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-nested-nontag.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_alias_template_template_param_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-template-template-param.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-template-template-param.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_alias_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alias-templates.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_alignas_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alignas.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/alignas.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_ambiguous_ovl_print_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ambiguous-ovl-print.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ambiguous-ovl-print.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_anonymous_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/anonymous-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/anonymous-union.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_array_to_pointer_decay_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/array-to-pointer-decay.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/array-to-pointer-decay.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_atomics_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/atomics.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/atomics.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_attributes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/attributes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=gnu++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/attributes.cpp
    RUN("%clang_cc1 -std=gnu++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_canonical_expr_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/canonical-expr-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/canonical-expr-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_canonical_expr_type_0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/canonical-expr-type-0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/canonical-expr-type-0x.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_class_template_ctor_initializer_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-ctor-initializer.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-ctor-initializer.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_class_template_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-decl.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_template_id_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-id.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-id.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_template_id_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-id-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-id-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_class_template_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/class-template-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_constexpr_instantiate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/constexpr-instantiate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/constexpr-instantiate.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_constructor_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/constructor-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/constructor-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/constructor-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/constructor-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_copy_ctor_assign_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/copy-ctor-assign.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/copy-ctor-assign.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash.cpp -std=c++11
    RUN("not %clang_cc1 -verify %s -std=c++11");
  }

  @Test
  public void test_crash_10438657_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-10438657.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-10438657.cpp 2> ${TEST_TEMP_DIR}/crash-10438657.cpp.tmp
    RUN("not %clang_cc1 -fsyntax-only %s 2> %t");
    // ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-10438657.cpp < ${TEST_TEMP_DIR}/crash-10438657.cpp.tmp
    RUN("FileCheck %s < %t");
  }

  @Test
  public void test_crash_8204126_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-8204126.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-8204126.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_crash_unparsed_exception_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-unparsed-exception.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/crash-unparsed-exception.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify -fcxx-exceptions -fexceptions %s");
  }

  @Test
  public void test_current_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/current-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/current-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_cxx1z_fold_expressions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/cxx1z-fold-expressions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1z -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/cxx1z-fold-expressions.cpp
    RUN("%clang_cc1 -std=c++1z -verify %s");
  }

  @Test
  public void test_deduction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/deduction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/deduction.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_deduction_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/deduction-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/deduction-crash.cpp -std=c++11 2>&1| ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/deduction-crash.cpp
    RUN("not %clang_cc1 -fsyntax-only %s -std=c++11 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_default_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_default_arguments_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-arguments-cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-arguments-cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_default_expr_arguments_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_default_expr_arguments_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-dump ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments-2.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/default-expr-arguments-2.cpp
    RUN("%clang_cc1 -ast-dump %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_delegating_constructors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/delegating-constructors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/delegating-constructors.cpp -verify
    RUN("%clang_cc1 -fsyntax-only -std=c++11 %s -verify");
  }

  @Test
  public void test_dependent_base_classes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-base-classes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-base-classes.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dependent_base_member_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-base-member-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-base-member-init.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dependent_class_member_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-class-member-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-class-member-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dependent_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dependent_names_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-names.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-names.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_dependent_names_no_std_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-names-no-std.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-names-no-std.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dependent_sized_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-sized_array.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -pedantic -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-sized_array.cpp
    RUN("%clang_cc1 -fsyntax-only -pedantic -verify %s");
  }

  @Test
  public void test_dependent_template_recover_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-template-recover.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-template-recover.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_dependent_type_identity_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-type-identity.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/dependent-type-identity.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_derived_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/derived.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/derived.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/derived.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_destructor_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/destructor-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/destructor-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_elaborated_type_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/elaborated-type-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/elaborated-type-specifier.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_enum_argument_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/enum-argument.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/enum-argument.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_enum_forward_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/enum-forward.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-compatibility ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/enum-forward.cpp
    RUN("%clang_cc1 -fsyntax-only -fms-compatibility %s");
  }

  @Test
  public void test_example_typelist_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/example-typelist.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/example-typelist.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_exception_spec_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/exception-spec-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/exception-spec-crash.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fcxx-exceptions -DCXX_EXCEPTIONS -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/exception-spec-crash.cpp
    RUN("%clang_cc1 -std=c++11 -fcxx-exceptions -DCXX_EXCEPTIONS -fsyntax-only -verify %s");
  }

  @Test
  public void test_explicit_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/explicit-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fexceptions -fcxx-exceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/explicit-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fexceptions -fcxx-exceptions %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fexceptions -fcxx-exceptions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/explicit-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -fexceptions -fcxx-exceptions -std=c++11 %s");
  }

  @Test
  public void test_explicit_specialization_member_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/explicit-specialization-member.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/explicit-specialization-member.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ext_vector_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ext-vector-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ext-vector-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ext_ms_template_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ext_ms_template_spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -fms-extensions -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ext_ms_template_spec.cpp
    RUN("%clang_cc1 -fsyntax-only -fms-extensions -std=c++11 -verify %s");
  }

  @Test
  public void test_extension_sfinae_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/extension-sfinae.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/extension-sfinae.cpp -pedantic-errors -DPEDANTIC
    RUN("%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -verify %s -pedantic-errors -DPEDANTIC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/extension-sfinae.cpp -Wno-c++11-narrowing
    RUN("%clang_cc1 -triple x86_64-linux-gnu -std=c++11 -verify %s -Wno-c++11-narrowing");
  }

  @Test
  public void test_extern_templates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/extern-templates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/extern-templates.cpp -DMS
    RUN("%clang_cc1 -triple i686-pc-win32 -fsyntax-only -verify %s -DMS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu-pc-win32 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/extern-templates.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu-pc-win32 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fibonacci_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/fibonacci.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/fibonacci.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/friend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/friend.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_friend_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/friend-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/friend-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_fun_template_def_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/fun-template-def.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/fun-template-def.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/fun-template-def.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/fun-template-def.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_function_template_specialization_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/function-template-specialization.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/function-template-specialization.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_template_specialization_noreturn_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/function-template-specialization-noreturn.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/function-template-specialization-noreturn.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_implicit_instantiation_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/implicit-instantiation-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/implicit-instantiation-1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_inject_templated_friend_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend.cpp -emit-llvm -triple i386-pc-solaris2.11 -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -emit-llvm -triple %itanium_abi_triple -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend.cpp -DREDEFINE -verify
    RUN(TestState.Failed, "%clang_cc1 %s -DREDEFINE -verify");
  }

  @Test
  public void test_inject_templated_friend_post_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp -std=c++98 -triple i386-pc-solaris2.11 -emit-llvm -o - | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++98 -triple %itanium_abi_triple -emit-llvm -o -")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp -std=c++98 -triple i386-pc-solaris2.11 -emit-llvm -o - -DPROTOTYPE | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PROTOTYPE ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++98 -triple %itanium_abi_triple -emit-llvm -o - -DPROTOTYPE")./*|*/
      I("FileCheck --check-prefix=CHECK-PROTOTYPE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp -std=c++98 -triple i386-pc-solaris2.11 -emit-llvm -o - -DINSTANTIATE | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-INSTANTIATE ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++98 -triple %itanium_abi_triple -emit-llvm -o - -DINSTANTIATE")./*|*/
      I("FileCheck --check-prefix=CHECK-INSTANTIATE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp -std=c++98 -triple i386-pc-solaris2.11 -emit-llvm -o - -DPROTOTYPE -DINSTANTIATE | ${LLVM_SRC}/build/bin/FileCheck --check-prefix=CHECK-PROTOTYPE-INSTANTIATE ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp
    RUN(TestState.Failed, "%clang_cc1 %s -std=c++98 -triple %itanium_abi_triple -emit-llvm -o - -DPROTOTYPE -DINSTANTIATE")./*|*/
      I("FileCheck --check-prefix=CHECK-PROTOTYPE-INSTANTIATE %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp -DREDEFINE -verify
    RUN(TestState.Failed, "%clang_cc1 %s -DREDEFINE -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/inject-templated-friend-post.cpp -DPROTOTYPE -DREDEFINE -verify
    RUN(TestState.Failed, "%clang_cc1 %s -DPROTOTYPE -DREDEFINE -verify");
  }

  @Test
  public void test_injected_class_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/injected-class-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/injected-class-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_anonymous_union_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-anonymous-union.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-anonymous-union.cpp -Wall
    RUN("%clang_cc1 -fsyntax-only %s -Wall");
  }

  @Test
  public void test_instantiate_array_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-array.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-array.cpp -std=c++11
    RUN("%clang_cc1 -fsyntax-only -verify %s -std=c++11");
  }

  @Test
  public void test_instantiate_attr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-attr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-attr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_c99_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-c99.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-c99.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_call_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-call.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-call.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_case_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-case.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-case.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_cast_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-cast.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-cast.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_clang_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-clang.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-clang.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_complete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-complete.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-complete.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -DMSABI -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-complete.cpp
    RUN("%clang_cc1 -triple %ms_abi_triple -DMSABI -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_decl_dtor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-decl-dtor.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-decl-dtor.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_instantiate_decl_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-decl-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-decl-init.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_declref_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-declref.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-declref.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_declref_ice_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-declref-ice.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-declref-ice.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_deeply_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-deeply.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wall -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-deeply.cpp
    RUN("%clang_cc1 -fsyntax-only -Wall -verify %s");
  }

  @Test
  public void test_instantiate_default_assignment_operator_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-default-assignment-operator.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-default-assignment-operator.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_dependent_nested_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-dependent-nested-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-dependent-nested-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_elab_type_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-elab-type-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-elab-type-specifier.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_enum_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-enum.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-enum.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_instantiate_enum_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-enum-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-enum-2.cpp -fsyntax-only -verify
    RUN("%clang_cc1 %s -fsyntax-only -verify");
  }

  @Test
  public void test_instantiate_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-exception-spec.cpp -DERRORS
    RUN("%clang_cc1 -fexceptions -fcxx-exceptions -verify %s -DERRORS");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fexceptions -fcxx-exceptions -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-exception-spec.cpp
    RUN(TestState.Failed, "%clang_cc1 -fexceptions -fcxx-exceptions -emit-llvm-only %s");
  }

  @Test
  public void test_instantiate_exception_spec_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-exception-spec-cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i386-pc-solaris2.11 -std=c++11 -ftemplate-depth 16 -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-exception-spec-cxx11.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -triple %itanium_abi_triple -std=c++11 -ftemplate-depth 16 -fcxx-exceptions -fexceptions %s");
  }

  @Test
  public void test_instantiate_explicitly_after_fatal_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-explicitly-after-fatal.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -ferror-limit 1 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-explicitly-after-fatal.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-explicitly-after-fatal.cpp
    RUN("not %clang_cc1 -fsyntax-only -std=c++11 -ferror-limit 1 %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_instantiate_expr_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-1.cpp -triple x86_64-pc-linux-gnu
    RUN("%clang_cc1 -fsyntax-only -verify %s  -triple x86_64-pc-linux-gnu");
  }

  @Test
  public void test_instantiate_expr_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-2.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_instantiate_expr_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-3.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_expr_4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-4.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-4.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-4.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_expr_5_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-5.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-5.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_expr_6_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-6.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-6.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -emit-llvm-only %s");
  }

  @Test
  public void test_instantiate_expr_basic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-basic.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wno-unused-value -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-expr-basic.cpp
    RUN("%clang_cc1 -fsyntax-only -Wno-unused-value -std=c++11 %s");
  }

  @Test
  public void test_instantiate_field_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-field.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-field.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_friend_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-friend-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-friend-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_function_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-1.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_function_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-1.mm
    RUN(TestState.Failed, "%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_function_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_function_params_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-params.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i686-unknown-unknown -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-function-params.cpp
    RUN("%clang_cc1 -triple i686-unknown-unknown -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_init_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-init.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-init.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_invalid_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-invalid.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-invalid.cpp
    RUN("not %clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_instantiate_local_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-local-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-local-class.cpp
    RUN("%clang_cc1 -verify -std=c++11 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++11 -fdelayed-template-parsing ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-local-class.cpp
    RUN("%clang_cc1 -verify -std=c++11 -fdelayed-template-parsing %s");
  }

  @Test
  public void test_instantiate_member_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-class.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_member_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-expr.cpp -pedantic
    RUN("%clang_cc1 -fsyntax-only -verify %s -pedantic");
  }

  @Test
  public void test_instantiate_member_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wall -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-initializers.cpp
    RUN("%clang_cc1 -fsyntax-only -Wall -verify %s");
  }

  @Test
  public void test_instantiate_member_pointers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-pointers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-pointers.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_member_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-member-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_method_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-method.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-method.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_non_dependent_types_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-non-dependent-types.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-non-dependent-types.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-non-dependent-types.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_non_type_template_parameter_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-non-type-template-parameter.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-non-type-template-parameter.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_objc_1_mm() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-objc-1.mm");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-objc-1.mm
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_overload_candidates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-overload-candidates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-overload-candidates.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_overloaded_arrow_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-overloaded-arrow.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-overloaded-arrow.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_partial_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-partial-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++1y -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-partial-spec.cpp
    RUN("%clang_cc1 -std=c++1y -verify %s");
  }

  @Test
  public void test_instantiate_scope_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-scope.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-scope.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_instantiate_self_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-self.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-self.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_instantiate_sizeof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-sizeof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-linux-gnu -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-sizeof.cpp
    RUN("%clang_cc1 -triple x86_64-linux-gnu -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_static_var_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-static-var.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-static-var.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-static-var.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-static-var.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_subscript_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-subscript.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-subscript.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_template_template_parm_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-template-template-parm.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-template-template-parm.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_try_catch_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-try-catch.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-try-catch.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_instantiate_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_typedef_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-typedef.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-typedef.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_typeof_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-typeof.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-typeof.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_instantiate_using_decl_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-using-decl.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-using-decl.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++98 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-using-decl.cpp
    RUN("%clang_cc1 -std=c++98 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiate_var_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-var-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify -std=c++1y ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiate-var-template.cpp
    RUN("%clang_cc1 -verify -std=c++1y %s");
  }

  @Test
  public void test_instantiation_backtrace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-backtrace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-backtrace.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiation_default_1_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-default-1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-default-1.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiation_default_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-default-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-default-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiation_default_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-default-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-default-3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_instantiation_depth_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ftemplate-depth 5 -ftemplate-backtrace-limit 4 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -ftemplate-depth 5 -ftemplate-backtrace-limit 4 %s");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Xclang -verify -ftemplate-depth-5 -ftemplate-backtrace-limit=4 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth.cpp
    RUN("%clang -fsyntax-only -Xclang -verify -ftemplate-depth-5 -ftemplate-backtrace-limit=4 %s");
    // ${LLVM_SRC}/build/bin/clang -fsyntax-only -Xclang -verify -ftemplate-depth=5 -ftemplate-backtrace-limit=4 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth.cpp
    RUN("%clang -fsyntax-only -Xclang -verify -ftemplate-depth=5 -ftemplate-backtrace-limit=4 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ftemplate-depth 5 -ftemplate-backtrace-limit 4 -std=c++11 -DNOEXCEPT ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -ftemplate-depth 5 -ftemplate-backtrace-limit 4 -std=c++11 -DNOEXCEPT %s");
  }

  @Test
  public void test_instantiation_depth_defarg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-defarg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -ftemplate-depth 128 -ftemplate-backtrace-limit 4 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-defarg.cpp
    RUN(TestState.Failed/*on build server*/, "%clang_cc1 -fsyntax-only -verify -ftemplate-depth 128 -ftemplate-backtrace-limit 4 %s");
  }

  @Test
  public void test_instantiation_depth_exception_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-exception-spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 -ftemplate-depth 16 -fcxx-exceptions -fexceptions ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-exception-spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 -ftemplate-depth 16 -fcxx-exceptions -fexceptions %s");
  }

  @Test
  public void test_instantiation_depth_subst_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-subst.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-subst.cpp -ftemplate-depth 2
    RUN("%clang_cc1 -std=c++11 -verify %s -ftemplate-depth 2");
  }

  @Test
  public void test_instantiation_depth_subst_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-subst-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-depth-subst-2.cpp -ftemplate-depth 2
    RUN("%clang_cc1 -verify %s -ftemplate-depth 2");
  }

  @Test
  public void test_instantiation_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-order.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/instantiation-order.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_issue150_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/issue150.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/issue150.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_lookup_dependent_bases_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/lookup-dependent-bases.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/lookup-dependent-bases.cpp
    RUN("%clang_cc1 -fms-compatibility -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_access_ambig_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-access-ambig.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-unused-comparison ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-access-ambig.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-unused-comparison %s");
  }

  @Test
  public void test_member_access_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-access-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-access-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-access-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-access-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_member_function_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-function-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-function-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_inclass_init_value_dependent_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-inclass-init-value-dependent.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-llvm-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-inclass-init-value-dependent.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-llvm-only %s");
  }

  @Test
  public void test_member_initializers_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-initializers.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-initializers.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_member_template_access_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-template-access-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/member-template-access-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_metafun_apply_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/metafun-apply.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/metafun-apply.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_missing_class_keyword_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/missing-class-keyword-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/missing-class-keyword-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_ms_class_specialization_class_scope_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-class-specialization-class-scope.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-class-specialization-class-scope.cpp -Wno-microsoft
    RUN("%clang_cc1 -fms-extensions -fsyntax-only -verify %s -Wno-microsoft");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fdelayed-template-parsing -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-class-specialization-class-scope.cpp -Wno-microsoft
    RUN("%clang_cc1 -fms-extensions -fdelayed-template-parsing -fsyntax-only -verify %s -Wno-microsoft");
  }

  @Test
  public void test_ms_class_specialization_duplicate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-class-specialization-duplicate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -fdelayed-template-parsing -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-class-specialization-duplicate.cpp
    RUN("%clang_cc1 -fms-compatibility -fdelayed-template-parsing -fsyntax-only -verify %s");
  }

  @Test
  public void test_ms_delayed_default_template_args_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-delayed-default-template-args.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-compatibility -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-delayed-default-template-args.cpp -verify
    RUN("%clang_cc1 -fms-compatibility -std=c++11 %s -verify");
  }

  @Test
  public void test_ms_function_specialization_class_scope_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-function-specialization-class-scope.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-function-specialization-class-scope.cpp
    RUN("%clang_cc1 -fms-extensions -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -fdelayed-template-parsing -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-function-specialization-class-scope.cpp
    RUN("%clang_cc1 -fms-extensions -fdelayed-template-parsing -fsyntax-only -verify %s");
  }

  @Test
  public void test_ms_if_exists_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-if-exists.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fms-extensions -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-if-exists.cpp -verify
    RUN("%clang_cc1 -fms-extensions -std=c++11 %s -verify");
  }

  @Test
  public void test_ms_lookup_template_base_classes_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-lookup-template-base-classes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fcxx-exceptions -fexceptions -std=c++1y -fms-compatibility -fno-spell-checking -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-lookup-template-base-classes.cpp
    RUN("%clang_cc1 -fcxx-exceptions -fexceptions -std=c++1y -fms-compatibility -fno-spell-checking -fsyntax-only -verify %s");
  }

  @Test
  public void test_ms_sizeof_missing_typename_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-sizeof-missing-typename.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fms-compatibility -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/ms-sizeof-missing-typename.cpp
    RUN(TestState.Failed, "%clang_cc1 -std=c++11 -fms-compatibility -fsyntax-only -verify %s");
  }

  @Test
  public void test_nested_incomplete_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-incomplete-class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-incomplete-class.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_nested_linkage_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-linkage.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-linkage.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_nested_name_spec_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-name-spec-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-name-spec-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-name-spec-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-name-spec-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_nested_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/nested-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_operator_function_id_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/operator-function-id-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/operator-function-id-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_operator_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/operator-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/operator-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_overload_candidates_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overload-candidates.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overload-candidates.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overload-candidates.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overload-candidates.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_overload_uneval_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overload-uneval.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -Wno-unused ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overload-uneval.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -Wno-unused %s");
  }

  @Test
  public void test_overloaded_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overloaded-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/overloaded-functions.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_pack_deduction_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/pack-deduction.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/pack-deduction.cpp
    RUN("%clang_cc1 -std=c++11 -verify %s");
  }

  @Test
  public void test_partial_spec_instantiate_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/partial-spec-instantiate.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/partial-spec-instantiate.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/partial-spec-instantiate.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/partial-spec-instantiate.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_pragma_ms_struct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/pragma-ms_struct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -triple i686-apple-osx10.7.0 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/pragma-ms_struct.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -triple i686-apple-osx10.7.0 %s");
  }

  @Test
  public void test_qualified_id_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/qualified-id.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/qualified-id.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_qualified_names_diag_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/qualified-names-diag.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/qualified-names-diag.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/qualified-names-diag.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/qualified-names-diag.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_rdar9173693_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/rdar9173693.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/rdar9173693.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_recovery_crash_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/recovery-crash.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/recovery-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/recovery-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/recovery-crash.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_recursive_template_instantiation_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/recursive-template-instantiation.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/recursive-template-instantiation.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_resolve_single_template_id_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/resolve-single-template-id.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/resolve-single-template-id.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_self_comparison_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/self-comparison.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/self-comparison.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_temp_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_temp_arg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_temp_arg_enum_printing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_enum_printing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_enum_printing.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_enum_printing.cpp
    RUN("%clang_cc1 -fsyntax-only -ast-print %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_temp_arg_nontype_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_nontype.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -Wconversion -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_nontype.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++98 -Wconversion -verify %s");
  }

  @Test
  public void test_temp_arg_nontype_cxx11_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_nontype_cxx11.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_nontype_cxx11.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_temp_arg_nontype_cxx1z_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_nontype_cxx1z.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++1z ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_nontype_cxx1z.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++1z %s");
  }

  @Test
  public void test_temp_arg_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_temp_arg_type_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_type.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_arg_type.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_temp_class_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_order.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_order.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_temp_class_spec_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_temp_class_spec_blocks_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec_blocks.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec_blocks.cpp -fblocks
    RUN("%clang_cc1 -fsyntax-only -verify %s -fblocks");
  }

  @Test
  public void test_temp_class_spec_neg_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec_neg.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec_neg.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec_neg.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_class_spec_neg.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_temp_explicit_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_explicit.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -pedantic -Wc++11-compat ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_explicit.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -pedantic -Wc++11-compat %s");
  }

  @Test
  public void test_temp_explicit_cxx0x_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_explicit_cxx0x.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_explicit_cxx0x.cpp
    RUN("%clang_cc1 -fsyntax-only -std=c++11 -verify %s");
  }

  @Test
  public void test_temp_func_order_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_func_order.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/temp_func_order.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_template_class_traits_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-class-traits.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-class-traits.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_template_decl_fail_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-decl-fail.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-decl-fail.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_template_id_expr_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-id-expr.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-id-expr.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_template_id_printing_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-id-printing.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -ast-print ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-id-printing.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/template-id-printing.cpp
    RUN("%clang_cc1 -fsyntax-only -ast-print %s")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_typename_specifier_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp -Wno-unused
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wno-unused");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp -Wno-unused -fms-compatibility -DMSVC
    RUN("%clang_cc1 -fsyntax-only -verify %s -Wno-unused -fms-compatibility -DMSVC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp -Wno-unused
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -Wno-unused");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp -Wno-unused -fms-compatibility -DMSVC
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s -Wno-unused -fms-compatibility -DMSVC");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp -Wno-unused
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -Wno-unused");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier.cpp -Wno-unused -fms-compatibility -DMSVC
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s -Wno-unused -fms-compatibility -DMSVC");
  }

  @Test
  public void test_typename_specifier_2_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-2.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typename_specifier_3_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-3.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-3.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_typename_specifier_4_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-4.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++98 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++11 ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typename-specifier-4.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_typo_dependent_name_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typo-dependent-name.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/typo-dependent-name.cpp
    RUN("%clang_cc1 -fsyntax-only -verify %s");
  }

  @Test
  public void test_undefined_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/undefined-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -std=c++14 -Wundefined-func-template ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/undefined-template.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++14 -Wundefined-func-template %s");
  }

  @Test
  public void test_unresolved_construct_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/unresolved-construct.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -std=c++11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/unresolved-construct.cpp
    RUN("%clang_cc1 -std=c++11 -fsyntax-only -verify %s");
  }

  @Test
  public void test_unused_variables_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/unused-variables.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -Wunused -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/unused-variables.cpp
    RUN("%clang_cc1 -fsyntax-only -Wunused -verify %s");
  }

  @Test
  public void test_value_dependent_null_pointer_constant_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/value-dependent-null-pointer-constant.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/value-dependent-null-pointer-constant.cpp
    RUN("%clang_cc1 -fsyntax-only %s");
  }

  @Test
  public void test_virtual_member_functions_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/virtual-member-functions.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/virtual-member-functions.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -fsyntax-only -verify %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-win32 -DMSABI -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/SemaTemplate/virtual-member-functions.cpp
    RUN("%clang_cc1 -triple %ms_abi_triple -DMSABI -fsyntax-only -verify %s");
  }
  
}
