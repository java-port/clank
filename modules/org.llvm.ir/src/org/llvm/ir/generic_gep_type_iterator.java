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

package org.llvm.ir;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import org.clank.support.aliases.type$iterator;
import static org.llvm.support.llvm.*;
import org.llvm.adt.*;

/*template <typename ItTy = User::const_op_iterator> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 24,
 FQN="llvm::generic_gep_type_iterator", NM="_ZN4llvm25generic_gep_type_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm25generic_gep_type_iteratorE")
//</editor-fold>
public class generic_gep_type_iterator</*typename*/ T/* = User::const_op_iterator*/>  implements /*public*/ std.iterator<std.forward_iterator_tag, Type /*P , int*/>, Native.NativeComparable, type$iterator<generic_gep_type_iterator, Type> {
  // JAVA: typedef std::iterator<std::forward_iterator_tag, Type *, ptrdiff_t> super
//  public final class super extends std.iterator<std.forward_iterator_tag, Type /*P*/ , int>{ };
  
  private type$iterator<?, T> OpIt;
  private PointerIntPair<Type /*P*/ > CurTy;
  private /*uint*/int AddrSpace;
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::generic_gep_type_iterator<ItTy>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 33,
   FQN="llvm::generic_gep_type_iterator::generic_gep_type_iterator<ItTy>", NM="_ZN4llvm25generic_gep_type_iteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm25generic_gep_type_iteratorC1Ev")
  //</editor-fold>
  private generic_gep_type_iterator() {
  }

/*public:*/
  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 36,
   FQN="llvm::generic_gep_type_iterator::begin", NM="_ZN4llvm25generic_gep_type_iterator5beginEPNS_4TypeEjT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm25generic_gep_type_iterator5beginEPNS_4TypeEjT_")
  //</editor-fold>
  public static </*typename*/ T/* = User::const_op_iterator*/> generic_gep_type_iterator<T> begin(Type /*P*/ Ty, /*uint*/int AddrSpace, 
       type$iterator<?, T> It) {
    generic_gep_type_iterator<T> I = new generic_gep_type_iterator<T>();
    I.CurTy.setPointer(Ty);
    I.CurTy.setInt(true);
    I.AddrSpace = AddrSpace;
    I.OpIt = $Clone(It);
    return I;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::end">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 45,
   FQN="llvm::generic_gep_type_iterator::end", NM="_ZN4llvm25generic_gep_type_iterator3endET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm25generic_gep_type_iterator3endET_")
  //</editor-fold>
  public static </*typename*/ T/* = User::const_op_iterator*/> generic_gep_type_iterator<T> end(type$iterator<?, T> It) {
    generic_gep_type_iterator<T> I = new generic_gep_type_iterator<T>();
    I.OpIt = $Clone(It);
    return I;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 51,
   FQN="llvm::generic_gep_type_iterator::operator==", NM="_ZNK4llvm25generic_gep_type_iteratoreqERKNS_25generic_gep_type_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZNK4llvm25generic_gep_type_iteratoreqERKNS_25generic_gep_type_iteratorIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ generic_gep_type_iterator<T> /*&*/ x) /*const*/ {
    return Native.$eq(OpIt, x.OpIt);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 54,
   FQN="llvm::generic_gep_type_iterator::operator!=", NM="_ZNK4llvm25generic_gep_type_iteratorneERKNS_25generic_gep_type_iteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZNK4llvm25generic_gep_type_iteratorneERKNS_25generic_gep_type_iteratorIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ generic_gep_type_iterator<T> /*&*/ x) /*const*/ {
    return Native.$not($eq(x));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 58,
   FQN="llvm::generic_gep_type_iterator::operator*", NM="_ZNK4llvm25generic_gep_type_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZNK4llvm25generic_gep_type_iteratordeEv")
  //</editor-fold>
  public Type /*P*/ $star() /*const*/ {
    if (CurTy.getInt() != 0) {
      return CurTy.getPointer().getPointerTo(AddrSpace);
    }
    return CurTy.getPointer();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::getIndexedType">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 64,
   FQN="llvm::generic_gep_type_iterator::getIndexedType", NM="_ZNK4llvm25generic_gep_type_iterator14getIndexedTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZNK4llvm25generic_gep_type_iterator14getIndexedTypeEv")
  //</editor-fold>
  public Type /*P*/ getIndexedType() /*const*/ {
    if (CurTy.getInt() != 0) {
      return CurTy.getPointer();
    }
    CompositeType /*P*/ CT = cast(CompositeType.class, CurTy.getPointer());
    return CT.getTypeAtIndex(getOperand());
  }

  
  // This is a non-standard operator->.  It allows you to call methods on the
  // current type directly.
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 73,
   FQN="llvm::generic_gep_type_iterator::operator->", NM="_ZNK4llvm25generic_gep_type_iteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZNK4llvm25generic_gep_type_iteratorptEv")
  //</editor-fold>
  public Type /*P*/ $arrow() /*const*/ {
    return $star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::getOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 75,
   FQN="llvm::generic_gep_type_iterator::getOperand", NM="_ZNK4llvm25generic_gep_type_iterator10getOperandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZNK4llvm25generic_gep_type_iterator10getOperandEv")
  //</editor-fold>
  public Value /*P*/ getOperand() /*const*/ {
    return ((/*const_cast*/Value /*P*/ )($AddrOf($Deref($Deref(OpIt)))));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 77,
   FQN="llvm::generic_gep_type_iterator::operator++", NM="_ZN4llvm25generic_gep_type_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm25generic_gep_type_iteratorppEv")
  //</editor-fold>
  public generic_gep_type_iterator<T> /*&*/ $preInc() {
    // Preincrement
    if (CurTy.getInt() != 0) {
      CurTy.setInt(false);
    } else {
      CompositeType /*P*/ CT = dyn_cast(CompositeType.class, CurTy.getPointer());
      if ((CT != null)) {
        CurTy.setPointer(CT.getTypeAtIndex(getOperand()));
      } else {
        CurTy.setPointer(null);
      }
    }
    OpIt.$preInc();
    return /*Deref*/this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::generic_gep_type_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 90,
   FQN="llvm::generic_gep_type_iterator::operator++", NM="_ZN4llvm25generic_gep_type_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm25generic_gep_type_iteratorppEi")
  //</editor-fold>
  public generic_gep_type_iterator<T> $postInc(int $Prm0) {
    // Postincrement
    generic_gep_type_iterator<T> tmp = /*Deref*/$Clone(this);
    /*++ Deref*/this.$preInc();
    return tmp;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  public generic_gep_type_iterator(generic_gep_type_iterator<T> other) {
    this.OpIt = $Clone(other.OpIt);
    this.CurTy = $Clone(other.CurTy);
    this.AddrSpace = other.AddrSpace;
  }

  @Override
  public generic_gep_type_iterator<T> clone() {
    return new generic_gep_type_iterator<>(this);
  }
  

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "OpIt=" + OpIt // NOI18N
              + ", CurTy=" + CurTy // NOI18N
              + ", AddrSpace=" + AddrSpace // NOI18N
              + super.toString(); // NOI18N
  }
}
