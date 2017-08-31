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

//<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTableParams">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 183,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 185,
 FQN="llvm::MCDwarfLineTableParams", NM="_ZN4llvm22MCDwarfLineTableParamsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm22MCDwarfLineTableParamsE")
//</editor-fold>
public class/*struct*/ MCDwarfLineTableParams {
  /// First special line opcode - leave room for the standard opcodes.
  /// Note: If you want to change this, you'll have to update the
  /// "StandardOpcodeLengths" table that is emitted in
  /// \c Emit().
  public byte/*uint8_t*/ DWARF2LineOpcodeBase/* = 13*/;
  /// Minimum line offset in a special line info. opcode.  The value
  /// -5 was chosen to give a reasonable range of values.
  public byte/*int8_t*/ DWARF2LineBase/* = -5*/;
  /// Range of line offsets in a special line info. opcode.
  public byte/*uint8_t*/ DWARF2LineRange/* = 14*/;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTableParams::MCDwarfLineTableParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 185,
   FQN="llvm::MCDwarfLineTableParams::MCDwarfLineTableParams", NM="_ZN4llvm22MCDwarfLineTableParamsC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm22MCDwarfLineTableParamsC1Ev")
  //</editor-fold>
  public /*inline*/ MCDwarfLineTableParams() {
    // : DWARF2LineOpcodeBase(13), DWARF2LineBase(-5), DWARF2LineRange(14) 
    //START JInit
    /*InClass*/this.DWARF2LineOpcodeBase = $int2uchar(13);
    /*InClass*/this.DWARF2LineBase = -5;
    /*InClass*/this.DWARF2LineRange = $int2uchar(14);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTableParams::MCDwarfLineTableParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 185,
   FQN="llvm::MCDwarfLineTableParams::MCDwarfLineTableParams", NM="_ZN4llvm22MCDwarfLineTableParamsC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm22MCDwarfLineTableParamsC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLineTableParams(final /*const*/ MCDwarfLineTableParams /*&*/ $Prm0) {
    // : DWARF2LineOpcodeBase(.DWARF2LineOpcodeBase), DWARF2LineBase(.DWARF2LineBase), DWARF2LineRange(.DWARF2LineRange) 
    //START JInit
    this.DWARF2LineOpcodeBase = $Prm0.DWARF2LineOpcodeBase;
    this.DWARF2LineBase = $Prm0.DWARF2LineBase;
    this.DWARF2LineRange = $Prm0.DWARF2LineRange;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTableParams::MCDwarfLineTableParams">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 185,
   FQN="llvm::MCDwarfLineTableParams::MCDwarfLineTableParams", NM="_ZN4llvm22MCDwarfLineTableParamsC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm22MCDwarfLineTableParamsC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLineTableParams(JD$Move _dparam, final MCDwarfLineTableParams /*&&*/$Prm0) {
    // : DWARF2LineOpcodeBase(static_cast<MCDwarfLineTableParams &&>().DWARF2LineOpcodeBase), DWARF2LineBase(static_cast<MCDwarfLineTableParams &&>().DWARF2LineBase), DWARF2LineRange(static_cast<MCDwarfLineTableParams &&>().DWARF2LineRange) 
    //START JInit
    this.DWARF2LineOpcodeBase = $Prm0.DWARF2LineOpcodeBase;
    this.DWARF2LineBase = $Prm0.DWARF2LineBase;
    this.DWARF2LineRange = $Prm0.DWARF2LineRange;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCDwarfLineTableParams::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 183,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 185,
   FQN="llvm::MCDwarfLineTableParams::operator=", NM="_ZN4llvm22MCDwarfLineTableParamsaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAssembler.cpp -nm=_ZN4llvm22MCDwarfLineTableParamsaSERKS0_")
  //</editor-fold>
  public /*inline*/ MCDwarfLineTableParams /*&*/ $assign(final /*const*/ MCDwarfLineTableParams /*&*/ $Prm0) {
    this.DWARF2LineOpcodeBase = $Prm0.DWARF2LineOpcodeBase;
    this.DWARF2LineBase = $Prm0.DWARF2LineBase;
    this.DWARF2LineRange = $Prm0.DWARF2LineRange;
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "DWARF2LineOpcodeBase=" + $uchar2uint(DWARF2LineOpcodeBase) // NOI18N
              + ", DWARF2LineBase=" + DWARF2LineBase // NOI18N
              + ", DWARF2LineRange=" + $uchar2uint(DWARF2LineRange); // NOI18N
  }
}
