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

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRetainReleaseChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 529,
 FQN="(anonymous namespace)::CFRetainReleaseChecker", NM="_ZN12_GLOBAL__N_122CFRetainReleaseCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_122CFRetainReleaseCheckerE")
//</editor-fold>
public class CFRetainReleaseChecker extends /*public*/ Checker/*T<org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<APIMisuse> BT;
  private /*mutable */IdentifierInfo /*P*/ Retain;
  private /*mutable */IdentifierInfo /*P*/ Release;
  private /*mutable */IdentifierInfo /*P*/ MakeCollectable;
  private /*mutable */IdentifierInfo /*P*/ Autorelease;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRetainReleaseChecker::CFRetainReleaseChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 534,
   FQN="(anonymous namespace)::CFRetainReleaseChecker::CFRetainReleaseChecker", NM="_ZN12_GLOBAL__N_122CFRetainReleaseCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_122CFRetainReleaseCheckerC1Ev")
  //</editor-fold>
  public CFRetainReleaseChecker() {
    // : Checker<PreStmt<CallExpr> >(), BT(), Retain(null), Release(null), MakeCollectable(null), Autorelease(null) 
    //START JInit
    super();
    this.BT = new std.unique_ptr<APIMisuse>();
    this.Retain = null;
    this.Release = null;
    this.MakeCollectable = null;
    this.Autorelease = null;
    //END JInit
  }

  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRetainReleaseChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 541,
   FQN="(anonymous namespace)::CFRetainReleaseChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_122CFRetainReleaseChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZNK12_GLOBAL__N_122CFRetainReleaseChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateTrue = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> stateFalse = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If the CallExpr doesn't have exactly 1 argument just give up checking.
      if (CE.getNumArgs() != 1) {
        return;
      }
      
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
      if (!(FD != null)) {
        return;
      }
      if (!BT.$bool()) {
        final ASTContext /*&*/ Ctx = C.getASTContext();
        Retain = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFRetain")));
        Release = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFRelease")));
        MakeCollectable = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFMakeCollectable")));
        Autorelease = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"CFAutorelease")));
        BT.reset(new APIMisuse(this, $("null passed to CF memory management function")));
      }
      
      // Check if we called CFRetain/CFRelease/CFMakeCollectable/CFAutorelease.
      /*const*/ IdentifierInfo /*P*/ FuncII = FD.getIdentifier();
      if (!(FuncII == Retain || FuncII == Release || FuncII == MakeCollectable
         || FuncII == Autorelease)) {
        return;
      }
      
      // FIXME: The rest of this just checks that the argument is non-null.
      // It should probably be refactored and combined with NonNullParamChecker.
      
      // Get the argument's value.
      /*const*/ Expr /*P*/ Arg = CE.getArg$Const(0);
      SVal ArgVal = state.$arrow().getSVal(Arg, C.getLocationContext());
      Optional<DefinedSVal> DefArgVal = ArgVal.getAs(DefinedSVal.class);
      if (!DefArgVal.$bool()) {
        return;
      }
      
      // Get a NULL value.
      final SValBuilder /*&*/ svalBuilder = C.getSValBuilder();
      DefinedSVal zero = svalBuilder.makeZeroVal(Arg.getType()).castAs(DefinedSVal.class);
      
      // Make an expression asserting that they're equal.
      DefinedOrUnknownSVal ArgIsNull = $c$.clean(svalBuilder.evalEQ($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), new DefinedOrUnknownSVal(zero), new DefinedOrUnknownSVal(DefArgVal.$star())));
      
      // Are they equal?
      stateTrue/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      stateFalse/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(stateTrue, stateFalse).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(ArgIsNull)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(ArgIsNull)));
      stateTrue.$assign($assume.first);
      stateFalse.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      if (stateTrue.$bool() && !stateFalse.$bool()) {
        unique_ptr<BugReport> report = null;
        try {
          ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateTrue))));
          if (!(N != null)) {
            return;
          }
          
          /*const*/char$ptr/*char P*/ description = create_char$ptr();
          if (FuncII == Retain) {
            description = $tryClone($("Null pointer argument in call to CFRetain"));
          } else if (FuncII == Release) {
            description = $tryClone($("Null pointer argument in call to CFRelease"));
          } else if (FuncII == MakeCollectable) {
            description = $tryClone($("Null pointer argument in call to CFMakeCollectable"));
          } else if (FuncII == Autorelease) {
            description = $tryClone($("Null pointer argument in call to CFAutorelease"));
          } else {
            throw new llvm_unreachable("impossible case");
          }
          
          report = llvm.make_unique(new BugReport(BT.$star(), new StringRef(description), N));
          report.$arrow().addRange(Arg.getSourceRange());
          NsBugreporter.trackNullOrUndefValue(N, Arg, report.$star());
          C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
          return;
        } finally {
          if (report != null) { report.$destroy(); }
        }
      }
      
      // From here on, we know the argument is non-null.
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(stateFalse))));
    } finally {
      if (stateFalse != null) { stateFalse.$destroy(); }
      if (stateTrue != null) { stateTrue.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CFRetainReleaseChecker::~CFRetainReleaseChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp", line = 529,
   FQN="(anonymous namespace)::CFRetainReleaseChecker::~CFRetainReleaseChecker", NM="_ZN12_GLOBAL__N_122CFRetainReleaseCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/BasicObjCFoundationChecks.cpp -nm=_ZN12_GLOBAL__N_122CFRetainReleaseCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override public void $checkPreStmt(Stmt stmt, CheckerContext C) { if (stmt instanceof CallExpr) { checkPreStmt((CallExpr) stmt, C); } }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
  };

  @Override protected CheckBase[] $getChecks() { return $CHECKS; }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", Retain=" + Retain // NOI18N
              + ", Release=" + Release // NOI18N
              + ", MakeCollectable=" + MakeCollectable // NOI18N
              + ", Autorelease=" + Autorelease // NOI18N
              + super.toString(); // NOI18N
  }
}
