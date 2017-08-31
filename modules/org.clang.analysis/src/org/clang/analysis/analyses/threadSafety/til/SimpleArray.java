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

package org.clang.analysis.analyses.threadSafety.til;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.analysis.analyses.threadSafety.til.*;


// A simple fixed size array class that does not manage its own memory,
// suitable for use with bump pointer allocation.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 82,
 FQN="clang::threadSafety::til::SimpleArray", NM="_ZN5clang12threadSafety3til11SimpleArrayE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayE")
//</editor-fold>
public class SimpleArray</*class*/ T> implements Iterable<T> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::SimpleArray<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 84,
   FQN="clang::threadSafety::til::SimpleArray::SimpleArray<T>", NM="_ZN5clang12threadSafety3til11SimpleArrayC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayC1Ev")
  //</editor-fold>
  public SimpleArray() {
    // : Data(null), Size(0), Capacity(0) 
    //START JInit
    this.Data = /*ParenListExpr*/null;
    this.Size = 0;
    this.Capacity = 0;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::SimpleArray<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 85,
   FQN="clang::threadSafety::til::SimpleArray::SimpleArray<T>", NM="_ZN5clang12threadSafety3til11SimpleArrayC1EPT_jj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayC1EPT_jj")
  //</editor-fold>
  public SimpleArray(type$ptr<T /*P*/> Dat, /*size_t*/int Cp) {
    this(Dat, Cp, 0);
  }
  public SimpleArray(type$ptr<T /*P*/> Dat, /*size_t*/int Cp, /*size_t*/int Sz/*= 0*/) {
    // : Data(Dat), Size(Sz), Capacity(Cp) 
    //START JInit
    this.Data = /*ParenListExpr*/Dat;
    this.Size = Sz;
    this.Capacity = Cp;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::SimpleArray<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 87,
   FQN="clang::threadSafety::til::SimpleArray::SimpleArray<T>", NM="_ZN5clang12threadSafety3til11SimpleArrayC1ENS1_12MemRegionRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayC1ENS1_12MemRegionRefEj")
  //</editor-fold>
  public SimpleArray(MemRegionRef A, /*size_t*/int Cp) {
    // : Data(Cp == 0 ? null : A.allocateT<T>(Cp)), Size(0), Capacity(Cp) 
    //START JInit
    // JAVA: MEMORY
    this.Data = /*ParenListExpr*/Cp == 0 ? null : create_type$ptr((T[]) new Object[Cp]);//A.<T>allocateT(Cp);
    this.Size = 0;
    this.Capacity = Cp;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::SimpleArray<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 89,
   FQN="clang::threadSafety::til::SimpleArray::SimpleArray<T>", NM="_ZN5clang12threadSafety3til11SimpleArrayC1EONS1_11SimpleArrayIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayC1EONS1_11SimpleArrayIT_EE")
  //</editor-fold>
  public SimpleArray(JD$Move _dparam, final SimpleArray<T> /*&&*/A) {
    // : Data(A.Data), Size(A.Size), Capacity(A.Capacity) 
    //START JInit
    this.Data = /*ParenListExpr*/A.Data;
    this.Size = A.Size;///*ParenListExpr*/new /*size_t*/int(A.Size);
    this.Capacity = A.Capacity;///*ParenListExpr*/new /*size_t*/int(A.Capacity);
    //END JInit
    A.Data = null;
    A.Size = 0;
    A.Capacity = 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 96,
   FQN="clang::threadSafety::til::SimpleArray::operator=", NM="_ZN5clang12threadSafety3til11SimpleArrayaSEONS1_11SimpleArrayIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayaSEONS1_11SimpleArrayIT_EE")
  //</editor-fold>
  public SimpleArray<T> /*&*/ $assignMove(final SimpleArray<T> /*&&*/RHS) {
    if (Native.$noteq(this, Native.$addr(RHS))) {
      Data = RHS.Data;
      Size = RHS.Size;
      Capacity = RHS.Capacity;
      
      RHS.Data = null;
      RHS.Size = RHS.Capacity = 0;
    }
    return Native.$star(this);
  }

  
  // Reserve space for at least Ncp items, reallocating if necessary.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::reserve">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 109,
   FQN="clang::threadSafety::til::SimpleArray::reserve", NM="_ZN5clang12threadSafety3til11SimpleArray7reserveEjNS1_12MemRegionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray7reserveEjNS1_12MemRegionRefE")
  //</editor-fold>
  public void reserve(/*size_t*/int Ncp, MemRegionRef A) {
    if (Native.$lesseq(Ncp, Capacity)) {
      return;
    }
    type$ptr<T /*P*/> Odata = Data;
    // JAVA: MEMORY
    Data = create_type$ptr((T[]) new Object[Ncp]);//A.<T>allocateT(Ncp);
    Capacity = Ncp;
    memcpy(Data, Odata, Size);//Native.$star($sizeof_T(), Size));
  }

  
  // Reserve space for at least N more items.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::reserveCheck">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 119,
   FQN="clang::threadSafety::til::SimpleArray::reserveCheck", NM="_ZN5clang12threadSafety3til11SimpleArray12reserveCheckEjNS1_12MemRegionRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray12reserveCheckEjNS1_12MemRegionRefE")
  //</editor-fold>
  public void reserveCheck(/*size_t*/int N, MemRegionRef A) {
    if (Native.$eq(Capacity, 0)) {
      reserve(u_max(InitialCapacity, N), A);
    } else if (Native.$less(Size + N, Capacity)) {
      reserve(u_max(Size + N, Capacity*2), A);
    }
  }

  
  /*typedef T *iterator*/
//  public final class iterator extends T /*P*/ { };
  /*typedef const T *const_iterator*/
//  public final class const_iterator extends /*const*/ T /*P*/ { };
  /*typedef std::reverse_iterator<iterator> reverse_iterator*/
//  public final class reverse_iterator extends std.reverse_iterator<T>{ };
  /*typedef std::reverse_iterator<const_iterator> const_reverse_iterator*/
//  public final class const_reverse_iterator extends std.reverse_iterator</*const*/ T>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 131,
   FQN="clang::threadSafety::til::SimpleArray::size", NM="_ZNK5clang12threadSafety3til11SimpleArray4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return Size;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::capacity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 132,
   FQN="clang::threadSafety::til::SimpleArray::capacity", NM="_ZNK5clang12threadSafety3til11SimpleArray8capacityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray8capacityEv")
  //</editor-fold>
  public /*size_t*/int capacity() /*const*/ {
    return Capacity;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 134,
   FQN="clang::threadSafety::til::SimpleArray::operator[]", NM="_ZN5clang12threadSafety3til11SimpleArrayixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayixEj")
  //</editor-fold>
  public T /*&*/ $at(/*uint*/int i) {
    assert Native.$bool(Native.$less(i, Size)) : "Array index out of bounds.";
    return Data.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 138,
   FQN="clang::threadSafety::til::SimpleArray::operator[]", NM="_ZNK5clang12threadSafety3til11SimpleArrayixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArrayixEj")
  //</editor-fold>
  public /*const*/ T /*&*/ $at$Const(/*uint*/int i) /*const*/ {
    assert Native.$bool(Native.$less(i, Size)) : "Array index out of bounds.";
    return Data.$at(i);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 142,
   FQN="clang::threadSafety::til::SimpleArray::back", NM="_ZN5clang12threadSafety3til11SimpleArray4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray4backEv")
  //</editor-fold>
  public T /*&*/ back() {
    assert Native.$bool(Size) : "No elements in the array.";
    return Data.$at(Size - 1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 146,
   FQN="clang::threadSafety::til::SimpleArray::back", NM="_ZNK5clang12threadSafety3til11SimpleArray4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray4backEv")
  //</editor-fold>
  public /*const*/ T /*&*/ back$Const() /*const*/ {
    assert Native.$bool(Size) : "No elements in the array.";
    return Data.$at(Size - 1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 151,
   FQN="clang::threadSafety::til::SimpleArray::begin", NM="_ZN5clang12threadSafety3til11SimpleArray5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray5beginEv")
  //</editor-fold>
  public type$ptr<T /*P*/ > begin() {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 152,
   FQN="clang::threadSafety::til::SimpleArray::end", NM="_ZN5clang12threadSafety3til11SimpleArray3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray3endEv")
  //</editor-fold>
  public type$ptr<T /*P*/ > end() {
    return Data.$add(Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 154,
   FQN="clang::threadSafety::til::SimpleArray::begin", NM="_ZNK5clang12threadSafety3til11SimpleArray5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray5beginEv")
  //</editor-fold>
  public type$ptr</*const*/ T /*P*/ > begin$Const() /*const*/ {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 155,
   FQN="clang::threadSafety::til::SimpleArray::end", NM="_ZNK5clang12threadSafety3til11SimpleArray3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray3endEv")
  //</editor-fold>
  public type$ptr</*const*/ T /*P*/ > end$Const() /*const*/ {
    return Data.$add(Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::cbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 157,
   FQN="clang::threadSafety::til::SimpleArray::cbegin", NM="_ZNK5clang12threadSafety3til11SimpleArray6cbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray6cbeginEv")
  //</editor-fold>
  public type$ptr</*const*/ T /*P*/ > cbegin() /*const*/ {
    return Data;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::cend">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 158,
   FQN="clang::threadSafety::til::SimpleArray::cend", NM="_ZNK5clang12threadSafety3til11SimpleArray4cendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray4cendEv")
  //</editor-fold>
  public type$ptr</*const*/ T /*P*/ > cend() /*const*/ {
    return Data.$add(Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::rbegin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 160,
   FQN="clang::threadSafety::til::SimpleArray::rbegin", NM="_ZN5clang12threadSafety3til11SimpleArray6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<T> rbegin() {
    return new std.reverse_iterator<T>(end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::rend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 161,
   FQN="clang::threadSafety::til::SimpleArray::rend", NM="_ZN5clang12threadSafety3til11SimpleArray4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray4rendEv")
  //</editor-fold>
  public std.reverse_iterator<T> rend() {
    return new std.reverse_iterator<T>(begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::rbegin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 163,
   FQN="clang::threadSafety::til::SimpleArray::rbegin", NM="_ZNK5clang12threadSafety3til11SimpleArray6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ T> rbegin$Const() /*const*/ {
    return new std.reverse_iterator</*const*/ T>(end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::rend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 166,
   FQN="clang::threadSafety::til::SimpleArray::rend", NM="_ZNK5clang12threadSafety3til11SimpleArray4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray4rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ T> rend$Const() /*const*/ {
    return new std.reverse_iterator</*const*/ T>(begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::push_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 170,
   FQN="clang::threadSafety::til::SimpleArray::push_back", NM="_ZN5clang12threadSafety3til11SimpleArray9push_backERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray9push_backERKT_")
  //</editor-fold>
  public void push_back(final /*const*/ T /*&*/ Elem) {
    assert Native.$bool(Native.$less(Size, Capacity));
    Data.$set(Size++, Elem);
  }

  
  // drop last n elements from array
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::drop">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 176,
   FQN="clang::threadSafety::til::SimpleArray::drop", NM="_ZN5clang12threadSafety3til11SimpleArray4dropEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray4dropEj")
  //</editor-fold>
  public void drop() {
    drop(0);
  }
  public void drop(/*uint*/int n/*= 0*/) {
    assert Native.$bool(Native.$greater(Size, n));
    Size -= n;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::setValues">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 181,
   FQN="clang::threadSafety::til::SimpleArray::setValues", NM="_ZN5clang12threadSafety3til11SimpleArray9setValuesEjRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray9setValuesEjRKT_")
  //</editor-fold>
  public void setValues(/*uint*/int Sz, final /*const*/ T /*&*/ C) {
    assert Native.$bool(Native.$lesseq(Sz, Capacity));
    Size = Sz;
    for (/*uint*/int i = 0; $less_uint(i, Sz); ++i) {
      Data.$set(i, C);
    }
  }

  
  /*template <class Iter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::append">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 189,
   FQN="clang::threadSafety::til::SimpleArray::append", NM="Tpl__ZN5clang12threadSafety3til11SimpleArray6appendET_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=Tpl__ZN5clang12threadSafety3til11SimpleArray6appendET_S3_")
  //</editor-fold>
  public </*class*/ Iter extends type$ptr<T>> /*uint*/int append(Iter I, Iter E) {
    /*size_t*/int Osz = Size;
    /*size_t*/int J = Osz;
    for (; Native.$bool(Native.$less(J, Capacity)) && Native.$bool(Native.$noteq_iter(I, E)); ++J , I.$preInc())  {
      Data.$set(J, Native.$star(I));
    }
    Size = J;
    return J - Osz;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::reverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 198,
   FQN="clang::threadSafety::til::SimpleArray::reverse", NM="_ZN5clang12threadSafety3til11SimpleArray7reverseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray7reverseEv")
  //</editor-fold>
  public iterator_range<T> reverse() {
    return llvm.make_range(rbegin(), rend());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::reverse">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 201,
   FQN="clang::threadSafety::til::SimpleArray::reverse", NM="_ZNK5clang12threadSafety3til11SimpleArray7reverseEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZNK5clang12threadSafety3til11SimpleArray7reverseEv")
  //</editor-fold>
  public iterator_range</*const*/ T> reverse$Const() /*const*/ {
    return llvm.make_range(rbegin(), rend());
  }

/*private:*/
  // std::max is annoying here, because it requires a reference,
  // thus forcing InitialCapacity to be initialized outside the .h file.
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::u_max">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 208,
   FQN="clang::threadSafety::til::SimpleArray::u_max", NM="_ZN5clang12threadSafety3til11SimpleArray5u_maxEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArray5u_maxEjj")
  //</editor-fold>
  private /*size_t*/int u_max(/*size_t*/int i, /*size_t*/int j) {
    return ($less_uint(i, j)) ? j : i;
  }

  
  private static /*const*//*size_t*/int InitialCapacity = 4;
  
  //<editor-fold defaultstate="collapsed" desc="clang::threadSafety::til::SimpleArray::SimpleArray<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/ThreadSafetyUtil.h", line = 212,
   FQN="clang::threadSafety::til::SimpleArray::SimpleArray<T>", NM="_ZN5clang12threadSafety3til11SimpleArrayC1ERKNS1_11SimpleArrayIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ThreadSafety.cpp -nm=_ZN5clang12threadSafety3til11SimpleArrayC1ERKNS1_11SimpleArrayIT_EE")
  //</editor-fold>
  private SimpleArray(final /*const*/ SimpleArray<T> /*&*/ A) { throw new UnsupportedOperationException("Deleted");}

  
  private type$ptr<T /*P*/> Data;
  private /*size_t*/int Size;
  private /*size_t*/int Capacity;
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public java.util.Iterator<T> iterator() { return new JavaIterator<>(begin(), end()); }
  
  public void $set(int index, T value) {setValues(index, value);}//Data.$set(index, value);}

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", Size=" + Size // NOI18N
              + ", Capacity=" + Capacity; // NOI18N
  }
}
