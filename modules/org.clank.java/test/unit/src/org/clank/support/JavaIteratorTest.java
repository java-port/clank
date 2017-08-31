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
package org.clank.support;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import static org.clank.support.Native.$tryClone;
import org.clank.support.aliases.JavaIterator;
import org.clank.support.aliases.type$iterator;
import org.junit.Test;

/**
 *
 * @author Vladimir Voskresensky
 */
public class JavaIteratorTest extends org.clank.java.JavaTestBase {
  private enum IteratorMethods {
    STAR,
    PRE_INC,
    CLONE,
    EQ
  }
  
  private static final class iterator implements type$iterator<iterator, AtomicInteger> {
    private final List<IteratorMethods> calls;
    private AtomicInteger index;
    
    private iterator(iterator $Prm0) {
      this($Prm0.calls, $Prm0.index.intValue());
    }
    public iterator(List calls, int index) {
      this.calls = calls;
      this.index = new AtomicInteger(index);
    }
    
    @Override
    public AtomicInteger $star() {
      calls.add(IteratorMethods.STAR);
      return index;
    }

    @Override
    public iterator $preInc() {
      calls.add(IteratorMethods.PRE_INC);
      index.incrementAndGet();
      return this;
    }

    @Override
    public iterator clone() {
      // can be called from assert modes multiple times
      return new iterator(this);
    }

    @Override
    public boolean $eq(Object other) {
      // can be called from assert modes multiple times
      return this.index.intValue() == ((iterator)other).index.intValue();
    }

    @Override
    public String toString() {
      return "iterator{index=" + index.intValue() + ";calls=" + calls + '}';
    }      
  }
  
  private static final class MyIterable implements Iterable<Number> {

    private final iterator beg;
    private final iterator end;
    
    public MyIterable(iterator beg, iterator end) {
      this.beg = beg;
      this.end = end;
    }

    @Override
    public Iterator<Number> iterator() {
      return new JavaIterator(beg, end);
    }
  }
  
  @Test public void testForEachLoop() {
    if (markAsSkippedIfNeed(TestState.Successful)) { return; }
    final int BEGIN_INDEX = 0;
    final int END_INDEX = 2;
    List<IteratorMethods> forBegin = new ArrayList<>();
    List<IteratorMethods> forEnd = new ArrayList<>();
    iterator begFor = new iterator(forBegin, BEGIN_INDEX);
    iterator endFor = new iterator(forEnd, END_INDEX);
    // collect standard for events
    int index = 0;
    for(iterator b = $tryClone(begFor), e = endFor; b.$noteq(e); b.$preInc()) {
      Number next = b.$star();
      ASSERT_EQ(index, next.intValue());
      index++;
    }
    
    List<IteratorMethods> foreachBegin = new ArrayList<>();
    List<IteratorMethods> foreachEnd = new ArrayList<>();
    iterator begForeach = new iterator(foreachBegin, BEGIN_INDEX);
    iterator endForeach = new iterator(foreachEnd, END_INDEX);
    Iterable<Number> forEach = new MyIterable(begForeach, endForeach);
    index = 0;
    for (Number next : forEach) {
      ASSERT_EQ(index, next.intValue());
      index++;
    }
    
    ASSERT_EQ(forEnd.size(), foreachEnd.size());
    for (int i = 0; i < forEnd.size(); i++) {
      ASSERT_EQ(forEnd.get(i), foreachEnd.get(i));
    }
    ASSERT_EQ(forBegin.size(), foreachBegin.size());
    for (int i = 0; i < forBegin.size(); i++) {
      ASSERT_EQ(forBegin.get(i), foreachBegin.get(i));
    }
  }
}
