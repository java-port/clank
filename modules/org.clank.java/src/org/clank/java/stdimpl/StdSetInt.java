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
import org.clank.support.Destructors;
import org.clank.support.Native;
import org.clank.support.NativeCloneable;
import org.clank.support.NativeSwappable;
import static org.clank.support.Native.*;
import static org.clank.support.JavaDifferentiators.*;
import org.clank.support.aliases.*;

/**
 *
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
public class StdSetInt implements Native.assignable<std.setInt>, NativeCloneable<std.setInt>, 
        NativeComparable<std.setInt>, Destructors.ClassWithDestructor, Iterable<Integer>, NativeSwappable {
  
  protected std.mapIntPtr<Integer> map;

  protected StdSetInt() {
    this.map = new std.mapIntPtr();
  }
  
  protected StdSetInt(Comparator<Integer> comparator) {
    this.map = new std.mapIntPtr(comparator);
  }

  protected StdSetInt(std.setInt other) {
    this.map = new std.mapIntPtr(other.map);
  }

  @Override
  public void swap(NativeSwappable /*&*/ RHS) {
    std.mapIntPtr<Integer> t = this.map;
    this.map = ((StdSetInt) RHS).map;
    ((StdSetInt) RHS).map = t;
  }

  @Override
  public std.setInt $assign(std.setInt value) {
    this.map.$assign(value.map);
    return (std.setInt) this;
  }

  public /*uint*/int size() {
    return map.size();
  }
  
  public boolean empty() {
    return map.empty();
  }

  public std.pairTypeBool<iterator> insert_T$C$R(int elem) {
    return insert(elem);
  }

  public std.pairTypeBool<iterator> insert(int elem) {
    std.pairTypeBool<std.mapIntPtr.iterator<Integer>> mapPair = map.insert(std.make_pair_int_Ptr(elem, (Integer) null));
    return std.make_pair_T_bool(new iterator(mapPair.first), mapPair.second);
  }
  
  public void insert(int$iterator<?> I, int$iterator<?> E) {
    for (; $noteq_iter(I, E); I.$preInc())  {
      map.insert(std.make_pair_int_Ptr(I.$star(), (Integer) null));
    }
  }    

  public boolean erase(int elem) {
    return map.erase(elem);
  }
  
  public void erase(iterator iter) {
    map.erase(iter.delegate);
  }
  
  public void clear() {
    map.clear();
  }
  
  public iterator find(int elem) {
    return new iterator(map.find(elem));
  }

  public iterator begin() {
    return new iterator(map.begin());
  }

  public iterator end() {
    return new iterator(map.end());
  }

  public boolean count(int elem) {
    return map.count(elem);
  }

  @Override
  public std.setInt clone() {
    return new std.setInt((std.setInt) this);
  }

  @Override
  public void $destroy() {
    map.clear();
  }

  @Override
  public boolean $eq(std.setInt other) {
    return this.map.$eq(other.map);
  }

  public static class iterator implements int$iterator<iterator> {
    
    private std.mapIntPtr.iterator<Integer> delegate;

    public iterator(iterator iter) {
      delegate = $tryClone(iter.delegate);
    }

    public iterator(JD$Move _dparam, iterator iter) {
      this.delegate = iter.delegate;
      iter.delegate = null;
    }

    public iterator(std.mapIntPtr.iterator<Integer> iter) {
      this.delegate = iter;
    }

    @Override
    public int $star() {
      return delegate.$star().first;
    }

    public int $arrow() {
      return delegate.$arrow().first;
    }

    @Override
    public int$ref star$ref() {
      return new int$ref() {
        
        private std.mapIntPtr.iterator<Integer> localIter = $tryClone(delegate);

        @Override
        public int $deref() {
          return localIter.$star().first;
        }

        @Override
        public int $set(int value) {
          throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public int$ptr deref$ptr() {
          throw new UnsupportedOperationException("Not supported.");
        }
      };
    }
    
    @Override
    public iterator $preInc() {
      delegate.$preInc();
      return this;
    }      
    
    @Override
    public iterator $postInc() {
      iterator cloned = clone();
      $preInc();
      return cloned;
    }      
    
    @Override
    public boolean $eq(Object other) {
      if (other instanceof iterator) {
        return delegate.$eq(((iterator) other).delegate);
      }
      return false;
    }

    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public iterator clone() {
      return new iterator($tryClone(delegate));
    }            

    @Override
    public iterator const_clone() {
      return new iterator($tryConstClone(delegate));
    }            

    @Override
    public int $sub(iterator iter) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $preDec() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $postDec() {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $inc(int amount) {
      return new iterator(delegate.$inc(amount));
    }

    @Override
    public iterator $dec(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $add(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $sub(int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }
  }

  @Override
  public Iterator<Integer> iterator() {
    return new JavaIteratorInt(begin(), end());
  }
}
