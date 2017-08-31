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
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1086,
 FQN="(anonymous namespace)::PluralMisuseChecker", NM="_ZN12_GLOBAL__N_119PluralMisuseCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseCheckerE")
//</editor-fold>
public class PluralMisuseChecker extends /*public*/ Checker/*T<ASTCodeBody> */
        implements org.clang.staticanalyzer.java.ASTCodeBodyChecker, Destructors.ClassWithDestructor {
  
  // A helper class, which walks the AST
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1089,
   FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawlerE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawlerE")
  //</editor-fold>
  private static class MethodCrawler implements /*public*/ RecursiveASTVisitor<MethodCrawler>, Destructors.ClassWithDestructor {
    private final BugReporter /*&*/ BR;
    private /*const*/ CheckerBase /*P*/ Checker;
    private AnalysisDeclContext /*P*/ AC;
    
    // This functions like a stack. We push on any IfStmt or
    // ConditionalOperator that matches the condition
    // and pop it off when we leave that statement
    private SmallVector</*const*/ Stmt /*P*/ > MatchingStatements;
    // This is true when we are the direct-child of a
    // matching statement
    private boolean InMatchingStatement/* = false*/;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::MethodCrawler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1103,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::MethodCrawler", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawlerC1ERN5clang4ento11BugReporterEPKNS3_11CheckerBaseEPNS2_19AnalysisDeclContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawlerC1ERN5clang4ento11BugReporterEPKNS3_11CheckerBaseEPNS2_19AnalysisDeclContextE")
    //</editor-fold>
    public /*explicit*/ MethodCrawler(final BugReporter /*&*/ InBR, /*const*/ CheckerBase /*P*/ Checker, 
        AnalysisDeclContext /*P*/ InAC) {
      // : RecursiveASTVisitor<MethodCrawler>(), BR(InBR), Checker(Checker), AC(InAC), MatchingStatements(), InMatchingStatement(false) 
      //START JInit
      $RecursiveASTVisitor();
      this./*&*/BR=/*&*/InBR;
      this.Checker = Checker;
      this.AC = InAC;
      this.MatchingStatements = new SmallVector</*const*/ Stmt /*P*/ >(8, (/*const*/ Stmt /*P*/ )null);
      /*InClass*/this.InMatchingStatement = false;
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitIfStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1231,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitIfStmt", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler11VisitIfStmtEPKN5clang6IfStmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler11VisitIfStmtEPKN5clang6IfStmtE")
    //</editor-fold>
    public boolean VisitIfStmt(/*const*/ IfStmt /*P*/ I) {
      /*const*/ Expr /*P*/ Condition = I.getCond$Const().IgnoreParenImpCasts$Const();
      if (isCheckingPlurality(Condition)) {
        MatchingStatements.push_back(I);
        InMatchingStatement = true;
      } else {
        MatchingStatements.push_back((/*const*/ Stmt /*P*/ /*const*/)null);
        InMatchingStatement = false;
      }
      
      return true;
    }

    
    // EndVisit callbacks are not provided by the RecursiveASTVisitor
    // so we override TraverseIfStmt and make a call to EndVisitIfStmt
    // after traversing the IfStmt
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::EndVisitIfStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1219,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::EndVisitIfStmt", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler14EndVisitIfStmtEPN5clang6IfStmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler14EndVisitIfStmtEPN5clang6IfStmtE")
    //</editor-fold>
    public boolean EndVisitIfStmt(IfStmt /*P*/ I) {
      MatchingStatements.pop_back();
      if (!MatchingStatements.empty()) {
        if (MatchingStatements.back() != null) {
          InMatchingStatement = true;
          return true;
        }
      }
      InMatchingStatement = false;
      return true;
    }

    
    /// Override TraverseIfStmt so we know when we are done traversing an IfStmt
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::TraverseIfStmt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1211,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::TraverseIfStmt", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler14TraverseIfStmtEPN5clang6IfStmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler14TraverseIfStmtEPN5clang6IfStmtE")
    //</editor-fold>
    public boolean TraverseIfStmt(IfStmt /*P*/ I) {
      RecursiveASTVisitor.super.TraverseIfStmt(I);
      return EndVisitIfStmt(I);
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitConditionalOperator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1260,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitConditionalOperator", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler24VisitConditionalOperatorEPKN5clang19ConditionalOperatorE")
    //</editor-fold>
    public boolean VisitConditionalOperator(/*const*/ ConditionalOperator /*P*/ C) {
      /*const*/ Expr /*P*/ Condition = C.getCond().IgnoreParenImpCasts();
      if (isCheckingPlurality(Condition)) {
        MatchingStatements.push_back(C);
        InMatchingStatement = true;
      } else {
        MatchingStatements.push_back((/*const*/ Stmt /*P*/ /*const*/)null);
        InMatchingStatement = false;
      }
      return true;
    }

    
    // Preliminary support for conditional operators.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::TraverseConditionalOperator">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1245,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::TraverseConditionalOperator", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler27TraverseConditionalOperatorEPN5clang19ConditionalOperatorE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler27TraverseConditionalOperatorEPN5clang19ConditionalOperatorE")
    //</editor-fold>
    public boolean TraverseConditionalOperator(ConditionalOperator /*P*/ C) {
      RecursiveASTVisitor.super.TraverseConditionalOperator(C);
      MatchingStatements.pop_back();
      if (!MatchingStatements.empty()) {
        if (MatchingStatements.back() != null) {
          InMatchingStatement = true;
        } else {
          InMatchingStatement = false;
        }
      } else {
        InMatchingStatement = false;
      }
      return true;
    }

    
    // A CallExpr with "LOC" in its identifier that takes in a string literal
    // has been shown to almost always be a function that returns a localized
    // string. Raise a diagnostic when this is in a statement that matches
    // the condition.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitCallExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1172,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitCallExpr", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler13VisitCallExprEPKN5clang8CallExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler13VisitCallExprEPKN5clang8CallExprE")
    //</editor-fold>
    public boolean VisitCallExpr(/*const*/ CallExpr /*P*/ CE) {
      if (InMatchingStatement) {
        {
          /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const();
          if ((FD != null)) {
            std.string NormalizedName = new StringRef(FD.getNameInfo().getAsString()).lower();
            if (NormalizedName.find_T$C$P_size_type$_CharT(/*KEEP_STR*/"loc") != std.string.npos) {
              for (/*const*/ Expr /*P*/ Arg : CE.arguments$Const()) {
                if (isa_ObjCStringLiteral(Arg)) {
                  reportPluralMisuseError(CE);
                }
              }
            }
          }
        }
      }
      return true;
    }

    
    // The other case is for NSLocalizedString which also returns
    // a localized string. It's a macro for the ObjCMessageExpr
    // [NSBundle localizedStringForKey:value:table:] Raise a
    // diagnostic when this is in a statement that matches
    // the condition.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitObjCMessageExpr">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1193,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler20VisitObjCMessageExprEPKN5clang15ObjCMessageExprE")
    //</editor-fold>
    public boolean VisitObjCMessageExpr(/*const*/ ObjCMessageExpr /*P*/ ME) {
      /*const*/ ObjCInterfaceDecl /*P*/ OD = ME.getReceiverInterface();
      if (!(OD != null)) {
        return true;
      }
      
      /*const*/ IdentifierInfo /*P*/ odInfo = OD.getIdentifier();
      if (odInfo.isStr(/*KEEP_STR*/"NSBundle")
         && $eq_string$C_T$C$P(ME.getSelector().getAsString(), /*KEEP_STR*/"localizedStringForKey:value:table:")) {
        if (InMatchingStatement) {
          reportPluralMisuseError(ME);
        }
      }
      return true;
    }

  /*private:*/
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::reportPluralMisuseError">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1273,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::reportPluralMisuseError", NM="_ZNK12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler23reportPluralMisuseErrorEPKN5clang4StmtE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler23reportPluralMisuseErrorEPKN5clang4StmtE")
    //</editor-fold>
    private void reportPluralMisuseError(/*const*/ Stmt /*P*/ S) /*const*/ {
      // Generate the bug report.
      BR.EmitBasicReport(AC.getDecl(), Checker, new StringRef(/*KEEP_STR*/"Plural Misuse"), 
          new StringRef(/*KEEP_STR*/"Localizability Issue (Apple)"), 
          new StringRef(/*KEEP_STR*/"Plural cases are not supported accross all languages. Use a .stringsdict file instead"), 
          new PathDiagnosticLocation(S, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC)));
    }

    // end anonymous namespace
    
    // Checks the condition of the IfStmt and returns true if one
    // of the following heuristics are met:
    // 1) The conidtion is a variable with "singular" or "plural" in the name
    // 2) The condition is a binary operator with 1 or 2 on the right-hand side
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::isCheckingPlurality">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1133,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::isCheckingPlurality", NM="_ZNK12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler19isCheckingPluralityEPKN5clang4ExprE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_119PluralMisuseChecker13MethodCrawler19isCheckingPluralityEPKN5clang4ExprE")
    //</editor-fold>
    private boolean isCheckingPlurality(/*const*/ Expr /*P*/ Condition) /*const*/ {
      /*const*/ BinaryOperator /*P*/ BO = null;
      {
        // Accounts for when a VarDecl represents a BinaryOperator
        /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Condition);
        if ((DRE != null)) {
          {
            /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
            if ((VD != null)) {
              /*const*/ Expr /*P*/ InitExpr = VD.getInit$Const();
              if ((InitExpr != null)) {
                {
                  /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(InitExpr.IgnoreParenImpCasts$Const());
                  if ((B != null)) {
                    BO = B;
                  }
                }
              }
              if (VD.getName().lower().find_T$C$P_size_type$_CharT(/*KEEP_STR*/"plural") != StringRef.npos
                 || VD.getName().lower().find_T$C$P_size_type$_CharT(/*KEEP_STR*/"singular") != StringRef.npos) {
                return true;
              }
            }
          }
        } else {
          /*const*/ BinaryOperator /*P*/ B = dyn_cast_BinaryOperator(Condition);
          if ((B != null)) {
            BO = B;
          }
        }
      }
      if (BO == null) {
        return false;
      }
      {
        
        IntegerLiteral /*P*/ IL = dyn_cast_or_null_IntegerLiteral(BO.getRHS().IgnoreParenImpCasts());
        if ((IL != null)) {
          APInt Value = IL.getValue();
          if (Value.$eq($int2ulong(1)) || Value.$eq($int2ulong(2))) {
            return true;
          }
        }
      }
      return false;
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::~MethodCrawler">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1089,
     FQN="(anonymous namespace)::PluralMisuseChecker::MethodCrawler::~MethodCrawler", NM="_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawlerD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseChecker13MethodCrawlerD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      MatchingStatements.$destroy();
      RecursiveASTVisitor.super.$destroy$RecursiveASTVisitor();
      //END JDestroy
    }

    @Override
    public boolean has_overridden_traverse_with_queue_method(String TraverseMethodName) {
      if ("TraverseConditionalOperator".equals(TraverseMethodName) ||
          "TraverseIfStmt".equals(TraverseMethodName)) {
        return true;
      }
      return false;
    }
    
    @Override public String toString() {
      return "" + "BR=" + BR // NOI18N
                + ", Checker=" + Checker // NOI18N
                + ", AC=" + "[AnalysisDeclContext]" // NOI18N
                + ", MatchingStatements=" + MatchingStatements // NOI18N
                + ", InMatchingStatement=" + InMatchingStatement // NOI18N
                + super.toString(); // NOI18N
    }
  };
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::checkASTCodeBody">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1121,
   FQN="(anonymous namespace)::PluralMisuseChecker::checkASTCodeBody", NM="_ZNK12_GLOBAL__N_119PluralMisuseChecker16checkASTCodeBodyEPKN5clang4DeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZNK12_GLOBAL__N_119PluralMisuseChecker16checkASTCodeBodyEPKN5clang4DeclERNS1_4ento15AnalysisManagerERNS5_11BugReporterE")
  //</editor-fold>
  public void checkASTCodeBody(/*const*/ Decl /*P*/ D, final AnalysisManager /*&*/ Mgr, 
                  final BugReporter /*&*/ BR) /*const*/ {
    MethodCrawler Visitor = null;
    try {
      Visitor/*J*/= new MethodCrawler(BR, this, Mgr.getAnalysisDeclContext(D));
      Visitor.TraverseDecl(((/*const_cast*/Decl /*P*/ )(D)));
    } finally {
      if (Visitor != null) { Visitor.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::~PluralMisuseChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1086,
   FQN="(anonymous namespace)::PluralMisuseChecker::~PluralMisuseChecker", NM="_ZN12_GLOBAL__N_119PluralMisuseCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    super.$destroy();
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::PluralMisuseChecker::PluralMisuseChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp", line = 1086,
   FQN="(anonymous namespace)::PluralMisuseChecker::PluralMisuseChecker", NM="_ZN12_GLOBAL__N_119PluralMisuseCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LocalizationChecker.cpp -nm=_ZN12_GLOBAL__N_119PluralMisuseCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ PluralMisuseChecker() {
    // : Checker<ASTCodeBody>() 
    //START JInit
    super();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private final CheckBase $CHECKS[] = {
    new ASTCodeBody()
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
