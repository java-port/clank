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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.IdenticalExprCheckerStatics.*;
import static org.clang.ast.java.AstStatementsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 36,
 FQN="(anonymous namespace)::FindIdenticalExprVisitor", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitorE")
//</editor-fold>
public class FindIdenticalExprVisitor implements /*public*/ RecursiveASTVisitor<FindIdenticalExprVisitor> {
  private final BugReporter /*&*/ BR;
  private /*const*/ CheckerBase /*P*/ Checker;
  private AnalysisDeclContext /*P*/ AC;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::FindIdenticalExprVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 42,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::FindIdenticalExprVisitor", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitorC1ERN5clang4ento11BugReporterEPKNS2_11CheckerBaseEPNS1_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitorC1ERN5clang4ento11BugReporterEPKNS2_11CheckerBaseEPNS1_19AnalysisDeclContextE")
  //</editor-fold>
  public /*explicit*/ FindIdenticalExprVisitor(final BugReporter /*&*/ B, 
      /*const*/ CheckerBase /*P*/ Checker, 
      AnalysisDeclContext /*P*/ A) {
    // : RecursiveASTVisitor<FindIdenticalExprVisitor>(), BR(B), Checker(Checker), AC(A) 
    //START JInit
    $RecursiveASTVisitor();
    this./*&*/BR=/*&*/B;
    this.Checker = Checker;
    this.AC = A;
    //END JInit
  }

  // FindIdenticalExprVisitor only visits nodes
  // that are binary operators, if statements or
  // conditional operators.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 182,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitor19VisitBinaryOperatorEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitor19VisitBinaryOperatorEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinaryOperator(/*const*/ BinaryOperator /*P*/ B) {
    BinaryOperatorKind Op = B.getOpcode();
    if (BinaryOperator.isBitwiseOp(Op)) {
      checkBitwiseOrLogicalOp(B, true);
    }
    if (BinaryOperator.isLogicalOp(Op)) {
      checkBitwiseOrLogicalOp(B, false);
    }
    if (BinaryOperator.isComparisonOp(Op)) {
      checkComparisonOp(B);
    }
    
    // We want to visit ALL nodes (subexpressions of binary comparison
    // expressions too) that contains comparison operators.
    // True is always returned to traverse ALL nodes.
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::VisitIfStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 107,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::VisitIfStmt", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitor11VisitIfStmtEPKN5clang6IfStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitor11VisitIfStmtEPKN5clang6IfStmtE")
  //</editor-fold>
  public boolean VisitIfStmt(/*const*/ IfStmt /*P*/ I) {
    /*const*/ Stmt /*P*/ Stmt1 = I.getThen$Const();
    /*const*/ Stmt /*P*/ Stmt2 = I.getElse$Const();
    {
      
      // Check for identical inner condition:
      //
      // if (x<10) {
      //   if (x<10) {
      //   ..
      /*const*/ CompoundStmt /*P*/ CS = dyn_cast_CompoundStmt(Stmt1);
      if ((CS != null)) {
        if (!CS.body_empty()) {
          /*const*/ IfStmt /*P*/ InnerIf = dyn_cast_IfStmt(CS.body_begin$Const().$star());
          if ((InnerIf != null) && isIdenticalStmt(AC.getASTContext(), I.getCond$Const(), InnerIf.getCond$Const(), /*ignoreSideEffects=*/ false)) {
            PathDiagnosticLocation ELoc/*J*/= new PathDiagnosticLocation(InnerIf.getCond$Const(), BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
            BR.EmitBasicReport(AC.getDecl(), Checker, new StringRef(/*KEEP_STR*/"Identical conditions"), 
                new StringRef(categories.LogicError), 
                new StringRef(/*KEEP_STR*/"conditions of the inner and outer statements are identical"), 
                new PathDiagnosticLocation(ELoc));
          }
        }
      }
    }
    
    // Check for identical conditions:
    //
    // if (b) {
    //   foo1();
    // } else if (b) {
    //   foo2();
    // }
    if ((Stmt1 != null) && (Stmt2 != null)) {
      /*const*/ Expr /*P*/ Cond1 = I.getCond$Const();
      /*const*/ Stmt /*P*/ Else = Stmt2;
      {
        /*const*/ IfStmt /*P*/ I2;
        while (((/*P*/ I2 = dyn_cast_or_null_IfStmt(Else)) != null)) {
          /*const*/ Expr /*P*/ Cond2 = I2.getCond$Const();
          if (isIdenticalStmt(AC.getASTContext(), Cond1, Cond2, false)) {
            SourceRange Sr = Cond1.getSourceRange();
            PathDiagnosticLocation ELoc/*J*/= new PathDiagnosticLocation(Cond2, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
            BR.EmitBasicReport(AC.getDecl(), Checker, new StringRef(/*KEEP_STR*/"Identical conditions"), 
                new StringRef(categories.LogicError), 
                new StringRef(/*KEEP_STR*/"expression is identical to previous condition"), 
                new PathDiagnosticLocation(ELoc), new ArrayRef<SourceRange>(Sr, false));
          }
          Else = I2.getElse$Const();
        }
      }
    }
    if (!(Stmt1 != null) || !(Stmt2 != null)) {
      return true;
    }
    {
      
      // Special handling for code like:
      //
      // if (b) {
      //   i = 1;
      // } else
      //   i = 1;
      /*const*/ CompoundStmt /*P*/ CompStmt = dyn_cast_CompoundStmt(Stmt1);
      if ((CompStmt != null)) {
        if (CompStmt.size() == 1) {
          Stmt1 = CompStmt.body_back$Const();
        }
      }
    }
    {
      /*const*/ CompoundStmt /*P*/ CompStmt = dyn_cast_CompoundStmt(Stmt2);
      if ((CompStmt != null)) {
        if (CompStmt.size() == 1) {
          Stmt2 = CompStmt.body_back$Const();
        }
      }
    }
    if (isIdenticalStmt(AC.getASTContext(), Stmt1, Stmt2, true)) {
      PathDiagnosticLocation ELoc = PathDiagnosticLocation.createBegin(I, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      BR.EmitBasicReport(AC.getDecl(), Checker, 
          new StringRef(/*KEEP_STR*/"Identical branches"), 
          new StringRef(categories.LogicError), 
          new StringRef(/*KEEP_STR*/"true and false branches are identical"), new PathDiagnosticLocation(ELoc));
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::VisitConditionalOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 268,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitor24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitor24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE")
  //</editor-fold>
  public boolean VisitConditionalOperator(/*const*/ ConditionalOperator /*P*/ C) {
    
    // Check if expressions in conditional expression are identical
    // from a symbolic point of view.
    if (isIdenticalStmt(AC.getASTContext(), C.getTrueExpr(), 
        C.getFalseExpr(), true)) {
      PathDiagnosticLocation ELoc = PathDiagnosticLocation.createConditionalColonLoc(C, BR.getSourceManager());
      
      SourceRange Sr[/*2*/]/*J*/= new$T(new SourceRange [2], ()->new SourceRange());
      Sr[0].$assignMove(C.getTrueExpr().getSourceRange());
      Sr[1].$assignMove(C.getFalseExpr().getSourceRange());
      BR.EmitBasicReport(AC.getDecl(), Checker, 
          new StringRef(/*KEEP_STR*/"Identical expressions in conditional expression"), 
          new StringRef(categories.LogicError), 
          new StringRef(/*KEEP_STR*/"identical expressions on both sides of ':' in conditional expression"), 
          new PathDiagnosticLocation(ELoc), new ArrayRef<SourceRange>(Sr, false));
    }
    // We want to visit ALL nodes (expressions in conditional
    // expressions too) that contains conditional operators,
    // thus always return true to traverse ALL nodes.
    return true;
  }

/*private:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::reportIdenticalExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 61,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::reportIdenticalExpr", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitor19reportIdenticalExprEPKN5clang14BinaryOperatorEbN4llvm8ArrayRefINS1_11SourceRangeEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitor19reportIdenticalExprEPKN5clang14BinaryOperatorEbN4llvm8ArrayRefINS1_11SourceRangeEEE")
  //</editor-fold>
  private void reportIdenticalExpr(/*const*/ BinaryOperator /*P*/ B, 
                     boolean CheckBitwise, 
                     ArrayRef<SourceRange> Sr) {
    StringRef Message/*J*/= new StringRef();
    if (CheckBitwise) {
      Message.$assignMove(/*STRINGREF_STR*/"identical expressions on both sides of bitwise operator");
    } else {
      Message.$assignMove(/*STRINGREF_STR*/"identical expressions on both sides of logical operator");
    }
    
    PathDiagnosticLocation ELoc = PathDiagnosticLocation.createOperatorLoc(B, BR.getSourceManager());
    BR.EmitBasicReport(AC.getDecl(), Checker, 
        new StringRef(/*KEEP_STR*/"Use of identical expressions"), 
        new StringRef(categories.LogicError), 
        new StringRef(Message), new PathDiagnosticLocation(ELoc), new ArrayRef<SourceRange>(Sr));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::checkBitwiseOrLogicalOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 78,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::checkBitwiseOrLogicalOp", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitor23checkBitwiseOrLogicalOpEPKN5clang14BinaryOperatorEb",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitor23checkBitwiseOrLogicalOpEPKN5clang14BinaryOperatorEb")
  //</editor-fold>
  private void checkBitwiseOrLogicalOp(/*const*/ BinaryOperator /*P*/ B, 
                         boolean CheckBitwise) {
    SourceRange Sr[/*2*/]/*J*/= new$T(new SourceRange [2], ()->new SourceRange());
    
    /*const*/ Expr /*P*/ LHS = B.getLHS();
    /*const*/ Expr /*P*/ RHS = B.getRHS();
    {
      
      // Split operators as long as we still have operators to split on. We will
      // get called for every binary operator in an expression so there is no need
      // to check every one against each other here, just the right most one with
      // the others.
      /*const*/ BinaryOperator /*P*/ B2;
      while (((/*P*/ B2 = dyn_cast_BinaryOperator(LHS)) != null)) {
        if (B.getOpcode() != B2.getOpcode()) {
          break;
        }
        if (isIdenticalStmt(AC.getASTContext(), RHS, B2.getRHS())) {
          Sr[0].$assignMove(RHS.getSourceRange());
          Sr[1].$assignMove(B2.getRHS().getSourceRange());
          reportIdenticalExpr(B, CheckBitwise, new ArrayRef<SourceRange>(Sr, false));
        }
        LHS = B2.getLHS();
      }
    }
    if (isIdenticalStmt(AC.getASTContext(), RHS, LHS)) {
      Sr[0].$assignMove(RHS.getSourceRange());
      Sr[1].$assignMove(LHS.getSourceRange());
      reportIdenticalExpr(B, CheckBitwise, new ArrayRef<SourceRange>(Sr, false));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::FindIdenticalExprVisitor::checkComparisonOp">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp", line = 200,
   FQN="(anonymous namespace)::FindIdenticalExprVisitor::checkComparisonOp", NM="_ZN12_GLOBAL__N_124FindIdenticalExprVisitor17checkComparisonOpEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/IdenticalExprChecker.cpp -nm=_ZN12_GLOBAL__N_124FindIdenticalExprVisitor17checkComparisonOpEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  private void checkComparisonOp(/*const*/ BinaryOperator /*P*/ B) {
    BinaryOperatorKind Op = B.getOpcode();
    
    //
    // Special case for floating-point representation.
    //
    // If expressions on both sides of comparison operator are of type float,
    // then for some comparison operators no warning shall be
    // reported even if the expressions are identical from a symbolic point of
    // view. Comparison between expressions, declared variables and literals
    // are treated differently.
    //
    // != and == between float literals that have the same value should NOT warn.
    // < > between float literals that have the same value SHOULD warn.
    //
    // != and == between the same float declaration should NOT warn.
    // < > between the same float declaration SHOULD warn.
    //
    // != and == between eq. expressions that evaluates into float
    //           should NOT warn.
    // < >       between eq. expressions that evaluates into float
    //           should NOT warn.
    //
    /*const*/ Expr /*P*/ LHS = B.getLHS().IgnoreParenImpCasts();
    /*const*/ Expr /*P*/ RHS = B.getRHS().IgnoreParenImpCasts();
    
    /*const*/ DeclRefExpr /*P*/ DeclRef1 = dyn_cast_DeclRefExpr(LHS);
    /*const*/ DeclRefExpr /*P*/ DeclRef2 = dyn_cast_DeclRefExpr(RHS);
    /*const*/ FloatingLiteral /*P*/ FloatLit1 = dyn_cast_FloatingLiteral(LHS);
    /*const*/ FloatingLiteral /*P*/ FloatLit2 = dyn_cast_FloatingLiteral(RHS);
    if (((DeclRef1) != null) && ((DeclRef2) != null)) {
      if ((DeclRef1.getType().$arrow().hasFloatingRepresentation())
         && (DeclRef2.getType().$arrow().hasFloatingRepresentation())) {
        if (DeclRef1.getDecl$Const() == DeclRef2.getDecl$Const()) {
          if ((Op == BinaryOperatorKind.BO_EQ) || (Op == BinaryOperatorKind.BO_NE)) {
            return;
          }
        }
      }
    } else if (((FloatLit1) != null) && ((FloatLit2) != null)) {
      if (FloatLit1.getValue().bitwiseIsEqual(FloatLit2.getValue())) {
        if ((Op == BinaryOperatorKind.BO_EQ) || (Op == BinaryOperatorKind.BO_NE)) {
          return;
        }
      }
    } else if (LHS.getType().$arrow().hasFloatingRepresentation()) {
      // If any side of comparison operator still has floating-point
      // representation, then it's an expression. Don't warn.
      // Here only LHS is checked since RHS will be implicit casted to float.
      return;
    } else {
      // No special case with floating-point representation, report as usual.
    }
    if (isIdenticalStmt(AC.getASTContext(), B.getLHS(), B.getRHS())) {
      PathDiagnosticLocation ELoc = PathDiagnosticLocation.createOperatorLoc(B, BR.getSourceManager());
      StringRef Message/*J*/= new StringRef();
      if (((Op == BinaryOperatorKind.BO_EQ) || (Op == BinaryOperatorKind.BO_LE) || (Op == BinaryOperatorKind.BO_GE))) {
        Message.$assignMove(/*STRINGREF_STR*/"comparison of identical expressions always evaluates to true");
      } else {
        Message.$assignMove(/*STRINGREF_STR*/"comparison of identical expressions always evaluates to false");
      }
      BR.EmitBasicReport(AC.getDecl(), Checker, 
          new StringRef(/*KEEP_STR*/"Compare of identical expressions"), 
          new StringRef(categories.LogicError), new StringRef(Message), new PathDiagnosticLocation(ELoc));
    }
  }

  @Override
  public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
    // no Traverse* methods
    return false;
  }

  @Override public String toString() {
    return "" + "BR=" + BR // NOI18N
              + ", Checker=" + Checker // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
