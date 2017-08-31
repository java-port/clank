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
package org.llvm.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import org.clank.support.NativeTrace;
import org.llvm.support.llvm;

/**
 * llvm-config.java
 * @author Vladimir Voskresensky
 */
public final class llvm_config {

  private llvm_config() {
  }

  public static final String LLVM_HOST_TRIPLE() {
    assert NativeTrace.isUnitTestMode() || NativeTrace.isStandalone() : "This should be called only in tests or standalone Clank";
    return TripleHolder.LLVM_HOST_TRIPLE;
  }
  
  private static class TripleHolder {
    private static final String LLVM_HOST_TRIPLE = getHostTripleSlow();
  }
          
  private static String getHostTripleSlow() {
    final String llvmSrcEnv = "LLVM_SRC";
    final String defaultTriple = "x86_64-unknown-linux-gnu";
    String llvmSrc = System.getenv(llvmSrcEnv);
    if (llvmSrc == null) {
      llvm.errs().$out(llvmSrcEnv).$out(" is not set. Using default host triple: ").$out(defaultTriple).$out("\n").flush();
      return defaultTriple;
    }
    File clangFile = new File(llvmSrc + "/build/bin/clang");
    if (!clangFile.exists()) {
      llvm.errs().$out(clangFile.getAbsolutePath()).$out(" does not exist. Using default host triple: ").$out(defaultTriple).$out("\n").flush();
      return defaultTriple;
    }
    ProcessBuilder builder = new ProcessBuilder(clangFile.getAbsolutePath(), "--version");
    try {
      Process process = builder.start();      
      String triple = null;
      try (BufferedReader rdr = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
        triple = parseTriple(rdr);
      }
      int rc = process.waitFor();
      if (rc != 0) {
        llvm.errs().$out(clangFile.getAbsolutePath()).$out(" returned ").$out(rc).$out(". Using default host triple").$out(defaultTriple).$out("\n").flush();
        return defaultTriple;
      }
      if (triple == null) {
        llvm.errs().$out("Error parsing ").$out(clangFile.getAbsolutePath()).$out(" output. Using default host triple").$out(defaultTriple).$out("\n").flush();
        return defaultTriple;
      }
      return triple;
    } catch (IOException | InterruptedException ex) {
      llvm.errs().$out("Error launching ").$out(clangFile.getAbsolutePath()).$out(". Using default host triple: ").$out(defaultTriple).$out("\n").flush();
      ex.printStackTrace();
      return defaultTriple;
    }
  }
  
  private static String parseTriple(BufferedReader rdr) throws IOException {
    // The format is:
    //  clang version 3.9.0 (tags/RELEASE_390/final 289525)
    //  Target: i386-pc-solaris2.11
    //  Thread model: posix
    //  InstalledDir: /ssd/src/LLVM39/build/bin
    String line = rdr.readLine();
    if (line == null || !line.startsWith("clang version ")) {
      return null;
    }
    line = rdr.readLine();
    String prefix = "Target:";
    if (line == null || !line.startsWith(prefix)) {
      return null;
    }
    return line.substring(prefix.length()).trim();
  }
}
