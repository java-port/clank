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

import java.util.Iterator;
import org.clank.java.std;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.NativeTrace;
import org.clank.support.NativePointer;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.java.std.string.npos;
import org.clank.support.Destructors;
import org.clank.support.JavaDifferentiators;
import org.clank.support.NativeCallback;
import org.clank.support.NativeMoveable;
import org.clank.support.NativeType;
import org.clank.support.Sequence;

/**
 * StdVector for T
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/java/stdimpl/aliases/templates/StdVector.tpl")
//</editor-fold>
public abstract class StdVector<T> extends NativeTrace.CreateDestroy$Tracker
        implements Native.NativePOD<std.vector<T>>,
          NativeMoveable<std.vector<T>>, Native.NativeComparable<std.vector<T>>, 
          Native.ComparableLower, NativeType.SizeofCapable, Iterable<T>, Sequence<type$ref<T>>,
          NativeContainer<T>, Destructors.ClassWithDestructor {

  protected final java.util.function.Supplier<T> defaultValue;
  
  protected T[] array;
  private static final Object[] EMPTY = new Object[0];
  
  protected int end;

  protected StdVector(java.util.function.Supplier<T> defaultValue) {
    this.array = (T[])(EMPTY);
    this.end = 0;
    assert NativeTrace.assertDefaultValue(defaultValue);
    this.defaultValue = defaultValue;
  }
  
  protected StdVector(int initialSize, java.util.function.Supplier<T> defaultValue) {
    this(initialSize, defaultValue, defaultValue);
  }

  protected StdVector(int initialSize, java.util.function.Supplier<T> initialValue, java.util.function.Supplier<T> defaultValue) {
    this(defaultValue);
    this.assignWithSupplier(initialSize, initialValue);
  }

  protected StdVector(T array[], int length, java.util.function.Supplier<T> defaultValue) {
    this.array = array;
    this.end = (int) length;
    assert NativeTrace.assertDefaultValue(defaultValue);
    this.defaultValue = defaultValue;
  }

  protected StdVector(type$iterator<?, T> iter, int length, java.util.function.Supplier<T> defaultValue) {
    this(iter, iter.$add(length), defaultValue);
  }

  protected StdVector(type$iterator<?, T> begin, type$iterator<?, T> end, java.util.function.Supplier<T> defaultValue) {
    this(defaultValue);
    append(begin, end);
  }

  protected StdVector(std.vector<T> other) {
    this(other.defaultValue);
    assert other.checkAlive();
    append(other.begin(), other.end());
  }

  protected StdVector(JavaDifferentiators.JD$Move _dparam, std.vector<T> other) {
    this(other.defaultValue);
    $assignMove(other);
  }
  
  @Override
  public std.vector<T> $assign(std.vector<T> other) {
    assert other.checkAlive();
    if (this == other) {
      return (std.vector<T>) this;
    }
    assert checkAlive();
    this.clear();
    this.array = (T[])(EMPTY);
    append(other.begin(), other.end());
    return (std.vector<T>) this;
  }    

  public std.vector<T> $assignMove(std.vector<T> other) {
    assert other.checkAlive();
    if (this == other) {
      return (std.vector<T>) this;
    }
    assert checkAlive();
    this.clear();
    this.array = other.array;
    this.end = other.end;
    other.array = (T[])(EMPTY);
    other.end = 0;
    return (std.vector<T>) this;
  }   

  public boolean shrink_to_fit() {
    // just don't shrink for now
    return false;
  }  
  
  public void clear() {
    assert checkAlive();
    this.destroy_range(0, this.size());
    this.setEnd(0);
  }

  public void resize(int newSize) {
    resize(newSize, defaultValue);
  }
  
  public void resize(int newSize, T defaultValue) {
    assert checkAlive();
    if (newSize < end) {
      destroy_range(newSize, end);
    } else if (newSize > end) {
      if (this.capacity() < newSize)
        this.grow(newSize);
      for (int i = end; i < newSize; i++) {
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        array[i] = $tryClone(defaultValue);
      }
    }
    this.setEnd(newSize);
  }  

  public void resize(int newSize, java.util.function.Supplier<T> defaultValue) {if (newSize < end) {destroy_range(newSize, end);} else if (newSize > end) {if (this.capacity() < newSize)this.grow(newSize);for (int i = end; i < newSize; i++) {assert NativeTrace.assertArrayHasMutableContent(array, this);array[i] = $getDefaultVal();}}this.setEnd(newSize);}

  public void reserve(int N) {
    assert checkAlive();
    if (this.capacity() < N)
      this.grow(N);
  }

  public void assign(int NumElts, T Elt) {
    assert checkAlive();
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      $set(i, Elt);
    }
  }  

  private void assignWithSupplier(int NumElts, java.util.function.Supplier<T> Supplier) {  
    assert checkAlive();
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      array[i] = (Supplier == null) ? null : Supplier.get();
    }
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
  public void assign$T(type$iterator<?, T> __first, type$iterator<?, T> __last) {
    clear();
    append(__first, __last);
  }  

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 440)
  //</editor-fold>  
  public void swap(StdVector<T> RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    T[] arrTmp = this.array;
    this.array = (T[])RHS.array;
    RHS.array = arrTmp;
    int endTmp = this.end;
    this.end = RHS.end;
    RHS.end = endTmp;
  }
  
  public final /*size_t*/int find(Object elem) {
    assert checkAlive();
    return find(elem, 0);
  }

  public final /*size_t*/int find(Object elem, /*size_t*/int from/*=0*/) {
    assert checkAlive();
    boolean isDataPointerLike = isDataPointerLike();
    for (int i = from; i < this.end; i++) {
      if (Native.$eq(array[i], elem, isDataPointerLike)) {
        return i;
      }
    }
    return npos;
  }
  
  public final boolean contains(Object elem) {
    assert checkAlive();
    return find(elem) != npos;
  }

  public final void remove_if(NativeCallback.BoolPredicate<T> predicate) {
    assert checkAlive();
    if (empty()) {
      return;
    }
    for (int i = 0; i < this.end; i++) {
      if (predicate.$call(array[i])) {
        boolean res = erase_at(i);
        assert res;
        i--; // keep index after erase
      }
    }
  }
  
  public final boolean erase(Object elem) {
    assert checkAlive();
    /*uint*/int index = find(elem);
    return erase_at(index);
  }
  
  private final boolean erase_at(int index) {  
    if (index == npos) {
      return false;
    }
    // destroy element
    assert checkIndex(index);
    destroy_range(index, index+1);
    // shift leftward if not the last
    if (index < end-1) {
      std.copy(this.array, index+1, end-index-1, this.array, index);
    }
    // clean up after shift
    $set(end-1, $getDefaultVal());
    --end;
    return true;
  }
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=478)
  //</editor-fold>
  public iterator erase(iterator I) {
    assert checkAlive();
    assert(I.$greatereq(this.begin())) : "Iterator to erase is out of bounds.";
    assert(I.$less(this.end())) : "Erasing at past-the-end iterator.";

    iterator N = I;
    // Shift all elts down one.
    std.move(I.$add(1), this.end(), I, isDataPointerLike());
    // Drop the last elt.
    this.pop_back();
    return(N);
  } 
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=490)
  //</editor-fold>
  public iterator erase(iterator S, iterator E) {
    assert checkAlive();
    assert(S.$greatereq(this.begin())) : "Range to erase is out of bounds.";
    assert(S.$lesseq(E)) : "Trying to erase invalid range.";
    assert(E.$lesseq(this.end())) : "Trying to erase past the end.";

    iterator N = S;
    // Shift all elts down.
    iterator I = std.move(E, this.end(), S, isDataPointerLike());
    // Drop the last elts.
    this.destroy_range(I, this.end());
    this.setEnd(I);
    return(N);
  }

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=537)
  //</editor-fold>
  public iterator insert(iterator I, T Elt) {
    assert checkAlive();
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
    // Push everything else over.
    std.copy_backward(I, this.end().$sub(1), this.end(), isDataPointerLike());   
    
//  // If we just moved the element we're inserting, be sure to update
//  // the reference.
//  const T *EltPtr = &Elt;
//  if (I <= EltPtr && EltPtr < this->EndX)
//    ++EltPtr;    
    
    I.star$ref().$set($tryAssign(I.$star(), Elt, isDataPointerLike()));
    return I;    
  }  

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=537)
  //</editor-fold>
  public iterator insert_T$RR(iterator I, T/*&&*/ Elt) {
    assert checkAlive();
    if (I.$eq(this.end())) {  // Important special case for empty vector.
      this.push_back_T$RR(Elt);
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
    // Push everything else over.
    std.copy_backward(I, this.end().$sub(1), this.end(), isDataPointerLike());   
    
//  // If we just moved the element we're inserting, be sure to update
//  // the reference.
//  const T *EltPtr = &Elt;
//  if (I <= EltPtr && EltPtr < this->EndX)
//    ++EltPtr;    
    
    I.star$ref().$set($tryMove(I.$star(), Elt, isDataPointerLike()));
    return I;    
  }  
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=568)
  //</editor-fold>  
  public iterator insert(iterator I, int NumToInsert, T Elt) {
    assert checkAlive();
    assert NumToInsert >= 0;
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
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd, isDataPointerLike());

      std.fill_n(I, NumToInsert, Elt);
      return I;
    }

    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.

    // Move over the elements that we're about to overwrite.
    iterator OldEnd = this.end();
    this.setEnd(this.size() + NumToInsert);
    int NumOverwritten = OldEnd.$sub(I);
    std.copy(I, OldEnd, this.end().$sub(NumOverwritten), isDataPointerLike());

    // Replace the overwritten part.
    std.fill_n(I, NumOverwritten, Elt);

    // Insert the non-overwritten middle part.
    std.fill_n(OldEnd, NumToInsert-NumOverwritten, Elt);
    return I;  
  }

  public final iterator insert$T(iterator I, type$iterator<?, T> From, type$iterator<?, T> To) {
    assert checkAlive();
    return insert(I, From, To);
  }
  
  //
public final <U> iterator insert$T(iterator I, type$iterator<?, U> From, type$iterator<?, U> To, NativeCallback.Converter<U,T> convertor) {
throw new UnsupportedOperationException();
}
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=618)
  //</editor-fold>
  public iterator insert(iterator I, type$iterator<?, T> From, type$iterator<?, T> To) {
    assert checkAlive();
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

    if (NumToInsert == 0) return I;
    
    // If there are more elements between the insertion point and the end of the
    // range than there are being inserted, we can use a simple approach to
    // insertion.  Since we already reserved space, we know that this won't
    // reallocate the vector.
    if (this.end().$sub(I) >= NumToInsert) {
      iterator OldEnd = this.end();
      append(this.end().$sub(NumToInsert), this.end());

      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd, isDataPointerLike());

      std.copy(From, To, I, isDataPointerLike());
      return I;
    }

    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.

    // Move over the elements that we're about to overwrite.
    iterator OldEnd = this.end();
    this.setEnd(this.size() + NumToInsert);
    int NumOverwritten = OldEnd.$sub(I);
    std.copy(I, OldEnd, this.end().$sub(NumOverwritten), isDataPointerLike());

    // Replace the overwritten part.
    From = $tryClone(From);
    for (iterator J = Native.$Clone(I); NumOverwritten > 0; --NumOverwritten) {
      J.star$ref().$set(From.$star());
      J.$preInc(); From.$preInc();
    }

    // Insert the non-overwritten middle part.
    std.copy(From, To, OldEnd, isDataPointerLike());
    return I;
  }

  /// append - Add the specified range to the end of the SmallVector.
  ///  
  public void append(type$iterator<?, T> in_start, type$iterator<?, T> in_end) {
    assert checkAlive();
    int NumInputs = std.distance(in_start, in_end);
    if (NumInputs == 0) {
      return;
    }
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
    
    type$iterator<?, T> iter = (type$iterator<?, T>) Native.$Clone(in_start);
    while (!iter.$eq(in_end)) {
      ++end;
      $set(end-1, iter.$star());
      iter.$preInc();
    }
  }
  
  public void append(int NumInputs, T Elt) {
    assert checkAlive();
    assert NumInputs >= 0;
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);

    // Copy the new elements over.
    for (int i = 0; i < NumInputs; i++) {
      ++end;
      $set(end-1, Elt);
    }
  }  

  @Override
  public boolean $eq(std.vector<T> RHS) {
    assert checkAlive();
    assert RHS.checkAlive();
    if (this.size() != RHS.size()) return false;
    return std.equal(this.begin(), this.end(), RHS.begin());
  }

  @Override
  public boolean $noteq(std.vector<T> RHS) {
    return !$eq(RHS);
  }

  @Override
  public boolean $less(Object obj) {
    assert checkAlive();
    assert ((StdVector) obj).checkAlive();
    return std.lexicographical_compare(
        this.begin(), 
        this.end(), 
        ((StdVector) obj).begin(), 
        ((StdVector) obj).end()
    );
  }

  @Override
  public boolean $lesseq(Object obj) {  
    return $less(obj) || $eq((std.vector<T>)obj);
  }

  public type$ref<T> ref$at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return NativePointer.create_type$ref(array, idx);
  }
  
  public T $at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return array[idx];
  }

  public T $at$Const(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return array[idx];
  }

  public T $set(int idx, T value) {
    assert checkAlive();
    assert checkIndex(idx);
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    if (defaultValue == null) {array[(int) idx] = value; } else {array[(int) idx] = $tryAssign(array[(int) idx], value, isDataPointerLike()); } return array[(int) idx];
  }

  protected final T $set$move(int idx, T value) {
    assert checkAlive();
    assert checkIndex(idx);
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    if (defaultValue == null) {array[(int) idx] = value; } else {array[(int) idx] = $tryMove(array[(int) idx], value, isDataPointerLike()); } return array[(int) idx];
  }
  
  public boolean empty() {
    assert checkAlive();
    return this.size() == 0;
  }
  
  public void $destroy() {
    destroy_range(0, this.size());
    this.setEnd(0);
    set$destroyed();
  }
  
  public final void push_back_T$C$R(T val) {
    assert checkAlive();
    push_back(val);
  }
  
  public final void push_back_T$RR(T val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow(2 * this.capacity() + 1);
    }
    end++;
    $set$move(end-1, val);
  }

  public void push_back(T val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow(2 * this.capacity() + 1);
    }
    end++;
    $set(end-1, val);
  }    

  public final void emplace_back(T val) {
    // JConvert already created val externally, 
    // so just prepare space and insert this object into last cell
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow();
    }    
    int index = this.size();
    array[index] = val;
    this.setEnd(index + 1);
  }

  public final void emplace_back() {
    assert checkAlive();
    // here object is not created externally, so use defaultValue and usual push_back
    push_back($getDefaultVal());
  }

  public void pop_back() {
    assert checkAlive();
    destroy_range(this.size() - 1, this.size());
    this.setEnd(this.size() - 1);
  }

  public T pop_back_val() {
    assert checkAlive();
    T val = this.back();
    this.setEnd(end - 1);
    return val;
  }  

  public final iterator<T> begin() {
    assert checkAlive();
    return new iterator<T>(this, 0, false);
  }

  public final iterator<T> cbegin() { return begin$Const(); }
  public final iterator<T> begin$Const() {
    assert checkAlive();
    return begin();
  }

  public final iterator<T> end() {
    assert checkAlive();
    return new iterator<T>(this, end, false);
  }

  public final iterator<T> cend() { return end$Const(); }
  public final iterator<T> end$Const() {
    assert checkAlive();
    return end();
  }
  
  public std.reverse_iterator<T> rbegin() {
    assert checkAlive();
    return new std.reverse_iterator<T>(end());
  }
  
  public final std.reverse_iterator<T> rbegin$Const() {
    assert checkAlive();
    return rbegin();
  }

  public std.reverse_iterator<T> rend() {
    assert checkAlive();
    return new std.reverse_iterator<T>(begin());
  }

  public final std.reverse_iterator<T> rend$Const() {
    assert checkAlive();
    return rend();
  }
  
  public type$ptr<T> data() {
    assert checkAlive();
    return NativePointer.create_type$ptr(array);
  }
  
  public T front() {
    assert checkAlive();
    assert checkIndex(0);
    return array[0];
  }    
  
  public final T front$Const() {
    assert checkAlive();
    return front();
  }    
  
  public T back() {
    assert checkAlive();
    assert checkIndex(end - 1);
    return array[end - 1];
  }    
  
  public final T back$Const() {
    assert checkAlive();
    return back();
  }    
  
  public type$ref<T> ref$front() {
    return new type$ref<T>() {
      {
        assert checkAlive();
        assert checkIndex(0);
      }
      
      private final T stored = array[0];
      
      private final int index = 0;

      @Override
      public T $deref() {
        assert checkAlive();
        assert checkIndex(index);
        return stored;
      }

      @Override
      public T $set(T value) {
        assert checkAlive();
        assert checkIndex(index);
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        if (defaultValue == null) {array[index] = value; } else {array[index] = $tryAssign(array[index], value, isDataPointerLike()); } return array[index];
      }
      
      @Override
      public type$ptr<T> deref$ptr() {
        assert checkAlive();
        assert checkIndex(index);
        return data().$add(index);
      }
    };
  }

  public type$ref<T> ref$back() {
    return  new type$ref<T>() {
      {
        assert checkAlive();
        assert checkIndex(end - 1);
      }
      
      private final T stored = array[end - 1];
      
      private final int index = end - 1;

      @Override
      public T $deref() {
        assert checkAlive();
        assert checkIndex(index);
        return stored;
      }

      @Override
      public T $set(T value) {
        assert checkAlive();
        assert checkIndex(index);
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        if (defaultValue == null) {array[index] = value; } else {array[index] = $tryAssign(array[index], value, isDataPointerLike()); } return array[index];
      }
      
      @Override
      public type$ptr<T> deref$ptr() {
        assert checkAlive();
        assert checkIndex(index);
        return data().$add(index);
      }   
    };
  }
  
  public /*size_t*/int size() /*const*/ {
    assert checkAlive();
    return end;
  }

  public /*size_t*/int max_size() /*const*/ {
    assert checkAlive();
    return Integer.MAX_VALUE; // TODO 
  }

  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  public /*size_t*/int capacity() /*const*/ {
    assert checkAlive();
    return array.length;
  }

  @Override public /*size_t*/int $sizeof() {
    int oneElemSize = NativeType.sizeof(defaultValue);; 
    for (T elem : array) {
      if (elem != defaultValue) {
        oneElemSize = NativeType.sizeof(elem);
        break;
      }
    }
    return capacity() * oneElemSize;
  }

  public type$ptr<T> ptr$at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return create_type$ptr(array, idx);
  }

  @Override
  public std.vector<T> clone() {
    assert checkAlive();
    std.vector<T> out = new std.vector<T>((std.vector<T>) this);
    assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
    return out;
  }

  @Override public std.vector<T> move() {
    assert checkAlive();
    std.vector<T> out = new std.vector<T>(JavaDifferentiators.JD$Move.INSTANCE, (std.vector<T>)this);
    assert this.getClass() == out.getClass() : "forgot to override move in " + out.getClass();
    return out;
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
  public void set_size(int N) {
    assert checkAlive();
    assert N >= 0;
    assert(N <= this.capacity());
    this.setEnd(N);
  }  
  
  private void destroy_range(int from, int to) {
    for (/*uint*/int i = from; i < to; i++) {
			if (defaultValue != null) { 
				Native.destroy(array[(int) i]);
			}
			array[(int) i] = null;
		}
  }

  private void destroy_range(iterator _from, iterator _to) {
    destroy_range(_from.$sub(this.begin()), _to.$sub(this.begin()));
  } 
  
  protected void grow(int newSize) {
    array = copyOf$Object(array, newSize);
  }

  private void grow() {
    this.grow(capacity() > 0 ? capacity() * 2 : 1);
  }  
  
  private void setEnd(int to) {
    end = to;
  }  

  private void setEnd(iterator to) {
    setEnd(to.$sub(this.begin()));
  } 

  @Override
  public Iterator<T> iterator() {
    assert checkAlive();
    return new JavaIterator(begin(), end());
  }

  // Only Java! 
  // Means that in native code vector contained pointers but in Java they were converted as Java references
  public boolean isDataPointerLike() {
    return defaultValue == null;
  }
  
  /*
   * *************************************************************************
   *  Iterators
   * *************************************************************************
   */
    
  public final static class iterator<T> implements type$iterator<iterator<T>, T>, Native.assignable<iterator<T>>, NativeMoveable<iterator<T>>, Native.ComparableLowerGreater {
    
    private final boolean _const;
    private final StdVector<T> delegate;
    private int index;

    public iterator(StdVector<T> delegate, int index, boolean makeConst) {
      assert delegate.checkAlive();
      this.delegate = delegate;
      this.index = index;
      this._const = makeConst;
    }
    
    public iterator(iterator<T> other) {
      assert other.delegate.checkAlive();
      this.delegate = other.delegate;
      this.index = other.index;
      this._const = other._const;
    }
    
    public iterator(JavaDifferentiators.JD$Move _dparam, iterator<T> other) {
      assert other.delegate.checkAlive();
      this.delegate = other.delegate;
      this.index = other.index;
      this._const = other._const;
    }
    
    @Override
    public iterator<T> $assign(iterator<T> other) {
      assert delegate.checkAlive();
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }
    
    @Override
    public iterator<T> $assignMove(iterator<T> other) {
      assert delegate.checkAlive();
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }

    public T $arrow() {
      assert delegate.checkAlive();
      return $at(0);
    }

    @Override
    public T $star() {
      assert delegate.checkAlive();
      return $at(0);
    }
    
    @Override
    public type$ref<T> star$ref() {
      assert delegate.checkAlive();
      return ref$at(0);
    }       

    @Override
    public int $sub(iterator<T> iter) {
      assert delegate.checkAlive();
      assert this.delegate == iter.delegate;
      return this.index - iter.index;
    }

    @Override
    public iterator<T> $preInc() {
      assert delegate.checkAlive();
      assert !_const;
      ++this.index;
      return this;
    }

    @Override
    public iterator<T> $preDec() {
      assert delegate.checkAlive();
      assert !_const;
      --this.index;
      return this;
    }

    @Override
    public iterator<T> $postInc() {
      assert delegate.checkAlive();
      assert !_const;
      iterator<T> cloned = new iterator<T>(delegate, index, false);
      index++;
      return cloned;
    }

    @Override
    public iterator<T> $postDec() {
      assert delegate.checkAlive();
      assert !_const;
      iterator<T> cloned = new iterator<T>(delegate, index, false);
      index--;
      return cloned;
    }

    @Override
    public iterator<T> $inc(int amount) {
      assert delegate.checkAlive();
      assert !_const;
      index+=amount;
      return this;
    }

    @Override
    public iterator<T> $dec(int amount) {
      assert delegate.checkAlive();
      assert !_const;
      index-=amount;
      return this;
    }

    @Override
    public iterator<T> $add(int amount) {
      assert delegate.checkAlive();
      return new iterator<T>(this.delegate, (this.index + amount), false);
    }

    @Override
    public iterator<T> $sub(int amount) {
      assert delegate.checkAlive();
      return new iterator<T>(this.delegate, (this.index - amount), false);
    }

    @Override
    public boolean $noteq(Object other) {
      assert delegate.checkAlive();
      assert ((iterator) other).delegate.checkAlive();
      assert this.delegate == ((iterator) other).delegate;
      return this.index != ((iterator) other).index;
    }

    @Override
    public boolean $eq(Object other) {
      assert delegate.checkAlive();
      assert ((iterator) other).delegate.checkAlive();
      assert this.delegate == ((iterator) other).delegate;
      return this.index == ((iterator) other).index;
    }

    @Override
    public iterator<T> move() {
      assert delegate.checkAlive();
      return new iterator<T>(JavaDifferentiators.JD$Move.INSTANCE, this);
    }
    
    @Override
    public iterator<T> clone() {
      assert delegate.checkAlive();
      return new iterator<T>(delegate, index, false);
    }

    @Override
    public iterator<T> const_clone() {
      assert delegate.checkAlive();
      return new iterator<T>(delegate, index, true);
    }

    @Override
    public boolean $less(Object obj) {
      assert delegate.checkAlive();
      assert ((iterator) obj).delegate.checkAlive();
      assert this.delegate == ((iterator) obj).delegate;
      return this.index < ((iterator) obj).index;
    }

    @Override
    public boolean $lesseq(Object obj) {
      assert delegate.checkAlive();
      assert ((iterator) obj).delegate.checkAlive();
      assert this.delegate == ((iterator) obj).delegate;
      return this.index <= ((iterator) obj).index;
    }

    @Override
    public boolean $greater(Object obj) {
      assert delegate.checkAlive();
      assert ((iterator) obj).delegate.checkAlive();
      assert this.delegate == ((iterator) obj).delegate;
      return this.index > ((iterator) obj).index;
    }

    @Override
    public boolean $greatereq(Object obj) {
      assert delegate.checkAlive();
      assert ((iterator) obj).delegate.checkAlive();
      assert this.delegate == ((iterator) obj).delegate;
      return this.index >= ((iterator) obj).index;
    }

    public T $at(int index) {
      assert delegate.checkAlive();
      return delegate.$at(this.index + index);
    }
    
    public type$ref<T> ref$at(final int index) {
      assert delegate.checkAlive();
      return delegate.ref$at(this.index + index);
    }

    public type$ptr<T> toPointer() {
      assert delegate.checkAlive();
      return create_type$ptr(delegate.array, this.index);
    }

    public int $index() {
      assert delegate.checkAlive();
      assert delegate.checkIndex(index);
      return this.index;
    }
        
    @Override
    public String toString() {
      return "[" + (delegate.is$destroyed()?"DESTROYED " : "") + this.index + "] from\n" + delegate.toString();
    }
  } 

  @Override
  public String toString() {
    String arrName = NativeTrace.getArrayName(array);
    if (this.end == 0) {
      return arrName + (super.is$destroyed() ? "DESTROYED ":"") + "<EMPTY>";
    }
    StringBuilder out = new StringBuilder(arrName);
    if (super.is$destroyed()) {
      out.append("DESTROYED");
    }
    out.append("\n").append(getClass().getSimpleName()).append("{\nend = " + this.end + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      T element = array[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append(element).append('\n');
    }
    out.append("}").append(getClass().getSimpleName()).append("}\n");
    return out.toString();
  }

  private T $getDefaultVal() {
    if (defaultValue != null) {final T res = defaultValue.get();assert res != null : "If stored type is pointer then pass null as a supplier! Nonnull supplier must provide nonull values.";return res;}return null;
  }
  
  protected final boolean checkIndex(int index) {
    assert index < this.end : "invalid index " + index + " when size is " + this.end;
    return true;
  }  
  
  protected final boolean checkAlive() {
    return check$Alive();
  }  
}
