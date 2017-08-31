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
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;
;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
;

//<editor-fold defaultstate="collapsed" desc="static type NacltoolsStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools12AssemblerARME;_ZN5clang6driver5tools9nacltools6LinkerE; -static-type=NacltoolsStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class NacltoolsStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::AssemblerARM">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 573,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 570,
 FQN="clang::driver::tools::nacltools::AssemblerARM", NM="_ZN5clang6driver5tools9nacltools12AssemblerARME",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools12AssemblerARME")
//</editor-fold>
public static class AssemblerARM extends /*public*/ GnutoolsStatics.Assembler implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::AssemblerARM::AssemblerARM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 575,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 572,
   FQN="clang::driver::tools::nacltools::AssemblerARM::AssemblerARM", NM="_ZN5clang6driver5tools9nacltools12AssemblerARMC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools12AssemblerARMC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public AssemblerARM(/*const*/ ToolChain /*&*/ TC) {
    /* : Assembler(TC)*/ 
    //START JInit
    super(TC);
    //END JInit
  }

  
  
  // NaCl ARM assembly (inline or standalone) can be written with a set of macros
  // for the various SFI requirements like register masking. The assembly tool
  // inserts the file containing the macros as an input into all the assembly
  // jobs.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::AssemblerARM::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9593,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 8986,
   FQN="clang::driver::tools::nacltools::AssemblerARM::ConstructJob", NM="_ZNK5clang6driver5tools9nacltools12AssemblerARM12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9nacltools12AssemblerARM12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    /*const*/ NaClToolChain /*&*/ ToolChain = ((/*static_cast*//*const*/ NaClToolChain /*&*/ )(getToolChain()));
    InputInfo NaClMacros/*J*/= new InputInfo(types.ID.TY_PP_Asm, ToolChain.GetNaClArmMacrosPath(), 
        $("nacl-arm-macros.s"));
    /*InputInfoList*/SmallVector<InputInfo> NewInputs/*J*/= new /*InputInfoList*/SmallVector<InputInfo>(4, new InputInfo());
    NewInputs.push_back(NaClMacros);
    NewInputs.append_T(Inputs.begin(), Inputs.end());
    super.ConstructJob(C, JA, Output, NewInputs, Args, 
        LinkingOutput);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::AssemblerARM::~AssemblerARM">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 573,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 570,
   FQN="clang::driver::tools::nacltools::AssemblerARM::~AssemblerARM", NM="_ZN5clang6driver5tools9nacltools12AssemblerARMD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools12AssemblerARMD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 583,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 580,
 FQN="clang::driver::tools::nacltools::Linker", NM="_ZN5clang6driver5tools9nacltools6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 585,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 582,
   FQN="clang::driver::tools::nacltools::Linker::Linker", NM="_ZN5clang6driver5tools9nacltools6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("NaCl::Linker", "linker", TC)*/ 
    //START JInit
    super($("NaCl::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 587,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 584,
   FQN="clang::driver::tools::nacltools::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools9nacltools6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9nacltools6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 588,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 585,
   FQN="clang::driver::tools::nacltools::Linker::isLinkJob", NM="_ZNK5clang6driver5tools9nacltools6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9nacltools6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  
  // This is quite similar to gnutools::Linker::ConstructJob with changes that
  // we use static by default, do not yet support sanitizers or LTO, and a few
  // others. Eventually we can support more of that and hopefully migrate back
  // to gnutools::Linker.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9613,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9006,
   FQN="clang::driver::tools::nacltools::Linker::ConstructJob", NM="_ZNK5clang6driver5tools9nacltools6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9nacltools6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ NaClToolChain /*&*/ ToolChain = ((/*static_cast*//*const*/ NaClToolChain /*&*/ )(getToolChain()));
      /*const*/ Driver /*&*/ D = ToolChain.getDriver();
      /*const*/ Triple.ArchType Arch = ToolChain.getArch();
      /*const*/boolean IsStatic = !Args.hasArg(new OptSpecifier(options.ID.OPT_dynamic.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()));
      
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      // Silence warning for "clang -g foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      // and "clang -emit-llvm foo.o -o foo"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      // and for "clang -w foo.o -o foo". Other warning options are already
      // handled somewhere else.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      if (!D.SysRoot.empty()) {
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_str$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_rdynamic.getValue()))) {
        CmdArgs.push_back($("-export-dynamic"));
      }
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_s.getValue()))) {
        CmdArgs.push_back($("-s"));
      }
      
      // NaClToolChain doesn't have ExtraOpts like Linux; the only relevant flag
      // from there is --build-id, which we do want.
      CmdArgs.push_back($("--build-id"));
      if (!IsStatic) {
        CmdArgs.push_back($("--eh-frame-hdr"));
      }
      
      CmdArgs.push_back($("-m"));
      if (Arch == Triple.ArchType.x86) {
        CmdArgs.push_back($("elf_i386_nacl"));
      } else if (Arch == Triple.ArchType.arm) {
        CmdArgs.push_back($("armelf_nacl"));
      } else if (Arch == Triple.ArchType.x86_64) {
        CmdArgs.push_back($("elf_x86_64_nacl"));
      } else if (Arch == Triple.ArchType.mipsel) {
        CmdArgs.push_back($("mipselelf_nacl"));
      } else {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_target_unsupported_arch)), ToolChain.getArchName()), 
            /*KEEP_STR*/"Native Client"));
      }
      if (IsStatic) {
        CmdArgs.push_back($("-static"));
      } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
        CmdArgs.push_back($("-shared"));
      }
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crt1.o")))));
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crti.o")))));
        
        /*const*/char$ptr/*char P*/ crtbegin;
        if (IsStatic) {
          crtbegin = $tryClone($("crtbeginT.o"));
        } else if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
          crtbegin = $tryClone($("crtbeginS.o"));
        } else {
          crtbegin = $tryClone($("crtbegin.o"));
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crtbegin))));
      }
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_L.getValue()));
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_u.getValue()));
      
      ToolChain.AddFilePathLibArgs(Args, CmdArgs);
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_Z_Xlinker__no_demangle.getValue()))) {
        CmdArgs.push_back($("--no-demangle"));
      }
      
      AddLinkerInputs(ToolChain, Inputs, Args, CmdArgs);
      if (D.CCCIsCXX()
         && !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        boolean OnlyLibstdcxxStatic = Args.hasArg(new OptSpecifier(options.ID.OPT_static_libstdcxx.getValue())) && !IsStatic;
        if (OnlyLibstdcxxStatic) {
          CmdArgs.push_back($("-Bstatic"));
        }
        ToolChain.AddCXXStdlibLibArgs(Args, CmdArgs);
        if (OnlyLibstdcxxStatic) {
          CmdArgs.push_back($("-Bdynamic"));
        }
        CmdArgs.push_back($("-lm"));
      }
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))) {
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
          // Always use groups, since it has no effect on dynamic libraries.
          CmdArgs.push_back($("--start-group"));
          CmdArgs.push_back($("-lc"));
          // NaCl's libc++ currently requires libpthread, so just always include it
          // in the group for C++.
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))
             || Args.hasArg(new OptSpecifier(options.ID.OPT_pthreads.getValue())) || D.CCCIsCXX()) {
            // Gold, used by Mips, handles nested groups differently than ld, and
            // without '-lnacl' it prefers symbols from libpthread.a over libnacl.a,
            // which is not a desired behaviour here.
            // See https://sourceware.org/ml/binutils/2015-03/msg00034.html
            if (getToolChain().getArch() == Triple.ArchType.mipsel) {
              CmdArgs.push_back($("-lnacl"));
            }
            
            CmdArgs.push_back($("-lpthread"));
          }
          
          CmdArgs.push_back($("-lgcc"));
          CmdArgs.push_back($("--as-needed"));
          if (IsStatic) {
            CmdArgs.push_back($("-lgcc_eh"));
          } else {
            CmdArgs.push_back($("-lgcc_s"));
          }
          CmdArgs.push_back($("--no-as-needed"));
          
          // Mips needs to create and use pnacl_legacy library that contains
          // definitions from bitcode/pnaclmm.c and definitions for
          // __nacl_tp_tls_offset() and __nacl_tp_tdb_offset().
          if (getToolChain().getArch() == Triple.ArchType.mipsel) {
            CmdArgs.push_back($("-lpnacl_legacy"));
          }
          
          CmdArgs.push_back($("--end-group"));
        }
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostartfiles.getValue()))) {
          /*const*/char$ptr/*char P*/ crtend;
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
            crtend = $tryClone($("crtendS.o"));
          } else {
            crtend = $tryClone($("crtend.o"));
          }
          
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath(crtend))));
          CmdArgs.push_back(Args.MakeArgString(new Twine(ToolChain.GetFilePath($("crtn.o")))));
        }
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(ToolChain.GetLinkerPath())));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::nacltools::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 583,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 580,
   FQN="clang::driver::tools::nacltools::Linker::~Linker", NM="_ZN5clang6driver5tools9nacltools6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9nacltools6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class NacltoolsStatics
