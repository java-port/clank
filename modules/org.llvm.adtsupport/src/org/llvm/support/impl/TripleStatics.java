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
package org.llvm.support.impl;

import org.llvm.support.target.ARM;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.Triple.ArchType;
import org.llvm.support.target.ARM.*;
import org.llvm.support.sys.*;


//<editor-fold defaultstate="collapsed" desc="static type TripleStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL11parseFormatN4llvm9StringRefE;_ZL11parseVendorN4llvm9StringRefE;_ZL12parseARMArchN4llvm9StringRefE;_ZL12parseBPFArchN4llvm9StringRefE;_ZL12parseSubArchN4llvm9StringRefE;_ZL16getDefaultFormatRKN4llvm6TripleE;_ZL16parseEnvironmentN4llvm9StringRefE;_ZL20parseVersionFromNameN4llvm9StringRefERjS1_S1_;_ZL22getArchPointerBitWidthN4llvm6Triple8ArchTypeE;_ZL23getObjectFormatTypeNameN4llvm6Triple16ObjectFormatTypeE;_ZL7parseOSN4llvm9StringRefE;_ZL9EatNumberRN4llvm9StringRefE;_ZL9parseArchN4llvm9StringRefE; -static-type=TripleStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class TripleStatics {

//<editor-fold defaultstate="collapsed" desc="parseBPFArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 225,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 213,
 FQN="parseBPFArch", NM="_ZL12parseBPFArchN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL12parseBPFArchN4llvm9StringRefE")
//</editor-fold>
public static Triple.ArchType parseBPFArch(StringRef ArchName) {
  if (ArchName.equals(/*STRINGREF_STR*/"bpf")) {
    if (sys.IsLittleEndianHost) {
      return Triple.ArchType.bpfel;
    } else {
      return Triple.ArchType.bpfeb;
    }
  } else if (ArchName.equals(/*STRINGREF_STR*/"bpf_be") || ArchName.equals(/*STRINGREF_STR*/"bpfeb")) {
    return Triple.ArchType.bpfeb;
  } else if (ArchName.equals(/*STRINGREF_STR*/"bpf_le") || ArchName.equals(/*STRINGREF_STR*/"bpfel")) {
    return Triple.ArchType.bpfel;
  } else {
    return Triple.ArchType.UnknownArch;
  }
}

//<editor-fold defaultstate="collapsed" desc="parseARMArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 292,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 277,
 FQN="parseARMArch", NM="_ZL12parseARMArchN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL12parseARMArchN4llvm9StringRefE")
//</editor-fold>
public static Triple.ArchType parseARMArch(StringRef ArchName) {
  /*uint*/int ISA = ARM.parseArchISA(/*NO_COPY*/ArchName);
  /*uint*/int ENDIAN = ARM.parseArchEndian(/*NO_COPY*/ArchName);
  
  Triple.ArchType arch = Triple.ArchType.UnknownArch;
  switch (EndianKind.valueOf(ENDIAN)) {
   case EK_LITTLE:
    {
      switch (ISAKind.valueOf(ISA)) {
       case IK_ARM:
        arch = Triple.ArchType.arm;
        break;
       case IK_THUMB:
        arch = Triple.ArchType.thumb;
        break;
       case IK_AARCH64:
        arch = Triple.ArchType.aarch64;
        break;
      }
      break;
    }
   case EK_BIG:
    {
      switch (ISAKind.valueOf(ISA)) {
       case IK_ARM:
        arch = Triple.ArchType.armeb;
        break;
       case IK_THUMB:
        arch = Triple.ArchType.thumbeb;
        break;
       case IK_AARCH64:
        arch = Triple.ArchType.aarch64_be;
        break;
      }
      break;
    }
  }
  
  ArchName.$assignMove(ARM.getCanonicalArchName(/*NO_COPY*/ArchName));
  if (ArchName.empty()) {
    return Triple.ArchType.UnknownArch;
  }
  
  // Thumb only exists in v4+
  if (ISA == ARM.ISAKind.IK_THUMB.getValue()
     && (ArchName.startswith(/*STRINGREF_STR*/"v2") || ArchName.startswith(/*STRINGREF_STR*/"v3"))) {
    return Triple.ArchType.UnknownArch;
  }
  
  // Thumb only for v6m
  /*uint*/int Profile = ARM.parseArchProfile(/*NO_COPY*/ArchName);
  /*uint*/int Version = ARM.parseArchVersion(/*NO_COPY*/ArchName);
  if (Profile == ARM.ProfileKind.PK_M.getValue() && Version == 6) {
    if (ENDIAN == ARM.EndianKind.EK_BIG.getValue()) {
      return Triple.ArchType.thumbeb;
    } else {
      return Triple.ArchType.thumb;
    }
  }
  
  return arch;
}

//<editor-fold defaultstate="collapsed" desc="parseArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 350,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 335,
 FQN="parseArch", NM="_ZL9parseArchN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL9parseArchN4llvm9StringRefE")
//</editor-fold>
public static Triple.ArchType parseArch(StringRef ArchName) {
  ArchType AT = new StringSwitch<Triple.ArchType>(/*NO_COPY*/ArchName).
      Cases(/*KEEP_STR*/"i386", /*KEEP_STR*/"i486", /*KEEP_STR*/"i586", /*KEEP_STR*/"i686", Triple.ArchType.x86).
      // FIXME: Do we need to support these?
      Cases(/*KEEP_STR*/"i786", /*KEEP_STR*/"i886", /*KEEP_STR*/"i986", Triple.ArchType.x86).
      Cases(/*KEEP_STR*/"amd64", /*KEEP_STR*/"x86_64", /*KEEP_STR*/"x86_64h", Triple.ArchType.x86_64).
      Cases(/*KEEP_STR*/"powerpc", /*KEEP_STR*/"ppc32", Triple.ArchType.ppc).
      Cases(/*KEEP_STR*/"powerpc64", /*KEEP_STR*/"ppu", /*KEEP_STR*/"ppc64", Triple.ArchType.ppc64).
      Cases(/*KEEP_STR*/"powerpc64le", /*KEEP_STR*/"ppc64le", Triple.ArchType.ppc64le).
      Case(/*KEEP_STR*/"xscale", Triple.ArchType.arm).
      Case(/*KEEP_STR*/"xscaleeb", Triple.ArchType.armeb).
      Case(/*KEEP_STR*/"aarch64", Triple.ArchType.aarch64).
      Case(/*KEEP_STR*/"aarch64_be", Triple.ArchType.aarch64_be).
      Case(/*KEEP_STR*/"arm64", Triple.ArchType.aarch64).
      Case(/*KEEP_STR*/"arm", Triple.ArchType.arm).
      Case(/*KEEP_STR*/"armeb", Triple.ArchType.armeb).
      Case(/*KEEP_STR*/"thumb", Triple.ArchType.thumb).
      Case(/*KEEP_STR*/"thumbeb", Triple.ArchType.thumbeb).
      Case(/*KEEP_STR*/"avr", Triple.ArchType.avr).
      Case(/*KEEP_STR*/"msp430", Triple.ArchType.msp430).
      Cases(/*KEEP_STR*/"mips", /*KEEP_STR*/"mipseb", /*KEEP_STR*/"mipsallegrex", Triple.ArchType.mips).
      Cases(/*KEEP_STR*/"mipsel", /*KEEP_STR*/"mipsallegrexel", Triple.ArchType.mipsel).
      Cases(/*KEEP_STR*/"mips64", /*KEEP_STR*/"mips64eb", Triple.ArchType.mips64).
      Case(/*KEEP_STR*/"mips64el", Triple.ArchType.mips64el).
      Case(/*KEEP_STR*/"r600", Triple.ArchType.r600).
      Case(/*KEEP_STR*/"amdgcn", Triple.ArchType.amdgcn).
      Case(/*KEEP_STR*/"hexagon", Triple.ArchType.hexagon).
      Cases(/*KEEP_STR*/"s390x", /*KEEP_STR*/"systemz", Triple.ArchType.systemz).
      Case(/*KEEP_STR*/"sparc", Triple.ArchType.sparc).
      Case(/*KEEP_STR*/"sparcel", Triple.ArchType.sparcel).
      Cases(/*KEEP_STR*/"sparcv9", /*KEEP_STR*/"sparc64", Triple.ArchType.sparcv9).
      Case(/*KEEP_STR*/"tce", Triple.ArchType.tce).
      Case(/*KEEP_STR*/"xcore", Triple.ArchType.xcore).
      Case(/*KEEP_STR*/"nvptx", Triple.ArchType.nvptx).
      Case(/*KEEP_STR*/"nvptx64", Triple.ArchType.nvptx64).
      Case(/*KEEP_STR*/"le32", Triple.ArchType.le32).
      Case(/*KEEP_STR*/"le64", Triple.ArchType.le64).
      Case(/*KEEP_STR*/"amdil", Triple.ArchType.amdil).
      Case(/*KEEP_STR*/"amdil64", Triple.ArchType.amdil64).
      Case(/*KEEP_STR*/"hsail", Triple.ArchType.hsail).
      Case(/*KEEP_STR*/"hsail64", Triple.ArchType.hsail64).
      Case(/*KEEP_STR*/"spir", Triple.ArchType.spir).
      Case(/*KEEP_STR*/"spir64", Triple.ArchType.spir64).
      StartsWith(/*KEEP_STR*/"kalimba", Triple.ArchType.kalimba).
      Case(/*KEEP_STR*/"lanai", Triple.ArchType.lanai).
      Case(/*KEEP_STR*/"shave", Triple.ArchType.shave).
      Case(/*KEEP_STR*/"wasm32", Triple.ArchType.wasm32).
      Case(/*KEEP_STR*/"wasm64", Triple.ArchType.wasm64).
      Case(/*KEEP_STR*/"renderscript32", Triple.ArchType.renderscript32).
      Case(/*KEEP_STR*/"renderscript64", Triple.ArchType.renderscript64).
      Default(Triple.ArchType.UnknownArch);
  
  // Some architectures require special parsing logic just to compute the
  // ArchType result.
  if (AT == Triple.ArchType.UnknownArch) {
    if (ArchName.startswith(/*STRINGREF_STR*/"arm") || ArchName.startswith(/*STRINGREF_STR*/"thumb")
       || ArchName.startswith(/*STRINGREF_STR*/"aarch64")) {
      return parseARMArch(new StringRef(ArchName));
    }
    if (ArchName.startswith(/*STRINGREF_STR*/"bpf")) {
      return parseBPFArch(/*NO_COPY*/ArchName);
    }
  }
  
  return AT;
}

//<editor-fold defaultstate="collapsed" desc="parseVendor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 415,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 397,
 FQN="parseVendor", NM="_ZL11parseVendorN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL11parseVendorN4llvm9StringRefE")
//</editor-fold>
public static Triple.VendorType parseVendor(StringRef VendorName) {
  return new StringSwitch<Triple.VendorType>(/*NO_COPY*/VendorName).
      Case(/*KEEP_STR*/"apple", Triple.VendorType.Apple).
      Case(/*KEEP_STR*/"pc", Triple.VendorType.PC).
      Case(/*KEEP_STR*/"scei", Triple.VendorType.SCEI).
      Case(/*KEEP_STR*/"bgp", Triple.VendorType.BGP).
      Case(/*KEEP_STR*/"bgq", Triple.VendorType.BGQ).
      Case(/*KEEP_STR*/"fsl", Triple.VendorType.Freescale).
      Case(/*KEEP_STR*/"ibm", Triple.VendorType.IBM).
      Case(/*KEEP_STR*/"img", Triple.VendorType.ImaginationTechnologies).
      Case(/*KEEP_STR*/"mti", Triple.VendorType.MipsTechnologies).
      Case(/*KEEP_STR*/"nvidia", Triple.VendorType.NVIDIA).
      Case(/*KEEP_STR*/"csr", Triple.VendorType.CSR).
      Case(/*KEEP_STR*/"myriad", Triple.VendorType.Myriad).
      Case(/*KEEP_STR*/"amd", Triple.VendorType.AMD).
      Case(/*KEEP_STR*/"mesa", Triple.VendorType.Mesa).
      Default(Triple.VendorType.UnknownVendor);
}

//<editor-fold defaultstate="collapsed" desc="parseOS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 434,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 414,
 FQN="parseOS", NM="_ZL7parseOSN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL7parseOSN4llvm9StringRefE")
//</editor-fold>
public static Triple.OSType parseOS(StringRef OSName) {
  return new StringSwitch<Triple.OSType>(/*NO_COPY*/OSName).
      StartsWith(/*KEEP_STR*/"cloudabi", Triple.OSType.CloudABI).
      StartsWith(/*KEEP_STR*/"darwin", Triple.OSType.Darwin).
      StartsWith(/*KEEP_STR*/"dragonfly", Triple.OSType.DragonFly).
      StartsWith(/*KEEP_STR*/"freebsd", Triple.OSType.FreeBSD).
      StartsWith(/*KEEP_STR*/"ios", Triple.OSType.IOS).
      StartsWith(/*KEEP_STR*/"kfreebsd", Triple.OSType.KFreeBSD).
      StartsWith(/*KEEP_STR*/"linux", Triple.OSType.Linux).
      StartsWith(/*KEEP_STR*/"lv2", Triple.OSType.Lv2).
      StartsWith(/*KEEP_STR*/"macosx", Triple.OSType.MacOSX).
      StartsWith(/*KEEP_STR*/"netbsd", Triple.OSType.NetBSD).
      StartsWith(/*KEEP_STR*/"openbsd", Triple.OSType.OpenBSD).
      StartsWith(/*KEEP_STR*/"solaris", Triple.OSType.Solaris).
      StartsWith(/*KEEP_STR*/"win32", Triple.OSType.Win32).
      StartsWith(/*KEEP_STR*/"windows", Triple.OSType.Win32).
      StartsWith(/*KEEP_STR*/"haiku", Triple.OSType.Haiku).
      StartsWith(/*KEEP_STR*/"minix", Triple.OSType.Minix).
      StartsWith(/*KEEP_STR*/"rtems", Triple.OSType.RTEMS).
      StartsWith(/*KEEP_STR*/"nacl", Triple.OSType.NaCl).
      StartsWith(/*KEEP_STR*/"cnk", Triple.OSType.CNK).
      StartsWith(/*KEEP_STR*/"bitrig", Triple.OSType.Bitrig).
      StartsWith(/*KEEP_STR*/"aix", Triple.OSType.AIX).
      StartsWith(/*KEEP_STR*/"cuda", Triple.OSType.CUDA).
      StartsWith(/*KEEP_STR*/"nvcl", Triple.OSType.NVCL).
      StartsWith(/*KEEP_STR*/"amdhsa", Triple.OSType.AMDHSA).
      StartsWith(/*KEEP_STR*/"ps4", Triple.OSType.PS4).
      StartsWith(/*KEEP_STR*/"elfiamcu", Triple.OSType.ELFIAMCU).
      StartsWith(/*KEEP_STR*/"tvos", Triple.OSType.TvOS).
      StartsWith(/*KEEP_STR*/"watchos", Triple.OSType.WatchOS).
      StartsWith(/*KEEP_STR*/"mesa3d", Triple.OSType.Mesa3D).
      Default(Triple.OSType.UnknownOS);
}

//<editor-fold defaultstate="collapsed" desc="parseEnvironment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 468,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 447,
 FQN="parseEnvironment", NM="_ZL16parseEnvironmentN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL16parseEnvironmentN4llvm9StringRefE")
//</editor-fold>
public static Triple.EnvironmentType parseEnvironment(StringRef EnvironmentName) {
  return new StringSwitch<Triple.EnvironmentType>(/*NO_COPY*/EnvironmentName).
      StartsWith(/*KEEP_STR*/"eabihf", Triple.EnvironmentType.EABIHF).
      StartsWith(/*KEEP_STR*/"eabi", Triple.EnvironmentType.EABI).
      StartsWith(/*KEEP_STR*/"gnuabi64", Triple.EnvironmentType.GNUABI64).
      StartsWith(/*KEEP_STR*/"gnueabihf", Triple.EnvironmentType.GNUEABIHF).
      StartsWith(/*KEEP_STR*/"gnueabi", Triple.EnvironmentType.GNUEABI).
      StartsWith(/*KEEP_STR*/"gnux32", Triple.EnvironmentType.GNUX32).
      StartsWith(/*KEEP_STR*/"code16", Triple.EnvironmentType.CODE16).
      StartsWith(/*KEEP_STR*/"gnu", Triple.EnvironmentType.GNU).
      StartsWith(/*KEEP_STR*/"android", Triple.EnvironmentType.Android).
      StartsWith(/*KEEP_STR*/"musleabihf", Triple.EnvironmentType.MuslEABIHF).
      StartsWith(/*KEEP_STR*/"musleabi", Triple.EnvironmentType.MuslEABI).
      StartsWith(/*KEEP_STR*/"musl", Triple.EnvironmentType.Musl).
      StartsWith(/*KEEP_STR*/"msvc", Triple.EnvironmentType.MSVC).
      StartsWith(/*KEEP_STR*/"itanium", Triple.EnvironmentType.Itanium).
      StartsWith(/*KEEP_STR*/"cygnus", Triple.EnvironmentType.Cygnus).
      StartsWith(/*KEEP_STR*/"amdopencl", Triple.EnvironmentType.AMDOpenCL).
      StartsWith(/*KEEP_STR*/"coreclr", Triple.EnvironmentType.CoreCLR).
      Default(Triple.EnvironmentType.UnknownEnvironment);
}

//<editor-fold defaultstate="collapsed" desc="parseFormat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 490,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 465,
 FQN="parseFormat", NM="_ZL11parseFormatN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL11parseFormatN4llvm9StringRefE")
//</editor-fold>
public static Triple.ObjectFormatType parseFormat(StringRef EnvironmentName) {
  return new StringSwitch<Triple.ObjectFormatType>(/*NO_COPY*/EnvironmentName).
      EndsWith(/*KEEP_STR*/"coff", Triple.ObjectFormatType.COFF).
      EndsWith(/*KEEP_STR*/"elf", Triple.ObjectFormatType.ELF).
      EndsWith(/*KEEP_STR*/"macho", Triple.ObjectFormatType.MachO).
      Default(Triple.ObjectFormatType.UnknownObjectFormat);
}

//<editor-fold defaultstate="collapsed" desc="parseSubArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 498,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 473,
 FQN="parseSubArch", NM="_ZL12parseSubArchN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL12parseSubArchN4llvm9StringRefE")
//</editor-fold>
public static Triple.SubArchType parseSubArch(StringRef SubArchName) {
  StringRef ARMSubArch = ARM.getCanonicalArchName(/*NO_COPY*/SubArchName);
  
  // For now, this is the small part. Early return.
  if (ARMSubArch.empty()) {
    return new StringSwitch<Triple.SubArchType>(/*NO_COPY*/SubArchName).
        EndsWith(/*KEEP_STR*/"kalimba3", Triple.SubArchType.KalimbaSubArch_v3).
        EndsWith(/*KEEP_STR*/"kalimba4", Triple.SubArchType.KalimbaSubArch_v4).
        EndsWith(/*KEEP_STR*/"kalimba5", Triple.SubArchType.KalimbaSubArch_v5).
        Default(Triple.SubArchType.NoSubArch);
  }
  
  // ARM sub arch.
  switch (ArchKind.valueOf(ARM.parseArch(/*NO_COPY*/ARMSubArch))) {
   case AK_ARMV4:
    return Triple.SubArchType.NoSubArch;
   case AK_ARMV4T:
    return Triple.SubArchType.ARMSubArch_v4t;
   case AK_ARMV5T:
    return Triple.SubArchType.ARMSubArch_v5;
   case AK_ARMV5TE:
   case AK_IWMMXT:
   case AK_IWMMXT2:
   case AK_XSCALE:
   case AK_ARMV5TEJ:
    return Triple.SubArchType.ARMSubArch_v5te;
   case AK_ARMV6:
    return Triple.SubArchType.ARMSubArch_v6;
   case AK_ARMV6K:
   case AK_ARMV6KZ:
    return Triple.SubArchType.ARMSubArch_v6k;
   case AK_ARMV6T2:
    return Triple.SubArchType.ARMSubArch_v6t2;
   case AK_ARMV6M:
    return Triple.SubArchType.ARMSubArch_v6m;
   case AK_ARMV7A:
   case AK_ARMV7R:
    return Triple.SubArchType.ARMSubArch_v7;
   case AK_ARMV7K:
    return Triple.SubArchType.ARMSubArch_v7k;
   case AK_ARMV7M:
    return Triple.SubArchType.ARMSubArch_v7m;
   case AK_ARMV7S:
    return Triple.SubArchType.ARMSubArch_v7s;
   case AK_ARMV7EM:
    return Triple.SubArchType.ARMSubArch_v7em;
   case AK_ARMV8A:
    return Triple.SubArchType.ARMSubArch_v8;
   case AK_ARMV8_1A:
    return Triple.SubArchType.ARMSubArch_v8_1a;
   case AK_ARMV8_2A:
    return Triple.SubArchType.ARMSubArch_v8_2a;
   case AK_ARMV8MBaseline:
    return Triple.SubArchType.ARMSubArch_v8m_baseline;
   case AK_ARMV8MMainline:
    return Triple.SubArchType.ARMSubArch_v8m_mainline;
   default:
    return Triple.SubArchType.NoSubArch;
  }
}

//<editor-fold defaultstate="collapsed" desc="getObjectFormatTypeName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 558,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 529,
 FQN="getObjectFormatTypeName", NM="_ZL23getObjectFormatTypeNameN4llvm6Triple16ObjectFormatTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL23getObjectFormatTypeNameN4llvm6Triple16ObjectFormatTypeE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getObjectFormatTypeName(Triple.ObjectFormatType Kind) {
  switch (Kind) {
   case UnknownObjectFormat:
    return $EMPTY;
   case COFF:
    return $("coff");
   case ELF:
    return $("elf");
   case MachO:
    return $("macho");
  }
  throw new llvm_unreachable("unknown object format type");
}

//<editor-fold defaultstate="collapsed" desc="getDefaultFormat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 568,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 539,
 FQN="getDefaultFormat", NM="_ZL16getDefaultFormatRKN4llvm6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL16getDefaultFormatRKN4llvm6TripleE")
//</editor-fold>
public static Triple.ObjectFormatType getDefaultFormat(/*const*/ Triple /*&*/ T) {
  switch (T.getArch()) {
   case UnknownArch:
   case aarch64:
   case arm:
   case thumb:
   case x86:
   case x86_64:
    if (T.isOSDarwin()) {
      return Triple.ObjectFormatType.MachO;
    } else if (T.isOSWindows()) {
      return Triple.ObjectFormatType.COFF;
    }
    return Triple.ObjectFormatType.ELF;
   case aarch64_be:
   case amdgcn:
   case amdil:
   case amdil64:
   case armeb:
   case avr:
   case bpfeb:
   case bpfel:
   case hexagon:
   case lanai:
   case hsail:
   case hsail64:
   case kalimba:
   case le32:
   case le64:
   case mips:
   case mips64:
   case mips64el:
   case mipsel:
   case msp430:
   case nvptx:
   case nvptx64:
   case ppc64le:
   case r600:
   case renderscript32:
   case renderscript64:
   case shave:
   case sparc:
   case sparcel:
   case sparcv9:
   case spir:
   case spir64:
   case systemz:
   case tce:
   case thumbeb:
   case wasm32:
   case wasm64:
   case xcore:
    return Triple.ObjectFormatType.ELF;
   case ppc:
   case ppc64:
    if (T.isOSDarwin()) {
      return Triple.ObjectFormatType.MachO;
    }
    return Triple.ObjectFormatType.ELF;
  }
  throw new llvm_unreachable("unknown architecture");
}

//<editor-fold defaultstate="collapsed" desc="EatNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 906,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 874,
 FQN="EatNumber", NM="_ZL9EatNumberRN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL9EatNumberRN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int EatNumber(StringRef /*&*/ Str) {
  assert (!Str.empty() && Str.$at(0) >= $$0 && Str.$at(0) <= $$9) : "Not a number";
  /*uint*/int Result = 0;
  
  do {
    // Consume the leading digit.
    Result = Result * 10 + (Str.$at(0) - $$0);
    
    // Eat the digit.
    Str.$assignMove(Str.substr(1));
  } while (!Str.empty() && Str.$at(0) >= $$0 && Str.$at(0) <= $$9);
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="parseVersionFromName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 921,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 889,
 FQN="parseVersionFromName", NM="_ZL20parseVersionFromNameN4llvm9StringRefERjS1_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL20parseVersionFromNameN4llvm9StringRefERjS1_S1_")
//</editor-fold>
public static void parseVersionFromName(StringRef Name, uint$ref/*uint &*/ Major, 
                    uint$ref/*uint &*/ Minor, uint$ref/*uint &*/ Micro) {
  // Any unset version defaults to 0.
  Major.$set(Minor.$set(Micro.$set(0)));
  
  // Parse up to three components.
  uint$ptr/*uint P*/ Components[/*3*/] = (new uint$ptr/*uint P*/ [/*3*/] {Major.deref$ptr(), Minor.deref$ptr(), Micro.deref$ptr()});
  for (/*uint*/int i = 0; i != 3; ++i) {
    if (Name.empty() || Name.$at(0) < $$0 || Name.$at(0) > $$9) {
      break;
    }
    
    // Consume the leading number.
    Components[i].$set(EatNumber(Name));
    
    // Consume the separator, if present.
    if (Name.startswith(/*STRINGREF_STR*/".")) {
      Name.$assignMove(Name.substr(1));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="getArchPointerBitWidth">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", line = 1117,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Triple.cpp", old_line = 1085,
 FQN="getArchPointerBitWidth", NM="_ZL22getArchPointerBitWidthN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Triple.cpp -nm=_ZL22getArchPointerBitWidthN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static /*uint*/int getArchPointerBitWidth(Triple.ArchType Arch) {
  switch (Arch) {
   case UnknownArch:
    return 0;
   case avr:
   case msp430:
    return 16;
   case arm:
   case armeb:
   case hexagon:
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
   case amdil:
   case hsail:
   case spir:
   case kalimba:
   case lanai:
   case shave:
   case wasm32:
   case renderscript32:
    return 32;
   case aarch64:
   case aarch64_be:
   case amdgcn:
   case bpfel:
   case bpfeb:
   case le64:
   case mips64:
   case mips64el:
   case nvptx64:
   case ppc64:
   case ppc64le:
   case sparcv9:
   case systemz:
   case x86_64:
   case amdil64:
   case hsail64:
   case spir64:
   case wasm64:
   case renderscript64:
    return 64;
  }
  throw new llvm_unreachable("Invalid architecture value");
}

} // END OF class TripleStatics
