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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.analysis.analyses.*;
import org.clang.analysis.impl.*;
import static org.clang.analysis.impl.LiveVariablesStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type AnalysisClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang33runUninitializedVariablesAnalysisERKNS_11DeclContextERKNS_3CFGERNS_19AnalysisDeclContextERNS_22UninitVariablesHandlerERNS_28UninitVariablesAnalysisStatsE; -static-type=AnalysisClangGlobals -package=org.clang.analysis.analyses")
//</editor-fold>
public final class AnalysisClangGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::runUninitializedVariablesAnalysis">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 867,
 FQN="clang::runUninitializedVariablesAnalysis", NM="_ZN5clang33runUninitializedVariablesAnalysisERKNS_11DeclContextERKNS_3CFGERNS_19AnalysisDeclContextERNS_22UninitVariablesHandlerERNS_28UninitVariablesAnalysisStatsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN5clang33runUninitializedVariablesAnalysisERKNS_11DeclContextERKNS_3CFGERNS_19AnalysisDeclContextERNS_22UninitVariablesHandlerERNS_28UninitVariablesAnalysisStatsE")
//</editor-fold>
public static void runUninitializedVariablesAnalysis(final /*const*/ DeclContext /*&*/ dc, 
                                 final /*const*/ CFG /*&*/ cfg, 
                                 final AnalysisDeclContext /*&*/ ac, 
                                 final UninitVariablesHandler /*&*/ handler, 
                                 final UninitVariablesAnalysisStats /*&*/ stats) {
  CFGBlockValues vals = null;
  ClassifyRefs classification = null;
  DataflowWorklist worklist = null;
  PruneBlocksHandler PBH = null;
  try {
    vals/*J*/= new CFGBlockValues(cfg);
    vals.computeSetOfDeclarations(dc);
    if (vals.hasNoDeclarations()) {
      return;
    }
    
    stats.NumVariablesAnalyzed = vals.getNumEntries();
    
    // Precompute which expressions are uses and which are initializations.
    classification/*J*/= new ClassifyRefs(ac);
    cfg.VisitBlockStmts(classification);
    
    // Mark all variables uninitialized at the entry.
    final /*const*/ CFGBlock /*&*/ entry = cfg.getEntry$Const();
    final PackedVector /*&*/ vec = vals.getValueVector($AddrOf(entry));
    /*const*//*uint*/int n = vals.getNumEntries();
    for (/*uint*/int j = 0; $less_uint(j, n); ++j) {
      vec.$at(j).$assign(/*KEEP_ENUM*/Value.Uninitialized);
    }
    
    // Proceed with the workist.
    worklist/*J*/= new DataflowWorklist(cfg, $Deref(ac.getAnalysis(PostOrderCFGView.class)));
    BitVector previouslyVisited/*J*/= new BitVector(cfg.getNumBlockIDs());
    worklist.enqueueSuccessors($AddrOf(cfg.getEntry$Const()));
    BitVector wasAnalyzed/*J*/= new BitVector(cfg.getNumBlockIDs(), false);
    wasAnalyzed.$at(cfg.getEntry$Const().getBlockID()).$assign(/*KEEP_BOOL*/true);
    PBH/*J*/= new PruneBlocksHandler(cfg.getNumBlockIDs());
    {
      
      /*const*/ CFGBlock /*P*/ block;
      while (((/*P*/ block = worklist.dequeue()) != null)) {
        PBH.currentBlock = block.getBlockID();
        
        // Did the block change?
        boolean changed = UninitializedValuesStatics.runOnBlock(block, cfg, ac, vals, 
            classification, wasAnalyzed, PBH);
        ++stats.NumBlockVisits;
        if (changed || !previouslyVisited.$at(block.getBlockID()).$bool()) {
          worklist.enqueueSuccessors(block);
        }
        previouslyVisited.$at(block.getBlockID()).$assign(/*KEEP_BOOL*/true);
      }
    }
    if (!PBH.hadAnyUse) {
      return;
    }
    
    // Run through the blocks one more time, and report uninitialized variables.
    for (type$ptr<CFGBlock> BI = $tryClone(cfg.begin$Const()), /*P*/ BE = $tryClone(cfg.end$Const()); $noteq_ptr(BI, BE); BI.$preInc()) {
      /*const*/ CFGBlock /*P*/ block$1 = BI.$star();
      if (PBH.hadUse.$at(block$1.getBlockID()).$bool()) {
        UninitializedValuesStatics.runOnBlock(block$1, cfg, ac, vals, classification, wasAnalyzed, handler);
        ++stats.NumBlockVisits;
      }
    }
  } finally {
    if (PBH != null) { PBH.$destroy(); }
    if (worklist != null) { worklist.$destroy(); }
    if (classification != null) { classification.$destroy(); }
    if (vals != null) { vals.$destroy(); }
  }
}

} // END OF class AnalysisClangGlobals
