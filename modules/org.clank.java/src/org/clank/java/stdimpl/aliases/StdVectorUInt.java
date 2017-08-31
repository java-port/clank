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
 * StdVector for int
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/java/stdimpl/aliases/templates/StdVector.tpl")
//</editor-fold>
public abstract class StdVectorUInt extends NativeTrace.CreateDestroy$Tracker
        implements Native.NativePOD<std.vectorUInt>,
          NativeMoveable<std.vectorUInt>, Native.NativeComparable<std.vectorUInt>, 
          Native.ComparableLower, NativeType.SizeofCapable, Iterable<Integer>, Sequence<uint$ref>,
          NativeContainerUInt, Destructors.ClassWithDestructor {

  protected final int defaultValue;
  
  protected int[] array;
  private static final int[] EMPTY = new$uint(0);
  
  protected int end;

  protected StdVectorUInt(int defaultValue) {
    this.array = (int[])(EMPTY);
    this.end = 0;
    assert true;
    this.defaultValue = defaultValue;
  }
  
  protected StdVectorUInt(int initialSize, int defaultValue) {
    this(initialSize, defaultValue, defaultValue);
  }

  protected StdVectorUInt(int initialSize, int initialValue, int defaultValue) {
    this(defaultValue);
    this.assignWithSupplier(initialSize, initialValue);
  }

  protected StdVectorUInt(int array[], int length, int defaultValue) {
    this.array = array;
    this.end = (int) length;
    assert true;
    this.defaultValue = defaultValue;
  }

  protected StdVectorUInt(uint$iterator<?> iter, int length, int defaultValue) {
    this(iter, iter.$add(length), defaultValue);
  }

  protected StdVectorUInt(uint$iterator<?> begin, uint$iterator<?> end, int defaultValue) {
    this(defaultValue);
    append(begin, end);
  }

  protected StdVectorUInt(std.vectorUInt other) {
    this(other.defaultValue);
    assert other.checkAlive();
    append(other.begin(), other.end());
  }

  protected StdVectorUInt(JavaDifferentiators.JD$Move _dparam, std.vectorUInt other) {
    this(other.defaultValue);
    $assignMove(other);
  }
  
  @Override
  public std.vectorUInt $assign(std.vectorUInt other) {
    assert other.checkAlive();
    if (this == other) {
      return (std.vectorUInt) this;
    }
    assert checkAlive();
    this.clear();
    this.array = (int[])(EMPTY);
    append(other.begin(), other.end());
    return (std.vectorUInt) this;
  }    

  public std.vectorUInt $assignMove(std.vectorUInt other) {
    assert other.checkAlive();
    if (this == other) {
      return (std.vectorUInt) this;
    }
    assert checkAlive();
    this.clear();
    this.array = other.array;
    this.end = other.end;
    other.array = (int[])(EMPTY);
    other.end = 0;
    return (std.vectorUInt) this;
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
  
  public void resize(int newSize, int defaultValue) {
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

  // No supplier => no version of resize with supplier

  public void reserve(int N) {
    assert checkAlive();
    if (this.capacity() < N)
      this.grow(N);
  }

  public void assign(int NumElts, int Elt) {
    assert checkAlive();
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      $set(i, Elt);
    }
  }  

  private void assignWithSupplier(int NumElts, int Supplier) {  
    assert checkAlive();
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      array[i] = Supplier;
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
  public void assign$T(uint$iterator<?> __first, uint$iterator<?> __last) {
    clear();
    append(__first, __last);
  }  

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 440)
  //</editor-fold>  
  public void swap(StdVectorUInt RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    int[] arrTmp = this.array;
    this.array = (int[])RHS.array;
    RHS.array = arrTmp;
    int endTmp = this.end;
    this.end = RHS.end;
    RHS.end = endTmp;
  }
  
  public final /*size_t*/int find(int elem) {
    assert checkAlive();
    return find(elem, 0);
  }

  public final /*size_t*/int find(int elem, /*size_t*/int from/*=0*/) {
    assert checkAlive();
    boolean isDataPointerLike = isDataPointerLike();
    for (int i = from; i < this.end; i++) {
      if (Native.$eq(array[i], elem, isDataPointerLike)) {
        return i;
      }
    }
    return npos;
  }
  
  public final boolean contains(int elem) {
    assert checkAlive();
    return find(elem) != npos;
  }

  public final void remove_if(NativeCallback.UIntBoolPredicate predicate) {
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
  
  public final boolean erase(int elem) {
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
  public iterator insert(iterator I, int Elt) {
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
  public iterator insert_T$RR(iterator I, int/*&&*/ Elt) {
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
  public iterator insert(iterator I, int NumToInsert, int Elt) {
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

  public final iterator insert$T(iterator I, uint$iterator<?> From, uint$iterator<?> To) {
    assert checkAlive();
    return insert(I, From, To);
  }
  
  //${INSERT_WITH_CONVERSION}
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=618)
  //</editor-fold>
  public iterator insert(iterator I, uint$iterator<?> From, uint$iterator<?> To) {
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
  public void append(uint$iterator<?> in_start, uint$iterator<?> in_end) {
    assert checkAlive();
    int NumInputs = std.distance(in_start, in_end);
    if (NumInputs == 0) {
      return;
    }
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
    
    uint$iterator<?> iter = (uint$iterator<?>) Native.$Clone(in_start);
    while (!iter.$eq(in_end)) {
      ++end;
      $set(end-1, iter.$star());
      iter.$preInc();
    }
  }
  
  public void append(int NumInputs, int Elt) {
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
  public boolean $eq(std.vectorUInt RHS) {
    assert checkAlive();
    assert RHS.checkAlive();
    if (this.size() != RHS.size()) return false;
    return std.equal(this.begin(), this.end(), RHS.begin());
  }

  @Override
  public boolean $noteq(std.vectorUInt RHS) {
    return !$eq(RHS);
  }

  @Override
  public boolean $less(Object obj) {
    assert checkAlive();
    assert ((StdVectorUInt) obj).checkAlive();
    return std.lexicographical_compare(
        this.begin(), 
        this.end(), 
        ((StdVectorUInt) obj).begin(), 
        ((StdVectorUInt) obj).end()
    );
  }

  @Override
  public boolean $lesseq(Object obj) {  
    return $less(obj) || $eq((std.vectorUInt)obj);
  }

  public uint$ref ref$at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return NativePointer.create_uint$ref(array, idx);
  }
  
  public int $at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return array[idx];
  }

  public int $at$Const(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return array[idx];
  }

  public int $set(int idx, int value) {
    assert checkAlive();
    assert checkIndex(idx);
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    array[(int) idx] = value; return value;
  }

  protected final int $set$move(int idx, int value) {
    assert checkAlive();
    assert checkIndex(idx);
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    array[(int) idx] = value; return value;
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
  
  public final void push_back_T$C$R(int val) {
    assert checkAlive();
    push_back(val);
  }
  
  public final void push_back_T$RR(int val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow(2 * this.capacity() + 1);
    }
    end++;
    $set$move(end-1, val);
  }

  public void push_back(int val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow(2 * this.capacity() + 1);
    }
    end++;
    $set(end-1, val);
  }    

  public final void emplace_back(int val) {
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

  public int pop_back_val() {
    assert checkAlive();
    int val = this.back();
    this.setEnd(end - 1);
    return val;
  }  

  public final iterator begin() {
    assert checkAlive();
    return new iterator(this, 0, false);
  }

  public final iterator cbegin() { return begin$Const(); }
  public final iterator begin$Const() {
    assert checkAlive();
    return begin();
  }

  public final iterator end() {
    assert checkAlive();
    return new iterator(this, end, false);
  }

  public final iterator cend() { return end$Const(); }
  public final iterator end$Const() {
    assert checkAlive();
    return end();
  }
  
  public std.reverse_iteratorUInt rbegin() {
    assert checkAlive();
    return new std.reverse_iteratorUInt(end());
  }
  
  public final std.reverse_iteratorUInt rbegin$Const() {
    assert checkAlive();
    return rbegin();
  }

  public std.reverse_iteratorUInt rend() {
    assert checkAlive();
    return new std.reverse_iteratorUInt(begin());
  }

  public final std.reverse_iteratorUInt rend$Const() {
    assert checkAlive();
    return rend();
  }
  
  public uint$ptr data() {
    assert checkAlive();
    return NativePointer.create_uint$ptr(array);
  }
  
  public int front() {
    assert checkAlive();
    assert checkIndex(0);
    return array[0];
  }    
  
  public final int front$Const() {
    assert checkAlive();
    return front();
  }    
  
  public int back() {
    assert checkAlive();
    assert checkIndex(end - 1);
    return array[end - 1];
  }    
  
  public final int back$Const() {
    assert checkAlive();
    return back();
  }    
  
  public uint$ref ref$front() {
    return new uint$ref() {
      {
        assert checkAlive();
        assert checkIndex(0);
      }
      
      private final int stored = array[0];
      
      private final int index = 0;

      @Override
      public int $deref() {
        assert checkAlive();
        assert checkIndex(index);
        return stored;
      }

      @Override
      public int $set(int value) {
        assert checkAlive();
        assert checkIndex(index);
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        array[index] = value; return value;
      }
      
      @Override
      public uint$ptr deref$ptr() {
        assert checkAlive();
        assert checkIndex(index);
        return data().$add(index);
      }
    };
  }

  public uint$ref ref$back() {
    return  new uint$ref() {
      {
        assert checkAlive();
        assert checkIndex(end - 1);
      }
      
      private final int stored = array[end - 1];
      
      private final int index = end - 1;

      @Override
      public int $deref() {
        assert checkAlive();
        assert checkIndex(index);
        return stored;
      }

      @Override
      public int $set(int value) {
        assert checkAlive();
        assert checkIndex(index);
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        array[index] = value; return value;
      }
      
      @Override
      public uint$ptr deref$ptr() {
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
    for (int elem : array) {
      if (elem != defaultValue) {
        oneElemSize = NativeType.sizeof(elem);
        break;
      }
    }
    return capacity() * oneElemSize;
  }

  public uint$ptr ptr$at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return create_uint$ptr(array, idx);
  }

  @Override
  public std.vectorUInt clone() {
    assert checkAlive();
    std.vectorUInt out = new std.vectorUInt((std.vectorUInt) this);
    assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
    return out;
  }

  @Override public std.vectorUInt move() {
    assert checkAlive();
    std.vectorUInt out = new std.vectorUInt(JavaDifferentiators.JD$Move.INSTANCE, (std.vectorUInt)this);
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
    /*Do not need to destroy primitive types*/
  }

  private void destroy_range(iterator _from, iterator _to) {
    destroy_range(_from.$sub(this.begin()), _to.$sub(this.begin()));
  } 
  
  protected void grow(int newSize) {
    array = copyOf$uint(array, newSize);
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
  public Iterator<Integer> iterator() {
    assert checkAlive();
    return new JavaIteratorUInt(begin(), end());
  }

  // Only Java! 
  // Means that in native code vector contained pointers but in Java they were converted as Java references
  public boolean isDataPointerLike() {
    return false;
  }
  
  /*
   * *************************************************************************
   *  Iterators
   * *************************************************************************
   */
    
  public final static class iterator implements uint$iterator<iterator>, Native.assignable<iterator>, NativeMoveable<iterator>, Native.ComparableLowerGreater {
    
    private final boolean _const;
    private final StdVectorUInt delegate;
    private int index;

    public iterator(StdVectorUInt delegate, int index, boolean makeConst) {
      assert delegate.checkAlive();
      this.delegate = delegate;
      this.index = index;
      this._const = makeConst;
    }
    
    public iterator(iterator other) {
      assert other.delegate.checkAlive();
      this.delegate = other.delegate;
      this.index = other.index;
      this._const = other._const;
    }
    
    public iterator(JavaDifferentiators.JD$Move _dparam, iterator other) {
      assert other.delegate.checkAlive();
      this.delegate = other.delegate;
      this.index = other.index;
      this._const = other._const;
    }
    
    @Override
    public iterator $assign(iterator other) {
      assert delegate.checkAlive();
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }
    
    @Override
    public iterator $assignMove(iterator other) {
      assert delegate.checkAlive();
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }

    public int $arrow() {
      assert delegate.checkAlive();
      return $at(0);
    }

    @Override
    public int $star() {
      assert delegate.checkAlive();
      return $at(0);
    }
    
    @Override
    public uint$ref star$ref() {
      assert delegate.checkAlive();
      return ref$at(0);
    }       

    @Override
    public int $sub(iterator iter) {
      assert delegate.checkAlive();
      assert this.delegate == iter.delegate;
      return this.index - iter.index;
    }

    @Override
    public iterator $preInc() {
      assert delegate.checkAlive();
      assert !_const;
      ++this.index;
      return this;
    }

    @Override
    public iterator $preDec() {
      assert delegate.checkAlive();
      assert !_const;
      --this.index;
      return this;
    }

    @Override
    public iterator $postInc() {
      assert delegate.checkAlive();
      assert !_const;
      iterator cloned = new iterator(delegate, index, false);
      index++;
      return cloned;
    }

    @Override
    public iterator $postDec() {
      assert delegate.checkAlive();
      assert !_const;
      iterator cloned = new iterator(delegate, index, false);
      index--;
      return cloned;
    }

    @Override
    public iterator $inc(int amount) {
      assert delegate.checkAlive();
      assert !_const;
      index+=amount;
      return this;
    }

    @Override
    public iterator $dec(int amount) {
      assert delegate.checkAlive();
      assert !_const;
      index-=amount;
      return this;
    }

    @Override
    public iterator $add(int amount) {
      assert delegate.checkAlive();
      return new iterator(this.delegate, (this.index + amount), false);
    }

    @Override
    public iterator $sub(int amount) {
      assert delegate.checkAlive();
      return new iterator(this.delegate, (this.index - amount), false);
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
    public iterator move() {
      assert delegate.checkAlive();
      return new iterator(JavaDifferentiators.JD$Move.INSTANCE, this);
    }
    
    @Override
    public iterator clone() {
      assert delegate.checkAlive();
      return new iterator(delegate, index, false);
    }

    @Override
    public iterator const_clone() {
      assert delegate.checkAlive();
      return new iterator(delegate, index, true);
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

    public int $at(int index) {
      assert delegate.checkAlive();
      return delegate.$at(this.index + index);
    }
    
    public uint$ref ref$at(final int index) {
      assert delegate.checkAlive();
      return delegate.ref$at(this.index + index);
    }

    public uint$ptr toPointer() {
      assert delegate.checkAlive();
      return create_uint$ptr(delegate.array, this.index);
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
      int element = array[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append(element).append('\n');
    }
    out.append("}").append(getClass().getSimpleName()).append("}\n");
    return out.toString();
  }

  private int $getDefaultVal() {
    return defaultValue;
  }
  
  protected final boolean checkIndex(int index) {
    assert index < this.end : "invalid index " + index + " when size is " + this.end;
    return true;
  }  
  
  protected final boolean checkAlive() {
    return check$Alive();
  }  
}
