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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.ToolChain.*;
import org.clang.driver.tools.impl.GnutoolsStatics;
import org.clang.driver.tools.impl.NacltoolsStatics;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 977,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 906,
 FQN="clang::driver::toolchains::NaClToolChain", NM="_ZN5clang6driver10toolchains13NaClToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains13NaClToolChainE")
//</editor-fold>
public class NaClToolChain extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/
  // End AMDGPU

  /// NaCl Toolchain
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::NaClToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3050,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2740,
   FQN="clang::driver::toolchains::NaClToolChain::NaClToolChain", NM="_ZN5clang6driver10toolchains13NaClToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains13NaClToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public NaClToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple,
      /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args), NaClArmMacrosPath()*/
    //START JInit
    super(D, Triple, Args);
    this.NaClArmMacrosPath = new std.string();
    //END JInit

    // Remove paths added by Generic_GCC. NaCl Toolchain cannot use the
    // default paths, and must instead only use the paths provided
    // with this toolchain based on architecture.
    SmallVector<std.string> /*&*/ file_paths = getFilePaths();
    SmallVector<std.string> /*&*/ prog_paths = getProgramPaths();

    file_paths.clear();
    prog_paths.clear();

    // Path for library files (libc.a, ...)
    std.string FilePath/*J*/= $add_str$C_T(getDriver().Dir, /*KEEP_STR*/"/../");

    // Path for tools (clang, ld, etc..)
    std.string ProgPath/*J*/= $add_str$C_T(getDriver().Dir, /*KEEP_STR*/"/../");

    // Path for toolchain libraries (libgcc.a, ...)
    std.string ToolPath/*J*/= $add_str$C_T(getDriver().ResourceDir, /*KEEP_STR*/"/lib/");
    switch (Triple.getArch()) {
     case x86:
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"x86_64-nacl/lib32"));
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"i686-nacl/usr/lib"));
      prog_paths.push_back($add_str$C_T(ProgPath, /*KEEP_STR*/"x86_64-nacl/bin"));
      file_paths.push_back($add_str$C_T(ToolPath, /*KEEP_STR*/"i686-nacl"));
      break;
     case x86_64:
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"x86_64-nacl/lib"));
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"x86_64-nacl/usr/lib"));
      prog_paths.push_back($add_str$C_T(ProgPath, /*KEEP_STR*/"x86_64-nacl/bin"));
      file_paths.push_back($add_str$C_T(ToolPath, /*KEEP_STR*/"x86_64-nacl"));
      break;
     case arm:
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"arm-nacl/lib"));
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"arm-nacl/usr/lib"));
      prog_paths.push_back($add_str$C_T(ProgPath, /*KEEP_STR*/"arm-nacl/bin"));
      file_paths.push_back($add_str$C_T(ToolPath, /*KEEP_STR*/"arm-nacl"));
      break;
     case mipsel:
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"mipsel-nacl/lib"));
      file_paths.push_back($add_str$C_T(FilePath, /*KEEP_STR*/"mipsel-nacl/usr/lib"));
      prog_paths.push_back($add_str$C_T(ProgPath, /*KEEP_STR*/"bin"));
      file_paths.push_back($add_str$C_T(ToolPath, /*KEEP_STR*/"mipsel-nacl"));
      break;
     default:
      break;
    }

    NaClArmMacrosPath.$assignMove(GetFilePath($("nacl-arm-macros.s")));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3104,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2794,
   FQN="clang::driver::toolchains::NaClToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains13NaClToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs,
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    /*const*/ Driver /*&*/ D = getDriver();
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      return;
    }
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()))) {
      SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(D.ResourceDir), 128);
      path.append(P, new Twine(/*KEEP_STR*/$include));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
    }
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      return;
    }

    SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef($add_str$C_T(D.Dir, /*KEEP_STR*/"/../")), 128);
    switch (getTriple().getArch()) {
     case x86:
      // x86 is special because multilib style uses x86_64-nacl/include for libc
      // headers but the SDK wants i686-nacl/usr/include. The other architectures
      // have the same substring.
      path.append(P, new Twine(/*KEEP_STR*/"i686-nacl/usr/include"));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
      path.remove_filename(P);
      path.remove_filename(P);
      path.remove_filename(P);
      path.append(P, new Twine(/*KEEP_STR*/"x86_64-nacl/include"));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
      return;
     case arm:
      path.append(P, new Twine(/*KEEP_STR*/"arm-nacl/usr/include"));
      break;
     case x86_64:
      path.append(P, new Twine(/*KEEP_STR*/"x86_64-nacl/usr/include"));
      break;
     case mipsel:
      path.append(P, new Twine(/*KEEP_STR*/"mipsel-nacl/usr/include"));
      break;
     default:
      return;
    }

    addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
    path.remove_filename(P);
    path.remove_filename(P);
    path.append(P, new Twine(/*KEEP_STR*/$include));
    addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3161,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2851,
   FQN="clang::driver::toolchains::NaClToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains13NaClToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs,
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    /*const*/ Driver /*&*/ D = getDriver();
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }

    // Check for -stdlib= flags. We only support libc++ but this consumes the arg
    // if the value is libc++, and emits an error for other values.
    GetCXXStdlibType(DriverArgs);

    SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef($add_str$C_T(D.Dir, /*KEEP_STR*/"/../")), 128);
    switch (getTriple().getArch()) {
     case arm:
      path.append(P, new Twine(/*KEEP_STR*/"arm-nacl/include/c++/v1"));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
      break;
     case x86:
      path.append(P, new Twine(/*KEEP_STR*/"x86_64-nacl/include/c++/v1"));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
      break;
     case x86_64:
      path.append(P, new Twine(/*KEEP_STR*/"x86_64-nacl/include/c++/v1"));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
      break;
     case mipsel:
      path.append(P, new Twine(/*KEEP_STR*/"mipsel-nacl/include/c++/v1"));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P.str()));
      break;
     default:
      break;
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::GetCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2885,
   FQN="clang::driver::toolchains::NaClToolChain::GetCXXStdlibType", NM="_ZNK5clang6driver10toolchains13NaClToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public ToolChain.CXXStdlibType GetCXXStdlibType(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue()));
      if ((A != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef Value = new StringRef(A.getValue());
          if ($eq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"libc++")) {
            return ToolChain.CXXStdlibType.CST_Libcxx;
          }
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_stdlib_name)), new StringRef(A.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }

    return ToolChain.CXXStdlibType.CST_Libcxx;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3153,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2843,
   FQN="clang::driver::toolchains::NaClToolChain::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver10toolchains13NaClToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ Args,
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // Check for -stdlib= flags. We only support libc++ but this consumes the arg
    // if the value is libc++, and emits an error for other values.
    GetCXXStdlibType(Args);
    CmdArgs.push_back($("-lc++"));
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 994,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 923,
   FQN="clang::driver::toolchains::NaClToolChain::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains13NaClToolChain28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return getTriple().getArch() == Triple.ArchType.mipsel;
  }


  // Get the path to the file containing NaCl's ARM macros.
  // It lives in NaClToolChain because the ARMAssembler tool needs a
  // const char * that it can pass around,
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::GetNaClArmMacrosPath">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1001,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 930,
   FQN="clang::driver::toolchains::NaClToolChain::GetNaClArmMacrosPath", NM="_ZNK5clang6driver10toolchains13NaClToolChain20GetNaClArmMacrosPathEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain20GetNaClArmMacrosPathEv")
  //</editor-fold>
  public /*const*/char$ptr/*char P*/ GetNaClArmMacrosPath() /*const*/ {
    return NaClArmMacrosPath.c_str();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::ComputeEffectiveClangTriple">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3207,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2897,
   FQN="clang::driver::toolchains::NaClToolChain::ComputeEffectiveClangTriple", NM="_ZNK5clang6driver10toolchains13NaClToolChain27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain27ComputeEffectiveClangTripleERKN4llvm3opt7ArgListENS0_5types2IDE")
  //</editor-fold>
  @Override public std.string ComputeEffectiveClangTriple(/*const*/ ArgList /*&*/ Args,
                             types.ID InputType) /*const*//* override*/ {
    Triple TheTriple/*J*/= new Triple(new Twine(ComputeLLVMTriple(Args, InputType)));
    if (TheTriple.getArch() == Triple.ArchType.arm
       && TheTriple.getEnvironment() == Triple.EnvironmentType.UnknownEnvironment) {
      TheTriple.setEnvironment(Triple.EnvironmentType.GNUEABIHF);
    }
    return new std.string(TheTriple.getTriple());
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3217,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2907,
   FQN="clang::driver::toolchains::NaClToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains13NaClToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new NacltoolsStatics.Linker(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3221,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2911,
   FQN="clang::driver::toolchains::NaClToolChain::buildAssembler", NM="_ZNK5clang6driver10toolchains13NaClToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains13NaClToolChain14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    if (getTriple().getArch() == Triple.ArchType.arm) {
      return new NacltoolsStatics.AssemblerARM(/*Deref*/this);
    }
    return new GnutoolsStatics.Assembler(/*Deref*/this);
  }


/*private:*/
  private std.string NaClArmMacrosPath;
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NaClToolChain::~NaClToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 977,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 906,
   FQN="clang::driver::toolchains::NaClToolChain::~NaClToolChain", NM="_ZN5clang6driver10toolchains13NaClToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains13NaClToolChainD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    NaClArmMacrosPath.$destroy();
    super.$destroy();
    //END JDestroy
  }



  public String toString() {
    return "" + "NaClArmMacrosPath=" + NaClArmMacrosPath // NOI18N
              + super.toString(); // NOI18N
  }
}
