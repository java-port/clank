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
import static org.llvm.support.impl.FoldingSetStatics.*;


//===----------------------------------------------------------------------===//
/// FoldingSetIteratorImpl - This is the common iterator support shared by all
/// folding sets, which knows how to walk the folding set hash table.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 609,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 642,
 FQN="llvm::FoldingSetIteratorImpl", NM="_ZN4llvm22FoldingSetIteratorImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN4llvm22FoldingSetIteratorImplE")
//</editor-fold>
public abstract class FoldingSetIteratorImpl /*implements Native.NativeComparable<FoldingSetIteratorImpl>*/ {
/*protected:*/
  protected FoldingSetImpl.Node /*P*/ NodePtr;
  
  //===----------------------------------------------------------------------===//
  // FoldingSetIteratorImpl Implementation
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl::FoldingSetIteratorImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 413,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 390,
   FQN="llvm::FoldingSetIteratorImpl::FoldingSetIteratorImpl", NM="_ZN4llvm22FoldingSetIteratorImplC1EPPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22FoldingSetIteratorImplC1EPPv")
  //</editor-fold>
  protected FoldingSetIteratorImpl(type$ptr<?>/*void PP*/ Bucket) {
    // Skip to the first non-null non-self-cycle bucket.
    while ((Bucket.$star() != EMPTY_NODE)
       && (!(Bucket.$star() != null) || !(GetNextPtr(Bucket.$star()) != null))) {
      Bucket.$preInc();
    }
    
    NodePtr = ((/*static_cast*/FoldingSetImpl.Node /*P*/ )(Bucket.$star()));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl::advance">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 422,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 399,
   FQN="llvm::FoldingSetIteratorImpl::advance", NM="_ZN4llvm22FoldingSetIteratorImpl7advanceEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm22FoldingSetIteratorImpl7advanceEv")
  //</editor-fold>
  protected void advance() {
    // If there is another link within this bucket, go to it.
    Object/*void P*/ Probe = NodePtr.getNextInBucket();
    {
      
      FoldingSetImpl.Node /*P*/ NextNodeInBucket = GetNextPtr(Probe);
      if ((NextNodeInBucket != null)) {
        NodePtr = NextNodeInBucket;
      } else {
        // Otherwise, this is the last link in this bucket.  
        type$ptr<Object>/*void PP*/ Bucket = $tryClone(GetBucketPtr(Probe));
        
        // Skip to the next non-null non-self-cycle bucket.
        do {
          Bucket.$preInc();
        } while (Bucket.$star() != EMPTY_NODE
           && (!(Bucket.$star() != null) || !(GetNextPtr(Bucket.$star()) != null)));
        
        NodePtr = ((/*static_cast*/FoldingSetImpl.Node /*P*/ )(Bucket.$star()));
      }
    }
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 616,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 649,
   FQN="llvm::FoldingSetIteratorImpl::operator==", NM="_ZNK4llvm22FoldingSetIteratorImpleqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZNK4llvm22FoldingSetIteratorImpleqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/ FoldingSetIteratorImpl /*&*/ RHS) /*const*/ {
    return NodePtr == RHS.NodePtr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 619,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 652,
   FQN="llvm::FoldingSetIteratorImpl::operator!=", NM="_ZNK4llvm22FoldingSetIteratorImplneERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZNK4llvm22FoldingSetIteratorImplneERKS0_")
  //</editor-fold>
  public boolean $noteq(/*const*/ FoldingSetIteratorImpl /*&*/ RHS) /*const*/ {
    return NodePtr != RHS.NodePtr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl::FoldingSetIteratorImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 609,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 642,
   FQN="llvm::FoldingSetIteratorImpl::FoldingSetIteratorImpl", NM="_ZN4llvm22FoldingSetIteratorImplC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN4llvm22FoldingSetIteratorImplC1ERKS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetIteratorImpl(/*const*/ FoldingSetIteratorImpl /*&*/ $Prm0) {
    /* : NodePtr(.NodePtr)*/ 
    //START JInit
    this.NodePtr = $Prm0.NodePtr;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetIteratorImpl::FoldingSetIteratorImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 609,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 642,
   FQN="llvm::FoldingSetIteratorImpl::FoldingSetIteratorImpl", NM="_ZN4llvm22FoldingSetIteratorImplC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CodeGenTypes.cpp -nm=_ZN4llvm22FoldingSetIteratorImplC1EOS0_")
  //</editor-fold>
  public /*inline*/ FoldingSetIteratorImpl(JD$Move _dparam, FoldingSetIteratorImpl /*&&*/$Prm0) {
    /* : NodePtr(static_cast<FoldingSetIteratorImpl &&>().NodePtr)*/ 
    //START JInit
    this.NodePtr = $Prm0.NodePtr;
    //END JInit
  }
  
  
  public String toString() {
    return "" + "NodePtr=" + NodePtr; // NOI18N
  }
}
