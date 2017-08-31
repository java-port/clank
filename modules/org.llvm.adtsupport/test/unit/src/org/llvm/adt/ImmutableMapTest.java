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

import org.clank.java.std;
import org.junit.Test;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.llvm.adt.aliases.*;


//<editor-fold defaultstate="collapsed" desc="static type ImmutableMapTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableMapTest.cpp -test=ImmutableMapTest")
//</editor-fold>
public final class ImmutableMapTest extends ADTSupportTestBase {
  
  private static class TestImutContainerInfoInteger extends ImutContainerInfo<Integer> {

    public TestImutContainerInfoInteger() {
      super(new DefaultFoldingSetTraitUInt());
    }

    @Override
    public void Profile(FoldingSetNodeID ID, Integer X) {
      ID.AddInteger_int(X.intValue());
    }
  }
  
  private static ImutKeyValueInfo<Integer, Integer, std.pairTypeType<Integer, Integer>> createIntIntInfo() {
    return new ImutKeyValueInfo<Integer, Integer, std.pairTypeType<Integer, Integer>>(
            new TestImutContainerInfoInteger(), 
            new TestImutContainerInfoInteger()
    );
  }

//JAVA: using namespace llvm
//JAVA: namespace (anonymous) {
;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableMapTest_EmptyIntMapTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableMapTest.cpp", line = 17,
 FQN="(anonymous namespace)::ImmutableMapTest_EmptyIntMapTest_Test::TestBody", NM="_ZN12_GLOBAL__N_137ImmutableMapTest_EmptyIntMapTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableMapTest.cpp -nm=_ZN12_GLOBAL__N_137ImmutableMapTest_EmptyIntMapTest_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyIntMapTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableMap.Factory<Integer, Integer> f = null;
  ImmutableMap<Integer, Integer> S = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableMap.Factory<Integer, Integer>(createIntIntInfo());
    EXPECT_TRUE(f.getEmptyMap().$eq(f.getEmptyMap()));
    EXPECT_FALSE(f.getEmptyMap().$noteq(f.getEmptyMap()));
    EXPECT_TRUE(f.getEmptyMap().isEmpty());

    S = f.getEmptyMap();
    EXPECT_EQ(0, S.getHeight());
    EXPECT_TRUE(S.begin().$eq(S.end()));
    EXPECT_FALSE(S.begin().$noteq(S.end()));
  } finally {
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableMapTest_MultiElemIntMapTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableMapTest.cpp", line = 30,
 FQN="(anonymous namespace)::ImmutableMapTest_MultiElemIntMapTest_Test::TestBody", NM="_ZN12_GLOBAL__N_141ImmutableMapTest_MultiElemIntMapTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableMapTest.cpp -nm=_ZN12_GLOBAL__N_141ImmutableMapTest_MultiElemIntMapTest_Test8TestBodyEv")
//</editor-fold>
@Test public void test_MultiElemIntMapTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableMap.Factory<Integer, Integer> f = null;
  ImmutableMap<Integer, Integer> S = null;
  ImmutableMap<Integer, Integer> S2 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableMap.Factory<Integer, Integer>(createIntIntInfo());
    S = f.getEmptyMap();
    
    S2 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableMap<Integer, Integer>(S)), 3, 10)), 4, 11)), 5, 12));
    
    EXPECT_TRUE(S.isEmpty());
    EXPECT_FALSE(S2.isEmpty());

    EXPECT_EQ(null, S.lookup(3));
    EXPECT_EQ(null, S.lookup(9));

    EXPECT_EQ(10, S2.lookup(3).$star());
    EXPECT_EQ(11, S2.lookup(4).$star());
    EXPECT_EQ(12, S2.lookup(5).$star());

    EXPECT_EQ(5, S2.getMaxElement().first);
    EXPECT_EQ(3, S2.getHeight());
  } finally {
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class ImmutableMapTest
