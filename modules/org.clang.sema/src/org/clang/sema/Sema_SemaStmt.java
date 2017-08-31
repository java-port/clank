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

import static org.clank.support.Native.$Deref;
import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.clank.support.NativeCallback.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaStmtStatics.*;
import org.clang.sema.llvm.impl.DenseMapInfoCatchHandlerType;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaStmt">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaPseudoObject ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema11ActOnDoStmtENS_14SourceLocationEPNS_4StmtES1_S1_PNS_4ExprES1_;_ZN5clang4Sema11ActOnIfStmtENS_14SourceLocationEbPNS_4StmtENS0_15ConditionResultES3_S1_S3_;_ZN5clang4Sema11BuildIfStmtENS_14SourceLocationEbPNS_4StmtENS0_15ConditionResultES3_S1_S3_;_ZN5clang4Sema12ActOnForStmtENS_14SourceLocationES1_PNS_4StmtENS0_15ConditionResultENS0_11FullExprArgES1_S3_;_ZN5clang4Sema13ActOnCaseStmtENS_14SourceLocationEPNS_4ExprES1_S3_S1_;_ZN5clang4Sema13ActOnDeclStmtENS_9OpaquePtrINS_12DeclGroupRefEEENS_14SourceLocationES4_;_ZN5clang4Sema13ActOnExprStmtENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema13ActOnGotoStmtENS_14SourceLocationES1_PNS_9LabelDeclE;_ZN5clang4Sema13ActOnNullStmtENS_14SourceLocationEb;_ZN5clang4Sema14ActOnBreakStmtENS_14SourceLocationEPNS_5ScopeE;_ZN5clang4Sema14ActOnLabelStmtENS_14SourceLocationEPNS_9LabelDeclES1_PNS_4StmtE;_ZN5clang4Sema14ActOnWhileStmtENS_14SourceLocationENS0_15ConditionResultEPNS_4StmtE;_ZN5clang4Sema15ActOnReturnStmtENS_14SourceLocationEPNS_4ExprEPNS_5ScopeE;_ZN5clang4Sema15BuildReturnStmtENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema16ActOnCXXTryBlockENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS3_EE;_ZN5clang4Sema16ActOnDefaultStmtENS_14SourceLocationES1_PNS_4StmtEPNS_5ScopeE;_ZN5clang4Sema16ActOnSEHTryBlockEbNS_14SourceLocationEPNS_4StmtES3_;_ZN5clang4Sema17ActOnCaseStmtBodyEPNS_4StmtES2_;_ZN5clang4Sema17ActOnCompoundStmtENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_4StmtEEEb;_ZN5clang4Sema17ActOnContinueStmtENS_14SourceLocationEPNS_5ScopeE;_ZN5clang4Sema17ActOnSEHLeaveStmtENS_14SourceLocationEPNS_5ScopeE;_ZN5clang4Sema18ActOnCXXCatchBlockENS_14SourceLocationEPNS_4DeclEPNS_4StmtE;_ZN5clang4Sema18ActOnExprStmtErrorEv;_ZN5clang4Sema18ActOnObjCAtTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm15MutableArrayRefIS3_EES3_;_ZN5clang4Sema19ActOnAttributedStmtENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE;_ZN5clang4Sema19ActOnSEHExceptBlockENS_14SourceLocationEPNS_4ExprEPNS_4StmtE;_ZN5clang4Sema20ActOnCXXForRangeStmtEPNS_5ScopeENS_14SourceLocationES3_PNS_4StmtES3_PNS_4ExprES3_NS0_17BuildForRangeKindE;_ZN5clang4Sema20ActOnForEachDeclStmtENS_9OpaquePtrINS_12DeclGroupRefEEE;_ZN5clang4Sema20ActOnObjCAtCatchStmtENS_14SourceLocationES1_PNS_4DeclEPNS_4StmtE;_ZN5clang4Sema20ActOnObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprEPNS_5ScopeE;_ZN5clang4Sema20BuildCXXForRangeStmtENS_14SourceLocationES1_S1_PNS_4StmtES3_S3_PNS_4ExprES5_S3_S1_NS0_17BuildForRangeKindE;_ZN5clang4Sema20BuildObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema21ActOnFinishSwitchStmtENS_14SourceLocationEPNS_4StmtES3_;_ZN5clang4Sema21ActOnIndirectGotoStmtENS_14SourceLocationES1_PNS_4ExprE;_ZN5clang4Sema21FinishCXXForRangeStmtEPNS_4StmtES2_;_ZN5clang4Sema22ActOnCapturedRegionEndEPNS_4StmtE;_ZN5clang4Sema22ActOnForEachLValueExprEPNS_4ExprE;_ZN5clang4Sema22ActOnObjCAtFinallyStmtENS_14SourceLocationEPNS_4StmtE;_ZN5clang4Sema22ActOnStartOfSwitchStmtENS_14SourceLocationEPNS_4StmtENS0_15ConditionResultE;_ZN5clang4Sema22DiagnoseAssignmentEnumENS_8QualTypeES1_PNS_4ExprE;_ZN5clang4Sema22isCopyElisionCandidateENS_8QualTypeEPKNS_7VarDeclEb;_ZN5clang4Sema23ActOnCapScopeReturnStmtENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema23getCopyElisionCandidateENS_8QualTypeEPNS_4ExprEb;_ZN5clang4Sema24ActOnCapturedRegionErrorEv;_ZN5clang4Sema24ActOnCapturedRegionStartENS_14SourceLocationEPNS_5ScopeENS_18CapturedRegionKindEN4llvm8ArrayRefISt4pairINS5_9StringRefENS_8QualTypeEEEE;_ZN5clang4Sema24ActOnCapturedRegionStartENS_14SourceLocationEPNS_5ScopeENS_18CapturedRegionKindEj;_ZN5clang4Sema24ActOnStartOfCompoundStmtEv;_ZN5clang4Sema24DiagnoseUnusedExprResultEPKNS_4StmtE;_ZN5clang4Sema25ActOnAbortSEHFinallyBlockEv;_ZN5clang4Sema25ActOnFinishOfCompoundStmtEv;_ZN5clang4Sema25ActOnStartSEHFinallyBlockEv;_ZN5clang4Sema25CheckBreakContinueBindingEPNS_4ExprE;_ZN5clang4Sema26ActOnFinishSEHFinallyBlockENS_14SourceLocationEPNS_4StmtE;_ZN5clang4Sema26ActOnMSDependentExistsStmtENS_14SourceLocationEbRNS_12CXXScopeSpecERNS_13UnqualifiedIdEPNS_4StmtE;_ZN5clang4Sema26ActOnObjCForCollectionStmtENS_14SourceLocationEPNS_4StmtEPNS_4ExprES1_;_ZN5clang4Sema26BuildMSDependentExistsStmtENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_4StmtE;_ZN5clang4Sema27ActOnObjCAtSynchronizedStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE;_ZN5clang4Sema27FinishObjCForCollectionStmtEPNS_4StmtES2_;_ZN5clang4Sema28ActOnObjCAutoreleasePoolStmtENS_14SourceLocationEPNS_4StmtE;_ZN5clang4Sema28CreateCapturedStmtRecordDeclERPNS_12CapturedDeclENS_14SourceLocationEj;_ZN5clang4Sema29CheckObjCForCollectionOperandENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema30ActOnObjCAtSynchronizedOperandENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema31PerformMoveOrCopyInitializationERKNS_17InitializedEntityEPKNS_7VarDeclENS_8QualTypeEPNS_4ExprEb;_ZN5clang4Sema32DeduceFunctionTypeFromReturnExprEPNS_12FunctionDeclENS_14SourceLocationERPNS_4ExprEPNS_8AutoTypeE;_ZNK5clang4Sema16getReturnTypeLocEPNS_12FunctionDeclE;_ZNK5clang4Sema19getCurCompoundScopeEv; -static-type=Sema_SemaStmt -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaStmt extends Sema_SemaPseudoObject {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurCompoundScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 328,
 FQN="clang::Sema::getCurCompoundScope", NM="_ZNK5clang4Sema19getCurCompoundScopeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang4Sema19getCurCompoundScopeEv")
//</editor-fold>
public final CompoundScopeInfo /*&*/ getCurCompoundScope() /*const*/ {
  return $this().getCurFunction().CompoundScopes.back();
}


/// \brief Perform the initialization of a potentially-movable value, which
/// is the result of return value.
///
/// This routine implements C++14 [class.copy]p32, which attempts to treat
/// returned lvalues as rvalues in certain cases (to prefer move construction),
/// then falls back to treating them as lvalues if that failed.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformMoveOrCopyInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2772,
 FQN="clang::Sema::PerformMoveOrCopyInitialization", NM="_ZN5clang4Sema31PerformMoveOrCopyInitializationERKNS_17InitializedEntityEPKNS_7VarDeclENS_8QualTypeEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema31PerformMoveOrCopyInitializationERKNS_17InitializedEntityEPKNS_7VarDeclENS_8QualTypeEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformMoveOrCopyInitialization(final /*const*/ InitializedEntity /*&*/ Entity, 
                               /*const*/ VarDecl /*P*/ NRVOCandidate, 
                               QualType ResultType, 
                               Expr /*P*/ Value) {
  return PerformMoveOrCopyInitialization(Entity, 
                               NRVOCandidate, 
                               ResultType, 
                               Value, 
                               true);
}
public final ActionResultTTrue<Expr /*P*/ > PerformMoveOrCopyInitialization(final /*const*/ InitializedEntity /*&*/ Entity, 
                               /*const*/ VarDecl /*P*/ NRVOCandidate, 
                               QualType ResultType, 
                               Expr /*P*/ Value, 
                               boolean AllowNRVO/*= true*/) {
  // C++14 [class.copy]p32:
  // When the criteria for elision of a copy/move operation are met, but not for
  // an exception-declaration, and the object to be copied is designated by an
  // lvalue, or when the expression in a return statement is a (possibly
  // parenthesized) id-expression that names an object with automatic storage
  // duration declared in the body or parameter-declaration-clause of the
  // innermost enclosing function or lambda-expression, overload resolution to
  // select the constructor for the copy is first performed as if the object
  // were designated by an rvalue.
  ActionResultTTrue<Expr /*P*/ > Res = ExprError();
  if (AllowNRVO && !(NRVOCandidate != null)) {
    NRVOCandidate = $this().getCopyElisionCandidate(new QualType(ResultType), Value, true);
  }
  if (AllowNRVO && (NRVOCandidate != null)) {
    InitializationSequence Seq = null;
    try {
      ImplicitCastExpr AsRvalue/*J*/= new ImplicitCastExpr(ImplicitCastExpr.OnStack_t.OnStack, Value.getType(), 
          CastKind.CK_NoOp, Value, ExprValueKind.VK_XValue);
      
      Expr /*P*/ InitExpr = $AddrOf(AsRvalue);
      
      InitializationKind Kind = InitializationKind.CreateCopy(Value.getLocStart(), Value.getLocStart());
      
      Seq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitExpr, true));
      if (Seq.$bool()) {
        for (final /*const*/ InitializationSequence.Step /*&*/ Step : Seq.steps()) {
          if (!(Step.Kind
             == InitializationSequence.StepKind.SK_ConstructorInitialization
             || (Step.Kind == InitializationSequence.StepKind.SK_UserConversion
             && isa_CXXConstructorDecl(Step.Unnamed_field2.Function.Function)))) {
            continue;
          }
          
          CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(Step.Unnamed_field2.Function.Function);
          
          /*const*/ RValueReferenceType /*P*/ RRefType = Constructor.getParamDecl(0).getType().$arrow().getAs(RValueReferenceType.class);
          
          // [...] If the first overload resolution fails or was not performed, or
          // if the type of the first parameter of the selected constructor is not
          // an rvalue reference to the object���s type (possibly cv-qualified),
          // overload resolution is performed again, considering the object as an
          // lvalue.
          if (!(RRefType != null)
             || !$this().Context.hasSameUnqualifiedType(RRefType.getPointeeType(), 
              NRVOCandidate.getType())) {
            break;
          }
          
          // Promote "AsRvalue" to the heap, since we now need this
          // expression node to persist.
          Value = ImplicitCastExpr.Create($this().Context, Value.getType(), CastKind.CK_NoOp, 
              Value, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_XValue);
          
          // Complete type-checking the initialization of the return type
          // using the constructor we found.
          Res.$assignMove(Seq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Value, true)));
        }
      }
    } finally {
      if (Seq != null) { Seq.$destroy(); }
    }
  }
  
  // Either we didn't meet the criteria for treating an lvalue as an rvalue,
  // above, or overload resolution failed. Either way, we need to try
  // (again) now with the return value expression as written.
  if (Res.isInvalid()) {
    Res.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Value)));
  }
  
  return Res;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExprStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 44,
 FQN="clang::Sema::ActOnExprStmt", NM="_ZN5clang4Sema13ActOnExprStmtENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema13ActOnExprStmtENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnExprStmt(ActionResultTTrue<Expr /*P*/ > FE) {
  if (FE.isInvalid()) {
    return StmtError();
  }
  
  FE.$assignMove($this().ActOnFinishFullExpr(FE.get(), FE.get().getExprLoc(), 
          /*DiscardedValue*/ true));
  if (FE.isInvalid()) {
    return StmtError();
  }
  
  // C99 6.8.3p2: The expression in an expression statement is evaluated as a
  // void expression for its side effects.  Conversion to void allows any
  // operand, even incomplete types.
  
  // Same thing in for stmt first clause (when expr) and third clause.
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, FE.getAs(Stmt.class));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExprStmtError">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 62,
 FQN="clang::Sema::ActOnExprStmtError", NM="_ZN5clang4Sema18ActOnExprStmtErrorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema18ActOnExprStmtErrorEv")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnExprStmtError() {
  $this().DiscardCleanupsInEvaluationContext();
  return StmtError();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnNullStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 67,
 FQN="clang::Sema::ActOnNullStmt", NM="_ZN5clang4Sema13ActOnNullStmtENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema13ActOnNullStmtENS_14SourceLocationEb")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnNullStmt(SourceLocation SemiLoc) {
  return ActOnNullStmt(SemiLoc, 
             false);
}
public final ActionResultTTrue<Stmt /*P*/ > ActOnNullStmt(SourceLocation SemiLoc, 
             boolean HasLeadingEmptyMacro/*= false*/) {
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new NullStmt(new SourceLocation(SemiLoc), HasLeadingEmptyMacro)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOfCompoundStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 320,
 FQN="clang::Sema::ActOnStartOfCompoundStmt", NM="_ZN5clang4Sema24ActOnStartOfCompoundStmtEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema24ActOnStartOfCompoundStmtEv")
//</editor-fold>
public final void ActOnStartOfCompoundStmt() {
  $this().PushCompoundScope();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishOfCompoundStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 324,
 FQN="clang::Sema::ActOnFinishOfCompoundStmt", NM="_ZN5clang4Sema25ActOnFinishOfCompoundStmtEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema25ActOnFinishOfCompoundStmtEv")
//</editor-fold>
public final void ActOnFinishOfCompoundStmt() {
  $this().PopCompoundScope();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCompoundStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 332,
 FQN="clang::Sema::ActOnCompoundStmt", NM="_ZN5clang4Sema17ActOnCompoundStmtENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_4StmtEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema17ActOnCompoundStmtENS_14SourceLocationES1_N4llvm8ArrayRefIPNS_4StmtEEEb")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCompoundStmt(SourceLocation L, SourceLocation R, 
                 ArrayRef<Stmt /*P*/ > Elts, boolean isStmtExpr) {
  /*const*//*uint*/int NumElts = Elts.size();
  
  // If we're in C89 mode, check that we don't have any decls after stmts.  If
  // so, emit an extension diagnostic.
  if (!$this().getLangOpts().C99 && !$this().getLangOpts().CPlusPlus) {
    // Note that __extension__ can be around a decl.
    /*uint*/int i = 0;
    // Skip over all declarations.
    for (; i != NumElts && isa_DeclStmt(Elts.$at(i)); ++i)  {
/*empty*/       ;
    }
    
    // We found the end of the list or a statement.  Scan for another declstmt.
    for (; i != NumElts && !isa_DeclStmt(Elts.$at(i)); ++i)  {
/*empty*/       ;
    }
    if (i != NumElts) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Decl /*P*/ D = cast_DeclStmt(Elts.$at(i)).decl_begin().$star();
        $c$.clean($c$.track($this().Diag(D.getLocation(), diag.ext_mixed_decls_code)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  // Warn about unused expressions in statements.
  for (/*uint*/int i = 0; i != NumElts; ++i) {
    // Ignore statements that are last in a statement expression.
    if (isStmtExpr && i == NumElts - 1) {
      continue;
    }
    
    $this().DiagnoseUnusedExprResult(Elts.$at(i));
  }
  
  // Check for suspicious empty body (null statement) in `for' and `while'
  // statements.  Don't do anything for template instantiations, this just adds
  // noise.
  if (NumElts != 0 && !($this().CurrentInstantiationScope != null)
     && $this().getCurCompoundScope().HasEmptyLoopBodies) {
    for (/*uint*/int i = 0; i != NumElts - 1; ++i)  {
      $this().DiagnoseEmptyLoopBody(Elts.$at(i), Elts.$at(i + 1));
    }
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CompoundStmt($this().Context, new ArrayRef<Stmt /*P*/ >(Elts), new SourceLocation(L), new SourceLocation(R));
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDeclStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 72,
 FQN="clang::Sema::ActOnDeclStmt", NM="_ZN5clang4Sema13ActOnDeclStmtENS_9OpaquePtrINS_12DeclGroupRefEEENS_14SourceLocationES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema13ActOnDeclStmtENS_9OpaquePtrINS_12DeclGroupRefEEENS_14SourceLocationES4_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnDeclStmt(OpaquePtr<DeclGroupRef> dg, SourceLocation StartLoc, 
             SourceLocation EndLoc) {
  DeclGroupRef DG = dg.getDeclGroupRef();
  
  // If we have an invalid decl, just return an error.
  if (DG.isNull()) {
    return StmtError();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new DeclStmt(new DeclGroupRef(DG), new SourceLocation(StartLoc), new SourceLocation(EndLoc));
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnForEachDeclStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 82,
 FQN="clang::Sema::ActOnForEachDeclStmt", NM="_ZN5clang4Sema20ActOnForEachDeclStmtENS_9OpaquePtrINS_12DeclGroupRefEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20ActOnForEachDeclStmtENS_9OpaquePtrINS_12DeclGroupRefEEE")
//</editor-fold>
public final void ActOnForEachDeclStmt(OpaquePtr<DeclGroupRef> dg) {
  DeclGroupRef DG = dg.getDeclGroupRef();
  
  // If we don't have a declaration, or we have an invalid declaration,
  // just return.
  if (DG.isNull() || !DG.isSingleDecl()) {
    return;
  }
  
  Decl /*P*/ decl = DG.getSingleDecl();
  if (!(decl != null) || decl.isInvalidDecl()) {
    return;
  }
  
  // Only variable declarations are permitted.
  VarDecl /*P*/ var = dyn_cast_VarDecl(decl);
  if (!(var != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(decl.getLocation(), diag.err_non_variable_decl_in_for)));
      decl.setInvalidDecl();
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // foreach variables are never actually initialized in the way that
  // the parser came up with.
  var.setInit((Expr /*P*/ )null);
  
  // In ARC, we don't need to retain the iteration variable of a fast
  // enumeration loop.  Rather than actually trying to catch that
  // during declaration processing, we remove the consequences here.
  if ($this().getLangOpts().ObjCAutoRefCount) {
    QualType type = var.getType();
    
    // Only do this if we inferred the lifetime.  Inferred lifetime
    // will show up as a local qualifier because explicit lifetime
    // should have shown up as an AttributedType instead.
    if (type.getLocalQualifiers().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong) {
      // Add 'const' and mark the variable as pseudo-strong.
      var.setType(type.withConst());
      var.setARCPseudoStrong(true);
    }
  }
}


/// In an Objective C collection iteration statement:
///   for (x in y)
/// x can be an arbitrary l-value expression.  Bind it up as a
/// full-expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnForEachLValueExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1682,
 FQN="clang::Sema::ActOnForEachLValueExpr", NM="_ZN5clang4Sema22ActOnForEachLValueExprEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema22ActOnForEachLValueExprEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnForEachLValueExpr(Expr /*P*/ E) {
  // Reduce placeholder expressions here.  Note that this rejects the
  // use of pseudo-object l-values in this position.
  ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(E);
  if (result.isInvalid()) {
    return StmtError();
  }
  E = result.get();
  
  ActionResultTTrue<Expr /*P*/ > FullExpr = $this().ActOnFinishFullExpr(E);
  if (FullExpr.isInvalid()) {
    return StmtError();
  }
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, ((/*static_cast*/Stmt /*P*/ )(FullExpr.get())));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCaseStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 375,
 FQN="clang::Sema::ActOnCaseStmt", NM="_ZN5clang4Sema13ActOnCaseStmtENS_14SourceLocationEPNS_4ExprES1_S3_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema13ActOnCaseStmtENS_14SourceLocationEPNS_4ExprES1_S3_S1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCaseStmt(SourceLocation CaseLoc, Expr /*P*/ LHSVal, 
             SourceLocation DotDotDotLoc, Expr /*P*/ RHSVal, 
             SourceLocation ColonLoc) {
  assert ((LHSVal != null)) : "missing expression in case statement";
  if ($this().getCurFunction().SwitchStack.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(CaseLoc), diag.err_case_not_in_switch)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > LHS = $this().CorrectDelayedTyposInExpr(LHSVal, /*FuncArg*//*[this]*/ ( Expr /*P*/ E) -> {
            if (!$this().getLangOpts().CPlusPlus11) {
              return $this().VerifyIntegerConstantExpression(E);
            }
            {
              Expr /*P*/ CondExpr = $this().getCurFunction().SwitchStack.back().getCond();
              if ((CondExpr != null)) {
                QualType CondType = CondExpr.getType();
                APSInt TempVal/*J*/= new APSInt();
                return $this().CheckConvertedConstantExpression(E, new QualType(CondType), TempVal, 
                    CCEKind.CCEK_CaseValue);
              }
            }
            return ExprError();
          });
  if (LHS.isInvalid()) {
    return StmtError();
  }
  LHSVal = LHS.get();
  if (!$this().getLangOpts().CPlusPlus11) {
    // C99 6.8.4.2p3: The expression shall be an integer constant.
    // However, GCC allows any evaluatable integer expression.
    if (!LHSVal.isTypeDependent() && !LHSVal.isValueDependent()) {
      LHSVal = $this().VerifyIntegerConstantExpression(LHSVal).get();
      if (!(LHSVal != null)) {
        return StmtError();
      }
    }
    
    // GCC extension: The expression shall be an integer constant.
    if ((RHSVal != null) && !RHSVal.isTypeDependent() && !RHSVal.isValueDependent()) {
      RHSVal = $this().VerifyIntegerConstantExpression(RHSVal).get();
      // Recover from an error by just forgetting about it.
    }
  }
  
  LHS.$assignMove($this().ActOnFinishFullExpr(LHSVal, LHSVal.getExprLoc(), false, 
          $this().getLangOpts().CPlusPlus11));
  if (LHS.isInvalid()) {
    return StmtError();
  }
  
  ActionResultTTrue<Expr /*P*/ > RHS = (RHSVal != null) ? $this().ActOnFinishFullExpr(RHSVal, RHSVal.getExprLoc(), false, 
      $this().getLangOpts().CPlusPlus11) : new ActionResultTTrue<Expr /*P*/ >();
  if (RHS.isInvalid()) {
    return StmtError();
  }
  
  CaseStmt /*P*/ CS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CaseStmt(LHS.get(), RHS.get(), new SourceLocation(CaseLoc), new SourceLocation(DotDotDotLoc), new SourceLocation(ColonLoc)));
  $this().getCurFunction().SwitchStack.back().addSwitchCase(CS);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, CS);
}


/// ActOnCaseStmtBody - This installs a statement as the body of a case.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCaseStmtBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 438,
 FQN="clang::Sema::ActOnCaseStmtBody", NM="_ZN5clang4Sema17ActOnCaseStmtBodyEPNS_4StmtES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema17ActOnCaseStmtBodyEPNS_4StmtES2_")
//</editor-fold>
public final void ActOnCaseStmtBody(Stmt /*P*/ caseStmt, Stmt /*P*/ SubStmt) {
  $this().DiagnoseUnusedExprResult(SubStmt);
  
  CaseStmt /*P*/ CS = ((/*static_cast*/CaseStmt /*P*/ )(caseStmt));
  CS.setSubStmt(SubStmt);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDefaultStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 445,
 FQN="clang::Sema::ActOnDefaultStmt", NM="_ZN5clang4Sema16ActOnDefaultStmtENS_14SourceLocationES1_PNS_4StmtEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema16ActOnDefaultStmtENS_14SourceLocationES1_PNS_4StmtEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnDefaultStmt(SourceLocation DefaultLoc, SourceLocation ColonLoc, 
                Stmt /*P*/ SubStmt, Scope /*P*/ CurScope) {
  $this().DiagnoseUnusedExprResult(SubStmt);
  if ($this().getCurFunction().SwitchStack.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(DefaultLoc), diag.err_default_not_in_switch)));
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SubStmt);
    } finally {
      $c$.$destroy();
    }
  }
  
  DefaultStmt /*P*/ DS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new DefaultStmt(new SourceLocation(DefaultLoc), new SourceLocation(ColonLoc), SubStmt));
  $this().getCurFunction().SwitchStack.back().addSwitchCase(DS);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, DS);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnLabelStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 460,
 FQN="clang::Sema::ActOnLabelStmt", NM="_ZN5clang4Sema14ActOnLabelStmtENS_14SourceLocationEPNS_9LabelDeclES1_PNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema14ActOnLabelStmtENS_14SourceLocationEPNS_9LabelDeclES1_PNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnLabelStmt(SourceLocation IdentLoc, LabelDecl /*P*/ TheDecl, 
              SourceLocation ColonLoc, Stmt /*P*/ SubStmt) {
  // If the label was multiply defined, reject it now.
  if ((TheDecl.getStmt() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IdentLoc), diag.err_redefinition_of_label)), TheDecl.getDeclName()));
      $c$.clean($c$.track($this().Diag(TheDecl.getLocation(), diag.note_previous_definition)));
      return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SubStmt);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Otherwise, things are good.  Fill in the declaration and return it.
  LabelStmt /*P*/ LS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
    return new LabelStmt(new SourceLocation(IdentLoc), TheDecl, SubStmt);
  });
  TheDecl.setStmt(LS);
  if (!TheDecl.isGnuLocal()) {
    TheDecl.setLocStart(new SourceLocation(IdentLoc));
    if (!TheDecl.isMSAsmLabel()) {
      // Don't update the location of MS ASM labels.  These will result in
      // a diagnostic, and changing the location here will mess that up.
      TheDecl.setLocation(new SourceLocation(IdentLoc));
    }
  }
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, LS);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAttributedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 484,
 FQN="clang::Sema::ActOnAttributedStmt", NM="_ZN5clang4Sema19ActOnAttributedStmtENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema19ActOnAttributedStmtENS_14SourceLocationEN4llvm8ArrayRefIPKNS_4AttrEEEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnAttributedStmt(SourceLocation AttrLoc, 
                   ArrayRef</*const*/ Attr /*P*/ > Attrs, 
                   Stmt /*P*/ SubStmt) {
  // Fill in the declaration and return it.
  AttributedStmt /*P*/ LS = AttributedStmt.Create($this().Context, new SourceLocation(AttrLoc), new ArrayRef</*const*/ Attr /*P*/ >(Attrs), SubStmt);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, LS);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnIfStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 506,
 FQN="clang::Sema::ActOnIfStmt", NM="_ZN5clang4Sema11ActOnIfStmtENS_14SourceLocationEbPNS_4StmtENS0_15ConditionResultES3_S1_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema11ActOnIfStmtENS_14SourceLocationEbPNS_4StmtENS0_15ConditionResultES3_S1_S3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnIfStmt(SourceLocation IfLoc, boolean IsConstexpr, Stmt /*P*/ InitStmt, 
           ConditionResult Cond, 
           Stmt /*P*/ thenStmt, SourceLocation ElseLoc, 
           Stmt /*P*/ elseStmt) {
  if (Cond.isInvalid()) {
    Cond.$assignMove(new ConditionResult(/*Deref*/$this(), (Decl /*P*/ )null, 
            $this().MakeFullExpr(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new OpaqueValueExpr(new SourceLocation(), 
                    $this().Context.BoolTy.$QualType(), ExprValueKind.VK_RValue)), 
                new SourceLocation(IfLoc)), 
            false));
  }
  
  Expr /*P*/ CondExpr = Cond.get().second;
  if (!$this().Diags.isIgnored(diag.warn_comma_operator, 
      CondExpr.getExprLoc())) {
    new CommaVisitor(/*Deref*/$this()).Visit(CondExpr);
  }
  if (!(elseStmt != null)) {
    $this().DiagnoseEmptyStmtBody(CondExpr.getLocEnd(), thenStmt, 
        diag.warn_empty_if_body);
  }
  
  return $this().BuildIfStmt(new SourceLocation(IfLoc), IsConstexpr, InitStmt, new ConditionResult(Cond), thenStmt, new SourceLocation(ElseLoc), 
      elseStmt);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildIfStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 532,
 FQN="clang::Sema::BuildIfStmt", NM="_ZN5clang4Sema11BuildIfStmtENS_14SourceLocationEbPNS_4StmtENS0_15ConditionResultES3_S1_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema11BuildIfStmtENS_14SourceLocationEbPNS_4StmtENS0_15ConditionResultES3_S1_S3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > BuildIfStmt(SourceLocation IfLoc, boolean IsConstexpr, 
           Stmt /*P*/ InitStmt, ConditionResult Cond, 
           Stmt /*P*/ thenStmt, SourceLocation ElseLoc, 
           Stmt /*P*/ elseStmt) {
  if (Cond.isInvalid()) {
    return StmtError();
  }
  if (IsConstexpr) {
    $this().getCurFunction().setHasBranchProtectedScope();
  }
  
  $this().DiagnoseUnusedExprResult(thenStmt);
  $this().DiagnoseUnusedExprResult(elseStmt);
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new IfStmt($this().Context, new SourceLocation(IfLoc), IsConstexpr, InitStmt, Cond.get().first, 
          Cond.get().second, thenStmt, new SourceLocation(ElseLoc), elseStmt)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartOfSwitchStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 666,
 FQN="clang::Sema::ActOnStartOfSwitchStmt", NM="_ZN5clang4Sema22ActOnStartOfSwitchStmtENS_14SourceLocationEPNS_4StmtENS0_15ConditionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema22ActOnStartOfSwitchStmtENS_14SourceLocationEPNS_4StmtENS0_15ConditionResultE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnStartOfSwitchStmt(SourceLocation SwitchLoc, 
                      Stmt /*P*/ InitStmt, ConditionResult Cond) {
  if (Cond.isInvalid()) {
    return StmtError();
  }
  
  $this().getCurFunction().setHasBranchIntoScope();
  
  SwitchStmt /*P*/ SS = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new SwitchStmt($this().Context, InitStmt, Cond.get().first, Cond.get().second));
  $this().getCurFunction().SwitchStack.push_back(SS);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SS);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishSwitchStmt">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 738,
 FQN="clang::Sema::ActOnFinishSwitchStmt", NM="_ZN5clang4Sema21ActOnFinishSwitchStmtENS_14SourceLocationEPNS_4StmtES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema21ActOnFinishSwitchStmtENS_14SourceLocationEPNS_4StmtES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnFinishSwitchStmt(SourceLocation SwitchLoc, Stmt /*P*/ Switch, 
                     Stmt /*P*/ BodyStmt) {
  std.vector<std.pair<APSInt, CaseStmt /*P*/ >> CaseRanges = null;
  try {
    SwitchStmt /*P*/ SS = cast_SwitchStmt(Switch);
    assert (SS == $this().getCurFunction().SwitchStack.back()) : "switch stack missing push/pop!";
    
    $this().getCurFunction().SwitchStack.pop_back();
    if (!(BodyStmt != null)) {
      return StmtError();
    }
    SS.setBody(BodyStmt, new SourceLocation(SwitchLoc));
    
    Expr /*P*/ CondExpr = SS.getCond();
    if (!(CondExpr != null)) {
      return StmtError();
    }
    
    QualType CondType = CondExpr.getType();
    
    type$ptr<Expr /*P*/ > CondExprBeforePromotion = create_type$ptr(CondExpr);
    QualType CondTypeBeforePromotion = GetTypeBeforeIntegralPromotion(CondExprBeforePromotion);
    
    // C++ 6.4.2.p2:
    // Integral promotions are performed (on the switch condition).
    //
    // A case value unrepresentable by the original switch condition
    // type (before the promotion) doesn't make sense, even when it can
    // be represented by the promoted type.  Therefore we need to find
    // the pre-promotion type of the switch condition.
    if (!CondExpr.isTypeDependent()) {
      // We have already converted the expression to an integral or enumeration
      // type, when we started the switch statement. If we don't have an
      // appropriate type now, just return an error.
      if (!CondType.$arrow().isIntegralOrEnumerationType()) {
        return StmtError();
      }
      if (CondExpr.isKnownToHaveBooleanValue()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // switch(bool_expr) {...} is often a programmer error, e.g.
          //   switch(n && mask) { ... }  // Doh - should be "n & mask".
          // One can always use an if statement instead of switch(bool_expr).
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(SwitchLoc), diag.warn_bool_switch_condition)), 
              CondExpr.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Get the bitwidth of the switched-on value after promotions. We must
    // convert the integer case values to this width before comparison.
    boolean HasDependentValue = CondExpr.isTypeDependent() || CondExpr.isValueDependent();
    /*uint*/int CondWidth = HasDependentValue ? 0 : $this().Context.getIntWidth(new QualType(CondType));
    boolean CondIsSigned = CondType.$arrow().isSignedIntegerOrEnumerationType();
    
    // Get the width and signedness that the condition might actually have, for
    // warning purposes.
    // FIXME: Grab an IntRange for the condition rather than using the unpromoted
    // type.
    /*uint*/int CondWidthBeforePromotion = HasDependentValue ? 0 : $this().Context.getIntWidth(new QualType(CondTypeBeforePromotion));
    boolean CondIsSignedBeforePromotion = CondTypeBeforePromotion.$arrow().isSignedIntegerOrEnumerationType();
    
    // Accumulate all of the case values in a vector so that we can sort them
    // and detect duplicates.  This vector contains the APInt for the case after
    // it has been converted to the condition type.
    /*typedef SmallVector<std::pair<llvm::APSInt, CaseStmt *>, 64> CaseValsTy*/
//    final class CaseValsTy extends SmallVector<std.pair<APSInt, CaseStmt /*P*/ >>{ };
    SmallVector<std.pair<APSInt, CaseStmt /*P*/ >> CaseVals/*J*/= new SmallVector<std.pair<APSInt, CaseStmt /*P*/ >>(64, new std.pairTypePtr<APSInt, CaseStmt /*P*/ >(new APSInt(), null));
    
    // Keep track of any GNU case ranges we see.  The APSInt is the low value.
    /*typedef std::vector<std::pair<llvm::APSInt, CaseStmt *> > CaseRangesTy*/
//    final class CaseRangesTy extends std.vector<std.pair<APSInt, CaseStmt /*P*/ >>{ };
    CaseRanges/*J*/= new std.vector<std.pair<APSInt, CaseStmt /*P*/ >>(new std.pairTypePtr<APSInt, CaseStmt /*P*/ >(new APSInt(), null));
    
    DefaultStmt /*P*/ TheDefaultStmt = null;
    
    boolean CaseListIsErroneous = false;
    
    for (SwitchCase /*P*/ SC = SS.getSwitchCaseList(); (SC != null) && !HasDependentValue;
         SC = SC.getNextSwitchCase()) {
      {
        
        DefaultStmt /*P*/ DS = dyn_cast_DefaultStmt(SC);
        if ((DS != null)) {
          if ((TheDefaultStmt != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(DS.getDefaultLoc(), diag.err_multiple_default_labels_defined)));
              $c$.clean($c$.track($this().Diag(TheDefaultStmt.getDefaultLoc(), diag.note_duplicate_case_prev)));
              
              // FIXME: Remove the default statement from the switch block so that
              // we'll return a valid AST.  This requires recursing down the AST and
              // finding it, not something we are set up to do right now.  For now,
              // just lop the entire switch stmt out of the AST.
              CaseListIsErroneous = true;
            } finally {
              $c$.$destroy();
            }
          }
          TheDefaultStmt = DS;
        } else {
          CaseStmt /*P*/ CS = cast_CaseStmt(SC);
          
          Expr /*P*/ Lo = CS.getLHS();
          if (Lo.isTypeDependent() || Lo.isValueDependent()) {
            HasDependentValue = true;
            break;
          }
          
          APSInt LoVal/*J*/= new APSInt();
          if ($this().getLangOpts().CPlusPlus11) {
            // C++11 [stmt.switch]p2: the constant-expression shall be a converted
            // constant expression of the promoted type of the switch condition.
            ActionResultTTrue<Expr /*P*/ > ConvLo = $this().CheckConvertedConstantExpression(Lo, new QualType(CondType), LoVal, CCEKind.CCEK_CaseValue);
            if (ConvLo.isInvalid()) {
              CaseListIsErroneous = true;
              continue;
            }
            Lo = ConvLo.get();
          } else {
            // We already verified that the expression has a i-c-e value (C99
            // 6.8.4.2p3) - get that value now.
            LoVal.$assignMove(Lo.EvaluateKnownConstInt($this().Context));
            
            // If the LHS is not the same type as the condition, insert an implicit
            // cast.
            Lo = $this().DefaultLvalueConversion(Lo).get();
            Lo = $this().ImpCastExprToType(Lo, new QualType(CondType), CastKind.CK_IntegralCast).get();
          }
          
          // Check the unconverted value is within the range of possible values of
          // the switch expression.
          checkCaseValue(/*Deref*/$this(), Lo.getLocStart(), LoVal, 
              CondWidthBeforePromotion, CondIsSignedBeforePromotion);
          
          // Convert the value to the same width/sign as the condition.
          AdjustAPSInt(LoVal, CondWidth, CondIsSigned);
          
          CS.setLHS(Lo);
          
          // If this is a case range, remember it in CaseRanges, otherwise CaseVals.
          if ((CS.getRHS() != null)) {
            if (CS.getRHS().isTypeDependent()
               || CS.getRHS().isValueDependent()) {
              HasDependentValue = true;
              break;
            }
            CaseRanges.push_back_T$RR(std.make_pair_T_Ptr(LoVal, CS));
          } else {
            CaseVals.push_back_T$RR(std.make_pair_T_Ptr(LoVal, CS));
          }
        }
      }
    }
    if (!HasDependentValue) {
      // If we don't have a default statement, check whether the
      // condition is constant.
      APSInt ConstantCondValue/*J*/= new APSInt();
      boolean HasConstantCond = false;
      if (!HasDependentValue && !(TheDefaultStmt != null)) {
        HasConstantCond = CondExpr.EvaluateAsInt(ConstantCondValue, $this().Context, 
            Expr.SideEffectsKind.SE_AllowSideEffects);
        assert (!HasConstantCond || (ConstantCondValue.getBitWidth() == CondWidth && ConstantCondValue.isSigned() == CondIsSigned));
      }
      boolean ShouldCheckConstantCond = HasConstantCond;
      
      // Sort all the scalar case values so we can easily detect duplicates.
      std.stable_sort(CaseVals.begin(), CaseVals.end(), SemaStmtStatics::/*FuncRef*/CmpCaseVals);
      if (!CaseVals.empty()) {
        for (/*uint*/int i = 0, e = CaseVals.size(); i != e; ++i) {
          if (ShouldCheckConstantCond
             && CaseVals.$at(i).first.$eq(ConstantCondValue)) {
            ShouldCheckConstantCond = false;
          }
          if (i != 0 && CaseVals.$at(i).first.$eq(CaseVals.$at(i - 1).first)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // If we have a duplicate, report it.
              // First, determine if either case value has a name
              StringRef PrevString/*J*/= new StringRef();
              StringRef CurrString/*J*/= new StringRef();
              Expr /*P*/ PrevCase = CaseVals.$at(i - 1).second.getLHS().IgnoreParenCasts();
              Expr /*P*/ CurrCase = CaseVals.$at(i).second.getLHS().IgnoreParenCasts();
              {
                DeclRefExpr /*P*/ DeclRef = dyn_cast_DeclRefExpr(PrevCase);
                if ((DeclRef != null)) {
                  PrevString.$assignMove(DeclRef.getDecl().getName());
                }
              }
              {
                DeclRefExpr /*P*/ DeclRef = dyn_cast_DeclRefExpr(CurrCase);
                if ((DeclRef != null)) {
                  CurrString.$assignMove(DeclRef.getDecl().getName());
                }
              }
              SmallString/*16*/ CaseValStr/*J*/= new SmallString/*16*/(16);
              CaseVals.$at(i - 1).first.__toString(CaseValStr);
              if ($eq_StringRef(/*NO_COPY*/PrevString, /*NO_COPY*/CurrString)) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CaseVals.$at(i).second.getLHS().getLocStart(), 
                        diag.err_duplicate_case)), 
                    (PrevString.empty() ? CaseValStr.$StringRef() : new StringRef(PrevString))));
              } else {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CaseVals.$at(i).second.getLHS().getLocStart(), 
                                diag.err_duplicate_case_differing_expr)), 
                            (PrevString.empty() ? CaseValStr.$StringRef() : new StringRef(PrevString))), 
                        (CurrString.empty() ? CaseValStr.$StringRef() : new StringRef(CurrString))), 
                    CaseValStr));
              }
              
              $c$.clean($c$.track($this().Diag(CaseVals.$at(i - 1).second.getLHS().getLocStart(), 
                  diag.note_duplicate_case_prev)));
              // FIXME: We really want to remove the bogus case stmt from the
              // substmt, but we have no way to do this right now.
              CaseListIsErroneous = true;
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
      
      // Detect duplicate case ranges, which usually don't exist at all in
      // the first place.
      if (!CaseRanges.empty()) {
        std.vector<APSInt> HiVals = null;
        try {
          // Sort all the case ranges by their low value so we can easily detect
          // overlaps between ranges.
          std.stable_sort(CaseRanges.begin(), CaseRanges.end(), new Compare<std.pair<APSInt, CaseStmt /*P*/ >>(){
            // TODO: rename to less
            public boolean compare(std.pair<APSInt, CaseStmt /*P*/ > a, std.pair<APSInt, CaseStmt /*P*/ > b) {
              if (a.first.$eq(b.first)) {
                return System.identityHashCode(a.second) < System.identityHashCode(b.second.hashCode());
              } else {
                return a.first.$less(b.first);
              }
            }
        });
          
          // Scan the ranges, computing the high values and removing empty ranges.
          HiVals/*J*/= new std.vector<APSInt>(new APSInt());
          for (/*uint*/int i = 0, e = CaseRanges.size(); i != e; ++i) {
            final APSInt /*&*/ LoVal = CaseRanges.$at(i).first;
            CaseStmt /*P*/ CR = CaseRanges.$at(i).second;
            Expr /*P*/ Hi = CR.getRHS();
            APSInt HiVal/*J*/= new APSInt();
            if ($this().getLangOpts().CPlusPlus11) {
              // C++11 [stmt.switch]p2: the constant-expression shall be a converted
              // constant expression of the promoted type of the switch condition.
              ActionResultTTrue<Expr /*P*/ > ConvHi = $this().CheckConvertedConstantExpression(Hi, new QualType(CondType), HiVal, 
                  CCEKind.CCEK_CaseValue);
              if (ConvHi.isInvalid()) {
                CaseListIsErroneous = true;
                continue;
              }
              Hi = ConvHi.get();
            } else {
              HiVal.$assignMove(Hi.EvaluateKnownConstInt($this().Context));
              
              // If the RHS is not the same type as the condition, insert an
              // implicit cast.
              Hi = $this().DefaultLvalueConversion(Hi).get();
              Hi = $this().ImpCastExprToType(Hi, new QualType(CondType), CastKind.CK_IntegralCast).get();
            }
            
            // Check the unconverted value is within the range of possible values of
            // the switch expression.
            checkCaseValue(/*Deref*/$this(), Hi.getLocStart(), HiVal, 
                CondWidthBeforePromotion, CondIsSignedBeforePromotion);
            
            // Convert the value to the same width/sign as the condition.
            AdjustAPSInt(HiVal, CondWidth, CondIsSigned);
            
            CR.setRHS(Hi);
            
            // If the low value is bigger than the high value, the case is empty.
            if (LoVal.$greater(HiVal)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CR.getLHS().getLocStart(), diag.warn_case_empty_range)), 
                    new SourceRange(CR.getLHS().getLocStart(), 
                        Hi.getLocEnd())));
                CaseRanges.erase(//new __normal_iterator</*const*/ pair<APSInt, CaseStmt /*P*/ > /*P*/ , vector<pair<APSInt, CaseStmt /*P*/ >> >(
                        CaseRanges.begin().$add(i)/*)*/);
                --i;
                --e;
                continue;
              } finally {
                $c$.$destroy();
              }
            }
            if (ShouldCheckConstantCond
               && LoVal.$lesseq(ConstantCondValue)
               && ConstantCondValue.$lesseq(HiVal)) {
              ShouldCheckConstantCond = false;
            }
            
            HiVals.push_back_T$C$R(HiVal);
          }
          
          // Rescan the ranges, looking for overlap with singleton values and other
          // ranges.  Since the range list is sorted, we only need to compare case
          // ranges with their neighbors.
          for (/*uint*/int i = 0, e = CaseRanges.size(); i != e; ++i) {
            final APSInt /*&*/ CRLo = CaseRanges.$at(i).first;
            final APSInt /*&*/ CRHi = HiVals.$at(i);
            CaseStmt /*P*/ CR = CaseRanges.$at(i).second;
            
            // Check to see whether the case range overlaps with any
            // singleton cases.
            CaseStmt /*P*/ OverlapStmt = null;
            APSInt OverlapVal/*J*/= new APSInt(32);
            
            // Find the smallest value >= the lower bound.  If I is in the
            // case range, then we have overlap.
            CaseCompareFunctor comparator = new CaseCompareFunctor();
            type$ptr<pair<APSInt, CaseStmt /*P*/ > /*P*/ > I = std.lower_bound(CaseVals.begin(), 
                CaseVals.end(), CRLo, (std_pair.pair<APSInt, CaseStmt> one, APSInt other) -> comparator.$call_pair$APSInt$CaseStmt$C$P_APSInt$C(one, other) /*P*/ /*&*/ );
            if ($noteq_ptr(I, CaseVals.end()) && I./*->*/$star().first.$less(CRHi)) {
              OverlapVal.$assign(I./*->*/$star().first); // Found overlap with scalar.
              OverlapStmt = I./*->*/$star().second;
            }
            
            // Find the smallest value bigger than the upper bound.
            I = std.upper_bound(I, CaseVals.end(), CRHi, (APSInt one,  std_pair.pair<APSInt, CaseStmt> other) -> comparator.$call_APSInt$C_pair$APSInt$CaseStmt$C$P(one, other) /*P*/ /*&*/ );
            if ($noteq_ptr(I, CaseVals.begin()) && (I.$sub(1)).$star().first.$greatereq(CRLo)) {
              OverlapVal.$assign((I.$sub(1)).$star().first); // Found overlap with scalar.
              OverlapStmt = (I.$sub(1)).$star().second;
            }
            
            // Check to see if this case stmt overlaps with the subsequent
            // case range.
            if ((i != 0) && CRLo.$lesseq(HiVals.$at(i - 1))) {
              OverlapVal.$assign(HiVals.$at(i - 1)); // Found overlap with range.
              OverlapStmt = CaseRanges.$at(i - 1).second;
            }
            if ((OverlapStmt != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // If we have a duplicate, report it.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CR.getLHS().getLocStart(), diag.err_duplicate_case)), 
                    OverlapVal.__toString(10)));
                $c$.clean($c$.track($this().Diag(OverlapStmt.getLHS().getLocStart(), 
                    diag.note_duplicate_case_prev)));
                // FIXME: We really want to remove the bogus case stmt from the
                // substmt, but we have no way to do this right now.
                CaseListIsErroneous = true;
              } finally {
                $c$.$destroy();
              }
            }
          }
        } finally {
          if (HiVals != null) { HiVals.$destroy(); }
        }
      }
      
      // Complain if we have a constant condition and we didn't find a match.
      if (!CaseListIsErroneous && ShouldCheckConstantCond) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // TODO: it would be nice if we printed enums as enums, chars as
          // chars, etc.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CondExpr.getExprLoc(), diag.warn_missing_case_for_condition)), 
                  ConstantCondValue.__toString(10)), 
              CondExpr.getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Check to see if switch is over an Enum and handles all of its
      // values.  We only issue a warning if there is not 'default:', but
      // we still do the analysis to preserve this information in the AST
      // (which can be used by flow-based analyes).
      //
      /*const*/ EnumType /*P*/ ET = CondTypeBeforePromotion.$arrow().getAs$EnumType();
      
      // If switch has default case, then ignore it.
      if (!CaseListIsErroneous && !HasConstantCond && (ET != null)) {
        /*const*/ EnumDecl /*P*/ ED = ET.getDecl();
        SmallVector<std.pair<APSInt, EnumConstantDecl /*P*/ >> EnumVals/*J*/= new SmallVector<std.pair<APSInt, EnumConstantDecl /*P*/ >>(64, new std.pairTypePtr<APSInt, EnumConstantDecl /*P*/ >(new APSInt(), null));
        
        // Gather all enum values, set their type and sort them,
        // allowing easier comparison with CaseVals.
        for (EnumConstantDecl /*P*/ EDI : ED.enumerators()) {
          APSInt Val = new APSInt(EDI.getInitVal());
          AdjustAPSInt(Val, CondWidth, CondIsSigned);
          EnumVals.push_back_T$RR(std.make_pair_T_Ptr(Val, EDI));
        }
        std.stable_sort(EnumVals.begin(), EnumVals.end(), SemaStmtStatics::/*FuncRef*/CmpEnumVals);
        type$ptr<pair<APSInt, EnumConstantDecl /*P*/ > /*P*/ > EI = $tryClone(EnumVals.begin());
        type$ptr<pair<APSInt, EnumConstantDecl /*P*/ > /*P*/ > EIEnd = std.unique(EnumVals.begin(), EnumVals.end(),
                (TypeType2Bool<pair<APSInt, EnumConstantDecl /*P*/ > /*P*/>) (pair<APSInt, EnumConstantDecl> a, pair<APSInt, EnumConstantDecl> b) ->
                        SemaStmtStatics.EqEnumVals(a, b), false);
        
        // See which case values aren't in enum.
        for (type$ptr</*const*/ pair<APSInt, CaseStmt /*P*/ > /*P*/ > CI = $tryClone(CaseVals.begin());
             CI.$noteq(CaseVals.end()); CI.$postInc()) {
          Expr /*P*/ CaseExpr = CI./*->*/$star().second.getLHS();
          if (ShouldDiagnoseSwitchCaseNotInEnum(/*Deref*/$this(), ED, CaseExpr, EI, EIEnd, 
              CI./*->*/$star().first)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CaseExpr.getExprLoc(), diag.warn_not_in_enum)), 
                  CondTypeBeforePromotion));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        // See which of case ranges aren't in enum
        EI = $tryClone(EnumVals.begin());
        //for (__normal_iterator</*const*/ pair<APSInt, CaseStmt /*P*/ > /*P*/ , vector<pair<APSInt, CaseStmt /*P*/ >> > RI = new __normal_iterator</*const*/ pair<APSInt, CaseStmt /*P*/ > /*P*/ , vector<pair<APSInt, CaseStmt /*P*/ >> >(CaseRanges.begin());
        //     $noteq___normal_iterator$_IteratorL$_Container$C___normal_iterator$_IteratorR$_Container$C(RI, CaseRanges.end()); RI.$postInc(0)) {
        for (StdVector.iterator<pair<APSInt, CaseStmt>> RI = CaseRanges.begin(); 
             RI.$noteq(CaseRanges.end()); RI.$postInc(0)) {
          Expr /*P*/ CaseExpr = RI.$arrow().second.getLHS();
          if (ShouldDiagnoseSwitchCaseNotInEnum(/*Deref*/$this(), ED, CaseExpr, EI, EIEnd, 
              RI.$arrow().first)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CaseExpr.getExprLoc(), diag.warn_not_in_enum)), 
                  CondTypeBeforePromotion));
            } finally {
              $c$.$destroy();
            }
          }
          
          APSInt Hi = RI.$arrow().second.getRHS().EvaluateKnownConstInt($this().Context);
          AdjustAPSInt(Hi, CondWidth, CondIsSigned);
          
          CaseExpr = RI.$arrow().second.getRHS();
          if (ShouldDiagnoseSwitchCaseNotInEnum(/*Deref*/$this(), ED, CaseExpr, EI, EIEnd, 
              Hi)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CaseExpr.getExprLoc(), diag.warn_not_in_enum)), 
                  CondTypeBeforePromotion));
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        // Check which enum vals aren't in switch
        type$ptr<pair<APSInt, CaseStmt /*P*/ > /*P*/ > CI = $tryClone(CaseVals.begin());
        StdVector.iterator<pair<APSInt, CaseStmt>> RI = CaseRanges.begin();
        boolean hasCasesNotInSwitch = false;
        
        SmallVector<DeclarationName> UnhandledNames/*J*/= new SmallVector<DeclarationName>(8, new DeclarationName());
        
        for (EI = $tryClone(EnumVals.begin()); $noteq_ptr(EI, EIEnd); EI.$postInc()) {
          // Drop unneeded case values
          while ($noteq_ptr(CI, CaseVals.end()) && CI./*->*/$star().first.$less(EI./*->*/$star().first)) {
            CI.$postInc();
          }
          if ($noteq_ptr(CI, CaseVals.end()) && CI./*->*/$star().first.$eq(EI./*->*/$star().first)) {
            continue;
          }
          
          // Drop unneeded case ranges
          for (; $noteq___normal_iterator$C(RI, CaseRanges.end()); RI.$postInc(0)) {
            APSInt Hi = RI.$arrow().second.getRHS().EvaluateKnownConstInt($this().Context);
            AdjustAPSInt(Hi, CondWidth, CondIsSigned);
            if (EI./*->*/$star().first.$lesseq(Hi)) {
              break;
            }
          }
          if ($eq___normal_iterator$C(RI, CaseRanges.end()) || EI./*->*/$star().first.$less(RI.$arrow().first)) {
            hasCasesNotInSwitch = true;
            UnhandledNames.push_back(EI./*->*/$star().second.getDeclName());
          }
        }
        if ((TheDefaultStmt != null) && UnhandledNames.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(TheDefaultStmt.getDefaultLoc(), diag.warn_unreachable_default)));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Produce a nice diagnostic if multiple values aren't handled.
        if (!UnhandledNames.empty()) {
          DiagnosticBuilder DB = null;
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            /*FIXME: Initializer produces not destroyed temporary!*/DB = $c$.clean(new DiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(CondExpr.getExprLoc(), 
                        (TheDefaultStmt != null) ? diag.warn_def_missing_case : diag.warn_missing_case)), 
                    (int)UnhandledNames.size())));
            
            for (/*size_t*/int I = 0, E = std.min_uint(UnhandledNames.size(), (/*size_t*/int)3);
                 I != E; ++I)  {
              $out_DiagnosticBuilder$C_DeclarationName(DB, /*NO_COPY*/UnhandledNames.$at(I));
            }
          } finally {
            if (DB != null) { DB.$destroy(); }
            $c$.$destroy();
          }
        }
        if (!hasCasesNotInSwitch) {
          SS.setAllEnumCasesCovered();
        }
      }
    }
    if ((BodyStmt != null)) {
      $this().DiagnoseEmptyStmtBody(CondExpr.getLocEnd(), BodyStmt, 
          diag.warn_empty_switch_body);
    }
    
    // FIXME: If the case list was broken is some way, we don't have a good system
    // to patch it up.  Instead, just return the whole substmt as broken.
    if (CaseListIsErroneous) {
      return StmtError();
    }
    
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SS);
  } finally {
    if (CaseRanges != null) { CaseRanges.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnWhileStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1235,
 FQN="clang::Sema::ActOnWhileStmt", NM="_ZN5clang4Sema14ActOnWhileStmtENS_14SourceLocationENS0_15ConditionResultEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema14ActOnWhileStmtENS_14SourceLocationENS0_15ConditionResultEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnWhileStmt(SourceLocation WhileLoc, ConditionResult Cond, 
              Stmt /*P*/ Body) {
  if (Cond.isInvalid()) {
    return StmtError();
  }
  
  pair<VarDecl /*P*/ , Expr /*P*/ > CondVal = Cond.get();
  $this().CheckBreakContinueBinding(CondVal.second);
  if ((CondVal.second != null)
     && !$this().Diags.isIgnored(diag.warn_comma_operator, CondVal.second.getExprLoc())) {
    new CommaVisitor(/*Deref*/$this()).Visit(CondVal.second);
  }
  
  $this().DiagnoseUnusedExprResult(Body);
  if (isa_NullStmt(Body)) {
    $this().getCurCompoundScope().setHasEmptyLoopBodies();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new WhileStmt($this().Context, CondVal.first, CondVal.second, Body, new SourceLocation(WhileLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDoStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$Cond*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1256,
 FQN="clang::Sema::ActOnDoStmt", NM="_ZN5clang4Sema11ActOnDoStmtENS_14SourceLocationEPNS_4StmtES1_S1_PNS_4ExprES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema11ActOnDoStmtENS_14SourceLocationEPNS_4StmtES1_S1_PNS_4ExprES1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnDoStmt(SourceLocation DoLoc, Stmt /*P*/ Body, 
           SourceLocation WhileLoc, SourceLocation CondLParen, 
           Expr /*P*/ Cond, SourceLocation CondRParen) {
  assert ((Cond != null)) : "ActOnDoStmt(): missing expression";
  
  $this().CheckBreakContinueBinding(Cond);
  ActionResultTTrue<Expr /*P*/ > CondResult = $this().CheckBooleanCondition(new SourceLocation(DoLoc), Cond);
  if (CondResult.isInvalid()) {
    return StmtError();
  }
  Cond = CondResult.get();
  
  CondResult.$assignMove($this().ActOnFinishFullExpr(Cond, new SourceLocation(DoLoc)));
  if (CondResult.isInvalid()) {
    return StmtError();
  }
  Cond = CondResult.get();
  
  $this().DiagnoseUnusedExprResult(Body);
  
  final Expr /*P*/ $Cond = Cond;
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new DoStmt(Body, $Cond, new SourceLocation(DoLoc), new SourceLocation(WhileLoc), new SourceLocation(CondRParen))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnForStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1627,
 FQN="clang::Sema::ActOnForStmt", NM="_ZN5clang4Sema12ActOnForStmtENS_14SourceLocationES1_PNS_4StmtENS0_15ConditionResultENS0_11FullExprArgES1_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema12ActOnForStmtENS_14SourceLocationES1_PNS_4StmtENS0_15ConditionResultENS0_11FullExprArgES1_S3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnForStmt(SourceLocation ForLoc, SourceLocation LParenLoc, 
            Stmt /*P*/ First, ConditionResult Second, 
            FullExprArg third, SourceLocation RParenLoc, 
            Stmt /*P*/ Body) {
  if (Second.isInvalid()) {
    return StmtError();
  }
  if (!$this().getLangOpts().CPlusPlus) {
    {
      DeclStmt /*P*/ DS = dyn_cast_or_null_DeclStmt(First);
      if ((DS != null)) {
        // C99 6.8.5p3: The declaration part of a 'for' statement shall only
        // declare identifiers for objects having storage class 'auto' or
        // 'register'.
        for (Decl /*P*/ DI : DS.decls()) {
          VarDecl /*P*/ VD = dyn_cast_VarDecl(DI);
          if ((VD != null) && VD.isLocalVarDecl() && !VD.hasLocalStorage()) {
            VD = null;
          }
          if (!(VD != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($c$.track($this().Diag(DI.getLocation(), diag.err_non_local_variable_decl_in_for)));
              DI.setInvalidDecl();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  
  $this().CheckBreakContinueBinding(Second.get().second);
  $this().CheckBreakContinueBinding(third.get());
  if (!((Second.get().first) != null)) {
    CheckForLoopConditionalStatement(/*Deref*/$this(), Second.get().second, third.get(), 
        Body);
  }
  CheckForRedundantIteration(/*Deref*/$this(), third.get(), Body);
  if (((Second.get().second) != null)
     && !$this().Diags.isIgnored(diag.warn_comma_operator, 
      Second.get().second.getExprLoc())) {
    new CommaVisitor(/*Deref*/$this()).Visit(Second.get().second);
  }
  
  Expr /*P*/ Third = third.release().getAs(Expr.class);
  
  $this().DiagnoseUnusedExprResult(First);
  $this().DiagnoseUnusedExprResult(Third);
  $this().DiagnoseUnusedExprResult(Body);
  if (isa_NullStmt(Body)) {
    $this().getCurCompoundScope().setHasEmptyLoopBodies();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ForStmt($this().Context, First, Second.get().second, Second.get().first, Third, 
          Body, new SourceLocation(ForLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckObjCForCollectionOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1695,
 FQN="clang::Sema::CheckObjCForCollectionOperand", NM="_ZN5clang4Sema29CheckObjCForCollectionOperandENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema29CheckObjCForCollectionOperandENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckObjCForCollectionOperand(SourceLocation forLoc, Expr /*P*/ collection) {
  if (!(collection != null)) {
    return ExprError();
  }
  
  ActionResultTTrue<Expr /*P*/ > result = $this().CorrectDelayedTyposInExpr(collection);
  if (!result.isUsable()) {
    return ExprError();
  }
  collection = result.get();
  
  // Bail out early if we've got a type-dependent expression.
  if (collection.isTypeDependent()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, collection);
  }
  
  // Perform normal l-value conversion.
  result.$assignMove($this().DefaultFunctionArrayLvalueConversion(collection));
  if (result.isInvalid()) {
    return ExprError();
  }
  collection = result.get();
  
  // The operand needs to have object-pointer type.
  // TODO: should we do a contextual conversion?
  /*const*/ ObjCObjectPointerType /*P*/ pointerType = collection.getType().$arrow().getAs(ObjCObjectPointerType.class);
  if (!(pointerType != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(forLoc), diag.err_collection_expr_type)), 
                  collection.getType()), collection.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the operand provides
  //   - countByEnumeratingWithState:objects:count:
  /*const*/ ObjCObjectType /*P*/ objectType = pointerType.getObjectType();
  ObjCInterfaceDecl /*P*/ iface = objectType.getInterface();
  
  // If we have a forward-declared type, we can't do this check.
  // Under ARC, it is an error not to have a forward-declared class.
  if ((iface != null)
     && ($this().getLangOpts().ObjCAutoRefCount ? $this().RequireCompleteType$T(new SourceLocation(forLoc), new QualType(objectType, 0), 
      diag.err_arc_collection_forward, collection) : !$this().isCompleteType(new SourceLocation(forLoc), new QualType(objectType, 0)))) {
    // Otherwise, if we have any useful type information, check that
    // the type declares the appropriate method.
  } else if ((iface != null) || !objectType.qual_empty()) {
    IdentifierInfo /*P*/ selectorIdents[/*3*/] = new IdentifierInfo /*P*/  [/*3*/] {
      $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"countByEnumeratingWithState"))), 
      $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"objects"))), 
      $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"count")))
    };
    Selector selector = $this().Context.Selectors.getSelector(3, $AddrOf(create_type$ptr(selectorIdents, 0)));
    
    ObjCMethodDecl /*P*/ method = null;
    
    // If there's an interface, look in both the public and private APIs.
    if ((iface != null)) {
      method = iface.lookupInstanceMethod(new Selector(selector));
      if (!(method != null)) {
        method = iface.lookupPrivateMethod(selector);
      }
    }
    
    // Also check protocol qualifiers.
    if (!(method != null)) {
      method = $this().LookupMethodInQualifiedType(new Selector(selector), pointerType, 
          /*instance*/ true);
    }
    
    // If we didn't find it anywhere, give up.
    if (!(method != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(forLoc), diag.warn_collection_expr_type)), 
                    collection.getType()), selector), collection.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
    // TODO: check for an incompatible signature?
  }
  
  // Wrap up any cleanups in the expression.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, collection);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCForCollectionStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1770,
 FQN="clang::Sema::ActOnObjCForCollectionStmt", NM="_ZN5clang4Sema26ActOnObjCForCollectionStmtENS_14SourceLocationEPNS_4StmtEPNS_4ExprES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema26ActOnObjCForCollectionStmtENS_14SourceLocationEPNS_4StmtEPNS_4ExprES1_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCForCollectionStmt(SourceLocation ForLoc, 
                          Stmt /*P*/ First, Expr /*P*/ collection, 
                          SourceLocation RParenLoc) {
  
  ActionResultTTrue<Expr /*P*/ > CollectionExprResult = $this().CheckObjCForCollectionOperand(new SourceLocation(ForLoc), collection);
  if ((First != null)) {
    QualType FirstType/*J*/= new QualType();
    {
      DeclStmt /*P*/ DS = dyn_cast_DeclStmt(First);
      if ((DS != null)) {
        if (!DS.isSingleDecl()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($c$.track($this().Diag((DS.decl_begin().$star()).getLocation(), 
                    diag.err_toomany_element_decls))));
          } finally {
            $c$.$destroy();
          }
        }
        
        VarDecl /*P*/ D = dyn_cast_VarDecl(DS.getSingleDecl());
        if (!(D != null) || D.isInvalidDecl()) {
          return StmtError();
        }
        
        FirstType.$assignMove(D.getType());
        // C99 6.8.5p3: The declaration part of a 'for' statement shall only
        // declare identifiers for objects having storage class 'auto' or
        // 'register'.
        if (!D.hasLocalStorage()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($c$.track($this().Diag(D.getLocation(), 
                    diag.err_non_local_variable_decl_in_for))));
          } finally {
            $c$.$destroy();
          }
        }
        
        // If the type contained 'auto', deduce the 'auto' to 'id'.
        if ((FirstType.$arrow().getContainedAutoType() != null)) {
          OpaqueValueExpr OpaqueId/*J*/= new OpaqueValueExpr(D.getLocation(), $this().Context.getObjCIdType(), 
              ExprValueKind.VK_RValue);
          type$ref<Expr /*P*/ > DeducedInit = create_type$ref($AddrOf(OpaqueId));
          if ($this().DeduceAutoType(D.getTypeSourceInfo(), DeducedInit, FirstType)
             == DeduceAutoResult.DAR_Failed) {
            $this().DiagnoseAutoDeductionFailure(D, DeducedInit.$deref());
          }
          if (FirstType.isNull()) {
            D.setInvalidDecl();
            return StmtError();
          }
          
          D.setType(new QualType(FirstType));
          if ($this().ActiveTemplateInstantiations.empty()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              SourceLocation Loc = D.getTypeSourceInfo().getTypeLoc().getBeginLoc();
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_auto_var_is_id)), 
                  D.getDeclName()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      } else {
        Expr /*P*/ FirstE = cast_Expr(First);
        if (!FirstE.isTypeDependent() && !FirstE.isLValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(First.getLocStart(), 
                        diag.err_selector_element_not_lvalue)), 
                    First.getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
        
        FirstType.$assignMove(((/*static_cast*/Expr /*P*/ )(First)).getType());
        if (FirstType.isConstQualified()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ForLoc), diag.err_selector_element_const_type)), 
                    FirstType), First.getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if (!FirstType.$arrow().isDependentType()
       && !FirstType.$arrow().isObjCObjectPointerType()
       && !FirstType.$arrow().isBlockPointerType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ForLoc), diag.err_selector_element_type)), 
                    FirstType), First.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if (CollectionExprResult.isInvalid()) {
    return StmtError();
  }
  
  CollectionExprResult.$assignMove($this().ActOnFinishFullExpr(CollectionExprResult.get()));
  if (CollectionExprResult.isInvalid()) {
    return StmtError();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCForCollectionStmt(First, CollectionExprResult.get(), 
          (Stmt /*P*/ )null, new SourceLocation(ForLoc), new SourceLocation(RParenLoc))));
}


/// FinishObjCForCollectionStmt - Attach the body to a objective-C foreach
/// statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FinishObjCForCollectionStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2431,
 FQN="clang::Sema::FinishObjCForCollectionStmt", NM="_ZN5clang4Sema27FinishObjCForCollectionStmtEPNS_4StmtES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema27FinishObjCForCollectionStmtEPNS_4StmtES2_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > FinishObjCForCollectionStmt(Stmt /*P*/ S, Stmt /*P*/ B) {
  if (!(S != null) || !(B != null)) {
    return StmtError();
  }
  ObjCForCollectionStmt /*P*/ ForStmt = cast_ObjCForCollectionStmt(S);
  
  ForStmt.setBody(B);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
}


/// ActOnCXXForRangeStmt - Check and build a C++11 for-range statement.
///
/// C++11 [stmt.ranged]:
///   A range-based for statement is equivalent to
///
///   {
///     auto && __range = range-init;
///     for ( auto __begin = begin-expr,
///           __end = end-expr;
///           __begin != __end;
///           ++__begin ) {
///       for-range-declaration = *__begin;
///       statement
///     }
///   }
///
/// The body of the loop is not available yet, since it cannot be analysed until
/// we have determined the type of the for-range-declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXForRangeStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1961,
 FQN="clang::Sema::ActOnCXXForRangeStmt", NM="_ZN5clang4Sema20ActOnCXXForRangeStmtEPNS_5ScopeENS_14SourceLocationES3_PNS_4StmtES3_PNS_4ExprES3_NS0_17BuildForRangeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20ActOnCXXForRangeStmtEPNS_5ScopeENS_14SourceLocationES3_PNS_4StmtES3_PNS_4ExprES3_NS0_17BuildForRangeKindE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCXXForRangeStmt(Scope /*P*/ S, SourceLocation ForLoc, 
                    SourceLocation CoawaitLoc, Stmt /*P*/ First, 
                    SourceLocation ColonLoc, Expr /*P*/ Range, 
                    SourceLocation RParenLoc, 
                    BuildForRangeKind Kind) {
  if (!(First != null)) {
    return StmtError();
  }
  if ((Range != null) && ObjCEnumerationCollection(Range)) {
    return $this().ActOnObjCForCollectionStmt(new SourceLocation(ForLoc), First, Range, new SourceLocation(RParenLoc));
  }
  
  DeclStmt /*P*/ DS = dyn_cast_DeclStmt(First);
  assert ((DS != null)) : "first part of for range not a decl stmt";
  if (!DS.isSingleDecl()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(DS.getStartLoc(), diag.err_type_defined_in_for_range)));
      return StmtError();
    } finally {
      $c$.$destroy();
    }
  }
  
  Decl /*P*/ LoopVar = DS.getSingleDecl();
  if (LoopVar.isInvalidDecl() || !(Range != null)
     || $this().DiagnoseUnexpandedParameterPack(Range, UnexpandedParameterPackContext.UPPC_Expression)) {
    LoopVar.setInvalidDecl();
    return StmtError();
  }
  
  // Coroutines: 'for co_await' implicitly co_awaits its range.
  if (CoawaitLoc.isValid()) {
    ActionResultTTrue<Expr /*P*/ > Coawait = $this().ActOnCoawaitExpr(S, new SourceLocation(CoawaitLoc), Range);
    if (Coawait.isInvalid()) {
      return StmtError();
    }
    Range = Coawait.get();
  }
  
  // Build  auto && __range = range-init
  SourceLocation RangeLoc = Range.getLocStart();
  type$ptr<VarDecl /*P*/ > RangeVar = create_type$ptr(BuildForRangeVarDecl(/*Deref*/$this(), new SourceLocation(RangeLoc), 
      $this().Context.getAutoRRefDeductType(), 
      $("__range")));
  if (FinishForRangeVarDecl(/*Deref*/$this(), RangeVar.$star(), create_type$ptr(Range), new SourceLocation(RangeLoc), 
      diag.err_for_range_deduction_failure)) {
    LoopVar.setInvalidDecl();
    return StmtError();
  }
  
  // Claim the type doesn't contain auto: we've already done the checking.
  OpaquePtr<DeclGroupRef> RangeGroup = $this().BuildDeclaratorGroup(new MutableArrayRef<Decl /*P*/ >((type$ptr<? extends Decl /*P*/ /*P*/>)$AddrOf(RangeVar), 1, true), 
      /*TypeMayContainAuto=*/ false);
  ActionResultTTrue<Stmt /*P*/ > RangeDecl = $this().ActOnDeclStmt(new OpaquePtr<DeclGroupRef>(RangeGroup), new SourceLocation(RangeLoc), new SourceLocation(RangeLoc));
  if (RangeDecl.isInvalid()) {
    LoopVar.setInvalidDecl();
    return StmtError();
  }
  
  return $this().BuildCXXForRangeStmt(new SourceLocation(ForLoc), new SourceLocation(CoawaitLoc), new SourceLocation(ColonLoc), RangeDecl.get(), 
      /*BeginStmt=*/ (Stmt /*P*/ )null, /*EndStmt=*/ (Stmt /*P*/ )null, 
      /*Cond=*/ (Expr /*P*/ )null, /*Inc=*/ (Expr /*P*/ )null, 
      DS, new SourceLocation(RParenLoc), Kind);
}


/// BuildCXXForRangeStmt - Build or instantiate a C++11 for-range statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXForRangeStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2166,
 FQN="clang::Sema::BuildCXXForRangeStmt", NM="_ZN5clang4Sema20BuildCXXForRangeStmtENS_14SourceLocationES1_S1_PNS_4StmtES3_S3_PNS_4ExprES5_S3_S1_NS0_17BuildForRangeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20BuildCXXForRangeStmtENS_14SourceLocationES1_S1_PNS_4StmtES3_S3_PNS_4ExprES5_S3_S1_NS0_17BuildForRangeKindE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > BuildCXXForRangeStmt(SourceLocation ForLoc, SourceLocation CoawaitLoc, 
                    SourceLocation ColonLoc, Stmt /*P*/ RangeDecl, 
                    Stmt /*P*/ Begin, Stmt /*P*/ End, Expr /*P*/ Cond, 
                    Expr /*P*/ Inc, Stmt /*P*/ LoopVarDecl, 
                    SourceLocation RParenLoc, BuildForRangeKind Kind) {
  InvalidateOnErrorScope Invalidate = null;
  try {
    // FIXME: This should not be used during template instantiation. We should
    // pick up the set of unqualified lookup results for the != and + operators
    // in the initial parse.
    //
    // Testcase (accepts-invalid):
    //   template<typename T> void f() { for (auto x : T()) {} }
    //   namespace N { struct X { X begin(); X end(); int operator*(); }; }
    //   bool operator!=(N::X, N::X); void operator++(N::X);
    //   void g() { f<N::X>(); }
    Scope /*P*/ S = $this().getCurScope();
    
    DeclStmt /*P*/ RangeDS = cast_DeclStmt(RangeDecl);
    VarDecl /*P*/ RangeVar = cast_VarDecl(RangeDS.getSingleDecl());
    QualType RangeVarType = RangeVar.getType();
    
    DeclStmt /*P*/ LoopVarDS = cast_DeclStmt(LoopVarDecl);
    VarDecl /*P*/ LoopVar = cast_VarDecl(LoopVarDS.getSingleDecl());
    
    // If we hit any errors, mark the loop variable as invalid if its type
    // contains 'auto'.
    Invalidate/*J*/= new InvalidateOnErrorScope(/*Deref*/$this(), LoopVar, 
        LoopVar.getType().$arrow().isUndeducedType());
    
    ActionResultTTrue<Stmt /*P*/ > BeginDeclStmt = new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Begin);
    ActionResultTTrue<Stmt /*P*/ > EndDeclStmt = new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, End);
    ActionResultTTrue<Expr /*P*/ > NotEqExpr = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Cond);
    ActionResultTTrue<Expr /*P*/ > IncrExpr = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Inc);
    if (RangeVarType.$arrow().isDependentType()) {
      // The range is implicitly used as a placeholder when it is dependent.
      RangeVar.markUsed($this().Context);
      
      // Deduce any 'auto's in the loop variable as 'DependentTy'. We'll fill
      // them in properly when we instantiate the loop.
      if (!LoopVar.isInvalidDecl() && Kind != BuildForRangeKind.BFRK_Check) {
        LoopVar.setType($this().SubstAutoType(LoopVar.getType(), $this().Context.DependentTy.$QualType()));
      }
    } else if (!(BeginDeclStmt.get() != null)) {
      SourceLocation RangeLoc = RangeVar.getLocation();
      
      /*const*/ QualType RangeVarNonRefType = RangeVarType.getNonReferenceType();
      
      ActionResultTTrue<Expr /*P*/ > BeginRangeRef = $this().BuildDeclRefExpr(RangeVar, new QualType(RangeVarNonRefType), 
          ExprValueKind.VK_LValue, new SourceLocation(ColonLoc));
      if (BeginRangeRef.isInvalid()) {
        return StmtError();
      }
      
      ActionResultTTrue<Expr /*P*/ > EndRangeRef = $this().BuildDeclRefExpr(RangeVar, new QualType(RangeVarNonRefType), 
          ExprValueKind.VK_LValue, new SourceLocation(ColonLoc));
      if (EndRangeRef.isInvalid()) {
        return StmtError();
      }
      
      QualType AutoType = $this().Context.getAutoDeductType();
      Expr /*P*/ Range = RangeVar.getInit();
      if (!(Range != null)) {
        return StmtError();
      }
      QualType RangeType = Range.getType();
      if ($this().RequireCompleteType(new SourceLocation(RangeLoc), new QualType(RangeType), 
          diag.err_for_range_incomplete_type)) {
        return StmtError();
      }
      
      // Build auto __begin = begin-expr, __end = end-expr.
      VarDecl /*P*/ BeginVar = BuildForRangeVarDecl(/*Deref*/$this(), new SourceLocation(ColonLoc), new QualType(AutoType), 
          $("__begin"));
      VarDecl /*P*/ EndVar = BuildForRangeVarDecl(/*Deref*/$this(), new SourceLocation(ColonLoc), new QualType(AutoType), 
          $("__end"));
      
      // Build begin-expr and end-expr and attach to __begin and __end variables.
      ActionResultTTrue<Expr /*P*/ > BeginExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      ActionResultTTrue<Expr /*P*/ > EndExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      {
        /*const*/ ArrayType /*P*/ UnqAT = RangeType.$arrow().getAsArrayTypeUnsafe();
        if ((UnqAT != null)) {
          // - if _RangeT is an array type, begin-expr and end-expr are __range and
          //   __range + __bound, respectively, where __bound is the array bound. If
          //   _RangeT is an array of unknown size or an array of incomplete type,
          //   the program is ill-formed;
          
          // begin-expr is __range.
          BeginExpr.$assign(BeginRangeRef);
          if (FinishForRangeVarDecl(/*Deref*/$this(), BeginVar, create_type$ptr(BeginRangeRef.get()), new SourceLocation(ColonLoc), 
              diag.err_for_range_iter_deduction_failure)) {
            NoteForRangeBeginEndFunction(/*Deref*/$this(), BeginExpr.get(), BeginEndFunction.BEF_begin);
            return StmtError();
          }
          
          // Find the array bound.
          ActionResultTTrue<Expr /*P*/ > BoundExpr/*J*/= new ActionResultTTrue<Expr /*P*/ >();
          {
            /*const*/ ConstantArrayType /*P*/ CAT = dyn_cast_ConstantArrayType(UnqAT);
            if ((CAT != null)) {
              BoundExpr.$assign(IntegerLiteral.Create($this().Context, CAT.getSize(), $this().Context.getPointerDiffType(), new SourceLocation(RangeLoc)));
            } else {
              /*const*/ VariableArrayType /*P*/ VAT = dyn_cast_VariableArrayType(UnqAT);
              if ((VAT != null)) {
                BoundExpr.$assign(VAT.getSizeExpr());
              } else {
                // Can't be a DependentSizedArrayType or an IncompleteArrayType since
                // UnqAT is not incomplete and Range is not type-dependent.
                throw new llvm_unreachable("Unexpected array type in for-range");
              }
            }
          }
          
          // end-expr is __range + __bound.
          EndExpr.$assignMove($this().ActOnBinOp(S, new SourceLocation(ColonLoc), tok.TokenKind.plus, EndRangeRef.get(), 
                  BoundExpr.get()));
          if (EndExpr.isInvalid()) {
            return StmtError();
          }
          if (FinishForRangeVarDecl(/*Deref*/$this(), EndVar, create_type$ptr(EndExpr.get()), new SourceLocation(ColonLoc), 
              diag.err_for_range_iter_deduction_failure)) {
            NoteForRangeBeginEndFunction(/*Deref*/$this(), EndExpr.get(), BeginEndFunction.BEF_end);
            return StmtError();
          }
        } else {
          OverloadCandidateSet CandidateSet = null;
          try {
            CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(RangeLoc), 
                OverloadCandidateSet.CandidateSetKind.CSK_Normal);
            type$ptr<BeginEndFunction> BEFFailure = create_type$null$ptr();
            ForRangeStatus RangeStatus = BuildNonArrayForRange(/*Deref*/$this(), BeginRangeRef.get(), 
                EndRangeRef.get(), new QualType(RangeType), 
                BeginVar, EndVar, new SourceLocation(ColonLoc), $AddrOf(CandidateSet), 
                $AddrOf(BeginExpr), $AddrOf(EndExpr), $AddrOf(BEFFailure));
            if (Kind == BuildForRangeKind.BFRK_Build && RangeStatus == ForRangeStatus.FRS_NoViableFunction
               && BEFFailure.$star() == BeginEndFunction.BEF_begin) {
              {
                // If the range is being built from an array parameter, emit a
                // a diagnostic that it is being treated as a pointer.
                DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Range);
                if ((DRE != null)) {
                  {
                    ParmVarDecl /*P*/ PVD = dyn_cast_ParmVarDecl(DRE.getDecl());
                    if ((PVD != null)) {
                      QualType ArrayTy = PVD.getOriginalType();
                      QualType PointerTy = PVD.getType();
                      if (PointerTy.$arrow().isPointerType() && ArrayTy.$arrow().isArrayType()) {
                        JavaCleaner $c$ = $createJavaCleaner();
                        try {
                          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range.getLocStart(), diag.err_range_on_array_parameter)), 
                                          RangeLoc), PVD), ArrayTy), PointerTy));
                          $c$.clean($c$.track($this().Diag(PVD.getLocation(), diag.note_declared_at)));
                          return StmtError();
                        } finally {
                          $c$.$destroy();
                        }
                      }
                    }
                  }
                }
              }
              
              // If building the range failed, try dereferencing the range expression
              // unless a diagnostic was issued or the end function is problematic.
              ActionResultTTrue<Stmt /*P*/ > SR = RebuildForRangeWithDereference(/*Deref*/$this(), S, new SourceLocation(ForLoc), 
                  new SourceLocation(CoawaitLoc), 
                  LoopVarDecl, new SourceLocation(ColonLoc), 
                  Range, new SourceLocation(RangeLoc), 
                  new SourceLocation(RParenLoc));
              if (SR.isInvalid() || SR.isUsable()) {
                return SR;
              }
            }
            
            // Otherwise, emit diagnostics if we haven't already.
            if (RangeStatus == ForRangeStatus.FRS_NoViableFunction) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                Expr /*P*/ Range$1 = (BEFFailure.$star().getValue() != 0) ? EndRangeRef.get() : BeginRangeRef.get();
                $c$.clean($out_SemaDiagnosticBuilder_BegEndFunc($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Range$1.getLocStart(), diag.err_for_range_invalid)), 
                            RangeLoc), Range$1.getType()), BEFFailure));
                CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Range$1, true));
              } finally {
                $c$.$destroy();
              }
            }
            // Return an error if no fix was discovered.
            if (RangeStatus != ForRangeStatus.FRS_Success) {
              return StmtError();
            }
          } finally {
            if (CandidateSet != null) { CandidateSet.$destroy(); }
          }
        }
      }
      assert (!BeginExpr.isInvalid() && !EndExpr.isInvalid()) : "invalid range expression in for loop";
      
      // C++11 [dcl.spec.auto]p7: BeginType and EndType must be the same.
      // C++1z removes this restriction.
      QualType BeginType = BeginVar.getType();
      QualType EndType = EndVar.getType();
      if (!$this().Context.hasSameType(new QualType(BeginType), new QualType(EndType))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RangeLoc), $this().getLangOpts().CPlusPlus1z ? diag.warn_for_range_begin_end_types_differ : diag.ext_for_range_begin_end_types_differ)), 
                  BeginType), EndType));
          NoteForRangeBeginEndFunction(/*Deref*/$this(), BeginExpr.get(), BeginEndFunction.BEF_begin);
          NoteForRangeBeginEndFunction(/*Deref*/$this(), EndExpr.get(), BeginEndFunction.BEF_end);
        } finally {
          $c$.$destroy();
        }
      }
      
      BeginDeclStmt.$assignMove(
          $this().ActOnDeclStmt($this().ConvertDeclToDeclGroup(BeginVar), new SourceLocation(ColonLoc), new SourceLocation(ColonLoc))
      );
      EndDeclStmt.$assignMove(
          $this().ActOnDeclStmt($this().ConvertDeclToDeclGroup(EndVar), new SourceLocation(ColonLoc), new SourceLocation(ColonLoc))
      );
      
      /*const*/ QualType BeginRefNonRefType = BeginType.getNonReferenceType();
      ActionResultTTrue<Expr /*P*/ > BeginRef = $this().BuildDeclRefExpr(BeginVar, new QualType(BeginRefNonRefType), 
          ExprValueKind.VK_LValue, new SourceLocation(ColonLoc));
      if (BeginRef.isInvalid()) {
        return StmtError();
      }
      
      ActionResultTTrue<Expr /*P*/ > EndRef = $this().BuildDeclRefExpr(EndVar, EndType.getNonReferenceType(), 
          ExprValueKind.VK_LValue, new SourceLocation(ColonLoc));
      if (EndRef.isInvalid()) {
        return StmtError();
      }
      
      // Build and check __begin != __end expression.
      NotEqExpr.$assignMove($this().ActOnBinOp(S, new SourceLocation(ColonLoc), tok.TokenKind.exclaimequal, 
              BeginRef.get(), EndRef.get()));
      if (!NotEqExpr.isInvalid()) {
        NotEqExpr.$assignMove($this().CheckBooleanCondition(new SourceLocation(ColonLoc), NotEqExpr.get()));
      }
      if (!NotEqExpr.isInvalid()) {
        NotEqExpr.$assignMove($this().ActOnFinishFullExpr(NotEqExpr.get()));
      }
      if (NotEqExpr.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RangeLoc), diag.note_for_range_invalid_iterator)), 
                      RangeLoc), 0), BeginRangeRef.get().getType()));
          NoteForRangeBeginEndFunction(/*Deref*/$this(), BeginExpr.get(), BeginEndFunction.BEF_begin);
          if (!$this().Context.hasSameType(new QualType(BeginType), new QualType(EndType))) {
            NoteForRangeBeginEndFunction(/*Deref*/$this(), EndExpr.get(), BeginEndFunction.BEF_end);
          }
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Build and check ++__begin expression.
      BeginRef.$assignMove($this().BuildDeclRefExpr(BeginVar, new QualType(BeginRefNonRefType), 
              ExprValueKind.VK_LValue, new SourceLocation(ColonLoc)));
      if (BeginRef.isInvalid()) {
        return StmtError();
      }
      
      IncrExpr.$assignMove($this().ActOnUnaryOp(S, new SourceLocation(ColonLoc), tok.TokenKind.plusplus, BeginRef.get()));
      if (!IncrExpr.isInvalid() && CoawaitLoc.isValid()) {
        IncrExpr.$assignMove($this().ActOnCoawaitExpr(S, new SourceLocation(CoawaitLoc), IncrExpr.get()));
      }
      if (!IncrExpr.isInvalid()) {
        IncrExpr.$assignMove($this().ActOnFinishFullExpr(IncrExpr.get()));
      }
      if (IncrExpr.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RangeLoc), diag.note_for_range_invalid_iterator)), 
                      RangeLoc), 2), BeginRangeRef.get().getType()));
          NoteForRangeBeginEndFunction(/*Deref*/$this(), BeginExpr.get(), BeginEndFunction.BEF_begin);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Build and check *__begin  expression.
      BeginRef.$assignMove($this().BuildDeclRefExpr(BeginVar, new QualType(BeginRefNonRefType), 
              ExprValueKind.VK_LValue, new SourceLocation(ColonLoc)));
      if (BeginRef.isInvalid()) {
        return StmtError();
      }
      
      ActionResultTTrue<Expr /*P*/ > DerefExpr = $this().ActOnUnaryOp(S, new SourceLocation(ColonLoc), tok.TokenKind.star, BeginRef.get());
      if (DerefExpr.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(RangeLoc), diag.note_for_range_invalid_iterator)), 
                      RangeLoc), 1), BeginRangeRef.get().getType()));
          NoteForRangeBeginEndFunction(/*Deref*/$this(), BeginExpr.get(), BeginEndFunction.BEF_begin);
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Attach  *__begin  as initializer for VD. Don't touch it if we're just
      // trying to determine whether this would be a valid range.
      if (!LoopVar.isInvalidDecl() && Kind != BuildForRangeKind.BFRK_Check) {
        $this().AddInitializerToDecl(LoopVar, DerefExpr.get(), /*DirectInit=*/ false, 
            /*TypeMayContainAuto=*/ true);
        if (LoopVar.isInvalidDecl()) {
          NoteForRangeBeginEndFunction(/*Deref*/$this(), BeginExpr.get(), BeginEndFunction.BEF_begin);
        }
      }
    }
    
    // Don't bother to actually allocate the result if we're just trying to
    // determine whether it would be valid.
    if (Kind == BuildForRangeKind.BFRK_Check) {
      return new ActionResultTTrue<Stmt /*P*/ >();
    }
    
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXForRangeStmt(RangeDS, cast_or_null_DeclStmt(BeginDeclStmt.get()), 
            cast_or_null_DeclStmt(EndDeclStmt.get()), NotEqExpr.get(), 
            IncrExpr.get(), LoopVarDS, /*Body=*/ (Stmt /*P*/ )null, new SourceLocation(ForLoc), new SourceLocation(CoawaitLoc), 
            new SourceLocation(ColonLoc), new SourceLocation(RParenLoc))));
  } finally {
    if (Invalidate != null) { Invalidate.$destroy(); }
  }
}


/// FinishCXXForRangeStmt - Attach the body to a C++0x for-range statement.
/// This is a separate step from ActOnCXXForRangeStmt because analysis of the
/// body cannot be performed until after the type of the range variable is
/// determined.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FinishCXXForRangeStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2598,
 FQN="clang::Sema::FinishCXXForRangeStmt", NM="_ZN5clang4Sema21FinishCXXForRangeStmtEPNS_4StmtES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema21FinishCXXForRangeStmtEPNS_4StmtES2_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > FinishCXXForRangeStmt(Stmt /*P*/ S, Stmt /*P*/ B) {
  if (!(S != null) || !(B != null)) {
    return StmtError();
  }
  if (isa_ObjCForCollectionStmt(S)) {
    return $this().FinishObjCForCollectionStmt(S, B);
  }
  
  CXXForRangeStmt /*P*/ ForStmt = cast_CXXForRangeStmt(S);
  ForStmt.setBody(B);
  
  $this().DiagnoseEmptyStmtBody(ForStmt.getRParenLoc(), B, 
      diag.warn_empty_range_based_for_body);
  
  DiagnoseForRangeVariableCopies(/*Deref*/$this(), ForStmt);
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, S);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnGotoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2616,
 FQN="clang::Sema::ActOnGotoStmt", NM="_ZN5clang4Sema13ActOnGotoStmtENS_14SourceLocationES1_PNS_9LabelDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema13ActOnGotoStmtENS_14SourceLocationES1_PNS_9LabelDeclE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnGotoStmt(SourceLocation GotoLoc, 
             SourceLocation LabelLoc, 
             LabelDecl /*P*/ TheDecl) {
  $this().getCurFunction().setHasBranchIntoScope();
  TheDecl.markUsed($this().Context);
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new GotoStmt(TheDecl, new SourceLocation(GotoLoc), new SourceLocation(LabelLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnIndirectGotoStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2624,
 FQN="clang::Sema::ActOnIndirectGotoStmt", NM="_ZN5clang4Sema21ActOnIndirectGotoStmtENS_14SourceLocationES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema21ActOnIndirectGotoStmtENS_14SourceLocationES1_PNS_4ExprE")
//</editor-fold>

public final ActionResultTTrue<Stmt /*P*/ > ActOnIndirectGotoStmt(final SourceLocation GotoLoc, final SourceLocation StarLoc, 
                     Expr /*P*/ E) {
  // Convert operand to void*
  if (!E.isTypeDependent()) {
    QualType ETy = E.getType();
    QualType DestTy = $this().Context.getPointerType($this().Context.VoidTy.withConst());
    ActionResultTTrue<Expr /*P*/ > ExprRes = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    AssignConvertType ConvTy = $this().CheckSingleAssignmentConstraints(new QualType(DestTy), ExprRes);
    if (ExprRes.isInvalid()) {
      return SemaClangGlobals.StmtError();
    }
    E = ExprRes.get();
    if ($this().DiagnoseAssignmentResult(ConvTy, new SourceLocation(StarLoc), new QualType(DestTy), new QualType(ETy), E, AssignmentAction.AA_Passing)) {
      return SemaClangGlobals.StmtError();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > ExprRes = $this().ActOnFinishFullExpr(E);
  if (ExprRes.isInvalid()) {
    return SemaClangGlobals.StmtError();
  }
  E = ExprRes.get();
  
  $this().getCurFunction().setHasIndirectGoto();
  
  final Expr /*P*/ $E = E;
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new IndirectGotoStmt(new SourceLocation(GotoLoc), new SourceLocation(StarLoc), $E);
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnContinueStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2659,
 FQN="clang::Sema::ActOnContinueStmt", NM="_ZN5clang4Sema17ActOnContinueStmtENS_14SourceLocationEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema17ActOnContinueStmtENS_14SourceLocationEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnContinueStmt(SourceLocation ContinueLoc, Scope /*P*/ CurScope) {
  Scope /*P*/ S = CurScope.getContinueParent();
  if (!(S != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C99 6.8.6.2p1: A break shall appear only in or as a loop body.
      return $c$.clean(StmtError($c$.track($this().Diag(new SourceLocation(ContinueLoc), diag.err_continue_not_in_loop))));
    } finally {
      $c$.$destroy();
    }
  }
  CheckJumpOutOfSEHFinally(/*Deref*/$this(), new SourceLocation(ContinueLoc), $Deref(S));
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ContinueStmt(new SourceLocation(ContinueLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnBreakStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2671,
 FQN="clang::Sema::ActOnBreakStmt", NM="_ZN5clang4Sema14ActOnBreakStmtENS_14SourceLocationEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema14ActOnBreakStmtENS_14SourceLocationEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnBreakStmt(SourceLocation BreakLoc, Scope /*P*/ CurScope) {
  Scope /*P*/ S = CurScope.getBreakParent();
  if (!(S != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C99 6.8.6.3p1: A break shall appear only in or as a switch/loop body.
      return $c$.clean(StmtError($c$.track($this().Diag(new SourceLocation(BreakLoc), diag.err_break_not_in_loop_or_switch))));
    } finally {
      $c$.$destroy();
    }
  }
  if (S.isOpenMPLoopScope()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(BreakLoc), diag.err_omp_loop_cannot_use_stmt)), 
              /*KEEP_STR*/"break")));
    } finally {
      $c$.$destroy();
    }
  }
  CheckJumpOutOfSEHFinally(/*Deref*/$this(), new SourceLocation(BreakLoc), $Deref(S));
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new BreakStmt(new SourceLocation(BreakLoc))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCapturedRegionStart">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3882,
 FQN="clang::Sema::ActOnCapturedRegionStart", NM="_ZN5clang4Sema24ActOnCapturedRegionStartENS_14SourceLocationEPNS_5ScopeENS_18CapturedRegionKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema24ActOnCapturedRegionStartENS_14SourceLocationEPNS_5ScopeENS_18CapturedRegionKindEj")
//</editor-fold>
public final void ActOnCapturedRegionStart(SourceLocation Loc, Scope /*P*/ CurScope, 
                        CapturedRegionKind Kind, 
                        /*uint*/int NumParams) {
  type$ptr<CapturedDecl /*P*/ > CD = create_type$null$ptr(null);
  RecordDecl /*P*/ RD = $this().CreateCapturedStmtRecordDecl(CD, new SourceLocation(Loc), NumParams);
  
  // Build the context parameter
  DeclContext /*P*/ DC = CapturedDecl.castToDeclContext(CD.$star());
  IdentifierInfo /*P*/ ParamName = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__context")));
  QualType ParamType = $this().Context.getPointerType($this().Context.getTagDeclType(RD));
  ImplicitParamDecl /*P*/ Param = ImplicitParamDecl.Create($this().Context, DC, new SourceLocation(Loc), ParamName, new QualType(ParamType));
  DC.addDecl(Param);
  
  CD.$star().setContextParam(0, Param);
  
  // Enter the capturing scope for this captured region.
  $this().PushCapturedRegionScope(CurScope, CD.$star(), RD, Kind);
  if ((CurScope != null)) {
    $this().PushDeclContext(CurScope, CD.$star());
  } else {
    $this().CurContext = CD.$star();
  }
  
  $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCapturedRegionStart">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3909,
 FQN="clang::Sema::ActOnCapturedRegionStart", NM="_ZN5clang4Sema24ActOnCapturedRegionStartENS_14SourceLocationEPNS_5ScopeENS_18CapturedRegionKindEN4llvm8ArrayRefISt4pairINS5_9StringRefENS_8QualTypeEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema24ActOnCapturedRegionStartENS_14SourceLocationEPNS_5ScopeENS_18CapturedRegionKindEN4llvm8ArrayRefISt4pairINS5_9StringRefENS_8QualTypeEEEE")
//</editor-fold>
public final void ActOnCapturedRegionStart(SourceLocation Loc, Scope /*P*/ CurScope, 
                        CapturedRegionKind Kind, 
                        ArrayRef<std.pair<StringRef, QualType>> Params) {
  type$ptr<CapturedDecl /*P*/ > CD = create_type$null$ptr(null);
  RecordDecl /*P*/ RD = $this().CreateCapturedStmtRecordDecl(CD, new SourceLocation(Loc), Params.size());
  
  // Build the context parameter
  DeclContext /*P*/ DC = CapturedDecl.castToDeclContext(CD.$star());
  boolean ContextIsFound = false;
  /*uint*/int ParamNum = 0;
  for (type$ptr<std.pair<StringRef, QualType>> I = $tryClone(Params.begin()), 
      /*P*/ E = $tryClone(Params.end());
       $noteq_ptr(I, E); I.$preInc() , ++ParamNum) {
    if (I./*->*/$star().second.isNull()) {
      assert (!ContextIsFound) : "null type has been found already for '__context' parameter";
      IdentifierInfo /*P*/ ParamName = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__context")));
      QualType ParamType = $this().Context.getPointerType($this().Context.getTagDeclType(RD));
      ImplicitParamDecl /*P*/ Param = ImplicitParamDecl.Create($this().Context, DC, new SourceLocation(Loc), ParamName, new QualType(ParamType));
      DC.addDecl(Param);
      CD.$star().setContextParam(ParamNum, Param);
      ContextIsFound = true;
    } else {
      IdentifierInfo /*P*/ ParamName = $AddrOf($this().Context.Idents.get(/*NO_COPY*/I./*->*/$star().first));
      ImplicitParamDecl /*P*/ Param = ImplicitParamDecl.Create($this().Context, DC, new SourceLocation(Loc), ParamName, new QualType(I./*->*/$star().second));
      DC.addDecl(Param);
      CD.$star().setParam(ParamNum, Param);
    }
  }
  assert (ContextIsFound) : "no null type for '__context' parameter";
  if (!ContextIsFound) {
    // Add __context implicitly if it is not specified.
    IdentifierInfo /*P*/ ParamName = $AddrOf($this().Context.Idents.get(new StringRef(/*KEEP_STR*/"__context")));
    QualType ParamType = $this().Context.getPointerType($this().Context.getTagDeclType(RD));
    ImplicitParamDecl /*P*/ Param = ImplicitParamDecl.Create($this().Context, DC, new SourceLocation(Loc), ParamName, new QualType(ParamType));
    DC.addDecl(Param);
    CD.$star().setContextParam(ParamNum, Param);
  }
  // Enter the capturing scope for this captured region.
  $this().PushCapturedRegionScope(CurScope, CD.$star(), RD, Kind);
  if ((CurScope != null)) {
    $this().PushDeclContext(CurScope, CD.$star());
  } else {
    $this().CurContext = CD.$star();
  }
  
  $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCapturedRegionEnd">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3977,
 FQN="clang::Sema::ActOnCapturedRegionEnd", NM="_ZN5clang4Sema22ActOnCapturedRegionEndEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema22ActOnCapturedRegionEndEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCapturedRegionEnd(Stmt /*P*/ S) {
  CapturedRegionScopeInfo /*P*/ RSI = $this().getCurCapturedRegion();
  
  SmallVector<CapturedStmt.Capture> Captures/*J*/= new SmallVector<CapturedStmt.Capture>(4, new CapturedStmt.Capture());
  SmallVector<Expr /*P*/ > CaptureInits/*J*/= new SmallVector<Expr /*P*/ >(4, (Expr /*P*/ )null);
  buildCapturedStmtCaptureList(Captures, CaptureInits, new ArrayRef<CapturingScopeInfo.Capture>(RSI.Captures, false));
  
  CapturedDecl /*P*/ CD = RSI.TheCapturedDecl;
  RecordDecl /*P*/ RD = RSI.TheRecordDecl;
  
  CapturedStmt /*P*/ Res = CapturedStmt.Create($this().getASTContext(), S, /*static_cast*/CapturedRegionKind.valueOf(RSI.CapRegionKind), 
      new ArrayRef<CapturedStmt.Capture>(Captures, false), new ArrayRef<Expr /*P*/ >(CaptureInits, true), CD, RD);
  
  CD.setBody(Res.getCapturedStmt());
  RD.completeDefinition();
  
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
  
  $this().PopDeclContext();
  $this().PopFunctionScopeInfo();
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Res);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCapturedRegionError">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3961,
 FQN="clang::Sema::ActOnCapturedRegionError", NM="_ZN5clang4Sema24ActOnCapturedRegionErrorEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema24ActOnCapturedRegionErrorEv")
//</editor-fold>
public final void ActOnCapturedRegionError() {
  $this().DiscardCleanupsInEvaluationContext();
  $this().PopExpressionEvaluationContext();
  
  CapturedRegionScopeInfo /*P*/ RSI = $this().getCurCapturedRegion();
  RecordDecl /*P*/ Record = RSI.TheRecordDecl;
  Record.setInvalidDecl();
  
  SmallVector<Decl /*P*/> Fields/*J*/= new SmallVector<Decl /*P*/>(4, Record.fields().begin(), Record.fields().end(), null);
  $this().ActOnFields(/*Scope=*/ (Scope /*P*/ )null, Record.getLocation(), Record, new ArrayRef<Decl /*P*/ >(Fields, true), 
      new SourceLocation(), new SourceLocation(), /*AttributeList=*/ (AttributeList /*P*/ )null);
  
  $this().PopDeclContext();
  $this().PopFunctionScopeInfo();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateCapturedStmtRecordDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3828,
 FQN="clang::Sema::CreateCapturedStmtRecordDecl", NM="_ZN5clang4Sema28CreateCapturedStmtRecordDeclERPNS_12CapturedDeclENS_14SourceLocationEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema28CreateCapturedStmtRecordDeclERPNS_12CapturedDeclENS_14SourceLocationEj")
//</editor-fold>
public final RecordDecl /*P*/ CreateCapturedStmtRecordDecl(final type$ptr<CapturedDecl /*P*/ /*&*/> CD, SourceLocation Loc, 
                            /*uint*/int NumParams) {
  DeclContext /*P*/ DC = $this().CurContext;
  while (!(DC.isFunctionOrMethod() || DC.isRecord() || DC.isFileContext())) {
    DC = DC.getParent();
  }
  
  RecordDecl /*P*/ RD = null;
  if ($this().getLangOpts().CPlusPlus) {
    RD = CXXRecordDecl.Create($this().Context, TagTypeKind.TTK_Struct, DC, new SourceLocation(Loc), new SourceLocation(Loc), 
        /*Id=*/ (IdentifierInfo /*P*/ )null);
  } else {
    RD = RecordDecl.Create($this().Context, TagTypeKind.TTK_Struct, DC, new SourceLocation(Loc), new SourceLocation(Loc), /*Id=*/ (IdentifierInfo /*P*/ )null);
  }
  
  RD.setCapturedRecord();
  DC.addDecl(RD);
  RD.setImplicit();
  RD.startDefinition();
  assert ($greater_uint(NumParams, 0)) : "CapturedStmt requires context parameter";
  CD.$set(CapturedDecl.Create($this().Context, $this().CurContext, NumParams));
  DC.addDecl(CD.$star());
  return RD;
}


/// \brief Determine whether the given expression is a candidate for
/// copy elision in either a return statement or a throw expression.
///
/// \param ReturnType If we're determining the copy elision candidate for
/// a return statement, this is the return type of the function. If we're
/// determining the copy elision candidate for a throw expression, this will
/// be a NULL type.
///
/// \param E The expression being returned from the function or block, or
/// being thrown.
///
/// \param AllowParamOrMoveConstructible Whether we allow function parameters or
/// id-expressions that could be moved out of the function to be considered NRVO
/// candidates. C++ prohibits these for NRVO itself, but we re-use this logic to
/// determine whether we should try to move as part of a return or throw (which
/// does allow function parameters).
///
/// \returns The NRVO candidate variable, if the return statement may use the
/// NRVO, or NULL if there is no such candidate.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCopyElisionCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2705,
 FQN="clang::Sema::getCopyElisionCandidate", NM="_ZN5clang4Sema23getCopyElisionCandidateENS_8QualTypeEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema23getCopyElisionCandidateENS_8QualTypeEPNS_4ExprEb")
//</editor-fold>
public final VarDecl /*P*/ getCopyElisionCandidate(QualType ReturnType, Expr /*P*/ E, 
                       boolean AllowParamOrMoveConstructible) {
  if (!$this().getLangOpts().CPlusPlus) {
    return null;
  }
  
  // - in a return statement in a function [where] ...
  // ... the expression is the name of a non-volatile automatic object ...
  DeclRefExpr /*P*/ DR = dyn_cast_DeclRefExpr(E.IgnoreParens());
  if (!(DR != null) || DR.refersToEnclosingVariableOrCapture()) {
    return null;
  }
  VarDecl /*P*/ VD = dyn_cast_VarDecl(DR.getDecl());
  if (!(VD != null)) {
    return null;
  }
  if ($this().isCopyElisionCandidate(new QualType(ReturnType), VD, AllowParamOrMoveConstructible)) {
    return VD;
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isCopyElisionCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2724,
 FQN="clang::Sema::isCopyElisionCandidate", NM="_ZN5clang4Sema22isCopyElisionCandidateENS_8QualTypeEPKNS_7VarDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema22isCopyElisionCandidateENS_8QualTypeEPKNS_7VarDeclEb")
//</editor-fold>
public final boolean isCopyElisionCandidate(QualType ReturnType, /*const*/ VarDecl /*P*/ VD, 
                      boolean AllowParamOrMoveConstructible) {
  QualType VDType = VD.getType();
  // - in a return statement in a function with ...
  // ... a class return type ...
  if (!ReturnType.isNull() && !ReturnType.$arrow().isDependentType()) {
    if (!ReturnType.$arrow().isRecordType()) {
      return false;
    }
    // ... the same cv-unqualified type as the function return type ...
    // When considering moving this expression out, allow dissimilar types.
    if (!AllowParamOrMoveConstructible && !VDType.$arrow().isDependentType()
       && !$this().Context.hasSameUnqualifiedType(new QualType(ReturnType), new QualType(VDType))) {
      return false;
    }
  }
  
  // ...object (other than a function or catch-clause parameter)...
  if (VD.getKind() != Decl.Kind.Var
     && !(AllowParamOrMoveConstructible && VD.getKind() == Decl.Kind.ParmVar)) {
    return false;
  }
  if (VD.isExceptionVariable()) {
    return false;
  }
  
  // ...automatic...
  if (!VD.hasLocalStorage()) {
    return false;
  }
  if (AllowParamOrMoveConstructible) {
    return true;
  }
  
  // ...non-volatile...
  if (VD.getType().isVolatileQualified()) {
    return false;
  }
  
  // __block variables can't be allocated in a way that permits NRVO.
  if (VD.hasAttr(BlocksAttr.class)) {
    return false;
  }
  
  // Variables with higher required alignment than their type's ABI
  // alignment cannot use NRVO.
  if (!VD.getType().$arrow().isDependentType() && VD.hasAttr(AlignedAttr.class)
     && $this().Context.getDeclAlign(VD).$greater($this().Context.getTypeAlignInChars(VD.getType()))) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnReturnStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3157,
 FQN="clang::Sema::ActOnReturnStmt", NM="_ZN5clang4Sema15ActOnReturnStmtENS_14SourceLocationEPNS_4ExprEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema15ActOnReturnStmtENS_14SourceLocationEPNS_4ExprEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnReturnStmt(SourceLocation ReturnLoc, type$ptr<Expr /*P*/> RetValExp, 
               Scope /*P*/ CurScope) {
  ActionResultTTrue<Stmt /*P*/ > R = $this().BuildReturnStmt(new SourceLocation(ReturnLoc), RetValExp);
  if (R.isInvalid() || $this().ExprEvalContexts.back().Context == ExpressionEvaluationContext.DiscardedStatement) {
    return R;
  }
  {
    
    VarDecl /*P*/ VD = ((/*const_cast*/VarDecl /*P*/ )(cast_ReturnStmt(R.get()).getNRVOCandidate()));
    if ((VD != null)) {
      CurScope.addNRVOCandidate(VD);
    } else {
      CurScope.setNoNRVO();
    }
  }
  
  CheckJumpOutOfSEHFinally(/*Deref*/$this(), new SourceLocation(ReturnLoc), $Deref(CurScope.getFnParent()));
  
  return R;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildReturnStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3176,
 FQN="clang::Sema::BuildReturnStmt", NM="_ZN5clang4Sema15BuildReturnStmtENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema15BuildReturnStmtENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > BuildReturnStmt(SourceLocation ReturnLoc, type$ptr<Expr /*P*/> RetValExp) {
  // Check for unexpanded parameter packs.
  if ((RetValExp.$star() != null) && $this().DiagnoseUnexpandedParameterPack(RetValExp.$star())) {
    return StmtError();
  }
  if (isa_CapturingScopeInfo($this().getCurFunction())) {
    return $this().ActOnCapScopeReturnStmt(new SourceLocation(ReturnLoc), RetValExp);
  }
  
  QualType FnRetType/*J*/= new QualType();
  QualType RelatedRetType/*J*/= new QualType();
  /*const*/SmallVector<Attr /*P*/>/*P*/ Attrs = null;
  boolean isObjCMethod = false;
  {
    
    /*const*/ FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
    if ((FD != null)) {
      FnRetType.$assignMove(FD.getReturnType());
      if (FD.hasAttrs()) {
        Attrs = $AddrOf(FD.getAttrs$Const());
      }
      if (FD.isNoReturn()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.warn_noreturn_function_has_return_expr)), 
              FD.getDeclName()));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      ObjCMethodDecl /*P*/ MD = $this().getCurMethodDecl();
      if ((MD != null)) {
        FnRetType.$assignMove(MD.getReturnType());
        isObjCMethod = true;
        if (MD.hasAttrs()) {
          Attrs = $AddrOf(MD.getAttrs());
        }
        if (MD.hasRelatedResultType() && (MD.getClassInterface() != null)) {
          // In the implementation of a method with a related return type, the
          // type used to type-check the validity of return statements within the
          // method body is a pointer to the type of the class being implemented.
          RelatedRetType.$assignMove($this().Context.getObjCInterfaceType(MD.getClassInterface()));
          RelatedRetType.$assignMove($this().Context.getObjCObjectPointerType(new QualType(RelatedRetType)));
        }
      } else { // If we don't have a function/method context, bail.
        return StmtError();
      }
    }
  }
  
  // C++1z: discarded return statements are not considered when deducing a
  // return type.
  if ($this().ExprEvalContexts.back().Context == ExpressionEvaluationContext.DiscardedStatement
     && (FnRetType.$arrow().getContainedAutoType() != null)) {
    if ((RetValExp.$star() != null)) {
      ActionResultTTrue<Expr /*P*/ > ER = $this().ActOnFinishFullExpr(RetValExp.$star(), new SourceLocation(ReturnLoc));
      if (ER.isInvalid()) {
        return StmtError();
      }
      RetValExp.$set(ER.get());
    }
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ReturnStmt(new SourceLocation(ReturnLoc), RetValExp.$star(), (/*const*/ VarDecl /*P*/ )null)));
  }
  
  // FIXME: Add a flag to the ScopeInfo to indicate whether we're performing
  // deduction.
  if ($this().getLangOpts().CPlusPlus14) {
    {
      AutoType /*P*/ AT = FnRetType.$arrow().getContainedAutoType();
      if ((AT != null)) {
        FunctionDecl /*P*/ FD = cast_FunctionDecl($this().CurContext);
        if ($this().DeduceFunctionTypeFromReturnExpr(FD, new SourceLocation(ReturnLoc), RetValExp.star$ref(), AT)) {
          FD.setInvalidDecl();
          return StmtError();
        } else {
          FnRetType.$assignMove(FD.getReturnType());
        }
      }
    }
  }
  
  boolean HasDependentReturnType = FnRetType.$arrow().isDependentType();
  
  ReturnStmt /*P*/ Result = null;
  if (FnRetType.$arrow().isVoidType()) {
    if ((RetValExp.$star() != null)) {
      if (isa_InitListExpr(RetValExp)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // We simply never allow init lists as the return value of void
          // functions. This is compatible because this was never allowed before,
          // so there's no legacy code to deal with.
          NamedDecl /*P*/ CurDecl = $this().getCurFunctionOrMethodDecl();
          int FunctionKind = 0;
          if (isa_ObjCMethodDecl(CurDecl)) {
            FunctionKind = 1;
          } else if (isa_CXXConstructorDecl(CurDecl)) {
            FunctionKind = 2;
          } else if (isa_CXXDestructorDecl(CurDecl)) {
            FunctionKind = 3;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_return_init_list)), 
                      CurDecl.getDeclName()), FunctionKind), 
              RetValExp.$star().getSourceRange()));
          
          // Drop the expression.
          RetValExp.$set(null);
        } finally {
          $c$.$destroy();
        }
      } else if (!RetValExp.$star().isTypeDependent()) {
        // C99 6.8.6.4p1 (ext_ since GCC warns)
        /*uint*/int D = diag.ext_return_has_expr;
        if (RetValExp.$star().getType().$arrow().isVoidType()) {
          NamedDecl /*P*/ CurDecl = $this().getCurFunctionOrMethodDecl();
          if (isa_CXXConstructorDecl(CurDecl)
             || isa_CXXDestructorDecl(CurDecl)) {
            D = diag.err_ctor_dtor_returns_void;
          } else {
            D = diag.ext_return_has_void_expr;
          }
        } else {
          ActionResultTTrue<Expr /*P*/ > Result$1 = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, RetValExp.$star());
          Result$1.$assignMove($this().IgnoredValueConversions(Result$1.get()));
          if (Result$1.isInvalid()) {
            return StmtError();
          }
          RetValExp.$set(Result$1.get());
          RetValExp.$set($this().ImpCastExprToType(RetValExp.$star(), 
              $this().Context.VoidTy.$QualType(), CastKind.CK_ToVoid).get());
        }
        // return of void in constructor/destructor is illegal in C++.
        if (D == diag.err_ctor_dtor_returns_void) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            NamedDecl /*P*/ CurDecl = $this().getCurFunctionOrMethodDecl();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), D)), 
                        CurDecl.getDeclName()), isa_CXXDestructorDecl(CurDecl)), 
                RetValExp.$star().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        } else // return (some void expression); is legal in C++.
        if (D != diag.ext_return_has_void_expr
           || !$this().getLangOpts().CPlusPlus) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            NamedDecl /*P*/ CurDecl = $this().getCurFunctionOrMethodDecl();
            
            int FunctionKind = 0;
            if (isa_ObjCMethodDecl(CurDecl)) {
              FunctionKind = 1;
            } else if (isa_CXXConstructorDecl(CurDecl)) {
              FunctionKind = 2;
            } else if (isa_CXXDestructorDecl(CurDecl)) {
              FunctionKind = 3;
            }
            
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), D)), 
                        CurDecl.getDeclName()), FunctionKind), 
                RetValExp.$star().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      if ((RetValExp.$star() != null)) {
        ActionResultTTrue<Expr /*P*/ > ER = $this().ActOnFinishFullExpr(RetValExp.$star(), new SourceLocation(ReturnLoc));
        if (ER.isInvalid()) {
          return StmtError();
        }
        RetValExp.$set(ER.get());
      }
    }
    
    Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ReturnStmt(new SourceLocation(ReturnLoc), RetValExp.$star(), (/*const*/ VarDecl /*P*/ )null));
  } else if (!(RetValExp.$star() != null) && !HasDependentReturnType) {
    FunctionDecl /*P*/ FD = $this().getCurFunctionDecl();
    
    /*uint*/int DiagID;
    if ($this().getLangOpts().CPlusPlus11 && (FD != null) && FD.isConstexpr()) {
      // C++11 [stmt.return]p2
      DiagID = diag.err_constexpr_return_missing_expr;
      FD.setInvalidDecl();
    } else if ($this().getLangOpts().C99) {
      // C99 6.8.6.4p1 (ext_ since GCC warns)
      DiagID = diag.ext_return_missing_expr;
    } else {
      // C90 6.6.6.4p4
      DiagID = diag.warn_return_missing_expr;
    }
    if ((FD != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), DiagID)), FD.getIdentifier()), 0/*fn*/));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), DiagID)), $this().getCurMethodDecl().getDeclName()), 1/*meth*/));
      } finally {
        $c$.$destroy();
      }
    }
    
    Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ReturnStmt(new SourceLocation(ReturnLoc)));
  } else {
    assert ((RetValExp.$star() != null) || HasDependentReturnType);
    /*const*/ VarDecl /*P*/ NRVOCandidate = null;
    
    QualType RetType = new QualType(RelatedRetType.isNull() ? FnRetType : RelatedRetType);
    
    // C99 6.8.6.4p3(136): The return statement is not an assignment. The
    // overlap restriction of subclause 6.5.16.1 does not apply to the case of
    // function return.
    
    // In C++ the return statement is handled via a copy initialization,
    // the C version of which boils down to CheckSingleAssignmentConstraints.
    if ((RetValExp.$star() != null)) {
      NRVOCandidate = $this().getCopyElisionCandidate(new QualType(FnRetType), RetValExp.$star(), false);
    }
    if (!HasDependentReturnType && !RetValExp.$star().isTypeDependent()) {
      // we have a non-void function with an expression, continue checking
      InitializedEntity Entity = InitializedEntity.InitializeResult(new SourceLocation(ReturnLoc), 
          new QualType(RetType), 
          NRVOCandidate != (/*const*/ VarDecl /*P*/ )null);
      ActionResultTTrue<Expr /*P*/ > Res = $this().PerformMoveOrCopyInitialization(Entity, NRVOCandidate, 
          new QualType(RetType), RetValExp.$star());
      if (Res.isInvalid()) {
        // FIXME: Clean up temporaries here anyway?
        return StmtError();
      }
      RetValExp.$set(Res.getAs(Expr.class));
      
      // If we have a related result type, we need to implicitly
      // convert back to the formal result type.  We can't pretend to
      // initialize the result again --- we might end double-retaining
      // --- so instead we initialize a notional temporary.
      if (!RelatedRetType.isNull()) {
        Entity.$assignMove(InitializedEntity.InitializeRelatedResult($this().getCurMethodDecl(), 
                new QualType(FnRetType)));
        Res.$assignMove($this().PerformCopyInitialization(Entity, new SourceLocation(ReturnLoc), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, RetValExp.$star())));
        if (Res.isInvalid()) {
          // FIXME: Clean up temporaries here anyway?
          return StmtError();
        }
        RetValExp.$set(Res.getAs(Expr.class));
      }
      
      $this().CheckReturnValExpr(RetValExp.$star(), new QualType(FnRetType), new SourceLocation(ReturnLoc), isObjCMethod, Attrs, 
          $this().getCurFunctionDecl());
    }
    if ((RetValExp.$star() != null)) {
      ActionResultTTrue<Expr /*P*/ > ER = $this().ActOnFinishFullExpr(RetValExp.$star(), new SourceLocation(ReturnLoc));
      if (ER.isInvalid()) {
        return StmtError();
      }
      RetValExp.$set(ER.get());
    }
    final VarDecl /*P*/ L$NRVOCandidate = NRVOCandidate;
    Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
        return new ReturnStmt(new SourceLocation(ReturnLoc), RetValExp.$star(), L$NRVOCandidate);
     });
  }
  
  // If we need to check for the named return value optimization, save the
  // return statement in our scope for later processing.
  if ((Result.getNRVOCandidate() != null)) {
    $this().FunctionScopes.back().Returns.push_back(Result);
  }
  if ($this().FunctionScopes.back().FirstReturnLoc.isInvalid()) {
    $this().FunctionScopes.back().FirstReturnLoc.$assign(ReturnLoc);
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Result);
}


/// ActOnCapScopeReturnStmt - Utility routine to type-check return statements
/// for capturing scopes.
///
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCapScopeReturnStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 2859,
 FQN="clang::Sema::ActOnCapScopeReturnStmt", NM="_ZN5clang4Sema23ActOnCapScopeReturnStmtENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema23ActOnCapScopeReturnStmtENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCapScopeReturnStmt(SourceLocation ReturnLoc, type$ptr<Expr /*P*/> RetValExp) {
  // If this is the first return we've seen, infer the return type.
  // [expr.prim.lambda]p4 in C++11; block literals follow the same rules.
  CapturingScopeInfo /*P*/ CurCap = cast_CapturingScopeInfo($this().getCurFunction());
  QualType FnRetType = new QualType(CurCap.ReturnType);
  LambdaScopeInfo /*P*/ CurLambda = dyn_cast_LambdaScopeInfo(CurCap);
  boolean HasDeducedReturnType = (CurLambda != null) && hasDeducedReturnType(CurLambda.CallOperator);
  if ($this().ExprEvalContexts.back().Context == ExpressionEvaluationContext.DiscardedStatement
     && (HasDeducedReturnType || CurCap.HasImplicitReturnType)) {
    if ((RetValExp.$star() != null)) {
      ActionResultTTrue<Expr /*P*/ > ER = $this().ActOnFinishFullExpr(RetValExp.$star(), new SourceLocation(ReturnLoc));
      if (ER.isInvalid()) {
        return StmtError();
      }
      RetValExp.$set(ER.get());
    }
    return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ReturnStmt(new SourceLocation(ReturnLoc), RetValExp.$star(), (/*const*/ VarDecl /*P*/ )null)));
  }
  if (HasDeducedReturnType) {
    // In C++1y, the return type may involve 'auto'.
    // FIXME: Blocks might have a return type of 'auto' explicitly specified.
    FunctionDecl /*P*/ FD = CurLambda.CallOperator;
    if (CurCap.ReturnType.isNull()) {
      CurCap.ReturnType.$assignMove(FD.getReturnType());
    }
    
    AutoType /*P*/ AT = CurCap.ReturnType.$arrow().getContainedAutoType();
    assert ((AT != null)) : "lost auto type from lambda return type";
    if ($this().DeduceFunctionTypeFromReturnExpr(FD, new SourceLocation(ReturnLoc), RetValExp.star$ref(), AT)) {
      FD.setInvalidDecl();
      return StmtError();
    }
    CurCap.ReturnType.$assign(FnRetType.$assignMove(FD.getReturnType()));
  } else if (CurCap.HasImplicitReturnType) {
    // For blocks/lambdas with implicit return types, we check each return
    // statement individually, and deduce the common return type when the block
    // or lambda is completed.
    // FIXME: Fold this into the 'auto' codepath above.
    if ((RetValExp.$star() != null) && !isa_InitListExpr(RetValExp)) {
      ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultFunctionArrayLvalueConversion(RetValExp.$star());
      if (Result.isInvalid()) {
        return StmtError();
      }
      RetValExp.$set(Result.get());
      
      // DR1048: even prior to C++14, we should use the 'auto' deduction rules
      // when deducing a return type for a lambda-expression (or by extension
      // for a block). These rules differ from the stated C++11 rules only in
      // that they remove top-level cv-qualifiers.
      if (!$this().CurContext.isDependentContext()) {
        FnRetType.$assignMove(RetValExp.$star().getType().getUnqualifiedType());
      } else {
        FnRetType.$assign(CurCap.ReturnType.$assignMove($this().Context.DependentTy.$QualType()));
      }
    } else {
      if ((RetValExp.$star() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++11 [expr.lambda.prim]p4 bans inferring the result from an
          // initializer list, because it is not an expression (even
          // though we represent it as one). We still deduce 'void'.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_lambda_return_init_list)), 
              RetValExp.$star().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      
      FnRetType.$assignMove($this().Context.VoidTy.$QualType());
    }
    
    // Although we'll properly infer the type of the block once it's completed,
    // make sure we provide a return type now for better error recovery.
    if (CurCap.ReturnType.isNull()) {
      CurCap.ReturnType.$assign(FnRetType);
    }
  }
  assert (!FnRetType.isNull());
  {
    
    BlockScopeInfo /*P*/ CurBlock = dyn_cast_BlockScopeInfo(CurCap);
    if ((CurBlock != null)) {
      if (CurBlock.FunctionType.$arrow().getAs(FunctionType.class).getNoReturnAttr()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_noreturn_block_has_return_expr)));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      CapturedRegionScopeInfo /*P*/ CurRegion = dyn_cast_CapturedRegionScopeInfo(CurCap);
      if ((CurRegion != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_return_in_captured_stmt)), CurRegion.getRegionName()));
          return StmtError();
        } finally {
          $c$.$destroy();
        }
      } else {
        assert ((CurLambda != null)) : "unknown kind of captured scope";
        if (CurLambda.CallOperator.getType().$arrow().getAs(FunctionType.class).
            getNoReturnAttr()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_noreturn_lambda_has_return_expr)));
            return StmtError();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  // Otherwise, verify that this result type matches the previous one.  We are
  // pickier with blocks than for normal functions because we don't have GCC
  // compatibility to worry about here.
  /*const*/ VarDecl /*P*/ NRVOCandidate = null;
  if (FnRetType.$arrow().isDependentType()) {
    // Delay processing for now.  TODO: there are lots of dependent
    // types we can conclusively prove aren't void.
  } else if (FnRetType.$arrow().isVoidType()) {
    if ((RetValExp.$star() != null) && !isa_InitListExpr(RetValExp)
       && !($this().getLangOpts().CPlusPlus
       && (RetValExp.$star().isTypeDependent()
       || RetValExp.$star().getType().$arrow().isVoidType()))) {
      if (!$this().getLangOpts().CPlusPlus
         && RetValExp.$star().getType().$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.ext_return_has_void_expr)), /*KEEP_STR*/"literal"), 2));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_return_block_has_expr)));
          RetValExp.$set(null);
        } finally {
          $c$.$destroy();
        }
      }
    }
  } else if (!(RetValExp.$star() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(StmtError($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_block_return_missing_expr))));
    } finally {
      $c$.$destroy();
    }
  } else if (!RetValExp.$star().isTypeDependent()) {
    // we have a non-void block with an expression, continue checking
    
    // C99 6.8.6.4p3(136): The return statement is not an assignment. The
    // overlap restriction of subclause 6.5.16.1 does not apply to the case of
    // function return.
    
    // In C++ the return statement is handled via a copy initialization.
    // the C version of which boils down to CheckSingleAssignmentConstraints.
    NRVOCandidate = $this().getCopyElisionCandidate(new QualType(FnRetType), RetValExp.$star(), false);
    InitializedEntity Entity = InitializedEntity.InitializeResult(new SourceLocation(ReturnLoc), 
        new QualType(FnRetType), 
        NRVOCandidate != (/*const*/ VarDecl /*P*/ )null);
    ActionResultTTrue<Expr /*P*/ > Res = $this().PerformMoveOrCopyInitialization(Entity, NRVOCandidate, 
        new QualType(FnRetType), RetValExp.$star());
    if (Res.isInvalid()) {
      // FIXME: Cleanup temporaries here, anyway?
      return StmtError();
    }
    RetValExp.$set(Res.get());
    $this().CheckReturnValExpr(RetValExp.$star(), new QualType(FnRetType), new SourceLocation(ReturnLoc));
  } else {
    NRVOCandidate = $this().getCopyElisionCandidate(new QualType(FnRetType), RetValExp.$star(), false);
  }
  if ((RetValExp.$star() != null)) {
    ActionResultTTrue<Expr /*P*/ > ER = $this().ActOnFinishFullExpr(RetValExp.$star(), new SourceLocation(ReturnLoc));
    if (ER.isInvalid()) {
      return StmtError();
    }
    RetValExp.$set(ER.get());
  }
  final VarDecl /*P*/ $NRVOCandidate = NRVOCandidate;
  ReturnStmt /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ReturnStmt(new SourceLocation(ReturnLoc), RetValExp.$star(), 
      $NRVOCandidate));
  
  // If we need to check for the named return value optimization,
  // or if we need to infer the return type,
  // save the return statement in our scope for later processing.
  if (CurCap.HasImplicitReturnType || (NRVOCandidate != null)) {
    $this().FunctionScopes.back().Returns.push_back(Result);
  }
  if ($this().FunctionScopes.back().FirstReturnLoc.isInvalid()) {
    $this().FunctionScopes.back().FirstReturnLoc.$assign(ReturnLoc);
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, Result);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAtCatchStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3405,
 FQN="clang::Sema::ActOnObjCAtCatchStmt", NM="_ZN5clang4Sema20ActOnObjCAtCatchStmtENS_14SourceLocationES1_PNS_4DeclEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20ActOnObjCAtCatchStmtENS_14SourceLocationES1_PNS_4DeclEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCAtCatchStmt(SourceLocation AtLoc, 
                    SourceLocation RParen, Decl /*P*/ Parm, 
                    Stmt /*P*/ Body) {
  VarDecl /*P*/ Var = cast_or_null_VarDecl(Parm);
  if ((Var != null) && Var.isInvalidDecl()) {
    return StmtError();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCAtCatchStmt(new SourceLocation(AtLoc), new SourceLocation(RParen), Var, Body)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAtFinallyStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3416,
 FQN="clang::Sema::ActOnObjCAtFinallyStmt", NM="_ZN5clang4Sema22ActOnObjCAtFinallyStmtENS_14SourceLocationEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema22ActOnObjCAtFinallyStmtENS_14SourceLocationEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCAtFinallyStmt(SourceLocation AtLoc, Stmt /*P*/ Body) {
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCAtFinallyStmt(new SourceLocation(AtLoc), Body)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAtTryStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3421,
 FQN="clang::Sema::ActOnObjCAtTryStmt", NM="_ZN5clang4Sema18ActOnObjCAtTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm15MutableArrayRefIS3_EES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema18ActOnObjCAtTryStmtENS_14SourceLocationEPNS_4StmtEN4llvm15MutableArrayRefIS3_EES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCAtTryStmt(SourceLocation AtLoc, Stmt /*P*/ Try, 
                  MutableArrayRef<Stmt /*P*/ > CatchStmts, Stmt /*P*/ Finally) {
  if (!$this().getLangOpts().ObjCExceptions) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_exceptions_disabled)), /*KEEP_STR*/"@try"));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().getCurFunction().setHasBranchProtectedScope();
  /*uint*/int NumCatchStmts = CatchStmts.size();
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, ObjCAtTryStmt.Create($this().Context, new SourceLocation(AtLoc), Try, CatchStmts.data(), 
          NumCatchStmts, Finally));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildObjCAtThrowStmt">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*$Throw*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3433,
 FQN="clang::Sema::BuildObjCAtThrowStmt", NM="_ZN5clang4Sema20BuildObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20BuildObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > BuildObjCAtThrowStmt(SourceLocation AtLoc, Expr /*P*/ Throw) {
  if ((Throw != null)) {
    ActionResultTTrue<Expr /*P*/ > Result = $this().DefaultLvalueConversion(Throw);
    if (Result.isInvalid()) {
      return StmtError();
    }
    
    Result.$assignMove($this().ActOnFinishFullExpr(Result.get()));
    if (Result.isInvalid()) {
      return StmtError();
    }
    Throw = Result.get();
    
    QualType ThrowType = Throw.getType();
    // Make sure the expression type is an ObjC pointer or "void *".
    if (!ThrowType.$arrow().isDependentType()
       && !ThrowType.$arrow().isObjCObjectPointerType()) {
      /*const*/ PointerType /*P*/ PT = ThrowType.$arrow().getAs(PointerType.class);
      if (!(PT != null) || !PT.getPointeeType().$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.error_objc_throw_expects_object)), 
                      Throw.getType()), Throw.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  final Expr /*P*/ $Throw = Throw;
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCAtThrowStmt(new SourceLocation(AtLoc), $Throw)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAtThrowStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3458,
 FQN="clang::Sema::ActOnObjCAtThrowStmt", NM="_ZN5clang4Sema20ActOnObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20ActOnObjCAtThrowStmtENS_14SourceLocationEPNS_4ExprEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCAtThrowStmt(SourceLocation AtLoc, Expr /*P*/ Throw, 
                    Scope /*P*/ CurScope) {
  if (!$this().getLangOpts().ObjCExceptions) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(AtLoc), diag.err_objc_exceptions_disabled)), /*KEEP_STR*/"@throw"));
    } finally {
      $c$.$destroy();
    }
  }
  if (!(Throw != null)) {
    // @throw without an expression designates a rethrow (which must occur
    // in the context of an @catch clause).
    Scope /*P*/ AtCatchParent = CurScope;
    while ((AtCatchParent != null) && !AtCatchParent.isAtCatchScope()) {
      AtCatchParent = AtCatchParent.getParent();
    }
    if (!(AtCatchParent != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(StmtError($c$.track($this().Diag(new SourceLocation(AtLoc), diag.error_rethrow_used_outside_catch))));
      } finally {
        $c$.$destroy();
      }
    }
  }
  return $this().BuildObjCAtThrowStmt(new SourceLocation(AtLoc), Throw);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAtSynchronizedOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3476,
 FQN="clang::Sema::ActOnObjCAtSynchronizedOperand", NM="_ZN5clang4Sema30ActOnObjCAtSynchronizedOperandENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema30ActOnObjCAtSynchronizedOperandENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnObjCAtSynchronizedOperand(SourceLocation atLoc, Expr /*P*/ operand) {
  ActionResultTTrue<Expr /*P*/ > result = $this().DefaultLvalueConversion(operand);
  if (result.isInvalid()) {
    return ExprError();
  }
  operand = result.get();
  
  // Make sure the expression type is an ObjC pointer or "void *".
  QualType type = operand.getType();
  if (!type.$arrow().isDependentType()
     && !type.$arrow().isObjCObjectPointerType()) {
    /*const*/ PointerType /*P*/ pointerType = type.$arrow().getAs(PointerType.class);
    if (!(pointerType != null) || !pointerType.getPointeeType().$arrow().isVoidType()) {
      if ($this().getLangOpts().CPlusPlus) {
        if ($this().RequireCompleteType(new SourceLocation(atLoc), new QualType(type), 
            diag.err_incomplete_receiver_type)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(atLoc), diag.error_objc_synchronized_expects_object)), 
                        type), operand.getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
        
        ActionResultTTrue<Expr /*P*/ > result$1 = $this().PerformContextuallyConvertToObjCPointer(operand);
        if (!result$1.isUsable()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(atLoc), diag.error_objc_synchronized_expects_object)), 
                        type), operand.getSourceRange())));
          } finally {
            $c$.$destroy();
          }
        }
        
        operand = result$1.get();
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(atLoc), diag.error_objc_synchronized_expects_object)), 
                      type), operand.getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // The operand to @synchronized is a full-expression.
  return $this().ActOnFinishFullExpr(operand);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAtSynchronizedStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3512,
 FQN="clang::Sema::ActOnObjCAtSynchronizedStmt", NM="_ZN5clang4Sema27ActOnObjCAtSynchronizedStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema27ActOnObjCAtSynchronizedStmtENS_14SourceLocationEPNS_4ExprEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCAtSynchronizedStmt(SourceLocation AtLoc, Expr /*P*/ SyncExpr, 
                           Stmt /*P*/ SyncBody) {
  // We can't jump into or indirect-jump out of a @synchronized block.
  $this().getCurFunction().setHasBranchProtectedScope();
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCAtSynchronizedStmt(new SourceLocation(AtLoc), SyncExpr, SyncBody)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnObjCAutoreleasePoolStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3530,
 FQN="clang::Sema::ActOnObjCAutoreleasePoolStmt", NM="_ZN5clang4Sema28ActOnObjCAutoreleasePoolStmtENS_14SourceLocationEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema28ActOnObjCAutoreleasePoolStmtENS_14SourceLocationEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnObjCAutoreleasePoolStmt(SourceLocation AtLoc, Stmt /*P*/ Body) {
  $this().getCurFunction().setHasBranchProtectedScope();
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ObjCAutoreleasePoolStmt(new SourceLocation(AtLoc), Body)));
}


/// ActOnCXXCatchBlock - Takes an exception declaration and a handler block
/// and creates a proper catch handler from them.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXCatchBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3522,
 FQN="clang::Sema::ActOnCXXCatchBlock", NM="_ZN5clang4Sema18ActOnCXXCatchBlockENS_14SourceLocationEPNS_4DeclEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema18ActOnCXXCatchBlockENS_14SourceLocationEPNS_4DeclEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCXXCatchBlock(SourceLocation CatchLoc, Decl /*P*/ ExDecl, 
                  Stmt /*P*/ HandlerBlock) {
  // There's nothing to test that ActOnExceptionDecl didn't already test.
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXCatchStmt(new SourceLocation(CatchLoc), cast_or_null_VarDecl(ExDecl), HandlerBlock)));
}


/// ActOnCXXTryBlock - Takes a try compound-statement and a number of
/// handlers and creates a try statement from them.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXTryBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3640,
 FQN="clang::Sema::ActOnCXXTryBlock", NM="_ZN5clang4Sema16ActOnCXXTryBlockENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS3_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema16ActOnCXXTryBlockENS_14SourceLocationEPNS_4StmtEN4llvm8ArrayRefIS3_EE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnCXXTryBlock(SourceLocation TryLoc, Stmt /*P*/ TryBlock, 
                ArrayRef<Stmt /*P*/ > Handlers) {
  // Don't report an error if 'try' is used in system headers.
  if (!$this().getLangOpts().CXXExceptions
     && !$this().getSourceManager().isInSystemHeader(/*NO_COPY*/TryLoc)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TryLoc), diag.err_exceptions_disabled)), /*KEEP_STR*/"try"));
    } finally {
      $c$.$destroy();
    }
  }
  if (($this().getCurScope() != null) && $this().getCurScope().isOpenMPSimdDirectiveScope()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TryLoc), diag.err_omp_simd_region_cannot_use_stmt)), /*KEEP_STR*/"try"));
    } finally {
      $c$.$destroy();
    }
  }
  
  FunctionScopeInfo /*P*/ FSI = $this().getCurFunction();
  
  // C++ try is incompatible with SEH __try.
  if (!$this().getLangOpts().Borland && FSI.FirstSEHTryLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(TryLoc), diag.err_mixing_cxx_try_seh_try)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FSI.FirstSEHTryLoc), diag.note_conflicting_try_here)), /*KEEP_STR*/"'__try'"));
    } finally {
      $c$.$destroy();
    }
  }
  
  /*const*//*uint*/int NumHandlers = Handlers.size();
  assert (!Handlers.empty()) : "The parser shouldn't call this if there are no handlers.";
  
  DenseMap<CatchHandlerType, CXXCatchStmt /*P*/ > HandledTypes/*J*/= new DenseMap<CatchHandlerType, CXXCatchStmt /*P*/ >(DenseMapInfoCatchHandlerType.Info(), (CXXCatchStmt /*P*/ )null);
  for (/*uint*/int i = 0; $less_uint(i, NumHandlers); ++i) {
    CXXCatchStmt /*P*/ H = cast_CXXCatchStmt(Handlers.$at(i));
    
    // Diagnose when the handler is a catch-all handler, but it isn't the last
    // handler for the try block. [except.handle]p5. Also, skip exception
    // declarations that are invalid, since we can't usefully report on them.
    if (!(H.getExceptionDecl() != null)) {
      if ($less_uint(i, NumHandlers - 1)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(StmtError($c$.track($this().Diag(H.getLocStart(), diag.err_early_catch_all))));
        } finally {
          $c$.$destroy();
        }
      }
      continue;
    } else if (H.getExceptionDecl().isInvalidDecl()) {
      continue;
    }
    
    // Walk the type hierarchy to diagnose when this type has already been
    // handled (duplication), or cannot be handled (derivation inversion). We
    // ignore top-level cv-qualifiers, per [except.handle]p3
    CatchHandlerType HandlerCHT = new CatchHandlerType((QualType)$this().Context.getCanonicalType(H.getCaughtType()).$QualType());
    
    // We can ignore whether the type is a reference or a pointer; we need the
    // underlying declaration type in order to get at the underlying record
    // decl, if there is one.
    QualType Underlying = HandlerCHT.underlying();
    {
      CXXRecordDecl /*P*/ RD = Underlying.$arrow().getAsCXXRecordDecl();
      if ((RD != null)) {
        CXXBasePaths Paths = null;
        try {
          if (!RD.hasDefinition()) {
            continue;
          }
          // Check that none of the public, unambiguous base classes are in the
          // map ([except.handle]p1). Give the base classes the same pointer
          // qualification as the original type we are basing off of. This allows
          // comparison against the handler type using the same top-level pointer
          // as the original type.
          Paths/*J*/= new CXXBasePaths();
          Paths.setOrigin(RD);
          CatchTypePublicBases CTPB/*J*/= new CatchTypePublicBases($this().Context, HandledTypes, HandlerCHT.isPointer());
          if (RD.lookupInBases(/*FuncArg*/CTPB, Paths)) {
            /*const*/ CXXCatchStmt /*P*/ Problem = CTPB.getFoundHandler();
            if (!Paths.isAmbiguous(CTPB.getFoundHandlerType())) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(H.getExceptionDecl().getTypeSpecStartLoc(), 
                        diag.warn_exception_caught_by_earlier_handler)), 
                    H.getCaughtType()));
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Problem.getExceptionDecl().getTypeSpecStartLoc(), 
                        diag.note_previous_exception_handler)), 
                    Problem.getCaughtType()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        } finally {
          if (Paths != null) { Paths.$destroy(); }
        }
      }
    }
    
    // Add the type the list of ones we have handled; diagnose if we've already
    // handled it.
    std.pairTypeBool<DenseMapIterator<CatchHandlerType, CXXCatchStmt /*P*/ >> R = HandledTypes.insert_pair$KeyT$ValueT(std.make_pair_T_Ptr(/*JCONV*/new CatchHandlerType(H.getCaughtType()), H));
    if (!R.second) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*const*/ CXXCatchStmt /*P*/ Problem = R.first.$arrow().second;
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(H.getExceptionDecl().getTypeSpecStartLoc(), 
                diag.warn_exception_caught_by_earlier_handler)), 
            H.getCaughtType()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Problem.getExceptionDecl().getTypeSpecStartLoc(), 
                diag.note_previous_exception_handler)), 
            Problem.getCaughtType()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  FSI.setHasCXXTry(new SourceLocation(TryLoc));
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, CXXTryStmt.Create($this().Context, new SourceLocation(TryLoc), TryBlock, new ArrayRef<Stmt /*P*/ >(Handlers)));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSEHTryBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3729,
 FQN="clang::Sema::ActOnSEHTryBlock", NM="_ZN5clang4Sema16ActOnSEHTryBlockEbNS_14SourceLocationEPNS_4StmtES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema16ActOnSEHTryBlockEbNS_14SourceLocationEPNS_4StmtES3_")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnSEHTryBlock(boolean IsCXXTry, SourceLocation TryLoc, 
                Stmt /*P*/ TryBlock, Stmt /*P*/ Handler) {
  assert ((TryBlock != null) && (Handler != null));
  
  FunctionScopeInfo /*P*/ FSI = $this().getCurFunction();
  
  // SEH __try is incompatible with C++ try. Borland appears to support this,
  // however.
  if (!$this().getLangOpts().Borland) {
    if (FSI.FirstCXXTryLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(TryLoc), diag.err_mixing_cxx_try_seh_try)));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(FSI.FirstCXXTryLoc), diag.note_conflicting_try_here)), /*KEEP_STR*/"'try'"));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  FSI.setHasSEHTry(new SourceLocation(TryLoc));
  
  // Reject __try in Obj-C methods, blocks, and captured decls, since we don't
  // track if they use SEH.
  DeclContext /*P*/ DC = $this().CurContext;
  while ((DC != null) && !DC.isFunctionOrMethod()) {
    DC = DC.getParent();
  }
  FunctionDecl /*P*/ FD = dyn_cast_or_null_FunctionDecl(DC);
  if ((FD != null)) {
    FD.setUsesSEHTry(true);
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(TryLoc), diag.err_seh_try_outside_functions)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Reject __try on unsupported targets.
  if (!$this().Context.getTargetInfo().isSEHTrySupported()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(TryLoc), diag.err_seh_try_unsupported)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SEHTryStmt.Create($this().Context, IsCXXTry, new SourceLocation(TryLoc), TryBlock, Handler));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSEHExceptBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3764,
 FQN="clang::Sema::ActOnSEHExceptBlock", NM="_ZN5clang4Sema19ActOnSEHExceptBlockENS_14SourceLocationEPNS_4ExprEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema19ActOnSEHExceptBlockENS_14SourceLocationEPNS_4ExprEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnSEHExceptBlock(SourceLocation Loc, 
                   Expr /*P*/ FilterExpr, 
                   Stmt /*P*/ Block) {
  assert ((FilterExpr != null) && (Block != null));
  if (!FilterExpr.getType().$arrow().isIntegerType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(StmtError($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FilterExpr.getExprLoc(), 
                  diag.err_filter_expression_integral)), 
              FilterExpr.getType())));
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SEHExceptStmt.Create($this().Context, new SourceLocation(Loc), FilterExpr, Block));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartSEHFinallyBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3779,
 FQN="clang::Sema::ActOnStartSEHFinallyBlock", NM="_ZN5clang4Sema25ActOnStartSEHFinallyBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema25ActOnStartSEHFinallyBlockEv")
//</editor-fold>
public final void ActOnStartSEHFinallyBlock() {
  $this().CurrentSEHFinally.push_back($this().CurScope);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnAbortSEHFinallyBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3783,
 FQN="clang::Sema::ActOnAbortSEHFinallyBlock", NM="_ZN5clang4Sema25ActOnAbortSEHFinallyBlockEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema25ActOnAbortSEHFinallyBlockEv")
//</editor-fold>
public final void ActOnAbortSEHFinallyBlock() {
  $this().CurrentSEHFinally.pop_back();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishSEHFinallyBlock">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3787,
 FQN="clang::Sema::ActOnFinishSEHFinallyBlock", NM="_ZN5clang4Sema26ActOnFinishSEHFinallyBlockENS_14SourceLocationEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema26ActOnFinishSEHFinallyBlockENS_14SourceLocationEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnFinishSEHFinallyBlock(SourceLocation Loc, Stmt /*P*/ Block) {
  assert Native.$bool(Block);
  $this().CurrentSEHFinally.pop_back();
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, SEHFinallyStmt.Create($this().Context, new SourceLocation(Loc), Block));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnSEHLeaveStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3793,
 FQN="clang::Sema::ActOnSEHLeaveStmt", NM="_ZN5clang4Sema17ActOnSEHLeaveStmtENS_14SourceLocationEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema17ActOnSEHLeaveStmtENS_14SourceLocationEPNS_5ScopeE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnSEHLeaveStmt(SourceLocation Loc, Scope /*P*/ CurScope) {
  Scope /*P*/ SEHTryParent = CurScope;
  while ((SEHTryParent != null) && !SEHTryParent.isSEHTryScope()) {
    SEHTryParent = SEHTryParent.getParent();
  }
  if (!(SEHTryParent != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(StmtError($c$.track($this().Diag(new SourceLocation(Loc), diag.err_ms___leave_not_in___try))));
    } finally {
      $c$.$destroy();
    }
  }
  CheckJumpOutOfSEHFinally(/*Deref*/$this(), new SourceLocation(Loc), $Deref(SEHTryParent));
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new SEHLeaveStmt(new SourceLocation(Loc))));
}


/// DiagnoseUnusedExprResult - If the statement passed in is an expression
/// whose result is unused, warn.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnusedExprResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 186,
 FQN="clang::Sema::DiagnoseUnusedExprResult", NM="_ZN5clang4Sema24DiagnoseUnusedExprResultEPKNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema24DiagnoseUnusedExprResultEPKNS_4StmtE")
//</editor-fold>
public final void DiagnoseUnusedExprResult(/*const*/ Stmt /*P*/ S) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    {
      /*const*/ LabelStmt /*P*/ Label = dyn_cast_or_null_LabelStmt(S);
      if ((Label != null)) {
        $this().DiagnoseUnusedExprResult(Label.getSubStmt$Const());
        /*JAVA:return*/return;
      }
    }
    
    /*const*/ Expr /*P*/ E = dyn_cast_or_null_Expr(S);
    if (!(E != null)) {
      return;
    }
    
    // If we are in an unevaluated expression context, then there can be no unused
    // results because the results aren't expected to be used in the first place.
    if ($this().isUnevaluatedContext()) {
      return;
    }
    
    SourceLocation ExprLoc = E.IgnoreParenImpCasts$Const().getExprLoc();
    // In most cases, we don't want to warn if the expression is written in a
    // macro body, or if the macro comes from a system header. If the offending
    // expression is a call to a function with the warn_unused_result attribute,
    // we warn no matter the location. Because of the order in which the various
    // checks need to happen, we factor out the macro-related test here.
    boolean ShouldSuppress = $this().SourceMgr.isMacroBodyExpansion(/*NO_COPY*/ExprLoc)
       || $this().SourceMgr.isInSystemMacro(/*NO_COPY*/ExprLoc);
    
    type$ptr</*const*/ Expr /*P*/ > WarnExpr = create_type$null$ptr();
    SourceLocation Loc/*J*/= new SourceLocation();
    SourceRange R1/*J*/= new SourceRange();
    SourceRange R2/*J*/= new SourceRange();
    if (!E.isUnusedResultAWarning(WarnExpr, Loc, R1, R2, $this().Context)) {
      return;
    }
    
    // If this is a GNU statement expression expanded from a macro, it is probably
    // unused because it is a function-like macro that can be used as either an
    // expression or statement.  Don't warn, because it is almost certainly a
    // false positive.
    if (isa_StmtExpr(E) && Loc.isMacroID()) {
      return;
    }
    
    // Check if this is the UNREFERENCED_PARAMETER from the Microsoft headers.
    // That macro is frequently used to suppress "unused parameter" warnings,
    // but its implementation makes clang's -Wunused-value fire.  Prevent this.
    if (isa_ParenExpr(E.IgnoreImpCasts$Const()) && Loc.isMacroID()) {
      SourceLocation SpellLoc = new SourceLocation(Loc);
      if ($this().findMacroSpelling(SpellLoc, new StringRef(/*KEEP_STR*/"UNREFERENCED_PARAMETER"))) {
        return;
      }
    }
    
    // Okay, we have an unused result.  Depending on what the base expression is,
    // we might want to make a more specific diagnostic.  Check for one of these
    // cases now.
    /*uint*/int DiagID = diag.warn_unused_expr;
    {
      /*const*/ ExprWithCleanups /*P*/ Temps = dyn_cast_ExprWithCleanups(E);
      if ((Temps != null)) {
        E = Temps.getSubExpr$Const();
      }
    }
    {
      /*const*/ CXXBindTemporaryExpr /*P*/ TempExpr = dyn_cast_CXXBindTemporaryExpr(E);
      if ((TempExpr != null)) {
        E = TempExpr.getSubExpr$Const();
      }
    }
    if (DiagnoseUnusedComparison(/*Deref*/$this(), E)) {
      return;
    }
    
    E = WarnExpr.$star();
    {
      /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(E);
      if ((CE != null)) {
        if (E.getType().$arrow().isVoidType()) {
          return;
        }
        {
          
          // If the callee has attribute pure, const, or warn_unused_result, warn with
          // a more specific message to make it clear what is happening. If the call
          // is written in a macro body, only warn if it has the warn_unused_result
          // attribute.
          /*const*/ Decl /*P*/ FD = CE.getCalleeDecl$Const();
          if ((FD != null)) {
            {
              /*const*/ Attr /*P*/ A = isa_FunctionDecl(FD) ? cast_FunctionDecl(FD).getUnusedResultAttr() : FD.getAttr(WarnUnusedResultAttr.class);
              if ((A != null)) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unused_result)), A), R1), R2));
                return;
              }
            }
            if (ShouldSuppress) {
              return;
            }
            if (FD.hasAttr(PureAttr.class)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unused_call)), R1), R2), /*KEEP_STR*/"pure"));
              return;
            }
            if (FD.hasAttr(ConstAttr.class)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unused_call)), R1), R2), /*KEEP_STR*/"const"));
              return;
            }
          }
        }
      } else if (ShouldSuppress) {
        return;
      }
    }
    {
      
      /*const*/ ObjCMessageExpr /*P*/ ME = dyn_cast_ObjCMessageExpr(E);
      if ((ME != null)) {
        if ($this().getLangOpts().ObjCAutoRefCount && ME.isDelegateInitCall()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_arc_unused_init_message)), R1));
          return;
        }
        /*const*/ ObjCMethodDecl /*P*/ MD = ME.getMethodDecl$Const();
        if ((MD != null)) {
          {
            /*const*/ WarnUnusedResultAttr /*P*/ A = MD.getAttr(WarnUnusedResultAttr.class);
            if ((A != null)) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unused_result)), A), R1), R2));
              return;
            }
          }
        }
      } else {
        /*const*/ PseudoObjectExpr /*P*/ POE = dyn_cast_PseudoObjectExpr(E);
        if ((POE != null)) {
          /*const*/ Expr /*P*/ Source = POE.getSyntacticForm$Const();
          if (isa_ObjCSubscriptRefExpr(Source)) {
            DiagID = diag.warn_unused_container_subscript_expr;
          } else {
            DiagID = diag.warn_unused_property_expr;
          }
        } else {
          /*const*/ CXXFunctionalCastExpr /*P*/ FC = dyn_cast_CXXFunctionalCastExpr(E);
          if ((FC != null)) {
            if (isa_CXXConstructExpr(FC.getSubExpr$Const())
               || isa_CXXTemporaryObjectExpr(FC.getSubExpr$Const())) {
              return;
            }
          } else {
            // Diagnose "(void*) blah" as a typo for "(void) blah".
            /*const*/ CStyleCastExpr /*P*/ CE = dyn_cast_CStyleCastExpr(E);
            if ((CE != null)) {
              TypeSourceInfo /*P*/ TI = CE.getTypeInfoAsWritten();
              QualType T = TI.getType();
              
              // We really do want to use the non-canonical type here.
              if ($eq_QualType$C(T, $this().Context.VoidPtrTy.$QualType())) {
                PointerTypeLoc TL = TI.getTypeLoc().castAs(PointerTypeLoc.class);
                
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unused_voidptr)), 
                    FixItHint.CreateRemoval(new SourceRange(TL.getStarLoc()))));
                return;
              }
            }
          }
        }
      }
    }
    if (E.isGLValue() && E.getType().isVolatileQualified()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_unused_volatile)), R1), R2));
      return;
    }
    
    $c$.clean($this().DiagRuntimeBehavior(new SourceLocation(Loc), (/*const*/ Stmt /*P*/ )null, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_SourceRange($c$.track($this().PDiag(DiagID)), /*NO_COPY*/R1), /*NO_COPY*/R2)));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildMSDependentExistsStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3805,
 FQN="clang::Sema::BuildMSDependentExistsStmt", NM="_ZN5clang4Sema26BuildMSDependentExistsStmtENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema26BuildMSDependentExistsStmtENS_14SourceLocationEbNS_22NestedNameSpecifierLocENS_19DeclarationNameInfoEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > BuildMSDependentExistsStmt(SourceLocation KeywordLoc, 
                          boolean IsIfExists, 
                          NestedNameSpecifierLoc QualifierLoc, 
                          DeclarationNameInfo NameInfo, 
                          Stmt /*P*/ Nested) {
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new MSDependentExistsStmt(new SourceLocation(KeywordLoc), IsIfExists, 
          new NestedNameSpecifierLoc(QualifierLoc), new DeclarationNameInfo(NameInfo), 
          cast_CompoundStmt(Nested))));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnMSDependentExistsStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3817,
 FQN="clang::Sema::ActOnMSDependentExistsStmt", NM="_ZN5clang4Sema26ActOnMSDependentExistsStmtENS_14SourceLocationEbRNS_12CXXScopeSpecERNS_13UnqualifiedIdEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema26ActOnMSDependentExistsStmtENS_14SourceLocationEbRNS_12CXXScopeSpecERNS_13UnqualifiedIdEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnMSDependentExistsStmt(SourceLocation KeywordLoc, 
                          boolean IsIfExists, 
                          final CXXScopeSpec /*&*/ SS, 
                          final UnqualifiedId /*&*/ Name, 
                          Stmt /*P*/ Nested) {
  return $this().BuildMSDependentExistsStmt(new SourceLocation(KeywordLoc), IsIfExists, 
      SS.getWithLocInContext($this().Context), 
      $this().GetNameFromUnqualifiedId(Name), 
      Nested);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getReturnTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3052,
 FQN="clang::Sema::getReturnTypeLoc", NM="_ZNK5clang4Sema16getReturnTypeLocEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZNK5clang4Sema16getReturnTypeLocEPNS_12FunctionDeclE")
//</editor-fold>
public final TypeLoc getReturnTypeLoc(FunctionDecl /*P*/ FD) /*const*/ {
  TypeLoc TL = FD.getTypeSourceInfo().getTypeLoc().IgnoreParens();
  {
    AttributedTypeLoc ATL;
    while ((ATL = TL.getAs(AttributedTypeLoc.class)).$bool()) {
      TL.$assignMove(ATL.getModifiedLoc().IgnoreParens());
    }
  }
  return TL.castAs(FunctionProtoTypeLoc.class).getReturnLoc();
}


/// Deduce the return type for a function from a returned expression, per
/// C++1y [dcl.spec.auto]p6.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeduceFunctionTypeFromReturnExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 3061,
 FQN="clang::Sema::DeduceFunctionTypeFromReturnExpr", NM="_ZN5clang4Sema32DeduceFunctionTypeFromReturnExprEPNS_12FunctionDeclENS_14SourceLocationERPNS_4ExprEPNS_8AutoTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema32DeduceFunctionTypeFromReturnExprEPNS_12FunctionDeclENS_14SourceLocationERPNS_4ExprEPNS_8AutoTypeE")
//</editor-fold>
public final boolean DeduceFunctionTypeFromReturnExpr(FunctionDecl /*P*/ FD, 
                                SourceLocation ReturnLoc, 
                                final type$ref<Expr /*P*/ /*&*/> RetExpr, 
                                AutoType /*P*/ AT) {
  TypeLoc OrigResultType = $this().getReturnTypeLoc(FD);
  QualType Deduced/*J*/= new QualType();
  if ((RetExpr.$deref() != null) && isa_InitListExpr(RetExpr)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      //  If the deduction is for a return statement and the initializer is
      //  a braced-init-list, the program is ill-formed.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RetExpr.$deref().getExprLoc(), 
              ($this().getCurLambda() != null) ? diag.err_lambda_return_init_list : diag.err_auto_fn_return_init_list)), 
          RetExpr.$deref().getSourceRange()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  if (FD.isDependentContext()) {
    // C++1y [dcl.spec.auto]p12:
    //   Return type deduction [...] occurs when the definition is
    //   instantiated even if the function body contains a return
    //   statement with a non-type-dependent operand.
    assert (AT.isDeduced()) : "should have deduced to dependent type";
    return false;
  }
  if ((RetExpr.$deref() != null)) {
    //  Otherwise, [...] deduce a value for U using the rules of template
    //  argument deduction.
    DeduceAutoResult DAR = $this().DeduceAutoType(new TypeLoc(OrigResultType), RetExpr, Deduced);
    if (DAR == DeduceAutoResult.DAR_Failed && !FD.isInvalidDecl()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(RetExpr.$deref().getExprLoc(), diag.err_auto_fn_deduction_failure)), 
                OrigResultType.getType()), RetExpr.$deref().getType()));
      } finally {
        $c$.$destroy();
      }
    }
    if (DAR != DeduceAutoResult.DAR_Succeeded) {
      return true;
    }
    
    // If a local type is part of the returned type, mark its fields as
    // referenced.
    LocalTypedefNameReferencer Referencer/*J*/= new LocalTypedefNameReferencer(/*Deref*/$this());
    Referencer.TraverseType(RetExpr.$deref().getType());
  } else {
    //  In the case of a return with no operand, the initializer is considered
    //  to be void().
    //
    // Deduction here can only succeed if the return type is exactly 'cv auto'
    // or 'decltype(auto)', so just check for that case directly.
    if (!(OrigResultType.getType().$arrow().getAs(AutoType.class) != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_auto_fn_return_void_but_not_auto)), 
            OrigResultType.getType()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    // We always deduce U = void in this case.
    Deduced.$assignMove($this().SubstAutoType(OrigResultType.getType(), $this().Context.VoidTy.$QualType()));
    if (Deduced.isNull()) {
      return true;
    }
  }
  
  //  If a function with a declared return type that contains a placeholder type
  //  has multiple return statements, the return type is deduced for each return
  //  statement. [...] if the type deduced is not the same in each deduction,
  //  the program is ill-formed.
  QualType DeducedT = AT.getDeducedType();
  if (!DeducedT.isNull() && !FD.isInvalidDecl()) {
    AutoType /*P*/ NewAT = Deduced.$arrow().getContainedAutoType();
    // It is possible that NewAT->getDeducedType() is null. When that happens,
    // we should not crash, instead we ignore this deduction.
    if (NewAT.getDeducedType().isNull()) {
      return false;
    }
    
    CanQual<Type> OldDeducedType = $this().Context.getCanonicalFunctionResultType(new QualType(DeducedT));
    CanQual<Type> NewDeducedType = $this().Context.getCanonicalFunctionResultType(NewAT.getDeducedType());
    if (!FD.isDependentContext() && $noteq_CanQual$T_CanQual$U(/*NO_COPY*/OldDeducedType, /*NO_COPY*/NewDeducedType)) {
      /*const*/ LambdaScopeInfo /*P*/ LambdaSI = $this().getCurLambda();
      if ((LambdaSI != null) && LambdaSI.HasImplicitReturnType) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_typecheck_missing_return_type_incompatible)), 
                      NewAT.getDeducedType()), DeducedT), 
              true/*IsLambda*/));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ReturnLoc), diag.err_auto_fn_different_deductions)), 
                      (AT.isDecltypeAuto() ? 1 : 0)), 
                  NewAT.getDeducedType()), DeducedT));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
  } else if (!FD.isInvalidDecl()) {
    // Update all declarations of the function to have the deduced return type.
    $this().Context.adjustDeducedFunctionResultType(FD, new QualType(Deduced));
  }
  
  return false;
}


/// DiagnoseAssignmentEnum - Warn if assignment to enum is a constant
/// integer not in the range of enum values.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseAssignmentEnum">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1181,
 FQN="clang::Sema::DiagnoseAssignmentEnum", NM="_ZN5clang4Sema22DiagnoseAssignmentEnumENS_8QualTypeES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema22DiagnoseAssignmentEnumENS_8QualTypeES1_PNS_4ExprE")
//</editor-fold>
public final void DiagnoseAssignmentEnum(QualType DstType, QualType SrcType, 
                      Expr /*P*/ SrcExpr) {
  if ($this().Diags.isIgnored(diag.warn_not_in_enum_assignment, SrcExpr.getExprLoc())) {
    return;
  }
  {
    
    /*const*/ EnumType /*P*/ ET = DstType.$arrow().getAs$EnumType();
    if ((ET != null)) {
      if (!$this().Context.hasSameUnqualifiedType(new QualType(SrcType), new QualType(DstType))
         && SrcType.$arrow().isIntegerType()) {
        if (!SrcExpr.isTypeDependent() && !SrcExpr.isValueDependent()
           && SrcExpr.isIntegerConstantExpr($this().Context)) {
          // Get the bitwidth of the enum value before promotions.
          /*uint*/int DstWidth = $this().Context.getIntWidth(new QualType(DstType));
          boolean DstIsSigned = DstType.$arrow().isSignedIntegerOrEnumerationType();
          
          APSInt RhsVal = SrcExpr.EvaluateKnownConstInt($this().Context);
          AdjustAPSInt(RhsVal, DstWidth, DstIsSigned);
          /*const*/ EnumDecl /*P*/ ED = ET.getDecl();
          if (ED.hasAttr(FlagEnumAttr.class)) {
            if (!$this().IsValueInFlagEnum(ED, RhsVal, true)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SrcExpr.getExprLoc(), diag.warn_not_in_enum_assignment)), 
                    DstType.getUnqualifiedType()));
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            /*typedef SmallVector<std::pair<llvm::APSInt, EnumConstantDecl *>, 64> EnumValsTy*/
//            final class EnumValsTy extends SmallVector<std.pair<APSInt, EnumConstantDecl /*P*/ >>{ };
            SmallVector<std.pair<APSInt, EnumConstantDecl /*P*/ >> EnumVals/*J*/= new SmallVector<std.pair<APSInt, EnumConstantDecl /*P*/ >>(64, new std.pairTypePtr<APSInt, EnumConstantDecl /*P*/ >(new APSInt(), null));
            
            // Gather all enum values, set their type and sort them,
            // allowing easier comparison with rhs constant.
            for (EnumConstantDecl /*P*/ EDI : ED.enumerators()) {
              APSInt Val = new APSInt(EDI.getInitVal());
              AdjustAPSInt(Val, DstWidth, DstIsSigned);
              EnumVals.push_back_T$RR(std.make_pair_T_Ptr(Val, EDI));
            }
            if (EnumVals.empty()) {
              return;
            }
            std.stable_sort(EnumVals.begin(), EnumVals.end(), SemaStmtStatics::/*FuncRef*/CmpEnumVals);
            type$ptr<pair<APSInt, EnumConstantDecl /*P*/ > /*P*/ > EIend = std.unique(EnumVals.begin(), EnumVals.end(),
                    (TypeType2Bool<pair<APSInt, EnumConstantDecl /*P*/ > /*P*/ >) (pair<APSInt, EnumConstantDecl> a, pair<APSInt, EnumConstantDecl> b) ->
                            SemaStmtStatics.EqEnumVals(a,b), false);
            // See which values aren't in the enum.
            type$ptr</*const*/ pair<APSInt, EnumConstantDecl /*P*/ > /*P*/ > EI = $tryClone(EnumVals.begin());
            while (EI.$noteq(EIend) && EI./*->*/$star().first.$less(RhsVal)) {
              EI.$postInc();
            }
            if (EI.$eq(EIend) || EI./*->*/$star().first.$noteq(RhsVal)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SrcExpr.getExprLoc(), diag.warn_not_in_enum_assignment)), 
                    DstType.getUnqualifiedType()));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 609,
 FQN="clang::Sema::CheckSwitchCondition", NM="_ZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckSwitchCondition(SourceLocation SwitchLoc, Expr /*P*/ Cond) {
  //<editor-fold defaultstate="collapsed" desc="SwitchConvertDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 610,
   FQN="SwitchConvertDiagnoser", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEE22SwitchConvertDiagnoser",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEE22SwitchConvertDiagnoser")
  //</editor-fold>
   class SwitchConvertDiagnoser extends /*public*/ ICEConvertDiagnoser implements Destructors.ClassWithDestructor {
    protected/*private*/ Expr /*P*/ Cond;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::SwitchConvertDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 614,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::SwitchConvertDiagnoser", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoserC1ES3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoserC1ES3_")
    //</editor-fold>
    public SwitchConvertDiagnoser(Expr /*P*/ Cond) {
      // : ICEConvertDiagnoser(/*AllowScopedEnumerations*/ true, false, true), Cond(Cond) 
      //START JInit
      super(true, false, true);
      this.Cond = Cond;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseNotInt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 618,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseNotInt", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser14diagnoseNotIntERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser14diagnoseNotIntERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseNotInt(final Sema /*&*/ S, SourceLocation Loc, 
                  QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_typecheck_statement_requires_integer)), T)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseIncomplete">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 623,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseIncomplete", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser18diagnoseIncompleteERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser18diagnoseIncompleteERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseIncomplete(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_switch_incomplete_class_type)), 
                    T), Cond.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 629,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseExplicitConv", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser20diagnoseExplicitConvERS0_S1_NS_8QualTypeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser20diagnoseExplicitConvERS0_S1_NS_8QualTypeES6_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseExplicitConv(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_switch_explicit_conversion)), T), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::noteExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 634,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::noteExplicitConv", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteExplicitConv(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Conv.getLocation(), diag.note_switch_conversion)), 
                    ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 640,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseAmbiguous", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser17diagnoseAmbiguousERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser17diagnoseAmbiguousERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseAmbiguous(final Sema /*&*/ S, SourceLocation Loc, 
                     QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_switch_multiple_conversions)), T)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::noteAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 645,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::noteAmbiguous", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteAmbiguous(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Conv.getLocation(), diag.note_switch_conversion)), 
                    ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseConversion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 651,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::diagnoseConversion", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser18diagnoseConversionERS0_S1_NS_8QualTypeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoser18diagnoseConversionERS0_S1_NS_8QualTypeES6_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseConversion(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* override*/ {
      throw new llvm_unreachable("conversion functions are permitted");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::~SwitchConvertDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 610,
     FQN="clang::Sema::CheckSwitchCondition(SourceLocation, Expr * )::SwitchConvertDiagnoser::~SwitchConvertDiagnoser", NM="_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoserD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZZN5clang4Sema20CheckSwitchConditionENS_14SourceLocationEPNS_4ExprEEN22SwitchConvertDiagnoserD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    @Override public String toString() {
      return "" + "Cond=" + Cond // NOI18N
                + super.toString(); // NOI18N
    }
  }
  SwitchConvertDiagnoser SwitchDiagnoser = null;
  try {
    SwitchDiagnoser/*J*/= new  SwitchConvertDiagnoser(Cond);
    
    ActionResultTTrue<Expr /*P*/ > CondResult = $this().PerformContextualImplicitConversion(new SourceLocation(SwitchLoc), Cond, SwitchDiagnoser);
    if (CondResult.isInvalid()) {
      return ExprError();
    }
    
    // C99 6.8.4.2p5 - Integer promotions are performed on the controlling expr.
    return $this().UsualUnaryConversions(CondResult.get());
  } finally {
    if (SwitchDiagnoser != null) { SwitchDiagnoser.$destroy(); }
  }
}


/// \brief Check if the given expression contains 'break' or 'continue'
/// statement that produces control flow different from GCC.
// end namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckBreakContinueBinding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp", line = 1609,
 FQN="clang::Sema::CheckBreakContinueBinding", NM="_ZN5clang4Sema25CheckBreakContinueBindingEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaStmt.cpp -nm=_ZN5clang4Sema25CheckBreakContinueBindingEPNS_4ExprE")
//</editor-fold>
protected/*private*/ final void CheckBreakContinueBinding(Expr /*P*/ E) {
  if (!(E != null) || $this().getLangOpts().CPlusPlus) {
    return;
  }
  BreakContinueFinder BCFinder/*J*/= new BreakContinueFinder(/*Deref*/$this(), E);
  Scope /*P*/ BreakParent = $this().CurScope.getBreakParent();
  if (BCFinder.BreakFound() && (BreakParent != null)) {
    if (((BreakParent.getFlags() & Scope.ScopeFlags.SwitchScope) != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(BCFinder.GetBreakLoc(), diag.warn_break_binds_to_switch)));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BCFinder.GetBreakLoc(), diag.warn_loop_ctrl_binds_to_inner)), 
            /*KEEP_STR*/"break"));
      } finally {
        $c$.$destroy();
      }
    }
  } else if (BCFinder.ContinueFound() && ($this().CurScope.getContinueParent() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(BCFinder.GetContinueLoc(), diag.warn_loop_ctrl_binds_to_inner)), 
          /*KEEP_STR*/"continue"));
    } finally {
      $c$.$destroy();
    }
  }
}

} // END OF class Sema_SemaStmt
