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
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 674,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 710,
 FQN="llvm::FoldingSetBucketIterator", NM="_ZN4llvm24FoldingSetBucketIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm24FoldingSetBucketIteratorE")
//</editor-fold>
public class FoldingSetBucketIterator</*class*/ T>  extends /*public*/ FoldingSetBucketIteratorImpl implements NativeCloneable<FoldingSetBucketIterator<T>> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator::FoldingSetBucketIterator<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 677,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 713,
   FQN="llvm::FoldingSetBucketIterator::FoldingSetBucketIterator<T>", NM="_ZN4llvm24FoldingSetBucketIteratorC1EPPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm24FoldingSetBucketIteratorC1EPPv")
  //</editor-fold>
  public /*explicit*/ FoldingSetBucketIterator(type$ptr<T>/*void PP*/ Bucket) {
    /* : FoldingSetBucketIteratorImpl(Bucket)*/ 
    //START JInit
    /*ParenListExpr*/super(Bucket);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator::FoldingSetBucketIterator<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 680,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 716,
   FQN="llvm::FoldingSetBucketIterator::FoldingSetBucketIterator<T>", NM="_ZN4llvm24FoldingSetBucketIteratorC1EPPvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm24FoldingSetBucketIteratorC1EPPvb")
  //</editor-fold>
  public FoldingSetBucketIterator(type$ptr<T>/*void PP*/ Bucket, boolean $Prm1) {
    /* : FoldingSetBucketIteratorImpl(Bucket, true)*/ 
    //START JInit
    /*ParenListExpr*/super(Bucket, true);
    //END JInit
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public FoldingSetBucketIterator(FoldingSetBucketIterator<T> other) {
    super(other);
  }  
  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator::operator*">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 683,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 719,
   FQN="llvm::FoldingSetBucketIterator::operator*", NM="_ZNK4llvm24FoldingSetBucketIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm24FoldingSetBucketIteratordeEv")
  //</editor-fold>
  public T /*&*/ $star() /*const*/ {
    if ($isPointer(Ptr)) {
      return ((type$ptr<T>) Ptr).$star();
    }
    return $Deref(((/*static_cast*/T /*P*/ )(Ptr)));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator::operator->">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 684,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 720,
   FQN="llvm::FoldingSetBucketIterator::operator->", NM="_ZNK4llvm24FoldingSetBucketIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm24FoldingSetBucketIteratorptEv")
  //</editor-fold>
  public T /*P*/ $arrow() /*const*/ {
    if ($isPointer(Ptr)) {
      return ((type$ptr<T>) Ptr).$star();
    }
    return ((/*static_cast*/T /*P*/ )(Ptr));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 686,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 722,
   FQN="llvm::FoldingSetBucketIterator::operator++", NM="_ZN4llvm24FoldingSetBucketIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm24FoldingSetBucketIteratorppEv")
  //</editor-fold>
  public /*inline*/ FoldingSetBucketIterator<T> /*&*/ $preInc() {
    // Preincrement
    advance();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 690,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 726,
   FQN="llvm::FoldingSetBucketIterator::operator++", NM="_ZN4llvm24FoldingSetBucketIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm24FoldingSetBucketIteratorppEi")
  //</editor-fold>
  public FoldingSetBucketIterator<T> $postInc(int $Prm0) {
    // Postincrement
    FoldingSetBucketIterator<T> tmp = /*Deref*/this;
    $Deref(this.$preInc());
    return tmp;
  }

  @Override
  public FoldingSetBucketIterator<T> clone() {
    return new FoldingSetBucketIterator<>(this);
  }
  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
