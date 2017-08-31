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


//<editor-fold defaultstate="collapsed" desc="static type WinEH">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp ${LLVM_SRC}/llvm/lib/MC/MCWinEH.cpp -nm=_ZN4llvm5WinEH11InstructionE;_ZN4llvm5WinEH12EncodingTypeE;_ZN4llvm5WinEH13UnwindEmitterE;_ZN4llvm5WinEH9FrameInfoE; -static-type=WinEH -package=org.llvm.mc")
//</editor-fold>
public final class WinEH {

//<editor-fold defaultstate="collapsed" desc="llvm::WinEH::EncodingType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCAsmInfo.h", line = 32,
 FQN="llvm::WinEH::EncodingType", NM="_ZN4llvm5WinEH12EncodingTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH12EncodingTypeE")
//</editor-fold>
public enum /*class */EncodingType/* : int*/ implements Native.ComparableLower {
  Invalid(0), /// Invalid
  Alpha(Invalid.getValue() + 1), /// Windows Alpha
  Alpha64(Alpha.getValue() + 1), /// Windows AXP64
  ARM(Alpha64.getValue() + 1), /// Windows NT (Windows on ARM)
  CE(ARM.getValue() + 1), /// Windows CE ARM, PowerPC, SH3, SH4
  Itanium(CE.getValue() + 1), /// Windows x64, Windows Itanium (IA-64)
  X86(Itanium.getValue() + 1), /// Windows x86, uses no CFI, just EH tables
  MIPS(Alpha.getValue());

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static EncodingType valueOf(int val) {
    EncodingType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final EncodingType[] VALUES;
    private static final EncodingType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (EncodingType kind : EncodingType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new EncodingType[min < 0 ? (1-min) : 0];
      VALUES = new EncodingType[max >= 0 ? (1+max) : 0];
      for (EncodingType kind : EncodingType.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private EncodingType(int val) { this.value = (int)val;}
  public int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((EncodingType)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((EncodingType)obj).value);}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::WinEH::Instruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 21,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 23,
 FQN="llvm::WinEH::Instruction", NM="_ZN4llvm5WinEH11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH11InstructionE")
//</editor-fold>
public static class/*struct*/ Instruction {
  public /*const*/ MCSymbol /*P*/ Label;
  public /*const*//*uint*/int Offset;
  public /*const*//*uint*/int Register;
  public /*const*//*uint*/int Operation;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::Instruction::Instruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 27,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 29,
   FQN="llvm::WinEH::Instruction::Instruction", NM="_ZN4llvm5WinEH11InstructionC1EjPNS_8MCSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH11InstructionC1EjPNS_8MCSymbolEjj")
  //</editor-fold>
  public Instruction(/*uint*/int Op, MCSymbol /*P*/ L, /*uint*/int Reg, /*uint*/int Off) {
    // : Label(L), Offset(Off), Register(Reg), Operation(Op) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::Instruction::Instruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 21,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 23,
   FQN="llvm::WinEH::Instruction::Instruction", NM="_ZN4llvm5WinEH11InstructionC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm5WinEH11InstructionC1ERKS1_")
  //</editor-fold>
  public /*inline*/ Instruction(/*const*/ Instruction /*&*/ $Prm0) {
    // : Label(.Label), Offset(.Offset), Register(.Register), Operation(.Operation) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::Instruction::Instruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 21,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 23,
   FQN="llvm::WinEH::Instruction::Instruction", NM="_ZN4llvm5WinEH11InstructionC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm5WinEH11InstructionC1EOS1_")
  //</editor-fold>
  public /*inline*/ Instruction(JD$Move _dparam, Instruction /*&&*/$Prm0) {
    // : Label(static_cast<Instruction &&>().Label), Offset(static_cast<Instruction &&>().Offset), Register(static_cast<Instruction &&>().Register), Operation(static_cast<Instruction &&>().Operation) 
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::Instruction::~Instruction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 21,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 23,
   FQN="llvm::WinEH::Instruction::~Instruction", NM="_ZN4llvm5WinEH11InstructionD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm5WinEH11InstructionD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "Label=" + Label // NOI18N
              + ", Offset=" + Offset // NOI18N
              + ", Register=" + Register // NOI18N
              + ", Operation=" + Operation; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::WinEH::FrameInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 31,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 33,
 FQN="llvm::WinEH::FrameInfo", NM="_ZN4llvm5WinEH9FrameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH9FrameInfoE")
//</editor-fold>
public static class/*struct*/ FrameInfo implements Destructors.ClassWithDestructor {
  public /*const*/ MCSymbol /*P*/ Begin/* = null*/;
  public /*const*/ MCSymbol /*P*/ End/* = null*/;
  public /*const*/ MCSymbol /*P*/ ExceptionHandler/* = null*/;
  public /*const*/ MCSymbol /*P*/ Function/* = null*/;
  public /*const*/ MCSymbol /*P*/ PrologEnd/* = null*/;
  public /*const*/ MCSymbol /*P*/ Symbol/* = null*/;
  public /*const*/ MCSection /*P*/ TextSection/* = null*/;
  
  public boolean HandlesUnwind/* = false*/;
  public boolean HandlesExceptions/* = false*/;
  
  public int LastFrameInst/* = -1*/;
  public /*const*/ FrameInfo /*P*/ ChainedParent/* = null*/;
  public std.vector<Instruction> Instructions;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::FrameInfo::FrameInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 47,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 48,
   FQN="llvm::WinEH::FrameInfo::FrameInfo", NM="_ZN4llvm5WinEH9FrameInfoC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH9FrameInfoC1Ev")
  //</editor-fold>
  public FrameInfo()/* = default*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::FrameInfo::FrameInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 48,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 53,
   FQN="llvm::WinEH::FrameInfo::FrameInfo", NM="_ZN4llvm5WinEH9FrameInfoC1EPKNS_8MCSymbolES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH9FrameInfoC1EPKNS_8MCSymbolES4_")
  //</editor-fold>
  public FrameInfo(/*const*/ MCSymbol /*P*/ Function, /*const*/ MCSymbol /*P*/ BeginFuncEHLabel) {
    // : Begin(BeginFuncEHLabel), End(null), ExceptionHandler(null), Function(Function), PrologEnd(null), Symbol(null), TextSection(null), HandlesUnwind(false), HandlesExceptions(false), LastFrameInst(-1), ChainedParent(null), Instructions() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::FrameInfo::FrameInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 50,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 58,
   FQN="llvm::WinEH::FrameInfo::FrameInfo", NM="_ZN4llvm5WinEH9FrameInfoC1EPKNS_8MCSymbolES4_PKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH9FrameInfoC1EPKNS_8MCSymbolES4_PKS1_")
  //</editor-fold>
  public FrameInfo(/*const*/ MCSymbol /*P*/ Function, /*const*/ MCSymbol /*P*/ BeginFuncEHLabel, 
      /*const*/ FrameInfo /*P*/ ChainedParent) {
    // : Begin(BeginFuncEHLabel), End(null), ExceptionHandler(null), Function(Function), PrologEnd(null), Symbol(null), TextSection(null), HandlesUnwind(false), HandlesExceptions(false), LastFrameInst(-1), ChainedParent(ChainedParent), Instructions() 
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::FrameInfo::~FrameInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 31,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 33,
   FQN="llvm::WinEH::FrameInfo::~FrameInfo", NM="_ZN4llvm5WinEH9FrameInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCStreamer.cpp -nm=_ZN4llvm5WinEH9FrameInfoD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  @Override public String toString() {
    return "" + "Begin=" + Begin // NOI18N
              + ", End=" + End // NOI18N
              + ", ExceptionHandler=" + ExceptionHandler // NOI18N
              + ", Function=" + Function // NOI18N
              + ", PrologEnd=" + PrologEnd // NOI18N
              + ", Symbol=" + Symbol // NOI18N
              + ", TextSection=" + TextSection // NOI18N
              + ", HandlesUnwind=" + HandlesUnwind // NOI18N
              + ", HandlesExceptions=" + HandlesExceptions // NOI18N
              + ", LastFrameInst=" + LastFrameInst // NOI18N
              + ", ChainedParent=" + ChainedParent // NOI18N
              + ", Instructions=" + Instructions; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::WinEH::UnwindEmitter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 56,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 66,
 FQN="llvm::WinEH::UnwindEmitter", NM="_ZN4llvm5WinEH13UnwindEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZN4llvm5WinEH13UnwindEmitterE")
//</editor-fold>
public abstract static class UnwindEmitter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::UnwindEmitter::~UnwindEmitter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCWinEH.cpp", line = 22,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 73,
   FQN="llvm::WinEH::UnwindEmitter::~UnwindEmitter", NM="_ZN4llvm5WinEH13UnwindEmitterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWinEH.cpp -nm=_ZN4llvm5WinEH13UnwindEmitterD0Ev")
  //</editor-fold>
  public void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }


  
  /// This emits the unwind info sections (.pdata and .xdata in PE/COFF).
  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::UnwindEmitter::Emit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 61,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 78,
   FQN="llvm::WinEH::UnwindEmitter::Emit", NM="_ZNK4llvm5WinEH13UnwindEmitter4EmitERNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm5WinEH13UnwindEmitter4EmitERNS_10MCStreamerE")
  //</editor-fold>
  public abstract /*virtual*/ void Emit(MCStreamer /*&*/ Streamer) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="llvm::WinEH::UnwindEmitter::EmitUnwindInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", line = 62,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWinEH.h", old_line = 79,
   FQN="llvm::WinEH::UnwindEmitter::EmitUnwindInfo", NM="_ZNK4llvm5WinEH13UnwindEmitter14EmitUnwindInfoERNS_10MCStreamerEPNS0_9FrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCAsmInfo.cpp -nm=_ZNK4llvm5WinEH13UnwindEmitter14EmitUnwindInfoERNS_10MCStreamerEPNS0_9FrameInfoE")
  //</editor-fold>
  public abstract /*virtual*/ void EmitUnwindInfo(MCStreamer /*&*/ Streamer, FrameInfo /*P*/ FI) /*const*//* = 0*/;

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
} // END OF class WinEH
