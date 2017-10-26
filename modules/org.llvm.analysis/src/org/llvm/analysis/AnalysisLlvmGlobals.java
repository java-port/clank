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
package org.llvm.analysis;

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
import static org.clank.support.JavaCleaner.JC$Push;
import static org.clank.support.JavaCleaner.JC$Pop;
import static org.clank.support.JavaCleaner.JC$Top;
import org.clank.support.NativeCallback.*;
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;
import org.llvm.analysis.LibFunc.target.*;
import org.llvm.analysis.LoopInfoGlobals.LoopBase;
import org.llvm.analysis.LoopInfoGlobals.LoopInfoBase;
import org.llvm.analysis.RegionInfoGlobals.RegionNodeBase;
import org.llvm.analysis.RegionInfoGlobals.RegionNodeBaseT;
import org.llvm.analysis.target.*;
import org.llvm.analysis.objcarc.*;
import org.llvm.analysis.cflaa.impl.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.*;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.*;
import static org.llvm.analysis.java.AnalysisRTTI.*;
import org.llvm.analysis.bfi_detail.*;
import org.llvm.analysis.impl.RegionInfoLlvmGlobals;
import org.llvm.analysis.java.impl.IPassLoop;
import static org.llvm.cl.ClGlobals.init;
import org.llvm.cl.aliases.optUInt;
import org.llvm.ir.java.IPassFunction;


//<editor-fold defaultstate="collapsed" desc="static type AnalysisLlvmGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.analysis.AnalysisLlvmGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGCall.cpp ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/CaptureTracking.cpp ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp ${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopPassManager.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/IR/OptBisect.cpp ${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/TypeMetadataUtils.cpp ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=Tpl__ZN4llvm10succ_beginEPT_;Tpl__ZN4llvm31createFunctionToLoopPassAdaptorET_;Tpl__ZN4llvm32createCGSCCToFunctionPassAdaptorET_b;Tpl__ZN4llvm39createModuleToPostOrderCGSCCPassAdaptorET_b;Tpl__ZN4llvm8succ_endEPT_;Tpl__ZN4llvm8visitAllEPKNS_4SCEVERT_;Tpl__ZN4llvmL21discoverAndMapSubloopEPT0_NS_8ArrayRefIPT_EEPNS_12LoopInfoBaseIS3_S0_EERKNS_17DominatorTreeBaseIS3_EE;Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_14RegionNodeBaseIT_EE;Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_8LoopBaseIT_T0_EE;_ZN4llvm10isFreeCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm10lintModuleERKNS_6ModuleE;_ZN4llvm10pred_beginEPNS_8IntervalE;_ZN4llvm10succ_beginEPNS_8IntervalE;_ZN4llvm10viewRegionEPKNS_8FunctionE;_ZN4llvm10viewRegionEPNS_10RegionInfoE;_ZN4llvm11isNoAliasFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm12SimplifyCallEPNS_5ValueENS_8ArrayRefIS1_EERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm12SimplifyCallEPNS_5ValueEPNS_3UseES3_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm12getPtrStrideERNS_25PredicatedScalarEvolutionEPNS_5ValueEPKNS_4LoopERKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_S3_EEEEb;_ZN4llvm12lintFunctionERKNS_8FunctionE;_ZN4llvm13SimplifyBinOpEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm13getInlineCostENS_8CallSiteEPNS_8FunctionEiRNS_19TargetTransformInfoEPNS_22AssumptionCacheTrackerEPNS_18ProfileSummaryInfoE;_ZN4llvm13getInlineCostENS_8CallSiteEiRNS_19TargetTransformInfoEPNS_22AssumptionCacheTrackerEPNS_18ProfileSummaryInfoE;_ZN4llvm13getMallocTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvm13getNodeHeaderEPNS_10BasicBlockE;_ZN4llvm13getNodeHeaderEPNS_8IntervalE;_ZN4llvm13getObjectSizeEPKNS_5ValueERyRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEbNS_11ObjSizeModeE;_ZN4llvm13getSplatValueEPKNS_5ValueE;_ZN4llvm13intervals_endEPNS_8FunctionE;_ZN4llvm13intervals_endERNS_17IntervalPartitionE;_ZN4llvm13isAllocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm13isNoAliasCallEPKNS_5ValueE;_ZN4llvm14ComputeSignBitEPNS_5ValueERbS2_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm14SimplifyOrInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm14createLintPassEv;_ZN4llvm14isAllocationFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm14isCallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm14isCriticalEdgeEPKNS_14TerminatorInstEjb;_ZN4llvm14isInlineViableERNS_8FunctionE;_ZN4llvm14isKnownNonNullEPKNS_5ValueE;_ZN4llvm14isKnownNonZeroEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm14isMallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb;_ZN4llvm14isSafeToExpandEPKNS_4SCEVERNS_15ScalarEvolutionE;_ZN4llvm14viewRegionOnlyEPKNS_8FunctionE;_ZN4llvm14viewRegionOnlyEPNS_10RegionInfoE;_ZN4llvm15ComputeMultipleEPNS_5ValueEjRS1_bj;_ZN4llvm15GetStringLengthEPNS_5ValueE;_ZN4llvm15SimplifyAddInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyAndInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyCmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyFPBinOpEjPNS_5ValueES1_RKNS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyGEPInstEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyMulInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyShlInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifySubInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15SimplifyXorInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm15colorEHFuncletsERNS_8FunctionE;_ZN4llvm15intervals_beginEPNS_8FunctionEb;_ZN4llvm15intervals_beginERNS_17IntervalPartitionEb;_ZN4llvm15isBytewiseValueEPNS_5ValueE;_ZN4llvm15isKnownNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm15isKnownNonEqualEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm15isKnownPositiveEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm16ConstantFoldCallEPNS_8FunctionENS_8ArrayRefIPNS_8ConstantEEEPKNS_17TargetLibraryInfoE;_ZN4llvm16SimplifyAShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFAddInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFCmpInstEjPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFDivInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFMulInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFRemInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyFSubInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyICmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyLShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifySDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifySRemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyUDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16SimplifyURemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm16computeKnownBitsEPNS_5ValueERNS_5APIntES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm16createAAEvalPassEv;_ZN4llvm16createPAEvalPassEv;_ZN4llvm16getUniqueCastUseEPNS_5ValueEPNS_4LoopEPNS_4TypeE;_ZN4llvm16isKnownNonNullAtEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm16stripIntegerCastEPNS_5ValueE;_ZN4llvm17DefMaxInstsToScanE;_ZN4llvm17FindInsertedValueEPNS_5ValueENS_8ArrayRefIjEEPNS_11InstructionE;_ZN4llvm17MaskedValueIsZeroEPNS_5ValueERKNS_5APIntERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm17SimplifyTruncInstEPNS_5ValueEPNS_4TypeERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm17addNodeToIntervalEPNS_8IntervalEPNS_10BasicBlockE;_ZN4llvm17addNodeToIntervalEPNS_8IntervalES1_;_ZN4llvm17createIVUsersPassEv;_ZN4llvm17createPostDomTreeEv;_ZN4llvm17extractCallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm17extractMallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvm17findScalarElementEPNS_5ValueEj;_ZN4llvm17isNoAliasArgumentEPKNS_5ValueE;_ZN4llvm17propagateMetadataEPNS_11InstructionENS_8ArrayRefIPNS_5ValueEEE;_ZN4llvm18ComputeNumSignBitsEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18GetSuccessorNumberEPKNS_10BasicBlockES2_;_ZN4llvm18SimplifySelectInstEPNS_5ValueES1_S1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm18getMallocArraySizeEPNS_8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb;_ZN4llvm18getSourceGraphNodeEPNS_17IntervalPartitionEPNS_10BasicBlockE;_ZN4llvm18getSourceGraphNodeEPNS_8FunctionEPNS_10BasicBlockE;_ZN4llvm18isIdentifiedObjectEPKNS_5ValueE;_ZN4llvm18isImpliedConditionEPNS_5ValueES1_RKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18isKnownNonNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm18matchSelectPatternEPNS_5ValueERS1_S2_PNS_11Instruction7CastOpsE;_ZN4llvm18stripGetElementPtrEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE;_ZN4llvm19GetUnderlyingObjectEPNS_5ValueERKNS_10DataLayoutEj;_ZN4llvm19SimplifyInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE;_ZN4llvm19createDomViewerPassEv;_ZN4llvm19createInstCountPassEv;_ZN4llvm19createMemDepPrinterEv;_ZN4llvm19haveNoCommonBitsSetEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm19isConsecutiveAccessEPNS_5ValueES1_RKNS_10DataLayoutERNS_15ScalarEvolutionEb;_ZN4llvm19isNoOpWithoutInvokeENS_13EHPersonalityE;_ZN4llvm20CannotBeNegativeZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj;_ZN4llvm20GetUnderlyingObjectsEPNS_5ValueERNS_15SmallVectorImplIS1_EERKNS_10DataLayoutEPNS_8LoopInfoEj;_ZN4llvm20PointerMayBeCapturedEPKNS_5ValueEPNS_14CaptureTrackerE;_ZN4llvm20PointerMayBeCapturedEPKNS_5ValueEbb;_ZN4llvm20createCFGPrinterPassEv;_ZN4llvm20createDomPrinterPassEv;_ZN4llvm20createRegionInfoPassEv;_ZN4llvm20getStrideFromPointerEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE;_ZN4llvm20isKnownNotFullPoisonEPKNS_11InstructionE;_ZN4llvm20mayBeMemoryDependentERKNS_11InstructionE;_ZN4llvm20propagatesFullPoisonEPKNS_11InstructionE;_ZN4llvm21FindFunctionBackedgesERKNS_8FunctionERNS_15SmallVectorImplISt4pairIPKNS_10BasicBlockES7_EEE;_ZN4llvm21canConstantFoldCallToEPKNS_8FunctionE;_ZN4llvm21classifyEHPersonalityEPKNS_5ValueE;_ZN4llvm21createMemDerefPrinterEv;_ZN4llvm21getConstantStringInfoEPKNS_5ValueERNS_9StringRefEyb;_ZN4llvm22TransformForPostIncUseENS_13TransformKindEPKNS_4SCEVEPNS_11InstructionEPNS_5ValueERNS_11SmallPtrSetIPKNS_4LoopELj2EEERNS_15ScalarEvolutionERNS_13DominatorTreeE;_ZN4llvm22createRegionViewerPassEv;_ZN4llvm22getGEPInductionOperandEPKNS_17GetElementPtrInstE;_ZN4llvm22getMallocAllocatedTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvm22isFuncletEHPersonalityENS_13EHPersonalityE;_ZN4llvm22isKnownToBeAPowerOfTwoEPNS_5ValueERKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm22isPotentiallyReachableEPKNS_10BasicBlockES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE;_ZN4llvm22isPotentiallyReachableEPKNS_11InstructionES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE;_ZN4llvm23ConstantFoldCastOperandEjPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE;_ZN4llvm23ConstantFoldInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm23SimplifyInsertValueInstEPNS_5ValueES1_NS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm23createDomOnlyViewerPassEv;_ZN4llvm23createLazyValueInfoPassEv;_ZN4llvm23createLegacyPMAAResultsERNS_4PassERNS_8FunctionERNS_13BasicAAResultE;_ZN4llvm23createPostDomViewerPassEv;_ZN4llvm23createRegionPrinterPassEv;_ZN4llvm23createSCEVAAWrapperPassEv;_ZN4llvm23getIntrinsicForCallSiteENS_17ImmutableCallSiteEPKNS_17TargetLibraryInfoE;_ZN4llvm23getWeightFromBranchProbENS_17BranchProbabilityE;_ZN4llvm23isTriviallyVectorizableENS_9Intrinsic2IDE;_ZN4llvm23isValidAssumeForContextEPKNS_11InstructionES2_PKNS_13DominatorTreeE;_ZN4llvm24ConstantFoldInstOperandsEPNS_11InstructionENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm24ConstantFoldInstOperandsEjPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE;_ZN4llvm24FindAvailableLoadedValueEPNS_8LoadInstEPNS_10BasicBlockERNS_14ilist_iteratorINS_11InstructionEEEjPNS_9AAResultsEPNS_9AAMDNodesEPb;_ZN4llvm24SimplifyExtractValueInstEPNS_5ValueENS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm24computeMinimumValueSizesENS_8ArrayRefIPNS_10BasicBlockEEERNS_12DemandedBitsEPKNS_19TargetTransformInfoE;_ZN4llvm24createBasicAAWrapperPassEv;_ZN4llvm24createCFGOnlyPrinterPassEv;_ZN4llvm24createDomOnlyPrinterPassEv;_ZN4llvm24createPostDomPrinterPassEv;_ZN4llvm24isDereferenceablePointerEPKNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm25canSimplifyInvokeNoUnwindEPKNS_8FunctionE;_ZN4llvm25createCallGraphViewerPassEv;_ZN4llvm25createDelinearizationPassEv;_ZN4llvm25getAAResultsAnalysisUsageERNS_13AnalysisUsageE;_ZN4llvm25getDefaultInlineThresholdEv;_ZN4llvm25initializeLazyBFIPassPassERNS_12PassRegistryE;_ZN4llvm25isIdentifiedFunctionLocalEPKNS_5ValueE;_ZN4llvm25isOverflowIntrinsicNoWrapEPNS_13IntrinsicInstERNS_13DominatorTreeE;_ZN4llvm25onlyUsedByLifetimeMarkersEPKNS_5ValueE;_ZN4llvm25replaceSymbolicStrideSCEVERNS_25PredicatedScalarEvolutionERKNS_8DenseMapIPKNS_5ValueEPS3_NS_12DenseMapInfoIS5_EENS_6detail12DenseMapPairIS5_S6_EEEES6_S6_;_ZN4llvm26IsConstantOffsetFromGlobalEPNS_8ConstantERPNS_11GlobalValueERNS_5APIntERKNS_10DataLayoutE;_ZN4llvm26PointerMayBeCapturedBeforeEPKNS_5ValueEbbPKNS_11InstructionEPNS_13DominatorTreeEbPNS_17OrderedBasicBlockE;_ZN4llvm26SimplifyExtractElementInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE;_ZN4llvm26createAAResultsWrapperPassEv;_ZN4llvm26createGlobalsAAWrapperPassEv;_ZN4llvm26createObjCARCAAWrapperPassEv;_ZN4llvm26createRegionOnlyViewerPassEv;_ZN4llvm27CannotBeOrderedLessThanZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj;_ZN4llvm27computeOverflowForSignedAddEPNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm27computeOverflowForSignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm27createCostModelAnalysisPassEv;_ZN4llvm27createExternalAAWrapperPassESt8functionIFvRNS_4PassERNS_8FunctionERNS_9AAResultsEEE;_ZN4llvm27createLegacyPMBasicAAResultERNS_4PassERNS_8FunctionE;_ZN4llvm27createPostDomOnlyViewerPassEv;_ZN4llvm27createRegionOnlyPrinterPassEv;_ZN4llvm27getVectorIntrinsicIDForCallEPKNS_8CallInstEPKNS_17TargetLibraryInfoE;_ZN4llvm27isAsynchronousEHPersonalityENS_13EHPersonalityE;_ZN4llvm27isGEPBasedOnPointerToStringEPKNS_11GEPOperatorE;_ZN4llvm27isSafeToLoadUnconditionallyEPNS_5ValueEjRKNS_10DataLayoutEPNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm28ConstantFoldBinaryOpOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutE;_ZN4llvm28ConstantFoldLoadFromConstPtrEPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE;_ZN4llvm28createCFLAndersAAWrapperPassEv;_ZN4llvm28createCFLSteensAAWrapperPassEv;_ZN4llvm28createDivergenceAnalysisPassEv;_ZN4llvm28createPostDomOnlyPrinterPassEv;_ZN4llvm28createTypeBasedAAWrapperPassEv;_ZN4llvm28getConstantRangeFromMetadataERNS_6MDNodeE;_ZN4llvm28getGuaranteedNonFullPoisonOpEPKNS_11InstructionE;_ZN4llvm28getLoopPassPreservedAnalysesEv;_ZN4llvm28hasVectorInstrinsicScalarOpdENS_9Intrinsic2IDEj;_ZN4llvm28initializeDummyCGSCCPassPassERNS_12PassRegistryE;_ZN4llvm28isSafeToSpeculativelyExecuteEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm28moduleCanBeRenamedForThinLTOERKNS_6ModuleE;_ZN4llvm29computeOverflowForUnsignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm29computeOverflowForUnsignedMulEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm29computeThresholdFromOptLevelsEjj;_ZN4llvm29createCallGraphDOTPrinterPassEv;_ZN4llvm29createDemandedBitsWrapperPassEv;_ZN4llvm29replaceAndRecursivelySimplifyEPNS_11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE;_ZN4llvm30ConstantFoldConterBaseWithConstantOffsetEPNS_5ValueERxRKNS_10DataLayoutE;_ZN4llvm32createModuleDebugInfoPrinterPassEv;_ZN4llvm32createScopedNoAliasAAWrapperPassEv;_ZN4llvm33ConstantFoldLoadThroughGEPIndicesEPNS_8ConstantENS_8ArrayRefIS1_EE;_ZN4llvm33computeKnownBitsFromRangeMetadataERKNS_6MDNodeERNS_5APIntES4_;_ZN4llvm34isDereferenceableAndAlignedPointerEPKNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE;_ZN4llvm35createDependenceAnalysisWrapperPassEv;_ZN4llvm35createModuleSummaryIndexWrapperPassEv;_ZN4llvm35findDevirtualizableCallsForTypeTestERNS_15SmallVectorImplINS_14DevirtCallSiteEEERNS0_IPNS_8CallInstEEES5_;_ZN4llvm36createTargetTransformInfoWrapperPassENS_16TargetIRAnalysisE;_ZN4llvm38ConstantFoldLoadThroughGEPConstantExprEPNS_8ConstantEPNS_12ConstantExprE;_ZN4llvm38isGuaranteedToExecuteForEveryIterationEPKNS_11InstructionEPKNS_4LoopE;_ZN4llvm42findDevirtualizableCallsForTypeCheckedLoadERNS_15SmallVectorImplINS_14DevirtCallSiteEEERNS0_IPNS_11InstructionEEES7_RbPNS_8CallInstE;_ZN4llvm42isGuaranteedToTransferExecutionToSuccessorEPKNS_11InstructionE;_ZN4llvm8pred_endEPNS_8IntervalE;_ZN4llvm8succ_endEPNS_8IntervalE;_ZN4llvmL10isFreeCallEPNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvmL17extractCallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvmL17extractMallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE;_ZN4llvmL19GetUnderlyingObjectEPKNS_5ValueERKNS_10DataLayoutEj;_ZN4llvmL21findIndirectCallSitesERNS_8FunctionE;_ZN4llvmL32GetPointerBaseWithConstantOffsetEPKNS_5ValueERxRKNS_10DataLayoutE;_ZN4llvmlsERNS_11raw_ostreamERKNS_13SCEVPredicateE;_ZN4llvmlsERNS_11raw_ostreamERKNS_15AliasSetTrackerE;_ZN4llvmlsERNS_11raw_ostreamERKNS_4SCEVE;_ZN4llvmlsERNS_11raw_ostreamERKNS_8AliasSetE; -static-type=AnalysisLlvmGlobals -package=org.llvm.analysis")
//</editor-fold>
public final class AnalysisLlvmGlobals {


/// Return true if this pointer is returned by a noalias function.
//<editor-fold defaultstate="collapsed" desc="llvm::isNoAliasCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 671,
 FQN="llvm::isNoAliasCall", NM="_ZN4llvm13isNoAliasCallEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm13isNoAliasCallEPKNS_5ValueE")
//</editor-fold>
public static boolean isNoAliasCall(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    isNoAliasCall(V);
}


/// Return true if this is an argument with the noalias attribute.
//<editor-fold defaultstate="collapsed" desc="llvm::isNoAliasArgument">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 677,
 FQN="llvm::isNoAliasArgument", NM="_ZN4llvm17isNoAliasArgumentEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm17isNoAliasArgumentEPKNS_5ValueE")
//</editor-fold>
public static boolean isNoAliasArgument(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    isNoAliasArgument(V);
}


/// Return true if this pointer refers to a distinct and identifiable object.
/// This returns true for:
///    Global Variables and Functions (but not Global Aliases)
///    Allocas
///    ByVal and NoAlias Arguments
///    NoAlias returns (e.g. calls to malloc)
///
//<editor-fold defaultstate="collapsed" desc="llvm::isIdentifiedObject">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 683,
 FQN="llvm::isIdentifiedObject", NM="_ZN4llvm18isIdentifiedObjectEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18isIdentifiedObjectEPKNS_5ValueE")
//</editor-fold>
public static boolean isIdentifiedObject(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    isIdentifiedObject(V);
}


/// Return true if V is umabigously identified at the function-level.
/// Different IdentifiedFunctionLocals can't alias.
/// Further, an IdentifiedFunctionLocal can not alias with any function
/// arguments other than itself, which is not necessarily true for
/// IdentifiedObjects.
//<editor-fold defaultstate="collapsed" desc="llvm::isIdentifiedFunctionLocal">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 695,
 FQN="llvm::isIdentifiedFunctionLocal", NM="_ZN4llvm25isIdentifiedFunctionLocalEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm25isIdentifiedFunctionLocalEPKNS_5ValueE")
//</editor-fold>
public static boolean isIdentifiedFunctionLocal(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    isIdentifiedFunctionLocal(V);
}

//<editor-fold defaultstate="collapsed" desc="llvm::createAAResultsWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 570,
 FQN="llvm::createAAResultsWrapperPass", NM="_ZN4llvm26createAAResultsWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm26createAAResultsWrapperPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createAAResultsWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    createAAResultsWrapperPass();
}


/// A wrapper pass around a callback which can be used to populate the
/// AAResults in the AAResultsWrapperPass from an external AA.
///
/// The callback provided here will be used each time we prepare an AAResults
/// object, and will receive a reference to the function wrapper pass, the
/// function, and the AAResults object to populate. This should be used when
/// setting up a custom pass pipeline to inject a hook into the AA results.
//<editor-fold defaultstate="collapsed" desc="llvm::createExternalAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 545,
 FQN="llvm::createExternalAAWrapperPass", NM="_ZN4llvm27createExternalAAWrapperPassESt8functionIFvRNS_4PassERNS_8FunctionERNS_9AAResultsEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27createExternalAAWrapperPassESt8functionIFvRNS_4PassERNS_8FunctionERNS_9AAResultsEEE")
//</editor-fold>
public static ImmutablePass /*P*/ createExternalAAWrapperPass(PassFunctionAAResults2Void Callback) {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    createExternalAAWrapperPass(Callback);
}


/// A helper for the legacy pass manager to create a \c AAResults
/// object populated to the best of our ability for a particular function when
/// inside of a \c ModulePass or a \c CallGraphSCCPass.
///
/// If a \c ModulePass or a \c CallGraphSCCPass calls \p
/// createLegacyPMAAResults, it also needs to call \p addUsedAAAnalyses in \p
/// getAnalysisUsage.
//<editor-fold defaultstate="collapsed" desc="llvm::createLegacyPMAAResults">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 644,
 FQN="llvm::createLegacyPMAAResults", NM="_ZN4llvm23createLegacyPMAAResultsERNS_4PassERNS_8FunctionERNS_13BasicAAResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm23createLegacyPMAAResultsERNS_4PassERNS_8FunctionERNS_13BasicAAResultE")
//</editor-fold>
public static AAResults createLegacyPMAAResults(final Pass /*&*/ P, final Function /*&*/ F,
                       final BasicAAResult /*&*/ BAR) {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    createLegacyPMAAResults(P, F,
                       BAR);
}


/// A helper for the legacy pass manager to populate \p AU to add uses to make
/// sure the analyses required by \p createLegacyPMAAResults are available.
//<editor-fold defaultstate="collapsed" desc="llvm::getAAResultsAnalysisUsage">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 699,
 FQN="llvm::getAAResultsAnalysisUsage", NM="_ZN4llvm25getAAResultsAnalysisUsageERNS_13AnalysisUsageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm25getAAResultsAnalysisUsageERNS_13AnalysisUsageE")
//</editor-fold>
public static void getAAResultsAnalysisUsage(final AnalysisUsage /*&*/ AU) {
  /*delegate*/org.llvm.analysis.impl.AliasAnalysisLlvmGlobals.
    getAAResultsAnalysisUsage(AU);
}

//<editor-fold defaultstate="collapsed" desc="llvm::createBasicAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 227,
 FQN="llvm::createBasicAAWrapperPass", NM="_ZN4llvm24createBasicAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm24createBasicAAWrapperPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createBasicAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.BasicAliasAnalysisLlvmGlobals.
    createBasicAAWrapperPass();
}


/// A helper for the legacy pass manager to create a \c BasicAAResult object
/// populated to the best of our ability for a particular function when inside
/// of a \c ModulePass or a \c CallGraphSCCPass.
//<editor-fold defaultstate="collapsed" desc="llvm::createLegacyPMBasicAAResult">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BasicAliasAnalysis.h", line = 232,
 FQN="llvm::createLegacyPMBasicAAResult", NM="_ZN4llvm27createLegacyPMBasicAAResultERNS_4PassERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27createLegacyPMBasicAAResultERNS_4PassERNS_8FunctionE")
//</editor-fold>
public static BasicAAResult createLegacyPMBasicAAResult(final Pass /*&*/ P, final Function /*&*/ F) {
  return /*delegate*/org.llvm.analysis.impl.BasicAliasAnalysisLlvmGlobals.
    createLegacyPMBasicAAResult(P, F);
}


/// Analyze the specified function to find all of the loop backedges in the
/// function and return them.  This is a relatively cheap (compared to
/// computing dominators and loop info) analysis.
///
/// The output is added to Result, as pairs of <from,to> edge info.
//<editor-fold defaultstate="collapsed" desc="llvm::FindFunctionBackedges">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFG.h", line = 35,
 FQN="llvm::FindFunctionBackedges", NM="_ZN4llvm21FindFunctionBackedgesERKNS_8FunctionERNS_15SmallVectorImplISt4pairIPKNS_10BasicBlockES7_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm21FindFunctionBackedgesERKNS_8FunctionERNS_15SmallVectorImplISt4pairIPKNS_10BasicBlockES7_EEE")
//</editor-fold>
public static void FindFunctionBackedges(final /*const*/ Function /*&*/ F,
                     final SmallVectorImpl<std.pairPtrPtr</*const*/ BasicBlock /*P*/ , /*const*/ BasicBlock /*P*/ > > /*&*/ Result) {
  /*delegate*/org.llvm.analysis.impl.CFGLlvmGlobals.
    FindFunctionBackedges(F,
                     Result);
}


/// Search for the specified successor of basic block BB and return its position
/// in the terminator instruction's list of successors.  It is an error to call
/// this with a block that is not a successor.
//<editor-fold defaultstate="collapsed" desc="llvm::GetSuccessorNumber">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFG.h", line = 43,
 FQN="llvm::GetSuccessorNumber", NM="_ZN4llvm18GetSuccessorNumberEPKNS_10BasicBlockES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18GetSuccessorNumberEPKNS_10BasicBlockES2_")
//</editor-fold>
public static /*uint*/int GetSuccessorNumber(/*const*/ BasicBlock /*P*/ BB, /*const*/ BasicBlock /*P*/ Succ) {
  return /*delegate*/org.llvm.analysis.impl.CFGLlvmGlobals.
    GetSuccessorNumber(BB, Succ);
}


/// Return true if the specified edge is a critical edge. Critical edges are
/// edges from a block with multiple successors to a block with multiple
/// predecessors.
///
//<editor-fold defaultstate="collapsed" desc="llvm::isCriticalEdge">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFG.h", line = 49,
 FQN="llvm::isCriticalEdge", NM="_ZN4llvm14isCriticalEdgeEPKNS_14TerminatorInstEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm14isCriticalEdgeEPKNS_14TerminatorInstEjb")
//</editor-fold>
public static boolean isCriticalEdge(/*const*/ TerminatorInst /*P*/ TI, /*uint*/int SuccNum) {
  return isCriticalEdge(TI, SuccNum,
              false);
}
public static boolean isCriticalEdge(/*const*/ TerminatorInst /*P*/ TI, /*uint*/int SuccNum,
              boolean AllowIdenticalEdges/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.CFGLlvmGlobals.
    isCriticalEdge(TI, SuccNum,
              AllowIdenticalEdges);
}


/// \brief Determine whether instruction 'To' is reachable from 'From',
/// returning true if uncertain.
///
/// Determine whether there is a path from From to To within a single function.
/// Returns false only if we can prove that once 'From' has been executed then
/// 'To' can not be executed. Conservatively returns true.
///
/// This function is linear with respect to the number of blocks in the CFG,
/// walking down successors from From to reach To, with a fixed threshold.
/// Using DT or LI allows us to answer more quickly. LI reduces the cost of
/// an entire loop of any number of blocsk to be the same as the cost of a
/// single block. DT reduces the cost by allowing the search to terminate when
/// we find a block that dominates the block containing 'To'. DT is most useful
/// on branchy code but not loops, and LI is most useful on code with loops but
/// does not help on branchy code outside loops.
//<editor-fold defaultstate="collapsed" desc="llvm::isPotentiallyReachable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFG.h", line = 67,
 FQN="llvm::isPotentiallyReachable", NM="_ZN4llvm22isPotentiallyReachableEPKNS_11InstructionES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm22isPotentiallyReachableEPKNS_11InstructionES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE")
//</editor-fold>
public static boolean isPotentiallyReachable(/*const*/ Instruction /*P*/ From, /*const*/ Instruction /*P*/ To) {
  return isPotentiallyReachable(From, To,
                      (/*const*/ DominatorTree /*P*/ )null,
                      (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ Instruction /*P*/ From, /*const*/ Instruction /*P*/ To,
                      /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return isPotentiallyReachable(From, To,
                      DT,
                      (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ Instruction /*P*/ From, /*const*/ Instruction /*P*/ To,
                      /*const*/ DominatorTree /*P*/ DT/*= null*/,
                      /*const*/ LoopInfo /*P*/ LI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.CFGLlvmGlobals.
    isPotentiallyReachable(From, To,
                      DT,
                      LI);
}


/// \brief Determine whether block 'To' is reachable from 'From', returning
/// true if uncertain.
///
/// Determine whether there is a path from From to To within a single function.
/// Returns false only if we can prove that once 'From' has been reached then
/// 'To' can not be executed. Conservatively returns true.
//<editor-fold defaultstate="collapsed" desc="llvm::isPotentiallyReachable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFG.h", line = 77,
 FQN="llvm::isPotentiallyReachable", NM="_ZN4llvm22isPotentiallyReachableEPKNS_10BasicBlockES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm22isPotentiallyReachableEPKNS_10BasicBlockES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE")
//</editor-fold>
public static boolean isPotentiallyReachable(/*const*/ BasicBlock /*P*/ From, /*const*/ BasicBlock /*P*/ To) {
  return isPotentiallyReachable(From, To,
                      (/*const*/ DominatorTree /*P*/ )null,
                      (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ BasicBlock /*P*/ From, /*const*/ BasicBlock /*P*/ To,
                      /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return isPotentiallyReachable(From, To,
                      DT,
                      (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachable(/*const*/ BasicBlock /*P*/ From, /*const*/ BasicBlock /*P*/ To,
                      /*const*/ DominatorTree /*P*/ DT/*= null*/,
                      /*const*/ LoopInfo /*P*/ LI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.CFGLlvmGlobals.
    isPotentiallyReachable(From, To,
                      DT,
                      LI);
}


/// \brief Determine whether there is at least one path from a block in
/// 'Worklist' to 'StopBB', returning true if uncertain.
///
/// Determine whether there is a path from at least one block in Worklist to
/// StopBB within a single function. Returns false only if we can prove that
/// once any block in 'Worklist' has been reached then 'StopBB' can not be
/// executed. Conservatively returns true.
//<editor-fold defaultstate="collapsed" desc="llvm::isPotentiallyReachableFromMany">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFG.h", line = 88,
 FQN="llvm::isPotentiallyReachableFromMany", NM="_ZN4llvm30isPotentiallyReachableFromManyERNS_15SmallVectorImplIPNS_10BasicBlockEEES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm30isPotentiallyReachableFromManyERNS_15SmallVectorImplIPNS_10BasicBlockEEES2_PKNS_13DominatorTreeEPKNS_8LoopInfoE")
//</editor-fold>
public static boolean isPotentiallyReachableFromMany(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Worklist,
                              BasicBlock /*P*/ StopBB) {
  return isPotentiallyReachableFromMany(Worklist,
                              StopBB,
                              (/*const*/ DominatorTree /*P*/ )null,
                              (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachableFromMany(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Worklist,
                              BasicBlock /*P*/ StopBB,
                              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return isPotentiallyReachableFromMany(Worklist,
                              StopBB,
                              DT,
                              (/*const*/ LoopInfo /*P*/ )null);
}
public static boolean isPotentiallyReachableFromMany(final SmallVectorImpl<BasicBlock /*P*/ > /*&*/ Worklist,
                              BasicBlock /*P*/ StopBB,
                              /*const*/ DominatorTree /*P*/ DT/*= null*/,
                              /*const*/ LoopInfo /*P*/ LI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.CFGLlvmGlobals.
    isPotentiallyReachableFromMany(Worklist,
                              StopBB,
                              DT,
                              LI);
}


//===--------------------------------------------------------------------===//
//
// createCFLAndersAAWrapperPass - This pass implements a set-based approach to
// alias analysis.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createCFLAndersAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLAndersAliasAnalysis.h", line = 135,
 FQN="llvm::createCFLAndersAAWrapperPass", NM="_ZN4llvm28createCFLAndersAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm28createCFLAndersAAWrapperPassEv")
//</editor-fold>
public static ImmutablePass /*P*/ createCFLAndersAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.CFLAndersAliasAnalysisLlvmGlobals.
    createCFLAndersAAWrapperPass();
}


//===--------------------------------------------------------------------===//
//
// createCFLSteensAAWrapperPass - This pass implements a set-based approach to
// alias analysis.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createCFLSteensAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFLSteensAliasAnalysis.h", line = 164,
 FQN="llvm::createCFLSteensAAWrapperPass", NM="_ZN4llvm28createCFLSteensAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm28createCFLSteensAAWrapperPassEv")
//</editor-fold>
public static ImmutablePass /*P*/ createCFLSteensAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.CFLSteensAliasAnalysisLlvmGlobals.
    createCFLSteensAAWrapperPass();
}


/// PointerMayBeCaptured - Return true if this pointer value may be captured
/// by the enclosing function (which is required to exist).  This routine can
/// be expensive, so consider caching the results.  The boolean ReturnCaptures
/// specifies whether returning the value (or part of it) from the function
/// counts as capturing it or not.  The boolean StoreCaptures specified
/// whether storing the value (or part of it) into memory anywhere
/// automatically counts as capturing it or not.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerMayBeCaptured">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CaptureTracking.h", line = 32,
 FQN="llvm::PointerMayBeCaptured", NM="_ZN4llvm20PointerMayBeCapturedEPKNS_5ValueEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20PointerMayBeCapturedEPKNS_5ValueEbb")
//</editor-fold>
public static boolean PointerMayBeCaptured(/*const*/ Value /*P*/ V,
                    boolean ReturnCaptures,
                    boolean StoreCaptures) {
  return /*delegate*/org.llvm.analysis.impl.CaptureTrackingLlvmGlobals.
    PointerMayBeCaptured(V,
                    ReturnCaptures,
                    StoreCaptures);
}


/// PointerMayBeCapturedBefore - Return true if this pointer value may be
/// captured by the enclosing function (which is required to exist). If a
/// DominatorTree is provided, only captures which happen before the given
/// instruction are considered. This routine can be expensive, so consider
/// caching the results.  The boolean ReturnCaptures specifies whether
/// returning the value (or part of it) from the function counts as capturing
/// it or not.  The boolean StoreCaptures specified whether storing the value
/// (or part of it) into memory anywhere automatically counts as capturing it
/// or not. Captures by the provided instruction are considered if the
/// final parameter is true. An ordered basic block in \p OBB could be used
/// to speed up capture-tracker queries.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerMayBeCapturedBefore">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CaptureTracking.h", line = 47,
 FQN="llvm::PointerMayBeCapturedBefore", NM="_ZN4llvm26PointerMayBeCapturedBeforeEPKNS_5ValueEbbPKNS_11InstructionEPNS_13DominatorTreeEbPNS_17OrderedBasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm26PointerMayBeCapturedBeforeEPKNS_5ValueEbbPKNS_11InstructionEPNS_13DominatorTreeEbPNS_17OrderedBasicBlockE")
//</editor-fold>
public static boolean PointerMayBeCapturedBefore(/*const*/ Value /*P*/ V, boolean ReturnCaptures,
                          boolean StoreCaptures, /*const*/ Instruction /*P*/ I,
                          DominatorTree /*P*/ DT) {
  return PointerMayBeCapturedBefore(V, ReturnCaptures,
                          StoreCaptures, I,
                          DT, false,
                          (OrderedBasicBlock /*P*/ )null);
}
public static boolean PointerMayBeCapturedBefore(/*const*/ Value /*P*/ V, boolean ReturnCaptures,
                          boolean StoreCaptures, /*const*/ Instruction /*P*/ I,
                          DominatorTree /*P*/ DT, boolean IncludeI/*= false*/) {
  return PointerMayBeCapturedBefore(V, ReturnCaptures,
                          StoreCaptures, I,
                          DT, IncludeI,
                          (OrderedBasicBlock /*P*/ )null);
}
public static boolean PointerMayBeCapturedBefore(/*const*/ Value /*P*/ V, boolean ReturnCaptures,
                          boolean StoreCaptures, /*const*/ Instruction /*P*/ I,
                          DominatorTree /*P*/ DT, boolean IncludeI/*= false*/,
                          OrderedBasicBlock /*P*/ OBB/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.CaptureTrackingLlvmGlobals.
    PointerMayBeCapturedBefore(V, ReturnCaptures,
                          StoreCaptures, I,
                          DT, IncludeI,
                          OBB);
}


/// PointerMayBeCaptured - Visit the value and the values derived from it and
/// find values which appear to be capturing the pointer value. This feeds
/// results into and is controlled by the CaptureTracker object.
//<editor-fold defaultstate="collapsed" desc="llvm::PointerMayBeCaptured">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CaptureTracking.h", line = 78,
 FQN="llvm::PointerMayBeCaptured", NM="_ZN4llvm20PointerMayBeCapturedEPKNS_5ValueEPNS_14CaptureTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20PointerMayBeCapturedEPKNS_5ValueEPNS_14CaptureTrackerE")
//</editor-fold>
public static void PointerMayBeCaptured(/*const*/ Value /*P*/ V, CaptureTracker /*P*/ Tracker) {
  /*delegate*/org.llvm.analysis.impl.CaptureTrackingLlvmGlobals.
    PointerMayBeCaptured(V, Tracker);
}


//===--------------------------------------------------------------------===//
//
// createGlobalsAAWrapperPass - This pass provides alias and mod/ref info for
// global values that do not have their addresses taken.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createGlobalsAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/GlobalsModRef.h", line = 153,
 FQN="llvm::createGlobalsAAWrapperPass", NM="_ZN4llvm26createGlobalsAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm26createGlobalsAAWrapperPassEv")
//</editor-fold>
public static ModulePass /*P*/ createGlobalsAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.GlobalsModRefLlvmGlobals.
    createGlobalsAAWrapperPass();
}

/*template <class BlockT, class LoopT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfo.h", line = 343,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_8LoopBaseIT_T0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_8LoopBaseIT_T0_EE")
//</editor-fold>
public static </*class*/ BlockT, /*class*/ LoopT> raw_ostream /*&*/ $out_raw_ostream_LoopBase$BlockT$LoopT$C(final raw_ostream /*&*/ OS, final /*const*/ LoopBase<BlockT, LoopT> /*&*/ Loop) {
  return /*delegate*/org.llvm.analysis.impl.LoopInfoLlvmGlobals.
    $out_raw_ostream_LoopBase$BlockT$LoopT$C(OS, Loop);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 156,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_4SCEVE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_4SCEVE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_SCEV$C(final raw_ostream /*&*/ OS, final /*const*/ SCEV /*&*/ S) {
  return /*delegate*/org.llvm.analysis.impl.ScalarEvolutionLlvmGlobals.
    $out_raw_ostream_SCEV$C(OS, S);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolution.h", line = 215,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_13SCEVPredicateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_13SCEVPredicateE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_SCEVPredicate$C(final raw_ostream /*&*/ OS, final /*const*/ SCEVPredicate /*&*/ P) {
  return /*delegate*/org.llvm.analysis.impl.ScalarEvolutionLlvmGlobals.
    $out_raw_ostream_SCEVPredicate$C(OS, P);
}


/// Use SCEVTraversal to visit all nodes in the given expression tree.
/*template <typename SV> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::visitAll">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionExpressions.h", line = 535,
 FQN="llvm::visitAll", NM="Tpl__ZN4llvm8visitAllEPKNS_4SCEVERT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=Tpl__ZN4llvm8visitAllEPKNS_4SCEVERT_")
//</editor-fold>
public static </*typename*/ SV> void visitAll(/*const*/ SCEV /*P*/ Root, final SV /*&*/ Visitor) {
  /*delegate*/org.llvm.analysis.impl.ScalarEvolutionExpressionsLlvmGlobals.
    visitAll(Root, Visitor);
}


/// Creates an instance of \c SCEVAAWrapperPass.
//<editor-fold defaultstate="collapsed" desc="llvm::createSCEVAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionAliasAnalysis.h", line = 68,
 FQN="llvm::createSCEVAAWrapperPass", NM="_ZN4llvm23createSCEVAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm23createSCEVAAWrapperPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createSCEVAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.ScalarEvolutionAliasAnalysisLlvmGlobals.
    createSCEVAAWrapperPass();
}


//===--------------------------------------------------------------------===//
//
// createScopedNoAliasAAWrapperPass - This pass implements metadata-based
// scoped noalias analysis.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createScopedNoAliasAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScopedNoAliasAA.h", line = 82,
 FQN="llvm::createScopedNoAliasAAWrapperPass", NM="_ZN4llvm32createScopedNoAliasAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm32createScopedNoAliasAAWrapperPassEv")
//</editor-fold>
public static ImmutablePass /*P*/ createScopedNoAliasAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.ScopedNoAliasAALlvmGlobals.
    createScopedNoAliasAAWrapperPass();
}


//===--------------------------------------------------------------------===//
//
// createTypeBasedAAWrapperPass - This pass implements metadata-based
// type-based alias analysis.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createTypeBasedAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TypeBasedAliasAnalysis.h", line = 83,
 FQN="llvm::createTypeBasedAAWrapperPass", NM="_ZN4llvm28createTypeBasedAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm28createTypeBasedAAWrapperPassEv")
//</editor-fold>
public static ImmutablePass /*P*/ createTypeBasedAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.TypeBasedAliasAnalysisLlvmGlobals.
    createTypeBasedAAWrapperPass();
}


/// Determine which bits of V are known to be either zero or one and return
/// them in the KnownZero/KnownOne bit sets.
///
/// This function is defined on values with integer type, values with pointer
/// type, and vectors of integers.  In the case
/// where V is a vector, the known zero and known one values are the
/// same width as the vector element, and the bit is set only if it is true
/// for all of the elements in the vector.
//<editor-fold defaultstate="collapsed" desc="llvm::computeKnownBits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 52,
 FQN="llvm::computeKnownBits", NM="_ZN4llvm16computeKnownBitsEPNS_5ValueERNS_5APIntES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm16computeKnownBitsEPNS_5ValueERNS_5APIntES3_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne,
                final /*const*/ DataLayout /*&*/ DL) {
  computeKnownBits(V, KnownZero, KnownOne,
                DL, 0,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne,
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  computeKnownBits(V, KnownZero, KnownOne,
                DL, Depth,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne,
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  computeKnownBits(V, KnownZero, KnownOne,
                DL, Depth,
                AC,
                (/*const*/ Instruction /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne,
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  computeKnownBits(V, KnownZero, KnownOne,
                DL, Depth,
                AC,
                CxtI,
                (/*const*/ DominatorTree /*P*/ )null);
}
public static void computeKnownBits(Value /*P*/ V, final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne,
                final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    computeKnownBits(V, KnownZero, KnownOne,
                DL, Depth,
                AC,
                CxtI,
                DT);
}

/// Compute known bits from the range metadata.
/// \p KnownZero the set of bits that are known to be zero
/// \p KnownOne the set of bits that are known to be one
//<editor-fold defaultstate="collapsed" desc="llvm::computeKnownBitsFromRangeMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 60,
 FQN="llvm::computeKnownBitsFromRangeMetadata", NM="_ZN4llvm33computeKnownBitsFromRangeMetadataERKNS_6MDNodeERNS_5APIntES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm33computeKnownBitsFromRangeMetadataERKNS_6MDNodeERNS_5APIntES4_")
//</editor-fold>
public static void computeKnownBitsFromRangeMetadata(final /*const*/ MDNode /*&*/ Ranges,
                                 final APInt /*&*/ KnownZero, final APInt /*&*/ KnownOne) {
  /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    computeKnownBitsFromRangeMetadata(Ranges,
                                 KnownZero, KnownOne);
}

/// Return true if LHS and RHS have no common bits set.
//<editor-fold defaultstate="collapsed" desc="llvm::haveNoCommonBitsSet">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 63,
 FQN="llvm::haveNoCommonBitsSet", NM="_ZN4llvm19haveNoCommonBitsSetEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm19haveNoCommonBitsSetEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return haveNoCommonBitsSet(LHS, RHS, DL,
                   (AssumptionCache /*P*/ )null,
                   (/*const*/ Instruction /*P*/ )null,
                   (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                   AssumptionCache /*P*/ AC/*= null*/) {
  return haveNoCommonBitsSet(LHS, RHS, DL,
                   AC,
                   (/*const*/ Instruction /*P*/ )null,
                   (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                   AssumptionCache /*P*/ AC/*= null*/,
                   /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return haveNoCommonBitsSet(LHS, RHS, DL,
                   AC,
                   CxtI,
                   (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean haveNoCommonBitsSet(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                   AssumptionCache /*P*/ AC/*= null*/,
                   /*const*/ Instruction /*P*/ CxtI/*= null*/,
                   /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    haveNoCommonBitsSet(LHS, RHS, DL,
                   AC,
                   CxtI,
                   DT);
}


/// Determine whether the sign bit is known to be zero or one. Convenience
/// wrapper around computeKnownBits.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeSignBit">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 70,
 FQN="llvm::ComputeSignBit", NM="_ZN4llvm14ComputeSignBitEPNS_5ValueERbS2_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm14ComputeSignBitEPNS_5ValueERbS2_RKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne,
              final /*const*/ DataLayout /*&*/ DL) {
  ComputeSignBit(V, KnownZero, KnownOne,
              DL, 0,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne,
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  ComputeSignBit(V, KnownZero, KnownOne,
              DL, Depth,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne,
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
              AssumptionCache /*P*/ AC/*= null*/) {
  ComputeSignBit(V, KnownZero, KnownOne,
              DL, Depth,
              AC,
              (/*const*/ Instruction /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne,
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
              AssumptionCache /*P*/ AC/*= null*/,
              /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  ComputeSignBit(V, KnownZero, KnownOne,
              DL, Depth,
              AC,
              CxtI,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static void ComputeSignBit(Value /*P*/ V, final bool$ref/*bool &*/ KnownZero, final bool$ref/*bool &*/ KnownOne,
              final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
              AssumptionCache /*P*/ AC/*= null*/,
              /*const*/ Instruction /*P*/ CxtI/*= null*/,
              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    ComputeSignBit(V, KnownZero, KnownOne,
              DL, Depth,
              AC,
              CxtI,
              DT);
}


/// Return true if the given value is known to have exactly one bit set when
/// defined. For vectors return true if every element is known to be a power
/// of two when defined. Supports values with integer or pointer type and
/// vectors of integers. If 'OrZero' is set, then return true if the given
/// value is either a power of two or zero.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownToBeAPowerOfTwo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 81,
 FQN="llvm::isKnownToBeAPowerOfTwo", NM="_ZN4llvm22isKnownToBeAPowerOfTwoEPNS_5ValueERKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm22isKnownToBeAPowerOfTwoEPNS_5ValueERKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownToBeAPowerOfTwo(V, DL,
                      false, 0,
                      (AssumptionCache /*P*/ )null,
                      (/*const*/ Instruction /*P*/ )null,
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                      boolean OrZero/*= false*/) {
  return isKnownToBeAPowerOfTwo(V, DL,
                      OrZero, 0,
                      (AssumptionCache /*P*/ )null,
                      (/*const*/ Instruction /*P*/ )null,
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                      boolean OrZero/*= false*/, /*uint*/int Depth/*= 0*/) {
  return isKnownToBeAPowerOfTwo(V, DL,
                      OrZero, Depth,
                      (AssumptionCache /*P*/ )null,
                      (/*const*/ Instruction /*P*/ )null,
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                      boolean OrZero/*= false*/, /*uint*/int Depth/*= 0*/,
                      AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownToBeAPowerOfTwo(V, DL,
                      OrZero, Depth,
                      AC,
                      (/*const*/ Instruction /*P*/ )null,
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                      boolean OrZero/*= false*/, /*uint*/int Depth/*= 0*/,
                      AssumptionCache /*P*/ AC/*= null*/,
                      /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownToBeAPowerOfTwo(V, DL,
                      OrZero, Depth,
                      AC,
                      CxtI,
                      (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownToBeAPowerOfTwo(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                      boolean OrZero/*= false*/, /*uint*/int Depth/*= 0*/,
                      AssumptionCache /*P*/ AC/*= null*/,
                      /*const*/ Instruction /*P*/ CxtI/*= null*/,
                      /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownToBeAPowerOfTwo(V, DL,
                      OrZero, Depth,
                      AC,
                      CxtI,
                      DT);
}


/// Return true if the given value is known to be non-zero when defined. For
/// vectors, return true if every element is known to be non-zero when
/// defined. Supports values with integer or pointer type and vectors of
/// integers.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonZero">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 91,
 FQN="llvm::isKnownNonZero", NM="_ZN4llvm14isKnownNonZeroEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm14isKnownNonZeroEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNonZero(V, DL, 0,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownNonZero(V, DL, Depth,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
              AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNonZero(V, DL, Depth,
              AC,
              (/*const*/ Instruction /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
              AssumptionCache /*P*/ AC/*= null*/,
              /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNonZero(V, DL, Depth,
              AC,
              CxtI,
              (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonZero(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
              AssumptionCache /*P*/ AC/*= null*/,
              /*const*/ Instruction /*P*/ CxtI/*= null*/,
              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNonZero(V, DL, Depth,
              AC,
              CxtI,
              DT);
}


/// Returns true if the give value is known to be non-negative.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonNegative">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 97,
 FQN="llvm::isKnownNonNegative", NM="_ZN4llvm18isKnownNonNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18isKnownNonNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNonNegative(V, DL, 0,
                  (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownNonNegative(V, DL, Depth,
                  (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
                  AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNonNegative(V, DL, Depth,
                  AC,
                  (/*const*/ Instruction /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
                  AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNonNegative(V, DL, Depth,
                  AC,
                  CxtI,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
                  AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/,
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNonNegative(V, DL, Depth,
                  AC,
                  CxtI,
                  DT);
}


/// Returns true if the given value is known be positive (i.e. non-negative
/// and non-zero).
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownPositive">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 104,
 FQN="llvm::isKnownPositive", NM="_ZN4llvm15isKnownPositiveEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm15isKnownPositiveEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownPositive(V, DL, 0,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownPositive(V, DL, Depth,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownPositive(V, DL, Depth,
               AC,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownPositive(V, DL, Depth,
               AC,
               CxtI,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownPositive(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownPositive(V, DL, Depth,
               AC,
               CxtI,
               DT);
}


/// Returns true if the given value is known be negative (i.e. non-positive
/// and non-zero).
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNegative">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 111,
 FQN="llvm::isKnownNegative", NM="_ZN4llvm15isKnownNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm15isKnownNegativeEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNegative(V, DL, 0,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/) {
  return isKnownNegative(V, DL, Depth,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNegative(V, DL, Depth,
               AC,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNegative(V, DL, Depth,
               AC,
               CxtI,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNegative(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL, /*uint*/int Depth/*= 0*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNegative(V, DL, Depth,
               AC,
               CxtI,
               DT);
}


/// Return true if the given values are known to be non-equal when defined.
/// Supports scalar integer types only.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonEqual">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 118,
 FQN="llvm::isKnownNonEqual", NM="_ZN4llvm15isKnownNonEqualEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm15isKnownNonEqualEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL) {
  return isKnownNonEqual(V1, V2, DL,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL,
               AssumptionCache /*P*/ AC/*= null*/) {
  return isKnownNonEqual(V1, V2, DL,
               AC,
               (/*const*/ Instruction /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isKnownNonEqual(V1, V2, DL,
               AC,
               CxtI,
               (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonEqual(Value /*P*/ V1, Value /*P*/ V2, final /*const*/ DataLayout /*&*/ DL,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNonEqual(V1, V2, DL,
               AC,
               CxtI,
               DT);
}


/// Return true if 'V & Mask' is known to be zero. We use this predicate to
/// simplify operations downstream. Mask is known to be zero for bits that V
/// cannot have.
///
/// This function is defined on values with integer type, values with pointer
/// type, and vectors of integers.  In the case
/// where V is a vector, the mask, known zero, and known one values are the
/// same width as the vector element, and the bit is set only if it is true
/// for all of the elements in the vector.
//<editor-fold defaultstate="collapsed" desc="llvm::MaskedValueIsZero">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 132,
 FQN="llvm::MaskedValueIsZero", NM="_ZN4llvm17MaskedValueIsZeroEPNS_5ValueERKNS_5APIntERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm17MaskedValueIsZeroEPNS_5ValueERKNS_5APIntERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL) {
  return MaskedValueIsZero(V, Mask, DL,
                 0, (AssumptionCache /*P*/ )null,
                 (/*const*/ Instruction /*P*/ )null,
                 (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL,
                 /*uint*/int Depth/*= 0*/) {
  return MaskedValueIsZero(V, Mask, DL,
                 Depth, (AssumptionCache /*P*/ )null,
                 (/*const*/ Instruction /*P*/ )null,
                 (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL,
                 /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return MaskedValueIsZero(V, Mask, DL,
                 Depth, AC,
                 (/*const*/ Instruction /*P*/ )null,
                 (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL,
                 /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/,
                 /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return MaskedValueIsZero(V, Mask, DL,
                 Depth, AC,
                 CxtI,
                 (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean MaskedValueIsZero(Value /*P*/ V, final /*const*/ APInt /*&*/ Mask, final /*const*/ DataLayout /*&*/ DL,
                 /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/,
                 /*const*/ Instruction /*P*/ CxtI/*= null*/,
                 /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    MaskedValueIsZero(V, Mask, DL,
                 Depth, AC,
                 CxtI,
                 DT);
}


/// Return the number of times the sign bit of the register is replicated into
/// the other bits. We know that at least 1 bit is always equal to the sign
/// bit (itself), but other cases can give us information. For example,
/// immediately after an "ashr X, 2", we know that the top 3 bits are all
/// equal to each other, so we return 3. For vectors, return the number of
/// sign bits for the vector element with the mininum number of known sign
/// bits.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeNumSignBits">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 144,
 FQN="llvm::ComputeNumSignBits", NM="_ZN4llvm18ComputeNumSignBitsEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18ComputeNumSignBitsEPNS_5ValueERKNS_10DataLayoutEjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static /*uint*/int ComputeNumSignBits(Value /*P*/ Op, final /*const*/ DataLayout /*&*/ DL) {
  return ComputeNumSignBits(Op, DL,
                  0, (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ Op, final /*const*/ DataLayout /*&*/ DL,
                  /*uint*/int Depth/*= 0*/) {
  return ComputeNumSignBits(Op, DL,
                  Depth, (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ Op, final /*const*/ DataLayout /*&*/ DL,
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return ComputeNumSignBits(Op, DL,
                  Depth, AC,
                  (/*const*/ Instruction /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ Op, final /*const*/ DataLayout /*&*/ DL,
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return ComputeNumSignBits(Op, DL,
                  Depth, AC,
                  CxtI,
                  (/*const*/ DominatorTree /*P*/ )null);
}
public static /*uint*/int ComputeNumSignBits(Value /*P*/ Op, final /*const*/ DataLayout /*&*/ DL,
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/,
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    ComputeNumSignBits(Op, DL,
                  Depth, AC,
                  CxtI,
                  DT);
}


/// This function computes the integer multiple of Base that equals V. If
/// successful, it returns true and returns the multiple in Multiple. If
/// unsuccessful, it returns false. Also, if V can be simplified to an
/// integer, then the simplified V is returned in Val. Look through sext only
/// if LookThroughSExt=true.
//<editor-fold defaultstate="collapsed" desc="llvm::ComputeMultiple">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 154,
 FQN="llvm::ComputeMultiple", NM="_ZN4llvm15ComputeMultipleEPNS_5ValueEjRS1_bj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm15ComputeMultipleEPNS_5ValueEjRS1_bj")
//</editor-fold>
public static boolean ComputeMultiple(Value /*P*/ V, /*uint*/int Base, final type$ref<Value /*P*/ /*&*/> Multiple) {
  return ComputeMultiple(V, Base, Multiple,
               false,
               0);
}
public static boolean ComputeMultiple(Value /*P*/ V, /*uint*/int Base, final type$ref<Value /*P*/ /*&*/> Multiple,
               boolean LookThroughSExt/*= false*/) {
  return ComputeMultiple(V, Base, Multiple,
               LookThroughSExt,
               0);
}
public static boolean ComputeMultiple(Value /*P*/ V, /*uint*/int Base, final type$ref<Value /*P*/ /*&*/> Multiple,
               boolean LookThroughSExt/*= false*/,
               /*uint*/int Depth/*= 0*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    ComputeMultiple(V, Base, Multiple,
               LookThroughSExt,
               Depth);
}


/// Map a call instruction to an intrinsic ID.  Libcalls which have equivalent
/// intrinsics are treated as-if they were intrinsics.
//<editor-fold defaultstate="collapsed" desc="llvm::getIntrinsicForCallSite">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 160,
 FQN="llvm::getIntrinsicForCallSite", NM="_ZN4llvm23getIntrinsicForCallSiteENS_17ImmutableCallSiteEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm23getIntrinsicForCallSiteENS_17ImmutableCallSiteEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*Intrinsic.ID*/int getIntrinsicForCallSite(ImmutableCallSite ICS,
                       /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    getIntrinsicForCallSite(ICS,
                       TLI);
}


/// Return true if we can prove that the specified FP value is never equal to
/// -0.0.
//<editor-fold defaultstate="collapsed" desc="llvm::CannotBeNegativeZero">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 165,
 FQN="llvm::CannotBeNegativeZero", NM="_ZN4llvm20CannotBeNegativeZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20CannotBeNegativeZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj")
//</editor-fold>
public static boolean CannotBeNegativeZero(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return CannotBeNegativeZero(V, TLI,
                    0);
}
public static boolean CannotBeNegativeZero(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
                    /*uint*/int Depth/*= 0*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    CannotBeNegativeZero(V, TLI,
                    Depth);
}


/// Return true if we can prove that the specified FP value is either a NaN or
/// never less than 0.0.
//<editor-fold defaultstate="collapsed" desc="llvm::CannotBeOrderedLessThanZero">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 170,
 FQN="llvm::CannotBeOrderedLessThanZero", NM="_ZN4llvm27CannotBeOrderedLessThanZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27CannotBeOrderedLessThanZeroEPKNS_5ValueEPKNS_17TargetLibraryInfoEj")
//</editor-fold>
public static boolean CannotBeOrderedLessThanZero(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return CannotBeOrderedLessThanZero(V, TLI,
                           0);
}
public static boolean CannotBeOrderedLessThanZero(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
                           /*uint*/int Depth/*= 0*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    CannotBeOrderedLessThanZero(V, TLI,
                           Depth);
}


/// If the specified value can be set by repeating the same byte in memory,
/// return the i8 value that it is represented with. This is true for all i8
/// values obviously, but is also true for i32 0, i32 -1, i16 0xF0F0, double
/// 0.0 etc. If the value can't be handled with a repeated byte store (e.g.
/// i16 0x1234), return null.
//<editor-fold defaultstate="collapsed" desc="llvm::isBytewiseValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 178,
 FQN="llvm::isBytewiseValue", NM="_ZN4llvm15isBytewiseValueEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm15isBytewiseValueEPNS_5ValueE")
//</editor-fold>
public static Value /*P*/ isBytewiseValue(Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isBytewiseValue(V);
}


/// Given an aggregrate and an sequence of indices, see if the scalar value
/// indexed is already around as a register, for example if it were inserted
/// directly into the aggregrate.
///
/// If InsertBefore is not null, this function will duplicate (modified)
/// insertvalues when a part of a nested struct is extracted.
//<editor-fold defaultstate="collapsed" desc="llvm::FindInsertedValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 186,
 FQN="llvm::FindInsertedValue", NM="_ZN4llvm17FindInsertedValueEPNS_5ValueENS_8ArrayRefIjEEPNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm17FindInsertedValueEPNS_5ValueENS_8ArrayRefIjEEPNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ FindInsertedValue(Value /*P*/ V,
                 ArrayRefUInt idx_range) {
  return FindInsertedValue(V,
                 idx_range,
                 (Instruction /*P*/ )null);
}
public static Value /*P*/ FindInsertedValue(Value /*P*/ V,
                 ArrayRefUInt idx_range,
                 Instruction /*P*/ InsertBefore/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    FindInsertedValue(V,
                 idx_range,
                 InsertBefore);
}


/// Analyze the specified pointer to see if it can be expressed as a base
/// pointer plus a constant offset. Return the base and offset to the caller.
//<editor-fold defaultstate="collapsed" desc="llvm::GetPointerBaseWithConstantOffset">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 192,
 FQN="llvm::GetPointerBaseWithConstantOffset", NM="_ZN4llvm32GetPointerBaseWithConstantOffsetEPNS_5ValueERxRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm32GetPointerBaseWithConstantOffsetEPNS_5ValueERxRKNS_10DataLayoutE")
//</editor-fold>
public static Value /*P*/ GetPointerBaseWithConstantOffset_Value$P_long$ref_DataLayout$C(Value /*P*/ Ptr, final long$ref/*int64_t &*/ Offset,
                                                              final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    GetPointerBaseWithConstantOffset_Value$P_long$ref_DataLayout$C(Ptr, Offset,
                                                              DL);
}

//<editor-fold defaultstate="collapsed" desc="llvm::GetPointerBaseWithConstantOffset">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 194,
 FQN="llvm::GetPointerBaseWithConstantOffset", NM="_ZN4llvmL32GetPointerBaseWithConstantOffsetEPKNS_5ValueERxRKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvmL32GetPointerBaseWithConstantOffsetEPKNS_5ValueERxRKNS_10DataLayoutE")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetPointerBaseWithConstantOffset_Value$C$P_long$ref_DataLayout$C(/*const*/ Value /*P*/ Ptr, final long$ref/*int64_t &*/ Offset,
                                                                final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    GetPointerBaseWithConstantOffset_Value$C$P_long$ref_DataLayout$C(Ptr, Offset,
                                                                DL);
}


/// Returns true if the GEP is based on a pointer to a string (array of i8),
/// and is indexing into this string.
//<editor-fold defaultstate="collapsed" desc="llvm::isGEPBasedOnPointerToString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 203,
 FQN="llvm::isGEPBasedOnPointerToString", NM="_ZN4llvm27isGEPBasedOnPointerToStringEPKNS_11GEPOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27isGEPBasedOnPointerToStringEPKNS_11GEPOperatorE")
//</editor-fold>
public static boolean isGEPBasedOnPointerToString(/*const*/ GEPOperator /*P*/ GEP) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isGEPBasedOnPointerToString(GEP);
}


/// This function computes the length of a null-terminated C string pointed to
/// by V. If successful, it returns true and returns the string in Str. If
/// unsuccessful, it returns false. This does not include the trailing null
/// character by default. If TrimAtNul is set to false, then this returns any
/// trailing null characters as well as any other characters that come after
/// it.
//<editor-fold defaultstate="collapsed" desc="llvm::getConstantStringInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 211,
 FQN="llvm::getConstantStringInfo", NM="_ZN4llvm21getConstantStringInfoEPKNS_5ValueERNS_9StringRefEyb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm21getConstantStringInfoEPKNS_5ValueERNS_9StringRefEyb")
//</editor-fold>
public static boolean getConstantStringInfo(/*const*/ Value /*P*/ V, final StringRef /*&*/ Str) {
  return getConstantStringInfo(V, Str,
                     $int2ulong(0), true);
}
public static boolean getConstantStringInfo(/*const*/ Value /*P*/ V, final StringRef /*&*/ Str,
                     long/*uint64_t*/ Offset/*= 0*/) {
  return getConstantStringInfo(V, Str,
                     Offset, true);
}
public static boolean getConstantStringInfo(/*const*/ Value /*P*/ V, final StringRef /*&*/ Str,
                     long/*uint64_t*/ Offset/*= 0*/, boolean TrimAtNul/*= true*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    getConstantStringInfo(V, Str,
                     Offset, TrimAtNul);
}


/// If we can compute the length of the string pointed to by the specified
/// pointer, return 'len+1'.  If we can't, return 0.
//<editor-fold defaultstate="collapsed" desc="llvm::GetStringLength">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 216,
 FQN="llvm::GetStringLength", NM="_ZN4llvm15GetStringLengthEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm15GetStringLengthEPNS_5ValueE")
//</editor-fold>
public static long/*uint64_t*/ GetStringLength(Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    GetStringLength(V);
}


/// This method strips off any GEP address adjustments and pointer casts from
/// the specified value, returning the original object being addressed. Note
/// that the returned value has pointer type if the specified value does. If
/// the MaxLookup value is non-zero, it limits the number of instructions to
/// be stripped off.
//<editor-fold defaultstate="collapsed" desc="llvm::GetUnderlyingObject">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 223,
 FQN="llvm::GetUnderlyingObject", NM="_ZN4llvm19GetUnderlyingObjectEPNS_5ValueERKNS_10DataLayoutEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm19GetUnderlyingObjectEPNS_5ValueERKNS_10DataLayoutEj")
//</editor-fold>
public static Value /*P*/ GetUnderlyingObject_Value$P_DataLayout$C_uint(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return GetUnderlyingObject_Value$P_DataLayout$C_uint(V, DL,
                                             6);
}
public static Value /*P*/ GetUnderlyingObject_Value$P_DataLayout$C_uint(Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                                             /*uint*/int MaxLookup/*= 6*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    GetUnderlyingObject_Value$P_DataLayout$C_uint(V, DL,
                                             MaxLookup);
}

//<editor-fold defaultstate="collapsed" desc="llvm::GetUnderlyingObject">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 225,
 FQN="llvm::GetUnderlyingObject", NM="_ZN4llvmL19GetUnderlyingObjectEPKNS_5ValueERKNS_10DataLayoutEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvmL19GetUnderlyingObjectEPKNS_5ValueERKNS_10DataLayoutEj")
//</editor-fold>
public static /*inline*/ /*const*/ Value /*P*/ GetUnderlyingObject_Value$C$P_DataLayout$C_uint(/*const*/ Value /*P*/ V,
                                               final /*const*/ DataLayout /*&*/ DL) {
  return GetUnderlyingObject_Value$C$P_DataLayout$C_uint(V,
                                               DL,
                                               6);
}
public static /*inline*/ /*const*/ Value /*P*/ GetUnderlyingObject_Value$C$P_DataLayout$C_uint(/*const*/ Value /*P*/ V,
                                               final /*const*/ DataLayout /*&*/ DL,
                                               /*uint*/int MaxLookup/*= 6*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    GetUnderlyingObject_Value$C$P_DataLayout$C_uint(V,
                                               DL,
                                               MaxLookup);
}


/// \brief This method is similar to GetUnderlyingObject except that it can
/// look through phi and select instructions and return multiple objects.
///
/// If LoopInfo is passed, loop phis are further analyzed.  If a pointer
/// accesses different objects in each iteration, we don't look through the
/// phi node. E.g. consider this loop nest:
///
///   int **A;
///   for (i)
///     for (j) {
///        A[i][j] = A[i-1][j] * B[j]
///     }
///
/// This is transformed by Load-PRE to stash away A[i] for the next iteration
/// of the outer loop:
///
///   Curr = A[0];          // Prev_0
///   for (i: 1..N) {
///     Prev = Curr;        // Prev = PHI (Prev_0, Curr)
///     Curr = A[i];
///     for (j: 0..N) {
///        Curr[j] = Prev[j] * B[j]
///     }
///   }
///
/// Since A[i] and A[i-1] are independent pointers, getUnderlyingObjects
/// should not assume that Curr and Prev share the same underlying object thus
/// it shouldn't look through the phi above.
//<editor-fold defaultstate="collapsed" desc="llvm::GetUnderlyingObjects">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 259,
 FQN="llvm::GetUnderlyingObjects", NM="_ZN4llvm20GetUnderlyingObjectsEPNS_5ValueERNS_15SmallVectorImplIS1_EERKNS_10DataLayoutEPNS_8LoopInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20GetUnderlyingObjectsEPNS_5ValueERNS_15SmallVectorImplIS1_EERKNS_10DataLayoutEPNS_8LoopInfoEj")
//</editor-fold>
public static void GetUnderlyingObjects(Value /*P*/ V, final SmallVectorImpl<Value /*P*/ > /*&*/ Objects,
                    final /*const*/ DataLayout /*&*/ DL) {
  GetUnderlyingObjects(V, Objects,
                    DL, (LoopInfo /*P*/ )null,
                    6);
}
public static void GetUnderlyingObjects(Value /*P*/ V, final SmallVectorImpl<Value /*P*/ > /*&*/ Objects,
                    final /*const*/ DataLayout /*&*/ DL, LoopInfo /*P*/ LI/*= null*/) {
  GetUnderlyingObjects(V, Objects,
                    DL, LI,
                    6);
}
public static void GetUnderlyingObjects(Value /*P*/ V, final SmallVectorImpl<Value /*P*/ > /*&*/ Objects,
                    final /*const*/ DataLayout /*&*/ DL, LoopInfo /*P*/ LI/*= null*/,
                    /*uint*/int MaxLookup/*= 6*/) {
  /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    GetUnderlyingObjects(V, Objects,
                    DL, LI,
                    MaxLookup);
}


/// Return true if the only users of this pointer are lifetime markers.
//<editor-fold defaultstate="collapsed" desc="llvm::onlyUsedByLifetimeMarkers">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 264,
 FQN="llvm::onlyUsedByLifetimeMarkers", NM="_ZN4llvm25onlyUsedByLifetimeMarkersEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm25onlyUsedByLifetimeMarkersEPKNS_5ValueE")
//</editor-fold>
public static boolean onlyUsedByLifetimeMarkers(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    onlyUsedByLifetimeMarkers(V);
}


/// Return true if the instruction does not have any effects besides
/// calculating the result and does not have undefined behavior.
///
/// This method never returns true for an instruction that returns true for
/// mayHaveSideEffects; however, this method also does some other checks in
/// addition. It checks for undefined behavior, like dividing by zero or
/// loading from an invalid pointer (but not for undefined results, like a
/// shift with a shift amount larger than the width of the result). It checks
/// for malloc and alloca because speculatively executing them might cause a
/// memory leak. It also returns false for instructions related to control
/// flow, specifically terminators and PHI nodes.
///
/// If the CtxI is specified this method performs context-sensitive analysis
/// and returns true if it is safe to execute the instruction immediately
/// before the CtxI.
///
/// If the CtxI is NOT specified this method only looks at the instruction
/// itself and its operands, so if this method returns true, it is safe to
/// move the instruction as long as the correct dominance relationships for
/// the operands and users hold.
///
/// This method can return true for instructions that read memory;
/// for such instructions, moving them may change the resulting value.
//<editor-fold defaultstate="collapsed" desc="llvm::isSafeToSpeculativelyExecute">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 289,
 FQN="llvm::isSafeToSpeculativelyExecute", NM="_ZN4llvm28isSafeToSpeculativelyExecuteEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm28isSafeToSpeculativelyExecuteEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isSafeToSpeculativelyExecute(/*const*/ Value /*P*/ V) {
  return isSafeToSpeculativelyExecute(V,
                            (/*const*/ Instruction /*P*/ )null,
                            (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToSpeculativelyExecute(/*const*/ Value /*P*/ V,
                            /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isSafeToSpeculativelyExecute(V,
                            CtxI,
                            (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToSpeculativelyExecute(/*const*/ Value /*P*/ V,
                            /*const*/ Instruction /*P*/ CtxI/*= null*/,
                            /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isSafeToSpeculativelyExecute(V,
                            CtxI,
                            DT);
}


/// Returns true if the result or effects of the given instructions \p I
/// depend on or influence global memory.
/// Memory dependence arises for example if the instruction reads from
/// memory or may produce effects or undefined behaviour. Memory dependent
/// instructions generally cannot be reorderd with respect to other memory
/// dependent instructions or moved into non-dominated basic blocks.
/// Instructions which just compute a value based on the values of their
/// operands are not memory dependent.
//<editor-fold defaultstate="collapsed" desc="llvm::mayBeMemoryDependent">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 301,
 FQN="llvm::mayBeMemoryDependent", NM="_ZN4llvm20mayBeMemoryDependentERKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20mayBeMemoryDependentERKNS_11InstructionE")
//</editor-fold>
public static boolean mayBeMemoryDependent(final /*const*/ Instruction /*&*/ I) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    mayBeMemoryDependent(I);
}


/// Return true if this pointer couldn't possibly be null by its definition.
/// This returns true for allocas, non-extern-weak globals, and byval
/// arguments.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonNull">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 306,
 FQN="llvm::isKnownNonNull", NM="_ZN4llvm14isKnownNonNullEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm14isKnownNonNullEPKNS_5ValueE")
//</editor-fold>
public static boolean isKnownNonNull(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNonNull(V);
}


/// Return true if this pointer couldn't possibly be null. If the context
/// instruction is specified, perform context-sensitive analysis and return
/// true if the pointer couldn't possibly be null at the specified
/// instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNonNullAt">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 312,
 FQN="llvm::isKnownNonNullAt", NM="_ZN4llvm16isKnownNonNullAtEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm16isKnownNonNullAtEPKNS_5ValueEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isKnownNonNullAt(/*const*/ Value /*P*/ V) {
  return isKnownNonNullAt(V,
                (/*const*/ Instruction /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNullAt(/*const*/ Value /*P*/ V,
                /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isKnownNonNullAt(V,
                CtxI,
                (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isKnownNonNullAt(/*const*/ Value /*P*/ V,
                /*const*/ Instruction /*P*/ CtxI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNonNullAt(V,
                CtxI,
                DT);
}


/// Return true if it is valid to use the assumptions provided by an
/// assume intrinsic, I, at the point in the control-flow identified by the
/// context instruction, CxtI.
//<editor-fold defaultstate="collapsed" desc="llvm::isValidAssumeForContext">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 319,
 FQN="llvm::isValidAssumeForContext", NM="_ZN4llvm23isValidAssumeForContextEPKNS_11InstructionES2_PKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm23isValidAssumeForContextEPKNS_11InstructionES2_PKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isValidAssumeForContext(/*const*/ Instruction /*P*/ I, /*const*/ Instruction /*P*/ CxtI) {
  return isValidAssumeForContext(I, CxtI,
                       (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isValidAssumeForContext(/*const*/ Instruction /*P*/ I, /*const*/ Instruction /*P*/ CxtI,
                       /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isValidAssumeForContext(I, CxtI,
                       DT);
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForUnsignedMul">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 323,
 FQN="llvm::computeOverflowForUnsignedMul", NM="_ZN4llvm29computeOverflowForUnsignedMulEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm29computeOverflowForUnsignedMulEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForUnsignedMul(Value /*P*/ LHS, Value /*P*/ RHS,
                             final /*const*/ DataLayout /*&*/ DL,
                             AssumptionCache /*P*/ AC,
                             /*const*/ Instruction /*P*/ CxtI,
                             /*const*/ DominatorTree /*P*/ DT) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    computeOverflowForUnsignedMul(LHS, RHS,
                             DL,
                             AC,
                             CxtI,
                             DT);
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForUnsignedAdd">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 328,
 FQN="llvm::computeOverflowForUnsignedAdd", NM="_ZN4llvm29computeOverflowForUnsignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm29computeOverflowForUnsignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForUnsignedAdd(Value /*P*/ LHS, Value /*P*/ RHS,
                             final /*const*/ DataLayout /*&*/ DL,
                             AssumptionCache /*P*/ AC,
                             /*const*/ Instruction /*P*/ CxtI,
                             /*const*/ DominatorTree /*P*/ DT) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    computeOverflowForUnsignedAdd(LHS, RHS,
                             DL,
                             AC,
                             CxtI,
                             DT);
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForSignedAdd">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 333,
 FQN="llvm::computeOverflowForSignedAdd", NM="_ZN4llvm27computeOverflowForSignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27computeOverflowForSignedAddEPNS_5ValueES1_RKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS,
                           final /*const*/ DataLayout /*&*/ DL) {
  return computeOverflowForSignedAdd(LHS, RHS,
                           DL,
                           (AssumptionCache /*P*/ )null,
                           (/*const*/ Instruction /*P*/ )null,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS,
                           final /*const*/ DataLayout /*&*/ DL,
                           AssumptionCache /*P*/ AC/*= null*/) {
  return computeOverflowForSignedAdd(LHS, RHS,
                           DL,
                           AC,
                           (/*const*/ Instruction /*P*/ )null,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS,
                           final /*const*/ DataLayout /*&*/ DL,
                           AssumptionCache /*P*/ AC/*= null*/,
                           /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return computeOverflowForSignedAdd(LHS, RHS,
                           DL,
                           AC,
                           CxtI,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(Value /*P*/ LHS, Value /*P*/ RHS,
                           final /*const*/ DataLayout /*&*/ DL,
                           AssumptionCache /*P*/ AC/*= null*/,
                           /*const*/ Instruction /*P*/ CxtI/*= null*/,
                           /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    computeOverflowForSignedAdd(LHS, RHS,
                           DL,
                           AC,
                           CxtI,
                           DT);
}

/// This version also leverages the sign bit of Add if known.
//<editor-fold defaultstate="collapsed" desc="llvm::computeOverflowForSignedAdd">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 339,
 FQN="llvm::computeOverflowForSignedAdd", NM="_ZN4llvm27computeOverflowForSignedAddEPNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm27computeOverflowForSignedAddEPNS_11AddOperatorERKNS_10DataLayoutEPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add,
                           final /*const*/ DataLayout /*&*/ DL) {
  return computeOverflowForSignedAdd(Add,
                           DL,
                           (AssumptionCache /*P*/ )null,
                           (/*const*/ Instruction /*P*/ )null,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add,
                           final /*const*/ DataLayout /*&*/ DL,
                           AssumptionCache /*P*/ AC/*= null*/) {
  return computeOverflowForSignedAdd(Add,
                           DL,
                           AC,
                           (/*const*/ Instruction /*P*/ )null,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add,
                           final /*const*/ DataLayout /*&*/ DL,
                           AssumptionCache /*P*/ AC/*= null*/,
                           /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return computeOverflowForSignedAdd(Add,
                           DL,
                           AC,
                           CxtI,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static OverflowResult computeOverflowForSignedAdd(AddOperator /*P*/ Add,
                           final /*const*/ DataLayout /*&*/ DL,
                           AssumptionCache /*P*/ AC/*= null*/,
                           /*const*/ Instruction /*P*/ CxtI/*= null*/,
                           /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    computeOverflowForSignedAdd(Add,
                           DL,
                           AC,
                           CxtI,
                           DT);
}


/// Returns true if the arithmetic part of the \p II 's result is
/// used only along the paths control dependent on the computation
/// not overflowing, \p II being an <op>.with.overflow intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::isOverflowIntrinsicNoWrap">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 348,
 FQN="llvm::isOverflowIntrinsicNoWrap", NM="_ZN4llvm25isOverflowIntrinsicNoWrapEPNS_13IntrinsicInstERNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm25isOverflowIntrinsicNoWrapEPNS_13IntrinsicInstERNS_13DominatorTreeE")
//</editor-fold>
public static boolean isOverflowIntrinsicNoWrap(IntrinsicInst /*P*/ II, final DominatorTree /*&*/ DT) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isOverflowIntrinsicNoWrap(II, DT);
}


/// Return true if this function can prove that the instruction I will
/// always transfer execution to one of its successors (including the next
/// instruction that follows within a basic block). E.g. this is not
/// guaranteed for function calls that could loop infinitely.
///
/// In other words, this function returns false for instructions that may
/// transfer execution or fail to transfer execution in a way that is not
/// captured in the CFG nor in the sequence of instructions within a basic
/// block.
///
/// Undefined behavior is assumed not to happen, so e.g. division is
/// guaranteed to transfer execution to the following instruction even
/// though division by zero might cause undefined behavior.
//<editor-fold defaultstate="collapsed" desc="llvm::isGuaranteedToTransferExecutionToSuccessor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 363,
 FQN="llvm::isGuaranteedToTransferExecutionToSuccessor", NM="_ZN4llvm42isGuaranteedToTransferExecutionToSuccessorEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm42isGuaranteedToTransferExecutionToSuccessorEPKNS_11InstructionE")
//</editor-fold>
public static boolean isGuaranteedToTransferExecutionToSuccessor(/*const*/ Instruction /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isGuaranteedToTransferExecutionToSuccessor(I);
}


/// Return true if this function can prove that the instruction I
/// is executed for every iteration of the loop L.
///
/// Note that this currently only considers the loop header.
//<editor-fold defaultstate="collapsed" desc="llvm::isGuaranteedToExecuteForEveryIteration">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 369,
 FQN="llvm::isGuaranteedToExecuteForEveryIteration", NM="_ZN4llvm38isGuaranteedToExecuteForEveryIterationEPKNS_11InstructionEPKNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm38isGuaranteedToExecuteForEveryIterationEPKNS_11InstructionEPKNS_4LoopE")
//</editor-fold>
public static boolean isGuaranteedToExecuteForEveryIteration(/*const*/ Instruction /*P*/ I,
                                      /*const*/ Loop /*P*/ L) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isGuaranteedToExecuteForEveryIteration(I,
                                      L);
}


/// Return true if this function can prove that I is guaranteed to yield
/// full-poison (all bits poison) if at least one of its operands are
/// full-poison (all bits poison).
///
/// The exact rules for how poison propagates through instructions have
/// not been settled as of 2015-07-10, so this function is conservative
/// and only considers poison to be propagated in uncontroversial
/// cases. There is no attempt to track values that may be only partially
/// poison.
//<editor-fold defaultstate="collapsed" desc="llvm::propagatesFullPoison">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 381,
 FQN="llvm::propagatesFullPoison", NM="_ZN4llvm20propagatesFullPoisonEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20propagatesFullPoisonEPKNS_11InstructionE")
//</editor-fold>
public static boolean propagatesFullPoison(/*const*/ Instruction /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    propagatesFullPoison(I);
}


/// Return either nullptr or an operand of I such that I will trigger
/// undefined behavior if I is executed and that operand has a full-poison
/// value (all bits poison).
//<editor-fold defaultstate="collapsed" desc="llvm::getGuaranteedNonFullPoisonOp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 386,
 FQN="llvm::getGuaranteedNonFullPoisonOp", NM="_ZN4llvm28getGuaranteedNonFullPoisonOpEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm28getGuaranteedNonFullPoisonOpEPKNS_11InstructionE")
//</editor-fold>
public static /*const*/ Value /*P*/ getGuaranteedNonFullPoisonOp(/*const*/ Instruction /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    getGuaranteedNonFullPoisonOp(I);
}


/// Return true if this function can prove that if PoisonI is executed
/// and yields a full-poison value (all bits poison), then that will
/// trigger undefined behavior.
///
/// Note that this currently only considers the basic block that is
/// the parent of I.
//<editor-fold defaultstate="collapsed" desc="llvm::isKnownNotFullPoison">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 394,
 FQN="llvm::isKnownNotFullPoison", NM="_ZN4llvm20isKnownNotFullPoisonEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm20isKnownNotFullPoisonEPKNS_11InstructionE")
//</editor-fold>
public static boolean isKnownNotFullPoison(/*const*/ Instruction /*P*/ PoisonI) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isKnownNotFullPoison(PoisonI);
}

/// Pattern match integer [SU]MIN, [SU]MAX and ABS idioms, returning the kind
/// and providing the out parameter results if we successfully match.
///
/// If CastOp is not nullptr, also match MIN/MAX idioms where the type does
/// not match that of the original select. If this is the case, the cast
/// operation (one of Trunc,SExt,Zext) that must be done to transform the
/// type of LHS and RHS into the type of V is returned in CastOp.
///
/// For example:
///   %1 = icmp slt i32 %a, i32 4
///   %2 = sext i32 %a to i64
///   %3 = select i1 %1, i64 %2, i64 4
///
/// -> LHS = %a, RHS = i32 4, *CastOp = Instruction::SExt
///
//<editor-fold defaultstate="collapsed" desc="llvm::matchSelectPattern">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 446,
 FQN="llvm::matchSelectPattern", NM="_ZN4llvm18matchSelectPatternEPNS_5ValueERS1_S2_PNS_11Instruction7CastOpsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18matchSelectPatternEPNS_5ValueERS1_S2_PNS_11Instruction7CastOpsE")
//</editor-fold>
public static SelectPatternResult matchSelectPattern(Value /*P*/ V, final type$ref<Value /*P*/ /*&*/> LHS, final type$ref<Value /*P*/ /*&*/> RHS) {
  return matchSelectPattern(V, LHS, RHS,
                  (Instruction.CastOps /*P*/ )null);
}
public static SelectPatternResult matchSelectPattern(Value /*P*/ V, final type$ref<Value /*P*/ /*&*/> LHS, final type$ref<Value /*P*/ /*&*/> RHS,
                  Instruction.CastOps /*P*/ CastOp/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    matchSelectPattern(V, LHS, RHS,
                  CastOp);
}


/// Parse out a conservative ConstantRange from !range metadata.
///
/// E.g. if RangeMD is !{i32 0, i32 10, i32 15, i32 20} then return [0, 20).
//<editor-fold defaultstate="collapsed" desc="llvm::getConstantRangeFromMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 452,
 FQN="llvm::getConstantRangeFromMetadata", NM="_ZN4llvm28getConstantRangeFromMetadataERNS_6MDNodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm28getConstantRangeFromMetadataERNS_6MDNodeE")
//</editor-fold>
public static ConstantRange getConstantRangeFromMetadata(final MDNode /*&*/ RangeMD) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    getConstantRangeFromMetadata(RangeMD);
}


/// Return true if RHS is known to be implied true by LHS.  Return false if
/// RHS is known to be implied false by LHS.  Otherwise, return None if no
/// implication can be made.
/// A & B must be i1 (boolean) values or a vector of such values. Note that
/// the truth table for implication is the same as <=u on i1 values (but not
/// <=s!).  The truth table for both is:
///    | T | F (B)
///  T | T | F
///  F | T | T
/// (A)
//<editor-fold defaultstate="collapsed" desc="llvm::isImpliedCondition">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ValueTracking.h", line = 464,
 FQN="llvm::isImpliedCondition", NM="_ZN4llvm18isImpliedConditionEPNS_5ValueES1_RKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm18isImpliedConditionEPNS_5ValueES1_RKNS_10DataLayoutEbjPNS_15AssumptionCacheEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return isImpliedCondition(LHS, RHS, DL, false,
                  0, (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/) {
  return isImpliedCondition(LHS, RHS, DL, InvertAPred,
                  0, (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/,
                  /*uint*/int Depth/*= 0*/) {
  return isImpliedCondition(LHS, RHS, DL, InvertAPred,
                  Depth, (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/,
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/) {
  return isImpliedCondition(LHS, RHS, DL, InvertAPred,
                  Depth, AC,
                  (/*const*/ Instruction /*P*/ )null, (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/,
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return isImpliedCondition(LHS, RHS, DL, InvertAPred,
                  Depth, AC,
                  CxtI, (/*const*/ DominatorTree /*P*/ )null);
}
public static OptionalBool isImpliedCondition(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL, boolean InvertAPred/*= false*/,
                  /*uint*/int Depth/*= 0*/, AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/, /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ValueTrackingLlvmGlobals.
    isImpliedCondition(LHS, RHS, DL, InvertAPred,
                  Depth, AC,
                  CxtI, DT);
}


/// Create a wrapper of the above for the legacy pass manager.
//<editor-fold defaultstate="collapsed" desc="llvm::createAAEvalPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 389,
 FQN="llvm::createAAEvalPass", NM="_ZN4llvm16createAAEvalPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm16createAAEvalPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createAAEvalPass() {
  return /*delegate*/org.llvm.analysis.impl.AliasAnalysisEvaluatorLlvmGlobals.
    createAAEvalPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 286,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_8AliasSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_8AliasSetE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_AliasSet$C(final raw_ostream /*&*/ OS, final /*const*/ AliasSet /*&*/ AS) {
  return /*delegate*/org.llvm.analysis.impl.AliasSetTrackerLlvmGlobals.
    $out_raw_ostream_AliasSet$C(OS, AS);
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/AliasSetTracker.h", line = 440,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKNS_15AliasSetTrackerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKNS_15AliasSetTrackerE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_AliasSetTracker$C(final raw_ostream /*&*/ OS, final /*const*/ AliasSetTracker /*&*/ AST) {
  return /*delegate*/org.llvm.analysis.impl.AliasSetTrackerLlvmGlobals.
    $out_raw_ostream_AliasSetTracker$C(OS, AST);
}


/// \brief Create an analysis pass wrapper around a TTI object.
///
/// This analysis pass just holds the TTI instance and makes it available to
/// clients.
//<editor-fold defaultstate="collapsed" desc="llvm::createTargetTransformInfoWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/TargetTransformInfo.h", line = 1078,
 FQN="llvm::createTargetTransformInfoWrapperPass", NM="_ZN4llvm36createTargetTransformInfoWrapperPassENS_16TargetIRAnalysisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm36createTargetTransformInfoWrapperPassENS_16TargetIRAnalysisE")
//</editor-fold>
public static ImmutablePass /*P*/ createTargetTransformInfoWrapperPass(TargetIRAnalysis TIRA) {
  return /*delegate*/org.llvm.analysis.target.impl.TargetTransformInfoLlvmGlobals.
    createTargetTransformInfoWrapperPass(TIRA);
}


//===--------------------------------------------------------------------===//
//
// createModuleSummaryIndexWrapperPass - This pass builds a ModuleSummaryIndex
// object for the module, to be written to bitcode or LLVM assembly.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createModuleSummaryIndexWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ModuleSummaryAnalysis.h", line = 83,
 FQN="llvm::createModuleSummaryIndexWrapperPass", NM="_ZN4llvm35createModuleSummaryIndexWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm35createModuleSummaryIndexWrapperPassEv")
//</editor-fold>
public static ModulePass /*P*/ createModuleSummaryIndexWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.ModuleSummaryAnalysisLlvmGlobals.
    createModuleSummaryIndexWrapperPass();
}


/// Returns true if \p M is eligible for ThinLTO promotion.
///
/// Currently we check if it has any any InlineASM that uses an internal symbol.
//<editor-fold defaultstate="collapsed" desc="llvm::moduleCanBeRenamedForThinLTO">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ModuleSummaryAnalysis.h", line = 88,
 FQN="llvm::moduleCanBeRenamedForThinLTO", NM="_ZN4llvm28moduleCanBeRenamedForThinLTOERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Bitcode/Writer/BitcodeWriterPass.cpp -nm=_ZN4llvm28moduleCanBeRenamedForThinLTOERKNS_6ModuleE")
//</editor-fold>
public static boolean moduleCanBeRenamedForThinLTO(final /*const*/ Module /*&*/ M) {
  return /*delegate*/org.llvm.analysis.impl.ModuleSummaryAnalysisLlvmGlobals.
    moduleCanBeRenamedForThinLTO(M);
}


// A helper function that converts a branch probability into weight.
//<editor-fold defaultstate="collapsed" desc="llvm::getWeightFromBranchProb">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/BlockFrequencyInfoImpl.h", line = 1189,
 FQN="llvm::getWeightFromBranchProb", NM="_ZN4llvm23getWeightFromBranchProbENS_17BranchProbabilityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm23getWeightFromBranchProbENS_17BranchProbabilityE")
//</editor-fold>
public static /*inline*/ /*uint32_t*/int getWeightFromBranchProb(/*const*/ BranchProbability Prob) {
  return /*delegate*/org.llvm.analysis.impl.BlockFrequencyInfoImplLlvmGlobals.
    getWeightFromBranchProb(Prob);
}


//===--------------------------------------------------------------------===//
//
// createObjCARCAAWrapperPass - This pass implements ObjC-ARC-based
// alias analysis.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createObjCARCAAWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 31,
 FQN="llvm::createObjCARCAAWrapperPass", NM="_ZN4llvm26createObjCARCAAWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm26createObjCARCAAWrapperPassEv")
//</editor-fold>
public static ImmutablePass /*P*/ createObjCARCAAWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.ObjCARCAliasAnalysisLlvmGlobals.
    createObjCARCAAWrapperPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPAEvalPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 33,
 FQN="llvm::createPAEvalPass", NM="_ZN4llvm16createPAEvalPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm16createPAEvalPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPAEvalPass() {
  return /*delegate*/org.llvm.analysis.impl.PassesLlvmGlobals.
    createPAEvalPass();
}


//===--------------------------------------------------------------------===//
//
/// createLazyValueInfoPass - This creates an instance of the LazyValueInfo
/// pass.
//<editor-fold defaultstate="collapsed" desc="llvm::createLazyValueInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 39,
 FQN="llvm::createLazyValueInfoPass", NM="_ZN4llvm23createLazyValueInfoPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm23createLazyValueInfoPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLazyValueInfoPass() {
  return /*delegate*/org.llvm.analysis.impl.LazyValueInfoLlvmGlobals.
    createLazyValueInfoPass();
}


//===--------------------------------------------------------------------===//
//
// createDependenceAnalysisWrapperPass - This creates an instance of the
// DependenceAnalysisWrapper pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDependenceAnalysisWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 46,
 FQN="llvm::createDependenceAnalysisWrapperPass", NM="_ZN4llvm35createDependenceAnalysisWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm35createDependenceAnalysisWrapperPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDependenceAnalysisWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.DependenceAnalysisLlvmGlobals.
    createDependenceAnalysisWrapperPass();
}


//===--------------------------------------------------------------------===//
//
// createCostModelAnalysisPass - This creates an instance of the
// CostModelAnalysis pass.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createCostModelAnalysisPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 53,
 FQN="llvm::createCostModelAnalysisPass", NM="_ZN4llvm27createCostModelAnalysisPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm27createCostModelAnalysisPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createCostModelAnalysisPass() {
  return /*delegate*/org.llvm.analysis.impl.CostModelLlvmGlobals.
    createCostModelAnalysisPass();
}


//===--------------------------------------------------------------------===//
//
// createDelinearizationPass - This pass implements attempts to restore
// multidimensional array indices from linearized expressions.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDelinearizationPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 60,
 FQN="llvm::createDelinearizationPass", NM="_ZN4llvm25createDelinearizationPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm25createDelinearizationPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDelinearizationPass() {
  return /*delegate*/org.llvm.analysis.impl.DelinearizationLlvmGlobals.
    createDelinearizationPass();
}


//===--------------------------------------------------------------------===//
//
// createDivergenceAnalysisPass - This pass determines which branches in a GPU
// program are divergent.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createDivergenceAnalysisPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 67,
 FQN="llvm::createDivergenceAnalysisPass", NM="_ZN4llvm28createDivergenceAnalysisPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm28createDivergenceAnalysisPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDivergenceAnalysisPass() {
  return /*delegate*/org.llvm.analysis.impl.DivergenceAnalysisLlvmGlobals.
    createDivergenceAnalysisPass();
}


//===--------------------------------------------------------------------===//
//
// Minor pass prototypes, allowing us to expose them through bugpoint and
// analyze.
//<editor-fold defaultstate="collapsed" desc="llvm::createInstCountPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 73,
 FQN="llvm::createInstCountPass", NM="_ZN4llvm19createInstCountPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm19createInstCountPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createInstCountPass() {
  return /*delegate*/org.llvm.analysis.impl.InstCountLlvmGlobals.
    createInstCountPass();
}


//===--------------------------------------------------------------------===//
//
// createRegionInfoPass - This pass finds all single entry single exit regions
// in a function and builds the region hierarchy.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createRegionInfoPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 80,
 FQN="llvm::createRegionInfoPass", NM="_ZN4llvm20createRegionInfoPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm20createRegionInfoPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createRegionInfoPass() {
  return /*delegate*/org.llvm.analysis.impl.RegionInfoLlvmGlobals.
    createRegionInfoPass();
}


// Print module-level debug info metadata in human-readable form.
//<editor-fold defaultstate="collapsed" desc="llvm::createModuleDebugInfoPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 83,
 FQN="llvm::createModuleDebugInfoPrinterPass", NM="_ZN4llvm32createModuleDebugInfoPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm32createModuleDebugInfoPrinterPassEv")
//</editor-fold>
public static ModulePass /*P*/ createModuleDebugInfoPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.ModuleDebugInfoPrinterLlvmGlobals.
    createModuleDebugInfoPrinterPass();
}


//===--------------------------------------------------------------------===//
//
// createMemDepPrinter - This pass exhaustively collects all memdep
// information and prints it with -analyze.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createMemDepPrinter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 90,
 FQN="llvm::createMemDepPrinter", NM="_ZN4llvm19createMemDepPrinterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm19createMemDepPrinterEv")
//</editor-fold>
public static FunctionPass /*P*/ createMemDepPrinter() {
  return /*delegate*/org.llvm.analysis.impl.MemDepPrinterLlvmGlobals.
    createMemDepPrinter();
}


//===--------------------------------------------------------------------===//
//
// createMemDerefPrinter - This pass collects memory dereferenceability
// information and prints it with -analyze.
//
//<editor-fold defaultstate="collapsed" desc="llvm::createMemDerefPrinter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Passes.h", line = 97,
 FQN="llvm::createMemDerefPrinter", NM="_ZN4llvm21createMemDerefPrinterEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm21createMemDerefPrinterEv")
//</editor-fold>
public static FunctionPass /*P*/ createMemDerefPrinter() {
  return /*delegate*/org.llvm.analysis.impl.MemDerefPrinterLlvmGlobals.
    createMemDerefPrinter();
}


/// If this constant is a constant offset from a global, return the global and
/// the constant. Because of constantexprs, this function is recursive.
//<editor-fold defaultstate="collapsed" desc="llvm::IsConstantOffsetFromGlobal">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 37,
 FQN="llvm::IsConstantOffsetFromGlobal", NM="_ZN4llvm26IsConstantOffsetFromGlobalEPNS_8ConstantERPNS_11GlobalValueERNS_5APIntERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm26IsConstantOffsetFromGlobalEPNS_8ConstantERPNS_11GlobalValueERNS_5APIntERKNS_10DataLayoutE")
//</editor-fold>
public static boolean IsConstantOffsetFromGlobal(Constant /*P*/ C, final type$ref<GlobalValue /*P*/ /*&*/> GV, final APInt /*&*/ Offset,
                          final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    IsConstantOffsetFromGlobal(C, GV, Offset,
                          DL);
}


/// ConstantFoldInstruction - Try to constant fold the specified instruction.
/// If successful, the constant result is returned, if not, null is returned.
/// Note that this fails if not all of the operands are constant.  Otherwise,
/// this function can only fail when attempting to fold instructions like loads
/// and stores, which have no constant expression form.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInstruction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 45,
 FQN="llvm::ConstantFoldInstruction", NM="_ZN4llvm23ConstantFoldInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm23ConstantFoldInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldInstruction(I, DL,
                       (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL,
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldInstruction(I, DL,
                       TLI);
}


/// ConstantFoldConstantExpression - Attempt to fold the constant expression
/// using the specified DataLayout.  If successful, the constant result is
/// result is returned, if not, null is returned.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldConstantExpression">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 51,
 FQN="llvm::ConstantFoldConstantExpression", NM="_ZN4llvm30ConstantFoldConstantExpressionEPKNS_12ConstantExprERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm30ConstantFoldConstantExpressionEPKNS_12ConstantExprERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldConstantExpression(/*const*/ ConstantExpr /*P*/ CE, final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldConstantExpression(CE, DL,
                              (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldConstantExpression(/*const*/ ConstantExpr /*P*/ CE, final /*const*/ DataLayout /*&*/ DL,
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldConstantExpression(CE, DL,
                              TLI);
}


/// ConstantFoldInstOperands - Attempt to constant fold an instruction with the
/// specified operands.  If successful, the constant result is returned, if not,
/// null is returned.  Note that this function can fail when attempting to
/// fold instructions like loads and stores, which have no constant expression
/// form.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInstOperands">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 61,
 FQN="llvm::ConstantFoldInstOperands", NM="_ZN4llvm24ConstantFoldInstOperandsEPNS_11InstructionENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm24ConstantFoldInstOperandsEPNS_11InstructionENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstOperands(Instruction /*P*/ I, ArrayRef<Constant /*P*/ > Ops,
                        final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldInstOperands(I, Ops,
                        DL,
                        (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldInstOperands(Instruction /*P*/ I, ArrayRef<Constant /*P*/ > Ops,
                        final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldInstOperands(I, Ops,
                        DL,
                        TLI);
}


/// ConstantFoldInstOperands - Attempt to constant fold an instruction with the
/// specified operands.  If successful, the constant result is returned, if not,
/// null is returned.  Note that this function can fail when attempting to
/// fold instructions like loads and stores, which have no constant expression
/// form.
///
/// This function doesn't work for compares (use ConstantFoldCompareInstOperands
/// for this) and GEPs.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldInstOperands">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 73,
 FQN="llvm::ConstantFoldInstOperands", NM="_ZN4llvm24ConstantFoldInstOperandsEjPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm24ConstantFoldInstOperandsEjPNS_4TypeENS_8ArrayRefIPNS_8ConstantEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldInstOperands(/*uint*/int Opcode, Type /*P*/ DestTy,
                        ArrayRef<Constant /*P*/ > Ops,
                        final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldInstOperands(Opcode, DestTy,
                        Ops,
                        DL,
                        (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldInstOperands(/*uint*/int Opcode, Type /*P*/ DestTy,
                        ArrayRef<Constant /*P*/ > Ops,
                        final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldInstOperands(Opcode, DestTy,
                        Ops,
                        DL,
                        TLI);
}


/// ConstantFoldCompareInstOperands - Attempt to constant fold a compare
/// instruction (icmp/fcmp) with the specified operands.  If it fails, it
/// returns a constant expression of the specified operands.
///
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCompareInstOperands">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 82,
 FQN="llvm::ConstantFoldCompareInstOperands", NM="_ZN4llvm31ConstantFoldCompareInstOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm31ConstantFoldCompareInstOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCompareInstOperands(/*uint*/int Predicate, Constant /*P*/ LHS,
                               Constant /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return ConstantFoldCompareInstOperands(Predicate, LHS,
                               RHS, DL,
                               (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldCompareInstOperands(/*uint*/int Predicate, Constant /*P*/ LHS,
                               Constant /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldCompareInstOperands(Predicate, LHS,
                               RHS, DL,
                               TLI);
}


/// \brief Attempt to constant fold a binary operation with the specified
/// operands.  If it fails, it returns a constant expression of the specified
/// operands.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldBinaryOpOperands">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 90,
 FQN="llvm::ConstantFoldBinaryOpOperands", NM="_ZN4llvm28ConstantFoldBinaryOpOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm28ConstantFoldBinaryOpOperandsEjPNS_8ConstantES1_RKNS_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldBinaryOpOperands(/*uint*/int Opcode, Constant /*P*/ LHS,
                            Constant /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldBinaryOpOperands(Opcode, LHS,
                            RHS, DL);
}


/// \brief Attempt to constant fold a cast with the specified operand.  If it
/// fails, it returns a constant expression of the specified operand.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCastOperand">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 95,
 FQN="llvm::ConstantFoldCastOperand", NM="_ZN4llvm23ConstantFoldCastOperandEjPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm23ConstantFoldCastOperandEjPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCastOperand(/*uint*/int Opcode, Constant /*P*/ C, Type /*P*/ DestTy,
                       final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldCastOperand(Opcode, C, DestTy,
                       DL);
}


/// ConstantFoldLoadFromConstPtr - Return the value that a load from C would
/// produce if it is constant and determinable.  If this is not determinable,
/// return null.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldLoadFromConstPtr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 118,
 FQN="llvm::ConstantFoldLoadFromConstPtr", NM="_ZN4llvm28ConstantFoldLoadFromConstPtrEPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm28ConstantFoldLoadFromConstPtrEPNS_8ConstantEPNS_4TypeERKNS_10DataLayoutE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadFromConstPtr(Constant /*P*/ C, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldLoadFromConstPtr(C, Ty, DL);
}


/// ConstantFoldLoadThroughGEPConstantExpr - Given a constant and a
/// getelementptr constantexpr, return the constant value being addressed by the
/// constant expression, or null if something is funny and we can't decide.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldLoadThroughGEPConstantExpr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 123,
 FQN="llvm::ConstantFoldLoadThroughGEPConstantExpr", NM="_ZN4llvm38ConstantFoldLoadThroughGEPConstantExprEPNS_8ConstantEPNS_12ConstantExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm38ConstantFoldLoadThroughGEPConstantExprEPNS_8ConstantEPNS_12ConstantExprE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadThroughGEPConstantExpr(Constant /*P*/ C, ConstantExpr /*P*/ CE) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldLoadThroughGEPConstantExpr(C, CE);
}


/// ConstantFoldLoadThroughGEPIndices - Given a constant and getelementptr
/// indices (with an *implied* zero pointer index that is not in the list),
/// return the constant value being addressed by a virtual load, or null if
/// something is funny and we can't decide.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldLoadThroughGEPIndices">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 129,
 FQN="llvm::ConstantFoldLoadThroughGEPIndices", NM="_ZN4llvm33ConstantFoldLoadThroughGEPIndicesEPNS_8ConstantENS_8ArrayRefIS1_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm33ConstantFoldLoadThroughGEPIndicesEPNS_8ConstantENS_8ArrayRefIS1_EE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldLoadThroughGEPIndices(Constant /*P*/ C,
                                 ArrayRef<Constant /*P*/ > Indices) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldLoadThroughGEPIndices(C,
                                 Indices);
}


/// canConstantFoldCallTo - Return true if its even possible to fold a call to
/// the specified function.
//<editor-fold defaultstate="collapsed" desc="llvm::canConstantFoldCallTo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 134,
 FQN="llvm::canConstantFoldCallTo", NM="_ZN4llvm21canConstantFoldCallToEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm21canConstantFoldCallToEPKNS_8FunctionE")
//</editor-fold>
public static boolean canConstantFoldCallTo(/*const*/ Function /*P*/ F) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    canConstantFoldCallTo(F);
}


/// ConstantFoldCall - Attempt to constant fold a call to the specified function
/// with the specified arguments, returning null if unsuccessful.
//<editor-fold defaultstate="collapsed" desc="llvm::ConstantFoldCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ConstantFolding.h", line = 138,
 FQN="llvm::ConstantFoldCall", NM="_ZN4llvm16ConstantFoldCallEPNS_8FunctionENS_8ArrayRefIPNS_8ConstantEEEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm16ConstantFoldCallEPNS_8FunctionENS_8ArrayRefIPNS_8ConstantEEEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Constant /*P*/ ConstantFoldCall(Function /*P*/ F, ArrayRef<Constant /*P*/ > Operands) {
  return ConstantFoldCall(F, Operands,
                (/*const*/ TargetLibraryInfo /*P*/ )null);
}
public static Constant /*P*/ ConstantFoldCall(Function /*P*/ F, ArrayRef<Constant /*P*/ > Operands,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.ConstantFoldingLlvmGlobals.
    ConstantFoldCall(F, Operands,
                TLI);
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates or reallocates memory (either malloc, calloc, realloc, or strdup
/// like).
//<editor-fold defaultstate="collapsed" desc="llvm::isAllocationFn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 44,
 FQN="llvm::isAllocationFn", NM="_ZN4llvm14isAllocationFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm14isAllocationFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isAllocationFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isAllocationFn(V, TLI,
              false);
}
public static boolean isAllocationFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
              boolean LookThroughBitCast/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isAllocationFn(V, TLI,
              LookThroughBitCast);
}


/// \brief Tests if a value is a call or invoke to a function that returns a
/// NoAlias pointer (including malloc/calloc/realloc/strdup-like functions).
//<editor-fold defaultstate="collapsed" desc="llvm::isNoAliasFn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 49,
 FQN="llvm::isNoAliasFn", NM="_ZN4llvm11isNoAliasFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm11isNoAliasFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isNoAliasFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isNoAliasFn(V, TLI,
           false);
}
public static boolean isNoAliasFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
           boolean LookThroughBitCast/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isNoAliasFn(V, TLI,
           LookThroughBitCast);
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates uninitialized memory (such as malloc).
//<editor-fold defaultstate="collapsed" desc="llvm::isMallocLikeFn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 54,
 FQN="llvm::isMallocLikeFn", NM="_ZN4llvm14isMallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm14isMallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isMallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isMallocLikeFn(V, TLI,
              false);
}
public static boolean isMallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
              boolean LookThroughBitCast/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isMallocLikeFn(V, TLI,
              LookThroughBitCast);
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates zero-filled memory (such as calloc).
//<editor-fold defaultstate="collapsed" desc="llvm::isCallocLikeFn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 59,
 FQN="llvm::isCallocLikeFn", NM="_ZN4llvm14isCallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm14isCallocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isCallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isCallocLikeFn(V, TLI,
              false);
}
public static boolean isCallocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
              boolean LookThroughBitCast/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isCallocLikeFn(V, TLI,
              LookThroughBitCast);
}


/// \brief Tests if a value is a call or invoke to a library function that
/// allocates memory (either malloc, calloc, or strdup like).
//<editor-fold defaultstate="collapsed" desc="llvm::isAllocLikeFn">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 64,
 FQN="llvm::isAllocLikeFn", NM="_ZN4llvm13isAllocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm13isAllocLikeFnEPKNS_5ValueEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static boolean isAllocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return isAllocLikeFn(V, TLI,
             false);
}
public static boolean isAllocLikeFn(/*const*/ Value /*P*/ V, /*const*/ TargetLibraryInfo /*P*/ TLI,
             boolean LookThroughBitCast/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isAllocLikeFn(V, TLI,
             LookThroughBitCast);
}


//===----------------------------------------------------------------------===//
//  malloc Call Utility Functions.
//

/// extractMallocCall - Returns the corresponding CallInst if the instruction
/// is a malloc call.  Since CallInst::CreateMalloc() only creates calls, we
/// ignore InvokeInst here.
//<editor-fold defaultstate="collapsed" desc="llvm::extractMallocCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 74,
 FQN="llvm::extractMallocCall", NM="_ZN4llvm17extractMallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17extractMallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*const*/ CallInst /*P*/ extractMallocCall_Value$C$P_TargetLibraryInfo$C$P(/*const*/ Value /*P*/ I, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    extractMallocCall_Value$C$P_TargetLibraryInfo$C$P(I, TLI);
}

//<editor-fold defaultstate="collapsed" desc="llvm::extractMallocCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 75,
 FQN="llvm::extractMallocCall", NM="_ZN4llvmL17extractMallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvmL17extractMallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*inline*/ CallInst /*P*/ extractMallocCall_Value$P_TargetLibraryInfo$C$P(Value /*P*/ I,
                                               /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    extractMallocCall_Value$P_TargetLibraryInfo$C$P(I,
                                               TLI);
}


/// getMallocType - Returns the PointerType resulting from the malloc call.
/// The PointerType depends on the number of bitcast uses of the malloc call:
///   0: PointerType is the malloc calls' return type.
///   1: PointerType is the bitcast's result type.
///  >1: Unique PointerType cannot be determined, return NULL.
//<editor-fold defaultstate="collapsed" desc="llvm::getMallocType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 85,
 FQN="llvm::getMallocType", NM="_ZN4llvm13getMallocTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm13getMallocTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static PointerType /*P*/ getMallocType(/*const*/ CallInst /*P*/ CI, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    getMallocType(CI, TLI);
}


/// getMallocAllocatedType - Returns the Type allocated by malloc call.
/// The Type depends on the number of bitcast uses of the malloc call:
///   0: PointerType is the malloc calls' return type.
///   1: PointerType is the bitcast's result type.
///  >1: Unique PointerType cannot be determined, return NULL.
//<editor-fold defaultstate="collapsed" desc="llvm::getMallocAllocatedType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 92,
 FQN="llvm::getMallocAllocatedType", NM="_ZN4llvm22getMallocAllocatedTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm22getMallocAllocatedTypeEPKNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static Type /*P*/ getMallocAllocatedType(/*const*/ CallInst /*P*/ CI, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    getMallocAllocatedType(CI, TLI);
}


/// getMallocArraySize - Returns the array size of a malloc call.  If the
/// argument passed to malloc is a multiple of the size of the malloced type,
/// then return that multiple.  For non-array mallocs, the multiple is
/// constant 1.  Otherwise, return NULL for mallocs whose array size cannot be
/// determined.
//<editor-fold defaultstate="collapsed" desc="llvm::getMallocArraySize">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 99,
 FQN="llvm::getMallocArraySize", NM="_ZN4llvm18getMallocArraySizeEPNS_8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm18getMallocArraySizeEPNS_8CallInstERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEb")
//</editor-fold>
public static Value /*P*/ getMallocArraySize(CallInst /*P*/ CI, final /*const*/ DataLayout /*&*/ DL,
                  /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return getMallocArraySize(CI, DL,
                  TLI,
                  false);
}
public static Value /*P*/ getMallocArraySize(CallInst /*P*/ CI, final /*const*/ DataLayout /*&*/ DL,
                  /*const*/ TargetLibraryInfo /*P*/ TLI,
                  boolean LookThroughSExt/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    getMallocArraySize(CI, DL,
                  TLI,
                  LookThroughSExt);
}


//===----------------------------------------------------------------------===//
//  calloc Call Utility Functions.
//

/// extractCallocCall - Returns the corresponding CallInst if the instruction
/// is a calloc call.
//<editor-fold defaultstate="collapsed" desc="llvm::extractCallocCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 109,
 FQN="llvm::extractCallocCall", NM="_ZN4llvm17extractCallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm17extractCallocCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*const*/ CallInst /*P*/ extractCallocCall_Value$C$P_TargetLibraryInfo$C$P(/*const*/ Value /*P*/ I, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    extractCallocCall_Value$C$P_TargetLibraryInfo$C$P(I, TLI);
}

//<editor-fold defaultstate="collapsed" desc="llvm::extractCallocCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 110,
 FQN="llvm::extractCallocCall", NM="_ZN4llvmL17extractCallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvmL17extractCallocCallEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*inline*/ CallInst /*P*/ extractCallocCall_Value$P_TargetLibraryInfo$C$P(Value /*P*/ I,
                                               /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    extractCallocCall_Value$P_TargetLibraryInfo$C$P(I,
                                               TLI);
}


//===----------------------------------------------------------------------===//
//  free Call Utility Functions.
//

/// isFreeCall - Returns non-null if the value is a call to the builtin free()
//<editor-fold defaultstate="collapsed" desc="llvm::isFreeCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 121,
 FQN="llvm::isFreeCall", NM="_ZN4llvm10isFreeCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm10isFreeCallEPKNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*const*/ CallInst /*P*/ isFreeCall_Value$C$P_TargetLibraryInfo$C$P(/*const*/ Value /*P*/ I, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isFreeCall_Value$C$P_TargetLibraryInfo$C$P(I, TLI);
}

//<editor-fold defaultstate="collapsed" desc="llvm::isFreeCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 123,
 FQN="llvm::isFreeCall", NM="_ZN4llvmL10isFreeCallEPNS_5ValueEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvmL10isFreeCallEPNS_5ValueEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*inline*/ CallInst /*P*/ isFreeCall_Value$P_TargetLibraryInfo$C$P(Value /*P*/ I, /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    isFreeCall_Value$P_TargetLibraryInfo$C$P(I, TLI);
}


//===----------------------------------------------------------------------===//
//  Utility functions to compute size of objects.
//

/// \brief Compute the size of the object pointed by Ptr. Returns true and the
/// object size in Size if successful, and false otherwise. In this context, by
/// object we mean the region of memory starting at Ptr to the end of the
/// underlying object pointed to by Ptr.
/// If RoundToAlign is true, then Size is rounded up to the aligment of allocas,
/// byval arguments, and global variables.
/// If Mode is Min or Max the size will be evaluated even if it depends on
/// a condition and corresponding value will be returned (min or max).
//<editor-fold defaultstate="collapsed" desc="llvm::getObjectSize">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/MemoryBuiltins.h", line = 140,
 FQN="llvm::getObjectSize", NM="_ZN4llvm13getObjectSizeEPKNS_5ValueERyRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEbNS_11ObjSizeModeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm13getObjectSizeEPKNS_5ValueERyRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEbNS_11ObjSizeModeE")
//</editor-fold>
public static boolean getObjectSize(/*const*/ Value /*P*/ Ptr, final ulong$ref/*uint64_t &*/ Size, final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return getObjectSize(Ptr, Size, DL,
             TLI, false,
             ObjSizeMode.Exact);
}
public static boolean getObjectSize(/*const*/ Value /*P*/ Ptr, final ulong$ref/*uint64_t &*/ Size, final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI, boolean RoundToAlign/*= false*/) {
  return getObjectSize(Ptr, Size, DL,
             TLI, RoundToAlign,
             ObjSizeMode.Exact);
}
public static boolean getObjectSize(/*const*/ Value /*P*/ Ptr, final ulong$ref/*uint64_t &*/ Size, final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI, boolean RoundToAlign/*= false*/,
             ObjSizeMode Mode/*= ObjSizeMode::Exact*/) {
  return /*delegate*/org.llvm.analysis.impl.MemoryBuiltinsLlvmGlobals.
    getObjectSize(Ptr, Size, DL,
             TLI, RoundToAlign,
             Mode);
}


/// \brief A function to deduce a function pass type and wrap it in the
/// templated adaptor.
/*template <typename CGSCCPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::createModuleToPostOrderCGSCCPassAdaptor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 140,
 FQN="llvm::createModuleToPostOrderCGSCCPassAdaptor", NM="Tpl__ZN4llvm39createModuleToPostOrderCGSCCPassAdaptorET_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=Tpl__ZN4llvm39createModuleToPostOrderCGSCCPassAdaptorET_b")
//</editor-fold>
public static </*typename*/ CGSCCPassT> ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> createModuleToPostOrderCGSCCPassAdaptor(CGSCCPassT Pass) {
  return createModuleToPostOrderCGSCCPassAdaptor(Pass, false);
}
public static </*typename*/ CGSCCPassT> ModuleToPostOrderCGSCCPassAdaptor<CGSCCPassT> createModuleToPostOrderCGSCCPassAdaptor(CGSCCPassT Pass, boolean DebugLogging/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.CGSCCPassManagerLlvmGlobals.
    createModuleToPostOrderCGSCCPassAdaptor(Pass, DebugLogging);
}


/// \brief A function to deduce a function pass type and wrap it in the
/// templated adaptor.
/*template <typename FunctionPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::createCGSCCToFunctionPassAdaptor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CGSCCPassManager.h", line = 230,
 FQN="llvm::createCGSCCToFunctionPassAdaptor", NM="Tpl__ZN4llvm32createCGSCCToFunctionPassAdaptorET_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CGSCCPassManager.cpp -nm=Tpl__ZN4llvm32createCGSCCToFunctionPassAdaptorET_b")
//</editor-fold>
public static </*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>> CGSCCToFunctionPassAdaptor<FunctionPassT> createCGSCCToFunctionPassAdaptor(FunctionPassT Pass) {
  return createCGSCCToFunctionPassAdaptor(Pass, false);
}
public static </*typename*/ FunctionPassT extends IPassFunction<PreservedAnalyses>> CGSCCToFunctionPassAdaptor<FunctionPassT> createCGSCCToFunctionPassAdaptor(FunctionPassT Pass, boolean DebugLogging/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.CGSCCPassManagerLlvmGlobals.
    createCGSCCToFunctionPassAdaptor(Pass, DebugLogging);
}


// Create methods available outside of this file, to use them
// "include/llvm/LinkAllPasses.h". Otherwise the pass would be deleted by
// the link time optimization.
//<editor-fold defaultstate="collapsed" desc="llvm::createCallGraphViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 88,
 FQN="llvm::createCallGraphViewerPass", NM="_ZN4llvm25createCallGraphViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm25createCallGraphViewerPassEv")
//</editor-fold>
public static ModulePass /*P*/ createCallGraphViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.CallPrinterLlvmGlobals.
    createCallGraphViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createCallGraphDOTPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 90,
 FQN="llvm::createCallGraphDOTPrinterPass", NM="_ZN4llvm29createCallGraphDOTPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm29createCallGraphDOTPrinterPassEv")
//</editor-fold>
public static ModulePass /*P*/ createCallGraphDOTPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.CallPrinterLlvmGlobals.
    createCallGraphDOTPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createCFGPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 126,
 FQN="llvm::createCFGPrinterPass", NM="_ZN4llvm20createCFGPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm20createCFGPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createCFGPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.CFGPrinterLlvmGlobals.
    createCFGPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createCFGOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CFGPrinter.h", line = 127,
 FQN="llvm::createCFGOnlyPrinterPass", NM="_ZN4llvm24createCFGOnlyPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm24createCFGOnlyPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createCFGOnlyPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.CFGPrinterLlvmGlobals.
    createCFGOnlyPrinterPass();
}


// Create methods available outside of this file, to use them
// "include/llvm/LinkAllPasses.h". Otherwise the pass would be deleted by
// the link time optimization.
//<editor-fold defaultstate="collapsed" desc="llvm::createDomPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 252,
 FQN="llvm::createDomPrinterPass", NM="_ZN4llvm20createDomPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm20createDomPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDomPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createDomPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 256,
 FQN="llvm::createDomOnlyPrinterPass", NM="_ZN4llvm24createDomOnlyPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm24createDomOnlyPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDomOnlyPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createDomOnlyPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createDomViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 260,
 FQN="llvm::createDomViewerPass", NM="_ZN4llvm19createDomViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm19createDomViewerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDomViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createDomViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createDomOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 264,
 FQN="llvm::createDomOnlyViewerPass", NM="_ZN4llvm23createDomOnlyViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm23createDomOnlyViewerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDomOnlyViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createDomOnlyViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPostDomPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 268,
 FQN="llvm::createPostDomPrinterPass", NM="_ZN4llvm24createPostDomPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm24createPostDomPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPostDomPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createPostDomPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPostDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 272,
 FQN="llvm::createPostDomOnlyPrinterPass", NM="_ZN4llvm28createPostDomOnlyPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28createPostDomOnlyPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPostDomOnlyPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createPostDomOnlyPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPostDomViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 276,
 FQN="llvm::createPostDomViewerPass", NM="_ZN4llvm23createPostDomViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm23createPostDomViewerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPostDomViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createPostDomViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPostDomOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 280,
 FQN="llvm::createPostDomOnlyViewerPass", NM="_ZN4llvm27createPostDomOnlyViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27createPostDomOnlyViewerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createPostDomOnlyViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.DomPrinterLlvmGlobals.
    createPostDomOnlyViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createPostDomTree">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/PostDominators.h", line = 88,
 FQN="llvm::createPostDomTree", NM="_ZN4llvm17createPostDomTreeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm17createPostDomTreeEv")
//</editor-fold>
public static FunctionPass /*P*/ createPostDomTree() {
  return /*delegate*/org.llvm.analysis.impl.PostDominatorsLlvmGlobals.
    createPostDomTree();
}


/// \brief See if the given exception handling personality function is one
/// that we understand.  If so, return a description of it; otherwise return
/// Unknown.

/// See if the given exception handling personality function is one that we
/// understand.  If so, return a description of it; otherwise return Unknown.
//<editor-fold defaultstate="collapsed" desc="llvm::classifyEHPersonality">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp", line = 22,
 FQN="llvm::classifyEHPersonality", NM="_ZN4llvm21classifyEHPersonalityEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm21classifyEHPersonalityEPKNS_5ValueE")
//</editor-fold>
public static EHPersonality classifyEHPersonality(/*const*/ Value /*P*/ Pers) {
  return /*delegate*/org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals.
    classifyEHPersonality(Pers);
}


/// \brief Returns true if this personality function catches asynchronous
/// exceptions.
//<editor-fold defaultstate="collapsed" desc="llvm::isAsynchronousEHPersonality">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/EHPersonalities.h", line = 44,
 FQN="llvm::isAsynchronousEHPersonality", NM="_ZN4llvm27isAsynchronousEHPersonalityENS_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm27isAsynchronousEHPersonalityENS_13EHPersonalityE")
//</editor-fold>
public static /*inline*/ boolean isAsynchronousEHPersonality(EHPersonality Pers) {
  return /*delegate*/org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals.
    isAsynchronousEHPersonality(Pers);
}


/// \brief Returns true if this is a personality function that invokes
/// handler funclets (which must return to it).
//<editor-fold defaultstate="collapsed" desc="llvm::isFuncletEHPersonality">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/EHPersonalities.h", line = 59,
 FQN="llvm::isFuncletEHPersonality", NM="_ZN4llvm22isFuncletEHPersonalityENS_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm22isFuncletEHPersonalityENS_13EHPersonalityE")
//</editor-fold>
public static /*inline*/ boolean isFuncletEHPersonality(EHPersonality Pers) {
  return /*delegate*/org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals.
    isFuncletEHPersonality(Pers);
}


/// \brief Return true if this personality may be safely removed if there
/// are no invoke instructions remaining in the current function.
//<editor-fold defaultstate="collapsed" desc="llvm::isNoOpWithoutInvoke">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/EHPersonalities.h", line = 74,
 FQN="llvm::isNoOpWithoutInvoke", NM="_ZN4llvm19isNoOpWithoutInvokeENS_13EHPersonalityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm19isNoOpWithoutInvokeENS_13EHPersonalityE")
//</editor-fold>
public static /*inline*/ boolean isNoOpWithoutInvoke(EHPersonality Pers) {
  return /*delegate*/org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals.
    isNoOpWithoutInvoke(Pers);
}

//<editor-fold defaultstate="collapsed" desc="llvm::canSimplifyInvokeNoUnwind">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp", line = 43,
 FQN="llvm::canSimplifyInvokeNoUnwind", NM="_ZN4llvm25canSimplifyInvokeNoUnwindEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm25canSimplifyInvokeNoUnwindEPKNS_8FunctionE")
//</editor-fold>
public static boolean canSimplifyInvokeNoUnwind(/*const*/ Function /*P*/ F) {
  return /*delegate*/org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals.
    canSimplifyInvokeNoUnwind(F);
}


/// \brief If an EH funclet personality is in use (see isFuncletEHPersonality),
/// this will recompute which blocks are in which funclet. It is possible that
/// some blocks are in multiple funclets. Consider this analysis to be
/// expensive.
//<editor-fold defaultstate="collapsed" desc="llvm::colorEHFunclets">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp", line = 51,
 FQN="llvm::colorEHFunclets", NM="_ZN4llvm15colorEHFuncletsERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/EHPersonalities.cpp -nm=_ZN4llvm15colorEHFuncletsERNS_8FunctionE")
//</editor-fold>
public static DenseMap<BasicBlock /*P*/ , TinyPtrVector<BasicBlock /*P*/ >> colorEHFunclets(final Function /*&*/ F) {
  return /*delegate*/org.llvm.analysis.impl.EHPersonalitiesLlvmGlobals.
    colorEHFunclets(F);
}


/// TransformForPostIncUse - Transform the given expression according to the
/// given transformation kind.
//<editor-fold defaultstate="collapsed" desc="llvm::TransformForPostIncUse">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/ScalarEvolutionNormalization.h", line = 68,
 FQN="llvm::TransformForPostIncUse", NM="_ZN4llvm22TransformForPostIncUseENS_13TransformKindEPKNS_4SCEVEPNS_11InstructionEPNS_5ValueERNS_11SmallPtrSetIPKNS_4LoopELj2EEERNS_15ScalarEvolutionERNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm22TransformForPostIncUseENS_13TransformKindEPKNS_4SCEVEPNS_11InstructionEPNS_5ValueERNS_11SmallPtrSetIPKNS_4LoopELj2EEERNS_15ScalarEvolutionERNS_13DominatorTreeE")
//</editor-fold>
public static /*const*/ SCEV /*P*/ TransformForPostIncUse(TransformKind Kind,
                      /*const*/ SCEV /*P*/ S,
                      Instruction /*P*/ User,
                      Value /*P*/ OperandValToReplace,
                      final SmallPtrSet</*const*/ Loop /*P*/ > /*&*/ Loops,
                      final ScalarEvolution /*&*/ SE,
                      final DominatorTree /*&*/ DT) {
  return /*delegate*/org.llvm.analysis.impl.ScalarEvolutionNormalizationLlvmGlobals.
    TransformForPostIncUse(Kind,
                      S,
                      User,
                      OperandValToReplace,
                      Loops,
                      SE,
                      DT);
}

//<editor-fold defaultstate="collapsed" desc="llvm::createIVUsersPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 65,
 FQN="llvm::createIVUsersPass", NM="_ZN4llvm17createIVUsersPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm17createIVUsersPassEv")
//</editor-fold>
public static Pass /*P*/ createIVUsersPass() {
  return /*delegate*/org.llvm.analysis.impl.IVUsersLlvmGlobals.
    createIVUsersPass();
}


/// Returns the minimum set of Analyses that all loop passes must preserve.
//<editor-fold defaultstate="collapsed" desc="llvm::getLoopPassPreservedAnalyses">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPassManager.h", line = 52,
 FQN="llvm::getLoopPassPreservedAnalyses", NM="_ZN4llvm28getLoopPassPreservedAnalysesEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm28getLoopPassPreservedAnalysesEv")
//</editor-fold>
public static PreservedAnalyses getLoopPassPreservedAnalyses() {
  return /*delegate*/org.llvm.analysis.impl.LoopPassManagerLlvmGlobals.
    getLoopPassPreservedAnalyses();
}


/// \brief A function to deduce a loop pass type and wrap it in the templated
/// adaptor.
/*template <typename LoopPassT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::createFunctionToLoopPassAdaptor">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopPassManager.h", line = 136,
 FQN="llvm::createFunctionToLoopPassAdaptor", NM="Tpl__ZN4llvm31createFunctionToLoopPassAdaptorET_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=Tpl__ZN4llvm31createFunctionToLoopPassAdaptorET_")
//</editor-fold>
public static </*typename*/ LoopPassT extends IPassLoop<PreservedAnalyses>> FunctionToLoopPassAdaptor<LoopPassT> createFunctionToLoopPassAdaptor(LoopPassT Pass) {
  return /*delegate*/org.llvm.analysis.impl.LoopPassManagerLlvmGlobals.
    createFunctionToLoopPassAdaptor(Pass);
}


// Helper function that finds all indirect call sites.
//<editor-fold defaultstate="collapsed" desc="llvm::findIndirectCallSites">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IndirectCallSiteVisitor.h", line = 38,
 FQN="llvm::findIndirectCallSites", NM="_ZN4llvmL21findIndirectCallSitesERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IndirectCallPromotionAnalysis.cpp -nm=_ZN4llvmL21findIndirectCallSitesERNS_8FunctionE")
//</editor-fold>
public static /*inline*/ std.vector<Instruction /*P*/ > findIndirectCallSites(final Function /*&*/ F) {
  return /*delegate*/org.llvm.analysis.impl.IndirectCallSiteVisitorLlvmGlobals.
    findIndirectCallSites(F);
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDummyCGSCCPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/CallGraphSCCPass.h", line = 115,
 FQN="llvm::initializeDummyCGSCCPassPass", NM="_ZN4llvm28initializeDummyCGSCCPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm28initializeDummyCGSCCPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDummyCGSCCPassPass(final PassRegistry /*&*/ $Prm0) {
  /*delegate*/org.llvm.analysis.impl.CallGraphSCCPassLlvmGlobals.
    initializeDummyCGSCCPassPass($Prm0);
}


/// \brief Get an InlineCost object representing the cost of inlining this
/// callsite.
///
/// Note that a default threshold is passed into this function. This threshold
/// could be modified based on callsite's properties and only costs below this
/// new threshold are computed with any accuracy. The new threshold can be
/// used to bound the computation necessary to determine whether the cost is
/// sufficiently low to warrant inlining.
///
/// Also note that calling this function *dynamically* computes the cost of
/// inlining the callsite. It is an expensive, heavyweight call.
//<editor-fold defaultstate="collapsed" desc="llvm::getInlineCost">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1447,
 FQN="llvm::getInlineCost", NM="_ZN4llvm13getInlineCostENS_8CallSiteEiRNS_19TargetTransformInfoEPNS_22AssumptionCacheTrackerEPNS_18ProfileSummaryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm13getInlineCostENS_8CallSiteEiRNS_19TargetTransformInfoEPNS_22AssumptionCacheTrackerEPNS_18ProfileSummaryInfoE")
//</editor-fold>
public static InlineCost getInlineCost(CallSite CS, int DefaultThreshold,
             final TargetTransformInfo /*&*/ CalleeTTI,
             AssumptionCacheTracker /*P*/ ACT,
             ProfileSummaryInfo /*P*/ PSI) {
  return /*delegate*/org.llvm.analysis.impl.InlineCostLlvmGlobals.
    getInlineCost(CS, DefaultThreshold,
             CalleeTTI,
             ACT,
             PSI);
}


/// \brief Get an InlineCost with the callee explicitly specified.
/// This allows you to calculate the cost of inlining a function via a
/// pointer. This behaves exactly as the version with no explicit callee
/// parameter in all other respects.
//
//<editor-fold defaultstate="collapsed" desc="llvm::getInlineCost">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1468,
 FQN="llvm::getInlineCost", NM="_ZN4llvm13getInlineCostENS_8CallSiteEPNS_8FunctionEiRNS_19TargetTransformInfoEPNS_22AssumptionCacheTrackerEPNS_18ProfileSummaryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm13getInlineCostENS_8CallSiteEPNS_8FunctionEiRNS_19TargetTransformInfoEPNS_22AssumptionCacheTrackerEPNS_18ProfileSummaryInfoE")
//</editor-fold>
public static InlineCost getInlineCost(CallSite CS, Function /*P*/ Callee,
             int DefaultThreshold,
             final TargetTransformInfo /*&*/ CalleeTTI,
             AssumptionCacheTracker /*P*/ ACT,
             ProfileSummaryInfo /*P*/ PSI) {
  return /*delegate*/org.llvm.analysis.impl.InlineCostLlvmGlobals.
    getInlineCost(CS, Callee,
             DefaultThreshold,
             CalleeTTI,
             ACT,
             PSI);
}

//<editor-fold defaultstate="collapsed" desc="llvm::computeThresholdFromOptLevels">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1455,
 FQN="llvm::computeThresholdFromOptLevels", NM="_ZN4llvm29computeThresholdFromOptLevelsEjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm29computeThresholdFromOptLevelsEjj")
//</editor-fold>
public static int computeThresholdFromOptLevels(/*uint*/int OptLevel,
                             /*uint*/int SizeOptLevel) {
  return /*delegate*/org.llvm.analysis.impl.InlineCostLlvmGlobals.
    computeThresholdFromOptLevels(OptLevel,
                             SizeOptLevel);
}


/// \brief Return the default value of -inline-threshold.
//<editor-fold defaultstate="collapsed" desc="llvm::getDefaultInlineThreshold">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1466,
 FQN="llvm::getDefaultInlineThreshold", NM="_ZN4llvm25getDefaultInlineThresholdEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm25getDefaultInlineThresholdEv")
//</editor-fold>
public static int getDefaultInlineThreshold() {
  return /*delegate*/org.llvm.analysis.impl.InlineCostLlvmGlobals.
    getDefaultInlineThreshold();
}


/// \brief Minimal filter to detect invalid constructs for inlining.
//<editor-fold defaultstate="collapsed" desc="llvm::isInlineViable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp", line = 1520,
 FQN="llvm::isInlineViable", NM="_ZN4llvm14isInlineViableERNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm14isInlineViableERNS_8FunctionE")
//</editor-fold>
public static boolean isInlineViable(final Function /*&*/ F) {
  return /*delegate*/org.llvm.analysis.impl.InlineCostLlvmGlobals.
    isInlineViable(F);
}


/// Given operands for an Add, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyAddInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 50,
 FQN="llvm::SimplifyAddInst", NM="_ZN4llvm15SimplifyAddInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyAddInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyAddInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyAddInst(LHS, RHS, isNSW, isNUW,
               DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyAddInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyAddInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyAddInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAddInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyAddInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for a Sub, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySubInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 58,
 FQN="llvm::SimplifySubInst", NM="_ZN4llvm15SimplifySubInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifySubInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySubInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySubInst(LHS, RHS, isNSW, isNUW,
               DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySubInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySubInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySubInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySubInst(Value /*P*/ LHS, Value /*P*/ RHS, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifySubInst(LHS, RHS, isNSW, isNUW,
               DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for an FAdd, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFAddInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 66,
 FQN="llvm::SimplifyFAddInst", NM="_ZN4llvm16SimplifyFAddInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyFAddInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFAddInst(LHS, RHS, FMF,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFAddInst(LHS, RHS, FMF,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFAddInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFAddInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFAddInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFAddInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an FSub, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFSubInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 74,
 FQN="llvm::SimplifyFSubInst", NM="_ZN4llvm16SimplifyFSubInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyFSubInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFSubInst(LHS, RHS, FMF,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFSubInst(LHS, RHS, FMF,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFSubInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFSubInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFSubInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFSubInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an FMul, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFMulInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 82,
 FQN="llvm::SimplifyFMulInst", NM="_ZN4llvm16SimplifyFMulInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyFMulInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFMulInst(LHS, RHS, FMF,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFMulInst(LHS, RHS, FMF,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFMulInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFMulInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFMulInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFMulInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for a Mul, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyMulInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 90,
 FQN="llvm::SimplifyMulInst", NM="_ZN4llvm15SimplifyMulInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyMulInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyMulInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyMulInst(LHS, RHS, DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyMulInst(LHS, RHS, DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyMulInst(LHS, RHS, DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyMulInst(LHS, RHS, DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyMulInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyMulInst(LHS, RHS, DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for an SDiv, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySDivInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 97,
 FQN="llvm::SimplifySDivInst", NM="_ZN4llvm16SimplifySDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifySDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySDivInst(LHS, RHS, DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySDivInst(LHS, RHS, DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySDivInst(LHS, RHS, DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySDivInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifySDivInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for a UDiv, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyUDivInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 104,
 FQN="llvm::SimplifyUDivInst", NM="_ZN4llvm16SimplifyUDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyUDivInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyUDivInst(LHS, RHS, DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyUDivInst(LHS, RHS, DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyUDivInst(LHS, RHS, DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyUDivInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyUDivInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyUDivInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an FDiv, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFDivInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 111,
 FQN="llvm::SimplifyFDivInst", NM="_ZN4llvm16SimplifyFDivInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyFDivInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFDivInst(LHS, RHS, FMF,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFDivInst(LHS, RHS, FMF,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFDivInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFDivInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFDivInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFDivInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an SRem, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySRemInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 119,
 FQN="llvm::SimplifySRemInst", NM="_ZN4llvm16SimplifySRemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifySRemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySRemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySRemInst(LHS, RHS, DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySRemInst(LHS, RHS, DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySRemInst(LHS, RHS, DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySRemInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySRemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifySRemInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for a URem, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyURemInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 126,
 FQN="llvm::SimplifyURemInst", NM="_ZN4llvm16SimplifyURemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyURemInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyURemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyURemInst(LHS, RHS, DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyURemInst(LHS, RHS, DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyURemInst(LHS, RHS, DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyURemInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyURemInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyURemInst(LHS, RHS, DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an FRem, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFRemInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 133,
 FQN="llvm::SimplifyFRemInst", NM="_ZN4llvm16SimplifyFRemInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyFRemInstEPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFRemInst(LHS, RHS, FMF,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFRemInst(LHS, RHS, FMF,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFRemInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFRemInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFRemInst(Value /*P*/ LHS, Value /*P*/ RHS, FastMathFlags FMF,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFRemInst(LHS, RHS, FMF,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for a Shl, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyShlInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 141,
 FQN="llvm::SimplifyShlInst", NM="_ZN4llvm15SimplifyShlInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyShlInstEPNS_5ValueES1_bbRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW,
               DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW,
               DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW,
               DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyShlInst(Op0, Op1, isNSW, isNUW,
               DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyShlInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isNSW, boolean isNUW,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyShlInst(Op0, Op1, isNSW, isNUW,
               DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for a LShr, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyLShrInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 149,
 FQN="llvm::SimplifyLShrInst", NM="_ZN4llvm16SimplifyLShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyLShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyLShrInst(Op0, Op1, isExact,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyLShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyLShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyLShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyLShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyLShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for a AShr, fold the result or return nulll.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyAShrInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 157,
 FQN="llvm::SimplifyAShrInst", NM="_ZN4llvm16SimplifyAShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyAShrInstEPNS_5ValueES1_bRKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyAShrInst(Op0, Op1, isExact,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyAShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyAShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyAShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAShrInst(Value /*P*/ Op0, Value /*P*/ Op1, boolean isExact,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyAShrInst(Op0, Op1, isExact,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an And, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyAndInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 165,
 FQN="llvm::SimplifyAndInst", NM="_ZN4llvm15SimplifyAndInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyAndInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyAndInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyAndInst(LHS, RHS, DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyAndInst(LHS, RHS, DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyAndInst(LHS, RHS, DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyAndInst(LHS, RHS, DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyAndInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyAndInst(LHS, RHS, DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for an Or, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyOrInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 172,
 FQN="llvm::SimplifyOrInst", NM="_ZN4llvm14SimplifyOrInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm14SimplifyOrInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyOrInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyOrInst(LHS, RHS, DL,
              (/*const*/ TargetLibraryInfo /*P*/ )null,
              (/*const*/ DominatorTree /*P*/ )null,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyOrInst(LHS, RHS, DL,
              TLI,
              (/*const*/ DominatorTree /*P*/ )null,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyOrInst(LHS, RHS, DL,
              TLI,
              DT,
              (AssumptionCache /*P*/ )null,
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
              /*const*/ DominatorTree /*P*/ DT/*= null*/,
              AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyOrInst(LHS, RHS, DL,
              TLI,
              DT,
              AC,
              (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyOrInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
              /*const*/ DominatorTree /*P*/ DT/*= null*/,
              AssumptionCache /*P*/ AC/*= null*/,
              /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyOrInst(LHS, RHS, DL,
              TLI,
              DT,
              AC,
              CxtI);
}


/// Given operands for an Xor, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyXorInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 179,
 FQN="llvm::SimplifyXorInst", NM="_ZN4llvm15SimplifyXorInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyXorInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyXorInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyXorInst(LHS, RHS, DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyXorInst(LHS, RHS, DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyXorInst(LHS, RHS, DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyXorInst(LHS, RHS, DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyXorInst(Value /*P*/ LHS, Value /*P*/ RHS, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyXorInst(LHS, RHS, DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for an ICmpInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyICmpInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 186,
 FQN="llvm::SimplifyICmpInst", NM="_ZN4llvm16SimplifyICmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyICmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyICmpInst(Predicate, LHS, RHS,
                DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyICmpInst(Predicate, LHS, RHS,
                DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyICmpInst(Predicate, LHS, RHS,
                DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyICmpInst(Predicate, LHS, RHS,
                DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyICmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyICmpInst(Predicate, LHS, RHS,
                DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for an FCmpInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFCmpInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 194,
 FQN="llvm::SimplifyFCmpInst", NM="_ZN4llvm16SimplifyFCmpInstEjPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm16SimplifyFCmpInstEjPNS_5ValueES1_NS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFCmpInst(Predicate, LHS, RHS,
                FMF, DL,
                (/*const*/ TargetLibraryInfo /*P*/ )null,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFCmpInst(Predicate, LHS, RHS,
                FMF, DL,
                TLI,
                (/*const*/ DominatorTree /*P*/ )null,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFCmpInst(Predicate, LHS, RHS,
                FMF, DL,
                TLI,
                DT,
                (AssumptionCache /*P*/ )null,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFCmpInst(Predicate, LHS, RHS,
                FMF, DL,
                TLI,
                DT,
                AC,
                (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
                FastMathFlags FMF, final /*const*/ DataLayout /*&*/ DL,
                /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                /*const*/ DominatorTree /*P*/ DT/*= null*/,
                AssumptionCache /*P*/ AC/*= null*/,
                /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFCmpInst(Predicate, LHS, RHS,
                FMF, DL,
                TLI,
                DT,
                AC,
                CxtI);
}


/// Given operands for a SelectInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifySelectInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 202,
 FQN="llvm::SimplifySelectInst", NM="_ZN4llvm18SimplifySelectInstEPNS_5ValueES1_S1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm18SimplifySelectInstEPNS_5ValueES1_S1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal,
                  final /*const*/ DataLayout /*&*/ DL) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal,
                  DL,
                  (/*const*/ TargetLibraryInfo /*P*/ )null,
                  (/*const*/ DominatorTree /*P*/ )null,
                  (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal,
                  final /*const*/ DataLayout /*&*/ DL,
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal,
                  DL,
                  TLI,
                  (/*const*/ DominatorTree /*P*/ )null,
                  (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal,
                  final /*const*/ DataLayout /*&*/ DL,
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal,
                  DL,
                  TLI,
                  DT,
                  (AssumptionCache /*P*/ )null,
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal,
                  final /*const*/ DataLayout /*&*/ DL,
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                  /*const*/ DominatorTree /*P*/ DT/*= null*/,
                  AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifySelectInst(Cond, TrueVal, FalseVal,
                  DL,
                  TLI,
                  DT,
                  AC,
                  (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifySelectInst(Value /*P*/ Cond, Value /*P*/ TrueVal, Value /*P*/ FalseVal,
                  final /*const*/ DataLayout /*&*/ DL,
                  /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                  /*const*/ DominatorTree /*P*/ DT/*= null*/,
                  AssumptionCache /*P*/ AC/*= null*/,
                  /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifySelectInst(Cond, TrueVal, FalseVal,
                  DL,
                  TLI,
                  DT,
                  AC,
                  CxtI);
}


/// Given operands for a GetElementPtrInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyGEPInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 210,
 FQN="llvm::SimplifyGEPInst", NM="_ZN4llvm15SimplifyGEPInstEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyGEPInstEPNS_4TypeENS_8ArrayRefIPNS_5ValueEEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops,
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyGEPInst(SrcTy, Ops,
               DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyGEPInst(SrcTy, Ops,
               DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyGEPInst(SrcTy, Ops,
               DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyGEPInst(SrcTy, Ops,
               DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyGEPInst(Type /*P*/ SrcTy, ArrayRef<Value /*P*/ > Ops,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyGEPInst(SrcTy, Ops,
               DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for an InsertValueInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyInsertValueInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 218,
 FQN="llvm::SimplifyInsertValueInst", NM="_ZN4llvm23SimplifyInsertValueInstEPNS_5ValueES1_NS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm23SimplifyInsertValueInstEPNS_5ValueES1_NS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val,
                       ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyInsertValueInst(Agg, Val,
                       Idxs, DL,
                       (/*const*/ TargetLibraryInfo /*P*/ )null,
                       (/*const*/ DominatorTree /*P*/ )null,
                       (AssumptionCache /*P*/ )null,
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val,
                       ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL,
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyInsertValueInst(Agg, Val,
                       Idxs, DL,
                       TLI,
                       (/*const*/ DominatorTree /*P*/ )null,
                       (AssumptionCache /*P*/ )null,
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val,
                       ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL,
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                       /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyInsertValueInst(Agg, Val,
                       Idxs, DL,
                       TLI,
                       DT,
                       (AssumptionCache /*P*/ )null,
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val,
                       ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL,
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                       /*const*/ DominatorTree /*P*/ DT/*= null*/,
                       AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyInsertValueInst(Agg, Val,
                       Idxs, DL,
                       TLI,
                       DT,
                       AC,
                       (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyInsertValueInst(Value /*P*/ Agg, Value /*P*/ Val,
                       ArrayRefUInt Idxs, final /*const*/ DataLayout /*&*/ DL,
                       /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                       /*const*/ DominatorTree /*P*/ DT/*= null*/,
                       AssumptionCache /*P*/ AC/*= null*/,
                       /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyInsertValueInst(Agg, Val,
                       Idxs, DL,
                       TLI,
                       DT,
                       AC,
                       CxtI);
}


/// Given operands for an ExtractValueInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyExtractValueInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 226,
 FQN="llvm::SimplifyExtractValueInst", NM="_ZN4llvm24SimplifyExtractValueInstEPNS_5ValueENS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm24SimplifyExtractValueInstEPNS_5ValueENS_8ArrayRefIjEERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs,
                        final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyExtractValueInst(Agg, Idxs,
                        DL,
                        (/*const*/ TargetLibraryInfo /*P*/ )null,
                        (/*const*/ DominatorTree /*P*/ )null,
                        (AssumptionCache /*P*/ )null,
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs,
                        final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyExtractValueInst(Agg, Idxs,
                        DL,
                        TLI,
                        (/*const*/ DominatorTree /*P*/ )null,
                        (AssumptionCache /*P*/ )null,
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs,
                        final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                        /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyExtractValueInst(Agg, Idxs,
                        DL,
                        TLI,
                        DT,
                        (AssumptionCache /*P*/ )null,
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs,
                        final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                        /*const*/ DominatorTree /*P*/ DT/*= null*/,
                        AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyExtractValueInst(Agg, Idxs,
                        DL,
                        TLI,
                        DT,
                        AC,
                        (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractValueInst(Value /*P*/ Agg, ArrayRefUInt Idxs,
                        final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                        /*const*/ DominatorTree /*P*/ DT/*= null*/,
                        AssumptionCache /*P*/ AC/*= null*/,
                        /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyExtractValueInst(Agg, Idxs,
                        DL,
                        TLI,
                        DT,
                        AC,
                        CxtI);
}


/// Given operands for an ExtractElementInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyExtractElementInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 234,
 FQN="llvm::SimplifyExtractElementInst", NM="_ZN4llvm26SimplifyExtractElementInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm26SimplifyExtractElementInstEPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx,
                          final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyExtractElementInst(Vec, Idx,
                          DL,
                          (/*const*/ TargetLibraryInfo /*P*/ )null,
                          (/*const*/ DominatorTree /*P*/ )null,
                          (AssumptionCache /*P*/ )null,
                          (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx,
                          final /*const*/ DataLayout /*&*/ DL,
                          /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyExtractElementInst(Vec, Idx,
                          DL,
                          TLI,
                          (/*const*/ DominatorTree /*P*/ )null,
                          (AssumptionCache /*P*/ )null,
                          (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx,
                          final /*const*/ DataLayout /*&*/ DL,
                          /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                          /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyExtractElementInst(Vec, Idx,
                          DL,
                          TLI,
                          DT,
                          (AssumptionCache /*P*/ )null,
                          (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx,
                          final /*const*/ DataLayout /*&*/ DL,
                          /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                          /*const*/ DominatorTree /*P*/ DT/*= null*/,
                          AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyExtractElementInst(Vec, Idx,
                          DL,
                          TLI,
                          DT,
                          AC,
                          (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyExtractElementInst(Value /*P*/ Vec, Value /*P*/ Idx,
                          final /*const*/ DataLayout /*&*/ DL,
                          /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                          /*const*/ DominatorTree /*P*/ DT/*= null*/,
                          AssumptionCache /*P*/ AC/*= null*/,
                          /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyExtractElementInst(Vec, Idx,
                          DL,
                          TLI,
                          DT,
                          AC,
                          CxtI);
}


/// Given operands for an TruncInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyTruncInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 242,
 FQN="llvm::SimplifyTruncInst", NM="_ZN4llvm17SimplifyTruncInstEPNS_5ValueEPNS_4TypeERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm17SimplifyTruncInstEPNS_5ValueEPNS_4TypeERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyTruncInst(Op, Ty, DL,
                 (/*const*/ TargetLibraryInfo /*P*/ )null,
                 (/*const*/ DominatorTree /*P*/ )null,
                 (AssumptionCache /*P*/ )null,
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL,
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyTruncInst(Op, Ty, DL,
                 TLI,
                 (/*const*/ DominatorTree /*P*/ )null,
                 (AssumptionCache /*P*/ )null,
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL,
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                 /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyTruncInst(Op, Ty, DL,
                 TLI,
                 DT,
                 (AssumptionCache /*P*/ )null,
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL,
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                 /*const*/ DominatorTree /*P*/ DT/*= null*/,
                 AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyTruncInst(Op, Ty, DL,
                 TLI,
                 DT,
                 AC,
                 (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyTruncInst(Value /*P*/ Op, Type /*P*/ Ty, final /*const*/ DataLayout /*&*/ DL,
                 /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                 /*const*/ DominatorTree /*P*/ DT/*= null*/,
                 AssumptionCache /*P*/ AC/*= null*/,
                 /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyTruncInst(Op, Ty, DL,
                 TLI,
                 DT,
                 AC,
                 CxtI);
}


//=== Helper functions for higher up the class hierarchy.

/// Given operands for a CmpInst, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCmpInst">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 252,
 FQN="llvm::SimplifyCmpInst", NM="_ZN4llvm15SimplifyCmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyCmpInstEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyCmpInst(Predicate, LHS, RHS,
               DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyCmpInst(Predicate, LHS, RHS,
               DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyCmpInst(Predicate, LHS, RHS,
               DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyCmpInst(Predicate, LHS, RHS,
               DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCmpInst(/*uint*/int Predicate, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyCmpInst(Predicate, LHS, RHS,
               DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given operands for a BinaryOperator, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyBinOp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 260,
 FQN="llvm::SimplifyBinOp", NM="_ZN4llvm13SimplifyBinOpEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm13SimplifyBinOpEjPNS_5ValueES1_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
             final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyBinOp(Opcode, LHS, RHS,
             DL,
             (/*const*/ TargetLibraryInfo /*P*/ )null,
             (/*const*/ DominatorTree /*P*/ )null,
             (AssumptionCache /*P*/ )null,
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
             final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyBinOp(Opcode, LHS, RHS,
             DL,
             TLI,
             (/*const*/ DominatorTree /*P*/ )null,
             (AssumptionCache /*P*/ )null,
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
             final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
             /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyBinOp(Opcode, LHS, RHS,
             DL,
             TLI,
             DT,
             (AssumptionCache /*P*/ )null,
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
             final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
             /*const*/ DominatorTree /*P*/ DT/*= null*/,
             AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyBinOp(Opcode, LHS, RHS,
             DL,
             TLI,
             DT,
             AC,
             (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
             final /*const*/ DataLayout /*&*/ DL,
             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
             /*const*/ DominatorTree /*P*/ DT/*= null*/,
             AssumptionCache /*P*/ AC/*= null*/,
             /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyBinOp(Opcode, LHS, RHS,
             DL,
             TLI,
             DT,
             AC,
             CxtI);
}


/// Given operands for an FP BinaryOperator, fold the result or return null.
/// In contrast to SimplifyBinOp, try to use FastMathFlag when folding the
/// result. In case we don't need FastMathFlags, simply fall to SimplifyBinOp.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyFPBinOp">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 270,
 FQN="llvm::SimplifyFPBinOp", NM="_ZN4llvm15SimplifyFPBinOpEjPNS_5ValueES1_RKNS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm15SimplifyFPBinOpEjPNS_5ValueES1_RKNS_13FastMathFlagsERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyFPBinOp(Opcode, LHS, RHS,
               FMF, DL,
               (/*const*/ TargetLibraryInfo /*P*/ )null,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyFPBinOp(Opcode, LHS, RHS,
               FMF, DL,
               TLI,
               (/*const*/ DominatorTree /*P*/ )null,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyFPBinOp(Opcode, LHS, RHS,
               FMF, DL,
               TLI,
               DT,
               (AssumptionCache /*P*/ )null,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyFPBinOp(Opcode, LHS, RHS,
               FMF, DL,
               TLI,
               DT,
               AC,
               (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyFPBinOp(/*uint*/int Opcode, Value /*P*/ LHS, Value /*P*/ RHS,
               final /*const*/ FastMathFlags /*&*/ FMF, final /*const*/ DataLayout /*&*/ DL,
               /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
               /*const*/ DominatorTree /*P*/ DT/*= null*/,
               AssumptionCache /*P*/ AC/*= null*/,
               /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyFPBinOp(Opcode, LHS, RHS,
               FMF, DL,
               TLI,
               DT,
               AC,
               CxtI);
}


/// Given a function and iterators over arguments, fold the result or return
/// null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 279,
 FQN="llvm::SimplifyCall", NM="_ZN4llvm12SimplifyCallEPNS_5ValueEPNS_3UseES3_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm12SimplifyCallEPNS_5ValueEPNS_3UseES3_RKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin,
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyCall(V, ArgBegin,
            ArgEnd, DL,
            (/*const*/ TargetLibraryInfo /*P*/ )null,
            (/*const*/ DominatorTree /*P*/ )null,
            (AssumptionCache /*P*/ )null,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin,
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyCall(V, ArgBegin,
            ArgEnd, DL,
            TLI,
            (/*const*/ DominatorTree /*P*/ )null,
            (AssumptionCache /*P*/ )null,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin,
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
            /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyCall(V, ArgBegin,
            ArgEnd, DL,
            TLI,
            DT,
            (AssumptionCache /*P*/ )null,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin,
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
            /*const*/ DominatorTree /*P*/ DT/*= null*/,
            AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyCall(V, ArgBegin,
            ArgEnd, DL,
            TLI,
            DT,
            AC,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, type$ptr<Use/*P*/> ArgBegin,
            type$ptr<Use/*P*/> ArgEnd, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
            /*const*/ DominatorTree /*P*/ DT/*= null*/,
            AssumptionCache /*P*/ AC/*= null*/,
            /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyCall(V, ArgBegin,
            ArgEnd, DL,
            TLI,
            DT,
            AC,
            CxtI);
}


/// Given a function and set of arguments, fold the result or return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 287,
 FQN="llvm::SimplifyCall", NM="_ZN4llvm12SimplifyCallEPNS_5ValueENS_8ArrayRefIS1_EERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm12SimplifyCallEPNS_5ValueENS_8ArrayRefIS1_EERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheEPKNS_11InstructionE")
//</editor-fold>
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyCall(V, Args, DL,
            (/*const*/ TargetLibraryInfo /*P*/ )null,
            (/*const*/ DominatorTree /*P*/ )null,
            (AssumptionCache /*P*/ )null,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyCall(V, Args, DL,
            TLI,
            (/*const*/ DominatorTree /*P*/ )null,
            (AssumptionCache /*P*/ )null,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
            /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyCall(V, Args, DL,
            TLI,
            DT,
            (AssumptionCache /*P*/ )null,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
            /*const*/ DominatorTree /*P*/ DT/*= null*/,
            AssumptionCache /*P*/ AC/*= null*/) {
  return SimplifyCall(V, Args, DL,
            TLI,
            DT,
            AC,
            (/*const*/ Instruction /*P*/ )null);
}
public static Value /*P*/ SimplifyCall(Value /*P*/ V, ArrayRef<Value /*P*/ > Args, final /*const*/ DataLayout /*&*/ DL,
            /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
            /*const*/ DominatorTree /*P*/ DT/*= null*/,
            AssumptionCache /*P*/ AC/*= null*/,
            /*const*/ Instruction /*P*/ CxtI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyCall(V, Args, DL,
            TLI,
            DT,
            AC,
            CxtI);
}


/// See if we can compute a simplified version of this instruction. If not,
/// return null.
//<editor-fold defaultstate="collapsed" desc="llvm::SimplifyInstruction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 295,
 FQN="llvm::SimplifyInstruction", NM="_ZN4llvm19SimplifyInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm19SimplifyInstructionEPNS_11InstructionERKNS_10DataLayoutEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL) {
  return SimplifyInstruction(I, DL,
                   (/*const*/ TargetLibraryInfo /*P*/ )null,
                   (/*const*/ DominatorTree /*P*/ )null,
                   (AssumptionCache /*P*/ )null);
}
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL,
                   /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return SimplifyInstruction(I, DL,
                   TLI,
                   (/*const*/ DominatorTree /*P*/ )null,
                   (AssumptionCache /*P*/ )null);
}
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL,
                   /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                   /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return SimplifyInstruction(I, DL,
                   TLI,
                   DT,
                   (AssumptionCache /*P*/ )null);
}
public static Value /*P*/ SimplifyInstruction(Instruction /*P*/ I, final /*const*/ DataLayout /*&*/ DL,
                   /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                   /*const*/ DominatorTree /*P*/ DT/*= null*/,
                   AssumptionCache /*P*/ AC/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    SimplifyInstruction(I, DL,
                   TLI,
                   DT,
                   AC);
}


/// Replace all uses of 'I' with 'SimpleV' and simplify the uses recursively.
///
/// This first performs a normal RAUW of I with SimpleV. It then recursively
/// attempts to simplify those users updated by the operation. The 'I'
/// instruction must not be equal to the simplified value 'SimpleV'.
///
/// The function returns true if any simplifications were performed.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceAndRecursivelySimplify">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 307,
 FQN="llvm::replaceAndRecursivelySimplify", NM="_ZN4llvm29replaceAndRecursivelySimplifyEPNS_11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm29replaceAndRecursivelySimplifyEPNS_11InstructionEPNS_5ValueEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV) {
  return replaceAndRecursivelySimplify(I, SimpleV,
                             (/*const*/ TargetLibraryInfo /*P*/ )null,
                             (/*const*/ DominatorTree /*P*/ )null,
                             (AssumptionCache /*P*/ )null);
}
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV,
                             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return replaceAndRecursivelySimplify(I, SimpleV,
                             TLI,
                             (/*const*/ DominatorTree /*P*/ )null,
                             (AssumptionCache /*P*/ )null);
}
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV,
                             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                             /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return replaceAndRecursivelySimplify(I, SimpleV,
                             TLI,
                             DT,
                             (AssumptionCache /*P*/ )null);
}
public static boolean replaceAndRecursivelySimplify(Instruction /*P*/ I, Value /*P*/ SimpleV,
                             /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                             /*const*/ DominatorTree /*P*/ DT/*= null*/,
                             AssumptionCache /*P*/ AC/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    replaceAndRecursivelySimplify(I, SimpleV,
                             TLI,
                             DT,
                             AC);
}


/// Recursively attempt to simplify an instruction.
///
/// This routine uses SimplifyInstruction to simplify 'I', and if successful
/// replaces uses of 'I' with the simplified value. It then recurses on each
/// of the users impacted. It returns true if any simplifications were
/// performed.
//<editor-fold defaultstate="collapsed" desc="llvm::recursivelySimplifyInstruction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/InstructionSimplify.h", line = 318,
 FQN="llvm::recursivelySimplifyInstruction", NM="_ZN4llvm30recursivelySimplifyInstructionEPNS_11InstructionEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/InlineCost.cpp -nm=_ZN4llvm30recursivelySimplifyInstructionEPNS_11InstructionEPKNS_17TargetLibraryInfoEPKNS_13DominatorTreeEPNS_15AssumptionCacheE")
//</editor-fold>
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I) {
  return recursivelySimplifyInstruction(I,
                              (/*const*/ TargetLibraryInfo /*P*/ )null,
                              (/*const*/ DominatorTree /*P*/ )null,
                              (AssumptionCache /*P*/ )null);
}
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I,
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/) {
  return recursivelySimplifyInstruction(I,
                              TLI,
                              (/*const*/ DominatorTree /*P*/ )null,
                              (AssumptionCache /*P*/ )null);
}
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I,
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                              /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return recursivelySimplifyInstruction(I,
                              TLI,
                              DT,
                              (AssumptionCache /*P*/ )null);
}
public static boolean recursivelySimplifyInstruction(Instruction /*P*/ I,
                              /*const*/ TargetLibraryInfo /*P*/ TLI/*= null*/,
                              /*const*/ DominatorTree /*P*/ DT/*= null*/,
                              AssumptionCache /*P*/ AC/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.InstructionSimplifyLlvmGlobals.
    recursivelySimplifyInstruction(I,
                              TLI,
                              DT,
                              AC);
}


/// succ_begin/succ_end - define methods so that Intervals may be used
/// just like BasicBlocks can with the succ_* functions, and *::succ_iterator.
///
//<editor-fold defaultstate="collapsed" desc="llvm::succ_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 106,
 FQN="llvm::succ_begin", NM="_ZN4llvm10succ_beginEPNS_8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZN4llvm10succ_beginEPNS_8IntervalE")
//</editor-fold>
public static /*inline*/ std.vector.iterator<BasicBlock /*P*/ > succ_begin(Interval /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.IntervalLlvmGlobals.
    succ_begin(I);
}

//<editor-fold defaultstate="collapsed" desc="llvm::succ_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 109,
 FQN="llvm::succ_end", NM="_ZN4llvm8succ_endEPNS_8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZN4llvm8succ_endEPNS_8IntervalE")
//</editor-fold>
public static /*inline*/ std.vector.iterator<BasicBlock /*P*/ > succ_end(Interval /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.IntervalLlvmGlobals.
    succ_end(I);
}


/// pred_begin/pred_end - define methods so that Intervals may be used
/// just like BasicBlocks can with the pred_* functions, and *::pred_iterator.
///
//<editor-fold defaultstate="collapsed" desc="llvm::pred_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 116,
 FQN="llvm::pred_begin", NM="_ZN4llvm10pred_beginEPNS_8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZN4llvm10pred_beginEPNS_8IntervalE")
//</editor-fold>
public static /*inline*/ std.vector.iterator<BasicBlock /*P*/ > pred_begin(Interval /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.IntervalLlvmGlobals.
    pred_begin(I);
}

//<editor-fold defaultstate="collapsed" desc="llvm::pred_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Interval.h", line = 119,
 FQN="llvm::pred_end", NM="_ZN4llvm8pred_endEPNS_8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Interval.cpp -nm=_ZN4llvm8pred_endEPNS_8IntervalE")
//</editor-fold>
public static /*inline*/ std.vector.iterator<BasicBlock /*P*/ > pred_end(Interval /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.IntervalLlvmGlobals.
    pred_end(I);
}


// getNodeHeader - Given a source graph node and the source graph, return the
// BasicBlock that is the header node.  This is the opposite of
// getSourceGraphNode.
//
//<editor-fold defaultstate="collapsed" desc="llvm::getNodeHeader">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 49,
 FQN="llvm::getNodeHeader", NM="_ZN4llvm13getNodeHeaderEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13getNodeHeaderEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ getNodeHeader(BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    getNodeHeader(BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::getNodeHeader">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 50,
 FQN="llvm::getNodeHeader", NM="_ZN4llvm13getNodeHeaderEPNS_8IntervalE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13getNodeHeaderEPNS_8IntervalE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ getNodeHeader(Interval /*P*/ I) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    getNodeHeader(I);
}


// getSourceGraphNode - Given a BasicBlock and the source graph, return the
// source graph node that corresponds to the BasicBlock.  This is the opposite
// of getNodeHeader.
//
//<editor-fold defaultstate="collapsed" desc="llvm::getSourceGraphNode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 56,
 FQN="llvm::getSourceGraphNode", NM="_ZN4llvm18getSourceGraphNodeEPNS_8FunctionEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm18getSourceGraphNodeEPNS_8FunctionEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ BasicBlock /*P*/ getSourceGraphNode(Function /*P*/ $Prm0, BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    getSourceGraphNode($Prm0, BB);
}

//<editor-fold defaultstate="collapsed" desc="llvm::getSourceGraphNode">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 59,
 FQN="llvm::getSourceGraphNode", NM="_ZN4llvm18getSourceGraphNodeEPNS_17IntervalPartitionEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm18getSourceGraphNodeEPNS_17IntervalPartitionEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ Interval /*P*/ getSourceGraphNode(IntervalPartition /*P*/ IP, BasicBlock /*P*/ BB) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    getSourceGraphNode(IP, BB);
}


// addNodeToInterval - This method exists to assist the generic ProcessNode
// with the task of adding a node to the new interval, depending on the
// type of the source node.  In the case of a CFG source graph (BasicBlock
// case), the BasicBlock itself is added to the interval.
//
//<editor-fold defaultstate="collapsed" desc="llvm::addNodeToInterval">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 68,
 FQN="llvm::addNodeToInterval", NM="_ZN4llvm17addNodeToIntervalEPNS_8IntervalEPNS_10BasicBlockE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17addNodeToIntervalEPNS_8IntervalEPNS_10BasicBlockE")
//</editor-fold>
public static /*inline*/ void addNodeToInterval(Interval /*P*/ Int, BasicBlock /*P*/ BB) {
  /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    addNodeToInterval(Int, BB);
}


// addNodeToInterval - This method exists to assist the generic ProcessNode
// with the task of adding a node to the new interval, depending on the
// type of the source node.  In the case of a CFG source graph (BasicBlock
// case), the BasicBlock itself is added to the interval.  In the case of
// an IntervalPartition source graph (Interval case), all of the member
// BasicBlocks are added to the interval.
//
//<editor-fold defaultstate="collapsed" desc="llvm::addNodeToInterval">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 79,
 FQN="llvm::addNodeToInterval", NM="_ZN4llvm17addNodeToIntervalEPNS_8IntervalES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm17addNodeToIntervalEPNS_8IntervalES1_")
//</editor-fold>
public static /*inline*/ void addNodeToInterval(Interval /*P*/ Int, Interval /*P*/ I) {
  /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    addNodeToInterval(Int, I);
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 249,
 FQN="llvm::intervals_begin", NM="_ZN4llvm15intervals_beginEPNS_8FunctionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm15intervals_beginEPNS_8FunctionEb")
//</editor-fold>
public static /*inline*/ IntervalIterator<BasicBlock, Function> intervals_begin(Function /*P*/ F) {
  return intervals_begin(F,
               true);
}
public static /*inline*/ IntervalIterator<BasicBlock, Function> intervals_begin(Function /*P*/ F,
               boolean DeleteInts/*= true*/) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    intervals_begin(F,
               DeleteInts);
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 253,
 FQN="llvm::intervals_end", NM="_ZN4llvm13intervals_endEPNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13intervals_endEPNS_8FunctionE")
//</editor-fold>
public static /*inline*/ IntervalIterator<BasicBlock, Function> intervals_end(Function /*P*/ $Prm0) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    intervals_end($Prm0);
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 257,
 FQN="llvm::intervals_begin", NM="_ZN4llvm15intervals_beginERNS_17IntervalPartitionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm15intervals_beginERNS_17IntervalPartitionEb")
//</editor-fold>
public static /*inline*/ IntervalIterator<Interval, IntervalPartition> intervals_begin(final IntervalPartition /*&*/ IP) {
  return intervals_begin(IP, true);
}
public static /*inline*/ IntervalIterator<Interval, IntervalPartition> intervals_begin(final IntervalPartition /*&*/ IP, boolean DeleteIntervals/*= true*/) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    intervals_begin(IP, DeleteIntervals);
}

//<editor-fold defaultstate="collapsed" desc="llvm::intervals_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/IntervalIterator.h", line = 262,
 FQN="llvm::intervals_end", NM="_ZN4llvm13intervals_endERNS_17IntervalPartitionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm13intervals_endERNS_17IntervalPartitionE")
//</editor-fold>
public static /*inline*/ IntervalIterator<Interval, IntervalPartition> intervals_end(final IntervalPartition /*&*/ IP) {
  return /*delegate*/org.llvm.analysis.impl.IntervalIteratorLlvmGlobals.
    intervals_end(IP);
}


/// \brief Helper for client passes to initialize dependent passes for LBFI.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyBFIPassPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 64,
 FQN="llvm::initializeLazyBFIPassPass", NM="_ZN4llvm25initializeLazyBFIPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm25initializeLazyBFIPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyBFIPassPass(final PassRegistry /*&*/ Registry) {
  /*delegate*/org.llvm.analysis.impl.LazyBlockFrequencyInfoLlvmGlobals.
    initializeLazyBFIPassPass(Registry);
}


/// @brief Create a lint pass.
///
/// Check a module or function.

//===----------------------------------------------------------------------===//
//  Implement the public interfaces to this file...
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="llvm::createLintPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 696,
 FQN="llvm::createLintPass", NM="_ZN4llvm14createLintPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm14createLintPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createLintPass() {
  return /*delegate*/org.llvm.analysis.impl.LintLlvmGlobals.
    createLintPass();
}


/// @brief Check a module.
///
/// This should only be used for debugging, because it plays games with
/// PassManagers and stuff.

/// lintModule - Check a module for errors, printing messages on stderr.
///
//<editor-fold defaultstate="collapsed" desc="llvm::lintModule">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 714,
 FQN="llvm::lintModule", NM="_ZN4llvm10lintModuleERKNS_6ModuleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm10lintModuleERKNS_6ModuleE")
//</editor-fold>
public static void lintModule(final /*const*/ Module /*&*/ M) {
  /*delegate*/org.llvm.analysis.impl.LintLlvmGlobals.
    lintModule(M);
}


// lintFunction - Check a function.

/// lintFunction - Check a function for errors, printing messages on stderr.
///
//<editor-fold defaultstate="collapsed" desc="llvm::lintFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 702,
 FQN="llvm::lintFunction", NM="_ZN4llvm12lintFunctionERKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm12lintFunctionERKNS_8FunctionE")
//</editor-fold>
public static void lintFunction(final /*const*/ Function /*&*/ f) {
  /*delegate*/org.llvm.analysis.impl.LintLlvmGlobals.
    lintFunction(f);
}


/// isDereferenceablePointer - Return true if this is always a dereferenceable
/// pointer. If the context instruction is specified perform context-sensitive
/// analysis and return true if the pointer is dereferenceable at the
/// specified instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::isDereferenceablePointer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Loads.h", line = 30,
 FQN="llvm::isDereferenceablePointer", NM="_ZN4llvm24isDereferenceablePointerEPKNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm24isDereferenceablePointerEPKNS_5ValueERKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isDereferenceablePointer(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL) {
  return isDereferenceablePointer(V, DL,
                        (/*const*/ Instruction /*P*/ )null,
                        (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceablePointer(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isDereferenceablePointer(V, DL,
                        CtxI,
                        (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceablePointer(/*const*/ Value /*P*/ V, final /*const*/ DataLayout /*&*/ DL,
                        /*const*/ Instruction /*P*/ CtxI/*= null*/,
                        /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.LoadsLlvmGlobals.
    isDereferenceablePointer(V, DL,
                        CtxI,
                        DT);
}


/// Returns true if V is always a dereferenceable pointer with alignment
/// greater or equal than requested. If the context instruction is specified
/// performs context-sensitive analysis and returns true if the pointer is
/// dereferenceable at the specified instruction.
//<editor-fold defaultstate="collapsed" desc="llvm::isDereferenceableAndAlignedPointer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Loads.h", line = 38,
 FQN="llvm::isDereferenceableAndAlignedPointer", NM="_ZN4llvm34isDereferenceableAndAlignedPointerEPKNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm34isDereferenceableAndAlignedPointerEPKNS_5ValueEjRKNS_10DataLayoutEPKNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isDereferenceableAndAlignedPointer(/*const*/ Value /*P*/ V, /*uint*/int Align,
                                  final /*const*/ DataLayout /*&*/ DL) {
  return isDereferenceableAndAlignedPointer(V, Align,
                                  DL,
                                  (/*const*/ Instruction /*P*/ )null,
                                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceableAndAlignedPointer(/*const*/ Value /*P*/ V, /*uint*/int Align,
                                  final /*const*/ DataLayout /*&*/ DL,
                                  /*const*/ Instruction /*P*/ CtxI/*= null*/) {
  return isDereferenceableAndAlignedPointer(V, Align,
                                  DL,
                                  CtxI,
                                  (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isDereferenceableAndAlignedPointer(/*const*/ Value /*P*/ V, /*uint*/int Align,
                                  final /*const*/ DataLayout /*&*/ DL,
                                  /*const*/ Instruction /*P*/ CtxI/*= null*/,
                                  /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.LoadsLlvmGlobals.
    isDereferenceableAndAlignedPointer(V, Align,
                                  DL,
                                  CtxI,
                                  DT);
}


/// isSafeToLoadUnconditionally - Return true if we know that executing a load
/// from this value cannot trap.
///
/// If DT and ScanFrom are specified this method performs context-sensitive
/// analysis and returns true if it is safe to load immediately before ScanFrom.
///
/// If it is not obviously safe to load from the specified pointer, we do a
/// quick local scan of the basic block containing ScanFrom, to determine if
/// the address is already accessed.
//<editor-fold defaultstate="collapsed" desc="llvm::isSafeToLoadUnconditionally">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Loads.h", line = 52,
 FQN="llvm::isSafeToLoadUnconditionally", NM="_ZN4llvm27isSafeToLoadUnconditionallyEPNS_5ValueEjRKNS_10DataLayoutEPNS_11InstructionEPKNS_13DominatorTreeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm27isSafeToLoadUnconditionallyEPNS_5ValueEjRKNS_10DataLayoutEPNS_11InstructionEPKNS_13DominatorTreeE")
//</editor-fold>
public static boolean isSafeToLoadUnconditionally(Value /*P*/ V, /*uint*/int Align,
                           final /*const*/ DataLayout /*&*/ DL) {
  return isSafeToLoadUnconditionally(V, Align,
                           DL,
                           (Instruction /*P*/ )null,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToLoadUnconditionally(Value /*P*/ V, /*uint*/int Align,
                           final /*const*/ DataLayout /*&*/ DL,
                           Instruction /*P*/ ScanFrom/*= null*/) {
  return isSafeToLoadUnconditionally(V, Align,
                           DL,
                           ScanFrom,
                           (/*const*/ DominatorTree /*P*/ )null);
}
public static boolean isSafeToLoadUnconditionally(Value /*P*/ V, /*uint*/int Align,
                           final /*const*/ DataLayout /*&*/ DL,
                           Instruction /*P*/ ScanFrom/*= null*/,
                           /*const*/ DominatorTree /*P*/ DT/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.LoadsLlvmGlobals.
    isSafeToLoadUnconditionally(V, Align,
                           DL,
                           ScanFrom,
                           DT);
}


/// \brief Scan backwards to see if we have the value of the given load
/// available locally within a small number of instructions.
///
/// You can use this function to scan across multiple blocks: after you call
/// this function, if ScanFrom points at the beginning of the block, it's safe
/// to continue scanning the predecessors.
///
/// Note that performing load CSE requires special care to make sure the
/// metadata is set appropriately.  In particular, aliasing metadata needs
/// to be merged.  (This doesn't matter for store-to-load forwarding because
/// the only relevant load gets deleted.)
///
/// \param Load The load we want to replace.
/// \param ScanBB The basic block to scan. FIXME: This is redundant.
/// \param [in,out] ScanFrom The location to start scanning from. When this
/// function returns, it points at the last instruction scanned.
/// \param MaxInstsToScan The maximum number of instructions to scan. If this
/// is zero, the whole block will be scanned.
/// \param AA Optional pointer to alias analysis, to make the scan more
/// precise.
/// \param [out] AATags The aliasing metadata for the operation which produced
/// the value. FIXME: This is basically useless.
/// \param [out] IsLoadCSE Whether the returned value is a load from the same
/// location in memory, as opposed to the value operand of a store.
///
/// \returns The found value, or nullptr if no value is found.
//<editor-fold defaultstate="collapsed" desc="llvm::FindAvailableLoadedValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/Loads.h", line = 87,
 FQN="llvm::FindAvailableLoadedValue", NM="_ZN4llvm24FindAvailableLoadedValueEPNS_8LoadInstEPNS_10BasicBlockERNS_14ilist_iteratorINS_11InstructionEEEjPNS_9AAResultsEPNS_9AAMDNodesEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm24FindAvailableLoadedValueEPNS_8LoadInstEPNS_10BasicBlockERNS_14ilist_iteratorINS_11InstructionEEEjPNS_9AAResultsEPNS_9AAMDNodesEPb")
//</editor-fold>
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load,
                        BasicBlock /*P*/ ScanBB,
                        final ilist_iterator<Instruction> /*&*/ ScanFrom) {
  return FindAvailableLoadedValue(Load,
                        ScanBB,
                        ScanFrom,
                        DefMaxInstsToScan.$T(),
                        (AAResults /*P*/ )null,
                        (AAMDNodes /*P*/ )null,
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load,
                        BasicBlock /*P*/ ScanBB,
                        final ilist_iterator<Instruction> /*&*/ ScanFrom,
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/) {
  return FindAvailableLoadedValue(Load,
                        ScanBB,
                        ScanFrom,
                        MaxInstsToScan,
                        (AAResults /*P*/ )null,
                        (AAMDNodes /*P*/ )null,
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load,
                        BasicBlock /*P*/ ScanBB,
                        final ilist_iterator<Instruction> /*&*/ ScanFrom,
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/,
                        AAResults /*P*/ AA/*= null*/) {
  return FindAvailableLoadedValue(Load,
                        ScanBB,
                        ScanFrom,
                        MaxInstsToScan,
                        AA,
                        (AAMDNodes /*P*/ )null,
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load,
                        BasicBlock /*P*/ ScanBB,
                        final ilist_iterator<Instruction> /*&*/ ScanFrom,
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/,
                        AAResults /*P*/ AA/*= null*/,
                        AAMDNodes /*P*/ AATags/*= null*/) {
  return FindAvailableLoadedValue(Load,
                        ScanBB,
                        ScanFrom,
                        MaxInstsToScan,
                        AA,
                        AATags,
                        (bool$ptr/*bool P*/ )null);
}
public static Value /*P*/ FindAvailableLoadedValue(LoadInst /*P*/ Load,
                        BasicBlock /*P*/ ScanBB,
                        final ilist_iterator<Instruction> /*&*/ ScanFrom,
                        /*uint*/int MaxInstsToScan/*= DefMaxInstsToScan.operator uintint()*/,
                        AAResults /*P*/ AA/*= null*/,
                        AAMDNodes /*P*/ AATags/*= null*/,
                        bool$ptr/*bool P*/ IsLoadCSE/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.LoadsLlvmGlobals.
    FindAvailableLoadedValue(Load,
                        ScanBB,
                        ScanFrom,
                        MaxInstsToScan,
                        AA,
                        AATags,
                        IsLoadCSE);
}

//<editor-fold defaultstate="collapsed" desc="llvm::stripIntegerCast">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 107,
 FQN="llvm::stripIntegerCast", NM="_ZN4llvm16stripIntegerCastEPNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16stripIntegerCastEPNS_5ValueE")
//</editor-fold>
public static Value /*P*/ stripIntegerCast(Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.LoopAccessAnalysisLlvmGlobals.
    stripIntegerCast(V);
}


/// \brief Return the SCEV corresponding to a pointer with the symbolic stride
/// replaced with constant one, assuming the SCEV predicate associated with
/// \p PSE is true.
///
/// If necessary this method will version the stride of the pointer according
/// to \p PtrToStride and therefore add further predicates to \p PSE.
///
/// If \p OrigPtr is not null, use it to look up the stride value instead of \p
/// Ptr.  \p PtrToStride provides the mapping between the pointer value and its
/// stride as collected by LoopVectorizationLegality::collectStridedAccess.
//<editor-fold defaultstate="collapsed" desc="llvm::replaceSymbolicStrideSCEV">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 114,
 FQN="llvm::replaceSymbolicStrideSCEV", NM="_ZN4llvm25replaceSymbolicStrideSCEVERNS_25PredicatedScalarEvolutionERKNS_8DenseMapIPKNS_5ValueEPS3_NS_12DenseMapInfoIS5_EENS_6detail12DenseMapPairIS5_S6_EEEES6_S6_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm25replaceSymbolicStrideSCEVERNS_25PredicatedScalarEvolutionERKNS_8DenseMapIPKNS_5ValueEPS3_NS_12DenseMapInfoIS5_EENS_6detail12DenseMapPairIS5_S6_EEEES6_S6_")
//</editor-fold>
public static /*const*/ SCEV /*P*/ replaceSymbolicStrideSCEV(final PredicatedScalarEvolution /*&*/ PSE,
                         final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ PtrToStride,
                         Value /*P*/ Ptr) {
  return replaceSymbolicStrideSCEV(PSE,
                         PtrToStride,
                         Ptr, (Value /*P*/ )null);
}
public static /*const*/ SCEV /*P*/ replaceSymbolicStrideSCEV(final PredicatedScalarEvolution /*&*/ PSE,
                         final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ PtrToStride,
                         Value /*P*/ Ptr, Value /*P*/ OrigPtr/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.LoopAccessAnalysisLlvmGlobals.
    replaceSymbolicStrideSCEV(PSE,
                         PtrToStride,
                         Ptr, OrigPtr);
}


/// \brief If the pointer has a constant stride return it in units of its
/// element size.  Otherwise return zero.
///
/// Ensure that it does not wrap in the address space, assuming the predicate
/// associated with \p PSE is true.
///
/// If necessary this method will version the stride of the pointer according
/// to \p PtrToStride and therefore add further predicates to \p PSE.
/// The \p Assume parameter indicates if we are allowed to make additional
/// run-time assumptions.

/// \brief Check whether the access through \p Ptr has a constant stride.
//<editor-fold defaultstate="collapsed" desc="llvm::getPtrStride">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 869,
 FQN="llvm::getPtrStride", NM="_ZN4llvm12getPtrStrideERNS_25PredicatedScalarEvolutionEPNS_5ValueEPKNS_4LoopERKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_S3_EEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm12getPtrStrideERNS_25PredicatedScalarEvolutionEPNS_5ValueEPKNS_4LoopERKNS_8DenseMapIPKS2_S3_NS_12DenseMapInfoIS9_EENS_6detail12DenseMapPairIS9_S3_EEEEb")
//</editor-fold>
public static long/*int64_t*/ getPtrStride(final PredicatedScalarEvolution /*&*/ PSE, Value /*P*/ Ptr,
            /*const*/ Loop /*P*/ Lp) {
  return getPtrStride(PSE, Ptr,
            Lp, new DenseMap</*const*/ Value /*P*/ , Value /*P*/ >(DenseMapInfo$LikePtr.$Info(), (Value /*P*/ )null),
            false);
}
public static long/*int64_t*/ getPtrStride(final PredicatedScalarEvolution /*&*/ PSE, Value /*P*/ Ptr,
            /*const*/ Loop /*P*/ Lp, final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ StridesMap/*= ValueToValueMap()*/) {
  return getPtrStride(PSE, Ptr,
            Lp, StridesMap,
            false);
}
public static long/*int64_t*/ getPtrStride(final PredicatedScalarEvolution /*&*/ PSE, Value /*P*/ Ptr,
            /*const*/ Loop /*P*/ Lp, final /*const*/DenseMap</*const*/ Value /*P*/ , Value /*P*/ > /*&*/ StridesMap/*= ValueToValueMap()*/,
            boolean Assume/*= false*/) {
  return /*delegate*/org.llvm.analysis.impl.LoopAccessAnalysisLlvmGlobals.
    getPtrStride(PSE, Ptr,
            Lp, StridesMap,
            Assume);
}


/// \brief Returns true if the memory operations \p A and \p B are consecutive.
/// This is a simple API that does not depend on the analysis pass.

/// Returns true if the memory operations \p A and \p B are consecutive.
//<editor-fold defaultstate="collapsed" desc="llvm::isConsecutiveAccess">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 997,
 FQN="llvm::isConsecutiveAccess", NM="_ZN4llvm19isConsecutiveAccessEPNS_5ValueES1_RKNS_10DataLayoutERNS_15ScalarEvolutionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm19isConsecutiveAccessEPNS_5ValueES1_RKNS_10DataLayoutERNS_15ScalarEvolutionEb")
//</editor-fold>
public static boolean isConsecutiveAccess(Value /*P*/ A, Value /*P*/ B, final /*const*/ DataLayout /*&*/ DL,
                   final ScalarEvolution /*&*/ SE) {
  return isConsecutiveAccess(A, B, DL,
                   SE, true);
}
public static boolean isConsecutiveAccess(Value /*P*/ A, Value /*P*/ B, final /*const*/ DataLayout /*&*/ DL,
                   final ScalarEvolution /*&*/ SE, boolean CheckType/*= true*/) {
  return /*delegate*/org.llvm.analysis.impl.LoopAccessAnalysisLlvmGlobals.
    isConsecutiveAccess(A, B, DL,
                   SE, CheckType);
}


/// Return true if the given expression is safe to expand in the sense that
/// all materialized values are safe to speculate.
//<editor-fold defaultstate="collapsed" desc="llvm::isSafeToExpand">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp", line = 2205,
 FQN="llvm::isSafeToExpand", NM="_ZN4llvm14isSafeToExpandEPKNS_4SCEVERNS_15ScalarEvolutionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionExpander.cpp -nm=_ZN4llvm14isSafeToExpandEPKNS_4SCEVERNS_15ScalarEvolutionE")
//</editor-fold>
public static boolean isSafeToExpand(/*const*/ SCEV /*P*/ S, final ScalarEvolution /*&*/ SE) {
  return /*delegate*/org.llvm.analysis.impl.ScalarEvolutionExpanderLlvmGlobals.
    isSafeToExpand(S, SE);
}


/// \brief Identify if the intrinsic is trivially vectorizable.
/// This method returns true if the intrinsic's argument types are all
/// scalars for the scalar form of the intrinsic and all vectors for
/// the vector form of the intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::isTriviallyVectorizable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 39,
 FQN="llvm::isTriviallyVectorizable", NM="_ZN4llvm23isTriviallyVectorizableENS_9Intrinsic2IDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm23isTriviallyVectorizableENS_9Intrinsic2IDE")
//</editor-fold>
public static boolean isTriviallyVectorizable(/*Intrinsic.ID*/int ID) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    isTriviallyVectorizable(ID);
}


/// \brief Identifies if the intrinsic has a scalar operand. It checks for
/// ctlz,cttz and powi special intrinsics whose argument is scalar.
//<editor-fold defaultstate="collapsed" desc="llvm::hasVectorInstrinsicScalarOpd">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 43,
 FQN="llvm::hasVectorInstrinsicScalarOpd", NM="_ZN4llvm28hasVectorInstrinsicScalarOpdENS_9Intrinsic2IDEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm28hasVectorInstrinsicScalarOpdENS_9Intrinsic2IDEj")
//</editor-fold>
public static boolean hasVectorInstrinsicScalarOpd(/*Intrinsic.ID*/int ID, /*uint*/int ScalarOpdIdx) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    hasVectorInstrinsicScalarOpd(ID, ScalarOpdIdx);
}


/// \brief Returns intrinsic ID for call.
/// For the input call instruction it finds mapping intrinsic and returns
/// its intrinsic ID, in case it does not found it return not_intrinsic.
//<editor-fold defaultstate="collapsed" desc="llvm::getVectorIntrinsicIDForCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 48,
 FQN="llvm::getVectorIntrinsicIDForCall", NM="_ZN4llvm27getVectorIntrinsicIDForCallEPKNS_8CallInstEPKNS_17TargetLibraryInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm27getVectorIntrinsicIDForCallEPKNS_8CallInstEPKNS_17TargetLibraryInfoE")
//</editor-fold>
public static /*Intrinsic.ID*/int getVectorIntrinsicIDForCall(/*const*/ CallInst /*P*/ CI,
                           /*const*/ TargetLibraryInfo /*P*/ TLI) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    getVectorIntrinsicIDForCall(CI,
                           TLI);
}


/// \brief Find the operand of the GEP that should be checked for consecutive
/// stores. This ignores trailing indices that have no effect on the final
/// pointer.
//<editor-fold defaultstate="collapsed" desc="llvm::getGEPInductionOperand">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 54,
 FQN="llvm::getGEPInductionOperand", NM="_ZN4llvm22getGEPInductionOperandEPKNS_17GetElementPtrInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm22getGEPInductionOperandEPKNS_17GetElementPtrInstE")
//</editor-fold>
public static /*uint*/int getGEPInductionOperand(/*const*/ GetElementPtrInst /*P*/ Gep) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    getGEPInductionOperand(Gep);
}


/// \brief If the argument is a GEP, then returns the operand identified by
/// getGEPInductionOperand. However, if there is some other non-loop-invariant
/// operand, it returns that instead.
//<editor-fold defaultstate="collapsed" desc="llvm::stripGetElementPtr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 59,
 FQN="llvm::stripGetElementPtr", NM="_ZN4llvm18stripGetElementPtrEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm18stripGetElementPtrEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE")
//</editor-fold>
public static Value /*P*/ stripGetElementPtr(Value /*P*/ Ptr, ScalarEvolution /*P*/ SE, Loop /*P*/ Lp) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    stripGetElementPtr(Ptr, SE, Lp);
}


/// \brief If a value has only one user that is a CastInst, return it.
//<editor-fold defaultstate="collapsed" desc="llvm::getUniqueCastUse">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 62,
 FQN="llvm::getUniqueCastUse", NM="_ZN4llvm16getUniqueCastUseEPNS_5ValueEPNS_4LoopEPNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm16getUniqueCastUseEPNS_5ValueEPNS_4LoopEPNS_4TypeE")
//</editor-fold>
public static Value /*P*/ getUniqueCastUse(Value /*P*/ Ptr, Loop /*P*/ Lp, Type /*P*/ Ty) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    getUniqueCastUse(Ptr, Lp, Ty);
}


/// \brief Get the stride of a pointer access in a loop. Looks for symbolic
/// strides "a[i*stride]". Returns the symbolic stride, or null otherwise.
//<editor-fold defaultstate="collapsed" desc="llvm::getStrideFromPointer">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 66,
 FQN="llvm::getStrideFromPointer", NM="_ZN4llvm20getStrideFromPointerEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm20getStrideFromPointerEPNS_5ValueEPNS_15ScalarEvolutionEPNS_4LoopE")
//</editor-fold>
public static Value /*P*/ getStrideFromPointer(Value /*P*/ Ptr, ScalarEvolution /*P*/ SE, Loop /*P*/ Lp) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    getStrideFromPointer(Ptr, SE, Lp);
}


/// \brief Given a vector and an element number, see if the scalar value is
/// already around as a register, for example if it were inserted then extracted
/// from the vector.
//<editor-fold defaultstate="collapsed" desc="llvm::findScalarElement">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 71,
 FQN="llvm::findScalarElement", NM="_ZN4llvm17findScalarElementEPNS_5ValueEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm17findScalarElementEPNS_5ValueEj")
//</editor-fold>
public static Value /*P*/ findScalarElement(Value /*P*/ V, /*uint*/int EltNo) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    findScalarElement(V, EltNo);
}


/// \brief Get splat value if the input is a splat vector or return nullptr.
/// The value may be extracted from a splat constants vector or from
/// a sequence of instructions that broadcast a single value into a vector.
//<editor-fold defaultstate="collapsed" desc="llvm::getSplatValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 76,
 FQN="llvm::getSplatValue", NM="_ZN4llvm13getSplatValueEPKNS_5ValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm13getSplatValueEPKNS_5ValueE")
//</editor-fold>
public static /*const*/ Value /*P*/ getSplatValue(/*const*/ Value /*P*/ V) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    getSplatValue(V);
}


/// \brief Compute a map of integer instructions to their minimum legal type
/// size.
///
/// C semantics force sub-int-sized values (e.g. i8, i16) to be promoted to int
/// type (e.g. i32) whenever arithmetic is performed on them.
///
/// For targets with native i8 or i16 operations, usually InstCombine can shrink
/// the arithmetic type down again. However InstCombine refuses to create
/// illegal types, so for targets without i8 or i16 registers, the lengthening
/// and shrinking remains.
///
/// Most SIMD ISAs (e.g. NEON) however support vectors of i8 or i16 even when
/// their scalar equivalents do not, so during vectorization it is important to
/// remove these lengthens and truncates when deciding the profitability of
/// vectorization.
///
/// This function analyzes the given range of instructions and determines the
/// minimum type size each can be converted to. It attempts to remove or
/// minimize type size changes across each def-use chain, so for example in the
/// following code:
///
///   %1 = load i8, i8*
///   %2 = add i8 %1, 2
///   %3 = load i16, i16*
///   %4 = zext i8 %2 to i32
///   %5 = zext i16 %3 to i32
///   %6 = add i32 %4, %5
///   %7 = trunc i32 %6 to i16
///
/// Instruction %6 must be done at least in i16, so computeMinimumValueSizes
/// will return: {%1: 16, %2: 16, %3: 16, %4: 16, %5: 16, %6: 16, %7: 16}.
///
/// If the optional TargetTransformInfo is provided, this function tries harder
/// to do less work by only looking at illegal types.
//<editor-fold defaultstate="collapsed" desc="llvm::computeMinimumValueSizes">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 112,
 FQN="llvm::computeMinimumValueSizes", NM="_ZN4llvm24computeMinimumValueSizesENS_8ArrayRefIPNS_10BasicBlockEEERNS_12DemandedBitsEPKNS_19TargetTransformInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm24computeMinimumValueSizesENS_8ArrayRefIPNS_10BasicBlockEEERNS_12DemandedBitsEPKNS_19TargetTransformInfoE")
//</editor-fold>
public static MapVectorPtrULong<Instruction /*P*/ > computeMinimumValueSizes(ArrayRef<BasicBlock /*P*/ > Blocks,
                        final DemandedBits /*&*/ DB) {
  return computeMinimumValueSizes(Blocks,
                        DB,
                        (/*const*/ TargetTransformInfo /*P*/ )null);
}
public static MapVectorPtrULong<Instruction /*P*/ > computeMinimumValueSizes(ArrayRef<BasicBlock /*P*/ > Blocks,
                        final DemandedBits /*&*/ DB,
                        /*const*/ TargetTransformInfo /*P*/ TTI/*= null*/) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    computeMinimumValueSizes(Blocks,
                        DB,
                        TTI);
}


/// Specifically, let Kinds = [MD_tbaa, MD_alias_scope, MD_noalias, MD_fpmath,
/// MD_nontemporal].  For K in Kinds, we get the MDNode for K from each of the
/// elements of VL, compute their "intersection" (i.e., the most generic
/// metadata value that covers all of the individual values), and set I's
/// metadata for M equal to the intersection value.
///
/// This function always sets a (possibly null) value for each K in Kinds.
//<editor-fold defaultstate="collapsed" desc="llvm::propagateMetadata">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/VectorUtils.h", line = 124,
 FQN="llvm::propagateMetadata", NM="_ZN4llvm17propagateMetadataEPNS_11InstructionENS_8ArrayRefIPNS_5ValueEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm17propagateMetadataEPNS_11InstructionENS_8ArrayRefIPNS_5ValueEEE")
//</editor-fold>
public static Instruction /*P*/ propagateMetadata(Instruction /*P*/ I, ArrayRef<Value /*P*/ > VL) {
  return /*delegate*/org.llvm.analysis.impl.VectorUtilsLlvmGlobals.
    propagateMetadata(I, VL);
}


//===----------------------------------------------------------------------===//
/// Stable LoopInfo Analysis - Build a loop tree using stable iterators so the
/// result does / not depend on use list (block predecessor) order.
///

/// Discover a subloop with the specified backedges such that: All blocks within
/// this loop are mapped to this loop or a subloop. And all subloops within this
/// loop have their parent loop set to this loop or a subloop.
/*template <class BlockT, class LoopT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::discoverAndMapSubloop">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/LoopInfoImpl.h", line = 346,
 FQN="llvm::discoverAndMapSubloop", NM="Tpl__ZN4llvmL21discoverAndMapSubloopEPT0_NS_8ArrayRefIPT_EEPNS_12LoopInfoBaseIS3_S0_EERKNS_17DominatorTreeBaseIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=Tpl__ZN4llvmL21discoverAndMapSubloopEPT0_NS_8ArrayRefIPT_EEPNS_12LoopInfoBaseIS3_S0_EERKNS_17DominatorTreeBaseIS3_EE")
//</editor-fold>
public static </*class*/ BlockT, /*class*/ LoopT> void discoverAndMapSubloop(LoopT /*P*/ L, ArrayRef<BlockT /*P*/ > Backedges,
                     LoopInfoBase<BlockT, LoopT> /*P*/ LI,
                     final /*const*/ DominatorTreeBase<BlockT> /*&*/ DomTree) {
  /*delegate*/org.llvm.analysis.impl.LoopInfoImplLlvmGlobals.
    discoverAndMapSubloop(L, Backedges,
                     LI,
                     DomTree);
}


/// Print a RegionNode.
/*template <class Tr> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionInfo.h", line = 968,
 FQN="llvm::operator<<", NM="Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_14RegionNodeBaseIT_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=Tpl__ZN4llvmlsERNS_11raw_ostreamERKNS_14RegionNodeBaseIT_EE")
//</editor-fold>
public static /*inline*/ </*class*/ Tr> raw_ostream /*&*/ $out_raw_ostream_RegionNodeBaseT$Tr$C(final raw_ostream /*&*/ OS,
                                     final /*const*/ RegionNodeBase /*&*/ Node) {
  return /*delegate*/org.llvm.analysis.impl.RegionInfoLlvmGlobals.
    $out_raw_ostream_RegionNodeBase$Tr$C(OS,
                                     Node);
}

/*template <class NodeType, class BlockT, class RegionT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::succ_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 236,
 FQN="llvm::succ_begin", NM="Tpl__ZN4llvm10succ_beginEPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=Tpl__ZN4llvm10succ_beginEPT_")
//</editor-fold>
public static /*inline*/ </*class*/ NodeType, /*class*/ BlockT, /*class*/ RegionT> RNSuccIterator<NodeType, BlockT, RegionT> succ_begin(NodeType /*P*/ Node) {
  return /*delegate*/org.llvm.analysis.impl.RegionIteratorLlvmGlobals.
    succ_begin(Node);
}

/*template <class NodeType, class BlockT, class RegionT> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="llvm::succ_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/RegionIterator.h", line = 241,
 FQN="llvm::succ_end", NM="Tpl__ZN4llvm8succ_endEPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=Tpl__ZN4llvm8succ_endEPT_")
//</editor-fold>
public static /*inline*/ </*class*/ NodeType, /*class*/ BlockT, /*class*/ RegionT> RNSuccIterator<NodeType, BlockT, RegionT> succ_end(NodeType /*P*/ Node) {
  return /*delegate*/org.llvm.analysis.impl.RegionIteratorLlvmGlobals.
    succ_end(Node);
}

//<editor-fold defaultstate="collapsed" desc="llvm::createRegionViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 222,
 FQN="llvm::createRegionViewerPass", NM="_ZN4llvm22createRegionViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm22createRegionViewerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createRegionViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    createRegionViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createRegionOnlyViewerPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 226,
 FQN="llvm::createRegionOnlyViewerPass", NM="_ZN4llvm26createRegionOnlyViewerPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm26createRegionOnlyViewerPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createRegionOnlyViewerPass() {
  return /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    createRegionOnlyViewerPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createRegionPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 216,
 FQN="llvm::createRegionPrinterPass", NM="_ZN4llvm23createRegionPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm23createRegionPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createRegionPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    createRegionPrinterPass();
}

//<editor-fold defaultstate="collapsed" desc="llvm::createRegionOnlyPrinterPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 218,
 FQN="llvm::createRegionOnlyPrinterPass", NM="_ZN4llvm27createRegionOnlyPrinterPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm27createRegionOnlyPrinterPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createRegionOnlyPrinterPass() {
  return /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    createRegionOnlyPrinterPass();
}

/// @brief Open a viewer to display the GraphViz vizualization of the analysis
/// result.
///
/// Practical to call in the debugger.
/// Includes the instructions in each BasicBlock.
///
/// @param RI The analysis to display.
//<editor-fold defaultstate="collapsed" desc="llvm::viewRegion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 256,
 FQN="llvm::viewRegion", NM="_ZN4llvm10viewRegionEPNS_10RegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm10viewRegionEPNS_10RegionInfoE")
//</editor-fold>
public static void viewRegion(RegionInfo /*P*/ RI) {
  /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    viewRegion(RI);
}


/// @brief Analyze the regions of a function and open its GraphViz
/// visualization in a viewer.
///
/// Useful to call in the debugger.
/// Includes the instructions in each BasicBlock.
/// The result of a new analysis may differ from the RegionInfo the pass
/// manager currently holds.
///
/// @param F Function to analyze.
//<editor-fold defaultstate="collapsed" desc="llvm::viewRegion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 258,
 FQN="llvm::viewRegion", NM="_ZN4llvm10viewRegionEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm10viewRegionEPKNS_8FunctionE")
//</editor-fold>
public static void viewRegion(/*const*/ Function /*P*/ F) {
  /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    viewRegion(F);
}


/// @brief Open a viewer to display the GraphViz vizualization of the analysis
/// result.
///
/// Useful to call in the debugger.
/// Shows only the BasicBlock names without their instructions.
///
/// @param RI The analysis to display.
//<editor-fold defaultstate="collapsed" desc="llvm::viewRegionOnly">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 262,
 FQN="llvm::viewRegionOnly", NM="_ZN4llvm14viewRegionOnlyEPNS_10RegionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14viewRegionOnlyEPNS_10RegionInfoE")
//</editor-fold>
public static void viewRegionOnly(RegionInfo /*P*/ RI) {
  /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    viewRegionOnly(RI);
}


/// @brief Analyze the regions of a function and open its GraphViz
/// visualization in a viewer.
///
/// Useful to call in the debugger.
/// Shows only the BasicBlock names without their instructions.
/// The result of a new analysis may differ from the RegionInfo the pass
/// manager currently holds.
///
/// @param F Function to analyze.
//<editor-fold defaultstate="collapsed" desc="llvm::viewRegionOnly">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 264,
 FQN="llvm::viewRegionOnly", NM="_ZN4llvm14viewRegionOnlyEPKNS_8FunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm14viewRegionOnlyEPKNS_8FunctionE")
//</editor-fold>
public static void viewRegionOnly(/*const*/ Function /*P*/ F) {
  /*delegate*/org.llvm.analysis.impl.RegionPrinterLlvmGlobals.
    viewRegionOnly(F);
}


/// Given a call to the intrinsic @llvm.type.test, find all devirtualizable
/// call sites based on the call and return them in DevirtCalls.
//<editor-fold defaultstate="collapsed" desc="llvm::findDevirtualizableCallsForTypeTest">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeMetadataUtils.cpp", line = 63,
 FQN="llvm::findDevirtualizableCallsForTypeTest", NM="_ZN4llvm35findDevirtualizableCallsForTypeTestERNS_15SmallVectorImplINS_14DevirtCallSiteEEERNS0_IPNS_8CallInstEEES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/TypeMetadataUtils.cpp -nm=_ZN4llvm35findDevirtualizableCallsForTypeTestERNS_15SmallVectorImplINS_14DevirtCallSiteEEERNS0_IPNS_8CallInstEEES5_")
//</editor-fold>
public static void findDevirtualizableCallsForTypeTest(final SmallVectorImpl<DevirtCallSite> /*&*/ DevirtCalls,
                                   final SmallVectorImpl<CallInst /*P*/ > /*&*/ Assumes, CallInst /*P*/ CI) {
  /*delegate*/org.llvm.analysis.impl.TypeMetadataUtilsLlvmGlobals.
    findDevirtualizableCallsForTypeTest(DevirtCalls,
                                   Assumes, CI);
}


/// Given a call to the intrinsic @llvm.type.checked.load, find all
/// devirtualizable call sites based on the call and return them in DevirtCalls.
//<editor-fold defaultstate="collapsed" desc="llvm::findDevirtualizableCallsForTypeCheckedLoad">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeMetadataUtils.cpp", line = 87,
 FQN="llvm::findDevirtualizableCallsForTypeCheckedLoad", NM="_ZN4llvm42findDevirtualizableCallsForTypeCheckedLoadERNS_15SmallVectorImplINS_14DevirtCallSiteEEERNS0_IPNS_11InstructionEEES7_RbPNS_8CallInstE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/TypeMetadataUtils.cpp -nm=_ZN4llvm42findDevirtualizableCallsForTypeCheckedLoadERNS_15SmallVectorImplINS_14DevirtCallSiteEEERNS0_IPNS_11InstructionEEES7_RbPNS_8CallInstE")
//</editor-fold>
public static void findDevirtualizableCallsForTypeCheckedLoad(final SmallVectorImpl<DevirtCallSite> /*&*/ DevirtCalls,
                                          final SmallVectorImpl<Instruction /*P*/ > /*&*/ LoadedPtrs,
                                          final SmallVectorImpl<Instruction /*P*/ > /*&*/ Preds, final bool$ref/*bool &*/ HasNonCallUses, CallInst /*P*/ CI) {
  /*delegate*/org.llvm.analysis.impl.TypeMetadataUtilsLlvmGlobals.
    findDevirtualizableCallsForTypeCheckedLoad(DevirtCalls,
                                          LoadedPtrs,
                                          Preds, HasNonCallUses, CI);
}


/// Create a demanded bits analysis pass.
//<editor-fold defaultstate="collapsed" desc="llvm::createDemandedBitsWrapperPass">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/include/llvm/Analysis/DemandedBits.h", line = 113,
 FQN="llvm::createDemandedBitsWrapperPass", NM="_ZN4llvm29createDemandedBitsWrapperPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/lib/Analysis/VectorUtils.cpp -nm=_ZN4llvm29createDemandedBitsWrapperPassEv")
//</editor-fold>
public static FunctionPass /*P*/ createDemandedBitsWrapperPass() {
  return /*delegate*/org.llvm.analysis.impl.DemandedBitsLlvmGlobals.
    createDemandedBitsWrapperPass();
}

/// DefMaxInstsToScan - the default number of maximum instructions
/// to scan in the block, used by FindAvailableLoadedValue().
/// FindAvailableLoadedValue() was introduced in r60148, to improve jump
/// threading in part by eliminating partially redundant loads.
/// At that point, the value of MaxInstsToScan was already set to '6'
/// without documented explanation.
@Converted(kind = Converted.Kind.MANUAL, source = "${LLVM_SRC}/llvm/lib/Analysis/Loads.cpp", line = 300)
public static optUInt DefMaxInstsToScan/*J*/=  new optUInt($("available-load-scan-limit"), OptionHidden.Hidden, init(6),
    new desc($("Use this to specify the default maximum number of instructions \n" +
    "to scan backward from a given instruction, when searching for \n" +
    "available loaded value")));


} // END OF class AnalysisLlvmGlobals
