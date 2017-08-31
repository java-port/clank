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
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//===----------------------------------------------------------------------===//
/// FoldingSetVector - This template class combines a FoldingSet and a vector
/// to provide the interface of FoldingSet but with deterministic iteration
/// order based on the insertion order. T must be a subclass of FoldingSetNode
/// and implement a Profile function.
/*template <class T, class VectorT = SmallVector<T *, 8>> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 547,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 579,
 FQN="llvm::FoldingSetVector", NM="_ZN4llvm16FoldingSetVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVectorE")
//</editor-fold>
public class FoldingSetVector</*class*/ T extends FoldingSetImpl.Node> implements Iterable<T> {
  private FoldingSet<T> Set;
  private SmallVector<T /*P*/> Vector;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::FoldingSetVector<T, VectorT>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 553,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 585,
   FQN="llvm::FoldingSetVector::FoldingSetVector<T, VectorT>", NM="_ZN4llvm16FoldingSetVectorC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVectorC1Ej")
  //</editor-fold>
  public /*explicit*/ FoldingSetVector(FoldingSetTrait<T> trait) {
    this(trait, 6);
  }
  public /*explicit*/ FoldingSetVector(FoldingSetTrait<T> trait, /*uint*/int Log2InitSize/*= 6*/) {
    /* : Set(Log2InitSize)*/ 
    //START JInit
    this.Set = /*ParenListExpr*/new FoldingSet<T>(trait, Log2InitSize);
    this.Vector = new SmallVector<>(8);
    //END JInit
  }

  
  /*typedef pointee_iterator<typename VectorT::iterator> iterator*/
//  public final class iterator extends pointee_iterator< VectorT.iterator>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 558,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 590,
   FQN="llvm::FoldingSetVector::begin", NM="_ZN4llvm16FoldingSetVector5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector5beginEv")
  //</editor-fold>
  public pointee_iterator<T> begin() {
    return new pointee_iterator(Vector.begin());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 559,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 591,
   FQN="llvm::FoldingSetVector::end", NM="_ZN4llvm16FoldingSetVector3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector3endEv")
  //</editor-fold>
  public pointee_iterator<T> end() {
    return new pointee_iterator(Vector.end());
  }

  
  /*typedef pointee_iterator<typename VectorT::const_iterator> const_iterator*/
//  public final class const_iterator extends pointee_iterator< VectorT.const_iterator>{ };
  ////<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::begin">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 562,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 595,
//   FQN="llvm::FoldingSetVector::begin", NM="_ZNK4llvm16FoldingSetVector5beginEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetVector5beginEv")
//  //</editor-fold>
//  public pointee_iterator< VectorT.const_iterator> begin() /*const*/ {
//    return Vector.begin();
//  }

  ////<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::end">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 563,
//   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 596,
//   FQN="llvm::FoldingSetVector::end", NM="_ZNK4llvm16FoldingSetVector3endEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetVector3endEv")
//  //</editor-fold>
//  public pointee_iterator< VectorT.const_iterator> end() /*const*/ {
//    return Vector.end();
//  }

  
  /// clear - Remove all nodes from the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::clear">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 566,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 599,
   FQN="llvm::FoldingSetVector::clear", NM="_ZN4llvm16FoldingSetVector5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector5clearEv")
  //</editor-fold>
  public void clear() {
    Set.clear();
    Vector.clear();
  }

  
  /// FindNodeOrInsertPos - Look up the node specified by ID.  If it exists,
  /// return it.  If not, return the insertion token that will make insertion
  /// faster.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::FindNodeOrInsertPos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 571,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 604,
   FQN="llvm::FoldingSetVector::FindNodeOrInsertPos", NM="_ZN4llvm16FoldingSetVector19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv")
  //</editor-fold>
  public T /*P*/ FindNodeOrInsertPos(/*const*/ FoldingSetNodeID /*&*/ ID, final type$ref<type$ptr<T>>/*void P&*/ InsertPos) {
    return Set.FindNodeOrInsertPos(ID, InsertPos);
  }

  
  /// GetOrInsertNode - If there is an existing simple Node exactly
  /// equal to the specified node, return it.  Otherwise, insert 'N' and
  /// return it instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::GetOrInsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 578,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 611,
   FQN="llvm::FoldingSetVector::GetOrInsertNode", NM="_ZN4llvm16FoldingSetVector15GetOrInsertNodeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector15GetOrInsertNodeEPT_")
  //</editor-fold>
  public T /*P*/ GetOrInsertNode(T /*P*/ N) {
    T /*P*/ Result = Set.GetOrInsertNode(N);
    if (Native.$eq(Result, N)) {
      Vector.push_back(N);
    }
    return Result;
  }

  
  /// InsertNode - Insert the specified node into the folding set, knowing that
  /// it is not already in the folding set.  InsertPos must be obtained from
  /// FindNodeOrInsertPos.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::InsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 587,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 620,
   FQN="llvm::FoldingSetVector::InsertNode", NM="_ZN4llvm16FoldingSetVector10InsertNodeEPT_Pv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector10InsertNodeEPT_Pv")
  //</editor-fold>
  public void InsertNode(T /*P*/ N, type$ptr<T>/*void P*/ InsertPos) {
    Set.InsertNode(N, InsertPos);
    Vector.push_back(N);
  }

  
  /// InsertNode - Insert the specified node into the folding set, knowing that
  /// it is not already in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::InsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 594,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 627,
   FQN="llvm::FoldingSetVector::InsertNode", NM="_ZN4llvm16FoldingSetVector10InsertNodeEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm16FoldingSetVector10InsertNodeEPT_")
  //</editor-fold>
  public void InsertNode(T /*P*/ N) {
    Set.InsertNode(N);
    Vector.push_back(N);
  }

  
  /// size - Returns the number of nodes in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 600,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 633,
   FQN="llvm::FoldingSetVector::size", NM="_ZNK4llvm16FoldingSetVector4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetVector4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return Set.size();
  }

  
  /// empty - Returns true if there are no nodes in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetVector::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 603,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 636,
   FQN="llvm::FoldingSetVector::empty", NM="_ZNK4llvm16FoldingSetVector5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm16FoldingSetVector5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return Set.empty();
  }

  
  public String toString() {
    return "" + "Set=" + Set.size() // NOI18N
              + ", Vector=" + Vector.size(); // NOI18N
  }

  @Override
  public Iterator<T> iterator() {
     return new JavaIterator(begin(), end()); 
  }

  public FoldingSetVector() {
    this(new DefaultFoldingSetTrait<>());
  }

  public void $destroy() {
    NativeTrace.traceNotImplemented("FoldingSetVector::$destroy");
  }  
}
