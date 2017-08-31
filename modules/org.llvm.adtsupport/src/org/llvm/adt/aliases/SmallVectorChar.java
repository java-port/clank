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
 * SmallVector for byte
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVector.tpl")
//</editor-fold>
public class SmallVectorChar extends SmallVectorImplChar 
 implements NativeCloneable<SmallVectorChar>, 
            NativeMoveable<SmallVectorChar>,
            Destructors.ClassWithDestructor {
  
  public SmallVectorChar(int capacity) {
    super(capacity, (byte) 0);
  }

  public SmallVectorChar(int capacity, byte defaultValue) {
    super(capacity, defaultValue);
  }
  
  public SmallVectorChar(int capacity, int initialSize, byte defaultValue) {
    super(capacity, initialSize, defaultValue);
  }    

  public SmallVectorChar(JD$UInt_T$C$R _dparam, int capacity, int initialSize, byte defaultValue) {
    super(_dparam, capacity, initialSize, defaultValue, defaultValue);
  }

  public SmallVectorChar(JD$UInt_T$C$R _dparam, int capacity, int initialSize, byte value, byte defaultValue) {
    super(_dparam, capacity, initialSize, value, defaultValue);
  }

  public SmallVectorChar(int capacity, byte array[], byte defaultValue) {
    super(array, defaultValue);
  }

  public SmallVectorChar(int capacity, char$iterator<?> iter, int length) {
    super(capacity, (char$iterator<?>)iter, length, (byte) 0);
  }

  public SmallVectorChar(int capacity, char$iterator<?> iter, int length, byte defaultValue) {
    super(capacity, (char$iterator<?>)iter, length, defaultValue);
  }

  public SmallVectorChar(int capacity, char$iterator<?> begin, char$iterator<?> end) {
    super(capacity, (char$iterator<?>)begin, (char$iterator<?>)end, (byte) 0);
  }

  public SmallVectorChar(int capacity, char$iterator<?> begin, char$iterator<?> end, byte defaultValue) {
    super(capacity, (char$iterator<?>)begin, (char$iterator<?>)end, defaultValue);
  }

  public SmallVectorChar(JD$T _dparam, int capacity, char$iterator<?> begin, char$iterator<?> end, byte defaultValue) {
    super(capacity, (char$iterator<?>)begin, (char$iterator<?>)end, defaultValue);
  }
  // ${CUNSTRUCTOR_WITH_CONVERTER}

//  public SmallVectorChar(int capacity, ${ITERATOR_RANGE} range, byte defaultValue) {
//    super(capacity, begin, end, defaultValue);
//  }

  public SmallVectorChar(SmallVectorChar other) {
    super(other);
  }

  public SmallVectorChar(JD$Move _dparam, SmallVectorChar other) {
    super(_dparam, other);
  }

  @Override
  public SmallVectorChar clone() {
    SmallVectorChar out = new SmallVectorChar(this);
    assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
    return out;
  }

  @Override
  public SmallVectorChar move() {
    SmallVectorChar out = new SmallVectorChar(JD$Move.INSTANCE, this);
    assert this.getClass() == out.getClass() : "forgot to override move in " + out.getClass();
    return out;
  }
  
}
