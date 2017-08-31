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

package org.llvm.adt;

import java.util.Iterator;
import org.clank.java.*;
import static org.clank.java.std.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.BoolPredicate;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.clank.support.JavaDifferentiators.*;

/*template <typename T, typename Vector = std::vector<T>, typename Set = SmallSet<T, 16>> TEMPLATE*/

/// \brief A vector that has set insertion semantics.
///
/// This adapter class provides a way to keep a set of things that also has the
/// property of a deterministic iteration order. The order of iteration is the
/// order of insertion.
//<editor-fold defaultstate="collapsed" desc="llvm::SetVector">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 36,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 35,
 FQN = "llvm::SetVector", NM = "_ZN4llvm9SetVectorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVectorE")
//</editor-fold>
public class SetVector</*typename*/ T /*typename Vector = std::vector<T>, typename Set = SmallSet<T, 16>*/>  implements Iterable<T>, Native.NativeComparable<SetVector<T>>, Destructors.ClassWithDestructor {
/*public:*/
  /*typedef T value_type*/
//  public final class value_type extends T{ };
  /*typedef T key_type*/
//  public final class key_type extends T{ };
  /*typedef T &reference*/
//  public final class reference extends T /*&*/ { };
  /*typedef const T &const_reference*/
//  public final class const_reference extends /*const*/T /*&*/ { };
  /*typedef Set set_type*/
//  public final class set_type extends Set{ };
  /*typedef Vector vector_type*/
//  public final class vector_type extends Vector{ };
  /*typedef typename vector_type::const_iterator iterator*/
//  public final class iterator extends  vector_type.const_iterator{ };
  /*typedef typename vector_type::const_iterator const_iterator*/
//  public final class const_iterator extends  vector_type.const_iterator{ };
  /*typedef typename vector_type::size_type size_type*/
//  public final class size_type extends  vector_type.size_type{ };
  
  private final T defaultValue;  
  
  /// \brief Construct an empty SetVector
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::SetVector<T, Vector, Set>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 50,
   FQN = "llvm::SetVector::SetVector<T, Vector, Set>", NM = "_ZN4llvm9SetVectorC1Ev",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVectorC1EvVector, Set>")
  //</editor-fold>
  public SetVector(T defaultValue) {
    this(16, defaultValue);
  }

  public SetVector(/*uint*/int N, T defaultValue) {  
    this.set_ = new SmallSet(N, defaultValue, defaultValue == null ? Native.Comparator$JavaRef() : null);
    this.vector_ = new std.vector(defaultValue);
    this.defaultValue = defaultValue;
  }    
  
  /// \brief Initialize a SetVector with a range of elements
  /*template <typename It> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::SetVector<T, Vector, Set>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 54,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::SetVector::SetVector<T, Vector, Set>")
  //</editor-fold>
  public SetVector(/*uint*/int N, type$iterator<?, T> Start, type$iterator<?, T> End, T defaultValue) {
    this(N, defaultValue);
    this.insert(Start, End);
  }
  
  public SetVector(SetVector<T> other) {
    this.set_ = new SmallSet(other.set_);
    this.vector_ = new std.vector(other.vector_);
    this.defaultValue = other.defaultValue;
  }

  public SetVector(JD$Move _p, SetVector<T> other) {
    this.set_ = other.set_;
    this.vector_ = other.vector_;
    this.defaultValue = other.defaultValue;
    other.set_ = null;
    other.vector_ = null;
  }

  public void $assign(SetVector<T> other) {
    this.set_.$destroy();
    this.set_ = new SmallSet(other.set_);
    this.vector_.$destroy();;
    this.vector_ = new std.vector(other.vector_);
    //JAVA: can not set default value as it is final! 
    //this.defaultValue = other.defaultValue;
  }

  /// \brief Determine if the SetVector is empty or not.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::empty">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 64,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 59,
   FQN = "llvm::SetVector::empty", NM = "_ZNK4llvm9SetVector5emptyEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return vector_.empty();
  }

  
  /// \brief Determine the number of elements in the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::size">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 69,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 64,
   FQN = "llvm::SetVector::size", NM = "_ZNK4llvm9SetVector4sizeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVector4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return vector_.size();
  }

  
  /// \brief Get an iterator to the beginning of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::begin">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 69,
   FQN = "llvm::SetVector::begin", NM = "_ZN4llvm9SetVector5beginEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector5beginEv")
  //</editor-fold>
  public std.vector.iterator<T> begin() {
    return vector_.begin();
  }
  public std.vector.iterator<T> begin$Const() {
    return begin();
  }


//  /// \brief Get a const_iterator to the beginning of the SetVector.
//  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::begin">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 74,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::SetVector::begin")
//  //</editor-fold>
//  public iterator begin() /*const*/ {
//    return vector_.begin();
//  }

  
  /// \brief Get an iterator to the end of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::end">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 79,
   FQN = "llvm::SetVector::end", NM = "_ZN4llvm9SetVector3endEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector3endEv")
  //</editor-fold>
  public std.vector.iterator<T> end() {
    return vector_.end();
  }
  public std.vector.iterator<T> end$Const() {
    return end();
  }

  
//  /// \brief Get a const_iterator to the end of the SetVector.
//  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::end">
//  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 84,
//   cmd="jclank.sh ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::SetVector::end")
//  //</editor-fold>
//  public iterator end() /*const*/ {
//    return vector_.end();
//  }

  /// \brief Get an reverse_iterator to the end of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 95,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 94,
   FQN="llvm::SetVector::rbegin", NM="_ZN4llvm9SetVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<T> rbegin() {
    return vector_.rbegin();
  }

  
  /// \brief Get a const_reverse_iterator to the end of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::rbegin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 100,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 99,
   FQN="llvm::SetVector::rbegin", NM="_ZNK4llvm9SetVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVector6rbeginEv")
  //</editor-fold>
  public std.reverse_iterator<T> rbegin$Const() /*const*/ {
    return vector_.rbegin();
  }

  
  /// \brief Get a reverse_iterator to the beginning of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 105,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 104,
   FQN="llvm::SetVector::rend", NM="_ZN4llvm9SetVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector4rendEv")
  //</editor-fold>
  public std.reverse_iterator<T> rend() {
    return vector_.rend();
  }

  
  /// \brief Get a const_reverse_iterator to the beginning of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::rend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 110,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 109,
   FQN="llvm::SetVector::rend", NM="_ZNK4llvm9SetVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVector4rendEv")
  //</editor-fold>
  public std.reverse_iterator<T> rend$Const() /*const*/ {
    return vector_.rend();
  }
  
  /// \brief Return the last element of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::back">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 89,
   FQN = "llvm::SetVector::back", NM = "_ZNK4llvm9SetVector4backEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVector4backEv")
  //</editor-fold>
  public /*const*/T /*&*/ back() /*const*/ {
    assert !empty() : "Cannot call back() on empty SetVector!";
    return vector_.back();
  }

  
  /// \brief Index into the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::operator[]">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 95,
   FQN = "llvm::SetVector::operator[]", NM = "_ZNK4llvm9SetVectorixENT0_9size_typeE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVectorixENT0_9size_typeE")
  //</editor-fold>
  public T $at(/*uint*/int n) /*const*/ {
    assert n < vector_.size() : "SetVector access out of range!";
    return vector_.$at(n);
  }

  
  /// \brief Insert a new element into the SetVector.
  /// \returns true iff the element was inserted into the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 127,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 102,
   FQN = "llvm::SetVector::insert", NM = "_ZN4llvm9SetVector6insertERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector6insertERKT_")
  //</editor-fold>
  public boolean insert(/*const*/T /*&*/ X) {
    boolean result = set_.insert(defaultValue == null ? X : $tryClone(X));
    if (result) {
      vector_.push_back(defaultValue == null ? X : $tryClone(X));
    }
    return result;
  }

  
  /// \brief Insert a range of elements into the SetVector.
  /*template <typename It> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::insert">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 111,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::SetVector::insert")
  //</editor-fold>
  public void insert(type$iterator<?, T> Start, type$iterator<?, T> End) {
    Start = $tryClone(Start);
    for (; $noteq_iter(Start, End); Start.$preInc())  {
      if (set_.insert(/*Deref*/defaultValue == null ? Start.$star() : $tryClone(Start.$star()))) {
        vector_.push_back(/*Deref*/defaultValue == null ? Start.$star() : $tryClone(Start.$star()));
      }
    }
  }

  
  /// \brief Remove an item from the set vector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::remove">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 118,
   FQN = "llvm::SetVector::remove", NM = "_ZN4llvm9SetVector6removeERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector6removeERKT_")
  //</editor-fold>
  public boolean remove(/*const*/T /*&*/ X) {
    if (set_.erase(X)) {
      assert vector_.contains(X) : "Corrupted SetVector instances!";
      vector_.erase(X);
      return true;
    }
    return false;
  }

  
  /// \brief Remove items from the set vector based on a predicate function.
  ///
  /// This is intended to be equivalent to the following code, if we could
  /// write it:
  ///
  /// \code
  ///   V.erase(std::remove_if(V.begin(), V.end(), P), V.end());
  /// \endcode
  ///
  /// However, SetVector doesn't expose non-const iterators, making any
  /// algorithm like remove_if impossible to use.
  ///
  /// \returns true if any element is removed.
  /*template <typename UnaryPredicate> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::remove_if">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 143,
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -filter=llvm::SetVector::remove_if")
  //</editor-fold>
  public boolean remove_if(BoolPredicate<T> P) {
     std.vector.iterator<T> I = std.remove_if(vector_.begin(), vector_.end(), new TestAndEraseFromSet(P, set_));
    if ($eq___normal_iterator(I, vector_.end())) {
      return false;
    }
    vector_.erase(I, vector_.end());
    return true;
  }

  
  /// \brief Count the number of elements of a given key in the SetVector.
  /// \returns 0 if the element is not in the SetVector, 1 if it is.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::count">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 180,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 156,
   FQN = "llvm::SetVector::count", NM = "_ZNK4llvm9SetVector5countERKT_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVector5countERKT_")
  //</editor-fold>
  public /*uint*/int count(/*const*/T /*&*/ key) /*const*/ {
    return set_.count(key);
  }

  
  /// \brief Completely clear the SetVector
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::clear">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 161,
   FQN = "llvm::SetVector::clear", NM = "_ZN4llvm9SetVector5clearEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector5clearEv")
  //</editor-fold>
  public void clear() {
    set_.clear();
    vector_.clear();
  }

  
  /// \brief Remove the last element of the SetVector.
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::pop_back">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 191,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 167,
   FQN = "llvm::SetVector::pop_back", NM = "_ZN4llvm9SetVector8pop_backEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    assert !empty() : "Cannot remove an element from an empty SetVector!";
    set_.erase(back());
    vector_.pop_back();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::pop_back_val">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 173,
   FQN = "llvm::SetVector::pop_back_val", NM = "_ZN4llvm9SetVector12pop_back_valEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector12pop_back_valEv")
  //</editor-fold>
  public T pop_back_val()/* __attribute__((warn_unused_result))*/ {
    T Ret = back();
    pop_back();
    return Ret;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 203,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 179,
   FQN = "llvm::SetVector::operator==", NM = "_ZNK4llvm9SetVectoreqERKNS_9SetVectorIT_T0_T1_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVectoreqERKNS_9SetVectorIT_T0_T1_EE")
  //</editor-fold>
  public boolean $eq(/*const*/SetVector<T> /*&*/ that) /*const*/ {
    return Native.$eq(vector_, that.vector_);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 207,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 183,
   FQN = "llvm::SetVector::operator!=", NM = "_ZNK4llvm9SetVectorneERKNS_9SetVectorIT_T0_T1_EE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZNK4llvm9SetVectorneERKNS_9SetVectorIT_T0_T1_EE")
  //</editor-fold>
  public boolean $noteq(/*const*/SetVector<T> /*&*/ that) /*const*/ {
    return Native.$noteq(vector_, that.vector_);
  }

  @Override
  public void $destroy() {
    set_.$destroy();
    vector_.$destroy();
  }

/*private:*/
  /// \brief A wrapper predicate designed for use with std::remove_if.
  ///
  /// This predicate wraps a predicate suitable for use with std::remove_if to
  /// call set_.erase(x) on each element which is slated for removal.
  /*template <typename UnaryPredicate> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::TestAndEraseFromSet">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 216,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 192,
   FQN = "llvm::SetVector::TestAndEraseFromSet", NM = "_ZN4llvm9SetVector19TestAndEraseFromSetE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector19TestAndEraseFromSetE")
  //</editor-fold>
  public static class TestAndEraseFromSet</*typename*/ T> implements BoolPredicate<T> {
    private BoolPredicate<T> P;
    private SmallSet<T> /*&*/ set_;
  /*public:*/
    /*typedef typename UnaryPredicate::argument_type argument_type*/
//    public final class argument_type extends  UnaryPredicate.argument_type{ };
    //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::TestAndEraseFromSet::TestAndEraseFromSet<UnaryPredicate>">
    @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 222,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", old_line = 198,
     FQN = "llvm::SetVector::TestAndEraseFromSet::TestAndEraseFromSet<UnaryPredicate>", NM = "_ZN4llvm9SetVector19TestAndEraseFromSetC1ET_RT1_",
     cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector19TestAndEraseFromSetC1ET_RT1_")
    //</editor-fold>
    public TestAndEraseFromSet(BoolPredicate<T> P, SmallSet<T> /*&*/ set_) {
      /* : P(P), set_(set_)*/ 
      //START JInit
      this.P = P;
      this.set_ = set_;
      //END JInit
    }

    /*template <typename ArgumentT> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::SetVector::TestAndEraseFromSet::operator()">
    @Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SetVector.h", line = 201,
     FQN="llvm::SetVector::TestAndEraseFromSet::operator()", NM="_ZN4llvm9SetVector19TestAndEraseFromSetclERKT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/Lexer.cpp -nm=_ZN4llvm9SetVector19TestAndEraseFromSetclERKT_")
    //</editor-fold>
    public boolean $call(/*const*/ T /*&*/ Arg) {
      if (P.$call(Arg)) {
        set_.erase(Arg);
        return true;
      }
      return false;
    }

  };
  private SmallSet<T> set_; ///< The set.
  private std.vector<T> vector_; ///< The vector.

  @Override
  public Iterator<T> iterator() {
    return new JavaIterator<>(begin(), end());
  }

  @Override
  public String toString() {
    return "" + this.vector_;
  }
}
