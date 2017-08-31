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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.NativeType.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
;
import static org.clang.basic.BasicClangGlobals.*;
import static org.llvm.adt.NoneType.None;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 928,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 859,
 FQN="clang::driver::toolchains::HexagonToolChain", NM="_ZN5clang6driver10toolchains16HexagonToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains16HexagonToolChainE")
//</editor-fold>
public class HexagonToolChain extends /*public*/ Linux implements Destructors.ClassWithDestructor {
/*protected:*/
  protected GCCVersion GCCLibAndIncVersion;
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2980,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2665,
   FQN="clang::driver::toolchains::HexagonToolChain::buildAssembler", NM="_ZNK5clang6driver10toolchains16HexagonToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new HexagonStatics.Assembler(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2984,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2669,
   FQN="clang::driver::toolchains::HexagonToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains16HexagonToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new HexagonStatics.Linker(/*Deref*/this);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::HexagonToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2957,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2642,
   FQN="clang::driver::toolchains::HexagonToolChain::HexagonToolChain", NM="_ZN5clang6driver10toolchains16HexagonToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains16HexagonToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public HexagonToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Linux(D, Triple, Args), GCCLibAndIncVersion()*/ 
    //START JInit
    super(D, Triple, Args);
    this.GCCLibAndIncVersion = new GCCVersion();
    //END JInit
    /*const*/std.string TargetDir = getHexagonTargetDir(new std.string(D.getInstalledDir()), 
        D.PrefixDirs);
    
    // Note: Generic_GCC::Generic_GCC adds InstalledDir and getDriver().Dir to
    // program paths
    /*const*/std.string BinDir/*J*/= $add_string$C_T(TargetDir, /*KEEP_STR*/"/bin");
    if (D.getVFS().exists(new Twine(BinDir))) {
      getProgramPaths().push_back(BinDir);
    }
    
    SmallVector<std.string> /*&*/ LibPaths = getFilePaths();
    
    // Remove paths added by Linux toolchain. Currently Hexagon_TC really targets
    // 'elf' OS type, so the Linux paths are not appropriate. When we actually
    // support 'linux' we'll need to fix this up
    LibPaths.clear();
    getHexagonLibraryPaths(Args, LibPaths);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::~HexagonToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2978,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2663,
   FQN="clang::driver::toolchains::HexagonToolChain::~HexagonToolChain", NM="_ZN5clang6driver10toolchains16HexagonToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains16HexagonToolChainD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    //START JDestroy
    GCCLibAndIncVersion.$destroy();
    super.$destroy();
    //END JDestroy
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2988,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2673,
   FQN="clang::driver::toolchains::HexagonToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains16HexagonToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      return;
    }
    
    /*const*/ Driver /*&*/ D = getDriver();
    std.string TargetDir = getHexagonTargetDir(new std.string(D.getInstalledDir()), 
        D.PrefixDirs);
    addExternCSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(TargetDir, /*KEEP_STR*/"/hexagon/include")));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3000,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2685,
   FQN="clang::driver::toolchains::HexagonToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains16HexagonToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    
    /*const*/ Driver /*&*/ D = getDriver();
    std.string TargetDir = getHexagonTargetDir(D.InstalledDir, D.PrefixDirs);
    addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(TargetDir, /*KEEP_STR*/"/hexagon/include/c++")));
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::GetCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3011,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2696,
   FQN="clang::driver::toolchains::HexagonToolChain::GetCXXStdlibType", NM="_ZNK5clang6driver10toolchains16HexagonToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain16GetCXXStdlibTypeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public ToolChain.CXXStdlibType GetCXXStdlibType(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_stdlib_EQ.getValue()));
    if (!(A != null)) {
      return ToolChain.CXXStdlibType.CST_Libstdcxx;
    }
    
    StringRef Value = new StringRef(A.getValue());
    if ($noteq_StringRef(/*NO_COPY*/Value, /*STRINGREF_STR*/"libstdc++")) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.err_drv_invalid_stdlib_name)), new StringRef(A.getAsString(Args))));
      } finally {
        $c$.$destroy();
      }
    }
    
    return ToolChain.CXXStdlibType.CST_Libstdcxx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::GetGCCLibAndIncVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 947,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 878,
   FQN="clang::driver::toolchains::HexagonToolChain::GetGCCLibAndIncVersion", NM="_ZNK5clang6driver10toolchains16HexagonToolChain22GetGCCLibAndIncVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain22GetGCCLibAndIncVersionEv")
  //</editor-fold>
  public StringRef GetGCCLibAndIncVersion() /*const*/ {
    return new StringRef(GCCLibAndIncVersion.Text);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 948,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 879,
   FQN="clang::driver::toolchains::HexagonToolChain::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains16HexagonToolChain28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return true;
  }

  
  
  /// Hexagon Toolchain
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::getHexagonTargetDir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2879,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2558,
   FQN="clang::driver::toolchains::HexagonToolChain::getHexagonTargetDir", NM="_ZNK5clang6driver10toolchains16HexagonToolChain19getHexagonTargetDirERKSsRKN4llvm15SmallVectorImplISsEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain19getHexagonTargetDirERKSsRKN4llvm15SmallVectorImplISsEE")
  //</editor-fold>
  public std.string getHexagonTargetDir(/*const*/std.string/*&*/ InstalledDir, 
                     /*const*/ SmallVectorImpl<std.string> /*&*/ PrefixDirs) /*const*/ {
    std.string InstallRelDir/*J*/= new std.string();
    /*const*/ Driver /*&*/ D = getDriver();
    
    // Locate the rest of the toolchain ...
    for (/*const*/std.string/*&*/ I : PrefixDirs)  {
      if (D.getVFS().exists(new Twine(I))) {
        return new std.string(I);
      }
    }
    if (getVFS().exists(new Twine(InstallRelDir.$assignMove($add_string$C_T(InstalledDir, /*KEEP_STR*/"/../target"))))) {
      return InstallRelDir;
    }
    
    return InstallRelDir;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::getHexagonLibraryPaths">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2914,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2599,
   FQN="clang::driver::toolchains::HexagonToolChain::getHexagonLibraryPaths", NM="_ZNK5clang6driver10toolchains16HexagonToolChain22getHexagonLibraryPathsERKN4llvm3opt7ArgListERNS3_11SmallVectorISsLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains16HexagonToolChain22getHexagonLibraryPathsERKN4llvm3opt7ArgListERNS3_11SmallVectorISsLj16EEE")
  //</editor-fold>
  public void getHexagonLibraryPaths(/*const*/ ArgList /*&*/ Args, 
                        SmallVector<std.string> /*&*/ LibPaths) /*const*/ {
    std.vectorString RootDirs = null;
    try {
      /*const*/ Driver /*&*/ D = getDriver();
      
      //----------------------------------------------------------------------------
      // -L Args
      //----------------------------------------------------------------------------
      for (Arg /*P*/ A : Args.filtered(new OptSpecifier(options.ID.OPT_L.getValue())))  {
        for (/*const*/char$ptr/*char P*/ Value : A.getValues())  {
          LibPaths.push_back(new std.string(Value));
        }
      }
      
      //----------------------------------------------------------------------------
      // Other standard paths
      //----------------------------------------------------------------------------
      RootDirs/*J*/= new std.vectorString(std.string.EMPTY);
      std.copy(D.PrefixDirs.begin(), D.PrefixDirs.end(), 
          std.back_inserter(RootDirs));
      
      std.string TargetDir = getHexagonTargetDir(new std.string(D.getInstalledDir()), 
          D.PrefixDirs);
      if ($eq___normal_iterator$C(std.find(RootDirs.begin(), RootDirs.end(), TargetDir), RootDirs.end())) {
        RootDirs.push_back(TargetDir);
      }
      
      boolean HasPIC = Args.hasArg(new OptSpecifier(options.ID.OPT_fpic.getValue()), new OptSpecifier(options.ID.OPT_fPIC.getValue()));
      // Assume G0 with -shared.
      boolean HasG0 = Args.hasArg(new OptSpecifier(options.ID.OPT_shared.getValue()));
      {
        OptionalUInt G = getSmallDataThreshold(Args);
        if (G.$bool()) {
          HasG0 = G.getValue() == 0;
        }
      }
      
      /*const*/std.string CpuVer = GetTargetCPUVersion(Args).str();
      for (std.string/*&*/ Dir : RootDirs) {
        std.string LibDir = $add_string$C_T(Dir, /*KEEP_STR*/"/hexagon/lib");
        std.string LibDirCpu = $add_string_string$C($add_string$C_T(LibDir, $$SLASH), CpuVer);
        if (HasG0) {
          if (HasPIC) {
            LibPaths.push_back($add_string$C_T(LibDirCpu, /*KEEP_STR*/"/G0/pic"));
          }
          LibPaths.push_back($add_string$C_T(LibDirCpu, /*KEEP_STR*/"/G0"));
        }
        LibPaths.push_back(LibDirCpu);
        LibPaths.push_back(LibDir);
      }
    } finally {
      if (RootDirs != null) { RootDirs.$destroy(); }
    }
  }

  
  
  //
  // Returns the default CPU for Hexagon. This is the default compilation target
  // if no Hexagon processor is selected at the command-line.
  //
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::GetDefaultCPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3028,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2713,
   FQN="clang::driver::toolchains::HexagonToolChain::GetDefaultCPU", NM="_ZN5clang6driver10toolchains16HexagonToolChain13GetDefaultCPUEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains16HexagonToolChain13GetDefaultCPUEv")
  //</editor-fold>
  public static /*const*/ StringRef GetDefaultCPU() {
    return new StringRef(/*KEEP_STR*/"hexagonv60");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::GetTargetCPUVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3032,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2717,
   FQN="clang::driver::toolchains::HexagonToolChain::GetTargetCPUVersion", NM="_ZN5clang6driver10toolchains16HexagonToolChain19GetTargetCPUVersionERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains16HexagonToolChain19GetTargetCPUVersionERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public static /*const*/ StringRef GetTargetCPUVersion(/*const*/ ArgList /*&*/ Args) {
    Arg /*P*/ CpuArg = null;
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_mcpu_EQ.getValue()), new OptSpecifier(options.ID.OPT_march_EQ.getValue()));
      if ((A != null)) {
        CpuArg = A;
      }
    }
    
    StringRef CPU = (CpuArg != null) ? new StringRef(CpuArg.getValue()) : GetDefaultCPU();
    if (CPU.startswith(/*STRINGREF_STR*/"hexagon")) {
      return CPU.substr(sizeof$str ("hexagon") - 1);
    }
    return CPU;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::HexagonToolChain::getSmallDataThreshold">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 2896,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2580,
   FQN="clang::driver::toolchains::HexagonToolChain::getSmallDataThreshold", NM="_ZN5clang6driver10toolchains16HexagonToolChain21getSmallDataThresholdERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains16HexagonToolChain21getSmallDataThresholdERKN4llvm3opt7ArgListE")
  //</editor-fold>
  public static OptionalUInt getSmallDataThreshold(/*const*/ ArgList /*&*/ Args) {
    StringRef Gn = new StringRef(/*KEEP_STR*/$EMPTY);
    {
      Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_G.getValue()), new OptSpecifier(options.ID.OPT_G_EQ.getValue()), 
          new OptSpecifier(options.ID.OPT_msmall_data_threshold_EQ.getValue()));
      if ((A != null)) {
        Gn.$assignMove(/*STRINGREF_STR*/A.getValue());
      } else if ((Args.getLastArg(new OptSpecifier(options.ID.OPT_shared.getValue()), new OptSpecifier(options.ID.OPT_fpic.getValue()), 
          new OptSpecifier(options.ID.OPT_fPIC.getValue())) != null)) {
        Gn.$assignMove(/*STRINGREF_STR*/$0);
      }
    }
    
    /*uint*/uint$ref G = create_uint$ref();
    if (!Gn.getAsInteger$NotSigned(10, G)) {
      return new OptionalUInt(G.$deref());
    }
    
    return new OptionalUInt(None);
  }

  
  public String toString() {
    return "" + "GCCLibAndIncVersion=" + GCCLibAndIncVersion // NOI18N
              + super.toString(); // NOI18N
  }
}
