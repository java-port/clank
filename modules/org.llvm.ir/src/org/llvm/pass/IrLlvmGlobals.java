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
package org.llvm.pass;

import org.clank.java.std;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.llvmc.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.ir.impl.IRPrintingPassesLlvmGlobals;
import org.llvm.ir.java.IPassFunction;
import org.llvm.ir.java.TargetMachineForward;
import org.llvm.ir.legacy.PassManagerBase;


//<editor-fold defaultstate="collapsed" desc="static type IrLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.pass.IrLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp ${LLVM_SRC}/llvm/lib/AsmParser/LLLexer.cpp ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/ScanfFormatString.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/TargetInfo.cpp ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=Tpl__ZN4llvm12gep_type_endEPNS_4TypeEjNS_8ArrayRefIT_EE;Tpl__ZN4llvm14gep_type_beginEPNS_4TypeEjNS_8ArrayRefIT_EE;Tpl__ZN4llvm15callDefaultCtorEv;Tpl__ZN4llvm21callTargetMachineCtorEPNS_13TargetMachineE;Tpl__ZN4llvm33createModuleToFunctionPassAdaptorET_;Tpl__ZN4llvm6unwrapEP14LLVMOpaqueType;Tpl__ZN4llvm6unwrapEP15LLVMOpaqueValue;Tpl__ZN4llvm6unwrapEP21LLVMOpaquePassManager;Tpl__ZN4llvm6unwrapEP22LLVMOpaquePassRegistry;Tpl__ZN4llvm6unwrapEPP15LLVMOpaqueValuej;_ZN4llvm10inst_beginEPKNS_8FunctionE;_ZN4llvm10inst_beginEPNS_8FunctionE;_ZN4llvm10inst_beginERKNS_8FunctionE;_ZN4llvm10inst_beginERNS_8FunctionE;_ZN4llvm10isGCResultENS_17ImmutableCallSiteE;_ZN4llvm10pred_beginEPKNS_10BasicBlockE;_ZN4llvm10pred_beginEPNS_10BasicBlockE;_ZN4llvm10pred_emptyEPKNS_10BasicBlockE;_ZN4llvm10succ_beginEPKNS_10BasicBlockE;_ZN4llvm10succ_beginEPNS_10BasicBlockE;_ZN4llvm10succ_emptyEPKNS_10BasicBlockE;_ZN4llvm10successorsEPKNS_10BasicBlockE;_ZN4llvm10successorsEPNS_10BasicBlockE;_ZN4llvm12checkGEPTypeEPNS_4TypeE;_ZN4llvm12gep_type_endEPKNS_4UserE;_ZN4llvm12gep_type_endERKNS_4UserE;_ZN4llvm12getPassTimerEPNS_4PassE;_ZN4llvm12instructionsEPKNS_8FunctionE;_ZN4llvm12instructionsEPNS_8FunctionE;_ZN4llvm12instructionsERKNS_8FunctionE;_ZN4llvm12instructionsERNS_8FunctionE;_ZN4llvm12isGCRelocateENS_17ImmutableCallSiteE;_ZN4llvm12isStatepointENS_17ImmutableCallSiteE;_ZN4llvm12isStatepointEPKNS_5ValueE;_ZN4llvm12isStatepointERKNS_5ValueE;_ZN4llvm12predecessorsEPKNS_10BasicBlockE;_ZN4llvm12predecessorsEPNS_10BasicBlockE;_ZN4llvm12verifyModuleERKNS_6ModuleEPNS_11raw_ostreamEPb;_ZN4llvm13initializeIPOERNS_12PassRegistryE;_ZN4llvm14StripDebugInfoERNS_6ModuleE;_ZN4llvm14gep_type_beginEPKNS_4UserE;_ZN4llvm14gep_type_beginERKNS_4UserE;_ZN4llvm14initializeCoreERNS_12PassRegistryE;_ZN4llvm14stripDebugInfoERNS_8FunctionE;_ZN4llvm14verifyFunctionERKNS_8FunctionEPNS_11raw_ostreamE;_ZN4llvm15getDISubprogramEPKNS_6MDNodeE;_ZN4llvm16UpgradeDebugInfoERNS_6ModuleE;_ZN4llvm17initializeDAEPassERNS_12PassRegistryE;_ZN4llvm17initializeDAHPassERNS_12PassRegistryE;_ZN4llvm18UpgradeBitCastExprEjPNS_8ConstantEPNS_4TypeE;_ZN4llvm18UpgradeBitCastInstEjPNS_5ValueEPNS_4TypeERPNS_11InstructionE;_ZN4llvm18UpgradeModuleFlagsERNS_6ModuleE;_ZN4llvm18createVerifierPassEb;_ZN4llvm18initializeAnalysisERNS_12PassRegistryE;_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE;_ZN4llvm18initializeLintPassERNS_12PassRegistryE;_ZN4llvm19TimePassesIsEnabledE;_ZN4llvm20UpgradeIntrinsicCallEPNS_8CallInstEPNS_8FunctionE;_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE;_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE;_ZN4llvm21UpgradeGlobalVariableEPNS_14GlobalVariableE;_ZN4llvm21createPrintModulePassERNS_11raw_ostreamERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEEb;_ZN4llvm21initializeInstCombineERNS_12PassRegistryE;_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE;_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE;_ZN4llvm21isFunctionInPrintListENS_9StringRefE;_ZN4llvm22UpgradeInstWithTBAATagEPNS_11InstructionE;_ZN4llvm22emitOptimizationRemarkERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE;_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE;_ZN4llvm23UpgradeCallsToIntrinsicEPNS_8FunctionE;_ZN4llvm23createPrintFunctionPassERNS_11raw_ostreamERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE;_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE;_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE;_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE;_ZN4llvm23initializeVectorizationERNS_12PassRegistryE;_ZN4llvm24UpgradeIntrinsicFunctionEPNS_8FunctionERS1_;_ZN4llvm24emitLoopVectorizeWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE;_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE;_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE;_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE;_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE;_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE;_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE;_ZN4llvm25createPrintBasicBlockPassERNS_11raw_ostreamERKNSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEE;_ZN4llvm25emitLoopInterleaveWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE;_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE;_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE;_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE;_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE;_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE;_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE;_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE;_ZN4llvm25isStatepointDirectiveAttrENS_9AttributeE;_ZN4llvm25mayBeOldLoopAttachmentTagENS_9StringRefE;_ZN4llvm26collectUsedGlobalVariablesERKNS_6ModuleERNS_15SmallPtrSetImplIPNS_11GlobalValueEEEb;_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE;_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE;_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE;_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE;_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE;_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE;_ZN4llvm26printLLVMNameWithoutPrefixERNS_11raw_ostreamENS_9StringRefE;_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE;_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE;_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE;_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE;_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE;_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE;_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE;_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE;_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE;_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE;_ZN4llvm28emitOptimizationRemarkMissedERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE;_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE;_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE;_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE;_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE;_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE;_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE;_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE;_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE;_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE;_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE;_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE;_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE;_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE;_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE;_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE;_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE;_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE;_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE;_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE;_ZN4llvm30emitOptimizationRemarkAnalysisERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE;_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE;_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE;_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE;_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE;_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm30initializeWriteBitcodePassPassERNS_12PassRegistryE;_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE;_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE;_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE;_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE;_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE;_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE;_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE;_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE;_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE;_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE;_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE;_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE;_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE;_ZN4llvm32initializeVerifierLegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE;_ZN4llvm32upgradeInstructionLoopAttachmentERNS_6MDNodeE;_ZN4llvm33getDebugMetadataVersionFromModuleERKNS_6ModuleE;_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE;_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE;_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE;_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE;_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE;_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE;_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE;_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializePrintBasicBlockPassPassERNS_12PassRegistryE;_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE;_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE;_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE;_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE;_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE;_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE;_ZN4llvm34parseStatepointDirectivesFromAttrsENS_12AttributeSetE;_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36getNextAvailablePluginDiagnosticKindEv;_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE;_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE;_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE;_ZN4llvm36initializePrintModulePassWrapperPassERNS_12PassRegistryE;_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE;_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE;_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE;_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE;_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE;_ZN4llvm38emitOptimizationRemarkAnalysisAliasingERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE;_ZN4llvm38initializeDominatorTreeWrapperPassPassERNS_12PassRegistryE;_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE;_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE;_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializePrintFunctionPassWrapperPassERNS_12PassRegistryE;_ZN4llvm39emitOptimizationRemarkAnalysisFPCommuteERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE;_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE;_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE;_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE;_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE;_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE;_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE;_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE;_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE;_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE;_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE;_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE;_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm4wrapENS_9AttributeE;_ZN4llvm4wrapEPKNS_10BasicBlockE;_ZN4llvm4wrapEPKNS_10DataLayoutE;_ZN4llvm4wrapEPKNS_11LLVMContextE;_ZN4llvm4wrapEPKNS_12PassRegistryE;_ZN4llvm4wrapEPKNS_14DiagnosticInfoE;_ZN4llvm4wrapEPKNS_3UseE;_ZN4llvm4wrapEPKNS_4TypeE;_ZN4llvm4wrapEPKNS_5ValueE;_ZN4llvm4wrapEPKNS_6ModuleE;_ZN4llvm4wrapEPKNS_6legacy15PassManagerBaseE;_ZN4llvm4wrapEPKNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEE;_ZN4llvm4wrapEPPKNS_11LLVMContextE;_ZN4llvm4wrapEPPKNS_5ValueE;_ZN4llvm4wrapEPPNS_4TypeE;_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE;_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm6unwrapEP13LLVMOpaqueUse;_ZN4llvm6unwrapEP14LLVMOpaqueType;_ZN4llvm6unwrapEP15LLVMOpaqueValue;_ZN4llvm6unwrapEP16LLVMOpaqueModule;_ZN4llvm6unwrapEP17LLVMOpaqueBuilder;_ZN4llvm6unwrapEP17LLVMOpaqueContext;_ZN4llvm6unwrapEP20LLVMOpaqueBasicBlock;_ZN4llvm6unwrapEP20LLVMOpaqueTargetData;_ZN4llvm6unwrapEP21LLVMOpaquePassManager;_ZN4llvm6unwrapEP22LLVMOpaqueAttributeRef;_ZN4llvm6unwrapEP22LLVMOpaquePassRegistry;_ZN4llvm6unwrapEP24LLVMOpaqueDiagnosticInfo;_ZN4llvm6unwrapEP24LLVMOpaqueModuleProvider;_ZN4llvm6unwrapEPP14LLVMOpaqueType;_ZN4llvm6unwrapEPP15LLVMOpaqueValue;_ZN4llvm6unwrapEPP17LLVMOpaqueContext;_ZN4llvm8inst_endEPKNS_8FunctionE;_ZN4llvm8inst_endEPNS_8FunctionE;_ZN4llvm8inst_endERKNS_8FunctionE;_ZN4llvm8inst_endERNS_8FunctionE;_ZN4llvm8pred_endEPKNS_10BasicBlockE;_ZN4llvm8pred_endEPNS_10BasicBlockE;_ZN4llvm8succ_endEPKNS_10BasicBlockE;_ZN4llvm8succ_endEPNS_10BasicBlockE;_ZN4llvmlsERNS_11raw_ostreamERKNS_13ConstantRangeE;_ZN4llvmlsERNS_11raw_ostreamERKNS_5ValueE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6ComdatE;_ZN4llvmlsERNS_11raw_ostreamERKNS_6ModuleE;_ZN4llvmlsERNS_11raw_ostreamERKNS_8MetadataE;_ZN4llvmlsERNS_11raw_ostreamERNS_4TypeE; -static-type=IrLlvmGlobals -package=org.llvm.pass")
//</editor-fold>
public final class IrLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Comdat.h", line = 56,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6ComdatE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6ComdatE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Comdat$C(final raw_ostream /*&*/ OS, final /*const*/ Comdat /*&*/ C) {
  return /*delegate*/org.llvm.ir.impl.ComdatLlvmGlobals.
    $out_raw_ostream_Comdat$C(OS, C);
}


// Printing of types.
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 415,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERNS_4TypeE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Type(final raw_ostream /*&*/ OS, final Type /*&*/ T) {
  return /*delegate*/org.llvm.ir.impl.TypeLlvmGlobals.
    $out_raw_ostream_Type(OS, T);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 458,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP14LLVMOpaqueType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP14LLVMOpaqueType")
//</editor-fold>
public static /*inline*/ Type /*P*/ unwrap_LLVMOpaqueType$P( LLVMOpaqueType /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.TypeLlvmGlobals.
    unwrap_LLVMOpaqueType$P(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 458,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_4TypeE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueType /*P*/ wrap_Type$C$P(/*const*/ Type /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.TypeLlvmGlobals.
    wrap_Type$C$P(P);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 458,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEP14LLVMOpaqueType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6unwrapEP14LLVMOpaqueType")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T /*P*/ unwrap_LLVMOpaqueType$P(Class<T> cls, LLVMOpaqueType /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.TypeLlvmGlobals.
    unwrap_LLVMOpaqueType$P(cls, P);
}


/* Specialized opaque type conversions.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 462,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEPP14LLVMOpaqueType",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEPP14LLVMOpaqueType")
//</editor-fold>
public static /*inline*/ type$ptr<Type /*P*/ /*P*/> unwrap_type$ptr$LLVMOpaqueType$P$P(type$ptr<LLVMOpaqueType /*P*/ /*P*/> Tys) {
  return /*delegate*/org.llvm.ir.impl.TypeLlvmGlobals.
    unwrap_type$ptr$LLVMOpaqueType$P$P(Tys);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Type.h", line = 466,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPPNS_4TypeE")
//</editor-fold>
public static /*inline*/ type$ptr<LLVMOpaqueType /*P*/ /*P*/> wrap_type$ptr$Type$P$P(type$ptr<Type /*P*/ /*P*/> Tys) {
  return /*delegate*/org.llvm.ir.impl.TypeLlvmGlobals.
    wrap_type$ptr$Type$P$P(Tys);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/PassRegistry.h", line = 95,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP22LLVMOpaquePassRegistry",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP22LLVMOpaquePassRegistry")
//</editor-fold>
public static /*inline*/ PassRegistry /*P*/ unwrap( LLVMOpaquePassRegistry /*P*/ P) {
  return /*delegate*/org.llvm.pass.impl.PassRegistryLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/PassRegistry.h", line = 95,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_12PassRegistryE")
//</editor-fold>
public static /*inline*/  LLVMOpaquePassRegistry /*P*/ wrap(/*const*/ PassRegistry /*P*/ P) {
  return /*delegate*/org.llvm.pass.impl.PassRegistryLlvmGlobals.
    wrap(P);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/PassRegistry.h", line = 95,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEP22LLVMOpaquePassRegistry",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6unwrapEP22LLVMOpaquePassRegistry")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T /*P*/ unwrap$T(Class<T> cls,  LLVMOpaquePassRegistry /*P*/ P) {
  return /*delegate*/org.llvm.pass.impl.PassRegistryLlvmGlobals.
    unwrap$T(P);
}

/*template <typename PassName> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::callDefaultCtor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 79,
 FQN="llvm::callDefaultCtor", NM="Tpl__ZN4llvm15callDefaultCtorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm15callDefaultCtorEv")
//</editor-fold>
public static </*typename*/ PassName> Pass /*P*/ callDefaultCtor(Class<PassName> cls) {
  return /*delegate*/org.llvm.pass.impl.PassSupportLlvmGlobals.
    callDefaultCtor(cls);
}

/*template <typename PassName> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::callTargetMachineCtor">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/PassSupport.h", line = 81,
 FQN="llvm::callTargetMachineCtor", NM="Tpl__ZN4llvm21callTargetMachineCtorEPNS_13TargetMachineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm21callTargetMachineCtorEPNS_13TargetMachineE")
//</editor-fold>
public static </*typename*/ PassName> Pass /*P*/ callTargetMachineCtor(Class<PassName> cls, TargetMachineForward /*P*/ TM) {
  return /*delegate*/org.llvm.pass.impl.PassSupportLlvmGlobals.
    callTargetMachineCtor(cls, TM);
}

//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 463,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP20LLVMOpaqueTargetData",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP20LLVMOpaqueTargetData")
//</editor-fold>
public static /*inline*/ DataLayout /*P*/ unwrap( LLVMOpaqueTargetData /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.DataLayoutLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DataLayout.h", line = 467,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_10DataLayoutE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueTargetData /*P*/ wrap(/*const*/ DataLayout /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.DataLayoutLlvmGlobals.
    wrap(P);
}


// Specialized opaque value conversions.
//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 186,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapENS_9AttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapENS_9AttributeE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueAttributeRef /*P*/ wrap(Attribute Attr) {
  return /*delegate*/org.llvm.ir.impl.AttributesLlvmGlobals.
    wrap(Attr);
}


// Specialized opaque value conversions.
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Attributes.h", line = 191,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP22LLVMOpaqueAttributeRef",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP22LLVMOpaqueAttributeRef")
//</editor-fold>
public static /*inline*/ Attribute unwrap( LLVMOpaqueAttributeRef /*P*/ Attr) {
  return /*delegate*/org.llvm.ir.impl.AttributesLlvmGlobals.
    unwrap(Attr);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 160,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP13LLVMOpaqueUse",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP13LLVMOpaqueUse")
//</editor-fold>
public static /*inline*/ type$ptr<Use /*P*/> unwrap( LLVMOpaqueUse /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.UseLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Use.h", line = 160,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_3UseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_3UseE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueUse /*P*/ wrap(/*const*/type$ptr<Use /*P*/> P) {
  return /*delegate*/org.llvm.ir.impl.UseLlvmGlobals.
    wrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 608,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_5ValueE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Value$C(final raw_ostream /*&*/ OS, final /*const*/ Value /*&*/ V) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    $out_raw_ostream_Value$C(OS, V);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 799,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP15LLVMOpaqueValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP15LLVMOpaqueValue")
//</editor-fold>
public static /*inline*/ Value /*P*/ unwrap_LLVMOpaqueValue$P( LLVMOpaqueValue /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    unwrap_LLVMOpaqueValue$P(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 799,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_5ValueE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueValue /*P*/ wrap_Value$C$P(/*const*/ Value /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    wrap_Value$C$P(P);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 799,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEP15LLVMOpaqueValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6unwrapEP15LLVMOpaqueValue")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T /*P*/ unwrap_LLVMOpaqueValue$P(Class<T> cls,  LLVMOpaqueValue /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    unwrap_LLVMOpaqueValue$P(cls, P);
}


// Specialized opaque value conversions.
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 802,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEPP15LLVMOpaqueValue",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEPP15LLVMOpaqueValue")
//</editor-fold>
public static /*inline*/ type$ptr<Value /*P*/ /*P*/> unwrap_type$ptr$LLVMOpaqueValue$P$P(type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    unwrap_type$ptr$LLVMOpaqueValue$P$P(Vals);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 807,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEPP15LLVMOpaqueValuej",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6unwrapEPP15LLVMOpaqueValuej")
//</editor-fold>
public static /*inline*/ </*typename*/ T> type$ptr<T /*P*/ /*P*/> unwrap$T(Class<T> cls, type$ptr<LLVMOpaqueValue /*P*/ /*P*/> Vals, /*uint*/int Length) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    unwrap$T(cls, Vals, Length);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Value.h", line = 816,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPPKNS_5ValueE")
//</editor-fold>
public static /*inline*/ type$ptr<LLVMOpaqueValue /*P*/ /*P*/> wrap_type$ptr$Value$C$P$P(type$ptr</*const*/ Value /*P*/ /*P*/> Vals) {
  return /*delegate*/org.llvm.ir.impl.ValueLlvmGlobals.
    wrap_type$ptr$Value$C$P$P(Vals);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 262,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP17LLVMOpaqueContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP17LLVMOpaqueContext")
//</editor-fold>
public static /*inline*/ LLVMContext /*P*/ unwrap_LLVMOpaqueContext$P( LLVMOpaqueContext /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.LLVMContextLlvmGlobals.
    unwrap_LLVMOpaqueContext$P(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 262,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_11LLVMContextE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueContext /*P*/ wrap_LLVMContext$C$P(/*const*/ LLVMContext /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.LLVMContextLlvmGlobals.
    wrap_LLVMContext$C$P(P);
}


/* Specialized opaque context conversions.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 266,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEPP17LLVMOpaqueContext",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEPP17LLVMOpaqueContext")
//</editor-fold>
public static /*inline*/ type$ptr<LLVMContext /*P*/ /*P*/> unwrap_type$ptr$LLVMOpaqueContext$P$P(type$ptr<LLVMOpaqueContext /*P*/ /*P*/> Tys) {
  return /*delegate*/org.llvm.ir.impl.LLVMContextLlvmGlobals.
    unwrap_type$ptr$LLVMOpaqueContext$P$P(Tys);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LLVMContext.h", line = 270,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPPKNS_11LLVMContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPPKNS_11LLVMContextE")
//</editor-fold>
public static /*inline*/ type$ptr<LLVMOpaqueContext /*P*/ /*P*/> wrap_type$ptr$LLVMContext$C$P$P(type$ptr</*const*/ LLVMContext /*P*/ /*P*/> Tys) {
  return /*delegate*/org.llvm.ir.impl.LLVMContextLlvmGlobals.
    wrap_type$ptr$LLVMContext$C$P$P(Tys);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Metadata.h", line = 137,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_8MetadataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_8MetadataE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Metadata$C(final raw_ostream /*&*/ OS, final /*const*/ Metadata /*&*/ MD) {
  return /*delegate*/org.llvm.ir.impl.MetadataLlvmGlobals.
    $out_raw_ostream_Metadata$C(OS, MD);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 345,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP20LLVMOpaqueBasicBlock",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP20LLVMOpaqueBasicBlock")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ unwrap( LLVMOpaqueBasicBlock /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.BasicBlockLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/BasicBlock.h", line = 345,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueBasicBlock /*P*/ wrap(/*const*/ BasicBlock /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.BasicBlockLlvmGlobals.
    wrap(P);
}


/// An raw_ostream inserter for modules.
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 833,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_6ModuleE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_Module$C(final raw_ostream /*&*/ O, final /*const*/ Module /*&*/ M) {
  return /*delegate*/org.llvm.ir.impl.ModuleLlvmGlobals.
    $out_raw_ostream_Module$C(O, M);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 839,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP16LLVMOpaqueModule",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP16LLVMOpaqueModule")
//</editor-fold>
public static /*inline*/ Module /*P*/ unwrap( LLVMOpaqueModule /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.ModuleLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 839,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_6ModuleE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueModule /*P*/ wrap(/*const*/ Module /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.ModuleLlvmGlobals.
    wrap(P);
}


/* LLVMModuleProviderRef exists for historical reasons, but now just holds a
* Module.
*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 844,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP24LLVMOpaqueModuleProvider",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP24LLVMOpaqueModuleProvider")
//</editor-fold>
public static /*inline*/ Module /*P*/ unwrap( LLVMOpaqueModuleProvider /*P*/ MP) {
  return /*delegate*/org.llvm.ir.impl.ModuleLlvmGlobals.
    unwrap(MP);
}


/// \brief A function to deduce a function pass type and wrap it in the
/// templated adaptor.
/*template <typename FunctionPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::createModuleToFunctionPassAdaptor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/PassManager.h", line = 929,
 FQN="llvm::createModuleToFunctionPassAdaptor", NM="Tpl__ZN4llvm33createModuleToFunctionPassAdaptorET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm33createModuleToFunctionPassAdaptorET_")
//</editor-fold>
public static </*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>> ModuleToFunctionPassAdaptor<FunctionPassT> createModuleToFunctionPassAdaptor(FunctionPassT Pass) {
  return /*delegate*/org.llvm.ir.impl.PassManagerLlvmGlobals.
    createModuleToFunctionPassAdaptor(Pass);
}


//===----------------------------------------------------------------------===//
//                             GetElementPtrInst Class
//===----------------------------------------------------------------------===//

// checkGEPType - Simple wrapper function to give a better assertion failure
// message on bad indexes for a gep instruction.
//
//<editor-fold defaultstate="collapsed" desc="llvm::checkGEPType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Instructions.h", line = 821,
 FQN="llvm::checkGEPType", NM="_ZN4llvm12checkGEPTypeEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm12checkGEPTypeEPNS_4TypeE")
//</editor-fold>
public static /*inline*/ Type /*P*/ checkGEPType(Type /*P*/ Ty) {
  return /*delegate*/org.llvm.ir.impl.InstructionsLlvmGlobals.
    checkGEPType(Ty);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 588,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP24LLVMOpaqueDiagnosticInfo",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP24LLVMOpaqueDiagnosticInfo")
//</editor-fold>
public static /*inline*/ DiagnosticInfo /*P*/ unwrap( LLVMOpaqueDiagnosticInfo /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 588,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_14DiagnosticInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_14DiagnosticInfoE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueDiagnosticInfo /*P*/ wrap(/*const*/ DiagnosticInfo /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    wrap(P);
}

// End legacy namespace

// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManager.h", line = 99,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP21LLVMOpaquePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm6unwrapEP21LLVMOpaquePassManager")
//</editor-fold>
public static /*inline*/ PassManagerBase /*P*/ unwrap( LLVMOpaquePassManager /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.LegacyPassManagerLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManager.h", line = 99,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_6legacy15PassManagerBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm4wrapEPKNS_6legacy15PassManagerBaseE")
//</editor-fold>
public static /*inline*/  LLVMOpaquePassManager /*P*/ wrap(/*const*/ PassManagerBase /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.LegacyPassManagerLlvmGlobals.
    wrap(P);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/LegacyPassManager.h", line = 99,
 FQN="llvm::unwrap", NM="Tpl__ZN4llvm6unwrapEP21LLVMOpaquePassManager",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=Tpl__ZN4llvm6unwrapEP21LLVMOpaquePassManager")
//</editor-fold>
public static /*inline*/ </*typename*/ T> T /*P*/ unwrap$T(Class<T> cls, LLVMOpaquePassManager /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.LegacyPassManagerLlvmGlobals.
    unwrap$T(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 91,
 FQN="llvm::pred_begin", NM="_ZN4llvm10pred_beginEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10pred_beginEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator<BasicBlock, Value.user_iterator_impl<User> > pred_begin_BasicBlock$P(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    pred_begin_BasicBlock$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 92,
 FQN="llvm::pred_begin", NM="_ZN4llvm10pred_beginEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10pred_beginEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > pred_begin_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    pred_begin_BasicBlock$C$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 95,
 FQN="llvm::pred_end", NM="_ZN4llvm8pred_endEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm8pred_endEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator<BasicBlock, Value.user_iterator_impl<User> > pred_end_BasicBlock$P(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    pred_end_BasicBlock$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 96,
 FQN="llvm::pred_end", NM="_ZN4llvm8pred_endEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm8pred_endEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ PredIterator</*const*/ BasicBlock, Value.user_iterator_impl</*const*/ User> > pred_end_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    pred_end_BasicBlock$C$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_empty">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 99,
 FQN="llvm::pred_empty", NM="_ZN4llvm10pred_emptyEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10pred_emptyEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ boolean pred_empty(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    pred_empty(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::predecessors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 102,
 FQN="llvm::predecessors", NM="_ZN4llvm12predecessorsEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm12predecessorsEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range<BasicBlock> predecessors_BasicBlock$P(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    predecessors_BasicBlock$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::predecessors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 105,
 FQN="llvm::predecessors", NM="_ZN4llvm12predecessorsEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm12predecessorsEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ BasicBlock> predecessors_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    predecessors_BasicBlock$C$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 120,
 FQN="llvm::succ_begin", NM="_ZN4llvm10succ_beginEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10succ_beginEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> succ_begin_BasicBlock$P(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    succ_begin_BasicBlock$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 123,
 FQN="llvm::succ_begin", NM="_ZN4llvm10succ_beginEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10succ_beginEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> succ_begin_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    succ_begin_BasicBlock$C$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 126,
 FQN="llvm::succ_end", NM="_ZN4llvm8succ_endEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm8succ_endEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> succ_end_BasicBlock$P(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    succ_end_BasicBlock$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 129,
 FQN="llvm::succ_end", NM="_ZN4llvm8succ_endEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm8succ_endEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ TerminatorInst.SuccIterator</*const*/ TerminatorInst /*P*/ , /*const*/ BasicBlock> succ_end_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    succ_end_BasicBlock$C$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_empty">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 132,
 FQN="llvm::succ_empty", NM="_ZN4llvm10succ_emptyEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10succ_emptyEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ boolean succ_empty(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    succ_empty(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::successors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 135,
 FQN="llvm::successors", NM="_ZN4llvm10successorsEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10successorsEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range<BasicBlock> successors_BasicBlock$P(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    successors_BasicBlock$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::successors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/CFG.h", line = 138,
 FQN="llvm::successors", NM="_ZN4llvm10successorsEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm10successorsEPKNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ BasicBlock> successors_BasicBlock$C$P(/*const*/ BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.ir.impl.CFGLlvmGlobals.
    successors_BasicBlock$C$P(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeWriteBitcodePassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 75,
 FQN="llvm::initializeWriteBitcodePassPass", NM="_ZN4llvm30initializeWriteBitcodePassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm30initializeWriteBitcodePassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeWriteBitcodePassPass(final PassRegistry /*&*/ Registry) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeWriteBitcodePassPass(Registry);
}


// Create wrappers for C Binding types (see CBindingWrapping.h).
//<editor-fold defaultstate="collapsed" desc="llvm::unwrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1799,
 FQN="llvm::unwrap", NM="_ZN4llvm6unwrapEP17LLVMOpaqueBuilder",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm6unwrapEP17LLVMOpaqueBuilder")
//</editor-fold>
public static /*inline*/ IRBuilder /*P*/ unwrap( LLVMOpaqueBuilder /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.IRBuilderLlvmGlobals.
    unwrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::wrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IRBuilder.h", line = 1799,
 FQN="llvm::wrap", NM="_ZN4llvm4wrapEPKNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm4wrapEPKNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEE")
//</editor-fold>
public static /*inline*/  LLVMOpaqueBuilder /*P*/ wrap(/*const*/ IRBuilder /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.IRBuilderLlvmGlobals.
    wrap(P);
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 97,
 FQN="llvm::gep_type_begin", NM="_ZN4llvm14gep_type_beginEPKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm14gep_type_beginEPKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_begin_User$C$P(/*const*/ User /*P*/ GEP) {
  return /*delegate*/org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals.
    gep_type_begin_User$C$P(GEP);
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 105,
 FQN="llvm::gep_type_end", NM="_ZN4llvm12gep_type_endEPKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12gep_type_endEPKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_end_User$C$P(/*const*/ User /*P*/ GEP) {
  return /*delegate*/org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals.
    gep_type_end_User$C$P(GEP);
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 108,
 FQN="llvm::gep_type_begin", NM="_ZN4llvm14gep_type_beginERKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm14gep_type_beginERKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_begin_User$C(final /*const*/ User /*&*/ GEP) {
  return /*delegate*/org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals.
    gep_type_begin_User$C(GEP);
}

//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 116,
 FQN="llvm::gep_type_end", NM="_ZN4llvm12gep_type_endERKNS_4UserE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=_ZN4llvm12gep_type_endERKNS_4UserE")
//</editor-fold>
public static /*inline*/ generic_gep_type_iterator gep_type_end_User$C(final /*const*/ User /*&*/ GEP) {
  return /*delegate*/org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals.
    gep_type_end_User$C(GEP);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 121,
 FQN="llvm::gep_type_begin", NM="Tpl__ZN4llvm14gep_type_beginEPNS_4TypeEjNS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=Tpl__ZN4llvm14gep_type_beginEPNS_4TypeEjNS_8ArrayRefIT_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> generic_gep_type_iterator</*const*/ T /*P*/ > gep_type_begin$T(Type /*P*/ Op0, /*uint*/int AS, ArrayRef<T> A) {
  return /*delegate*/org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals.
    gep_type_begin$T(Op0, AS, A);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::gep_type_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/GetElementPtrTypeIterator.h", line = 127,
 FQN="llvm::gep_type_end", NM="Tpl__ZN4llvm12gep_type_endEPNS_4TypeEjNS_8ArrayRefIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp -nm=Tpl__ZN4llvm12gep_type_endEPNS_4TypeEjNS_8ArrayRefIT_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> generic_gep_type_iterator</*const*/ T /*P*/ > gep_type_end$T(Type /*P*/ $Prm0/*Op0*/, /*uint*/int $Prm1/*AS*/, ArrayRef<T> A) {
  return /*delegate*/org.llvm.ir.impl.GetElementPtrTypeIteratorLlvmGlobals.
    gep_type_end$T($Prm0, $Prm1, A);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/ConstantRange.h", line = 316,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_13ConstantRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/ConstantRange.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_13ConstantRangeE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_ConstantRange$C(final raw_ostream /*&*/ OS, final /*const*/ ConstantRange /*&*/ CR) {
  return /*delegate*/org.llvm.ir.impl.ConstantRangeLlvmGlobals.
    $out_raw_ostream_ConstantRange$C(OS, CR);
}


/// Check whether a string looks like an old loop attachment tag.
//<editor-fold defaultstate="collapsed" desc="llvm::mayBeOldLoopAttachmentTag">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/AutoUpgrade.h", line = 73,
 FQN="llvm::mayBeOldLoopAttachmentTag", NM="_ZN4llvm25mayBeOldLoopAttachmentTagENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/AsmParser/LLParser.cpp -nm=_ZN4llvm25mayBeOldLoopAttachmentTagENS_9StringRefE")
//</editor-fold>
public static /*inline*/ boolean mayBeOldLoopAttachmentTag(StringRef Name) {
  return /*delegate*/org.llvm.ir.impl.AutoUpgradeLlvmGlobals.
    mayBeOldLoopAttachmentTag(Name);
}


/// isFunctionInPrintList - returns true if a function should be printed via
//  debugging options like -print-after-all/-print-before-all.
//  @brief Tells if the function IR should be printed by PrinterPass.
//<editor-fold defaultstate="collapsed" desc="llvm::isFunctionInPrintList">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 120,
 FQN="llvm::isFunctionInPrintList", NM="_ZN4llvm21isFunctionInPrintListENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm21isFunctionInPrintListENS_9StringRefE")
//</editor-fold>
public static boolean isFunctionInPrintList(StringRef FunctionName) {
  return /*delegate*/org.llvm.pass.impl.LegacyPassManagerLlvmGlobals.
    isFunctionInPrintList(FunctionName);
}


/// If TimingInfo is enabled then start pass timer.
//<editor-fold defaultstate="collapsed" desc="llvm::getPassTimer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1762,
 FQN="llvm::getPassTimer", NM="_ZN4llvm12getPassTimerEPNS_4PassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm12getPassTimerEPNS_4PassE")
//</editor-fold>
public static Timer /*P*/ getPassTimer(Pass /*P*/ P) {
  return /*delegate*/org.llvm.ir.impl.LegacyPassManagerLlvmGlobals.
    getPassTimer(P);
}


//===----------------------------------------------------------------------===//
// TimingInfo implementation
//<editor-fold defaultstate="collapsed" desc="llvm::TimePassesIsEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp", line = 1743,
 FQN="llvm::TimePassesIsEnabled", NM="_ZN4llvm19TimePassesIsEnabledE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/IR/LegacyPassManager.cpp -nm=_ZN4llvm19TimePassesIsEnabledE")
//</editor-fold>
public static boolean TimePassesIsEnabled = false;
@Converted(kind = Converted.Kind.MANUAL_ADDED)
public static bool$ref TimePassesIsEnabled$ref = new bool$ref() {
  @Override
  public boolean $deref() {
    return TimePassesIsEnabled;
  }
  @Override
  public boolean $set(boolean value) {
    TimePassesIsEnabled = value;
    return TimePassesIsEnabled;
  }        
};

/// Initialize all passes linked into the TransformUtils library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeCore">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 23,
 FQN="llvm::initializeCore", NM="_ZN4llvm14initializeCoreERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm14initializeCoreERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCore(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.CoreLlvmGlobals.
    initializeCore($Prm0);
}


/// Initialize all passes linked into the TransformUtils library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTransformUtils">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 26,
 FQN="llvm::initializeTransformUtils", NM="_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTransformUtils(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTransformUtils($Prm0);
}


/// Initialize all passes linked into the ScalarOpts library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarOpts">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 29,
 FQN="llvm::initializeScalarOpts", NM="_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarOpts(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeScalarOpts($Prm0);
}


/// Initialize all passes linked into the ObjCARCOpts library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOpts">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 32,
 FQN="llvm::initializeObjCARCOpts", NM="_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCOpts(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeObjCARCOpts($Prm0);
}


/// Initialize all passes linked into the Vectorize library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeVectorization">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 35,
 FQN="llvm::initializeVectorization", NM="_ZN4llvm23initializeVectorizationERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm23initializeVectorizationERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVectorization(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeVectorization($Prm0);
}


/// Initialize all passes linked into the InstCombine library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCombine">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 38,
 FQN="llvm::initializeInstCombine", NM="_ZN4llvm21initializeInstCombineERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm21initializeInstCombineERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstCombine(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstCombine($Prm0);
}


/// Initialize all passes linked into the IPO library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeIPO">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 41,
 FQN="llvm::initializeIPO", NM="_ZN4llvm13initializeIPOERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm13initializeIPOERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIPO(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIPO($Prm0);
}


/// Initialize all passes linked into the Instrumentation library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrumentation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 44,
 FQN="llvm::initializeInstrumentation", NM="_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstrumentation(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstrumentation($Prm0);
}


/// Initialize all passes linked into the Analysis library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeAnalysis">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 47,
 FQN="llvm::initializeAnalysis", NM="_ZN4llvm18initializeAnalysisERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm18initializeAnalysisERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAnalysis(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAnalysis($Prm0);
}


/// Initialize all passes linked into the CodeGen library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeCodeGen">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 50,
 FQN="llvm::initializeCodeGen", NM="_ZN4llvm17initializeCodeGenERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm17initializeCodeGenERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCodeGen(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCodeGen($Prm0);
}


/// Initialize all passes linked into the GlobalISel library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalISel">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 53,
 FQN="llvm::initializeGlobalISel", NM="_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalISel(final PassRegistry /*&*/ Registry) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGlobalISel(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAAEvalLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 58,
 FQN="llvm::initializeAAEvalLegacyPassPass", NM="_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAAEvalLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAAEvalLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAAResultsWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 59,
 FQN="llvm::initializeAAResultsWrapperPassPass", NM="_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAAResultsWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAAResultsWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeADCELegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 60,
 FQN="llvm::initializeADCELegacyPassPass", NM="_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeADCELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeADCELegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddDiscriminatorsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 61,
 FQN="llvm::initializeAddDiscriminatorsLegacyPassPass", NM="_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddDiscriminatorsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAddDiscriminatorsLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerModulePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 62,
 FQN="llvm::initializeAddressSanitizerModulePass", NM="_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddressSanitizerModulePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAddressSanitizerModulePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 63,
 FQN="llvm::initializeAddressSanitizerPass", NM="_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddressSanitizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAddressSanitizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAliasSetPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 64,
 FQN="llvm::initializeAliasSetPrinterPass", NM="_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAliasSetPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAliasSetPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAlignmentFromAssumptionsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 65,
 FQN="llvm::initializeAlignmentFromAssumptionsPass", NM="_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAlignmentFromAssumptionsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAlignmentFromAssumptionsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAlwaysInlinerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 66,
 FQN="llvm::initializeAlwaysInlinerPass", NM="_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAlwaysInlinerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAlwaysInlinerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeArgPromotionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 67,
 FQN="llvm::initializeArgPromotionPass", NM="_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeArgPromotionPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeArgPromotionPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAssumptionCacheTrackerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 68,
 FQN="llvm::initializeAssumptionCacheTrackerPass", NM="_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAssumptionCacheTrackerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAssumptionCacheTrackerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAtomicExpandPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 69,
 FQN="llvm::initializeAtomicExpandPass", NM="_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAtomicExpandPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeAtomicExpandPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBBVectorizePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 70,
 FQN="llvm::initializeBBVectorizePass", NM="_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBBVectorizePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBBVectorizePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBDCELegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 71,
 FQN="llvm::initializeBDCELegacyPassPass", NM="_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBDCELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBDCELegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBarrierNoopPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 72,
 FQN="llvm::initializeBarrierNoopPass", NM="_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBarrierNoopPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBarrierNoopPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBasicAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 73,
 FQN="llvm::initializeBasicAAWrapperPassPass", NM="_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBasicAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBasicAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockExtractorPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 74,
 FQN="llvm::initializeBlockExtractorPassPass", NM="_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBlockExtractorPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBlockExtractorPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockFrequencyInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 75,
 FQN="llvm::initializeBlockFrequencyInfoWrapperPassPass", NM="_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBlockFrequencyInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBlockFrequencyInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBoundsCheckingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 76,
 FQN="llvm::initializeBoundsCheckingPass", NM="_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBoundsCheckingPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBoundsCheckingPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchFolderPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 77,
 FQN="llvm::initializeBranchFolderPassPass", NM="_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBranchFolderPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBranchFolderPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchProbabilityInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 78,
 FQN="llvm::initializeBranchProbabilityInfoWrapperPassPass", NM="_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBranchProbabilityInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBranchProbabilityInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBreakCriticalEdgesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 79,
 FQN="llvm::initializeBreakCriticalEdgesPass", NM="_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBreakCriticalEdgesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeBreakCriticalEdgesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 80,
 FQN="llvm::initializeCFGOnlyPrinterPass", NM="_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGOnlyPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFGOnlyPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 81,
 FQN="llvm::initializeCFGOnlyViewerPass", NM="_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGOnlyViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFGOnlyViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 82,
 FQN="llvm::initializeCFGPrinterPass", NM="_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFGPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGSimplifyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 83,
 FQN="llvm::initializeCFGSimplifyPassPass", NM="_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGSimplifyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFGSimplifyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 84,
 FQN="llvm::initializeCFGViewerPass", NM="_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFGViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLAndersAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 85,
 FQN="llvm::initializeCFLAndersAAWrapperPassPass", NM="_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFLAndersAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFLAndersAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLSteensAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 86,
 FQN="llvm::initializeCFLSteensAAWrapperPassPass", NM="_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFLSteensAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCFLSteensAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphDOTPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 87,
 FQN="llvm::initializeCallGraphDOTPrinterPass", NM="_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphDOTPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCallGraphDOTPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphPrinterLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 88,
 FQN="llvm::initializeCallGraphPrinterLegacyPassPass", NM="_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphPrinterLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCallGraphPrinterLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 89,
 FQN="llvm::initializeCallGraphViewerPass", NM="_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCallGraphViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 90,
 FQN="llvm::initializeCallGraphWrapperPassPass", NM="_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCallGraphWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCodeGenPreparePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 91,
 FQN="llvm::initializeCodeGenPreparePass", NM="_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCodeGenPreparePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCodeGenPreparePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantHoistingLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 92,
 FQN="llvm::initializeConstantHoistingLegacyPassPass", NM="_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeConstantHoistingLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeConstantHoistingLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantMergeLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 93,
 FQN="llvm::initializeConstantMergeLegacyPassPass", NM="_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeConstantMergeLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeConstantMergeLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantPropagationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 94,
 FQN="llvm::initializeConstantPropagationPass", NM="_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeConstantPropagationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeConstantPropagationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCorrelatedValuePropagationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 95,
 FQN="llvm::initializeCorrelatedValuePropagationPass", NM="_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCorrelatedValuePropagationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCorrelatedValuePropagationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCostModelAnalysisPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 96,
 FQN="llvm::initializeCostModelAnalysisPass", NM="_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCostModelAnalysisPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCostModelAnalysisPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCrossDSOCFIPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 97,
 FQN="llvm::initializeCrossDSOCFIPass", NM="_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCrossDSOCFIPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeCrossDSOCFIPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDAEPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 98,
 FQN="llvm::initializeDAEPass", NM="_ZN4llvm17initializeDAEPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm17initializeDAEPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDAEPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDAEPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDAHPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 99,
 FQN="llvm::initializeDAHPass", NM="_ZN4llvm17initializeDAHPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm17initializeDAHPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDAHPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDAHPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDCELegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 100,
 FQN="llvm::initializeDCELegacyPassPass", NM="_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDCELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDCELegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDSELegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 101,
 FQN="llvm::initializeDSELegacyPassPass", NM="_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDSELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDSELegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDataFlowSanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 102,
 FQN="llvm::initializeDataFlowSanitizerPass", NM="_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDataFlowSanitizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDataFlowSanitizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadInstEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 103,
 FQN="llvm::initializeDeadInstEliminationPass", NM="_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDeadInstEliminationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDeadInstEliminationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadMachineInstructionElimPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 104,
 FQN="llvm::initializeDeadMachineInstructionElimPass", NM="_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDeadMachineInstructionElimPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDeadMachineInstructionElimPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDelinearizationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 105,
 FQN="llvm::initializeDelinearizationPass", NM="_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDelinearizationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDelinearizationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDemandedBitsWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 106,
 FQN="llvm::initializeDemandedBitsWrapperPassPass", NM="_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDemandedBitsWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDemandedBitsWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDependenceAnalysisWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 108,
 FQN="llvm::initializeDependenceAnalysisWrapperPassPass", NM="_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDependenceAnalysisWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDependenceAnalysisWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDetectDeadLanesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 109,
 FQN="llvm::initializeDetectDeadLanesPass", NM="_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDetectDeadLanesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDetectDeadLanesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDivergenceAnalysisPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 110,
 FQN="llvm::initializeDivergenceAnalysisPass", NM="_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDivergenceAnalysisPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDivergenceAnalysisPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 111,
 FQN="llvm::initializeDomOnlyPrinterPass", NM="_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomOnlyPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDomOnlyPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 112,
 FQN="llvm::initializeDomOnlyViewerPass", NM="_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomOnlyViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDomOnlyViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 113,
 FQN="llvm::initializeDomPrinterPass", NM="_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDomPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 114,
 FQN="llvm::initializeDomViewerPass", NM="_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDomViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDominanceFrontierWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 115,
 FQN="llvm::initializeDominanceFrontierWrapperPassPass", NM="_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDominanceFrontierWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDominanceFrontierWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDominatorTreeWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 116,
 FQN="llvm::initializeDominatorTreeWrapperPassPass", NM="_ZN4llvm38initializeDominatorTreeWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeDominatorTreeWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDominatorTreeWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.DominatorsLlvmGlobals.
    initializeDominatorTreeWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDwarfEHPreparePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 117,
 FQN="llvm::initializeDwarfEHPreparePass", NM="_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDwarfEHPreparePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeDwarfEHPreparePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyCSELegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 118,
 FQN="llvm::initializeEarlyCSELegacyPassPass", NM="_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEarlyCSELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeEarlyCSELegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyIfConverterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 119,
 FQN="llvm::initializeEarlyIfConverterPass", NM="_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEarlyIfConverterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeEarlyIfConverterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEdgeBundlesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 120,
 FQN="llvm::initializeEdgeBundlesPass", NM="_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEdgeBundlesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeEdgeBundlesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEfficiencySanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 121,
 FQN="llvm::initializeEfficiencySanitizerPass", NM="_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEfficiencySanitizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeEfficiencySanitizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEliminateAvailableExternallyLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 122,
 FQN="llvm::initializeEliminateAvailableExternallyLegacyPassPass", NM="_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEliminateAvailableExternallyLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeEliminateAvailableExternallyLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNHoistLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 123,
 FQN="llvm::initializeGVNHoistLegacyPassPass", NM="_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGVNHoistLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGVNHoistLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExpandISelPseudosPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 124,
 FQN="llvm::initializeExpandISelPseudosPass", NM="_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExpandISelPseudosPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeExpandISelPseudosPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExpandPostRAPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 125,
 FQN="llvm::initializeExpandPostRAPass", NM="_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExpandPostRAPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeExpandPostRAPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExternalAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 126,
 FQN="llvm::initializeExternalAAWrapperPassPass", NM="_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExternalAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeExternalAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFinalizeMachineBundlesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 127,
 FQN="llvm::initializeFinalizeMachineBundlesPass", NM="_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFinalizeMachineBundlesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeFinalizeMachineBundlesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFlattenCFGPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 128,
 FQN="llvm::initializeFlattenCFGPassPass", NM="_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFlattenCFGPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeFlattenCFGPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFloat2IntLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 129,
 FQN="llvm::initializeFloat2IntLegacyPassPass", NM="_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFloat2IntLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeFloat2IntLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeForceFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 130,
 FQN="llvm::initializeForceFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeForceFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeForceFunctionAttrsLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFuncletLayoutPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 132,
 FQN="llvm::initializeFuncletLayoutPass", NM="_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFuncletLayoutPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeFuncletLayoutPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFunctionImportPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 133,
 FQN="llvm::initializeFunctionImportPassPass", NM="_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFunctionImportPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeFunctionImportPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGCMachineCodeAnalysisPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 134,
 FQN="llvm::initializeGCMachineCodeAnalysisPass", NM="_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGCMachineCodeAnalysisPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGCMachineCodeAnalysisPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGCModuleInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 135,
 FQN="llvm::initializeGCModuleInfoPass", NM="_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGCModuleInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGCModuleInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGCOVProfilerLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 136,
 FQN="llvm::initializeGCOVProfilerLegacyPassPass", NM="_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGCOVProfilerLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGCOVProfilerLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 137,
 FQN="llvm::initializeGVNLegacyPassPass", NM="_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGVNLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGVNLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalDCELegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 138,
 FQN="llvm::initializeGlobalDCELegacyPassPass", NM="_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalDCELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGlobalDCELegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalMergePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 139,
 FQN="llvm::initializeGlobalMergePass", NM="_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalMergePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGlobalMergePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalOptLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 140,
 FQN="llvm::initializeGlobalOptLegacyPassPass", NM="_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalOptLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGlobalOptLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalsAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 141,
 FQN="llvm::initializeGlobalsAAWrapperPassPass", NM="_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalsAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGlobalsAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGuardWideningLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 142,
 FQN="llvm::initializeGuardWideningLegacyPassPass", NM="_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGuardWideningLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeGuardWideningLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIPCPPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 143,
 FQN="llvm::initializeIPCPPass", NM="_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIPCPPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIPCPPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIPSCCPLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 144,
 FQN="llvm::initializeIPSCCPLegacyPassPass", NM="_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIPSCCPLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIPSCCPLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIRTranslatorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 145,
 FQN="llvm::initializeIRTranslatorPass", NM="_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIRTranslatorPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIRTranslatorPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIVUsersWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 146,
 FQN="llvm::initializeIVUsersWrapperPassPass", NM="_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIVUsersWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIVUsersWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIfConverterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 147,
 FQN="llvm::initializeIfConverterPass", NM="_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIfConverterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIfConverterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeImplicitNullChecksPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 148,
 FQN="llvm::initializeImplicitNullChecksPass", NM="_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeImplicitNullChecksPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeImplicitNullChecksPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIndVarSimplifyLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 149,
 FQN="llvm::initializeIndVarSimplifyLegacyPassPass", NM="_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIndVarSimplifyLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIndVarSimplifyLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInductiveRangeCheckEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 150,
 FQN="llvm::initializeInductiveRangeCheckEliminationPass", NM="_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInductiveRangeCheckEliminationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInductiveRangeCheckEliminationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInferFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 151,
 FQN="llvm::initializeInferFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInferFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInferFunctionAttrsLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCountPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 153,
 FQN="llvm::initializeInstCountPass", NM="_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstCountPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstCountPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstNamerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 154,
 FQN="llvm::initializeInstNamerPass", NM="_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstNamerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstNamerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstSimplifierPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 155,
 FQN="llvm::initializeInstSimplifierPass", NM="_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstSimplifierPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstSimplifierPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrProfilingLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 156,
 FQN="llvm::initializeInstrProfilingLegacyPassPass", NM="_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstrProfilingLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstrProfilingLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstructionCombiningPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 157,
 FQN="llvm::initializeInstructionCombiningPassPass", NM="_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstructionCombiningPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInstructionCombiningPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInterleavedAccessPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 158,
 FQN="llvm::initializeInterleavedAccessPass", NM="_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInterleavedAccessPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInterleavedAccessPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInternalizeLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 159,
 FQN="llvm::initializeInternalizeLegacyPassPass", NM="_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInternalizeLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeInternalizeLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIntervalPartitionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 160,
 FQN="llvm::initializeIntervalPartitionPass", NM="_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIntervalPartitionPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeIntervalPartitionPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeJumpThreadingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 161,
 FQN="llvm::initializeJumpThreadingPass", NM="_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeJumpThreadingPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeJumpThreadingPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLCSSAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 162,
 FQN="llvm::initializeLCSSAWrapperPassPass", NM="_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLCSSAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLCSSAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLegacyLICMPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 163,
 FQN="llvm::initializeLegacyLICMPassPass", NM="_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLegacyLICMPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLegacyLICMPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyBlockFrequencyInfoPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 164,
 FQN="llvm::initializeLazyBlockFrequencyInfoPassPass", NM="_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyBlockFrequencyInfoPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLazyBlockFrequencyInfoPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyValueInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 165,
 FQN="llvm::initializeLazyValueInfoWrapperPassPass", NM="_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyValueInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLazyValueInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLintPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 166,
 FQN="llvm::initializeLintPass", NM="_ZN4llvm18initializeLintPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm18initializeLintPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLintPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLintPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveDebugValuesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 167,
 FQN="llvm::initializeLiveDebugValuesPass", NM="_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveDebugValuesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLiveDebugValuesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveDebugVariablesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 168,
 FQN="llvm::initializeLiveDebugVariablesPass", NM="_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveDebugVariablesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLiveDebugVariablesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveIntervalsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 169,
 FQN="llvm::initializeLiveIntervalsPass", NM="_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveIntervalsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLiveIntervalsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveRegMatrixPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 170,
 FQN="llvm::initializeLiveRegMatrixPass", NM="_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveRegMatrixPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLiveRegMatrixPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveStacksPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 171,
 FQN="llvm::initializeLiveStacksPass", NM="_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveStacksPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLiveStacksPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveVariablesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 172,
 FQN="llvm::initializeLiveVariablesPass", NM="_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveVariablesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLiveVariablesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadCombinePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 173,
 FQN="llvm::initializeLoadCombinePass", NM="_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoadCombinePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoadCombinePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadStoreVectorizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 175,
 FQN="llvm::initializeLoadStoreVectorizerPass", NM="_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoadStoreVectorizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoadStoreVectorizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLocalStackSlotPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 176,
 FQN="llvm::initializeLocalStackSlotPassPass", NM="_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLocalStackSlotPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLocalStackSlotPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopAccessLegacyAnalysisPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 177,
 FQN="llvm::initializeLoopAccessLegacyAnalysisPass", NM="_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopAccessLegacyAnalysisPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopAccessLegacyAnalysisPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDataPrefetchPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 178,
 FQN="llvm::initializeLoopDataPrefetchPass", NM="_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopDataPrefetchPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopDataPrefetchPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDeletionLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 179,
 FQN="llvm::initializeLoopDeletionLegacyPassPass", NM="_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopDeletionLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopDeletionLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDistributeLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 180,
 FQN="llvm::initializeLoopDistributeLegacyPass", NM="_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopDistributeLegacyPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopDistributeLegacyPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopExtractorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 181,
 FQN="llvm::initializeLoopExtractorPass", NM="_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopExtractorPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopExtractorPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopIdiomRecognizeLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 182,
 FQN="llvm::initializeLoopIdiomRecognizeLegacyPassPass", NM="_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopIdiomRecognizeLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopIdiomRecognizeLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 183,
 FQN="llvm::initializeLoopInfoWrapperPassPass", NM="_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInstSimplifyLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 184,
 FQN="llvm::initializeLoopInstSimplifyLegacyPassPass", NM="_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInstSimplifyLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopInstSimplifyLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInterchangePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 185,
 FQN="llvm::initializeLoopInterchangePass", NM="_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInterchangePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopInterchangePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopLoadEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 186,
 FQN="llvm::initializeLoopLoadEliminationPass", NM="_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopLoadEliminationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopLoadEliminationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 187,
 FQN="llvm::initializeLoopPassPass", NM="_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRerollPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 188,
 FQN="llvm::initializeLoopRerollPass", NM="_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopRerollPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopRerollPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRotateLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 189,
 FQN="llvm::initializeLoopRotateLegacyPassPass", NM="_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopRotateLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopRotateLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyCFGLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 190,
 FQN="llvm::initializeLoopSimplifyCFGLegacyPassPass", NM="_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopSimplifyCFGLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopSimplifyCFGLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 191,
 FQN="llvm::initializeLoopSimplifyPass", NM="_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopSimplifyPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopSimplifyPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopStrengthReducePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 192,
 FQN="llvm::initializeLoopStrengthReducePass", NM="_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopStrengthReducePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopStrengthReducePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnrollPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 193,
 FQN="llvm::initializeLoopUnrollPass", NM="_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopUnrollPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopUnrollPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnswitchPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 194,
 FQN="llvm::initializeLoopUnswitchPass", NM="_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopUnswitchPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopUnswitchPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVectorizePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 195,
 FQN="llvm::initializeLoopVectorizePass", NM="_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopVectorizePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopVectorizePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningLICMPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 196,
 FQN="llvm::initializeLoopVersioningLICMPass", NM="_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopVersioningLICMPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopVersioningLICMPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 197,
 FQN="llvm::initializeLoopVersioningPassPass", NM="_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopVersioningPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLoopVersioningPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerAtomicLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 198,
 FQN="llvm::initializeLowerAtomicLegacyPassPass", NM="_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerAtomicLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerAtomicLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerEmuTLSPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 199,
 FQN="llvm::initializeLowerEmuTLSPass", NM="_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerEmuTLSPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerEmuTLSPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerExpectIntrinsicPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 200,
 FQN="llvm::initializeLowerExpectIntrinsicPass", NM="_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerExpectIntrinsicPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerExpectIntrinsicPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerGuardIntrinsicPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 201,
 FQN="llvm::initializeLowerGuardIntrinsicPass", NM="_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerGuardIntrinsicPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerGuardIntrinsicPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerIntrinsicsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 202,
 FQN="llvm::initializeLowerIntrinsicsPass", NM="_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerIntrinsicsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerIntrinsicsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerInvokePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 203,
 FQN="llvm::initializeLowerInvokePass", NM="_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerInvokePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerInvokePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerSwitchPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 204,
 FQN="llvm::initializeLowerSwitchPass", NM="_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerSwitchPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerSwitchPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerTypeTestsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 205,
 FQN="llvm::initializeLowerTypeTestsPass", NM="_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerTypeTestsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeLowerTypeTestsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMIRPrintingPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 206,
 FQN="llvm::initializeMIRPrintingPassPass", NM="_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMIRPrintingPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMIRPrintingPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockFrequencyInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 207,
 FQN="llvm::initializeMachineBlockFrequencyInfoPass", NM="_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBlockFrequencyInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineBlockFrequencyInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockPlacementPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 208,
 FQN="llvm::initializeMachineBlockPlacementPass", NM="_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBlockPlacementPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineBlockPlacementPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockPlacementStatsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 209,
 FQN="llvm::initializeMachineBlockPlacementStatsPass", NM="_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBlockPlacementStatsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineBlockPlacementStatsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBranchProbabilityInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 210,
 FQN="llvm::initializeMachineBranchProbabilityInfoPass", NM="_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBranchProbabilityInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineBranchProbabilityInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCSEPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 211,
 FQN="llvm::initializeMachineCSEPass", NM="_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineCSEPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineCSEPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCombinerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 212,
 FQN="llvm::initializeMachineCombinerPass", NM="_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineCombinerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineCombinerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCopyPropagationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 213,
 FQN="llvm::initializeMachineCopyPropagationPass", NM="_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineCopyPropagationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineCopyPropagationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineDominanceFrontierPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 214,
 FQN="llvm::initializeMachineDominanceFrontierPass", NM="_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineDominanceFrontierPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineDominanceFrontierPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineDominatorTreePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 215,
 FQN="llvm::initializeMachineDominatorTreePass", NM="_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineDominatorTreePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineDominatorTreePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineFunctionPrinterPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 216,
 FQN="llvm::initializeMachineFunctionPrinterPassPass", NM="_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineFunctionPrinterPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineFunctionPrinterPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineLICMPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 217,
 FQN="llvm::initializeMachineLICMPass", NM="_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineLICMPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineLICMPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineLoopInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 218,
 FQN="llvm::initializeMachineLoopInfoPass", NM="_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineLoopInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineLoopInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineModuleInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 219,
 FQN="llvm::initializeMachineModuleInfoPass", NM="_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineModuleInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineModuleInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachinePostDominatorTreePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 220,
 FQN="llvm::initializeMachinePostDominatorTreePass", NM="_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachinePostDominatorTreePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachinePostDominatorTreePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineRegionInfoPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 221,
 FQN="llvm::initializeMachineRegionInfoPassPass", NM="_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineRegionInfoPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineRegionInfoPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineSchedulerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 222,
 FQN="llvm::initializeMachineSchedulerPass", NM="_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineSchedulerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineSchedulerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineSinkingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 223,
 FQN="llvm::initializeMachineSinkingPass", NM="_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineSinkingPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineSinkingPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineTraceMetricsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 224,
 FQN="llvm::initializeMachineTraceMetricsPass", NM="_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineTraceMetricsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineTraceMetricsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineVerifierPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 225,
 FQN="llvm::initializeMachineVerifierPassPass", NM="_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineVerifierPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMachineVerifierPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemCpyOptLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 226,
 FQN="llvm::initializeMemCpyOptLegacyPassPass", NM="_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemCpyOptLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemCpyOptLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDepPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 227,
 FQN="llvm::initializeMemDepPrinterPass", NM="_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemDepPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemDepPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDerefPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 228,
 FQN="llvm::initializeMemDerefPrinterPass", NM="_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemDerefPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemDerefPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemoryDependenceWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 229,
 FQN="llvm::initializeMemoryDependenceWrapperPassPass", NM="_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemoryDependenceWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemoryDependenceWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 230,
 FQN="llvm::initializeMemorySSAWrapperPassPass", NM="_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemorySSAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemorySSAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAPrinterLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 231,
 FQN="llvm::initializeMemorySSAPrinterLegacyPassPass", NM="_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemorySSAPrinterLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemorySSAPrinterLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 232,
 FQN="llvm::initializeMemorySanitizerPass", NM="_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemorySanitizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMemorySanitizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMergeFunctionsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 233,
 FQN="llvm::initializeMergeFunctionsPass", NM="_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMergeFunctionsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMergeFunctionsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMergedLoadStoreMotionLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 234,
 FQN="llvm::initializeMergedLoadStoreMotionLegacyPassPass", NM="_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMergedLoadStoreMotionLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMergedLoadStoreMotionLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMetaRenamerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 235,
 FQN="llvm::initializeMetaRenamerPass", NM="_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMetaRenamerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeMetaRenamerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleDebugInfoPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 236,
 FQN="llvm::initializeModuleDebugInfoPrinterPass", NM="_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeModuleDebugInfoPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeModuleDebugInfoPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleSummaryIndexWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 237,
 FQN="llvm::initializeModuleSummaryIndexWrapperPassPass", NM="_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeModuleSummaryIndexWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeModuleSummaryIndexWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeNameAnonFunctionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 238,
 FQN="llvm::initializeNameAnonFunctionPass", NM="_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeNameAnonFunctionPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeNameAnonFunctionPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeNaryReassociatePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 239,
 FQN="llvm::initializeNaryReassociatePass", NM="_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeNaryReassociatePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeNaryReassociatePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 241,
 FQN="llvm::initializeObjCARCAAWrapperPassPass", NM="_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeObjCARCAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAPElimPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 242,
 FQN="llvm::initializeObjCARCAPElimPass", NM="_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCAPElimPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeObjCARCAPElimPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCContractPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 243,
 FQN="llvm::initializeObjCARCContractPass", NM="_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCContractPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeObjCARCContractPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCExpandPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 244,
 FQN="llvm::initializeObjCARCExpandPass", NM="_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCExpandPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeObjCARCExpandPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOptPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 245,
 FQN="llvm::initializeObjCARCOptPass", NM="_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCOptPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeObjCARCOptPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizationRemarkEmitterWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 246,
 FQN="llvm::initializeOptimizationRemarkEmitterWrapperPassPass", NM="_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeOptimizationRemarkEmitterWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeOptimizationRemarkEmitterWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizePHIsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 247,
 FQN="llvm::initializeOptimizePHIsPass", NM="_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeOptimizePHIsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeOptimizePHIsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePAEvalPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 248,
 FQN="llvm::initializePAEvalPass", NM="_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePAEvalPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePAEvalPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePEIPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 249,
 FQN="llvm::initializePEIPass", NM="_ZN4llvm17initializePEIPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm17initializePEIPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePEIPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePEIPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePGOIndirectCallPromotionLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 250,
 FQN="llvm::initializePGOIndirectCallPromotionLegacyPassPass", NM="_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePGOIndirectCallPromotionLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePGOIndirectCallPromotionLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationGenLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 251,
 FQN="llvm::initializePGOInstrumentationGenLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePGOInstrumentationGenLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePGOInstrumentationGenLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationUseLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 252,
 FQN="llvm::initializePGOInstrumentationUseLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePGOInstrumentationUseLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePGOInstrumentationUseLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePHIEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 253,
 FQN="llvm::initializePHIEliminationPass", NM="_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePHIEliminationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePHIEliminationPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePhysicalRegisterUsageInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 254,
 FQN="llvm::initializePhysicalRegisterUsageInfoPass", NM="_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePhysicalRegisterUsageInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePhysicalRegisterUsageInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePartialInlinerLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 255,
 FQN="llvm::initializePartialInlinerLegacyPassPass", NM="_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePartialInlinerLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePartialInlinerLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePartiallyInlineLibCallsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 256,
 FQN="llvm::initializePartiallyInlineLibCallsLegacyPassPass", NM="_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePartiallyInlineLibCallsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePartiallyInlineLibCallsLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePatchableFunctionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 257,
 FQN="llvm::initializePatchableFunctionPass", NM="_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePatchableFunctionPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePatchableFunctionPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePeepholeOptimizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 258,
 FQN="llvm::initializePeepholeOptimizerPass", NM="_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePeepholeOptimizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePeepholeOptimizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceBackedgeSafepointsImplPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 259,
 FQN="llvm::initializePlaceBackedgeSafepointsImplPass", NM="_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePlaceBackedgeSafepointsImplPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePlaceBackedgeSafepointsImplPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceSafepointsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 260,
 FQN="llvm::initializePlaceSafepointsPass", NM="_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePlaceSafepointsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePlaceSafepointsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 261,
 FQN="llvm::initializePostDomOnlyPrinterPass", NM="_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomOnlyPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostDomOnlyPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 262,
 FQN="llvm::initializePostDomOnlyViewerPass", NM="_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomOnlyViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostDomOnlyViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 263,
 FQN="llvm::initializePostDomPrinterPass", NM="_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostDomPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 264,
 FQN="llvm::initializePostDomViewerPass", NM="_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostDomViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDominatorTreeWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 265,
 FQN="llvm::initializePostDominatorTreeWrapperPassPass", NM="_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDominatorTreeWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostDominatorTreeWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostMachineSchedulerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 266,
 FQN="llvm::initializePostMachineSchedulerPass", NM="_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostMachineSchedulerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostMachineSchedulerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostOrderFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 267,
 FQN="llvm::initializePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostOrderFunctionAttrsLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostRAHazardRecognizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 268,
 FQN="llvm::initializePostRAHazardRecognizerPass", NM="_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostRAHazardRecognizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostRAHazardRecognizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostRASchedulerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 269,
 FQN="llvm::initializePostRASchedulerPass", NM="_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostRASchedulerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePostRASchedulerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePreISelIntrinsicLoweringLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 270,
 FQN="llvm::initializePreISelIntrinsicLoweringLegacyPassPass", NM="_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePreISelIntrinsicLoweringLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePreISelIntrinsicLoweringLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePrintBasicBlockPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 271,
 FQN="llvm::initializePrintBasicBlockPassPass", NM="_ZN4llvm33initializePrintBasicBlockPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializePrintBasicBlockPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePrintBasicBlockPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.IRPrintingPassesLlvmGlobals.
    initializePrintBasicBlockPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePrintFunctionPassWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 272,
 FQN="llvm::initializePrintFunctionPassWrapperPass", NM="_ZN4llvm38initializePrintFunctionPassWrapperPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializePrintFunctionPassWrapperPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePrintFunctionPassWrapperPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.IRPrintingPassesLlvmGlobals.
    initializePrintFunctionPassWrapperPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePrintModulePassWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 273,
 FQN="llvm::initializePrintModulePassWrapperPass", NM="_ZN4llvm36initializePrintModulePassWrapperPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializePrintModulePassWrapperPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePrintModulePassWrapperPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.IRPrintingPassesLlvmGlobals.
    initializePrintModulePassWrapperPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeProcessImplicitDefsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 274,
 FQN="llvm::initializeProcessImplicitDefsPass", NM="_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeProcessImplicitDefsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeProcessImplicitDefsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeProfileSummaryInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 275,
 FQN="llvm::initializeProfileSummaryInfoWrapperPassPass", NM="_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeProfileSummaryInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeProfileSummaryInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePromoteLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 276,
 FQN="llvm::initializePromoteLegacyPassPass", NM="_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePromoteLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePromoteLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePruneEHPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 277,
 FQN="llvm::initializePruneEHPass", NM="_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePruneEHPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializePruneEHPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeReassociateLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 278,
 FQN="llvm::initializeReassociateLegacyPassPass", NM="_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeReassociateLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeReassociateLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegBankSelectPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 279,
 FQN="llvm::initializeRegBankSelectPass", NM="_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegBankSelectPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegBankSelectPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegToMemPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 280,
 FQN="llvm::initializeRegToMemPass", NM="_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegToMemPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegToMemPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionInfoPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 281,
 FQN="llvm::initializeRegionInfoPassPass", NM="_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionInfoPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegionInfoPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 282,
 FQN="llvm::initializeRegionOnlyPrinterPass", NM="_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionOnlyPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegionOnlyPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 283,
 FQN="llvm::initializeRegionOnlyViewerPass", NM="_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionOnlyViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegionOnlyViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 284,
 FQN="llvm::initializeRegionPrinterPass", NM="_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionPrinterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegionPrinterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 285,
 FQN="llvm::initializeRegionViewerPass", NM="_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionViewerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegionViewerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegisterCoalescerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 286,
 FQN="llvm::initializeRegisterCoalescerPass", NM="_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegisterCoalescerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRegisterCoalescerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRenameIndependentSubregsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 287,
 FQN="llvm::initializeRenameIndependentSubregsPass", NM="_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRenameIndependentSubregsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRenameIndependentSubregsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 288,
 FQN="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeReversePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeReversePostOrderFunctionAttrsLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteStatepointsForGCPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 289,
 FQN="llvm::initializeRewriteStatepointsForGCPass", NM="_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRewriteStatepointsForGCPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRewriteStatepointsForGCPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 290,
 FQN="llvm::initializeRewriteSymbolsPass", NM="_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRewriteSymbolsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeRewriteSymbolsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSCCPLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 291,
 FQN="llvm::initializeSCCPLegacyPassPass", NM="_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSCCPLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSCCPLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSCEVAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 292,
 FQN="llvm::initializeSCEVAAWrapperPassPass", NM="_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSCEVAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSCEVAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSLPVectorizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 293,
 FQN="llvm::initializeSLPVectorizerPass", NM="_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSLPVectorizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSLPVectorizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSROALegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 294,
 FQN="llvm::initializeSROALegacyPassPass", NM="_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSROALegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSROALegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSafeStackPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 295,
 FQN="llvm::initializeSafeStackPass", NM="_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSafeStackPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSafeStackPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSampleProfileLoaderLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 296,
 FQN="llvm::initializeSampleProfileLoaderLegacyPassPass", NM="_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSampleProfileLoaderLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSampleProfileLoaderLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSanitizerCoverageModulePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 297,
 FQN="llvm::initializeSanitizerCoverageModulePass", NM="_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSanitizerCoverageModulePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSanitizerCoverageModulePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarEvolutionWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 298,
 FQN="llvm::initializeScalarEvolutionWrapperPassPass", NM="_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarEvolutionWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeScalarEvolutionWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 299,
 FQN="llvm::initializeScalarizerPass", NM="_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeScalarizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScopedNoAliasAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 300,
 FQN="llvm::initializeScopedNoAliasAAWrapperPassPass", NM="_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScopedNoAliasAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeScopedNoAliasAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSeparateConstOffsetFromGEPPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 301,
 FQN="llvm::initializeSeparateConstOffsetFromGEPPass", NM="_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSeparateConstOffsetFromGEPPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSeparateConstOffsetFromGEPPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeShadowStackGCLoweringPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 302,
 FQN="llvm::initializeShadowStackGCLoweringPass", NM="_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeShadowStackGCLoweringPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeShadowStackGCLoweringPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeShrinkWrapPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 303,
 FQN="llvm::initializeShrinkWrapPass", NM="_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeShrinkWrapPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeShrinkWrapPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSimpleInlinerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 304,
 FQN="llvm::initializeSimpleInlinerPass", NM="_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSimpleInlinerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSimpleInlinerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSingleLoopExtractorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 305,
 FQN="llvm::initializeSingleLoopExtractorPass", NM="_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSingleLoopExtractorPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSingleLoopExtractorPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSinkingLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 306,
 FQN="llvm::initializeSinkingLegacyPassPass", NM="_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSinkingLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSinkingLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSjLjEHPreparePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 307,
 FQN="llvm::initializeSjLjEHPreparePass", NM="_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSjLjEHPreparePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSjLjEHPreparePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSlotIndexesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 308,
 FQN="llvm::initializeSlotIndexesPass", NM="_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSlotIndexesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSlotIndexesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSpeculativeExecutionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 309,
 FQN="llvm::initializeSpeculativeExecutionPass", NM="_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSpeculativeExecutionPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSpeculativeExecutionPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSpillPlacementPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 310,
 FQN="llvm::initializeSpillPlacementPass", NM="_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSpillPlacementPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeSpillPlacementPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackColoringPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 311,
 FQN="llvm::initializeStackColoringPass", NM="_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackColoringPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStackColoringPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackMapLivenessPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 312,
 FQN="llvm::initializeStackMapLivenessPass", NM="_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackMapLivenessPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStackMapLivenessPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackProtectorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 313,
 FQN="llvm::initializeStackProtectorPass", NM="_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackProtectorPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStackProtectorPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackSlotColoringPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 314,
 FQN="llvm::initializeStackSlotColoringPass", NM="_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackSlotColoringPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStackSlotColoringPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStraightLineStrengthReducePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 315,
 FQN="llvm::initializeStraightLineStrengthReducePass", NM="_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStraightLineStrengthReducePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStraightLineStrengthReducePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadDebugInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 316,
 FQN="llvm::initializeStripDeadDebugInfoPass", NM="_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripDeadDebugInfoPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStripDeadDebugInfoPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadPrototypesLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 317,
 FQN="llvm::initializeStripDeadPrototypesLegacyPassPass", NM="_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripDeadPrototypesLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStripDeadPrototypesLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDebugDeclarePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 318,
 FQN="llvm::initializeStripDebugDeclarePass", NM="_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripDebugDeclarePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStripDebugDeclarePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripNonDebugSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 319,
 FQN="llvm::initializeStripNonDebugSymbolsPass", NM="_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripNonDebugSymbolsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStripNonDebugSymbolsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 320,
 FQN="llvm::initializeStripSymbolsPass", NM="_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripSymbolsPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStripSymbolsPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStructurizeCFGPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 321,
 FQN="llvm::initializeStructurizeCFGPass", NM="_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStructurizeCFGPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeStructurizeCFGPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTailCallElimPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 322,
 FQN="llvm::initializeTailCallElimPass", NM="_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTailCallElimPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTailCallElimPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTailDuplicatePassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 323,
 FQN="llvm::initializeTailDuplicatePassPass", NM="_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTailDuplicatePassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTailDuplicatePassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetLibraryInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 324,
 FQN="llvm::initializeTargetLibraryInfoWrapperPassPass", NM="_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetLibraryInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTargetLibraryInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetPassConfigPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 325,
 FQN="llvm::initializeTargetPassConfigPass", NM="_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetPassConfigPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTargetPassConfigPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetTransformInfoWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 326,
 FQN="llvm::initializeTargetTransformInfoWrapperPassPass", NM="_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetTransformInfoWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTargetTransformInfoWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeThreadSanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 327,
 FQN="llvm::initializeThreadSanitizerPass", NM="_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeThreadSanitizerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeThreadSanitizerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTwoAddressInstructionPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 328,
 FQN="llvm::initializeTwoAddressInstructionPassPass", NM="_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTwoAddressInstructionPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTwoAddressInstructionPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTypeBasedAAWrapperPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 329,
 FQN="llvm::initializeTypeBasedAAWrapperPassPass", NM="_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTypeBasedAAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeTypeBasedAAWrapperPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnifyFunctionExitNodesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 330,
 FQN="llvm::initializeUnifyFunctionExitNodesPass", NM="_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnifyFunctionExitNodesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeUnifyFunctionExitNodesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnpackMachineBundlesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 331,
 FQN="llvm::initializeUnpackMachineBundlesPass", NM="_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnpackMachineBundlesPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeUnpackMachineBundlesPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnreachableBlockElimLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 332,
 FQN="llvm::initializeUnreachableBlockElimLegacyPassPass", NM="_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnreachableBlockElimLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeUnreachableBlockElimLegacyPassPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnreachableMachineBlockElimPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 333,
 FQN="llvm::initializeUnreachableMachineBlockElimPass", NM="_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnreachableMachineBlockElimPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeUnreachableMachineBlockElimPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeVerifierLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4368,
 FQN="llvm::initializeVerifierLegacyPassPass", NM="_ZN4llvm32initializeVerifierLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeVerifierLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVerifierLegacyPassPass(final PassRegistry /*&*/ Registry) {
  /*delegate*/org.llvm.pass.impl.VerifierLlvmGlobals.
    initializeVerifierLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeVirtRegMapPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 335,
 FQN="llvm::initializeVirtRegMapPass", NM="_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVirtRegMapPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeVirtRegMapPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeVirtRegRewriterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 336,
 FQN="llvm::initializeVirtRegRewriterPass", NM="_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVirtRegRewriterPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeVirtRegRewriterPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeWholeProgramDevirtPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 337,
 FQN="llvm::initializeWholeProgramDevirtPass", NM="_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeWholeProgramDevirtPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeWholeProgramDevirtPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeWinEHPreparePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 338,
 FQN="llvm::initializeWinEHPreparePass", NM="_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeWinEHPreparePass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeWinEHPreparePass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeXRayInstrumentationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 340,
 FQN="llvm::initializeXRayInstrumentationPass", NM="_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeXRayInstrumentationPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.pass.impl.InitializePassesLlvmGlobals.
    initializeXRayInstrumentationPass($Prm0);
}


/// Print out a name of an LLVM value without any prefixes.
///
/// The name is surrounded with ""'s and escaped if it has any special or
/// non-printable characters in it.
//<editor-fold defaultstate="collapsed" desc="llvm::printLLVMNameWithoutPrefix">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/IRPrintingPasses.h", line = 55,
 FQN="llvm::printLLVMNameWithoutPrefix", NM="_ZN4llvm26printLLVMNameWithoutPrefixERNS_11raw_ostreamENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm26printLLVMNameWithoutPrefixERNS_11raw_ostreamENS_9StringRefE")
//</editor-fold>
public static void printLLVMNameWithoutPrefix(final raw_ostream /*&*/ OS, StringRef Name) {
  /*delegate*/org.llvm.ir.impl.AsmWriterLlvmGlobals.
    printLLVMNameWithoutPrefix(OS, Name);
}

/// \brief Given "llvm.used" or "llvm.compiler.used" as a global name, collect
/// the initializer elements of that global in Set and return the global itself.
//<editor-fold defaultstate="collapsed" desc="llvm::collectUsedGlobalVariables">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Module.h", line = 828,
 FQN="llvm::collectUsedGlobalVariables", NM="_ZN4llvm26collectUsedGlobalVariablesERKNS_6ModuleERNS_15SmallPtrSetImplIPNS_11GlobalValueEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm26collectUsedGlobalVariablesERKNS_6ModuleERNS_15SmallPtrSetImplIPNS_11GlobalValueEEEb")
//</editor-fold>
public static GlobalVariable /*P*/ collectUsedGlobalVariables(final /*const*/ Module /*&*/ M, 
                          final SmallPtrSetImpl<GlobalValue /*P*/ > /*&*/ Set, 
                          boolean CompilerUsed) {
  return /*delegate*/org.llvm.ir.impl.ModuleLlvmGlobals.
    collectUsedGlobalVariables(M, 
                          Set, 
                          CompilerUsed);
}


/// \brief Check a function for errors, useful for use when debugging a
/// pass.
///
/// If there are no errors, the function returns false. If an error is found,
/// a message describing the error is written to OS (if non-null) and true is
/// returned.

//===----------------------------------------------------------------------===//
//  Implement the public interfaces to this file...
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::verifyFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4284,
 FQN="llvm::verifyFunction", NM="_ZN4llvm14verifyFunctionERKNS_8FunctionEPNS_11raw_ostreamE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm14verifyFunctionERKNS_8FunctionEPNS_11raw_ostreamE")
//</editor-fold>
public static boolean verifyFunction(final /*const*/ Function /*&*/ f) {
  return verifyFunction(f, (raw_ostream /*P*/ )null);
}
public static boolean verifyFunction(final /*const*/ Function /*&*/ f, raw_ostream /*P*/ OS/*= null*/) {
  return /*delegate*/org.llvm.ir.impl.VerifierLlvmGlobals.
    verifyFunction(f, OS);
}


/// \brief Check a module for errors.
///
/// If there are no errors, the function returns false. If an error is
/// found, a message describing the error is written to OS (if
/// non-null) and true is returned.
///
/// \return true if the module is broken. If BrokenDebugInfo is
/// supplied, DebugInfo verification failures won't be considered as
/// error and instead *BrokenDebugInfo will be set to true. Debug
/// info errors can be "recovered" from by stripping the debug info.
//<editor-fold defaultstate="collapsed" desc="llvm::verifyModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4295,
 FQN="llvm::verifyModule", NM="_ZN4llvm12verifyModuleERKNS_6ModuleEPNS_11raw_ostreamEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12verifyModuleERKNS_6ModuleEPNS_11raw_ostreamEPb")
//</editor-fold>
public static boolean verifyModule(final /*const*/ Module /*&*/ M) {
  return verifyModule(M, (raw_ostream /*P*/ )null, 
            (bool$ptr/*bool P*/ )null);
}
public static boolean verifyModule(final /*const*/ Module /*&*/ M, raw_ostream /*P*/ OS/*= null*/) {
  return verifyModule(M, OS, 
            (bool$ptr/*bool P*/ )null);
}
public static boolean verifyModule(final /*const*/ Module /*&*/ M, raw_ostream /*P*/ OS/*= null*/, 
            bool$ptr/*bool P*/ BrokenDebugInfo/*= null*/) {
  return /*delegate*/org.llvm.ir.impl.VerifierLlvmGlobals.
    verifyModule(M, OS, 
            BrokenDebugInfo);
}

//<editor-fold defaultstate="collapsed" desc="llvm::createVerifierPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/IR/Verifier.cpp", line = 4370,
 FQN="llvm::createVerifierPass", NM="_ZN4llvm18createVerifierPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm18createVerifierPassEb")
//</editor-fold>
public static FunctionPass /*P*/ createVerifierPass() {
  return createVerifierPass(true);
}
public static FunctionPass /*P*/ createVerifierPass(boolean FatalErrors/*= true*/) {
  return /*delegate*/org.llvm.ir.impl.VerifierLlvmGlobals.
    createVerifierPass(FatalErrors);
}


/// \brief Find subprogram that is enclosing this scope.
//<editor-fold defaultstate="collapsed" desc="llvm::getDISubprogram">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 37,
 FQN="llvm::getDISubprogram", NM="_ZN4llvm15getDISubprogramEPKNS_6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm15getDISubprogramEPKNS_6MDNodeE")
//</editor-fold>
public static DISubprogram /*P*/ getDISubprogram(/*const*/ MDNode /*P*/ Scope) {
  return /*delegate*/org.llvm.ir.impl.DebugInfoLlvmGlobals.
    getDISubprogram(Scope);
}


/// \brief Strip debug info in the module if it exists.
///
/// To do this, we remove all calls to the debugger intrinsics and any named
/// metadata for debugging. We also remove debug locations for instructions.
/// Return true if module is modified.
//<editor-fold defaultstate="collapsed" desc="llvm::StripDebugInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 44,
 FQN="llvm::StripDebugInfo", NM="_ZN4llvm14StripDebugInfoERNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm14StripDebugInfoERNS_6ModuleE")
//</editor-fold>
public static boolean StripDebugInfo(final Module /*&*/ M) {
  return /*delegate*/org.llvm.ir.impl.DebugInfoLlvmGlobals.
    StripDebugInfo(M);
}

//<editor-fold defaultstate="collapsed" desc="llvm::stripDebugInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 45,
 FQN="llvm::stripDebugInfo", NM="_ZN4llvm14stripDebugInfoERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm14stripDebugInfoERNS_8FunctionE")
//</editor-fold>
public static boolean stripDebugInfo(final Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.DebugInfoLlvmGlobals.
    stripDebugInfo(F);
}


/// \brief Return Debug Info Metadata Version by checking module flags.
//<editor-fold defaultstate="collapsed" desc="llvm::getDebugMetadataVersionFromModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DebugInfo.h", line = 48,
 FQN="llvm::getDebugMetadataVersionFromModule", NM="_ZN4llvm33getDebugMetadataVersionFromModuleERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm33getDebugMetadataVersionFromModuleERKNS_6ModuleE")
//</editor-fold>
public static /*uint*/int getDebugMetadataVersionFromModule(final /*const*/ Module /*&*/ M) {
  return /*delegate*/org.llvm.ir.impl.DebugInfoLlvmGlobals.
    getDebugMetadataVersionFromModule(M);
}


/// \brief Get the next available kind ID for a plugin diagnostic.
/// Each time this function is called, it returns a different number.
/// Therefore, a plugin that wants to "identify" its own classes
/// with a dynamic identifier, just have to use this method to get a new ID
/// and assign it to each of its classes.
/// The returned ID will be greater than or equal to DK_FirstPluginKind.
/// Thus, the plugin identifiers will not conflict with the
/// DiagnosticKind values.
//<editor-fold defaultstate="collapsed" desc="llvm::getNextAvailablePluginDiagnosticKind">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 80,
 FQN="llvm::getNextAvailablePluginDiagnosticKind", NM="_ZN4llvm36getNextAvailablePluginDiagnosticKindEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm36getNextAvailablePluginDiagnosticKindEv")
//</editor-fold>
public static int getNextAvailablePluginDiagnosticKind() {
  return /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    getNextAvailablePluginDiagnosticKind();
}


/// Emit an optimization-applied message. \p PassName is the name of the pass
/// emitting the message. If -Rpass= is given and \p PassName matches the
/// regular expression in -Rpass, then the remark will be emitted. \p Fn is
/// the function triggering the remark, \p DLoc is the debug location where
/// the diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemark">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 595,
 FQN="llvm::emitOptimizationRemark", NM="_ZN4llvm22emitOptimizationRemarkERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm22emitOptimizationRemarkERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemark(final LLVMContext /*&*/ Ctx, /*const*/char$ptr/*char P*/ PassName, 
                      final /*const*/ Function /*&*/ Fn, final /*const*/ DebugLoc /*&*/ DLoc, 
                      final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitOptimizationRemark(Ctx, PassName, 
                      Fn, DLoc, 
                      Msg);
}


/// Emit an optimization-missed message. \p PassName is the name of the
/// pass emitting the message. If -Rpass-missed= is given and \p PassName
/// matches the regular expression in -Rpass, then the remark will be
/// emitted. \p Fn is the function triggering the remark, \p DLoc is the
/// debug location where the diagnostic is generated. \p Msg is the
/// message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkMissed">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 605,
 FQN="llvm::emitOptimizationRemarkMissed", NM="_ZN4llvm28emitOptimizationRemarkMissedERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm28emitOptimizationRemarkMissedERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkMissed(final LLVMContext /*&*/ Ctx, /*const*/char$ptr/*char P*/ PassName, 
                            final /*const*/ Function /*&*/ Fn, final /*const*/ DebugLoc /*&*/ DLoc, 
                            final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitOptimizationRemarkMissed(Ctx, PassName, 
                            Fn, DLoc, 
                            Msg);
}


/// Emit an optimization analysis remark message. \p PassName is the name of
/// the pass emitting the message. If -Rpass-analysis= is given and \p
/// PassName matches the regular expression in -Rpass, then the remark will be
/// emitted. \p Fn is the function triggering the remark, \p DLoc is the debug
/// location where the diagnostic is generated. \p Msg is the message string
/// to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkAnalysis">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 615,
 FQN="llvm::emitOptimizationRemarkAnalysis", NM="_ZN4llvm30emitOptimizationRemarkAnalysisERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm30emitOptimizationRemarkAnalysisERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkAnalysis(final LLVMContext /*&*/ Ctx, /*const*/char$ptr/*char P*/ PassName, 
                              final /*const*/ Function /*&*/ Fn, final /*const*/ DebugLoc /*&*/ DLoc, 
                              final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitOptimizationRemarkAnalysis(Ctx, PassName, 
                              Fn, DLoc, 
                              Msg);
}


/// Emit an optimization analysis remark related to messages about
/// floating-point non-commutativity. \p PassName is the name of the pass
/// emitting the message. If -Rpass-analysis= is given and \p PassName matches
/// the regular expression in -Rpass, then the remark will be emitted. \p Fn is
/// the function triggering the remark, \p DLoc is the debug location where the
/// diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkAnalysisFPCommute">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 625,
 FQN="llvm::emitOptimizationRemarkAnalysisFPCommute", NM="_ZN4llvm39emitOptimizationRemarkAnalysisFPCommuteERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm39emitOptimizationRemarkAnalysisFPCommuteERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkAnalysisFPCommute(final LLVMContext /*&*/ Ctx, 
                                       /*const*/char$ptr/*char P*/ PassName, 
                                       final /*const*/ Function /*&*/ Fn, 
                                       final /*const*/ DebugLoc /*&*/ DLoc, 
                                       final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitOptimizationRemarkAnalysisFPCommute(Ctx, 
                                       PassName, 
                                       Fn, 
                                       DLoc, 
                                       Msg);
}


/// Emit an optimization analysis remark related to messages about
/// pointer aliasing. \p PassName is the name of the pass emitting the message.
/// If -Rpass-analysis= is given and \p PassName matches the regular expression
/// in -Rpass, then the remark will be emitted. \p Fn is the function triggering
/// the remark, \p DLoc is the debug location where the diagnostic is generated.
/// \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitOptimizationRemarkAnalysisAliasing">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 637,
 FQN="llvm::emitOptimizationRemarkAnalysisAliasing", NM="_ZN4llvm38emitOptimizationRemarkAnalysisAliasingERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm38emitOptimizationRemarkAnalysisAliasingERNS_11LLVMContextEPKcRKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitOptimizationRemarkAnalysisAliasing(final LLVMContext /*&*/ Ctx, 
                                      /*const*/char$ptr/*char P*/ PassName, 
                                      final /*const*/ Function /*&*/ Fn, 
                                      final /*const*/ DebugLoc /*&*/ DLoc, 
                                      final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitOptimizationRemarkAnalysisAliasing(Ctx, 
                                      PassName, 
                                      Fn, 
                                      DLoc, 
                                      Msg);
}


/// Emit a warning when loop vectorization is specified but fails. \p Fn is the
/// function triggering the warning, \p DLoc is the debug location where the
/// diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitLoopVectorizeWarning">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 697,
 FQN="llvm::emitLoopVectorizeWarning", NM="_ZN4llvm24emitLoopVectorizeWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm24emitLoopVectorizeWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitLoopVectorizeWarning(final LLVMContext /*&*/ Ctx, final /*const*/ Function /*&*/ Fn, 
                        final /*const*/ DebugLoc /*&*/ DLoc, final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitLoopVectorizeWarning(Ctx, Fn, 
                        DLoc, Msg);
}


/// Emit a warning when loop interleaving is specified but fails. \p Fn is the
/// function triggering the warning, \p DLoc is the debug location where the
/// diagnostic is generated. \p Msg is the message string to use.
//<editor-fold defaultstate="collapsed" desc="llvm::emitLoopInterleaveWarning">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/DiagnosticInfo.h", line = 703,
 FQN="llvm::emitLoopInterleaveWarning", NM="_ZN4llvm25emitLoopInterleaveWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25emitLoopInterleaveWarningERNS_11LLVMContextERKNS_8FunctionERKNS_8DebugLocERKNS_5TwineE")
//</editor-fold>
public static void emitLoopInterleaveWarning(final LLVMContext /*&*/ Ctx, final /*const*/ Function /*&*/ Fn, 
                         final /*const*/ DebugLoc /*&*/ DLoc, final /*const*/ Twine /*&*/ Msg) {
  /*delegate*/org.llvm.ir.impl.DiagnosticInfoLlvmGlobals.
    emitLoopInterleaveWarning(Ctx, Fn, 
                         DLoc, Msg);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 126,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm10inst_beginEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_begin_Function$P(Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_begin_Function$P(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 127,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm8inst_endEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_end_Function$P(Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_end_Function$P(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 128,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12instructionsEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range<Instruction /*&*/ > instructions_Function$P(Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    instructions_Function$P(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 131,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm10inst_beginEPKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_begin_Function$C$P(/*const*/ Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_begin_Function$C$P(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 134,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm8inst_endEPKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_end_Function$C$P(/*const*/ Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_end_Function$C$P(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 137,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12instructionsEPKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ Instruction /*&*/ > instructions_Function$C$P(/*const*/ Function /*P*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    instructions_Function$C$P(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 140,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm10inst_beginERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_begin_Function(final Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_begin_Function(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 141,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm8inst_endERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator<SymbolTableList<BasicBlock, Function>, ilist_iterator<BasicBlock>, ilist_iterator<Instruction>, Instruction> inst_end_Function(final Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_end_Function(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 142,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12instructionsERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range<Instruction /*&*/ > instructions_Function(final Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    instructions_Function(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 145,
 FQN="llvm::inst_begin", NM="_ZN4llvm10inst_beginERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm10inst_beginERKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_begin_Function$C(final /*const*/ Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_begin_Function$C(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::inst_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 148,
 FQN="llvm::inst_end", NM="_ZN4llvm8inst_endERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm8inst_endERKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ InstIterator</*const*/SymbolTableList<BasicBlock, Function>, ilist_iterator</*const*/ BasicBlock>, ilist_iterator</*const*/ Instruction>, /*const*/ Instruction> inst_end_Function$C(final /*const*/ Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    inst_end_Function$C(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::instructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/InstIterator.h", line = 151,
 FQN="llvm::instructions", NM="_ZN4llvm12instructionsERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12instructionsERKNS_8FunctionE")
//</editor-fold>
public static /*inline*/ iterator_range</*const*/ Instruction /*&*/ > instructions_Function$C(final /*const*/ Function /*&*/ F) {
  return /*delegate*/org.llvm.ir.impl.InstIteratorLlvmGlobals.
    instructions_Function$C(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStatepoint">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 45,
 FQN="llvm::isStatepoint", NM="_ZN4llvm12isStatepointENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12isStatepointENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean isStatepoint(ImmutableCallSite CS) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    isStatepoint(CS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStatepoint">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 46,
 FQN="llvm::isStatepoint", NM="_ZN4llvm12isStatepointEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12isStatepointEPKNS_5ValueE")
//</editor-fold>
public static boolean isStatepoint_Value$C$P(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    isStatepoint_Value$C$P(V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isStatepoint">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 47,
 FQN="llvm::isStatepoint", NM="_ZN4llvm12isStatepointERKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12isStatepointERKNS_5ValueE")
//</editor-fold>
public static boolean isStatepoint_Value$C(final /*const*/ Value /*&*/ V) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    isStatepoint_Value$C(V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isGCRelocate">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 49,
 FQN="llvm::isGCRelocate", NM="_ZN4llvm12isGCRelocateENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm12isGCRelocateENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean isGCRelocate(ImmutableCallSite CS) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    isGCRelocate(CS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isGCResult">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 50,
 FQN="llvm::isGCResult", NM="_ZN4llvm10isGCResultENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm10isGCResultENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean isGCResult(ImmutableCallSite CS) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    isGCResult(CS);
}


/// Parse out statepoint directives from the function attributes present in \p
/// AS.
//<editor-fold defaultstate="collapsed" desc="llvm::parseStatepointDirectivesFromAttrs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 442,
 FQN="llvm::parseStatepointDirectivesFromAttrs", NM="_ZN4llvm34parseStatepointDirectivesFromAttrsENS_12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm34parseStatepointDirectivesFromAttrsENS_12AttributeSetE")
//</editor-fold>
public static StatepointDirectives parseStatepointDirectivesFromAttrs(AttributeSet AS) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    parseStatepointDirectivesFromAttrs(AS);
}


/// Return \c true if the the \p Attr is an attribute that is a statepoint
/// directive.
//<editor-fold defaultstate="collapsed" desc="llvm::isStatepointDirectiveAttr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/IR/Statepoint.h", line = 446,
 FQN="llvm::isStatepointDirectiveAttr", NM="_ZN4llvm25isStatepointDirectiveAttrENS_9AttributeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/IR/Verifier.cpp -nm=_ZN4llvm25isStatepointDirectiveAttrENS_9AttributeE")
//</editor-fold>
public static boolean isStatepointDirectiveAttr(Attribute Attr) {
  return /*delegate*/org.llvm.ir.impl.StatepointLlvmGlobals.
    isStatepointDirectiveAttr(Attr);
}

@Converted(kind = Converted.Kind.MANUAL)
public static ModulePass /*P*/ createPrintModulePass(final raw_ostream /*&*/ OS, std.string Banner, boolean ShouldPreserveUseListOrder) {
  return IRPrintingPassesLlvmGlobals.createPrintModulePass(OS, Banner, ShouldPreserveUseListOrder);
}

} // END OF class IrLlvmGlobals
