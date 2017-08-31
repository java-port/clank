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

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;
import static org.clang.driver.impl.ToolsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type MipsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_NanEncoding;_ZN5clang6driver5tools4mips13hasMipsAbiArgERKN4llvm3opt7ArgListEPKc;_ZN5clang6driver5tools4mips13isFPXXDefaultERKN4llvm6TripleENS3_9StringRefES7_NS2_8FloatABIE;_ZN5clang6driver5tools4mips13shouldUseFPXXERKN4llvm3opt7ArgListERKNS3_6TripleENS3_9StringRefESB_NS2_8FloatABIE;_ZN5clang6driver5tools4mips14isFP64ADefaultERKN4llvm6TripleENS3_9StringRefE;_ZN5clang6driver5tools4mips16getMipsCPUAndABIERKN4llvm3opt7ArgListERKNS3_6TripleERNS3_9StringRefESC_;_ZN5clang6driver5tools4mips18hasCompactBranchesERN4llvm9StringRefE;_ZN5clang6driver5tools4mips19getMipsABILibSuffixERKN4llvm3opt7ArgListERKNS3_6TripleE;_ZN5clang6driver5tools4mips23getSupportedNanEncodingERN4llvm9StringRefE;_ZN5clang6driver5tools4mips8FloatABIE;_ZN5clang6driver5tools4mips8isUCLibcERKN4llvm3opt7ArgListE;_ZN5clang6driver5tools4mips9isNaN2008ERKN4llvm3opt7ArgListERKNS3_6TripleE; -static-type=MipsStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class MipsStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 284,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 283,
 FQN="clang::driver::tools::mips::(anonymous)", NM="_NanEncoding",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_NanEncoding")
//</editor-fold>
public final class/*enum*/ NanEncoding {
  public static final int NanLegacy = 1;
  public static final int Nan2008 = 2;
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::FloatABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 286,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 285,
 FQN="clang::driver::tools::mips::FloatABI", NM="_ZN5clang6driver5tools4mips8FloatABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips8FloatABIE")
//</editor-fold>
public enum /*class */FloatABI/* : int*/ implements Native.ComparableLower {
  Invalid(0),
  Soft(Invalid.getValue() + 1),
  Hard(Soft.getValue() + 1);

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

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::getSupportedNanEncoding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7261,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6658,
 FQN="clang::driver::tools::mips::getSupportedNanEncoding", NM="_ZN5clang6driver5tools4mips23getSupportedNanEncodingERN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips23getSupportedNanEncodingERN4llvm9StringRefE")
//</editor-fold>
public static /*NanEncoding*/int getSupportedNanEncoding(final StringRef /*&*/ CPU) {
  // Strictly speaking, mips32r2 and mips64r2 are NanLegacy-only since Nan2008
  // was first introduced in Release 3. However, other compilers have
  // traditionally allowed it for Release 2 so we should do the same.
  return (/*NanEncoding*/int)new StringSwitchInt(/*NO_COPY*/CPU).
      Case(/*KEEP_STR*/"mips1", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips2", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips3", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips4", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips5", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips32", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips32r2", NanEncoding.NanLegacy | NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips32r3", NanEncoding.NanLegacy | NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips32r5", NanEncoding.NanLegacy | NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips32r6", NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips64", NanEncoding.NanLegacy).
      Case(/*KEEP_STR*/"mips64r2", NanEncoding.NanLegacy | NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips64r3", NanEncoding.NanLegacy | NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips64r5", NanEncoding.NanLegacy | NanEncoding.Nan2008).
      Case(/*KEEP_STR*/"mips64r6", NanEncoding.Nan2008).
      Default(NanEncoding.NanLegacy);
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::hasCompactBranches">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7284,
 FQN="clang::driver::tools::mips::hasCompactBranches", NM="_ZN5clang6driver5tools4mips18hasCompactBranchesERN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips18hasCompactBranchesERN4llvm9StringRefE")
//</editor-fold>
public static boolean hasCompactBranches(StringRef /*&*/ CPU) {
  // mips32r6 and mips64r6 have compact branches.
  return new StringSwitchBool(/*NO_COPY*/CPU).
      Case(/*KEEP_STR*/"mips32r6", true).
      Case(/*KEEP_STR*/"mips64r6", true).
      Default(false);
}


// Get CPU and ABI names. They are not independent
// so we have to calculate them together.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::getMipsCPUAndABI">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1226,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1101,
 FQN="clang::driver::tools::mips::getMipsCPUAndABI", NM="_ZN5clang6driver5tools4mips16getMipsCPUAndABIERKN4llvm3opt7ArgListERKNS3_6TripleERNS3_9StringRefESC_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips16getMipsCPUAndABIERKN4llvm3opt7ArgListERKNS3_6TripleERNS3_9StringRefESC_")
//</editor-fold>
public static void getMipsCPUAndABI(/*const*/ ArgList /*&*/ Args, /*const*/ Triple /*&*/ _Triple, 
                StringRef /*&*/ CPUName, StringRef /*&*/ ABIName) {
  /*const*/char$ptr/*char P*/ DefMips32CPU = $("mips32r2");
  /*const*/char$ptr/*char P*/ DefMips64CPU = $("mips64r2");
  
  // MIPS32r6 is the default for mips(el)?-img-linux-gnu and MIPS64r6 is the
  // default for mips64(el)?-img-linux-gnu.
  if (_Triple.getVendor() == Triple.VendorType.ImaginationTechnologies
     && _Triple.getEnvironment() == Triple.EnvironmentType.GNU) {
    DefMips32CPU = $tryClone($("mips32r6"));
    DefMips64CPU = $tryClone($("mips64r6"));
  }
  
  // MIPS64r6 is the default for Android MIPS64 (mips64el-linux-android).
  if (_Triple.isAndroid()) {
    DefMips32CPU = $tryClone($("mips32"));
    DefMips64CPU = $tryClone($("mips64r6"));
  }
  
  // MIPS3 is the default for mips64*-unknown-openbsd.
  if (_Triple.getOS() == Triple.OSType.OpenBSD) {
    DefMips64CPU = $tryClone($("mips3"));
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()), new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
    if ((A != null)) {
      CPUName.$assignMove(/*STRINGREF_STR*/A.getValue());
    }
  }
  {
    
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mabi_EQ.getValue()));
    if ((A != null)) {
      ABIName.$assignMove(/*STRINGREF_STR*/A.getValue());
      // Convert a GNU style Mips ABI name to the name
      // accepted by LLVM Mips backend.
      ABIName.$assignMove(new StringSwitchStringRef(/*NO_COPY*/ABIName).
              Case(/*KEEP_STR*/"32", /*STRINGREF_STR*/"o32").
              Case(/*KEEP_STR*/"64", /*STRINGREF_STR*/"n64").
              Default(ABIName));
    }
  }
  
  // Setup default CPU and ABI names.
  if (CPUName.empty() && ABIName.empty()) {
    switch (_Triple.getArch()) {
     default:
      throw new llvm_unreachable("Unexpected triple arch name");
     case mips:
     case mipsel:
      CPUName.$assignMove(/*STRINGREF_STR*/DefMips32CPU);
      break;
     case mips64:
     case mips64el:
      CPUName.$assignMove(/*STRINGREF_STR*/DefMips64CPU);
      break;
    }
  }
  if (ABIName.empty()
     && (_Triple.getVendor() == Triple.VendorType.MipsTechnologies
     || _Triple.getVendor() == Triple.VendorType.ImaginationTechnologies)) {
    ABIName.$assignMove(/*STRINGREF_STR*/new StringSwitchCharPtr(/*NO_COPY*/CPUName).
            Case(/*KEEP_STR*/"mips1", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips2", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips3", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips4", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips5", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips32", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips32r2", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips32r3", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips32r5", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips32r6", /*KEEP_STR*/"o32").
            Case(/*KEEP_STR*/"mips64", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips64r2", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips64r3", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips64r5", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"mips64r6", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"octeon", /*KEEP_STR*/"n64").
            Case(/*KEEP_STR*/"p5600", /*KEEP_STR*/"o32").
            Default(/*KEEP_STR*/$EMPTY));
  }
  if (ABIName.empty()) {
    // Deduce ABI name from the target triple.
    if (_Triple.getArch() == Triple.ArchType.mips
       || _Triple.getArch() == Triple.ArchType.mipsel) {
      ABIName.$assignMove(/*STRINGREF_STR*/"o32");
    } else {
      ABIName.$assignMove(/*STRINGREF_STR*/"n64");
    }
  }
  if (CPUName.empty()) {
    // Deduce CPU name from ABI name.
    CPUName.$assignMove(/*STRINGREF_STR*/new StringSwitchCharPtr(/*NO_COPY*/ABIName).
            Case(/*KEEP_STR*/"o32", DefMips32CPU).
            Cases(/*KEEP_STR*/"n32", /*KEEP_STR*/"n64", DefMips64CPU).
            Default(/*KEEP_STR*/$EMPTY));
  }
  // FIXME: Warn on inconsistent use of -march and -mabi.
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::getMipsABILibSuffix">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 1322,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 1171,
 FQN="clang::driver::tools::mips::getMipsABILibSuffix", NM="_ZN5clang6driver5tools4mips19getMipsABILibSuffixERKN4llvm3opt7ArgListERKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips19getMipsABILibSuffixERKN4llvm3opt7ArgListERKNS3_6TripleE")
//</editor-fold>
public static std.string getMipsABILibSuffix(/*const*/ ArgList /*&*/ Args, 
                   /*const*/ Triple /*&*/ Triple) {
  StringRef CPUName/*J*/= new StringRef(), ABIName/*J*/= new StringRef();
  MipsStatics.getMipsCPUAndABI(Args, Triple, CPUName, ABIName);
  return new StringSwitch<std.string>(/*NO_COPY*/ABIName).
      Case(/*KEEP_STR*/"o32", new std.string(/*KEEP_STR*/$EMPTY)).
      Case(/*KEEP_STR*/"n32", new std.string(/*KEEP_STR*/"32")).
      Case(/*KEEP_STR*/"n64", new std.string(/*KEEP_STR*/"64")).$T1();
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::hasMipsAbiArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7292,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6681,
 FQN="clang::driver::tools::mips::hasMipsAbiArg", NM="_ZN5clang6driver5tools4mips13hasMipsAbiArgERKN4llvm3opt7ArgListEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips13hasMipsAbiArgERKN4llvm3opt7ArgListEPKc")
//</editor-fold>
public static boolean hasMipsAbiArg(/*const*/ ArgList /*&*/ Args, /*const*/char$ptr/*char P*/ Value) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mabi_EQ.getValue()));
  return (A != null) && ($eq_StringRef(/*STRINGREF_STR*/A.getValue(), /*STRINGREF_STR*/Value));
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::isUCLibc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7297,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6686,
 FQN="clang::driver::tools::mips::isUCLibc", NM="_ZN5clang6driver5tools4mips8isUCLibcERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips8isUCLibcERKN4llvm3opt7ArgListE")
//</editor-fold>
public static boolean isUCLibc(/*const*/ ArgList /*&*/ Args) {
  Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_m_libc_Group.getValue()));
  return (A != null) && A.getOption().matches(new OptSpecifier(options.ID.OPT_muclibc.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::isNaN2008">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7302,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6691,
 FQN="clang::driver::tools::mips::isNaN2008", NM="_ZN5clang6driver5tools4mips9isNaN2008ERKN4llvm3opt7ArgListERKNS3_6TripleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips9isNaN2008ERKN4llvm3opt7ArgListERKNS3_6TripleE")
//</editor-fold>
public static boolean isNaN2008(/*const*/ ArgList /*&*/ Args, /*const*/ Triple /*&*/ Triple) {
  {
    Arg /*P*/ NaNArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_mnan_EQ.getValue()));
    if ((NaNArg != null)) {
      return new StringSwitchBool(/*STRINGREF_STR*/NaNArg.getValue()).
          Case(/*KEEP_STR*/"2008", true).
          Case(/*KEEP_STR*/"legacy", false).
          Default(false);
    }
  }
  
  // NaN2008 is the default for MIPS32r6/MIPS64r6.
  return new StringSwitchBool(new StringRef(getCPUName(Args, Triple))).
      Cases(/*KEEP_STR*/"mips32r6", /*KEEP_STR*/"mips64r6", true).
      Default(false);
  
  //return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::isFP64ADefault">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7317,
 FQN="clang::driver::tools::mips::isFP64ADefault", NM="_ZN5clang6driver5tools4mips14isFP64ADefaultERKN4llvm6TripleENS3_9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips14isFP64ADefaultERKN4llvm6TripleENS3_9StringRefE")
//</editor-fold>
public static boolean isFP64ADefault(/*const*/ Triple /*&*/ Triple, StringRef CPUName) {
  if (!Triple.isAndroid()) {
    return false;
  }
  
  // Android MIPS32R6 defaults to FP64A.
  return new StringSwitchBool(/*NO_COPY*/CPUName).
      Case(/*KEEP_STR*/"mips32r6", true).
      Default(false);
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::isFPXXDefault">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7327,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6706,
 FQN="clang::driver::tools::mips::isFPXXDefault", NM="_ZN5clang6driver5tools4mips13isFPXXDefaultERKN4llvm6TripleENS3_9StringRefES7_NS2_8FloatABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips13isFPXXDefaultERKN4llvm6TripleENS3_9StringRefES7_NS2_8FloatABIE")
//</editor-fold>
public static boolean isFPXXDefault(/*const*/ Triple /*&*/ _Triple, StringRef CPUName, 
             StringRef ABIName, MipsStatics.FloatABI FloatABI) {
  if (_Triple.getVendor() != Triple.VendorType.ImaginationTechnologies
     && _Triple.getVendor() != Triple.VendorType.MipsTechnologies
     && !_Triple.isAndroid()) {
    return false;
  }
  if ($noteq_StringRef(/*NO_COPY*/ABIName, /*STRINGREF_STR*/"32")) {
    return false;
  }
  
  // FPXX shouldn't be used if either -msoft-float or -mfloat-abi=soft is
  // present.
  if (FloatABI == MipsStatics.FloatABI.Soft) {
    return false;
  }
  
  return new StringSwitchBool(/*NO_COPY*/CPUName).
      Cases(/*KEEP_STR*/"mips2", /*KEEP_STR*/"mips3", /*KEEP_STR*/"mips4", /*KEEP_STR*/"mips5", true).
      Cases(/*KEEP_STR*/"mips32", /*KEEP_STR*/"mips32r2", /*KEEP_STR*/"mips32r3", /*KEEP_STR*/"mips32r5", true).
      Cases(/*KEEP_STR*/"mips64", /*KEEP_STR*/"mips64r2", /*KEEP_STR*/"mips64r3", /*KEEP_STR*/"mips64r5", true).
      Default(false);
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::mips::shouldUseFPXX">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7349,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6727,
 FQN="clang::driver::tools::mips::shouldUseFPXX", NM="_ZN5clang6driver5tools4mips13shouldUseFPXXERKN4llvm3opt7ArgListERKNS3_6TripleENS3_9StringRefESB_NS2_8FloatABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools4mips13shouldUseFPXXERKN4llvm3opt7ArgListERKNS3_6TripleENS3_9StringRefESB_NS2_8FloatABIE")
//</editor-fold>
public static boolean shouldUseFPXX(/*const*/ ArgList /*&*/ Args, /*const*/ Triple /*&*/ Triple, 
             StringRef CPUName, StringRef ABIName, 
             MipsStatics.FloatABI FloatABI) {
  boolean UseFPXX = isFPXXDefault(Triple, new StringRef(CPUName), new StringRef(ABIName), FloatABI);
  {
    
    // FPXX shouldn't be used if -msingle-float is present.
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_msingle_float.getValue()), 
        new OptSpecifier(options.ID.OPT_mdouble_float.getValue()));
    if ((A != null)) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_msingle_float.getValue()))) {
        UseFPXX = false;
      }
    }
  }
  
  return UseFPXX;
}

} // END OF class MipsStatics
