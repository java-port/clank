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
package org.llvm.transforms.scalar.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.transforms.java.TransformDummies.*;


//<editor-fold defaultstate="collapsed" desc="static type TransformsLlvmStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.transforms.scalar.impl.TransformsLlvmStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPO.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombinePHI.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ProvenanceAnalysisEvaluator.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalar.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Utils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/Vectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp -nm=_ZN4llvm12_GLOBAL__N_115findGlobalCtorsERNS_6ModuleE;_ZN4llvm12_GLOBAL__N_116parseGlobalCtorsEPNS_14GlobalVariableE;_ZN4llvm12_GLOBAL__N_117removeGlobalCtorsEPNS_14GlobalVariableERKNS_9BitVectorE;_ZN4llvm13initializeIPOERNS_12PassRegistryE;_ZN4llvm16createPAEvalPassEv;_ZN4llvm17initializeDAEPassERNS_12PassRegistryE;_ZN4llvm17initializeDAHPassERNS_12PassRegistryE;_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE;_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE;_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE;_ZN4llvm21initializeInstCombineERNS_12PassRegistryE;_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE;_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE;_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE;_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE;_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE;_ZN4llvm23initializeVectorizationERNS_12PassRegistryE;_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE;_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE;_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE;_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE;_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE;_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE;_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE;_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE;_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE;_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE;_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE;_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE;_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE;_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE;_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE;_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE;_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE;_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE;_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE;_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE;_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE;_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE;_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE;_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE;_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE;_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE;_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE;_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE;_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE;_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE;_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE;_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE;_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE;_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE;_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE;_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE;_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE;_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE;_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE;_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE;_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE;_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE;_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE;_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE;_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE;_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE;_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE;_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE;_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE;_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE;_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE;_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE;_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE;_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE;_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE;_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE;_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE;_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE;_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE;_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE;_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE;_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE;_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE;_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE;_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE;_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE;_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE;_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE;_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE;_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE;_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE;_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE;_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE;_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE;_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE;_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE;_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE;_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE;_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE;_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE;_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE;_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE;_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE;_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE;_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE;_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE;_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE;_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE;_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE;_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE;_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE;_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE;_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE;_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE;_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE;_ZN4llvmL11CompareVarsERKNS_28ASanStackVariableDescriptionES2_;_ZN4llvmL13getComplexityEPNS_5ValueE;_ZN4llvmL13kMinAlignmentE;_ZN4llvmL14IsFreeToInvertEPNS_5ValueEb;_ZN4llvmL14LiveOnEntryStrE;_ZN4llvmL15onlySingleValueEPNS_9MemoryPhiE;_ZN4llvmL17VarAndRedzoneSizeEjj;_ZN4llvmL32IntrinsicIDToOverflowCheckFlavorEj;_ZN4llvmL6AddOneEPNS_8ConstantE;_ZN4llvmL6SubOneEPNS_8ConstantE;_ZN4llvmlsERNS_11raw_ostreamERN12_GLOBAL__N_17BBStateE; -static-type=TransformsLlvmStatics -package=org.llvm.transforms.scalar.impl")
//</editor-fold>
public final class TransformsLlvmStatics {


///// Initialize all passes linked into the TransformUtils library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeTransformUtils">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 26,
// FQN="llvm::initializeTransformUtils", NM="_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm24initializeTransformUtilsERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeTransformUtils(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.UtilsLlvmStatics.
//    initializeTransformUtils($Prm0);
//}
//
//
///// Initialize all passes linked into the ScalarOpts library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarOpts">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 29,
// FQN="llvm::initializeScalarOpts", NM="_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm20initializeScalarOptsERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeScalarOpts(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.ScalarLlvmStatics.
//    initializeScalarOpts($Prm0);
//}
//
//
///// Initialize all passes linked into the ObjCARCOpts library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOpts">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 32,
// FQN="llvm::initializeObjCARCOpts", NM="_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm21initializeObjCARCOptsERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeObjCARCOpts(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.objcarc.impl.ObjCARCLlvmStatics.
//    initializeObjCARCOpts($Prm0);
//}
//
//
///// Initialize all passes linked into the Vectorize library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeVectorization">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 35,
// FQN="llvm::initializeVectorization", NM="_ZN4llvm23initializeVectorizationERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm23initializeVectorizationERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeVectorization(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.vectorize.impl.VectorizeLlvmStatics.
//    initializeVectorization($Prm0);
//}
//
//
///// Initialize all passes linked into the InstCombine library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCombine">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 38,
// FQN="llvm::initializeInstCombine", NM="_ZN4llvm21initializeInstCombineERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm21initializeInstCombineERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInstCombine(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instcombine.impl.InstructionCombiningLlvmStatics.
//    initializeInstCombine($Prm0);
//}
//
//
///// Initialize all passes linked into the IPO library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeIPO">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 41,
// FQN="llvm::initializeIPO", NM="_ZN4llvm13initializeIPOERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm13initializeIPOERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeIPO(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.IPOLlvmStatics.
//    initializeIPO($Prm0);
//}
//
//
///// Initialize all passes linked into the Instrumentation library.
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrumentation">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 44,
// FQN="llvm::initializeInstrumentation", NM="_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeInstrumentationERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInstrumentation(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.InstrumentationLlvmStatics.
//    initializeInstrumentation($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeADCELegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 179,
// FQN="llvm::initializeADCELegacyPassPass", NM="_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeADCELegacyPassPass(final PassRegistry /*&*/ Registry) {
//  /*delegate*/org.llvm.transforms.scalar.impl.ADCELlvmStatics.
//    initializeADCELegacyPassPass(Registry);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAddDiscriminatorsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 61,
 FQN="llvm::initializeAddDiscriminatorsLegacyPassPass", NM="_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAddDiscriminatorsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.transforms.utils.impl.AddDiscriminatorsLlvmStatics.
    initializeAddDiscriminatorsLegacyPassPass($Prm0);
}

////<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerModulePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 62,
// FQN="llvm::initializeAddressSanitizerModulePass", NM="_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeAddressSanitizerModulePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.AddressSanitizerLlvmStatics.
//    initializeAddressSanitizerModulePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 63,
// FQN="llvm::initializeAddressSanitizerPass", NM="_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeAddressSanitizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.AddressSanitizerLlvmStatics.
//    initializeAddressSanitizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeAlignmentFromAssumptionsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 65,
// FQN="llvm::initializeAlignmentFromAssumptionsPass", NM="_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeAlignmentFromAssumptionsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.AlignmentFromAssumptionsLlvmStatics.
//    initializeAlignmentFromAssumptionsPass($Prm0);
//}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAlwaysInlinerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 66,
 FQN="llvm::initializeAlwaysInlinerPass", NM="_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAlwaysInlinerPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.transforms.ipo.impl.InlineAlwaysLlvmStatics.
    initializeAlwaysInlinerPass($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBarrierNoopPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 72,
 FQN="llvm::initializeBarrierNoopPass", NM="_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBarrierNoopPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.transforms.ipo.impl.BarrierNoopPassLlvmStatics.
    initializeBarrierNoopPass($Prm0);
}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockExtractorPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 74,
// FQN="llvm::initializeBlockExtractorPassPass", NM="_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeBlockExtractorPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.LoopExtractorLlvmStatics.
//    initializeBlockExtractorPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeBoundsCheckingPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 76,
// FQN="llvm::initializeBoundsCheckingPass", NM="_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeBoundsCheckingPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.BoundsCheckingLlvmStatics.
//    initializeBoundsCheckingPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeBreakCriticalEdgesPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 79,
// FQN="llvm::initializeBreakCriticalEdgesPass", NM="_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeBreakCriticalEdgesPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.BreakCriticalEdgesLlvmStatics.
//    initializeBreakCriticalEdgesPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGSimplifyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 83,
// FQN="llvm::initializeCFGSimplifyPassPass", NM="_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeCFGSimplifyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SimplifyCFGPassLlvmStatics.
//    initializeCFGSimplifyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantHoistingLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 92,
// FQN="llvm::initializeConstantHoistingLegacyPassPass", NM="_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeConstantHoistingLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.ConstantHoistingLlvmStatics.
//    initializeConstantHoistingLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantMergeLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 93,
// FQN="llvm::initializeConstantMergeLegacyPassPass", NM="_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeConstantMergeLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.ConstantMergeLlvmStatics.
//    initializeConstantMergeLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantPropagationPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 94,
// FQN="llvm::initializeConstantPropagationPass", NM="_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeConstantPropagationPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.ConstantPropLlvmStatics.
//    initializeConstantPropagationPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeCorrelatedValuePropagationPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 95,
// FQN="llvm::initializeCorrelatedValuePropagationPass", NM="_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeCorrelatedValuePropagationPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.CorrelatedValuePropagationLlvmStatics.
//    initializeCorrelatedValuePropagationPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeCrossDSOCFIPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 97,
// FQN="llvm::initializeCrossDSOCFIPass", NM="_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeCrossDSOCFIPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.CrossDSOCFILlvmStatics.
//    initializeCrossDSOCFIPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeDAEPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 98,
// FQN="llvm::initializeDAEPass", NM="_ZN4llvm17initializeDAEPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm17initializeDAEPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeDAEPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.DeadArgumentEliminationLlvmStatics.
//    initializeDAEPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeDAHPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 99,
// FQN="llvm::initializeDAHPass", NM="_ZN4llvm17initializeDAHPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm17initializeDAHPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeDAHPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.DeadArgumentEliminationLlvmStatics.
//    initializeDAHPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeDCELegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 100,
// FQN="llvm::initializeDCELegacyPassPass", NM="_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeDCELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.DCELlvmStatics.
//    initializeDCELegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeDSELegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 101,
// FQN="llvm::initializeDSELegacyPassPass", NM="_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeDSELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.DeadStoreEliminationLlvmStatics.
//    initializeDSELegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeDataFlowSanitizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 102,
// FQN="llvm::initializeDataFlowSanitizerPass", NM="_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeDataFlowSanitizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.DataFlowSanitizerLlvmStatics.
//    initializeDataFlowSanitizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadInstEliminationPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 103,
// FQN="llvm::initializeDeadInstEliminationPass", NM="_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeDeadInstEliminationPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.DCELlvmStatics.
//    initializeDeadInstEliminationPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyCSELegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 118,
// FQN="llvm::initializeEarlyCSELegacyPassPass", NM="_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeEarlyCSELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.EarlyCSELlvmStatics.
//    initializeEarlyCSELegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeEfficiencySanitizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 121,
// FQN="llvm::initializeEfficiencySanitizerPass", NM="_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeEfficiencySanitizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.EfficiencySanitizerLlvmStatics.
//    initializeEfficiencySanitizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeEliminateAvailableExternallyLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 122,
// FQN="llvm::initializeEliminateAvailableExternallyLegacyPassPass", NM="_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeEliminateAvailableExternallyLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.ElimAvailExternLlvmStatics.
//    initializeEliminateAvailableExternallyLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNHoistLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 123,
// FQN="llvm::initializeGVNHoistLegacyPassPass", NM="_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeGVNHoistLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.GVNHoistLlvmStatics.
//    initializeGVNHoistLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeFlattenCFGPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 128,
// FQN="llvm::initializeFlattenCFGPassPass", NM="_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeFlattenCFGPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.FlattenCFGPassLlvmStatics.
//    initializeFlattenCFGPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeFloat2IntLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 129,
// FQN="llvm::initializeFloat2IntLegacyPassPass", NM="_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeFloat2IntLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.Float2IntLlvmStatics.
//    initializeFloat2IntLegacyPassPass($Prm0);
//}
//
//<editor-fold defaultstate="collapsed" desc="llvm::initializeForceFunctionAttrsLegacyPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 130,
 FQN="llvm::initializeForceFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeForceFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.transforms.ipo.impl.ForceFunctionAttrsLlvmStatics.
    initializeForceFunctionAttrsLegacyPassPass($Prm0);
}

////<editor-fold defaultstate="collapsed" desc="llvm::initializeFunctionImportPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 133,
// FQN="llvm::initializeFunctionImportPassPass", NM="_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeFunctionImportPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmStatics.
//    initializeFunctionImportPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeGCOVProfilerLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 136,
// FQN="llvm::initializeGCOVProfilerLegacyPassPass", NM="_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeGCOVProfilerLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.GCOVProfilingLlvmStatics.
//    initializeGCOVProfilerLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 137,
// FQN="llvm::initializeGVNLegacyPassPass", NM="_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeGVNLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.GVNLlvmStatics.
//    initializeGVNLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalDCELegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 138,
// FQN="llvm::initializeGlobalDCELegacyPassPass", NM="_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeGlobalDCELegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.GlobalDCELlvmStatics.
//    initializeGlobalDCELegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalOptLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 140,
// FQN="llvm::initializeGlobalOptLegacyPassPass", NM="_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeGlobalOptLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.GlobalOptLlvmStatics.
//    initializeGlobalOptLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeGuardWideningLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 142,
// FQN="llvm::initializeGuardWideningLegacyPassPass", NM="_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeGuardWideningLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.GuardWideningLlvmStatics.
//    initializeGuardWideningLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeIPCPPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 143,
// FQN="llvm::initializeIPCPPass", NM="_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeIPCPPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.IPConstantPropagationLlvmStatics.
//    initializeIPCPPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeIPSCCPLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 144,
// FQN="llvm::initializeIPSCCPLegacyPassPass", NM="_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeIPSCCPLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SCCPLlvmStatics.
//    initializeIPSCCPLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeIndVarSimplifyLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 149,
// FQN="llvm::initializeIndVarSimplifyLegacyPassPass", NM="_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeIndVarSimplifyLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.IndVarSimplifyLlvmStatics.
//    initializeIndVarSimplifyLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInductiveRangeCheckEliminationPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 150,
// FQN="llvm::initializeInductiveRangeCheckEliminationPass", NM="_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInductiveRangeCheckEliminationPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.InductiveRangeCheckEliminationLlvmStatics.
//    initializeInductiveRangeCheckEliminationPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInferFunctionAttrsLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 151,
// FQN="llvm::initializeInferFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInferFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.InferFunctionAttrsLlvmStatics.
//    initializeInferFunctionAttrsLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInstNamerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 154,
// FQN="llvm::initializeInstNamerPass", NM="_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInstNamerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.InstructionNamerLlvmStatics.
//    initializeInstNamerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInstSimplifierPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 155,
// FQN="llvm::initializeInstSimplifierPass", NM="_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInstSimplifierPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.SimplifyInstructionsLlvmStatics.
//    initializeInstSimplifierPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrProfilingLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 156,
// FQN="llvm::initializeInstrProfilingLegacyPassPass", NM="_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInstrProfilingLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.InstrProfilingLlvmStatics.
//    initializeInstrProfilingLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInstructionCombiningPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 157,
// FQN="llvm::initializeInstructionCombiningPassPass", NM="_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInstructionCombiningPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instcombine.impl.InstructionCombiningLlvmStatics.
//    initializeInstructionCombiningPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeInternalizeLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 159,
// FQN="llvm::initializeInternalizeLegacyPassPass", NM="_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeInternalizeLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.InternalizeLlvmStatics.
//    initializeInternalizeLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeJumpThreadingPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 161,
// FQN="llvm::initializeJumpThreadingPass", NM="_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeJumpThreadingPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.JumpThreadingLlvmStatics.
//    initializeJumpThreadingPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLCSSAWrapperPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 162,
// FQN="llvm::initializeLCSSAWrapperPassPass", NM="_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLCSSAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.LCSSALlvmStatics.
//    initializeLCSSAWrapperPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLegacyLICMPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 163,
// FQN="llvm::initializeLegacyLICMPassPass", NM="_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLegacyLICMPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LICMLlvmStatics.
//    initializeLegacyLICMPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadCombinePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 173,
// FQN="llvm::initializeLoadCombinePass", NM="_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoadCombinePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoadCombineLlvmStatics.
//    initializeLoadCombinePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadStoreVectorizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 175,
// FQN="llvm::initializeLoadStoreVectorizerPass", NM="_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoadStoreVectorizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.vectorize.impl.LoadStoreVectorizerLlvmStatics.
//    initializeLoadStoreVectorizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDataPrefetchPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 178,
// FQN="llvm::initializeLoopDataPrefetchPass", NM="_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopDataPrefetchPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopDataPrefetchLlvmStatics.
//    initializeLoopDataPrefetchPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDeletionLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 179,
// FQN="llvm::initializeLoopDeletionLegacyPassPass", NM="_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopDeletionLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopDeletionLlvmStatics.
//    initializeLoopDeletionLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDistributeLegacyPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 180,
// FQN="llvm::initializeLoopDistributeLegacyPass", NM="_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopDistributeLegacyPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopDistributeLlvmStatics.
//    initializeLoopDistributeLegacyPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopExtractorPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 181,
// FQN="llvm::initializeLoopExtractorPass", NM="_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopExtractorPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.LoopExtractorLlvmStatics.
//    initializeLoopExtractorPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopIdiomRecognizeLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 182,
// FQN="llvm::initializeLoopIdiomRecognizeLegacyPassPass", NM="_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopIdiomRecognizeLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopIdiomRecognizeLlvmStatics.
//    initializeLoopIdiomRecognizeLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInstSimplifyLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 184,
// FQN="llvm::initializeLoopInstSimplifyLegacyPassPass", NM="_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopInstSimplifyLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopInstSimplifyLlvmStatics.
//    initializeLoopInstSimplifyLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInterchangePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 185,
// FQN="llvm::initializeLoopInterchangePass", NM="_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopInterchangePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopInterchangeLlvmStatics.
//    initializeLoopInterchangePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopLoadEliminationPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 186,
// FQN="llvm::initializeLoopLoadEliminationPass", NM="_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopLoadEliminationPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopLoadEliminationLlvmStatics.
//    initializeLoopLoadEliminationPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 187,
// FQN="llvm::initializeLoopPassPass", NM="_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm22initializeLoopPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.LoopUtilsLlvmStatics.
//    initializeLoopPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRerollPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 188,
// FQN="llvm::initializeLoopRerollPass", NM="_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopRerollPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopRerollPassLlvmStatics.
//    initializeLoopRerollPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRotateLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 189,
// FQN="llvm::initializeLoopRotateLegacyPassPass", NM="_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopRotateLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopRotationLlvmStatics.
//    initializeLoopRotateLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyCFGLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 190,
// FQN="llvm::initializeLoopSimplifyCFGLegacyPassPass", NM="_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopSimplifyCFGLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopSimplifyCFGLlvmStatics.
//    initializeLoopSimplifyCFGLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 191,
// FQN="llvm::initializeLoopSimplifyPass", NM="_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopSimplifyPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.LoopSimplifyLlvmStatics.
//    initializeLoopSimplifyPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopStrengthReducePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 192,
// FQN="llvm::initializeLoopStrengthReducePass", NM="_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopStrengthReducePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopStrengthReduceLlvmStatics.
//    initializeLoopStrengthReducePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnrollPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 193,
// FQN="llvm::initializeLoopUnrollPass", NM="_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopUnrollPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopUnrollPassLlvmStatics.
//    initializeLoopUnrollPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnswitchPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 194,
// FQN="llvm::initializeLoopUnswitchPass", NM="_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopUnswitchPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopUnswitchLlvmStatics.
//    initializeLoopUnswitchPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVectorizePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 195,
// FQN="llvm::initializeLoopVectorizePass", NM="_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopVectorizePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.vectorize.impl.LoopVectorizeLlvmStatics.
//    initializeLoopVectorizePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningLICMPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 196,
// FQN="llvm::initializeLoopVersioningLICMPass", NM="_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopVersioningLICMPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LoopVersioningLICMLlvmStatics.
//    initializeLoopVersioningLICMPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 197,
// FQN="llvm::initializeLoopVersioningPassPass", NM="_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLoopVersioningPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.LoopVersioningLlvmStatics.
//    initializeLoopVersioningPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerAtomicLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 198,
// FQN="llvm::initializeLowerAtomicLegacyPassPass", NM="_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLowerAtomicLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LowerAtomicLlvmStatics.
//    initializeLowerAtomicLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerExpectIntrinsicPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 200,
// FQN="llvm::initializeLowerExpectIntrinsicPass", NM="_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLowerExpectIntrinsicPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LowerExpectIntrinsicLlvmStatics.
//    initializeLowerExpectIntrinsicPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerGuardIntrinsicPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 201,
// FQN="llvm::initializeLowerGuardIntrinsicPass", NM="_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLowerGuardIntrinsicPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.LowerGuardIntrinsicLlvmStatics.
//    initializeLowerGuardIntrinsicPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerInvokePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 203,
// FQN="llvm::initializeLowerInvokePass", NM="_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLowerInvokePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.LowerInvokeLlvmStatics.
//    initializeLowerInvokePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerSwitchPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 204,
// FQN="llvm::initializeLowerSwitchPass", NM="_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLowerSwitchPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.LowerSwitchLlvmStatics.
//    initializeLowerSwitchPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerTypeTestsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 205,
// FQN="llvm::initializeLowerTypeTestsPass", NM="_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeLowerTypeTestsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.LowerTypeTestsLlvmStatics.
//    initializeLowerTypeTestsPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMemCpyOptLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 226,
// FQN="llvm::initializeMemCpyOptLegacyPassPass", NM="_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMemCpyOptLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.MemCpyOptimizerLlvmStatics.
//    initializeMemCpyOptLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAWrapperPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 230,
// FQN="llvm::initializeMemorySSAWrapperPassPass", NM="_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMemorySSAWrapperPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.MemorySSALlvmStatics.
//    initializeMemorySSAWrapperPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAPrinterLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 231,
// FQN="llvm::initializeMemorySSAPrinterLegacyPassPass", NM="_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMemorySSAPrinterLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.MemorySSALlvmStatics.
//    initializeMemorySSAPrinterLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySanitizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 232,
// FQN="llvm::initializeMemorySanitizerPass", NM="_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMemorySanitizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.MemorySanitizerLlvmStatics.
//    initializeMemorySanitizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMergeFunctionsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 233,
// FQN="llvm::initializeMergeFunctionsPass", NM="_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMergeFunctionsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.MergeFunctionsLlvmStatics.
//    initializeMergeFunctionsPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMergedLoadStoreMotionLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 234,
// FQN="llvm::initializeMergedLoadStoreMotionLegacyPassPass", NM="_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMergedLoadStoreMotionLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.MergedLoadStoreMotionLlvmStatics.
//    initializeMergedLoadStoreMotionLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeMetaRenamerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 235,
// FQN="llvm::initializeMetaRenamerPass", NM="_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeMetaRenamerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.MetaRenamerLlvmStatics.
//    initializeMetaRenamerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeNameAnonFunctionPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 238,
// FQN="llvm::initializeNameAnonFunctionPass", NM="_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeNameAnonFunctionPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.NameAnonFunctionsLlvmStatics.
//    initializeNameAnonFunctionPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeNaryReassociatePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 239,
// FQN="llvm::initializeNaryReassociatePass", NM="_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeNaryReassociatePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.NaryReassociateLlvmStatics.
//    initializeNaryReassociatePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAPElimPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 242,
// FQN="llvm::initializeObjCARCAPElimPass", NM="_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeObjCARCAPElimPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.objcarc.impl.ObjCARCAPElimLlvmStatics.
//    initializeObjCARCAPElimPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCContractPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 243,
// FQN="llvm::initializeObjCARCContractPass", NM="_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeObjCARCContractPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.objcarc.impl.ObjCARCContractLlvmStatics.
//    initializeObjCARCContractPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCExpandPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 244,
// FQN="llvm::initializeObjCARCExpandPass", NM="_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeObjCARCExpandPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.objcarc.impl.ObjCARCExpandLlvmStatics.
//    initializeObjCARCExpandPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOptPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 245,
// FQN="llvm::initializeObjCARCOptPass", NM="_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeObjCARCOptPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.objcarc.impl.ObjCARCOptsLlvmStatics.
//    initializeObjCARCOptPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePAEvalPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 248,
// FQN="llvm::initializePAEvalPass", NM="_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePAEvalPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.objcarc.impl.ProvenanceAnalysisEvaluatorLlvmStatics.
//    initializePAEvalPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePGOIndirectCallPromotionLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 250,
// FQN="llvm::initializePGOIndirectCallPromotionLegacyPassPass", NM="_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePGOIndirectCallPromotionLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.IndirectCallPromotionLlvmStatics.
//    initializePGOIndirectCallPromotionLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationGenLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 251,
// FQN="llvm::initializePGOInstrumentationGenLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePGOInstrumentationGenLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.PGOInstrumentationLlvmStatics.
//    initializePGOInstrumentationGenLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationUseLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 252,
// FQN="llvm::initializePGOInstrumentationUseLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePGOInstrumentationUseLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.PGOInstrumentationLlvmStatics.
//    initializePGOInstrumentationUseLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePartialInlinerLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 255,
// FQN="llvm::initializePartialInlinerLegacyPassPass", NM="_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePartialInlinerLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.PartialInliningLlvmStatics.
//    initializePartialInlinerLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePartiallyInlineLibCallsLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 256,
// FQN="llvm::initializePartiallyInlineLibCallsLegacyPassPass", NM="_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePartiallyInlineLibCallsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.PartiallyInlineLibCallsLlvmStatics.
//    initializePartiallyInlineLibCallsLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceBackedgeSafepointsImplPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 259,
// FQN="llvm::initializePlaceBackedgeSafepointsImplPass", NM="_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePlaceBackedgeSafepointsImplPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.PlaceSafepointsLlvmStatics.
//    initializePlaceBackedgeSafepointsImplPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceSafepointsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 260,
// FQN="llvm::initializePlaceSafepointsPass", NM="_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePlaceSafepointsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.PlaceSafepointsLlvmStatics.
//    initializePlaceSafepointsPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePostOrderFunctionAttrsLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 267,
// FQN="llvm::initializePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.FunctionAttrsLlvmStatics.
//    initializePostOrderFunctionAttrsLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePromoteLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 276,
// FQN="llvm::initializePromoteLegacyPassPass", NM="_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePromoteLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.Mem2RegLlvmStatics.
//    initializePromoteLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializePruneEHPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 277,
// FQN="llvm::initializePruneEHPass", NM="_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializePruneEHPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.PruneEHLlvmStatics.
//    initializePruneEHPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeReassociateLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 278,
// FQN="llvm::initializeReassociateLegacyPassPass", NM="_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeReassociateLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.ReassociateLlvmStatics.
//    initializeReassociateLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeRegToMemPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 280,
// FQN="llvm::initializeRegToMemPass", NM="_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeRegToMemPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.Reg2MemLlvmStatics.
//    initializeRegToMemPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 288,
// FQN="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeReversePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.FunctionAttrsLlvmStatics.
//    initializeReversePostOrderFunctionAttrsLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteStatepointsForGCPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 289,
// FQN="llvm::initializeRewriteStatepointsForGCPass", NM="_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeRewriteStatepointsForGCPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.RewriteStatepointsForGCLlvmStatics.
//    initializeRewriteStatepointsForGCPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteSymbolsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 290,
// FQN="llvm::initializeRewriteSymbolsPass", NM="_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeRewriteSymbolsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.SymbolRewriterLlvmStatics.
//    initializeRewriteSymbolsPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSCCPLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 291,
// FQN="llvm::initializeSCCPLegacyPassPass", NM="_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSCCPLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SCCPLlvmStatics.
//    initializeSCCPLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSLPVectorizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 293,
// FQN="llvm::initializeSLPVectorizerPass", NM="_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSLPVectorizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.vectorize.impl.SLPVectorizerLlvmStatics.
//    initializeSLPVectorizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSROALegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 294,
// FQN="llvm::initializeSROALegacyPassPass", NM="_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSROALegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SROALlvmStatics.
//    initializeSROALegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSampleProfileLoaderLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 296,
// FQN="llvm::initializeSampleProfileLoaderLegacyPassPass", NM="_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSampleProfileLoaderLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.SampleProfileLlvmStatics.
//    initializeSampleProfileLoaderLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSanitizerCoverageModulePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 297,
// FQN="llvm::initializeSanitizerCoverageModulePass", NM="_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSanitizerCoverageModulePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.SanitizerCoverageLlvmStatics.
//    initializeSanitizerCoverageModulePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 299,
// FQN="llvm::initializeScalarizerPass", NM="_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeScalarizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.ScalarizerLlvmStatics.
//    initializeScalarizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSeparateConstOffsetFromGEPPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 301,
// FQN="llvm::initializeSeparateConstOffsetFromGEPPass", NM="_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSeparateConstOffsetFromGEPPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SeparateConstOffsetFromGEPLlvmStatics.
//    initializeSeparateConstOffsetFromGEPPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSimpleInlinerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 304,
// FQN="llvm::initializeSimpleInlinerPass", NM="_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSimpleInlinerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.InlineSimpleLlvmStatics.
//    initializeSimpleInlinerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSingleLoopExtractorPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 305,
// FQN="llvm::initializeSingleLoopExtractorPass", NM="_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSingleLoopExtractorPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.LoopExtractorLlvmStatics.
//    initializeSingleLoopExtractorPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSinkingLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 306,
// FQN="llvm::initializeSinkingLegacyPassPass", NM="_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSinkingLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SinkLlvmStatics.
//    initializeSinkingLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeSpeculativeExecutionPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 309,
// FQN="llvm::initializeSpeculativeExecutionPass", NM="_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeSpeculativeExecutionPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.SpeculativeExecutionLlvmStatics.
//    initializeSpeculativeExecutionPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStraightLineStrengthReducePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 315,
// FQN="llvm::initializeStraightLineStrengthReducePass", NM="_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStraightLineStrengthReducePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.StraightLineStrengthReduceLlvmStatics.
//    initializeStraightLineStrengthReducePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadDebugInfoPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 316,
// FQN="llvm::initializeStripDeadDebugInfoPass", NM="_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStripDeadDebugInfoPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.StripSymbolsLlvmStatics.
//    initializeStripDeadDebugInfoPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadPrototypesLegacyPassPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 317,
// FQN="llvm::initializeStripDeadPrototypesLegacyPassPass", NM="_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStripDeadPrototypesLegacyPassPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.StripDeadPrototypesLlvmStatics.
//    initializeStripDeadPrototypesLegacyPassPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDebugDeclarePass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 318,
// FQN="llvm::initializeStripDebugDeclarePass", NM="_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStripDebugDeclarePass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.StripSymbolsLlvmStatics.
//    initializeStripDebugDeclarePass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStripNonDebugSymbolsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 319,
// FQN="llvm::initializeStripNonDebugSymbolsPass", NM="_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStripNonDebugSymbolsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.StripSymbolsLlvmStatics.
//    initializeStripNonDebugSymbolsPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStripSymbolsPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 320,
// FQN="llvm::initializeStripSymbolsPass", NM="_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStripSymbolsPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.StripSymbolsLlvmStatics.
//    initializeStripSymbolsPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeStructurizeCFGPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 321,
// FQN="llvm::initializeStructurizeCFGPass", NM="_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeStructurizeCFGPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.StructurizeCFGLlvmStatics.
//    initializeStructurizeCFGPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeTailCallElimPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 322,
// FQN="llvm::initializeTailCallElimPass", NM="_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeTailCallElimPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.scalar.impl.TailRecursionEliminationLlvmStatics.
//    initializeTailCallElimPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeThreadSanitizerPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 327,
// FQN="llvm::initializeThreadSanitizerPass", NM="_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeThreadSanitizerPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.instrumentation.impl.ThreadSanitizerLlvmStatics.
//    initializeThreadSanitizerPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeUnifyFunctionExitNodesPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 330,
// FQN="llvm::initializeUnifyFunctionExitNodesPass", NM="_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeUnifyFunctionExitNodesPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.utils.impl.UnifyFunctionExitNodesLlvmStatics.
//    initializeUnifyFunctionExitNodesPass($Prm0);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::initializeWholeProgramDevirtPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/InitializePasses.h", line = 337,
// FQN="llvm::initializeWholeProgramDevirtPass", NM="_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE")
////</editor-fold>
//public static void initializeWholeProgramDevirtPass(final PassRegistry /*&*/ $Prm0) {
//  /*delegate*/org.llvm.transforms.ipo.impl.WholeProgramDevirtLlvmStatics.
//    initializeWholeProgramDevirtPass($Prm0);
//}
//
//
//// We sort the stack variables by alignment (largest first) to minimize
//// unnecessary large gaps due to alignment.
//// It is tempting to also sort variables by size so that larger variables
//// have larger redzones at both ends. But reordering will make report analysis
//// harder, especially when temporary unnamed variables are present.
//// So, until we can provide more information (type, line number, etc)
//// for the stack variables we avoid reordering them too much.
////<editor-fold defaultstate="collapsed" desc="llvm::CompareVars">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp", line = 28,
// FQN="llvm::CompareVars", NM="_ZN4llvmL11CompareVarsERKNS_28ASanStackVariableDescriptionES2_",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvmL11CompareVarsERKNS_28ASanStackVariableDescriptionES2_")
////</editor-fold>
//public static /*inline*/ boolean CompareVars(final /*const*/ ASanStackVariableDescription /*&*/ a, 
//           final /*const*/ ASanStackVariableDescription /*&*/ b) {
//  return /*delegate*/org.llvm.transforms.utils.impl.ASanStackFrameLayoutLlvmStatics.
//    CompareVars(a, 
//           b);
//}
//
//
//// We also force minimal alignment for all vars to kMinAlignment so that vars
//// with e.g. alignment 1 and alignment 16 do not get reordered by CompareVars.
////<editor-fold defaultstate="collapsed" desc="llvm::kMinAlignment">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp", line = 35,
// FQN="llvm::kMinAlignment", NM="_ZN4llvmL13kMinAlignmentE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvmL13kMinAlignmentE")
////</editor-fold>
//public static /*const*//*size_t*/int kMinAlignment = 16;
//
//// The larger the variable Size the larger is the redzone.
//// The resulting frame size is a multiple of Alignment.
////<editor-fold defaultstate="collapsed" desc="llvm::VarAndRedzoneSize">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp", line = 39,
// FQN="llvm::VarAndRedzoneSize", NM="_ZN4llvmL17VarAndRedzoneSizeEjj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvmL17VarAndRedzoneSizeEjj")
////</editor-fold>
//public static /*size_t*/int VarAndRedzoneSize(/*size_t*/int Size, /*size_t*/int Alignment) {
//  return /*delegate*/org.llvm.transforms.utils.impl.ASanStackFrameLayoutLlvmStatics.
//    VarAndRedzoneSize(Size, Alignment);
//}
//
///// Given a specified llvm.global_ctors list, remove the listed elements.
////<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::removeGlobalCtors">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp", line = 30,
// FQN="llvm::(anonymous namespace)::removeGlobalCtors", NM="_ZN4llvm12_GLOBAL__N_117removeGlobalCtorsEPNS_14GlobalVariableERKNS_9BitVectorE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp -nm=_ZN4llvm12_GLOBAL__N_117removeGlobalCtorsEPNS_14GlobalVariableERKNS_9BitVectorE")
////</editor-fold>
//public static void removeGlobalCtors(GlobalVariable /*P*/ GCL, final /*const*/ BitVector /*&*/ CtorsToRemove) {
//  /*delegate*/org.llvm.transforms.utils.impl.CtorUtilsLlvmStatics.
//    removeGlobalCtors(GCL, CtorsToRemove);
//}
//
//
///// Given a llvm.global_ctors list that we can understand,
///// return a list of the functions and null terminator as a vector.
////<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::parseGlobalCtors">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp", line = 68,
// FQN="llvm::(anonymous namespace)::parseGlobalCtors", NM="_ZN4llvm12_GLOBAL__N_116parseGlobalCtorsEPNS_14GlobalVariableE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp -nm=_ZN4llvm12_GLOBAL__N_116parseGlobalCtorsEPNS_14GlobalVariableE")
////</editor-fold>
//public static std.vector<Function /*P*/ > parseGlobalCtors(GlobalVariable /*P*/ GV) {
//  return /*delegate*/org.llvm.transforms.utils.impl.CtorUtilsLlvmStatics.
//    parseGlobalCtors(GV);
//}
//
//
///// Find the llvm.global_ctors list, verifying that all initializers have an
///// init priority of 65535.
////<editor-fold defaultstate="collapsed" desc="llvm::(anonymous namespace)::findGlobalCtors">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp", line = 83,
// FQN="llvm::(anonymous namespace)::findGlobalCtors", NM="_ZN4llvm12_GLOBAL__N_115findGlobalCtorsERNS_6ModuleE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp -nm=_ZN4llvm12_GLOBAL__N_115findGlobalCtorsERNS_6ModuleE")
////</editor-fold>
//public static GlobalVariable /*P*/ findGlobalCtors(final Module /*&*/ M) {
//  return /*delegate*/org.llvm.transforms.utils.impl.CtorUtilsLlvmStatics.
//    findGlobalCtors(M);
//}
//
//
///// \brief Assign a complexity or rank value to LLVM Values.
/////
///// This routine maps IR values to various complexity ranks:
/////   0 -> undef
/////   1 -> Constants
/////   2 -> Other non-instructions
/////   3 -> Arguments
/////   3 -> Unary operations
/////   4 -> Other instructions
////<editor-fold defaultstate="collapsed" desc="llvm::getComplexity">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombineInternal.h", line = 52,
// FQN="llvm::getComplexity", NM="_ZN4llvmL13getComplexityEPNS_5ValueE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombinePHI.cpp -nm=_ZN4llvmL13getComplexityEPNS_5ValueE")
////</editor-fold>
//public static /*inline*/ /*uint*/int getComplexity(Value /*P*/ V) {
//  return /*delegate*/org.llvm.transforms.instcombine.impl.InstCombineInternalLlvmStatics.
//    getComplexity(V);
//}
//
//
///// \brief Add one to a Constant
////<editor-fold defaultstate="collapsed" desc="llvm::AddOne">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombineInternal.h", line = 65,
// FQN="llvm::AddOne", NM="_ZN4llvmL6AddOneEPNS_8ConstantE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombinePHI.cpp -nm=_ZN4llvmL6AddOneEPNS_8ConstantE")
////</editor-fold>
//public static /*inline*/ Constant /*P*/ AddOne(Constant /*P*/ C) {
//  return /*delegate*/org.llvm.transforms.instcombine.impl.InstCombineInternalLlvmStatics.
//    AddOne(C);
//}
//
///// \brief Subtract one from a Constant
////<editor-fold defaultstate="collapsed" desc="llvm::SubOne">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombineInternal.h", line = 69,
// FQN="llvm::SubOne", NM="_ZN4llvmL6SubOneEPNS_8ConstantE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombinePHI.cpp -nm=_ZN4llvmL6SubOneEPNS_8ConstantE")
////</editor-fold>
//public static /*inline*/ Constant /*P*/ SubOne(Constant /*P*/ C) {
//  return /*delegate*/org.llvm.transforms.instcombine.impl.InstCombineInternalLlvmStatics.
//    SubOne(C);
//}
//
//
///// \brief Return true if the specified value is free to invert (apply ~ to).
///// This happens in cases where the ~ can be eliminated.  If WillInvertAllUses
///// is true, work under the assumption that the caller intends to remove all
///// uses of V and only keep uses of ~V.
/////
////<editor-fold defaultstate="collapsed" desc="llvm::IsFreeToInvert">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombineInternal.h", line = 78,
// FQN="llvm::IsFreeToInvert", NM="_ZN4llvmL14IsFreeToInvertEPNS_5ValueEb",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombinePHI.cpp -nm=_ZN4llvmL14IsFreeToInvertEPNS_5ValueEb")
////</editor-fold>
//public static /*inline*/ boolean IsFreeToInvert(Value /*P*/ V, boolean WillInvertAllUses) {
//  return /*delegate*/org.llvm.transforms.instcombine.impl.InstCombineInternalLlvmStatics.
//    IsFreeToInvert(V, WillInvertAllUses);
//}
//
//
///// \brief Returns the OverflowCheckFlavor corresponding to a overflow_with_op
///// intrinsic.
////<editor-fold defaultstate="collapsed" desc="llvm::IntrinsicIDToOverflowCheckFlavor">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombineInternal.h", line = 118,
// FQN="llvm::IntrinsicIDToOverflowCheckFlavor", NM="_ZN4llvmL32IntrinsicIDToOverflowCheckFlavorEj",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstCombinePHI.cpp -nm=_ZN4llvmL32IntrinsicIDToOverflowCheckFlavorEj")
////</editor-fold>
//public static /*inline*/ OverflowCheckFlavor IntrinsicIDToOverflowCheckFlavor(/*uint*/int ID) {
//  return /*delegate*/org.llvm.transforms.instcombine.impl.InstCombineInternalLlvmStatics.
//    IntrinsicIDToOverflowCheckFlavor(ID);
//}
//
//
///// \brief If all arguments of a MemoryPHI are defined by the same incoming
///// argument, return that argument.
////<editor-fold defaultstate="collapsed" desc="llvm::onlySingleValue">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp", line = 595,
// FQN="llvm::onlySingleValue", NM="_ZN4llvmL15onlySingleValueEPNS_9MemoryPhiE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvmL15onlySingleValueEPNS_9MemoryPhiE")
////</editor-fold>
//public static MemoryAccess /*P*/ onlySingleValue(MemoryPhi /*P*/ MP) {
//  return /*delegate*/org.llvm.transforms.utils.impl.MemorySSALlvmStatics.
//    onlySingleValue(MP);
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::LiveOnEntryStr">
//@Converted(kind = Converted.Kind.AUTO,
// source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp", line = 851,
// FQN="llvm::LiveOnEntryStr", NM="_ZN4llvmL14LiveOnEntryStrE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvmL14LiveOnEntryStrE")
////</editor-fold>
//public static /*const*//*char*/byte LiveOnEntryStr[/*12*/] = new$char(12, "liveOnEntry");
////<editor-fold defaultstate="collapsed" desc="llvm::createPAEvalPass">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 33,
// FQN="llvm::createPAEvalPass", NM="_ZN4llvm16createPAEvalPassEv",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARC.cpp -nm=_ZN4llvm16createPAEvalPassEv")
////</editor-fold>
//public static FunctionPass /*P*/ createPAEvalPass() {
//  return /*delegate*/org.llvm.transforms.objcarc.impl.ProvenanceAnalysisEvaluatorLlvmStatics.
//    createPAEvalPass();
//}
//
////<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp", line = 420,
// FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERN12_GLOBAL__N_17BBStateE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERN12_GLOBAL__N_17BBStateE")
////</editor-fold>
//public static raw_ostream /*&*/ $out_raw_ostream_BBState(final raw_ostream /*&*/ OS, final BBState /*&*/ BBInfo)/* __attribute__((unused))*/ {
//  return /*delegate*/org.llvm.transforms.objcarc.impl.ObjCARCOptsLlvmStatics.
//    $out_raw_ostream_BBState(OS, BBInfo);
//}

} // END OF class TransformsLlvmStatics
