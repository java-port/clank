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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.basic.target.*;


// WebAssembly target
/*template <typename Target> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyOSTargetInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 815,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 760,
 FQN="(anonymous namespace)::WebAssemblyOSTargetInfo", NM="_ZN12_GLOBAL__N_123WebAssemblyOSTargetInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123WebAssemblyOSTargetInfoE")
//</editor-fold>
public class WebAssemblyOSTargetInfo</*typename*/ Target extends TargetInfo>  extends /*public*/ OSTargetInfo<Target> {
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyOSTargetInfo::getOSDefines">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 817,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 762,
   FQN="(anonymous namespace)::WebAssemblyOSTargetInfo::getOSDefines", NM="_ZNK12_GLOBAL__N_123WebAssemblyOSTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123WebAssemblyOSTargetInfo12getOSDefinesERKN5clang11LangOptionsERKN4llvm6TripleERNS1_12MacroBuilderE")
  //</editor-fold>
  /*lowered*/protected final void getOSDefines(/*const*/ LangOptions /*&*/ Opts, /*const*/ Triple /*&*/ Triple, 
              MacroBuilder /*&*/ Builder) /*const*//* final*/ {
    // A common platform macro.
    if (Opts.POSIXThreads) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_REENTRANT"));
    }
    // Follow g++ convention and predefine _GNU_SOURCE for C++.
    if (Opts.CPlusPlus) {
      Builder.defineMacro(new Twine(/*KEEP_STR*/"_GNU_SOURCE"));
    }
  }

  
  // As an optimization, group static init code together in a section.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyOSTargetInfo::getStaticInitSectionSpecifier">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 828,
   old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", old_line = 773,
   FQN="(anonymous namespace)::WebAssemblyOSTargetInfo::getStaticInitSectionSpecifier", NM="_ZNK12_GLOBAL__N_123WebAssemblyOSTargetInfo29getStaticInitSectionSpecifierEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZNK12_GLOBAL__N_123WebAssemblyOSTargetInfo29getStaticInitSectionSpecifierEv")
  //</editor-fold>
  /*lowered*/public final /*const*/char$ptr/*char P*/ getStaticInitSectionSpecifier() /*const*//* final*/ {
    return $(".text.__startup");
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WebAssemblyOSTargetInfo::WebAssemblyOSTargetInfo<Target>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp", line = 833,
   FQN="(anonymous namespace)::WebAssemblyOSTargetInfo::WebAssemblyOSTargetInfo<Target>", NM="_ZN12_GLOBAL__N_123WebAssemblyOSTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Targets.cpp -nm=_ZN12_GLOBAL__N_123WebAssemblyOSTargetInfoC1ERKN4llvm6TripleERKN5clang13TargetOptionsE")
  //</editor-fold>
  public /*explicit*/ WebAssemblyOSTargetInfo(Target T, /*const*/ Triple /*&*/ Triple, 
      /*const*/ TargetOptions /*&*/ Opts) {
    /* : OSTargetInfo<Target>(Triple, Opts)*/ 
    //START JInit
    /*ParenListExpr*/super(T, Triple, Opts);
    //END JInit
    super.tgt.MCountName = $("__mcount");
    super.tgt.TheCXXABI.set(TargetCXXABI.Kind.WebAssembly);
  }

  
  public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
