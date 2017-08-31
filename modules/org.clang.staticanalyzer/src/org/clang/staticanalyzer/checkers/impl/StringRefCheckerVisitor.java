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
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.LLVMConventionsCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StringRefCheckerVisitor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 117,
 FQN="(anonymous namespace)::StringRefCheckerVisitor", NM="_ZN12_GLOBAL__N_123StringRefCheckerVisitorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_123StringRefCheckerVisitorE")
//</editor-fold>
public class StringRefCheckerVisitor implements /*public*/ StmtVisitorVoid<StringRefCheckerVisitor> {
  private /*const*/ Decl /*P*/ DeclWithIssue;
  private final BugReporter /*&*/ BR;
  private /*const*/ CheckerBase /*P*/ Checker;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StringRefCheckerVisitor::StringRefCheckerVisitor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 123,
   FQN="(anonymous namespace)::StringRefCheckerVisitor::StringRefCheckerVisitor", NM="_ZN12_GLOBAL__N_123StringRefCheckerVisitorC1EPKN5clang4DeclERNS1_4ento11BugReporterEPKNS5_11CheckerBaseE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_123StringRefCheckerVisitorC1EPKN5clang4DeclERNS1_4ento11BugReporterEPKNS5_11CheckerBaseE")
  //</editor-fold>
  public StringRefCheckerVisitor(/*const*/ Decl /*P*/ declWithIssue, final BugReporter /*&*/ br, 
      /*const*/ CheckerBase /*P*/ checker) {
    // : StmtVisitor<StringRefCheckerVisitor>(), DeclWithIssue(declWithIssue), BR(br), Checker(checker) 
    //START JInit
    $StmtVisitor();
    this.DeclWithIssue = declWithIssue;
    this./*&*/BR=/*&*/br;
    this.Checker = checker;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StringRefCheckerVisitor::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 126,
   FQN="(anonymous namespace)::StringRefCheckerVisitor::VisitChildren", NM="_ZN12_GLOBAL__N_123StringRefCheckerVisitor13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_123StringRefCheckerVisitor13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StringRefCheckerVisitor::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 131,
   FQN="(anonymous namespace)::StringRefCheckerVisitor::VisitStmt", NM="_ZN12_GLOBAL__N_123StringRefCheckerVisitor9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_123StringRefCheckerVisitor9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StringRefCheckerVisitor::VisitDeclStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 144,
   FQN="(anonymous namespace)::StringRefCheckerVisitor::VisitDeclStmt", NM="_ZN12_GLOBAL__N_123StringRefCheckerVisitor13VisitDeclStmtEPN5clang8DeclStmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_123StringRefCheckerVisitor13VisitDeclStmtEPN5clang8DeclStmtE")
  //</editor-fold>
  public void VisitDeclStmt(DeclStmt /*P*/ S) {
    VisitChildren(S);
    
    for (Decl /*P*/ I : S.decls())  {
      {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(I);
        if ((VD != null)) {
          VisitVarDecl(VD);
        }
      }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::StringRefCheckerVisitor::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp", line = 152,
   FQN="(anonymous namespace)::StringRefCheckerVisitor::VisitVarDecl", NM="_ZN12_GLOBAL__N_123StringRefCheckerVisitor12VisitVarDeclEPN5clang7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/LLVMConventionsChecker.cpp -nm=_ZN12_GLOBAL__N_123StringRefCheckerVisitor12VisitVarDeclEPN5clang7VarDeclE")
  //</editor-fold>
  private void VisitVarDecl(VarDecl /*P*/ VD) {
    Expr /*P*/ Init = VD.getInit();
    if (!(Init != null)) {
      return;
    }
    
    // Pattern match for:
    // StringRef x = call() (where call returns std::string)
    if (!IsLLVMStringRef(VD.getType())) {
      return;
    }
    ExprWithCleanups /*P*/ Ex1 = dyn_cast_ExprWithCleanups(Init);
    if (!(Ex1 != null)) {
      return;
    }
    CXXConstructExpr /*P*/ Ex2 = dyn_cast_CXXConstructExpr(Ex1.getSubExpr());
    if (!(Ex2 != null) || Ex2.getNumArgs() != 1) {
      return;
    }
    ImplicitCastExpr /*P*/ Ex3 = dyn_cast_ImplicitCastExpr(Ex2.getArg(0));
    if (!(Ex3 != null)) {
      return;
    }
    CXXConstructExpr /*P*/ Ex4 = dyn_cast_CXXConstructExpr(Ex3.getSubExpr());
    if (!(Ex4 != null) || Ex4.getNumArgs() != 1) {
      return;
    }
    ImplicitCastExpr /*P*/ Ex5 = dyn_cast_ImplicitCastExpr(Ex4.getArg(0));
    if (!(Ex5 != null)) {
      return;
    }
    CXXBindTemporaryExpr /*P*/ Ex6 = dyn_cast_CXXBindTemporaryExpr(Ex5.getSubExpr());
    if (!(Ex6 != null) || !IsStdString(Ex6.getType())) {
      return;
    }
    
    // Okay, badness!  Report an error.
    /*const*/char$ptr/*char P*/ desc = $("StringRef should not be bound to temporary std::string that it outlives");
    PathDiagnosticLocation VDLoc = PathDiagnosticLocation.createBegin(VD, BR.getSourceManager());
    BR.EmitBasicReport(DeclWithIssue, Checker, new StringRef(desc), new StringRef(/*KEEP_STR*/"LLVM Conventions"), new StringRef(desc), 
        new PathDiagnosticLocation(VDLoc), new ArrayRef<SourceRange>(Init.getSourceRange(), false));
  }

  
  @Override public String toString() {
    return "" + "DeclWithIssue=" + DeclWithIssue // NOI18N
              + ", BR=" + BR // NOI18N
              + ", Checker=" + Checker // NOI18N
              + super.toString(); // NOI18N
  }
}
