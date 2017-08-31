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
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


// X86 target abstract base class; x86-32 and x86-64 are very close, so
// most of the implementation can be shared.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2300,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2073,
 FQN="(anonymous namespace)::X86TargetInfo", NM="_ZN12_GLOBAL__N_113X86TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfoE")
//</editor-fold>
public abstract class X86TargetInfo extends /*public*/ TargetInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::X86SSEEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2074,
   FQN="(anonymous namespace)::X86TargetInfo::X86SSEEnum", NM="_ZN12_GLOBAL__N_113X86TargetInfo10X86SSEEnumE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo10X86SSEEnumE")
  //</editor-fold>
  private enum X86SSEEnum implements Native.ComparableLower {
    NoSSE(0),
    SSE1(NoSSE.getValue() + 1),
    SSE2(SSE1.getValue() + 1),
    SSE3(SSE2.getValue() + 1),
    SSSE3(SSE3.getValue() + 1),
    SSE41(SSSE3.getValue() + 1),
    SSE42(SSE41.getValue() + 1),
    AVX(SSE42.getValue() + 1),
    AVX2(AVX.getValue() + 1),
    AVX512F(AVX2.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static X86SSEEnum valueOf(int val) {
      X86SSEEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final X86SSEEnum[] VALUES;
      private static final X86SSEEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (X86SSEEnum kind : X86SSEEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new X86SSEEnum[min < 0 ? (1-min) : 0];
        VALUES = new X86SSEEnum[max >= 0 ? (1+max) : 0];
        for (X86SSEEnum kind : X86SSEEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private X86SSEEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((X86SSEEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((X86SSEEnum)obj).value);}
    //</editor-fold>
  };
  private  X86SSEEnum SSELevel/* = NoSSE*/;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::MMX3DNowEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2304,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2077,
   FQN="(anonymous namespace)::X86TargetInfo::MMX3DNowEnum", NM="_ZN12_GLOBAL__N_113X86TargetInfo12MMX3DNowEnumE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo12MMX3DNowEnumE")
  //</editor-fold>
  private enum MMX3DNowEnum implements Native.ComparableLower {
    NoMMX3DNow(0),
    MMX(NoMMX3DNow.getValue() + 1),
    AMD3DNow(MMX.getValue() + 1),
    AMD3DNowAthlon(AMD3DNow.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static MMX3DNowEnum valueOf(int val) {
      MMX3DNowEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final MMX3DNowEnum[] VALUES;
      private static final MMX3DNowEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (MMX3DNowEnum kind : MMX3DNowEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new MMX3DNowEnum[min < 0 ? (1-min) : 0];
        VALUES = new MMX3DNowEnum[max >= 0 ? (1+max) : 0];
        for (MMX3DNowEnum kind : MMX3DNowEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private MMX3DNowEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((MMX3DNowEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((MMX3DNowEnum)obj).value);}
    //</editor-fold>
  };
  private  MMX3DNowEnum MMX3DNowLevel/* = NoMMX3DNow*/;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::XOPEnum">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2307,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2080,
   FQN="(anonymous namespace)::X86TargetInfo::XOPEnum", NM="_ZN12_GLOBAL__N_113X86TargetInfo7XOPEnumE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo7XOPEnumE")
  //</editor-fold>
  private enum XOPEnum implements Native.ComparableLower {
    NoXOP(0),
    SSE4A(NoXOP.getValue() + 1),
    FMA4(SSE4A.getValue() + 1),
    XOP(FMA4.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static XOPEnum valueOf(int val) {
      XOPEnum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final XOPEnum[] VALUES;
      private static final XOPEnum[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (XOPEnum kind : XOPEnum.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new XOPEnum[min < 0 ? (1-min) : 0];
        VALUES = new XOPEnum[max >= 0 ? (1+max) : 0];
        for (XOPEnum kind : XOPEnum.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private XOPEnum(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((XOPEnum)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((XOPEnum)obj).value);}
    //</editor-fold>
  };
  private  XOPEnum XOPLevel/* = NoXOP*/;
  
  private boolean HasAES/* = false*/;
  private boolean HasPCLMUL/* = false*/;
  private boolean HasLZCNT/* = false*/;
  private boolean HasRDRND/* = false*/;
  private boolean HasFSGSBASE/* = false*/;
  private boolean HasBMI/* = false*/;
  private boolean HasBMI2/* = false*/;
  private boolean HasPOPCNT/* = false*/;
  private boolean HasRTM/* = false*/;
  private boolean HasPRFCHW/* = false*/;
  private boolean HasRDSEED/* = false*/;
  private boolean HasADX/* = false*/;
  private boolean HasTBM/* = false*/;
  private boolean HasFMA/* = false*/;
  private boolean HasF16C/* = false*/;
  private boolean HasAVX512CD/* = false*/;
  private boolean HasAVX512ER/* = false*/;
  private boolean HasAVX512PF/* = false*/;
  private boolean HasAVX512DQ/* = false*/;
  private boolean HasAVX512BW/* = false*/;
  private boolean HasAVX512VL/* = false*/;
  private boolean HasAVX512VBMI/* = false*/;
  private boolean HasAVX512IFMA/* = false*/;
  private boolean HasSHA/* = false*/;
  private boolean HasMPX/* = false*/;
  private boolean HasSGX/* = false*/;
  private boolean HasCX16/* = false*/;
  private boolean HasFXSR/* = false*/;
  private boolean HasXSAVE/* = false*/;
  private boolean HasXSAVEOPT/* = false*/;
  private boolean HasXSAVEC/* = false*/;
  private boolean HasXSAVES/* = false*/;
  private boolean HasMWAITX/* = false*/;
  private boolean HasPKU/* = false*/;
  private boolean HasCLFLUSHOPT/* = false*/;
  private boolean HasPCOMMIT/* = false*/;
  private boolean HasCLWB/* = false*/;
  private boolean HasUMIP/* = false*/;
  private boolean HasMOVBE/* = false*/;
  private boolean HasPREFETCHWT1/* = false*/;
  
  /// \brief Enumeration of all of the X86 CPUs supported by Clang.
  ///
  /// Each enumeration represents a particular CPU supported by Clang. These
  /// loosely correspond to the options passed to '-march' or '-mtune' flags.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::CPUKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2121,
   FQN="(anonymous namespace)::X86TargetInfo::CPUKind", NM="_ZN12_GLOBAL__N_113X86TargetInfo7CPUKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo7CPUKindE")
  //</editor-fold>
  private enum CPUKind implements Native.ComparableLower {
    CK_Generic(0),
    
    /// \name i386
    /// i386-generation processors.
    //@{
    CK_i386(CK_Generic.getValue() + 1),
    //@}
    
    /// \name i486
    /// i486-generation processors.
    //@{
    CK_i486(CK_i386.getValue() + 1),
    CK_WinChipC6(CK_i486.getValue() + 1),
    CK_WinChip2(CK_WinChipC6.getValue() + 1),
    CK_C3(CK_WinChip2.getValue() + 1),
    //@}
    
    /// \name i586
    /// i586-generation processors, P5 microarchitecture based.
    //@{
    CK_i586(CK_C3.getValue() + 1),
    CK_Pentium(CK_i586.getValue() + 1),
    CK_PentiumMMX(CK_Pentium.getValue() + 1),
    //@}
    
    /// \name i686
    /// i686-generation processors, P6 / Pentium M microarchitecture based.
    //@{
    CK_i686(CK_PentiumMMX.getValue() + 1),
    CK_PentiumPro(CK_i686.getValue() + 1),
    CK_Pentium2(CK_PentiumPro.getValue() + 1),
    CK_Pentium3(CK_Pentium2.getValue() + 1),
    CK_Pentium3M(CK_Pentium3.getValue() + 1),
    CK_PentiumM(CK_Pentium3M.getValue() + 1),
    CK_C3_2(CK_PentiumM.getValue() + 1),
    
    /// This enumerator is a bit odd, as GCC no longer accepts -march=yonah.
    /// Clang however has some logic to suport this.
    // FIXME: Warn, deprecate, and potentially remove this.
    CK_Yonah(CK_C3_2.getValue() + 1),
    //@}
    
    /// \name Netburst
    /// Netburst microarchitecture based processors.
    //@{
    CK_Pentium4(CK_Yonah.getValue() + 1),
    CK_Pentium4M(CK_Pentium4.getValue() + 1),
    CK_Prescott(CK_Pentium4M.getValue() + 1),
    CK_Nocona(CK_Prescott.getValue() + 1),
    //@}
    
    /// \name Core
    /// Core microarchitecture based processors.
    //@{
    CK_Core2(CK_Nocona.getValue() + 1),
    
    /// This enumerator, like \see CK_Yonah, is a bit odd. It is another
    /// codename which GCC no longer accepts as an option to -march, but Clang
    /// has some logic for recognizing it.
    // FIXME: Warn, deprecate, and potentially remove this.
    CK_Penryn(CK_Core2.getValue() + 1),
    //@}
    
    /// \name Atom
    /// Atom processors
    //@{
    CK_Bonnell(CK_Penryn.getValue() + 1),
    CK_Silvermont(CK_Bonnell.getValue() + 1),
    //@}
    
    /// \name Nehalem
    /// Nehalem microarchitecture based processors.
    CK_Nehalem(CK_Silvermont.getValue() + 1),
    
    /// \name Westmere
    /// Westmere microarchitecture based processors.
    CK_Westmere(CK_Nehalem.getValue() + 1),
    
    /// \name Sandy Bridge
    /// Sandy Bridge microarchitecture based processors.
    CK_SandyBridge(CK_Westmere.getValue() + 1),
    
    /// \name Ivy Bridge
    /// Ivy Bridge microarchitecture based processors.
    CK_IvyBridge(CK_SandyBridge.getValue() + 1),
    
    /// \name Haswell
    /// Haswell microarchitecture based processors.
    CK_Haswell(CK_IvyBridge.getValue() + 1),
    
    /// \name Broadwell
    /// Broadwell microarchitecture based processors.
    CK_Broadwell(CK_Haswell.getValue() + 1),
    
    /// \name Skylake Client
    /// Skylake client microarchitecture based processors.
    CK_SkylakeClient(CK_Broadwell.getValue() + 1),
    
    /// \name Skylake Server
    /// Skylake server microarchitecture based processors.
    CK_SkylakeServer(CK_SkylakeClient.getValue() + 1),
    
    /// \name Cannonlake Client
    /// Cannonlake client microarchitecture based processors.
    CK_Cannonlake(CK_SkylakeServer.getValue() + 1),
    
    /// \name Knights Landing
    /// Knights Landing processor.
    CK_KNL(CK_Cannonlake.getValue() + 1),
    
    /// \name Lakemont
    /// Lakemont microarchitecture based processors.
    CK_Lakemont(CK_KNL.getValue() + 1),
    
    /// \name K6
    /// K6 architecture processors.
    //@{
    CK_K6(CK_Lakemont.getValue() + 1),
    CK_K6_2(CK_K6.getValue() + 1),
    CK_K6_3(CK_K6_2.getValue() + 1),
    //@}
    
    /// \name K7
    /// K7 architecture processors.
    //@{
    CK_Athlon(CK_K6_3.getValue() + 1),
    CK_AthlonThunderbird(CK_Athlon.getValue() + 1),
    CK_Athlon4(CK_AthlonThunderbird.getValue() + 1),
    CK_AthlonXP(CK_Athlon4.getValue() + 1),
    CK_AthlonMP(CK_AthlonXP.getValue() + 1),
    //@}
    
    /// \name K8
    /// K8 architecture processors.
    //@{
    CK_Athlon64(CK_AthlonMP.getValue() + 1),
    CK_Athlon64SSE3(CK_Athlon64.getValue() + 1),
    CK_AthlonFX(CK_Athlon64SSE3.getValue() + 1),
    CK_K8(CK_AthlonFX.getValue() + 1),
    CK_K8SSE3(CK_K8.getValue() + 1),
    CK_Opteron(CK_K8SSE3.getValue() + 1),
    CK_OpteronSSE3(CK_Opteron.getValue() + 1),
    CK_AMDFAM10(CK_OpteronSSE3.getValue() + 1),
    //@}
    
    /// \name Bobcat
    /// Bobcat architecture processors.
    //@{
    CK_BTVER1(CK_AMDFAM10.getValue() + 1),
    CK_BTVER2(CK_BTVER1.getValue() + 1),
    //@}
    
    /// \name Bulldozer
    /// Bulldozer architecture processors.
    //@{
    CK_BDVER1(CK_BTVER2.getValue() + 1),
    CK_BDVER2(CK_BDVER1.getValue() + 1),
    CK_BDVER3(CK_BDVER2.getValue() + 1),
    CK_BDVER4(CK_BDVER3.getValue() + 1),
    //@}
    
    /// This specification is deprecated and will be removed in the future.
    /// Users should prefer \see CK_K8.
    // FIXME: Warn on this when the CPU is set to it.
    //@{
    CK_x86_64(CK_BDVER4.getValue() + 1),
    //@}
    
    /// \name Geode
    /// Geode processors.
    //@{
    CK_Geode(CK_x86_64.getValue() + 1);
    //@}

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
  private  CPUKind CPU/* = CK_Generic*/;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getCPUKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2535,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2285,
   FQN="(anonymous namespace)::X86TargetInfo::getCPUKind", NM="_ZNK12_GLOBAL__N_113X86TargetInfo10getCPUKindEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo10getCPUKindEN4llvm9StringRefE")
  //</editor-fold>
  private CPUKind getCPUKind(StringRef CPU) /*const*/ {
    return new StringSwitch<CPUKind>(/*NO_COPY*/CPU).
        Case(/*KEEP_STR*/"i386", CPUKind.CK_i386).
        Case(/*KEEP_STR*/"i486", CPUKind.CK_i486).
        Case(/*KEEP_STR*/"winchip-c6", CPUKind.CK_WinChipC6).
        Case(/*KEEP_STR*/"winchip2", CPUKind.CK_WinChip2).
        Case(/*KEEP_STR*/"c3", CPUKind.CK_C3).
        Case(/*KEEP_STR*/"i586", CPUKind.CK_i586).
        Case(/*KEEP_STR*/"pentium", CPUKind.CK_Pentium).
        Case(/*KEEP_STR*/"pentium-mmx", CPUKind.CK_PentiumMMX).
        Case(/*KEEP_STR*/"i686", CPUKind.CK_i686).
        Case(/*KEEP_STR*/"pentiumpro", CPUKind.CK_PentiumPro).
        Case(/*KEEP_STR*/"pentium2", CPUKind.CK_Pentium2).
        Case(/*KEEP_STR*/"pentium3", CPUKind.CK_Pentium3).
        Case(/*KEEP_STR*/"pentium3m", CPUKind.CK_Pentium3M).
        Case(/*KEEP_STR*/"pentium-m", CPUKind.CK_PentiumM).
        Case(/*KEEP_STR*/"c3-2", CPUKind.CK_C3_2).
        Case(/*KEEP_STR*/"yonah", CPUKind.CK_Yonah).
        Case(/*KEEP_STR*/"pentium4", CPUKind.CK_Pentium4).
        Case(/*KEEP_STR*/"pentium4m", CPUKind.CK_Pentium4M).
        Case(/*KEEP_STR*/"prescott", CPUKind.CK_Prescott).
        Case(/*KEEP_STR*/"nocona", CPUKind.CK_Nocona).
        Case(/*KEEP_STR*/"core2", CPUKind.CK_Core2).
        Case(/*KEEP_STR*/"penryn", CPUKind.CK_Penryn).
        Case(/*KEEP_STR*/"bonnell", CPUKind.CK_Bonnell).
        Case(/*KEEP_STR*/"atom", CPUKind.CK_Bonnell). // Legacy name.
        Case(/*KEEP_STR*/"silvermont", CPUKind.CK_Silvermont).
        Case(/*KEEP_STR*/"slm", CPUKind.CK_Silvermont). // Legacy name.
        Case(/*KEEP_STR*/"nehalem", CPUKind.CK_Nehalem).
        Case(/*KEEP_STR*/"corei7", CPUKind.CK_Nehalem). // Legacy name.
        Case(/*KEEP_STR*/"westmere", CPUKind.CK_Westmere).
        Case(/*KEEP_STR*/"sandybridge", CPUKind.CK_SandyBridge).
        Case(/*KEEP_STR*/"corei7-avx", CPUKind.CK_SandyBridge). // Legacy name.
        Case(/*KEEP_STR*/"ivybridge", CPUKind.CK_IvyBridge).
        Case(/*KEEP_STR*/"core-avx-i", CPUKind.CK_IvyBridge). // Legacy name.
        Case(/*KEEP_STR*/"haswell", CPUKind.CK_Haswell).
        Case(/*KEEP_STR*/"core-avx2", CPUKind.CK_Haswell). // Legacy name.
        Case(/*KEEP_STR*/"broadwell", CPUKind.CK_Broadwell).
        Case(/*KEEP_STR*/"skylake", CPUKind.CK_SkylakeClient).
        Case(/*KEEP_STR*/"skylake-avx512", CPUKind.CK_SkylakeServer).
        Case(/*KEEP_STR*/"skx", CPUKind.CK_SkylakeServer). // Legacy name.
        Case(/*KEEP_STR*/"cannonlake", CPUKind.CK_Cannonlake).
        Case(/*KEEP_STR*/"knl", CPUKind.CK_KNL).
        Case(/*KEEP_STR*/"lakemont", CPUKind.CK_Lakemont).
        Case(/*KEEP_STR*/"k6", CPUKind.CK_K6).
        Case(/*KEEP_STR*/"k6-2", CPUKind.CK_K6_2).
        Case(/*KEEP_STR*/"k6-3", CPUKind.CK_K6_3).
        Case(/*KEEP_STR*/"athlon", CPUKind.CK_Athlon).
        Case(/*KEEP_STR*/"athlon-tbird", CPUKind.CK_AthlonThunderbird).
        Case(/*KEEP_STR*/"athlon-4", CPUKind.CK_Athlon4).
        Case(/*KEEP_STR*/"athlon-xp", CPUKind.CK_AthlonXP).
        Case(/*KEEP_STR*/"athlon-mp", CPUKind.CK_AthlonMP).
        Case(/*KEEP_STR*/"athlon64", CPUKind.CK_Athlon64).
        Case(/*KEEP_STR*/"athlon64-sse3", CPUKind.CK_Athlon64SSE3).
        Case(/*KEEP_STR*/"athlon-fx", CPUKind.CK_AthlonFX).
        Case(/*KEEP_STR*/"k8", CPUKind.CK_K8).
        Case(/*KEEP_STR*/"k8-sse3", CPUKind.CK_K8SSE3).
        Case(/*KEEP_STR*/"opteron", CPUKind.CK_Opteron).
        Case(/*KEEP_STR*/"opteron-sse3", CPUKind.CK_OpteronSSE3).
        Case(/*KEEP_STR*/"barcelona", CPUKind.CK_AMDFAM10).
        Case(/*KEEP_STR*/"amdfam10", CPUKind.CK_AMDFAM10).
        Case(/*KEEP_STR*/"btver1", CPUKind.CK_BTVER1).
        Case(/*KEEP_STR*/"btver2", CPUKind.CK_BTVER2).
        Case(/*KEEP_STR*/"bdver1", CPUKind.CK_BDVER1).
        Case(/*KEEP_STR*/"bdver2", CPUKind.CK_BDVER2).
        Case(/*KEEP_STR*/"bdver3", CPUKind.CK_BDVER3).
        Case(/*KEEP_STR*/"bdver4", CPUKind.CK_BDVER4).
        Case(/*KEEP_STR*/"x86-64", CPUKind.CK_x86_64).
        Case(/*KEEP_STR*/"geode", CPUKind.CK_Geode).
        Default(CPUKind.CK_Generic);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::FPMathKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2607,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2354,
   FQN="(anonymous namespace)::X86TargetInfo::FPMathKind", NM="_ZN12_GLOBAL__N_113X86TargetInfo10FPMathKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo10FPMathKindE")
  //</editor-fold>
  private enum FPMathKind implements Native.ComparableLower {
    FP_Default(0),
    FP_SSE(FP_Default.getValue() + 1),
    FP_387(FP_SSE.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static FPMathKind valueOf(int val) {
      FPMathKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final FPMathKind[] VALUES;
      private static final FPMathKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (FPMathKind kind : FPMathKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new FPMathKind[min < 0 ? (1-min) : 0];
        VALUES = new FPMathKind[max >= 0 ? (1+max) : 0];
        for (FPMathKind kind : FPMathKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private FPMathKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((FPMathKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((FPMathKind)obj).value);}
    //</editor-fold>
  };
  
  private  FPMathKind FPMath/* = FP_Default*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::X86TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2614,
   FQN="(anonymous namespace)::X86TargetInfo::X86TargetInfo", NM="_ZN12_GLOBAL__N_113X86TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public X86TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ $Prm1) {
    /* : TargetInfo(Triple), SSELevel(NoSSE), MMX3DNowLevel(NoMMX3DNow), XOPLevel(NoXOP), HasAES(false), HasPCLMUL(false), HasLZCNT(false), HasRDRND(false), HasFSGSBASE(false), HasBMI(false), HasBMI2(false), HasPOPCNT(false), HasRTM(false), HasPRFCHW(false), HasRDSEED(false), HasADX(false), HasTBM(false), HasFMA(false), HasF16C(false), HasAVX512CD(false), HasAVX512ER(false), HasAVX512PF(false), HasAVX512DQ(false), HasAVX512BW(false), HasAVX512VL(false), HasAVX512VBMI(false), HasAVX512IFMA(false), HasSHA(false), HasMPX(false), HasSGX(false), HasCX16(false), HasFXSR(false), HasXSAVE(false), HasXSAVEOPT(false), HasXSAVEC(false), HasXSAVES(false), HasMWAITX(false), HasPKU(false), HasCLFLUSHOPT(false), HasPCOMMIT(false), HasCLWB(false), HasUMIP(false), HasMOVBE(false), HasPREFETCHWT1(false), CPU(CK_Generic), FPMath(FP_Default)*/ 
    //START JInit
    super(Triple);
    /*InClass*/this.SSELevel = X86SSEEnum.NoSSE;
    /*InClass*/this.MMX3DNowLevel = MMX3DNowEnum.NoMMX3DNow;
    /*InClass*/this.XOPLevel = XOPEnum.NoXOP;
    /*InClass*/this.HasAES = false;
    /*InClass*/this.HasPCLMUL = false;
    /*InClass*/this.HasLZCNT = false;
    /*InClass*/this.HasRDRND = false;
    /*InClass*/this.HasFSGSBASE = false;
    /*InClass*/this.HasBMI = false;
    /*InClass*/this.HasBMI2 = false;
    /*InClass*/this.HasPOPCNT = false;
    /*InClass*/this.HasRTM = false;
    /*InClass*/this.HasPRFCHW = false;
    /*InClass*/this.HasRDSEED = false;
    /*InClass*/this.HasADX = false;
    /*InClass*/this.HasTBM = false;
    /*InClass*/this.HasFMA = false;
    /*InClass*/this.HasF16C = false;
    /*InClass*/this.HasAVX512CD = false;
    /*InClass*/this.HasAVX512ER = false;
    /*InClass*/this.HasAVX512PF = false;
    /*InClass*/this.HasAVX512DQ = false;
    /*InClass*/this.HasAVX512BW = false;
    /*InClass*/this.HasAVX512VL = false;
    /*InClass*/this.HasAVX512VBMI = false;
    /*InClass*/this.HasAVX512IFMA = false;
    /*InClass*/this.HasSHA = false;
    /*InClass*/this.HasMPX = false;
    /*InClass*/this.HasSGX = false;
    /*InClass*/this.HasCX16 = false;
    /*InClass*/this.HasFXSR = false;
    /*InClass*/this.HasXSAVE = false;
    /*InClass*/this.HasXSAVEOPT = false;
    /*InClass*/this.HasXSAVEC = false;
    /*InClass*/this.HasXSAVES = false;
    /*InClass*/this.HasMWAITX = false;
    /*InClass*/this.HasPKU = false;
    /*InClass*/this.HasCLFLUSHOPT = false;
    /*InClass*/this.HasPCOMMIT = false;
    /*InClass*/this.HasCLWB = false;
    /*InClass*/this.HasUMIP = false;
    /*InClass*/this.HasMOVBE = false;
    /*InClass*/this.HasPREFETCHWT1 = false;
    /*InClass*/this.CPU = CPUKind.CK_Generic;
    /*InClass*/this.FPMath = FPMathKind.FP_Default;
    //END JInit
    BigEndian = false;
    LongDoubleFormat = $AddrOf(APFloat.x87DoubleExtended);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getFloatEvalMethod">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2619,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2365,
   FQN="(anonymous namespace)::X86TargetInfo::getFloatEvalMethod", NM="_ZNK12_GLOBAL__N_113X86TargetInfo18getFloatEvalMethodEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo18getFloatEvalMethodEv")
  //</editor-fold>
  @Override public /*uint*/int getFloatEvalMethod() /*const*//* override*/ {
    // X87 evaluates with 80 bits "long double" precision.
    return SSELevel == X86SSEEnum.NoSSE ? 2 : 0;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getTargetBuiltins">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2623,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2369,
   FQN="(anonymous namespace)::X86TargetInfo::getTargetBuiltins", NM="_ZNK12_GLOBAL__N_113X86TargetInfo17getTargetBuiltinsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo17getTargetBuiltinsEv")
  //</editor-fold>
  @Override public ArrayRef<Builtin.Info> getTargetBuiltins() /*const*//* override*/ {
    return llvm.makeArrayRef(BuiltinInfo$Clang$Targets, 
        X86.LastTSBuiltin - Builtin.ID.FirstTSBuiltin.getValue());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getGCCRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2627,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2373,
   FQN="(anonymous namespace)::X86TargetInfo::getGCCRegNames", NM="_ZNK12_GLOBAL__N_113X86TargetInfo14getGCCRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo14getGCCRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef</*const*/char$ptr/*char P*/ > getGCCRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(GCCRegNames);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getGCCRegAliases">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2630,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2376,
   FQN="(anonymous namespace)::X86TargetInfo::getGCCRegAliases", NM="_ZNK12_GLOBAL__N_113X86TargetInfo16getGCCRegAliasesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo16getGCCRegAliasesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.GCCRegAlias> getGCCRegAliases() /*const*//* override*/ {
    return ArrayRef.<TargetInfo.GCCRegAlias>None();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getGCCAddlRegNames">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2633,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2379,
   FQN="(anonymous namespace)::X86TargetInfo::getGCCAddlRegNames", NM="_ZNK12_GLOBAL__N_113X86TargetInfo18getGCCAddlRegNamesEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo18getGCCAddlRegNamesEv")
  //</editor-fold>
  @Override public ArrayRef<TargetInfo.AddlRegName> getGCCAddlRegNames() /*const*//* override*/ {
    return llvm.makeArrayRef(AddlRegNames);
  }

  
  // We can't use a generic validation scheme for the features accepted here
  // versus subtarget features accepted in the target attribute because the
  // bitfield structure that's initialized in the runtime only supports the
  // below currently rather than the full range of subtarget features. (See
  // X86TargetInfo::hasFeature for a somewhat comprehensive list).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::validateCpuSupports">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3803,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3474,
   FQN="(anonymous namespace)::X86TargetInfo::validateCpuSupports", NM="_ZNK12_GLOBAL__N_113X86TargetInfo19validateCpuSupportsEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo19validateCpuSupportsEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean validateCpuSupports(StringRef FeatureStr) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/FeatureStr).
        Case(/*KEEP_STR*/"cmov", true).
        Case(/*KEEP_STR*/"mmx", true).
        Case(/*KEEP_STR*/"popcnt", true).
        Case(/*KEEP_STR*/"sse", true).
        Case(/*KEEP_STR*/"sse2", true).
        Case(/*KEEP_STR*/"sse3", true).
        Case(/*KEEP_STR*/"ssse3", true).
        Case(/*KEEP_STR*/"sse4.1", true).
        Case(/*KEEP_STR*/"sse4.2", true).
        Case(/*KEEP_STR*/"avx", true).
        Case(/*KEEP_STR*/"avx2", true).
        Case(/*KEEP_STR*/"sse4a", true).
        Case(/*KEEP_STR*/"fma4", true).
        Case(/*KEEP_STR*/"xop", true).
        Case(/*KEEP_STR*/"fma", true).
        Case(/*KEEP_STR*/"avx512f", true).
        Case(/*KEEP_STR*/"bmi", true).
        Case(/*KEEP_STR*/"bmi2", true).
        Case(/*KEEP_STR*/"aes", true).
        Case(/*KEEP_STR*/"pclmul", true).
        Case(/*KEEP_STR*/"avx512vl", true).
        Case(/*KEEP_STR*/"avx512bw", true).
        Case(/*KEEP_STR*/"avx512dq", true).
        Case(/*KEEP_STR*/"avx512cd", true).
        Case(/*KEEP_STR*/"avx512er", true).
        Case(/*KEEP_STR*/"avx512pf", true).
        Case(/*KEEP_STR*/"avx512vbmi", true).
        Case(/*KEEP_STR*/"avx512ifma", true).
        Default(false);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::validateAsmConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3836,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3496,
   FQN="(anonymous namespace)::X86TargetInfo::validateAsmConstraint", NM="_ZNK12_GLOBAL__N_113X86TargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo21validateAsmConstraintERPKcRN5clang10TargetInfo14ConstraintInfoE")
  //</editor-fold>
  @Override public boolean validateAsmConstraint(char$ptr/*const char P &*/ Name, 
                       TargetInfo.ConstraintInfo /*&*/ Info) /*const*//* override*/ {
    switch (Name.$star()) {
     default:
      return false;
     case 'e': // 32-bit signed integer constant for use with sign-extending x86_64
      // instructions.
     case 'Z': // 32-bit unsigned integer constant for use with zero-extending
      // x86_64 instructions.
     case 's':
      Info.setRequiresImmediate();
      return true;
     case 'I':
      Info.setRequiresImmediate(0, 31);
      return true;
     case 'J':
      Info.setRequiresImmediate(0, 63);
      return true;
     case 'K':
      Info.setRequiresImmediate(-128, 127);
      return true;
     case 'L':
      Info.setRequiresImmediate(/*{ */new ArrayRefInt(new$int(3, ((int)(0xff)), ((int)(0xffff)), ((int)(0xffffffff/*U*/))))/* }*/);
      return true;
     case 'M':
      Info.setRequiresImmediate(0, 3);
      return true;
     case 'N':
      Info.setRequiresImmediate(0, 255);
      return true;
     case 'O':
      Info.setRequiresImmediate(0, 127);
      return true;
     case 'Y': // 'Y' is the first character for several 2-character constraints.
      // Shift the pointer to the second character of the constraint.
      Name.$postInc();
      switch (Name.$star()) {
       default:
        return false;
       case '0': // First SSE register.
       case 't': // Any SSE register, when SSE2 is enabled.
       case 'i': // Any SSE register, when SSE2 and inter-unit moves enabled.
       case 'm': // Any MMX register, when inter-unit moves enabled.
        Info.setAllowsRegister();
        return true;
      }
     case 'f': // Any x87 floating point stack register.
      // Constraint 'f' cannot be used for output operands.
      if (Info.ConstraintStr.$at(0) == $$EQ) {
        return false;
      }
      Info.setAllowsRegister();
      return true;
     case 'a': // eax.
     case 'b': // ebx.
     case 'c': // ecx.
     case 'd': // edx.
     case 'S': // esi.
     case 'D': // edi.
     case 'A': // edx:eax.
     case 't': // Top of floating point stack.
     case 'u': // Second from top of floating point stack.
     case 'q': // Any register accessible as [r]l: a, b, c, and d.
     case 'y': // Any MMX register.
     case 'x': // Any SSE register.
     case 'Q': // Any register accessible as [r]h: a, b, c, and d.
     case 'R': // "Legacy" registers: ax, bx, cx, dx, di, si, sp, bp.
     case 'l': // "Index" registers: any general register that can be used as an
      // index in a base+index memory access.
      Info.setAllowsRegister();
      return true;
     case 'C': // SSE floating point constant.
     case 'G': // x87 floating point constant.
      return true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::validateGlobalRegisterVariable">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2640,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2386,
   FQN="(anonymous namespace)::X86TargetInfo::validateGlobalRegisterVariable", NM="_ZNK12_GLOBAL__N_113X86TargetInfo30validateGlobalRegisterVariableEN4llvm9StringRefEjRb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo30validateGlobalRegisterVariableEN4llvm9StringRefEjRb")
  //</editor-fold>
  @Override public boolean validateGlobalRegisterVariable(StringRef RegName, 
                                /*uint*/int RegSize, 
                                bool$ref/*bool &*/ HasSizeMismatch) /*const*//* override*/ {
    // esp and ebp are the only 32-bit registers the x86 backend can currently
    // handle.
    if (RegName.equals(/*STRINGREF_STR*/"esp") || RegName.equals(/*STRINGREF_STR*/"ebp")) {
      // Check that the register size is 32-bit.
      HasSizeMismatch.$set(RegSize != 32);
      return true;
    }
    
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::validateOutputSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3915,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3575,
   FQN="(anonymous namespace)::X86TargetInfo::validateOutputSize", NM="_ZNK12_GLOBAL__N_113X86TargetInfo18validateOutputSizeEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo18validateOutputSizeEN4llvm9StringRefEj")
  //</editor-fold>
  @Override public boolean validateOutputSize(StringRef Constraint, 
                    /*uint*/int Size) /*const*//* override*/ {
    // Strip off constraint modifiers.
    while (Constraint.$at(0) == $$EQ
       || Constraint.$at(0) == $$PLUS
       || Constraint.$at(0) == $$AMP) {
      Constraint.$assignMove(Constraint.substr(1));
    }
    
    return validateOperandSize(/*NO_COPY*/Constraint, Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::validateInputSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3926,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3586,
   FQN="(anonymous namespace)::X86TargetInfo::validateInputSize", NM="_ZNK12_GLOBAL__N_113X86TargetInfo17validateInputSizeEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo17validateInputSizeEN4llvm9StringRefEj")
  //</editor-fold>
  @Override public boolean validateInputSize(StringRef Constraint, 
                   /*uint*/int Size) /*const*//* override*/ {
    return validateOperandSize(/*NO_COPY*/Constraint, Size);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::validateOperandSize">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3931,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3591,
   FQN="(anonymous namespace)::X86TargetInfo::validateOperandSize", NM="_ZNK12_GLOBAL__N_113X86TargetInfo19validateOperandSizeEN4llvm9StringRefEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo19validateOperandSizeEN4llvm9StringRefEj")
  //</editor-fold>
  public boolean validateOperandSize(StringRef Constraint, 
                     /*uint*/int Size) /*const*/ {
    switch (Constraint.$at(0)) {
     default:
      break;
     case 'y':
      return $lesseq_uint(Size, 64);
     case 'f':
     case 't':
     case 'u':
      return $lesseq_uint(Size, 128);
     case 'x':
      if (SSELevel.getValue() >= X86SSEEnum.AVX512F.getValue()) {
        // 512-bit zmm registers can be used if target supports AVX512F.
        return $lesseq_uint(Size, 512/*U*/);
      } else if (SSELevel.getValue() >= X86SSEEnum.AVX.getValue()) {
        // 256-bit ymm registers can be used if target supports AVX.
        return $lesseq_uint(Size, 256/*U*/);
      }
      return $lesseq_uint(Size, 128/*U*/);
     case 'Y':
      // 'Y' is the first character for several 2-character constraints.
      switch (Constraint.$at(1)) {
       default:
        break;
       case 'm':
        // 'Ym' is synonymous with 'y'.
        return $lesseq_uint(Size, 64);
       case 'i':
       case 't':
        // 'Yi' and 'Yt' are synonymous with 'x' when SSE2 is enabled.
        if (SSELevel.getValue() >= X86SSEEnum.AVX512F.getValue()) {
          return $lesseq_uint(Size, 512/*U*/);
        } else if (SSELevel.getValue() >= X86SSEEnum.AVX.getValue()) {
          return $lesseq_uint(Size, 256/*U*/);
        }
        return SSELevel.getValue() >= X86SSEEnum.SSE2.getValue() && $lesseq_uint(Size, 128/*U*/);
      }
    }
    
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::convertConstraint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3971,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3631,
   FQN="(anonymous namespace)::X86TargetInfo::convertConstraint", NM="_ZNK12_GLOBAL__N_113X86TargetInfo17convertConstraintERPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo17convertConstraintERPKc")
  //</editor-fold>
  @Override public std.string convertConstraint(char$ptr/*const char P &*/ Constraint) /*const*//* override*/ {
    switch (Constraint.$star()) {
     case 'a':
      return new std.string(/*KEEP_STR*/"{ax}");
     case 'b':
      return new std.string(/*KEEP_STR*/"{bx}");
     case 'c':
      return new std.string(/*KEEP_STR*/"{cx}");
     case 'd':
      return new std.string(/*KEEP_STR*/"{dx}");
     case 'S':
      return new std.string(/*KEEP_STR*/"{si}");
     case 'D':
      return new std.string(/*KEEP_STR*/"{di}");
     case 'p': // address
      return new std.string(/*KEEP_STR*/"im");
     case 't': // top of floating point stack.
      return new std.string(/*KEEP_STR*/"{st}");
     case 'u': // second from top of floating point stack.
      return new std.string(/*KEEP_STR*/"{st(1)}"); // second from top of floating point stack.
     default:
      return new std.string(1, Constraint.$star());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getClobbers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2661,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2407,
   FQN="(anonymous namespace)::X86TargetInfo::getClobbers", NM="_ZNK12_GLOBAL__N_113X86TargetInfo11getClobbersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo11getClobbersEv")
  //</editor-fold>
  @Override public /*const*/char$ptr/*char P*/ getClobbers() /*const*//* override*/ {
    return $("~{dirflag},~{fpsr},~{flags}");
  }

  
  /// X86TargetInfo::getTargetDefines - Return the set of the X86-specific macro
  /// definitions for this particular subtarget.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3402,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3092,
   FQN="(anonymous namespace)::X86TargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_113X86TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    // Target identification.
    if (getTriple().getArch() == Triple.ArchType.x86_64) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__amd64__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__amd64"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__x86_64"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__x86_64__"));
      if ($eq_StringRef(getTriple().getArchName(), /*STRINGREF_STR*/"x86_64h")) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__x86_64h"));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__x86_64h__"));
      }
    } else {
      DefineStd(Builder, new StringRef(/*KEEP_STR*/"i386"), Opts);
    }
    
    // Subtarget options.
    // FIXME: We are hard-coding the tune parameters based on the CPU, but they
    // truly should be based on -mtune options.
    switch (CPU) {
     case CK_Generic:
      break;
     case CK_i386:
      // The rest are coming from the i386 define above.
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_i386__"));
      break;
     case CK_i486:
     case CK_WinChipC6:
     case CK_WinChip2:
     case CK_C3:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"i486"));
      break;
     case CK_PentiumMMX:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__pentium_mmx__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_pentium_mmx__"));
     case CK_i586:
     case CK_Pentium:
      // Fallthrough
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"i586"));
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"pentium"));
      break;
     case CK_Pentium3:
     case CK_Pentium3M:
     case CK_PentiumM:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_pentium3__"));
     case CK_Pentium2:
     case CK_C3_2:
      // Fallthrough
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_pentium2__"));
     case CK_PentiumPro:
      // Fallthrough
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_i686__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_pentiumpro__"));
     case CK_i686:
      // Fallthrough
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__i686"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__i686__"));
      // Strangely, __tune_i686__ isn't defined by GCC when CPU == i686.
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__pentiumpro"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__pentiumpro__"));
      break;
     case CK_Pentium4:
     case CK_Pentium4M:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"pentium4"));
      break;
     case CK_Yonah:
     case CK_Prescott:
     case CK_Nocona:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"nocona"));
      break;
     case CK_Core2:
     case CK_Penryn:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"core2"));
      break;
     case CK_Bonnell:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"atom"));
      break;
     case CK_Silvermont:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"slm"));
      break;
     case CK_Nehalem:
     case CK_Westmere:
     case CK_SandyBridge:
     case CK_IvyBridge:
     case CK_Haswell:
     case CK_Broadwell:
     case CK_SkylakeClient:
      // FIXME: Historically, we defined this legacy name, it would be nice to
      // remove it at some point. We've never exposed fine-grained names for
      // recent primary x86 CPUs, and we should keep it that way.
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"corei7"));
      break;
     case CK_SkylakeServer:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"skx"));
      break;
     case CK_Cannonlake:
      break;
     case CK_KNL:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"knl"));
      break;
     case CK_Lakemont:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_lakemont__"));
      break;
     case CK_K6_2:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__k6_2__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_k6_2__"));
     case CK_K6_3:
      // Fallthrough
      if (CPU != CPUKind.CK_K6_2) { // In case of fallthrough
// FIXME: GCC may be enabling these in cases where some other k6
// architecture is specified but -m3dnow is explicitly provided. The
// exact semantics need to be determined and emulated here.
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__k6_3__"));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_k6_3__"));
      }
     case CK_K6:
      // Fallthrough
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"k6"));
      break;
     case CK_Athlon:
     case CK_AthlonThunderbird:
     case CK_Athlon4:
     case CK_AthlonXP:
     case CK_AthlonMP:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"athlon"));
      if (SSELevel != X86SSEEnum.NoSSE) {
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__athlon_sse__"));
        Builder.defineMacro(new Twine(/*KEEP_STR*/"__tune_athlon_sse__"));
      }
      break;
     case CK_K8:
     case CK_K8SSE3:
     case CK_x86_64:
     case CK_Opteron:
     case CK_OpteronSSE3:
     case CK_Athlon64:
     case CK_Athlon64SSE3:
     case CK_AthlonFX:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"k8"));
      break;
     case CK_AMDFAM10:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"amdfam10"));
      break;
     case CK_BTVER1:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"btver1"));
      break;
     case CK_BTVER2:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"btver2"));
      break;
     case CK_BDVER1:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"bdver1"));
      break;
     case CK_BDVER2:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"bdver2"));
      break;
     case CK_BDVER3:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"bdver3"));
      break;
     case CK_BDVER4:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"bdver4"));
      break;
     case CK_Geode:
      defineCPUMacros(Builder, new StringRef(/*KEEP_STR*/"geode"));
      break;
    }
    
    // Target properties.
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__REGISTER_PREFIX__"), new Twine(/*KEEP_STR*/$EMPTY));
    
    // Define __NO_MATH_INLINES on linux/x86 so that we don't get inline
    // functions in glibc header files that use FP Stack inline asm which the
    // backend can't deal with (PR879).
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__NO_MATH_INLINES"));
    if (HasAES) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AES__"));
    }
    if (HasPCLMUL) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__PCLMUL__"));
    }
    if (HasLZCNT) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__LZCNT__"));
    }
    if (HasRDRND) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__RDRND__"));
    }
    if (HasFSGSBASE) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__FSGSBASE__"));
    }
    if (HasBMI) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__BMI__"));
    }
    if (HasBMI2) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__BMI2__"));
    }
    if (HasPOPCNT) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__POPCNT__"));
    }
    if (HasRTM) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__RTM__"));
    }
    if (HasPRFCHW) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__PRFCHW__"));
    }
    if (HasRDSEED) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__RDSEED__"));
    }
    if (HasADX) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__ADX__"));
    }
    if (HasTBM) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__TBM__"));
    }
    if (HasMWAITX) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__MWAITX__"));
    }
    switch (XOPLevel) {
     case XOP:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__XOP__"));
     case FMA4:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__FMA4__"));
     case SSE4A:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE4A__"));
     case NoXOP:
      break;
    }
    if (HasFMA) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__FMA__"));
    }
    if (HasF16C) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__F16C__"));
    }
    if (HasAVX512CD) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512CD__"));
    }
    if (HasAVX512ER) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512ER__"));
    }
    if (HasAVX512PF) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512PF__"));
    }
    if (HasAVX512DQ) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512DQ__"));
    }
    if (HasAVX512BW) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512BW__"));
    }
    if (HasAVX512VL) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512VL__"));
    }
    if (HasAVX512VBMI) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512VBMI__"));
    }
    if (HasAVX512IFMA) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512IFMA__"));
    }
    if (HasSHA) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SHA__"));
    }
    if (HasFXSR) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__FXSR__"));
    }
    if (HasXSAVE) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__XSAVE__"));
    }
    if (HasXSAVEOPT) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__XSAVEOPT__"));
    }
    if (HasXSAVEC) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__XSAVEC__"));
    }
    if (HasXSAVES) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__XSAVES__"));
    }
    if (HasPKU) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__PKU__"));
    }
    if (HasCX16) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_16"));
    }
    
    // Each case falls through to the previous one here.
    switch (SSELevel) {
     case AVX512F:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX512F__"));
     case AVX2:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX2__"));
     case AVX:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__AVX__"));
     case SSE42:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE4_2__"));
     case SSE41:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE4_1__"));
     case SSSE3:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSSE3__"));
     case SSE3:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE3__"));
     case SSE2:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE2__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE2_MATH__")); // -mfp-math=sse always implied.
     case SSE1:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE__"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SSE_MATH__")); // -mfp-math=sse always implied.
     case NoSSE:
      break;
    }
    if (Opts.MicrosoftExt && getTriple().getArch() == Triple.ArchType.x86) {
      switch (SSELevel) {
       case AVX512F:
       case AVX2:
       case AVX:
       case SSE42:
       case SSE41:
       case SSSE3:
       case SSE3:
       case SSE2:
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_IX86_FP"), new Twine(JD$Int.INSTANCE, 2));
        break;
       case SSE1:
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_IX86_FP"), new Twine(JD$Int.INSTANCE, 1));
        break;
       default:
        Builder.defineMacro(new Twine(/*KEEP_STR*/"_M_IX86_FP"), new Twine(JD$Int.INSTANCE, 0));
      }
    }
    
    // Each case falls through to the previous one here.
    switch (MMX3DNowLevel) {
     case AMD3DNowAthlon:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__3dNOW_A__"));
     case AMD3DNow:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__3dNOW__"));
     case MMX:
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__MMX__"));
     case NoMMX3DNow:
      break;
    }
    if (CPU.getValue() >= CPUKind.CK_i486.getValue()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_1"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_2"));
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_4"));
    }
    if (CPU.getValue() >= CPUKind.CK_i586.getValue()) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__GCC_HAVE_SYNC_COMPARE_AND_SWAP_8"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setSSELevel">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3076,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2786,
   FQN="(anonymous namespace)::X86TargetInfo::setSSELevel", NM="_ZN12_GLOBAL__N_113X86TargetInfo11setSSELevelERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS0_10X86SSEEnumEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo11setSSELevelERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS0_10X86SSEEnumEb")
  //</editor-fold>
  public static void setSSELevel(StringMapBool/*&*/ Features, 
             X86SSEEnum Level, boolean Enabled) {
    if (Enabled) {
      switch (Level) {
       case AVX512F:
        Features.$set(/*STRINGREF_STR*/"avx512f", true);
       case AVX2:
        Features.$set(/*STRINGREF_STR*/"avx2", true);
       case AVX:
        Features.$set(/*STRINGREF_STR*/"avx", true);
        Features.$set(/*STRINGREF_STR*/"xsave", true);
       case SSE42:
        Features.$set(/*STRINGREF_STR*/"sse4.2", true);
       case SSE41:
        Features.$set(/*STRINGREF_STR*/"sse4.1", true);
       case SSSE3:
        Features.$set(/*STRINGREF_STR*/"ssse3", true);
       case SSE3:
        Features.$set(/*STRINGREF_STR*/"sse3", true);
       case SSE2:
        Features.$set(/*STRINGREF_STR*/"sse2", true);
       case SSE1:
        Features.$set(/*STRINGREF_STR*/"sse", true);
       case NoSSE:
        break;
      }
      return;
    }
    switch (Level) {
     case NoSSE:
     case SSE1:
      Features.$set(/*STRINGREF_STR*/"sse", false);
     case SSE2:
      Features.$set(/*STRINGREF_STR*/"sse2", false);
      Features.$set(/*STRINGREF_STR*/"pclmul", false);
      Features.$set(/*STRINGREF_STR*/"aes", false);
      Features.$set(/*STRINGREF_STR*/"sha", false);
     case SSE3:
      Features.$set(/*STRINGREF_STR*/"sse3", false);
      setXOPLevel(Features, XOPEnum.NoXOP, false);
     case SSSE3:
      Features.$set(/*STRINGREF_STR*/"ssse3", false);
     case SSE41:
      Features.$set(/*STRINGREF_STR*/"sse4.1", false);
     case SSE42:
      Features.$set(/*STRINGREF_STR*/"sse4.2", false);
     case AVX:
      Features.$set(/*STRINGREF_STR*/"fma", false);
      Features.$set(/*STRINGREF_STR*/"avx", false);
      Features.$set(/*STRINGREF_STR*/"f16c", false);
      Features.$set(/*STRINGREF_STR*/"xsave", false);
      Features.$set(/*STRINGREF_STR*/"xsaveopt", false);
      setXOPLevel(Features, XOPEnum.FMA4, false);
     case AVX2:
      Features.$set(/*STRINGREF_STR*/"avx2", false);
     case AVX512F:
      Features.$set(/*STRINGREF_STR*/"avx512f", false);
      Features.$set(/*STRINGREF_STR*/"avx512cd", false);
      Features.$set(/*STRINGREF_STR*/"avx512er", false);
      Features.$set(/*STRINGREF_STR*/"avx512pf", false);
      Features.$set(/*STRINGREF_STR*/"avx512dq", false);
      Features.$set(/*STRINGREF_STR*/"avx512bw", false);
      Features.$set(/*STRINGREF_STR*/"avx512vl", false);
      Features.$set(/*STRINGREF_STR*/"avx512vbmi", false);
      Features.$set(/*STRINGREF_STR*/"avx512ifma", false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setMMXLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2844,
   FQN="(anonymous namespace)::X86TargetInfo::setMMXLevel", NM="_ZN12_GLOBAL__N_113X86TargetInfo11setMMXLevelERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS0_12MMX3DNowEnumEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo11setMMXLevelERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS0_12MMX3DNowEnumEb")
  //</editor-fold>
  public static void setMMXLevel(StringMapBool/*&*/ Features, 
             MMX3DNowEnum Level, boolean Enabled) {
    if (Enabled) {
      switch (Level) {
       case AMD3DNowAthlon:
        Features.$set(/*STRINGREF_STR*/"3dnowa", true);
       case AMD3DNow:
        Features.$set(/*STRINGREF_STR*/"3dnow", true);
       case MMX:
        Features.$set(/*STRINGREF_STR*/"mmx", true);
       case NoMMX3DNow:
        break;
      }
      return;
    }
    switch (Level) {
     case NoMMX3DNow:
     case MMX:
      Features.$set(/*STRINGREF_STR*/"mmx", false);
     case AMD3DNow:
      Features.$set(/*STRINGREF_STR*/"3dnow", false);
     case AMD3DNowAthlon:
      Features.$set(/*STRINGREF_STR*/"3dnowa", false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setXOPLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3162,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2871,
   FQN="(anonymous namespace)::X86TargetInfo::setXOPLevel", NM="_ZN12_GLOBAL__N_113X86TargetInfo11setXOPLevelERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS0_7XOPEnumEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo11setXOPLevelERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS0_7XOPEnumEb")
  //</editor-fold>
  public static void setXOPLevel(StringMapBool/*&*/ Features, XOPEnum Level, 
             boolean Enabled) {
    if (Enabled) {
      switch (Level) {
       case XOP:
        Features.$set(/*STRINGREF_STR*/"xop", true);
       case FMA4:
        Features.$set(/*STRINGREF_STR*/"fma4", true);
        setSSELevel(Features, X86SSEEnum.AVX, true);
       case SSE4A:
        Features.$set(/*STRINGREF_STR*/"sse4a", true);
        setSSELevel(Features, X86SSEEnum.SSE3, true);
       case NoXOP:
        break;
      }
      return;
    }
    switch (Level) {
     case NoXOP:
     case SSE4A:
      Features.$set(/*STRINGREF_STR*/"sse4a", false);
     case FMA4:
      Features.$set(/*STRINGREF_STR*/"fma4", false);
     case XOP:
      Features.$set(/*STRINGREF_STR*/"xop", false);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setFeatureEnabled">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2672,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2418,
   FQN="(anonymous namespace)::X86TargetInfo::setFeatureEnabled", NM="_ZNK12_GLOBAL__N_113X86TargetInfo17setFeatureEnabledERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo17setFeatureEnabledERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb")
  //</editor-fold>
  @Override public void setFeatureEnabled(StringMapBool/*&*/ Features, 
                   StringRef Name, boolean Enabled) /*const*//* override*/ {
    setFeatureEnabledImpl(Features, /*NO_COPY*/Name, Enabled);
  }

  // This exists purely to cut down on the number of virtual calls in
  // initFeatureMap which calls this repeatedly.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setFeatureEnabledImpl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3191,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2900,
   FQN="(anonymous namespace)::X86TargetInfo::setFeatureEnabledImpl", NM="_ZN12_GLOBAL__N_113X86TargetInfo21setFeatureEnabledImplERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo21setFeatureEnabledImplERN4llvm9StringMapIbNS1_15MallocAllocatorEEENS1_9StringRefEb")
  //</editor-fold>
  public static void setFeatureEnabledImpl(StringMapBool/*&*/ Features, 
                       StringRef Name, boolean Enabled) {
    // This is a bit of a hack to deal with the sse4 target feature when used
    // as part of the target attribute. We handle sse4 correctly everywhere
    // else. See below for more information on how we handle the sse4 options.
    if ($noteq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse4")) {
      Features.$set(/*NO_COPY*/Name, Enabled);
    }
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"mmx")) {
      setMMXLevel(Features, MMX3DNowEnum.MMX, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse")) {
      setSSELevel(Features, X86SSEEnum.SSE1, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse2")) {
      setSSELevel(Features, X86SSEEnum.SSE2, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse3")) {
      setSSELevel(Features, X86SSEEnum.SSE3, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"ssse3")) {
      setSSELevel(Features, X86SSEEnum.SSSE3, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse4.2")) {
      setSSELevel(Features, X86SSEEnum.SSE42, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse4.1")) {
      setSSELevel(Features, X86SSEEnum.SSE41, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"3dnow")) {
      setMMXLevel(Features, MMX3DNowEnum.AMD3DNow, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"3dnowa")) {
      setMMXLevel(Features, MMX3DNowEnum.AMD3DNowAthlon, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"aes")) {
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.SSE2, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"pclmul")) {
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.SSE2, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx")) {
      setSSELevel(Features, X86SSEEnum.AVX, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx2")) {
      setSSELevel(Features, X86SSEEnum.AVX2, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512f")) {
      setSSELevel(Features, X86SSEEnum.AVX512F, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512cd") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512er") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512pf")
       || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512dq") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512bw") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512vl")
       || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512vbmi") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"avx512ifma")) {
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.AVX512F, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"fma")) {
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.AVX, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"fma4")) {
      setXOPLevel(Features, XOPEnum.FMA4, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xop")) {
      setXOPLevel(Features, XOPEnum.XOP, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse4a")) {
      setXOPLevel(Features, XOPEnum.SSE4A, Enabled);
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"f16c")) {
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.AVX, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sha")) {
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.SSE2, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse4")) {
      // We can get here via the __target__ attribute since that's not controlled
      // via the -msse4/-mno-sse4 command line alias. Handle this the same way
      // here - turn on the sse4.2 if enabled, turn off the sse4.1 level if
      // disabled.
      if (Enabled) {
        setSSELevel(Features, X86SSEEnum.SSE42, Enabled);
      } else {
        setSSELevel(Features, X86SSEEnum.SSE41, Enabled);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xsave")) {
      if (!Enabled) {
        Features.$set(/*STRINGREF_STR*/"xsaveopt", false);
      }
    } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xsaveopt") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xsavec") || $eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"xsaves")) {
      if (Enabled) {
        Features.$set(/*STRINGREF_STR*/"xsave", true);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::initFeatureMap">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2822,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2555,
   FQN="(anonymous namespace)::X86TargetInfo::initFeatureMap", NM="_ZNK12_GLOBAL__N_113X86TargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo14initFeatureMapERN4llvm9StringMapIbNS1_15MallocAllocatorEEERN5clang17DiagnosticsEngineENS1_9StringRefERKSt6vectorISsSaISsEE")
  //</editor-fold>
  @Override public boolean initFeatureMap(StringMapBool/*&*/ Features, DiagnosticsEngine /*&*/ Diags, StringRef CPU, 
                /*const*/std.vectorString/*&*/ FeaturesVec) /*const*//* override*/ {
    // FIXME: This *really* should not be here.
    // X86_64 always has SSE2.
    if (getTriple().getArch() == Triple.ArchType.x86_64) {
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse2"), true);
    }
    
    /*const*/ CPUKind Kind = getCPUKind(/*NO_COPY*/CPU);
    
    // Enable X87 for all X86 processors but Lakemont.
    if (Kind != CPUKind.CK_Lakemont) {
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"x87"), true);
    }
    switch (Kind) {
     case CK_Generic:
     case CK_i386:
     case CK_i486:
     case CK_i586:
     case CK_Pentium:
     case CK_i686:
     case CK_PentiumPro:
     case CK_Lakemont:
      break;
     case CK_PentiumMMX:
     case CK_Pentium2:
     case CK_K6:
     case CK_WinChipC6:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"mmx"), true);
      break;
     case CK_Pentium3:
     case CK_Pentium3M:
     case CK_C3_2:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      break;
     case CK_PentiumM:
     case CK_Pentium4:
     case CK_Pentium4M:
     case CK_x86_64:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      break;
     case CK_Yonah:
     case CK_Prescott:
     case CK_Nocona:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse3"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      break;
     case CK_Core2:
     case CK_Bonnell:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"ssse3"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      break;
     case CK_Penryn:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse4.1"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      break;
     case CK_Cannonlake:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512ifma"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512vbmi"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sha"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"umip"), true);
     case CK_SkylakeServer:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512f"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512cd"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512dq"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512bw"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512vl"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"pku"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"pcommit"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"clwb"), true);
     case CK_SkylakeClient:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsavec"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsaves"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"mpx"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sgx"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"clflushopt"), true);
     case CK_Broadwell:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"rdseed"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"adx"), true);
     case CK_Haswell:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"lzcnt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"rtm"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fma"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"movbe"), true);
     case CK_IvyBridge:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"rdrnd"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"f16c"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fsgsbase"), true);
     case CK_SandyBridge:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsave"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsaveopt"), true);
     case CK_Westmere:
     case CK_Silvermont:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"aes"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"pclmul"), true);
     case CK_Nehalem:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse4.2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      break;
     case CK_KNL:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512f"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512cd"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512er"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx512pf"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"prefetchwt1"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"rdseed"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"adx"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"lzcnt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"rtm"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fma"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"rdrnd"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"f16c"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fsgsbase"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"aes"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"pclmul"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsaveopt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsave"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"movbe"), true);
      break;
     case CK_K6_2:
     case CK_K6_3:
     case CK_WinChip2:
     case CK_C3:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"3dnow"), true);
      break;
     case CK_Athlon:
     case CK_AthlonThunderbird:
     case CK_Geode:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"3dnowa"), true);
      break;
     case CK_Athlon4:
     case CK_AthlonXP:
     case CK_AthlonMP:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"3dnowa"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      break;
     case CK_K8:
     case CK_Opteron:
     case CK_Athlon64:
     case CK_AthlonFX:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"3dnowa"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      break;
     case CK_AMDFAM10:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse4a"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"lzcnt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"popcnt"), true);
     case CK_K8SSE3:
     case CK_OpteronSSE3:
     case CK_Athlon64SSE3:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse3"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"3dnowa"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      break;
     case CK_BTVER2:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"aes"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"pclmul"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"f16c"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsaveopt"), true);
     case CK_BTVER1:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"ssse3"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"sse4a"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"lzcnt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"popcnt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"prfchw"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      break;
     case CK_BDVER4:
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"avx2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi2"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"mwaitx"), true);
     case CK_BDVER3:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fsgsbase"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsaveopt"), true);
     case CK_BDVER2:
      // FALLTHROUGH
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"bmi"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fma"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"f16c"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"tbm"), true);
     case CK_BDVER1:
      // xop implies avx, sse4a and fma4.
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xop"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"lzcnt"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"aes"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"pclmul"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"prfchw"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"cx16"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"fxsr"), true);
      setFeatureEnabledImpl(Features, new StringRef(/*KEEP_STR*/"xsave"), true);
      break;
    }
    if (!super.initFeatureMap(Features, Diags, /*NO_COPY*/CPU, FeaturesVec)) {
      return false;
    }
    
    // Can't do this earlier because we need to be able to explicitly enable
    // or disable these features and the things that they depend upon.
    
    // Enable popcnt if sse4.2 is enabled and popcnt is not explicitly disabled.
    StringMapIteratorBool I = Features.find(/*STRINGREF_STR*/"sse4.2");
    if (I.$noteq(Features.end()) && I.$arrow().getValue()
       && $eq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"-popcnt"), 
        FeaturesVec.end())) {
      Features.$set(/*STRINGREF_STR*/"popcnt", true);
    }
    
    // Enable prfchw if 3DNow! is enabled and prfchw is not explicitly disabled.
    I.$assignMove(Features.find(/*STRINGREF_STR*/"3dnow"));
    if (I.$noteq(Features.end()) && I.$arrow().getValue()
       && $eq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"-prfchw"), 
        FeaturesVec.end())) {
      Features.$set(/*STRINGREF_STR*/"prfchw", true);
    }
    
    // Additionally, if SSE is enabled and mmx is not explicitly disabled,
    // then enable MMX.
    I.$assignMove(Features.find(/*STRINGREF_STR*/"sse"));
    if (I.$noteq(Features.end()) && I.$arrow().getValue()
       && $eq___normal_iterator$C(std.find(FeaturesVec.begin(), FeaturesVec.end(), /*KEEP_STR*/"-mmx"), 
        FeaturesVec.end())) {
      Features.$set(/*STRINGREF_STR*/"mmx", true);
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::hasFeature">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3737,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 3418,
   FQN="(anonymous namespace)::X86TargetInfo::hasFeature", NM="_ZNK12_GLOBAL__N_113X86TargetInfo10hasFeatureEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo10hasFeatureEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean hasFeature(StringRef Feature) /*const*//* override*/ {
    return new StringSwitchBool(/*NO_COPY*/Feature).
        Case(/*KEEP_STR*/"aes", HasAES).
        Case(/*KEEP_STR*/"avx", SSELevel.getValue() >= X86SSEEnum.AVX.getValue()).
        Case(/*KEEP_STR*/"avx2", SSELevel.getValue() >= X86SSEEnum.AVX2.getValue()).
        Case(/*KEEP_STR*/"avx512f", SSELevel.getValue() >= X86SSEEnum.AVX512F.getValue()).
        Case(/*KEEP_STR*/"avx512cd", HasAVX512CD).
        Case(/*KEEP_STR*/"avx512er", HasAVX512ER).
        Case(/*KEEP_STR*/"avx512pf", HasAVX512PF).
        Case(/*KEEP_STR*/"avx512dq", HasAVX512DQ).
        Case(/*KEEP_STR*/"avx512bw", HasAVX512BW).
        Case(/*KEEP_STR*/"avx512vl", HasAVX512VL).
        Case(/*KEEP_STR*/"avx512vbmi", HasAVX512VBMI).
        Case(/*KEEP_STR*/"avx512ifma", HasAVX512IFMA).
        Case(/*KEEP_STR*/"bmi", HasBMI).
        Case(/*KEEP_STR*/"bmi2", HasBMI2).
        Case(/*KEEP_STR*/"clflushopt", HasCLFLUSHOPT).
        Case(/*KEEP_STR*/"clwb", HasCLWB).
        Case(/*KEEP_STR*/"cx16", HasCX16).
        Case(/*KEEP_STR*/"f16c", HasF16C).
        Case(/*KEEP_STR*/"fma", HasFMA).
        Case(/*KEEP_STR*/"fma4", XOPLevel.getValue() >= XOPEnum.FMA4.getValue()).
        Case(/*KEEP_STR*/"fsgsbase", HasFSGSBASE).
        Case(/*KEEP_STR*/"fxsr", HasFXSR).
        Case(/*KEEP_STR*/"lzcnt", HasLZCNT).
        Case(/*KEEP_STR*/"mm3dnow", MMX3DNowLevel.getValue() >= MMX3DNowEnum.AMD3DNow.getValue()).
        Case(/*KEEP_STR*/"mm3dnowa", MMX3DNowLevel.getValue() >= MMX3DNowEnum.AMD3DNowAthlon.getValue()).
        Case(/*KEEP_STR*/"mmx", MMX3DNowLevel.getValue() >= MMX3DNowEnum.MMX.getValue()).
        Case(/*KEEP_STR*/"movbe", HasMOVBE).
        Case(/*KEEP_STR*/"mpx", HasMPX).
        Case(/*KEEP_STR*/"pclmul", HasPCLMUL).
        Case(/*KEEP_STR*/"pcommit", HasPCOMMIT).
        Case(/*KEEP_STR*/"pku", HasPKU).
        Case(/*KEEP_STR*/"popcnt", HasPOPCNT).
        Case(/*KEEP_STR*/"prefetchwt1", HasPREFETCHWT1).
        Case(/*KEEP_STR*/"prfchw", HasPRFCHW).
        Case(/*KEEP_STR*/"rdrnd", HasRDRND).
        Case(/*KEEP_STR*/"rdseed", HasRDSEED).
        Case(/*KEEP_STR*/"rtm", HasRTM).
        Case(/*KEEP_STR*/"sgx", HasSGX).
        Case(/*KEEP_STR*/"sha", HasSHA).
        Case(/*KEEP_STR*/"sse", SSELevel.getValue() >= X86SSEEnum.SSE1.getValue()).
        Case(/*KEEP_STR*/"sse2", SSELevel.getValue() >= X86SSEEnum.SSE2.getValue()).
        Case(/*KEEP_STR*/"sse3", SSELevel.getValue() >= X86SSEEnum.SSE3.getValue()).
        Case(/*KEEP_STR*/"ssse3", SSELevel.getValue() >= X86SSEEnum.SSSE3.getValue()).
        Case(/*KEEP_STR*/"sse4.1", SSELevel.getValue() >= X86SSEEnum.SSE41.getValue()).
        Case(/*KEEP_STR*/"sse4.2", SSELevel.getValue() >= X86SSEEnum.SSE42.getValue()).
        Case(/*KEEP_STR*/"sse4a", XOPLevel.getValue() >= XOPEnum.SSE4A.getValue()).
        Case(/*KEEP_STR*/"tbm", HasTBM).
        Case(/*KEEP_STR*/"umip", HasUMIP).
        Case(/*KEEP_STR*/"x86", true).
        Case(/*KEEP_STR*/"x86_32", getTriple().getArch() == Triple.ArchType.x86).
        Case(/*KEEP_STR*/"x86_64", getTriple().getArch() == Triple.ArchType.x86_64).
        Case(/*KEEP_STR*/"xop", XOPLevel.getValue() >= XOPEnum.XOP.getValue()).
        Case(/*KEEP_STR*/"xsave", HasXSAVE).
        Case(/*KEEP_STR*/"xsavec", HasXSAVEC).
        Case(/*KEEP_STR*/"xsaves", HasXSAVES).
        Case(/*KEEP_STR*/"xsaveopt", HasXSAVEOPT).
        Default(false);
  }

  
  /// handleTargetFeatures - Perform initialization based on the user
  /// configured set of features.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::handleTargetFeatures">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 3269,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2981,
   FQN="(anonymous namespace)::X86TargetInfo::handleTargetFeatures", NM="_ZN12_GLOBAL__N_113X86TargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo20handleTargetFeaturesERSt6vectorISsSaISsEERN5clang17DiagnosticsEngineE")
  //</editor-fold>
  @Override public boolean handleTargetFeatures(std.vectorString/*&*/ Features, 
                      DiagnosticsEngine /*&*/ Diags)/* override*/ {
    for (/*const*/std.string/*&*/ Feature : Features) {
      if (Feature.$at(0) != $$PLUS) {
        continue;
      }
      if ($eq_string$C_T(Feature, /*KEEP_STR*/"+aes")) {
        HasAES = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+pclmul")) {
        HasPCLMUL = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+lzcnt")) {
        HasLZCNT = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+rdrnd")) {
        HasRDRND = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fsgsbase")) {
        HasFSGSBASE = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+bmi")) {
        HasBMI = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+bmi2")) {
        HasBMI2 = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+popcnt")) {
        HasPOPCNT = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+rtm")) {
        HasRTM = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+prfchw")) {
        HasPRFCHW = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+rdseed")) {
        HasRDSEED = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+adx")) {
        HasADX = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+tbm")) {
        HasTBM = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fma")) {
        HasFMA = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+f16c")) {
        HasF16C = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512cd")) {
        HasAVX512CD = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512er")) {
        HasAVX512ER = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512pf")) {
        HasAVX512PF = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512dq")) {
        HasAVX512DQ = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512bw")) {
        HasAVX512BW = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512vl")) {
        HasAVX512VL = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512vbmi")) {
        HasAVX512VBMI = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+avx512ifma")) {
        HasAVX512IFMA = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+sha")) {
        HasSHA = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+mpx")) {
        HasMPX = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+movbe")) {
        HasMOVBE = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+sgx")) {
        HasSGX = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+cx16")) {
        HasCX16 = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+fxsr")) {
        HasFXSR = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+xsave")) {
        HasXSAVE = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+xsaveopt")) {
        HasXSAVEOPT = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+xsavec")) {
        HasXSAVEC = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+xsaves")) {
        HasXSAVES = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+mwaitx")) {
        HasMWAITX = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+pku")) {
        HasPKU = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+clflushopt")) {
        HasCLFLUSHOPT = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+pcommit")) {
        HasPCOMMIT = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+clwb")) {
        HasCLWB = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+umip")) {
        HasUMIP = true;
      } else if ($eq_string$C_T(Feature, /*KEEP_STR*/"+prefetchwt1")) {
        HasPREFETCHWT1 = true;
      }
      
      X86SSEEnum Level = new StringSwitch<X86SSEEnum>(new StringRef(Feature)).
          Case(/*KEEP_STR*/"+avx512f", X86SSEEnum.AVX512F).
          Case(/*KEEP_STR*/"+avx2", X86SSEEnum.AVX2).
          Case(/*KEEP_STR*/"+avx", X86SSEEnum.AVX).
          Case(/*KEEP_STR*/"+sse4.2", X86SSEEnum.SSE42).
          Case(/*KEEP_STR*/"+sse4.1", X86SSEEnum.SSE41).
          Case(/*KEEP_STR*/"+ssse3", X86SSEEnum.SSSE3).
          Case(/*KEEP_STR*/"+sse3", X86SSEEnum.SSE3).
          Case(/*KEEP_STR*/"+sse2", X86SSEEnum.SSE2).
          Case(/*KEEP_STR*/"+sse", X86SSEEnum.SSE1).
          Default(X86SSEEnum.NoSSE);
      SSELevel = std.max(SSELevel, Level);
      
      MMX3DNowEnum ThreeDNowLevel = new StringSwitch<MMX3DNowEnum>(new StringRef(Feature)).
          Case(/*KEEP_STR*/"+3dnowa", MMX3DNowEnum.AMD3DNowAthlon).
          Case(/*KEEP_STR*/"+3dnow", MMX3DNowEnum.AMD3DNow).
          Case(/*KEEP_STR*/"+mmx", MMX3DNowEnum.MMX).
          Default(MMX3DNowEnum.NoMMX3DNow);
      MMX3DNowLevel = std.max(MMX3DNowLevel, ThreeDNowLevel);
      
      XOPEnum XLevel = new StringSwitch<XOPEnum>(new StringRef(Feature)).
          Case(/*KEEP_STR*/"+xop", XOPEnum.XOP).
          Case(/*KEEP_STR*/"+fma4", XOPEnum.FMA4).
          Case(/*KEEP_STR*/"+sse4a", XOPEnum.SSE4A).
          Default(XOPEnum.NoXOP);
      XOPLevel = std.max(XOPLevel, XLevel);
    }
    
    // LLVM doesn't have a separate switch for fpmath, so only accept it if it
    // matches the selected sse level.
    if ((FPMath == FPMathKind.FP_SSE && SSELevel.getValue() < X86SSEEnum.SSE1.getValue())
       || (FPMath == FPMathKind.FP_387 && SSELevel.getValue() >= X86SSEEnum.SSE1.getValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(Diags.Report(diag.err_target_unsupported_fpmath)), 
            (FPMath == FPMathKind.FP_SSE ? $("sse") : $("387"))));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    SimdDefaultAlign
       = $int2ushort(hasFeature(new StringRef(/*KEEP_STR*/"avx512f")) ? 512 : hasFeature(new StringRef(/*KEEP_STR*/"avx")) ? 256 : 128);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getABI">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2687,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2433,
   FQN="(anonymous namespace)::X86TargetInfo::getABI", NM="_ZNK12_GLOBAL__N_113X86TargetInfo6getABIEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo6getABIEv")
  //</editor-fold>
  @Override public StringRef getABI() /*const*//* override*/ {
    if (getTriple().getArch() == Triple.ArchType.x86_64 && SSELevel.getValue() >= X86SSEEnum.AVX512F.getValue()) {
      return new StringRef(/*KEEP_STR*/"avx512");
    }
    if (getTriple().getArch() == Triple.ArchType.x86_64 && SSELevel.getValue() >= X86SSEEnum.AVX.getValue()) {
      return new StringRef(/*KEEP_STR*/"avx");
    }
    if (getTriple().getArch() == Triple.ArchType.x86
       && MMX3DNowLevel == MMX3DNowEnum.NoMMX3DNow) {
      return new StringRef(/*KEEP_STR*/"no-mmx");
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2697,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2443,
   FQN="(anonymous namespace)::X86TargetInfo::setCPU", NM="_ZN12_GLOBAL__N_113X86TargetInfo6setCPUERKSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo6setCPUERKSs")
  //</editor-fold>
  @Override public boolean setCPU(/*const*/std.string/*&*/ Name)/* override*/ {
    CPU = getCPUKind(new StringRef(Name));
    
    // Perform any per-CPU checks necessary to determine if this CPU is
    // acceptable.
    // FIXME: This results in terrible diagnostics. Clang just says the CPU is
    // invalid without explaining *why*.
    switch (CPU) {
     case CK_Generic:
      // No processor selected!
      return false;
     case CK_i386:
     case CK_i486:
     case CK_WinChipC6:
     case CK_WinChip2:
     case CK_C3:
     case CK_i586:
     case CK_Pentium:
     case CK_PentiumMMX:
     case CK_i686:
     case CK_PentiumPro:
     case CK_Pentium2:
     case CK_Pentium3:
     case CK_Pentium3M:
     case CK_PentiumM:
     case CK_Yonah:
     case CK_C3_2:
     case CK_Pentium4:
     case CK_Pentium4M:
     case CK_Lakemont:
     case CK_Prescott:
     case CK_K6:
     case CK_K6_2:
     case CK_K6_3:
     case CK_Athlon:
     case CK_AthlonThunderbird:
     case CK_Athlon4:
     case CK_AthlonXP:
     case CK_AthlonMP:
     case CK_Geode:
      // Only accept certain architectures when compiling in 32-bit mode.
      if (getTriple().getArch() != Triple.ArchType.x86) {
        return false;
      }
     case CK_Nocona:
     case CK_Core2:
     case CK_Penryn:
     case CK_Bonnell:
     case CK_Silvermont:
     case CK_Nehalem:
     case CK_Westmere:
     case CK_SandyBridge:
     case CK_IvyBridge:
     case CK_Haswell:
     case CK_Broadwell:
     case CK_SkylakeClient:
     case CK_SkylakeServer:
     case CK_Cannonlake:
     case CK_KNL:
     case CK_Athlon64:
     case CK_Athlon64SSE3:
     case CK_AthlonFX:
     case CK_K8:
     case CK_K8SSE3:
     case CK_Opteron:
     case CK_OpteronSSE3:
     case CK_AMDFAM10:
     case CK_BTVER1:
     case CK_BTVER2:
     case CK_BDVER1:
     case CK_BDVER2:
     case CK_BDVER3:
     case CK_BDVER4:
     case CK_x86_64:
      
      // Fallthrough
      return true;
    }
    throw new llvm_unreachable("Unhandled CPU kind");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setFPMath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2810,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2543,
   FQN="(anonymous namespace)::X86TargetInfo::setFPMath", NM="_ZN12_GLOBAL__N_113X86TargetInfo9setFPMathEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo9setFPMathEN4llvm9StringRefE")
  //</editor-fold>
  @Override public boolean setFPMath(StringRef Name)/* override*/ {
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"387")) {
      FPMath = FPMathKind.FP_387;
      return true;
    }
    if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"sse")) {
      FPMath = FPMathKind.FP_SSE;
      return true;
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::checkCallingConvention">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2523,
   FQN="(anonymous namespace)::X86TargetInfo::checkCallingConvention", NM="_ZNK12_GLOBAL__N_113X86TargetInfo22checkCallingConventionEN5clang11CallingConvE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo22checkCallingConventionEN5clang11CallingConvE")
  //</editor-fold>
  @Override public CallingConvCheckResult checkCallingConvention(CallingConv CC) /*const*//* override*/ {
    // Most of the non-ARM calling conventions are i386 conventions.
    switch (CC) {
     case CC_X86ThisCall:
     case CC_X86FastCall:
     case CC_X86StdCall:
     case CC_X86VectorCall:
     case CC_C:
     case CC_Swift:
     case CC_X86Pascal:
     case CC_IntelOclBicc:
      return CallingConvCheckResult.CCCR_OK;
     default:
      return CallingConvCheckResult.CCCR_Warning;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::getDefaultCallingConv">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2797,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2534,
   FQN="(anonymous namespace)::X86TargetInfo::getDefaultCallingConv", NM="_ZNK12_GLOBAL__N_113X86TargetInfo21getDefaultCallingConvEN5clang10TargetInfo21CallingConvMethodTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo21getDefaultCallingConvEN5clang10TargetInfo21CallingConvMethodTypeE")
  //</editor-fold>
  @Override public CallingConv getDefaultCallingConv(CallingConvMethodType MT) /*const*//* override*/ {
    return MT == CallingConvMethodType.CCMT_Member ? CallingConv.CC_X86ThisCall : CallingConv.CC_C;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::hasSjLjLowering">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2801,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2538,
   FQN="(anonymous namespace)::X86TargetInfo::hasSjLjLowering", NM="_ZNK12_GLOBAL__N_113X86TargetInfo15hasSjLjLoweringEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_113X86TargetInfo15hasSjLjLoweringEv")
  //</editor-fold>
  @Override public boolean hasSjLjLowering() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::setSupportedOpenCLOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2805,
   FQN="(anonymous namespace)::X86TargetInfo::setSupportedOpenCLOpts", NM="_ZN12_GLOBAL__N_113X86TargetInfo22setSupportedOpenCLOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfo22setSupportedOpenCLOptsEv")
  //</editor-fold>
  @Override public void setSupportedOpenCLOpts()/* override*/ {
    getSupportedOpenCLOpts().setAll();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::X86TargetInfo::~X86TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 2300,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 2073,
   FQN="(anonymous namespace)::X86TargetInfo::~X86TargetInfo", NM="_ZN12_GLOBAL__N_113X86TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_113X86TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + "SSELevel=" + SSELevel // NOI18N
              + ", MMX3DNowLevel=" + MMX3DNowLevel // NOI18N
              + ", XOPLevel=" + XOPLevel // NOI18N
              + ", HasAES=" + HasAES // NOI18N
              + ", HasPCLMUL=" + HasPCLMUL // NOI18N
              + ", HasLZCNT=" + HasLZCNT // NOI18N
              + ", HasRDRND=" + HasRDRND // NOI18N
              + ", HasFSGSBASE=" + HasFSGSBASE // NOI18N
              + ", HasBMI=" + HasBMI // NOI18N
              + ", HasBMI2=" + HasBMI2 // NOI18N
              + ", HasPOPCNT=" + HasPOPCNT // NOI18N
              + ", HasRTM=" + HasRTM // NOI18N
              + ", HasPRFCHW=" + HasPRFCHW // NOI18N
              + ", HasRDSEED=" + HasRDSEED // NOI18N
              + ", HasADX=" + HasADX // NOI18N
              + ", HasTBM=" + HasTBM // NOI18N
              + ", HasFMA=" + HasFMA // NOI18N
              + ", HasF16C=" + HasF16C // NOI18N
              + ", HasAVX512CD=" + HasAVX512CD // NOI18N
              + ", HasAVX512ER=" + HasAVX512ER // NOI18N
              + ", HasAVX512PF=" + HasAVX512PF // NOI18N
              + ", HasAVX512DQ=" + HasAVX512DQ // NOI18N
              + ", HasAVX512BW=" + HasAVX512BW // NOI18N
              + ", HasAVX512VL=" + HasAVX512VL // NOI18N
              + ", HasAVX512VBMI=" + HasAVX512VBMI // NOI18N
              + ", HasAVX512IFMA=" + HasAVX512IFMA // NOI18N
              + ", HasSHA=" + HasSHA // NOI18N
              + ", HasMPX=" + HasMPX // NOI18N
              + ", HasSGX=" + HasSGX // NOI18N
              + ", HasCX16=" + HasCX16 // NOI18N
              + ", HasFXSR=" + HasFXSR // NOI18N
              + ", HasXSAVE=" + HasXSAVE // NOI18N
              + ", HasXSAVEOPT=" + HasXSAVEOPT // NOI18N
              + ", HasXSAVEC=" + HasXSAVEC // NOI18N
              + ", HasXSAVES=" + HasXSAVES // NOI18N
              + ", HasMWAITX=" + HasMWAITX // NOI18N
              + ", HasPKU=" + HasPKU // NOI18N
              + ", HasCLFLUSHOPT=" + HasCLFLUSHOPT // NOI18N
              + ", HasPCOMMIT=" + HasPCOMMIT // NOI18N
              + ", HasCLWB=" + HasCLWB // NOI18N
              + ", HasUMIP=" + HasUMIP // NOI18N
              + ", HasMOVBE=" + HasMOVBE // NOI18N
              + ", HasPREFETCHWT1=" + HasPREFETCHWT1 // NOI18N
              + ", CPU=" + CPU // NOI18N
              + ", FPMath=" + FPMath // NOI18N
              + super.toString(); // NOI18N
  }
}
