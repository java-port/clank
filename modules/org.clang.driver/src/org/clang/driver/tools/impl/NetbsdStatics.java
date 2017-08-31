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
import static org.clang.driver.impl.ToolsStatics.*;


//<editor-fold defaultstate="collapsed" desc="static type NetbsdStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd6LinkerE;_ZN5clang6driver5tools6netbsd9AssemblerE; -static-type=NetbsdStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class NetbsdStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 517,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 514,
 FQN="clang::driver::tools::netbsd::Assembler", NM="_ZN5clang6driver5tools6netbsd9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 519,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 516,
   FQN="clang::driver::tools::netbsd::Assembler::Assembler", NM="_ZN5clang6driver5tools6netbsd9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("netbsd::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("netbsd::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 522,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 519,
   FQN="clang::driver::tools::netbsd::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6netbsd9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6netbsd9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8717,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8081,
   FQN="clang::driver::tools::netbsd::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools6netbsd9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6netbsd9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
      
      // GNU as needs different flags for creating the correct output format
      // on architectures with different ABIs or optional feature sets.
      switch (getToolChain().getArch()) {
       case x86:
        CmdArgs.push_back($("--32"));
        break;
       case arm:
       case armeb:
       case thumb:
       case thumbeb:
        {
          StringRef MArch/*J*/= new StringRef(), MCPU/*J*/= new StringRef();
          getARMArchCPUFromArgs(Args, MArch, MCPU, /*FromAs*/ true);
          std.string Arch = ArmStatics.getARMTargetCPU(new StringRef(MCPU), new StringRef(MArch), getToolChain().getTriple());
          CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"-mcpu=", Arch))));
          break;
        }
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
          
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       case sparc:
       case sparcel:
        {
          CmdArgs.push_back($("-32"));
          std.string CPU = getCPUName(Args, getToolChain().getTriple());
          CmdArgs.push_back(getSparcAsmModeForCPU(new StringRef(CPU), getToolChain().getTriple()));
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       case sparcv9:
        {
          CmdArgs.push_back($("-64"));
          std.string CPU = getCPUName(Args, getToolChain().getTriple());
          CmdArgs.push_back(getSparcAsmModeForCPU(new StringRef(CPU), getToolChain().getTriple()));
          AddAssemblerKPIC(getToolChain(), Args, CmdArgs);
          break;
        }
       default:
        break;
      }
      
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      
      for (/*const*/ InputInfo /*&*/ II : Inputs)  {
        CmdArgs.push_back(II.getFilename());
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine((getToolChain().GetProgramPath($("as"))))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 517,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 514,
   FQN="clang::driver::tools::netbsd::Assembler::~Assembler", NM="_ZN5clang6driver5tools6netbsd9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 530,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 527,
 FQN="clang::driver::tools::netbsd::Linker", NM="_ZN5clang6driver5tools6netbsd6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 532,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 529,
   FQN="clang::driver::tools::netbsd::Linker::Linker", NM="_ZN5clang6driver5tools6netbsd6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("netbsd::Linker", "linker", TC)*/ 
    //START JInit
    super($("netbsd::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 534,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 531,
   FQN="clang::driver::tools::netbsd::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6netbsd6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6netbsd6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 535,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 532,
   FQN="clang::driver::tools::netbsd::Linker::isLinkJob", NM="_ZNK5clang6driver5tools6netbsd6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6netbsd6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8800,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8164,
   FQN="clang::driver::tools::netbsd::Linker::ConstructJob", NM="_ZNK5clang6driver5tools6netbsd6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6netbsd6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Driver /*&*/ D = getToolChain().getDriver();
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      if (!D.SysRoot.empty()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_string$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
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
          Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_pie.getValue()));
          CmdArgs.push_back($("-dynamic-linker"));
          CmdArgs.push_back($("/libexec/ld.elf_so"));
        }
      }
      
      // Many NetBSD architectures support more than one ABI.
      // Determine the correct emulation for ld.
      switch (getToolChain().getArch()) {
       case x86:
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf_i386"));
        break;
       case arm:
       case thumb:
        CmdArgs.push_back($("-m"));
        switch (getToolChain().getTriple().getEnvironment()) {
         case EABI:
         case GNUEABI:
          CmdArgs.push_back($("armelf_nbsd_eabi"));
          break;
         case EABIHF:
         case GNUEABIHF:
          CmdArgs.push_back($("armelf_nbsd_eabihf"));
          break;
         default:
          CmdArgs.push_back($("armelf_nbsd"));
          break;
        }
        break;
       case armeb:
       case thumbeb:
        ArmStatics.appendEBLinkFlags(Args, CmdArgs, 
            new Triple(new Twine(getToolChain().ComputeEffectiveClangTriple(Args))));
        CmdArgs.push_back($("-m"));
        switch (getToolChain().getTriple().getEnvironment()) {
         case EABI:
         case GNUEABI:
          CmdArgs.push_back($("armelfb_nbsd_eabi"));
          break;
         case EABIHF:
         case GNUEABIHF:
          CmdArgs.push_back($("armelfb_nbsd_eabihf"));
          break;
         default:
          CmdArgs.push_back($("armelfb_nbsd"));
          break;
        }
        break;
       case mips64:
       case mips64el:
        if (MipsStatics.hasMipsAbiArg(Args, $("32"))) {
          CmdArgs.push_back($("-m"));
          if (getToolChain().getArch() == Triple.ArchType.mips64) {
            CmdArgs.push_back($("elf32btsmip"));
          } else {
            CmdArgs.push_back($("elf32ltsmip"));
          }
        } else if (MipsStatics.hasMipsAbiArg(Args, $("64"))) {
          CmdArgs.push_back($("-m"));
          if (getToolChain().getArch() == Triple.ArchType.mips64) {
            CmdArgs.push_back($("elf64btsmip"));
          } else {
            CmdArgs.push_back($("elf64ltsmip"));
          }
        }
        break;
       case ppc:
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf32ppc_nbsd"));
        break;
       case ppc64:
       case ppc64le:
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf64ppc"));
        break;
       case sparc:
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf32_sparc"));
        break;
       case sparcv9:
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf64_sparc"));
        break;
       default:
        break;
      }
      if (Output.isFilename()) {
        CmdArgs.push_back($("-o"));
        CmdArgs.push_back(Output.getFilename());
      } else {
        assert (Output.isNothing()) : "Invalid output.";
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crt0.o")))));
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crti.o")))));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtbeginS.o")))));
        } else {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtbegin.o")))));
        }
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_T_Group.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_e.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_s.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_t.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_Z_Flag.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_r.getValue()));
      
      AddLinkerInputs(getToolChain(), Inputs, Args, CmdArgs);
      
      /*uint*/uint$ref Major = create_uint$ref(), Minor = create_uint$ref(), Micro = create_uint$ref();

      getToolChain().getTriple().getOSVersion(Major, Minor, Micro);
      boolean useLibgcc = true;
      if ($greatereq_uint(Major, 7) || Major.$deref() == 0) {
        switch (getToolChain().getArch()) {
         case aarch64:
         case arm:
         case armeb:
         case thumb:
         case thumbeb:
         case ppc:
         case ppc64:
         case ppc64le:
         case sparc:
         case sparcv9:
         case x86:
         case x86_64:
          useLibgcc = false;
          break;
         default:
          break;
        }
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        addOpenMPRuntime(CmdArgs, getToolChain(), Args);
        if (D.CCCIsCXX()) {
          getToolChain().AddCXXStdlibLibArgs(Args, CmdArgs);
          CmdArgs.push_back($("-lm"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
          CmdArgs.push_back($("-lpthread"));
        }
        CmdArgs.push_back($("-lc"));
        if (useLibgcc) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
            // libgcc_eh depends on libc, so resolve as much as possible,
            // pull in any new requirements from libc and then get the rest
            // of libgcc.
            CmdArgs.push_back($("-lgcc_eh"));
            CmdArgs.push_back($("-lc"));
            CmdArgs.push_back($("-lgcc"));
          } else {
            CmdArgs.push_back($("-lgcc"));
            CmdArgs.push_back($("--as-needed"));
            CmdArgs.push_back($("-lgcc_s"));
            CmdArgs.push_back($("--no-as-needed"));
          }
        }
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtendS.o")))));
        } else {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtend.o")))));
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtn.o")))));
      }
      
      getToolChain().addProfileRTLibs(Args, CmdArgs);
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetLinkerPath())));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::netbsd::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 530,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 527,
   FQN="clang::driver::tools::netbsd::Linker::~Linker", NM="_ZN5clang6driver5tools6netbsd6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6netbsd6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class NetbsdStatics
