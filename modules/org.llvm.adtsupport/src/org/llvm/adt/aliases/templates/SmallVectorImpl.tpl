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
package ${PACKAGE};

${IMPORT}
import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.Converted;
import org.clank.support.Native;
import org.clank.support.NativePointer;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import org.clank.support.NativeCallback.*;
import static org.clank.support.Native.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.java.SmallVectorImplCommon;
import static org.clank.java.std.string.npos;

/**
 * SmallVectorImpl for ${TYPE}
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
public ${CLASS_SPECIFIER} class ${FILE_NAME}${CLASS_SUFFIX} extends NativeTrace.CreateDestroy$Tracker
 implements assignable<${FILE_NAME}${CLASS_SUFFIX}>,
  Native.NativeComparable<${FILE_NAME}${CLASS_SUFFIX}>, Native.ComparableLower, 
  NativeType.SizeofCapable, NativeSwappable, 
  Iterable<${BOXED_TYPE}>, NativeIterable<${ITERATOR_TYPE}>, 
  NativeReverseIterable<${REV_ITERATOR_TYPE}>, ${NATIVE_CONTAINER} ${COMMA_SMALL_VECTOR_IMPL_COMMON} {  

  protected final ${TYPE} defaultValue;
  
  private ${TYPE}[] array;
  private static final ${ARRAY_TYPE}[] EMPTY = ${NEW_ZERO_ARRAY};

  private int end;

  ${INNER_METHOD_VISIBILITY} final ${TYPE}[] $array() {
    assert checkAlive();
    return this.array;
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(int capacity, ${TYPE} defaultValue) {
    this.array = (${TYPE}[]) (capacity == 0 ? EMPTY : ${NEW_CAPACITY_ARRAY});
    this.end = 0;
    assert ${ASSERT_DEFAULT_VALUE};
    this.defaultValue = defaultValue;
  }
  
  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(int capacity, int initialSize, ${TYPE} defaultValue) {
    this(capacity, defaultValue);
    this.assign(initialSize, defaultValue);
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(JD$UInt_T$C$R _dparam, int capacity, int initialSize, ${TYPE} defaultValue) {
    this(capacity, defaultValue);
    this.assign(initialSize, defaultValue);
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(JD$UInt_T$C$R _dparam, int capacity, int initialSize, ${TYPE} value, ${TYPE} defaultValue) {
    this(capacity, defaultValue);
    this.assign(initialSize, value);
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(${TYPE} array[], ${TYPE} defaultValue) {
    this.array = array;
    this.end = array == null ? 0 : array.length;
    assert ${ASSERT_DEFAULT_VALUE};
    this.defaultValue = defaultValue;
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(int capacity, ${GENERIC_ITERATOR} iter, int length, ${TYPE} defaultValue) {
    this(capacity, iter, iter.$add(length), defaultValue);
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(int capacity, ${GENERIC_ITERATOR} begin, ${GENERIC_ITERATOR} end, ${TYPE} defaultValue) {
    this(capacity, defaultValue);
    append_T(begin, end);
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(${FILE_NAME}${CLASS_SUFFIX} other) {
    assert other.checkAlive();
    this.defaultValue = other.defaultValue;
    int capacity = other.size();
    this.array = (${TYPE}[]) (capacity == 0 ? EMPTY : ${NEW_CAPACITY_ARRAY});
    append_T(other.begin(), other.end());
  }

  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(JD$Move _dparam, ${FILE_NAME}${CLASS_SUFFIX} other) {
    assert other.checkAlive();
    this.defaultValue = other.defaultValue;
    this.array = other.array;
    this.end = other.end;
    
    other.array = (${TYPE}[])EMPTY;
    other.end = 0;
  }
  
//  ${CONSTRUCTOR_VISIBILITY} ${FILE_NAME}(${TYPE}... arr) {
//      // TODO: think over: this uses passed array as a backing store, 
//      // which is effective, but probably error prone; consider copynig
//      array = arr;
//      end = arr.length;
//  }

  @Override
  public final ${FILE_NAME}${CLASS_SUFFIX} $assign(${FILE_NAME}${CLASS_SUFFIX} other) {
    assert checkAlive();
    assert other.checkAlive();
    if (this == other) {
      return this;
    }
    this.clear();
    this.array = (${TYPE}[])(EMPTY);
    append_T(other.begin(), other.end());
    return this;
  }    

  public final ${FILE_NAME}${CLASS_SUFFIX} $assignMove(${FILE_NAME}${CLASS_SUFFIX} other) {
    assert checkAlive();
    assert other.checkAlive();
    assert this != other : "moving self";
    this.array = other.array;
    this.end = other.end;
    other.array = (${TYPE}[])EMPTY;
    other.end = 0;      
    return this;
  }    

  public final void clear() {
    assert checkAlive();
    this.destroy_range(0, this.size());
    this.setEnd(0);
  }

  public final boolean resize(int newSize) {
    assert checkAlive();
    return resize(newSize, defaultValue);
  }
  
  public final boolean resize(int newSize, ${TYPE} defaultValue) {
    assert checkAlive();
    assert newSize >= 0 : "can not be negative " + newSize;
    boolean grown = false;
    if (newSize < end) {
      destroy_range(newSize, end);
    } else if (newSize > end) {
      if (this.capacity() < newSize) {
        this.grow(newSize);
        grown = true;
      }
      for (int i = end; i < newSize; i++) {
        array[i] = $tryClone(defaultValue);
      }
    }
    this.setEnd(newSize);
    return grown;
  }  

  public final void reserve(int N) {
    assert checkAlive();
    assert N >= 0 : "can not be negative " + N;
    if (this.capacity() < N)
      this.grow(N);
  }

  public final void assign(int NumElts, ${TYPE} Elt) {
    assert checkAlive();
    assert NumElts >= 0 : "can not be negative " + NumElts;
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      $set(i, Elt);
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
  public final void assign$T(${GENERIC_ITERATOR} __first, ${GENERIC_ITERATOR} __last) {
    assert checkAlive();
    clear();
    append_T(__first, __last);
  }
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line = 700)
  //</editor-fold> 
  @Override public final void swap(NativeSwappable _RHS) {
    assert checkAlive();
    ${FILE_NAME}${CLASS_SUFFIX} RHS = (${FILE_NAME}${CLASS_SUFFIX})_RHS;
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

  public final boolean erase(${ARRAY_TYPE} elem) {
    assert checkAlive();
    /*uint*/int index = find(elem);
    if (index == npos) {
      return false;
    }
    // destroy element
    destroy_range(index, index+1);
    // shift leftward if not the last
    --end;
    if (index < end) {
      // we just move here
      NativePointer.copy$Object(this.array, index+1, this.array, index, end-index);
    }
    // clean up after shift
    $set(end, defaultValue);
    return true;
  }
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=478)
  //</editor-fold>
  public final ${ITERATOR_TYPE} erase(${ITERATOR_TYPE} I) {
    assert checkAlive();
    assert(I.$greatereq(this.begin())) : "Iterator to erase is out of bounds.";
    assert(I.$less(this.end())) : "Erasing at past-the-end iterator.";

    ${ITERATOR_TYPE} N = I;
    // Shift all elts down one.
    std.copy(I.$add(1), this.end(), I${STD_COPY_TRAILING_ARG});
    // Drop the last elt.
    this.pop_back();
    return(N);
  } 
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=490)
  //</editor-fold>
  public final ${ITERATOR_TYPE} erase(${ITERATOR_TYPE} S, ${ITERATOR_TYPE} E) {
    assert checkAlive();
    assert(S.$greatereq(this.begin())) : "Range to erase is out of bounds.";
    assert(S.$lesseq(E)) : "Trying to erase invalid range.";
    assert(E.$lesseq(this.end())) : "Trying to erase past the end.";

    ${ITERATOR_TYPE} N = S;
    // Shift all elts down.
    ${ITERATOR_TYPE} I = std.copy(E, this.end(), S${STD_COPY_TRAILING_ARG});
    // Drop the last elts.
    this.destroy_range(I, this.end());
    this.setEnd(I);
    return(N);
  }
  
  public ${ITERATOR_TYPE} insert_iterator$T$value_T$RR(${ITERATOR_TYPE} I, ${TYPE}/*&&*/ Elt) {
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
    std.copy_backward(I, this.end().$sub(1), this.end()${STD_COPY_TRAILING_ARG});   
    
//  // If we just moved the element we're inserting, be sure to update
//  // the reference.
//  const T *EltPtr = &Elt;
//  if (I <= EltPtr && EltPtr < this->EndX)
//    ++EltPtr;    
    
    I.$set(Native.$tryMove(I.$star(), Elt, isDataPointerLike()));
    return I;
  }

  public ${ITERATOR_TYPE} insert_iterator$T_T$C$R(${ITERATOR_TYPE} I, ${TYPE}/*&*/ Elt) {
    return insert(I, Elt);
  }
  
  public ${ITERATOR_TYPE} insert_iterator$T$value_T$C$R(${ITERATOR_TYPE} I, ${TYPE}/*&*/ Elt) {
    return insert(I, Elt);
  }
  
  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=537)
  //</editor-fold>
  public final ${ITERATOR_TYPE} insert(${ITERATOR_TYPE} I, ${TYPE} Elt) {
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
    std.copy_backward(I, this.end().$sub(1), this.end()${STD_COPY_TRAILING_ARG});   
    
//  // If we just moved the element we're inserting, be sure to update
//  // the reference.
//  const T *EltPtr = &Elt;
//  if (I <= EltPtr && EltPtr < this->EndX)
//    ++EltPtr;    
    
    I.$set(Native.$tryAssign(null/*do not overwrite existing element*/, Elt, isDataPointerLike()));
    return I;    
  }  

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=568)
  //</editor-fold>  
  public final ${ITERATOR_TYPE} insert(${ITERATOR_TYPE} I, int NumToInsert, ${TYPE} Elt) {
    assert checkAlive();
    assert NumToInsert >= 0 : "can not be negative " + NumToInsert;
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
      ${ITERATOR_TYPE} OldEnd = this.end();
      append_T(this.end().$sub(NumToInsert), this.end());

      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd${STD_COPY_TRAILING_ARG});

      std.fill_n(I, NumToInsert, Elt);
      return I;
    }

    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.

    // Move over the elements that we're about to overwrite.
    ${ITERATOR_TYPE} OldEnd = this.end();
    this.setEnd(this.size() + NumToInsert);
    int NumOverwritten = OldEnd.$sub(I);
    std.copy(I, OldEnd, this.end().$sub(NumOverwritten)${STD_COPY_TRAILING_ARG});

    // Replace the overwritten part.
    std.fill_n(I, NumOverwritten, Elt);

    // Insert the non-overwritten middle part.
    std.fill_n(OldEnd, NumToInsert-NumOverwritten, Elt);
    return I;  
  }

  //<editor-fold defaultstate="collapsed" desc="Manual">
  @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallVector.h", line=618)
  //</editor-fold>
  public final ${ITERATOR_TYPE} insert$T(${ITERATOR_TYPE} I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
    assert checkAlive();
    return insert(I, From, To);
  }
  public final ${ITERATOR_TYPE} insert$T$value_T(${ITERATOR_TYPE} I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
    assert checkAlive();
    return insert(I, From, To);
  }
  public final ${ITERATOR_TYPE} insert_iterator$T_T(${ITERATOR_TYPE} I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }  
  public final ${ITERATOR_TYPE} insert(${ITERATOR_TYPE} I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
    assert checkAlive();
    return insert_iterator$T$value_T(I, From, To);
  }
  public final ${ITERATOR_TYPE} insert_iterator$T$value_T(${ITERATOR_TYPE} I, ${GENERIC_ITERATOR} From, ${GENERIC_ITERATOR} To) {
    assert checkAlive();
    // Convert iterator to elt# to avoid invalidating iterator when we reserve()
    int InsertElt = I.$sub(this.begin());

    if (I.$eq(this.end())) {  // Important special case for empty vector.
      append_T(From, To);
      return this.begin().$add(InsertElt);
    }

    assert(I.$greatereq(this.begin())) : "Insertion iterator is out of bounds.";
    assert(I.$lesseq(this.end())) : "Inserting past the end of the vector.";

    int NumToInsert = std.distance(From, To);
    assert NumToInsert >= 0 : "Unexpected negative value " + NumToInsert;

    // Ensure there is enough space.
    reserve(this.size() + NumToInsert);

    // Uninvalidate the iterator.
    I = this.begin().$add(InsertElt);
    if (NumToInsert == 0) {
      return I;
    }

    // If there are more elements between the insertion point and the end of the
    // range than there are being inserted, we can use a simple approach to
    // insertion.  Since we already reserved space, we know that this won't
    // reallocate the vector.
    if (this.end().$sub(I) >= NumToInsert) {
      ${ITERATOR_TYPE} OldEnd = this.end();
      append_T(this.end().$sub(NumToInsert), this.end());

      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd${STD_COPY_TRAILING_ARG});

      std.copy(From, To, I${STD_COPY_TRAILING_ARG});
      return I;
    }

    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.

    // Move over the elements that we're about to overwrite.
    ${ITERATOR_TYPE} OldEnd = this.end();
    this.setEnd(this.size() + NumToInsert);
    int NumOverwritten = OldEnd.$sub(I);
    std.copy(I, OldEnd, this.end().$sub(NumOverwritten)${STD_COPY_TRAILING_ARG});

    // Replace the overwritten part.
    if (NumOverwritten > 0) {
      From = $Clone(From);
      for (${ITERATOR_TYPE} J = $Clone(I); NumOverwritten > 0; --NumOverwritten) {
        J.star$ref().$set(From.$star());
        J.$preInc(); From.$preInc();
      }
    }

    // Insert the non-overwritten middle part.
    std.copy(From, To, OldEnd${STD_COPY_TRAILING_ARG});
    return I;
  }
  
  // ${ADDITIONAL_APPEND_INSERT}

  /// append - Add the specified range to the end of the SmallVector.
  ///  
  public final void append_T(${GENERIC_ITERATOR} in_start, ${GENERIC_ITERATOR} in_end) {
    assert checkAlive();
    int NumInputs = std.distance(in_start, in_end);
    assert NumInputs >= 0 : "Unexpected negative value " + NumInputs;
    if (NumInputs == 0) {
      return;
    }
    
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
        
    ${GENERIC_ITERATOR} iter = $Clone(in_start);
    while (!iter.$eq(in_end)) {
      $set(end, iter.$star());
      ++end;
      iter.$preInc();
    }
  }

  /// append - Add the specified range to the end of the SmallVector.
  ///  
  public final <F> void append_T(type$iterator<?, F> in_start, type$iterator<?, F> in_end, Converter<F, ${BOXED_TYPE}> converter) {
    assert checkAlive();
    int NumInputs = std.distance(in_start, in_end);
    assert NumInputs >= 0 : "Unexpected negative value " + NumInputs;
    if (NumInputs == 0) {
      return;
    }
    
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);
    
    type$iterator<?, F> iter = $Clone(in_start);
    while (!iter.$eq(in_end)) {
      $set(end, converter.$call(iter.$star()));
      ++end;
      iter.$preInc();
    }
  }

  public final void append(${TYPE}[] a) {
    assert checkAlive();
    append(a, 0, a.length);
  }

  public final void append(${TYPE}[] a, int fromIndex, int count) {
    assert checkAlive();
    if (count > (this.capacity() - this.size()))
      this.grow(this.size()+count);
    while (count-- > 0) {
      ${TYPE} el = a[fromIndex++];
      $set(end, el);
      ++end;
    }
  } 
  
  public final void append(int NumInputs, ${TYPE} Elt) {
    assert checkAlive();
    assert NumInputs >= 0 : "can not be negative " + NumInputs;
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);

    // Copy the new elements over.
    for (int i = 0; i < NumInputs; i++) {
      $set(end, Elt);
      ++end;
    }
  }  

  public final void append_size_type$T$value_T$C$R(int NumInputs, ${TYPE} Elt) {
    append(NumInputs, Elt);
  }
  
  public final void append_size_type$T_T$C$R(int NumInputs, ${TYPE} Elt) {
    append(NumInputs, Elt);
  }
  
  // ${EXTRA_APPEND_MEMBERS}
    
  @Override
  public final boolean $eq(${FILE_NAME}${CLASS_SUFFIX} RHS) {
    assert checkAlive();
    assert RHS.checkAlive();
    int size = this.size();
    if (size != RHS.size()) return false;
    for (int i = 0; i < size; i++) {
      //if (this.array[i] != RHS.array[i]) {
      if (Native.$noteq(this.array[i], RHS.array[i])) {
        return false;
      }
    }
    return true;
  }

  @Override
  public final boolean $noteq(${FILE_NAME}${CLASS_SUFFIX} RHS) {
    return !$eq(RHS);
  }

  @Override
  public final boolean $less(Object obj) {
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
  public final boolean $lesseq(Object obj) {
    assert checkAlive();
    assert ((${FILE_NAME}) obj).checkAlive();
    return $less(obj) || $eq((${FILE_NAME}${CLASS_SUFFIX})obj);
  }

  public final ${REFERENCE_TYPE} ref$at(int idx) {
    assert checkAlive();
    return NativePointer.${REFERENCE_FACTORY_MTD}(array, idx);
  }
  
  public final ${TYPE} $at(int idx) {
    assert checkAlive();
    return array[(int) idx];
  }
  
  public final ${TYPE} $at$Const(int idx) {
    assert checkAlive();
    return array[(int) idx];
  }

  public final ${TYPE} $set(int idx, ${TYPE} value) {
    assert checkAlive();
    ${SET_IMPL}
  }

  protected final ${TYPE} $set$move(int idx, ${TYPE} value) {
    assert checkAlive();
    ${SET_MOVE_IMPL}
  }
  
  public final boolean empty() {
    assert checkAlive();
    return this.size() == 0;
  }
  
  public ${FINAL_DESTROY} void $destroy() {
    assert checkAlive();
    ${DESTROY_IMPL}
    this.setEnd(0);
    set$destroyed();
  }
  
  public final void push_back(${TYPE} val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    $set(this.size(), val);
    this.setEnd(this.size() + 1);
  }    

  public final void push_back_T$C$R(${TYPE} val) {
    assert checkAlive();
    push_back(val);
  }
  
  public final void push_back_T$RR(${TYPE} val) {
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    $set$move(this.size(), val);
    this.setEnd(this.size() + 1);
  }

  public final void emplace_back(${TYPE} val) {
    // JConvert already created val externally, 
    // so just prepare space and insert this object into last cell
    assert checkAlive();
    if (this.size() >= this.capacity()) {
      this.grow();
    }    
    int index = this.size();
    this.setEnd(index + 1);
    array[index] = val;
  }

  public final void emplace_back() {
    assert checkAlive();
    // here object is not created externally, so use defaultValue and usual push_back
    push_back(this.defaultValue);
  }

  public final void pop_back() {
    assert checkAlive();
    destroy_range(this.size() - 1, this.size());
    this.setEnd(this.size() - 1);
  }

  public final ${TYPE} pop_back_val() {
    assert checkAlive();
    ${TYPE} val = this.back();
    this.setEnd(end - 1);
    return val;
  }  

  @Override
  public final ${ITERATOR_TYPE} begin() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array);
  }

  @Override
  public final ${ITERATOR_TYPE} begin$Const() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array);
  }

  @Override
  public final ${ITERATOR_TYPE} end() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array, end);
  }

  @Override
  public final ${ITERATOR_TYPE} end$Const() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array, end);
  }
  
  public final ${REV_ITERATOR_TYPE} rbegin() {
    assert checkAlive();
    return new ${REV_ITERATOR_TYPE}(NativePointer.${POINTER_FACTORY_MTD}(array, end));
  }
  
  public final ${REV_ITERATOR_TYPE} rbegin$Const() {
    assert checkAlive();
    return new ${REV_ITERATOR_TYPE}(NativePointer.${POINTER_FACTORY_MTD}(array, end));
  }

  public final ${REV_ITERATOR_TYPE} rend() {
    assert checkAlive();
    return new ${REV_ITERATOR_TYPE}(NativePointer.${POINTER_FACTORY_MTD}(array));
  }

  public final ${REV_ITERATOR_TYPE} rend$Const() {
    assert checkAlive();
    return new ${REV_ITERATOR_TYPE}(NativePointer.${POINTER_FACTORY_MTD}(array));
  }
  
  public final ${POINTER_TYPE} data() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array);
  }
  
  public final ${POINTER_TYPE} data$Const() {
    assert checkAlive();
    return NativePointer.${POINTER_FACTORY_MTD}(array);
  }
  
  public final ${TYPE} front() {
    assert checkAlive();
    return array[0];
  }    
  
  public final ${TYPE} front$Const() {
    assert checkAlive();
    return array[0];
  }    
  
  public final ${TYPE} back() {
    assert checkAlive();
    return array[end - 1];
  }    
  
  public final ${TYPE} back$Const() {
    assert checkAlive();
    return array[end - 1];
  }    
  
  public final ${REFERENCE_TYPE} ref$front() {
    assert checkAlive();
    return new ${REFERENCE_TYPE}() {
      
      private final int index = 0;

      @Override
      public ${TYPE} $deref() {
        assert checkAlive();
        return array[index];
      }

      @Override
      public ${TYPE} $set(${TYPE} value) {
        assert checkAlive();
        ${REF_SET_IMPL}
      }
      
      @Override
      public ${POINTER_TYPE} deref$ptr() {
        assert checkAlive();
        return data().$add(index);
      }
    };
  }

  public final ${REFERENCE_TYPE} ref$back() {
    assert checkAlive();
    return  new ${REFERENCE_TYPE}() {
      
      private final int index = end - 1;

      @Override
      public ${TYPE} $deref() {
        assert checkAlive();
        return array[index];
      }

      @Override
      public ${TYPE} $set(${TYPE} value) {
        assert checkAlive();
        ${REF_SET_IMPL}
      }
      
      @Override
      public ${POINTER_TYPE} deref$ptr() {
        assert checkAlive();
        return data().$add(index);
      }   
    };
  }
  
  public final /*size_t*/int size() /*const*/ {
    assert checkAlive();
    return end;
  }

  public final /*size_t*/int max_size() /*const*/ {
    assert checkAlive();
    return Integer.MAX_VALUE; // TODO 
  }

  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  public final /*size_t*/int capacity() /*const*/ {
    assert checkAlive();
    return array.length;
  }

  @Override public final /*size_t*/int $sizeof() {
    assert checkAlive();
    return capacity_in_bytes();
  }

  public final /*size_t*/int capacity_in_bytes() {
    assert checkAlive();
    int oneElemSize = NativeType.sizeof(defaultValue);; 
    for (${TYPE} elem : array) {
      if (elem != defaultValue) {
        oneElemSize = NativeType.sizeof(elem);
        break;
      }
    }
    return array.length * oneElemSize;
  }

  public final ${POINTER_TYPE} ptr$at(int idx) {
    assert checkAlive();
    return ${POINTER_FACTORY_MTD}(array, idx);
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
    assert checkAlive();
    assert N >= 0 : "can not be negative " + N;
    assert(N <= this.capacity());
    this.setEnd(N);
  }  
  
  private void destroy_range(int from, int to) {
    ${DESTROY_RANGE_IMPL}
  }

  private void destroy_range(${ITERATOR_TYPE} _from, ${ITERATOR_TYPE} _to) {
    destroy_range(_from.$sub(this.begin()), _to.$sub(this.begin()));
  } 
  
  private void grow(int capacity) {
    ${TYPE}[] oldArray = array;
    array = (${TYPE}[])${NEW_CAPACITY_ARRAY};
    copy$Object(oldArray, 0, array, 0, oldArray.length);
  }

  private void grow() {
    int capacity = capacity();
    this.grow(capacity == 0 ? 1 : ((capacity < 1024) ? capacity * 2 : (capacity + 1024)));
  }
  
  private void setEnd(int to) {
    end = to;
  }  

  private void setEnd(${ITERATOR_TYPE} to) {
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

  @Override
  public String toString() {
    String extra = (super.is$destroyed() ? "DESTROYED" : "");
    if (this.end == 0) {
      return extra + "<EMPTY>";
    }
    StringBuilder out = new StringBuilder("\n${FILE_NAME}{\n");
    out.append(extra).append("end = " + this.end + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      ${TYPE} element = array[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      ${SB_APPEND_ELEMENT_I};
    }
    out.append("}${FILE_NAME}}\n");
    return out.toString();
  }
  
  protected final boolean checkAlive() {
    return check$Alive();
  }
}
