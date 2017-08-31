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
public abstract class ${FILE_NAME}${CLASS_SUFFIX} extends NativeTrace.CreateDestroy$Tracker
  implements Native.NativePOD<${DUAL_CLASS}>, 
    Iterable<${PAIR_TYPE}>, 
    Destructors.ClassWithDestructor {
    
    protected ${VALUE_TYPE} defaultValue;
    
    protected TreeMap<${KEY_TYPE}, ${PAIR_TYPE}> treeMap;

    protected ${FILE_NAME}(${VALUE_TYPE} defaultValue) {
      this(null, defaultValue);
    }

    protected ${FILE_NAME}(Comparator<${KEY_TYPE}> comparator, ${VALUE_TYPE} defaultValue) {
      if (comparator == null) {
        comparator = ${DEFAULT_KEYS_COMPARATOR};
      }
      this.treeMap = new TreeMap(comparator);
      assert ${ASSERT_DEFAULT_VALUE} : "non cloneable class for defaultValue " + NativeTrace.getIdentityStr(defaultValue);
      this.defaultValue = defaultValue;
    }
    
    protected ${FILE_NAME}(${DUAL_CLASS} other) {
      this((Comparator<${KEY_TYPE}>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
    }

    protected ${FILE_NAME}(JavaDifferentiators.JD$Move _dparam, ${DUAL_CLASS} other) {
      this((Comparator<${KEY_TYPE}>) other.treeMap.comparator(), other.defaultValue);
      $assign(other);
      other.$destroy();
      other.treeMap = null;
    }

    public Comparator<? super ${KEY_TYPE}> keyComparator() {
      return treeMap.comparator();
    }
    
    @Override
    public ${DUAL_CLASS} $assign(${DUAL_CLASS} other) {
      assert other.checkAlive();
      assert checkAlive();
      clear();
      for (Map.Entry<${KEY_TYPE}, ${PAIR_TYPE}> entry : other.treeMap.entrySet()) {
        this.treeMap.put($cloneKeyIfNeed(entry.getKey()), $Clone(entry.getValue()));
      }     
      return (${DUAL_CLASS}) this;
    }
    
    public void swap(${DUAL_CLASS} other) {
      assert other.checkAlive();
      assert checkAlive();
      TreeMap<${KEY_TYPE}, ${PAIR_TYPE}> tmpMap = this.treeMap;
      this.treeMap = other.treeMap;
      other.treeMap = tmpMap;
      
      ${VALUE_TYPE} tmpDefVal = this.defaultValue;
      this.defaultValue = other.defaultValue;
      other.defaultValue = tmpDefVal;
    }
    
    public ${VALUE_TYPE} $at_T$C$R(${KEY_TYPE} key) {
      assert checkAlive();
      return $at(key);
    }
    
    public ${VALUE_TYPE} $at_T$RR(${KEY_TYPE} key) {
      assert checkAlive();
      return $at(key);
    }

    public ${VALUE_TYPE} $at(${KEY_TYPE} key) {
      assert checkAlive();
      ${PAIR_TYPE} out = treeMap.get(key);
      if (out == null) {
        out = ${PAIR_FACTORY_METHOD}($cloneKeyIfNeed(key), $cloneValIfNeed(defaultValue));
        treeMap.put($cloneKeyIfNeed(key), out);
      }
      return out.second;
    }

    public void $set(${KEY_TYPE} key, ${VALUE_TYPE} val) {
      assert checkAlive();
      treeMap.put($cloneKeyIfNeed(key), ${PAIR_FACTORY_METHOD}($cloneKeyIfNeed(key), $cloneValIfNeed(val)));
    }
    
    public ${VALUE_REF} ref$at(final ${KEY_TYPE} key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        treeMap.put($cloneKeyIfNeed(key), ${PAIR_FACTORY_METHOD}($cloneKeyIfNeed(key), $cloneValIfNeed(defaultValue)));
      }
      return new ${VALUE_REF}() {

        @Override
        public ${VALUE_TYPE} $deref() {
          assert checkAlive();
          return treeMap.get(key).second;
        }

        @Override
        public ${VALUE_TYPE} $set(${VALUE_TYPE} value) {
          assert checkAlive();
          treeMap.get(key).second = $tryAssign(treeMap.get(key).second, value, isDataPointerLike());
          return value;
        }

        @Override
        public ${VALUE_PTR} deref$ptr() {
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
        for (Map.Entry<${KEY_TYPE}, ${PAIR_TYPE}> entry : treeMap.entrySet()) {
          if (!isKeyPointerLike()) {
            Native.destroy(entry.getKey());
          }
          Native.destroy(entry.getValue());
        }
      }
      treeMap.clear();
    }

    public std.pairTypeBool<${ITERATOR}> insert$T$RR(${PAIR_TYPE} /*&&*/ val) {
      assert checkAlive();
      ${KEY_TYPE} Key = $cloneKeyIfNeed(val.first);
      boolean newElement = !treeMap.containsKey(Key);
      treeMap.put(Key, $Move(val));
      return std.make_pair_Ptr_bool(find(Key), newElement);
    }
    
    public final std.pairTypeBool<${ITERATOR}> insert$T(${PAIR_TYPE} val) {
      assert checkAlive();
      return insert(val);
    }
    public std.pairTypeBool<${ITERATOR}> insert(${PAIR_TYPE} val) {
      assert checkAlive();
      boolean newElement = !treeMap.containsKey(val.first);
      treeMap.put($cloneKeyIfNeed(val.first), $Clone(val));
      return std.make_pair_Ptr_bool(find(val.first), newElement);
    }
    
    public void insert(${GENERIC_ITERATOR} I, ${GENERIC_ITERATOR} E) {
      assert checkAlive();
      for (; $noteq_iter(I, E); I.$preInc())  {
        ${PAIR_TYPE} val = I.$star();
        treeMap.put($cloneKeyIfNeed(val.first), $Clone(val));
      }
    }
    
    public void erase(${ITERATOR} position) {
      assert checkAlive();
      Native.destroy(position.$star());
      position.erase();
    }
    
    public boolean erase(${KEY_TYPE} key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return false;
      }
      Map.Entry<${KEY_TYPE}, ${PAIR_TYPE}> entry = treeMap.ceilingEntry(key);
      if (!isKeyPointerLike()) {
        Native.destroy(entry.getKey());
      }
      Native.destroy(entry.getValue());
      treeMap.remove(key);
      return true;
    }

    public ${ITERATOR} lower_bound(${KEY_TYPE} key) {
      assert checkAlive();
      ${KEY_TYPE} lowerBoundKey = treeMap.ceilingKey(key);
      return lowerBoundKey != null ? find(lowerBoundKey) : end();
    }
    
    public ${ITERATOR} upper_bound(${KEY_TYPE} key) {
      assert checkAlive();
      ${KEY_TYPE} upperBoundKey = treeMap.higherKey(key);
      return upperBoundKey != null ? find(upperBoundKey) : end();
    }   

    public ${ITERATOR} begin$Const() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, true);
    }

    public ${ITERATOR} end$Const() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, true);
    }

    public ${ITERATOR} begin() {
      assert checkAlive();
      return new iterator(treeMap, treeMap.firstEntry(), defaultValue, false);
    }

    public ${ITERATOR} end() {
      assert checkAlive();
      return new iterator(treeMap, null, defaultValue, false);
    }
    
    @Override
    public Iterator<${PAIR_TYPE}> iterator() {
      assert checkAlive();
      return new JavaIterator<>(begin(), end());
    }

    public boolean count(${KEY_TYPE} key) {
      assert checkAlive();
      return treeMap.containsKey(key);
    }    

    public boolean replaceValueReference(${KEY_TYPE} key, ${VALUE_TYPE} val) {
      assert checkAlive();
      ${PAIR_TYPE} entry = treeMap.get(key);
      assert entry != null : "must be called only for existing entry " + key + " => " + val;
      entry.second = val;
      return true;
    }
    
    public final ${ITERATOR} find$Const(${KEY_TYPE} key) {
      assert checkAlive();
      return find(key);
    }
    public ${ITERATOR} find(${KEY_TYPE} key) {
      assert checkAlive();
      if (!treeMap.containsKey(key)) {
        return end();
      } else {
        return new iterator(treeMap, treeMap.ceilingEntry(key), defaultValue, false);
      }
    }    

    @Override
    public boolean $eq(${DUAL_CLASS} other) {
      if (this.size() != other.size()) {
        return false;
      }
      // false because iterator iterates over pairs
      return std.equal(this.begin(), this.end(), other.begin(), false); 
    }

    @Override
    public ${DUAL_CLASS} clone() {
      assert checkAlive();
      ${DUAL_CLASS} out = new ${DUAL_CLASS}((${DUAL_CLASS}) this);
      assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
      return out;
    }

    public static class ${ITERATOR} implements type$iterator<${ITERATOR}, ${PAIR_TYPE}> {
      
      private final ${VALUE_TYPE} defaultValue;
      
      private final TreeMap<${KEY_TYPE}, ${PAIR_TYPE}> map;

      private final boolean _const;
      
      // helpers
      
      private Map.Entry<${KEY_TYPE}, ${PAIR_TYPE}> currentEntry;

      public iterator(${ITERATOR} other) {
        //assert other.map.checkAlive();
        this.defaultValue = $tryClone(other.defaultValue);
        this.map = $tryClone(other.map);
        this.currentEntry = $tryClone(other.currentEntry);
        this._const = other._const;
      }

      public iterator(JavaDifferentiators.JD$Move _dparam, ${ITERATOR} other) {
        //assert other.map.checkAlive();
        this.defaultValue = other.defaultValue;
        this.map = other.map;
        this.currentEntry = other.currentEntry;
        this._const = other._const;
      }

      private iterator(TreeMap<${KEY_TYPE}, ${PAIR_TYPE}> map, Map.Entry<${KEY_TYPE}, ${PAIR_TYPE}> curr, ${VALUE_TYPE} defaultValue, boolean asConst) {
        //assert map.checkAlive();
        this.defaultValue = defaultValue;
        this.map = map;
        this.currentEntry = curr;
        this._const = asConst;
      }
      
      private ${KEY_TYPE} getKey() {
        //assert map.checkAlive();
        return currentEntry.getKey();
      }
      
      private void erase() {
        //assert map.checkAlive();
        // TODO? check if next and prev will get the next value
        map.remove(currentEntry.getKey());
      }      
      
      public ${PAIR_TYPE} $arrow() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }      

      @Override
      public ${PAIR_TYPE} $star() {
        //assert map.checkAlive();
        return currentEntry.getValue();
      }

      @Override
      public type$ref<${PAIR_TYPE}> star$ref() {
        //assert map.checkAlive();
        return new type$ref<${PAIR_TYPE}>() {
          
          private final Map.Entry<${KEY_TYPE}, ${PAIR_TYPE}> localEntry = currentEntry;

          @Override
          public ${PAIR_TYPE} $deref() {
            //assert map.checkAlive();
            return localEntry.getValue();
          }

          @Override
          public ${PAIR_TYPE} $set(${PAIR_TYPE} value) {
            //assert map.checkAlive();
            assert map.comparator().compare(value.first, localEntry.getKey()) == 0 : "Trying to change key of entry via iterator!";
            localEntry.getValue().second = $tryAssign(localEntry.getValue().second, value.second, isDataPointerLike());
            return value;
          }

          @Override
          public type$ptr<${PAIR_TYPE}> deref$ptr() {
            //assert map.checkAlive();
            throw new UnsupportedOperationException("Not supported.");
          }
        };
      }

      @Override
      public ${ITERATOR} $preInc() {
        //assert map.checkAlive();
        currentEntry = map.higherEntry(currentEntry.getKey());
        return this;
      }
      
      @Override
      public ${ITERATOR} $postInc() {
        //assert map.checkAlive();
        ${ITERATOR} cloned = Native.$Clone(this);
        $preInc();
        return cloned;
      }      

      @Override
      public ${ITERATOR} clone() {
        //assert map.checkAlive();
        return new iterator(map, currentEntry, defaultValue, false);
      }
      
      @Override
      public ${ITERATOR} const_clone() {
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
      public int $sub(${ITERATOR} iter) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public ${ITERATOR} $preDec() {
        //assert map.checkAlive();
        if (currentEntry == null) {
          currentEntry = map.lastEntry();
        } else {
          currentEntry = map.lowerEntry(currentEntry.getKey());
        }
        return this;
      }

      @Override
      public ${ITERATOR} $postDec() {
        //assert map.checkAlive();
        ${ITERATOR} cloned = Native.$Clone(this);
        $preDec();
        return cloned;
      }

      @Override
      public ${ITERATOR} $inc(int amount) {
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
      public ${ITERATOR} $dec(int amount) {
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
      public ${ITERATOR} $add(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }

      @Override
      public ${ITERATOR} $sub(int amount) {
        //assert map.checkAlive();
        throw new UnsupportedOperationException("Not supported.");
      }
      
      private boolean isDataPointerLike() {
        return ${IS_DATA_POINTER_LIKE};
      }      
    }

    @Override
    public void $destroy() {
      assert checkAlive();
      clear();
      super.set$destroyed();
    }

    private boolean isKeyPointerLike() {
      return ${IS_KEY_POINTER_LIKE};
    }
    
    private ${KEY_TYPE} $cloneKeyIfNeed(${KEY_TYPE} Key) {
      return isKeyPointerLike() ? Key : $tryClone(Key);
    }
    
    private boolean isDataPointerLike() {
      return ${IS_DATA_POINTER_LIKE};
    }
    
    private ${VALUE_TYPE} $cloneValIfNeed(${VALUE_TYPE} Val) {
      return isDataPointerLike() ? Val : $tryClone(Val);
    }

    @Override
    public String toString() {
      return "${FILE_NAME} " + (super.is$destroyed()?"DESTROYED":"") + "{" + treeMap + "}";
    }

    protected final boolean checkAlive() {
      return check$Alive();
    }  
    
}
