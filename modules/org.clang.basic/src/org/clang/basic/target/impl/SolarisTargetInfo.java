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
import org.clang.basic.target.TargetInfo.*;
import static org.clang.basic.target.impl.TargetsStatics.*;


// Solaris target
/*template <typename Target> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SolarisTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 667,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 619,
 FQN="(anonymous namespace)::SolarisTargetInfo", NM="_ZN12_GLOBAL__N_117SolarisTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SolarisTargetInfoE")
//</editor-fold>
public class SolarisTargetInfo</*typename*/ Target extends TargetInfo>  extends /*public*/ OSTargetInfo<Target> {
/*protected:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SolarisTargetInfo::getOSDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 670,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 622,
   FQN="(anonymous namespace)::SolarisTargetInfo::getOSDefines", NM="_ZNK12_GLOBAL__N_117SolarisTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_117SolarisTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE")
  //</editor-fold>
  protected void getOSDefines(/*const*/ LangOptions /*&*/ Opts, /*const*/ Triple /*&*/ Triple, 
              MacroBuilder /*&*/ Builder) /*const*//* override*/ {
    DefineStd(Builder, new StringRef(/*KEEP_STR*/"sun"), Opts);
    DefineStd(Builder, new StringRef(/*KEEP_STR*/"unix"), Opts);
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__ELF__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__svr4__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__SVR4"));
    // Solaris headers require _XOPEN_SOURCE to be set to 600 for C99 and
    // newer, but to 500 for everything else.  feature_test.h has a check to
    // ensure that you are not using C99 with an old version of X/Open or C89
    // with a new version.
    if (Opts.C99) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_XOPEN_SOURCE"), new Twine(/*KEEP_STR*/"600"));
    } else {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_XOPEN_SOURCE"), new Twine(/*KEEP_STR*/"500"));
    }
    if (Opts.CPlusPlus) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"__C99FEATURES__"));
    }
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_LARGEFILE_SOURCE"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_LARGEFILE64_SOURCE"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"__EXTENSIONS__"));
    Builder.defineMacro(new Twine(/*KEEP_STR*/"_REENTRANT"));
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::SolarisTargetInfo::SolarisTargetInfo<Target>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 693,
   FQN="(anonymous namespace)::SolarisTargetInfo::SolarisTargetInfo<Target>", NM="_ZN12_GLOBAL__N_117SolarisTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_117SolarisTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public SolarisTargetInfo(Target T, /*const*/ Triple /*&*/ Triple, /*const*/ TargetOptions /*&*/ Opts) {
    /* : OSTargetInfo<Target>(Triple, Opts)*/ 
    //START JInit
    /*ParenListExpr*/super(T, Triple, Opts);
    //END JInit
    super.tgt.WCharType = IntType.SignedInt;
    // FIXME: WIntType should be SignedLong
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
