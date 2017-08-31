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

package org.clang.analysis.support;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.clang.analysis.support.*;

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::BumpVector">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 57,
 FQN="clang::BumpVector", NM="_ZN5clang10BumpVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVectorE")
//</editor-fold>
public class BumpVector</*typename*/ T>  implements Destructors.ClassWithDestructor {
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<T /*P*/ > Begin;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<T /*P*/ > End;
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC)
  private type$ptr<T /*P*/ > Capacity;
/*public:*/
  // Default ctor - Initialize to empty.
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::BumpVector<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 62,
   FQN="clang::BumpVector::BumpVector<T>", NM="_ZN5clang10BumpVectorC1ERNS_17BumpVectorContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVectorC1ERNS_17BumpVectorContextEj")
  //</editor-fold>
  public /*explicit*/ BumpVector(TypeAllocator<T> typeAllocator, final BumpVectorContext /*&*/ C, /*uint*/int N) {
    // : Begin(null), End(null), Capacity(null) 
    //START JInit
    this.$typeAllocator = typeAllocator;
    this.Begin = create_type$null$ptr();///*ParenListExpr*/null;
    this.End = create_type$null$ptr();///*ParenListExpr*/null;
    this.Capacity = create_type$null$ptr();///*ParenListExpr*/null;
    //END JInit
    reserve(C, N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::~BumpVector<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 67,
   FQN="clang::BumpVector::~BumpVector<T>", NM="_ZN5clang10BumpVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    if ($typeAllocator.isClass) {
      // Destroy the constructed elements in the vector.
      destroy_range(Begin, End);
    }
  }

  
  /*typedef size_t size_type*/;
  /*typedef ptrdiff_t difference_type*/;
  /*typedef T value_type*/
//  public final class value_type extends T{ };
  /*typedef T *iterator*/
//  public final class iterator extends T /*P*/ { };
  /*typedef const T *const_iterator*/
//  public final class const_iterator extends /*const*/ T /*P*/ { };
  
  /*typedef std::reverse_iterator<const_iterator> const_reverse_iterator*/
//  public final class const_reverse_iterator extends std.reverse_iterator</*const*/ T>{ };
  /*typedef std::reverse_iterator<iterator> reverse_iterator*/
//  public final class reverse_iterator extends std.reverse_iterator<T>{ };
  
  /*typedef T &reference*/
//  public final class reference extends T /*&*/ { };
  /*typedef const T &const_reference*/
//  public final class const_reference extends /*const*/ T /*&*/ { };
  /*typedef T *pointer*/
//  public final class pointer extends T /*P*/ { };
  /*typedef const T *const_pointer*/
//  public final class const_pointer extends /*const*/ T /*P*/ { };
  
  // forward iterator creation methods.
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 89,
   FQN="clang::BumpVector::begin", NM="_ZN5clang10BumpVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector5beginEv")
  //</editor-fold>
  public type$ptr<T /*P*/ > begin() {
    return Begin;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 90,
   FQN="clang::BumpVector::begin", NM="_ZNK5clang10BumpVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector5beginEv")
  //</editor-fold>
  public type$ptr</*const*/ T /*P*/ > begin$Const() /*const*/ {
    return Begin;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 91,
   FQN="clang::BumpVector::end", NM="_ZN5clang10BumpVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector3endEv")
  //</editor-fold>
  public type$ptr<T /*P*/ > end() {
    return End;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 92,
   FQN="clang::BumpVector::end", NM="_ZNK5clang10BumpVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector3endEv")
  //</editor-fold>
  public type$ptr</*const*/ T /*P*/ > end$Const() /*const*/ {
    return End;
  }

  
  // reverse iterator creation methods.
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::rbegin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 95,
   FQN="clang::BumpVector::rbegin", NM="_ZN5clang10BumpVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<T> rbegin() {
    return new std.reverse_iterator<T>(end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::rbegin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 96,
   FQN="clang::BumpVector::rbegin", NM="_ZNK5clang10BumpVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ T> rbegin$Const() /*const*/ {
    return new std.reverse_iterator</*const*/ T>(end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::rend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 97,
   FQN="clang::BumpVector::rend", NM="_ZN5clang10BumpVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector4rendEv")
  //</editor-fold>
  public std.reverse_iterator<T> rend() {
    return new std.reverse_iterator<T>(begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::rend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 98,
   FQN="clang::BumpVector::rend", NM="_ZNK5clang10BumpVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector4rendEv")
  //</editor-fold>
  public std.reverse_iterator</*const*/ T> rend$Const() /*const*/ {
    return new std.reverse_iterator</*const*/ T>(begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::empty">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 100,
   FQN="clang::BumpVector::empty", NM="_ZNK5clang10BumpVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Native.$eq_iter((abstract_iterator)Begin, (abstract_iterator)End);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::size">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 101,
   FQN="clang::BumpVector::size", NM="_ZNK5clang10BumpVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return End.$sub(Begin);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 103,
   FQN="clang::BumpVector::operator[]", NM="_ZN5clang10BumpVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVectorixEj")
  //</editor-fold>
  public T /*&*/ $at(/*uint*/int idx) {
    assert Begin.$add(idx).$less(End);
    return Begin.$at(idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 107,
   FQN="clang::BumpVector::operator[]", NM="_ZNK5clang10BumpVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVectorixEj")
  //</editor-fold>
  public /*const*/ T /*&*/ $at$Const(/*uint*/int idx) /*const*/ {
    assert Begin.$add(idx).$less(End);
    return Begin.$at(idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::front">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 112,
   FQN="clang::BumpVector::front", NM="_ZN5clang10BumpVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector5frontEv")
  //</editor-fold>
  public T /*&*/ front() {
    return begin().$star();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::front">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 115,
   FQN="clang::BumpVector::front", NM="_ZNK5clang10BumpVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector5frontEv")
  //</editor-fold>
  public /*const*/ T /*&*/ front$Const() /*const*/ {
    return begin().$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 119,
   FQN="clang::BumpVector::back", NM="_ZN5clang10BumpVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector4backEv")
  //</editor-fold>
  public T /*&*/ back() {
    return end().$at(-1);
  }
  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::back">
  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED/*access to the cell*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 119,
   FQN="clang::BumpVector::back", NM="_ZN5clang10BumpVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector4backEv")
  //</editor-fold>
  public type$ptr<T> /*&*/ back$ptr() {
    // JAVA: access to the previous pointee cell
    return end().$sub(1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 122,
   FQN="clang::BumpVector::back", NM="_ZNK5clang10BumpVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector4backEv")
  //</editor-fold>
  public /*const*/ T /*&*/ back$Const() /*const*/ {
    return end().$at(-1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::pop_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 126,
   FQN="clang::BumpVector::pop_back", NM="_ZN5clang10BumpVector8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    End.$preDec();
    // JAVA: MEMORY
    if ($typeAllocator.isClass) {
      Native.destroy(End.$arrow());//End->~T();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::pop_back_val">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 131,
   FQN="clang::BumpVector::pop_back_val", NM="_ZN5clang10BumpVector12pop_back_valEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector12pop_back_valEv")
  //</editor-fold>
  public T pop_back_val() {
    T Result = back();
    pop_back();
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::clear">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 137,
   FQN="clang::BumpVector::clear", NM="_ZN5clang10BumpVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector5clearEv")
  //</editor-fold>
  public void clear() {
    if ($typeAllocator.isClass) {
      destroy_range(Begin, End);
    }
    End = $toConst($tryClone(Begin));
  }

  
  /// data - Return a pointer to the vector's buffer, even if empty().
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::data">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 145,
   FQN="clang::BumpVector::data", NM="_ZN5clang10BumpVector4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector4dataEv")
  //</editor-fold>
  public T /*P*/ data() {
    return Begin.$star();//T /*P*/ (Begin);
  }

  
  /// data - Return a pointer to the vector's buffer, even if empty().
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::data">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 150,
   FQN="clang::BumpVector::data", NM="_ZNK5clang10BumpVector4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector4dataEv")
  //</editor-fold>
  public /*const*/ T /*P*/ data$Const() /*const*/ {
    return  Begin.$star();///*const*/ T /*P*/ (Begin);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::push_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 154,
   FQN="clang::BumpVector::push_back", NM="_ZN5clang10BumpVector9push_backERKT_RNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector9push_backERKT_RNS_17BumpVectorContextE")
  //</editor-fold>
  public void push_back(final /*const*/ T /*&*/ Elt, final BumpVectorContext /*&*/ C) {
    while(true) {
      if (End.$less(Capacity)) {
       //Retry:
        // JAVA: MEMORY
        ///*FIXME: NEW_EXPR [NoNewFun]*/End = /*new (End)*/ new T(( Elt ));
        if ($typeAllocator.isClass) {
          End.$set($typeAllocator.copyType.$call(Elt));
        } else {// pointer
          End.$set(Elt);
        }
        $toConst($cleanConst(End).$preInc());
        return;
      }
      grow(C);
      //goto Retry;
    }
  }

  
  /// insert - Insert some number of copies of element into a position. Return
  /// iterator to position after last inserted copy.
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 167,
   FQN="clang::BumpVector::insert", NM="_ZN5clang10BumpVector6insertEPT_jRKS1_RNS_17BumpVectorContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector6insertEPT_jRKS1_RNS_17BumpVectorContextE")
  //</editor-fold>
  public type$ptr<T /*P*/ > insert(type$ptr<T /*P*/ > I, /*size_t*/int Cnt, final /*const*/ T /*&*/ E, 
        final BumpVectorContext /*&*/ C) {
    assert I.$greatereq(Begin) && I.$lesseq(End) : "Iterator out of bounds.";
    while(true) {
      if (End.$add(Cnt).$lesseq(Capacity)) {
       //Retry:
        move_range_right(I, End, Cnt);
        construct_range(I, I.$add(Cnt), E);
        $toConst($cleanConst(End).$inc(Cnt));
        return I.$add(Cnt);
      }
      int D = I.$sub(Begin);
      grow(C, size() + Cnt);
      I = Begin.$add(D);
      //goto Retry;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::reserve">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 183,
   FQN="clang::BumpVector::reserve", NM="_ZN5clang10BumpVector7reserveERNS_17BumpVectorContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector7reserveERNS_17BumpVectorContextEj")
  //</editor-fold>
  public void reserve(final BumpVectorContext /*&*/ C, /*uint*/int N) {
    if ($less_uint(/*uint*/Capacity.$sub(Begin), N)) {
      grow(C, N);
    }
  }

  
  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::capacity">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 190,
   FQN="clang::BumpVector::capacity", NM="_ZNK5clang10BumpVector8capacityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK5clang10BumpVector8capacityEv")
  //</editor-fold>
  public /*size_t*/int capacity() /*const*/ {
    return Capacity.$sub(Begin);
  }

/*private:*/
  /// grow - double the size of the allocated memory, guaranteeing space for at
  /// least one more element or MinSize if specified.
  
  // Define this out-of-line to dissuade the C++ compiler from inlining it.
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::grow">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 219,
   FQN="clang::BumpVector::grow", NM="_ZN5clang10BumpVector4growERNS_17BumpVectorContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector4growERNS_17BumpVectorContextEj")
  //</editor-fold>
  private void grow(final BumpVectorContext /*&*/ C) {
    grow(C, 1);
  }
  private void grow(final BumpVectorContext /*&*/ C, /*size_t*/int MinSize/*= 1*/) {
    /*size_t*/int CurCapacity = Capacity.$sub(Begin);
    /*size_t*/int CurSize = size();
    /*size_t*/int NewCapacity = 2 * CurCapacity;
    if ($less_uint(NewCapacity, MinSize)) {
      NewCapacity = MinSize;
    }
    
    // Allocate the memory from the BumpPtrAllocator.
    // JAVA: MEMORY
    //T /*P*/ NewElts = C.getAllocator()./*template */<T>Allocate(NewCapacity);
    type$ptr<T /*P*/ > NewElts = create_type$ptr($typeAllocator.newArryType.$call(NewCapacity));
    
    // Copy the elements over.
    if (Native.$noteq_iter((abstract_iterator)Begin, (abstract_iterator)End)) {
      if ($typeAllocator.isClass) {
        std.uninitialized_copy(Begin, End, NewElts);
        // Destroy the original elements.
        destroy_range(Begin, End);
      } else {
        // Use memcpy for PODs (std::uninitialized_copy optimizes to memmove).
        memcpy(NewElts, Begin, CurSize);// * $sizeof_T());
      }
    }
    
    // For now, leak 'Begin'.  We can add it back to a freelist in
    // BumpVectorContext.
    Begin = $toConst(NewElts);
    End = $toConst(NewElts.$add(CurSize));
    Capacity = $toConst(Begin.$add(NewCapacity));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::construct_range">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 197,
   FQN="clang::BumpVector::construct_range", NM="_ZN5clang10BumpVector15construct_rangeEPT_S2_RKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector15construct_rangeEPT_S2_RKS1_")
  //</editor-fold>
  private void construct_range(type$ptr<T /*P*/ > S, type$ptr<T /*P*/ > E, final /*const*/ T /*&*/ Elt) {
    for (; Native.$noteq_iter((abstract_iterator)S, (abstract_iterator)E); S.$preInc())  {
       ///*FIXME: NEW_EXPR [NoNewFun]*/S = /*new (S)*/ new T(( Elt ));
       // JAVA: MEMORY
       if ($typeAllocator.isClass) {
         S.$set($typeAllocator.copyType.$call(Elt));
       } else {
         S.$set(Elt);
       }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::destroy_range">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 202,
   FQN="clang::BumpVector::destroy_range", NM="_ZN5clang10BumpVector13destroy_rangeEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector13destroy_rangeEPT_S2_")
  //</editor-fold>
  private void destroy_range(type$ptr<T /*P*/ > S, type$ptr<T /*P*/ > E) {
    assert $typeAllocator.isClass;
    E = $tryClone(E);
    while (Native.$noteq_iter((abstract_iterator)S, (abstract_iterator)E)) {
      E.$preDec();
      // JAVA: MEMORY
      Native.destroy(E.$star());//E->~T();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::BumpVector::move_range_right">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Support/BumpVector.h", line = 209,
   FQN="clang::BumpVector::move_range_right", NM="_ZN5clang10BumpVector16move_range_rightEPT_S2_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN5clang10BumpVector16move_range_rightEPT_S2_j")
  //</editor-fold>
  private void move_range_right(type$ptr<T /*P*/ > S, type$ptr<T /*P*/ > E, /*size_t*/int D) {
    E = $tryClone(E);
    for (type$ptr<T /*P*/ > I = E.$add(D - 1), /*P*/ IL = S.$add(D - 1); Native.$noteq_iter((abstract_iterator)I, (abstract_iterator)IL); I.$preDec()) {
      E.$preDec();
      ///*FIXME: NEW_EXPR [NoNewFun]*/I = /*new (I)*/ new T(( Native.$star(E) ));
      // JAVA: MEMORY
      if($typeAllocator.isClass) {
        I.$set($typeAllocator.copyType.$call(E.$star()));
        Native.destroy(E.$arrow());//E->~T();
      } else {
        I.$set(E.$star());
      }
      E.$set(null);
    }
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public type$ptr<T> /*&*/ ptr$at(/*uint*/int idx) {
    assert Begin.$add(idx).$less(End);
    return Begin.$add(idx);
  }
  
  private final TypeAllocator<T> $typeAllocator;
  
  @FunctionalInterface
  public interface Int2ArryType<Type> {
    public Type[] $call(int size);
  }
  
  public static final class TypeAllocator<T> {
    private final boolean isClass;
    private final Int2ArryType<T> newArryType;
    private final Type2RetType<T,T> copyType;
    public TypeAllocator(Int2ArryType<T> newArryType, Type2RetType<T,T> copyType) {
      this.isClass = true;
      this.newArryType = newArryType;
      this.copyType = copyType;
    }
    public TypeAllocator(Int2ArryType<T> newArryType) {
      this.isClass = false;
      this.newArryType = newArryType;
      this.copyType = null;
    }
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Begin=" + Begin // NOI18N
              + ", End=" + End // NOI18N
              + ", Capacity=" + Capacity; // NOI18N
  } 
}
