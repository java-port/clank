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
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstRTTI.*;



//<editor-fold defaultstate="collapsed" desc="static type CStringSyntaxCheckerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE; -static-type=CStringSyntaxCheckerStatics")
//</editor-fold>
public final class CStringSyntaxCheckerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 33,
 FQN="(anonymous namespace)::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE")
//</editor-fold>
public static class WalkAST implements /*public*/ StmtVisitorVoid<WalkAST> {
  private /*const*/ CheckerBase /*P*/ Checker;
  private final BugReporter /*&*/ BR;
  private AnalysisDeclContext /*P*/ AC;
  
  /// Check if two expressions refer to the same declaration.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::sameDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 39,
   FQN="(anonymous namespace)::WalkAST::sameDecl", NM="_ZN12_GLOBAL__N_17WalkAST8sameDeclEPKN5clang4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST8sameDeclEPKN5clang4ExprES4_")
  //</editor-fold>
  private /*inline*/ boolean sameDecl(/*const*/ Expr /*P*/ A1, /*const*/ Expr /*P*/ A2) {
    {
      /*const*/ DeclRefExpr /*P*/ D1 = dyn_cast_DeclRefExpr(A1.IgnoreParenCasts$Const());
      if ((D1 != null)) {
        {
          /*const*/ DeclRefExpr /*P*/ D2 = dyn_cast_DeclRefExpr(A2.IgnoreParenCasts$Const());
          if ((D2 != null)) {
            return D1.getDecl$Const() == D2.getDecl$Const();
          }
        }
      }
    }
    return false;
  }

  
  /// Check if the expression E is a sizeof(WithArg).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::isSizeof">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 47,
   FQN="(anonymous namespace)::WalkAST::isSizeof", NM="_ZN12_GLOBAL__N_17WalkAST8isSizeofEPKN5clang4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST8isSizeofEPKN5clang4ExprES4_")
  //</editor-fold>
  private /*inline*/ boolean isSizeof(/*const*/ Expr /*P*/ E, /*const*/ Expr /*P*/ WithArg) {
    {
      /*const*/ UnaryExprOrTypeTraitExpr /*P*/ UE = dyn_cast_UnaryExprOrTypeTraitExpr(E);
      if ((UE != null)) {
        if (UE.getKind() == UnaryExprOrTypeTrait.UETT_SizeOf) {
          return sameDecl(UE.getArgumentExpr$Const(), WithArg);
        }
      }
    }
    return false;
  }

  
  /// Check if the expression E is a strlen(WithArg).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::isStrlen">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 56,
   FQN="(anonymous namespace)::WalkAST::isStrlen", NM="_ZN12_GLOBAL__N_17WalkAST8isStrlenEPKN5clang4ExprES4_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST8isStrlenEPKN5clang4ExprES4_")
  //</editor-fold>
  private /*inline*/ boolean isStrlen(/*const*/ Expr /*P*/ E, /*const*/ Expr /*P*/ WithArg) {
    {
      /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
      if ((CE != null)) {
        /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee$Const();
        if (!(FD != null)) {
          return false;
        }
        return (CheckerContext.isCLibraryFunction(FD, new StringRef(/*KEEP_STR*/"strlen"))
           && sameDecl(CE.getArg$Const(0), WithArg));
      }
    }
    return false;
  }

  
  /// Check if the expression is an integer literal with value 1.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::isOne">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 68,
   FQN="(anonymous namespace)::WalkAST::isOne", NM="_ZN12_GLOBAL__N_17WalkAST5isOneEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST5isOneEPKN5clang4ExprE")
  //</editor-fold>
  private /*inline*/ boolean isOne(/*const*/ Expr /*P*/ E) {
    {
      /*const*/ IntegerLiteral /*P*/ IL = dyn_cast_IntegerLiteral(E);
      if ((IL != null)) {
        return (IL.getValue().isIntN(1));
      }
    }
    return false;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::getPrintableName">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 74,
   FQN="(anonymous namespace)::WalkAST::getPrintableName", NM="_ZN12_GLOBAL__N_17WalkAST16getPrintableNameEPKN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST16getPrintableNameEPKN5clang4ExprE")
  //</editor-fold>
  private /*inline*/ StringRef getPrintableName(/*const*/ Expr /*P*/ E) {
    {
      /*const*/ DeclRefExpr /*P*/ D = dyn_cast_DeclRefExpr(E.IgnoreParenCasts$Const());
      if ((D != null)) {
        return D.getDecl$Const().getName();
      }
    }
    return new StringRef();
  }

  
  /// Identify erroneous patterns in the last argument to strncat - the number
  /// of bytes to copy.
  // end anonymous namespace
  
  // The correct size argument should look like following:
  //   strncat(dst, src, sizeof(dst) - strlen(dest) - 1);
  // We look for the following anti-patterns:
  //   - strncat(dst, src, sizeof(dst) - strlen(dst));
  //   - strncat(dst, src, sizeof(dst) - 1);
  //   - strncat(dst, src, sizeof(dst));
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::containsBadStrncatPattern">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 103,
   FQN="(anonymous namespace)::WalkAST::containsBadStrncatPattern", NM="_ZN12_GLOBAL__N_17WalkAST25containsBadStrncatPatternEPKN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST25containsBadStrncatPatternEPKN5clang8CallExprE")
  //</editor-fold>
  private boolean containsBadStrncatPattern(/*const*/ CallExpr /*P*/ CE) {
    if (CE.getNumArgs() != 3) {
      return false;
    }
    /*const*/ Expr /*P*/ DstArg = CE.getArg$Const(0);
    /*const*/ Expr /*P*/ SrcArg = CE.getArg$Const(1);
    /*const*/ Expr /*P*/ LenArg = CE.getArg$Const(2);
    {
      
      // Identify wrong size expressions, which are commonly used instead.
      /*const*/ BinaryOperator /*P*/ BE = dyn_cast_BinaryOperator(LenArg.IgnoreParenCasts$Const());
      if ((BE != null)) {
        // - sizeof(dst) - strlen(dst)
        if (BE.getOpcode() == BinaryOperatorKind.BO_Sub) {
          /*const*/ Expr /*P*/ L = BE.getLHS();
          /*const*/ Expr /*P*/ R = BE.getRHS();
          if (isSizeof(L, DstArg) && isStrlen(R, DstArg)) {
            return true;
          }
          
          // - sizeof(dst) - 1
          if (isSizeof(L, DstArg) && isOne(R.IgnoreParenCasts$Const())) {
            return true;
          }
        }
      }
    }
    // - sizeof(dst)
    if (isSizeof(LenArg, DstArg)) {
      return true;
    }
    
    // - sizeof(src)
    if (isSizeof(LenArg, SrcArg)) {
      return true;
    }
    return false;
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::WalkAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 85,
   FQN="(anonymous namespace)::WalkAST::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTC1EPKN5clang4ento11CheckerBaseERNS2_11BugReporterEPNS1_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkASTC1EPKN5clang4ento11CheckerBaseERNS2_11BugReporterEPNS1_19AnalysisDeclContextE")
  //</editor-fold>
  public WalkAST(/*const*/ CheckerBase /*P*/ checker, final BugReporter /*&*/ br, AnalysisDeclContext /*P*/ ac) {
    // : StmtVisitor<WalkAST>(), Checker(checker), BR(br), AC(ac) 
    //START JInit
    $StmtVisitor();
    this.Checker = checker;
    this./*&*/BR=/*&*/br;
    this.AC = ac;
    //END JInit
  }

  
  // Statement visitor methods.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 170,
   FQN="(anonymous namespace)::WalkAST::VisitChildren", NM="_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 90,
   FQN="(anonymous namespace)::WalkAST::VisitStmt", NM="_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp", line = 135,
   FQN="(anonymous namespace)::WalkAST::VisitCallExpr", NM="_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CStringSyntaxChecker.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public void VisitCallExpr(CallExpr /*P*/ CE) {
    /*const*/ FunctionDecl /*P*/ FD = CE.getDirectCallee();
    if (!(FD != null)) {
      return;
    }
    if (CheckerContext.isCLibraryFunction(FD, new StringRef(/*KEEP_STR*/"strncat"))) {
      if (containsBadStrncatPattern(CE)) {
        raw_svector_ostream os = null;
        try {
          /*const*/ Expr /*P*/ DstArg = CE.getArg(0);
          /*const*/ Expr /*P*/ LenArg = CE.getArg(2);
          PathDiagnosticLocation Loc = PathDiagnosticLocation.createBegin(LenArg, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
          
          StringRef DstName = getPrintableName(DstArg);
          
          SmallString/*256*/ S/*J*/= new SmallString/*256*/(256);
          os/*J*/= new raw_svector_ostream(S);
          os.$out(/*KEEP_STR*/"Potential buffer overflow. ");
          if (!DstName.empty()) {
            os.$out(/*KEEP_STR*/"Replace with 'sizeof(").$out(/*NO_COPY*/DstName).$out(/*KEEP_STR*/") - strlen(").$out(/*NO_COPY*/DstName).$out(/*KEEP_STR*/") - 1'");
            os.$out(/*KEEP_STR*/" or u");
          } else {
            os.$out(/*KEEP_STR*/$U);
          }
          os.$out(/*KEEP_STR*/"se a safer 'strlcat' API");
          
          BR.EmitBasicReport(FD, Checker, new StringRef(/*KEEP_STR*/"Anti-pattern in the argument"), 
              new StringRef(/*KEEP_STR*/"C String API"), os.str(), new PathDiagnosticLocation(Loc), 
              new ArrayRef<SourceRange>(LenArg.getSourceRange(), false));
        } finally {
          if (os != null) { os.$destroy(); }
        }
      }
    }
    
    // Recurse and check children.
    VisitChildren(CE);
  }

  
  @Override public String toString() {
    return "" + "Checker=" + Checker // NOI18N
              + ", BR=" + BR // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
} // END OF class CStringSyntaxCheckerStatics
