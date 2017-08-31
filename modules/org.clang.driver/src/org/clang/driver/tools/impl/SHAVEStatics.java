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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import static org.clang.driver.java.JavaDriverSupport.*;


//<editor-fold defaultstate="collapsed" desc="static type SHAVEStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE8CompilerE;_ZN5clang6driver5tools5SHAVE9AssemblerE; -static-type=SHAVEStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class SHAVEStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Compiler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 848,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 834,
 FQN="clang::driver::tools::SHAVE::Compiler", NM="_ZN5clang6driver5tools5SHAVE8CompilerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE8CompilerE")
//</editor-fold>
public static class Compiler extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Compiler::Compiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 850,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 836,
   FQN="clang::driver::tools::SHAVE::Compiler::Compiler", NM="_ZN5clang6driver5tools5SHAVE8CompilerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE8CompilerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Compiler(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("moviCompile", "movicompile", TC)*/ 
    //START JInit
    super($("moviCompile"), $("movicompile"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Compiler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 852,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 838,
   FQN="clang::driver::tools::SHAVE::Compiler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5SHAVE8Compiler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5SHAVE8Compiler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Compiler::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10777,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 10146,
   FQN="clang::driver::tools::SHAVE::Compiler::ConstructJob", NM="_ZNK5clang6driver5tools5SHAVE8Compiler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5SHAVE8Compiler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      assert (Inputs.size() == 1);
      /*const*/ InputInfo /*&*/ II = Inputs.$at(0);
      assert (II.getType() == types.ID.TY_C || II.getType() == types.ID.TY_CXX || II.getType() == types.ID.TY_PP_CXX);
      if (JA.getKind() == Action.ActionClass.PreprocessJobClass) {
        Args.ClaimAllArgs();
        CmdArgs.push_back($("-E"));
      } else {
        assert (Output.getType() == types.ID.TY_PP_Asm); // Require preprocessed asm.
        CmdArgs.push_back($("-S"));
        CmdArgs.push_back($("-fno-exceptions")); // Always do this even if unspecified.
      }
      CmdArgs.push_back($("-DMYRIAD2"));
      
      // Append all -I, -iquote, -isystem paths, defines/undefines,
      // 'f' flags, optimize flags, and warning options.
      // These are spelled the same way in clang and moviCompile.
      Args.AddAllArgs(CmdArgs, /*{ */new ArrayRef<OptSpecifier>($IDsToOptSpecifiers(new /*const*/ options.ID [/*12*/] {
                options.ID.OPT_I_Group, options.ID.OPT_clang_i_Group, 
                options.ID.OPT_std_EQ, options.ID.OPT_D, options.ID.OPT_U, 
                options.ID.OPT_f_Group, options.ID.OPT_f_clang_Group, 
                options.ID.OPT_g_Group, options.ID.OPT_M_Group, 
                options.ID.OPT_O_Group, options.ID.OPT_W_Group, 
                options.ID.OPT_mcpu_EQ})/* }*/));
      
      // If we're producing a dependency file, and assembly is the final action,
      // then the name of the target in the dependency file should be the '.o'
      // file, not the '.s' file produced by this step. For example, instead of
      //  /tmp/mumble.s: mumble.c .../someheader.h
      // the filename on the lefthand side should be "mumble.o"
      if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_MF.getValue())) != null) && !(Args.getLastArg(new OptSpecifier(options.ID.OPT_MT.getValue())) != null)
         && C.getActions().size() == 1
         && C.getActions().$at(0).getKind() == Action.ActionClass.AssembleJobClass) {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_o.getValue()));
        if ((A != null)) {
          CmdArgs.push_back($("-MT"));
          CmdArgs.push_back(Args.MakeArgString(new Twine(A.getValue())));
        }
      }
      
      CmdArgs.push_back(II.getFilename());
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      
      std.string Exec = new std.string(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("moviCompile")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Args.MakeArgString(new Twine(Exec)), 
              CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Compiler::~Compiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 848,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 834,
   FQN="clang::driver::tools::SHAVE::Compiler::~Compiler", NM="_ZN5clang6driver5tools5SHAVE8CompilerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE8CompilerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 860,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 846,
 FQN="clang::driver::tools::SHAVE::Assembler", NM="_ZN5clang6driver5tools5SHAVE9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 862,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 848,
   FQN="clang::driver::tools::SHAVE::Assembler::Assembler", NM="_ZN5clang6driver5tools5SHAVE9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("moviAsm", "moviAsm", TC)*/ 
    //START JInit
    super($("moviAsm"), $("moviAsm"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 864,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 850,
   FQN="clang::driver::tools::SHAVE::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5SHAVE9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5SHAVE9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  } // not sure.

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 10833,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 10202,
   FQN="clang::driver::tools::SHAVE::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools5SHAVE9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5SHAVE9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      assert (Inputs.size() == 1);
      /*const*/ InputInfo /*&*/ II = Inputs.$at(0);
      assert (II.getType() == types.ID.TY_PP_Asm); // Require preprocessed asm input.
      assert (Output.getType() == types.ID.TY_Object);
      
      CmdArgs.push_back($("-no6thSlotCompression"));
      /*const*/ Arg /*P*/ CPUArg = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()));
      if ((CPUArg != null)) {
        CmdArgs.push_back(Args.MakeArgString($add_char$ptr$C_StringRef(/*KEEP_STR*/"-cv:", /*STRINGREF_STR*/CPUArg.getValue())));
      }
      CmdArgs.push_back($("-noSPrefixing"));
      CmdArgs.push_back($("-a")); // Mystery option.
      Args.AddAllArgValues(CmdArgs, new OptSpecifier(options.ID.OPT_Wa_COMMA.getValue()), new OptSpecifier(options.ID.OPT_Xassembler.getValue()));
      for (/*const*/ Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_I.getValue()), new OptSpecifier(options.ID.OPT_isystem.getValue()))) {
        A.claim();
        CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-i:"), A.getValue(0)))));
      }
      CmdArgs.push_back($("-elf")); // Output format.
      CmdArgs.push_back(II.getFilename());
      CmdArgs.push_back(Args.MakeArgString(new Twine($add_string_T(new std.string(/*KEEP_STR*/"-o:"), Output.getFilename()))));
      
      std.string Exec = new std.string(Args.MakeArgString(new Twine(getToolChain().GetProgramPath($("moviAsm")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Args.MakeArgString(new Twine(Exec)), 
              CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::SHAVE::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 860,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 846,
   FQN="clang::driver::tools::SHAVE::Assembler::~Assembler", NM="_ZN5clang6driver5tools5SHAVE9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5SHAVE9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class SHAVEStatics
