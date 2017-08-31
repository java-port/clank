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

package org.llvm.codegen.java.impl;

import org.clank.support.Converted;
import org.llvm.pass.PassRegistry;
import org.llvm.pass.spi.LllvmCodegenInitializer;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author alex
 */
@ServiceProvider(service = LllvmCodegenInitializer.class, position=1000)
public class LllvmCodegenInitializerImpl implements LllvmCodegenInitializer {
    //<editor-fold defaultstate="collapsed" desc="llvm::initializeAtomicExpandPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/AtomicExpandPass.cpp", line = 101,
    FQN="llvm::initializeAtomicExpandPass", NM="_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/AtomicExpandPass.cpp -nm=_ZN4llvm26initializeAtomicExpandPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeAtomicExpandPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeAtomicExpandPassFlag, initializeAtomicExpandPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeBranchFolderPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/BranchFolding.cpp", line = 90,
    FQN="llvm::initializeBranchFolderPassPass", NM="_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/BranchFolding.cpp -nm=_ZN4llvm30initializeBranchFolderPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeBranchFolderPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeBranchFolderPassPassFlag, initializeBranchFolderPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeCodeGenPreparePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/CodeGenPrepare.cpp", line = 207,
    FQN="llvm::initializeCodeGenPreparePass", NM="_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/CodeGenPrepare.cpp -nm=_ZN4llvm28initializeCodeGenPreparePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeCodeGenPreparePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeCodeGenPreparePassFlag, initializeCodeGenPreparePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeDeadMachineInstructionElimPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/DeadMachineInstructionElim.cpp", line = 57,
    FQN="llvm::initializeDeadMachineInstructionElimPass", NM="_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/DeadMachineInstructionElim.cpp -nm=_ZN4llvm40initializeDeadMachineInstructionElimPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeDeadMachineInstructionElimPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeDeadMachineInstructionElimPassFlag, initializeDeadMachineInstructionElimPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeDetectDeadLanesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/DetectDeadLanes.cpp", line = 135,
    FQN="llvm::initializeDetectDeadLanesPass", NM="_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/DetectDeadLanes.cpp -nm=_ZN4llvm29initializeDetectDeadLanesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeDetectDeadLanesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeDetectDeadLanesPassFlag, initializeDetectDeadLanesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeDwarfEHPreparePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/DwarfEHPrepare.cpp", line = 85,
    FQN="llvm::initializeDwarfEHPreparePass", NM="_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/DwarfEHPrepare.cpp -nm=_ZN4llvm28initializeDwarfEHPreparePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeDwarfEHPreparePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeDwarfEHPreparePassFlag, initializeDwarfEHPreparePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeEarlyIfConverterPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/EarlyIfConversion.cpp", line = 624,
    FQN="llvm::initializeEarlyIfConverterPass", NM="_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/EarlyIfConversion.cpp -nm=_ZN4llvm30initializeEarlyIfConverterPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeEarlyIfConverterPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeEarlyIfConverterPassFlag, initializeEarlyIfConverterPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeEdgeBundlesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/EdgeBundles.cpp", line = 29,
    FQN="llvm::initializeEdgeBundlesPass", NM="_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/EdgeBundles.cpp -nm=_ZN4llvm25initializeEdgeBundlesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeEdgeBundlesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeEdgeBundlesPassFlag, initializeEdgeBundlesPassOnce, std.ref_T$R(Registry));
   }

   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/ExpandISelPseudos.cpp", line = 44,
    FQN="llvm::initializeExpandISelPseudosPass", NM="_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ExpandISelPseudos.cpp -nm=_ZN4llvm31initializeExpandISelPseudosPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeExpandISelPseudosPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeExpandISelPseudosPassFlag, initializeExpandISelPseudosPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeExpandPostRAPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/ExpandPostRAPseudos.cpp", line = 61,
    FQN="llvm::initializeExpandPostRAPass", NM="_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ExpandPostRAPseudos.cpp -nm=_ZN4llvm26initializeExpandPostRAPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeExpandPostRAPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeExpandPostRAPassFlag, initializeExpandPostRAPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeFuncletLayoutPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/FuncletLayout.cpp", line = 40,
    FQN="llvm::initializeFuncletLayoutPass", NM="_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/FuncletLayout.cpp -nm=_ZN4llvm27initializeFuncletLayoutPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeFuncletLayoutPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeFuncletLayoutPassFlag, initializeFuncletLayoutPassOnce, std.ref_T$R(Registry));
   }
   //<editor-fold defaultstate="collapsed" desc="llvm::initializeGCModuleInfoPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GCMetadata.cpp", line = 43,
    FQN="llvm::initializeGCModuleInfoPass", NM="_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GCMetadata.cpp -nm=_ZN4llvm26initializeGCModuleInfoPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeGCModuleInfoPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeGCModuleInfoPassFlag, initializeGCModuleInfoPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeGCMachineCodeAnalysisPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp", line = 259,
    FQN="llvm::initializeGCMachineCodeAnalysisPass", NM="_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp -nm=_ZN4llvm35initializeGCMachineCodeAnalysisPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeGCMachineCodeAnalysisPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeGCMachineCodeAnalysisPassFlag, initializeGCMachineCodeAnalysisPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerIntrinsicsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp", line = 86,
    FQN="llvm::initializeLowerIntrinsicsPass", NM="_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GCRootLowering.cpp -nm=_ZN4llvm29initializeLowerIntrinsicsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLowerIntrinsicsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLowerIntrinsicsPassFlag, initializeLowerIntrinsicsPassOnce, std.ref_T$R(Registry));
   }

   /// Initialize all passes linked into the GlobalISel library.
   //<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalISel">
   @Converted(kind = Converted.Kind.AUTO,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/GlobalISel.cpp", line = 21,
    FQN="llvm::initializeGlobalISel", NM="_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/GlobalISel.cpp -nm=_ZN4llvm20initializeGlobalISelERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeGlobalISel(final PassRegistry /*&*/ Registry) {
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeGlobalMergePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalMerge.cpp", line = 199,
    FQN="llvm::initializeGlobalMergePass", NM="_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalMerge.cpp -nm=_ZN4llvm25initializeGlobalMergePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeGlobalMergePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeGlobalMergePassFlag, initializeGlobalMergePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeIRTranslatorPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/IRTranslator.cpp", line = 30,
    FQN="llvm::initializeIRTranslatorPass", NM="_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/IRTranslator.cpp -nm=_ZN4llvm26initializeIRTranslatorPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeIRTranslatorPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeIRTranslatorPassFlag, initializeIRTranslatorPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeIfConverterPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/IfConversion.cpp", line = 282,
    FQN="llvm::initializeIfConverterPass", NM="_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/IfConversion.cpp -nm=_ZN4llvm25initializeIfConverterPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeIfConverterPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeIfConverterPassFlag, initializeIfConverterPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeImplicitNullChecksPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/ImplicitNullChecks.cpp", line = 575,
    FQN="llvm::initializeImplicitNullChecksPass", NM="_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ImplicitNullChecks.cpp -nm=_ZN4llvm32initializeImplicitNullChecksPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeImplicitNullChecksPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeImplicitNullChecksPassFlag, initializeImplicitNullChecksPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeInterleavedAccessPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/InterleavedAccessPass.cpp", line = 110,
    FQN="llvm::initializeInterleavedAccessPass", NM="_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/InterleavedAccessPass.cpp -nm=_ZN4llvm31initializeInterleavedAccessPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeInterleavedAccessPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeInterleavedAccessPassFlag, initializeInterleavedAccessPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveDebugValuesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugValues.cpp", line = 239,
    FQN="llvm::initializeLiveDebugValuesPass", NM="_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugValues.cpp -nm=_ZN4llvm29initializeLiveDebugValuesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLiveDebugValuesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLiveDebugValuesPassFlag, initializeLiveDebugValuesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveDebugVariablesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugVariables.cpp", line = 62,
    FQN="llvm::initializeLiveDebugVariablesPass", NM="_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveDebugVariables.cpp -nm=_ZN4llvm32initializeLiveDebugVariablesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLiveDebugVariablesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLiveDebugVariablesPassFlag, initializeLiveDebugVariablesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveIntervalsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveIntervalAnalysis.cpp", line = 50,
    FQN="llvm::initializeLiveIntervalsPass", NM="_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveIntervalAnalysis.cpp -nm=_ZN4llvm27initializeLiveIntervalsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLiveIntervalsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLiveIntervalsPassFlag, initializeLiveIntervalsPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveRegMatrixPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveRegMatrix.cpp", line = 36,
    FQN="llvm::initializeLiveRegMatrixPass", NM="_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveRegMatrix.cpp -nm=_ZN4llvm27initializeLiveRegMatrixPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLiveRegMatrixPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLiveRegMatrixPassFlag, initializeLiveRegMatrixPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveStacksPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveStackAnalysis.cpp", line = 31,
    FQN="llvm::initializeLiveStacksPass", NM="_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveStackAnalysis.cpp -nm=_ZN4llvm24initializeLiveStacksPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLiveStacksPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLiveStacksPassFlag, initializeLiveStacksPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLiveVariablesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LiveVariables.cpp", line = 49,
    FQN="llvm::initializeLiveVariablesPass", NM="_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LiveVariables.cpp -nm=_ZN4llvm27initializeLiveVariablesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLiveVariablesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLiveVariablesPassFlag, initializeLiveVariablesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLocalStackSlotPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LocalStackSlotAllocation.cpp", line = 100,
    FQN="llvm::initializeLocalStackSlotPassPass", NM="_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LocalStackSlotAllocation.cpp -nm=_ZN4llvm32initializeLocalStackSlotPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLocalStackSlotPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLocalStackSlotPassPassFlag, initializeLocalStackSlotPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeLowerEmuTLSPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/LowerEmuTLS.cpp", line = 57,
    FQN="llvm::initializeLowerEmuTLSPass", NM="_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/LowerEmuTLS.cpp -nm=_ZN4llvm25initializeLowerEmuTLSPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeLowerEmuTLSPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeLowerEmuTLSPassFlag, initializeLowerEmuTLSPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMIRPrintingPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MIRPrintingPass.cpp", line = 63,
    FQN="llvm::initializeMIRPrintingPassPass", NM="_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MIRPrintingPass.cpp -nm=_ZN4llvm29initializeMIRPrintingPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMIRPrintingPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMIRPrintingPassPassFlag, initializeMIRPrintingPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockFrequencyInfoPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockFrequencyInfo.cpp", line = 116,
    FQN="llvm::initializeMachineBlockFrequencyInfoPass", NM="_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockFrequencyInfo.cpp -nm=_ZN4llvm39initializeMachineBlockFrequencyInfoPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineBlockFrequencyInfoPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineBlockFrequencyInfoPassFlag, initializeMachineBlockFrequencyInfoPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockPlacementPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp", line = 365,
    FQN="llvm::initializeMachineBlockPlacementPass", NM="_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp -nm=_ZN4llvm35initializeMachineBlockPlacementPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineBlockPlacementPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineBlockPlacementPassFlag, initializeMachineBlockPlacementPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBlockPlacementStatsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp", line = 1766,
    FQN="llvm::initializeMachineBlockPlacementStatsPass", NM="_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBlockPlacement.cpp -nm=_ZN4llvm40initializeMachineBlockPlacementStatsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineBlockPlacementStatsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineBlockPlacementStatsPassFlag, initializeMachineBlockPlacementStatsPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineBranchProbabilityInfoPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineBranchProbabilityInfo.cpp", line = 24,
    FQN="llvm::initializeMachineBranchProbabilityInfoPass", NM="_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineBranchProbabilityInfo.cpp -nm=_ZN4llvm42initializeMachineBranchProbabilityInfoPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineBranchProbabilityInfoPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineBranchProbabilityInfoPassFlag, initializeMachineBranchProbabilityInfoPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCSEPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp", line = 115,
    FQN="llvm::initializeMachineCSEPass", NM="_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCSE.cpp -nm=_ZN4llvm24initializeMachineCSEPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineCSEPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineCSEPassFlag, initializeMachineCSEPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCombinerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineCombiner.cpp", line = 92,
    FQN="llvm::initializeMachineCombinerPass", NM="_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCombiner.cpp -nm=_ZN4llvm29initializeMachineCombinerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineCombinerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineCombinerPassFlag, initializeMachineCombinerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineCopyPropagationPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineCopyPropagation.cpp", line = 81,
    FQN="llvm::initializeMachineCopyPropagationPass", NM="_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineCopyPropagation.cpp -nm=_ZN4llvm36initializeMachineCopyPropagationPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineCopyPropagationPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineCopyPropagationPassFlag, initializeMachineCopyPropagationPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineDominanceFrontierPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineDominanceFrontier.cpp", line = 29,
    FQN="llvm::initializeMachineDominanceFrontierPass", NM="_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineDominanceFrontier.cpp -nm=_ZN4llvm38initializeMachineDominanceFrontierPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineDominanceFrontierPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineDominanceFrontierPassFlag, initializeMachineDominanceFrontierPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineDominatorTreePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineDominators.cpp", line = 39,
    FQN="llvm::initializeMachineDominatorTreePass", NM="_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineDominators.cpp -nm=_ZN4llvm34initializeMachineDominatorTreePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineDominatorTreePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineDominatorTreePassFlag, initializeMachineDominatorTreePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineFunctionPrinterPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineFunctionPrinterPass.cpp", line = 57,
    FQN="llvm::initializeMachineFunctionPrinterPassPass", NM="_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineFunctionPrinterPass.cpp -nm=_ZN4llvm40initializeMachineFunctionPrinterPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineFunctionPrinterPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineFunctionPrinterPassPassFlag, initializeMachineFunctionPrinterPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeFinalizeMachineBundlesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp", line = 99,
    FQN="llvm::initializeFinalizeMachineBundlesPass", NM="_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp -nm=_ZN4llvm36initializeFinalizeMachineBundlesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeFinalizeMachineBundlesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeFinalizeMachineBundlesPassFlag, initializeFinalizeMachineBundlesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeUnpackMachineBundlesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp", line = 41,
    FQN="llvm::initializeUnpackMachineBundlesPass", NM="_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineInstrBundle.cpp -nm=_ZN4llvm34initializeUnpackMachineBundlesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeUnpackMachineBundlesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeUnpackMachineBundlesPassFlag, initializeUnpackMachineBundlesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineLICMPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineLICM.cpp", line = 246,
    FQN="llvm::initializeMachineLICMPass", NM="_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineLICM.cpp -nm=_ZN4llvm25initializeMachineLICMPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineLICMPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineLICMPassFlag, initializeMachineLICMPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineLoopInfoPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineLoopInfo.cpp", line = 33,
    FQN="llvm::initializeMachineLoopInfoPass", NM="_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineLoopInfo.cpp -nm=_ZN4llvm29initializeMachineLoopInfoPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineLoopInfoPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineLoopInfoPassFlag, initializeMachineLoopInfoPassOnce, std.ref_T$R(Registry));
   }


   // Handle the Pass registration stuff necessary to use DataLayout's.
   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineModuleInfoPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineModuleInfo.cpp", line = 30,
    FQN="llvm::initializeMachineModuleInfoPass", NM="_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineModuleInfo.cpp -nm=_ZN4llvm31initializeMachineModuleInfoPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineModuleInfoPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineModuleInfoPassFlag, initializeMachineModuleInfoPassOnce, std.ref_T$R(Registry));
   }


   //declare initializeMachinePostDominatorTreePass
   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachinePostDominatorTreePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachinePostDominators.cpp", line = 22,
    FQN="llvm::initializeMachinePostDominatorTreePass", NM="_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachinePostDominators.cpp -nm=_ZN4llvm38initializeMachinePostDominatorTreePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachinePostDominatorTreePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachinePostDominatorTreePassFlag, initializeMachinePostDominatorTreePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineRegionInfoPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineRegionInfo.cpp", line = 128,
    FQN="llvm::initializeMachineRegionInfoPassPass", NM="_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineRegionInfo.cpp -nm=_ZN4llvm35initializeMachineRegionInfoPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineRegionInfoPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineRegionInfoPassPassFlag, initializeMachineRegionInfoPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineSchedulerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp", line = 163,
    FQN="llvm::initializeMachineSchedulerPass", NM="_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp -nm=_ZN4llvm30initializeMachineSchedulerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineSchedulerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineSchedulerPassFlag, initializeMachineSchedulerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePostMachineSchedulerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp", line = 188,
    FQN="llvm::initializePostMachineSchedulerPass", NM="_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineScheduler.cpp -nm=_ZN4llvm34initializePostMachineSchedulerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePostMachineSchedulerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePostMachineSchedulerPassFlag, initializePostMachineSchedulerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineSinkingPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineSink.cpp", line = 155,
    FQN="llvm::initializeMachineSinkingPass", NM="_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineSink.cpp -nm=_ZN4llvm28initializeMachineSinkingPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineSinkingPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineSinkingPassFlag, initializeMachineSinkingPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineTraceMetricsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineTraceMetrics.cpp", line = 37,
    FQN="llvm::initializeMachineTraceMetricsPass", NM="_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineTraceMetrics.cpp -nm=_ZN4llvm33initializeMachineTraceMetricsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineTraceMetricsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineTraceMetricsPassFlag, initializeMachineTraceMetricsPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeMachineVerifierPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/MachineVerifier.cpp", line = 282,
    FQN="llvm::initializeMachineVerifierPassPass", NM="_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/MachineVerifier.cpp -nm=_ZN4llvm33initializeMachineVerifierPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeMachineVerifierPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeMachineVerifierPassPassFlag, initializeMachineVerifierPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeOptimizePHIsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/OptimizePHIs.cpp", line = 62,
    FQN="llvm::initializeOptimizePHIsPass", NM="_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/OptimizePHIs.cpp -nm=_ZN4llvm26initializeOptimizePHIsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeOptimizePHIsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeOptimizePHIsPassFlag, initializeOptimizePHIsPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePHIEliminationPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PHIElimination.cpp", line = 119,
    FQN="llvm::initializePHIEliminationPass", NM="_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PHIElimination.cpp -nm=_ZN4llvm28initializePHIEliminationPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePHIEliminationPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePHIEliminationPassFlag, initializePHIEliminationPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePatchableFunctionPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PatchableFunction.cpp", line = 87,
    FQN="llvm::initializePatchableFunctionPass", NM="_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PatchableFunction.cpp -nm=_ZN4llvm31initializePatchableFunctionPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePatchableFunctionPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePatchableFunctionPassFlag, initializePatchableFunctionPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePeepholeOptimizerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PeepholeOptimizer.cpp", line = 400,
    FQN="llvm::initializePeepholeOptimizerPass", NM="_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PeepholeOptimizer.cpp -nm=_ZN4llvm31initializePeepholeOptimizerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePeepholeOptimizerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePeepholeOptimizerPassFlag, initializePeepholeOptimizerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePostRAHazardRecognizerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PostRAHazardRecognizer.cpp", line = 66,
    FQN="llvm::initializePostRAHazardRecognizerPass", NM="_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PostRAHazardRecognizer.cpp -nm=_ZN4llvm36initializePostRAHazardRecognizerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePostRAHazardRecognizerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePostRAHazardRecognizerPassFlag, initializePostRAHazardRecognizerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePostRASchedulerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PostRASchedulerList.cpp", line = 203,
    FQN="llvm::initializePostRASchedulerPass", NM="_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PostRASchedulerList.cpp -nm=_ZN4llvm29initializePostRASchedulerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePostRASchedulerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePostRASchedulerPassFlag, initializePostRASchedulerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePreISelIntrinsicLoweringLegacyPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PreISelIntrinsicLowering.cpp", line = 78,
    FQN="llvm::initializePreISelIntrinsicLoweringLegacyPassPass", NM="_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PreISelIntrinsicLowering.cpp -nm=_ZN4llvm48initializePreISelIntrinsicLoweringLegacyPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePreISelIntrinsicLoweringLegacyPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeProcessImplicitDefsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/ProcessImplicitDefs.cpp", line = 56,
    FQN="llvm::initializeProcessImplicitDefsPass", NM="_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ProcessImplicitDefs.cpp -nm=_ZN4llvm33initializeProcessImplicitDefsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeProcessImplicitDefsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeProcessImplicitDefsPassFlag, initializeProcessImplicitDefsPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePEIPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/PrologEpilogInserter.cpp", line = 144,
    FQN="llvm::initializePEIPass", NM="_ZN4llvm17initializePEIPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/PrologEpilogInserter.cpp -nm=_ZN4llvm17initializePEIPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePEIPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePEIPassFlag, initializePEIPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegBankSelectPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/RegBankSelect.cpp", line = 43,
    FQN="llvm::initializeRegBankSelectPass", NM="_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/GlobalISel/RegBankSelect.cpp -nm=_ZN4llvm27initializeRegBankSelectPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeRegBankSelectPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeRegBankSelectPassFlag, initializeRegBankSelectPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeRegisterCoalescerPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/RegisterCoalescer.cpp", line = 273,
    FQN="llvm::initializeRegisterCoalescerPass", NM="_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/RegisterCoalescer.cpp -nm=_ZN4llvm31initializeRegisterCoalescerPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeRegisterCoalescerPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeRegisterCoalescerPassFlag, initializeRegisterCoalescerPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializePhysicalRegisterUsageInfoPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/RegisterUsageInfo.cpp", line = 29,
    FQN="llvm::initializePhysicalRegisterUsageInfoPass", NM="_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/RegisterUsageInfo.cpp -nm=_ZN4llvm39initializePhysicalRegisterUsageInfoPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializePhysicalRegisterUsageInfoPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializePhysicalRegisterUsageInfoPassFlag, initializePhysicalRegisterUsageInfoPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeRenameIndependentSubregsPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/RenameIndependentSubregs.cpp", line = 119,
    FQN="llvm::initializeRenameIndependentSubregsPass", NM="_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/RenameIndependentSubregs.cpp -nm=_ZN4llvm38initializeRenameIndependentSubregsPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeRenameIndependentSubregsPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeRenameIndependentSubregsPassFlag, initializeRenameIndependentSubregsPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeSafeStackPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/SafeStack.cpp", line = 846,
    FQN="llvm::initializeSafeStackPass", NM="_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SafeStack.cpp -nm=_ZN4llvm23initializeSafeStackPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeSafeStackPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeSafeStackPassFlag, initializeSafeStackPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeShadowStackGCLoweringPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/ShadowStackGCLowering.cpp", line = 71,
    FQN="llvm::initializeShadowStackGCLoweringPass", NM="_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ShadowStackGCLowering.cpp -nm=_ZN4llvm35initializeShadowStackGCLoweringPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeShadowStackGCLoweringPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeShrinkWrapPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/ShrinkWrap.cpp", line = 221,
    FQN="llvm::initializeShrinkWrapPass", NM="_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/ShrinkWrap.cpp -nm=_ZN4llvm24initializeShrinkWrapPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeShrinkWrapPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeShrinkWrapPassFlag, initializeShrinkWrapPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeSjLjEHPreparePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/SjLjEHPrepare.cpp", line = 76,
    FQN="llvm::initializeSjLjEHPreparePass", NM="_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SjLjEHPrepare.cpp -nm=_ZN4llvm27initializeSjLjEHPreparePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeSjLjEHPreparePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeSjLjEHPreparePassFlag, initializeSjLjEHPreparePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeSlotIndexesPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/SlotIndexes.cpp", line = 22,
    FQN="llvm::initializeSlotIndexesPass", NM="_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SlotIndexes.cpp -nm=_ZN4llvm25initializeSlotIndexesPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeSlotIndexesPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeSlotIndexesPassFlag, initializeSlotIndexesPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeSpillPlacementPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/SpillPlacement.cpp", line = 50,
    FQN="llvm::initializeSpillPlacementPass", NM="_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/SpillPlacement.cpp -nm=_ZN4llvm28initializeSpillPlacementPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeSpillPlacementPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeSpillPlacementPassFlag, initializeSpillPlacementPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeStackColoringPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/StackColoring.cpp", line = 379,
    FQN="llvm::initializeStackColoringPass", NM="_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackColoring.cpp -nm=_ZN4llvm27initializeStackColoringPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeStackColoringPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeStackColoringPassFlag, initializeStackColoringPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeStackMapLivenessPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/StackMapLivenessAnalysis.cpp", line = 88,
    FQN="llvm::initializeStackMapLivenessPass", NM="_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackMapLivenessAnalysis.cpp -nm=_ZN4llvm30initializeStackMapLivenessPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeStackMapLivenessPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeStackMapLivenessPassFlag, initializeStackMapLivenessPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeStackProtectorPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/StackProtector.cpp", line = 53,
    FQN="llvm::initializeStackProtectorPass", NM="_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackProtector.cpp -nm=_ZN4llvm28initializeStackProtectorPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeStackProtectorPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeStackProtectorPassFlag, initializeStackProtectorPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeStackSlotColoringPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/StackSlotColoring.cpp", line = 124,
    FQN="llvm::initializeStackSlotColoringPass", NM="_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/StackSlotColoring.cpp -nm=_ZN4llvm31initializeStackSlotColoringPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeStackSlotColoringPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeStackSlotColoringPassFlag, initializeStackSlotColoringPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeTailDuplicatePassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/TailDuplication.cpp", line = 43,
    FQN="llvm::initializeTailDuplicatePassPass", NM="_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/TailDuplication.cpp -nm=_ZN4llvm31initializeTailDuplicatePassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeTailDuplicatePassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeTailDuplicatePassPassFlag, initializeTailDuplicatePassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeTargetPassConfigPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/TargetPassConfig.cpp", line = 198,
    FQN="llvm::initializeTargetPassConfigPass", NM="_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/TargetPassConfig.cpp -nm=_ZN4llvm30initializeTargetPassConfigPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeTargetPassConfigPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeTargetPassConfigPassFlag, initializeTargetPassConfigPassOnce, std.ref_T$R(Registry));
   }


   //<editor-fold defaultstate="collapsed" desc="llvm::initializeTwoAddressInstructionPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/TwoAddressInstructionPass.cpp", line = 177,
    FQN="llvm::initializeTwoAddressInstructionPassPass", NM="_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/TwoAddressInstructionPass.cpp -nm=_ZN4llvm39initializeTwoAddressInstructionPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeTwoAddressInstructionPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeTwoAddressInstructionPassPassFlag, initializeTwoAddressInstructionPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeUnreachableBlockElimLegacyPassPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp", line = 92,
    FQN="llvm::initializeUnreachableBlockElimLegacyPassPass", NM="_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp -nm=_ZN4llvm44initializeUnreachableBlockElimLegacyPassPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeUnreachableBlockElimLegacyPassPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeUnreachableBlockElimLegacyPassPassFlag, initializeUnreachableBlockElimLegacyPassPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeUnreachableMachineBlockElimPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp", line = 121,
    FQN="llvm::initializeUnreachableMachineBlockElimPass", NM="_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/UnreachableBlockElim.cpp -nm=_ZN4llvm41initializeUnreachableMachineBlockElimPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeUnreachableMachineBlockElimPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeUnreachableMachineBlockElimPassFlag, initializeUnreachableMachineBlockElimPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeVirtRegMapPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp", line = 52,
    FQN="llvm::initializeVirtRegMapPass", NM="_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp -nm=_ZN4llvm24initializeVirtRegMapPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeVirtRegMapPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeVirtRegMapPassFlag, initializeVirtRegMapPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeVirtRegRewriterPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp", line = 194,
    FQN="llvm::initializeVirtRegRewriterPass", NM="_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/VirtRegMap.cpp -nm=_ZN4llvm29initializeVirtRegRewriterPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeVirtRegRewriterPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeVirtRegRewriterPassFlag, initializeVirtRegRewriterPassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeWinEHPreparePass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/WinEHPrepare.cpp", line = 96,
    FQN="llvm::initializeWinEHPreparePass", NM="_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/WinEHPrepare.cpp -nm=_ZN4llvm26initializeWinEHPreparePassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeWinEHPreparePass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeWinEHPreparePassFlag, initializeWinEHPreparePassOnce, std.ref_T$R(Registry));
   }

   //<editor-fold defaultstate="collapsed" desc="llvm::initializeXRayInstrumentationPass">
   @Converted(kind = Converted.Kind.AUTO_NO_BODY,
    source = "${LLVM_SRC}/llvm/lib/CodeGen/XRayInstrumentation.cpp", line = 95,
    FQN="llvm::initializeXRayInstrumentationPass", NM="_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE",
    cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.ir/llvmToClangType ${LLVM_SRC}/llvm/lib/CodeGen/XRayInstrumentation.cpp -nm=_ZN4llvm33initializeXRayInstrumentationPassERNS_12PassRegistryE")
   //</editor-fold>
    @Override
   public void initializeXRayInstrumentationPass(final PassRegistry /*&*/ Registry) {
     throw new UnsupportedOperationException("EmptyBody");
     //AdtsupportLlvmGlobals.call_once(InitializeXRayInstrumentationPassFlag, initializeXRayInstrumentationPassOnce, std.ref_T$R(Registry));
   }
    
}
