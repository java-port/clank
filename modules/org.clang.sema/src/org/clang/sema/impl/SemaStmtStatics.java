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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaStmtStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL10EqEnumValsRKSt4pairIN4llvm6APSIntEPN5clang16EnumConstantDeclEES7_;_ZL11CmpCaseValsRKSt4pairIN4llvm6APSIntEPN5clang8CaseStmtEES7_;_ZL11CmpEnumValsRKSt4pairIN4llvm6APSIntEPN5clang16EnumConstantDeclEES7_;_ZL12AdjustAPSIntRN4llvm6APSIntEjb;_ZL14checkCaseValueRN5clang4SemaENS_14SourceLocationERKN4llvm6APSIntEjb;_ZL20hasDeducedReturnTypePN5clang12FunctionDeclE;_ZL21BuildNonArrayForRangeRN5clang4SemaEPNS_4ExprES3_NS_8QualTypeEPNS_7VarDeclES6_NS_14SourceLocationEPNS_20OverloadCandidateSetEPNS_12ActionResultIS3_Lb1EEESC_PN12_GLOBAL__N_116BeginEndFunctionE;_ZL21FinishForRangeVarDeclRN5clang4SemaEPNS_7VarDeclEPNS_4ExprENS_14SourceLocationEi;_ZL24CheckJumpOutOfSEHFinallyRN5clang4SemaENS_14SourceLocationERKNS_5ScopeE;_ZL24DiagnoseUnusedComparisonRN5clang4SemaEPKNS_4ExprE;_ZL25ObjCEnumerationCollectionPN5clang4ExprE;_ZL28buildCapturedStmtCaptureListRN4llvm15SmallVectorImplIN5clang12CapturedStmt7CaptureEEERNS0_IPNS1_4ExprEEENS_8ArrayRefINS1_4sema18CapturingScopeInfo7CaptureEEE;_ZL30DiagnoseForRangeVariableCopiesRN5clang4SemaEPKNS_15CXXForRangeStmtE;_ZL30GetTypeBeforeIntegralPromotionRPN5clang4ExprE;_ZL30RebuildForRangeWithDereferenceRN5clang4SemaEPNS_5ScopeENS_14SourceLocationES4_PNS_4StmtES4_PNS_4ExprES4_S4_;_ZL33ShouldDiagnoseSwitchCaseNotInEnumRKN5clang4SemaEPKNS_8EnumDeclEPKNS_4ExprERPSt4pairIN4llvm6APSIntEPNS_16EnumConstantDeclEESG_RKSB_;_ZL35DiagnoseForRangeConstVariableCopiesRN5clang4SemaEPKNS_7VarDeclE;_ZL39DiagnoseForRangeReferenceVariableCopiesRN5clang4SemaEPKNS_7VarDeclENS_8QualTypeE;_ZN12_GLOBAL__N_120BuildForRangeVarDeclERN5clang4SemaENS0_14SourceLocationENS0_8QualTypeEPKc;_ZN12_GLOBAL__N_120ProcessIterationStmtERN5clang4SemaEPNS0_4StmtERbRPNS0_11DeclRefExprE;_ZN12_GLOBAL__N_126CheckForRedundantIterationERN5clang4SemaEPNS0_4ExprEPNS0_4StmtE;_ZN12_GLOBAL__N_128NoteForRangeBeginEndFunctionERN5clang4SemaEPNS0_4ExprENS_16BeginEndFunctionE;_ZN12_GLOBAL__N_132CheckForLoopConditionalStatementERN5clang4SemaEPNS0_4ExprES4_PNS0_4StmtE; -static-type=SemaStmtStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaStmtStatics {


/// \brief Diagnose unused comparisons, both builtin and overloaded operators.
/// For '==' and '!=', suggest fixits for '=' or '|='.
///
/// Adding a cast to void (or other expression wrappers) will prevent the
/// warning from firing.
//<editor-fold defaultstate="collapsed" desc="DiagnoseUnusedComparison">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 128,
 FQN="DiagnoseUnusedComparison", NM="_ZL24DiagnoseUnusedComparisonRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL24DiagnoseUnusedComparisonRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static boolean DiagnoseUnusedComparison(final Sema /*&*/ S, /*const*/ Expr /*P*/ E) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SourceLocation Loc/*J*/= new SourceLocation();
    boolean IsNotEqual, CanAssign, IsRelational;
    {
      
      /*const*/ BinaryOperator /*P*/ Op = dyn_cast_BinaryOperator(E);
      if ((Op != null)) {
        if (!Op.isComparisonOp()) {
          return false;
        }
        
        IsRelational = Op.isRelationalOp();
        Loc.$assignMove(Op.getOperatorLoc());
        IsNotEqual = Op.getOpcode() == BinaryOperatorKind.BO_NE;
        CanAssign = Op.getLHS().IgnoreParenImpCasts().isLValue();
      } else {
        /*const*/ CXXOperatorCallExpr /*P*/ Op$1 = dyn_cast_CXXOperatorCallExpr(E);
        if ((Op$1 != null)) {
          switch (Op$1.getOperator()) {
           default:
            return false;
           case OO_EqualEqual:
           case OO_ExclaimEqual:
            IsRelational = false;
            break;
           case OO_Less:
           case OO_Greater:
           case OO_GreaterEqual:
           case OO_LessEqual:
            IsRelational = true;
            break;
          }
          
          Loc.$assignMove(Op$1.getOperatorLoc());
          IsNotEqual = Op$1.getOperator() == OverloadedOperatorKind.OO_ExclaimEqual;
          CanAssign = Op$1.getArg$Const(0).IgnoreParenImpCasts$Const().isLValue();
        } else {
          // Not a typo-prone comparison.
          return false;
        }
      }
    }
    
    // Suppress warnings when the operator, suspicious as it may be, comes from
    // a macro expansion.
    if (S.SourceMgr.isMacroBodyExpansion(/*NO_COPY*/Loc)) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_unused_comparison)), 
                (/*uint*/int)(IsRelational ? 1 : 0)), (/*uint*/int)(IsNotEqual ? 1 : 0)), E.getSourceRange()));
    
    // If the LHS is a plausible entity to assign to, provide a fixit hint to
    // correct common typos.
    if (!IsRelational && CanAssign) {
      if (IsNotEqual) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_inequality_comparison_to_or_assign)), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(/*KEEP_STR*/$PIPE_EQ))));
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_equality_comparison_to_assign)), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(/*KEEP_STR*/$EQ))));
      }
    }
    
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// CmpCaseVals - Comparison predicate for sorting case values.
///
//<editor-fold defaultstate="collapsed" desc="CmpCaseVals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 569,
 FQN="CmpCaseVals", NM="_ZL11CmpCaseValsRKSt4pairIN4llvm6APSIntEPN5clang8CaseStmtEES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL11CmpCaseValsRKSt4pairIN4llvm6APSIntEPN5clang8CaseStmtEES7_")
//</editor-fold>
public static boolean CmpCaseVals(final /*const*/ std.pair<APSInt, CaseStmt /*P*/ > /*&*/ lhs, 
           final /*const*/ std.pair<APSInt, CaseStmt /*P*/ > /*&*/ rhs) {
  if (lhs.first.$less(rhs.first)) {
    return true;
  }
  if (lhs.first.$eq(rhs.first)
     && $less_uint(lhs.second.getCaseLoc().getRawEncoding()
    , rhs.second.getCaseLoc().getRawEncoding())) {
    return true;
  }
  return false;
}


/// CmpEnumVals - Comparison predicate for sorting enumeration values.
///
//<editor-fold defaultstate="collapsed" desc="CmpEnumVals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 583,
 FQN="CmpEnumVals", NM="_ZL11CmpEnumValsRKSt4pairIN4llvm6APSIntEPN5clang16EnumConstantDeclEES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL11CmpEnumValsRKSt4pairIN4llvm6APSIntEPN5clang16EnumConstantDeclEES7_")
//</editor-fold>
public static boolean CmpEnumVals(final /*const*/ std.pair<APSInt, EnumConstantDecl /*P*/ > /*&*/ lhs, 
           final /*const*/ std.pair<APSInt, EnumConstantDecl /*P*/ > /*&*/ rhs) {
  return lhs.first.$less(rhs.first);
}


/// EqEnumVals - Comparison preficate for uniqing enumeration values.
///
//<editor-fold defaultstate="collapsed" desc="EqEnumVals">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 591,
 FQN="EqEnumVals", NM="_ZL10EqEnumValsRKSt4pairIN4llvm6APSIntEPN5clang16EnumConstantDeclEES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL10EqEnumValsRKSt4pairIN4llvm6APSIntEPN5clang16EnumConstantDeclEES7_")
//</editor-fold>
public static boolean EqEnumVals(final /*const*/ std.pair<APSInt, EnumConstantDecl /*P*/ > /*&*/ lhs, 
          final /*const*/ std.pair<APSInt, EnumConstantDecl /*P*/ > /*&*/ rhs) {
  return lhs.first.$eq(rhs.first);
}


/// GetTypeBeforeIntegralPromotion - Returns the pre-promotion type of
/// potentially integral-promoted expression @p expr.
//<editor-fold defaultstate="collapsed" desc="GetTypeBeforeIntegralPromotion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 599,
 FQN="GetTypeBeforeIntegralPromotion", NM="_ZL30GetTypeBeforeIntegralPromotionRPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL30GetTypeBeforeIntegralPromotionRPN5clang4ExprE")
//</editor-fold>
public static QualType GetTypeBeforeIntegralPromotion(final type$ptr<Expr /*P*/ /*&*/> expr) {
  {
    ExprWithCleanups /*P*/ cleanups = dyn_cast_ExprWithCleanups(expr.$star());
    if ((cleanups != null)) {
      expr.$set(cleanups.getSubExpr());
    }
  }
  {
    ImplicitCastExpr /*P*/ impcast;
    while (((/*P*/ impcast = dyn_cast_ImplicitCastExpr(expr.$star())) != null)) {
      if (impcast.getCastKind() != CastKind.CK_IntegralCast) {
        break;
      }
      expr.$set(impcast.getSubExpr());
    }
  }
  return expr./*->*/$star().getType();
}

//<editor-fold defaultstate="collapsed" desc="AdjustAPSInt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 679,
 FQN="AdjustAPSInt", NM="_ZL12AdjustAPSIntRN4llvm6APSIntEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL12AdjustAPSIntRN4llvm6APSIntEjb")
//</editor-fold>
public static void AdjustAPSInt(final APSInt /*&*/ Val, /*uint*/int BitWidth, boolean IsSigned) {
  Val.$assignMove(Val.extOrTrunc(BitWidth));
  Val.setIsSigned(IsSigned);
}


/// Check the specified case value is in range for the given unpromoted switch
/// type.
//<editor-fold defaultstate="collapsed" desc="checkCaseValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 686,
 FQN="checkCaseValue", NM="_ZL14checkCaseValueRN5clang4SemaENS_14SourceLocationERKN4llvm6APSIntEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL14checkCaseValueRN5clang4SemaENS_14SourceLocationERKN4llvm6APSIntEjb")
//</editor-fold>
public static void checkCaseValue(final Sema /*&*/ S, SourceLocation Loc, final /*const*/ APSInt /*&*/ Val, 
              /*uint*/int UnpromotedWidth, boolean UnpromotedSign) {
  // If the case value was signed and negative and the switch expression is
  // unsigned, don't bother to warn: this is implementation-defined behavior.
  // FIXME: Introduce a second, default-ignored warning for this case?
  if ($less_uint(UnpromotedWidth, Val.getBitWidth())) {
    APSInt ConvVal/*J*/= new APSInt(Val);
    AdjustAPSInt(ConvVal, UnpromotedWidth, UnpromotedSign);
    AdjustAPSInt(ConvVal, Val.getBitWidth(), Val.isSigned());
    // FIXME: Use different diagnostics for overflow  in conversion to promoted
    // type versus "switch expression cannot have this value". Use proper
    // IntRange checking rather than just looking at the unpromoted type here.
    if (ConvVal.$noteq(Val)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_case_value_overflow)), Val.__toString(10)), 
            ConvVal.__toString(10)));
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// Returns true if we should emit a diagnostic about this case expression not
/// being a part of the enum used in the switch controlling expression.
//<editor-fold defaultstate="collapsed" desc="ShouldDiagnoseSwitchCaseNotInEnum">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 708,
 FQN="ShouldDiagnoseSwitchCaseNotInEnum", NM="_ZL33ShouldDiagnoseSwitchCaseNotInEnumRKN5clang4SemaEPKNS_8EnumDeclEPKNS_4ExprERPSt4pairIN4llvm6APSIntEPNS_16EnumConstantDeclEESG_RKSB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL33ShouldDiagnoseSwitchCaseNotInEnumRKN5clang4SemaEPKNS_8EnumDeclEPKNS_4ExprERPSt4pairIN4llvm6APSIntEPNS_16EnumConstantDeclEESG_RKSB_")
//</editor-fold>
public static boolean ShouldDiagnoseSwitchCaseNotInEnum(final /*const*/ Sema /*&*/ S, 
                                 /*const*/ EnumDecl /*P*/ ED, 
                                 /*const*/ Expr /*P*/ CaseExpr, 
                                 final type$ptr<std.pair<APSInt, EnumConstantDecl /*P*/ > /*&*/> EI, 
                                 final type$ptr<std.pair<APSInt, EnumConstantDecl /*P*/ > /*&*/> EIEnd, 
                                 final /*const*/ APSInt /*&*/ Val) {
  {
    /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CaseExpr.IgnoreParenImpCasts$Const());
    if ((DRE != null)) {
      {
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
        if ((VD != null)) {
          QualType VarType = VD.getType();
          QualType EnumType = S.Context.getTypeDeclType(ED);
          if (VD.hasGlobalStorage() && VarType.isConstQualified()
             && S.Context.hasSameUnqualifiedType(new QualType(EnumType), new QualType(VarType))) {
            return false;
          }
        }
      }
    }
  }
  if (ED.hasAttr(FlagEnumAttr.class)) {
    return !S.IsValueInFlagEnum(ED, Val, false);
  } else {
    while ($noteq_ptr(EI, EIEnd) && EI./*->*/$star().first.$less(Val)) {
      EI.$postInc();
    }
    if ($noteq_ptr(EI, EIEnd) && EI./*->*/$star().first.$eq(Val)) {
      return false;
    }
  }
  
  return true;
}

// end class DeclMatcher
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckForLoopConditionalStatement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1440,
 FQN="(anonymous namespace)::CheckForLoopConditionalStatement", NM="_ZN12_GLOBAL__N_132CheckForLoopConditionalStatementERN5clang4SemaEPNS0_4ExprES4_PNS0_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_132CheckForLoopConditionalStatementERN5clang4SemaEPNS0_4ExprES4_PNS0_4StmtE")
//</editor-fold>
public static void CheckForLoopConditionalStatement(final Sema /*&*/ S, Expr /*P*/ Second, 
                                Expr /*P*/ Third, Stmt /*P*/ Body) {
  PartialDiagnostic PDiag = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Condition is empty
    if (!(Second != null)) {
      return;
    }
    if (S.Diags.isIgnored(diag.warn_variables_not_in_loop_body, 
        Second.getLocStart())) {
      return;
    }
    
    PDiag = S.PDiag(diag.warn_variables_not_in_loop_body);
    SmallPtrSet<VarDecl /*P*/ > Decls/*J*/= new SmallPtrSet<VarDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    SmallVector<SourceRange> Ranges/*J*/= new SmallVector<SourceRange>(10, SourceRange.EMPTY);
    DeclExtractor DE/*J*/= new DeclExtractor(S, Decls, Ranges);
    DE.Visit(Second);
    
    // Don't analyze complex conditionals.
    if (!DE.isSimple()) {
      return;
    }
    
    // No decls found.
    if (Decls.size() == 0) {
      return;
    }
    
    // Don't warn on volatile, static, or global variables.
    for (SmallPtrSetIterator<VarDecl /*P*/ > I = Decls.begin(), 
        E = Decls.end();
         I.$noteq(E); I.$preInc())  {
      if ((I.$star()).getType().isVolatileQualified()
         || (I.$star()).hasGlobalStorage()) {
        return;
      }
    }
    if (new DeclMatcher(S, Decls, Second).FoundDeclInUse()
       || new DeclMatcher(S, Decls, Third).FoundDeclInUse()
       || new DeclMatcher(S, Decls, Body).FoundDeclInUse()) {
      return;
    }
    
    // Load decl names into diagnostic.
    if ($greater_uint(Decls.size(), 4)) {
      $out_PartialDiagnostic$C_int(PDiag, 0);
    } else {
      $out_PartialDiagnostic$C_uint(PDiag, Decls.size());
      for (SmallPtrSetIterator<VarDecl /*P*/ > I = Decls.begin(), 
          E = Decls.end();
           I.$noteq(E); I.$preInc())  {
        $out_PartialDiagnostic$C_DeclarationName(PDiag, (I.$star()).getDeclName());
      }
    }
    
    // Load SourceRanges into diagnostic if there is room.
    // Otherwise, load the SourceRange of the conditional expression.
    if ($lesseq_uint_int(Ranges.size(), PartialDiagnostic.MaxArguments)) {
      for (type$ptr<SourceRange> I = $tryClone(Ranges.begin()), 
          /*P*/ E = $tryClone(Ranges.end());
           $noteq_ptr(I, E); I.$preInc())  {
        $out_PartialDiagnostic$C_SourceRange(PDiag, /*NO_COPY*/I.$star());
      }
    } else {
      $out_PartialDiagnostic$C_SourceRange(PDiag, Second.getSourceRange());
    }
    
    $c$.clean($c$.track(S.Diag(Ranges.begin().$star().getBegin(), PDiag)));
  } finally {
    if (PDiag != null) { PDiag.$destroy(); }
    $c$.$destroy();
  }
}


// If Statement is an incemement or decrement, return true and sets the
// variables Increment and DRE.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ProcessIterationStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1499,
 FQN="(anonymous namespace)::ProcessIterationStmt", NM="_ZN12_GLOBAL__N_120ProcessIterationStmtERN5clang4SemaEPNS0_4StmtERbRPNS0_11DeclRefExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_120ProcessIterationStmtERN5clang4SemaEPNS0_4StmtERbRPNS0_11DeclRefExprE")
//</editor-fold>
public static boolean ProcessIterationStmt(final Sema /*&*/ S, Stmt /*P*/ Statement, final bool$ref/*bool &*/ Increment, 
                    final type$ptr<DeclRefExpr /*P*/ /*&*/> DRE) {
  {
    ExprWithCleanups /*P*/ Cleanups = dyn_cast_ExprWithCleanups(Statement);
    if ((Cleanups != null)) {
      if (!Cleanups.cleanupsHaveSideEffects()) {
        Statement = Cleanups.getSubExpr();
      }
    }
  }
  {
    
    UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(Statement);
    if ((UO != null)) {
      switch (UO.getOpcode()) {
       default:
        return false;
       case UO_PostInc:
       case UO_PreInc:
        Increment.$set(true);
        break;
       case UO_PostDec:
       case UO_PreDec:
        Increment.$set(false);
        break;
      }
      DRE.$set(dyn_cast_DeclRefExpr(UO.getSubExpr()));
      return (DRE != null);
    }
  }
  {
    
    CXXOperatorCallExpr /*P*/ Call = dyn_cast_CXXOperatorCallExpr(Statement);
    if ((Call != null)) {
      FunctionDecl /*P*/ FD = Call.getDirectCallee();
      if (!(FD != null) || !FD.isOverloadedOperator()) {
        return false;
      }
      switch (FD.getOverloadedOperator()) {
       default:
        return false;
       case OO_PlusPlus:
        Increment.$set(true);
        break;
       case OO_MinusMinus:
        Increment.$set(false);
        break;
      }
      DRE.$set(dyn_cast_DeclRefExpr(Call.getArg(0)));
      return (DRE != null);
    }
  }
  
  return false;
}

// end class BreakContinueFinder

// Emit a warning when a loop increment/decrement appears twice per loop
// iteration.  The conditions which trigger this warning are:
// 1) The last statement in the loop body and the third expression in the
//    for loop are both increment or both decrement of the same variable
// 2) No continue statements in the loop body.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckForRedundantIteration">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1573,
 FQN="(anonymous namespace)::CheckForRedundantIteration", NM="_ZN12_GLOBAL__N_126CheckForRedundantIterationERN5clang4SemaEPNS0_4ExprEPNS0_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_126CheckForRedundantIterationERN5clang4SemaEPNS0_4ExprEPNS0_4StmtE")
//</editor-fold>
public static void CheckForRedundantIteration(final Sema /*&*/ S, Expr /*P*/ Third, Stmt /*P*/ Body) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Return when there is nothing to check.
    if (!(Body != null) || !(Third != null)) {
      return;
    }
    if (S.Diags.isIgnored(diag.warn_redundant_loop_iteration, 
        Third.getLocStart())) {
      return;
    }
    
    // Get the last statement from the loop body.
    CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Body);
    if (!(CS != null) || CS.body_empty()) {
      return;
    }
    Stmt /*P*/ LastStmt = CS.body_back();
    if (!(LastStmt != null)) {
      return;
    }
    
    bool$ref LoopIncrement = create_bool$ref(), LastIncrement = create_bool$ref();
    type$ptr<DeclRefExpr /*P*/ > LoopDRE = create_type$null$ptr(), LastDRE = create_type$null$ptr();
    if (!ProcessIterationStmt(S, Third, LoopIncrement, LoopDRE)) {
      return;
    }
    if (!ProcessIterationStmt(S, LastStmt, LastIncrement, LastDRE)) {
      return;
    }
    
    // Check that the two statements are both increments or both decrements
    // on the same variable.
    if (LoopIncrement.$deref() != LastIncrement.$deref()
       || LoopDRE.$star().getDecl() != LastDRE.$star().getDecl()) {
      return;
    }
    if (new BreakContinueFinder(S, Body).ContinueFound()) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(LastDRE.$star().getLocation(), diag.warn_redundant_loop_iteration)), 
            LastDRE.$star().getDecl()), LastIncrement));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(LoopDRE.$star().getLocation(), diag.note_loop_iteration_here)), 
        LoopIncrement));
  } finally {
    $c$.$destroy();
  }
}


/// Finish building a variable declaration for a for-range statement.
/// \return true if an error occurs.
//<editor-fold defaultstate="collapsed" desc="FinishForRangeVarDecl">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1852,
 FQN="FinishForRangeVarDecl", NM="_ZL21FinishForRangeVarDeclRN5clang4SemaEPNS_7VarDeclEPNS_4ExprENS_14SourceLocationEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL21FinishForRangeVarDeclRN5clang4SemaEPNS_7VarDeclEPNS_4ExprENS_14SourceLocationEi")
//</editor-fold>
public static boolean FinishForRangeVarDecl(final Sema /*&*/ SemaRef, VarDecl /*P*/ Decl, type$ptr<Expr /*P*/> Init, 
                     SourceLocation Loc, int DiagID) {
  if (Decl.getType().$arrow().isUndeducedType()) {
    ActionResultTTrue<Expr /*P*/ > Res = SemaRef.CorrectDelayedTyposInExpr(Init.$star());
    if (!Res.isUsable()) {
      Decl.setInvalidDecl();
      return true;
    }
    Init.$set(Res.get());
  }
  
  // Deduce the type for the iterator variable now rather than leaving it to
  // AddInitializerToDecl, so we can produce a more suitable diagnostic.
  QualType InitType/*J*/= new QualType();
  if ((!isa_InitListExpr(Init.$star()) && Init.$star().getType().$arrow().isVoidType())
     || SemaRef.DeduceAutoType(Decl.getTypeSourceInfo(), Init.star$ref(), InitType)
     == Sema.DeduceAutoResult.DAR_Failed) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), DiagID)), Init.$star().getType()));
    } finally {
      $c$.$destroy();
    }
  }
  if (InitType.isNull()) {
    Decl.setInvalidDecl();
    return true;
  }
  Decl.setType(new QualType(InitType));
  
  // In ARC, infer lifetime.
  // FIXME: ARC may want to turn this into 'const __unsafe_unretained' if
  // we're doing the equivalent of fast iteration.
  if (SemaRef.getLangOpts().ObjCAutoRefCount
     && SemaRef.inferObjCARCLifetime(Decl)) {
    Decl.setInvalidDecl();
  }
  
  SemaRef.AddInitializerToDecl(Decl, Init.$star(), /*DirectInit=*/ false, 
      /*TypeMayContainAuto=*/ false);
  SemaRef.FinalizeDeclaration(Decl);
  SemaRef.CurContext.addHiddenDecl(Decl);
  return false;
}


/// Produce a note indicating which begin/end function was implicitly called
/// by a C++11 for-range statement. This is often not obvious from the code,
/// nor from the diagnostics produced when analysing the implicit expressions
/// required in a for-range statement.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::NoteForRangeBeginEndFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1902,
 FQN="(anonymous namespace)::NoteForRangeBeginEndFunction", NM="_ZN12_GLOBAL__N_128NoteForRangeBeginEndFunctionERN5clang4SemaEPNS0_4ExprENS_16BeginEndFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_128NoteForRangeBeginEndFunctionERN5clang4SemaEPNS0_4ExprENS_16BeginEndFunctionE")
//</editor-fold>
public static void NoteForRangeBeginEndFunction(final Sema /*&*/ SemaRef, Expr /*P*/ E, 
                            BeginEndFunction BEF) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
    if (!(CE != null)) {
      return;
    }
    FunctionDecl /*P*/ D = dyn_cast_FunctionDecl(CE.getCalleeDecl());
    if (!(D != null)) {
      return;
    }
    SourceLocation Loc = D.getLocation();
    
    std.string Description/*J*/= new std.string();
    boolean IsTemplate = false;
    {
      FunctionTemplateDecl /*P*/ FunTmpl = D.getPrimaryTemplate();
      if ((FunTmpl != null)) {
        Description.$assignMove(SemaRef.getTemplateArgumentBindingsText(FunTmpl.getTemplateParameters(), $Deref(D.getTemplateSpecializationArgs())));
        IsTemplate = true;
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), diag.note_for_range_begin_end)), 
                    BEF), IsTemplate), Description), E.getType()));
  } finally {
    $c$.$destroy();
  }
}


/// Build a variable declaration for a for-range statement.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::BuildForRangeVarDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1925,
 FQN="(anonymous namespace)::BuildForRangeVarDecl", NM="_ZN12_GLOBAL__N_120BuildForRangeVarDeclERN5clang4SemaENS0_14SourceLocationENS0_8QualTypeEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN12_GLOBAL__N_120BuildForRangeVarDeclERN5clang4SemaENS0_14SourceLocationENS0_8QualTypeEPKc")
//</editor-fold>
public static VarDecl /*P*/ BuildForRangeVarDecl(final Sema /*&*/ SemaRef, SourceLocation Loc, 
                    QualType Type, /*const*/char$ptr/*char P*/ Name) {
  DeclContext /*P*/ DC = SemaRef.CurContext;
  IdentifierInfo /*P*/ II = $AddrOf(SemaRef.PP.getIdentifierTable().get(new StringRef(Name)));
  TypeSourceInfo /*P*/ TInfo = SemaRef.Context.getTrivialTypeSourceInfo(new QualType(Type), new SourceLocation(Loc));
  VarDecl /*P*/ Decl = VarDecl.Create(SemaRef.Context, DC, new SourceLocation(Loc), new SourceLocation(Loc), II, new QualType(Type), 
      TInfo, StorageClass.SC_None);
  Decl.setImplicit();
  return Decl;
}

//<editor-fold defaultstate="collapsed" desc="ObjCEnumerationCollection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1938,
 FQN="ObjCEnumerationCollection", NM="_ZL25ObjCEnumerationCollectionPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL25ObjCEnumerationCollectionPN5clang4ExprE")
//</editor-fold>
public static boolean ObjCEnumerationCollection(Expr /*P*/ Collection) {
  return !Collection.isTypeDependent()
     && Collection.getType().$arrow().getAs(ObjCObjectPointerType.class) != null;
}


/// \brief Create the initialization, compare, and increment steps for
/// the range-based for loop expression.
/// This function does not handle array-based for loops,
/// which are created in Sema::BuildCXXForRangeStmt.
///
/// \returns a ForRangeStatus indicating success or what kind of error occurred.
/// BeginExpr and EndExpr are set and FRS_Success is returned on success;
/// CandidateSet and BEF are set and some non-success value is returned on
/// failure.
//<editor-fold defaultstate="collapsed" desc="BuildNonArrayForRange">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2030,
 FQN="BuildNonArrayForRange", NM="_ZL21BuildNonArrayForRangeRN5clang4SemaEPNS_4ExprES3_NS_8QualTypeEPNS_7VarDeclES6_NS_14SourceLocationEPNS_20OverloadCandidateSetEPNS_12ActionResultIS3_Lb1EEESC_PN12_GLOBAL__N_116BeginEndFunctionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL21BuildNonArrayForRangeRN5clang4SemaEPNS_4ExprES3_NS_8QualTypeEPNS_7VarDeclES6_NS_14SourceLocationEPNS_20OverloadCandidateSetEPNS_12ActionResultIS3_Lb1EEESC_PN12_GLOBAL__N_116BeginEndFunctionE")
//</editor-fold>
public static Sema.ForRangeStatus BuildNonArrayForRange(final Sema /*&*/ SemaRef, 
                     Expr /*P*/ BeginRange, Expr /*P*/ EndRange, 
                     QualType RangeType, 
                     VarDecl /*P*/ BeginVar, 
                     VarDecl /*P*/ EndVar, 
                     SourceLocation ColonLoc, 
                     OverloadCandidateSet /*P*/ CandidateSet, 
                     ActionResultTTrue<Expr /*P*/ > /*P*/ BeginExpr, 
                     ActionResultTTrue<Expr /*P*/ > /*P*/ EndExpr, 
                     type$ptr<BeginEndFunction /*P*/> BEF) {
  LookupResult BeginMemberLookup = null;
  LookupResult EndMemberLookup = null;
  try {
    DeclarationNameInfo BeginNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName($AddrOf(SemaRef.PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"begin")))), new SourceLocation(ColonLoc));
    DeclarationNameInfo EndNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName($AddrOf(SemaRef.PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"end")))), 
        new SourceLocation(ColonLoc));
    
    BeginMemberLookup/*J*/= new LookupResult(SemaRef, BeginNameInfo, 
        Sema.LookupNameKind.LookupMemberName);
    EndMemberLookup/*J*/= new LookupResult(SemaRef, EndNameInfo, Sema.LookupNameKind.LookupMemberName);
    {
      
      CXXRecordDecl /*P*/ D = RangeType.$arrow().getAsCXXRecordDecl();
      if ((D != null)) {
        // - if _RangeT is a class type, the unqualified-ids begin and end are
        //   looked up in the scope of class _RangeT as if by class member access
        //   lookup (3.4.5), and if either (or both) finds at least one
        //   declaration, begin-expr and end-expr are __range.begin() and
        //   __range.end(), respectively;
        SemaRef.LookupQualifiedName(BeginMemberLookup, D);
        SemaRef.LookupQualifiedName(EndMemberLookup, D);
        if (BeginMemberLookup.empty() != EndMemberLookup.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            SourceLocation RangeLoc = BeginVar.getLocation();
            BEF.$set(BeginMemberLookup.empty() ? BeginEndFunction.BEF_end : BeginEndFunction.BEF_begin);
            
            $c$.clean($out_SemaDiagnosticBuilder_BegEndFunc($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(RangeLoc), diag.err_for_range_member_begin_end_mismatch)), 
                        RangeLoc), BeginRange.getType()), $Deref(BEF)));
            return Sema.ForRangeStatus.FRS_DiagnosticIssued;
          } finally {
            $c$.$destroy();
          }
        }
      } else {
        // - otherwise, begin-expr and end-expr are begin(__range) and
        //   end(__range), respectively, where begin and end are looked up with
        //   argument-dependent lookup (3.4.2). For the purposes of this name
        //   lookup, namespace std is an associated namespace.
      }
    }
    
    BEF.$set(BeginEndFunction.BEF_begin);
    Sema.ForRangeStatus RangeStatus = SemaRef.BuildForRangeBeginEndCall(new SourceLocation(ColonLoc), new SourceLocation(ColonLoc), BeginNameInfo, 
        BeginMemberLookup, CandidateSet, 
        BeginRange, BeginExpr);
    if (RangeStatus != Sema.ForRangeStatus.FRS_Success) {
      if (RangeStatus == Sema.ForRangeStatus.FRS_DiagnosticIssued) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(BeginRange.getLocStart(), diag.note_in_for_range)), 
                      ColonLoc), BeginEndFunction.BEF_begin), BeginRange.getType()));
        } finally {
          $c$.$destroy();
        }
      }
      return RangeStatus;
    }
    if (FinishForRangeVarDecl(SemaRef, BeginVar, create_type$ptr(BeginExpr.get()), new SourceLocation(ColonLoc), 
        diag.err_for_range_iter_deduction_failure)) {
      NoteForRangeBeginEndFunction(SemaRef, BeginExpr.get(), $Deref(BEF.$star()));
      return Sema.ForRangeStatus.FRS_DiagnosticIssued;
    }
    
    BEF.$set(BeginEndFunction.BEF_end);
    RangeStatus
       = SemaRef.BuildForRangeBeginEndCall(new SourceLocation(ColonLoc), new SourceLocation(ColonLoc), EndNameInfo, 
        EndMemberLookup, CandidateSet, 
        EndRange, EndExpr);
    if (RangeStatus != Sema.ForRangeStatus.FRS_Success) {
      if (RangeStatus == Sema.ForRangeStatus.FRS_DiagnosticIssued) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(EndRange.getLocStart(), diag.note_in_for_range)), 
                      ColonLoc), BeginEndFunction.BEF_end), EndRange.getType()));
        } finally {
          $c$.$destroy();
        }
      }
      return RangeStatus;
    }
    if (FinishForRangeVarDecl(SemaRef, EndVar, create_type$ptr(EndExpr.get()), new SourceLocation(ColonLoc), 
        diag.err_for_range_iter_deduction_failure)) {
      NoteForRangeBeginEndFunction(SemaRef, EndExpr.get(), $Deref(BEF.$star()));
      return Sema.ForRangeStatus.FRS_DiagnosticIssued;
    }
    return Sema.ForRangeStatus.FRS_Success;
  } finally {
    if (EndMemberLookup != null) { EndMemberLookup.$destroy(); }
    if (BeginMemberLookup != null) { BeginMemberLookup.$destroy(); }
  }
}


/// Speculatively attempt to dereference an invalid range expression.
/// If the attempt fails, this function will return a valid, null StmtResult
/// and emit no diagnostics.
//<editor-fold defaultstate="collapsed" desc="RebuildForRangeWithDereference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2114,
 FQN="RebuildForRangeWithDereference", NM="_ZL30RebuildForRangeWithDereferenceRN5clang4SemaEPNS_5ScopeENS_14SourceLocationES4_PNS_4StmtES4_PNS_4ExprES4_S4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL30RebuildForRangeWithDereferenceRN5clang4SemaEPNS_5ScopeENS_14SourceLocationES4_PNS_4StmtES4_PNS_4ExprES4_S4_")
//</editor-fold>
public static ActionResultTTrue<Stmt /*P*/ > RebuildForRangeWithDereference(final Sema /*&*/ SemaRef, Scope /*P*/ S, 
                              SourceLocation ForLoc, 
                              SourceLocation CoawaitLoc, 
                              Stmt /*P*/ LoopVarDecl, 
                              SourceLocation ColonLoc, 
                              Expr /*P*/ Range, 
                              SourceLocation RangeLoc, 
                              SourceLocation RParenLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Determine whether we can rebuild the for-range statement with a
    // dereferenced range expression.
    ActionResultTTrue<Expr /*P*/ > AdjustedRange/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    {
      Sema.SFINAETrap Trap = null;
      try {
        Trap/*J*/= new Sema.SFINAETrap(SemaRef);
        
        AdjustedRange.$assignMove(SemaRef.BuildUnaryOp(S, new SourceLocation(RangeLoc), UnaryOperatorKind.UO_Deref, Range));
        if (AdjustedRange.isInvalid()) {
          return new ActionResultTTrue<Stmt /*P*/ >();
        }
        
        ActionResultTTrue<Stmt /*P*/ > SR = SemaRef.ActOnCXXForRangeStmt(S, new SourceLocation(ForLoc), new SourceLocation(CoawaitLoc), LoopVarDecl, new SourceLocation(ColonLoc), AdjustedRange.get(), 
            new SourceLocation(RParenLoc), Sema.BuildForRangeKind.BFRK_Check);
        if (SR.isInvalid()) {
          return new ActionResultTTrue<Stmt /*P*/ >();
        }
      } finally {
        if (Trap != null) { Trap.$destroy(); }
      }
    }
    
    // The attempt to dereference worked well enough that it could produce a valid
    // loop. Produce a fixit, and rebuild the loop with diagnostics enabled, in
    // case there are any other (non-fatal) problems with it.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(RangeLoc), diag.err_for_range_dereference)), 
            Range.getType()), FixItHint.CreateInsertion(/*NO_COPY*/RangeLoc, new StringRef(/*KEEP_STR*/$STAR))));
    return SemaRef.ActOnCXXForRangeStmt(S, new SourceLocation(ForLoc), new SourceLocation(CoawaitLoc), LoopVarDecl, 
        new SourceLocation(ColonLoc), AdjustedRange.get(), new SourceLocation(RParenLoc), 
        Sema.BuildForRangeKind.BFRK_Rebuild);
  } finally {
    $c$.$destroy();
  }
}


// Warn when the loop variable is a const reference that creates a copy.
// Suggest using the non-reference type for copies.  If a copy can be prevented
// suggest the const reference type that would do so.
// For instance, given "for (const &Foo : Range)", suggest
// "for (const Foo : Range)" to denote a copy is made for the loop.  If
// possible, also suggest "for (const &Bar : Range)" if this type prevents
// the copy altogether.
//<editor-fold defaultstate="collapsed" desc="DiagnoseForRangeReferenceVariableCopies">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2447,
 FQN="DiagnoseForRangeReferenceVariableCopies", NM="_ZL39DiagnoseForRangeReferenceVariableCopiesRN5clang4SemaEPKNS_7VarDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL39DiagnoseForRangeReferenceVariableCopiesRN5clang4SemaEPKNS_7VarDeclENS_8QualTypeE")
//</editor-fold>
public static void DiagnoseForRangeReferenceVariableCopies(final Sema /*&*/ SemaRef, 
                                       /*const*/ VarDecl /*P*/ VD, 
                                       QualType RangeInitType) {
  /*const*/ Expr /*P*/ InitExpr = VD.getInit$Const();
  if (!(InitExpr != null)) {
    return;
  }
  
  QualType VariableType = VD.getType();
  {
    
    /*const*/ ExprWithCleanups /*P*/ Cleanups = dyn_cast_ExprWithCleanups(InitExpr);
    if ((Cleanups != null)) {
      if (!Cleanups.cleanupsHaveSideEffects()) {
        InitExpr = Cleanups.getSubExpr$Const();
      }
    }
  }
  
  /*const*/ MaterializeTemporaryExpr /*P*/ MTE = dyn_cast_MaterializeTemporaryExpr(InitExpr);
  
  // No copy made.
  if (!(MTE != null)) {
    return;
  }
  
  /*const*/ Expr /*P*/ E = MTE.GetTemporaryExpr().IgnoreImpCasts();
  
  // Searching for either UnaryOperator for dereference of a pointer or
  // CXXOperatorCallExpr for handling iterators.
  while (!isa_CXXOperatorCallExpr(E) && !isa_UnaryOperator(E)) {
    {
      /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(E);
      if ((CCE != null)) {
        E = CCE.getArg$Const(0);
      } else {
        /*const*/ CXXMemberCallExpr /*P*/ Call = dyn_cast_CXXMemberCallExpr(E);
        if ((Call != null)) {
          /*const*/ MemberExpr /*P*/ ME = cast_MemberExpr(Call.getCallee$Const());
          E = ME.getBase();
        } else {
          /*const*/ MaterializeTemporaryExpr /*P*/ MTE$1 = cast_MaterializeTemporaryExpr(E);
          E = MTE$1.GetTemporaryExpr();
        }
      }
    }
    E = E.IgnoreImpCasts$Const();
  }
  
  boolean ReturnsReference = false;
  if (isa_UnaryOperator(E)) {
    ReturnsReference = true;
  } else {
    /*const*/ CXXOperatorCallExpr /*P*/ Call = cast_CXXOperatorCallExpr(E);
    /*const*/ FunctionDecl /*P*/ FD = Call.getDirectCallee$Const();
    QualType ReturnType = FD.getReturnType();
    ReturnsReference = ReturnType.$arrow().isReferenceType();
  }
  if (ReturnsReference) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Loop variable creates a temporary.  Suggest either to go with
      // non-reference loop variable to indiciate a copy is made, or
      // the correct time to bind a const reference.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocation(), diag.warn_for_range_const_reference_copy)), 
                  VD), VariableType), E.getType()));
      QualType NonReferenceType = VariableType.getNonReferenceType();
      NonReferenceType.removeLocalConst();
      QualType NewReferenceType = SemaRef.Context.getLValueReferenceType(E.getType().withConst());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocStart(), diag.note_use_type_or_non_reference)), 
                  NonReferenceType), NewReferenceType), VD.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The range always returns a copy, so a temporary is always created.
      // Suggest removing the reference from the loop variable.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocation(), diag.warn_for_range_variable_always_copy)), 
              VD), RangeInitType));
      QualType NonReferenceType = VariableType.getNonReferenceType();
      NonReferenceType.removeLocalConst();
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocStart(), diag.note_use_non_reference_type)), 
              NonReferenceType), VD.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
}


// Warns when the loop variable can be changed to a reference type to
// prevent a copy.  For instance, if given "for (const Foo x : Range)" suggest
// "for (const Foo &x : Range)" if this form does not make a copy.
//<editor-fold defaultstate="collapsed" desc="DiagnoseForRangeConstVariableCopies">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2521,
 FQN="DiagnoseForRangeConstVariableCopies", NM="_ZL35DiagnoseForRangeConstVariableCopiesRN5clang4SemaEPKNS_7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL35DiagnoseForRangeConstVariableCopiesRN5clang4SemaEPKNS_7VarDeclE")
//</editor-fold>
public static void DiagnoseForRangeConstVariableCopies(final Sema /*&*/ SemaRef, 
                                   /*const*/ VarDecl /*P*/ VD) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ Expr /*P*/ InitExpr = VD.getInit$Const();
    if (!(InitExpr != null)) {
      return;
    }
    
    QualType VariableType = VD.getType();
    {
      
      /*const*/ CXXConstructExpr /*P*/ CE = dyn_cast_CXXConstructExpr(InitExpr);
      if ((CE != null)) {
        if (!CE.getConstructor().isCopyConstructor()) {
          return;
        }
      } else {
        /*const*/ CastExpr /*P*/ CE$1 = dyn_cast_CastExpr(InitExpr);
        if ((CE$1 != null)) {
          if (CE$1.getCastKind() != CastKind.CK_LValueToRValue) {
            return;
          }
        } else {
          return;
        }
      }
    }
    
    // TODO: Determine a maximum size that a POD type can be before a diagnostic
    // should be emitted.  Also, only ignore POD types with trivial copy
    // constructors.
    if (VariableType.isPODType(SemaRef.Context)) {
      return;
    }
    
    // Suggest changing from a const variable to a const reference variable
    // if doing so will prevent a copy.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocation(), diag.warn_for_range_copy)), 
                VD), VariableType), InitExpr.getType()));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(VD.getLocStart(), diag.note_use_reference_type)), 
            SemaRef.Context.getLValueReferenceType(new QualType(VariableType))), 
        VD.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// DiagnoseForRangeVariableCopies - Diagnose three cases and fixes for them.
/// 1) for (const foo &x : foos) where foos only returns a copy.  Suggest
///    using "const foo x" to show that a copy is made
/// 2) for (const bar &x : foos) where bar is a temporary intialized by bar.
///    Suggest either "const bar x" to keep the copying or "const foo& x" to
///    prevent the copy.
/// 3) for (const foo x : foos) where x is constructed from a reference foo.
///    Suggest "const foo &x" to prevent the copy.
//<editor-fold defaultstate="collapsed" desc="DiagnoseForRangeVariableCopies">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2562,
 FQN="DiagnoseForRangeVariableCopies", NM="_ZL30DiagnoseForRangeVariableCopiesRN5clang4SemaEPKNS_15CXXForRangeStmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL30DiagnoseForRangeVariableCopiesRN5clang4SemaEPKNS_15CXXForRangeStmtE")
//</editor-fold>
public static void DiagnoseForRangeVariableCopies(final Sema /*&*/ SemaRef, 
                              /*const*/ CXXForRangeStmt /*P*/ ForStmt) {
  if (SemaRef.Diags.isIgnored(diag.warn_for_range_const_reference_copy, 
      ForStmt.getLocStart())
     && SemaRef.Diags.isIgnored(diag.warn_for_range_variable_always_copy, 
      ForStmt.getLocStart())
     && SemaRef.Diags.isIgnored(diag.warn_for_range_copy, 
      ForStmt.getLocStart())) {
    return;
  }
  
  /*const*/ VarDecl /*P*/ VD = ForStmt.getLoopVariable$Const();
  if (!(VD != null)) {
    return;
  }
  
  QualType VariableType = VD.getType();
  if (VariableType.$arrow().isIncompleteType()) {
    return;
  }
  
  /*const*/ Expr /*P*/ InitExpr = VD.getInit$Const();
  if (!(InitExpr != null)) {
    return;
  }
  if (VariableType.$arrow().isReferenceType()) {
    DiagnoseForRangeReferenceVariableCopies(SemaRef, VD, 
        ForStmt.getRangeInit$Const().getType());
  } else if (VariableType.isConstQualified()) {
    DiagnoseForRangeConstVariableCopies(SemaRef, VD);
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckJumpOutOfSEHFinally">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2651,
 FQN="CheckJumpOutOfSEHFinally", NM="_ZL24CheckJumpOutOfSEHFinallyRN5clang4SemaENS_14SourceLocationERKNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL24CheckJumpOutOfSEHFinallyRN5clang4SemaENS_14SourceLocationERKNS_5ScopeE")
//</editor-fold>
public static void CheckJumpOutOfSEHFinally(final Sema /*&*/ S, SourceLocation Loc, 
                        final /*const*/ Scope /*&*/ DestScope) {
  if (!S.CurrentSEHFinally.empty()
     && DestScope.Contains($Deref(S.CurrentSEHFinally.back()))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.warn_jump_out_of_seh_finally)));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Determine whether the declared return type of the specified function
/// contains 'auto'.
//<editor-fold defaultstate="collapsed" desc="hasDeducedReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2850,
 FQN="hasDeducedReturnType", NM="_ZL20hasDeducedReturnTypePN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL20hasDeducedReturnTypePN5clang12FunctionDeclE")
//</editor-fold>
public static boolean hasDeducedReturnType(FunctionDecl /*P*/ FD) {
  /*const*/ FunctionProtoType /*P*/ FPT = FD.getTypeSourceInfo().getType().$arrow().castAs(FunctionProtoType.class);
  return FPT.getReturnType().$arrow().isUndeducedType();
}

//<editor-fold defaultstate="collapsed" desc="buildCapturedStmtCaptureList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3853,
 FQN="buildCapturedStmtCaptureList", NM="_ZL28buildCapturedStmtCaptureListRN4llvm15SmallVectorImplIN5clang12CapturedStmt7CaptureEEERNS0_IPNS1_4ExprEEENS_8ArrayRefINS1_4sema18CapturingScopeInfo7CaptureEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZL28buildCapturedStmtCaptureListRN4llvm15SmallVectorImplIN5clang12CapturedStmt7CaptureEEERNS0_IPNS1_4ExprEEENS_8ArrayRefINS1_4sema18CapturingScopeInfo7CaptureEEE")
//</editor-fold>
public static void buildCapturedStmtCaptureList(final SmallVectorImpl<CapturedStmt.Capture> /*&*/ Captures, 
                            final SmallVectorImpl<Expr /*P*/ > /*&*/ CaptureInits, 
                            ArrayRef<CapturingScopeInfo.Capture> Candidates) {
  
  /*typedef ArrayRef<CapturingScopeInfo::Capture>::const_iterator CaptureIter*/
//  final class CaptureIter extends type$ptr<CapturingScopeInfo.Capture>{ };
  for (type$ptr<CapturingScopeInfo.Capture> Cap = $tryClone(Candidates.begin()); $noteq_ptr(Cap, Candidates.end()); Cap.$preInc()) {
    if (Cap./*->*/$star().isThisCapture()) {
      Captures.push_back(new CapturedStmt.Capture(Cap./*->*/$star().getLocation(), 
              CapturedStmt.VariableCaptureKind.VCK_This));
      CaptureInits.push_back(Cap./*->*/$star().getInitExpr());
      continue;
    } else if (Cap./*->*/$star().isVLATypeCapture()) {
      Captures.push_back(new CapturedStmt.Capture(Cap./*->*/$star().getLocation(), CapturedStmt.VariableCaptureKind.VCK_VLAType));
      CaptureInits.push_back((Expr /*P*/ /*const*/)null);
      continue;
    }
    
    Captures.push_back(new CapturedStmt.Capture(Cap./*->*/$star().getLocation(), 
            Cap./*->*/$star().isReferenceCapture() ? CapturedStmt.VariableCaptureKind.VCK_ByRef : CapturedStmt.VariableCaptureKind.VCK_ByCopy, 
            Cap./*->*/$star().getVariable()));
    CaptureInits.push_back(Cap./*->*/$star().getInitExpr());
  }
}

} // END OF class SemaStmtStatics
