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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;
import org.clang.basic.java.OptionalNotes;

/*template <class Derived> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4134,
 FQN="(anonymous namespace)::ExprEvaluatorBase", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBaseE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBaseE")
//</editor-fold>
public abstract class ExprEvaluatorBase</*class*/ Derived extends ExprEvaluatorBase<?>>  implements /*public*/ ConstStmtVisitorBool<Derived> {
/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::getDerived">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4138,
   FQN="(anonymous namespace)::ExprEvaluatorBase::getDerived", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase10getDerivedEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase10getDerivedEv")
  //</editor-fold>
  private Derived /*&*/ getDerived() {
    return ((/*static_cast*/Derived /*&*/ )(Native.$star(this)));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::DerivedSuccess">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4139,
   FQN="(anonymous namespace)::ExprEvaluatorBase::DerivedSuccess", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase14DerivedSuccessERKN5clang7APValueEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase14DerivedSuccessERKN5clang7APValueEPKNS1_4ExprE")
  //</editor-fold>
  private boolean DerivedSuccess(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E) {
    return getDerived().Success(V, E);
  }

  protected abstract boolean Success(final /*const*/ APValue /*&*/ V, /*const*/ Expr /*P*/ E);
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::DerivedZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4142,
   FQN="(anonymous namespace)::ExprEvaluatorBase::DerivedZeroInitialization", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase25DerivedZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase25DerivedZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  private boolean DerivedZeroInitialization(/*const*/ Expr /*P*/ E) {
    return getDerived().ZeroInitialization(E);
  }

  
  // Check whether a conditional operator with a non-constant condition is a
  // potential constant expression. If neither arm is a potential constant
  // expression, then the conditional operator is not either.
  /*template <typename ConditionalOperator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::CheckPotentialConstantConditional">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4150,
   FQN="(anonymous namespace)::ExprEvaluatorBase::CheckPotentialConstantConditional", NM="Tpl__ZN12_GLOBAL__N_117ExprEvaluatorBase33CheckPotentialConstantConditionalEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__ZN12_GLOBAL__N_117ExprEvaluatorBase33CheckPotentialConstantConditionalEPKT_")
  //</editor-fold>
  private </*typename*/ ConditionalOperator extends AbstractConditionalOperator> void CheckPotentialConstantConditional(/*const*/ ConditionalOperator /*P*/ E) {
    OptionalNotes Diag = null;
    try {
      assert (Info.checkingPotentialConstantExpression());
      
      // Speculatively evaluate both arms.
      Diag/*J*/= new OptionalNotes(8);
      {
        SpeculativeEvaluationRAII Speculate = null;
        try {
          Speculate/*J*/= /*ParenList*/new SpeculativeEvaluationRAII( Info, $AddrOf(Diag) );
          ConstStmtVisitorBool.super.Visit(E.getFalseExpr());
          if (Diag.empty()) {
            return;
          }
        } finally {
          if (Speculate != null) { Speculate.$destroy(); }
        }
      }
      {
        SpeculativeEvaluationRAII Speculate = null;
        try {
          Speculate/*J*/= /*ParenList*/new SpeculativeEvaluationRAII( Info, $AddrOf(Diag) );
          Diag.clear();
          ConstStmtVisitorBool.super.Visit(E.getTrueExpr());
          if (Diag.empty()) {
            return;
          }
        } finally {
          if (Speculate != null) { Speculate.$destroy(); }
        }
      }
      
      Error(E, diag.note_constexpr_conditional_never_const);
    } finally {
      if (Diag != null) { Diag.$destroy(); }
    }
  }

  
  /*template <typename ConditionalOperator> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::HandleConditionalOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4175,
   FQN="(anonymous namespace)::ExprEvaluatorBase::HandleConditionalOperator", NM="Tpl__ZN12_GLOBAL__N_117ExprEvaluatorBase25HandleConditionalOperatorEPKT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=Tpl__ZN12_GLOBAL__N_117ExprEvaluatorBase25HandleConditionalOperatorEPKT_")
  //</editor-fold>
  private </*typename*/ ConditionalOperator extends AbstractConditionalOperator> boolean HandleConditionalOperator(/*const*/ ConditionalOperator /*P*/ E) {
    bool$ref BoolResult = create_bool$ref();
    if (!EvaluateAsBooleanCondition(E.getCond(), BoolResult, Info)) {
      if (Info.checkingPotentialConstantExpression() && Info.noteFailure()) {
        CheckPotentialConstantConditional(E);
      }
      return false;
    }
    
    Expr /*P*/ EvalExpr = BoolResult.$deref() ? E.getTrueExpr() : E.getFalseExpr();
    return ConstStmtVisitorBool.super.Visit(EvalExpr);
  }

/*protected:*/
  protected final EvalInfo /*&*/ Info;
  /*typedef ConstStmtVisitor<Derived, bool> StmtVisitorTy*/
//  public final class StmtVisitorTy extends ConstStmtVisitorBool<Derived>{ };
  /*typedef ExprEvaluatorBase<Derived> ExprEvaluatorBaseTy*/
//  public final class ExprEvaluatorBaseTy extends ExprEvaluatorBase<Derived>{ };
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::CCEDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4192,
   FQN="(anonymous namespace)::ExprEvaluatorBase::CCEDiag", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase7CCEDiagEPKN5clang4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase7CCEDiagEPKN5clang4ExprEj")
  //</editor-fold>
  protected OptionalDiagnostic CCEDiag(/*const*/ Expr /*P*/ E, /*uint*/int D) {
    return Info.CCEDiag(E, D);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::ZeroInitialization">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4196,
   FQN="(anonymous namespace)::ExprEvaluatorBase::ZeroInitialization", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase18ZeroInitializationEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase18ZeroInitializationEPKN5clang4ExprE")
  //</editor-fold>
  protected boolean ZeroInitialization(/*const*/ Expr /*P*/ E) {
    return Error(E);
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::ExprEvaluatorBase<Derived>">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4199,
   FQN="(anonymous namespace)::ExprEvaluatorBase::ExprEvaluatorBase<Derived>", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBaseC1ERNS_8EvalInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBaseC1ERNS_8EvalInfoE")
  //</editor-fold>
  public ExprEvaluatorBase(final EvalInfo /*&*/ Info) {
    // : Info(Info) 
    //START JInit
    this./*&*/Info=/*&*/Info;
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::getEvalInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4201,
   FQN="(anonymous namespace)::ExprEvaluatorBase::getEvalInfo", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase11getEvalInfoEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase11getEvalInfoEv")
  //</editor-fold>
  public EvalInfo /*&*/ getEvalInfo() {
    return Info;
  }

  
  /// Report an evaluation error. This should only be called when an error is
  /// first discovered. When propagating an error, just return false.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4205,
   FQN="(anonymous namespace)::ExprEvaluatorBase::Error", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase5ErrorEPKN5clang4ExprEj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase5ErrorEPKN5clang4ExprEj")
  //</editor-fold>
  public boolean Error(/*const*/ Expr /*P*/ E, /*uint*/int D) {
    Info.FFDiag(E, D);
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::Error">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4209,
   FQN="(anonymous namespace)::ExprEvaluatorBase::Error", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase5ErrorEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase5ErrorEPKN5clang4ExprE")
  //</editor-fold>
  public boolean Error(/*const*/ Expr /*P*/ E) {
    return Error(E, diag.note_invalid_subexpr_in_const_expr);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4213,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitStmt", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase9VisitStmtEPKN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase9VisitStmtEPKN5clang4StmtE")
  //</editor-fold>
  public boolean VisitStmt(/*const*/ Stmt /*P*/ $Prm0) {
    throw new llvm_unreachable("Expression evaluator should not be called on stmts");
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4216,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase9VisitExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase9VisitExprEPKN5clang4ExprE")
  //</editor-fold>
  public boolean VisitExpr(/*const*/ Expr /*P*/ E) {
    return Error(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4220,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitParenExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase14VisitParenExprEPKN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase14VisitParenExprEPKN5clang9ParenExprE")
  //</editor-fold>
  public boolean VisitParenExpr(/*const*/ ParenExpr /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getSubExpr$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4222,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase19VisitUnaryExtensionEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase19VisitUnaryExtensionEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryExtension(/*const*/ UnaryOperator /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPlus">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4224,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPlus", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase14VisitUnaryPlusEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase14VisitUnaryPlusEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPlus(/*const*/ UnaryOperator /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitChooseExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4226,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitChooseExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase15VisitChooseExprEPKN5clang10ChooseExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase15VisitChooseExprEPKN5clang10ChooseExprE")
  //</editor-fold>
  public boolean VisitChooseExpr(/*const*/ ChooseExpr /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getChosenSubExpr());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitGenericSelectionExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4228,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitGenericSelectionExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase25VisitGenericSelectionExprEPKN5clang20GenericSelectionExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase25VisitGenericSelectionExprEPKN5clang20GenericSelectionExprE")
  //</editor-fold>
  public boolean VisitGenericSelectionExpr(/*const*/ GenericSelectionExpr /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getResultExpr$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitSubstNonTypeTemplateParmExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4230,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitSubstNonTypeTemplateParmExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase33VisitSubstNonTypeTemplateParmExprEPKN5clang28SubstNonTypeTemplateParmExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase33VisitSubstNonTypeTemplateParmExprEPKN5clang28SubstNonTypeTemplateParmExprE")
  //</editor-fold>
  public boolean VisitSubstNonTypeTemplateParmExpr(/*const*/ SubstNonTypeTemplateParmExpr /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getReplacement());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCXXDefaultArgExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4232,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCXXDefaultArgExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase22VisitCXXDefaultArgExprEPKN5clang17CXXDefaultArgExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase22VisitCXXDefaultArgExprEPKN5clang17CXXDefaultArgExprE")
  //</editor-fold>
  public boolean VisitCXXDefaultArgExpr(/*const*/ CXXDefaultArgExpr /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getExpr$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCXXDefaultInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4234,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCXXDefaultInitExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase23VisitCXXDefaultInitExprEPKN5clang18CXXDefaultInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase23VisitCXXDefaultInitExprEPKN5clang18CXXDefaultInitExprE")
  //</editor-fold>
  public boolean VisitCXXDefaultInitExpr(/*const*/ CXXDefaultInitExpr /*P*/ E) {
    // The initializer may not have been parsed yet, or might be erroneous.
    if (!(E.getExpr$Const() != null)) {
      return Error(E);
    }
    return ConstStmtVisitorBool.super.Visit(E.getExpr$Const());
  }

  // We cannot create any objects for which cleanups are required, so there is
  // nothing to do here; all cleanups must come from unevaluated subexpressions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitExprWithCleanups">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4242,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitExprWithCleanups", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase21VisitExprWithCleanupsEPKN5clang16ExprWithCleanupsE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase21VisitExprWithCleanupsEPKN5clang16ExprWithCleanupsE")
  //</editor-fold>
  public boolean VisitExprWithCleanups(/*const*/ ExprWithCleanups /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getSubExpr$Const());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCXXReinterpretCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4245,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCXXReinterpretCastExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase27VisitCXXReinterpretCastExprEPKN5clang22CXXReinterpretCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN4llvm15SmallVectorImplIiE12emplace_backIJEEEvDpOT_")
  //</editor-fold>
  public boolean VisitCXXReinterpretCastExpr(/*const*/ CXXReinterpretCastExpr /*P*/ E) {
    CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(0);
    return ((/*static_cast*/Derived /*P*/ )(this)).VisitCastExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCXXDynamicCastExpr">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4249,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCXXDynamicCastExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase23VisitCXXDynamicCastExprEPKN5clang18CXXDynamicCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN4llvm23SmallVectorTemplateBaseIiLb1EE9push_backERKi")
  //</editor-fold>
  public boolean VisitCXXDynamicCastExpr(/*const*/ CXXDynamicCastExpr /*P*/ E) {
    CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(1);
    return ((/*static_cast*/Derived /*P*/ )(this)).VisitCastExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4254,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ E) {
    switch (E.getOpcode()) {
     default:
      return Error(E);
     case BO_Comma:
      VisitIgnoredValue(E.getLHS());
      return ConstStmtVisitorBool.super.Visit(E.getRHS());
     case BO_PtrMemD:
     case BO_PtrMemI:
      {
        LValue Obj = null;
        APValue Result = null;
        try {
          Obj/*J*/= new LValue();
          if (Native.$not(HandleMemberPointerAccess(Info, E, Obj))) {
            return false;
          }
          Result/*J*/= new APValue();
          if (!handleLValueToRValueConversion(Info, E, E.getType(), Obj, Result)) {
            return false;
          }
          return DerivedSuccess(Result, E);
        } finally {
          if (Result != null) { Result.$destroy(); }
          if (Obj != null) { Obj.$destroy(); }
        }
      }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitBinaryConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4276,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitBinaryConditionalOperator", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase30VisitBinaryConditionalOperatorEPKN5clang25BinaryConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase30VisitBinaryConditionalOperatorEPKN5clang25BinaryConditionalOperatorE")
  //</editor-fold>
  public boolean VisitBinaryConditionalOperator(/*const*/ BinaryConditionalOperator /*P*/ E) {
    // Evaluate and cache the common expression. We treat it as a temporary,
    // even though it's not quite the same thing.
    if (!Evaluate(Info.CurrentCall.createTemporary(E.getOpaqueValue(), false), 
        Info, E.getCommon())) {
      return false;
    }
    
    return HandleConditionalOperator(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4286,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE")
  //</editor-fold>
  public boolean VisitConditionalOperator(/*const*/ ConditionalOperator /*P*/ E) {
    FoldConstant Fold = null;
    try {
      boolean IsBcpCall = false;
      {
        // If the condition (ignoring parens) is a __builtin_constant_p call,
        // the result is a constant expression if it can be folded without
        // side-effects. This is an important GNU extension. See GCC PR38377
        // for discussion.
        /*const*/ CallExpr /*P*/ CallCE = dyn_cast_CallExpr(E.getCond().IgnoreParenCasts());
        if ((CallCE != null)) {
          if (CallCE.getBuiltinCallee() == Builtin.ID.BI__builtin_constant_p.getValue()) {
            IsBcpCall = true;
          }
        }
      }
      
      // Always assume __builtin_constant_p(...) ? ... : ... is a potential
      // constant expression; we can't check whether it's potentially foldable.
      if (Info.checkingPotentialConstantExpression() && IsBcpCall) {
        return false;
      }
      
      Fold/*J*/= /*ParenList*/new FoldConstant( Info, IsBcpCall );
      if (!HandleConditionalOperator(E)) {
        Fold.keepDiagnostics();
        return false;
      }
      
      return true;
    } finally {
      if (Fold != null) { Fold.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitOpaqueValueExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4311,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitOpaqueValueExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase20VisitOpaqueValueExprEPKN5clang15OpaqueValueExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase20VisitOpaqueValueExprEPKN5clang15OpaqueValueExprE")
  //</editor-fold>
  public boolean VisitOpaqueValueExpr(/*const*/ OpaqueValueExpr /*P*/ E) {
    {
      APValue /*P*/ Value = Info.CurrentCall.getTemporary(E);
      if ((Value != null)) {
        return DerivedSuccess($Deref(Value), E);
      }
    }
    
    /*const*/ Expr /*P*/ Source = E.getSourceExpr();
    if (!(Source != null)) {
      return Error(E);
    }
    if (Source == E) { // sanity checking.
      assert (false) : "OpaqueValueExpr recursively refers to itself";
      return Error(E);
    }
    return ConstStmtVisitorBool.super.Visit(Source);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4325,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCallExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase13VisitCallExprEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase13VisitCallExprEPKN5clang8CallExprE")
  //</editor-fold>
  public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ E) {
    APValue Result = null;
    try {
      Result/*J*/= new APValue();
      if (!handleCallExpr(E, Result, null)) {
        return false;
      }
      return DerivedSuccess(Result, E);
    } finally {
      if (Result != null) { Result.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::handleCallExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4332,
   FQN="(anonymous namespace)::ExprEvaluatorBase::handleCallExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase14handleCallExprEPKN5clang8CallExprERNS1_7APValueEPKNS_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase14handleCallExprEPKN5clang8CallExprERNS1_7APValueEPKNS_6LValueE")
  //</editor-fold>
  public boolean handleCallExpr(/*const*/ CallExpr /*P*/ E, final APValue /*&*/ Result, 
                /*const*/ LValue /*P*/ ResultSlot) {
    LValue ThisVal = null;
    try {
      /*const*/ Expr /*P*/ Callee = E.getCallee$Const().IgnoreParens$Const();
      QualType CalleeType = Callee.getType();
      
      /*const*/ FunctionDecl /*P*/ FD = null;
      LValue /*P*/ This = null;
      ThisVal/*J*/= new LValue();
      ArrayRef</*const*/ Expr /*P*/ > Args = llvm.makeArrayRef(E.getArgs$Const(), E.getNumArgs());
      boolean HasQualifier = false;
      
      // Extract function decl and 'this' pointer from the callee.
      if (CalleeType.$arrow().isSpecificBuiltinType(BuiltinType.Kind.BoundMember.getValue())) {
        /*const*/ ValueDecl /*P*/ Member = null;
        {
          /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(Callee);
          if ((ME != null)) {
            // Explicit bound member calls, such as x.f() or p->g();
            if (!EvaluateObjectArgument(Info, ME.getBase(), ThisVal)) {
              return false;
            }
            Member = ME.getMemberDecl();
            This = $AddrOf(ThisVal);
            HasQualifier = ME.hasQualifier();
          } else {
            /*const*/ BinaryOperator /*P*/ BE = dyn_cast_BinaryOperator(Callee);
            if ((BE != null)) {
              // Indirect bound member calls ('.*' or '->*').
              Member = HandleMemberPointerAccess(Info, BE, ThisVal, false);
              if (!(Member != null)) {
                return false;
              }
              This = $AddrOf(ThisVal);
            } else {
              return Error(Callee);
            }
          }
        }
        
        FD = dyn_cast_FunctionDecl(Member);
        if (!(FD != null)) {
          return Error(Callee);
        }
      } else if (CalleeType.$arrow().isFunctionPointerType()) {
        LValue Call = null;
        try {
          Call/*J*/= new LValue();
          if (!EvaluatePointer(Callee, Call, Info)) {
            return false;
          }
          if (!Call.getLValueOffset().isZero()) {
            return Error(Callee);
          }
          FD = dyn_cast_or_null_FunctionDecl(Call.getLValueBase().dyn_cast(/*const*/ ValueDecl /*P*/.class));
          if (!(FD != null)) {
            return Error(Callee);
          }
          
          // Overloaded operator calls to member functions are represented as normal
          // calls with '*this' as the first argument.
          /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl((Decl)FD);
          if ((MD != null) && !MD.isStatic()) {
            // FIXME: When selecting an implicit conversion for an overloaded
            // operator delete, we sometimes try to evaluate calls to conversion
            // operators without a 'this' parameter!
            if (Args.empty()) {
              return Error(E);
            }
            if (!EvaluateObjectArgument(Info, Args.$at(0), ThisVal)) {
              return false;
            }
            This = $AddrOf(ThisVal);
            Args.$assignMove(Args.slice(1));
          }
          
          // Don't call function pointers which have been cast to some other type.
          if (!Info.Ctx.hasSameType(CalleeType.$arrow().getPointeeType(), FD.getType())) {
            return Error(E);
          }
        } finally {
          if (Call != null) { Call.$destroy(); }
        }
      } else {
        return Error(E);
      }
      if (Native.$bool(This) && !This.checkSubobject(Info, E, CheckSubobjectKind.CSK_This)) {
        return false;
      }
      
      // DR1358 allows virtual constexpr functions in some cases. Don't allow
      // calls to such functions in constant expressions.
      if ((This != null) && !HasQualifier
         && isa_CXXMethodDecl((Decl)FD) && cast_CXXMethodDecl((Decl)FD).isVirtual()) {
        return Error(E, diag.note_constexpr_virtual_call);
      }
      
      final type$ref</*const*/ FunctionDecl /*P*/ > Definition = create_type$ref();
      Stmt /*P*/ Body = FD.getBody(Definition);
      if (!CheckConstexprFunction(Info, E.getExprLoc(), FD, Definition.$deref(), Body)
         || !HandleFunctionCall(E.getExprLoc(), Definition.$deref(), This, Args, Body, Info, 
          Result, ResultSlot)) {
        return false;
      }
      
      return true;
    } finally {
      if (ThisVal != null) { ThisVal.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4417,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase24VisitCompoundLiteralExprEPKN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase24VisitCompoundLiteralExprEPKN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public boolean VisitCompoundLiteralExpr(/*const*/ CompoundLiteralExpr /*P*/ E) {
    return ConstStmtVisitorBool.super.Visit(E.getInitializer$Const());
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitInitListExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4420,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitInitListExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitInitListExprEPKN5clang12InitListExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitInitListExprEPKN5clang12InitListExprE")
  //</editor-fold>
  public boolean VisitInitListExpr(/*const*/ InitListExpr /*P*/ E) {
    if (E.getNumInits() == 0) {
      return DerivedZeroInitialization(E);
    }
    if (E.getNumInits() == 1) {
      return ConstStmtVisitorBool.super.Visit(E.getInit$Const(0));
    }
    return Error(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitImplicitValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4427,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitImplicitValueInitExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase26VisitImplicitValueInitExprEPKN5clang21ImplicitValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase26VisitImplicitValueInitExprEPKN5clang21ImplicitValueInitExprE")
  //</editor-fold>
  public boolean VisitImplicitValueInitExpr(/*const*/ ImplicitValueInitExpr /*P*/ E) {
    return DerivedZeroInitialization(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCXXScalarValueInitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4430,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCXXScalarValueInitExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase27VisitCXXScalarValueInitExprEPKN5clang22CXXScalarValueInitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase27VisitCXXScalarValueInitExprEPKN5clang22CXXScalarValueInitExprE")
  //</editor-fold>
  public boolean VisitCXXScalarValueInitExpr(/*const*/ CXXScalarValueInitExpr /*P*/ E) {
    return DerivedZeroInitialization(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCXXNullPtrLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4433,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCXXNullPtrLiteralExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase26VisitCXXNullPtrLiteralExprEPKN5clang21CXXNullPtrLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase26VisitCXXNullPtrLiteralExprEPKN5clang21CXXNullPtrLiteralExprE")
  //</editor-fold>
  public boolean VisitCXXNullPtrLiteralExpr(/*const*/ CXXNullPtrLiteralExpr /*P*/ E) {
    return DerivedZeroInitialization(E);
  }

  
  /// A member expression where the object is a prvalue is itself a prvalue.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4438,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitMemberExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase15VisitMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase15VisitMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  public boolean VisitMemberExpr(/*const*/ MemberExpr /*P*/ E) {
    APValue Val = null;
    SubobjectDesignator Designator = null;
    APValue Result = null;
    try {
      assert (!E.isArrow()) : "missing call to bound member function?";
      
      Val/*J*/= new APValue();
      if (!Evaluate(Val, Info, E.getBase())) {
        return false;
      }
      
      QualType BaseTy = E.getBase().getType();
      
      /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(E.getMemberDecl());
      if (!(FD != null)) {
        return Error(E);
      }
      assert (!FD.getType().$arrow().isReferenceType()) : "prvalue reference?";
      assert (BaseTy.$arrow().<RecordType>castAs$RecordType().getDecl().getCanonicalDecl() == FD.getParent$Const().getCanonicalDecl$Const()) : "record / field mismatch";
      
      CompleteObject Obj/*J*/= new CompleteObject($AddrOf(Val), new QualType(BaseTy));
      Designator/*J*/= new SubobjectDesignator(new QualType(BaseTy));
      Designator.addDeclUnchecked(FD);
      
      Result/*J*/= new APValue();
      return extractSubobject(Info, E, Obj, Designator, Result)
         && DerivedSuccess(Result, E);
    } finally {
      if (Result != null) { Result.$destroy(); }
      if (Designator != null) { Designator.$destroy(); }
      if (Val != null) { Val.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4462,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitCastExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      break;
     case CK_AtomicToNonAtomic:
      {
        APValue AtomicVal = null;
        try {
          AtomicVal/*J*/= new APValue();
          if (!EvaluateAtomic(E.getSubExpr$Const(), AtomicVal, Info)) {
            return false;
          }
          return DerivedSuccess(AtomicVal, E);
        } finally {
          if (AtomicVal != null) { AtomicVal.$destroy(); }
        }
      }
     case CK_NoOp:
     case CK_UserDefinedConversion:
      return ConstStmtVisitorBool.super.Visit(E.getSubExpr$Const());
     case CK_LValueToRValue:
      {
        LValue LVal = null;
        APValue RVal = null;
        try {
          LVal/*J*/= new LValue();
          if (!EvaluateLValue(E.getSubExpr$Const(), LVal, Info)) {
            return false;
          }
          RVal/*J*/= new APValue();
          // Note, we use the subexpression's type in order to retain cv-qualifiers.
          if (!handleLValueToRValueConversion(Info, E, E.getSubExpr$Const().getType(), 
              LVal, RVal)) {
            return false;
          }
          return DerivedSuccess(RVal, E);
        } finally {
          if (RVal != null) { RVal.$destroy(); }
          if (LVal != null) { LVal.$destroy(); }
        }
      }
    }
    
    return Error(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPostInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4494,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPostInc", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitUnaryPostIncEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitUnaryPostIncEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPostInc(/*const*/ UnaryOperator /*P*/ UO) {
    return VisitUnaryPostIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPostDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4497,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPostDec", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitUnaryPostDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitUnaryPostDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPostDec(/*const*/ UnaryOperator /*P*/ UO) {
    return VisitUnaryPostIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPostIncDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4500,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitUnaryPostIncDec", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase20VisitUnaryPostIncDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase20VisitUnaryPostIncDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPostIncDec(/*const*/ UnaryOperator /*P*/ UO) {
    LValue LVal = null;
    APValue RVal = null;
    try {
      if (!Info.getLangOpts().CPlusPlus14 && !Info.keepEvaluatingAfterFailure()) {
        return Error(UO);
      }
      
      LVal/*J*/= new LValue();
      if (!EvaluateLValue(UO.getSubExpr(), LVal, Info)) {
        return false;
      }
      RVal/*J*/= new APValue();
      if (!handleIncDec(this.Info, UO, LVal, UO.getSubExpr().getType(), 
          UO.isIncrementOp(), $AddrOf(RVal))) {
        return false;
      }
      return DerivedSuccess(RVal, UO);
    } finally {
      if (RVal != null) { RVal.$destroy(); }
      if (LVal != null) { LVal.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitStmtExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4514,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitStmtExpr", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase13VisitStmtExprEPKN5clang8StmtExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase13VisitStmtExprEPKN5clang8StmtExprE")
  //</editor-fold>
  public boolean VisitStmtExpr(/*const*/ StmtExpr /*P*/ E) {
    ScopeRAII Scope = null;
    try {
      // We will have checked the full-expressions inside the statement expression
      // when they were completed, and don't need to check them again now.
      if (Info.checkingForOverflow()) {
        return Error(E);
      }
      
      Scope/*J*/= /*ParenList*/new ScopeRAII(false, Info );
      /*const*/ CompoundStmt /*P*/ CS = E.getSubStmt$Const();
      if (CS.body_empty()) {
        return true;
      }
      
      for (type$ptr<Stmt /*P*/ /*const*/ /*P*/ > BI = $tryClone(CS.body_begin$Const()), 
          /*P*/ /*const*/ /*P*/ BE = $tryClone(CS.body_end$Const());; BI.$preInc()) {
        APValue ReturnValue = null;
        try {
          if ($eq_ptr(BI.$add(1), BE)) {
            /*const*/ Expr /*P*/ FinalExpr = dyn_cast_Expr(BI.$star());
            if (!(FinalExpr != null)) {
              Info.FFDiag((BI.$star()).getLocStart(), 
                  diag.note_constexpr_stmt_expr_unsupported);
              return false;
            }
            return this.Visit(FinalExpr);
          }
          
          ReturnValue/*J*/= new APValue();
          StmtResult Result = new StmtResult(ReturnValue, (/*const*/ LValue /*P*/ )null);
          EvalStmtResult ESR = EvaluateStmt(Result, Info, BI.$star());
          if (ESR != EvalStmtResult.ESR_Succeeded) {
            // FIXME: If the statement-expression terminated due to 'return',
            // 'break', or 'continue', it would be nice to propagate that to
            // the outer statement evaluation rather than bailing out.
            if (ESR != EvalStmtResult.ESR_Failed) {
              Info.FFDiag((BI.$star()).getLocStart(), 
                  diag.note_constexpr_stmt_expr_unsupported);
            }
            return false;
          }
        } finally {
          if (ReturnValue != null) { ReturnValue.$destroy(); }
        }
      }
      // JAVA: throw new llvm_unreachable("Return from function from the loop above.");
    } finally {
      if (Scope != null) { Scope.$destroy(); }
    }
  }

  
  /// Visit a value which is evaluated, but whose value is ignored.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitIgnoredValue">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4556,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitIgnoredValue", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitIgnoredValueEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase17VisitIgnoredValueEPKN5clang4ExprE")
  //</editor-fold>
  public void VisitIgnoredValue(/*const*/ Expr /*P*/ E) {
    EvaluateIgnoredValue(Info, E);
  }

  
  /// Potentially visit a MemberExpr's base expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ExprEvaluatorBase::VisitIgnoredBaseExpression">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4561,
   FQN="(anonymous namespace)::ExprEvaluatorBase::VisitIgnoredBaseExpression", NM="_ZN12_GLOBAL__N_117ExprEvaluatorBase26VisitIgnoredBaseExpressionEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_117ExprEvaluatorBase26VisitIgnoredBaseExpressionEPKN5clang4ExprE")
  //</editor-fold>
  public void VisitIgnoredBaseExpression(/*const*/ Expr /*P*/ E) {
    // While MSVC doesn't evaluate the base expression, it does diagnose the
    // presence of side-effecting behavior.
    if (Info.getLangOpts().MSVCCompat && !E.HasSideEffects(Info.Ctx)) {
      return;
    }
    VisitIgnoredValue(E);
  }

  
  @Override public String toString() {
    return "" + "Info=" + Info // NOI18N
              + super.toString(); // NOI18N
  }
}
