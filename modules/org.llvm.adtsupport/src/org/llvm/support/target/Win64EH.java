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
package org.llvm.support.target;

import org.clank.support.*;
import org.llvm.mc.MCStreamer;
import org.llvm.mc.MCSymbol;
import org.llvm.mc.WinEH;
import org.llvm.support.llvm;


//<editor-fold defaultstate="collapsed" desc="static type Win64EH">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindCodeE;_ZN4llvm7Win64EH10UnwindInfoE;_ZN4llvm7Win64EH11InstructionE;_ZN4llvm7Win64EH13UnwindEmitterE;_ZN4llvm7Win64EH13UnwindOpcodesE;_ZN4llvm7Win64EH15RuntimeFunctionE;_ZN4llvm7Win64EHE_Win64EH_h_Unnamed_enum1; -static-type=Win64EH -package=org.llvm.support")
//</editor-fold>
public final class Win64EH {


/// UnwindOpcodes - Enumeration whose values specify a single operation in
/// the prolog of a function.
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindOpcodes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 27,
 FQN="llvm::Win64EH::UnwindOpcodes", NM="_ZN4llvm7Win64EH13UnwindOpcodesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH13UnwindOpcodesE")
//</editor-fold>
public enum UnwindOpcodes implements Native.ComparableLower {
  UOP_PushNonVol(0),
  UOP_AllocLarge(UOP_PushNonVol.getValue() + 1),
  UOP_AllocSmall(UOP_AllocLarge.getValue() + 1),
  UOP_SetFPReg(UOP_AllocSmall.getValue() + 1),
  UOP_SaveNonVol(UOP_SetFPReg.getValue() + 1),
  UOP_SaveNonVolBig(UOP_SaveNonVol.getValue() + 1),
  UOP_SaveXMM128(8),
  UOP_SaveXMM128Big(UOP_SaveXMM128.getValue() + 1),
  UOP_PushMachFrame(UOP_SaveXMM128Big.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static UnwindOpcodes valueOf(int val) {
    UnwindOpcodes out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final UnwindOpcodes[] VALUES;
    private static final UnwindOpcodes[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (UnwindOpcodes kind : UnwindOpcodes.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new UnwindOpcodes[min < 0 ? (1-min) : 0];
      VALUES = new UnwindOpcodes[max >= 0 ? (1+max) : 0];
      for (UnwindOpcodes kind : UnwindOpcodes.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private UnwindOpcodes(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((UnwindOpcodes)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((UnwindOpcodes)obj).value);}
  //</editor-fold>
}

/// UnwindCode - This union describes a single operation in a function prolog,
/// or part thereof.
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindCode">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 41,
 FQN="llvm::Win64EH::UnwindCode", NM="_ZN4llvm7Win64EH10UnwindCodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindCodeE")
//</editor-fold>
public static class/*union*/ UnwindCode {
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindCode::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 42,
   FQN="llvm::Win64EH::UnwindCode::(anonymous)", NM="_ZN4llvm7Win64EH10UnwindCodeE_Unnamed_struct1",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindCodeE_Unnamed_struct1")
  //</editor-fold>
  public static class/*struct*/ Unnamed_struct1 {
    public byte/*uint8_t*/ CodeOffset;
    public byte/*uint8_t*/ UnwindOpAndOpInfo;
    
    @Override public String toString() {
      return "" + "CodeOffset=" + CodeOffset // NOI18N
                + ", UnwindOpAndOpInfo=" + UnwindOpAndOpInfo; // NOI18N
    }
  };
  public Unnamed_struct1 u;
  public llvm.support.ulittle16_t FrameOffset;
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindCode::getUnwindOp">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 48,
   FQN="llvm::Win64EH::UnwindCode::getUnwindOp", NM="_ZNK4llvm7Win64EH10UnwindCode11getUnwindOpEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindCode11getUnwindOpEv")
  //</editor-fold>
  public byte/*uint8_t*/ getUnwindOp() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindCode::getOpInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 51,
   FQN="llvm::Win64EH::UnwindCode::getOpInfo", NM="_ZNK4llvm7Win64EH10UnwindCode9getOpInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindCode9getOpInfoEv")
  //</editor-fold>
  public byte/*uint8_t*/ getOpInfo() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "u=" + u // NOI18N
              + ", FrameOffset=" + FrameOffset; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 56,
 FQN="llvm::Win64EH::(anonymous)", NM="_ZN4llvm7Win64EHE_Win64EH_h_Unnamed_enum1",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EHE_Win64EH_h_Unnamed_enum1")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  /// UNW_ExceptionHandler - Specifies that this function has an exception
  /// handler.
  public static final /*uint*/int UNW_ExceptionHandler = 0x01;
  /// UNW_TerminateHandler - Specifies that this function has a termination
  /// handler.
  public static final /*uint*/int UNW_TerminateHandler = 0x02;
  /// UNW_ChainInfo - Specifies that this UnwindInfo structure is chained to
  /// another one.
  public static final /*uint*/int UNW_ChainInfo = 0x04;
/*}*/

/// RuntimeFunction - An entry in the table of functions with unwind info.
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::RuntimeFunction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 69,
 FQN="llvm::Win64EH::RuntimeFunction", NM="_ZN4llvm7Win64EH15RuntimeFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH15RuntimeFunctionE")
//</editor-fold>
public static class/*struct*/ RuntimeFunction {
  public llvm.support.ulittle32_t StartAddress;
  public llvm.support.ulittle32_t EndAddress;
  public llvm.support.ulittle32_t UnwindInfoOffset;
  
  @Override public String toString() {
    return "" + "StartAddress=" + StartAddress // NOI18N
              + ", EndAddress=" + EndAddress // NOI18N
              + ", UnwindInfoOffset=" + UnwindInfoOffset; // NOI18N
  }
}

/// UnwindInfo - An entry in the exception table.
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 76,
 FQN="llvm::Win64EH::UnwindInfo", NM="_ZN4llvm7Win64EH10UnwindInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindInfoE")
//</editor-fold>
public static class/*struct*/ UnwindInfo {
  public byte/*uint8_t*/ VersionAndFlags;
  public byte/*uint8_t*/ PrologSize;
  public byte/*uint8_t*/ NumCodes;
  public byte/*uint8_t*/ FrameRegisterAndOffset;
  public UnwindCode UnwindCodes[/*1*/] = new UnwindCode [1];
  
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getVersion">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 83,
   FQN="llvm::Win64EH::UnwindInfo::getVersion", NM="_ZNK4llvm7Win64EH10UnwindInfo10getVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo10getVersionEv")
  //</editor-fold>
  public byte/*uint8_t*/ getVersion() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getFlags">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 86,
   FQN="llvm::Win64EH::UnwindInfo::getFlags", NM="_ZNK4llvm7Win64EH10UnwindInfo8getFlagsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo8getFlagsEv")
  //</editor-fold>
  public byte/*uint8_t*/ getFlags() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getFrameRegister">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 89,
   FQN="llvm::Win64EH::UnwindInfo::getFrameRegister", NM="_ZNK4llvm7Win64EH10UnwindInfo16getFrameRegisterEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo16getFrameRegisterEv")
  //</editor-fold>
  public byte/*uint8_t*/ getFrameRegister() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getFrameOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 92,
   FQN="llvm::Win64EH::UnwindInfo::getFrameOffset", NM="_ZNK4llvm7Win64EH10UnwindInfo14getFrameOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo14getFrameOffsetEv")
  //</editor-fold>
  public byte/*uint8_t*/ getFrameOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  // The data after unwindCodes depends on flags.
  // If UNW_ExceptionHandler or UNW_TerminateHandler is set then follows
  // the address of the language-specific exception handler.
  // If UNW_ChainInfo is set then follows a RuntimeFunction which defines
  // the chained unwind info.
  // For more information please see MSDN at:
  // http://msdn.microsoft.com/en-us/library/ddssxxy8.aspx
  
  /// \brief Return pointer to language specific data part of UnwindInfo.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getLanguageSpecificData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 105,
   FQN="llvm::Win64EH::UnwindInfo::getLanguageSpecificData", NM="_ZN4llvm7Win64EH10UnwindInfo23getLanguageSpecificDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindInfo23getLanguageSpecificDataEv")
  //</editor-fold>
  public Object/*void P*/ getLanguageSpecificData() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return pointer to language specific data part of UnwindInfo.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getLanguageSpecificData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 110,
   FQN="llvm::Win64EH::UnwindInfo::getLanguageSpecificData", NM="_ZNK4llvm7Win64EH10UnwindInfo23getLanguageSpecificDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo23getLanguageSpecificDataEv")
  //</editor-fold>
  public /*const*/Object/*void P*/ getLanguageSpecificData$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return image-relative offset of language-specific exception handler.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getLanguageSpecificHandlerOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 115,
   FQN="llvm::Win64EH::UnwindInfo::getLanguageSpecificHandlerOffset", NM="_ZNK4llvm7Win64EH10UnwindInfo32getLanguageSpecificHandlerOffsetEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo32getLanguageSpecificHandlerOffsetEv")
  //</editor-fold>
  public /*uint32_t*/int getLanguageSpecificHandlerOffset() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Set image-relative offset of language-specific exception handler.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::setLanguageSpecificHandlerOffset">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 121,
   FQN="llvm::Win64EH::UnwindInfo::setLanguageSpecificHandlerOffset", NM="_ZN4llvm7Win64EH10UnwindInfo32setLanguageSpecificHandlerOffsetEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindInfo32setLanguageSpecificHandlerOffsetEj")
  //</editor-fold>
  public void setLanguageSpecificHandlerOffset(/*uint32_t*/int offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return pointer to exception-specific data.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getExceptionData">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 127,
   FQN="llvm::Win64EH::UnwindInfo::getExceptionData", NM="_ZN4llvm7Win64EH10UnwindInfo16getExceptionDataEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindInfo16getExceptionDataEv")
  //</editor-fold>
  public Object/*void P*/ getExceptionData() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return pointer to chained unwind info.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getChainedFunctionEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 133,
   FQN="llvm::Win64EH::UnwindInfo::getChainedFunctionEntry", NM="_ZN4llvm7Win64EH10UnwindInfo23getChainedFunctionEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH10UnwindInfo23getChainedFunctionEntryEv")
  //</editor-fold>
  public RuntimeFunction /*P*/ getChainedFunctionEntry() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// \brief Return pointer to chained unwind info.
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindInfo::getChainedFunctionEntry">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/Win64EH.h", line = 138,
   FQN="llvm::Win64EH::UnwindInfo::getChainedFunctionEntry", NM="_ZNK4llvm7Win64EH10UnwindInfo23getChainedFunctionEntryEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH10UnwindInfo23getChainedFunctionEntryEv")
  //</editor-fold>
  public /*const*/ RuntimeFunction /*P*/ getChainedFunctionEntry$Const() /*const*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + "VersionAndFlags=" + VersionAndFlags // NOI18N
              + ", PrologSize=" + PrologSize // NOI18N
              + ", NumCodes=" + NumCodes // NOI18N
              + ", FrameRegisterAndOffset=" + FrameRegisterAndOffset // NOI18N
              + ", UnwindCodes=" + UnwindCodes; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 26,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 27,
 FQN="llvm::Win64EH::Instruction", NM="_ZN4llvm7Win64EH11InstructionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11InstructionE")
//</editor-fold>
public static class/*struct*/ Instruction {
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction::PushNonVol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 27,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 28,
   FQN="llvm::Win64EH::Instruction::PushNonVol", NM="_ZN4llvm7Win64EH11Instruction10PushNonVolEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11Instruction10PushNonVolEPNS_8MCSymbolEj")
  //</editor-fold>
  public static WinEH.Instruction PushNonVol(MCSymbol /*P*/ L, /*uint*/int Reg) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction::Alloc">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 30,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 31,
   FQN="llvm::Win64EH::Instruction::Alloc", NM="_ZN4llvm7Win64EH11Instruction5AllocEPNS_8MCSymbolEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11Instruction5AllocEPNS_8MCSymbolEj")
  //</editor-fold>
  public static WinEH.Instruction Alloc(MCSymbol /*P*/ L, /*uint*/int Size) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction::PushMachFrame">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 34,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 35,
   FQN="llvm::Win64EH::Instruction::PushMachFrame", NM="_ZN4llvm7Win64EH11Instruction13PushMachFrameEPNS_8MCSymbolEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11Instruction13PushMachFrameEPNS_8MCSymbolEb")
  //</editor-fold>
  public static WinEH.Instruction PushMachFrame(MCSymbol /*P*/ L, boolean Code) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction::SaveNonVol">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 37,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 38,
   FQN="llvm::Win64EH::Instruction::SaveNonVol", NM="_ZN4llvm7Win64EH11Instruction10SaveNonVolEPNS_8MCSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11Instruction10SaveNonVolEPNS_8MCSymbolEjj")
  //</editor-fold>
  public static WinEH.Instruction SaveNonVol(MCSymbol /*P*/ L, /*uint*/int Reg, 
            /*uint*/int Offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction::SaveXMM">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 43,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 44,
   FQN="llvm::Win64EH::Instruction::SaveXMM", NM="_ZN4llvm7Win64EH11Instruction7SaveXMMEPNS_8MCSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11Instruction7SaveXMMEPNS_8MCSymbolEjj")
  //</editor-fold>
  public static WinEH.Instruction SaveXMM(MCSymbol /*P*/ L, /*uint*/int Reg, 
         /*uint*/int Offset) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::Instruction::SetFPReg">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 49,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 50,
   FQN="llvm::Win64EH::Instruction::SetFPReg", NM="_ZN4llvm7Win64EH11Instruction8SetFPRegEPNS_8MCSymbolEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH11Instruction8SetFPRegEPNS_8MCSymbolEjj")
  //</editor-fold>
  public static WinEH.Instruction SetFPReg(MCSymbol /*P*/ L, /*uint*/int Reg, /*uint*/int Off) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return ""; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindEmitter">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 54,
 old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 55,
 FQN="llvm::Win64EH::UnwindEmitter", NM="_ZN4llvm7Win64EH13UnwindEmitterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH13UnwindEmitterE")
//</editor-fold>
public static class UnwindEmitter extends /*public*/ WinEH.UnwindEmitter implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindEmitter::Emit">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp", line = 221,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp", old_line = 222,
   FQN="llvm::Win64EH::UnwindEmitter::Emit", NM="_ZNK4llvm7Win64EH13UnwindEmitter4EmitERNS_10MCStreamerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH13UnwindEmitter4EmitERNS_10MCStreamerE")
  //</editor-fold>
  @Override public void Emit(MCStreamer /*&*/ Streamer) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindEmitter::EmitUnwindInfo">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp", line = 237,
   old_source = "${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp", old_line = 240,
   FQN="llvm::Win64EH::UnwindEmitter::EmitUnwindInfo", NM="_ZNK4llvm7Win64EH13UnwindEmitter14EmitUnwindInfoERNS_10MCStreamerEPNS_5WinEH9FrameInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZNK4llvm7Win64EH13UnwindEmitter14EmitUnwindInfoERNS_10MCStreamerEPNS_5WinEH9FrameInfoE")
  //</editor-fold>
  @Override public void EmitUnwindInfo(MCStreamer /*&*/ Streamer, WinEH.FrameInfo /*P*/ info) /*const*//* override*/ {
    throw new UnsupportedOperationException("EmptyBody");
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Win64EH::UnwindEmitter::~UnwindEmitter">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", line = 54,
   old_source = "${LLVM_SRC}/llvm/include/llvm/MC/MCWin64EH.h", old_line = 55,
   FQN="llvm::Win64EH::UnwindEmitter::~UnwindEmitter", NM="_ZN4llvm7Win64EH13UnwindEmitterD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/MC/MCWin64EH.cpp -nm=_ZN4llvm7Win64EH13UnwindEmitterD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class Win64EH
