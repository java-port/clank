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
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.ento.check.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import static org.clang.staticanalyzer.checkers.ento.EntoGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 45,
 FQN="(anonymous namespace)::VforkChecker", NM="_ZN12_GLOBAL__N_112VforkCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZN12_GLOBAL__N_112VforkCheckerE")
//</editor-fold>
public class VforkChecker extends /*public*/ Checker/*<PreCall, PostCall, Bind, PreStmt<ReturnStmt> >*/ 
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PreCallChecker, org.clang.staticanalyzer.java.PostCallChecker, org.clang.staticanalyzer.java.BindChecker, Destructors.ClassWithDestructor {
  private /*mutable */std.unique_ptr<BuiltinBug> BT;
  private /*mutable */SmallSetT$PLess$T$P</*const*/ IdentifierInfo /*P*/ > VforkWhitelist;
  private /*mutable *//*const*/ IdentifierInfo /*P*/ II_vfork;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::isChildProcess">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 79,
   FQN="(anonymous namespace)::VforkChecker::isChildProcess", NM="_ZN12_GLOBAL__N_112VforkChecker14isChildProcessEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZN12_GLOBAL__N_112VforkChecker14isChildProcessEN4llvm18IntrusiveRefCntPtrIKN5clang4ento12ProgramStateEEE")
  //</editor-fold>
  private static boolean isChildProcess(/*const*/ IntrusiveRefCntPtr</*const*/ ProgramState> State) {
    return State.$arrow()./*<VforkResultRegion>*/get(ProgramStateTraitVforkResultRegion.$Instance) != null;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::isVforkCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 83,
   FQN="(anonymous namespace)::VforkChecker::isVforkCall", NM="_ZNK12_GLOBAL__N_112VforkChecker11isVforkCallEPKN5clang4DeclERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker11isVforkCallEPKN5clang4DeclERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean isVforkCall(/*const*/ Decl /*P*/ D, final CheckerContext /*&*/ C) /*const*/ {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(D);
    if (!(FD != null) || !C.isCLibraryFunction(FD)) {
      return false;
    }
    if (!(II_vfork != null)) {
      final ASTContext /*&*/ AC = C.getASTContext();
      II_vfork = $AddrOf(AC.Idents.get(new StringRef(/*KEEP_STR*/"vfork")));
    }
    
    return FD.getIdentifier() == II_vfork;
  }

  
  // Returns true iff ok to call function after successful vfork.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::isCallWhitelisted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 97,
   FQN="(anonymous namespace)::VforkChecker::isCallWhitelisted", NM="_ZNK12_GLOBAL__N_112VforkChecker17isCallWhitelistedEPKN5clang14IdentifierInfoERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker17isCallWhitelistedEPKN5clang14IdentifierInfoERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean isCallWhitelisted(/*const*/ IdentifierInfo /*P*/ II, 
                   final CheckerContext /*&*/ C) /*const*/ {
    if (VforkWhitelist.empty()) {
      // According to manpage.
      type$ptr</*const*/char$ptr/*char P*/ /*[9]*/> ids = create_type$ptr(new /*const*/char$ptr/*char P*/  [/*9*/] {
        $("_exit"), 
        $("_Exit"), 
        $("execl"), 
        $("execlp"), 
        $("execle"), 
        $("execv"), 
        $("execvp"), 
        $("execvpe"), 
        null
      });
      
      final ASTContext /*&*/ AC = C.getASTContext();
      for (/*const*/type$ptr<char$ptr>/*char PP*/ id = $tryClone(ids); Native.$bool(id.$star()); id.$preInc())  {
        VforkWhitelist.insert($AddrOf(AC.Idents.get(new StringRef(id.$star()))));
      }
    }
    
    return (VforkWhitelist.count(II) != 0);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::reportBug">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 121,
   FQN="(anonymous namespace)::VforkChecker::reportBug", NM="_ZNK12_GLOBAL__N_112VforkChecker9reportBugEPKcRN5clang4ento14CheckerContextES2_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker9reportBugEPKcRN5clang4ento14CheckerContextES2_")
  //</editor-fold>
  private void reportBug(/*const*/char$ptr/*char P*/ What, final CheckerContext /*&*/ C) /*const*/ {
    reportBug(What, C, 
           (/*const*/char$ptr/*char P*/ )null);
  }
  private void reportBug(/*const*/char$ptr/*char P*/ What, final CheckerContext /*&*/ C, 
           /*const*/char$ptr/*char P*/ Details/*= null*/) /*const*/ {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      {
        ExplodedNode /*P*/ N = $c$.clean(C.generateErrorNode($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState()))));
        if ((N != null)) {
          raw_svector_ostream os = null;
          unique_ptr<BugReport> Report = null;
          try {
            if (!BT.$bool()) {
              BT.reset(new BuiltinBug(this, 
                      $("Dangerous construct in a vforked process")));
            }
            
            SmallString/*<256>*/ buf/*J*/= new SmallString/*<256>*/(256);
            os/*J*/= new raw_svector_ostream(buf);
            
            os.$out(What).$out(/*KEEP_STR*/" is prohibited after a successful vfork");
            if (Native.$bool(Details)) {
              os.$out(/*KEEP_STR*/"; ").$out(Details);
            }
            
            Report = llvm.make_unique(new BugReport(BT.$star(), os.str(), N));
            // TODO: mark vfork call in BugReportVisitor
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(Report)))); $c$.clean();
          } finally {
            if (Report != null) { Report.$destroy(); }
            if (os != null) { os.$destroy(); }
          }
        }
      }
    } finally {
      $c$.$destroy();
    }
  }

/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::VforkChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 60,
   FQN="(anonymous namespace)::VforkChecker::VforkChecker", NM="_ZN12_GLOBAL__N_112VforkCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZN12_GLOBAL__N_112VforkCheckerC1Ev")
  //</editor-fold>
  public VforkChecker() {
    // : Checker<PreCall, PostCall, Bind, PreStmt<ReturnStmt> >(), BT(), VforkWhitelist(), II_vfork(null) 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BuiltinBug>();
    this.VforkWhitelist = new SmallSetT$PLess$T$P</*const*/ IdentifierInfo /*P*/ >(10);
    this.II_vfork = null;
    //END JInit
  }

  
  
  // Prohibit calls to non-whitelist functions in child process.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::checkPreCall">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 183,
   FQN="(anonymous namespace)::VforkChecker::checkPreCall", NM="_ZNK12_GLOBAL__N_112VforkChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker12checkPreCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPreCall(final /*const*/ CallEvent /*&*/ Call, 
              final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(isChildProcess($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)))
         && !isCallWhitelisted(Call.getCalleeIdentifier(), C))) {
        reportBug($("This function call"), C);
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Detect calls to vfork and split execution appropriately.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::checkPostCall">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 143,
   FQN="(anonymous namespace)::VforkChecker::checkPostCall", NM="_ZNK12_GLOBAL__N_112VforkChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker13checkPostCallERKN5clang4ento9CallEventERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkPostCall(final /*const*/ CallEvent /*&*/ Call, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> ParentState = null;
    IntrusiveRefCntPtr</*const*/ ProgramState> ChildState = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We can't call vfork in child so don't bother
      // (corresponding warning has already been emitted in checkPreCall).
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(isChildProcess($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))) {
        return;
      }
      if (!isVforkCall(Call.getDecl(), C)) {
        return;
      }
      
      // Get return value of vfork.
      SVal VforkRetVal = Call.getReturnValue();
      Optional<DefinedOrUnknownSVal> DVal = VforkRetVal.getAs(DefinedOrUnknownSVal.class);
      if (!DVal.$bool()) {
        return;
      }
      
      // Get assigned variable.
      final /*const*/ ParentMap /*&*/ PM = C.getLocationContext().getParentMap();
      /*const*/ Stmt /*P*/ P = PM.getParentIgnoreParenCasts_Stmt$C$P(Call.getOriginExpr());
      /*const*/ VarDecl /*P*/ LhsDecl;
      LhsDecl = parseAssignment(P).first; // JAVA: orig code was: std.tie(LhsDecl, std.ignore).$assign(parseAssignment(P));
      // Get assigned memory region.
      final MemRegionManager /*&*/ M = C.getStoreManager().getRegionManager();
      /*const*/ MemRegion /*P*/ LhsDeclReg = (LhsDecl != null) ? M.getVarRegion(LhsDecl, C.getLocationContext()) : null; // JAVA: was: (/*const*/ MemRegion /*P*/ )((Object/*void P*/ )VFORK_RESULT_NONE);
      
      // Parent branch gets nonzero return value (according to manpage).
      ParentState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
      ChildState/*J*/= new IntrusiveRefCntPtr</*const*/ ProgramState>();
//      $c$.clean(std.tie(ParentState, ChildState).$assign($c$.track(C.getState().$arrow().assume(new DefinedOrUnknownSVal(DVal.$star())))));
      // JAVA: when unfold tie make sure returned pair is cleaned (in this case ProgramState was moved to other instances)
      std.pairTypeType<IntrusiveRefCntPtr</*const*/ ProgramState>, IntrusiveRefCntPtr</*const*/ ProgramState>> $assume = 
              $c$.track(C.getState().$arrow().assume(new DefinedOrUnknownSVal(DVal.$star())));
      ParentState.$assign($assume.first);
      ChildState.$assign($assume.second);
      assert !$assume.first.$bool();
      assert !$assume.second.$bool();
      $c$.clean();
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ParentState))));
      $c$.clean(ChildState.$assign($c$.track(ChildState.$arrow().set(ProgramStateTraitVforkResultRegion.$Instance, LhsDeclReg))));
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(ChildState))));
    } finally {
      if (ChildState != null) { ChildState.$destroy(); }
      if (ParentState != null) { ParentState.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Prohibit writes in child process (except for vfork's lhs).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::checkBind">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 192,
   FQN="(anonymous namespace)::VforkChecker::checkBind", NM="_ZNK12_GLOBAL__N_112VforkChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker9checkBindEN5clang4ento4SValES3_PKNS1_4StmtERNS2_14CheckerContextE")
  //</editor-fold>
  public void checkBind(SVal L, SVal V, /*const*/ Stmt /*P*/ S, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(!isChildProcess($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))) {
        return;
      }
      
      /*const*/ MemRegion /*P*/ VforkLhs = ((/*static_cast*//*const*/ MemRegion /*P*/ )(State.$arrow().get(ProgramStateTraitVforkResultRegion.$Instance)));
      /*const*/ MemRegion /*P*/ MR = L.getAsRegion();
      
      // Child is allowed to modify only vfork's lhs.
      if (!(MR != null) || MR == VforkLhs) {
        return;
      }
      
      reportBug($("This assignment"), C);
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  // Prohibit return from function in child process.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 210,
   FQN="(anonymous namespace)::VforkChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_112VforkChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZNK12_GLOBAL__N_112VforkChecker12checkPreStmtEPKN5clang10ReturnStmtERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ ReturnStmt /*P*/ RS, final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($c$.clean(isChildProcess($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))))) {
        reportBug($("Return"), C, $("call _exit() instead"));
      }
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::VforkChecker::~VforkChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp", line = 45,
   FQN="(anonymous namespace)::VforkChecker::~VforkChecker", NM="_ZN12_GLOBAL__N_112VforkCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/VforkChecker.cpp -nm=_ZN12_GLOBAL__N_112VforkCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    VforkWhitelist.$destroy();
    BT.$destroy();
    super.$destroy();
    //END JDestroy
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
    new PreCall(),
    new PostCall(),
    new Bind(),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<ReturnStmt>(ReturnStmt.class)
  };

  @Override
  protected CheckBase[] $getChecks() {
    return $CHECKS;
  }

  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "BT=" + BT // NOI18N
              + ", VforkWhitelist=" + VforkWhitelist // NOI18N
              + ", II_vfork=" + II_vfork // NOI18N
              + super.toString(); // NOI18N
  }
}
