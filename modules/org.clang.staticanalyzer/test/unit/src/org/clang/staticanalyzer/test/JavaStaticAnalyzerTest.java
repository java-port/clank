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

package org.clang.staticanalyzer.test;

import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.Test;

/**
 *
 * @author Vladimir Voskresensky
 */
public class JavaStaticAnalyzerTest extends DriverTestFileBase {
  private static final String TEST_LOCATION = "${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test";
  
  public JavaStaticAnalyzerTest() {
    super(TEST_LOCATION, TestState.Successful);
  }
  
  
  public static void main(String[] args) {
    // Print tests which will be accepted per test case
    DriverTestFileBase.printAllTestFiles(false, TEST_LOCATION, (test)->true, 
            "${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/src/org/clang/staticanalyzer/test/JavaStaticAnalyzerTest_Test.txt");
  }
  
  @Override
  protected boolean keepStacksForUnimplementedMethods() {
    return false;
  }
  
  @Test
  public void test_deref_track_symbolic_region_java_c() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/deref-track-symbolic-region-java.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core.NullDereference' '-analyzer-output=text' ${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/deref-track-symbolic-region-java.c -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core.NullDereference -analyzer-output=text %s -verify");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -analyze '-analyzer-checker=core' '-analyzer-output=text' ${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/deref-track-symbolic-region-java.c -verify
    RUN("%clang_cc1 -analyze -analyzer-checker=core -analyzer-output=text %s -verify");    
  } 

  @Test
  public void test_noreturn_func_cpp() throws Throwable {
    setTestFile("${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/noreturn_func.cpp");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -fsyntax-only -verify ${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/noreturn_func.cpp
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -fsyntax-only -ast-dump %s > %T/noreturn_func.cpp.ast");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple x86_64-unknown-linux-gnu -analyze '-analyzer-checker=debug.DumpCFG' ${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/noreturn_func.cpp 2>&1 > ${TEST_TEMP_DIR}/noreturn_func.cpp.cfg
    RUN("%clang_cc1 -triple x86_64-unknown-linux-gnu -analyze -analyzer-checker=debug.DumpCFG %s 2>&1 > %T/noreturn_func.cpp.cfg");
    // diff ${TEST_TEMP_DIR}/noreturn_func.cpp.cfg ${SPUTNIK}/modules/org.clang.staticanalyzer/test/unit/data/org/clang/staticanalyzer/test/Input/noreturn_func.cpp.cfg > ${TEST_TEMP_DIR}/noreturn_func.cpp.cfg.diff
    RUN("diff %T/noreturn_func.cpp.cfg %S/Input/noreturn_func.cpp.cfg > %T/noreturn_func.cpp.cfg.diff");
  }  
}
