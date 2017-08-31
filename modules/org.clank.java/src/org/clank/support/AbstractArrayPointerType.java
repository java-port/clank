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

/*
 ****************************************************************************
 *   Implementations for arrays
 ****************************************************************************
 */
public abstract class AbstractArrayPointerType<T extends abstract_pointer> implements abstract_pointer<T>, NativeCloneable<T>, NativeMoveable<T>, DebuggableAbstractPointerType<T> {
  protected static final String NEW_LINE = "\n"; // NOI18N
  
  protected int index;

  protected AbstractArrayPointerType(boolean makeConstPtr, boolean makeConstContent) {
    this.index = 0;
    this._flags = (byte) ((makeConstPtr ? CONST_PTR : 0) | (makeConstContent ? CONST_CONTENT : 0));
  }
  
  ///////////////////////////////////////////////////////////////////////////
  // Copy Constructors
  
  protected AbstractArrayPointerType(AbstractArrayPointerType<T> other, boolean makeConstPtr, boolean makeConstContent) {
    assert this.getClass() == other.getClass() : this.getClass() + " vs. " + other.getClass();
    this.index = other.index;
    this._flags = (byte) ((makeConstPtr ? CONST_PTR : 0) | (makeConstContent ? CONST_CONTENT : 0));
  }
  
  ///////////////////////////////////////////////////////////////////////////
  // performance access operations
  public final int $index() {
    return this.index;
  }
  
  ///////////////////////////////////////////////////////////////////////////
  // common operations

  @Override
  public abstract int $sub(T other);

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
    T old = clone();
    index++;
    return old;
  }

  @Override
  public T $postDec() {
    assert !_isConstPtr() : "Cannot modify const object!";
    T old = clone();
    index--;
    return old;
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
  public abstract T $add(int amount);

  @Override
  public abstract T $sub(int amount);

  @Override public abstract T clone();
  
  @Override public abstract T const_clone();
  
  @Override public T move() {
    return clone();
  }
  
//  @Override
//  public T clone() {    
//    try {
//      AbstractArrayPointerType clone = (AbstractArrayPointerType) super.clone();
//      clone._const = false; // always clone as non-const pointer
//      return (T) clone;
//    } catch (CloneNotSupportedException ex) {
//      throw new AssertionError("Clone is not supported!"); //NOI18N
//    }
//  }

  @Override
  public type$ptr<T> $addr() {
    return new type$ptr$inout<T>(this) {
      @Override
      protected T $star$impl() {
        return (T) AbstractArrayPointerType.this;
      }

      @Override
      protected T $set$impl(T value) {
        return (AbstractArrayPointerType.this).$assign(value);
      }
    };
  }

  @Override
  public type$memory<T> getSelfMemory() {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public int getSelfIndex() {
    throw new UnsupportedOperationException("Not supported.");
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
