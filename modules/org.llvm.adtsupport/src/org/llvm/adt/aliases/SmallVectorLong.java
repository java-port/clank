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
package org.llvm.adt.aliases;

import org.clank.support.Converted;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;

/**
 * SmallVector for long
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVector.tpl")
//</editor-fold>
public class SmallVectorLong extends SmallVectorImplLong 
 implements NativeCloneable<SmallVectorLong>, 
            NativeMoveable<SmallVectorLong>,
            Destructors.ClassWithDestructor {
  
  public SmallVectorLong(int capacity) {
    super(capacity, (long) 0);
  }

  public SmallVectorLong(int capacity, long defaultValue) {
    super(capacity, defaultValue);
  }
  
  public SmallVectorLong(int capacity, int initialSize, long defaultValue) {
    super(capacity, initialSize, defaultValue);
  }    

  public SmallVectorLong(JD$UInt_T$C$R _dparam, int capacity, int initialSize, long defaultValue) {
    super(_dparam, capacity, initialSize, defaultValue, defaultValue);
  }

  public SmallVectorLong(JD$UInt_T$C$R _dparam, int capacity, int initialSize, long value, long defaultValue) {
    super(_dparam, capacity, initialSize, value, defaultValue);
  }

  public SmallVectorLong(int capacity, long array[], long defaultValue) {
    super(array, defaultValue);
  }

  public SmallVectorLong(int capacity, long$iterator<?> iter, int length) {
    super(capacity, (long$iterator<?>)iter, length, (long) 0);
  }

  public SmallVectorLong(int capacity, long$iterator<?> iter, int length, long defaultValue) {
    super(capacity, (long$iterator<?>)iter, length, defaultValue);
  }

  public SmallVectorLong(int capacity, long$iterator<?> begin, long$iterator<?> end) {
    super(capacity, (long$iterator<?>)begin, (long$iterator<?>)end, (long) 0);
  }

  public SmallVectorLong(int capacity, long$iterator<?> begin, long$iterator<?> end, long defaultValue) {
    super(capacity, (long$iterator<?>)begin, (long$iterator<?>)end, defaultValue);
  }

  public SmallVectorLong(JD$T _dparam, int capacity, long$iterator<?> begin, long$iterator<?> end, long defaultValue) {
    super(capacity, (long$iterator<?>)begin, (long$iterator<?>)end, defaultValue);
  }
  // ${CUNSTRUCTOR_WITH_CONVERTER}

//  public SmallVectorLong(int capacity, ${ITERATOR_RANGE} range, long defaultValue) {
//    super(capacity, begin, end, defaultValue);
//  }

  public SmallVectorLong(SmallVectorLong other) {
    super(other);
  }

  public SmallVectorLong(JD$Move _dparam, SmallVectorLong other) {
    super(_dparam, other);
  }

  @Override
  public SmallVectorLong clone() {
    SmallVectorLong out = new SmallVectorLong(this);
    assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
    return out;
  }

  @Override
  public SmallVectorLong move() {
    SmallVectorLong out = new SmallVectorLong(JD$Move.INSTANCE, this);
    assert this.getClass() == out.getClass() : "forgot to override move in " + out.getClass();
    return out;
  }
  
}
