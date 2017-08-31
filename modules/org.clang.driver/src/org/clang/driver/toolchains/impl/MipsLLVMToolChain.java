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
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.impl.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.driver.impl.ToolChainsStatics.*;
import org.clang.driver.java.DriverFunctionPointers.IncludeDirsFunc;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 884,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 823,
 FQN="clang::driver::toolchains::MipsLLVMToolChain", NM="_ZN5clang6driver10toolchains17MipsLLVMToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains17MipsLLVMToolChainE")
//</editor-fold>
public class MipsLLVMToolChain extends /*public*/ Linux implements Destructors.ClassWithDestructor {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2805,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2483,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new GnutoolsStatics.Linker(/*Deref*/this);
  }

/*public:*/
  
  /// Mips Toolchain
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::MipsLLVMToolChain">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2762,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2439,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::MipsLLVMToolChain", NM="_ZN5clang6driver10toolchains17MipsLLVMToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains17MipsLLVMToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public MipsLLVMToolChain(/*const*/ Driver /*&*/ D, 
      /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Linux(D, Triple, Args), SelectedMultilib(), LibSuffix()*/ 
    //START JInit
    super(D, Triple, Args);
    this.SelectedMultilib = new Multilib();
    this.LibSuffix = new std.string();
    //END JInit
    DetectedMultilibs Result = null;
    try {
      // Select the correct multilib according to the given arguments.
      Result/*J*/= new DetectedMultilibs();
      findMIPSMultilibs(D, Triple, new StringRef(/*KEEP_STR*/$EMPTY), Args, Result);
      Multilibs.$assign(Result.Multilibs);
      SelectedMultilib.$assign(Result.SelectedMultilib);
      
      // Find out the library suffix based on the ABI.
      LibSuffix.$assignMove(MipsStatics.getMipsABILibSuffix(Args, Triple));
      getFilePaths().clear();
      getFilePaths().push_back($add_string_string$C($add_string_T(computeSysRoot(), /*KEEP_STR*/"/usr/lib"), LibSuffix));
      
      // Use LLD by default.
      DefaultLinker = $tryClone($("lld"));
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2781,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2458,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      return;
    }
    
    /*const*/ Driver /*&*/ D = getDriver();
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()))) {
      SmallString/*128*/ P/*J*/= new SmallString/*128*/(new StringRef(D.ResourceDir), 128);
      path.append(P, new Twine(/*KEEP_STR*/$include));
      addSystemInclude(DriverArgs, CC1Args, new Twine(P));
    }
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      return;
    }
    
    /*const*/IncludeDirsFunc/*&*/ Callback = Multilibs.includeDirsCallback();
    if (Callback != null) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        for (/*const*/std.string/*&*/ Path : Callback.$call(SelectedMultilib))  {
          addExternCSystemIncludeIfExists(DriverArgs, CC1Args, 
              new Twine($add_T_string$C(D.getInstalledDir(), Path)));
        }
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::GetCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2822,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2500,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::GetCXXStdlibType", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public ToolChain.CXXStdlibType GetCXXStdlibType(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue()));
    if ((A != null)) {
      StringRef Value = new StringRef(A.getValue());
      if ($noteq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"libc++")) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_stdlib_name)), 
              new StringRef(A.getAsString(Args))));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return ToolChain.CXXStdlibType.CST_Libcxx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2835,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2513,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    assert ((GetCXXStdlibType(DriverArgs) == ToolChain.CXXStdlibType.CST_Libcxx)) : "Only -lc++ (aka libcxx) is suported in this toolchain.";
    
    /*const*/IncludeDirsFunc/*&*/ Callback = Multilibs.includeDirsCallback();
    if (Callback != null) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        for (std.string Path : Callback.$call(SelectedMultilib)) {
          Path.$assignMove($add_string_T($add_T_string$C(getDriver().getInstalledDir(), Path), /*KEEP_STR*/"/c++/v1"));
          if (fs.exists(new Twine(Path))) {
            addSystemInclude(DriverArgs, CC1Args, new Twine(Path));
            break;
          }
        }
      } finally {
        $c$.$destroy();
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2856,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2535,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ Args, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    assert ((GetCXXStdlibType(Args) == ToolChain.CXXStdlibType.CST_Libcxx)) : "Only -lc++ (aka libxx) is suported in this toolchain.";
    
    CmdArgs.push_back($("-lc++"));
    CmdArgs.push_back($("-lc++abi"));
    CmdArgs.push_back($("-lunwind"));
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::getCompilerRT">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2866,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2545,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::getCompilerRT", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain13getCompilerRTERKN4llvm3opt7ArgListENS3_9StringRefEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain13getCompilerRTERKN4llvm3opt7ArgListENS3_9StringRefEb")
  //</editor-fold>
  @Override public std.string getCompilerRT(/*const*/ ArgList /*&*/ Args, 
               StringRef Component) /*const*//* override*/ {
    return getCompilerRT(Args, 
               Component, 
               false);
  }
  @Override public std.string getCompilerRT(/*const*/ ArgList /*&*/ Args, 
               StringRef Component, 
               boolean Shared/*= false*/) /*const*//* override*/ {
    SmallString/*128*/ Path/*J*/= new SmallString/*128*/(new StringRef(getDriver().ResourceDir), 128);
    path.append(Path, new Twine(SelectedMultilib.osSuffix()), new Twine($add_T_string$C(/*KEEP_STR*/"lib", LibSuffix)), 
        new Twine(getOS()));
    path.append(Path, $add_Twine($add_Twine($add_Twine($add_char$ptr$C_StringRef(/*KEEP_STR*/"libclang_rt.", Component), new Twine(/*KEEP_STR*/$MINUS)), 
                new Twine(/*KEEP_STR*/"mips")), new Twine((Shared ? $(".so") : $(".a")))));
    return Path.str().$string();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::computeSysRoot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2809,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2487,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::computeSysRoot", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain14computeSysRootEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain14computeSysRootEv")
  //</editor-fold>
  @Override public std.string computeSysRoot() /*const*//* override*/ {
    if (!getDriver().SysRoot.empty()) {
      return $add_string$C(getDriver().SysRoot, SelectedMultilib.osSuffix());
    }
    
    /*const*/std.string InstalledDir/*J*/= new std.string(getDriver().getInstalledDir());
    std.string SysRootPath = $add_string_string$C($add_string$C_T(InstalledDir, /*KEEP_STR*/"/../sysroot"), SelectedMultilib.osSuffix());
    if (fs.exists(new Twine(SysRootPath))) {
      return SysRootPath;
    }
    
    return new std.string();
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::GetDefaultRuntimeLibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 910,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 849,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::GetDefaultRuntimeLibType", NM="_ZNK5clang6driver10toolchains17MipsLLVMToolChain24GetDefaultRuntimeLibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains17MipsLLVMToolChain24GetDefaultRuntimeLibTypeEv")
  //</editor-fold>
  @Override public RuntimeLibType GetDefaultRuntimeLibType() /*const*//* override*/ {
    return GCCInstallation.isValid() ? RuntimeLibType.RLT_Libgcc : RuntimeLibType.RLT_CompilerRT;
  }

/*private:*/
  private Multilib SelectedMultilib;
  private std.string LibSuffix;
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::MipsLLVMToolChain::~MipsLLVMToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 884,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 823,
   FQN="clang::driver::toolchains::MipsLLVMToolChain::~MipsLLVMToolChain", NM="_ZN5clang6driver10toolchains17MipsLLVMToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains17MipsLLVMToolChainD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    LibSuffix.$destroy();
    SelectedMultilib.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  public String toString() {
    return "" + "SelectedMultilib=" + SelectedMultilib // NOI18N
              + ", LibSuffix=" + LibSuffix // NOI18N
              + super.toString(); // NOI18N
  }
}
