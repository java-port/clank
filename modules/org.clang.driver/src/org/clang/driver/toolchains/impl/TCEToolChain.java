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
import org.llvm.adt.*;
import org.llvm.option.*;
import org.clang.driver.*;

/// TCEToolChain - A tool chain using the llvm bitcode tools to perform
/// all subcommands. See http://tce.cs.tut.fi for our peculiar target.
//<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", line = 1016,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.h", old_line = 945,
 FQN="clang::driver::toolchains::TCEToolChain", NM="_ZN5clang6driver10toolchains12TCEToolChainE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/CrossWindowsToolChain.cpp -nm=_ZN5clang6driver10toolchains12TCEToolChainE")
//</editor-fold>
public class TCEToolChain extends /*public*/ ToolChain implements Destructors.ClassWithDestructor {
/*public:*/
  // End NaCl

  /// TCEToolChain - A tool chain using the llvm bitcode tools to perform
  /// all subcommands. See http://tce.cs.tut.fi for our peculiar target.
  /// Currently does not support anything else but compilation.
  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain::TCEToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3232,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2922,
   FQN="clang::driver::toolchains::TCEToolChain::TCEToolChain", NM="_ZN5clang6driver10toolchains12TCEToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains12TCEToolChainC1ERKNS0_6DriverERKN4llvm6TripleERKNS6_3opt7ArgListE")
  //</editor-fold>
  public TCEToolChain(/*const*/ Driver /*&*/ D, /*const*/ Triple /*&*/ Triple,
      /*const*/ ArgList /*&*/ Args) {
    /* : ToolChain(D, Triple, Args)*/
    //START JInit
    super(D, Triple, Args);
    //END JInit
    // Path mangling to find libexec
    std.string Path/*J*/= new std.string(getDriver().Dir);

    Path.$addassign(/*KEEP_STR*/"/../libexec");
    getProgramPaths().push_back(Path);
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain::~TCEToolChain">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3242,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2932,
   FQN="clang::driver::toolchains::TCEToolChain::~TCEToolChain", NM="_ZN5clang6driver10toolchains12TCEToolChainD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZN5clang6driver10toolchains12TCEToolChainD0Ev")
  //</editor-fold>
  @Override public void $destroy()/* override*/ {
    super.$destroy();
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain::IsMathErrnoDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3244,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2934,
   FQN="clang::driver::toolchains::TCEToolChain::IsMathErrnoDefault", NM="_ZNK5clang6driver10toolchains12TCEToolChain18IsMathErrnoDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains12TCEToolChain18IsMathErrnoDefaultEv")
  //</editor-fold>
  @Override public boolean IsMathErrnoDefault() /*const*//* override*/ {
    return true;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain::isPICDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3246,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2936,
   FQN="clang::driver::toolchains::TCEToolChain::isPICDefault", NM="_ZNK5clang6driver10toolchains12TCEToolChain12isPICDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains12TCEToolChain12isPICDefaultEv")
  //</editor-fold>
  @Override public boolean isPICDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain::isPIEDefault">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3248,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2938,
   FQN="clang::driver::toolchains::TCEToolChain::isPIEDefault", NM="_ZNK5clang6driver10toolchains12TCEToolChain12isPIEDefaultEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains12TCEToolChain12isPIEDefaultEv")
  //</editor-fold>
  @Override public boolean isPIEDefault() /*const*//* override*/ {
    return false;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::driver::toolchains::TCEToolChain::isPICDefaultForced">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", line = 3250,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp", old_line = 2940,
   FQN="clang::driver::toolchains::TCEToolChain::isPICDefaultForced", NM="_ZNK5clang6driver10toolchains12TCEToolChain18isPICDefaultForcedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.driver/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Driver/ToolChains.cpp -nm=_ZNK5clang6driver10toolchains12TCEToolChain18isPICDefaultForcedEv")
  //</editor-fold>
  @Override public boolean isPICDefaultForced() /*const*//* override*/ {
    return false;
  }



  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
