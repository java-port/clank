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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//<editor-fold defaultstate="collapsed" desc="static type ImmutableSetTest">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -test=ImmutableSetTest")
//</editor-fold>
public final class ImmutableSetTest extends ADTSupportTestBase {

//JAVA: using namespace llvm
//JAVA: namespace (anonymous) {
////<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 16,
// FQN="(anonymous namespace)::ImmutableSetTest", NM="_ZN12_GLOBAL__N_116ImmutableSetTestE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_116ImmutableSetTestE")
////</editor-fold>
//public abstract static class ImmutableSetTest extends /*public*/ Test implements Destructors.ClassWithDestructor {
/*protected:*/
  // for callback tests
  protected static /*char*/byte buffer[/*10*/] = new$char(10);
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest::MyIter">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 21,
   FQN="(anonymous namespace)::ImmutableSetTest::MyIter", NM="_ZN12_GLOBAL__N_116ImmutableSetTest6MyIterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_116ImmutableSetTest6MyIterE")
  //</editor-fold>
  protected static class/*struct*/ MyIter implements Char2Void {
    public int counter;
    public char$ptr/*char P*/ ptr;
    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest::MyIter::MyIter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 25,
     FQN="(anonymous namespace)::ImmutableSetTest::MyIter::MyIter", NM="_ZN12_GLOBAL__N_116ImmutableSetTest6MyIterC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_116ImmutableSetTest6MyIterC1Ev")
    //</editor-fold>
    public MyIter() {
      // : counter(0), ptr(buffer) 
      //START JInit
      this.counter = 0;
      this.ptr = create_char$ptr(buffer);
      //END JInit
      for (/*uint*/int i = 0; $less_uint(i, sizeof(buffer)); ++i)  {
        buffer[i] = $$TERM;
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest::MyIter::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 28,
     FQN="(anonymous namespace)::ImmutableSetTest::MyIter::operator()", NM="_ZN12_GLOBAL__N_116ImmutableSetTest6MyIterclEc",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_116ImmutableSetTest6MyIterclEc")
    //</editor-fold>
    public void $call(/*char*/byte c) {
      ptr.$postInc().$set(c);
      ++counter;
    }

    
    @Override public String toString() {
      return "" + "counter=" + counter // NOI18N
                + ", ptr=" + ptr; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest::~ImmutableSetTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 16,
   FQN="(anonymous namespace)::ImmutableSetTest::~ImmutableSetTest", NM="_ZN12_GLOBAL__N_116ImmutableSetTestD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_116ImmutableSetTestD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest::ImmutableSetTest">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 16,
   FQN="(anonymous namespace)::ImmutableSetTest::ImmutableSetTest", NM="_ZN12_GLOBAL__N_116ImmutableSetTestC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_116ImmutableSetTestC1Ev")
  //</editor-fold>
  public /*inline*/ ImmutableSetTest() {
    // : Test() 
    //START JInit
    super();
    //END JInit
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
//}
//;
//;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_EmptyIntSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 37,
 FQN="(anonymous namespace)::ImmutableSetTest_EmptyIntSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_137ImmutableSetTest_EmptyIntSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_137ImmutableSetTest_EmptyIntSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_EmptyIntSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetInt.Factory f = null;
  ImmutableSetInt S = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetInt.Factory(ImutContainerInfoInt.INFO);
    EXPECT_TRUE(f.getEmptySet().$eq(f.getEmptySet()));
    EXPECT_FALSE(f.getEmptySet().$noteq(f.getEmptySet()));
    EXPECT_TRUE(f.getEmptySet().isEmpty());

    S = f.getEmptySet();
    EXPECT_EQ(0, S.getHeight());
    EXPECT_TRUE(S.begin().$eq(S.end()));
    EXPECT_FALSE(S.begin().$noteq(S.end()));
  } finally {
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_OneElemIntSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 51,
 FQN="(anonymous namespace)::ImmutableSetTest_OneElemIntSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_139ImmutableSetTest_OneElemIntSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_139ImmutableSetTest_OneElemIntSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_OneElemIntSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetInt.Factory f = null;
  ImmutableSetInt S = null;
  ImmutableSetInt S2 = null;
  ImmutableSetInt S3 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetInt.Factory(ImutContainerInfoInt.INFO);
    S = f.getEmptySet();
    int distance = std.distance(S.begin(), S.end());
    EXPECT_EQ(0, distance);
    
    S2 = $c$.clean(f.add($c$.track(new ImmutableSetInt(S)), 3));
    int distance2 = std.distance(S2.begin(), S2.end());
    EXPECT_EQ(1, distance2);
    EXPECT_TRUE(S.isEmpty());
    EXPECT_FALSE(S2.isEmpty());
    EXPECT_FALSE(S.$eq(S2));
    EXPECT_TRUE(S.$noteq(S2));
    EXPECT_FALSE(S.contains(3));
    EXPECT_TRUE(S2.contains(3));
    EXPECT_FALSE(S2.begin().$eq(S2.end()));
    EXPECT_TRUE(S2.begin().$noteq(S2.end()));
    
    S3 = $c$.clean(f.add($c$.track(new ImmutableSetInt(S)), 2));
    int distance3 = std.distance(S3.begin(), S3.end());
    EXPECT_EQ(1, distance3);
    EXPECT_TRUE(S.isEmpty());
    EXPECT_FALSE(S3.isEmpty());
    EXPECT_FALSE(S.$eq(S3));
    EXPECT_TRUE(S.$noteq(S3));
    EXPECT_FALSE(S.contains(2));
    EXPECT_TRUE(S3.contains(2));

    EXPECT_FALSE(S2.$eq(S3));
    EXPECT_TRUE(S2.$noteq(S3));
    EXPECT_FALSE(S2.contains(2));
    EXPECT_FALSE(S3.contains(3));
  } finally {
    if (S3 != null) { S3.$destroy(); }
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_MultiElemIntSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 79,
 FQN="(anonymous namespace)::ImmutableSetTest_MultiElemIntSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_141ImmutableSetTest_MultiElemIntSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_141ImmutableSetTest_MultiElemIntSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_MultiElemIntSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetInt.Factory f = null;
  ImmutableSetInt S = null;
  ImmutableSetInt S2 = null;
  ImmutableSetInt S3 = null;
  ImmutableSetInt S4 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetInt.Factory(ImutContainerInfoInt.INFO);
    S = f.getEmptySet();
    
    S2 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetInt(S)), 3)), 4)), 5));
    S3 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetInt(S2)), 9)), 20)), 43));
    S4 = $c$.clean(f.add($c$.track(new ImmutableSetInt(S2)), 9));
    // check iterators
    ImutAVLValueIteratorIntBoolInt begin = S4.begin();
    ImutAVLValueIteratorIntBoolInt end = S4.end();
    int distance4 = std.distance(begin, end);
    EXPECT_EQ(4, distance4);   
    distance4 = std.distance(begin, end);
    EXPECT_EQ(4, distance4); 
    distance4 = 0;
    while (begin.$noteq(end)) {
      distance4++;
      begin.$preInc();
    }
    EXPECT_EQ(4, distance4); 
    
    EXPECT_TRUE(S.isEmpty());
    EXPECT_FALSE(S2.isEmpty());
    EXPECT_FALSE(S3.isEmpty());
    EXPECT_FALSE(S4.isEmpty());

    EXPECT_FALSE(S.contains(3));
    EXPECT_FALSE(S.contains(9));

    EXPECT_TRUE(S2.contains(3));
    EXPECT_TRUE(S2.contains(4));
    EXPECT_TRUE(S2.contains(5));
    EXPECT_FALSE(S2.contains(9));
    EXPECT_FALSE(S2.contains(0));

    EXPECT_TRUE(S3.contains(43));
    EXPECT_TRUE(S3.contains(20));
    EXPECT_TRUE(S3.contains(9));
    EXPECT_TRUE(S3.contains(3));
    EXPECT_TRUE(S3.contains(4));
    EXPECT_TRUE(S3.contains(5));
    EXPECT_FALSE(S3.contains(0));

    EXPECT_TRUE(S4.contains(9));
    EXPECT_TRUE(S4.contains(3));
    EXPECT_TRUE(S4.contains(4));
    EXPECT_TRUE(S4.contains(5));
    EXPECT_FALSE(S4.contains(20));
    EXPECT_FALSE(S4.contains(43));
  } finally {
    if (S4 != null) { S4.$destroy(); }
    if (S3 != null) { S3.$destroy(); }
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_RemoveIntSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 117,
 FQN="(anonymous namespace)::ImmutableSetTest_RemoveIntSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_138ImmutableSetTest_RemoveIntSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_138ImmutableSetTest_RemoveIntSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_RemoveIntSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetInt.Factory f = null;
  ImmutableSetInt S = null;
  ImmutableSetInt S2 = null;
  ImmutableSetInt S3 = null;
  ImmutableSetInt S4 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetInt.Factory(ImutContainerInfoInt.INFO);
    S = f.getEmptySet();
    
    S2 = $c$.clean(f.add($c$.track(f.add($c$.track(new ImmutableSetInt(S)), 4)), 5));
    S3 = $c$.clean(f.add($c$.track(new ImmutableSetInt(S2)), 3));
    S4 = $c$.clean(f.remove($c$.track(new ImmutableSetInt(S3)), 3));

    EXPECT_TRUE(S3.contains(3));
    EXPECT_FALSE(S2.contains(3));
    EXPECT_FALSE(S4.contains(3));

    EXPECT_TRUE(S2.$eq(S4));
    EXPECT_TRUE(S3.$noteq(S2));
    EXPECT_TRUE(S3.$noteq(S4));

    EXPECT_TRUE(S3.contains(4));
    EXPECT_TRUE(S3.contains(5));

    EXPECT_TRUE(S4.contains(4));
    EXPECT_TRUE(S4.contains(5));
  } finally {
    if (S4 != null) { S4.$destroy(); }
    if (S3 != null) { S3.$destroy(); }
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_CallbackCharSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 140,
 FQN="(anonymous namespace)::ImmutableSetTest_CallbackCharSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_141ImmutableSetTest_CallbackCharSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_141ImmutableSetTest_CallbackCharSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_CallbackCharSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetChar.Factory f = null;
  ImmutableSetChar S = null;
  ImmutableSetChar S2 = null;
  ImmutableSetChar S3 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetChar.Factory(ImutContainerInfoChar.INFO);
    S = f.getEmptySet();
    
    S2 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetChar(S)), $$a)), $$e)), $$i));
    S3 = $c$.clean(f.add($c$.track(f.add($c$.track(new ImmutableSetChar(S2)), $$o)), $$u));
    
    S3.foreach(new ImmutableSetTest.MyIter());
    ASSERT_STREQ("aeiou", create_char$ptr(buffer));
  } finally {
    if (S3 != null) { S3.$destroy(); }
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_Callback2CharSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 152,
 FQN="(anonymous namespace)::ImmutableSetTest_Callback2CharSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_142ImmutableSetTest_Callback2CharSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_142ImmutableSetTest_Callback2CharSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_Callback2CharSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetChar.Factory f = null;
  ImmutableSetChar S = null;
  ImmutableSetChar S2 = null;
  ImmutableSetChar S3 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetChar.Factory(ImutContainerInfoChar.INFO);
    S = f.getEmptySet();
    
    S2 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetChar(S)), $$b)), $$c)), $$d));
    S3 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetChar(S2)), $$f)), $$g)), $$h));
    
    ImmutableSetTest.MyIter obj/*J*/= new ImmutableSetTest.MyIter();
    S3.<ImmutableSetTest.MyIter>foreach(obj);
    ASSERT_STREQ("bcdfgh", create_char$ptr(buffer));
    ASSERT_EQ(6, obj.counter);
    
    ImmutableSetTest.MyIter obj2/*J*/= new ImmutableSetTest.MyIter();
    S2.<ImmutableSetTest.MyIter>foreach(obj2);
    ASSERT_STREQ("bcd", create_char$ptr(buffer));
    ASSERT_EQ(3, obj2.counter);
    
    ImmutableSetTest.MyIter obj3/*J*/= new ImmutableSetTest.MyIter();
    S.<ImmutableSetTest.MyIter>foreach(obj);
    ASSERT_STREQ("", create_char$ptr(buffer));
    ASSERT_EQ(0, obj3.counter);
  } finally {
    if (S3 != null) { S3.$destroy(); }
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

;
@Test
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ImmutableSetTest_IterLongSetTest_Test::TestBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp", line = 175,
 FQN="(anonymous namespace)::ImmutableSetTest_IterLongSetTest_Test::TestBody", NM="_ZN12_GLOBAL__N_137ImmutableSetTest_IterLongSetTest_Test8TestBodyEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/ImmutableSetTest.cpp -nm=_ZN12_GLOBAL__N_137ImmutableSetTest_IterLongSetTest_Test8TestBodyEv")
//</editor-fold>
public void test_IterLongSetTest() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  ImmutableSetLong.Factory f = null;
  ImmutableSetLong S = null;
  ImmutableSetLong S2 = null;
  ImmutableSetLong S3 = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    f/*J*/= new ImmutableSetLong.Factory(ImutContainerInfoLong.INFO);
    S = f.getEmptySet();
    
    S2 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetLong(S)), 0)), 1)), 2));
    S3 = $c$.clean(f.add($c$.track(f.add($c$.track(f.add($c$.track(new ImmutableSetLong(S2)), 3)), 4)), 5));
    
    int i = 0;
    ImutAVLValueIteratorLongBoolLong I = null;
    ImutAVLValueIteratorLongBoolLong E = null;
    for (I = S.begin(), E = S.end(); I.$noteq(E); I.$preInc()) {
      ASSERT_EQ(i, I.$star());
      i++;
    }
    ASSERT_EQ(0, i);
    
    i = 0;
    I = null;
    E = null;
    for (I = S2.begin(), E = S2.end(); I.$noteq(E); I.$preInc()) {
      ASSERT_EQ(i, I.$star());
      i++;
    }
    ASSERT_EQ(3, i);
    
    i = 0;
    I = null;
    E = null;
    for (I = S3.begin(), E = S3.end(); I.$noteq(E); I.$postInc(0)) {
      ASSERT_EQ(i, I.$star());
      i++;
    }
    ASSERT_EQ(6, i);
  } finally {
    if (S3 != null) { S3.$destroy(); }
    if (S2 != null) { S2.$destroy(); }
    if (S != null) { S.$destroy(); }
    if (f != null) { f.$destroy(); }
    $c$.$destroy();
  }
}

//} JAVA: end of namespace (anonymous)
//JAVA: using namespace 
} // END OF class ImmutableSetTest
