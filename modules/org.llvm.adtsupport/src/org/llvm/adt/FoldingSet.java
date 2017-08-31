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
import java.util.Iterator;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
/// FoldingSet - This template class is used to instantiate a specialized
/// implementation of the folding set to the node class T.  T must be a
/// subclass of FoldingSetNode and implement a Profile function.
///
/// Note that this set type is movable and move-assignable. However, its
/// moved-from state is not a valid state for anything other than
/// move-assigning and destroying. This is primarily to enable movable APIs
/// that incorporate these objects.
/*template <class T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 399,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 395,
 FQN="llvm::FoldingSet", NM="_ZN4llvm10FoldingSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSetE")
//</editor-fold>
public final class FoldingSet</*class*/ T extends FoldingSetImpl.Node>  extends /*public*/ FoldingSetImpl<T> implements Destructors.ClassWithDestructor {
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final FoldingSetTrait<T> trait;
  
/*private:*/
  /// GetNodeProfile - Each instantiatation of the FoldingSet needs to provide a
  /// way to convert nodes into a unique specifier.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::GetNodeProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 403,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 399,
   FQN="llvm::FoldingSet::GetNodeProfile", NM="_ZNK4llvm10FoldingSet14GetNodeProfileEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm10FoldingSet14GetNodeProfileEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  @Override protected/*private*/ void GetNodeProfile(Node /*P*/ N, FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    T /*P*/ TN = ((/*static_cast*/T /*P*/ )(N));
    trait.Profile($Deref(TN), ID);
  }

  /// NodeEquals - Instantiations may optionally provide a way to compare a
  /// node with a specified ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::NodeEquals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 409,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 405,
   FQN="llvm::FoldingSet::NodeEquals", NM="_ZNK4llvm10FoldingSet10NodeEqualsEPNS_14FoldingSetImpl4NodeERKNS_16FoldingSetNodeIDEjRS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm10FoldingSet10NodeEqualsEPNS_14FoldingSetImpl4NodeERKNS_16FoldingSetNodeIDEjRS4_")
  //</editor-fold>
  @Override protected/*private*/ boolean NodeEquals(Node /*P*/ N, /*const*/ FoldingSetNodeID /*&*/ ID, /*uint*/int IDHash, 
            FoldingSetNodeID /*&*/ TempID) /*const*//* override*/ {
    T /*P*/ TN = ((/*static_cast*/T /*P*/ )(N));
    return trait.Equals($Deref(TN), ID, IDHash, TempID);
  }

  /// ComputeNodeHash - Instantiations may optionally provide a way to compute a
  /// hash value directly from a node.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::ComputeNodeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 412,
   FQN="llvm::FoldingSet::ComputeNodeHash", NM="_ZNK4llvm10FoldingSet15ComputeNodeHashEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm10FoldingSet15ComputeNodeHashEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int ComputeNodeHash(Node /*P*/ N, FoldingSetNodeID /*&*/ TempID) /*const*//* override*/ {
    T /*P*/ TN = ((/*static_cast*/T /*P*/ )(N));
    return trait.ComputeHash($Deref(TN), TempID);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::FoldingSet<T>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 422,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 418,
   FQN="llvm::FoldingSet::FoldingSet<T>", NM="_ZN4llvm10FoldingSetC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSetC1Ej")
  //</editor-fold>
  public /*explicit*/ FoldingSet(FoldingSetTrait<T> trait) {
    this(trait, 6);
  }
  public /*explicit*/ FoldingSet(FoldingSetTrait<T> trait, /*uint*/int Log2InitSize/*= 6*/) {
    /* : FoldingSetImpl(Log2InitSize)*/ 
    //START JInit
    /*ParenListExpr*/super(Log2InitSize);
    //END JInit
    this.trait = trait;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::FoldingSet<T>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 425,
   FQN="llvm::FoldingSet::FoldingSet<T>", NM="_ZN4llvm10FoldingSetC1EONS_10FoldingSetIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSetC1EONS_10FoldingSetIT_EE")
  //</editor-fold>
  public FoldingSet(JD$Move _dparam, FoldingSet<T> /*&&*/Arg) {
    /* : FoldingSetImpl(std::move(Arg))*/ 
    //START JInit
    /*ParenListExpr*/super(JD$Move.INSTANCE, std.move(Arg));
    //END JInit
    this.trait = Arg.trait;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 426,
   FQN="llvm::FoldingSet::operator=", NM="_ZN4llvm10FoldingSetaSEONS_10FoldingSetIT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSetaSEONS_10FoldingSetIT_EE")
  //</editor-fold>
  public FoldingSet<T> /*&*/ $assignMove(FoldingSet<T> /*&&*/RHS) {
    super.$assignMove(RHS);
    return /*Deref*/this;
  }

  
  /*typedef FoldingSetIterator<T> iterator*/
//  public final class iterator extends FoldingSetIterator<T>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 432,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 423,
   FQN="llvm::FoldingSet::begin", NM="_ZN4llvm10FoldingSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSet5beginEv")
  //</editor-fold>
  public FoldingSetIterator<T> begin() {
    return new FoldingSetIterator<T>($tryClone(Buckets));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 433,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 424,
   FQN="llvm::FoldingSet::end", NM="_ZN4llvm10FoldingSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSet3endEv")
  //</editor-fold>
  public FoldingSetIterator<T> end() {
    return new FoldingSetIterator<T>(Buckets.$add(NumBuckets));
  }

  
  /*typedef FoldingSetIterator<const T> const_iterator*/
//  public final class const_iterator extends FoldingSetIterator</*const*/ T>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 427,
   FQN="llvm::FoldingSet::begin", NM="_ZNK4llvm10FoldingSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm10FoldingSet5beginEv")
  //</editor-fold>
  public FoldingSetIterator</*const*/ T> begin$Const() /*const*/ {
    return new FoldingSetIterator</*const*/ T>($tryClone(Buckets));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 437,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 428,
   FQN="llvm::FoldingSet::end", NM="_ZNK4llvm10FoldingSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm10FoldingSet3endEv")
  //</editor-fold>
  public FoldingSetIterator</*const*/ T> end$Const() /*const*/ {
    return new FoldingSetIterator</*const*/ T>(Buckets.$add(NumBuckets));
  }

  
  /*typedef FoldingSetBucketIterator<T> bucket_iterator*/
//  public final class bucket_iterator extends FoldingSetBucketIterator<T>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::bucket_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 441,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 432,
   FQN="llvm::FoldingSet::bucket_begin", NM="_ZN4llvm10FoldingSet12bucket_beginEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSet12bucket_beginEj")
  //</editor-fold>
  public FoldingSetBucketIterator<T> bucket_begin(/*uint*/int hash) {
    return new FoldingSetBucketIterator<T>(Buckets.$add(hash & (NumBuckets - 1)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::bucket_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 445,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 436,
   FQN="llvm::FoldingSet::bucket_end", NM="_ZN4llvm10FoldingSet10bucket_endEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSet10bucket_endEj")
  //</editor-fold>
  public FoldingSetBucketIterator<T> bucket_end(/*uint*/int hash) {
    return new FoldingSetBucketIterator<T>(Buckets.$add(hash & (NumBuckets - 1)), true);
  }

  
  /// GetOrInsertNode - If there is an existing simple Node exactly
  /// equal to the specified node, return it.  Otherwise, insert 'N' and
  /// return it instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::GetOrInsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 443,
   FQN="llvm::FoldingSet::GetOrInsertNode", NM="_ZN4llvm10FoldingSet15GetOrInsertNodeEPNS_14FoldingSetImpl4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSet15GetOrInsertNodeEPNS_14FoldingSetImpl4NodeE")
  //</editor-fold>
  public T /*P*/ GetOrInsertNode(Node /*P*/ N) {
    return ((/*static_cast*/T /*P*/ )(super.GetOrInsertNode(N)));
  }

  
  /// FindNodeOrInsertPos - Look up the node specified by ID.  If it exists,
  /// return it.  If not, return the insertion token that will make insertion
  /// faster.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSet::FindNodeOrInsertPos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 459,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 450,
   FQN="llvm::FoldingSet::FindNodeOrInsertPos", NM="_ZN4llvm10FoldingSet19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm10FoldingSet19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv")
  //</editor-fold>
  public <Ret extends T> Ret /*P*/ FindNodeOrInsertPos(/*const*/ FoldingSetNodeID /*&*/ ID, final type$ref<type$ptr<Ret>>/*void P&*/ InsertPos) {
    return ((/*static_cast*/Ret /*P*/ )(super.FindNodeOrInsertPosImpl(ID, (type$ref<type$ptr<T>>)(type$ref)InsertPos)));
  }

  @Override
  public Iterator<T> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
