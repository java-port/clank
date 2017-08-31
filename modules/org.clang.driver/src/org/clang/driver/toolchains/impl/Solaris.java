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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.llvm.option.*;
import org.clang.driver.*;
import static org.clang.driver.impl.ToolChainsStatics.*;
import static org.clang.driver.ToolChain.*;
import org.clang.driver.tools.impl.SolarisStatics;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 646,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 618,
 FQN="clang::driver::toolchains::Solaris", NM="_ZN5clang6driver10toolchains7SolarisE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains7SolarisE")
//</editor-fold>
public class Solaris extends /*public*/ Generic_GCC implements Destructors.ClassWithDestructor {
/*public:*/

  /// Solaris - Solaris tool chain which can call as(1) and ld(1) directly.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::Solaris">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3629,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3306,
   FQN="clang::driver::toolchains::Solaris::Solaris", NM="_ZN5clang6driver10toolchains7SolarisC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains7SolarisC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public Solaris(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple,
      /*const*/ ArgList /*&*/ Args) {
    /* : Generic_GCC(D, Triple, Args)*/
    //START JInit
    super(D, Triple, Args);
    //END JInit

    GCCInstallation.init(Triple, Args);

    SmallVector<std.string> /*&*/ Paths = getFilePaths();
    if (GCCInstallation.isValid()) {
      addPathIfExists(D, new Twine(GCCInstallation.getInstallPath()), Paths);
    }

    addPathIfExists(D, new Twine(getDriver().getInstalledDir()), Paths);
    if ($noteq_T_str$C(getDriver().getInstalledDir(), getDriver().Dir)) {
      addPathIfExists(D, new Twine(getDriver().Dir), Paths);
    }

    addPathIfExists(D, new Twine($add_str_T($add_str$C(getDriver().SysRoot, getDriver().Dir), /*KEEP_STR*/"/../lib")), Paths);

    std.string LibPath = new std.string(/*KEEP_STR*/"/usr/lib/");
    switch (Triple.getArch()) {
     case x86:
     case sparc:
      break;
     case x86_64:
      LibPath.$addassign(/*KEEP_STR*/"amd64/");
      break;
     case sparcv9:
      LibPath.$addassign(/*KEEP_STR*/"sparcv9/");
      break;
     default:
      throw new llvm_unreachable("Unsupported architecture");
    }

    addPathIfExists(D, new Twine($add_str$C(getDriver().SysRoot, LibPath)), Paths);
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::IsIntegratedAssemblerDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 651,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 623,
   FQN="clang::driver::toolchains::Solaris::IsIntegratedAssemblerDefault", NM="_ZNK5clang6driver10toolchains7Solaris28IsIntegratedAssemblerDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains7Solaris28IsIntegratedAssemblerDefaultEv")
  //</editor-fold>
  @Override public boolean IsIntegratedAssemblerDefault() /*const*//* override*/ {
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::AddClangCXXStdlibIncludeArgs">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3669,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3346,
   FQN="clang::driver::toolchains::Solaris::AddClangCXXStdlibIncludeArgs", NM="_ZNK5clang6driver10toolchains7Solaris28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7Solaris28AddClangCXXStdlibIncludeArgsERKN4llvm3opt7ArgListERNS3_11SmallVectorIPKcLj16EEE")
  //</editor-fold>
  @Override public void AddClangCXXStdlibIncludeArgs(/*const*/ ArgList /*&*/ DriverArgs,
                              ArgStringList/*&*/ CC1Args) /*const*//* override*/ {
    if (DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdlibinc.getValue()))
       || DriverArgs.hasArg(new OptSpecifier(options.ID.OPT_nostdincxx.getValue()))) {
      return;
    }

    // Include the support directory for things like xlocale and fudged system
    // headers.
    addSystemInclude(DriverArgs, CC1Args, new Twine(/*KEEP_STR*/"/usr/include/c++/v1/support/solaris"));
    if (GCCInstallation.isValid()) {
      GCCVersion Version = new GCCVersion(GCCInstallation.getVersion());
      addSystemInclude(DriverArgs, CC1Args,
          new Twine($add_str_str$C($add_str_T($add_str_str$C($add_str_T($add_str_str$C($add_str$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/gcc/"),
                                  Version.MajorStr), /*KEEP_STR*/"."),
                          Version.MinorStr),
                      /*KEEP_STR*/"/include/c++/"), Version.Text)));
      addSystemInclude(DriverArgs, CC1Args,
          new Twine($add_str_str$C($add_str_T($add_str_str$C($add_str_T($add_str_str$C($add_str_T($add_str_str$C($add_str$C_T(getDriver().SysRoot, /*KEEP_STR*/"/usr/gcc/"), Version.MajorStr),
                                      /*KEEP_STR*/"."), Version.MinorStr), /*KEEP_STR*/"/include/c++/"),
                          Version.Text), /*KEEP_STR*/"/"),
                  GCCInstallation.getTriple().str())));
    }
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::GetDefaultDwarfVersion">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 657,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 629,
   FQN="clang::driver::toolchains::Solaris::GetDefaultDwarfVersion", NM="_ZNK5clang6driver10toolchains7Solaris22GetDefaultDwarfVersionEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains7Solaris22GetDefaultDwarfVersionEv")
  //</editor-fold>
  @Override public /*uint*/int GetDefaultDwarfVersion() /*const*//* override*/ {
    return 2;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3663,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3340,
   FQN="clang::driver::toolchains::Solaris::buildAssembler", NM="_ZNK5clang6driver10toolchains7Solaris14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7Solaris14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new SolarisStatics.Assembler(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3667,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 3344,
   FQN="clang::driver::toolchains::Solaris::buildLinker", NM="_ZNK5clang6driver10toolchains7Solaris11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains7Solaris11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new SolarisStatics.Linker(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::Solaris::~Solaris">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 646,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 618,
   FQN="clang::driver::toolchains::Solaris::~Solaris", NM="_ZN5clang6driver10toolchains7SolarisD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains7SolarisD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }



  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
