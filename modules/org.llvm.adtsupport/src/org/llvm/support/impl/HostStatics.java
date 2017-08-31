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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Unsigned.*;


//<editor-fold defaultstate="collapsed" desc="static type HostStatics">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.llvm.support.impl.HostStatics",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL10getX86XCR0PjS_;_ZL11readCpuInfoPvj;_ZL18getX86CpuIDAndInfojPjS_S_S_;_ZL20detectX86FamilyModeljPjS_;_ZL20getAvailableFeaturesjjj;_ZL20getX86CpuIDAndInfoExjjPjS_S_S_;_ZL29getAMDProcessorTypeAndSubtypejjjPjS_;_ZL31getIntelProcessorTypeAndSubtypejjjjPjS_; -static-type=HostStatics -package=org.llvm.support.impl")
//</editor-fold>
public final class HostStatics {


/// getX86CpuIDAndInfo - Execute the specified cpuid and return the 4 values in
/// the specified arguments.  If we can't run cpuid on the host, return true.
//<editor-fold defaultstate="collapsed" desc="getX86CpuIDAndInfo">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 174,
 FQN="getX86CpuIDAndInfo", NM="_ZL18getX86CpuIDAndInfojPjS_S_S_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL18getX86CpuIDAndInfojPjS_S_S_")
//</editor-fold>
public static boolean getX86CpuIDAndInfo(/*uint*/int value, uint$ptr/*uint P*/ rEAX, uint$ptr/*uint P*/ rEBX, 
                  uint$ptr/*uint P*/ rECX, uint$ptr/*uint P*/ rEDX) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// getX86CpuIDAndInfoEx - Execute the specified cpuid with subleaf and return
/// the 4 values in the specified arguments.  If we can't run cpuid on the host,
/// return true.
//<editor-fold defaultstate="collapsed" desc="getX86CpuIDAndInfoEx">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 214,
 FQN="getX86CpuIDAndInfoEx", NM="_ZL20getX86CpuIDAndInfoExjjPjS_S_S_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL20getX86CpuIDAndInfoExjjPjS_S_S_")
//</editor-fold>
public static boolean getX86CpuIDAndInfoEx(/*uint*/int value, /*uint*/int subleaf, 
                    uint$ptr/*uint P*/ rEAX, uint$ptr/*uint P*/ rEBX, uint$ptr/*uint P*/ rECX, 
                    uint$ptr/*uint P*/ rEDX) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="getX86XCR0">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 268,
 FQN="getX86XCR0", NM="_ZL10getX86XCR0PjS_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL10getX86XCR0PjS_")
//</editor-fold>
public static boolean getX86XCR0(uint$ptr/*uint P*/ rEAX, uint$ptr/*uint P*/ rEDX) {
  // Check xgetbv; this uses a .byte sequence instead of the instruction
  // directly because older assemblers do not include support for xgetbv and
  // there is no easy way to conditionally compile based on the assembler used.
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="detectX86FamilyModel">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 285,
 FQN="detectX86FamilyModel", NM="_ZL20detectX86FamilyModeljPjS_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL20detectX86FamilyModeljPjS_")
//</editor-fold>
public static void detectX86FamilyModel(/*uint*/int EAX, uint$ptr/*uint P*/ Family, 
                    uint$ptr/*uint P*/ Model) {
  Family.$set((EAX >>> 8) & 0xf); // Bits 8 - 11
  Model.$set((EAX >>> 4) & 0xf); // Bits 4 - 7
  if (Family.$star() == 6 || Family.$star() == 0xf) {
    if (Family.$star() == 0xf) {
      // Examine extended family ID if family ID is F.
      Family.$set$addassign(0, (EAX >>> 20) & 0xff); // Bits 20 - 27
    }
    // Examine extended model ID if family ID is 6 or F.
    Model.$set$addassign(0, ((EAX >>> 16) & 0xf) << 4); // Bits 16 - 19
  }
}

//<editor-fold defaultstate="collapsed" desc="getIntelProcessorTypeAndSubtype">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 298,
 FQN="getIntelProcessorTypeAndSubtype", NM="_ZL31getIntelProcessorTypeAndSubtypejjjjPjS_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL31getIntelProcessorTypeAndSubtypejjjjPjS_")
//</editor-fold>
public static void getIntelProcessorTypeAndSubtype(/*uint*/int Family, /*uint*/int Model, 
                               /*uint*/int Brand_id, /*uint*/int Features, 
                               uint$ptr/*uint P*/ Type, uint$ptr/*uint P*/ Subtype) {
  if (Brand_id != 0) {
    return;
  }
  switch (Family) {
   case 3:
    Type.$set(ProcessorTypes.INTEL_i386.getValue());
    break;
   case 4:
    switch (Model) {
     case 0: // Intel486 DX processors
     case 1: // Intel486 DX processors
     case 2: // Intel486 SX processors
     case 3: // Intel487 processors, IntelDX2 OverDrive processors,
      // IntelDX2 processors
     case 4: // Intel486 SL processor
     case 5: // IntelSX2 processors
     case 7: // Write-Back Enhanced IntelDX2 processors
     case 8: // IntelDX4 OverDrive processors, IntelDX4 processors
     default:
      Type.$set(ProcessorTypes.INTEL_i486.getValue());
      break;
    }
    break;
   case 5:
    switch (Model) {
     case 1: // Pentium OverDrive processor for Pentium processor (60, 66),
      // Pentium processors (60, 66)
     case 2: // Pentium OverDrive processor for Pentium processor (75, 90,
      // 100, 120, 133), Pentium processors (75, 90, 100, 120, 133,
      // 150, 166, 200)
     case 3: // Pentium OverDrive processors for Intel486 processor-based
      // systems
      Type.$set(ProcessorTypes.INTEL_PENTIUM.getValue());
      break;
     case 4: // Pentium OverDrive processor with MMX technology for Pentium
      // processor (75, 90, 100, 120, 133), Pentium processor with
      // MMX technology (166, 200)
      Type.$set(ProcessorTypes.INTEL_PENTIUM.getValue());
      Subtype.$set(ProcessorSubtypes.INTEL_PENTIUM_MMX.getValue());
      break;
     default:
      Type.$set(ProcessorTypes.INTEL_PENTIUM.getValue());
      break;
    }
    break;
   case 6:
    switch (Model) {
     case 0x01: // Pentium Pro processor
      Type.$set(ProcessorTypes.INTEL_PENTIUM_PRO.getValue());
      break;
     case 0x03: // Intel Pentium II OverDrive processor, Pentium II processor,
      // model 03
     case 0x05: // Pentium II processor, model 05, Pentium II Xeon processor,
      // model 05, and Intel Celeron processor, model 05
     case 0x06: // Celeron processor, model 06
      Type.$set(ProcessorTypes.INTEL_PENTIUM_II.getValue());
      break;
     case 0x07: // Pentium III processor, model 07, and Pentium III Xeon
      // processor, model 07
     case 0x08: // Pentium III processor, model 08, Pentium III Xeon processor,
      // model 08, and Celeron processor, model 08
     case 0x0a: // Pentium III Xeon processor, model 0Ah
     case 0x0b: // Pentium III processor, model 0Bh
      Type.$set(ProcessorTypes.INTEL_PENTIUM_III.getValue());
      break;
     case 0x09: // Intel Pentium M processor, Intel Celeron M processor model 09.
     case 0x0d: // Intel Pentium M processor, Intel Celeron M processor, model
      // 0Dh. All processors are manufactured using the 90 nm process.
     case 0x15: // Intel EP80579 Integrated Processor and Intel EP80579
      // Integrated Processor with Intel QuickAssist Technology
      Type.$set(ProcessorTypes.INTEL_PENTIUM_M.getValue());
      break;
     case 0x0e: // Intel Core Duo processor, Intel Core Solo processor, model
      // 0Eh. All processors are manufactured using the 65 nm process.
      Type.$set(ProcessorTypes.INTEL_CORE_DUO.getValue());
      break; // yonah
     case 0x0f: // Intel Core 2 Duo processor, Intel Core 2 Duo mobile
      // processor, Intel Core 2 Quad processor, Intel Core 2 Quad
      // mobile processor, Intel Core 2 Extreme processor, Intel
      // Pentium Dual-Core processor, Intel Xeon processor, model
      // 0Fh. All processors are manufactured using the 65 nm process.
     case 0x16: // Intel Celeron processor model 16h. All processors are
      // manufactured using the 65 nm process
      Type.$set(ProcessorTypes.INTEL_CORE2.getValue()); // "core2"
      Subtype.$set(ProcessorSubtypes.INTEL_CORE2_65.getValue());
      break;
     case 0x17: // Intel Core 2 Extreme processor, Intel Xeon processor, model
      // 17h. All processors are manufactured using the 45 nm process.
      //
      // 45nm: Penryn , Wolfdale, Yorkfield (XE)
     case 0x1d: // Intel Xeon processor MP. All processors are manufactured using
      // the 45 nm process.
      Type.$set(ProcessorTypes.INTEL_CORE2.getValue()); // "penryn"
      Subtype.$set(ProcessorSubtypes.INTEL_CORE2_45.getValue());
      break;
     case 0x1a: // Intel Core i7 processor and Intel Xeon processor. All
      // processors are manufactured using the 45 nm process.
     case 0x1e: // Intel(R) Core(TM) i7 CPU         870  @ 2.93GHz.
      // As found in a Summer 2010 model iMac.
     case 0x1f:
     case 0x2e: // Nehalem EX
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "nehalem"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_NEHALEM.getValue());
      break;
     case 0x25: // Intel Core i7, laptop version.
     case 0x2c: // Intel Core i7 processor and Intel Xeon processor. All
      // processors are manufactured using the 32 nm process.
     case 0x2f: // Westmere EX
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "westmere"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_WESTMERE.getValue());
      break;
     case 0x2a: // Intel Core i7 processor. All processors are manufactured
      // using the 32 nm process.
     case 0x2d:
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); //"sandybridge"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_SANDYBRIDGE.getValue());
      break;
     case 0x3a:
     case 0x3e: // Ivy Bridge EP
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "ivybridge"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_IVYBRIDGE.getValue());
      break;
     case 0x3c:
     case 0x3f:
     case 0x45:
     case 0x46:
      
      // Haswell:
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "haswell"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_HASWELL.getValue());
      break;
     case 0x3d:
     case 0x47:
     case 0x4f:
     case 0x56:
      
      // Broadwell:
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "broadwell"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_BROADWELL.getValue());
      break;
     case 0x4e:
      
      // Skylake:
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "skylake-avx512"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_SKYLAKE_AVX512.getValue());
      break;
     case 0x5e:
      Type.$set(ProcessorTypes.INTEL_COREI7.getValue()); // "skylake"
      Subtype.$set(ProcessorSubtypes.INTEL_COREI7_SKYLAKE.getValue());
      break;
     case 0x1c: // Most 45 nm Intel Atom processors
     case 0x26: // 45 nm Atom Lincroft
     case 0x27: // 32 nm Atom Medfield
     case 0x35: // 32 nm Atom Midview
     case 0x36: // 32 nm Atom Midview
      Type.$set(ProcessorTypes.INTEL_ATOM.getValue());
      Subtype.$set(ProcessorSubtypes.INTEL_ATOM_BONNELL.getValue());
      break; // "bonnell"
     case 0x37:
     case 0x4a:
     case 0x4d:
     case 0x5a:
     case 0x5d:
     case 0x4c: // really airmont
      Type.$set(ProcessorTypes.INTEL_ATOM.getValue());
      Subtype.$set(ProcessorSubtypes.INTEL_ATOM_SILVERMONT.getValue());
      break; // "silvermont"
     case 0x57:
      Type.$set(ProcessorTypes.INTEL_XEONPHI.getValue()); // knl
      Subtype.$set(ProcessorSubtypes.INTEL_KNIGHTS_LANDING.getValue());
      break;
     default: // Unknown family 6 CPU, try to guess.
      if (((Features & (1 << ProcessorFeatures.FEATURE_AVX512.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_XEONPHI.getValue()); // knl
        Subtype.$set(ProcessorSubtypes.INTEL_KNIGHTS_LANDING.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_ADX.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_COREI7.getValue());
        Subtype.$set(ProcessorSubtypes.INTEL_COREI7_BROADWELL.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_AVX2.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_COREI7.getValue());
        Subtype.$set(ProcessorSubtypes.INTEL_COREI7_HASWELL.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_AVX.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_COREI7.getValue());
        Subtype.$set(ProcessorSubtypes.INTEL_COREI7_SANDYBRIDGE.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_SSE4_2.getValue())) != 0)) {
        if (((Features & (1 << ProcessorFeatures.FEATURE_MOVBE.getValue())) != 0)) {
          Type.$set(ProcessorTypes.INTEL_ATOM.getValue());
          Subtype.$set(ProcessorSubtypes.INTEL_ATOM_SILVERMONT.getValue());
        } else {
          Type.$set(ProcessorTypes.INTEL_COREI7.getValue());
          Subtype.$set(ProcessorSubtypes.INTEL_COREI7_NEHALEM.getValue());
        }
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_SSE4_1.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_CORE2.getValue()); // "penryn"
        Subtype.$set(ProcessorSubtypes.INTEL_CORE2_45.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_SSSE3.getValue())) != 0)) {
        if (((Features & (1 << ProcessorFeatures.FEATURE_MOVBE.getValue())) != 0)) {
          Type.$set(ProcessorTypes.INTEL_ATOM.getValue());
          Subtype.$set(ProcessorSubtypes.INTEL_ATOM_BONNELL.getValue()); // "bonnell"
        } else {
          Type.$set(ProcessorTypes.INTEL_CORE2.getValue()); // "core2"
          Subtype.$set(ProcessorSubtypes.INTEL_CORE2_65.getValue());
        }
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_EM64T.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_X86_64.getValue());
        break; // x86-64
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_SSE2.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_PENTIUM_M.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_SSE.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_PENTIUM_III.getValue());
        break;
      }
      if (((Features & (1 << ProcessorFeatures.FEATURE_MMX.getValue())) != 0)) {
        Type.$set(ProcessorTypes.INTEL_PENTIUM_II.getValue());
        break;
      }
      Type.$set(ProcessorTypes.INTEL_PENTIUM_PRO.getValue());
      break;
    }
    break;
   case 15:
    {
      switch (Model) {
       case 0: // Pentium 4 processor, Intel Xeon processor. All processors are
        // model 00h and manufactured using the 0.18 micron process.
       case 1: // Pentium 4 processor, Intel Xeon processor, Intel Xeon
        // processor MP, and Intel Celeron processor. All processors are
        // model 01h and manufactured using the 0.18 micron process.
       case 2: // Pentium 4 processor, Mobile Intel Pentium 4 processor - M,
        // Intel Xeon processor, Intel Xeon processor MP, Intel Celeron
        // processor, and Mobile Intel Celeron processor. All processors
        // are model 02h and manufactured using the 0.13 micron process.
        Type.$set(
          (((Features & (1 << ProcessorFeatures.FEATURE_EM64T.getValue())) != 0) ? ProcessorTypes.INTEL_X86_64 : ProcessorTypes.INTEL_PENTIUM_IV).getValue());
        break;
       case 3: // Pentium 4 processor, Intel Xeon processor, Intel Celeron D
        // processor. All processors are model 03h and manufactured using
        // the 90 nm process.
       case 4: // Pentium 4 processor, Pentium 4 processor Extreme Edition,
        // Pentium D processor, Intel Xeon processor, Intel Xeon
        // processor MP, Intel Celeron D processor. All processors are
        // model 04h and manufactured using the 90 nm process.
       case 6: // Pentium 4 processor, Pentium D processor, Pentium processor
        // Extreme Edition, Intel Xeon processor, Intel Xeon processor
        // MP, Intel Celeron D processor. All processors are model 06h
        // and manufactured using the 65 nm process.
        Type.$set(
          (((Features & (1 << ProcessorFeatures.FEATURE_EM64T.getValue())) != 0) ? ProcessorTypes.INTEL_NOCONA : ProcessorTypes.INTEL_PRESCOTT).getValue());
        break;
       default:
        Type.$set(
          (((Features & (1 << ProcessorFeatures.FEATURE_EM64T.getValue())) != 0) ? ProcessorTypes.INTEL_X86_64 : ProcessorTypes.INTEL_PENTIUM_IV).getValue());
        break;
      }
      break;
    }
   default:
    break; /*"generic"*/
  }
}

//<editor-fold defaultstate="collapsed" desc="getAMDProcessorTypeAndSubtype">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 585,
 FQN="getAMDProcessorTypeAndSubtype", NM="_ZL29getAMDProcessorTypeAndSubtypejjjPjS_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL29getAMDProcessorTypeAndSubtypejjjPjS_")
//</editor-fold>
public static void getAMDProcessorTypeAndSubtype(/*uint*/int Family, 
                             /*uint*/int Model, 
                             /*uint*/int Features, 
                             uint$ptr/*uint P*/ Type, 
                             uint$ptr/*uint P*/ Subtype) {
  // FIXME: this poorly matches the generated SubtargetFeatureKV table.  There
  // appears to be no way to generate the wide variety of AMD-specific targets
  // from the information returned from CPUID.
  switch (Family) {
   case 4:
    Type.$set(ProcessorTypes.AMD_i486.getValue());
    break;
   case 5:
    Type.$set(ProcessorTypes.AMDPENTIUM.getValue());
    switch (Model) {
     case 6:
     case 7:
      Subtype.$set(ProcessorSubtypes.AMDPENTIUM_K6.getValue());
      break; // "k6"
     case 8:
      Subtype.$set(ProcessorSubtypes.AMDPENTIUM_K62.getValue());
      break; // "k6-2"
     case 9:
     case 13:
      Subtype.$set(ProcessorSubtypes.AMDPENTIUM_K63.getValue());
      break; // "k6-3"
     case 10:
      Subtype.$set(ProcessorSubtypes.AMDPENTIUM_GEODE.getValue());
      break; // "geode"
    }
    break;
   case 6:
    Type.$set(ProcessorTypes.AMDATHLON.getValue());
    switch (Model) {
     case 4:
      Subtype.$set(ProcessorSubtypes.AMDATHLON_TBIRD.getValue());
      break; // "athlon-tbird"
     case 6:
     case 7:
     case 8:
      Subtype.$set(ProcessorSubtypes.AMDATHLON_MP.getValue());
      break; // "athlon-mp"
     case 10:
      Subtype.$set(ProcessorSubtypes.AMDATHLON_XP.getValue());
      break; // "athlon-xp"
    }
    break;
   case 15:
    Type.$set(ProcessorTypes.AMDATHLON.getValue());
    if (((Features & (1 << ProcessorFeatures.FEATURE_SSE3.getValue())) != 0)) {
      Subtype.$set(ProcessorSubtypes.AMDATHLON_K8SSE3.getValue());
      break; // "k8-sse3"
    }
    switch (Model) {
     case 1:
      Subtype.$set(ProcessorSubtypes.AMDATHLON_OPTERON.getValue());
      break; // "opteron"
     case 5:
      Subtype.$set(ProcessorSubtypes.AMDATHLON_FX.getValue());
      break; // "athlon-fx"; also opteron
     default:
      Subtype.$set(ProcessorSubtypes.AMDATHLON_64.getValue());
      break; // "athlon64"
    }
    break;
   case 16:
    Type.$set(ProcessorTypes.AMDFAM10H.getValue()); // "amdfam10"
    switch (Model) {
     case 2:
      Subtype.$set(ProcessorSubtypes.AMDFAM10H_BARCELONA.getValue());
      break;
     case 4:
      Subtype.$set(ProcessorSubtypes.AMDFAM10H_SHANGHAI.getValue());
      break;
     case 8:
      Subtype.$set(ProcessorSubtypes.AMDFAM10H_ISTANBUL.getValue());
      break;
    }
    break;
   case 20:
    Type.$set(ProcessorTypes.AMDFAM14H.getValue());
    Subtype.$set(ProcessorSubtypes.AMD_BTVER1.getValue());
    break; // "btver1";
   case 21:
    Type.$set(ProcessorTypes.AMDFAM15H.getValue());
    if (!((Features
       & (1 << ProcessorFeatures.FEATURE_AVX.getValue())) != 0)) { // If no AVX support, provide a sane fallback.
      Subtype.$set(ProcessorSubtypes.AMD_BTVER1.getValue());
      break; // "btver1"
    }
    if ($greatereq_uint(Model, 0x50) && $lesseq_uint(Model, 0x6f)) {
      Subtype.$set(ProcessorSubtypes.AMDFAM15H_BDVER4.getValue());
      break; // "bdver4"; 50h-6Fh: Excavator
    }
    if ($greatereq_uint(Model, 0x30) && $lesseq_uint(Model, 0x3f)) {
      Subtype.$set(ProcessorSubtypes.AMDFAM15H_BDVER3.getValue());
      break; // "bdver3"; 30h-3Fh: Steamroller
    }
    if ($greatereq_uint(Model, 0x10) && $lesseq_uint(Model, 0x1f)) {
      Subtype.$set(ProcessorSubtypes.AMDFAM15H_BDVER2.getValue());
      break; // "bdver2"; 10h-1Fh: Piledriver
    }
    if ($lesseq_uint(Model, 0x0f)) {
      Subtype.$set(ProcessorSubtypes.AMDFAM15H_BDVER1.getValue());
      break; // "bdver1"; 00h-0Fh: Bulldozer
    }
    break;
   case 22:
    Type.$set(ProcessorTypes.AMDFAM16H.getValue());
    if (!((Features
       & (1 << ProcessorFeatures.FEATURE_AVX.getValue())) != 0)) { // If no AVX support provide a sane fallback.
      Subtype.$set(ProcessorSubtypes.AMD_BTVER1.getValue());
      break; // "btver1";
    }
    Subtype.$set(ProcessorSubtypes.AMD_BTVER2.getValue());
    break; // "btver2"
   default:
    break; // "generic"
  }
}

//<editor-fold defaultstate="collapsed" desc="getAvailableFeatures">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/lib/Support/Host.cpp", line = 706,
 FQN="getAvailableFeatures", NM="_ZL20getAvailableFeaturesjjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/Host.cpp -nm=_ZL20getAvailableFeaturesjjj")
//</editor-fold>
public static /*uint*/int getAvailableFeatures(/*uint*/int ECX, /*uint*/int EDX, 
                    /*uint*/int MaxLeaf) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class HostStatics
