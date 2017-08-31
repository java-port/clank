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
import org.clank.support.aliases.type$ptr;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;

/*template <typename DERIVED> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 638,
 FQN="(anonymous namespace)::ClusterAnalysis", NM="_ZN12_GLOBAL__N_115ClusterAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysisE")
//</editor-fold>
public abstract class ClusterAnalysis</*typename*/ DERIVED extends ClusterAnalysis>  implements Destructors.ClassWithDestructor {
/*protected:*/
  // JAVA: typedef llvm::DenseMap<const MemRegion *, const ClusterBindings *> ClusterMap
//  public final class ClusterMap extends DenseMap</*const*/ MemRegion /*P*/ , /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ >{ };
  // JAVA: typedef const MemRegion *WorkListElement
//  public final class WorkListElement extends /*const*/ MemRegion /*P*/ { };
  // JAVA: typedef SmallVector<WorkListElement, 10> WorkList
//  public final class WorkList extends SmallVector</*const*/ MemRegion /*P*/ >{ };
  
  protected final SmallPtrSet</*const*/ ImmutableMap<BindingKey, SVal> /*P*/ > Visited;
  
  protected final SmallVector</*const*/ MemRegion /*P*/ > WL;
  
  protected final RegionStoreManager /*&*/ RM;
  protected final ASTContext /*&*/ Ctx;
  protected final SValBuilder /*&*/ svalBuilder;
  
  protected RegionBindingsRef B;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::getCluster">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 657,
   FQN="(anonymous namespace)::ClusterAnalysis::getCluster", NM="_ZN12_GLOBAL__N_115ClusterAnalysis10getClusterEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis10getClusterEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  protected /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ getCluster(/*const*/ MemRegion /*P*/ R) {
    // JAVA: B keeps ImmutableMap as VALUE, so if exists, then non-null
    // Visited prevents keeping NULL
    type$ptr<ImmutableMap<BindingKey, SVal>> $lookup = B.lookup(R);
    return $lookup == null ? null : $lookup.$star();
  }

  
  /// Returns true if all clusters in the given memspace should be initially
  /// included in the cluster analysis. Subclasses may provide their
  /// own implementation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::includeEntireMemorySpace">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 664,
   FQN="(anonymous namespace)::ClusterAnalysis::includeEntireMemorySpace", NM="_ZN12_GLOBAL__N_115ClusterAnalysis24includeEntireMemorySpaceEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis24includeEntireMemorySpaceEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  protected boolean includeEntireMemorySpace(/*const*/ MemRegion /*P*/ Base) {
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::ClusterAnalysis<DERIVED>">
  @Converted(kind = Converted.Kind.MANUAL_INSTANTIATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 669,
   FQN="(anonymous namespace)::ClusterAnalysis::ClusterAnalysis<DERIVED>", NM="_ZN12_GLOBAL__N_115ClusterAnalysisC1ERNS_18RegionStoreManagerERN5clang4ento19ProgramStateManagerENS_17RegionBindingsRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysisC1ERNS_18RegionStoreManagerERN5clang4ento19ProgramStateManagerENS_17RegionBindingsRefE")
  //</editor-fold>
  private ClusterAnalysis(final RegionStoreManager /*&*/ rm, final ProgramStateManager /*&*/ StateMgr, 
      RegionBindingsRef b) {
    // : RM(rm), Ctx(StateMgr.getContext()), svalBuilder(StateMgr.getSValBuilder()), B(std::move(b)) 
    //START JInit
    this.Visited = new SmallPtrSet</*const*/ ImmutableMap<BindingKey, SVal> /*P*/>(DenseMapInfo$LikePtr.$Info(), 16);
    this.WL = new SmallVector</*const*/ MemRegion /*P*/>(10, (/*const*/MemRegion /*P*/) null);
    this./*&*/RM=/*&*/rm;
    this./*&*/Ctx=/*&*/StateMgr.getContext();
    this./*&*/svalBuilder=/*&*/StateMgr.getSValBuilder();
    this.B = new RegionBindingsRef(JD$Move.INSTANCE, std.move(b));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::getRegionBindings">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 674,
   FQN="(anonymous namespace)::ClusterAnalysis::getRegionBindings", NM="_ZNK12_GLOBAL__N_115ClusterAnalysis17getRegionBindingsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZNK12_GLOBAL__N_115ClusterAnalysis17getRegionBindingsEv")
  //</editor-fold>
  public RegionBindingsRef getRegionBindings() /*const*/ {
    return B;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::isVisited">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 676,
   FQN="(anonymous namespace)::ClusterAnalysis::isVisited", NM="_ZN12_GLOBAL__N_115ClusterAnalysis9isVisitedEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis9isVisitedEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public boolean isVisited(/*const*/ MemRegion /*P*/ R) {
    return Visited.count(getCluster(R)) != 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::GenerateClusters">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 680,
   FQN="(anonymous namespace)::ClusterAnalysis::GenerateClusters", NM="_ZN12_GLOBAL__N_115ClusterAnalysis16GenerateClustersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis16GenerateClustersEv")
  //</editor-fold>
  public void GenerateClusters() {
    // Scan the entire set of bindings and record the region clusters.
    for (ImmutableMapRefPtrType.iterator<MemRegion, ImmutableMap<BindingKey, SVal>> RI = B.begin(), RE = B.end();
         RI.$noteq(RE); RI.$preInc()) {
      /*const*/ MemRegion /*P*/ Base = RI.getKey();
      
      final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ Cluster = RI.getData();
      assert (!Cluster.isEmpty()) : "Empty clusters should be removed";
      ((/*static_cast*/DERIVED /*P*/ )(this)).VisitAddedToCluster(Base, Cluster);
      
      // If the base's memspace should be entirely invalidated, add the cluster
      // to the workspace up front.
      if (((/*static_cast*/DERIVED /*P*/ )(this)).includeEntireMemorySpace(Base)) {
        AddToWorkList(((/*const*/ MemRegion /*P*/ )(Base)), $AddrOf(Cluster));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::AddToWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 697,
   FQN="(anonymous namespace)::ClusterAnalysis::AddToWorkList", NM="_ZN12_GLOBAL__N_115ClusterAnalysis13AddToWorkListEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis13AddToWorkListEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE")
  //</editor-fold>
  public boolean AddToWorkList(/*const*/ MemRegion /*P*/ E, /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ C) {
    if (Native.$bool(C) && Native.$not(Visited.insert(C).second)) {
      return false;
    }
    WL.push_back(E);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::AddToWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 704,
   FQN="(anonymous namespace)::ClusterAnalysis::AddToWorkList", NM="_ZN12_GLOBAL__N_115ClusterAnalysis13AddToWorkListEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis13AddToWorkListEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public boolean AddToWorkList(/*const*/ MemRegion /*P*/ R) {
    return ((/*static_cast*/DERIVED /*P*/ )(this)).AddToWorkList(R);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::RunWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 708,
   FQN="(anonymous namespace)::ClusterAnalysis::RunWorkList", NM="_ZN12_GLOBAL__N_115ClusterAnalysis11RunWorkListEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis11RunWorkListEv")
  //</editor-fold>
  public void RunWorkList() {
    while (Native.$not(WL.empty())) {
      /*const*/ MemRegion /*P*/ E = WL.pop_back_val();
      /*const*/ MemRegion /*P*/ BaseR = E;
      
      ((/*static_cast*/DERIVED /*P*/ )(this)).VisitCluster(BaseR, getCluster(BaseR));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::VisitAddedToCluster">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 717,
   FQN="(anonymous namespace)::ClusterAnalysis::VisitAddedToCluster", NM="_ZN12_GLOBAL__N_115ClusterAnalysis19VisitAddedToClusterEPKN5clang4ento9MemRegionERKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis19VisitAddedToClusterEPKN5clang4ento9MemRegionERKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE")
  //</editor-fold>
  public void VisitAddedToCluster(/*const*/ MemRegion /*P*/ baseR, final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ C) {
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::VisitCluster">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 718,
   FQN="(anonymous namespace)::ClusterAnalysis::VisitCluster", NM="_ZN12_GLOBAL__N_115ClusterAnalysis12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE")
  //</editor-fold>
  public void VisitCluster(/*const*/ MemRegion /*P*/ baseR, /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ C) {
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClusterAnalysis::VisitCluster">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 720,
   FQN="(anonymous namespace)::ClusterAnalysis::VisitCluster", NM="_ZN12_GLOBAL__N_115ClusterAnalysis12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_115ClusterAnalysis12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEEb")
  //</editor-fold>
  public void VisitCluster(/*const*/ MemRegion /*P*/ BaseR, /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ C, 
              boolean Flag) {
    ((/*static_cast*/DERIVED /*P*/ )(this)).VisitCluster(BaseR, C);
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  // JAVA: destroy temporary passed by child class as
  // /*ExprWithCleanups*/super(rm, stateMgr, $c$.track(new RegionBindingsRef(b))
  public ClusterAnalysis(final RegionStoreManager /*&*/ rm, final ProgramStateManager /*&*/ StateMgr, 
      RegionBindingsRef b, JD$Clean _dparm) {
    this(rm, StateMgr, b);
    // do requested clean up
    if (_dparm != null) b.$destroy();
  }
  
  @Override public void $destroy() {
  }


  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "Visited=" + Visited // NOI18N
              + ", WL=" + WL // NOI18N
              + ", RM=" + "[RegionStoreManager]" // NOI18N
              + ", Ctx=" + "[ASTContext]" // NOI18N
              + ", svalBuilder=" + "[SValBuilder]" // NOI18N
              + ", B=" + B; // NOI18N
  }
}
