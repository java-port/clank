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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;

//<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 325,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 327,
 FQN="llvm::MCCFIInstruction", NM="_ZN4llvm16MCCFIInstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionE")
//</editor-fold>
public class MCCFIInstruction implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::OpType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 327,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 329,
   FQN="llvm::MCCFIInstruction::OpType", NM="_ZN4llvm16MCCFIInstruction6OpTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction6OpTypeE")
  //</editor-fold>
  public enum OpType implements Native.NativeUIntEnum {
    OpSameValue(0),
    OpRememberState(OpSameValue.getValue() + 1),
    OpRestoreState(OpRememberState.getValue() + 1),
    OpOffset(OpRestoreState.getValue() + 1),
    OpDefCfaRegister(OpOffset.getValue() + 1),
    OpDefCfaOffset(OpDefCfaRegister.getValue() + 1),
    OpDefCfa(OpDefCfaOffset.getValue() + 1),
    OpRelOffset(OpDefCfa.getValue() + 1),
    OpAdjustCfaOffset(OpRelOffset.getValue() + 1),
    OpEscape(OpAdjustCfaOffset.getValue() + 1),
    OpRestore(OpEscape.getValue() + 1),
    OpUndefined(OpRestore.getValue() + 1),
    OpRegister(OpUndefined.getValue() + 1),
    OpWindowSave(OpRegister.getValue() + 1),
    OpGnuArgsSize(OpWindowSave.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OpType valueOf(int val) {
      OpType out = (val < 0) ? $Values._VALUES[-val] : $Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class $Values {
      private static final OpType[] VALUES;
      private static final OpType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OpType kind : OpType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OpType[min < 0 ? (1-min) : 0];
        VALUES = new OpType[max >= 0 ? (1+max) : 0];
        for (OpType kind : OpType.values()) {
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
    private OpType(int val) { this.value = (/*uint*/int)val;}
    @Override public final /*uint*/int getValue() { return value;}
    //</editor-fold>
  };
/*private:*/
  private OpType Operation;
  private MCSymbol /*P*/ Label;
  private /*uint*/int Register;
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 349,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 351,
   FQN="llvm::MCCFIInstruction::(anonymous)", NM="_ZN4llvm16MCCFIInstructionE_Unnamed_union1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionE_Unnamed_union1")
  //</editor-fold>
  private static class/*union*/ Unnamed_union1 {
    public int Offset;
    public /*uint*/int Register2;
    //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 349,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 351,
     FQN="llvm::MCCFIInstruction::(anonymous union)::", NM="_ZN4llvm16MCCFIInstructionUt_C1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionUt_C1ERKS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(final Unnamed_union1 $Prm0) {
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 349,
     old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 351,
     FQN="llvm::MCCFIInstruction::(anonymous union)::", NM="_ZN4llvm16MCCFIInstructionUt_C1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionUt_C1EOS1_")
    //</editor-fold>
    public /*inline*/ Unnamed_union1(JD$Move _dparam, final Unnamed_union1 $Prm0) {
    }

    public Unnamed_union1() {
    }
    
    @Override public String toString() {
      return "" + "Offset=" + Offset // NOI18N
                + ", Register2=" + Register2; // NOI18N
    }
  };
  private Unnamed_union1 Unnamed_field3 = new Unnamed_union1();
  private std.vectorChar Values;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::MCCFIInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 355,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 357,
   FQN="llvm::MCCFIInstruction::MCCFIInstruction", NM="_ZN4llvm16MCCFIInstructionC1ENS0_6OpTypeEPNS_8MCSymbolEjiNS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionC1ENS0_6OpTypeEPNS_8MCSymbolEjiNS_9StringRefE")
  //</editor-fold>
  private MCCFIInstruction(OpType Op, MCSymbol /*P*/ L, /*uint*/int R, int O, StringRef V) {
    // : Operation(Op), Label(L), Register(R), Offset(O), Values(V.begin(), V.end()) 
    //START JInit
    this.Operation = Op;
    this.Label = L;
    this.Register = R;
    /*Indirect*/this.Unnamed_field3.Offset = O;
    this.Values = new std.vectorChar(V.begin(), V.end());
    //END JInit
    assert (Op != OpType.OpRegister);
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::MCCFIInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 361,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 363,
   FQN="llvm::MCCFIInstruction::MCCFIInstruction", NM="_ZN4llvm16MCCFIInstructionC1ENS0_6OpTypeEPNS_8MCSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionC1ENS0_6OpTypeEPNS_8MCSymbolEjj")
  //</editor-fold>
  private MCCFIInstruction(OpType Op, MCSymbol /*P*/ L, /*uint*/int R1, /*uint*/int R2) {
    // : Operation(Op), Label(L), Register(R1), Register2(R2), Values() 
    //START JInit
    this.Operation = Op;
    this.Label = L;
    this.Register = R1;
    /*Indirect*/this.Unnamed_field3.Register2 = R2;
    this.Values = new std.vectorChar();
    //END JInit
    assert (Op == OpType.OpRegister);
  }

/*public:*/
  /// \brief .cfi_def_cfa defines a rule for computing CFA as: take address from
  /// Register and add Offset to it.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createDefCfa">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 369,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 371,
   FQN="llvm::MCCFIInstruction::createDefCfa", NM="_ZN4llvm16MCCFIInstruction12createDefCfaEPNS_8MCSymbolEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction12createDefCfaEPNS_8MCSymbolEji")
  //</editor-fold>
  public static MCCFIInstruction createDefCfa(MCSymbol /*P*/ L, /*uint*/int Register, 
              int Offset) {
    return new MCCFIInstruction(OpType.OpDefCfa, L, Register, -Offset, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_def_cfa_register modifies a rule for computing CFA. From now
  /// on Register will be used instead of the old one. Offset remains the same.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createDefCfaRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 376,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 378,
   FQN="llvm::MCCFIInstruction::createDefCfaRegister", NM="_ZN4llvm16MCCFIInstruction20createDefCfaRegisterEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction20createDefCfaRegisterEPNS_8MCSymbolEj")
  //</editor-fold>
  public static MCCFIInstruction createDefCfaRegister(MCSymbol /*P*/ L, /*uint*/int Register) {
    return new MCCFIInstruction(OpType.OpDefCfaRegister, L, Register, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_def_cfa_offset modifies a rule for computing CFA. Register
  /// remains the same, but offset is new. Note that it is the absolute offset
  /// that will be added to a defined register to the compute CFA address.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createDefCfaOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 383,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 385,
   FQN="llvm::MCCFIInstruction::createDefCfaOffset", NM="_ZN4llvm16MCCFIInstruction18createDefCfaOffsetEPNS_8MCSymbolEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction18createDefCfaOffsetEPNS_8MCSymbolEi")
  //</editor-fold>
  public static MCCFIInstruction createDefCfaOffset(MCSymbol /*P*/ L, int Offset) {
    return new MCCFIInstruction(OpType.OpDefCfaOffset, L, 0, -Offset, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_adjust_cfa_offset Same as .cfi_def_cfa_offset, but
  /// Offset is a relative value that is added/subtracted from the previous
  /// offset.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createAdjustCfaOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 390,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 392,
   FQN="llvm::MCCFIInstruction::createAdjustCfaOffset", NM="_ZN4llvm16MCCFIInstruction21createAdjustCfaOffsetEPNS_8MCSymbolEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction21createAdjustCfaOffsetEPNS_8MCSymbolEi")
  //</editor-fold>
  public static MCCFIInstruction createAdjustCfaOffset(MCSymbol /*P*/ L, int Adjustment) {
    return new MCCFIInstruction(OpType.OpAdjustCfaOffset, L, 0, Adjustment, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_offset Previous value of Register is saved at offset Offset
  /// from CFA.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 396,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 398,
   FQN="llvm::MCCFIInstruction::createOffset", NM="_ZN4llvm16MCCFIInstruction12createOffsetEPNS_8MCSymbolEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction12createOffsetEPNS_8MCSymbolEji")
  //</editor-fold>
  public static MCCFIInstruction createOffset(MCSymbol /*P*/ L, /*uint*/int Register, 
              int Offset) {
    return new MCCFIInstruction(OpType.OpOffset, L, Register, Offset, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_rel_offset Previous value of Register is saved at offset
  /// Offset from the current CFA register. This is transformed to .cfi_offset
  /// using the known displacement of the CFA register from the CFA.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createRelOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 404,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 406,
   FQN="llvm::MCCFIInstruction::createRelOffset", NM="_ZN4llvm16MCCFIInstruction15createRelOffsetEPNS_8MCSymbolEji",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction15createRelOffsetEPNS_8MCSymbolEji")
  //</editor-fold>
  public static MCCFIInstruction createRelOffset(MCSymbol /*P*/ L, /*uint*/int Register, 
                 int Offset) {
    return new MCCFIInstruction(OpType.OpRelOffset, L, Register, Offset, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_register Previous value of Register1 is saved in
  /// register Register2.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 411,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 413,
   FQN="llvm::MCCFIInstruction::createRegister", NM="_ZN4llvm16MCCFIInstruction14createRegisterEPNS_8MCSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction14createRegisterEPNS_8MCSymbolEjj")
  //</editor-fold>
  public static MCCFIInstruction createRegister(MCSymbol /*P*/ L, /*uint*/int Register1, 
                /*uint*/int Register2) {
    return new MCCFIInstruction(OpType.OpRegister, L, Register1, Register2);
  }

  
  /// \brief .cfi_window_save SPARC register window is saved.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createWindowSave">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 417,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 419,
   FQN="llvm::MCCFIInstruction::createWindowSave", NM="_ZN4llvm16MCCFIInstruction16createWindowSaveEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction16createWindowSaveEPNS_8MCSymbolE")
  //</editor-fold>
  public static MCCFIInstruction createWindowSave(MCSymbol /*P*/ L) {
    return new MCCFIInstruction(OpType.OpWindowSave, L, 0, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_restore says that the rule for Register is now the same as it
  /// was at the beginning of the function, after all initial instructions added
  /// by .cfi_startproc were executed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createRestore">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 424,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 426,
   FQN="llvm::MCCFIInstruction::createRestore", NM="_ZN4llvm16MCCFIInstruction13createRestoreEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction13createRestoreEPNS_8MCSymbolEj")
  //</editor-fold>
  public static MCCFIInstruction createRestore(MCSymbol /*P*/ L, /*uint*/int Register) {
    return new MCCFIInstruction(OpType.OpRestore, L, Register, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_undefined From now on the previous value of Register can't be
  /// restored anymore.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createUndefined">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 430,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 432,
   FQN="llvm::MCCFIInstruction::createUndefined", NM="_ZN4llvm16MCCFIInstruction15createUndefinedEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction15createUndefinedEPNS_8MCSymbolEj")
  //</editor-fold>
  public static MCCFIInstruction createUndefined(MCSymbol /*P*/ L, /*uint*/int Register) {
    return new MCCFIInstruction(OpType.OpUndefined, L, Register, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_same_value Current value of Register is the same as in the
  /// previous frame. I.e., no restoration is needed.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createSameValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 436,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 438,
   FQN="llvm::MCCFIInstruction::createSameValue", NM="_ZN4llvm16MCCFIInstruction15createSameValueEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction15createSameValueEPNS_8MCSymbolEj")
  //</editor-fold>
  public static MCCFIInstruction createSameValue(MCSymbol /*P*/ L, /*uint*/int Register) {
    return new MCCFIInstruction(OpType.OpSameValue, L, Register, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_remember_state Save all current rules for all registers.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createRememberState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 441,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 443,
   FQN="llvm::MCCFIInstruction::createRememberState", NM="_ZN4llvm16MCCFIInstruction19createRememberStateEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction19createRememberStateEPNS_8MCSymbolE")
  //</editor-fold>
  public static MCCFIInstruction createRememberState(MCSymbol /*P*/ L) {
    return new MCCFIInstruction(OpType.OpRememberState, L, 0, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_restore_state Restore the previously saved state.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createRestoreState">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 446,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 448,
   FQN="llvm::MCCFIInstruction::createRestoreState", NM="_ZN4llvm16MCCFIInstruction18createRestoreStateEPNS_8MCSymbolE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction18createRestoreStateEPNS_8MCSymbolE")
  //</editor-fold>
  public static MCCFIInstruction createRestoreState(MCSymbol /*P*/ L) {
    return new MCCFIInstruction(OpType.OpRestoreState, L, 0, 0, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  /// \brief .cfi_escape Allows the user to add arbitrary bytes to the unwind
  /// info.
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createEscape">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 454,
   FQN="llvm::MCCFIInstruction::createEscape", NM="_ZN4llvm16MCCFIInstruction12createEscapeEPNS_8MCSymbolENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction12createEscapeEPNS_8MCSymbolENS_9StringRefE")
  //</editor-fold>
  public static MCCFIInstruction createEscape(MCSymbol /*P*/ L, StringRef Vals) {
    return new MCCFIInstruction(OpType.OpEscape, L, 0, 0, new StringRef(Vals));
  }

  
  /// \brief A special wrapper for .cfi_escape that indicates GNU_ARGS_SIZE
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::createGnuArgsSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 457,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 459,
   FQN="llvm::MCCFIInstruction::createGnuArgsSize", NM="_ZN4llvm16MCCFIInstruction17createGnuArgsSizeEPNS_8MCSymbolEi",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstruction17createGnuArgsSizeEPNS_8MCSymbolEi")
  //</editor-fold>
  public static MCCFIInstruction createGnuArgsSize(MCSymbol /*P*/ L, int Size) {
    return new MCCFIInstruction(OpType.OpGnuArgsSize, L, 0, Size, new StringRef(/*KEEP_STR*/$EMPTY));
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::getOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 463,
   FQN="llvm::MCCFIInstruction::getOperation", NM="_ZNK4llvm16MCCFIInstruction12getOperationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCCFIInstruction12getOperationEv")
  //</editor-fold>
  public OpType getOperation() /*const*/ {
    return Operation;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::getLabel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 462,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 464,
   FQN="llvm::MCCFIInstruction::getLabel", NM="_ZNK4llvm16MCCFIInstruction8getLabelEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCCFIInstruction8getLabelEv")
  //</editor-fold>
  public MCSymbol /*P*/ getLabel() /*const*/ {
    return Label;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::getRegister">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 466,
   FQN="llvm::MCCFIInstruction::getRegister", NM="_ZNK4llvm16MCCFIInstruction11getRegisterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCCFIInstruction11getRegisterEv")
  //</editor-fold>
  public /*uint*/int getRegister() /*const*/ {
    assert (Operation == OpType.OpDefCfa || Operation == OpType.OpOffset || Operation == OpType.OpRestore || Operation == OpType.OpUndefined || Operation == OpType.OpSameValue || Operation == OpType.OpDefCfaRegister || Operation == OpType.OpRelOffset || Operation == OpType.OpRegister);
    return Register;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::getRegister2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 472,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 474,
   FQN="llvm::MCCFIInstruction::getRegister2", NM="_ZNK4llvm16MCCFIInstruction12getRegister2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCCFIInstruction12getRegister2Ev")
  //</editor-fold>
  public /*uint*/int getRegister2() /*const*/ {
    assert (Operation == OpType.OpRegister);
    return Unnamed_field3.Register2;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::getOffset">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 477,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 479,
   FQN="llvm::MCCFIInstruction::getOffset", NM="_ZNK4llvm16MCCFIInstruction9getOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCCFIInstruction9getOffsetEv")
  //</editor-fold>
  public int getOffset() /*const*/ {
    assert (Operation == OpType.OpDefCfa || Operation == OpType.OpOffset || Operation == OpType.OpRelOffset || Operation == OpType.OpDefCfaOffset || Operation == OpType.OpAdjustCfaOffset || Operation == OpType.OpGnuArgsSize);
    return Unnamed_field3.Offset;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::getValues">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 484,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 486,
   FQN="llvm::MCCFIInstruction::getValues", NM="_ZNK4llvm16MCCFIInstruction9getValuesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZNK4llvm16MCCFIInstruction9getValuesEv")
  //</editor-fold>
  public StringRef getValues() /*const*/ {
    assert (Operation == OpType.OpEscape);
    return new StringRef($AddrOf(Values.ptr$at(0)), Values.size());
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::MCCFIInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 325,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 327,
   FQN="llvm::MCCFIInstruction::MCCFIInstruction", NM="_ZN4llvm16MCCFIInstructionC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionC1EOS0_")
  //</editor-fold>
  public /*inline*/ MCCFIInstruction(JD$Move _dparam, final MCCFIInstruction /*&&*/$Prm0) {
    // : Operation(static_cast<MCCFIInstruction &&>().Operation), Label(static_cast<MCCFIInstruction &&>().Label), Register(static_cast<MCCFIInstruction &&>().Register), Unnamed_field3(static_cast<MCCFIInstruction &&>().), Values(static_cast<MCCFIInstruction &&>().Values) 
    //START JInit
    this.Operation = $Prm0.Operation;
    this.Label = $Prm0.Label;
    this.Register = $Prm0.Register;
    this.Unnamed_field3 = new Unnamed_union1(JD$Move.INSTANCE, $Prm0.Unnamed_field3);
    this.Values = new std.vectorChar(JD$Move.INSTANCE, $Prm0.Values);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::~MCCFIInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 325,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 327,
   FQN="llvm::MCCFIInstruction::~MCCFIInstruction", NM="_ZN4llvm16MCCFIInstructionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Values.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::MCCFIInstruction::MCCFIInstruction">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", line = 325,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCDwarf.h", old_line = 327,
   FQN="llvm::MCCFIInstruction::MCCFIInstruction", NM="_ZN4llvm16MCCFIInstructionC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCDwarf.cpp -nm=_ZN4llvm16MCCFIInstructionC1ERKS0_")
  //</editor-fold>
  public /*inline*/ MCCFIInstruction(final /*const*/ MCCFIInstruction /*&*/ $Prm0) {
    // : Operation(.Operation), Label(.Label), Register(.Register), Unnamed_field3(.), Values(.Values) 
    //START JInit
    this.Operation = $Prm0.Operation;
    this.Label = $Prm0.Label;
    this.Register = $Prm0.Register;
    this.Unnamed_field3 = new Unnamed_union1($Prm0.Unnamed_field3);
    this.Values = new std.vectorChar($Prm0.Values);
    //END JInit
  }

  public MCCFIInstruction() {
  }

  
  @Override public String toString() {
    return "" + "Operation=" + Operation // NOI18N
              + ", Label=" + Label // NOI18N
              + ", Register=" + Register // NOI18N
              + ", Unnamed_field3=" + Unnamed_field3 // NOI18N
              + ", Values=" + Values; // NOI18N
  }
}
