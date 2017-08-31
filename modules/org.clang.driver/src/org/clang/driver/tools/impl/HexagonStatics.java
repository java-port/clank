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

import org.clang.driver.toolchains.impl.HexagonToolChain;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.llvm.adt.ADTAliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
;


//<editor-fold defaultstate="collapsed" desc="static type HexagonStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon6LinkerE;_ZN5clang6driver5tools7hexagon9AssemblerE; -static-type=HexagonStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class HexagonStatics {

// For Hexagon, we do not need to instantiate tools for PreProcess, PreCompile
// and Compile.
// We simply use "clang -cc1" for those actions.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 209,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 208,
 FQN="clang::driver::tools::hexagon::Assembler", NM="_ZN5clang6driver5tools7hexagon9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 211,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 210,
   FQN="clang::driver::tools::hexagon::Assembler::Assembler", NM="_ZN5clang6driver5tools7hexagon9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("hexagon::Assembler", "hexagon-as", TC)*/ 
    //START JInit
    super($("hexagon::Assembler"), $("hexagon-as"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 214,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 213,
   FQN="clang::driver::tools::hexagon::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7hexagon9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  
  // Hexagon tools start.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Assembler::RenderExtraToolArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6812,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6252,
   FQN="clang::driver::tools::hexagon::Assembler::RenderExtraToolArgs", NM="_ZNK5clang6driver5tools7hexagon9Assembler19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon9Assembler19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void RenderExtraToolArgs(/*const*/ JobAction /*&*/ JA, 
                     ArgStringList/*&*/ CmdArgs) /*const*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6816,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6256,
   FQN="clang::driver::tools::hexagon::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools7hexagon9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      claimNoWarnArgs(Args);
      
      /*const*/ HexagonToolChain /*&*/ HTC = ((/*static_cast*//*const*/ HexagonToolChain /*&*/ )(getToolChain()));
      /*const*/ Driver /*&*/ D = HTC.getDriver();
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      std.string MArchString = new std.string(/*KEEP_STR*/"-march=hexagon");
      CmdArgs.push_back(Args.MakeArgString(new Twine(MArchString)));
      
      RenderExtraToolArgs(JA, CmdArgs);
      
      std.string AsName = new std.string(/*KEEP_STR*/"hexagon-llvm-mc");
      std.string MCpuString = $add_T_str(/*KEEP_STR*/"-mcpu=hexagon", 
          HexagonToolChain.GetTargetCPUVersion(Args).str());
      CmdArgs.push_back($("-filetype=obj"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(MCpuString)));
      if (Output.isFilename()) {
        CmdArgs.push_back($("-o"));
        CmdArgs.push_back(Output.getFilename());
      } else {
        assert (Output.isNothing()) : "Unexpected output";
        CmdArgs.push_back($("-fsyntax-only"));
      }
      {
        
        OptionalUInt G = HexagonToolChain.getSmallDataThreshold(Args);
        if (G.$bool()) {
          std.string N = llvm.utostr($uint2ulong(G.getValue()));
          CmdArgs.push_back(Args.MakeArgString(new Twine($add_str_str$C(new std.string(/*KEEP_STR*/"-gpsize="), N))));
        }
      }
      
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      
      // Only pass -x if gcc will understand it; otherwise hope gcc
      // understands the suffix correctly. The main use case this would go
      // wrong in is for linker inputs if they happened to have an odd
      // suffix; really the only way to get this to happen is a command
      // like '-x foobar a.c' which will treat a.c like a linker input.
      //
      // FIXME: For the linker case specifically, can we safely convert
      // inputs into '-Wl,' options?
      for (/*const*/ InputInfo /*&*/ II : Inputs) {
        // Don't try to pass LLVM or AST inputs to a generic gcc.
        if (types.isLLVMIR(II.getType())) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_linker_llvm_support)), 
              new StringRef(HTC.getTripleString())));
        } else if (II.getType() == types.ID.TY_AST) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_ast_support)), 
              new StringRef(HTC.getTripleString())));
        } else if (II.getType() == types.ID.TY_ModuleFile) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_module_support)), 
              new StringRef(HTC.getTripleString())));
        }
        if (II.isFilename()) {
          CmdArgs.push_back(II.getFilename());
        } else {
          // Don't render as input, we need gcc to do the translations.
          // FIXME: What is this?
          II.getInputArg().render(Args, CmdArgs);
        }
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(HTC.GetProgramPath(AsName.c_str()))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 209,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 208,
   FQN="clang::driver::tools::hexagon::Assembler::~Assembler", NM="_ZN5clang6driver5tools7hexagon9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 224,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 223,
 FQN="clang::driver::tools::hexagon::Linker", NM="_ZN5clang6driver5tools7hexagon6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 226,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 225,
   FQN="clang::driver::tools::hexagon::Linker::Linker", NM="_ZN5clang6driver5tools7hexagon6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool("hexagon::Linker", "hexagon-ld", TC)*/ 
    //START JInit
    super($("hexagon::Linker"), $("hexagon-ld"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 228,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 227,
   FQN="clang::driver::tools::hexagon::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7hexagon6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 229,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 228,
   FQN="clang::driver::tools::hexagon::Linker::isLinkJob", NM="_ZNK5clang6driver5tools7hexagon6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker::RenderExtraToolArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6885,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6325,
   FQN="clang::driver::tools::hexagon::Linker::RenderExtraToolArgs", NM="_ZNK5clang6driver5tools7hexagon6Linker19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon6Linker19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void RenderExtraToolArgs(/*const*/ JobAction /*&*/ JA, 
                     ArgStringList/*&*/ CmdArgs) /*const*/ {
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 7059,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6499,
   FQN="clang::driver::tools::hexagon::Linker::ConstructJob", NM="_ZNK5clang6driver5tools7hexagon6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7hexagon6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ HexagonToolChain /*&*/ HTC = ((/*static_cast*//*const*/ HexagonToolChain /*&*/ )(getToolChain()));
      
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      constructHexagonLinkArgs(C, JA, HTC, Output, Inputs, Args, CmdArgs, 
          LinkingOutput);
      
      std.string Linker = HTC.GetProgramPath($("hexagon-link"));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Args.MakeArgString(new Twine(Linker)), 
              CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::hexagon::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 224,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 223,
   FQN="clang::driver::tools::hexagon::Linker::~Linker", NM="_ZN5clang6driver5tools7hexagon6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7hexagon6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class HexagonStatics
