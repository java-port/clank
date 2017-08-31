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
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type CheckSizeofPointerStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE; -static-type=CheckSizeofPointerStatics")
//</editor-fold>
public final class CheckSizeofPointerStatics {

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp", line = 25,
 FQN="(anonymous namespace)::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN12_GLOBAL__N_17WalkASTE")
//</editor-fold>
public static class WalkAST implements /*public*/ StmtVisitorVoid<WalkAST> {
  private final BugReporter /*&*/ BR;
  private /*const*/ CheckerBase /*P*/ Checker;
  private AnalysisDeclContext /*P*/ AC;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::WalkAST">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp", line = 31,
   FQN="(anonymous namespace)::WalkAST::WalkAST", NM="_ZN12_GLOBAL__N_17WalkASTC1ERN5clang4ento11BugReporterEPKNS2_11CheckerBaseEPNS1_19AnalysisDeclContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN12_GLOBAL__N_17WalkASTC1ERN5clang4ento11BugReporterEPKNS2_11CheckerBaseEPNS1_19AnalysisDeclContextE")
  //</editor-fold>
  public WalkAST(final BugReporter /*&*/ br, /*const*/ CheckerBase /*P*/ checker, AnalysisDeclContext /*P*/ ac) {
    // : StmtVisitor<WalkAST>(), BR(br), Checker(checker), AC(ac) 
    //START JInit
    $StmtVisitor();
    this./*&*/BR=/*&*/br;
    this.Checker = checker;
    this.AC = ac;
    //END JInit
  }

  
  // CWE-467: Use of sizeof() on a Pointer Type
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitUnaryExprOrTypeTraitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp", line = 46,
   FQN="(anonymous namespace)::WalkAST::VisitUnaryExprOrTypeTraitExpr", NM="_ZN12_GLOBAL__N_17WalkAST29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN12_GLOBAL__N_17WalkAST29VisitUnaryExprOrTypeTraitExprEPN5clang24UnaryExprOrTypeTraitExprE")
  //</editor-fold>
  public void VisitUnaryExprOrTypeTraitExpr(UnaryExprOrTypeTraitExpr /*P*/ E) {
    if (E.getKind() != UnaryExprOrTypeTrait.UETT_SizeOf) {
      return;
    }
    
    // If an explicit type is used in the code, usually the coder knows what they are
    // doing.
    if (E.isArgumentType()) {
      return;
    }
    
    QualType T = E.getTypeOfArgument();
    if (T.$arrow().isPointerType()) {
      
      // Many false positives have the form 'sizeof *p'. This is reasonable
      // because people know what they are doing when they intentionally
      // dereference the pointer.
      Expr /*P*/ ArgEx = E.getArgumentExpr();
      if (!isa_DeclRefExpr(ArgEx.IgnoreParens())) {
        return;
      }
      
      PathDiagnosticLocation ELoc = PathDiagnosticLocation.createBegin(E, BR.getSourceManager(), new PointerUnion</*const*/ LocationContext /*P*/ , AnalysisDeclContext /*P*/ >(JD$T1.INSTANCE, AnalysisDeclContext /*P*/.class, AC));
      BR.EmitBasicReport(AC.getDecl(), Checker, 
          new StringRef(/*KEEP_STR*/"Potential unintended use of sizeof() on pointer type"), 
          new StringRef(categories.LogicError), 
          new StringRef(/*KEEP_STR*/"The code calls sizeof() on a pointer type. This can produce an unexpected result."), 
          new PathDiagnosticLocation(ELoc), new ArrayRef<SourceRange>(ArgEx.getSourceRange(), false));
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp", line = 34,
   FQN="(anonymous namespace)::WalkAST::VisitStmt", NM="_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN12_GLOBAL__N_17WalkAST9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public void VisitStmt(Stmt /*P*/ S) {
    VisitChildren(S);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::WalkAST::VisitChildren">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp", line = 39,
   FQN="(anonymous namespace)::WalkAST::VisitChildren", NM="_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CheckSizeofPointer.cpp -nm=_ZN12_GLOBAL__N_17WalkAST13VisitChildrenEPN5clang4StmtE")
  //</editor-fold>
  public void VisitChildren(Stmt /*P*/ S) {
    for (Stmt /*P*/ Child : S.children())  {
      if ((Child != null)) {
        Visit(Child);
      }
    }
  }

  
  @Override public String toString() {
    return "" + "BR=" + BR // NOI18N
              + ", Checker=" + Checker // NOI18N
              + ", AC=" + "[AnalysisDeclContext]" // NOI18N
              + super.toString(); // NOI18N
  }
}
} // END OF class CheckSizeofPointerStatics
