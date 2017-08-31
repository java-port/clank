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
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;
import org.clang.driver.tools.impl.DragonflyStatics;

//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DragonFly">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 811,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 771,
 FQN="clang::driver::toolchains::DragonFly", NM="_ZN5clang6driver10toolchains9DragonFlyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains9DragonFlyE")
//</editor-fold>
public class DragonFly extends /*public*/ Generic_ELF implements Destructors.ClassWithDestructor {
/*public:*/

  /// DragonFly - DragonFly tool chain which can call as(1) and ld(1) directly.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DragonFly::DragonFly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4648,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4181,
   FQN="clang::driver::toolchains::DragonFly::DragonFly", NM="_ZN5clang6driver10toolchains9DragonFlyC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains9DragonFlyC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public DragonFly(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple,
      /*const*/ ArgList /*&*/ Args) {
    /* : Generic_ELF(D, Triple, Args)*/
    //START JInit
    super(D, Triple, Args);
    //END JInit

    // Path mangling to find libexec
    getProgramPaths().push_back(new std.string(getDriver().getInstalledDir()));
    if ($noteq_T_str$C(getDriver().getInstalledDir(), getDriver().Dir)) {
      getProgramPaths().push_back(getDriver().Dir);
    }

    getFilePaths().push_back($add_str$C_T(getDriver().Dir, /*KEEP_STR*/"/../lib"));
    getFilePaths().push_back(new std.string(/*KEEP_STR*/"/usr/lib"));
    getFilePaths().push_back(new std.string(/*KEEP_STR*/"/usr/lib/gcc50"));
  }



  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DragonFly::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 816,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 776,
   FQN="clang::driver::toolchains::DragonFly::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains9DragonFly18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZNK5clang6driver10toolchains9DragonFly18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public boolean IsMathErrnoDefault() /*const*//* override*/ {
    return false;
  }

/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DragonFly::buildAssembler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4662,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4195,
   FQN="clang::driver::toolchains::DragonFly::buildAssembler", NM="_ZNK5clang6driver10toolchains9DragonFly14buildAssemblerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains9DragonFly14buildAssemblerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildAssembler() /*const*//* override*/ {
    return new DragonflyStatics.Assembler(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DragonFly::buildLinker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 4666,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 4199,
   FQN="clang::driver::toolchains::DragonFly::buildLinker", NM="_ZNK5clang6driver10toolchains9DragonFly11buildLinkerEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains9DragonFly11buildLinkerEv")
  //</editor-fold>
  @Override protected Tool /*P*/ buildLinker() /*const*//* override*/ {
    return new DragonflyStatics.Linker(/*Deref*/this);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::DragonFly::~DragonFly">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 811,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 771,
   FQN="clang::driver::toolchains::DragonFly::~DragonFly", NM="_ZN5clang6driver10toolchains9DragonFlyD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains9DragonFlyD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }



  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
