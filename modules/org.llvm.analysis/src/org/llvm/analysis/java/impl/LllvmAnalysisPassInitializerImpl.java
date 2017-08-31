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

package org.llvm.analysis.java.impl;

import org.clank.java.std;
import org.clank.support.Converted;
import org.llvm.analysis.impl.*;
import org.llvm.analysis.target.impl.*;
import org.llvm.pass.PassRegistry;
import org.llvm.pass.spi.LllvmAnalysisPassInitializer;
import org.llvm.support.AdtsupportLlvmGlobals;
import org.openide.util.lookup.ServiceProvider;

/**
 * Implement ServiceProvider to be able impl delegation into llvm/Analysis module from llvm/IR.
 * @author Vladimir Voskresensky
 */
@ServiceProvider(service = LllvmAnalysisPassInitializer.class, position=1000)
public class LllvmAnalysisPassInitializerImpl implements LllvmAnalysisPassInitializer {

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAssumptionCacheTrackerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp", line = 138,
   FQN="llvm::initializeAssumptionCacheTrackerPass", NM="_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AssumptionCache.cpp -nm=_ZN4llvm36initializeAssumptionCacheTrackerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAssumptionCacheTrackerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(AssumptionCacheStatics.InitializeAssumptionCacheTrackerPassFlag, AssumptionCacheStatics::initializeAssumptionCacheTrackerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 293,
   FQN="llvm::initializeCallGraphWrapperPassPass", NM="_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm34initializeCallGraphWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>  
  @Override public void initializeCallGraphWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CallGraphStatics.InitializeCallGraphWrapperPassPassFlag, CallGraphStatics::initializeCallGraphWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeProfileSummaryInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp", line = 134,
   FQN="llvm::initializeProfileSummaryInfoWrapperPassPass", NM="_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ProfileSummaryInfo.cpp -nm=_ZN4llvm43initializeProfileSummaryInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>  
  @Override public void initializeProfileSummaryInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ProfileSummaryInfoStatics.InitializeProfileSummaryInfoWrapperPassPassFlag, ProfileSummaryInfoStatics::initializeProfileSummaryInfoWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  // Register the basic pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetLibraryInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp", line = 1168,
   FQN="llvm::initializeTargetLibraryInfoWrapperPassPass", NM="_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetLibraryInfo.cpp -nm=_ZN4llvm42initializeTargetLibraryInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>  
  @Override public void initializeTargetLibraryInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(TargetLibraryInfoStatics.InitializeTargetLibraryInfoWrapperPassPassFlag, TargetLibraryInfoStatics::initializeTargetLibraryInfoWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAAResultsWrapperPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 567,
   FQN="llvm::initializeAAResultsWrapperPassPass", NM="_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm34initializeAAResultsWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAAResultsWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(AliasAnalysisStatics.InitializeAAResultsWrapperPassPassFlag, AliasAnalysisStatics::initializeAAResultsWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeExternalAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp", line = 542,
   FQN="llvm::initializeExternalAAWrapperPassPass", NM="_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysis.cpp -nm=_ZN4llvm35initializeExternalAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeExternalAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(AliasAnalysisStatics.InitializeExternalAAWrapperPassPassFlag, AliasAnalysisStatics::initializeExternalAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAAEvalLegacyPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp", line = 385,
   FQN="llvm::initializeAAEvalLegacyPassPass", NM="_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasAnalysisEvaluator.cpp -nm=_ZN4llvm30initializeAAEvalLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAAEvalLegacyPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(AliasAnalysisEvaluatorStatics.InitializeAAEvalLegacyPassPassFlag, AliasAnalysisEvaluatorStatics::initializeAAEvalLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAliasSetPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp", line = 717,
   FQN="llvm::initializeAliasSetPrinterPass", NM="_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/AliasSetTracker.cpp -nm=_ZN4llvm29initializeAliasSetPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAliasSetPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(AliasSetTrackerStatics.InitializeAliasSetPrinterPassFlag, AliasSetTrackerStatics::initializeAliasSetPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBasicAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp", line = 1692,
   FQN="llvm::initializeBasicAAWrapperPassPass", NM="_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BasicAliasAnalysis.cpp -nm=_ZN4llvm32initializeBasicAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBasicAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(BasicAliasAnalysisStatics.InitializeBasicAAWrapperPassPassFlag, BasicAliasAnalysisStatics::initializeBasicAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchProbabilityInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp", line = 33,
   FQN="llvm::initializeBranchProbabilityInfoWrapperPassPass", NM="_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BranchProbabilityInfo.cpp -nm=_ZN4llvm46initializeBranchProbabilityInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBranchProbabilityInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(BranchProbabilityInfoStatics.InitializeBranchProbabilityInfoWrapperPassPassFlag, BranchProbabilityInfoStatics::initializeBranchProbabilityInfoWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 136,
   FQN="llvm::initializeCFGOnlyPrinterPass", NM="_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm28initializeCFGOnlyPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFGOnlyPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CFGPrinterStatics.InitializeCFGOnlyPrinterPassFlag, CFGPrinterStatics::initializeCFGOnlyPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGOnlyViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 69,
   FQN="llvm::initializeCFGOnlyViewerPass", NM="_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm27initializeCFGOnlyViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFGOnlyViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CFGPrinterStatics.InitializeCFGOnlyViewerPassFlag, CFGPrinterStatics::initializeCFGOnlyViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 103,
   FQN="llvm::initializeCFGPrinterPass", NM="_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm24initializeCFGPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFGPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CFGPrinterStatics.InitializeCFGPrinterPassFlag, CFGPrinterStatics::initializeCFGPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp", line = 46,
   FQN="llvm::initializeCFGViewerPass", NM="_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFGPrinter.cpp -nm=_ZN4llvm23initializeCFGViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFGViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CFGPrinterStatics.InitializeCFGViewerPassFlag, CFGPrinterStatics::initializeCFGViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLAndersAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp", line = 565,
   FQN="llvm::initializeCFLAndersAAWrapperPassPass", NM="_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLAndersAliasAnalysis.cpp -nm=_ZN4llvm36initializeCFLAndersAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFLAndersAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CFLAndersAliasAnalysisStatics.InitializeCFLAndersAAWrapperPassPassFlag, CFLAndersAliasAnalysisStatics::initializeCFLAndersAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFLSteensAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp", line = 423,
   FQN="llvm::initializeCFLSteensAAWrapperPassPass", NM="_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CFLSteensAliasAnalysis.cpp -nm=_ZN4llvm36initializeCFLSteensAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFLSteensAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CFLSteensAliasAnalysisStatics.InitializeCFLSteensAAWrapperPassPassFlag, CFLSteensAliasAnalysisStatics::initializeCFLSteensAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphPrinterLegacyPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp", line = 336,
   FQN="llvm::initializeCallGraphPrinterLegacyPassPass", NM="_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallGraph.cpp -nm=_ZN4llvm40initializeCallGraphPrinterLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCallGraphPrinterLegacyPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CallGraphStatics.InitializeCallGraphPrinterLegacyPassPassFlag, CallGraphStatics::initializeCallGraphPrinterLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphDOTPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 81,
   FQN="llvm::initializeCallGraphDOTPrinterPass", NM="_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm33initializeCallGraphDOTPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCallGraphDOTPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CallPrinterStatics.InitializeCallGraphDOTPrinterPassFlag, CallPrinterStatics::initializeCallGraphDOTPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCallGraphViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp", line = 77,
   FQN="llvm::initializeCallGraphViewerPass", NM="_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CallPrinter.cpp -nm=_ZN4llvm29initializeCallGraphViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCallGraphViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CallPrinterStatics.InitializeCallGraphViewerPassFlag, CallPrinterStatics::initializeCallGraphViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDelinearizationPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp", line = 138,
   FQN="llvm::initializeDelinearizationPass", NM="_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Delinearization.cpp -nm=_ZN4llvm29initializeDelinearizationPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDelinearizationPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DelinearizationStatics.InitializeDelinearizationPassFlag, DelinearizationStatics::initializeDelinearizationPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDemandedBitsWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp", line = 50,
   FQN="llvm::initializeDemandedBitsWrapperPassPass", NM="_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DemandedBits.cpp -nm=_ZN4llvm37initializeDemandedBitsWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDemandedBitsWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DemandedBitsStatics.InitializeDemandedBitsWrapperPassPassFlag, DemandedBitsStatics::initializeDemandedBitsWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDependenceAnalysisWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp", line = 132,
   FQN="llvm::initializeDependenceAnalysisWrapperPassPass", NM="_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DependenceAnalysis.cpp -nm=_ZN4llvm43initializeDependenceAnalysisWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDependenceAnalysisWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DependenceAnalysisStatics.InitializeDependenceAnalysisWrapperPassPassFlag, DependenceAnalysisStatics::initializeDependenceAnalysisWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDivergenceAnalysisPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp", line = 272,
   FQN="llvm::initializeDivergenceAnalysisPass", NM="_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DivergenceAnalysis.cpp -nm=_ZN4llvm32initializeDivergenceAnalysisPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDivergenceAnalysisPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DivergenceAnalysisStatics.InitializeDivergenceAnalysisPassFlag, DivergenceAnalysisStatics::initializeDivergenceAnalysisPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 232,
   FQN="llvm::initializeDomOnlyPrinterPass", NM="_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28initializeDomOnlyPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDomOnlyPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializeDomOnlyPrinterPassFlag, DomPrinterStatics::initializeDomOnlyPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDomOnlyViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 154,
   FQN="llvm::initializeDomOnlyViewerPass", NM="_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27initializeDomOnlyViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDomOnlyViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializeDomOnlyViewerPassFlag, DomPrinterStatics::initializeDomOnlyViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDomPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 227,
   FQN="llvm::initializeDomPrinterPass", NM="_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm24initializeDomPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDomPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializeDomPrinterPassFlag, DomPrinterStatics::initializeDomPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDomViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 150,
   FQN="llvm::initializeDomViewerPass", NM="_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm23initializeDomViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDomViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializeDomViewerPassFlag, DomPrinterStatics::initializeDomViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 243,
   FQN="llvm::initializePostDomOnlyPrinterPass", NM="_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm32initializePostDomOnlyPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePostDomOnlyPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializePostDomOnlyPrinterPassFlag, DomPrinterStatics::initializePostDomOnlyPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomOnlyViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 163,
   FQN="llvm::initializePostDomOnlyViewerPass", NM="_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm31initializePostDomOnlyViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePostDomOnlyViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializePostDomOnlyViewerPassFlag, DomPrinterStatics::initializePostDomOnlyViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 238,
   FQN="llvm::initializePostDomPrinterPass", NM="_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm28initializePostDomPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePostDomPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializePostDomPrinterPassFlag, DomPrinterStatics::initializePostDomPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePostDomViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp", line = 159,
   FQN="llvm::initializePostDomViewerPass", NM="_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DomPrinter.cpp -nm=_ZN4llvm27initializePostDomViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePostDomViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DomPrinterStatics.InitializePostDomViewerPassFlag, DomPrinterStatics::initializePostDomViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDominanceFrontierWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp", line = 26,
   FQN="llvm::initializeDominanceFrontierWrapperPassPass", NM="_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/DominanceFrontier.cpp -nm=_ZN4llvm42initializeDominanceFrontierWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDominanceFrontierWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(DominanceFrontierStatics.InitializeDominanceFrontierWrapperPassPassFlag, DominanceFrontierStatics::initializeDominanceFrontierWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalsAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp", line = 953,
   FQN="llvm::initializeGlobalsAAWrapperPassPass", NM="_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/GlobalsModRef.cpp -nm=_ZN4llvm34initializeGlobalsAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGlobalsAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(GlobalsModRefStatics.InitializeGlobalsAAWrapperPassPassFlag, GlobalsModRefStatics::initializeGlobalsAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeIVUsersWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp", line = 62,
   FQN="llvm::initializeIVUsersWrapperPassPass", NM="_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IVUsers.cpp -nm=_ZN4llvm32initializeIVUsersWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeIVUsersWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(IVUsersStatics.InitializeIVUsersWrapperPassPassFlag, IVUsersStatics::initializeIVUsersWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInstCountPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp", line = 70,
   FQN="llvm::initializeInstCountPass", NM="_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/InstCount.cpp -nm=_ZN4llvm23initializeInstCountPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInstCountPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(InstCountStatics.InitializeInstCountPassFlag, InstCountStatics::initializeInstCountPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeIntervalPartitionPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp", line = 19,
   FQN="llvm::initializeIntervalPartitionPass", NM="_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/IntervalPartition.cpp -nm=_ZN4llvm31initializeIntervalPartitionPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeIntervalPartitionPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(IntervalPartitionStatics.InitializeIntervalPartitionPassFlag, IntervalPartitionStatics::initializeIntervalPartitionPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyBlockFrequencyInfoPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp", line = 29,
   FQN="llvm::initializeLazyBlockFrequencyInfoPassPass", NM="_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyBlockFrequencyInfo.cpp -nm=_ZN4llvm40initializeLazyBlockFrequencyInfoPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLazyBlockFrequencyInfoPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(LazyBlockFrequencyInfoStatics.InitializeLazyBlockFrequencyInfoPassPassFlag, LazyBlockFrequencyInfoStatics::initializeLazyBlockFrequencyInfoPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLazyValueInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp", line = 46,
   FQN="llvm::initializeLazyValueInfoWrapperPassPass", NM="_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LazyValueInfo.cpp -nm=_ZN4llvm38initializeLazyValueInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLazyValueInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(LazyValueInfoStatics.InitializeLazyValueInfoWrapperPassPassFlag, LazyValueInfoStatics::initializeLazyValueInfoWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLintPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp", line = 171,
   FQN="llvm::initializeLintPass", NM="_ZN4llvm18initializeLintPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/Lint.cpp -nm=_ZN4llvm18initializeLintPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLintPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(LintStatics.InitializeLintPassFlag, LintStatics::initializeLintPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleDebugInfoPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp", line = 46,
   FQN="llvm::initializeModuleDebugInfoPrinterPass", NM="_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleDebugInfoPrinter.cpp -nm=_ZN4llvm36initializeModuleDebugInfoPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeModuleDebugInfoPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ModuleDebugInfoPrinterStatics.InitializeModuleDebugInfoPrinterPassFlag, ModuleDebugInfoPrinterStatics::initializeModuleDebugInfoPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeModuleSummaryIndexWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp", line = 181,
   FQN="llvm::initializeModuleSummaryIndexWrapperPassPass", NM="_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ModuleSummaryAnalysis.cpp -nm=_ZN4llvm43initializeModuleSummaryIndexWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeModuleSummaryIndexWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ModuleSummaryAnalysisStatics.InitializeModuleSummaryIndexWrapperPassPassFlag, ModuleSummaryAnalysisStatics::initializeModuleSummaryIndexWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp", line = 139,
   FQN="llvm::initializeObjCARCAAWrapperPassPass", NM="_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ObjCARCAliasAnalysis.cpp -nm=_ZN4llvm34initializeObjCARCAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeObjCARCAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ObjCARCAliasAnalysisStatics.InitializeObjCARCAAWrapperPassPassFlag, ObjCARCAliasAnalysisStatics::initializeObjCARCAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizationRemarkEmitterWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp", line = 87,
   FQN="llvm::initializeOptimizationRemarkEmitterWrapperPassPass", NM="_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/OptimizationDiagnosticInfo.cpp -nm=_ZN4llvm50initializeOptimizationRemarkEmitterWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeOptimizationRemarkEmitterWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(OptimizationDiagnosticInfoStatics.InitializeOptimizationRemarkEmitterWrapperPassPassFlag, OptimizationDiagnosticInfoStatics::initializeOptimizationRemarkEmitterWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePostDominatorTreeWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp", line = 31,
   FQN="llvm::initializePostDominatorTreeWrapperPassPass", NM="_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/PostDominators.cpp -nm=_ZN4llvm42initializePostDominatorTreeWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePostDominatorTreeWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(PostDominatorsStatics.InitializePostDominatorTreeWrapperPassPassFlag, PostDominatorsStatics::initializePostDominatorTreeWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 204,
   FQN="llvm::initializeRegionOnlyPrinterPass", NM="_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm31initializeRegionOnlyPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRegionOnlyPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(RegionPrinterStatics.InitializeRegionOnlyPrinterPassFlag, RegionPrinterStatics::initializeRegionOnlyPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionOnlyViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 212,
   FQN="llvm::initializeRegionOnlyViewerPass", NM="_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm30initializeRegionOnlyViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRegionOnlyViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(RegionPrinterStatics.InitializeRegionOnlyViewerPassFlag, RegionPrinterStatics::initializeRegionOnlyViewerPassOnce, std.ref_T$R(Registry));
  }

  //end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 201,
   FQN="llvm::initializeRegionPrinterPass", NM="_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm27initializeRegionPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRegionPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(RegionPrinterStatics.InitializeRegionPrinterPassFlag, RegionPrinterStatics::initializeRegionPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionViewerPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp", line = 209,
   FQN="llvm::initializeRegionViewerPass", NM="_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionPrinter.cpp -nm=_ZN4llvm26initializeRegionViewerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRegionViewerPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(RegionPrinterStatics.InitializeRegionViewerPassFlag, RegionPrinterStatics::initializeRegionViewerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarEvolutionWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp", line = 10033,
   FQN="llvm::initializeScalarEvolutionWrapperPassPass", NM="_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolution.cpp -nm=_ZN4llvm40initializeScalarEvolutionWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeScalarEvolutionWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ScalarEvolutionStatics.InitializeScalarEvolutionWrapperPassPassFlag, ScalarEvolutionStatics::initializeScalarEvolutionWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSCEVAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp", line = 123,
   FQN="llvm::initializeSCEVAAWrapperPassPass", NM="_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScalarEvolutionAliasAnalysis.cpp -nm=_ZN4llvm31initializeSCEVAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSCEVAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ScalarEvolutionAliasAnalysisStatics.InitializeSCEVAAWrapperPassPassFlag, ScalarEvolutionAliasAnalysisStatics::initializeSCEVAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeScopedNoAliasAAWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp", line = 183,
   FQN="llvm::initializeScopedNoAliasAAWrapperPassPass", NM="_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/ScopedNoAliasAA.cpp -nm=_ZN4llvm40initializeScopedNoAliasAAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeScopedNoAliasAAWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ScopedNoAliasAAStatics.InitializeScopedNoAliasAAWrapperPassPassFlag, ScopedNoAliasAAStatics::initializeScopedNoAliasAAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  // Register the basic pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetTransformInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp", line = 440,
   FQN="llvm::initializeTargetTransformInfoWrapperPassPass", NM="_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/TargetTransformInfo.cpp -nm=_ZN4llvm44initializeTargetTransformInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeTargetTransformInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(TargetTransformInfoStatics.InitializeTargetTransformInfoWrapperPassPassFlag, TargetTransformInfoStatics::initializeTargetTransformInfoWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockFrequencyInfoWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp", line = 217,
   FQN="llvm::initializeBlockFrequencyInfoWrapperPassPass", NM="_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/BlockFrequencyInfo.cpp -nm=_ZN4llvm43initializeBlockFrequencyInfoWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBlockFrequencyInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(BlockFrequencyInfoStatics.InitializeBlockFrequencyInfoWrapperPassPassFlag, BlockFrequencyInfoStatics::initializeBlockFrequencyInfoWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCostModelAnalysisPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp", line = 72,
   FQN="llvm::initializeCostModelAnalysisPass", NM="_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/CostModel.cpp -nm=_ZN4llvm31initializeCostModelAnalysisPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCostModelAnalysisPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(CostModelStatics.InitializeCostModelAnalysisPassFlag, CostModelStatics::initializeCostModelAnalysisPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDepPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp", line = 83,
   FQN="llvm::initializeMemDepPrinterPass", NM="_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDepPrinter.cpp -nm=_ZN4llvm27initializeMemDepPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemDepPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(MemDepPrinterStatics.InitializeMemDepPrinterPassFlag, MemDepPrinterStatics::initializeMemDepPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemDerefPrinterPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp", line = 47,
   FQN="llvm::initializeMemDerefPrinterPass", NM="_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemDerefPrinter.cpp -nm=_ZN4llvm29initializeMemDerefPrinterPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemDerefPrinterPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(MemDerefPrinterStatics.InitializeMemDerefPrinterPassFlag, MemDerefPrinterStatics::initializeMemDerefPrinterPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemoryDependenceWrapperPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp", line = 1681,
   FQN="llvm::initializeMemoryDependenceWrapperPassPass", NM="_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/MemoryDependenceAnalysis.cpp -nm=_ZN4llvm41initializeMemoryDependenceWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemoryDependenceWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(MemoryDependenceAnalysisStatics.InitializeMemoryDependenceWrapperPassPassFlag, MemoryDependenceAnalysisStatics::initializeMemoryDependenceWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopAccessLegacyAnalysisPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp", line = 2021,
   FQN="llvm::initializeLoopAccessLegacyAnalysisPass", NM="_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/LoopAccessAnalysis.cpp -nm=_ZN4llvm38initializeLoopAccessLegacyAnalysisPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopAccessLegacyAnalysisPass(PassRegistry Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopAccessLegacyAnalysisPassFlag, initializeLoopAccessLegacyAnalysisPass(Registry);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegionInfoPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp", line = 168,
   FQN="llvm::initializeRegionInfoPassPass", NM="_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Analysis/RegionInfo.cpp -nm=_ZN4llvm28initializeRegionInfoPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRegionInfoPassPass(PassRegistry Registry) {
    throw new UnsupportedOperationException("EmptyBody");
  //AdtsupportLlvmGlobals.call_once(InitializeRegionInfoPassPassFlag, initializeRegionInfoPassPassOnce, std.ref_T$R(Registry));
  }

}
