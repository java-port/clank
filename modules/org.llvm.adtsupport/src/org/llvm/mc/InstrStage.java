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

import org.clank.support.*;


//===----------------------------------------------------------------------===//
/// Instruction stage - These values represent a non-pipelined step in
/// the execution of an instruction.  Cycles represents the number of
/// discrete time slots needed to complete the stage.  Units represent
/// the choice of functional units that can be used to complete the
/// stage.  Eg. IntUnit1, IntUnit2. NextCycles indicates how many
/// cycles should elapse from the start of this stage to the start of
/// the next stage in the itinerary. A value of -1 indicates that the
/// next stage should start immediately after the current one.
/// For example:
///
///   { 1, x, -1 }
///      indicates that the stage occupies FU x for 1 cycle and that
///      the next stage starts immediately after this one.
///
///   { 2, x|y, 1 }
///      indicates that the stage occupies either FU x or FU y for 2
///      consecuative cycles and that the next stage starts one cycle
///      after this stage starts. That is, the stage requirements
///      overlap in time.
///
///   { 1, x, 0 }
///      indicates that the stage occupies FU x for 1 cycle and that
///      the next stage starts in this same cycle. This can be used to
///      indicate that the instruction requires multiple stages at the
///      same time.
///
/// FU reservation can be of two different kinds:
///  - FUs which instruction actually requires
///  - FUs which instruction just reserves. Reserved unit is not available for
///    execution of other instruction. However, several instructions can reserve
///    the same unit several times.
/// Such two types of units reservation is used to model instruction domain
/// change stalls, FUs using the same resource (e.g. same register file), etc.
//<editor-fold defaultstate="collapsed" desc="llvm::InstrStage">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrItineraries.h", line = 59,
 FQN = "llvm::InstrStage", NM = "_ZN4llvm10InstrStageE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm10InstrStageE")
//</editor-fold>
public class/*struct*/ InstrStage {
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrStage::ReservationKinds">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrItineraries.h", line = 60,
   FQN = "llvm::InstrStage::ReservationKinds", NM = "_ZN4llvm10InstrStage16ReservationKindsE",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm10InstrStage16ReservationKindsE")
  //</editor-fold>
  public enum ReservationKinds {
    Required(0),
    Reserved(1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ReservationKinds valueOf(int val) {
      ReservationKinds out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      return out;
    }

    private static final class Values {
      private static final ReservationKinds[] VALUES;
      private static final ReservationKinds[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ReservationKinds kind : ReservationKinds.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ReservationKinds[min < 0 ? (1-min) : 0];
        VALUES = new ReservationKinds[max >= 0 ? (1+max) : 0];
        for (ReservationKinds kind : ReservationKinds.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private ReservationKinds(/*uint*/int val) { this.value = (int)val;}
    public int getValue() { return (int)value;}
    //</editor-fold>
  };
  
  public /*uint*/int Cycles_; ///< Length of stage in machine cycles
  public /*uint*/int Units_; ///< Choice of functional units
  public int NextCycles_; ///< Number of machine cycles to next stage
  public ReservationKinds Kind_; ///< Kind of the FU reservation
  
  /// getCycles - returns the number of cycles the stage is occupied
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrStage::getCycles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrItineraries.h", line = 71,
   FQN = "llvm::InstrStage::getCycles", NM = "_ZNK4llvm10InstrStage9getCyclesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm10InstrStage9getCyclesEv")
  //</editor-fold>
  public /*uint*/int getCycles() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getUnits - returns the choice of FUs
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrStage::getUnits">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrItineraries.h", line = 76,
   FQN = "llvm::InstrStage::getUnits", NM = "_ZNK4llvm10InstrStage8getUnitsEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm10InstrStage8getUnitsEv")
  //</editor-fold>
  public /*uint*/int getUnits() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrStage::getReservationKind">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrItineraries.h", line = 80,
   FQN = "llvm::InstrStage::getReservationKind", NM = "_ZNK4llvm10InstrStage18getReservationKindEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm10InstrStage18getReservationKindEv")
  //</editor-fold>
  public ReservationKinds getReservationKind() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// getNextCycles - returns the number of cycles from the start of
  /// this stage to the start of the next stage in the itinerary
  //<editor-fold defaultstate="collapsed" desc="llvm::InstrStage::getNextCycles">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrItineraries.h", line = 86,
   FQN = "llvm::InstrStage::getNextCycles", NM = "_ZNK4llvm10InstrStage13getNextCyclesEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm10InstrStage13getNextCyclesEv")
  //</editor-fold>
  public /*uint*/int getNextCycles() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
