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

package org.clang.analysis.analyses;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.analysis.*;


// A class that performs reachability queries for CFGBlocks. Several internal
// checks in this checker require reachability information. The requests all
// tend to have a common destination, so we lazily do a predecessor search
// from the destination node and cache the results to prevent work
// duplication.
//<editor-fold defaultstate="collapsed" desc="clang::CFGReverseBlockReachabilityAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/CFGReachabilityAnalysis.h", line = 32,
 FQN="clang::CFGReverseBlockReachabilityAnalysis", NM="_ZN5clang35CFGReverseBlockReachabilityAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang35CFGReverseBlockReachabilityAnalysisE")
//</editor-fold>
public class CFGReverseBlockReachabilityAnalysis implements Destructors.ClassWithDestructor {
  /*typedef llvm::BitVector ReachableSet*/
//  public final class ReachableSet extends BitVector{ };
  /*typedef llvm::DenseMap<unsigned int, ReachableSet> ReachableMap*/
//  public final class ReachableMap extends DenseMapUIntType<BitVector>{ };
  private BitVector analyzed;
  private DenseMapUIntType<BitVector> reachable;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::CFGReverseBlockReachabilityAnalysis::CFGReverseBlockReachabilityAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGReachabilityAnalysis.cpp", line = 22,
   FQN="clang::CFGReverseBlockReachabilityAnalysis::CFGReverseBlockReachabilityAnalysis", NM="_ZN5clang35CFGReverseBlockReachabilityAnalysisC1ERKNS_3CFGE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGReachabilityAnalysis.cpp -nm=_ZN5clang35CFGReverseBlockReachabilityAnalysisC1ERKNS_3CFGE")
  //</editor-fold>
  public CFGReverseBlockReachabilityAnalysis(final /*const*/ CFG /*&*/ cfg) {
    // : analyzed(cfg.getNumBlockIDs(), false), reachable() 
    //START JInit
    this.analyzed = new BitVector(cfg.getNumBlockIDs(), false);
    this.reachable = new DenseMapUIntType<BitVector>(DenseMapInfoUInt.$Info(), new BitVector());
    //END JInit
  }


  
  /// Returns true if the block 'Dst' can be reached from block 'Src'.
  
  /// Returns true if the block 'Dst' can be reached from block 'Src'.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGReverseBlockReachabilityAnalysis::isReachable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGReachabilityAnalysis.cpp", line = 25,
   FQN="clang::CFGReverseBlockReachabilityAnalysis::isReachable", NM="_ZN5clang35CFGReverseBlockReachabilityAnalysis11isReachableEPKNS_8CFGBlockES3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGReachabilityAnalysis.cpp -nm=_ZN5clang35CFGReverseBlockReachabilityAnalysis11isReachableEPKNS_8CFGBlockES3_")
  //</editor-fold>
  public boolean isReachable(/*const*/ CFGBlock /*P*/ Src, 
             /*const*/ CFGBlock /*P*/ Dst) {
    
    /*const*//*uint*/int DstBlockID = Dst.getBlockID();
    
    // If we haven't analyzed the destination node, run the analysis now
    if (!analyzed.$at(DstBlockID).$bool()) {
      mapReachability(Dst);
      analyzed.$at(DstBlockID).$assign(/*KEEP_BOOL*/true);
    }
    
    // Return the cached result
    return reachable.$at_T1$C$R(DstBlockID).$at(Src.getBlockID()).$bool();
  }


/*private:*/
  
  // Maps reachability to a common node by walking the predecessors of the
  // destination node.
  //<editor-fold defaultstate="collapsed" desc="clang::CFGReverseBlockReachabilityAnalysis::mapReachability">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGReachabilityAnalysis.cpp", line = 42,
   FQN="clang::CFGReverseBlockReachabilityAnalysis::mapReachability", NM="_ZN5clang35CFGReverseBlockReachabilityAnalysis15mapReachabilityEPKNS_8CFGBlockE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/CFGReachabilityAnalysis.cpp -nm=_ZN5clang35CFGReverseBlockReachabilityAnalysis15mapReachabilityEPKNS_8CFGBlockE")
  //</editor-fold>
  private void mapReachability(/*const*/ CFGBlock /*P*/ Dst) {
    BitVector visited = null;
    try {
      SmallVector</*const*/ CFGBlock /*P*/ > worklist/*J*/= new SmallVector</*const*/ CFGBlock /*P*/ >(11, (/*const*/ CFGBlock /*P*/ )null);
      visited/*J*/= new BitVector(analyzed.size());
      
      final BitVector /*&*/ DstReachability = reachable.$at_T1$RR(Dst.getBlockID());
      DstReachability.resize(analyzed.size(), false);
      
      // Start searching from the destination node, since we commonly will perform
      // multiple queries relating to a destination node.
      worklist.push_back(Dst);
      boolean firstRun = true;
      while (!worklist.empty()) {
        /*const*/ CFGBlock /*P*/ block = worklist.pop_back_val();
        if (visited.$at(block.getBlockID()).$bool()) {
          continue;
        }
        visited.$at(block.getBlockID()).$assign(/*KEEP_BOOL*/true);
        
        // Update reachability information for this node -> Dst
        if (!firstRun) {
          // Don't insert Dst -> Dst unless it was a predecessor of itself
          DstReachability.$at(block.getBlockID()).$assign(/*KEEP_BOOL*/true);
        } else {
          firstRun = false;
        }
        
        // Add the predecessors to the worklist.
        for (type$ptr</*const*/ CFGBlock.AdjacentBlock /*P*/ > i = $tryClone(block.pred_begin$Const()), 
            /*P*/ e = $tryClone(block.pred_end$Const()); $noteq_ptr(i, e); i.$preInc()) {
          if (((i.$star().$CFGBlock$P()) != null)) {
            worklist.push_back(i.$star().$CFGBlock$P());
          }
        }
      }
    } finally {
      if (visited != null) { visited.$destroy(); }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::CFGReverseBlockReachabilityAnalysis::~CFGReverseBlockReachabilityAnalysis">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Analysis/Analyses/CFGReachabilityAnalysis.h", line = 32,
   FQN="clang::CFGReverseBlockReachabilityAnalysis::~CFGReverseBlockReachabilityAnalysis", NM="_ZN5clang35CFGReverseBlockReachabilityAnalysisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/AnalysisDeclContext.cpp -nm=_ZN5clang35CFGReverseBlockReachabilityAnalysisD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    reachable.$destroy();
    analyzed.$destroy();
    //END JDestroy
  }

  
  @Override public String toString() {
    return "" + "analyzed=" + analyzed // NOI18N
              + ", reachable=" + reachable; // NOI18N
  }
}
