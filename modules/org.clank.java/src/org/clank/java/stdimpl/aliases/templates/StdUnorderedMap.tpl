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

import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.java.stdimpl.aliases.*;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Supplier;
import org.clank.java.impl.AlteredHashMap;
import org.clank.java.impl.CloneableIterator;
import org.clank.java.std;
import org.clank.support.Destructors;
import org.clank.support.Native;
import static org.clank.java.std_unordered_map.*;
import org.clank.support.Converted;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$Move;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Native.$tryAssign;
import org.clank.support.NativeTrace;
import org.clank.support.type$ptr$inout;

/**
 * Unordered map
 */
public class ${FILE_NAME}${CLASS_SUFFIX}
        extends NativeTrace.CreateDestroy$Tracker 
        implements Iterable<${PAIR_TYPE}>, 
          Native.NativePOD<${DUAL_CLASS}>, 
          Destructors.ClassWithDestructor {
  
  protected final ${HASH_FUN_TYPE} HashFun;
  
  protected final ${EQUAL_FUN_TYPE} EqualFun;

  protected final ${VALUE_SUPPLIER} valueSupplier;
  
  protected AlteredHashMap<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> javaMap;

  public ${FILE_NAME}(${HASH_FUN_TYPE} HashFun, ${EQUAL_FUN_TYPE} EqualFun, ${VALUE_SUPPLIER} valueSupplier) {
    this.HashFun = HashFun;
    this.EqualFun = EqualFun;
    this.javaMap = new AlteredHashMap<>();
    this.valueSupplier = valueSupplier;
  }
  
  public ${FILE_NAME}(${DUAL_CLASS} other) {
    this(other.HashFun, other.EqualFun, other.valueSupplier);
    $assign(other);
  }
  
  public ${FILE_NAME}(JD$Move $Param, ${DUAL_CLASS} other) {
    this(other.HashFun, other.EqualFun, other.valueSupplier);
    swap(other);
  }

  @Override
  public final ${DUAL_CLASS} $assign(${DUAL_CLASS} other) {
    assert check$Alive();
    assert this.HashFun == other.HashFun;
    assert this.EqualFun == other.EqualFun;
    this.javaMap.clear();
    for (${PAIR_TYPE} val : other) {
      this.javaMap.put(new ${WRAPPED_KEY_TYPE}($this(), $cloneKeyIfNeed(val.first)), $Clone(val));
    }
    return $this();
  }
  
  public final ${ITERATOR} begin() {
    assert check$Alive();
    return new iterator($this());
  }

  public final ${ITERATOR} begin$Const() {
    return begin();
  }
  
  public final ${ITERATOR} end() {
    assert check$Alive();
    return new iterator(JD$Misc.INSTANCE, $this());
  }

  public final ${ITERATOR} end$Const() {
    return end();
  }
  
  public final boolean empty() {
    assert check$Alive();
    return this.javaMap.isEmpty();
  }
  
  public final int size() {
    assert check$Alive();
    return this.javaMap.size();
  }
  
  public final void clear() {
    assert check$Alive();
    if (!isKeyPointerLike() || !isDataPointerLike()) {
      for (Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> entry : javaMap.entrySet()) {
        if (!isKeyPointerLike()) {
          Native.destroy(entry.getKey());
        }
        Native.destroy(entry.getValue());
      }
    }
    javaMap.clear();
  }
  
  //std::pair<iterator,bool> insert( const value_type& value );
  public final std.pairTypeBool<${ITERATOR}> insert(${PAIR_TYPE} value) {
    assert check$Alive();
    ${WRAPPED_KEY_TYPE} keyToSearch = new ${WRAPPED_KEY_TYPE}($this(), value.first);
    Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return std.make_pair_T_bool(new iterator($this(), existing), false);
    }
    ${WRAPPED_KEY_TYPE} keyToInsert = new ${WRAPPED_KEY_TYPE}($this(), $cloneKeyIfNeed(value.first));
    javaMap.put(keyToInsert, $Clone(value));
    existing = javaMap.getNode(keyToInsert);
    return std.make_pair_T_bool(new iterator($this(), existing), true);
  }
  public final std.pairTypeBool<${ITERATOR}> insert$T(${PAIR_TYPE} value) {
    assert check$Alive();
    return insert(value);
  }
  
  //std::pair<iterator,bool> insert(value_type&& value);
  public final std.pairTypeBool<${ITERATOR}> insert$T$RR(${PAIR_TYPE} /*&&*/ value) {
    assert check$Alive();
    ${WRAPPED_KEY_TYPE} keyToSearch = new ${WRAPPED_KEY_TYPE}($this(), value.first);
    Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return std.make_pair_T_bool(new iterator($this(), existing), false);
    }
    ${WRAPPED_KEY_TYPE} keyToInsert = new ${WRAPPED_KEY_TYPE}($this(), $cloneKeyIfNeed(value.first));
    javaMap.put(keyToInsert, $Move(value));
    existing = javaMap.getNode(keyToInsert);
    return std.make_pair_T_bool(new iterator($this(), existing), true);
  }
  
  //template< class... Args >
  //std::pair<iterator,bool> emplace( Args&&... args );
  public final std.pairTypeBool<${ITERATOR}> emplace(${PAIR_TYPE} value) {
    assert check$Alive();
    ${WRAPPED_KEY_TYPE} keyToSearch = new ${WRAPPED_KEY_TYPE}($this(), value.first);
    Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return std.make_pair_T_bool(new iterator($this(), existing), false);
    }
    ${WRAPPED_KEY_TYPE} keyToInsert = new ${WRAPPED_KEY_TYPE}($this(), $cloneKeyIfNeed(value.first));
    javaMap.put(keyToInsert, value);
    existing = javaMap.getNode(keyToInsert);
    return std.make_pair_T_bool(new iterator($this(), existing), true);
  }

  // size_type erase( const key_type& key );
  public int erase(${KEY_TYPE} key) {
    assert check$Alive();
    ${ITERATOR} pos = find(key);
    if (pos.$noteq(end())) {
      erase(pos);
      return 1;
    }
    return 0;
  }
  
  // iterator erase( const_iterator pos );
  public ${ITERATOR} erase(${ITERATOR} pos) {
    assert check$Alive();
    Native.destroy(pos.$star());
    return pos.remove();
  }
  
  // iterator find( const Key& key );
  public final ${ITERATOR} find(/*const*/ ${KEY_TYPE} /*&*/ key) {
    assert check$Alive();
    ${WRAPPED_KEY_TYPE} keyToSearch = new ${WRAPPED_KEY_TYPE}($this(), key);
    Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return new iterator($this(), existing);
    }
    return end();
  }

  public final ${ITERATOR} find$Const(/*const*/ ${KEY_TYPE} /*&*/ key) {
    return find(key);
  }

  // size_type count( const Key& key ) const;
  public final boolean count(${KEY_TYPE} key) {
    return find(key).$noteq(end());
  }
  
  // void swap( unordered_map& other );
  public final void swap(${DUAL_CLASS} /*&*/other) {
    assert check$Alive();
    assert this.HashFun == other.HashFun;
    assert this.EqualFun == other.EqualFun;
    AlteredHashMap<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> tmp = this.javaMap;
    this.javaMap = other.javaMap;
    other.javaMap = tmp;
  }

  // T& at( const Key& key );
  public ${VALUE_TYPE} at(${KEY_TYPE} key) {
    assert check$Alive();
    return $at(key);
  }

  // T& operator[]( const Key& key );
  public ${VALUE_TYPE} $at_T$C$R(${KEY_TYPE} key) {
    assert check$Alive();
    return $at(key);
  }
  
  // T& operator[]( Key&& key );
  public ${VALUE_TYPE} $at_T$RR(${KEY_TYPE} key) {
    assert check$Alive();
    return $at(key);
  }

  public ${VALUE_TYPE} $at(${KEY_TYPE} key) {
    assert check$Alive();
    ${PAIR_TYPE} out = javaMap.get(new ${WRAPPED_KEY_TYPE}($this(), key));
    if (out == null) {
      out = ${PAIR_FACTORY_METHOD}($cloneKeyIfNeed(key), valueSupplier.get());
      javaMap.put(new ${WRAPPED_KEY_TYPE}($this(), $cloneKeyIfNeed(key)), out);
    }
    return out.second;
  }
  
  public ${VALUE_REF} ref$at(final ${KEY_TYPE} key) {
    assert check$Alive();
    final ${WRAPPED_KEY_TYPE} wrappedKey = new ${WRAPPED_KEY_TYPE}($this(), $cloneKeyIfNeed(key));
    if (!javaMap.containsKey(wrappedKey)) {
      javaMap.put(wrappedKey, ${PAIR_FACTORY_METHOD}($cloneKeyIfNeed(key), valueSupplier.get()));
    }
    return new ${VALUE_REF_IMPL}() {
      @Override
      protected ${VALUE_TYPE} $star$impl() {
        assert check$Alive();
        return javaMap.get(wrappedKey).second;
      }
      
      @Override
      protected ${VALUE_TYPE} $set$impl(${VALUE_TYPE} value) {
        assert check$Alive();
        javaMap.get(wrappedKey).second = $tryAssign(javaMap.get(wrappedKey).second, value, isDataPointerLike());
        return value;
      }
    };
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public final ${VALUE_TYPE} $set(${KEY_TYPE} key, ${VALUE_TYPE} value) {
    return ref$at(key).$set(value);
  }
  
  // size_type bucket_count() const;
  public final int bucket_count() {
    return javaMap.bucketsNumber();
  }

  // size_type bucket( const Key& key ) const;
  public final int bucket(${KEY_TYPE} key) {
    return javaMap.bucketForKey(new ${WRAPPED_KEY_TYPE}($this(), key));
  }

  @Override
  public final Iterator<${PAIR_TYPE}> iterator() {
    assert check$Alive();
    return new JavaIterator(begin(), end());
  }

  @Override
  public ${DUAL_CLASS} clone() {
    assert check$Alive();
    return new ${DUAL_CLASS}($this());
  }

  @Override
  public void $destroy() {
    assert check$Alive();
    clear();
    super.set$destroyed();
  }
  
  // Iterator
  public static final class ${ITERATOR} implements ${GENERIC_ITERATOR} {
    
    private final ${DUAL_CLASS} map;
    
    private final CloneableIterator<Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}>> delegate;
    
    private Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> currentEntry;
    
    private iterator(${DUAL_CLASS} map) {
      this.map = map;
      this.delegate = map.javaMap.entrySetIterator();
      this.currentEntry = computeNext();
    }
    
    private iterator(${DUAL_CLASS} map, Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> entry) {
      this.map = map;
      this.delegate = map.javaMap.entrySetIterator(entry);
      this.currentEntry = entry;
    }
    
    private iterator(JD$Misc end, ${DUAL_CLASS} map) {
      this.map = map;
      this.delegate = null;
      this.currentEntry = null;
    }
    
    public iterator(${ITERATOR} other) {
      this.map = other.map;
      this.delegate = CloneableIterator.clone(other.delegate);
      this.currentEntry = other.currentEntry;
    }

    @Override
    public ${PAIR_TYPE} $star() {
      return currentEntry.getValue();
    }

    @Override
    public ${ITERATOR} $preInc() {
      if (this.currentEntry == null) {
        throw new NoSuchElementException();
      }
      this.currentEntry = computeNext();
      return this;
    }

    @Override
    public boolean $eq(Object other) {
      ${ITERATOR} otherIter = (${ITERATOR}) other;
      return this.map == otherIter.map && this.currentEntry == otherIter.currentEntry;
    }
    
    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public ${ITERATOR} clone() {
      return new iterator(this);
    }

    private final ${ITERATOR} remove() {
      this.delegate.remove();
      return clone().$preInc();
    }

    private final Map.Entry<${WRAPPED_KEY_TYPE}, ${PAIR_TYPE}> computeNext() {
      if (delegate.hasNext()) {
        return delegate.next(); 
      }
      return null;
    }
  }
  
  private static final class ${WRAPPED_KEY_TYPE} {
    
    private final ${GENERIC_DUAL_CLASS} map;
    
    private final ${KEY_TYPE} key;

    public ${WRAPPED_KEY_NAME}(${GENERIC_DUAL_CLASS} map, ${KEY_TYPE} key) {
      this.map = map;
      this.key = key;
    }

    @Override
    public int hashCode() {
      return map.HashFun.$call(this.key);
    }

    @Override
    public boolean equals(Object obj) {
      final ${WRAPPED_KEY_TYPE} other = (${WRAPPED_KEY_TYPE}) obj;
      return map.EqualFun.$call(this.key, other.key);
    }
  } 
  
  private final boolean isKeyPointerLike() {
    return ${IS_KEY_POINTER_LIKE};
  }
  
  private final ${KEY_TYPE} $cloneKeyIfNeed(${KEY_TYPE} Key) {
    return isKeyPointerLike() ? Key : $tryClone(Key);
  }
  
  private final boolean isDataPointerLike() {
    return ${IS_DATA_POINTER_LIKE};
  }
  
  private final ${VALUE_TYPE} $cloneValIfNeed(${VALUE_TYPE} Val) {
    return isDataPointerLike() ? Val : $tryClone(Val);
  }
  
  private final ${DUAL_CLASS} $this() {
    return (${DUAL_CLASS}) this;
  }
}