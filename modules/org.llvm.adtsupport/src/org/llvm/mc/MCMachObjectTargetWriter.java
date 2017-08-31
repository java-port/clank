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

//<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 26,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 27,
 FQN="llvm::MCMachObjectTargetWriter", NM="_ZN4llvm24MCMachObjectTargetWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZN4llvm24MCMachObjectTargetWriterE")
//</editor-fold>
public abstract class MCMachObjectTargetWriter implements Destructors.ClassWithDestructor {
  private /*JBIT const unsigned int*/ boolean Is64Bit /*: 1*/;
  private /*const*//*uint32_t*/int CPUType;
  private /*const*//*uint32_t*/int CPUSubtype;
  private /*uint*/int LocalDifference_RIT;
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::MCMachObjectTargetWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp", line = 14,
   FQN="llvm::MCMachObjectTargetWriter::MCMachObjectTargetWriter", NM="_ZN4llvm24MCMachObjectTargetWriterC1Ebjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZN4llvm24MCMachObjectTargetWriterC1Ebjj")
  //</editor-fold>
  protected MCMachObjectTargetWriter(boolean Is64Bit_, 
      /*uint32_t*/int CPUType_, 
      /*uint32_t*/int CPUSubtype_) {
    // : Is64Bit(Is64Bit_), CPUType(CPUType_), CPUSubtype(CPUSubtype_) 
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::setLocalDifferenceRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 36,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 37,
   FQN="llvm::MCMachObjectTargetWriter::setLocalDifferenceRelocationType", NM="_ZN4llvm24MCMachObjectTargetWriter32setLocalDifferenceRelocationTypeEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZN4llvm24MCMachObjectTargetWriter32setLocalDifferenceRelocationTypeEj")
  //</editor-fold>
  protected void setLocalDifferenceRelocationType(/*uint*/int Type) {
    throw new UnsupportedOperationException("EmptyBody");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::~MCMachObjectTargetWriter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp", line = 19,
   FQN="llvm::MCMachObjectTargetWriter::~MCMachObjectTargetWriter", NM="_ZN4llvm24MCMachObjectTargetWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZN4llvm24MCMachObjectTargetWriterD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \name Lifetime Management
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::reset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 46,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 47,
   FQN="llvm::MCMachObjectTargetWriter::reset", NM="_ZN4llvm24MCMachObjectTargetWriter5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZN4llvm24MCMachObjectTargetWriter5resetEv")
  //</editor-fold>
  public /*virtual*/ void reset() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @}
  
  /// \name Accessors
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::is64Bit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 54,
   FQN="llvm::MCMachObjectTargetWriter::is64Bit", NM="_ZNK4llvm24MCMachObjectTargetWriter7is64BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZNK4llvm24MCMachObjectTargetWriter7is64BitEv")
  //</editor-fold>
  public boolean is64Bit() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::getCPUType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 55,
   FQN="llvm::MCMachObjectTargetWriter::getCPUType", NM="_ZNK4llvm24MCMachObjectTargetWriter10getCPUTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZNK4llvm24MCMachObjectTargetWriter10getCPUTypeEv")
  //</editor-fold>
  public /*uint32_t*/int getCPUType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::getCPUSubtype">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 55,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 56,
   FQN="llvm::MCMachObjectTargetWriter::getCPUSubtype", NM="_ZNK4llvm24MCMachObjectTargetWriter13getCPUSubtypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZNK4llvm24MCMachObjectTargetWriter13getCPUSubtypeEv")
  //</editor-fold>
  public /*uint32_t*/int getCPUSubtype() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::getLocalDifferenceRelocationType">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 56,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 57,
   FQN="llvm::MCMachObjectTargetWriter::getLocalDifferenceRelocationType", NM="_ZNK4llvm24MCMachObjectTargetWriter32getLocalDifferenceRelocationTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZNK4llvm24MCMachObjectTargetWriter32getLocalDifferenceRelocationTypeEv")
  //</editor-fold>
  public /*uint*/int getLocalDifferenceRelocationType() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// @}
  
  /// \name API
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCMachObjectTargetWriter::recordRelocation">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCMachObjectWriter.h", old_line = 66,
   FQN="llvm::MCMachObjectTargetWriter::recordRelocation", NM="_ZN4llvm24MCMachObjectTargetWriter16recordRelocationEPNS_16MachObjectWriterERNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCMachObjectTargetWriter.cpp -nm=_ZN4llvm24MCMachObjectTargetWriter16recordRelocationEPNS_16MachObjectWriterERNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERy")
  //</editor-fold>
  public abstract /*virtual*/ void recordRelocation(MachObjectWriter /*P*/ Writer, final MCAssembler /*&*/ Asm, 
                  final /*const*/ MCAsmLayout /*&*/ Layout, 
                  /*const*/ MCFragment /*P*/ Fragment, 
                  final /*const*/ MCFixup /*&*/ Fixup, MCValue Target, 
                  final ulong$ref/*uint64_t &*/ FixedValue)/* = 0*/;

  
  @Override public String toString() {
    return "" + "Is64Bit=" + Is64Bit // NOI18N
              + ", CPUType=" + CPUType // NOI18N
              + ", CPUSubtype=" + CPUSubtype // NOI18N
              + ", LocalDifference_RIT=" + LocalDifference_RIT; // NOI18N
  }
/// @}
}
