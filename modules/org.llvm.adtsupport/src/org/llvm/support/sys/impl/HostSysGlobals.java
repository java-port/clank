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
package org.llvm.support.sys.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.support.impl.*;
import static org.llvm.support.impl.HostStatics.*;
import static org.llvm.support.unix.impl.HostStatics.getOSVersion;


//<editor-fold defaultstate="collapsed" desc="static type HostSysGlobals">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.sys.impl.HostSysGlobals",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys14getHostCPUNameEv;_ZN4llvm3sys16getProcessTripleB5cxx11Ev;_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE;_ZN4llvm3sys22getDefaultTargetTripleB5cxx11Ev; -static-type=HostSysGlobals -package=org.llvm.support.sys.impl")
//</editor-fold>
public final class HostSysGlobals {


/// getDefaultTargetTriple() - Return the default target triple the compiler
/// has been configured to produce code for.
///
/// The target triple is a string in the format of:
///   CPU_TYPE-VENDOR-OPERATING_SYSTEM
/// or
///   CPU_TYPE-VENDOR-KERNEL-OPERATING_SYSTEM
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getDefaultTargetTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Unix/Host.inc", line = 37,
 FQN="llvm::sys::getDefaultTargetTriple", NM="_ZN4llvm3sys22getDefaultTargetTripleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys22getDefaultTargetTripleEv")
//</editor-fold>
public static std.string getDefaultTargetTriple() {
  std.string TargetTripleString/*J*/= new std.string(JD$T$C$P_T2$C$R.INSTANCE, /*KEEP_STR*/"i386-pc-solaris2.11");
  
  // On darwin, we want to update the version to match that of the
  // target.
  /*size_t*/int DarwinDashIdx = TargetTripleString.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"-darwin");
  if (DarwinDashIdx != std.string.npos) {
    TargetTripleString.resize(DarwinDashIdx + strlen(/*KEEP_STR*/"-darwin"));
    TargetTripleString.$addassign(getOSVersion());
  }
  
  return Triple.normalize(new StringRef(TargetTripleString));
}


/// getProcessTriple() - Return an appropriate target triple for generating
/// code to be loaded into the current process, e.g. when using the JIT.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getProcessTriple">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 1333,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 919,
 FQN="llvm::sys::getProcessTriple", NM="_ZN4llvm3sys16getProcessTripleEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys16getProcessTripleEv")
//</editor-fold>
public static std.string getProcessTriple() {
  Triple PT/*J*/= new Triple(new Twine(Triple.normalize(new StringRef(/*KEEP_STR*/"i386-pc-solaris2.11"))));
  if ($sizeof_ptr(/*Object */) == 8 && PT.isArch32Bit()) {
    PT.$assignMove(PT.get64BitArchVariant());
  }
  if ($sizeof_ptr(/*Object */) == 4 && PT.isArch64Bit()) {
    PT.$assignMove(PT.get32BitArchVariant());
  }
  
  return new std.string(PT.str());
}


/// getHostCPUName - Get the LLVM name for the host CPU. The particular format
/// of the name is target dependent, and suitable for passing as -mcpu to the
/// target which matches the host.
///
/// \return - The host CPU name, or empty if the CPU could not be determined.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 742,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 215,
 FQN="llvm::sys::getHostCPUName", NM="_ZN4llvm3sys14getHostCPUNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys14getHostCPUNameEv")
//</editor-fold>
public static StringRef getHostCPUName() {
  uint$ptr EAX = create_uint$ptr(0);
  uint$ptr EBX = create_uint$ptr(0);
  uint$ptr ECX = create_uint$ptr(0);
  uint$ptr EDX = create_uint$ptr(0);
  uint$ptr MaxLeaf = create_uint$ptr();
  uint$ptr Vendor = create_uint$ptr();
  if (getX86CpuIDAndInfo(0, $AddrOf(MaxLeaf), $AddrOf(Vendor), $AddrOf(ECX), $AddrOf(EDX))) {
    return new StringRef(/*KEEP_STR*/$generic);
  }
  if (getX86CpuIDAndInfo(0x1, $AddrOf(EAX), $AddrOf(EBX), $AddrOf(ECX), $AddrOf(EDX))) {
    return new StringRef(/*KEEP_STR*/$generic);
  }
  
  /*uint*/int Brand_id = EBX.$star() & 0xff;
  uint$ptr Family = create_uint$ptr(0);
  uint$ptr Model = create_uint$ptr(0);
  /*uint*/int Features = 0;
  detectX86FamilyModel(EAX.$star(), $AddrOf(Family), $AddrOf(Model));
  Features = getAvailableFeatures(ECX.$star(), EDX.$star(), MaxLeaf.$star());
  
  uint$ptr Type = create_uint$ptr();
  uint$ptr Subtype = create_uint$ptr();
  if (Vendor.$star() == VendorSignatures.SIG_INTEL) {
    getIntelProcessorTypeAndSubtype(Family.$star(), Model.$star(), Brand_id, Features, $AddrOf(Type), 
        $AddrOf(Subtype));
    switch (ProcessorTypes.valueOf(Type.$star())) {
     case INTEL_i386:
      return new StringRef(/*KEEP_STR*/"i386");
     case INTEL_i486:
      return new StringRef(/*KEEP_STR*/"i486");
     case INTEL_PENTIUM:
      if (Subtype.$star() == ProcessorSubtypes.INTEL_PENTIUM_MMX.getValue()) {
        return new StringRef(/*KEEP_STR*/"pentium-mmx");
      }
      return new StringRef(/*KEEP_STR*/"pentium");
     case INTEL_PENTIUM_PRO:
      return new StringRef(/*KEEP_STR*/"pentiumpro");
     case INTEL_PENTIUM_II:
      return new StringRef(/*KEEP_STR*/"pentium2");
     case INTEL_PENTIUM_III:
      return new StringRef(/*KEEP_STR*/"pentium3");
     case INTEL_PENTIUM_IV:
      return new StringRef(/*KEEP_STR*/"pentium4");
     case INTEL_PENTIUM_M:
      return new StringRef(/*KEEP_STR*/"pentium-m");
     case INTEL_CORE_DUO:
      return new StringRef(/*KEEP_STR*/"yonah");
     case INTEL_CORE2:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case INTEL_CORE2_65:
        return new StringRef(/*KEEP_STR*/"core2");
       case INTEL_CORE2_45:
        return new StringRef(/*KEEP_STR*/"penryn");
       default:
        return new StringRef(/*KEEP_STR*/"core2");
      }
     case INTEL_COREI7:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case INTEL_COREI7_NEHALEM:
        return new StringRef(/*KEEP_STR*/"nehalem");
       case INTEL_COREI7_WESTMERE:
        return new StringRef(/*KEEP_STR*/"westmere");
       case INTEL_COREI7_SANDYBRIDGE:
        return new StringRef(/*KEEP_STR*/"sandybridge");
       case INTEL_COREI7_IVYBRIDGE:
        return new StringRef(/*KEEP_STR*/"ivybridge");
       case INTEL_COREI7_HASWELL:
        return new StringRef(/*KEEP_STR*/"haswell");
       case INTEL_COREI7_BROADWELL:
        return new StringRef(/*KEEP_STR*/"broadwell");
       case INTEL_COREI7_SKYLAKE:
        return new StringRef(/*KEEP_STR*/"skylake");
       case INTEL_COREI7_SKYLAKE_AVX512:
        return new StringRef(/*KEEP_STR*/"skylake-avx512");
       default:
        return new StringRef(/*KEEP_STR*/"corei7");
      }
     case INTEL_ATOM:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case INTEL_ATOM_BONNELL:
        return new StringRef(/*KEEP_STR*/"bonnell");
       case INTEL_ATOM_SILVERMONT:
        return new StringRef(/*KEEP_STR*/"silvermont");
       default:
        return new StringRef(/*KEEP_STR*/"atom");
      }
     case INTEL_XEONPHI:
      return new StringRef(/*KEEP_STR*/"knl"); /*update for more variants added*/
     case INTEL_X86_64:
      return new StringRef(/*KEEP_STR*/"x86-64");
     case INTEL_NOCONA:
      return new StringRef(/*KEEP_STR*/"nocona");
     case INTEL_PRESCOTT:
      return new StringRef(/*KEEP_STR*/"prescott");
     default:
      return new StringRef(/*KEEP_STR*/$generic);
    }
  } else if (Vendor.$star() == VendorSignatures.SIG_AMD) {
    getAMDProcessorTypeAndSubtype(Family.$star(), Model.$star(), Features, $AddrOf(Type), $AddrOf(Subtype));
    switch (ProcessorTypes.valueOf(Type.$star())) {
     case AMD_i486:
      return new StringRef(/*KEEP_STR*/"i486");
     case AMDPENTIUM:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case AMDPENTIUM_K6:
        return new StringRef(/*KEEP_STR*/"k6");
       case AMDPENTIUM_K62:
        return new StringRef(/*KEEP_STR*/"k6-2");
       case AMDPENTIUM_K63:
        return new StringRef(/*KEEP_STR*/"k6-3");
       case AMDPENTIUM_GEODE:
        return new StringRef(/*KEEP_STR*/"geode");
       default:
        return new StringRef(/*KEEP_STR*/"pentium");
      }
     case AMDATHLON:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case AMDATHLON_TBIRD:
        return new StringRef(/*KEEP_STR*/"athlon-tbird");
       case AMDATHLON_MP:
        return new StringRef(/*KEEP_STR*/"athlon-mp");
       case AMDATHLON_XP:
        return new StringRef(/*KEEP_STR*/"athlon-xp");
       case AMDATHLON_K8SSE3:
        return new StringRef(/*KEEP_STR*/"k8-sse3");
       case AMDATHLON_OPTERON:
        return new StringRef(/*KEEP_STR*/"opteron");
       case AMDATHLON_FX:
        return new StringRef(/*KEEP_STR*/"athlon-fx");
       case AMDATHLON_64:
        return new StringRef(/*KEEP_STR*/"athlon64");
       default:
        return new StringRef(/*KEEP_STR*/"athlon");
      }
     case AMDFAM10H:
      if (Subtype.$star() == ProcessorSubtypes.AMDFAM10H_BARCELONA.getValue()) {
        return new StringRef(/*KEEP_STR*/"barcelona");
      }
      return new StringRef(/*KEEP_STR*/"amdfam10");
     case AMDFAM14H:
      return new StringRef(/*KEEP_STR*/"btver1");
     case AMDFAM15H:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case AMDFAM15H_BDVER1:
        return new StringRef(/*KEEP_STR*/"bdver1");
       case AMDFAM15H_BDVER2:
        return new StringRef(/*KEEP_STR*/"bdver2");
       case AMDFAM15H_BDVER3:
        return new StringRef(/*KEEP_STR*/"bdver3");
       case AMDFAM15H_BDVER4:
        return new StringRef(/*KEEP_STR*/"bdver4");
       case AMD_BTVER1:
        return new StringRef(/*KEEP_STR*/"btver1");
       default:
        return new StringRef(/*KEEP_STR*/"amdfam15");
      }
     case AMDFAM16H:
      switch (ProcessorSubtypes.valueOf(Subtype.$star())) {
       case AMD_BTVER1:
        return new StringRef(/*KEEP_STR*/"btver1");
       case AMD_BTVER2:
        return new StringRef(/*KEEP_STR*/"btver2");
       default:
        return new StringRef(/*KEEP_STR*/"amdfam16");
      }
     default:
      return new StringRef(/*KEEP_STR*/$generic);
    }
  }
  return new StringRef(/*KEEP_STR*/$generic);
}


/// getHostCPUFeatures - Get the LLVM names for the host CPU features.
/// The particular format of the names are target dependent, and suitable for
/// passing as -mattr to the target which matches the host.
///
/// \param Features - A string mapping feature names to either
/// true (if enabled) or false (if disabled). This routine makes no guarantees
/// about exactly which features may appear in this map, except that they are
/// all valid LLVM feature names.
///
/// \return - True on success.
//<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 1154,
 old_source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", old_line = 744,
 FQN="llvm::sys::getHostCPUFeatures", NM="_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE")
//</editor-fold>
public static boolean getHostCPUFeatures(final StringMapBool/*&*/ Features) {
  uint$ptr EAX = create_uint$ptr(0);
  uint$ptr EBX = create_uint$ptr(0);
  uint$ptr ECX = create_uint$ptr(0);
  uint$ptr EDX = create_uint$ptr(0);
  uint$ptr MaxLevel = create_uint$ptr();
  //<editor-fold defaultstate="collapsed" desc="">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 1157,
   FQN="", NM="_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE_Unnamed_union",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEE_Unnamed_union")
  //</editor-fold>
   class/*union*/ Unnamed_union {
    public /*uint*/int u[/*3*/] = new /*uint*/int [3];
    public /*char*/byte c[/*12*/] = new$char(12);
    //<editor-fold defaultstate="collapsed" desc="llvm::sys::getHostCPUFeatures(StringMap<bool> & )::(anonymous union)::">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 1157,
     FQN="llvm::sys::getHostCPUFeatures(StringMap<bool> & )::(anonymous union)::", NM="_ZZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEEEN3$_0C1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZZN4llvm3sys18getHostCPUFeaturesERNS_9StringMapIbNS_15MallocAllocatorEEEEN3$_0C1Ev")
    //</editor-fold>
    public /*inline*/ Unnamed_union() {
    }

    
    @Override public String toString() {
      return "" + "u=" + u // NOI18N
                + ", c=" + c; // NOI18N
    }
  }Unnamed_union text/*J*/= new Unnamed_union();
  if (getX86CpuIDAndInfo(0, $AddrOf(MaxLevel), create_uint$ptr(text.u).$add(0), create_uint$ptr(text.u).$add(2), create_uint$ptr(text.u).$add(1))
     || $less_uint(MaxLevel.$star(), 1)) {
    return false;
  }
  
  getX86CpuIDAndInfo(1, $AddrOf(EAX), $AddrOf(EBX), $AddrOf(ECX), $AddrOf(EDX));
  
  Features.$set(/*STRINGREF_STR*/"cmov", (((EDX.$star() >>> 15) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"mmx", (((EDX.$star() >>> 23) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sse", (((EDX.$star() >>> 25) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sse2", (((EDX.$star() >>> 26) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sse3", (((ECX.$star() >>> 0) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"ssse3", (((ECX.$star() >>> 9) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sse4.1", (((ECX.$star() >>> 19) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sse4.2", (((ECX.$star() >>> 20) & 1) != 0));
  
  Features.$set(/*STRINGREF_STR*/"pclmul", (((ECX.$star() >>> 1) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"cx16", (((ECX.$star() >>> 13) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"movbe", (((ECX.$star() >>> 22) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"popcnt", (((ECX.$star() >>> 23) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"aes", (((ECX.$star() >>> 25) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"rdrnd", (((ECX.$star() >>> 30) & 1) != 0));
  
  // If CPUID indicates support for XSAVE, XRESTORE and AVX, and XGETBV
  // indicates that the AVX registers will be saved and restored on context
  // switch, then we have full AVX support.
  boolean HasAVXSave = (((ECX.$star() >>> 27) & 1) != 0) && (((ECX.$star() >>> 28) & 1) != 0)
     && !getX86XCR0($AddrOf(EAX), $AddrOf(EDX)) && ((EAX.$star() & 0x6) == 0x6);
  Features.$set(/*STRINGREF_STR*/"avx", HasAVXSave);
  Features.$set(/*STRINGREF_STR*/"fma", HasAVXSave && (((ECX.$star() >>> 12) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"f16c", HasAVXSave && (((ECX.$star() >>> 29) & 1) != 0));
  
  // Only enable XSAVE if OS has enabled support for saving YMM state.
  Features.$set(/*STRINGREF_STR*/"xsave", HasAVXSave && (((ECX.$star() >>> 26) & 1) != 0));
  
  // AVX512 requires additional context to be saved by the OS.
  boolean HasAVX512Save = HasAVXSave && ((EAX.$star() & 0xe0) == 0xe0);
  
  uint$ptr MaxExtLevel = create_uint$ptr();
  getX86CpuIDAndInfo(0x80000000/*U*/, $AddrOf(MaxExtLevel), $AddrOf(EBX), $AddrOf(ECX), $AddrOf(EDX));
  
  boolean HasExtLeaf1 = $greatereq_uint(MaxExtLevel.$star(), 0x80000001/*U*/)
     && !getX86CpuIDAndInfo(0x80000001/*U*/, $AddrOf(EAX), $AddrOf(EBX), $AddrOf(ECX), $AddrOf(EDX));
  Features.$set(/*STRINGREF_STR*/"lzcnt", HasExtLeaf1 && (((ECX.$star() >>> 5) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sse4a", HasExtLeaf1 && (((ECX.$star() >>> 6) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"prfchw", HasExtLeaf1 && (((ECX.$star() >>> 8) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"xop", HasExtLeaf1 && (((ECX.$star() >>> 11) & 1) != 0) && HasAVXSave);
  Features.$set(/*STRINGREF_STR*/"fma4", HasExtLeaf1 && (((ECX.$star() >>> 16) & 1) != 0) && HasAVXSave);
  Features.$set(/*STRINGREF_STR*/"tbm", HasExtLeaf1 && (((ECX.$star() >>> 21) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"mwaitx", HasExtLeaf1 && (((ECX.$star() >>> 29) & 1) != 0));
  
  boolean HasLeaf7 = $greatereq_uint(MaxLevel.$star(), 7) && !getX86CpuIDAndInfoEx(0x7, 0x0, $AddrOf(EAX), $AddrOf(EBX), $AddrOf(ECX), $AddrOf(EDX));
  
  // AVX2 is only supported if we have the OS save support from AVX.
  Features.$set(/*STRINGREF_STR*/"avx2", HasAVXSave && HasLeaf7 && (((EBX.$star() >>> 5) & 1) != 0));
  
  Features.$set(/*STRINGREF_STR*/"fsgsbase", HasLeaf7 && (((EBX.$star() >>> 0) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sgx", HasLeaf7 && (((EBX.$star() >>> 2) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"bmi", HasLeaf7 && (((EBX.$star() >>> 3) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"hle", HasLeaf7 && (((EBX.$star() >>> 4) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"bmi2", HasLeaf7 && (((EBX.$star() >>> 8) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"invpcid", HasLeaf7 && (((EBX.$star() >>> 10) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"rtm", HasLeaf7 && (((EBX.$star() >>> 11) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"rdseed", HasLeaf7 && (((EBX.$star() >>> 18) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"adx", HasLeaf7 && (((EBX.$star() >>> 19) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"smap", HasLeaf7 && (((EBX.$star() >>> 20) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"pcommit", HasLeaf7 && (((EBX.$star() >>> 22) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"clflushopt", HasLeaf7 && (((EBX.$star() >>> 23) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"clwb", HasLeaf7 && (((EBX.$star() >>> 24) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"sha", HasLeaf7 && (((EBX.$star() >>> 29) & 1) != 0));
  
  // AVX512 is only supported if the OS supports the context save for it.
  Features.$set(/*STRINGREF_STR*/"avx512f", HasLeaf7 && (((EBX.$star() >>> 16) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512dq", HasLeaf7 && (((EBX.$star() >>> 17) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512ifma", HasLeaf7 && (((EBX.$star() >>> 21) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512pf", HasLeaf7 && (((EBX.$star() >>> 26) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512er", HasLeaf7 && (((EBX.$star() >>> 27) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512cd", HasLeaf7 && (((EBX.$star() >>> 28) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512bw", HasLeaf7 && (((EBX.$star() >>> 30) & 1) != 0) && HasAVX512Save);
  Features.$set(/*STRINGREF_STR*/"avx512vl", HasLeaf7 && (((EBX.$star() >>> 31) & 1) != 0) && HasAVX512Save);
  
  Features.$set(/*STRINGREF_STR*/"prefetchwt1", HasLeaf7 && ((ECX.$star() & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"avx512vbmi", HasLeaf7 && (((ECX.$star() >>> 1) & 1) != 0) && HasAVX512Save);
  // Enable protection keys
  Features.$set(/*STRINGREF_STR*/"pku", HasLeaf7 && (((ECX.$star() >>> 4) & 1) != 0));
  
  boolean HasLeafD = $greatereq_uint(MaxLevel.$star(), 0xd)
     && !getX86CpuIDAndInfoEx(0xd, 0x1, $AddrOf(EAX), $AddrOf(EBX), $AddrOf(ECX), $AddrOf(EDX));
  
  // Only enable XSAVE if OS has enabled support for saving YMM state.
  Features.$set(/*STRINGREF_STR*/"xsaveopt", HasAVXSave && HasLeafD && (((EAX.$star() >>> 0) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"xsavec", HasAVXSave && HasLeafD && (((EAX.$star() >>> 1) & 1) != 0));
  Features.$set(/*STRINGREF_STR*/"xsaves", HasAVXSave && HasLeafD && (((EAX.$star() >>> 3) & 1) != 0));
  
  return true;
}

} // END OF class HostSysGlobals
