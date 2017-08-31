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

package org.clang.staticanalyzer.core.ento;

import org.clank.support.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerFunctionPointers.*;

//<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 51,
 FQN="clang::ento::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>", NM="_ZN5clang4ento9CheckerFnIFT_DpT0_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento9CheckerFnIFT_DpT0_EEE")
//</editor-fold>
public class CheckerFnT1ToT<RET, Ps> {
  /*typedef RET (*Func)(void *, Ps...)*/
//  public final class Func extends VoidPtrVarArgs2RET{ };
  private VoidPtrVarArgs2RET<RET, Ps> Fn;
/*public:*/
  public CheckerBase /*P*/ Checker;
  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 57,
   FQN="clang::ento::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>", NM="_ZN5clang4ento9CheckerFnIFT_DpT0_EEC1EPNS0_11CheckerBaseEPFS2_PvS4_E",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZN5clang4ento9CheckerFnIFT_DpT0_EEC1EPNS0_11CheckerBaseEPFS2_PvS4_E")
  //</editor-fold>
  public CheckerFnT1ToT(CheckerBase /*P*/ checker, VoidPtrVarArgs2RET<RET, Ps> fn) {
    // : Fn(fn), Checker(checker) 
    //START JInit
    this.Fn = /*ParenListExpr*/fn;
    this.Checker = checker;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ento::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>::operator()">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/StaticAnalyzer/Core/CheckerManager.h", line = 58,
   FQN="clang::ento::CheckerFn<type-parameter-0-0 (type-parameter-0-1...)>::operator()", NM="_ZNK5clang4ento9CheckerFnIFT_DpT0_EEclES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/CheckerManager.cpp -nm=_ZNK5clang4ento9CheckerFnIFT_DpT0_EEclES4_")
  //</editor-fold>
  public RET $call(Ps... ps) /*const*/ {
    return Fn.$call(Checker, ps);
  }

  
  @Override public String toString() {
    return "" + "Fn=" + Fn // NOI18N
              + ", Checker=" + Checker; // NOI18N
  }
}
