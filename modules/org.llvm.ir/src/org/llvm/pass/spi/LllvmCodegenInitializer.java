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
 * Interface for ServiceProvider to be able impl delegation into llvm/CodeGen module from llvm/IR.
 */
public interface LllvmCodegenInitializer {
    void initializeAtomicExpandPass(final PassRegistry Registry);

    void initializeBranchFolderPassPass(final PassRegistry Registry);

    void initializeCodeGenPreparePass(final PassRegistry Registry);

    void initializeDeadMachineInstructionElimPass(final PassRegistry Registry);

    void initializeDetectDeadLanesPass(final PassRegistry Registry);

    void initializeDwarfEHPreparePass(final PassRegistry Registry);

    void initializeEarlyIfConverterPass(final PassRegistry Registry);

    void initializeEdgeBundlesPass(final PassRegistry Registry);

    void initializeExpandISelPseudosPass(final PassRegistry Registry);

    void initializeExpandPostRAPass(final PassRegistry Registry);

    void initializeFinalizeMachineBundlesPass(final PassRegistry Registry);

    void initializeFuncletLayoutPass(final PassRegistry Registry);

    void initializeGCMachineCodeAnalysisPass(final PassRegistry Registry);

    void initializeGCModuleInfoPass(final PassRegistry Registry);

    void initializeGlobalISel(final PassRegistry Registry);

    void initializeGlobalMergePass(final PassRegistry Registry);

    void initializeIRTranslatorPass(final PassRegistry Registry);

    void initializeIfConverterPass(final PassRegistry Registry);

    void initializeImplicitNullChecksPass(final PassRegistry Registry);

    void initializeInterleavedAccessPass(final PassRegistry Registry);

    void initializeLiveDebugValuesPass(final PassRegistry Registry);

    void initializeLiveDebugVariablesPass(final PassRegistry Registry);

    void initializeLiveIntervalsPass(final PassRegistry Registry);

    void initializeLiveRegMatrixPass(final PassRegistry Registry);

    void initializeLiveStacksPass(final PassRegistry Registry);

    void initializeLiveVariablesPass(final PassRegistry Registry);

    void initializeLocalStackSlotPassPass(final PassRegistry Registry);

    void initializeLowerEmuTLSPass(final PassRegistry Registry);

    void initializeLowerIntrinsicsPass(final PassRegistry Registry);

    void initializeMIRPrintingPassPass(final PassRegistry Registry);

    void initializeMachineBlockFrequencyInfoPass(final PassRegistry Registry);

    void initializeMachineBlockPlacementPass(final PassRegistry Registry);

    void initializeMachineBlockPlacementStatsPass(final PassRegistry Registry);

    void initializeMachineBranchProbabilityInfoPass(final PassRegistry Registry);

    void initializeMachineCSEPass(final PassRegistry Registry);

    void initializeMachineCombinerPass(final PassRegistry Registry);

    void initializeMachineCopyPropagationPass(final PassRegistry Registry);

    void initializeMachineDominanceFrontierPass(final PassRegistry Registry);

    void initializeMachineDominatorTreePass(final PassRegistry Registry);

    void initializeMachineFunctionPrinterPassPass(final PassRegistry Registry);

    void initializeMachineLICMPass(final PassRegistry Registry);

    void initializeMachineLoopInfoPass(final PassRegistry Registry);

    void initializeMachineModuleInfoPass(final PassRegistry Registry);

    void initializeMachinePostDominatorTreePass(final PassRegistry Registry);

    void initializeMachineRegionInfoPassPass(final PassRegistry Registry);

    void initializeMachineSchedulerPass(final PassRegistry Registry);

    void initializeMachineSinkingPass(final PassRegistry Registry);

    void initializeMachineTraceMetricsPass(final PassRegistry Registry);

    void initializeMachineVerifierPassPass(final PassRegistry Registry);

    void initializeOptimizePHIsPass(final PassRegistry Registry);

    void initializePEIPass(final PassRegistry Registry);

    void initializePHIEliminationPass(final PassRegistry Registry);

    void initializePatchableFunctionPass(final PassRegistry Registry);

    void initializePeepholeOptimizerPass(final PassRegistry Registry);

    void initializePhysicalRegisterUsageInfoPass(final PassRegistry Registry);

    void initializePostMachineSchedulerPass(final PassRegistry Registry);

    void initializePostRAHazardRecognizerPass(final PassRegistry Registry);

    void initializePostRASchedulerPass(final PassRegistry Registry);

    void initializePreISelIntrinsicLoweringLegacyPassPass(final PassRegistry Registry);

    void initializeProcessImplicitDefsPass(final PassRegistry Registry);

    void initializeRegBankSelectPass(final PassRegistry Registry);

    void initializeRegisterCoalescerPass(final PassRegistry Registry);

    void initializeRenameIndependentSubregsPass(final PassRegistry Registry);

    void initializeSafeStackPass(final PassRegistry Registry);

    void initializeShadowStackGCLoweringPass(final PassRegistry Registry);

    void initializeShrinkWrapPass(final PassRegistry Registry);

    void initializeSjLjEHPreparePass(final PassRegistry Registry);

    void initializeSlotIndexesPass(final PassRegistry Registry);

    void initializeSpillPlacementPass(final PassRegistry Registry);

    void initializeStackColoringPass(final PassRegistry Registry);

    void initializeStackMapLivenessPass(final PassRegistry Registry);

    void initializeStackProtectorPass(final PassRegistry Registry);

    void initializeStackSlotColoringPass(final PassRegistry Registry);

    void initializeTailDuplicatePassPass(final PassRegistry Registry);

    void initializeTargetPassConfigPass(final PassRegistry Registry);

    void initializeTwoAddressInstructionPassPass(final PassRegistry Registry);

    void initializeUnpackMachineBundlesPass(final PassRegistry Registry);

    void initializeUnreachableBlockElimLegacyPassPass(final PassRegistry Registry);

    void initializeUnreachableMachineBlockElimPass(final PassRegistry Registry);

    void initializeVirtRegMapPass(final PassRegistry Registry);

    void initializeVirtRegRewriterPass(final PassRegistry Registry);

    void initializeWinEHPreparePass(final PassRegistry Registry);

    void initializeXRayInstrumentationPass(final PassRegistry Registry);
}
