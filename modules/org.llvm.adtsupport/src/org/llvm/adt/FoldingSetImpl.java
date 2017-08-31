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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.llvm.support.impl.FoldingSetStatics.*;
import org.llvm.adt.*;
import static org.llvm.support.AdtsupportLlvmGlobals.PowerOf2Floor;


//===----------------------------------------------------------------------===//
/// FoldingSetImpl - Implements the folding set functionality.  The main
/// structure is an array of buckets.  Each bucket is indexed by the hash of
/// the nodes it contains.  The bucket itself points to the nodes contained
/// in the bucket via a singly linked list.  The last node in the list points
/// back to the bucket to facilitate node removal.
///
//<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 109,
 old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 111,
 FQN="llvm::FoldingSetImpl", NM="_ZN4llvm14FoldingSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImplE")
//</editor-fold>
public abstract class FoldingSetImpl<T> implements Iterable<T>, Destructors.ClassWithDestructor {
  
  //===----------------------------------------------------------------------===//
  // FoldingSetImpl Implementation
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::anchor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 226,
   FQN="llvm::FoldingSetImpl::anchor", NM="_ZN4llvm14FoldingSetImpl6anchorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl6anchorEv")
  //</editor-fold>
  protected/*private*/ void anchor() {
  }
 // Out of line virtual method.
/*protected:*/
  /// Buckets - Array of bucket chains.
  ///
  protected type$ptr<T>/*void PP*/ Buckets;
  
  /// NumBuckets - Length of the Buckets array.  Always a power of 2.
  ///
  protected /*uint*/int NumBuckets;
  
  /// NumNodes - Number of nodes in the folding set. Growth occurs when NumNodes
  /// is greater than twice the number of buckets.
  protected /*uint*/int NumNodes;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::FoldingSetImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 228,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 225,
   FQN="llvm::FoldingSetImpl::FoldingSetImpl", NM="_ZN4llvm14FoldingSetImplC1Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImplC1Ej")
  //</editor-fold>
  protected FoldingSetImpl() {
    this(6);
  }
  protected FoldingSetImpl(/*uint*/int Log2InitSize/*= 6*/) {
    assert ($less_uint(5, Log2InitSize) && $less_uint(Log2InitSize, 32)) : "Initial hash table size out of range";
    NumBuckets = 1 << Log2InitSize;
    Buckets = $toConst(AllocateBuckets(NumBuckets));
    NumNodes = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::FoldingSetImpl">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 236,
   FQN="llvm::FoldingSetImpl::FoldingSetImpl", NM="_ZN4llvm14FoldingSetImplC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImplC1EOS0_")
  //</editor-fold>
  protected FoldingSetImpl(JD$Move _dparam, FoldingSetImpl /*&&*/Arg) {
    /* : Buckets(Arg.Buckets), NumBuckets(Arg.NumBuckets), NumNodes(Arg.NumNodes)*/ 
    //START JInit
    this.Buckets = $tryConstClone(Arg.Buckets);
    this.NumBuckets = Arg.NumBuckets;
    this.NumNodes = Arg.NumNodes;
    //END JInit
    Arg.Buckets = null;
    Arg.NumBuckets = 0;
    Arg.NumNodes = 0;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::operator=">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 243,
   FQN="llvm::FoldingSetImpl::operator=", NM="_ZN4llvm14FoldingSetImplaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImplaSEOS0_")
  //</editor-fold>
  protected FoldingSetImpl /*&*/ $assignMove(FoldingSetImpl /*&&*/RHS) {
    free(Buckets); // This may be null if the set is in a moved-from state.
    Buckets = $tryConstClone(RHS.Buckets);
    NumBuckets = RHS.NumBuckets;
    NumNodes = RHS.NumNodes;
    RHS.Buckets = null;
    RHS.NumBuckets = 0;
    RHS.NumNodes = 0;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::~FoldingSetImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 254,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 232,
   FQN="llvm::FoldingSetImpl::~FoldingSetImpl", NM="_ZN4llvm14FoldingSetImplD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImplD0Ev")
  //</editor-fold>
  public/*protected*/ void $destroy() {
    free(Buckets);
  }

  private static final String NODE_ERROR_MSG = "Forgot to derive from FoldingSetImpl.NodeImpl\n OR \nadd 'private final FoldingSetImpl.NodeImpl $nodeImpl = new FoldingSetImpl.NodeImpl()'? "; // NOI18N
/*public:*/
  //===--------------------------------------------------------------------===//
  /// Node - This class is used to maintain the singly linked bucket list in
  /// a folding set.
  ///
  // JAVA: changed to interface.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 133,
   FQN="llvm::FoldingSetImpl::Node", NM="_ZN4llvm14FoldingSetImpl4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeE")
  //</editor-fold>
  public static interface Node extends FoldingSetTrait.Profilable {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::Node">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 140,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 141,
     FQN="llvm::FoldingSetImpl::Node::Node", NM="_ZN4llvm14FoldingSetImpl4NodeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeC1Ev")
    //</editor-fold>
    public default void $Node() {
      throw new UnsupportedOperationException(NODE_ERROR_MSG + this.getClass());
    }
    public default void $Node(Node other) {
      throw new UnsupportedOperationException(NODE_ERROR_MSG + this.getClass());
    }
    
    public default void $destroy$Node() { $destroy$NodeImpl(); }
    
    public default void $destroy$NodeImpl() { }
    
    // Accessors
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::getNextInBucket">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 144,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 143,
     FQN="llvm::FoldingSetImpl::Node::getNextInBucket", NM="_ZNK4llvm14FoldingSetImpl4Node15getNextInBucketEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl4Node15getNextInBucketEv")
    //</editor-fold>
    public default Object/*void P*/ getNextInBucket() /*const*/ {
      return $nodeImpl().getNextInBucket();
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::SetNextInBucket">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 145,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 144,
     FQN="llvm::FoldingSetImpl::Node::SetNextInBucket", NM="_ZN4llvm14FoldingSetImpl4Node15SetNextInBucketEPv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4Node15SetNextInBucketEPv")
    //</editor-fold>
    public default void SetNextInBucket(Object/*void P*/ N) {
      $nodeImpl().SetNextInBucket(N);
    }
    
    @Override
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public default void Profile(FoldingSetNodeID /*&*/ ID) {
      throw new UnsupportedOperationException("Forgot to generate Profile method? " + this.getClass());
    }

    public default FoldingSetImpl.NodeImpl $nodeImpl() {
      throw new UnsupportedOperationException(NODE_ERROR_MSG + this.getClass());
    }
  };
  
  public static interface ContextualNode<Ctx> extends Node {
    public default void Profile(FoldingSetNodeID /*&*/ ID, Ctx C) {
      throw new UnsupportedOperationException("Please, implement Profile(ID, C) in " + this.getClass() + " or use another FoldingSetTrait!");
    }    
  }
  
  // Default implementation but we don't mark it as implementing FoldingSetImpl.Node, interface is added to the real class
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 133,
   FQN="llvm::FoldingSetImpl::Node", NM="_ZN4llvm14FoldingSetImpl4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeE")
  //</editor-fold>
  public static class NodeImpl {
    private static final FoldingSetTrait TRAIT = new DefaultFoldingSetTrait<>();    
    public static <T> FoldingSetTrait<T> $Trait() { return TRAIT; }
    
  /*private:*/
    // NextInFoldingSetBucket - next link in the bucket list.
    private Object/*void P*/ NextInFoldingSetBucket;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::Node">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 141,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 140,
     FQN="llvm::FoldingSetImpl::Node::Node", NM="_ZN4llvm14FoldingSetImpl4NodeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeC1Ev")
    //</editor-fold>
    public NodeImpl() {
      /* : NextInFoldingSetBucket(null)*/ 
      //START JInit
      this.NextInFoldingSetBucket = null;
      //END JInit
    }

    public final void $Node() { assert this instanceof FoldingSetImpl.NodeImpl : "it is expected to be called only by FoldingSetImpl.Node sublcasses"; }
    public final void $Node(Node other) { 
      assert this instanceof FoldingSetImpl.NodeImpl : "it is expected to be called only by FoldingSetImpl.Node sublcasses"; 
      assert other instanceof FoldingSetImpl.NodeImpl : "it is expected to be called only by FoldingSetImpl.Node sublcasses"; 
      // could be copy of existing folding node i.e. see BugReporterVisitorImpl::clone$Visitor
      //assert ((FoldingSetImpl.NodeImpl)other).NextInFoldingSetBucket == null : "only not yet attached nodes can be copied";
      assert this.NextInFoldingSetBucket == null : "must be called on detached nodes";
    }
    
    // Accessors
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::getNextInBucket">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 144,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 143,
     FQN="llvm::FoldingSetImpl::Node::getNextInBucket", NM="_ZNK4llvm14FoldingSetImpl4Node15getNextInBucketEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl4Node15getNextInBucketEv")
    //</editor-fold>
    public Object/*void P*/ getNextInBucket() /*const*/ {
      return NextInFoldingSetBucket;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::SetNextInBucket">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 145,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 144,
     FQN="llvm::FoldingSetImpl::Node::SetNextInBucket", NM="_ZN4llvm14FoldingSetImpl4Node15SetNextInBucketEPv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4Node15SetNextInBucketEPv")
    //</editor-fold>
    public void SetNextInBucket(Object/*void P*/ N) {
      NextInFoldingSetBucket = N;
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public void Profile(FoldingSetNodeID /*&*/ ID) {
      throw new UnsupportedOperationException("Please, implement Profile in " + this.getClass() + " or use another FoldingSetTrait!");
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::Node">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 135,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 133,
     FQN="llvm::FoldingSetImpl::Node::Node", NM="_ZN4llvm14FoldingSetImpl4NodeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeC1ERKS1_")
    //</editor-fold>
    protected /*inline*/ NodeImpl(/*const*/ Node /*&*/ $Prm0) {
      /* : NextInFoldingSetBucket(.NextInFoldingSetBucket)*/ 
      //START JInit
      this.NextInFoldingSetBucket = $Prm0.getNextInBucket();
      //END JInit
    }

    
    public String toString() {
      // Do not print NextInFoldingSetBucket! It will cause recursion, because
      // the last one always contains reference to an array which holds this object!
      // The acceptable solution is to check whether NextInFoldingSetBucket implements
      // Node if it is nercessary to implement toString().
      //return "" + "NextInFoldingSetBucket=" + NextInFoldingSetBucket; // NOI18N
      return "";
    }
  };
  
  // Default implementation like @see NodeImpl which also tracks create/destroy for check$alive
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 133,
   FQN="llvm::FoldingSetImpl::Node", NM="_ZN4llvm14FoldingSetImpl4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeE")
  //</editor-fold>  
  public static class NodeImpl$Tracker extends NativeTrace.CreateDestroy$Tracker {
    private static final FoldingSetTrait TRAIT = new DefaultFoldingSetTrait<>();    
    public static <T> FoldingSetTrait<T> $Trait() { return TRAIT; }
    
  /*private:*/
    // NextInFoldingSetBucket - next link in the bucket list.
    private Object/*void P*/ NextInFoldingSetBucket;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::Node">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 141,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 140,
     FQN="llvm::FoldingSetImpl::Node::Node", NM="_ZN4llvm14FoldingSetImpl4NodeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeC1Ev")
    //</editor-fold>
    public NodeImpl$Tracker() {
      /* : NextInFoldingSetBucket(null)*/ 
      //START JInit
      this.NextInFoldingSetBucket = null;
      //END JInit
    }

    public final void $Node() { assert this instanceof FoldingSetImpl.NodeImpl$Tracker : "it is expected to be called only by FoldingSetImpl.Node sublcasses"; }
    public final void $Node(Node other) { 
      assert checkAlive() : "can be called on alive nodes";
      assert this instanceof FoldingSetImpl.NodeImpl$Tracker : "it is expected to be called only by FoldingSetImpl.Node sublcasses"; 
      assert other instanceof FoldingSetImpl.NodeImpl$Tracker : "it is expected to be called only by FoldingSetImpl.Node sublcasses"; 
      // could be copy of existing folding node i.e. see BugReporterVisitorImpl::clone$Visitor
      // assert ((FoldingSetImpl.NodeImpl$Tracker)other).NextInFoldingSetBucket == null : "only not yet attached nodes can be copied";
      assert ((FoldingSetImpl.NodeImpl$Tracker)other).checkAlive() : "only not yet destroyed nodes can be copied";
      assert this.NextInFoldingSetBucket == null : "must be called on detached nodes";
    }
    
    // Accessors
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::getNextInBucket">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 144,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 143,
     FQN="llvm::FoldingSetImpl::Node::getNextInBucket", NM="_ZNK4llvm14FoldingSetImpl4Node15getNextInBucketEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl4Node15getNextInBucketEv")
    //</editor-fold>
    public Object/*void P*/ getNextInBucket() /*const*/ {
      assert checkAlive() : "can be called on alive nodes";
      return NextInFoldingSetBucket;
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::SetNextInBucket">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 145,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 144,
     FQN="llvm::FoldingSetImpl::Node::SetNextInBucket", NM="_ZN4llvm14FoldingSetImpl4Node15SetNextInBucketEPv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4Node15SetNextInBucketEPv")
    //</editor-fold>
    public void SetNextInBucket(Object/*void P*/ N) {
      assert checkAlive() : "can be called on alive nodes";
      NextInFoldingSetBucket = N;
    }
    
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public void Profile(FoldingSetNodeID /*&*/ ID) {
      throw new UnsupportedOperationException("Please, implement Profile in " + this.getClass() + " or use another FoldingSetTrait!");
    }
    
    //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node::Node">
    @Converted(kind = Converted.Kind.MANUAL_ADDED,
     source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 135,
     old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 133,
     FQN="llvm::FoldingSetImpl::Node::Node", NM="_ZN4llvm14FoldingSetImpl4NodeC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Tooling.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeC1ERKS1_")
    //</editor-fold>
    protected /*inline*/ NodeImpl$Tracker(/*const*/ Node /*&*/ $Prm0) {
      /* : NextInFoldingSetBucket(.NextInFoldingSetBucket)*/ 
      //START JInit
      this.NextInFoldingSetBucket = $Prm0.getNextInBucket();
      //END JInit
    }

    public void $destroy$Node() {
      $destroy$NodeImpl();
    }

    public void $destroy$NodeImpl() {
      assert checkAlive();
      super.set$destroyed();
    }
    
    public String toString() {
      // Do not print NextInFoldingSetBucket! It will cause recursion, because
      // the last one always contains reference to an array which holds this object!
      // The acceptable solution is to check whether NextInFoldingSetBucket implements
      // Node if it is nercessary to implement toString().
      //return "" + "NextInFoldingSetBucket=" + NextInFoldingSetBucket; // NOI18N
      return super.is$destroyed() ? "DESTROYED " : "";
    }
    
    public final boolean checkAlive() {
      return super.check$Alive();
    }
  }
  
  // Default implementation but we don't mark it as implementing FoldingSetImpl.Node, interface is added to the real class
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::Node">
  @Converted(kind = Converted.Kind.MANUAL_ADDED,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 135,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 133,
   FQN="llvm::FoldingSetImpl::Node", NM="_ZN4llvm14FoldingSetImpl4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl4NodeE")
  //</editor-fold>
  public static class ContextualNodeImpl<Ctx> extends NodeImpl {
    @Converted(kind = Converted.Kind.MANUAL_ADDED)
    public void Profile(FoldingSetNodeID /*&*/ ID, Ctx C) {
      throw new UnsupportedOperationException("Please, implement Profile(ID, C) in " + this.getClass() + " or use another FoldingSetTrait!");
    }    
    
    private static final ContextualFoldingSetTrait CONTEXTUAL_TRAIT = new DefaultContextualFoldingSetTrait<>();    
    public static <T, Ctx> ContextualFoldingSetTrait<T, Ctx> $ContextualTrait() { return CONTEXTUAL_TRAIT; }    
  }  
  
  /// clear - Remove all nodes from the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::clear">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 258,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 235,
   FQN="llvm::FoldingSetImpl::clear", NM="_ZN4llvm14FoldingSetImpl5clearEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl5clearEv")
  //</editor-fold>
  public void clear() {
    // Set all but the last bucket to null pointers.
    memset(Buckets, null, NumBuckets * (true ? 1 : sizeof(Object.class/*void P*/ )));
    
    // Set the very last bucket to be a non-null "pointer".
    ((type$ptr)Buckets).$set(NumBuckets, EMPTY_NODE);
    
    // Reset the node count to zero.
    NumNodes = 0;
  }

  
  /// RemoveNode - Remove a node from the folding set, returning true if one
  /// was removed or false if the node was not in the folding set.
  
  /// RemoveNode - Remove a node from the folding set, returning true if one was
  /// removed or false if the node was not in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::RemoveNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 359,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 336,
   FQN="llvm::FoldingSetImpl::RemoveNode", NM="_ZN4llvm14FoldingSetImpl10RemoveNodeEPNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl10RemoveNodeEPNS0_4NodeE")
  //</editor-fold>
  public boolean RemoveNode(Node /*P*/ N) {
    // Because each bucket is a circular list, we don't need to compute N's hash
    // to remove it.
    Object/*void P*/ Ptr = N.getNextInBucket();
    if (!(Ptr != null)) {
      return false; // Not in folding set.
    }
    
    --NumNodes;
    N.SetNextInBucket((Object/*void P*/ )null);
    
    // Remember what N originally pointed to, either a bucket or another node.
    Object/*void P*/ NodeNextPtr = Ptr;
    
    // Chase around the list until we find the node (or bucket) which points to N.
    while (true) {
      {
        Node /*P*/ NodeInBucket = GetNextPtr(Ptr);
        if ((NodeInBucket != null)) {
          // Advance pointer.
          Ptr = NodeInBucket.getNextInBucket();
          
          // We found a node that points to N, change it to point to N's next node,
          // removing N from the list.
          if ($eq(Ptr, N, true)) {
            NodeInBucket.SetNextInBucket(NodeNextPtr);
            return true;
          }
        } else {
          type$ptr<Object>/*void PP*/ Bucket = $tryClone(GetBucketPtr(Ptr));
          Ptr = Bucket.$star();
          
          // If we found that the bucket points to N, update the bucket to point to
          // whatever is next.
          if ($eq(Ptr, N, true)) {
            Bucket.$set(NodeNextPtr);
            return true;
          }
        }
      }
    }
  }

  
  /// GetOrInsertNode - If there is an existing simple Node exactly
  /// equal to the specified node, return it.  Otherwise, insert 'N' and return
  /// it instead.
  
  /// GetOrInsertNode - If there is an existing simple Node exactly
  /// equal to the specified node, return it.  Otherwise, insert 'N' and it
  /// instead.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::GetOrInsertNode">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 400,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 377,
   FQN="llvm::FoldingSetImpl::GetOrInsertNode", NM="_ZN4llvm14FoldingSetImpl15GetOrInsertNodeEPNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl15GetOrInsertNodeEPNS0_4NodeE")
  //</editor-fold>
  public FoldingSetImpl.Node /*P*/ GetOrInsertNode(FoldingSetImpl.Node /*P*/ N) {
    FoldingSetNodeID ID = null;
    try {
      ID/*J*/= new FoldingSetNodeID();
      GetNodeProfile(N, ID);
      type$ref<type$ptr<T>>/*void P*/ IP = create_type$null$ref(null);
      {
        Node /*P*/ E = FindNodeOrInsertPosImpl(ID, IP);
        if ((E != null)) {
          return E;
        }
      }
      InsertNode(N, IP.$deref());
      return N;
    } finally {
      if (ID != null) { ID.$destroy(); }
    }
  }

  
  /// FindNodeOrInsertPos - Look up the node specified by ID.  If it exists,
  /// return it.  If not, return the insertion token that will make insertion
  /// faster.
  
  /// FindNodeOrInsertPos - Look up the node specified by ID.  If it exists,
  /// return it.  If not, return the insertion token that will make insertion
  /// faster.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::FindNodeOrInsertPos">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 304,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 281,
   FQN="llvm::FoldingSetImpl::FindNodeOrInsertPos", NM="_ZN4llvm14FoldingSetImpl19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl19FindNodeOrInsertPosERKNS_16FoldingSetNodeIDERPv")
  //</editor-fold>
  protected FoldingSetImpl.Node /*P*/ FindNodeOrInsertPosImpl(/*const*/ FoldingSetNodeID /*&*/ ID, 
                     final type$ref<type$ptr<T>>/*void P&*/ InsertPos) {
    FoldingSetNodeID TempID = null;
    try {
      /*uint*/int IDHash = ID.ComputeHash();
      type$ptr<T>/*void PP*/ Bucket = $tryClone(GetBucketFor(IDHash, Buckets, NumBuckets));
      Object/*void P*/ Probe = Bucket.$star();
      
      InsertPos.$set(null);
      
      TempID/*J*/= new FoldingSetNodeID();
      {
        Node /*P*/ NodeInBucket;
        while (((/*P*/ NodeInBucket = GetNextPtr(Probe)) != null)) {
          if (NodeEquals(NodeInBucket, ID, IDHash, TempID)) {
            return NodeInBucket;
          }
          TempID.clear();
          
          Probe = NodeInBucket.getNextInBucket();
        }
      }
      
      // Didn't find the node, return null with the bucket as the InsertPos.
      InsertPos.$set(Bucket);
      return null;
    } finally {
      if (TempID != null) { TempID.$destroy(); }
    }
  }

  
  /// InsertNode - Insert the specified node into the folding set, knowing that
  /// it is not already in the folding set.  InsertPos must be obtained from
  /// FindNodeOrInsertPos.
  
  /// InsertNode - Insert the specified node into the folding set, knowing that it
  /// is not already in the map.  InsertPos must be obtained from 
  /// FindNodeOrInsertPos.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::InsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 330,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 307,
   FQN="llvm::FoldingSetImpl::InsertNode", NM="_ZN4llvm14FoldingSetImpl10InsertNodeEPNS0_4NodeEPv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl10InsertNodeEPNS0_4NodeEPv")
  //</editor-fold>
  public void InsertNode(Node /*P*/ N, type$ptr<? extends T>/*void P*/ InsertPos) {
    assert (!(N.getNextInBucket() != null));
    // Do we need to grow the hashtable?
    if ($greater_uint(NumNodes + 1, NumBuckets * 2)) {
      GrowHashTable();
      FoldingSetNodeID  TempID/*J*/= new FoldingSetNodeID();
      InsertPos = $tryClone(GetBucketFor(ComputeNodeHash(N, TempID), Buckets, NumBuckets));
    }
    
    ++NumNodes;
    
    /// The insert position is actually a bucket pointer.
    type$ptr<Object>/*void PP*/ Bucket = $tryClone(((/*static_cast*/type$ptr<Object>/*void PP*/ )(InsertPos)));
    
    Object/*void P*/ Next = Bucket.$star();
    
    // If this is the first insertion into this bucket, its next pointer will be
    // null.  Pretend as if it pointed to itself, setting the low bit to indicate
    // that it is a pointer to the bucket.
    if (!(Next != null)) {
      // >>>>>>>>>>>
      //Next = reinterpret_cast(Object/*void P*/ .class, reinterpret_cast_Object/*intptr_t*/(Bucket) | 1);
      // <<<<<<<<<<<
      // JAVA: implemented interface is natural distinguisher whether ptr points to Node or to Bucket.
      Next = Bucket;
      // >>>>>>>>>>>
    }
    
    // Set the node's next pointer, and make the bucket point to the node.
    N.SetNextInBucket(Next);
    Bucket.$set(N);
    
    if (NativeTrace.isDebugMode()) {
      FoldingSetNodeID TempID/*J*/= new FoldingSetNodeID();
      GetNodeProfile(N, TempID);
      type$ref<type$ptr<T>/*void P*/ > TmpInsertPos = create_type$null$ref(null);
      Node Found = FindNodeOrInsertPosImpl(TempID, TmpInsertPos);
      assert Found == N : "incorrect Profile? found\n " + Found + "\n right after insert:\n " + N;
    }
  }

  
  /// InsertNode - Insert the specified node into the folding set, knowing that
  /// it is not already in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::InsertNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 172,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 171,
   FQN="llvm::FoldingSetImpl::InsertNode", NM="_ZN4llvm14FoldingSetImpl10InsertNodeEPNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl10InsertNodeEPNS0_4NodeE")
  //</editor-fold>
  public void InsertNode(Node /*P*/ N) {
    Node /*P*/ Inserted = GetOrInsertNode(N);
    //(void)Inserted;
    assert (Inserted == N) : "Node already inserted!";
  }

  
  /// size - Returns the number of nodes in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 179,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 178,
   FQN="llvm::FoldingSetImpl::size", NM="_ZNK4llvm14FoldingSetImpl4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumNodes;
  }

  
  /// empty - Returns true if there are no nodes in the folding set.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 181,
   FQN="llvm::FoldingSetImpl::empty", NM="_ZNK4llvm14FoldingSetImpl5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return NumNodes == 0;
  }

  /// reserve - Increase the number of buckets such that adding the
  /// EltCount-th node won't cause a rebucket operation. reserve is permitted
  /// to allocate more space than requested by EltCount.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 307,
   FQN="llvm::FoldingSetImpl::reserve", NM="_ZN4llvm14FoldingSetImpl7reserveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl7reserveEj")
  //</editor-fold>
  public void reserve(/*uint*/int EltCount) {
    // This will give us somewhere between EltCount / 2 and
    // EltCount buckets.  This puts us in the load factor
    // range of 1.0 - 2.0.
    if ($less_uint(EltCount, capacity())) {
      return;
    }
    GrowBucketCount($ulong2uint(PowerOf2Floor($uint2ulong(EltCount))));
  }

  /// capacity - Returns the number of nodes permitted in the folding set
  /// before a rebucket operation is performed.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::capacity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 189,
   FQN="llvm::FoldingSetImpl::capacity", NM="_ZN4llvm14FoldingSetImpl8capacityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl8capacityEv")
  //</editor-fold>
  public /*uint*/int capacity() {
    // We allow a load factor of up to 2.0,
    // so that means our capacity is NumBuckets * 2
    return NumBuckets * 2;
  }
  
/*private:*/
  /// GrowHashTable - Double the size of the hash table and rehash everything.
  
  /// GrowHashTable - Double the size of the hash table and rehash everything.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::GrowHashTable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 303,
   old_source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", old_line = 271,
   FQN="llvm::FoldingSetImpl::GrowHashTable", NM="_ZN4llvm14FoldingSetImpl13GrowHashTableEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl13GrowHashTableEv")
  //</editor-fold>
  private void GrowHashTable() {
    GrowBucketCount(NumBuckets * 2);
  }
  
  /// GrowBucketCount - resize the hash table and rehash everything.
  /// NewBucketCount must be a power of two, and must be greater than the old
  /// bucket count.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::GrowBucketCount">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp", line = 269,
   FQN="llvm::FoldingSetImpl::GrowBucketCount", NM="_ZN4llvm14FoldingSetImpl15GrowBucketCountEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZN4llvm14FoldingSetImpl15GrowBucketCountEj")
  //</editor-fold>
  private void GrowBucketCount(/*uint*/int NewBucketCount) {  
    assert (($greater_uint(NewBucketCount, NumBuckets))) : "Can't shrink a folding set with GrowBucketCount";
    assert (isPowerOf2_32(NewBucketCount)) : "Bad bucket count!";
    type$ptr<T>/*void PP*/ OldBuckets = $tryClone(Buckets);
    /*uint*/int OldNumBuckets = NumBuckets;
    NumBuckets = NewBucketCount;
    
    // Clear out new buckets.
    Buckets = $toConst(AllocateBuckets(NumBuckets));
    NumNodes = 0;
    
    // Walk the old buckets, rehashing nodes into their new place.
    FoldingSetNodeID TempID/*J*/= new FoldingSetNodeID();
    for (/*uint*/int i = 0; i != OldNumBuckets; ++i) {
      Object/*void P*/ Probe = OldBuckets.$at(i);
      if (!(Probe != null)) {
        continue;
      }
      {
        Node /*P*/ NodeInBucket;
        while (((/*P*/ NodeInBucket = GetNextPtr(Probe)) != null)) {
          // Figure out the next link, remove NodeInBucket from the old link.
          Probe = NodeInBucket.getNextInBucket();
          NodeInBucket.SetNextInBucket((Object/*void P*/ )null);
          
          // Insert the node into the new bucket, after recomputing the hash.
          InsertNode(NodeInBucket, 
              GetBucketFor(ComputeNodeHash(NodeInBucket, TempID), 
                  Buckets, NumBuckets));
          TempID.clear();
        }
      }
    }
    
    free(OldBuckets);
  }

/*protected:*/
  /// GetNodeProfile - Instantiations of the FoldingSet template implement
  /// this function to gather data bits for the given node.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::GetNodeProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 192,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 193,
   FQN="llvm::FoldingSetImpl::GetNodeProfile", NM="_ZNK4llvm14FoldingSetImpl14GetNodeProfileEPNS0_4NodeERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl14GetNodeProfileEPNS0_4NodeERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  protected abstract /*virtual*/ void GetNodeProfile(Node /*P*/ N, FoldingSetNodeID /*&*/ ID) /*const*//* = 0*/;

  /// NodeEquals - Instantiations of the FoldingSet template implement
  /// this function to compare the given node with the given ID.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::NodeEquals">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 196,
   FQN="llvm::FoldingSetImpl::NodeEquals", NM="_ZNK4llvm14FoldingSetImpl10NodeEqualsEPNS0_4NodeERKNS_16FoldingSetNodeIDEjRS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl10NodeEqualsEPNS0_4NodeERKNS_16FoldingSetNodeIDEjRS3_")
  //</editor-fold>
  protected abstract /*virtual*/ boolean NodeEquals(Node /*P*/ N, /*const*/ FoldingSetNodeID /*&*/ ID, /*uint*/int IDHash, 
            FoldingSetNodeID /*&*/ TempID) /*const*//* = 0*/;

  /// ComputeNodeHash - Instantiations of the FoldingSet template implement
  /// this function to compute a hash value for the given node.
  //<editor-fold defaultstate="collapsed" desc="llvm::FoldingSetImpl::ComputeNodeHash">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", line = 199,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/FoldingSet.h", old_line = 200,
   FQN="llvm::FoldingSetImpl::ComputeNodeHash", NM="_ZNK4llvm14FoldingSetImpl15ComputeNodeHashEPNS0_4NodeERNS_16FoldingSetNodeIDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/FoldingSet.cpp -nm=_ZNK4llvm14FoldingSetImpl15ComputeNodeHashEPNS0_4NodeERNS_16FoldingSetNodeIDE")
  //</editor-fold>
  protected abstract /*virtual*/ /*uint*/int ComputeNodeHash(Node /*P*/ N, FoldingSetNodeID /*&*/ TempID) /*const*//* = 0*/;

  public abstract java.util.Iterator<T> iterator();
  
  public String toString() {
    String msg = "" + "Buckets=" + NativeTrace.getIdentityStr(Buckets) // NOI18N
              + ", NumBuckets=" + NumBuckets // NOI18N
              + ", NumNodes=" + NumNodes; // NOI18N
    StringBuilder out = new StringBuilder(msg);
    int idx = 0;
    for (T elem : this) {
      out.append("\n[").append(NativeTrace.formatNumber(idx++, 2)).append("]");
      out.append("{").append(elem).append("}");
    }
    return out.toString();
  }
}
