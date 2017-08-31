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

package org.clang.driver.toolchains.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
;
import static org.clang.basic.BasicClangGlobals.*;
;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 854,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 811,
 FQN="clang::driver::toolchains::CudaToolChain", NM="_ZN5clang6driver10toolchains13CudaToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains13CudaToolChainE")
//</editor-fold>
public class CudaToolChain extends /*public*/ Linux implements Destructors.ClassWithDestructor {
/*public:*/
  
  /// CUDA toolchain.  Our assembler is ptxas, and our "linker" is fatbinary,
  /// which isn't properly a linker but nonetheless performs the step of stitching
  /// together object files from the assembler into a single blob.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::CudaToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4692,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4207,
   FQN="clang::driver::toolchains::CudaToolChain::CudaToolChain", NM="_ZN5clang6driver10toolchains13CudaToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains13CudaToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public CudaToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Linux(D, Triple, Args)*/ 
    //START JInit
    super(D, Triple, Args);
    //END JInit
    if (CudaInstallation.isValid()) {
      getProgramPaths().push_back(CudaInstallation.getBinPath().$string());
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::TranslateArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4742,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4234,
   FQN="clang::driver::toolchains::CudaToolChain::TranslateArgs", NM="_ZNK5clang6driver10toolchains13CudaToolChain13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain13TranslateArgsERKN4llvm3opt14DerivedArgListEPKc")
  //</editor-fold>
  @Override public DerivedArgList /*P*/ TranslateArgs(/*const*/ DerivedArgList /*&*/ Args, 
               /*const*/char$ptr/*char P*/ BoundArch) /*const*//* override*/ {
    DerivedArgList /*P*/ DAL = new DerivedArgList(Args.getBaseArgs());
    /*const*/ OptTable /*&*/ Opts = getDriver().getOpts();
    
    for (Arg /*P*/ A : Args) {
      if (A.getOption().matches(new OptSpecifier(options.ID.OPT_Xarch__.getValue()))) {
        std.unique_ptr<Arg> XarchArg = null;
        try {
          // Skip this argument unless the architecture matches BoundArch
          if (!(BoundArch != null) || $noteq_StringRef(/*STRINGREF_STR*/A.getValue(0), /*STRINGREF_STR*/BoundArch)) {
            continue;
          }
          
          /*uint*/int $Index = Args.getBaseArgs().MakeIndex(new StringRef(A.getValue(1)));
          /*uint*/uint$ref Index = create_uint$ref($Index);
          /*uint*/int Prev = $Index;
          XarchArg/*J*/= new std.unique_ptr<Arg>(Opts.ParseOneArg(Args, Index));
          
          // If the argument parsing failed or more than one argument was
          // consumed, the -Xarch_ argument's parameter tried to consume
          // extra arguments. Emit an error and ignore.
          //
          // We also want to disallow any options which would alter the
          // driver behavior; that isn't going to work in our model. We
          // use isDriverOption() as an approximation, although things
          // like -O4 are going to slip through.
          if (!XarchArg.$bool() || $greater_uint(Index, Prev + 1)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_Xarch_argument_with_args)), 
                  new StringRef(A.getAsString(Args))));
              continue;
            } finally {
              $c$.$destroy();
            }
          } else if (XarchArg.$arrow().getOption().hasFlag(options.ClangFlags.DriverOption)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_Xarch_argument_isdriver)), 
                  new StringRef(A.getAsString(Args))));
              continue;
            } finally {
              $c$.$destroy();
            }
          }
          XarchArg.$arrow().setBaseArg(A);
          A = XarchArg.release();
          DAL.AddSynthesizedArg(A);
        } finally {
          if (XarchArg != null) { XarchArg.$destroy(); }
        }
      }
      DAL.append(A);
    }
    if ((BoundArch != null)) {
      DAL.eraseArg(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
      DAL.AddJoinedArg((/*const*/ Arg /*P*/ )null, Opts.getOption(new OptSpecifier(options.ID.OPT_march_EQ.getValue())), new StringRef(BoundArch));
    }
    return DAL;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::addClangTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4699,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4211,
   FQN="clang::driver::toolchains::CudaToolChain::addClangTargetOptions", NM="_ZNK5clang6driver10toolchains13CudaToolChain21addClangTargetOptionsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain21addClangTargetOptionsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addClangTargetOptions(/*const*/ ArgList /*&*/ DriverArgs, 
                       ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    super.addClangTargetOptions(DriverArgs, CC1Args);
    CC1Args.push_back($("-fcuda-is-device"));
    if (DriverArgs.hasFlag(new OptSpecifier(options.ID.OPT_fcuda_flush_denormals_to_zero.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_cuda_flush_denormals_to_zero.getValue()), false)) {
      CC1Args.push_back($("-fcuda-flush-denormals-to-zero"));
    }
    if (DriverArgs.hasFlag(new OptSpecifier(options.ID.OPT_fcuda_approx_transcendentals.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_cuda_approx_transcendentals.getValue()), false)) {
      CC1Args.push_back($("-fcuda-approx-transcendentals"));
    }
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nocudalib.getValue()))) {
      return;
    }
    
    std.string LibDeviceFile = CudaInstallation.getLibDeviceFile(DriverArgs.getLastArgValue(new OptSpecifier(options.ID.OPT_march_EQ.getValue())));
    if (!LibDeviceFile.empty()) {
      CC1Args.push_back($("-mlink-cuda-bitcode"));
      CC1Args.push_back(DriverArgs.MakeArgString(new Twine(LibDeviceFile)));
      
      // Libdevice in CUDA-7.0 requires PTX version that's more recent
      // than LLVM defaults to. Use PTX4.2 which is the PTX version that
      // came with CUDA-7.0.
      CC1Args.push_back($("-target-feature"));
      CC1Args.push_back($("+ptx42"));
    }
  }

  
  // Never try to use the integrated assembler with CUDA; always fork out to
  // ptxas.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::useIntegratedAs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 867,
   FQN="clang::driver::toolchains::CudaToolChain::useIntegratedAs", NM="_ZNK5clang6driver10toolchains13CudaToolChain15useIntegratedAsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain15useIntegratedAsEv")
  //</editor-fold>
  @Override public boolean useIntegratedAs() /*const*//* override*/ {
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::AddCudaIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4730,
   FQN="clang::driver::toolchains::CudaToolChain::AddCudaIncludeArgs", NM="_ZNK5clang6driver10toolchains13CudaToolChain18AddCudaIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain18AddCudaIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCudaIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                    ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    // Check our CUDA version if we're going to include the CUDA headers.
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nocudainc.getValue()))
       && !DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_no_cuda_version_check.getValue()))) {
      StringRef Arch = DriverArgs.getLastArgValue(new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
      assert (!Arch.empty()) : "Must have an explicit GPU arch.";
      CudaInstallation.CheckCudaVersionSupportsArch(StringToCudaArch(new StringRef(Arch)));
    }
    super.AddCudaIncludeArgs(DriverArgs, CC1Args);
  }

  
  ////<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::cudaInstallation">
//  @Converted(kind = Converted.Kind.AUTO,
//   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 872,
//   FQN="clang::driver::toolchains::CudaToolChain::cudaInstallation", NM="_ZNK5clang6driver10toolchains13CudaToolChain16cudaInstallationEv",
//   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain16cudaInstallationEv")
//  //</editor-fold>
//  public /*const*/ Generic_GCC.CudaInstallationDetector /*&*/ cudaInstallation() /*const*/ {
//    return CudaInstallation;
//  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::cudaInstallation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 875,
   FQN="clang::driver::toolchains::CudaToolChain::cudaInstallation", NM="_ZN5clang6driver10toolchains13CudaToolChain16cudaInstallationEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains13CudaToolChain16cudaInstallationEv")
  //</editor-fold>
  public Generic_GCC.CudaInstallationDetector /*&*/ cudaInstallation() {
    return CudaInstallation;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4789,
   FQN="clang::driver::toolchains::CudaToolChain::buildAssembler", NM="_ZNK5clang6driver10toolchains13CudaToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new NVPTXStatics.Assembler(/*Deref*/this);
  }
 // ptxas
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4793,
   FQN="clang::driver::toolchains::CudaToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains13CudaToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13CudaToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new NVPTXStatics.Linker(/*Deref*/this);
  }
 // fatbinary (ok, not really a linker)
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CudaToolChain::~CudaToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 854,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 811,
   FQN="clang::driver::toolchains::CudaToolChain::~CudaToolChain", NM="_ZN5clang6driver10toolchains13CudaToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains13CudaToolChainD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
