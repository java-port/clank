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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.clang.tools.driver.test.DriverTestFileBase;
import org.junit.Test;

/**
 *
 * @author Vladimir Voskresensky
 */
public class PreprocessorPTHTest extends DriverTestFileBase {

  private static final String TEST_LOCATION = "${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/";

  public PreprocessorPTHTest() {
    super(TEST_LOCATION, TestState.All);
  }
  private static final boolean EMIT_WITH_NATIVE_CLANK = false;
  
  @Test // copied PTH test case from AllPCHTest
  public void test_pth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o ${TEST_TEMP_DIR}/pth.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.h
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o %t %S/pth.h");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -include-pth ${TEST_TEMP_DIR}/pth.c.tmp -fsyntax-only ${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.c 2>&1 | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/pth.c
    RUN("not %clang_cc1 -triple i386-unknown-unknown -include-pth %t -fsyntax-only %s 2>&1")./*|*/
      I("FileCheck %s");
  }
  
  @Test // copied PTH test case from AllPCHTest
  public void test_emit_pth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o ${TEST_TEMP_DIR}/emit-pth.c.tmp1 ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o %t1 %s");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c > ${TEST_TEMP_DIR}/emit-pth.c.tmp2
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o - %s > %t2");
    // cmp ${TEST_TEMP_DIR}/emit-pth.c.tmp1 ${TEST_TEMP_DIR}/emit-pth.c.tmp2
    RUN("cmp %t1 %t2");
    // ${LLVM_SRC}/build/bin/clang -cc1 -internal-isystem ${LLVM_SRC}/build/lib/clang/3.9.0/include -nostdsysteminc -triple i386-unknown-unknown -emit-pth -o - ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c | ${LLVM_SRC}/build/bin/FileCheck ${LLVM_SRC}/llvm/tools/clang/test/PCH/emit-pth.c
    RUN("%clang_cc1 -triple i386-unknown-unknown -emit-pth -o - %s")./*|*/
      I("FileCheck %s");
  }  
  
  @Test
  public void test_include_pth_c() throws Throwable {
    setTestFile("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c");
    // ${LLVM_SRC}/build/bin/clang -cc1 -emit-pth ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c -o ${TEST_TEMP_DIR}/include-pth.c.tmp 
    RUN("%clang_cc1 -emit-pth %s -o %t");
    // ${LLVM_SRC}/build/bin/clang -cc1 -include-pth ${TEST_TEMP_DIR}/include-pth.c.tmp ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c -E 
    RUN("%clang_cc1 -include-pth %t %s -E")./*|*/
      I("grep 'file_to_include'")./*|*/
      I("count 2");
  }
    
  @Test
  public void test_include_pth_c_1() throws Throwable {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // RUN: %clang_cc1 -include-pth %t %s -E | grep 'file_to_include' | count 2
    // NOT [${LLVM_SRC}/build/bin/clang, -cc1, -include-pth, ${TEST_TEMP_DIR}/include-pth.c.tmp, ${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c, -E]
    // runThisTestCase();
    String TEST_FILE = substituteEnvironmentVariables("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/include-pth.c");
    String CACHE_TOKENS_FILE = substituteEnvironmentVariables("${LLVM_SRC}/llvm/tools/clang/test/Preprocessor/file_to_include.h");
//    CACHE_TOKENS_FILE = TEST_FILE;
    UsePTH(CACHE_TOKENS_FILE, TEST_FILE);
  }  
  
  @Test
  public void test_use_pth_define_a() throws Throwable {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // RUN: %clang_cc1 -emit-pth ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h -o /var/tmp/tmp/tokens-cache.tmp
    // RUN: %clang_cc1 -token-cache ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h
    String TEST_FILE = substituteEnvironmentVariables("${SPUTNIK}/modules/org.clang.lex/test/unit/data/file_use_pth_define_a.cc");
    String CACHE_TOKENS_FILE = substituteEnvironmentVariables("${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h");
    UsePTH(CACHE_TOKENS_FILE, TEST_FILE);
  }  
  
  @Test
  public void test_use_pth_simple() throws Throwable {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // RUN: %clang_cc1 -emit-pth ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h -o /var/tmp/tmp/tokens-cache.tmp
    // RUN: %clang_cc1 -token-cache ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h
    String TEST_FILE = substituteEnvironmentVariables("${SPUTNIK}/modules/org.clang.lex/test/unit/data/file_use_pth_simple.cc");
    String CACHE_TOKENS_FILE = substituteEnvironmentVariables("${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h");
    UsePTH(CACHE_TOKENS_FILE, TEST_FILE);
  }
  
  @Test
  public void test_use_pth_token_cache() throws Throwable {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // RUN: %clang_cc1 -emit-pth ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h -o /var/tmp/tmp/tokens-cache.tmp
    // RUN: %clang_cc1 -token-cache ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h
    String TEST_FILE = substituteEnvironmentVariables("${SPUTNIK}/modules/org.clang.lex/test/unit/data/file_use_pth_token_cache.cc");
    String CACHE_TOKENS_FILE = substituteEnvironmentVariables("${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h");
    UsePTH(CACHE_TOKENS_FILE, TEST_FILE);
  }   

  private void UsePTH(String fileToPreparePTHCache, String testedFile) throws Throwable {
    String CLANG_PATH = substituteEnvironmentVariables("${LLVM_SRC}/build/bin/clang++");
    String PTH_PATH = EmitPTH(CLANG_PATH, fileToPreparePTHCache);
    invokeCompiler(CLANG_PATH, "-cc1", "-triple", "i386-pc-solaris2.11", "-undef", "-token-cache", PTH_PATH, testedFile, "-E", "-CC");
  }
  
  private String EmitPTH(String ClangPath, String fileToEmit) throws Throwable {
    String outPthPath;
    outPthPath = getTestTemporaryFolder().getAbsolutePath();
//    outPthPath = "/var/tmp/tmp";
    outPthPath = outPthPath + "/" + getTestMethodName() + ".tmp";
    String [] args = {
      ClangPath, 
      "-cc1", "-triple", "i386-pc-solaris2.11",
      "-undef",
      "-emit-pth", fileToEmit, 
      "-o", outPthPath};
    if (EMIT_WITH_NATIVE_CLANK) {
      //  ${LLVM_SRC}/build/bin/clang++ -cc1 -triple i386-pc-solaris2.11 -emit-pth ${SPUTNIK}/modules/org.clang.lex/test/unit/data/include/file_to_cache.h -o /var/tmp/tmp/tokens-cache.tmp
      Path pthFile = Paths.get(outPthPath);
      try {
        Files.delete(pthFile);
      } catch (java.nio.file.NoSuchFileException e) {
        // it's OK
      }
      Process exec = Runtime.getRuntime().exec(args);
      int res = exec.waitFor();
      ASSERT_EQ(res, 0);
    } else {
      invokeCompiler(args);
    }
    return outPthPath;
  }   
}
