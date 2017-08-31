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

package org.clang.ast.aliases;

import java.util.Arrays;
import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.clang.ast.*;

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::ASTVector">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 32,
 FQN="clang::ASTVector", NM="_ZN5clang9ASTVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectorE")
//</editor-fold>
public class ${FILE_NAME}${CLASS_SUFFIX} implements Destructors.ClassWithDestructor,
        Iterable<${BOXED_TYPE}>, NativeIterable<${PTR_TYPE}>, NativeReverseIterable<${REVERSE_ITER_TYPE}> {
/*private:*/
  private ${PTR_TYPE} Begin;
  private ${PTR_TYPE} End;
  private PointerBoolPair<${PTR_TYPE}> Capacity;
  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::setEnd">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 38,
   FQN="clang::ASTVector::setEnd", NM="_ZN5clang9ASTVector6setEndEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6setEndEPT_")
  //</editor-fold>
  private void setEnd(${PTR_TYPE} P) {
    this.End = $tryClone(P);
  }

/*protected:*/
  // Make a tag bit available to users of this class.
  // FIXME: This is a horrible hack.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::getTag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 43,
   FQN="clang::ASTVector::getTag", NM="_ZNK5clang9ASTVector6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector6getTagEv")
  //</editor-fold>
  protected boolean getTag() /*const*/ {
    return Capacity.getInt();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::setTag">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 44,
   FQN="clang::ASTVector::setTag", NM="_ZN5clang9ASTVector6setTagEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6setTagEb")
  //</editor-fold>
  protected void setTag(boolean B) {
    Capacity.setInt(B);
  }

  ${DEFAULT_CTOR_DECL}

/*public:*/
  // Default ctor - Initialize to empty.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::${CLASS_TYPE}">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 48,
   FQN="clang::ASTVector::${CLASS_TYPE}", NM="_ZN5clang9ASTVectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectorC1Ev")
  //</editor-fold>
  public ${FILE_NAME}(${VALUE_TYPE} defaultValue) {
    // : Begin(null), End(null), Capacity(null, false) 
    //START JInit
    this.Begin = /*ParenListExpr*/${CREATE_NULL_PTR}();
    this.End = /*ParenListExpr*/${CREATE_NULL_PTR}();
    this.Capacity = /*ParenListExpr*/new PointerBoolPair<>(${CREATE_NULL_PTR}(), false);
    this.defaultValue = defaultValue;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::${CLASS_TYPE}">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 50,
   FQN="clang::ASTVector::${CLASS_TYPE}", NM="_ZN5clang9ASTVectorC1EONS_9ASTVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectorC1EONS_9ASTVectorIT_EE")
  //</editor-fold>
  public ${FILE_NAME}(JD$Move _dparam, final ${CLASS_TYPE} /*&&*/O) {
    // : Begin(O.Begin), End(O.End), Capacity(O.Capacity) 
    //START JInit
    this.Begin = /*ParenListExpr*/O.Begin;
    this.End = /*ParenListExpr*/O.End;
    this.Capacity = /*ParenListExpr*/new PointerBoolPair<>(O.Capacity);
    this.defaultValue = O.defaultValue;
    //END JInit
    O.Begin = O.End = null;
    O.Capacity.setPointer(null);
    O.Capacity.setInt(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::${CLASS_TYPE}">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 56,
   FQN="clang::ASTVector::${CLASS_TYPE}", NM="_ZN5clang9ASTVectorC1ERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectorC1ERKNS_10ASTContextEj")
  //</editor-fold>
  public ${FILE_NAME}(final /*const*/ ASTContext /*&*/ C, /*uint*/int N, ${VALUE_TYPE} defaultValue) {
    // : Begin(null), End(null), Capacity(null, false) 
    //START JInit
    this.Begin = /*ParenListExpr*/${CREATE_NULL_PTR}();
    this.End = /*ParenListExpr*/${CREATE_NULL_PTR}();
    this.Capacity = /*ParenListExpr*/new PointerBoolPair<>(${CREATE_NULL_PTR}(), false);
    this.defaultValue = defaultValue;
    //END JInit
    reserve(C, N);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::operator=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 61,
   FQN="clang::ASTVector::operator=", NM="_ZN5clang9ASTVectoraSEONS_9ASTVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectoraSEONS_9ASTVectorIT_EE")
  //</editor-fold>
  public ${CLASS_TYPE} /*&*/ $assignMove(final ${CLASS_TYPE} /*&&*/RHS) {
    ${ASSIGN_MOVE_ASSERTION};
    ${CLASS_TYPE} O = null;
    try {
      O/*J*/= /*ParenList*/new ${CLASS_TYPE}(JD$Move.INSTANCE, RHS);
      //JAVA: using std::swap;
      swap(Begin, O.Begin);
      swap(End, O.End);
      swap(Capacity, O.Capacity);
      return Native.$star(this);
    } finally {
      if (O != null) { O.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::~${CLASS_TYPE}">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 70,
   FQN="clang::ASTVector::~${CLASS_TYPE}", NM="_ZN5clang9ASTVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (needsCleanup) {
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
//  public final class const_reverse_iterator extends ${REVERSE_ITER_TYPE}{ };
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
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 92,
   FQN="clang::ASTVector::begin", NM="_ZN5clang9ASTVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector5beginEv")
  //</editor-fold>
  public ${PTR_TYPE} begin() {
    return Begin;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 93,
   FQN="clang::ASTVector::begin", NM="_ZNK5clang9ASTVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector5beginEv")
  //</editor-fold>
  public ${PTR_TYPE} begin$Const() /*const*/ {
    return Begin;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 94,
   FQN="clang::ASTVector::end", NM="_ZN5clang9ASTVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector3endEv")
  //</editor-fold>
  public ${PTR_TYPE} end() {
    return End;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 95,
   FQN="clang::ASTVector::end", NM="_ZNK5clang9ASTVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector3endEv")
  //</editor-fold>
  public ${PTR_TYPE} end$Const() /*const*/ {
    return End;
  }

  
  // reverse iterator creation methods.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::rbegin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 98,
   FQN="clang::ASTVector::rbegin", NM="_ZN5clang9ASTVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6rbeginEv")
  //</editor-fold>
  public  ${REVERSE_ITER_TYPE}  rbegin() {
    return new  ${REVERSE_ITER_TYPE} (end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::rbegin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 99,
   FQN="clang::ASTVector::rbegin", NM="_ZNK5clang9ASTVector6rbeginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector6rbeginEv")
  //</editor-fold>
  public ${REVERSE_ITER_TYPE} rbegin$Const() /*const*/ {
    return new ${REVERSE_ITER_TYPE}(end());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::rend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 100,
   FQN="clang::ASTVector::rend", NM="_ZN5clang9ASTVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector4rendEv")
  //</editor-fold>
  public  ${REVERSE_ITER_TYPE}  rend() {
    return new  ${REVERSE_ITER_TYPE} (begin());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::rend">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 101,
   FQN="clang::ASTVector::rend", NM="_ZNK5clang9ASTVector4rendEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector4rendEv")
  //</editor-fold>
  public ${REVERSE_ITER_TYPE} rend$Const() /*const*/ {
    return new ${REVERSE_ITER_TYPE}(begin());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::empty">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 103,
   FQN="clang::ASTVector::empty", NM="_ZNK5clang9ASTVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Native.$eq_ptr(Begin, End);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::size">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 104,
   FQN="clang::ASTVector::size", NM="_ZNK5clang9ASTVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector4sizeEv")
  //</editor-fold>
  public /*size_t*/int size() /*const*/ {
    return End.$sub(Begin);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 106,
   FQN="clang::ASTVector::operator[]", NM="_ZN5clang9ASTVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVectorixEj")
  //</editor-fold>
  public ${VALUE_TYPE} /*&*/ $at(/*uint*/int idx) {
    assert Native.$bool(Native.$less(Begin.$add(idx), End));
    return Begin.$at(idx);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 110,
   FQN="clang::ASTVector::operator[]", NM="_ZNK5clang9ASTVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVectorixEj")
  //</editor-fold>
  public /*const*/ ${VALUE_TYPE} /*&*/ $at$Const(/*uint*/int idx) /*const*/ {
    return $at(idx);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::front">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 115,
   FQN="clang::ASTVector::front", NM="_ZN5clang9ASTVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector5frontEv")
  //</editor-fold>
  public ${VALUE_TYPE} /*&*/ front() {
    return begin().$at(0);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::front">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 118,
   FQN="clang::ASTVector::front", NM="_ZNK5clang9ASTVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector5frontEv")
  //</editor-fold>
  public /*const*/ ${VALUE_TYPE} /*&*/ front$Const() /*const*/ {
    return begin().$at(0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 122,
   FQN="clang::ASTVector::back", NM="_ZN5clang9ASTVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector4backEv")
  //</editor-fold>
  public ${VALUE_TYPE} /*&*/ back() {
    return end().$at(-1);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 125,
   FQN="clang::ASTVector::back", NM="_ZNK5clang9ASTVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector4backEv")
  //</editor-fold>
  public /*const*/ ${VALUE_TYPE} /*&*/ back$Const() /*const*/ {
    return end().$at(-1);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::pop_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 129,
   FQN="clang::ASTVector::pop_back", NM="_ZN5clang9ASTVector8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    // --End;
    // End->~T();
    ${PTR_TYPE} PrevEnd = End.$postDec();
    destroy_range(End, PrevEnd);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::pop_back_val">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 134,
   FQN="clang::ASTVector::pop_back_val", NM="_ZN5clang9ASTVector12pop_back_valEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector12pop_back_valEv")
  //</editor-fold>
  public ${VALUE_TYPE} pop_back_val() {
    ${VALUE_TYPE} Result = back();
    pop_back();
    return Result;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::clear">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 140,
   FQN="clang::ASTVector::clear", NM="_ZN5clang9ASTVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector5clearEv")
  //</editor-fold>
  public void clear() {
    if (needsCleanup) {
      destroy_range(Begin, End);
    }
    End.$assign(Begin);
  }

  
  /// data - Return a pointer to the vector's buffer, even if empty().
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::data">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 148,
   FQN="clang::ASTVector::data", NM="_ZN5clang9ASTVector4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector4dataEv")
  //</editor-fold>
  public ${PTR_TYPE} /*P*/ data() {
    return Begin;
  }

  
  /// data - Return a pointer to the vector's buffer, even if empty().
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::data">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 153,
   FQN="clang::ASTVector::data", NM="_ZNK5clang9ASTVector4dataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector4dataEv")
  //</editor-fold>
  public /*const*/ ${PTR_TYPE} /*P*/ data$Const() /*const*/ {
    return /*const*/ Begin;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::push_back">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 157,
   FQN="clang::ASTVector::push_back", NM="_ZN5clang9ASTVector9push_backERKT_RKNS_10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector9push_backERKT_RKNS_10ASTContextE")
  //</editor-fold>
  public void push_back(final /*const*/ ${VALUE_TYPE} /*&*/ Elt, final /*const*/ ASTContext /*&*/ C) {
    for (int $i = 0; $i < 2; ++$i) {
      if (Native.$less(End, this.capacity_ptr())) {
        // native: new (End) T(Elt);
        End.$set($tryAssign(End.$star(), Elt, isDataPointerLike()));
        End.$preInc();
        return;
      }
      grow(C);
    }
    throw new llvm_unreachable("we should never get here");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::reserve">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 168,
   FQN="clang::ASTVector::reserve", NM="_ZN5clang9ASTVector7reserveERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector7reserveERKNS_10ASTContextEj")
  //</editor-fold>
  public void reserve(final /*const*/ ASTContext /*&*/ C, /*uint*/int N) {
    if ($less_uint(/*uint*/this.capacity_ptr().$sub(Begin), N)) {
      grow(C, N);
    }
  }

  
  /// capacity - Return the total number of elements in the currently allocated
  /// buffer.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::capacity">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 175,
   FQN="clang::ASTVector::capacity", NM="_ZNK5clang9ASTVector8capacityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector8capacityEv")
  //</editor-fold>
  public /*size_t*/int capacity() /*const*/ {
    return this.capacity_ptr().$sub(Begin);
  }

  
  /// append - Add the specified range to the end of the SmallVector.
  ///
  /*template <typename in_iter> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::append">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 180,
   FQN="clang::ASTVector::append", NM="Tpl__ZN5clang9ASTVector6appendERKNS_10ASTContextET_S4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang9ASTVector6appendERKNS_10ASTContextET_S4_")
  //</editor-fold>
  public </*typename*/ in_iter extends ${GENERIC_ITER_TYPE}> void append_ASTContext$C_T(final /*const*/ ASTContext /*&*/ C, in_iter in_start, in_iter in_end) {
    /*size_t*/int NumInputs = std.distance(in_start, in_end);
    if (NumInputs == 0) {
      return;
    }
    
    // Grow allocated space if needed.
    if ($greater_uint(NumInputs, this.capacity_ptr().$sub(this.end()))) {
      this.grow(C, this.size() + NumInputs);
    }
    
    // Copy the new elements over.
    // TODO: NEED To compile time dispatch on whether in_iter is a random access
    // iterator to use the fast uninitialized_copy.
    std.uninitialized_copy(in_start, in_end, this.end());
    this.setEnd(this.end().$add(NumInputs));
  }

  
  /// append - Add the specified range to the end of the SmallVector.
  ///
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::append">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 199,
   FQN="clang::ASTVector::append", NM="_ZN5clang9ASTVector6appendERKNS_10ASTContextEjRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6appendERKNS_10ASTContextEjRKT_")
  //</editor-fold>
  public void append_ASTContext$C_uint_T$C$R(final /*const*/ ASTContext /*&*/ C, /*size_t*/int NumInputs, final /*const*/ ${VALUE_TYPE} /*&*/ Elt) {
    // Grow allocated space if needed.
    if ($greater_uint(NumInputs, this.capacity_ptr().$sub(this.end()))) {
      this.grow(C, this.size() + NumInputs);
    }
    
    // Copy the new elements over.
    std.uninitialized_fill_n(this.end(), NumInputs, Elt);
    this.setEnd(this.end().$add(NumInputs));
  }

  
  /// uninitialized_copy - Copy the range [I, E) onto the uninitialized memory
  /// starting with "Dest", constructing elements into it as needed.
  /*template <typename It1, typename It2> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::uninitialized_copy">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 212,
   FQN="clang::ASTVector::uninitialized_copy", NM="Tpl__ZN5clang9ASTVector18uninitialized_copyET_S1_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang9ASTVector18uninitialized_copyET_S1_T0_")
  //</editor-fold>
  public static 
  ${UC_TEMPLATE_PREFIX} 
  void uninitialized_copy(${ITER_TYPE} I, ${ITER_TYPE} E, DestIter Dest) {
    std.uninitialized_copy(I, E, Dest);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 216,
   FQN="clang::ASTVector::insert", NM="_ZN5clang9ASTVector6insertERKNS_10ASTContextEPT_RKS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6insertERKNS_10ASTContextEPT_RKS4_")
  //</editor-fold>
  public ${PTR_TYPE} insert(final /*const*/ ASTContext /*&*/ C, ${PTR_TYPE} I, final /*const*/ ${VALUE_TYPE} /*&*/ Elt) {
    if (Native.$eq_ptr(I, this.end())) { // Important special case for empty vector.
      push_back(Elt, C);
      return this.end().$sub(1);
    }
    for (int $i = 0; $i < 2; ++$i) {
      if (Native.$less(this.End, this.capacity_ptr())) {
        // native: new (this->end()) T(this->back());
        this.end().$set($tryAssign(this.end().$star(), this.back(), isDataPointerLike()));
        this.setEnd(this.end().$add(1));
        // Push everything else over.
        std.copy_backward(I, this.end().$sub(1), this.end());
        I.star$ref().$set(Elt);
        return I;
      }
      /*size_t*/int EltNo = I.$sub(this.begin());
      this.grow(C);
      I = this.begin().$add(EltNo);
    }
    throw new llvm_unreachable("we should never get here");
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 237,
   FQN="clang::ASTVector::insert", NM="_ZN5clang9ASTVector6insertERKNS_10ASTContextEPT_jRKS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6insertERKNS_10ASTContextEPT_jRKS4_")
  //</editor-fold>
  public ${PTR_TYPE} insert_ASTContext$C_type$ptr$T$P_uint_T$C$R(final /*const*/ ASTContext /*&*/ C, ${PTR_TYPE} I, /*size_t*/int NumToInsert, 
                                             final /*const*/ ${VALUE_TYPE} /*&*/ Elt) {
    // Convert iterator to elt# to avoid invalidating iterator when we reserve()
    /*size_t*/int InsertElt = I.$sub(this.begin());
    if (Native.$eq_ptr(I, this.end())) { // Important special case for empty vector.
      append_ASTContext$C_uint_T$C$R(C, NumToInsert, Elt);
      return this.begin().$add(InsertElt);
    }
    
    // Ensure there is enough space.
    reserve(C, ((/*static_cast*//*uint*/int)(this.size() + NumToInsert)));
    
    // Uninvalidate the iterator.
    I = this.begin().$add(InsertElt);
    
    // If there are more elements between the insertion point and the end of the
    // range than there are being inserted, we can use a simple approach to
    // insertion.  Since we already reserved space, we know that this won't
    // reallocate the vector.
    if ($greatereq_uint(/*size_t*/this.end().$sub(I), NumToInsert)) {
      ${PTR_TYPE} /*P*/ OldEnd = this.end();
      append_ASTContext$C_T(C, this.end().$sub(NumToInsert), this.end());
      
      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd);
      
      std.fill_n(I, NumToInsert, Elt);
      return I;
    }
    
    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.
    
    // Copy over the elements that we're about to overwrite.
    ${PTR_TYPE} OldEnd = this.end();
    this.setEnd(this.end().$add(NumToInsert));
    /*size_t*/int NumOverwritten = OldEnd.$sub(I);
    this.uninitialized_copy(I, OldEnd, this.end().$sub(NumOverwritten));
    
    // Replace the overwritten part.
    std.fill_n(I, NumOverwritten, Elt);
    
    // Insert the non-overwritten middle part.
    std.uninitialized_fill_n(OldEnd, NumToInsert - NumOverwritten, Elt);
    return I;
  }

  
  /*template <typename ItTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::insert">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 286,
   FQN="clang::ASTVector::insert", NM="Tpl__ZN5clang9ASTVector6insertERKNS_10ASTContextEPT_T_S6_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=Tpl__ZN5clang9ASTVector6insertERKNS_10ASTContextEPT_T_S6_")
  //</editor-fold>
  public </*typename*/ ItTy extends ${GENERIC_ITER_TYPE}> ${PTR_TYPE} insert_ASTContext$C_type$ptr$T$P_T(final /*const*/ ASTContext /*&*/ C, ${PTR_TYPE} I, ItTy From, ItTy To) {
    // Convert iterator to elt# to avoid invalidating iterator when we reserve()
    /*size_t*/int InsertElt = I.$sub(this.begin());
    if (Native.$eq_ptr(I, this.end())) { // Important special case for empty vector.
      append_ASTContext$C_T(C, From, To);
      return this.begin().$add(InsertElt);
    }
    
    /*size_t*/int NumToInsert = std.distance(From, To);
    
    // Ensure there is enough space.
    reserve(C, ((/*static_cast*//*uint*/int)(this.size() + NumToInsert)));
    
    // Uninvalidate the iterator.
    I = this.begin().$add(InsertElt);
    
    // If there are more elements between the insertion point and the end of the
    // range than there are being inserted, we can use a simple approach to
    // insertion.  Since we already reserved space, we know that this won't
    // reallocate the vector.
    if ($greatereq_uint(this.end().$sub(I), NumToInsert)) {
      ${PTR_TYPE} OldEnd = this.end();
      append_ASTContext$C_T(C, this.end().$sub(NumToInsert), this.end());
      
      // Copy the existing elements that get replaced.
      std.copy_backward(I, OldEnd.$sub(NumToInsert), OldEnd);
      
      std.copy(From, To, I);
      return I;
    }
    
    // Otherwise, we're inserting more elements than exist already, and we're
    // not inserting at the end.
    
    // Copy over the elements that we're about to overwrite.
    ${PTR_TYPE} OldEnd = this.end();
    this.setEnd(this.end().$add(NumToInsert));
    /*size_t*/int NumOverwritten = OldEnd.$sub(I);
    this.uninitialized_copy(I, OldEnd, this.end().$sub(NumOverwritten));
    
    // Replace the overwritten part.
    for (; $greater_uint(NumOverwritten, 0); --NumOverwritten) {
      I.star$ref().$set(From.$star());
      I.$preInc();
      From.$preInc();
    }
    
    // Insert the non-overwritten middle part.
    this.uninitialized_copy((${ITER_TYPE}) From, (${ITER_TYPE}) To, OldEnd);
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::resize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 338,
   FQN="clang::ASTVector::resize", NM="_ZN5clang9ASTVector6resizeERKNS_10ASTContextEjRKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector6resizeERKNS_10ASTContextEjRKT_")
  //</editor-fold>
  public void resize(final /*const*/ ASTContext /*&*/ C, /*uint*/int N, final /*const*/ ${VALUE_TYPE} /*&*/ NV) {
    if (Native.$less(N, this.size())) {
      this.destroy_range(this.begin().$add(N), this.end());
      this.setEnd(this.begin().$add(N));
    } else if (Native.$greater(N, this.size())) {
      if (Native.$less(this.capacity(), N)) {
        this.grow(C, N);
      }
      construct_range($tryClone(this.end()), this.begin().$add(N), NV);
      this.setEnd(this.begin().$add(N));
    }
  }

/*private:*/
  /// grow - double the size of the allocated memory, guaranteeing space for at
  /// least one more element or MinSize if specified.
  
  // Define this out-of-line to dissuade the C++ compiler from inlining it.
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::grow">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 375,
   FQN="clang::ASTVector::grow", NM="_ZN5clang9ASTVector4growERKNS_10ASTContextEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector4growERKNS_10ASTContextEj")
  //</editor-fold>
  private void grow(final /*const*/ ASTContext /*&*/ C) {
    grow(C, 1);
  }
  private void grow(final /*const*/ ASTContext /*&*/ C, /*size_t*/int MinSize/*= 1*/) {
    /*size_t*/int CurCapacity = this.capacity();
    /*size_t*/int CurSize = size();
    /*size_t*/int NewCapacity = 2 * CurCapacity;
    if ($less_uint(NewCapacity, MinSize)) {
      NewCapacity = MinSize;
    }    
    // JAVA:
    final ${VALUE_TYPE}[] buf = (${VALUE_TYPE}[]) ${CREATE_ARRAY}(NewCapacity);
    // Allocate the memory from the ASTContext.
    ${PTR_TYPE} /*P*/ NewElts = ${CREATE_PTR}(buf);
    if (false && !isDataPointerLike()) { // memcpy below should be enough
      std.fill(NewElts, NewElts.$add(NewCapacity), defaultValue);
    }

    // Copy the elements over.
    if (Native.$noteq_ptr(Begin, End)) {
      if (needsCleanup) {
        std.uninitialized_copy(Begin, End, NewElts);
        // Destroy the original elements.
        destroy_range(Begin, $tryClone(End));
      } else {
        // Use memcpy for PODs (std::uninitialized_copy optimizes to memmove).
        memcpy(NewElts, Begin, CurSize * sizeof(${VALUE_CLASS}), isDataPointerLike());
      }
    }
    
    // ASTContext never frees any memory.
    Begin = NewElts;
    End = NewElts.$add(CurSize);
    Capacity.setPointer(Begin.$add(NewCapacity));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::construct_range">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 355,
   FQN="clang::ASTVector::construct_range", NM="_ZN5clang9ASTVector15construct_rangeEPT_S2_RKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector15construct_rangeEPT_S2_RKS1_")
  //</editor-fold>
  private void construct_range(${PTR_TYPE} /*P*/ S, ${PTR_TYPE} /*P*/ E, final /*const*/ ${VALUE_TYPE} /*&*/ Elt) {
    ${CONSTRUCT_RANGE_IMPL}
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::destroy_range">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 360,
   FQN="clang::ASTVector::destroy_range", NM="_ZN5clang9ASTVector13destroy_rangeEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector13destroy_rangeEPT_S2_")
  //</editor-fold>
  private void destroy_range(${PTR_TYPE} S, ${PTR_TYPE} E) {
    ${DESTROY_RANGE_IMPL}
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::capacity_ptr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 368,
   FQN="clang::ASTVector::capacity_ptr", NM="_ZNK5clang9ASTVector12capacity_ptrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZNK5clang9ASTVector12capacity_ptrEv")
  //</editor-fold>
  protected ${PTR_TYPE} capacity_ptr$Const() /*const*/ {
    return (${PTR_TYPE}) Capacity.getPointer();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ASTVector::capacity_ptr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTVector.h", line = 371,
   FQN="clang::ASTVector::capacity_ptr", NM="_ZN5clang9ASTVector12capacity_ptrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTReader.cpp -nm=_ZN5clang9ASTVector12capacity_ptrEv")
  //</editor-fold>
  protected ${PTR_TYPE} capacity_ptr() {
    return (${PTR_TYPE})Capacity.getPointer();
  }
  
  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  protected final boolean needsCleanup = false;
  protected final ${VALUE_TYPE} defaultValue;
  // Only Java! 
  // Means that in native code AstVector contained pointers but in Java they were converted as Java references
  public boolean isDataPointerLike() {
    ${IS_DATA_POINTER_LIKE_IMPL}
  }
  public void $set(int Init, ${VALUE_TYPE} expr) { 
    Begin.$set(Init, expr); 
  }

  @Override 
  public Iterator<${BOXED_TYPE}> iterator() { 
    return new ${JAVA_ITERATOR}(begin(), end()); 
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////

  @Override public String toString() {
    StringBuilder txt = new StringBuilder();
    txt.append("${FILE_NAME}${CLASS_SUFFIX} Capacity=").append(Capacity).append(":");
    long idx=0;
    for (${BOXED_TYPE} elem : this) {
      txt.append("\n[").append(NativeTrace.formatNumber(idx++, 2)).append("]");
      txt.append(${ELEM_TO_STRING});
    }
    return txt.toString();
  }
}
