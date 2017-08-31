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

package org.clang.basic.target.impl;

import org.clank.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64leTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5993,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5594,
 FQN="(anonymous namespace)::AArch64leTargetInfo", NM="_ZN12_GLOBAL__N_119AArch64leTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_119AArch64leTargetInfoE")
//</editor-fold>
public class AArch64leTargetInfo extends /*public*/ AArch64TargetInfo implements Destructors.ClassWithDestructor {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64leTargetInfo::setDataLayout">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5994,
   FQN="(anonymous namespace)::AArch64leTargetInfo::setDataLayout", NM="_ZN12_GLOBAL__N_119AArch64leTargetInfo13setDataLayoutEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_119AArch64leTargetInfo13setDataLayoutEv")
  //</editor-fold>
  @Override protected/*private*/ void setDataLayout()/* override*/ {
    if (getTriple().isOSBinFormatMachO()) {
      resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:o-i64:64-i128:128-n32:64-S128"));
    } else {
      resetDataLayout(new StringRef(/*KEEP_STR*/"e-m:e-i8:8:32-i16:16:32-i64:64-i128:128-n32:64-S128"));
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64leTargetInfo::AArch64leTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6002,
   FQN="(anonymous namespace)::AArch64leTargetInfo::AArch64leTargetInfo", NM="_ZN12_GLOBAL__N_119AArch64leTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_119AArch64leTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public AArch64leTargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : AArch64TargetInfo(Triple, Opts)*/ 
    //START JInit
    super(Triple, Opts);
    //END JInit
    BigEndian = false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64leTargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 6006,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5607,
   FQN="(anonymous namespace)::AArch64leTargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_119AArch64leTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_119AArch64leTargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__AARCH64EL__"));
    super.getTargetDefines(Opts, Builder);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::AArch64leTargetInfo::~AArch64leTargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 5993,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 5594,
   FQN="(anonymous namespace)::AArch64leTargetInfo::~AArch64leTargetInfo", NM="_ZN12_GLOBAL__N_119AArch64leTargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_119AArch64leTargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
