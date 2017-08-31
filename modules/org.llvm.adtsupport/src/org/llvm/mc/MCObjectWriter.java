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
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.endian.Writer;


/// Defines the object file and target independent interfaces used by the
/// assembler backend to write native file format object files.
///
/// The object writer contains a few callbacks used by the assembler to allow
/// the object writer to modify the assembler data structures at appropriate
/// points. Once assembly is complete, the object writer is given the
/// MCAssembler instance, which contains all the symbol and section data which
/// should be emitted as part of writeObject().
///
/// The object writer also contains a number of helper methods for writing
/// binary data to the output stream.
//<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 40,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 39,
 FQN="llvm::MCObjectWriter", NM="_ZN4llvm14MCObjectWriterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriterE")
//</editor-fold>
public abstract class MCObjectWriter implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::MCObjectWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 41,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 40,
   FQN="llvm::MCObjectWriter::MCObjectWriter", NM="_ZN4llvm14MCObjectWriterC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriterC1ERKS0_")
  //</editor-fold>
  protected/*private*/ MCObjectWriter(final /*const*/ MCObjectWriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 42,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 41,
   FQN="llvm::MCObjectWriter::operator=", NM="_ZN4llvm14MCObjectWriteraSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriteraSERKS0_")
  //</editor-fold>
  protected/*private*/ void $assign(final /*const*/ MCObjectWriter /*&*/ $Prm0) { throw new UnsupportedOperationException("Deleted");}

  
  private raw_pwrite_stream /*P*/ OS;
/*protected:*/
  protected /*JBIT unsigned int*/ boolean IsLittleEndian /*: 1*/;
/*protected:*/
  // Can only create subclasses.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::MCObjectWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 49,
   FQN="llvm::MCObjectWriter::MCObjectWriter", NM="_ZN4llvm14MCObjectWriterC1ERNS_17raw_pwrite_streamEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriterC1ERNS_17raw_pwrite_streamEb")
  //</editor-fold>
  protected MCObjectWriter(final raw_pwrite_stream /*&*/ OS, boolean IsLittleEndian) {
    // : OS(&OS), IsLittleEndian(IsLittleEndian) 
    //START JInit
    this.OS = $AddrOf(OS);
    this.IsLittleEndian = IsLittleEndian;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::getInitialOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 53,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 52,
   FQN="llvm::MCObjectWriter::getInitialOffset", NM="_ZN4llvm14MCObjectWriter16getInitialOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter16getInitialOffsetEv")
  //</editor-fold>
  protected /*uint*/int getInitialOffset() {
    return $ulong2uint(OS.tell());
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::~MCObjectWriter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp", line = 17,
   FQN="llvm::MCObjectWriter::~MCObjectWriter", NM="_ZN4llvm14MCObjectWriterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriterD0Ev")
  //</editor-fold>
  public void $destroy() {
  }

  
  /// lifetime management
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::reset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 60,
   FQN="llvm::MCObjectWriter::reset", NM="_ZN4llvm14MCObjectWriter5resetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter5resetEv")
  //</editor-fold>
  public /*virtual*/ void reset() {
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 63,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 62,
   FQN="llvm::MCObjectWriter::isLittleEndian", NM="_ZNK4llvm14MCObjectWriter14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZNK4llvm14MCObjectWriter14isLittleEndianEv")
  //</editor-fold>
  public boolean isLittleEndian() /*const*/ {
    return IsLittleEndian;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::getStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 65,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 64,
   FQN="llvm::MCObjectWriter::getStream", NM="_ZN4llvm14MCObjectWriter9getStreamEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9getStreamEv")
  //</editor-fold>
  public raw_pwrite_stream /*&*/ getStream() {
    return $Deref(OS);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::setStream">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 66,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 65,
   FQN="llvm::MCObjectWriter::setStream", NM="_ZN4llvm14MCObjectWriter9setStreamERNS_17raw_pwrite_streamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9setStreamERNS_17raw_pwrite_streamE")
  //</editor-fold>
  public void setStream(final raw_pwrite_stream /*&*/ NewOS) {
    OS = $AddrOf(NewOS);
  }

  
  /// \name High-Level API
  /// @{
  
  /// Perform any late binding of symbols (for example, to assign symbol
  /// indices for use when generating relocations).
  ///
  /// This routine is called by the assembler after layout and relaxation is
  /// complete.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::executePostLayoutBinding">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 75,
   FQN="llvm::MCObjectWriter::executePostLayoutBinding", NM="_ZN4llvm14MCObjectWriter24executePostLayoutBindingERNS_11MCAssemblerERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter24executePostLayoutBindingERNS_11MCAssemblerERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public abstract /*virtual*/ void executePostLayoutBinding(final MCAssembler /*&*/ Asm, 
                          final /*const*/ MCAsmLayout /*&*/ Layout)/* = 0*/;

  
  /// Record a relocation entry.
  ///
  /// This routine is called by the assembler after layout and relaxation, and
  /// post layout binding. The implementation is responsible for storing
  /// information about the relocation so that it can be emitted during
  /// writeObject().
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::recordRelocation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 85,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 84,
   FQN="llvm::MCObjectWriter::recordRelocation", NM="_ZN4llvm14MCObjectWriter16recordRelocationERNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERbRy",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter16recordRelocationERNS_11MCAssemblerERKNS_11MCAsmLayoutEPKNS_10MCFragmentERKNS_7MCFixupENS_7MCValueERbRy")
  //</editor-fold>
  public abstract /*virtual*/ void recordRelocation(final MCAssembler /*&*/ Asm, final /*const*/ MCAsmLayout /*&*/ Layout, 
                  /*const*/ MCFragment /*P*/ Fragment, 
                  final /*const*/ MCFixup /*&*/ Fixup, MCValue Target, 
                  final bool$ref/*bool &*/ IsPCRel, final ulong$ref/*uint64_t &*/ FixedValue)/* = 0*/;

  
  /// Check whether the difference (A - B) between two symbol references is
  /// fully resolved.
  ///
  /// Clients are not required to answer precisely and may conservatively return
  /// false, even when a difference is fully resolved.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::isSymbolRefDifferenceFullyResolved">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp", line = 20,
   FQN="llvm::MCObjectWriter::isSymbolRefDifferenceFullyResolved", NM="_ZNK4llvm14MCObjectWriter34isSymbolRefDifferenceFullyResolvedERKNS_11MCAssemblerEPKNS_15MCSymbolRefExprES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZNK4llvm14MCObjectWriter34isSymbolRefDifferenceFullyResolvedERKNS_11MCAssemblerEPKNS_15MCSymbolRefExprES6_b")
  //</editor-fold>
  public boolean isSymbolRefDifferenceFullyResolved(final /*const*/ MCAssembler /*&*/ Asm, /*const*/ MCSymbolRefExpr /*P*/ A, /*const*/ MCSymbolRefExpr /*P*/ B, 
                                    boolean InSet) /*const*/ {
    // Modified symbol references cannot be resolved.
    if (A.getKind() != MCSymbolRefExpr.VariantKind.VK_None
       || B.getKind() != MCSymbolRefExpr.VariantKind.VK_None) {
      return false;
    }
    
    final /*const*/ MCSymbol /*&*/ SA = A.getSymbol();
    final /*const*/ MCSymbol /*&*/ SB = B.getSymbol();
    if (SA.isUndefined() || SB.isUndefined()) {
      return false;
    }
    if (!(SA.getFragment() != null) || !(SB.getFragment() != null)) {
      return false;
    }
    
    return isSymbolRefDifferenceFullyResolvedImpl(Asm, SA, SB, InSet);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::isSymbolRefDifferenceFullyResolvedImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp", line = 39,
   FQN="llvm::MCObjectWriter::isSymbolRefDifferenceFullyResolvedImpl", NM="_ZNK4llvm14MCObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolES6_b",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZNK4llvm14MCObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolES6_b")
  //</editor-fold>
  public boolean isSymbolRefDifferenceFullyResolvedImpl(final /*const*/ MCAssembler /*&*/ Asm, final /*const*/ MCSymbol /*&*/ A, final /*const*/ MCSymbol /*&*/ B, 
                                        boolean InSet) /*const*/ {
    return isSymbolRefDifferenceFullyResolvedImpl(Asm, A, $Deref(B.getFragment()), InSet, 
        false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::isSymbolRefDifferenceFullyResolvedImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp", line = 46,
   FQN="llvm::MCObjectWriter::isSymbolRefDifferenceFullyResolvedImpl", NM="_ZNK4llvm14MCObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolERKNS_10MCFragmentEbb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZNK4llvm14MCObjectWriter38isSymbolRefDifferenceFullyResolvedImplERKNS_11MCAssemblerERKNS_8MCSymbolERKNS_10MCFragmentEbb")
  //</editor-fold>
  public boolean isSymbolRefDifferenceFullyResolvedImpl(final /*const*/ MCAssembler /*&*/ Asm, final /*const*/ MCSymbol /*&*/ SymA, final /*const*/ MCFragment /*&*/ FB, 
                                        boolean InSet, boolean IsPCRel) /*const*/ {
    final /*const*/ MCSection /*&*/ SecA = SymA.getSection();
    final /*const*/ MCSection /*&*/ SecB = $Deref(FB.getParent());
    // On ELF and COFF  A - B is absolute if A and B are in the same section.
    return $AddrOf(SecA) == $AddrOf(SecB);
  }

  
  /// True if this symbol (which is a variable) is weak. This is not
  /// just STB_WEAK, but more generally whether or not we can evaluate
  /// past it.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::isWeak">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp", line = 55,
   FQN="llvm::MCObjectWriter::isWeak", NM="_ZNK4llvm14MCObjectWriter6isWeakERKNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZNK4llvm14MCObjectWriter6isWeakERKNS_8MCSymbolE")
  //</editor-fold>
  public boolean isWeak(final /*const*/ MCSymbol /*&*/ $Prm0) /*const*/ {
    return false;
  }

  
  /// Write the object file.
  ///
  /// This routine is called by the assembler after layout and relaxation is
  /// complete, fixups have been evaluated and applied, and relocations
  /// generated.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeObject">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 120,
   FQN="llvm::MCObjectWriter::writeObject", NM="_ZN4llvm14MCObjectWriter11writeObjectERNS_11MCAssemblerERKNS_11MCAsmLayoutE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter11writeObjectERNS_11MCAssemblerERKNS_11MCAsmLayoutE")
  //</editor-fold>
  public abstract /*virtual*/ void writeObject(final MCAssembler /*&*/ Asm, final /*const*/ MCAsmLayout /*&*/ Layout)/* = 0*/;

  
  /// @}
  /// \name Binary Output
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::write8">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 127,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 126,
   FQN="llvm::MCObjectWriter::write8", NM="_ZN4llvm14MCObjectWriter6write8Eh",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter6write8Eh")
  //</editor-fold>
  public void write8(byte/*uint8_t*/ Value) {
    $Deref(OS).$out_char(((/*char*/byte)(Value)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeLE16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 128,
   FQN="llvm::MCObjectWriter::writeLE16", NM="_ZN4llvm14MCObjectWriter9writeLE16Et",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9writeLE16Et")
  //</editor-fold>
  public void writeLE16(/*uint16_t*/char Value) {
    new Writer(support.endianness.little, $Deref(OS)).write_uint16(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeLE32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 133,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 132,
   FQN="llvm::MCObjectWriter::writeLE32", NM="_ZN4llvm14MCObjectWriter9writeLE32Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9writeLE32Ej")
  //</editor-fold>
  public void writeLE32(/*uint32_t*/int Value) {
    new Writer(support.endianness.little, $Deref(OS)).write_uint32(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeLE64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 137,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 136,
   FQN="llvm::MCObjectWriter::writeLE64", NM="_ZN4llvm14MCObjectWriter9writeLE64Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9writeLE64Ey")
  //</editor-fold>
  public void writeLE64(long/*uint64_t*/ Value) {
    new Writer(support.endianness.little, $Deref(OS)).write_uint64(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeBE16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 141,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 140,
   FQN="llvm::MCObjectWriter::writeBE16", NM="_ZN4llvm14MCObjectWriter9writeBE16Et",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9writeBE16Et")
  //</editor-fold>
  public void writeBE16(/*uint16_t*/char Value) {
    new Writer(support.endianness.big, $Deref(OS)).write(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeBE32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 145,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 144,
   FQN="llvm::MCObjectWriter::writeBE32", NM="_ZN4llvm14MCObjectWriter9writeBE32Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9writeBE32Ej")
  //</editor-fold>
  public void writeBE32(/*uint32_t*/int Value) {
    new Writer(support.endianness.big, $Deref(OS)).write(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeBE64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 149,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 148,
   FQN="llvm::MCObjectWriter::writeBE64", NM="_ZN4llvm14MCObjectWriter9writeBE64Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter9writeBE64Ey")
  //</editor-fold>
  public void writeBE64(long/*uint64_t*/ Value) {
    new Writer(support.endianness.big, $Deref(OS)).write(Value);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::write16">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 153,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 152,
   FQN="llvm::MCObjectWriter::write16", NM="_ZN4llvm14MCObjectWriter7write16Et",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter7write16Et")
  //</editor-fold>
  public void write16(/*uint16_t*/char Value) {
    if (IsLittleEndian) {
      writeLE16(Value);
    } else {
      writeBE16(Value);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::write32">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 160,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 159,
   FQN="llvm::MCObjectWriter::write32", NM="_ZN4llvm14MCObjectWriter7write32Ej",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter7write32Ej")
  //</editor-fold>
  public void write32(/*uint32_t*/int Value) {
    if (IsLittleEndian) {
      writeLE32(Value);
    } else {
      writeBE32(Value);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::write64">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 167,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 166,
   FQN="llvm::MCObjectWriter::write64", NM="_ZN4llvm14MCObjectWriter7write64Ey",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter7write64Ey")
  //</editor-fold>
  public void write64(long/*uint64_t*/ Value) {
    if (IsLittleEndian) {
      writeLE64(Value);
    } else {
      writeBE64(Value);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::WriteZeros">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 174,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 173,
   FQN="llvm::MCObjectWriter::WriteZeros", NM="_ZN4llvm14MCObjectWriter10WriteZerosEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter10WriteZerosEj")
  //</editor-fold>
  public void WriteZeros(/*uint*/int N) {
    /*const*//*char*/byte Zeros[/*16*/] = new byte[16];//new$char(16, 0);
    
    for (/*uint*/int i = 0, e = $div_uint(N, 16); i != e; ++i)  {
      $Deref(OS).$out(new StringRef(Zeros, 16));
    }
    
    $Deref(OS).$out(new StringRef(Zeros, $rem_uint(N, 16)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 182,
   FQN="llvm::MCObjectWriter::writeBytes", NM="_ZN4llvm14MCObjectWriter10writeBytesERKNS_15SmallVectorImplIcEEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter10writeBytesERKNS_15SmallVectorImplIcEEj")
  //</editor-fold>
  public void writeBytes(final /*const*/SmallString/*&*/ ByteVec) {
    writeBytes(ByteVec, 
            0);
  }
  public void writeBytes(final /*const*/SmallString/*&*/ ByteVec, 
            /*uint*/int ZeroFillSize/*= 0*/) {
    writeBytes(new StringRef(ByteVec.data$Const(), ByteVec.size()), ZeroFillSize);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCObjectWriter::writeBytes">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", line = 188,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCObjectWriter.h", old_line = 187,
   FQN="llvm::MCObjectWriter::writeBytes", NM="_ZN4llvm14MCObjectWriter10writeBytesENS_9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCObjectWriter.cpp -nm=_ZN4llvm14MCObjectWriter10writeBytesENS_9StringRefEj")
  //</editor-fold>
  public void writeBytes(StringRef Str) {
    writeBytes(Str, 0);
  }
  public void writeBytes(StringRef Str, /*uint*/int ZeroFillSize/*= 0*/) {
    // TODO: this version may need to go away once all fragment contents are
    // converted to SmallVector<char, N>
    assert ((ZeroFillSize == 0 || $lesseq_uint(Str.size(), ZeroFillSize))) : "data size greater than fill size, unexpected large write will occur";
    $Deref(OS).$out(/*NO_COPY*/Str);
    if ((ZeroFillSize != 0)) {
      WriteZeros(ZeroFillSize - Str.size());
    }
  }

  
  @Override public String toString() {
    return "" + "OS=" + OS // NOI18N
              + ", IsLittleEndian=" + IsLittleEndian; // NOI18N
  }
/// @}
}
