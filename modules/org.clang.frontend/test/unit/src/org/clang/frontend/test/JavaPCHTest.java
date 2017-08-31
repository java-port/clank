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
import org.clank.support.NativeTrace;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Vladimir Voskresensky
 */
public class JavaPCHTest extends DriverTestFileBase {

  private static final String TEST_LOCATION = "${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH";

  public JavaPCHTest() {
    super(TEST_LOCATION, TestState.Successful);
  }

  @BeforeClass
  public static void startUpClass() {
    // set to false to prevent collections stacks: it slows down significantly
    // When test fails comment line to investigate problem
    System.setProperty(NativeTrace.CHECK_STD_ACCESS_DESTROYED_PROP, "false");
  }  
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test) -> true,
            "${SPUTNIK}/modules/org.clang.frontend/test/unit/src/org/clang/frontend/test/JavaPCHTest.txt");
  }

  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_chain_cxx_java_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp -include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp
    RUN("%clang_cc1 -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -fsyntax-only -verify -include %s -include %s %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp -chain-include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp -chain-include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp
    RUN("%clang_cc1 -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -fsyntax-only -verify %s -chain-include %s -chain-include %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -fsyntax-only -verify -fmodules ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp -chain-include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp -chain-include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/chain-cxx-java.cpp
    RUN("%clang_cc1 -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -fsyntax-only -verify -fmodules %s -chain-include %s -chain-include %s");
  }
  
  @Test
  public void test_variables_redefinition_java_c() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/variables-redefinition-java.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -undef -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/variables-redefinition-java.c -fsyntax-only ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/variables-redefinition-java.c -verify
    RUN("%clang_cc1 -undef -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -include %s -fsyntax-only %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -undef -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -chain-include ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/variables-redefinition-java.c -fsyntax-only ${SPUTNIK}/modules/org.clang.frontend/test/unit/data/org/clang/frontend/test/PCH/variables-redefinition-java.c -verify
    RUN("%clang_cc1 -undef -working-directory ${LLVM_SRC} -resource-dir ${LLVM_SRC}/build/bin/../lib/clang/3.9.0 -chain-include %s -fsyntax-only %s -verify");
  }  
}
