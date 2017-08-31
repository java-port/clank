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
;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.codegenoptions.DebugInfoKind;
import static org.clang.driver.impl.ToolsStatics.*;
import org.llvm.target.target.DebuggerKind;


/// \brief Clang integrated assembler tool.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 122,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 121,
 FQN="clang::driver::tools::ClangAs", NM="_ZN5clang6driver5tools7ClangAsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7ClangAsE")
//</editor-fold>
public class ClangAs extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::ClangAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 124,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 123,
   FQN="clang::driver::tools::ClangAs::ClangAs", NM="_ZN5clang6driver5tools7ClangAsC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7ClangAsC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public ClangAs(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("clang::as", "clang integrated assembler", TC, RF_Full)*/ 
    //START JInit
    super($("clang::as"), $("clang integrated assembler"), TC, ResponseFileSupport.RF_Full);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::AddMIPSTargetArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6457,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 5903,
   FQN="clang::driver::tools::ClangAs::AddMIPSTargetArgs", NM="_ZNK5clang6driver5tools7ClangAs17AddMIPSTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7ClangAs17AddMIPSTargetArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  public void AddMIPSTargetArgs(/*const*/ ArgList /*&*/ Args, 
                   ArgStringList/*&*/ CmdArgs) /*const*/ {
    StringRef CPUName/*J*/= new StringRef();
    StringRef ABIName/*J*/= new StringRef();
    /*const*/ Triple /*&*/ Triple = getToolChain().getTriple();
    MipsStatics.getMipsCPUAndABI(Args, Triple, CPUName, ABIName);
    
    CmdArgs.push_back($("-target-abi"));
    CmdArgs.push_back(ABIName.data());
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::hasGoodDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 128,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 127,
   FQN="clang::driver::tools::ClangAs::hasGoodDiagnostics", NM="_ZNK5clang6driver5tools7ClangAs18hasGoodDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7ClangAs18hasGoodDiagnosticsEv")
  //</editor-fold>
  @Override public boolean hasGoodDiagnostics() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::hasIntegratedAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 129,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 128,
   FQN="clang::driver::tools::ClangAs::hasIntegratedAssembler", NM="_ZNK5clang6driver5tools7ClangAs22hasIntegratedAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7ClangAs22hasIntegratedAssemblerEv")
  //</editor-fold>
  @Override public boolean hasIntegratedAssembler() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 130,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 129,
   FQN="clang::driver::tools::ClangAs::hasIntegratedCPP", NM="_ZNK5clang6driver5tools7ClangAs16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7ClangAs16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::ConstructJob">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 6468,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", old_line = 5914,
   FQN="clang::driver::tools::ClangAs::ConstructJob", NM="_ZNK5clang6driver5tools7ClangAs12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS8_Lj4EEERKNSB_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools7ClangAs12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS8_Lj4EEERKNSB_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      assert (Inputs.size() == 1) : "Unexpected number of inputs.";
      /*const*/ InputInfo /*&*/ Input = Inputs.$at(0);
      
      std.string TripleStr = getToolChain().ComputeEffectiveClangTriple(Args, Input.getType());
      /*const*/ Triple _Triple/*J*/= new Triple(new Twine(TripleStr));
      
      // Don't warn about "clang -w -c foo.s"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_w.getValue()));
      // and "clang -emit-llvm -c foo.s"
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_emit_llvm.getValue()));
      
      claimNoWarnArgs(Args);
      
      // Invoke ourselves in -cc1as mode.
      //
      // FIXME: Implement custom jobs for internal actions.
      CmdArgs.push_back($("-cc1as"));
      
      // Add the "effective" target triple.
      CmdArgs.push_back($("-triple"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(TripleStr)));
      
      // Set the output mode, we currently only expect to be used as a real
      // assembler.
      CmdArgs.push_back($("-filetype"));
      CmdArgs.push_back($("obj"));
      
      // Set the main file name, so that debug info works even with
      // -save-temps or preprocessed assembly.
      CmdArgs.push_back($("-main-file-name"));
      CmdArgs.push_back(Clang.getBaseInputName(Args, Input));
      
      // Add the target cpu
      std.string CPU = getCPUName(Args, _Triple, /*FromAs*/ true);
      if (!CPU.empty()) {
        CmdArgs.push_back($("-target-cpu"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(CPU)));
      }
      
      // Add the target features
      getTargetFeatures(getToolChain(), _Triple, Args, CmdArgs, true);
      
      // Ignore explicit -force_cpusubtype_ALL option.
      /*(void)*/Args.hasArg(new OptSpecifier(options.ID.OPT_force__cpusubtype__ALL.getValue()));
      
      // Pass along any -I options so we get proper .include search paths.
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_I_Group.getValue()));
      
      // Determine the original source input.
      /*const*/Action/*P*/ SourceAction = /*AddrOf*/JA;
      while (SourceAction.getKind() != Action.ActionClass.InputClass) {
        assert (!SourceAction.getInputs().empty()) : "unexpected root action!";
        SourceAction = SourceAction.getInputs().$at(0);
      }
      
      // Forward -g and handle debug info related flags, assuming we are dealing
      // with an actual assembly file.
      boolean WantDebug = false;
      /*uint*/int DwarfVersion = 0;
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
      {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_g_Group.getValue()));
        if ((A != null)) {
          WantDebug = !A.getOption().matches(new OptSpecifier(options.ID.OPT_g0.getValue()))
             && !A.getOption().matches(new OptSpecifier(options.ID.OPT_ggdb0.getValue()));
          if (WantDebug) {
            DwarfVersion = DwarfVersionNum(A.getSpelling());
          }
        }
      }
      if (DwarfVersion == 0) {
        DwarfVersion = getToolChain().GetDefaultDwarfVersion();
      }
      
      DebugInfoKind _DebugInfoKind = DebugInfoKind.NoDebugInfo;
      if (SourceAction.getType() == types.ID.TY_Asm
         || SourceAction.getType() == types.ID.TY_PP_Asm) {
        // You might think that it would be ok to set DebugInfoKind outside of
        // the guard for source type, however there is a test which asserts
        // that some assembler invocation receives no -debug-info-kind,
        // and it's not clear whether that test is just overly restrictive.
        _DebugInfoKind = (WantDebug ? DebugInfoKind.LimitedDebugInfo : DebugInfoKind.NoDebugInfo);
        // Add the -fdebug-compilation-dir flag if needed.
        addDebugCompDirArg(Args, CmdArgs);
        
        // Set the AT_producer to the clang version when using the integrated
        // assembler on assembly source files.
        CmdArgs.push_back($("-dwarf-debug-producer"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(getClangFullVersion())));
        
        // And pass along -I options
        Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_I.getValue()));
      }
      RenderDebugEnablingArgs(Args, CmdArgs, _DebugInfoKind, DwarfVersion, 
          DebuggerKind.Default);
      
      // Handle -fPIC et al -- the relocation-model affects the assembler
      // for some targets.
      // JAVA: unfold std::tie of tuple
      tuple $ParsePICArgs = ParsePICArgs(getToolChain(), _Triple, Args);
      Reloc.Model RelocationModel = (Reloc.Model) $ParsePICArgs.$getAt(0);
      /*uint*/int PICLevel = (int) $ParsePICArgs.$getAt(1);
      boolean IsPIE = (boolean) $ParsePICArgs.$getAt(2);
      //std.tie(RelocationModel, PICLevel, IsPIE).$assign(ParsePICArgs(getToolChain(), Triple, Args));
      
      /*const*/char$ptr/*char P*/ RMName = $tryClone(RelocationModelName(RelocationModel));
      if ((RMName != null)) {
        CmdArgs.push_back($("-mrelocation-model"));
        CmdArgs.push_back(RMName);
      }
      
      // Optionally embed the -cc1as level arguments into the debug info, for build
      // analysis.
      if (getToolChain().UseDwarfDebugFlags()) {
        ArgStringList OriginalArgs/*J*/= new ArgStringList();
        for (Arg /*P*/ /*const*/ /*&*/ Arg : Args)  {
          Arg.render(Args, OriginalArgs);
        }
        
        SmallString/*256*/ Flags/*J*/= new SmallString/*256*/(256);
        /*const*/char$ptr/*char P*/ Exec = $tryClone(getToolChain().getDriver().getClangProgramPath());
        Flags.$addassign(/*STRINGREF_STR*/Exec);
        for (/*const*/char$ptr/*char P*/ OriginalArg : OriginalArgs) {
          SmallString/*128*/ EscapedArg/*J*/= new SmallString/*128*/(128);
          EscapeSpacesAndBackslashes(OriginalArg, EscapedArg);
          Flags.$addassign(/*STRINGREF_STR*/" ");
          Flags.$addassign(EscapedArg.$StringRef());
        }
        CmdArgs.push_back($("-dwarf-debug-flags"));
        CmdArgs.push_back(Args.MakeArgString(new Twine(Flags)));
      }
      
      // FIXME: Add -static support, once we have it.
      
      // Add target specific flags.
      switch (getToolChain().getArch()) {
       default:
        break;
       case mips:
       case mipsel:
       case mips64:
       case mips64el:
        AddMIPSTargetArgs(Args, CmdArgs);
        break;
      }
      
      // Consume all the warning flags. Usually this would be handled more
      // gracefully by -cc1 (warning about unknown warning flags, etc) but -cc1as
      // doesn't handle that so rather than warning about unused flags that are
      // actually used, we'll lie by omission instead.
      // FIXME: Stop lying and consume only the appropriate driver flags
      Args.ClaimAllArgs(new OptSpecifier(options.ID.OPT_W_Group.getValue()));
      
      CollectArgsForIntegratedAssembler(C, Args, CmdArgs, 
          getToolChain().getDriver());
      
      Args.AddAllArgs(CmdArgs, new OptSpecifier(options.ID.OPT_mllvm.getValue()));
      assert (Output.isFilename()) : "Unexpected lipo output.";
      CmdArgs.push_back($("-o"));
      CmdArgs.push_back(Output.getFilename());
      assert (Input.isFilename()) : "Invalid input.";
      CmdArgs.push_back(Input.getFilename());
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(getToolChain().getDriver().getClangProgramPath());
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
      
      // Handle the debug info splitting at object creation time if we're
      // creating an object.
      // TODO: Currently only works on linux with newer objcopy.
      if (Args.hasArg(new OptSpecifier(options.ID.OPT_gsplit_dwarf.getValue()))
         && getToolChain().getTriple().isOSLinux()) {
        SplitDebugInfo(getToolChain(), C, /*Deref*/this, JA, Args, Output, 
            SplitDebugName(Args, Input));
      }
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::ClangAs::~ClangAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", old_line = 121,
   FQN="clang::driver::tools::ClangAs::~ClangAs", NM="_ZN5clang6driver5tools7ClangAsD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools7ClangAsD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
