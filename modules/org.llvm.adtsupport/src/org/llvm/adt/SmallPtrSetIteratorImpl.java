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
import static org.clank.support.Native.*;
import org.llvm.adt.*;


/// SmallPtrSetIteratorImpl - This is the common base class shared between all
/// instances of SmallPtrSetIterator.
//<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIteratorImpl">
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 149,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 147,
 FQN = "llvm::SmallPtrSetIteratorImpl", NM = "_ZN4llvm23SmallPtrSetIteratorImplE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm23SmallPtrSetIteratorImplE")
//</editor-fold>
public abstract class SmallPtrSetIteratorImpl {
  
  protected DenseMapInfo KeyInfo;
/*protected:*/
  protected /*const*/type$ptr<Object>/*void P const P*/ Bucket;
  protected /*const*/type$ptr<Object>/*void P const P*/ End;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIteratorImpl::SmallPtrSetIteratorImpl">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 155,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 152,
   FQN = "llvm::SmallPtrSetIteratorImpl::SmallPtrSetIteratorImpl", NM = "_ZN4llvm23SmallPtrSetIteratorImplC1EPKPKvS4_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm23SmallPtrSetIteratorImplC1EPKPKvS4_")
  //</editor-fold>
  public /*explicit*/ SmallPtrSetIteratorImpl(DenseMapInfo KeyInfo, /*const*/type$ptr<Object>/*void P const P*/ BP, /*const*/type$ptr<Object>/*void P const P*/ E) {
    /* : Bucket(BP), End(E)*/ 
    //START JInit
    this.KeyInfo = KeyInfo;
    this.Bucket = $tryClone(BP);
    this.End = $tryClone(E);
    //END JInit
    AdvanceIfNotValid();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIteratorImpl::operator==">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 157,
   FQN = "llvm::SmallPtrSetIteratorImpl::operator==", NM = "_ZNK4llvm23SmallPtrSetIteratorImpleqERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm23SmallPtrSetIteratorImpleqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/SmallPtrSetIteratorImpl /*&*/ RHS) /*const*/ {
    return Bucket.$eq(RHS.Bucket);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIteratorImpl::operator!=">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 160,
   FQN = "llvm::SmallPtrSetIteratorImpl::operator!=", NM = "_ZNK4llvm23SmallPtrSetIteratorImplneERKS0_",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZNK4llvm23SmallPtrSetIteratorImplneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/SmallPtrSetIteratorImpl /*&*/ RHS) /*const*/ {
    return Bucket.$noteq(RHS.Bucket);
  }

/*protected:*/
  /// AdvanceIfNotValid - If the current bucket isn't valid, advance to a bucket
  /// that is.   This is guaranteed to stop because the end() bucket is marked
  /// valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::SmallPtrSetIteratorImpl::AdvanceIfNotValid">
  @Converted(kind = Converted.Kind.AUTO, source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", line = 171,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/SmallPtrSet.h", old_line = 168,
   FQN = "llvm::SmallPtrSetIteratorImpl::AdvanceIfNotValid", NM = "_ZN4llvm23SmallPtrSetIteratorImpl17AdvanceIfNotValidEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/SmallPtrSet.cpp -nm=_ZN4llvm23SmallPtrSetIteratorImpl17AdvanceIfNotValidEv")
  //</editor-fold>
  protected void AdvanceIfNotValid() {
    assert (Bucket.$lesseq(End));
    while (Bucket.$noteq(End) && ((Bucket.$star() == KeyInfo.getEmptyKey()) || (Bucket.$star() == KeyInfo.getTombstoneKey()))) {
      Bucket.$preInc();
    }
  }
}
