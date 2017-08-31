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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;

/*template <typename PtrTy> TEMPLATE*/

/// SmallPtrSetIterator - This implements a const_iterator for SmallPtrSet.
//<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIterator">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 181,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 178,
 FQN = "llvm::SmallPtrSetIterator", NM = "_ZN4llvm19SmallPtrSetIteratorE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetIteratorE")
//</editor-fold>
public class SmallPtrSetIterator</*typename*/ PtrTy>  extends /*public*/ SmallPtrSetIteratorImpl implements type$iterator<SmallPtrSetIterator, PtrTy>, assignable<SmallPtrSetIterator>, NativeCloneable<SmallPtrSetIterator> {
  /*typedef PointerLikeTypeTraits<PtrTy> PtrTraits*/
//  public final class PtrTraits extends PointerLikeTypeTraits<PtrTy>{ };
/*public:*/
  /*typedef PtrTy value_type*/
//  public final class value_type extends PtrTy{ };
  /*typedef PtrTy reference*/
//  public final class reference extends PtrTy{ };
  /*typedef PtrTy pointer*/
//  public final class pointer extends PtrTy{ };
  /*typedef std::ptrdiff_t difference_type*/;
  /*typedef std::forward_iterator_tag iterator_category*/
  public final class iterator_category extends std.forward_iterator_tag{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIterator::SmallPtrSetIterator<PtrTy>">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 189,
   FQN = "llvm::SmallPtrSetIterator::SmallPtrSetIterator<PtrTy>", NM = "_ZN4llvm19SmallPtrSetIteratorC1EPKPKvS4_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetIteratorC1EPKPKvS4_")
  //</editor-fold>
  public /*explicit*/ SmallPtrSetIterator(DenseMapInfo KeyInfo, /*const*/type$ptr<Object>/*void P const P*/ BP, /*const*/type$ptr<Object>/*void P const P*/ E) {
    /* : SmallPtrSetIteratorImpl(BP, E)*/ 
    //START JInit
    super(KeyInfo, BP, E);
    //END JInit
  }

  
  // Most methods provided by baseclass.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 194,
   FQN = "llvm::SmallPtrSetIterator::operator*", NM = "_ZNK4llvm19SmallPtrSetIteratordeEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm19SmallPtrSetIteratordeEv")
  //</editor-fold>
  public /*const*/PtrTy $star() /*const*/ {
    //((Bucket.$less(End)) ? (/*static_cast*/void)(0) : __assert_fail("Bucket < End", ${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", 190, __PRETTY_FUNCTION__));
    return (PtrTy)(Bucket.$star());
  }

  // Preincrement
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 202,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 199,
   FQN = "llvm::SmallPtrSetIterator::operator++", NM = "_ZN4llvm19SmallPtrSetIteratorppEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetIteratorppEv")
  //</editor-fold>
  public /*inline*/ SmallPtrSetIterator<PtrTy> /*&*/ $preInc() {
    Bucket.$preInc();
    AdvanceIfNotValid();
    return this;
  }

  // Postincrement
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 208,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 205,
   FQN = "llvm::SmallPtrSetIterator::operator++", NM = "_ZN4llvm19SmallPtrSetIteratorppEi",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm19SmallPtrSetIteratorppEi")
  //</editor-fold>
  public SmallPtrSetIterator<PtrTy> $postInc() {
    SmallPtrSetIterator<PtrTy> tmp = this./*Deref*/clone();
    $preInc();
    return tmp;
  }

  @Override
  public SmallPtrSetIterator clone() {
    return new SmallPtrSetIterator(KeyInfo, Bucket, End);
  }

  @Override
  public SmallPtrSetIterator const_clone() {
    // TODO: pass constness
    return new SmallPtrSetIterator(KeyInfo, Bucket, End);
  }

  @Override
  public type$ref<PtrTy> star$ref() {
    return new type$ref<PtrTy>() {
        
        type$ptr<PtrTy> localPtr = (type$ptr<PtrTy>) Bucket.clone();

        @Override
        public PtrTy $deref() {
            return localPtr.$star();
        }

        @Override
        public PtrTy $set(PtrTy value) {
            return localPtr.$set(value);
        }

        @Override
        public type$ptr<PtrTy> deref$ptr() {
            return localPtr;
        }
    };
  }
  
  @Override
  public SmallPtrSetIterator $assign(SmallPtrSetIterator value) {
    this.KeyInfo = value.KeyInfo;
    this.Bucket = $tryClone(value.Bucket);
    this.End = $tryClone(value.End);
    return this;
  }

  @Override
  public boolean $noteq(Object other) {
    if (other instanceof SmallPtrSetIterator) {
      return $noteq((SmallPtrSetIterator) other);
    }
    return true;
  }

  @Override
  public boolean $eq(Object other) {
    if (other instanceof SmallPtrSetIterator) {
      return $eq((SmallPtrSetIterator) other);
    }
    return false;
  }

  @Override
  public int $sub(SmallPtrSetIterator iter) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SmallPtrSetIterator $preDec() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SmallPtrSetIterator $postDec() {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SmallPtrSetIterator $inc(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SmallPtrSetIterator $dec(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SmallPtrSetIterator $add(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  @Override
  public SmallPtrSetIterator $sub(int amount) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }
}
