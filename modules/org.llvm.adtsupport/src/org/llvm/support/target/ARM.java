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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.ARMBuildAttrs;
import org.llvm.support.llvm;
import static org.llvm.support.target.impl.TargetParserStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ARM">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10EndianKindE;_ZN4llvm3ARM10FPUVersionE;_ZN4llvm3ARM10getCPUAttrEj;_ZN4llvm3ARM10getFPUNameEj;_ZN4llvm3ARM10getSubArchEj;_ZN4llvm3ARM10parseHWDivENS_9StringRefE;_ZN4llvm3ARM11ArchExtKindE;_ZN4llvm3ARM11ProfileKindE;_ZN4llvm3ARM11getArchAttrEj;_ZN4llvm3ARM11getArchNameEj;_ZN4llvm3ARM12getHWDivNameEj;_ZN4llvm3ARM12parseArchExtENS_9StringRefE;_ZN4llvm3ARM12parseArchISAENS_9StringRefE;_ZN4llvm3ARM12parseCPUArchENS_9StringRefE;_ZN4llvm3ARM13getDefaultCPUENS_9StringRefE;_ZN4llvm3ARM13getDefaultFPUENS_9StringRefEj;_ZN4llvm3ARM13getFPUVersionEj;_ZN4llvm3ARM14FPURestrictionE;_ZN4llvm3ARM14getArchExtNameEj;_ZN4llvm3ARM14getFPUFeaturesEjRSt6vectorIPKcSaIS3_EE;_ZN4llvm3ARM15parseArchEndianENS_9StringRefE;_ZN4llvm3ARM16NeonSupportLevelE;_ZN4llvm3ARM16getHWDivFeaturesEjRSt6vectorIPKcSaIS3_EE;_ZN4llvm3ARM16parseArchProfileENS_9StringRefE;_ZN4llvm3ARM16parseArchVersionENS_9StringRefE;_ZN4llvm3ARM17getArchExtFeatureENS_9StringRefE;_ZN4llvm3ARM17getFPURestrictionEj;_ZN4llvm3ARM20getCanonicalArchNameENS_9StringRefE;_ZN4llvm3ARM20getDefaultExtensionsENS_9StringRefEj;_ZN4llvm3ARM20getExtensionFeaturesEjRSt6vectorIPKcSaIS3_EE;_ZN4llvm3ARM22getFPUNeonSupportLevelEj;_ZN4llvm3ARM5WinEHE;_ZN4llvm3ARM7FPUKindE;_ZN4llvm3ARM7ISAKindE;_ZN4llvm3ARM8ArchKindE;_ZN4llvm3ARM8parseFPUENS_9StringRefE;_ZN4llvm3ARM9parseArchENS_9StringRefE; -static-type=ARM -package=org.llvm.support")
//</editor-fold>
public final class ARM {

//JAVA: namespace WinEH {
public static final class WinEH {
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunctionFlag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 19,
   FQN="llvm::ARM::WinEH::RuntimeFunctionFlag", NM="_ZN4llvm3ARM5WinEH19RuntimeFunctionFlagE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH19RuntimeFunctionFlagE")
  //</editor-fold>
  public enum /*class */RuntimeFunctionFlag/* : int*/ implements Native.ComparableLower {
    RFF_Unpacked(0), /// unpacked entry
    RFF_Packed(RFF_Unpacked.getValue() + 1), /// packed entry
    RFF_PackedFragment(RFF_Packed.getValue() + 1), /// packed entry representing a fragment
    RFF_Reserved(RFF_PackedFragment.getValue() + 1); /// reserved

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static RuntimeFunctionFlag valueOf(int val) {
      RuntimeFunctionFlag out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final RuntimeFunctionFlag[] VALUES;
      private static final RuntimeFunctionFlag[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (RuntimeFunctionFlag kind : RuntimeFunctionFlag.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new RuntimeFunctionFlag[min < 0 ? (1-min) : 0];
        VALUES = new RuntimeFunctionFlag[max >= 0 ? (1+max) : 0];
        for (RuntimeFunctionFlag kind : RuntimeFunctionFlag.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private RuntimeFunctionFlag(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((RuntimeFunctionFlag)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((RuntimeFunctionFlag)obj).value);}
    //</editor-fold>
  }
  
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ReturnType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 26,
   FQN="llvm::ARM::WinEH::ReturnType", NM="_ZN4llvm3ARM5WinEH10ReturnTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH10ReturnTypeE")
  //</editor-fold>
  public enum /*class */ReturnType/* : int*/ implements Native.ComparableLower {
    RT_POP(0), /// return via pop {pc} (L flag must be set)
    RT_B(RT_POP.getValue() + 1), /// 16-bit branch
    RT_BW(RT_B.getValue() + 1), /// 32-bit branch
    RT_NoEpilogue(RT_BW.getValue() + 1); /// no epilogue (fragment)

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ReturnType valueOf(int val) {
      ReturnType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ReturnType[] VALUES;
      private static final ReturnType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ReturnType kind : ReturnType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ReturnType[min < 0 ? (1-min) : 0];
        VALUES = new ReturnType[max >= 0 ? (1+max) : 0];
        for (ReturnType kind : ReturnType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final int value;
    private ReturnType(int val) { this.value = (int)val;}
    public int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((ReturnType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((ReturnType)obj).value);}
    //</editor-fold>
  }
  
  /// RuntimeFunction - An entry in the table of procedure data (.pdata)
  ///
  ///  3 3 2 2 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0
  ///  1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0
  /// +---------------------------------------------------------------+
  /// |                     Function Start RVA                        |
  /// +-------------------+-+-+-+-----+-+---+---------------------+---+
  /// |    Stack Adjust   |C|L|R| Reg |H|Ret|   Function Length   |Flg|
  /// +-------------------+-+-+-+-----+-+---+---------------------+---+
  ///
  /// Flag : 2-bit field with the following meanings:
  ///   - 00 = packed unwind data not used; reamining bits point to .xdata record
  ///   - 01 = packed unwind data
  ///   - 10 = packed unwind data, function assumed to have no prologue; useful
  ///          for function fragments that are discontiguous with the start of the
  ///          function
  ///   - 11 = reserved
  /// Function Length : 11-bit field providing the length of the entire function
  ///                   in bytes, divided by 2; if the function is greater than
  ///                   4KB, a full .xdata record must be used instead
  /// Ret : 2-bit field indicating how the function returns
  ///   - 00 = return via pop {pc} (the L bit must be set)
  ///   - 01 = return via 16-bit branch
  ///   - 10 = return via 32-bit branch
  ///   - 11 = no epilogue; useful for function fragments that may only contain a
  ///          prologue but the epilogue is elsewhere
  /// H : 1-bit flag indicating whether the function "homes" the integer parameter
  ///     registers (r0-r3), allocating 16-bytes on the stack
  /// Reg : 3-bit field indicating the index of the last saved non-volatile
  ///       register.  If the R bit is set to 0, then only integer registers are
  ///       saved (r4-rN, where N is 4 + Reg).  If the R bit is set to 1, then
  ///       only floating-point registers are being saved (d8-dN, where N is
  ///       8 + Reg).  The special case of the R bit being set to 1 and Reg equal
  ///       to 7 indicates that no registers are saved.
  /// R : 1-bit flag indicating whether the non-volatile registers are integer or
  ///     floating-point.  0 indicates integer, 1 indicates floating-point.  The
  ///     special case of the R-flag being set and Reg being set to 7 indicates
  ///     that no non-volatile registers are saved.
  /// L : 1-bit flag indicating whether the function saves/restores the link
  ///     register (LR)
  /// C : 1-bit flag indicating whether the function includes extra instructions
  ///     to setup a frame chain for fast walking.  If this flag is set, r11 is
  ///     implicitly added to the list of saved non-volatile integer registers.
  /// Stack Adjust : 10-bit field indicating the number of bytes of stack that are
  ///                allocated for this function.  Only values between 0x000 and
  ///                0x3f3 can be directly encoded.  If the value is 0x3f4 or
  ///                greater, then the low 4 bits have special meaning as follows:
  ///                - Bit 0-1
  ///                  indicate the number of words' of adjustment (1-4), minus 1
  ///                - Bit 2
  ///                  indicates if the prologue combined adjustment into push
  ///                - Bit 3
  ///                  indicates if the epilogue combined adjustment into pop
  ///
  /// RESTRICTIONS:
  ///   - IF C is SET:
  ///     + L flag must be set since frame chaining requires r11 and lr
  ///     + r11 must NOT be included in the set of registers described by Reg
  ///   - IF Ret is 0:
  ///     + L flag must be set
  
  // NOTE: RuntimeFunction is meant to be a simple class that provides raw access
  // to all fields in the structure.  The accessor methods reflect the names of
  // the bitfields that they correspond to.  Although some obvious simplifications
  // are possible via merging of methods, it would prevent the use of this class
  // to fully inspect the contents of the data structure which is particularly
  // useful for scenarios such as llvm-readobj to aid in testing.
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 101,
   FQN="llvm::ARM::WinEH::RuntimeFunction", NM="_ZN4llvm3ARM5WinEH15RuntimeFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH15RuntimeFunctionE")
  //</editor-fold>
  public static class RuntimeFunction {
  /*public:*/
    public /*const*/llvm.support.ulittle32_t BeginAddress;
    public /*const*/llvm.support.ulittle32_t UnwindData;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::RuntimeFunction">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 106,
     FQN="llvm::ARM::WinEH::RuntimeFunction::RuntimeFunction", NM="_ZN4llvm3ARM5WinEH15RuntimeFunctionC1EPKNS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH15RuntimeFunctionC1EPKNS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEE")
    //</editor-fold>
    public RuntimeFunction(/*const*/llvm.support.ulittle32_t/*P*/ Data) {
      // : BeginAddress(Data[0]), UnwindData(Data[1]) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::RuntimeFunction">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 109,
     FQN="llvm::ARM::WinEH::RuntimeFunction::RuntimeFunction", NM="_ZN4llvm3ARM5WinEH15RuntimeFunctionC1ENS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEES7_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH15RuntimeFunctionC1ENS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEES7_")
    //</editor-fold>
    public RuntimeFunction(/*const*/llvm.support.ulittle32_t BeginAddress, 
        /*const*/llvm.support.ulittle32_t UnwindData) {
      // : BeginAddress(BeginAddress), UnwindData(UnwindData) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::Flag">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 113,
     FQN="llvm::ARM::WinEH::RuntimeFunction::Flag", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction4FlagEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction4FlagEv")
    //</editor-fold>
    public RuntimeFunctionFlag Flag() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::ExceptionInformationRVA">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 117,
     FQN="llvm::ARM::WinEH::RuntimeFunction::ExceptionInformationRVA", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction23ExceptionInformationRVAEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction23ExceptionInformationRVAEv")
    //</editor-fold>
    public /*uint32_t*/int ExceptionInformationRVA() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::PackedUnwindData">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 123,
     FQN="llvm::ARM::WinEH::RuntimeFunction::PackedUnwindData", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction16PackedUnwindDataEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction16PackedUnwindDataEv")
    //</editor-fold>
    public /*uint32_t*/int PackedUnwindData() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::FunctionLength">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 129,
     FQN="llvm::ARM::WinEH::RuntimeFunction::FunctionLength", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction14FunctionLengthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction14FunctionLengthEv")
    //</editor-fold>
    public /*uint32_t*/int FunctionLength() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::Ret">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 135,
     FQN="llvm::ARM::WinEH::RuntimeFunction::Ret", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction3RetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction3RetEv")
    //</editor-fold>
    public ReturnType Ret() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::H">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 142,
     FQN="llvm::ARM::WinEH::RuntimeFunction::H", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction1HEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction1HEv")
    //</editor-fold>
    public boolean H() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::Reg">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 148,
     FQN="llvm::ARM::WinEH::RuntimeFunction::Reg", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction3RegEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction3RegEv")
    //</editor-fold>
    public byte/*uint8_t*/ Reg() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::R">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 154,
     FQN="llvm::ARM::WinEH::RuntimeFunction::R", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction1REv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction1REv")
    //</editor-fold>
    public boolean R() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::L">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 160,
     FQN="llvm::ARM::WinEH::RuntimeFunction::L", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction1LEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction1LEv")
    //</editor-fold>
    public boolean L() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::C">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 166,
     FQN="llvm::ARM::WinEH::RuntimeFunction::C", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction1CEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction1CEv")
    //</editor-fold>
    public boolean C() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::RuntimeFunction::StackAdjust">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 176,
     FQN="llvm::ARM::WinEH::RuntimeFunction::StackAdjust", NM="_ZNK4llvm3ARM5WinEH15RuntimeFunction11StackAdjustEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH15RuntimeFunction11StackAdjustEv")
    //</editor-fold>
    public /*uint16_t*/char StackAdjust() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "BeginAddress=" + BeginAddress // NOI18N
                + ", UnwindData=" + UnwindData; // NOI18N
    }
  }
  
  /// PrologueFolding - pseudo-flag derived from Stack Adjust indicating that the
  /// prologue has stack adjustment combined into the push
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::PrologueFolding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 186,
   FQN="llvm::ARM::WinEH::PrologueFolding", NM="_ZN4llvm3ARM5WinEH15PrologueFoldingERKNS1_15RuntimeFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH15PrologueFoldingERKNS1_15RuntimeFunctionE")
  //</editor-fold>
  public static /*inline*/ boolean PrologueFolding(/*const*/ RuntimeFunction /*&*/ RF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// Epilogue - pseudo-flag derived from Stack Adjust indicating that the
  /// epilogue has stack adjustment combined into the pop
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueFolding">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 191,
   FQN="llvm::ARM::WinEH::EpilogueFolding", NM="_ZN4llvm3ARM5WinEH15EpilogueFoldingERKNS1_15RuntimeFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH15EpilogueFoldingERKNS1_15RuntimeFunctionE")
  //</editor-fold>
  public static /*inline*/ boolean EpilogueFolding(/*const*/ RuntimeFunction /*&*/ RF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  /// StackAdjustment - calculated stack adjustment in words.  The stack
  /// adjustment should be determined via this function to account for the special
  /// handling the special encoding when the value is >= 0x3f4.
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::StackAdjustment">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 197,
   FQN="llvm::ARM::WinEH::StackAdjustment", NM="_ZN4llvm3ARM5WinEH15StackAdjustmentERKNS1_15RuntimeFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH15StackAdjustmentERKNS1_15RuntimeFunctionE")
  //</editor-fold>
  public static /*inline*/ /*uint16_t*/char StackAdjustment(/*const*/ RuntimeFunction /*&*/ RF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// SavedRegisterMask - Utility function to calculate the set of saved general
  /// purpose (r0-r15) and VFP (d0-d31) registers.
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::SavedRegisterMask">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp", line = 16,
   FQN="llvm::ARM::WinEH::SavedRegisterMask", NM="_ZN4llvm3ARM5WinEH17SavedRegisterMaskERKNS1_15RuntimeFunctionE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH17SavedRegisterMaskERKNS1_15RuntimeFunctionE")
  //</editor-fold>
  public static std.pairUShortUInt SavedRegisterMask(/*const*/ RuntimeFunction /*&*/ RF) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  /// ExceptionDataRecord - An entry in the table of exception data (.xdata)
  ///
  ///  3 3 2 2 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0
  ///  1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0
  /// +-------+---------+-+-+-+---+-----------------------------------+
  /// | C Wrd | Epi Cnt |F|E|X|Ver|         Function Length           |
  /// +-------+--------+'-'-'-'---'---+-------------------------------+
  /// |    Reserved    |Ex. Code Words|   (Extended Epilogue Count)   |
  /// +-------+--------+--------------+-------------------------------+
  ///
  /// Function Length : 18-bit field indicating the total length of the function
  ///                   in bytes divided by 2.  If a function is larger than
  ///                   512KB, then multiple pdata and xdata records must be used.
  /// Vers : 2-bit field describing the version of the remaining structure.  Only
  ///        version 0 is currently defined (values 1-3 are not permitted).
  /// X : 1-bit field indicating the presence of exception data
  /// E : 1-bit field indicating that the single epilogue is packed into the
  ///     header
  /// F : 1-bit field indicating that the record describes a function fragment
  ///     (implies that no prologue is present, and prologue processing should be
  ///     skipped)
  /// Epilogue Count : 5-bit field that differs in meaning based on the E field.
  ///
  ///                  If E is set, then this field specifies the index of the
  ///                  first unwind code describing the (only) epilogue.
  ///
  ///                  Otherwise, this field indicates the number of exception
  ///                  scopes.  If more than 31 scopes exist, then this field and
  ///                  the Code Words field must both be set to 0 to indicate that
  ///                  an extension word is required.
  /// Code Words : 4-bit field that species the number of 32-bit words needed to
  ///              contain all the unwind codes.  If more than 15 words (63 code
  ///              bytes) are required, then this field and the Epilogue Count
  ///              field must both be set to 0 to indicate that an extension word
  ///              is required.
  /// Extended Epilogue Count, Extended Code Words :
  ///                          Valid only if Epilog Count and Code Words are both
  ///                          set to 0.  Provides an 8-bit extended code word
  ///                          count and 16-bits for epilogue count
  ///
  ///  3 3 2 2 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0
  ///  1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0
  /// +----------------+------+---+---+-------------------------------+
  /// |  Ep Start Idx  | Cond |Res|       Epilogue Start Offset       |
  /// +----------------+------+---+-----------------------------------+
  ///
  /// If the E bit is unset in the header, the header is followed by a series of
  /// epilogue scopes, which are sorted by their offset.
  ///
  /// Epilogue Start Offset: 18-bit field encoding the offset of epilogue relative
  ///                        to the start of the function in bytes divided by two
  /// Res : 2-bit field reserved for future expansion (must be set to 0)
  /// Condition : 4-bit field providing the condition under which the epilogue is
  ///             executed.  Unconditional epilogues should set this field to 0xe.
  ///             Epilogues must be entirely conditional or unconditional, and in
  ///             Thumb-2 mode.  The epilogue beings with the first instruction
  ///             after the IT opcode.
  /// Epilogue Start Index : 8-bit field indicating the byte index of the first
  ///                        unwind code describing the epilogue
  ///
  ///  3 3 2 2 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0
  ///  1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0
  /// +---------------+---------------+---------------+---------------+
  /// | Unwind Code 3 | Unwind Code 2 | Unwind Code 1 | Unwind Code 0 |
  /// +---------------+---------------+---------------+---------------+
  ///
  /// Following the epilogue scopes, the byte code describing the unwinding
  /// follows.  This is padded to align up to word alignment.  Bytes are stored in
  /// little endian.
  ///
  ///  3 3 2 2 2 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 0 0 0 0 0 0 0 0 0 0
  ///  1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0 9 8 7 6 5 4 3 2 1 0
  /// +---------------------------------------------------------------+
  /// |           Exception Handler RVA (requires X = 1)              |
  /// +---------------------------------------------------------------+
  /// |  (possibly followed by data required for exception handler)   |
  /// +---------------------------------------------------------------+
  ///
  /// If the X bit is set in the header, the unwind byte code is followed by the
  /// exception handler information.  This constants of one Exception Handler RVA
  /// which is the address to the exception handler, followed immediately by the
  /// variable length data associated with the exception handler.
  ///
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueScope">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 292,
   FQN="llvm::ARM::WinEH::EpilogueScope", NM="_ZN4llvm3ARM5WinEH13EpilogueScopeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH13EpilogueScopeE")
  //</editor-fold>
  public static class/*struct*/ EpilogueScope {
    public /*const*/llvm.support.ulittle32_t ES;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueScope::EpilogueScope">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 295,
     FQN="llvm::ARM::WinEH::EpilogueScope::EpilogueScope", NM="_ZN4llvm3ARM5WinEH13EpilogueScopeC1ENS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH13EpilogueScopeC1ENS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEE")
    //</editor-fold>
    public EpilogueScope(/*const*/llvm.support.ulittle32_t Data) {
      // : ES(Data) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueScope::EpilogueStartOffset">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 296,
     FQN="llvm::ARM::WinEH::EpilogueScope::EpilogueStartOffset", NM="_ZNK4llvm3ARM5WinEH13EpilogueScope19EpilogueStartOffsetEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH13EpilogueScope19EpilogueStartOffsetEv")
    //</editor-fold>
    public /*uint32_t*/int EpilogueStartOffset() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueScope::Res">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 299,
     FQN="llvm::ARM::WinEH::EpilogueScope::Res", NM="_ZNK4llvm3ARM5WinEH13EpilogueScope3ResEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH13EpilogueScope3ResEv")
    //</editor-fold>
    public byte/*uint8_t*/ Res() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueScope::Condition">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 302,
     FQN="llvm::ARM::WinEH::EpilogueScope::Condition", NM="_ZNK4llvm3ARM5WinEH13EpilogueScope9ConditionEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH13EpilogueScope9ConditionEv")
    //</editor-fold>
    public byte/*uint8_t*/ Condition() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::EpilogueScope::EpilogueStartIndex">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 305,
     FQN="llvm::ARM::WinEH::EpilogueScope::EpilogueStartIndex", NM="_ZNK4llvm3ARM5WinEH13EpilogueScope18EpilogueStartIndexEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH13EpilogueScope18EpilogueStartIndexEv")
    //</editor-fold>
    public byte/*uint8_t*/ EpilogueStartIndex() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "ES=" + ES; // NOI18N
    }
  }
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::HeaderWords">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 375,
   FQN="llvm::ARM::WinEH::HeaderWords", NM="_ZN4llvm3ARM5WinEH11HeaderWordsERKNS1_19ExceptionDataRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH11HeaderWordsERKNS1_19ExceptionDataRecordE")
  //</editor-fold>
  public static /*inline*/ /*size_t*/int HeaderWords(/*const*/ ExceptionDataRecord /*&*/ XR) {
    throw new UnsupportedOperationException("EmptyBody");
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord">
  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 313,
   FQN="llvm::ARM::WinEH::ExceptionDataRecord", NM="_ZN4llvm3ARM5WinEH19ExceptionDataRecordE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH19ExceptionDataRecordE")
  //</editor-fold>
  public static class/*struct*/ ExceptionDataRecord {
    public /*const*/llvm.support.ulittle32_t/*P*/ Data;
    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::ExceptionDataRecord">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 316,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::ExceptionDataRecord", NM="_ZN4llvm3ARM5WinEH19ExceptionDataRecordC1EPKNS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH19ExceptionDataRecordC1EPKNS_7support6detail31packed_endian_specific_integralIjLNS3_10endiannessE1ELj1EEE")
    //</editor-fold>
    public ExceptionDataRecord(/*const*/llvm.support.ulittle32_t/*P*/ Data) {
      // : Data(Data) 
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::FunctionLength">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 318,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::FunctionLength", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord14FunctionLengthEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord14FunctionLengthEv")
    //</editor-fold>
    public /*uint32_t*/int FunctionLength() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::Vers">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 322,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::Vers", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord4VersEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord4VersEv")
    //</editor-fold>
    public byte/*uint8_t*/ Vers() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::X">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 326,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::X", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord1XEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord1XEv")
    //</editor-fold>
    public boolean X() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::E">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 330,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::E", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord1EEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord1EEv")
    //</editor-fold>
    public boolean E() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::F">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 334,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::F", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord1FEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord1FEv")
    //</editor-fold>
    public boolean F() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::EpilogueCount">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 338,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::EpilogueCount", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord13EpilogueCountEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord13EpilogueCountEv")
    //</editor-fold>
    public byte/*uint8_t*/ EpilogueCount() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::CodeWords">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 344,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::CodeWords", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord9CodeWordsEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord9CodeWordsEv")
    //</editor-fold>
    public byte/*uint8_t*/ CodeWords() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::EpilogueScopes">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 350,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::EpilogueScopes", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord14EpilogueScopesEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord14EpilogueScopesEv")
    //</editor-fold>
    public ArrayRef<llvm.support.ulittle32_t> EpilogueScopes() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::UnwindByteCode">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 356,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::UnwindByteCode", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord14UnwindByteCodeEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord14UnwindByteCodeEv")
    //</editor-fold>
    public ArrayRefUChar UnwindByteCode() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::ExceptionHandlerRVA">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 364,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::ExceptionHandlerRVA", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord19ExceptionHandlerRVAEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord19ExceptionHandlerRVAEv")
    //</editor-fold>
    public /*uint32_t*/int ExceptionHandlerRVA() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::ExceptionDataRecord::ExceptionHandlerParameter">
    @Converted(kind = Converted.Kind.AUTO_NO_BODY,
     source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 369,
     FQN="llvm::ARM::WinEH::ExceptionDataRecord::ExceptionHandlerParameter", NM="_ZNK4llvm3ARM5WinEH19ExceptionDataRecord25ExceptionHandlerParameterEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZNK4llvm3ARM5WinEH19ExceptionDataRecord25ExceptionHandlerParameterEv")
    //</editor-fold>
    public /*uint32_t*/int ExceptionHandlerParameter() /*const*/ {
      throw new UnsupportedOperationException("EmptyBody");
    }

    
    @Override public String toString() {
      return "" + "Data=" + Data; // NOI18N
    }
  }
  
//  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::HeaderWords">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMWinEH.h", line = 375,
//   FQN="llvm::ARM::WinEH::HeaderWords", NM="_ZN4llvm3ARM5WinEH11HeaderWordsERKNS1_19ExceptionDataRecordE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH11HeaderWordsERKNS1_19ExceptionDataRecordE")
//  //</editor-fold>
//  public static /*inline*/ /*size_t*/int HeaderWords(/*const*/ ExceptionDataRecord /*&*/ XR) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }
//

//}
//} JAVA: end of namespace WinEH
//JAVA: namespace WinEH {
//public static final class WinEH {
//  //<editor-fold defaultstate="collapsed" desc="llvm::ARM::WinEH::SavedRegisterMask">
//  @Converted(kind = Converted.Kind.AUTO_NO_BODY,
//   source = "${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp", line = 16,
//   FQN="llvm::ARM::WinEH::SavedRegisterMask", NM="_ZN4llvm3ARM5WinEH17SavedRegisterMaskERKNS1_15RuntimeFunctionE",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMWinEH.cpp -nm=_ZN4llvm3ARM5WinEH17SavedRegisterMaskERKNS1_15RuntimeFunctionE")
//  //</editor-fold>
//  public static std.pairUShortUInt SavedRegisterMask(/*const*/ RuntimeFunction /*&*/ RF) {
//    throw new UnsupportedOperationException("EmptyBody");
//  }


}
//} JAVA: end of namespace WinEH

// FPU names.
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::FPUKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 34,
 FQN="llvm::ARM::FPUKind", NM="_ZN4llvm3ARM7FPUKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM7FPUKindE")
//</editor-fold>
public enum FPUKind implements Native.ComparableLower {
  FK_INVALID(0),
  FK_NONE(FK_INVALID.getValue() + 1),
  FK_VFP(FK_NONE.getValue() + 1),
  FK_VFPV2(FK_VFP.getValue() + 1),
  FK_VFPV3(FK_VFPV2.getValue() + 1),
  FK_VFPV3_FP16(FK_VFPV3.getValue() + 1),
  FK_VFPV3_D16(FK_VFPV3_FP16.getValue() + 1),
  FK_VFPV3_D16_FP16(FK_VFPV3_D16.getValue() + 1),
  FK_VFPV3XD(FK_VFPV3_D16_FP16.getValue() + 1),
  FK_VFPV3XD_FP16(FK_VFPV3XD.getValue() + 1),
  FK_VFPV4(FK_VFPV3XD_FP16.getValue() + 1),
  FK_VFPV4_D16(FK_VFPV4.getValue() + 1),
  FK_FPV4_SP_D16(FK_VFPV4_D16.getValue() + 1),
  FK_FPV5_D16(FK_FPV4_SP_D16.getValue() + 1),
  FK_FPV5_SP_D16(FK_FPV5_D16.getValue() + 1),
  FK_FP_ARMV8(FK_FPV5_SP_D16.getValue() + 1),
  FK_NEON(FK_FP_ARMV8.getValue() + 1),
  FK_NEON_FP16(FK_NEON.getValue() + 1),
  FK_NEON_VFPV4(FK_NEON_FP16.getValue() + 1),
  FK_NEON_FP_ARMV8(FK_NEON_VFPV4.getValue() + 1),
  FK_CRYPTO_NEON_FP_ARMV8(FK_NEON_FP_ARMV8.getValue() + 1),
  FK_SOFTVFP(FK_CRYPTO_NEON_FP_ARMV8.getValue() + 1),
  FK_LAST(FK_SOFTVFP.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FPUKind valueOf(int val) {
    FPUKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FPUKind[] VALUES;
    private static final FPUKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FPUKind kind : FPUKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FPUKind[min < 0 ? (1-min) : 0];
      VALUES = new FPUKind[max >= 0 ? (1+max) : 0];
      for (FPUKind kind : FPUKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private FPUKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FPUKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FPUKind)obj).value);}
  //</editor-fold>
}

// FPU Version
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::FPUVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 41,
 FQN="llvm::ARM::FPUVersion", NM="_ZN4llvm3ARM10FPUVersionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10FPUVersionE")
//</editor-fold>
public enum FPUVersion implements Native.ComparableLower {
  FV_NONE(0),
  FV_VFPV2(FV_NONE.getValue() + 1),
  FV_VFPV3(FV_VFPV2.getValue() + 1),
  FV_VFPV3_FP16(FV_VFPV3.getValue() + 1),
  FV_VFPV4(FV_VFPV3_FP16.getValue() + 1),
  FV_VFPV5(FV_VFPV4.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FPUVersion valueOf(int val) {
    FPUVersion out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FPUVersion[] VALUES;
    private static final FPUVersion[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FPUVersion kind : FPUVersion.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FPUVersion[min < 0 ? (1-min) : 0];
      VALUES = new FPUVersion[max >= 0 ? (1+max) : 0];
      for (FPUVersion kind : FPUVersion.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private FPUVersion(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FPUVersion)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FPUVersion)obj).value);}
  //</editor-fold>
}

// An FPU name implies one of three levels of Neon support:
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::NeonSupportLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 51,
 FQN="llvm::ARM::NeonSupportLevel", NM="_ZN4llvm3ARM16NeonSupportLevelE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM16NeonSupportLevelE")
//</editor-fold>
public enum NeonSupportLevel implements Native.ComparableLower {
  NS_None(0), ///< No Neon
  NS_Neon(NS_None.getValue() + 1), ///< Neon
  NS_Crypto(NS_Neon.getValue() + 1); ///< Neon with Crypto

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static NeonSupportLevel valueOf(int val) {
    NeonSupportLevel out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final NeonSupportLevel[] VALUES;
    private static final NeonSupportLevel[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (NeonSupportLevel kind : NeonSupportLevel.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new NeonSupportLevel[min < 0 ? (1-min) : 0];
      VALUES = new NeonSupportLevel[max >= 0 ? (1+max) : 0];
      for (NeonSupportLevel kind : NeonSupportLevel.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private NeonSupportLevel(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NeonSupportLevel)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NeonSupportLevel)obj).value);}
  //</editor-fold>
}

// An FPU name restricts the FPU in one of three ways:
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::FPURestriction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 58,
 FQN="llvm::ARM::FPURestriction", NM="_ZN4llvm3ARM14FPURestrictionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM14FPURestrictionE")
//</editor-fold>
public enum FPURestriction implements Native.ComparableLower {
  FR_None(0), ///< No restriction
  FR_D16(FR_None.getValue() + 1), ///< Only 16 D registers
  FR_SP_D16(FR_D16.getValue() + 1); ///< Only single-precision instructions, with 16 D registers

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FPURestriction valueOf(int val) {
    FPURestriction out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FPURestriction[] VALUES;
    private static final FPURestriction[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FPURestriction kind : FPURestriction.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FPURestriction[min < 0 ? (1-min) : 0];
      VALUES = new FPURestriction[max >= 0 ? (1+max) : 0];
      for (FPURestriction kind : FPURestriction.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private FPURestriction(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FPURestriction)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FPURestriction)obj).value);}
  //</editor-fold>
}

// Arch names.
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::ArchKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 65,
 FQN="llvm::ARM::ArchKind", NM="_ZN4llvm3ARM8ArchKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM8ArchKindE")
//</editor-fold>
public enum ArchKind implements Native.ComparableLower {
  AK_INVALID(0),
  AK_ARMV2(AK_INVALID.getValue() + 1),
  AK_ARMV2A(AK_ARMV2.getValue() + 1),
  AK_ARMV3(AK_ARMV2A.getValue() + 1),
  AK_ARMV3M(AK_ARMV3.getValue() + 1),
  AK_ARMV4(AK_ARMV3M.getValue() + 1),
  AK_ARMV4T(AK_ARMV4.getValue() + 1),
  AK_ARMV5T(AK_ARMV4T.getValue() + 1),
  AK_ARMV5TE(AK_ARMV5T.getValue() + 1),
  AK_ARMV5TEJ(AK_ARMV5TE.getValue() + 1),
  AK_ARMV6(AK_ARMV5TEJ.getValue() + 1),
  AK_ARMV6K(AK_ARMV6.getValue() + 1),
  AK_ARMV6T2(AK_ARMV6K.getValue() + 1),
  AK_ARMV6KZ(AK_ARMV6T2.getValue() + 1),
  AK_ARMV6M(AK_ARMV6KZ.getValue() + 1),
  AK_ARMV7A(AK_ARMV6M.getValue() + 1),
  AK_ARMV7R(AK_ARMV7A.getValue() + 1),
  AK_ARMV7M(AK_ARMV7R.getValue() + 1),
  AK_ARMV7EM(AK_ARMV7M.getValue() + 1),
  AK_ARMV8A(AK_ARMV7EM.getValue() + 1),
  AK_ARMV8_1A(AK_ARMV8A.getValue() + 1),
  AK_ARMV8_2A(AK_ARMV8_1A.getValue() + 1),
  AK_ARMV8MBaseline(AK_ARMV8_2A.getValue() + 1),
  AK_ARMV8MMainline(AK_ARMV8MBaseline.getValue() + 1),
  // Non-standard Arch names.
  AK_IWMMXT(AK_ARMV8MMainline.getValue() + 1),
  AK_IWMMXT2(AK_IWMMXT.getValue() + 1),
  AK_XSCALE(AK_IWMMXT2.getValue() + 1),
  AK_ARMV7S(AK_XSCALE.getValue() + 1),
  AK_ARMV7K(AK_ARMV7S.getValue() + 1),
  AK_LAST(AK_ARMV7K.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ArchKind valueOf(int val) {
    ArchKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ArchKind[] VALUES;
    private static final ArchKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ArchKind kind : ArchKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ArchKind[min < 0 ? (1-min) : 0];
      VALUES = new ArchKind[max >= 0 ? (1+max) : 0];
      for (ArchKind kind : ArchKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ArchKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ArchKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ArchKind)obj).value);}
  //</editor-fold>
}

// Arch extension modifiers for CPUs.
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::ArchExtKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 72,
 FQN="llvm::ARM::ArchExtKind", NM="_ZN4llvm3ARM11ArchExtKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM11ArchExtKindE")
//</editor-fold>
public static final class/*enum*/ ArchExtKind/* : unsigned int*/ {
  public static final /*uint*/int AEK_INVALID = 0x0;
  public static final /*uint*/int AEK_NONE = 0x1;
  public static final /*uint*/int AEK_CRC = 0x2;
  public static final /*uint*/int AEK_CRYPTO = 0x4;
  public static final /*uint*/int AEK_FP = 0x8;
  public static final /*uint*/int AEK_HWDIV = 0x10;
  public static final /*uint*/int AEK_HWDIVARM = 0x20;
  public static final /*uint*/int AEK_MP = 0x40;
  public static final /*uint*/int AEK_SIMD = 0x80;
  public static final /*uint*/int AEK_SEC = 0x100;
  public static final /*uint*/int AEK_VIRT = 0x200;
  public static final /*uint*/int AEK_DSP = 0x400;
  public static final /*uint*/int AEK_FP16 = 0x800;
  public static final /*uint*/int AEK_RAS = 0x1000;
  // Unsupported extensions.
  public static final /*uint*/int AEK_OS = 0x8000000;
  public static final /*uint*/int AEK_IWMMXT = 0x10000000;
  public static final /*uint*/int AEK_IWMMXT2 = 0x20000000;
  public static final /*uint*/int AEK_MAVERICK = 0x40000000;
  public static final /*uint*/int AEK_XSCALE = 0x80000000/*U*/;
}

// ISA kinds.
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::ISAKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 96,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", old_line = 95,
 FQN="llvm::ARM::ISAKind", NM="_ZN4llvm3ARM7ISAKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM7ISAKindE")
//</editor-fold>
public enum ISAKind implements Native.ComparableLower {
  IK_INVALID(0),
  IK_ARM(IK_INVALID.getValue() + 1),
  IK_THUMB(IK_ARM.getValue() + 1),
  IK_AARCH64(IK_THUMB.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ISAKind valueOf(int val) {
    ISAKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ISAKind[] VALUES;
    private static final ISAKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ISAKind kind : ISAKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ISAKind[min < 0 ? (1-min) : 0];
      VALUES = new ISAKind[max >= 0 ? (1+max) : 0];
      for (ISAKind kind : ISAKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ISAKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ISAKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ISAKind)obj).value);}
  //</editor-fold>
}

// Endianness
// FIXME: BE8 vs. BE32?
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::EndianKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 100,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", old_line = 99,
 FQN="llvm::ARM::EndianKind", NM="_ZN4llvm3ARM10EndianKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10EndianKindE")
//</editor-fold>
public enum EndianKind implements Native.ComparableLower {
  EK_INVALID(0),
  EK_LITTLE(EK_INVALID.getValue() + 1),
  EK_BIG(EK_LITTLE.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static EndianKind valueOf(int val) {
    EndianKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final EndianKind[] VALUES;
    private static final EndianKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (EndianKind kind : EndianKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new EndianKind[min < 0 ? (1-min) : 0];
      VALUES = new EndianKind[max >= 0 ? (1+max) : 0];
      for (EndianKind kind : EndianKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private EndianKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EndianKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EndianKind)obj).value);}
  //</editor-fold>
}

// v6/v7/v8 Profile
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::ProfileKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 103,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", old_line = 102,
 FQN="llvm::ARM::ProfileKind", NM="_ZN4llvm3ARM11ProfileKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM11ProfileKindE")
//</editor-fold>
public enum ProfileKind implements Native.ComparableLower {
  PK_INVALID(0),
  PK_A(PK_INVALID.getValue() + 1),
  PK_R(PK_A.getValue() + 1),
  PK_M(PK_R.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static ProfileKind valueOf(int val) {
    ProfileKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final ProfileKind[] VALUES;
    private static final ProfileKind[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (ProfileKind kind : ProfileKind.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new ProfileKind[min < 0 ? (1-min) : 0];
      VALUES = new ProfileKind[max >= 0 ? (1+max) : 0];
      for (ProfileKind kind : ProfileKind.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private ProfileKind(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ProfileKind)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ProfileKind)obj).value);}
  //</editor-fold>
}

// MArch is expected to be of the form (arm|thumb)?(eb)?(v.+)?(eb)?, but
// (iwmmxt|xscale)(eb)? is also permitted. If the former, return
// "v.+", if the latter, return unmodified string, minus 'eb'.
// If invalid, return empty string.
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getCanonicalArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 587,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 421,
 FQN="llvm::ARM::getCanonicalArchName", NM="_ZN4llvm3ARM20getCanonicalArchNameENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM20getCanonicalArchNameENS_9StringRefE")
//</editor-fold>
public static StringRef getCanonicalArchName(StringRef Arch) {
  /*size_t*/int offset = StringRef.npos;
  StringRef A = new StringRef(Arch);
  StringRef Error = new StringRef(/*KEEP_STR*/$EMPTY);
  
  // Begins with "arm" / "thumb", move past it.
  if (A.startswith(/*STRINGREF_STR*/"arm64")) {
    offset = 5;
  } else if (A.startswith(/*STRINGREF_STR*/"arm")) {
    offset = 3;
  } else if (A.startswith(/*STRINGREF_STR*/"thumb")) {
    offset = 5;
  } else if (A.startswith(/*STRINGREF_STR*/"aarch64")) {
    offset = 7;
    // AArch64 uses "_be", not "eb" suffix.
    if (A.find(/*STRINGREF_STR*/"eb") != StringRef.npos) {
      return Error;
    }
    if ($eq_StringRef(A.substr(offset, 3), /*STRINGREF_STR*/"_be")) {
      offset += 3;
    }
  }
  
  // Ex. "armebv7", move past the "eb".
  if (offset != StringRef.npos && $eq_StringRef(A.substr(offset, 2), /*STRINGREF_STR*/"eb")) {
    offset += 2;
  } else // Or, if it ends with eb ("armv7eb"), chop it off.
  if (A.endswith(/*STRINGREF_STR*/"eb")) {
    A.$assignMove(A.substr(0, A.size() - 2));
  }
  // Trim the head
  if (offset != StringRef.npos) {
    A.$assignMove(A.substr(offset));
  }
  
  // Empty string means offset reached the end, which means it's valid.
  if (A.empty()) {
    return new StringRef(JD$Move.INSTANCE, Arch);
  }
  
  // Only match non-marketing names
  if (offset != StringRef.npos) {
    // Must start with 'vN'.
    if (A.$at(0) != $$v || !(std.isdigit(A.$at(1)) != 0)) {
      return Error;
    }
    // Can't have an extra 'eb'.
    if (A.find(/*STRINGREF_STR*/"eb") != StringRef.npos) {
      return Error;
    }
  }
  
  // Arch will either be a 'v' name (v7a) or a marketing name (xscale).
  return A;
}


// Information by ID
// namespace

// ======================================================= //
// Information by ID
// ======================================================= //
// Information by ID
// ======================================================= //
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getFPUName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 149,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 135,
 FQN="llvm::ARM::getFPUName", NM="_ZN4llvm3ARM10getFPUNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10getFPUNameEj")
//</editor-fold>
public static StringRef getFPUName(/*uint*/int FPUKind) {
  if ($greatereq_uint(FPUKind, ARM.FPUKind.FK_LAST.getValue())) {
    return new StringRef();
  }
  return FPUNames[FPUKind].getName();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getFPUVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 155,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 141,
 FQN="llvm::ARM::getFPUVersion", NM="_ZN4llvm3ARM13getFPUVersionEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM13getFPUVersionEj")
//</editor-fold>
public static /*uint*/int getFPUVersion(/*uint*/int FPUKind) {
  if ($greatereq_uint(FPUKind, ARM.FPUKind.FK_LAST.getValue())) {
    return 0;
  }
  return FPUNames[FPUKind].FPUVersion.getValue();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getFPUNeonSupportLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 161,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 147,
 FQN="llvm::ARM::getFPUNeonSupportLevel", NM="_ZN4llvm3ARM22getFPUNeonSupportLevelEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM22getFPUNeonSupportLevelEj")
//</editor-fold>
public static /*uint*/int getFPUNeonSupportLevel(/*uint*/int FPUKind) {
  if ($greatereq_uint(FPUKind, ARM.FPUKind.FK_LAST.getValue())) {
    return 0;
  }
  return FPUNames[FPUKind].NeonSupport.getValue();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getFPURestriction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 167,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 153,
 FQN="llvm::ARM::getFPURestriction", NM="_ZN4llvm3ARM17getFPURestrictionEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM17getFPURestrictionEj")
//</editor-fold>
public static /*uint*/int getFPURestriction(/*uint*/int FPUKind) {
  if ($greatereq_uint(FPUKind, ARM.FPUKind.FK_LAST.getValue())) {
    return 0;
  }
  return FPUNames[FPUKind].Restriction.getValue();
}


// FIXME: These should be moved to TargetTuple once it exists
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getFPUFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 233,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 219,
 FQN="llvm::ARM::getFPUFeatures", NM="_ZN4llvm3ARM14getFPUFeaturesEjRSt6vectorIPKcSaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM14getFPUFeaturesEjRSt6vectorIPKcSaIS3_EE")
//</editor-fold>
public static boolean getFPUFeatures(/*uint*/int FPUKind, 
              vectorCharPtr/*&*/ Features) {
  if ($greatereq_uint(FPUKind, ARM.FPUKind.FK_LAST.getValue()) || FPUKind == ARM.FPUKind.FK_INVALID.getValue()) {
    return false;
  }
  
  // fp-only-sp and d16 subtarget features are independent of each other, so we
  // must enable/disable both.
  switch (FPUNames[FPUKind].Restriction) {
   case FR_SP_D16:
    Features.push_back_T$RR($("+fp-only-sp"));
    Features.push_back_T$RR($("+d16"));
    break;
   case FR_D16:
    Features.push_back_T$RR($("-fp-only-sp"));
    Features.push_back_T$RR($("+d16"));
    break;
   case FR_None:
    Features.push_back_T$RR($("-fp-only-sp"));
    Features.push_back_T$RR($("-d16"));
    break;
  }
  
  // FPU version subtarget features are inclusive of lower-numbered ones, so
  // enable the one corresponding to this version and disable all that are
  // higher. We also have to make sure to disable fp16 when vfp4 is disabled,
  // as +vfp4 implies +fp16 but -vfp4 does not imply -fp16.
  switch (FPUNames[FPUKind].FPUVersion) {
   case FV_VFPV5:
    Features.push_back_T$RR($("+fp-armv8"));
    break;
   case FV_VFPV4:
    Features.push_back_T$RR($("+vfp4"));
    Features.push_back_T$RR($("-fp-armv8"));
    break;
   case FV_VFPV3_FP16:
    Features.push_back_T$RR($("+vfp3"));
    Features.push_back_T$RR($("+fp16"));
    Features.push_back_T$RR($("-vfp4"));
    Features.push_back_T$RR($("-fp-armv8"));
    break;
   case FV_VFPV3:
    Features.push_back_T$RR($("+vfp3"));
    Features.push_back_T$RR($("-fp16"));
    Features.push_back_T$RR($("-vfp4"));
    Features.push_back_T$RR($("-fp-armv8"));
    break;
   case FV_VFPV2:
    Features.push_back_T$RR($("+vfp2"));
    Features.push_back_T$RR($("-vfp3"));
    Features.push_back_T$RR($("-fp16"));
    Features.push_back_T$RR($("-vfp4"));
    Features.push_back_T$RR($("-fp-armv8"));
    break;
   case FV_NONE:
    Features.push_back_T$RR($("-vfp2"));
    Features.push_back_T$RR($("-vfp3"));
    Features.push_back_T$RR($("-fp16"));
    Features.push_back_T$RR($("-vfp4"));
    Features.push_back_T$RR($("-fp-armv8"));
    break;
  }
  
  // crypto includes neon, so we handle this similarly to FPU version.
  switch (FPUNames[FPUKind].NeonSupport) {
   case NS_Crypto:
    Features.push_back_T$RR($("+neon"));
    Features.push_back_T$RR($("+crypto"));
    break;
   case NS_Neon:
    Features.push_back_T$RR($("+neon"));
    Features.push_back_T$RR($("-crypto"));
    break;
   case NS_None:
    Features.push_back_T$RR($("-neon"));
    Features.push_back_T$RR($("-crypto"));
    break;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getHWDivFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 195,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 181,
 FQN="llvm::ARM::getHWDivFeatures", NM="_ZN4llvm3ARM16getHWDivFeaturesEjRSt6vectorIPKcSaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM16getHWDivFeaturesEjRSt6vectorIPKcSaIS3_EE")
//</editor-fold>
public static boolean getHWDivFeatures(/*uint*/int HWDivKind, 
                vectorCharPtr/*&*/ Features) {
  if (HWDivKind == ARM.ArchExtKind.AEK_INVALID) {
    return false;
  }
  if (((HWDivKind & ARM.ArchExtKind.AEK_HWDIVARM) != 0)) {
    Features.push_back_T$RR($("+hwdiv-arm"));
  } else {
    Features.push_back_T$RR($("-hwdiv-arm"));
  }
  if (((HWDivKind & ARM.ArchExtKind.AEK_HWDIV) != 0)) {
    Features.push_back_T$RR($("+hwdiv"));
  } else {
    Features.push_back_T$RR($("-hwdiv"));
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getExtensionFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 214,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 200,
 FQN="llvm::ARM::getExtensionFeatures", NM="_ZN4llvm3ARM20getExtensionFeaturesEjRSt6vectorIPKcSaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM20getExtensionFeaturesEjRSt6vectorIPKcSaIS3_EE")
//</editor-fold>
public static boolean getExtensionFeatures(/*uint*/int Extensions, 
                    vectorCharPtr/*&*/ Features) {
  if (Extensions == ARM.ArchExtKind.AEK_INVALID) {
    return false;
  }
  if (((Extensions & ARM.ArchExtKind.AEK_CRC) != 0)) {
    Features.push_back_T$RR($("+crc"));
  } else {
    Features.push_back_T$RR($("-crc"));
  }
  if (((Extensions & ARM.ArchExtKind.AEK_DSP) != 0)) {
    Features.push_back_T$RR($("+dsp"));
  } else {
    Features.push_back_T$RR($("-dsp"));
  }
  
  return getHWDivFeatures(Extensions, Features);
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 315,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 301,
 FQN="llvm::ARM::getArchName", NM="_ZN4llvm3ARM11getArchNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM11getArchNameEj")
//</editor-fold>
public static StringRef getArchName(/*uint*/int ArchKind) {
  if ($greatereq_uint(ArchKind, ARM.ArchKind.AK_LAST.getValue())) {
    return new StringRef();
  }
  return ARCHNames[ArchKind].getName();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getArchAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 333,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 319,
 FQN="llvm::ARM::getArchAttr", NM="_ZN4llvm3ARM11getArchAttrEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM11getArchAttrEj")
//</editor-fold>
public static /*uint*/int getArchAttr(/*uint*/int ArchKind) {
  if ($greatereq_uint(ArchKind, ARM.ArchKind.AK_LAST.getValue())) {
    return ARMBuildAttrs.CPUArch.Pre_v4.getValue();
  }
  return ARCHNames[ArchKind].ArchAttr.getValue();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getCPUAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 321,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 307,
 FQN="llvm::ARM::getCPUAttr", NM="_ZN4llvm3ARM10getCPUAttrEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10getCPUAttrEj")
//</editor-fold>
public static StringRef getCPUAttr(/*uint*/int ArchKind) {
  if (ArchKind == ARM.ArchKind.AK_INVALID.getValue() || $greatereq_uint(ArchKind, ARM.ArchKind.AK_LAST.getValue())) {
    return new StringRef();
  }
  return ARCHNames[ArchKind].getCPUAttr();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getSubArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 327,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 313,
 FQN="llvm::ARM::getSubArch", NM="_ZN4llvm3ARM10getSubArchEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10getSubArchEj")
//</editor-fold>
public static StringRef getSubArch(/*uint*/int ArchKind) {
  if (ArchKind == ARM.ArchKind.AK_INVALID.getValue() || $greatereq_uint(ArchKind, ARM.ArchKind.AK_LAST.getValue())) {
    return new StringRef();
  }
  return ARCHNames[ArchKind].getSubArch();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getArchExtName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 339,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 325,
 FQN="llvm::ARM::getArchExtName", NM="_ZN4llvm3ARM14getArchExtNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM14getArchExtNameEj")
//</editor-fold>
public static StringRef getArchExtName(/*uint*/int ArchExtKind) {
  for (Unnamed_struct2 AE : ARCHExtNames) {
    if (ArchExtKind == AE.ID) {
      return AE.getName();
    }
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getArchExtFeature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 347,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 333,
 FQN="llvm::ARM::getArchExtFeature", NM="_ZN4llvm3ARM17getArchExtFeatureENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM17getArchExtFeatureENS_9StringRefE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getArchExtFeature(StringRef ArchExt) {
  if (ArchExt.startswith(/*STRINGREF_STR*/"no")) {
    StringRef ArchExtBase/*J*/= ArchExt.substr(2);
    for (Unnamed_struct2 AE : ARCHExtNames) {
      if ((AE.NegFeature != null) && $eq_StringRef(/*NO_COPY*/ArchExtBase, AE.getName())) {
        return AE.NegFeature;
      }
    }
  }
  for (Unnamed_struct2 AE : ARCHExtNames) {
    if ((AE.Feature != null) && $eq_StringRef(/*NO_COPY*/ArchExt, AE.getName())) {
      return AE.Feature;
    }
  }
  
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getHWDivName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 363,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 349,
 FQN="llvm::ARM::getHWDivName", NM="_ZN4llvm3ARM12getHWDivNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM12getHWDivNameEj")
//</editor-fold>
public static StringRef getHWDivName(/*uint*/int HWDivKind) {
  for (Unnamed_struct3 D : HWDivNames) {
    if (HWDivKind == D.ID) {
      return D.getName();
    }
  }
  return new StringRef();
}


// Information by Name
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getDefaultFPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 173,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 159,
 FQN="llvm::ARM::getDefaultFPU", NM="_ZN4llvm3ARM13getDefaultFPUENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM13getDefaultFPUENS_9StringRefEj")
//</editor-fold>
public static /*uint*/int getDefaultFPU(StringRef CPU, /*uint*/int ArchKind) {
  if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"generic")) {
    return ARCHNames[ArchKind].DefaultFPU;
  }
  
  return new StringSwitchUInt(/*NO_COPY*/CPU).Case(/*KEEP_STR*/"arm2", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm3", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm6", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm7m", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm8", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm810", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"strongarm", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"strongarm110", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"strongarm1100", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"strongarm1110", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm7tdmi", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm7tdmi-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm710t", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm720t", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm9", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm9tdmi", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm920", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm920t", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm922t", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm9312", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm940t", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"ep9312", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm10tdmi", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1020t", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm9e", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm946e-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm966e-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm968e-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm10e", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1020e", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1022e", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm926ej-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1136j-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1136jf-s", FPUKind.FK_VFPV2.getValue()).
      Case(/*KEEP_STR*/"arm1136jz-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1176j-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1176jz-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"mpcore", FPUKind.FK_VFPV2.getValue()).
      Case(/*KEEP_STR*/"mpcorenovfp", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1176jzf-s", FPUKind.FK_VFPV2.getValue()).
      Case(/*KEEP_STR*/"arm1156t2-s", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"arm1156t2f-s", FPUKind.FK_VFPV2.getValue()).
      Case(/*KEEP_STR*/"cortex-m0", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"cortex-m0plus", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"cortex-m1", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"sc000", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"cortex-a5", FPUKind.FK_NEON_VFPV4.getValue()).
      Case(/*KEEP_STR*/"cortex-a7", FPUKind.FK_NEON_VFPV4.getValue()).
      Case(/*KEEP_STR*/"cortex-a8", FPUKind.FK_NEON.getValue()).
      Case(/*KEEP_STR*/"cortex-a9", FPUKind.FK_NEON_FP16.getValue()).
      Case(/*KEEP_STR*/"cortex-a12", FPUKind.FK_NEON_VFPV4.getValue()).
      Case(/*KEEP_STR*/"cortex-a15", FPUKind.FK_NEON_VFPV4.getValue()).
      Case(/*KEEP_STR*/"cortex-a17", FPUKind.FK_NEON_VFPV4.getValue()).
      Case(/*KEEP_STR*/"krait", FPUKind.FK_NEON_VFPV4.getValue()).
      Case(/*KEEP_STR*/"cortex-r4", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"cortex-r4f", FPUKind.FK_VFPV3_D16.getValue()).
      Case(/*KEEP_STR*/"cortex-r5", FPUKind.FK_VFPV3_D16.getValue()).
      Case(/*KEEP_STR*/"cortex-r7", FPUKind.FK_VFPV3_D16_FP16.getValue()).
      Case(/*KEEP_STR*/"cortex-r8", FPUKind.FK_VFPV3_D16_FP16.getValue()).
      Case(/*KEEP_STR*/"sc300", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"cortex-m3", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"cortex-m4", FPUKind.FK_FPV4_SP_D16.getValue()).
      Case(/*KEEP_STR*/"cortex-m7", FPUKind.FK_FPV5_D16.getValue()).
      Case(/*KEEP_STR*/"cortex-a32", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a35", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a53", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a57", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a72", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a73", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cyclone", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"exynos-m1", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      // Non-standard Arch names.
      Case(/*KEEP_STR*/"iwmmxt", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"xscale", FPUKind.FK_NONE.getValue()).
      Case(/*KEEP_STR*/"swift", FPUKind.FK_NEON_VFPV4.getValue()).
      // Invalid CPU
      Case(/*KEEP_STR*/"invalid", FPUKind.FK_INVALID.getValue()).Default(ARM.FPUKind.FK_INVALID.getValue());
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getDefaultExtensions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 184,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 170,
 FQN="llvm::ARM::getDefaultExtensions", NM="_ZN4llvm3ARM20getDefaultExtensionsENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM20getDefaultExtensionsENS_9StringRefEj")
//</editor-fold>
public static /*uint*/int getDefaultExtensions(StringRef CPU, /*uint*/int _ArchKind) {
  if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"generic")) {
    return ARCHNames[_ArchKind].ArchBaseExtensions;
  }
  
  return new StringSwitchUInt(/*NO_COPY*/CPU).Case(/*KEEP_STR*/"arm2", ARCHNames[ArchKind.AK_ARMV2.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm3", ARCHNames[ArchKind.AK_ARMV2A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm6", ARCHNames[ArchKind.AK_ARMV3.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm7m", ARCHNames[ArchKind.AK_ARMV3M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm8", ARCHNames[ArchKind.AK_ARMV4.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm810", ARCHNames[ArchKind.AK_ARMV4.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"strongarm", ARCHNames[ArchKind.AK_ARMV4.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"strongarm110", ARCHNames[ArchKind.AK_ARMV4.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"strongarm1100", ARCHNames[ArchKind.AK_ARMV4.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"strongarm1110", ARCHNames[ArchKind.AK_ARMV4.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm7tdmi", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm7tdmi-s", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm710t", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm720t", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm9", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm9tdmi", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm920", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm920t", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm922t", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm9312", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm940t", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"ep9312", ARCHNames[ArchKind.AK_ARMV4T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm10tdmi", ARCHNames[ArchKind.AK_ARMV5T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1020t", ARCHNames[ArchKind.AK_ARMV5T.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm9e", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm946e-s", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm966e-s", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm968e-s", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm10e", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1020e", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1022e", ARCHNames[ArchKind.AK_ARMV5TE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm926ej-s", ARCHNames[ArchKind.AK_ARMV5TEJ.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1136j-s", ARCHNames[ArchKind.AK_ARMV6.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1136jf-s", ARCHNames[ArchKind.AK_ARMV6.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1136jz-s", ARCHNames[ArchKind.AK_ARMV6.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1176j-s", ARCHNames[ArchKind.AK_ARMV6K.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1176jz-s", ARCHNames[ArchKind.AK_ARMV6KZ.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"mpcore", ARCHNames[ArchKind.AK_ARMV6K.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"mpcorenovfp", ARCHNames[ArchKind.AK_ARMV6K.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1176jzf-s", ARCHNames[ArchKind.AK_ARMV6KZ.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1156t2-s", ARCHNames[ArchKind.AK_ARMV6T2.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"arm1156t2f-s", ARCHNames[ArchKind.AK_ARMV6T2.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-m0", ARCHNames[ArchKind.AK_ARMV6M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-m0plus", ARCHNames[ArchKind.AK_ARMV6M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-m1", ARCHNames[ArchKind.AK_ARMV6M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"sc000", ARCHNames[ArchKind.AK_ARMV6M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-a5", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP)).
      Case(/*KEEP_STR*/"cortex-a7", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)).
      Case(/*KEEP_STR*/"cortex-a8", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_SEC).
      Case(/*KEEP_STR*/"cortex-a9", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP)).
      Case(/*KEEP_STR*/"cortex-a12", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)).
      Case(/*KEEP_STR*/"cortex-a15", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)).
      Case(/*KEEP_STR*/"cortex-a17", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)).
      Case(/*KEEP_STR*/"krait", ARCHNames[ArchKind.AK_ARMV7A.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)).
      Case(/*KEEP_STR*/"cortex-r4", ARCHNames[ArchKind.AK_ARMV7R.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-r4f", ARCHNames[ArchKind.AK_ARMV7R.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-r5", ARCHNames[ArchKind.AK_ARMV7R.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_HWDIVARM)).
      Case(/*KEEP_STR*/"cortex-r7", ARCHNames[ArchKind.AK_ARMV7R.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_HWDIVARM)).
      Case(/*KEEP_STR*/"cortex-r8", ARCHNames[ArchKind.AK_ARMV7R.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_HWDIVARM)).
      Case(/*KEEP_STR*/"sc300", ARCHNames[ArchKind.AK_ARMV7M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-m3", ARCHNames[ArchKind.AK_ARMV7M.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-m4", ARCHNames[ArchKind.AK_ARMV7EM.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-m7", ARCHNames[ArchKind.AK_ARMV7EM.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"cortex-a32", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"cortex-a35", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"cortex-a53", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"cortex-a57", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"cortex-a72", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"cortex-a73", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"cyclone", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      Case(/*KEEP_STR*/"exynos-m1", ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_CRC).
      // Non-standard Arch names.
      Case(/*KEEP_STR*/"iwmmxt", ARCHNames[ArchKind.AK_IWMMXT.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"xscale", ARCHNames[ArchKind.AK_XSCALE.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_NONE).
      Case(/*KEEP_STR*/"swift", ARCHNames[ArchKind.AK_ARMV7S.getValue()].ArchBaseExtensions | (ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)).
      // Invalid CPU
      Case(/*KEEP_STR*/"invalid", ARCHNames[ArchKind.AK_INVALID.getValue()].ArchBaseExtensions | ARM.ArchExtKind.AEK_INVALID).Default(ARM.ArchExtKind.AEK_INVALID);
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::getDefaultCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 371,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 357,
 FQN="llvm::ARM::getDefaultCPU", NM="_ZN4llvm3ARM13getDefaultCPUENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM13getDefaultCPUENS_9StringRefE")
//</editor-fold>
public static StringRef getDefaultCPU(StringRef Arch) {
  /*uint*/int AK = parseArch(/*NO_COPY*/Arch);
  if (AK == ARM.ArchKind.AK_INVALID.getValue()) {
    return new StringRef();
  }
  
  // Look for multiple AKs to find the default for pair AK+Name.
  for (Unnamed_struct4 CPU : CPUNames) {
    if (CPU.ArchID.getValue() == AK && CPU.Default) {
      return CPU.getName();
    }
  }
  
  // If we can't find a default then target the architecture instead
  return new StringRef(/*KEEP_STR*/$generic);
}


// Parser
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseHWDiv">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 636,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 470,
 FQN="llvm::ARM::parseHWDiv", NM="_ZN4llvm3ARM10parseHWDivENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM10parseHWDivENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseHWDiv(StringRef HWDiv) {
  StringRef Syn = getHWDivSynonym(new StringRef(HWDiv));
  for (Unnamed_struct3 D : HWDivNames) {
    if ($eq_StringRef(/*NO_COPY*/Syn, D.getName())) {
      return D.ID;
    }
  }
  return ARM.ArchExtKind.AEK_INVALID;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseFPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 645,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 479,
 FQN="llvm::ARM::parseFPU", NM="_ZN4llvm3ARM8parseFPUENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM8parseFPUENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseFPU(StringRef FPU) {
  StringRef Syn = getFPUSynonym(new StringRef(FPU));
  for (Unnamed_struct F : FPUNames) {
    if ($eq_StringRef(/*NO_COPY*/Syn, F.getName())) {
      return F.ID.getValue();
    }
  }
  return ARM.FPUKind.FK_INVALID.getValue();
}


// Allows partial match, ex. "v7a" matches "armv7a".
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 655,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 489,
 FQN="llvm::ARM::parseArch", NM="_ZN4llvm3ARM9parseArchENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM9parseArchENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArch(StringRef Arch) {
  Arch.$assignMove(getCanonicalArchName(/*NO_COPY*/Arch));
  StringRef Syn = getArchSynonym(new StringRef(Arch));
  for (Unnamed_struct1 A : ARCHNames) {
    if (A.getName().endswith(/*NO_COPY*/Syn)) {
      return A.ID.getValue();
    }
  }
  return ARM.ArchKind.AK_INVALID.getValue();
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseArchExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 665,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 499,
 FQN="llvm::ARM::parseArchExt", NM="_ZN4llvm3ARM12parseArchExtENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM12parseArchExtENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchExt(StringRef ArchExt) {
  for (Unnamed_struct2 A : ARCHExtNames) {
    if ($eq_StringRef(/*NO_COPY*/ArchExt, A.getName())) {
      return A.ID;
    }
  }
  return ARM.ArchExtKind.AEK_INVALID;
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseCPUArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 673,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 507,
 FQN="llvm::ARM::parseCPUArch", NM="_ZN4llvm3ARM12parseCPUArchENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM12parseCPUArchENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseCPUArch(StringRef CPU) {
  for (Unnamed_struct4 C : CPUNames) {
    if ($eq_StringRef(/*NO_COPY*/CPU, C.getName())) {
      return C.ArchID.getValue();
    }
  }
  return ARM.ArchKind.AK_INVALID.getValue();
}


// ARM, Thumb, AArch64
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseArchISA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 682,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 516,
 FQN="llvm::ARM::parseArchISA", NM="_ZN4llvm3ARM12parseArchISAENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM12parseArchISAENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchISA(StringRef Arch) {
  return new StringSwitchUInt(/*NO_COPY*/Arch).
      StartsWith(/*KEEP_STR*/"aarch64", ARM.ISAKind.IK_AARCH64.getValue()).
      StartsWith(/*KEEP_STR*/"arm64", ARM.ISAKind.IK_AARCH64.getValue()).
      StartsWith(/*KEEP_STR*/"thumb", ARM.ISAKind.IK_THUMB.getValue()).
      StartsWith(/*KEEP_STR*/"arm", ARM.ISAKind.IK_ARM.getValue()).
      Default(ARM.EndianKind.EK_INVALID.getValue());
}


// Little/Big endian
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseArchEndian">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 692,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 526,
 FQN="llvm::ARM::parseArchEndian", NM="_ZN4llvm3ARM15parseArchEndianENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM15parseArchEndianENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchEndian(StringRef Arch) {
  if (Arch.startswith(/*STRINGREF_STR*/"armeb") || Arch.startswith(/*STRINGREF_STR*/"thumbeb")
     || Arch.startswith(/*STRINGREF_STR*/"aarch64_be")) {
    return ARM.EndianKind.EK_BIG.getValue();
  }
  if (Arch.startswith(/*STRINGREF_STR*/"arm") || Arch.startswith(/*STRINGREF_STR*/"thumb")) {
    if (Arch.endswith(/*STRINGREF_STR*/"eb")) {
      return ARM.EndianKind.EK_BIG.getValue();
    } else {
      return ARM.EndianKind.EK_LITTLE.getValue();
    }
  }
  if (Arch.startswith(/*STRINGREF_STR*/"aarch64")) {
    return ARM.EndianKind.EK_LITTLE.getValue();
  }
  
  return ARM.EndianKind.EK_INVALID.getValue();
}


// Profile A/R/M
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseArchProfile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 711,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 545,
 FQN="llvm::ARM::parseArchProfile", NM="_ZN4llvm3ARM16parseArchProfileENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM16parseArchProfileENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchProfile(StringRef Arch) {
  Arch.$assignMove(getCanonicalArchName(/*NO_COPY*/Arch));
  switch (ArchKind.valueOf(parseArch(/*NO_COPY*/Arch))) {
   case AK_ARMV6M:
   case AK_ARMV7M:
   case AK_ARMV7EM:
   case AK_ARMV8MMainline:
   case AK_ARMV8MBaseline:
    return ARM.ProfileKind.PK_M.getValue();
   case AK_ARMV7R:
    return ARM.ProfileKind.PK_R.getValue();
   case AK_ARMV7A:
   case AK_ARMV7K:
   case AK_ARMV8A:
   case AK_ARMV8_1A:
   case AK_ARMV8_2A:
    return ARM.ProfileKind.PK_A.getValue();
  }
  return ARM.ProfileKind.PK_INVALID.getValue();
}


// Version number (ex. v7 = 7).
//<editor-fold defaultstate="collapsed" desc="llvm::ARM::parseArchVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 733,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 565,
 FQN="llvm::ARM::parseArchVersion", NM="_ZN4llvm3ARM16parseArchVersionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm3ARM16parseArchVersionENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchVersion(StringRef Arch) {
  Arch.$assignMove(getCanonicalArchName(/*NO_COPY*/Arch));
  switch (ArchKind.valueOf(parseArch(/*NO_COPY*/Arch))) {
   case AK_ARMV2:
   case AK_ARMV2A:
    return 2;
   case AK_ARMV3:
   case AK_ARMV3M:
    return 3;
   case AK_ARMV4:
   case AK_ARMV4T:
    return 4;
   case AK_ARMV5T:
   case AK_ARMV5TE:
   case AK_IWMMXT:
   case AK_IWMMXT2:
   case AK_XSCALE:
   case AK_ARMV5TEJ:
    return 5;
   case AK_ARMV6:
   case AK_ARMV6K:
   case AK_ARMV6T2:
   case AK_ARMV6KZ:
   case AK_ARMV6M:
    return 6;
   case AK_ARMV7A:
   case AK_ARMV7R:
   case AK_ARMV7M:
   case AK_ARMV7S:
   case AK_ARMV7EM:
   case AK_ARMV7K:
    return 7;
   case AK_ARMV8A:
   case AK_ARMV8_1A:
   case AK_ARMV8_2A:
   case AK_ARMV8MBaseline:
   case AK_ARMV8MMainline:
    return 8;
  }
  return 0;
}

} // END OF class ARM
