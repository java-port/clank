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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1078,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1007,
 FQN="clang::driver::toolchains::CrossWindowsToolChain", NM="_ZN5clang6driver10toolchains21CrossWindowsToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains21CrossWindowsToolChainE")
//</editor-fold>
public class CrossWindowsToolChain extends /*public*/ Generic_GCC implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::CrossWindowsToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 18,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::CrossWindowsToolChain", NM="_ZN5clang6driver10toolchains21CrossWindowsToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains21CrossWindowsToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public CrossWindowsToolChain(/*const*/ Driver /*&*/ D, 
      /*const*/ Triple /*&*/ T, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Generic_GCC(D, T, Args)*/ 
    //START JInit
    super(D, T, Args);
    //END JInit
    if (GetCXXStdlibType(Args) == ToolChain.CXXStdlibType.CST_Libstdcxx) {
      /*const*/std.string/*&*/ SysRoot = D.SysRoot;
      
      // libstdc++ resides in /usr/lib, but depends on libgcc which is placed in
      // /usr/lib/gcc.
      getFilePaths().push_back($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/lib"));
      getFilePaths().push_back($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/lib/gcc"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1083,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1012,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 32,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::IsUnwindTablesDefault", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain21IsUnwindTablesDefaultEv")
  //</editor-fold>
  @Override public boolean IsUnwindTablesDefault() /*const*//* override*/ {
    // FIXME: all non-x86 targets need unwind tables, however, LLVM currently does
    // not know how to emit them.
    return getArch() == Triple.ArchType.x86_64;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 38,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::isPICDefault", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 42,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::isPIEDefault", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 46,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return getArch() == Triple.ArchType.x86_64;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::GetDefaultStackProtectorLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1089,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1018,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::GetDefaultStackProtectorLevel", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain29GetDefaultStackProtectorLevelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain29GetDefaultStackProtectorLevelEb")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultStackProtectorLevel(boolean KernelOrKext) /*const*//* override*/ {
    return 0;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 50,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Driver /*&*/ D = getDriver();
      /*const*/std.string/*&*/ SysRoot = D.SysRoot;
      if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
        return;
      }
      
      addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/local/include")));
      if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nobuiltininc.getValue()))) {
        SmallString/*128*/ ResourceDir/*J*/= new SmallString/*128*/(new StringRef(D.ResourceDir), 128);
        path.append(ResourceDir, new Twine(/*KEEP_STR*/$include));
        addSystemInclude(DriverArgs, CC1Args, new Twine(ResourceDir));
      }
      for (/*const*/std.string/*&*/ P : DriverArgs.getAllArgValues(new OptSpecifier(options.ID.OPT_isystem_after.getValue())))  {
        addSystemInclude(DriverArgs, CC1Args, new Twine(P));
      }
      addExternCSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/include")));
    } finally {
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 70,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", old_line = 68,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    /*const*/ Triple /*&*/ Triple = getTriple();
    /*const*/std.string/*&*/ SysRoot = getDriver().SysRoot;
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    switch (GetCXXStdlibType(DriverArgs)) {
     case CST_Libcxx:
      addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/include/c++/v1")));
      break;
     case CST_Libstdcxx:
      addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/include/c++")));
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string_string$C($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/include/c++/"), Triple.str())));
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(SysRoot, /*KEEP_STR*/"/usr/include/c++/backwards")));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 94,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", old_line = 92,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                     ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    switch (GetCXXStdlibType(DriverArgs)) {
     case CST_Libcxx:
      CC1Args.push_back($("-lc++"));
      break;
     case CST_Libstdcxx:
      CC1Args.push_back($("-lstdc++"));
      CC1Args.push_back($("-lmingw32"));
      CC1Args.push_back($("-lmingwex"));
      CC1Args.push_back($("-lgcc"));
      CC1Args.push_back($("-lmoldname"));
      CC1Args.push_back($("-lmingw32"));
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 112,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", old_line = 110,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::getSupportedSanitizers", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain22getSupportedSanitizersEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSupportedSanitizers() /*const*//* override*/ {
    long/*uint64_t*/ Res = super.getSupportedSanitizers();
    Res |= SanitizerKind.Address;
    return Res;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 118,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", old_line = 116,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new CrossWindowsStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", line = 122,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp", old_line = 120,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::buildAssembler", NM="_ZNK5clang6driver10toolchains21CrossWindowsToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains21CrossWindowsToolChain14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new CrossWindowsStatics.Assembler(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::CrossWindowsToolChain::~CrossWindowsToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1078,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1007,
   FQN="clang::driver::toolchains::CrossWindowsToolChain::~CrossWindowsToolChain", NM="_ZN5clang6driver10toolchains21CrossWindowsToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains21CrossWindowsToolChainD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
