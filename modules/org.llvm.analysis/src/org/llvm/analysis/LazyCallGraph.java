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

import java.util.Iterator;
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
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;


/// A lazily constructed view of the call graph of a module.
///
/// With the edges of this graph, the motivating constraint that we are
/// attempting to maintain is that function-local optimization, CGSCC-local
/// optimizations, and optimizations transforming a pair of functions connected
/// by an edge in the graph, do not invalidate a bottom-up traversal of the SCC
/// DAG. That is, no optimizations will delete, remove, or add an edge such
/// that functions already visited in a bottom-up order of the SCC DAG are no
/// longer valid to have visited, or such that functions not yet visited in
/// a bottom-up order of the SCC DAG are not required to have already been
/// visited.
///
/// Within this constraint, the desire is to minimize the merge points of the
/// SCC DAG. The greater the fanout of the SCC DAG and the fewer merge points
/// in the SCC DAG, the more independence there is in optimizing within it.
/// There is a strong desire to enable parallelization of optimizations over
/// the call graph, and both limited fanout and merge points will (artificially
/// in some cases) limit the scaling of such an effort.
///
/// To this end, graph represents both direct and any potential resolution to
/// an indirect call edge. Another way to think about it is that it represents
/// both the direct call edges and any direct call edges that might be formed
/// through static optimizations. Specifically, it considers taking the address
/// of a function to be an edge in the call graph because this might be
/// forwarded to become a direct call by some subsequent function-local
/// optimization. The result is that the graph closely follows the use-def
/// edges for functions. Walking "up" the graph can be done by looking at all
/// of the uses of a function.
///
/// The roots of the call graph are the external functions and functions
/// escaped into global variables. Those functions can be called from outside
/// of the module or via unknowable means in the IR -- we may not be able to
/// form even a potential call edge from a function body which may dynamically
/// load the function and call it.
///
/// This analysis still requires updates to remain valid after optimizations
/// which could potentially change the set of potential callees. The
/// constraints it operates under only make the traversal order remain valid.
///
/// The entire analysis must be re-computed if full interprocedural
/// optimizations run at any point. For example, globalopt completely
/// invalidates the information in this analysis.
///
/// FIXME: This class is named LazyCallGraph in a lame attempt to distinguish
/// it from the existing CallGraph. At some point, it is expected that this
/// will be the only call graph and it will be renamed accordingly.
//<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 105,
 FQN="llvm::LazyCallGraph", NM="_ZN4llvm13LazyCallGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraphE")
//</editor-fold>
public class LazyCallGraph implements Destructors.ClassWithDestructor {
/*public:*/
  
  /// A node in the call graph.
  ///
  /// This represents a single node. It's primary roles are to cache the list of
  /// callees, de-duplicate and provide fast testing of whether a function is
  /// a callee, and facilitate iteration of child nodes in the graph.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 194,
   FQN="llvm::LazyCallGraph::Node", NM="_ZN4llvm13LazyCallGraph4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4NodeE")
  //</editor-fold>
  public static class Node implements Destructors.ClassWithDestructor, Native.NativeComparable<Node> {
    /*friend  class LazyCallGraph*/
    /*friend  class LazyCallGraph::SCC*/
    
    private LazyCallGraph /*P*/ G;
    private final Function /*&*/ F;
    
    // We provide for the DFS numbering and Tarjan walk lowlink numbers to be
    // stored directly within the node. These are both '-1' when nodes are part
    // of an SCC (or RefSCC), or '0' when not yet reached in a DFS walk.
    private int DFSNumber;
    private int LowLink;
    
    private /*mutable */SmallVector<Edge> Edges;
    private DenseMapTypeInt<Function /*P*/ > EdgeIndexMap;
    
    /// Basic constructor implements the scanning of F into Edges and
    /// EdgeIndexMap.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::Node">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 61,
     FQN="llvm::LazyCallGraph::Node::Node", NM="_ZN4llvm13LazyCallGraph4NodeC1ERS0_RNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4NodeC1ERS0_RNS_8FunctionE")
    //</editor-fold>
    private Node(final LazyCallGraph /*&*/ G, final Function /*&*/ F) {
      // : G(&G), F(F), DFSNumber(0), LowLink(0), Edges(), EdgeIndexMap() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Internal helper to insert an edge to a function.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::insertEdgeInternal">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 96,
     FQN="llvm::LazyCallGraph::Node::insertEdgeInternal", NM="_ZN4llvm13LazyCallGraph4Node18insertEdgeInternalERNS_8FunctionENS0_4Edge4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Node18insertEdgeInternalERNS_8FunctionENS0_4Edge4KindE")
    //</editor-fold>
    private void insertEdgeInternal(final Function /*&*/ Target, Edge.Kind EK) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Internal helper to insert an edge to a node.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::insertEdgeInternal">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 104,
     FQN="llvm::LazyCallGraph::Node::insertEdgeInternal", NM="_ZN4llvm13LazyCallGraph4Node18insertEdgeInternalERS1_NS0_4Edge4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Node18insertEdgeInternalERS1_NS0_4Edge4KindE")
    //</editor-fold>
    private void insertEdgeInternal(final Node /*&*/ TargetN, Edge.Kind EK) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Internal helper to change an edge kind.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::setEdgeKind">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 109,
     FQN="llvm::LazyCallGraph::Node::setEdgeKind", NM="_ZN4llvm13LazyCallGraph4Node11setEdgeKindERNS_8FunctionENS0_4Edge4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Node11setEdgeKindERNS_8FunctionENS0_4Edge4KindE")
    //</editor-fold>
    private void setEdgeKind(final Function /*&*/ TargetF, Edge.Kind EK) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Internal helper to remove the edge to the given function.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::removeEdgeInternal">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 113,
     FQN="llvm::LazyCallGraph::Node::removeEdgeInternal", NM="_ZN4llvm13LazyCallGraph4Node18removeEdgeInternalERNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Node18removeEdgeInternalERNS_8FunctionE")
    //</editor-fold>
    private void removeEdgeInternal(final Function /*&*/ Target) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Print the name of this node's function.
    /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 227,
     FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_13LazyCallGraph4NodeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_13LazyCallGraph4NodeE")
    //</editor-fold>
    public static raw_ostream /*&*/ $out_raw_ostream_Node$C(final raw_ostream /*&*/ OS, final /*const*/ LazyCallGraph.Node /*&*/ N) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Dump the name of this node's function to stderr.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 122,
     FQN="llvm::LazyCallGraph::Node::dump", NM="_ZNK4llvm13LazyCallGraph4Node4dumpEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node4dumpEv")
    //</editor-fold>
    private void dump() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::getGraph">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 235,
     FQN="llvm::LazyCallGraph::Node::getGraph", NM="_ZNK4llvm13LazyCallGraph4Node8getGraphEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node8getGraphEv")
    //</editor-fold>
    public LazyCallGraph /*&*/ getGraph() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::getFunction">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 237,
     FQN="llvm::LazyCallGraph::Node::getFunction", NM="_ZNK4llvm13LazyCallGraph4Node11getFunctionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node11getFunctionEv")
    //</editor-fold>
    public Function /*&*/ getFunction() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::begin">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 239,
     FQN="llvm::LazyCallGraph::Node::begin", NM="_ZNK4llvm13LazyCallGraph4Node5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node5beginEv")
    //</editor-fold>
    public edge_iterator begin() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::end">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 242,
     FQN="llvm::LazyCallGraph::Node::end", NM="_ZNK4llvm13LazyCallGraph4Node3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node3endEv")
    //</editor-fold>
    public edge_iterator end() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::operator[]">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 244,
     FQN="llvm::LazyCallGraph::Node::operator[]", NM="_ZNK4llvm13LazyCallGraph4NodeixEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4NodeixEi")
    //</editor-fold>
    public /*const*/ Edge /*&*/ $at(int i) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::operator[]">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 245,
     FQN="llvm::LazyCallGraph::Node::operator[]", NM="_ZNK4llvm13LazyCallGraph4NodeixERNS_8FunctionE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4NodeixERNS_8FunctionE")
    //</editor-fold>
    public /*const*/ Edge /*&*/ $at(final Function /*&*/ F) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::operator[]">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 249,
     FQN="llvm::LazyCallGraph::Node::operator[]", NM="_ZNK4llvm13LazyCallGraph4NodeixERS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4NodeixERS1_")
    //</editor-fold>
    public /*const*/ Edge /*&*/ $at(final Node /*&*/ N) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::call_begin">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 251,
     FQN="llvm::LazyCallGraph::Node::call_begin", NM="_ZNK4llvm13LazyCallGraph4Node10call_beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node10call_beginEv")
    //</editor-fold>
    public call_edge_iterator call_begin() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::call_end">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 254,
     FQN="llvm::LazyCallGraph::Node::call_end", NM="_ZNK4llvm13LazyCallGraph4Node8call_endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node8call_endEv")
    //</editor-fold>
    public call_edge_iterator call_end() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::calls">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 258,
     FQN="llvm::LazyCallGraph::Node::calls", NM="_ZNK4llvm13LazyCallGraph4Node5callsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Node5callsEv")
    //</editor-fold>
    public iterator_range<call_edge_iterator> calls() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Equality is defined as address equality.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::operator==">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 263,
     FQN="llvm::LazyCallGraph::Node::operator==", NM="_ZNK4llvm13LazyCallGraph4NodeeqERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4NodeeqERKS1_")
    //</editor-fold>
    public boolean $eq(final /*const*/ Node /*&*/ N) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::operator!=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 264,
     FQN="llvm::LazyCallGraph::Node::operator!=", NM="_ZNK4llvm13LazyCallGraph4NodeneERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4NodeneERKS1_")
    //</editor-fold>
    public boolean $noteq(final /*const*/ Node /*&*/ N) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Node::~Node">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 194,
     FQN="llvm::LazyCallGraph::Node::~Node", NM="_ZN4llvm13LazyCallGraph4NodeD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4NodeD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "G=" + G // NOI18N
                + ", F=" + F // NOI18N
                + ", DFSNumber=" + DFSNumber // NOI18N
                + ", LowLink=" + LowLink // NOI18N
                + ", Edges=" + Edges // NOI18N
                + ", EdgeIndexMap=" + EdgeIndexMap; // NOI18N
    }
  };
  
  /// An SCC of the call graph.
  ///
  /// This represents a Strongly Connected Component of the direct call graph
  /// -- ignoring indirect calls and function references. It stores this as
  /// a collection of call graph nodes. While the order of nodes in the SCC is
  /// stable, it is not any particular order.
  ///
  /// The SCCs are nested within a \c RefSCC, see below for details about that
  /// outer structure. SCCs do not support mutation of the call graph, that
  /// must be done through the containing \c RefSCC in order to fully reason
  /// about the ordering and connections of the graph.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 349,
   FQN="llvm::LazyCallGraph::SCC", NM="_ZN4llvm13LazyCallGraph3SCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph3SCCE")
  //</editor-fold>
  public static class SCC implements Iterable<Node /*P*/>, Destructors.ClassWithDestructor {
    /*friend  class LazyCallGraph*/
    /*friend  class LazyCallGraph::Node*/
    
    private RefSCC /*P*/ OuterRefSCC;
    private SmallVector<Node /*P*/ > Nodes;
    
    /*template <typename NodeRangeT> TEMPLATE*/
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::SCC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 357,
     FQN="llvm::LazyCallGraph::SCC::SCC", NM="Tpl__ZN4llvm13LazyCallGraph3SCCC1ERNS0_6RefSCCEOT_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=Tpl__ZN4llvm13LazyCallGraph3SCCC1ERNS0_6RefSCCEOT_")
    //</editor-fold>
    private </*typename*/ NodeRangeT> SCC(final RefSCC /*&*/ OuterRefSCC, final NodeRangeT /*&&*/Nodes) {
      // : OuterRefSCC(&OuterRefSCC), Nodes(std::forward<NodeRangeT>(Nodes)) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::clear">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 360,
     FQN="llvm::LazyCallGraph::SCC::clear", NM="_ZN4llvm13LazyCallGraph3SCC5clearEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph3SCC5clearEv")
    //</editor-fold>
    private void clear() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Print a short descrtiption useful for debugging or logging.
    ///
    /// We print the function names in the SCC wrapped in '()'s and skipping
    /// the middle functions if there are a large number.
    //
    // Note: this is defined inline to dodge issues with GCC's interpretation
    // of enclosing namespaces for friend function declarations.
    /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 372,
     FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_13LazyCallGraph3SCCE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_13LazyCallGraph3SCCE")
    //</editor-fold>
    public static raw_ostream /*&*/ $out_raw_ostream_SCC$C(final raw_ostream /*&*/ OS, final /*const*/ LazyCallGraph.SCC /*&*/ C) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Dump a short description of this SCC to stderr.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 179,
     FQN="llvm::LazyCallGraph::SCC::dump", NM="_ZNK4llvm13LazyCallGraph3SCC4dumpEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph3SCC4dumpEv")
    //</editor-fold>
    private void dump() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    /// Verify invariants about the SCC.
    ///
    /// This will attempt to validate all of the basic invariants within an
    /// SCC, but not that it is a strongly connected componet per-se. Primarily
    /// useful while building and updating the graph to check that basic
    /// properties are in place rather than having inexplicable crashes later.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::verify">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 184,
     FQN="llvm::LazyCallGraph::SCC::verify", NM="_ZN4llvm13LazyCallGraph3SCC6verifyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph3SCC6verifyEv")
    //</editor-fold>
    private void verify() {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    // JAVA: typedef pointee_iterator<SmallVectorImpl<Node *>::const_iterator> iterator
//    public final class iterator extends pointee_iterator<type$ptr<Node /*P*/ /*P*/> >{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::begin">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 406,
     FQN="llvm::LazyCallGraph::SCC::begin", NM="_ZNK4llvm13LazyCallGraph3SCC5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph3SCC5beginEv")
    //</editor-fold>
    public pointee_iterator<type$ptr<Node /*P*/ /*P*/> > begin() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::end">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 407,
     FQN="llvm::LazyCallGraph::SCC::end", NM="_ZNK4llvm13LazyCallGraph3SCC3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph3SCC3endEv")
    //</editor-fold>
    public pointee_iterator<type$ptr<Node /*P*/ /*P*/> > end() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::size">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 409,
     FQN="llvm::LazyCallGraph::SCC::size", NM="_ZNK4llvm13LazyCallGraph3SCC4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph3SCC4sizeEv")
    //</editor-fold>
    public int size() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::getOuterRefSCC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 411,
     FQN="llvm::LazyCallGraph::SCC::getOuterRefSCC", NM="_ZNK4llvm13LazyCallGraph3SCC14getOuterRefSCCEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph3SCC14getOuterRefSCCEv")
    //</editor-fold>
    public RefSCC /*&*/ getOuterRefSCC() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Provide a short name by printing this SCC to a std::string.
    ///
    /// This copes with the fact that we don't have a name per-se for an SCC
    /// while still making the use of this in debugging and logging useful.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::getName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 417,
     FQN="llvm::LazyCallGraph::SCC::getName", NM="_ZNK4llvm13LazyCallGraph3SCC7getNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph3SCC7getNameEv")
    //</editor-fold>
    public std.string getName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::SCC::~SCC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 349,
     FQN="llvm::LazyCallGraph::SCC::~SCC", NM="_ZN4llvm13LazyCallGraph3SCCD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph3SCCD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    @Override
    public Iterator<Node> iterator() {
      return new JavaIterator<>(begin(), end());
    }
    
    @Override public String toString() {
      return "" + "OuterRefSCC=" + OuterRefSCC // NOI18N
                + ", Nodes=" + Nodes; // NOI18N
    }
  };
  
  /// A RefSCC of the call graph.
  ///
  /// This models a Strongly Connected Component of function reference edges in
  /// the call graph. As opposed to actual SCCs, these can be used to scope
  /// subgraphs of the module which are independent from other subgraphs of the
  /// module because they do not reference it in any way. This is also the unit
  /// where we do mutation of the graph in order to restrict mutations to those
  /// which don't violate this independence.
  ///
  /// A RefSCC contains a DAG of actual SCCs. All the nodes within the RefSCC
  /// are necessarily within some actual SCC that nests within it. Since
  /// a direct call *is* a reference, there will always be at least one RefSCC
  /// around any SCC.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 439,
   FQN="llvm::LazyCallGraph::RefSCC", NM="_ZN4llvm13LazyCallGraph6RefSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCCE")
  //</editor-fold>
  public static class RefSCC implements Destructors.ClassWithDestructor {
    /*friend  class LazyCallGraph*/
    /*friend  class LazyCallGraph::Node*/
    
    private LazyCallGraph /*P*/ G;
    private SmallPtrSet<RefSCC /*P*/ > Parents;
    
    /// A postorder list of the inner SCCs.
    private SmallVector<SCC /*P*/ > SCCs;
    
    /// A map from SCC to index in the postorder list.
    private SmallDenseMapTypeInt<SCC /*P*/ > SCCIndices;
    
    /// Fast-path constructor. RefSCCs should instead be constructed by calling
    /// formRefSCCFast on the graph itself.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::RefSCC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 202,
     FQN="llvm::LazyCallGraph::RefSCC::RefSCC", NM="_ZN4llvm13LazyCallGraph6RefSCCC1ERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCCC1ERS0_")
    //</editor-fold>
    private RefSCC(final LazyCallGraph /*&*/ G) {
      // : G(&G), Parents(), SCCs(), SCCIndices() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Print a short description useful for debugging or logging.
    ///
    /// We print the SCCs wrapped in '[]'s and skipping the middle SCCs if
    /// there are a large number.
    //
    // Note: this is defined inline to dodge issues with GCC's interpretation
    // of enclosing namespaces for friend function declarations.
    /*friend*///<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 463,
     FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_13LazyCallGraph6RefSCCE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_13LazyCallGraph6RefSCCE")
    //</editor-fold>
    public static raw_ostream /*&*/ $out_raw_ostream_RefSCC$C(final raw_ostream /*&*/ OS, final /*const*/ LazyCallGraph.RefSCC /*&*/ RC) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Dump a short description of this RefSCC to stderr.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::dump">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 204,
     FQN="llvm::LazyCallGraph::RefSCC::dump", NM="_ZNK4llvm13LazyCallGraph6RefSCC4dumpEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC4dumpEv")
    //</editor-fold>
    private void dump() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    /// Verify invariants about the RefSCC and all its SCCs.
    ///
    /// This will attempt to validate all of the invariants *within* the
    /// RefSCC, but not that it is a strongly connected component of the larger
    /// graph. This makes it useful even when partially through an update.
    ///
    /// Invariants checked:
    /// - SCCs and their indices match.
    /// - The SCCs list is in fact in post-order.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::verify">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 209,
     FQN="llvm::LazyCallGraph::RefSCC::verify", NM="_ZN4llvm13LazyCallGraph6RefSCC6verifyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC6verifyEv")
    //</editor-fold>
    private void verify() {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*public:*/
    // JAVA: typedef pointee_iterator<SmallVectorImpl<SCC *>::const_iterator> iterator
//    public final class iterator extends pointee_iterator<type$ptr<SCC /*P*/ /*P*/> >{ };
    // JAVA: typedef iterator_range<iterator> range
//    public final class range extends iterator_range<SCC /*&*/ >{ };
    // JAVA: typedef pointee_iterator<SmallPtrSetImpl<RefSCC *>::const_iterator> parent_iterator
//    public final class parent_iterator extends pointee_iterator<SmallPtrSetIterator<RefSCC /*P*/ > >{ };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::begin">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 503,
     FQN="llvm::LazyCallGraph::RefSCC::begin", NM="_ZNK4llvm13LazyCallGraph6RefSCC5beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC5beginEv")
    //</editor-fold>
    public pointee_iterator<type$ptr<SCC /*P*/ /*P*/> > begin() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::end">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 504,
     FQN="llvm::LazyCallGraph::RefSCC::end", NM="_ZNK4llvm13LazyCallGraph6RefSCC3endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC3endEv")
    //</editor-fold>
    public pointee_iterator<type$ptr<SCC /*P*/ /*P*/> > end() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::size">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 506,
     FQN="llvm::LazyCallGraph::RefSCC::size", NM="_ZNK4llvm13LazyCallGraph6RefSCC4sizeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC4sizeEv")
    //</editor-fold>
    public int size() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::operator[]">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 508,
     FQN="llvm::LazyCallGraph::RefSCC::operator[]", NM="_ZN4llvm13LazyCallGraph6RefSCCixEi",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCCixEi")
    //</editor-fold>
    public SCC /*&*/ $at(int Idx) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::find">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 510,
     FQN="llvm::LazyCallGraph::RefSCC::find", NM="_ZNK4llvm13LazyCallGraph6RefSCC4findERNS0_3SCCE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC4findERNS0_3SCCE")
    //</editor-fold>
    public pointee_iterator<type$ptr<SCC /*P*/ /*P*/> > find(final SCC /*&*/ C) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::parent_begin">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 514,
     FQN="llvm::LazyCallGraph::RefSCC::parent_begin", NM="_ZNK4llvm13LazyCallGraph6RefSCC12parent_beginEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC12parent_beginEv")
    //</editor-fold>
    public pointee_iterator<SmallPtrSetIterator<RefSCC /*P*/ > > parent_begin() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::parent_end">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 515,
     FQN="llvm::LazyCallGraph::RefSCC::parent_end", NM="_ZNK4llvm13LazyCallGraph6RefSCC10parent_endEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC10parent_endEv")
    //</editor-fold>
    public pointee_iterator<SmallPtrSetIterator<RefSCC /*P*/ > > parent_end() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::parents">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 517,
     FQN="llvm::LazyCallGraph::RefSCC::parents", NM="_ZNK4llvm13LazyCallGraph6RefSCC7parentsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC7parentsEv")
    //</editor-fold>
    public iterator_range<RefSCC /*&*/ > parents() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test if this SCC is a parent of \a C.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::isParentOf">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 522,
     FQN="llvm::LazyCallGraph::RefSCC::isParentOf", NM="_ZNK4llvm13LazyCallGraph6RefSCC10isParentOfERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC10isParentOfERKS1_")
    //</editor-fold>
    public boolean isParentOf(final /*const*/ RefSCC /*&*/ C) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test if this RefSCC is an ancestor of \a C.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::isAncestorOf">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 525,
     FQN="llvm::LazyCallGraph::RefSCC::isAncestorOf", NM="_ZNK4llvm13LazyCallGraph6RefSCC12isAncestorOfERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC12isAncestorOfERKS1_")
    //</editor-fold>
    public boolean isAncestorOf(final /*const*/ RefSCC /*&*/ C) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test if this RefSCC is a child of \a C.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::isChildOf">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 528,
     FQN="llvm::LazyCallGraph::RefSCC::isChildOf", NM="_ZNK4llvm13LazyCallGraph6RefSCC9isChildOfERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC9isChildOfERKS1_")
    //</editor-fold>
    public boolean isChildOf(final /*const*/ RefSCC /*&*/ C) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test if this RefSCC is a descendant of \a C.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::isDescendantOf">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 249,
     FQN="llvm::LazyCallGraph::RefSCC::isDescendantOf", NM="_ZNK4llvm13LazyCallGraph6RefSCC14isDescendantOfERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC14isDescendantOfERKS1_")
    //</editor-fold>
    public boolean isDescendantOf(final /*const*/ RefSCC /*&*/ C) /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Provide a short name by printing this SCC to a std::string.
    ///
    /// This copes with the fact that we don't have a name per-se for an SCC
    /// while still making the use of this in debugging and logging useful.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::getName">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 539,
     FQN="llvm::LazyCallGraph::RefSCC::getName", NM="_ZNK4llvm13LazyCallGraph6RefSCC7getNameEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6RefSCC7getNameEv")
    //</editor-fold>
    public std.string getName() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    ///@{
    /// \name Mutation API
    ///
    /// These methods provide the core API for updating the call graph in the
    /// presence of a (potentially still in-flight) DFS-found SCCs.
    ///
    /// Note that these methods sometimes have complex runtimes, so be careful
    /// how you call them.
    
    /// Make an existing internal ref edge into a call edge.
    ///
    /// This may form a larger cycle and thus collapse SCCs into TargetN's SCC.
    /// If that happens, the deleted SCC pointers are returned. These SCCs are
    /// not in a valid state any longer but the pointers will remain valid
    /// until destruction of the parent graph instance for the purpose of
    /// clearing cached information.
    ///
    /// After this operation, both SourceN's SCC and TargetN's SCC may move
    /// position within this RefSCC's postorder list. Any SCCs merged are
    /// merged into the TargetN's SCC in order to preserve reachability analyses
    /// which took place on that SCC.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::switchInternalEdgeToCall">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 264,
     FQN="llvm::LazyCallGraph::RefSCC::switchInternalEdgeToCall", NM="_ZN4llvm13LazyCallGraph6RefSCC24switchInternalEdgeToCallERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC24switchInternalEdgeToCallERNS0_4NodeES3_")
    //</editor-fold>
    public SmallVector<LazyCallGraph.SCC /*P*/ > switchInternalEdgeToCall(final Node /*&*/ SourceN, final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Make an existing internal call edge into a ref edge.
    ///
    /// If SourceN and TargetN are part of a single SCC, it may be split up due
    /// to breaking a cycle in the call edges that formed it. If that happens,
    /// then this routine will insert new SCCs into the postorder list *before*
    /// the SCC of TargetN (previously the SCC of both). This preserves
    /// postorder as the TargetN can reach all of the other nodes by definition
    /// of previously being in a single SCC formed by the cycle from SourceN to
    /// TargetN. The newly added nodes are added *immediately* and contiguously
    /// prior to the TargetN SCC and so they may be iterated starting from
    /// there.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::switchInternalEdgeToRef">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 481,
     FQN="llvm::LazyCallGraph::RefSCC::switchInternalEdgeToRef", NM="_ZN4llvm13LazyCallGraph6RefSCC23switchInternalEdgeToRefERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC23switchInternalEdgeToRefERNS0_4NodeES3_")
    //</editor-fold>
    public void switchInternalEdgeToRef(final Node /*&*/ SourceN, 
                           final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Make an existing outgoing ref edge into a call edge.
    ///
    /// Note that this is trivial as there are no cyclic impacts and there
    /// remains a reference edge.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::switchOutgoingEdgeToCall">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 672,
     FQN="llvm::LazyCallGraph::RefSCC::switchOutgoingEdgeToCall", NM="_ZN4llvm13LazyCallGraph6RefSCC24switchOutgoingEdgeToCallERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC24switchOutgoingEdgeToCallERNS0_4NodeES3_")
    //</editor-fold>
    public void switchOutgoingEdgeToCall(final Node /*&*/ SourceN, 
                            final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Make an existing outgoing call edge into a ref edge.
    ///
    /// This is trivial as there are no cyclic impacts and there remains
    /// a reference edge.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::switchOutgoingEdgeToRef">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 692,
     FQN="llvm::LazyCallGraph::RefSCC::switchOutgoingEdgeToRef", NM="_ZN4llvm13LazyCallGraph6RefSCC23switchOutgoingEdgeToRefERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC23switchOutgoingEdgeToRefERNS0_4NodeES3_")
    //</editor-fold>
    public void switchOutgoingEdgeToRef(final Node /*&*/ SourceN, 
                           final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Insert a ref edge from one node in this RefSCC to another in this
    /// RefSCC.
    ///
    /// This is always a trivial operation as it doesn't change any part of the
    /// graph structure besides connecting the two nodes.
    ///
    /// Note that we don't support directly inserting internal *call* edges
    /// because that could change the graph structure and requires returning
    /// information about what became invalid. As a consequence, the pattern
    /// should be to first insert the necessary ref edge, and then to switch it
    /// to a call edge if needed and handle any invalidation that results. See
    /// the \c switchInternalEdgeToCall routine for details.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::insertInternalRefEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 712,
     FQN="llvm::LazyCallGraph::RefSCC::insertInternalRefEdge", NM="_ZN4llvm13LazyCallGraph6RefSCC21insertInternalRefEdgeERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC21insertInternalRefEdgeERNS0_4NodeES3_")
    //</editor-fold>
    public void insertInternalRefEdge(final Node /*&*/ SourceN, 
                         final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Insert an edge whose parent is in this RefSCC and child is in some
    /// child RefSCC.
    ///
    /// There must be an existing path from the \p SourceN to the \p TargetN.
    /// This operation is inexpensive and does not change the set of SCCs and
    /// RefSCCs in the graph.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::insertOutgoingEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 725,
     FQN="llvm::LazyCallGraph::RefSCC::insertOutgoingEdge", NM="_ZN4llvm13LazyCallGraph6RefSCC18insertOutgoingEdgeERNS0_4NodeES3_NS0_4Edge4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC18insertOutgoingEdgeERNS0_4NodeES3_NS0_4Edge4KindE")
    //</editor-fold>
    public void insertOutgoingEdge(final Node /*&*/ SourceN, final Node /*&*/ TargetN, 
                      Edge.Kind EK) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Insert an edge whose source is in a descendant RefSCC and target is in
    /// this RefSCC.
    ///
    /// There must be an existing path from the target to the source in this
    /// case.
    ///
    /// NB! This is has the potential to be a very expensive function. It
    /// inherently forms a cycle in the prior RefSCC DAG and we have to merge
    /// RefSCCs to resolve that cycle. But finding all of the RefSCCs which
    /// participate in the cycle can in the worst case require traversing every
    /// RefSCC in the graph. Every attempt is made to avoid that, but passes
    /// must still exercise caution calling this routine repeatedly.
    ///
    /// Also note that this can only insert ref edges. In order to insert
    /// a call edge, first insert a ref edge and then switch it to a call edge.
    /// These are intentionally kept as separate interfaces because each step
    /// of the operation invalidates a different set of data structures.
    ///
    /// This returns all the RefSCCs which were merged into the this RefSCC
    /// (the target's). This allows callers to invalidate any cached
    /// information.
    ///
    /// FIXME: We could possibly optimize this quite a bit for cases where the
    /// caller and callee are very nearby in the graph. See comments in the
    /// implementation for details, but that use case might impact users.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::insertIncomingRefEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 747,
     FQN="llvm::LazyCallGraph::RefSCC::insertIncomingRefEdge", NM="_ZN4llvm13LazyCallGraph6RefSCC21insertIncomingRefEdgeERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC21insertIncomingRefEdgeERNS0_4NodeES3_")
    //</editor-fold>
    public SmallVector<LazyCallGraph.RefSCC /*P*/ > insertIncomingRefEdge(final Node /*&*/ SourceN, final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Remove an edge whose source is in this RefSCC and target is *not*.
    ///
    /// This removes an inter-RefSCC edge. All inter-RefSCC edges originating
    /// from this SCC have been fully explored by any in-flight DFS graph
    /// formation, so this is always safe to call once you have the source
    /// RefSCC.
    ///
    /// This operation does not change the cyclic structure of the graph and so
    /// is very inexpensive. It may change the connectivity graph of the SCCs
    /// though, so be careful calling this while iterating over them.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::removeOutgoingEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 903,
     FQN="llvm::LazyCallGraph::RefSCC::removeOutgoingEdge", NM="_ZN4llvm13LazyCallGraph6RefSCC18removeOutgoingEdgeERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC18removeOutgoingEdgeERNS0_4NodeES3_")
    //</editor-fold>
    public void removeOutgoingEdge(final Node /*&*/ SourceN, final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Remove a ref edge which is entirely within this RefSCC.
    ///
    /// Both the \a SourceN and the \a TargetN must be within this RefSCC.
    /// Removing such an edge may break cycles that form this RefSCC and thus
    /// this operation may change the RefSCC graph significantly. In
    /// particular, this operation will re-form new RefSCCs based on the
    /// remaining connectivity of the graph. The following invariants are
    /// guaranteed to hold after calling this method:
    ///
    /// 1) This RefSCC is still a RefSCC in the graph.
    /// 2) This RefSCC will be the parent of any new RefSCCs. Thus, this RefSCC
    ///    is preserved as the root of any new RefSCC DAG formed.
    /// 3) No RefSCC other than this RefSCC has its member set changed (this is
    ///    inherent in the definition of removing such an edge).
    /// 4) All of the parent links of the RefSCC graph will be updated to
    ///    reflect the new RefSCC structure.
    /// 5) All RefSCCs formed out of this RefSCC, excluding this RefSCC, will
    ///    be returned in post-order.
    /// 6) The order of the RefSCCs in the vector will be a valid postorder
    ///    traversal of the new RefSCCs.
    ///
    /// These invariants are very important to ensure that we can build
    /// optimization pipelines on top of the CGSCC pass manager which
    /// intelligently update the RefSCC graph without invalidating other parts
    /// of the RefSCC graph.
    ///
    /// Note that we provide no routine to remove a *call* edge. Instead, you
    /// must first switch it to a ref edge using \c switchInternalEdgeToRef.
    /// This split API is intentional as each of these two steps can invalidate
    /// a different aspect of the graph structure and needs to have the
    /// invalidation handled independently.
    ///
    /// The runtime complexity of this method is, in the worst case, O(V+E)
    /// where V is the number of nodes in this RefSCC and E is the number of
    /// edges leaving the nodes in this RefSCC. Note that E includes both edges
    /// within this RefSCC and edges from this RefSCC to child RefSCCs. Some
    /// effort has been made to minimize the overhead of common cases such as
    /// self-edges and edge removals which result in a spanning tree with no
    /// more cycles. There are also detailed comments within the implementation
    /// on techniques which could substantially improve this routine's
    /// efficiency.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::removeInternalRefEdge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 960,
     FQN="llvm::LazyCallGraph::RefSCC::removeInternalRefEdge", NM="_ZN4llvm13LazyCallGraph6RefSCC21removeInternalRefEdgeERNS0_4NodeES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCC21removeInternalRefEdgeERNS0_4NodeES3_")
    //</editor-fold>
    public SmallVector<LazyCallGraph.RefSCC /*P*/ > removeInternalRefEdge(final Node /*&*/ SourceN, final Node /*&*/ TargetN) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::RefSCC::~RefSCC">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 439,
     FQN="llvm::LazyCallGraph::RefSCC::~RefSCC", NM="_ZN4llvm13LazyCallGraph6RefSCCD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph6RefSCCD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "G=" + G // NOI18N
                + ", Parents=" + Parents // NOI18N
                + ", SCCs=" + SCCs // NOI18N
                + ", SCCIndices=" + SCCIndices; // NOI18N
    }
  ///@}
    };
  
  /// A lazy iterator used for both the entry nodes and child nodes.
  ///
  /// When this iterator is dereferenced, if not yet available, a function will
  /// be scanned for "calls" or uses of functions and its child information
  /// will be constructed. All of these results are accumulated and cached in
  /// the graph.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::edge_iterator">
  @Converted(kind = Converted.Kind.DUMMY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 273,
   FQN="llvm::LazyCallGraph::edge_iterator", NM="_ZN4llvm13LazyCallGraph13edge_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph13edge_iteratorE")
  //</editor-fold>
  public static class edge_iterator {// extends /*public*/ iterator_adaptor_base<edge_iterator, type$ptr<Edge /*P*/ >, std.forward_iterator_tag> {
  };
  
  /// A lazy iterator over specifically call edges.
  ///
  /// This has the same iteration properties as the \c edge_iterator, but
  /// restricts itself to edges which represent actual calls.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::call_edge_iterator">
  @Converted(kind = Converted.Kind.DUMMY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 305,
   FQN="llvm::LazyCallGraph::call_edge_iterator", NM="_ZN4llvm13LazyCallGraph18call_edge_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph18call_edge_iteratorE")
  //</editor-fold>
  public static class call_edge_iterator {
  };
  
  /// A class used to represent edges in the call graph.
  ///
  /// The lazy call graph models both *call* edges and *reference* edges. Call
  /// edges are much what you would expect, and exist when there is a 'call' or
  /// 'invoke' instruction of some function. Reference edges are also tracked
  /// along side these, and exist whenever any instruction (transitively
  /// through its operands) references a function. All call edges are
  /// inherently reference edges, and so the reference graph forms a superset
  /// of the formal call graph.
  ///
  /// Furthermore, edges also may point to raw \c Function objects when those
  /// functions have not been scanned and incorporated into the graph (yet).
  /// This is one of the primary ways in which the graph can be lazy. When
  /// functions are scanned and fully incorporated into the graph, all of the
  /// edges referencing them are updated to point to the graph \c Node objects
  /// instead of to the raw \c Function objects. This class even provides
  /// methods to trigger this scan on-demand by attempting to get the target
  /// node of the graph and providing a reference back to the graph in order to
  /// lazily build it if necessary.
  ///
  /// All of these forms of edges are fundamentally represented as outgoing
  /// edges. The edges are stored in the source node and point at the target
  /// node. This allows the edge structure itself to be a very compact data
  /// structure: essentially a tagged pointer.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 137,
   FQN="llvm::LazyCallGraph::Edge", NM="_ZN4llvm13LazyCallGraph4EdgeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4EdgeE")
  //</editor-fold>
  public static class Edge implements Native.Native$Bool {
  /*public:*/
    /// The kind of edge in the graph.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::Kind">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 140,
     FQN="llvm::LazyCallGraph::Edge::Kind", NM="_ZN4llvm13LazyCallGraph4Edge4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Edge4KindE")
    //</editor-fold>
    public enum Kind/* : bool*/ implements Native.NativeBoolEnum {
      Ref(0),
      Call(1);

      //<editor-fold defaultstate="collapsed" desc="hidden">
      public static Kind valueOf(boolean val) {
        Kind out = valueOf(val?1:0);
        //assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
        return out;
      }
      public static Kind valueOf(int val) {
        Kind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
        assert out != null : "no value for " + val;
        assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
        return out;
      }

      private static final class Values {
        private static final Kind[] VALUES;
        private static final Kind[] _VALUES; // [0] not used
        static {
          int max = 0;
          int min = 0;
          for (Kind kind : Kind.values()) {
            if (kind.value > max) { max = kind.value; }
            if (kind.value < min) { min = kind.value; }
          }
          _VALUES = new Kind[min < 0 ? (1-min) : 0];
          VALUES = new Kind[max >= 0 ? (1+max) : 0];
          for (Kind kind : Kind.values()) {
            if (kind.value < 0) {
              if (_VALUES[-kind.value] == null) {
                _VALUES[-kind.value] = kind;
              } else {
                assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            } else {
              if (VALUES[kind.value] == null) {
                VALUES[kind.value] = kind;
              } else {
                assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
              }
            }
          }
        }
      }

      private final int value;
      private Kind(int val) { this.value = val;}
      @Override public final boolean getValue() { return value==1;}
      //</editor-fold>
    };
    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::Edge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 912,
     FQN="llvm::LazyCallGraph::Edge::Edge", NM="_ZN4llvm13LazyCallGraph4EdgeC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4EdgeC1Ev")
    //</editor-fold>
    public /*inline*/ Edge() {
      // : Value() 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::Edge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 913,
     FQN="llvm::LazyCallGraph::Edge::Edge", NM="_ZN4llvm13LazyCallGraph4EdgeC1ERNS_8FunctionENS1_4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4EdgeC1ERNS_8FunctionENS1_4KindE")
    //</editor-fold>
    public /*inline*/ Edge(final Function /*&*/ F, Kind K) {
      // : Value(&F, K) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::Edge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 914,
     FQN="llvm::LazyCallGraph::Edge::Edge", NM="_ZN4llvm13LazyCallGraph4EdgeC1ERNS0_4NodeENS1_4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4EdgeC1ERNS0_4NodeENS1_4KindE")
    //</editor-fold>
    public /*inline*/ Edge(final Node /*&*/ N, Kind K) {
      // : Value(&N, K) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test whether the edge is null.
    ///
    /// This happens when an edge has been deleted. We leave the edge objects
    /// around but clear them.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::operator bool">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 916,
     FQN="llvm::LazyCallGraph::Edge::operator bool", NM="_ZNK4llvm13LazyCallGraph4EdgecvbEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4EdgecvbEv")
    //</editor-fold>
    public /*inline*/ boolean $bool() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Test whether the edge represents a direct call to a function.
    ///
    /// This requires that the edge is not null.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::isCall">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 920,
     FQN="llvm::LazyCallGraph::Edge::isCall", NM="_ZNK4llvm13LazyCallGraph4Edge6isCallEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Edge6isCallEv")
    //</editor-fold>
    public /*inline*/ boolean isCall() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Get the function referenced by this edge.
    ///
    /// This requires that the edge is not null, but will succeed whether we
    /// have built a graph node for the function yet or not.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::getFunction">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 925,
     FQN="llvm::LazyCallGraph::Edge::getFunction", NM="_ZNK4llvm13LazyCallGraph4Edge11getFunctionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Edge11getFunctionEv")
    //</editor-fold>
    public /*inline*/ Function /*&*/ getFunction() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Get the call graph node referenced by this edge if one exists.
    ///
    /// This requires that the edge is not null. If we have built a graph node
    /// for the function this edge points to, this will return that node,
    /// otherwise it will return null.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::getNode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 934,
     FQN="llvm::LazyCallGraph::Edge::getNode", NM="_ZNK4llvm13LazyCallGraph4Edge7getNodeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph4Edge7getNodeEv")
    //</editor-fold>
    public /*inline*/ LazyCallGraph.Node /*P*/ getNode() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    /// Get the call graph node for this edge, building it if necessary.
    ///
    /// This requires that the edge is not null. If we have not yet built
    /// a graph node for the function this edge points to, this will first ask
    /// the graph to build that node, inserting it into all the relevant
    /// structures.
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::getNode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 943,
     FQN="llvm::LazyCallGraph::Edge::getNode", NM="_ZN4llvm13LazyCallGraph4Edge7getNodeERS0_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Edge7getNodeERS0_")
    //</editor-fold>
    public /*inline*/ LazyCallGraph.Node /*&*/ getNode(final LazyCallGraph /*&*/ G) {
      throw new UnsupportedOperationException("EmptyBody");
    }

  /*private:*/
    /*friend  class LazyCallGraph::Node*/
    
    //private PointerIntPair<PointerUnion<Function /*P*/ , Node /*P*/ >, 1, Kind> Value;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::setKind">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 183,
     FQN="llvm::LazyCallGraph::Edge::setKind", NM="_ZN4llvm13LazyCallGraph4Edge7setKindENS1_4KindE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4Edge7setKindENS1_4KindE")
    //</editor-fold>
    private void setKind(Kind K) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::Edge">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 137,
     FQN="llvm::LazyCallGraph::Edge::Edge", NM="_ZN4llvm13LazyCallGraph4EdgeC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4EdgeC1EOS1_")
    //</editor-fold>
    public /*inline*/ Edge(JD$Move _dparam, final Edge /*&&*/$Prm0) {
      // : Value(static_cast<Edge &&>().Value) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::Edge::operator=">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 137,
     FQN="llvm::LazyCallGraph::Edge::operator=", NM="_ZN4llvm13LazyCallGraph4EdgeaSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph4EdgeaSEOS1_")
    //</editor-fold>
    public /*inline*/ Edge /*&*/ $assignMove(final Edge /*&&*/$Prm0) {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Value=";// + Value; // NOI18N
    }
  };
  
  // JAVA: typedef SmallVector<Edge, 4> EdgeVectorT
//  public final class EdgeVectorT extends SmallVector<Edge>{ };
  // JAVA: typedef SmallVectorImpl<Edge> EdgeVectorImplT
//  public final class EdgeVectorImplT extends SmallVectorImpl<Edge>{ };
  ;
  ;
  ;
  ;
  ;
  
  /// A post-order depth-first SCC iterator over the call graph.
  ///
  /// This iterator triggers the Tarjan DFS-based formation of the SCC DAG for
  /// the call graph, walking it lazily in depth-first post-order. That is, it
  /// always visits SCCs for a callee prior to visiting the SCC for a caller
  /// (when they are in different SCCs).
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::postorder_ref_scc_iterator">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 711,
   FQN="llvm::LazyCallGraph::postorder_ref_scc_iterator", NM="_ZN4llvm13LazyCallGraph26postorder_ref_scc_iteratorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph26postorder_ref_scc_iteratorE")
  //</editor-fold>
  public static class postorder_ref_scc_iterator {
  }
  
  /// Construct a graph for the given module.
  ///
  /// This sets up the graph and computes all of the entry points of the graph.
  /// No function definitions are scanned until their nodes in the graph are
  /// requested during traversal.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::LazyCallGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 126,
   FQN="llvm::LazyCallGraph::LazyCallGraph", NM="_ZN4llvm13LazyCallGraphC1ERNS_6ModuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraphC1ERNS_6ModuleE")
  //</editor-fold>
  public LazyCallGraph(final Module /*&*/ M) {
    // : BPA(), NodeMap(), EntryEdges(), EntryIndexMap(), SCCBPA(), SCCMap(), RefSCCBPA(), LeafRefSCCs(), DFSStack(), RefSCCEntryNodes(), PendingRefSCCStack(), NextDFSNumber(0) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::LazyCallGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 153,
   FQN="llvm::LazyCallGraph::LazyCallGraph", NM="_ZN4llvm13LazyCallGraphC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraphC1EOS0_")
  //</editor-fold>
  public LazyCallGraph(JD$Move _dparam, final LazyCallGraph /*&&*/G) {
    // : BPA(std::move(G.BPA)), NodeMap(std::move(G.NodeMap)), EntryEdges(std::move(G.EntryEdges)), EntryIndexMap(std::move(G.EntryIndexMap)), SCCBPA(std::move(G.SCCBPA)), SCCMap(std::move(G.SCCMap)), RefSCCBPA(), LeafRefSCCs(std::move(G.LeafRefSCCs)), DFSStack(std::move(G.DFSStack)), RefSCCEntryNodes(std::move(G.RefSCCEntryNodes)), PendingRefSCCStack(), NextDFSNumber(G.NextDFSNumber) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 164,
   FQN="llvm::LazyCallGraph::operator=", NM="_ZN4llvm13LazyCallGraphaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraphaSEOS0_")
  //</editor-fold>
  public LazyCallGraph /*&*/ $assignMove(final LazyCallGraph /*&&*/G) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 756,
   FQN="llvm::LazyCallGraph::begin", NM="_ZN4llvm13LazyCallGraph5beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph5beginEv")
  //</editor-fold>
  public edge_iterator begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 759,
   FQN="llvm::LazyCallGraph::end", NM="_ZN4llvm13LazyCallGraph3endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph3endEv")
  //</editor-fold>
  public edge_iterator end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::postorder_ref_scc_begin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 763,
   FQN="llvm::LazyCallGraph::postorder_ref_scc_begin", NM="_ZN4llvm13LazyCallGraph23postorder_ref_scc_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph23postorder_ref_scc_beginEv")
  //</editor-fold>
  public postorder_ref_scc_iterator postorder_ref_scc_begin() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::postorder_ref_scc_end">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 766,
   FQN="llvm::LazyCallGraph::postorder_ref_scc_end", NM="_ZN4llvm13LazyCallGraph21postorder_ref_scc_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph21postorder_ref_scc_endEv")
  //</editor-fold>
  public postorder_ref_scc_iterator postorder_ref_scc_end() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::postorder_ref_sccs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 771,
   FQN="llvm::LazyCallGraph::postorder_ref_sccs", NM="_ZN4llvm13LazyCallGraph18postorder_ref_sccsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph18postorder_ref_sccsEv")
  //</editor-fold>
  public iterator_range<RefSCC> postorder_ref_sccs() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Lookup a function in the graph which has already been scanned and added.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::lookup">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 776,
   FQN="llvm::LazyCallGraph::lookup", NM="_ZNK4llvm13LazyCallGraph6lookupERKNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph6lookupERKNS_8FunctionE")
  //</editor-fold>
  public Node /*P*/ lookup(final /*const*/ Function /*&*/ F) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Lookup a function's SCC in the graph.
  ///
  /// \returns null if the function hasn't been assigned an SCC via the SCC
  /// iterator walk.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::lookupSCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 782,
   FQN="llvm::LazyCallGraph::lookupSCC", NM="_ZNK4llvm13LazyCallGraph9lookupSCCERNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph9lookupSCCERNS0_4NodeE")
  //</editor-fold>
  public SCC /*P*/ lookupSCC(final Node /*&*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Lookup a function's RefSCC in the graph.
  ///
  /// \returns null if the function hasn't been assigned a RefSCC via the
  /// RefSCC iterator walk.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::lookupRefSCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 788,
   FQN="llvm::LazyCallGraph::lookupRefSCC", NM="_ZNK4llvm13LazyCallGraph12lookupRefSCCERNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZNK4llvm13LazyCallGraph12lookupRefSCCERNS0_4NodeE")
  //</editor-fold>
  public RefSCC /*P*/ lookupRefSCC(final Node /*&*/ N) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Get a graph node for a given function, scanning it to populate the graph
  /// data as necessary.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::get">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 797,
   FQN="llvm::LazyCallGraph::get", NM="_ZN4llvm13LazyCallGraph3getERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph3getERNS_8FunctionE")
  //</editor-fold>
  public Node /*&*/ get(final Function /*&*/ F) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  ///@{
  /// \name Pre-SCC Mutation API
  ///
  /// These methods are only valid to call prior to forming any SCCs for this
  /// call graph. They can be used to update the core node-graph during
  /// a node-based inorder traversal that precedes any SCC-based traversal.
  ///
  /// Once you begin manipulating a call graph's SCCs, you must perform all
  /// mutation of the graph via the SCC methods.
  
  /// Update the call graph after inserting a new edge.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::insertEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1229,
   FQN="llvm::LazyCallGraph::insertEdge", NM="_ZN4llvm13LazyCallGraph10insertEdgeERNS0_4NodeERNS_8FunctionENS0_4Edge4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph10insertEdgeERNS0_4NodeERNS_8FunctionENS0_4Edge4KindE")
  //</editor-fold>
  public void insertEdge(final Node /*&*/ SourceN, final Function /*&*/ Target, Edge.Kind EK) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Update the call graph after inserting a new edge.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::insertEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 819,
   FQN="llvm::LazyCallGraph::insertEdge", NM="_ZN4llvm13LazyCallGraph10insertEdgeERNS_8FunctionES2_NS0_4Edge4KindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph10insertEdgeERNS_8FunctionES2_NS0_4Edge4KindE")
  //</editor-fold>
  public void insertEdge(final Function /*&*/ Caller, final Function /*&*/ Callee, Edge.Kind EK) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Update the call graph after deleting an edge.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::removeEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1236,
   FQN="llvm::LazyCallGraph::removeEdge", NM="_ZN4llvm13LazyCallGraph10removeEdgeERNS0_4NodeERNS_8FunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph10removeEdgeERNS0_4NodeERNS_8FunctionE")
  //</editor-fold>
  public void removeEdge(final Node /*&*/ SourceN, final Function /*&*/ Target) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Update the call graph after deleting an edge.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::removeEdge">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 827,
   FQN="llvm::LazyCallGraph::removeEdge", NM="_ZN4llvm13LazyCallGraph10removeEdgeERNS_8FunctionES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph10removeEdgeERNS_8FunctionES2_")
  //</editor-fold>
  public void removeEdge(final Function /*&*/ Caller, final Function /*&*/ Callee) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  ///@}
  /*private:*/
  // JAVA: typedef SmallVectorImpl<Node *>::reverse_iterator node_stack_iterator
//  public final class node_stack_iterator extends std.reverse_iterator<Node /*P*/ >{ };
  // JAVA: typedef iterator_range<node_stack_iterator> node_stack_range
//  public final class node_stack_range extends iterator_range<Node /*&*/ >{ };
  
  /// Allocator that holds all the call graph nodes.
  private SpecificBumpPtrAllocator<Node> BPA;
  
  /// Maps function->node for fast lookup.
  private DenseMap</*const*/ Function /*P*/ , Node /*P*/ > NodeMap;
  
  /// The entry nodes to the graph.
  ///
  /// These nodes are reachable through "external" means. Put another way, they
  /// escape at the module scope.
  private SmallVector<Edge> EntryEdges;
  
  /// Map of the entry nodes in the graph to their indices in \c EntryEdges.
  private DenseMapTypeInt<Function /*P*/ > EntryIndexMap;
  
  /// Allocator that holds all the call graph SCCs.
  private SpecificBumpPtrAllocator<SCC> SCCBPA;
  
  /// Maps Function -> SCC for fast lookup.
  private DenseMap<Node /*P*/ , SCC /*P*/ > SCCMap;
  
  /// Allocator that holds all the call graph RefSCCs.
  private SpecificBumpPtrAllocator<RefSCC> RefSCCBPA;
  
  /// The leaf RefSCCs of the graph.
  ///
  /// These are all of the RefSCCs which have no children.
  private SmallVector<RefSCC /*P*/ > LeafRefSCCs;
  
  /// Stack of nodes in the DFS walk.
  private SmallVector<std.pair<Node /*P*/ , edge_iterator>> DFSStack;
  
  /// Set of entry nodes not-yet-processed into RefSCCs.
  private SmallVector<Function /*P*/ > RefSCCEntryNodes;
  
  /// Stack of nodes the DFS has walked but not yet put into a SCC.
  private SmallVector<Node /*P*/ > PendingRefSCCStack;
  
  /// Counter for the next DFS number to assign.
  private int NextDFSNumber;
  
  /// Helper to insert a new function, with an already looked-up entry in
  /// the NodeMap.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::insertInto">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1243,
   FQN="llvm::LazyCallGraph::insertInto", NM="_ZN4llvm13LazyCallGraph10insertIntoERNS_8FunctionERPNS0_4NodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph10insertIntoERNS_8FunctionERPNS0_4NodeE")
  //</editor-fold>
  private LazyCallGraph.Node /*&*/ insertInto(final Function /*&*/ F, final type$ref<Node /*P*/ /*&*/> MappedN) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Helper to update pointers back to the graph object during moves.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::updateGraphPtrs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1247,
   FQN="llvm::LazyCallGraph::updateGraphPtrs", NM="_ZN4llvm13LazyCallGraph15updateGraphPtrsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph15updateGraphPtrsEv")
  //</editor-fold>
  private void updateGraphPtrs() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Allocates an SCC and constructs it using the graph allocator.
  ///
  /// The arguments are forwarded to the constructor.
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::createSCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 888,
   FQN="llvm::LazyCallGraph::createSCC", NM="Tpl__ZN4llvm13LazyCallGraph9createSCCEDpOT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=Tpl__ZN4llvm13LazyCallGraph9createSCCEDpOT_")
  //</editor-fold>
  private </*typename*/ /*...*/ Ts> SCC /*P*/ createSCC(Ts /*&&*/...Args) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Allocates a RefSCC and constructs it using the graph allocator.
  ///
  /// The arguments are forwarded to the constructor.
  /*template <typename ... Ts> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::createRefSCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 895,
   FQN="llvm::LazyCallGraph::createRefSCC", NM="Tpl__ZN4llvm13LazyCallGraph12createRefSCCEDpOT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=Tpl__ZN4llvm13LazyCallGraph12createRefSCCEDpOT_")
  //</editor-fold>
  private </*typename*/ /*...*/ Ts> RefSCC /*P*/ createRefSCC(Ts /*&&*/...Args) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Build the SCCs for a RefSCC out of a list of nodes.
  
  /// Build the internal SCCs for a RefSCC from a sequence of nodes.
  ///
  /// Appends the SCCs to the provided vector and updates the map with their
  /// indices. Both the vector and map must be empty when passed into this
  /// routine.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::buildSCCs">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1282,
   FQN="llvm::LazyCallGraph::buildSCCs", NM="_ZN4llvm13LazyCallGraph9buildSCCsERNS0_6RefSCCENS_14iterator_rangeISt16reverse_iteratorIPPNS0_4NodeEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph9buildSCCsERNS0_6RefSCCENS_14iterator_rangeISt16reverse_iteratorIPPNS0_4NodeEEEE")
  //</editor-fold>
  private void buildSCCs(final RefSCC /*&*/ RC, iterator_range<Node /*&*/ > Nodes) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Connect a RefSCC into the larger graph.
  ///
  /// This walks the edges to connect the RefSCC to its children's parent set,
  /// and updates the root leaf list.
  
  // FIXME: We should move callers of this to embed the parent linking and leaf
  // tracking into their DFS in order to remove a full walk of all edges.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::connectRefSCC">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1397,
   FQN="llvm::LazyCallGraph::connectRefSCC", NM="_ZN4llvm13LazyCallGraph13connectRefSCCERNS0_6RefSCCE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph13connectRefSCCERNS0_6RefSCCE")
  //</editor-fold>
  private void connectRefSCC(final RefSCC /*&*/ RC) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Retrieve the next node in the post-order RefSCC walk of the call graph.
  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::getNextRefSCCInPostOrder">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp", line = 1419,
   FQN="llvm::LazyCallGraph::getNextRefSCCInPostOrder", NM="_ZN4llvm13LazyCallGraph24getNextRefSCCInPostOrderEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraph24getNextRefSCCInPostOrderEv")
  //</editor-fold>
  private LazyCallGraph.RefSCC /*P*/ getNextRefSCCInPostOrder() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::LazyCallGraph::~LazyCallGraph">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LazyCallGraph.h", line = 105,
   FQN="llvm::LazyCallGraph::~LazyCallGraph", NM="_ZN4llvm13LazyCallGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyCallGraph.cpp -nm=_ZN4llvm13LazyCallGraphD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "BPA=" + BPA // NOI18N
              + ", NodeMap=" + NodeMap // NOI18N
              + ", EntryEdges=" + EntryEdges // NOI18N
              + ", EntryIndexMap=" + EntryIndexMap // NOI18N
              + ", SCCBPA=" + SCCBPA // NOI18N
              + ", SCCMap=" + SCCMap // NOI18N
              + ", RefSCCBPA=" + RefSCCBPA // NOI18N
              + ", LeafRefSCCs=" + LeafRefSCCs // NOI18N
              + ", DFSStack=" + DFSStack // NOI18N
              + ", RefSCCEntryNodes=" + RefSCCEntryNodes // NOI18N
              + ", PendingRefSCCStack=" + PendingRefSCCStack // NOI18N
              + ", NextDFSNumber=" + NextDFSNumber; // NOI18N
  }
}
