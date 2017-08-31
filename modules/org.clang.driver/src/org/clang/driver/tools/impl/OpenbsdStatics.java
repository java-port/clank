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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import static org.clang.driver.impl.ToolsStatics.*;
;


//<editor-fold defaultstate="collapsed" desc="static type OpenbsdStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd6LinkerE;_ZN5clang6driver5tools7openbsd9AssemblerE; -static-type=OpenbsdStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class OpenbsdStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 430,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 427,
 FQN="clang::driver::tools::openbsd::Assembler", NM="_ZN5clang6driver5tools7openbsd9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 432,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 429,
   FQN="clang::driver::tools::openbsd::Assembler::Assembler", NM="_ZN5clang6driver5tools7openbsd9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("openbsd::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("openbsd::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 435,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 432,
   FQN="clang::driver::tools::openbsd::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7openbsd9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7openbsd9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8110,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7476,
   FQN="clang::driver::tools::openbsd::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools7openbsd9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7openbsd9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
      switch (getToolChain().getArch()) {
       case x86:
        // When building 32-bit code on OpenBSD/amd64, we have to explicitly
        // instruct as in the base system to assemble 32-bit code.
        CmdArgs.push_back($("--32"));
        break;
       case ppc:
        CmdArgs.push_back($("-mppc"));
        CmdArgs.push_back($("-many"));
        break;
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
       case mips64:
       case mips64el:
        {
          StringRef CPUName/*J*/= new StringRef();
          StringRef ABIName/*J*/= new StringRef();
          MipsStatics.getMipsCPUAndABI(Args, getToolChain().getTriple(), CPUName, ABIName);
          
          CmdArgs.push_back($("-mabi"));
          CmdArgs.push_back(getGnuCompatibleMipsABIName(/*NO_COPY*/ABIName).data());
          if (getToolChain().getArch() == Triple.ArchType.mips64) {
            CmdArgs.push_back($("-EB"));
          } else {
            CmdArgs.push_back($("-EL"));
          }
          
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
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("as")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 430,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 427,
   FQN="clang::driver::tools::openbsd::Assembler::~Assembler", NM="_ZN5clang6driver5tools7openbsd9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 443,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 440,
 FQN="clang::driver::tools::openbsd::Linker", NM="_ZN5clang6driver5tools7openbsd6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 445,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 442,
   FQN="clang::driver::tools::openbsd::Linker::Linker", NM="_ZN5clang6driver5tools7openbsd6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("openbsd::Linker", "linker", TC)*/ 
    //START JInit
    super($("openbsd::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 447,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 444,
   FQN="clang::driver::tools::openbsd::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7openbsd6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7openbsd6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 448,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 445,
   FQN="clang::driver::tools::openbsd::Linker::isLinkJob", NM="_ZNK5clang6driver5tools7openbsd6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7openbsd6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8181,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7547,
   FQN="clang::driver::tools::openbsd::Linker::ConstructJob", NM="_ZNK5clang6driver5tools7openbsd6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7openbsd6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
      
      // Silence warning for "clang -g foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      // and "clang -emit-llvm foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      // and for "clang -w foo.o -o foo". Other warning options are already
      // handled somewhere else.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      if (getToolChain().getArch() == Triple.ArchType.mips64) {
        CmdArgs.push_back($("-EB"));
      } else if (getToolChain().getArch() == Triple.ArchType.mips64el) {
        CmdArgs.push_back($("-EL"));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_shared.getValue()))) {
        CmdArgs.push_back($("-e"));
        CmdArgs.push_back($("__start"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
        CmdArgs.push_back($("-Bstatic"));
      } else {
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
          CmdArgs.push_back($("-export-dynamic"));
        }
        CmdArgs.push_back($("--eh-frame-hdr"));
        CmdArgs.push_back($("-Bdynamic"));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back($("-shared"));
        } else {
          CmdArgs.push_back($("-dynamic-linker"));
          CmdArgs.push_back($("/usr/libexec/ld.so"));
        }
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_nopie.getValue()))) {
        CmdArgs.push_back($("-nopie"));
      }
      if (Output.isFilename()) {
        CmdArgs.push_back($("-o"));
        CmdArgs.push_back(Output.getFilename());
      } else {
        assert (Output.isNothing()) : "Invalid output.";
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("gcrt0.o")))));
          } else {
            CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crt0.o")))));
          }
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtbegin.o")))));
        } else {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtbeginS.o")))));
        }
      }
      
      std.string Triple = getToolChain().getTripleString();
      if ($eq_str$C_T(Triple.substr(0, 6), /*KEEP_STR*/"x86_64")) {
        Triple.replace(0, 6, $("amd64"));
      }
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_str_T($add_T_str$C(/*KEEP_STR*/"-L/usr/lib/gcc-lib/", Triple), /*KEEP_STR*/"/4.2.1"))));
      
      Args.AddAllArgs(CmdArgs, /*{ */new ArrayRef<OptSpecifier>(new /*const*/ OptSpecifier [/*7*/] {
                new OptSpecifier(options.ID.OPT_L.getValue()), 
                new OptSpecifier(options.ID.OPT_T_Group.getValue()), 
                new OptSpecifier(options.ID.OPT_e.getValue()), 
                new OptSpecifier(options.ID.OPT_s.getValue()), 
                new OptSpecifier(options.ID.OPT_t.getValue()), 
                new OptSpecifier(options.ID.OPT_Z_Flag.getValue()), 
                new OptSpecifier(options.ID.OPT_r.getValue())})/* }*/);
      
      AddLinkerInputs(getToolChain(), Inputs, Args, CmdArgs);
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        if (D.CCCIsCXX()) {
          getToolChain().AddCXXStdlibLibArgs(Args, CmdArgs);
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back($("-lm_p"));
          } else {
            CmdArgs.push_back($("-lm"));
          }
        }
        
        // FIXME: For some reason GCC passes -lgcc before adding
        // the default system libraries. Just mimic this for now.
        CmdArgs.push_back($("-lgcc"));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
          if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) && Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back($("-lpthread_p"));
          } else {
            CmdArgs.push_back($("-lpthread"));
          }
        }
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()))) {
            CmdArgs.push_back($("-lc_p"));
          } else {
            CmdArgs.push_back($("-lc"));
          }
        }
        
        CmdArgs.push_back($("-lgcc"));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtend.o")))));
        } else {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtendS.o")))));
        }
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetLinkerPath())));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::openbsd::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 443,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 440,
   FQN="clang::driver::tools::openbsd::Linker::~Linker", NM="_ZN5clang6driver5tools7openbsd6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7openbsd6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class OpenbsdStatics
