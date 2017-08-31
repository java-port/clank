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
package org.clang.driver.impl;

import org.llvm.support.target.ARM;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.driver.impl.ToolChainsStatics.*;
import org.clang.driver.java.DriverFunctionPointers.*;


//<editor-fold defaultstate="collapsed" desc="static type ToolChainsStatics">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 NM="org.clang.driver.impl.ToolChainsStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL10IsOpenSUSE6Distro;_ZL10isMipsArchN4llvm6Triple8ArchTypeE;_ZL11getOSLibDirRKN4llvm6TripleERKNS_3opt7ArgListE;_ZL11isMicroMipsRKN4llvm3opt7ArgListE;_ZL12DetectDistroRKN5clang6driver6DriverEN4llvm6Triple8ArchTypeE;_ZL12makeMultilibN4llvm9StringRefE;_ZL14isSoftFloatABIRKN4llvm3opt7ArgListE;_ZL15addMultilibFlagbPKcRSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS7_EE;_ZL15addPathIfExistsRKN5clang6driver6DriverERKN4llvm5TwineERNS4_11SmallVectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEELj16EEE;_ZL16ArmMachOArchNameN4llvm9StringRefE;_ZL16isArmOrThumbArchN4llvm6Triple8ArchTypeE;_ZL17findMIPSMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListERN12_GLOBAL__N_117DetectedMultilibsE;_ZL18getGCCToolchainDirRKN4llvm3opt7ArgListE;_ZL18getMultiarchTripleB5cxx11RKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefE;_ZL18isObjCAutoRefCountRKN4llvm3opt7ArgListE;_ZL19ArmMachOArchNameCPUN4llvm9StringRefE;_ZL19findBiarchMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListEbRN12_GLOBAL__N_117DetectedMultilibsE;_ZL19findMipsCsMultilibsRKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS5_EERN12_GLOBAL__N_117FilterNonExistentERNSA_17DetectedMultilibsE;_ZL20ParseCudaVersionFileN4llvm9StringRefE;_ZL20findMipsImgMultilibsRKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS5_EERN12_GLOBAL__N_117FilterNonExistentERNSA_17DetectedMultilibsE;_ZL20findMipsMtiMultilibsRKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS5_EERN12_GLOBAL__N_117FilterNonExistentERNSA_17DetectedMultilibsE;_ZL21addMultilibsFilePathsRKN5clang6driver6DriverERKNS0_11MultilibSetERKNS0_8MultilibEN4llvm9StringRefERNSA_11SmallVectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEELj16EEE;_ZL21findMipsMuslMultilibsRKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS5_EERN12_GLOBAL__N_117FilterNonExistentERNSA_17DetectedMultilibsE;_ZL23DetectLibcxxIncludePathB5cxx11N4llvm9StringRefE;_ZL23findAndroidArmMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListERN12_GLOBAL__N_117DetectedMultilibsE;_ZL24findMipsAndroidMultilibsRKSt6vectorINSt7__cxx1112basic_stringIcSt11char_traitsIcESaIcEEESaIS5_EERN12_GLOBAL__N_117FilterNonExistentERNSA_17DetectedMultilibsE;_ZL8IsDebian6Distro;_ZL8IsRedhat6Distro;_ZL8IsUbuntu6Distro;_ZL8isMips16RKN4llvm3opt7ArgListE;_ZL8isMips32N4llvm6Triple8ArchTypeE;_ZL8isMips64N4llvm6Triple8ArchTypeE;_ZL8isMipsELN4llvm6Triple8ArchTypeE; -static-type=ToolChainsStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class ToolChainsStatics {


// This is just a MachO name translation routine and there's no
// way to join this into ARMTargetParser without breaking all
// other assumptions. Maybe MachO should consider standardising
// their nomenclature.
//<editor-fold defaultstate="collapsed" desc="ArmMachOArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 106,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 95,
 FQN="ArmMachOArchName", NM="_ZL16ArmMachOArchNameN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL16ArmMachOArchNameN4llvm9StringRefE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ArmMachOArchName(StringRef Arch) {
  return new StringSwitchCharPtr(/*NO_COPY*/Arch).
      Case(/*KEEP_STR*/"armv6k", /*KEEP_STR*/"armv6").
      Case(/*KEEP_STR*/"armv6m", /*KEEP_STR*/"armv6m").
      Case(/*KEEP_STR*/"armv5tej", /*KEEP_STR*/"armv5").
      Case(/*KEEP_STR*/"xscale", /*KEEP_STR*/"xscale").
      Case(/*KEEP_STR*/"armv4t", /*KEEP_STR*/"armv4t").
      Case(/*KEEP_STR*/"armv7", /*KEEP_STR*/"armv7").
      Cases(/*KEEP_STR*/"armv7a", /*KEEP_STR*/"armv7-a", /*KEEP_STR*/"armv7").
      Cases(/*KEEP_STR*/"armv7r", /*KEEP_STR*/"armv7-r", /*KEEP_STR*/"armv7").
      Cases(/*KEEP_STR*/"armv7em", /*KEEP_STR*/"armv7e-m", /*KEEP_STR*/"armv7em").
      Cases(/*KEEP_STR*/"armv7k", /*KEEP_STR*/"armv7-k", /*KEEP_STR*/"armv7k").
      Cases(/*KEEP_STR*/"armv7m", /*KEEP_STR*/"armv7-m", /*KEEP_STR*/"armv7m").
      Cases(/*KEEP_STR*/"armv7s", /*KEEP_STR*/"armv7-s", /*KEEP_STR*/"armv7s").
      Default(/*NULL*/(/*const*/char$ptr/*char P*//*const*/)null);
}

//<editor-fold defaultstate="collapsed" desc="ArmMachOArchNameCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 123,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 112,
 FQN="ArmMachOArchNameCPU", NM="_ZL19ArmMachOArchNameCPUN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL19ArmMachOArchNameCPUN4llvm9StringRefE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ ArmMachOArchNameCPU(StringRef CPU) {
  /*uint*/int ArchKind = ARM.parseCPUArch(/*NO_COPY*/CPU);
  if (ArchKind == ARM.ArchKind.AK_INVALID.getValue()) {
    return null;
  }
  StringRef Arch = ARM.getArchName(ArchKind);
  
  // FIXME: Make sure this MachO triple mangling is really necessary.
  // ARMv5* normalises to ARMv5.
  if (Arch.startswith(/*STRINGREF_STR*/"armv5")) {
    Arch.$assignMove(Arch.substr(0, 5));
  } else // ARMv6*, except ARMv6M, normalises to ARMv6.
  if (Arch.startswith(/*STRINGREF_STR*/"armv6") && !Arch.endswith(/*STRINGREF_STR*/"6m")) {
    Arch.$assignMove(Arch.substr(0, 5));
  } else // ARMv7A normalises to ARMv7.
  if (Arch.endswith(/*STRINGREF_STR*/"v7a")) {
    Arch.$assignMove(Arch.substr(0, 5));
  }
  return Arch.data();
}

//<editor-fold defaultstate="collapsed" desc="isSoftFloatABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 142,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 131,
 FQN="isSoftFloatABI", NM="_ZL14isSoftFloatABIRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL14isSoftFloatABIRKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isSoftFloatABI(final /*const*/ ArgList /*&*/ Args) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_msoft_float.getValue()), new OptSpecifier(options.ID.OPT_mhard_float.getValue()), 
      new OptSpecifier(options.ID.OPT_mfloat_abi_EQ.getValue()));
  if (!(A != null)) {
    return false;
  }
  
  return A.getOption().matches(new OptSpecifier(options.ID.OPT_msoft_float.getValue()))
     || (A.getOption().matches(new OptSpecifier(options.ID.OPT_mfloat_abi_EQ.getValue()))
     && $eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/"soft"));
}


/// \brief Determine whether Objective-C automated reference counting is
/// enabled.
//<editor-fold defaultstate="collapsed" desc="isObjCAutoRefCount">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 258,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 271,
 FQN="isObjCAutoRefCount", NM="_ZL18isObjCAutoRefCountRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL18isObjCAutoRefCountRKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isObjCAutoRefCount(final /*const*/ ArgList /*&*/ Args) {
  return Args.hasFlag(new OptSpecifier(options.ID.OPT_fobjc_arc.getValue()), new OptSpecifier(options.ID.OPT_fno_objc_arc.getValue()), false);
}

//<editor-fold defaultstate="collapsed" desc="getGCCToolchainDir">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1359,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1305,
 FQN="getGCCToolchainDir", NM="_ZL18getGCCToolchainDirRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL18getGCCToolchainDirRKN4llvm3opt7ArgListE")
//</editor-fold>
public static StringRef getGCCToolchainDir(final /*const*/ ArgList /*&*/ Args) {
  /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_gcc_toolchain.getValue()));
  if ((A != null)) {
    return new StringRef(A.getValue());
  }
  return new StringRef(/*KEEP_STR*/$EMPTY);
}


// Parses the contents of version.txt in an CUDA installation.  It should
// contain one line of the from e.g. "CUDA Version 7.5.2".
//<editor-fold defaultstate="collapsed" desc="ParseCudaVersionFile">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1702,
 FQN="ParseCudaVersionFile", NM="_ZL20ParseCudaVersionFileN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL20ParseCudaVersionFileN4llvm9StringRefE")
//</editor-fold>
public static CudaVersion ParseCudaVersionFile(StringRef V) {
  if (!V.startswith(/*STRINGREF_STR*/"CUDA Version ")) {
    return CudaVersion.UNKNOWN;
  }
  V.$assignMove(V.substr(strlen($("CUDA Version "))));
  int$ref $Major = create_int$ref(-1), $Minor = create_int$ref(-1);
  pair<StringRef, StringRef> First = V.split($$DOT);
  pair<StringRef, StringRef> Second = First.second.split($$DOT);
  if (!First.first.getAsInteger$Signed(10, $Major)
     || !Second.first.getAsInteger$Signed(10, $Minor)) {
    return CudaVersion.UNKNOWN;
  }
  int Major = $Major.$deref(), Minor = $Minor.$deref();
  if (Major == 7 && Minor == 0) {
    // This doesn't appear to ever happen -- version.txt doesn't exist in the
    // CUDA 7 installs I've seen.  But no harm in checking.
    return CudaVersion.CUDA_70;
  }
  if (Major == 7 && Minor == 5) {
    return CudaVersion.CUDA_75;
  }
  if (Major == 8 && Minor == 0) {
    return CudaVersion.CUDA_80;
  }
  return CudaVersion.UNKNOWN;
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="addMultilibFlag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1840,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1715,
 FQN="addMultilibFlag", NM="_ZL15addMultilibFlagbPKcRSt6vectorISsSaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL15addMultilibFlagbPKcRSt6vectorISsSaISsEE")
//</editor-fold>
public static void addMultilibFlag(boolean Enabled, /*const*/char$ptr/*char P*//*const*/ Flag, 
               final std.vectorString/*&*/ Flags) {
  if (Enabled) {
    Flags.push_back_T$RR($add_string_T$C$P(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$PLUS), Flag));
  } else {
    Flags.push_back_T$RR($add_string_T$C$P(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$MINUS), Flag));
  }
}

//<editor-fold defaultstate="collapsed" desc="isArmOrThumbArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1848,
 FQN="isArmOrThumbArch", NM="_ZL16isArmOrThumbArchN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL16isArmOrThumbArchN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static boolean isArmOrThumbArch(Triple.ArchType Arch) {
  return Arch == Triple.ArchType.arm || Arch == Triple.ArchType.thumb;
}

//<editor-fold defaultstate="collapsed" desc="isMipsArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1852,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1723,
 FQN="isMipsArch", NM="_ZL10isMipsArchN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL10isMipsArchN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static boolean isMipsArch(Triple.ArchType Arch) {
  return Arch == Triple.ArchType.mips || Arch == Triple.ArchType.mipsel
     || Arch == Triple.ArchType.mips64 || Arch == Triple.ArchType.mips64el;
}

//<editor-fold defaultstate="collapsed" desc="isMips32">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1857,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1728,
 FQN="isMips32", NM="_ZL8isMips32N4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8isMips32N4llvm6Triple8ArchTypeE")
//</editor-fold>
public static boolean isMips32(Triple.ArchType Arch) {
  return Arch == Triple.ArchType.mips || Arch == Triple.ArchType.mipsel;
}

//<editor-fold defaultstate="collapsed" desc="isMips64">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1861,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1732,
 FQN="isMips64", NM="_ZL8isMips64N4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8isMips64N4llvm6Triple8ArchTypeE")
//</editor-fold>
public static boolean isMips64(Triple.ArchType Arch) {
  return Arch == Triple.ArchType.mips64 || Arch == Triple.ArchType.mips64el;
}

//<editor-fold defaultstate="collapsed" desc="isMipsEL">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1865,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1736,
 FQN="isMipsEL", NM="_ZL8isMipsELN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8isMipsELN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static boolean isMipsEL(Triple.ArchType Arch) {
  return Arch == Triple.ArchType.mipsel || Arch == Triple.ArchType.mips64el;
}

//<editor-fold defaultstate="collapsed" desc="isMips16">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1869,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1740,
 FQN="isMips16", NM="_ZL8isMips16RKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8isMips16RKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isMips16(final /*const*/ ArgList /*&*/ Args) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mips16.getValue()), new OptSpecifier(options.ID.OPT_mno_mips16.getValue()));
  return (A != null) && A.getOption().matches(new OptSpecifier(options.ID.OPT_mips16.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="isMicroMips">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1874,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1745,
 FQN="isMicroMips", NM="_ZL11isMicroMipsRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL11isMicroMipsRKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isMicroMips(final /*const*/ ArgList /*&*/ Args) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mmicromips.getValue()), new OptSpecifier(options.ID.OPT_mno_micromips.getValue()));
  return (A != null) && A.getOption().matches(new OptSpecifier(options.ID.OPT_mmicromips.getValue()));
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="makeMultilib">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1893,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1764,
 FQN="makeMultilib", NM="_ZL12makeMultilibN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL12makeMultilibN4llvm9StringRefE")
//</editor-fold>
public static Multilib makeMultilib(StringRef commonSuffix) {
  return new Multilib(new StringRef(commonSuffix), new StringRef(commonSuffix), new StringRef(commonSuffix));
}

//<editor-fold defaultstate="collapsed" desc="findMipsCsMultilibs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1897,
 FQN="findMipsCsMultilibs", NM="_ZL19findMipsCsMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL19findMipsCsMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE")
//</editor-fold>
public static boolean findMipsCsMultilibs(final /*const*/std.vectorString/*&*/ Flags, 
                   final FilterNonExistent /*&*/ NonExistent, 
                   final DetectedMultilibs /*&*/ Result) {
  MultilibSet CSMipsMultilibs = null;
  MultilibSet DebianMipsMultilibs = null;
  try {
    // Check for Code Sourcery toolchain multilibs
    CSMipsMultilibs/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib MArchMips16 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips16")).flag(new StringRef(/*KEEP_STR*/"+m32")).flag(new StringRef(/*KEEP_STR*/"+mips16")));
        
        Multilib MArchMicroMips = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromips")).flag(new StringRef(/*KEEP_STR*/"+m32")).flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        
        Multilib MArchDefault = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"-mips16")).flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        
        Multilib UCLibc = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/uclibc")).flag(new StringRef(/*KEEP_STR*/"+muclibc")));
        
        Multilib SoftFloat = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/soft-float")).flag(new StringRef(/*KEEP_STR*/"+msoft-float")));
        
        Multilib Nan2008 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/nan2008")).flag(new StringRef(/*KEEP_STR*/"+mnan=2008")));
        
        Multilib DefaultFloat = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"-msoft-float")).flag(new StringRef(/*KEEP_STR*/"-mnan=2008")));
        
        Multilib BigEndian = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"+EB")).flag(new StringRef(/*KEEP_STR*/"-EL")));
        
        Multilib LittleEndian = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/el")).flag(new StringRef(/*KEEP_STR*/"+EL")).flag(new StringRef(/*KEEP_STR*/"-EB")));
        
        // Note that this one's osSuffix is ""
        Multilib MAbi64 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).
                gccSuffix(new StringRef(/*KEEP_STR*/"/64")).
                includeSuffix(new StringRef(/*KEEP_STR*/"/64")).
                flag(new StringRef(/*KEEP_STR*/"+mabi=n64")).
                flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).
                flag(new StringRef(/*KEEP_STR*/"-m32")));
        
          $c$.clean(CSMipsMultilibs.$assign(
              $c$.track(new MultilibSet()).
                  Either(MArchMips16, MArchMicroMips, MArchDefault).
                  Maybe(UCLibc).
                  Either(SoftFloat, Nan2008, DefaultFloat).
                  FilterOut(/*KEEP_STR*/"/micromips/nan2008").
                  FilterOut(/*KEEP_STR*/"/mips16/nan2008").
                  Either(BigEndian, LittleEndian).
                  Maybe(MAbi64).
                  FilterOut(/*KEEP_STR*/"/mips16.*/64").
                  FilterOut(/*KEEP_STR*/"/micromips.*/64").
                  FilterOut(/*FuncArg*/NonExistent).
                  setIncludeDirsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                        std.vectorString Dirs = null;
                        try {
                          Dirs/*J*/= $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {new std.string("/include")}), std.string.EMPTY));
                          if (new StringRef(M.includeSuffix()).startswith(/*STRINGREF_STR*/"/uclibc")) {
                            Dirs.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/../../../../mips-linux-gnu/libc/uclibc/usr/include"));
                          } else {
                            Dirs.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/../../../../mips-linux-gnu/libc/usr/include"));
                          }
                          return new std.vectorString(JD$Move.INSTANCE, Dirs);
                        } finally {
                          if (Dirs != null) { Dirs.$destroy(); }
                        }
                      })
          ));
      } finally {
        $c$.$destroy();
      }
    }
    
    DebianMipsMultilibs/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib MAbiN32 = new Multilib(new Multilib().gccSuffix(new StringRef(/*KEEP_STR*/"/n32")).includeSuffix(new StringRef(/*KEEP_STR*/"/n32")).flag(new StringRef(/*KEEP_STR*/"+mabi=n32")));
        
        Multilib M64 = new Multilib(new Multilib().
                gccSuffix(new StringRef(/*KEEP_STR*/"/64")).
                includeSuffix(new StringRef(/*KEEP_STR*/"/64")).
                flag(new StringRef(/*KEEP_STR*/"+m64")).
                flag(new StringRef(/*KEEP_STR*/"-m32")).
                flag(new StringRef(/*KEEP_STR*/"-mabi=n32")));
        
        Multilib M32 = new Multilib(new Multilib().flag(new StringRef(/*KEEP_STR*/"-m64")).flag(new StringRef(/*KEEP_STR*/"+m32")).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")));
        
        $c$.clean(DebianMipsMultilibs.$assign(
            $c$.track(new MultilibSet()).Either(M32, M64, MAbiN32).FilterOut(/*FuncArg*/NonExistent)
        ));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Sort candidates. Toolchain that best meets the directories tree goes first.
    // Then select the first toolchains matches command line flags.
    MultilibSet /*P*/ Candidates[/*2*/] = new MultilibSet /*P*/ [/*2*/] {/*AddrOf*/CSMipsMultilibs, /*AddrOf*/DebianMipsMultilibs};
    if ($less_uint(CSMipsMultilibs.size(), DebianMipsMultilibs.size())) {
      std.iter_swap(Candidates, 0, 1);
    }
    for (/*const*/ MultilibSet /*P*/ Candidate : Candidates) {
      if (Candidate.select(Flags, Result.SelectedMultilib)) {
        if (Candidate == $AddrOf(DebianMipsMultilibs)) {
          Result.BiarchSibling.$assign_T$RR(new Multilib());
        }
        Result.Multilibs.$assign($Deref(Candidate));
        return true;
      }
    }
    return false;
  } finally {
    if (DebianMipsMultilibs != null) { DebianMipsMultilibs.$destroy(); }
    if (CSMipsMultilibs != null) { CSMipsMultilibs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="findMipsAndroidMultilibs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1988,
 FQN="findMipsAndroidMultilibs", NM="_ZL24findMipsAndroidMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL24findMipsAndroidMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE")
//</editor-fold>
public static boolean findMipsAndroidMultilibs(final /*const*/std.vectorString/*&*/ Flags, 
                        final FilterNonExistent /*&*/ NonExistent, 
                        final DetectedMultilibs /*&*/ Result) {
  MultilibSet AndroidMipsMultilibs = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    AndroidMipsMultilibs = $c$.clean(new MultilibSet($c$.track(new MultilibSet()).
            Maybe(new Multilib(new StringRef(/*KEEP_STR*/"/mips-r2")).flag(new StringRef(/*KEEP_STR*/"+march=mips32r2"))).
            Maybe(new Multilib(new StringRef(/*KEEP_STR*/"/mips-r6")).flag(new StringRef(/*KEEP_STR*/"+march=mips32r6"))).
            FilterOut(/*FuncArg*/NonExistent)));
    if (AndroidMipsMultilibs.select(Flags, Result.SelectedMultilib)) {
      Result.Multilibs.$assign(AndroidMipsMultilibs);
      return true;
    }
    return false;
  } finally {
    if (AndroidMipsMultilibs != null) { AndroidMipsMultilibs.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="findMipsMuslMultilibs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2005,
 FQN="findMipsMuslMultilibs", NM="_ZL21findMipsMuslMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL21findMipsMuslMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE")
//</editor-fold>
public static boolean findMipsMuslMultilibs(final /*const*/std.vectorString/*&*/ Flags, 
                     final FilterNonExistent /*&*/ NonExistent, 
                     final DetectedMultilibs /*&*/ Result) {
  MultilibSet MuslMipsMultilibs = null;
  try {
    // Musl toolchain multilibs
    MuslMipsMultilibs/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib MArchMipsR2 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).
                osSuffix(new StringRef(/*KEEP_STR*/"/mips-r2-hard-musl")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-EL")).
                flag(new StringRef(/*KEEP_STR*/"+march=mips32r2")));
        
        Multilib MArchMipselR2 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r2-hard-musl")).
                flag(new StringRef(/*KEEP_STR*/"-EB")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"+march=mips32r2")));
        
        $c$.clean(MuslMipsMultilibs.$assign($c$.track(new MultilibSet()).Either(MArchMipsR2, MArchMipselR2)));
        
        // Specify the callback that computes the include directories.
        MuslMipsMultilibs.setIncludeDirsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                  return $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {$add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"/../sysroot", M.osSuffix()), /*KEEP_STR*/"/usr/include")}), std.string.EMPTY));
                });
      } finally {
        $c$.$destroy();
      }
    }
    if (MuslMipsMultilibs.select(Flags, Result.SelectedMultilib)) {
      Result.Multilibs.$assign(MuslMipsMultilibs);
      return true;
    }
    return false;
  } finally {
    if (MuslMipsMultilibs != null) { MuslMipsMultilibs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="findMipsMtiMultilibs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2037,
 FQN="findMipsMtiMultilibs", NM="_ZL20findMipsMtiMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL20findMipsMtiMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE")
//</editor-fold>
public static boolean findMipsMtiMultilibs(final /*const*/std.vectorString/*&*/ Flags, 
                    final FilterNonExistent /*&*/ NonExistent, 
                    final DetectedMultilibs /*&*/ Result) {
  MultilibSet MtiMipsMultilibsV1 = null;
  MultilibSet MtiMipsMultilibsV2 = null;
  try {
    // CodeScape MTI toolchain v1.2 and early.
    MtiMipsMultilibsV1/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib MArchMips32 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips32")).
                flag(new StringRef(/*KEEP_STR*/"+m32")).
                flag(new StringRef(/*KEEP_STR*/"-m64")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")).
                flag(new StringRef(/*KEEP_STR*/"+march=mips32")));
        
        Multilib MArchMicroMips = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromips")).
                flag(new StringRef(/*KEEP_STR*/"+m32")).
                flag(new StringRef(/*KEEP_STR*/"-m64")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        
        Multilib MArchMips64r2 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips64r2")).
                flag(new StringRef(/*KEEP_STR*/"-m32")).
                flag(new StringRef(/*KEEP_STR*/"+m64")).
                flag(new StringRef(/*KEEP_STR*/"+march=mips64r2")));
        
        Multilib MArchMips64 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips64")).flag(new StringRef(/*KEEP_STR*/"-m32")).flag(new StringRef(/*KEEP_STR*/"+m64")).flag(new StringRef(/*KEEP_STR*/"-march=mips64r2")));
        
        Multilib MArchDefault = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).
                flag(new StringRef(/*KEEP_STR*/"+m32")).
                flag(new StringRef(/*KEEP_STR*/"-m64")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")).
                flag(new StringRef(/*KEEP_STR*/"+march=mips32r2")));
        
        Multilib Mips16 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips16")).flag(new StringRef(/*KEEP_STR*/"+mips16")));
        
        Multilib UCLibc = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/uclibc")).flag(new StringRef(/*KEEP_STR*/"+muclibc")));
        
        Multilib MAbi64 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/64")).flag(new StringRef(/*KEEP_STR*/"+mabi=n64")).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).flag(new StringRef(/*KEEP_STR*/"-m32")));
        
        Multilib BigEndian = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"+EB")).flag(new StringRef(/*KEEP_STR*/"-EL")));
        
        Multilib LittleEndian = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/el")).flag(new StringRef(/*KEEP_STR*/"+EL")).flag(new StringRef(/*KEEP_STR*/"-EB")));
        
        Multilib SoftFloat = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/sof")).flag(new StringRef(/*KEEP_STR*/"+msoft-float")));
        
        Multilib Nan2008 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/nan2008")).flag(new StringRef(/*KEEP_STR*/"+mnan=2008")));
        
        $c$.clean(MtiMipsMultilibsV1.$assign(
            $c$.track(new MultilibSet()).
                Either(MArchMips32, MArchMicroMips, MArchMips64r2, MArchMips64, 
                MArchDefault).
                Maybe(UCLibc).
                Maybe(Mips16).
                FilterOut(/*KEEP_STR*/"/mips64/mips16").
                FilterOut(/*KEEP_STR*/"/mips64r2/mips16").
                FilterOut(/*KEEP_STR*/"/micromips/mips16").
                Maybe(MAbi64).
                FilterOut(/*KEEP_STR*/"/micromips/64").
                FilterOut(/*KEEP_STR*/"/mips32/64").
                FilterOut(/*KEEP_STR*/"^/64").
                FilterOut(/*KEEP_STR*/"/mips16/64").
                Either(BigEndian, LittleEndian).
                Maybe(SoftFloat).
                Maybe(Nan2008).
                FilterOut(/*KEEP_STR*/".*sof/nan2008").
                FilterOut(/*FuncArg*/NonExistent).
                setIncludeDirsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                      std.vectorString Dirs = null;
                      try {
                        Dirs/*J*/= $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {new std.string("/include")}), std.string.EMPTY));
                        if (new StringRef(M.includeSuffix()).startswith(/*STRINGREF_STR*/"/uclibc")) {
                          Dirs.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/../../../../sysroot/uclibc/usr/include"));
                        } else {
                          Dirs.push_back_T$RR(new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"/../../../../sysroot/usr/include"));
                        }
                        return new std.vectorString(JD$Move.INSTANCE, Dirs);
                      } finally {
                        if (Dirs != null) { Dirs.$destroy(); }
                      }
                    })
        ));
      } finally {
        $c$.$destroy();
      }
    }
    
    // CodeScape IMG toolchain starting from v1.3.
    MtiMipsMultilibsV2/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib BeHard = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r2-hard")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"-muclibc")));
        Multilib BeSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r2-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")));
        Multilib ElHard = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r2-hard")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"-muclibc")));
        Multilib ElSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r2-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        Multilib BeHardNan = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r2-hard-nan2008")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"-muclibc")));
        Multilib ElHardNan = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r2-hard-nan2008")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"-muclibc")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        Multilib BeHardNanUclibc = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r2-hard-nan2008-uclibc")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"+muclibc")));
        Multilib ElHardNanUclibc = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r2-hard-nan2008-uclibc")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"+muclibc")));
        Multilib BeHardUclibc = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r2-hard-uclibc")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"+muclibc")));
        Multilib ElHardUclibc = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r2-hard-uclibc")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"+muclibc")));
        Multilib ElMicroHardNan = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromipsel-r2-hard-nan2008")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        Multilib ElMicroSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromipsel-r2-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mnan=2008")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        
        Multilib O32 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/lib")).osSuffix(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).flag(new StringRef(/*KEEP_STR*/"-mabi=n64")));
        Multilib N32 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/lib32")).osSuffix(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"+mabi=n32")).flag(new StringRef(/*KEEP_STR*/"-mabi=n64")));
        Multilib N64 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/lib64")).osSuffix(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).flag(new StringRef(/*KEEP_STR*/"+mabi=n64")));
        
        $c$.clean(MtiMipsMultilibsV2.$assign(
            $c$.track(new MultilibSet()).
                Either(/*{ */new ArrayRef<Multilib>($c$.track(new /*const*/ Multilib [/*12*/] {
                      BeHard, BeSoft, ElHard, ElSoft, BeHardNan, ElHardNan, 
                      BeHardNanUclibc, ElHardNanUclibc, BeHardUclibc, 
                      ElHardUclibc, ElMicroHardNan, ElMicroSoft}), false)/* }*/).
                Either(O32, N32, N64).
                FilterOut(/*FuncArg*/NonExistent).
                setIncludeDirsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                        return $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {
                            $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"/../../../../sysroot", 
                                      M.includeSuffix()), 
                                  /*KEEP_STR*/"/../usr/include")
                            }), std.string.EMPTY));
                    }).
                setFilePathsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                      return $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {$add_T$C$P_string$C(/*KEEP_STR*/"/../../../../mips-mti-linux-gnu/lib", M.gccSuffix())}), std.string.EMPTY));
                    })
        ));
      } finally {
        $c$.$destroy();
      }
    }
    for (MultilibSet /*P*/ Candidate : new MultilibSet /*P*/ /*const*/ [/*2*/] {$AddrOf(MtiMipsMultilibsV1), $AddrOf(MtiMipsMultilibsV2)}) {
      if (Candidate.select(Flags, Result.SelectedMultilib)) {
        Result.Multilibs.$assign($Deref(Candidate));
        return true;
      }
    }
    return false;
  } finally {
    if (MtiMipsMultilibsV2 != null) { MtiMipsMultilibsV2.$destroy(); }
    if (MtiMipsMultilibsV1 != null) { MtiMipsMultilibsV1.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="findMipsImgMultilibs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2209,
 FQN="findMipsImgMultilibs", NM="_ZL20findMipsImgMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL20findMipsImgMultilibsRKSt6vectorISsSaISsEERN12_GLOBAL__N_117FilterNonExistentERNS4_17DetectedMultilibsE")
//</editor-fold>
public static boolean findMipsImgMultilibs(final /*const*/std.vectorString/*&*/ Flags, 
                    final FilterNonExistent /*&*/ NonExistent, 
                    final DetectedMultilibs /*&*/ Result) {
  MultilibSet ImgMultilibsV1 = null;
  MultilibSet ImgMultilibsV2 = null;
  try {
    // CodeScape IMG toolchain v1.2 and early.
    ImgMultilibsV1/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib Mips64r6 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips64r6")).flag(new StringRef(/*KEEP_STR*/"+m64")).flag(new StringRef(/*KEEP_STR*/"-m32")));
        
        Multilib LittleEndian = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/el")).flag(new StringRef(/*KEEP_STR*/"+EL")).flag(new StringRef(/*KEEP_STR*/"-EB")));
        
        Multilib MAbi64 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/64")).flag(new StringRef(/*KEEP_STR*/"+mabi=n64")).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).flag(new StringRef(/*KEEP_STR*/"-m32")));
        
        $c$.clean(ImgMultilibsV1.$assign(
            $c$.track(new MultilibSet()).
                Maybe(Mips64r6).
                Maybe(MAbi64).
                Maybe(LittleEndian).
                FilterOut(/*FuncArg*/NonExistent).
                setIncludeDirsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                      return $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*2*/] {new string("/include"), new string("/../../../../sysroot/usr/include")}), std.string.EMPTY));
                    })
        ));
      } finally {
        $c$.$destroy();
      }
    }
    
    // CodeScape IMG toolchain starting from v1.3.
    ImgMultilibsV2/*J*/= new MultilibSet();
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Multilib BeHard = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r6-hard")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        Multilib BeSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mips-r6-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        Multilib ElHard = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r6-hard")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        Multilib ElSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/mipsel-r6-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"-mmicromips")));
        Multilib BeMicroHard = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromips-r6-hard")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        Multilib BeMicroSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromips-r6-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EB")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        Multilib ElMicroHard = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromipsel-r6-hard")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"-msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        Multilib ElMicroSoft = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/micromipsel-r6-soft")).
                flag(new StringRef(/*KEEP_STR*/"+EL")).
                flag(new StringRef(/*KEEP_STR*/"+msoft-float")).
                flag(new StringRef(/*KEEP_STR*/"+mmicromips")));
        
        Multilib O32 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/lib")).osSuffix(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).flag(new StringRef(/*KEEP_STR*/"-mabi=n64")));
        Multilib N32 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/lib32")).osSuffix(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"+mabi=n32")).flag(new StringRef(/*KEEP_STR*/"-mabi=n64")));
        Multilib N64 = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/lib64")).osSuffix(new StringRef(/*KEEP_STR*/$EMPTY)).flag(new StringRef(/*KEEP_STR*/"-mabi=n32")).flag(new StringRef(/*KEEP_STR*/"+mabi=n64")));
        
        $c$.clean(ImgMultilibsV2.$assign(
            $c$.track(new MultilibSet()).
                Either(/*{ */new ArrayRef<Multilib>($c$.track(new /*const*/ Multilib [/*8*/] {
                      BeHard, BeSoft, ElHard, ElSoft, BeMicroHard, BeMicroSoft, 
                      ElMicroHard, ElMicroSoft}), false)/* }*/).
                Either(O32, N32, N64).
                FilterOut(/*FuncArg*/NonExistent).
                setIncludeDirsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                        return $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {
                            $add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"/../../../../sysroot", 
                                      M.includeSuffix()), 
                                  /*KEEP_STR*/"/../usr/include")
                            }), std.string.EMPTY));
                    }).
                setFilePathsCallback(/*FuncArg*//*[]*/ (final /*const*/ Multilib /*&*/ M) -> {
                      return $c$.clean(new std.vectorString($c$.track(new /*const*/std.string [/*1*/] {$add_T$C$P_string$C(/*KEEP_STR*/"/../../../../mips-img-linux-gnu/lib", M.gccSuffix())}), std.string.EMPTY));
                    })
        ));
      } finally {
        $c$.$destroy();
      }
    }
    for (MultilibSet /*P*/ Candidate : new MultilibSet /*P*/ /*const*/ [/*2*/] {$AddrOf(ImgMultilibsV1), $AddrOf(ImgMultilibsV2)}) {
      if (Candidate.select(Flags, Result.SelectedMultilib)) {
        Result.Multilibs.$assign($Deref(Candidate));
        return true;
      }
    }
    return false;
  } finally {
    if (ImgMultilibsV2 != null) { ImgMultilibsV2.$destroy(); }
    if (ImgMultilibsV1 != null) { ImgMultilibsV1.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="findMIPSMultilibs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2302,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1768,
 FQN="findMIPSMultilibs", NM="_ZL17findMIPSMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListERN12_GLOBAL__N_117DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL17findMIPSMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListERN12_GLOBAL__N_117DetectedMultilibsE")
//</editor-fold>
public static boolean findMIPSMultilibs(final /*const*/ Driver /*&*/ D, final /*const*/ Triple /*&*/ TargetTriple, 
                 StringRef Path, final /*const*/ ArgList /*&*/ Args, 
                 final DetectedMultilibs /*&*/ Result) {
  std.vectorString Flags = null;
  try {
    FilterNonExistent NonExistent/*J*/= new FilterNonExistent(new StringRef(Path), new StringRef(/*KEEP_STR*/"/crtbegin.o"), D.getVFS());
    
    StringRef CPUName/*J*/= new StringRef();
    StringRef ABIName/*J*/= new StringRef();
    MipsStatics.getMipsCPUAndABI(Args, TargetTriple, CPUName, ABIName);
    
    Triple.ArchType TargetArch = TargetTriple.getArch();
    
    Flags/*J*/= new std.vectorString(std.string.EMPTY);
    addMultilibFlag(isMips32(TargetArch), $("m32"), Flags);
    addMultilibFlag(isMips64(TargetArch), $("m64"), Flags);
    addMultilibFlag(isMips16(Args), $("mips16"), Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips32"), $("march=mips32"), Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips32r2") || $eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips32r3")
           || $eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips32r5") || $eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"p5600"), 
        $("march=mips32r2"), Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips32r6"), $("march=mips32r6"), Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips64"), $("march=mips64"), Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips64r2") || $eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips64r3")
           || $eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"mips64r5") || $eq_StringRef(/*NO_COPY*/CPUName, /*STRINGREF_STR*/"octeon"), 
        $("march=mips64r2"), Flags);
    addMultilibFlag(isMicroMips(Args), $("mmicromips"), Flags);
    addMultilibFlag(MipsStatics.isUCLibc(Args), $("muclibc"), Flags);
    addMultilibFlag(MipsStatics.isNaN2008(Args, TargetTriple), $("mnan=2008"), 
        Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/ABIName, /*STRINGREF_STR*/"n32"), $("mabi=n32"), Flags);
    addMultilibFlag($eq_StringRef(/*NO_COPY*/ABIName, /*STRINGREF_STR*/"n64"), $("mabi=n64"), Flags);
    addMultilibFlag(isSoftFloatABI(Args), $("msoft-float"), Flags);
    addMultilibFlag(!isSoftFloatABI(Args), $("mhard-float"), Flags);
    addMultilibFlag(isMipsEL(TargetArch), $("EL"), Flags);
    addMultilibFlag(!isMipsEL(TargetArch), $("EB"), Flags);
    if (TargetTriple.isAndroid()) {
      return findMipsAndroidMultilibs(Flags, NonExistent, Result);
    }
    if (TargetTriple.getVendor() == Triple.VendorType.MipsTechnologies
       && TargetTriple.getOS() == Triple.OSType.Linux
       && TargetTriple.getEnvironment() == Triple.EnvironmentType.UnknownEnvironment) {
      return findMipsMuslMultilibs(Flags, NonExistent, Result);
    }
    if (TargetTriple.getVendor() == Triple.VendorType.MipsTechnologies
       && TargetTriple.getOS() == Triple.OSType.Linux
       && TargetTriple.getEnvironment() == Triple.EnvironmentType.GNU) {
      return findMipsMtiMultilibs(Flags, NonExistent, Result);
    }
    if (TargetTriple.getVendor() == Triple.VendorType.ImaginationTechnologies
       && TargetTriple.getOS() == Triple.OSType.Linux
       && TargetTriple.getEnvironment() == Triple.EnvironmentType.GNU) {
      return findMipsImgMultilibs(Flags, NonExistent, Result);
    }
    if (findMipsCsMultilibs(Flags, NonExistent, Result)) {
      return true;
    }
    
    // Fallback to the regular toolchain-tree structure.
    Multilib Default/*J*/= new Multilib();
    Result.Multilibs.push_back(Default);
    Result.Multilibs.FilterOut(/*FuncArg*/NonExistent);
    if (Result.Multilibs.select(Flags, Result.SelectedMultilib)) {
      Result.BiarchSibling.$assign_T$RR(new Multilib());
      return true;
    }
    
    return false;
  } finally {
    if (Flags != null) { Flags.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="findAndroidArmMultilibs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2371,
 FQN="findAndroidArmMultilibs", NM="_ZL23findAndroidArmMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListERN12_GLOBAL__N_117DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL23findAndroidArmMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListERN12_GLOBAL__N_117DetectedMultilibsE")
//</editor-fold>
public static void findAndroidArmMultilibs(final /*const*/ Driver /*&*/ D, 
                       final /*const*/ Triple /*&*/ TargetTriple, 
                       StringRef Path, final /*const*/ ArgList /*&*/ Args, 
                       final DetectedMultilibs /*&*/ Result) {
  MultilibSet AndroidArmMultilibs = null;
  std.vectorString Flags = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Find multilibs with subdirectories like armv7-a, thumb, armv7-a/thumb.
    FilterNonExistent NonExistent/*J*/= new FilterNonExistent(new StringRef(Path), new StringRef(/*KEEP_STR*/"/crtbegin.o"), D.getVFS());
    Multilib ArmV7Multilib = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/armv7-a")).
            flag(new StringRef(/*KEEP_STR*/"+armv7")).
            flag(new StringRef(/*KEEP_STR*/"-thumb")));
    Multilib ThumbMultilib = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/thumb")).
            flag(new StringRef(/*KEEP_STR*/"-armv7")).
            flag(new StringRef(/*KEEP_STR*/"+thumb")));
    Multilib ArmV7ThumbMultilib = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/"/armv7-a/thumb")).
            flag(new StringRef(/*KEEP_STR*/"+armv7")).
            flag(new StringRef(/*KEEP_STR*/"+thumb")));
    Multilib DefaultMultilib = new Multilib(makeMultilib(new StringRef(/*KEEP_STR*/$EMPTY)).
            flag(new StringRef(/*KEEP_STR*/"-armv7")).
            flag(new StringRef(/*KEEP_STR*/"-thumb")));
    AndroidArmMultilibs = $c$.clean(new MultilibSet($c$.track(new MultilibSet()).
            Either(ThumbMultilib, ArmV7Multilib, 
            ArmV7ThumbMultilib, DefaultMultilib).
            FilterOut(/*FuncArg*/NonExistent)));
    
    Flags/*J*/= new std.vectorString(std.string.EMPTY);
    StringRef Arch = Args.getLastArgValue(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
    boolean IsArmArch = TargetTriple.getArch() == Triple.ArchType.arm;
    boolean IsThumbArch = TargetTriple.getArch() == Triple.ArchType.thumb;
    boolean IsV7SubArch = TargetTriple.getSubArch() == Triple.SubArchType.ARMSubArch_v7;
    boolean IsThumbMode = IsThumbArch
       || Args.hasFlag(new OptSpecifier(options.ID.OPT_mthumb.getValue()), new OptSpecifier(options.ID.OPT_mno_thumb.getValue()), false)
       || (IsArmArch && ARM.parseArchISA(/*NO_COPY*/Arch) == ARM.ISAKind.IK_THUMB.getValue());
    boolean IsArmV7Mode = (IsArmArch || IsThumbArch)
       && (ARM.parseArchVersion(/*NO_COPY*/Arch) == 7
       || (IsArmArch && $eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"") && IsV7SubArch));
    addMultilibFlag(IsArmV7Mode, $("armv7"), Flags);
    addMultilibFlag(IsThumbMode, $("thumb"), Flags);
    if (AndroidArmMultilibs.select(Flags, Result.SelectedMultilib)) {
      Result.Multilibs.$assign(AndroidArmMultilibs);
    }
  } finally {
    if (Flags != null) { Flags.$destroy(); }
    if (AndroidArmMultilibs != null) { AndroidArmMultilibs.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="findBiarchMultilibs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2413,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2097,
 FQN="findBiarchMultilibs", NM="_ZL19findBiarchMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListEbRN12_GLOBAL__N_117DetectedMultilibsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL19findBiarchMultilibsRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefERKNS4_3opt7ArgListEbRN12_GLOBAL__N_117DetectedMultilibsE")
//</editor-fold>
public static boolean findBiarchMultilibs(final /*const*/ Driver /*&*/ D, 
                   final /*const*/ Triple /*&*/ TargetTriple, 
                   StringRef Path, final /*const*/ ArgList /*&*/ Args, 
                   boolean NeedsBiarchSuffix, 
                   final DetectedMultilibs /*&*/ Result) {
  std.vectorString Flags = null;
  try {
    // Some versions of SUSE and Fedora on ppc64 put 32-bit libs
    // in what would normally be GCCInstallPath and put the 64-bit
    // libs in a subdirectory named 64. The simple logic we follow is that
    // *if* there is a subdirectory of the right name with crtbegin.o in it,
    // we use that. If not, and if not a biarch triple alias, we look for
    // crtbegin.o without the subdirectory.
    Multilib Default/*J*/= new Multilib();
    Multilib Alt64 = new Multilib(new Multilib().
            gccSuffix(new StringRef(/*KEEP_STR*/"/64")).
            includeSuffix(new StringRef(/*KEEP_STR*/"/64")).
            flag(new StringRef(/*KEEP_STR*/"-m32")).
            flag(new StringRef(/*KEEP_STR*/"+m64")).
            flag(new StringRef(/*KEEP_STR*/"-mx32")));
    Multilib Alt32 = new Multilib(new Multilib().
            gccSuffix(new StringRef(/*KEEP_STR*/"/32")).
            includeSuffix(new StringRef(/*KEEP_STR*/"/32")).
            flag(new StringRef(/*KEEP_STR*/"+m32")).
            flag(new StringRef(/*KEEP_STR*/"-m64")).
            flag(new StringRef(/*KEEP_STR*/"-mx32")));
    Multilib Altx32 = new Multilib(new Multilib().
            gccSuffix(new StringRef(/*KEEP_STR*/"/x32")).
            includeSuffix(new StringRef(/*KEEP_STR*/"/x32")).
            flag(new StringRef(/*KEEP_STR*/"-m32")).
            flag(new StringRef(/*KEEP_STR*/"-m64")).
            flag(new StringRef(/*KEEP_STR*/"+mx32")));
    
    // GCC toolchain for IAMCU doesn't have crtbegin.o, so look for libgcc.a.
    FilterNonExistent NonExistent/*J*/= new FilterNonExistent(new StringRef(Path), new StringRef(TargetTriple.isOSIAMCU() ? $("/libgcc.a") : $("/crtbegin.o")), D.getVFS());
    
    // Determine default multilib from: 32, 64, x32
    // Also handle cases such as 64 on 32, 32 on 64, etc.
    /*enum ANONYMOUS_INT_CONSTANTS {*/
      final /*uint*/int UNKNOWN = 0;
      final /*uint*/int WANT32 = UNKNOWN + 1;
      final /*uint*/int WANT64 = WANT32 + 1;
      final /*uint*/int WANTX32 = WANT64 + 1;
    /*}*//*Unnamed enum*//*uint*/int Want = UNKNOWN;
    /*const*/boolean IsX32 = TargetTriple.getEnvironment() == Triple.EnvironmentType.GNUX32;
    if (TargetTriple.isArch32Bit() && !NonExistent.$call(Alt32)) {
      Want = WANT64;
    } else if (TargetTriple.isArch64Bit() && IsX32 && !NonExistent.$call(Altx32)) {
      Want = WANT64;
    } else if (TargetTriple.isArch64Bit() && !IsX32 && !NonExistent.$call(Alt64)) {
      Want = WANT32;
    } else {
      if (TargetTriple.isArch32Bit()) {
        Want = NeedsBiarchSuffix ? WANT64 : WANT32;
      } else if (IsX32) {
        Want = NeedsBiarchSuffix ? WANT64 : WANTX32;
      } else {
        Want = NeedsBiarchSuffix ? WANT32 : WANT64;
      }
    }
    if (Want == WANT32) {
      Default.flag(new StringRef(/*KEEP_STR*/"+m32")).flag(new StringRef(/*KEEP_STR*/"-m64")).flag(new StringRef(/*KEEP_STR*/"-mx32"));
    } else if (Want == WANT64) {
      Default.flag(new StringRef(/*KEEP_STR*/"-m32")).flag(new StringRef(/*KEEP_STR*/"+m64")).flag(new StringRef(/*KEEP_STR*/"-mx32"));
    } else if (Want == WANTX32) {
      Default.flag(new StringRef(/*KEEP_STR*/"-m32")).flag(new StringRef(/*KEEP_STR*/"-m64")).flag(new StringRef(/*KEEP_STR*/"+mx32"));
    } else {
      return false;
    }
    
    Result.Multilibs.push_back(Default);
    Result.Multilibs.push_back(Alt64);
    Result.Multilibs.push_back(Alt32);
    Result.Multilibs.push_back(Altx32);
    
    Result.Multilibs.FilterOut(/*FuncArg*/NonExistent);
    
    Flags/*J*/= new std.vectorString(std.string.EMPTY);
    addMultilibFlag(TargetTriple.isArch64Bit() && !IsX32, $("m64"), Flags);
    addMultilibFlag(TargetTriple.isArch32Bit(), $("m32"), Flags);
    addMultilibFlag(TargetTriple.isArch64Bit() && IsX32, $("mx32"), Flags);
    if (!Result.Multilibs.select(Flags, Result.SelectedMultilib)) {
      return false;
    }
    if (Result.SelectedMultilib.$eq(Alt64) || Result.SelectedMultilib.$eq(Alt32)
       || Result.SelectedMultilib.$eq(Altx32)) {
      Result.BiarchSibling.$assign_T$C$R(Default);
    }
    
    return true;
  } finally {
    if (Flags != null) { Flags.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="addPathIfExists">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3639,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3298,
 FQN="addPathIfExists", NM="_ZL15addPathIfExistsRKN5clang6driver6DriverERKN4llvm5TwineERNS4_11SmallVectorISsLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL15addPathIfExistsRKN5clang6driver6DriverERKN4llvm5TwineERNS4_11SmallVectorISsLj16EEE")
//</editor-fold>
public static void addPathIfExists(final /*const*/ Driver /*&*/ D, final /*const*/ Twine /*&*/ Path, 
               final SmallVector<std.string> /*&*/ Paths) {
  if (D.getVFS().exists(Path)) {
    Paths.push_back_T$RR(Path.str());
  }
}

//<editor-fold defaultstate="collapsed" desc="IsRedhat">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3750,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3410,
 FQN="IsRedhat", NM="_ZL8IsRedhat6Distro",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8IsRedhat6Distro")
//</editor-fold>
public static boolean IsRedhat( Distro $Distro) {
  return $Distro == Distro.Fedora || ($Distro.getValue() >= Distro.RHEL5.getValue() && $Distro.getValue() <= Distro.RHEL7.getValue());
}

//<editor-fold defaultstate="collapsed" desc="IsOpenSUSE">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3754,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3414,
 FQN="IsOpenSUSE", NM="_ZL10IsOpenSUSE6Distro",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL10IsOpenSUSE6Distro")
//</editor-fold>
public static boolean IsOpenSUSE( Distro $Distro) {
  return $Distro == Distro.OpenSUSE;
}

//<editor-fold defaultstate="collapsed" desc="IsDebian">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3756,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3416,
 FQN="IsDebian", NM="_ZL8IsDebian6Distro",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8IsDebian6Distro")
//</editor-fold>
public static boolean IsDebian( Distro $Distro) {
  return $Distro.getValue() >= Distro.DebianLenny.getValue() && $Distro.getValue() <= Distro.DebianStretch.getValue();
}

//<editor-fold defaultstate="collapsed" desc="IsUbuntu">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3760,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3420,
 FQN="IsUbuntu", NM="_ZL8IsUbuntu6Distro",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL8IsUbuntu6Distro")
//</editor-fold>
public static boolean IsUbuntu( Distro $Distro) {
  return $Distro.getValue() >= Distro.UbuntuHardy.getValue() && $Distro.getValue() <= Distro.UbuntuXenial.getValue();
}

//<editor-fold defaultstate="collapsed" desc="DetectDistro">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3764,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3424,
 FQN="DetectDistro", NM="_ZL12DetectDistroRKN5clang6driver6DriverEN4llvm6Triple8ArchTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL12DetectDistroRKN5clang6driver6DriverEN4llvm6Triple8ArchTypeE")
//</editor-fold>
public static Distro DetectDistro(final /*const*/ Driver /*&*/ D, Triple.ArchType Arch) {
  ErrorOr<std.unique_ptr<MemoryBuffer> > File = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    File = MemoryBuffer.getFile(new Twine(/*KEEP_STR*/"/etc/lsb-release"));
    if (File.$bool()) {
      StringRef Data = File.get().$arrow().getBuffer();
      SmallVector<StringRef> Lines/*J*/= new SmallVector<StringRef>(16, new StringRef());
      Data.split(Lines, /*STRINGREF_STR*/"\n");
      Distro Version = Distro.UnknownDistro;
      for (StringRef Line : Lines)  {
        if (Version == Distro.UnknownDistro && Line.startswith(/*STRINGREF_STR*/"DISTRIB_CODENAME=")) {
          Version = new StringSwitch<Distro>(Line.substr(17)).
              Case(/*KEEP_STR*/"hardy", Distro.UbuntuHardy).
              Case(/*KEEP_STR*/"intrepid", Distro.UbuntuIntrepid).
              Case(/*KEEP_STR*/"jaunty", Distro.UbuntuJaunty).
              Case(/*KEEP_STR*/"karmic", Distro.UbuntuKarmic).
              Case(/*KEEP_STR*/"lucid", Distro.UbuntuLucid).
              Case(/*KEEP_STR*/"maverick", Distro.UbuntuMaverick).
              Case(/*KEEP_STR*/"natty", Distro.UbuntuNatty).
              Case(/*KEEP_STR*/"oneiric", Distro.UbuntuOneiric).
              Case(/*KEEP_STR*/"precise", Distro.UbuntuPrecise).
              Case(/*KEEP_STR*/"quantal", Distro.UbuntuQuantal).
              Case(/*KEEP_STR*/"raring", Distro.UbuntuRaring).
              Case(/*KEEP_STR*/"saucy", Distro.UbuntuSaucy).
              Case(/*KEEP_STR*/"trusty", Distro.UbuntuTrusty).
              Case(/*KEEP_STR*/"utopic", Distro.UbuntuUtopic).
              Case(/*KEEP_STR*/"vivid", Distro.UbuntuVivid).
              Case(/*KEEP_STR*/"wily", Distro.UbuntuWily).
              Case(/*KEEP_STR*/"xenial", Distro.UbuntuXenial).
              Default(Distro.UnknownDistro);
        }
      }
      if (Version != Distro.UnknownDistro) {
        return Version;
      }
    }
    
    $c$.clean(File.$assignMove($c$.track(MemoryBuffer.getFile(new Twine(/*KEEP_STR*/"/etc/redhat-release")))));
    if (File.$bool()) {
      StringRef Data = File.get().$arrow().getBuffer();
      if (Data.startswith(/*STRINGREF_STR*/"Fedora release")) {
        return Distro.Fedora;
      }
      if (Data.startswith(/*STRINGREF_STR*/"Red Hat Enterprise Linux")
         || Data.startswith(/*STRINGREF_STR*/"CentOS")
         || Data.startswith(/*STRINGREF_STR*/"Scientific Linux")) {
        if (Data.find(/*STRINGREF_STR*/"release 7") != StringRef.npos) {
          return Distro.RHEL7;
        } else if (Data.find(/*STRINGREF_STR*/"release 6") != StringRef.npos) {
          return Distro.RHEL6;
        } else if (Data.find(/*STRINGREF_STR*/"release 5") != StringRef.npos) {
          return Distro.RHEL5;
        }
      }
      return Distro.UnknownDistro;
    }
    
    $c$.clean(File.$assignMove($c$.track(MemoryBuffer.getFile(new Twine(/*KEEP_STR*/"/etc/debian_version")))));
    if (File.$bool()) {
      StringRef Data = File.get().$arrow().getBuffer();
      if (Data.$at(0) == $$5) {
        return Distro.DebianLenny;
      } else if (Data.startswith(/*STRINGREF_STR*/"squeeze/sid") || Data.$at(0) == $$6) {
        return Distro.DebianSqueeze;
      } else if (Data.startswith(/*STRINGREF_STR*/"wheezy/sid") || Data.$at(0) == $$7) {
        return Distro.DebianWheezy;
      } else if (Data.startswith(/*STRINGREF_STR*/"jessie/sid") || Data.$at(0) == $$8) {
        return Distro.DebianJessie;
      } else if (Data.startswith(/*STRINGREF_STR*/"stretch/sid") || Data.$at(0) == $$9) {
        return Distro.DebianStretch;
      }
      return Distro.UnknownDistro;
    }
    if (D.getVFS().exists(new Twine(/*KEEP_STR*/"/etc/SuSE-release"))) {
      return Distro.OpenSUSE;
    }
    if (D.getVFS().exists(new Twine(/*KEEP_STR*/"/etc/exherbo-release"))) {
      return Distro.Exherbo;
    }
    if (D.getVFS().exists(new Twine(/*KEEP_STR*/"/etc/arch-release"))) {
      return Distro.ArchLinux;
    }
    
    return Distro.UnknownDistro;
  } finally {
    if (File != null) { File.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Get our best guess at the multiarch triple for a target.
///
/// Debian-based systems are starting to use a multiarch setup where they use
/// a target-triple directory in the library and header search paths.
/// Unfortunately, this triple does not align with the vanilla target triple,
/// so we provide a rough mapping here.
//<editor-fold defaultstate="collapsed" desc="getMultiarchTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3849,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3509,
 FQN="getMultiarchTriple", NM="_ZL18getMultiarchTripleRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL18getMultiarchTripleRKN5clang6driver6DriverERKN4llvm6TripleENS4_9StringRefE")
//</editor-fold>
public static std.string getMultiarchTriple(final /*const*/ Driver /*&*/ D, 
                  final /*const*/ Triple /*&*/ TargetTriple, 
                  StringRef SysRoot) {
  Triple.EnvironmentType TargetEnvironment = TargetTriple.getEnvironment();
  
  // For most architectures, just use whatever we have rather than trying to be
  // clever.
  switch (TargetTriple.getArch()) {
   default:
    break;
   case arm:
   case thumb:
    
    // We use the existence of '/lib/<triple>' as a directory to detect some
    // common linux triples that don't quite match the Clang triple for both
    // 32-bit and 64-bit targets. Multiarch fixes its install triples to these
    // regardless of what the actual target triple is.
    if (TargetEnvironment == Triple.EnvironmentType.GNUEABIHF) {
      if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/arm-linux-gnueabihf"))) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"arm-linux-gnueabihf");
      }
    } else {
      if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/arm-linux-gnueabi"))) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"arm-linux-gnueabi");
      }
    }
    break;
   case armeb:
   case thumbeb:
    if (TargetEnvironment == Triple.EnvironmentType.GNUEABIHF) {
      if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/armeb-linux-gnueabihf"))) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"armeb-linux-gnueabihf");
      }
    } else {
      if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/armeb-linux-gnueabi"))) {
        return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"armeb-linux-gnueabi");
      }
    }
    break;
   case x86:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/i386-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"i386-linux-gnu");
    }
    break;
   case x86_64:
    // We don't want this for x32, otherwise it will match x86_64 libs
    if (TargetEnvironment != Triple.EnvironmentType.GNUX32
       && D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/x86_64-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"x86_64-linux-gnu");
    }
    break;
   case aarch64:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/aarch64-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"aarch64-linux-gnu");
    }
    break;
   case aarch64_be:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/aarch64_be-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"aarch64_be-linux-gnu");
    }
    break;
   case mips:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/mips-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mips-linux-gnu");
    }
    break;
   case mipsel:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/mipsel-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mipsel-linux-gnu");
    }
    break;
   case mips64:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/mips64-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mips64-linux-gnu");
    }
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/mips64-linux-gnuabi64"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mips64-linux-gnuabi64");
    }
    break;
   case mips64el:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/mips64el-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mips64el-linux-gnu");
    }
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/mips64el-linux-gnuabi64"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"mips64el-linux-gnuabi64");
    }
    break;
   case ppc:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/powerpc-linux-gnuspe"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"powerpc-linux-gnuspe");
    }
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/powerpc-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"powerpc-linux-gnu");
    }
    break;
   case ppc64:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/powerpc64-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"powerpc64-linux-gnu");
    }
    break;
   case ppc64le:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/powerpc64le-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"powerpc64le-linux-gnu");
    }
    break;
   case sparc:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/sparc-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sparc-linux-gnu");
    }
    break;
   case sparcv9:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/sparc64-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"sparc64-linux-gnu");
    }
    break;
   case systemz:
    if (D.getVFS().exists($add_StringRef$C_char$ptr$C(SysRoot, /*KEEP_STR*/"/lib/s390x-linux-gnu"))) {
      return new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"s390x-linux-gnu");
    }
    break;
  }
  return new std.string(TargetTriple.str());
}

//<editor-fold defaultstate="collapsed" desc="getOSLibDir">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3953,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3613,
 FQN="getOSLibDir", NM="_ZL11getOSLibDirRKN4llvm6TripleERKNS_3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL11getOSLibDirRKN4llvm6TripleERKNS_3opt7ArgListE")
//</editor-fold>
public static StringRef getOSLibDir(final /*const*/ Triple /*&*/ $Triple, final /*const*/ ArgList /*&*/ Args) {
  if (isMipsArch($Triple.getArch())) {
    // lib32 directory has a special meaning on MIPS targets.
    // It contains N32 ABI binaries. Use this folder if produce
    // code for N32 ABI only.
    if (MipsStatics.hasMipsAbiArg(Args, $("n32"))) {
      return new StringRef(/*KEEP_STR*/"lib32");
    }
    return new StringRef($Triple.isArch32Bit() ? $("lib") : $("lib64"));
  }
  
  // It happens that only x86 and PPC use the 'lib32' variant of oslibdir, and
  // using that variant while targeting other architectures causes problems
  // because the libraries are laid out in shared system roots that can't cope
  // with a 'lib32' library search path being considered. So we only enable
  // them when we know we may need it.
  //
  // FIXME: This is a bit of a hack. We should really unify this code for
  // reasoning about oslibdir spellings with the lib dir spellings in the
  // GCCInstallationDetector, but that is a more significant refactoring.
  if ($Triple.getArch() == Triple.ArchType.x86
     || $Triple.getArch() == Triple.ArchType.ppc) {
    return new StringRef(/*KEEP_STR*/"lib32");
  }
  if ($Triple.getArch() == Triple.ArchType.x86_64
     && $Triple.getEnvironment() == Triple.EnvironmentType.GNUX32) {
    return new StringRef(/*KEEP_STR*/"libx32");
  }
  
  return new StringRef($Triple.isArch32Bit() ? $("lib") : $("lib64"));
}

//<editor-fold defaultstate="collapsed" desc="addMultilibsFilePaths">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3983,
 FQN="addMultilibsFilePaths", NM="_ZL21addMultilibsFilePathsRKN5clang6driver6DriverERKNS0_11MultilibSetERKNS0_8MultilibEN4llvm9StringRefERNSA_11SmallVectorISsLj16EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL21addMultilibsFilePathsRKN5clang6driver6DriverERKNS0_11MultilibSetERKNS0_8MultilibEN4llvm9StringRefERNSA_11SmallVectorISsLj16EEE")
//</editor-fold>
public static void addMultilibsFilePaths(final /*const*/ Driver /*&*/ D, final /*const*/ MultilibSet /*&*/ Multilibs, 
                     final /*const*/ Multilib /*&*/ $Multilib, 
                     StringRef InstallPath, 
                     final SmallVector<std.string> /*&*/ Paths) {
  {
    final /*const*/IncludeDirsFunc /*&*/ PathsCallback = Multilibs.filePathsCallback();
    if (PathsCallback != null) {
      for (final /*const*/std.string/*&*/ Path : PathsCallback.$call($Multilib))  {
        addPathIfExists(D, $add_Twine$C(new Twine(InstallPath), new Twine(Path)), Paths);
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="DetectLibcxxIncludePath">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4501,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4032,
 FQN="DetectLibcxxIncludePath", NM="_ZL23DetectLibcxxIncludePathN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZL23DetectLibcxxIncludePathN4llvm9StringRefE")
//</editor-fold>
public static std.string DetectLibcxxIncludePath(StringRef base) {
  std.error_code EC/*J*/= new std.error_code();
  int MaxVersion = 0;
  std.string MaxVersionString = new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
  fs.directory_iterator LI = null;
  fs.directory_iterator LE = null;
  try {
    for (LI/*J*/= new fs.directory_iterator(new Twine(base), EC), LE/*J*/= new fs.directory_iterator(); !EC.$bool() && LI.$noteq(LE);
         LI.$assign(LI.increment(EC))) {
      StringRef VersionText = path.filename(new StringRef(LI.$arrow().getPath()));
      int$ref Version = create_int$ref();
      if (VersionText.$at(0) == $$v
         && !VersionText.slice(1, StringRef.npos).getAsInteger$Signed(10, Version)) {
        if (Version.$deref() > MaxVersion) {
          MaxVersion = Version.$deref();
          MaxVersionString.$assignMove(VersionText.$string());
        }
      }
    }
  } finally {
    if (LE != null) { LE.$destroy(); }
    if (LI != null) { LI.$destroy(); }
  }
  return (MaxVersion != 0) ? ($add_Twine$C($add_StringRef$C_char$ptr$C(base, /*KEEP_STR*/$SLASH), new Twine(MaxVersionString))).str() : new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/$EMPTY);
}

} // END OF class ToolChainsStatics
