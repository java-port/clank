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

package org.llvm.pass.spi;

import org.llvm.pass.PassRegistry;

/**
 * Interface for ServiceProvider to be able impl delegation into llvm/Transforms module from llvm/IR.
 */
public interface LllvmTransformsPassInitializer {

  public void initializeTargetLibraryInfoWrapperPassPass(PassRegistry Registry);

  public void initializeAddDiscriminatorsLegacyPassPass(PassRegistry Registry);

  public void initializeBarrierNoopPass(PassRegistry Registry);

  public void initializeBoundsCheckingPass(PassRegistry Registry);

  void initializeAddressSanitizerModulePass(final PassRegistry Registry);

  void initializeAddressSanitizerPass(final PassRegistry Registry);

  void initializeAlignmentFromAssumptionsPass(final PassRegistry Registry);

  void initializeAlwaysInlinerPass(final PassRegistry Registry);

  void initializeArgPromotionPass(final PassRegistry Registry);

  void initializeBBVectorizePass(final PassRegistry Registry);

  void initializeBDCELegacyPassPass(final PassRegistry Registry);

  void initializeBlockExtractorPassPass(final PassRegistry Registry);

  void initializeBreakCriticalEdgesPass(final PassRegistry Registry);

  void initializeCFGSimplifyPassPass(final PassRegistry Registry);

  void initializeConstantHoistingLegacyPassPass(final PassRegistry Registry);

  void initializeConstantMergeLegacyPassPass(final PassRegistry Registry);

  void initializeConstantPropagationPass(final PassRegistry Registry);

  void initializeCorrelatedValuePropagationPass(final PassRegistry Registry);

  void initializeCrossDSOCFIPass(final PassRegistry Registry);

  void initializeDAEPass(final PassRegistry Registry);

  void initializeDAHPass(final PassRegistry Registry);

  void initializeDCELegacyPassPass(final PassRegistry Registry);

  void initializeDSELegacyPassPass(final PassRegistry Registry);

  void initializeDataFlowSanitizerPass(final PassRegistry Registry);

  void initializeDeadInstEliminationPass(final PassRegistry Registry);

  void initializeEarlyCSELegacyPassPass(final PassRegistry Registry);

  void initializeEfficiencySanitizerPass(final PassRegistry Registry);

  void initializeEliminateAvailableExternallyLegacyPassPass(final PassRegistry Registry);

  void initializeFlattenCFGPassPass(final PassRegistry Registry);

  void initializeFloat2IntLegacyPassPass(final PassRegistry Registry);

  void initializeForceFunctionAttrsLegacyPassPass(final PassRegistry Registry);

  void initializeFunctionImportPassPass(final PassRegistry Registry);

  void initializeGCOVProfilerLegacyPassPass(final PassRegistry Registry);

  void initializeGVNHoistLegacyPassPass(final PassRegistry Registry);

  void initializeGVNLegacyPassPass(final PassRegistry Registry);

  void initializeGlobalDCELegacyPassPass(final PassRegistry Registry);

  void initializeGlobalOptLegacyPassPass(final PassRegistry Registry);

  void initializeGuardWideningLegacyPassPass(final PassRegistry Registry);

  void initializeIPCPPass(final PassRegistry Registry);

  void initializeIPSCCPLegacyPassPass(final PassRegistry Registry);

  void initializeIndVarSimplifyLegacyPassPass(final PassRegistry Registry);

  void initializeInductiveRangeCheckEliminationPass(final PassRegistry Registry);

  void initializeInferFunctionAttrsLegacyPassPass(final PassRegistry Registry);

  void initializeInstNamerPass(final PassRegistry Registry);

  void initializeInstSimplifierPass(final PassRegistry Registry);

  void initializeInstrProfilingLegacyPassPass(final PassRegistry Registry);

  void initializeInstructionCombiningPassPass(final PassRegistry Registry);

  void initializeInternalizeLegacyPassPass(final PassRegistry Registry);

  void initializeJumpThreadingPass(final PassRegistry Registry);

  void initializeLCSSAWrapperPassPass(final PassRegistry Registry);

  void initializeLegacyLICMPassPass(final PassRegistry Registry);

  void initializeLoadCombinePass(final PassRegistry Registry);

  void initializeLoadStoreVectorizerPass(final PassRegistry Registry);

  void initializeLoopDataPrefetchPass(final PassRegistry Registry);

  void initializeLoopDeletionLegacyPassPass(final PassRegistry Registry);

  void initializeLoopDistributeLegacyPass(final PassRegistry Registry);

  void initializeLoopExtractorPass(final PassRegistry Registry);

  void initializeLoopIdiomRecognizeLegacyPassPass(final PassRegistry Registry);

  void initializeLoopInstSimplifyLegacyPassPass(final PassRegistry Registry);

  void initializeLoopInterchangePass(final PassRegistry Registry);

  void initializeLoopLoadEliminationPass(final PassRegistry Registry);

  void initializeLoopRerollPass(final PassRegistry Registry);

  void initializeLoopRotateLegacyPassPass(final PassRegistry Registry);

  void initializeLoopSimplifyCFGLegacyPassPass(final PassRegistry Registry);

  void initializeLoopSimplifyPass(final PassRegistry Registry);

  void initializeLoopStrengthReducePass(final PassRegistry Registry);

  void initializeLoopUnrollPass(final PassRegistry Registry);

  void initializeLoopUnswitchPass(final PassRegistry Registry);

  void initializeLoopVectorizePass(final PassRegistry Registry);

  void initializeLoopVersioningLICMPass(final PassRegistry Registry);

  void initializeLoopVersioningPassPass(final PassRegistry Registry);

  void initializeLowerAtomicLegacyPassPass(final PassRegistry Registry);

  void initializeLowerExpectIntrinsicPass(final PassRegistry Registry);

  void initializeLowerGuardIntrinsicPass(final PassRegistry Registry);

  void initializeLowerInvokePass(final PassRegistry Registry);

  void initializeLowerSwitchPass(final PassRegistry Registry);

  void initializeLowerTypeTestsPass(final PassRegistry Registry);

  void initializeMemCpyOptLegacyPassPass(final PassRegistry Registry);

  void initializeMemorySSAPrinterLegacyPassPass(final PassRegistry Registry);

  void initializeMemorySSAWrapperPassPass(final PassRegistry Registry);

  void initializeMemorySanitizerPass(final PassRegistry Registry);

  void initializeMergeFunctionsPass(final PassRegistry Registry);

  void initializeMergedLoadStoreMotionLegacyPassPass(final PassRegistry Registry);

  void initializeMetaRenamerPass(final PassRegistry Registry);

  void initializeNameAnonFunctionPass(final PassRegistry Registry);

  void initializeNaryReassociatePass(final PassRegistry Registry);

  void initializeObjCARCAPElimPass(final PassRegistry Registry);

  void initializeObjCARCContractPass(final PassRegistry Registry);

  void initializeObjCARCExpandPass(final PassRegistry Registry);

  void initializeObjCARCOptPass(final PassRegistry Registry);

  void initializePAEvalPass(final PassRegistry Registry);

  void initializePGOIndirectCallPromotionLegacyPassPass(final PassRegistry Registry);

  void initializePGOInstrumentationGenLegacyPassPass(final PassRegistry Registry);

  void initializePGOInstrumentationUseLegacyPassPass(final PassRegistry Registry);

  void initializePartialInlinerLegacyPassPass(final PassRegistry Registry);

  void initializePartiallyInlineLibCallsLegacyPassPass(final PassRegistry Registry);

  void initializePlaceBackedgeSafepointsImplPass(final PassRegistry Registry);

  void initializePlaceSafepointsPass(final PassRegistry Registry);

  void initializePostOrderFunctionAttrsLegacyPassPass(final PassRegistry Registry);

  void initializePromoteLegacyPassPass(final PassRegistry Registry);

  void initializePruneEHPass(final PassRegistry Registry);

  void initializeReassociateLegacyPassPass(final PassRegistry Registry);

  void initializeRegToMemPass(final PassRegistry Registry);

  void initializeReversePostOrderFunctionAttrsLegacyPassPass(final PassRegistry Registry);

  void initializeRewriteStatepointsForGCPass(final PassRegistry Registry);

  void initializeRewriteSymbolsPass(final PassRegistry Registry);

  void initializeSCCPLegacyPassPass(final PassRegistry Registry);

  void initializeSLPVectorizerPass(final PassRegistry Registry);

  void initializeSROALegacyPassPass(final PassRegistry Registry);

  void initializeSampleProfileLoaderLegacyPassPass(final PassRegistry Registry);

  void initializeSanitizerCoverageModulePass(final PassRegistry Registry);

  void initializeScalarizerPass(final PassRegistry Registry);

  void initializeSeparateConstOffsetFromGEPPass(final PassRegistry Registry);

  void initializeSimpleInlinerPass(final PassRegistry Registry);

  void initializeSingleLoopExtractorPass(final PassRegistry Registry);

  void initializeSinkingLegacyPassPass(final PassRegistry Registry);

  void initializeSpeculativeExecutionPass(final PassRegistry Registry);

  void initializeStraightLineStrengthReducePass(final PassRegistry Registry);

  void initializeStripDeadDebugInfoPass(final PassRegistry Registry);

  void initializeStripDeadPrototypesLegacyPassPass(final PassRegistry Registry);

  void initializeStripDebugDeclarePass(final PassRegistry Registry);

  void initializeStripNonDebugSymbolsPass(final PassRegistry Registry);

  void initializeStripSymbolsPass(final PassRegistry Registry);

  void initializeStructurizeCFGPass(final PassRegistry Registry);

  void initializeTailCallElimPass(final PassRegistry Registry);

  void initializeThreadSanitizerPass(final PassRegistry Registry);

  void initializeUnifyFunctionExitNodesPass(final PassRegistry Registry);

  void initializeWholeProgramDevirtPass(final PassRegistry Registry);

}
