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
import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.java.Insertable;


/// \brief A templated base class for \c SmallPtrSet which provides the
/// typesafe interface that is common across all small sizes.
///
/// This is particularly useful for passing around between interface boundaries
/// to avoid encoding a particular small size in the interface boundary.
/*template <typename PtrType> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 243,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 241,
 FQN="llvm::SmallPtrSetImpl", NM="_ZN4llvm15SmallPtrSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImplE")
//</editor-fold>
public class SmallPtrSetImpl</*typename*/ PtrType>  extends /*public*/ SmallPtrSetImplBase<PtrType> 
        implements Destructors.ClassWithDestructor, Insertable<SmallPtrSetIterator<PtrType>, PtrType>, NativeIterable<type$iterator<?, PtrType>>, Iterable<PtrType> {
  /*typedef PointerLikeTypeTraits<PtrType> PtrTraits*/
//  public final class PtrTraits extends PointerLikeTypeTraits<PtrType>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 247,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 245,
   FQN="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>", NM="_ZN4llvm15SmallPtrSetImplC1ERKNS_15SmallPtrSetImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImplC1ERKNS_15SmallPtrSetImplIT_EE")
  //</editor-fold>
  private SmallPtrSetImpl(/*const*/ SmallPtrSetImpl<PtrType> /*&*/ $Prm0) { 
    super(create_type$ptr((PtrType[])new Object[0]), $Prm0);
    throw new UnsupportedOperationException("Deleted");
  }

/*protected:*/
  // Constructors that forward to the base.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 251,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 248,
   FQN="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>", NM="_ZN4llvm15SmallPtrSetImplC1EPPKvRKNS_15SmallPtrSetImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImplC1EPPKvRKNS_15SmallPtrSetImplIT_EE")
  //</editor-fold>
  protected SmallPtrSetImpl(/*const*/type$ptr<PtrType>/*void PP*/ SmallStorage, /*const*/ SmallPtrSetImpl<PtrType> /*&*/ that) {
    /* : SmallPtrSetImplBase(SmallStorage, that)*/ 
    //START JInit
    /*ParenListExpr*/super(SmallStorage, that);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 253,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 250,
   FQN="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>", NM="_ZN4llvm15SmallPtrSetImplC1EPPKvjONS_15SmallPtrSetImplIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImplC1EPPKvjONS_15SmallPtrSetImplIT_EE")
  //</editor-fold>
  protected SmallPtrSetImpl(/*const*/type$ptr<PtrType>/*void PP*/ SmallStorage, /*uint*/int SmallSize, 
      SmallPtrSetImpl<PtrType> /*&&*/that) {
    /* : SmallPtrSetImplBase(SmallStorage, SmallSize, std::move(that))*/ 
    //START JInit
    /*ParenListExpr*/super(SmallStorage, SmallSize, std.move(that));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 253,
   FQN="llvm::SmallPtrSetImpl::SmallPtrSetImpl<PtrType>", NM="_ZN4llvm15SmallPtrSetImplC1EPPKvj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImplC1EPPKvj")
  //</editor-fold>
  protected /*explicit*/ SmallPtrSetImpl(DenseMapInfo<PtrType> KeyInfo, /*const*/type$ptr<PtrType>/*void PP*/ SmallStorage, /*uint*/int SmallSize) {
    /* : SmallPtrSetImplBase(SmallStorage, SmallSize)*/ 
    //START JInit
    /*ParenListExpr*/super(KeyInfo, SmallStorage, SmallSize);
    //END JInit
  }

/*public:*/
  /*typedef SmallPtrSetIterator<PtrType> iterator*/
//  public final class iterator extends SmallPtrSetIterator<PtrType>{ };
  /*typedef SmallPtrSetIterator<PtrType> const_iterator*/
//  public final class const_iterator extends SmallPtrSetIterator<PtrType>{ };
  
  /// Inserts Ptr if and only if there is no element in the container equal to
  /// Ptr. The bool component of the returned pair is true if and only if the
  /// insertion takes place, and the iterator component of the pair points to
  /// the element equal to Ptr.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 267,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 264,
   FQN="llvm::SmallPtrSetImpl::insert", NM="_ZN4llvm15SmallPtrSetImpl6insertET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImpl6insertET_")
  //</editor-fold>
  public std.pairTypeBool<SmallPtrSetIterator<PtrType>> insert(PtrType Ptr) {
    pairTypeBool<type$ptr<PtrType>> p = insert_imp(Ptr);
    return std.make_pair_T_bool(new SmallPtrSetIterator(KeyInfo, p.first, CurArray.$add(CurArraySize)), p.second);
  }

  
  /// erase - If the set contains the specified pointer, remove it and return
  /// true, otherwise return false.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::erase">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 274,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 271,
   FQN="llvm::SmallPtrSetImpl::erase", NM="_ZN4llvm15SmallPtrSetImpl5eraseET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm15SmallPtrSetImpl5eraseET_")
  //</editor-fold>
  public boolean erase(PtrType Ptr) {
    return erase_imp(Ptr/*PointerLikeTypeTraits<PtrType>.getAsVoidPointer(Ptr)*/);
  }

  
  /// count - Return 1 if the specified pointer is in the set, 0 otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::count">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 279,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 276,
   FQN="llvm::SmallPtrSetImpl::count", NM="_ZNK4llvm15SmallPtrSetImpl5countET_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm15SmallPtrSetImpl5countET_")
  //</editor-fold>
  public /*uint*/int count(PtrType Ptr) /*const*/ {
    return count_imp(Ptr/*PointerLikeTypeTraits<PtrType>.getAsVoidPointer(Ptr)*/) ? 1 : 0;
  }

  
  /*template <typename IterT> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::insert">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 284,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 280,
   FQN="llvm::SmallPtrSetImpl::insert", NM="Tpl__ZN4llvm15SmallPtrSetImpl6insertET_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=Tpl__ZN4llvm15SmallPtrSetImpl6insertET_S1_")
  //</editor-fold>
  public </*typename*/ IterT extends type$iterator<?, ? extends PtrType>> void insert(IterT I, IterT E) {
    insert$T(I, E);
  }
  public </*typename*/ IterT extends type$iterator<?, ? extends PtrType>> void insert$T(IterT I, IterT E) {
    I = $tryClone(I);
    for (; I.$noteq(E); I.$preInc())  {
      insert($Deref(I.$star()));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 289,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 286,
   FQN="llvm::SmallPtrSetImpl::begin", NM="_ZNK4llvm15SmallPtrSetImpl5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm15SmallPtrSetImpl5beginEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<PtrType> begin() /*const*/ {
    return new SmallPtrSetIterator(KeyInfo, CurArray, CurArray.$add(CurArraySize));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetImpl::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 292,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 289,
   FQN="llvm::SmallPtrSetImpl::end", NM="_ZNK4llvm15SmallPtrSetImpl3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm15SmallPtrSetImpl3endEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<PtrType> end() /*const*/ {
    return new SmallPtrSetIterator(KeyInfo, CurArray.$add(CurArraySize), CurArray.$add(CurArraySize));
  }

  @Override
  public Iterator<PtrType> iterator() {
    return new JavaIterator<>(begin(), end());
  }

  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
