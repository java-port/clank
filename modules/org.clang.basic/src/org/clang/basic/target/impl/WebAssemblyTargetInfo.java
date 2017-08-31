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
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7741,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7189,
 FQN="(anonymous namespace)::WebAssemblyTargetInfo", NM="_ZN12_GLOBAL__N_121WebAssemblyTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121WebAssemblyTargetInfoE")
//</editor-fold>
public class WebAssemblyTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*2*/] {
    // BuiltinsWebAssembly.def - WebAssembly builtin function database -*- C++ -*-//
    //
    //                     The LLVM Compiler Infrastructure
    //
    // This file is distributed under the University of Illinois Open Source
    // License. See LICENSE.TXT for details.
    //
    //===----------------------------------------------------------------------===//
    ///
    /// \file
    /// \brief This file defines the WebAssembly-specific builtin function database.
    /// Users of this file must define the BUILTIN macro to make use of this
    /// information.
    ///
    //===----------------------------------------------------------------------===//
    
    // The format of this database matches clang/Basic/Builtins.def.
    
    // Note that current_memory is not "c" (readnone) because it must be sequenced with
    // respect to grow_memory calls.
    new Builtin.Info(/*KEEP_STR*/"__builtin_wasm_current_memory", /*KEEP_STR*/$z, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_wasm_grow_memory", /*KEEP_STR*/"vz", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::SIMDEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7744,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7192,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::SIMDEnum", NM="_ZN12_GLOBAL__N_121WebAssemblyTargetInfo8SIMDEnumE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121WebAssemblyTargetInfo8SIMDEnumE")
  //</editor-fold>
  private enum SIMDEnum implements Native.ComparableLower {
    NoSIMD(0),
    SIMD128(NoSIMD.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static SIMDEnum valueOf(int val) {
      SIMDEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final SIMDEnum[] VALUES;
      private static final SIMDEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (SIMDEnum kind : SIMDEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new SIMDEnum[min < 0 ? (1-min) : 0];
        VALUES = new SIMDEnum[max >= 0 ? (1+max) : 0];
        for (SIMDEnum kind : SIMDEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private SIMDEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SIMDEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SIMDEnum)obj).value);}
    //</editor-fold>
  };
  
  private  SIMDEnum SIMDLevel;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::WebAssemblyTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7750,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::WebAssemblyTargetInfo", NM="_ZN12_GLOBAL__N_121WebAssemblyTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121WebAssemblyTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public /*explicit*/ WebAssemblyTargetInfo(/*const*/ Triple /*&*/ T, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(T), SIMDLevel(NoSIMD)*/ 
    //START JInit
    super(T);
    this.SIMDLevel = SIMDEnum.NoSIMD;
    //END JInit
    BigEndian = false;
    NoAsmVariants = true;
    SuitableAlign = $int2uchar(128);
    LargeArrayMinWidth = $int2uchar(128);
    LargeArrayAlign = $int2uchar(128);
    SimdDefaultAlign = 128;
    SigAtomicType = IntType.SignedLong;
    LongDoubleWidth = LongDoubleAlign = $int2uchar(128);
    LongDoubleFormat = $AddrOf(APFloat.IEEEquad);
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7764,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7212,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public/*protected*/ void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"wasm"), /*Tuning=*/ false);
    if (SIMDLevel.getValue() >= SIMDEnum.SIMD128.getValue()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__wasm_simd128__"));
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7772,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7220,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public/*private*/ boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, 
                StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeaturesVec) /*const*//* override*/ {
    if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"bleeding-edge")) {
      Features.$set(/*STRINGREF_STR*/"simd128", true);
    }
    return super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeaturesVec);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7228,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public/*private*/ final boolean hasFeature(StringRef Feature) /*const*//* final*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"simd128", SIMDLevel.getValue() >= SIMDEnum.SIMD128.getValue()).
        Default(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7785,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7233,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_121WebAssemblyTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121WebAssemblyTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public/*private*/ final boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* final*/ {
    for (/*const*/std.string/*&*/ Feature : Features) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if ($eq_string$C_T(Feature, /*KEEP_STR*/"+simd128")) {
          SIMDLevel = std.max(SIMDLevel, SIMDEnum.SIMD128);
          continue;
        }
        if ($eq_string$C_T(Feature, /*KEEP_STR*/"-simd128")) {
          SIMDLevel = SIMDEnum.valueOf(std.min(SIMDLevel.getValue(), SIMDEnum.SIMD128.getValue() - 1));
          continue;
        }
        
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(Diags.Report(diag.err_opt_not_valid_with_opt)), new StringRef(Feature)), 
            /*KEEP_STR*/"-target-feature"));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7803,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7251,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_121WebAssemblyTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121WebAssemblyTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public/*private*/ final boolean setCPU(/*const*/std.string/*&*/ Name)/* final*/ {
    return new StringSwitchBool(Name).
        Case(/*KEEP_STR*/"mvp", true).
        Case(/*KEEP_STR*/"bleeding-edge", true).
        Case(/*KEEP_STR*/"generic", true).
        Default(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7810,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7258,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public/*private*/ final ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* final*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        WebAssembly.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7814,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7262,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public/*private*/ final BuiltinVaListKind getBuiltinVaListKind() /*const*//* final*/ {
    return BuiltinVaListKind.VoidPtrBuiltinVaList;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7265,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override protected/*private*/ final ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* final*/ {
    return ArrayRef.</*const*/char$ptr/*char P*/ >None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7820,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7268,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override protected/*private*/ final ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* final*/ {
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7823,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7271,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public/*private*/ final boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* final*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7828,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7276,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public/*private*/ final /*const*/char$ptr/*char P*/ getClobbers() /*const*//* final*/ {
    return $EMPTY;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::isCLZForZeroUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7829,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7277,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::isCLZForZeroUndef", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo17isCLZForZeroUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo17isCLZForZeroUndefEv")
  //</editor-fold>
  @Override public/*private*/ final boolean isCLZForZeroUndef() /*const*//* final*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::hasInt128Type">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7830,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7278,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::hasInt128Type", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo13hasInt128TypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo13hasInt128TypeEv")
  //</editor-fold>
  @Override public/*private*/ final boolean hasInt128Type() /*const*//* final*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getIntTypeByWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7831,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7279,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getIntTypeByWidth", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo17getIntTypeByWidthEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo17getIntTypeByWidthEjb")
  //</editor-fold>
  @Override public/*private*/ final IntType getIntTypeByWidth(/*uint*/int BitWidth, 
                   boolean IsSigned) /*const*//* final*/ {
    // WebAssembly prefers long long for explicitly 64-bit integers.
    return BitWidth == 64 ? (IsSigned ? IntType.SignedLongLong : IntType.UnsignedLongLong) : super.getIntTypeByWidth(BitWidth, IsSigned);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::getLeastIntTypeByWidth">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7837,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7285,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::getLeastIntTypeByWidth", NM="_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo22getLeastIntTypeByWidthEjb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121WebAssemblyTargetInfo22getLeastIntTypeByWidthEjb")
  //</editor-fold>
  @Override public/*private*/ final IntType getLeastIntTypeByWidth(/*uint*/int BitWidth, 
                        boolean IsSigned) /*const*//* final*/ {
    // WebAssembly uses long long for int_least64_t and int_fast64_t.
    return BitWidth == 64 ? (IsSigned ? IntType.SignedLongLong : IntType.UnsignedLongLong) : super.getLeastIntTypeByWidth(BitWidth, IsSigned);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyTargetInfo::~WebAssemblyTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 7741,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 7189,
   FQN="(anonymous namespace)::WebAssemblyTargetInfo::~WebAssemblyTargetInfo", NM="_ZN12_GLOBAL__N_121WebAssemblyTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121WebAssemblyTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "SIMDLevel=" + SIMDLevel // NOI18N
              + super.toString(); // NOI18N
  }
}
