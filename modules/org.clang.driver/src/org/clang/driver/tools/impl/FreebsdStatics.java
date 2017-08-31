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
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import static org.clang.driver.impl.ToolsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type FreebsdStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd6LinkerE;_ZN5clang6driver5tools7freebsd9AssemblerE; -static-type=FreebsdStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class FreebsdStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 488,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 485,
 FQN="clang::driver::tools::freebsd::Assembler", NM="_ZN5clang6driver5tools7freebsd9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 490,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 487,
   FQN="clang::driver::tools::freebsd::Assembler::Assembler", NM="_ZN5clang6driver5tools7freebsd9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("freebsd::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("freebsd::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 493,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 490,
   FQN="clang::driver::tools::freebsd::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7freebsd9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7freebsd9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8434,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7798,
   FQN="clang::driver::tools::freebsd::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools7freebsd9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7freebsd9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
      
      // When building 32-bit code on FreeBSD/amd64, we have to explicitly
      // instruct as in the base system to assemble 32-bit code.
      switch (getToolChain().getArch()) {
       default:
        break;
       case x86:
        CmdArgs.push_back($("--32"));
        break;
       case ppc:
        CmdArgs.push_back($("-a32"));
        break;
       case mips:
       case mipsel:
       case mips64:
       case mips64el:
        {
          StringRef CPUName/*J*/= new StringRef();
          StringRef ABIName/*J*/= new StringRef();
          MipsStatics.getMipsCPUAndABI(Args, getToolChain().getTriple(), CPUName, ABIName);
          
          CmdArgs.push_back($("-march"));
          CmdArgs.push_back(CPUName.data());
          
          CmdArgs.push_back($("-mabi"));
          CmdArgs.push_back(getGnuCompatibleMipsABIName(/*NO_COPY*/ABIName).data());
          if (getToolChain().getArch() == Triple.ArchType.mips
             || getToolChain().getArch() == Triple.ArchType.mips64) {
            CmdArgs.push_back($("-EB"));
          } else {
            CmdArgs.push_back($("-EL"));
          }
          {
            
            Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_G.getValue()));
            if ((A != null)) {
              StringRef v = new StringRef(A.getValue());
              CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-G", v)));
              A.claim();
            }
          }
          
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       case arm:
       case armeb:
       case thumb:
       case thumbeb:
        {
          ArmStatics.FloatABI ABI = ArmStatics.getARMFloatABI(getToolChain(), Args);
          if (ABI == ArmStatics.FloatABI.Hard) {
            CmdArgs.push_back($("-mfpu=vfp"));
          } else {
            CmdArgs.push_back($("-mfpu=softvfp"));
          }
          switch (getToolChain().getTriple().getEnvironment()) {
           case GNUEABIHF:
           case GNUEABI:
           case EABI:
            CmdArgs.push_back($("-meabi=5"));
            break;
           default:
            CmdArgs.push_back($("-matpcs"));
          }
          break;
        }
       case sparc:
       case sparcel:
       case sparcv9:
        {
          std.string CPU = getCPUName(Args, getToolChain().getTriple());
          CmdArgs.push_back(getSparcAsmModeForCPU(new StringRef(CPU), getToolChain().getTriple()));
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
      }
      
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      
      for (/*const*/ InputInfo /*&*/ II : Inputs)  {
        CmdArgs.push_back(II.getFilename());
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("as")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 488,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 485,
   FQN="clang::driver::tools::freebsd::Assembler::~Assembler", NM="_ZN5clang6driver5tools7freebsd9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 501,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 498,
 FQN="clang::driver::tools::freebsd::Linker", NM="_ZN5clang6driver5tools7freebsd6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 503,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 500,
   FQN="clang::driver::tools::freebsd::Linker::Linker", NM="_ZN5clang6driver5tools7freebsd6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("freebsd::Linker", "linker", TC)*/ 
    //START JInit
    super($("freebsd::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 505,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 502,
   FQN="clang::driver::tools::freebsd::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7freebsd6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7freebsd6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 506,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 503,
   FQN="clang::driver::tools::freebsd::Linker::isLinkJob", NM="_ZNK5clang6driver5tools7freebsd6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7freebsd6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8527,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7891,
   FQN="clang::driver::tools::freebsd::Linker::ConstructJob", NM="_ZNK5clang6driver5tools7freebsd6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7freebsd6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ FreeBSD /*&*/ ToolChain = ((/*static_cast*//*const*/ FreeBSD /*&*/ )(getToolChain()));
      /*const*/ Driver /*&*/ D = ToolChain.getDriver();
      /*const*/ Triple.ArchType Arch = ToolChain.getArch();
      /*const*/boolean IsPIE = !Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))
         && (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue())) || ToolChain.isPIEDefault());
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      // Silence warning for "clang -g foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      // and "clang -emit-llvm foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      // and for "clang -w foo.o -o foo". Other warning options are already
      // handled somewhere else.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      if (!D.SysRoot.empty()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
      }
      if (IsPIE) {
        CmdArgs.push_back($("-pie"));
      }
      
      CmdArgs.push_back($("--eh-frame-hdr"));
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        CmdArgs.push_back($("-Bstatic"));
      } else {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
          CmdArgs.push_back($("-export-dynamic"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back($("-Bshareable"));
        } else {
          CmdArgs.push_back($("-dynamic-linker"));
          CmdArgs.push_back($("/libexec/ld-elf.so.1"));
        }
        if ($greatereq_uint(ToolChain.getTriple().getOSMajorVersion(), 9)) {
          if (Arch == Triple.ArchType.arm || Arch == Triple.ArchType.sparc
             || Arch == Triple.ArchType.x86 || Arch == Triple.ArchType.x86_64) {
            CmdArgs.push_back($("--hash-style=both"));
          }
        }
        CmdArgs.push_back($("--enable-new-dtags"));
      }
      
      // When building 32-bit code on FreeBSD/amd64, we have to explicitly
      // instruct ld in the base system to link 32-bit code.
      if (Arch == Triple.ArchType.x86) {
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf_i386_fbsd"));
      }
      if (Arch == Triple.ArchType.ppc) {
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf32ppc_fbsd"));
      }
      {
        
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_G.getValue()));
        if ((A != null)) {
          if (ToolChain.getArch() == Triple.ArchType.mips
             || ToolChain.getArch() == Triple.ArchType.mipsel
             || ToolChain.getArch() == Triple.ArchType.mips64
             || ToolChain.getArch() == Triple.ArchType.mips64el) {
            StringRef v = new StringRef(A.getValue());
            CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-G", v)));
            A.claim();
          }
        }
      }
      if (Output.isFilename()) {
        CmdArgs.push_back($("-o"));
        CmdArgs.push_back(Output.getFilename());
      } else {
        assert (Output.isNothing()) : "Invalid output.";
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        /*const*/char$ptr/*char P*/ crt1 = null;
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            crt1 = $tryClone($("gcrt1.o"));
          } else if (IsPIE) {
            crt1 = $tryClone($("Scrt1.o"));
          } else {
            crt1 = $tryClone($("crt1.o"));
          }
        }
        if ((crt1 != null)) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crt1))));
        }
        
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crti.o")))));
        
        /*const*/char$ptr/*char P*/ crtbegin = null;
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
          crtbegin = $tryClone($("crtbeginT.o"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || IsPIE) {
          crtbegin = $tryClone($("crtbeginS.o"));
        } else {
          crtbegin = $tryClone($("crtbegin.o"));
        }
        
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crtbegin))));
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      ToolChain.AddFilePathLibArgs(Args, CmdArgs);
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_T_Group.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_e.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_s.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_t.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_Z_Flag.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_r.getValue()));
      if (D.isUsingLTO()) {
        AddGoldPlugin(ToolChain, Args, CmdArgs, D.getLTOMode() == LTOKind.LTOK_Thin);
      }
      
      boolean NeedsSanitizerDeps = addSanitizerRuntimes(ToolChain, Args, CmdArgs);
      AddLinkerInputs(ToolChain, Inputs, Args, CmdArgs);
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        addOpenMPRuntime(CmdArgs, ToolChain, Args);
        if (D.CCCIsCXX()) {
          ToolChain.AddCXXStdlibLibArgs(Args, CmdArgs);
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back($("-lm_p"));
          } else {
            CmdArgs.push_back($("-lm"));
          }
        }
        if (NeedsSanitizerDeps) {
          linkSanitizerRuntimeDeps(ToolChain, CmdArgs);
        }
        // FIXME: For some reason GCC passes -lgcc and -lgcc_s before adding
        // the default system libraries. Just mimic this for now.
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          CmdArgs.push_back($("-lgcc_p"));
        } else {
          CmdArgs.push_back($("-lgcc"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
          CmdArgs.push_back($("-lgcc_eh"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          CmdArgs.push_back($("-lgcc_eh_p"));
        } else {
          CmdArgs.push_back($("--as-needed"));
          CmdArgs.push_back($("-lgcc_s"));
          CmdArgs.push_back($("--no-as-needed"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back($("-lpthread_p"));
          } else {
            CmdArgs.push_back($("-lpthread"));
          }
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
            CmdArgs.push_back($("-lc"));
          } else {
            CmdArgs.push_back($("-lc_p"));
          }
          CmdArgs.push_back($("-lgcc_p"));
        } else {
          CmdArgs.push_back($("-lc"));
          CmdArgs.push_back($("-lgcc"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
          CmdArgs.push_back($("-lgcc_eh"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
          CmdArgs.push_back($("-lgcc_eh_p"));
        } else {
          CmdArgs.push_back($("--as-needed"));
          CmdArgs.push_back($("-lgcc_s"));
          CmdArgs.push_back($("--no-as-needed"));
        }
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || IsPIE) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtendS.o")))));
        } else {
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtend.o")))));
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtn.o")))));
      }
      
      ToolChain.addProfileRTLibs(Args, CmdArgs);
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetLinkerPath())));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::freebsd::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 501,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 498,
   FQN="clang::driver::tools::freebsd::Linker::~Linker", NM="_ZN5clang6driver5tools7freebsd6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7freebsd6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class FreebsdStatics
