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
import static org.llvm.support.llvm.*;
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
;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolsStatics.*;
import static org.clang.driver.types.*;


//<editor-fold defaultstate="collapsed" desc="static type GccStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc12PreprocessorE;_ZN5clang6driver5tools3gcc6CommonE;_ZN5clang6driver5tools3gcc6LinkerE;_ZN5clang6driver5tools3gcc8CompilerE; -static-type=GccStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class GccStatics {

//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Common">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 150,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 149,
 FQN="clang::driver::tools::gcc::Common", NM="_ZN5clang6driver5tools3gcc6CommonE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc6CommonE")
//</editor-fold>
public abstract static class Common extends /*public*/ GnuTool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Common::Common">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 152,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 151,
   FQN="clang::driver::tools::gcc::Common::Common", NM="_ZN5clang6driver5tools3gcc6CommonC1EPKcS5_RKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc6CommonC1EPKcS5_RKNS0_9ToolChainE")
  //</editor-fold>
  public Common(/*const*/char$ptr/*char P*/ Name, /*const*/char$ptr/*char P*/ ShortName, /*const*/ ToolChain /*&*/ TC) {
    /* : GnuTool(Name, ShortName, TC)*/ 
    //START JInit
    super(Name, ShortName, TC);
    //END JInit
  }

  
  // A gcc tool has an "integrated" assembler that it will call to produce an
  // object. Let it use that assembler so that we don't have to deal with
  // assembly syntax incompatibilities.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Common::hasIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 158,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 157,
   FQN="clang::driver::tools::gcc::Common::hasIntegratedAssembler", NM="_ZNK5clang6driver5tools3gcc6Common22hasIntegratedAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc6Common22hasIntegratedAssemblerEv")
  //</editor-fold>
  @Override public boolean hasIntegratedAssembler() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Common::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6650,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6090,
   FQN="clang::driver::tools::gcc::Common::ConstructJob", NM="_ZNK5clang6driver5tools3gcc6Common12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc6Common12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Driver /*&*/ D = getToolChain().getDriver();
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      
      for (Arg /*P*/ /*const*/ /*&*/ A : Args) {
        if (forwardToGCC(A.getOption())) {
          // It is unfortunate that we have to claim here, as this means
          // we will basically never report anything interesting for
          // platforms using a generic gcc, even if we are just using gcc
          // to get to the assembler.
          A.claim();
          
          // Don't forward any -g arguments to assembly steps.
          if (isa(AssembleJobAction.class, JA)
             && A.getOption().matches(new OptSpecifier(options.ID.OPT_g_Group.getValue()))) {
            continue;
          }
          
          // Don't forward any -W arguments to assembly and link steps.
          if ((isa(AssembleJobAction.class, JA) || isa(LinkJobAction.class, JA))
             && A.getOption().matches(new OptSpecifier(options.ID.OPT_W_Group.getValue()))) {
            continue;
          }
          
          A.render(Args, CmdArgs);
        }
      }
      
      RenderExtraToolArgs(JA, CmdArgs);
      
      // If using a driver driver, force the arch.
      if (getToolChain().getTriple().isOSDarwin()) {
        CmdArgs.push_back($("-arch"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(getToolChain().getDefaultUniversalArchName())));
      }
      
      // Try to force gcc to match the tool chain we want, if we recognize
      // the arch.
      //
      // FIXME: The triple class should directly provide the information we want
      // here.
      switch (getToolChain().getArch()) {
       default:
        break;
       case x86:
       case ppc:
        CmdArgs.push_back($("-m32"));
        break;
       case x86_64:
       case ppc64:
       case ppc64le:
        CmdArgs.push_back($("-m64"));
        break;
       case sparcel:
        CmdArgs.push_back($("-EL"));
        break;
      }
      if (Output.isFilename()) {
        CmdArgs.push_back($("-o"));
        CmdArgs.push_back(Output.getFilename());
      } else {
        assert (Output.isNothing()) : "Unexpected output";
        CmdArgs.push_back($("-fsyntax-only"));
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
              new StringRef(getToolChain().getTripleString())));
        } else if (II.getType() == types.ID.TY_AST) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_ast_support)), new StringRef(getToolChain().getTripleString())));
        } else if (II.getType() == types.ID.TY_ModuleFile) {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(D.Diag(diag.err_drv_no_module_support)), 
              new StringRef(getToolChain().getTripleString())));
        }
        if (types.canTypeBeUserSpecified(II.getType())) {
          CmdArgs.push_back($("-x"));
          CmdArgs.push_back(types.getTypeName(II.getType()));
        }
        if (II.isFilename()) {
          CmdArgs.push_back(II.getFilename());
        } else {
          /*const*/ Arg /*&*/ A = II.getInputArg();
          
          // Reverse translate some rewritten options.
          if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Z_reserved_lib_stdcxx.getValue()))) {
            CmdArgs.push_back($("-lstdc++"));
            continue;
          }
          
          // Don't render as input, we need gcc to do the translations.
          A.render(Args, CmdArgs);
        }
      }
      
      /*const*/std.string/*&*/ customGCCName = D.getCCCGenericGCCName();
      /*const*/char$ptr/*char P*/ GCCName;
      if (!customGCCName.empty()) {
        GCCName = $tryClone(customGCCName.c_str());
      } else if (D.CCCIsCXX()) {
        GCCName = $tryClone($("g++"));
      } else {
        GCCName = $tryClone($("gcc"));
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(getToolChain().GetProgramPath(GCCName))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  
  /// RenderExtraToolArgs - Render any arguments necessary to force
  /// the particular tool mode.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Common::RenderExtraToolArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 166,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 165,
   FQN="clang::driver::tools::gcc::Common::RenderExtraToolArgs", NM="_ZNK5clang6driver5tools3gcc6Common19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc6Common19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public abstract /*virtual*/ void RenderExtraToolArgs(/*const*/ JobAction /*&*/ JA, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* = 0*/;

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Common::~Common">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 150,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 149,
   FQN="clang::driver::tools::gcc::Common::~Common", NM="_ZN5clang6driver5tools3gcc6CommonD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc6CommonD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Preprocessor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 170,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 169,
 FQN="clang::driver::tools::gcc::Preprocessor", NM="_ZN5clang6driver5tools3gcc12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc12PreprocessorE")
//</editor-fold>
public static class Preprocessor extends /*public*/ Common implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Preprocessor::Preprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 172,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 171,
   FQN="clang::driver::tools::gcc::Preprocessor::Preprocessor", NM="_ZN5clang6driver5tools3gcc12PreprocessorC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc12PreprocessorC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Preprocessor(/*const*/ ToolChain /*&*/ TC) {
    /* : Common("gcc::Preprocessor", "gcc preprocessor", TC)*/ 
    //START JInit
    super($("gcc::Preprocessor"), $("gcc preprocessor"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Preprocessor::hasGoodDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 175,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 174,
   FQN="clang::driver::tools::gcc::Preprocessor::hasGoodDiagnostics", NM="_ZNK5clang6driver5tools3gcc12Preprocessor18hasGoodDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc12Preprocessor18hasGoodDiagnosticsEv")
  //</editor-fold>
  @Override public boolean hasGoodDiagnostics() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Preprocessor::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 176,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 175,
   FQN="clang::driver::tools::gcc::Preprocessor::hasIntegratedCPP", NM="_ZNK5clang6driver5tools3gcc12Preprocessor16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc12Preprocessor16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Preprocessor::RenderExtraToolArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6773,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6213,
   FQN="clang::driver::tools::gcc::Preprocessor::RenderExtraToolArgs", NM="_ZNK5clang6driver5tools3gcc12Preprocessor19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc12Preprocessor19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void RenderExtraToolArgs(/*const*/ JobAction /*&*/ JA, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    CmdArgs.push_back($("-E"));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Preprocessor::~Preprocessor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 170,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 169,
   FQN="clang::driver::tools::gcc::Preprocessor::~Preprocessor", NM="_ZN5clang6driver5tools3gcc12PreprocessorD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc12PreprocessorD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Compiler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 182,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 181,
 FQN="clang::driver::tools::gcc::Compiler", NM="_ZN5clang6driver5tools3gcc8CompilerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc8CompilerE")
//</editor-fold>
public static class Compiler extends /*public*/ Common implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Compiler::Compiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 184,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 183,
   FQN="clang::driver::tools::gcc::Compiler::Compiler", NM="_ZN5clang6driver5tools3gcc8CompilerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc8CompilerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Compiler(/*const*/ ToolChain /*&*/ TC) {
    /* : Common("gcc::Compiler", "gcc frontend", TC)*/ 
    //START JInit
    super($("gcc::Compiler"), $("gcc frontend"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Compiler::hasGoodDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 186,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 185,
   FQN="clang::driver::tools::gcc::Compiler::hasGoodDiagnostics", NM="_ZNK5clang6driver5tools3gcc8Compiler18hasGoodDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc8Compiler18hasGoodDiagnosticsEv")
  //</editor-fold>
  @Override public boolean hasGoodDiagnostics() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Compiler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 187,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 186,
   FQN="clang::driver::tools::gcc::Compiler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools3gcc8Compiler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc8Compiler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Compiler::RenderExtraToolArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6778,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6218,
   FQN="clang::driver::tools::gcc::Compiler::RenderExtraToolArgs", NM="_ZNK5clang6driver5tools3gcc8Compiler19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc8Compiler19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void RenderExtraToolArgs(/*const*/ JobAction /*&*/ JA, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    /*const*/ Driver /*&*/ D = getToolChain().getDriver();
    switch (JA.getType()) {
     case TY_LLVM_IR:
     case TY_LTO_IR:
     case TY_LLVM_BC:
     case TY_LTO_BC:
      // If -flto, etc. are present then make sure not to force assembly output.
      CmdArgs.push_back($("-c"));
      break;
     case TY_Object:
      // We assume we've got an "integrated" assembler in that gcc will produce an
      // object file itself.
      CmdArgs.push_back($("-c"));
      break;
     case TY_PP_Asm:
      CmdArgs.push_back($("-S"));
      break;
     case TY_Nothing:
      CmdArgs.push_back($("-fsyntax-only"));
      break;
     default:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_invalid_gcc_output_type)), getTypeName(JA.getType())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Compiler::~Compiler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 182,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 181,
   FQN="clang::driver::tools::gcc::Compiler::~Compiler", NM="_ZN5clang6driver5tools3gcc8CompilerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc8CompilerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 193,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 192,
 FQN="clang::driver::tools::gcc::Linker", NM="_ZN5clang6driver5tools3gcc6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ Common implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Linker::Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 194,
   FQN="clang::driver::tools::gcc::Linker::Linker", NM="_ZN5clang6driver5tools3gcc6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : Common("gcc::Linker", "linker (via gcc)", TC)*/ 
    //START JInit
    super($("gcc::Linker"), $("linker (via gcc)"), TC);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 197,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 196,
   FQN="clang::driver::tools::gcc::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools3gcc6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Linker::isLinkJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 198,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 197,
   FQN="clang::driver::tools::gcc::Linker::isLinkJob", NM="_ZNK5clang6driver5tools3gcc6Linker9isLinkJobEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc6Linker9isLinkJobEv")
  //</editor-fold>
  @Override public boolean isLinkJob() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Linker::RenderExtraToolArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6806,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 6246,
   FQN="clang::driver::tools::gcc::Linker::RenderExtraToolArgs", NM="_ZNK5clang6driver5tools3gcc6Linker19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools3gcc6Linker19RenderExtraToolArgsERKNS0_9JobActionERN4llvm11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void RenderExtraToolArgs(/*const*/ JobAction /*&*/ JA, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // The types are (hopefully) good enough.
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::gcc::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 193,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 192,
   FQN="clang::driver::tools::gcc::Linker::~Linker", NM="_ZN5clang6driver5tools3gcc6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools3gcc6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class GccStatics
