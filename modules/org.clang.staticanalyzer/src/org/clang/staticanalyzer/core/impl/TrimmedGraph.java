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
package org.clang.staticanalyzer.core.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;


/// A wrapper around a trimmed graph and its node maps.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2801,
 FQN="(anonymous namespace)::TrimmedGraph", NM="_ZN12_GLOBAL__N_112TrimmedGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_112TrimmedGraphE")
//</editor-fold>
public class TrimmedGraph implements Destructors.ClassWithDestructor {
  private DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > InverseMap;
  
  // JAVA: typedef llvm::DenseMap<const ExplodedNode *, unsigned int> PriorityMapTy
//  public final class PriorityMapTy extends DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ >{ };
  private DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ > PriorityMap;
  
  // JAVA: typedef std::pair<const ExplodedNode *, size_t> NodeIndexPair
//  public final class NodeIndexPair extends std.pairPtrUInt</*const*/ ExplodedNode /*P*/ >{ };
  private SmallVector<std.pairPtrUInt</*const*/ ExplodedNode /*P*/ >> ReportNodes;
  
  private std.unique_ptr<ExplodedGraph> G;
  
  /// A helper class for sorting ExplodedNodes by priority.
  /*template <bool Descending> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::PriorityCompare">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2813,
   FQN="(anonymous namespace)::TrimmedGraph::PriorityCompare", NM="_ZN12_GLOBAL__N_112TrimmedGraph15PriorityCompareE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_112TrimmedGraph15PriorityCompareE")
  //</editor-fold>
  public static class PriorityCompare/*<boolean Descending>*/  implements Compare<std.pairPtrUInt</*const*/ ExplodedNode /*P*/ >> {
    /*template parameter*/ private final boolean Descending;
    
    private final /*const*/DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ > /*&*/ PriorityMap;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::PriorityCompare::PriorityCompare<Descending>">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2818,
     FQN="(anonymous namespace)::TrimmedGraph::PriorityCompare::PriorityCompare<Descending>", NM="_ZN12_GLOBAL__N_112TrimmedGraph15PriorityCompareC1ERKN4llvm8DenseMapIPKN5clang4ento12ExplodedNodeEjNS2_12DenseMapInfoIS8_EENS2_6detail12DenseMapPairIS8_jEEEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_112TrimmedGraph15PriorityCompareC1ERKN4llvm8DenseMapIPKN5clang4ento12ExplodedNodeEjNS2_12DenseMapInfoIS8_EENS2_6detail12DenseMapPairIS8_jEEEE")
    //</editor-fold>
    public PriorityCompare(boolean Descending, final /*const*/DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ > /*&*/ M) {
      // : PriorityMap(M) 
      //START JInit
      /*template parameter*/ this.Descending = Descending;
      this./*&*/PriorityMap=/*&*/M;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::PriorityCompare::operator()">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2820,
     FQN="(anonymous namespace)::TrimmedGraph::PriorityCompare::operator()", NM="_ZNK12_GLOBAL__N_112TrimmedGraph15PriorityCompareclEPKN5clang4ento12ExplodedNodeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK12_GLOBAL__N_112TrimmedGraph15PriorityCompareclEPKN5clang4ento12ExplodedNodeES6_")
    //</editor-fold>
    public boolean $call(/*const*/ ExplodedNode /*P*/ LHS, /*const*/ ExplodedNode /*P*/ RHS) /*const*/ {
      DenseMapIteratorTypeUInt</*const*/ ExplodedNode /*P*/ /*P*/> LI = PriorityMap.find(LHS);
      DenseMapIteratorTypeUInt</*const*/ ExplodedNode /*P*/ /*P*/> RI = PriorityMap.find(RHS);
      DenseMapIteratorTypeUInt</*const*/ ExplodedNode /*P*/ /*P*/> E = PriorityMap.end();
      if (LI.$eq(E)) {
        return Descending;
      }
      if (RI.$eq(E)) {
        return !Descending;
      }
      
      return Descending ? $greater_uint(LI.$arrow().second, RI.$arrow().second) : $less_uint(LI.$arrow().second, RI.$arrow().second);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::PriorityCompare::operator()">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2834,
     FQN="(anonymous namespace)::TrimmedGraph::PriorityCompare::operator()", NM="_ZNK12_GLOBAL__N_112TrimmedGraph15PriorityCompareclERKSt4pairIPKN5clang4ento12ExplodedNodeEjESA_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZNK12_GLOBAL__N_112TrimmedGraph15PriorityCompareclERKSt4pairIPKN5clang4ento12ExplodedNodeEjESA_")
    //</editor-fold>
    public boolean $call(final /*const*/std.pairPtrUInt</*const*/ ExplodedNode /*P*/ > /*&*/ LHS, final /*const*/std.pairPtrUInt</*const*/ ExplodedNode /*P*/ > /*&*/ RHS) /*const*/ {
      return $call(LHS.first, RHS.first);
    }

    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    @Override
    public boolean $less(pairPtrUInt<ExplodedNode> first, pairPtrUInt<ExplodedNode> second) {
      return $call(first, second);
    }

    @Override
    public boolean compare(pairPtrUInt<ExplodedNode> first, pairPtrUInt<ExplodedNode> second) {
      return $call(first, second);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
  
    @Override public String toString() {
      return "" + "PriorityMap=" + PriorityMap; // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::TrimmedGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2847,
   FQN="(anonymous namespace)::TrimmedGraph::TrimmedGraph", NM="_ZN12_GLOBAL__N_112TrimmedGraphC1EPKN5clang4ento13ExplodedGraphEN4llvm8ArrayRefIPKNS2_12ExplodedNodeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_112TrimmedGraphC1EPKN5clang4ento13ExplodedGraphEN4llvm8ArrayRefIPKNS2_12ExplodedNodeEEE")
  //</editor-fold>
  public TrimmedGraph(/*const*/ ExplodedGraph /*P*/ OriginalGraph, 
      ArrayRef</*const*/ ExplodedNode /*P*/ > Nodes) {
    // : InverseMap(), PriorityMap(), ReportNodes(), G() 
    //START JInit
    this.InverseMap = new DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ExplodedNode /*P*/ )null);
    this.PriorityMap = new DenseMapTypeUInt</*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 0);
    this.ReportNodes = new SmallVector<std.pairPtrUInt</*const*/ ExplodedNode /*P*/ >>(32, new std.pairPtrUInt</*const*/ ExplodedNode /*P*/ >());
    this.G = new std.unique_ptr<ExplodedGraph>();
    //END JInit
    std.queue</*const*/ ExplodedNode /*P*/ > WS = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The trimmed graph is created in the body of the constructor to ensure
      // that the DenseMaps have been initialized already.
      DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > ForwardMap/*J*/= new DenseMap</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), (/*const*/ ExplodedNode /*P*/ )null);
      $c$.clean(G.$assignMove($c$.track(OriginalGraph.trim(new ArrayRef</*const*/ ExplodedNode /*P*/ >(Nodes), $AddrOf(ForwardMap), $AddrOf(InverseMap)))));
      
      // Find the (first) error node in the trimmed graph.  We just need to consult
      // the node map which maps from nodes in the original graph to nodes
      // in the new graph.
      SmallPtrSet</*const*/ ExplodedNode /*P*/ > RemainingNodes/*J*/= new SmallPtrSet</*const*/ ExplodedNode /*P*/ >(DenseMapInfo$LikePtr.$Info(), 32);
      
      for (/*uint*/int i = 0, count = Nodes.size(); $less_uint(i, count); ++i) {
        {
          /*const*/ ExplodedNode /*P*/ NewNode = ForwardMap.lookup(Nodes.$at(i));
          if ((NewNode != null)) {
            ReportNodes.push_back(std.make_pair_Ptr_uint(NewNode, i));
            RemainingNodes.insert(NewNode);
          }
        }
      }
      assert (!RemainingNodes.empty()) : "No error node found in the trimmed graph";
      
      // Perform a forward BFS to find all the shortest paths.
      WS/*J*/= new std.queue</*const*/ ExplodedNode /*P*/ >(true);
      assert (G.$arrow().num_roots() == 1);
      WS.push_value_type(G.$arrow().roots_begin().$star());
      /*uint*/int Priority = 0;
      while (!WS.empty()) {
        /*const*/ ExplodedNode /*P*/ Node = WS.front();
        WS.pop();
        // JAVA: unfold std.tie
        std.pairTypeBool<DenseMapIteratorTypeUInt<ExplodedNode>> tmp = PriorityMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(Node, Priority));
        DenseMapIteratorTypeUInt</*const*/ ExplodedNode /*P*/ /*P*/> PriorityEntry/*J*/= tmp.first;
        boolean IsNew = tmp.second;
        //std.tie(PriorityEntry, IsNew).$assign(
        //    PriorityMap.insert_pair$KeyT$ValueT(std.make_pair_Ptr_uint(Node, Priority))
        //);
        ++Priority;
        if (!IsNew) {
          assert ($lesseq_uint(PriorityEntry.$arrow().second, Priority));
          continue;
        }
        if (RemainingNodes.erase(Node)) {
          if (RemainingNodes.empty()) {
            break;
          }
        }
        
        for (type$ptr</*const*/ ExplodedNode /*P*/ /*const*/ /*P*/> I = $tryClone(Node.succ_begin$Const()), 
            /*P*/ /*const*/ /*P*/ E = $tryClone(Node.succ_end$Const());
             $noteq_ptr(I, E); I.$preInc())  {
          WS.push_value_type$C(I.$star());
        }
      }
      
      // Sort the error paths from longest to shortest.
      std.sort(ReportNodes.begin(), ReportNodes.end(), 
          new PriorityCompare/*<true>*/(true, PriorityMap));
    } finally {
      if (WS != null) { WS.$destroy(); }
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::popNextReportGraph">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2905,
   FQN="(anonymous namespace)::TrimmedGraph::popNextReportGraph", NM="_ZN12_GLOBAL__N_112TrimmedGraph18popNextReportGraphERNS_11ReportGraphE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_112TrimmedGraph18popNextReportGraphERNS_11ReportGraphE")
  //</editor-fold>
  public boolean popNextReportGraph(final ReportGraph /*&*/ GraphWrapper) {
    unique_ptr<ExplodedGraph> GNew = null;
    try {
      if (ReportNodes.empty()) {
        return false;
      }
      
      // JAVA: unfold std.tie
      pairTypeUInt<ExplodedNode> tmp = ReportNodes.pop_back_val();
      ExplodedNode /*P*/ OrigN = tmp.first;
      GraphWrapper.Index = tmp.second;
      //std.tie(OrigN, GraphWrapper.Index).$assign(ReportNodes.pop_back_val());
      assert (PriorityMap.find(OrigN).$noteq(/*NO_ITER_COPY*/PriorityMap.end())) : "error node not accessible from root";
      
      // Create a new graph with a single path.  This is the graph
      // that will be returned to the caller.
      GNew = llvm.make_unique(new ExplodedGraph());
      GraphWrapper.BackMap.clear();
      
      // Now walk from the error node up the BFS path, always taking the
      // predeccessor with the lowest number.
      ExplodedNode /*P*/ Succ = null;
      while (true) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Create the equivalent node in the new graph with the same state
          // and location.
          ExplodedNode /*P*/ NewN = $c$.clean(GNew.$arrow().createUncachedNode(OrigN.getLocation(), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(OrigN.getState())), 
              OrigN.isSink()));
          
          // Store the mapping to the original node.
          DenseMapIterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ > IMitr = new DenseMapIterator</*const*/ ExplodedNode /*P*/ , /*const*/ ExplodedNode /*P*/ >(InverseMap.find(OrigN));
          assert (IMitr.$noteq(/*NO_ITER_COPY*/InverseMap.end())) : "No mapping to original node.";
          GraphWrapper.BackMap.$set(NewN, IMitr.$arrow().second);
          
          // Link up the new node with the previous node.
          if ((Succ != null)) {
            Succ.addPredecessor(NewN, GNew.$star());
          } else {
            GraphWrapper.ErrorNode = NewN;
          }
          
          Succ = NewN;
          
          // Are we at the final node?
          if (OrigN.pred_empty()) {
            GNew.$arrow().addRoot(NewN);
            break;
          }
          
          // Find the next predeccessor node.  We choose the node that is marked
          // with the lowest BFS number.
          OrigN = std.min_element(OrigN.pred_begin$Const(), OrigN.pred_end$Const(), 
                  new Compare<ExplodedNode>(){
                    final PriorityCompare comaprator = new PriorityCompare(false, PriorityMap);
                    @Override
                    public boolean compare(ExplodedNode a, ExplodedNode b) {
                      return comaprator.$call(a, b);
                    }
                  }
              //new PriorityCompare(false, PriorityMap)
                      ).$star();
        } finally {
          $c$.$destroy();
        }
      }
      
      GraphWrapper.Graph.$assignMove(std.move(GNew));
      
      return true;
    } finally {
      if (GNew != null) { GNew.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TrimmedGraph::~TrimmedGraph">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp", line = 2801,
   FQN="(anonymous namespace)::TrimmedGraph::~TrimmedGraph", NM="_ZN12_GLOBAL__N_112TrimmedGraphD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/BugReporter.cpp -nm=_ZN12_GLOBAL__N_112TrimmedGraphD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    G.$destroy();
    ReportNodes.$destroy();
    PriorityMap.$destroy();
    InverseMap.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "InverseMap=" + InverseMap // NOI18N
              + ", PriorityMap=" + PriorityMap // NOI18N
              + ", ReportNodes=" + ReportNodes // NOI18N
              + ", G=" + G; // NOI18N
  }
}
