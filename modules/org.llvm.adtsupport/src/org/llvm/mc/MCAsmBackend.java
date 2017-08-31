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
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.ADTAliases.OptionalUInt;
import org.llvm.adt.aliases.*;


/// Generic interface to target specific assembler backends.
//<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 35,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 34,
 FQN="llvm::MCAsmBackend", NM="_ZN4llvm12MCAsmBackendE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackendE")
//</editor-fold>
public abstract class MCAsmBackend implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::MCAsmBackend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 36,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 35,
   FQN="llvm::MCAsmBackend::MCAsmBackend", NM="_ZN4llvm12MCAsmBackendC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackendC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCAsmBackend(final /*const*/ MCAsmBackend /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 37,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 36,
   FQN="llvm::MCAsmBackend::operator=", NM="_ZN4llvm12MCAsmBackendaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackendaSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCAsmBackend /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

/*protected:*/
  // Can only create subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::MCAsmBackend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp", line = 15,
   FQN="llvm::MCAsmBackend::MCAsmBackend", NM="_ZN4llvm12MCAsmBackendC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackendC1Ev")
  //</editor-fold>
  protected MCAsmBackend() {
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::~MCAsmBackend">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp", line = 17,
   FQN="llvm::MCAsmBackend::~MCAsmBackend", NM="_ZN4llvm12MCAsmBackendD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackendD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// lifetime management
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 47,
   FQN="llvm::MCAsmBackend::reset", NM="_ZN4llvm12MCAsmBackend5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackend5resetEv")
  //</editor-fold>
  public /*virtual*/ void reset() {
  }

  
  /// Create a new MCObjectWriter instance for use by the assembler backend to
  /// emit the final object file.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::createObjectWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 51,
   FQN="llvm::MCAsmBackend::createObjectWriter", NM="_ZNK4llvm12MCAsmBackend18createObjectWriterERNS_17raw_pwrite_streamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend18createObjectWriterERNS_17raw_pwrite_streamE")
  //</editor-fold>
  public abstract /*virtual*/ MCObjectWriter /*P*/ createObjectWriter(final raw_pwrite_stream /*&*/ OS) /*const*//* = 0*/;

  
  /// \name Target Fixup Interfaces
  /// @{
  
  /// Get the number of target specific fixup kinds.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::getNumFixupKinds">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 68,
   FQN="llvm::MCAsmBackend::getNumFixupKinds", NM="_ZNK4llvm12MCAsmBackend16getNumFixupKindsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend16getNumFixupKindsEv")
  //</editor-fold>
  public abstract /*virtual*/ /*uint*/int getNumFixupKinds() /*const*//* = 0*/;

  
  /// Map a relocation name used in .reloc to a fixup kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::getFixupKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp", line = 19,
   FQN="llvm::MCAsmBackend::getFixupKind", NM="_ZNK4llvm12MCAsmBackend12getFixupKindENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend12getFixupKindENS_9StringRefE")
  //</editor-fold>
  public OptionalUInt/*MCFixupKind*//*uint*/ getFixupKind(StringRef Name) /*const*/ {
    return new OptionalUInt/*MCFixupKind*//*uint*/(None);
  }

  
  /// Get information on a fixup kind.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::getFixupKindInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp", line = 23,
   FQN="llvm::MCAsmBackend::getFixupKindInfo", NM="_ZNK4llvm12MCAsmBackend16getFixupKindInfoENS_11MCFixupKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend16getFixupKindInfoENS_11MCFixupKindE")
  //</editor-fold>
  public /*const*/ MCFixupKindInfo /*&*/ getFixupKindInfo(/*MCFixupKind*//*uint*/int Kind) /*const*/ {
    final/*static*/ /*const*/ MCFixupKindInfo Builtins[/*16*/] = getFixupKindInfo$$.Builtins;
    assert ($lesseq_uint(Kind, array_lengthof(Builtins))) : "Unknown fixup kind";
    return Builtins[Kind];
  }
  private static final class getFixupKindInfo$$ {
    static final/*static*/ /*const*/ MCFixupKindInfo Builtins[/*16*/] = new /*const*/ MCFixupKindInfo [/*16*/] {
      new MCFixupKindInfo($("FK_Data_1"), 0, 8, 0), 
      new MCFixupKindInfo($("FK_Data_2"), 0, 16, 0), 
      new MCFixupKindInfo($("FK_Data_4"), 0, 32, 0), 
      new MCFixupKindInfo($("FK_Data_8"), 0, 64, 0), 
      new MCFixupKindInfo($("FK_PCRel_1"), 0, 8, MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel), 
      new MCFixupKindInfo($("FK_PCRel_2"), 0, 16, MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel), 
      new MCFixupKindInfo($("FK_PCRel_4"), 0, 32, MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel), 
      new MCFixupKindInfo($("FK_PCRel_8"), 0, 64, MCFixupKindInfo.FixupKindFlags.FKF_IsPCRel), 
      new MCFixupKindInfo($("FK_GPRel_1"), 0, 8, 0), 
      new MCFixupKindInfo($("FK_GPRel_2"), 0, 16, 0), 
      new MCFixupKindInfo($("FK_GPRel_4"), 0, 32, 0), 
      new MCFixupKindInfo($("FK_GPRel_8"), 0, 64, 0), 
      new MCFixupKindInfo($("FK_SecRel_1"), 0, 8, 0), 
      new MCFixupKindInfo($("FK_SecRel_2"), 0, 16, 0), 
      new MCFixupKindInfo($("FK_SecRel_4"), 0, 32, 0), 
      new MCFixupKindInfo($("FK_SecRel_8"), 0, 64, 0)};
  }

  
  /// Target hook to adjust the literal value of a fixup if necessary.
  /// IsResolved signals whether the caller believes a relocation is needed; the
  /// target can modify the value. The default does nothing.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::processFixupValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 67,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 81,
   FQN="llvm::MCAsmBackend::processFixupValue", NM="_ZN4llvm12MCAsmBackend17processFixupValueERKNS_11MCAssemblerERKNS_11MCAsmLayoutERKNS_7MCFixupEPKNS_10MCFragmentERKNS_7MCValueERyRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackend17processFixupValueERKNS_11MCAssemblerERKNS_11MCAsmLayoutERKNS_7MCFixupEPKNS_10MCFragmentERKNS_7MCValueERyRb")
  //</editor-fold>
  public /*virtual*/ void processFixupValue(final /*const*/ MCAssembler /*&*/ Asm, 
                   final /*const*/ MCAsmLayout /*&*/ Layout, 
                   final /*const*/ MCFixup /*&*/ Fixup, /*const*/ MCFragment /*P*/ DF, 
                   final /*const*/ MCValue /*&*/ Target, final ulong$ref/*uint64_t &*/ Value, 
                   final bool$ref/*bool &*/ IsResolved) {
  }

  
  /// Apply the \p Value for given \p Fixup into the provided data fragment, at
  /// the offset specified by the fixup and following the fixup kind as
  /// appropriate.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::applyFixup">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 90,
   FQN="llvm::MCAsmBackend::applyFixup", NM="_ZNK4llvm12MCAsmBackend10applyFixupERKNS_7MCFixupEPcjyb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend10applyFixupERKNS_7MCFixupEPcjyb")
  //</editor-fold>
  public abstract /*virtual*/ void applyFixup(final /*const*/ MCFixup /*&*/ Fixup, char$ptr/*char P*/ Data, /*uint*/int DataSize, 
            long/*uint64_t*/ Value, boolean IsPCRel) /*const*//* = 0*/;

  
  /// @}
  
  /// \name Target Relaxation Interfaces
  /// @{
  
  /// Check whether the given instruction may need relaxation.
  ///
  /// \param Inst - The instruction to test.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::mayNeedRelaxation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 101,
   FQN="llvm::MCAsmBackend::mayNeedRelaxation", NM="_ZNK4llvm12MCAsmBackend17mayNeedRelaxationERKNS_6MCInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend17mayNeedRelaxationERKNS_6MCInstE")
  //</editor-fold>
  public abstract /*virtual*/ boolean mayNeedRelaxation(final /*const*/ MCInst /*&*/ Inst) /*const*//* = 0*/;

  
  /// Target specific predicate for whether a given fixup requires the
  /// associated instruction to be relaxed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::fixupNeedsRelaxationAdvanced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp", line = 46,
   FQN="llvm::MCAsmBackend::fixupNeedsRelaxationAdvanced", NM="_ZNK4llvm12MCAsmBackend28fixupNeedsRelaxationAdvancedERKNS_7MCFixupEbyPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend28fixupNeedsRelaxationAdvancedERKNS_7MCFixupEbyPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public boolean fixupNeedsRelaxationAdvanced(final /*const*/ MCFixup /*&*/ Fixup, boolean Resolved, long/*uint64_t*/ Value, 
                              /*const*/ MCRelaxableFragment /*P*/ DF, final /*const*/ MCAsmLayout /*&*/ Layout) /*const*/ {
    if (!Resolved) {
      return true;
    }
    return fixupNeedsRelaxation(Fixup, Value, DF, Layout);
  }

  
  /// Simple predicate for targets where !Resolved implies requiring relaxation
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::fixupNeedsRelaxation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 97,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 111,
   FQN="llvm::MCAsmBackend::fixupNeedsRelaxation", NM="_ZNK4llvm12MCAsmBackend20fixupNeedsRelaxationERKNS_7MCFixupEyPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend20fixupNeedsRelaxationERKNS_7MCFixupEyPKNS_19MCRelaxableFragmentERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public abstract /*virtual*/ boolean fixupNeedsRelaxation(final /*const*/ MCFixup /*&*/ Fixup, long/*uint64_t*/ Value, 
                      /*const*/ MCRelaxableFragment /*P*/ DF, 
                      final /*const*/ MCAsmLayout /*&*/ Layout) /*const*//* = 0*/;

  
  /// Relax the instruction in the given fragment to the next wider instruction.
  ///
  /// \param Inst The instruction to relax, which may be the same as the
  /// output.
  /// \param STI the subtarget information for the associated instruction.
  /// \param [out] Res On return, the relaxed instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::relaxInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 107,
   FQN="llvm::MCAsmBackend::relaxInstruction", NM="_ZNK4llvm12MCAsmBackend16relaxInstructionERKNS_6MCInstERKNS_15MCSubtargetInfoERS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend16relaxInstructionERKNS_6MCInstERKNS_15MCSubtargetInfoERS1_")
  //</editor-fold>
  public abstract /*virtual*/ void relaxInstruction(final /*const*/ MCInst /*&*/ Inst, final /*const*/ MCSubtargetInfo /*&*/ STI, 
                  final MCInst /*&*/ Res) /*const*//* = 0*/;

  
  /// @}
  
  /// Returns the minimum size of a nop in bytes on this target. The assembler
  /// will use this to emit excess padding in situations where the padding
  /// required for simple alignment would be less than the minimum nop size.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::getMinimumNopSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 116,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 128,
   FQN="llvm::MCAsmBackend::getMinimumNopSize", NM="_ZNK4llvm12MCAsmBackend17getMinimumNopSizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend17getMinimumNopSizeEv")
  //</editor-fold>
  public /*virtual*/ /*uint*/int getMinimumNopSize() /*const*/ {
    return 1;
  }

  
  /// Write an (optimal) nop sequence of Count bytes to the given output. If the
  /// target cannot generate such a sequence, it should return an error.
  ///
  /// \return - True on success.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::writeNopData">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 134,
   FQN="llvm::MCAsmBackend::writeNopData", NM="_ZNK4llvm12MCAsmBackend12writeNopDataEyPNS_14MCObjectWriterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend12writeNopDataEyPNS_14MCObjectWriterE")
  //</editor-fold>
  public abstract /*virtual*/ boolean writeNopData(long/*uint64_t*/ Count, MCObjectWriter /*P*/ OW) /*const*//* = 0*/;

  
  /// Give backend an opportunity to finish layout after relaxation
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::finishLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 125,
   FQN="llvm::MCAsmBackend::finishLayout", NM="_ZNK4llvm12MCAsmBackend12finishLayoutERKNS_11MCAssemblerERNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend12finishLayoutERKNS_11MCAssemblerERNS_11MCAsmLayoutE")
  //</editor-fold>
  public /*virtual*/ void finishLayout(final /*const*/ MCAssembler /*&*/ Asm, 
              final MCAsmLayout /*&*/ Layout) /*const*/ {
  }

  
  /// Handle any target-specific assembler flags. By default, do nothing.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::handleAssemblerFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 137,
   FQN="llvm::MCAsmBackend::handleAssemblerFlag", NM="_ZN4llvm12MCAsmBackend19handleAssemblerFlagENS_15MCAssemblerFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZN4llvm12MCAsmBackend19handleAssemblerFlagENS_15MCAssemblerFlagE")
  //</editor-fold>
  public /*virtual*/ void handleAssemblerFlag(MCAssemblerFlag Flag) {
  }

  
  /// \brief Generate the compact unwind encoding for the CFI instructions.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCAsmBackend::generateCompactUnwindEncoding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", line = 132,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmBackend.h", old_line = 140,
   FQN="llvm::MCAsmBackend::generateCompactUnwindEncoding", NM="_ZNK4llvm12MCAsmBackend29generateCompactUnwindEncodingENS_8ArrayRefINS_16MCCFIInstructionEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmBackend.cpp -nm=_ZNK4llvm12MCAsmBackend29generateCompactUnwindEncodingENS_8ArrayRefINS_16MCCFIInstructionEEE")
  //</editor-fold>
  public /*virtual*/ /*uint32_t*/int generateCompactUnwindEncoding(ArrayRef<MCCFIInstruction> $Prm0) /*const*/ {
    return 0;
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
