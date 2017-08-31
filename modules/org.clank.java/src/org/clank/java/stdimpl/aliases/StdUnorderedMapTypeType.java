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
public class StdUnorderedMapTypeType<K, V>
        extends NativeTrace.CreateDestroy$Tracker 
        implements Iterable<std.pairTypeType<K, V>>, 
          Native.NativePOD<std.unordered_mapTypeType<K, V>>, 
          Destructors.ClassWithDestructor {
  
  protected final std.hash<K> HashFun;
  
  protected final std.binary_functionBoolean<K> EqualFun;

  protected final Supplier<V> valueSupplier;
  
  protected AlteredHashMap<WrappedKey<K>, std.pairTypeType<K, V>> javaMap;

  public StdUnorderedMapTypeType(std.hash<K> HashFun, std.binary_functionBoolean<K> EqualFun, Supplier<V> valueSupplier) {
    this.HashFun = HashFun;
    this.EqualFun = EqualFun;
    this.javaMap = new AlteredHashMap<>();
    this.valueSupplier = valueSupplier;
  }
  
  public StdUnorderedMapTypeType(std.unordered_mapTypeType<K, V> other) {
    this(other.HashFun, other.EqualFun, other.valueSupplier);
    $assign(other);
  }
  
  public StdUnorderedMapTypeType(JD$Move $Param, std.unordered_mapTypeType<K, V> other) {
    this(other.HashFun, other.EqualFun, other.valueSupplier);
    swap(other);
  }

  @Override
  public final std.unordered_mapTypeType<K, V> $assign(std.unordered_mapTypeType<K, V> other) {
    assert check$Alive();
    assert this.HashFun == other.HashFun;
    assert this.EqualFun == other.EqualFun;
    this.javaMap.clear();
    for (std.pairTypeType<K, V> val : other) {
      this.javaMap.put(new WrappedKey<K>($this(), $cloneKeyIfNeed(val.first)), $Clone(val));
    }
    return $this();
  }
  
  public final iterator<K, V> begin() {
    assert check$Alive();
    return new iterator($this());
  }

  public final iterator<K, V> begin$Const() {
    return begin();
  }
  
  public final iterator<K, V> end() {
    assert check$Alive();
    return new iterator(JD$Misc.INSTANCE, $this());
  }

  public final iterator<K, V> end$Const() {
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
      for (Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> entry : javaMap.entrySet()) {
        if (!isKeyPointerLike()) {
          Native.destroy(entry.getKey());
        }
        Native.destroy(entry.getValue());
      }
    }
    javaMap.clear();
  }
  
  //std::pair<iterator,bool> insert( const value_type& value );
  public final std.pairTypeBool<iterator<K, V>> insert(std.pairTypeType<K, V> value) {
    assert check$Alive();
    WrappedKey<K> keyToSearch = new WrappedKey<K>($this(), value.first);
    Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return std.make_pair_T_bool(new iterator($this(), existing), false);
    }
    WrappedKey<K> keyToInsert = new WrappedKey<K>($this(), $cloneKeyIfNeed(value.first));
    javaMap.put(keyToInsert, $Clone(value));
    existing = javaMap.getNode(keyToInsert);
    return std.make_pair_T_bool(new iterator($this(), existing), true);
  }
  public final std.pairTypeBool<iterator<K, V>> insert$T(std.pairTypeType<K, V> value) {
    assert check$Alive();
    return insert(value);
  }
  
  //std::pair<iterator,bool> insert(value_type&& value);
  public final std.pairTypeBool<iterator<K, V>> insert$T$RR(std.pairTypeType<K, V> /*&&*/ value) {
    assert check$Alive();
    WrappedKey<K> keyToSearch = new WrappedKey<K>($this(), value.first);
    Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return std.make_pair_T_bool(new iterator($this(), existing), false);
    }
    WrappedKey<K> keyToInsert = new WrappedKey<K>($this(), $cloneKeyIfNeed(value.first));
    javaMap.put(keyToInsert, $Move(value));
    existing = javaMap.getNode(keyToInsert);
    return std.make_pair_T_bool(new iterator($this(), existing), true);
  }
  
  //template< class... Args >
  //std::pair<iterator,bool> emplace( Args&&... args );
  public final std.pairTypeBool<iterator<K, V>> emplace(std.pairTypeType<K, V> value) {
    assert check$Alive();
    WrappedKey<K> keyToSearch = new WrappedKey<K>($this(), value.first);
    Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return std.make_pair_T_bool(new iterator($this(), existing), false);
    }
    WrappedKey<K> keyToInsert = new WrappedKey<K>($this(), $cloneKeyIfNeed(value.first));
    javaMap.put(keyToInsert, value);
    existing = javaMap.getNode(keyToInsert);
    return std.make_pair_T_bool(new iterator($this(), existing), true);
  }

  // size_type erase( const key_type& key );
  public int erase(K key) {
    assert check$Alive();
    iterator<K, V> pos = find(key);
    if (pos.$noteq(end())) {
      erase(pos);
      return 1;
    }
    return 0;
  }
  
  // iterator erase( const_iterator pos );
  public iterator<K, V> erase(iterator<K, V> pos) {
    assert check$Alive();
    Native.destroy(pos.$star());
    return pos.remove();
  }
  
  // iterator find( const Key& key );
  public final iterator<K, V> find(/*const*/ K /*&*/ key) {
    assert check$Alive();
    WrappedKey<K> keyToSearch = new WrappedKey<K>($this(), key);
    Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> existing = javaMap.getNode(keyToSearch);
    if (existing != null) {
      return new iterator($this(), existing);
    }
    return end();
  }

  public final iterator<K, V> find$Const(/*const*/ K /*&*/ key) {
    return find(key);
  }

  // size_type count( const Key& key ) const;
  public final boolean count(K key) {
    return find(key).$noteq(end());
  }
  
  // void swap( unordered_map& other );
  public final void swap(std.unordered_mapTypeType<K, V> /*&*/other) {
    assert check$Alive();
    assert this.HashFun == other.HashFun;
    assert this.EqualFun == other.EqualFun;
    AlteredHashMap<WrappedKey<K>, std.pairTypeType<K, V>> tmp = this.javaMap;
    this.javaMap = other.javaMap;
    other.javaMap = tmp;
  }

  // T& at( const Key& key );
  public V at(K key) {
    assert check$Alive();
    return $at(key);
  }

  // T& operator[]( const Key& key );
  public V $at_T$C$R(K key) {
    assert check$Alive();
    return $at(key);
  }
  
  // T& operator[]( Key&& key );
  public V $at_T$RR(K key) {
    assert check$Alive();
    return $at(key);
  }

  public V $at(K key) {
    assert check$Alive();
    std.pairTypeType<K, V> out = javaMap.get(new WrappedKey<K>($this(), key));
    if (out == null) {
      out = std.make_pair_T_T($cloneKeyIfNeed(key), valueSupplier.get());
      javaMap.put(new WrappedKey<K>($this(), $cloneKeyIfNeed(key)), out);
    }
    return out.second;
  }
  
  public type$ref<V> ref$at(final K key) {
    assert check$Alive();
    final WrappedKey<K> wrappedKey = new WrappedKey<K>($this(), $cloneKeyIfNeed(key));
    if (!javaMap.containsKey(wrappedKey)) {
      javaMap.put(wrappedKey, std.make_pair_T_T($cloneKeyIfNeed(key), valueSupplier.get()));
    }
    return new type$ptr$inout<V>() {
      @Override
      protected V $star$impl() {
        assert check$Alive();
        return javaMap.get(wrappedKey).second;
      }
      
      @Override
      protected V $set$impl(V value) {
        assert check$Alive();
        javaMap.get(wrappedKey).second = $tryAssign(javaMap.get(wrappedKey).second, value, isDataPointerLike());
        return value;
      }
    };
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public final V $set(K key, V value) {
    return ref$at(key).$set(value);
  }
  
  // size_type bucket_count() const;
  public final int bucket_count() {
    return javaMap.bucketsNumber();
  }

  // size_type bucket( const Key& key ) const;
  public final int bucket(K key) {
    return javaMap.bucketForKey(new WrappedKey<K>($this(), key));
  }

  @Override
  public final Iterator<std.pairTypeType<K, V>> iterator() {
    assert check$Alive();
    return new JavaIterator(begin(), end());
  }

  @Override
  public std.unordered_mapTypeType<K, V> clone() {
    assert check$Alive();
    return new std.unordered_mapTypeType<K, V>($this());
  }

  @Override
  public void $destroy() {
    assert check$Alive();
    clear();
    super.set$destroyed();
  }
  
  // Iterator
  public static final class iterator<K, V> implements type$iterator<iterator<K, V>, std.pairTypeType<K, V>> {
    
    private final std.unordered_mapTypeType<K, V> map;
    
    private final CloneableIterator<Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>>> delegate;
    
    private Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> currentEntry;
    
    private iterator(std.unordered_mapTypeType<K, V> map) {
      this.map = map;
      this.delegate = map.javaMap.entrySetIterator();
      this.currentEntry = computeNext();
    }
    
    private iterator(std.unordered_mapTypeType<K, V> map, Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> entry) {
      this.map = map;
      this.delegate = map.javaMap.entrySetIterator(entry);
      this.currentEntry = entry;
    }
    
    private iterator(JD$Misc end, std.unordered_mapTypeType<K, V> map) {
      this.map = map;
      this.delegate = null;
      this.currentEntry = null;
    }
    
    public iterator(iterator<K, V> other) {
      this.map = other.map;
      this.delegate = CloneableIterator.clone(other.delegate);
      this.currentEntry = other.currentEntry;
    }

    @Override
    public std.pairTypeType<K, V> $star() {
      return currentEntry.getValue();
    }

    @Override
    public iterator<K, V> $preInc() {
      if (this.currentEntry == null) {
        throw new NoSuchElementException();
      }
      this.currentEntry = computeNext();
      return this;
    }

    @Override
    public boolean $eq(Object other) {
      iterator<K, V> otherIter = (iterator<K, V>) other;
      return this.map == otherIter.map && this.currentEntry == otherIter.currentEntry;
    }
    
    @Override
    public boolean $noteq(Object other) {
      return !$eq(other);
    }

    @Override
    public iterator<K, V> clone() {
      return new iterator(this);
    }

    private final iterator<K, V> remove() {
      this.delegate.remove();
      return clone().$preInc();
    }

    private final Map.Entry<WrappedKey<K>, std.pairTypeType<K, V>> computeNext() {
      if (delegate.hasNext()) {
        return delegate.next(); 
      }
      return null;
    }
  }
  
  private static final class WrappedKey<K> {
    
    private final std.unordered_mapTypeType<K, ?> map;
    
    private final K key;

    public WrappedKey(std.unordered_mapTypeType<K, ?> map, K key) {
      this.map = map;
      this.key = key;
    }

    @Override
    public int hashCode() {
      return map.HashFun.$call(this.key);
    }

    @Override
    public boolean equals(Object obj) {
      final WrappedKey<K> other = (WrappedKey<K>) obj;
      return map.EqualFun.$call(this.key, other.key);
    }
  } 
  
  private final boolean isKeyPointerLike() {
    return false;
  }
  
  private final K $cloneKeyIfNeed(K Key) {
    return isKeyPointerLike() ? Key : $tryClone(Key);
  }
  
  private final boolean isDataPointerLike() {
    return false;
  }
  
  private final V $cloneValIfNeed(V Val) {
    return isDataPointerLike() ? Val : $tryClone(Val);
  }
  
  private final std.unordered_mapTypeType<K, V> $this() {
    return (std.unordered_mapTypeType<K, V>) this;
  }
}