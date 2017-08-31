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
package org.clank.java.stdimpl.aliases;

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
 * 
 * @author Petr Kudryavtsev <petrk@netbeans.org>
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/java/stdimpl/aliases/templates/StdMap.tpl")
//</editor-fold>
public abstract class StdMapULongPtr<ValueT> extends NativeTrace.CreateDestroy$Tracker
  implements Native.NativePOD<std.mapULongPtr<ValueT>>, 
    Iterable<std.pairULongPtr<ValueT>>, 
    Destructors.ClassWithDestructor {
    
    protected ValueT defaultValue;
    
    protected TreeMap<Long, std.pairULongPtr<ValueT>> treeMap;

    protected StdMapULongPtr(ValueT defaultValue) {
      this(null, defaultValue);
    }

    protected StdMapULongPtr(Comparator<Long> comparator, ValueT defaultValue) {
      if (comparator == null) {
        comparator = Native::$compare_type_ulong;
      }
      this.treeMap = new TreeMap(comparator);
      assert (defaultValue == null) : "non cloneable class for defaultValue " + NativeTrace.getIdentityStr(defaultValue);
      this.defaultValue = defaultValue;
    }
    
    protected StdMapULongPtr(std.mapULongPtr<ValueT> other) {
      this((Comparator<Long>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
    }

    protected StdMapULongPtr(JavaDifferentiators.JD$Move _dparam, std.mapULongPtr<ValueT> other) {
      this((Comparator<Long>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
      other.$destroy();
      other.treeMap = null;
    }

    public Comparator<? super Long> keyComparator() {
      return treeMap.comparator();
    }
    
    @Override
    public std.mapULongPtr<ValueT> $assign(std.mapULongPtr<ValueT> other) {
      assert other.checkAlive();
      assert checkAlive();
      clear();
      for (Map.Entry<Long, std.pairULongPtr<ValueT>> entry : other.treeMap.entrySet()) {
        this.treeMap.put($cloneKeyIfNeed(entry.getKey()), $Clone(entry.getValue()));
      }     
      return (std.mapULongPtr<ValueT>) this;
    }
    
    public void swap(std.mapULongPtr<ValueT> other) {
      assert other.checkAlive();
      assert checkAlive();
      TreeMap<Long, std.pairULongPtr<ValueT>> tmpMap = this.treeMap;
      this.treeMap = other.treeMap;
      other.treeMap = tmpMap;
      
      ValueT tmpDefVal = this.defaultValue;
      this.defaultValue = other.defaultValue;
      other.defaultValue = tmpDefVal;
    }
    
    public ValueT $at_T$C$R(Long key) {
      assert checkAlive();
      return $at(key);
    }
    
    public ValueT $at_T$RR(Long key) {
      assert checkAlive();
      return $at(key);
    }

    public ValueT $at(Long key) {
      assert checkAlive();
      std.pairULongPtr<ValueT> out = treeMap.get(key);
      if (out == null) {
        out = std.make_pair_ulong_Ptr($cloneKeyIfNeed(key), $cloneValIfNeed(defaultValue));
        treeMap.put($cloneKeyIfNeed(key), out);
      }
      return out.second;
    }

    public void $set(Long key, ValueT val) {
      assert checkAlive();
      treeMap.put($cloneKeyIfNeed(key), std.make_pair_ulong_Ptr($cloneKeyIfNeed(key), $cloneValIfNeed(val)));
    }
    
    public type$ref<ValueT> ref$at(final Long key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        treeMap.put($cloneKeyIfNeed(key), std.make_pair_ulong_Ptr($cloneKeyIfNeed(key), $cloneValIfNeed(defaultValue)));
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
          treeMap.get(key).second = $tryAssign(treeMap.get(key).second, value, isDataPointerLike());
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
      if (!isKeyPointerLike() || !isDataPointerLike()) {
        for (Map.Entry<Long, std.pairULongPtr<ValueT>> entry : treeMap.entrySet()) {
          if (!isKeyPointerLike()) {
            Native.destroy(entry.getKey());
          }
          Native.destroy(entry.getValue());
        }
      }
      treeMap.clear();
    }

    public std.pairTypeBool<iterator<ValueT>> insert$T$RR(std.pairULongPtr<ValueT> /*&&*/ val) {
      assert checkAlive();
      Long Key = $cloneKeyIfNeed(val.first);
      boolean newElement = !treeMap.containsKey(Key);
      treeMap.put(Key, $Move(val));
      return std.make_pair_Ptr_bool(find(Key), newElement);
    }
    
    public final std.pairTypeBool<iterator<ValueT>> insert$T(std.pairULongPtr<ValueT> val) {
      assert checkAlive();
      return insert(val);
    }
    public std.pairTypeBool<iterator<ValueT>> insert(std.pairULongPtr<ValueT> val) {
      assert checkAlive();
      boolean newElement = !treeMap.containsKey(val.first);
      treeMap.put($cloneKeyIfNeed(val.first), $Clone(val));
      return std.make_pair_Ptr_bool(find(val.first), newElement);
    }
    
    public void insert(type$iterator<?, std.pairULongPtr<ValueT>> I, type$iterator<?, std.pairULongPtr<ValueT>> E) {
      assert checkAlive();
      for (; $noteq_iter(I, E); I.$preInc())  {
        std.pairULongPtr<ValueT> val = I.$star();
        treeMap.put($cloneKeyIfNeed(val.first), $Clone(val));
      }
    }
    
    public void erase(iterator<ValueT> position) {
      assert checkAlive();
      Native.destroy(position.$star());
      position.erase();
    }
    
    public boolean erase(Long key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return false;
      }
      Map.Entry<Long, std.pairULongPtr<ValueT>> entry = treeMap.ceilingEntry(key);
      if (!isKeyPointerLike()) {
        Native.destroy(entry.getKey());
      }
      Native.destroy(entry.getValue());
      treeMap.remove(key);
      return true;
    }

    public iterator<ValueT> lower_bound(Long key) {
      assert checkAlive();
      Long lowerBoundKey = treeMap.ceilingKey(key);
      return lowerBoundKey != null ? find(lowerBoundKey) : end();
    }
    
    public iterator<ValueT> upper_bound(Long key) {
      assert checkAlive();
      Long upperBoundKey = treeMap.higherKey(key);
      return upperBoundKey != null ? find(upperBoundKey) : end();
    }   

    public iterator<ValueT> begin$Const() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, true);
    }

    public iterator<ValueT> end$Const() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, true);
    }

    public iterator<ValueT> begin() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, false);
    }

    public iterator<ValueT> end() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, false);
    }
    
    @Override
    public Iterator<std.pairULongPtr<ValueT>> iterator() {
      assert checkAlive();
      return new JavaIterator<>(begin(), end());
    }

    public boolean count(Long key) {
      assert checkAlive();
      return treeMap.containsKey(key);
    }    

    public boolean replaceValueReference(Long key, ValueT val) {
      assert checkAlive();
      std.pairULongPtr<ValueT> entry = treeMap.get(key);
      assert entry != null : "must be called only for existing entry " + key + " => " + val;
      entry.second = val;
      return true;
    }
    
    public final iterator<ValueT> find$Const(Long key) {
      assert checkAlive();
      return find(key);
    }
    public iterator<ValueT> find(Long key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return end();
      } else {
        return new iterator(treeMap, treeMap.ceilingEntry(key), defaultValue, false);
      }
    }    

    @Override
    public boolean $eq(std.mapULongPtr<ValueT> other) {
      if (this.size() != other.size()) {
        return false;
      }
      // false because iterator iterates over pairs
      return std.equal(this.begin(), this.end(), other.begin(), false); 
    }

    @Override
    public std.mapULongPtr<ValueT> clone() {
      assert checkAlive();
      std.mapULongPtr<ValueT> out = new std.mapULongPtr<ValueT>((std.mapULongPtr<ValueT>) this);
      assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
      return out;
    }

    public static class iterator<ValueT> implements type$iterator<iterator<ValueT>, std.pairULongPtr<ValueT>> {
      
      private final ValueT defaultValue;
      
      private final TreeMap<Long, std.pairULongPtr<ValueT>> map;

      private final boolean _const;
      
      // helpers
      
      private Map.Entry<Long, std.pairULongPtr<ValueT>> currentEntry;

      public iterator(iterator<ValueT> other) {
        //assert other.map.checkAlive();
        this.defaultValue = $tryClone(other.defaultValue);
        this.map = $tryClone(other.map);
        this.currentEntry = $tryClone(other.currentEntry);
        this._const = other._const;
      }

      public iterator(JavaDifferentiators.JD$Move _dparam, iterator<ValueT> other) {
        //assert other.map.checkAlive();
        this.defaultValue = other.defaultValue;
        this.map = other.map;
        this.currentEntry = other.currentEntry;
        this._const = other._const;
      }

      private iterator(TreeMap<Long, std.pairULongPtr<ValueT>> map, Map.Entry<Long, std.pairULongPtr<ValueT>> curr, ValueT defaultValue, boolean asConst) {
        //assert map.checkAlive();
        this.defaultValue = defaultValue;
        this.map = map;
        this.currentEntry = curr;
        this._const = asConst;
      }
      
      private Long getKey() {
        //assert map.checkAlive();
        return currentEntry.getKey();
      }
      
      private void erase() {
        //assert map.checkAlive();
        // TODO? check if next and prev will get the next value
        map.remove(currentEntry.getKey());
      }      
      
      public std.pairULongPtr<ValueT> $arrow() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }      

      @Override
      public std.pairULongPtr<ValueT> $star() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }

      @Override
      public type$ref<std.pairULongPtr<ValueT>> star$ref() {
        //assert map.checkAlive();
        return new type$ref<std.pairULongPtr<ValueT>>() {
          
          private final Map.Entry<Long, std.pairULongPtr<ValueT>> localEntry = currentEntry;

          @Override
          public std.pairULongPtr<ValueT> $deref() {
            //assert map.checkAlive();
            return localEntry.getValue();
          }

          @Override
          public std.pairULongPtr<ValueT> $set(std.pairULongPtr<ValueT> value) {
            //assert map.checkAlive();
            assert map.comparator().compare(value.first, localEntry.getKey()) == 0 : "Trying to change key of entry via iterator!";
            localEntry.getValue().second = $tryAssign(localEntry.getValue().second, value.second, isDataPointerLike());
            return value;
          }

          @Override
          public type$ptr<std.pairULongPtr<ValueT>> deref$ptr() {
            //assert map.checkAlive();
            throw new UnsupportedOperationException("Not supported.");
          }
        };
      }

      @Override
      public iterator<ValueT> $preInc() {
        //assert map.checkAlive();
        currentEntry = map.higherEntry(currentEntry.getKey());
        return this;
      }
      
      @Override
      public iterator<ValueT> $postInc() {
        //assert map.checkAlive();
        iterator<ValueT> cloned = Native.$Clone(this);
        $preInc();
        return cloned;
      }      

      @Override
      public iterator<ValueT> clone() {
        //assert map.checkAlive();
        return new iterator(map, currentEntry, defaultValue, false);
      }
      
      @Override
      public iterator<ValueT> const_clone() {
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
      public int $sub(iterator<ValueT> iter) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public iterator<ValueT> $preDec() {
        //assert map.checkAlive();
        if (currentEntry == null) {
          currentEntry = map.lastEntry();
        } else {
          currentEntry = map.lowerEntry(currentEntry.getKey());
        }
        return this;
      }

      @Override
      public iterator<ValueT> $postDec() {
        //assert map.checkAlive();
        iterator<ValueT> cloned = Native.$Clone(this);
        $preDec();
        return cloned;
      }

      @Override
      public iterator<ValueT> $inc(int amount) {
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
      public iterator<ValueT> $dec(int amount) {
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
      public iterator<ValueT> $add(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public iterator<ValueT> $sub(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }
      
      private boolean isDataPointerLike() {
        return true;
      }      
    }

    @Override
    public void $destroy() {
      assert checkAlive();
      clear();
      super.set$destroyed();
    }

    private boolean isKeyPointerLike() {
      return false;
    }
    
    private Long $cloneKeyIfNeed(Long Key) {
      return isKeyPointerLike() ? Key : $tryClone(Key);
    }
    
    private boolean isDataPointerLike() {
      return true;
    }
    
    private ValueT $cloneValIfNeed(ValueT Val) {
      return isDataPointerLike() ? Val : $tryClone(Val);
    }

    @Override
    public String toString() {
      return "StdMapULongPtr " + (super.is$destroyed()?"DESTROYED":"") + "{" + treeMap + "}";
    }

    protected final boolean checkAlive() {
      return check$Alive();
    }  
    
}
