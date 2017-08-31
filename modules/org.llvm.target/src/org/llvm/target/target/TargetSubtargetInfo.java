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

package org.llvm.target.target;

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
import org.llvm.analysis.*;
import org.llvm.mc.*;
import org.llvm.ir.*;


//===----------------------------------------------------------------------===//
///
/// TargetSubtargetInfo - Generic base class for all target subtargets.  All
/// Target-specific options that control code generation and printing should
/// be exposed through a TargetSubtargetInfo-derived class.
///
//<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 49,
 FQN="llvm::TargetSubtargetInfo", NM="_ZN4llvm19TargetSubtargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm19TargetSubtargetInfoE")
//</editor-fold>
public class TargetSubtargetInfo extends /*public*/ MCSubtargetInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::TargetSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 50,
   FQN="llvm::TargetSubtargetInfo::TargetSubtargetInfo", NM="_ZN4llvm19TargetSubtargetInfoC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm19TargetSubtargetInfoC1ERKS0_")
  //</editor-fold>
  protected/*private*/ TargetSubtargetInfo(final /*const*/ TargetSubtargetInfo /*&*/ $Prm0) {  super($Prm0); throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::operator=">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 51,
   FQN="llvm::TargetSubtargetInfo::operator=", NM="_ZN4llvm19TargetSubtargetInfoaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm19TargetSubtargetInfoaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ TargetSubtargetInfo /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::TargetSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 52,
   FQN="llvm::TargetSubtargetInfo::TargetSubtargetInfo", NM="_ZN4llvm19TargetSubtargetInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm19TargetSubtargetInfoC1Ev")
  //</editor-fold>
  protected/*private*/ TargetSubtargetInfo() { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // Can only create subclasses...
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::TargetSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 55,
   FQN="llvm::TargetSubtargetInfo::TargetSubtargetInfo", NM="_ZN4llvm19TargetSubtargetInfoC1ERKNS_6TripleENS_9StringRefES4_NS_8ArrayRefINS_18SubtargetFeatureKVEEES7_PKNS_15SubtargetInfoKVEPKNS_19MCWriteProcResEntryEPKNS_19MCWriteLatencyEntryEPKNS_18MCReadAdvanceEntryEPKNS_10InstrStageEPKjSO_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm19TargetSubtargetInfoC1ERKNS_6TripleENS_9StringRefES4_NS_8ArrayRefINS_18SubtargetFeatureKVEEES7_PKNS_15SubtargetInfoKVEPKNS_19MCWriteProcResEntryEPKNS_19MCWriteLatencyEntryEPKNS_18MCReadAdvanceEntryEPKNS_10InstrStageEPKjSO_")
  //</editor-fold>
  protected TargetSubtargetInfo(final /*const*/ Triple /*&*/ TT, StringRef CPU, StringRef FS, 
      ArrayRef<SubtargetFeatureKV> PF, 
      ArrayRef<SubtargetFeatureKV> PD, 
      /*const*/ SubtargetInfoKV /*P*/ ProcSched, 
      /*const*/ MCWriteProcResEntry /*P*/ WPR, 
      /*const*/ MCWriteLatencyEntry /*P*/ WL, 
      /*const*/ MCReadAdvanceEntry /*P*/ RA, /*const*/ InstrStage /*P*/ IS, 
      /*const*/uint$ptr/*uint P*/ OC, /*const*/uint$ptr/*uint P*/ FP) {
    throw new UnsupportedOperationException("EmptyBody");
  }


/*public:*/
  // AntiDepBreakMode - Type of anti-dependence breaking that should
  // be performed before post-RA scheduling.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 67,
   FQN="llvm::TargetSubtargetInfo::(anonymous)", NM="_AntiDepBreakMode",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_AntiDepBreakMode")
  //</editor-fold>
  public enum AntiDepBreakMode implements Native.NativeUIntEnum {
    ANTIDEP_NONE(0),
    ANTIDEP_CRITICAL(ANTIDEP_NONE.getValue() + 1),
    ANTIDEP_ALL(ANTIDEP_CRITICAL.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static AntiDepBreakMode valueOf(int val) {
      AntiDepBreakMode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final AntiDepBreakMode[] VALUES;
      private static final AntiDepBreakMode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (AntiDepBreakMode kind : AntiDepBreakMode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new AntiDepBreakMode[min < 0 ? (1-min) : 0];
        VALUES = new AntiDepBreakMode[max >= 0 ? (1+max) : 0];
        for (AntiDepBreakMode kind : AntiDepBreakMode.values()) {
          if (kind.value < 0) {
            if (_VALUES[-kind.value] == null) {
              _VALUES[-kind.value] = kind;
            } else {
              assert true: "Must not replace " + _VALUES[-kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          } else {
            if (VALUES[kind.value] == null) {
              VALUES[kind.value] = kind;
            } else {
              assert true: "Must not replace " + VALUES[kind.value] + " by " + kind + ". Switch to int-based enum or filter valid.";
            }
          }
        }
      }
    }

    private final /*uint*/int value;
    private AntiDepBreakMode(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
  // JAVA: typedef enum AntiDepBreakMode AntiDepBreakMode;
  // JAVA: typedef SmallVectorImpl<const TargetRegisterClass *> RegClassVector
//  public final class RegClassVector extends SmallVectorImpl</*const*/ TargetRegisterClass /*P*/ >{ };
  
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::~TargetSubtargetInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 70,
   FQN="llvm::TargetSubtargetInfo::~TargetSubtargetInfo", NM="_ZN4llvm19TargetSubtargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN4llvm19TargetSubtargetInfoD0Ev")
  //</editor-fold>
  public /*virtual*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
//  // Interfaces to the major aspects of target machine information:
//  //
//  // -- Instruction opcode and operand information
//  // -- Pipelines and scheduling information
//  // -- Stack frame information
//  // -- Selection DAG lowering information
//  // -- Call lowering information
//  //
//  // N.B. These objects may change during compilation. It's not safe to cache
//  // them between functions.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getInstrInfo">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 82,
//   FQN="llvm::TargetSubtargetInfo::getInstrInfo", NM="_ZNK4llvm19TargetSubtargetInfo12getInstrInfoEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo12getInstrInfoEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ TargetInstrInfo /*P*/ getInstrInfo() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getFrameLowering">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 83,
//   FQN="llvm::TargetSubtargetInfo::getFrameLowering", NM="_ZNK4llvm19TargetSubtargetInfo16getFrameLoweringEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo16getFrameLoweringEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ TargetFrameLowering /*P*/ getFrameLowering() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getTargetLowering">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 86,
//   FQN="llvm::TargetSubtargetInfo::getTargetLowering", NM="_ZNK4llvm19TargetSubtargetInfo17getTargetLoweringEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo17getTargetLoweringEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ TargetLowering /*P*/ getTargetLowering() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getSelectionDAGInfo">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 87,
//   FQN="llvm::TargetSubtargetInfo::getSelectionDAGInfo", NM="_ZNK4llvm19TargetSubtargetInfo19getSelectionDAGInfoEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo19getSelectionDAGInfoEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ SelectionDAGTargetInfo /*P*/ getSelectionDAGInfo() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getCallLowering">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 90,
//   FQN="llvm::TargetSubtargetInfo::getCallLowering", NM="_ZNK4llvm19TargetSubtargetInfo15getCallLoweringEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo15getCallLoweringEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ CallLowering /*P*/ getCallLowering() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  /// Target can subclass this hook to select a different DAG scheduler.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getDAGScheduler">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 92,
//   FQN="llvm::TargetSubtargetInfo::getDAGScheduler", NM="_ZNK4llvm19TargetSubtargetInfo15getDAGSchedulerENS_10CodeGenOpt5LevelE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo15getDAGSchedulerENS_10CodeGenOpt5LevelE")
//  //</editor-fold>
//  public /*virtual*/ type$ptr<ScheduleDAGSDNodes /*P*/ (/*P*/ )(SelectionDAGISel /*P*/ , CodeGenOpt.Level)> getDAGScheduler(CodeGenOpt.Level $Prm0) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  /// getRegisterInfo - If register information is available, return it.  If
//  /// not, return null.
//  ///
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getRegisterInfo">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 100,
//   FQN="llvm::TargetSubtargetInfo::getRegisterInfo", NM="_ZNK4llvm19TargetSubtargetInfo15getRegisterInfoEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo15getRegisterInfoEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ TargetRegisterInfo /*P*/ getRegisterInfo() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  /// If the information for the register banks is available, return it.
//  /// Otherwise return nullptr.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getRegBankInfo">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 104,
//   FQN="llvm::TargetSubtargetInfo::getRegBankInfo", NM="_ZNK4llvm19TargetSubtargetInfo14getRegBankInfoEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo14getRegBankInfoEv")
//  //</editor-fold>
//  public /*virtual*/ /*const*/ RegisterBankInfo /*P*/ getRegBankInfo() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  /// getInstrItineraryData - Returns instruction itinerary data for the target
  /// or specific subtarget.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getInstrItineraryData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 109,
   FQN="llvm::TargetSubtargetInfo::getInstrItineraryData", NM="_ZNK4llvm19TargetSubtargetInfo21getInstrItineraryDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo21getInstrItineraryDataEv")
  //</editor-fold>
  public /*virtual*/ /*const*/ InstrItineraryData /*P*/ getInstrItineraryData() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  /// Resolve a SchedClass at runtime, where SchedClass identifies an
//  /// MCSchedClassDesc with the isVariant property. This may return the ID of
//  /// another variant SchedClass, but repeated invocation must quickly terminate
//  /// in a nonvariant SchedClass.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::resolveSchedClass">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 117,
//   FQN="llvm::TargetSubtargetInfo::resolveSchedClass", NM="_ZNK4llvm19TargetSubtargetInfo17resolveSchedClassEjPKNS_12MachineInstrEPKNS_16TargetSchedModelE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo17resolveSchedClassEjPKNS_12MachineInstrEPKNS_16TargetSchedModelE")
//  //</editor-fold>
//  public /*virtual*/ /*uint*/int resolveSchedClass(/*uint*/int SchedClass, 
//                   /*const*/ MachineInstr /*P*/ MI, 
//                   /*const*/ TargetSchedModel /*P*/ SchedModel) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  /// \brief True if the subtarget should run MachineScheduler after aggressive
  /// coalescing.
  ///
  /// This currently replaces the SelectionDAG scheduler with the "source" order
  /// scheduler (though see below for an option to turn this off and use the
  /// TargetLowering preference). It does not yet disable the postRA scheduler.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableMachineScheduler">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 129,
   FQN="llvm::TargetSubtargetInfo::enableMachineScheduler", NM="_ZNK4llvm19TargetSubtargetInfo22enableMachineSchedulerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo22enableMachineSchedulerEv")
  //</editor-fold>
  public /*virtual*/ boolean enableMachineScheduler() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief True if the machine scheduler should disable the TLI preference
  /// for preRA scheduling with the source level scheduler.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableMachineSchedDefaultSched">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 133,
   FQN="llvm::TargetSubtargetInfo::enableMachineSchedDefaultSched", NM="_ZNK4llvm19TargetSubtargetInfo30enableMachineSchedDefaultSchedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo30enableMachineSchedDefaultSchedEv")
  //</editor-fold>
  public /*virtual*/ boolean enableMachineSchedDefaultSched() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief True if the subtarget should enable joining global copies.
  ///
  /// By default this is enabled if the machine scheduler is enabled, but
  /// can be overridden.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableJoinGlobalCopies">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 139,
   FQN="llvm::TargetSubtargetInfo::enableJoinGlobalCopies", NM="_ZNK4llvm19TargetSubtargetInfo22enableJoinGlobalCopiesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo22enableJoinGlobalCopiesEv")
  //</editor-fold>
  public /*virtual*/ boolean enableJoinGlobalCopies() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// True if the subtarget should run a scheduler after register allocation.
  ///
  /// By default this queries the PostRAScheduling bit in the scheduling model
  /// which is the preferred way to influence this.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enablePostRAScheduler">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 145,
   FQN="llvm::TargetSubtargetInfo::enablePostRAScheduler", NM="_ZNK4llvm19TargetSubtargetInfo21enablePostRASchedulerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo21enablePostRASchedulerEv")
  //</editor-fold>
  public /*virtual*/ boolean enablePostRAScheduler() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief True if the subtarget should run the atomic expansion pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableAtomicExpand">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 148,
   FQN="llvm::TargetSubtargetInfo::enableAtomicExpand", NM="_ZNK4llvm19TargetSubtargetInfo18enableAtomicExpandEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo18enableAtomicExpandEv")
  //</editor-fold>
  public /*virtual*/ boolean enableAtomicExpand() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
//  /// \brief Override generic scheduling policy within a region.
//  ///
//  /// This is a convenient way for targets that don't provide any custom
//  /// scheduling heuristics (no custom MachineSchedStrategy) to make
//  /// changes to the generic scheduling policy.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::overrideSchedPolicy">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 155,
//   FQN="llvm::TargetSubtargetInfo::overrideSchedPolicy", NM="_ZNK4llvm19TargetSubtargetInfo19overrideSchedPolicyERNS_18MachineSchedPolicyEj",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo19overrideSchedPolicyERNS_18MachineSchedPolicyEj")
//  //</editor-fold>
//  public /*virtual*/ void overrideSchedPolicy(final MachineSchedPolicy /*&*/ Policy, 
//                     /*uint*/int NumRegionInstrs) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  // \brief Perform target specific adjustments to the latency of a schedule
//  // dependency.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::adjustSchedDependency">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 160,
//   FQN="llvm::TargetSubtargetInfo::adjustSchedDependency", NM="_ZNK4llvm19TargetSubtargetInfo21adjustSchedDependencyEPNS_5SUnitES2_RNS_4SDepE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo21adjustSchedDependencyEPNS_5SUnitES2_RNS_4SDepE")
//  //</editor-fold>
//  public /*virtual*/ void adjustSchedDependency(SUnit /*P*/ def, SUnit /*P*/ use, final SDep /*&*/ dep) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  // For use with PostRAScheduling: get the anti-dependence breaking that should
  // be performed before post-RA scheduling.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getAntiDepBreakMode">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 164,
   FQN="llvm::TargetSubtargetInfo::getAntiDepBreakMode", NM="_ZNK4llvm19TargetSubtargetInfo19getAntiDepBreakModeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo19getAntiDepBreakModeEv")
  //</editor-fold>
  public /*virtual*/ AntiDepBreakMode getAntiDepBreakMode() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  // For use with PostRAScheduling: in CriticalPathRCs, return any register
//  // classes that should only be considered for anti-dependence breaking if they
//  // are on the critical path.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getCriticalPathRCs">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 169,
//   FQN="llvm::TargetSubtargetInfo::getCriticalPathRCs", NM="_ZNK4llvm19TargetSubtargetInfo18getCriticalPathRCsERNS_15SmallVectorImplIPKNS_19TargetRegisterClassEEE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo18getCriticalPathRCsERNS_15SmallVectorImplIPKNS_19TargetRegisterClassEEE")
//  //</editor-fold>
//  public /*virtual*/ void getCriticalPathRCs(final SmallVectorImpl</*const*/ TargetRegisterClass /*P*/ > /*&*/ CriticalPathRCs) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//
//  
//  // \brief Provide an ordered list of schedule DAG mutations for the post-RA
//  // scheduler.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getPostRAMutations">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 175,
//   FQN="llvm::TargetSubtargetInfo::getPostRAMutations", NM="_ZNK4llvm19TargetSubtargetInfo18getPostRAMutationsERSt6vectorISt10unique_ptrINS_19ScheduleDAGMutationESt14default_deleteIS3_EESaIS6_EE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo18getPostRAMutationsERSt6vectorISt10unique_ptrINS_19ScheduleDAGMutationESt14default_deleteIS3_EESaIS6_EE")
//  //</editor-fold>
//  public /*virtual*/ void getPostRAMutations(final std.vector<std.unique_ptr<ScheduleDAGMutation>> /*&*/ Mutations) /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  // For use with PostRAScheduling: get the minimum optimization level needed
  // to enable post-RA scheduling.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getOptLevelToEnablePostRAScheduler">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 181,
   FQN="llvm::TargetSubtargetInfo::getOptLevelToEnablePostRAScheduler", NM="_ZNK4llvm19TargetSubtargetInfo34getOptLevelToEnablePostRASchedulerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo34getOptLevelToEnablePostRASchedulerEv")
  //</editor-fold>
  public /*virtual*/ CodeGenOpt.Level getOptLevelToEnablePostRAScheduler() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief True if the subtarget should run the local reassignment
  /// heuristic of the register allocator.
  /// This heuristic may be compile time intensive, \p OptLevel provides
  /// a finer grain to tune the register allocator.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableRALocalReassignment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 189,
   FQN="llvm::TargetSubtargetInfo::enableRALocalReassignment", NM="_ZNK4llvm19TargetSubtargetInfo25enableRALocalReassignmentENS_10CodeGenOpt5LevelE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo25enableRALocalReassignmentENS_10CodeGenOpt5LevelE")
  //</editor-fold>
  public /*virtual*/ boolean enableRALocalReassignment(CodeGenOpt.Level OptLevel) /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Enable use of alias analysis during code generation (during MI
  /// scheduling, DAGCombine, etc.).
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::useAA">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 193,
   FQN="llvm::TargetSubtargetInfo::useAA", NM="_ZNK4llvm19TargetSubtargetInfo5useAAEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo5useAAEv")
  //</editor-fold>
  public /*virtual*/ boolean useAA() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// \brief Enable the use of the early if conversion pass.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableEarlyIfConversion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 196,
   FQN="llvm::TargetSubtargetInfo::enableEarlyIfConversion", NM="_ZNK4llvm19TargetSubtargetInfo23enableEarlyIfConversionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo23enableEarlyIfConversionEv")
  //</editor-fold>
  public /*virtual*/ boolean enableEarlyIfConversion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
//  /// \brief Return PBQPConstraint(s) for the target.
//  ///
//  /// Override to provide custom PBQP constraints.
//  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::getCustomPBQPConstraints">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 201,
//   FQN="llvm::TargetSubtargetInfo::getCustomPBQPConstraints", NM="_ZNK4llvm19TargetSubtargetInfo24getCustomPBQPConstraintsEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo24getCustomPBQPConstraintsEv")
//  //</editor-fold>
//  public /*virtual*/ std.unique_ptr<PBQPRAConstraint> getCustomPBQPConstraints() /*const*/ {
//    throw new UnsupportedOperationException("EmptyBody");
//  }

  
  /// Enable tracking of subregister liveness in register allocator.
  //<editor-fold defaultstate="collapsed" desc="llvm::TargetSubtargetInfo::enableSubRegLiveness">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Target/TargetSubtargetInfo.h", line = 206,
   FQN="llvm::TargetSubtargetInfo::enableSubRegLiveness", NM="_ZNK4llvm19TargetSubtargetInfo20enableSubRegLivenessEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.target/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK4llvm19TargetSubtargetInfo20enableSubRegLivenessEv")
  //</editor-fold>
  public /*virtual*/ boolean enableSubRegLiveness() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
