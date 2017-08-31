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

package org.clank.java;

import java.util.Iterator;
import org.clank.support.NativeCallback.Converter;
import org.clank.support.*;
import org.clank.support.aliases.JavaIterator;
import org.clank.support.aliases.NativeContainer;
import org.clank.support.aliases.type$iterator;

/**
 *
 * @author petrk
 */
public interface std_deque {
  public static class deque<T> implements NativeContainer<T>, Destructors.ClassWithDestructor, Iterable<T>  {
    private java.util.ArrayList<T> deque = new java.util.ArrayList<T>();
    private final boolean isDataPointerLike;
    public deque(boolean isDataPointerLike) {
      this.isDataPointerLike = isDataPointerLike;
    }
    
    public <From> deque(boolean isDataPointerLike, type$iterator<?, From> beg, type$iterator<?, From> end, Converter<From, T> converter) {
      this(isDataPointerLike);
      if (!beg.$eq(end)) {
        beg = Native.$Clone(beg);
        while (beg.$noteq(end)) {
          push_back(converter.$call(beg.$star()));
          beg.$preInc();
        }
      }
    }

    public deque(deque<T> Other) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void push_back(T val) {
      assert (val == null) || !(val instanceof void$ptr) : "need to clone?" + val.getClass();
      push_back_impl(val);
    }

    public void push_back_T$RR(T val) {
      deque.add(Native.$tryMove(null, val, isDataPointerLike));
    }

    public void push_back_T$C$R(T val) {
      assert (val == null) || !(val instanceof void$ptr) : "need to clone?" + val.getClass();
      push_back_impl(val);
    }
    
    private void push_back_impl(T val) {
      deque.add(Native.$tryAssign(null, val, isDataPointerLike));
    }

    public boolean empty() {
      return deque.isEmpty();
    }

    public T front() {
      // Calling front on an empty container is undefined. 
      return deque.get(0);
    }
    
    public T back() {
      // Calling back on an empty container is undefined. 
      return deque.get(deque.size() - 1);
    }

    public T pop_front() {
      return deque.remove(0);
    }

    public void $destroy() {
      if (!empty() && !isDataPointerLike) {
        for(T t : deque){
          Destructors.$destroy(t);
        }
      }
    }
    public void swap(deque<T> other) {
      assert this.isDataPointerLike == other.isDataPointerLike;
      java.util.ArrayList<T> impl = this.deque;
      this.deque = other.deque;
      other.deque = impl;
    }
    
    public iterator<T> begin() {
      return new iterator<>(deque, 0);
    }
    
    public iterator<T> begin$Const() {
      return new iterator<>(deque, 0);
    }
    
    public iterator<T> end() {
      return new iterator<>(deque, deque.size());
    }
    
    public iterator<T> end$Const() {
      return new iterator<>(deque, deque.size());
    }
    
    public void insert$T(type$iterator<?, T> position, type$iterator<?, T> beg, type$iterator<?, T> end) {
      if (Native.$noteq_ptr(beg, end)) {
        assert position instanceof iterator;
        int index = ((iterator)position).i;
        // fast paths
        if (position.$eq(end())) {
          beg = Native.$Clone(beg);
          while (beg.$noteq(end)) {
            push_back_impl(beg.$star());
            beg.$preInc();
          }
        } else {
          // insert from last to first into index
          end = Native.$Clone(end);
          while (beg.$noteq(end)) {
            T element = end.$star();
            deque.add(index, Native.$tryAssign(null, element, isDataPointerLike));
            end.$preDec();
          }
        }
      }
    }

    public int size() {
      return deque.size();
    }
    
    public T $at(int i) {
      return deque.get(i);
    }

    public void push_front_T$C$R(T U) {
      //assert U instanceof void$ptr : "need to clone?";
      deque.add(0, Native.$tryAssign(null, U, isDataPointerLike));
    }

    @Override
    public Iterator<T> iterator() {
      return new JavaIterator<T>(begin(), end());
    }

    @Override
    public String toString() {
      StringBuilder out = new StringBuilder(isDataPointerLike ? "PTRs " : "TYPEs ");
      out.append("size=").append(deque.size());
      for (int i = 0; i < deque.size(); i++) {
        out.append("\n[").append(i).append("]");
        T elem = deque.get(i);
        if (isDataPointerLike) {
          out.append(NativeTrace.getIdentityStr(elem));
        } else {
          out.append(String.valueOf(elem));
        }
      }
      return out.toString();
    }

    public void emplace_back(Object ... Args) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void push_front_T$RR(T $AddrOf) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public static class iterator<T> implements type$iterator<iterator<T>, T>, Native.assignable<iterator<T>> {
      private java.util.ArrayList<T> delegate;
      private int i = 0;
      
      private iterator(java.util.ArrayList<T> delegate, int i) {
        this.delegate = delegate;
        this.i = i;
      }

      public iterator(iterator<T> other) {
        this.delegate = other.delegate;
        this.i = other.i;
      }
      
      @Override
      public T $star() {
        return delegate.get(i);
      }

      @Override
      public iterator<T> clone() {
        return new iterator(this);
      }

      @Override
      public iterator<T> $preInc() {
        i++;
        return this;
      }

      @Override
      public int $sub(iterator<T> iter) {
        return i - iter.i;
      }

      @Override
      public boolean $eq(Object other) {
        return $eq((iterator<T>)other);
      }
      
      public boolean $eq(iterator<T> other){
        return i == other.i;
      }

      @Override
      public iterator<T> $assign(iterator<T> $Prm0) {
        this.delegate = $Prm0.delegate;
        this.i = $Prm0.i;
        return this;
      }

      @Override
      public String toString() {
        return "[" + i + "] in " + delegate;
      }
    }
  }
}
