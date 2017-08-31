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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.sema.impl.SemaOpenMPStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


/// \brief Helper class for checking canonical form of the OpenMP loops and
/// extracting iteration space of each loop in the loop nest, that will be used
/// for IR generation.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3901,
 FQN="(anonymous namespace)::OpenMPIterationSpaceChecker", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceCheckerE")
//</editor-fold>
public class OpenMPIterationSpaceChecker {
  /// \brief Reference to Sema.
  private final Sema /*&*/ SemaRef;
  /// \brief A location for diagnostics (when there is no some better location).
  private SourceLocation DefaultLoc;
  /// \brief A location for diagnostics (when increment is not compatible).
  private SourceLocation ConditionLoc;
  /// \brief A source location for referring to loop init later.
  private SourceRange InitSrcRange;
  /// \brief A source location for referring to condition later.
  private SourceRange ConditionSrcRange;
  /// \brief A source location for referring to increment later.
  private SourceRange IncrementSrcRange;
  /// \brief Loop variable.
  private ValueDecl /*P*/ LCDecl/* = null*/;
  /// \brief Reference to loop variable.
  private Expr /*P*/ LCRef/* = null*/;
  /// \brief Lower bound (initializer for the var).
  private Expr /*P*/ LB/* = null*/;
  /// \brief Upper bound.
  private Expr /*P*/ UB/* = null*/;
  /// \brief Loop step (increment).
  private Expr /*P*/ Step/* = null*/;
  /// \brief This flag is true when condition is one of:
  ///   Var <  UB
  ///   Var <= UB
  ///   UB  >  Var
  ///   UB  >= Var
  private boolean TestIsLessOp/* = false*/;
  /// \brief This flag is true when condition is strict ( < or > ).
  private boolean TestIsStrictOp/* = false*/;
  /// \brief This flag is true when step is subtracted on each iteration.
  private boolean SubtractStep/* = false*/;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::OpenMPIterationSpaceChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3936,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::OpenMPIterationSpaceChecker", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceCheckerC1ERN5clang4SemaENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceCheckerC1ERN5clang4SemaENS1_14SourceLocationE")
  //</editor-fold>
  public OpenMPIterationSpaceChecker(final Sema /*&*/ SemaRef, SourceLocation DefaultLoc) {
    // : SemaRef(SemaRef), DefaultLoc(DefaultLoc), ConditionLoc(DefaultLoc), InitSrcRange(), ConditionSrcRange(), IncrementSrcRange(), LCDecl(null), LCRef(null), LB(null), UB(null), Step(null), TestIsLessOp(false), TestIsStrictOp(false), SubtractStep(false) 
    //START JInit
    this./*&*/SemaRef=/*&*/SemaRef;
    this.DefaultLoc = new SourceLocation(DefaultLoc);
    this.ConditionLoc = new SourceLocation(DefaultLoc);
    this.InitSrcRange = new SourceRange();
    this.ConditionSrcRange = new SourceRange();
    this.IncrementSrcRange = new SourceRange();
    /*InClass*/this.LCDecl = null;
    /*InClass*/this.LCRef = null;
    /*InClass*/this.LB = null;
    /*InClass*/this.UB = null;
    /*InClass*/this.Step = null;
    /*InClass*/this.TestIsLessOp = false;
    /*InClass*/this.TestIsStrictOp = false;
    /*InClass*/this.SubtractStep = false;
    //END JInit
  }

  /// \brief Check init-expr for canonical loop form and save loop counter
  /// variable - #Var and its initialization value - #LB.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4108,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckInit", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker9CheckInitEPN5clang4StmtEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker9CheckInitEPN5clang4StmtEb")
  //</editor-fold>
  public boolean CheckInit(Stmt /*P*/ S) {
    return CheckInit(S, true);
  }
  public boolean CheckInit(Stmt /*P*/ S, boolean EmitDiags/*= true*/) {
    // Check init-expr for canonical loop form and save loop counter
    // variable - #Var and its initialization value - #LB.
    // OpenMP [2.6] Canonical loop form. init-expr may be one of the following:
    //   var = lb
    //   integer-type var = lb
    //   random-access-iterator-type var = lb
    //   pointer-type var = lb
    //
    if (!(S != null)) {
      if (EmitDiags) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(SemaRef.Diag(new SourceLocation(DefaultLoc), diag.err_omp_loop_not_canonical_init)));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    {
      ExprWithCleanups /*P*/ ExprTemp = dyn_cast_ExprWithCleanups(S);
      if ((ExprTemp != null)) {
        if (!ExprTemp.cleanupsHaveSideEffects()) {
          S = ExprTemp.getSubExpr();
        }
      }
    }
    
    InitSrcRange.$assignMove(S.getSourceRange());
    {
      Expr /*P*/ E = dyn_cast_Expr(S);
      if ((E != null)) {
        S = E.IgnoreParens();
      }
    }
    {
      BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(S);
      if ((BO != null)) {
        if (BO.getOpcode() == BinaryOperatorKind.BO_Assign) {
          Expr /*P*/ LHS = BO.getLHS().IgnoreParens();
          {
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(LHS);
            if ((DRE != null)) {
              {
                OMPCapturedExprDecl /*P*/ CED = dyn_cast_OMPCapturedExprDecl(DRE.getDecl());
                if ((CED != null)) {
                  {
                    MemberExpr /*P*/ ME = dyn_cast_MemberExpr(getExprAsWritten(CED.getInit()));
                    if ((ME != null)) {
                      return SetLCDeclAndLB(ME.getMemberDecl(), ME, BO.getRHS());
                    }
                  }
                }
              }
              return SetLCDeclAndLB(DRE.getDecl(), DRE, BO.getRHS());
            }
          }
          {
            MemberExpr /*P*/ ME = dyn_cast_MemberExpr(LHS);
            if ((ME != null)) {
              if (ME.isArrow()
                 && isa_CXXThisExpr(ME.getBase().IgnoreParenImpCasts())) {
                return SetLCDeclAndLB(ME.getMemberDecl(), ME, BO.getRHS());
              }
            }
          }
        }
      } else {
        DeclStmt /*P*/ DS = dyn_cast_DeclStmt(S);
        if ((DS != null)) {
          if (DS.isSingleDecl()) {
            {
              VarDecl /*P*/ Var = dyn_cast_or_null_VarDecl(DS.getSingleDecl());
              if ((Var != null)) {
                if (Var.hasInit() && !Var.getType().$arrow().isReferenceType()) {
                  // Accept non-canonical init form here but emit ext. warning.
                  if (Var.getInitStyle() != VarDecl.InitializationStyle.CInit && EmitDiags) {
                    JavaCleaner $c$ = $createJavaCleaner();
                    try {
                      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(S.getLocStart(), 
                              diag.ext_omp_loop_not_canonical_init)), 
                          S.getSourceRange()));
                    } finally {
                      $c$.$destroy();
                    }
                  }
                  return SetLCDeclAndLB(Var, (Expr /*P*/ )null, Var.getInit());
                }
              }
            }
          }
        } else {
          CXXOperatorCallExpr /*P*/ CE = dyn_cast_CXXOperatorCallExpr(S);
          if ((CE != null)) {
            if (CE.getOperator() == OverloadedOperatorKind.OO_Equal) {
              Expr /*P*/ LHS = CE.getArg(0);
              {
                DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(LHS);
                if ((DRE != null)) {
                  {
                    OMPCapturedExprDecl /*P*/ CED = dyn_cast_OMPCapturedExprDecl(DRE.getDecl());
                    if ((CED != null)) {
                      {
                        MemberExpr /*P*/ ME = dyn_cast_MemberExpr(getExprAsWritten(CED.getInit()));
                        if ((ME != null)) {
                          return SetLCDeclAndLB(ME.getMemberDecl(), ME, BO.getRHS());
                        }
                      }
                    }
                  }
                  return SetLCDeclAndLB(DRE.getDecl(), DRE, CE.getArg(1));
                }
              }
              {
                MemberExpr /*P*/ ME = dyn_cast_MemberExpr(LHS);
                if ((ME != null)) {
                  if (ME.isArrow()
                     && isa_CXXThisExpr(ME.getBase().IgnoreParenImpCasts())) {
                    return SetLCDeclAndLB(ME.getMemberDecl(), ME, BO.getRHS());
                  }
                }
              }
            }
          }
        }
      }
    }
    if (Dependent() || SemaRef.CurContext.isDependentContext()) {
      return false;
    }
    if (EmitDiags) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(S.getLocStart(), diag.err_omp_loop_not_canonical_init)), 
            S.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    return true;
  }

  /// \brief Check test-expr for canonical form, save upper-bound (#UB), flags
  /// for less/greater and for strict/non-strict comparison.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4210,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckCond", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker9CheckCondEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker9CheckCondEPN5clang4ExprE")
  //</editor-fold>
  public boolean CheckCond(Expr /*P*/ S) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Check test-expr for canonical form, save upper-bound UB, flags for
      // less/greater and for strict/non-strict comparison.
      // OpenMP [2.6] Canonical loop form. Test-expr may be one of the following:
      //   var relational-op b
      //   b relational-op var
      //
      if (!(S != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DefaultLoc), diag.err_omp_loop_not_canonical_cond)), LCDecl));
        return true;
      }
      S = getExprAsWritten(S);
      SourceLocation CondLoc = S.getLocStart();
      {
        BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(S);
        if ((BO != null)) {
          if (BO.isRelationalOp()) {
            if (GetInitLCDecl(BO.getLHS()) == LCDecl) {
              return SetUB(BO.getRHS(), 
                  (BO.getOpcode() == BinaryOperatorKind.BO_LT || BO.getOpcode() == BinaryOperatorKind.BO_LE), 
                  (BO.getOpcode() == BinaryOperatorKind.BO_LT || BO.getOpcode() == BinaryOperatorKind.BO_GT), 
                  BO.getSourceRange(), BO.getOperatorLoc());
            }
            if (GetInitLCDecl(BO.getRHS()) == LCDecl) {
              return SetUB(BO.getLHS(), 
                  (BO.getOpcode() == BinaryOperatorKind.BO_GT || BO.getOpcode() == BinaryOperatorKind.BO_GE), 
                  (BO.getOpcode() == BinaryOperatorKind.BO_LT || BO.getOpcode() == BinaryOperatorKind.BO_GT), 
                  BO.getSourceRange(), BO.getOperatorLoc());
            }
          }
        } else {
          CXXOperatorCallExpr /*P*/ CE = dyn_cast_CXXOperatorCallExpr(S);
          if ((CE != null)) {
            if (CE.getNumArgs() == 2) {
              OverloadedOperatorKind Op = CE.getOperator();
              switch (Op) {
               case OO_Greater:
               case OO_GreaterEqual:
               case OO_Less:
               case OO_LessEqual:
                if (GetInitLCDecl(CE.getArg(0)) == LCDecl) {
                  return SetUB(CE.getArg(1), Op == OverloadedOperatorKind.OO_Less || Op == OverloadedOperatorKind.OO_LessEqual, 
                      Op == OverloadedOperatorKind.OO_Less || Op == OverloadedOperatorKind.OO_Greater, CE.getSourceRange(), 
                      CE.getOperatorLoc());
                }
                if (GetInitLCDecl(CE.getArg(1)) == LCDecl) {
                  return SetUB(CE.getArg(0), Op == OverloadedOperatorKind.OO_Greater || Op == OverloadedOperatorKind.OO_GreaterEqual, 
                      Op == OverloadedOperatorKind.OO_Less || Op == OverloadedOperatorKind.OO_Greater, CE.getSourceRange(), 
                      CE.getOperatorLoc());
                }
                break;
               default:
                break;
              }
            }
          }
        }
      }
      if (Dependent() || SemaRef.CurContext.isDependentContext()) {
        return false;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(CondLoc), diag.err_omp_loop_not_canonical_cond)), 
              S.getSourceRange()), LCDecl));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  /// \brief Check incr-expr for canonical loop form and return true if it
  /// does not conform, otherwise save loop step (#Step).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4296,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckInc", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker8CheckIncEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker8CheckIncEPN5clang4ExprE")
  //</editor-fold>
  public boolean CheckInc(Expr /*P*/ S) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Check incr-expr for canonical loop form and return true if it
      // does not conform.
      // OpenMP [2.6] Canonical loop form. Test-expr may be one of the following:
      //   ++var
      //   var++
      //   --var
      //   var--
      //   var += incr
      //   var -= incr
      //   var = var + incr
      //   var = incr + var
      //   var = var - incr
      //
      if (!(S != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DefaultLoc), diag.err_omp_loop_not_canonical_incr)), LCDecl));
        return true;
      }
      {
        ExprWithCleanups /*P*/ ExprTemp = dyn_cast_ExprWithCleanups(S);
        if ((ExprTemp != null)) {
          if (!ExprTemp.cleanupsHaveSideEffects()) {
            S = ExprTemp.getSubExpr();
          }
        }
      }
      
      IncrementSrcRange.$assignMove(S.getSourceRange());
      S = S.IgnoreParens();
      {
        UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(S);
        if ((UO != null)) {
          if (UO.isIncrementDecrementOp()
             && GetInitLCDecl(UO.getSubExpr()) == LCDecl) {
            return SetStep(SemaRef.ActOnIntegerConstant(UO.getLocStart(), 
                    $int2ulong((UO.isDecrementOp() ? -1 : 1))).get(), 
                false);
          }
        } else {
          BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(S);
          if ((BO != null)) {
            switch (BO.getOpcode()) {
             case BO_AddAssign:
             case BO_SubAssign:
              if (GetInitLCDecl(BO.getLHS()) == LCDecl) {
                return SetStep(BO.getRHS(), BO.getOpcode() == BinaryOperatorKind.BO_SubAssign);
              }
              break;
             case BO_Assign:
              if (GetInitLCDecl(BO.getLHS()) == LCDecl) {
                return CheckIncRHS(BO.getRHS());
              }
              break;
             default:
              break;
            }
          } else {
            CXXOperatorCallExpr /*P*/ CE = dyn_cast_CXXOperatorCallExpr(S);
            if ((CE != null)) {
              switch (CE.getOperator()) {
               case OO_PlusPlus:
               case OO_MinusMinus:
                if (GetInitLCDecl(CE.getArg(0)) == LCDecl) {
                  return SetStep(SemaRef.ActOnIntegerConstant(CE.getLocStart(), 
                          $int2ulong(((CE.getOperator() == OverloadedOperatorKind.OO_MinusMinus) ? -1 : 1))).get(), 
                      false);
                }
                break;
               case OO_PlusEqual:
               case OO_MinusEqual:
                if (GetInitLCDecl(CE.getArg(0)) == LCDecl) {
                  return SetStep(CE.getArg(1), CE.getOperator() == OverloadedOperatorKind.OO_MinusEqual);
                }
                break;
               case OO_Equal:
                if (GetInitLCDecl(CE.getArg(0)) == LCDecl) {
                  return CheckIncRHS(CE.getArg(1));
                }
                break;
               default:
                break;
              }
            }
          }
        }
      }
      if (Dependent() || SemaRef.CurContext.isDependentContext()) {
        return false;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(S.getLocStart(), diag.err_omp_loop_not_canonical_incr)), 
              S.getSourceRange()), LCDecl));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  /// \brief Return the loop counter variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::GetLoopDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3948,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::GetLoopDecl", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker11GetLoopDeclEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker11GetLoopDeclEv")
  //</editor-fold>
  public ValueDecl /*P*/ GetLoopDecl() /*const*/ {
    return LCDecl;
  }

  /// \brief Return the reference expression to loop counter variable.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::GetLoopDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3950,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::GetLoopDeclRefExpr", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker18GetLoopDeclRefExprEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker18GetLoopDeclRefExprEv")
  //</editor-fold>
  public Expr /*P*/ GetLoopDeclRefExpr() /*const*/ {
    return LCRef;
  }

  /// \brief Source range of the loop init.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::GetInitSrcRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3952,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::GetInitSrcRange", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker15GetInitSrcRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker15GetInitSrcRangeEv")
  //</editor-fold>
  public SourceRange GetInitSrcRange() /*const*/ {
    return new SourceRange(InitSrcRange);
  }

  /// \brief Source range of the loop condition.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::GetConditionSrcRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3954,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::GetConditionSrcRange", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker20GetConditionSrcRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker20GetConditionSrcRangeEv")
  //</editor-fold>
  public SourceRange GetConditionSrcRange() /*const*/ {
    return new SourceRange(ConditionSrcRange);
  }

  /// \brief Source range of the loop increment.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::GetIncrementSrcRange">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3956,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::GetIncrementSrcRange", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker20GetIncrementSrcRangeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker20GetIncrementSrcRangeEv")
  //</editor-fold>
  public SourceRange GetIncrementSrcRange() /*const*/ {
    return new SourceRange(IncrementSrcRange);
  }

  /// \brief True if the step should be subtracted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::ShouldSubtractStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3958,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::ShouldSubtractStep", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker18ShouldSubtractStepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker18ShouldSubtractStepEv")
  //</editor-fold>
  public boolean ShouldSubtractStep() /*const*/ {
    return SubtractStep;
  }

  /// \brief Build the expression to calculate the number of iterations.
  
  /// \brief Build the expression to calculate the number of iterations.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildNumIterations">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4391,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildNumIterations", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker18BuildNumIterationsEPN5clang5ScopeEbRN4llvm9MapVectorIPNS1_4ExprEPNS1_11DeclRefExprENS4_8DenseMapIS7_jNS4_12DenseMapInfoIS7_EENS4_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_S9_ESaISJ_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker18BuildNumIterationsEPN5clang5ScopeEbRN4llvm9MapVectorIPNS1_4ExprEPNS1_11DeclRefExprENS4_8DenseMapIS7_jNS4_12DenseMapInfoIS7_EENS4_6detail12DenseMapPairIS7_jEEEESt6vectorISt4pairIS7_S9_ESaISJ_EEEE")
  //</editor-fold>
  public Expr /*P*/ BuildNumIterations(Scope /*P*/ S, /*const*/boolean LimitedType, 
                    final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures) /*const*/ {
    ActionResultTTrue<Expr /*P*/ > Diff/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    QualType VarType = LCDecl.getType().getNonReferenceType();
    if (VarType.$arrow().isIntegerType() || VarType.$arrow().isPointerType()
       || SemaRef.getLangOpts().CPlusPlus) {
      // Upper - Lower
      Expr /*P*/ UBExpr = TestIsLessOp ? UB : LB;
      Expr /*P*/ LBExpr = TestIsLessOp ? LB : UB;
      Expr /*P*/ Upper = tryBuildCapture(SemaRef, UBExpr, Captures).get();
      Expr /*P*/ Lower = tryBuildCapture(SemaRef, LBExpr, Captures).get();
      if (!(Upper != null) || !(Lower != null)) {
        return null;
      }
      
      Diff.$assignMove(SemaRef.BuildBinOp(S, new SourceLocation(DefaultLoc), BinaryOperatorKind.BO_Sub, Upper, Lower));
      if (!Diff.isUsable() && (VarType.$arrow().getAsCXXRecordDecl() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // BuildBinOp already emitted error, this one is to point user to upper
          // and lower bound, and to tell what is passed to 'operator-'.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Upper.getLocStart(), diag.err_omp_loop_diff_cxx)), 
                  Upper.getSourceRange()), Lower.getSourceRange()));
          return null;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!Diff.isUsable()) {
      return null;
    }
    
    // Upper - Lower [- 1]
    if (TestIsStrictOp) {
      Diff.$assignMove(SemaRef.BuildBinOp(S, new SourceLocation(DefaultLoc), BinaryOperatorKind.BO_Sub, Diff.get(), 
              SemaRef.ActOnIntegerConstant(new SourceLocation(), 1).get()));
    }
    if (!Diff.isUsable()) {
      return null;
    }
    
    // Upper - Lower [- 1] + Step
    ActionResultTTrue<Expr /*P*/ /*P*/> NewStep = tryBuildCapture(SemaRef, Step, Captures);
    if (!NewStep.isUsable()) {
      return null;
    }
    Diff.$assignMove(SemaRef.BuildBinOp(S, new SourceLocation(DefaultLoc), BinaryOperatorKind.BO_Add, Diff.get(), NewStep.get()));
    if (!Diff.isUsable()) {
      return null;
    }
    
    // Parentheses (for dumping/debugging purposes only).
    Diff.$assignMove(SemaRef.ActOnParenExpr(new SourceLocation(DefaultLoc), new SourceLocation(DefaultLoc), Diff.get()));
    if (!Diff.isUsable()) {
      return null;
    }
    
    // (Upper - Lower [- 1] + Step) / Step
    Diff.$assignMove(SemaRef.BuildBinOp(S, new SourceLocation(DefaultLoc), BinaryOperatorKind.BO_Div, Diff.get(), NewStep.get()));
    if (!Diff.isUsable()) {
      return null;
    }
    
    // OpenMP runtime requires 32-bit or 64-bit loop variables.
    QualType Type = Diff.get().getType();
    final ASTContext /*&*/ C = SemaRef.Context;
    boolean UseVarType = VarType.$arrow().hasIntegerRepresentation()
       && $greater_ulong(C.getTypeSize(new QualType(Type)), C.getTypeSize(new QualType(VarType)));
    if (!Type.$arrow().isIntegerType() || UseVarType) {
      /*uint*/int NewSize = $ulong2uint(UseVarType ? C.getTypeSize(new QualType(VarType)) : C.getTypeSize(new QualType(Type)));
      boolean IsSigned = UseVarType ? VarType.$arrow().hasSignedIntegerRepresentation() : Type.$arrow().hasSignedIntegerRepresentation();
      Type.$assignMove(C.getIntTypeForBitwidth(NewSize, (IsSigned ? 1 : 0)));
      if (!SemaRef.Context.hasSameType(Diff.get().getType(), new QualType(Type))) {
        Diff.$assignMove(SemaRef.PerformImplicitConversion(Diff.get(), new QualType(Type), Sema.AssignmentAction.AA_Converting, /*AllowExplicit=*/ true));
        if (!Diff.isUsable()) {
          return null;
        }
      }
    }
    if (LimitedType) {
      /*uint*/int NewSize = ($greater_ulong_ullong(C.getTypeSize(new QualType(Type)), 32)) ? 64 : 32;
      if ($uint2ullong(NewSize) != C.getTypeSize(new QualType(Type))) {
        if ($less_uint_ulong(NewSize, C.getTypeSize(new QualType(Type)))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            assert (NewSize == 64) : "incorrect loop var size";
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(DefaultLoc), diag.warn_omp_loop_64_bit_var)), 
                    InitSrcRange), ConditionSrcRange));
          } finally {
            $c$.$destroy();
          }
        }
        QualType NewType = C.getIntTypeForBitwidth(NewSize, ((Type.$arrow().hasSignedIntegerRepresentation()
               || $less_ulong_uint(C.getTypeSize(new QualType(Type)), NewSize)) ? 1 : 0));
        if (!SemaRef.Context.hasSameType(Diff.get().getType(), new QualType(NewType))) {
          Diff.$assignMove(SemaRef.PerformImplicitConversion(Diff.get(), new QualType(NewType), 
                  Sema.AssignmentAction.AA_Converting, true));
          if (!Diff.isUsable()) {
            return null;
          }
        }
      }
    }
    
    return Diff.get();
  }

  /// \brief Build the precondition expression for the loops.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildPreCond">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4487,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildPreCond", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker12BuildPreCondEPN5clang5ScopeEPNS1_4ExprERN4llvm9MapVectorIS5_PNS1_11DeclRefExprENS6_8DenseMapIS5_jNS6_12DenseMapInfoIS5_EENS6_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S9_ESaISJ_EEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker12BuildPreCondEPN5clang5ScopeEPNS1_4ExprERN4llvm9MapVectorIS5_PNS1_11DeclRefExprENS6_8DenseMapIS5_jNS6_12DenseMapInfoIS5_EENS6_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S9_ESaISJ_EEEE")
  //</editor-fold>
  public Expr /*P*/ BuildPreCond(Scope /*P*/ S, Expr /*P*/ Cond, 
              final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures) /*const*/ {
    // Try to build LB <op> UB, where <op> is <, >, <=, or >=.
    boolean Suppress = SemaRef.getDiagnostics().getSuppressAllDiagnostics();
    SemaRef.getDiagnostics().setSuppressAllDiagnostics(/*Val=*/ true);
    
    ActionResultTTrue<Expr /*P*/ /*P*/> NewLB = tryBuildCapture(SemaRef, LB, Captures);
    ActionResultTTrue<Expr /*P*/ /*P*/> NewUB = tryBuildCapture(SemaRef, UB, Captures);
    if (!NewLB.isUsable() || !NewUB.isUsable()) {
      return null;
    }
    
    ActionResultTTrue<Expr /*P*/ /*P*/> CondExpr = SemaRef.BuildBinOp(S, new SourceLocation(DefaultLoc), TestIsLessOp ? (TestIsStrictOp ? BinaryOperatorKind.BO_LT : BinaryOperatorKind.BO_LE) : (TestIsStrictOp ? BinaryOperatorKind.BO_GT : BinaryOperatorKind.BO_GE), 
        NewLB.get(), NewUB.get());
    if (CondExpr.isUsable()) {
      if (!SemaRef.Context.hasSameUnqualifiedType(CondExpr.get().getType(), 
          SemaRef.Context.BoolTy.$QualType())) {
        CondExpr.$assignMove(SemaRef.PerformImplicitConversion(CondExpr.get(), SemaRef.Context.BoolTy.$QualType(), /*Action=*/ Sema.AssignmentAction.AA_Casting, 
                /*AllowExplicit=*/ true));
      }
    }
    SemaRef.getDiagnostics().setSuppressAllDiagnostics(Suppress);
    // Otherwise use original loop conditon and evaluate it in runtime.
    return CondExpr.isUsable() ? CondExpr.get() : Cond;
  }

  /// \brief Build reference expression to the counter be used for codegen.
  
  /// \brief Build reference expression to the counter be used for codegen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildCounterVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4516,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildCounterVar", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker15BuildCounterVarERN4llvm9MapVectorIPN5clang4ExprEPNS3_11DeclRefExprENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEERNS_10DSAStackTyE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker15BuildCounterVarERN4llvm9MapVectorIPN5clang4ExprEPNS3_11DeclRefExprENS1_8DenseMapIS5_jNS1_12DenseMapInfoIS5_EENS1_6detail12DenseMapPairIS5_jEEEESt6vectorISt4pairIS5_S7_ESaISH_EEEERNS_10DSAStackTyE")
  //</editor-fold>
  public DeclRefExpr /*P*/ BuildCounterVar(final MapVectorPtrPtr<Expr /*P*/ , DeclRefExpr /*P*/ > /*&*/ Captures, final DSAStackTy /*&*/ DSA) /*const*/ {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(LCDecl);
    if (!(VD != null)) {
      VD = SemaRef.IsOpenMPCapturedDecl(LCDecl);
      DeclRefExpr /*P*/ Ref = buildDeclRefExpr(SemaRef, VD, VD.getType().getNonReferenceType(), new SourceLocation(DefaultLoc));
      DSAStackTy.DSAVarData Data = DSA.getTopDSA(LCDecl, /*FromParent=*/ false);
      // If the loop control decl is explicitly marked as private, do not mark it
      // as captured again.
      if (!isOpenMPPrivate(Data.CKind) || !(Data.RefExpr != null)) {
        Captures.insert(std.make_pair_Ptr_Ptr(LCRef, Ref));
      }
      return Ref;
    }
    return buildDeclRefExpr(SemaRef, VD, VD.getType().getNonReferenceType(), 
        new SourceLocation(DefaultLoc));
  }

  /// \brief Build reference expression to the private counter be used for
  /// codegen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildPrivateCounterVar">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4534,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildPrivateCounterVar", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker22BuildPrivateCounterVarEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker22BuildPrivateCounterVarEv")
  //</editor-fold>
  public Expr /*P*/ BuildPrivateCounterVar() /*const*/ {
    if ((LCDecl != null) && !LCDecl.isInvalidDecl()) {
      QualType Type = LCDecl.getType().getNonReferenceType();
      VarDecl /*P*/ PrivateVar = buildVarDecl(SemaRef, new SourceLocation(DefaultLoc), new QualType(Type), LCDecl.getName(), 
          LCDecl.hasAttrs() ? $AddrOf(LCDecl.getAttrs()) : (SmallVector<Attr /*P*/>/*P*/ )null);
      if (PrivateVar.isInvalidDecl()) {
        return null;
      }
      return buildDeclRefExpr(SemaRef, PrivateVar, new QualType(Type), new SourceLocation(DefaultLoc));
    }
    return null;
  }

  /// \brief Build initization of the counter be used for codegen.
  
  /// \brief Build initization of the counter be used for codegen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildCounterInit">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4548,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildCounterInit", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker16BuildCounterInitEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker16BuildCounterInitEv")
  //</editor-fold>
  public Expr /*P*/ BuildCounterInit() /*const*/ {
    return LB;
  }

  /// \brief Build step of the counter be used for codegen.
  
  /// \brief Build step of the counter be used for codegen.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildCounterStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4551,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::BuildCounterStep", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker16BuildCounterStepEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker16BuildCounterStepEv")
  //</editor-fold>
  public Expr /*P*/ BuildCounterStep() /*const*/ {
    return Step;
  }

  /// \brief Return true if any expression is dependent.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::Dependent">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 3992,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::Dependent", NM="_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker9DependentEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZNK12_GLOBAL__N_127OpenMPIterationSpaceChecker9DependentEv")
  //</editor-fold>
  public boolean Dependent() /*const*/ {
    if (!(LCDecl != null)) {
      assert (!(LB != null) && !(UB != null) && !(Step != null));
      return false;
    }
    return LCDecl.getType().$arrow().isDependentType()
       || ((LB != null) && LB.isValueDependent()) || ((UB != null) && UB.isValueDependent())
       || ((Step != null) && Step.isValueDependent());
  }

/*private:*/
  /// \brief Check the right-hand side of an assignment in the increment
  /// expression.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckIncRHS">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4265,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::CheckIncRHS", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker11CheckIncRHSEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker11CheckIncRHSEPN5clang4ExprE")
  //</editor-fold>
  private boolean CheckIncRHS(Expr /*P*/ RHS) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // RHS of canonical loop form increment can be:
      //   var + incr
      //   incr + var
      //   var - incr
      //
      RHS = RHS.IgnoreParenImpCasts();
      {
        BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(RHS);
        if ((BO != null)) {
          if (BO.isAdditiveOp()) {
            boolean IsAdd = BO.getOpcode() == BinaryOperatorKind.BO_Add;
            if (GetInitLCDecl(BO.getLHS()) == LCDecl) {
              return SetStep(BO.getRHS(), !IsAdd);
            }
            if (IsAdd && GetInitLCDecl(BO.getRHS()) == LCDecl) {
              return SetStep(BO.getLHS(), false);
            }
          }
        } else {
          CXXOperatorCallExpr /*P*/ CE = dyn_cast_CXXOperatorCallExpr(RHS);
          if ((CE != null)) {
            boolean IsAdd = CE.getOperator() == OverloadedOperatorKind.OO_Plus;
            if ((IsAdd || CE.getOperator() == OverloadedOperatorKind.OO_Minus) && CE.getNumArgs() == 2) {
              if (GetInitLCDecl(CE.getArg(0)) == LCDecl) {
                return SetStep(CE.getArg(1), !IsAdd);
              }
              if (IsAdd && GetInitLCDecl(CE.getArg(1)) == LCDecl) {
                return SetStep(CE.getArg(0), false);
              }
            }
          }
        }
      }
      if (Dependent() || SemaRef.CurContext.isDependentContext()) {
        return false;
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(RHS.getLocStart(), diag.err_omp_loop_not_canonical_incr)), 
              RHS.getSourceRange()), LCDecl));
      return true;
    } finally {
      $c$.$destroy();
    }
  }

  /// \brief Helper to set loop counter variable and its initializer.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::SetLCDeclAndLB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4017,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::SetLCDeclAndLB", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker14SetLCDeclAndLBEPN5clang9ValueDeclEPNS1_4ExprES5_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker14SetLCDeclAndLBEPN5clang9ValueDeclEPNS1_4ExprES5_")
  //</editor-fold>
  private boolean SetLCDeclAndLB(ValueDecl /*P*/ NewLCDecl, 
                Expr /*P*/ NewLCRefExpr, 
                Expr /*P*/ NewLB) {
    // State consistency checking to ensure correct usage.
    assert (LCDecl == null && LB == null && LCRef == null && UB == null && Step == null && !TestIsLessOp && !TestIsStrictOp);
    if (!(NewLCDecl != null) || !(NewLB != null)) {
      return true;
    }
    LCDecl = getCanonicalDecl(NewLCDecl);
    LCRef = NewLCRefExpr;
    {
      CXXConstructExpr /*P*/ CE = dyn_cast_or_null_CXXConstructExpr(NewLB);
      if ((CE != null)) {
        {
          /*const*/ CXXConstructorDecl /*P*/ Ctor = CE.getConstructor();
          if ((Ctor != null)) {
            if ((Ctor.isCopyOrMoveConstructor()
               || Ctor.isConvertingConstructor(/*AllowExplicit=*/ false))
               && $greater_uint(CE.getNumArgs(), 0) && CE.getArg(0) != null) {
              NewLB = CE.getArg(0).IgnoreParenImpCasts();
            }
          }
        }
      }
    }
    LB = NewLB;
    return false;
  }

  /// \brief Helper to set upper bound.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::SetUB">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4037,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::SetUB", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker5SetUBEPN5clang4ExprEbbNS1_11SourceRangeENS1_14SourceLocationE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker5SetUBEPN5clang4ExprEbbNS1_11SourceRangeENS1_14SourceLocationE")
  //</editor-fold>
  private boolean SetUB(Expr /*P*/ NewUB, boolean LessOp, boolean StrictOp, 
       SourceRange SR, SourceLocation SL) {
    // State consistency checking to ensure correct usage.
    assert (LCDecl != null && LB != null && UB == null && Step == null && !TestIsLessOp && !TestIsStrictOp);
    if (!(NewUB != null)) {
      return true;
    }
    UB = NewUB;
    TestIsLessOp = LessOp;
    TestIsStrictOp = StrictOp;
    ConditionSrcRange.$assign(SR);
    ConditionLoc.$assign(SL);
    return false;
  }

  /// \brief Helper to set loop increment.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::OpenMPIterationSpaceChecker::SetStep">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp", line = 4052,
   FQN="(anonymous namespace)::OpenMPIterationSpaceChecker::SetStep", NM="_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker7SetStepEPN5clang4ExprEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOpenMP.cpp -nm=_ZN12_GLOBAL__N_127OpenMPIterationSpaceChecker7SetStepEPN5clang4ExprEb")
  //</editor-fold>
  private boolean SetStep(Expr /*P*/ NewStep, boolean Subtract) {
    // State consistency checking to ensure correct usage.
    assert (LCDecl != null && LB != null && Step == null);
    if (!(NewStep != null)) {
      return true;
    }
    if (!NewStep.isValueDependent()) {
      // Check that the step is integer expression.
      SourceLocation StepLoc = NewStep.getLocStart();
      ActionResultTTrue<Expr /*P*/ > Val = SemaRef.PerformOpenMPImplicitIntegerConversion(new SourceLocation(StepLoc), NewStep);
      if (Val.isInvalid()) {
        return true;
      }
      NewStep = Val.get();
      
      // OpenMP [2.6, Canonical Loop Form, Restrictions]
      //  If test-expr is of form var relational-op b and relational-op is < or
      //  <= then incr-expr must cause var to increase on each iteration of the
      //  loop. If test-expr is of form var relational-op b and relational-op is
      //  > or >= then incr-expr must cause var to decrease on each iteration of
      //  the loop.
      //  If test-expr is of form b relational-op var and relational-op is < or
      //  <= then incr-expr must cause var to decrease on each iteration of the
      //  loop. If test-expr is of form b relational-op var and relational-op is
      //  > or >= then incr-expr must cause var to increase on each iteration of
      //  the loop.
      APSInt Result/*J*/= new APSInt();
      boolean IsConstant = NewStep.isIntegerConstantExpr(Result, SemaRef.Context);
      boolean IsUnsigned = !NewStep.getType().$arrow().hasSignedIntegerRepresentation();
      boolean IsConstNeg = IsConstant && Result.isSigned() && (Subtract != Result.isNegative());
      boolean IsConstPos = IsConstant && Result.isSigned() && (Subtract == Result.isNegative());
      boolean IsConstZero = IsConstant && !Result.getBoolValue();
      if ((UB != null) && (IsConstZero
         || (TestIsLessOp ? (IsConstNeg || (IsUnsigned && Subtract)) : (IsConstPos || (IsUnsigned && !Subtract))))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(NewStep.getExprLoc(), 
                          diag.err_omp_loop_incr_not_compatible)), 
                      LCDecl), TestIsLessOp), NewStep.getSourceRange()));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(ConditionLoc), 
                      diag.note_omp_loop_cond_requres_compatible_incr)), 
                  TestIsLessOp), ConditionSrcRange));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      if (TestIsLessOp == Subtract) {
        NewStep = SemaRef.CreateBuiltinUnaryOp(NewStep.getExprLoc(), UnaryOperatorKind.UO_Minus, 
            NewStep).get();
        Subtract = !Subtract;
      }
    }
    
    Step = NewStep;
    SubtractStep = Subtract;
    return false;
  }

  
  @Override public String toString() {
    return "" + "SemaRef=" + "[Sema]" // NOI18N
              + ", DefaultLoc=" + DefaultLoc // NOI18N
              + ", ConditionLoc=" + ConditionLoc // NOI18N
              + ", InitSrcRange=" + InitSrcRange // NOI18N
              + ", ConditionSrcRange=" + ConditionSrcRange // NOI18N
              + ", IncrementSrcRange=" + IncrementSrcRange // NOI18N
              + ", LCDecl=" + LCDecl // NOI18N
              + ", LCRef=" + LCRef // NOI18N
              + ", LB=" + LB // NOI18N
              + ", UB=" + UB // NOI18N
              + ", Step=" + Step // NOI18N
              + ", TestIsLessOp=" + TestIsLessOp // NOI18N
              + ", TestIsStrictOp=" + TestIsStrictOp // NOI18N
              + ", SubtractStep=" + SubtractStep; // NOI18N
  }
}
