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
package org.clang.format.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.*;

/**
 * Collection of all test files from test/Format folder
 * @author Vladimir Voskresensky
 */
public class AllFormatTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Format/";
  public AllFormatTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, 
            TEST_LOCATION, (test)->{ return true;/*test.getFileIndexInFolder()<120;*/ }, 
            "${SPUTNIK}/modules/org.clang.format/test/unit/src/org/clang/format/test/AllFormatTest.txt");
  }  

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_adjust_indent_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/adjust-indent.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/adjust-indent.cpp | ${LLVM_SRC}/build/bin/clang-format '-lines=2:2' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/adjust-indent.cpp
    RUN("grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -lines=2:2")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_basic_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/basic.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/basic.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/basic.cpp
    RUN("grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -style=LLVM")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_cursor_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/cursor.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/cursor.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' '-cursor=6' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/cursor.cpp
    RUN("grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -style=LLVM -cursor=6")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_disable_format_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/disable-format.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-format.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=none' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-format.cpp
    RUN("grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -style=none")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_disable_include_sorting_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp");
    // ${LLVM_SRC}/build/bin/clang-format ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp
    RUN("clang-format %s")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang-format ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp -sort-includes '-style="{SortIncludes: false}"' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp
    RUN("clang-format %s -sort-includes '-style={SortIncludes: false}'")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang-format ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp '-sort-includes=false' | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Format/disable-include-sorting.cpp '-check-prefix=NOT-SORTED'
    RUN("clang-format %s -sort-includes=false")./*|*/
      I("FileCheck %s -check-prefix=NOT-SORTED");
  }

  @Test
  public void test_incomplete_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/incomplete.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/incomplete.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' '-cursor=0' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/incomplete.cpp
    RUN("grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -style=LLVM -cursor=0")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_language_detection_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/language-detection.cpp");
    // grep -Ev '// *[A-Z0-9_]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/language-detection.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=llvm' '-assume-filename=foo.js' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK1' ${LLVM_SRC}/llvm/tools/clang/test/Format/language-detection.cpp
    RUN("grep -Ev \"// *[A-Z0-9_]+:\" %s")./*|*/
      I("clang-format -style=llvm -assume-filename=foo.js")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK1 %s");
    // grep -Ev '// *[A-Z0-9_]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/language-detection.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=llvm' '-assume-filename=foo.cpp' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK2' ${LLVM_SRC}/llvm/tools/clang/test/Format/language-detection.cpp
    RUN("grep -Ev \"// *[A-Z0-9_]+:\" %s")./*|*/
      I("clang-format -style=llvm -assume-filename=foo.cpp")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK2 %s");
  }

  @Test
  public void test_line_ranges_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/line-ranges.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/line-ranges.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' '-lines=1:1' '-lines=5:5' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/line-ranges.cpp
    RUN("grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -style=LLVM -lines=1:1 -lines=5:5")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_multiple_inputs_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs.cpp ${TEST_TEMP_DIR}/multiple-inputs.cpp.tmp-1.cpp
    RUN("cp %s %t-1.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs.cpp ${TEST_TEMP_DIR}/multiple-inputs.cpp.tmp-2.cpp
    RUN("cp %s %t-2.cpp");
    // ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' ${TEST_TEMP_DIR}/multiple-inputs.cpp.tmp-1.cpp ${TEST_TEMP_DIR}/multiple-inputs.cpp.tmp-2.cpp|FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs.cpp
    RUN("clang-format -style=LLVM %t-1.cpp %t-2.cpp")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_multiple_inputs_error_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-error.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-error.cpp ${TEST_TEMP_DIR}/multiple-inputs-error.cpp.tmp-1.cpp
    RUN("cp %s %t-1.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-error.cpp ${TEST_TEMP_DIR}/multiple-inputs-error.cpp.tmp-2.cpp
    RUN("cp %s %t-2.cpp");
    // ${LLVM_SRC}/build/bin/clang-format 2>&1 >/dev/null '-offset=1' '-length=0' ${TEST_TEMP_DIR}/multiple-inputs-error.cpp.tmp-1.cpp ${TEST_TEMP_DIR}/multiple-inputs-error.cpp.tmp-2.cpp |FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-error.cpp
    RUN("not clang-format 2>&1 >/dev/null -offset=1 -length=0 %t-1.cpp %t-2.cpp")./*|*/
      I("FileCheck %s");
    // ${LLVM_SRC}/build/bin/clang-format 2>&1 >/dev/null '-lines=1:1' ${TEST_TEMP_DIR}/multiple-inputs-error.cpp.tmp-1.cpp ${TEST_TEMP_DIR}/multiple-inputs-error.cpp.tmp-2.cpp |FileCheck ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-error.cpp '-check-prefix=CHECK-LINE'
    RUN("not clang-format 2>&1 >/dev/null -lines=1:1 %t-1.cpp %t-2.cpp")./*|*/
      I("FileCheck %s -check-prefix=CHECK-LINE");
  }

  @Test
  public void test_multiple_inputs_inplace_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-inplace.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-inplace.cpp ${TEST_TEMP_DIR}/multiple-inputs-inplace.cpp.tmp-1.cpp
    RUN("cp %s %t-1.cpp");
    // cp ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-inplace.cpp ${TEST_TEMP_DIR}/multiple-inputs-inplace.cpp.tmp-2.cpp
    RUN("cp %s %t-2.cpp");
    // ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' -i ${TEST_TEMP_DIR}/multiple-inputs-inplace.cpp.tmp-1.cpp ${TEST_TEMP_DIR}/multiple-inputs-inplace.cpp.tmp-2.cpp
    RUN("clang-format -style=LLVM -i %t-1.cpp %t-2.cpp");
    // ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace "-input-file=${TEST_TEMP_DIR}/multiple-inputs-inplace.cpp.tmp-1.cpp" ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-inplace.cpp
    RUN("FileCheck -strict-whitespace -input-file=%t-1.cpp %s");
    // ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace "-input-file=${TEST_TEMP_DIR}/multiple-inputs-inplace.cpp.tmp-2.cpp" ${LLVM_SRC}/llvm/tools/clang/test/Format/multiple-inputs-inplace.cpp
    RUN("FileCheck -strict-whitespace -input-file=%t-2.cpp %s");
  }

  @Test
  public void test_ranges_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/ranges.cpp");
    // grep -Ev '// *[A-Z-]+:' ${LLVM_SRC}/llvm/tools/clang/test/Format/ranges.cpp | ${LLVM_SRC}/build/bin/clang-format '-style=LLVM' '-offset=2' '-length=0' '-offset=28' '-length=0' | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/ranges.cpp
    RUN( "grep -Ev \"// *[A-Z-]+:\" %s")./*|*/
      I("clang-format -style=LLVM -offset=2 -length=0 -offset=28 -length=0")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

  @Test
  public void test_style_on_command_line_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp");
    // REQUIRES: shell
    if (!CHECK_REQUIRES("shell")) {
      return;
    }
    // ${LLVM_SRC}/build/bin/clang-format '-style="{BasedOnStyle: Google, IndentWidth: 8}"' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK1' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format '-style={BasedOnStyle: Google, IndentWidth: 8}' %s")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK1 %s");
    // ${LLVM_SRC}/build/bin/clang-format '-style="{BasedOnStyle: LLVM, IndentWidth: 7}"' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK2' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format '-style={BasedOnStyle: LLVM, IndentWidth: 7}' %s")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK2 %s");
    // ${LLVM_SRC}/build/bin/clang-format '-style="{BasedOnStyle: invalid, IndentWidth: 7}"' '-fallback-style=LLVM' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK3' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format '-style={BasedOnStyle: invalid, IndentWidth: 7}' -fallback-style=LLVM %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK3 %s");
    // ${LLVM_SRC}/build/bin/clang-format '-style="{lsjd}"' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp '-fallback-style=LLVM' 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK4' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format '-style={lsjd}' %s -fallback-style=LLVM 2>&1")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK4 %s");
    // printf 'BasedOnStyle: google\nIndentWidth: 5\n' > ${TEST_TEMP_DIR}/.clang-format
    RUN("printf \"BasedOnStyle: google\\nIndentWidth: 5\\n\" > %T/.clang-format");
    // ${LLVM_SRC}/build/bin/clang-format '-style=file' "-assume-filename=${TEST_TEMP_DIR}/foo.cpp" < ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK5' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format -style=file -assume-filename=%T/foo.cpp < %s")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK5 %s");
    // printf \n > ${TEST_TEMP_DIR}/.clang-format
    RUN("printf \"\\n\" > %T/.clang-format");
    // ${LLVM_SRC}/build/bin/clang-format '-style=file' '-fallback-style=webkit' "-assume-filename=${TEST_TEMP_DIR}/foo.cpp" < ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp 2>&1 | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK6' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format -style=file -fallback-style=webkit -assume-filename=%T/foo.cpp < %s 2>&1")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK6 %s");
//    // rm ${TEST_TEMP_DIR}/.clang-format
    RUN("rm %T/.clang-format");
    // printf 'BasedOnStyle: google\nIndentWidth: 6\n' > ${TEST_TEMP_DIR}/_clang-format
    RUN("printf \"BasedOnStyle: google\\nIndentWidth: 6\\n\" > %T/_clang-format");
    // ${LLVM_SRC}/build/bin/clang-format '-style=file' "-assume-filename=${TEST_TEMP_DIR}/foo.cpp" < ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK7' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format -style=file -assume-filename=%T/foo.cpp < %s")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK7 %s");
    // ${LLVM_SRC}/build/bin/clang-format '-style="{BasedOnStyle: LLVM, PointerBindsToType: true}"' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK8' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format '-style={BasedOnStyle: LLVM, PointerBindsToType: true}' %s")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK8 %s");
    // ${LLVM_SRC}/build/bin/clang-format '-style="{BasedOnStyle: WebKit, PointerBindsToType: false}"' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace '-check-prefix=CHECK9' ${LLVM_SRC}/llvm/tools/clang/test/Format/style-on-command-line.cpp
    RUN("clang-format '-style={BasedOnStyle: WebKit, PointerBindsToType: false}' %s")./*|*/
      I("FileCheck -strict-whitespace -check-prefix=CHECK9 %s");
  }

  @Test
  public void test_xmloutput_cpp() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Format/xmloutput.cpp");
    // ${LLVM_SRC}/build/bin/clang-format -output-replacements-xml -sort-includes ${LLVM_SRC}/llvm/tools/clang/test/Format/xmloutput.cpp | ${LLVM_SRC}/build/bin/FileCheck -strict-whitespace ${LLVM_SRC}/llvm/tools/clang/test/Format/xmloutput.cpp
    RUN("clang-format -output-replacements-xml -sort-includes %s")./*|*/
      I("FileCheck -strict-whitespace %s");
  }

}
