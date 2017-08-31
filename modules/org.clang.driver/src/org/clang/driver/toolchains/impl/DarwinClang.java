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

import org.clank.support.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.target.target.DebuggerKind;


/// DarwinClang - The Darwin toolchain used by Clang.
//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 568,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 543,
 FQN="clang::driver::toolchains::DarwinClang", NM="_ZN5clang6driver10toolchains11DarwinClangE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11DarwinClangE")
//</editor-fold>
public class DarwinClang extends /*public*/ Darwin implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::DarwinClang">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 237,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 226,
   FQN="clang::driver::toolchains::DarwinClang::DarwinClang", NM="_ZN5clang6driver10toolchains11DarwinClangC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11DarwinClangC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public DarwinClang(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Darwin(D, Triple, Args)*/ 
    //START JInit
    super(D, Triple, Args);
    //END JInit
  }

  
  /// @name Apple ToolChain Implementation
  /// {
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::AddLinkRuntimeLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 403,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 382,
   FQN="clang::driver::toolchains::DarwinClang::AddLinkRuntimeLibArgs", NM="_ZNK5clang6driver10toolchains11DarwinClang21AddLinkRuntimeLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang21AddLinkRuntimeLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddLinkRuntimeLibArgs(/*const*/ ArgList /*&*/ Args, 
                       ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // Darwin only supports the compiler-rt based runtime libraries.
    switch (GetRuntimeLibType(Args)) {
     case RLT_CompilerRT:
      break;
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.err_drv_unsupported_rtlib_for_platform)), 
                  Args.getLastArg(new OptSpecifier(options.ID.OPT_rtlib_EQ.getValue())).getValue()), /*KEEP_STR*/"darwin"));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Darwin doesn't support real static executables, don't link any runtime
    // libraries with -static.
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_fapple_kext.getValue()))
       || Args.hasArg(new OptSpecifier(options.ID.OPT_mkernel.getValue()))) {
      return;
    }
    {
      
      // Reject -static-libgcc for now, we can deal with this when and if someone
      // cares. This is useful in situations where someone wants to statically link
      // something like libstdc++, and needs its runtime support routines.
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_static_libgcc.getValue()));
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_unsupported_opt)), new StringRef(A.getAsString(Args))));
          return;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    /*const*/ SanitizerArgs /*&*/ Sanitize = getSanitizerArgs();
    if (Sanitize.needsAsanRt()) {
      AddLinkSanitizerLibArgs(Args, CmdArgs, new StringRef(/*KEEP_STR*/"asan"));
    }
    if (Sanitize.needsUbsanRt()) {
      AddLinkSanitizerLibArgs(Args, CmdArgs, new StringRef(/*KEEP_STR*/"ubsan"));
    }
    if (Sanitize.needsTsanRt()) {
      AddLinkSanitizerLibArgs(Args, CmdArgs, new StringRef(/*KEEP_STR*/"tsan"));
    }
    if (Sanitize.needsStatsRt()) {
      StringRef OS = new StringRef(isTargetMacOS() ? $("osx") : $("iossim"));
      AddLinkRuntimeLib(Args, CmdArgs, 
          new StringRef(($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"libclang_rt.stats_client_"), new Twine(OS)), new Twine(/*KEEP_STR*/".a"))).str()), 
          /*AlwaysLink=*/ true);
      AddLinkSanitizerLibArgs(Args, CmdArgs, new StringRef(/*KEEP_STR*/"stats"));
    }
    if (Sanitize.needsEsanRt()) {
      AddLinkSanitizerLibArgs(Args, CmdArgs, new StringRef(/*KEEP_STR*/"esan"));
    }
    
    // Otherwise link libSystem, then the dynamic runtime library, and finally any
    // target specific static runtime library.
    CmdArgs.push_back($("-lSystem"));
    
    // Select the dynamic runtime library and the target specific static library.
    if (isTargetWatchOSBased()) {
      // We currently always need a static runtime library for watchOS.
      AddLinkRuntimeLib(Args, CmdArgs, new StringRef(/*KEEP_STR*/"libclang_rt.watchos.a"));
    } else if (isTargetTvOSBased()) {
      // We currently always need a static runtime library for tvOS.
      AddLinkRuntimeLib(Args, CmdArgs, new StringRef(/*KEEP_STR*/"libclang_rt.tvos.a"));
    } else if (isTargetIOSBased()) {
      // If we are compiling as iOS / simulator, don't attempt to link libgcc_s.1,
      // it never went into the SDK.
      // Linking against libgcc_s.1 isn't needed for iOS 5.0+
      if (isIPhoneOSVersionLT(5, 0) && !isTargetIOSSimulator()
         && getTriple().getArch() != Triple.ArchType.aarch64) {
        CmdArgs.push_back($("-lgcc_s.1"));
      }
      
      // We currently always need a static runtime library for iOS.
      AddLinkRuntimeLib(Args, CmdArgs, new StringRef(/*KEEP_STR*/"libclang_rt.ios.a"));
    } else {
      assert (isTargetMacOS()) : "unexpected non MacOS platform";
      // The dynamic runtime library was merged with libSystem for 10.6 and
      // beyond; only 10.4 and 10.5 need an additional runtime library.
      if (isMacosxVersionLT(10, 5)) {
        CmdArgs.push_back($("-lgcc_s.10.4"));
      } else if (isMacosxVersionLT(10, 6)) {
        CmdArgs.push_back($("-lgcc_s.10.5"));
      }
      
      // Originally for OS X, we thought we would only need a static runtime
      // library when targeting 10.4, to provide versions of the static functions
      // which were omitted from 10.4.dylib. This led to the creation of the 10.4
      // builtins library.
      //
      // Unfortunately, that turned out to not be true, because Darwin system
      // headers can still use eprintf on i386, and it is not exported from
      // libSystem. Therefore, we still must provide a runtime library just for
      // the tiny tiny handful of projects that *might* use that symbol.
      //
      // Then over time, we figured out it was useful to add more things to the
      // runtime so we created libclang_rt.osx.a to provide new functions when
      // deploying to old OS builds, and for a long time we had both eprintf and
      // osx builtin libraries. Which just seems excessive. So with PR 28855, we
      // are removing the eprintf library and expecting eprintf to be provided by
      // the OS X builtins library.
      if (isMacosxVersionLT(10, 5)) {
        AddLinkRuntimeLib(Args, CmdArgs, new StringRef(/*KEEP_STR*/"libclang_rt.10.4.a"));
      } else {
        AddLinkRuntimeLib(Args, CmdArgs, new StringRef(/*KEEP_STR*/"libclang_rt.osx.a"));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 734,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 691,
   FQN="clang::driver::toolchains::DarwinClang::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver10toolchains11DarwinClang19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ Args, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    CXXStdlibType Type = GetCXXStdlibType(Args);
    switch (Type) {
     case CST_Libcxx:
      CmdArgs.push_back($("-lc++"));
      break;
     case CST_Libstdcxx:
      {
        // Unfortunately, -lstdc++ doesn't always exist in the standard search path;
        // it was previously found in the gcc lib dir. However, for all the Darwin
        // platforms we care about it was -lstdc++.6, so we search for that
        // explicitly if we can't see an obvious -lstdc++ candidate.
        
        // Check in the sysroot first.
        /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()));
        if ((A != null)) {
          SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(A.getValue()), 128);
          path.append(P, new Twine(/*KEEP_STR*/"usr"), new Twine(/*KEEP_STR*/"lib"), new Twine(/*KEEP_STR*/"libstdc++.dylib"));
          if (!getVFS().exists(new Twine(P))) {
            path.remove_filename(P);
            path.append(P, new Twine(/*KEEP_STR*/"libstdc++.6.dylib"));
            if (getVFS().exists(new Twine(P))) {
              CmdArgs.push_back(Args.MakeArgString(new Twine(P)));
              return;
            }
          }
        }
      }
      
      // Otherwise, look in the root.
      // FIXME: This should be removed someday when we don't have to care about
      // 10.6 and earlier, where /usr/lib/libstdc++.dylib does not exist.
      if (!getVFS().exists(new Twine(/*KEEP_STR*/"/usr/lib/libstdc++.dylib"))
         && getVFS().exists(new Twine(/*KEEP_STR*/"/usr/lib/libstdc++.6.dylib"))) {
        CmdArgs.push_back($("/usr/lib/libstdc++.6.dylib"));
        return;
      }
      
      // Otherwise, let the linker search.
      CmdArgs.push_back($("-lstdc++"));
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::AddCCKextLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 779,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 736,
   FQN="clang::driver::toolchains::DarwinClang::AddCCKextLibArgs", NM="_ZNK5clang6driver10toolchains11DarwinClang16AddCCKextLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang16AddCCKextLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCCKextLibArgs(/*const*/ ArgList /*&*/ Args, 
                  ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // For Darwin platforms, use the compiler-rt-based support library
    // instead of the gcc-provided one (which is also incidentally
    // only present in the gcc lib dir, which makes it hard to find).
    SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(getDriver().ResourceDir), 128);
    path.append(P, new Twine(/*KEEP_STR*/"lib"), new Twine(/*KEEP_STR*/"darwin"));
    
    // Use the newer cc_kext for iOS ARM after 6.0.
    if (isTargetWatchOS()) {
      path.append(P, new Twine(/*KEEP_STR*/"libclang_rt.cc_kext_watchos.a"));
    } else if (isTargetTvOS()) {
      path.append(P, new Twine(/*KEEP_STR*/"libclang_rt.cc_kext_tvos.a"));
    } else if (isTargetIPhoneOS()) {
      path.append(P, new Twine(/*KEEP_STR*/"libclang_rt.cc_kext_ios.a"));
    } else {
      path.append(P, new Twine(/*KEEP_STR*/"libclang_rt.cc_kext.a"));
    }
    
    // For now, allow missing resource libraries to support developers who may
    // not have compiler-rt checked out or integrated into their build.
    if (getVFS().exists(new Twine(P))) {
      CmdArgs.push_back(Args.MakeArgString(new Twine(P)));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::addClangWarningOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 241,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 230,
   FQN="clang::driver::toolchains::DarwinClang::addClangWarningOptions", NM="_ZNK5clang6driver10toolchains11DarwinClang22addClangWarningOptionsERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang22addClangWarningOptionsERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addClangWarningOptions(ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    // For modern targets, promote certain warnings to errors.
    if (isTargetWatchOSBased() || getTriple().isArch64Bit()) {
      // Always enable -Wdeprecated-objc-isa-usage and promote it
      // to an error.
      CC1Args.push_back($("-Wdeprecated-objc-isa-usage"));
      CC1Args.push_back($("-Werror=deprecated-objc-isa-usage"));
      
      // For iOS and watchOS, also error about implicit function declarations,
      // as that can impact calling conventions.
      if (!isTargetMacOS()) {
        CC1Args.push_back($("-Werror=implicit-function-declaration"));
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::AddLinkARCArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION/*isObjCAutoRefCount abmiguoty*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 262,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 251,
   FQN="clang::driver::toolchains::DarwinClang::AddLinkARCArgs", NM="_ZNK5clang6driver10toolchains11DarwinClang14AddLinkARCArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang14AddLinkARCArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddLinkARCArgs(/*const*/ ArgList /*&*/ Args, 
                ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // Avoid linking compatibility stubs on i386 mac.
    if (isTargetMacOS() && getArch() == Triple.ArchType.x86) {
      return;
    }
    
    ObjCRuntime runtime = getDefaultObjCRuntime(/*nonfragile*/ true);
    if ((runtime.hasNativeARC() || !ToolChainsStatics.isObjCAutoRefCount(Args))
       && runtime.hasSubscripting()) {
      return;
    }
    
    CmdArgs.push_back($("-force_load"));
    SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(getDriver().ClangExecutable), 128);
    path.remove_filename(P); // 'clang'
    path.remove_filename(P); // 'bin'
    path.append(P, new Twine(/*KEEP_STR*/"lib"), new Twine(/*KEEP_STR*/"arc"), new Twine(/*KEEP_STR*/"libarclite_"));
    // Mash in the platform.
    if (isTargetWatchOSSimulator()) {
      P.$addassign(/*STRINGREF_STR*/"watchsimulator");
    } else if (isTargetWatchOS()) {
      P.$addassign(/*STRINGREF_STR*/"watchos");
    } else if (isTargetTvOSSimulator()) {
      P.$addassign(/*STRINGREF_STR*/"appletvsimulator");
    } else if (isTargetTvOS()) {
      P.$addassign(/*STRINGREF_STR*/"appletvos");
    } else if (isTargetIOSSimulator()) {
      P.$addassign(/*STRINGREF_STR*/"iphonesimulator");
    } else if (isTargetIPhoneOS()) {
      P.$addassign(/*STRINGREF_STR*/"iphoneos");
    } else {
      P.$addassign(/*STRINGREF_STR*/"macosx");
    }
    P.$addassign(/*STRINGREF_STR*/".a");
    
    CmdArgs.push_back(Args.MakeArgString(new Twine(P)));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::GetDefaultDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 590,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 565,
   FQN="clang::driver::toolchains::DarwinClang::GetDefaultDwarfVersion", NM="_ZNK5clang6driver10toolchains11DarwinClang22GetDefaultDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang22GetDefaultDwarfVersionEv")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultDwarfVersion() /*const*//* override*/ {
    return 2;
  }

  // Until dtrace (via CTF) and LLDB can deal with distributed debug info,
  // Darwin defaults to standalone/full debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::GetDefaultStandaloneDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 593,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 568,
   FQN="clang::driver::toolchains::DarwinClang::GetDefaultStandaloneDebug", NM="_ZNK5clang6driver10toolchains11DarwinClang25GetDefaultStandaloneDebugEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang25GetDefaultStandaloneDebugEv")
  //</editor-fold>
  @Override public boolean GetDefaultStandaloneDebug() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::getDefaultDebuggerTuning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 594,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 569,
   FQN="clang::driver::toolchains::DarwinClang::getDefaultDebuggerTuning", NM="_ZNK5clang6driver10toolchains11DarwinClang24getDefaultDebuggerTuningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang24getDefaultDebuggerTuningEv")
  //</editor-fold>
  @Override public DebuggerKind getDefaultDebuggerTuning() /*const*//* override*/ {
    return DebuggerKind.LLDB;
  }


  /// }
  /*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::AddLinkSanitizerLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 392,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 358,
   FQN="clang::driver::toolchains::DarwinClang::AddLinkSanitizerLibArgs", NM="_ZNK5clang6driver10toolchains11DarwinClang23AddLinkSanitizerLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEENS3_9StringRefE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11DarwinClang23AddLinkSanitizerLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEENS3_9StringRefE")
  //</editor-fold>
  private void AddLinkSanitizerLibArgs(/*const*/ ArgList /*&*/ Args, 
                         ArgStringList/*&*/ CmdArgs, 
                         StringRef Sanitizer) /*const*/ {
    AddLinkRuntimeLib(Args, CmdArgs, 
        new StringRef(($add_Twine($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"libclang_rt."), new Twine(Sanitizer)), new Twine(/*KEEP_STR*/$UNDERSCORE)), 
                    new Twine(getOSLibraryNameSuffix())), new Twine(/*KEEP_STR*/"_dynamic.dylib"))).str()), 
        /*AlwaysLink*/ true, /*IsEmbedded*/ false, 
        /*AddRPath*/ true);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DarwinClang::~DarwinClang">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 568,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 543,
   FQN="clang::driver::toolchains::DarwinClang::~DarwinClang", NM="_ZN5clang6driver10toolchains11DarwinClangD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11DarwinClangD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
