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

package org.clang.codegen.impl;

import org.clank.support.*;
import org.clang.basic.*;
import org.clang.driver.frontend.CodeGenOptions;
import org.llvm.transforms.ipo.PassManagerBuilder;


// We need this wrapper to access LangOpts and CGOpts from extension functions
// that we add to the PassManagerBuilder.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassManagerBuilderWrapper">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 116,
 FQN="(anonymous namespace)::PassManagerBuilderWrapper", NM="_ZN12_GLOBAL__N_125PassManagerBuilderWrapperE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_125PassManagerBuilderWrapperE")
//</editor-fold>
public class PassManagerBuilderWrapper extends /*public*/ PassManagerBuilder implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassManagerBuilderWrapper::PassManagerBuilderWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 118,
   FQN="(anonymous namespace)::PassManagerBuilderWrapper::PassManagerBuilderWrapper", NM="_ZN12_GLOBAL__N_125PassManagerBuilderWrapperC1ERKN5clang14CodeGenOptionsERKNS1_11LangOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_125PassManagerBuilderWrapperC1ERKN5clang14CodeGenOptionsERKNS1_11LangOptionsE")
  //</editor-fold>
  public PassManagerBuilderWrapper(final /*const*/ CodeGenOptions /*&*/ CGOpts, 
      final /*const*/ LangOptions /*&*/ LangOpts) {
    // : PassManagerBuilder(), CGOpts(CGOpts), LangOpts(LangOpts) 
    //START JInit
    super();
    this./*&*/CGOpts=/*&*/CGOpts;
    this./*&*/LangOpts=/*&*/LangOpts;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassManagerBuilderWrapper::getCGOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 121,
   FQN="(anonymous namespace)::PassManagerBuilderWrapper::getCGOpts", NM="_ZNK12_GLOBAL__N_125PassManagerBuilderWrapper9getCGOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK12_GLOBAL__N_125PassManagerBuilderWrapper9getCGOptsEv")
  //</editor-fold>
  public /*const*/ CodeGenOptions /*&*/ getCGOpts() /*const*/ {
    return CGOpts;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassManagerBuilderWrapper::getLangOpts">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 122,
   FQN="(anonymous namespace)::PassManagerBuilderWrapper::getLangOpts", NM="_ZNK12_GLOBAL__N_125PassManagerBuilderWrapper11getLangOptsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZNK12_GLOBAL__N_125PassManagerBuilderWrapper11getLangOptsEv")
  //</editor-fold>
  public /*const*/ LangOptions /*&*/ getLangOpts() /*const*/ {
    return LangOpts;
  }

/*private:*/
  private final /*const*/ CodeGenOptions /*&*/ CGOpts;
  private final /*const*/ LangOptions /*&*/ LangOpts;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PassManagerBuilderWrapper::~PassManagerBuilderWrapper">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp", line = 116,
   FQN="(anonymous namespace)::PassManagerBuilderWrapper::~PassManagerBuilderWrapper", NM="_ZN12_GLOBAL__N_125PassManagerBuilderWrapperD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.codegen/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/BackendUtil.cpp -nm=_ZN12_GLOBAL__N_125PassManagerBuilderWrapperD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  @Override public String toString() {
    return "" + "CGOpts=" + CGOpts // NOI18N
              + ", LangOpts=" + LangOpts // NOI18N
              + super.toString(); // NOI18N
  }
}
