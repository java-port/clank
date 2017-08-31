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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;

/*
$SPUTNIK/contrib/JConvert/jclank.sh -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType $LLVM_SRC/llvm/unittests/ADT/ilistTest.cpp   -test=IlistTest > /home/vkvashin/src/sputnik~jclank/modules/org.llvm.adtsupport/test/unit/src/org/llvm/adt/IlistTest.java
*/

//<editor-fold defaultstate="collapsed" desc="static type IlistTest">
@Converted(kind = Converted.Kind.AUTO,
 NM="IlistTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -test=IlistTest")
//</editor-fold>

public final class IlistTest extends ADTSupportTestBase {

//JAVA: using namespace llvm
//JAVA: namespace (anonymous) {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Node">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 20,
 FQN="(anonymous namespace)::Node", NM="_ZN12_GLOBAL__N_14NodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_14NodeE")
//</editor-fold>
public static class/*struct*/ Node implements ilist_node<Node>, Destructors.ClassWithDestructor {
  public int Value;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Node::Node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 23,
   FQN="(anonymous namespace)::Node::Node", NM="_ZN12_GLOBAL__N_14NodeC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_14NodeC1Ev")
  //</editor-fold>
  public Node() {
    // : ilist_node<Node>() 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this.ilist_half_node$Fields = $ilist_half_node();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Node::Node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 24,
   FQN="(anonymous namespace)::Node::Node", NM="_ZN12_GLOBAL__N_14NodeC1Ei",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_14NodeC1Ei")
  //</editor-fold>
  public Node(int Value) {
    // : ilist_node<Node>(), Value(Value) 
    //START JInit
    this.ilist_node$Flds = $ilist_node();
    this.ilist_half_node$Fields = $ilist_half_node();
    this.Value = Value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Node::Node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 25,
   FQN="(anonymous namespace)::Node::Node", NM="_ZN12_GLOBAL__N_14NodeC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_14NodeC1ERKS0_")
  //</editor-fold>
  public Node(final /*const*/ Node /*&*/ $Prm0) {
    // : ilist_node<Node>(), Value(.Value)/* = default*/ 
    //START JInit
    this.ilist_node$Flds = $ilist_node($Prm0);
    this.ilist_half_node$Fields = $ilist_half_node();
    this.Value = $Prm0.Value;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::Node::~Node">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 26,
   FQN="(anonymous namespace)::Node::~Node", NM="_ZN12_GLOBAL__N_14NodeD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_14NodeD0Ev")
  //</editor-fold>
  public void $destroy() {
    Value = -1;
    ilist_node.super.$destroy$ilist_node();
  }

  
  private final ilist_node$Fields ilist_node$Flds;// use return value of $ilist_node();
  @Override public final ilist_node$Fields $ilist_node$Fields() { return ilist_node$Flds; }
  
  private final ilist_half_node$Fields ilist_half_node$Fields;
  public ilist_half_node$Fields<Node> $ilist_half_node$Fields() {
    return ilist_half_node$Fields;
  }
//  public void init$ilist_half_node$Fields(ilist_half_node$Fields<Node> fields) { 
//    ilist_half_node$Fields = fields;
//  }       
          
  
  @Override public String toString() {
    return "" + "Value=" + Value // NOI18N
              + super.toString(); // NOI18N
  }
}
;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ilistTest_Basic_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 29,
 FQN="(anonymous namespace)::ilistTest_Basic_Test::TestBody", NM="_ZN12_GLOBAL__N_120ilistTest_Basic_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_120ilistTest_Basic_Test8TestBodyEv")
//</editor-fold>
@Test public void test_Basic() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   ilist<Node> List = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    List/*J*/= new ilist_Node();
    List.push_back($c$.track(new Node(1))); //$c$.clean();
    EXPECT_EQ(1,List.back().Value);
    EXPECT_EQ(null,List.getPrevNode_T$R(List.back()));
    EXPECT_EQ(null,List.getNextNode_T$R(List.back()));
    
    List.push_back($c$.track(new Node(2))); //$c$.clean();
    EXPECT_EQ(2,List.back().Value);
    EXPECT_EQ(2,List.getNextNode_T$R(List.front()).Value);
    EXPECT_EQ(1,List.getPrevNode_T$R(List.back()).Value);
    
    final /*const*/ ilist<Node> /*&*/ ConstList = List;
    EXPECT_EQ(2,ConstList.back$Const().Value);
    EXPECT_EQ(2,ConstList.getNextNode_T$C$R(ConstList.front$Const()).Value);
    EXPECT_EQ(1,ConstList.getPrevNode_T$C$R(ConstList.back$Const()).Value);
  } finally {
    $c$.clean();
    if (List != null) { List.$destroy(); }
    $c$.$destroy();
  }
}

;
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ilistTest_SpliceOne_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 47,
 FQN="(anonymous namespace)::ilistTest_SpliceOne_Test::TestBody", NM="_ZN12_GLOBAL__N_124ilistTest_SpliceOne_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_124ilistTest_SpliceOne_Test8TestBodyEv")
//</editor-fold>
@Test public void test_SpliceOne() {
  if (markAsSkippedIfNeed(TestState.Failed)) { return; }
   ilist<Node> List = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    List/*J*/= new ilist_Node();
    List.push_back($c$.track(new Node(1))); $c$.clean();
    
    // The single-element splice operation supports noops.
    List.splice(List.begin(), List, List.begin());
    EXPECT_EQ(1/*U*/,List.size());
    EXPECT_EQ(1,List.front().Value);
    EXPECT_TRUE(std.next(List.begin()).$eq(List.end()));
    
    // Altenative noop. Move the first element behind itself.
    List.push_back($c$.track(new Node(2))); $c$.clean();
    List.push_back($c$.track(new Node(3))); $c$.clean();
    List.splice(std.next(List.begin()), List, List.begin());
    EXPECT_EQ(3/*U*/,List.size());
    EXPECT_EQ(1,List.front().Value);
    EXPECT_EQ(2,std.next(List.begin()).$arrow().Value);
    EXPECT_EQ(3,List.back().Value);
  } finally {
    if (List != null) { List.$destroy(); }
    $c$.$destroy();
  }
}

@Converted(kind = Converted.Kind.MANUAL) 
@Test public void test_Sub() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ilist<Node> l1, l2;
  ilist_iterator<Node> i1, i2;
  
  // no intersection => Integer.MAX_VALUE
  l1 = new ilist_Node();
  i1 = l1.begin();
  l2 = new ilist_Node();
  i2 = l2.begin();
  ASSERT_EQ(Integer.MAX_VALUE, i1.$sub(i2));
  
  // equal => 0
  ASSERT_EQ(0, i1.$sub(i1));
  ASSERT_EQ(0, l1.begin().$sub(l1.begin()));
  ASSERT_EQ(0, l1.end().$sub(l1.end()));
  i1 = l1.begin();
  i2 = l1.end();
  ASSERT_EQ(0, i2.$sub(i1));

  // 3 elements => distance == 3
  l1.push_back(new Node(1));
  l1.push_back(new Node(2));
  l1.push_back(new Node(3));
  i1 = l1.begin();
  i2 = l1.end();
  ASSERT_EQ(3, i2.$sub(i1));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ilistTest_UnsafeClear_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp", line = 67,
 FQN="(anonymous namespace)::ilistTest_UnsafeClear_Test::TestBody", NM="_ZN12_GLOBAL__N_126ilistTest_UnsafeClear_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ilistTest.cpp -nm=_ZN12_GLOBAL__N_126ilistTest_UnsafeClear_Test8TestBodyEv")
//</editor-fold>
@Test public void test_UnsafeClear() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
   ilist<Node> List = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    List/*J*/= new ilist_Node();
    
    // Before even allocating a sentinel.
    List.clearAndLeakNodesUnsafely();
    EXPECT_EQ(0/*U*/,List.size());
    
    // Empty list with sentinel.
    ilist_iterator<Node> E = List.end();
    List.clearAndLeakNodesUnsafely();
    EXPECT_EQ(0/*U*/,List.size());
    // The sentinel shouldn't change.
    EXPECT_TRUE(E.$eq(List.end()));
    
    // List with contents.
    List.push_back($c$.track(new Node(1))); $c$.clean();
    EXPECT_EQ(1/*U*/,List.size());
    Node /*P*/ N = $AddrOf(List.begin().$star());
    EXPECT_EQ(1,N.Value);
    List.clearAndLeakNodesUnsafely();
    EXPECT_EQ(0/*U*/,List.size());
    EXPECT_EQ(1,N.Value);
    if (N != null) { N.$destroy();};
    
    // List is still functional.
    List.push_back($c$.track(new Node(5))); $c$.clean();
    List.push_back($c$.track(new Node(6))); $c$.clean();
    EXPECT_EQ(2/*U*/,List.size());
    EXPECT_EQ(5,List.front().Value);
    EXPECT_EQ(6,List.back().Value);
  } finally {
    if (List != null) { List.$destroy(); }
    $c$.$destroy();
  }
}

private static class ilist_Node extends ilist<Node> {
  @Override
  protected ilist_traits<Node> $createTraits() {
    return new ilist_traitsNode();
  }
}

private static class ilist_traitsNode implements ilist_traits<Node> {

    @Override
    public Node createNode(Node V) {
      return new Node(V);
    }    
    
    @Override
    public Node createSentinel() {
      return new Node();
    }
    @Override
    public Node ensureHead(type$ref<Node> Head) {
      if (Head.$deref() == null) {
        Head.$set(createSentinel());
        noteHead(Head.$deref(), Head.$deref());
        setNext(Head.$deref(), null);
        return Head.$deref();
      }
      return getPrev(Head.$deref());
    }
  }

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class IlistTest
