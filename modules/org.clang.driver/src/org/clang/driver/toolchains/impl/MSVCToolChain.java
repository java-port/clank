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
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
;
import org.llvm.support.sys.*;;
import static org.clang.driver.impl.MSVCToolChainStatics.*;
import org.llvm.support.sys.Process; // to resolve ambiguity with java.lang.Process

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1027,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 957,
 FQN="clang::driver::toolchains::MSVCToolChain", NM="_ZN5clang6driver10toolchains13MSVCToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZN5clang6driver10toolchains13MSVCToolChainE")
//</editor-fold>
public class MSVCToolChain extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::MSVCToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 48,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 47,
   FQN="clang::driver::toolchains::MSVCToolChain::MSVCToolChain", NM="_ZN5clang6driver10toolchains13MSVCToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZN5clang6driver10toolchains13MSVCToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public MSVCToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args)*/ 
    //START JInit
    super(D, Triple, Args);
    //END JInit
    getProgramPaths().push_back(new std.string(getDriver().getInstalledDir()));
    if ($noteq_T_string$C(getDriver().getInstalledDir(), getDriver().Dir)) {
      getProgramPaths().push_back(getDriver().Dir);
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::TranslateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 807,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 727,
   FQN="clang::driver::toolchains::MSVCToolChain::TranslateArgs", NM="_ZNK5clang6driver10toolchains13MSVCToolChain13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc")
  //</editor-fold>
  @Override public DerivedArgList /*P*/ TranslateArgs(/*const*/ DerivedArgList /*&*/ Args, 
               /*const*/char$ptr/*char P*/ BoundArch) /*const*//* override*/ {
    DerivedArgList /*P*/ DAL = new DerivedArgList(Args.getBaseArgs());
    /*const*/ OptTable /*&*/ Opts = getDriver().getOpts();
    
    // /Oy and /Oy- only has an effect under X86-32.
    boolean SupportsForcingFramePointer = getArch() == Triple.ArchType.x86;
    
    // The -O[12xd] flag actually expands to several flags.  We must desugar the
    // flags so that options embedded can be negated.  For example, the '-O2' flag
    // enables '-Oy'.  Expanding '-O2' into its constituent flags allows us to
    // correctly handle '-O2 -Oy-' where the trailing '-Oy-' disables a single
    // aspect of '-O2'.
    //
    // Note that this expansion logic only applies to the *last* of '[12xd]'.
    
    // First step is to search for the character we'd like to expand.
    /*const*/char$ptr/*char P*/ ExpandChar = null;
    for (Arg /*P*/ A : Args) {
      if (!A.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_O.getValue()))) {
        continue;
      }
      StringRef OptStr = new StringRef(A.getValue());
      for (/*size_t*/int I = 0, E = OptStr.size(); I != E; ++I) {
        /*char*/byte OptChar = OptStr.$at(I);
        /*char*/byte PrevChar = $greater_uint(I, 0) ? OptStr.$at(I - 1) : $$0;
        if (PrevChar == $$b) {
          // OptChar does not expand; it's an argument to the previous char.
          continue;
        }
        if (OptChar == $$1 || OptChar == $$2 || OptChar == $$x || OptChar == $$d) {
          ExpandChar = $tryClone(OptStr.data().$add(I));
        }
      }
    }
    
    for (Arg /*P*/ A : Args) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT__SLASH_O.getValue()))) {
        // The -O flag actually takes an amalgam of other options.  For example,
        // '/Ogyb2' is equivalent to '/Og' '/Oy' '/Ob2'.
        TranslateOptArg(A, /*Deref*/DAL, SupportsForcingFramePointer, ExpandChar, Opts);
      } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_D.getValue()))) {
        // Translate -Dfoo#bar into -Dfoo=bar.
        TranslateDArg(A, /*Deref*/DAL, Opts);
      } else {
        DAL.append(A);
      }
    }
    
    return DAL;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 67,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 66,
   FQN="clang::driver::toolchains::MSVCToolChain::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains13MSVCToolChain28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 71,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 70,
   FQN="clang::driver::toolchains::MSVCToolChain::IsUnwindTablesDefault", NM="_ZNK5clang6driver10toolchains13MSVCToolChain21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain21IsUnwindTablesDefaultEv")
  //</editor-fold>
  @Override public boolean IsUnwindTablesDefault() /*const*//* override*/ {
    // Emit unwind tables by default on Win64. All non-x86_32 Windows platforms
    // such as ARM and PPC actually require unwind tables, but LLVM doesn't know
    // how to generate them yet.
    
    // Don't emit unwind tables by default for MachO targets.
    if (getTriple().isOSBinFormatMachO()) {
      return false;
    }
    
    return getArch() == Triple.ArchType.x86_64;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 83,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 77,
   FQN="clang::driver::toolchains::MSVCToolChain::isPICDefault", NM="_ZNK5clang6driver10toolchains13MSVCToolChain12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 87,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 81,
   FQN="clang::driver::toolchains::MSVCToolChain::isPIEDefault", NM="_ZNK5clang6driver10toolchains13MSVCToolChain12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 91,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 85,
   FQN="clang::driver::toolchains::MSVCToolChain::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains13MSVCToolChain18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 577,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 520,
   FQN="clang::driver::toolchains::MSVCToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains13MSVCToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
        return;
      }
      if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()))) {
        AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, getDriver().ResourceDir, 
            new Twine(/*KEEP_STR*/$include));
      }
      
      // Add %INCLUDE%-like directories from the -imsvc flag.
      for (/*const*/std.string/*&*/ Path : DriverArgs.getAllArgValues(new OptSpecifier(options.ID.OPT__SLASH_imsvc.getValue())))  {
        addSystemInclude(DriverArgs, CC1Args, new Twine(Path));
      }
      if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
        return;
      }
      {
        
        // Honor %INCLUDE%. It should know essential search paths with vcvarsall.bat.
        /*const*/char$ptr/*char P*/ cl_include_dir = $tryClone(getenv($("INCLUDE")));
        if ((cl_include_dir != null)) {
          SmallVector<StringRef> Dirs/*J*/= new SmallVector<StringRef>(8, new StringRef());
          new StringRef(cl_include_dir).
              split(Dirs, /*STRINGREF_STR*/";", /*MaxSplit=*/ -1, /*KEEP_BOOL*//*KeepEmpty=*/ false);
          for (StringRef Dir : Dirs)  {
            addSystemInclude(DriverArgs, CC1Args, new Twine(Dir));
          }
          if (!Dirs.empty()) {
            return;
          }
        }
      }
      
      std.string VSDir/*J*/= new std.string();
      
      // When built with access to the proper Windows APIs, try to actually find
      // the correct include paths first.
      if (getVisualStudioInstallDir(VSDir)) {
        AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, VSDir, new Twine(/*KEEP_STR*/"VC\\include"));
        if (useUniversalCRT(VSDir)) {
          std.string UniversalCRTSdkPath/*J*/= new std.string();
          std.string UCRTVersion/*J*/= new std.string();
          if (getUniversalCRTSdkDir(UniversalCRTSdkPath, UCRTVersion)) {
            AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, UniversalCRTSdkPath, 
                new Twine(/*KEEP_STR*/"Include"), new Twine(UCRTVersion), new Twine(/*KEEP_STR*/"ucrt"));
          }
        }
        
        std.string WindowsSDKDir/*J*/= new std.string();
        int$ref major = create_int$ref();
        std.string windowsSDKIncludeVersion/*J*/= new std.string();
        std.string windowsSDKLibVersion/*J*/= new std.string();
        if (getWindowsSDKDir(WindowsSDKDir, major, windowsSDKIncludeVersion, 
            windowsSDKLibVersion)) {
          if (major.$deref() >= 8) {
            // Note: windowsSDKIncludeVersion is empty for SDKs prior to v10.
            // Anyway, llvm::sys::path::append is able to manage it.
            AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, WindowsSDKDir, 
                new Twine(/*KEEP_STR*/$include), new Twine(windowsSDKIncludeVersion), 
                new Twine(/*KEEP_STR*/"shared"));
            AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, WindowsSDKDir, 
                new Twine(/*KEEP_STR*/$include), new Twine(windowsSDKIncludeVersion), 
                new Twine(/*KEEP_STR*/"um"));
            AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, WindowsSDKDir, 
                new Twine(/*KEEP_STR*/$include), new Twine(windowsSDKIncludeVersion), 
                new Twine(/*KEEP_STR*/"winrt"));
          } else {
            AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, WindowsSDKDir, 
                new Twine(/*KEEP_STR*/$include));
          }
        } else {
          addSystemInclude(DriverArgs, CC1Args, new Twine(VSDir));
        }
        return;
      }
      
      // As a fallback, select default install paths.
      // FIXME: Don't guess drives and paths like this on Windows.
      /*const*/ StringRef Paths[/*5*/] = new /*const*/ StringRef [/*5*/] {
        new StringRef("C:/Program Files/Microsoft Visual Studio 10.0/VC/include"), 
        new StringRef("C:/Program Files/Microsoft Visual Studio 9.0/VC/include"), 
        new StringRef("C:/Program Files/Microsoft Visual Studio 9.0/VC/PlatformSDK/Include"), 
        new StringRef("C:/Program Files/Microsoft Visual Studio 8/VC/include"), 
        new StringRef("C:/Program Files/Microsoft Visual Studio 8/VC/PlatformSDK/Include")
      };
      addSystemIncludes(DriverArgs, CC1Args, new ArrayRef<StringRef>(Paths));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 661,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 600,
   FQN="clang::driver::toolchains::MSVCToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains13MSVCToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    // FIXME: There should probably be logic here to find libc++ on Windows.
  }

  
  
  /// \brief Get Windows SDK installation directory.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getWindowsSDKDir">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 267,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 252,
   FQN="clang::driver::toolchains::MSVCToolChain::getWindowsSDKDir", NM="_ZNK5clang6driver10toolchains13MSVCToolChain16getWindowsSDKDirERSsRiS3_S3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain16getWindowsSDKDirERSsRiS3_S3_")
  //</editor-fold>
  public boolean getWindowsSDKDir(std.string/*&*/ Path, int$ref/*int &*/ Major, 
                  std.string/*&*/ WindowsSDKIncludeVersion, 
                  std.string/*&*/ WindowsSDKLibVersion) /*const*/ {
    std.string RegistrySDKVersion/*J*/= new std.string();
    // Try the Windows registry.
    if (!getSystemRegistryString($("SOFTWARE\\Microsoft\\Microsoft SDKs\\Windows\\$VERSION"), 
        $("InstallationFolder"), Path, /*AddrOf*/RegistrySDKVersion)) {
      return false;
    }
    if (Path.empty() || RegistrySDKVersion.empty()) {
      return false;
    }
    
    WindowsSDKIncludeVersion.clear();
    WindowsSDKLibVersion.clear();
    Major.$set(0);
    std.sscanf(RegistrySDKVersion.c_str(), $("v%d."), Major.deref$ptr());
    if (Major.$deref() <= 7) {
      return true;
    }
    if (Major.$deref() == 8) {
      // Windows SDK 8.x installs libraries in a folder whose names depend on the
      // version of the OS you're targeting.  By default choose the newest, which
      // usually corresponds to the version of the OS you've installed the SDK on.
      /*const*/char$ptr/*char P*/ Tests[/*3*/] = (new /*const*/char$ptr/*char P*/ [/*3*/] {$("winv6.3"), $("win8"), $("win7")});
      for (/*const*/char$ptr/*char P*/ Test : Tests) {
        SmallString/*128*/ TestPath/*J*/= new SmallString/*128*/(new StringRef(Path), 128);
        path.append(TestPath, new Twine(/*KEEP_STR*/"Lib"), new Twine(Test));
        if (fs.exists(new Twine(TestPath.c_str()))) {
          WindowsSDKLibVersion.$assign(Test);
          break;
        }
      }
      return !WindowsSDKLibVersion.empty();
    }
    if (Major.$deref() == 10) {
      if (!getWindows10SDKVersion(Path, WindowsSDKIncludeVersion)) {
        return false;
      }
      WindowsSDKLibVersion.$assign(WindowsSDKIncludeVersion);
      return true;
    }
    // Unsupported SDK version
    return false;
  }

  
  // Gets the library path required to link against the Windows SDK.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getWindowsSDKLibraryPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 311,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 296,
   FQN="clang::driver::toolchains::MSVCToolChain::getWindowsSDKLibraryPath", NM="_ZNK5clang6driver10toolchains13MSVCToolChain24getWindowsSDKLibraryPathERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain24getWindowsSDKLibraryPathERSs")
  //</editor-fold>
  public boolean getWindowsSDKLibraryPath(std.string/*&*/ _path) /*const*/ {
    std.string sdkPath/*J*/= new std.string();
    int$ref sdkMajor = create_int$ref(0);
    std.string windowsSDKIncludeVersion/*J*/= new std.string();
    std.string windowsSDKLibVersion/*J*/= new std.string();
    
    _path.clear();
    if (!getWindowsSDKDir(sdkPath, sdkMajor, windowsSDKIncludeVersion, 
        windowsSDKLibVersion)) {
      return false;
    }
    
    SmallString/*128*/ libPath/*J*/= new SmallString/*128*/(new StringRef(sdkPath), 128);
    path.append(libPath, new Twine(/*KEEP_STR*/"Lib"));
    if (sdkMajor.$deref() <= 7) {
      switch (getArch()) {
       case x86:
        // In Windows SDK 7.x, x86 libraries are directly in the Lib folder.
        break;
       case x86_64:
        path.append(libPath, new Twine(/*KEEP_STR*/"x64"));
        break;
       case arm:
        // It is not necessary to link against Windows SDK 7.x when targeting ARM.
        return false;
       default:
        return false;
      }
    } else {
      /*const*/ StringRef archName = getWindowsSDKArch(getArch());
      if (archName.empty()) {
        return false;
      }
      path.append(libPath, new Twine(windowsSDKLibVersion), new Twine(/*KEEP_STR*/"um"), new Twine(archName));
    }
    
    _path.$assignMove(libPath.str().$string());
    return true;
  }

  /// \brief Check if Universal CRT should be used if available
  
  // Check if the Include path of a specified version of Visual Studio contains
  // specific header files. If not, they are probably shipped with Universal CRT.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::useUniversalCRT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 351,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 336,
   FQN="clang::driver::toolchains::MSVCToolChain::useUniversalCRT", NM="_ZNK5clang6driver10toolchains13MSVCToolChain15useUniversalCRTERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain15useUniversalCRTERSs")
  //</editor-fold>
  public boolean useUniversalCRT(std.string/*&*/ VisualStudioDir) /*const*/ {
    SmallString/*128*/ TestPath/*J*/= new SmallString/*128*/(new StringRef(VisualStudioDir), 128);
    path.append(TestPath, new Twine(/*KEEP_STR*/"VC\\include\\stdlib.h"));
    
    return !fs.exists(new Twine(TestPath));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getUniversalCRTSdkDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 359,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 344,
   FQN="clang::driver::toolchains::MSVCToolChain::getUniversalCRTSdkDir", NM="_ZNK5clang6driver10toolchains13MSVCToolChain21getUniversalCRTSdkDirERSsS3_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain21getUniversalCRTSdkDirERSsS3_")
  //</editor-fold>
  public boolean getUniversalCRTSdkDir(std.string/*&*/ Path, 
                       std.string/*&*/ UCRTVersion) /*const*/ {
    // vcvarsqueryregistry.bat for Visual Studio 2015 queries the registry
    // for the specific key "KitsRoot10". So do we.
    if (!getSystemRegistryString($("SOFTWARE\\Microsoft\\Windows Kits\\Installed Roots"), $("KitsRoot10"), 
        Path, (std.string/*P*/ )null)) {
      return false;
    }
    
    return getWindows10SDKVersion(Path, UCRTVersion);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getUniversalCRTLibraryPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 371,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 356,
   FQN="clang::driver::toolchains::MSVCToolChain::getUniversalCRTLibraryPath", NM="_ZNK5clang6driver10toolchains13MSVCToolChain26getUniversalCRTLibraryPathERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain26getUniversalCRTLibraryPathERSs")
  //</editor-fold>
  public boolean getUniversalCRTLibraryPath(std.string/*&*/ Path) /*const*/ {
    std.string UniversalCRTSdkPath/*J*/= new std.string();
    std.string UCRTVersion/*J*/= new std.string();
    
    Path.clear();
    if (!getUniversalCRTSdkDir(UniversalCRTSdkPath, UCRTVersion)) {
      return false;
    }
    
    StringRef ArchName = getWindowsSDKArch(getArch());
    if (ArchName.empty()) {
      return false;
    }
    
    SmallString/*128*/ LibPath/*J*/= new SmallString/*128*/(new StringRef(UniversalCRTSdkPath), 128);
    path.append(LibPath, new Twine(/*KEEP_STR*/"Lib"), new Twine(UCRTVersion), new Twine(/*KEEP_STR*/"ucrt"), new Twine(ArchName));
    
    Path.$assignMove(LibPath.str().$string());
    return true;
  }

  
  // Get Visual Studio installation directory.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getVisualStudioInstallDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 513,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 456,
   FQN="clang::driver::toolchains::MSVCToolChain::getVisualStudioInstallDir", NM="_ZNK5clang6driver10toolchains13MSVCToolChain25getVisualStudioInstallDirERSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain25getVisualStudioInstallDirERSs")
  //</editor-fold>
  public boolean getVisualStudioInstallDir(std.string/*&*/ path) /*const*/ {
    // First check the environment variables that vsvars32.bat sets.
    /*const*/char$ptr/*char P*/ vcinstalldir = $tryClone(getenv($("VCINSTALLDIR")));
    if ((vcinstalldir != null)) {
      path.$assign(vcinstalldir);
      path.$assignMove(path.substr(0, path.find(/*KEEP_STR*/"\\VC")));
      return true;
    }
    
    std.string vsIDEInstallDir/*J*/= new std.string();
    std.string vsExpressIDEInstallDir/*J*/= new std.string();
    // Then try the windows registry.
    boolean hasVCDir = getSystemRegistryString($("SOFTWARE\\Microsoft\\VisualStudio\\$VERSION"), 
        $("InstallDir"), vsIDEInstallDir, (std.string/*P*/ )null);
    if (hasVCDir && !vsIDEInstallDir.empty()) {
      path.$assignMove(vsIDEInstallDir.substr(0, vsIDEInstallDir.find(/*KEEP_STR*/"\\Common7\\IDE")));
      return true;
    }
    
    boolean hasVCExpressDir = getSystemRegistryString($("SOFTWARE\\Microsoft\\VCExpress\\$VERSION"), 
        $("InstallDir"), vsExpressIDEInstallDir, (std.string/*P*/ )null);
    if (hasVCExpressDir && !vsExpressIDEInstallDir.empty()) {
      path.$assignMove(vsExpressIDEInstallDir.substr(0, vsIDEInstallDir.find(/*KEEP_STR*/"\\Common7\\IDE")));
      return true;
    }
    
    // Try the environment.
    /*const*/char$ptr/*char P*/ vs120comntools = $tryClone(getenv($("VS120COMNTOOLS")));
    /*const*/char$ptr/*char P*/ vs100comntools = $tryClone(getenv($("VS100COMNTOOLS")));
    /*const*/char$ptr/*char P*/ vs90comntools = $tryClone(getenv($("VS90COMNTOOLS")));
    /*const*/char$ptr/*char P*/ vs80comntools = $tryClone(getenv($("VS80COMNTOOLS")));
    
    /*const*/char$ptr/*char P*/ vscomntools = null;
    
    // Find any version we can
    if ((vs120comntools != null)) {
      vscomntools = $tryClone(vs120comntools);
    } else if ((vs100comntools != null)) {
      vscomntools = $tryClone(vs100comntools);
    } else if ((vs90comntools != null)) {
      vscomntools = $tryClone(vs90comntools);
    } else if ((vs80comntools != null)) {
      vscomntools = $tryClone(vs80comntools);
    }
    if ((vscomntools != null) && (vscomntools.$star() != 0)) {
      /*const*/char$ptr/*char P*/ p = $tryClone(strstr(vscomntools, $("\\Common7\\Tools")));
      path.$assignMove((p != null) ? new std.string(vscomntools, p) : new std.string(vscomntools));
      return true;
    }
    return false;
  }

  
  // Get the location to use for Visual Studio binaries.  The location priority
  // is: %VCINSTALLDIR% > %PATH% > newest copy of Visual Studio installed on
  // system (as reported by the registry).
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getVisualStudioBinariesFolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 393,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 378,
   FQN="clang::driver::toolchains::MSVCToolChain::getVisualStudioBinariesFolder", NM="_ZNK5clang6driver10toolchains13MSVCToolChain29getVisualStudioBinariesFolderEPKcRSs",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain29getVisualStudioBinariesFolderEPKcRSs")
  //</editor-fold>
  public boolean getVisualStudioBinariesFolder(/*const*/char$ptr/*char P*/ clangProgramPath, 
                               std.string/*&*/ _path) /*const*/ {
    _path.clear();
    
    SmallString/*128*/ BinDir/*J*/= new SmallString/*128*/(128);
    
    // First check the environment variables that vsvars32.bat sets.
    Optional<std.string> VcInstallDir = Process.GetEnv(new StringRef(/*KEEP_STR*/"VCINSTALLDIR"));
    if (VcInstallDir.hasValue()) {
      BinDir.$assign(new StringRef(VcInstallDir.getValue()));
      path.append(BinDir, new Twine(/*KEEP_STR*/"bin"));
    } else {
      // Next walk the PATH, trying to find a cl.exe in the path.  If we find one,
      // use that.  However, make sure it's not clang's cl.exe.
      Optional<std.string> OptPath = Process.GetEnv(new StringRef(/*KEEP_STR*/"PATH"));
      if (OptPath.hasValue()) {
        /*const*//*char*/byte EnvPathSeparatorStr[/*2*/] = new$char(2, sys.EnvPathSeparator, $$TERM);
        SmallVector<StringRef> PathSegments/*J*/= new SmallVector<StringRef>(8, new StringRef());
        llvm.SplitString(new StringRef(OptPath.getValue()), PathSegments, new StringRef(EnvPathSeparatorStr));
        
        for (StringRef PathSegment : PathSegments) {
          if (PathSegment.empty()) {
            continue;
          }
          
          SmallString/*128*/ FilePath/*J*/= new SmallString/*128*/(new StringRef(PathSegment), 128);
          path.append(FilePath, new Twine(/*KEEP_STR*/"cl.exe"));
          // Checking if cl.exe exists is a small optimization over calling
          // can_execute, which really only checks for existence but will also do
          // extra checks for cl.exe.exe.  These add up when walking a long path.
          if (fs.exists(new Twine(FilePath.c_str()))
             && !fs.equivalent(new Twine(FilePath.c_str()), new Twine(clangProgramPath))) {
            // If we found it on the PATH, use it exactly as is with no
            // modifications.
            _path.$assignMove(PathSegment.$string());
            return true;
          }
        }
      }
      
      std.string installDir/*J*/= new std.string();
      // With no VCINSTALLDIR and nothing on the PATH, if we can't find it in the
      // registry then we have no choice but to fail.
      if (!getVisualStudioInstallDir(installDir)) {
        return false;
      }
      
      // Regardless of what binary we're ultimately trying to find, we make sure
      // that this is a Visual Studio directory by checking for cl.exe.  We use
      // cl.exe instead of other binaries like link.exe because programs such as
      // GnuWin32 also have a utility called link.exe, so cl.exe is the least
      // ambiguous.
      BinDir.$assign(new StringRef(installDir));
      path.append(BinDir, new Twine(/*KEEP_STR*/"VC"), new Twine(/*KEEP_STR*/"bin"));
      SmallString/*128*/ ClPath/*J*/= new SmallString/*128*/(BinDir);
      path.append(ClPath, new Twine(/*KEEP_STR*/"cl.exe"));
      if (!fs.can_execute(new Twine(ClPath.c_str()))) {
        return false;
      }
    }
    if (BinDir.empty()) {
      return false;
    }
    switch (getArch()) {
     case x86:
      break;
     case x86_64:
      path.append(BinDir, new Twine(/*KEEP_STR*/"amd64"));
      break;
     case arm:
      path.append(BinDir, new Twine(/*KEEP_STR*/"arm"));
      break;
     default:
      // Whatever this is, Visual Studio doesn't have a toolchain for it.
      return false;
    }
    _path.$assignMove(BinDir.str().$string());
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getMSVCVersionFromExe">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 473,
   FQN="clang::driver::toolchains::MSVCToolChain::getMSVCVersionFromExe", NM="_ZNK5clang6driver10toolchains13MSVCToolChain21getMSVCVersionFromExeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain21getMSVCVersionFromExeEv")
  //</editor-fold>
  @Override public VersionTuple getMSVCVersionFromExe() /*const*//* override*/ {
    VersionTuple Version/*J*/= new VersionTuple();
    return Version;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::ComputeEffectiveClangTriple">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 666,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 605,
   FQN="clang::driver::toolchains::MSVCToolChain::ComputeEffectiveClangTriple", NM="_ZNK5clang6driver10toolchains13MSVCToolChain27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE")
  //</editor-fold>
  @Override public std.string ComputeEffectiveClangTriple(/*const*/ ArgList /*&*/ Args, 
                             types.ID InputType) /*const*//* override*/ {
    std.string TripleStr = super.ComputeEffectiveClangTriple(Args, InputType);
    Triple _Triple/*J*/= new Triple(new Twine(TripleStr));
    VersionTuple MSVT = VisualstudioStatics.getMSVCVersion(/*D=*/ (/*const*/ Driver /*P*/ )null, /*Deref*/this, _Triple, Args, 
        /*IsWindowsMSVC=*/ true);
    if (MSVT.empty()) {
      return TripleStr;
    }
    
    MSVT.$assignMove(new VersionTuple(MSVT.getMajor(), MSVT.getMinor().getValueOr(0), 
            MSVT.getSubminor().getValueOr(0)));
    if (_Triple.getEnvironment() == Triple.EnvironmentType.MSVC) {
      StringRef ObjFmt = new StringRef(JD$Move.INSTANCE, _Triple.getEnvironmentName().split($$MINUS).second);
      if (ObjFmt.empty()) {
        _Triple.setEnvironmentName(new StringRef(($add_Twine(new Twine(/*KEEP_STR*/"msvc"), new Twine(MSVT.getAsString()))).str()));
      } else {
        _Triple.setEnvironmentName(new StringRef(($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"msvc"), new Twine(MSVT.getAsString())), new Twine(JD$Char.INSTANCE, $$MINUS)), new Twine(ObjFmt))).str()));
      }
    }
    return new std.string(_Triple.getTriple());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 692,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 631,
   FQN="clang::driver::toolchains::MSVCToolChain::getSupportedSanitizers", NM="_ZNK5clang6driver10toolchains13MSVCToolChain22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain22getSupportedSanitizersEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSupportedSanitizers() /*const*//* override*/ {
    long/*uint64_t*/ Res = super.getSupportedSanitizers();
    Res |= SanitizerKind.Address;
    return Res;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::AddSystemIncludeWithSubfolder">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 568,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 511,
   FQN="clang::driver::toolchains::MSVCToolChain::AddSystemIncludeWithSubfolder", NM="_ZNK5clang6driver10toolchains13MSVCToolChain29AddSystemIncludeWithSubfolderERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKSsRKNS3_5TwineESH_SH_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain29AddSystemIncludeWithSubfolderERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEERKSsRKNS3_5TwineESH_SH_")
  //</editor-fold>
  protected void AddSystemIncludeWithSubfolder(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args, 
                               /*const*/std.string/*&*/ folder, /*const*/ Twine /*&*/ subfolder1) /*const*/ {
    AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, 
                               folder, subfolder1, new Twine(/*KEEP_STR*/$EMPTY), 
                               new Twine(/*KEEP_STR*/$EMPTY));
  }
  protected void AddSystemIncludeWithSubfolder(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args, 
                               /*const*/std.string/*&*/ folder, /*const*/ Twine /*&*/ subfolder1, /*const*/ Twine /*&*/ subfolder2/*= ""*/) /*const*/ {
    AddSystemIncludeWithSubfolder(DriverArgs, CC1Args, 
                               folder, subfolder1, subfolder2, 
                               new Twine(/*KEEP_STR*/$EMPTY));
  }
  protected void AddSystemIncludeWithSubfolder(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args, 
                               /*const*/std.string/*&*/ folder, /*const*/ Twine /*&*/ subfolder1, /*const*/ Twine /*&*/ subfolder2/*= ""*/, 
                               /*const*/ Twine /*&*/ subfolder3/*= ""*/) /*const*/ {
    SmallString/*128*/ _path/*J*/= new SmallString/*128*/(new StringRef(folder), 128);
    path.append(_path, subfolder1, subfolder2, subfolder3);
    addSystemInclude(DriverArgs, CC1Args, new Twine(_path));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 56,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 55,
   FQN="clang::driver::toolchains::MSVCToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains13MSVCToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new VisualstudioStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", line = 60,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp", old_line = 59,
   FQN="clang::driver::toolchains::MSVCToolChain::buildAssembler", NM="_ZNK5clang6driver10toolchains13MSVCToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZNK5clang6driver10toolchains13MSVCToolChain14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (getTriple().isOSBinFormatMachO()) {
        return new DarwinStatics.Assembler(/*Deref*/this);
      }
      $c$.clean($c$.track(getDriver().Diag(diag.err_no_external_assembler)));
      return null;
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MSVCToolChain::~MSVCToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1027,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 957,
   FQN="clang::driver::toolchains::MSVCToolChain::~MSVCToolChain", NM="_ZN5clang6driver10toolchains13MSVCToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/MSVCToolChain.cpp -nm=_ZN5clang6driver10toolchains13MSVCToolChainD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
