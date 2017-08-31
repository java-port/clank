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


/**
 * Base type for iterators.
 *
 * @param <T> - type of implementation
 */
public interface abstract_iterator<T extends abstract_iterator> extends Native.NativeComparable, NativeCloneable<T>, NativeSwappable {

  /**
   * returns distance in elements between iterators (int len = ptr1 - ptr2)
   *
   * @param iter other iterator
   * @return distance in elements between pointers
   */
  default int $sub(T iter) { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Increments position and returns itself (++x in C++)
   *
   * @return this iterator
   */
  default T $preInc() { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Decrements position and returns itself (--x in C++)
   *
   * @return this iterator
   */
  default T $preDec() { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Increments position and returns previous value (x++ in C++)
   *
   * @return val iterator
   */
  default T $postInc() { return $postInc(Integer.MAX_VALUE); }
  default T $postInc(int $Dummy) { assert $Dummy == 0 : "Why not overloaded $postInc() without args?"; return $postInc(); }

  /**
   * Decrements position and returns previous value (x-- in C++)
   *
   * @return val iterator
   */
  default T $postDec() { return $postDec(Integer.MAX_VALUE); }
  default T $postDec(int $Dummy) { assert $Dummy == 0 : "Why not overloaded $postDec() without args?"; return $postDec(); }

  /**
   * Increments position and returns itself ('x += amount' in C++)
   *
   * @param amount
   * @return this iterator
   */
  default T $inc(int amount) { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Decrements position and returns itself ('x -= amount' in C++)
   *
   * @param amount
   * @return this iterator
   */
  default T $dec(int amount) { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Creates new iterator with incremented position ('x + amount' in C++)
   *
   * @param amount
   * @return new iterator
   */
  default T $add(int amount) { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Creates new iterator with decremented position ('x - amount' in C++)
   *
   * @param amount
   * @return new iterator
   */
  default T $sub(int amount) { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Clones iterator.
   */  
  default T clone() { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }

  /**
   * Clones iterator which can not be self-incremented/decremented.
   */  
  default T const_clone() { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }
  
  default void swap(NativeSwappable RHS) { throw new UnsupportedOperationException("why not implemented in " + this.getClass()); }
}
