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

package org.clang.staticanalyzer.checkers.impl;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clank.support.Native.NativePOD;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowCheck">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 35,
 FQN="(anonymous namespace)::MallocOverflowCheck", NM="_ZN12_GLOBAL__N_119MallocOverflowCheckE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_119MallocOverflowCheckE")
//</editor-fold>
public class/*struct*/ MallocOverflowCheck implements Destructors.ClassWithDestructor, NativePOD<MallocOverflowCheck> {
  public /*const*/ BinaryOperator /*P*/ mulop;
  public /*const*/ Expr /*P*/ variable;
  public APSInt maxVal;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowCheck::MallocOverflowCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 40,
   FQN="(anonymous namespace)::MallocOverflowCheck::MallocOverflowCheck", NM="_ZN12_GLOBAL__N_119MallocOverflowCheckC1EPKN5clang14BinaryOperatorEPKNS1_4ExprEN4llvm6APSIntE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_119MallocOverflowCheckC1EPKN5clang14BinaryOperatorEPKNS1_4ExprEN4llvm6APSIntE")
  //</editor-fold>
  public MallocOverflowCheck(/*const*/ BinaryOperator /*P*/ m, /*const*/ Expr /*P*/ v, APSInt val) {
    // : mulop(m), variable(v), maxVal(std::move(val)) 
    //START JInit
    this.mulop = m;
    this.variable = v;
    this.maxVal = new APSInt(JD$Move.INSTANCE, std.move(val));
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowCheck::MallocOverflowCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 35,
   FQN="(anonymous namespace)::MallocOverflowCheck::MallocOverflowCheck", NM="_ZN12_GLOBAL__N_119MallocOverflowCheckC1EOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_119MallocOverflowCheckC1EOS0_")
  //</editor-fold>
  public /*inline*/ MallocOverflowCheck(JD$Move _dparam, final MallocOverflowCheck /*&&*/$Prm0) {
    // : mulop(static_cast<MallocOverflowCheck &&>().mulop), variable(static_cast<MallocOverflowCheck &&>().variable), maxVal(static_cast<MallocOverflowCheck &&>().maxVal) 
    //START JInit
    this.mulop = $Prm0.mulop;
    this.variable = $Prm0.variable;
    this.maxVal = new APSInt(JD$Move.INSTANCE, $Prm0.maxVal);
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowCheck::~MallocOverflowCheck">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 35,
   FQN="(anonymous namespace)::MallocOverflowCheck::~MallocOverflowCheck", NM="_ZN12_GLOBAL__N_119MallocOverflowCheckD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_119MallocOverflowCheckD0Ev")
  //</editor-fold>
  public /*inline*/ void $destroy() {
    //START JDestroy
    maxVal.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MallocOverflowCheck::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 35,
   FQN="(anonymous namespace)::MallocOverflowCheck::operator=", NM="_ZN12_GLOBAL__N_119MallocOverflowCheckaSEOS0_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_119MallocOverflowCheckaSEOS0_")
  //</editor-fold>
  public /*inline*/ MallocOverflowCheck /*&*/ $assignMove(final MallocOverflowCheck /*&&*/$Prm0) {
    this.mulop = $Prm0.mulop;
    this.variable = $Prm0.variable;
    this.maxVal.$assignMove($Prm0.maxVal);
    return /*Deref*/this;
  }

  public /*inline*/ MallocOverflowCheck /*&*/ $assign(final MallocOverflowCheck /*&&*/$Prm0) {
    this.mulop = $Prm0.mulop;
    this.variable = $Prm0.variable;
    this.maxVal.$assign($Prm0.maxVal);
    return /*Deref*/this;
  }

  MallocOverflowCheck() {
    this.mulop = null;
    this.variable = null;
    this.maxVal = new APSInt();
  }

  @Override public MallocOverflowCheck clone() {
    return new MallocOverflowCheck().$assign(this);
  }
  
  @Override public String toString() {
    return "" + "mulop=" + mulop // NOI18N
              + ", variable=" + variable // NOI18N
              + ", maxVal=" + maxVal; // NOI18N
  }
}
