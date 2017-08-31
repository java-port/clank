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

import java.util.Comparator;
import java.util.Iterator;
import org.clank.java.std;
import org.clank.java.std.Compare;
import org.clank.support.Destructors;
import org.clank.support.Native;
import org.clank.support.NativeCloneable;
import static org.clank.support.Native.*;
import org.clank.support.aliases.JavaIterator;
import org.clank.support.aliases.type$iterator;
import org.clank.support.aliases.type$ptr;
import org.clank.support.aliases.type$ref;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class StdSetPtr<T> implements Native.assignable<std.setPtr<T>>, NativeCloneable<std.setPtr<T>>, 
        NativeComparable<std.setPtr<T>>, Destructors.ClassWithDestructor, Iterable<T> {
  
  protected std.mapPtrPtr<T, T> map;

  protected StdSetPtr() {
    this.map = new std.mapPtrPtr();
  }
  
  protected StdSetPtr(Comparator<T> comparator) {
    this.map = new std.mapPtrPtr(comparator);
  }

  protected StdSetPtr(std.setPtr<T> other) {
    this.map = new std.mapPtrPtr(other.map);
  }

  @Override
  public std.setPtr<T> $assign(std.setPtr<T> value) {
    this.map.$assign(value.map);
    return (std.setPtr<T>) this;
  }

  public /*uint*/int size() {
    return map.size();
  }
  
  public boolean empty() {
    return map.empty();
  }

  public final std.pairTypeBool<iterator<T>> insert_T$RR(T elem) {
    std.pairTypeBool<std.mapPtrPtr.iterator<T, T>> mapPair = map.insert$T$RR(std.make_pair_Ptr_Ptr(elem, (T) null));
    return std.make_pair_T_bool(new iterator<T>(mapPair.first), mapPair.second);
  }
  
  public std.pairTypeBool<iterator<T>> insert(T elem) {
    std.pairTypeBool<std.mapPtrPtr.iterator<T, T>> mapPair = map.insert(std.make_pair_Ptr_Ptr(elem, (T) null));
    return std.make_pair_T_bool(new iterator<T>(mapPair.first), mapPair.second);
  }

  public std.pairTypeBool<iterator<T>> insert_T$C$R(T elem) {
    return insert(elem);
  }

  public void insert(type$iterator<?, T> I, type$iterator<?, T> E) {
    for (; $noteq_iter(I, E); I.$preInc())  {
      map.insert(std.make_pair_Ptr_Ptr(I.$star(), (T) null));
    }
  }    
  
  // iterator lower_bound( const Key& key );
  public iterator<T> lower_bound(T key) {
    return new iterator(map.lower_bound(key));
  }
  
  // iterator upper_bound( const Key& key );
  public iterator<T> upper_bound(T key) {
    return new iterator(map.upper_bound(key));
  }
  
  // key_compare key_comp() const;
  public Compare<T> key_comp() {
    return (T t1, T t2)->map.keyComparator().compare(t1, t2) < 0;
  }

  public boolean erase(T elem) {
    return map.erase(elem);
  }
  
  public void erase(iterator<T> iter) {
    map.erase(iter.delegate);
  }
  
  public void erase(iterator<T> from, iterator<T> to) {
    from = $tryClone(from);
    while (from.$noteq(to)) {
      erase(from);
      from.$preInc();
    }
  }
  
  public void clear() {
    map.clear();
  }
  
  public iterator<T> find(T elem) {
    return new iterator(map.find(elem));
  }

  public iterator<T> begin() {
    return new iterator(map.begin());
  }

  public iterator<T> end() {
    return new iterator(map.end());
  }

  public boolean count(T elem) {
    return map.count(elem);
  }

  @Override
  public std.setPtr<T> clone() {
    return new std.setPtr((std.setPtr<T>) this);
  }

  @Override
  public void $destroy() {
    map.clear();
  }
  
  @Override
  public boolean $eq(std.setPtr<T> other) {
    return this.map.$eq(other.map);
  }

  public static class iterator<T> implements type$iterator<iterator<T>, T> {
    
    private std.mapPtrPtr.iterator<T, T> delegate;

    public iterator(std.mapPtrPtr.iterator<T, T> iter) {
      this.delegate = iter;
    }

    @Override
    public T $star() {
      return delegate.$star().first;
    }

    public T $arrow() {
      return delegate.$arrow().first;
    }

    @Override
    public type$ref<T> star$ref() {
      return new type$ref<T>() {
        
        private std.mapPtrPtr.iterator<T, T> localIter = $tryClone(delegate);

        @Override
        public T $deref() {
          return localIter.$star().first;
        }

        @Override
        public T $set(T value) {
          localIter.$star().first = value;
          return value;
        }

        @Override
        public type$ptr<T> deref$ptr() {
          throw new UnsupportedOperationException("Not supported.");
        }
      };
    }
    
    @Override
    public iterator<T> $preInc() {
      delegate.$preInc();
      return this;
    }      
    
    @Override
    public iterator<T> $postInc() {
      iterator<T> cloned = clone();
      $preInc();
      return cloned;
    }      
    
    @Override
    public boolean $eq(Object other) {
      if (other instanceof iterator) {
        return delegate.$eq(((iterator<T>) other).delegate);
      }
      return false;
    }

    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public iterator<T> clone() {
      return new iterator($tryClone(delegate));
    }            

    @Override
    public iterator<T> const_clone() {
      return new iterator($tryConstClone(delegate));
    }            

    @Override
    public int $sub(iterator<T> iter) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator<T> $preDec() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator<T> $postDec() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator<T> $inc(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator<T> $dec(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator<T> $add(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator<T> $sub(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }
  }

  @Override
  public Iterator<T> iterator() {
    return new JavaIterator(begin(), end());
  }
}
