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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 751,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 712,
 FQN="clang::driver::toolchains::FreeBSD", NM="_ZN5clang6driver10toolchains7FreeBSDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains7FreeBSDE")
//</editor-fold>
public class FreeBSD extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/
  
  /// FreeBSD - FreeBSD tool chain which can call as(1) and ld(1) directly.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::FreeBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3423,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3062,
   FQN="clang::driver::toolchains::FreeBSD::FreeBSD", NM="_ZN5clang6driver10toolchains7FreeBSDC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains7FreeBSDC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public FreeBSD(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ _Triple, 
      /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args)*/ 
    //START JInit
    super(D, _Triple, Args);
    //END JInit
    
    // When targeting 32-bit platforms, look for '/usr/lib32/crt1.o' and fall
    // back to '/usr/lib' if it doesn't exist.
    if ((_Triple.getArch() == Triple.ArchType.x86
       || _Triple.getArch() == Triple.ArchType.ppc)
       && D.getVFS().exists(new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/lib32/crt1.o")))) {
      getFilePaths().push_back($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/lib32"));
    } else {
      getFilePaths().push_back($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/lib"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::HasNativeLLVMSupport">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3499,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3147,
   FQN="clang::driver::toolchains::FreeBSD::HasNativeLLVMSupport", NM="_ZNK5clang6driver10toolchains7FreeBSD20HasNativeLLVMSupportEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD20HasNativeLLVMSupportEv")
  //</editor-fold>
  @Override public boolean HasNativeLLVMSupport() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 757,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 718,
   FQN="clang::driver::toolchains::FreeBSD::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains7FreeBSD18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public boolean IsMathErrnoDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::IsObjCNonFragileABIDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 758,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 719,
   FQN="clang::driver::toolchains::FreeBSD::IsObjCNonFragileABIDefault", NM="_ZNK5clang6driver10toolchains7FreeBSD26IsObjCNonFragileABIDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD26IsObjCNonFragileABIDefaultEv")
  //</editor-fold>
  @Override public boolean IsObjCNonFragileABIDefault() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::GetDefaultCXXStdlibType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3437,
   FQN="clang::driver::toolchains::FreeBSD::GetDefaultCXXStdlibType", NM="_ZNK5clang6driver10toolchains7FreeBSD23GetDefaultCXXStdlibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD23GetDefaultCXXStdlibTypeEv")
  //</editor-fold>
  @Override public ToolChain.CXXStdlibType GetDefaultCXXStdlibType() /*const*//* override*/ {
    if ($greatereq_uint(getTriple().getOSMajorVersion(), 10)) {
      return ToolChain.CXXStdlibType.CST_Libcxx;
    }
    return ToolChain.CXXStdlibType.CST_Libstdcxx;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3443,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3091,
   FQN="clang::driver::toolchains::FreeBSD::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains7FreeBSD28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs, 
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }
    switch (GetCXXStdlibType(DriverArgs)) {
     case CST_Libcxx:
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/c++/v1")));
      break;
     case CST_Libstdcxx:
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/c++/4.2")));
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/c++/4.2/backward")));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::AddCXXStdlibLibArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3463,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3111,
   FQN="clang::driver::toolchains::FreeBSD::AddCXXStdlibLibArgs", NM="_ZNK5clang6driver10toolchains7FreeBSD19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD19AddCXXStdlibLibArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddCXXStdlibLibArgs(/*const*/ ArgList /*&*/ Args, 
                     ArgStringList/*&*/ CmdArgs) /*const*//* override*/ {
    CXXStdlibType Type = GetCXXStdlibType(Args);
    boolean Profiling = Args.hasArg(new OptSpecifier(options.ID.OPT_pg.getValue()));
    switch (Type) {
     case CST_Libcxx:
      CmdArgs.push_back(Profiling ? $("-lc++_p") : $("-lc++"));
      break;
     case CST_Libstdcxx:
      CmdArgs.push_back(Profiling ? $("-lstdc++_p") : $("-lstdc++"));
      break;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::UseSjLjExceptions">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3485,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3133,
   FQN="clang::driver::toolchains::FreeBSD::UseSjLjExceptions", NM="_ZNK5clang6driver10toolchains7FreeBSD17UseSjLjExceptionsERKN4llvm3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD17UseSjLjExceptionsERKN4llvm3opt7ArgListE")
  //</editor-fold>
  @Override public boolean UseSjLjExceptions(/*const*/ ArgList /*&*/ Args) /*const*//* override*/ {
    // FreeBSD uses SjLj exceptions on ARM oabi.
    switch (getTriple().getEnvironment()) {
     case GNUEABIHF:
     case GNUEABI:
     case EABI:
      return false;
     default:
      return (getTriple().getArch() == Triple.ArchType.arm
         || getTriple().getArch() == Triple.ArchType.thumb);
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3501,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3149,
   FQN="clang::driver::toolchains::FreeBSD::isPIEDefault", NM="_ZNK5clang6driver10toolchains7FreeBSD12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return getSanitizerArgs().requiresPIE();
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::getSupportedSanitizers">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3503,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3151,
   FQN="clang::driver::toolchains::FreeBSD::getSupportedSanitizers", NM="_ZNK5clang6driver10toolchains7FreeBSD22getSupportedSanitizersEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD22getSupportedSanitizersEv")
  //</editor-fold>
  @Override public long/*uint64_t*/ getSupportedSanitizers() /*const*//* override*/ {
    /*const*/boolean IsX86 = getTriple().getArch() == Triple.ArchType.x86;
    /*const*/boolean IsX86_64 = getTriple().getArch() == Triple.ArchType.x86_64;
    /*const*/boolean IsMIPS64 = getTriple().getArch() == Triple.ArchType.mips64
       || getTriple().getArch() == Triple.ArchType.mips64el;
    long/*uint64_t*/ Res = super.getSupportedSanitizers();
    Res |= SanitizerKind.Address;
    Res |= SanitizerKind.Vptr;
    if (IsX86_64 || IsMIPS64) {
      Res |= SanitizerKind.Leak;
      Res |= SanitizerKind.Thread;
    }
    if (IsX86 || IsX86_64) {
      Res |= SanitizerKind.SafeStack;
    }
    return Res;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::GetDefaultDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 770,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 731,
   FQN="clang::driver::toolchains::FreeBSD::GetDefaultDwarfVersion", NM="_ZNK5clang6driver10toolchains7FreeBSD22GetDefaultDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD22GetDefaultDwarfVersionEv")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultDwarfVersion() /*const*//* override*/ {
    return 2;
  }

  // Until dtrace (via CTF) and LLDB can deal with distributed debug info,
  // FreeBSD defaults to standalone/full debug info.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::GetDefaultStandaloneDebug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 773,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 734,
   FQN="clang::driver::toolchains::FreeBSD::GetDefaultStandaloneDebug", NM="_ZNK5clang6driver10toolchains7FreeBSD25GetDefaultStandaloneDebugEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD25GetDefaultStandaloneDebugEv")
  //</editor-fold>
  @Override public boolean GetDefaultStandaloneDebug() /*const*//* override*/ {
    return true;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3479,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3127,
   FQN="clang::driver::toolchains::FreeBSD::buildAssembler", NM="_ZNK5clang6driver10toolchains7FreeBSD14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new FreebsdStatics.Assembler(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3483,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3131,
   FQN="clang::driver::toolchains::FreeBSD::buildLinker", NM="_ZNK5clang6driver10toolchains7FreeBSD11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7FreeBSD11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new FreebsdStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::FreeBSD::~FreeBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 751,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 712,
   FQN="clang::driver::toolchains::FreeBSD::~FreeBSD", NM="_ZN5clang6driver10toolchains7FreeBSDD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains7FreeBSDD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
