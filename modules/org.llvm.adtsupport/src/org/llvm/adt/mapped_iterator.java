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

import static org.clank.support.Native.$Deref;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.clank.support.NativeCallback.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
//     Extra additions to <iterator>
//===----------------------------------------------------------------------===//

// mapped_iterator - This is a simple iterator adapter that causes a function to
// be dereferenced whenever operator* is invoked on the iterator.
//
/*template <class RootIt, class UnaryFunc> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 121,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 111,
 FQN="llvm::mapped_iterator", NM="_ZN4llvm15mapped_iteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratorE")
//</editor-fold>
public class mapped_iterator<FromType, /*class*/ value_type>  implements type$iterator<mapped_iterator<FromType, value_type>, value_type> {
  private type$iterator<?, FromType> current;
  private final Converter<FromType, value_type> Fn;
/*public:*/
  /*typedef typename std::iterator_traits<RootIt>::iterator_category iterator_category*/
//  public final class iterator_category extends  std.iterator_traits.<RootIt>iterator_category{ };
  /*typedef typename std::iterator_traits<RootIt>::difference_type difference_type*/
//  public final class difference_type extends  std.iterator_traits.<RootIt>difference_type{ };
  /*typedef typename std::result_of<UnaryFunc (decltype(*std::declval<RootIt>()))>::type value_type*/
//  public final class value_type extends  std.result_of.<value_type>type{ };
  
  /*typedef void pointer*/;
  //typedef typename UnaryFunc::result_type *pointer;
  /*typedef void reference*/; // Can't modify value returned by fn
  
  /*typedef RootIt iterator_type*/
//  public final class iterator_type extends RootIt{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::getCurrent">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 140,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 128,
   FQN="llvm::mapped_iterator::getCurrent", NM="_ZNK4llvm15mapped_iterator10getCurrentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iterator10getCurrentEv")
  //</editor-fold>
  public /*inline*/ /*const*/type$iterator<?, FromType> /*&*/ getCurrent() /*const*/ {
    return current;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::getFunc">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 129,
   FQN="llvm::mapped_iterator::getFunc", NM="_ZNK4llvm15mapped_iterator7getFuncEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iterator7getFuncEv")
  //</editor-fold>
  public /*inline*/ /*const*/Converter<FromType, value_type> /*&*/ getFunc() /*const*/ {
    return Fn;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::mapped_iterator<RootIt, UnaryFunc>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 143,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 131,
   FQN="llvm::mapped_iterator::mapped_iterator<RootIt, UnaryFunc>", NM="_ZN4llvm15mapped_iteratorC1ERKT_T0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratorC1ERKT_T0_")
  //</editor-fold>
  public /*inline*/ /*explicit*/ mapped_iterator(final /*const*/type$iterator<?, FromType> /*&*/ I, Converter<FromType, value_type> F) {
    // : current(I), Fn(F) 
    //START JInit
    this.current = $tryClone(I);
    this.Fn= F;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 146,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 134,
   FQN="llvm::mapped_iterator::operator*", NM="_ZNK4llvm15mapped_iteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratordeEv")
  //</editor-fold>
  public /*inline*/ value_type $star() /*const*/ {
    // All this work to do this
    return Fn.$call($Deref(current.$star())); // little change
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 138,
   FQN="llvm::mapped_iterator::operator++", NM="_ZN4llvm15mapped_iteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratorppEv")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> /*&*/ $preInc() {
    current.$preInc();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 154,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 142,
   FQN="llvm::mapped_iterator::operator--", NM="_ZN4llvm15mapped_iteratormmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratormmEv")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> /*&*/ $preDec() {
    current.$preDec();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 146,
   FQN="llvm::mapped_iterator::operator++", NM="_ZN4llvm15mapped_iteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratorppEi")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> $postInc(int $Prm0) {
    mapped_iterator<FromType, /*class*/ value_type> __tmp = $tryClone(/*Deref*/this);
    current.$preInc();
    return __tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 151,
   FQN="llvm::mapped_iterator::operator--", NM="_ZN4llvm15mapped_iteratormmEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratormmEi")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> $postDec(int $Prm0) {
    mapped_iterator<FromType, /*class*/ value_type> __tmp = $tryClone(/*Deref*/this);
    current.$preDec();
    return __tmp;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator+">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 168,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 156,
   FQN="llvm::mapped_iterator::operator+", NM="_ZNK4llvm15mapped_iteratorplENSt15iterator_traitsIT_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratorplENSt15iterator_traitsIT_E15difference_typeE")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> $add(int n) /*const*/ {
    return new mapped_iterator<>(current.$add(n), this.Fn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator+=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 159,
   FQN="llvm::mapped_iterator::operator+=", NM="_ZN4llvm15mapped_iteratorpLENSt15iterator_traitsIT_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratorpLENSt15iterator_traitsIT_E15difference_typeE")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> /*&*/ $addassign(int n) {
    current.$inc(n);
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator-">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 163,
   FQN="llvm::mapped_iterator::operator-", NM="_ZNK4llvm15mapped_iteratormiENSt15iterator_traitsIT_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratormiENSt15iterator_traitsIT_E15difference_typeE")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> $sub(int n) /*const*/ {
    return new mapped_iterator<>(current.$sub(n), this.Fn);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator-=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 178,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 166,
   FQN="llvm::mapped_iterator::operator-=", NM="_ZN4llvm15mapped_iteratormIENSt15iterator_traitsIT_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZN4llvm15mapped_iteratormIENSt15iterator_traitsIT_E15difference_typeE")
  //</editor-fold>
  public mapped_iterator<FromType, /*class*/ value_type> /*&*/ $minusassign(int n) {
    current.$dec(n);
    return this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator[]">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 170,
   FQN="llvm::mapped_iterator::operator[]", NM="_ZNK4llvm15mapped_iteratorixENSt15iterator_traitsIT_E15difference_typeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratorixENSt15iterator_traitsIT_E15difference_typeE")
  //</editor-fold>
  public value_type $at(int n) /*const*/ {
    return new mapped_iterator<FromType, /*class*/ value_type>(current.$add(n), this.Fn).$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 184,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 172,
   FQN="llvm::mapped_iterator::operator!=", NM="_ZNK4llvm15mapped_iteratorneERKNS_15mapped_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratorneERKNS_15mapped_iteratorIT_T0_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ mapped_iterator<FromType, /*class*/ value_type> /*&*/ X) /*const*/ {
    return !$eq(X);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 185,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 173,
   FQN="llvm::mapped_iterator::operator==", NM="_ZNK4llvm15mapped_iteratoreqERKNS_15mapped_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratoreqERKNS_15mapped_iteratorIT_T0_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ mapped_iterator<FromType, /*class*/ value_type> /*&*/ X) /*const*/ {
    return Native.$eq_iter(current, X.current);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator<">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 176,
   FQN="llvm::mapped_iterator::operator<", NM="_ZNK4llvm15mapped_iteratorltERKNS_15mapped_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratorltERKNS_15mapped_iteratorIT_T0_EE")
  //</editor-fold>
  public boolean $less(final /*const*/ mapped_iterator<FromType, /*class*/ value_type> /*&*/ X) /*const*/ {
    return $sub(X) < 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::mapped_iterator::operator-">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", line = 190,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/STLExtras.h", old_line = 178,
   FQN="llvm::mapped_iterator::operator-", NM="_ZNK4llvm15mapped_iteratormiERKNS_15mapped_iteratorIT_T0_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGExpr.cpp -nm=_ZNK4llvm15mapped_iteratormiERKNS_15mapped_iteratorIT_T0_EE")
  //</editor-fold>
  public int $sub(final /*const*/ mapped_iterator<FromType, /*class*/ value_type> /*&*/ X) /*const*/ {
    return ((abstract_iterator)current).$sub((abstract_iterator)X.current);
  }

  @Override public mapped_iterator<FromType, value_type> clone() { return new mapped_iterator<>(this.current, this.Fn); }

  @Override public boolean $eq(Object other) { return this.$eq((mapped_iterator<FromType, /*class*/ value_type>)other); }
  
  @Override public String toString() {
    return "" + "current=" + current // NOI18N
              + ", Fn=" + Fn; // NOI18N
  }  
}
