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
import static org.clank.java.io.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.staticanalyzer.checkers.ento.impl.*;
import org.clang.staticanalyzer.core.bugreporter.ento.*;
import org.clang.staticanalyzer.core.ento.*;
import org.clang.staticanalyzer.core.pathsensitive.ento.*;
import org.clang.staticanalyzer.java.StaticAnalyzerMemberPointers.*;
import static org.clang.staticanalyzer.java.StaticanalyzerRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import org.clang.staticanalyzer.java.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 31,
 FQN="(anonymous namespace)::GenericTaintChecker", NM="_ZN12_GLOBAL__N_119GenericTaintCheckerE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintCheckerE")
//</editor-fold>
public class GenericTaintChecker extends /*public*/ Checker/*<PostStmt<CallExpr>, PreStmt<CallExpr> > */
        implements org.clang.staticanalyzer.java.PreStmtChecker, org.clang.staticanalyzer.java.PostStmtChecker, Destructors.ClassWithDestructor {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::getTag">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 34,
   FQN="(anonymous namespace)::GenericTaintChecker::getTag", NM="_ZN12_GLOBAL__N_119GenericTaintChecker6getTagEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker6getTagEv")
  //</editor-fold>
  public static Object/*void P*/ getTag() {
    final/*static*/ Object Tag = getTag$$.Tag;
    return $AddrOf(Tag);
  }
  private static final class getTag$$ {
    static final/*static*/ Object Tag = GenericTaintChecker.class;
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::checkPostStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 285,
   FQN="(anonymous namespace)::GenericTaintChecker::checkPostStmt", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker13checkPostStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPostStmt(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    if (propagateFromPre(CE, C)) {
      return;
    }
    addSourcesPost(CE, C);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::checkPreStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 275,
   FQN="(anonymous namespace)::GenericTaintChecker::checkPreStmt", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker12checkPreStmtEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  public void checkPreStmt(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    // Check for errors first.
    if (checkPre(CE, C)) {
      return;
    }
    
    // Add taint second.
    addSourcesPre(CE, C);
  }

/*private:*/
  private static /*const*//*uint*/int InvalidArgIndex = UINT_MAX;
  /// Denotes the return vale.
  private static /*const*//*uint*/int ReturnValueIndex = UINT_MAX - 1;
  
  private /*mutable */std.unique_ptr<BugType> BT;
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::initBugType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 46,
   FQN="(anonymous namespace)::GenericTaintChecker::initBugType", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker11initBugTypeEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker11initBugTypeEv")
  //</editor-fold>
  private /*inline*/ void initBugType() /*const*/ {
    if (!BT.$bool()) {
      BT.reset(new BugType(this, new StringRef(/*KEEP_STR*/"Use of Untrusted Data"), new StringRef(/*KEEP_STR*/"Untrusted Data")));
    }
  }

  
  /// \brief Catch taint related bugs. Check if tainted data is passed to a
  /// system call etc.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::checkPre">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 404,
   FQN="(anonymous namespace)::GenericTaintChecker::checkPre", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker8checkPreEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker8checkPreEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean checkPre(/*const*/ CallExpr /*P*/ CE, final CheckerContext /*&*/ C) /*const*/ {
    if (checkUncontrolledFormatString(CE, C)) {
      return true;
    }
    
    /*const*/ FunctionDecl /*P*/ FDecl = C.getCalleeDecl(CE);
    if (!(FDecl != null) || FDecl.getKind() != Decl.Kind.Function) {
      return false;
    }
    
    StringRef Name = C.getCalleeName(FDecl);
    if (Name.empty()) {
      return false;
    }
    if (checkSystemCall(CE, new StringRef(Name), C)) {
      return true;
    }
    if (checkTaintedBufferSize(CE, FDecl, C)) {
      return true;
    }
    
    return false;
  }

  
  /// \brief Add taint sources on a pre-visit.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::addSourcesPre">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 292,
   FQN="(anonymous namespace)::GenericTaintChecker::addSourcesPre", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker13addSourcesPreEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker13addSourcesPreEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void addSourcesPre(/*const*/ CallExpr /*P*/ CE, 
               final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      /*const*/ FunctionDecl /*P*/ FDecl = C.getCalleeDecl(CE);
      if (!(FDecl != null) || FDecl.getKind() != Decl.Kind.Function) {
        return;
      }
      
      StringRef Name = C.getCalleeName(FDecl);
      if (Name.empty()) {
        return;
      }
      
      // First, try generating a propagation rule for this function.
      TaintPropagationRule Rule = TaintPropagationRule.getTaintPropagationRule(FDecl, new StringRef(Name), C);
      if (!Rule.isNull()) {
        $c$.clean(State.$assign($c$.track(Rule.process(CE, C))));
        if (!State.$bool()) {
          return;
        }
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return;
      }
      
      // Otherwise, check if we have custom pre-processing implemented.
      GenericTaintChecker$FnCheck evalFunction = new StringSwitch<GenericTaintChecker$FnCheck>(/*NO_COPY*/Name).
          Case(/*KEEP_STR*/"fscanf", /*AddrOf*//*FPtr*/GenericTaintChecker::preFscanf).
          Default((GenericTaintChecker$FnCheck/*const*/)null);
      // Check and evaluate the call.
      if ((evalFunction != null)) {
        $c$.clean(State.$assign($c$.track(evalFunction.$call(/*PtrMemI*/this, CE, C))));
      }
      if (!State.$bool()) {
        return;
      }
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Propagate taint generated at pre-visit.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::propagateFromPre">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 327,
   FQN="(anonymous namespace)::GenericTaintChecker::propagateFromPre", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker16propagateFromPreEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker16propagateFromPreEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean propagateFromPre(/*const*/ CallExpr /*P*/ CE, 
                  final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    ImmutableSetUInt TaintArgs = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      // Depending on what was tainted at pre-visit, we determined a set of
      // arguments which should be tainted after the function returns. These are
      // stored in the state as TaintArgsOnPostVisit set.
      TaintArgs = State.$arrow().<TaintArgsOnPostVisit>get(ProgramStateTraitTaintArgsOnPostVisit.$Instance);
      if (TaintArgs.isEmpty()) {
        return false;
      }
      
      for (ImutAVLValueIteratorUIntBoolUInt I = TaintArgs.begin(), E = TaintArgs.end(); I.$noteq(E); I.$preInc()) {
        /*uint*/int ArgNum = I.$star();
        
        // Special handling for the tainted return value.
        if (ArgNum == ReturnValueIndex) {
          $c$.clean(State.$assign($c$.track(State.$arrow().addTaint(CE, C.getLocationContext()))));
          continue;
        }
        
        // The arguments are pointer arguments. The data they are pointing at is
        // tainted after the call.
        if ($less_uint(CE.getNumArgs(), (ArgNum + 1))) {
          return false;
        }
        /*const*/ Expr /*P*/ Arg = CE.getArg$Const(ArgNum);
        /*const*/ SymExpr /*P*/ Sym = getPointedToSymbol(C, Arg);
        if ((Sym != null)) {
          $c$.clean(State.$assign($c$.track(State.$arrow().addTaint(Sym))));
        }
      }
      
      // Clear up the taint info from the state.
      $c$.clean(State.$assign($c$.track(State.$arrow().remove(ProgramStateTraitTaintArgsOnPostVisit.$Instance))));
      if ($noteq_IntrusiveRefCntPtr(State, C.getState())) {
        $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
        return true;
      }
      return false;
    } finally {
      if (TaintArgs != null) { TaintArgs.$destroy(); }
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// \brief Add taint sources on a post visit.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::addSourcesPost">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 368,
   FQN="(anonymous namespace)::GenericTaintChecker::addSourcesPost", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker14addSourcesPostEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker14addSourcesPostEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private void addSourcesPost(/*const*/ CallExpr /*P*/ CE, 
                final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Define the attack surface.
      // Set the evaluation function by switching on the callee name.
      /*const*/ FunctionDecl /*P*/ FDecl = C.getCalleeDecl(CE);
      if (!(FDecl != null) || FDecl.getKind() != Decl.Kind.Function) {
        return;
      }
      
      StringRef Name = C.getCalleeName(FDecl);
      if (Name.empty()) {
        return;
      }
      GenericTaintChecker$FnCheck evalFunction = new StringSwitch<GenericTaintChecker$FnCheck>(/*NO_COPY*/Name).
          Case(/*KEEP_STR*/"scanf", /*AddrOf*//*FPtr*/GenericTaintChecker::postScanf).
          // TODO: Add support for vfscanf & family.
          Case(/*KEEP_STR*/"getchar", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"getchar_unlocked", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"getenv", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"fopen", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"fdopen", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"freopen", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"getch", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"wgetch", /*AddrOf*//*FPtr*/GenericTaintChecker::postRetTaint).
          Case(/*KEEP_STR*/"socket", /*AddrOf*//*FPtr*/GenericTaintChecker::postSocket).
          Default((GenericTaintChecker$FnCheck/*const*/)null);
      
      // If the callee isn't defined, it is not of security concern.
      // Check and evaluate the call.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
      if ((evalFunction != null)) {
        $c$.clean(State.$assign($c$.track(evalFunction.$call(/*PtrMemI*/this, CE, C))));
      }
      if (!State.$bool()) {
        return;
      }
      
      $c$.clean(C.addTransition($c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State))));
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  
  /// Check if the region the expression evaluates to is the standard input,
  /// and thus, is tainted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::isStdin">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 573,
   FQN="(anonymous namespace)::GenericTaintChecker::isStdin", NM="_ZN12_GLOBAL__N_119GenericTaintChecker7isStdinEPKN5clang4ExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker7isStdinEPKN5clang4ExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private static boolean isStdin(/*const*/ Expr /*P*/ E, final CheckerContext /*&*/ C) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal Val = State.$arrow().getSVal(E, C.getLocationContext());
      
      // stdin is a pointer, so it would be a region.
      /*const*/ MemRegion /*P*/ MemReg = Val.getAsRegion();
      
      // The region should be symbolic, we do not know it's value.
      /*const*/ SymbolicRegion /*P*/ SymReg = dyn_cast_or_null_SymbolicRegion(MemReg);
      if (!(SymReg != null)) {
        return false;
      }
      
      // Get it's symbol and find the declaration region it's pointing to.
      /*const*/ SymbolRegionValue /*P*/ Sm = dyn_cast_SymbolRegionValue(SymReg.getSymbol());
      if (!(Sm != null)) {
        return false;
      }
      /*const*/ DeclRegion /*P*/ DeclReg = dyn_cast_or_null_DeclRegion(Sm.getRegion());
      if (!(DeclReg != null)) {
        return false;
      }
      {
        
        // This region corresponds to a declaration, find out if it's a global/extern
        // variable named stdin with the proper type.
        /*const*/ VarDecl /*P*/ D = dyn_cast_or_null_VarDecl(DeclReg.getDecl());
        if ((D != null)) {
          D = D.getCanonicalDecl$Const();
          if ((D.getName().find(/*STRINGREF_STR*/"stdin") != StringRef.npos) && D.isExternC()) {
            {
              /*const*/ PointerType /*P*/ PtrTy = dyn_cast_PointerType(D.getType().getTypePtr());
              if ((PtrTy != null)) {
                if (QualType.$eq_QualType$C(PtrTy.getPointeeType(), C.getASTContext().getFILEType())) {
                  return true;
                }
              }
            }
          }
        }
      }
      return false;
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  /// \brief Given a pointer argument, get the symbol of the value it contains
  /// (points to).
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::getPointedToSymbol">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 426,
   FQN="(anonymous namespace)::GenericTaintChecker::getPointedToSymbol", NM="_ZN12_GLOBAL__N_119GenericTaintChecker18getPointedToSymbolERN5clang4ento14CheckerContextEPKNS1_4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker18getPointedToSymbolERN5clang4ento14CheckerContextEPKNS1_4ExprE")
  //</editor-fold>
  private static /*const*/ SymExpr /*P*/ getPointedToSymbol(final CheckerContext /*&*/ C, 
                    /*const*/ Expr /*P*/ Arg) {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      SVal AddrVal = State.$arrow().getSVal(Arg.IgnoreParens$Const(), C.getLocationContext());
      if (AddrVal.isUnknownOrUndef$SVal()) {
        return null;
      }
      
      Optional<Loc> AddrLoc = AddrVal.getAs(Loc.class);
      if (!AddrLoc.$bool()) {
        return null;
      }
      
      /*const*/ PointerType /*P*/ ArgTy = dyn_cast_PointerType(Arg.getType().getCanonicalType().getTypePtr());
      SVal Val = State.$arrow().getSVal(new Loc(AddrLoc.$star()), 
          (ArgTy != null) ? ArgTy.getPointeeType() : new QualType());
      return Val.getAsSymbol();
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  /// Functions defining the attack surface.
  // JAVA: typedef ProgramStateRef (GenericTaintChecker::*FnCheck)(const CallExpr *, CheckerContext &) const
//  public final class FnCheck extends GenericTaintChecker$FnCheck{ };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::postScanf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 550,
   FQN="(anonymous namespace)::GenericTaintChecker::postScanf", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker9postScanfEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker9postScanfEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> postScanf(/*const*/ CallExpr /*P*/ CE, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($less_uint(CE.getNumArgs(), 2)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      // All arguments except for the very first one should get taint.
      for (/*uint*/int i = 1; $less_uint(i, CE.getNumArgs()); ++i) {
        // The arguments are pointer arguments. The data they are pointing at is
        // tainted after the call.
        /*const*/ Expr /*P*/ Arg = CE.getArg$Const(i);
        /*const*/ SymExpr /*P*/ Sym = getPointedToSymbol(C, Arg);
        if ((Sym != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(State.$assign($c$.track(State.$arrow().addTaint(Sym))));
          } finally {
            $c$.$destroy();
          }
        }
      }
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  // If argument 0(protocol domain) is network, the return value should get taint.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::postSocket">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 534,
   FQN="(anonymous namespace)::GenericTaintChecker::postSocket", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker10postSocketEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker10postSocketEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> postSocket(/*const*/ CallExpr /*P*/ CE, 
            final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if ($less_uint(CE.getNumArgs(), 3)) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      
      SourceLocation DomLoc = CE.getArg$Const(0).getExprLoc();
      StringRef DomName = C.getMacroNameOrSpelling(DomLoc);
      // White list the internal communication protocols.
      if (DomName.equals(/*STRINGREF_STR*/"AF_SYSTEM") || DomName.equals(/*STRINGREF_STR*/"AF_LOCAL")
         || DomName.equals(/*STRINGREF_STR*/"AF_UNIX") || DomName.equals(/*STRINGREF_STR*/"AF_RESERVED_36")) {
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      }
      $c$.clean(State.$assign($c$.track(State.$arrow().addTaint(CE, C.getLocationContext()))));
      return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
    } finally {
      if (State != null) { State.$destroy(); }
      $c$.$destroy();
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::postRetTaint">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 568,
   FQN="(anonymous namespace)::GenericTaintChecker::postRetTaint", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker12postRetTaintEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker12postRetTaintEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> postRetTaint(/*const*/ CallExpr /*P*/ CE, 
              final CheckerContext /*&*/ C) /*const*/ {
    return C.getState().$arrow().addTaint(CE, C.getLocationContext());
  }

  
  /// Taint the scanned input if the file is tainted.
  
  // If argument 0 (file descriptor) is tainted, all arguments except for arg 0
  // and arg 1 should get taint.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::preFscanf">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 515,
   FQN="(anonymous namespace)::GenericTaintChecker::preFscanf", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker9preFscanfEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker9preFscanfEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private IntrusiveRefCntPtr</*const*/ ProgramState> preFscanf(/*const*/ CallExpr /*P*/ CE, 
           final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      assert ($greatereq_uint(CE.getNumArgs(), 2));
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      
      // Check is the file descriptor is tainted.
      if (State.$arrow().isTainted(CE.getArg$Const(0), C.getLocationContext())
         || isStdin(CE.getArg$Const(0), C)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // All arguments except for the first two should get taint.
          for (/*uint*/int i = 2; $less_uint(i, CE.getNumArgs()); ++i)  {
            $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitTaintArgsOnPostVisit.$Instance, i))));
          }
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
        } finally {
          $c$.$destroy();
        }
      }
      
      return new IntrusiveRefCntPtr</*const*/ ProgramState>((/*const*/ ProgramState /*P*/ )null);
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  /// Check for CWE-134: Uncontrolled Format String.
  private static /*const*//*char*/byte MsgUncontrolledFormatString[] = new$char(-1, "Untrusted data is used as a format string (CWE-134: Uncontrolled Format String)");
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::checkUncontrolledFormatString">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 653,
   FQN="(anonymous namespace)::GenericTaintChecker::checkUncontrolledFormatString", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker29checkUncontrolledFormatStringEPKN5clang8CallExprERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker29checkUncontrolledFormatStringEPKN5clang8CallExprERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean checkUncontrolledFormatString(/*const*/ CallExpr /*P*/ CE, 
                               final CheckerContext /*&*/ C) /*const*/ {
    // Check if the function contains a format string argument.
    uint$ref ArgNum = create_uint$ref(0);
    if (!GenericTaintCheckerStatics.getPrintfFormatArgumentNum(CE, C, ArgNum)) {
      return false;
    }
    
    // If either the format string content or the pointer itself are tainted, warn.
    return generateReportIfTainted(CE.getArg$Const(ArgNum.$deref()), 
        /*create_char$ptr(*/MsgUncontrolledFormatString/*)*/, C);
  }

  
  /// Check for:
  /// CERT/STR02-C. "Sanitize data passed to complex subsystems"
  /// CWE-78, "Failure to Sanitize Data into an OS Command"
  private static /*const*//*char*/byte MsgSanitizeSystemArgs[] = new$char(-1, "Untrusted data is passed to a system call (CERT/STR02-C. Sanitize data passed to complex subsystems)");
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::checkSystemCall">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 665,
   FQN="(anonymous namespace)::GenericTaintChecker::checkSystemCall", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker15checkSystemCallEPKN5clang8CallExprEN4llvm9StringRefERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker15checkSystemCallEPKN5clang8CallExprEN4llvm9StringRefERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean checkSystemCall(/*const*/ CallExpr /*P*/ CE, 
                 StringRef Name, 
                 final CheckerContext /*&*/ C) /*const*/ {
    // TODO: It might make sense to run this check on demand. In some cases,
    // we should check if the environment has been cleansed here. We also might
    // need to know if the user was reset before these calls(seteuid).
    /*uint*/int ArgNum = new StringSwitchUInt(/*NO_COPY*/Name).
        Case(/*KEEP_STR*/"system", 0).
        Case(/*KEEP_STR*/"popen", 0).
        Case(/*KEEP_STR*/"execl", 0).
        Case(/*KEEP_STR*/"execle", 0).
        Case(/*KEEP_STR*/"execlp", 0).
        Case(/*KEEP_STR*/"execv", 0).
        Case(/*KEEP_STR*/"execvp", 0).
        Case(/*KEEP_STR*/"execvP", 0).
        Case(/*KEEP_STR*/"execve", 0).
        Case(/*KEEP_STR*/"dlopen", 0).
        Default(UINT_MAX);
    if (ArgNum == UINT_MAX || $less_uint(CE.getNumArgs(), (ArgNum + 1))) {
      return false;
    }
    
    return generateReportIfTainted(CE.getArg$Const(ArgNum), /*create_char$ptr(*/MsgSanitizeSystemArgs/*)*/, C);
  }

  
  /// Check if tainted data is used as a buffer size ins strn.. functions,
  /// and allocators.
  private static /*const*//*char*/byte MsgTaintedBufferSize[] = new$char(-1, "Untrusted data is used to specify the buffer size (CERT/STR31-C. Guarantee that storage for strings has sufficient space for character data and the null terminator)");
  
  // TODO: Should this check be a part of the CString checker?
  // If yes, should taint be a global setting?
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::checkTaintedBufferSize">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 692,
   FQN="(anonymous namespace)::GenericTaintChecker::checkTaintedBufferSize", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker22checkTaintedBufferSizeEPKN5clang8CallExprEPKNS1_12FunctionDeclERNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker22checkTaintedBufferSizeEPKN5clang8CallExprEPKNS1_12FunctionDeclERNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean checkTaintedBufferSize(/*const*/ CallExpr /*P*/ CE, 
                        /*const*/ FunctionDecl /*P*/ FDecl, 
                        final CheckerContext /*&*/ C) /*const*/ {
    // If the function has a buffer size argument, set ArgNum.
    /*uint*/int ArgNum = InvalidArgIndex;
    /*uint*/int BId = 0;
    if (((BId = FDecl.getMemoryFunctionKind()) != 0)) {
      switch (Builtin.ID.valueOf(BId)) {
       case BImemcpy:
       case BImemmove:
       case BIstrncpy:
        ArgNum = 2;
        break;
       case BIstrndup:
        ArgNum = 1;
        break;
       default:
        break;
      }
    }
    ;
    if (ArgNum == InvalidArgIndex) {
      if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"malloc"))
         || C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"calloc"))
         || C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"alloca"))) {
        ArgNum = 0;
      } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"memccpy"))) {
        ArgNum = 3;
      } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"realloc"))) {
        ArgNum = 1;
      } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"bcopy"))) {
        ArgNum = 2;
      }
    }
    
    return ArgNum != InvalidArgIndex && $greater_uint(CE.getNumArgs(), ArgNum)
       && generateReportIfTainted(CE.getArg$Const(ArgNum), /*create_char$ptr(*/MsgTaintedBufferSize/*)*/, C);
  }

  
  /// Generate a report if the expression is tainted or points to tainted data.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::generateReportIfTainted">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 631,
   FQN="(anonymous namespace)::GenericTaintChecker::generateReportIfTainted", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker23generateReportIfTaintedEPKN5clang4ExprEPKcRNS1_4ento14CheckerContextE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker23generateReportIfTaintedEPKN5clang4ExprEPKcRNS1_4ento14CheckerContextE")
  //</editor-fold>
  private boolean generateReportIfTainted(/*const*/ Expr /*P*/ E, 
                         /*const*//*char*/byte Msg[], 
                         final CheckerContext /*&*/ C) /*const*/ {
    IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
    try {
      assert Native.$bool(E);
      
      // Check for taint.
      State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
      if (!State.$arrow().isTainted(getPointedToSymbol(C, E))
         && !State.$arrow().isTainted(E, C.getLocationContext())) {
        return false;
      }
      {
        
        // Generate diagnostic.
        ExplodedNode /*P*/ N = C.generateNonFatalErrorNode();
        if ((N != null)) {
          unique_ptr<BugReport> report = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            initBugType();
            report = llvm.make_unique(new BugReport(BT.$star(), Msg, N));
            report.$arrow().addRange(E.getSourceRange());
            C.emitReport($c$.track(new std.unique_ptr<BugReport>(JD$Move.INSTANCE, std.move(report)))); $c$.clean();
            return true;
          } finally {
            if (report != null) { report.$destroy(); }
            $c$.$destroy();
          }
        }
      }
      return false;
    } finally {
      if (State != null) { State.$destroy(); }
    }
  }

  
  // JAVA: typedef SmallVector<unsigned int, 2> ArgVector
//  public final class ArgVector extends SmallVectorUInt{ };
  
  /// \brief A struct used to specify taint propagation rules for a function.
  ///
  /// If any of the possible taint source arguments is tainted, all of the
  /// destination arguments should also be tainted. Use InvalidArgIndex in the
  /// src list to specify that all of the arguments can introduce taint. Use
  /// InvalidArgIndex in the dst arguments to signify that all the non-const
  /// pointer and reference arguments might be tainted on return. If
  /// ReturnValueIndex is added to the dst list, the return value will be
  /// tainted.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 116,
   FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleE")
  //</editor-fold>
  private static class/*struct*/ TaintPropagationRule implements Destructors.ClassWithDestructor {
    /// List of arguments which can be taint sources and should be checked.
    public SmallVectorUInt SrcArgs;
    /// List of arguments which should be tainted on function return.
    public SmallVectorUInt DstArgs;
    // TODO: Check if using other data structures would be more optimal.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 123,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1Ev")
    //</editor-fold>
    public TaintPropagationRule() {
      // : SrcArgs(), DstArgs() 
      //START JInit
      this.SrcArgs = new SmallVectorUInt(2, 0);
      this.DstArgs = new SmallVectorUInt(2, 0);
      //END JInit
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 125,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1Ejjb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1Ejjb")
    //</editor-fold>
    public TaintPropagationRule(/*uint*/int SArg, 
        /*uint*/int DArg) {
      this(SArg, 
        DArg, false);
    }
    public TaintPropagationRule(/*uint*/int SArg, 
        /*uint*/int DArg, boolean TaintRet/*= false*/) {
      // : SrcArgs(), DstArgs() 
      //START JInit
      this.SrcArgs = new SmallVectorUInt(2, 0);
      this.DstArgs = new SmallVectorUInt(2, 0);
      //END JInit
      SrcArgs.push_back(SArg);
      DstArgs.push_back(DArg);
      if (TaintRet) {
        DstArgs.push_back(ReturnValueIndex);
      }
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 133,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1Ejjjb",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1Ejjjb")
    //</editor-fold>
    public TaintPropagationRule(/*uint*/int SArg1, /*uint*/int SArg2, 
        /*uint*/int DArg) {
      this(SArg1, SArg2, 
        DArg, false);
    }
    public TaintPropagationRule(/*uint*/int SArg1, /*uint*/int SArg2, 
        /*uint*/int DArg, boolean TaintRet/*= false*/) {
      // : SrcArgs(), DstArgs() 
      //START JInit
      this.SrcArgs = new SmallVectorUInt(2, 0);
      this.DstArgs = new SmallVectorUInt(2, 0);
      //END JInit
      SrcArgs.push_back(SArg1);
      SrcArgs.push_back(SArg2);
      DstArgs.push_back(DArg);
      if (TaintRet) {
        DstArgs.push_back(ReturnValueIndex);
      }
    }

    
    /// Get the propagation rule for a given function.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::getTaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 197,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::getTaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule23getTaintPropagationRuleEPKN5clang12FunctionDeclEN4llvm9StringRefERNS2_4ento14CheckerContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule23getTaintPropagationRuleEPKN5clang12FunctionDeclEN4llvm9StringRefERNS2_4ento14CheckerContextE")
    //</editor-fold>
    public static GenericTaintChecker.TaintPropagationRule getTaintPropagationRule(/*const*/ FunctionDecl /*P*/ FDecl, 
                           StringRef Name, 
                           final CheckerContext /*&*/ C) {
      // TODO: Currently, we might lose precision here: we always mark a return
      // value as tainted even if it's just a pointer, pointing to tainted data.
      
      // Check for exact name match for functions without builtin substitutes.
      TaintPropagationRule Rule = new StringSwitch<TaintPropagationRule>(/*NO_COPY*/Name).
          Case(/*KEEP_STR*/"atoi", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"atol", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"atoll", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"getc", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"fgetc", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"getc_unlocked", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"getw", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"toupper", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"tolower", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"strchr", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"strrchr", new TaintPropagationRule(0, ReturnValueIndex)).
          Case(/*KEEP_STR*/"read", new TaintPropagationRule(0, 2, 1, true)).
          Case(/*KEEP_STR*/"pread", new TaintPropagationRule(InvalidArgIndex, 1, true)).
          Case(/*KEEP_STR*/"gets", new TaintPropagationRule(InvalidArgIndex, 0, true)).
          Case(/*KEEP_STR*/"fgets", new TaintPropagationRule(2, 0, true)).
          Case(/*KEEP_STR*/"getline", new TaintPropagationRule(2, 0)).
          Case(/*KEEP_STR*/"getdelim", new TaintPropagationRule(3, 0)).
          Case(/*KEEP_STR*/"fgetln", new TaintPropagationRule(0, ReturnValueIndex)).
          Default(new TaintPropagationRule());
      if (!Rule.isNull()) {
        return Rule;
      }
      
      // Check if it's one of the memory setting/copying functions.
      // This check is specialized but faster then calling isCLibraryFunction.
      /*uint*/int BId = 0;
      if (((BId = FDecl.getMemoryFunctionKind()) != 0)) {
        switch (Builtin.ID.valueOf(BId)) {
         case BImemcpy:
         case BImemmove:
         case BIstrncpy:
         case BIstrncat:
          return new TaintPropagationRule(1, 2, 0, true);
         case BIstrlcpy:
         case BIstrlcat:
          return new TaintPropagationRule(1, 2, 0, false);
         case BIstrndup:
          return new TaintPropagationRule(0, 1, ReturnValueIndex);
         default:
          break;
        }
      }
      ;
      
      // Process all other functions which could be defined as builtins.
      if (Rule.isNull()) {
        if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"snprintf"))
           || C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"sprintf"))) {
          return new TaintPropagationRule(InvalidArgIndex, 0, true);
        } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strcpy"))
           || C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"stpcpy"))
           || C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strcat"))) {
          return new TaintPropagationRule(1, 0, true);
        } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"bcopy"))) {
          return new TaintPropagationRule(0, 2, 1, false);
        } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strdup"))
           || C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"strdupa"))) {
          return new TaintPropagationRule(0, ReturnValueIndex);
        } else if (C.isCLibraryFunction(FDecl, new StringRef(/*KEEP_STR*/"wcsdup"))) {
          return new TaintPropagationRule(0, ReturnValueIndex);
        }
      }
      
      // Skipping the following functions, since they might be used for cleansing
      // or smart memory copy:
      // - memccpy - copying until hitting a special character.
      return new TaintPropagationRule();
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::addSrcArg">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 148,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::addSrcArg", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule9addSrcArgEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule9addSrcArgEj")
    //</editor-fold>
    public /*inline*/ void addSrcArg(/*uint*/int A) {
      SrcArgs.push_back(A);
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::addDstArg">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 149,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::addDstArg", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule9addDstArgEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule9addDstArgEj")
    //</editor-fold>
    public /*inline*/ void addDstArg(/*uint*/int A) {
      DstArgs.push_back(A);
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::isNull">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 151,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::isNull", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule6isNullEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule6isNullEv")
    //</editor-fold>
    public /*inline*/ boolean isNull() /*const*/ {
      return SrcArgs.empty();
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::isDestinationArgument">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 153,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::isDestinationArgument", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule21isDestinationArgumentEj",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule21isDestinationArgumentEj")
    //</editor-fold>
    public /*inline*/ boolean isDestinationArgument(/*uint*/int ArgNum) /*const*/ {
      return ($noteq_ptr(std.find(DstArgs.begin$Const(), 
          DstArgs.end$Const(), ArgNum), DstArgs.end$Const()));
    }

    
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::isTaintedOrPointsToTainted">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 158,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::isTaintedOrPointsToTainted", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule26isTaintedOrPointsToTaintedEPKN5clang4ExprEN4llvm18IntrusiveRefCntPtrIKNS2_4ento12ProgramStateEEERNS8_14CheckerContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule26isTaintedOrPointsToTaintedEPKN5clang4ExprEN4llvm18IntrusiveRefCntPtrIKNS2_4ento12ProgramStateEEERNS8_14CheckerContextE")
    //</editor-fold>
    public static /*inline*/ boolean isTaintedOrPointsToTainted(/*const*/ Expr /*P*/ E, 
                              IntrusiveRefCntPtr</*const*/ ProgramState> State, 
                              final CheckerContext /*&*/ C) {
      return (State.$arrow().isTainted(E, C.getLocationContext()) || isStdin(E, C)
         || (E.getType().getTypePtr().isPointerType()
         && State.$arrow().isTainted(getPointedToSymbol(C, E))));
    }

    
    /// \brief Pre-process a function which propagates taint according to the
    /// taint rule.
    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::process">
    @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 444,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::process", NM="_ZNK12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule7processEPKN5clang8CallExprERNS2_4ento14CheckerContextE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZNK12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRule7processEPKN5clang8CallExprERNS2_4ento14CheckerContextE")
    //</editor-fold>
    public IntrusiveRefCntPtr</*const*/ ProgramState> process(/*const*/ CallExpr /*P*/ CE, 
           final CheckerContext /*&*/ C) /*const*/ {
      IntrusiveRefCntPtr</*const*/ ProgramState> State = null;
      try {
        State = new IntrusiveRefCntPtr</*const*/ ProgramState>(C.getState());
        
        // Check for taint in arguments.
        boolean IsTainted = false;
        for (/*const*/uint$ptr/*uint P*/ I = $tryClone(SrcArgs.begin$Const()), 
            /*P*/ E = $tryClone(SrcArgs.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int ArgNum = I.$star();
            if (ArgNum == InvalidArgIndex) {
              // Check if any of the arguments is tainted, but skip the
              // destination arguments.
              for (/*uint*/int i = 0; $less_uint(i, CE.getNumArgs()); ++i) {
                if (isDestinationArgument(i)) {
                  continue;
                }
                if ($c$.clean((IsTainted = TaintPropagationRule.isTaintedOrPointsToTainted(CE.getArg$Const(i), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C)))) {
                  break;
                }
              }
              break;
            }
            if ($less_uint(CE.getNumArgs(), (ArgNum + 1))) {
              return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
            }
            if ($c$.clean((IsTainted = TaintPropagationRule.isTaintedOrPointsToTainted(CE.getArg$Const(ArgNum), $c$.track(new IntrusiveRefCntPtr</*const*/ ProgramState>(State)), C)))) {
              break;
            }
          } finally {
            $c$.$destroy();
          }
        }
        if (!IsTainted) {
          return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
        }
        
        // Mark the arguments which should be tainted after the function returns.
        for (/*const*/uint$ptr/*uint P*/ I = $tryClone(DstArgs.begin$Const()), 
            /*P*/ E = $tryClone(DstArgs.end$Const()); $noteq_ptr(I, E); I.$preInc()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*uint*/int ArgNum = I.$star();
            
            // Should we mark all arguments as tainted?
            if (ArgNum == InvalidArgIndex) {
              // For all pointer and references that were passed in:
              //   If they are not pointing to const data, mark data as tainted.
              //   TODO: So far we are just going one level down; ideally we'd need to
              //         recurse here.
              for (/*uint*/int i = 0; $less_uint(i, CE.getNumArgs()); ++i) {
                /*const*/ Expr /*P*/ Arg = CE.getArg$Const(i);
                // Process pointer argument.
                /*const*/ Type /*P*/ ArgTy = Arg.getType().getTypePtr();
                QualType PType = ArgTy.getPointeeType();
                if ((!PType.isNull() && !PType.isConstQualified())
                   || (ArgTy.isReferenceType() && !Arg.getType().isConstQualified())) {
                  $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitTaintArgsOnPostVisit.$Instance, i))));
                }
              }
              continue;
            }
            
            // Should mark the return value?
            if (ArgNum == ReturnValueIndex) {
              $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitTaintArgsOnPostVisit.$Instance, ReturnValueIndex))));
              continue;
            }
            
            // Mark the given argument.
            assert ($less_uint(ArgNum, CE.getNumArgs()));
            $c$.clean(State.$assign($c$.track(State.$arrow().add(ProgramStateTraitTaintArgsOnPostVisit.$Instance, ArgNum))));
          } finally {
            $c$.$destroy();
          }
        }
        
        return new IntrusiveRefCntPtr</*const*/ ProgramState>(JD$Move.INSTANCE, State);
      } finally {
        if (State != null) { State.$destroy(); }
      }
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 116,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1EOS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1EOS1_")
    //</editor-fold>
    public /*inline*/ TaintPropagationRule(JD$Move _dparam, final TaintPropagationRule /*&&*/$Prm0) {
      // : SrcArgs(static_cast<TaintPropagationRule &&>().SrcArgs), DstArgs(static_cast<TaintPropagationRule &&>().DstArgs) 
      //START JInit
      this.SrcArgs = new SmallVectorUInt(JD$Move.INSTANCE, $Prm0.SrcArgs);
      this.DstArgs = new SmallVectorUInt(JD$Move.INSTANCE, $Prm0.DstArgs);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 116,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1ERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleC1ERKS1_")
    //</editor-fold>
    public /*inline*/ TaintPropagationRule(final /*const*/ TaintPropagationRule /*&*/ $Prm0) {
      // : SrcArgs(.SrcArgs), DstArgs(.DstArgs) 
      //START JInit
      this.SrcArgs = new SmallVectorUInt($Prm0.SrcArgs);
      this.DstArgs = new SmallVectorUInt($Prm0.DstArgs);
      //END JInit
    }

    //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::~TaintPropagationRule">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 116,
     FQN="(anonymous namespace)::GenericTaintChecker::TaintPropagationRule::~TaintPropagationRule", NM="_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintChecker20TaintPropagationRuleD0Ev")
    //</editor-fold>
    public /*inline*/ void $destroy() {
      //START JDestroy
      DstArgs.$destroy();
      SrcArgs.$destroy();
      //END JDestroy
    }

    
    @Override public String toString() {
      return "" + "SrcArgs=" + SrcArgs // NOI18N
                + ", DstArgs=" + DstArgs; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::~GenericTaintChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 31,
   FQN="(anonymous namespace)::GenericTaintChecker::~GenericTaintChecker", NM="_ZN12_GLOBAL__N_119GenericTaintCheckerD0Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintCheckerD0Ev")
  //</editor-fold>
  @Override public /*inline*/ void $destroy() {
    //START JDestroy
    BT.$destroy();
    super.$destroy();
    //END JDestroy
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GenericTaintChecker::GenericTaintChecker">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp", line = 31,
   FQN="(anonymous namespace)::GenericTaintChecker::GenericTaintChecker", NM="_ZN12_GLOBAL__N_119GenericTaintCheckerC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.staticanalyzer/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Checkers/GenericTaintChecker.cpp -nm=_ZN12_GLOBAL__N_119GenericTaintCheckerC1Ev")
  //</editor-fold>
  public /*inline*/ GenericTaintChecker() {
    // : Checker<PostStmt<CallExpr>, PreStmt<CallExpr> >(), BT() 
    //START JInit
    super();
    this.BT = new std.unique_ptr<BugType>();
    //END JInit
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  @Override
  public void $checkPreStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPreStmt((CallExpr) stmt, C);
    }
  }

  @Override
  public void $checkPostStmt(Stmt stmt, CheckerContext C) {
    if (stmt instanceof CallExpr) {
      checkPostStmt((CallExpr) stmt, C);
    }
  }

  private final CheckBase $CHECKS[] = {
    new org.clang.staticanalyzer.core.ento.check.PostStmt<CallExpr>(CallExpr.class),
    new org.clang.staticanalyzer.core.ento.check.PreStmt<CallExpr>(CallExpr.class)
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
