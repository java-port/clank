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

package org.clank.java.stdimpl;

import java.util.Iterator;
import org.clank.java.std;
import org.clank.support.Native;
import org.clank.support.NativeCloneable;
import static org.clank.support.NativePointer.*;
import org.clank.support.aliases.*;

/**
 *
 * @author petrk
 */
public abstract class StdTuple implements NativeCloneable<std.tuple>, Native.NativeComparable<std.tuple>, Native.assignable<std.tuple>, Iterable<Object> {
  
  private boolean isDataPointerLike;
  
  private Object elements[];

  public StdTuple(StdTuple other) {
    this.isDataPointerLike = other.isDataPointerLike;
    this.elements = other.elements;
  }
  
  public StdTuple(Object ... elements) {
    this(false, elements);
  }
  
  public StdTuple(boolean isDataPointerLike, Object ... elements) {
    this.isDataPointerLike = isDataPointerLike;
    this.elements = elements;
  }

  @Override
  public std.tuple clone() {
    return new std.tuple(this.isDataPointerLike, elements);
  }

  @Override
  public std.tuple $assign(std.tuple value) {
    if (this == value) {
      return value;
    }
    this.isDataPointerLike = ((StdTuple)value).isDataPointerLike;
    if (elements.length == ((StdTuple) value).elements.length) {
      for (int i = 0; i < elements.length; i++) {
        elements[i] = Native.$tryAssign(elements[i], ((StdTuple) value).elements[i], isDataPointerLike);
      }
    }
    throw new AssertionError("Tuples of different sizes (and types) are not assignable!");
  }

  @Override
  public boolean $noteq(std.tuple other) {
    return !$eq(other);
  }

  @Override
  public boolean $eq(std.tuple other) {
    if (this.isDataPointerLike != ((StdTuple)other).isDataPointerLike) {
      return false;
    }
    if (elements.length == ((StdTuple) other).elements.length) {
      for (int i = 0; i < elements.length; i++) {
        if (!Native.$eq(elements[i], ((StdTuple) other).elements[i], this.isDataPointerLike)) {
          return false;
        }
      }
      return true;
    }
    return false;
  }

  public Object $getAt(int idx) {
    return elements[idx];
  }

  public Object[] $get(){
    Object[] res = new Object[elements.length];
    System.arraycopy(elements, 0, res, 0, elements.length);
    return res;
  }
  
  @Override
  public Iterator<Object> iterator() {
    return new JavaIterator(create_type$ptr(elements), create_type$ptr(elements, elements == null ? 0 : elements.length));
  }
}
