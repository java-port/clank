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

package org.clang.staticanalyzer.core.pathsensitive.ento;

import static org.clank.support.Native.$Deref;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.support.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 247,
 FQN="clang::ento::ExplodedGraph", NM="_ZN5clang4ento13ExplodedGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraphE")
//</editor-fold>
public class ExplodedGraph implements Destructors.ClassWithDestructor {
/*protected:*/
  /*friend  class CoreEngine*/
  
  // Type definitions.
  // JAVA: typedef std::vector<ExplodedNode *> NodeVector
//  public final class NodeVector extends std.vector<ExplodedNode /*P*/ >{ };
  
  /// The roots of the simulation graph. Usually there will be only
  /// one, but clients are free to establish multiple subgraphs within a single
  /// SimulGraph. Moreover, these subgraphs can often merge when paths from
  /// different roots reach the same state at the same program location.
  protected std.vector<ExplodedNode /*P*/ > Roots;
  
  /// The nodes in the simulation graph which have been
  /// specially marked as the endpoint of an abstract simulation path.
  protected std.vector<ExplodedNode /*P*/ > EndNodes;
  
  /// Nodes - The nodes in the graph.
  protected FoldingSet<ExplodedNode> Nodes;
  
  /// BVC - Allocator and context for allocating nodes and their predecessor
  /// and successor groups.
  protected BumpVectorContext BVC;
  
  /// NumNodes - The number of nodes in the graph.
  protected /*uint*/int NumNodes;
  
  /// A list of recently allocated nodes that can potentially be recycled.
  protected std.vector<ExplodedNode /*P*/ > ChangedNodes;
  
  /// A list of nodes that can be reused.
  protected std.vector<ExplodedNode /*P*/ > FreeNodes;
  
  /// Determines how often nodes are reclaimed.
  ///
  /// If this is 0, nodes will never be reclaimed.
  protected /*uint*/int ReclaimNodeInterval;
  
  /// Counter to determine when to reclaim nodes.
  protected /*uint*/int ReclaimCounter;
/*public:*/
  
  /// \brief Retrieve the node associated with a (Location,State) pair,
  ///  where the 'Location' is a ProgramPoint in the CFG.  If no node for
  ///  this pair exists, it is created. IsNew is set to true if
  ///  the node was freshly created.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::getNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 301,
   FQN="clang::ento::ExplodedGraph::getNode", NM="_ZN5clang4ento13ExplodedGraph7getNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEbPb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph7getNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEbPb")
  //</editor-fold>
  public ExplodedNode /*P*/ getNode(final /*const*/ ProgramPoint /*&*/ L, 
         IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    return getNode(L, 
         State, 
         false, 
         (bool$ptr/*bool P*/ )null);
  }
  public ExplodedNode /*P*/ getNode(final /*const*/ ProgramPoint /*&*/ L, 
         IntrusiveRefCntPtr</*const*/ ProgramState> State, 
         boolean IsSink/*= false*/) {
    return getNode(L, 
         State, 
         IsSink, 
         (bool$ptr/*bool P*/ )null);
  }
  public ExplodedNode /*P*/ getNode(final /*const*/ ProgramPoint /*&*/ L, 
         IntrusiveRefCntPtr</*const*/ ProgramState> State, 
         boolean IsSink/*= false*/, 
         bool$ptr/*bool P*/ IsNew/*= null*/) {
    // Profile 'State' to determine if we already have an existing node.
    FoldingSetNodeID profile/*J*/= new FoldingSetNodeID();
    final type$ref<type$ptr<ExplodedNode /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    
    ExplodedNode.Profile(profile, L, State, IsSink);
    ExplodedNode /*P*/ V = Nodes.FindNodeOrInsertPos(profile, InsertPos);
    if (!(V != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // JAVA: ALLOC
        if (!FreeNodes.empty()) {
          V = FreeNodes.back();
          FreeNodes.pop_back();
        } else {
          // Allocate a new node.
          if (/*JAVA*/false) {
            V = (ExplodedNode /*P*/ )getAllocator().<ExplodedNode>Allocate$T(ExplodedNode.class);
          }
        }
        
        $c$.clean(/*NEW_EXPR [System]*/V = /*new (V)*/ $new_uint_voidPtr(/*V*/null, (type$ptr<?> New$Mem)->{
            return new ExplodedNode(L, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), IsSink);
         }));
        if ((ReclaimNodeInterval != 0)) {
          ChangedNodes.push_back_T$C$R(V);
        }
        
        // Insert the node into the node set and return it.
        Nodes.InsertNode(V, InsertPos.$deref());
        ++NumNodes;
        if (Native.$bool(IsNew)) {
          IsNew.$set(true);
        }
      } finally {
        $c$.$destroy();
      }
    } else if (Native.$bool(IsNew)) {
      IsNew.$set(false);
    }
    
    return V;
  }

  
  /// \brief Create a node for a (Location, State) pair,
  ///  but don't store it for deduplication later.  This
  ///  is useful when copying an already completed
  ///  ExplodedGraph for further processing.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::createUncachedNode">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*Alloc*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 339,
   FQN="clang::ento::ExplodedGraph::createUncachedNode", NM="_ZN5clang4ento13ExplodedGraph18createUncachedNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph18createUncachedNodeERKNS_12ProgramPointEN4llvm18IntrusiveRefCntPtrIKNS0_12ProgramStateEEEb")
  //</editor-fold>
  public ExplodedNode /*P*/ createUncachedNode(final /*const*/ ProgramPoint /*&*/ L, 
                    IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    return createUncachedNode(L, 
                    State, 
                    false);
  }
  public ExplodedNode /*P*/ createUncachedNode(final /*const*/ ProgramPoint /*&*/ L, 
                    IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                    boolean IsSink/*= false*/) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // JAVA: ALLOC
      ExplodedNode /*P*/ V = null;
      if (/*JAVA*/false) {
        V = (ExplodedNode /*P*/ )getAllocator().<ExplodedNode>Allocate$T(ExplodedNode.class);
      }
      $c$.clean(/*NEW_EXPR [System]*/V = /*new (V)*/ $new_uint_voidPtr(/*V*/null, (type$ptr<?> New$Mem)->{
          return new ExplodedNode(L, $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), IsSink);
       }));
      return V;
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::MakeEmptyGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 306,
   FQN="clang::ento::ExplodedGraph::MakeEmptyGraph", NM="_ZNK5clang4ento13ExplodedGraph14MakeEmptyGraphEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph14MakeEmptyGraphEv")
  //</editor-fold>
  public std.unique_ptr<ExplodedGraph> MakeEmptyGraph() /*const*/ {
    return llvm.make_unique(new ExplodedGraph());
  }

  
  /// addRoot - Add an untyped node to the set of roots.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::addRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 311,
   FQN="clang::ento::ExplodedGraph::addRoot", NM="_ZN5clang4ento13ExplodedGraph7addRootEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph7addRootEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNode /*P*/ addRoot(ExplodedNode /*P*/ V) {
    Roots.push_back_T$C$R(V);
    return V;
  }

  
  /// addEndOfPath - Add an untyped node to the set of EOP nodes.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::addEndOfPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 317,
   FQN="clang::ento::ExplodedGraph::addEndOfPath", NM="_ZN5clang4ento13ExplodedGraph12addEndOfPathEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph12addEndOfPathEPNS0_12ExplodedNodeE")
  //</editor-fold>
  public ExplodedNode /*P*/ addEndOfPath(ExplodedNode /*P*/ V) {
    EndNodes.push_back_T$C$R(V);
    return V;
  }

  
  
  //===----------------------------------------------------------------------===//
  // Cleanup.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::ExplodedGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 50,
   FQN="clang::ento::ExplodedGraph::ExplodedGraph", NM="_ZN5clang4ento13ExplodedGraphC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraphC1Ev")
  //</editor-fold>
  public ExplodedGraph() {
    // : Roots(), EndNodes(), Nodes(), BVC(), NumNodes(0), ChangedNodes(), FreeNodes(), ReclaimNodeInterval(0) 
    //START JInit
    this.Roots = new std.vector<ExplodedNode /*P*/ >((ExplodedNode /*P*/ )null);
    this.EndNodes = new std.vector<ExplodedNode /*P*/ >((ExplodedNode /*P*/ )null);
    this.Nodes = new FoldingSet<ExplodedNode>(ExplodedNode.$Trait());
    this.BVC = new BumpVectorContext();
    this.NumNodes = 0;
    this.ChangedNodes = new std.vector<ExplodedNode /*P*/ >((ExplodedNode /*P*/ )null);
    this.FreeNodes = new std.vector<ExplodedNode /*P*/ >((ExplodedNode /*P*/ )null);
    this.ReclaimNodeInterval = 0;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::~ExplodedGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 53,
   FQN="clang::ento::ExplodedGraph::~ExplodedGraph", NM="_ZN5clang4ento13ExplodedGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraphD0Ev")
  //</editor-fold>
  public void $destroy() {
    //START JDestroy
    FreeNodes.$destroy();
    ChangedNodes.$destroy();
    BVC.$destroy();
    Nodes.$destroy();
    EndNodes.$destroy();
    Roots.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::num_roots">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 326,
   FQN="clang::ento::ExplodedGraph::num_roots", NM="_ZNK5clang4ento13ExplodedGraph9num_rootsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph9num_rootsEv")
  //</editor-fold>
  public /*uint*/int num_roots() /*const*/ {
    return Roots.size();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::num_eops">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 327,
   FQN="clang::ento::ExplodedGraph::num_eops", NM="_ZNK5clang4ento13ExplodedGraph8num_eopsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph8num_eopsEv")
  //</editor-fold>
  public /*uint*/int num_eops() /*const*/ {
    return EndNodes.size();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::empty">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 329,
   FQN="clang::ento::ExplodedGraph::empty", NM="_ZNK5clang4ento13ExplodedGraph5emptyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph5emptyEv")
  //</editor-fold>
  public boolean empty() /*const*/ {
    return NumNodes == 0;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::size">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 330,
   FQN="clang::ento::ExplodedGraph::size", NM="_ZNK5clang4ento13ExplodedGraph4sizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph4sizeEv")
  //</editor-fold>
  public /*uint*/int size() /*const*/ {
    return NumNodes;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::reserve">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 332,
   FQN="clang::ento::ExplodedGraph::reserve", NM="_ZN5clang4ento13ExplodedGraph7reserveEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph7reserveEj")
  //</editor-fold>
  public void reserve(/*uint*/int NodeCount) {
    Nodes.reserve(NodeCount);
  }

  
  // Iterators.
  // JAVA: typedef ExplodedNode NodeTy
//  public final class NodeTy extends ExplodedNode{ };
  // JAVA: typedef llvm::FoldingSet<ExplodedNode> AllNodesTy
//  public final class AllNodesTy extends FoldingSet<ExplodedNode>{ };
  // JAVA: typedef NodeVector::iterator roots_iterator
//  public final class roots_iterator extends std.vector.iterator<ExplodedNode /*P*/ >{ };
  // JAVA: typedef NodeVector::const_iterator const_roots_iterator
//  public final class const_roots_iterator extends std.vector.iterator</*const*/ ExplodedNode /*P*/ >{ };
  // JAVA: typedef NodeVector::iterator eop_iterator
//  public final class eop_iterator extends std.vector.iterator<ExplodedNode /*P*/ >{ };
  // JAVA: typedef NodeVector::const_iterator const_eop_iterator
//  public final class const_eop_iterator extends std.vector.iterator</*const*/ ExplodedNode /*P*/ >{ };
  // JAVA: typedef AllNodesTy::iterator node_iterator
//  public final class node_iterator extends FoldingSetIterator<ExplodedNode>{ };
  // JAVA: typedef AllNodesTy::const_iterator const_node_iterator
//  public final class const_node_iterator extends FoldingSetIterator</*const*/ ExplodedNode>{ };
  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::nodes_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 344,
   FQN="clang::ento::ExplodedGraph::nodes_begin", NM="_ZN5clang4ento13ExplodedGraph11nodes_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph11nodes_beginEv")
  //</editor-fold>
  public FoldingSetIterator<ExplodedNode> nodes_begin() {
    return Nodes.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::nodes_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 346,
   FQN="clang::ento::ExplodedGraph::nodes_end", NM="_ZN5clang4ento13ExplodedGraph9nodes_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph9nodes_endEv")
  //</editor-fold>
  public FoldingSetIterator<ExplodedNode> nodes_end() {
    return Nodes.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::nodes_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 348,
   FQN="clang::ento::ExplodedGraph::nodes_begin", NM="_ZNK5clang4ento13ExplodedGraph11nodes_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph11nodes_beginEv")
  //</editor-fold>
  public FoldingSetIterator</*const*/ ExplodedNode> nodes_begin$Const() /*const*/ {
    return Nodes.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::nodes_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 350,
   FQN="clang::ento::ExplodedGraph::nodes_end", NM="_ZNK5clang4ento13ExplodedGraph9nodes_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph9nodes_endEv")
  //</editor-fold>
  public FoldingSetIterator</*const*/ ExplodedNode> nodes_end$Const() /*const*/ {
    return Nodes.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::roots_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 352,
   FQN="clang::ento::ExplodedGraph::roots_begin", NM="_ZN5clang4ento13ExplodedGraph11roots_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph11roots_beginEv")
  //</editor-fold>
  public std.vector.iterator<ExplodedNode /*P*/ > roots_begin() {
    return Roots.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::roots_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 354,
   FQN="clang::ento::ExplodedGraph::roots_end", NM="_ZN5clang4ento13ExplodedGraph9roots_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph9roots_endEv")
  //</editor-fold>
  public std.vector.iterator<ExplodedNode /*P*/ > roots_end() {
    return Roots.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::roots_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 356,
   FQN="clang::ento::ExplodedGraph::roots_begin", NM="_ZNK5clang4ento13ExplodedGraph11roots_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph11roots_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ ExplodedNode /*P*/ > roots_begin$Const() /*const*/ {
    return Roots.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::roots_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 358,
   FQN="clang::ento::ExplodedGraph::roots_end", NM="_ZNK5clang4ento13ExplodedGraph9roots_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph9roots_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ ExplodedNode /*P*/ > roots_end$Const() /*const*/ {
    return Roots.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::eop_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 360,
   FQN="clang::ento::ExplodedGraph::eop_begin", NM="_ZN5clang4ento13ExplodedGraph9eop_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph9eop_beginEv")
  //</editor-fold>
  public std.vector.iterator<ExplodedNode /*P*/ > eop_begin() {
    return EndNodes.begin();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::eop_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 362,
   FQN="clang::ento::ExplodedGraph::eop_end", NM="_ZN5clang4ento13ExplodedGraph7eop_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph7eop_endEv")
  //</editor-fold>
  public std.vector.iterator<ExplodedNode /*P*/ > eop_end() {
    return EndNodes.end();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::eop_begin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 364,
   FQN="clang::ento::ExplodedGraph::eop_begin", NM="_ZNK5clang4ento13ExplodedGraph9eop_beginEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph9eop_beginEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ ExplodedNode /*P*/ > eop_begin$Const() /*const*/ {
    return EndNodes.begin$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::eop_end">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 366,
   FQN="clang::ento::ExplodedGraph::eop_end", NM="_ZNK5clang4ento13ExplodedGraph7eop_endEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph7eop_endEv")
  //</editor-fold>
  public std.vector.iterator</*const*/ ExplodedNode /*P*/ > eop_end$Const() /*const*/ {
    return EndNodes.end$Const();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::getAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 368,
   FQN="clang::ento::ExplodedGraph::getAllocator", NM="_ZN5clang4ento13ExplodedGraph12getAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph12getAllocatorEv")
  //</editor-fold>
  public BumpPtrAllocatorImpl /*&*/ getAllocator() {
    return BVC.getAllocator();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::getNodeAllocator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 369,
   FQN="clang::ento::ExplodedGraph::getNodeAllocator", NM="_ZN5clang4ento13ExplodedGraph16getNodeAllocatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph16getNodeAllocatorEv")
  //</editor-fold>
  public BumpVectorContext /*&*/ getNodeAllocator() {
    return BVC;
  }

  
  // JAVA: typedef llvm::DenseMap<const ExplodedNode *, ExplodedNode *> NodeMap
//  public final class NodeMap extends DenseMap</*const*/ ExplodedNode /*P*/ , ExplodedNode /*P*/ >{ };
  
  /// Creates a trimmed version of the graph that only contains paths leading
  /// to the given nodes.
  ///
  /// \param Nodes The nodes which must appear in the final graph. Presumably
  ///              these are end-of-path nodes (i.e. they have no successors).
  /// \param[out] ForwardMap A optional map from nodes in this graph to nodes in
  ///                        the returned graph.
  /// \param[out] InverseMap An optional map from nodes in the returned graph to
  ///                        nodes in this graph.
  /// \returns The trimmed graph
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::trim">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 347,
   FQN="clang::ento::ExplodedGraph::trim", NM="_ZNK5clang4ento13ExplodedGraph4trimEN4llvm8ArrayRefIPKNS0_12ExplodedNodeEEEPNS2_8DenseMapIS6_S6_NS2_12DenseMapInfoIS6_EENS2_6detail12DenseMapPairIS6_S6_EEEESF_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZNK5clang4ento13ExplodedGraph4trimEN4llvm8ArrayRefIPKNS0_12ExplodedNodeEEEPNS2_8DenseMapIS6_S6_NS2_12DenseMapInfoIS6_EENS2_6detail12DenseMapPairIS6_S6_EEEESF_")
  //</editor-fold>
  public std.unique_ptr<ExplodedGraph> trim(ArrayRef</*const*/ ExplodedNode /*P*/ > Sinks) /*const*/ {
    return trim(Sinks, 
      (DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/)null, 
      (DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/)null);
  }
  public std.unique_ptr<ExplodedGraph> trim(ArrayRef</*const*/ ExplodedNode /*P*/ > Sinks, 
      DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/ ForwardMap/*= null*/) /*const*/ {
    return trim(Sinks, 
      ForwardMap, 
      (DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/)null);
  }
  public std.unique_ptr<ExplodedGraph> trim(ArrayRef</*const*/ ExplodedNode /*P*/ > Sinks, 
      DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/ ForwardMap/*= null*/, 
      DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*P*/ InverseMap/*= null*/) /*const*/ {
    std.unique_ptr<ExplodedGraph> G = null;
    try {
      if (Nodes.empty()) {
        return new std.unique_ptr<ExplodedGraph>(JD$NullPtr.INSTANCE, null);
      }
      
      // JAVA: typedef llvm::DenseSet<const ExplodedNode *> Pass1Ty
//      final class Pass1Ty extends DenseSet</*const*/ ExplodedNode /*P*/ >{ };
      DenseSet</*const*/ ExplodedNode /*P*/ > Pass1/*J*/= new DenseSet</*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info());
      
      // JAVA: typedef InterExplodedGraphMap Pass2Ty
//      final class Pass2Ty extends DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ >{ };
      DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > Pass2Scratch/*J*/= new DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ExplodedNode /*P*/ )null);
      final DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > /*&*/ Pass2 = (ForwardMap != null) ? $Deref(ForwardMap) : Pass2Scratch;
      
      SmallVector</*const*/ ExplodedNode /*P*/ > WL1/*J*/= new SmallVector</*const*/ ExplodedNode /*P*/ >(10, (/*const*/ ExplodedNode /*P*/ )null);
      SmallVector</*const*/ ExplodedNode /*P*/ > WL2/*J*/= new SmallVector</*const*/ ExplodedNode /*P*/ >(10, (/*const*/ ExplodedNode /*P*/ )null);

      // ===- Pass 1 (reverse DFS) -===
      for (type$ptr</*const*/ ExplodedNode /*P*/ /*P*/> I = $tryClone(Sinks.begin()), /*P*/ E = $tryClone(Sinks.end());
           $noteq_ptr(I, E); I.$preInc()) {
        if ((I.$star() != null)) {
          WL1.push_back(I.$star());
        }
      }
      
      // Process the first worklist until it is empty.
      while (!WL1.empty()) {
        /*const*/ ExplodedNode /*P*/ N = WL1.pop_back_val();
        
        // Have we already visited this node?  If so, continue to the next one.
        if (!Pass1.insert(N).second) {
          continue;
        }
        
        // If this is a root enqueue it to the second worklist.
        if (N.Preds.empty()) {
          WL2.push_back(N);
          continue;
        }
        
        // Visit our predecessors and enqueue them.
        WL1.append_T(N.Preds.begin(), N.Preds.end());
      }
      
      // We didn't hit a root? Return with a null pointer for the new graph.
      if (WL2.empty()) {
        return new std.unique_ptr<ExplodedGraph>(JD$NullPtr.INSTANCE, null);
      }
      
      // Create an empty graph.
      G = MakeEmptyGraph();
      
      // ===- Pass 2 (forward DFS to construct the new graph) -===
      while (!WL2.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*const*/ ExplodedNode /*P*/ N = WL2.pop_back_val();
          
          // Skip this node if we have already processed it.
          if (Pass2.find(N).$noteq(/*NO_ITER_COPY*/Pass2.end())) {
            continue;
          }
          
          // Create the corresponding node in the new graph and record the mapping
          // from the old node to the new node.
          ExplodedNode /*P*/ NewN = $c$.clean(G.$arrow().createUncachedNode(N.getLocation(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(N.State)), N.isSink()));
          Pass2.$set(N, NewN);
          
          // Also record the reverse mapping from the new node to the old node.
          if ((InverseMap != null)) {
            ($Deref(InverseMap)).$set(NewN, N);
          }
          
          // If this node is a root, designate it as such in the graph.
          if (N.Preds.empty()) {
            G.$arrow().addRoot(NewN);
          }
          
          // In the case that some of the intended predecessors of NewN have already
          // been created, we should hook them up as predecessors.
          
          // Walk through the predecessors of 'N' and hook up their corresponding
          // nodes in the new graph (if any) to the freshly created node.
          for (type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> I = $tryClone(N.Preds.begin()), /*P*/ /*const*/ /*P*/ E = $tryClone(N.Preds.end());
               $noteq_ptr(I, E); I.$preInc()) {
            DenseMapIterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > PI = Pass2.find(I.$star());
            if (PI.$eq(/*NO_ITER_COPY*/Pass2.end())) {
              continue;
            }
            
            NewN.addPredecessor(((/*const_cast*/ExplodedNode /*P*/ )(PI.$arrow().second)), G.$star());
          }
          
          // In the case that some of the intended successors of NewN have already
          // been created, we should hook them up as successors.  Otherwise, enqueue
          // the new nodes from the original graph that should have nodes created
          // in the new graph.
          for (type$ptr<ExplodedNode /*P*/ /*const*/ /*P*/> I = $tryClone(N.Succs.begin()), /*P*/ /*const*/ /*P*/ E = $tryClone(N.Succs.end());
               $noteq_ptr(I, E); I.$preInc()) {
            DenseMapIterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > PI = Pass2.find(I.$star());
            if (PI.$noteq(/*NO_ITER_COPY*/Pass2.end())) {
              ((/*const_cast*/ExplodedNode /*P*/ )(PI.$arrow().second)).addPredecessor(NewN, G.$star());
              continue;
            }
            
            // Enqueue nodes to the worklist that were marked during pass 1.
            if ((Pass1.count(I.$star()) != 0)) {
              WL2.push_back(I.$star());
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
      
      return new std.unique_ptr<ExplodedGraph>(JD$Move.INSTANCE, G);
    } finally {
      if (G != null) { G.$destroy(); }
    }
  }

  
  /// Enable tracking of recently allocated nodes for potential reclamation
  /// when calling reclaimRecentlyAllocatedNodes().
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::enableNodeReclamation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/PathSensitive/ExplodedGraph.h", line = 390,
   FQN="clang::ento::ExplodedGraph::enableNodeReclamation", NM="_ZN5clang4ento13ExplodedGraph21enableNodeReclamationEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph21enableNodeReclamationEj")
  //</editor-fold>
  public void enableNodeReclamation(/*uint*/int Interval) {
    ReclaimCounter = ReclaimNodeInterval = Interval;
  }

  
  /// Reclaim "uninteresting" nodes created since the last time this method
  /// was called.
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::reclaimRecentlyAllocatedNodes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 180,
   FQN="clang::ento::ExplodedGraph::reclaimRecentlyAllocatedNodes", NM="_ZN5clang4ento13ExplodedGraph29reclaimRecentlyAllocatedNodesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph29reclaimRecentlyAllocatedNodesEv")
  //</editor-fold>
  public void reclaimRecentlyAllocatedNodes() {
    if (ChangedNodes.empty()) {
      return;
    }
    
    // Only periodically reclaim nodes so that we can build up a set of
    // nodes that meet the reclamation criteria.  Freshly created nodes
    // by definition have no successor, and thus cannot be reclaimed (see below).
    assert ($greater_uint(ReclaimCounter, 0));
    if (--ReclaimCounter != 0) {
      return;
    }
    ReclaimCounter = ReclaimNodeInterval;
    
    for (std.vector.iterator<ExplodedNode /*P*/ > it = ChangedNodes.begin(), et = ChangedNodes.end();
         $noteq___normal_iterator$C(it, et); it.$preInc()) {
      ExplodedNode /*P*/ node = it.$star();
      if (shouldCollect(node)) {
        collectNode(node);
      }
    }
    ChangedNodes.clear();
  }

  
  /// \brief Returns true if nodes for the given expression kind are always
  ///        kept around.
  
  //===----------------------------------------------------------------------===//
  // Node reclamation.
  //===----------------------------------------------------------------------===//
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::isInterestingLValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 59,
   FQN="clang::ento::ExplodedGraph::isInterestingLValueExpr", NM="_ZN5clang4ento13ExplodedGraph23isInterestingLValueExprEPKNS_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph23isInterestingLValueExprEPKNS_4ExprE")
  //</editor-fold>
  public static boolean isInterestingLValueExpr(/*const*/ Expr /*P*/ Ex) {
    if (!Ex.isLValue()) {
      return false;
    }
    return isa_DeclRefExpr(Ex)
       || isa_MemberExpr(Ex)
       || isa_ObjCIvarRefExpr(Ex);
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::shouldCollect">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 67,
   FQN="clang::ento::ExplodedGraph::shouldCollect", NM="_ZN5clang4ento13ExplodedGraph13shouldCollectEPKNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph13shouldCollectEPKNS0_12ExplodedNodeE")
  //</editor-fold>
  private boolean shouldCollect(/*const*/ ExplodedNode /*P*/ node) {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> pred_state = null;
    try {
      // First, we only consider nodes for reclamation of the following
      // conditions apply:
      //
      // (1) 1 predecessor (that has one successor)
      // (2) 1 successor (that has one predecessor)
      //
      // If a node has no successor it is on the "frontier", while a node
      // with no predecessor is a root.
      //
      // After these prerequisites, we discard all "filler" nodes that
      // are used only for intermediate processing, and are not essential
      // for analyzer history:
      //
      // (a) PreStmtPurgeDeadSymbols
      //
      // We then discard all other nodes where *all* of the following conditions
      // apply:
      //
      // (3) The ProgramPoint is for a PostStmt, but not a PostStore.
      // (4) There is no 'tag' for the ProgramPoint.
      // (5) The 'store' is the same as the predecessor.
      // (6) The 'GDM' is the same as the predecessor.
      // (7) The LocationContext is the same as the predecessor.
      // (8) Expressions that are *not* lvalue expressions.
      // (9) The PostStmt isn't for a non-consumed Stmt or Expr.
      // (10) The successor is neither a CallExpr StmtPoint nor a CallEnter or
      //      PreImplicitCall (so that we would be able to find it when retrying a
      //      call with no inlining).
      // FIXME: It may be safe to reclaim PreCall and PostCall nodes as well.

      // Conditions 1 and 2.
      if (node.pred_size() != 1 || node.succ_size() != 1) {
        return false;
      }

      /*const*/ ExplodedNode /*P*/ pred = (node.pred_begin$Const()).$star();
      if (pred.succ_size() != 1) {
        return false;
      }

      /*const*/ ExplodedNode /*P*/ succ = (node.succ_begin$Const()).$star();
      if (succ.pred_size() != 1) {
        return false;
      }

      // Now reclaim any nodes that are (by definition) not essential to
      // analysis history and are not consulted by any client code.
      ProgramPoint progPoint = node.getLocation();
      if (progPoint.getAs(PreStmtPurgeDeadSymbols.class).$bool()) {
        return !(progPoint.getTag() != null);
      }

      // Condition 3.
      if (!progPoint.getAs(org.clang.analysis.PostStmt.class).$bool() || progPoint.getAs(PostStore.class).$bool()) {
        return false;
      }

      // Condition 4.
      if ((progPoint.getTag() != null)) {
        return false;
      }

      // Conditions 5, 6, and 7.
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(node.getState());
      pred_state = new IntrusiveRefCntPtr</*const*/ ProgramState>(pred.getState());
      if ($noteq_ptr(state.$arrow().store, pred_state.$arrow().store) || state.$arrow().GDM.$noteq(pred_state.$arrow().GDM)
         || progPoint.getLocationContext() != pred.getLocationContext()) {
        return false;
      }

      // All further checks require expressions. As per #3, we know that we have
      // a PostStmt.
      /*const*/ Expr /*P*/ Ex = dyn_cast_Expr(progPoint.castAs(org.clang.analysis.PostStmt.class).getStmt());
      if (!(Ex != null)) {
        return false;
      }

      // Condition 8.
      // Do not collect nodes for "interesting" lvalue expressions since they are
      // used extensively for generating path diagnostics.
      if (isInterestingLValueExpr(Ex)) {
        return false;
      }

      // Condition 9.
      // Do not collect nodes for non-consumed Stmt or Expr to ensure precise
      // diagnostic generation; specifically, so that we could anchor arrows
      // pointing to the beginning of statements (as written in code).
      final ParentMap /*&*/ PM = progPoint.getLocationContext().getParentMap();
      if (!PM.isConsumedExpr_Expr$C$P(Ex)) {
        return false;
      }

      // Condition 10.
      /*const*/ ProgramPoint SuccLoc = succ.getLocation();
      {
        Optional<StmtPoint> SP = SuccLoc.getAs(StmtPoint.class);
        if (SP.$bool()) {
          if (CallEvent.isCallStmt(SP.$arrow().getStmt())) {
            return false;
          }
        }
      }

      // Condition 10, continuation.
      if (SuccLoc.getAs(CallEnter.class).$bool() || SuccLoc.getAs(PreImplicitCall.class).$bool()) {
        return false;
      }

      return true;
    } finally {
     if (pred_state != null) { pred_state.$destroy(); }
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::ExplodedGraph::collectNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp", line = 164,
   FQN="clang::ento::ExplodedGraph::collectNode", NM="_ZN5clang4ento13ExplodedGraph11collectNodeEPNS0_12ExplodedNodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/ExplodedGraph.cpp -nm=_ZN5clang4ento13ExplodedGraph11collectNodeEPNS0_12ExplodedNodeE")
  //</editor-fold>
  private void collectNode(ExplodedNode /*P*/ node) {
    // Removing a node means:
    // (a) changing the predecessors successor to the successor of this node
    // (b) changing the successors predecessor to the predecessor of this node
    // (c) Putting 'node' onto freeNodes.
    assert (node.pred_size() == 1 || node.succ_size() == 1);
    ExplodedNode /*P*/ pred = (node.pred_begin()).$star();
    ExplodedNode /*P*/ succ = (node.succ_begin()).$star();
    pred.replaceSuccessor(succ);
    succ.replacePredecessor(pred);
    FreeNodes.push_back_T$C$R(node);
    Nodes.RemoveNode(node);
    --NumNodes;
    node.$destroy();
  }

  
  @Override public String toString() {
    return "" + "Roots=" + Roots // NOI18N
              + ",\nEndNodes=" + EndNodes // NOI18N
              + ",\nNumNodes=" + NumNodes // NOI18N
              + ", Nodes=" + Nodes // NOI18N
              + ",\nBVC=" + "[BumpVectorContext]" // NOI18N
              + ", ChangedNodes=" + ChangedNodes // NOI18N
              + ", FreeNodes=" + FreeNodes // NOI18N
              + ", ReclaimNodeInterval=" + ReclaimNodeInterval // NOI18N
              + ", ReclaimCounter=" + ReclaimCounter; // NOI18N
  }
}
