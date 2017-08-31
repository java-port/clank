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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;
import org.llvm.support.sys.*;;
import static org.clang.basic.BasicClangGlobals.*;
import org.llvm.target.target.DebuggerKind;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1195,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1116,
 FQN="clang::driver::toolchains::PS4CPU", NM="_ZN5clang6driver10toolchains6PS4CPUE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6PS4CPUE")
//</editor-fold>
public class PS4CPU extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::PS4CPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5021,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4474,
   FQN="clang::driver::toolchains::PS4CPU::PS4CPU", NM="_ZN5clang6driver10toolchains6PS4CPUC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6PS4CPUC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public PS4CPU(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args)*/ 
    //START JInit
    super(D, Triple, Args);
    //END JInit
    if (Args.hasArg(new OptSpecifier(options.ID.OPT_static.getValue()))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($out_DiagnosticBuilder$C_char$ptr$C($c$.track(D.Diag(diag.err_drv_unsupported_opt_for_target)), /*KEEP_STR*/"-static"), /*KEEP_STR*/"PS4"));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Determine where to find the PS4 libraries. We use SCE_ORBIS_SDK_DIR
    // if it exists; otherwise use the driver's installation path, which
    // should be <SDK_DIR>/host_tools/bin.
    SmallString/*512*/ PS4SDKDir/*J*/= new SmallString/*512*/(512);
    {
      /*const*/char$ptr/*char P*/ EnvValue = $tryClone(getenv($("SCE_ORBIS_SDK_DIR")));
      if ((EnvValue != null)) {
        if (!fs.exists(new Twine(EnvValue))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.warn_drv_ps4_sdk_dir)), EnvValue));
          } finally {
            $c$.$destroy();
          }
        }
        PS4SDKDir.$assign(/*STRINGREF_STR*/EnvValue);
      } else {
        PS4SDKDir.$assign(new StringRef(getDriver().Dir));
        path.append(PS4SDKDir, new Twine(/*KEEP_STR*/"/../../"));
      }
    }
    
    // By default, the driver won't report a warning if it can't find
    // PS4's include or lib directories. This behavior could be changed if
    // -Weverything or -Winvalid-or-nonexistent-directory options are passed.
    // If -isysroot was passed, use that as the SDK base path.
    std.string PrefixDir/*J*/= new std.string();
    {
      /*const*/ Arg /*P*/ A = Args.getLastArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()));
      if ((A != null)) {
        PrefixDir.$assign(A.getValue());
        if (!fs.exists(new Twine(PrefixDir))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_DiagnosticBuilder$C_StringRef($c$.track(getDriver().Diag(diag.warn_missing_sysroot)), new StringRef(PrefixDir)));
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        PrefixDir.$assignMove(PS4SDKDir.str().$string());
      }
    }
    
    SmallString/*512*/ PS4SDKIncludeDir/*J*/= new SmallString/*512*/(new StringRef(PrefixDir), 512);
    path.append(PS4SDKIncludeDir, new Twine(/*KEEP_STR*/"target/include"));
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdinc.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_isysroot.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT__sysroot_EQ.getValue()))
       && !fs.exists(new Twine(PS4SDKIncludeDir))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.warn_drv_unable_to_find_directory_expected)), 
                /*KEEP_STR*/"PS4 system headers"), PS4SDKIncludeDir.$StringRef()));
      } finally {
        $c$.$destroy();
      }
    }
    
    SmallString/*512*/ PS4SDKLibDir/*J*/= new SmallString/*512*/(PS4SDKDir);
    path.append(PS4SDKLibDir, new Twine(/*KEEP_STR*/"target/lib"));
    if (!Args.hasArg(new OptSpecifier(options.ID.OPT_nostdlib.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_nodefaultlibs.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT__sysroot_EQ.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT_E.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_c.getValue())) && !Args.hasArg(new OptSpecifier(options.ID.OPT_S.getValue()))
       && !Args.hasArg(new OptSpecifier(options.ID.OPT_emit_ast.getValue()))
       && !fs.exists(new Twine(PS4SDKLibDir))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_DiagnosticBuilder$C_StringRef($out_DiagnosticBuilder$C_char$ptr$C($c$.track(getDriver().Diag(diag.warn_drv_unable_to_find_directory_expected)), 
                /*KEEP_STR*/"PS4 system libraries"), PS4SDKLibDir.$StringRef()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    getFilePaths().push_back(PS4SDKLibDir.str().$string());
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1200,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1121,
   FQN="clang::driver::toolchains::PS4CPU::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains6PS4CPU18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public boolean IsMathErrnoDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::IsObjCNonFragileABIDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1201,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1122,
   FQN="clang::driver::toolchains::PS4CPU::IsObjCNonFragileABIDefault", NM="_ZNK5clang6driver10toolchains6PS4CPU26IsObjCNonFragileABIDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU26IsObjCNonFragileABIDefaultEv")
  //</editor-fold>
  @Override public boolean IsObjCNonFragileABIDefault() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::HasNativeLLVMSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5086,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4539,
   FQN="clang::driver::toolchains::PS4CPU::HasNativeLLVMSupport", NM="_ZNK5clang6driver10toolchains6PS4CPU20HasNativeLLVMSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU20HasNativeLLVMSupportEv")
  //</editor-fold>
  @Override public boolean HasNativeLLVMSupport() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5084,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4537,
   FQN="clang::driver::toolchains::PS4CPU::isPICDefault", NM="_ZNK5clang6driver10toolchains6PS4CPU12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::GetDefaultStackProtectorLevel">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1205,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1126,
   FQN="clang::driver::toolchains::PS4CPU::GetDefaultStackProtectorLevel", NM="_ZNK5clang6driver10toolchains6PS4CPU29GetDefaultStackProtectorLevelEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU29GetDefaultStackProtectorLevelEb")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultStackProtectorLevel(boolean KernelOrKext) /*const*//* override*/ {
    return 2; // SSPStrong
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::getDefaultDebuggerTuning">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1209,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1130,
   FQN="clang::driver::toolchains::PS4CPU::getDefaultDebuggerTuning", NM="_ZNK5clang6driver10toolchains6PS4CPU24getDefaultDebuggerTuningEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU24getDefaultDebuggerTuningEv")
  //</editor-fold>
  @Override public DebuggerKind getDefaultDebuggerTuning() /*const*//* override*/ {
    return DebuggerKind.SCE;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5088,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4541,
   FQN="clang::driver::toolchains::PS4CPU::getSupportedSanitizers", NM="_ZNK5clang6driver10toolchains6PS4CPU22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU22getSupportedSanitizersEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSupportedSanitizers() /*const*//* override*/ {
    long/*uint64_t*/ Res = super.getSupportedSanitizers();
    Res |= SanitizerKind.Address;
    Res |= SanitizerKind.Vptr;
    return Res;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5078,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4531,
   FQN="clang::driver::toolchains::PS4CPU::buildAssembler", NM="_ZNK5clang6driver10toolchains6PS4CPU14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new PS4cpuStatics.Assemble(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 5082,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4535,
   FQN="clang::driver::toolchains::PS4CPU::buildLinker", NM="_ZNK5clang6driver10toolchains6PS4CPU11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6PS4CPU11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new PS4cpuStatics.Link(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::PS4CPU::~PS4CPU">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1195,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 1116,
   FQN="clang::driver::toolchains::PS4CPU::~PS4CPU", NM="_ZN5clang6driver10toolchains6PS4CPUD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6PS4CPUD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
