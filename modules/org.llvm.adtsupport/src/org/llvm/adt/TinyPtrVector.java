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

import static org.clank.support.Native.$AddrOf;
import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


/// TinyPtrVector - This class is specialized for cases where there are
/// normally 0 or 1 element in a vector, but is general enough to go beyond that
/// when required.
///
/// NOTE: This container doesn't allow you to store a null pointer into it.
///
/*template <typename EltTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 25,
 FQN="llvm::TinyPtrVector", NM="_ZN4llvm13TinyPtrVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorE")
//</editor-fold>
public class TinyPtrVector</*typename*/ EltTy>  implements NativeCloneable<TinyPtrVector<EltTy>>, 
        NativeIterable<type$ptr<EltTy>>, Destructors.ClassWithDestructor, Iterable<EltTy> {
/*public:*/
  /*typedef llvm::SmallVector<EltTy, 4> VecTy*/
//  public final class VecTy extends SmallVector<EltTy>{ };
  /*typedef typename VecTy::value_type value_type*/
//  public final class value_type extends  SmallVector<EltTy>.value_type{ };
  /*typedef llvm::PointerUnion<EltTy, VecTy *> PtrUnion*/
//  public final class PtrUnion extends PointerUnion<EltTy, SmallVector<EltTy> /*P*/>{ };
/*private:*/
  // JAVA: changed to Object[]
  private final Object Val[] = new Object[]{null};
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private boolean $vector;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private boolean $isNull() {
    return Val[0] == null;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private boolean $isElement() {
    return !$vector;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private EltTy $getAsElement() {
    return $isElement() ? (EltTy) Val[0] : null;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private boolean $isVector() {
    return $vector;
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private SmallVector<EltTy> $getAsVector() {
    return $isVector() ? (SmallVector<EltTy>) Val[0] : null;
  }
  
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::TinyPtrVector<EltTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 36,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 33,
   FQN="llvm::TinyPtrVector::TinyPtrVector<EltTy>", NM="_ZN4llvm13TinyPtrVectorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorC1Ev")
  //</editor-fold>
  public TinyPtrVector() {
    Val[0] = null;
    $vector = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::~TinyPtrVector<EltTy>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 37,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 34,
   FQN="llvm::TinyPtrVector::~TinyPtrVector<EltTy>", NM="_ZN4llvm13TinyPtrVectorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorD0Ev")
  //</editor-fold>
  public void $destroy() {
    {
      SmallVector<EltTy> /*P*/ V = $getAsVector();
      if (V != null) {
        /*delete*/Destructors.$destroy(V);
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::TinyPtrVector<EltTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 39,
   FQN="llvm::TinyPtrVector::TinyPtrVector<EltTy>", NM="_ZN4llvm13TinyPtrVectorC1ERKNS_13TinyPtrVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorC1ERKNS_13TinyPtrVectorIT_EE")
  //</editor-fold>
  public TinyPtrVector(/*const*/ TinyPtrVector<EltTy> /*&*/ RHS) {
    /* : Val(RHS.Val)*/ 
    //START JInit
    this.Val[0] = /*ParenListExpr*/RHS.Val[0];
    this.$vector = RHS.$vector;
    //END JInit
    {
      SmallVector<EltTy> /*P*/ V = $getAsVector();
      if (V != null) {
        Val[0] = new SmallVector<EltTy>(Native.$star(V));
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 43,
   FQN="llvm::TinyPtrVector::operator=", NM="_ZN4llvm13TinyPtrVectoraSERKNS_13TinyPtrVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectoraSERKNS_13TinyPtrVectorIT_EE")
  //</editor-fold>
  public TinyPtrVector<EltTy> /*&*/ $assign(/*const*/ TinyPtrVector<EltTy> /*&*/ RHS) {
    if (Native.$eq(this, $AddrOf(RHS))) {
      return Native.$star(this);
    }
    if (RHS.empty()) {
      this.clear();
      return Native.$star(this);
    }
    
    // Try to squeeze into the single slot. If it won't fit, allocate a copied
    // vector.
    if ($isElement()) {
      if (Native.$eq(RHS.size(), 1)) {
        Val[0] = RHS.front();
        $vector = false;
      } else {
        Val[0] = new SmallVector<EltTy>( Native.$star((SmallVector<EltTy>) RHS.Val[0]) );
        $vector = true;
      }
      return Native.$star(this);
    }
    
    // If we have a full vector allocated, try to re-use it.
    if (RHS.$isElement()) {
      $getAsVector().clear();
      $getAsVector().push_back(RHS.front());
    } else {
      Native.$star($getAsVector()).$assign(Native.$star(RHS.$getAsVector()));
    }
    return Native.$star(this);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::TinyPtrVector<EltTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 71,
   FQN="llvm::TinyPtrVector::TinyPtrVector<EltTy>", NM="_ZN4llvm13TinyPtrVectorC1EONS_13TinyPtrVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorC1EONS_13TinyPtrVectorIT_EE")
  //</editor-fold>
  public TinyPtrVector(JD$Move _dparam, TinyPtrVector<EltTy> /*&&*/RHS) {
    /* : Val(RHS.Val)*/ 
    //START JInit
    this.Val[0] = /*ParenListExpr*/RHS.Val[0];
    this.$vector = RHS.$vector;
    //END JInit
    RHS.Val[0] = null;
    RHS.$vector = false;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 77,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 74,
   FQN="llvm::TinyPtrVector::operator=", NM="_ZN4llvm13TinyPtrVectoraSEONS_13TinyPtrVectorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectoraSEONS_13TinyPtrVectorIT_EE")
  //</editor-fold>
  public TinyPtrVector<EltTy> /*&*/ $assignMove(TinyPtrVector<EltTy> /*&&*/RHS) {
    if (Native.$eq(this, $AddrOf(RHS))) {
      return Native.$star(this);
    }
    if (RHS.empty()) {
      this.clear();
      return Native.$star(this);
    }
    {
      
      // If this vector has been allocated on the heap, re-use it if cheap. If it
      // would require more copying, just delete it and we'll steal the other
      // side.
      SmallVector<EltTy> /*P*/ V = $getAsVector();
      if (V != null) {
        if (RHS.$isElement()) {
          V.clear();
          V.push_back(RHS.front());
          return Native.$star(this);
        }
        /*delete*/Destructors.$destroy(V);
      }
    }
    
    Val[0] = RHS.Val[0];
    $vector = RHS.$vector;
    RHS.Val[0] = null;
    RHS.$vector = false;
    return Native.$star(this);
  }

  
  /// Constructor from an ArrayRef.
  ///
  /// This also is a constructor for individual array elements due to the single
  /// element constructor for ArrayRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::TinyPtrVector<EltTy>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 106,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 103,
   FQN="llvm::TinyPtrVector::TinyPtrVector<EltTy>", NM="_ZN4llvm13TinyPtrVectorC1ENS_8ArrayRefIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorC1ENS_8ArrayRefIT_EE")
  //</editor-fold>
  public /*explicit*/ TinyPtrVector(ArrayRef<EltTy> Elts) {
    /* : Val(Elts.size() == 1 ? PtrUnion(Elts[0]) : PtrUnion(new VecTy(( Elts.begin(), Elts.end() ))))*/ 
    //START JInit
    if (Native.$eq(Elts.size(), 1)) {
      this.Val[0] = Elts.$at(0);
      this.$vector = false;
    } else {
      this.Val[0] = new SmallVector<EltTy>(4, Elts.begin(), Elts.end(), (EltTy) null);
      this.$vector = true;
    }
    //END JInit
  }

  
  // implicit conversion operator to ArrayRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::operator ArrayRef<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 111,
   FQN="llvm::TinyPtrVector::operator ArrayRef<type-parameter-0-0>", NM="_ZNK4llvm13TinyPtrVectorcvNS_8ArrayRefIT_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVectorcvNS_8ArrayRefIT_EEEv")
  //</editor-fold>
  public ArrayRef<EltTy> $ArrayRef() /*const*/ {
    if ($isNull()) {
      return ArrayRef.None();
    }
    if ($isElement()) {
      return new ArrayRef(Native.$star($getAsElement()), true);
    }
    return new ArrayRef(Native.$star($getAsVector()));
  }

  
  // implicit conversion operator to MutableArrayRef.
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::operator MutableArrayRef<type-parameter-0-0>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 120,
   FQN="llvm::TinyPtrVector::operator MutableArrayRef<type-parameter-0-0>", NM="_ZN4llvm13TinyPtrVectorcvNS_15MutableArrayRefIT_EEEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVectorcvNS_15MutableArrayRefIT_EEEv")
  //</editor-fold>
  public MutableArrayRef<EltTy> $MutableArrayRef$EltTy() {
    if ($isNull()) {
      return MutableArrayRef.None();
    }
    if ($isElement()) {
      return new MutableArrayRef(Native.$star($getAsElement()), true);
    }
    return new MutableArrayRef(Native.$star($getAsVector()));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::empty">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 115,
   FQN="llvm::TinyPtrVector::empty", NM="_ZNK4llvm13TinyPtrVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    // This vector can be empty if it contains no element, or if it
    // contains a pointer to an empty vector.
    if ($isNull()) {
      return true;
    }
    {
      SmallVector<EltTy> /*P*/ Vec = $getAsVector();
      if (Vec != null) {
        return Vec.empty();
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::size">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 137,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 124,
   FQN="llvm::TinyPtrVector::size", NM="_ZNK4llvm13TinyPtrVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVector4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    if (empty()) {
      return 0;
    }
    if ($isElement()) {
      return 1;
    }
    return $getAsVector().size();
  }

  
  /*typedef const EltTy *const_iterator*/
//  public final class const_iterator extends /*const*/ EltTy /*P*/ { };
  /*typedef EltTy *iterator*/
//  public final class iterator extends EltTy /*P*/ { };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 148,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 135,
   FQN="llvm::TinyPtrVector::begin", NM="_ZN4llvm13TinyPtrVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector5beginEv")
  //</editor-fold>
  public type$ptr<EltTy> begin() {
    if ($isElement()) {
      return create_type$ptr((EltTy[]) Val);
    }
    
    return $getAsVector().begin();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 142,
   FQN="llvm::TinyPtrVector::end", NM="_ZN4llvm13TinyPtrVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector3endEv")
  //</editor-fold>
  public type$ptr<EltTy> end() {
    if ($isElement()) {
      return Native.$add(begin(), $isNull() ? 0 : 1);
    }
    
    return $getAsVector().end();
  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::begin">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 161,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 149,
//   FQN="llvm::TinyPtrVector::begin", NM="_ZNK4llvm13TinyPtrVector5beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVector5beginEv")
//  //</editor-fold>
//  public const_iterator begin() /*const*/ {
//    return (const_iterator)((/*const_cast*/TinyPtrVector<EltTy> /*P*/ )(this)).begin();
//  }

  
  ////<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::end">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 165,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 153,
//   FQN="llvm::TinyPtrVector::end", NM="_ZNK4llvm13TinyPtrVector3endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVector3endEv")
//  //</editor-fold>
//  public const_iterator end() /*const*/ {
//    return (const_iterator)((/*const_cast*/TinyPtrVector<EltTy> /*P*/ )(this)).end();
//  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 169,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 157,
   FQN="llvm::TinyPtrVector::operator[]", NM="_ZNK4llvm13TinyPtrVectorixEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVectorixEj")
  //</editor-fold>
  public EltTy $at(/*uint*/int i) /*const*/ {
    assert (!$isNull()) : "can't index into an empty vector";
    {
      EltTy V = $getAsElement();
      if (V != null) {
        assert (i == 0) : "tinyvector index out of range";
        return V;
      }
    }
    assert (Native.$less(i, $getAsVector().size())) : "tinyvector index out of range";
    return Native.$star($getAsVector()).$at(i);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::front">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 181,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 169,
   FQN="llvm::TinyPtrVector::front", NM="_ZNK4llvm13TinyPtrVector5frontEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVector5frontEv")
  //</editor-fold>
  public EltTy front() /*const*/ {
    assert (!empty()) : "vector empty";
    {
      EltTy V = $getAsElement();
      if (V != null) {
        return V;
      }
    }
    return $getAsVector().front();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 176,
   FQN="llvm::TinyPtrVector::back", NM="_ZNK4llvm13TinyPtrVector4backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZNK4llvm13TinyPtrVector4backEv")
  //</editor-fold>
  public EltTy back() /*const*/ {
    assert (!empty()) : "vector empty";
    {
      EltTy V = $getAsElement();
      if (V != null) {
        return V;
      }
    }
    return $getAsVector().back();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::push_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 183,
   FQN="llvm::TinyPtrVector::push_back", NM="_ZN4llvm13TinyPtrVector9push_backET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector9push_backET_")
  //</editor-fold>
  public void push_back(EltTy NewVal) {
    assert (NewVal != null) : "Can't add a null value";
    
    // If we have nothing, add something.
    if ($isNull()) {
      Val[0] = NewVal;
      $vector = false;
      return;
    }
    {
      
      // If we have a single value, convert to a vector.
      EltTy V = $getAsElement();
      if (V != null) {
        Val[0] = new SmallVector<EltTy>(4, (EltTy) null);
        $vector = true;
        $getAsVector().push_back(V);
      }
    }
    
    // Add the new value, we know we have a vector.
    $getAsVector().push_back(NewVal);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::pop_back">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 202,
   FQN="llvm::TinyPtrVector::pop_back", NM="_ZN4llvm13TinyPtrVector8pop_backEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector8pop_backEv")
  //</editor-fold>
  public void pop_back() {
    // If we have a single value, convert to empty.
    if ($isElement()) {
      Val[0] = (EltTy)null;
    } else {
      SmallVector<EltTy> /*P*/ Vec = $getAsVector();
      if (Vec != null) {
        assert !Vec.empty() : "JAVA: why pop back from empty vector?";
        Vec.pop_back();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::clear">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 222,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 210,
   FQN="llvm::TinyPtrVector::clear", NM="_ZN4llvm13TinyPtrVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector5clearEv")
  //</editor-fold>
  public void clear() {
    // If we have a single value, convert to empty.
    if ($isElement()) {
      Val[0] = (EltTy)null;
    } else {
      SmallVector<EltTy> /*P*/ Vec = $getAsVector();
      if (Vec != null) {
        // If we have a vector form, just clear it.
        Vec.clear();
      }
    }
    // Otherwise, we're already empty.
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 233,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 221,
   FQN="llvm::TinyPtrVector::erase", NM="_ZN4llvm13TinyPtrVector5eraseEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector5eraseEPT_")
  //</editor-fold>
  public type$ptr<EltTy> erase(type$ptr<EltTy> I) {
    assert (Native.$greatereq(I, begin())) : "Iterator to erase is out of bounds.";
    assert (Native.$less(I, end())) : "Erasing at past-the-end iterator.";
    
    // If we have a single value, convert to empty.
    if ($isElement()) {
      if (Native.$eq_ptr(I, begin())) {
        Val[0] = (EltTy)null;
      }
    } else {
      SmallVector<EltTy> /*P*/ Vec = $getAsVector();
      if (Vec != null) {
        // multiple items in a vector; just do the erase, there is no
        // benefit to collapsing back to a pointer
        return Vec.erase(I);
      }
    }
    return end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 249,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 237,
   FQN="llvm::TinyPtrVector::erase", NM="_ZN4llvm13TinyPtrVector5eraseEPT_S2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector5eraseEPT_S2_")
  //</editor-fold>
  public type$ptr<EltTy> erase(type$ptr<EltTy> S, type$ptr<EltTy> E) {
    assert (Native.$greatereq_ptr(S, begin())) : "Range to erase is out of bounds.";
    assert (Native.$lesseq_ptr(S, E)) : "Trying to erase invalid range.";
    assert (Native.$lesseq_ptr(E, end())) : "Trying to erase past the end.";
    if ($isElement()) {
      if (Native.$eq_ptr(S, begin()) && Native.$noteq_ptr(S, E)) {
        Val[0] = (EltTy) null;
      }
    } else {
      SmallVector<EltTy> /*P*/ Vec = $getAsVector();
      if (Vec != null) {
        return Vec.erase(S, E);
      }
    }
    return end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 251,
   FQN="llvm::TinyPtrVector::insert", NM="_ZN4llvm13TinyPtrVector6insertEPT_RKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=_ZN4llvm13TinyPtrVector6insertEPT_RKS1_")
  //</editor-fold>
  public type$ptr<EltTy> insert(type$ptr<EltTy> I, /*const*/ EltTy /*&*/ Elt) {
    assert (Native.$greatereq(I, this.begin())) : "Insertion iterator is out of bounds.";
    assert (Native.$lesseq(I, this.end())) : "Inserting past the end of the vector.";
    if (Native.$eq_ptr(I, end())) {
      push_back(Elt);
      return std.prev(end());
    }
    assert (!$isNull()) : "Null value with non-end insert iterator.";
    {
      EltTy V = $getAsElement();
      if (V != null) {
        assert (Native.$eq_ptr(I, begin()));
        Val[0] = Elt;
        push_back(V);
        return begin();
      }
    }
    
    return $getAsVector().insert(I, Elt);
  }


  public type$ptr<EltTy> insert(type$ptr<EltTy> I, type$iterator<?, EltTy> From, type$iterator<?, EltTy> To) {
    return insert$T(I, From, To);
  }  
  /*template <typename ItTy> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::TinyPtrVector::insert">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", line = 282,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/TinyPtrVector.h", old_line = 269,
   FQN="llvm::TinyPtrVector::insert", NM="Tpl__ZN4llvm13TinyPtrVector6insertEPT_T_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Frontend/ModelInjector.cpp -nm=Tpl__ZN4llvm13TinyPtrVector6insertEPT_T_S3_")
  //</editor-fold>
  public /*<typename ItTy>*/ type$ptr<EltTy> insert$T(type$ptr<EltTy> I, type$iterator<?, EltTy> From, type$iterator<?, EltTy> To) {
    assert (Native.$greatereq_ptr(I, this.begin())) : "Insertion iterator is out of bounds.";
    assert (Native.$lesseq_ptr(I, this.end())) : "Inserting past the end of the vector.";
    if (Native.$eq_iter(From, To)) {
      return I;
    }
    
    // If we have a single value, convert to a vector.
    int Offset = I.$sub(begin());
    if ($isNull()) {
      if (Native.$eq_iter(std.next($tryClone(From)), To)) {
        Val[0] = Native.$star(From);
        return begin();
      }
      
      Val[0] = new SmallVector<EltTy>(4, (EltTy) null);
      $vector = true;
    } else {
      EltTy V = $getAsElement();
      if (V != null) {
        Val[0] = new SmallVector<EltTy>(4, (EltTy) null);
        $vector = true;
        $getAsVector().push_back(V);
      }
    }
    return $getAsVector().insert(Native.$add(begin(), Offset), From, To);
  }

  @Override
  public TinyPtrVector<EltTy> clone() {
    return new TinyPtrVector<>(this);
  }

  @Override
  public Iterator<EltTy> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  
  public String toString() {
    return "" + "Val=" + Val; // NOI18N
  }
}
