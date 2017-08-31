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
package org.llvm.pass.impl;

import org.clank.java.std;
import org.clank.support.*;
import org.llvm.ir.TypeBasedAliasAnalysisStatics;
import org.llvm.pass.*;
import org.llvm.pass.spi.LllvmAnalysisPassInitializer;
import org.llvm.pass.spi.LllvmBitcodePassInitializer;
import org.llvm.pass.spi.LllvmCodegenInitializer;
import org.llvm.pass.spi.LllvmTransformsPassInitializer;
import org.llvm.support.AdtsupportLlvmGlobals;


//<editor-fold defaultstate="collapsed" desc="static type InitializePassesLlvmGlobals">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 NM="org.llvm.pass.impl.InitializePassesLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp ${LLVM_SRC}/llvm/lib/CodeGen/AtomicExpandPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp ${LLVM_SRC}/llvm/lib/CodeGen/BranchFolding.cpp ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp ${LLVM_SRC}/llvm/lib/CodeGen/CodeGen.cpp ${LLVM_SRC}/llvm/lib/CodeGen/CodeGenPrepare.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp ${LLVM_SRC}/llvm/lib/CodeGen/DeadMachineInstructionElim.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp ${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/CodeGen/DetectDeadLanes.cpp ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp ${LLVM_SRC}/llvm/lib/CodeGen/DwarfEHPrepare.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp ${LLVM_SRC}/llvm/lib/CodeGen/EarlyIfConversion.cpp ${LLVM_SRC}/llvm/lib/CodeGen/EdgeBundles.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp ${LLVM_SRC}/llvm/lib/CodeGen/ExpandISelPseudos.cpp ${LLVM_SRC}/llvm/lib/CodeGen/ExpandPostRAPseudos.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/CodeGen/FuncletLayout.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp ${LLVM_SRC}/llvm/lib/CodeGen/GCMetadata.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp ${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/GlobalISel.cpp ${LLVM_SRC}/llvm/lib/CodeGen/GlobalMerge.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/IRTranslator.cpp ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp ${LLVM_SRC}/llvm/lib/CodeGen/IfConversion.cpp ${LLVM_SRC}/llvm/lib/CodeGen/ImplicitNullChecks.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp ${LLVM_SRC}/llvm/lib/CodeGen/InterleavedAccessPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugValues.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugVariables.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LiveIntervalAnalysis.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LiveRegMatrix.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LiveStackAnalysis.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LiveVariables.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LocalStackSlotAllocation.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp ${LLVM_SRC}/llvm/lib/CodeGen/LowerEmuTLS.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MIRPrintingPass.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineBranchProbabilityInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineCombiner.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineCopyPropagation.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineDominanceFrontier.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineDominators.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineFunctionPrinterPass.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineLICM.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineLoopInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineModuleInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachinePostDominators.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineRegionInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineSink.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineTraceMetrics.cpp ${LLVM_SRC}/llvm/lib/CodeGen/MachineVerifier.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp ${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/OptimizePHIs.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PHIElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PatchableFunction.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PeepholeOptimizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp ${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PostRAHazardRecognizer.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PostRASchedulerList.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PreISelIntrinsicLowering.cpp ${LLVM_SRC}/llvm/lib/CodeGen/ProcessImplicitDefs.cpp ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/PrologEpilogInserter.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ProvenanceAnalysisEvaluator.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/RegBankSelect.cpp ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp ${LLVM_SRC}/llvm/lib/CodeGen/RegisterCoalescer.cpp ${LLVM_SRC}/llvm/lib/CodeGen/RegisterUsageInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/RenameIndependentSubregs.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp ${LLVM_SRC}/llvm/lib/CodeGen/SafeStack.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp ${LLVM_SRC}/llvm/lib/CodeGen/ShadowStackGCLowering.cpp ${LLVM_SRC}/llvm/lib/CodeGen/ShrinkWrap.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp ${LLVM_SRC}/llvm/lib/CodeGen/SjLjEHPrepare.cpp ${LLVM_SRC}/llvm/lib/CodeGen/SlotIndexes.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp ${LLVM_SRC}/llvm/lib/CodeGen/SpillPlacement.cpp ${LLVM_SRC}/llvm/lib/CodeGen/StackColoring.cpp ${LLVM_SRC}/llvm/lib/CodeGen/StackMapLivenessAnalysis.cpp ${LLVM_SRC}/llvm/lib/CodeGen/StackProtector.cpp ${LLVM_SRC}/llvm/lib/CodeGen/StackSlotColoring.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp ${LLVM_SRC}/llvm/lib/CodeGen/TailDuplication.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp ${LLVM_SRC}/llvm/lib/CodeGen/TargetPassConfig.cpp ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp ${LLVM_SRC}/llvm/lib/CodeGen/TwoAddressInstructionPass.cpp ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp ${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp ${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp ${LLVM_SRC}/llvm/lib/CodeGen/WinEHPrepare.cpp ${LLVM_SRC}/llvm/lib/CodeGen/XRayInstrumentation.cpp -nm=_ZN4llvm13initializeIPOERNS_12PassRegistryE;_ZN4llvm17initializeCodeGenERNS_12PassRegistryE;_ZN4llvm17initializeDAEPassERNS_12PassRegistryE;_ZN4llvm17initializeDAHPassERNS_12PassRegistryE;_ZN4llvm17initializePEIPassERNS_12PassRegistryE;_ZN4llvm18initializeAnalysisERNS_12PassRegistryE;_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE;_ZN4llvm18initializeLintPassERNS_12PassRegistryE;_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE;_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE;_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE;_ZN4llvm21initializeInstCombineERNS_12PassRegistryE;_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE;_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE;_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE;_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE;_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE;_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE;_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE;_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE;_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE;_ZN4llvm23initializeVectorizationERNS_12PassRegistryE;_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE;_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE;_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE;_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE;_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE;_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE;_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE;_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE;_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE;_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE;_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE;_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE;_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE;_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE;_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE;_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE;_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE;_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE;_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE;_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE;_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE;_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE;_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE;_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE;_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE;_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE;_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE;_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE;_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE;_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE;_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE;_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE;_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE;_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE;_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE;_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE;_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE;_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE;_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE;_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE;_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE;_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE;_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE;_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE;_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE;_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE;_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE;_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE;_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE;_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE;_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE;_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE;_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE;_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE;_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE;_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE;_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE;_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE;_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE;_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE;_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE;_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE;_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE;_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE;_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE;_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE;_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE;_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE;_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE;_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE;_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE;_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE;_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE;_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE;_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE;_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE;_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE;_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE;_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE;_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE;_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE;_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE;_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE;_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE;_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE;_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE;_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE;_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE;_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE;_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE;_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE;_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE;_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE;_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE;_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE;_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE;_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE;_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE;_ZN4llvm30initializeWriteBitcodePassPassERNS_12PassRegistryE;_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE;_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE;_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE;_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE;_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE;_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE;_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE;_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE;_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE;_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE;_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE;_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE;_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE;_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE;_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE;_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE;_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE;_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE;_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE;_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE;_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE;_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE;_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE;_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE;_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE;_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE;_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE;_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE;_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE;_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE;_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE;_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE;_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE;_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE;_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE;_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE;_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE;_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE;_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE;_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE;_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE;_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE;_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE;_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE;_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE;_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE;_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE;_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE;_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE;_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE;_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE;_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE;_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE;_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE;_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE;_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE;_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE;_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE;_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE;_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE;_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE;_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE;_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE;_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE;_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE;_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE;_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE;_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE;_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE;_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE;_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE;_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE;_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE;_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE;_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE;_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE;_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE;_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE;_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE;_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE;_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE;_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE;_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE;_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE;_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE;_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE;_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE;_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE;_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE; -static-type=InitializePassesLlvmGlobals -package=org.llvm.pass.impl -empty-body")
//</editor-fold>
public final class InitializePassesLlvmGlobals {

//<editor-fold defaultstate="collapsed" desc="llvm::initializeADCELegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 179,
 FQN="llvm::initializeADCELegacyPassPass", NM="_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeADCELegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeTargetLibraryInfoWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddDiscriminatorsLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 92,
 FQN="llvm::initializeAddDiscriminatorsLegacyPassPass", NM="_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddDiscriminatorsLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeAddDiscriminatorsLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerModulePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp", line = 821,
 FQN="llvm::initializeAddressSanitizerModulePass", NM="_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddressSanitizerModulePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeAddressSanitizerModulePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp", line = 809,
 FQN="llvm::initializeAddressSanitizerPass", NM="_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddressSanitizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeAddressSanitizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAAResultsWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 567,
 FQN="llvm::initializeAAResultsWrapperPassPass", NM="_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAAResultsWrapperPassPass(final PassRegistry /*&*/ Registry) {
  //AliasAnalysisLlvmStatics
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeAAResultsWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExternalAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 542,
 FQN="llvm::initializeExternalAAWrapperPassPass", NM="_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExternalAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeExternalAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAAEvalLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 385,
 FQN="llvm::initializeAAEvalLegacyPassPass", NM="_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAAEvalLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeAAEvalLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAliasSetPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 717,
 FQN="llvm::initializeAliasSetPrinterPass", NM="_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAliasSetPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeAliasSetPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAlignmentFromAssumptionsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp", line = 80,
 FQN="llvm::initializeAlignmentFromAssumptionsPass", NM="_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp -nm=_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAlignmentFromAssumptionsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeAlignmentFromAssumptionsPass(Registry);
}


/// Initialize all passes linked into the Analysis library.

/// initializeAnalysis - Initialize all passes linked into the Analysis library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeAnalysis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 22,
 FQN="llvm::initializeAnalysis", NM="_ZN4llvm18initializeAnalysisERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_ZN4llvm18initializeAnalysisERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAnalysis(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeAAEvalLegacyPassPass(Registry);
  IrLlvmGlobals.initializeAliasSetPrinterPass(Registry);
  IrLlvmGlobals.initializeBasicAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeBlockFrequencyInfoWrapperPassPass(Registry);
  IrLlvmGlobals.initializeBranchProbabilityInfoWrapperPassPass(Registry);
  IrLlvmGlobals.initializeCallGraphWrapperPassPass(Registry);
  IrLlvmGlobals.initializeCallGraphDOTPrinterPass(Registry);
  IrLlvmGlobals.initializeCallGraphPrinterLegacyPassPass(Registry);
  IrLlvmGlobals.initializeCallGraphViewerPass(Registry);
  IrLlvmGlobals.initializeCostModelAnalysisPass(Registry);
  IrLlvmGlobals.initializeCFGViewerPass(Registry);
  IrLlvmGlobals.initializeCFGPrinterPass(Registry);
  IrLlvmGlobals.initializeCFGOnlyViewerPass(Registry);
  IrLlvmGlobals.initializeCFGOnlyPrinterPass(Registry);
  IrLlvmGlobals.initializeCFLAndersAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeCFLSteensAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeDependenceAnalysisWrapperPassPass(Registry);
  IrLlvmGlobals.initializeDelinearizationPass(Registry);
  IrLlvmGlobals.initializeDemandedBitsWrapperPassPass(Registry);
  IrLlvmGlobals.initializeDivergenceAnalysisPass(Registry);
  IrLlvmGlobals.initializeDominanceFrontierWrapperPassPass(Registry);
  IrLlvmGlobals.initializeDomViewerPass(Registry);
  IrLlvmGlobals.initializeDomPrinterPass(Registry);
  IrLlvmGlobals.initializeDomOnlyViewerPass(Registry);
  IrLlvmGlobals.initializePostDomViewerPass(Registry);
  IrLlvmGlobals.initializeDomOnlyPrinterPass(Registry);
  IrLlvmGlobals.initializePostDomPrinterPass(Registry);
  IrLlvmGlobals.initializePostDomOnlyViewerPass(Registry);
  IrLlvmGlobals.initializePostDomOnlyPrinterPass(Registry);
  IrLlvmGlobals.initializeAAResultsWrapperPassPass(Registry);
  IrLlvmGlobals.initializeGlobalsAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeIVUsersWrapperPassPass(Registry);
  IrLlvmGlobals.initializeInstCountPass(Registry);
  IrLlvmGlobals.initializeIntervalPartitionPass(Registry);
  IrLlvmGlobals.initializeLazyBlockFrequencyInfoPassPass(Registry);
  IrLlvmGlobals.initializeLazyValueInfoWrapperPassPass(Registry);
  IrLlvmGlobals.initializeLintPass(Registry);
  IrLlvmGlobals.initializeLoopInfoWrapperPassPass(Registry);
  IrLlvmGlobals.initializeMemDepPrinterPass(Registry);
  IrLlvmGlobals.initializeMemDerefPrinterPass(Registry);
  IrLlvmGlobals.initializeMemoryDependenceWrapperPassPass(Registry);
  IrLlvmGlobals.initializeModuleDebugInfoPrinterPass(Registry);
  IrLlvmGlobals.initializeModuleSummaryIndexWrapperPassPass(Registry);
  IrLlvmGlobals.initializeObjCARCAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeOptimizationRemarkEmitterWrapperPassPass(Registry);
  IrLlvmGlobals.initializePostDominatorTreeWrapperPassPass(Registry);
  IrLlvmGlobals.initializeRegionInfoPassPass(Registry);
  IrLlvmGlobals.initializeRegionViewerPass(Registry);
  IrLlvmGlobals.initializeRegionPrinterPass(Registry);
  IrLlvmGlobals.initializeRegionOnlyViewerPass(Registry);
  IrLlvmGlobals.initializeRegionOnlyPrinterPass(Registry);
  IrLlvmGlobals.initializeSCEVAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeScalarEvolutionWrapperPassPass(Registry);
  IrLlvmGlobals.initializeTargetTransformInfoWrapperPassPass(Registry);
  IrLlvmGlobals.initializeTypeBasedAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeScopedNoAliasAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeArgPromotionPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp", line = 113,
 FQN="llvm::initializeArgPromotionPass", NM="_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeArgPromotionPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeArgPromotionPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAssumptionCacheTrackerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 138,
 FQN="llvm::initializeAssumptionCacheTrackerPass", NM="_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAssumptionCacheTrackerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeAssumptionCacheTrackerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAtomicExpandPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/AtomicExpandPass.cpp", line = 101,
 FQN="llvm::initializeAtomicExpandPass", NM="_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/AtomicExpandPass.cpp -nm=_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAtomicExpandPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeAtomicExpandPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBBVectorizePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp", line = 3231,
 FQN="llvm::initializeBBVectorizePass", NM="_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBBVectorizePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeBBVectorizePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBDCELegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp", line = 109,
 FQN="llvm::initializeBDCELegacyPassPass", NM="_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp -nm=_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBDCELegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeBDCELegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBarrierNoopPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp", line = 46,
 FQN="llvm::initializeBarrierNoopPass", NM="_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp -nm=_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBarrierNoopPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeBarrierNoopPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBasicAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1692,
 FQN="llvm::initializeBasicAAWrapperPassPass", NM="_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBasicAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeBasicAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeWriteBitcodePassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp", line = 75,
 FQN="llvm::initializeWriteBitcodePassPass", NM="_ZN4llvm30initializeWriteBitcodePassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm30initializeWriteBitcodePassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeWriteBitcodePassPass(final PassRegistry /*&*/ Registry) {
  LllvmBitcodePassInitializer$$.PROVIDER.initializeWriteBitcodePassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockFrequencyInfoWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 217,
 FQN="llvm::initializeBlockFrequencyInfoWrapperPassPass", NM="_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBlockFrequencyInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeBlockFrequencyInfoWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBoundsCheckingPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 69,
 FQN="llvm::initializeBoundsCheckingPass", NM="_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBoundsCheckingPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeBoundsCheckingPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchFolderPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/BranchFolding.cpp", line = 90,
 FQN="llvm::initializeBranchFolderPassPass", NM="_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/BranchFolding.cpp -nm=_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBranchFolderPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeBranchFolderPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchProbabilityInfoWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 33,
 FQN="llvm::initializeBranchProbabilityInfoWrapperPassPass", NM="_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBranchProbabilityInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeBranchProbabilityInfoWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBreakCriticalEdgesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp", line = 66,
 FQN="llvm::initializeBreakCriticalEdgesPass", NM="_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp -nm=_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBreakCriticalEdgesPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeBreakCriticalEdgesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 136,
 FQN="llvm::initializeCFGOnlyPrinterPass", NM="_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCFGOnlyPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 69,
 FQN="llvm::initializeCFGOnlyViewerPass", NM="_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCFGOnlyViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 103,
 FQN="llvm::initializeCFGPrinterPass", NM="_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCFGPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 46,
 FQN="llvm::initializeCFGViewerPass", NM="_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCFGViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLAndersAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 565,
 FQN="llvm::initializeCFLAndersAAWrapperPassPass", NM="_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFLAndersAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCFLAndersAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLSteensAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 423,
 FQN="llvm::initializeCFLSteensAAWrapperPassPass", NM="_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFLSteensAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCFLSteensAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphPrinterLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 336,
 FQN="llvm::initializeCallGraphPrinterLegacyPassPass", NM="_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphPrinterLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCallGraphPrinterLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 293,
 FQN="llvm::initializeCallGraphWrapperPassPass", NM="_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCallGraphWrapperPassPass(Registry);  
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphDOTPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 81,
 FQN="llvm::initializeCallGraphDOTPrinterPass", NM="_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphDOTPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCallGraphDOTPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 77,
 FQN="llvm::initializeCallGraphViewerPass", NM="_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCallGraphViewerPass(Registry);
}


/// Initialize all passes linked into the CodeGen library.

/// initializeCodeGen - Initialize all passes linked into the CodeGen library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeCodeGen">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/CodeGen.cpp", line = 22,
 FQN="llvm::initializeCodeGen", NM="_ZN4llvm17initializeCodeGenERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/CodeGen.cpp -nm=_ZN4llvm17initializeCodeGenERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCodeGen(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeAtomicExpandPass(Registry);
  IrLlvmGlobals.initializeBranchFolderPassPass(Registry);
  IrLlvmGlobals.initializeCodeGenPreparePass(Registry);
  IrLlvmGlobals.initializeDeadMachineInstructionElimPass(Registry);
  IrLlvmGlobals.initializeDetectDeadLanesPass(Registry);
  IrLlvmGlobals.initializeDwarfEHPreparePass(Registry);
  IrLlvmGlobals.initializeEarlyIfConverterPass(Registry);
  IrLlvmGlobals.initializeExpandISelPseudosPass(Registry);
  IrLlvmGlobals.initializeExpandPostRAPass(Registry);
  IrLlvmGlobals.initializeFinalizeMachineBundlesPass(Registry);
  IrLlvmGlobals.initializeFuncletLayoutPass(Registry);
  IrLlvmGlobals.initializeGCMachineCodeAnalysisPass(Registry);
  IrLlvmGlobals.initializeGCModuleInfoPass(Registry);
  IrLlvmGlobals.initializeIfConverterPass(Registry);
  IrLlvmGlobals.initializeInterleavedAccessPass(Registry);
  IrLlvmGlobals.initializeLiveDebugVariablesPass(Registry);
  IrLlvmGlobals.initializeLiveIntervalsPass(Registry);
  IrLlvmGlobals.initializeLiveStacksPass(Registry);
  IrLlvmGlobals.initializeLiveVariablesPass(Registry);
  IrLlvmGlobals.initializeLocalStackSlotPassPass(Registry);
  IrLlvmGlobals.initializeLowerIntrinsicsPass(Registry);
  IrLlvmGlobals.initializeMachineBlockFrequencyInfoPass(Registry);
  IrLlvmGlobals.initializeMachineBlockPlacementPass(Registry);
  IrLlvmGlobals.initializeMachineBlockPlacementStatsPass(Registry);
  IrLlvmGlobals.initializeMachineCSEPass(Registry);
  IrLlvmGlobals.initializeImplicitNullChecksPass(Registry);
  IrLlvmGlobals.initializeMachineCombinerPass(Registry);
  IrLlvmGlobals.initializeMachineCopyPropagationPass(Registry);
  IrLlvmGlobals.initializeMachineDominatorTreePass(Registry);
  IrLlvmGlobals.initializeMachineFunctionPrinterPassPass(Registry);
  IrLlvmGlobals.initializeMachineLICMPass(Registry);
  IrLlvmGlobals.initializeMachineLoopInfoPass(Registry);
  IrLlvmGlobals.initializeMachineModuleInfoPass(Registry);
  IrLlvmGlobals.initializeMachinePostDominatorTreePass(Registry);
  IrLlvmGlobals.initializeMachineSchedulerPass(Registry);
  IrLlvmGlobals.initializeMachineSinkingPass(Registry);
  IrLlvmGlobals.initializeMachineVerifierPassPass(Registry);
  IrLlvmGlobals.initializeXRayInstrumentationPass(Registry);
  IrLlvmGlobals.initializePatchableFunctionPass(Registry);
  IrLlvmGlobals.initializeOptimizePHIsPass(Registry);
  IrLlvmGlobals.initializePEIPass(Registry);
  IrLlvmGlobals.initializePHIEliminationPass(Registry);
  IrLlvmGlobals.initializePeepholeOptimizerPass(Registry);
  IrLlvmGlobals.initializePostMachineSchedulerPass(Registry);
  IrLlvmGlobals.initializePostRAHazardRecognizerPass(Registry);
  IrLlvmGlobals.initializePostRASchedulerPass(Registry);
  IrLlvmGlobals.initializePreISelIntrinsicLoweringLegacyPassPass(Registry);
  IrLlvmGlobals.initializeProcessImplicitDefsPass(Registry);
  IrLlvmGlobals.initializeRegisterCoalescerPass(Registry);
  IrLlvmGlobals.initializeRenameIndependentSubregsPass(Registry);
  IrLlvmGlobals.initializeShrinkWrapPass(Registry);
  IrLlvmGlobals.initializeSlotIndexesPass(Registry);
  IrLlvmGlobals.initializeStackColoringPass(Registry);
  IrLlvmGlobals.initializeStackMapLivenessPass(Registry);
  IrLlvmGlobals.initializeLiveDebugValuesPass(Registry);
  IrLlvmGlobals.initializeSafeStackPass(Registry);
  IrLlvmGlobals.initializeStackProtectorPass(Registry);
  IrLlvmGlobals.initializeStackSlotColoringPass(Registry);
  IrLlvmGlobals.initializeTailDuplicatePassPass(Registry);
  IrLlvmGlobals.initializeTargetPassConfigPass(Registry);
  IrLlvmGlobals.initializeTwoAddressInstructionPassPass(Registry);
  IrLlvmGlobals.initializeUnpackMachineBundlesPass(Registry);
  IrLlvmGlobals.initializeUnreachableBlockElimLegacyPassPass(Registry);
  IrLlvmGlobals.initializeUnreachableMachineBlockElimPass(Registry);
  IrLlvmGlobals.initializeVirtRegMapPass(Registry);
  IrLlvmGlobals.initializeVirtRegRewriterPass(Registry);
  IrLlvmGlobals.initializeWinEHPreparePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCodeGenPreparePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/CodeGenPrepare.cpp", line = 207,
 FQN="llvm::initializeCodeGenPreparePass", NM="_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/CodeGenPrepare.cpp -nm=_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCodeGenPreparePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeCodeGenPreparePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantHoistingLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp", line = 87,
 FQN="llvm::initializeConstantHoistingLegacyPassPass", NM="_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp -nm=_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeConstantHoistingLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeConstantHoistingLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantMergeLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp", line = 219,
 FQN="llvm::initializeConstantMergeLegacyPassPass", NM="_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp -nm=_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeConstantMergeLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeConstantMergeLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantPropagationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp", line = 57,
 FQN="llvm::initializeConstantPropagationPass", NM="_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeConstantPropagationPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeConstantPropagationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCorrelatedValuePropagationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp", line = 63,
 FQN="llvm::initializeCorrelatedValuePropagationPass", NM="_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp -nm=_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCorrelatedValuePropagationPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeCorrelatedValuePropagationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCostModelAnalysisPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 72,
 FQN="llvm::initializeCostModelAnalysisPass", NM="_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCostModelAnalysisPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeCostModelAnalysisPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCrossDSOCFIPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp", line = 61,
 FQN="llvm::initializeCrossDSOCFIPass", NM="_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp -nm=_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCrossDSOCFIPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeCrossDSOCFIPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDCELegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp", line = 156,
 FQN="llvm::initializeDCELegacyPassPass", NM="_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDCELegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeDCELegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadInstEliminationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp", line = 68,
 FQN="llvm::initializeDeadInstEliminationPass", NM="_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDeadInstEliminationPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeDeadInstEliminationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDataFlowSanitizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp", line = 359,
 FQN="llvm::initializeDataFlowSanitizerPass", NM="_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp -nm=_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDataFlowSanitizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeDataFlowSanitizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDAEPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp", line = 78,
 FQN="llvm::initializeDAEPass", NM="_ZN4llvm17initializeDAEPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp -nm=_ZN4llvm17initializeDAEPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDAEPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeDAEPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDAHPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp", line = 93,
 FQN="llvm::initializeDAHPass", NM="_ZN4llvm17initializeDAHPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp -nm=_ZN4llvm17initializeDAHPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDAHPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeDAHPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadMachineInstructionElimPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/DeadMachineInstructionElim.cpp", line = 57,
 FQN="llvm::initializeDeadMachineInstructionElimPass", NM="_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/DeadMachineInstructionElim.cpp -nm=_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDeadMachineInstructionElimPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeDeadMachineInstructionElimPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDSELegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp", line = 1098,
 FQN="llvm::initializeDSELegacyPassPass", NM="_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp -nm=_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDSELegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeDSELegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDelinearizationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp", line = 138,
 FQN="llvm::initializeDelinearizationPass", NM="_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp -nm=_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDelinearizationPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDelinearizationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDemandedBitsWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 50,
 FQN="llvm::initializeDemandedBitsWrapperPassPass", NM="_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDemandedBitsWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDemandedBitsWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDependenceAnalysisWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 132,
 FQN="llvm::initializeDependenceAnalysisWrapperPassPass", NM="_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDependenceAnalysisWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDependenceAnalysisWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDetectDeadLanesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/DetectDeadLanes.cpp", line = 135,
 FQN="llvm::initializeDetectDeadLanesPass", NM="_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/DetectDeadLanes.cpp -nm=_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDetectDeadLanesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeDetectDeadLanesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDivergenceAnalysisPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 272,
 FQN="llvm::initializeDivergenceAnalysisPass", NM="_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDivergenceAnalysisPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDivergenceAnalysisPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 232,
 FQN="llvm::initializeDomOnlyPrinterPass", NM="_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDomOnlyPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 154,
 FQN="llvm::initializeDomOnlyViewerPass", NM="_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDomOnlyViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 227,
 FQN="llvm::initializeDomPrinterPass", NM="_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDomPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 150,
 FQN="llvm::initializeDomViewerPass", NM="_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDomViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 243,
 FQN="llvm::initializePostDomOnlyPrinterPass", NM="_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializePostDomOnlyPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 163,
 FQN="llvm::initializePostDomOnlyViewerPass", NM="_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializePostDomOnlyViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 238,
 FQN="llvm::initializePostDomPrinterPass", NM="_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializePostDomPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 159,
 FQN="llvm::initializePostDomViewerPass", NM="_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializePostDomViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDominanceFrontierWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 26,
 FQN="llvm::initializeDominanceFrontierWrapperPassPass", NM="_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDominanceFrontierWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeDominanceFrontierWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDwarfEHPreparePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/DwarfEHPrepare.cpp", line = 85,
 FQN="llvm::initializeDwarfEHPreparePass", NM="_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/DwarfEHPrepare.cpp -nm=_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDwarfEHPreparePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeDwarfEHPreparePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyCSELegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp", line = 920,
 FQN="llvm::initializeEarlyCSELegacyPassPass", NM="_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEarlyCSELegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeEarlyCSELegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyIfConverterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/EarlyIfConversion.cpp", line = 624,
 FQN="llvm::initializeEarlyIfConverterPass", NM="_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/EarlyIfConversion.cpp -nm=_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEarlyIfConverterPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeEarlyIfConverterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEdgeBundlesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/EdgeBundles.cpp", line = 29,
 FQN="llvm::initializeEdgeBundlesPass", NM="_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/EdgeBundles.cpp -nm=_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEdgeBundlesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeEdgeBundlesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEfficiencySanitizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp", line = 230,
 FQN="llvm::initializeEfficiencySanitizerPass", NM="_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp -nm=_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEfficiencySanitizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeEfficiencySanitizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeEliminateAvailableExternallyLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp", line = 91,
 FQN="llvm::initializeEliminateAvailableExternallyLegacyPassPass", NM="_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp -nm=_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeEliminateAvailableExternallyLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeEliminateAvailableExternallyLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExpandISelPseudosPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/ExpandISelPseudos.cpp", line = 44,
 FQN="llvm::initializeExpandISelPseudosPass", NM="_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ExpandISelPseudos.cpp -nm=_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExpandISelPseudosPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeExpandISelPseudosPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExpandPostRAPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/ExpandPostRAPseudos.cpp", line = 61,
 FQN="llvm::initializeExpandPostRAPass", NM="_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ExpandPostRAPseudos.cpp -nm=_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExpandPostRAPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeExpandPostRAPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFlattenCFGPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp", line = 45,
 FQN="llvm::initializeFlattenCFGPassPass", NM="_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp -nm=_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFlattenCFGPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeFlattenCFGPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFloat2IntLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp", line = 78,
 FQN="llvm::initializeFloat2IntLegacyPassPass", NM="_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp -nm=_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFloat2IntLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeFloat2IntLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeForceFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 117,
 FQN="llvm::initializeForceFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeForceFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeForceFunctionAttrsLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFuncletLayoutPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/FuncletLayout.cpp", line = 40,
 FQN="llvm::initializeFuncletLayoutPass", NM="_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/FuncletLayout.cpp -nm=_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFuncletLayoutPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeFuncletLayoutPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostOrderFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp", line = 1066,
 FQN="llvm::initializePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePostOrderFunctionAttrsLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp", line = 1147,
 FQN="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeReversePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeReversePostOrderFunctionAttrsLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFunctionImportPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 787,
 FQN="llvm::initializeFunctionImportPassPass", NM="_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFunctionImportPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeFunctionImportPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGCModuleInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GCMetadata.cpp", line = 43,
 FQN="llvm::initializeGCModuleInfoPass", NM="_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GCMetadata.cpp -nm=_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGCModuleInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeGCModuleInfoPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGCOVProfilerLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp", line = 154,
 FQN="llvm::initializeGCOVProfilerLegacyPassPass", NM="_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGCOVProfilerLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeGCOVProfilerLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGCMachineCodeAnalysisPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp", line = 259,
 FQN="llvm::initializeGCMachineCodeAnalysisPass", NM="_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp -nm=_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGCMachineCodeAnalysisPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeGCMachineCodeAnalysisPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerIntrinsicsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp", line = 86,
 FQN="llvm::initializeLowerIntrinsicsPass", NM="_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp -nm=_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerIntrinsicsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLowerIntrinsicsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp", line = 2754,
 FQN="llvm::initializeGVNLegacyPassPass", NM="_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGVNLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeGVNLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNHoistLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp", line = 822,
 FQN="llvm::initializeGVNHoistLegacyPassPass", NM="_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp -nm=_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGVNHoistLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeGVNHoistLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalDCELegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp", line = 64,
 FQN="llvm::initializeGlobalDCELegacyPassPass", NM="_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp -nm=_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalDCELegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeGlobalDCELegacyPassPass(Registry);
}


/// Initialize all passes linked into the GlobalISel library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalISel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/GlobalISel.cpp", line = 21,
 FQN="llvm::initializeGlobalISel", NM="_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/GlobalISel.cpp -nm=_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalISel(final PassRegistry /*&*/ Registry) {
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalMergePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalMerge.cpp", line = 199,
 FQN="llvm::initializeGlobalMergePass", NM="_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalMerge.cpp -nm=_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalMergePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeGlobalMergePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalOptLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp", line = 2612,
 FQN="llvm::initializeGlobalOptLegacyPassPass", NM="_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp -nm=_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalOptLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeGlobalOptLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalsAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 953,
 FQN="llvm::initializeGlobalsAAWrapperPassPass", NM="_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalsAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeGlobalsAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGuardWideningLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp", line = 686,
 FQN="llvm::initializeGuardWideningLegacyPassPass", NM="_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGuardWideningLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeGuardWideningLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIPCPPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp", line = 253,
 FQN="llvm::initializeIPCPPass", NM="_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp -nm=_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIPCPPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeIPCPPass(Registry);
}


/// Initialize all passes linked into the IPO library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeIPO">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp", line = 25,
 FQN="llvm::initializeIPO", NM="_ZN4llvm13initializeIPOERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp -nm=_ZN4llvm13initializeIPOERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIPO(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeArgPromotionPass(Registry);
  IrLlvmGlobals.initializeConstantMergeLegacyPassPass(Registry);
  IrLlvmGlobals.initializeCrossDSOCFIPass(Registry);
  IrLlvmGlobals.initializeDAEPass(Registry);
  IrLlvmGlobals.initializeDAHPass(Registry);
  IrLlvmGlobals.initializeForceFunctionAttrsLegacyPassPass(Registry);
  IrLlvmGlobals.initializeGlobalDCELegacyPassPass(Registry);
  IrLlvmGlobals.initializeGlobalOptLegacyPassPass(Registry);
  IrLlvmGlobals.initializeIPCPPass(Registry);
  IrLlvmGlobals.initializeAlwaysInlinerPass(Registry);
  IrLlvmGlobals.initializeSimpleInlinerPass(Registry);
  IrLlvmGlobals.initializeInferFunctionAttrsLegacyPassPass(Registry);
  IrLlvmGlobals.initializeInternalizeLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLoopExtractorPass(Registry);
  IrLlvmGlobals.initializeBlockExtractorPassPass(Registry);
  IrLlvmGlobals.initializeSingleLoopExtractorPass(Registry);
  IrLlvmGlobals.initializeLowerTypeTestsPass(Registry);
  IrLlvmGlobals.initializeMergeFunctionsPass(Registry);
  IrLlvmGlobals.initializePartialInlinerLegacyPassPass(Registry);
  IrLlvmGlobals.initializePostOrderFunctionAttrsLegacyPassPass(Registry);
  IrLlvmGlobals.initializeReversePostOrderFunctionAttrsLegacyPassPass(Registry);
  IrLlvmGlobals.initializePruneEHPass(Registry);
  IrLlvmGlobals.initializeStripDeadPrototypesLegacyPassPass(Registry);
  IrLlvmGlobals.initializeStripSymbolsPass(Registry);
  IrLlvmGlobals.initializeStripDebugDeclarePass(Registry);
  IrLlvmGlobals.initializeStripDeadDebugInfoPass(Registry);
  IrLlvmGlobals.initializeStripNonDebugSymbolsPass(Registry);
  IrLlvmGlobals.initializeBarrierNoopPass(Registry);
  IrLlvmGlobals.initializeEliminateAvailableExternallyLegacyPassPass(Registry);
  IrLlvmGlobals.initializeSampleProfileLoaderLegacyPassPass(Registry);
  IrLlvmGlobals.initializeFunctionImportPassPass(Registry);
  IrLlvmGlobals.initializeWholeProgramDevirtPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIRTranslatorPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/IRTranslator.cpp", line = 30,
 FQN="llvm::initializeIRTranslatorPass", NM="_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/IRTranslator.cpp -nm=_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIRTranslatorPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeIRTranslatorPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIVUsersWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 62,
 FQN="llvm::initializeIVUsersWrapperPassPass", NM="_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIVUsersWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeIVUsersWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIfConverterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/IfConversion.cpp", line = 282,
 FQN="llvm::initializeIfConverterPass", NM="_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/IfConversion.cpp -nm=_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIfConverterPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeIfConverterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeImplicitNullChecksPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/ImplicitNullChecks.cpp", line = 575,
 FQN="llvm::initializeImplicitNullChecksPass", NM="_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ImplicitNullChecks.cpp -nm=_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeImplicitNullChecksPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeImplicitNullChecksPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIndVarSimplifyLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp", line = 2283,
 FQN="llvm::initializeIndVarSimplifyLegacyPassPass", NM="_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp -nm=_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIndVarSimplifyLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeIndVarSimplifyLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePGOIndirectCallPromotionLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp", line = 119,
 FQN="llvm::initializePGOIndirectCallPromotionLegacyPassPass", NM="_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePGOIndirectCallPromotionLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePGOIndirectCallPromotionLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInductiveRangeCheckEliminationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp", line = 224,
 FQN="llvm::initializeInductiveRangeCheckEliminationPass", NM="_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp -nm=_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInductiveRangeCheckEliminationPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInductiveRangeCheckEliminationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInferFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp", line = 75,
 FQN="llvm::initializeInferFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp -nm=_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInferFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInferFunctionAttrsLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAlwaysInlinerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 71,
 FQN="llvm::initializeAlwaysInlinerPass", NM="_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAlwaysInlinerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeAlwaysInlinerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSimpleInlinerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp", line = 84,
 FQN="llvm::initializeSimpleInlinerPass", NM="_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp -nm=_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSimpleInlinerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSimpleInlinerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCountPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 70,
 FQN="llvm::initializeInstCountPass", NM="_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstCountPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeInstCountPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrProfilingLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp", line = 77,
 FQN="llvm::initializeInstrProfilingLegacyPassPass", NM="_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp -nm=_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstrProfilingLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInstrProfilingLegacyPassPass(Registry);
}


/// Initialize all passes linked into the InstCombine library.

// Initialization Routines
//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCombine">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp", line = 3213,
 FQN="llvm::initializeInstCombine", NM="_ZN4llvm21initializeInstCombineERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm21initializeInstCombineERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstCombine(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeInstructionCombiningPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstructionCombiningPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp", line = 3209,
 FQN="llvm::initializeInstructionCombiningPassPass", NM="_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstructionCombiningPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInstructionCombiningPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstNamerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp", line = 55,
 FQN="llvm::initializeInstNamerPass", NM="_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp -nm=_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstNamerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInstNamerPass(Registry);
}


/// Initialize all passes linked into the Instrumentation library.

/// initializeInstrumentation - Initialize all passes in the TransformUtils
/// library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrumentation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp", line = 58,
 FQN="llvm::initializeInstrumentation", NM="_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp -nm=_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstrumentation(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeAddressSanitizerPass(Registry);
  IrLlvmGlobals.initializeAddressSanitizerModulePass(Registry);
  IrLlvmGlobals.initializeBoundsCheckingPass(Registry);
  IrLlvmGlobals.initializeGCOVProfilerLegacyPassPass(Registry);
  IrLlvmGlobals.initializePGOInstrumentationGenLegacyPassPass(Registry);
  IrLlvmGlobals.initializePGOInstrumentationUseLegacyPassPass(Registry);
  IrLlvmGlobals.initializePGOIndirectCallPromotionLegacyPassPass(Registry);
  IrLlvmGlobals.initializeInstrProfilingLegacyPassPass(Registry);
  IrLlvmGlobals.initializeMemorySanitizerPass(Registry);
  IrLlvmGlobals.initializeThreadSanitizerPass(Registry);
  IrLlvmGlobals.initializeSanitizerCoverageModulePass(Registry);
  IrLlvmGlobals.initializeDataFlowSanitizerPass(Registry);
  IrLlvmGlobals.initializeEfficiencySanitizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInterleavedAccessPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/InterleavedAccessPass.cpp", line = 110,
 FQN="llvm::initializeInterleavedAccessPass", NM="_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/InterleavedAccessPass.cpp -nm=_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInterleavedAccessPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeInterleavedAccessPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInternalizeLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp", line = 284,
 FQN="llvm::initializeInternalizeLegacyPassPass", NM="_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp -nm=_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInternalizeLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInternalizeLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIntervalPartitionPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 19,
 FQN="llvm::initializeIntervalPartitionPass", NM="_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIntervalPartitionPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeIntervalPartitionPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeJumpThreadingPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp", line = 107,
 FQN="llvm::initializeJumpThreadingPass", NM="_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp -nm=_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeJumpThreadingPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeJumpThreadingPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLCSSAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 342,
 FQN="llvm::initializeLCSSAWrapperPassPass", NM="_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLCSSAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLCSSAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLegacyLICMPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 203,
 FQN="llvm::initializeLegacyLICMPassPass", NM="_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLegacyLICMPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLegacyLICMPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyBlockFrequencyInfoPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 29,
 FQN="llvm::initializeLazyBlockFrequencyInfoPassPass", NM="_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyBlockFrequencyInfoPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeLazyBlockFrequencyInfoPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyValueInfoWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 46,
 FQN="llvm::initializeLazyValueInfoWrapperPassPass", NM="_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyValueInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeLazyValueInfoWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLintPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 171,
 FQN="llvm::initializeLintPass", NM="_ZN4llvm18initializeLintPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm18initializeLintPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLintPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeLintPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveDebugValuesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugValues.cpp", line = 239,
 FQN="llvm::initializeLiveDebugValuesPass", NM="_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugValues.cpp -nm=_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveDebugValuesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLiveDebugValuesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveDebugVariablesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugVariables.cpp", line = 62,
 FQN="llvm::initializeLiveDebugVariablesPass", NM="_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugVariables.cpp -nm=_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveDebugVariablesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLiveDebugVariablesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveIntervalsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveIntervalAnalysis.cpp", line = 50,
 FQN="llvm::initializeLiveIntervalsPass", NM="_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveIntervalAnalysis.cpp -nm=_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveIntervalsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLiveIntervalsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveRegMatrixPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveRegMatrix.cpp", line = 36,
 FQN="llvm::initializeLiveRegMatrixPass", NM="_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveRegMatrix.cpp -nm=_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveRegMatrixPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLiveRegMatrixPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveStacksPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveStackAnalysis.cpp", line = 31,
 FQN="llvm::initializeLiveStacksPass", NM="_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveStackAnalysis.cpp -nm=_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveStacksPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLiveStacksPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveVariablesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveVariables.cpp", line = 49,
 FQN="llvm::initializeLiveVariablesPass", NM="_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveVariables.cpp -nm=_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLiveVariablesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLiveVariablesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadCombinePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp", line = 283,
 FQN="llvm::initializeLoadCombinePass", NM="_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp -nm=_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoadCombinePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoadCombinePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadStoreVectorizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp", line = 171,
 FQN="llvm::initializeLoadStoreVectorizerPass", NM="_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp -nm=_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoadStoreVectorizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoadStoreVectorizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLocalStackSlotPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LocalStackSlotAllocation.cpp", line = 100,
 FQN="llvm::initializeLocalStackSlotPassPass", NM="_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LocalStackSlotAllocation.cpp -nm=_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLocalStackSlotPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLocalStackSlotPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopAccessLegacyAnalysisPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 2021,
 FQN="llvm::initializeLoopAccessLegacyAnalysisPass", NM="_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopAccessLegacyAnalysisPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeLoopAccessLegacyAnalysisPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDataPrefetchPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp", line = 129,
 FQN="llvm::initializeLoopDataPrefetchPass", NM="_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp -nm=_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopDataPrefetchPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopDataPrefetchPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDeletionLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp", line = 254,
 FQN="llvm::initializeLoopDeletionLegacyPassPass", NM="_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopDeletionLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopDeletionLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDistributeLegacyPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp", line = 984,
 FQN="llvm::initializeLoopDistributeLegacyPass", NM="_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp -nm=_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopDistributeLegacyPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopDistributeLegacyPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockExtractorPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 191,
 FQN="llvm::initializeBlockExtractorPassPass", NM="_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBlockExtractorPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeBlockExtractorPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopExtractorPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 63,
 FQN="llvm::initializeLoopExtractorPass", NM="_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopExtractorPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopExtractorPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSingleLoopExtractorPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 75,
 FQN="llvm::initializeSingleLoopExtractorPass", NM="_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSingleLoopExtractorPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSingleLoopExtractorPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopIdiomRecognizeLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp", line = 204,
 FQN="llvm::initializeLoopIdiomRecognizeLegacyPassPass", NM="_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp -nm=_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopIdiomRecognizeLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopIdiomRecognizeLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 690,
 FQN="llvm::initializeLoopInfoWrapperPassPass", NM="_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInstSimplifyLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp", line = 211,
 FQN="llvm::initializeLoopInstSimplifyLegacyPassPass", NM="_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp -nm=_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInstSimplifyLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopInstSimplifyLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInterchangePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp", line = 1277,
 FQN="llvm::initializeLoopInterchangePass", NM="_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp -nm=_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInterchangePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopInterchangePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopLoadEliminationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp", line = 599,
 FQN="llvm::initializeLoopLoadEliminationPass", NM="_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp -nm=_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopLoadEliminationPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopLoadEliminationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRerollPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp", line = 454,
 FQN="llvm::initializeLoopRerollPass", NM="_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp -nm=_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopRerollPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopRerollPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRotateLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp", line = 688,
 FQN="llvm::initializeLoopRotateLegacyPassPass", NM="_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp -nm=_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopRotateLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopRotateLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp", line = 800,
 FQN="llvm::initializeLoopSimplifyPass", NM="_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp -nm=_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopSimplifyPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopSimplifyPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyCFGLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp", line = 109,
 FQN="llvm::initializeLoopSimplifyCFGLegacyPassPass", NM="_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp -nm=_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopSimplifyCFGLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopSimplifyCFGLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopStrengthReducePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp", line = 4956,
 FQN="llvm::initializeLoopStrengthReducePass", NM="_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp -nm=_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopStrengthReducePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopStrengthReducePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnrollPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp", line = 1040,
 FQN="llvm::initializeLoopUnrollPass", NM="_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopUnrollPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopUnrollPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnswitchPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp", line = 384,
 FQN="llvm::initializeLoopUnswitchPass", NM="_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp -nm=_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopUnswitchPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopUnswitchPass(Registry);
}


/// Manually defined generic "LoopPass" dependency initialization. This is used
/// to initialize the exact set of passes from above in \c
/// getLoopAnalysisUsage. It can be used within a loop pass's initialization
/// with:
///
///   INITIALIZE_PASS_DEPENDENCY(LoopPass)
///
/// As-if "LoopPass" were a pass.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopPassPass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp", line = 879,
 FQN="llvm::initializeLoopPassPass", NM="_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopPassPass(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeDominatorTreeWrapperPassPass(Registry);
  IrLlvmGlobals.initializeLoopInfoWrapperPassPass(Registry);
  IrLlvmGlobals.initializeLoopSimplifyPass(Registry);
  IrLlvmGlobals.initializeLCSSAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeAAResultsWrapperPassPass(Registry);
  IrLlvmGlobals.initializeBasicAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeGlobalsAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeSCEVAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeScalarEvolutionWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVectorizePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp", line = 6220,
 FQN="llvm::initializeLoopVectorizePass", NM="_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp -nm=_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopVectorizePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopVectorizePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp", line = 317,
 FQN="llvm::initializeLoopVersioningPassPass", NM="_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp -nm=_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopVersioningPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopVersioningPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningLICMPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp", line = 568,
 FQN="llvm::initializeLoopVersioningLICMPass", NM="_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp -nm=_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopVersioningLICMPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLoopVersioningLICMPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerAtomicLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp", line = 171,
 FQN="llvm::initializeLowerAtomicLegacyPassPass", NM="_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp -nm=_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerAtomicLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLowerAtomicLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerEmuTLSPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/LowerEmuTLS.cpp", line = 57,
 FQN="llvm::initializeLowerEmuTLSPass", NM="_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LowerEmuTLS.cpp -nm=_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerEmuTLSPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeLowerEmuTLSPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerExpectIntrinsicPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp", line = 200,
 FQN="llvm::initializeLowerExpectIntrinsicPass", NM="_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp -nm=_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerExpectIntrinsicPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLowerExpectIntrinsicPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerGuardIntrinsicPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp", line = 117,
 FQN="llvm::initializeLowerGuardIntrinsicPass", NM="_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp -nm=_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerGuardIntrinsicPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLowerGuardIntrinsicPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerInvokePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp", line = 42,
 FQN="llvm::initializeLowerInvokePass", NM="_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp -nm=_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerInvokePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLowerInvokePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerSwitchPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp", line = 100,
 FQN="llvm::initializeLowerSwitchPass", NM="_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp -nm=_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerSwitchPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLowerSwitchPass(Registry);
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerTypeTestsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp", line = 261,
 FQN="llvm::initializeLowerTypeTestsPass", NM="_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp -nm=_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLowerTypeTestsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeLowerTypeTestsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMIRPrintingPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MIRPrintingPass.cpp", line = 63,
 FQN="llvm::initializeMIRPrintingPassPass", NM="_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MIRPrintingPass.cpp -nm=_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMIRPrintingPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMIRPrintingPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockFrequencyInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockFrequencyInfo.cpp", line = 116,
 FQN="llvm::initializeMachineBlockFrequencyInfoPass", NM="_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockFrequencyInfo.cpp -nm=_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBlockFrequencyInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineBlockFrequencyInfoPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockPlacementPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp", line = 365,
 FQN="llvm::initializeMachineBlockPlacementPass", NM="_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp -nm=_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBlockPlacementPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineBlockPlacementPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockPlacementStatsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp", line = 1766,
 FQN="llvm::initializeMachineBlockPlacementStatsPass", NM="_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp -nm=_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBlockPlacementStatsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineBlockPlacementStatsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBranchProbabilityInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBranchProbabilityInfo.cpp", line = 24,
 FQN="llvm::initializeMachineBranchProbabilityInfoPass", NM="_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBranchProbabilityInfo.cpp -nm=_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineBranchProbabilityInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineBranchProbabilityInfoPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCSEPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp", line = 115,
 FQN="llvm::initializeMachineCSEPass", NM="_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineCSEPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineCSEPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCombinerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineCombiner.cpp", line = 92,
 FQN="llvm::initializeMachineCombinerPass", NM="_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCombiner.cpp -nm=_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineCombinerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineCombinerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCopyPropagationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineCopyPropagation.cpp", line = 81,
 FQN="llvm::initializeMachineCopyPropagationPass", NM="_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCopyPropagation.cpp -nm=_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineCopyPropagationPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineCopyPropagationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineDominanceFrontierPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineDominanceFrontier.cpp", line = 29,
 FQN="llvm::initializeMachineDominanceFrontierPass", NM="_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineDominanceFrontier.cpp -nm=_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineDominanceFrontierPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineDominanceFrontierPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineDominatorTreePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineDominators.cpp", line = 39,
 FQN="llvm::initializeMachineDominatorTreePass", NM="_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineDominators.cpp -nm=_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineDominatorTreePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineDominatorTreePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineFunctionPrinterPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineFunctionPrinterPass.cpp", line = 57,
 FQN="llvm::initializeMachineFunctionPrinterPassPass", NM="_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineFunctionPrinterPass.cpp -nm=_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineFunctionPrinterPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineFunctionPrinterPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeFinalizeMachineBundlesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp", line = 99,
 FQN="llvm::initializeFinalizeMachineBundlesPass", NM="_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp -nm=_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeFinalizeMachineBundlesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeFinalizeMachineBundlesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnpackMachineBundlesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp", line = 41,
 FQN="llvm::initializeUnpackMachineBundlesPass", NM="_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp -nm=_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnpackMachineBundlesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeUnpackMachineBundlesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineLICMPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineLICM.cpp", line = 246,
 FQN="llvm::initializeMachineLICMPass", NM="_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineLICM.cpp -nm=_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineLICMPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineLICMPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineLoopInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineLoopInfo.cpp", line = 33,
 FQN="llvm::initializeMachineLoopInfoPass", NM="_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineLoopInfo.cpp -nm=_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineLoopInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineLoopInfoPass(Registry);
}


// Handle the Pass registration stuff necessary to use DataLayout's.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineModuleInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineModuleInfo.cpp", line = 30,
 FQN="llvm::initializeMachineModuleInfoPass", NM="_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineModuleInfo.cpp -nm=_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineModuleInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineModuleInfoPass(Registry);
}


//declare initializeMachinePostDominatorTreePass
//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachinePostDominatorTreePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachinePostDominators.cpp", line = 22,
 FQN="llvm::initializeMachinePostDominatorTreePass", NM="_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachinePostDominators.cpp -nm=_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachinePostDominatorTreePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachinePostDominatorTreePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineRegionInfoPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineRegionInfo.cpp", line = 128,
 FQN="llvm::initializeMachineRegionInfoPassPass", NM="_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineRegionInfo.cpp -nm=_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineRegionInfoPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineRegionInfoPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineSchedulerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp", line = 163,
 FQN="llvm::initializeMachineSchedulerPass", NM="_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp -nm=_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineSchedulerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineSchedulerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostMachineSchedulerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp", line = 188,
 FQN="llvm::initializePostMachineSchedulerPass", NM="_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp -nm=_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostMachineSchedulerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePostMachineSchedulerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineSinkingPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineSink.cpp", line = 155,
 FQN="llvm::initializeMachineSinkingPass", NM="_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineSink.cpp -nm=_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineSinkingPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineSinkingPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineTraceMetricsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineTraceMetrics.cpp", line = 37,
 FQN="llvm::initializeMachineTraceMetricsPass", NM="_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineTraceMetrics.cpp -nm=_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineTraceMetricsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineTraceMetricsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineVerifierPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineVerifier.cpp", line = 282,
 FQN="llvm::initializeMachineVerifierPassPass", NM="_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineVerifier.cpp -nm=_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMachineVerifierPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeMachineVerifierPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePromoteLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp", line = 100,
 FQN="llvm::initializePromoteLegacyPassPass", NM="_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp -nm=_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePromoteLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePromoteLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemCpyOptLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp", line = 356,
 FQN="llvm::initializeMemCpyOptLegacyPassPass", NM="_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp -nm=_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemCpyOptLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMemCpyOptLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDepPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 83,
 FQN="llvm::initializeMemDepPrinterPass", NM="_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemDepPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeMemDepPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDerefPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp", line = 47,
 FQN="llvm::initializeMemDerefPrinterPass", NM="_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp -nm=_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemDerefPrinterPass(final PassRegistry /*&*/ Registry) {
   LllvmAnalysisPassInitializer$$.PROVIDER.initializeMemDerefPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemoryDependenceWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1681,
 FQN="llvm::initializeMemoryDependenceWrapperPassPass", NM="_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemoryDependenceWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeMemoryDependenceWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp", line = 54,
 FQN="llvm::initializeMemorySSAWrapperPassPass", NM="_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemorySSAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMemorySSAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAPrinterLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp", line = 60,
 FQN="llvm::initializeMemorySSAPrinterLegacyPassPass", NM="_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemorySSAPrinterLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMemorySSAPrinterLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySanitizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp", line = 394,
 FQN="llvm::initializeMemorySanitizerPass", NM="_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp -nm=_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemorySanitizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMemorySanitizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMergeFunctionsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp", line = 1460,
 FQN="llvm::initializeMergeFunctionsPass", NM="_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp -nm=_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMergeFunctionsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMergeFunctionsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMergedLoadStoreMotionLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp", line = 589,
 FQN="llvm::initializeMergedLoadStoreMotionLegacyPassPass", NM="_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp -nm=_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMergedLoadStoreMotionLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMergedLoadStoreMotionLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMetaRenamerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp", line = 142,
 FQN="llvm::initializeMetaRenamerPass", NM="_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp -nm=_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMetaRenamerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeMetaRenamerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleDebugInfoPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp", line = 46,
 FQN="llvm::initializeModuleDebugInfoPrinterPass", NM="_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp -nm=_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeModuleDebugInfoPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeModuleDebugInfoPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleSummaryIndexWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 181,
 FQN="llvm::initializeModuleSummaryIndexWrapperPassPass", NM="_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeModuleSummaryIndexWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeModuleSummaryIndexWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeNameAnonFunctionPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp", line = 97,
 FQN="llvm::initializeNameAnonFunctionPass", NM="_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp -nm=_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeNameAnonFunctionPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeNameAnonFunctionPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeNaryReassociatePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp", line = 203,
 FQN="llvm::initializeNaryReassociatePass", NM="_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp -nm=_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeNaryReassociatePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeNaryReassociatePass(Registry);
}


/// Initialize all passes linked into the ObjCARCOpts library.

/// initializeObjCARCOptsPasses - Initialize all passes linked into the
/// ObjCARCOpts library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp", line = 30,
 FQN="llvm::initializeObjCARCOpts", NM="_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp -nm=_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCOpts(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeObjCARCAAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeObjCARCAPElimPass(Registry);
  IrLlvmGlobals.initializeObjCARCExpandPass(Registry);
  IrLlvmGlobals.initializeObjCARCContractPass(Registry);
  IrLlvmGlobals.initializeObjCARCOptPass(Registry);
  IrLlvmGlobals.initializePAEvalPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAPElimPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp", line = 56,
 FQN="llvm::initializeObjCARCAPElimPass", NM="_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp -nm=_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCAPElimPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeObjCARCAPElimPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 139,
 FQN="llvm::initializeObjCARCAAWrapperPassPass", NM="_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeObjCARCAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCContractPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp", line = 635,
 FQN="llvm::initializeObjCARCContractPass", NM="_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp -nm=_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCContractPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeObjCARCContractPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCExpandPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp", line = 68,
 FQN="llvm::initializeObjCARCExpandPass", NM="_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp -nm=_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCExpandPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeObjCARCExpandPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOptPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp", line = 560,
 FQN="llvm::initializeObjCARCOptPass", NM="_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp -nm=_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCOptPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeObjCARCOptPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizationRemarkEmitterWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp", line = 87,
 FQN="llvm::initializeOptimizationRemarkEmitterWrapperPassPass", NM="_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeOptimizationRemarkEmitterWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeOptimizationRemarkEmitterWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizePHIsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/OptimizePHIs.cpp", line = 62,
 FQN="llvm::initializeOptimizePHIsPass", NM="_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/OptimizePHIs.cpp -nm=_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeOptimizePHIsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeOptimizePHIsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationGenLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp", line = 179,
 FQN="llvm::initializePGOInstrumentationGenLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp -nm=_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePGOInstrumentationGenLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePGOInstrumentationGenLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationUseLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp", line = 191,
 FQN="llvm::initializePGOInstrumentationUseLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp -nm=_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePGOInstrumentationUseLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePGOInstrumentationUseLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePHIEliminationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PHIElimination.cpp", line = 119,
 FQN="llvm::initializePHIEliminationPass", NM="_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PHIElimination.cpp -nm=_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePHIEliminationPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePHIEliminationPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePartialInlinerLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp", line = 52,
 FQN="llvm::initializePartialInlinerLegacyPassPass", NM="_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp -nm=_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePartialInlinerLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePartialInlinerLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePartiallyInlineLibCallsLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp", line = 170,
 FQN="llvm::initializePartiallyInlineLibCallsLegacyPassPass", NM="_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp -nm=_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePartiallyInlineLibCallsLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePartiallyInlineLibCallsLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePatchableFunctionPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PatchableFunction.cpp", line = 87,
 FQN="llvm::initializePatchableFunctionPass", NM="_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PatchableFunction.cpp -nm=_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePatchableFunctionPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePatchableFunctionPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePeepholeOptimizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PeepholeOptimizer.cpp", line = 400,
 FQN="llvm::initializePeepholeOptimizerPass", NM="_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PeepholeOptimizer.cpp -nm=_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePeepholeOptimizerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePeepholeOptimizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceBackedgeSafepointsImplPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp", line = 602,
 FQN="llvm::initializePlaceBackedgeSafepointsImplPass", NM="_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp -nm=_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePlaceBackedgeSafepointsImplPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePlaceBackedgeSafepointsImplPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceSafepointsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp", line = 608,
 FQN="llvm::initializePlaceSafepointsPass", NM="_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp -nm=_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePlaceSafepointsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePlaceSafepointsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDominatorTreeWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp", line = 31,
 FQN="llvm::initializePostDominatorTreeWrapperPassPass", NM="_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp -nm=_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDominatorTreeWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializePostDominatorTreeWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostRAHazardRecognizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PostRAHazardRecognizer.cpp", line = 66,
 FQN="llvm::initializePostRAHazardRecognizerPass", NM="_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PostRAHazardRecognizer.cpp -nm=_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostRAHazardRecognizerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePostRAHazardRecognizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostRASchedulerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PostRASchedulerList.cpp", line = 203,
 FQN="llvm::initializePostRASchedulerPass", NM="_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PostRASchedulerList.cpp -nm=_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostRASchedulerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePostRASchedulerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePreISelIntrinsicLoweringLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PreISelIntrinsicLowering.cpp", line = 78,
 FQN="llvm::initializePreISelIntrinsicLoweringLegacyPassPass", NM="_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PreISelIntrinsicLowering.cpp -nm=_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePreISelIntrinsicLoweringLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePreISelIntrinsicLoweringLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeProcessImplicitDefsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/ProcessImplicitDefs.cpp", line = 56,
 FQN="llvm::initializeProcessImplicitDefsPass", NM="_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ProcessImplicitDefs.cpp -nm=_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeProcessImplicitDefsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeProcessImplicitDefsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeProfileSummaryInfoWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 134,
 FQN="llvm::initializeProfileSummaryInfoWrapperPassPass", NM="_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeProfileSummaryInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeProfileSummaryInfoWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePEIPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/PrologEpilogInserter.cpp", line = 144,
 FQN="llvm::initializePEIPass", NM="_ZN4llvm17initializePEIPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PrologEpilogInserter.cpp -nm=_ZN4llvm17initializePEIPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePEIPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePEIPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePAEvalPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ProvenanceAnalysisEvaluator.cpp", line = 93,
 FQN="llvm::initializePAEvalPass", NM="_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ProvenanceAnalysisEvaluator.cpp -nm=_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePAEvalPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePAEvalPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePruneEHPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp", line = 59,
 FQN="llvm::initializePruneEHPass", NM="_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp -nm=_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePruneEHPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializePruneEHPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeReassociateLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp", line = 2254,
 FQN="llvm::initializeReassociateLegacyPassPass", NM="_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp -nm=_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeReassociateLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeReassociateLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegToMemPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp", line = 67,
 FQN="llvm::initializeRegToMemPass", NM="_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp -nm=_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegToMemPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeRegToMemPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegBankSelectPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/RegBankSelect.cpp", line = 43,
 FQN="llvm::initializeRegBankSelectPass", NM="_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/RegBankSelect.cpp -nm=_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegBankSelectPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeRegBankSelectPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionInfoPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 168,
 FQN="llvm::initializeRegionInfoPassPass", NM="_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionInfoPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeRegionInfoPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 204,
 FQN="llvm::initializeRegionOnlyPrinterPass", NM="_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeRegionOnlyPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 212,
 FQN="llvm::initializeRegionOnlyViewerPass", NM="_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeRegionOnlyViewerPass(Registry);
}

//end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionPrinterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 201,
 FQN="llvm::initializeRegionPrinterPass", NM="_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionPrinterPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeRegionPrinterPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionViewerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 209,
 FQN="llvm::initializeRegionViewerPass", NM="_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionViewerPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeRegionViewerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegisterCoalescerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/RegisterCoalescer.cpp", line = 273,
 FQN="llvm::initializeRegisterCoalescerPass", NM="_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/RegisterCoalescer.cpp -nm=_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegisterCoalescerPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeRegisterCoalescerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePhysicalRegisterUsageInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/RegisterUsageInfo.cpp", line = 29,
 FQN="llvm::initializePhysicalRegisterUsageInfoPass", NM="_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/RegisterUsageInfo.cpp -nm=_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePhysicalRegisterUsageInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializePhysicalRegisterUsageInfoPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRenameIndependentSubregsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/RenameIndependentSubregs.cpp", line = 119,
 FQN="llvm::initializeRenameIndependentSubregsPass", NM="_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/RenameIndependentSubregs.cpp -nm=_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRenameIndependentSubregsPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeRenameIndependentSubregsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteStatepointsForGCPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp", line = 135,
 FQN="llvm::initializeRewriteStatepointsForGCPass", NM="_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp -nm=_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRewriteStatepointsForGCPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeRewriteStatepointsForGCPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIPSCCPLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp", line = 1941,
 FQN="llvm::initializeIPSCCPLegacyPassPass", NM="_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp -nm=_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIPSCCPLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeIPSCCPLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSCCPLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp", line = 1648,
 FQN="llvm::initializeSCCPLegacyPassPass", NM="_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp -nm=_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSCCPLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSCCPLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSLPVectorizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp", line = 4709,
 FQN="llvm::initializeSLPVectorizerPass", NM="_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSLPVectorizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSLPVectorizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSROALegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp", line = 4295,
 FQN="llvm::initializeSROALegacyPassPass", NM="_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSROALegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSROALegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSafeStackPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/SafeStack.cpp", line = 846,
 FQN="llvm::initializeSafeStackPass", NM="_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SafeStack.cpp -nm=_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSafeStackPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeSafeStackPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSampleProfileLoaderLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp", line = 1197,
 FQN="llvm::initializeSampleProfileLoaderLegacyPassPass", NM="_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp -nm=_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSampleProfileLoaderLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSampleProfileLoaderLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSanitizerCoverageModulePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp", line = 590,
 FQN="llvm::initializeSanitizerCoverageModulePass", NM="_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSanitizerCoverageModulePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSanitizerCoverageModulePass(Registry);
}


/// Initialize all passes linked into the ScalarOpts library.

/// initializeScalarOptsPasses - Initialize all passes linked into the
/// ScalarOpts library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarOpts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp", line = 33,
 FQN="llvm::initializeScalarOpts", NM="_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp -nm=_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarOpts(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeADCELegacyPassPass(Registry);
  IrLlvmGlobals.initializeBDCELegacyPassPass(Registry);
  IrLlvmGlobals.initializeAlignmentFromAssumptionsPass(Registry);
  IrLlvmGlobals.initializeConstantHoistingLegacyPassPass(Registry);
  IrLlvmGlobals.initializeConstantPropagationPass(Registry);
  IrLlvmGlobals.initializeCorrelatedValuePropagationPass(Registry);
  IrLlvmGlobals.initializeDCELegacyPassPass(Registry);
  IrLlvmGlobals.initializeDeadInstEliminationPass(Registry);
  IrLlvmGlobals.initializeScalarizerPass(Registry);
  IrLlvmGlobals.initializeDSELegacyPassPass(Registry);
  IrLlvmGlobals.initializeGuardWideningLegacyPassPass(Registry);
  IrLlvmGlobals.initializeGVNLegacyPassPass(Registry);
  IrLlvmGlobals.initializeEarlyCSELegacyPassPass(Registry);
  IrLlvmGlobals.initializeGVNHoistLegacyPassPass(Registry);
  IrLlvmGlobals.initializeFlattenCFGPassPass(Registry);
  IrLlvmGlobals.initializeInductiveRangeCheckEliminationPass(Registry);
  IrLlvmGlobals.initializeIndVarSimplifyLegacyPassPass(Registry);
  IrLlvmGlobals.initializeJumpThreadingPass(Registry);
  IrLlvmGlobals.initializeLegacyLICMPassPass(Registry);
  IrLlvmGlobals.initializeLoopDataPrefetchPass(Registry);
  IrLlvmGlobals.initializeLoopDeletionLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLoopAccessLegacyAnalysisPass(Registry);
  IrLlvmGlobals.initializeLoopInstSimplifyLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLoopInterchangePass(Registry);
  IrLlvmGlobals.initializeLoopRotateLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLoopStrengthReducePass(Registry);
  IrLlvmGlobals.initializeLoopRerollPass(Registry);
  IrLlvmGlobals.initializeLoopUnrollPass(Registry);
  IrLlvmGlobals.initializeLoopUnswitchPass(Registry);
  IrLlvmGlobals.initializeLoopVersioningLICMPass(Registry);
  IrLlvmGlobals.initializeLoopIdiomRecognizeLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLowerAtomicLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLowerExpectIntrinsicPass(Registry);
  IrLlvmGlobals.initializeLowerGuardIntrinsicPass(Registry);
  IrLlvmGlobals.initializeMemCpyOptLegacyPassPass(Registry);
  IrLlvmGlobals.initializeMergedLoadStoreMotionLegacyPassPass(Registry);
  IrLlvmGlobals.initializeNaryReassociatePass(Registry);
  IrLlvmGlobals.initializePartiallyInlineLibCallsLegacyPassPass(Registry);
  IrLlvmGlobals.initializeReassociateLegacyPassPass(Registry);
  IrLlvmGlobals.initializeRegToMemPass(Registry);
  IrLlvmGlobals.initializeRewriteStatepointsForGCPass(Registry);
  IrLlvmGlobals.initializeSCCPLegacyPassPass(Registry);
  IrLlvmGlobals.initializeIPSCCPLegacyPassPass(Registry);
  IrLlvmGlobals.initializeSROALegacyPassPass(Registry);
  IrLlvmGlobals.initializeCFGSimplifyPassPass(Registry);
  IrLlvmGlobals.initializeStructurizeCFGPass(Registry);
  IrLlvmGlobals.initializeSinkingLegacyPassPass(Registry);
  IrLlvmGlobals.initializeTailCallElimPass(Registry);
  IrLlvmGlobals.initializeSeparateConstOffsetFromGEPPass(Registry);
  IrLlvmGlobals.initializeSpeculativeExecutionPass(Registry);
  IrLlvmGlobals.initializeStraightLineStrengthReducePass(Registry);
  IrLlvmGlobals.initializeLoadCombinePass(Registry);
  IrLlvmGlobals.initializePlaceBackedgeSafepointsImplPass(Registry);
  IrLlvmGlobals.initializePlaceSafepointsPass(Registry);
  IrLlvmGlobals.initializeFloat2IntLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLoopDistributeLegacyPass(Registry);
  IrLlvmGlobals.initializeLoopLoadEliminationPass(Registry);
  IrLlvmGlobals.initializeLoopSimplifyCFGLegacyPassPass(Registry);
  IrLlvmGlobals.initializeLoopVersioningPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarEvolutionWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10033,
 FQN="llvm::initializeScalarEvolutionWrapperPassPass", NM="_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarEvolutionWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeScalarEvolutionWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSCEVAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp", line = 123,
 FQN="llvm::initializeSCEVAAWrapperPassPass", NM="_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp -nm=_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSCEVAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeSCEVAAWrapperPassPass(Registry);
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp", line = 181,
 FQN="llvm::initializeScalarizerPass", NM="_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp -nm=_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeScalarizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScopedNoAliasAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 183,
 FQN="llvm::initializeScopedNoAliasAAWrapperPassPass", NM="_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScopedNoAliasAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeScopedNoAliasAAWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSeparateConstOffsetFromGEPPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp", line = 434,
 FQN="llvm::initializeSeparateConstOffsetFromGEPPass", NM="_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp -nm=_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSeparateConstOffsetFromGEPPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSeparateConstOffsetFromGEPPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeShadowStackGCLoweringPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/ShadowStackGCLowering.cpp", line = 71,
 FQN="llvm::initializeShadowStackGCLoweringPass", NM="_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ShadowStackGCLowering.cpp -nm=_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeShadowStackGCLoweringPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeShadowStackGCLoweringPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeShrinkWrapPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/ShrinkWrap.cpp", line = 221,
 FQN="llvm::initializeShrinkWrapPass", NM="_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ShrinkWrap.cpp -nm=_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeShrinkWrapPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeShrinkWrapPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGSimplifyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp", line = 237,
 FQN="llvm::initializeCFGSimplifyPassPass", NM="_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp -nm=_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGSimplifyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeCFGSimplifyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstSimplifierPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp", line = 119,
 FQN="llvm::initializeInstSimplifierPass", NM="_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp -nm=_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstSimplifierPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeInstSimplifierPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSinkingLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp", line = 304,
 FQN="llvm::initializeSinkingLegacyPassPass", NM="_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp -nm=_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSinkingLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSinkingLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSjLjEHPreparePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/SjLjEHPrepare.cpp", line = 76,
 FQN="llvm::initializeSjLjEHPreparePass", NM="_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SjLjEHPrepare.cpp -nm=_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSjLjEHPreparePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeSjLjEHPreparePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSlotIndexesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/SlotIndexes.cpp", line = 22,
 FQN="llvm::initializeSlotIndexesPass", NM="_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SlotIndexes.cpp -nm=_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSlotIndexesPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeSlotIndexesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSpeculativeExecutionPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp", line = 137,
 FQN="llvm::initializeSpeculativeExecutionPass", NM="_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp -nm=_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSpeculativeExecutionPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeSpeculativeExecutionPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSpillPlacementPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/SpillPlacement.cpp", line = 50,
 FQN="llvm::initializeSpillPlacementPass", NM="_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SpillPlacement.cpp -nm=_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSpillPlacementPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeSpillPlacementPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackColoringPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/StackColoring.cpp", line = 379,
 FQN="llvm::initializeStackColoringPass", NM="_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackColoring.cpp -nm=_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackColoringPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeStackColoringPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackMapLivenessPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/StackMapLivenessAnalysis.cpp", line = 88,
 FQN="llvm::initializeStackMapLivenessPass", NM="_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackMapLivenessAnalysis.cpp -nm=_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackMapLivenessPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeStackMapLivenessPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackProtectorPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/StackProtector.cpp", line = 53,
 FQN="llvm::initializeStackProtectorPass", NM="_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackProtector.cpp -nm=_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackProtectorPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeStackProtectorPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStackSlotColoringPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/StackSlotColoring.cpp", line = 124,
 FQN="llvm::initializeStackSlotColoringPass", NM="_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackSlotColoring.cpp -nm=_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStackSlotColoringPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeStackSlotColoringPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStraightLineStrengthReducePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp", line = 217,
 FQN="llvm::initializeStraightLineStrengthReducePass", NM="_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp -nm=_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStraightLineStrengthReducePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStraightLineStrengthReducePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadPrototypesLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp", line = 83,
 FQN="llvm::initializeStripDeadPrototypesLegacyPassPass", NM="_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp -nm=_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripDeadPrototypesLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStripDeadPrototypesLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadDebugInfoPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 125,
 FQN="llvm::initializeStripDeadDebugInfoPass", NM="_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripDeadDebugInfoPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStripDeadDebugInfoPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDebugDeclarePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 117,
 FQN="llvm::initializeStripDebugDeclarePass", NM="_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripDebugDeclarePass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStripDebugDeclarePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripNonDebugSymbolsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 108,
 FQN="llvm::initializeStripNonDebugSymbolsPass", NM="_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripNonDebugSymbolsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStripNonDebugSymbolsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStripSymbolsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 100,
 FQN="llvm::initializeStripSymbolsPass", NM="_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStripSymbolsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStripSymbolsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeStructurizeCFGPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp", line = 284,
 FQN="llvm::initializeStructurizeCFGPass", NM="_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp -nm=_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeStructurizeCFGPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeStructurizeCFGPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteSymbolsPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 541,
 FQN="llvm::initializeRewriteSymbolsPass", NM="_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRewriteSymbolsPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeRewriteSymbolsPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTailDuplicatePassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/TailDuplication.cpp", line = 43,
 FQN="llvm::initializeTailDuplicatePassPass", NM="_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/TailDuplication.cpp -nm=_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTailDuplicatePassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeTailDuplicatePassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTailCallElimPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp", line = 820,
 FQN="llvm::initializeTailCallElimPass", NM="_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp -nm=_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTailCallElimPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeTailCallElimPass(Registry);
}


// Register the basic pass.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetLibraryInfoWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1168,
 FQN="llvm::initializeTargetLibraryInfoWrapperPassPass", NM="_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetLibraryInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeTargetLibraryInfoWrapperPassPass(Registry);
}


//===---------------------------------------------------------------------===//
/// TargetPassConfig
//===---------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetPassConfigPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/TargetPassConfig.cpp", line = 198,
 FQN="llvm::initializeTargetPassConfigPass", NM="_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/TargetPassConfig.cpp -nm=_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetPassConfigPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeTargetPassConfigPass(Registry);
}


// Register the basic pass.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetTransformInfoWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 440,
 FQN="llvm::initializeTargetTransformInfoWrapperPassPass", NM="_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetTransformInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  LllvmAnalysisPassInitializer$$.PROVIDER.initializeTargetTransformInfoWrapperPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeThreadSanitizerPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp", line = 133,
 FQN="llvm::initializeThreadSanitizerPass", NM="_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp -nm=_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeThreadSanitizerPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeThreadSanitizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTwoAddressInstructionPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/TwoAddressInstructionPass.cpp", line = 177,
 FQN="llvm::initializeTwoAddressInstructionPassPass", NM="_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/TwoAddressInstructionPass.cpp -nm=_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTwoAddressInstructionPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeTwoAddressInstructionPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTypeBasedAAWrapperPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 593,
 FQN="llvm::initializeTypeBasedAAWrapperPassPass", NM="_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTypeBasedAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  AdtsupportLlvmGlobals.call_once(TypeBasedAliasAnalysisStatics.InitializeTypeBasedAAWrapperPassPassFlag, TypeBasedAliasAnalysisStatics::initializeTypeBasedAAWrapperPassPassOnce, std.ref_T$R(Registry));
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnifyFunctionExitNodesPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp", line = 27,
 FQN="llvm::initializeUnifyFunctionExitNodesPass", NM="_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp -nm=_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnifyFunctionExitNodesPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeUnifyFunctionExitNodesPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnreachableBlockElimLegacyPassPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp", line = 92,
 FQN="llvm::initializeUnreachableBlockElimLegacyPassPass", NM="_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp -nm=_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnreachableBlockElimLegacyPassPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeUnreachableBlockElimLegacyPassPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeUnreachableMachineBlockElimPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp", line = 121,
 FQN="llvm::initializeUnreachableMachineBlockElimPass", NM="_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp -nm=_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeUnreachableMachineBlockElimPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeUnreachableMachineBlockElimPass(Registry);
}


/// Initialize all passes linked into the TransformUtils library.

/// initializeTransformUtils - Initialize all passes in the TransformUtils
/// library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTransformUtils">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp", line = 23,
 FQN="llvm::initializeTransformUtils", NM="_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp -nm=_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTransformUtils(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeAddDiscriminatorsLegacyPassPass(Registry);
  IrLlvmGlobals.initializeBreakCriticalEdgesPass(Registry);
  IrLlvmGlobals.initializeInstNamerPass(Registry);
  IrLlvmGlobals.initializeLCSSAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeLoopSimplifyPass(Registry);
  IrLlvmGlobals.initializeLowerInvokePass(Registry);
  IrLlvmGlobals.initializeLowerSwitchPass(Registry);
  IrLlvmGlobals.initializeNameAnonFunctionPass(Registry);
  IrLlvmGlobals.initializePromoteLegacyPassPass(Registry);
  IrLlvmGlobals.initializeUnifyFunctionExitNodesPass(Registry);
  IrLlvmGlobals.initializeInstSimplifierPass(Registry);
  IrLlvmGlobals.initializeMetaRenamerPass(Registry);
  IrLlvmGlobals.initializeMemorySSAWrapperPassPass(Registry);
  IrLlvmGlobals.initializeMemorySSAPrinterLegacyPassPass(Registry);
}


/// Initialize all passes linked into the Vectorize library.

/// initializeVectorizationPasses - Initialize all passes linked into the
/// Vectorization library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeVectorization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp", line = 28,
 FQN="llvm::initializeVectorization", NM="_ZN4llvm23initializeVectorizationERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp -nm=_ZN4llvm23initializeVectorizationERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVectorization(final PassRegistry /*&*/ Registry) {
  IrLlvmGlobals.initializeBBVectorizePass(Registry);
  IrLlvmGlobals.initializeLoopVectorizePass(Registry);
  IrLlvmGlobals.initializeSLPVectorizerPass(Registry);
  IrLlvmGlobals.initializeLoadStoreVectorizerPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeVirtRegMapPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp", line = 52,
 FQN="llvm::initializeVirtRegMapPass", NM="_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp -nm=_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVirtRegMapPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeVirtRegMapPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeVirtRegRewriterPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp", line = 194,
 FQN="llvm::initializeVirtRegRewriterPass", NM="_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp -nm=_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeVirtRegRewriterPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeVirtRegRewriterPass(Registry);
}

// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::initializeWholeProgramDevirtPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp", line = 307,
 FQN="llvm::initializeWholeProgramDevirtPass", NM="_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp -nm=_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeWholeProgramDevirtPass(final PassRegistry /*&*/ Registry) {
  LllvmTransformsPassInitializer$$.PROVIDER.initializeWholeProgramDevirtPass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeWinEHPreparePass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/WinEHPrepare.cpp", line = 96,
 FQN="llvm::initializeWinEHPreparePass", NM="_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/WinEHPrepare.cpp -nm=_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeWinEHPreparePass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeWinEHPreparePass(Registry);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeXRayInstrumentationPass">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/CodeGen/XRayInstrumentation.cpp", line = 95,
 FQN="llvm::initializeXRayInstrumentationPass", NM="_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/XRayInstrumentation.cpp -nm=_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeXRayInstrumentationPass(final PassRegistry /*&*/ Registry) {
  LllvmCodegenInitializer$$.PROVIDER.initializeXRayInstrumentationPass(Registry);
}

// wrapper to be able impl delegation into llvm/Analysis module
private static final class LllvmAnalysisPassInitializer$$ {
  private static final LllvmAnalysisPassInitializer PROVIDER = org.openide.util.Lookup.getDefault().lookup(LllvmAnalysisPassInitializer.class);
}
// wrapper to be able impl delegation into llvm/Transforms module
private static final class LllvmTransformsPassInitializer$$ {
  private static final LllvmTransformsPassInitializer PROVIDER = org.openide.util.Lookup.getDefault().lookup(LllvmTransformsPassInitializer.class);
}
// wrapper to be able impl delegation into llvm/Bitcode module
private static final class LllvmBitcodePassInitializer$$ {
  private static final LllvmBitcodePassInitializer PROVIDER = org.openide.util.Lookup.getDefault().lookup(LllvmBitcodePassInitializer.class);
}
// wrapper to be able impl delegation into llvm/CodeGen module
private static final class LllvmCodegenInitializer$$ {
  private static final LllvmCodegenInitializer PROVIDER = org.openide.util.Lookup.getDefault().lookup(LllvmCodegenInitializer.class);
}
} // END OF class InitializePassesLlvmGlobals
