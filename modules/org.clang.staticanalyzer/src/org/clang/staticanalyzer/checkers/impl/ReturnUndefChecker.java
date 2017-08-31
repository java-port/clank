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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.analysis.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;
import static org.clang.staticanalyzer.checkers.impl.ReturnUndefCheckerStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnUndefChecker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 27,
 FQN="(anonymous namespace)::ReturnUndefChecker", NM="_ZN12_GLOBAL__N_118ReturnUndefCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZN12_GLOBAL__N_118ReturnUndefCheckerE")
//</editor-fold>
public class ReturnUndefChecker extends /*public*/ Checker/*T<PreStmt<ReturnStmt> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT_Undef;
  private /*mutable */std.unique_ptr<BuiltinBug> BT_NullReference;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnUndefChecker::emitUndef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 95,
   FQN="(anonymous namespace)::ReturnUndefChecker::emitUndef", NM="_ZNK12_GLOBAL__N_118ReturnUndefChecker9emitUndefERN5clang4ento14CheckerContextEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZNK12_GLOBAL__N_118ReturnUndefChecker9emitUndefERN5clang4ento14CheckerContextEPKNS1_4ExprE")
  //</editor-fold>
  private void emitUndef(final CheckerContext /*&*/ C, /*const*/ Expr /*P*/ RetE) /*const*/ {
    if (!BT_Undef.$bool()) {
      BT_Undef.reset(new BuiltinBug(this, $("Garbage return value"), 
              $("Undefined or garbage value returned to caller")));
    }
    emitBug(C, BT_Undef.$star(), RetE);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnUndefChecker::checkReference">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 103,
   FQN="(anonymous namespace)::ReturnUndefChecker::checkReference", NM="_ZNK12_GLOBAL__N_118ReturnUndefChecker14checkReferenceERN5clang4ento14CheckerContextEPKNS1_4ExprENS2_20DefinedOrUnknownSValE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZNK12_GLOBAL__N_118ReturnUndefChecker14checkReferenceERN5clang4ento14CheckerContextEPKNS1_4ExprENS2_20DefinedOrUnknownSValE")
  //</editor-fold>
  private void checkReference(final CheckerContext /*&*/ C, /*const*/ Expr /*P*/ RetE, 
                DefinedOrUnknownSVal RetVal) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> StNonNull = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> StNull = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      StNonNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      StNull/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(StNonNull, StNull).$assign($c$.track(C.getState().$arrow().assume(new DefinedOrUnknownSVal(RetVal)))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(C.getState().$arrow().assume(new DefinedOrUnknownSVal(RetVal)));
      StNonNull.$assign($assume.first);
      StNull.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();

      if (StNonNull.$bool()) {
        // Going forward, assume the location is non-null.
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(StNonNull))));
        return;
      }
      
      // The return value is known to be null. Emit a bug report.
      if (!BT_NullReference.$bool()) {
        BT_NullReference.reset(new BuiltinBug(this, $("Returning null reference")));
      }
      
      ReturnUndefCheckerStatics.emitBug(C, BT_NullReference.$star(), RetE, NsBugreporter.getDerefExpr(RetE));
    } finally {
      if (StNull != null) { StNull.$destroy(); }
      if (StNonNull != null) { StNonNull.$destroy(); }
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnUndefChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 39,
   FQN="(anonymous namespace)::ReturnUndefChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_118ReturnUndefChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZNK12_GLOBAL__N_118ReturnUndefChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ RS, 
              final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ Expr /*P*/ RetE = RS.getRetValue$Const();
    if (!(RetE != null)) {
      return;
    }
    SVal RetVal = C.getSVal(RetE);
    
    /*const*/ StackFrameContext /*P*/ SFC = C.getStackFrame();
    QualType RT = CallEvent.getDeclaredResultType(SFC.getDecl());
    if (RetVal.isUndef$SVal()) {
      // "return;" is modeled to evaluate to an UndefinedVal. Allow UndefinedVal
      // to be returned in functions returning void to support this pattern:
      //   void foo() {
      //     return;
      //   }
      //   void test() {
      //     return foo();
      //   }
      if (!RT.isNull() && RT.$arrow().isVoidType()) {
        return;
      }
      
      // Not all blocks have explicitly-specified return types; if the return type
      // is not available, but the return value expression has 'void' type, assume
      // Sema already checked it.
      if (RT.isNull() && isa_BlockDecl(SFC.getDecl())
         && RetE.getType().$arrow().isVoidType()) {
        return;
      }
      
      emitUndef(C, RetE);
      return;
    }
    if (RT.isNull()) {
      return;
    }
    if (RT.$arrow().isReferenceType()) {
      checkReference(C, RetE, RetVal.castAs(DefinedOrUnknownSVal.class));
      return;
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnUndefChecker::~ReturnUndefChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ReturnUndefChecker::~ReturnUndefChecker", NM="_ZN12_GLOBAL__N_118ReturnUndefCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZN12_GLOBAL__N_118ReturnUndefCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT_NullReference.$destroy();
    BT_Undef.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ReturnUndefChecker::ReturnUndefChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp", line = 27,
   FQN="(anonymous namespace)::ReturnUndefChecker::ReturnUndefChecker", NM="_ZN12_GLOBAL__N_118ReturnUndefCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/ReturnUndefChecker.cpp -nm=_ZN12_GLOBAL__N_118ReturnUndefCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ ReturnUndefChecker() {
    // : Checker<PreStmt<ReturnStmt> >(), BT_Undef(), BT_NullReference() 
    //START JInit
    super();
    this.BT_Undef = new std.unique_ptr<BuiltinBug>();
    this.BT_NullReference = new std.unique_ptr<BuiltinBug>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof ReturnStmt) {
      checkPreStmt((ReturnStmt) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT_Undef=" + BT_Undef // NOI18N
              + ", BT_NullReference=" + BT_NullReference // NOI18N
              + super.toString(); // NOI18N
  }
}
