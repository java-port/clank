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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Unsigned.*;


/// \brief Instances of this class represent the information from a
/// dwarf .loc directive.
//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 54,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 56,
 FQN="llvm::MCDwarfLoc", NM="_ZN4llvm10MCDwarfLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLocE")
//</editor-fold>
public class MCDwarfLoc implements NativeCloneable<MCDwarfLoc>, NativeMoveable<MCDwarfLoc> {
  private /*uint32_t*/int FileNum;
  private /*uint32_t*/int Line;
  private /*uint16_t*/char Column;
  // Flags (see #define's below)
  private byte/*uint8_t*/ Flags;
  private byte/*uint8_t*/ Isa;
  private /*uint32_t*/int Discriminator;
/*private:*/
  // MCContext manages these
  /*friend  class MCContext*/
  /*friend  class MCDwarfLineEntry*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::MCDwarfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 74,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 76,
   FQN="llvm::MCDwarfLoc::MCDwarfLoc", NM="_ZN4llvm10MCDwarfLocC1Ejjjjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLocC1Ejjjjjj")
  //</editor-fold>
  public MCDwarfLoc(/*uint*/int fileNum, /*uint*/int line, /*uint*/int column, /*uint*/int flags, 
      /*uint*/int isa, /*uint*/int discriminator) {
    // : FileNum(fileNum), Line(line), Column(column), Flags(flags), Isa(isa), Discriminator(discriminator) 
    //START JInit
    this.FileNum = fileNum;
    this.Line = line;
    this.Column = $uint2ushort(column);
    this.Flags = $uint2uchar(flags);
    this.Isa = $uint2uchar(isa);
    this.Discriminator = discriminator;
    //END JInit
  }


  // Allow the default copy constructor and assignment operator to be used
  // for an MCDwarfLoc object.
  /*public:*/
  /// \brief Get the FileNum of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::getFileNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 84,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 86,
   FQN="llvm::MCDwarfLoc::getFileNum", NM="_ZNK4llvm10MCDwarfLoc10getFileNumEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm10MCDwarfLoc10getFileNumEv")
  //</editor-fold>
  public /*uint*/int getFileNum() /*const*/ {
    return FileNum;
  }

  
  /// \brief Get the Line of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::getLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 87,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 89,
   FQN="llvm::MCDwarfLoc::getLine", NM="_ZNK4llvm10MCDwarfLoc7getLineEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm10MCDwarfLoc7getLineEv")
  //</editor-fold>
  public /*uint*/int getLine() /*const*/ {
    return Line;
  }

  
  /// \brief Get the Column of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::getColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 90,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 92,
   FQN="llvm::MCDwarfLoc::getColumn", NM="_ZNK4llvm10MCDwarfLoc9getColumnEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm10MCDwarfLoc9getColumnEv")
  //</editor-fold>
  public /*uint*/int getColumn() /*const*/ {
    return $ushort2uint(Column);
  }

  
  /// \brief Get the Flags of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::getFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 93,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 95,
   FQN="llvm::MCDwarfLoc::getFlags", NM="_ZNK4llvm10MCDwarfLoc8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm10MCDwarfLoc8getFlagsEv")
  //</editor-fold>
  public /*uint*/int getFlags() /*const*/ {
    return $uchar2uint(Flags);
  }

  
  /// \brief Get the Isa of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::getIsa">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 98,
   FQN="llvm::MCDwarfLoc::getIsa", NM="_ZNK4llvm10MCDwarfLoc6getIsaEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm10MCDwarfLoc6getIsaEv")
  //</editor-fold>
  public /*uint*/int getIsa() /*const*/ {
    return $uchar2uint(Isa);
  }

  
  /// \brief Get the Discriminator of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::getDiscriminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 99,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 101,
   FQN="llvm::MCDwarfLoc::getDiscriminator", NM="_ZNK4llvm10MCDwarfLoc16getDiscriminatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZNK4llvm10MCDwarfLoc16getDiscriminatorEv")
  //</editor-fold>
  public /*uint*/int getDiscriminator() /*const*/ {
    return Discriminator;
  }

  
  /// \brief Set the FileNum of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::setFileNum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 102,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 104,
   FQN="llvm::MCDwarfLoc::setFileNum", NM="_ZN4llvm10MCDwarfLoc10setFileNumEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLoc10setFileNumEj")
  //</editor-fold>
  public void setFileNum(/*uint*/int fileNum) {
    FileNum = fileNum;
  }

  
  /// \brief Set the Line of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::setLine">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 105,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 107,
   FQN="llvm::MCDwarfLoc::setLine", NM="_ZN4llvm10MCDwarfLoc7setLineEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLoc7setLineEj")
  //</editor-fold>
  public void setLine(/*uint*/int line) {
    Line = line;
  }

  
  /// \brief Set the Column of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::setColumn">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 108,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 110,
   FQN="llvm::MCDwarfLoc::setColumn", NM="_ZN4llvm10MCDwarfLoc9setColumnEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLoc9setColumnEj")
  //</editor-fold>
  public void setColumn(/*uint*/int column) {
    assert ($lesseq_uint(column, (65535/*U*/)));
    Column = $uint2ushort(column);
  }

  
  /// \brief Set the Flags of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::setFlags">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 114,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 116,
   FQN="llvm::MCDwarfLoc::setFlags", NM="_ZN4llvm10MCDwarfLoc8setFlagsEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLoc8setFlagsEj")
  //</editor-fold>
  public void setFlags(/*uint*/int flags) {
    assert ($lesseq_uint(flags, (255/*U*/)));
    Flags = $uint2uchar(flags);
  }

  
  /// \brief Set the Isa of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::setIsa">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 120,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 122,
   FQN="llvm::MCDwarfLoc::setIsa", NM="_ZN4llvm10MCDwarfLoc6setIsaEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLoc6setIsaEj")
  //</editor-fold>
  public void setIsa(/*uint*/int isa) {
    assert ($lesseq_uint(isa, (255/*U*/)));
    Isa = $uint2uchar(isa);
  }

  
  /// \brief Set the Discriminator of this MCDwarfLoc.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::setDiscriminator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 126,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 128,
   FQN="llvm::MCDwarfLoc::setDiscriminator", NM="_ZN4llvm10MCDwarfLoc16setDiscriminatorEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLoc16setDiscriminatorEj")
  //</editor-fold>
  public void setDiscriminator(/*uint*/int discriminator) {
    Discriminator = discriminator;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::MCDwarfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 56,
   FQN="llvm::MCDwarfLoc::MCDwarfLoc", NM="_ZN4llvm10MCDwarfLocC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLocC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLoc(final /*const*/ MCDwarfLoc /*&*/ $Prm0) {
    // : FileNum(.FileNum), Line(.Line), Column(.Column), Flags(.Flags), Isa(.Isa), Discriminator(.Discriminator) 
    //START JInit
    this.FileNum = $Prm0.FileNum;
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    this.Flags = $Prm0.Flags;
    this.Isa = $Prm0.Isa;
    this.Discriminator = $Prm0.Discriminator;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::MCDwarfLoc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 56,
   FQN="llvm::MCDwarfLoc::MCDwarfLoc", NM="_ZN4llvm10MCDwarfLocC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLocC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLoc(JD$Move _dparam, final MCDwarfLoc /*&&*/$Prm0) {
    // : FileNum(static_cast<MCDwarfLoc &&>().FileNum), Line(static_cast<MCDwarfLoc &&>().Line), Column(static_cast<MCDwarfLoc &&>().Column), Flags(static_cast<MCDwarfLoc &&>().Flags), Isa(static_cast<MCDwarfLoc &&>().Isa), Discriminator(static_cast<MCDwarfLoc &&>().Discriminator) 
    //START JInit
    this.FileNum = $Prm0.FileNum;
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    this.Flags = $Prm0.Flags;
    this.Isa = $Prm0.Isa;
    this.Discriminator = $Prm0.Discriminator;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLoc::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 56,
   FQN="llvm::MCDwarfLoc::operator=", NM="_ZN4llvm10MCDwarfLocaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCContext.cpp -nm=_ZN4llvm10MCDwarfLocaSEOS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLoc /*&*/ $assignMove(final MCDwarfLoc /*&&*/$Prm0) {
    this.FileNum = $Prm0.FileNum;
    this.Line = $Prm0.Line;
    this.Column = $Prm0.Column;
    this.Flags = $Prm0.Flags;
    this.Isa = $Prm0.Isa;
    this.Discriminator = $Prm0.Discriminator;
    return /*Deref*/this;
  }

  public static final int DWARF2_LINE_DEFAULT_IS_STMT = 1;
  public static final int DWARF2_FLAG_IS_STMT = (1 << 0);
  public static final int DWARF2_FLAG_BASIC_BLOCK = (1 << 1);
  public static final int DWARF2_FLAG_PROLOGUE_END = (1 << 2);
  public static final int DWARF2_FLAG_EPILOGUE_BEGIN = (1 << 3);
  
  /*friend*/MCDwarfLoc() {
  }
  
  @Override
  public MCDwarfLoc clone() {
    assert this.getClass() == MCDwarfLoc.class : "Must be overridden in " + this.getClass();
    return new MCDwarfLoc(this);
  }

  @Override
  public MCDwarfLoc move() {
    assert this.getClass() == MCDwarfLoc.class : "Must be overridden in " + this.getClass();
    return new MCDwarfLoc(JD$Move.INSTANCE, this);
  }

  @Override public String toString() {
    return "" + "FileNum=" + FileNum // NOI18N
              + ", Line=" + Line // NOI18N
              + ", Column=" + $ushort2uint(Column) // NOI18N
              + ", Flags=" + $uchar2uint(Flags) // NOI18N
              + ", Isa=" + $uchar2uint(Isa) // NOI18N
              + ", Discriminator=" + Discriminator; // NOI18N
  }
}
