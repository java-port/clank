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
import org.llvm.adt.*;

/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 624,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 658,
 FQN="llvm::FoldingSetIterator", NM="_ZN4llvm18FoldingSetIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm18FoldingSetIteratorE")
//</editor-fold>
public class FoldingSetIterator</*class*/ T>  extends /*public*/ FoldingSetIteratorImpl implements type$iterator<FoldingSetIterator</*class*/ T>, T> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIterator::FoldingSetIterator<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 626,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 661,
   FQN="llvm::FoldingSetIterator::FoldingSetIterator<T>", NM="_ZN4llvm18FoldingSetIteratorC1EPPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm18FoldingSetIteratorC1EPPv")
  //</editor-fold>
  public /*explicit*/ FoldingSetIterator(type$ptr<T>/*void PP*/ Bucket) {
    /* : FoldingSetIteratorImpl(Bucket)*/ 
    //START JInit
    /*ParenListExpr*/super(Bucket);
    //END JInit
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public FoldingSetIterator(FoldingSetIterator<T> other) {
    super(other);
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 628,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 663,
   FQN="llvm::FoldingSetIterator::operator*", NM="_ZNK4llvm18FoldingSetIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm18FoldingSetIteratordeEv")
  //</editor-fold>
  public T /*&*/ $star() /*const*/ {
    return $Deref(((/*static_cast*/T /*P*/ )(NodePtr)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 632,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 667,
   FQN="llvm::FoldingSetIterator::operator->", NM="_ZNK4llvm18FoldingSetIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm18FoldingSetIteratorptEv")
  //</editor-fold>
  public T /*P*/ $arrow() /*const*/ {
    return ((/*static_cast*/T /*P*/ )(NodePtr));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 636,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 671,
   FQN="llvm::FoldingSetIterator::operator++", NM="_ZN4llvm18FoldingSetIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm18FoldingSetIteratorppEv")
  //</editor-fold>
  public /*inline*/ FoldingSetIterator<T> /*&*/ $preInc() {
    // Preincrement
    advance();
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 640,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 675,
   FQN="llvm::FoldingSetIterator::operator++", NM="_ZN4llvm18FoldingSetIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm18FoldingSetIteratorppEi")
  //</editor-fold>
  public FoldingSetIterator<T> $postInc(int $Prm0) {
    // Postincrement
    FoldingSetIterator<T> tmp = $tryClone(/*Deref*/this);
    $Deref(this.$preInc());
    return tmp;
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public FoldingSetIterator<T> $postInc() {
    return $postInc(0);
  }
  
  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public type$ref<T> star$ref() {
    return new type$ref<T>() {
      
      FoldingSetImpl.Node localPtr = NodePtr;
      
      @Override
      public T $deref() {
        return (T) localPtr;
      }

      @Override
      public T $set(T value) {
        if (localPtr instanceof assignable) {
          return Native.$tryAssign((T) localPtr, value, false);
        }
        throw new UnsupportedOperationException("Cannot replace value in the bucket from iterator!");
      }
    };
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public FoldingSetIterator<T> const_clone() {
    return clone();
  }  

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public FoldingSetIterator<T> clone() {
    return new FoldingSetIterator<>(this);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public boolean $noteq(Object other) {
    return super.$noteq((FoldingSetIteratorImpl) other);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public boolean $eq(Object other) {
    return super.$eq((FoldingSetIteratorImpl) other);
  }
  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
