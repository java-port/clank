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

import org.clank.support.NativeCallback.Converter;
import static org.clank.support.Native.*;
import org.clank.support.aliases.*;

/**
 * Converts types when iterating.
 * 
 * @param <From> - from type
 * @param <To> - to type
 * @param <Iter> - type of original iterator (which is used to iterate over objects of type From)
 * 
 * @author petrk
 */
public class convert_iterator<From, To, Iter extends type$iterator<Iter, From>> implements type$iterator<convert_iterator<From, To, Iter>, To> {
  
  private final Iter delegate;
  
  private final Converter<From, To> converter;

  public convert_iterator(Iter delegate, Converter<From, To> converter) {
    this.delegate = delegate;
    this.converter = converter;
  }

  @Override
  public To $star() {
    return converter.$call(delegate.$star());
  }

  @Override
  public type$ref<To> star$ref() {
    throw new UnsupportedOperationException("Not supported.");
  }

  @Override
  public int $sub(convert_iterator<From, To, Iter> iter) {
    return delegate.$sub(iter.delegate);
  }

  @Override
  public convert_iterator<From, To, Iter> $preInc() {
    delegate.$preInc();
    return this;
  }

  @Override
  public convert_iterator<From, To, Iter> $preDec() {
    delegate.$preDec();
    return this;
  }

  @Override
  public convert_iterator<From, To, Iter> $postInc() {
    convert_iterator<From, To, Iter> cloned = clone();
    delegate.$preInc();
    return cloned;
  }

  @Override
  public convert_iterator<From, To, Iter> $postDec() {
    convert_iterator<From, To, Iter> cloned = clone();
    delegate.$preDec();
    return cloned;
  }

  @Override
  public convert_iterator<From, To, Iter> $inc(int amount) {
    delegate.$inc(amount);
    return this;
  }

  @Override
  public convert_iterator<From, To, Iter> $dec(int amount) {
    delegate.$dec(amount);
    return this;
  }

  @Override
  public convert_iterator<From, To, Iter> $add(int amount) {
    return clone().$inc(amount);
  }

  @Override
  public convert_iterator<From, To, Iter> $sub(int amount) {
    return clone().$sub(amount);
  }

  @Override
  public convert_iterator<From, To, Iter> clone() {
    return new convert_iterator($tryClone(delegate), converter);
  }

  @Override
  public convert_iterator<From, To, Iter> const_clone() {
    return clone();
  }

  @Override
  public boolean $noteq(Object other) {
    if (other instanceof convert_iterator) {
      convert_iterator otherIter = (convert_iterator) other;
      return delegate.$noteq(otherIter.delegate);
    }
    return true;
  }

  @Override
  public boolean $eq(Object other) {
    if (other instanceof convert_iterator) {
      convert_iterator otherIter = (convert_iterator) other;
      return delegate.$eq(otherIter.delegate);
    }
    return false;
  }
}
