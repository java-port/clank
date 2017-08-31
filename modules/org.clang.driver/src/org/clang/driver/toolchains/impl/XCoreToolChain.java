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

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.llvm.support.sys.*;;
import static org.clang.driver.ToolChain.*;
import org.clang.driver.tools.impl.XCoreStatics;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1110,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1038,
 FQN="clang::driver::toolchains::XCoreToolChain", NM="_ZN5clang6driver10toolchains14XCoreToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains14XCoreToolChainE")
//</editor-fold>
public class XCoreToolChain extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*public:*/

  /// XCore tool chain
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::XCoreToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4279,
   FQN="clang::driver::toolchains::XCoreToolChain::XCoreToolChain", NM="_ZN5clang6driver10toolchains14XCoreToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains14XCoreToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public XCoreToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple,
      /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args)*/
    //START JInit
    super(D, Triple, Args);
    //END JInit
    // ProgramPaths are found via 'PATH' environment variable.
  }


/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4786,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4285,
   FQN="clang::driver::toolchains::XCoreToolChain::buildAssembler", NM="_ZNK5clang6driver10toolchains14XCoreToolChain14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new XCoreStatics.Assembler(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4790,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4289,
   FQN="clang::driver::toolchains::XCoreToolChain::buildLinker", NM="_ZNK5clang6driver10toolchains14XCoreToolChain11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new XCoreStatics.Linker(/*Deref*/this);
  }


/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4794,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4293,
   FQN="clang::driver::toolchains::XCoreToolChain::isPICDefault", NM="_ZNK5clang6driver10toolchains14XCoreToolChain12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4796,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4295,
   FQN="clang::driver::toolchains::XCoreToolChain::isPIEDefault", NM="_ZNK5clang6driver10toolchains14XCoreToolChain12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4798,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4297,
   FQN="clang::driver::toolchains::XCoreToolChain::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains14XCoreToolChain18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::SupportsProfiling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4800,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4299,
   FQN="clang::driver::toolchains::XCoreToolChain::SupportsProfiling", NM="_ZNK5clang6driver10toolchains14XCoreToolChain17SupportsProfilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain17SupportsProfilingEv")
  //</editor-fold>
  @Override public boolean SupportsProfiling() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::hasBlocksRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4802,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4301,
   FQN="clang::driver::toolchains::XCoreToolChain::hasBlocksRuntime", NM="_ZNK5clang6driver10toolchains14XCoreToolChain16hasBlocksRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain16hasBlocksRuntimeEv")
  //</editor-fold>
  @Override public boolean hasBlocksRuntime() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4804,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4303,
   FQN="clang::driver::toolchains::XCoreToolChain::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains14XCoreToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs,
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))) {
      return;
    }
    {
      /*const*/char$ptr/*char P*/ cl_include_dir = $tryClone(getenv($("XCC_C_INCLUDE_PATH")));
      if ((cl_include_dir != null)) {
        SmallVector<StringRef> Dirs/*J*/= new SmallVector<StringRef>(4, new StringRef());
        /*const*//*char*/byte EnvPathSeparatorStr[/*2*/] = new$char(2, sys.EnvPathSeparator, $$TERM);
        new StringRef(cl_include_dir).split(Dirs, /*STRINGREF_STR*/EnvPathSeparatorStr);
        ArrayRef<StringRef> DirVec/*J*/= new ArrayRef<StringRef>(Dirs);
        addSystemIncludes(DriverArgs, CC1Args, new ArrayRef<StringRef>(DirVec));
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::addClangTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4818,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4317,
   FQN="clang::driver::toolchains::XCoreToolChain::addClangTargetOptions", NM="_ZNK5clang6driver10toolchains14XCoreToolChain21addClangTargetOptionsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain21addClangTargetOptionsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void addClangTargetOptions(/*const*/ ArgList /*&*/ DriverArgs,
                       ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    CC1Args.push_back($("-nostdsysteminc"));
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4823,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4322,
   FQN="clang::driver::toolchains::XCoreToolChain::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains14XCoreToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    {
      /*const*/char$ptr/*char P*/ cl_include_dir = $tryClone(getenv($("XCC_CPLUS_INCLUDE_PATH")));
      if ((cl_include_dir != null)) {
        SmallVector<StringRef> Dirs/*J*/= new SmallVector<StringRef>(4, new StringRef());
        /*const*//*char*/byte EnvPathSeparatorStr[/*2*/] = new$char(2, sys.EnvPathSeparator, $$TERM);
        new StringRef(cl_include_dir).split(Dirs, /*STRINGREF_STR*/EnvPathSeparatorStr);
        ArrayRef<StringRef> DirVec/*J*/= new ArrayRef<StringRef>(Dirs);
        addSystemIncludes(DriverArgs, CC1Args, new ArrayRef<StringRef>(DirVec));
      }
    }
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4838,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4337,
   FQN="clang::driver::toolchains::XCoreToolChain::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver10toolchains14XCoreToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains14XCoreToolChain19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ Args,
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    // We don't output any lib args. This is handled by xcc.
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::XCoreToolChain::~XCoreToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1110,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1038,
   FQN="clang::driver::toolchains::XCoreToolChain::~XCoreToolChain", NM="_ZN5clang6driver10toolchains14XCoreToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains14XCoreToolChainD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }



  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
