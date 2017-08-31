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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;
import static org.clang.driver.impl.ToolsStatics.*;
;


//<editor-fold defaultstate="collapsed" desc="static type MyriadStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6Myriad6LinkerE; -static-type=MyriadStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class MyriadStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Myriad::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 878,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 864,
 FQN="clang::driver::tools::Myriad::Linker", NM="_ZN5clang6driver5tools6Myriad6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6Myriad6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Myriad::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 880,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 866,
   FQN="clang::driver::tools::Myriad::Linker::Linker", NM="_ZN5clang6driver5tools6Myriad6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6Myriad6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("shave::Linker", "ld", TC)*/ 
    //START JInit
    super($("shave::Linker"), $("ld"), TC);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Myriad::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 881,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 867,
   FQN="clang::driver::tools::Myriad::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools6Myriad6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6Myriad6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Myriad::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 882,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 868,
   FQN="clang::driver::tools::Myriad::Linker::isLinkJob", NM="_ZNK5clang6driver5tools6Myriad6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6Myriad6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Myriad::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10867,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 10235,
   FQN="clang::driver::tools::Myriad::Linker::ConstructJob", NM="_ZNK5clang6driver5tools6Myriad6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools6Myriad6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ MyriadToolChain /*&*/ TC = ((/*static_cast*//*const*/ MyriadToolChain /*&*/ )(getToolChain()));
      /*const*/ Triple /*&*/ T = TC.getTriple();
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      boolean UseStartfiles = !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nostartfiles.getValue()));
      boolean UseDefaultLibs = !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()), new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()));
      if (T.getArch() == Triple.ArchType.sparc) {
        CmdArgs.push_back($("-EB"));
      } else { // SHAVE assumes little-endian, and sparcel is expressly so.
        CmdArgs.push_back($("-EL"));
      }
      
      // The remaining logic is mostly like gnutools::Linker::ConstructJob,
      // but we never pass through a --sysroot option and various other bits.
      // For example, there are no sanitizers (yet) nor gold linker.
      
      // Eat some arguments that may be present but have no effect.
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_static_libgcc.getValue()));
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_s.getValue()))) { // Pass the 'strip' option.
        CmdArgs.push_back($("-s"));
      }
      
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      if (UseStartfiles) {
        // If you want startfiles, it means you want the builtin crti and crtbegin,
        // but not crt0. Myriad link commands provide their own crt0.o as needed.
        CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crti.o")))));
        CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crtbegin.o")))));
      }
      
      Args.AddAllArgs(CmdArgs, /*{ */new ArrayRef<OptSpecifier>(new /*const*/ OptSpecifier [/*7*/] {
                new OptSpecifier(options.ID.OPT_L.getValue()), new OptSpecifier(options.ID.OPT_T_Group.getValue()),
                new OptSpecifier(options.ID.OPT_e.getValue()), new OptSpecifier(options.ID.OPT_s.getValue()), new OptSpecifier(options.ID.OPT_t.getValue()),
                new OptSpecifier(options.ID.OPT_Z_Flag.getValue()), new OptSpecifier(options.ID.OPT_r.getValue())})/* }*/);
      
      TC.AddFilePathLibArgs(Args, CmdArgs);
      
      AddLinkerInputs(getToolChain(), Inputs, Args, CmdArgs);
      if (UseDefaultLibs) {
        if (C.getDriver().CCCIsCXX()) {
          CmdArgs.push_back($("-lstdc++"));
        }
        if (T.getOS() == Triple.OSType.RTEMS) {
          CmdArgs.push_back($("--start-group"));
          CmdArgs.push_back($("-lc"));
          // You must provide your own "-L" option to enable finding these.
          CmdArgs.push_back($("-lrtemscpu"));
          CmdArgs.push_back($("-lrtemsbsp"));
          CmdArgs.push_back($("--end-group"));
        } else {
          CmdArgs.push_back($("-lc"));
        }
        CmdArgs.push_back($("-lgcc"));
      }
      if (UseStartfiles) {
        CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crtend.o")))));
        CmdArgs.push_back(Args.MakeArgString(new Twine(TC.GetFilePath($("crtn.o")))));
      }
      
      std.string Exec = new std.string(Args.MakeArgString(new Twine(TC.GetProgramPath($("sparc-myriad-elf-ld")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Args.MakeArgString(new Twine(Exec)), 
              CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::Myriad::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 878,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 864,
   FQN="clang::driver::tools::Myriad::Linker::~Linker", NM="_ZN5clang6driver5tools6Myriad6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools6Myriad6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class MyriadStatics
