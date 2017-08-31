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
package org.clang.basic.target.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.SanitizerKind;
import org.clang.basic.impl.JavaHugeTargetStaticsBuiltinInfoDelegate;
import org.clang.basic.target.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type TargetsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZL14AllocateTargetRKN4llvm6TripleERKN5clang13TargetOptionsE;_ZL15defineCPUMacrosRN5clang12MacroBuilderEN4llvm9StringRefEb;_ZL9DefineStdRN5clang12MacroBuilderEN4llvm9StringRefERKNS_11LangOptionsE;_ZN12_GLOBAL__N_1L11BuiltinInfoE;_ZN12_GLOBAL__N_1L11GCCRegNamesE;_ZN12_GLOBAL__N_1L12AddlRegNamesE;_ZN12_GLOBAL__N_1L15addMinGWDefinesERKN5clang11LangOptionsERNS0_12MacroBuilderE;_ZN12_GLOBAL__N_1L16SPIRAddrSpaceMapE;_ZN12_GLOBAL__N_1L16getDarwinDefinesERN5clang12MacroBuilderERKNS0_11LangOptionsERKN4llvm6TripleERNS6_9StringRefERNS0_12VersionTupleE;_ZN12_GLOBAL__N_1L17NVPTXAddrSpaceMapE;_ZN12_GLOBAL__N_1L17addCygMingDefinesERKN5clang11LangOptionsERNS0_12MacroBuilderE;_ZN12_GLOBAL__N_1L18AMDGPUAddrSpaceMapE;_ZN12_GLOBAL__N_1L18DataLayoutStringSIE;_ZN12_GLOBAL__N_1L20DataLayoutStringR600E;_ZN12_GLOBAL__N_1L20ppcUserFeaturesCheckERN5clang17DiagnosticsEngineERKSt6vectorISsSaISsEE;_ZN12_GLOBAL__N_1L21TCEOpenCLAddrSpaceMapE; -static-type=TargetsStatics -package=org.clang.basic.target.impl")
//</editor-fold>
public final class TargetsStatics {


//===----------------------------------------------------------------------===//
//  Common code shared among targets.
//===----------------------------------------------------------------------===//

/// DefineStd - Define a macro name and standard variants.  For example if
/// MacroName is "unix", then this will define "__unix", "__unix__", and "unix"
/// when in GNU mode.
//<editor-fold defaultstate="collapsed" desc="DefineStd">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 45,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 44,
 FQN="DefineStd", NM="_ZL9DefineStdRN5clang12MacroBuilderEN4llvm9StringRefERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZL9DefineStdRN5clang12MacroBuilderEN4llvm9StringRefERKNS_11LangOptionsE")
//</editor-fold>
public static void DefineStd(MacroBuilder /*&*/ Builder, StringRef MacroName, 
         /*const*/ LangOptions /*&*/ Opts) {
  assert (MacroName.$at(0) != $$UNDERSCORE) : "Identifier should be in the user's namespace";
  
  // If in GNU mode (e.g. -std=gnu99 but not -std=c99) define the raw identifier
  // in the user's namespace.
  if (Opts.GNUMode) {
    Builder.defineMacro(new Twine(MacroName));
  }
  
  // Define __unix.
  Builder.defineMacro($add_char$ptr$C_StringRef(/*KEEP_STR*/"__", MacroName));
  
  // Define __unix__.
  Builder.defineMacro($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"__", MacroName), new Twine(/*KEEP_STR*/"__")));
}

//<editor-fold defaultstate="collapsed" desc="defineCPUMacros">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 61,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 60,
 FQN="defineCPUMacros", NM="_ZL15defineCPUMacrosRN5clang12MacroBuilderEN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZL15defineCPUMacrosRN5clang12MacroBuilderEN4llvm9StringRefEb")
//</editor-fold>
public static void defineCPUMacros(MacroBuilder /*&*/ Builder, StringRef CPUName) {
  defineCPUMacros(Builder, CPUName, 
               true);
}
public static void defineCPUMacros(MacroBuilder /*&*/ Builder, StringRef CPUName, 
               boolean Tuning/*= true*/) {
  Builder.defineMacro($add_char$ptr$C_StringRef(/*KEEP_STR*/"__", CPUName));
  Builder.defineMacro($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"__", CPUName), new Twine(/*KEEP_STR*/"__")));
  if (Tuning) {
    Builder.defineMacro($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"__tune_", CPUName), new Twine(/*KEEP_STR*/"__")));
  }
}

// end anonymous namespace

// end anonymous namespace

// end anonymous namespace

//===----------------------------------------------------------------------===//
// Driver code
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="AllocateTarget">
@Converted(kind = Converted.Kind.MANUAL/*return type*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 8121,
 FQN="AllocateTarget", NM="_ZL14AllocateTargetRKN4llvm6TripleERKN5clang13TargetOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZL14AllocateTargetRKN4llvm6TripleERKN5clang13TargetOptionsE")
//</editor-fold>
public static org.clang.basic.target.impl.TargetInfoImpl /*P*/ AllocateTarget(/*const*/ Triple /*&*/ _Triple, 
              /*const*/ TargetOptions /*&*/ Opts) {
  Triple.OSType os = _Triple.getOS();
  switch (_Triple.getArch()) {
   default:
    return null;
   case xcore:
    return new XCoreTargetInfo(_Triple, Opts);
   case hexagon:
    return new HexagonTargetInfo(_Triple, Opts);
   case lanai:
    return new LanaiTargetInfo(_Triple, Opts);
   case aarch64:
    if (_Triple.isOSDarwin()) {
      return new DarwinAArch64TargetInfo(_Triple, Opts);
    }
    switch (os) {
     case CloudABI:
      return new CloudABITargetInfo<AArch64leTargetInfo>(new AArch64leTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<AArch64leTargetInfo>(new AArch64leTargetInfo(_Triple, Opts), _Triple, Opts);
     case Linux:
      return new LinuxTargetInfo<AArch64leTargetInfo>(new AArch64leTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<AArch64leTargetInfo>(new AArch64leTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new AArch64leTargetInfo(_Triple, Opts);
    }
   case aarch64_be:
    switch (os) {
     case FreeBSD:
      return new FreeBSDTargetInfo<AArch64beTargetInfo>(new AArch64beTargetInfo(_Triple, Opts), _Triple, Opts);
     case Linux:
      return new LinuxTargetInfo<AArch64beTargetInfo>(new AArch64beTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<AArch64beTargetInfo>(new AArch64beTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new AArch64beTargetInfo(_Triple, Opts);
    }
   case arm:
   case thumb:
    if (_Triple.isOSBinFormatMachO()) {
      return new DarwinARMTargetInfo(_Triple, Opts);
    }
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case Bitrig:
      return new BitrigTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case NaCl:
      return new NaClTargetInfo<ARMleTargetInfo>(new ARMleTargetInfo(_Triple, Opts), _Triple, Opts);
     case Win32:
      switch (_Triple.getEnvironment()) {
       case Cygnus:
        return new CygwinARMTargetInfo(_Triple, Opts);
       case GNU:
        return new MinGWARMTargetInfo(_Triple, Opts);
       case Itanium:
        return new ItaniumWindowsARMleTargetInfo(_Triple, Opts);
       case MSVC:
       default: // Assume MSVC for unknown environments
        return new MicrosoftARMleTargetInfo(_Triple, Opts);
      }
     default:
      return new ARMleTargetInfo(_Triple, Opts);
    }
   case armeb:
   case thumbeb:
    if (_Triple.isOSDarwin()) {
      return new DarwinARMTargetInfo(_Triple, Opts);
    }
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     case Bitrig:
      return new BitrigTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     case NaCl:
      return new NaClTargetInfo<ARMbeTargetInfo>(new ARMbeTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new ARMbeTargetInfo(_Triple, Opts);
    }
   case bpfeb:
   case bpfel:
    return new BPFTargetInfo(_Triple, Opts);
   case msp430:
    return new MSP430TargetInfo(_Triple, Opts);
   case mips:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new MipsTargetInfo(_Triple, Opts);
    }
   case mipsel:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case NaCl:
      return new NaClTargetInfo<NaClMips32TargetInfo>(new NaClMips32TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new MipsTargetInfo(_Triple, Opts);
    }
   case mips64:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new MipsTargetInfo(_Triple, Opts);
    }
   case mips64el:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<MipsTargetInfo>(new MipsTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new MipsTargetInfo(_Triple, Opts);
    }
   case le32:
    switch (os) {
     case NaCl:
      return new NaClTargetInfo<PNaClTargetInfo>(new PNaClTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return null;
    }
   case le64:
    return new Le64TargetInfo(_Triple, Opts);
   case ppc:
    if (_Triple.isOSDarwin()) {
      return new DarwinPPC32TargetInfo(_Triple, Opts);
    }
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<PPC32TargetInfo>(new PPC32TargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<PPC32TargetInfo>(new PPC32TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<PPC32TargetInfo>(new PPC32TargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<PPC32TargetInfo>(new PPC32TargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<PPC32TargetInfo>(new PPC32TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new PPC32TargetInfo(_Triple, Opts);
    }
   case ppc64:
    if (_Triple.isOSDarwin()) {
      return new DarwinPPC64TargetInfo(_Triple, Opts);
    }
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<PPC64TargetInfo>(new PPC64TargetInfo(_Triple, Opts), _Triple, Opts);
     case Lv2:
      return new PS3PPUTargetInfo<PPC64TargetInfo>(new PPC64TargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<PPC64TargetInfo>(new PPC64TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<PPC64TargetInfo>(new PPC64TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new PPC64TargetInfo(_Triple, Opts);
    }
   case ppc64le:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<PPC64TargetInfo>(new PPC64TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<PPC64TargetInfo>(new PPC64TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new PPC64TargetInfo(_Triple, Opts);
    }
   case nvptx:
    return new NVPTX32TargetInfo(_Triple, Opts);
   case nvptx64:
    return new NVPTX64TargetInfo(_Triple, Opts);
   case amdgcn:
   case r600:
    return new AMDGPUTargetInfo(_Triple, Opts);
   case sparc:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<SparcV8TargetInfo>(new SparcV8TargetInfo(_Triple, Opts), _Triple, Opts);
     case Solaris:
      return new SolarisTargetInfo<SparcV8TargetInfo>(new SparcV8TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<SparcV8TargetInfo>(new SparcV8TargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<SparcV8TargetInfo>(new SparcV8TargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<SparcV8TargetInfo>(new SparcV8TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new SparcV8TargetInfo(_Triple, Opts);
    }
   case sparcel:
    
    // The 'sparcel' architecture copies all the above cases except for Solaris.
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<SparcV8elTargetInfo>(new SparcV8elTargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<SparcV8elTargetInfo>(new SparcV8elTargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<SparcV8elTargetInfo>(new SparcV8elTargetInfo(_Triple, Opts), _Triple, Opts);
     case RTEMS:
      return new RTEMSTargetInfo<SparcV8elTargetInfo>(new SparcV8elTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new SparcV8elTargetInfo(_Triple, Opts);
    }
   case sparcv9:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<SparcV9TargetInfo>(new SparcV9TargetInfo(_Triple, Opts), _Triple, Opts);
     case Solaris:
      return new SolarisTargetInfo<SparcV9TargetInfo>(new SparcV9TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<SparcV9TargetInfo>(new SparcV9TargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDTargetInfo<SparcV9TargetInfo>(new SparcV9TargetInfo(_Triple, Opts), _Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<SparcV9TargetInfo>(new SparcV9TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new SparcV9TargetInfo(_Triple, Opts);
    }
   case systemz:
    switch (os) {
     case Linux:
      return new LinuxTargetInfo<SystemZTargetInfo>(new SystemZTargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new SystemZTargetInfo(_Triple, Opts);
    }
   case tce:
    return new TCETargetInfo(_Triple, Opts);
   case x86:
    if (_Triple.isOSDarwin()) {
      return new DarwinI386TargetInfo(_Triple, Opts);
    }
    switch (os) {
     case CloudABI:
      return new CloudABITargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case Linux:
      {
        switch (_Triple.getEnvironment()) {
         default:
          return new LinuxTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
         case Android:
          return new AndroidX86_32TargetInfo(_Triple, Opts);
        }
      }
     case DragonFly:
      return new DragonFlyBSDTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDI386TargetInfo(_Triple, Opts);
     case OpenBSD:
      return new OpenBSDI386TargetInfo(_Triple, Opts);
     case Bitrig:
      return new BitrigI386TargetInfo(_Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case KFreeBSD:
      return new KFreeBSDTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case Minix:
      return new MinixTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case Solaris:
      return new SolarisTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case Win32:
      {
        switch (_Triple.getEnvironment()) {
         case Cygnus:
          return new CygwinX86_32TargetInfo(_Triple, Opts);
         case GNU:
          return new MinGWX86_32TargetInfo(_Triple, Opts);
         case Itanium:
         case MSVC:
         default: // Assume MSVC for unknown environments
          return new MicrosoftX86_32TargetInfo(_Triple, Opts);
        }
      }
     case Haiku:
      return new HaikuX86_32TargetInfo(_Triple, Opts);
     case RTEMS:
      return new RTEMSX86_32TargetInfo(_Triple, Opts);
     case NaCl:
      return new NaClTargetInfo<X86_32TargetInfo>(new X86_32TargetInfo(_Triple, Opts), _Triple, Opts);
     case ELFIAMCU:
      return new MCUX86_32TargetInfo(_Triple, Opts);
     default:
      return new X86_32TargetInfo(_Triple, Opts);
    }
   case x86_64:
    if (_Triple.isOSDarwin() || _Triple.isOSBinFormatMachO()) {
      return new DarwinX86_64TargetInfo(_Triple, Opts);
    }
    switch (os) {
     case CloudABI:
      return new CloudABITargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case Linux:
      {
        switch (_Triple.getEnvironment()) {
         default:
          return new LinuxTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
         case Android:
          return new AndroidX86_64TargetInfo(_Triple, Opts);
        }
      }
     case DragonFly:
      return new DragonFlyBSDTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case NetBSD:
      return new NetBSDTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case OpenBSD:
      return new OpenBSDX86_64TargetInfo(_Triple, Opts);
     case Bitrig:
      return new BitrigX86_64TargetInfo(_Triple, Opts);
     case FreeBSD:
      return new FreeBSDTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case KFreeBSD:
      return new KFreeBSDTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case Solaris:
      return new SolarisTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case Win32:
      {
        switch (_Triple.getEnvironment()) {
         case Cygnus:
          return new CygwinX86_64TargetInfo(_Triple, Opts);
         case GNU:
          return new MinGWX86_64TargetInfo(_Triple, Opts);
         case MSVC:
         default: // Assume MSVC for unknown environments
          return new MicrosoftX86_64TargetInfo(_Triple, Opts);
        }
      }
     case Haiku:
      return new HaikuTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case NaCl:
      return new NaClTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     case PS4:
      return new PS4OSTargetInfo<X86_64TargetInfo>(new X86_64TargetInfo(_Triple, Opts), _Triple, Opts);
     default:
      return new X86_64TargetInfo(_Triple, Opts);
    }
   case spir:
    {
      if (_Triple.getOS() != Triple.OSType.UnknownOS
         || _Triple.getEnvironment() != Triple.EnvironmentType.UnknownEnvironment) {
        return null;
      }
      return new SPIR32TargetInfo(_Triple, Opts);
    }
   case spir64:
    {
      if (_Triple.getOS() != Triple.OSType.UnknownOS
         || _Triple.getEnvironment() != Triple.EnvironmentType.UnknownEnvironment) {
        return null;
      }
      return new SPIR64TargetInfo(_Triple, Opts);
    }
   case wasm32:
    if (!(_Triple.$eq(new Triple(new Twine(/*KEEP_STR*/"wasm32-unknown-unknown"))))) {
      return null;
    }
    return new WebAssemblyOSTargetInfo<WebAssembly32TargetInfo>(new WebAssembly32TargetInfo(_Triple, Opts), _Triple, Opts);
   case wasm64:
    if (!(_Triple.$eq(new Triple(new Twine(/*KEEP_STR*/"wasm64-unknown-unknown"))))) {
      return null;
    }
    return new WebAssemblyOSTargetInfo<WebAssembly64TargetInfo>(new WebAssembly64TargetInfo(_Triple, Opts), _Triple, Opts);
   case renderscript32:
    return new LinuxTargetInfo<RenderScript32TargetInfo>(new RenderScript32TargetInfo(_Triple, Opts), _Triple, Opts);
   case renderscript64:
    return new LinuxTargetInfo<RenderScript64TargetInfo>(new RenderScript64TargetInfo(_Triple, Opts), _Triple, Opts);
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::getDarwinDefines">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 113,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 110,
 FQN="(anonymous namespace)::getDarwinDefines", NM="_ZN12_GLOBAL__N_1L16getDarwinDefinesERN5clang12MacroBuilderERKNS0_11LangOptionsERKN4llvm6TripleERNS6_9StringRefERNS0_12VersionTupleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L16getDarwinDefinesERN5clang12MacroBuilderERKNS0_11LangOptionsERKN4llvm6TripleERNS6_9StringRefERNS0_12VersionTupleE")
//</editor-fold>
public static void getDarwinDefines(MacroBuilder /*&*/ Builder, /*const*/ LangOptions /*&*/ Opts, 
                /*const*/ Triple /*&*/ Triple, 
                StringRef /*&*/ PlatformName, 
                VersionTuple /*&*/ PlatformMinVersion) {
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__APPLE_CC__"), new Twine(/*KEEP_STR*/"6000"));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__APPLE__"));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"OBJC_NEW_PROPERTIES"));
  // AddressSanitizer doesn't play well with source fortification, which is on
  // by default on Darwin.
  if (Opts.Sanitize.has(SanitizerKind.Address)) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_FORTIFY_SOURCE"), new Twine(/*KEEP_STR*/$0));
  }
  
  // Darwin defines __weak, __strong, and __unsafe_unretained even in C mode.
  if (!Opts.ObjC1) {
    // __weak is always defined, for use in blocks and with objc pointers.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__weak"), new Twine(/*KEEP_STR*/"__attribute__((objc_gc(weak)))"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__strong"), new Twine(/*KEEP_STR*/$EMPTY));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__unsafe_unretained"), new Twine(/*KEEP_STR*/$EMPTY));
  }
  if (Opts.Static) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__STATIC__"));
  } else {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__DYNAMIC__"));
  }
  if (Opts.POSIXThreads) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_REENTRANT"));
  }
  
  // Get the platform type and version number from the triple.
  /*uint*/uint$ref Maj = create_uint$ref(), Min = create_uint$ref(), Rev = create_uint$ref();
  if (Triple.isMacOSX()) {
    Triple.getMacOSXVersion(Maj, Min, Rev);
    PlatformName.$assignMove(/*STRINGREF_STR*/"macos");
  } else {
    Triple.getOSVersion(Maj, Min, Rev);
    PlatformName.$assignMove(/*STRINGREF_STR*/Triple.getOSTypeName(Triple.getOS()));
  }
  
  // If -target arch-pc-win32-macho option specified, we're
  // generating code for Win32 ABI. No need to emit
  // __ENVIRONMENT_XX_OS_VERSION_MIN_REQUIRED__.
  if ($eq_StringRef(/*NO_COPY*/PlatformName, /*STRINGREF_STR*/"win32")) {
    PlatformMinVersion.$assignMove(new VersionTuple(Maj.$deref(), Min.$deref(), Rev.$deref()));
    return;
  }
  
  // Set the appropriate OS version define.
  if (Triple.isiOS()) {
    assert ($less_uint(Maj, 10) && $less_uint(Min, 100) && $less_uint(Rev, 100)) : "Invalid version!";
    /*char*/byte Str[/*6*/] = new$char(6);
    Str[0] = $uint2char($$0 + Maj.$deref());
    Str[1] = $uint2char($$0 + (Min.$deref() / 10));
    Str[2] = $uint2char($$0 + (Min.$deref() % 10));
    Str[3] = $uint2char($$0 + (Rev.$deref() / 10));
    Str[4] = $uint2char($$0 + (Rev.$deref() % 10));
    Str[5] = $$TERM;
    if (Triple.isTvOS()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ENVIRONMENT_TV_OS_VERSION_MIN_REQUIRED__"), new Twine(Str));
    } else {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ENVIRONMENT_IPHONE_OS_VERSION_MIN_REQUIRED__"), 
          new Twine(Str));
    }
  } else if (Triple.isWatchOS()) {
    assert ($less_uint(Maj, 10) && $less_uint(Min, 100) && $less_uint(Rev, 100)) : "Invalid version!";
    /*char*/byte Str[/*6*/] = new$char(6);
    Str[0] = $uint2char($$0 + Maj.$deref());
    Str[1] = $uint2char($$0 + (Min.$deref() / 10));
    Str[2] = $uint2char($$0 + (Min.$deref() % 10));
    Str[3] = $uint2char($$0 + (Rev.$deref() / 10));
    Str[4] = $uint2char($$0 + (Rev.$deref() % 10));
    Str[5] = $$TERM;
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ENVIRONMENT_WATCH_OS_VERSION_MIN_REQUIRED__"), new Twine(Str));
  } else if (Triple.isMacOSX()) {
    // Note that the Driver allows versions which aren't representable in the
    // define (because we only get a single digit for the minor and micro
    // revision numbers). So, we limit them to the maximum representable
    // version.
    assert ($less_uint(Maj, 100) && $less_uint(Min, 100) && $less_uint(Rev, 100)) : "Invalid version!";
    /*char*/byte Str[/*7*/] = new$char(7);
    if ($less_uint(Maj, 10) || (Maj.$deref() == 10 && $less_uint(Min, 10))) {
      Str[0] = $uint2char($$0 + (Maj.$deref() / 10));
      Str[1] = $uint2char($$0 + (Maj.$deref() % 10));
      Str[2] = $uint2char($$0 + std.min(Min.$deref(), 9/*U*/));
      Str[3] = $uint2char($$0 + std.min(Rev.$deref(), 9/*U*/));
      Str[4] = $$TERM;
    } else {
      // Handle versions > 10.9.
      Str[0] = $uint2char($$0 + (Maj.$deref() / 10));
      Str[1] = $uint2char($$0 + (Maj.$deref() % 10));
      Str[2] = $uint2char($$0 + (Min.$deref() / 10));
      Str[3] = $uint2char($$0 + (Min.$deref() % 10));
      Str[4] = $uint2char($$0 + (Rev.$deref() / 10));
      Str[5] = $uint2char($$0 + (Rev.$deref() % 10));
      Str[6] = $$TERM;
    }
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ENVIRONMENT_MAC_OS_X_VERSION_MIN_REQUIRED__"), new Twine(Str));
  }
  
  // Tell users about the kernel if there is one.
  if (Triple.isOSDarwin()) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__MACH__"));
  }
  
  // The Watch ABI uses Dwarf EH.
  if (Triple.isWatchABI()) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_DWARF_EH__"));
  }
  
  PlatformMinVersion.$assignMove(new VersionTuple(Maj.$deref(), Min.$deref(), Rev.$deref()));
}


// Handle explicit options being passed to the compiler here: if we've
// explicitly turned off vsx and turned on power8-vector or direct-move then
// go ahead and error since the customer has expressed a somewhat incompatible
// set of options.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ppcUserFeaturesCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1350,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1278,
 FQN="(anonymous namespace)::ppcUserFeaturesCheck", NM="_ZN12_GLOBAL__N_1L20ppcUserFeaturesCheckERN5clang17DiagnosticsEngineERKSt6vectorISsSaISsEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L20ppcUserFeaturesCheckERN5clang17DiagnosticsEngineERKSt6vectorISsSaISsEE")
//</editor-fold>
public static boolean ppcUserFeaturesCheck(DiagnosticsEngine /*&*/ Diags, 
                    /*const*/std.vectorString/*&*/ FeaturesVec) {
  if ($noteq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"-vsx"), 
      FeaturesVec.end())) {
    if ($noteq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"+power8-vector"), 
        FeaturesVec.end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_opt_not_valid_with_opt)), /*KEEP_STR*/"-mpower8-vector"), 
            /*KEEP_STR*/"-mno-vsx"));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if ($noteq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"+direct-move"), 
        FeaturesVec.end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_opt_not_valid_with_opt)), /*KEEP_STR*/"-mdirect-move"), 
            /*KEEP_STR*/"-mno-vsx"));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if ($noteq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"+float128"), 
        FeaturesVec.end())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_opt_not_valid_with_opt)), /*KEEP_STR*/"-mfloat128"), 
            /*KEEP_STR*/"-mno-vsx"));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NVPTXAddrSpaceMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1684,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1597,
 FQN="(anonymous namespace)::NVPTXAddrSpaceMap", NM="_ZN12_GLOBAL__N_1L17NVPTXAddrSpaceMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L17NVPTXAddrSpaceMapE")
//</editor-fold>
public static /*const*//*uint*/int NVPTXAddrSpaceMap[/*7*/] = new /*const*//*uint*/int [/*7*/] {
  1,  // opencl_global
  3,  // opencl_local
  4,  // opencl_constant
  // FIXME: generic has to be added to the target
  0,  // opencl_generic
  1,  // cuda_device
  4,  // cuda_constant
  3 // cuda_shared
};
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AMDGPUAddrSpaceMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1907,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1750,
 FQN="(anonymous namespace)::AMDGPUAddrSpaceMap", NM="_ZN12_GLOBAL__N_1L18AMDGPUAddrSpaceMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L18AMDGPUAddrSpaceMapE")
//</editor-fold>
public static /*const*//*uint*/int AMDGPUAddrSpaceMap[/*7*/] = new /*const*//*uint*/int [/*7*/] {
  1,  // opencl_global
  3,  // opencl_local
  2,  // opencl_constant
  4,  // opencl_generic
  1,  // cuda_device
  2,  // cuda_constant
  3 // cuda_shared
};

// If you edit the description strings, make sure you update
// getPointerWidthV().
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataLayoutStringR600">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1920,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1763,
 FQN="(anonymous namespace)::DataLayoutStringR600", NM="_ZN12_GLOBAL__N_1L20DataLayoutStringR600E",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L20DataLayoutStringR600E")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ DataLayoutStringR600 = $("e-p:32:32-i64:64-v16:16-v24:32-v32:32-v48:64-v96:128-v192:256-v256:256-v512:512-v1024:1024-v2048:2048-n32:64");
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::DataLayoutStringSI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 1924,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 1771,
 FQN="(anonymous namespace)::DataLayoutStringSI", NM="_ZN12_GLOBAL__N_1L18DataLayoutStringSIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L18DataLayoutStringSIE")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ DataLayoutStringSI = $("e-p:32:32-p1:64:64-p2:64:64-p3:32:32-p4:64:64-p5:32:32-i64:64-v16:16-v24:32-v32:32-v48:64-v96:128-v192:256-v256:256-v512:512-v1024:1024-v2048:2048-n32:64");

// Namespace for x86 abstract base class
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuiltinInfo">
@Converted(kind = Converted.Kind.DELETED, // JAVA: field is huge when inline initialized, so extracted into separate class
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2249,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2030,
 FQN="(anonymous namespace)::BuiltinInfo", NM="_ZN12_GLOBAL__N_1L11BuiltinInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L11BuiltinInfoE")
//</editor-fold>
public static /*const*/ Builtin.Info BuiltinInfo$Clang$Targets[/*1955*/] = JavaHugeTargetStaticsBuiltinInfoDelegate.BuiltinInfo$Clang$Targets;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GCCRegNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2259,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2040,
 FQN="(anonymous namespace)::GCCRegNames", NM="_ZN12_GLOBAL__N_1L11GCCRegNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L11GCCRegNamesE")
//</editor-fold>
public static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[/*134*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*134*/] {
  $("ax"), $("dx"), $("cx"), $("bx"), $("si"), $("di"), $("bp"), $("sp"), 
  $("st"), $("st(1)"), $("st(2)"), $("st(3)"), $("st(4)"), $("st(5)"), $("st(6)"), $("st(7)"), 
  $("argp"), $("flags"), $("fpcr"), $("fpsr"), $("dirflag"), $("frame"), 
  $("xmm0"), $("xmm1"), $("xmm2"), $("xmm3"), $("xmm4"), $("xmm5"), $("xmm6"), $("xmm7"), 
  $("mm0"), $("mm1"), $("mm2"), $("mm3"), $("mm4"), $("mm5"), $("mm6"), $("mm7"), 
  $("r8"), $("r9"), $("r10"), $("r11"), $("r12"), $("r13"), $("r14"), $("r15"), 
  $("xmm8"), $("xmm9"), $("xmm10"), $("xmm11"), $("xmm12"), $("xmm13"), $("xmm14"), $("xmm15"), 
  $("ymm0"), $("ymm1"), $("ymm2"), $("ymm3"), $("ymm4"), $("ymm5"), $("ymm6"), $("ymm7"), 
  $("ymm8"), $("ymm9"), $("ymm10"), $("ymm11"), $("ymm12"), $("ymm13"), $("ymm14"), $("ymm15"), 
  $("xmm16"), $("xmm17"), $("xmm18"), $("xmm19"), $("xmm20"), $("xmm21"), $("xmm22"), $("xmm23"), 
  $("xmm24"), $("xmm25"), $("xmm26"), $("xmm27"), $("xmm28"), $("xmm29"), $("xmm30"), $("xmm31"), 
  $("ymm16"), $("ymm17"), $("ymm18"), $("ymm19"), $("ymm20"), $("ymm21"), $("ymm22"), $("ymm23"), 
  $("ymm24"), $("ymm25"), $("ymm26"), $("ymm27"), $("ymm28"), $("ymm29"), $("ymm30"), $("ymm31"), 
  $("zmm0"), $("zmm1"), $("zmm2"), $("zmm3"), $("zmm4"), $("zmm5"), $("zmm6"), $("zmm7"), 
  $("zmm8"), $("zmm9"), $("zmm10"), $("zmm11"), $("zmm12"), $("zmm13"), $("zmm14"), $("zmm15"), 
  $("zmm16"), $("zmm17"), $("zmm18"), $("zmm19"), $("zmm20"), $("zmm21"), $("zmm22"), $("zmm23"), 
  $("zmm24"), $("zmm25"), $("zmm26"), $("zmm27"), $("zmm28"), $("zmm29"), $("zmm30"), $("zmm31")
});
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AddlRegNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2279,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2052,
 FQN="(anonymous namespace)::AddlRegNames", NM="_ZN12_GLOBAL__N_1L12AddlRegNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L12AddlRegNamesE")
//</editor-fold>
public static /*const*/ TargetInfo.AddlRegName AddlRegNames[/*16*/] = new /*const*/ TargetInfo.AddlRegName [/*16*/] {
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("al"), $("ah"), $("eax"), $("rax")}, 0), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("bl"), $("bh"), $("ebx"), $("rbx")}, 3), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("cl"), $("ch"), $("ecx"), $("rcx")}, 2), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("dl"), $("dh"), $("edx"), $("rdx")}, 1), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("esi"), $("rsi")}, 4), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("edi"), $("rdi")}, 5), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("esp"), $("rsp")}, 7), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("ebp"), $("rbp")}, 6), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r8d"), $("r8w"), $("r8b")}, 38), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r9d"), $("r9w"), $("r9b")}, 39), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r10d"), $("r10w"), $("r10b")}, 40), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r11d"), $("r11w"), $("r11b")}, 41), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r12d"), $("r12w"), $("r12b")}, 42), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r13d"), $("r13w"), $("r13b")}, 43), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r14d"), $("r14w"), $("r14b")}, 44), 
  new TargetInfo.AddlRegName(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r15d"), $("r15w"), $("r15b")}, 45)
};
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::addCygMingDefines">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4152,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3810,
 FQN="(anonymous namespace)::addCygMingDefines", NM="_ZN12_GLOBAL__N_1L17addCygMingDefinesERKN5clang11LangOptionsERNS0_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L17addCygMingDefinesERKN5clang11LangOptionsERNS0_12MacroBuilderE")
//</editor-fold>
public static void addCygMingDefines(/*const*/ LangOptions /*&*/ Opts, MacroBuilder /*&*/ Builder) {
  // Mingw and cygwin define __declspec(a) to __attribute__((a)).  Clang
  // supports __declspec natively under -fms-extensions, but we define a no-op
  // __declspec macro anyway for pre-processor compatibility.
  if (Opts.MicrosoftExt) {
    Builder.defineMacro(new Twine(/*KEEP_STR*/$__declspec), new Twine(/*KEEP_STR*/$__declspec));
  } else {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__declspec(a)"), new Twine(/*KEEP_STR*/"__attribute__((a))"));
  }
  if (!Opts.MicrosoftExt) {
    // Provide macros for all the calling convention keywords.  Provide both
    // single and double underscore prefixed variants.  These are available on
    // x64 as well as x86, even though they have no effect.
    /*const*/char$ptr/*char P*/ CCs[/*5*/] = (new /*const*/char$ptr/*char P*/ [/*5*/] {$("cdecl"), $("stdcall"), $("fastcall"), $("thiscall"), $("pascal")});
    for (/*const*/char$ptr/*char P*/ CC : CCs) {
      std.string GCCSpelling = new std.string(/*KEEP_STR*/"__attribute__((__");
      GCCSpelling.$addassign(CC);
      GCCSpelling.$addassign(/*KEEP_STR*/"__))");
      Builder.defineMacro($add_Twine(new Twine(/*KEEP_STR*/$UNDERSCORE), new Twine(CC)), new Twine(GCCSpelling));
      Builder.defineMacro($add_Twine(new Twine(/*KEEP_STR*/"__"), new Twine(CC)), new Twine(GCCSpelling));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::addMinGWDefines">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4176,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3834,
 FQN="(anonymous namespace)::addMinGWDefines", NM="_ZN12_GLOBAL__N_1L15addMinGWDefinesERKN5clang11LangOptionsERNS0_12MacroBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L15addMinGWDefinesERKN5clang11LangOptionsERNS0_12MacroBuilderE")
//</editor-fold>
public static void addMinGWDefines(/*const*/ LangOptions /*&*/ Opts, MacroBuilder /*&*/ Builder) {
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__MSVCRT__"));
  Builder.defineMacro(new Twine(/*KEEP_STR*/"__MINGW32__"));
  addCygMingDefines(Opts, Builder);
}


// LLVM and Clang cannot be used directly to output native binaries for
// target, but is used to compile C code to llvm bitcode with correct
// type and alignment information.
//
// TCE uses the llvm bitcode as input and uses it for generating customized
// target processor and program binary. TCE co-design environment is
// publicly available in http://tce.cs.tut.fi
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TCEOpenCLAddrSpaceMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6975,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6369,
 FQN="(anonymous namespace)::TCEOpenCLAddrSpaceMap", NM="_ZN12_GLOBAL__N_1L21TCEOpenCLAddrSpaceMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L21TCEOpenCLAddrSpaceMapE")
//</editor-fold>
public static /*const*//*uint*/int TCEOpenCLAddrSpaceMap[/*7*/] = new /*const*//*uint*/int [/*7*/] {
  3,  // opencl_global
  4,  // opencl_local
  5,  // opencl_constant
  // FIXME: generic has to be added to the target
  0,  // opencl_generic
  0,  // cuda_device
  0,  // cuda_constant
  0 // cuda_shared
};
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRAddrSpaceMap">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7896,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7342,
 FQN="(anonymous namespace)::SPIRAddrSpaceMap", NM="_ZN12_GLOBAL__N_1L16SPIRAddrSpaceMapE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_1L16SPIRAddrSpaceMapE")
//</editor-fold>
public static /*const*//*uint*/int SPIRAddrSpaceMap[/*7*/] = new /*const*//*uint*/int [/*7*/] {
  1,  // opencl_global
  3,  // opencl_local
  2,  // opencl_constant
  4,  // opencl_generic
  0,  // cuda_device
  0,  // cuda_constant
  0 // cuda_shared
};
} // END OF class TargetsStatics
