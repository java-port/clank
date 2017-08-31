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
package org.clang.parse.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.Test;

/**
 *
 * @author petrk
 */
public class JavaParserTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test";
  
  public JavaParserTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_MultiArgsTemplatesTest() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/MultiArgsTemplatesTest.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/MultiArgsTemplatesTest.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }

  @Test
  public void test_Cpp11TemplateVsExpressionTest() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/Cpp11TemplateVsExpressionTest.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/Cpp11TemplateVsExpressionTest.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }
  
  @Test
  public void test_StdVector14Test() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/StdVector14Test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -triple x86_64-unknown-linux-gnu -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++14 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/StdVector14Test.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify -std=c++14 %s");
  }
  
  @Test
  public void test_StdIoStream14Test() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/StdIoStream14Test.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -triple x86_64-unknown-linux-gnu -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++14 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/StdIoStream14Test.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -verify -std=c++14 %s");
  }
  
  @Test
  public void test_MfDoesNotPointIntoClassTest() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/MfDoesNotPointIntoClassTest.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++98 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/MfDoesNotPointIntoClassTest.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++98 %s");
  }
  
  @Test
  public void test_PrivateMemberWithFriendTemplateTest() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/PrivateMemberWithFriendTemplateTest.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -std=c++11 -verify ${SPUTNIK}/modules/org.clang.parse/test/unit/data/org/clang/parse/test/PrivateMemberWithFriendTemplateTest.cpp
    RUN("%clang_cc1 -fsyntax-only -verify -std=c++11 %s");
  }
}
