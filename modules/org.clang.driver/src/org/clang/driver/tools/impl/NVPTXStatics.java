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
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
;


//<editor-fold defaultstate="collapsed" desc="static type NVPTXStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX6LinkerE;_ZN5clang6driver5tools5NVPTX9AssemblerE; -static-type=NVPTXStatics -package=org.clang.driver.tools.impl")
//</editor-fold>
public final class NVPTXStatics {


// Run ptxas, the NVPTX assembler.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Assembler">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 923,
 FQN="clang::driver::tools::NVPTX::Assembler", NM="_ZN5clang6driver5tools5NVPTX9AssemblerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX9AssemblerE")
//</editor-fold>
public static class Assembler extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Assembler::Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 925,
   FQN="clang::driver::tools::NVPTX::Assembler::Assembler", NM="_ZN5clang6driver5tools5NVPTX9AssemblerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX9AssemblerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Assembler(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("NVPTX::Assembler", "ptxas", TC, RF_Full, sys::WEM_UTF8, "--options-file")*/ 
    //START JInit
    super($("NVPTX::Assembler"), $("ptxas"), TC, ResponseFileSupport.RF_Full, WindowsEncodingMethod.WEM_UTF8, 
        $("--options-file"));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Assembler::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 929,
   FQN="clang::driver::tools::NVPTX::Assembler::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5NVPTX9Assembler16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5NVPTX9Assembler16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Assembler::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 11241,
   FQN="clang::driver::tools::NVPTX::Assembler::ConstructJob", NM="_ZNK5clang6driver5tools5NVPTX9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5NVPTX9Assembler12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ CudaToolChain /*&*/ TC = ((/*static_cast*//*const*/ CudaToolChain /*&*/ )(getToolChain()));
      assert (TC.getTriple().isNVPTX()) : "Wrong platform";
      
      // Obtain architecture from the action.
      CudaArch gpu_arch = StringToCudaArch(new StringRef(JA.getOffloadingArch()));
      assert (gpu_arch != CudaArch.UNKNOWN) : "Device action expected to have an architecture.";
      
      // Check that our installation's ptxas supports gpu_arch.
      if (!Args.hasArg(new OptSpecifier(options.ID.OPT_no_cuda_version_check.getValue()))) {
        TC.cudaInstallation().CheckCudaVersionSupportsArch(gpu_arch);
      }
      
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      CmdArgs.push_back(TC.getTriple().isArch64Bit() ? $("-m64") : $("-m32"));
      if (Args.hasFlag(new OptSpecifier(options.ID.OPT_cuda_noopt_device_debug.getValue()), 
          new OptSpecifier(options.ID.OPT_no_cuda_noopt_device_debug.getValue()), false)) {
        // ptxas does not accept -g option if optimization is enabled, so
        // we ignore the compiler's -O* options if we want debug info.
        CmdArgs.push_back($("-g"));
        CmdArgs.push_back($("--dont-merge-basicblocks"));
        CmdArgs.push_back($("--return-at-end"));
      } else {
        Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_O_Group.getValue()));
        if ((A != null)) {
          // Map the -O we received to -O{0,1,2,3}.
          //
          // TODO: Perhaps we should map host -O2 to ptxas -O3. -O3 is ptxas's
          // default, so it may correspond more closely to the spirit of clang -O2.
          
          // -O3 seems like the least-bad option when -Osomething is specified to
          // clang but it isn't handled below.
          StringRef OOpt = new StringRef(/*KEEP_STR*/$3);
          if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O4.getValue()))
             || A.getOption().matches(new OptSpecifier(options.ID.OPT_Ofast.getValue()))) {
            OOpt.$assignMove(/*STRINGREF_STR*/$3);
          } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O0.getValue()))) {
            OOpt.$assignMove(/*STRINGREF_STR*/$0);
          } else if (A.getOption().matches(new OptSpecifier(options.ID.OPT_O.getValue()))) {
            // -Os, -Oz, and -O(anything else) map to -O2, for lack of better options.
            OOpt.$assignMove(/*STRINGREF_STR*/new StringSwitchCharPtr(/*STRINGREF_STR*/A.getValue()).
                    Case(/*KEEP_STR*/"1", /*KEEP_STR*/$1).
                    Case(/*KEEP_STR*/"2", /*KEEP_STR*/$2).
                    Case(/*KEEP_STR*/"3", /*KEEP_STR*/$3).
                    Case(/*KEEP_STR*/"s", /*KEEP_STR*/$2).
                    Case(/*KEEP_STR*/"z", /*KEEP_STR*/$2).
                    Default(/*KEEP_STR*/$2));
          }
          CmdArgs.push_back(Args.MakeArgString($add_Twine(new Twine(/*KEEP_STR*/"-O"), new Twine(OOpt))));
        } else {
          // If no -O was passed, pass -O0 to ptxas -- no opt flag should correspond
          // to no optimizations, but ptxas's default is -O3.
          CmdArgs.push_back($("-O0"));
        }
      }
      
      CmdArgs.push_back($("--gpu-name"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(CudaArchToString(gpu_arch))));
      CmdArgs.push_back($("--output-file"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(Output.getFilename())));
      for (/*const*/ InputInfo /*&*/ II : Inputs)  {
        CmdArgs.push_back(Args.MakeArgString(new Twine(II.getFilename())));
      }
      
      for (/*const*/std.string/*&*/ A : Args.getAllArgValues(new OptSpecifier(options.ID.OPT_Xcuda_ptxas.getValue())))  {
        CmdArgs.push_back(Args.MakeArgString(new Twine(A)));
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(TC.GetProgramPath($("ptxas")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Assembler::~Assembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 923,
   FQN="clang::driver::tools::NVPTX::Assembler::~Assembler", NM="_ZN5clang6driver5tools5NVPTX9AssemblerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX9AssemblerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}

// Runs fatbinary, which combines GPU object files ("cubin" files) and/or PTX
// assembly into a single output file.
//<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Linker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 939,
 FQN="clang::driver::tools::NVPTX::Linker", NM="_ZN5clang6driver5tools5NVPTX6LinkerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX6LinkerE")
//</editor-fold>
public static class Linker extends /*public*/ Tool implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Linker::Linker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 941,
   FQN="clang::driver::tools::NVPTX::Linker::Linker", NM="_ZN5clang6driver5tools5NVPTX6LinkerC1ERKNS0_9ToolChainE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX6LinkerC1ERKNS0_9ToolChainE")
  //</editor-fold>
  public Linker(/*const*/ ToolChain /*&*/ TC) {
    /* : Tool("NVPTX::Linker", "fatbinary", TC, RF_Full, sys::WEM_UTF8, "--options-file")*/ 
    //START JInit
    super($("NVPTX::Linker"), $("fatbinary"), TC, ResponseFileSupport.RF_Full, WindowsEncodingMethod.WEM_UTF8, 
        $("--options-file"));
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Linker::hasIntegratedCPP">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 945,
   FQN="clang::driver::tools::NVPTX::Linker::hasIntegratedCPP", NM="_ZNK5clang6driver5tools5NVPTX6Linker16hasIntegratedCPPEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5NVPTX6Linker16hasIntegratedCPPEv")
  //</editor-fold>
  @Override public boolean hasIntegratedCPP() /*const*//* override*/ {
    return false;
  }

  
  
  // All inputs to this linker must be from CudaDeviceActions, as we need to look
  // at the Inputs' Actions in order to figure out which GPU architecture they
  // correspond to.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Linker::ConstructJob">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp", line = 11317,
   FQN="clang::driver::tools::NVPTX::Linker::ConstructJob", NM="_ZNK5clang6driver5tools5NVPTX6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZNK5clang6driver5tools5NVPTX6Linker12ConstructJobERNS0_11CompilationERKNS0_9JobActionERKNS0_9InputInfoERKN4llvm11SmallVectorIS9_Lj4EEERKNSC_3opt7ArgListEPKc")
  //</editor-fold>
  @Override public void ConstructJob(Compilation /*&*/ C, /*const*/ JobAction /*&*/ JA, 
              /*const*/ InputInfo /*&*/ Output, 
              /*const*//*InputInfoList*/SmallVector<InputInfo>/*&*/ Inputs, 
              /*const*/ ArgList /*&*/ Args, 
              /*const*/char$ptr/*char P*/ LinkingOutput) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ CudaToolChain /*&*/ TC = ((/*static_cast*//*const*/ CudaToolChain /*&*/ )(getToolChain()));
      assert (TC.getTriple().isNVPTX()) : "Wrong platform";
      
      ArgStringList CmdArgs/*J*/= new ArgStringList();
      CmdArgs.push_back($("--cuda"));
      CmdArgs.push_back(TC.getTriple().isArch64Bit() ? $("-64") : $("-32"));
      CmdArgs.push_back(Args.MakeArgString(new Twine(/*KEEP_STR*/"--create")));
      CmdArgs.push_back(Args.MakeArgString(new Twine(Output.getFilename())));
      
      for (/*const*/ InputInfo /*&*/ II : Inputs) {
        /*const*/Action/*P*/ A = II.getAction();
        assert (A.getInputs().size() == 1) : "Device offload action is expected to have a single input";
        /*const*/char$ptr/*char P*/ gpu_arch_str = $tryClone(A.getOffloadingArch());
        assert ((gpu_arch_str != null)) : "Device action expected to have associated a GPU architecture!";
        CudaArch gpu_arch = StringToCudaArch(new StringRef(gpu_arch_str));
        
        // We need to pass an Arch of the form "sm_XX" for cubin files and
        // "compute_XX" for ptx.
        /*const*/char$ptr/*char P*/ Arch = $tryClone((II.getType() == types.ID.TY_PP_Asm) ? CudaVirtualArchToString(VirtualArchForCudaArch(gpu_arch)) : gpu_arch_str);
        CmdArgs.push_back(Args.MakeArgString($add_Twine($add_Twine($add_Twine(new Twine(/*KEEP_STR*/"--image=profile="), 
                            new Twine(Arch)), new Twine(/*KEEP_STR*/",file=")), new Twine(II.getFilename()))));
      }
      
      for (/*const*/std.string/*&*/ A : Args.getAllArgValues(new OptSpecifier(options.ID.OPT_Xcuda_fatbinary.getValue())))  {
        CmdArgs.push_back(Args.MakeArgString(new Twine(A)));
      }
      
      /*const*/char$ptr/*char P*/ Exec = $tryClone(Args.MakeArgString(new Twine(TC.GetProgramPath($("fatbinary")))));
      C.addCommand($c$.track(llvm.make_unique(new Command(JA, /*Deref*/this, Exec, CmdArgs, Inputs)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::tools::NVPTX::Linker::~Linker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.h", line = 939,
   FQN="clang::driver::tools::NVPTX::Linker::~Linker", NM="_ZN5clang6driver5tools5NVPTX6LinkerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/Tools.cpp -nm=_ZN5clang6driver5tools5NVPTX6LinkerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
} // END OF class NVPTXStatics
