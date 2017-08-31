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
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;


//===----------------------------------------------------------------------===//
/// ContextualFoldingSet - This template class is a further refinement
/// of FoldingSet which provides a context argument when calling
/// Profile on its nodes.  Currently, that argument is fixed at
/// initialization time.
///
/// T must be a subclass of FoldingSetNode and implement a Profile
/// function with signature
///   void Profile(llvm::FoldingSetNodeID &, Ctx);
/*template <class T, class Ctx> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 487,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 473,
 FQN="llvm::ContextualFoldingSet", NM="_ZN4llvm20ContextualFoldingSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSetE")
//</editor-fold>
public final class ContextualFoldingSet</*class*/ T extends FoldingSetImpl.ContextualNode, /*class*/ Ctx>  extends /*public*/ FoldingSetImpl<T> implements Destructors.ClassWithDestructor {
// Unfortunately, this can't derive from FoldingSet<T> because the
  // construction vtable for FoldingSet<T> requires
  // FoldingSet<T>::GetNodeProfile to be instantiated, which in turn
  // requires a single-argument T::Profile().
  /*private:*/
  private final Ctx Context;
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  private final ContextualFoldingSetTrait<T, Ctx> Trait;
  /// GetNodeProfile - Each instantiatation of the FoldingSet needs to provide a
  /// way to convert nodes into a unique specifier.
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::GetNodeProfile">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 499,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 485,
   FQN="llvm::ContextualFoldingSet::GetNodeProfile", NM="_ZNK4llvm20ContextualFoldingSet14GetNodeProfileEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm20ContextualFoldingSet14GetNodeProfileEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  @Override protected/*private*/ void GetNodeProfile(FoldingSetImpl.Node /*P*/ N, 
                final FoldingSetNodeID /*&*/ ID) /*const*//* override*/ {
    T /*P*/ TN = ((/*static_cast*/T /*P*/ )(N));
    Trait.Profile($Deref(TN), ID, Context);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::NodeEquals">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 504,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 490,
   FQN="llvm::ContextualFoldingSet::NodeEquals", NM="_ZNK4llvm20ContextualFoldingSet10NodeEqualsEPNS_14FoldingSetImpl4NodeERKNS_16FoldingSetNodeIDEjRS4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm20ContextualFoldingSet10NodeEqualsEPNS_14FoldingSetImpl4NodeERKNS_16FoldingSetNodeIDEjRS4_")
  //</editor-fold>
  @Override protected/*private*/ boolean NodeEquals(FoldingSetImpl.Node /*P*/ N, final /*const*/ FoldingSetNodeID /*&*/ ID, 
            /*uint*/int IDHash, final FoldingSetNodeID /*&*/ TempID) /*const*//* override*/ {
    T /*P*/ TN = ((/*static_cast*/T /*P*/ )(N));
    return Trait.Equals($Deref(TN), ID, IDHash, TempID, 
        Context);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::ComputeNodeHash">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 510,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 496,
   FQN="llvm::ContextualFoldingSet::ComputeNodeHash", NM="_ZNK4llvm20ContextualFoldingSet15ComputeNodeHashEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm20ContextualFoldingSet15ComputeNodeHashEPNS_14FoldingSetImpl4NodeERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  @Override protected/*private*/ /*uint*/int ComputeNodeHash(FoldingSetImpl.Node /*P*/ N, 
                 final FoldingSetNodeID /*&*/ TempID) /*const*//* override*/ {
    T /*P*/ TN = ((/*static_cast*/T /*P*/ )(N));
    return Trait.ComputeHash($Deref(TN), TempID, Context);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::ContextualFoldingSet<T, Ctx>">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 517,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 503,
   FQN="llvm::ContextualFoldingSet::ContextualFoldingSet<T, Ctx>", NM="_ZN4llvm20ContextualFoldingSetC1ET0_j",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSetC1ET0_j")
  //</editor-fold>
  public /*explicit*/ ContextualFoldingSet(final ContextualFoldingSetTrait<T, Ctx> Trait, Ctx Context) {
    this(Trait, Context, 6);
  }
  public /*explicit*/ ContextualFoldingSet(final ContextualFoldingSetTrait<T, Ctx> Trait, Ctx Context, /*uint*/int Log2InitSize/*= 6*/) {
    // : FoldingSetImpl(Log2InitSize), Context(Context) 
    //START JInit
    /*ParenListExpr*/super(Log2InitSize);
    this.Context = /*ParenListExpr*/Context;
    //END JInit
    this.Trait = Trait;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::getContext">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 521,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 507,
   FQN="llvm::ContextualFoldingSet::getContext", NM="_ZNK4llvm20ContextualFoldingSet10getContextEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm20ContextualFoldingSet10getContextEv")
  //</editor-fold>
  public Ctx getContext() /*const*/ {
    return Context;
  }

  
  /*typedef FoldingSetIterator<T> iterator*/
//  public final class iterator extends FoldingSetIterator<T>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*must clone*/,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 524,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 510,
   FQN="llvm::ContextualFoldingSet::begin", NM="_ZN4llvm20ContextualFoldingSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSet5beginEv")
  //</editor-fold>
  public FoldingSetIterator<T> begin() {
    return new FoldingSetIterator<T>($tryClone(Buckets));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 525,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 511,
   FQN="llvm::ContextualFoldingSet::end", NM="_ZN4llvm20ContextualFoldingSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSet3endEv")
  //</editor-fold>
  public FoldingSetIterator<T> end() {
    return new FoldingSetIterator<T>(Buckets.$add(NumBuckets));
  }

  
  /*typedef FoldingSetIterator<const T> const_iterator*/
//  public final class const_iterator extends FoldingSetIterator</*const*/ T>{ };
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::begin">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*must clone*/,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 528,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 514,
   FQN="llvm::ContextualFoldingSet::begin", NM="_ZNK4llvm20ContextualFoldingSet5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm20ContextualFoldingSet5beginEv")
  //</editor-fold>
  public FoldingSetIterator</*const*/ T> begin$Const() /*const*/ {
    return new FoldingSetIterator</*const*/ T>($tryClone(Buckets));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 529,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 515,
   FQN="llvm::ContextualFoldingSet::end", NM="_ZNK4llvm20ContextualFoldingSet3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm20ContextualFoldingSet3endEv")
  //</editor-fold>
  public FoldingSetIterator</*const*/ T> end$Const() /*const*/ {
    return new FoldingSetIterator</*const*/ T>(Buckets.$add(NumBuckets));
  }

  
  /*typedef FoldingSetBucketIterator<T> bucket_iterator*/
//  public final class bucket_iterator extends FoldingSetBucketIterator<T>{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::bucket_begin">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 533,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 519,
   FQN="llvm::ContextualFoldingSet::bucket_begin", NM="_ZN4llvm20ContextualFoldingSet12bucket_beginEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSet12bucket_beginEj")
  //</editor-fold>
  public FoldingSetBucketIterator<T> bucket_begin(/*uint*/int hash) {
    return new FoldingSetBucketIterator<T>(Buckets.$add(hash & (NumBuckets - 1)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::bucket_end">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 537,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 523,
   FQN="llvm::ContextualFoldingSet::bucket_end", NM="_ZN4llvm20ContextualFoldingSet10bucket_endEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSet10bucket_endEj")
  //</editor-fold>
  public FoldingSetBucketIterator<T> bucket_end(/*uint*/int hash) {
    return new FoldingSetBucketIterator<T>(Buckets.$add(hash & (NumBuckets - 1)), true);
  }

  
  /// GetOrInsertNode - If there is an existing simple Node exactly
  /// equal to the specified node, return it.  Otherwise, insert 'N'
  /// and return it instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::GetOrInsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 544,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 530,
   FQN="llvm::ContextualFoldingSet::GetOrInsertNode", NM="_ZN4llvm20ContextualFoldingSet15GetOrInsertNodeEPNS_14FoldingSetImpl4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSet15GetOrInsertNodeEPNS_14FoldingSetImpl4NodeE")
  //</editor-fold>
  public T /*P*/ GetOrInsertNode(FoldingSetImpl.Node /*P*/ N) {
    return ((/*static_cast*/T /*P*/ )(super.GetOrInsertNode(N)));
  }

  
  /// FindNodeOrInsertPos - Look up the node specified by ID.  If it
  /// exists, return it.  If not, return the insertion token that will
  /// make insertion faster.
  //<editor-fold defaultstate="collapsed" desc="llvm::ContextualFoldingSet::FindNodeOrInsertPos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 551,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 537,
   FQN="llvm::ContextualFoldingSet::FindNodeOrInsertPos", NM="_ZN4llvm20ContextualFoldingSet19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm20ContextualFoldingSet19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv")
  //</editor-fold>
  public <Ret extends T> Ret /*P*/ FindNodeOrInsertPos(final /*const*/ FoldingSetNodeID /*&*/ ID, final type$ref<type$ptr<Ret>>/*void P&*/ InsertPos) {
    return ((/*static_cast*/Ret /*P*/ )(super.FindNodeOrInsertPosImpl(ID, (type$ref<type$ptr<T>>)(type$ref)InsertPos)));
  }

  @Override
  public Iterator<T> iterator() {
    return new JavaIterator<>(begin(), end());
  }
  
  @Override public String toString() {
    return "" + "Context={" + NativeTrace.getIdentityStr(Context) + "}\n" // NOI18N
              + super.toString(); // NOI18N
  }
}
