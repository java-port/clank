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

package org.clang.ast.impl;

import org.clank.support.*;


/// Object used to treat all foldable expressions as constant expressions.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FoldConstant">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 809,
 FQN="(anonymous namespace)::FoldConstant", NM="_ZN12_GLOBAL__N_112FoldConstantE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112FoldConstantE")
//</editor-fold>
public class/*struct*/ FoldConstant implements Destructors.ClassWithDestructor {
  public final EvalInfo /*&*/ Info;
  public boolean Enabled;
  public boolean HadNoPriorDiags;
  public EvalInfo.EvaluationMode OldMode;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FoldConstant::FoldConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 815,
   FQN="(anonymous namespace)::FoldConstant::FoldConstant", NM="_ZN12_GLOBAL__N_112FoldConstantC1ERNS_8EvalInfoEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112FoldConstantC1ERNS_8EvalInfoEb")
  //</editor-fold>
  public /*explicit*/ FoldConstant(final EvalInfo /*&*/ Info, boolean Enabled) {
    // : Info(Info), Enabled(Enabled), HadNoPriorDiags(Info.EvalStatus.Diag && Info.EvalStatus.Diag->empty() && !Info.EvalStatus.HasSideEffects), OldMode(Info.EvalMode) 
    //START JInit
    this./*&*/Info=/*&*/Info;
    this.Enabled = Enabled;
    this.HadNoPriorDiags = (Info.EvalStatus.Diag != null)
       && Info.EvalStatus.Diag.empty()
       && !Info.EvalStatus.HasSideEffects;
    this.OldMode = Info.EvalMode;
    //END JInit
    if (Enabled
       && (Info.EvalMode == EvalInfo.EvaluationMode.EM_ConstantExpression
       || Info.EvalMode == EvalInfo.EvaluationMode.EM_ConstantExpressionUnevaluated)) {
      Info.EvalMode = EvalInfo.EvaluationMode.EM_ConstantFold;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FoldConstant::keepDiagnostics">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 827,
   FQN="(anonymous namespace)::FoldConstant::keepDiagnostics", NM="_ZN12_GLOBAL__N_112FoldConstant15keepDiagnosticsEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112FoldConstant15keepDiagnosticsEv")
  //</editor-fold>
  public void keepDiagnostics() {
    Enabled = false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FoldConstant::~FoldConstant">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 828,
   FQN="(anonymous namespace)::FoldConstant::~FoldConstant", NM="_ZN12_GLOBAL__N_112FoldConstantD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_112FoldConstantD0Ev")
  //</editor-fold>
  public void $destroy() {
    if (Enabled && HadNoPriorDiags && !Info.EvalStatus.Diag.empty()
       && !Info.EvalStatus.HasSideEffects) {
      Info.EvalStatus.Diag.clear();
    }
    Info.EvalMode = OldMode;
  }

  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + ", Enabled=" + Enabled // NOI18N
              + ", HadNoPriorDiags=" + HadNoPriorDiags // NOI18N
              + ", OldMode=" + OldMode; // NOI18N
  }
}
