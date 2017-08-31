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
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.*;
import org.clang.basic.target.TargetCXXABI;
import org.llvm.support.target.ARM;
import org.llvm.support.target.ARM.*;
import org.clang.basic.target.TargetInfo.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4553,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4200,
 FQN="(anonymous namespace)::ARMTargetInfo", NM="_ZN12_GLOBAL__N_113ARMTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfoE")
//</editor-fold>
public class ARMTargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  // Possible FPU choices.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::FPUMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4555,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4202,
   FQN="(anonymous namespace)::ARMTargetInfo::FPUMode", NM="_ZN12_GLOBAL__N_113ARMTargetInfo7FPUModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo7FPUModeE")
  //</editor-fold>
  private static final class/*enum*/ FPUMode {
    public static final /*uint*/int VFP2FPU = (1 << 0);
    public static final /*uint*/int VFP3FPU = (1 << 1);
    public static final /*uint*/int VFP4FPU = (1 << 2);
    public static final /*uint*/int NeonFPU = (1 << 3);
    public static final /*uint*/int FPARMV8 = (1 << 4);
  };
  
  // Possible HWDiv features.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::HWDivMode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4564,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4211,
   FQN="(anonymous namespace)::ARMTargetInfo::HWDivMode", NM="_ZN12_GLOBAL__N_113ARMTargetInfo9HWDivModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo9HWDivModeE")
  //</editor-fold>
  private static final class/*enum*/ HWDivMode {
    public static final /*uint*/int HWDivThumb = (1 << 0);
    public static final /*uint*/int HWDivARM = (1 << 1);
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::FPUModeIsVFP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4569,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4216,
   FQN="(anonymous namespace)::ARMTargetInfo::FPUModeIsVFP", NM="_ZN12_GLOBAL__N_113ARMTargetInfo12FPUModeIsVFPENS0_7FPUModeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo12FPUModeIsVFPENS0_7FPUModeE")
  //</editor-fold>
  private static boolean FPUModeIsVFP(/*FPUMode*//*uint*/int Mode) {
    return ((Mode & (FPUMode.VFP2FPU | FPUMode.VFP3FPU | FPUMode.VFP4FPU | FPUMode.NeonFPU | FPUMode.FPARMV8)) != 0);
  }

  
  private static /*const*/ TargetInfo.GCCRegAlias GCCRegAliases[] = new /*const*/ TargetInfo.GCCRegAlias [/*16*/] {
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a1")}, $("r0")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a2")}, $("r1")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a3")}, $("r2")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("a4")}, $("r3")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v1")}, $("r4")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v2")}, $("r5")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v3")}, $("r6")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v4")}, $("r7")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v5")}, $("r8")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("v6"), $("rfp")}, $("r9")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("sl")}, $("r10")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("fp")}, $("r11")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("ip")}, $("r12")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r13")}, $("sp")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r14")}, $("lr")), 
    new TargetInfo.GCCRegAlias(new /*const*/char$ptr/*char P*//*const*/ [/*5*/] {$("r15")}, $("pc"))
  };
  private static /*const*/char$ptr/*char P*//*const*/ GCCRegNames[] = (new /*const*/char$ptr/*char P*//*const*/ [/*96*/] {
    // Integer registers
    $("r0"), $("r1"), $("r2"), $("r3"), $("r4"), $("r5"), $("r6"), $("r7"), 
    $("r8"), $("r9"), $("r10"), $("r11"), $("r12"), $("sp"), $("lr"), $("pc"), 
    
    // Float registers
    $("s0"), $("s1"), $("s2"), $("s3"), $("s4"), $("s5"), $("s6"), $("s7"), 
    $("s8"), $("s9"), $("s10"), $("s11"), $("s12"), $("s13"), $("s14"), $("s15"), 
    $("s16"), $("s17"), $("s18"), $("s19"), $("s20"), $("s21"), $("s22"), $("s23"), 
    $("s24"), $("s25"), $("s26"), $("s27"), $("s28"), $("s29"), $("s30"), $("s31"), 
    
    // Double registers
    $("d0"), $("d1"), $("d2"), $("d3"), $("d4"), $("d5"), $("d6"), $("d7"), 
    $("d8"), $("d9"), $("d10"), $("d11"), $("d12"), $("d13"), $("d14"), $("d15"), 
    $("d16"), $("d17"), $("d18"), $("d19"), $("d20"), $("d21"), $("d22"), $("d23"), 
    $("d24"), $("d25"), $("d26"), $("d27"), $("d28"), $("d29"), $("d30"), $("d31"), 
    
    // Quad registers
    $("q0"), $("q1"), $("q2"), $("q3"), $("q4"), $("q5"), $("q6"), $("q7"), 
    $("q8"), $("q9"), $("q10"), $("q11"), $("q12"), $("q13"), $("q14"), $("q15")
  });
  
  private std.string ABI;
  
  private std.string CPU;
  
  private StringRef CPUProfile;
  private StringRef CPUAttr;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4581,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4228,
   FQN="(anonymous namespace)::ARMTargetInfo::(anonymous)", NM="_ZN12_GLOBAL__N_113ARMTargetInfoE_Unnamed_enum2",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfoE_Unnamed_enum2")
  //</editor-fold>
  private enum Unnamed_enum2 implements Native.ComparableLower {
    FP_Default(0),
    FP_VFP(FP_Default.getValue() + 1),
    FP_Neon(FP_VFP.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static Unnamed_enum2 valueOf(int val) {
      Unnamed_enum2 out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final Unnamed_enum2[] VALUES;
      private static final Unnamed_enum2[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (Unnamed_enum2 kind : Unnamed_enum2.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new Unnamed_enum2[min < 0 ? (1-min) : 0];
        VALUES = new Unnamed_enum2[max >= 0 ? (1+max) : 0];
        for (Unnamed_enum2 kind : Unnamed_enum2.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private Unnamed_enum2(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((Unnamed_enum2)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((Unnamed_enum2)obj).value);}
    //</editor-fold>
  };
  
  private Unnamed_enum2 FPMath;
  
  private /*uint*/int ArchISA;
  private /*uint*/int _ArchKind/* = ARM::AK_ARMV4T*/;
  private /*uint*/int ArchProfile;
  private /*uint*/int ArchVersion;
  
  private /*JBYTE unsigned int*/ byte FPU /*: 5*/;
  
  private /*JBIT unsigned int*/ boolean IsAAPCS /*: 1*/;
  private /*JBYTE unsigned int*/ byte HWDiv /*: 2*/;
  
  // Initialized via features.
  private /*JBIT unsigned int*/ boolean SoftFloat /*: 1*/;
  private /*JBIT unsigned int*/ boolean SoftFloatABI /*: 1*/;
  
  private /*JBIT unsigned int*/ boolean CRC /*: 1*/;
  private /*JBIT unsigned int*/ boolean Crypto /*: 1*/;
  private /*JBIT unsigned int*/ boolean DSP /*: 1*/;
  private /*JBIT unsigned int*/ boolean Unaligned /*: 1*/;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4606,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4253,
   FQN="(anonymous namespace)::ARMTargetInfo::(anonymous)", NM="_ZN12_GLOBAL__N_113ARMTargetInfoE_Unnamed_enum3",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfoE_Unnamed_enum3")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int LDREX_B = (1 << 0); /// byte (8-bit)
    public static final /*uint*/int LDREX_H = (1 << 1); /// half (16-bit)
    public static final /*uint*/int LDREX_W = (1 << 2); /// word (32-bit)
    public static final /*uint*/int LDREX_D = (1 << 3); /// double (64-bit)
  /*}*/;
  
  private /*uint32_t*/int LDREX;
  
  // ACLE 6.5.1 Hardware floating point
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::(anonymous)">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4616,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4263,
   FQN="(anonymous namespace)::ARMTargetInfo::(anonymous)", NM="_ZN12_GLOBAL__N_113ARMTargetInfoE_Unnamed_enum4",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfoE_Unnamed_enum4")
  //</editor-fold>
  /*enum ANONYMOUS_INT_CONSTANTS {*/
    public static final /*uint*/int HW_FP_HP = (1 << 1); /// half (16-bit)
    public static final /*uint*/int HW_FP_SP = (1 << 2); /// single (32-bit)
    public static final /*uint*/int HW_FP_DP = (1 << 3); /// double (64-bit)
  /*}*/;
  private /*uint32_t*/int HW_FP;
  
  private static /*const*/ Builtin.Info BuiltinInfo[] = new /*const*/ Builtin.Info [/*735*/] {
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
    
    // In libgcc
    new Builtin.Info(/*KEEP_STR*/"__clear_cache", /*KEEP_STR*/"vv*v*", /*KEEP_STR*/$i, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Saturating arithmetic
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_qadd", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_qsub", /*KEEP_STR*/"iii", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ssat", /*KEEP_STR*/"iiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_usat", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Bit manipulation
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rbit", /*KEEP_STR*/"UiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Store and load exclusive
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldrexd", /*KEEP_STR*/"LLUiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_strexd", /*KEEP_STR*/"iLLUiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldrex", /*KEEP_STR*/$vDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldaex", /*KEEP_STR*/$vDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_strex", /*KEEP_STR*/$iDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_stlex", /*KEEP_STR*/$iDOT, /*KEEP_STR*/$t, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_clrex", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // VFP
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_get_fpscr", /*KEEP_STR*/"Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_set_fpscr", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_vcvtr_f", /*KEEP_STR*/"ffi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_vcvtr_d", /*KEEP_STR*/"fdi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Coprocessor
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldc", /*KEEP_STR*/"vUIiUIivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldcl", /*KEEP_STR*/"vUIiUIivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldc2", /*KEEP_STR*/"vUIiUIivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_ldc2l", /*KEEP_STR*/"vUIiUIivC*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_stc", /*KEEP_STR*/"vUIiUIiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_stcl", /*KEEP_STR*/"vUIiUIiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_stc2", /*KEEP_STR*/"vUIiUIiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_stc2l", /*KEEP_STR*/"vUIiUIiv*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_cdp", /*KEEP_STR*/"vUIiUIiUIiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_cdp2", /*KEEP_STR*/"vUIiUIiUIiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mcr", /*KEEP_STR*/"vUIiUIiUiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mcr2", /*KEEP_STR*/"vUIiUIiUiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mrc", /*KEEP_STR*/"UiUIiUIiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mrc2", /*KEEP_STR*/"UiUIiUIiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mcrr", /*KEEP_STR*/"vUIiUIiLLUiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mcrr2", /*KEEP_STR*/"vUIiUIiLLUiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mrrc", /*KEEP_STR*/"LLUiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_mrrc2", /*KEEP_STR*/"LLUiUIiUIiUIi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // CRC32
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32b", /*KEEP_STR*/"UiUiUc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32cb", /*KEEP_STR*/"UiUiUc", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32h", /*KEEP_STR*/"UiUiUs", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32ch", /*KEEP_STR*/"UiUiUs", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32w", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32cw", /*KEEP_STR*/"UiUiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32d", /*KEEP_STR*/"UiUiLLUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_crc32cd", /*KEEP_STR*/"UiUiLLUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // HINT
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_nop", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_yield", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wfe", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wfi", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_sev", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_sevl", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_dbg", /*KEEP_STR*/"vUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Data barrier
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_dmb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_dsb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_isb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // Prefetch
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_prefetch", /*KEEP_STR*/"vvC*UiUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // System registers (ACLE)
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rsr", /*KEEP_STR*/"UicC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rsr64", /*KEEP_STR*/"LLUicC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_rsrp", /*KEEP_STR*/"v*cC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wsr", /*KEEP_STR*/"vcC*Ui", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wsr64", /*KEEP_STR*/"vcC*LLUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__builtin_arm_wsrp", /*KEEP_STR*/"vcC*vC*", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    
    // MSVC
    new Builtin.Info(/*KEEP_STR*/"__emit", /*KEEP_STR*/"vIUiC", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__yield", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__wfe", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__wfi", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__sev", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__sevl", /*KEEP_STR*/$v, /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__dmb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__dsb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__isb", /*KEEP_STR*/"vUi", /*KEEP_STR*/$nc, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"__ldrexd", /*KEEP_STR*/"WiWiCD*", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"_MoveFromCoprocessor", /*KEEP_STR*/"UiIUiIUiIUiIUiIUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"_MoveFromCoprocessor2", /*KEEP_STR*/"UiIUiIUiIUiIUiIUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"_MoveToCoprocessor", /*KEEP_STR*/"vUiIUiIUiIUiIUiIUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null), 
    new Builtin.Info(/*KEEP_STR*/"_MoveToCoprocessor2", /*KEEP_STR*/"vUiIUiIUiIUiIUiIUi", /*KEEP_STR*/$EMPTY, /*NULL*/(/*const*/char$ptr/*char P*/ )null, LanguageID.ALL_MS_LANGUAGES, (/*const*/char$ptr/*char P*/ )null)
  };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setABIAAPCS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4625,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4272,
   FQN="(anonymous namespace)::ARMTargetInfo::setABIAAPCS", NM="_ZN12_GLOBAL__N_113ARMTargetInfo11setABIAAPCSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo11setABIAAPCSEv")
  //</editor-fold>
  private void setABIAAPCS() {
    IsAAPCS = true;
    
    DoubleAlign = LongLongAlign = LongDoubleAlign = SuitableAlign = 64;
    /*const*/ Triple /*&*/ T = getTriple();
    
    // size_t is unsigned long on MachO-derived environments, NetBSD and Bitrig.
    if (T.isOSBinFormatMachO() || T.getOS() == Triple.OSType.NetBSD
       || T.getOS() == Triple.OSType.Bitrig) {
      SizeType = IntType.UnsignedLong;
    } else {
      SizeType = IntType.UnsignedInt;
    }
    switch (T.getOS()) {
     case NetBSD:
      WCharType = IntType.SignedInt;
      break;
     case Win32:
      WCharType = IntType.UnsignedShort;
      break;
     case Linux:
     default:
      // AAPCS 7.1.1, ARM-Linux ABI 2.4: type of wchar_t is unsigned int.
      WCharType = IntType.UnsignedInt;
      break;
    }
    
    UseBitFieldTypeAlignment = true;
    
    ZeroLengthBitfieldBoundary = 0;
    
    // Thumb1 add sp, #imm requires the immediate value be multiple of 4,
    // so set preferred for small types to 32.
    if (T.isOSBinFormatMachO()) {
      resetDataLayout(new StringRef(BigEndian ? $("E-m:o-p:32:32-i64:64-v128:64:128-a:0:32-n32-S64") : $("e-m:o-p:32:32-i64:64-v128:64:128-a:0:32-n32-S64")));
    } else if (T.isOSWindows()) {
      assert (!BigEndian) : "Windows on ARM does not support big endian";
      resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:w-p:32:32-i64:64-v128:64:128-a:0:32-n32-S64"));
    } else if (T.isOSNaCl()) {
      assert (!BigEndian) : "NaCl on ARM does not support big endian";
      resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:e-p:32:32-i64:64-v128:64:128-a:0:32-n32-S128"));
    } else {
      resetDataLayout(new StringRef(BigEndian ? $("E-m:e-p:32:32-i64:64-v128:64:128-a:0:32-n32-S64") : $("e-m:e-p:32:32-i64:64-v128:64:128-a:0:32-n32-S64")));
    }
    // FIXME: Enumerated types are variable width in straight AAPCS.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setABIAPCS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4684,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4331,
   FQN="(anonymous namespace)::ARMTargetInfo::setABIAPCS", NM="_ZN12_GLOBAL__N_113ARMTargetInfo10setABIAPCSEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo10setABIAPCSEb")
  //</editor-fold>
  private void setABIAPCS(boolean IsAAPCS16) {
    /*const*/ Triple /*&*/ T = getTriple();
    
    IsAAPCS = false;
    if (IsAAPCS16) {
      DoubleAlign = LongLongAlign = LongDoubleAlign = SuitableAlign = 64;
    } else {
      DoubleAlign = LongLongAlign = LongDoubleAlign = SuitableAlign = 32;
    }
    
    // size_t is unsigned int on FreeBSD.
    if (T.getOS() == Triple.OSType.FreeBSD) {
      SizeType = IntType.UnsignedInt;
    } else {
      SizeType = IntType.UnsignedLong;
    }
    
    // Revert to using SignedInt on apcs-gnu to comply with existing behaviour.
    WCharType = IntType.SignedInt;
    
    // Do not respect the alignment of bit-field types when laying out
    // structures. This corresponds to PCC_BITFIELD_TYPE_MATTERS in gcc.
    UseBitFieldTypeAlignment = false;
    
    /// gcc forces the alignment to 4 bytes, regardless of the type of the
    /// zero length bitfield.  This corresponds to EMPTY_FIELD_BOUNDARY in
    /// gcc.
    ZeroLengthBitfieldBoundary = 32;
    if (T.isOSBinFormatMachO() && IsAAPCS16) {
      assert (!BigEndian) : "AAPCS16 does not support big-endian";
      resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:o-p:32:32-i64:64-a:0:32-n32-S128"));
    } else if (T.isOSBinFormatMachO()) {
      resetDataLayout(new StringRef(BigEndian ? $("E-m:o-p:32:32-f64:32:64-v64:32:64-v128:32:128-a:0:32-n32-S32") : $("e-m:o-p:32:32-f64:32:64-v64:32:64-v128:32:128-a:0:32-n32-S32")));
    } else {
      resetDataLayout(new StringRef(BigEndian ? $("E-m:e-p:32:32-f64:32:64-v64:32:64-v128:32:128-a:0:32-n32-S32") : $("e-m:e-p:32:32-f64:32:64-v64:32:64-v128:32:128-a:0:32-n32-S32")));
    }
    // FIXME: Override "preferred align" for double and long long.
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setArchInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4729,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4376,
   FQN="(anonymous namespace)::ARMTargetInfo::setArchInfo", NM="_ZN12_GLOBAL__N_113ARMTargetInfo11setArchInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo11setArchInfoEv")
  //</editor-fold>
  private void setArchInfo() {
    StringRef ArchName = getTriple().getArchName();
    
    ArchISA = ARM.parseArchISA(/*NO_COPY*/ArchName);
    CPU.$assignMove(ARM.getDefaultCPU(/*NO_COPY*/ArchName).$string());
    /*uint*/int AK = ARM.parseArch(/*NO_COPY*/ArchName);
    if (AK != ARM.ArchKind.AK_INVALID.getValue()) {
      _ArchKind = AK;
    }
    setArchInfo(_ArchKind);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setArchInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4740,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4387,
   FQN="(anonymous namespace)::ARMTargetInfo::setArchInfo", NM="_ZN12_GLOBAL__N_113ARMTargetInfo11setArchInfoEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo11setArchInfoEj")
  //</editor-fold>
  private void setArchInfo(/*uint*/int Kind) {
    StringRef SubArch/*J*/= new StringRef();
    
    // cache TargetParser info
    _ArchKind = Kind;
    SubArch.$assignMove(ARM.getSubArch(_ArchKind));
    ArchProfile = ARM.parseArchProfile(/*NO_COPY*/SubArch);
    ArchVersion = ARM.parseArchVersion(/*NO_COPY*/SubArch);
    
    // cache CPU related strings
    CPUAttr.$assignMove(getCPUAttr());
    CPUProfile.$assignMove(getCPUProfile());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setAtomic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4754,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4401,
   FQN="(anonymous namespace)::ARMTargetInfo::setAtomic", NM="_ZN12_GLOBAL__N_113ARMTargetInfo9setAtomicEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo9setAtomicEv")
  //</editor-fold>
  private void setAtomic() {
    // when triple does not specify a sub arch,
    // then we are not using inline atomics
    boolean ShouldUseInlineAtomic = (ArchISA == ARM.ISAKind.IK_ARM.getValue() && $greatereq_uint(ArchVersion, 6))
       || (ArchISA == ARM.ISAKind.IK_THUMB.getValue() && $greatereq_uint(ArchVersion, 7));
    // Cortex M does not support 8 byte atomics, while general Thumb2 does.
    if (ArchProfile == ARM.ProfileKind.PK_M.getValue()) {
      MaxAtomicPromoteWidth = 32;
      if (ShouldUseInlineAtomic) {
        MaxAtomicInlineWidth = 32;
      }
    } else {
      MaxAtomicPromoteWidth = 64;
      if (ShouldUseInlineAtomic) {
        MaxAtomicInlineWidth = 64;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::isThumb">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4773,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4420,
   FQN="(anonymous namespace)::ARMTargetInfo::isThumb", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo7isThumbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo7isThumbEv")
  //</editor-fold>
  private boolean isThumb() /*const*/ {
    return (ArchISA == ARM.ISAKind.IK_THUMB.getValue());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::supportsThumb">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4777,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4424,
   FQN="(anonymous namespace)::ARMTargetInfo::supportsThumb", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo13supportsThumbEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo13supportsThumbEv")
  //</editor-fold>
  private boolean supportsThumb() /*const*/ {
    return (CPUAttr.count($$T) != 0) || $greatereq_uint(ArchVersion, 6);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::supportsThumb2">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4781,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4428,
   FQN="(anonymous namespace)::ARMTargetInfo::supportsThumb2", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo14supportsThumb2Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo14supportsThumb2Ev")
  //</editor-fold>
  private boolean supportsThumb2() /*const*/ {
    return CPUAttr.equals(/*STRINGREF_STR*/"6T2")
       || ($greatereq_uint(ArchVersion, 7) && !CPUAttr.equals(/*STRINGREF_STR*/"8M_BASE"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getCPUAttr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4786,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4432,
   FQN="(anonymous namespace)::ARMTargetInfo::getCPUAttr", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo10getCPUAttrEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo10getCPUAttrEv")
  //</editor-fold>
  private StringRef getCPUAttr() /*const*/ {
    // For most sub-arches, the build attribute CPU name is enough.
    // For Cortex variants, it's slightly different.
    switch (ArchKind.valueOf(_ArchKind)) {
     default:
      return ARM.getCPUAttr(_ArchKind);
     case AK_ARMV6M:
      return new StringRef(/*KEEP_STR*/"6M");
     case AK_ARMV7S:
      return new StringRef(/*KEEP_STR*/"7S");
     case AK_ARMV7A:
      return new StringRef(/*KEEP_STR*/"7A");
     case AK_ARMV7R:
      return new StringRef(/*KEEP_STR*/"7R");
     case AK_ARMV7M:
      return new StringRef(/*KEEP_STR*/"7M");
     case AK_ARMV7EM:
      return new StringRef(/*KEEP_STR*/"7EM");
     case AK_ARMV8A:
      return new StringRef(/*KEEP_STR*/"8A");
     case AK_ARMV8_1A:
      return new StringRef(/*KEEP_STR*/"8_1A");
     case AK_ARMV8_2A:
      return new StringRef(/*KEEP_STR*/"8_2A");
     case AK_ARMV8MBaseline:
      return new StringRef(/*KEEP_STR*/"8M_BASE");
     case AK_ARMV8MMainline:
      return new StringRef(/*KEEP_STR*/"8M_MAIN");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getCPUProfile">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4457,
   FQN="(anonymous namespace)::ARMTargetInfo::getCPUProfile", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo13getCPUProfileEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo13getCPUProfileEv")
  //</editor-fold>
  private StringRef getCPUProfile() /*const*/ {
    switch (ProfileKind.valueOf(ArchProfile)) {
     case PK_A:
      return new StringRef(/*KEEP_STR*/$A);
     case PK_R:
      return new StringRef(/*KEEP_STR*/$R);
     case PK_M:
      return new StringRef(/*KEEP_STR*/$M);
     default:
      return new StringRef(/*KEEP_STR*/$EMPTY);
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::ARMTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4831,
   FQN="(anonymous namespace)::ARMTargetInfo::ARMTargetInfo", NM="_ZN12_GLOBAL__N_113ARMTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsEb")
  //</editor-fold>
  public ARMTargetInfo(/*const*/ Triple /*&*/ _Triple, /*const*/ TargetOptions /*&*/ Opts, 
      boolean IsBigEndian) {
    /* : TargetInfo(Triple), ABI(), CPU(), CPUProfile(), CPUAttr(), FPMath(FP_Default), ArchKind(ARM::AK_ARMV4T), IsAAPCS(true), LDREX(0), HW_FP(0)*/ 
    //START JInit
    super(_Triple);
    this.ABI = new std.string();
    this.CPU = new std.string();
    this.CPUProfile = new StringRef();
    this.CPUAttr = new StringRef();
    this.FPMath = Unnamed_enum2.FP_Default;
    /*InClass*/this._ArchKind = ARM.ArchKind.AK_ARMV4T.getValue();
    this.IsAAPCS = true;
    this.LDREX = 0;
    this.HW_FP = 0;
    //END JInit
    BigEndian = IsBigEndian;
    switch (getTriple().getOS()) {
     case NetBSD:
      PtrDiffType = IntType.SignedLong;
      break;
     default:
      PtrDiffType = IntType.SignedInt;
      break;
    }
    
    // Cache arch related info.
    setArchInfo();
    
    // {} in inline assembly are neon specifiers, not assembly variant
    // specifiers.
    NoAsmVariants = true;
    
    // FIXME: This duplicates code from the driver that sets the -target-abi
    // option - this code is used if -target-abi isn't passed and should
    // be unified in some way.
    if (_Triple.isOSBinFormatMachO()) {
      // The backend is hardwired to assume AAPCS for M-class processors, ensure
      // the frontend matches that.
      if (_Triple.getEnvironment() == org.llvm.adt.Triple.EnvironmentType.EABI
         || _Triple.getOS() == org.llvm.adt.Triple.OSType.UnknownOS
         || new StringRef(CPU).startswith(/*STRINGREF_STR*/"cortex-m")) {
        setABI(new std.string(/*KEEP_STR*/"aapcs"));
      } else if (_Triple.isWatchABI()) {
        setABI(new std.string(/*KEEP_STR*/"aapcs16"));
      } else {
        setABI(new std.string(/*KEEP_STR*/"apcs-gnu"));
      }
    } else if (_Triple.isOSWindows()) {
      // FIXME: this is invalid for WindowsCE
      setABI(new std.string(/*KEEP_STR*/"aapcs"));
    } else {
      // Select the default based on the platform.
      switch (_Triple.getEnvironment()) {
       case Android:
       case GNUEABI:
       case GNUEABIHF:
       case MuslEABI:
       case MuslEABIHF:
        setABI(new std.string(/*KEEP_STR*/"aapcs-linux"));
        break;
       case EABIHF:
       case EABI:
        setABI(new std.string(/*KEEP_STR*/"aapcs"));
        break;
       case GNU:
        setABI(new std.string(/*KEEP_STR*/"apcs-gnu"));
        break;
       default:
        if (_Triple.getOS() == org.llvm.adt.Triple.OSType.NetBSD) {
          setABI(new std.string(/*KEEP_STR*/"apcs-gnu"));
        } else {
          setABI(new std.string(/*KEEP_STR*/"aapcs"));
        }
        break;
      }
    }
    
    // ARM targets default to using the ARM C++ ABI.
    TheCXXABI.set(TargetCXXABI.Kind.GenericARM);
    
    // ARM has atomics up to 8 bytes
    setAtomic();
    
    // Do force alignment of members that follow zero length bitfields.  If
    // the alignment of the zero-length bitfield is greater than the member
    // that follows it, `bar', `bar' will be aligned as the  type of the
    // zero length bitfield.
    UseZeroLengthBitfieldAlignment = true;
    if (_Triple.getOS() == org.llvm.adt.Triple.OSType.Linux
       || _Triple.getOS() == org.llvm.adt.Triple.OSType.UnknownOS) {
      this.MCountName = $tryClone($eq_string$C_T(Opts.EABIVersion, /*KEEP_STR*/"gnu") ? $("\001__gnu_mcount_nc") : $("\001mcount"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4915,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4547,
   FQN="(anonymous namespace)::ARMTargetInfo::getABI", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo6getABIEv")
  //</editor-fold>
  @Override public StringRef getABI() /*const*//* override*/ {
    return new StringRef(ABI);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4917,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4549,
   FQN="(anonymous namespace)::ARMTargetInfo::setABI", NM="_ZN12_GLOBAL__N_113ARMTargetInfo6setABIERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo6setABIERKSs")
  //</editor-fold>
  @Override public boolean setABI(/*const*/std.string/*&*/ Name)/* override*/ {
    ABI.$assign(Name);
    
    // The defaults (above) are for AAPCS, check if we need to change them.
    //
    // FIXME: We need support for -meabi... we could just mangle it into the
    // name.
    if ($eq_string$C_T(Name, /*KEEP_STR*/"apcs-gnu") || $eq_string$C_T(Name, /*KEEP_STR*/"aapcs16")) {
      setABIAPCS($eq_string$C_T(Name, /*KEEP_STR*/"aapcs16"));
      return true;
    }
    if ($eq_string$C_T(Name, /*KEEP_STR*/"aapcs") || $eq_string$C_T(Name, /*KEEP_STR*/"aapcs-vfp") || $eq_string$C_T(Name, /*KEEP_STR*/"aapcs-linux")) {
      setABIAAPCS();
      return true;
    }
    return false;
  }

  
  // FIXME: This should be based on Arch attributes, not CPU names.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4936,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4568,
   FQN="(anonymous namespace)::ARMTargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, 
                StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeaturesVec) /*const*//* override*/ {
    vectorCharPtr TargetFeatures = null;
    try {
      
      TargetFeatures/*J*/= new vectorCharPtr();
      /*uint*/int Arch = ARM.parseArch(getTriple().getArchName());
      
      // get default FPU features
      /*uint*/int FPUKind = ARM.getDefaultFPU(/*NO_COPY*/CPU, Arch);
      ARM.getFPUFeatures(FPUKind, TargetFeatures);
      
      // get default Extension features
      /*uint*/int Extensions = ARM.getDefaultExtensions(/*NO_COPY*/CPU, Arch);
      ARM.getExtensionFeatures(Extensions, TargetFeatures);
      
      for (/*const*/char$ptr/*char P*/ Feature : TargetFeatures)  {
        if (Feature.$at(0) == $$PLUS) {
          Features.$set(/*STRINGREF_STR*/Feature.$add(1), true);
        }
      }
      
      return super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeaturesVec);
    } finally {
      if (TargetFeatures != null) { TargetFeatures.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4959,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4591,
   FQN="(anonymous namespace)::ARMTargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_113ARMTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    FPU = 0;
    CRC = false;
    Crypto = false;
    DSP = false;
    Unaligned = true;
    SoftFloat = SoftFloatABI = false;
    HWDiv = 0;
    
    // This does not diagnose illegal cases like having both
    // "+vfpv2" and "+vfpv3" or having "+neon" and "+fp-only-sp".
    /*uint32_t*/int HW_FP_remove = 0;
    for (/*const*/std.string/*&*/ Feature : Features) {
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+soft-float")) {
        SoftFloat = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+soft-float-abi")) {
        SoftFloatABI = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+vfp2")) {
        FPU |= FPUMode.VFP2FPU;
        HW_FP |= HW_FP_SP | HW_FP_DP;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+vfp3")) {
        FPU |= FPUMode.VFP3FPU;
        HW_FP |= HW_FP_SP | HW_FP_DP;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+vfp4")) {
        FPU |= FPUMode.VFP4FPU;
        HW_FP |= HW_FP_SP | HW_FP_DP | HW_FP_HP;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fp-armv8")) {
        FPU |= FPUMode.FPARMV8;
        HW_FP |= HW_FP_SP | HW_FP_DP | HW_FP_HP;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+neon")) {
        FPU |= FPUMode.NeonFPU;
        HW_FP |= HW_FP_SP | HW_FP_DP;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+hwdiv")) {
        HWDiv |= HWDivMode.HWDivThumb;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+hwdiv-arm")) {
        HWDiv |= HWDivMode.HWDivARM;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+crc")) {
        CRC = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+crypto")) {
        Crypto = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+dsp")) {
        DSP = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fp-only-sp")) {
        HW_FP_remove |= HW_FP_DP;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+strict-align")) {
        Unaligned = false;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fp16")) {
        HW_FP |= HW_FP_HP;
      }
    }
    HW_FP &= ~HW_FP_remove;
    switch (ArchVersion) {
     case 6:
      if (ArchProfile == ARM.ProfileKind.PK_M.getValue()) {
        LDREX = 0;
      } else if (_ArchKind == ARM.ArchKind.AK_ARMV6K.getValue()) {
        LDREX = LDREX_D | LDREX_W | LDREX_H | LDREX_B;
      } else {
        LDREX = LDREX_W;
      }
      break;
     case 7:
      if (ArchProfile == ARM.ProfileKind.PK_M.getValue()) {
        LDREX = LDREX_W | LDREX_H | LDREX_B;
      } else {
        LDREX = LDREX_D | LDREX_W | LDREX_H | LDREX_B;
      }
      break;
     case 8:
      LDREX = LDREX_D | LDREX_W | LDREX_H | LDREX_B;
    }
    if (!((FPU & FPUMode.NeonFPU) != 0) && FPMath == Unnamed_enum2.FP_Neon) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_target_unsupported_fpmath)), /*KEEP_STR*/"neon"));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    if (FPMath == Unnamed_enum2.FP_Neon) {
      Features.push_back(new std.string(/*KEEP_STR*/"+neonfp"));
    } else if (FPMath == Unnamed_enum2.FP_VFP) {
      Features.push_back(new std.string(/*KEEP_STR*/"-neonfp"));
    }
    
    // Remove front-end specific options which the backend handles differently.
    vectorString.iterator Feature = std.find(Features.begin(), Features.end(), /*KEEP_STR*/"+soft-float-abi");
    if ($noteq___normal_iterator$C(Feature, Features.end())) {
      Features.erase(Feature);
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5050,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4682,
   FQN="(anonymous namespace)::ARMTargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"arm", true).
        Case(/*KEEP_STR*/"aarch32", true).
        Case(/*KEEP_STR*/"softfloat", SoftFloat).
        Case(/*KEEP_STR*/"thumb", isThumb()).
        Case(/*KEEP_STR*/"neon", ((FPU & FPUMode.NeonFPU) != 0) && !SoftFloat).
        Case(/*KEEP_STR*/"hwdiv", ((HWDiv & HWDivMode.HWDivThumb) != 0)).
        Case(/*KEEP_STR*/"hwdiv-arm", ((HWDiv & HWDivMode.HWDivARM) != 0)).
        Default(false);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5062,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4694,
   FQN="(anonymous namespace)::ARMTargetInfo::setCPU", NM="_ZN12_GLOBAL__N_113ARMTargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    if ($noteq_string$C_T(Name, /*KEEP_STR*/"generic")) {
      setArchInfo(ARM.parseCPUArch(new StringRef(Name)));
    }
    if (_ArchKind == ARM.ArchKind.AK_INVALID.getValue()) {
      return false;
    }
    setAtomic();
    CPU.$assign(Name);
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::setFPMath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5393,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5012,
   FQN="(anonymous namespace)::ARMTargetInfo::setFPMath", NM="_ZN12_GLOBAL__N_113ARMTargetInfo9setFPMathEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfo9setFPMathEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean setFPMath(StringRef Name)/* override*/ {
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"neon")) {
      FPMath = Unnamed_enum2.FP_Neon;
      return true;
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vfp") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vfp2") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vfp3")
       || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"vfp4")) {
      FPMath = Unnamed_enum2.FP_VFP;
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5075,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4707,
   FQN="(anonymous namespace)::ARMTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    // Target identification.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__arm"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__arm__"));
    // For bare-metal none-eabi.
    if (getTriple().getOS() == Triple.OSType.UnknownOS
       && getTriple().getEnvironment() == Triple.EnvironmentType.EABI) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ELF__"));
    }
    
    // Target properties.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__REGISTER_PREFIX__"), new Twine(/*KEEP_STR*/$EMPTY));
    
    // Unfortunately, __ARM_ARCH_7K__ is now more of an ABI descriptor. The CPU
    // happens to be Cortex-A7 though, so it should still get __ARM_ARCH_7A__.
    if (getTriple().isWatchABI()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_7K__"), new Twine(/*KEEP_STR*/$2));
    }
    if (!CPUAttr.empty()) {
      Builder.defineMacro($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"__ARM_ARCH_", CPUAttr), new Twine(/*KEEP_STR*/"__")));
    }
    
    // ACLE 6.4.1 ARM/Thumb instruction set architecture
    // __ARM_ARCH is defined as an integer value indicating the current ARM ISA
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH"), new Twine(JD$UInt.INSTANCE, ArchVersion));
    if ($greatereq_uint(ArchVersion, 8)) {
      // ACLE 6.5.7 Crypto Extension
      if (Crypto) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_CRYPTO"), new Twine(/*KEEP_STR*/$1));
      }
      // ACLE 6.5.8 CRC32 Extension
      if (CRC) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_CRC32"), new Twine(/*KEEP_STR*/$1));
      }
      // ACLE 6.5.10 Numeric Maximum and Minimum
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_NUMERIC_MAXMIN"), new Twine(/*KEEP_STR*/$1));
      // ACLE 6.5.9 Directed Rounding
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_DIRECTED_ROUNDING"), new Twine(/*KEEP_STR*/$1));
    }
    
    // __ARM_ARCH_ISA_ARM is defined to 1 if the core supports the ARM ISA.  It
    // is not defined for the M-profile.
    // NOTE that the default profile is assumed to be 'A'
    if (CPUProfile.empty() || ArchProfile != ARM.ProfileKind.PK_M.getValue()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_ISA_ARM"), new Twine(/*KEEP_STR*/$1));
    }
    
    // __ARM_ARCH_ISA_THUMB is defined to 1 if the core supports the original
    // Thumb ISA (including v6-M and v8-M Baseline).  It is set to 2 if the
    // core supports the Thumb-2 ISA as found in the v6T2 architecture and all
    // v7 and v8 architectures excluding v8-M Baseline.
    if (supportsThumb2()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_ISA_THUMB"), new Twine(/*KEEP_STR*/$2));
    } else if (supportsThumb()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_ISA_THUMB"), new Twine(/*KEEP_STR*/$1));
    }
    
    // __ARM_32BIT_STATE is defined to 1 if code is being generated for a 32-bit
    // instruction set such as ARM or Thumb.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_32BIT_STATE"), new Twine(/*KEEP_STR*/$1));
    
    // ACLE 6.4.2 Architectural Profile (A, R, M or pre-Cortex)
    
    // __ARM_ARCH_PROFILE is defined as 'A', 'R', 'M' or 'S', or unset.
    if (!CPUProfile.empty()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_PROFILE"), $add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/$SGL_QUOTE, CPUProfile), new Twine(/*KEEP_STR*/$SGL_QUOTE)));
    }
    
    // ACLE 6.4.3 Unaligned access supported in hardware
    if (Unaligned) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_UNALIGNED"), new Twine(/*KEEP_STR*/$1));
    }
    
    // ACLE 6.4.4 LDREX/STREX
    if ((LDREX != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_LDREX"), new Twine($add_T_string(/*KEEP_STR*/"0x", llvm.utohexstr($uint32_t2ulong(LDREX)))));
    }
    
    // ACLE 6.4.5 CLZ
    if (ArchVersion == 5
       || (ArchVersion == 6 && $noteq_StringRef(/*NO_COPY*/CPUProfile, /*STRINGREF_STR*/"M"))
       || $greater_uint(ArchVersion, 6)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_CLZ"), new Twine(/*KEEP_STR*/$1));
    }
    
    // ACLE 6.5.1 Hardware Floating Point
    if ((HW_FP != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP"), new Twine($add_T_string(/*KEEP_STR*/"0x", llvm.utohexstr($uint32_t2ulong(HW_FP)))));
    }
    
    // ACLE predefines.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ACLE"), new Twine(/*KEEP_STR*/"200"));
    
    // FP16 support (we currently only support IEEE format).
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP16_FORMAT_IEEE"), new Twine(/*KEEP_STR*/$1));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP16_ARGS"), new Twine(/*KEEP_STR*/$1));
    
    // ACLE 6.5.3 Fused multiply-accumulate (FMA)
    if ($greatereq_uint(ArchVersion, 7) && ((FPU & FPUMode.VFP4FPU) != 0)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_FMA"), new Twine(/*KEEP_STR*/$1));
    }
    
    // Subtarget options.
    
    // FIXME: It's more complicated than this and we don't really support
    // interworking.
    // Windows on ARM does not "support" interworking
    if ($lesseq_uint(5, ArchVersion) && $lesseq_uint(ArchVersion, 8) && !getTriple().isOSWindows()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__THUMB_INTERWORK__"));
    }
    if ($eq_string$C_T(ABI, /*KEEP_STR*/"aapcs") || $eq_string$C_T(ABI, /*KEEP_STR*/"aapcs-linux") || $eq_string$C_T(ABI, /*KEEP_STR*/"aapcs-vfp")) {
      // Embedded targets on Darwin follow AAPCS, but not EABI.
      // Windows on ARM follows AAPCS VFP, but does not conform to EABI.
      if (!getTriple().isOSBinFormatMachO() && !getTriple().isOSWindows()) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_EABI__"));
      }
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_PCS"), new Twine(/*KEEP_STR*/$1));
    }
    if ((!SoftFloat && !SoftFloatABI) || $eq_string$C_T(ABI, /*KEEP_STR*/"aapcs-vfp")
       || $eq_string$C_T(ABI, /*KEEP_STR*/"aapcs16")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_PCS_VFP"), new Twine(/*KEEP_STR*/$1));
    }
    if (SoftFloat) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SOFTFP__"));
    }
    if ($eq_string$C_T(CPU, /*KEEP_STR*/"xscale")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__XSCALE__"));
    }
    if (isThumb()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__THUMBEL__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__thumb__"));
      if (supportsThumb2()) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__thumb2__"));
      }
    }
    
    // ACLE 6.4.9 32-bit SIMD instructions
    if ($greatereq_uint(ArchVersion, 6) && ($noteq_StringRef(/*NO_COPY*/CPUProfile, /*STRINGREF_STR*/"M") || $eq_StringRef(/*NO_COPY*/CPUAttr, /*STRINGREF_STR*/"7EM"))) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_SIMD32"), new Twine(/*KEEP_STR*/$1));
    }
    
    // ACLE 6.4.10 Hardware Integer Divide
    if ((((HWDiv & HWDivMode.HWDivThumb) != 0) && isThumb())
       || (((HWDiv & HWDivMode.HWDivARM) != 0) && !isThumb())) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_IDIV"), new Twine(/*KEEP_STR*/$1));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_ARCH_EXT_IDIV__"), new Twine(/*KEEP_STR*/$1));
    }
    
    // Note, this is always on in gcc, even though it doesn't make sense.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__APCS_32__"));
    if (FPUModeIsVFP((/*FPUMode*//*uint*/int)FPU)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__VFP_FP__"));
      if (((FPU & FPUMode.VFP2FPU) != 0)) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_VFPV2__"));
      }
      if (((FPU & FPUMode.VFP3FPU) != 0)) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_VFPV3__"));
      }
      if (((FPU & FPUMode.VFP4FPU) != 0)) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_VFPV4__"));
      }
    }
    
    // This only gets set when Neon instructions are actually available, unlike
    // the VFP define, hence the soft float and arch check. This is subtly
    // different from gcc, we follow the intent which was that it should be set
    // when Neon instructions are actually available.
    if (((FPU & FPUMode.NeonFPU) != 0) && !SoftFloat && $greatereq_uint(ArchVersion, 7)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_NEON"), new Twine(/*KEEP_STR*/$1));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_NEON__"));
      // current AArch32 NEON implementations do not support double-precision
      // floating-point even when it is present in VFP.
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_NEON_FP"), 
          new Twine($add_T_string(/*KEEP_STR*/"0x", llvm.utohexstr($uint2ulong(HW_FP & ~HW_FP_DP)))));
    }
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_SIZEOF_WCHAR_T"), 
        new Twine(Opts.ShortWChar ? $2 : $4));
    
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_SIZEOF_MINIMAL_ENUM"), 
        new Twine(Opts.ShortEnums ? $1 : $4));
    if ($greatereq_uint(ArchVersion, 6) && $noteq_StringRef(/*NO_COPY*/CPUAttr, /*STRINGREF_STR*/"6M") && $noteq_StringRef(/*NO_COPY*/CPUAttr, /*STRINGREF_STR*/"8M_BASE")) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8"));
    }
    
    // ACLE 6.4.7 DSP instructions
    if (DSP) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_DSP"), new Twine(/*KEEP_STR*/$1));
    }
    
    // ACLE 6.4.8 Saturation instructions
    boolean SAT = false;
    if ((ArchVersion == 6 && $noteq_StringRef(/*NO_COPY*/CPUProfile, /*STRINGREF_STR*/"M")) || $greater_uint(ArchVersion, 6)) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_SAT"), new Twine(/*KEEP_STR*/$1));
      SAT = true;
    }
    
    // ACLE 6.4.6 Q (saturation) flag
    if (DSP || SAT) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_QBIT"), new Twine(/*KEEP_STR*/$1));
    }
    if (Opts.UnsafeFPMath) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FP_FAST"), new Twine(/*KEEP_STR*/$1));
    }
    if (_ArchKind == ARM.ArchKind.AK_ARMV8_1A.getValue()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ARM_FEATURE_QRDMX"), new Twine(/*KEEP_STR*/$1));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5273,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4899,
   FQN="(anonymous namespace)::ARMTargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo, 
        org.clang.basic.target.ARM.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::isCLZForZeroUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5277,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4903,
   FQN="(anonymous namespace)::ARMTargetInfo::isCLZForZeroUndef", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo17isCLZForZeroUndefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo17isCLZForZeroUndefEv")
  //</editor-fold>
  @Override public boolean isCLZForZeroUndef() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getBuiltinVaListKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5278,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4904,
   FQN="(anonymous namespace)::ARMTargetInfo::getBuiltinVaListKind", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo20getBuiltinVaListKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo20getBuiltinVaListKindEv")
  //</editor-fold>
  @Override public BuiltinVaListKind getBuiltinVaListKind() /*const*//* override*/ {
    return IsAAPCS ? BuiltinVaListKind.AAPCSABIBuiltinVaList : (getTriple().isWatchABI() ? TargetInfo.BuiltinVaListKind.CharPtrBuiltinVaList : TargetInfo.BuiltinVaListKind.VoidPtrBuiltinVaList);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5427,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5046,
   FQN="(anonymous namespace)::ARMTargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5452,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5071,
   FQN="(anonymous namespace)::ARMTargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegAliases);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5286,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4912,
   FQN="(anonymous namespace)::ARMTargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      break;
     case 'l': // r0-r7
     case 'h': // r8-r15
     case 't': // VFP Floating point register single precision
     case 'w': // VFP Floating point register double precision
      Info.setAllowsRegister();
      return true;
     case 'I':
     case 'J':
     case 'K':
     case 'L':
     case 'M':
      // FIXME
      return true;
     case 'Q': // A memory address that is a single base register.
      Info.setAllowsMemory();
      return true;
     case 'U': // a memory reference...
      switch (Name.$at(1)) {
       case 'q': // ...ARMV4 ldrsb
       case 'v': // ...VFP load/store (reg+constant offset)
       case 'y': // ...iWMMXt load/store
       case 't': // address valid for load/store opaque types wider
        // than 128-bits
       case 'n': // valid address for Neon doubleword vector load/store
       case 'm': // valid address for Neon element and structure load/store
       case 's': // valid address for non-offset loads/stores of quad-word
        // values in four ARM registers
        Info.setAllowsMemory();
        Name.$postInc();
        return true;
      }
    }
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::convertConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5324,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4950,
   FQN="(anonymous namespace)::ARMTargetInfo::convertConstraint", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo17convertConstraintERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo17convertConstraintERPKc")
  //</editor-fold>
  @Override public std.string convertConstraint(char$ptr/*const char P &*/ Constraint) /*const*//* override*/ {
    std.string R/*J*/= new std.string();
    switch (Constraint.$star()) {
     case 'U': // Two-character constraint; add "^" hint for later parsing.
      R.$assignMove($add_string(new std.string(/*KEEP_STR*/$CARET), new std.string(Constraint, 2)));
      Constraint.$postInc();
      break;
     case 'p': // 'p' should be translated to 'r' by default.
      R.$assignMove(new std.string(/*KEEP_STR*/$r));
      break;
     default:
      return new std.string(1, Constraint.$star());
    }
    return R;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::validateConstraintModifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5339,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4965,
   FQN="(anonymous namespace)::ARMTargetInfo::validateConstraintModifier", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo26validateConstraintModifierEN4llvm9StringRefEcjRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo26validateConstraintModifierEN4llvm9StringRefEcjRSs")
  //</editor-fold>
  @Override public boolean validateConstraintModifier(StringRef Constraint, /*char*/byte Modifier, /*uint*/int Size, 
                            std.string/*&*/ SuggestedModifier) /*const*//* override*/ {
    boolean isOutput = (Constraint.$at(0) == $$EQ);
    boolean isInOut = (Constraint.$at(0) == $$PLUS);
    
    // Strip off constraint modifiers.
    while (Constraint.$at(0) == $$EQ
       || Constraint.$at(0) == $$PLUS
       || Constraint.$at(0) == $$AMP) {
      Constraint.$assignMove(Constraint.substr(1));
    }
    switch (Constraint.$at(0)) {
     default:
      break;
     case 'r':
      {
        switch (Modifier) {
         default:
          return (isInOut || isOutput || $lesseq_uint(Size, 64));
         case 'q':
          // A register of size 32 cannot fit a vector type.
          return false;
        }
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5366,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4992,
   FQN="(anonymous namespace)::ARMTargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    // FIXME: Is this really right?
    return $EMPTY;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5371,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4997,
   FQN="(anonymous namespace)::ARMTargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    switch (CC) {
     case CC_AAPCS:
     case CC_AAPCS_VFP:
     case CC_Swift:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::getEHDataRegisterNumber">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5382,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5001,
   FQN="(anonymous namespace)::ARMTargetInfo::getEHDataRegisterNumber", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo23getEHDataRegisterNumberEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo23getEHDataRegisterNumberEj")
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

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::hasSjLjLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5388,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5007,
   FQN="(anonymous namespace)::ARMTargetInfo::hasSjLjLowering", NM="_ZNK12_GLOBAL__N_113ARMTargetInfo15hasSjLjLoweringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113ARMTargetInfo15hasSjLjLoweringEv")
  //</editor-fold>
  @Override public boolean hasSjLjLowering() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ARMTargetInfo::~ARMTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4553,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4200,
   FQN="(anonymous namespace)::ARMTargetInfo::~ARMTargetInfo", NM="_ZN12_GLOBAL__N_113ARMTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113ARMTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    CPU.$destroy();
    ABI.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "ABI=" + ABI // NOI18N
              + ", CPU=" + CPU // NOI18N
              + ", CPUProfile=" + CPUProfile // NOI18N
              + ", CPUAttr=" + CPUAttr // NOI18N
              + ", FPMath=" + FPMath // NOI18N
              + ", ArchISA=" + ArchISA // NOI18N
              + ", _ArchKind=" + _ArchKind // NOI18N
              + ", ArchProfile=" + ArchProfile // NOI18N
              + ", ArchVersion=" + ArchVersion // NOI18N
              + ", FPU=" + FPU // NOI18N
              + ", IsAAPCS=" + IsAAPCS // NOI18N
              + ", HWDiv=" + HWDiv // NOI18N
              + ", SoftFloat=" + SoftFloat // NOI18N
              + ", SoftFloatABI=" + SoftFloatABI // NOI18N
              + ", CRC=" + CRC // NOI18N
              + ", Crypto=" + Crypto // NOI18N
              + ", DSP=" + DSP // NOI18N
              + ", Unaligned=" + Unaligned // NOI18N
              + ", LDREX=" + LDREX // NOI18N
              + ", HW_FP=" + HW_FP // NOI18N
              + super.toString(); // NOI18N
  }
}
