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
package org.llvm.transforms.utils;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.built_in.*;
import static org.clank.support.Casts.*;
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.clank.java.std_pair.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.analysis.AAResults;
import org.llvm.analysis.CallGraph;
import org.llvm.analysis.Loop;
import org.llvm.analysis.LoopInfo;
import org.llvm.analysis.ScalarEvolution;
import org.llvm.analysis.target.TargetLibraryInfo;
import org.llvm.ir.*;
import org.llvm.ir.legacy.*;
import org.llvm.pass.FunctionPass;
import org.llvm.transforms.*;
import org.llvm.transforms.java.TransformFunctionPointers.*;
import org.llvm.transforms.ipo.*;
import org.llvm.transforms.utils.*;
import org.llvm.support.yaml.*;
import org.llvm.pass.*;
import org.llvm.target.target.*;
import org.llvm.transforms.java.TransformDummies.*;
import org.llvm.transforms.utils.SymbolRewriter.RewriteDescriptor;


//<editor-fold defaultstate="collapsed" desc="static type TransformsLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.transforms.utils.TransformsLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/BypassSlowDivision.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/DemoteRegToStack.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ExtractGV.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/FlattenCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/FunctionImportUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/GlobalStatus.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnroll.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnrollRuntime.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/PromoteMemoryToRegister.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyIndVar.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SplitModule.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp ${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp ${LLVM_SRC}/llvm/lib/Transforms/Utils/ValueMapper.cpp ${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp -nm=Tpl__ZN4llvm13EmitGEPOffsetEPT_RKNS_10DataLayoutEPNS_4UserEb;_Z4llvm_SanitizerStats_h_Unnamed_enum;_ZN4llvm10FlattenCFGEPNS_10BasicBlockEPNS_9AAResultsE;_ZN4llvm10SplitBlockEPNS_10BasicBlockEPNS_11InstructionEPNS_13DominatorTreeEPNS_8LoopInfoE;_ZN4llvm10UnrollLoopEPNS_4LoopEjjbbbjPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_15AssumptionCacheEb;_ZN4llvm10castToCStrEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEE;_ZN4llvm10emitFWriteEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm10emitMemChrEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm10emitMemCmpEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm10emitStrChrEPNS_5ValueEcRNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE;_ZN4llvm10emitStrCpyEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoENS_9StringRefE;_ZN4llvm10emitStrLenEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm10sinkRegionEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_9AAResultsEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE;_ZN4llvm11CloneModuleEPKNS_6ModuleE;_ZN4llvm11CloneModuleEPKNS_6ModuleERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEE;_ZN4llvm11CloneModuleEPKNS_6ModuleERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_12function_refIFbPKNS_11GlobalValueEEEE;_ZN4llvm11MapMetadataEPKNS_6MDNodeERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm11MapMetadataEPKNS_8MetadataERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm11SimplifyCFGEPNS_10BasicBlockERKNS_19TargetTransformInfoEjPNS_15AssumptionCacheEPNS_15SmallPtrSetImplIS1_EE;_ZN4llvm11SplitModuleESt10unique_ptrINS_6ModuleESt14default_deleteIS1_EEjNS_12function_refIFvS4_EEEb;_ZN4llvm11emitPutCharEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE;_ZN4llvm11emitStrNCmpEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm11emitStrNCpyEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoENS_9StringRefE;_ZN4llvm11getICmpCodeEPKNS_8ICmpInstEb;_ZN4llvm11hoistRegionEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_9AAResultsEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE;_ZN4llvm12getICmpValueEbjPNS_5ValueES1_RNS_7CmpInst9PredicateE;_ZN4llvm12simplifyLoopEPNS_4LoopEPNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_15AssumptionCacheEb;_ZN4llvm13CloneFunctionEPNS_8FunctionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEEPNS_14ClonedCodeInfoE;_ZN4llvm13LowerSwitchIDE;_ZN4llvm13RemapFunctionERNS_8FunctionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm13createGVNPassEb;_ZN4llvm13emitMemCpyChkEPNS_5ValueES1_S1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm14DeleteDeadPHIsEPNS_10BasicBlockEPKNS_17TargetLibraryInfoE;_ZN4llvm14GetIfConditionEPNS_10BasicBlockERS1_S2_;_ZN4llvm14InlineFunctionENS_8CallSiteERNS_18InlineFunctionInfoEPNS_9AAResultsEb;_ZN4llvm14InlineFunctionEPNS_10InvokeInstERNS_18InlineFunctionInfoEPNS_9AAResultsEb;_ZN4llvm14InlineFunctionEPNS_8CallInstERNS_18InlineFunctionInfoEPNS_9AAResultsEb;_ZN4llvm14LoopSimplifyIDE;_ZN4llvm14createLICMPassEv;_ZN4llvm14createSCCPPassEv;_ZN4llvm14createSROAPassEv;_ZN4llvm14expandDivisionEPNS_14BinaryOperatorE;_ZN4llvm15CloneBasicBlockEPKNS_10BasicBlockERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEERKNS_5TwineEPNS_8FunctionEPNS_14ClonedCodeInfoE;_ZN4llvm15DeleteDeadBlockEPNS_10BasicBlockE;_ZN4llvm15LowerDbgDeclareERNS_8FunctionE;_ZN4llvm15PromoteMemToRegENS_8ArrayRefIPNS_10AllocaInstEEERNS_13DominatorTreeEPNS_15AliasSetTrackerEPNS_15AssumptionCacheE;_ZN4llvm15combineMetadataEPNS_11InstructionEPKS0_NS_8ArrayRefIjEE;_ZN4llvm15createLCSSAPassEv;_ZN4llvm15expandRemainderEPNS_14BinaryOperatorE;_ZN4llvm15simplifyLoopIVsEPNS_4LoopEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_8LoopInfoERNS_15SmallVectorImplINS_6WeakVHEEE;_ZN4llvm15upward_defs_endEv;_ZN4llvm16DemotePHIToStackEPNS_7PHINodeEPNS_11InstructionE;_ZN4llvm16DemoteRegToStackERNS_11InstructionEbPS0_;_ZN4llvm16EmitImportsFilesENS_9StringRefES0_RKNS_9StringMapINS1_ISt3mapIyjSt4lessIyESaISt4pairIKyjEEENS_15MallocAllocatorEEESA_EE;_ZN4llvm16RemapInstructionEPNS_11InstructionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm16createIPSCCPPassEv;_ZN4llvm16removeUnwindEdgeEPNS_10BasicBlockE;_ZN4llvm17CloneFunctionIntoEPNS_8FunctionEPKS0_RNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm17GetUnrollMetadataEPNS_6MDNodeENS_9StringRefE;_ZN4llvm17LowerInvokePassIDE;_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockENS_12PredIteratorIS0_NS_5Value18user_iterator_implINS_4UserEEEEERKNS_28CriticalEdgeSplittingOptionsE;_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPS2_S0_EERKNS_28CriticalEdgeSplittingOptionsE;_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockES1_RKNS_28CriticalEdgeSplittingOptionsE;_ZN4llvm17SplitCriticalEdgeEPNS_14TerminatorInstEjRKNS_28CriticalEdgeSplittingOptionsE;_ZN4llvm17createPruneEHPassEv;_ZN4llvm17createSinkingPassEv;_ZN4llvm17internalizeModuleERNS_6ModuleESt8functionIFbRKNS_11GlobalValueEEEPNS_9CallGraphE;_ZN4llvm17replaceDbgDeclareEPNS_5ValueES1_PNS_11InstructionERNS_9DIBuilderEbi;_ZN4llvm17simplifyUsersOfIVEPNS_7PHINodeEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_8LoopInfoERNS_15SmallVectorImplINS_6WeakVHEEEPNS_9IVVisitorE;_ZN4llvm17upward_defs_beginERKSt4pairIPNS_12MemoryAccessENS_14MemoryLocationEE;_ZN4llvm18InstructionNamerIDE;_ZN4llvm18PredicatesFoldableENS_7CmpInst9PredicateES1_;_ZN4llvm18bypassSlowDivisionEPNS_10BasicBlockERKNS_8DenseMapIjjNS_12DenseMapInfoIjEENS_6detail12DenseMapPairIjjEEEE;_ZN4llvm18createEarlyCSEPassEv;_ZN4llvm18createGVNHoistPassEv;_ZN4llvm18isAllocaPromotableEPKNS_10AllocaInstE;_ZN4llvm19ReplaceInstWithInstEPNS_11InstructionES1_;_ZN4llvm19ReplaceInstWithInstERNS_15SymbolTableListINS_11InstructionEEERNS_14ilist_iteratorIS1_EEPS1_;_ZN4llvm19appendToGlobalCtorsERNS_6ModuleEPNS_8FunctionEiPNS_8ConstantE;_ZN4llvm19appendToGlobalDtorsERNS_6ModuleEPNS_8FunctionEiPNS_8ConstantE;_ZN4llvm19callsGCLeafFunctionENS_17ImmutableCallSiteE;_ZN4llvm19changeToUnreachableEPNS_11InstructionEb;_ZN4llvm19createFloat2IntPassEv;_ZN4llvm19createGlobalDCEPassEv;_ZN4llvm19createLoopIdiomPassEv;_ZN4llvm19createMemCpyOptPassEv;_ZN4llvm19nameUnamedFunctionsERNS_6ModuleE;_ZN4llvm19vectorizeBasicBlockEPNS_4PassERNS_10BasicBlockERKNS_15VectorizeConfigE;_ZN4llvm20BreakCriticalEdgesIDE;_ZN4llvm20FindAllocaDbgDeclareEPNS_5ValueE;_ZN4llvm20ReplaceInstWithValueERNS_15SymbolTableListINS_11InstructionEEERNS_14ilist_iteratorIS1_EEPNS_5ValueE;_ZN4llvm20createFlattenCFGPassEv;_ZN4llvm20createLoopRerollPassEv;_ZN4llvm20createLoopRotatePassEi;_ZN4llvm20createLoopUnrollPassEiiii;_ZN4llvm20createObjCARCOptPassEv;_ZN4llvm20createScalarizerPassEv;_ZN4llvm20emitUnaryFloatFnCallEPNS_5ValueENS_9StringRefERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_12AttributeSetE;_ZN4llvm20formLCSSARecursivelyERNS_4LoopERNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionE;_ZN4llvm20getLoopAnalysisUsageERNS_13AnalysisUsageE;_ZN4llvm21SplitAllCriticalEdgesERNS_8FunctionERKNS_28CriticalEdgeSplittingOptionsE;_ZN4llvm21computeLoopSafetyInfoEPNS_14LoopSafetyInfoEPNS_4LoopE;_ZN4llvm21createBBVectorizePassERKNS_15VectorizeConfigE;_ZN4llvm21createBarrierNoopPassEv;_ZN4llvm21createCrossDSOCFIPassEv;_ZN4llvm21createInternalizePassESt8functionIFbRKNS_11GlobalValueEEE;_ZN4llvm21createInternalizePassEv;_ZN4llvm21createLoadCombinePassEv;_ZN4llvm21createLowerAtomicPassEv;_ZN4llvm21createLowerInvokePassEv;_ZN4llvm21createLowerSwitchPassEv;_ZN4llvm21createMetaRenamerPassEv;_ZN4llvm21createReassociatePassEv;_ZN4llvm21emitBinaryFloatFnCallEPNS_5ValueES1_NS_9StringRefERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_12AttributeSetE;_ZN4llvm21isGuaranteedToExecuteERKNS_11InstructionEPKNS_13DominatorTreeEPKNS_4LoopEPKNS_14LoopSafetyInfoE;_ZN4llvm22ConstantFoldTerminatorEPNS_10BasicBlockEbPKNS_17TargetLibraryInfoE;_ZN4llvm22FoldBranchToCommonDestEPNS_10BranchInstEj;_ZN4llvm22InsertPreheaderForLoopEPNS_4LoopEPNS_13DominatorTreeEPNS_8LoopInfoEb;_ZN4llvm22SplitBlockPredecessorsEPNS_10BasicBlockENS_8ArrayRefIS1_EEPKcPNS_13DominatorTreeEPNS_8LoopInfoEb;_ZN4llvm22cloneLoopWithPreheaderEPNS_10BasicBlockES1_PNS_4LoopERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEERKNS_5TwineEPNS_8LoopInfoEPNS_13DominatorTreeERNS_15SmallVectorImplIS1_EE;_ZN4llvm22createGCOVProfilerPassERKNS_11GCOVOptionsE;_ZN4llvm22createGVExtractionPassERSt6vectorIPNS_11GlobalValueESaIS2_EEb;_ZN4llvm22createLoopDeletionPassEv;_ZN4llvm22createLoopSimplifyPassEv;_ZN4llvm22createLoopUnswitchPassEb;_ZN4llvm22createStripSymbolsPassEb;_ZN4llvm22inferLibFuncAttributesERNS_8FunctionERKNS_17TargetLibraryInfoE;_ZN4llvm22renameModuleForThinLTOERNS_6ModuleERKNS_18ModuleSummaryIndexEPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS8_EEEE;_ZN4llvm23FoldSingleEntryPHINodesEPNS_10BasicBlockEPNS_23MemoryDependenceResultsE;_ZN4llvm23InstructionSimplifierIDE;_ZN4llvm23addStringMetadataToLoopEPNS_4LoopEPKcj;_ZN4llvm23createAggressiveDCEPassEv;_ZN4llvm23createAlwaysInlinerPassEb;_ZN4llvm23createAlwaysInlinerPassEv;_ZN4llvm23createConstantMergePassEv;_ZN4llvm23createGuardWideningPassEv;_ZN4llvm23createJumpThreadingPassEi;_ZN4llvm23createLoopExtractorPassEv;_ZN4llvm23createLoopVectorizePassEbb;_ZN4llvm23createObjCARCAPElimPassEv;_ZN4llvm23createObjCARCExpandPassEv;_ZN4llvm23createSLPVectorizerPassEv;_ZN4llvm23isSafeToDestroyConstantEPKNS_8ConstantE;_ZN4llvm23optimizeGlobalCtorsListERNS_6ModuleENS_12function_refIFbPNS_8FunctionEEEE;_ZN4llvm23removeUnreachableBlocksERNS_8FunctionEPNS_13LazyValueInfoE;_ZN4llvm24ComputeCrossModuleImportERKNS_18ModuleSummaryIndexERKNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS6_EEENS_15MallocAllocatorEEERNS3_INS3_IS4_IyjS8_SaIS9_ISA_jEEESE_EESE_EERNS3_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESE_EE;_ZN4llvm24DemoteRegisterToMemoryIDE;_ZN4llvm24PrepareToSplitEntryBlockERNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE;_ZN4llvm24createBitTrackingDCEPassEv;_ZN4llvm24createBlockExtractorPassEv;_ZN4llvm24createBoundsCheckingPassEv;_ZN4llvm24createDeadArgHackingPassEv;_ZN4llvm24createFunctionImportPassEPKNS_18ModuleSummaryIndexE;_ZN4llvm24createIndVarSimplifyPassEv;_ZN4llvm24createLoopDistributePassEb;_ZN4llvm24createLoopVersioningPassEv;_ZN4llvm24createLowerTypeTestsPassEv;_ZN4llvm24createMergeFunctionsPassEv;_ZN4llvm24createRewriteSymbolsPassERNS_6iplistINS_14SymbolRewriter17RewriteDescriptorENS_12ilist_traitsIS2_EEEE;_ZN4llvm24createRewriteSymbolsPassEv;_ZN4llvm24createStructurizeCFGPassEb;_ZN4llvm24expandDivisionUpTo32BitsEPNS_14BinaryOperatorE;_ZN4llvm24expandDivisionUpTo64BitsEPNS_14BinaryOperatorE;_ZN4llvm24formLCSSAForInstructionsERNS_15SmallVectorImplIPNS_11InstructionEEERNS_13DominatorTreeERNS_8LoopInfoE;_ZN4llvm24replaceDbgValueForAllocaEPNS_10AllocaInstEPNS_5ValueERNS_9DIBuilderEi;_ZN4llvm24replaceDominatedUsesWithEPNS_5ValueES1_RNS_13DominatorTreeEPKNS_10BasicBlockE;_ZN4llvm24replaceDominatedUsesWithEPNS_5ValueES1_RNS_13DominatorTreeERKNS_14BasicBlockEdgeE;_ZN4llvm24thinLTOInternalizeModuleERNS_6ModuleERKSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE;_ZN4llvm25CloneAndPruneFunctionIntoEPNS_8FunctionEPKS0_RNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoEPNS_11InstructionE;_ZN4llvm25CloneAndPruneIntoFromInstEPNS_8FunctionEPKS0_PKNS_11InstructionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigISA_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoE;_ZN4llvm25MergeBlockIntoPredecessorEPNS_10BasicBlockEPNS_13DominatorTreeEPNS_8LoopInfoEPNS_23MemoryDependenceResultsE;_ZN4llvm25SplitBlockAndInsertIfThenEPNS_5ValueEPNS_11InstructionEbPNS_6MDNodeEPNS_13DominatorTreeEPNS_8LoopInfoE;_ZN4llvm25createGlobalOptimizerPassEv;_ZN4llvm25createLoopInterchangePassEv;_ZN4llvm25createLoopSimplifyCFGPassEv;_ZN4llvm25createMemorySanitizerPassEi;_ZN4llvm25createNaryReassociatePassEv;_ZN4llvm25createObjCARCContractPassEv;_ZN4llvm25createPartialInliningPassEv;_ZN4llvm25createPlaceSafepointsPassEv;_ZN4llvm25createThreadSanitizerPassEv;_ZN4llvm25expandRemainderUpTo32BitsEPNS_14BinaryOperatorE;_ZN4llvm25expandRemainderUpTo64BitsEPNS_14BinaryOperatorE;_ZN4llvm25findDefsUsedOutsideOfLoopEPNS_4LoopE;_ZN4llvm25findStringMetadataForLoopEPNS_4LoopENS_9StringRefE;_ZN4llvm25remapInstructionsInBlocksERKNS_15SmallVectorImplIPNS_10BasicBlockEEERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS9_NS_3sys10SmartMutexILb0EEEEEEE;_ZN4llvm26EliminateDuplicatePHINodesEPNS_10BasicBlockE;_ZN4llvm26FoldReturnIntoUncondBranchEPNS_10ReturnInstEPNS_10BasicBlockES3_;_ZN4llvm26UnrollRuntimeLoopRemainderEPNS_4LoopEjbbPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_13DominatorTreeEb;_ZN4llvm26createConstantHoistingPassEv;_ZN4llvm26createFunctionInliningPassEi;_ZN4llvm26createFunctionInliningPassEjj;_ZN4llvm26createFunctionInliningPassEv;_ZN4llvm26createInstructionNamerPassEv;_ZN4llvm26createLoopDataPrefetchPassEv;_ZN4llvm26createLoopInstSimplifyPassEv;_ZN4llvm26createNameAnonFunctionPassEv;_ZN4llvm26createSimpleLoopUnrollPassEv;_ZN4llvm26getOrEnforceKnownAlignmentEPNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPNS_15AssumptionCacheEPKNS_13DominatorTreeE;_ZN4llvm26isInstructionTriviallyDeadEPNS_11InstructionEPKNS_17TargetLibraryInfoE;_ZN4llvm26replaceDbgDeclareForAllocaEPNS_10AllocaInstEPNS_5ValueERNS_9DIBuilderEbi;_ZN4llvm27ComputeASanStackFrameLayoutERNS_15SmallVectorImplINS_28ASanStackVariableDescriptionEEEjjPNS_20ASanStackFrameLayoutE;_ZN4llvm27MergeBasicBlockIntoOnlyPredEPNS_10BasicBlockEPNS_13DominatorTreeE;_ZN4llvm27SimplifyInstructionsInBlockEPNS_10BasicBlockEPKNS_17TargetLibraryInfoE;_ZN4llvm27SplitLandingPadPredecessorsEPNS_10BasicBlockENS_8ArrayRefIS1_EEPKcS5_RNS_15SmallVectorImplIS1_EEPNS_13DominatorTreeEPNS_8LoopInfoEb;_ZN4llvm27createAddDiscriminatorsPassEv;_ZN4llvm27createArgumentPromotionPassEj;_ZN4llvm27createCFGSimplificationPassEiSt8functionIFbRKNS_8FunctionEEE;_ZN4llvm27createDataFlowSanitizerPassERKSt6vectorISsSaISsEEPFPvvES7_;_ZN4llvm27createStripDebugDeclarePassEv;_ZN4llvm28RecursivelyDeleteDeadPHINodeEPNS_7PHINodeEPKNS_17TargetLibraryInfoE;_ZN4llvm28RemovePredecessorAndSimplifyEPNS_10BasicBlockES1_;_ZN4llvm28createBreakCriticalEdgesPassEv;_ZN4llvm28createDeadArgEliminationPassEv;_ZN4llvm28createLoopStrengthReducePassEv;_ZN4llvm28createLoopVersioningLICMPassEv;_ZN4llvm28createStripDeadDebugInfoPassEv;_ZN4llvm28createWholeProgramDevirtPassEv;_ZN4llvm28promoteLoopAccessesToScalarsERNS_8AliasSetERNS_15SmallVectorImplIPNS_10BasicBlockEEERNS2_IPNS_11InstructionEEERNS_17PredIteratorCacheEPNS_8LoopInfoEPNS_13DominatorTreeEPKNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE;_ZN4llvm29SplitBlockAndInsertIfThenElseEPNS_5ValueEPNS_11InstructionEPPNS_14TerminatorInstES6_PNS_6MDNodeE;_ZN4llvm29createConstantPropagationPassEv;_ZN4llvm29createDeadCodeEliminationPassEv;_ZN4llvm29createDeadInstEliminationPassEv;_ZN4llvm29createEfficiencySanitizerPassERKNS_26EfficiencySanitizerOptionsE;_ZN4llvm29createLoadStoreVectorizerPassEv;_ZN4llvm29createLoopLoadEliminationPassEv;_ZN4llvm29createLowerGuardIntrinsicPassEv;_ZN4llvm29createSampleProfileLoaderPassENS_9StringRefE;_ZN4llvm29createSampleProfileLoaderPassEv;_ZN4llvm29createSingleLoopExtractorPassEv;_ZN4llvm29createStripDeadPrototypesPassEv;_ZN4llvm29createTailCallEliminationPassEv;_ZN4llvm30createDeadStoreEliminationPassEv;_ZN4llvm30createInstrProfilingLegacyPassERKNS_16InstrProfOptionsE;_ZN4llvm30createInstructionCombiningPassEb;_ZN4llvm30createLowerExpectIntrinsicPassEv;_ZN4llvm30createSpeculativeExecutionPassEv;_ZN4llvm30createStripNonDebugSymbolsPassEv;_ZN4llvm31ConvertDebugDeclareToDebugValueEPNS_14DbgDeclareInstEPNS_8LoadInstERNS_9DIBuilderE;_ZN4llvm31ConvertDebugDeclareToDebugValueEPNS_14DbgDeclareInstEPNS_9StoreInstERNS_9DIBuilderE;_ZN4llvm31checkSanitizerInterfaceFunctionEPNS_8ConstantE;_ZN4llvm31createIPConstantPropagationPassEv;_ZN4llvm31createInstructionSimplifierPassEv;_ZN4llvm31createMergedLoadStoreMotionPassEv;_ZN4llvm31recognizeBSwapOrBitReverseIdiomEPNS_11InstructionEbbRNS_15SmallVectorImplIS1_EE;_ZN4llvm32createAddressSanitizerModulePassEbb;_ZN4llvm32createDemoteRegisterToMemoryPassEv;_ZN4llvm32createUnifyFunctionExitNodesPassEv;_ZN4llvm32gatherImportedSummariesForModuleENS_9StringRefERKNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEENS_15MallocAllocatorEEERKNS1_INS1_IS2_IyjS6_SaIS7_IS8_jEEESC_EESC_EERS2_ISsSB_S5_ISsESaIS7_IKSsSB_EEE;_ZN4llvm33ComputeCrossModuleImportForModuleENS_9StringRefERKNS_18ModuleSummaryIndexERNS_9StringMapISt3mapIyjSt4lessIyESaISt4pairIKyjEEENS_15MallocAllocatorEEE;_ZN4llvm33createPartiallyInlineLibCallsPassEv;_ZN4llvm33createPromoteMemoryToRegisterPassEv;_ZN4llvm33createRewriteStatepointsForGCPassEv;_ZN4llvm33createSanitizerCoverageModulePassERKNS_24SanitizerCoverageOptionsE;_ZN4llvm33thinLTOResolveWeakForLinkerModuleERNS_6ModuleERKSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE;_ZN4llvm34createAddressSanitizerFunctionPassEbbb;_ZN4llvm34createAlignmentFromAssumptionsPassEv;_ZN4llvm34createForceFunctionAttrsLegacyPassEv;_ZN4llvm34createInferFunctionAttrsLegacyPassEv;_ZN4llvm35createSanitizerCtorAndInitFunctionsERNS_6ModuleENS_9StringRefES2_NS_8ArrayRefIPNS_4TypeEEENS3_IPNS_5ValueEEES2_;_ZN4llvm36createCorrelatedValuePropagationPassEv;_ZN4llvm36createSeparateConstOffsetFromGEPPassEPKNS_13TargetMachineEb;_ZN4llvm36createStraightLineStrengthReducePassEv;_ZN4llvm37createPGOInstrumentationGenLegacyPassEv;_ZN4llvm37createPGOInstrumentationUseLegacyPassENS_9StringRefE;_ZN4llvm38createEliminateAvailableExternallyPassEv;_ZN4llvm38createPostOrderFunctionAttrsLegacyPassEv;_ZN4llvm38maybeMarkSanitizerLibraryCallNoBuiltinEPNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvm39TryToSimplifyUncondBranchFromEmptyBlockEPNS_10BasicBlockE;_ZN4llvm39createReversePostOrderFunctionAttrsPassEv;_ZN4llvm40createInductiveRangeCheckEliminationPassEv;_ZN4llvm40createPGOIndirectCallPromotionLegacyPassEb;_ZN4llvm42RecursivelyDeleteTriviallyDeadInstructionsEPNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm42removeAllNonTerminatorAndEHPadInstructionsEPNS_10BasicBlockE;_ZN4llvm51createSpeculativeExecutionIfHasBranchDivergencePassEv;_ZN4llvm7LCSSAIDE;_ZN4llvm8MapValueEPKNS_5ValueERNS_8ValueMapIS2_NS_6WeakVHENS_14ValueMapConfigIS2_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm8MapValueEPKNS_8ConstantERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE;_ZN4llvm8emitPutSEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE;_ZN4llvm9SplitEdgeEPNS_10BasicBlockES1_PNS_13DominatorTreeEPNS_8LoopInfoE;_ZN4llvm9emitFPutCEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE;_ZN4llvm9emitFPutSEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE;_ZN4llvm9formLCSSAERNS_4LoopERNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionE;_ZN4llvmL16scaleBranchCountEyy;_ZN4llvmL17getKnownAlignmentEPNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPNS_15AssumptionCacheEPKNS_13DominatorTreeE;_ZN4llvmL19calculateCountScaleEy;_ZN4llvmL25kAsanStackMidRedzoneMagicE;_ZN4llvmL26kAsanStackLeftRedzoneMagicE;_ZN4llvmL27kAsanStackRightRedzoneMagicE;_ZN4llvmlsERNS_11raw_ostreamERKNS_12MemoryAccessE;_ZN4llvmorENS_10RemapFlagsES0_; -static-type=TransformsLlvmGlobals -package=org.llvm.transforms.utils")
//</editor-fold>
public final class TransformsLlvmGlobals {


//===----------------------------------------------------------------------===//
//
// AggressiveDCE - This pass uses the SSA based Aggressive DCE algorithm.  This
// algorithm assumes instructions are dead until proven otherwise, which makes
// it more successful are removing non-obviously dead instructions.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createAggressiveDCEPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 182,
 FQN="llvm::createAggressiveDCEPass", NM="_ZN4llvm23createAggressiveDCEPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm23createAggressiveDCEPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createAggressiveDCEPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ADCELlvmGlobals.
  //    createAggressiveDCEPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// These magic constants should be the same as in
// in asan_internal.h from ASan runtime in compiler-rt.
//<editor-fold defaultstate="collapsed" desc="llvm::kAsanStackLeftRedzoneMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ASanStackFrameLayout.h", line = 24,
 FQN="llvm::kAsanStackLeftRedzoneMagic", NM="_ZN4llvmL26kAsanStackLeftRedzoneMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvmL26kAsanStackLeftRedzoneMagicE")
//</editor-fold>
public static /*const*/int kAsanStackLeftRedzoneMagic = 0xf1;
//<editor-fold defaultstate="collapsed" desc="llvm::kAsanStackMidRedzoneMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ASanStackFrameLayout.h", line = 25,
 FQN="llvm::kAsanStackMidRedzoneMagic", NM="_ZN4llvmL25kAsanStackMidRedzoneMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvmL25kAsanStackMidRedzoneMagicE")
//</editor-fold>
public static /*const*/int kAsanStackMidRedzoneMagic = 0xf2;
//<editor-fold defaultstate="collapsed" desc="llvm::kAsanStackRightRedzoneMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ASanStackFrameLayout.h", line = 26,
 FQN="llvm::kAsanStackRightRedzoneMagic", NM="_ZN4llvmL27kAsanStackRightRedzoneMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvmL27kAsanStackRightRedzoneMagicE")
//</editor-fold>
public static /*const*/int kAsanStackRightRedzoneMagic = 0xf3;
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeASanStackFrameLayout">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp", line = 50,
 FQN="llvm::ComputeASanStackFrameLayout", NM="_ZN4llvm27ComputeASanStackFrameLayoutERNS_15SmallVectorImplINS_28ASanStackVariableDescriptionEEEjjPNS_20ASanStackFrameLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ASanStackFrameLayout.cpp -nm=_ZN4llvm27ComputeASanStackFrameLayoutERNS_15SmallVectorImplINS_28ASanStackVariableDescriptionEEEjjPNS_20ASanStackFrameLayoutE")
//</editor-fold>
public static void ComputeASanStackFrameLayout(final SmallVectorImpl<ASanStackVariableDescription> /*&*/ Vars, 
                           /*size_t*/int Granularity, /*size_t*/int MinHeaderSize, 
                           ASanStackFrameLayout /*P*/ Layout) {
  //  /*delegate*/org.llvm.transforms.utils.impl.ASanStackFrameLayoutLlvmGlobals.
  //    ComputeASanStackFrameLayout(Vars, 
  //                           Granularity, MinHeaderSize, 
 //                           Layout);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// AddDiscriminators - Add DWARF path discriminators to the IR.

// Create the legacy AddDiscriminatorsPass.
//<editor-fold defaultstate="collapsed" desc="llvm::createAddDiscriminatorsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 103,
 FQN="llvm::createAddDiscriminatorsPass", NM="_ZN4llvm27createAddDiscriminatorsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZN4llvm27createAddDiscriminatorsPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createAddDiscriminatorsPass() {
    return /*delegate*/org.llvm.transforms.impl.AddDiscriminatorsLlvmGlobals.
      createAddDiscriminatorsPass();
}


// Insert AddressSanitizer (address sanity checking) instrumentation
//<editor-fold defaultstate="collapsed" desc="llvm::createAddressSanitizerFunctionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp", line = 813,
 FQN="llvm::createAddressSanitizerFunctionPass", NM="_ZN4llvm34createAddressSanitizerFunctionPassEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm34createAddressSanitizerFunctionPassEbbb")
//</editor-fold>
public static FunctionPass /*P*/ createAddressSanitizerFunctionPass() {
  //  return createAddressSanitizerFunctionPass(false, 
  //                                  false, 
  //                                  false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createAddressSanitizerFunctionPass(boolean CompileKernel/*= false*/) {
  //  return createAddressSanitizerFunctionPass(CompileKernel, 
  //                                  false, 
  //                                  false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createAddressSanitizerFunctionPass(boolean CompileKernel/*= false*/, 
                                  boolean Recover/*= false*/) {
  //  return createAddressSanitizerFunctionPass(CompileKernel, 
  //                                  Recover, 
  //                                  false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createAddressSanitizerFunctionPass(boolean CompileKernel/*= false*/, 
                                  boolean Recover/*= false*/, 
                                  boolean UseAfterScope/*= false*/) {
  //  return /*delegate*/org.llvm.transforms.impl.AddressSanitizerLlvmGlobals.
  //    createAddressSanitizerFunctionPass(CompileKernel, 
  //                                  Recover, 
 //                                  UseAfterScope);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createAddressSanitizerModulePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp", line = 826,
 FQN="llvm::createAddressSanitizerModulePass", NM="_ZN4llvm32createAddressSanitizerModulePassEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm32createAddressSanitizerModulePassEbb")
//</editor-fold>
public static ModulePass /*P*/ createAddressSanitizerModulePass() {
  //  return createAddressSanitizerModulePass(false, 
  //                                false);
  //}
 //public static ModulePass /*P*/ createAddressSanitizerModulePass(boolean CompileKernel/*= false*/) {
  // //  return createAddressSanitizerModulePass(CompileKernel, 
  // //                                false);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}
public static ModulePass /*P*/ createAddressSanitizerModulePass(boolean CompileKernel/*= false*/, 
                                boolean Recover/*= false*/) {
  //  return /*delegate*/org.llvm.transforms.impl.AddressSanitizerLlvmGlobals.
  //    createAddressSanitizerModulePass(CompileKernel, 
  //                                Recover);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Calculate what to divide by to scale counts.
///
/// Given the maximum count, calculate a divisor that will scale all the
/// weights to strictly less than UINT32_MAX.
//<editor-fold defaultstate="collapsed" desc="llvm::calculateCountScale">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 174,
 FQN="llvm::calculateCountScale", NM="_ZN4llvmL19calculateCountScaleEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvmL19calculateCountScaleEy")
//</editor-fold>
public static /*inline*/ long/*uint64_t*/ calculateCountScale(long/*uint64_t*/ MaxCount) {
  //  return /*delegate*/org.llvm.transforms.impl.InstrumentationLlvmGlobals.
  //    calculateCountScale(MaxCount);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Scale an individual branch count.
///
/// Scale a 64-bit weight down to 32-bits using \c Scale.
///
//<editor-fold defaultstate="collapsed" desc="llvm::scaleBranchCount">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Instrumentation.h", line = 182,
 FQN="llvm::scaleBranchCount", NM="_ZN4llvmL16scaleBranchCountEyy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvmL16scaleBranchCountEyy")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int scaleBranchCount(long/*uint64_t*/ Count, long/*uint64_t*/ Scale) {
  //  return /*delegate*/org.llvm.transforms.impl.InstrumentationLlvmGlobals.
  //    scaleBranchCount(Count, Scale);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::SplitCriticalEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/BasicBlockUtils.h", line = 125,
 FQN="llvm::SplitCriticalEdge", NM="_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPS2_S0_EERKNS_28CriticalEdgeSplittingOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockENS_14TerminatorInst12SuccIteratorIPS2_S0_EERKNS_28CriticalEdgeSplittingOptionsE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ SplitCriticalEdge(BasicBlock /*P*/ BB, TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> SI) {
  //  return SplitCriticalEdge(BB, SI, 
  //                 new CriticalEdgeSplittingOptions());
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ BasicBlock /*P*/ SplitCriticalEdge(BasicBlock /*P*/ BB, TerminatorInst.SuccIterator<TerminatorInst /*P*/ , BasicBlock> SI, 
                 final /*const*/ CriticalEdgeSplittingOptions /*&*/ Options/*= CriticalEdgeSplittingOptions()*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitCriticalEdge(BB, SI, 
  //                 Options);
  throw new UnsupportedOperationException("EmptyBody");
}


/// If the edge from *PI to BB is not critical, return false. Otherwise, split
/// all edges between the two blocks and return true. This updates all of the
/// same analyses as the other SplitCriticalEdge function. If P is specified, it
/// updates the analyses described above.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitCriticalEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/BasicBlockUtils.h", line = 137,
 FQN="llvm::SplitCriticalEdge", NM="_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockENS_12PredIteratorIS0_NS_5Value18user_iterator_implINS_4UserEEEEERKNS_28CriticalEdgeSplittingOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockENS_12PredIteratorIS0_NS_5Value18user_iterator_implINS_4UserEEEEERKNS_28CriticalEdgeSplittingOptionsE")
//</editor-fold>
public static /*inline*/ boolean SplitCriticalEdge(BasicBlock /*P*/ Succ, PredIterator<BasicBlock, Value.user_iterator_impl<User> > PI) {
  //  return SplitCriticalEdge(Succ, PI, 
  //                 new CriticalEdgeSplittingOptions());
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ boolean SplitCriticalEdge(BasicBlock /*P*/ Succ, PredIterator<BasicBlock, Value.user_iterator_impl<User> > PI, 
                 final /*const*/ CriticalEdgeSplittingOptions /*&*/ Options/*= CriticalEdgeSplittingOptions()*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitCriticalEdge(Succ, PI, 
  //                 Options);
  throw new UnsupportedOperationException("EmptyBody");
}


/// If an edge from Src to Dst is critical, split the edge and return true,
/// otherwise return false. This method requires that there be an edge between
/// the two blocks. It updates the analyses passed in the options struct
//<editor-fold defaultstate="collapsed" desc="llvm::SplitCriticalEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/BasicBlockUtils.h", line = 151,
 FQN="llvm::SplitCriticalEdge", NM="_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockES1_RKNS_28CriticalEdgeSplittingOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm17SplitCriticalEdgeEPNS_10BasicBlockES1_RKNS_28CriticalEdgeSplittingOptionsE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ SplitCriticalEdge(BasicBlock /*P*/ Src, BasicBlock /*P*/ Dst) {
  //  return SplitCriticalEdge(Src, Dst, 
  //                 new CriticalEdgeSplittingOptions());
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ BasicBlock /*P*/ SplitCriticalEdge(BasicBlock /*P*/ Src, BasicBlock /*P*/ Dst, 
                 final /*const*/ CriticalEdgeSplittingOptions /*&*/ Options/*= CriticalEdgeSplittingOptions()*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitCriticalEdge(Src, Dst, 
  //                 Options);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator|">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 91,
 FQN="llvm::operator|", NM="_ZN4llvmorENS_10RemapFlagsES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvmorENS_10RemapFlagsES0_")
//</editor-fold>
public static /*inline*/ RemapFlags $bitor_RemapFlags(RemapFlags LHS, RemapFlags RHS) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
  //    $bitor_RemapFlags(LHS, RHS);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Look up or compute a value in the value map.
///
/// Return a mapped value for a function-local value (Argument, Instruction,
/// BasicBlock), or compute and memoize a value for a Constant.
///
///  1. If \c V is in VM, return the result.
///  2. Else if \c V can be materialized with \c Materializer, do so, memoize
///     it in \c VM, and return it.
///  3. Else if \c V is a function-local value, return nullptr.
///  4. Else if \c V is a \a GlobalValue, return \c nullptr or \c V depending
///     on \a RF_NullMapMissingGlobalValues.
///  5. Else if \c V is a \a MetadataAsValue wrapping a LocalAsMetadata,
///     recurse on the local SSA value, and return nullptr or "metadata !{}" on
///     missing depending on RF_IgnoreMissingValues.
///  6. Else if \c V is a \a MetadataAsValue, rewrap the return of \a
///     MapMetadata().
///  7. Else, compute the equivalent constant, and return it.
//<editor-fold defaultstate="collapsed" desc="llvm::MapValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 198,
 FQN="llvm::MapValue", NM="_ZN4llvm8MapValueEPKNS_5ValueERNS_8ValueMapIS2_NS_6WeakVHENS_14ValueMapConfigIS2_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm8MapValueEPKNS_5ValueERNS_8ValueMapIS2_NS_6WeakVHENS_14ValueMapConfigIS2_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static /*inline*/ Value /*P*/ MapValue(/*const*/ Value /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
  //  return MapValue(V, VM, 
  //        RemapFlags.RF_None, 
  //        (ValueMapTypeRemapper /*P*/ )null, 
 //        (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Value /*P*/ MapValue(/*const*/ Value /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
        RemapFlags Flags/*= RF_None*/) {
  //  return MapValue(V, VM, 
  //        Flags, 
  //        (ValueMapTypeRemapper /*P*/ )null, 
 //        (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Value /*P*/ MapValue(/*const*/ Value /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
        RemapFlags Flags/*= RF_None*/, 
        ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  //  return MapValue(V, VM, 
  //        Flags, 
  //        TypeMapper, 
 //        (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Value /*P*/ MapValue(/*const*/ Value /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
        RemapFlags Flags/*= RF_None*/, 
        ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
        ValueMaterializer /*P*/ Materializer/*= null*/) {
 //  return /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
 //    MapValue(V, VM, 
 //        Flags, 
 //        TypeMapper, 
 //        Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Lookup or compute a mapping for a piece of metadata.
///
/// Compute and memoize a mapping for \c MD.
///
///  1. If \c MD is mapped, return it.
///  2. Else if \a RF_NoModuleLevelChanges or \c MD is an \a MDString, return
///     \c MD.
///  3. Else if \c MD is a \a ConstantAsMetadata, call \a MapValue() and
///     re-wrap its return (returning nullptr on nullptr).
///  4. Else, \c MD is an \a MDNode.  These are remapped, along with their
///     transitive operands.  Distinct nodes are duplicated or moved depending
///     on \a RF_MoveDistinctNodes.  Uniqued nodes are remapped like constants.
///
/// \note \a LocalAsMetadata is completely unsupported by \a MapMetadata.
/// Instead, use \a MapValue() with its wrapping \a MetadataAsValue instance.
//<editor-fold defaultstate="collapsed" desc="llvm::MapMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 220,
 FQN="llvm::MapMetadata", NM="_ZN4llvm11MapMetadataEPKNS_8MetadataERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm11MapMetadataEPKNS_8MetadataERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static /*inline*/ Metadata /*P*/ MapMetadata(/*const*/ Metadata /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
  //  return MapMetadata(MD, VM, 
  //           RemapFlags.RF_None, 
  //           (ValueMapTypeRemapper /*P*/ )null, 
 //           (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Metadata /*P*/ MapMetadata(/*const*/ Metadata /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
           RemapFlags Flags/*= RF_None*/) {
  //  return MapMetadata(MD, VM, 
  //           Flags, 
  //           (ValueMapTypeRemapper /*P*/ )null, 
 //           (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Metadata /*P*/ MapMetadata(/*const*/ Metadata /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
           RemapFlags Flags/*= RF_None*/, 
           ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  //  return MapMetadata(MD, VM, 
  //           Flags, 
  //           TypeMapper, 
 //           (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Metadata /*P*/ MapMetadata(/*const*/ Metadata /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
           RemapFlags Flags/*= RF_None*/, 
           ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
           ValueMaterializer /*P*/ Materializer/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
  //    MapMetadata(MD, VM, 
  //           Flags, 
 //           TypeMapper, 
 //           Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Version of MapMetadata with type safety for MDNode.
//<editor-fold defaultstate="collapsed" desc="llvm::MapMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 228,
 FQN="llvm::MapMetadata", NM="_ZN4llvm11MapMetadataEPKNS_6MDNodeERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm11MapMetadataEPKNS_6MDNodeERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static /*inline*/ MDNode /*P*/ MapMetadata(/*const*/ MDNode /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
  //  return MapMetadata(MD, VM, 
  //           RemapFlags.RF_None, 
  //           (ValueMapTypeRemapper /*P*/ )null, 
 //           (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ MDNode /*P*/ MapMetadata(/*const*/ MDNode /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
           RemapFlags Flags/*= RF_None*/) {
  //  return MapMetadata(MD, VM, 
  //           Flags, 
  //           (ValueMapTypeRemapper /*P*/ )null, 
 //           (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ MDNode /*P*/ MapMetadata(/*const*/ MDNode /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
           RemapFlags Flags/*= RF_None*/, 
           ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  //  return MapMetadata(MD, VM, 
  //           Flags, 
  //           TypeMapper, 
 //           (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ MDNode /*P*/ MapMetadata(/*const*/ MDNode /*P*/ MD, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
           RemapFlags Flags/*= RF_None*/, 
           ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
           ValueMaterializer /*P*/ Materializer/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
  //    MapMetadata(MD, VM, 
  //           Flags, 
 //           TypeMapper, 
 //           Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Convert the instruction operands from referencing the current values into
/// those specified by VM.
///
/// If \a RF_IgnoreMissingLocals is set and an operand can't be found via \a
/// MapValue(), use the old value.  Otherwise assert that this doesn't happen.
///
/// Note that \a MapValue() only returns \c nullptr for SSA values missing from
/// \c VM.
//<editor-fold defaultstate="collapsed" desc="llvm::RemapInstruction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 243,
 FQN="llvm::RemapInstruction", NM="_ZN4llvm16RemapInstructionEPNS_11InstructionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm16RemapInstructionEPNS_11InstructionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static /*inline*/ void RemapInstruction(Instruction /*P*/ I, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
  //  RemapInstruction(I, VM, 
  //                RemapFlags.RF_None, 
  //                (ValueMapTypeRemapper /*P*/ )null, 
 //                (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ void RemapInstruction(Instruction /*P*/ I, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
                RemapFlags Flags/*= RF_None*/) {
  //  RemapInstruction(I, VM, 
  //                Flags, 
  //                (ValueMapTypeRemapper /*P*/ )null, 
 //                (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ void RemapInstruction(Instruction /*P*/ I, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
                RemapFlags Flags/*= RF_None*/, 
                ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  //  RemapInstruction(I, VM, 
  //                Flags, 
  //                TypeMapper, 
 //                (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ void RemapInstruction(Instruction /*P*/ I, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
                RemapFlags Flags/*= RF_None*/, 
                ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
                ValueMaterializer /*P*/ Materializer/*= null*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
  //    RemapInstruction(I, VM, 
  //                Flags, 
 //                TypeMapper, 
 //                Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Remap the operands, metadata, arguments, and instructions of a function.
///
/// Calls \a MapValue() on prefix data, prologue data, and personality
/// function; calls \a MapMetadata() on each attached MDNode; remaps the
/// argument types using the provided \c TypeMapper; and calls \a
/// RemapInstruction() on every instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::RemapFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 256,
 FQN="llvm::RemapFunction", NM="_ZN4llvm13RemapFunctionERNS_8FunctionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm13RemapFunctionERNS_8FunctionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static /*inline*/ void RemapFunction(final Function /*&*/ F, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
  //  RemapFunction(F, VM, 
  //             RemapFlags.RF_None, 
  //             (ValueMapTypeRemapper /*P*/ )null, 
 //             (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ void RemapFunction(final Function /*&*/ F, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
             RemapFlags Flags/*= RF_None*/) {
  //  RemapFunction(F, VM, 
  //             Flags, 
  //             (ValueMapTypeRemapper /*P*/ )null, 
 //             (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ void RemapFunction(final Function /*&*/ F, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
             RemapFlags Flags/*= RF_None*/, 
             ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  //  RemapFunction(F, VM, 
  //             Flags, 
  //             TypeMapper, 
 //             (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ void RemapFunction(final Function /*&*/ F, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
             RemapFlags Flags/*= RF_None*/, 
             ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
             ValueMaterializer /*P*/ Materializer/*= null*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
  //    RemapFunction(F, VM, 
  //             Flags, 
 //             TypeMapper, 
 //             Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Version of MapValue with type safety for Constant.
//<editor-fold defaultstate="collapsed" desc="llvm::MapValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/ValueMapper.h", line = 264,
 FQN="llvm::MapValue", NM="_ZN4llvm8MapValueEPKNS_8ConstantERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm8MapValueEPKNS_8ConstantERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_10RemapFlagsEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static /*inline*/ Constant /*P*/ MapValue(/*const*/ Constant /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM) {
  //  return MapValue(V, VM, 
  //        RemapFlags.RF_None, 
  //        (ValueMapTypeRemapper /*P*/ )null, 
 //        (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Constant /*P*/ MapValue(/*const*/ Constant /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
        RemapFlags Flags/*= RF_None*/) {
  //  return MapValue(V, VM, 
  //        Flags, 
  //        (ValueMapTypeRemapper /*P*/ )null, 
 //        (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Constant /*P*/ MapValue(/*const*/ Constant /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
        RemapFlags Flags/*= RF_None*/, 
        ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  //  return MapValue(V, VM, 
  //        Flags, 
  //        TypeMapper, 
 //        (ValueMaterializer /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ Constant /*P*/ MapValue(/*const*/ Constant /*P*/ V, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VM, 
        RemapFlags Flags/*= RF_None*/, 
        ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
        ValueMaterializer /*P*/ Materializer/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.ValueMapperLlvmGlobals.
  //    MapValue(V, VM, 
  //        Flags, 
 //        TypeMapper, 
 //        Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Try to infer an alignment for the specified pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::getKnownAlignment">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/Local.h", line = 175,
 FQN="llvm::getKnownAlignment", NM="_ZN4llvmL17getKnownAlignmentEPNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPNS_15AssumptionCacheEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvmL17getKnownAlignmentEPNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPNS_15AssumptionCacheEPKNS_13DominatorTreeE")
//</editor-fold>
public static /*inline*/ /*uint*/int getKnownAlignment(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  //  return getKnownAlignment(V, DL, 
  //                 (/*const*/ Instruction /*P*/ )null, 
  //                 (AssumptionCache /*P*/ )null, 
 //                 (/*const*/ DominatorTree /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ /*uint*/int getKnownAlignment(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  //  return getKnownAlignment(V, DL, 
  //                 CxtI, 
  //                 (AssumptionCache /*P*/ )null, 
 //                 (/*const*/ DominatorTree /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ /*uint*/int getKnownAlignment(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                 AssumptionCache /*P*/ AC/*= null*/) {
  //  return getKnownAlignment(V, DL, 
  //                 CxtI, 
  //                 AC, 
 //                 (/*const*/ DominatorTree /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ /*uint*/int getKnownAlignment(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, 
                 /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                 AssumptionCache /*P*/ AC/*= null*/, 
                 /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    getKnownAlignment(V, DL, 
  //                 CxtI, 
 //                 AC, 
 //                 DT);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given a getelementptr instruction/constantexpr, emit the code necessary to
/// compute the offset from the base pointer (without adding in the base
/// pointer). Return the result as a signed integer of intptr size.
/// When NoAssumptions is true, no assumptions about index computation not
/// overflowing is made.
/*template <typename IRBuilderTy> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::EmitGEPOffset">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/Local.h", line = 188,
 FQN="llvm::EmitGEPOffset", NM="Tpl__ZN4llvm13EmitGEPOffsetEPT_RKNS_10DataLayoutEPNS_4UserEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=Tpl__ZN4llvm13EmitGEPOffsetEPT_RKNS_10DataLayoutEPNS_4UserEb")
//</editor-fold>
public static </*typename*/ IRBuilderTy> Value /*P*/ EmitGEPOffset(IRBuilderTy /*P*/ Builder, final /*const*/ DataLayout /*&*/ DL, User /*P*/ GEP) {
  //  return EmitGEPOffset(Builder, DL, GEP, 
  //             false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static </*typename*/ IRBuilderTy> Value /*P*/ EmitGEPOffset(IRBuilderTy /*P*/ Builder, final /*const*/ DataLayout /*&*/ DL, User /*P*/ GEP, 
             boolean NoAssumptions/*= false*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    EmitGEPOffset(Builder, DL, GEP, 
  //             NoAssumptions);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// AlignmentFromAssumptions - Use assume intrinsics to set load/store
// alignments.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createAlignmentFromAssumptionsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp", line = 83,
 FQN="llvm::createAlignmentFromAssumptionsPass", NM="_ZN4llvm34createAlignmentFromAssumptionsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp -nm=_ZN4llvm34createAlignmentFromAssumptionsPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createAlignmentFromAssumptionsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.AlignmentFromAssumptionsLlvmGlobals.
  //    createAlignmentFromAssumptionsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createArgumentPromotionPass - This pass promotes "by reference" arguments to
/// be passed by value if the number of elements passed is smaller or
/// equal to maxElements (maxElements == 0 means always promote).
///
//<editor-fold defaultstate="collapsed" desc="llvm::createArgumentPromotionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp", line = 116,
 FQN="llvm::createArgumentPromotionPass", NM="_ZN4llvm27createArgumentPromotionPassEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm27createArgumentPromotionPassEj")
//</editor-fold>
public static Pass /*P*/ createArgumentPromotionPass() {
  //  return createArgumentPromotionPass(3);
  //}
  //public static Pass /*P*/ createArgumentPromotionPass(/*uint*/int maxElements/*= 3*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.ArgumentPromotionLlvmGlobals.
  // //    createArgumentPromotionPass(maxElements);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// BBVectorize - A basic-block vectorization pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createBBVectorizePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp", line = 3233,
 FQN="llvm::createBBVectorizePass", NM="_ZN4llvm21createBBVectorizePassERKNS_15VectorizeConfigE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm21createBBVectorizePassERKNS_15VectorizeConfigE")
//</editor-fold>
public static BasicBlockPass /*P*/ createBBVectorizePass() {
  //  return createBBVectorizePass(new VectorizeConfig());
  //}
  //public static BasicBlockPass /*P*/ createBBVectorizePass(final /*const*/ VectorizeConfig /*&*/ C/*= VectorizeConfig()*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.BBVectorizeLlvmGlobals.
  // //    createBBVectorizePass(C);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// @brief Vectorize the BasicBlock.
///
/// @param BB The BasicBlock to be vectorized
/// @param P  The current running pass, should require AliasAnalysis and
///           ScalarEvolution. After the vectorization, AliasAnalysis,
///           ScalarEvolution and CFG are preserved.
///
/// @return True if the BB is changed, false otherwise.
///
//<editor-fold defaultstate="collapsed" desc="llvm::vectorizeBasicBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp", line = 3237,
 FQN="llvm::vectorizeBasicBlock", NM="_ZN4llvm19vectorizeBasicBlockEPNS_4PassERNS_10BasicBlockERKNS_15VectorizeConfigE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm19vectorizeBasicBlockEPNS_4PassERNS_10BasicBlockERKNS_15VectorizeConfigE")
//</editor-fold>
public static boolean vectorizeBasicBlock(Pass /*P*/ P, final BasicBlock /*&*/ BB) {
  //  return vectorizeBasicBlock(P, BB, new VectorizeConfig());
  //}
  //public static boolean vectorizeBasicBlock(Pass /*P*/ P, final BasicBlock /*&*/ BB, final /*const*/ VectorizeConfig /*&*/ C/*= VectorizeConfig()*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.BBVectorizeLlvmGlobals.
  // //    vectorizeBasicBlock(P, BB, C);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// BitTrackingDCE - This pass uses a bit-tracking DCE algorithm in order to
// remove computations of dead bits.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createBitTrackingDCEPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp", line = 112,
 FQN="llvm::createBitTrackingDCEPass", NM="_ZN4llvm24createBitTrackingDCEPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp -nm=_ZN4llvm24createBitTrackingDCEPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createBitTrackingDCEPass() {
  //  return /*delegate*/org.llvm.transforms.impl.BDCELlvmGlobals.
  //    createBitTrackingDCEPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createBarrierNoopPass - This pass is purely a module pass barrier in a pass
/// manager.
//<editor-fold defaultstate="collapsed" desc="llvm::createBarrierNoopPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp", line = 43,
 FQN="llvm::createBarrierNoopPass", NM="_ZN4llvm21createBarrierNoopPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp -nm=_ZN4llvm21createBarrierNoopPassEv")
//</editor-fold>
public static ModulePass /*P*/ createBarrierNoopPass() {
  return /*delegate*/org.llvm.transforms.impl.BarrierNoopPassLlvmGlobals.
    createBarrierNoopPass();
}


/// Delete the specified block, which must have no predecessors.
//<editor-fold defaultstate="collapsed" desc="llvm::DeleteDeadBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 34,
 FQN="llvm::DeleteDeadBlock", NM="_ZN4llvm15DeleteDeadBlockEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm15DeleteDeadBlockEPNS_10BasicBlockE")
//</editor-fold>
public static void DeleteDeadBlock(BasicBlock /*P*/ BB) {
  //  /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    DeleteDeadBlock(BB);
  throw new UnsupportedOperationException("EmptyBody");
}


/// We know that BB has one predecessor. If there are any single-entry PHI nodes
/// in it, fold them away. This handles the case when all entries to the PHI
/// nodes in a block are guaranteed equal, such as when the block has exactly
/// one predecessor.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldSingleEntryPHINodes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 62,
 FQN="llvm::FoldSingleEntryPHINodes", NM="_ZN4llvm23FoldSingleEntryPHINodesEPNS_10BasicBlockEPNS_23MemoryDependenceResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm23FoldSingleEntryPHINodesEPNS_10BasicBlockEPNS_23MemoryDependenceResultsE")
//</editor-fold>
public static void FoldSingleEntryPHINodes(BasicBlock /*P*/ BB) {
  //  FoldSingleEntryPHINodes(BB, 
  //                       (MemoryDependenceResults /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void FoldSingleEntryPHINodes(BasicBlock /*P*/ BB, 
                       MemoryDependenceResults /*P*/ MemDep/*= null*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    FoldSingleEntryPHINodes(BB, 
  //                       MemDep);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Examine each PHI in the given block and delete it if it is dead. Also
/// recursively delete any operands that become dead as a result. This includes
/// tracing the def-use list from the PHI to see if it is ultimately unused or
/// if it reaches an unused cycle. Return true if any PHIs were deleted.
//<editor-fold defaultstate="collapsed" desc="llvm::DeleteDeadPHIs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 79,
 FQN="llvm::DeleteDeadPHIs", NM="_ZN4llvm14DeleteDeadPHIsEPNS_10BasicBlockEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm14DeleteDeadPHIsEPNS_10BasicBlockEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean DeleteDeadPHIs(BasicBlock /*P*/ BB) {
  //  return DeleteDeadPHIs(BB, (/*const*/ TargetLibraryInfo /*P*/ )null);
  //}
  //public static boolean DeleteDeadPHIs(BasicBlock /*P*/ BB, /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  // //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  // //    DeleteDeadPHIs(BB, TLI);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


/// Attempts to merge a block into its predecessor, if possible. The return
/// value indicates success or failure.
//<editor-fold defaultstate="collapsed" desc="llvm::MergeBlockIntoPredecessor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 95,
 FQN="llvm::MergeBlockIntoPredecessor", NM="_ZN4llvm25MergeBlockIntoPredecessorEPNS_10BasicBlockEPNS_13DominatorTreeEPNS_8LoopInfoEPNS_23MemoryDependenceResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm25MergeBlockIntoPredecessorEPNS_10BasicBlockEPNS_13DominatorTreeEPNS_8LoopInfoEPNS_23MemoryDependenceResultsE")
//</editor-fold>
public static boolean MergeBlockIntoPredecessor(BasicBlock /*P*/ BB) {
  //  return MergeBlockIntoPredecessor(BB, (DominatorTree /*P*/ )null, 
  //                         (LoopInfo /*P*/ )null, 
  //                         (MemoryDependenceResults /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean MergeBlockIntoPredecessor(BasicBlock /*P*/ BB, DominatorTree /*P*/ DT/*= null*/) {
  //  return MergeBlockIntoPredecessor(BB, DT, 
  //                         (LoopInfo /*P*/ )null, 
  //                         (MemoryDependenceResults /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean MergeBlockIntoPredecessor(BasicBlock /*P*/ BB, DominatorTree /*P*/ DT/*= null*/, 
                         LoopInfo /*P*/ LI/*= null*/) {
  //  return MergeBlockIntoPredecessor(BB, DT, 
  //                         LI, 
  //                         (MemoryDependenceResults /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean MergeBlockIntoPredecessor(BasicBlock /*P*/ BB, DominatorTree /*P*/ DT/*= null*/, 
                         LoopInfo /*P*/ LI/*= null*/, 
                         MemoryDependenceResults /*P*/ MemDep/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    MergeBlockIntoPredecessor(BB, DT, 
  //                         LI, 
 //                         MemDep);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replace all uses of an instruction (specified by BI) with a value, then
/// remove and delete the original instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::ReplaceInstWithValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 171,
 FQN="llvm::ReplaceInstWithValue", NM="_ZN4llvm20ReplaceInstWithValueERNS_15SymbolTableListINS_11InstructionEEERNS_14ilist_iteratorIS1_EEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm20ReplaceInstWithValueERNS_15SymbolTableListINS_11InstructionEEERNS_14ilist_iteratorIS1_EEPNS_5ValueE")
//</editor-fold>
public static void ReplaceInstWithValue(final SymbolTableList<Instruction, BasicBlock> /*&*/ BIL, 
                    final ilist_iterator<Instruction> /*&*/ BI, Value /*P*/ V) {
  //  /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    ReplaceInstWithValue(BIL, 
  //                    BI, V);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replace the instruction specified by BI with the instruction specified by I.
/// Copies DebugLoc from BI to I, if I doesn't already have a DebugLoc. The
/// original instruction is deleted and BI is updated to point to the new
/// instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::ReplaceInstWithInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 185,
 FQN="llvm::ReplaceInstWithInst", NM="_ZN4llvm19ReplaceInstWithInstERNS_15SymbolTableListINS_11InstructionEEERNS_14ilist_iteratorIS1_EEPS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm19ReplaceInstWithInstERNS_15SymbolTableListINS_11InstructionEEERNS_14ilist_iteratorIS1_EEPS1_")
//</editor-fold>
public static void ReplaceInstWithInst(final SymbolTableList<Instruction, BasicBlock> /*&*/ BIL, 
                   final ilist_iterator<Instruction> /*&*/ BI, Instruction /*P*/ I) {
  //  /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    ReplaceInstWithInst(BIL, 
  //                   BI, I);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replace the instruction specified by From with the instruction specified by
/// To. Copies DebugLoc from BI to I, if I doesn't already have a DebugLoc.
//<editor-fold defaultstate="collapsed" desc="llvm::ReplaceInstWithInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 205,
 FQN="llvm::ReplaceInstWithInst", NM="_ZN4llvm19ReplaceInstWithInstEPNS_11InstructionES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm19ReplaceInstWithInstEPNS_11InstructionES1_")
//</editor-fold>
public static void ReplaceInstWithInst(Instruction /*P*/ From, Instruction /*P*/ To) {
  //  /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    ReplaceInstWithInst(From, To);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Loop over all of the edges in the CFG, breaking critical edges as they are
/// found. Returns the number of broken edges.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitAllCriticalEdges">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 237,
 FQN="llvm::SplitAllCriticalEdges", NM="_ZN4llvm21SplitAllCriticalEdgesERNS_8FunctionERKNS_28CriticalEdgeSplittingOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm21SplitAllCriticalEdgesERNS_8FunctionERKNS_28CriticalEdgeSplittingOptionsE")
//</editor-fold>
public static /*uint*/int SplitAllCriticalEdges(final Function /*&*/ F) {
  //  return SplitAllCriticalEdges(F, 
  //                     new CriticalEdgeSplittingOptions());
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*uint*/int SplitAllCriticalEdges(final Function /*&*/ F, 
                     final /*const*/ CriticalEdgeSplittingOptions /*&*/ Options/*= CriticalEdgeSplittingOptions()*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitAllCriticalEdges(F, 
  //                     Options);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Split the edge connecting specified block.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 210,
 FQN="llvm::SplitEdge", NM="_ZN4llvm9SplitEdgeEPNS_10BasicBlockES1_PNS_13DominatorTreeEPNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm9SplitEdgeEPNS_10BasicBlockES1_PNS_13DominatorTreeEPNS_8LoopInfoE")
//</editor-fold>
public static BasicBlock /*P*/ SplitEdge(BasicBlock /*P*/ BB, BasicBlock /*P*/ Succ) {
  //  return SplitEdge(BB, Succ, (DominatorTree /*P*/ )null, 
  //         (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitEdge(BasicBlock /*P*/ BB, BasicBlock /*P*/ Succ, DominatorTree /*P*/ DT/*= null*/) {
  //  return SplitEdge(BB, Succ, DT, 
  //         (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitEdge(BasicBlock /*P*/ BB, BasicBlock /*P*/ Succ, DominatorTree /*P*/ DT/*= null*/, 
         LoopInfo /*P*/ LI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitEdge(BB, Succ, DT, 
  //         LI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Split the specified block at the specified instruction - everything before
/// SplitPt stays in Old and everything starting with SplitPt moves to a new
/// block. The two blocks are joined by an unconditional branch and the loop
/// info is updated.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 251,
 FQN="llvm::SplitBlock", NM="_ZN4llvm10SplitBlockEPNS_10BasicBlockEPNS_11InstructionEPNS_13DominatorTreeEPNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm10SplitBlockEPNS_10BasicBlockEPNS_11InstructionEPNS_13DominatorTreeEPNS_8LoopInfoE")
//</editor-fold>
public static BasicBlock /*P*/ SplitBlock(BasicBlock /*P*/ Old, Instruction /*P*/ SplitPt) {
  //  return SplitBlock(Old, SplitPt, 
  //          (DominatorTree /*P*/ )null, (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitBlock(BasicBlock /*P*/ Old, Instruction /*P*/ SplitPt, 
          DominatorTree /*P*/ DT/*= null*/) {
  //  return SplitBlock(Old, SplitPt, 
  //          DT, (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitBlock(BasicBlock /*P*/ Old, Instruction /*P*/ SplitPt, 
          DominatorTree /*P*/ DT/*= null*/, LoopInfo /*P*/ LI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitBlock(Old, SplitPt, 
  //          DT, LI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This method introduces at least one new basic block into the function and
/// moves some of the predecessors of BB to be predecessors of the new block.
/// The new predecessors are indicated by the Preds array. The new block is
/// given a suffix of 'Suffix'. Returns new basic block to which predecessors
/// from Preds are now pointing.
///
/// If BB is a landingpad block then additional basicblock might be introduced.
/// It will have Suffix+".split_lp". See SplitLandingPadPredecessors for more
/// details on this case.
///
/// This currently updates the LLVM IR, DominatorTree, LoopInfo, and LCCSA but
/// no other analyses. In particular, it does not preserve LoopSimplify
/// (because it's complicated to handle the case where one of the edges being
/// split is an exit of a loop with other exits).
///
//<editor-fold defaultstate="collapsed" desc="llvm::SplitBlockPredecessors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 416,
 FQN="llvm::SplitBlockPredecessors", NM="_ZN4llvm22SplitBlockPredecessorsEPNS_10BasicBlockENS_8ArrayRefIS1_EEPKcPNS_13DominatorTreeEPNS_8LoopInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm22SplitBlockPredecessorsEPNS_10BasicBlockENS_8ArrayRefIS1_EEPKcPNS_13DominatorTreeEPNS_8LoopInfoEb")
//</editor-fold>
public static BasicBlock /*P*/ SplitBlockPredecessors(BasicBlock /*P*/ BB, 
                      ArrayRef<BasicBlock /*P*/ > Preds, 
                      /*const*/char$ptr/*char P*/ Suffix) {
  //  return SplitBlockPredecessors(BB, 
  //                      Preds, 
  //                      Suffix, (DominatorTree /*P*/ )null, 
 //                      (LoopInfo /*P*/ )null, false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitBlockPredecessors(BasicBlock /*P*/ BB, 
                      ArrayRef<BasicBlock /*P*/ > Preds, 
                      /*const*/char$ptr/*char P*/ Suffix, DominatorTree /*P*/ DT/*= null*/) {
  //  return SplitBlockPredecessors(BB, 
  //                      Preds, 
  //                      Suffix, DT, 
 //                      (LoopInfo /*P*/ )null, false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitBlockPredecessors(BasicBlock /*P*/ BB, 
                      ArrayRef<BasicBlock /*P*/ > Preds, 
                      /*const*/char$ptr/*char P*/ Suffix, DominatorTree /*P*/ DT/*= null*/, 
                      LoopInfo /*P*/ LI/*= null*/) {
  //  return SplitBlockPredecessors(BB, 
  //                      Preds, 
  //                      Suffix, DT, 
 //                      LI, false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitBlockPredecessors(BasicBlock /*P*/ BB, 
                      ArrayRef<BasicBlock /*P*/ > Preds, 
                      /*const*/char$ptr/*char P*/ Suffix, DominatorTree /*P*/ DT/*= null*/, 
                      LoopInfo /*P*/ LI/*= null*/, boolean PreserveLCSSA/*= false*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitBlockPredecessors(BB, 
  //                      Preds, 
 //                      Suffix, DT, 
 //                      LI, PreserveLCSSA);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This method transforms the landing pad, OrigBB, by introducing two new basic
/// blocks into the function. One of those new basic blocks gets the
/// predecessors listed in Preds. The other basic block gets the remaining
/// predecessors of OrigBB. The landingpad instruction OrigBB is clone into both
/// of the new basic blocks. The new blocks are given the suffixes 'Suffix1' and
/// 'Suffix2', and are returned in the NewBBs vector.
///
/// This currently updates the LLVM IR, DominatorTree, LoopInfo, and LCCSA but
/// no other analyses. In particular, it does not preserve LoopSimplify
/// (because it's complicated to handle the case where one of the edges being
/// split is an exit of a loop with other exits).
///
//<editor-fold defaultstate="collapsed" desc="llvm::SplitLandingPadPredecessors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 474,
 FQN="llvm::SplitLandingPadPredecessors", NM="_ZN4llvm27SplitLandingPadPredecessorsEPNS_10BasicBlockENS_8ArrayRefIS1_EEPKcS5_RNS_15SmallVectorImplIS1_EEPNS_13DominatorTreeEPNS_8LoopInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm27SplitLandingPadPredecessorsEPNS_10BasicBlockENS_8ArrayRefIS1_EEPKcS5_RNS_15SmallVectorImplIS1_EEPNS_13DominatorTreeEPNS_8LoopInfoEb")
//</editor-fold>
public static void SplitLandingPadPredecessors(BasicBlock /*P*/ OrigBB, 
                           ArrayRef<BasicBlock /*P*/ > Preds, 
                           /*const*/char$ptr/*char P*/ Suffix1, /*const*/char$ptr/*char P*/ Suffix2, 
                           final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ NewBBs) {
  SplitLandingPadPredecessors(OrigBB, 
                           Preds, 
                           Suffix1, Suffix2, 
                           NewBBs, 
                           (DominatorTree /*P*/ )null, (LoopInfo /*P*/ )null, 
                           false);
}
public static void SplitLandingPadPredecessors(BasicBlock /*P*/ OrigBB, 
                           ArrayRef<BasicBlock /*P*/ > Preds, 
                           /*const*/char$ptr/*char P*/ Suffix1, /*const*/char$ptr/*char P*/ Suffix2, 
                           final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ NewBBs, 
                           DominatorTree /*P*/ DT/*= null*/) {
  SplitLandingPadPredecessors(OrigBB, 
                           Preds, 
                           Suffix1, Suffix2, 
                           NewBBs, 
                           DT, (LoopInfo /*P*/ )null, 
                           false);
}
public static void SplitLandingPadPredecessors(BasicBlock /*P*/ OrigBB, 
                           ArrayRef<BasicBlock /*P*/ > Preds, 
                           /*const*/char$ptr/*char P*/ Suffix1, /*const*/char$ptr/*char P*/ Suffix2, 
                           final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ NewBBs, 
                           DominatorTree /*P*/ DT/*= null*/, LoopInfo /*P*/ LI/*= null*/) {
  SplitLandingPadPredecessors(OrigBB, 
                           Preds, 
                           Suffix1, Suffix2, 
                           NewBBs, 
                           DT, LI, 
                           false);
}
public static void SplitLandingPadPredecessors(BasicBlock /*P*/ OrigBB, 
                           ArrayRef<BasicBlock /*P*/ > Preds, 
                           /*const*/char$ptr/*char P*/ Suffix1, /*const*/char$ptr/*char P*/ Suffix2, 
                           final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ NewBBs, 
                           DominatorTree /*P*/ DT/*= null*/, LoopInfo /*P*/ LI/*= null*/, 
                           boolean PreserveLCSSA/*= false*/) {
  ///*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //  SplitLandingPadPredecessors(OrigBB, 
  //                         Preds, 
  //                         Suffix1, Suffix2, 
  //                         NewBBs, 
  //                         DT, LI, 
  //                         PreserveLCSSA);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This method duplicates the specified return instruction into a predecessor
/// which ends in an unconditional branch. If the return instruction returns a
/// value defined by a PHI, propagate the right value into the return. It
/// returns the new return instruction in the predecessor.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldReturnIntoUncondBranch">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 577,
 FQN="llvm::FoldReturnIntoUncondBranch", NM="_ZN4llvm26FoldReturnIntoUncondBranchEPNS_10ReturnInstEPNS_10BasicBlockES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm26FoldReturnIntoUncondBranchEPNS_10ReturnInstEPNS_10BasicBlockES3_")
//</editor-fold>
public static ReturnInst /*P*/ FoldReturnIntoUncondBranch(ReturnInst /*P*/ RI, BasicBlock /*P*/ BB, 
                          BasicBlock /*P*/ Pred) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    FoldReturnIntoUncondBranch(RI, BB, 
  //                          Pred);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Split the containing block at the specified instruction - everything before
/// and including SplitBefore stays in the old basic block, and everything after
/// SplitBefore is moved to a new block. The two blocks are connected by a
/// conditional branch (with value of Cmp being the condition).
/// Before:
///   Head
///   SplitBefore
///   Tail
/// After:
///   Head
///   if (Cond)
///     ThenBlock
///   SplitBefore
///   Tail
///
/// If Unreachable is true, then ThenBlock ends with
/// UnreachableInst, otherwise it branches to Tail.
/// Returns the NewBasicBlock's terminator.
///
/// Updates DT and LI if given.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitBlockAndInsertIfThen">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 615,
 FQN="llvm::SplitBlockAndInsertIfThen", NM="_ZN4llvm25SplitBlockAndInsertIfThenEPNS_5ValueEPNS_11InstructionEbPNS_6MDNodeEPNS_13DominatorTreeEPNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm25SplitBlockAndInsertIfThenEPNS_5ValueEPNS_11InstructionEbPNS_6MDNodeEPNS_13DominatorTreeEPNS_8LoopInfoE")
//</editor-fold>
public static TerminatorInst /*P*/ SplitBlockAndInsertIfThen(Value /*P*/ Cond, Instruction /*P*/ SplitBefore, 
                         boolean Unreachable) {
  //  return SplitBlockAndInsertIfThen(Cond, SplitBefore, 
  //                         Unreachable, (MDNode /*P*/ )null, 
  //                         (DominatorTree /*P*/ )null, (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static TerminatorInst /*P*/ SplitBlockAndInsertIfThen(Value /*P*/ Cond, Instruction /*P*/ SplitBefore, 
                         boolean Unreachable, MDNode /*P*/ BranchWeights/*= null*/) {
  //  return SplitBlockAndInsertIfThen(Cond, SplitBefore, 
  //                         Unreachable, BranchWeights, 
  //                         (DominatorTree /*P*/ )null, (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static TerminatorInst /*P*/ SplitBlockAndInsertIfThen(Value /*P*/ Cond, Instruction /*P*/ SplitBefore, 
                         boolean Unreachable, MDNode /*P*/ BranchWeights/*= null*/, 
                         DominatorTree /*P*/ DT/*= null*/) {
  //  return SplitBlockAndInsertIfThen(Cond, SplitBefore, 
  //                         Unreachable, BranchWeights, 
  //                         DT, (LoopInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static TerminatorInst /*P*/ SplitBlockAndInsertIfThen(Value /*P*/ Cond, Instruction /*P*/ SplitBefore, 
                         boolean Unreachable, MDNode /*P*/ BranchWeights/*= null*/, 
                         DominatorTree /*P*/ DT/*= null*/, LoopInfo /*P*/ LI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitBlockAndInsertIfThen(Cond, SplitBefore, 
  //                         Unreachable, BranchWeights, 
 //                         DT, LI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// SplitBlockAndInsertIfThenElse is similar to SplitBlockAndInsertIfThen,
/// but also creates the ElseBlock.
/// Before:
///   Head
///   SplitBefore
///   Tail
/// After:
///   Head
///   if (Cond)
///     ThenBlock
///   else
///     ElseBlock
///   SplitBefore
///   Tail
//<editor-fold defaultstate="collapsed" desc="llvm::SplitBlockAndInsertIfThenElse">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 657,
 FQN="llvm::SplitBlockAndInsertIfThenElse", NM="_ZN4llvm29SplitBlockAndInsertIfThenElseEPNS_5ValueEPNS_11InstructionEPPNS_14TerminatorInstES6_PNS_6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm29SplitBlockAndInsertIfThenElseEPNS_5ValueEPNS_11InstructionEPPNS_14TerminatorInstES6_PNS_6MDNodeE")
//</editor-fold>
public static void SplitBlockAndInsertIfThenElse(Value /*P*/ Cond, Instruction /*P*/ SplitBefore, 
                             type$ptr<TerminatorInst /*P*/ /*P*/> ThenTerm, 
                             type$ptr<TerminatorInst /*P*/ /*P*/> ElseTerm) {
  //  SplitBlockAndInsertIfThenElse(Cond, SplitBefore, 
  //                             ThenTerm, 
  //                             ElseTerm, 
 //                             (MDNode /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void SplitBlockAndInsertIfThenElse(Value /*P*/ Cond, Instruction /*P*/ SplitBefore, 
                             type$ptr<TerminatorInst /*P*/ /*P*/> ThenTerm, 
                             type$ptr<TerminatorInst /*P*/ /*P*/> ElseTerm, 
                             MDNode /*P*/ BranchWeights/*= null*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    SplitBlockAndInsertIfThenElse(Cond, SplitBefore, 
  //                             ThenTerm, 
 //                             ElseTerm, 
 //                             BranchWeights);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Check whether BB is the merge point of a if-region.
/// If so, return the boolean condition that determines which entry into
/// BB will be taken.  Also, return by references the block that will be
/// entered from if the condition is true, and the block that will be
/// entered if the condition is false.
///
/// This does no checking to see if the true/false blocks have large or unsavory
/// instructions in them.
//<editor-fold defaultstate="collapsed" desc="llvm::GetIfCondition">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp", line = 678,
 FQN="llvm::GetIfCondition", NM="_ZN4llvm14GetIfConditionEPNS_10BasicBlockERS1_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BasicBlockUtils.cpp -nm=_ZN4llvm14GetIfConditionEPNS_10BasicBlockERS1_S2_")
//</editor-fold>
public static Value /*P*/ GetIfCondition(BasicBlock /*P*/ BB, final type$ref<BasicBlock /*P*/ /*&*/> IfTrue, 
              final type$ref<BasicBlock /*P*/ /*&*/> IfFalse) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BasicBlockUtilsLlvmGlobals.
  //    GetIfCondition(BB, IfTrue, 
  //              IfFalse);
  throw new UnsupportedOperationException("EmptyBody");
}


// BoundsChecking - This pass instruments the code to perform run-time bounds
// checking on loads, stores, and other memory intrinsics.
//<editor-fold defaultstate="collapsed" desc="llvm::createBoundsCheckingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 210,
 FQN="llvm::createBoundsCheckingPass", NM="_ZN4llvm24createBoundsCheckingPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm24createBoundsCheckingPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createBoundsCheckingPass() {
  //  return /*delegate*/org.llvm.transforms.impl.BoundsCheckingLlvmGlobals.
  //    createBoundsCheckingPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// BreakCriticalEdges - Break all of the critical edges in the CFG by inserting
// a dummy basic block. This pass may be "required" by passes that cannot deal
// with critical edges. For this usage, a pass must call:
//
//   AU.addRequiredID(BreakCriticalEdgesID);
//
// This pass obviously invalidates the CFG, but can update forward dominator
// (set, immediate dominators, tree, and frontier) information.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createBreakCriticalEdgesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp", line = 71,
 FQN="llvm::createBreakCriticalEdgesPass", NM="_ZN4llvm28createBreakCriticalEdgesPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp -nm=_ZN4llvm28createBreakCriticalEdgesPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createBreakCriticalEdgesPass() {
  //  return /*delegate*/org.llvm.transforms.impl.BreakCriticalEdgesLlvmGlobals.
  //    createBreakCriticalEdgesPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// If this edge is a critical edge, insert a new node to split the critical
/// edge. This will update the analyses passed in through the option struct.
/// This returns the new block if the edge was split, null otherwise.
///
/// If MergeIdenticalEdges in the options struct is true (not the default),
/// *all* edges from TI to the specified successor will be merged into the same
/// critical edge block. This is most commonly interesting with switch
/// instructions, which may have many edges to any one destination.  This
/// ensures that all edges to that dest go to one block instead of each going
/// to a different block, but isn't the standard definition of a "critical
/// edge".
///
/// It is invalid to call this function on a critical edge that starts at an
/// IndirectBrInst.  Splitting these edges will almost always create an invalid
/// program because the address of the new block won't be the one that is jumped
/// to.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SplitCriticalEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp", line = 114,
 FQN="llvm::SplitCriticalEdge", NM="_ZN4llvm17SplitCriticalEdgeEPNS_14TerminatorInstEjRKNS_28CriticalEdgeSplittingOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp -nm=_ZN4llvm17SplitCriticalEdgeEPNS_14TerminatorInstEjRKNS_28CriticalEdgeSplittingOptionsE")
//</editor-fold>
public static BasicBlock /*P*/ SplitCriticalEdge(TerminatorInst /*P*/ TI, /*uint*/int SuccNum) {
  //  return SplitCriticalEdge(TI, SuccNum, 
  //                 new CriticalEdgeSplittingOptions());
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ SplitCriticalEdge(TerminatorInst /*P*/ TI, /*uint*/int SuccNum, 
                 final /*const*/ CriticalEdgeSplittingOptions /*&*/ Options/*= CriticalEdgeSplittingOptions()*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BreakCriticalEdgesLlvmGlobals.
  //    SplitCriticalEdge(TI, SuccNum, 
  //                 Options);
  throw new UnsupportedOperationException("EmptyBody");
}


// Publicly exposed interface to pass...
//<editor-fold defaultstate="collapsed" desc="llvm::BreakCriticalEdgesID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp", line = 70,
 FQN="llvm::BreakCriticalEdgesID", NM="_ZN4llvm20BreakCriticalEdgesIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp -nm=_ZN4llvm20BreakCriticalEdgesIDE")
//</editor-fold>
public static final char$ref/*char &*/ BreakCriticalEdgesID = BreakCriticalEdges.ID;

/// Analyze the name and prototype of the given function and set any
/// applicable attributes.
/// If the library function is unavailable, this doesn't modify it.
///
/// Returns true if any attributes were set and false otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::inferLibFuncAttributes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 109,
 FQN="llvm::inferLibFuncAttributes", NM="_ZN4llvm22inferLibFuncAttributesERNS_8FunctionERKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm22inferLibFuncAttributesERNS_8FunctionERKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean inferLibFuncAttributes(final Function /*&*/ F, final /*const*/ TargetLibraryInfo /*&*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    inferLibFuncAttributes(F, TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return V if it is an i8*, otherwise cast it to i8*.

//- Emit LibCalls ------------------------------------------------------------//
//<editor-fold defaultstate="collapsed" desc="llvm::castToCStr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 712,
 FQN="llvm::castToCStr", NM="_ZN4llvm10castToCStrEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10castToCStrEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEE")
//</editor-fold>
public static Value /*P*/ castToCStr(Value /*P*/ V, final IRBuilder /*&*/ B) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    castToCStr(V, B);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the strlen function to the builder, for the specified
/// pointer. Ptr is required to be some pointer type, and the return value has
/// 'intptr_t' type.
//<editor-fold defaultstate="collapsed" desc="llvm::emitStrLen">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 717,
 FQN="llvm::emitStrLen", NM="_ZN4llvm10emitStrLenEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10emitStrLenEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitStrLen(Value /*P*/ Ptr, final IRBuilder /*&*/ B, final /*const*/ DataLayout /*&*/ DL, 
          /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitStrLen(Ptr, B, DL, 
  //          TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the strchr function to the builder, for the specified
/// pointer and character. Ptr is required to be some pointer type, and the
/// return value has 'i8*' type.
//<editor-fold defaultstate="collapsed" desc="llvm::emitStrChr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 734,
 FQN="llvm::emitStrChr", NM="_ZN4llvm10emitStrChrEPNS_5ValueEcRNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10emitStrChrEPNS_5ValueEcRNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitStrChr(Value /*P*/ Ptr, /*char*/byte C, final IRBuilder /*&*/ B, 
          /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitStrChr(Ptr, C, B, 
  //          TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the strncmp function to the builder.
//<editor-fold defaultstate="collapsed" desc="llvm::emitStrNCmp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 752,
 FQN="llvm::emitStrNCmp", NM="_ZN4llvm11emitStrNCmpEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm11emitStrNCmpEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitStrNCmp(Value /*P*/ Ptr1, Value /*P*/ Ptr2, Value /*P*/ Len, final IRBuilder /*&*/ B, 
           final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitStrNCmp(Ptr1, Ptr2, Len, B, 
  //           DL, TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the strcpy function to the builder, for the specified
/// pointer arguments.
//<editor-fold defaultstate="collapsed" desc="llvm::emitStrCpy">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 772,
 FQN="llvm::emitStrCpy", NM="_ZN4llvm10emitStrCpyEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10emitStrCpyEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoENS_9StringRefE")
//</editor-fold>
public static Value /*P*/ emitStrCpy(Value /*P*/ Dst, Value /*P*/ Src, final IRBuilder /*&*/ B, 
          /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return emitStrCpy(Dst, Src, B, 
  //          TLI, new StringRef(/*KEEP_STR*/"strcpy"));
  throw new UnsupportedOperationException("EmptyBody");
}
public static Value /*P*/ emitStrCpy(Value /*P*/ Dst, Value /*P*/ Src, final IRBuilder /*&*/ B, 
          /*const*/ TargetLibraryInfo /*P*/ TLI, StringRef Name/*= "strcpy"*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitStrCpy(Dst, Src, B, 
  //          TLI, Name);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the strncpy function to the builder, for the specified
/// pointer arguments and length.
//<editor-fold defaultstate="collapsed" desc="llvm::emitStrNCpy">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 788,
 FQN="llvm::emitStrNCpy", NM="_ZN4llvm11emitStrNCpyEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm11emitStrNCpyEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoENS_9StringRefE")
//</editor-fold>
public static Value /*P*/ emitStrNCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Len, final IRBuilder /*&*/ B, 
           /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return emitStrNCpy(Dst, Src, Len, B, 
  //           TLI, new StringRef(/*KEEP_STR*/"strncpy"));
  throw new UnsupportedOperationException("EmptyBody");
}
public static Value /*P*/ emitStrNCpy(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Len, final IRBuilder /*&*/ B, 
           /*const*/ TargetLibraryInfo /*P*/ TLI, StringRef Name/*= "strncpy"*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitStrNCpy(Dst, Src, Len, B, 
  //           TLI, Name);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the __memcpy_chk function to the builder. This expects that
/// the Len and ObjSize have type 'intptr_t' and Dst/Src are pointers.
//<editor-fold defaultstate="collapsed" desc="llvm::emitMemCpyChk">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 805,
 FQN="llvm::emitMemCpyChk", NM="_ZN4llvm13emitMemCpyChkEPNS_5ValueES1_S1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm13emitMemCpyChkEPNS_5ValueES1_S1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitMemCpyChk(Value /*P*/ Dst, Value /*P*/ Src, Value /*P*/ Len, Value /*P*/ ObjSize, 
             final IRBuilder /*&*/ B, final /*const*/ DataLayout /*&*/ DL, 
             /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitMemCpyChk(Dst, Src, Len, ObjSize, 
  //             B, DL, 
 //             TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the memchr function. This assumes that Ptr is a pointer,
/// Val is an i32 value, and Len is an 'intptr_t' value.
//<editor-fold defaultstate="collapsed" desc="llvm::emitMemChr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 828,
 FQN="llvm::emitMemChr", NM="_ZN4llvm10emitMemChrEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10emitMemChrEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitMemChr(Value /*P*/ Ptr, Value /*P*/ Val, Value /*P*/ Len, final IRBuilder /*&*/ B, 
          final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitMemChr(Ptr, Val, Len, B, 
  //          DL, TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the memcmp function.
//<editor-fold defaultstate="collapsed" desc="llvm::emitMemCmp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 847,
 FQN="llvm::emitMemCmp", NM="_ZN4llvm10emitMemCmpEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10emitMemCmpEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitMemCmp(Value /*P*/ Ptr1, Value /*P*/ Ptr2, Value /*P*/ Len, final IRBuilder /*&*/ B, 
          final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitMemCmp(Ptr1, Ptr2, Len, B, 
  //          DL, TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the unary function named 'Name' (e.g.  'floor'). This
/// function is known to take a single of type matching 'Op' and returns one
/// value with the same type. If 'Op' is a long double, 'l' is added as the
/// suffix of name, if 'Op' is a float, we add a 'f' suffix.
//<editor-fold defaultstate="collapsed" desc="llvm::emitUnaryFloatFnCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 882,
 FQN="llvm::emitUnaryFloatFnCall", NM="_ZN4llvm20emitUnaryFloatFnCallEPNS_5ValueENS_9StringRefERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm20emitUnaryFloatFnCallEPNS_5ValueENS_9StringRefERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_12AttributeSetE")
//</editor-fold>
public static Value /*P*/ emitUnaryFloatFnCall(Value /*P*/ Op, StringRef Name, final IRBuilder /*&*/ B, 
                    final /*const*/ AttributeSet /*&*/ Attrs) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitUnaryFloatFnCall(Op, Name, B, 
  //                    Attrs);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the binary function named 'Name' (e.g. 'fmin'). This
/// function is known to take type matching 'Op1' and 'Op2' and return one
/// value with the same type. If 'Op1/Op2' are long double, 'l' is added as
/// the suffix of name, if 'Op1/Op2' are float, we add a 'f' suffix.
//<editor-fold defaultstate="collapsed" desc="llvm::emitBinaryFloatFnCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 898,
 FQN="llvm::emitBinaryFloatFnCall", NM="_ZN4llvm21emitBinaryFloatFnCallEPNS_5ValueES1_NS_9StringRefERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_12AttributeSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm21emitBinaryFloatFnCallEPNS_5ValueES1_NS_9StringRefERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_12AttributeSetE")
//</editor-fold>
public static Value /*P*/ emitBinaryFloatFnCall(Value /*P*/ Op1, Value /*P*/ Op2, StringRef Name, 
                     final IRBuilder /*&*/ B, final /*const*/ AttributeSet /*&*/ Attrs) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitBinaryFloatFnCall(Op1, Op2, Name, 
  //                     B, Attrs);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the putchar function. This assumes that Char is an integer.
//<editor-fold defaultstate="collapsed" desc="llvm::emitPutChar">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 914,
 FQN="llvm::emitPutChar", NM="_ZN4llvm11emitPutCharEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm11emitPutCharEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitPutChar(Value /*P*/ Char, final IRBuilder /*&*/ B, 
           /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitPutChar(Char, B, 
  //           TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the puts function. This assumes that Str is some pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::emitPutS">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 934,
 FQN="llvm::emitPutS", NM="_ZN4llvm8emitPutSEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm8emitPutSEPNS_5ValueERNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitPutS(Value /*P*/ Str, final IRBuilder /*&*/ B, 
        /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitPutS(Str, B, 
  //        TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the fputc function. This assumes that Char is an i32, and
/// File is a pointer to FILE.
//<editor-fold defaultstate="collapsed" desc="llvm::emitFPutC">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 949,
 FQN="llvm::emitFPutC", NM="_ZN4llvm9emitFPutCEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm9emitFPutCEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitFPutC(Value /*P*/ Char, Value /*P*/ File, final IRBuilder /*&*/ B, 
         /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitFPutC(Char, File, B, 
  //         TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the puts function. Str is required to be a pointer and
/// File is a pointer to FILE.
//<editor-fold defaultstate="collapsed" desc="llvm::emitFPutS">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 968,
 FQN="llvm::emitFPutS", NM="_ZN4llvm9emitFPutSEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm9emitFPutSEPNS_5ValueES1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitFPutS(Value /*P*/ Str, Value /*P*/ File, final IRBuilder /*&*/ B, 
         /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitFPutS(Str, File, B, 
  //         TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit a call to the fwrite function. This assumes that Ptr is a pointer,
/// Size is an 'intptr_t', and File is a pointer to FILE.
//<editor-fold defaultstate="collapsed" desc="llvm::emitFWrite">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp", line = 986,
 FQN="llvm::emitFWrite", NM="_ZN4llvm10emitFWriteEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BuildLibCalls.cpp -nm=_ZN4llvm10emitFWriteEPNS_5ValueES1_S1_RNS_9IRBuilderINS_14ConstantFolderENS_24IRBuilderDefaultInserterEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Value /*P*/ emitFWrite(Value /*P*/ Ptr, Value /*P*/ Size, Value /*P*/ File, final IRBuilder /*&*/ B, 
          final /*const*/ DataLayout /*&*/ DL, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BuildLibCallsLlvmGlobals.
  //    emitFWrite(Ptr, Size, File, B, 
  //          DL, TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This optimization identifies DIV instructions in a BB that can be
/// profitably bypassed and carried out with a shorter, faster divide.
///
/// This optimization may add basic blocks immediately after BB; for obvious
/// reasons, you shouldn't pass those blocks to bypassSlowDivision.

// bypassSlowDivision - This optimization identifies DIV instructions in a BB
// that can be profitably bypassed and carried out with a shorter, faster
// divide.
//<editor-fold defaultstate="collapsed" desc="llvm::bypassSlowDivision">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BypassSlowDivision.cpp", line = 208,
 FQN="llvm::bypassSlowDivision", NM="_ZN4llvm18bypassSlowDivisionEPNS_10BasicBlockERKNS_8DenseMapIjjNS_12DenseMapInfoIjEENS_6detail12DenseMapPairIjjEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/BypassSlowDivision.cpp -nm=_ZN4llvm18bypassSlowDivisionEPNS_10BasicBlockERKNS_8DenseMapIjjNS_12DenseMapInfoIjEENS_6detail12DenseMapPairIjjEEEE")
//</editor-fold>
public static boolean bypassSlowDivision(BasicBlock /*P*/ BB, final /*const*/DenseMapUIntUInt/*&*/ BypassWidths) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.BypassSlowDivisionLlvmGlobals.
  //    bypassSlowDivision(BB, BypassWidths);
  throw new UnsupportedOperationException("EmptyBody");
}


/// CloneBasicBlock - Return a copy of the specified basic block, but without
/// embedding the block into a particular function.  The block returned is an
/// exact copy of the specified basic block, without any remapping having been
/// performed.  Because of this, this is only suitable for applications where
/// the basic block will be inserted into the same function that it was cloned
/// from (loop unrolling would use this, for example).
///
/// Also, note that this function makes a direct copy of the basic block, and
/// can thus produce illegal LLVM code.  In particular, it will copy any PHI
/// nodes from the original block, even though there are no predecessors for the
/// newly cloned block (thus, phi nodes will have to be updated).  Also, this
/// block will branch to the old successors of the original block: these
/// successors will have to have any PHI nodes updated to account for the new
/// incoming edges.
///
/// The correlation between instructions in the source and result basic blocks
/// is recorded in the VMap map.
///
/// If you have a particular suffix you'd like to use to add to any cloned
/// names, specify it as the optional third parameter.
///
/// If you would like the basic block to be auto-inserted into the end of a
/// function, you can specify it as the optional fourth parameter.
///
/// If you would like to collect additional information about the cloned
/// function, you can specify a ClonedCodeInfo object with the optional fifth
/// parameter.
///

/// See comments in Cloning.h.
//<editor-fold defaultstate="collapsed" desc="llvm::CloneBasicBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 40,
 FQN="llvm::CloneBasicBlock", NM="_ZN4llvm15CloneBasicBlockEPKNS_10BasicBlockERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEERKNS_5TwineEPNS_8FunctionEPNS_14ClonedCodeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm15CloneBasicBlockEPKNS_10BasicBlockERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEERKNS_5TwineEPNS_8FunctionEPNS_14ClonedCodeInfoE")
//</editor-fold>
public static BasicBlock /*P*/ CloneBasicBlock(/*const*/ BasicBlock /*P*/ BB, 
               final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap) {
  //  return CloneBasicBlock(BB, 
  //               VMap, 
  //               new Twine(/*KEEP_STR*/$EMPTY), (Function /*P*/ )null, 
 //               (ClonedCodeInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ CloneBasicBlock(/*const*/ BasicBlock /*P*/ BB, 
               final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
               final /*const*/ Twine /*&*/ NameSuffix/*= ""*/) {
  //  return CloneBasicBlock(BB, 
  //               VMap, 
  //               NameSuffix, (Function /*P*/ )null, 
 //               (ClonedCodeInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ CloneBasicBlock(/*const*/ BasicBlock /*P*/ BB, 
               final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
               final /*const*/ Twine /*&*/ NameSuffix/*= ""*/, Function /*P*/ F/*= null*/) {
  //  return CloneBasicBlock(BB, 
  //               VMap, 
  //               NameSuffix, F, 
 //               (ClonedCodeInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static BasicBlock /*P*/ CloneBasicBlock(/*const*/ BasicBlock /*P*/ BB, 
               final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
               final /*const*/ Twine /*&*/ NameSuffix/*= ""*/, Function /*P*/ F/*= null*/, 
               ClonedCodeInfo /*P*/ CodeInfo/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  //    CloneBasicBlock(BB, 
  //               VMap, 
 //               NameSuffix, F, 
 //               CodeInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// CloneFunction - Return a copy of the specified function and add it to that
/// function's module.  Also, any references specified in the VMap are changed
/// to refer to their mapped value instead of the original one.  If any of the
/// arguments to the function are in the VMap, the arguments are deleted from
/// the resultant function.  The VMap is updated to include mappings from all of
/// the instructions and basicblocks in the function from their old to new
/// values.  The final argument captures information about the cloned code if
/// non-null.
///
/// VMap contains no non-identity GlobalValue mappings and debug info metadata
/// will not be cloned.
///

/// Return a copy of the specified function and add it to that function's
/// module.  Also, any references specified in the VMap are changed to refer to
/// their mapped value instead of the original one.  If any of the arguments to
/// the function are in the VMap, the arguments are deleted from the resultant
/// function.  The VMap is updated to include mappings from all of the
/// instructions and basicblocks in the function from their old to new values.
///
//<editor-fold defaultstate="collapsed" desc="llvm::CloneFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 183,
 FQN="llvm::CloneFunction", NM="_ZN4llvm13CloneFunctionEPNS_8FunctionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEEPNS_14ClonedCodeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm13CloneFunctionEPNS_8FunctionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS5_NS_3sys10SmartMutexILb0EEEEEEEPNS_14ClonedCodeInfoE")
//</editor-fold>
public static Function /*P*/ CloneFunction(Function /*P*/ F, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap) {
  //  return CloneFunction(F, VMap, 
  //             (ClonedCodeInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static Function /*P*/ CloneFunction(Function /*P*/ F, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
             ClonedCodeInfo /*P*/ CodeInfo/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  //    CloneFunction(F, VMap, 
  //             CodeInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Clone OldFunc into NewFunc, transforming the old arguments into references
/// to VMap values.  Note that if NewFunc already has basic blocks, the ones
/// cloned into it will be added to the end of the function.  This function
/// fills in a list of return instructions, and can optionally remap types
/// and/or append the specified suffix to all values cloned.
///
/// If ModuleLevelChanges is false, VMap contains no non-identity GlobalValue
/// mappings.
///

// Clone OldFunc into NewFunc, transforming the old arguments into references to
// VMap values.
//
//<editor-fold defaultstate="collapsed" desc="llvm::CloneFunctionInto">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 79,
 FQN="llvm::CloneFunctionInto", NM="_ZN4llvm17CloneFunctionIntoEPNS_8FunctionEPKS0_RNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm17CloneFunctionIntoEPNS_8FunctionEPKS0_RNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoEPNS_20ValueMapTypeRemapperEPNS_17ValueMaterializerE")
//</editor-fold>
public static void CloneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                 final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                 boolean ModuleLevelChanges, 
                 final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns) {
  CloneFunctionInto(NewFunc, OldFunc, 
                 VMap, 
                 ModuleLevelChanges, 
                 Returns, 
                 $EMPTY, (ClonedCodeInfo /*P*/ )null, 
                 (ValueMapTypeRemapper /*P*/ )null, 
                 (ValueMaterializer /*P*/ )null);
}
public static void CloneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                 final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                 boolean ModuleLevelChanges, 
                 final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                 /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/) {
  CloneFunctionInto(NewFunc, OldFunc, 
                 VMap, 
                 ModuleLevelChanges, 
                 Returns, 
                 NameSuffix, (ClonedCodeInfo /*P*/ )null, 
                 (ValueMapTypeRemapper /*P*/ )null, 
                 (ValueMaterializer /*P*/ )null);
}
public static void CloneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                 final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                 boolean ModuleLevelChanges, 
                 final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                 /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/, ClonedCodeInfo /*P*/ CodeInfo/*= null*/) {
  CloneFunctionInto(NewFunc, OldFunc, 
                 VMap, 
                 ModuleLevelChanges, 
                 Returns, 
                 NameSuffix, CodeInfo, 
                 (ValueMapTypeRemapper /*P*/ )null, 
                 (ValueMaterializer /*P*/ )null);
}
public static void CloneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                 final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                 boolean ModuleLevelChanges, 
                 final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                 /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/, ClonedCodeInfo /*P*/ CodeInfo/*= null*/, 
                 ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/) {
  CloneFunctionInto(NewFunc, OldFunc, 
                 VMap, 
                 ModuleLevelChanges, 
                 Returns, 
                 NameSuffix, CodeInfo, 
                 TypeMapper, 
                 (ValueMaterializer /*P*/ )null);
}
public static void CloneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                 final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                 boolean ModuleLevelChanges, 
                 final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                 /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/, ClonedCodeInfo /*P*/ CodeInfo/*= null*/, 
                 ValueMapTypeRemapper /*P*/ TypeMapper/*= null*/, 
                 ValueMaterializer /*P*/ Materializer/*= null*/) {
  ///*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  //  CloneFunctionInto(NewFunc, OldFunc, 
  //               VMap, 
  //               ModuleLevelChanges, 
  //               Returns, 
  //               NameSuffix, CodeInfo, 
  //               TypeMapper, 
  //               Materializer);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This works like CloneAndPruneFunctionInto, except that it does not clone the
/// entire function. Instead it starts at an instruction provided by the caller
/// and copies (and prunes) only the code reachable from that instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::CloneAndPruneIntoFromInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 393,
 FQN="llvm::CloneAndPruneIntoFromInst", NM="_ZN4llvm25CloneAndPruneIntoFromInstEPNS_8FunctionEPKS0_PKNS_11InstructionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigISA_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm25CloneAndPruneIntoFromInstEPNS_8FunctionEPKS0_PKNS_11InstructionERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigISA_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoE")
//</editor-fold>
public static void CloneAndPruneIntoFromInst(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         /*const*/ Instruction /*P*/ StartingInst, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns) {
  CloneAndPruneIntoFromInst(NewFunc, OldFunc, 
                         StartingInst, 
                         VMap, 
                         ModuleLevelChanges, 
                         Returns, 
                         $EMPTY, 
                         (ClonedCodeInfo /*P*/ )null);
}
public static void CloneAndPruneIntoFromInst(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         /*const*/ Instruction /*P*/ StartingInst, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                         /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/) {
  CloneAndPruneIntoFromInst(NewFunc, OldFunc, 
                         StartingInst, 
                         VMap, 
                         ModuleLevelChanges, 
                         Returns, 
                         NameSuffix, 
                         (ClonedCodeInfo /*P*/ )null);
}
public static void CloneAndPruneIntoFromInst(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         /*const*/ Instruction /*P*/ StartingInst, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                         /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/, 
                         ClonedCodeInfo /*P*/ CodeInfo/*= null*/) {
  ///*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  //  CloneAndPruneIntoFromInst(NewFunc, OldFunc, 
  //                       StartingInst, 
  //                       VMap, 
  //                       ModuleLevelChanges, 
  //                       Returns, 
  //                       NameSuffix, 
  //                       CodeInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// CloneAndPruneFunctionInto - This works exactly like CloneFunctionInto,
/// except that it does some simple constant prop and DCE on the fly.  The
/// effect of this is to copy significantly less code in cases where (for
/// example) a function call with constant arguments is inlined, and those
/// constant arguments cause a significant amount of code in the callee to be
/// dead.  Since this doesn't produce an exactly copy of the input, it can't be
/// used for things like CloneFunction or CloneModule.
///
/// If ModuleLevelChanges is false, VMap contains no non-identity GlobalValue
/// mappings.
///

/// This works exactly like CloneFunctionInto,
/// except that it does some simple constant prop and DCE on the fly.  The
/// effect of this is to copy significantly less code in cases where (for
/// example) a function call with constant arguments is inlined, and those
/// constant arguments cause a significant amount of code in the callee to be
/// dead.  Since this doesn't produce an exact copy of the input, it can't be
/// used for things like CloneFunction or CloneModule.
//<editor-fold defaultstate="collapsed" desc="llvm::CloneAndPruneFunctionInto">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 666,
 FQN="llvm::CloneAndPruneFunctionInto", NM="_ZN4llvm25CloneAndPruneFunctionIntoEPNS_8FunctionEPKS0_RNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm25CloneAndPruneFunctionIntoEPNS_8FunctionEPKS0_RNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEEbRNS_15SmallVectorImplIPNS_10ReturnInstEEEPKcPNS_14ClonedCodeInfoEPNS_11InstructionE")
//</editor-fold>
public static void CloneAndPruneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns) {
  CloneAndPruneFunctionInto(NewFunc, OldFunc, 
                         VMap, 
                         ModuleLevelChanges, 
                         Returns, 
                         $EMPTY, 
                         (ClonedCodeInfo /*P*/ )null, 
                         (Instruction /*P*/ )null);
}
public static void CloneAndPruneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                         /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/) {
  CloneAndPruneFunctionInto(NewFunc, OldFunc, 
                         VMap, 
                         ModuleLevelChanges, 
                         Returns, 
                         NameSuffix, 
                         (ClonedCodeInfo /*P*/ )null, 
                         (Instruction /*P*/ )null);
}
public static void CloneAndPruneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                         /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/, 
                         ClonedCodeInfo /*P*/ CodeInfo/*= null*/) {
  CloneAndPruneFunctionInto(NewFunc, OldFunc, 
                         VMap, 
                         ModuleLevelChanges, 
                         Returns, 
                         NameSuffix, 
                         CodeInfo, 
                         (Instruction /*P*/ )null);
}
public static void CloneAndPruneFunctionInto(Function /*P*/ NewFunc, /*const*/ Function /*P*/ OldFunc, 
                         final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                         boolean ModuleLevelChanges, 
                         final SmallVectorImpl<ReturnInst /*P*/ > /*&*/ Returns, 
                         /*const*/char$ptr/*char P*/ NameSuffix/*= ""*/, 
                         ClonedCodeInfo /*P*/ CodeInfo/*= null*/, 
                         Instruction /*P*/ TheCall/*= null*/) {
  //*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  // CloneAndPruneFunctionInto(NewFunc, OldFunc, 
  //                      VMap, 
  //                      ModuleLevelChanges, 
  //                      Returns, 
  //                      NameSuffix, 
  //                      CodeInfo, 
  //                      TheCall); throw new UnsupportedOperationException("EmptyBody");
   throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Clones a loop \p OrigLoop.  Returns the loop and the blocks in \p
/// Blocks.
///
/// Updates LoopInfo and DominatorTree assuming the loop is dominated by block
/// \p LoopDomBB.  Insert the new blocks before block specified in \p Before.
/// Note: Only innermost loops are supported.

/// \brief Clones a loop \p OrigLoop.  Returns the loop and the blocks in \p
/// Blocks.
///
/// Updates LoopInfo and DominatorTree assuming the loop is dominated by block
/// \p LoopDomBB.  Insert the new blocks before block specified in \p Before.
//<editor-fold defaultstate="collapsed" desc="llvm::cloneLoopWithPreheader">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 692,
 FQN="llvm::cloneLoopWithPreheader", NM="_ZN4llvm22cloneLoopWithPreheaderEPNS_10BasicBlockES1_PNS_4LoopERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEERKNS_5TwineEPNS_8LoopInfoEPNS_13DominatorTreeERNS_15SmallVectorImplIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm22cloneLoopWithPreheaderEPNS_10BasicBlockES1_PNS_4LoopERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS7_NS_3sys10SmartMutexILb0EEEEEEERKNS_5TwineEPNS_8LoopInfoEPNS_13DominatorTreeERNS_15SmallVectorImplIS1_EE")
//</editor-fold>
public static Loop /*P*/ cloneLoopWithPreheader(BasicBlock /*P*/ Before, BasicBlock /*P*/ LoopDomBB, 
                      Loop /*P*/ OrigLoop, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
                      final /*const*/ Twine /*&*/ NameSuffix, LoopInfo /*P*/ LI, 
                      DominatorTree /*P*/ DT, 
                      final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Blocks) {
  //return /*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  //  cloneLoopWithPreheader(Before, LoopDomBB, 
  //                    OrigLoop, VMap, 
  //                    NameSuffix, LI, 
  //                    DT, 
  //                    Blocks);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Remaps instructions in \p Blocks using the mapping in \p VMap.

/// \brief Remaps instructions in \p Blocks using the mapping in \p VMap.
//<editor-fold defaultstate="collapsed" desc="llvm::remapInstructionsInBlocks">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp", line = 678,
 FQN="llvm::remapInstructionsInBlocks", NM="_ZN4llvm25remapInstructionsInBlocksERKNS_15SmallVectorImplIPNS_10BasicBlockEEERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS9_NS_3sys10SmartMutexILb0EEEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneFunction.cpp -nm=_ZN4llvm25remapInstructionsInBlocksERKNS_15SmallVectorImplIPNS_10BasicBlockEEERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS9_NS_3sys10SmartMutexILb0EEEEEEE")
//</editor-fold>
public static void remapInstructionsInBlocks(final /*const*/ SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Blocks, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap) {
  //  /*delegate*/org.llvm.transforms.utils.impl.CloneFunctionLlvmGlobals.
  //    remapInstructionsInBlocks(Blocks, VMap);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return an exact copy of the specified module
///

/// This is not as easy as it might seem because we have to worry about making
/// copies of global variables and functions, and making their (initializers and
/// references, respectively) refer to the right globals.
///
//<editor-fold defaultstate="collapsed" desc="llvm::CloneModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp", line = 27,
 FQN="llvm::CloneModule", NM="_ZN4llvm11CloneModuleEPKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_ZN4llvm11CloneModuleEPKNS_6ModuleE")
//</editor-fold>
public static std.unique_ptr<Module> CloneModule(/*const*/ Module /*P*/ M) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CloneModuleLlvmGlobals.
  //    CloneModule(M);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::CloneModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp", line = 34,
 FQN="llvm::CloneModule", NM="_ZN4llvm11CloneModuleEPKNS_6ModuleERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_ZN4llvm11CloneModuleEPKNS_6ModuleERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEE")
//</editor-fold>
public static std.unique_ptr<Module> CloneModule(/*const*/ Module /*P*/ M, 
           final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CloneModuleLlvmGlobals.
  //    CloneModule(M, 
  //           VMap);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return a copy of the specified module. The ShouldCloneDefinition function
/// controls whether a specific GlobalValue's definition is cloned. If the
/// function returns false, the module copy will contain an external reference
/// in place of the global definition.
//<editor-fold defaultstate="collapsed" desc="llvm::CloneModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp", line = 39,
 FQN="llvm::CloneModule", NM="_ZN4llvm11CloneModuleEPKNS_6ModuleERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_12function_refIFbPKNS_11GlobalValueEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CloneModule.cpp -nm=_ZN4llvm11CloneModuleEPKNS_6ModuleERNS_8ValueMapIPKNS_5ValueENS_6WeakVHENS_14ValueMapConfigIS6_NS_3sys10SmartMutexILb0EEEEEEENS_12function_refIFbPKNS_11GlobalValueEEEE")
//</editor-fold>
public static std.unique_ptr<Module> CloneModule(/*const*/ Module /*P*/ M, final ValueMap</*const*/ Value /*P*/ , WeakVH> /*&*/ VMap, 
           BoolPredicate<GlobalValue> ShouldCloneDefinition) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CloneModuleLlvmGlobals.
  //    CloneModule(M, VMap, 
  //           ShouldCloneDefinition);
  throw new UnsupportedOperationException("EmptyBody");
}


/// getICmpCode - Encode a icmp predicate into a three bit mask.  These bits
/// are carefully arranged to allow folding of expressions such as:
///
///      (A < B) | (A > B) --> (A != B)
///
/// Note that this is only valid if the first and second predicates have the
/// same sign. Is illegal to do: (A u< B) | (A s> B)
///
/// Three bits are used to represent the condition, as follows:
///   0  A > B
///   1  A == B
///   2  A < B
///
/// <=>  Value  Definition
/// 000     0   Always false
/// 001     1   A >  B
/// 010     2   A == B
/// 011     3   A >= B
/// 100     4   A <  B
/// 101     5   A != B
/// 110     6   A <= B
/// 111     7   Always true
///

/// getICmpCode - Encode a icmp predicate into a three bit mask.  These bits
/// are carefully arranged to allow folding of expressions such as:
///
///      (A < B) | (A > B) --> (A != B)
///
/// Note that this is only valid if the first and second predicates have the
/// same sign. Is illegal to do: (A u< B) | (A s> B)
///
/// Three bits are used to represent the condition, as follows:
///   0  A > B
///   1  A == B
///   2  A < B
///
/// <=>  Value  Definition
/// 000     0   Always false
/// 001     1   A >  B
/// 010     2   A == B
/// 011     3   A >= B
/// 100     4   A <  B
/// 101     5   A != B
/// 110     6   A <= B
/// 111     7   Always true
///
//<editor-fold defaultstate="collapsed" desc="llvm::getICmpCode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp", line = 44,
 FQN="llvm::getICmpCode", NM="_ZN4llvm11getICmpCodeEPKNS_8ICmpInstEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp -nm=_ZN4llvm11getICmpCodeEPKNS_8ICmpInstEb")
//</editor-fold>
public static /*uint*/int getICmpCode(/*const*/ ICmpInst /*P*/ ICI) {
  //  return getICmpCode(ICI, false);
  //}
  //public static /*uint*/int getICmpCode(/*const*/ ICmpInst /*P*/ ICI, boolean InvertPred/*= false*/) {
  // //  return /*delegate*/org.llvm.transforms.utils.impl.CmpInstAnalysisLlvmGlobals.
  // //    getICmpCode(ICI, InvertPred);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


/// getICmpValue - This is the complement of getICmpCode, which turns an
/// opcode and two operands into either a constant true or false, or the
/// predicate for a new ICmp instruction. The sign is passed in to determine
/// which kind of predicate to use in the new icmp instruction.
/// Non-NULL return value will be a true or false constant.
/// NULL return means a new ICmp is needed.  The predicate for which is
/// output in NewICmpPred.

/// getICmpValue - This is the complement of getICmpCode, which turns an
/// opcode and two operands into either a constant true or false, or the
/// predicate for a new ICmp instruction. The sign is passed in to determine
/// which kind of predicate to use in the new icmp instruction.
/// Non-NULL return value will be a true or false constant.
/// NULL return means a new ICmp is needed.  The predicate for which is
/// output in NewICmpPred.
//<editor-fold defaultstate="collapsed" desc="llvm::getICmpValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp", line = 72,
 FQN="llvm::getICmpValue", NM="_ZN4llvm12getICmpValueEbjPNS_5ValueES1_RNS_7CmpInst9PredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp -nm=_ZN4llvm12getICmpValueEbjPNS_5ValueES1_RNS_7CmpInst9PredicateE")
//</editor-fold>
public static Value /*P*/ getICmpValue(boolean Sign, /*uint*/int Code, Value /*P*/ LHS, Value /*P*/ RHS, 
            final type$ref<CmpInst.Predicate /*&*/> NewICmpPred) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CmpInstAnalysisLlvmGlobals.
  //    getICmpValue(Sign, Code, LHS, RHS, 
  //            NewICmpPred);
  throw new UnsupportedOperationException("EmptyBody");
}


/// PredicatesFoldable - Return true if both predicates match sign or if at
/// least one of them is an equality comparison (which is signless).

/// PredicatesFoldable - Return true if both predicates match sign or if at
/// least one of them is an equality comparison (which is signless).
//<editor-fold defaultstate="collapsed" desc="llvm::PredicatesFoldable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp", line = 92,
 FQN="llvm::PredicatesFoldable", NM="_ZN4llvm18PredicatesFoldableENS_7CmpInst9PredicateES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CmpInstAnalysis.cpp -nm=_ZN4llvm18PredicatesFoldableENS_7CmpInst9PredicateES1_")
//</editor-fold>
public static boolean PredicatesFoldable(ICmpInst.Predicate p1, ICmpInst.Predicate p2) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CmpInstAnalysisLlvmGlobals.
  //    PredicatesFoldable(p1, p2);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ConstantHoisting - This pass prepares a function for expensive constants.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createConstantHoistingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp", line = 90,
 FQN="llvm::createConstantHoistingPass", NM="_ZN4llvm26createConstantHoistingPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp -nm=_ZN4llvm26createConstantHoistingPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createConstantHoistingPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ConstantHoistingLlvmGlobals.
  //    createConstantHoistingPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createConstantMergePass - This function returns a new pass that merges
/// duplicate global constants together into a single constant that is shared.
/// This is useful because some passes (ie TraceValues) insert a lot of string
/// constants into the program, regardless of whether or not they duplicate an
/// existing string.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createConstantMergePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp", line = 222,
 FQN="llvm::createConstantMergePass", NM="_ZN4llvm23createConstantMergePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp -nm=_ZN4llvm23createConstantMergePassEv")
//</editor-fold>
public static ModulePass /*P*/ createConstantMergePass() {
  //  return /*delegate*/org.llvm.transforms.impl.ConstantMergeLlvmGlobals.
  //    createConstantMergePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ConstantPropagation - A worklist driven constant propagation pass
//
//<editor-fold defaultstate="collapsed" desc="llvm::createConstantPropagationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp", line = 60,
 FQN="llvm::createConstantPropagationPass", NM="_ZN4llvm29createConstantPropagationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm29createConstantPropagationPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createConstantPropagationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ConstantPropLlvmGlobals.
  //    createConstantPropagationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ValuePropagation - Propagate CFG-derived value information
//

// Public interface to the Value Propagation pass
//<editor-fold defaultstate="collapsed" desc="llvm::createCorrelatedValuePropagationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp", line = 67,
 FQN="llvm::createCorrelatedValuePropagationPass", NM="_ZN4llvm36createCorrelatedValuePropagationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp -nm=_ZN4llvm36createCorrelatedValuePropagationPassEv")
//</editor-fold>
public static Pass /*P*/ createCorrelatedValuePropagationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.CorrelatedValuePropagationLlvmGlobals.
  //    createCorrelatedValuePropagationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief This pass export CFI checks for use by external modules.
//<editor-fold defaultstate="collapsed" desc="llvm::createCrossDSOCFIPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp", line = 64,
 FQN="llvm::createCrossDSOCFIPass", NM="_ZN4llvm21createCrossDSOCFIPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp -nm=_ZN4llvm21createCrossDSOCFIPassEv")
//</editor-fold>
public static ModulePass /*P*/ createCrossDSOCFIPass() {
  //  return /*delegate*/org.llvm.transforms.impl.CrossDSOCFILlvmGlobals.
  //    createCrossDSOCFIPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Call "ShouldRemove" for every entry in M's global_ctor list and remove the
/// entries for which it returns true.  Return true if anything changed.
// namespace

/// Call "ShouldRemove" for every entry in M's global_ctor list and remove the
/// entries for which it returns true.  Return true if anything changed.
//<editor-fold defaultstate="collapsed" desc="llvm::optimizeGlobalCtorsList">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp", line = 120,
 FQN="llvm::optimizeGlobalCtorsList", NM="_ZN4llvm23optimizeGlobalCtorsListERNS_6ModuleENS_12function_refIFbPNS_8FunctionEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/CtorUtils.cpp -nm=_ZN4llvm23optimizeGlobalCtorsListERNS_6ModuleENS_12function_refIFbPNS_8FunctionEEEE")
//</editor-fold>
public static boolean optimizeGlobalCtorsList(final Module /*&*/ M, 
                       BoolPredicate<Function> ShouldRemove) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.CtorUtilsLlvmGlobals.
  //    optimizeGlobalCtorsList(M, 
  //                       ShouldRemove);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// DeadInstElimination - This pass quickly removes trivially dead instructions
// without modifying the CFG of the function.  It is a BasicBlockPass, so it
// runs efficiently when queued next to other BasicBlockPass's.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDeadInstEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp", line = 71,
 FQN="llvm::createDeadInstEliminationPass", NM="_ZN4llvm29createDeadInstEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm29createDeadInstEliminationPassEv")
//</editor-fold>
public static Pass /*P*/ createDeadInstEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.DCELlvmGlobals.
  //    createDeadInstEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// DeadCodeElimination - This pass is more powerful than DeadInstElimination,
// because it is worklist driven that can potentially revisit instructions when
// their other instructions become dead, to eliminate chains of dead
// computations.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDeadCodeEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp", line = 158,
 FQN="llvm::createDeadCodeEliminationPass", NM="_ZN4llvm29createDeadCodeEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm29createDeadCodeEliminationPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDeadCodeEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.DCELlvmGlobals.
  //    createDeadCodeEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// Insert DataFlowSanitizer (dynamic data flow analysis) instrumentation
//<editor-fold defaultstate="collapsed" desc="llvm::createDataFlowSanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp", line = 362,
 FQN="llvm::createDataFlowSanitizerPass", NM="_ZN4llvm27createDataFlowSanitizerPassERKSt6vectorISsSaISsEEPFPvvES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp -nm=_ZN4llvm27createDataFlowSanitizerPassERKSt6vectorISsSaISsEEPFPvvES7_")
//</editor-fold>
public static ModulePass /*P*/ createDataFlowSanitizerPass() {
  //  return createDataFlowSanitizerPass($c$.track(new std.vectorString(std.string.EMPTY)), 
  //                           (Void2VoidPtr)null, 
  //                           (Void2VoidPtr)null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static ModulePass /*P*/ createDataFlowSanitizerPass(final /*const*/std.vectorString/*&*/ ABIListFiles/*= std.vectorString()*/) {
  //  return createDataFlowSanitizerPass(ABIListFiles, 
  //                           (Void2VoidPtr)null, 
  //                           (Void2VoidPtr)null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static ModulePass /*P*/ createDataFlowSanitizerPass(final /*const*/std.vectorString/*&*/ ABIListFiles/*= std.vectorString()*/, 
                           Void2Void getArgTLS/*= null*/) {
  //  return createDataFlowSanitizerPass(ABIListFiles, 
  //                           getArgTLS, 
  //                           (Void2VoidPtr)null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static ModulePass /*P*/ createDataFlowSanitizerPass(final /*const*/std.vectorString/*&*/ ABIListFiles/*= std.vectorString()*/, 
                           Void2Void getArgTLS/*= null*/, 
                           Void2Void getRetValTLS/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.impl.DataFlowSanitizerLlvmGlobals.
  //    createDataFlowSanitizerPass(ABIListFiles, 
  //                           getArgTLS, 
 //                           getRetValTLS);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createDeadArgEliminationPass - This pass removes arguments from functions
/// which are not used by the body of the function.
///

/// createDeadArgEliminationPass - This pass removes arguments from functions
/// which are not used by the body of the function.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createDeadArgEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp", line = 100,
 FQN="llvm::createDeadArgEliminationPass", NM="_ZN4llvm28createDeadArgEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp -nm=_ZN4llvm28createDeadArgEliminationPassEv")
//</editor-fold>
public static ModulePass /*P*/ createDeadArgEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.DeadArgumentEliminationLlvmGlobals.
  //    createDeadArgEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// DeadArgHacking pass - Same as DAE, but delete arguments of external
/// functions as well.  This is definitely not safe, and should only be used by
/// bugpoint.
//<editor-fold defaultstate="collapsed" desc="llvm::createDeadArgHackingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp", line = 101,
 FQN="llvm::createDeadArgHackingPass", NM="_ZN4llvm24createDeadArgHackingPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp -nm=_ZN4llvm24createDeadArgHackingPassEv")
//</editor-fold>
public static ModulePass /*P*/ createDeadArgHackingPass() {
  //  return /*delegate*/org.llvm.transforms.impl.DeadArgumentEliminationLlvmGlobals.
  //    createDeadArgHackingPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// DeadStoreElimination - This pass deletes stores that are post-dominated by
// must-aliased stores and are not loaded used between the stores.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDeadStoreEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp", line = 1101,
 FQN="llvm::createDeadStoreEliminationPass", NM="_ZN4llvm30createDeadStoreEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp -nm=_ZN4llvm30createDeadStoreEliminationPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDeadStoreEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.DeadStoreEliminationLlvmGlobals.
  //    createDeadStoreEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function takes a virtual register computed by an Instruction and
/// replaces it with a slot in the stack frame, allocated via alloca.
/// This allows the CFG to be changed around without fear of invalidating the
/// SSA information for the value. It returns the pointer to the alloca inserted
/// to create a stack slot for X.

/// DemoteRegToStack - This function takes a virtual register computed by an
/// Instruction and replaces it with a slot in the stack frame, allocated via
/// alloca.  This allows the CFG to be changed around without fear of
/// invalidating the SSA information for the value.  It returns the pointer to
/// the alloca inserted to create a stack slot for I.
//<editor-fold defaultstate="collapsed" desc="llvm::DemoteRegToStack">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/DemoteRegToStack.cpp", line = 24,
 FQN="llvm::DemoteRegToStack", NM="_ZN4llvm16DemoteRegToStackERNS_11InstructionEbPS0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/DemoteRegToStack.cpp -nm=_ZN4llvm16DemoteRegToStackERNS_11InstructionEbPS0_")
//</editor-fold>
public static AllocaInst /*P*/ DemoteRegToStack(final Instruction /*&*/ I) {
  //  return DemoteRegToStack(I, false, 
  //                (Instruction /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static AllocaInst /*P*/ DemoteRegToStack(final Instruction /*&*/ I, boolean VolatileLoads/*= false*/) {
  //  return DemoteRegToStack(I, VolatileLoads, 
  //                (Instruction /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static AllocaInst /*P*/ DemoteRegToStack(final Instruction /*&*/ I, boolean VolatileLoads/*= false*/, 
                Instruction /*P*/ AllocaPoint/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.DemoteRegToStackLlvmGlobals.
  //    DemoteRegToStack(I, VolatileLoads, 
  //                AllocaPoint);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function takes a virtual register computed by a phi node and replaces
/// it with a slot in the stack frame, allocated via alloca. The phi node is
/// deleted and it returns the pointer to the alloca inserted.

/// DemotePHIToStack - This function takes a virtual register computed by a PHI
/// node and replaces it with a slot in the stack frame allocated via alloca.
/// The PHI node is deleted. It returns the pointer to the alloca inserted.
//<editor-fold defaultstate="collapsed" desc="llvm::DemotePHIToStack">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/DemoteRegToStack.cpp", line = 107,
 FQN="llvm::DemotePHIToStack", NM="_ZN4llvm16DemotePHIToStackEPNS_7PHINodeEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/DemoteRegToStack.cpp -nm=_ZN4llvm16DemotePHIToStackEPNS_7PHINodeEPNS_11InstructionE")
//</editor-fold>
public static AllocaInst /*P*/ DemotePHIToStack(PHINode /*P*/ P) {
  //  return DemotePHIToStack(P, (Instruction /*P*/ )null);
  //}
  //public static AllocaInst /*P*/ DemotePHIToStack(PHINode /*P*/ P, Instruction /*P*/ AllocaPoint/*= null*/) {
  // //  return /*delegate*/org.llvm.transforms.utils.impl.DemoteRegToStackLlvmGlobals.
  // //    DemotePHIToStack(P, AllocaPoint);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// EarlyCSE - This pass performs a simple and fast CSE pass over the dominator
// tree.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createEarlyCSEPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp", line = 912,
 FQN="llvm::createEarlyCSEPass", NM="_ZN4llvm18createEarlyCSEPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm18createEarlyCSEPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createEarlyCSEPass() {
  //  return /*delegate*/org.llvm.transforms.impl.EarlyCSELlvmGlobals.
  //    createEarlyCSEPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// Insert EfficiencySanitizer instrumentation.
//<editor-fold defaultstate="collapsed" desc="llvm::createEfficiencySanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp", line = 242,
 FQN="llvm::createEfficiencySanitizerPass", NM="_ZN4llvm29createEfficiencySanitizerPassERKNS_26EfficiencySanitizerOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp -nm=_ZN4llvm29createEfficiencySanitizerPassERKNS_26EfficiencySanitizerOptionsE")
//</editor-fold>
public static ModulePass /*P*/ createEfficiencySanitizerPass() {
  return createEfficiencySanitizerPass(new EfficiencySanitizerOptions());
}
public static ModulePass /*P*/ createEfficiencySanitizerPass(EfficiencySanitizerOptions Options) {
  //  return createEfficiencySanitizerPass(new EfficiencySanitizerOptions());
  //}
  //public static ModulePass /*P*/ createEfficiencySanitizerPass(final /*const*/ EfficiencySanitizerOptions /*&*/ Options/*= EfficiencySanitizerOptions()*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.EfficiencySanitizerLlvmGlobals.
  // //    createEfficiencySanitizerPass(Options);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// This transform is designed to eliminate available external globals
/// (functions or global variables)
///
//<editor-fold defaultstate="collapsed" desc="llvm::createEliminateAvailableExternallyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp", line = 94,
 FQN="llvm::createEliminateAvailableExternallyPass", NM="_ZN4llvm38createEliminateAvailableExternallyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp -nm=_ZN4llvm38createEliminateAvailableExternallyPassEv")
//</editor-fold>
public static ModulePass /*P*/ createEliminateAvailableExternallyPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ElimAvailExternLlvmGlobals.
  //    createEliminateAvailableExternallyPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createGVExtractionPass - If deleteFn is true, this pass deletes
/// the specified global values. Otherwise, it deletes as much of the module as
/// possible, except for the global values specified.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createGVExtractionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ExtractGV.cpp", line = 160,
 FQN="llvm::createGVExtractionPass", NM="_ZN4llvm22createGVExtractionPassERSt6vectorIPNS_11GlobalValueESaIS2_EEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/ExtractGV.cpp -nm=_ZN4llvm22createGVExtractionPassERSt6vectorIPNS_11GlobalValueESaIS2_EEb")
//</editor-fold>
public static ModulePass /*P*/ createGVExtractionPass(final std.vector<GlobalValue /*P*/ > /*&*/ GVs) {
  //  return createGVExtractionPass(GVs, 
  //                      false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static ModulePass /*P*/ createGVExtractionPass(final std.vector<GlobalValue /*P*/ > /*&*/ GVs, 
                      boolean deleteFn/*= false*/) {
  //  return /*delegate*/org.llvm.transforms.impl.ExtractGVLlvmGlobals.
  //    createGVExtractionPass(GVs, 
  //                      deleteFn);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function is used to flatten a CFG. For example, it uses parallel-and
/// and parallel-or mode to collapse if-conditions and merge if-regions with
/// identical statements.

/// FlattenCFG - This function is used to flatten a CFG.  For
/// example, it uses parallel-and and parallel-or mode to collapse
//  if-conditions and merge if-regions with identical statements.
///
//<editor-fold defaultstate="collapsed" desc="llvm::FlattenCFG">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/FlattenCFG.cpp", line = 485,
 FQN="llvm::FlattenCFG", NM="_ZN4llvm10FlattenCFGEPNS_10BasicBlockEPNS_9AAResultsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/FlattenCFG.cpp -nm=_ZN4llvm10FlattenCFGEPNS_10BasicBlockEPNS_9AAResultsE")
//</editor-fold>
public static boolean FlattenCFG(BasicBlock /*P*/ BB) {
  //  return FlattenCFG(BB, (AAResults /*P*/ )null);
  //}
  //public static boolean FlattenCFG(BasicBlock /*P*/ BB, AAResults /*P*/ AA/*= null*/) {
  // //  return /*delegate*/org.llvm.transforms.utils.impl.FlattenCFGLlvmGlobals.
  // //    FlattenCFG(BB, AA);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// FlattenCFG - flatten CFG, reduce number of conditional branches by using
// parallel-and and parallel-or mode, etc...
//

// Public interface to the FlattenCFG pass
//<editor-fold defaultstate="collapsed" desc="llvm::createFlattenCFGPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp", line = 49,
 FQN="llvm::createFlattenCFGPass", NM="_ZN4llvm20createFlattenCFGPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp -nm=_ZN4llvm20createFlattenCFGPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createFlattenCFGPass() {
  //  return /*delegate*/org.llvm.transforms.impl.FlattenCFGPassLlvmGlobals.
  //    createFlattenCFGPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// Float2Int - Demote floats to ints where possible.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createFloat2IntPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp", line = 529,
 FQN="llvm::createFloat2IntPass", NM="_ZN4llvm19createFloat2IntPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp -nm=_ZN4llvm19createFloat2IntPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createFloat2IntPass() {
  //  return /*delegate*/org.llvm.transforms.impl.Float2IntLlvmGlobals.
  //    createFloat2IntPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Create a legacy pass manager instance of a pass to force function attrs.
//<editor-fold defaultstate="collapsed" desc="llvm::createForceFunctionAttrsLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 120,
 FQN="llvm::createForceFunctionAttrsLegacyPass", NM="_ZN4llvm34createForceFunctionAttrsLegacyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZN4llvm34createForceFunctionAttrsLegacyPassEv")
//</editor-fold>
public static Pass /*P*/ createForceFunctionAttrsLegacyPass() {
  return /*delegate*/org.llvm.transforms.ipo.impl.ForceFunctionAttrsLlvmGlobals.
    createForceFunctionAttrsLegacyPass();
}


/// Create a legacy pass manager instance of a pass to compute function attrs
/// in post-order.
//<editor-fold defaultstate="collapsed" desc="llvm::createPostOrderFunctionAttrsLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp", line = 1069,
 FQN="llvm::createPostOrderFunctionAttrsLegacyPass", NM="_ZN4llvm38createPostOrderFunctionAttrsLegacyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=_ZN4llvm38createPostOrderFunctionAttrsLegacyPassEv")
//</editor-fold>
public static Pass /*P*/ createPostOrderFunctionAttrsLegacyPass() {
  //  return /*delegate*/org.llvm.transforms.ipo.impl.FunctionAttrsLlvmGlobals.
  //    createPostOrderFunctionAttrsLegacyPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createReversePostOrderFunctionAttrsPass - This pass walks SCCs of the call
/// graph in RPO to deduce and propagate function attributes. Currently it
/// only handles synthesizing norecurse attributes.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createReversePostOrderFunctionAttrsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp", line = 1150,
 FQN="llvm::createReversePostOrderFunctionAttrsPass", NM="_ZN4llvm39createReversePostOrderFunctionAttrsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=_ZN4llvm39createReversePostOrderFunctionAttrsPassEv")
//</editor-fold>
public static Pass /*P*/ createReversePostOrderFunctionAttrsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.FunctionAttrsLlvmGlobals.
  //    createReversePostOrderFunctionAttrsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Compute all the imports and exports for every module in the Index.
///
/// \p ModuleToDefinedGVSummaries contains for each Module a map
/// (GUID -> Summary) for every global defined in the module.
///
/// \p ImportLists will be populated with an entry for every Module we are
/// importing into. This entry is itself a map that can be passed to
/// FunctionImporter::importFunctions() above (see description there).
///
/// \p ExportLists contains for each Module the set of globals (GUID) that will
/// be imported by another module, or referenced by such a function. I.e. this
/// is the set of globals that need to be promoted/renamed appropriately.
// anonymous namespace

/// Compute all the import and export for every module using the Index.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeCrossModuleImport">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 377,
 FQN="llvm::ComputeCrossModuleImport", NM="_ZN4llvm24ComputeCrossModuleImportERKNS_18ModuleSummaryIndexERKNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS6_EEENS_15MallocAllocatorEEERNS3_INS3_IS4_IyjS8_SaIS9_ISA_jEEESE_EESE_EERNS3_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESE_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm24ComputeCrossModuleImportERKNS_18ModuleSummaryIndexERKNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS6_EEENS_15MallocAllocatorEEERNS3_INS3_IS4_IyjS8_SaIS9_ISA_jEEESE_EESE_EERNS3_ISt13unordered_setIySt4hashIyESt8equal_toIyESaIyEESE_EE")
//</editor-fold>
public static void ComputeCrossModuleImport(final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                        final /*const*/StringMap<std.mapULongType<GlobalValueSummary /*P*/ /*P*/>> /*&*/ ModuleToDefinedGVSummaries, 
                        final StringMap<StringMap<std.mapULongUInt>> /*&*/ ImportLists, 
                        final StringMap<std.unordered_setULong/*uint64_t*/> /*&*/ ExportLists) {
  //  /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmGlobals.
  //    ComputeCrossModuleImport(Index, 
  //                        ModuleToDefinedGVSummaries, 
 //                        ImportLists, 
 //                        ExportLists);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Compute all the imports for the given module using the Index.
///
/// \p ImportList will be populated with a map that can be passed to
/// FunctionImporter::importFunctions() above (see description there).

/// Compute all the imports for the given module in the Index.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeCrossModuleImportForModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 410,
 FQN="llvm::ComputeCrossModuleImportForModule", NM="_ZN4llvm33ComputeCrossModuleImportForModuleENS_9StringRefERKNS_18ModuleSummaryIndexERNS_9StringMapISt3mapIyjSt4lessIyESaISt4pairIKyjEEENS_15MallocAllocatorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm33ComputeCrossModuleImportForModuleENS_9StringRefERKNS_18ModuleSummaryIndexERNS_9StringMapISt3mapIyjSt4lessIyESaISt4pairIKyjEEENS_15MallocAllocatorEEE")
//</editor-fold>
public static void ComputeCrossModuleImportForModule(StringRef ModulePath, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                                 final StringMap<std.mapULongUInt> /*&*/ ImportList) {
  //  /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmGlobals.
  //    ComputeCrossModuleImportForModule(ModulePath, Index, 
  //                                 ImportList);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Compute the set of summaries needed for a ThinLTO backend compilation of
/// \p ModulePath.
//
/// This includes summaries from that module (in case any global summary based
/// optimizations were recorded) and from any definitions in other modules that
/// should be imported.
//
/// \p ModuleToSummariesForIndex will be populated with the needed summaries
/// from each required module path. Use a std::map instead of StringMap to get
/// stable order for bitcode emission.

/// Compute the set of summaries needed for a ThinLTO backend compilation of
/// \p ModulePath.
//<editor-fold defaultstate="collapsed" desc="llvm::gatherImportedSummariesForModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 436,
 FQN="llvm::gatherImportedSummariesForModule", NM="_ZN4llvm32gatherImportedSummariesForModuleENS_9StringRefERKNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEENS_15MallocAllocatorEEERKNS1_INS1_IS2_IyjS6_SaIS7_IS8_jEEESC_EESC_EERS2_ISsSB_S5_ISsESaIS7_IKSsSB_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm32gatherImportedSummariesForModuleENS_9StringRefERKNS_9StringMapISt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEENS_15MallocAllocatorEEERKNS1_INS1_IS2_IyjS6_SaIS7_IS8_jEEESC_EESC_EERS2_ISsSB_S5_ISsESaIS7_IKSsSB_EEE")
//</editor-fold>
public static void gatherImportedSummariesForModule(StringRef ModulePath, 
                                final /*const*/StringMap<std.mapULongType<GlobalValueSummary /*P*/ /*P*/>> /*&*/ ModuleToDefinedGVSummaries, 
                                final /*const*/StringMap<StringMap<std.mapULongUInt>> /*&*/ ImportLists, 
                                final std.mapTypeType<std.string, std.mapULongType<GlobalValueSummary /*P*/ /*P*/>> /*&*/ ModuleToSummariesForIndex) {
  //  /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmGlobals.
  //    gatherImportedSummariesForModule(ModulePath, 
  //                                ModuleToDefinedGVSummaries, 
 //                                ImportLists, 
 //                                ModuleToSummariesForIndex);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Emit the files \p ModulePath will import from into \p OutputFilename.
//<editor-fold defaultstate="collapsed" desc="llvm::EmitImportsFiles">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 462,
 FQN="llvm::EmitImportsFiles", NM="_ZN4llvm16EmitImportsFilesENS_9StringRefES0_RKNS_9StringMapINS1_ISt3mapIyjSt4lessIyESaISt4pairIKyjEEENS_15MallocAllocatorEEESA_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm16EmitImportsFilesENS_9StringRefES0_RKNS_9StringMapINS1_ISt3mapIyjSt4lessIyESaISt4pairIKyjEEENS_15MallocAllocatorEEESA_EE")
//</editor-fold>
public static std.error_code EmitImportsFiles(StringRef ModulePath, StringRef OutputFilename, 
                final /*const*/StringMap<StringMap<std.mapULongUInt>> /*&*/ ImportLists) {
  //  return /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmGlobals.
  //    EmitImportsFiles(ModulePath, OutputFilename, 
  //                ImportLists);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Resolve WeakForLinker values in \p TheModule based on the information
/// recorded in the summaries during global summary-based analysis.

/// Fixup WeakForLinker linkages in \p TheModule based on summary analysis.
//<editor-fold defaultstate="collapsed" desc="llvm::thinLTOResolveWeakForLinkerModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 477,
 FQN="llvm::thinLTOResolveWeakForLinkerModule", NM="_ZN4llvm33thinLTOResolveWeakForLinkerModuleERNS_6ModuleERKSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm33thinLTOResolveWeakForLinkerModuleERNS_6ModuleERKSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE")
//</editor-fold>
public static void thinLTOResolveWeakForLinkerModule(final Module /*&*/ TheModule, final /*const*/std.mapULongType<GlobalValueSummary /*P*/ /*P*/> /*&*/ DefinedGlobals) {
  //  /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmGlobals.
  //    thinLTOResolveWeakForLinkerModule(TheModule, DefinedGlobals);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Internalize \p TheModule based on the information recorded in the summaries
/// during global summary-based analysis.

/// Run internalization on \p TheModule based on symmary analysis.
//<editor-fold defaultstate="collapsed" desc="llvm::thinLTOInternalizeModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 504,
 FQN="llvm::thinLTOInternalizeModule", NM="_ZN4llvm24thinLTOInternalizeModuleERNS_6ModuleERKSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm24thinLTOInternalizeModuleERNS_6ModuleERKSt3mapIyPNS_18GlobalValueSummaryESt4lessIyESaISt4pairIKyS4_EEE")
//</editor-fold>
public static void thinLTOInternalizeModule(final Module /*&*/ TheModule, 
                        final /*const*/std.mapULongType<GlobalValueSummary /*P*/ /*P*/> /*&*/ DefinedGlobals) {
  //  /*delegate*/org.llvm.transforms.ipo.impl.FunctionImportLlvmGlobals.
  //    thinLTOInternalizeModule(TheModule, 
  //                        DefinedGlobals);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper function to internalize functions and variables in a Module.
//<editor-fold defaultstate="collapsed" desc="llvm::internalizeModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO/Internalize.h", line = 70,
 FQN="llvm::internalizeModule", NM="_ZN4llvm17internalizeModuleERNS_6ModuleESt8functionIFbRKNS_11GlobalValueEEEPNS_9CallGraphE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm17internalizeModuleERNS_6ModuleESt8functionIFbRKNS_11GlobalValueEEEPNS_9CallGraphE")
//</editor-fold>
public static /*inline*/ boolean internalizeModule(final Module /*&*/ TheModule, 
                 BoolPredicate<GlobalValue> MustPreserveGV) {
  //  return internalizeModule(TheModule, 
  //                 MustPreserveGV, 
  //                 (CallGraph /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*inline*/ boolean internalizeModule(final Module /*&*/ TheModule, 
                 BoolPredicate<GlobalValue> MustPreserveGV, 
                 CallGraph /*P*/ CG/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.ipo.impl.InternalizeLlvmGlobals.
  //    internalizeModule(TheModule, 
  //                 MustPreserveGV, 
 //                 CG);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createFunctionImportPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 791,
 FQN="llvm::createFunctionImportPass", NM="_ZN4llvm24createFunctionImportPassEPKNS_18ModuleSummaryIndexE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm24createFunctionImportPassEPKNS_18ModuleSummaryIndexE")
//</editor-fold>
public static Pass /*P*/ createFunctionImportPass() {
  return createFunctionImportPass((/*const*/ ModuleSummaryIndex /*P*/ )null);
}
public static Pass /*P*/ createFunctionImportPass(/*const*/ ModuleSummaryIndex /*P*/ Index/*= null*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

/// Perform in-place global value handling on the given Module for
/// exported local functions renamed and promoted for ThinLTO.
//<editor-fold defaultstate="collapsed" desc="llvm::renameModuleForThinLTO">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/FunctionImportUtils.cpp", line = 238,
 FQN="llvm::renameModuleForThinLTO", NM="_ZN4llvm22renameModuleForThinLTOERNS_6ModuleERKNS_18ModuleSummaryIndexEPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS8_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/FunctionImportUtils.cpp -nm=_ZN4llvm22renameModuleForThinLTOERNS_6ModuleERKNS_18ModuleSummaryIndexEPNS_8DenseSetIPKNS_11GlobalValueENS_12DenseMapInfoIS8_EEEE")
//</editor-fold>
public static boolean renameModuleForThinLTO(final Module /*&*/ M, final /*const*/ ModuleSummaryIndex /*&*/ Index) {
  //  return renameModuleForThinLTO(M, Index, 
  //                      (DenseSet</*const*/ GlobalValue /*P*/ > /*P*/)null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean renameModuleForThinLTO(final Module /*&*/ M, final /*const*/ ModuleSummaryIndex /*&*/ Index, 
                      DenseSet</*const*/ GlobalValue /*P*/ > /*P*/ GlobalsToImport/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.FunctionImportUtilsLlvmGlobals.
  //    renameModuleForThinLTO(M, Index, 
  //                      GlobalsToImport);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createGCOVProfilerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp", line = 157,
 FQN="llvm::createGCOVProfilerPass", NM="_ZN4llvm22createGCOVProfilerPassERKNS_11GCOVOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm22createGCOVProfilerPassERKNS_11GCOVOptionsE")
//</editor-fold>
public static ModulePass /*P*/ createGCOVProfilerPass(GCOVOptions Options) {
  //  return createGCOVProfilerPass(GCOVOptions.getDefault());
  //}
  //public static ModulePass /*P*/ createGCOVProfilerPass(final /*const*/ GCOVOptions /*&*/ Options/*= GCOVOptions::getDefault()*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.GCOVProfilingLlvmGlobals.
  // //    createGCOVProfilerPass(Options);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


/// Create a legacy GVN pass. This also allows parameterizing whether or not
/// loads are eliminated by the pass.

/// Create a legacy GVN pass. This also allows parameterizing whether or not
/// loads are eliminated by the pass.

// The public interface to this file...
//<editor-fold defaultstate="collapsed" desc="llvm::createGVNPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp", line = 2743,
 FQN="llvm::createGVNPass", NM="_ZN4llvm13createGVNPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=_ZN4llvm13createGVNPassEb")
//</editor-fold>
public static FunctionPass /*P*/ createGVNPass() {
  return createGVNPass(false);
}
public static FunctionPass /*P*/ createGVNPass(boolean NoLoads/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// GVNHoist - This pass performs a simple and fast GVN pass over the dominator
// tree to hoist common expressions from sibling branches.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createGVNHoistPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp", line = 825,
 FQN="llvm::createGVNHoistPass", NM="_ZN4llvm18createGVNHoistPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp -nm=_ZN4llvm18createGVNHoistPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createGVNHoistPass() {
  //  return /*delegate*/org.llvm.transforms.impl.GVNHoistLlvmGlobals.
  //    createGVNHoistPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/MemorySSA.h", line = 192,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_12MemoryAccessE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_12MemoryAccessE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_MemoryAccess$C(final raw_ostream /*&*/ OS, final /*const*/ MemoryAccess /*&*/ MA) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.MemorySSALlvmGlobals.
  //    $out_raw_ostream_MemoryAccess$C(OS, MA);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::upward_defs_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/MemorySSA.h", line = 941,
 FQN="llvm::upward_defs_begin", NM="_ZN4llvm17upward_defs_beginERKSt4pairIPNS_12MemoryAccessENS_14MemoryLocationEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp -nm=_ZN4llvm17upward_defs_beginERKSt4pairIPNS_12MemoryAccessENS_14MemoryLocationEE")
//</editor-fold>
public static /*inline*/ upward_defs_iterator upward_defs_begin(final /*const*/ std.pair<MemoryAccess /*P*/ , MemoryLocation> /*&*/ Pair) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.MemorySSALlvmGlobals.
  //    upward_defs_begin(Pair);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::upward_defs_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/MemorySSA.h", line = 945,
 FQN="llvm::upward_defs_end", NM="_ZN4llvm15upward_defs_endEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp -nm=_ZN4llvm15upward_defs_endEv")
//</editor-fold>
public static /*inline*/ upward_defs_iterator upward_defs_end() {
  //  return /*delegate*/org.llvm.transforms.utils.impl.MemorySSALlvmGlobals.
  //    upward_defs_end();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createGlobalDCEPass - This transform is designed to eliminate unreachable
/// internal globals (functions or global variables)
///

// Public interface to the GlobalDCEPass.
//<editor-fold defaultstate="collapsed" desc="llvm::createGlobalDCEPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp", line = 68,
 FQN="llvm::createGlobalDCEPass", NM="_ZN4llvm19createGlobalDCEPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp -nm=_ZN4llvm19createGlobalDCEPassEv")
//</editor-fold>
public static ModulePass /*P*/ createGlobalDCEPass() {
  //  return /*delegate*/org.llvm.transforms.impl.GlobalDCELlvmGlobals.
  //    createGlobalDCEPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createGlobalOptimizerPass - This function returns a new pass that optimizes
/// non-address taken internal globals.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createGlobalOptimizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp", line = 2615,
 FQN="llvm::createGlobalOptimizerPass", NM="_ZN4llvm25createGlobalOptimizerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp -nm=_ZN4llvm25createGlobalOptimizerPassEv")
//</editor-fold>
public static ModulePass /*P*/ createGlobalOptimizerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.GlobalOptLlvmGlobals.
  //    createGlobalOptimizerPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// It is safe to destroy a constant iff it is only used by constants itself.
/// Note that constants cannot be cyclic, so this test is pretty easy to
/// implement recursively.
///

/// It is safe to destroy a constant iff it is only used by constants itself.
/// Note that constants cannot be cyclic, so this test is pretty easy to
/// implement recursively.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isSafeToDestroyConstant">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/GlobalStatus.cpp", line = 34,
 FQN="llvm::isSafeToDestroyConstant", NM="_ZN4llvm23isSafeToDestroyConstantEPKNS_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/GlobalStatus.cpp -nm=_ZN4llvm23isSafeToDestroyConstantEPKNS_8ConstantE")
//</editor-fold>
public static boolean isSafeToDestroyConstant(/*const*/ Constant /*P*/ C) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.GlobalStatusLlvmGlobals.
  //    isSafeToDestroyConstant(C);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// GuardWidening - An optimization over the @llvm.experimental.guard intrinsic
// that (optimistically) combines multiple guards into one to have fewer checks
// at runtime.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createGuardWideningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp", line = 689,
 FQN="llvm::createGuardWideningPass", NM="_ZN4llvm23createGuardWideningPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm23createGuardWideningPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createGuardWideningPass() {
  //  return /*delegate*/org.llvm.transforms.impl.GuardWideningLlvmGlobals.
  //    createGuardWideningPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createIPConstantPropagationPass - This pass propagates constants from call
/// sites into the bodies of functions.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createIPConstantPropagationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp", line = 256,
 FQN="llvm::createIPConstantPropagationPass", NM="_ZN4llvm31createIPConstantPropagationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp -nm=_ZN4llvm31createIPConstantPropagationPassEv")
//</editor-fold>
public static ModulePass /*P*/ createIPConstantPropagationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.IPConstantPropagationLlvmGlobals.
  //    createIPConstantPropagationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// InductionVariableSimplify - Transform induction variables in a program to all
// use a single canonical induction variable per loop.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createIndVarSimplifyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp", line = 2286,
 FQN="llvm::createIndVarSimplifyPass", NM="_ZN4llvm24createIndVarSimplifyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp -nm=_ZN4llvm24createIndVarSimplifyPassEv")
//</editor-fold>
public static Pass /*P*/ createIndVarSimplifyPass() {
  //  return /*delegate*/org.llvm.transforms.impl.IndVarSimplifyLlvmGlobals.
  //    createIndVarSimplifyPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPGOIndirectCallPromotionLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp", line = 124,
 FQN="llvm::createPGOIndirectCallPromotionLegacyPass", NM="_ZN4llvm40createPGOIndirectCallPromotionLegacyPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm40createPGOIndirectCallPromotionLegacyPassEb")
//</editor-fold>
public static ModulePass /*P*/ createPGOIndirectCallPromotionLegacyPass() {
  return createPGOIndirectCallPromotionLegacyPass(false);
}
public static ModulePass /*P*/ createPGOIndirectCallPromotionLegacyPass(boolean InLTO/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// InductiveRangeCheckElimination - Transform loops to elide range checks on
// linear functions of the induction variable.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createInductiveRangeCheckEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp", line = 1472,
 FQN="llvm::createInductiveRangeCheckEliminationPass", NM="_ZN4llvm40createInductiveRangeCheckEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp -nm=_ZN4llvm40createInductiveRangeCheckEliminationPassEv")
//</editor-fold>
public static Pass /*P*/ createInductiveRangeCheckEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.InductiveRangeCheckEliminationLlvmGlobals.
  //    createInductiveRangeCheckEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Create a legacy pass manager instance of a pass to infer function
/// attributes.
//<editor-fold defaultstate="collapsed" desc="llvm::createInferFunctionAttrsLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp", line = 78,
 FQN="llvm::createInferFunctionAttrsLegacyPass", NM="_ZN4llvm34createInferFunctionAttrsLegacyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp -nm=_ZN4llvm34createInferFunctionAttrsLegacyPassEv")
//</editor-fold>
public static Pass /*P*/ createInferFunctionAttrsLegacyPass() {
  //  return /*delegate*/org.llvm.transforms.ipo.impl.InferFunctionAttrsLlvmGlobals.
  //    createInferFunctionAttrsLegacyPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createAlwaysInlinerPass - Return a new pass object that inlines only
/// functions that are marked as "always_inline".
//<editor-fold defaultstate="collapsed" desc="llvm::createAlwaysInlinerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO.h", line = 110,
 FQN="llvm::createAlwaysInlinerPass", NM="_ZN4llvm23createAlwaysInlinerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm23createAlwaysInlinerPassEv")
//</editor-fold>
public static Pass /*P*/ createAlwaysInlinerPass() {
  return /*delegate*/org.llvm.transforms.impl.InlineAlwaysLlvmGlobals.
    createAlwaysInlinerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createAlwaysInlinerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/IPO.h", line = 111,
 FQN="llvm::createAlwaysInlinerPass", NM="_ZN4llvm23createAlwaysInlinerPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm23createAlwaysInlinerPassEb")
//</editor-fold>
public static Pass /*P*/ createAlwaysInlinerPass(boolean InsertLifetime) {
  return /*delegate*/org.llvm.transforms.impl.InlineAlwaysLlvmGlobals.
    createAlwaysInlinerPass(InsertLifetime);
}


/// InlineFunction - This function inlines the called function into the basic
/// block of the caller.  This returns false if it is not possible to inline
/// this call.  The program is still in a well defined state if this occurs
/// though.
///
/// Note that this only does one level of inlining.  For example, if the
/// instruction 'call B' is inlined, and 'B' calls 'C', then the call to 'C' now
/// exists in the instruction stream.  Similarly this will inline a recursive
/// function by one level.
///
//<editor-fold defaultstate="collapsed" desc="llvm::InlineFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp", line = 58,
 FQN="llvm::InlineFunction", NM="_ZN4llvm14InlineFunctionEPNS_8CallInstERNS_18InlineFunctionInfoEPNS_9AAResultsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp -nm=_ZN4llvm14InlineFunctionEPNS_8CallInstERNS_18InlineFunctionInfoEPNS_9AAResultsEb")
//</editor-fold>
public static boolean InlineFunction(CallInst /*P*/ CI, final InlineFunctionInfo /*&*/ IFI) {
  //  return InlineFunction(CI, IFI, 
  //              (AAResults /*P*/ )null, true);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean InlineFunction(CallInst /*P*/ CI, final InlineFunctionInfo /*&*/ IFI, 
              AAResults /*P*/ CalleeAAR/*= null*/) {
  //  return InlineFunction(CI, IFI, 
  //              CalleeAAR, true);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean InlineFunction(CallInst /*P*/ CI, final InlineFunctionInfo /*&*/ IFI, 
              AAResults /*P*/ CalleeAAR/*= null*/, boolean InsertLifetime/*= true*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.InlineFunctionLlvmGlobals.
  //    InlineFunction(CI, IFI, 
  //              CalleeAAR, InsertLifetime);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::InlineFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp", line = 62,
 FQN="llvm::InlineFunction", NM="_ZN4llvm14InlineFunctionEPNS_10InvokeInstERNS_18InlineFunctionInfoEPNS_9AAResultsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp -nm=_ZN4llvm14InlineFunctionEPNS_10InvokeInstERNS_18InlineFunctionInfoEPNS_9AAResultsEb")
//</editor-fold>
public static boolean InlineFunction(InvokeInst /*P*/ II, final InlineFunctionInfo /*&*/ IFI) {
  //  return InlineFunction(II, IFI, 
  //              (AAResults /*P*/ )null, true);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean InlineFunction(InvokeInst /*P*/ II, final InlineFunctionInfo /*&*/ IFI, 
              AAResults /*P*/ CalleeAAR/*= null*/) {
  //  return InlineFunction(II, IFI, 
  //              CalleeAAR, true);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean InlineFunction(InvokeInst /*P*/ II, final InlineFunctionInfo /*&*/ IFI, 
              AAResults /*P*/ CalleeAAR/*= null*/, boolean InsertLifetime/*= true*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.InlineFunctionLlvmGlobals.
  //    InlineFunction(II, IFI, 
  //              CalleeAAR, InsertLifetime);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function inlines the called function into the basic block of the
/// caller. This returns false if it is not possible to inline this call.
/// The program is still in a well defined state if this occurs though.
///
/// Note that this only does one level of inlining.  For example, if the
/// instruction 'call B' is inlined, and 'B' calls 'C', then the call to 'C' now
/// exists in the instruction stream.  Similarly this will inline a recursive
/// function by one level.
//<editor-fold defaultstate="collapsed" desc="llvm::InlineFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp", line = 1357,
 FQN="llvm::InlineFunction", NM="_ZN4llvm14InlineFunctionENS_8CallSiteERNS_18InlineFunctionInfoEPNS_9AAResultsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/InlineFunction.cpp -nm=_ZN4llvm14InlineFunctionENS_8CallSiteERNS_18InlineFunctionInfoEPNS_9AAResultsEb")
//</editor-fold>
public static boolean InlineFunction(CallSite CS, final InlineFunctionInfo /*&*/ IFI) {
  //  return InlineFunction(CS, IFI, 
  //              (AAResults /*P*/ )null, true);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean InlineFunction(CallSite CS, final InlineFunctionInfo /*&*/ IFI, 
              AAResults /*P*/ CalleeAAR/*= null*/) {
  //  return InlineFunction(CS, IFI, 
  //              CalleeAAR, true);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean InlineFunction(CallSite CS, final InlineFunctionInfo /*&*/ IFI, 
              AAResults /*P*/ CalleeAAR/*= null*/, boolean InsertLifetime/*= true*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.InlineFunctionLlvmGlobals.
  //    InlineFunction(CS, IFI, 
  //              CalleeAAR, InsertLifetime);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createFunctionInliningPass - Return a new pass object that uses a heuristic
/// to inline direct function calls to small functions.
///
/// The Threshold can be passed directly, or asked to be computed from the
/// given optimization and size optimization arguments.
///
/// The -inline-threshold command line option takes precedence over the
/// threshold given here.
//<editor-fold defaultstate="collapsed" desc="llvm::createFunctionInliningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp", line = 87,
 FQN="llvm::createFunctionInliningPass", NM="_ZN4llvm26createFunctionInliningPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp -nm=_ZN4llvm26createFunctionInliningPassEv")
//</editor-fold>
public static Pass /*P*/ createFunctionInliningPass() {
  //  return /*delegate*/org.llvm.transforms.impl.InlineSimpleLlvmGlobals.
  //    createFunctionInliningPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createFunctionInliningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp", line = 89,
 FQN="llvm::createFunctionInliningPass", NM="_ZN4llvm26createFunctionInliningPassEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp -nm=_ZN4llvm26createFunctionInliningPassEi")
//</editor-fold>
public static Pass /*P*/ createFunctionInliningPass(int Threshold) {
  //  return /*delegate*/org.llvm.transforms.impl.InlineSimpleLlvmGlobals.
  //    createFunctionInliningPass(Threshold);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createFunctionInliningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp", line = 93,
 FQN="llvm::createFunctionInliningPass", NM="_ZN4llvm26createFunctionInliningPassEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp -nm=_ZN4llvm26createFunctionInliningPassEjj")
//</editor-fold>
public static Pass /*P*/ createFunctionInliningPass(/*uint*/int OptLevel, 
                          /*uint*/int SizeOptLevel) {
  //  return /*delegate*/org.llvm.transforms.impl.InlineSimpleLlvmGlobals.
  //    createFunctionInliningPass(OptLevel, 
  //                          SizeOptLevel);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Insert frontend instrumentation based profiling.
//<editor-fold defaultstate="collapsed" desc="llvm::createInstrProfilingLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp", line = 81,
 FQN="llvm::createInstrProfilingLegacyPass", NM="_ZN4llvm30createInstrProfilingLegacyPassERKNS_16InstrProfOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp -nm=_ZN4llvm30createInstrProfilingLegacyPassERKNS_16InstrProfOptionsE")
//</editor-fold>
public static ModulePass /*P*/ createInstrProfilingLegacyPass(InstrProfOptions Options) {
  //  return createInstrProfilingLegacyPass($c$.track(new InstrProfOptions()));
  //}
  //public static ModulePass /*P*/ createInstrProfilingLegacyPass(final /*const*/ InstrProfOptions /*&*/ Options/*= InstrProfOptions()*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.InstrProfilingLlvmGlobals.
  // //    createInstrProfilingLegacyPass(Options);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// InstructionCombining - Combine instructions to form fewer, simple
// instructions. This pass does not modify the CFG, and has a tendency to make
// instructions dead, so a subsequent DCE pass is useful.
//
// This pass combines things like:
//    %Y = add int 1, %X
//    %Z = add int 1, %Y
// into:
//    %Z = add int 2, %X
//
//<editor-fold defaultstate="collapsed" desc="llvm::createInstructionCombiningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp", line = 3221,
 FQN="llvm::createInstructionCombiningPass", NM="_ZN4llvm30createInstructionCombiningPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm30createInstructionCombiningPassEb")
//</editor-fold>
public static FunctionPass /*P*/ createInstructionCombiningPass() {
  return createInstructionCombiningPass(true);
}
public static FunctionPass /*P*/ createInstructionCombiningPass(boolean ExpensiveCombines/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// InstructionNamer - Give any unnamed non-void instructions "tmp" names.
//
//===----------------------------------------------------------------------===//
//
// InstructionNamer - Give any unnamed non-void instructions "tmp" names.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createInstructionNamerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp", line = 62,
 FQN="llvm::createInstructionNamerPass", NM="_ZN4llvm26createInstructionNamerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp -nm=_ZN4llvm26createInstructionNamerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createInstructionNamerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.InstructionNamerLlvmGlobals.
  //    createInstructionNamerPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::InstructionNamerID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp", line = 57,
 FQN="llvm::InstructionNamerID", NM="_ZN4llvm18InstructionNamerIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp -nm=_ZN4llvm18InstructionNamerIDE")
//</editor-fold>
public static final char$ref/*char &*/ InstructionNamerID = InstNamer.ID;

/// Instrumentation passes often insert conditional checks into entry blocks.
/// Call this function before splitting the entry block to move instructions
/// that must remain in the entry block up before the split point. Static
/// allocas and llvm.localescape calls, for example, must remain in the entry
/// block.

/// Instrumentation passes often insert conditional checks into entry blocks.
/// Call this function before splitting the entry block to move instructions
/// that must remain in the entry block up before the split point. Static
/// allocas and llvm.localescape calls, for example, must remain in the entry
/// block.
//<editor-fold defaultstate="collapsed" desc="llvm::PrepareToSplitEntryBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp", line = 38,
 FQN="llvm::PrepareToSplitEntryBlock", NM="_ZN4llvm24PrepareToSplitEntryBlockERNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/Instrumentation.cpp -nm=_ZN4llvm24PrepareToSplitEntryBlockERNS_10BasicBlockENS_14ilist_iteratorINS_11InstructionEEE")
//</editor-fold>
public static ilist_iterator<Instruction> PrepareToSplitEntryBlock(final BasicBlock /*&*/ BB, 
                        ilist_iterator<Instruction> IP) {
  //  return /*delegate*/org.llvm.transforms.impl.InstrumentationLlvmGlobals.
  //    PrepareToSplitEntryBlock(BB, 
  //                        IP);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generate code to calculate the remainder of two integers, replacing Rem
/// with the generated code. This currently generates code using the udiv
/// expansion, but future work includes generating more specialized code,
/// e.g. when more information about the operands are known. Implements both
/// 32bit and 64bit scalar division.
///
/// @brief Replace Rem with generated code.

/// Generate code to calculate the remainder of two integers, replacing Rem with
/// the generated code. This currently generates code using the udiv expansion,
/// but future work includes generating more specialized code, e.g. when more
/// information about the operands are known. Implements both 32bit and 64bit
/// scalar division.
///
/// @brief Replace Rem with generated code.
//<editor-fold defaultstate="collapsed" desc="llvm::expandRemainder">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp", line = 376,
 FQN="llvm::expandRemainder", NM="_ZN4llvm15expandRemainderEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp -nm=_ZN4llvm15expandRemainderEPNS_14BinaryOperatorE")
//</editor-fold>
public static boolean expandRemainder(BinaryOperator /*P*/ Rem) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.IntegerDivisionLlvmGlobals.
  //    expandRemainder(Rem);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generate code to divide two integers, replacing Div with the generated
/// code. This currently generates code similarly to compiler-rt's
/// implementations, but future work includes generating more specialized code
/// when more information about the operands are known. Implements both
/// 32bit and 64bit scalar division.
///
/// @brief Replace Div with generated code.

/// Generate code to divide two integers, replacing Div with the generated
/// code. This currently generates code similarly to compiler-rt's
/// implementations, but future work includes generating more specialized code
/// when more information about the operands are known. Implements both
/// 32bit and 64bit scalar division.
///
/// @brief Replace Div with generated code.
//<editor-fold defaultstate="collapsed" desc="llvm::expandDivision">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp", line = 434,
 FQN="llvm::expandDivision", NM="_ZN4llvm14expandDivisionEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp -nm=_ZN4llvm14expandDivisionEPNS_14BinaryOperatorE")
//</editor-fold>
public static boolean expandDivision(BinaryOperator /*P*/ Div) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.IntegerDivisionLlvmGlobals.
  //    expandDivision(Div);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generate code to calculate the remainder of two integers, replacing Rem
/// with the generated code. Uses ExpandReminder with a 32bit Rem which
/// makes it useful for targets with little or no support for less than
/// 32 bit arithmetic.
///
/// @brief Replace Rem with generated code.

/// Generate code to compute the remainder of two integers of bitwidth up to 
/// 32 bits. Uses the above routines and extends the inputs/truncates the
/// outputs to operate in 32 bits; that is, these routines are good for targets
/// that have no or very little suppport for smaller than 32 bit integer 
/// arithmetic.
///
/// @brief Replace Rem with emulation code.
//<editor-fold defaultstate="collapsed" desc="llvm::expandRemainderUpTo32Bits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp", line = 486,
 FQN="llvm::expandRemainderUpTo32Bits", NM="_ZN4llvm25expandRemainderUpTo32BitsEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp -nm=_ZN4llvm25expandRemainderUpTo32BitsEPNS_14BinaryOperatorE")
//</editor-fold>
public static boolean expandRemainderUpTo32Bits(BinaryOperator /*P*/ Rem) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.IntegerDivisionLlvmGlobals.
  //    expandRemainderUpTo32Bits(Rem);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generate code to calculate the remainder of two integers, replacing Rem
/// with the generated code. Uses ExpandReminder with a 64bit Rem.
///
/// @brief Replace Rem with generated code.

/// Generate code to compute the remainder of two integers of bitwidth up to 
/// 64 bits. Uses the above routines and extends the inputs/truncates the
/// outputs to operate in 64 bits.
///
/// @brief Replace Rem with emulation code.
//<editor-fold defaultstate="collapsed" desc="llvm::expandRemainderUpTo64Bits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp", line = 535,
 FQN="llvm::expandRemainderUpTo64Bits", NM="_ZN4llvm25expandRemainderUpTo64BitsEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp -nm=_ZN4llvm25expandRemainderUpTo64BitsEPNS_14BinaryOperatorE")
//</editor-fold>
public static boolean expandRemainderUpTo64Bits(BinaryOperator /*P*/ Rem) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.IntegerDivisionLlvmGlobals.
  //    expandRemainderUpTo64Bits(Rem);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generate code to divide two integers, replacing Div with the generated
/// code. Uses ExpandDivision with a 32bit Div which makes it useful for
/// targets with little or no support for less than 32 bit arithmetic.
///
/// @brief Replace Rem with generated code.

/// Generate code to divide two integers of bitwidth up to 32 bits. Uses the
/// above routines and extends the inputs/truncates the outputs to operate
/// in 32 bits; that is, these routines are good for targets that have no
/// or very little support for smaller than 32 bit integer arithmetic.
///
/// @brief Replace Div with emulation code.
//<editor-fold defaultstate="collapsed" desc="llvm::expandDivisionUpTo32Bits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp", line = 584,
 FQN="llvm::expandDivisionUpTo32Bits", NM="_ZN4llvm24expandDivisionUpTo32BitsEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp -nm=_ZN4llvm24expandDivisionUpTo32BitsEPNS_14BinaryOperatorE")
//</editor-fold>
public static boolean expandDivisionUpTo32Bits(BinaryOperator /*P*/ Div) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.IntegerDivisionLlvmGlobals.
  //    expandDivisionUpTo32Bits(Div);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Generate code to divide two integers, replacing Div with the generated
/// code. Uses ExpandDivision with a 64bit Div.
///
/// @brief Replace Rem with generated code.

/// Generate code to divide two integers of bitwidth up to 64 bits. Uses the
/// above routines and extends the inputs/truncates the outputs to operate
/// in 64 bits.
///
/// @brief Replace Div with emulation code.
//<editor-fold defaultstate="collapsed" desc="llvm::expandDivisionUpTo64Bits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp", line = 632,
 FQN="llvm::expandDivisionUpTo64Bits", NM="_ZN4llvm24expandDivisionUpTo64BitsEPNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/IntegerDivision.cpp -nm=_ZN4llvm24expandDivisionUpTo64BitsEPNS_14BinaryOperatorE")
//</editor-fold>
public static boolean expandDivisionUpTo64Bits(BinaryOperator /*P*/ Div) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.IntegerDivisionLlvmGlobals.
  //    expandDivisionUpTo64Bits(Div);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createInternalizePass - This pass loops over all of the functions in the
/// input module, internalizing all globals (functions and variables) it can.
////
/// Before internalizing a symbol, the callback \p MustPreserveGV is invoked and
/// gives to the client the ability to prevent internalizing specific symbols.
///
/// The symbol in DSOList are internalized if it is safe to drop them from
/// the symbol table.
///
/// Note that commandline options that are used with the above function are not
/// used now!
//<editor-fold defaultstate="collapsed" desc="llvm::createInternalizePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp", line = 291,
 FQN="llvm::createInternalizePass", NM="_ZN4llvm21createInternalizePassESt8functionIFbRKNS_11GlobalValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp -nm=_ZN4llvm21createInternalizePassESt8functionIFbRKNS_11GlobalValueEEE")
//</editor-fold>
public static ModulePass /*P*/ createInternalizePass(BoolPredicate<GlobalValue> MustPreserveGV) {
  //  return /*delegate*/org.llvm.transforms.impl.InternalizeLlvmGlobals.
  //    createInternalizePass(MustPreserveGV);
  throw new UnsupportedOperationException("EmptyBody");
}


/// createInternalizePass - Same as above, but with an empty exportList.
//<editor-fold defaultstate="collapsed" desc="llvm::createInternalizePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp", line = 287,
 FQN="llvm::createInternalizePass", NM="_ZN4llvm21createInternalizePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp -nm=_ZN4llvm21createInternalizePassEv")
//</editor-fold>
public static ModulePass /*P*/ createInternalizePass() {
  //  return /*delegate*/org.llvm.transforms.impl.InternalizeLlvmGlobals.
  //    createInternalizePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// JumpThreading - Thread control through mult-pred/multi-succ blocks where some
// preds always go to some succ. Thresholds other than minus one override the
// internal BB duplication default threshold.
//

// Public interface to the Jump Threading pass
//<editor-fold defaultstate="collapsed" desc="llvm::createJumpThreadingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp", line = 111,
 FQN="llvm::createJumpThreadingPass", NM="_ZN4llvm23createJumpThreadingPassEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp -nm=_ZN4llvm23createJumpThreadingPassEi")
//</editor-fold>
public static FunctionPass /*P*/ createJumpThreadingPass() {
  //  return createJumpThreadingPass(-1);
  //}
  //public static FunctionPass /*P*/ createJumpThreadingPass(int Threshold/*= -1*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.JumpThreadingLlvmGlobals.
  // //    createJumpThreadingPass(Threshold);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LCSSA - This pass inserts phi nodes at loop boundaries to simplify other loop
// optimizations.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLCSSAPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 345,
 FQN="llvm::createLCSSAPass", NM="_ZN4llvm15createLCSSAPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm15createLCSSAPassEv")
//</editor-fold>
public static Pass /*P*/ createLCSSAPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LCSSALlvmGlobals.
  //    createLCSSAPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Ensures LCSSA form for every instruction from the Worklist in the scope of
/// innermost containing loop.
///
/// For the given instruction which have uses outside of the loop, an LCSSA PHI
/// node is inserted and the uses outside the loop are rewritten to use this
/// node.
///
/// LoopInfo and DominatorTree are required and, since the routine makes no
/// changes to CFG, preserved.
///
/// Returns true if any modifications are made.

/// For every instruction from the worklist, check to see if it has any uses
/// that are outside the current loop.  If so, insert LCSSA PHI nodes and
/// rewrite the uses.
//<editor-fold defaultstate="collapsed" desc="llvm::formLCSSAForInstructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 63,
 FQN="llvm::formLCSSAForInstructions", NM="_ZN4llvm24formLCSSAForInstructionsERNS_15SmallVectorImplIPNS_11InstructionEEERNS_13DominatorTreeERNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm24formLCSSAForInstructionsERNS_15SmallVectorImplIPNS_11InstructionEEERNS_13DominatorTreeERNS_8LoopInfoE")
//</editor-fold>
public static boolean formLCSSAForInstructions(final SmallVectorImpl<Instruction /*P*/ > /*&*/ Worklist, 
                        final DominatorTree /*&*/ DT, final LoopInfo /*&*/ LI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LCSSALlvmGlobals.
  //    formLCSSAForInstructions(Worklist, 
  //                        DT, LI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Put loop into LCSSA form.
///
/// Looks at all instructions in the loop which have uses outside of the
/// current loop. For each, an LCSSA PHI node is inserted and the uses outside
/// the loop are rewritten to use this node.
///
/// LoopInfo and DominatorTree are required and preserved.
///
/// If ScalarEvolution is passed in, it will be preserved.
///
/// Returns true if any modifications are made to the loop.
//<editor-fold defaultstate="collapsed" desc="llvm::formLCSSA">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 237,
 FQN="llvm::formLCSSA", NM="_ZN4llvm9formLCSSAERNS_4LoopERNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm9formLCSSAERNS_4LoopERNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionE")
//</editor-fold>
public static boolean formLCSSA(final Loop /*&*/ L, final DominatorTree /*&*/ DT, LoopInfo /*P*/ LI, 
         ScalarEvolution /*P*/ SE) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LCSSALlvmGlobals.
  //    formLCSSA(L, DT, LI, 
  //         SE);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Put a loop nest into LCSSA form.
///
/// This recursively forms LCSSA for a loop nest.
///
/// LoopInfo and DominatorTree are required and preserved.
///
/// If ScalarEvolution is passed in, it will be preserved.
///
/// Returns true if any modifications are made to the loop.

/// Process a loop nest depth first.
//<editor-fold defaultstate="collapsed" desc="llvm::formLCSSARecursively">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 284,
 FQN="llvm::formLCSSARecursively", NM="_ZN4llvm20formLCSSARecursivelyERNS_4LoopERNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm20formLCSSARecursivelyERNS_4LoopERNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionE")
//</editor-fold>
public static boolean formLCSSARecursively(final Loop /*&*/ L, final DominatorTree /*&*/ DT, LoopInfo /*P*/ LI, 
                    ScalarEvolution /*P*/ SE) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LCSSALlvmGlobals.
  //    formLCSSARecursively(L, DT, LI, 
  //                    SE);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::LCSSAID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 346,
 FQN="llvm::LCSSAID", NM="_ZN4llvm7LCSSAIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm7LCSSAIDE")
//</editor-fold>
public static final char$ref/*char &*/ LCSSAID = LCSSAWrapperPass.ID;

//===----------------------------------------------------------------------===//
//
// LICM - This pass is a loop invariant code motion and memory promotion pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLICMPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 206,
 FQN="llvm::createLICMPass", NM="_ZN4llvm14createLICMPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm14createLICMPassEv")
//</editor-fold>
public static Pass /*P*/ createLICMPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LICMLlvmGlobals.
  //    createLICMPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Walk the specified region of the CFG (defined by all blocks
/// dominated by the specified block, and that are in the current loop) in
/// reverse depth first order w.r.t the DominatorTree. This allows us to visit
/// uses before definitions, allowing us to sink a loop body in one pass without
/// iteration. Takes DomTreeNode, AliasAnalysis, LoopInfo, DominatorTree,
/// DataLayout, TargetLibraryInfo, Loop, AliasSet information for all
/// instructions of the loop and loop safety information as arguments.
/// It returns changed status.

/// Walk the specified region of the CFG (defined by all blocks dominated by
/// the specified block, and that are in the current loop) in reverse depth
/// first order w.r.t the DominatorTree.  This allows us to visit uses before
/// definitions, allowing us to sink a loop body in one pass without iteration.
///
//<editor-fold defaultstate="collapsed" desc="llvm::sinkRegion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 295,
 FQN="llvm::sinkRegion", NM="_ZN4llvm10sinkRegionEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_9AAResultsEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm10sinkRegionEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_9AAResultsEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE")
//</editor-fold>
public static boolean sinkRegion(DomTreeNodeBase<BasicBlock> /*P*/ N, AAResults /*P*/ AA, LoopInfo /*P*/ LI, 
          DominatorTree /*P*/ DT, TargetLibraryInfo /*P*/ TLI, Loop /*P*/ CurLoop, 
          AliasSetTracker /*P*/ CurAST, LoopSafetyInfo /*P*/ SafetyInfo) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LICMLlvmGlobals.
  //    sinkRegion(N, AA, LI, 
  //          DT, TLI, CurLoop, 
 //          CurAST, SafetyInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Walk the specified region of the CFG (defined by all blocks
/// dominated by the specified block, and that are in the current loop) in depth
/// first order w.r.t the DominatorTree.  This allows us to visit definitions
/// before uses, allowing us to hoist a loop body in one pass without iteration.
/// Takes DomTreeNode, AliasAnalysis, LoopInfo, DominatorTree, DataLayout,
/// TargetLibraryInfo, Loop, AliasSet information for all instructions of the
/// loop and loop safety information as arguments. It returns changed status.

/// Walk the specified region of the CFG (defined by all blocks dominated by
/// the specified block, and that are in the current loop) in depth first
/// order w.r.t the DominatorTree.  This allows us to visit definitions before
/// uses, allowing us to hoist a loop body in one pass without iteration.
///
//<editor-fold defaultstate="collapsed" desc="llvm::hoistRegion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 353,
 FQN="llvm::hoistRegion", NM="_ZN4llvm11hoistRegionEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_9AAResultsEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm11hoistRegionEPNS_15DomTreeNodeBaseINS_10BasicBlockEEEPNS_9AAResultsEPNS_8LoopInfoEPNS_13DominatorTreeEPNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE")
//</editor-fold>
public static boolean hoistRegion(DomTreeNodeBase<BasicBlock> /*P*/ N, AAResults /*P*/ AA, LoopInfo /*P*/ LI, 
           DominatorTree /*P*/ DT, TargetLibraryInfo /*P*/ TLI, Loop /*P*/ CurLoop, 
           AliasSetTracker /*P*/ CurAST, LoopSafetyInfo /*P*/ SafetyInfo) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LICMLlvmGlobals.
  //    hoistRegion(N, AA, LI, 
  //           DT, TLI, CurLoop, 
 //           CurAST, SafetyInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Try to promote memory values to scalars by sinking stores out of
/// the loop and moving loads to before the loop.  We do this by looping over
/// the stores in the loop, looking for stores to Must pointers which are
/// loop invariant. It takes AliasSet, Loop exit blocks vector, loop exit blocks
/// insertion point vector, PredIteratorCache, LoopInfo, DominatorTree, Loop,
/// AliasSet information for all instructions of the loop and loop safety
/// information as arguments. It returns changed status.
// end anon namespace

/// Try to promote memory values to scalars by sinking stores out of the
/// loop and moving loads to before the loop.  We do this by looping over
/// the stores in the loop, looking for stores to Must pointers which are
/// loop invariant.
///
//<editor-fold defaultstate="collapsed" desc="llvm::promoteLoopAccessesToScalars">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 844,
 FQN="llvm::promoteLoopAccessesToScalars", NM="_ZN4llvm28promoteLoopAccessesToScalarsERNS_8AliasSetERNS_15SmallVectorImplIPNS_10BasicBlockEEERNS2_IPNS_11InstructionEEERNS_17PredIteratorCacheEPNS_8LoopInfoEPNS_13DominatorTreeEPKNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm28promoteLoopAccessesToScalarsERNS_8AliasSetERNS_15SmallVectorImplIPNS_10BasicBlockEEERNS2_IPNS_11InstructionEEERNS_17PredIteratorCacheEPNS_8LoopInfoEPNS_13DominatorTreeEPKNS_17TargetLibraryInfoEPNS_4LoopEPNS_15AliasSetTrackerEPNS_14LoopSafetyInfoE")
//</editor-fold>
public static boolean promoteLoopAccessesToScalars(final AliasSet /*&*/ AS, final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ ExitBlocks, 
                            final SmallVectorImpl<Instruction /*P*/ > /*&*/ InsertPts, final PredIteratorCache /*&*/ PIC, 
                            LoopInfo /*P*/ LI, DominatorTree /*P*/ DT, /*const*/ TargetLibraryInfo /*P*/ TLI, 
                            Loop /*P*/ CurLoop, AliasSetTracker /*P*/ CurAST, LoopSafetyInfo /*P*/ SafetyInfo) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LICMLlvmGlobals.
  //    promoteLoopAccessesToScalars(AS, ExitBlocks, 
  //                            InsertPts, PIC, 
 //                            LI, DT, TLI, 
 //                            CurLoop, CurAST, SafetyInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Computes safety information for a loop
/// checks loop body & header for the possibility of may throw
/// exception, it takes LoopSafetyInfo and loop as argument.
/// Updates safety information in LoopSafetyInfo argument.

/// Computes loop safety information, checks loop body & header
/// for the possibility of may throw exception.
///
//<editor-fold defaultstate="collapsed" desc="llvm::computeLoopSafetyInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 409,
 FQN="llvm::computeLoopSafetyInfo", NM="_ZN4llvm21computeLoopSafetyInfoEPNS_14LoopSafetyInfoEPNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm21computeLoopSafetyInfoEPNS_14LoopSafetyInfoEPNS_4LoopE")
//</editor-fold>
public static void computeLoopSafetyInfo(LoopSafetyInfo /*P*/ SafetyInfo, Loop /*P*/ CurLoop) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LICMLlvmGlobals.
  //    computeLoopSafetyInfo(SafetyInfo, CurLoop);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoadCombine - Combine loads into bigger loads.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoadCombinePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp", line = 277,
 FQN="llvm::createLoadCombinePass", NM="_ZN4llvm21createLoadCombinePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp -nm=_ZN4llvm21createLoadCombinePassEv")
//</editor-fold>
public static BasicBlockPass /*P*/ createLoadCombinePass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoadCombineLlvmGlobals.
  //    createLoadCombinePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoadStoreVectorizer - Create vector loads and stores, but leave scalar
// operations.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoadStoreVectorizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp", line = 176,
 FQN="llvm::createLoadStoreVectorizerPass", NM="_ZN4llvm29createLoadStoreVectorizerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp -nm=_ZN4llvm29createLoadStoreVectorizerPassEv")
//</editor-fold>
public static Pass /*P*/ createLoadStoreVectorizerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoadStoreVectorizerLlvmGlobals.
  //    createLoadStoreVectorizerPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Local constant propagation.
//

/// If a terminator instruction is predicated on a constant value, convert it
/// into an unconditional branch to the constant destination.
/// This is a nontrivial operation because the successors of this basic block
/// must have their PHI nodes updated.
/// Also calls RecursivelyDeleteTriviallyDeadInstructions() on any branch/switch
/// conditions and indirectbr addresses this might make dead if
/// DeleteDeadConditions is true.

//===----------------------------------------------------------------------===//
//  Local constant propagation.
//

/// ConstantFoldTerminator - If a terminator instruction is predicated on a
/// constant value, convert it into an unconditional branch to the constant
/// destination.  This is a nontrivial operation because the successors of this
/// basic block must have their PHI nodes updated.
/// Also calls RecursivelyDeleteTriviallyDeadInstructions() on any branch/switch
/// conditions and indirectbr addresses this might make dead if
/// DeleteDeadConditions is true.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldTerminator">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 68,
 FQN="llvm::ConstantFoldTerminator", NM="_ZN4llvm22ConstantFoldTerminatorEPNS_10BasicBlockEbPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm22ConstantFoldTerminatorEPNS_10BasicBlockEbPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean ConstantFoldTerminator(BasicBlock /*P*/ BB) {
  //  return ConstantFoldTerminator(BB, false, 
  //                      (/*const*/ TargetLibraryInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean ConstantFoldTerminator(BasicBlock /*P*/ BB, boolean DeleteDeadConditions/*= false*/) {
  //  return ConstantFoldTerminator(BB, DeleteDeadConditions, 
  //                      (/*const*/ TargetLibraryInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean ConstantFoldTerminator(BasicBlock /*P*/ BB, boolean DeleteDeadConditions/*= false*/, 
                      /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    ConstantFoldTerminator(BB, DeleteDeadConditions, 
  //                      TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Local dead code elimination.
//

/// Return true if the result produced by the instruction is not used, and the
/// instruction has no side effects.

//===----------------------------------------------------------------------===//
//  Local dead code elimination.
//

/// isInstructionTriviallyDead - Return true if the result produced by the
/// instruction is not used, and the instruction has no side effects.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isInstructionTriviallyDead">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 288,
 FQN="llvm::isInstructionTriviallyDead", NM="_ZN4llvm26isInstructionTriviallyDeadEPNS_11InstructionEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm26isInstructionTriviallyDeadEPNS_11InstructionEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean isInstructionTriviallyDead(Instruction /*P*/ I) {
  //  return isInstructionTriviallyDead(I, 
  //                          (/*const*/ TargetLibraryInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean isInstructionTriviallyDead(Instruction /*P*/ I, 
                          /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    isInstructionTriviallyDead(I, 
  //                          TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// If the specified value is a trivially dead instruction, delete it.
/// If that makes any of its operands trivially dead, delete them too,
/// recursively. Return true if any instructions were deleted.

/// RecursivelyDeleteTriviallyDeadInstructions - If the specified value is a
/// trivially dead instruction, delete it.  If that makes any of its operands
/// trivially dead, delete them too, recursively.  Return true if any
/// instructions were deleted.
//<editor-fold defaultstate="collapsed" desc="llvm::RecursivelyDeleteTriviallyDeadInstructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 350,
 FQN="llvm::RecursivelyDeleteTriviallyDeadInstructions", NM="_ZN4llvm42RecursivelyDeleteTriviallyDeadInstructionsEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm42RecursivelyDeleteTriviallyDeadInstructionsEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean RecursivelyDeleteTriviallyDeadInstructions(Value /*P*/ V) {
  //  return RecursivelyDeleteTriviallyDeadInstructions(V, 
  //                                          (/*const*/ TargetLibraryInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean RecursivelyDeleteTriviallyDeadInstructions(Value /*P*/ V, 
                                          /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    RecursivelyDeleteTriviallyDeadInstructions(V, 
  //                                          TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// If the specified value is an effectively dead PHI node, due to being a
/// def-use chain of single-use nodes that either forms a cycle or is terminated
/// by a trivially dead instruction, delete it. If that makes any of its
/// operands trivially dead, delete them too, recursively. Return true if a
/// change was made.

/// RecursivelyDeleteDeadPHINode - If the specified value is an effectively
/// dead PHI node, due to being a def-use chain of single-use nodes that
/// either forms a cycle or is terminated by a trivially dead instruction,
/// delete it.  If that makes any of its operands trivially dead, delete them
/// too, recursively.  Return true if a change was made.
//<editor-fold defaultstate="collapsed" desc="llvm::RecursivelyDeleteDeadPHINode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 408,
 FQN="llvm::RecursivelyDeleteDeadPHINode", NM="_ZN4llvm28RecursivelyDeleteDeadPHINodeEPNS_7PHINodeEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm28RecursivelyDeleteDeadPHINodeEPNS_7PHINodeEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean RecursivelyDeleteDeadPHINode(PHINode /*P*/ PN) {
  //  return RecursivelyDeleteDeadPHINode(PN, 
  //                            (/*const*/ TargetLibraryInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean RecursivelyDeleteDeadPHINode(PHINode /*P*/ PN, 
                            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    RecursivelyDeleteDeadPHINode(PN, 
  //                            TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Scan the specified basic block and try to simplify any instructions in it
/// and recursively delete dead instructions.
///
/// This returns true if it changed the code, note that it can delete
/// instructions in other blocks as well in this block.

/// SimplifyInstructionsInBlock - Scan the specified basic block and try to
/// simplify any instructions in it and recursively delete dead instructions.
///
/// This returns true if it changed the code, note that it can delete
/// instructions in other blocks as well in this block.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyInstructionsInBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 485,
 FQN="llvm::SimplifyInstructionsInBlock", NM="_ZN4llvm27SimplifyInstructionsInBlockEPNS_10BasicBlockEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm27SimplifyInstructionsInBlockEPNS_10BasicBlockEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static boolean SimplifyInstructionsInBlock(BasicBlock /*P*/ BB) {
  //  return SimplifyInstructionsInBlock(BB, 
  //                           (/*const*/ TargetLibraryInfo /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean SimplifyInstructionsInBlock(BasicBlock /*P*/ BB, 
                           /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    SimplifyInstructionsInBlock(BB, 
  //                           TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Control Flow Graph Restructuring.
//

/// Like BasicBlock::removePredecessor, this method is called when we're about
/// to delete Pred as a predecessor of BB. If BB contains any PHI nodes, this
/// drops the entries in the PHI nodes for Pred.
///
/// Unlike the removePredecessor method, this attempts to simplify uses of PHI
/// nodes that collapse into identity values.  For example, if we have:
///   x = phi(1, 0, 0, 0)
///   y = and x, z
///
/// .. and delete the predecessor corresponding to the '1', this will attempt to
/// recursively fold the 'and' to 0.

//===----------------------------------------------------------------------===//
//  Control Flow Graph Restructuring.
//

/// RemovePredecessorAndSimplify - Like BasicBlock::removePredecessor, this
/// method is called when we're about to delete Pred as a predecessor of BB.  If
/// BB contains any PHI nodes, this drops the entries in the PHI nodes for Pred.
///
/// Unlike the removePredecessor method, this attempts to simplify uses of PHI
/// nodes that collapse into identity values.  For example, if we have:
///   x = phi(1, 0, 0, 0)
///   y = and x, z
///
/// .. and delete the predecessor corresponding to the '1', this will attempt to
/// recursively fold the and to 0.
//<editor-fold defaultstate="collapsed" desc="llvm::RemovePredecessorAndSimplify">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 537,
 FQN="llvm::RemovePredecessorAndSimplify", NM="_ZN4llvm28RemovePredecessorAndSimplifyEPNS_10BasicBlockES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm28RemovePredecessorAndSimplifyEPNS_10BasicBlockES1_")
//</editor-fold>
public static void RemovePredecessorAndSimplify(BasicBlock /*P*/ BB, BasicBlock /*P*/ Pred) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    RemovePredecessorAndSimplify(BB, Pred);
  throw new UnsupportedOperationException("EmptyBody");
}


/// BB is a block with one predecessor and its predecessor is known to have one
/// successor (BB!). Eliminate the edge between them, moving the instructions in
/// the predecessor into BB. This deletes the predecessor block.

/// MergeBasicBlockIntoOnlyPred - DestBB is a block with one predecessor and its
/// predecessor is known to have one successor (DestBB!).  Eliminate the edge
/// between them, moving the instructions in the predecessor into DestBB and
/// deleting the predecessor block.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MergeBasicBlockIntoOnlyPred">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 568,
 FQN="llvm::MergeBasicBlockIntoOnlyPred", NM="_ZN4llvm27MergeBasicBlockIntoOnlyPredEPNS_10BasicBlockEPNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm27MergeBasicBlockIntoOnlyPredEPNS_10BasicBlockEPNS_13DominatorTreeE")
//</editor-fold>
public static void MergeBasicBlockIntoOnlyPred(BasicBlock /*P*/ DestBB) {
  //  MergeBasicBlockIntoOnlyPred(DestBB, (DominatorTree /*P*/ )null);
  //}
  //public static void MergeBasicBlockIntoOnlyPred(BasicBlock /*P*/ DestBB, DominatorTree /*P*/ DT/*= null*/) {
  // //  /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  // //    MergeBasicBlockIntoOnlyPred(DestBB, DT);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


/// BB is known to contain an unconditional branch, and contains no instructions
/// other than PHI nodes, potential debug intrinsics and the branch. If
/// possible, eliminate BB by rewriting all the predecessors to branch to the
/// successor block and return true. If we can't transform, return false.

/// TryToSimplifyUncondBranchFromEmptyBlock - BB is known to contain an
/// unconditional branch, and contains no instructions other than PHI nodes,
/// potential side-effect free intrinsics and the branch.  If possible,
/// eliminate BB by rewriting all the predecessors to branch to the successor
/// block and return true.  If we can't transform, return false.
//<editor-fold defaultstate="collapsed" desc="llvm::TryToSimplifyUncondBranchFromEmptyBlock">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 818,
 FQN="llvm::TryToSimplifyUncondBranchFromEmptyBlock", NM="_ZN4llvm39TryToSimplifyUncondBranchFromEmptyBlockEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm39TryToSimplifyUncondBranchFromEmptyBlockEPNS_10BasicBlockE")
//</editor-fold>
public static boolean TryToSimplifyUncondBranchFromEmptyBlock(BasicBlock /*P*/ BB) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    TryToSimplifyUncondBranchFromEmptyBlock(BB);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Check for and eliminate duplicate PHI nodes in this block. This doesn't try
/// to be clever about PHI nodes which differ only in the order of the incoming
/// values, but instcombine orders them so it usually won't matter.

/// EliminateDuplicatePHINodes - Check for and eliminate duplicate PHI
/// nodes in this block. This doesn't try to be clever about PHI nodes
/// which differ only in the order of the incoming values, but instcombine
/// orders them so it usually won't matter.
///
//<editor-fold defaultstate="collapsed" desc="llvm::EliminateDuplicatePHINodes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 901,
 FQN="llvm::EliminateDuplicatePHINodes", NM="_ZN4llvm26EliminateDuplicatePHINodesEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm26EliminateDuplicatePHINodesEPNS_10BasicBlockE")
//</editor-fold>
public static boolean EliminateDuplicatePHINodes(BasicBlock /*P*/ BB) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    EliminateDuplicatePHINodes(BB);
  throw new UnsupportedOperationException("EmptyBody");
}


/// If the specified pointer has an alignment that we can determine, return it,
/// otherwise return 0. If PrefAlign is specified, and it is more than the
/// alignment of the ultimate object, see if we can increase the alignment of
/// the ultimate object, making this check succeed.

/// getOrEnforceKnownAlignment - If the specified pointer has an alignment that
/// we can determine, return it, otherwise return 0.  If PrefAlign is specified,
/// and it is more than the alignment of the ultimate object, see if we can
/// increase the alignment of the ultimate object, making this check succeed.
//<editor-fold defaultstate="collapsed" desc="llvm::getOrEnforceKnownAlignment">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1008,
 FQN="llvm::getOrEnforceKnownAlignment", NM="_ZN4llvm26getOrEnforceKnownAlignmentEPNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPNS_15AssumptionCacheEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm26getOrEnforceKnownAlignmentEPNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPNS_15AssumptionCacheEPKNS_13DominatorTreeE")
//</editor-fold>
public static /*uint*/int getOrEnforceKnownAlignment(Value /*P*/ V, /*uint*/int PrefAlign, 
                          final /*const*/ DataLayout /*&*/ DL) {
  //  return getOrEnforceKnownAlignment(V, PrefAlign, 
  //                          DL, 
  //                          (/*const*/ Instruction /*P*/ )null, 
 //                          (AssumptionCache /*P*/ )null, 
 //                          (/*const*/ DominatorTree /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*uint*/int getOrEnforceKnownAlignment(Value /*P*/ V, /*uint*/int PrefAlign, 
                          final /*const*/ DataLayout /*&*/ DL, 
                          /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  //  return getOrEnforceKnownAlignment(V, PrefAlign, 
  //                          DL, 
  //                          CxtI, 
 //                          (AssumptionCache /*P*/ )null, 
 //                          (/*const*/ DominatorTree /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*uint*/int getOrEnforceKnownAlignment(Value /*P*/ V, /*uint*/int PrefAlign, 
                          final /*const*/ DataLayout /*&*/ DL, 
                          /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                          AssumptionCache /*P*/ AC/*= null*/) {
  //  return getOrEnforceKnownAlignment(V, PrefAlign, 
  //                          DL, 
  //                          CxtI, 
  //                          AC, 
  //                          (/*const*/ DominatorTree /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static /*uint*/int getOrEnforceKnownAlignment(Value /*P*/ V, /*uint*/int PrefAlign, 
                          final /*const*/ DataLayout /*&*/ DL, 
                          /*const*/ Instruction /*P*/ CxtI/*= null*/, 
                          AssumptionCache /*P*/ AC/*= null*/, 
                          /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  //return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //  getOrEnforceKnownAlignment(V, PrefAlign, 
  //                        DL, 
  //                        CxtI, 
  //                        AC, 
  //                        DT);
  throw new UnsupportedOperationException("EmptyBody");
}


///===---------------------------------------------------------------------===//
///  Dbg Intrinsic utilities
///

/// Inserts a llvm.dbg.value intrinsic before a store to an alloca'd value
/// that has an associated llvm.dbg.decl intrinsic.

/// Inserts a llvm.dbg.value intrinsic before a store to an alloca'd value
/// that has an associated llvm.dbg.decl intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::ConvertDebugDeclareToDebugValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1062,
 FQN="llvm::ConvertDebugDeclareToDebugValue", NM="_ZN4llvm31ConvertDebugDeclareToDebugValueEPNS_14DbgDeclareInstEPNS_9StoreInstERNS_9DIBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm31ConvertDebugDeclareToDebugValueEPNS_14DbgDeclareInstEPNS_9StoreInstERNS_9DIBuilderE")
//</editor-fold>
public static boolean ConvertDebugDeclareToDebugValue(DbgDeclareInst /*P*/ DDI, 
                               StoreInst /*P*/ SI, final DIBuilder /*&*/ Builder) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    ConvertDebugDeclareToDebugValue(DDI, 
  //                               SI, Builder);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Inserts a llvm.dbg.value intrinsic before a load of an alloca'd value
/// that has an associated llvm.dbg.decl intrinsic.

/// Inserts a llvm.dbg.value intrinsic before a load of an alloca'd value
/// that has an associated llvm.dbg.decl intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::ConvertDebugDeclareToDebugValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1108,
 FQN="llvm::ConvertDebugDeclareToDebugValue", NM="_ZN4llvm31ConvertDebugDeclareToDebugValueEPNS_14DbgDeclareInstEPNS_8LoadInstERNS_9DIBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm31ConvertDebugDeclareToDebugValueEPNS_14DbgDeclareInstEPNS_8LoadInstERNS_9DIBuilderE")
//</editor-fold>
public static boolean ConvertDebugDeclareToDebugValue(DbgDeclareInst /*P*/ DDI, 
                               LoadInst /*P*/ LI, final DIBuilder /*&*/ Builder) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    ConvertDebugDeclareToDebugValue(DDI, 
  //                               LI, Builder);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Lowers llvm.dbg.declare intrinsics into appropriate set of
/// llvm.dbg.value intrinsics.

/// LowerDbgDeclare - Lowers llvm.dbg.declare intrinsics into appropriate set
/// of llvm.dbg.value intrinsics.
//<editor-fold defaultstate="collapsed" desc="llvm::LowerDbgDeclare">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1135,
 FQN="llvm::LowerDbgDeclare", NM="_ZN4llvm15LowerDbgDeclareERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm15LowerDbgDeclareERNS_8FunctionE")
//</editor-fold>
public static boolean LowerDbgDeclare(final Function /*&*/ F) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    LowerDbgDeclare(F);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Finds the llvm.dbg.declare intrinsic corresponding to an alloca, if any.

/// FindAllocaDbgDeclare - Finds the llvm.dbg.declare intrinsic describing the
/// alloca 'V', if any.
//<editor-fold defaultstate="collapsed" desc="llvm::FindAllocaDbgDeclare">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1184,
 FQN="llvm::FindAllocaDbgDeclare", NM="_ZN4llvm20FindAllocaDbgDeclareEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm20FindAllocaDbgDeclareEPNS_5ValueE")
//</editor-fold>
public static DbgDeclareInst /*P*/ FindAllocaDbgDeclare(Value /*P*/ V) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    FindAllocaDbgDeclare(V);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replaces llvm.dbg.declare instruction when the address it describes
/// is replaced with a new value. If Deref is true, an additional DW_OP_deref is
/// prepended to the expression. If Offset is non-zero, a constant displacement
/// is added to the expression (after the optional Deref). Offset can be
/// negative.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceDbgDeclare">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1226,
 FQN="llvm::replaceDbgDeclare", NM="_ZN4llvm17replaceDbgDeclareEPNS_5ValueES1_PNS_11InstructionERNS_9DIBuilderEbi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm17replaceDbgDeclareEPNS_5ValueES1_PNS_11InstructionERNS_9DIBuilderEbi")
//</editor-fold>
public static boolean replaceDbgDeclare(Value /*P*/ Address, Value /*P*/ NewAddress, 
                 Instruction /*P*/ InsertBefore, final DIBuilder /*&*/ Builder, 
                 boolean Deref, int Offset) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    replaceDbgDeclare(Address, NewAddress, 
  //                 InsertBefore, Builder, 
 //                 Deref, Offset);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replaces llvm.dbg.declare instruction when the alloca it describes
/// is replaced with a new value. If Deref is true, an additional DW_OP_deref is
/// prepended to the expression. If Offset is non-zero, a constant displacement
/// is added to the expression (after the optional Deref). Offset can be
/// negative. New llvm.dbg.declare is inserted immediately before AI.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceDbgDeclareForAlloca">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1246,
 FQN="llvm::replaceDbgDeclareForAlloca", NM="_ZN4llvm26replaceDbgDeclareForAllocaEPNS_10AllocaInstEPNS_5ValueERNS_9DIBuilderEbi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm26replaceDbgDeclareForAllocaEPNS_10AllocaInstEPNS_5ValueERNS_9DIBuilderEbi")
//</editor-fold>
public static boolean replaceDbgDeclareForAlloca(AllocaInst /*P*/ AI, Value /*P*/ NewAllocaAddress, 
                          final DIBuilder /*&*/ Builder, boolean Deref) {
  //  return replaceDbgDeclareForAlloca(AI, NewAllocaAddress, 
  //                          Builder, Deref, 0);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean replaceDbgDeclareForAlloca(AllocaInst /*P*/ AI, Value /*P*/ NewAllocaAddress, 
                          final DIBuilder /*&*/ Builder, boolean Deref, int Offset/*= 0*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    replaceDbgDeclareForAlloca(AI, NewAllocaAddress, 
  //                          Builder, Deref, Offset);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replaces multiple llvm.dbg.value instructions when the alloca it describes
/// is replaced with a new value. If Offset is non-zero, a constant displacement
/// is added to the expression (after the mandatory Deref). Offset can be
/// negative. New llvm.dbg.value instructions are inserted at the locations of
/// the instructions they replace.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceDbgValueForAlloca">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1281,
 FQN="llvm::replaceDbgValueForAlloca", NM="_ZN4llvm24replaceDbgValueForAllocaEPNS_10AllocaInstEPNS_5ValueERNS_9DIBuilderEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm24replaceDbgValueForAllocaEPNS_10AllocaInstEPNS_5ValueERNS_9DIBuilderEi")
//</editor-fold>
public static void replaceDbgValueForAlloca(AllocaInst /*P*/ AI, Value /*P*/ NewAllocaAddress, 
                        final DIBuilder /*&*/ Builder) {
  //  replaceDbgValueForAlloca(AI, NewAllocaAddress, 
  //                        Builder, 0);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void replaceDbgValueForAlloca(AllocaInst /*P*/ AI, Value /*P*/ NewAllocaAddress, 
                        final DIBuilder /*&*/ Builder, int Offset/*= 0*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    replaceDbgValueForAlloca(AI, NewAllocaAddress, 
  //                        Builder, Offset);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Remove all instructions from a basic block other than it's terminator
/// and any present EH pad instructions.
//<editor-fold defaultstate="collapsed" desc="llvm::removeAllNonTerminatorAndEHPadInstructions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1292,
 FQN="llvm::removeAllNonTerminatorAndEHPadInstructions", NM="_ZN4llvm42removeAllNonTerminatorAndEHPadInstructionsEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm42removeAllNonTerminatorAndEHPadInstructionsEPNS_10BasicBlockE")
//</editor-fold>
public static /*uint*/int removeAllNonTerminatorAndEHPadInstructions(BasicBlock /*P*/ BB) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    removeAllNonTerminatorAndEHPadInstructions(BB);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Insert an unreachable instruction before the specified
/// instruction, making it and the rest of the code in the block dead.
//<editor-fold defaultstate="collapsed" desc="llvm::changeToUnreachable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1313,
 FQN="llvm::changeToUnreachable", NM="_ZN4llvm19changeToUnreachableEPNS_11InstructionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm19changeToUnreachableEPNS_11InstructionEb")
//</editor-fold>
public static /*uint*/int changeToUnreachable(Instruction /*P*/ I, boolean UseLLVMTrap) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    changeToUnreachable(I, UseLLVMTrap);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replace 'BB's terminator with one that does not have an unwind successor
/// block. Rewrites `invoke` to `call`, etc. Updates any PHIs in unwind
/// successor.
///
/// \param BB  Block whose terminator will be replaced.  Its terminator must
///            have an unwind successor.
//<editor-fold defaultstate="collapsed" desc="llvm::removeUnwindEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1513,
 FQN="llvm::removeUnwindEdge", NM="_ZN4llvm16removeUnwindEdgeEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm16removeUnwindEdgeEPNS_10BasicBlockE")
//</editor-fold>
public static void removeUnwindEdge(BasicBlock /*P*/ BB) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    removeUnwindEdge(BB);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Remove all blocks that can not be reached from the function's entry.
///
/// Returns true if any basic block was removed.

/// removeUnreachableBlocksFromFn - Remove blocks that are not reachable, even
/// if they are in a dead cycle.  Return true if a change was made, false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::removeUnreachableBlocks">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1550,
 FQN="llvm::removeUnreachableBlocks", NM="_ZN4llvm23removeUnreachableBlocksERNS_8FunctionEPNS_13LazyValueInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm23removeUnreachableBlocksERNS_8FunctionEPNS_13LazyValueInfoE")
//</editor-fold>
public static boolean removeUnreachableBlocks(final Function /*&*/ F) {
  //  return removeUnreachableBlocks(F, (LazyValueInfo /*P*/ )null);
  //}
  //public static boolean removeUnreachableBlocks(final Function /*&*/ F, LazyValueInfo /*P*/ LVI/*= null*/) {
  // //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  // //    removeUnreachableBlocks(F, LVI);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


/// Combine the metadata of two instructions so that K can replace J
///
/// Metadata not listed as known via KnownIDs is removed
//<editor-fold defaultstate="collapsed" desc="llvm::combineMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1584,
 FQN="llvm::combineMetadata", NM="_ZN4llvm15combineMetadataEPNS_11InstructionEPKS0_NS_8ArrayRefIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm15combineMetadataEPNS_11InstructionEPKS0_NS_8ArrayRefIjEE")
//</editor-fold>
public static void combineMetadata(Instruction /*P*/ K, /*const*/ Instruction /*P*/ J, 
               ArrayRefUInt KnownIDs) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    combineMetadata(K, J, 
  //               KnownIDs);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Replace each use of 'From' with 'To' if that use is dominated by
/// the given edge.  Returns the number of replacements made.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceDominatedUsesWith">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1649,
 FQN="llvm::replaceDominatedUsesWith", NM="_ZN4llvm24replaceDominatedUsesWithEPNS_5ValueES1_RNS_13DominatorTreeERKNS_14BasicBlockEdgeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm24replaceDominatedUsesWithEPNS_5ValueES1_RNS_13DominatorTreeERKNS_14BasicBlockEdgeE")
//</editor-fold>
public static /*uint*/int replaceDominatedUsesWith(Value /*P*/ From, Value /*P*/ To, 
                        final DominatorTree /*&*/ DT, 
                        final /*const*/ BasicBlockEdge /*&*/ Root) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    replaceDominatedUsesWith(From, To, 
  //                        DT, 
 //                        Root);
  throw new UnsupportedOperationException("EmptyBody");
}

/// Replace each use of 'From' with 'To' if that use is dominated by
/// the end of the given BasicBlock. Returns the number of replacements made.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceDominatedUsesWith">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1669,
 FQN="llvm::replaceDominatedUsesWith", NM="_ZN4llvm24replaceDominatedUsesWithEPNS_5ValueES1_RNS_13DominatorTreeEPKNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm24replaceDominatedUsesWithEPNS_5ValueES1_RNS_13DominatorTreeEPKNS_10BasicBlockE")
//</editor-fold>
public static /*uint*/int replaceDominatedUsesWith(Value /*P*/ From, Value /*P*/ To, 
                        final DominatorTree /*&*/ DT, 
                        /*const*/ BasicBlock /*P*/ BB) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    replaceDominatedUsesWith(From, To, 
  //                        DT, 
 //                        BB);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Return true if the CallSite CS calls a gc leaf function.
///
/// A leaf function is a function that does not safepoint the thread during its
/// execution.  During a call or invoke to such a function, the callers stack
/// does not have to be made parseable.
///
/// Most passes can and should ignore this information, and it is only used
/// during lowering by the GC infrastructure.
//<editor-fold defaultstate="collapsed" desc="llvm::callsGCLeafFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1689,
 FQN="llvm::callsGCLeafFunction", NM="_ZN4llvm19callsGCLeafFunctionENS_17ImmutableCallSiteE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm19callsGCLeafFunctionENS_17ImmutableCallSiteE")
//</editor-fold>
public static boolean callsGCLeafFunction(ImmutableCallSite CS) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    callsGCLeafFunction(CS);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Intrinsic pattern matching
//

/// Try and match a bswap or bitreverse idiom.
///
/// If an idiom is matched, an intrinsic call is inserted before \c I. Any added
/// instructions are returned in \c InsertedInsts. They will all have been added
/// to a basic block.
///
/// A bitreverse idiom normally requires around 2*BW nodes to be searched (where
/// BW is the bitwidth of the integer type). A bswap idiom requires anywhere up
/// to BW / 4 nodes to be searched, so is significantly faster.
///
/// This function returns true on a successful match or false otherwise.

/// Given an OR instruction, check to see if this is a bitreverse
/// idiom. If so, insert the new intrinsic and return true.
//<editor-fold defaultstate="collapsed" desc="llvm::recognizeBSwapOrBitReverseIdiom">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1883,
 FQN="llvm::recognizeBSwapOrBitReverseIdiom", NM="_ZN4llvm31recognizeBSwapOrBitReverseIdiomEPNS_11InstructionEbbRNS_15SmallVectorImplIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm31recognizeBSwapOrBitReverseIdiomEPNS_11InstructionEbbRNS_15SmallVectorImplIS1_EE")
//</editor-fold>
public static boolean recognizeBSwapOrBitReverseIdiom(Instruction /*P*/ I, boolean MatchBSwaps, boolean MatchBitReversals, 
                               final SmallVectorImpl<Instruction /*P*/ > /*&*/ InsertedInsts) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    recognizeBSwapOrBitReverseIdiom(I, MatchBSwaps, MatchBitReversals, 
  //                               InsertedInsts);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//  Sanitizer utilities
//

/// Given a CallInst, check if it calls a string function known to CodeGen,
/// and mark it with NoBuiltin if so.  To be used by sanitizers that intend
/// to intercept string functions and want to avoid converting them to target
/// specific instructions.

// CodeGen has special handling for some string functions that may replace
// them with target-specific intrinsics.  Since that'd skip our interceptors
// in ASan/MSan/TSan/DFSan, and thus make us miss some memory accesses,
// we mark affected calls as NoBuiltin, which will disable optimization
// in CodeGen.
//<editor-fold defaultstate="collapsed" desc="llvm::maybeMarkSanitizerLibraryCallNoBuiltin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp", line = 1957,
 FQN="llvm::maybeMarkSanitizerLibraryCallNoBuiltin", NM="_ZN4llvm38maybeMarkSanitizerLibraryCallNoBuiltinEPNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Local.cpp -nm=_ZN4llvm38maybeMarkSanitizerLibraryCallNoBuiltinEPNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static void maybeMarkSanitizerLibraryCallNoBuiltin(CallInst /*P*/ CI, 
                                      /*const*/ TargetLibraryInfo /*P*/ TLI) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LocalLlvmGlobals.
  //    maybeMarkSanitizerLibraryCallNoBuiltin(CI, 
  //                                      TLI);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopDataPrefetch - Perform data prefetching in loops.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopDataPrefetchPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp", line = 132,
 FQN="llvm::createLoopDataPrefetchPass", NM="_ZN4llvm26createLoopDataPrefetchPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp -nm=_ZN4llvm26createLoopDataPrefetchPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLoopDataPrefetchPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopDataPrefetchLlvmGlobals.
  //    createLoopDataPrefetchPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopDeletion - This pass performs DCE of non-infinite loops that it
// can prove are dead.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopDeletionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp", line = 257,
 FQN="llvm::createLoopDeletionPass", NM="_ZN4llvm22createLoopDeletionPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm22createLoopDeletionPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopDeletionPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopDeletionLlvmGlobals.
  //    createLoopDeletionPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createLoopDistributePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp", line = 987,
 FQN="llvm::createLoopDistributePass", NM="_ZN4llvm24createLoopDistributePassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp -nm=_ZN4llvm24createLoopDistributePassEb")
//</editor-fold>
public static FunctionPass /*P*/ createLoopDistributePass(boolean ProcessAllLoopsByDefault) {
  //  return /*delegate*/org.llvm.transforms.impl.LoopDistributeLlvmGlobals.
  //    createLoopDistributePass(ProcessAllLoopsByDefault);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
/// createLoopExtractorPass - This pass extracts all natural loops from the
/// program into a function if it can.
///

// createLoopExtractorPass - This pass extracts all natural loops from the
// program into a function if it can.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopExtractorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 81,
 FQN="llvm::createLoopExtractorPass", NM="_ZN4llvm23createLoopExtractorPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm23createLoopExtractorPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopExtractorPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopExtractorLlvmGlobals.
  //    createLoopExtractorPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// createSingleLoopExtractorPass - This pass extracts one natural loop from the
/// program into a function if it can.  This is used by bugpoint.
///

// createSingleLoopExtractorPass - This pass extracts one natural loop from the
// program into a function if it can.  This is used by bugpoint.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createSingleLoopExtractorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 157,
 FQN="llvm::createSingleLoopExtractorPass", NM="_ZN4llvm29createSingleLoopExtractorPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm29createSingleLoopExtractorPassEv")
//</editor-fold>
public static Pass /*P*/ createSingleLoopExtractorPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopExtractorLlvmGlobals.
  //    createSingleLoopExtractorPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// createBlockExtractorPass - This pass extracts all blocks (except those
/// specified in the argument list) from the functions in the module.
///

// createBlockExtractorPass - This pass extracts all blocks (except those
// specified in the argument list) from the functions in the module.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createBlockExtractorPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 198,
 FQN="llvm::createBlockExtractorPass", NM="_ZN4llvm24createBlockExtractorPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm24createBlockExtractorPassEv")
//</editor-fold>
public static ModulePass /*P*/ createBlockExtractorPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopExtractorLlvmGlobals.
  //    createBlockExtractorPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopIdiom - This pass recognizes and replaces idioms in loops.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopIdiomPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp", line = 207,
 FQN="llvm::createLoopIdiomPass", NM="_ZN4llvm19createLoopIdiomPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp -nm=_ZN4llvm19createLoopIdiomPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopIdiomPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopIdiomRecognizeLlvmGlobals.
  //    createLoopIdiomPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopInstSimplify - This pass simplifies instructions in a loop's body.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopInstSimplifyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp", line = 214,
 FQN="llvm::createLoopInstSimplifyPass", NM="_ZN4llvm26createLoopInstSimplifyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp -nm=_ZN4llvm26createLoopInstSimplifyPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopInstSimplifyPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopInstSimplifyLlvmGlobals.
  //    createLoopInstSimplifyPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopInterchange - This pass interchanges loops to provide a more
// cache-friendly memory access patterns.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopInterchangePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp", line = 1280,
 FQN="llvm::createLoopInterchangePass", NM="_ZN4llvm25createLoopInterchangePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp -nm=_ZN4llvm25createLoopInterchangePassEv")
//</editor-fold>
public static Pass /*P*/ createLoopInterchangePass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopInterchangeLlvmGlobals.
  //    createLoopInterchangePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopLoadElimination - Perform loop-aware load elimination.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopLoadEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp", line = 602,
 FQN="llvm::createLoopLoadEliminationPass", NM="_ZN4llvm29createLoopLoadEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp -nm=_ZN4llvm29createLoopLoadEliminationPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLoopLoadEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopLoadEliminationLlvmGlobals.
  //    createLoopLoadEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopReroll - This pass is a simple loop rerolling pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopRerollPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp", line = 456,
 FQN="llvm::createLoopRerollPass", NM="_ZN4llvm20createLoopRerollPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp -nm=_ZN4llvm20createLoopRerollPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopRerollPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopRerollPassLlvmGlobals.
  //    createLoopRerollPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopRotate - This pass is a simple loop rotating pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopRotatePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp", line = 691,
 FQN="llvm::createLoopRotatePass", NM="_ZN4llvm20createLoopRotatePassEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp -nm=_ZN4llvm20createLoopRotatePassEi")
//</editor-fold>
public static Pass /*P*/ createLoopRotatePass() {
  return createLoopRotatePass(-1);
}
public static Pass /*P*/ createLoopRotatePass(int MaxHeaderSize/*= -1*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Simplify each loop in a loop nest recursively.
///
/// This takes a potentially un-simplified loop L (and its children) and turns
/// it into a simplified loop nest with preheaders and single backedges. It will
/// update \c AliasAnalysis and \c ScalarEvolution analyses if they're non-null.
//<editor-fold defaultstate="collapsed" desc="llvm::simplifyLoop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp", line = 736,
 FQN="llvm::simplifyLoop", NM="_ZN4llvm12simplifyLoopEPNS_4LoopEPNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_15AssumptionCacheEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp -nm=_ZN4llvm12simplifyLoopEPNS_4LoopEPNS_13DominatorTreeEPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_15AssumptionCacheEb")
//</editor-fold>
public static boolean simplifyLoop(Loop /*P*/ L, DominatorTree /*P*/ DT, LoopInfo /*P*/ LI, 
            ScalarEvolution /*P*/ SE, AssumptionCache /*P*/ AC, 
            boolean PreserveLCSSA) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LoopSimplifyLlvmGlobals.
  //    simplifyLoop(L, DT, LI, 
  //            SE, AC, 
 //            PreserveLCSSA);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopSimplify - Insert Pre-header blocks into the CFG for every function in
// the module.  This pass updates dominator information, loop information, and
// does not add critical edges to the CFG.
//
//   AU.addRequiredID(LoopSimplifyID);
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopSimplifyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp", line = 805,
 FQN="llvm::createLoopSimplifyPass", NM="_ZN4llvm22createLoopSimplifyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp -nm=_ZN4llvm22createLoopSimplifyPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopSimplifyPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopSimplifyLlvmGlobals.
  //    createLoopSimplifyPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// InsertPreheaderForLoop - Once we discover that a loop doesn't have a
/// preheader, this method is called to insert one.  This method has two phases:
/// preheader insertion and analysis updating.
///
//<editor-fold defaultstate="collapsed" desc="llvm::InsertPreheaderForLoop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp", line = 118,
 FQN="llvm::InsertPreheaderForLoop", NM="_ZN4llvm22InsertPreheaderForLoopEPNS_4LoopEPNS_13DominatorTreeEPNS_8LoopInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp -nm=_ZN4llvm22InsertPreheaderForLoopEPNS_4LoopEPNS_13DominatorTreeEPNS_8LoopInfoEb")
//</editor-fold>
public static BasicBlock /*P*/ InsertPreheaderForLoop(Loop /*P*/ L, DominatorTree /*P*/ DT, 
                      LoopInfo /*P*/ LI, boolean PreserveLCSSA) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LoopSimplifyLlvmGlobals.
  //    InsertPreheaderForLoop(L, DT, 
  //                      LI, PreserveLCSSA);
  throw new UnsupportedOperationException("EmptyBody");
}


// Publicly exposed interface to pass...
//<editor-fold defaultstate="collapsed" desc="llvm::LoopSimplifyID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp", line = 804,
 FQN="llvm::LoopSimplifyID", NM="_ZN4llvm14LoopSimplifyIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp -nm=_ZN4llvm14LoopSimplifyIDE")
//</editor-fold>
public static final char$ref/*char &*/ LoopSimplifyID = LoopSimplify.ID;

//===----------------------------------------------------------------------===//
//
// LoopSimplifyCFG - This pass performs basic CFG simplification on loops,
// primarily to help other loop passes.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopSimplifyCFGPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp", line = 112,
 FQN="llvm::createLoopSimplifyCFGPass", NM="_ZN4llvm25createLoopSimplifyCFGPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp -nm=_ZN4llvm25createLoopSimplifyCFGPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopSimplifyCFGPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopSimplifyCFGLlvmGlobals.
  //    createLoopSimplifyCFGPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopStrengthReduce - This pass is strength reduces GEP instructions that use
// a loop's canonical induction variable as one of their indices.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopStrengthReducePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp", line = 4960,
 FQN="llvm::createLoopStrengthReducePass", NM="_ZN4llvm28createLoopStrengthReducePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp -nm=_ZN4llvm28createLoopStrengthReducePassEv")
//</editor-fold>
public static Pass /*P*/ createLoopStrengthReducePass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopStrengthReduceLlvmGlobals.
  //    createLoopStrengthReducePass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Unroll the given loop by Count. The loop must be in LCSSA form. Returns true
/// if unrolling was successful, or false if the loop was unmodified. Unrolling
/// can only fail when the loop's latch block is not terminated by a conditional
/// branch instruction. However, if the trip count (and multiple) are not known,
/// loop unrolling will mostly produce more code that is no faster.
///
/// TripCount is generally defined as the number of times the loop header
/// executes. UnrollLoop relaxes the definition to permit early exits: here
/// TripCount is the iteration on which control exits LatchBlock if no early
/// exits were taken. Note that UnrollLoop assumes that the loop counter test
/// terminates LatchBlock in order to remove unnecesssary instances of the
/// test. In other words, control may exit the loop prior to TripCount
/// iterations via an early branch, but control may not exit the loop from the
/// LatchBlock's terminator prior to TripCount iterations.
///
/// Similarly, TripMultiple divides the number of times that the LatchBlock may
/// execute without exiting the loop.
///
/// If AllowRuntime is true then UnrollLoop will consider unrolling loops that
/// have a runtime (i.e. not compile time constant) trip count.  Unrolling these
/// loops require a unroll "prologue" that runs "RuntimeTripCount % Count"
/// iterations before branching into the unrolled loop.  UnrollLoop will not
/// runtime-unroll the loop if computing RuntimeTripCount will be expensive and
/// AllowExpensiveTripCount is false.
///
/// The LoopInfo Analysis that is passed will be kept consistent.
///
/// This utility preserves LoopInfo. It will also preserve ScalarEvolution and
/// DominatorTree if they are non-null.
//<editor-fold defaultstate="collapsed" desc="llvm::UnrollLoop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnroll.cpp", line = 203,
 FQN="llvm::UnrollLoop", NM="_ZN4llvm10UnrollLoopEPNS_4LoopEjjbbbjPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_15AssumptionCacheEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnroll.cpp -nm=_ZN4llvm10UnrollLoopEPNS_4LoopEjjbbbjPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_15AssumptionCacheEb")
//</editor-fold>
public static boolean UnrollLoop(Loop /*P*/ L, /*uint*/int Count, /*uint*/int TripCount, boolean Force, 
          boolean AllowRuntime, boolean AllowExpensiveTripCount, 
          /*uint*/int TripMultiple, LoopInfo /*P*/ LI, ScalarEvolution /*P*/ SE, 
          DominatorTree /*P*/ DT, AssumptionCache /*P*/ AC, 
          boolean PreserveLCSSA) {
  //return /*delegate*/org.llvm.transforms.utils.impl.LoopUnrollLlvmGlobals.
  //  UnrollLoop(L, Count, TripCount, Force, 
  //        AllowRuntime, AllowExpensiveTripCount, 
  //        TripMultiple, LI, SE, 
  //        DT, AC, 
  //        PreserveLCSSA);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Given an llvm.loop loop id metadata node, returns the loop hint metadata
/// node with the given name (for example, "llvm.loop.unroll.count"). If no
/// such metadata node exists, then nullptr is returned.
//<editor-fold defaultstate="collapsed" desc="llvm::GetUnrollMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnroll.cpp", line = 690,
 FQN="llvm::GetUnrollMetadata", NM="_ZN4llvm17GetUnrollMetadataEPNS_6MDNodeENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnroll.cpp -nm=_ZN4llvm17GetUnrollMetadataEPNS_6MDNodeENS_9StringRefE")
//</editor-fold>
public static MDNode /*P*/ GetUnrollMetadata(MDNode /*P*/ LoopID, StringRef Name) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LoopUnrollLlvmGlobals.
  //    GetUnrollMetadata(LoopID, Name);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopUnroll - This pass is a simple loop unrolling pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopUnrollPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp", line = 1042,
 FQN="llvm::createLoopUnrollPass", NM="_ZN4llvm20createLoopUnrollPassEiiii",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm20createLoopUnrollPassEiiii")
//</editor-fold>
public static Pass /*P*/ createLoopUnrollPass() {
  //  return createLoopUnrollPass(-1, -1, -1, 
  //                    -1);
  throw new UnsupportedOperationException("EmptyBody");
}
public static Pass /*P*/ createLoopUnrollPass(int Threshold/*= -1*/) {
  //  return createLoopUnrollPass(Threshold, -1, -1, 
  //                    -1);
  throw new UnsupportedOperationException("EmptyBody");
}
public static Pass /*P*/ createLoopUnrollPass(int Threshold/*= -1*/, int Count/*= -1*/) {
  //  return createLoopUnrollPass(Threshold, Count, -1, 
  //                    -1);
  throw new UnsupportedOperationException("EmptyBody");
}
public static Pass /*P*/ createLoopUnrollPass(int Threshold/*= -1*/, int Count/*= -1*/, int AllowPartial/*= -1*/) {
  //  return createLoopUnrollPass(Threshold, Count, AllowPartial, 
  //                    -1);
  throw new UnsupportedOperationException("EmptyBody");
}
public static Pass /*P*/ createLoopUnrollPass(int Threshold/*= -1*/, int Count/*= -1*/, int AllowPartial/*= -1*/, 
                    int Runtime/*= -1*/) {
  //  return /*delegate*/org.llvm.transforms.impl.LoopUnrollPassLlvmGlobals.
  //    createLoopUnrollPass(Threshold, Count, AllowPartial, 
  //                    Runtime);
  throw new UnsupportedOperationException("EmptyBody");
}

// Create an unrolling pass for full unrolling only.
//<editor-fold defaultstate="collapsed" desc="llvm::createSimpleLoopUnrollPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp", line = 1054,
 FQN="llvm::createSimpleLoopUnrollPass", NM="_ZN4llvm26createSimpleLoopUnrollPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm26createSimpleLoopUnrollPassEv")
//</editor-fold>
public static Pass /*P*/ createSimpleLoopUnrollPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopUnrollPassLlvmGlobals.
  //    createSimpleLoopUnrollPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Insert code in the prolog/epilog code when unrolling a loop with a
/// run-time trip-count.
///
/// This method assumes that the loop unroll factor is total number
/// of loop bodies in the loop after unrolling. (Some folks refer
/// to the unroll factor as the number of *extra* copies added).
/// We assume also that the loop unroll factor is a power-of-two. So, after
/// unrolling the loop, the number of loop bodies executed is 2,
/// 4, 8, etc.  Note - LLVM converts the if-then-sequence to a switch
/// instruction in SimplifyCFG.cpp.  Then, the backend decides how code for
/// the switch instruction is generated.
///
/// ***Prolog case***
///        extraiters = tripcount % loopfactor
///        if (extraiters == 0) jump Loop:
///        else jump Prol:
/// Prol:  LoopBody;
///        extraiters -= 1                 // Omitted if unroll factor is 2.
///        if (extraiters != 0) jump Prol: // Omitted if unroll factor is 2.
///        if (tripcount < loopfactor) jump End:
/// Loop:
/// ...
/// End:
///
/// ***Epilog case***
///        extraiters = tripcount % loopfactor
///        if (tripcount < loopfactor) jump LoopExit:
///        unroll_iters = tripcount - extraiters
/// Loop:  LoopBody; (executes unroll_iter times);
///        unroll_iter -= 1
///        if (unroll_iter != 0) jump Loop:
/// LoopExit:
///        if (extraiters == 0) jump EpilExit:
/// Epil:  LoopBody; (executes extraiters times)
///        extraiters -= 1                 // Omitted if unroll factor is 2.
///        if (extraiters != 0) jump Epil: // Omitted if unroll factor is 2.
/// EpilExit:
//<editor-fold defaultstate="collapsed" desc="llvm::UnrollRuntimeLoopRemainder">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnrollRuntime.cpp", line = 431,
 FQN="llvm::UnrollRuntimeLoopRemainder", NM="_ZN4llvm26UnrollRuntimeLoopRemainderEPNS_4LoopEjbbPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_13DominatorTreeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUnrollRuntime.cpp -nm=_ZN4llvm26UnrollRuntimeLoopRemainderEPNS_4LoopEjbbPNS_8LoopInfoEPNS_15ScalarEvolutionEPNS_13DominatorTreeEb")
//</editor-fold>
public static boolean UnrollRuntimeLoopRemainder(Loop /*P*/ L, /*uint*/int Count, 
                          boolean AllowExpensiveTripCount, 
                          boolean UseEpilogRemainder, 
                          LoopInfo /*P*/ LI, ScalarEvolution /*P*/ SE, 
                          DominatorTree /*P*/ DT, boolean PreserveLCSSA) {
  //return /*delegate*/org.llvm.transforms.utils.impl.LoopUnrollRuntimeLlvmGlobals.
  //  UnrollRuntimeLoopRemainder(L, Count, 
  //                        AllowExpensiveTripCount, 
  //                        UseEpilogRemainder, 
  //                        LI, SE, 
  //                        DT, PreserveLCSSA);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopUnswitch - This pass is a simple loop unswitching pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopUnswitchPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp", line = 387,
 FQN="llvm::createLoopUnswitchPass", NM="_ZN4llvm22createLoopUnswitchPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp -nm=_ZN4llvm22createLoopUnswitchPassEb")
//</editor-fold>
public static Pass /*P*/ createLoopUnswitchPass() {
  return createLoopUnswitchPass(false);
}
public static Pass /*P*/ createLoopUnswitchPass(boolean Os/*= false*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Returns true if the instruction in a loop is guaranteed to execute at least
/// once.

/// Returns true if the instruction in a loop is guaranteed to execute at least
/// once.
//<editor-fold defaultstate="collapsed" desc="llvm::isGuaranteedToExecute">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp", line = 931,
 FQN="llvm::isGuaranteedToExecute", NM="_ZN4llvm21isGuaranteedToExecuteERKNS_11InstructionEPKNS_13DominatorTreeEPKNS_4LoopEPKNS_14LoopSafetyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm21isGuaranteedToExecuteERKNS_11InstructionEPKNS_13DominatorTreeEPKNS_4LoopEPKNS_14LoopSafetyInfoE")
//</editor-fold>
public static boolean isGuaranteedToExecute(final /*const*/ Instruction /*&*/ Inst, 
                     /*const*/ DominatorTree /*P*/ DT, /*const*/ Loop /*P*/ CurLoop, 
                     /*const*/ LoopSafetyInfo /*P*/ SafetyInfo) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LoopUtilsLlvmGlobals.
  //    isGuaranteedToExecute(Inst, 
  //                     DT, CurLoop, 
 //                     SafetyInfo);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Returns the instructions that use values defined in the loop.

/// \brief Returns the instructions that use values defined in the loop.
//<editor-fold defaultstate="collapsed" desc="llvm::findDefsUsedOutsideOfLoop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp", line = 819,
 FQN="llvm::findDefsUsedOutsideOfLoop", NM="_ZN4llvm25findDefsUsedOutsideOfLoopEPNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm25findDefsUsedOutsideOfLoopEPNS_4LoopE")
//</editor-fold>
public static SmallVector<Instruction /*P*/ > findDefsUsedOutsideOfLoop(Loop /*P*/ L) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LoopUtilsLlvmGlobals.
  //    findDefsUsedOutsideOfLoop(L);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Find string metadata for loop
///
/// If it has a value (e.g. {"llvm.distribute", 1} return the value as an
/// operand or null otherwise.  If the string metadata is not found return
/// Optional's not-a-value.

/// \brief Find string metadata for loop
///
/// If it has a value (e.g. {"llvm.distribute", 1} return the value as an
/// operand or null otherwise.  If the string metadata is not found return
/// Optional's not-a-value.
//<editor-fold defaultstate="collapsed" desc="llvm::findStringMetadataForLoop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp", line = 896,
 FQN="llvm::findStringMetadataForLoop", NM="_ZN4llvm25findStringMetadataForLoopEPNS_4LoopENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm25findStringMetadataForLoopEPNS_4LoopENS_9StringRefE")
//</editor-fold>
public static OptionalPtr</*const*/ MDOperand /*P*/ > findStringMetadataForLoop(Loop /*P*/ TheLoop, 
                         StringRef Name) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.LoopUtilsLlvmGlobals.
  //    findStringMetadataForLoop(TheLoop, 
  //                         Name);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Helper to consistently add the set of standard passes to a loop pass's \c
/// AnalysisUsage.
///
/// All loop passes should call this as part of implementing their \c
/// getAnalysisUsage.
//<editor-fold defaultstate="collapsed" desc="llvm::getLoopAnalysisUsage">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp", line = 837,
 FQN="llvm::getLoopAnalysisUsage", NM="_ZN4llvm20getLoopAnalysisUsageERNS_13AnalysisUsageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopUtils.cpp -nm=_ZN4llvm20getLoopAnalysisUsageERNS_13AnalysisUsageE")
//</editor-fold>
public static void getLoopAnalysisUsage(final AnalysisUsage /*&*/ AU) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LoopUtilsLlvmGlobals.
  //    getLoopAnalysisUsage(AU);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopVectorize - Create a loop vectorization pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopVectorizePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp", line = 6223,
 FQN="llvm::createLoopVectorizePass", NM="_ZN4llvm23createLoopVectorizePassEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp -nm=_ZN4llvm23createLoopVectorizePassEbb")
//</editor-fold>
public static Pass /*P*/ createLoopVectorizePass() {
  return createLoopVectorizePass(false, true);
}
public static Pass /*P*/ createLoopVectorizePass(boolean NoUnrolling/*= false*/) {
  return createLoopVectorizePass(NoUnrolling, true);
}
public static Pass /*P*/ createLoopVectorizePass(boolean NoUnrolling/*= false*/, boolean AlwaysVectorize/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createLoopVersioningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp", line = 320,
 FQN="llvm::createLoopVersioningPass", NM="_ZN4llvm24createLoopVersioningPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp -nm=_ZN4llvm24createLoopVersioningPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLoopVersioningPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopVersioningLlvmGlobals.
  //    createLoopVersioningPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LoopVersioningLICM - This pass is a loop versioning pass for LICM.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLoopVersioningLICMPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp", line = 571,
 FQN="llvm::createLoopVersioningLICMPass", NM="_ZN4llvm28createLoopVersioningLICMPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp -nm=_ZN4llvm28createLoopVersioningLICMPassEv")
//</editor-fold>
public static Pass /*P*/ createLoopVersioningLICMPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LoopVersioningLICMLlvmGlobals.
  //    createLoopVersioningLICMPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Set input string into loop metadata by keeping other values intact.

/// \brief Set input string into loop metadata by keeping other values intact.
//<editor-fold defaultstate="collapsed" desc="llvm::addStringMetadataToLoop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp", line = 125,
 FQN="llvm::addStringMetadataToLoop", NM="_ZN4llvm23addStringMetadataToLoopEPNS_4LoopEPKcj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp -nm=_ZN4llvm23addStringMetadataToLoopEPNS_4LoopEPKcj")
//</editor-fold>
public static void addStringMetadataToLoop(Loop /*P*/ TheLoop, /*const*/char$ptr/*char P*/ MDString) {
  //  addStringMetadataToLoop(TheLoop, MDString, 
  //                       0);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void addStringMetadataToLoop(Loop /*P*/ TheLoop, /*const*/char$ptr/*char P*/ MDString, 
                       /*uint*/int V/*= 0*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.LoopVersioningLICMLlvmGlobals.
  //    addStringMetadataToLoop(TheLoop, MDString, 
  //                       V);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LowerAtomic - Lower atomic intrinsics to non-atomic form
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLowerAtomicPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp", line = 174,
 FQN="llvm::createLowerAtomicPass", NM="_ZN4llvm21createLowerAtomicPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp -nm=_ZN4llvm21createLowerAtomicPassEv")
//</editor-fold>
public static Pass /*P*/ createLowerAtomicPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LowerAtomicLlvmGlobals.
  //    createLowerAtomicPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LowerExpectIntrinsics - Removes llvm.expect intrinsics and creates
// "block_weights" metadata.
//<editor-fold defaultstate="collapsed" desc="llvm::createLowerExpectIntrinsicPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp", line = 203,
 FQN="llvm::createLowerExpectIntrinsicPass", NM="_ZN4llvm30createLowerExpectIntrinsicPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp -nm=_ZN4llvm30createLowerExpectIntrinsicPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLowerExpectIntrinsicPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LowerExpectIntrinsicLlvmGlobals.
  //    createLowerExpectIntrinsicPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LowerGuardIntrinsic - Lower guard intrinsics to normal control flow.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createLowerGuardIntrinsicPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp", line = 121,
 FQN="llvm::createLowerGuardIntrinsicPass", NM="_ZN4llvm29createLowerGuardIntrinsicPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp -nm=_ZN4llvm29createLowerGuardIntrinsicPassEv")
//</editor-fold>
public static Pass /*P*/ createLowerGuardIntrinsicPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LowerGuardIntrinsicLlvmGlobals.
  //    createLowerGuardIntrinsicPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// LowerInvoke - This pass removes invoke instructions, converting them to call
// instructions.
//

// Public Interface To the LowerInvoke pass.
//<editor-fold defaultstate="collapsed" desc="llvm::createLowerInvokePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp", line = 49,
 FQN="llvm::createLowerInvokePass", NM="_ZN4llvm21createLowerInvokePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp -nm=_ZN4llvm21createLowerInvokePassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLowerInvokePass() {
  //  return /*delegate*/org.llvm.transforms.impl.LowerInvokeLlvmGlobals.
  //    createLowerInvokePass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::LowerInvokePassID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp", line = 46,
 FQN="llvm::LowerInvokePassID", NM="_ZN4llvm17LowerInvokePassIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp -nm=_ZN4llvm17LowerInvokePassIDE")
//</editor-fold>
public static final char$ref/*char &*/ LowerInvokePassID = LowerInvoke.ID;

//===----------------------------------------------------------------------===//
//
// LowerSwitch - This pass converts SwitchInst instructions into a sequence of
// chained binary branch instructions.
//
// createLowerSwitchPass - Interface to this file...
//<editor-fold defaultstate="collapsed" desc="llvm::createLowerSwitchPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp", line = 106,
 FQN="llvm::createLowerSwitchPass", NM="_ZN4llvm21createLowerSwitchPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp -nm=_ZN4llvm21createLowerSwitchPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLowerSwitchPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LowerSwitchLlvmGlobals.
  //    createLowerSwitchPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// Publicly exposed interface to pass...
//<editor-fold defaultstate="collapsed" desc="llvm::LowerSwitchID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp", line = 104,
 FQN="llvm::LowerSwitchID", NM="_ZN4llvm13LowerSwitchIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp -nm=_ZN4llvm13LowerSwitchIDE")
//</editor-fold>
public static final char$ref/*char &*/ LowerSwitchID = LowerSwitch.ID;

/// \brief This pass lowers type metadata and the llvm.type.test intrinsic to
/// bitsets.
//<editor-fold defaultstate="collapsed" desc="llvm::createLowerTypeTestsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp", line = 265,
 FQN="llvm::createLowerTypeTestsPass", NM="_ZN4llvm24createLowerTypeTestsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp -nm=_ZN4llvm24createLowerTypeTestsPassEv")
//</editor-fold>
public static ModulePass /*P*/ createLowerTypeTestsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.LowerTypeTestsLlvmGlobals.
  //    createLowerTypeTestsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// PromoteMemoryToRegister - This pass is used to promote memory references to
// be register references. A simple example of the transformation performed by
// this pass is:
//
//        FROM CODE                           TO CODE
//   %X = alloca i32, i32 1                 ret i32 42
//   store i32 42, i32 *%X
//   %Y = load i32* %X
//   ret i32 %Y
//

// createPromoteMemoryToRegister - Provide an entry point to create this pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createPromoteMemoryToRegisterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp", line = 105,
 FQN="llvm::createPromoteMemoryToRegisterPass", NM="_ZN4llvm33createPromoteMemoryToRegisterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp -nm=_ZN4llvm33createPromoteMemoryToRegisterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPromoteMemoryToRegisterPass() {
  //  return /*delegate*/org.llvm.transforms.impl.Mem2RegLlvmGlobals.
  //    createPromoteMemoryToRegisterPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// MemCpyOpt - This pass performs optimizations related to eliminating memcpy
// calls and/or combining multiple stores into memset's.
//

/// The public interface to this file...
//<editor-fold defaultstate="collapsed" desc="llvm::createMemCpyOptPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp", line = 346,
 FQN="llvm::createMemCpyOptPass", NM="_ZN4llvm19createMemCpyOptPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp -nm=_ZN4llvm19createMemCpyOptPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createMemCpyOptPass() {
  //  return /*delegate*/org.llvm.transforms.impl.MemCpyOptimizerLlvmGlobals.
  //    createMemCpyOptPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// Insert MemorySanitizer instrumentation (detection of uninitialized reads)
//<editor-fold defaultstate="collapsed" desc="llvm::createMemorySanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp", line = 398,
 FQN="llvm::createMemorySanitizerPass", NM="_ZN4llvm25createMemorySanitizerPassEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp -nm=_ZN4llvm25createMemorySanitizerPassEi")
//</editor-fold>
public static FunctionPass /*P*/ createMemorySanitizerPass() {
  return createMemorySanitizerPass(0);
}
public static FunctionPass /*P*/ createMemorySanitizerPass(int TrackOrigins) {
  //  return createMemorySanitizerPass(0);
  //}
  //public static FunctionPass /*P*/ createMemorySanitizerPass(int TrackOrigins/*= 0*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.MemorySanitizerLlvmGlobals.
  // //    createMemorySanitizerPass(TrackOrigins);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createMergeFunctionsPass - This pass discovers identical functions and
/// collapses them.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createMergeFunctionsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp", line = 1462,
 FQN="llvm::createMergeFunctionsPass", NM="_ZN4llvm24createMergeFunctionsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp -nm=_ZN4llvm24createMergeFunctionsPassEv")
//</editor-fold>
public static ModulePass /*P*/ createMergeFunctionsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.MergeFunctionsLlvmGlobals.
  //    createMergeFunctionsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// MergedLoadStoreMotion - This pass merges loads and stores in diamonds. Loads
// are hoisted into the header, while stores sink into the footer.
//
// anonymous namespace

///
/// \brief createMergedLoadStoreMotionPass - The public interface to this file.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createMergedLoadStoreMotionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp", line = 581,
 FQN="llvm::createMergedLoadStoreMotionPass", NM="_ZN4llvm31createMergedLoadStoreMotionPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp -nm=_ZN4llvm31createMergedLoadStoreMotionPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createMergedLoadStoreMotionPass() {
  //  return /*delegate*/org.llvm.transforms.impl.MergedLoadStoreMotionLlvmGlobals.
  //    createMergedLoadStoreMotionPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
// createMetaRenamerPass - Rename everything with metasyntatic names.
//
//===----------------------------------------------------------------------===//
//
// MetaRenamer - Rename everything with metasyntactic names.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createMetaRenamerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp", line = 148,
 FQN="llvm::createMetaRenamerPass", NM="_ZN4llvm21createMetaRenamerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp -nm=_ZN4llvm21createMetaRenamerPassEv")
//</editor-fold>
public static ModulePass /*P*/ createMetaRenamerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.MetaRenamerLlvmGlobals.
  //    createMetaRenamerPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Append F to the list of global ctors of module M with the given Priority.
/// This wraps the function in the appropriate structure and stores it along
/// side other global constructors. For details see
/// http://llvm.org/docs/LangRef.html#intg_global_ctors
//<editor-fold defaultstate="collapsed" desc="llvm::appendToGlobalCtors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp", line = 84,
 FQN="llvm::appendToGlobalCtors", NM="_ZN4llvm19appendToGlobalCtorsERNS_6ModuleEPNS_8FunctionEiPNS_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp -nm=_ZN4llvm19appendToGlobalCtorsERNS_6ModuleEPNS_8FunctionEiPNS_8ConstantE")
//</editor-fold>
public static void appendToGlobalCtors(final Module /*&*/ M, Function /*P*/ F, int Priority) {
  //  appendToGlobalCtors(M, F, Priority, (Constant /*P*/ )null);
  //}
  //public static void appendToGlobalCtors(final Module /*&*/ M, Function /*P*/ F, int Priority, Constant /*P*/ Data/*= null*/) {
  // //  /*delegate*/org.llvm.transforms.utils.impl.ModuleUtilsLlvmGlobals.
  // //    appendToGlobalCtors(M, F, Priority, Data);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


/// Same as appendToGlobalCtors(), but for global dtors.
//<editor-fold defaultstate="collapsed" desc="llvm::appendToGlobalDtors">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp", line = 88,
 FQN="llvm::appendToGlobalDtors", NM="_ZN4llvm19appendToGlobalDtorsERNS_6ModuleEPNS_8FunctionEiPNS_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp -nm=_ZN4llvm19appendToGlobalDtorsERNS_6ModuleEPNS_8FunctionEiPNS_8ConstantE")
//</editor-fold>
public static void appendToGlobalDtors(final Module /*&*/ M, Function /*P*/ F, int Priority) {
  //  appendToGlobalDtors(M, F, Priority, (Constant /*P*/ )null);
  //}
  //public static void appendToGlobalDtors(final Module /*&*/ M, Function /*P*/ F, int Priority, Constant /*P*/ Data/*= null*/) {
  // //  /*delegate*/org.llvm.transforms.utils.impl.ModuleUtilsLlvmGlobals.
  // //    appendToGlobalDtors(M, F, Priority, Data);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


// Validate the result of Module::getOrInsertFunction called for an interface
// function of given sanitizer. If the instrumented module defines a function
// with the same name, their prototypes must match, otherwise
// getOrInsertFunction returns a bitcast.
//<editor-fold defaultstate="collapsed" desc="llvm::checkSanitizerInterfaceFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp", line = 92,
 FQN="llvm::checkSanitizerInterfaceFunction", NM="_ZN4llvm31checkSanitizerInterfaceFunctionEPNS_8ConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp -nm=_ZN4llvm31checkSanitizerInterfaceFunctionEPNS_8ConstantE")
//</editor-fold>
public static Function /*P*/ checkSanitizerInterfaceFunction(Constant /*P*/ FuncOrBitcast) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.ModuleUtilsLlvmGlobals.
  //    checkSanitizerInterfaceFunction(FuncOrBitcast);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Creates sanitizer constructor function, and calls sanitizer's init
/// function from it.
/// \return Returns pair of pointers to constructor, and init functions
/// respectively.
//<editor-fold defaultstate="collapsed" desc="llvm::createSanitizerCtorAndInitFunctions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp", line = 102,
 FQN="llvm::createSanitizerCtorAndInitFunctions", NM="_ZN4llvm35createSanitizerCtorAndInitFunctionsERNS_6ModuleENS_9StringRefES2_NS_8ArrayRefIPNS_4TypeEEENS3_IPNS_5ValueEEES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/ModuleUtils.cpp -nm=_ZN4llvm35createSanitizerCtorAndInitFunctionsERNS_6ModuleENS_9StringRefES2_NS_8ArrayRefIPNS_4TypeEEENS3_IPNS_5ValueEEES2_")
//</editor-fold>
public static std.pair<Function /*P*/ , Function /*P*/ > createSanitizerCtorAndInitFunctions(final Module /*&*/ M, StringRef CtorName, StringRef InitName, 
                                   ArrayRef<Type /*P*/ > InitArgTypes, ArrayRef<Value /*P*/ > InitArgs) {
  //  return createSanitizerCtorAndInitFunctions(M, CtorName, InitName, 
  //                                   InitArgTypes, InitArgs, 
  //                                   new StringRef());
  throw new UnsupportedOperationException("EmptyBody");
}
public static std.pair<Function /*P*/ , Function /*P*/ > createSanitizerCtorAndInitFunctions(final Module /*&*/ M, StringRef CtorName, StringRef InitName, 
                                   ArrayRef<Type /*P*/ > InitArgTypes, ArrayRef<Value /*P*/ > InitArgs, 
                                   StringRef VersionCheckName/*= StringRef()*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.ModuleUtilsLlvmGlobals.
  //    createSanitizerCtorAndInitFunctions(M, CtorName, InitName, 
  //                                   InitArgTypes, InitArgs, 
 //                                   VersionCheckName);
  throw new UnsupportedOperationException("EmptyBody");
}


/// Rename all the anon functions in the module using a hash computed from
/// the list of public globals in the module.

// Rename all the anon functions in the module
//<editor-fold defaultstate="collapsed" desc="llvm::nameUnamedFunctions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp", line = 62,
 FQN="llvm::nameUnamedFunctions", NM="_ZN4llvm19nameUnamedFunctionsERNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp -nm=_ZN4llvm19nameUnamedFunctionsERNS_6ModuleE")
//</editor-fold>
public static boolean nameUnamedFunctions(final Module /*&*/ M) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.NameAnonFunctionsLlvmGlobals.
  //    nameUnamedFunctions(M);
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createNameAnonFunctionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp", line = 101,
 FQN="llvm::createNameAnonFunctionPass", NM="_ZN4llvm26createNameAnonFunctionPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp -nm=_ZN4llvm26createNameAnonFunctionPassEv")
//</editor-fold>
public static ModulePass /*P*/ createNameAnonFunctionPass() {
  //  return /*delegate*/org.llvm.transforms.impl.NameAnonFunctionsLlvmGlobals.
  //    createNameAnonFunctionPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// NaryReassociate - Simplify n-ary operations by reassociation.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createNaryReassociatePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp", line = 206,
 FQN="llvm::createNaryReassociatePass", NM="_ZN4llvm25createNaryReassociatePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp -nm=_ZN4llvm25createNaryReassociatePassEv")
//</editor-fold>
public static FunctionPass /*P*/ createNaryReassociatePass() {
  //  return /*delegate*/org.llvm.transforms.impl.NaryReassociateLlvmGlobals.
  //    createNaryReassociatePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ObjCARCAPElim - ObjC ARC autorelease pool elimination.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createObjCARCAPElimPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp", line = 61,
 FQN="llvm::createObjCARCAPElimPass", NM="_ZN4llvm23createObjCARCAPElimPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp -nm=_ZN4llvm23createObjCARCAPElimPassEv")
//</editor-fold>
public static Pass /*P*/ createObjCARCAPElimPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ObjCARCAPElimLlvmGlobals.
  //    createObjCARCAPElimPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ObjCARCContract - Late ObjC ARC cleanups.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createObjCARCContractPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp", line = 644,
 FQN="llvm::createObjCARCContractPass", NM="_ZN4llvm25createObjCARCContractPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp -nm=_ZN4llvm25createObjCARCContractPassEv")
//</editor-fold>
public static Pass /*P*/ createObjCARCContractPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ObjCARCContractLlvmGlobals.
  //    createObjCARCContractPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ObjCARCExpand - ObjC ARC preliminary simplifications.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createObjCARCExpandPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp", line = 71,
 FQN="llvm::createObjCARCExpandPass", NM="_ZN4llvm23createObjCARCExpandPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp -nm=_ZN4llvm23createObjCARCExpandPassEv")
//</editor-fold>
public static Pass /*P*/ createObjCARCExpandPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ObjCARCExpandLlvmGlobals.
  //    createObjCARCExpandPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// ObjCARCOpt - ObjC ARC optimization.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createObjCARCOptPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp", line = 563,
 FQN="llvm::createObjCARCOptPass", NM="_ZN4llvm20createObjCARCOptPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp -nm=_ZN4llvm20createObjCARCOptPassEv")
//</editor-fold>
public static Pass /*P*/ createObjCARCOptPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ObjCARCOptsLlvmGlobals.
  //    createObjCARCOptPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// PGO Instrumention
//<editor-fold defaultstate="collapsed" desc="llvm::createPGOInstrumentationGenLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp", line = 182,
 FQN="llvm::createPGOInstrumentationGenLegacyPass", NM="_ZN4llvm37createPGOInstrumentationGenLegacyPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp -nm=_ZN4llvm37createPGOInstrumentationGenLegacyPassEv")
//</editor-fold>
public static ModulePass /*P*/ createPGOInstrumentationGenLegacyPass() {
  //  return /*delegate*/org.llvm.transforms.impl.PGOInstrumentationLlvmGlobals.
  //    createPGOInstrumentationGenLegacyPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPGOInstrumentationUseLegacyPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp", line = 194,
 FQN="llvm::createPGOInstrumentationUseLegacyPass", NM="_ZN4llvm37createPGOInstrumentationUseLegacyPassENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp -nm=_ZN4llvm37createPGOInstrumentationUseLegacyPassENS_9StringRefE")
//</editor-fold>
public static ModulePass /*P*/ createPGOInstrumentationUseLegacyPass() {
  return createPGOInstrumentationUseLegacyPass(new StringRef(/*KEEP_STR*/$EMPTY));
}
public static ModulePass /*P*/ createPGOInstrumentationUseLegacyPass(StringRef Filename/*= StringRef("")*/) {
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createPartialInliningPass - This pass inlines parts of functions.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createPartialInliningPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp", line = 55,
 FQN="llvm::createPartialInliningPass", NM="_ZN4llvm25createPartialInliningPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp -nm=_ZN4llvm25createPartialInliningPassEv")
//</editor-fold>
public static ModulePass /*P*/ createPartialInliningPass() {
  //  return /*delegate*/org.llvm.transforms.impl.PartialInliningLlvmGlobals.
  //    createPartialInliningPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// PartiallyInlineLibCalls - Tries to inline the fast path of library
// calls such as sqrt.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createPartiallyInlineLibCallsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp", line = 174,
 FQN="llvm::createPartiallyInlineLibCallsPass", NM="_ZN4llvm33createPartiallyInlineLibCallsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp -nm=_ZN4llvm33createPartiallyInlineLibCallsPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPartiallyInlineLibCallsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.PartiallyInlineLibCallsLlvmGlobals.
  //    createPartiallyInlineLibCallsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// PlaceSafepoints - Rewrite any IR calls to gc.statepoints and insert any
// safepoint polls (method entry, backedge) that might be required.  This pass
// does not generate explicit relocation sequences - that's handled by
// RewriteStatepointsForGC which can be run at an arbitrary point in the pass
// order following this pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createPlaceSafepointsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp", line = 592,
 FQN="llvm::createPlaceSafepointsPass", NM="_ZN4llvm25createPlaceSafepointsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp -nm=_ZN4llvm25createPlaceSafepointsPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPlaceSafepointsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.PlaceSafepointsLlvmGlobals.
  //    createPlaceSafepointsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Return true if this alloca is legal for promotion.
///
/// This is true if there are only loads, stores, and lifetime markers
/// (transitively) using this alloca. This also enforces that there is only
/// ever one layer of bitcasts or GEPs between the alloca and the lifetime
/// markers.
//<editor-fold defaultstate="collapsed" desc="llvm::isAllocaPromotable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/PromoteMemoryToRegister.cpp", line = 51,
 FQN="llvm::isAllocaPromotable", NM="_ZN4llvm18isAllocaPromotableEPKNS_10AllocaInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/PromoteMemoryToRegister.cpp -nm=_ZN4llvm18isAllocaPromotableEPKNS_10AllocaInstE")
//</editor-fold>
public static boolean isAllocaPromotable(/*const*/ AllocaInst /*P*/ AI) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.PromoteMemoryToRegisterLlvmGlobals.
  //    isAllocaPromotable(AI);
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Promote the specified list of alloca instructions into scalar
/// registers, inserting PHI nodes as appropriate.
///
/// This function makes use of DominanceFrontier information.  This function
/// does not modify the CFG of the function at all.  All allocas must be from
/// the same function.
///
/// If AST is specified, the specified tracker is updated to reflect changes
/// made to the IR.
//<editor-fold defaultstate="collapsed" desc="llvm::PromoteMemToReg">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/PromoteMemoryToRegister.cpp", line = 987,
 FQN="llvm::PromoteMemToReg", NM="_ZN4llvm15PromoteMemToRegENS_8ArrayRefIPNS_10AllocaInstEEERNS_13DominatorTreeEPNS_15AliasSetTrackerEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/PromoteMemoryToRegister.cpp -nm=_ZN4llvm15PromoteMemToRegENS_8ArrayRefIPNS_10AllocaInstEEERNS_13DominatorTreeEPNS_15AliasSetTrackerEPNS_15AssumptionCacheE")
//</editor-fold>
public static void PromoteMemToReg(ArrayRef<AllocaInst /*P*/ > Allocas, final DominatorTree /*&*/ DT) {
  //  PromoteMemToReg(Allocas, DT, 
  //               (AliasSetTracker /*P*/ )null, (AssumptionCache /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void PromoteMemToReg(ArrayRef<AllocaInst /*P*/ > Allocas, final DominatorTree /*&*/ DT, 
               AliasSetTracker /*P*/ AST/*= null*/) {
  //  PromoteMemToReg(Allocas, DT, 
  //               AST, (AssumptionCache /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void PromoteMemToReg(ArrayRef<AllocaInst /*P*/ > Allocas, final DominatorTree /*&*/ DT, 
               AliasSetTracker /*P*/ AST/*= null*/, AssumptionCache /*P*/ AC/*= null*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.PromoteMemoryToRegisterLlvmGlobals.
  //    PromoteMemToReg(Allocas, DT, 
  //               AST, AC);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createPruneEHPass - Return a new pass object which transforms invoke
/// instructions into calls, if the callee can _not_ unwind the stack.
///
//<editor-fold defaultstate="collapsed" desc="llvm::createPruneEHPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp", line = 62,
 FQN="llvm::createPruneEHPass", NM="_ZN4llvm17createPruneEHPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp -nm=_ZN4llvm17createPruneEHPassEv")
//</editor-fold>
public static Pass /*P*/ createPruneEHPass() {
  //  return /*delegate*/org.llvm.transforms.impl.PruneEHLlvmGlobals.
  //    createPruneEHPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// Reassociate - This pass reassociates commutative expressions in an order that
// is designed to promote better constant propagation, GCSE, LICM, PRE...
//
// For example:  4 + (x + 5)  ->  x + (4 + 5)
//

// Public interface to the Reassociate pass
//<editor-fold defaultstate="collapsed" desc="llvm::createReassociatePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp", line = 2258,
 FQN="llvm::createReassociatePass", NM="_ZN4llvm21createReassociatePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp -nm=_ZN4llvm21createReassociatePassEv")
//</editor-fold>
public static FunctionPass /*P*/ createReassociatePass() {
  //  return /*delegate*/org.llvm.transforms.impl.ReassociateLlvmGlobals.
  //    createReassociatePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// DemoteRegisterToMemoryPass - This pass is used to demote registers to memory
// references. In basically undoes the PromoteMemoryToRegister pass to make cfg
// hacking easier.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDemoteRegisterToMemoryPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp", line = 126,
 FQN="llvm::createDemoteRegisterToMemoryPass", NM="_ZN4llvm32createDemoteRegisterToMemoryPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp -nm=_ZN4llvm32createDemoteRegisterToMemoryPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDemoteRegisterToMemoryPass() {
  //  return /*delegate*/org.llvm.transforms.impl.Reg2MemLlvmGlobals.
  //    createDemoteRegisterToMemoryPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// createDemoteRegisterToMemory - Provide an entry point to create this pass.
//<editor-fold defaultstate="collapsed" desc="llvm::DemoteRegisterToMemoryID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp", line = 125,
 FQN="llvm::DemoteRegisterToMemoryID", NM="_ZN4llvm24DemoteRegisterToMemoryIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp -nm=_ZN4llvm24DemoteRegisterToMemoryIDE")
//</editor-fold>
public static final char$ref/*char &*/ DemoteRegisterToMemoryID = RegToMem.ID;

//===----------------------------------------------------------------------===//
//
// RewriteStatepointsForGC - Rewrite any gc.statepoints which do not yet have
// explicit relocations to include explicit relocations.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createRewriteStatepointsForGCPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp", line = 127,
 FQN="llvm::createRewriteStatepointsForGCPass", NM="_ZN4llvm33createRewriteStatepointsForGCPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp -nm=_ZN4llvm33createRewriteStatepointsForGCPassEv")
//</editor-fold>
public static ModulePass /*P*/ createRewriteStatepointsForGCPass() {
  //  return /*delegate*/org.llvm.transforms.impl.RewriteStatepointsForGCLlvmGlobals.
  //    createRewriteStatepointsForGCPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
/// createIPSCCPPass - This pass propagates constants from call sites into the
/// bodies of functions, and keeps track of whether basic blocks are executable
/// in the process.
///

// createIPSCCPPass - This is the public interface to this file.
//<editor-fold defaultstate="collapsed" desc="llvm::createIPSCCPPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp", line = 1946,
 FQN="llvm::createIPSCCPPass", NM="_ZN4llvm16createIPSCCPPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp -nm=_ZN4llvm16createIPSCCPPassEv")
//</editor-fold>
public static ModulePass /*P*/ createIPSCCPPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SCCPLlvmGlobals.
  //    createIPSCCPPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// SCCP - Sparse conditional constant propagation.
//

// createSCCPPass - This is the public interface to this file.
//<editor-fold defaultstate="collapsed" desc="llvm::createSCCPPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp", line = 1652,
 FQN="llvm::createSCCPPass", NM="_ZN4llvm14createSCCPPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp -nm=_ZN4llvm14createSCCPPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createSCCPPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SCCPLlvmGlobals.
  //    createSCCPPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// SLPVectorizer - Create a bottom-up SLP vectorizer pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createSLPVectorizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp", line = 4712,
 FQN="llvm::createSLPVectorizerPass", NM="_ZN4llvm23createSLPVectorizerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZN4llvm23createSLPVectorizerPassEv")
//</editor-fold>
public static Pass /*P*/ createSLPVectorizerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SLPVectorizerLlvmGlobals.
  //    createSLPVectorizerPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// SROA - Replace aggregates or pieces of aggregates with scalar SSA values.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createSROAPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp", line = 4289,
 FQN="llvm::createSROAPass", NM="_ZN4llvm14createSROAPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm14createSROAPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createSROAPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SROALlvmGlobals.
  //    createSROAPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
// SampleProfilePass - Loads sample profile data from disk and generates
// IR metadata to reflect the profile.
//<editor-fold defaultstate="collapsed" desc="llvm::createSampleProfileLoaderPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp", line = 1213,
 FQN="llvm::createSampleProfileLoaderPass", NM="_ZN4llvm29createSampleProfileLoaderPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp -nm=_ZN4llvm29createSampleProfileLoaderPassEv")
//</editor-fold>
public static ModulePass /*P*/ createSampleProfileLoaderPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SampleProfileLlvmGlobals.
  //    createSampleProfileLoaderPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createSampleProfileLoaderPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp", line = 1217,
 FQN="llvm::createSampleProfileLoaderPass", NM="_ZN4llvm29createSampleProfileLoaderPassENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp -nm=_ZN4llvm29createSampleProfileLoaderPassENS_9StringRefE")
//</editor-fold>
public static ModulePass /*P*/ createSampleProfileLoaderPass(StringRef Name) {
  //  return /*delegate*/org.llvm.transforms.impl.SampleProfileLlvmGlobals.
  //    createSampleProfileLoaderPass(Name);
  throw new UnsupportedOperationException("EmptyBody");
}


// Insert SanitizerCoverage instrumentation.
//<editor-fold defaultstate="collapsed" desc="llvm::createSanitizerCoverageModulePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp", line = 594,
 FQN="llvm::createSanitizerCoverageModulePass", NM="_ZN4llvm33createSanitizerCoverageModulePassERKNS_24SanitizerCoverageOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm33createSanitizerCoverageModulePassERKNS_24SanitizerCoverageOptionsE")
//</editor-fold>
public static ModulePass /*P*/ createSanitizerCoverageModulePass() {
  return createSanitizerCoverageModulePass(new SanitizerCoverageOptions());
}
public static ModulePass /*P*/ createSanitizerCoverageModulePass(SanitizerCoverageOptions Options) {
  //  return createSanitizerCoverageModulePass(new SanitizerCoverageOptions());
  //}
  //public static ModulePass /*P*/ createSanitizerCoverageModulePass(final /*const*/ SanitizerCoverageOptions /*&*/ Options/*= SanitizerCoverageOptions()*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.SanitizerCoverageLlvmGlobals.
  // //    createSanitizerCoverageModulePass(Options);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


// Number of bits in data that are used for the sanitizer kind. Needs to match
// __sanitizer::kKindBits in compiler-rt/lib/stats/stats.h
//<editor-fold defaultstate="collapsed" desc="llvm::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Transforms/Utils/SanitizerStats.h", line = 23,
 FQN="llvm::(anonymous)", NM="_Z4llvm_SanitizerStats_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SanitizerStats.cpp -nm=_Z4llvm_SanitizerStats_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int kSanitizerStatKindBits = 3;
/*}*/

//===----------------------------------------------------------------------===//
//
// ScalarizerPass - Converts vector operations into scalar operations
//
//<editor-fold defaultstate="collapsed" desc="llvm::createScalarizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp", line = 678,
 FQN="llvm::createScalarizerPass", NM="_ZN4llvm20createScalarizerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp -nm=_ZN4llvm20createScalarizerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createScalarizerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ScalarizerLlvmGlobals.
  //    createScalarizerPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// SeparateConstOffsetFromGEP - Split GEPs for better CSE
//
//<editor-fold defaultstate="collapsed" desc="llvm::createSeparateConstOffsetFromGEPPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp", line = 439,
 FQN="llvm::createSeparateConstOffsetFromGEPPass", NM="_ZN4llvm36createSeparateConstOffsetFromGEPPassEPKNS_13TargetMachineEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp -nm=_ZN4llvm36createSeparateConstOffsetFromGEPPassEPKNS_13TargetMachineEb")
//</editor-fold>
public static FunctionPass /*P*/ createSeparateConstOffsetFromGEPPass() {
  //  return createSeparateConstOffsetFromGEPPass((/*const*/ TargetMachine /*P*/ )null, 
  //                                    false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createSeparateConstOffsetFromGEPPass(/*const*/ TargetMachine /*P*/ TM/*= null*/) {
  //  return createSeparateConstOffsetFromGEPPass(TM, 
  //                                    false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createSeparateConstOffsetFromGEPPass(/*const*/ TargetMachine /*P*/ TM/*= null*/, 
                                    boolean LowerGEP/*= false*/) {
  //  return /*delegate*/org.llvm.transforms.impl.SeparateConstOffsetFromGEPLlvmGlobals.
  //    createSeparateConstOffsetFromGEPPass(TM, 
  //                                    LowerGEP);
  throw new UnsupportedOperationException("EmptyBody");
}


/// This function is used to do simplification of a CFG.  For
/// example, it adjusts branches to branches to eliminate the extra hop, it
/// eliminates unreachable basic blocks, and does other "peephole" optimization
/// of the CFG.  It returns true if a modification was made, possibly deleting
/// the basic block that was pointed to. LoopHeaders is an optional input
/// parameter, providing the set of loop header that SimplifyCFG should not
/// eliminate.

/// This function is used to do simplification of a CFG.
/// For example, it adjusts branches to branches to eliminate the extra hop,
/// eliminates unreachable basic blocks, and does other "peephole" optimization
/// of the CFG.  It returns true if a modification was made.
///
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCFG">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp", line = 5532,
 FQN="llvm::SimplifyCFG", NM="_ZN4llvm11SimplifyCFGEPNS_10BasicBlockERKNS_19TargetTransformInfoEjPNS_15AssumptionCacheEPNS_15SmallPtrSetImplIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp -nm=_ZN4llvm11SimplifyCFGEPNS_10BasicBlockERKNS_19TargetTransformInfoEjPNS_15AssumptionCacheEPNS_15SmallPtrSetImplIS1_EE")
//</editor-fold>
public static boolean SimplifyCFG(BasicBlock /*P*/ BB, final /*const*/ TargetTransformInfo /*&*/ TTI, 
           /*uint*/int BonusInstThreshold) {
  //  return SimplifyCFG(BB, TTI, 
  //           BonusInstThreshold, (AssumptionCache /*P*/ )null, 
  //           (SmallPtrSetImpl<BasicBlock /*P*/ > /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean SimplifyCFG(BasicBlock /*P*/ BB, final /*const*/ TargetTransformInfo /*&*/ TTI, 
           /*uint*/int BonusInstThreshold, AssumptionCache /*P*/ AC/*= null*/) {
  //  return SimplifyCFG(BB, TTI, 
  //           BonusInstThreshold, AC, 
  //           (SmallPtrSetImpl<BasicBlock /*P*/ > /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean SimplifyCFG(BasicBlock /*P*/ BB, final /*const*/ TargetTransformInfo /*&*/ TTI, 
           /*uint*/int BonusInstThreshold, AssumptionCache /*P*/ AC/*= null*/, 
           SmallPtrSetImpl<BasicBlock /*P*/ > /*P*/ LoopHeaders/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.SimplifyCFGLlvmGlobals.
  //    SimplifyCFG(BB, TTI, 
  //           BonusInstThreshold, AC, 
 //           LoopHeaders);
  throw new UnsupportedOperationException("EmptyBody");
}


/// If this basic block is ONLY a setcc and a branch, and if a predecessor
/// branches to us and one of our successors, fold the setcc into the
/// predecessor and use logical operations to pick the right destination.

/// If this basic block is simple enough, and if a predecessor branches to us
/// and one of our successors, fold the block into the predecessor and use
/// logical operations to pick the right destination.
//<editor-fold defaultstate="collapsed" desc="llvm::FoldBranchToCommonDest">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp", line = 2188,
 FQN="llvm::FoldBranchToCommonDest", NM="_ZN4llvm22FoldBranchToCommonDestEPNS_10BranchInstEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyCFG.cpp -nm=_ZN4llvm22FoldBranchToCommonDestEPNS_10BranchInstEj")
//</editor-fold>
public static boolean FoldBranchToCommonDest(BranchInst /*P*/ BI) {
  //  return FoldBranchToCommonDest(BI, 1);
  //}
  //public static boolean FoldBranchToCommonDest(BranchInst /*P*/ BI, /*uint*/int BonusInstThreshold/*= 1*/) {
  // //  return /*delegate*/org.llvm.transforms.utils.impl.SimplifyCFGLlvmGlobals.
  // //    FoldBranchToCommonDest(BI, BonusInstThreshold);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// CFGSimplification - Merge basic blocks, eliminate unreachable blocks,
// simplify terminator instructions, etc...
//

// Public interface to the CFGSimplification pass
//<editor-fold defaultstate="collapsed" desc="llvm::createCFGSimplificationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp", line = 241,
 FQN="llvm::createCFGSimplificationPass", NM="_ZN4llvm27createCFGSimplificationPassEiSt8functionIFbRKNS_8FunctionEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp -nm=_ZN4llvm27createCFGSimplificationPassEiSt8functionIFbRKNS_8FunctionEEE")
//</editor-fold>
public static FunctionPass /*P*/ createCFGSimplificationPass() {
  //  return createCFGSimplificationPass(-1, 
  //                           /*FuncArg*/null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createCFGSimplificationPass(int Threshold/*= -1*/) {
  //  return createCFGSimplificationPass(Threshold, 
  //                           /*FuncArg*/null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static FunctionPass /*P*/ createCFGSimplificationPass(int Threshold/*= -1*/, 
                           BoolPredicate<Function> /*&*/ Ftor/*= FuncArgnull*/) {
  //  return /*delegate*/org.llvm.transforms.impl.SimplifyCFGPassLlvmGlobals.
  //    createCFGSimplificationPass(Threshold, 
  //                           Ftor);
  throw new UnsupportedOperationException("EmptyBody");
}


/// simplifyUsersOfIV - Simplify instructions that use this induction variable
/// by using ScalarEvolution to analyze the IV's recurrence.

/// Simplify instructions that use this induction variable
/// by using ScalarEvolution to analyze the IV's recurrence.
//<editor-fold defaultstate="collapsed" desc="llvm::simplifyUsersOfIV">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyIndVar.cpp", line = 669,
 FQN="llvm::simplifyUsersOfIV", NM="_ZN4llvm17simplifyUsersOfIVEPNS_7PHINodeEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_8LoopInfoERNS_15SmallVectorImplINS_6WeakVHEEEPNS_9IVVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyIndVar.cpp -nm=_ZN4llvm17simplifyUsersOfIVEPNS_7PHINodeEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_8LoopInfoERNS_15SmallVectorImplINS_6WeakVHEEEPNS_9IVVisitorE")
//</editor-fold>
public static boolean simplifyUsersOfIV(PHINode /*P*/ CurrIV, ScalarEvolution /*P*/ SE, DominatorTree /*P*/ DT, 
                 LoopInfo /*P*/ LI, final SmallVectorImpl<WeakVH> /*&*/ Dead) {
  //  return simplifyUsersOfIV(CurrIV, SE, DT, 
  //                 LI, Dead, 
  //                 (IVVisitor /*P*/ )null);
  throw new UnsupportedOperationException("EmptyBody");
}
public static boolean simplifyUsersOfIV(PHINode /*P*/ CurrIV, ScalarEvolution /*P*/ SE, DominatorTree /*P*/ DT, 
                 LoopInfo /*P*/ LI, final SmallVectorImpl<WeakVH> /*&*/ Dead, 
                 IVVisitor /*P*/ V/*= null*/) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.SimplifyIndVarLlvmGlobals.
  //    simplifyUsersOfIV(CurrIV, SE, DT, 
  //                 LI, Dead, 
 //                 V);
  throw new UnsupportedOperationException("EmptyBody");
}


/// SimplifyLoopIVs - Simplify users of induction variables within this
/// loop. This does not actually change or add IVs.

/// Simplify users of induction variables within this
/// loop. This does not actually change or add IVs.
//<editor-fold defaultstate="collapsed" desc="llvm::simplifyLoopIVs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyIndVar.cpp", line = 679,
 FQN="llvm::simplifyLoopIVs", NM="_ZN4llvm15simplifyLoopIVsEPNS_4LoopEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_8LoopInfoERNS_15SmallVectorImplINS_6WeakVHEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyIndVar.cpp -nm=_ZN4llvm15simplifyLoopIVsEPNS_4LoopEPNS_15ScalarEvolutionEPNS_13DominatorTreeEPNS_8LoopInfoERNS_15SmallVectorImplINS_6WeakVHEEE")
//</editor-fold>
public static boolean simplifyLoopIVs(Loop /*P*/ L, ScalarEvolution /*P*/ SE, DominatorTree /*P*/ DT, 
               LoopInfo /*P*/ LI, final SmallVectorImpl<WeakVH> /*&*/ Dead) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.SimplifyIndVarLlvmGlobals.
  //    simplifyLoopIVs(L, SE, DT, 
  //               LI, Dead);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// InstructionSimplifier - Remove redundant instructions.
//

// Public interface to the simplify instructions pass.
//<editor-fold defaultstate="collapsed" desc="llvm::createInstructionSimplifierPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp", line = 124,
 FQN="llvm::createInstructionSimplifierPass", NM="_ZN4llvm31createInstructionSimplifierPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp -nm=_ZN4llvm31createInstructionSimplifierPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createInstructionSimplifierPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SimplifyInstructionsLlvmGlobals.
  //    createInstructionSimplifierPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::InstructionSimplifierID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp", line = 121,
 FQN="llvm::InstructionSimplifierID", NM="_ZN4llvm23InstructionSimplifierIDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp -nm=_ZN4llvm23InstructionSimplifierIDE")
//</editor-fold>
public static final char$ref/*char &*/ InstructionSimplifierID = InstSimplifier.ID;

//===----------------------------------------------------------------------===//
//
// Sink - Code Sinking
//
//<editor-fold defaultstate="collapsed" desc="llvm::createSinkingPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp", line = 306,
 FQN="llvm::createSinkingPass", NM="_ZN4llvm17createSinkingPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp -nm=_ZN4llvm17createSinkingPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createSinkingPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SinkLlvmGlobals.
  //    createSinkingPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createSpeculativeExecutionPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp", line = 275,
 FQN="llvm::createSpeculativeExecutionPass", NM="_ZN4llvm30createSpeculativeExecutionPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp -nm=_ZN4llvm30createSpeculativeExecutionPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createSpeculativeExecutionPass() {
  //  return /*delegate*/org.llvm.transforms.impl.SpeculativeExecutionLlvmGlobals.
  //    createSpeculativeExecutionPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createSpeculativeExecutionIfHasBranchDivergencePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp", line = 279,
 FQN="llvm::createSpeculativeExecutionIfHasBranchDivergencePass", NM="_ZN4llvm51createSpeculativeExecutionIfHasBranchDivergencePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp -nm=_ZN4llvm51createSpeculativeExecutionIfHasBranchDivergencePassEv")
//</editor-fold>
public static FunctionPass /*P*/ createSpeculativeExecutionIfHasBranchDivergencePass() {
  //  return /*delegate*/org.llvm.transforms.impl.SpeculativeExecutionLlvmGlobals.
  //    createSpeculativeExecutionIfHasBranchDivergencePass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// Splits the module M into N linkable partitions. The function ModuleCallback
/// is called N times passing each individual partition as the MPart argument.
///
/// FIXME: This function does not deal with the somewhat subtle symbol
/// visibility issues around module splitting, including (but not limited to):
///
/// - Internal symbols should not collide with symbols defined outside the
///   module.
/// - Internal symbols defined in module-level inline asm should be visible to
///   each partition.
//<editor-fold defaultstate="collapsed" desc="llvm::SplitModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SplitModule.cpp", line = 228,
 FQN="llvm::SplitModule", NM="_ZN4llvm11SplitModuleESt10unique_ptrINS_6ModuleESt14default_deleteIS1_EEjNS_12function_refIFvS4_EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SplitModule.cpp -nm=_ZN4llvm11SplitModuleESt10unique_ptrINS_6ModuleESt14default_deleteIS1_EEjNS_12function_refIFvS4_EEEb")
//</editor-fold>
public static void SplitModule(std.unique_ptr<Module> M, /*uint*/int N, 
           Type2Void<std.unique_ptr<Module>> ModuleCallback) {
  //  SplitModule(M, N, 
  //           ModuleCallback, 
  //           false);
  throw new UnsupportedOperationException("EmptyBody");
}
public static void SplitModule(std.unique_ptr<Module> M, /*uint*/int N, 
           Type2Void<std.unique_ptr<Module>> ModuleCallback, 
           boolean PreserveLocals/*= false*/) {
  //  /*delegate*/org.llvm.transforms.utils.impl.SplitModuleLlvmGlobals.
  //    SplitModule(M, N, 
  //           ModuleCallback, 
 //           PreserveLocals);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// StraightLineStrengthReduce - This pass strength-reduces some certain
// instruction patterns in straight-line code.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createStraightLineStrengthReducePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp", line = 220,
 FQN="llvm::createStraightLineStrengthReducePass", NM="_ZN4llvm36createStraightLineStrengthReducePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp -nm=_ZN4llvm36createStraightLineStrengthReducePassEv")
//</editor-fold>
public static FunctionPass /*P*/ createStraightLineStrengthReducePass() {
  //  return /*delegate*/org.llvm.transforms.impl.StraightLineStrengthReduceLlvmGlobals.
  //    createStraightLineStrengthReducePass();
  throw new UnsupportedOperationException("EmptyBody");
}


/// createStripDeadPrototypesPass - This pass removes any function declarations
/// (prototypes) that are not used.
//<editor-fold defaultstate="collapsed" desc="llvm::createStripDeadPrototypesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp", line = 86,
 FQN="llvm::createStripDeadPrototypesPass", NM="_ZN4llvm29createStripDeadPrototypesPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp -nm=_ZN4llvm29createStripDeadPrototypesPassEv")
//</editor-fold>
public static ModulePass /*P*/ createStripDeadPrototypesPass() {
  //  return /*delegate*/org.llvm.transforms.impl.StripDeadPrototypesLlvmGlobals.
  //    createStripDeadPrototypesPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// These functions removes symbols from functions and modules.  If OnlyDebugInfo
// is true, only debugging information is removed from the module.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createStripSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 103,
 FQN="llvm::createStripSymbolsPass", NM="_ZN4llvm22createStripSymbolsPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm22createStripSymbolsPassEb")
//</editor-fold>
public static ModulePass /*P*/ createStripSymbolsPass(boolean OnlyDebugInfo) {
  //  return createStripSymbolsPass(false);
  //}
  //public static ModulePass /*P*/ createStripSymbolsPass(boolean OnlyDebugInfo/*= false*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.StripSymbolsLlvmGlobals.
  // //    createStripSymbolsPass(OnlyDebugInfo);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// These functions strips symbols from functions and modules.
// Only debugging information is not stripped.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createStripNonDebugSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 112,
 FQN="llvm::createStripNonDebugSymbolsPass", NM="_ZN4llvm30createStripNonDebugSymbolsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm30createStripNonDebugSymbolsPassEv")
//</editor-fold>
public static ModulePass /*P*/ createStripNonDebugSymbolsPass() {
  //  return /*delegate*/org.llvm.transforms.impl.StripSymbolsLlvmGlobals.
  //    createStripNonDebugSymbolsPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// These pass removes llvm.dbg.declare intrinsics.
//<editor-fold defaultstate="collapsed" desc="llvm::createStripDebugDeclarePass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 120,
 FQN="llvm::createStripDebugDeclarePass", NM="_ZN4llvm27createStripDebugDeclarePassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm27createStripDebugDeclarePassEv")
//</editor-fold>
public static ModulePass /*P*/ createStripDebugDeclarePass() {
  //  return /*delegate*/org.llvm.transforms.impl.StripSymbolsLlvmGlobals.
  //    createStripDebugDeclarePass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// These pass removes unused symbols' debug info.
//<editor-fold defaultstate="collapsed" desc="llvm::createStripDeadDebugInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 128,
 FQN="llvm::createStripDeadDebugInfoPass", NM="_ZN4llvm28createStripDeadDebugInfoPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm28createStripDeadDebugInfoPassEv")
//</editor-fold>
public static ModulePass /*P*/ createStripDeadDebugInfoPass() {
  //  return /*delegate*/org.llvm.transforms.impl.StripSymbolsLlvmGlobals.
  //    createStripDeadDebugInfoPass();
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// CFG Structurization - Remove irreducible control flow
//
///
/// When \p SkipUniformRegions is true the structizer will not structurize
/// regions that only contain uniform branches.
//<editor-fold defaultstate="collapsed" desc="llvm::createStructurizeCFGPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp", line = 987,
 FQN="llvm::createStructurizeCFGPass", NM="_ZN4llvm24createStructurizeCFGPassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp -nm=_ZN4llvm24createStructurizeCFGPassEb")
//</editor-fold>
public static Pass /*P*/ createStructurizeCFGPass() {
  //  return createStructurizeCFGPass(false);
  //}
  //public static Pass /*P*/ createStructurizeCFGPass(boolean SkipUniformRegions/*= false*/) {
  // //  return /*delegate*/org.llvm.transforms.impl.StructurizeCFGLlvmGlobals.
  // //    createStructurizeCFGPass(SkipUniformRegions);
  // throw new UnsupportedOperationException("EmptyBody");
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createRewriteSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 544,
 FQN="llvm::createRewriteSymbolsPass", NM="_ZN4llvm24createRewriteSymbolsPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm24createRewriteSymbolsPassEv")
//</editor-fold>
public static ModulePass /*P*/ createRewriteSymbolsPass() {
  //  return /*delegate*/org.llvm.transforms.utils.impl.SymbolRewriterLlvmGlobals.
  //    createRewriteSymbolsPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createRewriteSymbolsPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 546,
 FQN="llvm::createRewriteSymbolsPass", NM="_ZN4llvm24createRewriteSymbolsPassERNS_6iplistINS_14SymbolRewriter17RewriteDescriptorENS_12ilist_traitsIS2_EEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm24createRewriteSymbolsPassERNS_6iplistINS_14SymbolRewriter17RewriteDescriptorENS_12ilist_traitsIS2_EEEE")
//</editor-fold>
public static ModulePass /*P*/ createRewriteSymbolsPass(final iplist<RewriteDescriptor> /*&*/ DL) {
  //  return /*delegate*/org.llvm.transforms.utils.impl.SymbolRewriterLlvmGlobals.
  //    createRewriteSymbolsPass(DL);
  throw new UnsupportedOperationException("EmptyBody");
}


//===----------------------------------------------------------------------===//
//
// TailCallElimination - This pass eliminates call instructions to the current
// function which occur immediately before return instructions.
//

// Public interface to the TailCallElimination pass
//<editor-fold defaultstate="collapsed" desc="llvm::createTailCallEliminationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp", line = 824,
 FQN="llvm::createTailCallEliminationPass", NM="_ZN4llvm29createTailCallEliminationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp -nm=_ZN4llvm29createTailCallEliminationPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createTailCallEliminationPass() {
  //  return /*delegate*/org.llvm.transforms.impl.TailRecursionEliminationLlvmGlobals.
  //    createTailCallEliminationPass();
  throw new UnsupportedOperationException("EmptyBody");
}


// Insert ThreadSanitizer (race detection) instrumentation
//<editor-fold defaultstate="collapsed" desc="llvm::createThreadSanitizerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp", line = 146,
 FQN="llvm::createThreadSanitizerPass", NM="_ZN4llvm25createThreadSanitizerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp -nm=_ZN4llvm25createThreadSanitizerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createThreadSanitizerPass() {
  //  return /*delegate*/org.llvm.transforms.impl.ThreadSanitizerLlvmGlobals.
  //    createThreadSanitizerPass();
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createUnifyFunctionExitNodesPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp", line = 30,
 FQN="llvm::createUnifyFunctionExitNodesPass", NM="_ZN4llvm32createUnifyFunctionExitNodesPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp -nm=_ZN4llvm32createUnifyFunctionExitNodesPassEv")
//</editor-fold>
public static Pass /*P*/ createUnifyFunctionExitNodesPass() {
  //  return /*delegate*/org.llvm.transforms.utils.impl.UnifyFunctionExitNodesLlvmGlobals.
  //    createUnifyFunctionExitNodesPass();
  throw new UnsupportedOperationException("EmptyBody");
}





/// \brief This pass implements whole-program devirtualization using type
/// metadata.
//<editor-fold defaultstate="collapsed" desc="llvm::createWholeProgramDevirtPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp", line = 311,
 FQN="llvm::createWholeProgramDevirtPass", NM="_ZN4llvm28createWholeProgramDevirtPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.transforms/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp -nm=_ZN4llvm28createWholeProgramDevirtPassEv")
//</editor-fold>
public static ModulePass /*P*/ createWholeProgramDevirtPass() {
  //  return /*delegate*/org.llvm.transforms.impl.WholeProgramDevirtLlvmGlobals.
  //    createWholeProgramDevirtPass();
  //}
  //
  throw new UnsupportedOperationException("EmptyBody");
} // END OF class TransformsLlvmGlobals
}