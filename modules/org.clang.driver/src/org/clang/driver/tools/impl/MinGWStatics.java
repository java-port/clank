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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
;


//<editor-fold defaultstate="collapsed" desc="static type MinGWStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW6LinkerE;_ZN5clang6driver5tools5MinGW9AssemblerE; -static-type=MinGWStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class MinGWStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 730,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 726,
 FQN="clang::driver::tools::MinGW::Assembler", NM="_ZN5clang6driver5tools5MinGW9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 732,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 728,
   FQN="clang::driver::tools::MinGW::Assembler::Assembler", NM="_ZN5clang6driver5tools5MinGW9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("MinGW::Assemble", "assembler", TC)*/ 
    //START JInit
    super($("MinGW::Assemble"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 734,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 730,
   FQN="clang::driver::tools::MinGW::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5MinGW9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5MinGW9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  
  /// MinGW Tools
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10301,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9672,
   FQN="clang::driver::tools::MinGW::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools5MinGW9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5MinGW9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      claimNoWarnArgs(Args);
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      if (getToolChain().getArch() == Triple.ArchType.x86) {
        CmdArgs.push_back($("--32"));
      } else if (getToolChain().getArch() == Triple.ArchType.x86_64) {
        CmdArgs.push_back($("--64"));
      }
      
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      
      for (/*const*/ InputInfo /*&*/ II : Inputs)  {
        CmdArgs.push_back(II.getFilename());
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("as")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_gsplit_dwarf.getValue()))) {
        SplitDebugInfo(getToolChain(), C, /*Deref*/this, JA, Args, Output, 
            SplitDebugName(Args, Inputs.$at(0)));
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 730,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 726,
   FQN="clang::driver::tools::MinGW::Assembler::~Assembler", NM="_ZN5clang6driver5tools5MinGW9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 742,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 738,
 FQN="clang::driver::tools::MinGW::Linker", NM="_ZN5clang6driver5tools5MinGW6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 744,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 740,
   FQN="clang::driver::tools::MinGW::Linker::Linker", NM="_ZN5clang6driver5tools5MinGW6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("MinGW::Linker", "linker", TC)*/ 
    //START JInit
    super($("MinGW::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 746,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 742,
   FQN="clang::driver::tools::MinGW::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5MinGW6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5MinGW6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 747,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 743,
   FQN="clang::driver::tools::MinGW::Linker::isLinkJob", NM="_ZNK5clang6driver5tools5MinGW6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5MinGW6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10361,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9732,
   FQN="clang::driver::tools::MinGW::Linker::ConstructJob", NM="_ZNK5clang6driver5tools5MinGW6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5MinGW6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ ToolChain /*&*/ TC = getToolChain();
      /*const*/ Driver /*&*/ D = TC.getDriver();
      // const SanitizerArgs &Sanitize = TC.getSanitizerArgs();
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      // Silence warning for "clang -g foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      // and "clang -emit-llvm foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      // and for "clang -w foo.o -o foo". Other warning options are already
      // handled somewhere else.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      
      StringRef LinkerName = Args.getLastArgValue(new OptSpecifier(options.ID.OPT_fuse_ld_EQ.getValue()), new StringRef(/*KEEP_STR*/"ld"));
      if (LinkerName.equals_lower(/*STRINGREF_STR*/"lld")) {
        CmdArgs.push_back($("-flavor"));
        CmdArgs.push_back($("gnu"));
      } else if (!LinkerName.equals_lower(/*STRINGREF_STR*/"ld")) {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_unsupported_linker)), /*NO_COPY*/LinkerName));
      }
      if (!D.SysRoot.empty()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_str$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_s.getValue()))) {
        CmdArgs.push_back($("-s"));
      }
      
      CmdArgs.push_back($("-m"));
      if (TC.getArch() == Triple.ArchType.x86) {
        CmdArgs.push_back($("i386pe"));
      }
      if (TC.getArch() == Triple.ArchType.x86_64) {
        CmdArgs.push_back($("i386pep"));
      }
      if (TC.getArch() == Triple.ArchType.arm) {
        CmdArgs.push_back($("thumb2pe"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_mwindows.getValue()))) {
        CmdArgs.push_back($("--subsystem"));
        CmdArgs.push_back($("windows"));
      } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_mconsole.getValue()))) {
        CmdArgs.push_back($("--subsystem"));
        CmdArgs.push_back($("console"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        CmdArgs.push_back($("-Bstatic"));
      } else {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_mdll.getValue()))) {
          CmdArgs.push_back($("--dll"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back($("--shared"));
        }
        CmdArgs.push_back($("-Bdynamic"));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_mdll.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back($("-e"));
          if (TC.getArch() == Triple.ArchType.x86) {
            CmdArgs.push_back($("_DllMainCRTStartup@12"));
          } else {
            CmdArgs.push_back($("DllMainCRTStartup"));
          }
          CmdArgs.push_back($("--enable-auto-image-base"));
        }
      }
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_e.getValue()));
      // FIXME: add -N, -n flags
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_r.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_s.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_t.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_u_Group.getValue()));
      Args.AddLastArg(CmdArgs, new OptSpecifier(options.ID.OPT_Z_Flag.getValue()));
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_mdll.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("dllcrt2.o")))));
        } else {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_municode.getValue()))) {
            CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crt2u.o")))));
          } else {
            CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crt2.o")))));
          }
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("gcrt2.o")))));
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crtbegin.o")))));
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      TC.AddFilePathLibArgs(Args, CmdArgs);
      AddLinkerInputs(TC, Inputs, Args, CmdArgs);
      
      // TODO: Add ASan stuff here
      
      // TODO: Add profile stuff here
      if (D.CCCIsCXX()
         && !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        boolean OnlyLibstdcxxStatic = Args.hasArg(new OptSpecifier(options.ID.OPT_static_libstdcxx.getValue()))
           && !Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()));
        if (OnlyLibstdcxxStatic) {
          CmdArgs.push_back($("-Bstatic"));
        }
        TC.AddCXXStdlibLibArgs(Args, CmdArgs);
        if (OnlyLibstdcxxStatic) {
          CmdArgs.push_back($("-Bdynamic"));
        }
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            CmdArgs.push_back($("--start-group"));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_fstack_protector.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_fstack_protector_strong.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_fstack_protector_all.getValue()))) {
            CmdArgs.push_back($("-lssp_nonshared"));
            CmdArgs.push_back($("-lssp"));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_fopenmp.getValue()))) {
            CmdArgs.push_back($("-lgomp"));
          }
          
          AddLibGCC(Args, CmdArgs);
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back($("-lgmon"));
          }
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
            CmdArgs.push_back($("-lpthread"));
          }
          
          // add system libraries
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_mwindows.getValue()))) {
            CmdArgs.push_back($("-lgdi32"));
            CmdArgs.push_back($("-lcomdlg32"));
          }
          CmdArgs.push_back($("-ladvapi32"));
          CmdArgs.push_back($("-lshell32"));
          CmdArgs.push_back($("-luser32"));
          CmdArgs.push_back($("-lkernel32"));
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            CmdArgs.push_back($("--end-group"));
          } else if (!LinkerName.equals_lower(/*STRINGREF_STR*/"lld")) {
            AddLibGCC(Args, CmdArgs);
          }
        }
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
          // Add crtfastmath.o if available and fast math is enabled.
          TC.AddFastMathRuntimeIfAvailable(Args, CmdArgs);
          
          CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crtend.o")))));
        }
      }
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(TC.GetProgramPath(LinkerName.data()))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker::AddLibGCC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10331,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9702,
   FQN="clang::driver::tools::MinGW::Linker::AddLibGCC", NM="_ZNK5clang6driver5tools5MinGW6Linker9AddLibGCCERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5MinGW6Linker9AddLibGCCERKN4llvm3opt7ArgListERNS4_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  private void AddLibGCC(/*const*/ ArgList /*&*/ Args, 
           ArgStringList/*&*/ CmdArgs) /*const*/ {
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_mthreads.getValue()))) {
      CmdArgs.push_back($("-lmingwthrd"));
    }
    CmdArgs.push_back($("-lmingw32"));
    
    // Make use of compiler-rt if --rtlib option is used
    ToolChain.RuntimeLibType RLT = getToolChain().GetRuntimeLibType(Args);
    if (RLT == ToolChain.RuntimeLibType.RLT_Libgcc) {
      boolean Static = Args.hasArg(new OptSpecifier(options.ID.OPT_static_libgcc.getValue()))
         || Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()));
      boolean Shared = Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()));
      boolean CXX = getToolChain().getDriver().CCCIsCXX();
      if (Static || (!CXX && !Shared)) {
        CmdArgs.push_back($("-lgcc"));
        CmdArgs.push_back($("-lgcc_eh"));
      } else {
        CmdArgs.push_back($("-lgcc_s"));
        CmdArgs.push_back($("-lgcc"));
      }
    } else {
      AddRunTimeLibs(getToolChain(), getToolChain().getDriver(), CmdArgs, Args);
    }
    
    CmdArgs.push_back($("-lmoldname"));
    CmdArgs.push_back($("-lmingwex"));
    CmdArgs.push_back($("-lmsvcrt"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::MinGW::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 742,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 738,
   FQN="clang::driver::tools::MinGW::Linker::~Linker", NM="_ZN5clang6driver5tools5MinGW6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5MinGW6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class MinGWStatics
