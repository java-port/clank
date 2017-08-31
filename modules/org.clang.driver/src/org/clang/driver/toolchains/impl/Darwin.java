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

package org.clang.driver.toolchains.impl;

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
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.basic.VersionTuple.*;


/// Darwin - The base Darwin tool chain.
//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 372,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 354,
 FQN="clang::driver::toolchains::Darwin", NM="_ZN5clang6driver10toolchains6DarwinE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6DarwinE")
//</editor-fold>
public class Darwin extends /*public*/ MachO implements Destructors.ClassWithDestructor {
/*public:*/
  /// Whether the information on the target has been initialized.
  //
  // FIXME: This should be eliminated. What we want to do is make this part of
  // the "default target for arguments" selection process, once we get out of
  // the argument translation business.
  public /*mutable */boolean TargetInitialized;
  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::DarwinPlatformKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 381,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 363,
   FQN="clang::driver::toolchains::Darwin::DarwinPlatformKind", NM="_ZN5clang6driver10toolchains6Darwin18DarwinPlatformKindE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6Darwin18DarwinPlatformKindE")
  //</editor-fold>
  public enum DarwinPlatformKind implements Native.ComparableLower {
    MacOS(0),
    IPhoneOS(MacOS.getValue() + 1),
    IPhoneOSSimulator(IPhoneOS.getValue() + 1),
    TvOS(IPhoneOSSimulator.getValue() + 1),
    TvOSSimulator(TvOS.getValue() + 1),
    WatchOS(TvOSSimulator.getValue() + 1),
    WatchOSSimulator(WatchOS.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static DarwinPlatformKind valueOf(int val) {
      DarwinPlatformKind out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final DarwinPlatformKind[] VALUES;
      private static final DarwinPlatformKind[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (DarwinPlatformKind kind : DarwinPlatformKind.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new DarwinPlatformKind[min < 0 ? (1-min) : 0];
        VALUES = new DarwinPlatformKind[max >= 0 ? (1+max) : 0];
        for (DarwinPlatformKind kind : DarwinPlatformKind.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private DarwinPlatformKind(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((DarwinPlatformKind)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((DarwinPlatformKind)obj).value);}
    //</editor-fold>
  };
  
  public /*mutable */DarwinPlatformKind TargetPlatform;
  
  /// The OS version we are targeting.
  public /*mutable */VersionTuple TargetVersion;
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::AddDeploymentTarget">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 500,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 465,
   FQN="clang::driver::toolchains::Darwin::AddDeploymentTarget", NM="_ZNK5clang6driver10toolchains6Darwin19AddDeploymentTargetERN4llvm3opt14DerivedArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin19AddDeploymentTargetERN4llvm3opt14DerivedArgListE")
  //</editor-fold>
  private void AddDeploymentTarget(DerivedArgList /*&*/ Args) /*const*/ {
    /*const*/ OptTable /*&*/ Opts = getDriver().getOpts();
    {
      
      // Support allowing the SDKROOT environment variable used by xcrun and other
      // Xcode tools to define the default sysroot, by making it the default for
      // isysroot.
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()));
      if ((A != null)) {
        // Warn if the path does not exist.
        if (!getVFS().exists(new Twine(A.getValue()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.warn_missing_sysroot)), A.getValue()));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        {
          char$ptr/*char P*/ env = $tryClone(/*::*/getenv($("SDKROOT")));
          if ((env != null)) {
            // We only use this value as the default if it is an absolute path,
            // exists, and it is not the root path.
            if (path.is_absolute(new Twine(env)) && getVFS().exists(new Twine(env))
               && $noteq_StringRef(new StringRef(env), /*STRINGREF_STR*/"/")) {
              Args.append(Args.MakeSeparateArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_isysroot.getValue())), new StringRef(env)));
            }
          }
        }
      }
    }
    
    Arg /*P*/ OSXVersion = Args.getLastArg(new OptSpecifier(options.ID.OPT_mmacosx_version_min_EQ.getValue()));
    Arg /*P*/ iOSVersion = Args.getLastArg(new OptSpecifier(options.ID.OPT_miphoneos_version_min_EQ.getValue()));
    Arg /*P*/ TvOSVersion = Args.getLastArg(new OptSpecifier(options.ID.OPT_mtvos_version_min_EQ.getValue()));
    Arg /*P*/ WatchOSVersion = Args.getLastArg(new OptSpecifier(options.ID.OPT_mwatchos_version_min_EQ.getValue()));
    if ((OSXVersion != null) && ((iOSVersion != null) || (TvOSVersion != null) || (WatchOSVersion != null))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_argument_not_allowed_with)), 
                new StringRef(OSXVersion.getAsString(Args))), 
            new StringRef(((iOSVersion != null) ? iOSVersion : (TvOSVersion != null) ? TvOSVersion : WatchOSVersion).getAsString(Args))));
        iOSVersion = TvOSVersion = WatchOSVersion = null;
      } finally {
        $c$.$destroy();
      }
    } else if ((iOSVersion != null) && ((TvOSVersion != null) || (WatchOSVersion != null))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_argument_not_allowed_with)), 
                new StringRef(iOSVersion.getAsString(Args))), 
            new StringRef(((TvOSVersion != null) ? TvOSVersion : WatchOSVersion).getAsString(Args))));
        TvOSVersion = WatchOSVersion = null;
      } finally {
        $c$.$destroy();
      }
    } else if ((TvOSVersion != null) && (WatchOSVersion != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_argument_not_allowed_with)), 
                new StringRef(TvOSVersion.getAsString(Args))), 
            new StringRef(WatchOSVersion.getAsString(Args))));
        WatchOSVersion = null;
      } finally {
        $c$.$destroy();
      }
    } else if (!(OSXVersion != null) && !(iOSVersion != null) && !(TvOSVersion != null) && !(WatchOSVersion != null)) {
      // If no deployment target was specified on the command line, check for
      // environment defines.
      std.string OSXTarget/*J*/= new std.string();
      std.string iOSTarget/*J*/= new std.string();
      std.string TvOSTarget/*J*/= new std.string();
      std.string WatchOSTarget/*J*/= new std.string();
      {
        
        char$ptr/*char P*/ env = $tryClone(/*::*/getenv($("MACOSX_DEPLOYMENT_TARGET")));
        if ((env != null)) {
          OSXTarget.$assign(env);
        }
      }
      {
        char$ptr/*char P*/ env = $tryClone(/*::*/getenv($("IPHONEOS_DEPLOYMENT_TARGET")));
        if ((env != null)) {
          iOSTarget.$assign(env);
        }
      }
      {
        char$ptr/*char P*/ env = $tryClone(/*::*/getenv($("TVOS_DEPLOYMENT_TARGET")));
        if ((env != null)) {
          TvOSTarget.$assign(env);
        }
      }
      {
        char$ptr/*char P*/ env = $tryClone(/*::*/getenv($("WATCHOS_DEPLOYMENT_TARGET")));
        if ((env != null)) {
          WatchOSTarget.$assign(env);
        }
      }
      
      // If there is no command-line argument to specify the Target version and
      // no environment variable defined, see if we can set the default based
      // on -isysroot.
      if (OSXTarget.empty() && iOSTarget.empty() && WatchOSTarget.empty()
         && TvOSTarget.empty() && Args.hasArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()))) {
        {
          /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()));
          if ((A != null)) {
            StringRef isysroot = new StringRef(A.getValue());
            StringRef SDK = getSDKName(new StringRef(isysroot));
            if ($greater_uint(SDK.size(), 0)) {
              // Slice the version number out.
              // Version number is between the first and the last number.
              /*size_t*/int StartVer = SDK.find_first_of(/*STRINGREF_STR*/"0123456789");
              /*size_t*/int EndVer = SDK.find_last_of(/*STRINGREF_STR*/"0123456789");
              if (StartVer != StringRef.npos && $greater_uint(EndVer, StartVer)) {
                StringRef Version = SDK.slice(StartVer, EndVer + 1);
                if (SDK.startswith(/*STRINGREF_STR*/"iPhoneOS")
                   || SDK.startswith(/*STRINGREF_STR*/"iPhoneSimulator")) {
                  iOSTarget.$assignMove(Version.$string());
                } else if (SDK.startswith(/*STRINGREF_STR*/"MacOSX")) {
                  OSXTarget.$assignMove(Version.$string());
                } else if (SDK.startswith(/*STRINGREF_STR*/"WatchOS")
                   || SDK.startswith(/*STRINGREF_STR*/"WatchSimulator")) {
                  WatchOSTarget.$assignMove(Version.$string());
                } else if (SDK.startswith(/*STRINGREF_STR*/"AppleTVOS")
                   || SDK.startswith(/*STRINGREF_STR*/"AppleTVSimulator")) {
                  TvOSTarget.$assignMove(Version.$string());
                }
              }
            }
          }
        }
      }
      
      // If no OSX or iOS target has been specified, try to guess platform
      // from arch name and compute the version from the triple.
      if (OSXTarget.empty() && iOSTarget.empty() && TvOSTarget.empty()
         && WatchOSTarget.empty()) {
        StringRef MachOArchName = getMachOArchName(Args);
        /*uint*/uint$ref Major = create_uint$ref(), Minor = create_uint$ref(), Micro = create_uint$ref();
        if ($eq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"armv7") || $eq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"armv7s")
           || $eq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"arm64")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            getTriple().getiOSVersion(Major, Minor, Micro);
            $c$.clean($c$.track(new raw_string_ostream(iOSTarget)).$out_uint(Major).$out_char($$DOT).$out_uint(Minor).$out_char($$DOT).$out_uint(Micro));
          } finally {
            $c$.$destroy();
          }
        } else if ($eq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"armv7k")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            getTriple().getWatchOSVersion(Major, Minor, Micro);
            $c$.clean($c$.track(new raw_string_ostream(WatchOSTarget)).$out_uint(Major).$out_char($$DOT).$out_uint(Minor).$out_char($$DOT).$out_uint(Micro));
          } finally {
            $c$.$destroy();
          }
        } else if ($noteq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"armv6m") && $noteq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"armv7m")
           && $noteq_StringRef(/*NO_COPY*/MachOArchName, /*STRINGREF_STR*/"armv7em")) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (!getTriple().getMacOSXVersion(Major, Minor, Micro)) {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_darwin_version)), 
                  getTriple().getOSName()));
            }
            $c$.clean($c$.track(new raw_string_ostream(OSXTarget)).$out_uint(Major).$out_char($$DOT).$out_uint(Minor).$out_char($$DOT).$out_uint(Micro));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      // Do not allow conflicts with the watchOS target.
      if (!WatchOSTarget.empty() && (!iOSTarget.empty() || !TvOSTarget.empty())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.err_drv_conflicting_deployment_targets)), 
                  /*KEEP_STR*/"WATCHOS_DEPLOYMENT_TARGET"), 
              (!iOSTarget.empty() ? $("IPHONEOS_DEPLOYMENT_TARGET") : $("TVOS_DEPLOYMENT_TARGET"))));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Do not allow conflicts with the tvOS target.
      if (!TvOSTarget.empty() && !iOSTarget.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.err_drv_conflicting_deployment_targets)), 
                  /*KEEP_STR*/"TVOS_DEPLOYMENT_TARGET"), 
              /*KEEP_STR*/"IPHONEOS_DEPLOYMENT_TARGET"));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Allow conflicts among OSX and iOS for historical reasons, but choose the
      // default platform.
      if (!OSXTarget.empty() && (!iOSTarget.empty()
         || !WatchOSTarget.empty()
         || !TvOSTarget.empty())) {
        if (getTriple().getArch() == Triple.ArchType.arm
           || getTriple().getArch() == Triple.ArchType.aarch64
           || getTriple().getArch() == Triple.ArchType.thumb) {
          OSXTarget.$assign(/*KEEP_STR*/"");
        } else {
          iOSTarget.$assign(WatchOSTarget.$assign(TvOSTarget.$assign(/*KEEP_STR*/"")));
        }
      }
      if (!OSXTarget.empty()) {
        /*const*/ Option O = Opts.getOption(new OptSpecifier(options.ID.OPT_mmacosx_version_min_EQ.getValue()));
        OSXVersion = Args.MakeJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/O, new StringRef(OSXTarget));
        Args.append(OSXVersion);
      } else if (!iOSTarget.empty()) {
        /*const*/ Option O = Opts.getOption(new OptSpecifier(options.ID.OPT_miphoneos_version_min_EQ.getValue()));
        iOSVersion = Args.MakeJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/O, new StringRef(iOSTarget));
        Args.append(iOSVersion);
      } else if (!TvOSTarget.empty()) {
        /*const*/ Option O = Opts.getOption(new OptSpecifier(options.ID.OPT_mtvos_version_min_EQ.getValue()));
        TvOSVersion = Args.MakeJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/O, new StringRef(TvOSTarget));
        Args.append(TvOSVersion);
      } else if (!WatchOSTarget.empty()) {
        /*const*/ Option O = Opts.getOption(new OptSpecifier(options.ID.OPT_mwatchos_version_min_EQ.getValue()));
        WatchOSVersion = Args.MakeJoinedArg((/*const*/ Arg /*P*/ )null, /*NO_COPY*/O, new StringRef(WatchOSTarget));
        Args.append(WatchOSVersion);
      }
    }
    
    DarwinPlatformKind Platform;
    if ((OSXVersion != null)) {
      Platform = DarwinPlatformKind.MacOS;
    } else if ((iOSVersion != null)) {
      Platform = DarwinPlatformKind.IPhoneOS;
    } else if ((TvOSVersion != null)) {
      Platform = DarwinPlatformKind.TvOS;
    } else if ((WatchOSVersion != null)) {
      Platform = DarwinPlatformKind.WatchOS;
    } else {
      throw new llvm_unreachable("Unable to infer Darwin variant");
    }
    
    // Set the tool chain target information.
    /*uint*/uint$ref Major = create_uint$ref(), Minor = create_uint$ref(), Micro = create_uint$ref();
    bool$ref HadExtra = create_bool$ref();
    if (Platform == DarwinPlatformKind.MacOS) {
      assert ((!(iOSVersion != null) && !(TvOSVersion != null) && !(WatchOSVersion != null))) : "Unknown target platform!";
      if (!Driver.GetReleaseVersion(OSXVersion.getValue(), Major, Minor, Micro, 
          HadExtra)
         || HadExtra.$deref() || Major.$deref() != 10 || $greatereq_uint(Minor, 100) || $greatereq_uint(Micro, 100)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_version_number)), 
              new StringRef(OSXVersion.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (Platform == DarwinPlatformKind.IPhoneOS) {
      assert ((iOSVersion != null)) : "Unknown target platform!";
      if (!Driver.GetReleaseVersion(iOSVersion.getValue(), Major, Minor, Micro, 
          HadExtra)
         || HadExtra.$deref() || $greatereq_uint(Major, 10) || $greatereq_uint(Minor, 100) || $greatereq_uint(Micro, 100)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_version_number)), 
              new StringRef(iOSVersion.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (Platform == DarwinPlatformKind.TvOS) {
      if (!Driver.GetReleaseVersion(TvOSVersion.getValue(), Major, Minor, 
          Micro, HadExtra) || HadExtra.$deref()
         || $greatereq_uint(Major, 10) || $greatereq_uint(Minor, 100) || $greatereq_uint(Micro, 100)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_version_number)), 
              new StringRef(TvOSVersion.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    } else if (Platform == DarwinPlatformKind.WatchOS) {
      if (!Driver.GetReleaseVersion(WatchOSVersion.getValue(), Major, Minor, 
          Micro, HadExtra) || HadExtra.$deref()
         || $greatereq_uint(Major, 10) || $greatereq_uint(Minor, 100) || $greatereq_uint(Micro, 100)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_version_number)), 
              new StringRef(WatchOSVersion.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      throw new llvm_unreachable("unknown kind of Darwin platform");
    }
    
    // Recognize iOS targets with an x86 architecture as the iOS simulator.
    if ((iOSVersion != null) && (getTriple().getArch() == Triple.ArchType.x86
       || getTriple().getArch() == Triple.ArchType.x86_64)) {
      Platform = DarwinPlatformKind.IPhoneOSSimulator;
    }
    if ((TvOSVersion != null) && (getTriple().getArch() == Triple.ArchType.x86
       || getTriple().getArch() == Triple.ArchType.x86_64)) {
      Platform = DarwinPlatformKind.TvOSSimulator;
    }
    if ((WatchOSVersion != null) && (getTriple().getArch() == Triple.ArchType.x86
       || getTriple().getArch() == Triple.ArchType.x86_64)) {
      Platform = DarwinPlatformKind.WatchOSSimulator;
    }
    
    setTarget(Platform, Major.$deref(), Minor.$deref(), Micro.$deref());
    {
      
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()));
      if ((A != null)) {
        StringRef SDK = getSDKName(new StringRef(A.getValue()));
        if ($greater_uint(SDK.size(), 0)) {
          /*size_t*/int StartVer = SDK.find_first_of(/*STRINGREF_STR*/"0123456789");
          StringRef SDKName = SDK.slice(0, StartVer);
          if (!SDKName.startswith(getPlatformFamily())) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.warn_incompatible_sysroot)), 
                      /*NO_COPY*/SDKName), getPlatformFamily()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }

/*public:*/
  
  /// Darwin - Darwin tool chain for i386 and x86_64.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::Darwin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 54,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 53,
   FQN="clang::driver::toolchains::Darwin::Darwin", NM="_ZN5clang6driver10toolchains6DarwinC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6DarwinC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public Darwin(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, /*const*/ ArgList /*&*/ Args) {
    /* : MachO(D, Triple, Args), TargetInitialized(false), TargetVersion()*/ 
    //START JInit
    super(D, Triple, Args);
    this.TargetInitialized = false;
    this.TargetVersion = new VersionTuple();
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::~Darwin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 164,
   FQN="clang::driver::toolchains::Darwin::~Darwin", NM="_ZN5clang6driver10toolchains6DarwinD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6DarwinD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::ComputeEffectiveClangTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 186,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 175,
   FQN="clang::driver::toolchains::Darwin::ComputeEffectiveClangTriple", NM="_ZNK5clang6driver10toolchains6Darwin27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE")
  //</editor-fold>
  @Override public std.string ComputeEffectiveClangTriple(/*const*/ ArgList /*&*/ Args, 
                             types.ID InputType) /*const*//* override*/ {
    Triple Triple/*J*/= new Triple(new Twine(ComputeLLVMTriple(Args, InputType)));
    
    // If the target isn't initialized (e.g., an unknown Darwin platform, return
    // the default triple).
    if (!isTargetInitialized()) {
      return new std.string(Triple.getTriple());
    }
    
    SmallString/*16*/ Str/*J*/= new SmallString/*16*/(16);
    if (isTargetWatchOSBased()) {
      Str.$addassign(/*STRINGREF_STR*/"watchos");
    } else if (isTargetTvOSBased()) {
      Str.$addassign(/*STRINGREF_STR*/"tvos");
    } else if (isTargetIOSBased()) {
      Str.$addassign(/*STRINGREF_STR*/"ios");
    } else {
      Str.$addassign(/*STRINGREF_STR*/"macosx");
    }
    Str.$addassign(new StringRef(getTargetVersion().getAsString()));
    Triple.setOSName(Str.$StringRef());
    
    return new std.string(Triple.getTriple());
  }

  
  /// @name Apple Specific Toolchain Implementation
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::addMinVersionArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1135,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1088,
   FQN="clang::driver::toolchains::Darwin::addMinVersionArgs", NM="_ZNK5clang6driver10toolchains6Darwin17addMinVersionArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin17addMinVersionArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addMinVersionArgs(/*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    VersionTuple TargetVersion = getTargetVersion();
    if (isTargetWatchOS()) {
      CmdArgs.push_back($("-watchos_version_min"));
    } else if (isTargetWatchOSSimulator()) {
      CmdArgs.push_back($("-watchos_simulator_version_min"));
    } else if (isTargetTvOS()) {
      CmdArgs.push_back($("-tvos_version_min"));
    } else if (isTargetTvOSSimulator()) {
      CmdArgs.push_back($("-tvos_simulator_version_min"));
    } else if (isTargetIOSSimulator()) {
      CmdArgs.push_back($("-ios_simulator_version_min"));
    } else if (isTargetIOSBased()) {
      CmdArgs.push_back($("-iphoneos_version_min"));
    } else {
      assert (isTargetMacOS()) : "unexpected target";
      CmdArgs.push_back($("-macosx_version_min"));
    }
    
    CmdArgs.push_back(Args.MakeArgString(new Twine(TargetVersion.getAsString())));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::addStartObjectFileArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1159,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1112,
   FQN="clang::driver::toolchains::Darwin::addStartObjectFileArgs", NM="_ZNK5clang6driver10toolchains6Darwin22addStartObjectFileArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin22addStartObjectFileArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addStartObjectFileArgs(/*const*/ ArgList /*&*/ Args, 
                        ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // Derived from startfile spec.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_dynamiclib.getValue()))) {
      // Derived from darwin_dylib1 spec.
      if (isTargetWatchOSBased()) {
        ; // watchOS does not need dylib1.o.
      } else if (isTargetIOSSimulator()) {
        ; // iOS simulator does not need dylib1.o.
      } else if (isTargetIPhoneOS()) {
        if (isIPhoneOSVersionLT(3, 1)) {
          CmdArgs.push_back($("-ldylib1.o"));
        }
      } else {
        if (isMacosxVersionLT(10, 5)) {
          CmdArgs.push_back($("-ldylib1.o"));
        } else if (isMacosxVersionLT(10, 6)) {
          CmdArgs.push_back($("-ldylib1.10.5.o"));
        }
      }
    } else {
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_bundle.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
          // Derived from darwin_bundle1 spec.
          if (isTargetWatchOSBased()) {
            ; // watchOS does not need bundle1.o.
          } else if (isTargetIOSSimulator()) {
            ; // iOS simulator does not need bundle1.o.
          } else if (isTargetIPhoneOS()) {
            if (isIPhoneOSVersionLT(3, 1)) {
              CmdArgs.push_back($("-lbundle1.o"));
            }
          } else {
            if (isMacosxVersionLT(10, 6)) {
              CmdArgs.push_back($("-lbundle1.o"));
            }
          }
        }
      } else {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue())) && SupportsProfiling()) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_object.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_preload.getValue()))) {
            CmdArgs.push_back($("-lgcrt0.o"));
          } else {
            CmdArgs.push_back($("-lgcrt1.o"));
            // darwin_crt2 spec is empty.
          }
          // By default on OS X 10.8 and later, we don't link with a crt1.o
          // file and the linker knows to use _main as the entry point.  But,
          // when compiling with -pg, we need to link with the gcrt1.o file,
          // so pass the -no_new_main option to tell the linker to use the
          // "start" symbol as the entry point.
          if (isTargetMacOS() && !isMacosxVersionLT(10, 8)) {
            CmdArgs.push_back($("-no_new_main"));
          }
        } else {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_object.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_preload.getValue()))) {
            CmdArgs.push_back($("-lcrt0.o"));
          } else {
            // Derived from darwin_crt1 spec.
            if (isTargetWatchOSBased()) {
              ; // watchOS does not need crt1.o.
            } else if (isTargetIOSSimulator()) {
              ; // iOS simulator does not need crt1.o.
            } else if (isTargetIPhoneOS()) {
              if (getArch() == Triple.ArchType.aarch64) {
                ; // iOS does not need any crt1 files for arm64
              } else if (isIPhoneOSVersionLT(3, 1)) {
                CmdArgs.push_back($("-lcrt1.o"));
              } else if (isIPhoneOSVersionLT(6, 0)) {
                CmdArgs.push_back($("-lcrt1.3.1.o"));
              }
            } else {
              if (isMacosxVersionLT(10, 5)) {
                CmdArgs.push_back($("-lcrt1.o"));
              } else if (isMacosxVersionLT(10, 6)) {
                CmdArgs.push_back($("-lcrt1.10.5.o"));
              } else if (isMacosxVersionLT(10, 8)) {
                CmdArgs.push_back($("-lcrt1.10.6.o"));
              }
              // darwin_crt2 spec is empty.
            }
          }
        }
      }
    }
    if (!isTargetIPhoneOS() && Args.hasArg(new OptSpecifier(options.ID.OPT_shared_libgcc.getValue()))
       && !isTargetWatchOS()
       && isMacosxVersionLT(10, 5)) {
      /*const*/char$ptr/*char P*/ Str = $tryClone(Args.MakeArgString(new Twine(GetFilePath($("crt3.o")))));
      CmdArgs.push_back(Str);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isKernelStatic">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 416,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 398,
   FQN="clang::driver::toolchains::Darwin::isKernelStatic", NM="_ZNK5clang6driver10toolchains6Darwin14isKernelStaticEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin14isKernelStaticEv")
  //</editor-fold>
  @Override public boolean isKernelStatic() /*const*//* override*/ {
    return (!(isTargetIPhoneOS() && !isIPhoneOSVersionLT(6, 0))
       && !isTargetWatchOS());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::addProfileRTLibs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 383,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 322,
   FQN="clang::driver::toolchains::Darwin::addProfileRTLibs", NM="_ZNK5clang6driver10toolchains6Darwin16addProfileRTLibsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin16addProfileRTLibsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addProfileRTLibs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    if (!needsProfileRT(Args)) {
      return;
    }
    
    AddLinkRuntimeLib(Args, CmdArgs, new StringRef(($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"libclang_rt.profile_"), 
                    new Twine(getOSLibraryNameSuffix())), new Twine(/*KEEP_STR*/".a"))).str()), 
        /*AlwaysLink*/ true);
  }

/*protected:*/
  /// }
  /// @name Darwin specific Toolchain functions
  /// {
  
  // FIXME: Eliminate these ...Target functions and derive separate tool chains
  // for these targets and put version in constructor.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::setTarget">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 431,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 413,
   FQN="clang::driver::toolchains::Darwin::setTarget", NM="_ZNK5clang6driver10toolchains6Darwin9setTargetENS2_18DarwinPlatformKindEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin9setTargetENS2_18DarwinPlatformKindEjjj")
  //</editor-fold>
  protected void setTarget(DarwinPlatformKind Platform, /*uint*/int Major, /*uint*/int Minor, 
           /*uint*/int Micro) /*const*/ {
    // FIXME: For now, allow reinitialization as long as values don't
    // change. This will go away when we move away from argument translation.
    if (TargetInitialized && TargetPlatform == Platform
       && $eq_VersionTuple$C(TargetVersion, new VersionTuple(Major, Minor, Micro))) {
      return;
    }
    assert (!TargetInitialized) : "Target already initialized!";
    TargetInitialized = true;
    TargetPlatform = Platform;
    TargetVersion.$assignMove(new VersionTuple(Major, Minor, Micro));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetIPhoneOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 445,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 427,
   FQN="clang::driver::toolchains::Darwin::isTargetIPhoneOS", NM="_ZNK5clang6driver10toolchains6Darwin16isTargetIPhoneOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin16isTargetIPhoneOSEv")
  //</editor-fold>
  protected boolean isTargetIPhoneOS() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.IPhoneOS || TargetPlatform == DarwinPlatformKind.TvOS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetIOSSimulator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 450,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 432,
   FQN="clang::driver::toolchains::Darwin::isTargetIOSSimulator", NM="_ZNK5clang6driver10toolchains6Darwin20isTargetIOSSimulatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin20isTargetIOSSimulatorEv")
  //</editor-fold>
  protected boolean isTargetIOSSimulator() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.IPhoneOSSimulator
       || TargetPlatform == DarwinPlatformKind.TvOSSimulator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetIOSBased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 456,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 438,
   FQN="clang::driver::toolchains::Darwin::isTargetIOSBased", NM="_ZNK5clang6driver10toolchains6Darwin16isTargetIOSBasedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin16isTargetIOSBasedEv")
  //</editor-fold>
  public/*protected*/ boolean isTargetIOSBased() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return isTargetIPhoneOS() || isTargetIOSSimulator();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetTvOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 443,
   FQN="clang::driver::toolchains::Darwin::isTargetTvOS", NM="_ZNK5clang6driver10toolchains6Darwin12isTargetTvOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin12isTargetTvOSEv")
  //</editor-fold>
  protected boolean isTargetTvOS() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.TvOS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetTvOSSimulator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 466,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 448,
   FQN="clang::driver::toolchains::Darwin::isTargetTvOSSimulator", NM="_ZNK5clang6driver10toolchains6Darwin21isTargetTvOSSimulatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin21isTargetTvOSSimulatorEv")
  //</editor-fold>
  protected boolean isTargetTvOSSimulator() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.TvOSSimulator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetTvOSBased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 471,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 453,
   FQN="clang::driver::toolchains::Darwin::isTargetTvOSBased", NM="_ZNK5clang6driver10toolchains6Darwin17isTargetTvOSBasedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin17isTargetTvOSBasedEv")
  //</editor-fold>
  protected boolean isTargetTvOSBased() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.TvOS || TargetPlatform == DarwinPlatformKind.TvOSSimulator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetWatchOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 458,
   FQN="clang::driver::toolchains::Darwin::isTargetWatchOS", NM="_ZNK5clang6driver10toolchains6Darwin15isTargetWatchOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin15isTargetWatchOSEv")
  //</editor-fold>
  protected boolean isTargetWatchOS() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.WatchOS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetWatchOSSimulator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 481,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 463,
   FQN="clang::driver::toolchains::Darwin::isTargetWatchOSSimulator", NM="_ZNK5clang6driver10toolchains6Darwin24isTargetWatchOSSimulatorEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin24isTargetWatchOSSimulatorEv")
  //</editor-fold>
  protected boolean isTargetWatchOSSimulator() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.WatchOSSimulator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetWatchOSBased">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 486,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 468,
   FQN="clang::driver::toolchains::Darwin::isTargetWatchOSBased", NM="_ZNK5clang6driver10toolchains6Darwin20isTargetWatchOSBasedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin20isTargetWatchOSBasedEv")
  //</editor-fold>
  protected boolean isTargetWatchOSBased() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.WatchOS || TargetPlatform == DarwinPlatformKind.WatchOSSimulator;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetMacOS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 491,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 473,
   FQN="clang::driver::toolchains::Darwin::isTargetMacOS", NM="_ZNK5clang6driver10toolchains6Darwin13isTargetMacOSEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin13isTargetMacOSEv")
  //</editor-fold>
  protected boolean isTargetMacOS() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return TargetPlatform == DarwinPlatformKind.MacOS;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isTargetInitialized">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 496,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 478,
   FQN="clang::driver::toolchains::Darwin::isTargetInitialized", NM="_ZNK5clang6driver10toolchains6Darwin19isTargetInitializedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin19isTargetInitializedEv")
  //</editor-fold>
  protected boolean isTargetInitialized() /*const*/ {
    return TargetInitialized;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::getTargetVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 498,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 480,
   FQN="clang::driver::toolchains::Darwin::getTargetVersion", NM="_ZNK5clang6driver10toolchains6Darwin16getTargetVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin16getTargetVersionEv")
  //</editor-fold>
  protected VersionTuple getTargetVersion() /*const*/ {
    assert (TargetInitialized) : "Target not initialized!";
    return new VersionTuple(TargetVersion);
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isIPhoneOSVersionLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 503,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 485,
   FQN="clang::driver::toolchains::Darwin::isIPhoneOSVersionLT", NM="_ZNK5clang6driver10toolchains6Darwin19isIPhoneOSVersionLTEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin19isIPhoneOSVersionLTEjjj")
  //</editor-fold>
  protected boolean isIPhoneOSVersionLT(/*uint*/int V0) /*const*/ {
    return isIPhoneOSVersionLT(V0, 0, 
                     0);
  }
  protected boolean isIPhoneOSVersionLT(/*uint*/int V0, /*uint*/int V1/*= 0*/) /*const*/ {
    return isIPhoneOSVersionLT(V0, V1, 
                     0);
  }
  protected boolean isIPhoneOSVersionLT(/*uint*/int V0, /*uint*/int V1/*= 0*/, 
                     /*uint*/int V2/*= 0*/) /*const*/ {
    assert (isTargetIOSBased()) : "Unexpected call for non iOS target!";
    return $less_VersionTuple$C(TargetVersion, new VersionTuple(V0, V1, V2));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isMacosxVersionLT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 509,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 491,
   FQN="clang::driver::toolchains::Darwin::isMacosxVersionLT", NM="_ZNK5clang6driver10toolchains6Darwin17isMacosxVersionLTEjjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin17isMacosxVersionLTEjjj")
  //</editor-fold>
  protected boolean isMacosxVersionLT(/*uint*/int V0) /*const*/ {
    return isMacosxVersionLT(V0, 0, 0);
  }
  protected boolean isMacosxVersionLT(/*uint*/int V0, /*uint*/int V1/*= 0*/) /*const*/ {
    return isMacosxVersionLT(V0, V1, 0);
  }
  protected boolean isMacosxVersionLT(/*uint*/int V0, /*uint*/int V1/*= 0*/, /*uint*/int V2/*= 0*/) /*const*/ {
    assert (isTargetMacOS()) : "Unexpected call for non OS X target!";
    return $less_VersionTuple$C(TargetVersion, new VersionTuple(V0, V1, V2));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::getPlatformFamily">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 333,
   FQN="clang::driver::toolchains::Darwin::getPlatformFamily", NM="_ZNK5clang6driver10toolchains6Darwin17getPlatformFamilyEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin17getPlatformFamilyEv")
  //</editor-fold>
  protected StringRef getPlatformFamily() /*const*/ {
    switch (TargetPlatform) {
     case MacOS:
      return new StringRef(/*KEEP_STR*/"MacOSX");
     case IPhoneOS:
     case IPhoneOSSimulator:
      return new StringRef(/*KEEP_STR*/"iPhone");
     case TvOS:
     case TvOSSimulator:
      return new StringRef(/*KEEP_STR*/"AppleTV");
     case WatchOS:
     case WatchOSSimulator:
      return new StringRef(/*KEEP_STR*/"Watch");
    }
    throw new llvm_unreachable("Unsupported platform");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::getSDKName">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 350,
   FQN="clang::driver::toolchains::Darwin::getSDKName", NM="_ZN5clang6driver10toolchains6Darwin10getSDKNameEN4llvm9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6Darwin10getSDKNameEN4llvm9StringRefE")
  //</editor-fold>
  protected static StringRef getSDKName(StringRef isysroot) {
    // Assume SDK has path: SOME_PATH/SDKs/PlatformXX.YY.sdk
    path.const_iterator SDKDir/*J*/= new path.const_iterator();
    path.const_iterator BeginSDK = path.begin(/*NO_COPY*/isysroot);
    path.const_iterator EndSDK = path.end(/*NO_COPY*/isysroot);
    for (path.const_iterator IT = new path.const_iterator(BeginSDK); IT.$noteq(EndSDK); IT.$preInc()) {
      StringRef SDK = new StringRef(IT.$star());
      if (SDK.endswith(/*STRINGREF_STR*/".sdk")) {
        return SDK.slice(0, SDK.size() - 4);
      }
    }
    return new StringRef(/*KEEP_STR*/$EMPTY);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::getOSLibraryNameSuffix">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 363,
   FQN="clang::driver::toolchains::Darwin::getOSLibraryNameSuffix", NM="_ZNK5clang6driver10toolchains6Darwin22getOSLibraryNameSuffixEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin22getOSLibraryNameSuffixEv")
  //</editor-fold>
  protected StringRef getOSLibraryNameSuffix() /*const*/ {
    switch (TargetPlatform) {
     case MacOS:
      return new StringRef(/*KEEP_STR*/"osx");
     case IPhoneOS:
      return new StringRef(/*KEEP_STR*/"ios");
     case IPhoneOSSimulator:
      return new StringRef(/*KEEP_STR*/"iossim");
     case TvOS:
      return new StringRef(/*KEEP_STR*/"tvos");
     case TvOSSimulator:
      return new StringRef(/*KEEP_STR*/"tvossim");
     case WatchOS:
      return new StringRef(/*KEEP_STR*/"watchos");
     case WatchOSSimulator:
      return new StringRef(/*KEEP_STR*/"watchossim");
    }
    throw new llvm_unreachable("Unsupported platform");
  }

/*public:*/
  /// }
  /// @name ToolChain Implementation
  /// {
  
  // Darwin tools support multiple architecture (e.g., i386 and x86_64) and
  // most development is done against SDKs, so compiling for a different
  // architecture should not get any special treatment.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::isCrossCompiling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 526,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 504,
   FQN="clang::driver::toolchains::Darwin::isCrossCompiling", NM="_ZNK5clang6driver10toolchains6Darwin16isCrossCompilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin16isCrossCompilingEv")
  //</editor-fold>
  @Override public boolean isCrossCompiling() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::TranslateArgs">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*update end after erase*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1035,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 993,
   FQN="clang::driver::toolchains::Darwin::TranslateArgs", NM="_ZNK5clang6driver10toolchains6Darwin13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc")
  //</editor-fold>
  @Override public DerivedArgList /*P*/ TranslateArgs(/*const*/ DerivedArgList /*&*/ Args, 
               /*const*/char$ptr/*char P*/ BoundArch) /*const*//* override*/ {
    // First get the generic Apple args, before moving onto Darwin-specific ones.
    DerivedArgList /*P*/ DAL = super.TranslateArgs(Args, BoundArch);
    /*const*/ OptTable /*&*/ Opts = getDriver().getOpts();
    
    // If no architecture is bound, none of the translations here are relevant.
    if (!(BoundArch != null)) {
      return DAL;
    }
    
    // Add an explicit version min argument for the deployment target. We do this
    // after argument translation because -Xarch_ arguments may add a version min
    // argument.
    AddDeploymentTarget(/*Deref*/DAL);
    
    // For iOS 6, undo the translation to add -static for -mkernel/-fapple-kext.
    // FIXME: It would be far better to avoid inserting those -static arguments,
    // but we can't check the deployment target in the translation code until
    // it is set here.
    if (isTargetWatchOSBased()
       || (isTargetIOSBased() && !isIPhoneOSVersionLT(6, 0))) {
      for (type$ptr<Arg> it = DAL.begin(), ie = DAL.end(); $noteq_iter(it, ie);) {
        Arg /*P*/ A = it.$star();
        it.$preInc();
        if (A.getOption().getID() != options.ID.OPT_mkernel.getValue()
           && A.getOption().getID() != options.ID.OPT_fapple_kext.getValue()) {
          continue;
        }
        assert ($noteq_iter(it, ie)) : "unexpected argument translation";
        A = it.$star();
        assert (A.getOption().getID() == options.ID.OPT_static.getValue()) : "missing expected -static argument";
        it = $tryClone(DAL.getArgs().erase(it));
        // JAVA FIX: update end
        ie = DAL.end();
      }
    }
    if (!(Args.getLastArg(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue())) != null)
       && GetCXXStdlibType(Args) == ToolChain.CXXStdlibType.CST_Libcxx) {
      DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue())), 
          new StringRef(/*KEEP_STR*/"libc++"));
    }
    
    // Validate the C++ standard library choice.
    CXXStdlibType Type = GetCXXStdlibType(/*Deref*/DAL);
    if (Type == ToolChain.CXXStdlibType.CST_Libcxx) {
      // Check whether the target provides libc++.
      StringRef where/*J*/= new StringRef();
      
      // Complain about targeting iOS < 5.0 in any way.
      if (isTargetIOSBased() && isIPhoneOSVersionLT(5, 0)) {
        where.$assignMove(/*STRINGREF_STR*/"iOS 5.0");
      }
      if ($noteq_StringRef(/*NO_COPY*/where, new StringRef())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_libcxx_deployment)), /*NO_COPY*/where));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return DAL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::GetDefaultCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 69,
   FQN="clang::driver::toolchains::Darwin::GetDefaultCXXStdlibType", NM="_ZNK5clang6driver10toolchains6Darwin23GetDefaultCXXStdlibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin23GetDefaultCXXStdlibTypeEv")
  //</editor-fold>
  @Override public ToolChain.CXXStdlibType GetDefaultCXXStdlibType() /*const*//* override*/ {
    // Default to use libc++ on OS X 10.9+ and iOS 7+.
    if ((isTargetMacOS() && !isMacosxVersionLT(10, 9))
       || (isTargetIOSBased() && !isIPhoneOSVersionLT(7, 0))
       || isTargetWatchOSBased()) {
      return ToolChain.CXXStdlibType.CST_Libcxx;
    }
    
    return ToolChain.CXXStdlibType.CST_Libstdcxx;
  }

  
  /// Darwin provides an ARC runtime starting in MacOS X 10.7 and iOS 5.0.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::getDefaultObjCRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 80,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 69,
   FQN="clang::driver::toolchains::Darwin::getDefaultObjCRuntime", NM="_ZNK5clang6driver10toolchains6Darwin21getDefaultObjCRuntimeEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin21getDefaultObjCRuntimeEb")
  //</editor-fold>
  @Override public ObjCRuntime getDefaultObjCRuntime(boolean isNonFragile) /*const*//* override*/ {
    if (isTargetWatchOSBased()) {
      return new ObjCRuntime(ObjCRuntime.Kind.WatchOS, TargetVersion);
    }
    if (isTargetIOSBased()) {
      return new ObjCRuntime(ObjCRuntime.Kind.iOS, TargetVersion);
    }
    if (isNonFragile) {
      return new ObjCRuntime(ObjCRuntime.Kind.MacOSX, TargetVersion);
    }
    return new ObjCRuntime(ObjCRuntime.Kind.FragileMacOSX, TargetVersion);
  }

  
  /// Darwin provides a blocks runtime starting in MacOS X 10.6 and iOS 3.2.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::hasBlocksRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 91,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 80,
   FQN="clang::driver::toolchains::Darwin::hasBlocksRuntime", NM="_ZNK5clang6driver10toolchains6Darwin16hasBlocksRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin16hasBlocksRuntimeEv")
  //</editor-fold>
  @Override public boolean hasBlocksRuntime() /*const*//* override*/ {
    if (isTargetWatchOSBased()) {
      return true;
    } else if (isTargetIOSBased()) {
      return !isIPhoneOSVersionLT(3, 2);
    } else {
      assert (isTargetMacOS()) : "unexpected darwin target";
      return !isMacosxVersionLT(10, 6);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::UseObjCMixedDispatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 536,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 513,
   FQN="clang::driver::toolchains::Darwin::UseObjCMixedDispatch", NM="_ZNK5clang6driver10toolchains6Darwin20UseObjCMixedDispatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin20UseObjCMixedDispatchEv")
  //</editor-fold>
  @Override public boolean UseObjCMixedDispatch() /*const*//* override*/ {
    // This is only used with the non-fragile ABI and non-legacy dispatch.
    
    // Mixed dispatch is used everywhere except OS X before 10.6.
    return !(isTargetMacOS() && isMacosxVersionLT(10, 6));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::GetDefaultStackProtectorLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 543,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 520,
   FQN="clang::driver::toolchains::Darwin::GetDefaultStackProtectorLevel", NM="_ZNK5clang6driver10toolchains6Darwin29GetDefaultStackProtectorLevelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin29GetDefaultStackProtectorLevelEb")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultStackProtectorLevel(boolean KernelOrKext) /*const*//* override*/ {
    // Stack protectors default to on for user code on 10.5,
    // and for everything in 10.6 and beyond
    if (isTargetIOSBased() || isTargetWatchOSBased()) {
      return 1;
    } else if (isTargetMacOS() && !isMacosxVersionLT(10, 6)) {
      return 1;
    } else if (isTargetMacOS() && !isMacosxVersionLT(10, 5) && !KernelOrKext) {
      return 1;
    }
    
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::SupportsObjCGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1252,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1205,
   FQN="clang::driver::toolchains::Darwin::SupportsObjCGC", NM="_ZNK5clang6driver10toolchains6Darwin14SupportsObjCGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin14SupportsObjCGCEv")
  //</editor-fold>
  @Override public boolean SupportsObjCGC() /*const*//* override*/ {
    return isTargetMacOS();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::CheckObjCARC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1254,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1207,
   FQN="clang::driver::toolchains::Darwin::CheckObjCARC", NM="_ZNK5clang6driver10toolchains6Darwin12CheckObjCARCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin12CheckObjCARCEv")
  //</editor-fold>
  @Override public void CheckObjCARC() /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (isTargetIOSBased() || isTargetWatchOSBased()
         || (isTargetMacOS() && !isMacosxVersionLT(10, 6))) {
        return;
      }
      $c$.clean($c$.track(getDriver().Diag(diag.err_arc_unsupported_on_toolchain)));
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::UseSjLjExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1103,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1064,
   FQN="clang::driver::toolchains::Darwin::UseSjLjExceptions", NM="_ZNK5clang6driver10toolchains6Darwin17UseSjLjExceptionsERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin17UseSjLjExceptionsERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public boolean UseSjLjExceptions(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    // Darwin uses SjLj exceptions on ARM.
    if (getTriple().getArch() != Triple.ArchType.arm
       && getTriple().getArch() != Triple.ArchType.thumb) {
      return false;
    }
    
    // Only watchOS uses the new DWARF/Compact unwinding method.
    Triple Triple/*J*/= new Triple(new Twine(ComputeLLVMTriple(Args)));
    return !Triple.isWatchABI();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::SupportsEmbeddedBitcode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1114,
   FQN="clang::driver::toolchains::Darwin::SupportsEmbeddedBitcode", NM="_ZNK5clang6driver10toolchains6Darwin23SupportsEmbeddedBitcodeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin23SupportsEmbeddedBitcodeEv")
  //</editor-fold>
  @Override public boolean SupportsEmbeddedBitcode() /*const*//* override*/ {
    assert (TargetInitialized) : "Target not initialized!";
    if (isTargetIPhoneOS() && isIPhoneOSVersionLT(6, 0)) {
      return false;
    }
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Darwin::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 1261,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 1214,
   FQN="clang::driver::toolchains::Darwin::getSupportedSanitizers", NM="_ZNK5clang6driver10toolchains6Darwin22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6Darwin22getSupportedSanitizersEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSupportedSanitizers() /*const*//* override*/ {
    /*const*/boolean IsX86_64 = getTriple().getArch() == Triple.ArchType.x86_64;
    long/*uint64_t*/ Res = super.getSupportedSanitizers();
    Res |= SanitizerKind.Address;
    if (isTargetMacOS()) {
      if (!isMacosxVersionLT(10, 9)) {
        Res |= SanitizerKind.Vptr;
      }
      Res |= SanitizerKind.SafeStack;
      if (IsX86_64) {
        Res |= SanitizerKind.Thread;
      }
    } else if (isTargetIOSSimulator() || isTargetTvOSSimulator()) {
      if (IsX86_64) {
        Res |= SanitizerKind.Thread;
      }
    }
    return Res;
  }

  
  public String toString() {
    return "" + "TargetInitialized=" + TargetInitialized // NOI18N
              + ", TargetPlatform=" + TargetPlatform // NOI18N
              + ", TargetVersion=" + TargetVersion // NOI18N
              + super.toString(); // NOI18N
  }
}
