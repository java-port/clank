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
package org.llvm.support.target.impl;

import org.llvm.support.target.ARM;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.support.target.ARM.*;
import org.llvm.support.target.AArch64;


//<editor-fold defaultstate="collapsed" desc="static type TargetParserStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_Unnamed_struct;_Unnamed_struct1;_Unnamed_struct2;_Unnamed_struct3;_Unnamed_struct4;_ZL13getFPUSynonymN4llvm9StringRefE;_ZL14getArchSynonymN4llvm9StringRefE;_ZL15getHWDivSynonymN4llvm9StringRefE;_ZN12_GLOBAL__N_1L10HWDivNamesE;_ZN12_GLOBAL__N_1L12ARCHExtNamesE;_ZN12_GLOBAL__N_1L15AArch64CPUNamesE;_ZN12_GLOBAL__N_1L16AArch64ARCHNamesE;_ZN12_GLOBAL__N_1L19AArch64ARCHExtNamesE;_ZN12_GLOBAL__N_1L8CPUNamesE;_ZN12_GLOBAL__N_1L8FPUNamesE;_ZN12_GLOBAL__N_1L9ARCHNamesE; -static-type=TargetParserStatics -package=org.llvm.support.target.impl")
//</editor-fold>
public final class TargetParserStatics {


// List of canonical FPU names (use getFPUSynonym) and which architectural
// features they correspond to (use getFPUFeatures).
// FIXME: TableGen this.
// The entries must appear in the order listed in ARM::FPUKind for correct indexing
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 32,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
 FQN="(anonymous namespace)::(anonymous)", NM="_Unnamed_struct",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_Unnamed_struct")
//</editor-fold>
public static class/*struct*/ Unnamed_struct {
  public /*const*/char$ptr/*char P*/ NameCStr;
  public /*size_t*/int NameLength;
  public ARM.FPUKind ID;
  public ARM.FPUVersion FPUVersion;
  public ARM.NeonSupportLevel NeonSupport;
  public ARM.FPURestriction Restriction;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Unnamed_struct(char$ptr NameCStr, int NameLength, FPUKind ID, FPUVersion FPUVersion, NeonSupportLevel NeonSupport, FPURestriction Restriction) {
    this.NameCStr = NameCStr;
    this.NameLength = NameLength;
    this.ID = ID;
    this.FPUVersion = FPUVersion;
    this.NeonSupport = NeonSupport;
    this.Restriction = Restriction;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 40,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 39,
   FQN="(anonymous namespace)::(anonymous struct)::getName", NM="_ZNK12_GLOBAL__N_13$_07getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_07getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(NameCStr, NameLength);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 32,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
   FQN="(anonymous namespace)::(anonymous struct)::", NM="_ZN12_GLOBAL__N_13$_0C1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_13$_0C1ERKS0_")
  //</editor-fold>
  public /*inline*/ Unnamed_struct(Unnamed_struct $Prm0) {
    // : NameCStr(.NameCStr), NameLength(.NameLength), ID(.ID), FPUVersion(.FPUVersion), NeonSupport(.NeonSupport), Restriction(.Restriction) 
    //START JInit
    this.NameCStr = $tryClone($Prm0.NameCStr);
    this.NameLength = $Prm0.NameLength;
    this.ID = $Prm0.ID;
    this.FPUVersion = $Prm0.FPUVersion;
    this.NeonSupport = $Prm0.NeonSupport;
    this.Restriction = $Prm0.Restriction;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "NameCStr=" + NameCStr // NOI18N
              + ", NameLength=" + NameLength // NOI18N
              + ", ID=" + ID // NOI18N
              + ", FPUVersion=" + FPUVersion // NOI18N
              + ", NeonSupport=" + NeonSupport // NOI18N
              + ", Restriction=" + Restriction; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FPUNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 32,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
 FQN="(anonymous namespace)::FPUNames", NM="_ZN12_GLOBAL__N_1L8FPUNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L8FPUNamesE")
//</editor-fold>
public static Unnamed_struct FPUNames[/*22*/] = new Unnamed_struct[/*22*/] {
  new Unnamed_struct($("invalid"), sizeof$str("invalid") - 1, FPUKind.FK_INVALID, FPUVersion.FV_NONE, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("none"), sizeof$str("none") - 1, FPUKind.FK_NONE, FPUVersion.FV_NONE, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("vfp"), sizeof$str("vfp") - 1, FPUKind.FK_VFP, FPUVersion.FV_VFPV2, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("vfpv2"), sizeof$str("vfpv2") - 1, FPUKind.FK_VFPV2, FPUVersion.FV_VFPV2, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("vfpv3"), sizeof$str("vfpv3") - 1, FPUKind.FK_VFPV3, FPUVersion.FV_VFPV3, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("vfpv3-fp16"), sizeof$str("vfpv3-fp16") - 1, FPUKind.FK_VFPV3_FP16, FPUVersion.FV_VFPV3_FP16, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("vfpv3-d16"), sizeof$str("vfpv3-d16") - 1, FPUKind.FK_VFPV3_D16, FPUVersion.FV_VFPV3, NeonSupportLevel.NS_None, FPURestriction.FR_D16), 
  new Unnamed_struct($("vfpv3-d16-fp16"), sizeof$str("vfpv3-d16-fp16") - 1, FPUKind.FK_VFPV3_D16_FP16, FPUVersion.FV_VFPV3_FP16, NeonSupportLevel.NS_None, FPURestriction.FR_D16), 
  new Unnamed_struct($("vfpv3xd"), sizeof$str("vfpv3xd") - 1, FPUKind.FK_VFPV3XD, FPUVersion.FV_VFPV3, NeonSupportLevel.NS_None, FPURestriction.FR_SP_D16), 
  new Unnamed_struct($("vfpv3xd-fp16"), sizeof$str("vfpv3xd-fp16") - 1, FPUKind.FK_VFPV3XD_FP16, FPUVersion.FV_VFPV3_FP16, NeonSupportLevel.NS_None, FPURestriction.FR_SP_D16), 
  new Unnamed_struct($("vfpv4"), sizeof$str("vfpv4") - 1, FPUKind.FK_VFPV4, FPUVersion.FV_VFPV4, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("vfpv4-d16"), sizeof$str("vfpv4-d16") - 1, FPUKind.FK_VFPV4_D16, FPUVersion.FV_VFPV4, NeonSupportLevel.NS_None, FPURestriction.FR_D16), 
  new Unnamed_struct($("fpv4-sp-d16"), sizeof$str("fpv4-sp-d16") - 1, FPUKind.FK_FPV4_SP_D16, FPUVersion.FV_VFPV4, NeonSupportLevel.NS_None, FPURestriction.FR_SP_D16), 
  new Unnamed_struct($("fpv5-d16"), sizeof$str("fpv5-d16") - 1, FPUKind.FK_FPV5_D16, FPUVersion.FV_VFPV5, NeonSupportLevel.NS_None, FPURestriction.FR_D16), 
  new Unnamed_struct($("fpv5-sp-d16"), sizeof$str("fpv5-sp-d16") - 1, FPUKind.FK_FPV5_SP_D16, FPUVersion.FV_VFPV5, NeonSupportLevel.NS_None, FPURestriction.FR_SP_D16), 
  new Unnamed_struct($("fp-armv8"), sizeof$str("fp-armv8") - 1, FPUKind.FK_FP_ARMV8, FPUVersion.FV_VFPV5, NeonSupportLevel.NS_None, FPURestriction.FR_None), 
  new Unnamed_struct($("neon"), sizeof$str("neon") - 1, FPUKind.FK_NEON, FPUVersion.FV_VFPV3, NeonSupportLevel.NS_Neon, FPURestriction.FR_None), 
  new Unnamed_struct($("neon-fp16"), sizeof$str("neon-fp16") - 1, FPUKind.FK_NEON_FP16, FPUVersion.FV_VFPV3_FP16, NeonSupportLevel.NS_Neon, FPURestriction.FR_None), 
  new Unnamed_struct($("neon-vfpv4"), sizeof$str("neon-vfpv4") - 1, FPUKind.FK_NEON_VFPV4, FPUVersion.FV_VFPV4, NeonSupportLevel.NS_Neon, FPURestriction.FR_None), 
  new Unnamed_struct($("neon-fp-armv8"), sizeof$str("neon-fp-armv8") - 1, FPUKind.FK_NEON_FP_ARMV8, FPUVersion.FV_VFPV5, NeonSupportLevel.NS_Neon, FPURestriction.FR_None), 
  new Unnamed_struct($("crypto-neon-fp-armv8"), sizeof$str("crypto-neon-fp-armv8") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8, FPUVersion.FV_VFPV5, NeonSupportLevel.NS_Crypto, FPURestriction.FR_None), 
  new Unnamed_struct($("softvfp"), sizeof$str("softvfp") - 1, FPUKind.FK_SOFTVFP, FPUVersion.FV_NONE, NeonSupportLevel.NS_None, FPURestriction.FR_None)
};

// List of canonical arch names (use getArchSynonym).
// This table also provides the build attribute fields for CPU arch
// and Arch ID, according to the Addenda to the ARM ABI, chapters
// 2.4 and 2.3.5.2 respectively.
// FIXME: SubArch values were simplified to fit into the expectations
// of the triples and are not conforming with their official names.
// Check to see if the expectation should be changed.
// FIXME: TableGen this.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 55,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 54,
 FQN="(anonymous namespace)::(anonymous)", NM="_Unnamed_struct1",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_Unnamed_struct1")
//</editor-fold>
public static class/*struct*/ Unnamed_struct1 {
  public /*const*/char$ptr/*char P*/ NameCStr;
  public /*size_t*/int NameLength;
  public /*const*/char$ptr/*char P*/ CPUAttrCStr;
  public /*size_t*/int CPUAttrLength;
  public /*const*/char$ptr/*char P*/ SubArchCStr;
  public /*size_t*/int SubArchLength;
  public /*uint*/int DefaultFPU;
  public /*uint*/int ArchBaseExtensions;
  public ARM.ArchKind ID;
  public ARMBuildAttrs.CPUArch ArchAttr; // Arch ID in build attributes.
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Unnamed_struct1(char$ptr NameCStr, int NameLength, char$ptr CPUAttrCStr, int CPUAttrLength, char$ptr SubArchCStr, int SubArchLength, int DefaultFPU, int ArchBaseExtensions, ArchKind ID, ARMBuildAttrs.CPUArch ArchAttr) {
    this.NameCStr = NameCStr;
    this.NameLength = NameLength;
    this.CPUAttrCStr = CPUAttrCStr;
    this.CPUAttrLength = CPUAttrLength;
    this.SubArchCStr = SubArchCStr;
    this.SubArchLength = SubArchLength;
    this.DefaultFPU = DefaultFPU;
    this.ArchBaseExtensions = ArchBaseExtensions;
    this.ID = ID;
    this.ArchAttr = ArchAttr;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 67,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 39,
   FQN="(anonymous namespace)::(anonymous struct)::getName", NM="_ZNK12_GLOBAL__N_13$_07getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_07getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(NameCStr, NameLength);
  }

  
  // CPU class in build attributes.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getCPUAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 70,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 69,
   FQN="(anonymous namespace)::(anonymous struct)::getCPUAttr", NM="_ZNK12_GLOBAL__N_13$_010getCPUAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_010getCPUAttrEv")
  //</editor-fold>
  public StringRef getCPUAttr() /*const*/ {
    return new StringRef(CPUAttrCStr, CPUAttrLength);
  }

  
  // Sub-Arch name.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getSubArch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 73,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 72,
   FQN="(anonymous namespace)::(anonymous struct)::getSubArch", NM="_ZNK12_GLOBAL__N_13$_010getSubArchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_010getSubArchEv")
  //</editor-fold>
  public StringRef getSubArch() /*const*/ {
    return new StringRef(SubArchCStr, SubArchLength);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 55,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
   FQN="(anonymous namespace)::(anonymous struct)::", NM="_ZN12_GLOBAL__N_13$_0C1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_13$_0C1ERKS0_")
  //</editor-fold>
  public /*inline*/ Unnamed_struct1(Unnamed_struct1 $Prm0) {
    // : NameCStr(.NameCStr), NameLength(.NameLength), CPUAttrCStr(.CPUAttrCStr), CPUAttrLength(.CPUAttrLength), SubArchCStr(.SubArchCStr), SubArchLength(.SubArchLength), DefaultFPU(.DefaultFPU), ArchBaseExtensions(.ArchBaseExtensions), ID(.ID), ArchAttr(.ArchAttr) 
    //START JInit
    this.NameCStr = $tryClone($Prm0.NameCStr);
    this.NameLength = $Prm0.NameLength;
    this.CPUAttrCStr = $tryClone($Prm0.CPUAttrCStr);
    this.CPUAttrLength = $Prm0.CPUAttrLength;
    this.SubArchCStr = $tryClone($Prm0.SubArchCStr);
    this.SubArchLength = $Prm0.SubArchLength;
    this.DefaultFPU = $Prm0.DefaultFPU;
    this.ArchBaseExtensions = $Prm0.ArchBaseExtensions;
    this.ID = $Prm0.ID;
    this.ArchAttr = $Prm0.ArchAttr;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "NameCStr=" + NameCStr // NOI18N
              + ", NameLength=" + NameLength // NOI18N
              + ", CPUAttrCStr=" + CPUAttrCStr // NOI18N
              + ", CPUAttrLength=" + CPUAttrLength // NOI18N
              + ", SubArchCStr=" + SubArchCStr // NOI18N
              + ", SubArchLength=" + SubArchLength // NOI18N
              + ", DefaultFPU=" + DefaultFPU // NOI18N
              + ", ArchBaseExtensions=" + ArchBaseExtensions // NOI18N
              + ", ID=" + ID // NOI18N
              + ", ArchAttr=" + ArchAttr; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCHNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 55,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 54,
 FQN="(anonymous namespace)::ARCHNames", NM="_ZN12_GLOBAL__N_1L9ARCHNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L9ARCHNamesE")
//</editor-fold>
public static Unnamed_struct1 ARCHNames[/*29*/] = new Unnamed_struct1[/*29*/] {
  new Unnamed_struct1($("invalid"), sizeof$str("invalid") - 1, (/*const*/char$ptr/*char P*/ )null, sizeof$null(null) - 1, (/*const*/char$ptr/*char P*/ )null, sizeof$null(null) - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_INVALID, ARMBuildAttrs.CPUArch.Pre_v4), 
  new Unnamed_struct1($("armv2"), sizeof$str("armv2") - 1, $2, sizeof$str("2") - 1, $("v2"), sizeof$str("v2") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV2, ARMBuildAttrs.CPUArch.Pre_v4), 
  new Unnamed_struct1($("armv2a"), sizeof$str("armv2a") - 1, $("2A"), sizeof$str("2A") - 1, $("v2a"), sizeof$str("v2a") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV2A, ARMBuildAttrs.CPUArch.Pre_v4), 
  new Unnamed_struct1($("armv3"), sizeof$str("armv3") - 1, $3, sizeof$str("3") - 1, $("v3"), sizeof$str("v3") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV3, ARMBuildAttrs.CPUArch.Pre_v4), 
  new Unnamed_struct1($("armv3m"), sizeof$str("armv3m") - 1, $("3M"), sizeof$str("3M") - 1, $("v3m"), sizeof$str("v3m") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV3M, ARMBuildAttrs.CPUArch.Pre_v4), 
  new Unnamed_struct1($("armv4"), sizeof$str("armv4") - 1, $4, sizeof$str("4") - 1, $("v4"), sizeof$str("v4") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV4, ARMBuildAttrs.CPUArch.v4), 
  new Unnamed_struct1($("armv4t"), sizeof$str("armv4t") - 1, $("4T"), sizeof$str("4T") - 1, $("v4t"), sizeof$str("v4t") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV4T, ARMBuildAttrs.CPUArch.v4T), 
  new Unnamed_struct1($("armv5t"), sizeof$str("armv5t") - 1, $("5T"), sizeof$str("5T") - 1, $("v5"), sizeof$str("v5") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV5T, ARMBuildAttrs.CPUArch.v5T), 
  new Unnamed_struct1($("armv5te"), sizeof$str("armv5te") - 1, $("5TE"), sizeof$str("5TE") - 1, $("v5e"), sizeof$str("v5e") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV5TE, ARMBuildAttrs.CPUArch.v5TE), 
  new Unnamed_struct1($("armv5tej"), sizeof$str("armv5tej") - 1, $("5TEJ"), sizeof$str("5TEJ") - 1, $("v5e"), sizeof$str("v5e") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV5TEJ, ARMBuildAttrs.CPUArch.v5TEJ), 
  new Unnamed_struct1($("armv6"), sizeof$str("armv6") - 1, $6, sizeof$str("6") - 1, $("v6"), sizeof$str("v6") - 1, FPUKind.FK_VFPV2.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV6, ARMBuildAttrs.CPUArch.v6), 
  new Unnamed_struct1($("armv6k"), sizeof$str("armv6k") - 1, $("6K"), sizeof$str("6K") - 1, $("v6k"), sizeof$str("v6k") - 1, FPUKind.FK_VFPV2.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV6K, ARMBuildAttrs.CPUArch.v6K), 
  new Unnamed_struct1($("armv6t2"), sizeof$str("armv6t2") - 1, $("6T2"), sizeof$str("6T2") - 1, $("v6t2"), sizeof$str("v6t2") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV6T2, ARMBuildAttrs.CPUArch.v6T2), 
  new Unnamed_struct1($("armv6kz"), sizeof$str("armv6kz") - 1, $("6KZ"), sizeof$str("6KZ") - 1, $("v6kz"), sizeof$str("v6kz") - 1, FPUKind.FK_VFPV2.getValue(), (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_DSP), ArchKind.AK_ARMV6KZ, ARMBuildAttrs.CPUArch.v6KZ), 
  new Unnamed_struct1($("armv6-m"), sizeof$str("armv6-m") - 1, $("6-M"), sizeof$str("6-M") - 1, $("v6m"), sizeof$str("v6m") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_ARMV6M, ARMBuildAttrs.CPUArch.v6_M), 
  new Unnamed_struct1($("armv7-a"), sizeof$str("armv7-a") - 1, $("7-A"), sizeof$str("7-A") - 1, $("v7"), sizeof$str("v7") - 1, FPUKind.FK_NEON.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV7A, ARMBuildAttrs.CPUArch.v7), 
  new Unnamed_struct1($("armv7-r"), sizeof$str("armv7-r") - 1, $("7-R"), sizeof$str("7-R") - 1, $("v7r"), sizeof$str("v7r") - 1, FPUKind.FK_NONE.getValue(), (ARM.ArchExtKind.AEK_HWDIV | ARM.ArchExtKind.AEK_DSP), ArchKind.AK_ARMV7R, ARMBuildAttrs.CPUArch.v7), 
  new Unnamed_struct1($("armv7-m"), sizeof$str("armv7-m") - 1, $("7-M"), sizeof$str("7-M") - 1, $("v7m"), sizeof$str("v7m") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_HWDIV, ArchKind.AK_ARMV7M, ARMBuildAttrs.CPUArch.v7), 
  new Unnamed_struct1($("armv7e-m"), sizeof$str("armv7e-m") - 1, $("7E-M"), sizeof$str("7E-M") - 1, $("v7em"), sizeof$str("v7em") - 1, FPUKind.FK_NONE.getValue(), (ARM.ArchExtKind.AEK_HWDIV | ARM.ArchExtKind.AEK_DSP), ArchKind.AK_ARMV7EM, ARMBuildAttrs.CPUArch.v7E_M), 
  new Unnamed_struct1($("armv8-a"), sizeof$str("armv8-a") - 1, $("8-A"), sizeof$str("8-A") - 1, $("v8"), sizeof$str("v8") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue(), (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV | ARM.ArchExtKind.AEK_DSP | ARM.ArchExtKind.AEK_CRC), ArchKind.AK_ARMV8A, ARMBuildAttrs.CPUArch.v8_A), 
  new Unnamed_struct1($("armv8.1-a"), sizeof$str("armv8.1-a") - 1, $("8.1-A"), sizeof$str("8.1-A") - 1, $("v8.1a"), sizeof$str("v8.1a") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue(), (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV | ARM.ArchExtKind.AEK_DSP | ARM.ArchExtKind.AEK_CRC | ARM.ArchExtKind.AEK_RAS), ArchKind.AK_ARMV8_1A, ARMBuildAttrs.CPUArch.v8_A), 
  new Unnamed_struct1($("armv8.2-a"), sizeof$str("armv8.2-a") - 1, $("8.2-A"), sizeof$str("8.2-A") - 1, $("v8.2a"), sizeof$str("v8.2a") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue(), (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV | ARM.ArchExtKind.AEK_DSP | ARM.ArchExtKind.AEK_CRC), ArchKind.AK_ARMV8_2A, ARMBuildAttrs.CPUArch.v8_A), 
  new Unnamed_struct1($("armv8-m.base"), sizeof$str("armv8-m.base") - 1, $("8-M.Baseline"), sizeof$str("8-M.Baseline") - 1, $("v8m.base"), sizeof$str("v8m.base") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_HWDIV, ArchKind.AK_ARMV8MBaseline, ARMBuildAttrs.CPUArch.v8_M_Base), 
  new Unnamed_struct1($("armv8-m.main"), sizeof$str("armv8-m.main") - 1, $("8-M.Mainline"), sizeof$str("8-M.Mainline") - 1, $("v8m.main"), sizeof$str("v8m.main") - 1, FPUKind.FK_FPV5_D16.getValue(), ARM.ArchExtKind.AEK_HWDIV, ArchKind.AK_ARMV8MMainline, ARMBuildAttrs.CPUArch.v8_M_Main), 
  // Non-standard Arch names.
  new Unnamed_struct1($("iwmmxt"), sizeof$str("iwmmxt") - 1, $("iwmmxt"), sizeof$str("iwmmxt") - 1, $EMPTY, sizeof$str("") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_IWMMXT, ARMBuildAttrs.CPUArch.v5TE), 
  new Unnamed_struct1($("iwmmxt2"), sizeof$str("iwmmxt2") - 1, $("iwmmxt2"), sizeof$str("iwmmxt2") - 1, $EMPTY, sizeof$str("") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_IWMMXT2, ARMBuildAttrs.CPUArch.v5TE), 
  new Unnamed_struct1($("xscale"), sizeof$str("xscale") - 1, $("xscale"), sizeof$str("xscale") - 1, $("v5e"), sizeof$str("v5e") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_NONE, ArchKind.AK_XSCALE, ARMBuildAttrs.CPUArch.v5TE), 
  new Unnamed_struct1($("armv7s"), sizeof$str("armv7s") - 1, $("7-S"), sizeof$str("7-S") - 1, $("v7s"), sizeof$str("v7s") - 1, FPUKind.FK_NEON_VFPV4.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV7S, ARMBuildAttrs.CPUArch.v7), 
  new Unnamed_struct1($("armv7k"), sizeof$str("armv7k") - 1, $("7-K"), sizeof$str("7-K") - 1, $("v7k"), sizeof$str("v7k") - 1, FPUKind.FK_NONE.getValue(), ARM.ArchExtKind.AEK_DSP, ArchKind.AK_ARMV7K, ARMBuildAttrs.CPUArch.v7)
};
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ARCHNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 55,
 FQN="(anonymous namespace)::AArch64ARCHNames", NM="_ZN12_GLOBAL__N_1L16AArch64ARCHNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L16AArch64ARCHNamesE")
//</editor-fold>
public static Unnamed_struct1 AArch64ARCHNames[/*3*/] = new Unnamed_struct1[/*3*/] {
  new Unnamed_struct1($("armv8-a"), sizeof$str("armv8-a") - 1, $("8-A"), sizeof$str("8-A") - 1, $("v8"), sizeof$str("v8") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue(), (AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO | AArch64.ArchExtKind.AEK_FP | AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_FP16 | AArch64.ArchExtKind.AEK_PROFILE), ArchKind.AK_ARMV8A, ARMBuildAttrs.CPUArch.v8_A), 
  new Unnamed_struct1($("armv8.1-a"), sizeof$str("armv8.1-a") - 1, $("8.1-A"), sizeof$str("8.1-A") - 1, $("v8.1a"), sizeof$str("v8.1a") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue(), (AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO | AArch64.ArchExtKind.AEK_FP | AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_FP16 | AArch64.ArchExtKind.AEK_PROFILE), ArchKind.AK_ARMV8_1A, ARMBuildAttrs.CPUArch.v8_A), 
  new Unnamed_struct1($("armv8.2-a"), sizeof$str("armv8.2-a") - 1, $("8.2-A"), sizeof$str("8.2-A") - 1, $("v8.2a"), sizeof$str("v8.2a") - 1, FPUKind.FK_CRYPTO_NEON_FP_ARMV8.getValue(), (AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO | AArch64.ArchExtKind.AEK_FP | AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_FP16 | AArch64.ArchExtKind.AEK_PROFILE | AArch64.ArchExtKind.AEK_RAS), ArchKind.AK_ARMV8_2A, ARMBuildAttrs.CPUArch.v8_A)
};

// List of Arch Extension names.
// FIXME: TableGen this.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 88,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 82,
 FQN="(anonymous namespace)::(anonymous)", NM="_Unnamed_struct2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_Unnamed_struct2")
//</editor-fold>
public static class/*struct*/ Unnamed_struct2 {
  public /*const*/char$ptr/*char P*/ NameCStr;
  public /*size_t*/int NameLength;
  public /*uint*/int ID;
  public /*const*/char$ptr/*char P*/ Feature;
  public /*const*/char$ptr/*char P*/ NegFeature;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Unnamed_struct2(char$ptr NameCStr, int NameLength, int ID, char$ptr Feature, char$ptr NegFeature) {
    this.NameCStr = NameCStr;
    this.NameLength = NameLength;
    this.ID = ID;
    this.Feature = Feature;
    this.NegFeature = NegFeature;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 95,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 39,
   FQN="(anonymous namespace)::(anonymous struct)::getName", NM="_ZNK12_GLOBAL__N_13$_07getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_07getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(NameCStr, NameLength);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 88,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
   FQN="(anonymous namespace)::(anonymous struct)::", NM="_ZN12_GLOBAL__N_13$_0C1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_13$_0C1ERKS0_")
  //</editor-fold>
  public /*inline*/ Unnamed_struct2(Unnamed_struct2 $Prm0) {
    // : NameCStr(.NameCStr), NameLength(.NameLength), ID(.ID), Feature(.Feature), NegFeature(.NegFeature) 
    //START JInit
    this.NameCStr = $tryClone($Prm0.NameCStr);
    this.NameLength = $Prm0.NameLength;
    this.ID = $Prm0.ID;
    this.Feature = $tryClone($Prm0.Feature);
    this.NegFeature = $tryClone($Prm0.NegFeature);
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "NameCStr=" + NameCStr // NOI18N
              + ", NameLength=" + NameLength // NOI18N
              + ", ID=" + ID // NOI18N
              + ", Feature=" + Feature // NOI18N
              + ", NegFeature=" + NegFeature; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARCHExtNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 88,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 82,
 FQN="(anonymous namespace)::ARCHExtNames", NM="_ZN12_GLOBAL__N_1L12ARCHExtNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L12ARCHExtNamesE")
//</editor-fold>
public static Unnamed_struct2 ARCHExtNames[/*18*/] = new Unnamed_struct2[/*18*/] {
  // FIXME: This would be nicer were it tablegen
  new Unnamed_struct2($("invalid"), sizeof$str("invalid") - 1, ARM.ArchExtKind.AEK_INVALID, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("none"), sizeof$str("none") - 1, ARM.ArchExtKind.AEK_NONE, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("crc"), sizeof$str("crc") - 1, ARM.ArchExtKind.AEK_CRC, $("+crc"), $("-crc")), 
  new Unnamed_struct2($("crypto"), sizeof$str("crypto") - 1, ARM.ArchExtKind.AEK_CRYPTO, $("+crypto"), $("-crypto")), 
  new Unnamed_struct2($("dsp"), sizeof$str("dsp") - 1, ARM.ArchExtKind.AEK_DSP, $("+dsp"), $("-dsp")), 
  new Unnamed_struct2($("fp"), sizeof$str("fp") - 1, ARM.ArchExtKind.AEK_FP, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("idiv"), sizeof$str("idiv") - 1, (ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV), (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("mp"), sizeof$str("mp") - 1, ARM.ArchExtKind.AEK_MP, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("simd"), sizeof$str("simd") - 1, ARM.ArchExtKind.AEK_SIMD, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("sec"), sizeof$str("sec") - 1, ARM.ArchExtKind.AEK_SEC, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("virt"), sizeof$str("virt") - 1, ARM.ArchExtKind.AEK_VIRT, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("fp16"), sizeof$str("fp16") - 1, ARM.ArchExtKind.AEK_FP16, $("+fullfp16"), $("-fullfp16")), 
  new Unnamed_struct2($("ras"), sizeof$str("ras") - 1, ARM.ArchExtKind.AEK_RAS, $("+ras"), $("-ras")), 
  new Unnamed_struct2($("os"), sizeof$str("os") - 1, ARM.ArchExtKind.AEK_OS, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("iwmmxt"), sizeof$str("iwmmxt") - 1, ARM.ArchExtKind.AEK_IWMMXT, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("iwmmxt2"), sizeof$str("iwmmxt2") - 1, ARM.ArchExtKind.AEK_IWMMXT2, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("maverick"), sizeof$str("maverick") - 1, ARM.ArchExtKind.AEK_MAVERICK, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("xscale"), sizeof$str("xscale") - 1, ARM.ArchExtKind.AEK_XSCALE, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null)
};
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64ARCHExtNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 88,
 FQN="(anonymous namespace)::AArch64ARCHExtNames", NM="_ZN12_GLOBAL__N_1L19AArch64ARCHExtNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L19AArch64ARCHExtNamesE")
//</editor-fold>
public static Unnamed_struct2 AArch64ARCHExtNames[/*9*/] = new Unnamed_struct2[/*9*/] {
  // FIXME: This would be nicer were it tablegen
  new Unnamed_struct2($("invalid"), sizeof$str("invalid") - 1, AArch64.ArchExtKind.AEK_INVALID, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("none"), sizeof$str("none") - 1, AArch64.ArchExtKind.AEK_NONE, (/*const*/char$ptr/*char P*/ )null, (/*const*/char$ptr/*char P*/ )null), 
  new Unnamed_struct2($("crc"), sizeof$str("crc") - 1, AArch64.ArchExtKind.AEK_CRC, $("+crc"), $("-crc")), 
  new Unnamed_struct2($("crypto"), sizeof$str("crypto") - 1, AArch64.ArchExtKind.AEK_CRYPTO, $("+crypto"), $("-crypto")), 
  new Unnamed_struct2($("fp"), sizeof$str("fp") - 1, AArch64.ArchExtKind.AEK_FP, $("+fp-armv8"), $("-fp-armv8")), 
  new Unnamed_struct2($("simd"), sizeof$str("simd") - 1, AArch64.ArchExtKind.AEK_SIMD, $("+neon"), $("-neon")), 
  new Unnamed_struct2($("fp16"), sizeof$str("fp16") - 1, AArch64.ArchExtKind.AEK_FP16, $("+fullfp16"), $("-fullfp16")), 
  new Unnamed_struct2($("profile"), sizeof$str("profile") - 1, AArch64.ArchExtKind.AEK_PROFILE, $("+spe"), $("-spe")), 
  new Unnamed_struct2($("ras"), sizeof$str("ras") - 1, AArch64.ArchExtKind.AEK_RAS, $("+ras"), $("-ras"))
};

// List of HWDiv names (use getHWDivSynonym) and which architectural
// features they correspond to (use getHWDivFeatures).
// FIXME: TableGen this.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 109,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 99,
 FQN="(anonymous namespace)::(anonymous)", NM="_Unnamed_struct3",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_Unnamed_struct3")
//</editor-fold>
public static class/*struct*/ Unnamed_struct3 {
  public /*const*/char$ptr/*char P*/ NameCStr;
  public /*size_t*/int NameLength;
  public /*uint*/int ID;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Unnamed_struct3(char$ptr NameCStr, int NameLength, int ID) {
    this.NameCStr = NameCStr;
    this.NameLength = NameLength;
    this.ID = ID;
  }
  
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 114,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 39,
   FQN="(anonymous namespace)::(anonymous struct)::getName", NM="_ZNK12_GLOBAL__N_13$_07getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_07getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(NameCStr, NameLength);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 109,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
   FQN="(anonymous namespace)::(anonymous struct)::", NM="_ZN12_GLOBAL__N_13$_0C1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_13$_0C1ERKS0_")
  //</editor-fold>
  public /*inline*/ Unnamed_struct3(Unnamed_struct3 $Prm0) {
    // : NameCStr(.NameCStr), NameLength(.NameLength), ID(.ID) 
    //START JInit
    this.NameCStr = $tryClone($Prm0.NameCStr);
    this.NameLength = $Prm0.NameLength;
    this.ID = $Prm0.ID;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "NameCStr=" + NameCStr // NOI18N
              + ", NameLength=" + NameLength // NOI18N
              + ", ID=" + ID; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::HWDivNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 109,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 99,
 FQN="(anonymous namespace)::HWDivNames", NM="_ZN12_GLOBAL__N_1L10HWDivNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L10HWDivNamesE")
//</editor-fold>
public static Unnamed_struct3 HWDivNames[/*5*/] = new Unnamed_struct3[/*5*/] {
  new Unnamed_struct3($("invalid"), sizeof$str("invalid") - 1, ARM.ArchExtKind.AEK_INVALID), 
  new Unnamed_struct3($("none"), sizeof$str("none") - 1, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct3($("thumb"), sizeof$str("thumb") - 1, ARM.ArchExtKind.AEK_HWDIV), 
  new Unnamed_struct3($("arm"), sizeof$str("arm") - 1, ARM.ArchExtKind.AEK_HWDIVARM), 
  new Unnamed_struct3($("arm,thumb"), sizeof$str("arm,thumb") - 1, (ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV))
};

// List of CPU names and their arches.
// The same CPU can have multiple arches and can be default on multiple arches.
// When finding the Arch for a CPU, first-found prevails. Sort them accordingly.
// When this becomes table-generated, we'd probably need two tables.
// FIXME: TableGen this.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 125,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 115,
 FQN="(anonymous namespace)::(anonymous)", NM="_Unnamed_struct4",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_Unnamed_struct4")
//</editor-fold>
public static class/*struct*/ Unnamed_struct4 {
  public /*const*/char$ptr/*char P*/ NameCStr;
  public /*size_t*/int NameLength;
  public ARM.ArchKind ArchID;
  public boolean Default; // is $Name the default CPU for $ArchID ?
  public /*uint*/int DefaultExtensions;
  
  @Converted(kind = Converted.Kind.MANUAL_ADDED)
  public Unnamed_struct4(char$ptr NameCStr, int NameLength, ArchKind ArchID, boolean Default, int DefaultExtensions) {
    this.NameCStr = NameCStr;
    this.NameLength = NameLength;
    this.ArchID = ArchID;
    this.Default = Default;
    this.DefaultExtensions = DefaultExtensions;
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::getName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 132,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 39,
   FQN="(anonymous namespace)::(anonymous struct)::getName", NM="_ZNK12_GLOBAL__N_13$_07getNameEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZNK12_GLOBAL__N_13$_07getNameEv")
  //</editor-fold>
  public StringRef getName() /*const*/ {
    return new StringRef(NameCStr, NameLength);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::(anonymous struct)::">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 125,
   old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 31,
   FQN="(anonymous namespace)::(anonymous struct)::", NM="_ZN12_GLOBAL__N_13$_0C1ERKS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_13$_0C1ERKS0_")
  //</editor-fold>
  public /*inline*/ Unnamed_struct4(Unnamed_struct4 $Prm0) {
    // : NameCStr(.NameCStr), NameLength(.NameLength), ArchID(.ArchID), Default(.Default), DefaultExtensions(.DefaultExtensions) 
    //START JInit
    this.NameCStr = $tryClone($Prm0.NameCStr);
    this.NameLength = $Prm0.NameLength;
    this.ArchID = $Prm0.ArchID;
    this.Default = $Prm0.Default;
    this.DefaultExtensions = $Prm0.DefaultExtensions;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "NameCStr=" + NameCStr // NOI18N
              + ", NameLength=" + NameLength // NOI18N
              + ", ArchID=" + ArchID // NOI18N
              + ", Default=" + Default // NOI18N
              + ", DefaultExtensions=" + DefaultExtensions; // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CPUNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 125,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 115,
 FQN="(anonymous namespace)::CPUNames", NM="_ZN12_GLOBAL__N_1L8CPUNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L8CPUNamesE")
//</editor-fold>
public static Unnamed_struct4 CPUNames[/*75*/] = new Unnamed_struct4[/*75*/] {
  new Unnamed_struct4($("arm2"), sizeof$str("arm2") - 1, ArchKind.AK_ARMV2, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm3"), sizeof$str("arm3") - 1, ArchKind.AK_ARMV2A, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm6"), sizeof$str("arm6") - 1, ArchKind.AK_ARMV3, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm7m"), sizeof$str("arm7m") - 1, ArchKind.AK_ARMV3M, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm8"), sizeof$str("arm8") - 1, ArchKind.AK_ARMV4, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm810"), sizeof$str("arm810") - 1, ArchKind.AK_ARMV4, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("strongarm"), sizeof$str("strongarm") - 1, ArchKind.AK_ARMV4, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("strongarm110"), sizeof$str("strongarm110") - 1, ArchKind.AK_ARMV4, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("strongarm1100"), sizeof$str("strongarm1100") - 1, ArchKind.AK_ARMV4, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("strongarm1110"), sizeof$str("strongarm1110") - 1, ArchKind.AK_ARMV4, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm7tdmi"), sizeof$str("arm7tdmi") - 1, ArchKind.AK_ARMV4T, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm7tdmi-s"), sizeof$str("arm7tdmi-s") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm710t"), sizeof$str("arm710t") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm720t"), sizeof$str("arm720t") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm9"), sizeof$str("arm9") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm9tdmi"), sizeof$str("arm9tdmi") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm920"), sizeof$str("arm920") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm920t"), sizeof$str("arm920t") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm922t"), sizeof$str("arm922t") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm9312"), sizeof$str("arm9312") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm940t"), sizeof$str("arm940t") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("ep9312"), sizeof$str("ep9312") - 1, ArchKind.AK_ARMV4T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm10tdmi"), sizeof$str("arm10tdmi") - 1, ArchKind.AK_ARMV5T, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1020t"), sizeof$str("arm1020t") - 1, ArchKind.AK_ARMV5T, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm9e"), sizeof$str("arm9e") - 1, ArchKind.AK_ARMV5TE, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm946e-s"), sizeof$str("arm946e-s") - 1, ArchKind.AK_ARMV5TE, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm966e-s"), sizeof$str("arm966e-s") - 1, ArchKind.AK_ARMV5TE, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm968e-s"), sizeof$str("arm968e-s") - 1, ArchKind.AK_ARMV5TE, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm10e"), sizeof$str("arm10e") - 1, ArchKind.AK_ARMV5TE, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1020e"), sizeof$str("arm1020e") - 1, ArchKind.AK_ARMV5TE, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1022e"), sizeof$str("arm1022e") - 1, ArchKind.AK_ARMV5TE, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm926ej-s"), sizeof$str("arm926ej-s") - 1, ArchKind.AK_ARMV5TEJ, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1136j-s"), sizeof$str("arm1136j-s") - 1, ArchKind.AK_ARMV6, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1136jf-s"), sizeof$str("arm1136jf-s") - 1, ArchKind.AK_ARMV6, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1136jz-s"), sizeof$str("arm1136jz-s") - 1, ArchKind.AK_ARMV6, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1176j-s"), sizeof$str("arm1176j-s") - 1, ArchKind.AK_ARMV6K, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1176jz-s"), sizeof$str("arm1176jz-s") - 1, ArchKind.AK_ARMV6KZ, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("mpcore"), sizeof$str("mpcore") - 1, ArchKind.AK_ARMV6K, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("mpcorenovfp"), sizeof$str("mpcorenovfp") - 1, ArchKind.AK_ARMV6K, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1176jzf-s"), sizeof$str("arm1176jzf-s") - 1, ArchKind.AK_ARMV6KZ, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1156t2-s"), sizeof$str("arm1156t2-s") - 1, ArchKind.AK_ARMV6T2, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("arm1156t2f-s"), sizeof$str("arm1156t2f-s") - 1, ArchKind.AK_ARMV6T2, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-m0"), sizeof$str("cortex-m0") - 1, ArchKind.AK_ARMV6M, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-m0plus"), sizeof$str("cortex-m0plus") - 1, ArchKind.AK_ARMV6M, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-m1"), sizeof$str("cortex-m1") - 1, ArchKind.AK_ARMV6M, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("sc000"), sizeof$str("sc000") - 1, ArchKind.AK_ARMV6M, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-a5"), sizeof$str("cortex-a5") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP)), 
  new Unnamed_struct4($("cortex-a7"), sizeof$str("cortex-a7") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)), 
  new Unnamed_struct4($("cortex-a8"), sizeof$str("cortex-a8") - 1, ArchKind.AK_ARMV7A, true, ARM.ArchExtKind.AEK_SEC), 
  new Unnamed_struct4($("cortex-a9"), sizeof$str("cortex-a9") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP)), 
  new Unnamed_struct4($("cortex-a12"), sizeof$str("cortex-a12") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)), 
  new Unnamed_struct4($("cortex-a15"), sizeof$str("cortex-a15") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)), 
  new Unnamed_struct4($("cortex-a17"), sizeof$str("cortex-a17") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_SEC | ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_VIRT | ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)), 
  new Unnamed_struct4($("krait"), sizeof$str("krait") - 1, ArchKind.AK_ARMV7A, false, (ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)), 
  new Unnamed_struct4($("cortex-r4"), sizeof$str("cortex-r4") - 1, ArchKind.AK_ARMV7R, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-r4f"), sizeof$str("cortex-r4f") - 1, ArchKind.AK_ARMV7R, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-r5"), sizeof$str("cortex-r5") - 1, ArchKind.AK_ARMV7R, false, (ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_HWDIVARM)), 
  new Unnamed_struct4($("cortex-r7"), sizeof$str("cortex-r7") - 1, ArchKind.AK_ARMV7R, false, (ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_HWDIVARM)), 
  new Unnamed_struct4($("cortex-r8"), sizeof$str("cortex-r8") - 1, ArchKind.AK_ARMV7R, false, (ARM.ArchExtKind.AEK_MP | ARM.ArchExtKind.AEK_HWDIVARM)), 
  new Unnamed_struct4($("sc300"), sizeof$str("sc300") - 1, ArchKind.AK_ARMV7M, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-m3"), sizeof$str("cortex-m3") - 1, ArchKind.AK_ARMV7M, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-m4"), sizeof$str("cortex-m4") - 1, ArchKind.AK_ARMV7EM, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-m7"), sizeof$str("cortex-m7") - 1, ArchKind.AK_ARMV7EM, false, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("cortex-a32"), sizeof$str("cortex-a32") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("cortex-a35"), sizeof$str("cortex-a35") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("cortex-a53"), sizeof$str("cortex-a53") - 1, ArchKind.AK_ARMV8A, true, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("cortex-a57"), sizeof$str("cortex-a57") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("cortex-a72"), sizeof$str("cortex-a72") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("cortex-a73"), sizeof$str("cortex-a73") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("cyclone"), sizeof$str("cyclone") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  new Unnamed_struct4($("exynos-m1"), sizeof$str("exynos-m1") - 1, ArchKind.AK_ARMV8A, false, ARM.ArchExtKind.AEK_CRC), 
  // Non-standard Arch names.
  new Unnamed_struct4($("iwmmxt"), sizeof$str("iwmmxt") - 1, ArchKind.AK_IWMMXT, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("xscale"), sizeof$str("xscale") - 1, ArchKind.AK_XSCALE, true, ARM.ArchExtKind.AEK_NONE), 
  new Unnamed_struct4($("swift"), sizeof$str("swift") - 1, ArchKind.AK_ARMV7S, true, (ARM.ArchExtKind.AEK_HWDIVARM | ARM.ArchExtKind.AEK_HWDIV)), 
  // Invalid CPU
  new Unnamed_struct4($("invalid"), sizeof$str("invalid") - 1, ArchKind.AK_INVALID, true, ARM.ArchExtKind.AEK_INVALID)
};
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64CPUNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 125,
 FQN="(anonymous namespace)::AArch64CPUNames", NM="_ZN12_GLOBAL__N_1L15AArch64CPUNamesE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZN12_GLOBAL__N_1L15AArch64CPUNamesE")
//</editor-fold>
public static Unnamed_struct4 AArch64CPUNames[/*10*/] = new Unnamed_struct4[/*10*/] {
  new Unnamed_struct4($("cortex-a35"), sizeof$str("cortex-a35") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("cortex-a53"), sizeof$str("cortex-a53") - 1, ArchKind.AK_ARMV8A, true, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("cortex-a57"), sizeof$str("cortex-a57") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("cortex-a72"), sizeof$str("cortex-a72") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("cortex-a73"), sizeof$str("cortex-a73") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("cyclone"), sizeof$str("cyclone") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("exynos-m1"), sizeof$str("exynos-m1") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("kryo"), sizeof$str("kryo") - 1, ArchKind.AK_ARMV8A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  new Unnamed_struct4($("vulcan"), sizeof$str("vulcan") - 1, ArchKind.AK_ARMV8_1A, false, (AArch64.ArchExtKind.AEK_SIMD | AArch64.ArchExtKind.AEK_CRC | AArch64.ArchExtKind.AEK_CRYPTO)), 
  // Invalid CPU
  new Unnamed_struct4($("invalid"), sizeof$str("invalid") - 1, ArchKind.AK_INVALID, true, AArch64.ArchExtKind.AEK_INVALID)
};

// ======================================================= //
// Parsers
// ======================================================= //
//<editor-fold defaultstate="collapsed" desc="getHWDivSynonym">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 540,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 376,
 FQN="getHWDivSynonym", NM="_ZL15getHWDivSynonymN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZL15getHWDivSynonymN4llvm9StringRefE")
//</editor-fold>
public static StringRef getHWDivSynonym(StringRef HWDiv) {
  return new StringSwitchStringRef(/*NO_COPY*/HWDiv).
      Case(/*KEEP_STR*/"thumb,arm", /*STRINGREF_STR*/"arm,thumb").
      Default(HWDiv);
}

//<editor-fold defaultstate="collapsed" desc="getFPUSynonym">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 546,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 382,
 FQN="getFPUSynonym", NM="_ZL13getFPUSynonymN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZL13getFPUSynonymN4llvm9StringRefE")
//</editor-fold>
public static StringRef getFPUSynonym(StringRef FPU) {
  return new StringSwitchStringRef(/*NO_COPY*/FPU).
      Cases(/*KEEP_STR*/"fpa", /*KEEP_STR*/"fpe2", /*KEEP_STR*/"fpe3", /*KEEP_STR*/"maverick", /*STRINGREF_STR*/"invalid"). // Unsupported
      Case(/*KEEP_STR*/"vfp2", /*STRINGREF_STR*/"vfpv2").
      Case(/*KEEP_STR*/"vfp3", /*STRINGREF_STR*/"vfpv3").
      Case(/*KEEP_STR*/"vfp4", /*STRINGREF_STR*/"vfpv4").
      Case(/*KEEP_STR*/"vfp3-d16", /*STRINGREF_STR*/"vfpv3-d16").
      Case(/*KEEP_STR*/"vfp4-d16", /*STRINGREF_STR*/"vfpv4-d16").
      Cases(/*KEEP_STR*/"fp4-sp-d16", /*KEEP_STR*/"vfpv4-sp-d16", /*STRINGREF_STR*/"fpv4-sp-d16").
      Cases(/*KEEP_STR*/"fp4-dp-d16", /*KEEP_STR*/"fpv4-dp-d16", /*STRINGREF_STR*/"vfpv4-d16").
      Case(/*KEEP_STR*/"fp5-sp-d16", /*STRINGREF_STR*/"fpv5-sp-d16").
      Cases(/*KEEP_STR*/"fp5-dp-d16", /*KEEP_STR*/"fpv5-dp-d16", /*STRINGREF_STR*/"fpv5-d16").
      // FIXME: Clang uses it, but it's bogus, since neon defaults to vfpv3.
      Case(/*KEEP_STR*/"neon-vfpv3", /*STRINGREF_STR*/"neon").
      Default(FPU);
}

//<editor-fold defaultstate="collapsed" desc="getArchSynonym">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", line = 563,
 old_source = "${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp", old_line = 399,
 FQN="getArchSynonym", NM="_ZL14getArchSynonymN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.llvm.adtsupport/llvmToClangType ${LLVM_SRC}/llvm/lib/Support/TargetParser.cpp -nm=_ZL14getArchSynonymN4llvm9StringRefE")
//</editor-fold>
public static StringRef getArchSynonym(StringRef Arch) {
  return new StringSwitchStringRef(/*NO_COPY*/Arch).
      Case(/*KEEP_STR*/"v5", /*STRINGREF_STR*/"v5t").
      Case(/*KEEP_STR*/"v5e", /*STRINGREF_STR*/"v5te").
      Case(/*KEEP_STR*/"v6j", /*STRINGREF_STR*/"v6").
      Case(/*KEEP_STR*/"v6hl", /*STRINGREF_STR*/"v6k").
      Cases(/*KEEP_STR*/"v6m", /*KEEP_STR*/"v6sm", /*KEEP_STR*/"v6s-m", /*STRINGREF_STR*/"v6-m").
      Cases(/*KEEP_STR*/"v6z", /*KEEP_STR*/"v6zk", /*STRINGREF_STR*/"v6kz").
      Cases(/*KEEP_STR*/"v7", /*KEEP_STR*/"v7a", /*KEEP_STR*/"v7hl", /*KEEP_STR*/"v7l", /*STRINGREF_STR*/"v7-a").
      Case(/*KEEP_STR*/"v7r", /*STRINGREF_STR*/"v7-r").
      Case(/*KEEP_STR*/"v7m", /*STRINGREF_STR*/"v7-m").
      Case(/*KEEP_STR*/"v7em", /*STRINGREF_STR*/"v7e-m").
      Cases(/*KEEP_STR*/"v8", /*KEEP_STR*/"v8a", /*KEEP_STR*/"aarch64", /*KEEP_STR*/"arm64", /*STRINGREF_STR*/"v8-a").
      Case(/*KEEP_STR*/"v8.1a", /*STRINGREF_STR*/"v8.1-a").
      Case(/*KEEP_STR*/"v8.2a", /*STRINGREF_STR*/"v8.2-a").
      Case(/*KEEP_STR*/"v8m.base", /*STRINGREF_STR*/"v8-m.base").
      Case(/*KEEP_STR*/"v8m.main", /*STRINGREF_STR*/"v8-m.main").
      Default(Arch);
}

} // END OF class TargetParserStatics
