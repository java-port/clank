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

package org.llvm.adt.aliases;

import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.aliases.*;

/*template <typename ImutInfo> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 758,
 FQN="llvm::ImutAVLTreeInOrderIterator", NM="_ZN4llvm26ImutAVLTreeInOrderIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeInOrderIteratorE")
//</editor-fold>
public class ImutAVLTreeInOrderIteratorPtrTypeType</*typename ImutInfo*/ KeyT, DataT, ValT> implements type$iterator<ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT>, ImutAVLTreePtrTypeType<KeyT, DataT, ValT>>,
        /*public*/ std.iterator<std.bidirectional_iterator_tag, ImutAVLTreePtrTypeType<KeyT, DataT, ValT> > {
  /*typedef ImutAVLTreeGenericIterator<ImutInfo> InternalIteratorTy*/
//  public final class InternalIteratorTy extends ImutAVLTreeGenericIterator<_Kt, _Vt>{ };
  private ImutAVLTreeGenericIteratorPtrTypeType<KeyT, DataT, ValT> InternalItr;
/*public:*/
  /*typedef ImutAVLTree<ImutInfo> TreeTy*/
//  public final class TreeTy extends ImutAVLTree<_Kt, _Vt>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::ImutAVLTreeInOrderIterator<ImutInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 768,
   FQN="llvm::ImutAVLTreeInOrderIterator::ImutAVLTreeInOrderIterator<ImutInfo>", NM="_ZN4llvm26ImutAVLTreeInOrderIteratorC1EPKNS_11ImutAVLTreeIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeInOrderIteratorC1EPKNS_11ImutAVLTreeIT_EE")
  //</editor-fold>
  public ImutAVLTreeInOrderIteratorPtrTypeType(/*const*/ImutAVLTreePtrTypeType<KeyT, DataT, ValT>/*P*/ Root) {
    // : InternalItr(Root) 
    //START JInit
    this.InternalItr = /*ParenListExpr*/new ImutAVLTreeGenericIteratorPtrTypeType<KeyT, DataT, ValT>(Root);
    //END JInit
    if (Root != null) {
      this.$preInc(); // Advance to first element.
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::ImutAVLTreeInOrderIterator<ImutInfo>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 773,
   FQN="llvm::ImutAVLTreeInOrderIterator::ImutAVLTreeInOrderIterator<ImutInfo>", NM="_ZN4llvm26ImutAVLTreeInOrderIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeInOrderIteratorC1Ev")
  //</editor-fold>
  public ImutAVLTreeInOrderIteratorPtrTypeType() {
    // : InternalItr() 
    //START JInit
    this.InternalItr = /*ParenListExpr*/new ImutAVLTreeGenericIteratorPtrTypeType<KeyT, DataT, ValT>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::operator==">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 775,
   FQN="llvm::ImutAVLTreeInOrderIterator::operator==", NM="_ZNK4llvm26ImutAVLTreeInOrderIteratoreqERKNS_26ImutAVLTreeInOrderIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeInOrderIteratoreqERKNS_26ImutAVLTreeInOrderIteratorIT_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/Object/*&*/ x) /*const*/ {
    return Native.$eq_iter(InternalItr, ((ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT>) x).InternalItr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 779,
   FQN="llvm::ImutAVLTreeInOrderIterator::operator!=", NM="_ZNK4llvm26ImutAVLTreeInOrderIteratorneERKNS_26ImutAVLTreeInOrderIteratorIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeInOrderIteratorneERKNS_26ImutAVLTreeInOrderIteratorIT_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/Object/*&*/ x) /*const*/ {
    return !$eq(x);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 783,
   FQN="llvm::ImutAVLTreeInOrderIterator::operator*", NM="_ZNK4llvm26ImutAVLTreeInOrderIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeInOrderIteratordeEv")
  //</editor-fold>
  public ImutAVLTreePtrTypeType<KeyT, DataT, ValT>/*&*/ $star() /*const*/ {
    return InternalItr.$star();
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 784,
   FQN="llvm::ImutAVLTreeInOrderIterator::operator->", NM="_ZNK4llvm26ImutAVLTreeInOrderIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZNK4llvm26ImutAVLTreeInOrderIteratorptEv")
  //</editor-fold>
  public ImutAVLTreePtrTypeType<KeyT, DataT, ValT>/*P*/ $arrow() /*const*/ {
    return $AddrOf(InternalItr.$star());
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::operator++">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 786,
   FQN="llvm::ImutAVLTreeInOrderIterator::operator++", NM="_ZN4llvm26ImutAVLTreeInOrderIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeInOrderIteratorppEv")
  //</editor-fold>
  public ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT>/*&*/ $preInc() {
    do  {
      InternalItr.$preInc();
    } while (!InternalItr.atEnd()
       && (InternalItr.getVisitState() != ImutAVLTreeGenericIterator.VisitFlag.VisitedLeft));
    
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::operator--">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 794,
   FQN="llvm::ImutAVLTreeInOrderIterator::operator--", NM="_ZN4llvm26ImutAVLTreeInOrderIteratormmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeInOrderIteratormmEv")
  //</editor-fold>
  public ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT>/*&*/ $preDec() {
    do  {
      InternalItr.$preDec();
    } while (!InternalItr.atBeginning()
       && (InternalItr.getVisitState() != ImutAVLTreeGenericIterator.VisitFlag.VisitedLeft));
    
    return this;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ImutAVLTreeInOrderIterator::skipSubTree">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/ImmutableSet.h", line = 802,
   FQN="llvm::ImutAVLTreeInOrderIterator::skipSubTree", NM="_ZN4llvm26ImutAVLTreeInOrderIterator11skipSubTreeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CallEvent.cpp -nm=_ZN4llvm26ImutAVLTreeInOrderIterator11skipSubTreeEv")
  //</editor-fold>
  public void skipSubTree() {
    InternalItr.skipToParent();
    while (!InternalItr.atEnd()
       && (InternalItr.getVisitState() != ImutAVLTreeGenericIterator.VisitFlag.VisitedLeft)) {
      InternalItr.$preInc();
    }
  }
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutAVLTreeInOrderIteratorPtrTypeType(ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT> Other) {
    this.InternalItr = new ImutAVLTreeGenericIteratorPtrTypeType<KeyT, DataT, ValT>(Other.InternalItr);
  }

  @Override
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT> clone() {
    return new ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT>(this);
  }
  
  @Override
  public int $sub(ImutAVLTreeInOrderIteratorPtrTypeType<KeyT, DataT, ValT> iter) {
    return std.distance(iter, this, JavaDifferentiators.JD$FAKE.TRAILING);
  }
  
  @Override public String toString() {
    return "" + "InternalItr=" + InternalItr // NOI18N
              + super.toString(); // NOI18N
  }
}
