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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.staticanalyzer.checkers.impl.ChrootCheckerStatics.*;
import org.clang.staticanalyzer.java.CheckBase;

//bool isJailEntered(intptr_t k) { return k == JAIL_ENTERED; }

// This checker checks improper use of chroot.
// The state transition:
// NO_CHROOT ---chroot(path)--> ROOT_CHANGED ---chdir(/) --> JAIL_ENTERED
//                                  |                               |
//         ROOT_CHANGED<--chdir(..)--      JAIL_ENTERED<--chdir(..)--
//                                  |                               |
//                      bug<--foo()--          JAIL_ENTERED<--foo()--
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 42,
 FQN="(anonymous namespace)::ChrootChecker", NM="_ZN12_GLOBAL__N_113ChrootCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN12_GLOBAL__N_113ChrootCheckerE")
//</editor-fold>
public class ChrootChecker extends /*public*/ Checker/*<eval.Call, PreStmt<CallExpr> > */
        implements org.clang.staticanalyzer.java.EvalCallChecker, org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */IdentifierInfo /*P*/ II_chroot;
  private /*mutable */IdentifierInfo /*P*/ II_chdir;
  // This bug refers to possibly break out of a chroot() jail.
  private /*mutable */std.unique_ptr<BuiltinBug> BT_BreakJail;
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::ChrootChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 48,
   FQN="(anonymous namespace)::ChrootChecker::ChrootChecker", NM="_ZN12_GLOBAL__N_113ChrootCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN12_GLOBAL__N_113ChrootCheckerC1Ev")
  //</editor-fold>
  public ChrootChecker() {
    // : Checker<eval::Call, PreStmt<CallExpr> >(), II_chroot(null), II_chdir(null), BT_BreakJail() 
    //START JInit
    super();
    this.II_chroot = null;
    this.II_chdir = null;
    this.BT_BreakJail = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 50,
   FQN="(anonymous namespace)::ChrootChecker::getTag", NM="_ZN12_GLOBAL__N_113ChrootChecker6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN12_GLOBAL__N_113ChrootChecker6getTagEv")
  //</editor-fold>
  public static Object/*void P*/ getTag() {
    final/*static*/ Object x = getTag$$.x;
    return $AddrOf(x);
  }
  private static final class getTag$$ {
    static final/*static*/ Object x = ChrootChecker.class;
  }

  
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::evalCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 65,
   FQN="(anonymous namespace)::ChrootChecker::evalCall", NM="_ZNK12_GLOBAL__N_113ChrootChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZNK12_GLOBAL__N_113ChrootChecker8evalCallEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public boolean evalCall(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
    if (!(FD != null)) {
      return false;
    }
    
    final ASTContext /*&*/ Ctx = C.getASTContext();
    if (!(II_chroot != null)) {
      II_chroot = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"chroot")));
    }
    if (!(II_chdir != null)) {
      II_chdir = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"chdir")));
    }
    if (FD.getIdentifier() == II_chroot) {
      Chroot(C, CE);
      return true;
    }
    if (FD.getIdentifier() == II_chdir) {
      Chdir(C, CE);
      return true;
    }
    
    return false;
  }


  // Check the jail state before any function call except chroot and chdir().
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 125,
   FQN="(anonymous namespace)::ChrootChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_113ChrootChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZNK12_GLOBAL__N_113ChrootChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FD = C.getCalleeDecl(CE);
    if (!(FD != null)) {
      return;
    }
    
    final ASTContext /*&*/ Ctx = C.getASTContext();
    if (!(II_chroot != null)) {
      II_chroot = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"chroot")));
    }
    if (!(II_chdir != null)) {
      II_chdir = $AddrOf(Ctx.Idents.get(new StringRef(/*KEEP_STR*/"chdir")));
    }
    
    // Ingnore chroot and chdir.
    if (FD.getIdentifier() == II_chroot || FD.getIdentifier() == II_chdir) {
      return;
    }
    
    // If jail state is ROOT_CHANGED, generate BugReport.
    type$ptr<Object>/*void P const P*/ k = $tryClone(C.getState().$arrow().FindGDM(ChrootChecker.getTag()));
    if (Native.$bool(k)) {
      if (ChrootCheckerStatics.isRootChanged((Object/*intptr_t*/)k.$star())) {
        {
          ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
          if ((N != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              if (!BT_BreakJail.$bool()) {
                BT_BreakJail.reset(new BuiltinBug(this, $("Break out of jail"), $("No call of chdir(\"/\") immediately after chroot")));
              }
              C.emitReport($c$.track(llvm.make_unique(new BugReport(BT_BreakJail.$star(), BT_BreakJail.$arrow().getDescription(), N)))); $c$.clean();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }

/*private:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::Chroot">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 88,
   FQN="(anonymous namespace)::ChrootChecker::Chroot", NM="_ZNK12_GLOBAL__N_113ChrootChecker6ChrootERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZNK12_GLOBAL__N_113ChrootChecker6ChrootERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Chroot(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      final ProgramStateManager /*&*/ Mgr = state.$arrow().getStateManager();
      
      // Once encouter a chroot(), set the enum value ROOT_CHANGED directly in
      // the GDM.
      $c$.clean(state.$assign($c$.track(Mgr.addGDM($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), ChrootChecker.getTag(), ((Object/*void P*/ )Kind.ROOT_CHANGED.getValue())))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::Chdir">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 98,
   FQN="(anonymous namespace)::ChrootChecker::Chdir", NM="_ZNK12_GLOBAL__N_113ChrootChecker5ChdirERN5clang4ento14CheckerContextEPKNS1_8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZNK12_GLOBAL__N_113ChrootChecker5ChdirERN5clang4ento14CheckerContextEPKNS1_8CallExprE")
  //</editor-fold>
  private void Chdir(final CheckerContext /*&*/ C, /*const*/ CallExpr /*P*/ CE) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      final ProgramStateManager /*&*/ Mgr = state.$arrow().getStateManager();
      
      // If there are no jail state in the GDM, just return.
      /*const*/Object/*void P*/ k = $tryClone(state.$arrow().FindGDM(ChrootChecker.getTag()));
      if (!(k != null)) {
        return;
      }
      
      // After chdir("/"), enter the jail, set the enum value JAIL_ENTERED.
      /*const*/ Expr /*P*/ ArgExpr = CE.getArg$Const(0);
      SVal ArgVal = state.$arrow().getSVal(ArgExpr, C.getLocationContext());
      {
        
        /*const*/ MemRegion /*P*/ R = ArgVal.getAsRegion();
        if ((R != null)) {
          R = R.StripCasts();
          {
            /*const*/ StringRegion /*P*/ StrRegion = dyn_cast_StringRegion(R);
            if ((StrRegion != null)) {
              /*const*/ StringLiteral /*P*/ Str = StrRegion.getStringLiteral();
              if ($eq_StringRef(Str.getString(), /*STRINGREF_STR*/"/")) {
                $c$.clean(state.$assign($c$.track(Mgr.addGDM($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state)), ChrootChecker.getTag(), 
                        ((Object/*void P*/ )Kind.JAIL_ENTERED.getValue())))));
              }
            }
          }
        }
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(state))));
    } finally {
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ChrootChecker::~ChrootChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp", line = 42,
   FQN="(anonymous namespace)::ChrootChecker::~ChrootChecker", NM="_ZN12_GLOBAL__N_113ChrootCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ChrootChecker.cpp -nm=_ZN12_GLOBAL__N_113ChrootCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_BreakJail.$destroy();
    super.$destroy();
    //END JDestroy
   }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new eval.Call(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "II_chroot=" + II_chroot // NOI18N
              + ", II_chdir=" + II_chdir // NOI18N
              + ", BT_BreakJail=" + BT_BreakJail // NOI18N
              + super.toString(); // NOI18N
  }
}
