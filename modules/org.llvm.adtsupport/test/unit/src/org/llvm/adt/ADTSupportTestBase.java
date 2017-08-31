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


package org.llvm.adt;

import org.clank.java.JavaTestBase;
import org.clank.support.Native;
import org.clank.support.NativeTrace;
import org.clank.support.aliases.char$ptr;
import static org.junit.Assert.assertTrue;
import org.junit.BeforeClass;
import org.llvm.cl.opt;
import static org.llvm.config.llvm_config.LLVM_HOST_TRIPLE;
import static org.llvm.support.impl.CommandLineStatics.GlobalParser;
import org.llvm.support.llvm;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public abstract class ADTSupportTestBase extends JavaTestBase { 

  
  public ADTSupportTestBase() {
    super();
  }  

  public ADTSupportTestBase(TestState runTestsWithSpecifiedState) {
    super(runTestsWithSpecifiedState);
  }  

  protected static <T> void EXPECT_EQ(String golden, opt<T> Val) {
    EXPECT_EQ(new StringRef(golden), Val);
  }
  protected static <T> void EXPECT_EQ(char$ptr golden, opt<T> Val) {
    EXPECT_EQ(new StringRef(golden), Val);
  }
  protected static <T> void EXPECT_EQ(StringRef golden, opt<T> Val) {
    assertTrue("Expect[" + golden.toJavaString() + "] got [" + Val + "]", Native.$eq(golden, Val.$T()));
  }
  
  protected void EXPECT_STREQ(String golden, StringRef val) {
    ASSERT_STREQ(new StringRef(golden), val);
  }  
  protected void EXPECT_EQ(String golden, StringRef val) {
    ASSERT_STREQ(new StringRef(golden), val);
  }  
  
  protected void EXPECT_STREQ(StringRef golden, String val) {
    ASSERT_STREQ(golden, new StringRef(val));
  }  
  protected void EXPECT_EQ(StringRef golden, String val) {
    ASSERT_STREQ(golden, new StringRef(val));
  }  


  protected void ASSERT_STREQ(String golden, StringRef val) {
    ASSERT_STREQ(new StringRef(golden), val);
  }  
  protected void ASSERT_EQ(String golden, StringRef val) {
    ASSERT_STREQ(new StringRef(golden), val);
  }  
  
  protected void ASSERT_STREQ(char$ptr golden, StringRef val) {
    ASSERT_STREQ(new StringRef(golden), val);
  }  
  protected void ASSERT_EQ(char$ptr golden, StringRef val) {
    ASSERT_STREQ(new StringRef(golden), val);
  }  
  
  protected void ASSERT_STREQ(StringRef golden, String val) {
    ASSERT_STREQ(golden, new StringRef(val));
  } 
  protected void ASSERT_EQ(StringRef golden, String val) {
    ASSERT_STREQ(golden, new StringRef(val));
  } 
  
  protected void ASSERT_STREQ(StringRef golden, char$ptr val) {
    ASSERT_STREQ(golden, new StringRef(val));
  } 
  protected void ASSERT_EQ(StringRef golden, char$ptr val) {
    ASSERT_STREQ(golden, new StringRef(val));
  }
  
  protected void ASSERT_STREQ(StringRef golden, StringRef val) {
    assertTrue("Expect[" + golden.toJavaString() + "] got [" + val + "]", Native.$eq(golden, val));
  } 
  protected void ASSERT_EQ(StringRef golden, StringRef val) {
    ASSERT_STREQ(golden, val);
  }
  
  protected static boolean isLinux() {
    Triple hostTriple = getHostTriple();
    return hostTriple.getOS() == Triple.OSType.Linux;
  }
  
  protected static boolean isSolaris() {
    Triple hostTriple = getHostTriple();
    return hostTriple.getOS() == Triple.OSType.Solaris;
  }

  protected static Triple getHostTriple() {
    Triple HostTriple/*J*/= new Triple(new Twine(/*KEEP_STR*/LLVM_HOST_TRIPLE()));    
    return HostTriple; 
  }

  @BeforeClass
  public static void startUpClass() {
    // initialize options
    GlobalParser.$arrow();
  }
  
  @Override
  public void tearDown() {
    try {
      // call these clean ups always, becuase it clears managed statics possibly initialized
      // by running skipped tests
      llvm.remove_fatal_error_handler();
      llvm.llvm_shutdown();
    } catch (Throwable ex) {
      NativeTrace.printStackTraceOnce(ex);
    }
    super.tearDown();
  }
    
  public /*inline*/ void $destroy() {
    
  }  
}
