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

package org.clang.ast;

import org.junit.Test;
import org.llvm.adt.aliases.SmallVectorImpl;
import static org.clang.ast.java.AstMemberPointers.*;
import org.clank.java.std;
import org.clank.support.aliases.type$iterator;
import static org.junit.Assert.*;
import org.llvm.adt.ADTSupportTestBase;

/**
 *
 * @author vkvashin
 */
public class LazyVectorTest extends ADTSupportTestBase {
  
  public static class ExtSource {
    private final String[] toLoad;
    public ExtSource(String... toLoad) {
      this.toLoad = toLoad;
    }
    public static final Source$SmallVector2Void<ExtSource, String> Loader = ExtSource::load;
    private static void load(ExtSource instance, SmallVectorImpl<String> v) {
      v.clear();
      for (int i = 0; i < instance.toLoad.length; i++) {
        v.append(1, instance.toLoad[i]);
      }
    }
  }

  @Test
  public void testLoad() throws Exception {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    LazyVector<String, ExtSource> vec = new LazyVector<>(ExtSource.Loader, 10, 10);
    final String[] loadData = new String[] { "1", "2", "3" };
    ExtSource extSource = new ExtSource(loadData);
    LazyVector.iterator<String, ExtSource> beg, end;

    for (int i = 0; i < 2; i++) {
      beg = vec.begin(extSource);
      end = vec.end();
      int cnt = 0;
      while (beg.$less(end)) {
        String s = beg.$star();
        cnt++;
        beg.$postInc();
      }
      assertEquals("Amount of elements", 3, cnt);
    }
    
    beg = vec.begin(extSource);
    end = vec.end();
    int idx = 0;
    while(beg.$less(end)) {
      String s = beg.$star();
      assertEquals(loadData[idx++], s);
      beg.$postInc();
    }
  }
  
  @Test
  public void testPush() throws Exception {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    LazyVector<String, ExtSource> vec = new LazyVector<>(ExtSource.Loader, 10, 10);
    ExtSource extSource = new ExtSource(new String[0]);
    final String[] pushData = new String[] { "a", "b", "c" };
    push(vec, pushData);
    assertEquals("count after push", pushData.length, count(vec, extSource));
    LazyVector.iterator<String, ExtSource> beg, end;
    beg = vec.begin(extSource);
    end = vec.end();
    int idx = 0;
    while(beg.$less(end)) {
      String s = beg.$star();
      assertEquals(pushData[idx++], s);
      beg.$postInc();
    }
  }
  
  @Test
  public void testFindIf() throws Exception {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    LazyVector<String, ExtSource> vec = new LazyVector<>(ExtSource.Loader, 10, 10);
    ExtSource extSource = new ExtSource(new String[0]);
    final String[] pushData = new String[] { "a", "b", "c" };
    push(vec, pushData);
    assertEquals("count after push", pushData.length, count(vec, extSource));
    LazyVector.iterator<String, ExtSource> beg, end;
    beg = vec.begin(extSource);
    end = vec.end();
    int idx = 0;
    while(beg.$less(end)) {
      String s = beg.$star();
      assertEquals(pushData[idx++], s);
      beg.$postInc();
    }
    beg = vec.begin(extSource);
    end = vec.end();
    type$iterator<?, String> found = std.find_if(beg, end, (String s) -> { return s.equals("b"); });
    assertNotNull("*found", found.$star());
    assertEquals("*found", "b", found.$star());
  }
  
  @Test
  public void testEraseLoaded() throws Exception {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    LazyVector<String, ExtSource> vec = new LazyVector<>(ExtSource.Loader, 10, 10);
    final String[] loadData = new String[] { "1", "2", "3" };
    ExtSource extSource = new ExtSource(loadData);
    LazyVector.iterator<String, ExtSource> beg, end;
    beg = vec.begin(extSource);
    end = vec.end();
    vec.erase(beg, end);
    assertEquals("count after erasure", 0, count(vec, new ExtSource(new String[0])));
  }
  
  @Test
  public void testEraseAdded() throws Exception {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    LazyVector<String, ExtSource> vec = new LazyVector<>(ExtSource.Loader, 10, 10);
    ExtSource extSource = new ExtSource(new String[0]);
    LazyVector.iterator<String, ExtSource> beg, end;
    final String[] pushData = new String[] { "a", "b", "c" };
    push(vec, pushData);
    assertEquals("count push erasure", pushData.length, count(vec, extSource));
    beg = vec.begin(extSource);
    end = vec.end();
    vec.erase(beg, end);
    assertEquals("count after erasure", 0, count(vec, extSource));
  }
  
  private static void push(LazyVector<String, ExtSource> vec, String ... toPush) {
    for (String s : toPush) {
      vec.push_back(s);
    }
  }
  
  private static int count(LazyVector<String, ExtSource> vec, ExtSource extSource) {
    LazyVector.iterator<String, ExtSource> beg = vec.begin(extSource);
    LazyVector.iterator<String, ExtSource> end = vec.end();
    int cnt = 0;
    while (beg.$less(end)) {
      cnt++;
      beg.$postInc();
    }
    return cnt;
  }  
}
