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

package org.llvm.mc;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;


//===----------------------------------------------------------------------===//
///
/// MCSubtargetInfo - Generic base class for all target subtargets.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 30,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 29,
 FQN="llvm::MCSubtargetInfo", NM="_ZN4llvm15MCSubtargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfoE")
//</editor-fold>
public class MCSubtargetInfo implements Destructors.ClassWithDestructor {
  private Triple TargetTriple; // Target triple
  private std.string CPU; // CPU being targeted.
  private ArrayRef<SubtargetFeatureKV> ProcFeatures; // Processor feature list
  private ArrayRef<SubtargetFeatureKV> ProcDesc; // Processor descriptions
  
  // Scheduler machine model
  private /*const*/ SubtargetInfoKV /*P*/ ProcSchedModels;
  private /*const*/ MCWriteProcResEntry /*P*/ WriteProcResTable;
  private /*const*/ MCWriteLatencyEntry /*P*/ WriteLatencyTable;
  private /*const*/ MCReadAdvanceEntry /*P*/ ReadAdvanceTable;
  private /*const*/ MCSchedModel /*P*/ CPUSchedModel;
  
  private /*const*/ InstrStage /*P*/ Stages; // Instruction itinerary stages
  private /*const*/uint$ptr/*uint P*/ OperandCycles; // Itinerary operand cycles
  private /*const*/uint$ptr/*uint P*/ ForwardingPaths; // Forwarding paths
  private FeatureBitset FeatureBits; // Feature bits for current CPU + FS
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::MCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 47,
   FQN="llvm::MCSubtargetInfo::MCSubtargetInfo", NM="_ZN4llvm15MCSubtargetInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfoC1Ev")
  //</editor-fold>
  protected/*private*/ MCSubtargetInfo() { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 48,
   FQN="llvm::MCSubtargetInfo::operator=", NM="_ZN4llvm15MCSubtargetInfoaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfoaSEOS0_")
  //</editor-fold>
  protected/*private*/ MCSubtargetInfo /*&*/ $assignMove(final MCSubtargetInfo /*&&*/$Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 49,
   FQN="llvm::MCSubtargetInfo::operator=", NM="_ZN4llvm15MCSubtargetInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ MCSubtargetInfo /*&*/ $assign(final /*const*/ MCSubtargetInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::MCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 52,
   FQN="llvm::MCSubtargetInfo::MCSubtargetInfo", NM="_ZN4llvm15MCSubtargetInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfoC1ERKS0_")
  //</editor-fold>
  public MCSubtargetInfo(final /*const*/ MCSubtargetInfo /*&*/ $Prm0) {
    // : TargetTriple(.TargetTriple), CPU(.CPU), ProcFeatures(.ProcFeatures), ProcDesc(.ProcDesc), ProcSchedModels(.ProcSchedModels), WriteProcResTable(.WriteProcResTable), WriteLatencyTable(.WriteLatencyTable), ReadAdvanceTable(.ReadAdvanceTable), CPUSchedModel(.CPUSchedModel), Stages(.Stages), OperandCycles(.OperandCycles), ForwardingPaths(.ForwardingPaths), FeatureBits(.FeatureBits)/* = default*/ 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::MCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 39,
   FQN="llvm::MCSubtargetInfo::MCSubtargetInfo", NM="_ZN4llvm15MCSubtargetInfoC1ERKNS_6TripleENS_9StringRefES4_NS_8ArrayRefINS_18SubtargetFeatureKVEEES7_PKNS_15SubtargetInfoKVEPKNS_19MCWriteProcResEntryEPKNS_19MCWriteLatencyEntryEPKNS_18MCReadAdvanceEntryEPKNS_10InstrStageEPKjSO_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfoC1ERKNS_6TripleENS_9StringRefES4_NS_8ArrayRefINS_18SubtargetFeatureKVEEES7_PKNS_15SubtargetInfoKVEPKNS_19MCWriteProcResEntryEPKNS_19MCWriteLatencyEntryEPKNS_18MCReadAdvanceEntryEPKNS_10InstrStageEPKjSO_")
  //</editor-fold>
  public MCSubtargetInfo(final /*const*/ Triple /*&*/ TT, StringRef C, StringRef FS, 
      ArrayRef<SubtargetFeatureKV> PF, ArrayRef<SubtargetFeatureKV> PD, 
      /*const*/ SubtargetInfoKV /*P*/ ProcSched, /*const*/ MCWriteProcResEntry /*P*/ WPR, 
      /*const*/ MCWriteLatencyEntry /*P*/ WL, /*const*/ MCReadAdvanceEntry /*P*/ RA, 
      /*const*/ InstrStage /*P*/ IS, /*const*/uint$ptr/*uint P*/ OC, /*const*/uint$ptr/*uint P*/ FP) {
    // : TargetTriple(TT), CPU(C.operator basic_string()), ProcFeatures(PF), ProcDesc(PD), ProcSchedModels(ProcSched), WriteProcResTable(WPR), WriteLatencyTable(WL), ReadAdvanceTable(RA), Stages(IS), OperandCycles(OC), ForwardingPaths(FP), FeatureBits() 
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// getTargetTriple - Return the target triple string.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getTargetTriple">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 62,
   FQN="llvm::MCSubtargetInfo::getTargetTriple", NM="_ZNK4llvm15MCSubtargetInfo15getTargetTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo15getTargetTripleEv")
  //</editor-fold>
  public /*const*/ Triple /*&*/ getTargetTriple() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getCPU - Return the CPU string.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getCPU">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 65,
   FQN="llvm::MCSubtargetInfo::getCPU", NM="_ZNK4llvm15MCSubtargetInfo6getCPUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo6getCPUEv")
  //</editor-fold>
  public StringRef getCPU() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getFeatureBits - Return the feature bits.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getFeatureBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 72,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 71,
   FQN="llvm::MCSubtargetInfo::getFeatureBits", NM="_ZNK4llvm15MCSubtargetInfo14getFeatureBitsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo14getFeatureBitsEv")
  //</editor-fold>
  public /*const*/ FeatureBitset /*&*/ getFeatureBits() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// setFeatureBits - Set the feature bits.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::setFeatureBits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 78,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 77,
   FQN="llvm::MCSubtargetInfo::setFeatureBits", NM="_ZN4llvm15MCSubtargetInfo14setFeatureBitsERKNS_13FeatureBitsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfo14setFeatureBitsERKNS_13FeatureBitsetE")
  //</editor-fold>
  public void setFeatureBits(final /*const*/ FeatureBitset /*&*/ FeatureBits_) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*protected:*/
  /// Initialize the scheduling model and feature bits.
  ///
  /// FIXME: Find a way to stick this in the constructor, since it should only
  /// be called during initialization.
  /// Initialize the scheduling model and feature bits.
  ///
  /// FIXME: Find a way to stick this in the constructor, since it should only
  /// be called during initialization.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::InitMCProcessorInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 27,
   FQN="llvm::MCSubtargetInfo::InitMCProcessorInfo", NM="_ZN4llvm15MCSubtargetInfo19InitMCProcessorInfoENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfo19InitMCProcessorInfoENS_9StringRefES1_")
  //</editor-fold>
  protected void InitMCProcessorInfo(StringRef CPU, StringRef FS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  /// Set the features to the default for the given CPU with an appended feature
  /// string.
  /// Set the features to the default for the given CPU with an appended feature
  /// string.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::setDefaultFeatures">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 35,
   FQN="llvm::MCSubtargetInfo::setDefaultFeatures", NM="_ZN4llvm15MCSubtargetInfo18setDefaultFeaturesENS_9StringRefES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfo18setDefaultFeaturesENS_9StringRefES1_")
  //</editor-fold>
  public void setDefaultFeatures(StringRef CPU, StringRef FS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// ToggleFeature - Toggle a feature and returns the re-computed feature
  /// bits. This version does not change the implied bits.
  
  /// ToggleFeature - Toggle a feature and returns the re-computed feature
  /// bits. This version does not change the implied bits.
  
  /// ToggleFeature - Toggle a feature and returns the re-computed feature
  /// bits. This version does not change the implied bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::ToggleFeature">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 53,
   FQN="llvm::MCSubtargetInfo::ToggleFeature", NM="_ZN4llvm15MCSubtargetInfo13ToggleFeatureEy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfo13ToggleFeatureEy")
  //</editor-fold>
  public FeatureBitset ToggleFeature(long/*uint64_t*/ FB) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// ToggleFeature - Toggle a feature and returns the re-computed feature
  /// bits. This version does not change the implied bits.
  
  /// ToggleFeature - Toggle a feature and returns the re-computed feature
  /// bits. This version does not change the implied bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::ToggleFeature">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 58,
   FQN="llvm::MCSubtargetInfo::ToggleFeature", NM="_ZN4llvm15MCSubtargetInfo13ToggleFeatureERKNS_13FeatureBitsetE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfo13ToggleFeatureERKNS_13FeatureBitsetE")
  //</editor-fold>
  public FeatureBitset ToggleFeature(final /*const*/ FeatureBitset /*&*/ FB) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// ToggleFeature - Toggle a set of features and returns the re-computed
  /// feature bits. This version will also change all implied bits.
  
  /// ToggleFeature - Toggle a set of features and returns the re-computed
  /// feature bits. This version will also change all implied bits.
  
  /// ToggleFeature - Toggle a feature and returns the re-computed feature
  /// bits. This version will also change all implied bits.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::ToggleFeature">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 65,
   FQN="llvm::MCSubtargetInfo::ToggleFeature", NM="_ZN4llvm15MCSubtargetInfo13ToggleFeatureENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfo13ToggleFeatureENS_9StringRefE")
  //</editor-fold>
  public FeatureBitset ToggleFeature(StringRef FS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Apply a feature flag and return the re-computed feature bits, including
  /// all feature bits implied by the flag.
  
  /// Apply a feature flag and return the re-computed feature bits, including
  /// all feature bits implied by the flag.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::ApplyFeatureFlag">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 70,
   FQN="llvm::MCSubtargetInfo::ApplyFeatureFlag", NM="_ZN4llvm15MCSubtargetInfo16ApplyFeatureFlagENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZN4llvm15MCSubtargetInfo16ApplyFeatureFlagENS_9StringRefE")
  //</editor-fold>
  public FeatureBitset ApplyFeatureFlag(StringRef FS) {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// getSchedModelForCPU - Get the machine model of a CPU.
  ///
  
  /// getSchedModelForCPU - Get the machine model of a CPU.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getSchedModelForCPU">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 75,
   FQN="llvm::MCSubtargetInfo::getSchedModelForCPU", NM="_ZNK4llvm15MCSubtargetInfo19getSchedModelForCPUENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZNK4llvm15MCSubtargetInfo19getSchedModelForCPUENS_9StringRefE")
  //</editor-fold>
  public /*const*/ MCSchedModel /*&*/ getSchedModelForCPU(StringRef CPU) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Get the machine model for this subtarget's CPU.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getSchedModel">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 115,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 114,
   FQN="llvm::MCSubtargetInfo::getSchedModel", NM="_ZNK4llvm15MCSubtargetInfo13getSchedModelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo13getSchedModelEv")
  //</editor-fold>
  public /*const*/ MCSchedModel /*&*/ getSchedModel() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// Return an iterator at the first process resource consumed by the given
  /// scheduling class.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getWriteProcResBegin">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 119,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 118,
   FQN="llvm::MCSubtargetInfo::getWriteProcResBegin", NM="_ZNK4llvm15MCSubtargetInfo20getWriteProcResBeginEPKNS_16MCSchedClassDescE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo20getWriteProcResBeginEPKNS_16MCSchedClassDescE")
  //</editor-fold>
  public /*const*/ MCWriteProcResEntry /*P*/ getWriteProcResBegin(/*const*/ MCSchedClassDesc /*P*/ SC) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getWriteProcResEnd">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 123,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 122,
   FQN="llvm::MCSubtargetInfo::getWriteProcResEnd", NM="_ZNK4llvm15MCSubtargetInfo18getWriteProcResEndEPKNS_16MCSchedClassDescE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo18getWriteProcResEndEPKNS_16MCSchedClassDescE")
  //</editor-fold>
  public /*const*/ MCWriteProcResEntry /*P*/ getWriteProcResEnd(/*const*/ MCSchedClassDesc /*P*/ SC) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getWriteLatencyEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 127,
   FQN="llvm::MCSubtargetInfo::getWriteLatencyEntry", NM="_ZNK4llvm15MCSubtargetInfo20getWriteLatencyEntryEPKNS_16MCSchedClassDescEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo20getWriteLatencyEntryEPKNS_16MCSchedClassDescEj")
  //</editor-fold>
  public /*const*/ MCWriteLatencyEntry /*P*/ getWriteLatencyEntry(/*const*/ MCSchedClassDesc /*P*/ SC, 
                      /*uint*/int DefIdx) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getReadAdvanceCycles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 136,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 135,
   FQN="llvm::MCSubtargetInfo::getReadAdvanceCycles", NM="_ZNK4llvm15MCSubtargetInfo20getReadAdvanceCyclesEPKNS_16MCSchedClassDescEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo20getReadAdvanceCyclesEPKNS_16MCSchedClassDescEjj")
  //</editor-fold>
  public int getReadAdvanceCycles(/*const*/ MCSchedClassDesc /*P*/ SC, /*uint*/int UseIdx, 
                      /*uint*/int WriteResID) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getInstrItineraryForCPU - Get scheduling itinerary of a CPU.
  ///
  
  /// getInstrItineraryForCPU - Get scheduling itinerary of a CPU.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::getInstrItineraryForCPU">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 100,
   FQN="llvm::MCSubtargetInfo::getInstrItineraryForCPU", NM="_ZNK4llvm15MCSubtargetInfo23getInstrItineraryForCPUENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZNK4llvm15MCSubtargetInfo23getInstrItineraryForCPUENS_9StringRefE")
  //</editor-fold>
  public InstrItineraryData getInstrItineraryForCPU(StringRef CPU) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Initialize an InstrItineraryData instance.
  
  /// Initialize an InstrItineraryData instance.
  
  /// Initialize an InstrItineraryData instance.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::initInstrItins">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp", line = 107,
   FQN="llvm::MCSubtargetInfo::initInstrItins", NM="_ZNK4llvm15MCSubtargetInfo14initInstrItinsERNS_18InstrItineraryDataE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCSubtargetInfo.cpp -nm=_ZNK4llvm15MCSubtargetInfo14initInstrItinsERNS_18InstrItineraryDataE")
  //</editor-fold>
  public void initInstrItins(final InstrItineraryData /*&*/ InstrItins) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// Check whether the CPU string is valid.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::isCPUStringValid">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 163,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 162,
   FQN="llvm::MCSubtargetInfo::isCPUStringValid", NM="_ZNK4llvm15MCSubtargetInfo16isCPUStringValidENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm15MCSubtargetInfo16isCPUStringValidENS_9StringRefE")
  //</editor-fold>
  public boolean isCPUStringValid(StringRef CPU) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCSubtargetInfo::~MCSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", line = 30,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCSubtargetInfo.h", old_line = 29,
   FQN="llvm::MCSubtargetInfo::~MCSubtargetInfo", NM="_ZN4llvm15MCSubtargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm15MCSubtargetInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "TargetTriple=" + TargetTriple // NOI18N
              + ", CPU=" + CPU // NOI18N
              + ", ProcFeatures=" + ProcFeatures // NOI18N
              + ", ProcDesc=" + ProcDesc // NOI18N
              + ", ProcSchedModels=" + ProcSchedModels // NOI18N
              + ", WriteProcResTable=" + WriteProcResTable // NOI18N
              + ", WriteLatencyTable=" + WriteLatencyTable // NOI18N
              + ", ReadAdvanceTable=" + ReadAdvanceTable // NOI18N
              + ", CPUSchedModel=" + CPUSchedModel // NOI18N
              + ", Stages=" + Stages // NOI18N
              + ", OperandCycles=" + OperandCycles // NOI18N
              + ", ForwardingPaths=" + ForwardingPaths // NOI18N
              + ", FeatureBits=" + FeatureBits; // NOI18N
  }
}
