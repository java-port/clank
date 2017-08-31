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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;


//<editor-fold defaultstate="collapsed" desc="static type BitVectorTest">
@Converted(kind = Converted.Kind.AUTO,
 NM="BitVectorTest",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/unittests/ADT/BitVectorTest.cpp -test=BitVectorTest")
//</editor-fold>
public final class BitVectorTest extends ADTSupportTestBase {
  
@Test
public void testTrivialOperation() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector Vec = new BitVector();
  EXPECT_EQ(0/*u*/, Vec.count());
  EXPECT_EQ(0/*u*/, Vec.size());
  EXPECT_FALSE(Vec.any());
  EXPECT_TRUE(Vec.all());
  EXPECT_TRUE(Vec.none());
  EXPECT_TRUE(Vec.empty());

  Vec.resize(5, true);
  EXPECT_EQ(5/*u*/, Vec.count());
  EXPECT_EQ(5/*u*/, Vec.size());
  EXPECT_TRUE(Vec.any());
  EXPECT_TRUE(Vec.all());
  EXPECT_FALSE(Vec.none());
  EXPECT_FALSE(Vec.empty());

  Vec.resize(11);
  EXPECT_EQ(5/*u*/, Vec.count());
  EXPECT_EQ(11/*u*/, Vec.size());
  EXPECT_TRUE(Vec.any());
  EXPECT_FALSE(Vec.all());
  EXPECT_FALSE(Vec.none());
  EXPECT_FALSE(Vec.empty());

  BitVector Inv = new BitVector(Vec);
  Inv.flip();
  EXPECT_EQ(6/*u*/, Inv.count());
  EXPECT_EQ(11/*u*/, Inv.size());
  EXPECT_TRUE(Inv.any());
  EXPECT_FALSE(Inv.all());
  EXPECT_FALSE(Inv.none());
  EXPECT_FALSE(Inv.empty());

  EXPECT_FALSE(Inv.$eq(Vec));
  EXPECT_TRUE(Inv.$noteq(Vec));
  Vec.flip();
  EXPECT_TRUE(Inv.$eq(Vec));
  EXPECT_FALSE(Inv.$noteq(Vec));

  // Add some "interesting" data to Vec.
  Vec.resize(23, true);
  Vec.resize(25, false);
  Vec.resize(26, true);
  Vec.resize(29, false);
  Vec.resize(33, true);
  Vec.resize(57, false);
  /*uint*/int Count = 0;
  for (/*uint*/int i = Vec.find_first(); i != -1; i = Vec.find_next(i)) {
    ++Count;
    EXPECT_TRUE(Vec.$at$Const(i));
    EXPECT_TRUE(Vec.test(i));
  }
  EXPECT_EQ(Count, Vec.count());
  EXPECT_EQ(Count, 23/*u*/);
  EXPECT_FALSE(Vec.$at$Const(0));
  EXPECT_TRUE(Vec.$at$Const(32));
  EXPECT_FALSE(Vec.$at$Const(56));
  Vec.resize(61, false);

  BitVector Copy = new BitVector(Vec);
  BitVector Alt = new BitVector(3, false);
  Alt.resize(6, true);
  std.swap(Alt, Vec);
  EXPECT_TRUE(Copy.$eq(Alt));
  EXPECT_TRUE(Vec.size() == 6);
  EXPECT_TRUE(Vec.count() == 3);
  EXPECT_TRUE(Vec.find_first() == 3);
  std.swap(Copy, Vec);

  // Add some more "interesting" data.
  Vec.resize(68, true);
  Vec.resize(78, false);
  Vec.resize(89, true);
  Vec.resize(90, false);
  Vec.resize(91, true);
  Vec.resize(130, false);
  Count = 0;
  for (/*uint*/int i = Vec.find_first(); i != -1/*u*/; i = Vec.find_next(i)) {
    ++Count;
    EXPECT_TRUE(Vec.$at$Const(i));
    EXPECT_TRUE(Vec.test(i));
  }
  EXPECT_EQ(Count, Vec.count());
  EXPECT_EQ(Count, 42/*u*/);
  EXPECT_FALSE(Vec.$at$Const(0));
  EXPECT_TRUE(Vec.$at$Const(32));
  EXPECT_FALSE(Vec.$at$Const(60));
  EXPECT_FALSE(Vec.$at$Const(129));

  Vec.flip(60);
  EXPECT_TRUE(Vec.$at$Const(60));
  EXPECT_EQ(Count + 1, Vec.count());
  Vec.flip(60);
  EXPECT_FALSE(Vec.$at$Const(60));
  EXPECT_EQ(Count, Vec.count());

  Vec.reset(32);
  EXPECT_FALSE(Vec.$at$Const(32));
  EXPECT_EQ(Count - 1, Vec.count());
  Vec.set(32);
  EXPECT_TRUE(Vec.$at$Const(32));
  EXPECT_EQ(Count, Vec.count());

  Vec.flip();
  EXPECT_EQ(Vec.size() - Count, Vec.count());

  Vec.reset();
  EXPECT_EQ(0/*u*/, Vec.count());
  EXPECT_EQ(130/*u*/, Vec.size());
  EXPECT_FALSE(Vec.any());
  EXPECT_FALSE(Vec.all());
  EXPECT_TRUE(Vec.none());
  EXPECT_FALSE(Vec.empty());

  Vec.flip();
  EXPECT_EQ(130/*u*/, Vec.count());
  EXPECT_EQ(130/*u*/, Vec.size());
  EXPECT_TRUE(Vec.any());
  EXPECT_TRUE(Vec.all());
  EXPECT_FALSE(Vec.none());
  EXPECT_FALSE(Vec.empty());

  Vec.resize(64);
  EXPECT_EQ(64/*u*/, Vec.count());
  EXPECT_EQ(64/*u*/, Vec.size());
  EXPECT_TRUE(Vec.any());
  EXPECT_TRUE(Vec.all());
  EXPECT_FALSE(Vec.none());
  EXPECT_FALSE(Vec.empty());

  Vec.flip();
  EXPECT_EQ(0/*u*/, Vec.count());
  EXPECT_EQ(64/*u*/, Vec.size());
  EXPECT_FALSE(Vec.any());
  EXPECT_FALSE(Vec.all());
  EXPECT_TRUE(Vec.none());
  EXPECT_FALSE(Vec.empty());

  Inv.$assign(new BitVector().flip());
  EXPECT_EQ(0/*u*/, Inv.count());
  EXPECT_EQ(0/*u*/, Inv.size());
  EXPECT_FALSE(Inv.any());
  EXPECT_TRUE(Inv.all());
  EXPECT_TRUE(Inv.none());
  EXPECT_TRUE(Inv.empty());

  Vec.clear();
  EXPECT_EQ(0/*u*/, Vec.count());
  EXPECT_EQ(0/*u*/, Vec.size());
  EXPECT_FALSE(Vec.any());
  EXPECT_TRUE(Vec.all());
  EXPECT_TRUE(Vec.none());
  EXPECT_TRUE(Vec.empty());
}

@Test
public void testCompoundAssignment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector();
  A.resize(10);
  A.set(4);
  A.set(7);

  BitVector B = new BitVector();
  B.resize(50);
  B.set(5);
  B.set(18);

  A.$orassign(B);
  EXPECT_TRUE(A.test(4));
  EXPECT_TRUE(A.test(5));
  EXPECT_TRUE(A.test(7));
  EXPECT_TRUE(A.test(18));
  EXPECT_EQ(4/*u*/, A.count());
  EXPECT_EQ(50/*u*/, A.size());

  B.resize(10);
  B.set();
  B.reset(2);
  B.reset(7);
  A.$andassign(B);
  EXPECT_FALSE(A.test(2));
  EXPECT_FALSE(A.test(7));
  EXPECT_EQ(2/*u*/, A.count());
  EXPECT_EQ(50/*u*/, A.size());

  B.resize(100);
  B.set();

  A.$xorassign(B);
  EXPECT_TRUE(A.test(2));
  EXPECT_TRUE(A.test(7));
  EXPECT_EQ(98/*u*/, A.count());
  EXPECT_EQ(100/*u*/, A.size());
}

@Test
public void testProxyIndex() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector Vec = new BitVector(3);
  EXPECT_TRUE(Vec.none());
  Vec.$at(0).$assign(Vec.$at(1).$assign(Vec.$at(2).$assign(true)));
  EXPECT_EQ(Vec.size(), Vec.count());
  Vec.$at(2).$assign(Vec.$at(1).$assign(Vec.$at(0).$assign(false)));
  EXPECT_TRUE(Vec.none());
}

@Test
public void testPortableBitMask() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector();
  /*uint*/uint$ptr Mask1 = create_uint$ptr(new$uint(3, 0x80000000, 6, 5));

  A.resize(10);
  A.setBitsInMask(Mask1, 1);
  EXPECT_EQ(10/*u*/, A.size());
  EXPECT_FALSE(A.test(0));

  A.resize(32);
  A.setBitsInMask(Mask1, 1);
  EXPECT_FALSE(A.test(0));
  EXPECT_TRUE(A.test(31));
  EXPECT_EQ(1/*u*/, A.count());

  A.resize(33);
  A.setBitsInMask(Mask1, 1);
  EXPECT_EQ(1/*u*/, A.count());
  A.setBitsInMask(Mask1, 2);
  EXPECT_EQ(1/*u*/, A.count());

  A.resize(34);
  A.setBitsInMask(Mask1, 2);
  EXPECT_EQ(2/*u*/, A.count());

  A.resize(65);
  A.setBitsInMask(Mask1, 3);
  EXPECT_EQ(4/*u*/, A.count());

  A.setBitsNotInMask(Mask1, 1);
  EXPECT_EQ(32/*u*/+3/*u*/, A.count());

  A.setBitsNotInMask(Mask1, 3);
  EXPECT_EQ(65/*u*/, A.count());

  A.resize(96);
  EXPECT_EQ(65/*u*/, A.count());

  A.clear();
  A.resize(128);
  A.setBitsNotInMask(Mask1, 3);
  EXPECT_EQ(96/*u*/-5/*u*/, A.count());

  A.clearBitsNotInMask(Mask1, 1);
  EXPECT_EQ(64-4/*u*/, A.count());
}

@Test
public void testBinOps() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector();
  BitVector B = new BitVector();

  A.resize(65);
  EXPECT_FALSE(A.anyCommon(B));
  EXPECT_FALSE(B.anyCommon(B));

  B.resize(64);
  A.set(64);
  EXPECT_FALSE(A.anyCommon(B));
  EXPECT_FALSE(B.anyCommon(A));

  B.set(63);
  EXPECT_FALSE(A.anyCommon(B));
  EXPECT_FALSE(B.anyCommon(A));

  A.set(63);
  EXPECT_TRUE(A.anyCommon(B));
  EXPECT_TRUE(B.anyCommon(A));

  B.resize(70);
  B.set(64);
  B.reset(63);
  A.resize(64);
  EXPECT_FALSE(A.anyCommon(B));
  EXPECT_FALSE(B.anyCommon(A));
}

@Test
public void testRangeOps() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector();
  A.resize(256);
  A.reset();
  A.set(1, 255);

  EXPECT_FALSE(A.test(0));
  EXPECT_TRUE( A.test(1));
  EXPECT_TRUE( A.test(23));
  EXPECT_TRUE( A.test(254));
  EXPECT_FALSE(A.test(255));

  BitVector B = new BitVector();
  B.resize(256);
  B.set();
  B.reset(1, 255);

  EXPECT_TRUE( B.test(0));
  EXPECT_FALSE(B.test(1));
  EXPECT_FALSE(B.test(23));
  EXPECT_FALSE(B.test(254));
  EXPECT_TRUE( B.test(255));

  BitVector C = new BitVector();
  C.resize(3);
  C.reset();
  C.set(0, 1);

  EXPECT_TRUE(C.test(0));
  EXPECT_FALSE( C.test(1));
  EXPECT_FALSE( C.test(2));

  BitVector D = new BitVector();
  D.resize(3);
  D.set();
  D.reset(0, 1);

  EXPECT_FALSE(D.test(0));
  EXPECT_TRUE( D.test(1));
  EXPECT_TRUE( D.test(2));

  BitVector E = new BitVector();
  E.resize(128);
  E.reset();
  E.set(1, 33);

  EXPECT_FALSE(E.test(0));
  EXPECT_TRUE( E.test(1));
  EXPECT_TRUE( E.test(32));
  EXPECT_FALSE(E.test(33));

  BitVector BufferOverrun = new BitVector();
  /*uint*/int size = sizeof$uint64() * 8;
  BufferOverrun.resize(size);
  BufferOverrun.reset(0, size);
  BufferOverrun.set(0, size);
}

@Test
public void testCompoundTestReset() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector(50, true);
  BitVector B = new BitVector(50, false);

  BitVector C = new BitVector(100, true);
  BitVector D = new BitVector(100, false);

  EXPECT_FALSE(A.test(A));
  EXPECT_TRUE(A.test(B));
  EXPECT_FALSE(A.test(C));
  EXPECT_TRUE(A.test(D));
  EXPECT_FALSE(B.test(A));
  EXPECT_FALSE(B.test(B));
  EXPECT_FALSE(B.test(C));
  EXPECT_FALSE(B.test(D));
  EXPECT_TRUE(C.test(A));
  EXPECT_TRUE(C.test(B));
  EXPECT_FALSE(C.test(C));
  EXPECT_TRUE(C.test(D));

  A.reset(B);
  A.reset(D);
  EXPECT_TRUE(A.all());
  A.reset(A);
  EXPECT_TRUE(A.none());
  A.set();
  A.reset(C);
  EXPECT_TRUE(A.none());
  A.set();

  C.reset(A);
  EXPECT_EQ(50, C.find_first());
  C.reset(C);
  EXPECT_TRUE(C.none());
}

@Test
public void testMoveConstructor() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector(10, true);
  BitVector B = new BitVector(JD$Move.INSTANCE, std.move(A));
  // Check that the move ctor leaves the moved-from object in a valid state.
  // The following line used to crash.
  A.$assign(B);

  BitVector C = new BitVector(10, true);
  EXPECT_EQ(C, A);
  EXPECT_EQ(C, B);
}

@Test
public void testMoveAssignment() {
  if (markAsSkippedIfNeed(TestState.Successful)) { return; }
  BitVector A = new BitVector(10, true);
  BitVector B = new BitVector();
  B.$assignMove(std.move(A));
  // Check that move assignment leaves the moved-from object in a valid state.
  // The following line used to crash.
  A.$assign(B);

  BitVector C = new BitVector(10, true);
  EXPECT_EQ(C, A);
  EXPECT_EQ(C, B);
}

} // END OF class BitVectorTest
