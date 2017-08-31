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
import org.clank.support.JavaDifferentiators.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5767,
 FQN="(anonymous namespace)::TemporaryExprEvaluator", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluatorE")
//</editor-fold>
public class TemporaryExprEvaluator extends /*public*/ LValueExprEvaluatorBase<TemporaryExprEvaluator> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::TemporaryExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5770,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::TemporaryExprEvaluator", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluatorC1ERNS_8EvalInfoERNS_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluatorC1ERNS_8EvalInfoERNS_6LValueE")
  //</editor-fold>
  public TemporaryExprEvaluator(final EvalInfo /*&*/ Info, final LValue /*&*/ Result) {
    // : LValueExprEvaluatorBaseTy(Info, Result) 
    //START JInit
    super(Info, Result);
    //END JInit
  }

  
  /// Visit an expression which constructs the value of this temporary.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::VisitConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5774,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::VisitConstructExpr", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluator18VisitConstructExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluator18VisitConstructExprEPKN5clang4ExprE")
  //</editor-fold>
  public boolean VisitConstructExpr(/*const*/ Expr /*P*/ E) {
    Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E), Info.CurrentCall.Index);
    return EvaluateInPlace(Info.CurrentCall.createTemporary(E, false), 
        Info, Result, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5780,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_ConstructorConversion:
      return VisitConstructExpr(E.getSubExpr$Const());
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5789,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::VisitInitListExpr", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluator17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public boolean VisitInitListExpr(/*const*/ InitListExpr /*P*/ E) {
    return VisitConstructExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::VisitCXXConstructExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5792,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::VisitCXXConstructExpr", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluator21VisitCXXConstructExprEPKN5clang16CXXConstructExprE")
  //</editor-fold>
  public boolean VisitCXXConstructExpr(/*const*/ CXXConstructExpr /*P*/ E) {
    return VisitConstructExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5795,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    return VisitConstructExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::TemporaryExprEvaluator::VisitCXXStdInitializerListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 5798,
   FQN="(anonymous namespace)::TemporaryExprEvaluator::VisitCXXStdInitializerListExpr", NM="_ZN12_GLOBAL__N_122TemporaryExprEvaluator30VisitCXXStdInitializerListExprEPKN5clang25CXXStdInitializerListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_122TemporaryExprEvaluator30VisitCXXStdInitializerListExprEPKN5clang25CXXStdInitializerListExprE")
  //</editor-fold>
  public boolean VisitCXXStdInitializerListExpr(/*const*/ CXXStdInitializerListExpr /*P*/ E) {
    return VisitConstructExpr(E);
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
