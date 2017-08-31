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

package org.clang.sema.impl;

import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;



/// \brief Helper class for checking expression in 'omp atomic [update]'
/// construct.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6002,
 FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker", NM="_ZN12_GLOBAL__N_125OpenMPAtomicUpdateCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_125OpenMPAtomicUpdateCheckerE")
//</editor-fold>
public class OpenMPAtomicUpdateChecker {
  /// \brief Error results for atomic update expressions.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::ExprAnalysisErrorCode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6004,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::ExprAnalysisErrorCode", NM="_ZN12_GLOBAL__N_125OpenMPAtomicUpdateChecker21ExprAnalysisErrorCodeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_125OpenMPAtomicUpdateChecker21ExprAnalysisErrorCodeE")
  //</editor-fold>
  private enum ExprAnalysisErrorCode implements Native.ComparableLower, Native.NativeUIntEnum {
    /// \brief A statement is not an expression statement.
    NotAnExpression(0),
    /// \brief Expression is not builtin binary or unary operation.
    NotABinaryOrUnaryExpression(NotAnExpression.getValue() + 1),
    /// \brief Unary operation is not post-/pre- increment/decrement operation.
    NotAnUnaryIncDecExpression(NotABinaryOrUnaryExpression.getValue() + 1),
    /// \brief An expression is not of scalar type.
    NotAScalarType(NotAnUnaryIncDecExpression.getValue() + 1),
    /// \brief A binary operation is not an assignment operation.
    NotAnAssignmentOp(NotAScalarType.getValue() + 1),
    /// \brief RHS part of the binary operation is not a binary expression.
    NotABinaryExpression(NotAnAssignmentOp.getValue() + 1),
    /// \brief RHS part is not additive/multiplicative/shift/biwise binary
    /// expression.
    NotABinaryOperator(NotABinaryExpression.getValue() + 1),
    /// \brief RHS binary operation does not have reference to the updated LHS
    /// part.
    NotAnUpdateExpression(NotABinaryOperator.getValue() + 1),
    /// \brief No errors is found.
    NoError(NotAnUpdateExpression.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static ExprAnalysisErrorCode valueOf(int val) {
      ExprAnalysisErrorCode out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final ExprAnalysisErrorCode[] VALUES;
      private static final ExprAnalysisErrorCode[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (ExprAnalysisErrorCode kind : ExprAnalysisErrorCode.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new ExprAnalysisErrorCode[min < 0 ? (1-min) : 0];
        VALUES = new ExprAnalysisErrorCode[max >= 0 ? (1+max) : 0];
        for (ExprAnalysisErrorCode kind : ExprAnalysisErrorCode.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private ExprAnalysisErrorCode(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((ExprAnalysisErrorCode)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((ExprAnalysisErrorCode)obj).value);}
    //</editor-fold>
  };
  /// \brief Reference to Sema.
  private final Sema /*&*/ SemaRef;
  /// \brief A location for note diagnostics (when error is found).
  private SourceLocation NoteLoc;
  /// \brief 'x' lvalue part of the source atomic expression.
  private Expr /*P*/ X;
  /// \brief 'expr' rvalue part of the source atomic expression.
  private Expr /*P*/ E;
  /// \brief Helper expression of the form
  /// 'OpaqueValueExpr(x) binop OpaqueValueExpr(expr)' or
  /// 'OpaqueValueExpr(expr) binop OpaqueValueExpr(x)'.
  private Expr /*P*/ UpdateExpr;
  /// \brief Is 'x' a LHS in a RHS part of full update expression. It is
  /// important for non-associative operations.
  private boolean IsXLHSInRHSPart;
  private BinaryOperatorKind Op;
  private SourceLocation OpLoc;
  /// \brief true if the source expression is a postfix unary operation, false
  /// if it is a prefix unary operation.
  private boolean IsPostfixUpdate;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::OpenMPAtomicUpdateChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6048,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::OpenMPAtomicUpdateChecker", NM="_ZN12_GLOBAL__N_125OpenMPAtomicUpdateCheckerC1ERN5clang4SemaE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_125OpenMPAtomicUpdateCheckerC1ERN5clang4SemaE")
  //</editor-fold>
  public OpenMPAtomicUpdateChecker(final Sema /*&*/ SemaRef) {
    // : SemaRef(SemaRef), NoteLoc(), X(null), E(null), UpdateExpr(null), IsXLHSInRHSPart(false), Op(BO_PtrMemD), OpLoc(), IsPostfixUpdate(false) 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.NoteLoc = new SourceLocation();
    this.X = null;
    this.E = null;
    this.UpdateExpr = null;
    this.IsXLHSInRHSPart = false;
    this.Op = BinaryOperatorKind.BO_PtrMemD;
    this.OpLoc = new SourceLocation();
    this.IsPostfixUpdate = false;
    //END JInit
  }

  /// \brief Check specified statement that it is suitable for 'atomic update'
  /// constructs and extract 'x', 'expr' and Operation from the original
  /// expression. If DiagId and NoteId == 0, then only check is performed
  /// without error notification.
  /// \param DiagId Diagnostic which should be emitted if error is found.
  /// \param NoteId Diagnostic note for the main error message.
  /// \return true if statement is not an update expression, false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::checkStatement">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6148,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::checkStatement", NM="_ZN12_GLOBAL__N_125OpenMPAtomicUpdateChecker14checkStatementEPN5clang4StmtEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_125OpenMPAtomicUpdateChecker14checkStatementEPN5clang4StmtEjj")
  //</editor-fold>
  public boolean checkStatement(Stmt /*P*/ S) {
    return checkStatement(S, 0, 
                0);
  }
  public boolean checkStatement(Stmt /*P*/ S, /*uint*/int DiagId/*= 0*/) {
    return checkStatement(S, DiagId, 
                0);
  }
  public boolean checkStatement(Stmt /*P*/ S, /*uint*/int DiagId/*= 0*/, 
                /*uint*/int NoteId/*= 0*/) {
    ExprAnalysisErrorCode ErrorFound = ExprAnalysisErrorCode.NoError;
    SourceLocation ErrorLoc/*J*/= new SourceLocation(), NoteLoc/*J*/= new SourceLocation();
    SourceRange ErrorRange/*J*/= new SourceRange(), NoteRange/*J*/= new SourceRange();
    {
      // Allowed constructs are:
      //  x++;
      //  x--;
      //  ++x;
      //  --x;
      //  x binop= expr;
      //  x = x binop expr;
      //  x = expr binop x;
      Expr /*P*/ AtomicBody = dyn_cast_Expr(S);
      if ((AtomicBody != null)) {
        AtomicBody = AtomicBody.IgnoreParenImpCasts();
        if (AtomicBody.getType().$arrow().isScalarType()
           || AtomicBody.isInstantiationDependent()) {
          {
            CompoundAssignOperator /*P*/ AtomicCompAssignOp = dyn_cast_CompoundAssignOperator(AtomicBody.IgnoreParenImpCasts());
            if ((AtomicCompAssignOp != null)) {
              // Check for Compound Assignment Operation
              Op = BinaryOperator.getOpForCompoundAssignment(AtomicCompAssignOp.getOpcode());
              OpLoc.$assignMove(AtomicCompAssignOp.getOperatorLoc());
              E = AtomicCompAssignOp.getRHS();
              X = AtomicCompAssignOp.getLHS();
              IsXLHSInRHSPart = true;
            } else {
              BinaryOperator /*P*/ AtomicBinOp = dyn_cast_BinaryOperator(AtomicBody.IgnoreParenImpCasts());
              if ((AtomicBinOp != null)) {
                // Check for Binary Operation
                if (checkBinaryOperation(AtomicBinOp, DiagId, NoteId)) {
                  return true;
                }
              } else {
                UnaryOperator /*P*/ AtomicUnaryOp = dyn_cast_UnaryOperator(AtomicBody.IgnoreParenImpCasts());
                if ((AtomicUnaryOp != null)) {
                  // Check for Unary Operation
                  if (AtomicUnaryOp.isIncrementDecrementOp()) {
                    IsPostfixUpdate = AtomicUnaryOp.isPostfix();
                    Op = AtomicUnaryOp.isIncrementOp() ? BinaryOperatorKind.BO_Add : BinaryOperatorKind.BO_Sub;
                    OpLoc.$assignMove(AtomicUnaryOp.getOperatorLoc());
                    X = AtomicUnaryOp.getSubExpr();
                    E = SemaRef.ActOnIntegerConstant(new SourceLocation(OpLoc), /*uint64_t Val=*/ 1).get();
                    IsXLHSInRHSPart = true;
                  } else {
                    ErrorFound = ExprAnalysisErrorCode.NotAnUnaryIncDecExpression;
                    ErrorLoc.$assignMove(AtomicUnaryOp.getExprLoc());
                    ErrorRange.$assignMove(AtomicUnaryOp.getSourceRange());
                    NoteLoc.$assignMove(AtomicUnaryOp.getOperatorLoc());
                    NoteRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc));
                  }
                } else if (!AtomicBody.isInstantiationDependent()) {
                  ErrorFound = ExprAnalysisErrorCode.NotABinaryOrUnaryExpression;
                  NoteLoc.$assign(ErrorLoc.$assignMove(AtomicBody.getExprLoc()));
                  NoteRange.$assign(ErrorRange.$assignMove(AtomicBody.getSourceRange()));
                }
              }
            }
          }
        } else {
          ErrorFound = ExprAnalysisErrorCode.NotAScalarType;
          NoteLoc.$assign(ErrorLoc.$assignMove(AtomicBody.getLocStart()));
          NoteRange.$assign(ErrorRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc)));
        }
      } else {
        ErrorFound = ExprAnalysisErrorCode.NotAnExpression;
        NoteLoc.$assign(ErrorLoc.$assignMove(S.getLocStart()));
        NoteRange.$assign(ErrorRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc)));
      }
    }
    if (ErrorFound != ExprAnalysisErrorCode.NoError && DiagId != 0 && NoteId != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ErrorLoc), DiagId)), ErrorRange));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(NoteLoc), NoteId)), ErrorFound), NoteRange));
        return true;
      } finally {
        $c$.$destroy();
      }
    } else if (SemaRef.CurContext.isDependentContext()) {
      E = X = UpdateExpr = null;
    }
    if (ErrorFound == ExprAnalysisErrorCode.NoError && (E != null) && (X != null)) {
      // Build an update expression of form 'OpaqueValueExpr(x) binop
      // OpaqueValueExpr(expr)' or 'OpaqueValueExpr(expr) binop
      // OpaqueValueExpr(x)' and then cast it to the type of the 'x' expression.
      OpaqueValueExpr /*P*/ OVEX = /*NEW_EXPR [Stmt::new]*//*new (SemaRef.getASTContext())*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.getASTContext(), (type$ptr<?> New$Mem)->{
          return new OpaqueValueExpr(X.getExprLoc(), X.getType(), ExprValueKind.VK_RValue);
       });
      OpaqueValueExpr /*P*/ OVEExpr = /*NEW_EXPR [Stmt::new]*//*new (SemaRef.getASTContext())*/ Stmt.$new_uint_ASTContext$C_uint(SemaRef.getASTContext(), (type$ptr<?> New$Mem)->{
          return new OpaqueValueExpr(E.getExprLoc(), E.getType(), ExprValueKind.VK_RValue);
       });
      ActionResultTTrue<Expr /*P*/ /*P*/> Update = SemaRef.CreateBuiltinBinOp(new SourceLocation(OpLoc), Op, IsXLHSInRHSPart ? OVEX : OVEExpr, 
          IsXLHSInRHSPart ? OVEExpr : OVEX);
      if (Update.isInvalid()) {
        return true;
      }
      Update.$assignMove(SemaRef.PerformImplicitConversion(Update.get(), X.getType(), 
              Sema.AssignmentAction.AA_Casting));
      if (Update.isInvalid()) {
        return true;
      }
      UpdateExpr = Update.get();
    }
    return ErrorFound != ExprAnalysisErrorCode.NoError;
  }

  /// \brief Return the 'x' lvalue part of the source atomic expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::getX">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6060,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::getX", NM="_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker4getXEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker4getXEv")
  //</editor-fold>
  public Expr /*P*/ getX() /*const*/ {
    return X;
  }

  /// \brief Return the 'expr' rvalue part of the source atomic expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::getExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6062,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::getExpr", NM="_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker7getExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker7getExprEv")
  //</editor-fold>
  public Expr /*P*/ getExpr() /*const*/ {
    return E;
  }

  /// \brief Return the update expression used in calculation of the updated
  /// value. Always has form 'OpaqueValueExpr(x) binop OpaqueValueExpr(expr)' or
  /// 'OpaqueValueExpr(expr) binop OpaqueValueExpr(x)'.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::getUpdateExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6066,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::getUpdateExpr", NM="_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker13getUpdateExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker13getUpdateExprEv")
  //</editor-fold>
  public Expr /*P*/ getUpdateExpr() /*const*/ {
    return UpdateExpr;
  }

  /// \brief Return true if 'x' is LHS in RHS part of full update expression,
  /// false otherwise.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::isXLHSInRHSPart">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6069,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::isXLHSInRHSPart", NM="_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker15isXLHSInRHSPartEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker15isXLHSInRHSPartEv")
  //</editor-fold>
  public boolean isXLHSInRHSPart() /*const*/ {
    return IsXLHSInRHSPart;
  }

  
  /// \brief true if the source expression is a postfix unary operation, false
  /// if it is a prefix unary operation.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::isPostfixUpdate">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6073,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::isPostfixUpdate", NM="_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker15isPostfixUpdateEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_125OpenMPAtomicUpdateChecker15isPostfixUpdateEv")
  //</editor-fold>
  public boolean isPostfixUpdate() /*const*/ {
    return IsPostfixUpdate;
  }

/*private:*/
  // namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPAtomicUpdateChecker::checkBinaryOperation">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 6081,
   FQN="(anonymous namespace)::OpenMPAtomicUpdateChecker::checkBinaryOperation", NM="_ZN12_GLOBAL__N_125OpenMPAtomicUpdateChecker20checkBinaryOperationEPN5clang14BinaryOperatorEjj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_125OpenMPAtomicUpdateChecker20checkBinaryOperationEPN5clang14BinaryOperatorEjj")
  //</editor-fold>
  private boolean checkBinaryOperation(BinaryOperator /*P*/ AtomicBinOp) {
    return checkBinaryOperation(AtomicBinOp, 0, 0);
  }
  private boolean checkBinaryOperation(BinaryOperator /*P*/ AtomicBinOp, /*uint*/int DiagId/*= 0*/) {
    return checkBinaryOperation(AtomicBinOp, DiagId, 0);
  }
  private boolean checkBinaryOperation(BinaryOperator /*P*/ AtomicBinOp, /*uint*/int DiagId/*= 0*/, /*uint*/int NoteId/*= 0*/) {
    ExprAnalysisErrorCode ErrorFound = ExprAnalysisErrorCode.NoError;
    SourceLocation ErrorLoc/*J*/= new SourceLocation(), NoteLoc/*J*/= new SourceLocation();
    SourceRange ErrorRange/*J*/= new SourceRange(), NoteRange/*J*/= new SourceRange();
    // Allowed constructs are:
    //  x = x binop expr;
    //  x = expr binop x;
    if (AtomicBinOp.getOpcode() == BinaryOperatorKind.BO_Assign) {
      X = AtomicBinOp.getLHS();
      {
        BinaryOperator /*P*/ AtomicInnerBinOp = dyn_cast_BinaryOperator(AtomicBinOp.getRHS().IgnoreParenImpCasts());
        if ((AtomicInnerBinOp != null)) {
          if (AtomicInnerBinOp.isMultiplicativeOp()
             || AtomicInnerBinOp.isAdditiveOp() || AtomicInnerBinOp.isShiftOp()
             || AtomicInnerBinOp.isBitwiseOp()) {
            FoldingSetNodeID XId = null;
            FoldingSetNodeID LHSId = null;
            FoldingSetNodeID RHSId = null;
            try {
              Op = AtomicInnerBinOp.getOpcode();
              OpLoc.$assignMove(AtomicInnerBinOp.getOperatorLoc());
              Expr /*P*/ LHS = AtomicInnerBinOp.getLHS();
              Expr /*P*/ RHS = AtomicInnerBinOp.getRHS();
              XId/*J*/= new FoldingSetNodeID(); LHSId/*J*/= new FoldingSetNodeID(); RHSId/*J*/= new FoldingSetNodeID();
              X.IgnoreParenImpCasts().Profile(XId, SemaRef.getASTContext(), 
                  /*Canonical=*/ true);
              LHS.IgnoreParenImpCasts().Profile(LHSId, SemaRef.getASTContext(), 
                  /*Canonical=*/ true);
              RHS.IgnoreParenImpCasts().Profile(RHSId, SemaRef.getASTContext(), 
                  /*Canonical=*/ true);
              if (XId.$eq(LHSId)) {
                E = RHS;
                IsXLHSInRHSPart = true;
              } else if (XId.$eq(RHSId)) {
                E = LHS;
                IsXLHSInRHSPart = false;
              } else {
                ErrorLoc.$assignMove(AtomicInnerBinOp.getExprLoc());
                ErrorRange.$assignMove(AtomicInnerBinOp.getSourceRange());
                NoteLoc.$assignMove(X.getExprLoc());
                NoteRange.$assignMove(X.getSourceRange());
                ErrorFound = ExprAnalysisErrorCode.NotAnUpdateExpression;
              }
            } finally {
              if (RHSId != null) { RHSId.$destroy(); }
              if (LHSId != null) { LHSId.$destroy(); }
              if (XId != null) { XId.$destroy(); }
            }
          } else {
            ErrorLoc.$assignMove(AtomicInnerBinOp.getExprLoc());
            ErrorRange.$assignMove(AtomicInnerBinOp.getSourceRange());
            NoteLoc.$assignMove(AtomicInnerBinOp.getOperatorLoc());
            NoteRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc));
            ErrorFound = ExprAnalysisErrorCode.NotABinaryOperator;
          }
        } else {
          NoteLoc.$assign(ErrorLoc.$assignMove(AtomicBinOp.getRHS().getExprLoc()));
          NoteRange.$assign(ErrorRange.$assignMove(AtomicBinOp.getRHS().getSourceRange()));
          ErrorFound = ExprAnalysisErrorCode.NotABinaryExpression;
        }
      }
    } else {
      ErrorLoc.$assignMove(AtomicBinOp.getExprLoc());
      ErrorRange.$assignMove(AtomicBinOp.getSourceRange());
      NoteLoc.$assignMove(AtomicBinOp.getOperatorLoc());
      NoteRange.$assignMove(new SourceRange(/*NO_COPY*/NoteLoc, /*NO_COPY*/NoteLoc));
      ErrorFound = ExprAnalysisErrorCode.NotAnAssignmentOp;
    }
    if (ErrorFound != ExprAnalysisErrorCode.NoError && DiagId != 0 && NoteId != 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ErrorLoc), DiagId)), ErrorRange));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(NoteLoc), NoteId)), ErrorFound), NoteRange));
        return true;
      } finally {
        $c$.$destroy();
      }
    } else if (SemaRef.CurContext.isDependentContext()) {
      E = X = UpdateExpr = null;
    }
    return ErrorFound != ExprAnalysisErrorCode.NoError;
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", NoteLoc=" + NoteLoc // NOI18N
              + ", X=" + X // NOI18N
              + ", E=" + E // NOI18N
              + ", UpdateExpr=" + UpdateExpr // NOI18N
              + ", IsXLHSInRHSPart=" + IsXLHSInRHSPart // NOI18N
              + ", Op=" + Op // NOI18N
              + ", OpLoc=" + OpLoc // NOI18N
              + ", IsPostfixUpdate=" + IsPostfixUpdate; // NOI18N
  }
}
