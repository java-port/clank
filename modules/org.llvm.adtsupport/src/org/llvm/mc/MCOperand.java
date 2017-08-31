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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCExpr$C;
import static org.llvm.support.AdtsupportLlvmGlobals.$out_raw_ostream_MCInst$C;


/// \brief Instances of this class represent operands of the MCInst class.
/// This is a simple discriminated union.
//<editor-fold defaultstate="collapsed" desc="llvm::MCOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 33,
 FQN="llvm::MCOperand", NM="_ZN4llvm9MCOperandE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandE")
//</editor-fold>
public class MCOperand {
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::MachineOperandType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 34,
   FQN="llvm::MCOperand::MachineOperandType", NM="_ZN4llvm9MCOperand18MachineOperandTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand18MachineOperandTypeE")
  //</editor-fold>
  private enum MachineOperandType/* : unsigned char*/ implements Native.NativeUCharEnum {
    kInvalid(0), ///< Uninitialized.
    kRegister(kInvalid.getValue() + 1), ///< Register operand.
    kImmediate(kRegister.getValue() + 1), ///< Immediate operand.
    kFPImmediate(kImmediate.getValue() + 1), ///< Floating-point immediate operand.
    kExpr(kFPImmediate.getValue() + 1), ///< Relocatable immediate operand.
    kInst(kExpr.getValue() + 1); ///< Sub-instruction operand.

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MachineOperandType valueOf(/*uchar*/byte val) {
      MachineOperandType out = valueOf((int)val);
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]. Int not capable to keep values?";
      return out;
    }
    public static MachineOperandType valueOf(int val) {
      MachineOperandType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MachineOperandType[] VALUES;
      private static final MachineOperandType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MachineOperandType kind : MachineOperandType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MachineOperandType[min < 0 ? (1-min) : 0];
        VALUES = new MachineOperandType[max >= 0 ? (1+max) : 0];
        for (MachineOperandType kind : MachineOperandType.values()) {
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

    private final /*uchar*/byte value;
    private MachineOperandType(int val) { this.value = (/*uchar*/byte)val;}
    @Override public final /*uchar*/byte getValue() { return value;}
    //</editor-fold>
  };
  private MachineOperandType Kind;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 44,
   FQN="llvm::MCOperand::(anonymous)", NM="_ZN4llvm9MCOperandE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public /*uint*/int RegVal;
    public long/*int64_t*/ ImmVal;
    public double FPImmVal;
    public /*const*/ MCExpr /*P*/ ExprVal;
    public /*const*/ MCInst /*P*/ InstVal;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 44,
     FQN="llvm::MCOperand::(anonymous union)::", NM="_ZN4llvm9MCOperandUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 44,
     FQN="llvm::MCOperand::(anonymous union)::operator=", NM="_ZN4llvm9MCOperandUt_aSERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandUt_aSERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assign(final Unnamed_union1 $Prm0) {
      
      return /*Deref*/this;
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::(anonymous union)::operator=">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 44,
     FQN="llvm::MCOperand::(anonymous union)::operator=", NM="_ZN4llvm9MCOperandUt_aSEOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandUt_aSEOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1 $assignMove(final Unnamed_union1 $Prm0) {
      
      return /*Deref*/this;
    }

    public Unnamed_union1() {
    }

    
    @Override public String toString() {
      return "" + "RegVal=" + RegVal // NOI18N
                + ", ImmVal=" + ImmVal // NOI18N
                + ", FPImmVal=" + FPImmVal // NOI18N
                + ", ExprVal=" + "[MCExpr]" // NOI18N
                + ", InstVal=" + InstVal; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field1 = new Unnamed_union1();
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::MCOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 53,
   FQN="llvm::MCOperand::MCOperand", NM="_ZN4llvm9MCOperandC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandC1Ev")
  //</editor-fold>
  public MCOperand() {
    // : Kind(kInvalid), FPImmVal(0.) 
    //START JInit
    this.Kind = MachineOperandType.kInvalid;
    /*Indirect*/this.Unnamed_field1.FPImmVal = 0.;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::isValid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 55,
   FQN="llvm::MCOperand::isValid", NM="_ZNK4llvm9MCOperand7isValidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand7isValidEv")
  //</editor-fold>
  public boolean isValid() /*const*/ {
    return Kind != MachineOperandType.kInvalid;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::isReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 56,
   FQN="llvm::MCOperand::isReg", NM="_ZNK4llvm9MCOperand5isRegEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand5isRegEv")
  //</editor-fold>
  public boolean isReg() /*const*/ {
    return Kind == MachineOperandType.kRegister;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::isImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 57,
   FQN="llvm::MCOperand::isImm", NM="_ZNK4llvm9MCOperand5isImmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand5isImmEv")
  //</editor-fold>
  public boolean isImm() /*const*/ {
    return Kind == MachineOperandType.kImmediate;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::isFPImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 58,
   FQN="llvm::MCOperand::isFPImm", NM="_ZNK4llvm9MCOperand7isFPImmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand7isFPImmEv")
  //</editor-fold>
  public boolean isFPImm() /*const*/ {
    return Kind == MachineOperandType.kFPImmediate;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::isExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 59,
   FQN="llvm::MCOperand::isExpr", NM="_ZNK4llvm9MCOperand6isExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand6isExprEv")
  //</editor-fold>
  public boolean isExpr() /*const*/ {
    return Kind == MachineOperandType.kExpr;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::isInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 60,
   FQN="llvm::MCOperand::isInst", NM="_ZNK4llvm9MCOperand6isInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand6isInstEv")
  //</editor-fold>
  public boolean isInst() /*const*/ {
    return Kind == MachineOperandType.kInst;
  }

  
  /// \brief Returns the register number.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::getReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 63,
   FQN="llvm::MCOperand::getReg", NM="_ZNK4llvm9MCOperand6getRegEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand6getRegEv")
  //</editor-fold>
  public /*uint*/int getReg() /*const*/ {
    assert (isReg()) : "This is not a register operand!";
    return Unnamed_field1.RegVal;
  }

  
  /// \brief Set the register number.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::setReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 69,
   FQN="llvm::MCOperand::setReg", NM="_ZN4llvm9MCOperand6setRegEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand6setRegEj")
  //</editor-fold>
  public void setReg(/*uint*/int Reg) {
    assert (isReg()) : "This is not a register operand!";
    Unnamed_field1.RegVal = Reg;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::getImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 74,
   FQN="llvm::MCOperand::getImm", NM="_ZNK4llvm9MCOperand6getImmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand6getImmEv")
  //</editor-fold>
  public long/*int64_t*/ getImm() /*const*/ {
    assert (isImm()) : "This is not an immediate";
    return Unnamed_field1.ImmVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::setImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 78,
   FQN="llvm::MCOperand::setImm", NM="_ZN4llvm9MCOperand6setImmEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand6setImmEx")
  //</editor-fold>
  public void setImm(long/*int64_t*/ Val) {
    assert (isImm()) : "This is not an immediate";
    Unnamed_field1.ImmVal = Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::getFPImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 83,
   FQN="llvm::MCOperand::getFPImm", NM="_ZNK4llvm9MCOperand8getFPImmEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand8getFPImmEv")
  //</editor-fold>
  public double getFPImm() /*const*/ {
    assert (isFPImm()) : "This is not an FP immediate";
    return Unnamed_field1.FPImmVal;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::setFPImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 88,
   FQN="llvm::MCOperand::setFPImm", NM="_ZN4llvm9MCOperand8setFPImmEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand8setFPImmEd")
  //</editor-fold>
  public void setFPImm(double Val) {
    assert (isFPImm()) : "This is not an FP immediate";
    Unnamed_field1.FPImmVal = Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 93,
   FQN="llvm::MCOperand::getExpr", NM="_ZNK4llvm9MCOperand7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand7getExprEv")
  //</editor-fold>
  public /*const*/ MCExpr /*P*/ getExpr() /*const*/ {
    assert (isExpr()) : "This is not an expression";
    return Unnamed_field1.ExprVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::setExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 97,
   FQN="llvm::MCOperand::setExpr", NM="_ZN4llvm9MCOperand7setExprEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand7setExprEPKNS_6MCExprE")
  //</editor-fold>
  public void setExpr(/*const*/ MCExpr /*P*/ Val) {
    assert (isExpr()) : "This is not an expression";
    Unnamed_field1.ExprVal = Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::getInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 102,
   FQN="llvm::MCOperand::getInst", NM="_ZNK4llvm9MCOperand7getInstEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand7getInstEv")
  //</editor-fold>
  public /*const*/ MCInst /*P*/ getInst() /*const*/ {
    assert (isInst()) : "This is not a sub-instruction";
    return Unnamed_field1.InstVal;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::setInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 106,
   FQN="llvm::MCOperand::setInst", NM="_ZN4llvm9MCOperand7setInstEPKNS_6MCInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand7setInstEPKNS_6MCInstE")
  //</editor-fold>
  public void setInst(/*const*/ MCInst /*P*/ Val) {
    assert (isInst()) : "This is not a sub-instruction";
    Unnamed_field1.InstVal = Val;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::createReg">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 111,
   FQN="llvm::MCOperand::createReg", NM="_ZN4llvm9MCOperand9createRegEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand9createRegEj")
  //</editor-fold>
  public static MCOperand createReg(/*uint*/int Reg) {
    MCOperand Op/*J*/= new MCOperand();
    Op.Kind = MachineOperandType.kRegister;
    Op.Unnamed_field1.RegVal = Reg;
    return Op;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::createImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 117,
   FQN="llvm::MCOperand::createImm", NM="_ZN4llvm9MCOperand9createImmEx",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand9createImmEx")
  //</editor-fold>
  public static MCOperand createImm(long/*int64_t*/ Val) {
    MCOperand Op/*J*/= new MCOperand();
    Op.Kind = MachineOperandType.kImmediate;
    Op.Unnamed_field1.ImmVal = Val;
    return Op;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::createFPImm">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 123,
   FQN="llvm::MCOperand::createFPImm", NM="_ZN4llvm9MCOperand11createFPImmEd",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand11createFPImmEd")
  //</editor-fold>
  public static MCOperand createFPImm(double Val) {
    MCOperand Op/*J*/= new MCOperand();
    Op.Kind = MachineOperandType.kFPImmediate;
    Op.Unnamed_field1.FPImmVal = Val;
    return Op;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::createExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 129,
   FQN="llvm::MCOperand::createExpr", NM="_ZN4llvm9MCOperand10createExprEPKNS_6MCExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand10createExprEPKNS_6MCExprE")
  //</editor-fold>
  public static MCOperand createExpr(/*const*/ MCExpr /*P*/ Val) {
    MCOperand Op/*J*/= new MCOperand();
    Op.Kind = MachineOperandType.kExpr;
    Op.Unnamed_field1.ExprVal = Val;
    return Op;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::createInst">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 135,
   FQN="llvm::MCOperand::createInst", NM="_ZN4llvm9MCOperand10createInstEPKNS_6MCInstE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperand10createInstEPKNS_6MCInstE")
  //</editor-fold>
  public static MCOperand createInst(/*const*/ MCInst /*P*/ Val) {
    MCOperand Op/*J*/= new MCOperand();
    Op.Kind = MachineOperandType.kInst;
    Op.Unnamed_field1.InstVal = Val;
    return Op;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::print">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInst.cpp", line = 18,
   FQN="llvm::MCOperand::print", NM="_ZNK4llvm9MCOperand5printERNS_11raw_ostreamE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand5printERNS_11raw_ostreamE")
  //</editor-fold>
  public void print(final raw_ostream /*&*/ OS) /*const*/ {
    OS.$out(/*KEEP_STR*/"<MCOperand ");
    if (!isValid()) {
      OS.$out(/*KEEP_STR*/"INVALID");
    } else if (isReg()) {
      OS.$out(/*KEEP_STR*/"Reg:").$out_uint(getReg());
    } else if (isImm()) {
      OS.$out(/*KEEP_STR*/"Imm:").$out_llong(getImm());
    } else if (isFPImm()) {
      OS.$out(/*KEEP_STR*/"FPImm:").$out_double(getFPImm());
    } else if (isExpr()) {
      $out_raw_ostream_MCExpr$C(OS.$out(/*KEEP_STR*/"Expr:("), $Deref(getExpr())).$out(/*KEEP_STR*/$RPAREN);
    } else if (isInst()) {
      $out_raw_ostream_MCInst$C(OS.$out(/*KEEP_STR*/"Inst:("), $Deref(getInst())).$out(/*KEEP_STR*/$RPAREN);
    } else {
      OS.$out(/*KEEP_STR*/"UNDEFINED");
    }
    OS.$out(/*KEEP_STR*/$GT);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::dump">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/MC/MCInst.cpp", line = 38,
   FQN="llvm::MCOperand::dump", NM="_ZNK4llvm9MCOperand4dumpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZNK4llvm9MCOperand4dumpEv")
  //</editor-fold>
  public void dump() /*const*//* __attribute__((used)) __attribute__((noinline))*/ {
    print(dbgs());
    dbgs().$out(/*KEEP_STR*/$LF);
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::MCOperand">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 33,
   FQN="llvm::MCOperand::MCOperand", NM="_ZN4llvm9MCOperandC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCOperand(JD$Move _dparam, final MCOperand /*&&*/$Prm0) {
    // : Kind(static_cast<MCOperand &&>().Kind), Unnamed_field1(static_cast<MCOperand &&>().) 
    //START JInit
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field1);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 33,
   FQN="llvm::MCOperand::operator=", NM="_ZN4llvm9MCOperandaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandaSERKS0_")
  //</editor-fold>
  public /*inline*/ MCOperand /*&*/ $assign(final /*const*/ MCOperand /*&*/ $Prm0) {
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1.$assign($Prm0.Unnamed_field1);
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCOperand::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCInst.h", line = 33,
   FQN="llvm::MCOperand::operator=", NM="_ZN4llvm9MCOperandaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCInst.cpp -nm=_ZN4llvm9MCOperandaSEOS0_")
  //</editor-fold>
  public /*inline*/ MCOperand /*&*/ $assignMove(final MCOperand /*&&*/$Prm0) {
    this.Kind = $Prm0.Kind;
    this.Unnamed_field1.$assignMove($Prm0.Unnamed_field1);
    return /*Deref*/this;
  }

  
  @Override public String toString() {
    return "" + "Kind=" + Kind // NOI18N
              + ", Unnamed_field1=" + Unnamed_field1; // NOI18N
  }
}
