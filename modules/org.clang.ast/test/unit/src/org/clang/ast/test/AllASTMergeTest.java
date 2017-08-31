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
package org.clang.ast.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/ASTMerge folder
 * @author Vladimir Voskresensky
 */
public class AllASTMergeTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/";
  public AllASTMergeTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.ast/test/unit/src/org/clang/ast/test/AllASTMergeTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_anonymous_fields_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/anonymous-fields.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/anonymous-fields.cpp.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/anonymous-fields1.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/anonymous-fields1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/anonymous-fields.cpp.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/anonymous-fields2.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/anonymous-fields2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-obj -o /dev/null -ast-merge ${TEST_TEMP_DIR}/anonymous-fields.cpp.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/anonymous-fields.cpp.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/anonymous-fields.cpp
    RUN(TestState.Failed, "%clang_cc1 -emit-obj -o /dev/null -ast-merge %t.1.ast -ast-merge %t.2.ast %s");
  }

  @Test
  public void test_category_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/category.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/category.m.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/category1.m
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/category1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/category.m.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/category2.m
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/category2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/category.m.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/category.m.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/category.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/category.m
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_class_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/class.cpp.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/class1.cpp
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/class1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/class.cpp.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/class2.cpp
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/class2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/class.cpp.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/class.cpp.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class.cpp
    RUN("%clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/class.cpp.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/class.cpp.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class.cpp 2>&1 -Wno-odr -Werror
    RUN("%clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1 -Wno-odr -Werror");
  }

  @Test
  public void test_class_template_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class-template.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/class-template.cpp.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/class-template1.cpp
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/class-template1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/class-template.cpp.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/class-template2.cpp
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/class-template2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/class-template.cpp.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/class-template.cpp.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class-template.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/class-template.cpp
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_codegen_body_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/codegen-body.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/codegen-body.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/body1.c
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/body1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/codegen-body.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/body2.c
    RUN(TestState.Failed, "%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/body2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-obj -o /dev/null -ast-merge ${TEST_TEMP_DIR}/codegen-body.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/codegen-body.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/codegen-body.c
    RUN(TestState.Failed, "%clang_cc1 -emit-obj -o /dev/null -ast-merge %t.1.ast -ast-merge %t.2.ast %s");
  }

  @Test
  public void test_codegen_exprs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/codegen-exprs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/codegen-exprs.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/exprs1.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -emit-pch -o %t.1.ast %S/Inputs/exprs1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/codegen-exprs.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/exprs2.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -emit-pch -o %t.2.ast %S/Inputs/exprs2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-obj -o /dev/null -ast-merge ${TEST_TEMP_DIR}/codegen-exprs.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/codegen-exprs.c.tmp.2.ast -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/codegen-exprs.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -emit-obj -o /dev/null -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only -verify %s");
  }

  @Test
  public void test_enum_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/enum.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/enum.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/enum1.c
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/enum1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/enum.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/enum2.c
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/enum2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/enum.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/enum.c.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/enum.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/enum.c
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_exprs_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/exprs.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/exprs.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/exprs1.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -emit-pch -o %t.1.ast %S/Inputs/exprs1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -emit-pch -o ${TEST_TEMP_DIR}/exprs.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/exprs2.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -emit-pch -o %t.2.ast %S/Inputs/exprs2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -ast-merge ${TEST_TEMP_DIR}/exprs.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/exprs.c.tmp.2.ast -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/exprs.c
    RUN("%clang_cc1 -triple %itanium_abi_triple -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only -verify %s");
  }

  @Test
  public void test_function_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/function.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/function.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/function1.c
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/function1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/function.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/function2.c
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/function2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/function.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/function.c.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/function.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/function.c
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/function.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/function.c.tmp.2.ast -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/function.c
    RUN("%clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only -verify %s");
  }

  @Test
  public void test_inheritance_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/inheritance.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++1z -emit-pch -o ${TEST_TEMP_DIR}/inheritance.cpp.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/inheritance-base.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++1z -emit-pch -o %t.1.ast %S/Inputs/inheritance-base.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++1z -ast-merge ${TEST_TEMP_DIR}/inheritance.cpp.tmp.1.ast -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/inheritance.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++1z -ast-merge %t.1.ast -fsyntax-only -verify %s");
  }

  @Test
  public void test_init_ctors_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/init-ctors.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++1z -emit-pch -o ${TEST_TEMP_DIR}/init-ctors.cpp.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/init-ctors-classes.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++1z -emit-pch -o %t.1.ast %S/Inputs/init-ctors-classes.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-pc-solaris2.11 -std=c++1z -ast-merge ${TEST_TEMP_DIR}/init-ctors.cpp.tmp.1.ast -fsyntax-only -verify ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/init-ctors.cpp
    RUN("%clang_cc1 -triple %itanium_abi_triple -std=c++1z -ast-merge %t.1.ast -fsyntax-only -verify %s");
  }

  @Test
  public void test_interface_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/interface.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/interface.m.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/interface1.m
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/interface1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/interface.m.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/interface2.m
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/interface2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/interface.m.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/interface.m.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/interface.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/interface.m
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_namespace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/namespace.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/namespace.cpp.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/namespace1.cpp
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/namespace1.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/namespace.cpp.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/namespace2.cpp
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/namespace2.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/namespace.cpp.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/namespace.cpp.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/namespace.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/namespace.cpp
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_property_m() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/property.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/property.m.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/property1.m
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/property1.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/property.m.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/property2.m
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/property2.m");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/property.m.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/property.m.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/property.m 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/property.m
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_struct_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/struct.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/struct.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/struct1.c
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/struct1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/struct.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/struct2.c
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/struct2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/struct.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/struct.c.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/struct.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/struct.c
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_typedef_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/typedef.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/typedef.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/typedef1.c
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/typedef1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/typedef.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/typedef2.c
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/typedef2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/typedef.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/typedef.c.tmp.2.ast -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/typedef.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/typedef.c
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }

  @Test
  public void test_var_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/var.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/var.c.tmp.1.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/var1.c
    RUN("%clang_cc1 -emit-pch -o %t.1.ast %S/Inputs/var1.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -emit-pch -o ${TEST_TEMP_DIR}/var.c.tmp.2.ast ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/Inputs/var2.c
    RUN("%clang_cc1 -emit-pch -o %t.2.ast %S/Inputs/var2.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -ast-merge ${TEST_TEMP_DIR}/var.c.tmp.1.ast -ast-merge ${TEST_TEMP_DIR}/var.c.tmp.2.ast -fsyntax-only -fdiagnostics-show-note-include-stack ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/var.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/ASTMerge/var.c
    RUN("not %clang_cc1 -ast-merge %t.1.ast -ast-merge %t.2.ast -fsyntax-only -fdiagnostics-show-note-include-stack %s 2>&1")./*|*/
      I("FileCheck %s");
  }
  
}
