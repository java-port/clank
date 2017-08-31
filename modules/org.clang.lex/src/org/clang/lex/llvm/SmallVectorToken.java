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
package org.clang.lex.llvm;

import java.util.Iterator;
import org.clang.lex.Token;
import org.clank.java.*;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.NativePointer;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;

/**
 * SmallVectorImpl for Token
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
public final class SmallVectorToken implements assignable<SmallVectorToken>, 
  Native.NativeComparable<SmallVectorToken>, Native.ComparableLower, NativeType.SizeofCapable,
  Iterable<Token>, NativeCloneable<SmallVectorToken> {
  // constant to be used as defaultValue in other collections.
  // tihs instance is cloned, but have not be modified
  public static final SmallVectorToken DEFAULT = new SmallVectorToken(0, null);
  private static final Token[] EMPTY = new Token[0];
  protected final Token defaultValue;
  
  private Token[] array;
  
  private int end;

  public final Token[] $array() {
    return this.array;
  }

  public SmallVectorToken(int capacity, Token defaultValue) {
    this.array = (Token[]) (capacity == 0 ? EMPTY : new Token[capacity]);
    this.end = 0;
    assert defaultValue == null;
    this.defaultValue = defaultValue;
  }
  
  public SmallVectorToken(int capacity, int initialSize, Token defaultValue) {
    this(capacity, defaultValue);
    this.assign(initialSize, defaultValue);
  }

  public SmallVectorToken(Token array[], int length, Token defaultValue) {
    this.array = array;
    this.end = (int) length;
    assert defaultValue == null;
    this.defaultValue = defaultValue;
  }

  public SmallVectorToken(int capacity, type$iterator<?, Token> iter, int length, Token defaultValue) {
    this(capacity, iter, iter.$add(length), defaultValue);
  }

  public SmallVectorToken(int capacity, type$iterator<?, Token> begin, type$iterator<?, Token> end, Token defaultValue) {
    this(capacity, defaultValue);
    append(begin, end);
  }

  public SmallVectorToken(SmallVectorToken other) {
    this.defaultValue = other.defaultValue;
    this.array = other.array.clone();
    this.end = other.end;
  }
  
//  public SmallVectorToken(Token... arr) {
//      // TODO: think over: this uses passed array as a backing store, 
//      // which is effective, but probably error prone; consider copynig
//      array = arr;
//      end = arr.length;
//  }

  @Override
  public final SmallVectorToken $assign(SmallVectorToken other) {
      this.array = other.array;
      this.end = other.end;
      return this;
  }    

  public final void clear() {
    this.destroy_range(0, this.size());
    this.setEnd(0);
  }

  public final boolean resize(int newSize) {
    return resize(newSize, defaultValue);
  }
  
  public final boolean resize(int newSize, Token defaultValue) {
    boolean grown = false;
    if (newSize < end) {
      destroy_range(newSize, end);
    } else if (newSize > end) {
      if (this.capacity() < newSize) {
        this.grow(newSize);
        grown = true;
      }
      for (int i = end; i < newSize; i++) {
        array[i] = new Token();
      }
    }
    end = (int) newSize;
    return grown;
  }  

  public final void reserve(int N) {
    if (this.capacity() < N) {
      this.grow(N);
    }
  }

  public final void assign(int NumElts, Token Elt) {
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      $set(i, Elt);
    }
    
    assert ensureConsistent() : "Check SmallVectorToken!";
  }  

  /**
   *  @brief  Assigns a range to a %vector.
   *  @param  __first  An input iterator.
   *  @param  __last   An input iterator.
   *
   *  This function fills a %vector with copies of the elements in the
   *  range [__first,__last).
   *
   *  Note that the assignment completely changes the %vector and
   *  that the resulting %vector's size is the same as the number
   *  of elements assigned.  Old data may be lost.
   */
  public final void assign(type$iterator<?, Token> __first, type$iterator<?, Token> __last) {
    clear();
    append(__first, __last);
  }
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 440)
  //</editor-fold>  
  public final void swap(SmallVectorToken RHS) {
    Token[] arrTmp = this.array;
    this.array = (Token[])RHS.array;
    RHS.array = arrTmp;
    int endTmp = this.end;
    this.end = RHS.end;
    RHS.end = endTmp;
  }
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=478)
  //</editor-fold>
  public final iterator erase(iterator I) {
    assert(I.$greatereq(this.begin())) : "Iterator to erase is out of bounds.";
    assert(I.$less(this.end())) : "Erasing at past-the-end iterator.";

    iterator N = I;
    // Shift all elts down one.
    std.copy(I.$add(1), this.end(), I, false);
    // Drop the last elt.
    this.pop_back();
    
    assert ensureConsistent() : "Check SmallVectorToken!";
    return(N);
  } 
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=490)
  //</editor-fold>
  public final iterator erase(iterator S, iterator E) {
    assert(S.$greatereq(this.begin())) : "Range to erase is out of bounds.";
    assert(S.$lesseq(E)) : "Trying to erase invalid range.";
    assert(E.$lesseq(this.end())) : "Trying to erase past the end.";

    iterator N = S;
    // Shift all elts down.
    iterator I = std.copy(E, this.end(), S, false);
    // Drop the last elts.
    this.destroy_range(I, this.end());
    this.setEnd(I);
    
    assert ensureConsistent() : "Check SmallVectorToken!";
    return(N);
  }

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=537)
  //</editor-fold>
  public final iterator insert(iterator I, Token Elt) {
    if (I.$eq(this.end())) {  // Important special case for empty vector.
      this.push_back(Elt);
      return this.end().$sub(1);
    }

    assert(I.$greatereq(this.begin())) : "Insertion iterator is out of bounds.";
    assert(I.$lesseq(this.end())) : "Inserting past the end of the vector.";
    
    if (this.size() >= this.capacity()) {
      int EltNo = I.$sub(this.begin());
      this.grow();
      I = this.begin().$add(EltNo);
    }
    
    assert(this.size() < this.capacity());
    
    this.setEnd(this.size() + 1);
    
    // JAVA: this operation moves references instead of copying!
    // Push everything else over.
    std.copy_backward(I, this.end().$sub(1), this.end(), false);   
    
//  // If we just moved the element we're inserting, be sure to update
//  // the reference.
//  const T *EltPtr = &Elt;
//  if (I <= EltPtr && EltPtr < this->EndX)
//    ++EltPtr;    
    
    // JAVA: make sure that Token is cloned
    I.star$ref().$set($tryClone(Elt));
    
    assert ensureConsistent() : "Check SmallVectorToken!";
    return I;    
  }  

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=568)
  //</editor-fold>  
  public final iterator insert(iterator I, int NumToInsert, Token Elt) {
    // Convert iterator to elt# to avoid invalidating iterator when we reserve()
    int InsertElt = I.$sub(this.begin());

    if (I.$eq(this.end())) {  // Important special case for empty vector.
      append(NumToInsert, Elt);
      return this.begin().$add(InsertElt);
    }

    assert(I.$greatereq(this.begin())) : "Insertion iterator is out of bounds.";
    assert(I.$lesseq(this.end())) : "Inserting past the end of the vector.";

    // Ensure there is enough space.
    reserve(this.size() + NumToInsert);

    // Uninvalidate the iterator.
    I = this.begin().$add(InsertElt);

    // If there are more elements between the insertion point and the end of the
    // range than there are being inserted, we can use a simple approach to
    // insertion.  Since we already reserved space, we know that this won't
    // reallocate the vector.
    if (this.end().$sub(I) >= NumToInsert) {
      iterator OldEnd = this.end();
      append(this.end().$sub(NumToInsert), this.end());

      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd, false);

      std.fill_n(I, NumToInsert, Elt);
      return I;
    }

    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.

    // Move over the elements that we're about to overwrite.
    iterator OldEnd = this.end();
    this.setEnd(this.size() + NumToInsert);
    int NumOverwritten = OldEnd.$sub(I);
    std.copy(I, OldEnd, this.end().$sub(NumOverwritten), false);

    // Replace the overwritten part.
    std.fill_n(I, NumOverwritten, Elt);

    // Insert the non-overwritten middle part.
    std.fill_n(OldEnd, NumToInsert-NumOverwritten, Elt);
    
    assert ensureConsistent() : "Check SmallVectorToken!";
    return I;  
  }

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=618)
  //</editor-fold>
  public final iterator insert(iterator I, type$iterator<?, Token> From, type$iterator<?, Token> To) {
    // Convert iterator to elt# to avoid invalidating iterator when we reserve()
    int InsertElt = I.$sub(this.begin());

    if (I.$eq(this.end())) {  // Important special case for empty vector.
      append(From, To);
      return this.begin().$add(InsertElt);
    }

    assert(I.$greatereq(this.begin())) : "Insertion iterator is out of bounds.";
    assert(I.$lesseq(this.end())) : "Inserting past the end of the vector.";

    int NumToInsert = std.distance(From, To);

    // Ensure there is enough space.
    reserve(this.size() + NumToInsert);

    // Uninvalidate the iterator.
    I = this.begin().$add(InsertElt);

    // If there are more elements between the insertion point and the end of the
    // range than there are being inserted, we can use a simple approach to
    // insertion.  Since we already reserved space, we know that this won't
    // reallocate the vector.
    if (this.end().$sub(I) >= NumToInsert) {
      iterator OldEnd = this.end();
      append(this.end().$sub(NumToInsert), this.end());

      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd, false);

      std.copy(From, To, I, false);
      
      assert ensureConsistent() : "Check SmallVectorToken!";
      return I;
    }

    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.

    // Move over the elements that we're about to overwrite.
    iterator OldEnd = this.end();
    this.setEnd(this.size() + NumToInsert);
    int NumOverwritten = OldEnd.$sub(I);
    std.copy(I, OldEnd, this.end().$sub(NumOverwritten), false);

    // Replace the overwritten part.
    for (iterator J = I.clone(); NumOverwritten > 0; --NumOverwritten) {
      J.star$ref().$set(From.$star());
      J.$preInc(); From.$preInc();
    }

    // Insert the non-overwritten middle part.
    std.copy(From, To, OldEnd, false);
    
    assert ensureConsistent() : "Check SmallVectorToken!";
    return I;
  }

  /// append - Add the specified range to the end of the SmallVector.
  ///  
  public final void append(type$iterator<?, Token> in_start, type$iterator<?, Token> in_end) {
    int NumInputs = std.distance(in_start, in_end);
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
    
    type$iterator<?, Token> iter = (type$iterator<?, Token>) in_start.clone();
    while (!iter.$eq(in_end)) {
      if (this.array[this.end] == null) {
        this.array[this.end] = new Token();
      }      
      $set(end, iter.$star());
      ++end;
      iter.$preInc();
    }
    
    assert ensureConsistent() : "Check SmallVectorToken!";
  }

  public final void append(type$ptr<Token> start, int NumInputs) {
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
    
    for (int i = 0; i < NumInputs; i++) {
      if (this.array[this.end] == null) {
        this.array[this.end] = new Token();
      }      
      this.array[end++].$assign(start.$at(i));
    }    
    
    assert ensureConsistent() : "Check SmallVectorToken!";
  }
    
  public final void append(Token[] a) {
    append(a, 0, a.length);
  }
  public final void append(Token[] a, int startIdx, int count) {
    int num = count;
    if (num > (this.capacity() - this.size()))
      this.grow(this.size()+num);
    int last = startIdx + count;
    for (int i = startIdx; i < last; i++) {
      if (this.array[this.end] == null) {
        this.array[this.end] = new Token();
      }
      this.array[this.end++].$assign(a[i]);
    }
    
    assert ensureConsistent() : "Check SmallVectorToken!";
  }

  public final void append(int NumInputs, Token Elt) {
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);

    // Copy the new elements over.
    for (int i = 0; i < NumInputs; i++) {
      $set(end, Elt);
      ++end;
    }
    
    assert ensureConsistent() : "Check SmallVectorToken!";
  }  

  /**
   * 
   * @param count
   * @return true if was expanded
   */
  public final boolean prepareBeforeAppend(int num) {
    int capacity = this.capacity();
    int size = this.size();
    if (num > (capacity - size)) {
      // grow at least twice
      int N = Math.max(capacity*2, size+num);
//      System.err.printf("prepareBeforeAppend from %d [%d] to %d [+%d] %n", capacity, this.end, N, N - capacity);
      this.grow(N);
      assert num <= (this.capacity() - this.size()) : "must be enough for appending " + num + " into [" + this.size() + "-" + this.capacity() +"]";
      return true;
    } else {
      return false;
    }
  }
  
  @Override
  public final boolean $eq(SmallVectorToken RHS) {
    if (this.size() != RHS.size()) return false;
    return std.equal(this.begin(), this.end(), RHS.begin());
  }

  @Override
  public final boolean $noteq(SmallVectorToken RHS) {
    return !$eq(RHS);
  }

  @Override
  public final boolean $less(Object obj) {
    return std.lexicographical_compare(
        this.begin(), 
        this.end(), 
        ((SmallVectorToken) obj).begin(), 
        ((SmallVectorToken) obj).end()
    );
  }

  @Override
  public final boolean $lesseq(Object obj) {
    return $less(obj) || $eq((SmallVectorToken)obj);
  }

  public final type$ref<Token> ref$at(int idx) {
    return NativePointer.create_type$ref(array, idx);
  }
  
  public final Token $at(uint$ref idx) { return $at(idx.$deref()); }
  public final Token $at(int$ref idx) { return $at(idx.$deref()); }
  public final Token $at(int idx) {
    assert array[(int) idx] != null;
    return array[(int) idx];
  }
  public final Token $at$Const(int idx) {
    assert array[(int) idx] != null;
    return array[(int) idx];
  }

  public final Token $set(uint$ref idx, Token value) { return $set(idx.$deref(), value); }
  public final Token $set(int$ref idx, Token value) { return $set(idx.$deref(), value); }
  public final Token $set(int idx, Token value) {
    assert array[(int) idx] != null;
    array[(int) idx].$assign(value);
//    if (defaultValue == null) { array[(int) idx] = value; } else { if (array[(int) idx] == null) { array[(int) idx] = value.clone(); } else { array[(int) idx].$assign(value); } } return value;
    return array[(int) idx];
  }
  
  public final boolean empty() {
    return this.size() == 0;
  }
  
  public final void $destroy() {
    destroy_range(0, end);
    end = 0;
  }
  
  public final void push_back_T$C$R(Token val) {
    push_back(val);
  }
  public final void push_back(Token val) {
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    if (this.array[end] == null) {
      this.array[end] = new Token();
    }
    $set(end, val);
    end++;
  }    

  public final void pop_back() {
    this.array[--end].$destroy();
  }

  public final Token pop_back_val() {
    Token val = this.back();
    this.setEnd(end - 1);
    return val;
  }  

  public final iterator begin() {
    return new iterator(this, 0, false);
  }

  public final type$ptr<Token> ptr$at$begin() {
    return create_type$ptr(array);
  }
  

  public final iterator end() {
    return new iterator(this, end, false);
  }
  
  public final type$ptr<Token> ptr$at$end() {
    return create_type$ptr(array, end);
  }
  
  public final std.reverse_iterator<Token> rbegin() {
    return new std.reverse_iterator<Token>(NativePointer.create_type$ptr(array, end));
  }

  public final std.reverse_iterator<Token> rend() {
    return new std.reverse_iterator<Token>(NativePointer.create_type$ptr(array));
  }
  
  public final type$ptr<Token> data() {
    return NativePointer.create_type$ptr(array);
  }
  
  public final Token front() {
    return array[0];
  }    
  
  public final Token back() {
    return array[end - 1];
  }    
  
  public final type$ref<Token> ref$front() {
    return new type$ref<Token>() {
      
      private final Token stored = array[0];
      
      private final int index = 0;

      @Override
      public Token $deref() {
        return stored;
      }

      @Override
      public Token $set(Token value) {
        if (stored instanceof assignable) { ((assignable<Token>) stored).$assign(value); } else { array[index] = $tryClone(value); } return value;
      }
      
      @Override
      public type$ptr<Token> deref$ptr() {
        return data().$add(index);
      }
    };
  }

  public final type$ref<Token> ref$back() {
    return  new type$ref<Token>() {
      
      private final Token stored = array[end - 1];
      
      private final int index = end - 1;

      @Override
      public Token $deref() {
        return stored;
      }

      @Override
      public Token $set(Token value) {
        if (stored instanceof assignable) { ((assignable<Token>) stored).$assign(value); } else { array[index] = $tryClone(value); } return value;
      }
      
      @Override
      public type$ptr<Token> deref$ptr() {
        return data().$add(index);
      }   
    };
  }
  
  public final /*size_t*/int size() /*const*/ {
    return end;
  }

  public final /*size_t*/int max_size() /*const*/ {
    return Integer.MAX_VALUE; // TODO 
  }

  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  public final /*size_t*/int capacity() /*const*/ {
    return array.length;
  }

  @Override public final /*size_t*/int $sizeof() {
    return capacity_in_bytes();
  }

  public final /*size_t*/int capacity_in_bytes() {
    int oneElemSize = Token.$sizeof_Token();//NativeType.sizeof(defaultValue);; 
//    for (Token elem : array) {
//      if (elem != defaultValue) {
//        oneElemSize = NativeType.sizeof(elem);
//        break;
//      }
//    }
    return array.length * oneElemSize;
  }

  public final type$ptr<Token> ptr$at(int idx) {
    return create_type$ptr(array, idx);
  }

  /// Set the array size to \p N, which the current array must have enough
  /// capacity for.
  ///
  /// This does not construct or destroy any elements in the vector.
  ///
  /// Clients can use this in conjunction with capacity() to write past the end
  /// of the buffer when they know that more elements are available, and only
  /// update the size later. This avoids the cost of value initializing elements
  /// which will only be overwritten.
  public final void set_size(int N) {
    assert(N <= this.capacity());
    this.setEnd(N);
  }  
  
  private void destroy_range(int from, int to) {
     for (int i = from; i < to; i++) { 
        Token Tok = array[i];
        if (Tok != null) {
          Tok.$destroy();
        } else {
          if (NativeTrace.isDebugMode()) {
            for (int j = i; j < to; j++) {
              assert array[j] == null : "Non null element [" + j + "] after null [" + i + "]";
            }
          }
          break;
        }
     }
  }

  private void destroy_range(iterator _from, iterator _to) {
    destroy_range(_from.$sub(this.begin()), _to.$sub(this.begin()));
  } 
  
  private void grow(int newSize) {    
    Token[] oldArray = array;
    array = new Token[newSize];
//    System.err.printf("growing from %d [%d] to %d [+%d] %n", oldArray.length, this.end, newSize, array.length-oldArray.length);
    copy$Object(oldArray, 0, array, 0, oldArray.length);
  }

  private void grow() {
    int capacity = capacity();
//    this.grow(capacity == 0 ? 1 : ((capacity < 1024) ? capacity * 2 : (capacity + 1024)));
    // PERF: when size is big and we continue to push elements, then increase twice
    // to reduce number of allocations/copy of arrays
    if (capacity == 0) {
      array = new Token[8];
    } else {
      this.grow(capacity * 2);
    }
  }  
  
  private void setEnd(int to) {
    end = to;
  }  

  private void setEnd(iterator to) {
    setEnd(to.$sub(this.begin()));
  } 
  
  @Override
  public Iterator<Token> iterator() {
    return new JavaIterator(begin(), end());
  }

  @Override
  public SmallVectorToken clone() {
    return new SmallVectorToken(this);
  }
  
  public SmallVectorToken deepCopy() {
    int size = size();
    SmallVectorToken other = new SmallVectorToken(size, null);
    assert other.capacity() == size;
    for (int i = 0; i < size; i++) {
      Token tok = this.array[i];
      assert tok != null;
      other.array[i] = new Token(tok);
    }
    other.end = this.end;
    return other;
  }
  /*
   * *************************************************************************
   *  Iterators
   * *************************************************************************
   */
    
  public final static class iterator implements type$iterator<iterator, Token>, Native.assignable<iterator>, Native.ComparableLowerGreater {
    
    private final boolean _const;
    private final SmallVectorToken delegate;
    private int index;

    private iterator(SmallVectorToken delegate, int index, boolean makeConst) {
      this.delegate = delegate;
      this.index = index;
      this._const = makeConst;
    }

    @Override
    public iterator $assign(iterator other) {
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }

    public Token $arrow() {
      return $at(0);
    }

    @Override
    public Token $star() {
      return $at(0);
    }
    
    @Override
    public type$ref<Token> star$ref() {
      return ref$at(0);
    }       

    @Override
    public int $sub(iterator iter) {
      assert this.delegate == iter.delegate;
      return this.index - iter.index;
    }

    @Override
    public iterator $preInc() {
      assert !_const;
      ++this.index;
      return this;
    }

    @Override
    public iterator $preDec() {
      assert !_const;
      --this.index;
      return this;
    }

    @Override
    public iterator $postInc() {
      assert !_const;
      iterator cloned = new iterator(delegate, index, false);
      index++;
      return cloned;
    }

    @Override
    public iterator $postDec() {
      assert !_const;
      iterator cloned = new iterator(delegate, index, false);
      index--;
      return cloned;
    }

    @Override
    public iterator $inc(int amount) {
      assert !_const;
      index+=amount;
      return this;
    }

    @Override
    public iterator $dec(int amount) {
      assert !_const;
      index-=amount;
      return this;
    }

    @Override
    public iterator $add(int amount) {
      return new iterator(this.delegate, (this.index + amount), false);
    }

    @Override
    public iterator $sub(int amount) {
      return new iterator(this.delegate, (this.index - amount), false);
    }

    @Override
    public boolean $noteq(Object other) {
      assert this.delegate == ((iterator) other).delegate;
      return this.index != ((iterator) other).index;
    }

    @Override
    public boolean $eq(Object other) {
      assert this.delegate == ((iterator) other).delegate;
      return this.index == ((iterator) other).index;
    }

    @Override
    public iterator clone() {
      return new iterator(delegate, index, false);
    }

    @Override
    public iterator const_clone() {
      return new iterator(delegate, index, true);
    }

    @Override
    public boolean $less(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index < ((iterator) obj).index;
    }

    @Override
    public boolean $lesseq(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index <= ((iterator) obj).index;
    }

    @Override
    public boolean $greater(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index > ((iterator) obj).index;
    }

    @Override
    public boolean $greatereq(Object obj) {
      assert this.delegate == ((iterator) obj).delegate;
      return this.index >= ((iterator) obj).index;
    }

    public Token $at(int index) {
      return delegate.$at(this.index + index);
    }
    
    public type$ref<Token> ref$at(final int index) {
      return delegate.ref$at(this.index + index);
    }

    public type$ptr<Token> toPointer() {
      return create_type$ptr(delegate.array, this.index);
    }

    @Override
    public String toString() {
      return "[" + this.index + "] from\n" + delegate.toString();
    }
  } 
  
  private final static class JavaIterator implements Iterator<Token> {
    
    private final iterator begin;
    
    private final iterator end;

    public JavaIterator(iterator begin, iterator end) {
      this.begin = $tryClone(begin);
      this.end = end;
    }

    @Override
    public boolean hasNext() {
      return begin.$noteq(end);
    }

    @Override
    public Token next() {
      Token val = begin.$star();
      begin.$preInc();
      return val;
    }

    @Override
    public void remove() {
      throw new UnsupportedOperationException("Not supported.");
    }
  }

  @Override
  public String toString() {
    if (this.end == 0) {
      return "<EMPTY>";
    }
    StringBuilder out = new StringBuilder("\nSmallVectorToken{\nend = " + this.end + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      Token element = array[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append(element).append('\n');
    }
    out.append("}SmallVectorToken}\n");
    return out.toString();
  }
  
  // Check that we do not contain the same Token twice!
  private boolean ensureConsistent() {
    for (int i = 0; i < size(); ++i) {
      for (int k = i + 1; k < size(); ++k) {
        if (array[i] == array[k]) {
          return false;
        }
      }
    }
    return true;
  }
}
