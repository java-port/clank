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
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import static org.clang.driver.impl.ToolsStatics.*;
;


//<editor-fold defaultstate="collapsed" desc="static type DragonflyStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly6LinkerE;_ZN5clang6driver5tools9dragonfly9AssemblerE; -static-type=DragonflyStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class DragonflyStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 657,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 654,
 FQN="clang::driver::tools::dragonfly::Assembler", NM="_ZN5clang6driver5tools9dragonfly9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 659,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 656,
   FQN="clang::driver::tools::dragonfly::Assembler::Assembler", NM="_ZN5clang6driver5tools9dragonfly9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("dragonfly::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("dragonfly::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 662,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 659,
   FQN="clang::driver::tools::dragonfly::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools9dragonfly9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9dragonfly9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  
  /// DragonFly Tools
  
  // For now, DragonFly Assemble does just about the same as for
  // FreeBSD, but this may change soon.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9836,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9229,
   FQN="clang::driver::tools::dragonfly::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools9dragonfly9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9dragonfly9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
      
      // When building 32-bit code on DragonFly/pc64, we have to explicitly
      // instruct as in the base system to assemble 32-bit code.
      if (getToolChain().getArch() == Triple.ArchType.x86) {
        CmdArgs.push_back($("--32"));
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

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 657,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 654,
   FQN="clang::driver::tools::dragonfly::Assembler::~Assembler", NM="_ZN5clang6driver5tools9dragonfly9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 670,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 667,
 FQN="clang::driver::tools::dragonfly::Linker", NM="_ZN5clang6driver5tools9dragonfly6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 672,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 669,
   FQN="clang::driver::tools::dragonfly::Linker::Linker", NM="_ZN5clang6driver5tools9dragonfly6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("dragonfly::Linker", "linker", TC)*/ 
    //START JInit
    super($("dragonfly::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 674,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 671,
   FQN="clang::driver::tools::dragonfly::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools9dragonfly6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9dragonfly6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 675,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 672,
   FQN="clang::driver::tools::dragonfly::Linker::isLinkJob", NM="_ZNK5clang6driver5tools9dragonfly6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9dragonfly6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 9861,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 9254,
   FQN="clang::driver::tools::dragonfly::Linker::ConstructJob", NM="_ZNK5clang6driver5tools9dragonfly6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools9dragonfly6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_T_str$C(/*KEEP_STR*/"--sysroot=", D.SysRoot))));
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
          CmdArgs.push_back($("/usr/libexec/ld-elf.so.2"));
        }
        CmdArgs.push_back($("--hash-style=gnu"));
        CmdArgs.push_back($("--enable-new-dtags"));
      }
      
      // When building 32-bit code on DragonFly/pc64, we have to explicitly
      // instruct ld in the base system to link 32-bit code.
      if (getToolChain().getArch() == Triple.ArchType.x86) {
        CmdArgs.push_back($("-m"));
        CmdArgs.push_back($("elf_i386"));
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
            CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("gcrt1.o")))));
          } else {
            if (Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
              CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("Scrt1.o")))));
            } else {
              CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crt1.o")))));
            }
          }
        }
        CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crti.o")))));
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue())) || Args.hasArg(new OptSpecifier(options.ID.OPT_pie.getValue()))) {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtbeginS.o")))));
        } else {
          CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().GetFilePath($("crtbegin.o")))));
        }
      }
      
      Args.AddAllArgs(CmdArgs, 
          /*{ */new ArrayRef<OptSpecifier>(new /*const*/ OptSpecifier [/*3*/] {
            new OptSpecifier(options.ID.OPT_L.getValue()),
            new OptSpecifier(options.ID.OPT_T_Group.getValue()),
            new OptSpecifier(options.ID.OPT_e.getValue())})/* }*/);
      
      AddLinkerInputs(getToolChain(), Inputs, Args, CmdArgs);
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))) {
        CmdArgs.push_back($("-L/usr/lib/gcc50"));
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
          CmdArgs.push_back($("-rpath"));
          CmdArgs.push_back($("/usr/lib/gcc50"));
        }
        if (D.CCCIsCXX()) {
          getToolChain().AddCXXStdlibLibArgs(Args, CmdArgs);
          CmdArgs.push_back($("-lm"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_pthread.getValue()))) {
          CmdArgs.push_back($("-lpthread"));
        }
        if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nolibc.getValue()))) {
          CmdArgs.push_back($("-lc"));
        }
        if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))
           || Args.hasArg(new OptSpecifier(options.ID.OPT_static_libgcc.getValue()))) {
          CmdArgs.push_back($("-lgcc"));
          CmdArgs.push_back($("-lgcc_eh"));
        } else {
          if (Args.hasArg(new OptSpecifier(options.ID.OPT_shared_libgcc.getValue()))) {
            CmdArgs.push_back($("-lgcc_pic"));
            if (!Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()))) {
              CmdArgs.push_back($("-lgcc"));
            }
          } else {
            CmdArgs.push_back($("-lgcc"));
            CmdArgs.push_back($("--as-needed"));
            CmdArgs.push_back($("-lgcc_pic"));
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

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::dragonfly::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 670,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 667,
   FQN="clang::driver::tools::dragonfly::Linker::~Linker", NM="_ZN5clang6driver5tools9dragonfly6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools9dragonfly6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class DragonflyStatics
