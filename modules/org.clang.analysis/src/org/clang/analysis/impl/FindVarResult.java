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

package org.clang.analysis.impl;

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.clang.ast.*;
import org.clang.analysis.impl.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindVarResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 267,
 FQN="(anonymous namespace)::FindVarResult", NM="_ZN12_GLOBAL__N_113FindVarResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_113FindVarResultE")
//</editor-fold>
public class FindVarResult {
  private /*const*/ VarDecl /*P*/ vd;
  private /*const*/ DeclRefExpr /*P*/ dr;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindVarResult::FindVarResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 271,
   FQN="(anonymous namespace)::FindVarResult::FindVarResult", NM="_ZN12_GLOBAL__N_113FindVarResultC1EPKN5clang7VarDeclEPKNS1_11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_113FindVarResultC1EPKN5clang7VarDeclEPKNS1_11DeclRefExprE")
  //</editor-fold>
  public FindVarResult(/*const*/ VarDecl /*P*/ vd, /*const*/ DeclRefExpr /*P*/ dr) {
    // : vd(vd), dr(dr) 
    //START JInit
    this.vd = vd;
    this.dr = dr;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindVarResult::getDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 273,
   FQN="(anonymous namespace)::FindVarResult::getDeclRefExpr", NM="_ZNK12_GLOBAL__N_113FindVarResult14getDeclRefExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_113FindVarResult14getDeclRefExprEv")
  //</editor-fold>
  public /*const*/ DeclRefExpr /*P*/ getDeclRefExpr() /*const*/ {
    return dr;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindVarResult::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 274,
   FQN="(anonymous namespace)::FindVarResult::getDecl", NM="_ZNK12_GLOBAL__N_113FindVarResult7getDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZNK12_GLOBAL__N_113FindVarResult7getDeclEv")
  //</editor-fold>
  public /*const*/ VarDecl /*P*/ getDecl() /*const*/ {
    return vd;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindVarResult::FindVarResult">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp", line = 267,
   FQN="(anonymous namespace)::FindVarResult::FindVarResult", NM="_ZN12_GLOBAL__N_113FindVarResultC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.analysis/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Analysis/UninitializedValues.cpp -nm=_ZN12_GLOBAL__N_113FindVarResultC1EOS0_")
  //</editor-fold>
  public /*inline*/ FindVarResult(JD$Move _dparam, final FindVarResult /*&&*/$Prm0) {
    // : vd(static_cast<FindVarResult &&>().vd), dr(static_cast<FindVarResult &&>().dr) 
    //START JInit
    this.vd = $Prm0.vd;
    this.dr = $Prm0.dr;
    //END JInit
  }

  
  @Override public String toString() {
    return "" + "vd=" + vd // NOI18N
              + ", dr=" + dr; // NOI18N
  }
}
