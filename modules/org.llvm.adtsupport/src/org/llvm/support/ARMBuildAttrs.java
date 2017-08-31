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
package org.llvm.support;

import org.clank.support.*;
import org.llvm.adt.*;


//<editor-fold defaultstate="collapsed" desc="static type ARMBuildAttrs">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs11SpecialAttrE;_ZN4llvm13ARMBuildAttrs14CPUArchProfileE;_ZN4llvm13ARMBuildAttrs16AttrTypeAsStringENS0_8AttrTypeEb;_ZN4llvm13ARMBuildAttrs16AttrTypeAsStringEjb;_ZN4llvm13ARMBuildAttrs18AttrTypeFromStringENS_9StringRefE;_ZN4llvm13ARMBuildAttrs7CPUArchE;_ZN4llvm13ARMBuildAttrs8AttrTypeE;_ZN4llvm13ARMBuildAttrs9AttrMagicE;_ZN4llvm13ARMBuildAttrsE_ARMBuildAttributes_h_Unnamed_enum5; -static-type=ARMBuildAttrs -package=org.llvm.support")
//</editor-fold>
public final class ARMBuildAttrs {

//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::SpecialAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", line = 27,
 FQN="llvm::ARMBuildAttrs::SpecialAttr", NM="_ZN4llvm13ARMBuildAttrs11SpecialAttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs11SpecialAttrE")
//</editor-fold>
public enum SpecialAttr implements Native.ComparableLower {
  // This is for the .cpu asm attr. It translates into one or more
  // AttrType (below) entries in the .ARM.attributes section in the ELF.
  SEL_CPU(0);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SpecialAttr valueOf(int val) {
    SpecialAttr out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SpecialAttr[] VALUES;
    private static final SpecialAttr[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SpecialAttr kind : SpecialAttr.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new SpecialAttr[min < 0 ? (1-min) : 0];
      VALUES = new SpecialAttr[max >= 0 ? (1+max) : 0];
      for (SpecialAttr kind : SpecialAttr.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private SpecialAttr(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SpecialAttr)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SpecialAttr)obj).value);}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::AttrType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", line = 33,
 FQN="llvm::ARMBuildAttrs::AttrType", NM="_ZN4llvm13ARMBuildAttrs8AttrTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs8AttrTypeE")
//</editor-fold>
public enum AttrType implements Native.ComparableLower {
  // Rest correspond to ELF/.ARM.attributes
  File(1),
  CPU_raw_name(4),
  CPU_name(5),
  CPU_arch(6),
  CPU_arch_profile(7),
  ARM_ISA_use(8),
  THUMB_ISA_use(9),
  FP_arch(10),
  WMMX_arch(11),
  Advanced_SIMD_arch(12),
  PCS_config(13),
  ABI_PCS_R9_use(14),
  ABI_PCS_RW_data(15),
  ABI_PCS_RO_data(16),
  ABI_PCS_GOT_use(17),
  ABI_PCS_wchar_t(18),
  ABI_FP_rounding(19),
  ABI_FP_denormal(20),
  ABI_FP_exceptions(21),
  ABI_FP_user_exceptions(22),
  ABI_FP_number_model(23),
  ABI_align_needed(24),
  ABI_align_preserved(25),
  ABI_enum_size(26),
  ABI_HardFP_use(27),
  ABI_VFP_args(28),
  ABI_WMMX_args(29),
  ABI_optimization_goals(30),
  ABI_FP_optimization_goals(31),
  compatibility(32),
  CPU_unaligned_access(34),
  FP_HP_extension(36),
  ABI_FP_16bit_format(38),
  MPextension_use(42), // recoded from 70 (ABI r2.08)
  DIV_use(44),
  DSP_extension(46),
  also_compatible_with(65),
  conformance(67),
  Virtualization_use(68),
  
  /// Legacy Tags
  Section(2), // deprecated (ABI r2.09)
  Symbol(3), // deprecated (ABI r2.09)
  ABI_align8_needed(24), // renamed to ABI_align_needed (ABI r2.09)
  ABI_align8_preserved(25), // renamed to ABI_align_preserved (ABI r2.09)
  nodefaults(64), // deprecated (ABI r2.09)
  T2EE_use(66), // deprecated (ABI r2.09)
  MPextension_use_old(70); // recoded to MPextension_use (ABI r2.08)

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static AttrType valueOf(int val) {
    AttrType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final AttrType[] VALUES;
    private static final AttrType[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (AttrType kind : AttrType.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new AttrType[min < 0 ? (1-min) : 0];
      VALUES = new AttrType[max >= 0 ? (1+max) : 0];
      for (AttrType kind : AttrType.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private AttrType(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((AttrType)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((AttrType)obj).value);}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::AttrTypeAsString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp", line = 74,
 old_source = "${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp", old_line = 73,
 FQN="llvm::ARMBuildAttrs::AttrTypeAsString", NM="_ZN4llvm13ARMBuildAttrs16AttrTypeAsStringEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs16AttrTypeAsStringEjb")
//</editor-fold>
public static StringRef AttrTypeAsString(/*uint*/int Attr) {
  return AttrTypeAsString(Attr, true);
}
public static StringRef AttrTypeAsString(/*uint*/int Attr, boolean HasTagPrefix/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::AttrTypeAsString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp", line = 78,
 old_source = "${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp", old_line = 77,
 FQN="llvm::ARMBuildAttrs::AttrTypeAsString", NM="_ZN4llvm13ARMBuildAttrs16AttrTypeAsStringENS0_8AttrTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs16AttrTypeAsStringENS0_8AttrTypeEb")
//</editor-fold>
public static StringRef AttrTypeAsString(AttrType Attr) {
  return AttrTypeAsString(Attr, true);
}
public static StringRef AttrTypeAsString(AttrType Attr, boolean HasTagPrefix/*= true*/) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::AttrTypeFromString">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp", line = 86,
 old_source = "${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp", old_line = 85,
 FQN="llvm::ARMBuildAttrs::AttrTypeFromString", NM="_ZN4llvm13ARMBuildAttrs18AttrTypeFromStringENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs18AttrTypeFromStringENS_9StringRefE")
//</editor-fold>
public static int AttrTypeFromString(StringRef Tag) {
  throw new UnsupportedOperationException("EmptyBody");
}


// Magic numbers for .ARM.attributes
//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::AttrMagic">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", line = 90,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", old_line = 89,
 FQN="llvm::ARMBuildAttrs::AttrMagic", NM="_ZN4llvm13ARMBuildAttrs9AttrMagicE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs9AttrMagicE")
//</editor-fold>
public static final class/*enum*/ AttrMagic {
  public static final /*uint*/int Format_Version = 0x41;
}

// Legal Values for CPU_arch, (=6), uleb128
//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::CPUArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", line = 95,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", old_line = 94,
 FQN="llvm::ARMBuildAttrs::CPUArch", NM="_ZN4llvm13ARMBuildAttrs7CPUArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs7CPUArchE")
//</editor-fold>
public enum CPUArch implements Native.ComparableLower {
  Pre_v4(0),
  v4(1), // e.g. SA110
  v4T(2), // e.g. ARM7TDMI
  v5T(3), // e.g. ARM9TDMI
  v5TE(4), // e.g. ARM946E_S
  v5TEJ(5), // e.g. ARM926EJ_S
  v6(6), // e.g. ARM1136J_S
  v6KZ(7), // e.g. ARM1176JZ_S
  v6T2(8), // e.g. ARM1156T2_S
  v6K(9), // e.g. ARM1176JZ_S
  v7(10), // e.g. Cortex A8, Cortex M3
  v6_M(11), // e.g. Cortex M1
  v6S_M(12), // v6_M with the System extensions
  v7E_M(13), // v7_M with DSP extensions
  v8_A(14), // v8_A AArch32
  v8_M_Base(16), // v8_M_Base AArch32
  v8_M_Main(17); // v8_M_Main AArch32

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static CPUArch valueOf(int val) {
    CPUArch out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final CPUArch[] VALUES;
    private static final CPUArch[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (CPUArch kind : CPUArch.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new CPUArch[min < 0 ? (1-min) : 0];
      VALUES = new CPUArch[max >= 0 ? (1+max) : 0];
      for (CPUArch kind : CPUArch.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private CPUArch(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CPUArch)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CPUArch)obj).value);}
  //</editor-fold>
}
//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::CPUArchProfile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", line = 115,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", old_line = 112,
 FQN="llvm::ARMBuildAttrs::CPUArchProfile", NM="_ZN4llvm13ARMBuildAttrs14CPUArchProfileE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrs14CPUArchProfileE")
//</editor-fold>
public static final class/*enum*/ CPUArchProfile {
  // (=7), uleb128
  public static final /*uint*/int Not_Applicable = 0; // pre v7, or cross-profile code
  public static final /*uint*/int ApplicationProfile = (0x41); // 'A' (e.g. for Cortex A8)
  public static final /*uint*/int RealTimeProfile = (0x52); // 'R' (e.g. for Cortex R4)
  public static final /*uint*/int MicroControllerProfile = (0x4D); // 'M' (e.g. for Cortex M3)
  public static final /*uint*/int SystemProfile = (0x53); // 'S' Application or real-time profile
}

// The following have a lot of common use cases
//<editor-fold defaultstate="collapsed" desc="llvm::ARMBuildAttrs::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", line = 124,
 old_source = "${LLVM_SRC}/llvm/include/llvm/Support/ARMBuildAttributes.h", old_line = 121,
 FQN="llvm::ARMBuildAttrs::(anonymous)", NM="_ZN4llvm13ARMBuildAttrsE_ARMBuildAttributes_h_Unnamed_enum5",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/ARMBuildAttrs.cpp -nm=_ZN4llvm13ARMBuildAttrsE_ARMBuildAttributes_h_Unnamed_enum5")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int Not_Allowed = 0;
  public static final /*uint*/int Allowed = 1;
  
  // Tag_ARM_ISA_use (=8), uleb128
  
  // Tag_THUMB_ISA_use, (=9), uleb128
  public static final /*uint*/int AllowThumb32 = 2; // 32-bit Thumb (implies 16-bit instructions)
  public static final /*uint*/int AllowThumbDerived = 3; // Thumb allowed, derived from arch/profile
  
  // Tag_FP_arch (=10), uleb128 (formerly Tag_VFP_arch = 10)
  public static final /*uint*/int AllowFPv2 = 2; // v2 FP ISA permitted (implies use of the v1 FP ISA)
  public static final /*uint*/int AllowFPv3A = 3; // v3 FP ISA permitted (implies use of the v2 FP ISA)
  public static final /*uint*/int AllowFPv3B = 4; // v3 FP ISA permitted, but only D0-D15, S0-S31
  public static final /*uint*/int AllowFPv4A = 5; // v4 FP ISA permitted (implies use of v3 FP ISA)
  public static final /*uint*/int AllowFPv4B = 6; // v4 FP ISA was permitted, but only D0-D15, S0-S31
  public static final /*uint*/int AllowFPARMv8A = 7; // Use of the ARM v8-A FP ISA was permitted
  public static final /*uint*/int AllowFPARMv8B = 8; // Use of the ARM v8-A FP ISA was permitted, but only
  // D0-D15, S0-S31
  
  // Tag_WMMX_arch, (=11), uleb128
  public static final /*uint*/int AllowWMMXv1 = 1; // The user permitted this entity to use WMMX v1
  public static final /*uint*/int AllowWMMXv2 = 2; // The user permitted this entity to use WMMX v2
  
  // Tag_Advanced_SIMD_arch, (=12), uleb128
  public static final /*uint*/int AllowNeon = 1; // SIMDv1 was permitted
  public static final /*uint*/int AllowNeon2 = 2; // SIMDv2 was permitted (Half-precision FP, MAC operations)
  public static final /*uint*/int AllowNeonARMv8 = 3; // ARM v8-A SIMD was permitted
  public static final /*uint*/int AllowNeonARMv8_1a = 4; // ARM v8.1-A SIMD was permitted (RDMA)
  
  // Tag_ABI_PCS_R9_use, (=14), uleb128
  public static final /*uint*/int R9IsGPR = 0; // R9 used as v6 (just another callee-saved register)
  public static final /*uint*/int R9IsSB = 1; // R9 used as a global static base rgister
  public static final /*uint*/int R9IsTLSPointer = 2; // R9 used as a thread local storage pointer
  public static final /*uint*/int R9Reserved = 3; // R9 not used by code associated with attributed entity
  
  // Tag_ABI_PCS_RW_data, (=15), uleb128
  public static final /*uint*/int AddressRWPCRel = 1; // Address RW static data PC-relative
  public static final /*uint*/int AddressRWSBRel = 2; // Address RW static data SB-relative
  public static final /*uint*/int AddressRWNone = 3; // No RW static data permitted
  
  // Tag_ABI_PCS_RO_data, (=14), uleb128
  public static final /*uint*/int AddressROPCRel = 1; // Address RO static data PC-relative
  public static final /*uint*/int AddressRONone = 2; // No RO static data permitted
  
  // Tag_ABI_PCS_GOT_use, (=17), uleb128
  public static final /*uint*/int AddressDirect = 1; // Address imported data directly
  public static final /*uint*/int AddressGOT = 2; // Address imported data indirectly (via GOT)
  
  // Tag_ABI_PCS_wchar_t, (=18), uleb128
  public static final /*uint*/int WCharProhibited = 0; // wchar_t is not used
  public static final /*uint*/int WCharWidth2Bytes = 2; // sizeof(wchar_t) == 2
  public static final /*uint*/int WCharWidth4Bytes = 4; // sizeof(wchar_t) == 4
  
  // Tag_ABI_FP_denormal, (=20), uleb128
  public static final /*uint*/int PositiveZero = 0;
  public static final /*uint*/int IEEEDenormals = 1;
  public static final /*uint*/int PreserveFPSign = 2; // sign when flushed-to-zero is preserved
  
  // Tag_ABI_FP_number_model, (=23), uleb128
  public static final /*uint*/int AllowRTABI = 2; // numbers, infinities, and one quiet NaN (see [RTABI])
  public static final /*uint*/int AllowIEE754 = 3; // this code to use all the IEEE 754-defined FP encodings
  
  // Tag_ABI_enum_size, (=26), uleb128
  public static final /*uint*/int EnumProhibited = 0; // The user prohibited the use of enums when building
  // this entity.
  public static final /*uint*/int EnumSmallest = 1; // Enum is smallest container big enough to hold all
  // values.
  public static final /*uint*/int Enum32Bit = 2; // Enum is at least 32 bits.
  public static final /*uint*/int Enum32BitABI = 3; // Every enumeration visible across an ABI-complying
  // interface contains a value needing 32 bits to encode
  // it; other enums can be containerized.
  
  // Tag_ABI_HardFP_use, (=27), uleb128
  public static final /*uint*/int HardFPImplied = 0; // FP use should be implied by Tag_FP_arch
  public static final /*uint*/int HardFPSinglePrecision = 1; // Single-precision only
  
  // Tag_ABI_VFP_args, (=28), uleb128
  public static final /*uint*/int BaseAAPCS = 0;
  public static final /*uint*/int HardFPAAPCS = 1;
  
  // Tag_FP_HP_extension, (=36), uleb128
  public static final /*uint*/int AllowHPFP = 1; // Allow use of Half Precision FP
  
  // Tag_FP_16bit_format, (=38), uleb128
  public static final /*uint*/int FP16FormatIEEE = 1;
  
  // Tag_MPextension_use, (=42), uleb128
  public static final /*uint*/int AllowMP = 1; // Allow use of MP extensions
  
  // Tag_DIV_use, (=44), uleb128
  // Note: AllowDIVExt must be emitted if and only if the permission to use
  // hardware divide cannot be conveyed using AllowDIVIfExists or DisallowDIV
  public static final /*uint*/int AllowDIVIfExists = 0; // Allow hardware divide if available in arch, or no
  // info exists.
  public static final /*uint*/int DisallowDIV = 1; // Hardware divide explicitly disallowed.
  public static final /*uint*/int AllowDIVExt = 2; // Allow hardware divide as optional architecture
  // extension above the base arch specified by
  // Tag_CPU_arch and Tag_CPU_arch_profile.
  
  // Tag_Virtualization_use, (=68), uleb128
  public static final /*uint*/int AllowTZ = 1;
  public static final /*uint*/int AllowVirtualization = 2;
  public static final /*uint*/int AllowTZVirtualization = 3;
/*}*/
} // END OF class ARMBuildAttrs
