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
package org.llvm.analysis.impl;

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
import org.llvm.ir.*;
import org.llvm.pass.*;
import static org.llvm.ir.PassManagerGlobals.*;
import static org.llvm.analysis.java.AnalysisFunctionPointers.*;
import org.llvm.analysis.*;


//<editor-fold defaultstate="collapsed" desc="static type NsAnalysisLlvmStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 NM="org.llvm.analysis.impl.NsAnalysisLlvmStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp ${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm13createLAAPassEv;_ZN4llvm18initializeAnalysisERNS_12PassRegistryE;_ZN4llvm18initializeLintPassERNS_12PassRegistryE;_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE;_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE;_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE;_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE;_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE;_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE;_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE;_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE;_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE;_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE;_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE;_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE;_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE;_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE;_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE;_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE;_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE;_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE;_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE;_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE;_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE;_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE;_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE;_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE;_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE;_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE;_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE;_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE;_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE;_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE;_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE;_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE;_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE;_ZN4llvmlsERNS_11raw_ostreamERKN12_GLOBAL__N_113LVILatticeValE; -static-type=NsAnalysisLlvmStatics -package=org.llvm.analysis.impl")
//</editor-fold>
public final class NsAnalysisLlvmStatics {

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAAResultsWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 567,
 FQN="llvm::initializeAAResultsWrapperPassPass", NM="_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAAResultsWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeExternalAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 542,
 FQN="llvm::initializeExternalAAWrapperPassPass", NM="_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeExternalAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAAEvalLegacyPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 385,
 FQN="llvm::initializeAAEvalLegacyPassPass", NM="_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAAEvalLegacyPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAliasSetPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 717,
 FQN="llvm::initializeAliasSetPrinterPass", NM="_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAliasSetPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// Initialize all passes linked into the Analysis library.

/// initializeAnalysis - Initialize all passes linked into the Analysis library.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeAnalysis">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp", line = 22,
 FQN="llvm::initializeAnalysis", NM="_ZN4llvm18initializeAnalysisERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Analysis.cpp -nm=_ZN4llvm18initializeAnalysisERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAnalysis(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeAssumptionCacheTrackerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 138,
 FQN="llvm::initializeAssumptionCacheTrackerPass", NM="_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeAssumptionCacheTrackerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBasicAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1692,
 FQN="llvm::initializeBasicAAWrapperPassPass", NM="_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBasicAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockFrequencyInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 217,
 FQN="llvm::initializeBlockFrequencyInfoWrapperPassPass", NM="_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBlockFrequencyInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchProbabilityInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 33,
 FQN="llvm::initializeBranchProbabilityInfoWrapperPassPass", NM="_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeBranchProbabilityInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 136,
 FQN="llvm::initializeCFGOnlyPrinterPass", NM="_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 69,
 FQN="llvm::initializeCFGOnlyViewerPass", NM="_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 103,
 FQN="llvm::initializeCFGPrinterPass", NM="_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 46,
 FQN="llvm::initializeCFGViewerPass", NM="_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFGViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLAndersAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 565,
 FQN="llvm::initializeCFLAndersAAWrapperPassPass", NM="_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFLAndersAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLSteensAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 423,
 FQN="llvm::initializeCFLSteensAAWrapperPassPass", NM="_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCFLSteensAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphPrinterLegacyPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 336,
 FQN="llvm::initializeCallGraphPrinterLegacyPassPass", NM="_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphPrinterLegacyPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 293,
 FQN="llvm::initializeCallGraphWrapperPassPass", NM="_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphDOTPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 81,
 FQN="llvm::initializeCallGraphDOTPrinterPass", NM="_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphDOTPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 77,
 FQN="llvm::initializeCallGraphViewerPass", NM="_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCallGraphViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeCostModelAnalysisPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 72,
 FQN="llvm::initializeCostModelAnalysisPass", NM="_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeCostModelAnalysisPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDelinearizationPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp", line = 138,
 FQN="llvm::initializeDelinearizationPass", NM="_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp -nm=_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDelinearizationPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDemandedBitsWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 50,
 FQN="llvm::initializeDemandedBitsWrapperPassPass", NM="_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDemandedBitsWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDependenceAnalysisWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 132,
 FQN="llvm::initializeDependenceAnalysisWrapperPassPass", NM="_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDependenceAnalysisWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDivergenceAnalysisPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 272,
 FQN="llvm::initializeDivergenceAnalysisPass", NM="_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDivergenceAnalysisPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 232,
 FQN="llvm::initializeDomOnlyPrinterPass", NM="_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 154,
 FQN="llvm::initializeDomOnlyViewerPass", NM="_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 227,
 FQN="llvm::initializeDomPrinterPass", NM="_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDomViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 150,
 FQN="llvm::initializeDomViewerPass", NM="_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDomViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 243,
 FQN="llvm::initializePostDomOnlyPrinterPass", NM="_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 163,
 FQN="llvm::initializePostDomOnlyViewerPass", NM="_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 238,
 FQN="llvm::initializePostDomPrinterPass", NM="_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 159,
 FQN="llvm::initializePostDomViewerPass", NM="_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDomViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeDominanceFrontierWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 26,
 FQN="llvm::initializeDominanceFrontierWrapperPassPass", NM="_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeDominanceFrontierWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalsAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 953,
 FQN="llvm::initializeGlobalsAAWrapperPassPass", NM="_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeGlobalsAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIVUsersWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 62,
 FQN="llvm::initializeIVUsersWrapperPassPass", NM="_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIVUsersWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCountPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 70,
 FQN="llvm::initializeInstCountPass", NM="_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeInstCountPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeIntervalPartitionPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 19,
 FQN="llvm::initializeIntervalPartitionPass", NM="_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeIntervalPartitionPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyBlockFrequencyInfoPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 29,
 FQN="llvm::initializeLazyBlockFrequencyInfoPassPass", NM="_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyBlockFrequencyInfoPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyValueInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 46,
 FQN="llvm::initializeLazyValueInfoWrapperPassPass", NM="_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLazyValueInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::operator<<">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 283,
 FQN="llvm::operator<<", NM="_ZN4llvmlsERNS_11raw_ostreamERKN12_GLOBAL__N_113LVILatticeValE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvmlsERNS_11raw_ostreamERKN12_GLOBAL__N_113LVILatticeValE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_LVILatticeVal$C(final raw_ostream /*&*/ OS, final /*const*/ LVILatticeVal /*&*/ Val)/* __attribute__((used))*/ {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLintPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 171,
 FQN="llvm::initializeLintPass", NM="_ZN4llvm18initializeLintPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm18initializeLintPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLintPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopAccessLegacyAnalysisPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 2021,
 FQN="llvm::initializeLoopAccessLegacyAnalysisPass", NM="_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopAccessLegacyAnalysisPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::createLAAPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 2057,
 FQN="llvm::createLAAPass", NM="_ZN4llvm13createLAAPassEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm13createLAAPassEv")
//</editor-fold>
public static Pass /*P*/ createLAAPass() {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp", line = 690,
 FQN="llvm::initializeLoopInfoWrapperPassPass", NM="_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopInfo.cpp -nm=_ZN4llvm33initializeLoopInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeLoopInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDepPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 83,
 FQN="llvm::initializeMemDepPrinterPass", NM="_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemDepPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDerefPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp", line = 47,
 FQN="llvm::initializeMemDerefPrinterPass", NM="_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp -nm=_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemDerefPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeMemoryDependenceWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1681,
 FQN="llvm::initializeMemoryDependenceWrapperPassPass", NM="_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeMemoryDependenceWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleDebugInfoPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp", line = 46,
 FQN="llvm::initializeModuleDebugInfoPrinterPass", NM="_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp -nm=_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeModuleDebugInfoPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleSummaryIndexWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 181,
 FQN="llvm::initializeModuleSummaryIndexWrapperPassPass", NM="_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeModuleSummaryIndexWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 139,
 FQN="llvm::initializeObjCARCAAWrapperPassPass", NM="_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeObjCARCAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizationRemarkEmitterWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp", line = 87,
 FQN="llvm::initializeOptimizationRemarkEmitterWrapperPassPass", NM="_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeOptimizationRemarkEmitterWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializePostDominatorTreeWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp", line = 31,
 FQN="llvm::initializePostDominatorTreeWrapperPassPass", NM="_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp -nm=_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializePostDominatorTreeWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeProfileSummaryInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 134,
 FQN="llvm::initializeProfileSummaryInfoWrapperPassPass", NM="_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeProfileSummaryInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionInfoPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 168,
 FQN="llvm::initializeRegionInfoPassPass", NM="_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionInfoPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 204,
 FQN="llvm::initializeRegionOnlyPrinterPass", NM="_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionOnlyPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 212,
 FQN="llvm::initializeRegionOnlyViewerPass", NM="_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionOnlyViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionPrinterPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 201,
 FQN="llvm::initializeRegionPrinterPass", NM="_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionPrinterPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionViewerPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 209,
 FQN="llvm::initializeRegionViewerPass", NM="_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeRegionViewerPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarEvolutionWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10033,
 FQN="llvm::initializeScalarEvolutionWrapperPassPass", NM="_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScalarEvolutionWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeSCEVAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp", line = 123,
 FQN="llvm::initializeSCEVAAWrapperPassPass", NM="_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp -nm=_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeSCEVAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeScopedNoAliasAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 183,
 FQN="llvm::initializeScopedNoAliasAAWrapperPassPass", NM="_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeScopedNoAliasAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Register the basic pass.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetLibraryInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1168,
 FQN="llvm::initializeTargetLibraryInfoWrapperPassPass", NM="_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetLibraryInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Register the basic pass.
//<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetTransformInfoWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 440,
 FQN="llvm::initializeTargetTransformInfoWrapperPassPass", NM="_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTargetTransformInfoWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::initializeTypeBasedAAWrapperPassPass">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp", line = 593,
 FQN="llvm::initializeTypeBasedAAWrapperPassPass", NM="_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.analysis/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TypeBasedAliasAnalysis.cpp -nm=_ZN4llvm36initializeTypeBasedAAWrapperPassPassERNS_12PassRegistryE")
//</editor-fold>
public static void initializeTypeBasedAAWrapperPassPass(final PassRegistry /*&*/ Registry) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class NsAnalysisLlvmStatics
