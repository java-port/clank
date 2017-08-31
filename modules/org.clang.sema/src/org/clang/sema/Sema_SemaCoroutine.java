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
package org.clang.sema;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaCoroutine">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaCoroutine",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaCodeComplete ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema16ActOnCoawaitExprEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema16ActOnCoyieldExprEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema16BuildCoawaitExprENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema16BuildCoyieldExprENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema17ActOnCoreturnStmtENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema17BuildCoreturnStmtENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema27CheckCompletedCoroutineBodyEPNS_12FunctionDeclERPNS_4StmtE; -static-type=Sema_SemaCoroutine -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaCoroutine extends Sema_SemaCodeComplete {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


//===--------------------------------------------------------------------===//
// C++ Coroutines TS
//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCoawaitExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 215,
 FQN="clang::Sema::ActOnCoawaitExpr", NM="_ZN5clang4Sema16ActOnCoawaitExprEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema16ActOnCoawaitExprEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCoawaitExpr(Scope /*P*/ S, SourceLocation Loc, Expr /*P*/ E) {
  if (E.getType().$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > R = $this().CheckPlaceholderExpr(E);
    if (R.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    E = R.get();
  }
  
  ActionResultTTrue<Expr /*P*/ > Awaitable = SemaCoroutineStatics.buildOperatorCoawaitCall(/*Deref*/$this(), S, new SourceLocation(Loc), E);
  if (Awaitable.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  return $this().BuildCoawaitExpr(new SourceLocation(Loc), Awaitable.get());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCoyieldExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 276,
 FQN="clang::Sema::ActOnCoyieldExpr", NM="_ZN5clang4Sema16ActOnCoyieldExprEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema16ActOnCoyieldExprEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCoyieldExpr(Scope /*P*/ S, SourceLocation Loc, Expr /*P*/ E) {
  FunctionScopeInfo /*P*/ Coroutine = SemaCoroutineStatics.checkCoroutineContext(/*Deref*/$this(), new SourceLocation(Loc), new StringRef(/*KEEP_STR*/$co_yield));
  if (!(Coroutine != null)) {
    return SemaClangGlobals.ExprError();
  }
  
  // Build yield_value call.
  ActionResultTTrue<Expr /*P*/ > Awaitable = SemaCoroutineStatics.buildPromiseCall(/*Deref*/$this(), Coroutine, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"yield_value"), new MutableArrayRef<Expr /*P*/ >(E, true));
  if (Awaitable.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  
  // Build 'operator co_await' call.
  Awaitable.$assignMove(SemaCoroutineStatics.buildOperatorCoawaitCall(/*Deref*/$this(), S, new SourceLocation(Loc), Awaitable.get()));
  if (Awaitable.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  
  return $this().BuildCoyieldExpr(new SourceLocation(Loc), Awaitable.get());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCoreturnStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 327,
 FQN="clang::Sema::ActOnCoreturnStmt", NM="_ZN5clang4Sema17ActOnCoreturnStmtENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema17ActOnCoreturnStmtENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCoreturnStmt(SourceLocation Loc, Expr /*P*/ E) {
  return $this().BuildCoreturnStmt(new SourceLocation(Loc), E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCoawaitExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 227,
 FQN="clang::Sema::BuildCoawaitExpr", NM="_ZN5clang4Sema16BuildCoawaitExprENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema16BuildCoawaitExprENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCoawaitExpr(SourceLocation Loc, Expr /*P*/ E) {
  FunctionScopeInfo /*P*/ Coroutine = SemaCoroutineStatics.checkCoroutineContext(/*Deref*/$this(), new SourceLocation(Loc), new StringRef(/*KEEP_STR*/$co_await));
  if (!(Coroutine != null)) {
    return SemaClangGlobals.ExprError();
  }
  if (E.getType().$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > R = $this().CheckPlaceholderExpr(E);
    if (R.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    E = R.get();
  }
  if (E.getType().$arrow().isDependentType()) {
    final Expr/*P*/ L$E = E;
    Expr /*P*/ Res = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new CoawaitExpr(new SourceLocation(Loc), $this().Context.DependentTy.$QualType(), L$E);
     });
    Coroutine.CoroutineStmts.push_back(Res);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res);
  }
  
  // If the expression is a temporary, materialize it as an lvalue so that we
  // can use it multiple times.
  if (E.getValueKind() == ExprValueKind.VK_RValue) {
    E = $this().CreateMaterializeTemporaryExpr(E.getType(), E, true);
  }
  
  // Build the await_ready, await_suspend, await_resume calls.
  ReadySuspendResumeResult RSS = SemaCoroutineStatics.buildCoawaitCalls(/*Deref*/$this(), new SourceLocation(Loc), E);
  if (RSS.IsInvalid) {
    return SemaClangGlobals.ExprError();
  }
  final Expr/*P*/ L$E = E;
  Expr /*P*/ Res = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CoawaitExpr(new SourceLocation(Loc), L$E, RSS.Results[0], RSS.Results[1], 
              RSS.Results[2]);
   });
  Coroutine.CoroutineStmts.push_back(Res);
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCoyieldExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 294,
 FQN="clang::Sema::BuildCoyieldExpr", NM="_ZN5clang4Sema16BuildCoyieldExprENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema16BuildCoyieldExprENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCoyieldExpr(SourceLocation Loc, Expr /*P*/ E) {
  FunctionScopeInfo /*P*/ Coroutine = SemaCoroutineStatics.checkCoroutineContext(/*Deref*/$this(), new SourceLocation(Loc), new StringRef(/*KEEP_STR*/$co_yield));
  if (!(Coroutine != null)) {
    return SemaClangGlobals.ExprError();
  }
  if (E.getType().$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > R = $this().CheckPlaceholderExpr(E);
    if (R.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    E = R.get();
  }
  if (E.getType().$arrow().isDependentType()) {
    final Expr/*P*/ L$E = E;
    Expr /*P*/ Res = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new CoyieldExpr(new SourceLocation(Loc), $this().Context.DependentTy.$QualType(), L$E);
     });
    Coroutine.CoroutineStmts.push_back(Res);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res);
  }
  
  // If the expression is a temporary, materialize it as an lvalue so that we
  // can use it multiple times.
  if (E.getValueKind() == ExprValueKind.VK_RValue) {
    E = $this().CreateMaterializeTemporaryExpr(E.getType(), E, true);
  }
  
  // Build the await_ready, await_suspend, await_resume calls.
  ReadySuspendResumeResult RSS = SemaCoroutineStatics.buildCoawaitCalls(/*Deref*/$this(), new SourceLocation(Loc), E);
  if (RSS.IsInvalid) {
    return SemaClangGlobals.ExprError();
  }
  final Expr/*P*/ L$E = E;
  Expr /*P*/ Res = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CoyieldExpr(new SourceLocation(Loc), L$E, RSS.Results[0], RSS.Results[1], 
              RSS.Results[2]);
   });
  Coroutine.CoroutineStmts.push_back(Res);
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Res);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCoreturnStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 330,
 FQN="clang::Sema::BuildCoreturnStmt", NM="_ZN5clang4Sema17BuildCoreturnStmtENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema17BuildCoreturnStmtENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > BuildCoreturnStmt(SourceLocation Loc, Expr /*P*/ E) {
  FunctionScopeInfo /*P*/ Coroutine = SemaCoroutineStatics.checkCoroutineContext(/*Deref*/$this(), new SourceLocation(Loc), new StringRef(/*KEEP_STR*/$co_return));
  if (!(Coroutine != null)) {
    return SemaClangGlobals.StmtError();
  }
  if ((E != null) && E.getType().$arrow().isPlaceholderType()
     && !E.getType().$arrow().isSpecificPlaceholderType(BuiltinType.Kind.Overload.getValue())) {
    ActionResultTTrue<Expr /*P*/ > R = $this().CheckPlaceholderExpr(E);
    if (R.isInvalid()) {
      return SemaClangGlobals.StmtError();
    }
    E = R.get();
  }
  
  // FIXME: If the operand is a reference to a variable that's about to go out
  // of scope, we should treat the operand as an xvalue for this overload
  // resolution.
  ActionResultTTrue<Expr /*P*/ > PC/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  if ((E != null) && !E.getType().$arrow().isVoidType()) {
    PC.$assignMove(SemaCoroutineStatics.buildPromiseCall(/*Deref*/$this(), Coroutine, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"return_value"), new MutableArrayRef<Expr /*P*/ >(E, true)));
  } else {
    E = $this().MakeFullDiscardedValueExpr(E).get();
    PC.$assignMove(SemaCoroutineStatics.buildPromiseCall(/*Deref*/$this(), Coroutine, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"return_void"), new MutableArrayRef<Expr /*P*/ >(None, true)));
  }
  if (PC.isInvalid()) {
    return SemaClangGlobals.StmtError();
  }
  
  Expr /*P*/ PCE = $this().ActOnFinishFullExpr(PC.get()).get();
  final Expr/*P*/ L$E = E;
  Stmt /*P*/ Res = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CoreturnStmt(new SourceLocation(Loc), L$E, PCE);
   });
  Coroutine.CoroutineStmts.push_back(Res);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Res);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCompletedCoroutineBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 362,
 FQN="clang::Sema::CheckCompletedCoroutineBody", NM="_ZN5clang4Sema27CheckCompletedCoroutineBodyEPNS_12FunctionDeclERPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZN5clang4Sema27CheckCompletedCoroutineBodyEPNS_12FunctionDeclERPNS_4StmtE")
//</editor-fold>
public final void CheckCompletedCoroutineBody(FunctionDecl /*P*/ FD, final type$ref<Stmt /*P*/ /*&*/> Body) {
  FunctionScopeInfo /*P*/ Fn = $this().getCurFunction();
  assert ((Fn != null) && !Fn.CoroutineStmts.empty()) : "not a coroutine";
  
  // Coroutines [stmt.return]p1:
  //   A return statement shall not appear in a coroutine.
  if (Fn.FirstReturnLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(Fn.FirstReturnLoc), diag.err_return_in_coroutine)));
      Stmt /*P*/ First = Fn.CoroutineStmts.$at(0);
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(First.getLocStart(), diag.note_declared_coroutine_here)), 
          (isa_CoawaitExpr(First) ? 0 : isa_CoyieldExpr(First) ? 1 : 2)));
    } finally {
      $c$.$destroy();
    }
  }
  
  boolean AnyCoawaits = false;
  boolean AnyCoyields = false;
  for (Stmt /*P*/ CoroutineStmt : Fn.CoroutineStmts) {
    AnyCoawaits |= isa_CoawaitExpr(CoroutineStmt);
    AnyCoyields |= isa_CoyieldExpr(CoroutineStmt);
  }
  if (!AnyCoawaits && !AnyCoyields) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(Fn.CoroutineStmts.front().getLocStart(), 
          diag.ext_coroutine_without_co_await_co_yield)));
    } finally {
      $c$.$destroy();
    }
  }
  
  SourceLocation Loc = FD.getLocation();
  
  // Form a declaration statement for the promise declaration, so that AST
  // visitors can more easily find it.
  ActionResultTTrue<Stmt /*P*/ > PromiseStmt = $this().ActOnDeclStmt($this().ConvertDeclToDeclGroup(Fn.CoroutinePromise), new SourceLocation(Loc), new SourceLocation(Loc));
  if (PromiseStmt.isInvalid()) {
    FD.setInvalidDecl();
    /*JAVA:return*/return;
  }
  
  // Form and check implicit 'co_await p.initial_suspend();' statement.
  ActionResultTTrue<Expr /*P*/ > InitialSuspend = SemaCoroutineStatics.buildPromiseCall(/*Deref*/$this(), Fn, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"initial_suspend"), new MutableArrayRef<Expr /*P*/ >(None, true));
  // FIXME: Support operator co_await here.
  if (!InitialSuspend.isInvalid()) {
    InitialSuspend.$assignMove($this().BuildCoawaitExpr(new SourceLocation(Loc), InitialSuspend.get()));
  }
  InitialSuspend.$assignMove($this().ActOnFinishFullExpr(InitialSuspend.get()));
  if (InitialSuspend.isInvalid()) {
    FD.setInvalidDecl();
    /*JAVA:return*/return;
  }
  
  // Form and check implicit 'co_await p.final_suspend();' statement.
  ActionResultTTrue<Expr /*P*/ > FinalSuspend = SemaCoroutineStatics.buildPromiseCall(/*Deref*/$this(), Fn, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"final_suspend"), new MutableArrayRef<Expr /*P*/ >(None, true));
  // FIXME: Support operator co_await here.
  if (!FinalSuspend.isInvalid()) {
    FinalSuspend.$assignMove($this().BuildCoawaitExpr(new SourceLocation(Loc), FinalSuspend.get()));
  }
  FinalSuspend.$assignMove($this().ActOnFinishFullExpr(FinalSuspend.get()));
  if (FinalSuspend.isInvalid()) {
    FD.setInvalidDecl();
    /*JAVA:return*/return;
  }
  
  // FIXME: Perform analysis of set_exception call.
  
  // FIXME: Try to form 'p.return_void();' expression statement to handle
  // control flowing off the end of the coroutine.
  
  // Build implicit 'p.get_return_object()' expression and form initialization
  // of return type from it.
  ActionResultTTrue<Expr /*P*/ > ReturnObject = SemaCoroutineStatics.buildPromiseCall(/*Deref*/$this(), Fn, new SourceLocation(Loc), new StringRef(/*KEEP_STR*/"get_return_object"), new MutableArrayRef<Expr /*P*/ >(None, true));
  if (ReturnObject.isInvalid()) {
    FD.setInvalidDecl();
    /*JAVA:return*/return;
  }
  QualType RetType = FD.getReturnType();
  if (!RetType.$arrow().isDependentType()) {
    InitializedEntity Entity = InitializedEntity.InitializeResult(new SourceLocation(Loc), new QualType(RetType), false);
    ReturnObject.$assignMove($this().PerformMoveOrCopyInitialization(Entity, (/*const*/ VarDecl /*P*/ )null, new QualType(RetType), 
            ReturnObject.get()));
    if (ReturnObject.isInvalid()) {
      FD.setInvalidDecl();
      /*JAVA:return*/return;
    }
  }
  ReturnObject.$assignMove($this().ActOnFinishFullExpr(ReturnObject.get(), new SourceLocation(Loc)));
  if (ReturnObject.isInvalid()) {
    FD.setInvalidDecl();
    /*JAVA:return*/return;
  }
  
  // FIXME: Perform move-initialization of parameters into frame-local copies.
  SmallVector<Expr /*P*/ > ParamMoves/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
  
  // Build body for the coroutine wrapper statement.
  Body.$set(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CoroutineBodyStmt(Body.$deref(), PromiseStmt.get(), InitialSuspend.get(), FinalSuspend.get(), 
              /*SetException*/ (Stmt /*P*/ )null, /*Fallthrough*/ (Stmt /*P*/ )null, 
              ReturnObject.get(), new ArrayRef<Expr /*P*/ >(ParamMoves, true));
   }));
}

} // END OF class Sema_SemaCoroutine
