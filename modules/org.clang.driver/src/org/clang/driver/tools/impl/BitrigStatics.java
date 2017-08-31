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
import static org.llvm.support.llvm.*;
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


//<editor-fold defaultstate="collapsed" desc="static type BitrigStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig6LinkerE;_ZN5clang6driver5tools6bitrig9AssemblerE; -static-type=BitrigStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class BitrigStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 459,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 456,
 FQN="clang::driver::tools::bitrig::Assembler", NM="_ZN5clang6driver5tools6bitrig9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 461,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 458,
   FQN="clang::driver::tools::bitrig::Assembler::Assembler", NM="_ZN5clang6driver5tools6bitrig9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("bitrig::Assembler", "assembler", TC)*/ 
    //START JInit
    super($("bitrig::Assembler"), $("assembler"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 464,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 461,
   FQN="clang::driver::tools::bitrig::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6bitrig9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6bitrig9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8303,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7669,
   FQN="clang::driver::tools::bitrig::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools6bitrig9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6bitrig9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 459,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 456,
   FQN="clang::driver::tools::bitrig::Assembler::~Assembler", NM="_ZN5clang6driver5tools6bitrig9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }
  
  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 472,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 469,
 FQN="clang::driver::tools::bitrig::Linker", NM="_ZN5clang6driver5tools6bitrig6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 474,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 471,
   FQN="clang::driver::tools::bitrig::Linker::Linker", NM="_ZN5clang6driver5tools6bitrig6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("bitrig::Linker", "linker", TC)*/ 
    //START JInit
    super($("bitrig::Linker"), $("linker"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 476,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 473,
   FQN="clang::driver::tools::bitrig::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6bitrig6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6bitrig6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 477,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 474,
   FQN="clang::driver::tools::bitrig::Linker::isLinkJob", NM="_ZNK5clang6driver5tools6bitrig6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6bitrig6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 8323,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 7689,
   FQN="clang::driver::tools::bitrig::Linker::ConstructJob", NM="_ZNK5clang6driver5tools6bitrig6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6bitrig6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
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
      
      Args.AddAllArgs(CmdArgs, 
          /*{ */new ArrayRef<OptSpecifier>(new /*const*/ OptSpecifier [/*3*/] {
            new OptSpecifier(options.ID.OPT_L.getValue()), 
            new OptSpecifier(options.ID.OPT_T_Group.getValue()), 
            new OptSpecifier(options.ID.OPT_e.getValue())})/* }*/);
      
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
        
        StringRef MyArch/*J*/= new StringRef();
        switch (getToolChain().getArch()) {
         case arm:
          MyArch.$assignMove(/*STRINGREF_STR*/"arm");
          break;
         case x86:
          MyArch.$assignMove(/*STRINGREF_STR*/"i386");
          break;
         case x86_64:
          MyArch.$assignMove(/*STRINGREF_STR*/"amd64");
          break;
         default:
          throw new llvm_unreachable("Unsupported architecture");
        }
        CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-lclang_rt.", MyArch)));
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

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::bitrig::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 472,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 469,
   FQN="clang::driver::tools::bitrig::Linker::~Linker", NM="_ZN5clang6driver5tools6bitrig6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6bitrig6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }
  
  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class BitrigStatics
