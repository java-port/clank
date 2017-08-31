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
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCAtSyncChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp", line = 27,
 FQN="(anonymous namespace)::ObjCAtSyncChecker", NM="_ZN12_GLOBAL__N_117ObjCAtSyncCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp -nm=_ZN12_GLOBAL__N_117ObjCAtSyncCheckerE")
//</editor-fold>
public class ObjCAtSyncChecker extends /*public*/ Checker/*T<PreStmt<ObjCAtSynchronizedStmt> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT_null;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_undef;
/*public:*/
  // end anonymous namespace
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCAtSyncChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp", line = 37,
   FQN="(anonymous namespace)::ObjCAtSyncChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_117ObjCAtSyncChecker12checkPreStmtEPKN5clang22ObjCAtSynchronizedStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp -nm=_ZNK12_GLOBAL__N_117ObjCAtSyncChecker12checkPreStmtEPKN5clang22ObjCAtSynchronizedStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ObjCAtSynchronizedStmt /*P*/ S, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> state = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> notNullState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> nullState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      
      /*const*/ Expr /*P*/ Ex = S.getSynchExpr$Const();
      state = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal V = state.$arrow().getSVal(Ex, C.getLocationContext());
      
      // Uninitialized value used for the mutex?
      if (V.getAs(UndefinedVal.class).$bool()) {
        {
          ExplodedNode /*P*/ N = C.generateErrorNode();
          if ((N != null)) {
            unique_ptr<BugReport> report = null;
            try {
              if (!BT_undef.$bool()) {
                BT_undef.reset(new BuiltinBug(this, $("Uninitialized value used as mutex for @synchronized")));
              }
              report = llvm.make_unique(new BugReport(BT_undef.$star(), BT_undef.$arrow().getDescription(), N));
              NsBugreporter.trackNullOrUndefValue(N, Ex, report.$star());
              C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
            } finally {
              if (report != null) { report.$destroy(); }
            }
          }
        }
        return;
      }
      if (V.isUnknown$SVal()) {
        return;
      }
      
      // Check for null mutexes.
      notNullState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      nullState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(notNullState, nullState).$assign($c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(JD$Move.INSTANCE, V.castAs(DefinedSVal.class))))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(state.$arrow().assume(new DefinedOrUnknownSVal(JD$Move.INSTANCE, V.castAs(DefinedSVal.class))));
      notNullState.$assign($assume.first);
      nullState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();

      if (nullState.$bool()) {
        if (!notNullState.$bool()) {
          {
            // Generate an error node.  This isn't a sink since
            // a null mutex just means no synchronization occurs.
            ExplodedNode /*P*/ N = $c$.clean(C.generateNonFatalErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(nullState))));
            if ((N != null)) {
              unique_ptr<BugReport> report = null;
              try {
                if (!BT_null.$bool()) {
                  BT_null.reset(new BuiltinBug(this, $("Nil value used as mutex for @synchronized() (no synchronization will occur)")));
                }
                report = llvm.make_unique(new BugReport(BT_null.$star(), BT_null.$arrow().getDescription(), N));
                NsBugreporter.trackNullOrUndefValue(N, Ex, report.$star());
                
                C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
                return;
              } finally {
                if (report != null) { report.$destroy(); }
              }
            }
          }
        }
        // Don't add a transition for 'nullState'.  If the value is
        // under-constrained to be null or non-null, assume it is non-null
        // afterwards.
      }
      if (notNullState.$bool()) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(notNullState))));
      }
    } finally {
      if (nullState != null) { nullState.$destroy(); }
      if (notNullState != null) { notNullState.$destroy(); }
      if (state != null) { state.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCAtSyncChecker::~ObjCAtSyncChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ObjCAtSyncChecker::~ObjCAtSyncChecker", NM="_ZN12_GLOBAL__N_117ObjCAtSyncCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp -nm=_ZN12_GLOBAL__N_117ObjCAtSyncCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_undef.$destroy();
    BT_null.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ObjCAtSyncChecker::ObjCAtSyncChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ObjCAtSyncChecker::ObjCAtSyncChecker", NM="_ZN12_GLOBAL__N_117ObjCAtSyncCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ObjCAtSyncChecker.cpp -nm=_ZN12_GLOBAL__N_117ObjCAtSyncCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ ObjCAtSyncChecker() {
    // : Checker<PreStmt<ObjCAtSynchronizedStmt> >(), BT_null(), BT_undef() 
    //START JInit
    super();
    this.BT_null = new std.unique_ptr<BuiltinBug>();
    this.BT_undef = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ObjCAtSynchronizedStmt) {
      checkPreStmt((ObjCAtSynchronizedStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ObjCAtSynchronizedStmt>(ObjCAtSynchronizedStmt.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_null=" + BT_null // NOI18N
              + ", BT_undef=" + BT_undef // NOI18N
              + super.toString(); // NOI18N
  }
}
