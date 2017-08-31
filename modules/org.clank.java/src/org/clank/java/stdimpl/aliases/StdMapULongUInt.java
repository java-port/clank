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
public abstract class StdMapULongUInt extends NativeTrace.CreateDestroy$Tracker
  implements Native.NativePOD<std.mapULongUInt>, 
    Iterable<std.pairULongUInt>, 
    Destructors.ClassWithDestructor {
    
    protected int defaultValue;
    
    protected TreeMap<Long, std.pairULongUInt> treeMap;

    protected StdMapULongUInt(int defaultValue) {
      this(null, defaultValue);
    }

    protected StdMapULongUInt(Comparator<Long> comparator, int defaultValue) {
      if (comparator == null) {
        comparator = Native::$compare_type_ulong;
      }
      this.treeMap = new TreeMap(comparator);
      assert true : "non cloneable class for defaultValue " + NativeTrace.getIdentityStr(defaultValue);
      this.defaultValue = defaultValue;
    }
    
    protected StdMapULongUInt(std.mapULongUInt other) {
      this((Comparator<Long>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
    }

    protected StdMapULongUInt(JavaDifferentiators.JD$Move _dparam, std.mapULongUInt other) {
      this((Comparator<Long>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
      other.$destroy();
      other.treeMap = null;
    }

    public Comparator<? super Long> keyComparator() {
      return treeMap.comparator();
    }
    
    @Override
    public std.mapULongUInt $assign(std.mapULongUInt other) {
      assert other.checkAlive();
      assert checkAlive();
      clear();
      for (Map.Entry<Long, std.pairULongUInt> entry : other.treeMap.entrySet()) {
        this.treeMap.put($cloneKeyIfNeed(entry.getKey()), $Clone(entry.getValue()));
      }     
      return (std.mapULongUInt) this;
    }
    
    public void swap(std.mapULongUInt other) {
      assert other.checkAlive();
      assert checkAlive();
      TreeMap<Long, std.pairULongUInt> tmpMap = this.treeMap;
      this.treeMap = other.treeMap;
      other.treeMap = tmpMap;
      
      int tmpDefVal = this.defaultValue;
      this.defaultValue = other.defaultValue;
      other.defaultValue = tmpDefVal;
    }
    
    public int $at_T$C$R(Long key) {
      assert checkAlive();
      return $at(key);
    }
    
    public int $at_T$RR(Long key) {
      assert checkAlive();
      return $at(key);
    }

    public int $at(Long key) {
      assert checkAlive();
      std.pairULongUInt out = treeMap.get(key);
      if (out == null) {
        out = std.make_pair_ulong_uint($cloneKeyIfNeed(key), $cloneValIfNeed(defaultValue));
        treeMap.put($cloneKeyIfNeed(key), out);
      }
      return out.second;
    }

    public void $set(Long key, int val) {
      assert checkAlive();
      treeMap.put($cloneKeyIfNeed(key), std.make_pair_ulong_uint($cloneKeyIfNeed(key), $cloneValIfNeed(val)));
    }
    
    public uint$ref ref$at(final Long key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        treeMap.put($cloneKeyIfNeed(key), std.make_pair_ulong_uint($cloneKeyIfNeed(key), $cloneValIfNeed(defaultValue)));
      }
      return new uint$ref() {

        @Override
        public int $deref() {
          assert checkAlive();
          return treeMap.get(key).second;
        }

        @Override
        public int $set(int value) {
          assert checkAlive();
          treeMap.get(key).second = $tryAssign(treeMap.get(key).second, value, isDataPointerLike());
          return value;
        }

        @Override
        public uint$ptr deref$ptr() {
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
        for (Map.Entry<Long, std.pairULongUInt> entry : treeMap.entrySet()) {
          if (!isKeyPointerLike()) {
            Native.destroy(entry.getKey());
          }
          Native.destroy(entry.getValue());
        }
      }
      treeMap.clear();
    }

    public std.pairTypeBool<iterator> insert$T$RR(std.pairULongUInt /*&&*/ val) {
      assert checkAlive();
      Long Key = $cloneKeyIfNeed(val.first);
      boolean newElement = !treeMap.containsKey(Key);
      treeMap.put(Key, $Move(val));
      return std.make_pair_Ptr_bool(find(Key), newElement);
    }
    
    public final std.pairTypeBool<iterator> insert$T(std.pairULongUInt val) {
      assert checkAlive();
      return insert(val);
    }
    public std.pairTypeBool<iterator> insert(std.pairULongUInt val) {
      assert checkAlive();
      boolean newElement = !treeMap.containsKey(val.first);
      treeMap.put($cloneKeyIfNeed(val.first), $Clone(val));
      return std.make_pair_Ptr_bool(find(val.first), newElement);
    }
    
    public void insert(type$iterator<?, std.pairULongUInt> I, type$iterator<?, std.pairULongUInt> E) {
      assert checkAlive();
      for (; $noteq_iter(I, E); I.$preInc())  {
        std.pairULongUInt val = I.$star();
        treeMap.put($cloneKeyIfNeed(val.first), $Clone(val));
      }
    }
    
    public void erase(iterator position) {
      assert checkAlive();
      Native.destroy(position.$star());
      position.erase();
    }
    
    public boolean erase(Long key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return false;
      }
      Map.Entry<Long, std.pairULongUInt> entry = treeMap.ceilingEntry(key);
      if (!isKeyPointerLike()) {
        Native.destroy(entry.getKey());
      }
      Native.destroy(entry.getValue());
      treeMap.remove(key);
      return true;
    }

    public iterator lower_bound(Long key) {
      assert checkAlive();
      Long lowerBoundKey = treeMap.ceilingKey(key);
      return lowerBoundKey != null ? find(lowerBoundKey) : end();
    }
    
    public iterator upper_bound(Long key) {
      assert checkAlive();
      Long upperBoundKey = treeMap.higherKey(key);
      return upperBoundKey != null ? find(upperBoundKey) : end();
    }   

    public iterator begin$Const() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, true);
    }

    public iterator end$Const() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, true);
    }

    public iterator begin() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, false);
    }

    public iterator end() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, false);
    }
    
    @Override
    public Iterator<std.pairULongUInt> iterator() {
      assert checkAlive();
      return new JavaIterator<>(begin(), end());
    }

    public boolean count(Long key) {
      assert checkAlive();
      return treeMap.containsKey(key);
    }    

    public boolean replaceValueReference(Long key, int val) {
      assert checkAlive();
      std.pairULongUInt entry = treeMap.get(key);
      assert entry != null : "must be called only for existing entry " + key + " => " + val;
      entry.second = val;
      return true;
    }
    
    public final iterator find$Const(Long key) {
      assert checkAlive();
      return find(key);
    }
    public iterator find(Long key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return end();
      } else {
        return new iterator(treeMap, treeMap.ceilingEntry(key), defaultValue, false);
      }
    }    

    @Override
    public boolean $eq(std.mapULongUInt other) {
      if (this.size() != other.size()) {
        return false;
      }
      // false because iterator iterates over pairs
      return std.equal(this.begin(), this.end(), other.begin(), false); 
    }

    @Override
    public std.mapULongUInt clone() {
      assert checkAlive();
      std.mapULongUInt out = new std.mapULongUInt((std.mapULongUInt) this);
      assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
      return out;
    }

    public static class iterator implements type$iterator<iterator, std.pairULongUInt> {
      
      private final int defaultValue;
      
      private final TreeMap<Long, std.pairULongUInt> map;

      private final boolean _const;
      
      // helpers
      
      private Map.Entry<Long, std.pairULongUInt> currentEntry;

      public iterator(iterator other) {
        //assert other.map.checkAlive();
        this.defaultValue = $tryClone(other.defaultValue);
        this.map = $tryClone(other.map);
        this.currentEntry = $tryClone(other.currentEntry);
        this._const = other._const;
      }

      public iterator(JavaDifferentiators.JD$Move _dparam, iterator other) {
        //assert other.map.checkAlive();
        this.defaultValue = other.defaultValue;
        this.map = other.map;
        this.currentEntry = other.currentEntry;
        this._const = other._const;
      }

      private iterator(TreeMap<Long, std.pairULongUInt> map, Map.Entry<Long, std.pairULongUInt> curr, int defaultValue, boolean asConst) {
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
      
      public std.pairULongUInt $arrow() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }      

      @Override
      public std.pairULongUInt $star() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }

      @Override
      public type$ref<std.pairULongUInt> star$ref() {
        //assert map.checkAlive();
        return new type$ref<std.pairULongUInt>() {
          
          private final Map.Entry<Long, std.pairULongUInt> localEntry = currentEntry;

          @Override
          public std.pairULongUInt $deref() {
            //assert map.checkAlive();
            return localEntry.getValue();
          }

          @Override
          public std.pairULongUInt $set(std.pairULongUInt value) {
            //assert map.checkAlive();
            assert map.comparator().compare(value.first, localEntry.getKey()) == 0 : "Trying to change key of entry via iterator!";
            localEntry.getValue().second = $tryAssign(localEntry.getValue().second, value.second, isDataPointerLike());
            return value;
          }

          @Override
          public type$ptr<std.pairULongUInt> deref$ptr() {
            //assert map.checkAlive();
            throw new UnsupportedOperationException("Not supported.");
          }
        };
      }

      @Override
      public iterator $preInc() {
        //assert map.checkAlive();
        currentEntry = map.higherEntry(currentEntry.getKey());
        return this;
      }
      
      @Override
      public iterator $postInc() {
        //assert map.checkAlive();
        iterator cloned = Native.$Clone(this);
        $preInc();
        return cloned;
      }      

      @Override
      public iterator clone() {
        //assert map.checkAlive();
        return new iterator(map, currentEntry, defaultValue, false);
      }
      
      @Override
      public iterator const_clone() {
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
      public int $sub(iterator iter) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public iterator $preDec() {
        //assert map.checkAlive();
        if (currentEntry == null) {
          currentEntry = map.lastEntry();
        } else {
          currentEntry = map.lowerEntry(currentEntry.getKey());
        }
        return this;
      }

      @Override
      public iterator $postDec() {
        //assert map.checkAlive();
        iterator cloned = Native.$Clone(this);
        $preDec();
        return cloned;
      }

      @Override
      public iterator $inc(int amount) {
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
      public iterator $dec(int amount) {
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
      public iterator $add(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public iterator $sub(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }
      
      private boolean isDataPointerLike() {
        return false;
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
      return false;
    }
    
    private int $cloneValIfNeed(int Val) {
      return isDataPointerLike() ? Val : $tryClone(Val);
    }

    @Override
    public String toString() {
      return "StdMapULongUInt " + (super.is$destroyed()?"DESTROYED":"") + "{" + treeMap + "}";
    }

    protected final boolean checkAlive() {
      return check$Alive();
    }  
    
}
