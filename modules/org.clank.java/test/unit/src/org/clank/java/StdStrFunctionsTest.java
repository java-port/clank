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


package org.clank.java;

import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.junit.Test;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class StdStrFunctionsTest extends JavaTestBase {
  
  @Test
  public void testStrtod() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    char$ptr testStr = $("365.24 29.53 -1.07 6.6777764E7");
    char$ptr pEnd = create_char$ptr("");
    double d1, d2, d3, d4;
    d1 = std.strtod(testStr, pEnd.$addr());
    d2 = std.strtod(pEnd, pEnd.$addr());
    d3 = std.strtod(pEnd, pEnd.$addr());
    d4 = std.strtod(pEnd, null);
    EXPECT_EQ(365.24, d1);
    EXPECT_EQ(29.53, d2);
    EXPECT_EQ(-1.07, d3);
    EXPECT_EQ(6.6777764E7, d4);
  }  
  
  @Test
  public void testStrtoul() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    char$ptr testStr = $("777 29 FF -0xA0");
    char$ptr pEnd = create_char$ptr("");
    long l1, l2, l3, l4;
    l1 = std.strtoul(testStr, pEnd.$addr(), 8);
    l2 = std.strtoul(pEnd, pEnd.$addr(), 10);
    l3 = std.strtoul(pEnd, pEnd.$addr(), 16);
    l4 = std.strtoul(pEnd, null, 0);
    EXPECT_EQ(511l, l1);
    EXPECT_EQ(29l, l2);
    EXPECT_EQ(255l, l3);
    EXPECT_EQ(-160l, l4);
  }    
}
