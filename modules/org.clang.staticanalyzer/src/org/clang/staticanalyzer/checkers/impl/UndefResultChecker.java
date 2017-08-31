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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefResultChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp", line = 28,
 FQN="(anonymous namespace)::UndefResultChecker", NM="_ZN12_GLOBAL__N_118UndefResultCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefResultCheckerE")
//</editor-fold>
public class UndefResultChecker extends /*public*/ Checker/*T<PostStmt<BinaryOperator> > */
        implements org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
  
  private /*mutable */std.unique_ptr<BugType> BT;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefResultChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp", line = 38,
   FQN="(anonymous namespace)::UndefResultChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_118UndefResultChecker13checkPostStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp -nm=_ZNK12_GLOBAL__N_118UndefResultChecker13checkPostStmtEPKN5clang14BinaryOperatorERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ BinaryOperator /*P*/ B, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ LocationContext /*P*/ LCtx = C.getLocationContext();
      if (state.$arrow().getSVal(B, LCtx).isUndef$SVal()) {
        raw_svector_ostream OS = null;
        unique_ptr<BugReport> report = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          {

            // Do not report assignments of uninitialized values inside swap functions.
            // This should allow to swap partially uninitialized structs
            // (radar://14129997)
            /*const*/ FunctionDecl /*P*/ EnclosingFunctionDecl = dyn_cast_FunctionDecl(C.getStackFrame().getDecl());
            if ((EnclosingFunctionDecl != null)) {
              if ($eq_StringRef(C.getCalleeName(EnclosingFunctionDecl), /*STRINGREF_STR*/"swap")) {
                return;
              }
            }
          }

          // Generate an error node.
          ExplodedNode /*P*/ N = C.generateErrorNode();
          if (!(N != null)) {
            return;
          }
          if (!BT.$bool()) {
            BT.reset(new BuiltinBug(this, $("Result of operation is garbage or undefined")));
          }

          SmallString/*<256>*/ sbuf/*J*/= new SmallString/*<256>*/(256);
          OS/*J*/= new raw_svector_ostream(sbuf);
          /*const*/ Expr /*P*/ Ex = null;
          boolean isLeft = true;
          if (state.$arrow().getSVal(B.getLHS(), LCtx).isUndef$SVal()) {
            Ex = B.getLHS().IgnoreParenCasts();
            isLeft = true;
          } else if (state.$arrow().getSVal(B.getRHS(), LCtx).isUndef$SVal()) {
            Ex = B.getRHS().IgnoreParenCasts();
            isLeft = false;
          }
          if ((Ex != null)) {
            OS.$out(/*KEEP_STR*/"The ").$out((isLeft ? $("left") : $("right"))).$out(
                /*KEEP_STR*/" operand of '"
            ).$out(
                BinaryOperator.getOpcodeStr(B.getOpcode())
            ).$out(
                /*KEEP_STR*/"' is a garbage value"
            );
          } else {
            // Neither operand was undefined, but the result is undefined.
            OS.$out(/*KEEP_STR*/"The result of the '").$out(
                BinaryOperator.getOpcodeStr(B.getOpcode())
            ).$out(
                /*KEEP_STR*/"' expression is undefined"
            );
          }
          report = llvm.make_unique(new BugReport(BT.$star(), OS.str(), N));
          if ((Ex != null)) {
            report.$arrow().addRange(Ex.getSourceRange());
            NsBugreporter.trackNullOrUndefValue(N, Ex, report.$star());
          } else {
            NsBugreporter.trackNullOrUndefValue(N, B, report.$star());
          }

          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
        } finally {
          if (report != null) { report.$destroy(); }
          if (OS != null) { OS.$destroy(); }
          $c$.$destroy();
        }
      }
    } finally {
     if (state != null) { state.$destroy(); }
    } 
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefResultChecker::~UndefResultChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp", line = 28,
   FQN="(anonymous namespace)::UndefResultChecker::~UndefResultChecker", NM="_ZN12_GLOBAL__N_118UndefResultCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefResultCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::UndefResultChecker::UndefResultChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp", line = 28,
   FQN="(anonymous namespace)::UndefResultChecker::UndefResultChecker", NM="_ZN12_GLOBAL__N_118UndefResultCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/UndefResultChecker.cpp -nm=_ZN12_GLOBAL__N_118UndefResultCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ UndefResultChecker() {
    // : Checker<PostStmt<BinaryOperator> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof BinaryOperator) {
      checkPostStmt((BinaryOperator) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<BinaryOperator>(BinaryOperator.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + super.toString(); // NOI18N
  }
}
