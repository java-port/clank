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
import static org.clank.support.Native.*;
import org.clank.support.aliases.*;

/**
 *
 * @author vkvashin
 */
public class StdSetUInt implements Native.assignable<std.setUInt>, NativeCloneable<std.setUInt>, 
        NativeComparable<std.setUInt>, Destructors.ClassWithDestructor, Iterable<Integer> {
  
  protected std.mapUIntPtr<Integer> map;

  protected StdSetUInt() {
    this.map = new std.mapUIntPtr();
  }
  
  protected StdSetUInt(Comparator<Integer> comparator) {
    this.map = new std.mapUIntPtr<Integer>(comparator);
  }

  protected StdSetUInt(std.setUInt other) {
    this.map = new std.mapUIntPtr(other.map);
  }

  @Override
  public std.setUInt $assign(std.setUInt value) {
    this.map.$assign(value.map);
    return (std.setUInt) this;
  }

  public /*uint*/int size() {
    return map.size();
  }
  
  public boolean empty() {
    return map.empty();
  }

  public std.pairTypeBool<StdSetUInt.iterator> insert(/*uint*/int elem) {
    std.pairTypeBool<std.mapUIntPtr.iterator<Integer>> mapPair = map.insert(std.make_pair_uint_Ptr(elem, (Integer) null));
    return std.make_pair_T_bool(new StdSetUInt.iterator(mapPair.first), mapPair.second);
  }
  
  public void insert(uint$iterator<?> I, uint$iterator<?> E) {
    for (; $noteq_iter(I, E); I.$preInc())  {
      map.insert(std.make_pair_uint_Ptr(I.$star(), (Integer) null));
    }
  }    

  public boolean erase(/*uint*/int elem) {
    return map.erase(elem);
  }
  
  public void erase(iterator iter) {
    map.erase(iter.delegate);
  }
  
  public void clear() {
    map.clear();
  }
  
  public iterator find(/*uint*/int elem) {
    return new iterator(map.find(elem));
  }

  public iterator begin() {
    return new iterator(map.begin());
  }

  public iterator end() {
    return new iterator(map.end());
  }

  public boolean count(/*uint*/int elem) {
    return map.count(elem);
  }

  @Override
  public std.setUInt clone() {
    return new std.setUInt((std.setUInt) this);
  }

  @Override
  public void $destroy() {
    map.clear();
  }

  @Override
  public boolean $eq(std.setUInt other) {
    return this.map.$eq(other.map);
  }

  public static class iterator implements uint$iterator<iterator> {
    
    private std.mapUIntPtr.iterator<Integer> delegate;

    public iterator(std.mapUIntPtr.iterator<Integer> iter) {
      this.delegate = iter;
    }

    @Override
    public /*uint*/int $star() {
      return delegate.$star().first;
    }

    public /*uint*/int $arrow() {
      return delegate.$arrow().first;
    }

    @Override
    public uint$ref star$ref() {
      return new uint$ref() {
        
        private std.mapUIntPtr.iterator<Integer> localIter = $tryClone(delegate);

        @Override
        public /*uint*/int $deref() {
          return localIter.$star().first;
        }

        @Override
        public /*uint*/int $set(int value) {
          throw new UnsupportedOperationException("Not supported.");
        }

        @Override
        public uint$ptr deref$ptr() {
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
    public /*uint*/int $sub(iterator iter) {
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
    public iterator $inc(/*uint*/int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $dec(/*uint*/int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $add(/*uint*/int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }

    @Override
    public iterator $sub(/*uint*/int amount) {
      throw new UnsupportedOperationException("Not supported.");
    }
  }

  @Override
  public Iterator<Integer> iterator() {
    return new JavaIteratorUInt(begin(), end());
  }
}
