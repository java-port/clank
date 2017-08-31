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

import org.clank.support.aliases.type$memory;
import org.clank.support.aliases.type$ptr;
import org.clank.support.aliases.type$ptr$heavy;

/**
 * Abstract implementation of pointer type
 *
 * @param <T> must be the type of the pointer itself
 * @param <M> must be the memory type on which pointer points
 */
public abstract class AbstractHeavyPointerType<T extends abstract_pointer, M extends NativeMemory.memory> extends abstract$assignable<T, type$memory<T>> implements abstract_pointer<T>, NativeCloneable<T>, NativeMoveable<T>, DebuggableAbstractPointerType<T> {
  protected M memory;
  protected int index;

  public AbstractHeavyPointerType(M memory, int index, type$memory<T> selfMemory, int selfIndex) {
    super(selfMemory, selfIndex);
    this.memory = memory;
    this.index = index;
  }
  
  @Override
  public boolean $isNull() {
      return memory == null;
  }  

  @Override
  public int $sub(T ptr) {
    if (ptr instanceof AbstractHeavyPointerType) {
      AbstractHeavyPointerType<T, M> other = (AbstractHeavyPointerType<T, M>) ptr;
      NativeMemory.MemoryPoint p1 = NativePointer.extractMemoryPoint(this);
      NativeMemory.MemoryPoint p2 = NativePointer.extractMemoryPoint(other);
      return NativeMemory.getMemoryPointsDistance(p1, p2);
    }
    throw new IllegalArgumentException("Different pointer types: expected '" + getClass().getName() + "'" + ", but found '" + (ptr != null ? ptr.getClass() : "null") + "'");
  }

  @Override
  public T $assign(T value) {
    if (value instanceof AbstractHeavyPointerType) {
      AbstractHeavyPointerType<T, M> other = (AbstractHeavyPointerType<T, M>) value;
      memory = other.memory;
      index = other.index;
      return (T) this;
    }
    throw new IllegalArgumentException("Different pointer types: expected '" + getClass().getName() + "'" + ", but found '" + (value != null ? value.getClass() : "null") + "'");
  }

  @Override
  public T $preInc() {
    assert !_isConstPtr() : "Cannot modify const object!";
    index++;
    return (T) this;
  }

  @Override
  public T $preDec() {
    assert !_isConstPtr() : "Cannot modify const object!";
    index--;
    return (T) this;
  }

  @Override
  public T $postInc() {
    assert !_isConstPtr() : "Cannot modify const object!";
    T prev = clone();
    index++;
    return prev;
  }

  @Override
  public T $postDec() {
    assert !_isConstPtr() : "Cannot modify const object!";
    T prev = clone();
    index--;
    return prev;
  }

  @Override
  public T $inc(int amount) {
    assert !_isConstPtr() : "Cannot modify const object!";
    index += amount;
    return (T) this;
  }

  @Override
  public T $dec(int amount) {
    assert !_isConstPtr() : "Cannot modify const object!";
    index -= amount;
    return (T) this;
  }

  @Override
  public T $add(int amount) {
    T created = clone();
    return (T) created.$inc(amount);
  }

  @Override
  public T $sub(int amount) {
    T created = clone();
    return (T) created.$dec(amount);
  }

  @Override
  public type$ptr<T> $addr() {
    return new type$ptr$heavy(selfMemory, selfIndex);
  }

  @Override
  public boolean $eq(Object p) {
    if (p == this) {
      return true;
    }
    return NativePointer.arePointersEqual(this, (void$ptr) p);
  }

  @Override
  public boolean $noteq(Object p) {
    return !$eq(p);
  }

  @Override
  public boolean isComparableTo(void$ptr other) {
    return NativePointer.arePointersComparable(this, other);
  }

  @Override
  public boolean $less(Object obj) {
    if (obj instanceof void$ptr) {
      return NativePointer.comparePointers(this, (void$ptr) obj) < 0;
    }
    return false;
  }

  @Override
  public boolean $lesseq(Object obj) {
    if (obj instanceof void$ptr) {
      return NativePointer.comparePointers(this, (void$ptr) obj) <= 0;
    }
    return false;
  }

  @Override
  public boolean $greater(Object obj) {
    if (obj instanceof void$ptr) {
      return NativePointer.comparePointers(this, (void$ptr) obj) > 0;
    }
    return false;
  }

  @Override
  public boolean $greatereq(Object obj) {
    if (obj instanceof void$ptr) {
      return NativePointer.comparePointers(this, (void$ptr) obj) >= 0;
    }
    return false;
  }

  @Override
  public int $hashcode() {
    return NativePointer.calcHashCode(this);
  }

  @Override
  protected type$memory<T> createMemory() {
    return new NativeMemory.type$mem(this);
  }

  @Override
  public abstract T clone();

  @Override
  public T const_clone() {
    return (T)((AbstractHeavyPointerType)clone()).$toConstPtr();
  }

  @Override 
  public T move() {
    return clone();
  }

  public M $memory() {
    return memory;
  }
  
  public int $index() {
    return index;
  }
  
  ///////////////////////////////////////////////////////////////////////////
  // FOR DEBUG PURPOSES
  
  private byte _flags;

  public/*debug-only*/ final boolean _isConstPtr() {
    return (_flags & CONST_PTR) != 0;
  }
  
  public/*debug-only*/ T $toConstPtr() {
    _flags |= CONST_PTR;
    return (T)this;
  }

  public/*debug-only*/ T $cleanConstPtr() {
    assert _isConstPtr() : "only marked as const can be cleared; may be you are doing something not completely investigated?";
    $cleanConstPtrWithoutAssert();
    return (T)this;
  }
  
  public/*debug-only*/ final void $cleanConstPtrWithoutAssert() {
    _flags &= ~CONST_PTR;
  }

  public/*debug-only*/ final boolean _isConstContent() {
    return (_flags & CONST_CONTENT) != 0;
  }
  
  public/*debug-only*/ T $toConstContent() {
    _flags |= CONST_CONTENT;
    return (T)this;
  }

  public/*debug-only*/ T $cleanConstContent() {
    assert _isConstContent(): "only marked as const can be cleared; may be you are doing something not completely investigated?";
    $cleanConstContentWithoutAssert();
    return (T)this;
  }  
  
  public/*debug-only*/ final void $cleanConstContentWithoutAssert() {
    _flags &= ~CONST_CONTENT;
  }  
}
