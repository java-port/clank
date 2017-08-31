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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.staticanalyzer.java.CheckBase;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastToStructChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp", line = 26,
 FQN="(anonymous namespace)::CastToStructChecker", NM="_ZN12_GLOBAL__N_119CastToStructCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp -nm=_ZN12_GLOBAL__N_119CastToStructCheckerE")
//</editor-fold>
public class CastToStructChecker extends /*public*/ Checker/*T<PreStmt<CastExpr> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastToStructChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp", line = 34,
   FQN="(anonymous namespace)::CastToStructChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119CastToStructChecker12checkPreStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp -nm=_ZNK12_GLOBAL__N_119CastToStructChecker12checkPreStmtEPKN5clang8CastExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CastExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ Expr /*P*/ E = CE.getSubExpr$Const();
    final ASTContext /*&*/ Ctx = C.getASTContext();
    QualType OrigTy = Ctx.getCanonicalType(E.getType()).$QualType();
    QualType ToTy = Ctx.getCanonicalType(CE.getType()).$QualType();
    
    /*const*/ PointerType /*P*/ OrigPTy = dyn_cast_PointerType(OrigTy.getTypePtr());
    /*const*/ PointerType /*P*/ ToPTy = dyn_cast_PointerType(ToTy.getTypePtr());
    if (!(ToPTy != null) || !(OrigPTy != null)) {
      return;
    }
    
    QualType OrigPointeeTy = OrigPTy.getPointeeType();
    QualType ToPointeeTy = ToPTy.getPointeeType();
    if (!ToPointeeTy.$arrow().isStructureOrClassType()) {
      return;
    }
    
    // We allow cast from void*.
    if (OrigPointeeTy.$arrow().isVoidType()) {
      return;
    }
    
    // Now the cast-to-type is struct pointer, the original type is not void*.
    if (!OrigPointeeTy.$arrow().isRecordType()) {
      {
        ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
        if ((N != null)) {
          unique_ptr<BugReport> R = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (!BT.$bool()) {
              BT.reset(new BuiltinBug(this, $("Cast from non-struct type to struct type"), 
                      $("Casting a non-structure type to a structure type and accessing a field can lead to memory access errors or data corruption.")));
            }
            R = llvm.make_unique(new BugReport(BT.$star(), BT.$arrow().getDescription(), N));
            R.$arrow().addRange(CE.getSourceRange());
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(R)))); $c$.clean();
          } finally {
            if (R != null) { R.$destroy(); }
            $c$.$destroy();
          }
        }
      }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastToStructChecker::~CastToStructChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp", line = 26,
   FQN="(anonymous namespace)::CastToStructChecker::~CastToStructChecker", NM="_ZN12_GLOBAL__N_119CastToStructCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp -nm=_ZN12_GLOBAL__N_119CastToStructCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CastToStructChecker::CastToStructChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp", line = 26,
   FQN="(anonymous namespace)::CastToStructChecker::CastToStructChecker", NM="_ZN12_GLOBAL__N_119CastToStructCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/CastToStructChecker.cpp -nm=_ZN12_GLOBAL__N_119CastToStructCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ CastToStructChecker() {
    // : Checker<PreStmt<CastExpr> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $checkPreStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof CastExpr) { checkPreStmt((CastExpr) stmt, C); } }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CastExpr>(CastExpr.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
