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
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1164,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1093,
 FQN="clang::driver::toolchains::WebAssembly", NM="_ZN5clang6driver10toolchains11WebAssemblyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11WebAssemblyE")
//</editor-fold>
public final class WebAssembly extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::WebAssembly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4951,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4432,
   FQN="clang::driver::toolchains::WebAssembly::WebAssembly", NM="_ZN5clang6driver10toolchains11WebAssemblyC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11WebAssemblyC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public WebAssembly(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args)*/ 
    //START JInit
    super(D, Triple, Args);
    //END JInit
    assert (Triple.isArch32Bit() != Triple.isArch64Bit());
    getFilePaths().push_back($add_string_T($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/lib"), (Triple.isArch32Bit() ? $("32") : $("64"))));
    
    // Use LLD by default.
    DefaultLinker = $tryClone($("lld"));
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4963,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4439,
   FQN="clang::driver::toolchains::WebAssembly::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains11WebAssembly18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public/*private*/ boolean IsMathErrnoDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::IsObjCNonFragileABIDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4965,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4441,
   FQN="clang::driver::toolchains::WebAssembly::IsObjCNonFragileABIDefault", NM="_ZNK5clang6driver10toolchains11WebAssembly26IsObjCNonFragileABIDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly26IsObjCNonFragileABIDefaultEv")
  //</editor-fold>
  @Override public/*private*/ boolean IsObjCNonFragileABIDefault() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::UseObjCMixedDispatch">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4967,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4443,
   FQN="clang::driver::toolchains::WebAssembly::UseObjCMixedDispatch", NM="_ZNK5clang6driver10toolchains11WebAssembly20UseObjCMixedDispatchEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly20UseObjCMixedDispatchEv")
  //</editor-fold>
  @Override public/*private*/ boolean UseObjCMixedDispatch() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4969,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4445,
   FQN="clang::driver::toolchains::WebAssembly::isPICDefault", NM="_ZNK5clang6driver10toolchains11WebAssembly12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly12isPICDefaultEv")
  //</editor-fold>
  @Override public/*private*/ boolean isPICDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4971,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4447,
   FQN="clang::driver::toolchains::WebAssembly::isPIEDefault", NM="_ZNK5clang6driver10toolchains11WebAssembly12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly12isPIEDefaultEv")
  //</editor-fold>
  @Override public/*private*/ boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4973,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4449,
   FQN="clang::driver::toolchains::WebAssembly::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains11WebAssembly18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public/*private*/ boolean isPICDefaultForced() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4975,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4451,
   FQN="clang::driver::toolchains::WebAssembly::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains11WebAssembly28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public/*private*/ boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::hasBlocksRuntime">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4980,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4456,
   FQN="clang::driver::toolchains::WebAssembly::hasBlocksRuntime", NM="_ZNK5clang6driver10toolchains11WebAssembly16hasBlocksRuntimeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly16hasBlocksRuntimeEv")
  //</editor-fold>
  @Override public/*private*/ boolean hasBlocksRuntime() /*const*//* override*/ {
    return false;
  }

  
  // TODO: Support Objective C stuff.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::SupportsObjCGC">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4978,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4454,
   FQN="clang::driver::toolchains::WebAssembly::SupportsObjCGC", NM="_ZNK5clang6driver10toolchains11WebAssembly14SupportsObjCGCEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly14SupportsObjCGCEv")
  //</editor-fold>
  @Override public/*private*/ boolean SupportsObjCGC() /*const*//* override*/ {
    return false;
  }

  
  // TODO: Support profiling.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::SupportsProfiling">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4983,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4459,
   FQN="clang::driver::toolchains::WebAssembly::SupportsProfiling", NM="_ZNK5clang6driver10toolchains11WebAssembly17SupportsProfilingEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly17SupportsProfilingEv")
  //</editor-fold>
  @Override public/*private*/ boolean SupportsProfiling() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::HasNativeLLVMSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4985,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4461,
   FQN="clang::driver::toolchains::WebAssembly::HasNativeLLVMSupport", NM="_ZNK5clang6driver10toolchains11WebAssembly20HasNativeLLVMSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly20HasNativeLLVMSupportEv")
  //</editor-fold>
  @Override public/*private*/ boolean HasNativeLLVMSupport() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::addClangTargetOptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4987,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4463,
   FQN="clang::driver::toolchains::WebAssembly::addClangTargetOptions", NM="_ZNK5clang6driver10toolchains11WebAssembly21addClangTargetOptionsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly21addClangTargetOptionsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public/*private*/ void addClangTargetOptions(/*const*/ ArgList /*&*/ DriverArgs, 
                       ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasFlag(new OptSpecifier(options.ID.OPT_fuse_init_array.getValue()), 
        new OptSpecifier(options.ID.OPT_fno_use_init_array.getValue()), true)) {
      CC1Args.push_back($("-fuse-init-array"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::GetDefaultRuntimeLibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4994,
   FQN="clang::driver::toolchains::WebAssembly::GetDefaultRuntimeLibType", NM="_ZNK5clang6driver10toolchains11WebAssembly24GetDefaultRuntimeLibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly24GetDefaultRuntimeLibTypeEv")
  //</editor-fold>
  @Override public/*private*/ ToolChain.RuntimeLibType GetDefaultRuntimeLibType() /*const*//* override*/ {
    return ToolChain.RuntimeLibType.RLT_CompilerRT;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::GetCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4998,
   FQN="clang::driver::toolchains::WebAssembly::GetCXXStdlibType", NM="_ZNK5clang6driver10toolchains11WebAssembly16GetCXXStdlibTypeERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly16GetCXXStdlibTypeERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public/*private*/ ToolChain.CXXStdlibType GetCXXStdlibType(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    return ToolChain.CXXStdlibType.CST_Libcxx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::AddClangSystemIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5002,
   FQN="clang::driver::toolchains::WebAssembly::AddClangSystemIncludeArgs", NM="_ZNK5clang6driver10toolchains11WebAssembly25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly25AddClangSystemIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public/*private*/ void AddClangSystemIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                           ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))) {
      addSystemInclude(DriverArgs, CC1Args, new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/include")));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5008,
   FQN="clang::driver::toolchains::WebAssembly::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains11WebAssembly28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public/*private*/ void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (!DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       && !DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/include/c++/v1")));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5017,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4470,
   FQN="clang::driver::toolchains::WebAssembly::buildLinker", NM="_ZNK5clang6driver10toolchains11WebAssembly11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains11WebAssembly11buildLinkerEv")
  //</editor-fold>
  @Override protected/*private*/ Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new WasmStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::WebAssembly::~WebAssembly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1164,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1093,
   FQN="clang::driver::toolchains::WebAssembly::~WebAssembly", NM="_ZN5clang6driver10toolchains11WebAssemblyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains11WebAssemblyD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
