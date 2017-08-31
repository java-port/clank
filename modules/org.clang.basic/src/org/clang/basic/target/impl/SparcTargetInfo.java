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
import static org.clank.support.NativePointer.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


// Shared base class for SPARC v8 (32-bit) and SPARC v9 (64-bit).
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6372,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5840,
 FQN="(anonymous namespace)::SparcTargetInfo", NM="_ZN12_GLOBAL__N_115SparcTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfoE")
//</editor-fold>
public class SparcTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/ TargetInfo.GCCRegAlias GCCRegAliases[] = new /*const*/ TargetInfo.GCCRegAlias [/*32*/] {
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g0")}, $("r0")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g1")}, $("r1")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g2")}, $("r2")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g3")}, $("r3")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g4")}, $("r4")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g5")}, $("r5")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g6")}, $("r6")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("g7")}, $("r7")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o0")}, $("r8")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o1")}, $("r9")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o2")}, $("r10")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o3")}, $("r11")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o4")}, $("r12")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o5")}, $("r13")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o6"), $("sp")}, $("r14")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("o7")}, $("r15")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l0")}, $("r16")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l1")}, $("r17")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l2")}, $("r18")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l3")}, $("r19")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l4")}, $("r20")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l5")}, $("r21")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l6")}, $("r22")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("l7")}, $("r23")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i0")}, $("r24")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i1")}, $("r25")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i2")}, $("r26")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i3")}, $("r27")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i4")}, $("r28")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i5")}, $("r29")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i6"), $("fp")}, $("r30")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("i7")}, $("r31"))
  };
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*32*/] {
    $("r0"), $("r1"), $("r2"), $("r3"), $("r4"), $("r5"), $("r6"), $("r7"), 
    $("r8"), $("r9"), $("r10"), $("r11"), $("r12"), $("r13"), $("r14"), $("r15"), 
    $("r16"), $("r17"), $("r18"), $("r19"), $("r20"), $("r21"), $("r22"), $("r23"), 
    $("r24"), $("r25"), $("r26"), $("r27"), $("r28"), $("r29"), $("r30"), $("r31")
  });
  private boolean SoftFloat;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::SparcTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6377,
   FQN="(anonymous namespace)::SparcTargetInfo::SparcTargetInfo", NM="_ZN12_GLOBAL__N_115SparcTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public SparcTargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple), SoftFloat(false), CPU(CK_GENERIC)*/ 
    //START JInit
    super(Triple);
    this.SoftFloat = false;
    /*InClass*/this.CPU = CPUKind.CK_GENERIC;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6380,
   FQN="(anonymous namespace)::SparcTargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  @Override public int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*//* override*/ {
    if (RegNo == 0) {
      return 24;
    }
    if (RegNo == 1) {
      return 25;
    }
    return -1;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6386,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5848,
   FQN="(anonymous namespace)::SparcTargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_115SparcTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    // Check if software floating point is enabled
    vectorString.iterator Feature = std.find(Features.begin(), Features.end(), /*KEEP_STR*/"+soft-float");
    if ($noteq___normal_iterator$C(Feature, Features.end())) {
      SoftFloat = true;
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6395,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5859,
   FQN="(anonymous namespace)::SparcTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    DefineStd(Builder, new StringRef(/*KEEP_STR*/"sparc"), Opts);
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__REGISTER_PREFIX__"), new Twine(/*KEEP_STR*/$EMPTY));
    if (SoftFloat) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"SOFT_FLOAT"), new Twine(/*KEEP_STR*/$1));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6404,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5868,
   FQN="(anonymous namespace)::SparcTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"softfloat", SoftFloat).
        Case(/*KEEP_STR*/"sparc", true).
        Default(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::hasSjLjLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6411,
   FQN="(anonymous namespace)::SparcTargetInfo::hasSjLjLowering", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo15hasSjLjLoweringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo15hasSjLjLoweringEv")
  //</editor-fold>
  @Override public boolean hasSjLjLowering() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6415,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5875,
   FQN="(anonymous namespace)::SparcTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    // FIXME: Implement!
    // JAVA: can not use None() here, because it is used in $assignMove
    return new ArrayRef<Builtin.Info>(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6419,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5879,
   FQN="(anonymous namespace)::SparcTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.VoidPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6557,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5986,
   FQN="(anonymous namespace)::SparcTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6596,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 6025,
   FQN="(anonymous namespace)::SparcTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegAliases);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6424,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5884,
   FQN="(anonymous namespace)::SparcTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ info) /*const*//* override*/ {
    // FIXME: Implement!
    switch (Name.$star()) {
     case 'I': // Signed 13-bit constant
     case 'J': // Zero
     case 'K': // 32-bit constant with the low 12 bits clear
     case 'L': // A constant in the range supported by movcc (11-bit signed imm)
     case 'M': // A constant in the range supported by movrcc (19-bit signed imm)
     case 'N': // Same as 'K' but zext (required for SIMode)
     case 'O': // The constant 4096
      return true;
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6439,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5899,
   FQN="(anonymous namespace)::SparcTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    // FIXME: Implement!
    return $EMPTY;
  }

  
  // No Sparc V7 for now, the backend doesn't support it anyway.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::CPUKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6445,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5905,
   FQN="(anonymous namespace)::SparcTargetInfo::CPUKind", NM="_ZN12_GLOBAL__N_115SparcTargetInfo7CPUKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfo7CPUKindE")
  //</editor-fold>
  public enum CPUKind implements Native.ComparableLower {
    CK_GENERIC(0),
    CK_V8(CK_GENERIC.getValue() + 1),
    CK_SUPERSPARC(CK_V8.getValue() + 1),
    CK_SPARCLITE(CK_SUPERSPARC.getValue() + 1),
    CK_F934(CK_SPARCLITE.getValue() + 1),
    CK_HYPERSPARC(CK_F934.getValue() + 1),
    CK_SPARCLITE86X(CK_HYPERSPARC.getValue() + 1),
    CK_SPARCLET(CK_SPARCLITE86X.getValue() + 1),
    CK_TSC701(CK_SPARCLET.getValue() + 1),
    CK_V9(CK_TSC701.getValue() + 1),
    CK_ULTRASPARC(CK_V9.getValue() + 1),
    CK_ULTRASPARC3(CK_ULTRASPARC.getValue() + 1),
    CK_NIAGARA(CK_ULTRASPARC3.getValue() + 1),
    CK_NIAGARA2(CK_NIAGARA.getValue() + 1),
    CK_NIAGARA3(CK_NIAGARA2.getValue() + 1),
    CK_NIAGARA4(CK_NIAGARA3.getValue() + 1),
    CK_MYRIAD2_1(CK_NIAGARA4.getValue() + 1),
    CK_MYRIAD2_2(CK_MYRIAD2_1.getValue() + 1),
    CK_LEON2(CK_MYRIAD2_2.getValue() + 1),
    CK_LEON2_AT697E(CK_LEON2.getValue() + 1),
    CK_LEON2_AT697F(CK_LEON2_AT697E.getValue() + 1),
    CK_LEON3(CK_LEON2_AT697F.getValue() + 1),
    CK_LEON3_UT699(CK_LEON3.getValue() + 1),
    CK_LEON3_GR712RC(CK_LEON3_UT699.getValue() + 1),
    CK_LEON4(CK_LEON3_GR712RC.getValue() + 1),
    CK_LEON4_GR740(CK_LEON4.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CPUKind valueOf(int val) {
      CPUKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CPUKind[] VALUES;
      private static final CPUKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CPUKind kind : CPUKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CPUKind[min < 0 ? (1-min) : 0];
        VALUES = new CPUKind[max >= 0 ? (1+max) : 0];
        for (CPUKind kind : CPUKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CPUKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CPUKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CPUKind)obj).value);}
    //</editor-fold>
  };
  public  CPUKind CPU/* = CK_GENERIC*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::CPUGeneration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6474,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5924,
   FQN="(anonymous namespace)::SparcTargetInfo::CPUGeneration", NM="_ZN12_GLOBAL__N_115SparcTargetInfo13CPUGenerationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfo13CPUGenerationE")
  //</editor-fold>
  public enum CPUGeneration implements Native.ComparableLower {
    CG_V8(0),
    CG_V9(CG_V8.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static CPUGeneration valueOf(int val) {
      CPUGeneration out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final CPUGeneration[] VALUES;
      private static final CPUGeneration[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (CPUGeneration kind : CPUGeneration.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new CPUGeneration[min < 0 ? (1-min) : 0];
        VALUES = new CPUGeneration[max >= 0 ? (1+max) : 0];
        for (CPUGeneration kind : CPUGeneration.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private CPUGeneration(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((CPUGeneration)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((CPUGeneration)obj).value);}
    //</editor-fold>
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getCPUGeneration">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5929,
   FQN="(anonymous namespace)::SparcTargetInfo::getCPUGeneration", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo16getCPUGenerationENS0_7CPUKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo16getCPUGenerationENS0_7CPUKindE")
  //</editor-fold>
  public CPUGeneration getCPUGeneration(CPUKind Kind) /*const*/ {
    switch (Kind) {
     case CK_GENERIC:
     case CK_V8:
     case CK_SUPERSPARC:
     case CK_SPARCLITE:
     case CK_F934:
     case CK_HYPERSPARC:
     case CK_SPARCLITE86X:
     case CK_SPARCLET:
     case CK_TSC701:
     case CK_MYRIAD2_1:
     case CK_MYRIAD2_2:
     case CK_LEON2:
     case CK_LEON2_AT697E:
     case CK_LEON2_AT697F:
     case CK_LEON3:
     case CK_LEON3_UT699:
     case CK_LEON3_GR712RC:
     case CK_LEON4:
     case CK_LEON4_GR740:
      return CPUGeneration.CG_V8;
     case CK_V9:
     case CK_ULTRASPARC:
     case CK_ULTRASPARC3:
     case CK_NIAGARA:
     case CK_NIAGARA2:
     case CK_NIAGARA3:
     case CK_NIAGARA4:
      return CPUGeneration.CG_V9;
    }
    throw new llvm_unreachable("Unexpected CPU kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::getCPUKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6513,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5953,
   FQN="(anonymous namespace)::SparcTargetInfo::getCPUKind", NM="_ZNK12_GLOBAL__N_115SparcTargetInfo10getCPUKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_115SparcTargetInfo10getCPUKindEN4llvm9StringRefE")
  //</editor-fold>
  public CPUKind getCPUKind(StringRef Name) /*const*/ {
    return new StringSwitch<CPUKind>(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"v8", CPUKind.CK_V8).
        Case(/*KEEP_STR*/"supersparc", CPUKind.CK_SUPERSPARC).
        Case(/*KEEP_STR*/"sparclite", CPUKind.CK_SPARCLITE).
        Case(/*KEEP_STR*/"f934", CPUKind.CK_F934).
        Case(/*KEEP_STR*/"hypersparc", CPUKind.CK_HYPERSPARC).
        Case(/*KEEP_STR*/"sparclite86x", CPUKind.CK_SPARCLITE86X).
        Case(/*KEEP_STR*/"sparclet", CPUKind.CK_SPARCLET).
        Case(/*KEEP_STR*/"tsc701", CPUKind.CK_TSC701).
        Case(/*KEEP_STR*/"v9", CPUKind.CK_V9).
        Case(/*KEEP_STR*/"ultrasparc", CPUKind.CK_ULTRASPARC).
        Case(/*KEEP_STR*/"ultrasparc3", CPUKind.CK_ULTRASPARC3).
        Case(/*KEEP_STR*/"niagara", CPUKind.CK_NIAGARA).
        Case(/*KEEP_STR*/"niagara2", CPUKind.CK_NIAGARA2).
        Case(/*KEEP_STR*/"niagara3", CPUKind.CK_NIAGARA3).
        Case(/*KEEP_STR*/"niagara4", CPUKind.CK_NIAGARA4).
        Case(/*KEEP_STR*/"myriad2", CPUKind.CK_MYRIAD2_1).
        Case(/*KEEP_STR*/"myriad2.1", CPUKind.CK_MYRIAD2_1).
        Case(/*KEEP_STR*/"myriad2.2", CPUKind.CK_MYRIAD2_2).
        Case(/*KEEP_STR*/"leon2", CPUKind.CK_LEON2).
        Case(/*KEEP_STR*/"at697e", CPUKind.CK_LEON2_AT697E).
        Case(/*KEEP_STR*/"at697f", CPUKind.CK_LEON2_AT697F).
        Case(/*KEEP_STR*/"leon3", CPUKind.CK_LEON3).
        Case(/*KEEP_STR*/"ut699", CPUKind.CK_LEON3_UT699).
        Case(/*KEEP_STR*/"gr712rc", CPUKind.CK_LEON3_GR712RC).
        Case(/*KEEP_STR*/"leon4", CPUKind.CK_LEON4).
        Case(/*KEEP_STR*/"gr740", CPUKind.CK_LEON4_GR740).
        Default(CPUKind.CK_GENERIC);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6544,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5973,
   FQN="(anonymous namespace)::SparcTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_115SparcTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    CPU = getCPUKind(new StringRef(Name));
    return CPU != CPUKind.CK_GENERIC;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SparcTargetInfo::~SparcTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6372,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5840,
   FQN="(anonymous namespace)::SparcTargetInfo::~SparcTargetInfo", NM="_ZN12_GLOBAL__N_115SparcTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_115SparcTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "SoftFloat=" + SoftFloat // NOI18N
              + ", CPU=" + CPU // NOI18N
              + super.toString(); // NOI18N
  }
}
