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

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


// x86-64 MinGW target
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MinGWX86_64TargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4463,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4110,
 FQN="(anonymous namespace)::MinGWX86_64TargetInfo", NM="_ZN12_GLOBAL__N_121MinGWX86_64TargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121MinGWX86_64TargetInfoE")
//</editor-fold>
public class MinGWX86_64TargetInfo extends /*public*/ WindowsX86_64TargetInfo implements Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MinGWX86_64TargetInfo::MinGWX86_64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4465,
   FQN="(anonymous namespace)::MinGWX86_64TargetInfo::MinGWX86_64TargetInfo", NM="_ZN12_GLOBAL__N_121MinGWX86_64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121MinGWX86_64TargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public MinGWX86_64TargetInfo(/*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : WindowsX86_64TargetInfo(Triple, Opts)*/ 
    //START JInit
    super(Triple, Opts);
    //END JInit
    // Mingw64 rounds long double size and alignment up to 16 bytes, but sticks
    // with x86 FP ops. Weird.
    super.tgt.LongDoubleWidth = super.tgt.LongDoubleAlign = $int2uchar(128);
    super.tgt.LongDoubleFormat = $AddrOf(APFloat.x87DoubleExtended);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MinGWX86_64TargetInfo::getTargetDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4473,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4120,
   FQN="(anonymous namespace)::MinGWX86_64TargetInfo::getTargetDefines", NM="_ZNK12_GLOBAL__N_121MinGWX86_64TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_121MinGWX86_64TargetInfo16getTargetDefinesERKN5clang11LangOptionsERNS1_12MacroBuilderE")
  //</editor-fold>
  @Override public void getTargetDefines(/*const*/ LangOptions /*&*/ Opts, 
                  MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    super.getTargetDefines(Opts, Builder);
    DefineStd(Builder, new StringRef(/*KEEP_STR*/"WIN64"), Opts);
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__MINGW64__"));
    addMinGWDefines(Opts, Builder);
    
    // GCC defines this macro when it is using __gxx_personality_seh0.
    if (!Opts.SjLjExceptions) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__SEH__"));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MinGWX86_64TargetInfo::~MinGWX86_64TargetInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 4463,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 4110,
   FQN="(anonymous namespace)::MinGWX86_64TargetInfo::~MinGWX86_64TargetInfo", NM="_ZN12_GLOBAL__N_121MinGWX86_64TargetInfoD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_121MinGWX86_64TargetInfoD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
