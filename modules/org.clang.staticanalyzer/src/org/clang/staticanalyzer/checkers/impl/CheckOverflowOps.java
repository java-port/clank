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
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.checkers.impl.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import org.clang.staticanalyzer.checkers.impl.java.StaticAnalyzerCheckersImplFunctionPointers.*;

// A worker class for OutputPossibleOverflows.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 126,
 FQN="(anonymous namespace)::CheckOverflowOps", NM="_ZN12_GLOBAL__N_116CheckOverflowOpsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOpsE")
//</editor-fold>
public class CheckOverflowOps implements /*public*/ EvaluatedExprVisitor<CheckOverflowOps> {
/*public:*/
  /*typedef SmallVectorImpl<MallocOverflowCheck> theVecType*/
//  public final class theVecType extends SmallVectorImpl<MallocOverflowCheck>{ };
/*private:*/
  private final SmallVectorImpl<MallocOverflowCheck> /*&*/ toScanFor;
  private final ASTContext /*&*/ Context;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::isIntZeroExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 135,
   FQN="(anonymous namespace)::CheckOverflowOps::isIntZeroExpr", NM="_ZNK12_GLOBAL__N_116CheckOverflowOps13isIntZeroExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZNK12_GLOBAL__N_116CheckOverflowOps13isIntZeroExprEPKN5clang4ExprE")
  //</editor-fold>
  private boolean isIntZeroExpr(/*const*/ Expr /*P*/ E) /*const*/ {
    if (!E.getType().$arrow().isIntegralOrEnumerationType()) {
      return false;
    }
    APSInt Result/*J*/= new APSInt();
    if (E.EvaluateAsInt(Result, Context)) {
      return Result.$eq(0);
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 144,
   FQN="(anonymous namespace)::CheckOverflowOps::getDecl", NM="_ZN12_GLOBAL__N_116CheckOverflowOps7getDeclEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps7getDeclEPKN5clang11DeclRefExprE")
  //</editor-fold>
  private static /*const*/ Decl /*P*/ getDecl(/*const*/ DeclRefExpr /*P*/ DR) {
    return DR.getDecl$Const();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::getDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 145,
   FQN="(anonymous namespace)::CheckOverflowOps::getDecl", NM="_ZN12_GLOBAL__N_116CheckOverflowOps7getDeclEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps7getDeclEPKN5clang10MemberExprE")
  //</editor-fold>
  private static /*const*/ Decl /*P*/ getDecl(/*const*/ MemberExpr /*P*/ ME) {
    return ME.getMemberDecl();
  }

  
  /*template <typename T1> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::Erase">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC /*manual specialization*/,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 150,
   FQN="(anonymous namespace)::CheckOverflowOps::Erase", NM="Tpl__ZN12_GLOBAL__N_116CheckOverflowOps5EraseEPKT_N4llvm12function_refIFbRKNS_19MallocOverflowCheckEEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=Tpl__ZN12_GLOBAL__N_116CheckOverflowOps5EraseEPKT_N4llvm12function_refIFbRKNS_19MallocOverflowCheckEEEE")
  //</editor-fold>
  //private </*typename*/ T1 extends Expr> void Erase(/*const*/ T1 /*P*/ DR, 
  private void Erase(/*const*/ DeclRefExpr /*P*/ DR, 
       MallocOverflowCheck$Ref2Bool Pred) {
    DeclRefExpr L$DR = $tryClone(DR); // JAVA: captured copy for lambda
    MallocOverflowCheck$Ref2Bool L$Pred = $tryClone(Pred); // JAVA: captured copy for lambda
    MallocOverflowCheck$Ref2Bool P = (final /*const*/ MallocOverflowCheck /*&*/ Check) -> {
          {
            DeclRefExpr /*const*/ /*P*/ CheckDR = dyn_cast_DeclRefExpr(Check.variable);
            if (CheckDR != null) {
              return Native.$bool(Native.$eq(getDecl(CheckDR), getDecl(L$DR))) && L$Pred.$call(Check);
            }
          }
          return false;
        };
    final type$ptr<MallocOverflowCheck> begin = toScanFor.begin();
    final type$ptr<MallocOverflowCheck> end = toScanFor.end();
    toScanFor.erase(std.remove_if(toScanFor.begin(), toScanFor.end(), P), 
        toScanFor.end());
  }
  private void Erase(/*const*/ MemberExpr /*P*/ DR, 
       MallocOverflowCheck$Ref2Bool Pred) {
    MemberExpr L$DR = $tryClone(DR); // JAVA: captured copy for lambda
    MallocOverflowCheck$Ref2Bool L$Pred = $tryClone(Pred); // JAVA: captured copy for lambda
    MallocOverflowCheck$Ref2Bool P = (final /*const*/ MallocOverflowCheck /*&*/ Check) -> {
          {
            MemberExpr /*const*/ /*P*/ CheckDR = dyn_cast_MemberExpr(Check.variable);
            if (CheckDR != null) {
              return Native.$bool(Native.$eq(getDecl(CheckDR), getDecl(L$DR))) && L$Pred.$call(Check);
            }
          }
          return false;
        };
    toScanFor.erase(std.remove_if(toScanFor.begin(), toScanFor.end(), P), 
        toScanFor.end());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::CheckExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 161,
   FQN="(anonymous namespace)::CheckOverflowOps::CheckExpr", NM="_ZN12_GLOBAL__N_116CheckOverflowOps9CheckExprEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps9CheckExprEPKN5clang4ExprE")
  //</editor-fold>
  private void CheckExpr(/*const*/ Expr /*P*/ E_p) {
    MallocOverflowCheck$Ref2Bool/*const*/ PredTrue = /*[]*/ (final /*const*/ MallocOverflowCheck /*&*/ $Prm0) -> {
          return true;
        };
    /*const*/ Expr /*P*/ E = E_p.IgnoreParenImpCasts$Const();
    {
      /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E);
      if ((DR != null)) {
        this.<DeclRefExpr>Erase(DR, /*FuncArg*/PredTrue);
      } else {
        /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
        if ((ME != null)) {
          this.<MemberExpr>Erase(ME, /*FuncArg*/PredTrue);
        }
      }
    }
  }

  
  // Check if the argument to malloc is assigned a value
  // which cannot cause an overflow.
  // e.g., malloc (mul * x) and,
  // case 1: mul = <constant value>
  // case 2: mul = a/b, where b > x
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::CheckAssignmentExpr">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 176,
   FQN="(anonymous namespace)::CheckOverflowOps::CheckAssignmentExpr", NM="_ZN12_GLOBAL__N_116CheckOverflowOps19CheckAssignmentExprEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps19CheckAssignmentExprEPN5clang14BinaryOperatorE")
  //</editor-fold>
  private void CheckAssignmentExpr(BinaryOperator /*P*/ AssignEx) {
    boolean assignKnown = false;
    boolean numeratorKnown = false;
    boolean denomKnown = false;
    APSInt denomVal/*J*/= new APSInt();
    denomVal.$assign($int2ulong(0));
    
    // Erase if the multiplicand was assigned a constant value.
    /*const*/ Expr /*P*/ rhs = AssignEx.getRHS();
    if (rhs.isEvaluatable(Context)) {
      assignKnown = true;
    }
    
    // Discard the report if the multiplicand was assigned a value,
    // that can never overflow after multiplication. e.g., the assignment
    // is a division operator and the denominator is > other multiplicand.
    /*const*/ Expr /*P*/ rhse = rhs.IgnoreParenImpCasts$Const();
    {
      /*const*/ BinaryOperator /*P*/ BOp = dyn_cast_BinaryOperator(rhse);
      if ((BOp != null)) {
        if (BOp.getOpcode() == BinaryOperatorKind.BO_Div) {
          /*const*/ Expr /*P*/ denom = BOp.getRHS().IgnoreParenImpCasts();
          if (denom.EvaluateAsInt(denomVal, Context)) {
            denomKnown = true;
          }
          /*const*/ Expr /*P*/ numerator = BOp.getLHS().IgnoreParenImpCasts();
          if (numerator.isEvaluatable(Context)) {
            numeratorKnown = true;
          }
        }
      }
    }
    if (!assignKnown && !denomKnown) {
      return;
    }
    long/*int64_t*/ denomExtVal = denomVal.getExtValue();
    
    // Ignore negative denominator.
    if (denomExtVal < 0) {
      return;
    }
    
    /*const*/ Expr /*P*/ lhs = AssignEx.getLHS();
    /*const*/ Expr /*P*/ E = lhs.IgnoreParenImpCasts$Const();
    
    // JAVA: effectively final vars for use in lambda
    boolean L$assignKnown = assignKnown;
    boolean L$numeratorKnown = numeratorKnown;
    long L$denomExtVal = denomExtVal;
    
    MallocOverflowCheck$Ref2Bool/*const*/ pred = /*[=L$assignKnown(assignKnown), =L$numeratorKnown(numeratorKnown), =L$denomExtVal(denomExtVal)]*/ (final /*const*/ MallocOverflowCheck /*&*/ Check) -> {
          return L$assignKnown
             || (L$numeratorKnown && (L$denomExtVal >= Check.maxVal.getExtValue()));
        };
    {
      
      /*const*/ DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E);
      if ((DR != null)) {
        this.<DeclRefExpr>Erase(DR, /*FuncArg*/pred);
      } else {
        /*const*/ MemberExpr /*P*/ ME = dyn_cast_MemberExpr(E);
        if ((ME != null)) {
          this.<MemberExpr>Erase(ME, /*FuncArg*/pred);
        }
      }
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::VisitBinaryOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 225,
   FQN="(anonymous namespace)::CheckOverflowOps::VisitBinaryOperator", NM="_ZN12_GLOBAL__N_116CheckOverflowOps19VisitBinaryOperatorEPN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps19VisitBinaryOperatorEPN5clang14BinaryOperatorE")
  //</editor-fold>
  public void VisitBinaryOperator(BinaryOperator /*P*/ E) {
    if (E.isComparisonOp()) {
      /*const*/ Expr /*P*/ lhs = E.getLHS();
      /*const*/ Expr /*P*/ rhs = E.getRHS();
      // Ignore comparisons against zero, since they generally don't
      // protect against an overflow.
      if (!isIntZeroExpr(lhs) && !isIntZeroExpr(rhs)) {
        CheckExpr(lhs);
        CheckExpr(rhs);
      }
    }
    if (E.isAssignmentOp()) {
      CheckAssignmentExpr(E);
    }
    EvaluatedExprVisitor.super.VisitBinaryOperator(E);
  }

  
  /* We specifically ignore loop conditions, because they're typically
  not error checks.  */
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::VisitWhileStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 243,
   FQN="(anonymous namespace)::CheckOverflowOps::VisitWhileStmt", NM="_ZN12_GLOBAL__N_116CheckOverflowOps14VisitWhileStmtEPN5clang9WhileStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps14VisitWhileStmtEPN5clang9WhileStmtE")
  //</editor-fold>
  public void VisitWhileStmt(WhileStmt /*P*/ S) {
    /*J:ToBase*/EvaluatedExprVisitor /*P*/ .super.Visit(S.getBody());
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::VisitForStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 246,
   FQN="(anonymous namespace)::CheckOverflowOps::VisitForStmt", NM="_ZN12_GLOBAL__N_116CheckOverflowOps12VisitForStmtEPN5clang7ForStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps12VisitForStmtEPN5clang7ForStmtE")
  //</editor-fold>
  public void VisitForStmt(ForStmt /*P*/ S) {
    /*J:ToBase*/EvaluatedExprVisitor /*P*/ .super.Visit(S.getBody());
    /*JAVA:return*/return;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::VisitDoStmt">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 249,
   FQN="(anonymous namespace)::CheckOverflowOps::VisitDoStmt", NM="_ZN12_GLOBAL__N_116CheckOverflowOps11VisitDoStmtEPN5clang6DoStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOps11VisitDoStmtEPN5clang6DoStmtE")
  //</editor-fold>
  public void VisitDoStmt(DoStmt /*P*/ S) {
    /*J:ToBase*/EvaluatedExprVisitor /*P*/ .super.Visit(S.getBody());
    /*JAVA:return*/return;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckOverflowOps::CheckOverflowOps">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp", line = 253,
   FQN="(anonymous namespace)::CheckOverflowOps::CheckOverflowOps", NM="_ZN12_GLOBAL__N_116CheckOverflowOpsC1ERN4llvm15SmallVectorImplINS_19MallocOverflowCheckEEERN5clang10ASTContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/MallocOverflowSecurityChecker.cpp -nm=_ZN12_GLOBAL__N_116CheckOverflowOpsC1ERN4llvm15SmallVectorImplINS_19MallocOverflowCheckEEERN5clang10ASTContextE")
  //</editor-fold>
  public CheckOverflowOps(final SmallVectorImpl<MallocOverflowCheck> /*&*/ v, final ASTContext /*&*/ ctx) {
    // : EvaluatedExprVisitor<CheckOverflowOps>(ctx), toScanFor(v), Context(ctx) 
    //START JInit
    this.EvaluatedExprVisitorBase$Flds = $EvaluatedExprVisitor(ctx);
    this./*&*/toScanFor=/*&*/v;
    this./*&*/Context=/*&*/ctx;
    //END JInit
  }

  
  private final EvaluatedExprVisitorBase$Fields EvaluatedExprVisitorBase$Flds;// use return value of $EvaluatedExprVisitor();
  @Override public final EvaluatedExprVisitorBase$Fields $EvaluatedExprVisitorBase$Fields() { return EvaluatedExprVisitorBase$Flds; }
  
  @Override public String toString() {
    return "" + "toScanFor=" + toScanFor // NOI18N
              + ", Context=" + "[ASTContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
