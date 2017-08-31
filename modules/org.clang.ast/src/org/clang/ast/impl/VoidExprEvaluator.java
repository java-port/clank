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
import org.clang.basic.*;
import org.clang.ast.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8944,
 FQN="(anonymous namespace)::VoidExprEvaluator", NM="_ZN12_GLOBAL__N_117VoidExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117VoidExprEvaluatorE")
//</editor-fold>
public class VoidExprEvaluator extends /*public*/ ExprEvaluatorBase<VoidExprEvaluator> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidExprEvaluator::VoidExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8947,
   FQN="(anonymous namespace)::VoidExprEvaluator::VoidExprEvaluator", NM="_ZN12_GLOBAL__N_117VoidExprEvaluatorC1ERNS_8EvalInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117VoidExprEvaluatorC1ERNS_8EvalInfoE")
  //</editor-fold>
  public VoidExprEvaluator(final EvalInfo /*&*/ Info) {
    // : ExprEvaluatorBaseTy(Info) 
    //START JInit
    super(Info);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8949,
   FQN="(anonymous namespace)::VoidExprEvaluator::Success", NM="_ZN12_GLOBAL__N_117VoidExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117VoidExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ e) {
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8951,
   FQN="(anonymous namespace)::VoidExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_117VoidExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117VoidExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_ToVoid:
      VisitIgnoredValue(E.getSubExpr$Const());
      return true;
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VoidExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8961,
   FQN="(anonymous namespace)::VoidExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_117VoidExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117VoidExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    switch (Builtin.ID.valueOf(E.getBuiltinCallee())) {
     default:
      return super.VisitCallExpr(E);
     case BI__assume:
     case BI__builtin_assume:
      // The argument is not evaluated!
      return true;
    }
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
