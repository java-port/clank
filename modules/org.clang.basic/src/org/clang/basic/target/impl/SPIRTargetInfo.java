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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7905,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7351,
 FQN="(anonymous namespace)::SPIRTargetInfo", NM="_ZN12_GLOBAL__N_114SPIRTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114SPIRTargetInfoE")
//</editor-fold>
public class SPIRTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::SPIRTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7907,
   FQN="(anonymous namespace)::SPIRTargetInfo::SPIRTargetInfo", NM="_ZN12_GLOBAL__N_114SPIRTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114SPIRTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public SPIRTargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple)*/ 
    //START JInit
    super(_Triple);
    //END JInit
    assert (getTriple().getOS() == Triple.OSType.UnknownOS) : "SPIR target must use unknown OS";
    assert (getTriple().getEnvironment() == Triple.EnvironmentType.UnknownEnvironment) : "SPIR target must use unknown environment type";
    BigEndian = false;
    TLSSupported = false;
    LongWidth = LongAlign = 64;
    AddrSpaceMap = new LangAS.Map($AddrOf(SPIRAddrSpaceMap));
    UseAddrSpaceMapMangling = true;
    // Define available target features
    // These must be defined in sorted order!
    NoAsmVariants = true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7922,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7367,
   FQN="(anonymous namespace)::SPIRTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    DefineStd(Builder, new StringRef(/*KEEP_STR*/"SPIR"), Opts);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7926,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7371,
   FQN="(anonymous namespace)::SPIRTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"spir");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7930,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7375,
   FQN="(anonymous namespace)::SPIRTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    // JAVA: can not use None() here, because it is used in $assignMove
    return new ArrayRef<Builtin.Info>(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7931,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7376,
   FQN="(anonymous namespace)::SPIRTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    return $EMPTY;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7932,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7377,
   FQN="(anonymous namespace)::SPIRTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return ArrayRef.</*const*/char$ptr/*char P*/ >None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7933,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7378,
   FQN="(anonymous namespace)::SPIRTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ info) /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7937,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7382,
   FQN="(anonymous namespace)::SPIRTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7940,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7385,
   FQN="(anonymous namespace)::SPIRTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.VoidPtrBuiltinVaList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7944,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7389,
   FQN="(anonymous namespace)::SPIRTargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    return (CC == CallingConv.CC_SpirFunction || CC == CallingConv.CC_OpenCLKernel) ? CallingConvCheckResult.CCCR_OK : CallingConvCheckResult.CCCR_Warning;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::getDefaultCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7949,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7394,
   FQN="(anonymous namespace)::SPIRTargetInfo::getDefaultCallingConv", NM="_ZNK12_GLOBAL__N_114SPIRTargetInfo21getDefaultCallingConvEN5clang10TargetInfo21CallingConvMethodTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_114SPIRTargetInfo21getDefaultCallingConvEN5clang10TargetInfo21CallingConvMethodTypeE")
  //</editor-fold>
  @Override public CallingConv getDefaultCallingConv(CallingConvMethodType MT) /*const*//* override*/ {
    return CallingConv.CC_SpirFunction;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::setSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7953,
   FQN="(anonymous namespace)::SPIRTargetInfo::setSupportedOpenCLOpts", NM="_ZN12_GLOBAL__N_114SPIRTargetInfo22setSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114SPIRTargetInfo22setSupportedOpenCLOptsEv")
  //</editor-fold>
  @Override public void setSupportedOpenCLOpts()/* override*/ {
    // Assume all OpenCL extensions and optional core features are supported
    // for SPIR since it is a generic target.
    getSupportedOpenCLOpts().setAll();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SPIRTargetInfo::~SPIRTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7905,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7351,
   FQN="(anonymous namespace)::SPIRTargetInfo::~SPIRTargetInfo", NM="_ZN12_GLOBAL__N_114SPIRTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_114SPIRTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
