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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8183,
 FQN="(anonymous namespace)::FloatExprEvaluator", NM="_ZN12_GLOBAL__N_118FloatExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluatorE")
//</editor-fold>
public class FloatExprEvaluator extends /*public*/ ExprEvaluatorBase<FloatExprEvaluator> {
  private final APFloat /*&*/ Result;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::FloatExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8187,
   FQN="(anonymous namespace)::FloatExprEvaluator::FloatExprEvaluator", NM="_ZN12_GLOBAL__N_118FloatExprEvaluatorC1ERNS_8EvalInfoERN4llvm7APFloatE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluatorC1ERNS_8EvalInfoERN4llvm7APFloatE")
  //</editor-fold>
  public FloatExprEvaluator(final EvalInfo /*&*/ info, final APFloat /*&*/ result) {
    // : ExprEvaluatorBaseTy(info), Result(result) 
    //START JInit
    super(info);
    this./*&*/Result=/*&*/result;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::Success">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8190,
   FQN="(anonymous namespace)::FloatExprEvaluator::Success", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator7SuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  public boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ e) {
    Result.$assign(V.getFloat$Const());
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8195,
   FQN="(anonymous namespace)::FloatExprEvaluator::ZeroInitialization", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  public boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    Result.$assignMove(APFloat.getZero(Info.Ctx.getFloatTypeSemantics(E.getType())));
    return true;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8257,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitCallExpr", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    switch (Builtin.ID.valueOf(E.getBuiltinCallee())) {
     default:
      return super.VisitCallExpr(E);
     case BI__builtin_huge_val:
     case BI__builtin_huge_valf:
     case BI__builtin_huge_vall:
     case BI__builtin_inf:
     case BI__builtin_inff:
     case BI__builtin_infl:
      {
        final /*const*/ fltSemantics /*&*/ Sem = Info.Ctx.getFloatTypeSemantics(E.getType());
        Result.$assignMove(APFloat.getInf(Sem));
        return true;
      }
     case BI__builtin_nans:
     case BI__builtin_nansf:
     case BI__builtin_nansl:
      if (!TryEvaluateBuiltinNaN(Info.Ctx, E.getType(), E.getArg$Const(0), 
          true, Result)) {
        return Error(E);
      }
      return true;
     case BI__builtin_nan:
     case BI__builtin_nanf:
     case BI__builtin_nanl:
      // If this is __builtin_nan() turn this into a nan, otherwise we
      // can't constant fold it.
      if (!TryEvaluateBuiltinNaN(Info.Ctx, E.getType(), E.getArg$Const(0), 
          false, Result)) {
        return Error(E);
      }
      return true;
     case BI__builtin_fabs:
     case BI__builtin_fabsf:
     case BI__builtin_fabsl:
      if (!EvaluateFloat(E.getArg$Const(0), Result, Info)) {
        return false;
      }
      if (Result.isNegative()) {
        Result.changeSign();
      }
      return true;
     case BI__builtin_copysign:
     case BI__builtin_copysignf:
     case BI__builtin_copysignl:
      {
        APFloat RHS/*J*/= new APFloat(0.);
        if (!EvaluateFloat(E.getArg$Const(0), Result, Info)
           || !EvaluateFloat(E.getArg$Const(1), RHS, Info)) {
          return false;
        }
        Result.copySign(RHS);
        return true;
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitUnaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8346,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitUnaryOperator", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator18VisitUnaryOperatorEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator18VisitUnaryOperatorEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryOperator(/*const*/ UnaryOperator /*P*/ E) {
    switch (E.getOpcode()) {
     default:
      return Error(E);
     case UO_Plus:
      return EvaluateFloat(E.getSubExpr(), Result, Info);
     case UO_Minus:
      if (!EvaluateFloat(E.getSubExpr(), Result, Info)) {
        return false;
      }
      Result.changeSign();
      return true;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8359,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ E) {
    if (E.isPtrMemOp() || E.isAssignmentOp() || E.getOpcode() == BinaryOperatorKind.BO_Comma) {
      return super.VisitBinaryOperator(E);
    }
    
    APFloat RHS/*J*/= new APFloat(0.);
    boolean LHSOK = EvaluateFloat(E.getLHS(), Result, Info);
    if (!LHSOK && !Info.noteFailure()) {
      return false;
    }
    return EvaluateFloat(E.getRHS(), RHS, Info) && LHSOK
       && handleFloatFloatBinOp(Info, E, Result, E.getOpcode(), RHS);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitFloatingLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8371,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitFloatingLiteral", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator20VisitFloatingLiteralEPKN5clang15FloatingLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator20VisitFloatingLiteralEPKN5clang15FloatingLiteralE")
  //</editor-fold>
  public boolean VisitFloatingLiteral(/*const*/ FloatingLiteral /*P*/ E) {
    Result.$assignMove(E.getValue());
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8376,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    /*const*/ Expr /*P*/ SubExpr = E.getSubExpr$Const();
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_IntegralToFloating:
      {
        APSInt IntResult/*J*/= new APSInt();
        return EvaluateInteger(SubExpr, IntResult, Info)
           && HandleIntToFloatCast(Info, E, SubExpr.getType(), IntResult, 
            E.getType(), Result);
      }
     case CK_FloatingCast:
      {
        if (!Visit(SubExpr)) {
          return false;
        }
        return HandleFloatToFloatCast(Info, E, SubExpr.getType(), E.getType(), 
            Result);
      }
     case CK_FloatingComplexToReal:
      {
        ComplexValue V = null;
        try {
          V/*J*/= new ComplexValue();
          if (!EvaluateComplex(SubExpr, V, Info)) {
            return false;
          }
          Result.$assign(V.getComplexFloatReal());
          return true;
        } finally {
          if (V != null) { V.$destroy(); }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitUnaryReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8319,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitUnaryReal", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryReal(/*const*/ UnaryOperator /*P*/ E) {
    if (E.getSubExpr().getType().$arrow().isAnyComplexType()) {
      ComplexValue CV = null;
      try {
        CV/*J*/= new ComplexValue();
        if (!EvaluateComplex(E.getSubExpr(), CV, Info)) {
          return false;
        }
        Result.$assign(CV.FloatReal);
        return true;
      } finally {
        if (CV != null) { CV.$destroy(); }
      }
    }
    
    return Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FloatExprEvaluator::VisitUnaryImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 8331,
   FQN="(anonymous namespace)::FloatExprEvaluator::VisitUnaryImag", NM="_ZN12_GLOBAL__N_118FloatExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_118FloatExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryImag(/*const*/ UnaryOperator /*P*/ E) {
    if (E.getSubExpr().getType().$arrow().isAnyComplexType()) {
      ComplexValue CV = null;
      try {
        CV/*J*/= new ComplexValue();
        if (!EvaluateComplex(E.getSubExpr(), CV, Info)) {
          return false;
        }
        Result.$assign(CV.FloatImag);
        return true;
      } finally {
        if (CV != null) { CV.$destroy(); }
      }
    }
    
    VisitIgnoredValue(E.getSubExpr());
    final /*const*/ fltSemantics /*&*/ Sem = Info.Ctx.getFloatTypeSemantics(E.getType());
    Result.$assignMove(APFloat.getZero(Sem));
    return true;
  }

  
  @Override public String toString() {
    return "" + "Result=" + Result // NOI18N
              + super.toString(); // NOI18N
  }
// FIXME: Missing: array subscript of vector, member of vector
}
