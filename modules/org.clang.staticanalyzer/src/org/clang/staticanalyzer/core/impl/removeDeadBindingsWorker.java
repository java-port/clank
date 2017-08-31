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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import org.clank.support.JavaDifferentiators.JD$Clean;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2273,
 FQN="(anonymous namespace)::removeDeadBindingsWorker", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorkerE")
//</editor-fold>
public class removeDeadBindingsWorker extends /*public*/ ClusterAnalysis<removeDeadBindingsWorker> implements Destructors.ClassWithDestructor {
  private SmallVector</*const*/ SymbolicRegion /*P*/ > Postponed;
  private final SymbolReaper /*&*/ SymReaper;
  private /*const*/ StackFrameContext /*P*/ CurrentLCtx;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::removeDeadBindingsWorker">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2280,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::removeDeadBindingsWorker", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorkerC1ERNS_18RegionStoreManagerERN5clang4ento19ProgramStateManagerENS_17RegionBindingsRefERNS4_12SymbolReaperEPKNS3_17StackFrameContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorkerC1ERNS_18RegionStoreManagerERN5clang4ento19ProgramStateManagerENS_17RegionBindingsRefERNS4_12SymbolReaperEPKNS3_17StackFrameContextE")
  //</editor-fold>
  public removeDeadBindingsWorker(final RegionStoreManager /*&*/ rm, 
      final ProgramStateManager /*&*/ stateMgr, 
      RegionBindingsRef b, final SymbolReaper /*&*/ symReaper, 
      /*const*/ StackFrameContext /*P*/ LCtx) {
    // : ClusterAnalysis<removeDeadBindingsWorker>(rm, stateMgr, b), Postponed(), SymReaper(symReaper), CurrentLCtx(LCtx) 
    //START JInit
    /*ExprWithCleanups*/super(rm, stateMgr, /*$c$.track(*/new RegionBindingsRef(b)/*)*/, JD$Clean.TRAILING);
    this.Postponed = new SmallVector</*const*/ SymbolicRegion /*P*/ >(12, (/*const*/ SymbolicRegion /*P*/ )null);
    this./*&*/SymReaper=/*&*/symReaper;
    this.CurrentLCtx = LCtx;
    //END JInit
  }

  
  // Called by ClusterAnalysis.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::VisitAddedToCluster">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2306,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::VisitAddedToCluster", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorker19VisitAddedToClusterEPKN5clang4ento9MemRegionERKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorker19VisitAddedToClusterEPKN5clang4ento9MemRegionERKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE")
  //</editor-fold>
  public void VisitAddedToCluster(/*const*/ MemRegion /*P*/ baseR, 
                     final /*const*/ ImmutableMap<BindingKey, SVal> /*&*/ C) {
    {
      
      /*const*/ VarRegion /*P*/ VR = dyn_cast_VarRegion(baseR);
      if ((VR != null)) {
        if (SymReaper.isLive(VR)) {
          AddToWorkList(baseR, $AddrOf(C));
        }
        
        return;
      }
    }
    {
      
      /*const*/ SymbolicRegion /*P*/ SR = dyn_cast_SymbolicRegion(baseR);
      if ((SR != null)) {
        if (SymReaper.isLive(SR.getSymbol())) {
          AddToWorkList(SR, $AddrOf(C));
        } else {
          Postponed.push_back(SR);
        }
        
        return;
      }
    }
    if (isa_NonStaticGlobalSpaceRegion(baseR)) {
      AddToWorkList(baseR, $AddrOf(C));
      return;
    }
    {
      
      // CXXThisRegion in the current or parent location context is live.
      /*const*/ CXXThisRegion /*P*/ TR = dyn_cast_CXXThisRegion(baseR);
      if ((TR != null)) {
        /*const*/ StackArgumentsSpaceRegion /*P*/ StackReg = cast_StackArgumentsSpaceRegion(TR.getSuperRegion());
        /*const*/ StackFrameContext /*P*/ RegCtx = StackReg.getStackFrame();
        if ((CurrentLCtx != null)
           && (RegCtx == CurrentLCtx || RegCtx.isParentOf(CurrentLCtx))) {
          AddToWorkList(TR, $AddrOf(C));
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::VisitCluster">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2341,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::VisitCluster", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorker12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorker12VisitClusterEPKN5clang4ento9MemRegionEPKN4llvm12ImmutableMapINS_10BindingKeyENS2_4SValENS6_16ImutKeyValueInfoIS8_S9_EEEE")
  //</editor-fold>
  public void VisitCluster(/*const*/ MemRegion /*P*/ baseR, 
              /*const*/ ImmutableMap<BindingKey, SVal> /*P*/ C) {
    if (!(C != null)) {
      return;
    }
    {
      
      // Mark the symbol for any SymbolicRegion with live bindings as live itself.
      // This means we should continue to track that symbol.
      /*const*/ SymbolicRegion /*P*/ SymR = dyn_cast_SymbolicRegion(baseR);
      if ((SymR != null)) {
        SymReaper.markLive(SymR.getSymbol());
      }
    }
    ImmutableMap.iterator<BindingKey, SVal> I = null;
    ImmutableMap.iterator<BindingKey, SVal> E = null;
    try {
      
      for (I = C.begin(), E = C.end(); I.$noteq(E); I.$preInc()) {
        // Element index of a binding key is live.
        SymReaper.markElementIndicesLive(I.getKey().getRegion());
        
        VisitBinding(new SVal(I.getData()));
      }
    } finally {
      if (E != null) { E.$destroy(); }
      if (I != null) { I.$destroy(); }
    }
  }

  //JAVA: using ClusterAnalysis<removeDeadBindingsWorker>::VisitCluster;
  
  //JAVA: using ClusterAnalysis<removeDeadBindingsWorker>::AddToWorkList;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::AddToWorkList">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2301,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::AddToWorkList", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorker13AddToWorkListEPKN5clang4ento9MemRegionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorker13AddToWorkListEPKN5clang4ento9MemRegionE")
  //</editor-fold>
  public boolean AddToWorkList(/*const*/ MemRegion /*P*/ R) {
    /*const*/ MemRegion /*P*/ BaseR = R.getBaseRegion();
    return AddToWorkList(((/*const*/ MemRegion /*P*/ )(BaseR)), getCluster(BaseR));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::UpdatePostponed">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2395,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::UpdatePostponed", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorker15UpdatePostponedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorker15UpdatePostponedEv")
  //</editor-fold>
  public boolean UpdatePostponed() {
    // See if any postponed SymbolicRegions are actually live now, after
    // having done a scan.
    boolean changed = false;
    
    for (type$ptr</*const*/ SymbolicRegion /*P*/ /*P*/> I = $tryClone(Postponed.begin()), /*P*/ E = $tryClone(Postponed.end()); $noteq_ptr(I, E); I.$preInc()) {
      {
        /*const*/ SymbolicRegion /*P*/ SR = I.$star();
        if ((SR != null)) {
          if (SymReaper.isLive(SR.getSymbol())) {
            changed |= AddToWorkList(SR);
            I.$set(null);
          }
        }
      }
    }
    
    return changed;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::VisitBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2359,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::VisitBinding", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorker12VisitBindingEN5clang4ento4SValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorker12VisitBindingEN5clang4ento4SValE")
  //</editor-fold>
  public void VisitBinding(SVal V) {
    {
      // Is it a LazyCompoundVal?  All referenced regions are live as well.
      Optional<NsNonloc.LazyCompoundVal> LCS = V.getAs(NsNonloc.LazyCompoundVal.class);
      if (LCS.$bool()) {
        
        final /*const*/std.vector<SVal> /*&*/ Vals = RM.getInterestingValues(new NsNonloc.LazyCompoundVal(LCS.$star()));
        
        for (std.vector.iterator</*const*/ SVal /*P*/ > I = Vals.begin$Const(), 
            E = Vals.end$Const();
             $noteq___normal_iterator$C(I, E); I.$preInc())  {
          VisitBinding(new SVal(I.$star()));
        }
        
        return;
      }
    }
    {
      
      // If V is a region, then add it to the worklist.
      /*const*/ MemRegion /*P*/ R = V.getAsRegion();
      if ((R != null)) {
        AddToWorkList(R);
        SymReaper.markLive(R);
        {
          
          // All regions captured by a block are also live.
          /*const*/ BlockDataRegion /*P*/ BR = dyn_cast_BlockDataRegion(R);
          if ((BR != null)) {
            BlockDataRegion.referenced_vars_iterator I = BR.referenced_vars_begin();
            BlockDataRegion.referenced_vars_iterator E = BR.referenced_vars_end();
            for (; I.$noteq(E); I.$preInc())  {
              AddToWorkList(I.getCapturedRegion());
            }
          }
        }
      }
    }
    SymExpr.symbol_iterator SI = null;
    SymExpr.symbol_iterator SE = null;
    try {
      
      // Update the set of live symbols.
      for (SI = V.symbol_begin(), SE = V.symbol_end();
           SI.$noteq(SE); SI.$preInc())  {
        SymReaper.markLive(SI.$star());
      }
    } finally {
      if (SE != null) { SE.$destroy(); }
      if (SI != null) { SI.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::removeDeadBindingsWorker::~removeDeadBindingsWorker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp", line = 2273,
   FQN="(anonymous namespace)::removeDeadBindingsWorker::~removeDeadBindingsWorker", NM="_ZN12_GLOBAL__N_124removeDeadBindingsWorkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/RegionStore.cpp -nm=_ZN12_GLOBAL__N_124removeDeadBindingsWorkerD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Postponed.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "Postponed=" + Postponed // NOI18N
              + ", SymReaper=" + SymReaper // NOI18N
              + ", CurrentLCtx=" + "[StackFrameContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
