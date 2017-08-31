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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
import org.llvm.support.sys.Process; // to resolve ambiguity with java.lang.Process

//<editor-fold defaultstate="collapsed" desc="static type VisualstudioStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio14getMSVCVersionEPKNS0_6DriverERKNS0_9ToolChainERKN4llvm6TripleERKNS9_3opt7ArgListEb;_ZN5clang6driver5tools12visualstudio6LinkerE;_ZN5clang6driver5tools12visualstudio8CompilerE; -static-type=VisualstudioStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class VisualstudioStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::getMSVCVersion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 3475,
 FQN="clang::driver::tools::visualstudio::getMSVCVersion", NM="_ZN5clang6driver5tools12visualstudio14getMSVCVersionEPKNS0_6DriverERKNS0_9ToolChainERKN4llvm6TripleERKNS9_3opt7ArgListEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio14getMSVCVersionEPKNS0_6DriverERKNS0_9ToolChainERKN4llvm6TripleERKNS9_3opt7ArgListEb")
//</editor-fold>
public static VersionTuple getMSVCVersion(/*const*/ Driver /*P*/ D, /*const*/ ToolChain /*&*/ TC, 
              /*const*/ Triple /*&*/ Triple, 
              /*const*/ ArgList /*&*/ Args, 
              boolean IsWindowsMSVC) {
  if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fms_extensions.getValue()), new OptSpecifier(options.ID.OPT_fno_ms_extensions.getValue()), 
      IsWindowsMSVC)
     || Args.hasArg(new OptSpecifier(options.ID.OPT_fmsc_version.getValue()))
     || Args.hasArg(new OptSpecifier(options.ID.OPT_fms_compatibility_version.getValue()))) {
    /*const*/ Arg /*P*/ MSCVersion = Args.getLastArg(new OptSpecifier(options.ID.OPT_fmsc_version.getValue()));
    /*const*/ Arg /*P*/ MSCompatibilityVersion = Args.getLastArg(new OptSpecifier(options.ID.OPT_fms_compatibility_version.getValue()));
    if ((MSCVersion != null) && (MSCompatibilityVersion != null)) {
      if ((D != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_argument_not_allowed_with)), 
                  new StringRef(MSCVersion.getAsString(Args))), 
              new StringRef(MSCompatibilityVersion.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
      return new VersionTuple();
    }
    if ((MSCompatibilityVersion != null)) {
      VersionTuple MSVT/*J*/= new VersionTuple();
      if (MSVT.tryParse(/*STRINGREF_STR*/MSCompatibilityVersion.getValue()) && (D != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), 
                  new StringRef(MSCompatibilityVersion.getAsString(Args))), 
              MSCompatibilityVersion.getValue()));
        } finally {
          $c$.$destroy();
        }
      }
      return MSVT;
    }
    if ((MSCVersion != null)) {
      /*uint*/uint$ref Version = create_uint$ref(0);
      if (new StringRef(MSCVersion.getValue()).getAsInteger$NotSigned(10, Version) && (D != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_invalid_value)), new StringRef(MSCVersion.getAsString(Args))), 
              MSCVersion.getValue()));
        } finally {
          $c$.$destroy();
        }
      }
      return getMSCompatibilityVersion(Version.$deref());
    }
    
    /*uint*/uint$ref Major = create_uint$ref(), Minor = create_uint$ref(), Micro = create_uint$ref();
    Triple.getEnvironmentVersion(Major, Minor, Micro);
    if ((Major.$deref() != 0) || (Minor.$deref() != 0) || (Micro.$deref() != 0)) {
      return new VersionTuple(Major.$deref(), Minor.$deref(), Micro.$deref());
    }
    if (IsWindowsMSVC) {
      VersionTuple MSVT = TC.getMSVCVersionFromExe();
      if (!MSVT.empty()) {
        return MSVT;
      }
      
      // FIXME: Consider bumping this to 19 (MSVC2015) soon.
      return new VersionTuple(18);
    }
  }
  return new VersionTuple();
}

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 690,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 686,
 FQN="clang::driver::tools::visualstudio::Linker", NM="_ZN5clang6driver5tools12visualstudio6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Linker::Linker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 692,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 688,
   FQN="clang::driver::tools::visualstudio::Linker::Linker", NM="_ZN5clang6driver5tools12visualstudio6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("visualstudio::Linker", "linker", TC, RF_Full, sys::WEM_UTF16)*/ 
    //START JInit
    super($("visualstudio::Linker"), $("linker"), TC, ResponseFileSupport.RF_Full, 
        WindowsEncodingMethod.WEM_UTF16);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 696,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 692,
   FQN="clang::driver::tools::visualstudio::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools12visualstudio6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 697,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 693,
   FQN="clang::driver::tools::visualstudio::Linker::isLinkJob", NM="_ZNK5clang6driver5tools12visualstudio6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10006,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9397,
   FQN="clang::driver::tools::visualstudio::Linker::ConstructJob", NM="_ZNK5clang6driver5tools12visualstudio6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      /*const*/ ToolChain /*&*/ TC = getToolChain();
      assert ((Output.isFilename() || Output.isNothing())) : "invalid output";
      if (Output.isFilename()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-out:"), Output.getFilename()))));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))
         && !C.getDriver().IsCLMode()) {
        CmdArgs.push_back($("-defaultlib:libcmt"));
      }
      if (!Process.GetEnv(new StringRef(/*KEEP_STR*/"LIB")).$bool()) {
        // If the VC environment hasn't been configured (perhaps because the user
        // did not run vcvarsall), try to build a consistent link environment.  If
        // the environment variable is set however, assume the user knows what
        // they're doing.
        std.string VisualStudioDir/*J*/= new std.string();
        /*const*/ MSVCToolChain /*&*/ MSVC = ((/*static_cast*//*const*/ MSVCToolChain /*&*/ )(TC));
        if (MSVC.getVisualStudioInstallDir(VisualStudioDir)) {
          SmallString/*128*/ LibDir/*J*/= new SmallString/*128*/(new StringRef(VisualStudioDir), 128);
          path.append(LibDir, new Twine(/*KEEP_STR*/"VC"), new Twine(/*KEEP_STR*/"lib"));
          switch (MSVC.getArch()) {
           case x86:
            // x86 just puts the libraries directly in lib
            break;
           case x86_64:
            path.append(LibDir, new Twine(/*KEEP_STR*/"amd64"));
            break;
           case arm:
            path.append(LibDir, new Twine(/*KEEP_STR*/"arm"));
            break;
           default:
            break;
          }
          CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-libpath:"), LibDir.c_str()))));
          if (MSVC.useUniversalCRT(VisualStudioDir)) {
            std.string UniversalCRTLibPath/*J*/= new std.string();
            if (MSVC.getUniversalCRTLibraryPath(UniversalCRTLibPath)) {
              CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-libpath:"), 
                              UniversalCRTLibPath.c_str()))));
            }
          }
        }
        
        std.string WindowsSdkLibPath/*J*/= new std.string();
        if (MSVC.getWindowsSDKLibraryPath(WindowsSdkLibPath)) {
          CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-libpath:"), 
                          WindowsSdkLibPath.c_str()))));
        }
      }
      if (!C.getDriver().IsCLMode() && Args.hasArg(new OptSpecifier(options.ID.OPT_L.getValue()))) {
        for (/*const*/std.string/*&*/ LibPath : Args.getAllArgValues(new OptSpecifier(options.ID.OPT_L.getValue())))  {
          CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"-libpath:", LibPath))));
        }
      }
      
      CmdArgs.push_back($("-nologo"));
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_g_Group.getValue()), new OptSpecifier(options.ID.OPT__SLASH_Z7.getValue()), 
          new OptSpecifier(options.ID.OPT__SLASH_Zd.getValue()))) {
        CmdArgs.push_back($("-debug"));
      }
      
      boolean DLL = Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_LD.getValue()), new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()), 
          new OptSpecifier(options.ID.OPT_shared.getValue()));
      if (DLL) {
        CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-dll")));
        
        SmallString/*128*/ ImplibName/*J*/= new SmallString/*128*/(new StringRef(Output.getFilename()), 128);
        path.replace_extension(ImplibName, new Twine(/*KEEP_STR*/"lib"));
        CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(new std.string(/*KEEP_STR*/"-implib:")), new Twine(ImplibName))));
      }
      if (TC.getSanitizerArgs().needsAsanRt()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-debug")));
        CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-incremental:no")));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT__SLASH_MD.getValue()), new OptSpecifier(options.ID.OPT__SLASH_MDd.getValue()))) {
          for (/*const*/char$ptr/*char P*//*const*/ /*&*/ Lib : new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("asan_dynamic"), $("asan_dynamic_runtime_thunk")})  {
            CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(Lib)));
          }
          // Make sure the dynamic runtime thunk is not optimized out at link time
          // to ensure proper SEH handling.
          CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"-include:___asan_seh_interceptor")));
        } else if (DLL) {
          CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(/*KEEP_STR*/"asan_dll_thunk")));
        } else {
          for (/*const*/char$ptr/*char P*//*const*/ /*&*/ Lib : new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("asan"), $("asan_cxx")})  {
            CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(Lib)));
          }
        }
      }
      
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_link.getValue()));
      if (Args.hasFlag(new OptSpecifier(options.ID.OPT_fopenmp.getValue()), new OptSpecifier(options.ID.OPT_fopenmp_EQ.getValue()), 
          new OptSpecifier(options.ID.OPT_fno_openmp.getValue()), false)) {
        CmdArgs.push_back($("-nodefaultlib:vcomp.lib"));
        CmdArgs.push_back($("-nodefaultlib:vcompd.lib"));
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T($add_string_string$C(new std.string(/*KEEP_STR*/"-libpath:"), 
                            TC.getDriver().Dir), /*KEEP_STR*/"/../lib"))));
        switch (getOpenMPRuntime(getToolChain(), Args)) {
         case OMPRT_OMP:
          CmdArgs.push_back($("-defaultlib:libomp.lib"));
          break;
         case OMPRT_IOMP5:
          CmdArgs.push_back($("-defaultlib:libiomp5md.lib"));
          break;
         case OMPRT_GOMP:
          break;
         case OMPRT_Unknown:
          // Already diagnosed.
          break;
        }
      }
      
      // Add compiler-rt lib in case if it was explicitly
      // specified as an argument for --rtlib option.
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))) {
        AddRunTimeLibs(TC, TC.getDriver(), CmdArgs, Args);
      }
      
      // Add filenames, libraries, and other linker inputs.
      for (/*const*/ InputInfo /*&*/ Input : Inputs) {
        if (Input.isFilename()) {
          CmdArgs.push_back(Input.getFilename());
          continue;
        }
        
        /*const*/ Arg /*&*/ A = Input.getInputArg();
        
        // Render -l options differently for the MSVC linker.
        if (A.getOption().matches(new OptSpecifier(options.ID.OPT_l.getValue()))) {
          StringRef Lib = new StringRef(A.getValue());
          /*const*/char$ptr/*char P*/ LinkLibArg;
          if (Lib.endswith(/*STRINGREF_STR*/".lib")) {
            LinkLibArg = $tryClone(Args.MakeArgString(new Twine(Lib)));
          } else {
            LinkLibArg = $tryClone(Args.MakeArgString($add_StringRef_char$ptr$C(Lib, /*KEEP_STR*/".lib")));
          }
          CmdArgs.push_back(LinkLibArg);
          continue;
        }
        
        // Otherwise, this is some other kind of linker input option like -Wl, -z,
        // or -L. Render it, even if MSVC doesn't understand it.
        A.renderAsInput(Args, CmdArgs);
      }
      
      TC.addProfileRTLibs(Args, CmdArgs);
      
      // We need to special case some linker paths.  In the case of lld, we need to
      // translate 'lld' into 'lld-link', and in the case of the regular msvc
      // linker, we need to use a special search algorithm.
      SmallString/*128*/ linkPath/*J*/= new SmallString/*128*/(128);
      StringRef Linker = Args.getLastArgValue(new OptSpecifier(options.ID.OPT_fuse_ld_EQ.getValue()), new StringRef(/*KEEP_STR*/"link"));
      if (Linker.equals_lower(/*STRINGREF_STR*/"lld")) {
        Linker.$assignMove(/*STRINGREF_STR*/"lld-link");
      }
      if (Linker.equals_lower(/*STRINGREF_STR*/"link")) {
        // If we're using the MSVC linker, it's not sufficient to just use link
        // from the program PATH, because other environments like GnuWin32 install
        // their own link.exe which may come first.
        linkPath.$assign(new StringRef(FindVisualStudioExecutable(TC, $("link.exe"), 
                    C.getDriver().getClangProgramPath())));
      } else {
        linkPath.$assign(/*NO_COPY*/Linker);
        path.replace_extension(linkPath, new Twine(/*KEEP_STR*/"exe"));
        linkPath.$assign(new StringRef(TC.GetProgramPath(linkPath.c_str())));
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(linkPath)));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 690,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 686,
   FQN="clang::driver::tools::visualstudio::Linker::~Linker", NM="_ZN5clang6driver5tools12visualstudio6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 705,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 701,
 FQN="clang::driver::tools::visualstudio::Compiler", NM="_ZN5clang6driver5tools12visualstudio8CompilerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio8CompilerE")
//</editor-fold>
public static class Compiler extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::Compiler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 707,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 703,
   FQN="clang::driver::tools::visualstudio::Compiler::Compiler", NM="_ZN5clang6driver5tools12visualstudio8CompilerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio8CompilerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Compiler(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("visualstudio::Compiler", "compiler", TC, RF_Full, sys::WEM_UTF16)*/ 
    //START JInit
    super($("visualstudio::Compiler"), $("compiler"), TC, ResponseFileSupport.RF_Full, 
        WindowsEncodingMethod.WEM_UTF16);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::hasIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 711,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 707,
   FQN="clang::driver::tools::visualstudio::Compiler::hasIntegratedAssembler", NM="_ZNK5clang6driver5tools12visualstudio8Compiler22hasIntegratedAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio8Compiler22hasIntegratedAssemblerEv")
  //</editor-fold>
  @Override public boolean hasIntegratedAssembler() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 712,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 708,
   FQN="clang::driver::tools::visualstudio::Compiler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools12visualstudio8Compiler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio8Compiler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 713,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 709,
   FQN="clang::driver::tools::visualstudio::Compiler::isLinkJob", NM="_ZNK5clang6driver5tools12visualstudio8Compiler9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio8Compiler9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9561,
   FQN="clang::driver::tools::visualstudio::Compiler::ConstructJob", NM="_ZNK5clang6driver5tools12visualstudio8Compiler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio8Compiler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      C.addCommand($c$.track(GetCommand(C, JA, Output, Inputs, Args, LinkingOutput))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::GetCommand">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10189,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9569,
   FQN="clang::driver::tools::visualstudio::Compiler::GetCommand", NM="_ZNK5clang6driver5tools12visualstudio8Compiler10GetCommandERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12visualstudio8Compiler10GetCommandERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  public std.unique_ptr<Command> GetCommand(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, /*const*/ InputInfo /*&*/ Output, 
            /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, /*const*/ ArgList /*&*/ Args, 
            /*const*/char$ptr/*char P*/ LinkingOutput) /*const*/ {
    std.vectorString Includes = null;
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      CmdArgs.push_back($("/nologo"));
      CmdArgs.push_back($("/c")); // Compile only.
      CmdArgs.push_back($("/W0")); // No warnings.
      
      // The goal is to be able to invoke this tool correctly based on
      // any flag accepted by clang-cl.
      
      // These are spelled the same way in clang and cl.exe,.
      Args.AddAllArgs(CmdArgs, /*{ */new ArrayRef<OptSpecifier>(new /*const*/ OptSpecifier [/*3*/] 
        {
          new OptSpecifier(options.ID.OPT_D.getValue()), 
          new OptSpecifier(options.ID.OPT_U.getValue()), 
          new OptSpecifier(options.ID.OPT_I.getValue())
        })/* }*/);
      {
        
        // Optimization level.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fbuiltin.getValue()), new OptSpecifier(options.ID.OPT_fno_builtin.getValue()));
        if ((A != null)) {
          CmdArgs.push_back(A.getOption().getID() == options.ID.OPT_fbuiltin.getValue() ? $("/Oi") : $("/Oi-"));
        }
      }
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O.getValue()), new OptSpecifier(options.ID.OPT_O0.getValue()));
        if ((A != null)) {
          if (A.getOption().getID() == options.ID.OPT_O0.getValue()) {
            CmdArgs.push_back($("/Od"));
          } else {
            CmdArgs.push_back($("/Og"));
            
            StringRef OptLevel = new StringRef(A.getValue());
            if ($eq_StringRef(/*NO_COPY*/OptLevel, /*STRINGREF_STR*/"s") || $eq_StringRef(/*NO_COPY*/OptLevel, /*STRINGREF_STR*/"z")) {
              CmdArgs.push_back($("/Os"));
            } else {
              CmdArgs.push_back($("/Ot"));
            }
            
            CmdArgs.push_back($("/Ob2"));
          }
        }
      }
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fomit_frame_pointer.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_omit_frame_pointer.getValue()));
        if ((A != null)) {
          CmdArgs.push_back(A.getOption().getID() == options.ID.OPT_fomit_frame_pointer.getValue() ? $("/Oy") : $("/Oy-"));
        }
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_fwritable_strings.getValue()))) {
        CmdArgs.push_back($("/GF"));
      }
      
      // Flags for which clang-cl has an alias.
      // FIXME: How can we ensure this stays in sync with relevant clang-cl options?
      if (Args.hasFlag(new OptSpecifier(options.ID.OPT__SLASH_GR_.getValue()), new OptSpecifier(options.ID.OPT__SLASH_GR.getValue()), 
          /*default=*/ false)) {
        CmdArgs.push_back($("/GR-"));
      }
      if (Args.hasFlag(new OptSpecifier(options.ID.OPT__SLASH_GS_.getValue()), new OptSpecifier(options.ID.OPT__SLASH_GS.getValue()), 
          /*default=*/ false)) {
        CmdArgs.push_back($("/GS-"));
      }
      {
        
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_ffunction_sections.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_function_sections.getValue()));
        if ((A != null)) {
          CmdArgs.push_back(A.getOption().getID() == options.ID.OPT_ffunction_sections.getValue() ? $("/Gy") : $("/Gy-"));
        }
      }
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_fdata_sections.getValue()), 
            new OptSpecifier(options.ID.OPT_fno_data_sections.getValue()));
        if ((A != null)) {
          CmdArgs.push_back(A.getOption().getID() == options.ID.OPT_fdata_sections.getValue() ? $("/Gw") : $("/Gw-"));
        }
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_fsyntax_only.getValue()))) {
        CmdArgs.push_back($("/Zs"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_g_Flag.getValue()), new OptSpecifier(options.ID.OPT_gline_tables_only.getValue()), 
          new OptSpecifier(options.ID.OPT__SLASH_Z7.getValue()))) {
        CmdArgs.push_back($("/Z7"));
      }
      
      Includes = Args.getAllArgValues(new OptSpecifier(options.ID.OPT_include.getValue()));
      for (/*const*/std.string/*&*/ Include : Includes)  {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_string$C(new std.string(/*KEEP_STR*/"/FI"), Include))));
      }
      
      // Flags that can simply be passed through.
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_LD.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_LDd.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_GX.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_GX_.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_EH.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT__SLASH_Zl.getValue()));
      {
        
        // The order of these flags is relevant, so pick the last one.
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT__SLASH_MD.getValue()), new OptSpecifier(options.ID.OPT__SLASH_MDd.getValue()), 
            new OptSpecifier(options.ID.OPT__SLASH_MT.getValue()), new OptSpecifier(options.ID.OPT__SLASH_MTd.getValue()));
        if ((A != null)) {
          A.render(Args, CmdArgs);
        }
      }
      
      // Pass through all unknown arguments so that the fallback command can see
      // them too.
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_UNKNOWN.getValue()));
      
      // Input filename.
      assert (Inputs.size() == 1);
      /*const*/ InputInfo /*&*/ II = Inputs.$at(0);
      assert (II.getType() == types.ID.TY_C || II.getType() == types.ID.TY_CXX);
      CmdArgs.push_back(II.getType() == types.ID.TY_C ? $("/Tc") : $("/Tp"));
      if (II.isFilename()) {
        CmdArgs.push_back(II.getFilename());
      } else {
        II.getInputArg().renderAsInput(Args, CmdArgs);
      }
      
      // Output filename.
      assert (Output.getType() == types.ID.TY_Object);
      /*const*/char$ptr/*char P*/ Fo = $tryClone(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"/Fo"), Output.getFilename()))));
      CmdArgs.push_back(Fo);
      
      /*const*/ Driver /*&*/ D = getToolChain().getDriver();
      std.string Exec = FindVisualStudioExecutable(getToolChain(), $("cl.exe"), 
          D.getClangProgramPath());
      return llvm.make_unique(new Command(JA, /*Deref*/this, Args.MakeArgString(new Twine(Exec)), 
          CmdArgs, Inputs));
    } finally {
      if (Includes != null) { Includes.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::visualstudio::Compiler::~Compiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 705,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 701,
   FQN="clang::driver::tools::visualstudio::Compiler::~Compiler", NM="_ZN5clang6driver5tools12visualstudio8CompilerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12visualstudio8CompilerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class VisualstudioStatics
