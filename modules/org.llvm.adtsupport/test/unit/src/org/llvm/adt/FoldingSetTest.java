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
import java.util.ArrayList;
import java.util.List;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author petrk
 */
public class FoldingSetTest extends ADTSupportTestBase {
  
  private static class TestNode extends FoldingSetImpl.NodeImpl implements FoldingSetImpl.Node, NativeComparable<TestNode>{
    
    private final int first;
    
    private final int second;
    
    private boolean visited;

    public TestNode(int first, int second) {
      this.first = first;
      this.second = second;
    }

    @Override
    public void Profile(FoldingSetNodeID ID) {
      ID.AddInteger_int(first);
      ID.AddInteger_int(second);
    }

    @Override
    public boolean $eq(TestNode other) {
      return first == other.first && second == other.second;
    }

    public boolean isVisited() {
      return visited;
    }

    public void setVisited(boolean visited) {
      this.visited = visited;
    }
  }
  
  private FoldingSet<TestNode> Set;
  
  @Before
  public void before() {
    Set = new FoldingSet<>(new DefaultFoldingSetTrait<>());
  }
  
  @Test
  public void EmptySetTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    // Size tests
    EXPECT_EQ(0, this.Set.size());
    EXPECT_TRUE(this.Set.empty());

    // Iterator tests
    EXPECT_TRUE(this.Set.begin().$eq(this.Set.end()));

    // Lookup tests
    TestNode node = new TestNode(0, 1);
    FoldingSetNodeID nodeID = new FoldingSetNodeID();
    node.Profile(nodeID);
    type$ref InsertPos = create_type$ref(null);
    EXPECT_TRUE(this.Set.FindNodeOrInsertPos(nodeID, InsertPos) == null);
    EXPECT_FALSE(InsertPos.$deref() == null);
  }

  // A set with a single entry
  @Test
  public void SingleEntrySetTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    TestNode node = new TestNode(0, 1);
    ASSERT_TRUE(this.Set.GetOrInsertNode(node) == node);
    
    // Size tests
    EXPECT_EQ(this.Set.size(), 1);
    EXPECT_FALSE(this.Set.begin().$eq(this.Set.end()));
    EXPECT_FALSE(this.Set.empty());

    // Iterator tests    
    FoldingSetIterator<TestNode> it = this.Set.begin();
    EXPECT_EQ(it.$star(), node);
    it.$preInc();
    EXPECT_TRUE(it.$eq(this.Set.end()));    

    // Lookup tests
    type$ref InsertPos = create_type$ref(null);
    FoldingSetNodeID nodeID = new FoldingSetNodeID();
    node.Profile(nodeID);
    EXPECT_EQ(this.Set.FindNodeOrInsertPos(nodeID, InsertPos), node);
    EXPECT_TRUE(InsertPos.$deref() == null);
  }  
  
  // Test clear() method
  @Test
  public void ClearTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    TestNode node = new TestNode(0, 1);
    ASSERT_TRUE(this.Set.GetOrInsertNode(node) == node);
    this.Set.clear();

    EXPECT_EQ(0, this.Set.size());
    EXPECT_TRUE(this.Set.empty());
    EXPECT_TRUE(this.Set.begin().$eq(this.Set.end()));
  }    
  
  // A more complex iteration test
  @Test
  public void IterationTest() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    List<TestNode> nodes = new ArrayList<>();
    for (int i = 0; i < 100; ++i) {
      TestNode node = new TestNode(i % 10, i);
      ASSERT_TRUE(this.Set.GetOrInsertNode(node) == node);
      nodes.add(node);
    }
    
    // Iterate over all numbers and mark each one found.
    for (FoldingSetIterator<TestNode> it = this.Set.begin();
         it.$noteq(this.Set.end()); it.$preInc()) {
      it.$star().setVisited(true);
    }
    
    // Check that all nodes are visited
    for (TestNode node : nodes) {
      ASSERT_TRUE(node.isVisited(), "Entry (" + node.first + ", " + node.second + ")" + " was never visited");
    }
  }
}
