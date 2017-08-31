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

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


/// \brief CRTP base class for adapting an iterator to a different type.
///
/// This class can be used through CRTP to adapt one iterator into another.
/// Typically this is done through providing in the derived class a custom \c
/// operator* implementation. Other methods can be overridden as well.
/*template <typename DerivedT, typename WrappedIteratorT, typename IteratorCategoryT = typename std::iterator_traits<WrappedIteratorT>::iterator_category, typename T = typename std::iterator_traits<WrappedIteratorT>::value_type, typename DifferenceTypeT = typename std::iterator_traits<WrappedIteratorT>::difference_type, typename PointerT = T *, typename ReferenceT = T &, typename WrappedTraitsT = std::iterator_traits<WrappedIteratorT>> TEMPLATE*/
// Don't provide these, they are mostly to act as aliases below.
//<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 135,
 FQN="llvm::iterator_adaptor_base", NM="_ZN4llvm21iterator_adaptor_baseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm21iterator_adaptor_baseE")
//</editor-fold>
public abstract class iterator_adaptor$UInt_base</*typename*/ DerivedT extends iterator_adaptor$UInt_base/*, int*/, /*typename*/ IteratorCategoryT, /*typename*/ T>  extends /*public*/ iterator_facade_base<DerivedT, IteratorCategoryT, T, T> {
  /*typedef typename iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>::iterator_facade_base BaseT*/
//  public final class BaseT extends  iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>.iterator_facade_base{ };
/*protected:*/
  public final uint$ref I;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 153,
   FQN="llvm::iterator_adaptor_base::iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>", NM="_ZN4llvm21iterator_adaptor_baseC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm21iterator_adaptor_baseC1Ev")
  //</editor-fold>
  protected iterator_adaptor$UInt_base()/* = default*/ {
    I = new uint$ptr$single();
  }

  protected iterator_adaptor$UInt_base(final int Position)/* = default*/ {
    I = new uint$ptr$single(Position);
  }


  /*template <typename U> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 156,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 155,
   FQN="llvm::iterator_adaptor_base::iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>", NM="Tpl__ZN4llvm21iterator_adaptor_baseC1EOT_NSt9enable_ifIXntsr3std10is_base_ofINSt9remove_cvINSt16remove_referenceIS1_E4typeEE4typeET_EE5valueEiE4typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=Tpl__ZN4llvm21iterator_adaptor_baseC1EOT_NSt9enable_ifIXntsr3std10is_base_ofINSt9remove_cvINSt16remove_referenceIS1_E4typeEE4typeET_EE5valueEiE4typeE")
  //</editor-fold>
  protected /*explicit*/ </*typename*/ U> iterator_adaptor$UInt_base(JD$NotBaseOfRemoveCVRef _dparam, int /*&&*/Position) {
    I = new uint$ptr$single(Position);
  }
  
  @Converted(kind = Converted.Kind.MANUAL_NO_BODY)
  protected /*explicit*/ iterator_adaptor$UInt_base(JD$Move _dparam, DerivedT /*&&*/u) {
    /* : I(std::forward<U &&>(u))*/ 
    this.I = u.I;
  }

  @Converted(kind = Converted.Kind.MANUAL_NO_BODY)
  protected /*explicit*/ iterator_adaptor$UInt_base(JD$NotBaseOfRemoveCVRef _dparam, uint$ref /*&&*/u) {
    this.I = $tryClone(u);
  }

  protected /*explicit*/ iterator_adaptor$UInt_base(DerivedT /*&*/u) {
    this.I = $tryClone(u.I);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::wrapped">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 165,
   FQN="llvm::iterator_adaptor_base::wrapped", NM="_ZNK4llvm21iterator_adaptor_base7wrappedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm21iterator_adaptor_base7wrappedEv")
  //</editor-fold>
  protected /*const*/ uint$ref /*&*/ wrapped() /*const*/ {
    return I;
  }

/*public:*/
  /*typedef DifferenceTypeT difference_type*/
//  public final class difference_type extends DifferenceTypeT{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator+=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 170,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 168,
   FQN="llvm::iterator_adaptor_base::operator+=", NM="_ZN4llvm21iterator_adaptor_basepLET3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm21iterator_adaptor_basepLET3_")
  //</editor-fold>
  public DerivedT /*&*/ $addassign(int n) {
    this.I.$set$addassign(n);
    return (DerivedT)this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator-=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 177,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 175,
   FQN="llvm::iterator_adaptor_base::operator-=", NM="_ZN4llvm21iterator_adaptor_basemIET3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm21iterator_adaptor_basemIET3_")
  //</editor-fold>
  public DerivedT /*&*/ $minusassign(int n) {
    this.I.$set$minusassign(n);
    return (DerivedT)this;
  }

  //JAVA: using  iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>.iterator_facade_base::operator-;
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator-">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 183,
   FQN="llvm::iterator_adaptor_base::operator-", NM="_ZNK4llvm21iterator_adaptor_basemiERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm21iterator_adaptor_basemiERKT_")
  //</editor-fold>
  public int $sub(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
    return this.I.$deref() - RHS.I.$deref();
  }
  
  // We have to explicitly provide ++ and -- rather than letting the facade
  // forward to += because WrappedIteratorT might not support +=.
  //JAVA: using  iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>.iterator_facade_base::operator++;
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 193,
   FQN="llvm::iterator_adaptor_base::operator++", NM="_ZN4llvm21iterator_adaptor_baseppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm21iterator_adaptor_baseppEv")
  //</editor-fold>
  public DerivedT /*&*/ $preInc() {
      I.$set$preInc();
      return (DerivedT)/*Deref*/this;
  }

  //JAVA: using  iterator_adaptor_base<DerivedT, WrappedIteratorT, IteratorCategoryT, T, DifferenceTypeT, PointerT, ReferenceT, WrappedTraitsT>.iterator_facade_base::operator--;
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator--">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 200,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 198,
   FQN="llvm::iterator_adaptor_base::operator--", NM="_ZN4llvm21iterator_adaptor_basemmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZN4llvm21iterator_adaptor_basemmEv")
  //</editor-fold>
  public DerivedT /*&*/ $preDec() {
      I.$set$preDec();
      return (DerivedT)/*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::operator++">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 428,
   FQN = "clang::PreprocessingRecord::iterator::operator++", NM = "_ZN5clang19PreprocessingRecord8iteratorppEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -filter=clang::PreprocessingRecord::iterator::operator++")
  //</editor-fold>
  public DerivedT $postInc(int $Prm0) {
    DerivedT Prev/*J*/= clone();
    I.$set$preInc();
    return Prev;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::PreprocessingRecord::iterator::operator--">
  @Converted(kind = Converted.Kind.DELETED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Lex/PreprocessingRecord.h", line = 439,
   FQN = "clang::PreprocessingRecord::iterator::operator--", NM = "_ZN5clang19PreprocessingRecord8iteratormmEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.clang.lex/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Lex/PreprocessingRecord.cpp -filter=clang::PreprocessingRecord::iterator::operator--")
  //</editor-fold>
  public DerivedT $postDec(int $Prm0) {
    DerivedT Prev/*J*/= clone();
    I.$set$preDec();
    return Prev;
  }
    
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 206,
   FQN="llvm::iterator_adaptor_base::operator==", NM="_ZNK4llvm21iterator_adaptor_baseeqERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm21iterator_adaptor_baseeqERKT_")
  //</editor-fold>
  public boolean $eq(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
    return this.I.$deref() == RHS.I.$deref();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 209,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 207,
   FQN="llvm::iterator_adaptor_base::operator<", NM="_ZNK4llvm21iterator_adaptor_baseltERKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm21iterator_adaptor_baseltERKT_")
  //</editor-fold>
  public boolean $less(/*const*/ DerivedT /*&*/ RHS) /*const*/ {
    return Unsigned.$less_uint(this.I.$deref(), RHS.I.$deref());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::iterator_adaptor_base::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", line = 216,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/iterator.h", old_line = 214,
   FQN="llvm::iterator_adaptor_base::operator*", NM="_ZNK4llvm21iterator_adaptor_basedeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/Sema.cpp -nm=_ZNK4llvm21iterator_adaptor_basedeEv")
  //</editor-fold>
  public abstract T $star() /*const*/;

  @Override public abstract DerivedT clone(); 
  
  @Override
  public boolean $eq(Object RHS) {
    return this.I.$deref() == ((iterator_adaptor$UInt_base)RHS).I.$deref();
  }
  
  public String toString() {
    return "" + "I=" + I // NOI18N
              + super.toString(); // NOI18N
  }
}
