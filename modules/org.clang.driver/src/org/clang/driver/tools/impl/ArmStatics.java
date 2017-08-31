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
package org.clang.driver.tools.impl;

import org.llvm.support.target.ARM;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ArmStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm10getARMArchEN4llvm9StringRefERKNS3_6TripleE;_ZN5clang6driver5tools3arm14getARMFloatABIERKNS0_9ToolChainERKN4llvm3opt7ArgListE;_ZN5clang6driver5tools3arm15getARMTargetCPUEN4llvm9StringRefES4_RKNS3_6TripleE;_ZN5clang6driver5tools3arm17appendEBLinkFlagsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKNS3_6TripleE;_ZN5clang6driver5tools3arm17getARMCPUForMArchEN4llvm9StringRefERKNS3_6TripleE;_ZN5clang6driver5tools3arm23getLLVMArchSuffixForARMEN4llvm9StringRefES4_RKNS3_6TripleE;_ZN5clang6driver5tools3arm8FloatABIE; -static-type=ArmStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class ArmStatics {


/// getARMTargetCPU - Get the (LLVM) name of the ARM cpu we are targeting.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::getARMTargetCPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7209,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6606,
 FQN="clang::driver::tools::arm::getARMTargetCPU", NM="_ZN5clang6driver5tools3arm15getARMTargetCPUEN4llvm9StringRefES4_RKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm15getARMTargetCPUEN4llvm9StringRefES4_RKNS3_6TripleE")
//</editor-fold>
public static std.string getARMTargetCPU(StringRef CPU, StringRef Arch, 
               /*const*/ Triple /*&*/ Triple) {
  // FIXME: Warn on inconsistent use of -mcpu and -march.
  // If we have -mcpu=, use that.
  if (!CPU.empty()) {
    std.string MCPU = new StringRef(CPU).split(/*STRINGREF_STR*/"+").first.lower();
    // Handle -mcpu=native.
    if ($eq_string$C_T(MCPU, /*KEEP_STR*/"native")) {
      return sys.getHostCPUName().$string();
    } else {
      return MCPU;
    }
  }
  
  return getARMCPUForMArch(new StringRef(Arch), Triple).$string();
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::getARMArch">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7169,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6566,
 FQN="clang::driver::tools::arm::getARMArch", NM="_ZN5clang6driver5tools3arm10getARMArchEN4llvm9StringRefERKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm10getARMArchEN4llvm9StringRefERKNS3_6TripleE")
//</editor-fold>
public static /*const*/std.string getARMArch(StringRef Arch, /*const*/ Triple /*&*/ Triple) {
  std.string MArch/*J*/= new std.string();
  if (!Arch.empty()) {
    MArch.$assignMove(Arch.$string());
  } else {
    MArch.$assignMove(Triple.getArchName().$string());
  }
  MArch.$assignMove(new StringRef(MArch).split(/*STRINGREF_STR*/"+").first.lower());
  
  // Handle -march=native.
  if ($eq_string$C_T(MArch, /*KEEP_STR*/"native")) {
    std.string CPU = sys.getHostCPUName().$string();
    if ($noteq_string$C_T(CPU, /*KEEP_STR*/"generic")) {
      // Translate the native cpu into the architecture suffix for that CPU.
      StringRef Suffix = ArmStatics.getLLVMArchSuffixForARM(new StringRef(CPU), new StringRef(MArch), Triple);
      // If there is no valid architecture suffix for this CPU we don't know how
      // to handle it, so return no architecture.
      if (Suffix.empty()) {
        MArch.$assign(/*KEEP_STR*/"");
      } else {
        MArch.$assignMove($add_string(new std.string(/*KEEP_STR*/"arm"), Suffix.str()));
      }
    }
  }
  
  return MArch;
}


/// Get the (LLVM) name of the minimum ARM CPU for the arch we are targeting.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::getARMCPUForMArch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7196,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6593,
 FQN="clang::driver::tools::arm::getARMCPUForMArch", NM="_ZN5clang6driver5tools3arm17getARMCPUForMArchEN4llvm9StringRefERKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm17getARMCPUForMArchEN4llvm9StringRefERKNS3_6TripleE")
//</editor-fold>
public static StringRef getARMCPUForMArch(StringRef Arch, /*const*/ Triple /*&*/ Triple) {
  std.string MArch = getARMArch(new StringRef(Arch), Triple);
  // getARMCPUForArch defaults to the triple if MArch is empty, but empty MArch
  // here means an -march=native that we can't handle, so instead return no CPU.
  if (MArch.empty()) {
    return new StringRef();
  }
  
  // We need to return an empty string here on invalid MArch values as the
  // various places that call this function can't cope with a null result.
  return Triple.getARMCPUForArch(new StringRef(MArch));
}


/// getLLVMArchSuffixForARM - Get the LLVM arch name to use for a particular
/// CPU  (or Arch, if CPU is generic).
// FIXME: This is redundant with -mcpu, why does LLVM use this.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::getLLVMArchSuffixForARM">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7228,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6625,
 FQN="clang::driver::tools::arm::getLLVMArchSuffixForARM", NM="_ZN5clang6driver5tools3arm23getLLVMArchSuffixForARMEN4llvm9StringRefES4_RKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm23getLLVMArchSuffixForARMEN4llvm9StringRefES4_RKNS3_6TripleE")
//</editor-fold>
public static StringRef getLLVMArchSuffixForARM(StringRef CPU, StringRef Arch, 
                       /*const*/ Triple /*&*/ Triple) {
  /*uint*/int ArchKind;
  if ($eq_StringRef(/*NO_COPY*/CPU, /*STRINGREF_STR*/"generic")) {
    std.string ARMArch = ArmStatics.getARMArch(new StringRef(Arch), Triple);
    ArchKind = ARM.parseArch(new StringRef(ARMArch));
    if (ArchKind == ARM.ArchKind.AK_INVALID.getValue()) {
      // In case of generic Arch, i.e. "arm",
      // extract arch from default cpu of the Triple
      ArchKind = ARM.parseCPUArch(Triple.getARMCPUForArch(new StringRef(ARMArch)));
    }
  } else {
    // FIXME: horrible hack to get around the fact that Cortex-A7 is only an
    // armv7k triple if it's actually been specified via "-arch armv7k".
    ArchKind = ($eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"armv7k") || $eq_StringRef(/*NO_COPY*/Arch, /*STRINGREF_STR*/"thumbv7k")) ? (/*uint*/int)ARM.ArchKind.AK_ARMV7K.getValue() : ARM.parseCPUArch(/*NO_COPY*/CPU);
  }
  if (ArchKind == ARM.ArchKind.AK_INVALID.getValue()) {
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }
  return ARM.getSubArch(ArchKind);
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::appendEBLinkFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7250,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6647,
 FQN="clang::driver::tools::arm::appendEBLinkFlags", NM="_ZN5clang6driver5tools3arm17appendEBLinkFlagsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm17appendEBLinkFlagsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKNS3_6TripleE")
//</editor-fold>
public static void appendEBLinkFlags(/*const*/ ArgList /*&*/ Args, ArgStringList/*&*/ CmdArgs, 
                 /*const*/ Triple /*&*/ Triple) {
  if (Args.hasArg(new OptSpecifier(options.ID.OPT_r.getValue()))) {
    return;
  }
  
  // ARMv7 (and later) and ARMv6-M do not support BE-32, so instruct the linker
  // to generate BE-8 executables.
  if (getARMSubArchVersionNumber(Triple) >= 7 || isARMMProfile(Triple)) {
    CmdArgs.push_back($("--be8"));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::FloatABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 760,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 756,
 FQN="clang::driver::tools::arm::FloatABI", NM="_ZN5clang6driver5tools3arm8FloatABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm8FloatABIE")
//</editor-fold>
public enum /*class */FloatABI/* : int*/ implements Native.ComparableLower {
  Invalid(0),
  Soft(Invalid.getValue() + 1),
  SoftFP(Soft.getValue() + 1),
  Hard(SoftFP.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static FloatABI valueOf(int val) {
    FloatABI out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final FloatABI[] VALUES;
    private static final FloatABI[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (FloatABI kind : FloatABI.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new FloatABI[min < 0 ? (1-min) : 0];
      VALUES = new FloatABI[max >= 0 ? (1+max) : 0];
      for (FloatABI kind : FloatABI.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final int value;
  private FloatABI(int val) { this.value = (int)val;}
  public int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_int(value, ((FloatABI)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_int(value, ((FloatABI)obj).value);}
  //</editor-fold>
}

// Select the float ABI as determined by -msoft-float, -mhard-float, and
// -mfloat-abi=.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::arm::getARMFloatABI">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 774,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 659,
 FQN="clang::driver::tools::arm::getARMFloatABI", NM="_ZN5clang6driver5tools3arm14getARMFloatABIERKNS0_9ToolChainERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3arm14getARMFloatABIERKNS0_9ToolChainERKN4llvm3opt7ArgListE")
//</editor-fold>
public static ArmStatics.FloatABI getARMFloatABI(/*const*/ ToolChain /*&*/ TC, /*const*/ ArgList /*&*/ Args) {
  /*const*/ Driver /*&*/ D = TC.getDriver();
  /*const*/ Triple _Triple/*J*/= new Triple(new Twine(TC.ComputeEffectiveClangTriple(Args)));
  int SubArch = getARMSubArchVersionNumber(_Triple);
  ArmStatics.FloatABI ABI = FloatABI.Invalid;
  {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_msoft_float.getValue()), new OptSpecifier(options.ID.OPT_mhard_float.getValue()), 
        new OptSpecifier(options.ID.OPT_mfloat_abi_EQ.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_msoft_float.getValue()))) {
        ABI = FloatABI.Soft;
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_mhard_float.getValue()))) {
        ABI = FloatABI.Hard;
      } else {
        ABI = new StringSwitch<ArmStatics.FloatABI>(/*STRINGREF_STR*/A.getValue()).
            Case(/*KEEP_STR*/"soft", FloatABI.Soft).
            Case(/*KEEP_STR*/"softfp", FloatABI.SoftFP).
            Case(/*KEEP_STR*/"hard", FloatABI.Hard).
            Default(FloatABI.Invalid);
        if (ABI == FloatABI.Invalid && !new StringRef(A.getValue()).empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_mfloat_abi)), new StringRef(A.getAsString(Args))));
            ABI = FloatABI.Soft;
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // It is incorrect to select hard float ABI on MachO platforms if the ABI is
      // "apcs-gnu".
      if (_Triple.isOSBinFormatMachO() && !useAAPCSForMachO(_Triple)
         && ABI == FloatABI.Hard) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_opt_for_target)), new StringRef(A.getAsString(Args))), 
              _Triple.getArchName()));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // If unspecified, choose the default based on the platform.
  if (ABI == FloatABI.Invalid) {
    switch (_Triple.getOS()) {
     case Darwin:
     case MacOSX:
     case IOS:
     case TvOS:
      {
        // Darwin defaults to "softfp" for v6 and v7.
        ABI = (SubArch == 6 || SubArch == 7) ? FloatABI.SoftFP : FloatABI.Soft;
        ABI = _Triple.isWatchABI() ? FloatABI.Hard : ABI;
        break;
      }
     case WatchOS:
      ABI = FloatABI.Hard;
      break;
     case Win32:
      
      // FIXME: this is invalid for WindowsCE
      ABI = FloatABI.Hard;
      break;
     case FreeBSD:
      switch (_Triple.getEnvironment()) {
       case GNUEABIHF:
        ABI = FloatABI.Hard;
        break;
       default:
        // FreeBSD defaults to soft float
        ABI = FloatABI.Soft;
        break;
      }
      break;
     default:
      switch (_Triple.getEnvironment()) {
       case GNUEABIHF:
       case MuslEABIHF:
       case EABIHF:
        ABI = FloatABI.Hard;
        break;
       case GNUEABI:
       case MuslEABI:
       case EABI:
        // EABI is always AAPCS, and if it was not marked 'hard', it's softfp
        ABI = FloatABI.SoftFP;
        break;
       case Android:
        ABI = (SubArch == 7) ? FloatABI.SoftFP : FloatABI.Soft;
        break;
       default:
        // Assume "soft", but warn the user we are guessing.
        if (_Triple.isOSBinFormatMachO()
           && _Triple.getSubArch() == Triple.SubArchType.ARMSubArch_v7em) {
          ABI = FloatABI.Hard;
        } else {
          ABI = FloatABI.Soft;
        }
        if (_Triple.getOS() != Triple.OSType.UnknownOS
           || !_Triple.isOSBinFormatMachO()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.warn_drv_assuming_mfloat_abi_is)), /*KEEP_STR*/"soft"));
          } finally {
            $c$.$destroy();
          }
        }
        break;
      }
    }
  }
  assert (ABI != FloatABI.Invalid) : "must select an ABI";
  return ABI;
}

} // END OF class ArmStatics
