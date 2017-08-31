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
package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaCoroutineStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL15buildMemberCallRN5clang4SemaEPNS_4ExprENS_14SourceLocationEN4llvm9StringRefENS5_15MutableArrayRefIS3_EE;_ZL16buildPromiseCallRN5clang4SemaEPNS_4sema17FunctionScopeInfoENS_14SourceLocationEN4llvm9StringRefENS6_15MutableArrayRefIPNS_4ExprEEE;_ZL17buildCoawaitCallsRN5clang4SemaENS_14SourceLocationEPNS_4ExprE;_ZL17lookupPromiseTypeRN5clang4SemaEPKNS_17FunctionProtoTypeENS_14SourceLocationE;_ZL21checkCoroutineContextRN5clang4SemaENS_14SourceLocationEN4llvm9StringRefE;_ZL24buildOperatorCoawaitCallRN5clang4SemaEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE; -static-type=SemaCoroutineStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaCoroutineStatics {


/// Look up the std::coroutine_traits<...>::promise_type for the given
/// function type.
//<editor-fold defaultstate="collapsed" desc="lookupPromiseType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 26,
 FQN="lookupPromiseType", NM="_ZL17lookupPromiseTypeRN5clang4SemaEPKNS_17FunctionProtoTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL17lookupPromiseTypeRN5clang4SemaEPKNS_17FunctionProtoTypeENS_14SourceLocationE")
//</editor-fold>
public static QualType lookupPromiseType(final Sema /*&*/ S, /*const*/ FunctionProtoType /*P*/ FnType, 
                 SourceLocation Loc) {
  LookupResult Result = null;
  TemplateArgumentListInfo Args = null;
  LookupResult R = null;
  try {
    // FIXME: Cache std::coroutine_traits once we've found it.
    NamespaceDecl /*P*/ Std = S.getStdNamespace();
    if (!(Std != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_implied_std_coroutine_traits_not_found)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    Result/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"coroutine_traits")))), 
        new SourceLocation(Loc), Sema.LookupNameKind.LookupOrdinaryName);
    if (!S.LookupQualifiedName(Result, Std)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), diag.err_implied_std_coroutine_traits_not_found)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    ClassTemplateDecl /*P*/ CoroTraits = Result.<ClassTemplateDecl>getAsSingle(ClassTemplateDecl.class);
    if (!(CoroTraits != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Result.suppressDiagnostics();
        // We found something weird. Complain about the first thing we found.
        NamedDecl /*P*/ Found = Result.begin().$star();
        $c$.clean($c$.track(S.Diag(Found.getLocation(), diag.err_malformed_std_coroutine_traits)));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Form template argument list for coroutine_traits<R, P1, P2, ...>.
    Args/*J*/= new TemplateArgumentListInfo(new SourceLocation(Loc), new SourceLocation(Loc));
    Args.addArgument(new TemplateArgumentLoc(new TemplateArgument(FnType.getReturnType()), 
            S.Context.getTrivialTypeSourceInfo(FnType.getReturnType(), new SourceLocation(Loc))));
    // FIXME: If the function is a non-static member function, add the type
    // of the implicit object parameter before the formal parameters.
    for (QualType T : FnType.getParamTypes())  {
      Args.addArgument(new TemplateArgumentLoc(new TemplateArgument(new QualType(T)), S.Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(Loc))));
    }
    
    // Build the template-id.
    QualType CoroTrait = S.CheckTemplateIdType(new TemplateName(CoroTraits), new SourceLocation(Loc), Args);
    if (CoroTrait.isNull()) {
      return new QualType();
    }
    if (S.RequireCompleteType(new SourceLocation(Loc), new QualType(CoroTrait), 
        diag.err_coroutine_traits_missing_specialization)) {
      return new QualType();
    }
    
    CXXRecordDecl /*P*/ RD = CoroTrait.$arrow().getAsCXXRecordDecl();
    assert ((RD != null)) : "specialization of class template is not a class?";
    
    // Look up the ::promise_type member.
    R/*J*/= new LookupResult(S, new DeclarationName($AddrOf(S.PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"promise_type")))), new SourceLocation(Loc), 
        Sema.LookupNameKind.LookupOrdinaryName);
    S.LookupQualifiedName(R, RD);
    TypeDecl /*P*/ Promise = R.<TypeDecl>getAsSingle(TypeDecl.class);
    if (!(Promise != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_implied_std_coroutine_traits_promise_type_not_found)), 
            RD));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    // The promise type is required to be a class type.
    QualType PromiseType = S.Context.getTypeDeclType(Promise);
    if (!(PromiseType.$arrow().getAsCXXRecordDecl() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Use the fully-qualified name of the type.
        NestedNameSpecifier /*P*/ NNS = NestedNameSpecifier.Create(S.Context, (NestedNameSpecifier /*P*/ )null, Std);
        NNS = NestedNameSpecifier.Create(S.Context, NNS, false, 
            CoroTrait.getTypePtr());
        PromiseType.$assignMove(S.Context.getElaboratedType(ElaboratedTypeKeyword.ETK_None, NNS, new QualType(PromiseType)));
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_implied_std_coroutine_traits_promise_type_not_class)), 
            PromiseType));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    return PromiseType;
  } finally {
    if (R != null) { R.$destroy(); }
    if (Args != null) { Args.$destroy(); }
    if (Result != null) { Result.$destroy(); }
  }
}


/// Check that this is a context in which a coroutine suspension can appear.
//<editor-fold defaultstate="collapsed" desc="checkCoroutineContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 103,
 FQN="checkCoroutineContext", NM="_ZL21checkCoroutineContextRN5clang4SemaENS_14SourceLocationEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL21checkCoroutineContextRN5clang4SemaENS_14SourceLocationEN4llvm9StringRefE")
//</editor-fold>
public static FunctionScopeInfo /*P*/ checkCoroutineContext(final Sema /*&*/ S, SourceLocation Loc, StringRef Keyword) {
  // 'co_await' and 'co_yield' are not permitted in unevaluated operands.
  if (S.isUnevaluatedContext()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_coroutine_unevaluated_context)), Keyword));
      return null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Any other usage must be within a function.
  // FIXME: Reject a coroutine with a deduced return type.
  FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(S.CurContext);
  if (!(FD != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), isa_ObjCMethodDecl(S.CurContext) ? diag.err_coroutine_objc_method : diag.err_coroutine_outside_function)), Keyword));
    } finally {
      $c$.$destroy();
    }
  } else if (isa_CXXConstructorDecl(FD) || isa_CXXDestructorDecl(FD)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Coroutines TS [special]/6:
      //   A special member function shall not be a coroutine.
      //
      // FIXME: We assume that this really means that a coroutine cannot
      //        be a constructor or destructor.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_coroutine_ctor_dtor)), 
              isa_CXXDestructorDecl(FD)), Keyword));
    } finally {
      $c$.$destroy();
    }
  } else if (FD.isConstexpr()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_coroutine_constexpr)), Keyword));
    } finally {
      $c$.$destroy();
    }
  } else if (FD.isVariadic()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_coroutine_varargs)), Keyword));
    } finally {
      $c$.$destroy();
    }
  } else {
    FunctionScopeInfo /*P*/ ScopeInfo = S.getCurFunction();
    assert ((ScopeInfo != null)) : "missing function scope for function";
    
    // If we don't have a promise variable, build one now.
    if (!(ScopeInfo.CoroutinePromise != null)) {
      QualType T = FD.getType().$arrow().isDependentType() ? S.Context.DependentTy.$QualType() : lookupPromiseType(S, FD.getType().$arrow().castAs(FunctionProtoType.class), 
          new SourceLocation(Loc));
      if (T.isNull()) {
        return null;
      }
      
      // Create and default-initialize the promise.
      ScopeInfo.CoroutinePromise
         = VarDecl.Create(S.Context, FD, FD.getLocation(), FD.getLocation(), 
          $AddrOf(S.PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"__promise"))), new QualType(T), 
          S.Context.getTrivialTypeSourceInfo(new QualType(T), new SourceLocation(Loc)), StorageClass.SC_None);
      S.CheckVariableDeclarationType(ScopeInfo.CoroutinePromise);
      if (!ScopeInfo.CoroutinePromise.isInvalidDecl()) {
        S.ActOnUninitializedDecl(ScopeInfo.CoroutinePromise, false);
      }
    }
    
    return ScopeInfo;
  }
  
  return null;
}


/// Build a call to 'operator co_await' if there is a suitable operator for
/// the given expression.
//<editor-fold defaultstate="collapsed" desc="buildOperatorCoawaitCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 162,
 FQN="buildOperatorCoawaitCall", NM="_ZL24buildOperatorCoawaitCallRN5clang4SemaEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL24buildOperatorCoawaitCallRN5clang4SemaEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > buildOperatorCoawaitCall(final Sema /*&*/ SemaRef, Scope /*P*/ S, 
                        SourceLocation Loc, Expr /*P*/ E) {
  UnresolvedSet Functions/*J*/= new UnresolvedSet(16);
  SemaRef.LookupOverloadedOperatorName(OverloadedOperatorKind.OO_Coawait, S, E.getType(), new QualType(), 
      Functions);
  return SemaRef.CreateOverloadedUnaryOp(new SourceLocation(Loc), UnaryOperatorKind.UO_Coawait, Functions, E);
}

//<editor-fold defaultstate="collapsed" desc="buildMemberCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 175,
 FQN="buildMemberCall", NM="_ZL15buildMemberCallRN5clang4SemaEPNS_4ExprENS_14SourceLocationEN4llvm9StringRefENS5_15MutableArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL15buildMemberCallRN5clang4SemaEPNS_4ExprENS_14SourceLocationEN4llvm9StringRefENS5_15MutableArrayRefIS3_EE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > buildMemberCall(final Sema /*&*/ S, Expr /*P*/ Base, SourceLocation Loc, 
               StringRef Name, 
               MutableArrayRef<Expr /*P*/ > Args) {
  CXXScopeSpec SS = null;
  try {
    DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName($AddrOf(S.PP.getIdentifierTable().get(/*NO_COPY*/Name))), new SourceLocation(Loc));
    
    // FIXME: Fix BuildMemberReferenceExpr to take a const CXXScopeSpec&.
    SS/*J*/= new CXXScopeSpec();
    ActionResultTTrue<Expr /*P*/ > Result = S.BuildMemberReferenceExpr1(Base, Base.getType(), new SourceLocation(Loc), /*IsPtr=*/ false, SS, 
        new SourceLocation(), (NamedDecl /*P*/ )null, NameInfo, /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, 
        /*Scope=*/ (/*const*/ Scope /*P*/ )null);
    if (Result.isInvalid()) {
      return ExprError();
    }
    
    return S.ActOnCallExpr((Scope /*P*/ )null, Result.get(), new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(Args), new SourceLocation(Loc), (Expr /*P*/ )null);
  } finally {
    if (SS != null) { SS.$destroy(); }
  }
}


/// Build calls to await_ready, await_suspend, and await_resume for a co_await
/// expression.
//<editor-fold defaultstate="collapsed" desc="buildCoawaitCalls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 194,
 FQN="buildCoawaitCalls", NM="_ZL17buildCoawaitCallsRN5clang4SemaENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL17buildCoawaitCallsRN5clang4SemaENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public static ReadySuspendResumeResult buildCoawaitCalls(final Sema /*&*/ S, SourceLocation Loc, 
                 Expr /*P*/ E) {
  // Assume invalid until we see otherwise.
  ReadySuspendResumeResult Calls = new ReadySuspendResumeResult(true);
  
  /*const*/ StringRef Funcs[/*3*/] = new /*const*/ StringRef [/*3*/] {new StringRef($("await_ready")), new StringRef($("await_suspend")), new StringRef($("await_resume"))};
  for (/*size_t*/int I = 0, N = llvm.array_lengthof(Funcs); I != N; ++I) {
    Expr /*P*/ Operand = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new OpaqueValueExpr(new SourceLocation(Loc), E.getType(), ExprValueKind.VK_LValue, E.getObjectKind(), E));
    
    // FIXME: Pass coroutine handle to await_suspend.
    ActionResultTTrue<Expr /*P*/ > Result = buildMemberCall(S, Operand, new SourceLocation(Loc), new StringRef(Funcs[I]), MutableArrayRef.<Expr>None());
    if (Result.isInvalid()) {
      return Calls;
    }
    Calls.Results[I] = Result.get();
  }
  
  Calls.IsInvalid = false;
  return Calls;
}

//<editor-fold defaultstate="collapsed" desc="buildPromiseCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp", line = 260,
 FQN="buildPromiseCall", NM="_ZL16buildPromiseCallRN5clang4SemaEPNS_4sema17FunctionScopeInfoENS_14SourceLocationEN4llvm9StringRefENS6_15MutableArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCoroutine.cpp -nm=_ZL16buildPromiseCallRN5clang4SemaEPNS_4sema17FunctionScopeInfoENS_14SourceLocationEN4llvm9StringRefENS6_15MutableArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > buildPromiseCall(final Sema /*&*/ S, FunctionScopeInfo /*P*/ Coroutine, 
                SourceLocation Loc, StringRef Name, 
                MutableArrayRef<Expr /*P*/ > Args) {
  assert ((Coroutine.CoroutinePromise != null)) : "no promise for coroutine";
  
  // Form a reference to the promise.
  VarDecl /*P*/ Promise = Coroutine.CoroutinePromise;
  ActionResultTTrue<Expr /*P*/ > PromiseRef = S.BuildDeclRefExpr(Promise, Promise.getType().getNonReferenceType(), ExprValueKind.VK_LValue, new SourceLocation(Loc));
  if (PromiseRef.isInvalid()) {
    return ExprError();
  }
  
  // Call 'yield_value', passing in E.
  return buildMemberCall(S, PromiseRef.get(), new SourceLocation(Loc), new StringRef(Name), new MutableArrayRef<Expr /*P*/ >(Args));
}

} // END OF class SemaCoroutineStatics
