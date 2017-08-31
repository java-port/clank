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
package org.clang.lex.java.impl;

import org.clang.basic.Module;
import org.clang.lex.DirectoryLookup;
import org.clang.lex.Lexer;
import org.clang.lex.PTHLexer;
import org.clang.lex.Preprocessor;
import org.clang.lex.Preprocessor_NestedClasses.IncludeStackInfo;
import org.clang.lex.PreprocessorLexer;
import org.clang.lex.TokenLexer;
import org.clank.support.Converted;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;

/**
 * SmallVectorImpl for IncludeStackInfo
 */
//<editor-fold defaultstate="collapsed" desc="template">
@Converted(kind = Converted.Kind.DUMMY, source = "${SPUTNIK}/modules/org.llvm.adtsupport/src/org/llvm/adt/aliases/templates/SmallVectorImpl.tpl")
//</editor-fold>
public final class SmallVectorIncludeStackInfo implements NativeType.SizeofCapable {
  // constant to be used as defaultValue in other collections.
  // tihs instance is cloned, but have not be modified
  public static final SmallVectorIncludeStackInfo DEFAULT = new SmallVectorIncludeStackInfo(0, IncludeStackInfo.DEFAULT);
  private static final IncludeStackInfo[] EMPTY = new IncludeStackInfo[0];
  protected final IncludeStackInfo defaultValue;
  
  private IncludeStackInfo[] array;
  
  private int end;

  public /*friend*/ final IncludeStackInfo[] $array() {
    return this.array;
  }

  public SmallVectorIncludeStackInfo() {
    this(0, IncludeStackInfo.DEFAULT);
  }
  public SmallVectorIncludeStackInfo(int capacity, IncludeStackInfo defaultValue) {
    this.array = (IncludeStackInfo[]) (capacity == 0 ? EMPTY : new IncludeStackInfo[capacity]);
    this.end = 0;
    assert defaultValue != null;
    this.defaultValue = defaultValue;
  }
  
  public SmallVectorIncludeStackInfo(int capacity, int initialSize, IncludeStackInfo defaultValue) {
    this(capacity, defaultValue);
    this.assign(initialSize, defaultValue);
  }

  public SmallVectorIncludeStackInfo(IncludeStackInfo array[], int length, IncludeStackInfo defaultValue) {
    this.array = array;
    this.end = length;
    assert defaultValue == null;
    this.defaultValue = defaultValue;
  }

  public SmallVectorIncludeStackInfo(SmallVectorIncludeStackInfo other) {
    this.defaultValue = other.defaultValue;
    this.array = other.array.clone();
    this.end = other.end;
  }

  public final void clear() {
    this.destroy_range(0, this.size());
    this.setEnd(0);
  }

  public final boolean resize(int newSize) {
    return resize(newSize, defaultValue);
  }
  
  public final boolean resize(int newSize, IncludeStackInfo defaultValue) {
    boolean grown = false;
    if (newSize < end) {
      destroy_range(newSize, end);
    } else if (newSize > end) {
      if (this.capacity() < newSize) {
        this.grow(newSize);
        grown = true;
      }
      for (int i = end; i < newSize; i++) {
        array[i] = new IncludeStackInfo();
      }
    }
    end = newSize;
    return grown;
  }  

  public final void reserve(int N) {
    if (this.capacity() < N)
      this.grow(N);
  }

  public final void assign(int NumElts, IncludeStackInfo Elt) {
    clear();
    if (this.capacity() < NumElts)
      this.grow(NumElts);    
    this.setEnd(NumElts);
    
    for (int i = 0; i < this.size(); i++) {
      $set(i, Elt);
    }
  }  

  public final void append(IncludeStackInfo[] a) {
    append(a, 0, a.length);
  }
  public final void append(IncludeStackInfo[] a, int startIdx, int count) {
    int num = count;
    if (num > (this.capacity() - this.size()))
      this.grow(this.size()+num);
    int last = startIdx + count;
    for (int i = startIdx; i < last; i++) {
      if (this.array[this.end] == null) {
        this.array[this.end] = new IncludeStackInfo();
      }
      this.array[this.end++].$assign(a[i]);
    }
  }

  public final void append(int NumInputs, IncludeStackInfo Elt) {
    // Grow allocated space if needed.
    if (NumInputs > (this.capacity() - this.size()))
      this.grow(this.size()+NumInputs);

    // Copy the new elements over.
    for (int i = 0; i < NumInputs; i++) {
      $set(end, Elt);
      ++end;
    }
  }  
  
  public final IncludeStackInfo $at(int idx) {
    assert array[idx] != null;
    return array[idx];
  }

  public final IncludeStackInfo $set(int idx, IncludeStackInfo value) {
    assert array[idx] != null;
    array[idx].$assign(value);
    return array[idx];
  }
  
  public final boolean empty() {
    return this.size() == 0;
  }
  
  public final void $destroy() {
    destroy_range(0, this.size());
    end = 0;
  }
  
  public final void push_back(IncludeStackInfo val) {
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    if (this.array[end] == null) {
      this.array[end] = new IncludeStackInfo();
    }
    $set(end, val);
    end++;
  }    

  public void emplace_back(Preprocessor.CurLexerKindEnum K, Module /*P*/ TheSubmodule, Lexer /*P*/ L, PTHLexer /*P*/ P, PreprocessorLexer /*P*/ PPL, TokenLexer /*P*/ TL, /*const*/type$ptr<DirectoryLookup> /*P*/ D) {
    if (this.size() >= this.capacity()) {
      this.grow();
    }
    if (this.array[end] == null) {
      this.array[end] = new IncludeStackInfo();
    }
    this.array[end].CurLexerKind = K;
    this.array[end].TheSubmodule = TheSubmodule;
    assert this.array[end].TheLexer.get() == null : "must not hold other ptr";
    this.array[end].TheLexer.reset(L); // JAVA: reuse
    assert this.array[end].ThePTHLexer.get() == null : "must not hold other ptr";
    this.array[end].ThePTHLexer.reset(P); // JAVA: reuse
    this.array[end].ThePPLexer = PPL;
    assert this.array[end].TheTokenLexer.get() == null : "must not hold other ptr";
    this.array[end].TheTokenLexer.reset(TL); // JAVA: reuse
    this.array[end].TheDirLookup = D;
    end++;
  }    

  public final void pop_back() {
    this.array[--end].$destroy();
  }

  public final IncludeStackInfo pop_back_val() {
    IncludeStackInfo val = this.back();
    this.setEnd(end - 1);
    return val;
  }  

  public final IncludeStackInfo front() {
    return array[0];
  }    
  
  public final IncludeStackInfo back() {
    return array[end - 1];
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
    int oneElemSize = IncludeStackInfo.$sizeof_IncludeStackInfo();//NativeType.sizeof(defaultValue);; 
//    for (IncludeStackInfo elem : array) {
//      if (elem != defaultValue) {
//        oneElemSize = NativeType.sizeof(elem);
//        break;
//      }
//    }
    return array.length * oneElemSize;
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
       if (array[i] != null) {
        array[i].$destroy();
       }
     }
  }
  
  private void grow(int newSize) {
    IncludeStackInfo[] oldArray = array;
    array = new IncludeStackInfo[newSize];
    copy$Object(oldArray, 0, array, 0, oldArray.length);
  }

  private void grow() {
    int capacity = capacity();
    this.grow(capacity == 0 ? 1 : ((capacity < 1024) ? capacity * 2 : (capacity + 1024)));
  }  
  
  private void setEnd(int to) {
    end = to;
  }  

  @Override
  public String toString() {
    if (this.end == 0) {
      return "<EMPTY>";
    }
    StringBuilder out = new StringBuilder("\nSmallVectorIncludeStackInfo{\nend = " + this.end + '\n');
    String fmt = "%" + (int)Math.ceil(Math.log10(this.end+1)) + "d";
    for (int i = 0; i < this.end; i++) {
      IncludeStackInfo element = array[i];
      out.append("[").append(String.format(fmt, i)).append("]");
      out.append(element).append('\n');
    }
    out.append("}SmallVectorIncludeStackInfo}\n");
    return out.toString();
  }
}
