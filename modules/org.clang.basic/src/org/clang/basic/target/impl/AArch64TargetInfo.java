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
import org.clang.basic.target.*;
import org.clang.basic.target.TargetInfo.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5645,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5264,
 FQN="(anonymous namespace)::AArch64TargetInfo", NM="_ZN12_GLOBAL__N_117AArch64TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfoE")
//</editor-fold>
public abstract class AArch64TargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::setDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5646,
   FQN="(anonymous namespace)::AArch64TargetInfo::setDataLayout", NM="_ZN12_GLOBAL__N_117AArch64TargetInfo13setDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfo13setDataLayoutEv")
  //</editor-fold>
  protected/*private*/ abstract /*virtual*/ void setDataLayout()/* = 0*/;

  private static /*const*/ TargetInfo.GCCRegAlias GCCRegAliases[] = new /*const*/ TargetInfo.GCCRegAlias [/*4*/] {
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("w31")}, $("wsp")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("x29")}, $("fp")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("x30")}, $("lr")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("x31")}, $("sp"))
  };
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*160*/] {
    // 32-bit Integer registers
    $("w0"), $("w1"), $("w2"), $("w3"), $("w4"), $("w5"), $("w6"), $("w7"), $("w8"), $("w9"), $("w10"), 
    $("w11"), $("w12"), $("w13"), $("w14"), $("w15"), $("w16"), $("w17"), $("w18"), $("w19"), $("w20"), $("w21"), 
    $("w22"), $("w23"), $("w24"), $("w25"), $("w26"), $("w27"), $("w28"), $("w29"), $("w30"), $("wsp"), 
    
    // 64-bit Integer registers
    $("x0"), $("x1"), $("x2"), $("x3"), $("x4"), $("x5"), $("x6"), $("x7"), $("x8"), $("x9"), $("x10"), 
    $("x11"), $("x12"), $("x13"), $("x14"), $("x15"), $("x16"), $("x17"), $("x18"), $("x19"), $("x20"), $("x21"), 
    $("x22"), $("x23"), $("x24"), $("x25"), $("x26"), $("x27"), $("x28"), $("fp"), $("lr"), $("sp"), 
    
    // 32-bit floating point regsisters
    $("s0"), $("s1"), $("s2"), $("s3"), $("s4"), $("s5"), $("s6"), $("s7"), $("s8"), $("s9"), $("s10"), 
    $("s11"), $("s12"), $("s13"), $("s14"), $("s15"), $("s16"), $("s17"), $("s18"), $("s19"), $("s20"), $("s21"), 
    $("s22"), $("s23"), $("s24"), $("s25"), $("s26"), $("s27"), $("s28"), $("s29"), $("s30"), $("s31"), 
    
    // 64-bit floating point regsisters
    $("d0"), $("d1"), $("d2"), $("d3"), $("d4"), $("d5"), $("d6"), $("d7"), $("d8"), $("d9"), $("d10"), 
    $("d11"), $("d12"), $("d13"), $("d14"), $("d15"), $("d16"), $("d17"), $("d18"), $("d19"), $("d20"), $("d21"), 
    $("d22"), $("d23"), $("d24"), $("d25"), $("d26"), $("d27"), $("d28"), $("d29"), $("d30"), $("d31"), 
    
    // Vector registers
    $("v0"), $("v1"), $("v2"), $("v3"), $("v4"), $("v5"), $("v6"), $("v7"), $("v8"), $("v9"), $("v10"), 
    $("v11"), $("v12"), $("v13"), $("v14"), $("v15"), $("v16"), $("v17"), $("v18"), $("v19"), $("v20"), $("v21"), 
    $("v22"), $("v23"), $("v24"), $("v25"), $("v26"), $("v27"), $("v28"), $("v29"), $("v30"), $("v31")
  });
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::FPUModeEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5650,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5269,
   FQN="(anonymous namespace)::AArch64TargetInfo::FPUModeEnum", NM="_ZN12_GLOBAL__N_117AArch64TargetInfo11FPUModeEnumE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfo11FPUModeEnumE")
  //</editor-fold>
  private enum FPUModeEnum implements Native.ComparableLower {
    FPUMode(0),
    NeonMode(FPUMode.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FPUModeEnum valueOf(int val) {
      FPUModeEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FPUModeEnum[] VALUES;
      private static final FPUModeEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FPUModeEnum kind : FPUModeEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FPUModeEnum[min < 0 ? (1-min) : 0];
        VALUES = new FPUModeEnum[max >= 0 ? (1+max) : 0];
        for (FPUModeEnum kind : FPUModeEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FPUModeEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FPUModeEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FPUModeEnum)obj).value);}
    //</editor-fold>
  };
  
  private /*uint*/int FPU;
  private /*uint*/int CRC;
  private /*uint*/int Crypto;
  private /*uint*/int Unaligned;
  private /*uint*/int V8_1A;
  
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*693*/] {
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabdd_f64", /*KEEP_STR*/$ddd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabdq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabds_f32", /*KEEP_STR*/$fff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabs_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabsd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vabsq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddhn_v", /*KEEP_STR*/"V8ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlv_s16", /*KEEP_STR*/"iV4s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlv_s32", /*KEEP_STR*/"WiV2i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlv_s8", /*KEEP_STR*/"sV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlv_u16", /*KEEP_STR*/"UiV4Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlv_u32", /*KEEP_STR*/"UWiV2Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlv_u8", /*KEEP_STR*/"UsV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlvq_s16", /*KEEP_STR*/"iV8s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlvq_s32", /*KEEP_STR*/"WiV4i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlvq_s8", /*KEEP_STR*/"sV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlvq_u16", /*KEEP_STR*/"UiV8Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlvq_u32", /*KEEP_STR*/"UWiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddlvq_u8", /*KEEP_STR*/"UsV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_s16", /*KEEP_STR*/"sV4s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_s32", /*KEEP_STR*/"iV2i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_s8", /*KEEP_STR*/"ScV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_u16", /*KEEP_STR*/"UsV4Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_u32", /*KEEP_STR*/"UiV2Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddv_u8", /*KEEP_STR*/"ScV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_f32", /*KEEP_STR*/"fV4f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_s16", /*KEEP_STR*/"sV8s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_s32", /*KEEP_STR*/"iV4i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_s64", /*KEEP_STR*/"WiV2Wi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_s8", /*KEEP_STR*/"ScV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_u16", /*KEEP_STR*/"UsV8Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_u32", /*KEEP_STR*/"UiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_u64", /*KEEP_STR*/"UWiV2UWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaddvq_u8", /*KEEP_STR*/"ScV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaesdq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaeseq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaesimcq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vaesmcq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vbsl_v", /*KEEP_STR*/"V8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vbslq_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcage_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcaged_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcageq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcages_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcagt_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcagtd_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcagtq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcagts_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcale_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcaled_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcaleq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcales_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcalt_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcaltd_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcaltq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcalts_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqd_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqs_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqz_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqzd_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqzd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqzd_u64", /*KEEP_STR*/"UWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqzq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vceqzs_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcged_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcged_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcged_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcges_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgez_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgezd_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgezd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgezq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgezs_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtd_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgts_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtz_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtzd_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtzd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtzq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcgtzs_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcled_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcled_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcled_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcles_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclez_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclezd_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclezd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclezq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclezs_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcls_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclsq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltd_f64", /*KEEP_STR*/"UWidd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclts_f32", /*KEEP_STR*/"Uiff", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltz_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltzd_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltzd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltzq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcltzs_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclz_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vclzq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcnt_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcntq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_f16_f32", /*KEEP_STR*/"V8ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_f32_f16", /*KEEP_STR*/"V16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_f32_f64", /*KEEP_STR*/"V8ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_f32_v", /*KEEP_STR*/"V2fV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_f64_f32", /*KEEP_STR*/"V16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_f64_v", /*KEEP_STR*/"V1dV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_n_f32_v", /*KEEP_STR*/"V2fV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_n_f64_v", /*KEEP_STR*/"V1dV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_n_s32_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_n_s64_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_n_u32_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_n_u64_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_s32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_s64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_u32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvt_u64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvta_s32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvta_s64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvta_u32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvta_u64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtad_s64_f64", /*KEEP_STR*/"Wid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtad_u64_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtaq_s32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtaq_s64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtaq_u32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtaq_u64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtas_s32_f32", /*KEEP_STR*/$if, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtas_u32_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_f64_s64", /*KEEP_STR*/"dWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_f64_u64", /*KEEP_STR*/"dUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_n_f64_s64", /*KEEP_STR*/"dWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_n_f64_u64", /*KEEP_STR*/"dUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_n_s64_f64", /*KEEP_STR*/"WidIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_n_u64_f64", /*KEEP_STR*/"UWidIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_s64_f64", /*KEEP_STR*/"Wid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtd_u64_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtm_s32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtm_s64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtm_u32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtm_u64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtmd_s64_f64", /*KEEP_STR*/"Wid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtmd_u64_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtmq_s32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtmq_s64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtmq_u32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtmq_u64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtms_s32_f32", /*KEEP_STR*/$if, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtms_u32_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtn_s32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtn_s64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtn_u32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtn_u64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtnd_s64_f64", /*KEEP_STR*/"Wid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtnd_u64_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtnq_s32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtnq_s64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtnq_u32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtnq_u64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtns_s32_f32", /*KEEP_STR*/$if, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtns_u32_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtp_s32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtp_s64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtp_u32_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtp_u64_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtpd_s64_f64", /*KEEP_STR*/"Wid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtpd_u64_f64", /*KEEP_STR*/"UWid", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtpq_s32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtpq_s64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtpq_u32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtpq_u64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtps_s32_f32", /*KEEP_STR*/$if, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtps_u32_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_f32_v", /*KEEP_STR*/"V4fV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_f64_v", /*KEEP_STR*/"V2dV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_n_f32_v", /*KEEP_STR*/"V4fV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_n_f64_v", /*KEEP_STR*/"V2dV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_n_s32_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_n_s64_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_n_u32_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_n_u64_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_s32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_s64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_u32_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtq_u64_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_f32_s32", /*KEEP_STR*/"fi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_f32_u32", /*KEEP_STR*/"fUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_n_f32_s32", /*KEEP_STR*/"fiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_n_f32_u32", /*KEEP_STR*/"fUiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_n_s32_f32", /*KEEP_STR*/"ifIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_n_u32_f32", /*KEEP_STR*/"UifIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_s32_f32", /*KEEP_STR*/$if, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvts_u32_f32", /*KEEP_STR*/"Uif", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtx_f32_v", /*KEEP_STR*/"V2fV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vcvtxd_f32_f64", /*KEEP_STR*/"fd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdupb_lane_i8", /*KEEP_STR*/"ScV8ScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdupb_laneq_i8", /*KEEP_STR*/"ScV16ScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdupd_lane_f64", /*KEEP_STR*/"dV1dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdupd_lane_i64", /*KEEP_STR*/"UWiV1WiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdupd_laneq_f64", /*KEEP_STR*/"dV2dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdupd_laneq_i64", /*KEEP_STR*/"UWiV2WiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vduph_lane_i16", /*KEEP_STR*/"UsV4sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vduph_laneq_i16", /*KEEP_STR*/"UsV8sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdups_lane_f32", /*KEEP_STR*/"fV2fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdups_lane_i32", /*KEEP_STR*/"UiV2iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdups_laneq_f32", /*KEEP_STR*/"fV4fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vdups_laneq_i32", /*KEEP_STR*/"UiV4iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vext_v", /*KEEP_STR*/"V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vextq_v", /*KEEP_STR*/"V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfma_lane_v", /*KEEP_STR*/"V8ScV8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfma_laneq_v", /*KEEP_STR*/"V8ScV8ScV8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfma_v", /*KEEP_STR*/"V8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmad_lane_f64", /*KEEP_STR*/"dddV1dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmad_laneq_f64", /*KEEP_STR*/"dddV2dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmaq_lane_v", /*KEEP_STR*/"V16ScV16ScV16ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmaq_laneq_v", /*KEEP_STR*/"V16ScV16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmaq_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmas_lane_f32", /*KEEP_STR*/"fffV2fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vfmas_laneq_f32", /*KEEP_STR*/"fffV4fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vget_lane_f32", /*KEEP_STR*/"fV2fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vget_lane_f64", /*KEEP_STR*/"dV1dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vget_lane_i16", /*KEEP_STR*/"UsV4sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vget_lane_i32", /*KEEP_STR*/"UiV2iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vget_lane_i64", /*KEEP_STR*/"UWiV1WiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vget_lane_i8", /*KEEP_STR*/"ScV8ScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vgetq_lane_f32", /*KEEP_STR*/"fV4fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vgetq_lane_f64", /*KEEP_STR*/"dV2dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vgetq_lane_i16", /*KEEP_STR*/"UsV8sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vgetq_lane_i32", /*KEEP_STR*/"UiV4iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vgetq_lane_i64", /*KEEP_STR*/"UWiV2WiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vgetq_lane_i8", /*KEEP_STR*/"ScV16ScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vhadd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vhaddq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vhsub_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vhsubq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1_dup_v", /*KEEP_STR*/"V8ScvC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1_lane_v", /*KEEP_STR*/"V8ScvC*V8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1_v", /*KEEP_STR*/"V8ScvC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1_x2_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1_x3_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1_x4_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1q_dup_v", /*KEEP_STR*/"V16ScvC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1q_lane_v", /*KEEP_STR*/"V16ScvC*V16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1q_v", /*KEEP_STR*/"V16ScvC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1q_x2_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1q_x3_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld1q_x4_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld2_dup_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld2_lane_v", /*KEEP_STR*/"vv*vC*V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld2_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld2q_dup_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld2q_lane_v", /*KEEP_STR*/"vv*vC*V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld2q_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld3_dup_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld3_lane_v", /*KEEP_STR*/"vv*vC*V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld3_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld3q_dup_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld3q_lane_v", /*KEEP_STR*/"vv*vC*V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld3q_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld4_dup_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld4_lane_v", /*KEEP_STR*/"vv*vC*V8ScV8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld4_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld4q_dup_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld4q_lane_v", /*KEEP_STR*/"vv*vC*V16ScV16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vld4q_v", /*KEEP_STR*/"vv*vC*i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vldrq_p128", /*KEEP_STR*/"ULLLivC*", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmax_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxnm_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxnmq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxnmv_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxnmvq_f32", /*KEEP_STR*/"fV4f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxnmvq_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_s16", /*KEEP_STR*/"sV4s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_s32", /*KEEP_STR*/"iV2i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_s8", /*KEEP_STR*/"ScV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_u16", /*KEEP_STR*/"UsV4Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_u32", /*KEEP_STR*/"UiV2Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxv_u8", /*KEEP_STR*/"ScV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_f32", /*KEEP_STR*/"fV4f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_s16", /*KEEP_STR*/"sV8s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_s32", /*KEEP_STR*/"iV4i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_s8", /*KEEP_STR*/"ScV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_u16", /*KEEP_STR*/"UsV8Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_u32", /*KEEP_STR*/"UiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmaxvq_u8", /*KEEP_STR*/"ScV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmin_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminnm_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminnmq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminnmv_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminnmvq_f32", /*KEEP_STR*/"fV4f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminnmvq_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_s16", /*KEEP_STR*/"sV4s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_s32", /*KEEP_STR*/"iV2i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_s8", /*KEEP_STR*/"ScV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_u16", /*KEEP_STR*/"UsV4Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_u32", /*KEEP_STR*/"UiV2Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminv_u8", /*KEEP_STR*/"ScV8Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_f32", /*KEEP_STR*/"fV4f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_s16", /*KEEP_STR*/"sV8s", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_s32", /*KEEP_STR*/"iV4i", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_s8", /*KEEP_STR*/"ScV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_u16", /*KEEP_STR*/"UsV8Us", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_u32", /*KEEP_STR*/"UiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vminvq_u8", /*KEEP_STR*/"ScV16Sc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmovl_v", /*KEEP_STR*/"V16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmovn_v", /*KEEP_STR*/"V8ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmul_lane_v", /*KEEP_STR*/"V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmul_laneq_v", /*KEEP_STR*/"V8ScV8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmul_n_f64", /*KEEP_STR*/"V1dV1dd", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmul_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmull_p64", /*KEEP_STR*/"ULLLiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmull_v", /*KEEP_STR*/"V16ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmulq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmulx_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmulxd_f64", /*KEEP_STR*/$ddd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmulxq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vmulxs_f32", /*KEEP_STR*/$fff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vnegd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpadal_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpadalq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpadd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpaddd_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpaddd_s64", /*KEEP_STR*/"WiV2Wi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpaddd_u64", /*KEEP_STR*/"UWiV2UWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpaddl_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpaddlq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpaddq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpadds_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmax_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxnm_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxnmq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxnmqd_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxnms_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxqd_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmaxs_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmin_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpminnm_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpminnmq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpminnmqd_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpminnms_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpminq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpminqd_f64", /*KEEP_STR*/"dV2d", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vpmins_f32", /*KEEP_STR*/"fV2f", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqabs_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqabsb_s8", /*KEEP_STR*/"ScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqabsd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqabsh_s16", /*KEEP_STR*/"ss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqabsq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqabss_s32", /*KEEP_STR*/$ii, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqadd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddb_s8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddb_u8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddh_u16", /*KEEP_STR*/"UsUsUs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqaddq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqadds_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqadds_u32", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlal_v", /*KEEP_STR*/"V16ScV16ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlalh_lane_s16", /*KEEP_STR*/"iisV4sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlalh_laneq_s16", /*KEEP_STR*/"iisV8sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlalh_s16", /*KEEP_STR*/"iiss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlals_lane_s32", /*KEEP_STR*/"WiWiiV2iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlals_laneq_s32", /*KEEP_STR*/"WiWiiV4iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlals_s32", /*KEEP_STR*/"WiWiii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlsl_v", /*KEEP_STR*/"V16ScV16ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlslh_lane_s16", /*KEEP_STR*/"iisV4sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlslh_laneq_s16", /*KEEP_STR*/"iisV8sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlslh_s16", /*KEEP_STR*/"iiss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlsls_lane_s32", /*KEEP_STR*/"WiWiiV2iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlsls_laneq_s32", /*KEEP_STR*/"WiWiiV4iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmlsls_s32", /*KEEP_STR*/"WiWiii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmulh_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmulhh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmulhq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmulhs_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmull_v", /*KEEP_STR*/"V16ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmullh_s16", /*KEEP_STR*/"iss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqdmulls_s32", /*KEEP_STR*/"Wiii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovn_v", /*KEEP_STR*/"V8ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovnd_s64", /*KEEP_STR*/"iWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovnd_u64", /*KEEP_STR*/"UiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovnh_s16", /*KEEP_STR*/"Scs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovnh_u16", /*KEEP_STR*/"ScUs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovns_s32", /*KEEP_STR*/"si", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovns_u32", /*KEEP_STR*/"UsUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovun_v", /*KEEP_STR*/"V8ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovund_s64", /*KEEP_STR*/"iWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovunh_s16", /*KEEP_STR*/"Scs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqmovuns_s32", /*KEEP_STR*/"si", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqneg_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqnegb_s8", /*KEEP_STR*/"ScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqnegd_s64", /*KEEP_STR*/"WiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqnegh_s16", /*KEEP_STR*/"ss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqnegq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqnegs_s32", /*KEEP_STR*/$ii, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrdmulh_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrdmulhh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrdmulhq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrdmulhs_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshl_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshlb_s8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshlb_u8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshld_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshld_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshlh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshlh_u16", /*KEEP_STR*/"UsUsUs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshlq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshls_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshls_u32", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrn_n_v", /*KEEP_STR*/"V8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrnd_n_s64", /*KEEP_STR*/"iWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrnd_n_u64", /*KEEP_STR*/"UiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrnh_n_s16", /*KEEP_STR*/"ScsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrnh_n_u16", /*KEEP_STR*/"ScUsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrns_n_s32", /*KEEP_STR*/"siIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrns_n_u32", /*KEEP_STR*/"UsUiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrun_n_v", /*KEEP_STR*/"V8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrund_n_s64", /*KEEP_STR*/"iWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshrunh_n_s16", /*KEEP_STR*/"ScsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqrshruns_n_s32", /*KEEP_STR*/"siIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshl_n_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshl_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlb_n_s8", /*KEEP_STR*/"ScScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlb_n_u8", /*KEEP_STR*/"ScScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlb_s8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlb_u8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshld_n_s64", /*KEEP_STR*/"WiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshld_n_u64", /*KEEP_STR*/"UWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshld_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshld_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlh_n_s16", /*KEEP_STR*/"ssIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlh_n_u16", /*KEEP_STR*/"UsUsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlh_u16", /*KEEP_STR*/"UsUsUs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlq_n_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshls_n_s32", /*KEEP_STR*/"iiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshls_n_u32", /*KEEP_STR*/"UiUiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshls_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshls_u32", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlu_n_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlub_n_s8", /*KEEP_STR*/"ScScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlud_n_s64", /*KEEP_STR*/"WiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshluh_n_s16", /*KEEP_STR*/"ssIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshluq_n_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshlus_n_s32", /*KEEP_STR*/"iiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrn_n_v", /*KEEP_STR*/"V8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrnd_n_s64", /*KEEP_STR*/"iWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrnd_n_u64", /*KEEP_STR*/"UiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrnh_n_s16", /*KEEP_STR*/"ScsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrnh_n_u16", /*KEEP_STR*/"ScUsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrns_n_s32", /*KEEP_STR*/"siIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrns_n_u32", /*KEEP_STR*/"UsUiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrun_n_v", /*KEEP_STR*/"V8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrund_n_s64", /*KEEP_STR*/"iWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshrunh_n_s16", /*KEEP_STR*/"ScsIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqshruns_n_s32", /*KEEP_STR*/"siIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsub_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubb_s8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubb_u8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubh_u16", /*KEEP_STR*/"UsUsUs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubs_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqsubs_u32", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl1_v", /*KEEP_STR*/"V8ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl1q_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl2_v", /*KEEP_STR*/"V8ScV16ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl2q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl3_v", /*KEEP_STR*/"V8ScV16ScV16ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl3q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl4_v", /*KEEP_STR*/"V8ScV16ScV16ScV16ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbl4q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx1_v", /*KEEP_STR*/"V8ScV8ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx1q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx2_v", /*KEEP_STR*/"V8ScV8ScV16ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx2q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx3_v", /*KEEP_STR*/"V8ScV8ScV16ScV16ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx3q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx4_v", /*KEEP_STR*/"V8ScV8ScV16ScV16ScV16ScV16ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vqtbx4q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vraddhn_v", /*KEEP_STR*/"V8ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrbit_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrbitq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpe_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecped_f64", /*KEEP_STR*/$dd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpeq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpes_f32", /*KEEP_STR*/$ff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecps_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpsd_f64", /*KEEP_STR*/$ddd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpsq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpss_f32", /*KEEP_STR*/$fff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpxd_f64", /*KEEP_STR*/$dd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrecpxs_f32", /*KEEP_STR*/$ff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrhadd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrhaddq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrnd_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrnda_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndaq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndi_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndiq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndm_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndmq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndn_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndnq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndp_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndpq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndx_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrndxq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshl_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshld_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshld_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshlq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshr_n_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshrd_n_s64", /*KEEP_STR*/"WiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshrd_n_u64", /*KEEP_STR*/"UWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshrn_n_v", /*KEEP_STR*/"V8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrshrq_n_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrte_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrted_f64", /*KEEP_STR*/$dd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrteq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrtes_f32", /*KEEP_STR*/$ff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrts_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrtsd_f64", /*KEEP_STR*/$ddd, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrtsq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsqrtss_f32", /*KEEP_STR*/$fff, /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsra_n_v", /*KEEP_STR*/"V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsrad_n_s64", /*KEEP_STR*/"WiWiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsrad_n_u64", /*KEEP_STR*/"UWiUWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsraq_n_v", /*KEEP_STR*/"V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vrsubhn_v", /*KEEP_STR*/"V8ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vset_lane_f32", /*KEEP_STR*/"V2ffV2fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vset_lane_f64", /*KEEP_STR*/"V1ddV1dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vset_lane_i16", /*KEEP_STR*/"V4ssV4sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vset_lane_i32", /*KEEP_STR*/"V2iiV2iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vset_lane_i64", /*KEEP_STR*/"V1WiWiV1WiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vset_lane_i8", /*KEEP_STR*/"V8ScScV8ScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsetq_lane_f32", /*KEEP_STR*/"V4ffV4fIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsetq_lane_f64", /*KEEP_STR*/"V2ddV2dIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsetq_lane_i16", /*KEEP_STR*/"V8ssV8sIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsetq_lane_i32", /*KEEP_STR*/"V4iiV4iIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsetq_lane_i64", /*KEEP_STR*/"V2WiWiV2WiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsetq_lane_i8", /*KEEP_STR*/"V16ScScV16ScIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha1cq_u32", /*KEEP_STR*/"V4iV4UiUiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha1h_u32", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha1mq_u32", /*KEEP_STR*/"V4iV4UiUiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha1pq_u32", /*KEEP_STR*/"V4iV4UiUiV4Ui", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha1su0q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha1su1q_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha256h2q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha256hq_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha256su0q_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsha256su1q_v", /*KEEP_STR*/"V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshl_n_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshl_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshld_n_s64", /*KEEP_STR*/"WiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshld_n_u64", /*KEEP_STR*/"UWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshld_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshld_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshll_n_v", /*KEEP_STR*/"V16ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshlq_n_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshlq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshr_n_v", /*KEEP_STR*/"V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshrd_n_s64", /*KEEP_STR*/"WiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshrd_n_u64", /*KEEP_STR*/"UWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshrn_n_v", /*KEEP_STR*/"V8ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vshrq_n_v", /*KEEP_STR*/"V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsli_n_v", /*KEEP_STR*/"V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vslid_n_s64", /*KEEP_STR*/"WiWiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vslid_n_u64", /*KEEP_STR*/"UWiUWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsliq_n_v", /*KEEP_STR*/"V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqadd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqaddb_u8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqaddd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqaddh_u16", /*KEEP_STR*/"UsUsUs", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqaddq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqadds_u32", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqrt_v", /*KEEP_STR*/"V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsqrtq_v", /*KEEP_STR*/"V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsra_n_v", /*KEEP_STR*/"V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsrad_n_s64", /*KEEP_STR*/"WiWiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsrad_n_u64", /*KEEP_STR*/"UWiUWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsraq_n_v", /*KEEP_STR*/"V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsri_n_v", /*KEEP_STR*/"V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsrid_n_s64", /*KEEP_STR*/"WiWiWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsrid_n_u64", /*KEEP_STR*/"UWiUWiUWiIi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsriq_n_v", /*KEEP_STR*/"V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1_lane_v", /*KEEP_STR*/"vv*V8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1_v", /*KEEP_STR*/"vv*V8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1_x2_v", /*KEEP_STR*/"vv*V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1_x3_v", /*KEEP_STR*/"vv*V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1_x4_v", /*KEEP_STR*/"vv*V8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1q_lane_v", /*KEEP_STR*/"vv*V16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1q_v", /*KEEP_STR*/"vv*V16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1q_x2_v", /*KEEP_STR*/"vv*V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1q_x3_v", /*KEEP_STR*/"vv*V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst1q_x4_v", /*KEEP_STR*/"vv*V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst2_lane_v", /*KEEP_STR*/"vv*V8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst2_v", /*KEEP_STR*/"vv*V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst2q_lane_v", /*KEEP_STR*/"vv*V16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst2q_v", /*KEEP_STR*/"vv*V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst3_lane_v", /*KEEP_STR*/"vv*V8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst3_v", /*KEEP_STR*/"vv*V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst3q_lane_v", /*KEEP_STR*/"vv*V16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst3q_v", /*KEEP_STR*/"vv*V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst4_lane_v", /*KEEP_STR*/"vv*V8ScV8ScV8ScV8ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst4_v", /*KEEP_STR*/"vv*V8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst4q_lane_v", /*KEEP_STR*/"vv*V16ScV16ScV16ScV16ScIii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vst4q_v", /*KEEP_STR*/"vv*V16ScV16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vstrq_p128", /*KEEP_STR*/"vv*ULLLi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsubd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsubd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vsubhn_v", /*KEEP_STR*/"V8ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbl1_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbl2_v", /*KEEP_STR*/"V8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbl3_v", /*KEEP_STR*/"V8ScV8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbl4_v", /*KEEP_STR*/"V8ScV8ScV8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbx1_v", /*KEEP_STR*/"V8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbx2_v", /*KEEP_STR*/"V8ScV8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbx3_v", /*KEEP_STR*/"V8ScV8ScV8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtbx4_v", /*KEEP_STR*/"V8ScV8ScV8ScV8ScV8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtrn_v", /*KEEP_STR*/"vv*V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtrnq_v", /*KEEP_STR*/"vv*V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtst_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtstd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtstd_u64", /*KEEP_STR*/"UWiUWiUWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vtstq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuqadd_v", /*KEEP_STR*/"V8ScV8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuqaddb_s8", /*KEEP_STR*/"ScScSc", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuqaddd_s64", /*KEEP_STR*/"WiWiWi", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuqaddh_s16", /*KEEP_STR*/"sss", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuqaddq_v", /*KEEP_STR*/"V16ScV16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuqadds_s32", /*KEEP_STR*/"iii", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuzp_v", /*KEEP_STR*/"vv*V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vuzpq_v", /*KEEP_STR*/"vv*V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vzip_v", /*KEEP_STR*/"vv*V8ScV8Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_neon_vzipq_v", /*KEEP_STR*/"vv*V16ScV16Sci", /*KEEP_STR*/$n, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    //===----------------------------------------------------------------------===//
    //
    // This file defines the AArch64-specific builtin function database.  Users of
    // this file must define the BUILTIN macro to make use of this information.
    //
    //===----------------------------------------------------------------------===//
    
    // The format of this database matches clang/Basic/Builtins.def.
    
    // In libgcc
    new Builtin.Info(/*KEEP_STR*/"__clear_cache", /*KEEP_STR*/"vv*v*", /*KEEP_STR*/$i, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldrex", /*KEEP_STR*/$vDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldaex", /*KEEP_STR*/$vDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_strex", /*KEEP_STR*/$iDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_stlex", /*KEEP_STR*/$iDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_clrex", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Bit manipulation
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rbit", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rbit64", /*KEEP_STR*/"LUiLUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // HINT
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_nop", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_yield", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wfe", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wfi", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_sev", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_sevl", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // CRC32
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32b", /*KEEP_STR*/"UiUiUc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32cb", /*KEEP_STR*/"UiUiUc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32h", /*KEEP_STR*/"UiUiUs", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32ch", /*KEEP_STR*/"UiUiUs", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32w", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32cw", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32d", /*KEEP_STR*/"UiUiLUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32cd", /*KEEP_STR*/"UiUiLUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Memory barrier
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_dmb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_dsb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_isb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Prefetch
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_prefetch", /*KEEP_STR*/"vvC*UiUiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // System Registers
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rsr", /*KEEP_STR*/"UicC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rsr64", /*KEEP_STR*/"LUicC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rsrp", /*KEEP_STR*/"v*cC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wsr", /*KEEP_STR*/"vcC*Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wsr64", /*KEEP_STR*/"vcC*LUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wsrp", /*KEEP_STR*/"vcC*vC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  
  private std.string ABI;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::AArch64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5666,
   FQN="(anonymous namespace)::AArch64TargetInfo::AArch64TargetInfo", NM="_ZN12_GLOBAL__N_117AArch64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public AArch64TargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : TargetInfo(Triple), ABI("aapcs")*/ 
    //START JInit
    super(_Triple);
    this.ABI = new std.string(/*KEEP_STR*/"aapcs");
    //END JInit
    if (getTriple().getOS() == Triple.OSType.NetBSD) {
      WCharType = IntType.SignedInt;
      
      // NetBSD apparently prefers consistency across ARM targets to consistency
      // across 64-bit targets.
      Int64Type = IntType.SignedLongLong;
      IntMaxType = IntType.SignedLongLong;
    } else {
      WCharType = IntType.UnsignedInt;
      Int64Type = IntType.SignedLong;
      IntMaxType = IntType.SignedLong;
    }
    
    LongWidth = LongAlign = PointerWidth = PointerAlign = 64;
    MaxVectorAlign = 128;
    MaxAtomicInlineWidth = $int2uchar(128);
    MaxAtomicPromoteWidth = $int2uchar(128);
    
    LongDoubleWidth = LongDoubleAlign = SuitableAlign = $int2uchar(128);
    LongDoubleFormat = $AddrOf(APFloat.IEEEquad);
    
    // {} in inline assembly are neon specifiers, not assembly variant
    // specifiers.
    NoAsmVariants = true;
    
    // AAPCS gives rules for bitfields. 7.1.7 says: "The container type
    // contributes to the alignment of the containing aggregate in the same way
    // a plain (non bit-field) member of that type would, without exception for
    // zero-sized or anonymous bit-fields."
    assert (UseBitFieldTypeAlignment) : "bitfields affect type alignment";
    UseZeroLengthBitfieldAlignment = true;
    
    // AArch64 targets default to using the ARM C++ ABI.
    TheCXXABI.set(TargetCXXABI.Kind.GenericAArch64);
    if (_Triple.getOS() == Triple.OSType.Linux
       || _Triple.getOS() == Triple.OSType.UnknownOS) {
      this.MCountName = $tryClone($eq_string$C_T(Opts.EABIVersion, /*KEEP_STR*/"gnu") ? $("\001_mcount") : $("mcount"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5708,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5324,
   FQN="(anonymous namespace)::AArch64TargetInfo::getABI", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo6getABIEv")
  //</editor-fold>
  @Override public StringRef getABI() /*const*//* override*/ {
    return new StringRef(ABI);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::setABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5709,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5325,
   FQN="(anonymous namespace)::AArch64TargetInfo::setABI", NM="_ZN12_GLOBAL__N_117AArch64TargetInfo6setABIERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfo6setABIERKSs")
  //</editor-fold>
  @Override public boolean setABI(/*const*/std.string/*&*/ Name)/* override*/ {
    if ($noteq_string$C_T(Name, /*KEEP_STR*/"aapcs") && $noteq_string$C_T(Name, /*KEEP_STR*/"darwinpcs")) {
      return false;
    }
    
    ABI.$assign(Name);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5717,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5333,
   FQN="(anonymous namespace)::AArch64TargetInfo::setCPU", NM="_ZN12_GLOBAL__N_117AArch64TargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    boolean CPUKnown = new StringSwitchBool(Name).
        Case(/*KEEP_STR*/"generic", true).
        Cases(/*KEEP_STR*/"cortex-a53", /*KEEP_STR*/"cortex-a57", /*KEEP_STR*/"cortex-a72", 
        /*KEEP_STR*/"cortex-a35", /*KEEP_STR*/"exynos-m1", true).
        Case(/*KEEP_STR*/"cortex-a73", true).
        Case(/*KEEP_STR*/"cyclone", true).
        Case(/*KEEP_STR*/"kryo", true).
        Case(/*KEEP_STR*/"vulcan", true).
        Default(false);
    return CPUKnown;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5730,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5343,
   FQN="(anonymous namespace)::AArch64TargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    // Target identification.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__aarch64__"));
    
    // Target properties.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_LP64"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__LP64__"));
    
    // ACLE predefines. Many can only have one possible value on v8 AArch64.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ACLE"), new Twine(/*KEEP_STR*/"200"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH"), new Twine(/*KEEP_STR*/$8));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_PROFILE"), new Twine(/*KEEP_STR*/"'A'"));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_64BIT_STATE"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_PCS_AAPCS64"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_ISA_A64"), new Twine(/*KEEP_STR*/$1));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_CLZ"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_FMA"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_LDREX"), new Twine(/*KEEP_STR*/"0xF"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_IDIV"), new Twine(/*KEEP_STR*/$1)); // As specified in ACLE
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_DIV")); // For backwards compatibility
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_NUMERIC_MAXMIN"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_DIRECTED_ROUNDING"), new Twine(/*KEEP_STR*/$1));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ALIGN_MAX_STACK_PWR"), new Twine(/*KEEP_STR*/$4));
    
    // 0xe implies support for half, single and double precision operations.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP"), new Twine(/*KEEP_STR*/"0xE"));
    
    // PCS specifies this for SysV variants, which is all we support. Other ABIs
    // may choose __ARM_FP16_FORMAT_ALTERNATIVE.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP16_FORMAT_IEEE"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP16_ARGS"), new Twine(/*KEEP_STR*/$1));
    if (Opts.UnsafeFPMath) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP_FAST"), new Twine(/*KEEP_STR*/$1));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_SIZEOF_WCHAR_T"), new Twine(Opts.ShortWChar ? $2 : $4));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_SIZEOF_MINIMAL_ENUM"), 
        new Twine(Opts.ShortEnums ? $1 : $4));
    if (FPU == FPUModeEnum.NeonMode.getValue()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_NEON"), new Twine(/*KEEP_STR*/$1));
      // 64-bit NEON supports half, single and double precision operations.
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_NEON_FP"), new Twine(/*KEEP_STR*/"0xE"));
    }
    if ((CRC != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_CRC32"), new Twine(/*KEEP_STR*/$1));
    }
    if ((Crypto != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_CRYPTO"), new Twine(/*KEEP_STR*/$1));
    }
    if ((Unaligned != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_UNALIGNED"), new Twine(/*KEEP_STR*/$1));
    }
    if ((V8_1A != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_QRDMX"), new Twine(/*KEEP_STR*/$1));
    }
    
    // All of the __sync_(bool|val)_compare_and_swap_(1|2|4|8) builtins work.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5799,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5412,
   FQN="(anonymous namespace)::AArch64TargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        AArch64.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5804,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5417,
   FQN="(anonymous namespace)::AArch64TargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"aarch64")
       || $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"arm64")
       || $eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"arm")
       || ($eq_StringRef(/*NO_COPY*/Feature, /*STRINGREF_STR*/"neon") && FPU == FPUModeEnum.NeonMode.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5811,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5424,
   FQN="(anonymous namespace)::AArch64TargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_117AArch64TargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    FPU = FPUModeEnum.FPUMode.getValue();
    CRC = 0;
    Crypto = 0;
    Unaligned = 1;
    V8_1A = 0;
    
    for (/*const*/std.string/*&*/ Feature : Features) {
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+neon")) {
        FPU = FPUModeEnum.NeonMode.getValue();
      }
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+crc")) {
        CRC = 1;
      }
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+crypto")) {
        Crypto = 1;
      }
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+strict-align")) {
        Unaligned = 0;
      }
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+v8.1a")) {
        V8_1A = 1;
      }
    }
    
    setDataLayout();
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5837,
   FQN="(anonymous namespace)::AArch64TargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     case CC_C:
     case CC_Swift:
     case CC_PreserveMost:
     case CC_PreserveAll:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::isCLZForZeroUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5849,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5450,
   FQN="(anonymous namespace)::AArch64TargetInfo::isCLZForZeroUndef", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo17isCLZForZeroUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo17isCLZForZeroUndefEv")
  //</editor-fold>
  @Override public boolean isCLZForZeroUndef() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5851,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5452,
   FQN="(anonymous namespace)::AArch64TargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return TargetInfo.BuiltinVaListKind.AArch64ABIBuiltinVaList;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5966,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5567,
   FQN="(anonymous namespace)::AArch64TargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5979,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5580,
   FQN="(anonymous namespace)::AArch64TargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegAliases);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5858,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5459,
   FQN="(anonymous namespace)::AArch64TargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      return false;
     case 'w': // Floating point and SIMD registers (V0-V31)
      Info.setAllowsRegister();
      return true;
     case 'I': // Constant that can be used with an ADD instruction
     case 'J': // Constant that can be used with a SUB instruction
     case 'K': // Constant that can be used with a 32-bit logical instruction
     case 'L': // Constant that can be used with a 64-bit logical instruction
     case 'M': // Constant that can be used as a 32-bit MOV immediate
     case 'N': // Constant that can be used as a 64-bit MOV immediate
     case 'Y': // Floating point constant zero
     case 'Z': // Integer constant zero
      return true;
     case 'Q': // A memory reference with base register and no offset
      Info.setAllowsMemory();
      return true;
     case 'S': // A symbolic address
      Info.setAllowsRegister();
      return true;
     case 'U':
      // Ump: A memory address suitable for ldp/stp in SI, DI, SF and DF modes.
      // Utf: A memory address suitable for ldp/stp in TF mode.
      // Usa: An absolute symbolic address.
      // Ush: The high part (bits 32:12) of a pc-relative symbolic address.
      throw new llvm_unreachable("FIXME: Unimplemented support for U* constraints.");
     case 'z': // Zero register, wzr or xzr
      Info.setAllowsRegister();
      return true;
     case 'x': // Floating point and SIMD registers (V0-V15)
      Info.setAllowsRegister();
      return true;
    }
    // JAVA: unreachable
//    return false; 
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::validateConstraintModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5897,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5498,
   FQN="(anonymous namespace)::AArch64TargetInfo::validateConstraintModifier", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo26validateConstraintModifierEN4llvm9StringRefEcjRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo26validateConstraintModifierEN4llvm9StringRefEcjRSs")
  //</editor-fold>
  @Override public boolean validateConstraintModifier(StringRef Constraint, /*char*/byte Modifier, /*uint*/int Size, 
                            std.string/*&*/ SuggestedModifier) /*const*//* override*/ {
    // Strip off constraint modifiers.
    while (Constraint.$at(0) == $$EQ || Constraint.$at(0) == $$PLUS || Constraint.$at(0) == $$AMP) {
      Constraint.$assignMove(Constraint.substr(1));
    }
    switch (Constraint.$at(0)) {
     default:
      return true;
     case 'z':
     case 'r':
      {
        switch (Modifier) {
         case 'x':
         case 'w':
          // For now assume that the person knows what they're
          // doing with the modifier.
          return true;
         default:
          // By default an 'r' constraint will be in the 'x'
          // registers.
          if (Size == 64) {
            return true;
          }
          
          SuggestedModifier.$assign(/*KEEP_STR*/"w");
          return false;
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5928,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5529,
   FQN="(anonymous namespace)::AArch64TargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    return $EMPTY;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5930,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5531,
   FQN="(anonymous namespace)::AArch64TargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_117AArch64TargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117AArch64TargetInfo23getEHDataRegisterNumberEj")
  //</editor-fold>
  @Override public int getEHDataRegisterNumber(/*uint*/int RegNo) /*const*//* override*/ {
    if (RegNo == 0) {
      return 0;
    }
    if (RegNo == 1) {
      return 1;
    }
    return -1;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64TargetInfo::~AArch64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5645,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5264,
   FQN="(anonymous namespace)::AArch64TargetInfo::~AArch64TargetInfo", NM="_ZN12_GLOBAL__N_117AArch64TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117AArch64TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    ABI.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "FPU=" + FPU // NOI18N
              + ", CRC=" + CRC // NOI18N
              + ", Crypto=" + Crypto // NOI18N
              + ", Unaligned=" + Unaligned // NOI18N
              + ", V8_1A=" + V8_1A // NOI18N
              + ", ABI=" + ABI // NOI18N
              + super.toString(); // NOI18N
  }
}
