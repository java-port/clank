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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.target.ARM.*;
import static org.llvm.support.target.impl.TargetParserStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type AArch64">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6410getCPUAttrEj;_ZN4llvm7AArch6410getFPUNameEj;_ZN4llvm7AArch6410getSubArchEj;_ZN4llvm7AArch6411ArchExtKindE;_ZN4llvm7AArch6411getArchAttrEj;_ZN4llvm7AArch6411getArchNameEj;_ZN4llvm7AArch6412parseArchExtENS_9StringRefE;_ZN4llvm7AArch6412parseArchISAENS_9StringRefE;_ZN4llvm7AArch6412parseCPUArchENS_9StringRefE;_ZN4llvm7AArch6413getDefaultCPUENS_9StringRefE;_ZN4llvm7AArch6413getDefaultFPUENS_9StringRefEj;_ZN4llvm7AArch6413getFPUVersionEj;_ZN4llvm7AArch6414getArchExtNameEj;_ZN4llvm7AArch6414getFPUFeaturesEjRSt6vectorIPKcSaIS3_EE;_ZN4llvm7AArch6415getArchFeaturesEjRSt6vectorIPKcSaIS3_EE;_ZN4llvm7AArch6415parseArchEndianENS_9StringRefE;_ZN4llvm7AArch6416checkArchVersionENS_9StringRefE;_ZN4llvm7AArch6416parseArchProfileENS_9StringRefE;_ZN4llvm7AArch6416parseArchVersionENS_9StringRefE;_ZN4llvm7AArch6417getArchExtFeatureENS_9StringRefE;_ZN4llvm7AArch6417getFPURestrictionEj;_ZN4llvm7AArch6420getCanonicalArchNameENS_9StringRefE;_ZN4llvm7AArch6420getDefaultExtensionsENS_9StringRefEj;_ZN4llvm7AArch6420getExtensionFeaturesEjRSt6vectorIPKcSaIS3_EE;_ZN4llvm7AArch6422getFPUNeonSupportLevelEj;_ZN4llvm7AArch648parseFPUENS_9StringRefE;_ZN4llvm7AArch649parseArchENS_9StringRefE; -static-type=AArch64 -package=org.llvm.support.target")
//</editor-fold>
public final class AArch64 {


// Arch extension modifiers for CPUs.
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::ArchExtKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/include/llvm/Support/TargetParser.h", line = 149,
 FQN="llvm::AArch64::ArchExtKind", NM="_ZN4llvm7AArch6411ArchExtKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6411ArchExtKindE")
//</editor-fold>
public static final class/*enum*/ ArchExtKind/* : unsigned int*/ {
  public static final /*uint*/int AEK_INVALID = 0x0;
  public static final /*uint*/int AEK_NONE = 0x1;
  public static final /*uint*/int AEK_CRC = 0x2;
  public static final /*uint*/int AEK_CRYPTO = 0x4;
  public static final /*uint*/int AEK_FP = 0x8;
  public static final /*uint*/int AEK_SIMD = 0x10;
  public static final /*uint*/int AEK_FP16 = 0x20;
  public static final /*uint*/int AEK_PROFILE = 0x40;
  public static final /*uint*/int AEK_RAS = 0x80;
}
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getCanonicalArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 775,
 FQN="llvm::AArch64::getCanonicalArchName", NM="_ZN4llvm7AArch6420getCanonicalArchNameENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6420getCanonicalArchNameENS_9StringRefE")
//</editor-fold>
public static StringRef getCanonicalArchName(StringRef Arch) {
  return ARM.getCanonicalArchName(/*NO_COPY*/Arch);
}


// Information by ID
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getFPUName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 386,
 FQN="llvm::AArch64::getFPUName", NM="_ZN4llvm7AArch6410getFPUNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6410getFPUNameEj")
//</editor-fold>
public static StringRef getFPUName(/*uint*/int FPUKind) {
  return ARM.getFPUName(FPUKind);
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getFPUVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 390,
 FQN="llvm::AArch64::getFPUVersion", NM="_ZN4llvm7AArch6413getFPUVersionEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6413getFPUVersionEj")
//</editor-fold>
public static /*uint*/int getFPUVersion(/*uint*/int FPUKind) {
  return ARM.getFPUVersion(FPUKind);
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getFPUNeonSupportLevel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 394,
 FQN="llvm::AArch64::getFPUNeonSupportLevel", NM="_ZN4llvm7AArch6422getFPUNeonSupportLevelEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6422getFPUNeonSupportLevelEj")
//</editor-fold>
public static /*uint*/int getFPUNeonSupportLevel(/*uint*/int FPUKind) {
  return ARM.getFPUNeonSupportLevel(FPUKind);
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getFPURestriction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 398,
 FQN="llvm::AArch64::getFPURestriction", NM="_ZN4llvm7AArch6417getFPURestrictionEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6417getFPURestrictionEj")
//</editor-fold>
public static /*uint*/int getFPURestriction(/*uint*/int FPUKind) {
  return ARM.getFPURestriction(FPUKind);
}


// FIXME: These should be moved to TargetTuple once it exists
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getFPUFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 448,
 FQN="llvm::AArch64::getFPUFeatures", NM="_ZN4llvm7AArch6414getFPUFeaturesEjRSt6vectorIPKcSaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6414getFPUFeaturesEjRSt6vectorIPKcSaIS3_EE")
//</editor-fold>
public static boolean getFPUFeatures(/*uint*/int FPUKind, 
              vectorCharPtr/*&*/ Features) {
  return ARM.getFPUFeatures(FPUKind, Features);
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getExtensionFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 424,
 FQN="llvm::AArch64::getExtensionFeatures", NM="_ZN4llvm7AArch6420getExtensionFeaturesEjRSt6vectorIPKcSaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6420getExtensionFeaturesEjRSt6vectorIPKcSaIS3_EE")
//</editor-fold>
public static boolean getExtensionFeatures(/*uint*/int Extensions, 
                    vectorCharPtr/*&*/ Features) {
  if (Extensions == AArch64.ArchExtKind.AEK_INVALID) {
    return false;
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_FP) != 0)) {
    Features.push_back_T$RR($("+fp-armv8"));
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_SIMD) != 0)) {
    Features.push_back_T$RR($("+neon"));
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_CRC) != 0)) {
    Features.push_back_T$RR($("+crc"));
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_CRYPTO) != 0)) {
    Features.push_back_T$RR($("+crypto"));
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_FP16) != 0)) {
    Features.push_back_T$RR($("+fullfp16"));
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_PROFILE) != 0)) {
    Features.push_back_T$RR($("+spe"));
  }
  if (((Extensions & AArch64.ArchExtKind.AEK_RAS) != 0)) {
    Features.push_back_T$RR($("+ras"));
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getArchFeatures">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 453,
 FQN="llvm::AArch64::getArchFeatures", NM="_ZN4llvm7AArch6415getArchFeaturesEjRSt6vectorIPKcSaIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6415getArchFeaturesEjRSt6vectorIPKcSaIS3_EE")
//</editor-fold>
public static boolean getArchFeatures(/*uint*/int ArchKind, 
               vectorCharPtr/*&*/ Features) {
  if (ArchKind == ARM.ArchKind.AK_INVALID.getValue() || $greatereq_uint(ArchKind, ARM.ArchKind.AK_LAST.getValue())) {
    return false;
  }
  if (ArchKind == ARM.ArchKind.AK_ARMV8_1A.getValue()) {
    Features.push_back_T$RR($("+v8.1a"));
  }
  if (ArchKind == ARM.ArchKind.AK_ARMV8_2A.getValue()) {
    Features.push_back_T$RR($("+v8.2a"));
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getArchName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 466,
 FQN="llvm::AArch64::getArchName", NM="_ZN4llvm7AArch6411getArchNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6411getArchNameEj")
//</editor-fold>
public static StringRef getArchName(/*uint*/int ArchKind) {
  for (Unnamed_struct1 AI : AArch64ARCHNames)  {
    if (AI.ID.getValue() == ArchKind) {
      return AI.getName();
    }
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getArchAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 487,
 FQN="llvm::AArch64::getArchAttr", NM="_ZN4llvm7AArch6411getArchAttrEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6411getArchAttrEj")
//</editor-fold>
public static /*uint*/int getArchAttr(/*uint*/int ArchKind) {
  for (Unnamed_struct1 AI : AArch64ARCHNames)  {
    if (AI.ID.getValue() == ArchKind) {
      return AI.ArchAttr.getValue();
    }
  }
  return ARMBuildAttrs.CPUArch.v8_A.getValue();
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getCPUAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 473,
 FQN="llvm::AArch64::getCPUAttr", NM="_ZN4llvm7AArch6410getCPUAttrEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6410getCPUAttrEj")
//</editor-fold>
public static StringRef getCPUAttr(/*uint*/int ArchKind) {
  for (Unnamed_struct1 AI : AArch64ARCHNames)  {
    if (AI.ID.getValue() == ArchKind) {
      return AI.getCPUAttr();
    }
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getSubArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 480,
 FQN="llvm::AArch64::getSubArch", NM="_ZN4llvm7AArch6410getSubArchEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6410getSubArchEj")
//</editor-fold>
public static StringRef getSubArch(/*uint*/int ArchKind) {
  for (Unnamed_struct1 AI : AArch64ARCHNames)  {
    if (AI.ID.getValue() == ArchKind) {
      return AI.getSubArch();
    }
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getArchExtName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 494,
 FQN="llvm::AArch64::getArchExtName", NM="_ZN4llvm7AArch6414getArchExtNameEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6414getArchExtNameEj")
//</editor-fold>
public static StringRef getArchExtName(/*uint*/int AArchExtKind) {
  for (Unnamed_struct2 AE : AArch64ARCHExtNames)  {
    if (AArchExtKind == AE.ID) {
      return AE.getName();
    }
  }
  return new StringRef();
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getArchExtFeature">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 501,
 FQN="llvm::AArch64::getArchExtFeature", NM="_ZN4llvm7AArch6417getArchExtFeatureENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6417getArchExtFeatureENS_9StringRefE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getArchExtFeature(StringRef ArchExt) {
  if (ArchExt.startswith(/*STRINGREF_STR*/"no")) {
    StringRef ArchExtBase/*J*/= ArchExt.substr(2);
    for (Unnamed_struct2 AE : AArch64ARCHExtNames) {
      if ((AE.NegFeature != null) && $eq_StringRef(/*NO_COPY*/ArchExtBase, AE.getName())) {
        return AE.NegFeature;
      }
    }
  }
  
  for (Unnamed_struct2 AE : AArch64ARCHExtNames)  {
    if ((AE.Feature != null) && $eq_StringRef(/*NO_COPY*/ArchExt, AE.getName())) {
      return AE.Feature;
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::checkArchVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 530,
 FQN="llvm::AArch64::checkArchVersion", NM="_ZN4llvm7AArch6416checkArchVersionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6416checkArchVersionENS_9StringRefE")
//</editor-fold>
public static /*uint*/int checkArchVersion(StringRef Arch) {
  if (Arch.$at(0) == $$v && (std.isdigit(Arch.$at(1)) != 0)) {
    return (Arch.$at(1) - 48);
  }
  return 0;
}


// Information by Name
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getDefaultFPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 402,
 FQN="llvm::AArch64::getDefaultFPU", NM="_ZN4llvm7AArch6413getDefaultFPUENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6413getDefaultFPUENS_9StringRefEj")
//</editor-fold>
public static /*uint*/int getDefaultFPU(StringRef CPU, /*uint*/int ArchKind) {
  if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"generic")) {
    return AArch64ARCHNames[ArchKind].DefaultFPU;
  }
  
  return new StringSwitchUInt(/*NO_COPY*/CPU).Case(/*KEEP_STR*/"cortex-a35", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a53", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a57", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a72", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cortex-a73", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"cyclone", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"exynos-m1", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"kryo", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      Case(/*KEEP_STR*/"vulcan", FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue()).
      // Invalid CPU
      Case(/*KEEP_STR*/"invalid", FPUKind.FK_INVALID.getValue()).
      Default(ARM.FPUKind.FK_INVALID.getValue());
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getDefaultExtensions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 413,
 FQN="llvm::AArch64::getDefaultExtensions", NM="_ZN4llvm7AArch6420getDefaultExtensionsENS_9StringRefEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6420getDefaultExtensionsENS_9StringRefEj")
//</editor-fold>
public static /*uint*/int getDefaultExtensions(StringRef CPU, /*uint*/int _ArchKind) {
  if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"generic")) {
    return AArch64ARCHNames[_ArchKind].ArchBaseExtensions;
  }
  
  return new StringSwitchUInt(/*NO_COPY*/CPU).Case(/*KEEP_STR*/"cortex-a35", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"cortex-a53", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"cortex-a57", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"cortex-a72", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"cortex-a73", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"cyclone", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"exynos-m1", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"kryo", AArch64ARCHNames[ArchKind.AK_ARMV8A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      Case(/*KEEP_STR*/"vulcan", AArch64ARCHNames[ArchKind.AK_ARMV8_1A.getValue()].ArchBaseExtensions | (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)).
      // Invalid CPU
      Case(/*KEEP_STR*/"invalid", AArch64ARCHNames[ArchKind.AK_INVALID.getValue()].ArchBaseExtensions | AArch64.ArchExtKind.AEK_INVALID).
      Default(AArch64.ArchExtKind.AEK_INVALID);
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::getDefaultCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 516,
 FQN="llvm::AArch64::getDefaultCPU", NM="_ZN4llvm7AArch6413getDefaultCPUENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6413getDefaultCPUENS_9StringRefE")
//</editor-fold>
public static StringRef getDefaultCPU(StringRef Arch) {
  /*uint*/int AK = parseArch(new StringRef(Arch));
  if (AK == ARM.ArchKind.AK_INVALID.getValue()) {
    return new StringRef();
  }
  
  // Look for multiple AKs to find the default for pair AK+Name.
  for (Unnamed_struct4 CPU : AArch64CPUNames)  {
    if (CPU.ArchID.getValue() == AK && CPU.Default) {
      return CPU.getName();
    }
  }
  
  // If we can't find a default then target the architecture instead
  return new StringRef(/*KEEP_STR*/$generic);
}


// Parser
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseFPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 779,
 FQN="llvm::AArch64::parseFPU", NM="_ZN4llvm7AArch648parseFPUENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch648parseFPUENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseFPU(StringRef FPU) {
  return ARM.parseFPU(/*NO_COPY*/FPU);
}


// Allows partial match, ex. "v8a" matches "armv8a".
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 784,
 FQN="llvm::AArch64::parseArch", NM="_ZN4llvm7AArch649parseArchENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch649parseArchENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArch(StringRef Arch) {
  Arch.$assignMove(getCanonicalArchName(new StringRef(Arch)));
  if ($less_uint(checkArchVersion(new StringRef(Arch)), 8)) {
    return ARM.ArchKind.AK_INVALID.getValue();
  }
  
  StringRef Syn = getArchSynonym(new StringRef(Arch));
  for (Unnamed_struct1 A : AArch64ARCHNames) {
    if (A.getName().endswith(/*NO_COPY*/Syn)) {
      return A.ID.getValue();
    }
  }
  return ARM.ArchKind.AK_INVALID.getValue();
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseArchExt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 797,
 FQN="llvm::AArch64::parseArchExt", NM="_ZN4llvm7AArch6412parseArchExtENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6412parseArchExtENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchExt(StringRef ArchExt) {
  for (Unnamed_struct2 A : AArch64ARCHExtNames) {
    if ($eq_StringRef(/*NO_COPY*/ArchExt, A.getName())) {
      return A.ID;
    }
  }
  return AArch64.ArchExtKind.AEK_INVALID;
}

//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseCPUArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 805,
 FQN="llvm::AArch64::parseCPUArch", NM="_ZN4llvm7AArch6412parseCPUArchENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6412parseCPUArchENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseCPUArch(StringRef CPU) {
  for (Unnamed_struct4 C : AArch64CPUNames) {
    if ($eq_StringRef(/*NO_COPY*/CPU, C.getName())) {
      return C.ArchID.getValue();
    }
  }
  return ARM.ArchKind.AK_INVALID.getValue();
}


// ARM, Thumb, AArch64
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseArchISA">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 814,
 FQN="llvm::AArch64::parseArchISA", NM="_ZN4llvm7AArch6412parseArchISAENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6412parseArchISAENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchISA(StringRef Arch) {
  return ARM.parseArchISA(/*NO_COPY*/Arch);
}


// Little/Big endian
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseArchEndian">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 819,
 FQN="llvm::AArch64::parseArchEndian", NM="_ZN4llvm7AArch6415parseArchEndianENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6415parseArchEndianENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchEndian(StringRef Arch) {
  return ARM.parseArchEndian(/*NO_COPY*/Arch);
}


// Profile A/R/M
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseArchProfile">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 824,
 FQN="llvm::AArch64::parseArchProfile", NM="_ZN4llvm7AArch6416parseArchProfileENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6416parseArchProfileENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchProfile(StringRef Arch) {
  return ARM.parseArchProfile(/*NO_COPY*/Arch);
}


// Version number (ex. v8 = 8).
//<editor-fold defaultstate="collapsed" desc="llvm::AArch64::parseArchVersion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 829,
 FQN="llvm::AArch64::parseArchVersion", NM="_ZN4llvm7AArch6416parseArchVersionENS_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN4llvm7AArch6416parseArchVersionENS_9StringRefE")
//</editor-fold>
public static /*uint*/int parseArchVersion(StringRef Arch) {
  return ARM.parseArchVersion(/*NO_COPY*/Arch);
}

} // END OF class AArch64
