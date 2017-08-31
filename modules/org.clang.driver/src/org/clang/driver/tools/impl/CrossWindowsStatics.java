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

import org.clang.driver.toolchains.impl.CrossWindowsToolChain;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.llvm.support.sys.*;;
import static org.clang.driver.impl.ToolsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type CrossWindowsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows6LinkerE;_ZN5clang6driver5tools12CrossWindows9AssemblerE; -static-type=CrossWindows -package=org.clang.driver.tools.impl")
//</editor-fold>

public final class CrossWindowsStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 819,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 805,
 FQN="clang::driver::tools::CrossWindows::Assembler", NM="_ZN5clang6driver5tools12CrossWindows9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 821,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 807,
   FQN="clang::driver::tools::CrossWindows::Assembler::Assembler", NM="_ZN5clang6driver5tools12CrossWindows9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("CrossWindows::Assembler", "as", TC)*/
    //START JInit
    super($("CrossWindows::Assembler"), $("as"), TC);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 823,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 809,
   FQN="clang::driver::tools::CrossWindows::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools12CrossWindows9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12CrossWindows9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10585,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9956,
   FQN="clang::driver::tools::CrossWindows::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools12CrossWindows9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12CrossWindows9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA,
              /*const*/ InputInfo /*&*/ Output,
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs,
              /*const*/ ArgList /*&*/ Args,
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      claimNoWarnArgs(Args);
      /*const*/ CrossWindowsToolChain /*&*/ TC = ((/*static_cast*//*const*/ CrossWindowsToolChain /*&*/ )(getToolChain()));
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      /*const*/char$ptr/*char P*/ Exec;
      switch (TC.getArch()) {
       default:
        throw new llvm_unreachable("unsupported architecture");
       case arm:
       case thumb:
        break;
       case x86:
        CmdArgs.push_back($("--32"));
        break;
       case x86_64:
        CmdArgs.push_back($("--64"));
        break;
      }

      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));

      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());

      for (/*const*/ InputInfo /*&*/ Input : Inputs)  {
        CmdArgs.push_back(Input.getFilename());
      }

      /*const*/std.string Assembler = TC.GetProgramPath($("as"));
      Exec = $tryClone(Args.MakeArgString(new Twine(Assembler)));

      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 819,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 805,
   FQN="clang::driver::tools::CrossWindows::Assembler::~Assembler", NM="_ZN5clang6driver5tools12CrossWindows9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 831,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 817,
 FQN="clang::driver::tools::CrossWindows::Linker", NM="_ZN5clang6driver5tools12CrossWindows6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 833,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 819,
   FQN="clang::driver::tools::CrossWindows::Linker::Linker", NM="_ZN5clang6driver5tools12CrossWindows6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("CrossWindows::Linker", "ld", TC, RF_Full)*/
    //START JInit
    super($("CrossWindows::Linker"), $("ld"), TC, Tool.ResponseFileSupport.RF_Full);
    //END JInit
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 836,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 822,
   FQN="clang::driver::tools::CrossWindows::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools12CrossWindows6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12CrossWindows6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 837,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 823,
   FQN="clang::driver::tools::CrossWindows::Linker::isLinkJob", NM="_ZNK5clang6driver5tools12CrossWindows6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12CrossWindows6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10624,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9995,
   FQN="clang::driver::tools::CrossWindows::Linker::ConstructJob", NM="_ZNK5clang6driver5tools12CrossWindows6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools12CrossWindows6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA,
              /*const*/ InputInfo /*&*/ Output,
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs,
              /*const*/ ArgList /*&*/ Args,
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ CrossWindowsToolChain /*&*/ TC = ((/*static_cast*//*const*/ CrossWindowsToolChain /*&*/ )(getToolChain()));
      /*const*/ Triple /*&*/ T = TC.getTriple();
      /*const*/ Driver /*&*/ D = TC.getDriver();
      SmallString/*128*/ EntryPoint/*J*/= new SmallString/*128*/(128);
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      /*const*/char$ptr/*char P*/ Exec;

      // Silence warning for "clang -g foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      // and "clang -emit-llvm foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      // and for "clang -w foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      // Other warning options are already handled somewhere else.
      if (!D.SysRoot.empty()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_str$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
        CmdArgs.push_back($("-pie"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
        CmdArgs.push_back($("-export-dynamic"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_s.getValue()))) {
        CmdArgs.push_back($("--strip-all"));
      }

      CmdArgs.push_back($("-m"));
      switch (TC.getArch()) {
       default:
        throw new llvm_unreachable("unsupported architecture");
       case arm:
       case thumb:
        // FIXME: this is incorrect for WinCE
        CmdArgs.push_back($("thumb2pe"));
        break;
       case x86:
        CmdArgs.push_back($("i386pe"));
        EntryPoint.append(new StringRef(/*KEEP_STR*/$UNDERSCORE));
        break;
       case x86_64:
        CmdArgs.push_back($("i386pep"));
        break;
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
        switch (T.getArch()) {
         default:
          throw new llvm_unreachable("unsupported architecture");
         case arm:
         case thumb:
         case x86_64:
          EntryPoint.append(new StringRef(/*KEEP_STR*/"_DllMainCRTStartup"));
          break;
         case x86:
          EntryPoint.append(new StringRef(/*KEEP_STR*/"_DllMainCRTStartup@12"));
          break;
        }

        CmdArgs.push_back($("-shared"));
        CmdArgs.push_back($("-Bdynamic"));

        CmdArgs.push_back($("--enable-auto-image-base"));

        CmdArgs.push_back($("--entry"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(EntryPoint)));
      } else {
        EntryPoint.append(new StringRef(/*KEEP_STR*/"mainCRTStartup"));

        CmdArgs.push_back(Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue())) ? $("-Bstatic") : $("-Bdynamic"));
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
          CmdArgs.push_back($("--entry"));
          CmdArgs.push_back(Args.MakeArgString(new Twine(EntryPoint)));
        }
        // FIXME: handle subsystem
      }

      // NOTE: deal with multiple definitions on Windows (e.g. COMDAT)
      CmdArgs.push_back($("--allow-multiple-definition"));

      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
        SmallString/*261*/ ImpLib/*J*/= new SmallString/*261*/(new StringRef(Output.getFilename()), 261);
        path.replace_extension(ImpLib, new Twine(/*KEEP_STR*/".lib"));

        CmdArgs.push_back($("--out-implib"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(ImpLib)));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        /*const*/std.string CRTPath/*J*/= $add_str$C_T(D.SysRoot, /*KEEP_STR*/"/usr/lib/");
        /*const*/char$ptr/*char P*/ CRTBegin;

        CRTBegin = $tryClone(Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) ? $("crtbeginS.obj") : $("crtbegin.obj"));
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_str$C_T(CRTPath, CRTBegin))));
      }

      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      TC.AddFilePathLibArgs(Args, CmdArgs);
      AddLinkerInputs(TC, Inputs, Args, CmdArgs);
      if (D.CCCIsCXX() && !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))
         && !Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        boolean StaticCXX = Args.hasArg(new OptSpecifier(options.ID.OPT_static_libstdcxx.getValue()))
           && !Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()));
        if (StaticCXX) {
          CmdArgs.push_back($("-Bstatic"));
        }
        TC.AddCXXStdlibLibArgs(Args, CmdArgs);
        if (StaticCXX) {
          CmdArgs.push_back($("-Bdynamic"));
        }
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
          // TODO handle /MT[d] /MD[d]
          CmdArgs.push_back($("-lmsvcrt"));
          AddRunTimeLibs(TC, D, CmdArgs, Args);
        }
      }
      if (TC.getSanitizerArgs().needsAsanRt()) {
        // TODO handle /MT[d] /MD[d]
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(/*KEEP_STR*/"asan_dll_thunk")));
        } else {
          for (/*const*/char$ptr/*char P*//*const*/ /*&*/ Lib : new /*const*/char$ptr/*char P*//*const*/ [/*2*/] {$("asan_dynamic"), $("asan_dynamic_runtime_thunk")})  {
            CmdArgs.push_back(TC.getCompilerRTArgString(Args, new StringRef(Lib)));
          }
          // Make sure the dynamic runtime thunk is not optimized out at link time
          // to ensure proper SEH handling.
          CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"--undefined")));
          CmdArgs.push_back(Args.MakeArgString(new Twine(TC.getArch() == Triple.ArchType.x86 ? $("___asan_seh_interceptor") : $("__asan_seh_interceptor"))));
        }
      }

      Exec = $tryClone(Args.MakeArgString(new Twine(TC.GetLinkerPath())));

      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::CrossWindows::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 831,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 817,
   FQN="clang::driver::tools::CrossWindows::Linker::~Linker", NM="_ZN5clang6driver5tools12CrossWindows6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools12CrossWindows6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }


  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}

} // END OF class CrossWindows
