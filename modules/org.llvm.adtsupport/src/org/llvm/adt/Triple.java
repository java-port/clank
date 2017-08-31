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

package org.llvm.adt;

import org.llvm.support.target.ARM;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.StringRefStatics;
import static org.llvm.support.impl.TripleStatics.*;


/// Triple - Helper class for working with autoconf configuration names. For
/// historical reasons, we also call these 'triples' (they used to contain
/// exactly three fields).
///
/// Configuration names are strings in the canonical form:
///   ARCHITECTURE-VENDOR-OPERATING_SYSTEM
/// or
///   ARCHITECTURE-VENDOR-OPERATING_SYSTEM-ENVIRONMENT
///
/// This class is used for clients which want to support arbitrary
/// configuration names, but also want to implement certain special
/// behavior for particular configurations. This class isolates the mapping
/// from the components of the configuration name to well known IDs.
///
/// At its core the Triple class is designed to be a wrapper for a triple
/// string; the constructor does not change or normalize the triple string.
/// Clients that need to handle the non-canonical triples that users often
/// specify should use the normalize method.
///
/// See autoconf/config.guess for a glimpse into what configuration names
/// look like in practice.
//<editor-fold defaultstate="collapsed" desc="llvm::Triple">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 44,
 FQN="llvm::Triple", NM="_ZN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6TripleE")
//</editor-fold>
public class Triple implements Destructors.ClassWithDestructor, Native.NativeComparable<Triple>, NativeCloneable<Triple> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::ArchType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 46,
   FQN="llvm::Triple::ArchType", NM="_ZN4llvm6Triple8ArchTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6Triple8ArchTypeE")
  //</editor-fold>
  public enum ArchType implements Native.ComparableLower {
    UnknownArch(0),
    
    arm(UnknownArch.getValue() + 1), // ARM (little endian): arm, armv.*, xscale
    armeb(arm.getValue() + 1), // ARM (big endian): armeb
    aarch64(armeb.getValue() + 1), // AArch64 (little endian): aarch64
    aarch64_be(aarch64.getValue() + 1), // AArch64 (big endian): aarch64_be
    avr(aarch64_be.getValue() + 1), // AVR: Atmel AVR microcontroller
    bpfel(avr.getValue() + 1), // eBPF or extended BPF or 64-bit BPF (little endian)
    bpfeb(bpfel.getValue() + 1), // eBPF or extended BPF or 64-bit BPF (big endian)
    hexagon(bpfeb.getValue() + 1), // Hexagon: hexagon
    mips(hexagon.getValue() + 1), // MIPS: mips, mipsallegrex
    mipsel(mips.getValue() + 1), // MIPSEL: mipsel, mipsallegrexel
    mips64(mipsel.getValue() + 1), // MIPS64: mips64
    mips64el(mips64.getValue() + 1), // MIPS64EL: mips64el
    msp430(mips64el.getValue() + 1), // MSP430: msp430
    ppc(msp430.getValue() + 1), // PPC: powerpc
    ppc64(ppc.getValue() + 1), // PPC64: powerpc64, ppu
    ppc64le(ppc64.getValue() + 1), // PPC64LE: powerpc64le
    r600(ppc64le.getValue() + 1), // R600: AMD GPUs HD2XXX - HD6XXX
    amdgcn(r600.getValue() + 1), // AMDGCN: AMD GCN GPUs
    sparc(amdgcn.getValue() + 1), // Sparc: sparc
    sparcv9(sparc.getValue() + 1), // Sparcv9: Sparcv9
    sparcel(sparcv9.getValue() + 1), // Sparc: (endianness = little). NB: 'Sparcle' is a CPU variant
    systemz(sparcel.getValue() + 1), // SystemZ: s390x
    tce(systemz.getValue() + 1), // TCE (http://tce.cs.tut.fi/): tce
    thumb(tce.getValue() + 1), // Thumb (little endian): thumb, thumbv.*
    thumbeb(thumb.getValue() + 1), // Thumb (big endian): thumbeb
    x86(thumbeb.getValue() + 1), // X86: i[3-9]86
    x86_64(x86.getValue() + 1), // X86-64: amd64, x86_64
    xcore(x86_64.getValue() + 1), // XCore: xcore
    nvptx(xcore.getValue() + 1), // NVPTX: 32-bit
    nvptx64(nvptx.getValue() + 1), // NVPTX: 64-bit
    le32(nvptx64.getValue() + 1), // le32: generic little-endian 32-bit CPU (PNaCl)
    le64(le32.getValue() + 1), // le64: generic little-endian 64-bit CPU (PNaCl)
    amdil(le64.getValue() + 1), // AMDIL
    amdil64(amdil.getValue() + 1), // AMDIL with 64-bit pointers
    hsail(amdil64.getValue() + 1), // AMD HSAIL
    hsail64(hsail.getValue() + 1), // AMD HSAIL with 64-bit pointers
    spir(hsail64.getValue() + 1), // SPIR: standard portable IR for OpenCL 32-bit version
    spir64(spir.getValue() + 1), // SPIR: standard portable IR for OpenCL 64-bit version
    kalimba(spir64.getValue() + 1), // Kalimba: generic kalimba
    shave(kalimba.getValue() + 1), // SHAVE: Movidius vector VLIW processors
    lanai(shave.getValue() + 1), // Lanai: Lanai 32-bit
    wasm32(lanai.getValue() + 1), // WebAssembly with 32-bit pointers
    wasm64(wasm32.getValue() + 1), // WebAssembly with 64-bit pointers
    renderscript32(wasm64.getValue() + 1), // 32-bit RenderScript
    renderscript64(renderscript32.getValue() + 1), // 64-bit RenderScript
    LastArchType(ArchType.renderscript64.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ArchType valueOf(int val) {
      ArchType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ArchType[] VALUES;
      private static final ArchType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ArchType kind : ArchType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ArchType[min < 0 ? (1-min) : 0];
        VALUES = new ArchType[max >= 0 ? (1+max) : 0];
        for (ArchType kind : ArchType.values()) {
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
    private ArchType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ArchType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ArchType)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::SubArchType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 96,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 93,
   FQN="llvm::Triple::SubArchType", NM="_ZN4llvm6Triple11SubArchTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6Triple11SubArchTypeE")
  //</editor-fold>
  public enum SubArchType implements Native.ComparableLower {
    NoSubArch(0),
    
    ARMSubArch_v8_2a(NoSubArch.getValue() + 1),
    ARMSubArch_v8_1a(ARMSubArch_v8_2a.getValue() + 1),
    ARMSubArch_v8(ARMSubArch_v8_1a.getValue() + 1),
    ARMSubArch_v8m_baseline(ARMSubArch_v8.getValue() + 1),
    ARMSubArch_v8m_mainline(ARMSubArch_v8m_baseline.getValue() + 1),
    ARMSubArch_v7(ARMSubArch_v8m_mainline.getValue() + 1),
    ARMSubArch_v7em(ARMSubArch_v7.getValue() + 1),
    ARMSubArch_v7m(ARMSubArch_v7em.getValue() + 1),
    ARMSubArch_v7s(ARMSubArch_v7m.getValue() + 1),
    ARMSubArch_v7k(ARMSubArch_v7s.getValue() + 1),
    ARMSubArch_v6(ARMSubArch_v7k.getValue() + 1),
    ARMSubArch_v6m(ARMSubArch_v6.getValue() + 1),
    ARMSubArch_v6k(ARMSubArch_v6m.getValue() + 1),
    ARMSubArch_v6t2(ARMSubArch_v6k.getValue() + 1),
    ARMSubArch_v5(ARMSubArch_v6t2.getValue() + 1),
    ARMSubArch_v5te(ARMSubArch_v5.getValue() + 1),
    ARMSubArch_v4t(ARMSubArch_v5te.getValue() + 1),
    
    KalimbaSubArch_v3(ARMSubArch_v4t.getValue() + 1),
    KalimbaSubArch_v4(KalimbaSubArch_v3.getValue() + 1),
    KalimbaSubArch_v5(KalimbaSubArch_v4.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SubArchType valueOf(int val) {
      SubArchType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SubArchType[] VALUES;
      private static final SubArchType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SubArchType kind : SubArchType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SubArchType[min < 0 ? (1-min) : 0];
        VALUES = new SubArchType[max >= 0 ? (1+max) : 0];
        for (SubArchType kind : SubArchType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SubArchType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SubArchType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SubArchType)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::VendorType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 121,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 116,
   FQN="llvm::Triple::VendorType", NM="_ZN4llvm6Triple10VendorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6Triple10VendorTypeE")
  //</editor-fold>
  public enum VendorType implements Native.ComparableLower {
    UnknownVendor(0),
    
    Apple(UnknownVendor.getValue() + 1),
    PC(Apple.getValue() + 1),
    SCEI(PC.getValue() + 1),
    BGP(SCEI.getValue() + 1),
    BGQ(BGP.getValue() + 1),
    Freescale(BGQ.getValue() + 1),
    IBM(Freescale.getValue() + 1),
    ImaginationTechnologies(IBM.getValue() + 1),
    MipsTechnologies(ImaginationTechnologies.getValue() + 1),
    NVIDIA(MipsTechnologies.getValue() + 1),
    CSR(NVIDIA.getValue() + 1),
    Myriad(CSR.getValue() + 1),
    AMD(Myriad.getValue() + 1),
    Mesa(AMD.getValue() + 1),
    LastVendorType(VendorType.Mesa.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static VendorType valueOf(int val) {
      VendorType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final VendorType[] VALUES;
      private static final VendorType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (VendorType kind : VendorType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new VendorType[min < 0 ? (1-min) : 0];
        VALUES = new VendorType[max >= 0 ? (1+max) : 0];
        for (VendorType kind : VendorType.values()) {
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
    private VendorType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((VendorType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((VendorType)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::OSType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 140,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 133,
   FQN="llvm::Triple::OSType", NM="_ZN4llvm6Triple6OSTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6Triple6OSTypeE")
  //</editor-fold>
  public enum OSType implements Native.ComparableLower {
    UnknownOS(0),
    
    CloudABI(UnknownOS.getValue() + 1),
    Darwin(CloudABI.getValue() + 1),
    DragonFly(Darwin.getValue() + 1),
    FreeBSD(DragonFly.getValue() + 1),
    IOS(FreeBSD.getValue() + 1),
    KFreeBSD(IOS.getValue() + 1),
    Linux(KFreeBSD.getValue() + 1),
    Lv2(Linux.getValue() + 1), // PS3
    MacOSX(Lv2.getValue() + 1),
    NetBSD(MacOSX.getValue() + 1),
    OpenBSD(NetBSD.getValue() + 1),
    Solaris(OpenBSD.getValue() + 1),
    Win32(Solaris.getValue() + 1),
    Haiku(Win32.getValue() + 1),
    Minix(Haiku.getValue() + 1),
    RTEMS(Minix.getValue() + 1),
    NaCl(RTEMS.getValue() + 1), // Native Client
    CNK(NaCl.getValue() + 1), // BG/P Compute-Node Kernel
    Bitrig(CNK.getValue() + 1),
    AIX(Bitrig.getValue() + 1),
    CUDA(AIX.getValue() + 1), // NVIDIA CUDA
    NVCL(CUDA.getValue() + 1), // NVIDIA OpenCL
    AMDHSA(NVCL.getValue() + 1), // AMD HSA Runtime
    PS4(AMDHSA.getValue() + 1),
    ELFIAMCU(PS4.getValue() + 1),
    TvOS(ELFIAMCU.getValue() + 1), // Apple tvOS
    WatchOS(TvOS.getValue() + 1), // Apple watchOS
    Mesa3D(WatchOS.getValue() + 1),
    LastOSType(OSType.Mesa3D.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static OSType valueOf(int val) {
      OSType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final OSType[] VALUES;
      private static final OSType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (OSType kind : OSType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new OSType[min < 0 ? (1-min) : 0];
        VALUES = new OSType[max >= 0 ? (1+max) : 0];
        for (OSType kind : OSType.values()) {
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
    private OSType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((OSType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((OSType)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::EnvironmentType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 173,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 165,
   FQN="llvm::Triple::EnvironmentType", NM="_ZN4llvm6Triple15EnvironmentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6Triple15EnvironmentTypeE")
  //</editor-fold>
  public enum EnvironmentType implements Native.ComparableLower {
    UnknownEnvironment(0),
    
    GNU(UnknownEnvironment.getValue() + 1),
    GNUABI64(GNU.getValue() + 1),
    GNUEABI(GNUABI64.getValue() + 1),
    GNUEABIHF(GNUEABI.getValue() + 1),
    GNUX32(GNUEABIHF.getValue() + 1),
    CODE16(GNUX32.getValue() + 1),
    EABI(CODE16.getValue() + 1),
    EABIHF(EABI.getValue() + 1),
    Android(EABIHF.getValue() + 1),
    Musl(Android.getValue() + 1),
    MuslEABI(Musl.getValue() + 1),
    MuslEABIHF(MuslEABI.getValue() + 1),
    
    MSVC(MuslEABIHF.getValue() + 1),
    Itanium(MSVC.getValue() + 1),
    Cygnus(Itanium.getValue() + 1),
    AMDOpenCL(Cygnus.getValue() + 1),
    CoreCLR(AMDOpenCL.getValue() + 1),
    LastEnvironmentType(EnvironmentType.CoreCLR.getValue());

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static EnvironmentType valueOf(int val) {
      EnvironmentType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final EnvironmentType[] VALUES;
      private static final EnvironmentType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (EnvironmentType kind : EnvironmentType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new EnvironmentType[min < 0 ? (1-min) : 0];
        VALUES = new EnvironmentType[max >= 0 ? (1+max) : 0];
        for (EnvironmentType kind : EnvironmentType.values()) {
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
    private EnvironmentType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((EnvironmentType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((EnvironmentType)obj).value);}
    //</editor-fold>
  };
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::ObjectFormatType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 196,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 184,
   FQN="llvm::Triple::ObjectFormatType", NM="_ZN4llvm6Triple16ObjectFormatTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6Triple16ObjectFormatTypeE")
  //</editor-fold>
  public enum ObjectFormatType implements Native.ComparableLower {
    UnknownObjectFormat(0),
    
    COFF(UnknownObjectFormat.getValue() + 1),
    ELF(COFF.getValue() + 1),
    MachO(ELF.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ObjectFormatType valueOf(int val) {
      ObjectFormatType out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ObjectFormatType[] VALUES;
      private static final ObjectFormatType[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ObjectFormatType kind : ObjectFormatType.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ObjectFormatType[min < 0 ? (1-min) : 0];
        VALUES = new ObjectFormatType[max >= 0 ? (1+max) : 0];
        for (ObjectFormatType kind : ObjectFormatType.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ObjectFormatType(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ObjectFormatType)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ObjectFormatType)obj).value);}
    //</editor-fold>
  };
/*private:*/
  private std.string Data;
  
  /// The parsed arch type.
  private ArchType Arch;
  
  /// The parsed subarchitecture type.
  private SubArchType SubArch;
  
  /// The parsed vendor type.
  private VendorType Vendor;
  
  /// The parsed OS type.
  private OSType OS;
  
  /// The parsed Environment type.
  private EnvironmentType Environment;
  
  /// The object format type.
  private ObjectFormatType ObjectFormat;
/*public:*/
  /// @name Constructors
  /// @{
  
  /// Default constructor is the same as an empty string and leaves all
  /// triple fields unknown.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::Triple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 231,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 219,
   FQN="llvm::Triple::Triple", NM="_ZN4llvm6TripleC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6TripleC1Ev")
  //</editor-fold>
  public Triple() {
    /* : Data(), Arch(implicit ArchType()), Vendor(implicit VendorType()), OS(implicit OSType()), Environment(implicit EnvironmentType()), ObjectFormat(implicit ObjectFormatType())*/ 
    //START JInit
    this.Data = new std.string();
    this.Arch = /*implicit-init*/ArchType.valueOf(/*zero-init*/0);
    this.Vendor = /*implicit-init*/VendorType.valueOf(/*zero-init*/0);
    this.OS = /*implicit-init*/OSType.valueOf(/*zero-init*/0);
    this.Environment = /*implicit-init*/EnvironmentType.valueOf(/*zero-init*/0);
    this.ObjectFormat = /*implicit-init*/ObjectFormatType.valueOf(/*zero-init*/0);
    //END JInit
  }

  
  /// \brief Construct a triple from the string representation provided.
  ///
  /// This stores the string representation and parses the various pieces into
  /// enum members.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::Triple">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 635,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 603,
   FQN="llvm::Triple::Triple", NM="_ZN4llvm6TripleC1ERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6TripleC1ERKNS_5TwineE")
  //</editor-fold>
  public Triple(/*const*/ Twine /*&*/ Str) {
    /* : Data(Str.str()), Arch(UnknownArch), SubArch(NoSubArch), Vendor(UnknownVendor), OS(UnknownOS), Environment(UnknownEnvironment), ObjectFormat(UnknownObjectFormat)*/ 
    //START JInit
    this.Data = Str.str();
    this.Arch = ArchType.UnknownArch;
    this.SubArch = SubArchType.NoSubArch;
    this.Vendor = VendorType.UnknownVendor;
    this.OS = OSType.UnknownOS;
    this.Environment = EnvironmentType.UnknownEnvironment;
    this.ObjectFormat = ObjectFormatType.UnknownObjectFormat;
    //END JInit
    // Do minimal parsing by hand here.
    SmallVector<StringRef> Components/*J*/= new SmallVector<StringRef>(4, new StringRef());
    new StringRef(Data).split(Components, StringRef.R$MINUS, /*MaxSplit*/ 3);
    if ($greater_uint(Components.size(), 0)) {
      Arch = parseArch(/*NO_COPY*/Components.$at(0));
      SubArch = parseSubArch(/*NO_COPY*/Components.$at(0));
      if ($greater_uint(Components.size(), 1)) {
        Vendor = parseVendor(/*NO_COPY*/Components.$at(1));
        if ($greater_uint(Components.size(), 2)) {
          OS = parseOS(/*NO_COPY*/Components.$at(2));
          if ($greater_uint(Components.size(), 3)) {
            Environment = parseEnvironment(/*NO_COPY*/Components.$at(3));
            ObjectFormat = parseFormat(/*NO_COPY*/Components.$at(3));
          }
        }
      }
    }
    if (ObjectFormat == ObjectFormatType.UnknownObjectFormat) {
      ObjectFormat = getDefaultFormat(/*Deref*/this);
    }
  }


  
  /// \brief Construct a triple from string representations of the architecture,
  /// vendor, and OS.
  ///
  /// This joins each argument into a canonical string representation and parses
  /// them into enum members. It leaves the environment unknown and omits it from
  /// the string representation.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::Triple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 666,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 634,
   FQN="llvm::Triple::Triple", NM="_ZN4llvm6TripleC1ERKNS_5TwineES3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6TripleC1ERKNS_5TwineES3_S3_")
  //</editor-fold>
  public Triple(/*const*/ Twine /*&*/ ArchStr, /*const*/ Twine /*&*/ VendorStr, /*const*/ Twine /*&*/ OSStr) {
    /* : Data((ArchStr + Twine('-') + VendorStr + Twine('-') + OSStr).str()), Arch(parseArch(ArchStr.str())), SubArch(parseSubArch(ArchStr.str())), Vendor(parseVendor(VendorStr.str())), OS(parseOS(OSStr.str())), Environment(implicit EnvironmentType()), ObjectFormat(Triple::UnknownObjectFormat)*/ 
    //START JInit
    this.Data = ($add_Twine($add_Twine($add_Twine($add_Twine(ArchStr, new Twine(JD$Char.INSTANCE, $$MINUS)), VendorStr), new Twine(JD$Char.INSTANCE, $$MINUS)), OSStr)).str();
    this.Arch = parseArch(new StringRef(ArchStr.str()));
    this.SubArch = parseSubArch(new StringRef(ArchStr.str()));
    this.Vendor = parseVendor(new StringRef(VendorStr.str()));
    this.OS = parseOS(new StringRef(OSStr.str()));
    this.Environment = /*implicit-init*/EnvironmentType.valueOf(/*zero-init*/0);
    this.ObjectFormat = Triple.ObjectFormatType.UnknownObjectFormat;
    //END JInit
    ObjectFormat = getDefaultFormat(/*Deref*/this);
  }


  
  /// \brief Construct a triple from string representations of the architecture,
  /// vendor, OS, and environment.
  ///
  /// This joins each argument into a canonical string representation and parses
  /// them into enum members.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::Triple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 681,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 649,
   FQN="llvm::Triple::Triple", NM="_ZN4llvm6TripleC1ERKNS_5TwineES3_S3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6TripleC1ERKNS_5TwineES3_S3_S3_")
  //</editor-fold>
  public Triple(/*const*/ Twine /*&*/ ArchStr, /*const*/ Twine /*&*/ VendorStr, /*const*/ Twine /*&*/ OSStr, 
      /*const*/ Twine /*&*/ EnvironmentStr) {
    /* : Data((ArchStr + Twine('-') + VendorStr + Twine('-') + OSStr + Twine('-') + EnvironmentStr).str()), Arch(parseArch(ArchStr.str())), SubArch(parseSubArch(ArchStr.str())), Vendor(parseVendor(VendorStr.str())), OS(parseOS(OSStr.str())), Environment(parseEnvironment(EnvironmentStr.str())), ObjectFormat(parseFormat(EnvironmentStr.str()))*/ 
    //START JInit
    this.Data = ($add_Twine($add_Twine($add_Twine($add_Twine($add_Twine($add_Twine(ArchStr, new Twine(JD$Char.INSTANCE, $$MINUS)), VendorStr), new Twine(JD$Char.INSTANCE, $$MINUS)), OSStr), new Twine(JD$Char.INSTANCE, $$MINUS)), 
        EnvironmentStr)).str();
    this.Arch = parseArch(new StringRef(ArchStr.str()));
    this.SubArch = parseSubArch(new StringRef(ArchStr.str()));
    this.Vendor = parseVendor(new StringRef(VendorStr.str()));
    this.OS = parseOS(new StringRef(OSStr.str()));
    this.Environment = parseEnvironment(new StringRef(EnvironmentStr.str()));
    this.ObjectFormat = parseFormat(new StringRef(EnvironmentStr.str()));
    //END JInit
    if (ObjectFormat == Triple.ObjectFormatType.UnknownObjectFormat) {
      ObjectFormat = getDefaultFormat(/*Deref*/this);
    }
  }


  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::operator==">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 238,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 226,
   FQN="llvm::Triple::operator==", NM="_ZNK4llvm6TripleeqERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6TripleeqERKS0_")
  //</editor-fold>
  public boolean $eq(/*const*/ Triple /*&*/ Other) /*const*/ {
    return Arch == Other.Arch && SubArch == Other.SubArch
       && Vendor == Other.Vendor && OS == Other.OS
       && Environment == Other.Environment
       && ObjectFormat == Other.ObjectFormat;
  }

  
  /// @}
  /// @name Normalization
  /// @{
  
  /// normalize - Turn an arbitrary machine specification into the canonical
  /// triple form (or something sensible that the Triple class understands if
  /// nothing better can reasonably be done).  In particular, it handles the
  /// common case in which otherwise valid components are in the wrong order.
  
  /// @}
  /// @name Normalization
  /// @{
  
  /// normalize - Turn an arbitrary machine specification into the canonical
  /// triple form (or something sensible that the Triple class understands if
  /// nothing better can reasonably be done).  In particular, it handles the
  /// common case in which otherwise valid components are in the wrong order.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::normalize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 695,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 663,
   FQN="llvm::Triple::normalize", NM="_ZN4llvm6Triple9normalizeENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple9normalizeENS_9StringRefE")
  //</editor-fold>
  public static std.string normalize(StringRef Str) {
    boolean IsMinGW32 = false;
    boolean IsCygwin = false;
    
    // Parse into components.
    SmallVector<StringRef> Components/*J*/= new SmallVector<StringRef>(4, new StringRef());
    Str.split(Components, StringRef.R$MINUS);
    
    // If the first component corresponds to a known architecture, preferentially
    // use it for the architecture.  If the second component corresponds to a
    // known vendor, preferentially use it for the vendor, etc.  This avoids silly
    // component movement when a component parses as (eg) both a valid arch and a
    // valid os.
    ArchType Arch = ArchType.UnknownArch;
    if ($greater_uint(Components.size(), 0)) {
      Arch = parseArch(/*NO_COPY*/Components.$at(0));
    }
    VendorType Vendor = VendorType.UnknownVendor;
    if ($greater_uint(Components.size(), 1)) {
      Vendor = parseVendor(/*NO_COPY*/Components.$at(1));
    }
    OSType OS = OSType.UnknownOS;
    if ($greater_uint(Components.size(), 2)) {
      OS = parseOS(/*NO_COPY*/Components.$at(2));
      IsCygwin = Components.$at(2).startswith(/*STRINGREF_STR*/"cygwin");
      IsMinGW32 = Components.$at(2).startswith(/*STRINGREF_STR*/"mingw");
    }
    EnvironmentType Environment = EnvironmentType.UnknownEnvironment;
    if ($greater_uint(Components.size(), 3)) {
      Environment = parseEnvironment(/*NO_COPY*/Components.$at(3));
    }
    ObjectFormatType ObjectFormat = ObjectFormatType.UnknownObjectFormat;
    if ($greater_uint(Components.size(), 4)) {
      ObjectFormat = parseFormat(/*NO_COPY*/Components.$at(4));
    }
    
    // Note which components are already in their final position.  These will not
    // be moved.
    boolean Found[/*4*/] = new$bool(4);
    Found[0] = Arch != ArchType.UnknownArch;
    Found[1] = Vendor != VendorType.UnknownVendor;
    Found[2] = OS != OSType.UnknownOS;
    Found[3] = Environment != EnvironmentType.UnknownEnvironment;
    
    // If they are not there already, permute the components into their canonical
    // positions by seeing if they parse as a valid architecture, and if so moving
    // the component to the architecture position etc.
    for (/*uint*/int Pos = 0; Pos != array_lengthof(Found); ++Pos) {
      if (Found[Pos]) {
        continue; // Already in the canonical position.
      }
      
      for (/*uint*/int Idx = 0; Idx != Components.size(); ++Idx) {
        // Do not reparse any components that already matched.
        if ($less_uint(Idx, array_lengthof(Found)) && Found[Idx]) {
          continue;
        }
        
        // Does this component parse as valid for the target position?
        boolean Valid = false;
        // VV: we need to copy, owerwise swap below changes reference at index
        // VV: together with this Comp variable        
        StringRef Comp = new StringRef(Components.$at(Idx));
        switch (Pos) {
         default:
          throw new llvm_unreachable("unexpected component type!");
         case 0:
          Arch = parseArch(/*NO_COPY*/Comp);
          Valid = Arch != ArchType.UnknownArch;
          break;
         case 1:
          Vendor = parseVendor(/*NO_COPY*/Comp);
          Valid = Vendor != VendorType.UnknownVendor;
          break;
         case 2:
          OS = parseOS(/*NO_COPY*/Comp);
          IsCygwin = Comp.startswith(/*STRINGREF_STR*/"cygwin");
          IsMinGW32 = Comp.startswith(/*STRINGREF_STR*/"mingw");
          Valid = OS != OSType.UnknownOS || IsCygwin || IsMinGW32;
          break;
         case 3:
          Environment = parseEnvironment(/*NO_COPY*/Comp);
          Valid = Environment != EnvironmentType.UnknownEnvironment;
          if (!Valid) {
            ObjectFormat = parseFormat(/*NO_COPY*/Comp);
            Valid = ObjectFormat != ObjectFormatType.UnknownObjectFormat;
          }
          break;
        }
        if (!Valid) {
          continue; // Nope, try the next component.
        }
        
        // Move the component to the target position, pushing any non-fixed
        // components that are in the way to the right.  This tends to give
        // good results in the common cases of a forgotten vendor component
        // or a wrongly positioned environment.
        if ($less_uint(Pos, Idx)) {
          // Insert left, pushing the existing components to the right.  For
          // example, a-b-i386 -> i386-a-b when moving i386 to the front.
          StringRef CurrentComponent/*J*/= new StringRef(/*KEEP_STR*/$EMPTY); // The empty component.
          // Replace the component we are moving with an empty component.
          StringRefStatics.swap(CurrentComponent, Components.$at(Idx));
          // Insert the component being moved at Pos, displacing any existing
          // components to the right.
          for (/*uint*/int i = Pos; !CurrentComponent.empty(); ++i) {
            // Skip over any fixed components.
            while ($less_uint(i, array_lengthof(Found)) && Found[i]) {
              ++i;
            }
            // Place the component at the new position, getting the component
            // that was at this position - it will be moved right.
            StringRefStatics.swap(CurrentComponent, Components.$at(i));
          }
        } else if ($greater_uint(Pos, Idx)) {
          // Push right by inserting empty components until the component at Idx
          // reaches the target position Pos.  For example, pc-a -> -pc-a when
          // moving pc to the second position.
          do {
            // Insert one empty component at Idx.
            StringRef CurrentComponent/*J*/= new StringRef(/*KEEP_STR*/$EMPTY); // The empty component.
            for (/*uint*/int i = Idx; $less_uint(i, Components.size());) {
              // Place the component at the new position, getting the component
              // that was at this position - it will be moved right.
              StringRefStatics.swap(CurrentComponent, Components.$at(i));
              // If it was placed on top of an empty component then we are done.
              if (CurrentComponent.empty()) {
                break;
              }
              // Advance to the next component, skipping any fixed components.
              while ($less_uint(++i, array_lengthof(Found)) && Found[i]) {
                ;
              }
            }
            // The last component was pushed off the end - append it.
            if (!CurrentComponent.empty()) {
              Components.push_back(CurrentComponent);
            }
            
            // Advance Idx to the component's new position.
            while ($less_uint(++Idx, array_lengthof(Found)) && Found[Idx]) {
              ;
            }
          } while ($less_uint(Idx, Pos)); // Add more until the final position is reached.
        }
        assert ($less_uint(Pos, Components.size()) && $eq_StringRef(/*NO_COPY*/Components.$at(Pos), /*NO_COPY*/Comp)) : "Component moved wrong!";
        Found[Pos] = true;
        break;
      }
    }
    
    // Special case logic goes here.  At this point Arch, Vendor and OS have the
    // correct values for the computed components.
    std.string NormalizedEnvironment/*J*/= new std.string();
    if (Environment == Triple.EnvironmentType.Android && Components.$at(3).startswith(/*STRINGREF_STR*/"androideabi")) {
      StringRef AndroidVersion = Components.$at(3).drop_front(strlen($("androideabi")));
      if (AndroidVersion.empty()) {
        Components.$at(3).$assignMove(/*STRINGREF_STR*/"android");
      } else {
        NormalizedEnvironment.$assignMove(new Twine(/*KEEP_STR*/"android", AndroidVersion).str());
        Components.$at(3).$assignMove(new StringRef(NormalizedEnvironment));
      }
    }
    if (OS == Triple.OSType.Win32) {
      Components.resize(4);
      Components.$at(2).$assignMove(/*STRINGREF_STR*/"windows");
      if (Environment == EnvironmentType.UnknownEnvironment) {
        if (ObjectFormat == ObjectFormatType.UnknownObjectFormat || ObjectFormat == Triple.ObjectFormatType.COFF) {
          Components.$at(3).$assignMove(/*STRINGREF_STR*/"msvc");
        } else {
          Components.$at(3).$assignMove(/*STRINGREF_STR*/getObjectFormatTypeName(ObjectFormat));
        }
      }
    } else if (IsMinGW32) {
      Components.resize(4);
      Components.$at(2).$assignMove(/*STRINGREF_STR*/"windows");
      Components.$at(3).$assignMove(/*STRINGREF_STR*/"gnu");
    } else if (IsCygwin) {
      Components.resize(4);
      Components.$at(2).$assignMove(/*STRINGREF_STR*/"windows");
      Components.$at(3).$assignMove(/*STRINGREF_STR*/"cygnus");
    }
    if (IsMinGW32 || IsCygwin
       || (OS == Triple.OSType.Win32 && Environment != EnvironmentType.UnknownEnvironment)) {
      if (ObjectFormat != ObjectFormatType.UnknownObjectFormat && ObjectFormat != Triple.ObjectFormatType.COFF) {
        Components.resize(5);
        Components.$at(4).$assignMove(/*STRINGREF_STR*/getObjectFormatTypeName(ObjectFormat));
      }
    }
    
    // Stick the corrected components back together to form the normalized string.
    std.string Normalized/*J*/= new std.string();
    for (/*uint*/int i = 0, e = Components.size(); i != e; ++i) {
      if ((i != 0)) {
        Normalized.$addassign($$MINUS);
      }
      $addassign_str_StringRef(Normalized, /*NO_COPY*/Components.$at(i));
    }
    return Normalized;
  }


  
  /// Return the normalized form of this triple's string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::normalize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 256,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 244,
   FQN="llvm::Triple::normalize", NM="_ZNK4llvm6Triple9normalizeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9normalizeEv")
  //</editor-fold>
  public std.string normalize() /*const*/ {
    return normalize(new StringRef(Data));
  }

  
  /// @}
  /// @name Typed Component Access
  /// @{
  
  /// getArch - Get the parsed architecture type of this triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 263,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 251,
   FQN="llvm::Triple::getArch", NM="_ZNK4llvm6Triple7getArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple7getArchEv")
  //</editor-fold>
  public ArchType getArch() /*const*/ {
    return Arch;
  }

  
  /// getSubArch - get the parsed subarchitecture type for this triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getSubArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 266,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 254,
   FQN="llvm::Triple::getSubArch", NM="_ZNK4llvm6Triple10getSubArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple10getSubArchEv")
  //</editor-fold>
  public SubArchType getSubArch() /*const*/ {
    return SubArch;
  }

  
  /// getVendor - Get the parsed vendor type of this triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getVendor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 269,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 257,
   FQN="llvm::Triple::getVendor", NM="_ZNK4llvm6Triple9getVendorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9getVendorEv")
  //</editor-fold>
  public VendorType getVendor() /*const*/ {
    return Vendor;
  }

  
  /// getOS - Get the parsed operating system type of this triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 272,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 260,
   FQN="llvm::Triple::getOS", NM="_ZNK4llvm6Triple5getOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple5getOSEv")
  //</editor-fold>
  public OSType getOS() /*const*/ {
    return OS;
  }

  
  /// hasEnvironment - Does this triple have the optional environment
  /// (fourth) component?
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::hasEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 276,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 264,
   FQN="llvm::Triple::hasEnvironment", NM="_ZNK4llvm6Triple14hasEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple14hasEnvironmentEv")
  //</editor-fold>
  public boolean hasEnvironment() /*const*/ {
    return $noteq_StringRef(getEnvironmentName(), /*STRINGREF_STR*/"");
  }

  
  /// getEnvironment - Get the parsed environment type of this triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 281,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 269,
   FQN="llvm::Triple::getEnvironment", NM="_ZNK4llvm6Triple14getEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple14getEnvironmentEv")
  //</editor-fold>
  public EnvironmentType getEnvironment() /*const*/ {
    return Environment;
  }

  
  /// Parse the version number from the OS name component of the
  /// triple, if present.
  ///
  /// For example, "fooos1.2.3" would return (1, 2, 3).
  ///
  /// If an entry is not defined, it will be returned as 0.
  
  /// Parse the version number from the OS name component of the
  /// triple, if present.
  ///
  /// For example, "fooos1.2.3" would return (1, 2, 3).
  ///
  /// If an entry is not defined, it will be returned as 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getEnvironmentVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 941,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 909,
   FQN="llvm::Triple::getEnvironmentVersion", NM="_ZNK4llvm6Triple21getEnvironmentVersionERjS1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple21getEnvironmentVersionERjS1_S1_")
  //</editor-fold>
  public void getEnvironmentVersion(uint$ref/*uint &*/ Major, uint$ref/*uint &*/ Minor, 
                       uint$ref/*uint &*/ Micro) /*const*/ {
    StringRef EnvironmentName = getEnvironmentName();
    StringRef EnvironmentTypeName = new StringRef(getEnvironmentTypeName(getEnvironment()));
    if (EnvironmentName.startswith(/*NO_COPY*/EnvironmentTypeName)) {
      EnvironmentName.$assignMove(EnvironmentName.substr(EnvironmentTypeName.size()));
    }
    
    parseVersionFromName(/*NO_COPY*/EnvironmentName, Major, Minor, Micro);
  }


  
  /// getFormat - Get the object format for this triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getObjectFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 293,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 281,
   FQN="llvm::Triple::getObjectFormat", NM="_ZNK4llvm6Triple15getObjectFormatEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple15getObjectFormatEv")
  //</editor-fold>
  public ObjectFormatType getObjectFormat() /*const*/ {
    return ObjectFormat;
  }

  
  /// getOSVersion - Parse the version number from the OS name component of the
  /// triple, if present.
  ///
  /// For example, "fooos1.2.3" would return (1, 2, 3).
  ///
  /// If an entry is not defined, it will be returned as 0.
  
  /// getOSVersion - Parse the version number from the OS name component of the
  /// triple, if present.
  ///
  /// For example, "fooos1.2.3" would return (1, 2, 3).
  ///
  /// If an entry is not defined, it will be returned as 0.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getOSVersion">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 951,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 919,
   FQN="llvm::Triple::getOSVersion", NM="_ZNK4llvm6Triple12getOSVersionERjS1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple12getOSVersionERjS1_S1_")
  //</editor-fold>
  public void getOSVersion(uint$ref/*uint &*/ Major, uint$ref/*uint &*/ Minor, 
              uint$ref/*uint &*/ Micro) /*const*/ {
    StringRef OSName = getOSName();
    // Assume that the OS portion of the triple starts with the canonical name.
    StringRef OSTypeName = new StringRef(getOSTypeName(getOS()));
    if (OSName.startswith(/*NO_COPY*/OSTypeName)) {
      OSName.$assign$substr(OSTypeName.size());
    }
    
    parseVersionFromName(/*NO_COPY*/OSName, Major, Minor, Micro);
  }


  
  /// getOSMajorVersion - Return just the major version number, this is
  /// specialized because it is a common query.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getOSMajorVersion">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 305,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 293,
   FQN="llvm::Triple::getOSMajorVersion", NM="_ZNK4llvm6Triple17getOSMajorVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple17getOSMajorVersionEv")
  //</editor-fold>
  public /*uint*/int getOSMajorVersion() /*const*/ {
//    /*uint*/int Maj, Min, Micro;
    uint$ref Maj = create_uint$ref();
    uint$ref Min = create_uint$ref();
    uint$ref Micro = create_uint$ref();
    getOSVersion(Maj, Min, Micro);
    return Maj.$deref();
  }

  
  /// getMacOSXVersion - Parse the version number as with getOSVersion and then
  /// translate generic "darwin" versions to the corresponding OS X versions.
  /// This may also be called with IOS triples but the OS X version number is
  /// just set to a constant 10.4.0 in that case.  Returns true if successful.
  
  /// getMacOSXVersion - Parse the version number as with getOSVersion and then
  /// translate generic "darwin" versions to the corresponding OS X versions.
  /// This may also be called with IOS triples but the OS X version number is
  /// just set to a constant 10.4.0 in that case.  Returns true if successful.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getMacOSXVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 962,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 930,
   FQN="llvm::Triple::getMacOSXVersion", NM="_ZNK4llvm6Triple16getMacOSXVersionERjS1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple16getMacOSXVersionERjS1_S1_")
  //</editor-fold>
  public boolean getMacOSXVersion(uint$ref/*uint &*/ Major, uint$ref/*uint &*/ Minor, 
                  uint$ref/*uint &*/ Micro) /*const*/ {
    getOSVersion(Major, Minor, Micro);
    switch (getOS()) {
     default:
      throw new llvm_unreachable("unexpected OS for Darwin triple");
     case Darwin:
      // Default to darwin8, i.e., MacOSX 10.4.
      if (Major.$deref() == 0) {
        Major.$set(8);
      }
      // Darwin version numbers are skewed from OS X versions.
      if ($less_uint(Major.$deref(), 4)) {
        return false;
      }
      Micro.$set(0);
      Minor.$set(Major.$deref() - 4);
      Major.$set(10);
      break;
     case MacOSX:
      // Default to 10.4.
      if (Major.$deref() == 0) {
        Major.$set(10);
        Minor.$set(4);
      }
      if (Major.$deref() != 10) {
        return false;
      }
      break;
     case IOS:
     case TvOS:
     case WatchOS:
      // Ignore the version from the triple.  This is only handled because the
      // the clang driver combines OS X and IOS support into a common Darwin
      // toolchain that wants to know the OS X version number even when targeting
      // IOS.
      Major.$set(10);
      Minor.$set(4);
      Micro.$set(0);
      break;
    }
    return true;
  }


  
  /// getiOSVersion - Parse the version number as with getOSVersion.  This should
  /// only be called with IOS or generic triples.
  
  /// getiOSVersion - Parse the version number as with getOSVersion.  This should
  /// only be called with IOS or generic triples.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getiOSVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1003,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 971,
   FQN="llvm::Triple::getiOSVersion", NM="_ZNK4llvm6Triple13getiOSVersionERjS1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple13getiOSVersionERjS1_S1_")
  //</editor-fold>
  public void getiOSVersion(uint$ref/*uint &*/ Major, uint$ref/*uint &*/ Minor, 
               uint$ref/*uint &*/ Micro) /*const*/ {
    switch (getOS()) {
     default:
      throw new llvm_unreachable("unexpected OS for Darwin triple");
     case Darwin:
     case MacOSX:
      // Ignore the version from the triple.  This is only handled because the
      // the clang driver combines OS X and IOS support into a common Darwin
      // toolchain that wants to know the iOS version number even when targeting
      // OS X.
      Major.$set(5);
      Minor.$set(0);
      Micro.$set(0);
      break;
     case IOS:
     case TvOS:
      getOSVersion(Major, Minor, Micro);
      // Default to 5.0 (or 7.0 for arm64).
      if (Major.$deref() == 0) {
        Major.$set((getArch() == ArchType.aarch64) ? 7 : 5);
      }
      break;
     case WatchOS:
      throw new llvm_unreachable("conflicting triple info");
    }
  }


  
  /// getWatchOSVersion - Parse the version number as with getOSVersion.  This
  /// should only be called with WatchOS or generic triples.
  
  /// getWatchOSVersion - Parse the version number as with getOSVersion.  This
  /// should only be called with WatchOS or generic triples.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getWatchOSVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1029,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 997,
   FQN="llvm::Triple::getWatchOSVersion", NM="_ZNK4llvm6Triple17getWatchOSVersionERjS1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple17getWatchOSVersionERjS1_S1_")
  //</editor-fold>
  public void getWatchOSVersion(uint$ref/*uint &*/ Major, uint$ref/*uint &*/ Minor, 
                   uint$ref/*uint &*/ Micro) /*const*/ {
    switch (getOS()) {
     default:
      throw new llvm_unreachable("unexpected OS for Darwin triple");
     case Darwin:
     case MacOSX:
      // Ignore the version from the triple.  This is only handled because the
      // the clang driver combines OS X and IOS support into a common Darwin
      // toolchain that wants to know the iOS version number even when targeting
      // OS X.
      Major.$set(2);
      Minor.$set(0);
      Micro.$set(0);
      break;
     case WatchOS:
      getOSVersion(Major, Minor, Micro);
      if (Major.$deref() == 0) {
        Major.$set(2);
      }
      break;
     case IOS:
      throw new llvm_unreachable("conflicting triple info");
    }
  }


  
  /// @}
  /// @name Direct Component Access
  /// @{
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::str">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 332,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 320,
   FQN="llvm::Triple::str", NM="_ZNK4llvm6Triple3strEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple3strEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ str() /*const*/ {
    return Data;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 334,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 322,
   FQN="llvm::Triple::getTriple", NM="_ZNK4llvm6Triple9getTripleEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9getTripleEv")
  //</editor-fold>
  public /*const*/std.string/*&*/ getTriple() /*const*/ {
    return Data;
  }

  
  /// getArchName - Get the architecture (first) component of the
  /// triple.
  
  /// getArchName - Get the architecture (first) component of the
  /// triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getArchName">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,       
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 880,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 848,
   FQN="llvm::Triple::getArchName", NM="_ZNK4llvm6Triple11getArchNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple11getArchNameEv")
  //</editor-fold>
  public StringRef getArchName() /*const*/ {
    return new StringRef(Data).split($$MINUS).first; // Isolate first component
  }


  
  /// getVendorName - Get the vendor (second) component of the triple.
  
  /// getVendorName - Get the vendor (second) component of the triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getVendorName">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 884,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 852,
   FQN="llvm::Triple::getVendorName", NM="_ZNK4llvm6Triple13getVendorNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple13getVendorNameEv")
  //</editor-fold>
  public StringRef getVendorName() /*const*/ {
    StringRef Tmp = new StringRef(Data).split($$MINUS).second; // Strip first component
    return Tmp.split($$MINUS).first; // Isolate second component
  }


  
  /// getOSName - Get the operating system (third) component of the
  /// triple.
  
  /// getOSName - Get the operating system (third) component of the
  /// triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getOSName">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 889,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 857,
   FQN="llvm::Triple::getOSName", NM="_ZNK4llvm6Triple9getOSNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple9getOSNameEv")
  //</editor-fold>
  public StringRef getOSName() /*const*/ {
    StringRef Tmp = new StringRef(Data).split($$MINUS).second; // Strip first component
    Tmp.$assignMove(Tmp.split($$MINUS).second); // Strip second component
    return Tmp.split($$MINUS).first; // Isolate third component
  }


  
  /// getEnvironmentName - Get the optional environment (fourth)
  /// component of the triple, or "" if empty.
  
  /// getEnvironmentName - Get the optional environment (fourth)
  /// component of the triple, or "" if empty.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getEnvironmentName">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 895,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 863,
   FQN="llvm::Triple::getEnvironmentName", NM="_ZNK4llvm6Triple18getEnvironmentNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple18getEnvironmentNameEv")
  //</editor-fold>
  public StringRef getEnvironmentName() /*const*/ {
    StringRef Tmp = new StringRef(Data).split($$MINUS).second; // Strip first component
    Tmp.$assignMove(Tmp.split($$MINUS).second); // Strip second component
    return Tmp.split($$MINUS).second; // Strip third component
  }


  
  /// getOSAndEnvironmentName - Get the operating system and optional
  /// environment components as a single string (separated by a '-'
  /// if the environment component is present).
  
  /// getOSAndEnvironmentName - Get the operating system and optional
  /// environment components as a single string (separated by a '-'
  /// if the environment component is present).
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getOSAndEnvironmentName">
  @Converted(kind = Converted.Kind.MANUAL,
   optimized = Converted.Optimization.VALUE_TYPE,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 901,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 869,
   FQN="llvm::Triple::getOSAndEnvironmentName", NM="_ZNK4llvm6Triple23getOSAndEnvironmentNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple23getOSAndEnvironmentNameEv")
  //</editor-fold>
  public StringRef getOSAndEnvironmentName() /*const*/ {
    StringRef Tmp = new StringRef(Data).split($$MINUS).second; // Strip first component
    return Tmp.split($$MINUS).second; // Strip second component
  }


  
  /// @}
  /// @name Convenience Predicates
  /// @{
  
  /// Test whether the architecture is 64-bit
  ///
  /// Note that this tests for 64-bit pointer width, and nothing else. Note
  /// that we intentionally expose only three predicates, 64-bit, 32-bit, and
  /// 16-bit. The inner details of pointer width for particular architectures
  /// is not summed up in the triple, and so only a coarse grained predicate
  /// system is provided.
  
  /// @}
  /// @name Convenience Predicates
  /// @{
  
  /// Test whether the architecture is 64-bit
  ///
  /// Note that this tests for 64-bit pointer width, and nothing else. Note
  /// that we intentionally expose only three predicates, 64-bit, 32-bit, and
  /// 16-bit. The inner details of pointer width for particular architectures
  /// is not summed up in the triple, and so only a coarse grained predicate
  /// system is provided.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isArch64Bit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1176,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1141,
   FQN="llvm::Triple::isArch64Bit", NM="_ZNK4llvm6Triple11isArch64BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple11isArch64BitEv")
  //</editor-fold>
  public boolean isArch64Bit() /*const*/ {
    return getArchPointerBitWidth(getArch()) == 64;
  }


  
  /// Test whether the architecture is 32-bit
  ///
  /// Note that this tests for 32-bit pointer width, and nothing else.
  
  /// Test whether the architecture is 32-bit
  ///
  /// Note that this tests for 32-bit pointer width, and nothing else.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isArch32Bit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1180,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1145,
   FQN="llvm::Triple::isArch32Bit", NM="_ZNK4llvm6Triple11isArch32BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple11isArch32BitEv")
  //</editor-fold>
  public boolean isArch32Bit() /*const*/ {
    return getArchPointerBitWidth(getArch()) == 32;
  }


  
  /// Test whether the architecture is 16-bit
  ///
  /// Note that this tests for 16-bit pointer width, and nothing else.
  
  /// Test whether the architecture is 16-bit
  ///
  /// Note that this tests for 16-bit pointer width, and nothing else.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isArch16Bit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1184,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1149,
   FQN="llvm::Triple::isArch16Bit", NM="_ZNK4llvm6Triple11isArch16BitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple11isArch16BitEv")
  //</editor-fold>
  public boolean isArch16Bit() /*const*/ {
    return getArchPointerBitWidth(getArch()) == 16;
  }


  
  /// isOSVersionLT - Helper function for doing comparisons against version
  /// numbers included in the target triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSVersionLT">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 369,
   FQN="llvm::Triple::isOSVersionLT", NM="_ZNK4llvm6Triple13isOSVersionLTEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple13isOSVersionLTEjjj")
  //</editor-fold>
  public boolean isOSVersionLT(/*uint*/int Major) /*const*/ {
    return isOSVersionLT(Major, 0, 
               0);
  }
  public boolean isOSVersionLT(/*uint*/int Major, /*uint*/int Minor/*= 0*/) /*const*/ {
    return isOSVersionLT(Major, Minor, 
               0);
  }
  public boolean isOSVersionLT(/*uint*/int Major, /*uint*/int Minor/*= 0*/, 
               /*uint*/int Micro/*= 0*/) /*const*/ {
    /*uint*/int LHS[/*3*/] = new$uint(3);
    getOSVersion(create_uint$ref(LHS, 0), create_uint$ref(LHS, 1), create_uint$ref(LHS, 2));
    if (LHS[0] != Major) {
      return $less_uint(LHS[0], Major);
    }
    if (LHS[1] != Minor) {
      return $less_uint(LHS[1], Minor);
    }
    if (LHS[2] != Micro) {
      return $less_uint(LHS[1], Micro);
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSVersionLT">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 396,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 384,
   FQN="llvm::Triple::isOSVersionLT", NM="_ZNK4llvm6Triple13isOSVersionLTERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple13isOSVersionLTERKS0_")
  //</editor-fold>
  public boolean isOSVersionLT(/*const*/ Triple /*&*/ Other) /*const*/ {
    /*uint*/int RHS[/*3*/] = new$uint(3);
    Other.getOSVersion(create_uint$ref(RHS, 0), create_uint$ref(RHS, 1), create_uint$ref(RHS, 2));
    return isOSVersionLT(RHS[0], RHS[1], RHS[2]);
  }

  
  /// isMacOSXVersionLT - Comparison function for checking OS X version
  /// compatibility, which handles supporting skewed version numbering schemes
  /// used by the "darwin" triples.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isMacOSXVersionLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 405,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 393,
   FQN="llvm::Triple::isMacOSXVersionLT", NM="_ZNK4llvm6Triple17isMacOSXVersionLTEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple17isMacOSXVersionLTEjjj")
  //</editor-fold>
  public boolean isMacOSXVersionLT(/*uint*/int Major) /*const*/ {
    return isMacOSXVersionLT(Major, 0, 
                   0);
  }
  public boolean isMacOSXVersionLT(/*uint*/int Major, /*uint*/int Minor/*= 0*/) /*const*/ {
    return isMacOSXVersionLT(Major, Minor, 
                   0);
  }
  public boolean isMacOSXVersionLT(/*uint*/int Major, /*uint*/int Minor/*= 0*/, 
                   /*uint*/int Micro/*= 0*/) /*const*/ {
    assert (isMacOSX()) : "Not an OS X triple!";
    
    // If this is OS X, expect a sane version number.
    if (getOS() == Triple.OSType.MacOSX) {
      return isOSVersionLT(Major, Minor, Micro);
    }
    
    // Otherwise, compare to the "Darwin" number.
    assert (Major == 10) : "Unexpected major version";
    return isOSVersionLT(Minor + 4, Micro, 0);
  }

  
  /// isMacOSX - Is this a Mac OS X triple. For legacy reasons, we support both
  /// "darwin" and "osx" as OS X triples.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isMacOSX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 420,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 408,
   FQN="llvm::Triple::isMacOSX", NM="_ZNK4llvm6Triple8isMacOSXEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple8isMacOSXEv")
  //</editor-fold>
  public boolean isMacOSX() /*const*/ {
    return getOS() == Triple.OSType.Darwin || getOS() == Triple.OSType.MacOSX;
  }

  
  /// Is this an iOS triple.
  /// Note: This identifies tvOS as a variant of iOS. If that ever
  /// changes, i.e., if the two operating systems diverge or their version
  /// numbers get out of sync, that will need to be changed.
  /// watchOS has completely different version numbers so it is not included.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isiOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 429,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 417,
   FQN="llvm::Triple::isiOS", NM="_ZNK4llvm6Triple5isiOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple5isiOSEv")
  //</editor-fold>
  public boolean isiOS() /*const*/ {
    return getOS() == Triple.OSType.IOS || isTvOS();
  }

  
  /// Is this an Apple tvOS triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isTvOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 434,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 422,
   FQN="llvm::Triple::isTvOS", NM="_ZNK4llvm6Triple6isTvOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple6isTvOSEv")
  //</editor-fold>
  public boolean isTvOS() /*const*/ {
    return getOS() == Triple.OSType.TvOS;
  }

  
  /// Is this an Apple watchOS triple.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWatchOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 439,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 427,
   FQN="llvm::Triple::isWatchOS", NM="_ZNK4llvm6Triple9isWatchOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9isWatchOSEv")
  //</editor-fold>
  public boolean isWatchOS() /*const*/ {
    return getOS() == Triple.OSType.WatchOS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWatchABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 443,
   FQN="llvm::Triple::isWatchABI", NM="_ZNK4llvm6Triple10isWatchABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple10isWatchABIEv")
  //</editor-fold>
  public boolean isWatchABI() /*const*/ {
    return getSubArch() == Triple.SubArchType.ARMSubArch_v7k;
  }

  
  /// isOSDarwin - Is this a "Darwin" OS (OS X, iOS, or watchOS).
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSDarwin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 432,
   FQN="llvm::Triple::isOSDarwin", NM="_ZNK4llvm6Triple10isOSDarwinEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple10isOSDarwinEv")
  //</editor-fold>
  public boolean isOSDarwin() /*const*/ {
    return isMacOSX() || isiOS() || isWatchOS();
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSNetBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 452,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 436,
   FQN="llvm::Triple::isOSNetBSD", NM="_ZNK4llvm6Triple10isOSNetBSDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple10isOSNetBSDEv")
  //</editor-fold>
  public boolean isOSNetBSD() /*const*/ {
    return getOS() == Triple.OSType.NetBSD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSOpenBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 456,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 440,
   FQN="llvm::Triple::isOSOpenBSD", NM="_ZNK4llvm6Triple11isOSOpenBSDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple11isOSOpenBSDEv")
  //</editor-fold>
  public boolean isOSOpenBSD() /*const*/ {
    return getOS() == Triple.OSType.OpenBSD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSFreeBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 460,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 444,
   FQN="llvm::Triple::isOSFreeBSD", NM="_ZNK4llvm6Triple11isOSFreeBSDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple11isOSFreeBSDEv")
  //</editor-fold>
  public boolean isOSFreeBSD() /*const*/ {
    return getOS() == Triple.OSType.FreeBSD;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSDragonFly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 448,
   FQN="llvm::Triple::isOSDragonFly", NM="_ZNK4llvm6Triple13isOSDragonFlyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple13isOSDragonFlyEv")
  //</editor-fold>
  public boolean isOSDragonFly() /*const*/ {
    return getOS() == Triple.OSType.DragonFly;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSSolaris">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 450,
   FQN="llvm::Triple::isOSSolaris", NM="_ZNK4llvm6Triple11isOSSolarisEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple11isOSSolarisEv")
  //</editor-fold>
  public boolean isOSSolaris() /*const*/ {
    return getOS() == Triple.OSType.Solaris;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSBitrig">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 470,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 454,
   FQN="llvm::Triple::isOSBitrig", NM="_ZNK4llvm6Triple10isOSBitrigEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple10isOSBitrigEv")
  //</editor-fold>
  public boolean isOSBitrig() /*const*/ {
    return getOS() == Triple.OSType.Bitrig;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSIAMCU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 458,
   FQN="llvm::Triple::isOSIAMCU", NM="_ZNK4llvm6Triple9isOSIAMCUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9isOSIAMCUEv")
  //</editor-fold>
  public boolean isOSIAMCU() /*const*/ {
    return getOS() == Triple.OSType.ELFIAMCU;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isGNUEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 478,
   FQN="llvm::Triple::isGNUEnvironment", NM="_ZNK4llvm6Triple16isGNUEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple16isGNUEnvironmentEv")
  //</editor-fold>
  public boolean isGNUEnvironment() /*const*/ {
    EnvironmentType Env = getEnvironment();
    return Env == Triple.EnvironmentType.GNU || Env == Triple.EnvironmentType.GNUABI64
       || Env == Triple.EnvironmentType.GNUEABI || Env == Triple.EnvironmentType.GNUEABIHF
       || Env == Triple.EnvironmentType.GNUX32;
  }

  
  /// Checks if the environment could be MSVC.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWindowsMSVCEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 486,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 463,
   FQN="llvm::Triple::isWindowsMSVCEnvironment", NM="_ZNK4llvm6Triple24isWindowsMSVCEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple24isWindowsMSVCEnvironmentEv")
  //</editor-fold>
  public boolean isWindowsMSVCEnvironment() /*const*/ {
    return getOS() == Triple.OSType.Win32
       && (getEnvironment() == Triple.EnvironmentType.UnknownEnvironment
       || getEnvironment() == Triple.EnvironmentType.MSVC);
  }

  
  /// Checks if the environment is MSVC.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isKnownWindowsMSVCEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 493,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 470,
   FQN="llvm::Triple::isKnownWindowsMSVCEnvironment", NM="_ZNK4llvm6Triple29isKnownWindowsMSVCEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple29isKnownWindowsMSVCEnvironmentEv")
  //</editor-fold>
  public boolean isKnownWindowsMSVCEnvironment() /*const*/ {
    return getOS() == Triple.OSType.Win32 && getEnvironment() == Triple.EnvironmentType.MSVC;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWindowsCoreCLREnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 497,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 474,
   FQN="llvm::Triple::isWindowsCoreCLREnvironment", NM="_ZNK4llvm6Triple27isWindowsCoreCLREnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple27isWindowsCoreCLREnvironmentEv")
  //</editor-fold>
  public boolean isWindowsCoreCLREnvironment() /*const*/ {
    return getOS() == Triple.OSType.Win32 && getEnvironment() == Triple.EnvironmentType.CoreCLR;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWindowsItaniumEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 478,
   FQN="llvm::Triple::isWindowsItaniumEnvironment", NM="_ZNK4llvm6Triple27isWindowsItaniumEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple27isWindowsItaniumEnvironmentEv")
  //</editor-fold>
  public boolean isWindowsItaniumEnvironment() /*const*/ {
    return getOS() == Triple.OSType.Win32 && getEnvironment() == Triple.EnvironmentType.Itanium;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWindowsCygwinEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 505,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 482,
   FQN="llvm::Triple::isWindowsCygwinEnvironment", NM="_ZNK4llvm6Triple26isWindowsCygwinEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple26isWindowsCygwinEnvironmentEv")
  //</editor-fold>
  public boolean isWindowsCygwinEnvironment() /*const*/ {
    return getOS() == Triple.OSType.Win32 && getEnvironment() == Triple.EnvironmentType.Cygnus;
  }

  
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isWindowsGNUEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 509,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 486,
   FQN="llvm::Triple::isWindowsGNUEnvironment", NM="_ZNK4llvm6Triple23isWindowsGNUEnvironmentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple23isWindowsGNUEnvironmentEv")
  //</editor-fold>
  public boolean isWindowsGNUEnvironment() /*const*/ {
    return getOS() == Triple.OSType.Win32 && getEnvironment() == Triple.EnvironmentType.GNU;
  }

  
  /// Tests for either Cygwin or MinGW OS
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSCygMing">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 514,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 491,
   FQN="llvm::Triple::isOSCygMing", NM="_ZNK4llvm6Triple11isOSCygMingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple11isOSCygMingEv")
  //</editor-fold>
  public boolean isOSCygMing() /*const*/ {
    return isWindowsCygwinEnvironment() || isWindowsGNUEnvironment();
  }

  
  /// Is this a "Windows" OS targeting a "MSVCRT.dll" environment.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSMSVCRT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 519,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 496,
   FQN="llvm::Triple::isOSMSVCRT", NM="_ZNK4llvm6Triple10isOSMSVCRTEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple10isOSMSVCRTEv")
  //</editor-fold>
  public boolean isOSMSVCRT() /*const*/ {
    return isWindowsMSVCEnvironment() || isWindowsGNUEnvironment()
       || isWindowsItaniumEnvironment();
  }

  
  /// Tests whether the OS is Windows.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSWindows">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 525,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 502,
   FQN="llvm::Triple::isOSWindows", NM="_ZNK4llvm6Triple11isOSWindowsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple11isOSWindowsEv")
  //</editor-fold>
  public boolean isOSWindows() /*const*/ {
    return getOS() == Triple.OSType.Win32;
  }

  
  /// Tests whether the OS is NaCl (Native Client)
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSNaCl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 530,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 507,
   FQN="llvm::Triple::isOSNaCl", NM="_ZNK4llvm6Triple8isOSNaClEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple8isOSNaClEv")
  //</editor-fold>
  public boolean isOSNaCl() /*const*/ {
    return getOS() == Triple.OSType.NaCl;
  }

  
  /// Tests whether the OS is Linux.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSLinux">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 535,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 512,
   FQN="llvm::Triple::isOSLinux", NM="_ZNK4llvm6Triple9isOSLinuxEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9isOSLinuxEv")
  //</editor-fold>
  public boolean isOSLinux() /*const*/ {
    return getOS() == Triple.OSType.Linux;
  }

  
  /// Tests whether the OS is kFreeBSD.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSKFreeBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 540,
   FQN="llvm::Triple::isOSKFreeBSD", NM="_ZNK4llvm6Triple12isOSKFreeBSDEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple12isOSKFreeBSDEv")
  //</editor-fold>
  public boolean isOSKFreeBSD() /*const*/ {
    return getOS() == Triple.OSType.KFreeBSD;
  }

  
  /// Tests whether the OS uses glibc.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSGlibc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 545,
   FQN="llvm::Triple::isOSGlibc", NM="_ZNK4llvm6Triple9isOSGlibcEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9isOSGlibcEv")
  //</editor-fold>
  public boolean isOSGlibc() /*const*/ {
    return getOS() == Triple.OSType.Linux || getOS() == Triple.OSType.KFreeBSD;
  }

  
  /// Tests whether the OS uses the ELF binary format.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSBinFormatELF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 550,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 517,
   FQN="llvm::Triple::isOSBinFormatELF", NM="_ZNK4llvm6Triple16isOSBinFormatELFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple16isOSBinFormatELFEv")
  //</editor-fold>
  public boolean isOSBinFormatELF() /*const*/ {
    return getObjectFormat() == Triple.ObjectFormatType.ELF;
  }

  
  /// Tests whether the OS uses the COFF binary format.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSBinFormatCOFF">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 555,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 522,
   FQN="llvm::Triple::isOSBinFormatCOFF", NM="_ZNK4llvm6Triple17isOSBinFormatCOFFEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple17isOSBinFormatCOFFEv")
  //</editor-fold>
  public boolean isOSBinFormatCOFF() /*const*/ {
    return getObjectFormat() == Triple.ObjectFormatType.COFF;
  }

  
  /// Tests whether the environment is MachO.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isOSBinFormatMachO">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 560,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 527,
   FQN="llvm::Triple::isOSBinFormatMachO", NM="_ZNK4llvm6Triple18isOSBinFormatMachOEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple18isOSBinFormatMachOEv")
  //</editor-fold>
  public boolean isOSBinFormatMachO() /*const*/ {
    return getObjectFormat() == Triple.ObjectFormatType.MachO;
  }

  
  /// Tests whether the target is the PS4 CPU
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isPS4CPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 565,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 532,
   FQN="llvm::Triple::isPS4CPU", NM="_ZNK4llvm6Triple8isPS4CPUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple8isPS4CPUEv")
  //</editor-fold>
  public boolean isPS4CPU() /*const*/ {
    return getArch() == Triple.ArchType.x86_64
       && getVendor() == Triple.VendorType.SCEI
       && getOS() == Triple.OSType.PS4;
  }

  
  /// Tests whether the target is the PS4 platform
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isPS4">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 572,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 539,
   FQN="llvm::Triple::isPS4", NM="_ZNK4llvm6Triple5isPS4Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple5isPS4Ev")
  //</editor-fold>
  public boolean isPS4() /*const*/ {
    return getVendor() == Triple.VendorType.SCEI
       && getOS() == Triple.OSType.PS4;
  }

  
  /// Tests whether the target is Android
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isAndroid">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 578,
   old_source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", old_line = 545,
   FQN="llvm::Triple::isAndroid", NM="_ZNK4llvm6Triple9isAndroidEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple9isAndroidEv")
  //</editor-fold>
  public boolean isAndroid() /*const*/ {
    return getEnvironment() == Triple.EnvironmentType.Android;
  }

  
  /// Tests whether the environment is musl-libc
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isMusl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 581,
   FQN="llvm::Triple::isMusl", NM="_ZNK4llvm6Triple6isMuslEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple6isMuslEv")
  //</editor-fold>
  public boolean isMusl() /*const*/ {
    return getEnvironment() == Triple.EnvironmentType.Musl
       || getEnvironment() == Triple.EnvironmentType.MuslEABI
       || getEnvironment() == Triple.EnvironmentType.MuslEABIHF;
  }

  
  /// Tests whether the target is NVPTX (32- or 64-bit).
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isNVPTX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 588,
   FQN="llvm::Triple::isNVPTX", NM="_ZNK4llvm6Triple7isNVPTXEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple7isNVPTXEv")
  //</editor-fold>
  public boolean isNVPTX() /*const*/ {
    return getArch() == Triple.ArchType.nvptx || getArch() == Triple.ArchType.nvptx64;
  }

  
  /// Tests wether the target supports comdat
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::supportsCOMDAT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 593,
   FQN="llvm::Triple::supportsCOMDAT", NM="_ZNK4llvm6Triple14supportsCOMDATEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZNK4llvm6Triple14supportsCOMDATEv")
  //</editor-fold>
  public boolean supportsCOMDAT() /*const*/ {
    return !isOSBinFormatMachO();
  }

  
  /// @}
  /// @name Mutators
  /// @{
  
  /// setArch - Set the architecture (first) component of the triple
  /// to a known type.
  
  /// @}
  /// @name Mutators
  /// @{
  
  /// setArch - Set the architecture (first) component of the triple
  /// to a known type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1057,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1025,
   FQN="llvm::Triple::setArch", NM="_ZN4llvm6Triple7setArchENS0_8ArchTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple7setArchENS0_8ArchTypeE")
  //</editor-fold>
  public void setArch(ArchType Kind) {
    setArchName(new StringRef(getArchTypeName(Kind)));
  }


  
  /// setVendor - Set the vendor (second) component of the triple to a
  /// known type.
  
  /// setVendor - Set the vendor (second) component of the triple to a
  /// known type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setVendor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1061,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1029,
   FQN="llvm::Triple::setVendor", NM="_ZN4llvm6Triple9setVendorENS0_10VendorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple9setVendorENS0_10VendorTypeE")
  //</editor-fold>
  public void setVendor(VendorType Kind) {
    setVendorName(new StringRef(getVendorTypeName(Kind)));
  }


  
  /// setOS - Set the operating system (third) component of the triple
  /// to a known type.
  
  /// setOS - Set the operating system (third) component of the triple
  /// to a known type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1065,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1033,
   FQN="llvm::Triple::setOS", NM="_ZN4llvm6Triple5setOSENS0_6OSTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple5setOSENS0_6OSTypeE")
  //</editor-fold>
  public void setOS(OSType Kind) {
    setOSName(new StringRef(getOSTypeName(Kind)));
  }


  
  /// setEnvironment - Set the environment (fourth) component of the triple
  /// to a known type.
  
  /// setEnvironment - Set the environment (fourth) component of the triple
  /// to a known type.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setEnvironment">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1069,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1037,
   FQN="llvm::Triple::setEnvironment", NM="_ZN4llvm6Triple14setEnvironmentENS0_15EnvironmentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple14setEnvironmentENS0_15EnvironmentTypeE")
  //</editor-fold>
  public void setEnvironment(EnvironmentType Kind) {
    if (ObjectFormat == getDefaultFormat(/*Deref*/this)) {
      setEnvironmentName(new StringRef(getEnvironmentTypeName(Kind)));
      return;
    }
    
    setEnvironmentName(new StringRef(($add_Twine($add_Twine(new Twine(getEnvironmentTypeName(Kind)), new Twine(/*KEEP_STR*/$MINUS)), 
                new Twine(getObjectFormatTypeName(ObjectFormat)))).str()));
  }


  
  /// setObjectFormat - Set the object file format
  
  /// setObjectFormat - Set the object file format
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setObjectFormat">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1077,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1045,
   FQN="llvm::Triple::setObjectFormat", NM="_ZN4llvm6Triple15setObjectFormatENS0_16ObjectFormatTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple15setObjectFormatENS0_16ObjectFormatTypeE")
  //</editor-fold>
  public void setObjectFormat(ObjectFormatType Kind) {
    if (Environment == EnvironmentType.UnknownEnvironment) {
      setEnvironmentName(new StringRef(getObjectFormatTypeName(Kind)));
      return;
    }
    
    setEnvironmentName(new StringRef(($add_Twine($add_Twine(new Twine(getEnvironmentTypeName(Environment)), new Twine(/*KEEP_STR*/$MINUS)), 
                new Twine(getObjectFormatTypeName(Kind)))).str()));
  }


  
  /// setTriple - Set all components to the new triple \p Str.
  
  /// setTriple - Set all components to the new triple \p Str.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1053,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1021,
   FQN="llvm::Triple::setTriple", NM="_ZN4llvm6Triple9setTripleERKNS_5TwineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple9setTripleERKNS_5TwineE")
  //</editor-fold>
  public void setTriple(/*const*/ Twine /*&*/ Str) {
    /*Deref*/this.$assignMove(new Triple(Str));
  }


  
  /// setArchName - Set the architecture (first) component of the
  /// triple by name.
  
  /// setArchName - Set the architecture (first) component of the
  /// triple by name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setArchName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1085,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1053,
   FQN="llvm::Triple::setArchName", NM="_ZN4llvm6Triple11setArchNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple11setArchNameENS_9StringRefE")
  //</editor-fold>
  public void setArchName(StringRef Str) {
    // Work around a miscompilation bug for Twines in gcc 4.0.3.
    SmallString/*64*/ Triple/*J*/= new SmallString/*64*/(64);
    Triple.$addassign(/*NO_COPY*/Str);
    Triple.$addassign(/*STRINGREF_STR*/"-");
    Triple.$addassign(getVendorName());
    Triple.$addassign(/*STRINGREF_STR*/"-");
    Triple.$addassign(getOSAndEnvironmentName());
    setTriple(new Twine(Triple));
  }


  
  /// setVendorName - Set the vendor (second) component of the triple
  /// by name.
  
  /// setVendorName - Set the vendor (second) component of the triple
  /// by name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setVendorName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1096,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1064,
   FQN="llvm::Triple::setVendorName", NM="_ZN4llvm6Triple13setVendorNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple13setVendorNameENS_9StringRefE")
  //</editor-fold>
  public void setVendorName(StringRef Str) {
    setTriple($add_Twine($add_Twine($add_Twine($add_StringRef_char$ptr$C(getArchName(), /*KEEP_STR*/$MINUS), new Twine(Str)), new Twine(/*KEEP_STR*/$MINUS)), new Twine(getOSAndEnvironmentName())));
  }


  
  /// setOSName - Set the operating system (third) component of the
  /// triple by name.
  
  /// setOSName - Set the operating system (third) component of the
  /// triple by name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setOSName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1100,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1068,
   FQN="llvm::Triple::setOSName", NM="_ZN4llvm6Triple9setOSNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple9setOSNameENS_9StringRefE")
  //</editor-fold>
  public void setOSName(StringRef Str) {
    if (hasEnvironment()) {
      setTriple($add_Twine($add_Twine($add_Twine($add_Twine($add_Twine($add_StringRef_char$ptr$C(getArchName(), /*KEEP_STR*/$MINUS), new Twine(getVendorName())), new Twine(/*KEEP_STR*/$MINUS)), new Twine(Str)), 
                  new Twine(/*KEEP_STR*/$MINUS)), new Twine(getEnvironmentName())));
    } else {
      setTriple($add_Twine($add_Twine($add_Twine($add_StringRef_char$ptr$C(getArchName(), /*KEEP_STR*/$MINUS), new Twine(getVendorName())), new Twine(/*KEEP_STR*/$MINUS)), new Twine(Str)));
    }
  }


  
  /// setEnvironmentName - Set the optional environment (fourth)
  /// component of the triple by name.
  
  /// setEnvironmentName - Set the optional environment (fourth)
  /// component of the triple by name.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setEnvironmentName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1108,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1076,
   FQN="llvm::Triple::setEnvironmentName", NM="_ZN4llvm6Triple18setEnvironmentNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple18setEnvironmentNameENS_9StringRefE")
  //</editor-fold>
  public void setEnvironmentName(StringRef Str) {
    setTriple($add_Twine($add_Twine($add_Twine($add_Twine($add_Twine($add_StringRef_char$ptr$C(getArchName(), /*KEEP_STR*/$MINUS), new Twine(getVendorName())), new Twine(/*KEEP_STR*/$MINUS)), new Twine(getOSName())), 
                new Twine(/*KEEP_STR*/$MINUS)), new Twine(Str)));
  }


  
  /// setOSAndEnvironmentName - Set the operating system and optional
  /// environment components with a single string.
  
  /// setOSAndEnvironmentName - Set the operating system and optional
  /// environment components with a single string.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::setOSAndEnvironmentName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1113,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1081,
   FQN="llvm::Triple::setOSAndEnvironmentName", NM="_ZN4llvm6Triple23setOSAndEnvironmentNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple23setOSAndEnvironmentNameENS_9StringRefE")
  //</editor-fold>
  public void setOSAndEnvironmentName(StringRef Str) {
    setTriple($add_Twine($add_Twine($add_Twine($add_StringRef_char$ptr$C(getArchName(), /*KEEP_STR*/$MINUS), new Twine(getVendorName())), new Twine(/*KEEP_STR*/$MINUS)), new Twine(Str)));
  }


  
  /// @}
  /// @name Helpers to build variants of a particular triple.
  /// @{
  
  /// Form a triple with a 32-bit variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a 32-bit architecture or an unknown
  ///          architecture if no such variant can be found.
  
  /// @}
  /// @name Helpers to build variants of a particular triple.
  /// @{
  
  /// Form a triple with a 32-bit variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a 32-bit architecture or an unknown
  ///          architecture if no such variant can be found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::get32BitArchVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1188,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1153,
   FQN="llvm::Triple::get32BitArchVariant", NM="_ZNK4llvm6Triple19get32BitArchVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple19get32BitArchVariantEv")
  //</editor-fold>
  public Triple get32BitArchVariant() /*const*/ {
    Triple T/*J*/= new Triple(/*Deref*/this);
    switch (getArch()) {
     case UnknownArch:
     case amdgcn:
     case avr:
     case bpfel:
     case bpfeb:
     case msp430:
     case systemz:
     case ppc64le:
      T.setArch(ArchType.UnknownArch);
      break;
     case amdil:
     case hsail:
     case spir:
     case arm:
     case armeb:
     case hexagon:
     case kalimba:
     case le32:
     case mips:
     case mipsel:
     case nvptx:
     case ppc:
     case r600:
     case sparc:
     case sparcel:
     case tce:
     case thumb:
     case thumbeb:
     case x86:
     case xcore:
     case lanai:
     case shave:
     case wasm32:
     case renderscript32:
      // Already 32-bit.
      break;
     case aarch64:
      T.setArch(Triple.ArchType.arm);
      break;
     case aarch64_be:
      T.setArch(Triple.ArchType.armeb);
      break;
     case le64:
      T.setArch(Triple.ArchType.le32);
      break;
     case mips64:
      T.setArch(Triple.ArchType.mips);
      break;
     case mips64el:
      T.setArch(Triple.ArchType.mipsel);
      break;
     case nvptx64:
      T.setArch(Triple.ArchType.nvptx);
      break;
     case ppc64:
      T.setArch(Triple.ArchType.ppc);
      break;
     case sparcv9:
      T.setArch(Triple.ArchType.sparc);
      break;
     case x86_64:
      T.setArch(Triple.ArchType.x86);
      break;
     case amdil64:
      T.setArch(Triple.ArchType.amdil);
      break;
     case hsail64:
      T.setArch(Triple.ArchType.hsail);
      break;
     case spir64:
      T.setArch(Triple.ArchType.spir);
      break;
     case wasm64:
      T.setArch(Triple.ArchType.wasm32);
      break;
     case renderscript64:
      T.setArch(Triple.ArchType.renderscript32);
      break;
    }
    return T;
  }


  
  /// Form a triple with a 64-bit variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a 64-bit architecture or an unknown
  ///          architecture if no such variant can be found.
  
  /// Form a triple with a 64-bit variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a 64-bit architecture or an unknown
  ///          architecture if no such variant can be found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::get64BitArchVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1247,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1209,
   FQN="llvm::Triple::get64BitArchVariant", NM="_ZNK4llvm6Triple19get64BitArchVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple19get64BitArchVariantEv")
  //</editor-fold>
  public Triple get64BitArchVariant() /*const*/ {
    Triple T/*J*/= new Triple(/*Deref*/this);
    switch (getArch()) {
     case UnknownArch:
     case avr:
     case hexagon:
     case kalimba:
     case lanai:
     case msp430:
     case r600:
     case tce:
     case xcore:
     case sparcel:
     case shave:
      T.setArch(ArchType.UnknownArch);
      break;
     case aarch64:
     case aarch64_be:
     case bpfel:
     case bpfeb:
     case le64:
     case amdil64:
     case amdgcn:
     case hsail64:
     case spir64:
     case mips64:
     case mips64el:
     case nvptx64:
     case ppc64:
     case ppc64le:
     case sparcv9:
     case systemz:
     case x86_64:
     case wasm64:
     case renderscript64:
      // Already 64-bit.
      break;
     case arm:
      T.setArch(Triple.ArchType.aarch64);
      break;
     case armeb:
      T.setArch(Triple.ArchType.aarch64_be);
      break;
     case le32:
      T.setArch(Triple.ArchType.le64);
      break;
     case mips:
      T.setArch(Triple.ArchType.mips64);
      break;
     case mipsel:
      T.setArch(Triple.ArchType.mips64el);
      break;
     case nvptx:
      T.setArch(Triple.ArchType.nvptx64);
      break;
     case ppc:
      T.setArch(Triple.ArchType.ppc64);
      break;
     case sparc:
      T.setArch(Triple.ArchType.sparcv9);
      break;
     case x86:
      T.setArch(Triple.ArchType.x86_64);
      break;
     case amdil:
      T.setArch(Triple.ArchType.amdil64);
      break;
     case hsail:
      T.setArch(Triple.ArchType.hsail64);
      break;
     case spir:
      T.setArch(Triple.ArchType.spir64);
      break;
     case thumb:
      T.setArch(Triple.ArchType.aarch64);
      break;
     case thumbeb:
      T.setArch(Triple.ArchType.aarch64_be);
      break;
     case wasm32:
      T.setArch(Triple.ArchType.wasm64);
      break;
     case renderscript32:
      T.setArch(Triple.ArchType.renderscript64);
      break;
    }
    return T;
  }


  
  /// Form a triple with a big endian variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a big endian architecture or an unknown
  ///          architecture if no such variant can be found.
  
  /// Form a triple with a big endian variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a big endian architecture or an unknown
  ///          architecture if no such variant can be found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getBigEndianArchVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1306,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1265,
   FQN="llvm::Triple::getBigEndianArchVariant", NM="_ZNK4llvm6Triple23getBigEndianArchVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple23getBigEndianArchVariantEv")
  //</editor-fold>
  public Triple getBigEndianArchVariant() /*const*/ {
    Triple T/*J*/= new Triple(/*Deref*/this);
    // Already big endian.
    if (!isLittleEndian()) {
      return T;
    }
    switch (getArch()) {
     case UnknownArch:
     case amdgcn:
     case amdil64:
     case amdil:
     case avr:
     case hexagon:
     case hsail64:
     case hsail:
     case kalimba:
     case le32:
     case le64:
     case msp430:
     case nvptx64:
     case nvptx:
     case r600:
     case shave:
     case spir64:
     case spir:
     case wasm32:
     case wasm64:
     case x86:
     case x86_64:
     case xcore:
     case renderscript32:
     case renderscript64:
     case arm:
     case thumb:
      
      // ARM is intentionally unsupported here, changing the architecture would
      // drop any arch suffixes.
      T.setArch(ArchType.UnknownArch);
      break;
     case aarch64:
      T.setArch(Triple.ArchType.aarch64_be);
      break;
     case bpfel:
      T.setArch(Triple.ArchType.bpfeb);
      break;
     case mips64el:
      T.setArch(Triple.ArchType.mips64);
      break;
     case mipsel:
      T.setArch(Triple.ArchType.mips);
      break;
     case ppc64le:
      T.setArch(Triple.ArchType.ppc64);
      break;
     case sparcel:
      T.setArch(Triple.ArchType.sparc);
      break;
     default:
      throw new llvm_unreachable("getBigEndianArchVariant: unknown triple.");
    }
    return T;
  }


  
  /// Form a triple with a little endian variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a little endian architecture or an unknown
  ///          architecture if no such variant can be found.
  
  /// Form a triple with a little endian variant of the current architecture.
  ///
  /// This can be used to move across "families" of architectures where useful.
  ///
  /// \returns A new triple with a little endian architecture or an unknown
  ///          architecture if no such variant can be found.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getLittleEndianArchVariant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1357,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1324,
   FQN="llvm::Triple::getLittleEndianArchVariant", NM="_ZNK4llvm6Triple26getLittleEndianArchVariantEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple26getLittleEndianArchVariantEv")
  //</editor-fold>
  public Triple getLittleEndianArchVariant() /*const*/ {
    Triple T/*J*/= new Triple(/*Deref*/this);
    if (isLittleEndian()) {
      return T;
    }
    switch (getArch()) {
     case UnknownArch:
     case lanai:
     case ppc:
     case sparcv9:
     case systemz:
     case tce:
     case armeb:
     case thumbeb:
      
      // ARM is intentionally unsupported here, changing the architecture would
      // drop any arch suffixes.
      T.setArch(ArchType.UnknownArch);
      break;
     case aarch64_be:
      T.setArch(Triple.ArchType.aarch64);
      break;
     case bpfeb:
      T.setArch(Triple.ArchType.bpfel);
      break;
     case mips64:
      T.setArch(Triple.ArchType.mips64el);
      break;
     case mips:
      T.setArch(Triple.ArchType.mipsel);
      break;
     case ppc64:
      T.setArch(Triple.ArchType.ppc64le);
      break;
     case sparc:
      T.setArch(Triple.ArchType.sparcel);
      break;
     default:
      throw new llvm_unreachable("getLittleEndianArchVariant: unknown triple.");
    }
    return T;
  }


  
  /// Get the (LLVM) name of the minimum ARM CPU for the arch we are targeting.
  ///
  /// \param Arch the architecture name (e.g., "armv7s"). If it is an empty
  /// string then the triple's arch name is used.
  
  /// Get the (LLVM) name of the minimum ARM CPU for the arch we are targeting.
  ///
  /// \param Arch the architecture name (e.g., "armv7s"). If it is an empty
  /// string then the triple's arch name is used.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getARMCPUForArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1429,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1383,
   FQN="llvm::Triple::getARMCPUForArch", NM="_ZNK4llvm6Triple16getARMCPUForArchENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple16getARMCPUForArchENS_9StringRefE")
  //</editor-fold>
  public StringRef getARMCPUForArch() /*const*/ {
    return getARMCPUForArch(new StringRef());
  }
  public StringRef getARMCPUForArch(StringRef MArch/*= StringRef()*/) /*const*/ {
    if (MArch.empty()) {
      MArch.$assignMove(getArchName());
    }
    MArch.$assignMove(ARM.getCanonicalArchName(/*NO_COPY*/MArch));
    
    // Some defaults are forced.
    switch (getOS()) {
     case FreeBSD:
     case NetBSD:
      if (!MArch.empty() && $eq_StringRef(/*NO_COPY*/MArch, /*STRINGREF_STR*/"v6")) {
        return new StringRef(/*KEEP_STR*/"arm1176jzf-s");
      }
      break;
     case Win32:
      // FIXME: this is invalid for WindowsCE
      return new StringRef(/*KEEP_STR*/"cortex-a9");
     case MacOSX:
     case IOS:
     case WatchOS:
     case TvOS:
      if ($eq_StringRef(/*NO_COPY*/MArch, /*STRINGREF_STR*/"v7k")) {
        return new StringRef(/*KEEP_STR*/"cortex-a7");
      }
      break;
     default:
      break;
    }
    if (MArch.empty()) {
      return new StringRef();
    }
    
    StringRef CPU = ARM.getDefaultCPU(/*NO_COPY*/MArch);
    if (!CPU.empty()) {
      return CPU;
    }
    
    // If no specific architecture version is requested, return the minimum CPU
    // required by the OS and environment.
    switch (getOS()) {
     case NetBSD:
      switch (getEnvironment()) {
       case GNUEABIHF:
       case GNUEABI:
       case EABIHF:
       case EABI:
        return new StringRef(/*KEEP_STR*/"arm926ej-s");
       default:
        return new StringRef(/*KEEP_STR*/"strongarm");
      }
     case NaCl:
      return new StringRef(/*KEEP_STR*/"cortex-a8");
     default:
      switch (getEnvironment()) {
       case EABIHF:
       case GNUEABIHF:
       case MuslEABIHF:
        return new StringRef(/*KEEP_STR*/"arm1176jzf-s");
       default:
        return new StringRef(/*KEEP_STR*/"arm7tdmi");
      }
    }
    // JAVA: unreachable
    //throw new llvm_unreachable("invalid arch name");
  }


  
  /// Tests whether the target triple is little endian.
  ///
  /// \returns true if the triple is little endian, false otherwise.
  
  /// Tests whether the target triple is little endian.
  ///
  /// \returns true if the triple is little endian, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::isLittleEndian">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1389,
   FQN="llvm::Triple::isLittleEndian", NM="_ZNK4llvm6Triple14isLittleEndianEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZNK4llvm6Triple14isLittleEndianEv")
  //</editor-fold>
  public boolean isLittleEndian() /*const*/ {
    switch (getArch()) {
     case aarch64:
     case amdgcn:
     case amdil64:
     case amdil:
     case arm:
     case avr:
     case bpfel:
     case hexagon:
     case hsail64:
     case hsail:
     case kalimba:
     case le32:
     case le64:
     case mips64el:
     case mipsel:
     case msp430:
     case nvptx64:
     case nvptx:
     case ppc64le:
     case r600:
     case shave:
     case sparcel:
     case spir64:
     case spir:
     case thumb:
     case wasm32:
     case wasm64:
     case x86:
     case x86_64:
     case xcore:
     case renderscript32:
     case renderscript64:
      return true;
     default:
      return false;
    }
  }


  
  /// @}
  /// @name Static helpers for IDs.
  /// @{
  
  /// getArchTypeName - Get the canonical name for the \p Kind architecture.
  
  /// @}
  /// @name Static helpers for IDs.
  /// @{
  
  /// getArchTypeName - Get the canonical name for the \p Kind architecture.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getArchTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 20,
   FQN="llvm::Triple::getArchTypeName", NM="_ZN4llvm6Triple15getArchTypeNameENS0_8ArchTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple15getArchTypeNameENS0_8ArchTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getArchTypeName(ArchType Kind) {
    switch (Kind) {
     case UnknownArch:
      return $unknown;
     case aarch64:
      return $("aarch64");
     case aarch64_be:
      return $("aarch64_be");
     case arm:
      return $("arm");
     case armeb:
      return $("armeb");
     case avr:
      return $("avr");
     case bpfel:
      return $("bpfel");
     case bpfeb:
      return $("bpfeb");
     case hexagon:
      return $("hexagon");
     case mips:
      return $("mips");
     case mipsel:
      return $("mipsel");
     case mips64:
      return $("mips64");
     case mips64el:
      return $("mips64el");
     case msp430:
      return $("msp430");
     case ppc64:
      return $("powerpc64");
     case ppc64le:
      return $("powerpc64le");
     case ppc:
      return $("powerpc");
     case r600:
      return $("r600");
     case amdgcn:
      return $("amdgcn");
     case sparc:
      return $("sparc");
     case sparcv9:
      return $("sparcv9");
     case sparcel:
      return $("sparcel");
     case systemz:
      return $("s390x");
     case tce:
      return $("tce");
     case thumb:
      return $("thumb");
     case thumbeb:
      return $("thumbeb");
     case x86:
      return $("i386");
     case x86_64:
      return $("x86_64");
     case xcore:
      return $("xcore");
     case nvptx:
      return $("nvptx");
     case nvptx64:
      return $("nvptx64");
     case le32:
      return $("le32");
     case le64:
      return $("le64");
     case amdil:
      return $("amdil");
     case amdil64:
      return $("amdil64");
     case hsail:
      return $("hsail");
     case hsail64:
      return $("hsail64");
     case spir:
      return $("spir");
     case spir64:
      return $("spir64");
     case kalimba:
      return $("kalimba");
     case lanai:
      return $("lanai");
     case shave:
      return $("shave");
     case wasm32:
      return $("wasm32");
     case wasm64:
      return $("wasm64");
     case renderscript32:
      return $("renderscript32");
     case renderscript64:
      return $("renderscript64");
    }
    throw new llvm_unreachable("Invalid ArchType!");
  }


  
  /// getArchTypePrefix - Get the "prefix" canonical name for the \p Kind
  /// architecture. This is the prefix used by the architecture specific
  /// builtins, and is suitable for passing to \see
  /// Intrinsic::getIntrinsicForGCCBuiltin().
  ///
  /// \return - The architecture prefix, or 0 if none is defined.
  
  /// getArchTypePrefix - Get the "prefix" canonical name for the \p Kind
  /// architecture. This is the prefix used by the architecture specific
  /// builtins, and is suitable for passing to \see
  /// Intrinsic::getIntrinsicForGCCBuiltin().
  ///
  /// \return - The architecture prefix, or 0 if none is defined.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getArchTypePrefix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 74,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 71,
   FQN="llvm::Triple::getArchTypePrefix", NM="_ZN4llvm6Triple17getArchTypePrefixENS0_8ArchTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple17getArchTypePrefixENS0_8ArchTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getArchTypePrefix(ArchType Kind) {
    switch (Kind) {
     default:
      return null;
     case aarch64:
     case aarch64_be:
      return $("aarch64");
     case arm:
     case armeb:
     case thumb:
     case thumbeb:
      return $("arm");
     case avr:
      return $("avr");
     case ppc64:
     case ppc64le:
     case ppc:
      return $("ppc");
     case mips:
     case mipsel:
     case mips64:
     case mips64el:
      return $("mips");
     case hexagon:
      return $("hexagon");
     case amdgcn:
      return $("amdgcn");
     case r600:
      return $("r600");
     case bpfel:
     case bpfeb:
      return $("bpf");
     case sparcv9:
     case sparcel:
     case sparc:
      return $("sparc");
     case systemz:
      return $("s390");
     case x86:
     case x86_64:
      return $("x86");
     case xcore:
      return $("xcore");
     case nvptx:
      
      // NVPTX intrinsics are namespaced under nvvm.
      return $("nvvm");
     case nvptx64:
      return $("nvvm");
     case le32:
      return $("le32");
     case le64:
      return $("le64");
     case amdil:
     case amdil64:
      return $("amdil");
     case hsail:
     case hsail64:
      return $("hsail");
     case spir:
     case spir64:
      return $("spir");
     case kalimba:
      return $("kalimba");
     case lanai:
      return $("lanai");
     case shave:
      return $("shave");
     case wasm32:
     case wasm64:
      return $("wasm");
    }
  }


  
  /// getVendorTypeName - Get the canonical name for the \p Kind vendor.
  
  /// getVendorTypeName - Get the canonical name for the \p Kind vendor.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getVendorTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 140,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 135,
   FQN="llvm::Triple::getVendorTypeName", NM="_ZN4llvm6Triple17getVendorTypeNameENS0_10VendorTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple17getVendorTypeNameENS0_10VendorTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getVendorTypeName(VendorType Kind) {
    switch (Kind) {
     case UnknownVendor:
      return $unknown;
     case Apple:
      return $("apple");
     case PC:
      return $("pc");
     case SCEI:
      return $("scei");
     case BGP:
      return $("bgp");
     case BGQ:
      return $("bgq");
     case Freescale:
      return $("fsl");
     case IBM:
      return $("ibm");
     case ImaginationTechnologies:
      return $("img");
     case MipsTechnologies:
      return $("mti");
     case NVIDIA:
      return $("nvidia");
     case CSR:
      return $("csr");
     case Myriad:
      return $("myriad");
     case AMD:
      return $("amd");
     case Mesa:
      return $("mesa");
    }
    throw new llvm_unreachable("Invalid VendorType!");
  }


  
  /// getOSTypeName - Get the canonical name for the \p Kind operating system.
  
  /// getOSTypeName - Get the canonical name for the \p Kind operating system.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getOSTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 163,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 156,
   FQN="llvm::Triple::getOSTypeName", NM="_ZN4llvm6Triple13getOSTypeNameENS0_6OSTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple13getOSTypeNameENS0_6OSTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getOSTypeName(OSType Kind) {
    switch (Kind) {
     case UnknownOS:
      return $unknown;
     case CloudABI:
      return $("cloudabi");
     case Darwin:
      return $("darwin");
     case DragonFly:
      return $("dragonfly");
     case FreeBSD:
      return $("freebsd");
     case IOS:
      return $("ios");
     case KFreeBSD:
      return $("kfreebsd");
     case Linux:
      return $("linux");
     case Lv2:
      return $("lv2");
     case MacOSX:
      return $("macosx");
     case NetBSD:
      return $("netbsd");
     case OpenBSD:
      return $("openbsd");
     case Solaris:
      return $("solaris");
     case Win32:
      return $("windows");
     case Haiku:
      return $("haiku");
     case Minix:
      return $("minix");
     case RTEMS:
      return $("rtems");
     case NaCl:
      return $("nacl");
     case CNK:
      return $("cnk");
     case Bitrig:
      return $("bitrig");
     case AIX:
      return $("aix");
     case CUDA:
      return $("cuda");
     case NVCL:
      return $("nvcl");
     case AMDHSA:
      return $("amdhsa");
     case PS4:
      return $("ps4");
     case ELFIAMCU:
      return $("elfiamcu");
     case TvOS:
      return $("tvos");
     case WatchOS:
      return $("watchos");
     case Mesa3D:
      return $("mesa3d");
    }
    throw new llvm_unreachable("Invalid OSType");
  }


  
  /// getEnvironmentTypeName - Get the canonical name for the \p Kind
  /// environment.
  
  /// getEnvironmentTypeName - Get the canonical name for the \p Kind
  /// environment.
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getEnvironmentTypeName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 200,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 192,
   FQN="llvm::Triple::getEnvironmentTypeName", NM="_ZN4llvm6Triple22getEnvironmentTypeNameENS0_15EnvironmentTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple22getEnvironmentTypeNameENS0_15EnvironmentTypeE")
  //</editor-fold>
  public static /*const*/char$ptr/*char P*/ getEnvironmentTypeName(EnvironmentType Kind) {
    switch (Kind) {
     case UnknownEnvironment:
      return $unknown;
     case GNU:
      return $("gnu");
     case GNUABI64:
      return $("gnuabi64");
     case GNUEABIHF:
      return $("gnueabihf");
     case GNUEABI:
      return $("gnueabi");
     case GNUX32:
      return $("gnux32");
     case CODE16:
      return $("code16");
     case EABI:
      return $("eabi");
     case EABIHF:
      return $("eabihf");
     case Android:
      return $("android");
     case Musl:
      return $("musl");
     case MuslEABI:
      return $("musleabi");
     case MuslEABIHF:
      return $("musleabihf");
     case MSVC:
      return $("msvc");
     case Itanium:
      return $("itanium");
     case Cygnus:
      return $("cygnus");
     case AMDOpenCL:
      return $("amdopencl");
     case CoreCLR:
      return $("coreclr");
    }
    throw new llvm_unreachable("Invalid EnvironmentType!");
  }


  
  /// @}
  /// @name Static helpers for converting alternate architecture names.
  /// @{
  
  /// getArchTypeForLLVMName - The canonical type for the given LLVM
  /// architecture name (e.g., "x86").
  
  /// @}
  /// @name Static helpers for converting alternate architecture names.
  /// @{
  
  /// getArchTypeForLLVMName - The canonical type for the given LLVM
  /// architecture name (e.g., "x86").
  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::getArchTypeForLLVMName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 240,
   old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 228,
   FQN="llvm::Triple::getArchTypeForLLVMName", NM="_ZN4llvm6Triple22getArchTypeForLLVMNameENS_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6Triple22getArchTypeForLLVMNameENS_9StringRefE")
  //</editor-fold>
  public static Triple.ArchType getArchTypeForLLVMName(StringRef Name) {
    Triple.ArchType BPFArch/*J*/= parseBPFArch(/*NO_COPY*/Name);
    return new StringSwitch<Triple.ArchType>(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"aarch64", ArchType.aarch64).
        Case(/*KEEP_STR*/"aarch64_be", ArchType.aarch64_be).
        Case(/*KEEP_STR*/"arm64", ArchType.aarch64). // "arm64" is an alias for "aarch64"
        Case(/*KEEP_STR*/"arm", ArchType.arm).
        Case(/*KEEP_STR*/"armeb", ArchType.armeb).
        Case(/*KEEP_STR*/"avr", ArchType.avr).
        StartsWith(/*KEEP_STR*/"bpf", BPFArch).
        Case(/*KEEP_STR*/"mips", ArchType.mips).
        Case(/*KEEP_STR*/"mipsel", ArchType.mipsel).
        Case(/*KEEP_STR*/"mips64", ArchType.mips64).
        Case(/*KEEP_STR*/"mips64el", ArchType.mips64el).
        Case(/*KEEP_STR*/"msp430", ArchType.msp430).
        Case(/*KEEP_STR*/"ppc64", ArchType.ppc64).
        Case(/*KEEP_STR*/"ppc32", ArchType.ppc).
        Case(/*KEEP_STR*/"ppc", ArchType.ppc).
        Case(/*KEEP_STR*/"ppc64le", ArchType.ppc64le).
        Case(/*KEEP_STR*/"r600", ArchType.r600).
        Case(/*KEEP_STR*/"amdgcn", ArchType.amdgcn).
        Case(/*KEEP_STR*/"hexagon", ArchType.hexagon).
        Case(/*KEEP_STR*/"sparc", ArchType.sparc).
        Case(/*KEEP_STR*/"sparcel", ArchType.sparcel).
        Case(/*KEEP_STR*/"sparcv9", ArchType.sparcv9).
        Case(/*KEEP_STR*/"systemz", ArchType.systemz).
        Case(/*KEEP_STR*/"tce", ArchType.tce).
        Case(/*KEEP_STR*/"thumb", ArchType.thumb).
        Case(/*KEEP_STR*/"thumbeb", ArchType.thumbeb).
        Case(/*KEEP_STR*/"x86", ArchType.x86).
        Case(/*KEEP_STR*/"x86-64", ArchType.x86_64).
        Case(/*KEEP_STR*/"xcore", ArchType.xcore).
        Case(/*KEEP_STR*/"nvptx", ArchType.nvptx).
        Case(/*KEEP_STR*/"nvptx64", ArchType.nvptx64).
        Case(/*KEEP_STR*/"le32", ArchType.le32).
        Case(/*KEEP_STR*/"le64", ArchType.le64).
        Case(/*KEEP_STR*/"amdil", ArchType.amdil).
        Case(/*KEEP_STR*/"amdil64", ArchType.amdil64).
        Case(/*KEEP_STR*/"hsail", ArchType.hsail).
        Case(/*KEEP_STR*/"hsail64", ArchType.hsail64).
        Case(/*KEEP_STR*/"spir", ArchType.spir).
        Case(/*KEEP_STR*/"spir64", ArchType.spir64).
        Case(/*KEEP_STR*/"kalimba", ArchType.kalimba).
        Case(/*KEEP_STR*/"lanai", ArchType.lanai).
        Case(/*KEEP_STR*/"shave", ArchType.shave).
        Case(/*KEEP_STR*/"wasm32", ArchType.wasm32).
        Case(/*KEEP_STR*/"wasm64", ArchType.wasm64).
        Case(/*KEEP_STR*/"renderscript32", ArchType.renderscript32).
        Case(/*KEEP_STR*/"renderscript64", ArchType.renderscript64).
        Default(ArchType.UnknownArch);
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::Triple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 44,
   FQN="llvm::Triple::Triple", NM="_ZN4llvm6TripleC1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6TripleC1ERKS0_")
  //</editor-fold>
  public /*inline*/ Triple(/*const*/ Triple /*&*/ $Prm0) {
    /* : Data(.Data), Arch(.Arch), SubArch(.SubArch), Vendor(.Vendor), OS(.OS), Environment(.Environment), ObjectFormat(.ObjectFormat)*/ 
    //START JInit
    this.Data = new std.string($Prm0.Data);
    this.Arch = $Prm0.Arch;
    this.SubArch = $Prm0.SubArch;
    this.Vendor = $Prm0.Vendor;
    this.OS = $Prm0.OS;
    this.Environment = $Prm0.Environment;
    this.ObjectFormat = $Prm0.ObjectFormat;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 44,
   FQN="llvm::Triple::operator=", NM="_ZN4llvm6TripleaSERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6TripleaSERKS0_")
  //</editor-fold>
  public /*inline*/ Triple /*&*/ $assign(/*const*/ Triple /*&*/ $Prm0) {
    this.Data.$assign($Prm0.Data);
    this.Arch = $Prm0.Arch;
    this.SubArch = $Prm0.SubArch;
    this.Vendor = $Prm0.Vendor;
    this.OS = $Prm0.OS;
    this.Environment = $Prm0.Environment;
    this.ObjectFormat = $Prm0.ObjectFormat;
    return /*Deref*/this;
  }

  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::~Triple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 44,
   FQN="llvm::Triple::~Triple", NM="_ZN4llvm6TripleD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Frontend/ASTUnit.cpp -nm=_ZN4llvm6TripleD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    Data.$destroy();
    //END JDestroy
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::Triple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 44,
   FQN="llvm::Triple::Triple", NM="_ZN4llvm6TripleC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6TripleC1EOS0_")
  //</editor-fold>
  public /*inline*/ Triple(JD$Move _dparam, Triple /*&&*/$Prm0) {
    /* : Data(static_cast<Triple &&>().Data), Arch(static_cast<Triple &&>().Arch), SubArch(static_cast<Triple &&>().SubArch), Vendor(static_cast<Triple &&>().Vendor), OS(static_cast<Triple &&>().OS), Environment(static_cast<Triple &&>().Environment), ObjectFormat(static_cast<Triple &&>().ObjectFormat)*/ 
    //START JInit
    this.Data = new std.string(JD$Move.INSTANCE, $Prm0.Data);
    this.Arch = $Prm0.Arch;
    this.SubArch = $Prm0.SubArch;
    this.Vendor = $Prm0.Vendor;
    this.OS = $Prm0.OS;
    this.Environment = $Prm0.Environment;
    this.ObjectFormat = $Prm0.ObjectFormat;
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="llvm::Triple::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/include/llvm/ADT/Triple.h", line = 44,
   FQN="llvm::Triple::operator=", NM="_ZN4llvm6TripleaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZN4llvm6TripleaSEOS0_")
  //</editor-fold>
  public /*inline*/ Triple /*&*/ $assignMove(Triple /*&&*/$Prm0) {
    this.Data.$assignMove($Prm0.Data);
    this.Arch = $Prm0.Arch;
    this.SubArch = $Prm0.SubArch;
    this.Vendor = $Prm0.Vendor;
    this.OS = $Prm0.OS;
    this.Environment = $Prm0.Environment;
    this.ObjectFormat = $Prm0.ObjectFormat;
    return /*Deref*/this;
  }

  @Override public Triple clone() { return new Triple(this); }
  
  public String toString() {
    return "" + "Data=" + Data // NOI18N
              + ", Arch=" + Arch // NOI18N
              + ", SubArch=" + SubArch // NOI18N
              + ", Vendor=" + Vendor // NOI18N
              + ", OS=" + OS // NOI18N
              + ", Environment=" + Environment // NOI18N
              + ", ObjectFormat=" + ObjectFormat; // NOI18N
  }
/// @}
}
