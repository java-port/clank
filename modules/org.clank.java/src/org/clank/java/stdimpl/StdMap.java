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
import java.util.Map;
import java.util.TreeMap;
import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators;
import org.clank.support.Native;
import static org.clank.support.Native.*;
import org.clank.support.aliases.*;
import org.clank.support.NativeTrace;

/** 
 * Notes:
 *  [1] assignment is not fully correct (no checks for assignable interface)
 *  [2] no destruction of keys
 * 
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/java/stdimpl/aliases/templates/StdMap.tpl")
//</editor-fold>
@Deprecated//use StdMap(Type|Ptr)(Type|Ptr) specializations
public abstract class StdMap<KeyT, ValueT> extends NativeTrace.CreateDestroy$Tracker
  implements Native.NativePOD<StdMap<KeyT, ValueT>>, 
    Iterable<std.pair<KeyT, ValueT>>, 
    Destructors.ClassWithDestructor {
    
    protected ValueT defaultValue;
    
    protected TreeMap<KeyT, std.pair<KeyT, ValueT>> treeMap;
    
    private static class DefaultComparator<KeyT> implements Comparator<KeyT> {
      @Override
      public int compare(KeyT o1, KeyT o2) {
        if (o1 instanceof Native.ComparableLower) {
          if (((Native.ComparableLower) o1).$less(o2)) {
            return -1;
          }
          return ((Native.ComparableLower) o2).$less(o1) ? 1 : 0;
        } else if (o1 instanceof Comparable) {
          return ((Comparable) o1).compareTo(o2);
        } else {
          throw new UnsupportedOperationException("NO ComparableLower: " + o1.getClass() + " vs. " + o2.getClass());
        }
      }
    }

    protected StdMap(ValueT defaultValue) {
      this(null, defaultValue);
    }

    protected StdMap(Comparator<KeyT> comparator, ValueT defaultValue) {
      this.treeMap = new TreeMap(comparator != null ? comparator : new DefaultComparator<KeyT>());
      assert (defaultValue == null) || ($tryClone(defaultValue) != defaultValue) : "non cloneable class for defaultValue " + NativeTrace.getIdentityStr(defaultValue);
      this.defaultValue = defaultValue;
    }
    
    protected StdMap(StdMap<KeyT, ValueT> other) {
      this((Comparator<KeyT>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
    }

    protected StdMap(JavaDifferentiators.JD$Move _dparam, StdMap<KeyT, ValueT> other) {
      this((Comparator<KeyT>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
      other.$destroy();
      other.treeMap = null;
    }

    @Override
    public StdMap<KeyT, ValueT> $assign(StdMap<KeyT, ValueT> other) {
      assert other.checkAlive();
      assert checkAlive();
      clear();
      for (Map.Entry<KeyT, std.pair<KeyT, ValueT>> entry : other.treeMap.entrySet()) {
        this.treeMap.put(entry.getKey(), std.make_pair(entry.getKey(), isDataPointerLike() ? entry.getValue().second : $tryClone(entry.getValue().second)));
      }     
      return (StdMap<KeyT, ValueT>) this;
    }
    
    public void swap(StdMap<KeyT, ValueT> other) {
      assert other.checkAlive();
      assert checkAlive();
      TreeMap<KeyT, std.pair<KeyT, ValueT>> tmpMap = this.treeMap;
      this.treeMap = other.treeMap;
      other.treeMap = tmpMap;
      
      ValueT tmpDefVal = this.defaultValue;
      this.defaultValue = other.defaultValue;
      other.defaultValue = tmpDefVal;
    }
    
    public ValueT $at_T$C$R(KeyT key) {
      assert checkAlive();
      return $at(key);
    }
    
    public ValueT $at_T$RR(KeyT key) {
      assert checkAlive();
      return $at(key);
    }

    public ValueT $at(KeyT key) {
      assert checkAlive();
      std.pair<KeyT, ValueT> out = treeMap.get(key);
      if (out == null) {
        out = std.make_pair(key, $tryClone(defaultValue));
        treeMap.put(key, out);
      }
      return out.second;
    }

    public void $set(KeyT key, ValueT val) {
      assert checkAlive();
      treeMap.put(key, std.make_pair(key, isDataPointerLike() ? val : $tryClone(val)));
    }
    
    public type$ref<ValueT> ref$at(final KeyT key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        treeMap.put(key, std.make_pair(key, $tryClone(defaultValue)));
      }
      return new type$ref<ValueT>() {

        @Override
        public ValueT $deref() {
          assert checkAlive();
          return treeMap.get(key).second;
        }

        @Override
        public ValueT $set(ValueT value) {
          assert checkAlive();
          treeMap.get(key).second = (isDataPointerLike() ? value : $tryClone(value));
          return value;
        }

        @Override
        public type$ptr<ValueT> deref$ptr() {
          assert checkAlive();
          throw new UnsupportedOperationException("Not supported.");
        }
      };
    }

    public /*size_t*/int size() {
      assert checkAlive();
      return treeMap.size();
    }
    
    public boolean empty() {
      assert checkAlive();
      return treeMap.isEmpty();
    } 

    public void clear() {
      assert checkAlive();
      if (!isDataPointerLike()) {
        for (Map.Entry<KeyT, std.pair<KeyT, ValueT>> entry : treeMap.entrySet()) {
          Native.destroy(entry.getValue().second);
        }
      }
      treeMap.clear();
    }

    public std.pairTypeBool<iterator<KeyT, ValueT>> insert$T$RR(std.pair<KeyT, ValueT> /*&&*/ val) {
      assert checkAlive();
      boolean newElement = !treeMap.containsKey(val.first);
      treeMap.put(val.first, std.make_pair(val.first, isDataPointerLike() ? val.second :  $tryMove(val.second)));
      return std.make_pair_T_bool(find(val.first), newElement);
    }
    
    public final std.pairTypeBool<iterator<KeyT, ValueT>> insert$T(std.pair<KeyT, ValueT> val) {
      assert checkAlive();
      return insert(val);
    }
    public std.pairTypeBool<iterator<KeyT, ValueT>> insert(std.pair<KeyT, ValueT> val) {
      assert checkAlive();
      boolean newElement = !treeMap.containsKey(val.first);
      treeMap.put(val.first, std.make_pair(val.first, isDataPointerLike() ? val.second :  $tryClone(val.second)));
      return std.make_pair_T_bool(find(val.first), newElement);
    }
    
    public void insert(type$iterator<?, std.pair<KeyT, ValueT>> I, type$iterator<?, std.pair<KeyT, ValueT>> E) {
      assert checkAlive();
      for (; $noteq_iter(I, E); I.$preInc())  {
        std.pair<KeyT, ValueT> val = I.$star();
        treeMap.put(val.first, std.make_pair(val.first, isDataPointerLike() ? val.second : $tryClone(val.second)));
      }
    }
    
    public void erase(iterator<KeyT, ValueT> position) {
      assert checkAlive();
      if (!isDataPointerLike()) {
        Native.destroy(position.$star().second);
      }
      position.erase();
    }
    
    public boolean erase(KeyT key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return false;
      }
      if (!isDataPointerLike()) {
        Native.destroy(treeMap.get(key).second);
      }      
      treeMap.remove(key);
      return true;
    }

    public iterator<KeyT, ValueT> lower_bound(KeyT key) {
      assert checkAlive();
      KeyT lowerBoundKey = treeMap.ceilingKey(key);
      return lowerBoundKey != null ? find(lowerBoundKey) : end();
    }
    
    public iterator<KeyT, ValueT> upper_bound(KeyT key) {
      assert checkAlive();
      iterator<KeyT, ValueT> upperBound = lower_bound(key);
      while (upperBound.$noteq(end()) && treeMap.comparator().compare(key, upperBound.getKey()) >= 0) {
        upperBound.$preInc();
      }
      return upperBound;
    }   

    public iterator<KeyT, ValueT> begin$Const() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, true);
    }

    public iterator<KeyT, ValueT> end$Const() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, true);
    }

    public iterator<KeyT, ValueT> begin() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, false);
    }

    public iterator<KeyT, ValueT> end() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, false);
    }
    
    @Override
    public Iterator<std.pair<KeyT, ValueT>> iterator() {
      assert checkAlive();
      return new JavaIterator<>(begin(), end());
    }

    public boolean count(KeyT key) {
      assert checkAlive();
      return treeMap.containsKey(key);
    }    

    public boolean replaceValueReference(KeyT key, ValueT val) {
      assert checkAlive();
      std.pair<KeyT, ValueT> entry = treeMap.get(key);
      assert entry != null : "must be called only for existing entry " + key + " => " + val;
      entry.second = val;
      return true;
    }
    
    public final iterator<KeyT, ValueT> find$Const(KeyT key) {
      assert checkAlive();
      return find(key);
    }
    public iterator<KeyT, ValueT> find(KeyT key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return end();
      } else {
        return new iterator(treeMap, treeMap.ceilingEntry(key), defaultValue, false);
      }
    }    

    @Override
    public StdMap<KeyT, ValueT> clone() {
      assert checkAlive();
      throw new UnsupportedOperationException("forgot to override clone in " + this.getClass());
    }

    public static class iterator<KeyT, ValueT> implements type$iterator<iterator<KeyT, ValueT>, std.pair<KeyT, ValueT>> {
      
      private final ValueT defaultValue;
      
      private final TreeMap<KeyT, std.pair<KeyT, ValueT>> map;

      private final boolean _const;
      
      // helpers
      
      private Map.Entry<KeyT, std.pair<KeyT, ValueT>> currentEntry;

      public iterator(iterator<KeyT, ValueT> other) {
        //assert other.map.checkAlive();
        this.defaultValue = $tryClone(other.defaultValue);
        this.map = $tryClone(other.map);
        this.currentEntry = $tryClone(other.currentEntry);
        this._const = other._const;
      }

      public iterator(JavaDifferentiators.JD$Move _dparam, iterator<KeyT, ValueT> other) {
        //assert other.map.checkAlive();
        this.defaultValue = other.defaultValue;
        this.map = other.map;
        this.currentEntry = other.currentEntry;
        this._const = other._const;
      }

      private iterator(TreeMap<KeyT, std.pair<KeyT, ValueT>> map, Map.Entry<KeyT, std.pair<KeyT, ValueT>> curr, ValueT defaultValue, boolean asConst) {
        //assert map.checkAlive();
        this.defaultValue = defaultValue;
        this.map = map;
        this.currentEntry = curr;
        this._const = asConst;
      }
      
      private KeyT getKey() {
        //assert map.checkAlive();
        return currentEntry.getKey();
      }
      
      private void erase() {
        //assert map.checkAlive();
        // TODO? check if next and prev will get the next value
        map.remove(currentEntry.getKey());
      }      
      
      public std.pair<KeyT, ValueT> $arrow() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }      

      @Override
      public std.pair<KeyT, ValueT> $star() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }

      @Override
      public type$ref<std.pair<KeyT, ValueT>> star$ref() {
        //assert map.checkAlive();
        return new type$ref<std.pair<KeyT, ValueT>>() {
          
          private final Map.Entry<KeyT, std.pair<KeyT, ValueT>> localEntry = currentEntry;

          @Override
          public std.pair<KeyT, ValueT> $deref() {
            //assert map.checkAlive();
            return localEntry.getValue();
          }

          @Override
          public std.pair<KeyT, ValueT> $set(std.pair<KeyT, ValueT> value) {
            //assert map.checkAlive();
            assert map.comparator().compare(value.first, localEntry.getKey()) == 0 : "Trying to change key of entry via iterator!";
            localEntry.getValue().second = $tryAssign(localEntry.getValue().second, value.second, isDataPointerLike());
            return value;
          }

          @Override
          public type$ptr<std.pair<KeyT, ValueT>> deref$ptr() {
            //assert map.checkAlive();
            throw new UnsupportedOperationException("Not supported.");
          }
        };
      }

      @Override
      public iterator<KeyT, ValueT> $preInc() {
        //assert map.checkAlive();
        currentEntry = map.higherEntry(currentEntry.getKey());
        return this;
      }
      
      @Override
      public iterator<KeyT, ValueT> $postInc() {
        //assert map.checkAlive();
        iterator<KeyT, ValueT> cloned = Native.$Clone(this);
        $preInc();
        return cloned;
      }      

      @Override
      public iterator<KeyT, ValueT> clone() {
        //assert map.checkAlive();
        return new iterator(map, currentEntry, defaultValue, false);
      }
      
      @Override
      public iterator<KeyT, ValueT> const_clone() {
        //assert map.checkAlive();
        return new iterator(map, currentEntry, defaultValue, true);
      }
      
      @Override
      public boolean $eq(Object other) {
        //assert map.checkAlive();
        if (other instanceof iterator) {
          iterator otherIter = (iterator) other;
          //assert other.map.checkAlive();
          if (otherIter.map == map) {
            if (otherIter.currentEntry == null) {
              return currentEntry == null;
            } else if (currentEntry == null) {
              return otherIter.currentEntry == null;
            } else {
              return Native.$eq(otherIter.currentEntry.getKey(), currentEntry.getKey());
            }
          }
        }
        return false;
      }      

      @Override
      public boolean $noteq(Object other) {
        return !$eq(other);
      }

      @Override
      public int $sub(iterator<KeyT, ValueT> iter) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public iterator<KeyT, ValueT> $preDec() {
        //assert map.checkAlive();
        if (currentEntry == null) {
          currentEntry = map.lastEntry();
        } else {
          currentEntry = map.lowerEntry(currentEntry.getKey());
        }
        return this;
      }

      @Override
      public iterator<KeyT, ValueT> $postDec() {
        //assert map.checkAlive();
        iterator<KeyT, ValueT> cloned = Native.$Clone(this);
        $preDec();
        return cloned;
      }

      @Override
      public iterator<KeyT, ValueT> $inc(int amount) {
        //assert map.checkAlive();
        if (amount == 0) return this;
        if (amount > 0) {
          do {
            $preInc();
          } while (--amount > 0);
          return this;
        } else {
          return $dec(-amount);
        }
      }

      @Override
      public iterator<KeyT, ValueT> $dec(int amount) {
        //assert map.checkAlive();
        if (amount == 0) return this;
        if (amount > 0) {
          do {
            $preDec();
          } while (--amount > 0);
          return this;
        } else {
          return $inc(-amount);
        }
      }

      @Override
      public iterator<KeyT, ValueT> $add(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public iterator<KeyT, ValueT> $sub(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }
      
      private boolean isDataPointerLike() {
        return (defaultValue == null);
      }      
    }

    @Override
    public void $destroy() {
      assert checkAlive();
      clear();
      super.set$destroyed();
    }
    
    private boolean isDataPointerLike() {
      return (defaultValue == null);
    }

    @Override
    public String toString() {
      return "StdMap " + (super.is$destroyed()?"DESTROYED":"") + "{" + treeMap + "}";
    }

    protected final boolean checkAlive() {
      return check$Alive();
    }  
    
}
