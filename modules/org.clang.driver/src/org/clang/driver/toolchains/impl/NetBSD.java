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
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.*;
import org.clang.driver.toolchains.impl.*;;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 780,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 741,
 FQN="clang::driver::toolchains::NetBSD", NM="_ZN5clang6driver10toolchains6NetBSDE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6NetBSDE")
//</editor-fold>
public class NetBSD extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/
  
  /// NetBSD - NetBSD tool chain which can call as(1) and ld(1) directly.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::NetBSD">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3523,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3171,
   FQN="clang::driver::toolchains::NetBSD::NetBSD", NM="_ZN5clang6driver10toolchains6NetBSDC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6NetBSDC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public NetBSD(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple, /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args)*/ 
    //START JInit
    super(D, Triple, Args);
    //END JInit
    if (getDriver().UseStdLib) {
      // When targeting a 32-bit platform, try the special directory used on
      // 64-bit hosts, and only fall back to the main library directory if that
      // doesn't work.
      // FIXME: It'd be nicer to test if this directory exists, but I'm not sure
      // what all logic is needed to emulate the '=' prefix here.
      switch (Triple.getArch()) {
       case x86:
        getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/i386"));
        break;
       case arm:
       case armeb:
       case thumb:
       case thumbeb:
        switch (Triple.getEnvironment()) {
         case EABI:
         case GNUEABI:
          getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/eabi"));
          break;
         case EABIHF:
         case GNUEABIHF:
          getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/eabihf"));
          break;
         default:
          getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/oabi"));
          break;
        }
        break;
       case mips64:
       case mips64el:
        if (MipsStatics.hasMipsAbiArg(Args, $("o32"))) {
          getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/o32"));
        } else if (MipsStatics.hasMipsAbiArg(Args, $("64"))) {
          getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/64"));
        }
        break;
       case ppc:
        getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/powerpc"));
        break;
       case sparc:
        getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib/sparc"));
        break;
       default:
        break;
      }
      
      getFilePaths().push_back(new std.string(/*KEEP_STR*/"=/usr/lib"));
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 785,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 746,
   FQN="clang::driver::toolchains::NetBSD::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains6NetBSD18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public boolean IsMathErrnoDefault() /*const*//* override*/ {
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::IsObjCNonFragileABIDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 786,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 747,
   FQN="clang::driver::toolchains::NetBSD::IsObjCNonFragileABIDefault", NM="_ZNK5clang6driver10toolchains6NetBSD26IsObjCNonFragileABIDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD26IsObjCNonFragileABIDefaultEv")
  //</editor-fold>
  @Override public boolean IsObjCNonFragileABIDefault() /*const*//* override*/ {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::GetDefaultCXXStdlibType">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3580,
   FQN="clang::driver::toolchains::NetBSD::GetDefaultCXXStdlibType", NM="_ZNK5clang6driver10toolchains6NetBSD23GetDefaultCXXStdlibTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD23GetDefaultCXXStdlibTypeEv")
  //</editor-fold>
  @Override public ToolChain.CXXStdlibType GetDefaultCXXStdlibType() /*const*//* override*/ {
    /*uint*/uint$ref Major = create_uint$ref(), Minor = create_uint$ref(), Micro = create_uint$ref();
    getTriple().getOSVersion(Major, Minor, Micro);
    if ($greatereq_uint(Major, 7) || Major.$deref() == 0) {
      switch (getArch()) {
       case aarch64:
       case arm:
       case armeb:
       case thumb:
       case thumbeb:
       case ppc:
       case ppc64:
       case ppc64le:
       case sparc:
       case sparcv9:
       case x86:
       case x86_64:
        return ToolChain.CXXStdlibType.CST_Libcxx;
       default:
        break;
      }
    }
    return ToolChain.CXXStdlibType.CST_Libstdcxx;
  }

  
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3605,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3264,
   FQN="clang::driver::toolchains::NetBSD::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains6NetBSD28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
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
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/c++/")));
      break;
     case CST_Libstdcxx:
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/g++")));
      addSystemInclude(DriverArgs, CC1Args, 
          new Twine($add_string$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/include/g++/backward")));
      break;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::IsUnwindTablesDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 793,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 754,
   FQN="clang::driver::toolchains::NetBSD::IsUnwindTablesDefault", NM="_ZNK5clang6driver10toolchains6NetBSD21IsUnwindTablesDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD21IsUnwindTablesDefaultEv")
  //</editor-fold>
  @Override public boolean IsUnwindTablesDefault() /*const*//* override*/ {
    return true;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::buildAssembler">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3574,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3223,
   FQN="clang::driver::toolchains::NetBSD::buildAssembler", NM="_ZNK5clang6driver10toolchains6NetBSD14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new NetbsdStatics.Assembler(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::buildLinker">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3578,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3227,
   FQN="clang::driver::toolchains::NetBSD::buildLinker", NM="_ZNK5clang6driver10toolchains6NetBSD11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains6NetBSD11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new NetbsdStatics.Linker(/*Deref*/this);
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::NetBSD::~NetBSD">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 780,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 741,
   FQN="clang::driver::toolchains::NetBSD::~NetBSD", NM="_ZN5clang6driver10toolchains6NetBSDD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains6NetBSDD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
