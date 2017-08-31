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

import org.junit.Test;

/**
 *
 * @author petrk
 */
public class PackedVectorTest extends ADTSupportTestBase {
  
  @Test
  public void OperationTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    PackedVector Vec = new PackedVector(2, false/*unsigned*/, new BitVector());
    EXPECT_EQ(0, Vec.size());
    EXPECT_TRUE(Vec.empty());

    Vec.resize(5);
    EXPECT_EQ(5, Vec.size());
    EXPECT_FALSE(Vec.empty());

    Vec.resize(11);
    EXPECT_EQ(11, Vec.size());
    EXPECT_FALSE(Vec.empty());

    PackedVector Vec2 = new PackedVector(2, false/*unsigned*/, new BitVector(), 3);
    EXPECT_EQ(3, Vec2.size());
    EXPECT_FALSE(Vec2.empty());

    Vec.clear();
    EXPECT_EQ(0, Vec.size());
    EXPECT_TRUE(Vec.empty());

    Vec.push_back(2);
    Vec.push_back(0);
    Vec.push_back(1);
    Vec.push_back(3);

    EXPECT_EQ(2, Vec.$at$Const(0));
    EXPECT_EQ(0, Vec.$at$Const(1));
    EXPECT_EQ(1, Vec.$at$Const(2));
    EXPECT_EQ(3, Vec.$at$Const(3));

    EXPECT_FALSE(Vec.$eq(Vec2));
    EXPECT_TRUE(Vec.$noteq(Vec2));

    Vec.$assign(Vec2);
    EXPECT_TRUE(Vec.$eq(Vec2));
    EXPECT_FALSE(Vec.$noteq(Vec2));

    Vec.$at(1).$assign(1);
    Vec2.$at(1).$assign(2);
    Vec.$orassign(Vec2);
    EXPECT_EQ(3, Vec.$at$Const(1));
  }
}
