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
package org.llvm.transforms.java;

import java.util.List;
import org.clank.support.Converted;
import org.llvm.pass.LinkAllPassesGlobals;
import org.llvm.support.raw_string_ostream;
import static org.llvm.transforms.utils.TransformsLlvmGlobals.*;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author as204739
 */
@ServiceProvider(service = LinkAllPassesGlobals.ForcePassLinking.class, position=3000)
public class ForcePassLinkingImpl extends LinkAllPassesGlobals.ForcePassLinking {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ForcePassLinking::ForcePassLinking">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/LinkAllPasses.h", line = 55,
   FQN="(anonymous namespace)::ForcePassLinking::ForcePassLinking", NM="_ZN12_GLOBAL__N_116ForcePassLinkingC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/driver/cc1_main.cpp -nm=_ZN12_GLOBAL__N_116ForcePassLinkingC1Ev")
  //</editor-fold>
  public ForcePassLinkingImpl() {
  }

  @Override
  public void create() {
      /*J:(void)*/createAggressiveDCEPass();
      /*J:(void)*/createBitTrackingDCEPass();
      /*J:(void)*/createArgumentPromotionPass();
      /*J:(void)*/createAlignmentFromAssumptionsPass();
      /*J:(void)*/createBoundsCheckingPass();
      /*J:(void)*/createBreakCriticalEdgesPass();
      /*J:(void)*/createCFGSimplificationPass();
      /*J:(void)*/createStructurizeCFGPass();
      /*J:(void)*/createConstantMergePass();
      /*J:(void)*/createConstantPropagationPass();
      /*J:(void)*/createDeadArgEliminationPass();
      /*J:(void)*/createDeadCodeEliminationPass();
      /*J:(void)*/createDeadInstEliminationPass();
      /*J:(void)*/createDeadStoreEliminationPass();
      /*J:(void)*/createPGOInstrumentationGenLegacyPass();
      /*J:(void)*/createPGOInstrumentationUseLegacyPass();
      /*J:(void)*/createPGOIndirectCallPromotionLegacyPass();
      /*J:(void)*/createFunctionImportPass();
      /*J:(void)*/createFunctionInliningPass();
      /*J:(void)*/createAlwaysInlinerPass();
      /*J:(void)*/createGlobalDCEPass();
      /*J:(void)*/createGlobalOptimizerPass();
      /*J:(void)*/createGuardWideningPass();
      /*J:(void)*/createIPConstantPropagationPass();
      /*J:(void)*/createIPSCCPPass();
      /*J:(void)*/createInductiveRangeCheckEliminationPass();
      /*J:(void)*/createIndVarSimplifyPass();
      /*J:(void)*/createInstructionCombiningPass();
      /*J:(void)*/createInternalizePass();
      /*J:(void)*/createLCSSAPass();
      /*J:(void)*/createLICMPass();
      /*J:(void)*/createLoopExtractorPass();
      /*J:(void)*/createLoopInterchangePass();
      /*J:(void)*/createLoopSimplifyPass();
      /*J:(void)*/createLoopSimplifyCFGPass();
      /*J:(void)*/createLoopStrengthReducePass();
      /*J:(void)*/createLoopRerollPass();
      /*J:(void)*/createLoopUnrollPass();
      /*J:(void)*/createLoopUnswitchPass();
      /*J:(void)*/createLoopVersioningLICMPass();
      /*J:(void)*/createLoopIdiomPass();
      /*J:(void)*/createLoopRotatePass();
      /*J:(void)*/createLowerExpectIntrinsicPass();
      /*J:(void)*/createLowerInvokePass();
      /*J:(void)*/createLowerSwitchPass();
      /*J:(void)*/createNaryReassociatePass();
      /*J:(void)*/createObjCARCAPElimPass();
      /*J:(void)*/createObjCARCExpandPass();
      /*J:(void)*/createObjCARCContractPass();
      /*J:(void)*/createObjCARCOptPass();
      /*J:(void)*/createPromoteMemoryToRegisterPass();
      /*J:(void)*/createDemoteRegisterToMemoryPass();
      /*J:(void)*/createPruneEHPass();
      /*J:(void)*/createReassociatePass();
      /*J:(void)*/createSCCPPass();
      /*J:(void)*/createSROAPass();
      /*J:(void)*/createSingleLoopExtractorPass();
      /*J:(void)*/createStripNonDebugSymbolsPass();
      /*J:(void)*/createStripDeadDebugInfoPass();
      /*J:(void)*/createStripDeadPrototypesPass();
      /*J:(void)*/createTailCallEliminationPass();
      /*J:(void)*/createJumpThreadingPass();
      /*J:(void)*/createUnifyFunctionExitNodesPass();
      /*J:(void)*/createConstantHoistingPass();
      /*J:(void)*/createEarlyCSEPass();
      /*J:(void)*/createGVNHoistPass();
      /*J:(void)*/createMergedLoadStoreMotionPass();
      /*J:(void)*/createGVNPass();
      /*J:(void)*/createMemCpyOptPass();
      /*J:(void)*/createLoopDeletionPass();
      /*J:(void)*/createInstructionNamerPass();
      /*J:(void)*/createMetaRenamerPass();
      /*J:(void)*/createPostOrderFunctionAttrsLegacyPass();
      /*J:(void)*/createReversePostOrderFunctionAttrsPass();
      /*J:(void)*/createMergeFunctionsPass();
  }
      
  @Override
  public void create(raw_string_ostream os) {
  }

  @Override
  public void create2() {
      /*J:(void)*/createPartialInliningPass();
      /*J:(void)*/createSinkingPass();
      /*J:(void)*/createLowerAtomicPass();
      /*J:(void)*/createCorrelatedValuePropagationPass();
      /*J:(void)*/createInstructionSimplifierPass();
      /*J:(void)*/createLoopVectorizePass();
      /*J:(void)*/createSLPVectorizerPass();
      /*J:(void)*/createLoadStoreVectorizerPass();
      /*J:(void)*/createBBVectorizePass();
      /*J:(void)*/createPartiallyInlineLibCallsPass();
      /*J:(void)*/createScalarizerPass();
      /*J:(void)*/createSeparateConstOffsetFromGEPPass();
      /*J:(void)*/createSpeculativeExecutionPass();
      /*J:(void)*/createSpeculativeExecutionIfHasBranchDivergencePass();
      /*J:(void)*/createRewriteSymbolsPass();
      /*J:(void)*/createStraightLineStrengthReducePass();
      /*J:(void)*/createFloat2IntPass();
      /*J:(void)*/createEliminateAvailableExternallyPass();
}
  
  @Override
  public LinkAllPassesGlobals.ForcePassLinking create(List<LinkAllPassesGlobals.ForcePassLinking> services) {
      throw new UnsupportedOperationException("Only one service implements this method");
  }
}
