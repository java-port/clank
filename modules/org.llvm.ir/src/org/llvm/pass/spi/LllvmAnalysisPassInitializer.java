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

import org.clank.support.Converted;
import org.llvm.pass.PassRegistry;

/**
 * Interface for ServiceProvider to be able impl delegation into llvm/Analysis module from llvm/IR.
 * @author Vladimir Voskresensky
 */
public interface LllvmAnalysisPassInitializer {

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAssumptionCacheTrackerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 138,
   FQN="llvm::initializeAssumptionCacheTrackerPass", NM="_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE")
  //</editor-fold>  
  public void initializeAssumptionCacheTrackerPass(PassRegistry Registry);

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 293,
   FQN="llvm::initializeCallGraphWrapperPassPass", NM="_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>  
  public void initializeCallGraphWrapperPassPass(PassRegistry Registry);

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeProfileSummaryInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 134,
   FQN="llvm::initializeProfileSummaryInfoWrapperPassPass", NM="_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>  
  public void initializeProfileSummaryInfoWrapperPassPass(PassRegistry Registry);

  // Register the basic pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetLibraryInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1168,
   FQN="llvm::initializeTargetLibraryInfoWrapperPassPass", NM="_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>  
  public void initializeTargetLibraryInfoWrapperPassPass(PassRegistry Registry);

  public void initializeAAResultsWrapperPassPass(PassRegistry Registry);

  public void initializeExternalAAWrapperPassPass(PassRegistry Registry);

  public void initializeAAEvalLegacyPassPass(PassRegistry Registry);

  public void initializeAliasSetPrinterPass(PassRegistry Registry);

  public void initializeBasicAAWrapperPassPass(PassRegistry Registry);

  public void initializeBranchProbabilityInfoWrapperPassPass(PassRegistry Registry);

  public void initializeCFGOnlyPrinterPass(PassRegistry Registry);

  public void initializeCFGOnlyViewerPass(PassRegistry Registry);

  public void initializeCFGPrinterPass(PassRegistry Registry);

  public void initializeCFGViewerPass(PassRegistry Registry);

  public void initializeCFLAndersAAWrapperPassPass(PassRegistry Registry);

  public void initializeCFLSteensAAWrapperPassPass(PassRegistry Registry);

  public void initializeCallGraphPrinterLegacyPassPass(PassRegistry Registry);

  public void initializeCallGraphDOTPrinterPass(PassRegistry Registry);

  public void initializeCallGraphViewerPass(PassRegistry Registry);

  public void initializeDelinearizationPass(PassRegistry Registry);

  public void initializeDemandedBitsWrapperPassPass(PassRegistry Registry);

  public void initializeDependenceAnalysisWrapperPassPass(PassRegistry Registry);

  public void initializeDivergenceAnalysisPass(PassRegistry Registry);

  public void initializeDomOnlyPrinterPass(PassRegistry Registry);

  public void initializeDomOnlyViewerPass(PassRegistry Registry);

  public void initializeDomPrinterPass(PassRegistry Registry);

  public void initializeDomViewerPass(PassRegistry Registry);

  public void initializePostDomOnlyPrinterPass(PassRegistry Registry);

  public void initializePostDomOnlyViewerPass(PassRegistry Registry);

  public void initializePostDomPrinterPass(PassRegistry Registry);

  public void initializePostDomViewerPass(PassRegistry Registry);

  public void initializeDominanceFrontierWrapperPassPass(PassRegistry Registry);

  public void initializeGlobalsAAWrapperPassPass(PassRegistry Registry);

  public void initializeIVUsersWrapperPassPass(PassRegistry Registry);

  public void initializeInstCountPass(PassRegistry Registry);

  public void initializeIntervalPartitionPass(PassRegistry Registry);

  public void initializeLazyBlockFrequencyInfoPassPass(PassRegistry Registry);

  public void initializeLazyValueInfoWrapperPassPass(PassRegistry Registry);

  public void initializeLintPass(PassRegistry Registry);

  public void initializeModuleDebugInfoPrinterPass(PassRegistry Registry);

  public void initializeModuleSummaryIndexWrapperPassPass(PassRegistry Registry);

  public void initializeObjCARCAAWrapperPassPass(PassRegistry Registry);

  public void initializeOptimizationRemarkEmitterWrapperPassPass(PassRegistry Registry);

  public void initializePostDominatorTreeWrapperPassPass(PassRegistry Registry);

  public void initializeRegionOnlyPrinterPass(PassRegistry Registry);

  public void initializeRegionOnlyViewerPass(PassRegistry Registry);

  public void initializeRegionPrinterPass(PassRegistry Registry);

  public void initializeRegionViewerPass(PassRegistry Registry);

  public void initializeScalarEvolutionWrapperPassPass(PassRegistry Registry);

  public void initializeSCEVAAWrapperPassPass(PassRegistry Registry);

  public void initializeScopedNoAliasAAWrapperPassPass(PassRegistry Registry);

  public void initializeTargetTransformInfoWrapperPassPass(PassRegistry Registry);

  public void initializeBlockFrequencyInfoWrapperPassPass(PassRegistry Registry);

  public void initializeCostModelAnalysisPass(PassRegistry Registry);

  public void initializeMemDepPrinterPass(PassRegistry Registry);

  public void initializeMemDerefPrinterPass(PassRegistry Registry);

  public void initializeMemoryDependenceWrapperPassPass(PassRegistry Registry);

  public void initializeLoopAccessLegacyAnalysisPass(PassRegistry Registry);

  public void initializeRegionInfoPassPass(PassRegistry Registry);

}
