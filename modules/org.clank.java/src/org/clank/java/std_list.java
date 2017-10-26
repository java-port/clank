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
package org.clank.java;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.function.Supplier;
import org.clank.java.std;
import org.clank.java.std.Compare;
import org.clank.java.std.reverse_iterator;
import org.clank.support.Destructors;
import org.clank.support.Native;
import org.clank.support.aliases.type$ref;
import static org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.$Clone;
import static org.clank.support.Native.$tryClone;
import static org.clank.support.Native.$tryMove;
import org.clank.support.Native.NativeComparable;
import org.clank.support.NativeCallback;
import org.clank.support.NativeCloneable;
import org.clank.support.NativeMoveable;
import org.clank.support.NativeSwappable;
import org.clank.support.aliases.JavaIterator;
import org.clank.support.aliases.NativeContainer;
import org.clank.support.aliases.type$iterator;
import org.clank.support.type$ptr$inout;

/**
 *
 * @author petrk
 */
public interface std_list {
  
  public static class list<E> implements Iterable<E>, Destructors.ClassWithDestructor, 
          NativeCloneable<list<E>>, NativeMoveable<list<E>>, NativeContainer<E>,
          NativeSwappable, NativeComparable<list<E>> {
    
    private final Supplier<E> defaultValue;
    
    public list() {
      this(std.getSupplier(null));
    }
    
    public list(E defaultValue) {
      this(std.getSupplier(defaultValue));
    }
    
    public list(Supplier<E> defaultValue) {
      this.defaultValue = defaultValue;
    }
    
    /**
     *  @brief  Creates a %list with copies of an exemplar element.
     *  @param  __n  The number of elements to initially create.
     *  @param  __value  An element to copy.
     *  @param  __a  An allocator object.
     *
     *  This constructor fills the %list with @a __n copies of @a __value.
     */
    public list(/*uint*/int __n, E __value, Supplier<E> defaultValue) { 
      this(defaultValue);
      while (--__n >= 0) {
        linkLast($cloneIfNeeded(__value));
      }
    }

    /**
     *  @brief  %List copy constructor.
     *  @param  __x  A %list of identical element and allocator types.
     *
     *  The newly-created %list uses a copy of the allocation object used
     *  by @a __x.
     */
    public list(list<E> __x) { 
      this(__x.defaultValue);
      for (E elem : __x) {
        linkLast($cloneIfNeeded(elem));
      }
    }
    public list(JD$Move _dparam, list<E> other) {
      this(other.defaultValue);
      swap(other);
    }

    /**
     *  @brief  Builds a %list from a range.
     *  @param  __first  An input iterator.
     *  @param  __last  An input iterator.
     *
     *  Create a %list consisting of copies of the elements from
     *  [@a __first,@a __last).  This is linear in N (where N is
     *  distance(@a __first,@a __last)).
     */    
    public list(type$iterator<?, E> __first, type$iterator<?, E> __last, Supplier<E> defaultValue) { 
      this(defaultValue);
      for (type$iterator<?, E> B = $tryClone(__first), E = __last; B.$noteq(E); B.$preInc()) {
        linkLast($cloneIfNeeded(B.$star()));
      }
    }
    
    public list<E> $assign(list<E> other) {
      clear();
      insert$T(end(), other.begin(), other.end());
      return this;
    }

    public final list<E> $assignMove(list<E> other) {
      clear();
      swap(other);
      return this;
    }
    
    public void push_back(E val) {
      linkLast($tryClone(val));
    }
    
    public void push_back_T$C$R(E val) {
      linkLast($tryClone(val));
    }

    public void push_back_T$RR(E val) {
      linkLast($tryMove(val));
    }
    
    public void push_front_T$RR(E val) {
      linkFirst($tryMove(val));
    }

    public void remove_if(NativeCallback.BoolPredicate<E> predicate) {
      Node<E> cur = first;
      while (cur != null) {
        Node<E> next = cur.next;
        if (predicate.$call(cur.item)) {
          $destroyIfNeeded(unlink(cur));
        }
        cur = next;
      }
    }

    public E front() {
      return getFirst();
    }
    
    public E front$Const() {
      return getFirst();
    }

    public E back() {
      return getLast();
    }  

    public E back$Const() {
      return getLast();
    }  

    // Version without args
    public void emplace_back() {
      push_back($getDefaultVal());
    }

    // Version with args
    public void emplace_back(E val) {
      // JConvert already created val externally, 
      // so just put this object into last cell without any move
      // in native element is created in memory of node like: new (End) (args)
      linkLast(val);
    }

    public void pop_back() {
      $destroyIfNeeded(removeLast());
    }

    public void pop_front() {
      $destroyIfNeeded(removeFirst());
    }

    /**
     *  @brief  Remove element at given position.
     *  @param  __position  Iterator pointing to element to be erased.
     *  @return  An iterator pointing to the next element (or end()).
     *
     *  This function will erase the element at the given position and thus
     *  shorten the %list by one.
     *
     *  Due to the nature of a %list this operation can be done in
     *  constant time, and only invalidates iterators/references to
     *  the element being removed.  The user is also cautioned that
     *  this function only erases the element, and that if the element
     *  is itself a pointer, the pointed-to memory is not touched in
     *  any way.  Managing the pointer is the user's responsibility.
     */
    public iterator<E> erase(iterator<E> __position) {
      assert __position.lst == this;
      iterator<E> next = __position.clone().$preInc();
      $destroyIfNeeded(unlink(__position.current));
      return next;
    }
    
    /**
     *  @brief  Remove a range of elements.
     *  @param  __first  Iterator pointing to the first element to be erased.
     *  @param  __last  Iterator pointing to one past the last element to be
     *                erased.
     *  @return  An iterator pointing to the element pointed to by @a last
     *           prior to erasing (or end()).
     *
     *  This function will erase the elements in the range @a
     *  [first,last) and shorten the %list accordingly.
     *
     *  This operation is linear time in the size of the range and only
     *  invalidates iterators/references to the element being removed.
     *  The user is also cautioned that this function only erases the
     *  elements, and that if the elements themselves are pointers, the
     *  pointed-to memory is not touched in any way.  Managing the pointer
     *  is the user's responsibility.
     */
    public iterator<E> erase(iterator<E> __first, iterator<E> __last) {
      // No need to clone __first
      while (__first.$noteq(__last)) {
        __first = erase(__first);
      }
      return  __last;
    }

    public void insert$T(iterator<E> position, type$iterator<?, E> begin, type$iterator<?, E> end) {
      assert position.lst == this;
      for (type$iterator<?, E> cur = $Clone(begin); cur.$noteq(end); cur.$preInc()) {
        E toInsert = $cloneIfNeeded(cur.$star());
        if (position.current == null) {
          linkLast(toInsert);
        } else {
          linkBefore(toInsert, position.current);
        }
      }
    }

    public list.iterator<E> insert__List_const_iterator$_Tp_T$C$R(list.iterator<E> position, E val) {
      assert position.lst == this;
      E toInsert = $cloneIfNeeded(val);
      if (position.current == null) {
        linkLast(toInsert);
      } else {
        linkBefore(toInsert, position.current);
      }
      return position;
    }

    public list.iterator<E> insert__List_const_iterator$_Tp_T$RR(list.iterator<E> position, E val) {
      assert position.lst == this;
      E toInsert = $moveIfNeeded(val);
      if (position.current == null) {
        linkLast(toInsert);
      } else {
        linkBefore(toInsert, position.current);
      }
      return position;
    }

    public iterator<E> begin() {
      return new iterator<E>(this, this.first);
    }

    public iterator<E> end() {
      return new iterator<E>(this, null);
    }
    
    public iterator<E> begin$Const() {
      return new iterator<E>(this, this.first);
    }
  
    public iterator<E> end$Const() {
      return new iterator<E>(this, null);
    }    

    public reverse_iterator<E> rbegin() {
      return new reverse_iterator(end());
    }

    public reverse_iterator<E> rend() {
      return new reverse_iterator(begin());
    }

    public boolean empty() {
      return size() == 0;
    }
    
    public void sort(Compare<E> compare) {
      std.sort(begin(), end(), compare);
    }
    
    public void sort$T(Compare<E> compare) {
      std.sort(begin(), end(), compare);
    }

    @Override
    public boolean $eq(list<E> other) {
      if (this.size() != other.size()) {
        return false;
      }
      if (this.$isPointerLike() != other.$isPointerLike()) {
        return false;
      }
      return std.equal(this.begin(), this.end(), other.begin(), $isPointerLike());
    }

    @Override
    public boolean $noteq(list<E> other) {
      return !$eq(other);
    }

    @Override
    public void swap(NativeSwappable RHS) {
      list<E> other = (list<E>) RHS;
      assert this.$isPointerLike() == other.$isPointerLike();
      
      Node<E> tmp = this.first;
      this.first = other.first;
      other.first = tmp;
      
      tmp = this.last;
      this.last = other.last;
      other.last = tmp;
      
      int tmpSize = this.size;
      this.size = other.size;
      other.size = tmpSize;
    }
    
    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
      return size;
    }
    
    /**
     *  Erases all the elements.  Note that this function only erases
     *  the elements, and that if the elements themselves are
     *  pointers, the pointed-to memory is not touched in any way.
     *  Managing the pointer is the user's responsibility.
     */
    public void clear() {
      if (!$isPointerLike()) {
        for (E elem : this) {
          Destructors.$destroy(elem);
        }
      }
      // From LinkedList.java:
      // Clearing all of the links between nodes is "unnecessary", but:
      // - helps a generational GC if the discarded nodes inhabit
      //   more than one generation
      // - is sure to free memory even if there is a reachable Iterator
      for (Node<E> x = first; x != null; ) {
          Node<E> next = x.next;
          x.item = null;
          x.next = null;
          x.prev = null;
          x = next;
      }
      first = last = null;
      size = 0;
    }

    @Override
    public list<E> move() {
      list<E> out = new list<E>(JD$Move.INSTANCE, this);
      assert this.getClass() == out.getClass() : "forgot to override move in " + out.getClass();
      return out;
    }
    
    @Override
    public void $destroy() {
      if (!$isPointerLike()) {
        for (E elem : this) {
          Destructors.$destroy(elem);
        }
      }
    }

    @Override
    public list<E> clone() {
      return new list<E>(this);
    }

    @Override
    public Iterator<E> iterator() {
      return new JavaIterator(begin(), end());
    }

    public void emplace_back(Object ... args) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void emplace_front(Object ... args) {
      throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    // Cyclic iterator
    public static class iterator<T> implements type$iterator<iterator<T>, T>, NativeSwappable {
      
      private list<T> lst;
    
      private Node<T> current;

      public iterator() {
        this.lst = null;
        this.current = null;
      }

      public iterator(iterator<T> other) {
        this.lst = other.lst;
        this.current = other.current;
      }
      
      public iterator(JD$Move _dparam, list.iterator<T> other) {
        this.lst = other.lst;
        this.current = other.current;
      }
      
      private iterator(list<T> lst, Node<T> node) {
        this.lst = lst;
        this.current = node;
      }

      public iterator<T> $assign(list.iterator<T> other) {
        this.lst = other.lst;
        this.current = other.current;
        return this;
      }

      public iterator<T> $assignMove(list.iterator<T> other) {
        this.lst = other.lst;
        this.current = other.current;
        return this;
      }

      public T $arrow() {
        return this.current.item;
      }

      @Override
      public T $star() {
        return this.current.item;
      }

      @Override
      public type$ref<T> star$ref() {
        return new type$ptr$inout<T>() {
          
          final Node<T> node = iterator.this.current;
          
          @Override
          protected T $star$impl() {
            return node.item;
          }

          @Override
          protected T $set$impl(T value) {
            node.item = Native.$tryAssign(node.item, value, lst.$isPointerLike());
            return node.item;
          }
        };
      }

      @Override
      public boolean $noteq(Object other) {
        return !$eq(other);
      }

      @Override
      public boolean $eq(Object other) {
        iterator<T> otherIter = (iterator<T>) other;
        return this.lst == otherIter.lst && this.current == otherIter.current;
      }

      @Override
      public int $sub(iterator<T> iter) {
        return std.distance(iter, this, JD$FAKE.TRAILING);
      }

      @Override
      public iterator<T> $preInc() {
        if (this.current == null) {
          this.current = this.lst.first; // from last to first
        } else {
          this.current = this.current.next;
        }
        return this;
      }

      @Override
      public iterator<T> $preDec() {
        if (this.current == this.lst.first) {
          this.current = null;  // from first to last
        } else if (this.current == null) {
          this.current = this.lst.last; // prev for last
        } else {
          this.current = this.current.prev; // just prev
        }
        return this;
      }

      @Override
      public iterator<T> $postInc() {
        iterator<T> cloned = clone();
        this.$preInc();
        return cloned;
      }

      @Override
      public iterator<T> $postDec() {
        iterator<T> cloned = clone();
        this.$preDec();
        return cloned;
      }

      @Override
      public iterator<T> clone() {
        return new iterator<T>(this);
      }      

      @Override
      public iterator<T> const_clone() {
        return clone();
      }      

      @Override
      public iterator<T> $inc(int amount) {
        // Note, there is no "operator+=" in std::list::iterator in C++.
        if (amount > 0) {
          while (amount-- > 0) {
            $preInc();
          }
        } else if (amount < 0) {
          $dec(-amount);
        }
        return this;
      }

      @Override
      public iterator<T> $dec(int amount) {
        // Note, there is no "operator-=" in std::list::iterator in C++.
        if (amount > 0) {
          while (amount-- > 0) {
            $preDec();
          }
        } else if (amount < 0) {
          $inc(-amount);
        }
        return this;
      }

      @Override
      public iterator<T> $add(int amount) {
        iterator<T> cloned = clone();
        return cloned.$inc(amount);
      }

      @Override
      public iterator<T> $sub(int amount) {
        iterator<T> cloned = clone();
        return cloned.$dec(amount);
      }

      @Override
      public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append($index()).append("]: ");
        if (current != null) {
          $printRest(sb, current);
        } else {
          sb.append("<END>");
        }
        return sb.toString();
      }
      
      public int $index() {
        if (this.current == null) {
          return this.lst.size();
        } else {
          int index = 0;
          Node<T> inList = this.lst.first;
          while (inList != null && inList != this.current) {
            ++index;
            inList = inList.next;
          }
          return index;
        }
      }

      @Override
      public void swap(NativeSwappable RHS) {
        iterator<T> other = (iterator<T>) RHS;
        assert this.lst == other.lst : "only iterators created on the same list can be swapped";
        T tmp = this.current.item;
        this.current.item = other.current.item;
        other.current.item = tmp;
      }
    }
    
    private static <T> void $printRest(StringBuilder sb, Node<T> node) {
      boolean printComma = false;
      while (node != null) {
        if (printComma) {
          sb.append(", ");
        }
        sb.append(node.item);
        printComma = true;
        node = node.next;
      }
    }
    
    private E $getDefaultVal() {
      if (defaultValue != null) {
        final E res = defaultValue.get();
        assert res != null : "If stored type is pointer then pass null as a supplier! Nonnull supplier must provide nonull values.";
        return res;
      }
      return null;
    }
    
    private boolean $isPointerLike() {
      return defaultValue == null;
    }
    
    private E $cloneIfNeeded(E value) {
      return !$isPointerLike() ? $tryClone(value) : value;
    }
    
    private E $moveIfNeeded(E value) {
      return !$isPointerLike() ? $tryMove(value) : value;
    }
    
    private void $destroyIfNeeded(E value) {
      if (!$isPointerLike()) {
        Destructors.$destroy(value);
      }
    }
    
    ///////////////////////////////////////////////////////////////////////////
    // From LinkedList.java
    
    private transient int size = 0;

    /**
     * Pointer to first node.
     * Invariant: (first == null && last == null) ||
     *            (first.prev == null && first.item != null)
     */
    private transient Node<E> first;

    /**
     * Pointer to last node.
     * Invariant: (first == null && last == null) ||
     *            (last.next == null && last.item != null)
     */
    private transient Node<E> last;
    
    /**
     * Links e as first element.
     */
    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        size++;
    }

    /**
     * Links e as last element.
     */
    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        size++;
    }

    /**
     * Inserts element e before non-null Node succ.
     */
    private void linkBefore(E e, Node<E> succ) {
        // assert succ != null;
        final Node<E> pred = succ.prev;
        final Node<E> newNode = new Node<>(pred, e, succ);
        succ.prev = newNode;
        if (pred == null)
            first = newNode;
        else
            pred.next = newNode;
        size++;
    }

    /**
     * Unlinks non-null first node f.
     */
    private E unlinkFirst(Node<E> f) {
        // assert f == first && f != null;
        final E element = f.item;
        final Node<E> next = f.next;
        f.item = null;
        f.next = null; // help GC
        first = next;
        if (next == null)
            last = null;
        else
            next.prev = null;
        size--;
        return element;
    }

    /**
     * Unlinks non-null last node l.
     */
    private E unlinkLast(Node<E> l) {
        // assert l == last && l != null;
        final E element = l.item;
        final Node<E> prev = l.prev;
        l.item = null;
        l.prev = null; // help GC
        last = prev;
        if (prev == null)
            first = null;
        else
            prev.next = null;
        size--;
        return element;
    }

    /**
     * Unlinks non-null node x.
     */
    private E unlink(Node<E> x) {
        // assert x != null;
        final E element = x.item;
        final Node<E> next = x.next;
        final Node<E> prev = x.prev;

        if (prev == null) {
            first = next;
        } else {
            prev.next = next;
            x.prev = null;
        }

        if (next == null) {
            last = prev;
        } else {
            next.prev = prev;
            x.next = null;
        }

        x.item = null;
        size--;
        return element;
    }

    /**
     * Returns the first element in this list.
     *
     * @return the first element in this list
     * @throws NoSuchElementException if this list is empty
     */
    private E getFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return f.item;
    }

    /**
     * Returns the last element in this list.
     *
     * @return the last element in this list
     * @throws NoSuchElementException if this list is empty
     */
    private E getLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return l.item;
    }

    /**
     * Removes and returns the first element from this list.
     *
     * @return the first element from this list
     * @throws NoSuchElementException if this list is empty
     */
    private E removeFirst() {
        final Node<E> f = first;
        if (f == null)
            throw new NoSuchElementException();
        return unlinkFirst(f);
    }

    /**
     * Removes and returns the last element from this list.
     *
     * @return the last element from this list
     * @throws NoSuchElementException if this list is empty
     */
    private E removeLast() {
        final Node<E> l = last;
        if (l == null)
            throw new NoSuchElementException();
        return unlinkLast(l);
    }

    /**
     * Inserts the specified element at the beginning of this list.
     *
     * @param e the element to add
     */
    private void addFirst(E e) {
        linkFirst(e);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #add}.
     *
     * @param e the element to add
     */
    private void addLast(E e) {
        linkLast(e);
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     * More formally, returns {@code true} if and only if this list contains
     * at least one element {@code e} such that
     * <tt>(o==null&nbsp;?&nbsp;e==null&nbsp;:&nbsp;o.equals(e))</tt>.
     *
     * @param o element whose presence in this list is to be tested
     * @return {@code true} if this list contains the specified element
     */
    private boolean contains(Object o) {
        return indexOf(o) != -1;
    }
    
    /**
     * Returns the index of the first occurrence of the specified element
     * in this list, or -1 if this list does not contain the element.
     * More formally, returns the lowest index {@code i} such that
     * <tt>(o==null&nbsp;?&nbsp;get(i)==null&nbsp;:&nbsp;o.equals(get(i)))</tt>,
     * or -1 if there is no such index.
     *
     * @param o element to search for
     * @return the index of the first occurrence of the specified element in
     *         this list, or -1 if this list does not contain the element
     */
    private int indexOf(Object o) {
        int index = 0;
        if (o == null) {
            for (Node<E> x = first; x != null; x = x.next) {
                if (x.item == null)
                    return index;
                index++;
            }
        } else {
            for (Node<E> x = first; x != null; x = x.next) {
                if (o.equals(x.item))
                    return index;
                index++;
            }
        }
        return -1;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * <p>This method is equivalent to {@link #addLast}.
     *
     * @param e element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    private boolean add(E e) {
        linkLast(e);
        return true;
    }
    
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }
    
    @Override
    public String toString() {
      StringBuilder sb = new StringBuilder();
      if (!empty()) {
        $printRest(sb, first);
      } else {
        sb.append("<EMPTY>");
      }
      return sb.toString();
    }
  }
}
