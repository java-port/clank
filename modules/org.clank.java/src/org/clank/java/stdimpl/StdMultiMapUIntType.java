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
import java.util.Map;
import java.util.TreeMap;
import org.clank.java.std;
import org.clank.java.std_pair;
import org.clank.support.Destructors;
import org.clank.support.Native;
import org.clank.support.NativeCloneable;
import static org.clank.support.Native.*;
import org.clank.support.NativePointer;
import static org.clank.support.NativePointer.*;
import org.clank.support.Unsigned;
import org.clank.support.aliases.type$iterator;
import org.clank.support.aliases.type$ptr;

/**
 * std::multimap<uint, ?>
 * @author Vladimir Voskresensky
 */
public class StdMultiMapUIntType<T> implements Native.assignable<std.multimapUIntType<T>>, 
    NativeCloneable<std.multimapUIntType<T>>, Iterable<std.pairUIntType<T>>, Destructors.ClassWithDestructor {
    
  private T defaultValue;

  private static class Values<T> implements Destructors.ClassWithDestructor {
    
    private T[] data;    
    private int size;
    
    public Values(int capacity) {
      this.data = (T[]) new Object[capacity];
      this.size = 0;
    }

    public Values(int capacity, T value) {
      this(capacity);
      this.data[0] = value;
      this.size = 1;
    }

    public void add(T value) {
      ensureCapacity(size + 1);
      data[size] = value;
      size++;
    }

    private void ensureCapacity(int capacity) {
      if (capacity >= data.length) {
        T[] oldData = data;
        data = (T[]) new Object[data.length * 2];
        NativePointer.copy$Object(oldData, 0, data, 0, oldData.length);
      }
    }

    public type$ptr<T> begin() {
      return create_type$ptr(data);
    }

    public type$ptr<T> end() {
      return create_type$ptr(data, size);
    }

    public int count() {
      return size;
    }

    @Override
    public void $destroy() {
      for (int i = 0; i < size; i++) {
        Native.destroy(data[i]);        
      }
      data = null;
      size = 0;
    }    
  }

  private TreeMap<Integer, Values<std_pair.pairUIntType<T>>> treeMap;

  public StdMultiMapUIntType(T defVal) {
    treeMap = new TreeMap<>(Unsigned.UINT_COMPARATOR);
  }

  public std_pair.pair<type$iterator<?, std_pair.pairUIntType<T>>, type$iterator<?, std_pair.pairUIntType<T>>> equal_range(int key) {
    Values<std_pair.pairUIntType<T>> values = treeMap.get(key);
    if (values == null) {
      // NB: that's don't compily what C++ multimap does in the case there are no values. In this case c++ reference says:
      // "the range returned has a length of zero, with both iterators pointing to the first element 
      // that has a key considered to go after k according to the container's internal comparison object"
      // But I'm pretty sure this fact is not used
      return new std_pair.pair<>(create_type$null$ptr(), create_type$null$ptr());
    }
    return new std_pair.pair<>(values.begin(), values.end());
  }
  
  public void insert(std_pair.pairUIntType<T> KeyAndVal) {
    Values<std_pair.pairUIntType<T>> values = treeMap.get(KeyAndVal.first);
    if (values == null) {
      values = new Values(2, $tryClone(KeyAndVal));
      treeMap.put(KeyAndVal.first, values);
    } else {
      values.add($tryClone(KeyAndVal));
    }
  }
  
  public int count(/*uint*/ int key) {
    Values<std_pair.pairUIntType<T>> values = treeMap.get(key);
    if (values == null) {
      return 0;
    } else {
      return values.count();
    }
  }
  
  public std_pair.pairUIntType<T> find(/*uint*/int key) {
    throw new UnsupportedOperationException("Not supported yet.");
  }
  
  @Override
  public std.multimapUIntType<T> $assign(std.multimapUIntType<T> value) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public std.multimapUIntType<T> clone() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public Iterator<std_pair.pairUIntType<T>> iterator() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public void $destroy() {
    clear();
  }
  
    
  private boolean isDataPointerLike() {
    return (defaultValue == null);
  }
    
  public void clear() {
    if (!isDataPointerLike()) {      
      for (Map.Entry<Integer, Values<std_pair.pairUIntType<T>>> entry : treeMap.entrySet()) {
        entry.getValue().$destroy();
      }
    }
    treeMap.clear();
  }  
}
