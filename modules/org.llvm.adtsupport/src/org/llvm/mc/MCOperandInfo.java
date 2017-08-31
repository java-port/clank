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


/// MCOperandInfo - This holds information about one operand of a machine
/// instruction, indicating the register class for register operands, etc.
///
//<editor-fold defaultstate="collapsed" desc="llvm::MCOperandInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 56,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 59,
 FQN = "llvm::MCOperandInfo", NM = "_ZN4llvm13MCOperandInfoE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm13MCOperandInfoE")
//</editor-fold>
public class MCOperandInfo {
/*public:*/
  /// RegClass - This specifies the register class enumeration of the operand
  /// if the operand is a register.  If isLookupPtrRegClass is set, then this is
  /// an index that is passed to TargetRegisterInfo::getPointerRegClass(x) to
  /// get a dynamic register class.
  public short/*int16_t*/ RegClass;
  
  /// Flags - These are flags from the MCOI::OperandFlags enum.
  public byte/*uint8_t*/ Flags;
  
  /// OperandType - Information about the type of the operand.
  public byte/*uint8_t*/ OperandType;
  
  /// Lower 16 bits are used to specify which constraints are set. The higher 16
  /// bits are used to specify the value of constraints (4 bits each).
  public int/*uint32_t*/ Constraints;
  /// Currently no other information.
  
  /// isLookupPtrRegClass - Set if this operand is a pointer value and it
  /// requires a callback to look up its register class.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperandInfo::isLookupPtrRegClass">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 76,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 80,
   FQN = "llvm::MCOperandInfo::isLookupPtrRegClass", NM = "_ZNK4llvm13MCOperandInfo19isLookupPtrRegClassEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCOperandInfo19isLookupPtrRegClassEv")
  //</editor-fold>
  public boolean isLookupPtrRegClass() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isPredicate - Set if this is one of the operands that made up of
  /// the predicate operand that controls an isPredicable() instruction.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperandInfo::isPredicate">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 82,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 84,
   FQN = "llvm::MCOperandInfo::isPredicate", NM = "_ZNK4llvm13MCOperandInfo11isPredicateEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCOperandInfo11isPredicateEv")
  //</editor-fold>
  public boolean isPredicate() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// isOptionalDef - Set if this operand is a optional def.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperandInfo::isOptionalDef">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 85,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 88,
   FQN = "llvm::MCOperandInfo::isOptionalDef", NM = "_ZNK4llvm13MCOperandInfo13isOptionalDefEv",
   cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZNK4llvm13MCOperandInfo13isOptionalDefEv")
  //</editor-fold>
  public boolean isOptionalDef() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

}
