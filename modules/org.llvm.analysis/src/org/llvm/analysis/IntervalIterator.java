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

package org.llvm.analysis;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;

/*template <class NodeTy, class OrigContainer_t, class GT = GraphTraits<NodeTy *>, class IGT = GraphTraits<Inverse<NodeTy *> >> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 88,
 FQN="llvm::IntervalIterator", NM="_ZN4llvm16IntervalIteratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorE")
//</editor-fold>
public class IntervalIterator</*class*/ NodeTy, /*class*/ OrigContainer_t>//, /*class*/ GT/* = GraphTraits<NodeTy *>*/, /*class*/ IGT/* = GraphTraits<Inverse<NodeTy *> >*/>
        implements Destructors.ClassWithDestructor, Native.NativeComparable<IntervalIterator> {
  private std.vector<std.pair<Interval /*P*/ , std.vector.iterator<BasicBlock /*P*/ > >> IntStack;
  private std.setPtr<BasicBlock /*P*/ > Visited;
  private OrigContainer_t /*P*/ OrigContainer;
  private boolean IOwnMem; // If True, delete intervals when done with them
  // See file header for conditions of use
/*public:*/
  // JAVA: typedef std::forward_iterator_tag iterator_category
//  public final class iterator_category extends std.forward_iterator_tag{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 99,
   FQN="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>", NM="_ZN4llvm16IntervalIteratorC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorC1Ev")
  //</editor-fold>
  public IntervalIterator() {
    throw new UnsupportedOperationException("EmptyBody");
  }
 // End iterator, empty stack
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 100,
   FQN="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>", NM="_ZN4llvm16IntervalIteratorC1EPNS_8FunctionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorC1EPNS_8FunctionEb")
  //</editor-fold>
  public IntervalIterator(Function /*P*/ M, boolean OwnMemory) {
    // : IOwnMem(OwnMemory) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 107,
   FQN="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>", NM="_ZN4llvm16IntervalIteratorC1EONS_16IntervalIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorC1EONS_16IntervalIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public IntervalIterator(JD$Move _dparam, final IntervalIterator<NodeTy, OrigContainer_t/*, GT, IGT*/> /*&&*/x) {
    // : IntStack(std::move(x.IntStack)), Visited(std::move(x.Visited)), OrigContainer(x.OrigContainer), IOwnMem(x.IOwnMem) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 113,
   FQN="llvm::IntervalIterator::IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>", NM="_ZN4llvm16IntervalIteratorC1ERNS_17IntervalPartitionEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorC1ERNS_17IntervalPartitionEb")
  //</editor-fold>
  public IntervalIterator(final IntervalPartition /*&*/ IP, boolean OwnMemory) {
    // : IOwnMem(OwnMemory) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::~IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 120,
   FQN="llvm::IntervalIterator::~IntervalIterator<NodeTy, OrigContainer_t, GT, IGT>", NM="_ZN4llvm16IntervalIteratorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator==">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 128,
   FQN="llvm::IntervalIterator::operator==", NM="_ZNK4llvm16IntervalIteratoreqERKNS_16IntervalIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm16IntervalIteratoreqERKNS_16IntervalIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public boolean $eq(final /*const*/ IntervalIterator<NodeTy, OrigContainer_t/*, GT, IGT*/> /*&*/ x) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator!=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 131,
   FQN="llvm::IntervalIterator::operator!=", NM="_ZNK4llvm16IntervalIteratorneERKNS_16IntervalIteratorIT_T0_T1_T2_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm16IntervalIteratorneERKNS_16IntervalIteratorIT_T0_T1_T2_EE")
  //</editor-fold>
  public boolean $noteq(final /*const*/ IntervalIterator<NodeTy, OrigContainer_t/*, GT, IGT*/> /*&*/ x) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 133,
   FQN="llvm::IntervalIterator::operator*", NM="_ZNK4llvm16IntervalIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm16IntervalIteratordeEv")
  //</editor-fold>
  public /*const*/ Interval /*P*/ $star$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator*">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 134,
   FQN="llvm::IntervalIterator::operator*", NM="_ZN4llvm16IntervalIteratordeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratordeEv")
  //</editor-fold>
  public Interval /*P*/ $star() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 135,
   FQN="llvm::IntervalIterator::operator->", NM="_ZNK4llvm16IntervalIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZNK4llvm16IntervalIteratorptEv")
  //</editor-fold>
  public /*const*/ Interval /*P*/ $arrow$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator->">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 136,
   FQN="llvm::IntervalIterator::operator->", NM="_ZN4llvm16IntervalIteratorptEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorptEv")
  //</editor-fold>
  public Interval /*P*/ $arrow() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 138,
   FQN="llvm::IntervalIterator::operator++", NM="_ZN4llvm16IntervalIteratorppEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorppEv")
  //</editor-fold>
  public IntervalIterator<NodeTy, OrigContainer_t/*, GT, IGT*/> /*&*/ $preInc() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::operator++">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 160,
   FQN="llvm::IntervalIterator::operator++", NM="_ZN4llvm16IntervalIteratorppEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIteratorppEi")
  //</editor-fold>
  public IntervalIterator<NodeTy, OrigContainer_t/*, GT, IGT*/> $postInc(int $Prm0) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*private:*/
  // ProcessInterval - This method is used during the construction of the
  // interval graph.  It walks through the source graph, recursively creating
  // an interval per invocation until the entire graph is covered.  This uses
  // the ProcessNode method to add all of the nodes to the interval.
  //
  // This method is templated because it may operate on two different source
  // graphs: a basic block graph, or a preexisting interval graph.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::ProcessInterval">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 175,
   FQN="llvm::IntervalIterator::ProcessInterval", NM="_ZN4llvm16IntervalIterator15ProcessIntervalEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIterator15ProcessIntervalEPT_")
  //</editor-fold>
  private boolean ProcessInterval(NodeTy /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // ProcessNode - This method is called by ProcessInterval to add nodes to the
  // interval being constructed, and it is also called recursively as it walks
  // the source graph.  A node is added to the current interval only if all of
  // its predecessors are already in the graph.  This also takes care of keeping
  // the successor set of an interval up to date.
  //
  // This method is templated because it may operate on two different source
  // graphs: a basic block graph, or a preexisting interval graph.
  //
  //<editor-fold defaultstate="collapsed" desc="llvm::IntervalIterator::ProcessNode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 200,
   FQN="llvm::IntervalIterator::ProcessNode", NM="_ZN4llvm16IntervalIterator11ProcessNodeEPNS_8IntervalEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm16IntervalIterator11ProcessNodeEPNS_8IntervalEPT_")
  //</editor-fold>
  private void ProcessNode(Interval /*P*/ Int, NodeTy /*P*/ Node) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "IntStack=" + IntStack // NOI18N
              + ", Visited=" + Visited // NOI18N
              + ", OrigContainer=" + OrigContainer // NOI18N
              + ", IOwnMem=" + IOwnMem; // NOI18N
  }
}
