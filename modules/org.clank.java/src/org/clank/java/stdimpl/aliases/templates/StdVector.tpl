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
 * StdVector for ${TYPE}
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.clank.java/src/org/clank/java/stdimpl/aliases/templates/StdVector.tpl")
//</editor-fold>
public abstract class ${FILE_NAME}${CLASS_SUFFIX} extends NativeTrace.CreateDestroy$Tracker
        implements Native.NativePOD<${MAIN_CLASS}>,
          NativeMoveable<${MAIN_CLASS}>, Native.NativeComparable<${MAIN_CLASS}>, 
          Native.ComparableLower, NativeType.SizeofCapable, Iterable<${BOXED_TYPE}>, Sequence<${REFERENCE_TYPE}>,
          ${NATIVE_CONTAINER}, Destructors.ClassWithDestructor {

  protected final ${SUPPLIER} defaultValue;
  
  protected ${TYPE}[] array;
  private static final ${ARRAY_TYPE}[] EMPTY = ${NEW_ZERO_ARRAY};
  
  protected int end;

  protected ${FILE_NAME}(${SUPPLIER} defaultValue) {
    this.array = (${TYPE}[])(EMPTY);
    this.end = 0;
    assert ${ASSERT_DEFAULT_VALUE};
    this.defaultValue = defaultValue;
  }
  
  protected ${FILE_NAME}(int initialSize, ${SUPPLIER} defaultValue) {
    this(initialSize, defaultValue, defaultValue);
  }

  protected ${FILE_NAME}(int initialSize, ${SUPPLIER} initialValue, ${SUPPLIER} defaultValue) {
    this(defaultValue);
    this.assignWithSupplier(initialSize, initialValue);
  }

  protected ${FILE_NAME}(${TYPE} array[], int length, ${SUPPLIER} defaultValue) {
    this.array = array;
    this.end = (int) length;
    assert ${ASSERT_DEFAULT_VALUE};
    this.defaultValue = defaultValue;
  }

  protected ${FILE_NAME}(${GENERIC_ITERATOR} iter, int length, ${SUPPLIER} defaultValue) {
    this(iter, iter.$add(length), defaultValue);
  }

  protected ${FILE_NAME}(${GENERIC_ITERATOR} begin, ${GENERIC_ITERATOR} end, ${SUPPLIER} defaultValue) {
    this(defaultValue);
    append(begin, end);
  }

  protected ${FILE_NAME}(${MAIN_CLASS} other) {
    this(other.defaultValue);
    assert other.checkAlive();
    append(other.begin(), other.end());
  }

  protected ${FILE_NAME}(JavaDifferentiators.JD$Move _dparam, ${MAIN_CLASS} other) {
    this(other.defaultValue);
    $assignMove(other);
  }
  
  @Override
  public ${MAIN_CLASS} $assign(${MAIN_CLASS} other) {
    assert other.checkAlive();
    if (this == other) {
      return (${MAIN_CLASS}) this;
    }
    assert checkAlive();
    this.clear();
    this.array = (${TYPE}[])(EMPTY);
    append(other.begin(), other.end());
    return (${MAIN_CLASS}) this;
  }    

  public ${MAIN_CLASS} $assignMove(${MAIN_CLASS} other) {
    assert other.checkAlive();
    if (this == other) {
      return (${MAIN_CLASS}) this;
    }
    assert checkAlive();
    this.clear();
    this.array = other.array;
    this.end = other.end;
    other.array = (${TYPE}[])(EMPTY);
    other.end = 0;
    return (${MAIN_CLASS}) this;
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
  
  public void resize(int newSize, ${TYPE} defaultValue) {
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

  ${RESIZE_WITH_SUPPLIER}

  public void reserve(int N) {
    assert checkAlive();
    if (this.capacity() < N)
      this.grow(N);
  }

  public void assign(int NumElts, ${TYPE} Elt) {
    assert checkAlive();
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      $set(i, Elt);
    }
  }  

  private void assignWithSupplier(int NumElts, ${SUPPLIER} Supplier) {  
    assert checkAlive();
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      array[i] = ${USE_OF_SUPPLIER};
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
  public void assign$T(${GENERIC_ITERATOR} __first, ${GENERIC_ITERATOR} __last) {
    clear();
    append(__first, __last);
  }  

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 440)
  //</editor-fold>  
  public void swap(${FILE_NAME}${CLASS_SUFFIX} RHS) {
    assert RHS.checkAlive();
    assert checkAlive();
    ${TYPE}[] arrTmp = this.array;
    this.array = (${TYPE}[])RHS.array;
    RHS.array = arrTmp;
    int endTmp = this.end;
    this.end = RHS.end;
    RHS.end = endTmp;
  }
  
  public final /*size_t*/int find(${ARRAY_TYPE} elem) {
    assert checkAlive();
    return find(elem, 0);
  }

  public final /*size_t*/int find(${ARRAY_TYPE} elem, /*size_t*/int from/*=0*/) {
    assert checkAlive();
    boolean isDataPointerLike = isDataPointerLike();
    for (int i = from; i < this.end; i++) {
      if (Native.$eq(array[i], elem, isDataPointerLike)) {
        return i;
      }
    }
    return npos;
  }
  
  public final boolean contains(${ARRAY_TYPE} elem) {
    assert checkAlive();
    return find(elem) != npos;
  }

  public final void remove_if(${ELEMENT_BOOL_PREDICATE} predicate) {
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
  
  public final boolean erase(${ARRAY_TYPE} elem) {
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
  public iterator insert(iterator I, ${TYPE} Elt) {
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
  public iterator insert_T$RR(iterator I, ${TYPE}/*&&*/ Elt) {
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
  public iterator insert(iterator I, int NumToInsert, ${TYPE} Elt) {
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

  public final iterator insert$T(iterator I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
    assert checkAlive();
    return insert(I, From, To);
  }
  
  //${INSERT_WITH_CONVERSION}
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=618)
  //</editor-fold>
  public iterator insert(iterator I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
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
  public void append(${GENERIC_ITERATOR} in_start, ${GENERIC_ITERATOR} in_end) {
    assert checkAlive();
    int NumInputs = std.distance(in_start, in_end);
    if (NumInputs == 0) {
      return;
    }
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
    
    ${GENERIC_ITERATOR} iter = (${GENERIC_ITERATOR}) Native.$Clone(in_start);
    while (!iter.$eq(in_end)) {
      ++end;
      $set(end-1, iter.$star());
      iter.$preInc();
    }
  }
  
  public void append(int NumInputs, ${TYPE} Elt) {
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
  public boolean $eq(${MAIN_CLASS} RHS) {
    assert checkAlive();
    assert RHS.checkAlive();
    if (this.size() != RHS.size()) return false;
    return std.equal(this.begin(), this.end(), RHS.begin());
  }

  @Override
  public boolean $noteq(${MAIN_CLASS} RHS) {
    return !$eq(RHS);
  }

  @Override
  public boolean $less(Object obj) {
    assert checkAlive();
    assert ((${FILE_NAME}) obj).checkAlive();
    return std.lexicographical_compare(
        this.begin(), 
        this.end(), 
        ((${FILE_NAME}) obj).begin(), 
        ((${FILE_NAME}) obj).end()
    );
  }

  @Override
  public boolean $lesseq(Object obj) {  
    return $less(obj) || $eq((${MAIN_CLASS})obj);
  }

  public ${REFERENCE_TYPE} ref$at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return NativePointer.${REFERENCE_FACTORY_MTD}(array, idx);
  }
  
  public ${TYPE} $at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return array[idx];
  }

  public ${TYPE} $at$Const(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return array[idx];
  }

  public ${TYPE} $set(int idx, ${TYPE} value) {
    assert checkAlive();
    assert checkIndex(idx);
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    ${SET_IMPL}
  }

  protected final ${TYPE} $set$move(int idx, ${TYPE} value) {
    assert checkAlive();
    assert checkIndex(idx);
    assert NativeTrace.assertArrayHasMutableContent(array, this);
    ${SET_MOVE_IMPL}
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
  
  public final void push_back_T$C$R(${TYPE} val) {
    assert checkAlive();
    push_back(val);
  }
  
  public final void push_back_T$RR(${TYPE} val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow(2 * this.capacity() + 1);
    }
    end++;
    $set$move(end-1, val);
  }

  public void push_back(${TYPE} val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow(2 * this.capacity() + 1);
    }
    end++;
    $set(end-1, val);
  }    

  public final void emplace_back(${TYPE} val) {
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

  public ${TYPE} pop_back_val() {
    assert checkAlive();
    ${TYPE} val = this.back();
    this.setEnd(end - 1);
    return val;
  }  

  public final ${ITERATOR_TYPE} begin() {
    assert checkAlive();
    return new ${ITERATOR_TYPE}(this, 0, false);
  }

  public final ${ITERATOR_TYPE} cbegin() { return begin$Const(); }
  public final ${ITERATOR_TYPE} begin$Const() {
    assert checkAlive();
    return begin();
  }

  public final ${ITERATOR_TYPE} end() {
    assert checkAlive();
    return new ${ITERATOR_TYPE}(this, end, false);
  }

  public final ${ITERATOR_TYPE} cend() { return end$Const(); }
  public final ${ITERATOR_TYPE} end$Const() {
    assert checkAlive();
    return end();
  }
  
  public ${REV_ITERATOR_TYPE} rbegin() {
    assert checkAlive();
    return new ${REV_ITERATOR_TYPE}(end());
  }
  
  public final ${REV_ITERATOR_TYPE} rbegin$Const() {
    assert checkAlive();
    return rbegin();
  }

  public ${REV_ITERATOR_TYPE} rend() {
    assert checkAlive();
    return new ${REV_ITERATOR_TYPE}(begin());
  }

  public final ${REV_ITERATOR_TYPE} rend$Const() {
    assert checkAlive();
    return rend();
  }
  
  public ${POINTER_TYPE} data() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array);
  }
  
  public ${TYPE} front() {
    assert checkAlive();
    assert checkIndex(0);
    return array[0];
  }    
  
  public final ${TYPE} front$Const() {
    assert checkAlive();
    return front();
  }    
  
  public ${TYPE} back() {
    assert checkAlive();
    assert checkIndex(end - 1);
    return array[end - 1];
  }    
  
  public final ${TYPE} back$Const() {
    assert checkAlive();
    return back();
  }    
  
  public ${REFERENCE_TYPE} ref$front() {
    return new ${REFERENCE_TYPE}() {
      {
        assert checkAlive();
        assert checkIndex(0);
      }
      
      private final ${TYPE} stored = array[0];
      
      private final int index = 0;

      @Override
      public ${TYPE} $deref() {
        assert checkAlive();
        assert checkIndex(index);
        return stored;
      }

      @Override
      public ${TYPE} $set(${TYPE} value) {
        assert checkAlive();
        assert checkIndex(index);
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        ${REF_SET_IMPL}
      }
      
      @Override
      public ${POINTER_TYPE} deref$ptr() {
        assert checkAlive();
        assert checkIndex(index);
        return data().$add(index);
      }
    };
  }

  public ${REFERENCE_TYPE} ref$back() {
    return  new ${REFERENCE_TYPE}() {
      {
        assert checkAlive();
        assert checkIndex(end - 1);
      }
      
      private final ${TYPE} stored = array[end - 1];
      
      private final int index = end - 1;

      @Override
      public ${TYPE} $deref() {
        assert checkAlive();
        assert checkIndex(index);
        return stored;
      }

      @Override
      public ${TYPE} $set(${TYPE} value) {
        assert checkAlive();
        assert checkIndex(index);
        assert NativeTrace.assertArrayHasMutableContent(array, this);
        ${REF_SET_IMPL}
      }
      
      @Override
      public ${POINTER_TYPE} deref$ptr() {
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
    for (${TYPE} elem : array) {
      if (elem != defaultValue) {
        oneElemSize = NativeType.sizeof(elem);
        break;
      }
    }
    return capacity() * oneElemSize;
  }

  public ${POINTER_TYPE} ptr$at(int idx) {
    assert checkAlive();
    assert checkIndex(idx);
    return ${POINTER_FACTORY_MTD}(array, idx);
  }

  @Override
  public ${MAIN_CLASS} clone() {
    assert checkAlive();
    ${MAIN_CLASS} out = new ${MAIN_CLASS}((${MAIN_CLASS}) this);
    assert this.getClass() == out.getClass() : "forgot to override clone in " + out.getClass();
    return out;
  }

  @Override public ${MAIN_CLASS} move() {
    assert checkAlive();
    ${MAIN_CLASS} out = new ${MAIN_CLASS}(JavaDifferentiators.JD$Move.INSTANCE, (${MAIN_CLASS})this);
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
    ${DESTROY_RANGE_IMPL}
  }

  private void destroy_range(iterator _from, iterator _to) {
    destroy_range(_from.$sub(this.begin()), _to.$sub(this.begin()));
  } 
  
  protected void grow(int newSize) {
    array = ${COPY_OF_ARRAY}(array, newSize);
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
  public Iterator<${BOXED_TYPE}> iterator() {
    assert checkAlive();
    return new ${JAVA_ITERATOR}(begin(), end());
  }

  // Only Java! 
  // Means that in native code vector contained pointers but in Java they were converted as Java references
  public boolean isDataPointerLike() {
    ${IS_DATA_POINTER_LIKE_IMPL}
  }
  
  /*
   * *************************************************************************
   *  Iterators
   * *************************************************************************
   */
    
  public final static class ${ITERATOR_TYPE} implements ${ITERATOR_INTERFACE}, Native.assignable<${ITERATOR_TYPE}>, NativeMoveable<${ITERATOR_TYPE}>, Native.ComparableLowerGreater {
    
    private final boolean _const;
    private final ${FILE_NAME}${CLASS_SUFFIX} delegate;
    private int index;

    public iterator(${FILE_NAME}${CLASS_SUFFIX} delegate, int index, boolean makeConst) {
      assert delegate.checkAlive();
      this.delegate = delegate;
      this.index = index;
      this._const = makeConst;
    }
    
    public iterator(${ITERATOR_TYPE} other) {
      assert other.delegate.checkAlive();
      this.delegate = other.delegate;
      this.index = other.index;
      this._const = other._const;
    }
    
    public iterator(JavaDifferentiators.JD$Move _dparam, ${ITERATOR_TYPE} other) {
      assert other.delegate.checkAlive();
      this.delegate = other.delegate;
      this.index = other.index;
      this._const = other._const;
    }
    
    @Override
    public ${ITERATOR_TYPE} $assign(${ITERATOR_TYPE} other) {
      assert delegate.checkAlive();
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }
    
    @Override
    public ${ITERATOR_TYPE} $assignMove(${ITERATOR_TYPE} other) {
      assert delegate.checkAlive();
      assert this.delegate == other.delegate;
      this.index = other.index;
      return this;
    }

    public ${TYPE} $arrow() {
      assert delegate.checkAlive();
      return $at(0);
    }

    @Override
    public ${TYPE} $star() {
      assert delegate.checkAlive();
      return $at(0);
    }
    
    @Override
    public ${REFERENCE_TYPE} star$ref() {
      assert delegate.checkAlive();
      return ref$at(0);
    }       

    @Override
    public int $sub(${ITERATOR_TYPE} iter) {
      assert delegate.checkAlive();
      assert this.delegate == iter.delegate;
      return this.index - iter.index;
    }

    @Override
    public ${ITERATOR_TYPE} $preInc() {
      assert delegate.checkAlive();
      assert !_const;
      ++this.index;
      return this;
    }

    @Override
    public ${ITERATOR_TYPE} $preDec() {
      assert delegate.checkAlive();
      assert !_const;
      --this.index;
      return this;
    }

    @Override
    public ${ITERATOR_TYPE} $postInc() {
      assert delegate.checkAlive();
      assert !_const;
      ${ITERATOR_TYPE} cloned = new ${ITERATOR_TYPE}(delegate, index, false);
      index++;
      return cloned;
    }

    @Override
    public ${ITERATOR_TYPE} $postDec() {
      assert delegate.checkAlive();
      assert !_const;
      ${ITERATOR_TYPE} cloned = new ${ITERATOR_TYPE}(delegate, index, false);
      index--;
      return cloned;
    }

    @Override
    public ${ITERATOR_TYPE} $inc(int amount) {
      assert delegate.checkAlive();
      assert !_const;
      index+=amount;
      return this;
    }

    @Override
    public ${ITERATOR_TYPE} $dec(int amount) {
      assert delegate.checkAlive();
      assert !_const;
      index-=amount;
      return this;
    }

    @Override
    public ${ITERATOR_TYPE} $add(int amount) {
      assert delegate.checkAlive();
      return new ${ITERATOR_TYPE}(this.delegate, (this.index + amount), false);
    }

    @Override
    public ${ITERATOR_TYPE} $sub(int amount) {
      assert delegate.checkAlive();
      return new ${ITERATOR_TYPE}(this.delegate, (this.index - amount), false);
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
    public ${ITERATOR_TYPE} move() {
      assert delegate.checkAlive();
      return new ${ITERATOR_TYPE}(JavaDifferentiators.JD$Move.INSTANCE, this);
    }
    
    @Override
    public ${ITERATOR_TYPE} clone() {
      assert delegate.checkAlive();
      return new ${ITERATOR_TYPE}(delegate, index, false);
    }

    @Override
    public ${ITERATOR_TYPE} const_clone() {
      assert delegate.checkAlive();
      return new ${ITERATOR_TYPE}(delegate, index, true);
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

    public ${TYPE} $at(int index) {
      assert delegate.checkAlive();
      return delegate.$at(this.index + index);
    }
    
    public ${REFERENCE_TYPE} ref$at(final int index) {
      assert delegate.checkAlive();
      return delegate.ref$at(this.index + index);
    }

    public ${POINTER_TYPE} toPointer() {
      assert delegate.checkAlive();
      return ${POINTER_FACTORY_MTD}(delegate.array, this.index);
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
      ${TYPE} element = array[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      ${SB_APPEND_ELEMENT_I};
    }
    out.append("}").append(getClass().getSimpleName()).append("}\n");
    return out.toString();
  }

  private ${TYPE} $getDefaultVal() {
    ${DEFVAL_WITH_SUPPLIER};
  }
  
  protected final boolean checkIndex(int index) {
    assert index < this.end : "invalid index " + index + " when size is " + this.end;
    return true;
  }  
  
  protected final boolean checkAlive() {
    return check$Alive();
  }  
}
