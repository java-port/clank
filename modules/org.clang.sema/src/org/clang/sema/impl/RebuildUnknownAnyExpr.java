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

import org.clank.support.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


/// A visitor for rebuilding an expression of type __unknown_anytype
/// into one which resolves the type directly on the referring
/// expression.  Strict preservation of the original source
/// structure is not a goal.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14525,
 FQN="(anonymous namespace)::RebuildUnknownAnyExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExprE")
//</editor-fold>
public class/*struct*/ RebuildUnknownAnyExpr implements StmtVisitor<RebuildUnknownAnyExpr, ActionResultTTrue<Expr /*P*/ > > {
  
  public final Sema /*&*/ S;
  
  /// The current destination type.
  public QualType DestType;
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::RebuildUnknownAnyExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14533,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::RebuildUnknownAnyExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExprC1ERN5clang4SemaENS1_8QualTypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExprC1ERN5clang4SemaENS1_8QualTypeE")
  //</editor-fold>
  public RebuildUnknownAnyExpr(final Sema /*&*/ S, QualType CastType) {
    // : StmtVisitor<RebuildUnknownAnyExpr, ExprResult>(), S(S), DestType(CastType) 
    //START JInit
    $StmtVisitor();
    this./*&*/S=/*&*/S;
    this.DestType = new QualType(CastType);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitStmt">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14536,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitStmt", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr9VisitStmtEPN5clang4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr9VisitStmtEPN5clang4StmtE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitStmt(Stmt /*P*/ S) {
    throw new llvm_unreachable("unexpected statement!");
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14540,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr9VisitExprEPN5clang4ExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr9VisitExprEPN5clang4ExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitExpr(Expr /*P*/ E) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_unsupported_unknown_any_expr)), 
          E.getSourceRange()));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }

  
  
  /// Rebuilds a call expression which yielded __unknown_anytype.
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitCallExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14604,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitCallExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr13VisitCallExprEPN5clang8CallExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr13VisitCallExprEPN5clang8CallExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitCallExpr(CallExpr /*P*/ E) {
    Expr /*P*/ CalleeExpr = E.getCallee();
    
    final class/*enum*/ FnKind {
      private static final /*uint*/int FK_MemberFunction = 0;
      private static final /*uint*/int FK_FunctionPointer = FK_MemberFunction + 1;
      private static final /*uint*/int FK_BlockPointer = FK_FunctionPointer + 1;
    };
    
    /*FnKind*//*uint*/int Kind;
    QualType CalleeType = CalleeExpr.getType();
    if ($eq_QualType$C(CalleeType, S.Context.BoundMemberTy.$QualType())) {
      assert (isa_CXXMemberCallExpr(E) || isa_CXXOperatorCallExpr(E));
      Kind = FnKind.FK_MemberFunction;
      CalleeType.$assignMove(Expr.findBoundMemberType(CalleeExpr));
    } else {
      /*const*/ PointerType /*P*/ Ptr = CalleeType.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        CalleeType.$assignMove(Ptr.getPointeeType());
        Kind = FnKind.FK_FunctionPointer;
      } else {
        CalleeType.$assignMove(CalleeType.$arrow().castAs(BlockPointerType.class).getPointeeType());
        Kind = FnKind.FK_BlockPointer;
      }
    }
    /*const*/ FunctionType /*P*/ FnType = CalleeType.$arrow().castAs(FunctionType.class);
    
    // Verify that this is a legal result type of a function.
    if (DestType.$arrow().isArrayType() || DestType.$arrow().isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int diagID = diag.err_func_returning_array_function;
        if (Kind == FnKind.FK_BlockPointer) {
          diagID = diag.err_block_returning_array_function;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diagID)), 
                DestType.$arrow().isFunctionType()), DestType));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Otherwise, go ahead and set DestType as the call's result.
    E.setType(DestType.getNonLValueExprType(S.Context));
    E.setValueKind(Expr.getValueKindForType(new QualType(DestType)));
    assert (E.getObjectKind() == ExprObjectKind.OK_Ordinary);
    
    // Rebuild the function type, replacing the result type with DestType.
    /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(FnType);
    if ((Proto != null)) {
      // __unknown_anytype(...) is a special case used by the debugger when
      // it has no idea what a function's signature is.
      //
      // We want to build this call essentially under the K&R
      // unprototyped rules, but making a FunctionNoProtoType in C++
      // would foul up all sorts of assumptions.  However, we cannot
      // simply pass all arguments as variadic arguments, nor can we
      // portably just call the function under a non-variadic type; see
      // the comment on IR-gen's TargetInfo::isNoProtoCallVariadic.
      // However, it turns out that in practice it is generally safe to
      // call a function declared as "A foo(B,C,D);" under the prototype
      // "A foo(B,C,D,...);".  The only known exception is with the
      // Windows ABI, where any variadic function is implicitly cdecl
      // regardless of its normal CC.  Therefore we change the parameter
      // types to match the types of the arguments.
      //
      // This is a hack, but it is far superior to moving the
      // corresponding target-specific code from IR-gen to Sema/AST.
      ArrayRef<QualType> ParamTypes = Proto.getParamTypes();
      SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(8, new QualType());
      if (ParamTypes.empty() && Proto.isVariadic()) { // the special case
        ArgTypes.reserve(E.getNumArgs());
        for (/*uint*/int i = 0, e = E.getNumArgs(); i != e; ++i) {
          Expr /*P*/ Arg = E.getArg(i);
          QualType ArgType = Arg.getType();
          if (E.isLValue()) {
            ArgType.$assignMove(S.Context.getLValueReferenceType(new QualType(ArgType)));
          } else if (E.isXValue()) {
            ArgType.$assignMove(S.Context.getRValueReferenceType(new QualType(ArgType)));
          }
          ArgTypes.push_back(ArgType);
        }
        ParamTypes.$assignMove(new ArrayRef<QualType>(ArgTypes, false));
      }
      DestType.$assignMove(S.Context.getFunctionType(new QualType(DestType), new ArrayRef<QualType>(ParamTypes), 
              Proto.getExtProtoInfo()));
    } else {
      DestType.$assignMove(S.Context.getFunctionNoProtoType(new QualType(DestType), 
              FnType.getExtInfo()));
    }
    
    // Rebuild the appropriate pointer-to-function type.
    switch (Kind) {
     case FnKind.FK_MemberFunction:
      // Nothing to do.
      break;
     case FnKind.FK_FunctionPointer:
      DestType.$assignMove(S.Context.getPointerType(new QualType(DestType)));
      break;
     case FnKind.FK_BlockPointer:
      DestType.$assignMove(S.Context.getBlockPointerType(new QualType(DestType)));
      break;
    }
    
    // Finally, we can recurse.
    ActionResultTTrue<Expr /*P*/ > CalleeResult = Visit(CalleeExpr);
    if (!CalleeResult.isUsable()) {
      return ExprError();
    }
    E.setCallee(CalleeResult.get());
    
    // Bind a temporary if necessary.
    return S.MaybeBindToTemporary(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitObjCMessageExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14713,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitObjCMessageExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr20VisitObjCMessageExprEPN5clang15ObjCMessageExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr20VisitObjCMessageExprEPN5clang15ObjCMessageExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitObjCMessageExpr(ObjCMessageExpr /*P*/ E) {
    // Verify that this is a legal result type of a call.
    if (DestType.$arrow().isArrayType() || DestType.$arrow().isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_func_returning_array_function)), 
                DestType.$arrow().isFunctionType()), DestType));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      // Rewrite the method result type if available.
      ObjCMethodDecl /*P*/ Method = E.getMethodDecl();
      if ((Method != null)) {
        assert ($eq_QualType$C(Method.getReturnType(), S.Context.UnknownAnyTy.$QualType()));
        Method.setReturnType(new QualType(DestType));
      }
    }
    
    // Change the type of the message.
    E.setType(DestType.getNonReferenceType());
    E.setValueKind(Expr.getValueKindForType(new QualType(DestType)));
    
    return S.MaybeBindToTemporary(E);
  }

  
  /// Rebuild an expression which simply semantically wraps another
  /// expression which it shares the type and value kind of.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::rebuildSugarExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14551,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::rebuildSugarExpr", NM="Tpl__ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16rebuildSugarExprEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=Tpl__ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16rebuildSugarExprEPT_")
  //</editor-fold>
  public </*class*/ T extends Expr> ActionResultTTrue<Expr /*P*/ > rebuildSugarExpr(T /*P*/ E) {
    throw new UnsupportedOperationException("Specialization must be used. Or generate new specialization");
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14551,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::rebuildSugarExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16rebuildSugarExprIN5clang9ParenExprEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16rebuildSugarExprIN5clang9ParenExprEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > rebuildSugarExpr(ParenExpr /*P*/ E) {
    ActionResultTTrue<Expr /*P*/ > SubResult = Visit(E.getSubExpr());
    if (SubResult.isInvalid()) {
      return ExprError();
    }
    Expr /*P*/ SubExpr = SubResult.get();
    E.setSubExpr(SubExpr);
    E.setType(SubExpr.getType());
    E.setValueKind(SubExpr.getValueKind());
    assert Native.$bool(Native.$eq(E.getObjectKind(), ExprObjectKind.OK_Ordinary));
    return new ActionResultTTrue<Expr>(JD$T.INSTANCE , E);
  }

  @Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14551,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::rebuildSugarExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16rebuildSugarExprIN5clang13UnaryOperatorEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16rebuildSugarExprIN5clang13UnaryOperatorEEENS2_12ActionResultIPNS2_4ExprELb1EEEPT_")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > rebuildSugarExpr(UnaryOperator /*P*/ E) {
    ActionResultTTrue<Expr /*P*/ > SubResult = Visit(E.getSubExpr());
    if (SubResult.isInvalid()) {
      return ExprError();
    }
    Expr /*P*/ SubExpr = SubResult.get();
    E.setSubExpr(SubExpr);
    E.setType(SubExpr.getType());
    E.setValueKind(SubExpr.getValueKind());
    assert Native.$bool(Native.$eq(E.getObjectKind(), ExprObjectKind.OK_Ordinary));
    return new ActionResultTTrue<Expr>(JD$T.INSTANCE , E);
  }
  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitParenExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14562,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitParenExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr14VisitParenExprEPN5clang9ParenExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr14VisitParenExprEPN5clang9ParenExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitParenExpr(ParenExpr /*P*/ E) {
    return rebuildSugarExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitUnaryExtension">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14566,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitUnaryExtension", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr19VisitUnaryExtensionEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr19VisitUnaryExtensionEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitUnaryExtension(UnaryOperator /*P*/ E) {
    return rebuildSugarExpr(E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitUnaryAddrOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14570,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitUnaryAddrOf", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16VisitUnaryAddrOfEPN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16VisitUnaryAddrOfEPN5clang13UnaryOperatorE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitUnaryAddrOf(UnaryOperator /*P*/ E) {
    /*const*/ PointerType /*P*/ Ptr = DestType.$arrow().getAs(PointerType.class);
    if (!(Ptr != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getOperatorLoc(), diag.err_unknown_any_addrof)), 
            E.getSourceRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    assert (E.getValueKind() == ExprValueKind.VK_RValue);
    assert (E.getObjectKind() == ExprObjectKind.OK_Ordinary);
    E.setType(new QualType(DestType));
    
    // Build the sub-expression as if it were an object of the pointee type.
    DestType.$assignMove(Ptr.getPointeeType());
    ActionResultTTrue<Expr /*P*/ > SubResult = Visit(E.getSubExpr());
    if (SubResult.isInvalid()) {
      return ExprError();
    }
    E.setSubExpr(SubResult.get());
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitImplicitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14734,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitImplicitCastExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr21VisitImplicitCastExprEPN5clang16ImplicitCastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr21VisitImplicitCastExprEPN5clang16ImplicitCastExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitImplicitCastExpr(ImplicitCastExpr /*P*/ E) {
    // The only case we should ever see here is a function-to-pointer decay.
    if (E.getCastKind() == CastKind.CK_FunctionToPointerDecay) {
      assert (E.getValueKind() == ExprValueKind.VK_RValue);
      assert (E.getObjectKind() == ExprObjectKind.OK_Ordinary);
      
      E.setType(new QualType(DestType));
      
      // Rebuild the sub-expression as the pointee (function) type.
      DestType.$assignMove(DestType.$arrow().castAs(PointerType.class).getPointeeType());
      
      ActionResultTTrue<Expr /*P*/ > Result = Visit(E.getSubExpr());
      if (!Result.isUsable()) {
        return ExprError();
      }
      
      E.setSubExpr(Result.get());
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    } else if (E.getCastKind() == CastKind.CK_LValueToRValue) {
      assert (E.getValueKind() == ExprValueKind.VK_RValue);
      assert (E.getObjectKind() == ExprObjectKind.OK_Ordinary);
      assert (isa_BlockPointerType(E.getType()));
      
      E.setType(new QualType(DestType));
      
      // The sub-expression has to be a lvalue reference, so rebuild it as such.
      DestType.$assignMove(S.Context.getLValueReferenceType(new QualType(DestType)));
      
      ActionResultTTrue<Expr /*P*/ > Result = Visit(E.getSubExpr());
      if (!Result.isUsable()) {
        return ExprError();
      }
      
      E.setSubExpr(Result.get());
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    } else {
      throw new llvm_unreachable("Unhandled cast type!");
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::resolveDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14771,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::resolveDecl", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr11resolveDeclEPN5clang4ExprEPNS1_9ValueDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr11resolveDeclEPN5clang4ExprEPNS1_9ValueDeclE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > resolveDecl(Expr /*P*/ E, ValueDecl /*P*/ VD) {
    ExprValueKind ValueKind = ExprValueKind.VK_LValue;
    QualType Type = new QualType(DestType);
    {
      
      // We know how to make this work for certain kinds of decls:
      
      //  - functions
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(VD);
      if ((FD != null)) {
        {
          /*const*/ PointerType /*P*/ Ptr = Type.$arrow().getAs(PointerType.class);
          if ((Ptr != null)) {
            DestType.$assignMove(Ptr.getPointeeType());
            ActionResultTTrue<Expr /*P*/ > Result = resolveDecl(E, VD);
            if (Result.isInvalid()) {
              return ExprError();
            }
            return S.ImpCastExprToType(Result.get(), new QualType(Type), 
                CastKind.CK_FunctionToPointerDecay, ExprValueKind.VK_RValue);
          }
        }
        if (!Type.$arrow().isFunctionType()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_unknown_any_function)), 
                    VD), E.getSourceRange()));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
        {
          /*const*/ FunctionProtoType /*P*/ FT = Type.$arrow().getAs(FunctionProtoType.class);
          if ((FT != null)) {
            // We must match the FunctionDecl's type to the hack introduced in
            // RebuildUnknownAnyExpr::VisitCallExpr to vararg functions of unknown
            // type. See the lengthy commentary in that routine.
            QualType FDT = FD.getType();
            /*const*/ FunctionType /*P*/ FnType = FDT.$arrow().castAs(FunctionType.class);
            /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_or_null_FunctionProtoType(FnType);
            DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
            if ((DRE != null) && (Proto != null) && Proto.getParamTypes().empty() && Proto.isVariadic()) {
              SourceLocation Loc = FD.getLocation();
              FunctionDecl /*P*/ NewFD = FunctionDecl.Create(FD.getASTContext(), 
                  FD.getDeclContext(), 
                  new SourceLocation(Loc), new SourceLocation(Loc), FD.getNameInfo().getName(), 
                  new QualType(DestType), FD.getTypeSourceInfo(), 
                  StorageClass.SC_None, false/*isInlineSpecified*/, 
                  FD.hasPrototype(), 
                  false/*isConstexprSpecified*/);
              if ((FD.getQualifier() != null)) {
                NewFD.setQualifierInfo(FD.getQualifierLoc());
              }
              
              SmallVector<ParmVarDecl /*P*/ > Params/*J*/= new SmallVector<ParmVarDecl /*P*/ >(16, (ParmVarDecl /*P*/ )null);
              for (final /*const*/ QualType /*&*/ AI : FT.param_types()) {
                ParmVarDecl /*P*/ Param = S.BuildParmVarDeclForTypedef(FD, new SourceLocation(Loc), new QualType(AI));
                Param.setScopeInfo(0, Params.size());
                Params.push_back(Param);
              }
              NewFD.setParams(new ArrayRef<ParmVarDecl /*P*/ >(Params, true));
              DRE.setDecl(NewFD);
              VD = DRE.getDecl();
            }
          }
        }
        {
          
          CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(FD);
          if ((MD != null)) {
            if (MD.isInstance()) {
              ValueKind = ExprValueKind.VK_RValue;
              Type.$assignMove(S.Context.BoundMemberTy.$QualType());
            }
          }
        }
        
        // Function references aren't l-values in C.
        if (!S.getLangOpts().CPlusPlus) {
          ValueKind = ExprValueKind.VK_RValue;
        }
        //  - variables
      } else if (isa_VarDecl(VD)) {
        {
          /*const*/ ReferenceType /*P*/ RefTy = Type.$arrow().getAs(ReferenceType.class);
          if ((RefTy != null)) {
            Type.$assignMove(RefTy.getPointeeType());
          } else if (Type.$arrow().isFunctionType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_unknown_any_var_function_type)), 
                      VD), E.getSourceRange()));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
        }
        //  - nothing else
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(E.getExprLoc(), diag.err_unsupported_unknown_any_decl)), 
                  VD), E.getSourceRange()));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Modifying the declaration like this is friendly to IR-gen but
    // also really dangerous.
    VD.setType(new QualType(DestType));
    E.setType(new QualType(Type));
    E.setValueKind(ValueKind);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14593,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitMemberExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr15VisitMemberExprEPN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr15VisitMemberExprEPN5clang10MemberExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitMemberExpr(MemberExpr /*P*/ E) {
    return resolveDecl(E, E.getMemberDecl());
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::RebuildUnknownAnyExpr::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp", line = 14597,
   FQN="(anonymous namespace)::RebuildUnknownAnyExpr::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16VisitDeclRefExprEPN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExpr.cpp -nm=_ZN12_GLOBAL__N_121RebuildUnknownAnyExpr16VisitDeclRefExprEPN5clang11DeclRefExprE")
  //</editor-fold>
  public ActionResultTTrue<Expr /*P*/ > VisitDeclRefExpr(DeclRefExpr /*P*/ E) {
    return resolveDecl(E, E.getDecl());
  }

  
  @Override public String toString() {
    return "" + "S=" + "[Sema]" // NOI18N
              + ", DestType=" + DestType // NOI18N
              + super.toString(); // NOI18N
  }
}
