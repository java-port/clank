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

import org.clank.java.*;
import org.clank.support.aliases.type$iterator;
import org.junit.Assert;
import org.junit.Test;
/**
 *
 * @author vkvashin
 */
public class MultiMapTest extends JavaTestBase {

  @Test
  public void testMultiMapUIntSimple() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.multimapUIntType<String> map;
    map = new std.multimapUIntType<>("");
    map.insert(new std_pair.pairUIntType<>(0, "zero"));
    map.insert(new std_pair.pairUIntType<>(1, "one"));
    map.insert(new std_pair.pairUIntType<>(1, "uno"));
    map.insert(new std_pair.pairUIntType<>(2, "two"));
    map.insert(new std_pair.pairUIntType<>(2, "due"));
    map.insert(new std_pair.pairUIntType<>(2, "dos"));
    Assert.assertEquals("count", 1, map.count(0));
    Assert.assertEquals("count", 2, map.count(1));
    Assert.assertEquals("count", 3, map.count(2));
    Assert.assertEquals("count", 0, map.count(3));
  }
  
  @Test
  public void testMultiMap_equal_range() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    std.multimapUIntType<String> map;
    map = new std.multimapUIntType<>("");
    map.insert(new std_pair.pairUIntType<>(0, "zero"));
    map.insert(new std_pair.pairUIntType<>(1, "one"));
    map.insert(new std_pair.pairUIntType<>(1, "uno"));
    map.insert(new std_pair.pairUIntType<>(2, "two"));
    map.insert(new std_pair.pairUIntType<>(2, "due"));
    map.insert(new std_pair.pairUIntType<>(2, "dos"));
    //std_pair.pair<type$iterator<?, std_pair.pairUIntType<String>>, type$iterator<?, std_pair.pairUIntType<String>>> equal_range = map.equal_range(0);
    Assert.assertEquals("count", 1, count(map.equal_range(0)));
    Assert.assertEquals("count", 2, count(map.equal_range(1)));
    Assert.assertEquals("count", 3, count(map.equal_range(2)));
    Assert.assertEquals("count", 0, count(map.equal_range(3)));
  }
  
  private int count(std_pair.pair<type$iterator<?, std_pair.pairUIntType<String>>, type$iterator<?, std_pair.pairUIntType<String>>> range) {
    int count = 0;
    for(type$iterator<?, std_pair.pairUIntType<String>> I = range.first, E = range.second; I.$noteq(E); I.$postInc()) {
      count++;
    }
    return count;
  }
  
}
