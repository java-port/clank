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
import static org.clank.support.Casts.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import static org.llvm.support.impl.FoldingSetStatics.*;


//===----------------------------------------------------------------------===//
/// FoldingSetBucketIteratorImpl - This is the common bucket iterator support
/// shared by all folding sets, which knows how to walk a particular bucket
/// of a folding set hash table.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIteratorImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 650,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 685,
 FQN="llvm::FoldingSetBucketIteratorImpl", NM="_ZN4llvm28FoldingSetBucketIteratorImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm28FoldingSetBucketIteratorImplE")
//</editor-fold>
public class FoldingSetBucketIteratorImpl implements Native.NativeComparable<FoldingSetBucketIteratorImpl> {
/*protected:*/
  protected Object/*void P*/ Ptr;
  
  
  //===----------------------------------------------------------------------===//
  // FoldingSetBucketIteratorImpl Implementation
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIteratorImpl::FoldingSetBucketIteratorImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 445,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 422,
   FQN="llvm::FoldingSetBucketIteratorImpl::FoldingSetBucketIteratorImpl", NM="_ZN4llvm28FoldingSetBucketIteratorImplC1EPPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm28FoldingSetBucketIteratorImplC1EPPv")
  //</editor-fold>
  protected FoldingSetBucketIteratorImpl(type$ptr<?>/*void PP*/ Bucket) {
    Ptr = (!(Bucket.$star() != null) || !(GetNextPtr(Bucket.$star()) != null)) 
            ? reinterpret_cast(Object/*void P*/ .class, Bucket) 
            : Bucket.$star();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIteratorImpl::FoldingSetBucketIteratorImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 656,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 691,
   FQN="llvm::FoldingSetBucketIteratorImpl::FoldingSetBucketIteratorImpl", NM="_ZN4llvm28FoldingSetBucketIteratorImplC1EPPvb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm28FoldingSetBucketIteratorImplC1EPPvb")
  //</editor-fold>
  protected FoldingSetBucketIteratorImpl(type$ptr<?>/*void PP*/ Bucket, boolean $Prm1) {
    /* : Ptr(Bucket)*/ 
    //START JInit
    this.Ptr = $tryClone(Bucket);
    //END JInit
  }

  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  protected FoldingSetBucketIteratorImpl(FoldingSetBucketIteratorImpl other) {
    if ($isPointer(other.Ptr)) {
      this.Ptr = $tryClone(other.Ptr);
    } else {
      this.Ptr = other.Ptr;
    }
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIteratorImpl::advance">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 659,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 694,
   FQN="llvm::FoldingSetBucketIteratorImpl::advance", NM="_ZN4llvm28FoldingSetBucketIteratorImpl7advanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm28FoldingSetBucketIteratorImpl7advanceEv")
  //</editor-fold>
  protected void advance() {
    Object/*void P*/ Probe = ((/*static_cast*/FoldingSetImpl.Node /*P*/ )(Ptr)).getNextInBucket();
    Object/*uintptr_t*/ x = Probe; //reinterpret_cast_Object/*uintptr_t*/(Probe) & ~0x1;
    Ptr = x;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIteratorImpl::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 666,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 701,
   FQN="llvm::FoldingSetBucketIteratorImpl::operator==", NM="_ZNK4llvm28FoldingSetBucketIteratorImpleqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm28FoldingSetBucketIteratorImpleqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/ FoldingSetBucketIteratorImpl /*&*/ RHS) /*const*/ {
    return $eq_ptr(Ptr, RHS.Ptr);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetBucketIteratorImpl::operator!=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 669,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 704,
   FQN="llvm::FoldingSetBucketIteratorImpl::operator!=", NM="_ZNK4llvm28FoldingSetBucketIteratorImplneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm28FoldingSetBucketIteratorImplneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/ FoldingSetBucketIteratorImpl /*&*/ RHS) /*const*/ {
    return $noteq_ptr(Ptr, RHS.Ptr);
  }

  
  public String toString() {
    return "" + "Ptr=" + Ptr; // NOI18N
  }
}
