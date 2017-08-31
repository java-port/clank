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


//<editor-fold defaultstate="collapsed" desc="static type MCOI">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType -java-types-map=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm4MCOI17OperandConstraintE;_ZN4llvm4MCOI12OperandFlagsE;_ZN4llvm4MCOI11OperandTypeE; -static-type=MCOI")
//</editor-fold>
public final class MCOI {

// Operand constraints
//<editor-fold defaultstate="collapsed" desc="llvm::MCOI::OperandConstraint">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 33,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 31,
 FQN = "llvm::MCOI::OperandConstraint", NM = "_ZN4llvm4MCOI17OperandConstraintE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm4MCOI17OperandConstraintE")
//</editor-fold>
public enum OperandConstraint {
  TIED_TO(0), // Must be allocated the same register as.
  EARLY_CLOBBER(1); // Operand is an early clobber register operand

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OperandConstraint valueOf(int val) {
    OperandConstraint out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final OperandConstraint[] VALUES;
    private static final OperandConstraint[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OperandConstraint kind : OperandConstraint.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OperandConstraint[min < 0 ? (1-min) : 0];
      VALUES = new OperandConstraint[max >= 0 ? (1+max) : 0];
      for (OperandConstraint kind : OperandConstraint.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private OperandConstraint(/*uint*/int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}
  //</editor-fold>
}

/// OperandFlags - These are flags set on operands, but should be considered
/// private, all access should go through the MCOperandInfo accessors.
/// See the accessors for a description of what these are.
//<editor-fold defaultstate="collapsed" desc="llvm::MCOI::OperandFlags">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 41,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 39,
 FQN = "llvm::MCOI::OperandFlags", NM = "_ZN4llvm4MCOI12OperandFlagsE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm4MCOI12OperandFlagsE")
//</editor-fold>
public enum OperandFlags {
  LookupPtrRegClass(0),
  Predicate(1),
  OptionalDef(2);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OperandFlags valueOf(int val) {
    OperandFlags out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final OperandFlags[] VALUES;
    private static final OperandFlags[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OperandFlags kind : OperandFlags.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OperandFlags[min < 0 ? (1-min) : 0];
      VALUES = new OperandFlags[max >= 0 ? (1+max) : 0];
      for (OperandFlags kind : OperandFlags.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private OperandFlags(/*uint*/int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}
  //</editor-fold>
}

/// Operand Type - Operands are tagged with one of the values of this enum.
//<editor-fold defaultstate="collapsed" desc="llvm::MCOI::OperandType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY, source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", line = 44,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInstrDesc.h", old_line = 46,
 FQN = "llvm::MCOI::OperandType", NM = "_ZN4llvm4MCOI11OperandTypeE",
 cmd = "jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInstPrinter.cpp -nm=_ZN4llvm4MCOI11OperandTypeE")
//</editor-fold>
public enum OperandType {
  OPERAND_UNKNOWN(0),
  OPERAND_IMMEDIATE(1),
  OPERAND_REGISTER(2),
  OPERAND_MEMORY(3),
  OPERAND_PCREL(4);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static OperandType valueOf(int val) {
    OperandType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    return out;
  }

  private static final class Values {
    private static final OperandType[] VALUES;
    private static final OperandType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (OperandType kind : OperandType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new OperandType[min < 0 ? (1-min) : 0];
      VALUES = new OperandType[max >= 0 ? (1+max) : 0];
      for (OperandType kind : OperandType.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private OperandType(/*uint*/int val) { this.value = (int)val;}
  public int getValue() { return (int)value;}
  //</editor-fold>
}
} // END OF class MCOI
