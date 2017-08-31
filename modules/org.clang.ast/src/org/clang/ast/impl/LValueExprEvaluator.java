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

package org.clang.ast.impl;

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import org.clang.ast.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.impl.ExprConstantStatics.*;

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4705,
 FQN="(anonymous namespace)::LValueExprEvaluator", NM="_ZN12_GLOBAL__N_119LValueExprEvaluatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluatorE")
//</editor-fold>
public class LValueExprEvaluator extends /*public*/ LValueExprEvaluatorBase<LValueExprEvaluator> {
/*public:*/
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::LValueExprEvaluator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4708,
   FQN="(anonymous namespace)::LValueExprEvaluator::LValueExprEvaluator", NM="_ZN12_GLOBAL__N_119LValueExprEvaluatorC1ERNS_8EvalInfoERNS_6LValueE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluatorC1ERNS_8EvalInfoERNS_6LValueE")
  //</editor-fold>
  public LValueExprEvaluator(final EvalInfo /*&*/ Info, final LValue /*&*/ Result) {
    // : LValueExprEvaluatorBaseTy(Info, Result) 
    //START JInit
    super(Info, Result);
    //END JInit
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitVarDecl">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4776,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitVarDecl", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator12VisitVarDeclEPKN5clang4ExprEPKNS1_7VarDeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator12VisitVarDeclEPKN5clang4ExprEPKNS1_7VarDeclE")
  //</editor-fold>
  public boolean VisitVarDecl(/*const*/ Expr /*P*/ E, /*const*/ VarDecl /*P*/ VD) {
    CallStackFrame /*P*/ Frame = null;
    if (VD.hasLocalStorage() && $greater_uint(Info.CurrentCall.Index, 1)) {
      Frame = Info.CurrentCall;
    }
    if (!VD.getType().$arrow().isReferenceType()) {
      if ((Frame != null)) {
        Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, VD), Frame.Index);
        return true;
      }
      return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, VD));
    }
    
    type$ref<APValue /*P*/ > V = create_type$ref();
    if (!evaluateVarDeclInit(Info, E, VD, Frame, V)) {
      return false;
    }
    if (V.$deref().isUninit()) {
      if (!Info.checkingPotentialConstantExpression()) {
        Info.FFDiag(E, diag.note_constexpr_use_uninit_reference);
      }
      return false;
    }
    return Success($Deref(V.$deref()), E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitUnaryPreIncDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4945,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitUnaryPreIncDec", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator19VisitUnaryPreIncDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator19VisitUnaryPreIncDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPreIncDec(/*const*/ UnaryOperator /*P*/ UO) {
    if (!Info.getLangOpts().CPlusPlus14 && !Info.keepEvaluatingAfterFailure()) {
      return Error(UO);
    }
    if (!this.Visit(UO.getSubExpr())) {
      return false;
    }
    
    return handleIncDec(this.Info, UO, Result, UO.getSubExpr().getType(), 
        UO.isIncrementOp(), (APValue /*P*/ )null);
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitDeclRefExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4768,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitDeclRefExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator16VisitDeclRefExprEPKN5clang11DeclRefExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator16VisitDeclRefExprEPKN5clang11DeclRefExprE")
  //</editor-fold>
  public boolean VisitDeclRefExpr(/*const*/ DeclRefExpr /*P*/ E) {
    {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(E.getDecl$Const());
      if ((FD != null)) {
        return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, FD));
      }
    }
    {
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(E.getDecl$Const());
      if ((VD != null)) {
        return VisitVarDecl(E, VD);
      }
    }
    return Error(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitPredefinedExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4715,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitPredefinedExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator19VisitPredefinedExprEPKN5clang14PredefinedExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator19VisitPredefinedExprEPKN5clang14PredefinedExprE")
  //</editor-fold>
  public boolean VisitPredefinedExpr(/*const*/ PredefinedExpr /*P*/ E) {
    return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitMaterializeTemporaryExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4800,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitMaterializeTemporaryExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator29VisitMaterializeTemporaryExprEPKN5clang24MaterializeTemporaryExprE")
  //</editor-fold>
  public boolean VisitMaterializeTemporaryExpr(/*const*/ MaterializeTemporaryExpr /*P*/ E) {
    // Walk through the expression to find the materialized temporary itself.
    SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
    SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
    /*const*/ Expr /*P*/ Inner = E.GetTemporaryExpr().
        skipRValueSubobjectAdjustments(CommaLHSs, Adjustments);
    
    // If we passed any comma operators, evaluate their LHSs.
    for (/*uint*/int I = 0, N = CommaLHSs.size(); I != N; ++I)  {
      if (!EvaluateIgnoredValue(Info, CommaLHSs.$at(I))) {
        return false;
      }
    }
    
    // A materialized temporary with static storage duration can appear within the
    // result of a constant expression evaluation, so we need to preserve its
    // value for use outside this evaluation.
    APValue /*P*/ Value;
    if (E.getStorageDuration() == StorageDuration.SD_Static) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Value = Info.Ctx.getMaterializedTemporaryValue(E, true);
        $c$.clean(/*Deref*/Value.$assign($c$.track(new APValue())));
        Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
      } finally {
        $c$.$destroy();
      }
    } else {
      Value = $AddrOf(Info.CurrentCall.
          createTemporary(E, E.getStorageDuration() == StorageDuration.SD_Automatic));
      Result.set(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E), Info.CurrentCall.Index);
    }
    
    QualType Type = Inner.getType();
    
    // Materialize the temporary itself.
    if (!EvaluateInPlace($Deref(Value), Info, Result, Inner)
       || (E.getStorageDuration() == StorageDuration.SD_Static
       && !CheckConstantExpression(Info, E.getExprLoc(), new QualType(Type), $Deref(Value)))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(/*Deref*/Value.$assign($c$.track(new APValue())));
        return false;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Adjust our lvalue to refer to the desired subobject.
    for (/*uint*/int I = Adjustments.size(); I != 0;) {
      --I;
      switch (Adjustments.$at(I).Kind) {
       case DerivedToBaseAdjustment:
        if (!HandleLValueBasePath(Info, Adjustments.$at(I).Unnamed_field1.DerivedToBase.BasePath, 
            new QualType(Type), Result)) {
          return false;
        }
        Type.$assignMove(Adjustments.$at(I).Unnamed_field1.DerivedToBase.BasePath.getType());
        break;
       case FieldAdjustment:
        if (!HandleLValueMember(Info, E, Result, Adjustments.$at(I).Unnamed_field1.Field)) {
          return false;
        }
        Type.$assignMove(Adjustments.$at(I).Unnamed_field1.Field.getType());
        break;
       case MemberPointerAdjustment:
        if (!(HandleMemberPointerAccess(this.Info, new QualType(Type), Result, 
            Adjustments.$at(I).Unnamed_field1.Ptr.RHS) != null)) {
          return false;
        }
        Type.$assignMove(Adjustments.$at(I).Unnamed_field1.Ptr.MPT.getPointeeType());
        break;
      }
    }
    
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitCompoundLiteralExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4866,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitCompoundLiteralExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator24VisitCompoundLiteralExprEPKN5clang19CompoundLiteralExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator24VisitCompoundLiteralExprEPKN5clang19CompoundLiteralExprE")
  //</editor-fold>
  public boolean VisitCompoundLiteralExpr(/*const*/ CompoundLiteralExpr /*P*/ E) {
    assert (!Info.getLangOpts().CPlusPlus) : "lvalue compound literal in c++?";
    // Defer visiting the literal until the lvalue-to-rvalue conversion. We can
    // only see this when folding in C, so there's no standard to follow here.
    return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitMemberExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4888,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitMemberExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator15VisitMemberExprEPKN5clang10MemberExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator15VisitMemberExprEPKN5clang10MemberExprE")
  //</editor-fold>
  public boolean VisitMemberExpr(/*const*/ MemberExpr /*P*/ E) {
    {
      // Handle static data members.
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(E.getMemberDecl());
      if ((VD != null)) {
        VisitIgnoredBaseExpression(E.getBase());
        return VisitVarDecl(E, VD);
      }
    }
    {
      
      // Handle static member functions.
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(E.getMemberDecl());
      if ((MD != null)) {
        if (MD.isStatic()) {
          VisitIgnoredBaseExpression(E.getBase());
          return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T.INSTANCE, /*const*/ ValueDecl /*P*/ .class, MD));
        }
      }
    }
    
    // Handle non-static data members.
    return super.VisitMemberExpr(E);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitStringLiteral">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4719,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitStringLiteral", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator18VisitStringLiteralEPKN5clang13StringLiteralE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator18VisitStringLiteralEPKN5clang13StringLiteralE")
  //</editor-fold>
  public boolean VisitStringLiteral(/*const*/ StringLiteral /*P*/ E) {
    return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitObjCEncodeExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4720,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitObjCEncodeExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator19VisitObjCEncodeExprEPKN5clang14ObjCEncodeExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator19VisitObjCEncodeExprEPKN5clang14ObjCEncodeExprE")
  //</editor-fold>
  public boolean VisitObjCEncodeExpr(/*const*/ ObjCEncodeExpr /*P*/ E) {
    return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitCXXTypeidExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4874,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitCXXTypeidExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator18VisitCXXTypeidExprEPKN5clang13CXXTypeidExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator18VisitCXXTypeidExprEPKN5clang13CXXTypeidExprE")
  //</editor-fold>
  public boolean VisitCXXTypeidExpr(/*const*/ CXXTypeidExpr /*P*/ E) {
    if (!E.isPotentiallyEvaluated()) {
      return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
    }
    
    Info.FFDiag(E, diag.note_constexpr_typeid_polymorphic).$out$T(
        E.getExprOperand().getType()
    ).$out$T(
        E.getExprOperand().getSourceRange()
    );
    return false;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitCXXUuidofExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4884,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitCXXUuidofExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator18VisitCXXUuidofExprEPKN5clang13CXXUuidofExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator18VisitCXXUuidofExprEPKN5clang13CXXUuidofExprE")
  //</editor-fold>
  public boolean VisitCXXUuidofExpr(/*const*/ CXXUuidofExpr /*P*/ E) {
    return Success(new PointerUnion</*const*/ ValueDecl /*P*/ , /*const*/ Expr /*P*/ >(JD$T1.INSTANCE, /*const*/ Expr /*P*/ .class, E));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitArraySubscriptExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4907,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitArraySubscriptExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator23VisitArraySubscriptExprEPKN5clang18ArraySubscriptExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator23VisitArraySubscriptExprEPKN5clang18ArraySubscriptExprE")
  //</editor-fold>
  public boolean VisitArraySubscriptExpr(/*const*/ ArraySubscriptExpr /*P*/ E) {
    // FIXME: Deal with vectors as array subscript bases.
    if (E.getBase$Const().getType().$arrow().isVectorType()) {
      return Error(E);
    }
    if (!EvaluatePointer(E.getBase$Const(), Result, Info)) {
      return false;
    }
    
    APSInt Index/*J*/= new APSInt();
    if (!EvaluateInteger(E.getIdx$Const(), Index, Info)) {
      return false;
    }
    
    return HandleLValueArrayAdjustment(Info, E, Result, E.getType(), 
        getExtValue(Index));
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitUnaryDeref">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4923,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitUnaryDeref", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator15VisitUnaryDerefEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator15VisitUnaryDerefEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryDeref(/*const*/ UnaryOperator /*P*/ E) {
    return EvaluatePointer(E.getSubExpr(), Result, Info);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitUnaryReal">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4927,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitUnaryReal", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator14VisitUnaryRealEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryReal(/*const*/ UnaryOperator /*P*/ E) {
    if (!Visit(E.getSubExpr())) {
      return false;
    }
    // __real is a no-op on scalar lvalues.
    if (E.getSubExpr().getType().$arrow().isAnyComplexType()) {
      HandleLValueComplexElement(Info, E, Result, E.getType(), false);
    }
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitUnaryImag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4936,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitUnaryImag", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator14VisitUnaryImagEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryImag(/*const*/ UnaryOperator /*P*/ E) {
    assert (E.getSubExpr().getType().$arrow().isAnyComplexType()) : "lvalue __imag__ on scalar?";
    if (!Visit(E.getSubExpr())) {
      return false;
    }
    HandleLValueComplexElement(Info, E, Result, E.getType(), true);
    return true;
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitUnaryPreInc">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4727,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitUnaryPreInc", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator16VisitUnaryPreIncEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator16VisitUnaryPreIncEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPreInc(/*const*/ UnaryOperator /*P*/ UO) {
    return VisitUnaryPreIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitUnaryPreDec">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4730,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitUnaryPreDec", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator16VisitUnaryPreDecEPKN5clang13UnaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator16VisitUnaryPreDecEPKN5clang13UnaryOperatorE")
  //</editor-fold>
  public boolean VisitUnaryPreDec(/*const*/ UnaryOperator /*P*/ UO) {
    return VisitUnaryPreIncDec(UO);
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitBinAssign">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4980,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitBinAssign", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator14VisitBinAssignEPKN5clang14BinaryOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator14VisitBinAssignEPKN5clang14BinaryOperatorE")
  //</editor-fold>
  public boolean VisitBinAssign(/*const*/ BinaryOperator /*P*/ E) {
    APValue NewVal = null;
    try {
      if (!Info.getLangOpts().CPlusPlus14 && !Info.keepEvaluatingAfterFailure()) {
        return Error(E);
      }
      
      NewVal/*J*/= new APValue();
      if (!this.Visit(E.getLHS())) {
        if (Info.noteFailure()) {
          Evaluate(NewVal, this.Info, E.getRHS());
        }
        return false;
      }
      if (!Evaluate(NewVal, this.Info, E.getRHS())) {
        return false;
      }
      
      return handleAssignment(this.Info, E, Result, E.getLHS().getType(), 
          NewVal);
    } finally {
      if (NewVal != null) { NewVal.$destroy(); }
    }
  }

  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitCompoundAssignOperator">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4957,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitCompoundAssignOperator", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator27VisitCompoundAssignOperatorEPKN5clang22CompoundAssignOperatorE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator27VisitCompoundAssignOperatorEPKN5clang22CompoundAssignOperatorE")
  //</editor-fold>
  public boolean VisitCompoundAssignOperator(/*const*/ CompoundAssignOperator /*P*/ CAO) {
    APValue RHS = null;
    try {
      if (!Info.getLangOpts().CPlusPlus14 && !Info.keepEvaluatingAfterFailure()) {
        return Error(CAO);
      }
      
      RHS/*J*/= new APValue();
      
      // The overall lvalue result is the result of evaluating the LHS.
      if (!this.Visit(CAO.getLHS())) {
        if (Info.noteFailure()) {
          Evaluate(RHS, this.Info, CAO.getRHS());
        }
        return false;
      }
      if (!Evaluate(RHS, this.Info, CAO.getRHS())) {
        return false;
      }
      
      return handleCompoundAssignment(this.Info, CAO, 
          Result, CAO.getLHS().getType(), CAO.getComputationLHSType(), 
          CAO.getOpForCompoundAssignment(CAO.getOpcode()), RHS);
    } finally {
      if (RHS != null) { RHS.$destroy(); }
    }
  }

  
  //<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::LValueExprEvaluator::VisitCastExpr">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp", line = 4736,
   FQN="(anonymous namespace)::LValueExprEvaluator::VisitCastExpr", NM="_ZN12_GLOBAL__N_119LValueExprEvaluator13VisitCastExprEPKN5clang8CastExprE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprConstant.cpp -nm=_ZN12_GLOBAL__N_119LValueExprEvaluator13VisitCastExprEPKN5clang8CastExprE")
  //</editor-fold>
  public boolean VisitCastExpr(/*const*/ CastExpr /*P*/ E) {
    switch (E.getCastKind()) {
     default:
      return super.VisitCastExpr(E);
     case CK_LValueBitCast:
      this.CCEDiag(E, diag.note_constexpr_invalid_cast).$out_int(2);
      if (!Visit(E.getSubExpr$Const())) {
        return false;
      }
      Result.Designator.setInvalid();
      return true;
     case CK_BaseToDerived:
      if (!Visit(E.getSubExpr$Const())) {
        return false;
      }
      return HandleBaseToDerivedCast(Info, E, Result);
    }
  }

  
  @Override public String toString() {
    return "" + super.toString(); // NOI18N
  }
}
