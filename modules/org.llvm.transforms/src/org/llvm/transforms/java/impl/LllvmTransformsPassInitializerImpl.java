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
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.llvm.transforms.java.impl;

import org.clank.java.std;
import org.clank.support.Converted;
import org.llvm.pass.PassRegistry;
import org.llvm.pass.spi.LllvmTransformsPassInitializer;
import org.llvm.support.AdtsupportLlvmGlobals;
import org.llvm.transforms.instrumentation.impl.BoundsCheckingStatics;
import org.llvm.transforms.ipo.impl.BarrierNoopPassStatics;
import org.llvm.transforms.scalar.impl.ADCEStatics;
import org.llvm.transforms.utils.impl.AddDiscriminatorsStatics;
import org.openide.util.lookup.ServiceProvider;

@ServiceProvider(service = LllvmTransformsPassInitializer.class, position=1000)
public class LllvmTransformsPassInitializerImpl implements LllvmTransformsPassInitializer {

  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp", line = 179,
   FQN="llvm::initializeADCELegacyPassPass", NM="_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ADCE.cpp -nm=_ZN4llvm28initializeADCELegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeTargetLibraryInfoWrapperPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(ADCEStatics.InitializeADCELegacyPassPassFlag, ADCEStatics::initializeADCELegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAddDiscriminatorsLegacyPassPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp", line = 92,
   FQN="llvm::initializeAddDiscriminatorsLegacyPassPass", NM="_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/AddDiscriminators.cpp -nm=_ZN4llvm41initializeAddDiscriminatorsLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAddDiscriminatorsLegacyPassPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(AddDiscriminatorsStatics.InitializeAddDiscriminatorsLegacyPassPassFlag, AddDiscriminatorsStatics::initializeAddDiscriminatorsLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBarrierNoopPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp", line = 46,
   FQN="llvm::initializeBarrierNoopPass", NM="_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/BarrierNoopPass.cpp -nm=_ZN4llvm25initializeBarrierNoopPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBarrierNoopPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(BarrierNoopPassStatics.InitializeBarrierNoopPassFlag, BarrierNoopPassStatics::initializeBarrierNoopPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBoundsCheckingPass">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp", line = 69,
   FQN="llvm::initializeBoundsCheckingPass", NM="_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/BoundsChecking.cpp -nm=_ZN4llvm28initializeBoundsCheckingPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBoundsCheckingPass(PassRegistry Registry) {
    AdtsupportLlvmGlobals.call_once(BoundsCheckingStatics.InitializeBoundsCheckingPassFlag, BoundsCheckingStatics::initializeBoundsCheckingPassOnce, std.ref_T$R(Registry));
  }
  
  ///============================
  
  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerModulePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp", line = 821,
   FQN="llvm::initializeAddressSanitizerModulePass", NM="_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm36initializeAddressSanitizerModulePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAddressSanitizerModulePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeAddressSanitizerModulePassFlag, initializeAddressSanitizerModulePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAddressSanitizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp", line = 809,
   FQN="llvm::initializeAddressSanitizerPass", NM="_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/AddressSanitizer.cpp -nm=_ZN4llvm30initializeAddressSanitizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAddressSanitizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeAddressSanitizerPassFlag, initializeAddressSanitizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAlignmentFromAssumptionsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp", line = 80,
   FQN="llvm::initializeAlignmentFromAssumptionsPass", NM="_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/AlignmentFromAssumptions.cpp -nm=_ZN4llvm38initializeAlignmentFromAssumptionsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAlignmentFromAssumptionsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeAlignmentFromAssumptionsPassFlag, initializeAlignmentFromAssumptionsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeArgPromotionPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp", line = 113,
   FQN="llvm::initializeArgPromotionPass", NM="_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ArgumentPromotion.cpp -nm=_ZN4llvm26initializeArgPromotionPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeArgPromotionPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeArgPromotionPassFlag, initializeArgPromotionPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBBVectorizePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp", line = 3231,
   FQN="llvm::initializeBBVectorizePass", NM="_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/BBVectorize.cpp -nm=_ZN4llvm25initializeBBVectorizePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBBVectorizePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeBBVectorizePassFlag, initializeBBVectorizePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBDCELegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp", line = 109,
   FQN="llvm::initializeBDCELegacyPassPass", NM="_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/BDCE.cpp -nm=_ZN4llvm28initializeBDCELegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBDCELegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeBDCELegacyPassPassFlag, initializeBDCELegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBreakCriticalEdgesPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp", line = 66,
   FQN="llvm::initializeBreakCriticalEdgesPass", NM="_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/BreakCriticalEdges.cpp -nm=_ZN4llvm32initializeBreakCriticalEdgesPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBreakCriticalEdgesPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeBreakCriticalEdgesPassFlag, initializeBreakCriticalEdgesPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantHoistingLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp", line = 87,
   FQN="llvm::initializeConstantHoistingLegacyPassPass", NM="_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantHoisting.cpp -nm=_ZN4llvm40initializeConstantHoistingLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeConstantHoistingLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeConstantHoistingLegacyPassPassFlag, initializeConstantHoistingLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantMergeLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp", line = 219,
   FQN="llvm::initializeConstantMergeLegacyPassPass", NM="_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ConstantMerge.cpp -nm=_ZN4llvm37initializeConstantMergeLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeConstantMergeLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeConstantMergeLegacyPassPassFlag, initializeConstantMergeLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeConstantPropagationPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp", line = 57,
   FQN="llvm::initializeConstantPropagationPass", NM="_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/ConstantProp.cpp -nm=_ZN4llvm33initializeConstantPropagationPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeConstantPropagationPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeConstantPropagationPassFlag, initializeConstantPropagationPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCorrelatedValuePropagationPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp", line = 63,
   FQN="llvm::initializeCorrelatedValuePropagationPass", NM="_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/CorrelatedValuePropagation.cpp -nm=_ZN4llvm40initializeCorrelatedValuePropagationPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCorrelatedValuePropagationPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeCorrelatedValuePropagationPassFlag, initializeCorrelatedValuePropagationPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCrossDSOCFIPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp", line = 61,
   FQN="llvm::initializeCrossDSOCFIPass", NM="_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/CrossDSOCFI.cpp -nm=_ZN4llvm25initializeCrossDSOCFIPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCrossDSOCFIPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeCrossDSOCFIPassFlag, initializeCrossDSOCFIPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDCELegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp", line = 156,
   FQN="llvm::initializeDCELegacyPassPass", NM="_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm27initializeDCELegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDCELegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeDCELegacyPassPassFlag, initializeDCELegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadInstEliminationPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp", line = 68,
   FQN="llvm::initializeDeadInstEliminationPass", NM="_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DCE.cpp -nm=_ZN4llvm33initializeDeadInstEliminationPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDeadInstEliminationPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeDeadInstEliminationPassFlag, initializeDeadInstEliminationPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDataFlowSanitizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp", line = 359,
   FQN="llvm::initializeDataFlowSanitizerPass", NM="_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/DataFlowSanitizer.cpp -nm=_ZN4llvm31initializeDataFlowSanitizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDataFlowSanitizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeDataFlowSanitizerPassFlag, initializeDataFlowSanitizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDAEPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp", line = 78,
   FQN="llvm::initializeDAEPass", NM="_ZN4llvm17initializeDAEPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp -nm=_ZN4llvm17initializeDAEPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDAEPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeDAEPassFlag, initializeDAEPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDAHPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp", line = 93,
   FQN="llvm::initializeDAHPass", NM="_ZN4llvm17initializeDAHPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/DeadArgumentElimination.cpp -nm=_ZN4llvm17initializeDAHPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDAHPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeDAHPassFlag, initializeDAHPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeDSELegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp", line = 1098,
   FQN="llvm::initializeDSELegacyPassPass", NM="_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/DeadStoreElimination.cpp -nm=_ZN4llvm27initializeDSELegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeDSELegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeDSELegacyPassPassFlag, initializeDSELegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyCSELegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp", line = 920,
   FQN="llvm::initializeEarlyCSELegacyPassPass", NM="_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/EarlyCSE.cpp -nm=_ZN4llvm32initializeEarlyCSELegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeEarlyCSELegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeEarlyCSELegacyPassPassFlag, initializeEarlyCSELegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeEfficiencySanitizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp", line = 230,
   FQN="llvm::initializeEfficiencySanitizerPass", NM="_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/EfficiencySanitizer.cpp -nm=_ZN4llvm33initializeEfficiencySanitizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeEfficiencySanitizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeEfficiencySanitizerPassFlag, initializeEfficiencySanitizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeEliminateAvailableExternallyLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp", line = 91,
   FQN="llvm::initializeEliminateAvailableExternallyLegacyPassPass", NM="_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ElimAvailExtern.cpp -nm=_ZN4llvm52initializeEliminateAvailableExternallyLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeEliminateAvailableExternallyLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeEliminateAvailableExternallyLegacyPassPassFlag, initializeEliminateAvailableExternallyLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeFlattenCFGPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp", line = 45,
   FQN="llvm::initializeFlattenCFGPassPass", NM="_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/FlattenCFGPass.cpp -nm=_ZN4llvm28initializeFlattenCFGPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeFlattenCFGPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeFlattenCFGPassPassFlag, initializeFlattenCFGPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeFloat2IntLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp", line = 78,
   FQN="llvm::initializeFloat2IntLegacyPassPass", NM="_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Float2Int.cpp -nm=_ZN4llvm33initializeFloat2IntLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeFloat2IntLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeFloat2IntLegacyPassPassFlag, initializeFloat2IntLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeForceFunctionAttrsLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp", line = 117,
   FQN="llvm::initializeForceFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/ForceFunctionAttrs.cpp -nm=_ZN4llvm42initializeForceFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeForceFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeForceFunctionAttrsLegacyPassPassFlag, initializeForceFunctionAttrsLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePostOrderFunctionAttrsLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp", line = 1066,
   FQN="llvm::initializePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=_ZN4llvm46initializePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePostOrderFunctionAttrsLegacyPassPassFlag, initializePostOrderFunctionAttrsLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp", line = 1147,
   FQN="llvm::initializeReversePostOrderFunctionAttrsLegacyPassPass", NM="_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionAttrs.cpp -nm=_ZN4llvm53initializeReversePostOrderFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeReversePostOrderFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeReversePostOrderFunctionAttrsLegacyPassPassFlag, initializeReversePostOrderFunctionAttrsLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeFunctionImportPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp", line = 787,
   FQN="llvm::initializeFunctionImportPassPass", NM="_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/FunctionImport.cpp -nm=_ZN4llvm32initializeFunctionImportPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeFunctionImportPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeFunctionImportPassPassFlag, initializeFunctionImportPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGCOVProfilerLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp", line = 154,
   FQN="llvm::initializeGCOVProfilerLegacyPassPass", NM="_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/GCOVProfiling.cpp -nm=_ZN4llvm36initializeGCOVProfilerLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGCOVProfilerLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeGCOVProfilerLegacyPassPassFlag, initializeGCOVProfilerLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp", line = 2754,
   FQN="llvm::initializeGVNLegacyPassPass", NM="_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVN.cpp -nm=_ZN4llvm27initializeGVNLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGVNLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeGVNLegacyPassPassFlag, initializeGVNLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGVNHoistLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp", line = 822,
   FQN="llvm::initializeGVNHoistLegacyPassPass", NM="_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GVNHoist.cpp -nm=_ZN4llvm32initializeGVNHoistLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGVNHoistLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeGVNHoistLegacyPassPassFlag, initializeGVNHoistLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalDCELegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp", line = 64,
   FQN="llvm::initializeGlobalDCELegacyPassPass", NM="_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalDCE.cpp -nm=_ZN4llvm33initializeGlobalDCELegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGlobalDCELegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeGlobalDCELegacyPassPassFlag, initializeGlobalDCELegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalOptLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp", line = 2612,
   FQN="llvm::initializeGlobalOptLegacyPassPass", NM="_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/GlobalOpt.cpp -nm=_ZN4llvm33initializeGlobalOptLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGlobalOptLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeGlobalOptLegacyPassPassFlag, initializeGlobalOptLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeGuardWideningLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp", line = 686,
   FQN="llvm::initializeGuardWideningLegacyPassPass", NM="_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/GuardWidening.cpp -nm=_ZN4llvm37initializeGuardWideningLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeGuardWideningLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeGuardWideningLegacyPassPassFlag, initializeGuardWideningLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeIPCPPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp", line = 253,
   FQN="llvm::initializeIPCPPass", NM="_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/IPConstantPropagation.cpp -nm=_ZN4llvm18initializeIPCPPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeIPCPPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeIPCPPassFlag, initializeIPCPPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeIndVarSimplifyLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp", line = 2283,
   FQN="llvm::initializeIndVarSimplifyLegacyPassPass", NM="_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/IndVarSimplify.cpp -nm=_ZN4llvm38initializeIndVarSimplifyLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeIndVarSimplifyLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeIndVarSimplifyLegacyPassPassFlag, initializeIndVarSimplifyLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePGOIndirectCallPromotionLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp", line = 119,
   FQN="llvm::initializePGOIndirectCallPromotionLegacyPassPass", NM="_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/IndirectCallPromotion.cpp -nm=_ZN4llvm48initializePGOIndirectCallPromotionLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePGOIndirectCallPromotionLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePGOIndirectCallPromotionLegacyPassPassFlag, initializePGOIndirectCallPromotionLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInductiveRangeCheckEliminationPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp", line = 224,
   FQN="llvm::initializeInductiveRangeCheckEliminationPass", NM="_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/InductiveRangeCheckElimination.cpp -nm=_ZN4llvm44initializeInductiveRangeCheckEliminationPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInductiveRangeCheckEliminationPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInductiveRangeCheckEliminationPassFlag, initializeInductiveRangeCheckEliminationPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInferFunctionAttrsLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp", line = 75,
   FQN="llvm::initializeInferFunctionAttrsLegacyPassPass", NM="_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InferFunctionAttrs.cpp -nm=_ZN4llvm42initializeInferFunctionAttrsLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInferFunctionAttrsLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInferFunctionAttrsLegacyPassPassFlag, initializeInferFunctionAttrsLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeAlwaysInlinerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp", line = 71,
   FQN="llvm::initializeAlwaysInlinerPass", NM="_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineAlways.cpp -nm=_ZN4llvm27initializeAlwaysInlinerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeAlwaysInlinerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeAlwaysInlinerPassFlag, initializeAlwaysInlinerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSimpleInlinerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp", line = 84,
   FQN="llvm::initializeSimpleInlinerPass", NM="_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/InlineSimple.cpp -nm=_ZN4llvm27initializeSimpleInlinerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSimpleInlinerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSimpleInlinerPassFlag, initializeSimpleInlinerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInstrProfilingLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp", line = 77,
   FQN="llvm::initializeInstrProfilingLegacyPassPass", NM="_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/InstrProfiling.cpp -nm=_ZN4llvm38initializeInstrProfilingLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInstrProfilingLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInstrProfilingLegacyPassPassFlag, initializeInstrProfilingLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInstructionCombiningPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp", line = 3209,
   FQN="llvm::initializeInstructionCombiningPassPass", NM="_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/InstCombine/InstructionCombining.cpp -nm=_ZN4llvm38initializeInstructionCombiningPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInstructionCombiningPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInstructionCombiningPassPassFlag, initializeInstructionCombiningPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInstNamerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp", line = 55,
   FQN="llvm::initializeInstNamerPass", NM="_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/InstructionNamer.cpp -nm=_ZN4llvm23initializeInstNamerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInstNamerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInstNamerPassFlag, initializeInstNamerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInternalizeLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp", line = 284,
   FQN="llvm::initializeInternalizeLegacyPassPass", NM="_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/Internalize.cpp -nm=_ZN4llvm35initializeInternalizeLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInternalizeLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInternalizeLegacyPassPassFlag, initializeInternalizeLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeJumpThreadingPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp", line = 107,
   FQN="llvm::initializeJumpThreadingPass", NM="_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/JumpThreading.cpp -nm=_ZN4llvm27initializeJumpThreadingPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeJumpThreadingPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeJumpThreadingPassFlag, initializeJumpThreadingPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLCSSAWrapperPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp", line = 342,
   FQN="llvm::initializeLCSSAWrapperPassPass", NM="_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LCSSA.cpp -nm=_ZN4llvm30initializeLCSSAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLCSSAWrapperPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLCSSAWrapperPassPassFlag, initializeLCSSAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLegacyLICMPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp", line = 203,
   FQN="llvm::initializeLegacyLICMPassPass", NM="_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LICM.cpp -nm=_ZN4llvm28initializeLegacyLICMPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLegacyLICMPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLegacyLICMPassPassFlag, initializeLegacyLICMPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadCombinePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp", line = 283,
   FQN="llvm::initializeLoadCombinePass", NM="_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoadCombine.cpp -nm=_ZN4llvm25initializeLoadCombinePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoadCombinePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoadCombinePassFlag, initializeLoadCombinePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoadStoreVectorizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp", line = 171,
   FQN="llvm::initializeLoadStoreVectorizerPass", NM="_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoadStoreVectorizer.cpp -nm=_ZN4llvm33initializeLoadStoreVectorizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoadStoreVectorizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoadStoreVectorizerPassFlag, initializeLoadStoreVectorizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDataPrefetchPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp", line = 129,
   FQN="llvm::initializeLoopDataPrefetchPass", NM="_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDataPrefetch.cpp -nm=_ZN4llvm30initializeLoopDataPrefetchPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopDataPrefetchPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopDataPrefetchPassFlag, initializeLoopDataPrefetchPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDeletionLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp", line = 254,
   FQN="llvm::initializeLoopDeletionLegacyPassPass", NM="_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDeletion.cpp -nm=_ZN4llvm36initializeLoopDeletionLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopDeletionLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopDeletionLegacyPassPassFlag, initializeLoopDeletionLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopDistributeLegacyPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp", line = 984,
   FQN="llvm::initializeLoopDistributeLegacyPass", NM="_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopDistribute.cpp -nm=_ZN4llvm34initializeLoopDistributeLegacyPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopDistributeLegacyPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopDistributeLegacyPassFlag, initializeLoopDistributeLegacyPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeBlockExtractorPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 191,
   FQN="llvm::initializeBlockExtractorPassPass", NM="_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm32initializeBlockExtractorPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeBlockExtractorPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeBlockExtractorPassPassFlag, initializeBlockExtractorPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopExtractorPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 63,
   FQN="llvm::initializeLoopExtractorPass", NM="_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm27initializeLoopExtractorPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopExtractorPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopExtractorPassFlag, initializeLoopExtractorPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSingleLoopExtractorPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp", line = 75,
   FQN="llvm::initializeSingleLoopExtractorPass", NM="_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LoopExtractor.cpp -nm=_ZN4llvm33initializeSingleLoopExtractorPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSingleLoopExtractorPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSingleLoopExtractorPassFlag, initializeSingleLoopExtractorPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopIdiomRecognizeLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp", line = 204,
   FQN="llvm::initializeLoopIdiomRecognizeLegacyPassPass", NM="_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopIdiomRecognize.cpp -nm=_ZN4llvm42initializeLoopIdiomRecognizeLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopIdiomRecognizeLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopIdiomRecognizeLegacyPassPassFlag, initializeLoopIdiomRecognizeLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInstSimplifyLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp", line = 211,
   FQN="llvm::initializeLoopInstSimplifyLegacyPassPass", NM="_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInstSimplify.cpp -nm=_ZN4llvm40initializeLoopInstSimplifyLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopInstSimplifyLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopInstSimplifyLegacyPassPassFlag, initializeLoopInstSimplifyLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopInterchangePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp", line = 1277,
   FQN="llvm::initializeLoopInterchangePass", NM="_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopInterchange.cpp -nm=_ZN4llvm29initializeLoopInterchangePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopInterchangePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopInterchangePassFlag, initializeLoopInterchangePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopLoadEliminationPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp", line = 599,
   FQN="llvm::initializeLoopLoadEliminationPass", NM="_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopLoadElimination.cpp -nm=_ZN4llvm33initializeLoopLoadEliminationPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopLoadEliminationPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopLoadEliminationPassFlag, initializeLoopLoadEliminationPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRerollPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp", line = 454,
   FQN="llvm::initializeLoopRerollPass", NM="_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRerollPass.cpp -nm=_ZN4llvm24initializeLoopRerollPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopRerollPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopRerollPassFlag, initializeLoopRerollPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopRotateLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp", line = 688,
   FQN="llvm::initializeLoopRotateLegacyPassPass", NM="_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopRotation.cpp -nm=_ZN4llvm34initializeLoopRotateLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopRotateLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopRotateLegacyPassPassFlag, initializeLoopRotateLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp", line = 800,
   FQN="llvm::initializeLoopSimplifyPass", NM="_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopSimplify.cpp -nm=_ZN4llvm26initializeLoopSimplifyPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopSimplifyPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopSimplifyPassFlag, initializeLoopSimplifyPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopSimplifyCFGLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp", line = 109,
   FQN="llvm::initializeLoopSimplifyCFGLegacyPassPass", NM="_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopSimplifyCFG.cpp -nm=_ZN4llvm39initializeLoopSimplifyCFGLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopSimplifyCFGLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopSimplifyCFGLegacyPassPassFlag, initializeLoopSimplifyCFGLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopStrengthReducePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp", line = 4956,
   FQN="llvm::initializeLoopStrengthReducePass", NM="_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopStrengthReduce.cpp -nm=_ZN4llvm32initializeLoopStrengthReducePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopStrengthReducePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopStrengthReducePassFlag, initializeLoopStrengthReducePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnrollPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp", line = 1040,
   FQN="llvm::initializeLoopUnrollPass", NM="_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnrollPass.cpp -nm=_ZN4llvm24initializeLoopUnrollPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopUnrollPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopUnrollPassFlag, initializeLoopUnrollPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopUnswitchPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp", line = 384,
   FQN="llvm::initializeLoopUnswitchPass", NM="_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopUnswitch.cpp -nm=_ZN4llvm26initializeLoopUnswitchPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopUnswitchPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopUnswitchPassFlag, initializeLoopUnswitchPassOnce, std.ref_T$R(Registry));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVectorizePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp", line = 6220,
   FQN="llvm::initializeLoopVectorizePass", NM="_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/LoopVectorize.cpp -nm=_ZN4llvm27initializeLoopVectorizePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopVectorizePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopVectorizePassFlag, initializeLoopVectorizePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp", line = 317,
   FQN="llvm::initializeLoopVersioningPassPass", NM="_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LoopVersioning.cpp -nm=_ZN4llvm32initializeLoopVersioningPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopVersioningPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopVersioningPassPassFlag, initializeLoopVersioningPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLoopVersioningLICMPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp", line = 568,
   FQN="llvm::initializeLoopVersioningLICMPass", NM="_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LoopVersioningLICM.cpp -nm=_ZN4llvm32initializeLoopVersioningLICMPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLoopVersioningLICMPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLoopVersioningLICMPassFlag, initializeLoopVersioningLICMPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerAtomicLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp", line = 171,
   FQN="llvm::initializeLowerAtomicLegacyPassPass", NM="_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerAtomic.cpp -nm=_ZN4llvm35initializeLowerAtomicLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLowerAtomicLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLowerAtomicLegacyPassPassFlag, initializeLowerAtomicLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerExpectIntrinsicPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp", line = 200,
   FQN="llvm::initializeLowerExpectIntrinsicPass", NM="_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerExpectIntrinsic.cpp -nm=_ZN4llvm34initializeLowerExpectIntrinsicPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLowerExpectIntrinsicPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLowerExpectIntrinsicPassFlag, initializeLowerExpectIntrinsicPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerGuardIntrinsicPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp", line = 117,
   FQN="llvm::initializeLowerGuardIntrinsicPass", NM="_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/LowerGuardIntrinsic.cpp -nm=_ZN4llvm33initializeLowerGuardIntrinsicPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLowerGuardIntrinsicPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLowerGuardIntrinsicPassFlag, initializeLowerGuardIntrinsicPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerInvokePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp", line = 42,
   FQN="llvm::initializeLowerInvokePass", NM="_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerInvoke.cpp -nm=_ZN4llvm25initializeLowerInvokePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLowerInvokePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLowerInvokePassFlag, initializeLowerInvokePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerSwitchPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp", line = 100,
   FQN="llvm::initializeLowerSwitchPass", NM="_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/LowerSwitch.cpp -nm=_ZN4llvm25initializeLowerSwitchPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLowerSwitchPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLowerSwitchPassFlag, initializeLowerSwitchPassOnce, std.ref_T$R(Registry));
  }

  // anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerTypeTestsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp", line = 261,
   FQN="llvm::initializeLowerTypeTestsPass", NM="_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/LowerTypeTests.cpp -nm=_ZN4llvm28initializeLowerTypeTestsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeLowerTypeTestsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeLowerTypeTestsPassFlag, initializeLowerTypeTestsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePromoteLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp", line = 100,
   FQN="llvm::initializePromoteLegacyPassPass", NM="_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/Mem2Reg.cpp -nm=_ZN4llvm31initializePromoteLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePromoteLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePromoteLegacyPassPassFlag, initializePromoteLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemCpyOptLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp", line = 356,
   FQN="llvm::initializeMemCpyOptLegacyPassPass", NM="_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MemCpyOptimizer.cpp -nm=_ZN4llvm33initializeMemCpyOptLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemCpyOptLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMemCpyOptLegacyPassPassFlag, initializeMemCpyOptLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAWrapperPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp", line = 54,
   FQN="llvm::initializeMemorySSAWrapperPassPass", NM="_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm34initializeMemorySSAWrapperPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemorySSAWrapperPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMemorySSAWrapperPassPassFlag, initializeMemorySSAWrapperPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySSAPrinterLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp", line = 60,
   FQN="llvm::initializeMemorySSAPrinterLegacyPassPass", NM="_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MemorySSA.cpp -nm=_ZN4llvm40initializeMemorySSAPrinterLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemorySSAPrinterLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMemorySSAPrinterLegacyPassPassFlag, initializeMemorySSAPrinterLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMemorySanitizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp", line = 394,
   FQN="llvm::initializeMemorySanitizerPass", NM="_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/MemorySanitizer.cpp -nm=_ZN4llvm29initializeMemorySanitizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMemorySanitizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMemorySanitizerPassFlag, initializeMemorySanitizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMergeFunctionsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp", line = 1460,
   FQN="llvm::initializeMergeFunctionsPass", NM="_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/MergeFunctions.cpp -nm=_ZN4llvm28initializeMergeFunctionsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMergeFunctionsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMergeFunctionsPassFlag, initializeMergeFunctionsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMergedLoadStoreMotionLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp", line = 589,
   FQN="llvm::initializeMergedLoadStoreMotionLegacyPassPass", NM="_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/MergedLoadStoreMotion.cpp -nm=_ZN4llvm45initializeMergedLoadStoreMotionLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMergedLoadStoreMotionLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMergedLoadStoreMotionLegacyPassPassFlag, initializeMergedLoadStoreMotionLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeMetaRenamerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp", line = 142,
   FQN="llvm::initializeMetaRenamerPass", NM="_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/MetaRenamer.cpp -nm=_ZN4llvm25initializeMetaRenamerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeMetaRenamerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeMetaRenamerPassFlag, initializeMetaRenamerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeNameAnonFunctionPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp", line = 97,
   FQN="llvm::initializeNameAnonFunctionPass", NM="_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/NameAnonFunctions.cpp -nm=_ZN4llvm30initializeNameAnonFunctionPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeNameAnonFunctionPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeNameAnonFunctionPassFlag, initializeNameAnonFunctionPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeNaryReassociatePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp", line = 203,
   FQN="llvm::initializeNaryReassociatePass", NM="_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/NaryReassociate.cpp -nm=_ZN4llvm29initializeNaryReassociatePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeNaryReassociatePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeNaryReassociatePassFlag, initializeNaryReassociatePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCAPElimPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp", line = 56,
   FQN="llvm::initializeObjCARCAPElimPass", NM="_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCAPElim.cpp -nm=_ZN4llvm27initializeObjCARCAPElimPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeObjCARCAPElimPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeObjCARCAPElimPassFlag, initializeObjCARCAPElimPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCContractPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp", line = 635,
   FQN="llvm::initializeObjCARCContractPass", NM="_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCContract.cpp -nm=_ZN4llvm29initializeObjCARCContractPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeObjCARCContractPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeObjCARCContractPassFlag, initializeObjCARCContractPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCExpandPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp", line = 68,
   FQN="llvm::initializeObjCARCExpandPass", NM="_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCExpand.cpp -nm=_ZN4llvm27initializeObjCARCExpandPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeObjCARCExpandPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeObjCARCExpandPassFlag, initializeObjCARCExpandPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeObjCARCOptPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp", line = 560,
   FQN="llvm::initializeObjCARCOptPass", NM="_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ObjCARCOpts.cpp -nm=_ZN4llvm24initializeObjCARCOptPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeObjCARCOptPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeObjCARCOptPassFlag, initializeObjCARCOptPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationGenLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp", line = 179,
   FQN="llvm::initializePGOInstrumentationGenLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp -nm=_ZN4llvm45initializePGOInstrumentationGenLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePGOInstrumentationGenLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePGOInstrumentationGenLegacyPassPassFlag, initializePGOInstrumentationGenLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePGOInstrumentationUseLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp", line = 191,
   FQN="llvm::initializePGOInstrumentationUseLegacyPassPass", NM="_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/PGOInstrumentation.cpp -nm=_ZN4llvm45initializePGOInstrumentationUseLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePGOInstrumentationUseLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePGOInstrumentationUseLegacyPassPassFlag, initializePGOInstrumentationUseLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePartialInlinerLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp", line = 52,
   FQN="llvm::initializePartialInlinerLegacyPassPass", NM="_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PartialInlining.cpp -nm=_ZN4llvm38initializePartialInlinerLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePartialInlinerLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePartialInlinerLegacyPassPassFlag, initializePartialInlinerLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePartiallyInlineLibCallsLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp", line = 170,
   FQN="llvm::initializePartiallyInlineLibCallsLegacyPassPass", NM="_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PartiallyInlineLibCalls.cpp -nm=_ZN4llvm47initializePartiallyInlineLibCallsLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePartiallyInlineLibCallsLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePartiallyInlineLibCallsLegacyPassPassFlag, initializePartiallyInlineLibCallsLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceBackedgeSafepointsImplPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp", line = 602,
   FQN="llvm::initializePlaceBackedgeSafepointsImplPass", NM="_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp -nm=_ZN4llvm41initializePlaceBackedgeSafepointsImplPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePlaceBackedgeSafepointsImplPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePlaceBackedgeSafepointsImplPassFlag, initializePlaceBackedgeSafepointsImplPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePlaceSafepointsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp", line = 608,
   FQN="llvm::initializePlaceSafepointsPass", NM="_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/PlaceSafepoints.cpp -nm=_ZN4llvm29initializePlaceSafepointsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePlaceSafepointsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePlaceSafepointsPassFlag, initializePlaceSafepointsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePAEvalPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ProvenanceAnalysisEvaluator.cpp", line = 93,
   FQN="llvm::initializePAEvalPass", NM="_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/ObjCARC/ProvenanceAnalysisEvaluator.cpp -nm=_ZN4llvm20initializePAEvalPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePAEvalPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePAEvalPassFlag, initializePAEvalPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializePruneEHPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp", line = 59,
   FQN="llvm::initializePruneEHPass", NM="_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/PruneEH.cpp -nm=_ZN4llvm21initializePruneEHPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializePruneEHPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializePruneEHPassFlag, initializePruneEHPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeReassociateLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp", line = 2254,
   FQN="llvm::initializeReassociateLegacyPassPass", NM="_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reassociate.cpp -nm=_ZN4llvm35initializeReassociateLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeReassociateLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeReassociateLegacyPassPassFlag, initializeReassociateLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegToMemPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp", line = 67,
   FQN="llvm::initializeRegToMemPass", NM="_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Reg2Mem.cpp -nm=_ZN4llvm22initializeRegToMemPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRegToMemPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeRegToMemPassFlag, initializeRegToMemPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteStatepointsForGCPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp", line = 135,
   FQN="llvm::initializeRewriteStatepointsForGCPass", NM="_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/RewriteStatepointsForGC.cpp -nm=_ZN4llvm37initializeRewriteStatepointsForGCPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRewriteStatepointsForGCPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeRewriteStatepointsForGCPassFlag, initializeRewriteStatepointsForGCPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeIPSCCPLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp", line = 1941,
   FQN="llvm::initializeIPSCCPLegacyPassPass", NM="_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp -nm=_ZN4llvm30initializeIPSCCPLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeIPSCCPLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeIPSCCPLegacyPassPassFlag, initializeIPSCCPLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSCCPLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp", line = 1648,
   FQN="llvm::initializeSCCPLegacyPassPass", NM="_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SCCP.cpp -nm=_ZN4llvm28initializeSCCPLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSCCPLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSCCPLegacyPassPassFlag, initializeSCCPLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSLPVectorizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp", line = 4709,
   FQN="llvm::initializeSLPVectorizerPass", NM="_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Vectorize/SLPVectorizer.cpp -nm=_ZN4llvm27initializeSLPVectorizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSLPVectorizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSLPVectorizerPassFlag, initializeSLPVectorizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSROALegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp", line = 4295,
   FQN="llvm::initializeSROALegacyPassPass", NM="_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SROA.cpp -nm=_ZN4llvm28initializeSROALegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSROALegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSROALegacyPassPassFlag, initializeSROALegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSampleProfileLoaderLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp", line = 1197,
   FQN="llvm::initializeSampleProfileLoaderLegacyPassPass", NM="_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/SampleProfile.cpp -nm=_ZN4llvm43initializeSampleProfileLoaderLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSampleProfileLoaderLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSampleProfileLoaderLegacyPassPassFlag, initializeSampleProfileLoaderLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSanitizerCoverageModulePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp", line = 590,
   FQN="llvm::initializeSanitizerCoverageModulePass", NM="_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/SanitizerCoverage.cpp -nm=_ZN4llvm37initializeSanitizerCoverageModulePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSanitizerCoverageModulePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSanitizerCoverageModulePassFlag, initializeSanitizerCoverageModulePassOnce, std.ref_T$R(Registry));
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::initializeScalarizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp", line = 181,
   FQN="llvm::initializeScalarizerPass", NM="_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Scalarizer.cpp -nm=_ZN4llvm24initializeScalarizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeScalarizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeScalarizerPassFlag, initializeScalarizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSeparateConstOffsetFromGEPPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp", line = 434,
   FQN="llvm::initializeSeparateConstOffsetFromGEPPass", NM="_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SeparateConstOffsetFromGEP.cpp -nm=_ZN4llvm40initializeSeparateConstOffsetFromGEPPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSeparateConstOffsetFromGEPPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSeparateConstOffsetFromGEPPassFlag, initializeSeparateConstOffsetFromGEPPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeCFGSimplifyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp", line = 237,
   FQN="llvm::initializeCFGSimplifyPassPass", NM="_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SimplifyCFGPass.cpp -nm=_ZN4llvm29initializeCFGSimplifyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeCFGSimplifyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeCFGSimplifyPassPassFlag, initializeCFGSimplifyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeInstSimplifierPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp", line = 119,
   FQN="llvm::initializeInstSimplifierPass", NM="_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SimplifyInstructions.cpp -nm=_ZN4llvm28initializeInstSimplifierPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeInstSimplifierPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeInstSimplifierPassFlag, initializeInstSimplifierPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSinkingLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp", line = 304,
   FQN="llvm::initializeSinkingLegacyPassPass", NM="_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/Sink.cpp -nm=_ZN4llvm31initializeSinkingLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSinkingLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSinkingLegacyPassPassFlag, initializeSinkingLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeSpeculativeExecutionPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp", line = 137,
   FQN="llvm::initializeSpeculativeExecutionPass", NM="_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/SpeculativeExecution.cpp -nm=_ZN4llvm34initializeSpeculativeExecutionPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeSpeculativeExecutionPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeSpeculativeExecutionPassFlag, initializeSpeculativeExecutionPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStraightLineStrengthReducePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp", line = 217,
   FQN="llvm::initializeStraightLineStrengthReducePass", NM="_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StraightLineStrengthReduce.cpp -nm=_ZN4llvm40initializeStraightLineStrengthReducePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStraightLineStrengthReducePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStraightLineStrengthReducePassFlag, initializeStraightLineStrengthReducePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadPrototypesLegacyPassPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp", line = 83,
   FQN="llvm::initializeStripDeadPrototypesLegacyPassPass", NM="_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripDeadPrototypes.cpp -nm=_ZN4llvm43initializeStripDeadPrototypesLegacyPassPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStripDeadPrototypesLegacyPassPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStripDeadPrototypesLegacyPassPassFlag, initializeStripDeadPrototypesLegacyPassPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDeadDebugInfoPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 125,
   FQN="llvm::initializeStripDeadDebugInfoPass", NM="_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm32initializeStripDeadDebugInfoPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStripDeadDebugInfoPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStripDeadDebugInfoPassFlag, initializeStripDeadDebugInfoPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStripDebugDeclarePass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 117,
   FQN="llvm::initializeStripDebugDeclarePass", NM="_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm31initializeStripDebugDeclarePassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStripDebugDeclarePass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStripDebugDeclarePassFlag, initializeStripDebugDeclarePassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStripNonDebugSymbolsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 108,
   FQN="llvm::initializeStripNonDebugSymbolsPass", NM="_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm34initializeStripNonDebugSymbolsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStripNonDebugSymbolsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStripNonDebugSymbolsPassFlag, initializeStripNonDebugSymbolsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStripSymbolsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp", line = 100,
   FQN="llvm::initializeStripSymbolsPass", NM="_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/StripSymbols.cpp -nm=_ZN4llvm26initializeStripSymbolsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStripSymbolsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStripSymbolsPassFlag, initializeStripSymbolsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeStructurizeCFGPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp", line = 284,
   FQN="llvm::initializeStructurizeCFGPass", NM="_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/StructurizeCFG.cpp -nm=_ZN4llvm28initializeStructurizeCFGPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeStructurizeCFGPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeStructurizeCFGPassFlag, initializeStructurizeCFGPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeRewriteSymbolsPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp", line = 541,
   FQN="llvm::initializeRewriteSymbolsPass", NM="_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/SymbolRewriter.cpp -nm=_ZN4llvm28initializeRewriteSymbolsPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeRewriteSymbolsPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeRewriteSymbolsPassFlag, initializeRewriteSymbolsPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeTailCallElimPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp", line = 820,
   FQN="llvm::initializeTailCallElimPass", NM="_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Scalar/TailRecursionElimination.cpp -nm=_ZN4llvm26initializeTailCallElimPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeTailCallElimPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeTailCallElimPassFlag, initializeTailCallElimPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeThreadSanitizerPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp", line = 133,
   FQN="llvm::initializeThreadSanitizerPass", NM="_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Instrumentation/ThreadSanitizer.cpp -nm=_ZN4llvm29initializeThreadSanitizerPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeThreadSanitizerPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeThreadSanitizerPassFlag, initializeThreadSanitizerPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeUnifyFunctionExitNodesPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp", line = 27,
   FQN="llvm::initializeUnifyFunctionExitNodesPass", NM="_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/Utils/UnifyFunctionExitNodes.cpp -nm=_ZN4llvm36initializeUnifyFunctionExitNodesPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeUnifyFunctionExitNodesPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeUnifyFunctionExitNodesPassFlag, initializeUnifyFunctionExitNodesPassOnce, std.ref_T$R(Registry));
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::initializeWholeProgramDevirtPass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp", line = 307,
   FQN="llvm::initializeWholeProgramDevirtPass", NM="_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/Transforms/IPO/WholeProgramDevirt.cpp -nm=_ZN4llvm32initializeWholeProgramDevirtPassERNS_12PassRegistryE")
  //</editor-fold>
  @Override public void initializeWholeProgramDevirtPass(final PassRegistry /*&*/ Registry) {
    throw new UnsupportedOperationException("EmptyBody");
    //AdtsupportLlvmGlobals.call_once(InitializeWholeProgramDevirtPassFlag, initializeWholeProgramDevirtPassOnce, std.ref_T$R(Registry));
  }

}
