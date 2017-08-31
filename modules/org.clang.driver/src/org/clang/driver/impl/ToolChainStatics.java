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
package org.clang.driver.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.driver.impl.ToolChainStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type ToolChainStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZL15GetRTTIArgumentRKN4llvm3opt7ArgListE;_ZL17CalculateRTTIModeRKN4llvm3opt7ArgListERKNS_6TripleEPKNS0_3ArgE;_ZL18ParseCXXStdlibTypeRKN4llvm9StringRefERN5clang6driver9ToolChain13CXXStdlibTypeE;_ZL27getArchNameForCompilerRTLibRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListE;_ZN12_GLOBAL__N_116FindDriverSuffixEN4llvm9StringRefE;_ZN12_GLOBAL__N_117parseDriverSuffixEN4llvm9StringRefE;_ZN12_GLOBAL__N_120normalizeProgramNameEN4llvm9StringRefE; -static-type=ToolChainStatics -package=org.clang.driver.impl")
//</editor-fold>
public final class ToolChainStatics {

//<editor-fold defaultstate="collapsed" desc="GetRTTIArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 35,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 34,
 FQN="GetRTTIArgument", NM="_ZL15GetRTTIArgumentRKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZL15GetRTTIArgumentRKN4llvm3opt7ArgListE")
//</editor-fold>
public static Arg /*P*/ GetRTTIArgument(/*const*/ ArgList /*&*/ Args) {
  return Args.getLastArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()), new OptSpecifier(options.ID.OPT_fapple_kext.getValue()), 
      new OptSpecifier(options.ID.OPT_fno_rtti.getValue()), new OptSpecifier(options.ID.OPT_frtti.getValue()));
}

//<editor-fold defaultstate="collapsed" desc="CalculateRTTIMode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 40,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 39,
 FQN="CalculateRTTIMode", NM="_ZL17CalculateRTTIModeRKN4llvm3opt7ArgListERKNS_6TripleEPKNS0_3ArgE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZL17CalculateRTTIModeRKN4llvm3opt7ArgListERKNS_6TripleEPKNS0_3ArgE")
//</editor-fold>
public static ToolChain.RTTIMode CalculateRTTIMode(/*const*/ ArgList /*&*/ Args, 
                 /*const*/ Triple /*&*/ Triple, 
                 /*const*/ Arg /*P*/ CachedRTTIArg) {
  // Explicit rtti/no-rtti args
  if ((CachedRTTIArg != null)) {
    if (CachedRTTIArg.getOption().matches(new OptSpecifier(options.ID.OPT_frtti.getValue()))) {
      return ToolChain.RTTIMode.RM_EnabledExplicitly;
    } else {
      return ToolChain.RTTIMode.RM_DisabledExplicitly;
    }
  }
  
  // -frtti is default, except for the PS4 CPU.
  if (!Triple.isPS4CPU()) {
    return ToolChain.RTTIMode.RM_EnabledImplicitly;
  }
  
  // On the PS4, turning on c++ exceptions turns on rtti.
  // We're assuming that, if we see -fexceptions, rtti gets turned on.
  Arg /*P*/ Exceptions = Args.getLastArgNoClaim(new OptSpecifier(options.ID.OPT_fcxx_exceptions.getValue()), new OptSpecifier(options.ID.OPT_fno_cxx_exceptions.getValue()), 
      new OptSpecifier(options.ID.OPT_fexceptions.getValue()), new OptSpecifier(options.ID.OPT_fno_exceptions.getValue()));
  if ((Exceptions != null)
     && (Exceptions.getOption().matches(new OptSpecifier(options.ID.OPT_fexceptions.getValue()))
     || Exceptions.getOption().matches(new OptSpecifier(options.ID.OPT_fcxx_exceptions.getValue())))) {
    return ToolChain.RTTIMode.RM_EnabledImplicitly;
  }
  
  return ToolChain.RTTIMode.RM_DisabledImplicitly;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindDriverSuffix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 101,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 100,
 FQN="(anonymous namespace)::FindDriverSuffix", NM="_ZN12_GLOBAL__N_116FindDriverSuffixEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN12_GLOBAL__N_116FindDriverSuffixEN4llvm9StringRefE")
//</editor-fold>
public static /*const*/ DriverSuffix /*P*/ FindDriverSuffix(StringRef ProgName) {
  // A list of known driver suffixes. Suffixes are compared against the
  // program name in order. If there is a match, the frontend type is updated as
  // necessary by applying the ModeFlag.
  final/*static*/ /*const*/ DriverSuffix DriverSuffixes[/*12*/] = FindDriverSuffix$$.DriverSuffixes;
  
  for (/*size_t*/int i = 0; $less_uint(i, llvm.array_lengthof(DriverSuffixes)); ++i)  {
    if (ProgName.endswith(/*STRINGREF_STR*/DriverSuffixes[i].Suffix)) {
      return /*AddrOf*/DriverSuffixes[i];
    }
  }
  return null;
}
private static final class FindDriverSuffix$$ {
  static final/*static*/ /*const*/ DriverSuffix DriverSuffixes[/*12*/] = new /*const*/ DriverSuffix [/*12*/] {
  new DriverSuffix($("clang"), (/*const*/char$ptr/*char P*/ )null), 
  new DriverSuffix($("clang++"), $("--driver-mode=g++")), 
  new DriverSuffix($("clang-c++"), $("--driver-mode=g++")), 
  new DriverSuffix($("clang-cc"), (/*const*/char$ptr/*char P*/ )null), 
  new DriverSuffix($("clang-cpp"), $("--driver-mode=cpp")), 
  new DriverSuffix($("clang-g++"), $("--driver-mode=g++")), 
  new DriverSuffix($("clang-gcc"), (/*const*/char$ptr/*char P*/ )null), 
  new DriverSuffix($("clang-cl"), $("--driver-mode=cl")), 
  new DriverSuffix($("cc"), (/*const*/char$ptr/*char P*/ )null), 
  new DriverSuffix($("cpp"), $("--driver-mode=cpp")), 
  new DriverSuffix($("cl"), $("--driver-mode=cl")), 
  new DriverSuffix($PLUS_PLUS, $("--driver-mode=g++"))
};
}


/// Normalize the program name from argv[0] by stripping the file extension if
/// present and lower-casing the string on Windows.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::normalizeProgramName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 128,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 127,
 FQN="(anonymous namespace)::normalizeProgramName", NM="_ZN12_GLOBAL__N_120normalizeProgramNameEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN12_GLOBAL__N_120normalizeProgramNameEN4llvm9StringRefE")
//</editor-fold>
public static std.string normalizeProgramName(StringRef Argv0) {
  std.string ProgName = path.stem(/*NO_COPY*/Argv0).$string();
  return ProgName;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::parseDriverSuffix">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 137,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", old_line = 136,
 FQN="(anonymous namespace)::parseDriverSuffix", NM="_ZN12_GLOBAL__N_117parseDriverSuffixEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZN12_GLOBAL__N_117parseDriverSuffixEN4llvm9StringRefE")
//</editor-fold>
public static /*const*/ DriverSuffix /*P*/ parseDriverSuffix(StringRef ProgName) {
  // Try to infer frontend type and default target from the program name by
  // comparing it against DriverSuffixes in order.
  
  // If there is a match, the function tries to identify a target as prefix.
  // E.g. "x86_64-linux-clang" as interpreted as suffix "clang" with target
  // prefix "x86_64-linux". If such a target prefix is found, it may be
  // added via -target as implicit first argument.
  /*const*/ DriverSuffix /*P*/ DS = FindDriverSuffix(new StringRef(ProgName));
  if (!(DS != null)) {
    // Try again after stripping any trailing version number:
    // clang++3.5 -> clang++
    ProgName.$assignMove(ProgName.rtrim(/*STRINGREF_STR*/"0123456789."));
    DS = FindDriverSuffix(new StringRef(ProgName));
  }
  if (!(DS != null)) {
    // Try again after stripping trailing -component.
    // clang++-tot -> clang++
    ProgName.$assignMove(ProgName.slice(0, ProgName.rfind($$MINUS)));
    DS = FindDriverSuffix(new StringRef(ProgName));
  }
  return DS;
}

//<editor-fold defaultstate="collapsed" desc="getArchNameForCompilerRTLib">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 270,
 FQN="getArchNameForCompilerRTLib", NM="_ZL27getArchNameForCompilerRTLibRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZL27getArchNameForCompilerRTLibRKN5clang6driver9ToolChainERKN4llvm3opt7ArgListE")
//</editor-fold>
public static StringRef getArchNameForCompilerRTLib(/*const*/ ToolChain /*&*/ TC, 
                           /*const*/ ArgList /*&*/ Args) {
  /*const*/ Triple /*&*/ _Triple = TC.getTriple();
  boolean IsWindows = _Triple.isOSWindows();
  if (_Triple.isWindowsMSVCEnvironment() && TC.getArch() == Triple.ArchType.x86) {
    return new StringRef(/*KEEP_STR*/"i386");
  }
  if (TC.getArch() == Triple.ArchType.arm || TC.getArch() == Triple.ArchType.armeb) {
    return new StringRef((ArmStatics.getARMFloatABI(TC, Args) == ArmStatics.FloatABI.Hard && !IsWindows) ? $("armhf") : $("arm"));
  }
  
  return TC.getArchName();
}

//<editor-fold defaultstate="collapsed" desc="ParseCXXStdlibType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp", line = 542,
 FQN="ParseCXXStdlibType", NM="_ZL18ParseCXXStdlibTypeRKN4llvm9StringRefERN5clang6driver9ToolChain13CXXStdlibTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChain.cpp -nm=_ZL18ParseCXXStdlibTypeRKN4llvm9StringRefERN5clang6driver9ToolChain13CXXStdlibTypeE")
//</editor-fold>
public static boolean ParseCXXStdlibType(/*const*/ StringRef /*&*/ Name, 
                  type$ref<ToolChain.CXXStdlibType> Type) {
  if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"libc++")) {
    Type.$set(ToolChain.CXXStdlibType.CST_Libcxx);
  } else if ($eq_StringRef(/*NO_COPY*/Name, /*STRINGREF_STR*/"libstdc++")) {
    Type.$set(ToolChain.CXXStdlibType.CST_Libstdcxx);
  } else {
    return false;
  }
  
  return true;
}

} // END OF class ToolChainStatics
