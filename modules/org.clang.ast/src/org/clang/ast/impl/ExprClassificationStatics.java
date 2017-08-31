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

import org.clank.support.*;
import org.llvm.support.*;
import org.clang.basic.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.QualType.*;


//<editor-fold defaultstate="collapsed" desc="static type ExprClassificationStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL12ClassifyDeclRN5clang10ASTContextEPKNS_4DeclE;_ZL12IsModifiableRN5clang10ASTContextEPKNS_4ExprENS2_14Classification5KindsERNS_14SourceLocationE;_ZL15ClassifyUnnamedRN5clang10ASTContextENS_8QualTypeE;_ZL16ClassifyBinaryOpRN5clang10ASTContextEPKNS_14BinaryOperatorE;_ZL16ClassifyInternalRN5clang10ASTContextEPKNS_4ExprE;_ZL17ClassifyTemporaryN5clang8QualTypeE;_ZL18ClassifyMemberExprRN5clang10ASTContextEPKNS_10MemberExprE;_ZL19ClassifyConditionalRN5clang10ASTContextEPKNS_4ExprES4_;_ZL21ClassifyExprValueKindRKN5clang11LangOptionsEPKNS_4ExprENS_13ExprValueKindE; -static-type=ExprClassificationStatics -package=org.clang.ast.impl")
//</editor-fold>
public final class ExprClassificationStatics {

//<editor-fold defaultstate="collapsed" desc="ClassifyInternal">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 102,
 FQN="ClassifyInternal", NM="_ZL16ClassifyInternalRN5clang10ASTContextEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL16ClassifyInternalRN5clang10ASTContextEPKNS_4ExprE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyInternal(final ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ E) {
  // This function takes the first stab at classifying expressions.
  final /*const*/ LangOptions /*&*/ Lang = Ctx.getLangOpts();
  switch (E.getStmtClass()) {
   case NoStmtClass:
   case GCCAsmStmtClass:
   case MSAsmStmtClass:
   case AttributedStmtClass:
   case BreakStmtClass:
   case CXXCatchStmtClass:
   case CXXForRangeStmtClass:
   case CXXTryStmtClass:
   case CapturedStmtClass:
   case CompoundStmtClass:
   case ContinueStmtClass:
   case CoreturnStmtClass:
   case CoroutineBodyStmtClass:
   case DeclStmtClass:
   case DoStmtClass:
   case ForStmtClass:
   case GotoStmtClass:
   case IfStmtClass:
   case IndirectGotoStmtClass:
   case LabelStmtClass:
   case MSDependentExistsStmtClass:
   case NullStmtClass:
   case OMPAtomicDirectiveClass:
   case OMPBarrierDirectiveClass:
   case OMPCancelDirectiveClass:
   case OMPCancellationPointDirectiveClass:
   case OMPCriticalDirectiveClass:
   case OMPFlushDirectiveClass:
   case OMPDistributeDirectiveClass:
   case OMPDistributeParallelForDirectiveClass:
   case OMPDistributeParallelForSimdDirectiveClass:
   case OMPDistributeSimdDirectiveClass:
   case OMPForDirectiveClass:
   case OMPForSimdDirectiveClass:
   case OMPParallelForDirectiveClass:
   case OMPParallelForSimdDirectiveClass:
   case OMPSimdDirectiveClass:
   case OMPTargetParallelForSimdDirectiveClass:
   case OMPTaskLoopDirectiveClass:
   case OMPTaskLoopSimdDirectiveClass:
   case OMPMasterDirectiveClass:
   case OMPOrderedDirectiveClass:
   case OMPParallelDirectiveClass:
   case OMPParallelSectionsDirectiveClass:
   case OMPSectionDirectiveClass:
   case OMPSectionsDirectiveClass:
   case OMPSingleDirectiveClass:
   case OMPTargetDataDirectiveClass:
   case OMPTargetDirectiveClass:
   case OMPTargetEnterDataDirectiveClass:
   case OMPTargetExitDataDirectiveClass:
   case OMPTargetParallelDirectiveClass:
   case OMPTargetParallelForDirectiveClass:
   case OMPTargetUpdateDirectiveClass:
   case OMPTaskDirectiveClass:
   case OMPTaskgroupDirectiveClass:
   case OMPTaskwaitDirectiveClass:
   case OMPTaskyieldDirectiveClass:
   case OMPTeamsDirectiveClass:
   case ObjCAtCatchStmtClass:
   case ObjCAtFinallyStmtClass:
   case ObjCAtSynchronizedStmtClass:
   case ObjCAtThrowStmtClass:
   case ObjCAtTryStmtClass:
   case ObjCAutoreleasePoolStmtClass:
   case ObjCForCollectionStmtClass:
   case ReturnStmtClass:
   case SEHExceptStmtClass:
   case SEHFinallyStmtClass:
   case SEHLeaveStmtClass:
   case SEHTryStmtClass:
   case CaseStmtClass:
   case DefaultStmtClass:
   case SwitchStmtClass:
   case WhileStmtClass:
    throw new llvm_unreachable("cannot classify a statement");
   case ObjCIsaExprClass:
   case StringLiteralClass:
   case ObjCEncodeExprClass:
   case PredefinedExprClass:
   case ObjCSubscriptRefExprClass:
   case ObjCPropertyRefExprClass:
   case CXXTypeidExprClass:
   case UnresolvedLookupExprClass:
   case UnresolvedMemberExprClass:
   case TypoExprClass:
   case CXXDependentScopeMemberExprClass:
   case DependentScopeDeclRefExprClass:
   case ObjCIvarRefExprClass:
   case FunctionParmPackExprClass:
   case MSPropertyRefExprClass:
   case MSPropertySubscriptExprClass:
   case OMPArraySectionExprClass:
    // ObjC instance variables are lvalues
    // FIXME: ObjC++0x might have different rules
    return Expr.Classification.Kinds.CL_LValue;
   case CompoundLiteralExprClass:
    
    // C99 6.5.2.5p5 says that compound literals are lvalues.
    // In C++, they're prvalue temporaries.
    return Ctx.getLangOpts().CPlusPlus ? ClassifyTemporary(E.getType()) : Expr.Classification.Kinds.CL_LValue;
   case CXXBoolLiteralExprClass:
   case CXXPseudoDestructorExprClass:
   case UnaryExprOrTypeTraitExprClass:
   case CXXNewExprClass:
   case CXXThisExprClass:
   case CXXNullPtrLiteralExprClass:
   case ImaginaryLiteralClass:
   case GNUNullExprClass:
   case OffsetOfExprClass:
   case CXXThrowExprClass:
   case ShuffleVectorExprClass:
   case ConvertVectorExprClass:
   case IntegerLiteralClass:
   case CharacterLiteralClass:
   case AddrLabelExprClass:
   case CXXDeleteExprClass:
   case ImplicitValueInitExprClass:
   case BlockExprClass:
   case FloatingLiteralClass:
   case CXXNoexceptExprClass:
   case CXXScalarValueInitExprClass:
   case TypeTraitExprClass:
   case ArrayTypeTraitExprClass:
   case ExpressionTraitExprClass:
   case ObjCSelectorExprClass:
   case ObjCProtocolExprClass:
   case ObjCStringLiteralClass:
   case ObjCBoxedExprClass:
   case ObjCArrayLiteralClass:
   case ObjCDictionaryLiteralClass:
   case ObjCBoolLiteralExprClass:
   case ObjCAvailabilityCheckExprClass:
   case ParenListExprClass:
   case SizeOfPackExprClass:
   case SubstNonTypeTemplateParmPackExprClass:
   case AsTypeExprClass:
   case ObjCIndirectCopyRestoreExprClass:
   case AtomicExprClass:
   case CXXFoldExprClass:
   case NoInitExprClass:
   case DesignatedInitUpdateExprClass:
   case CoyieldExprClass:
    
    // Expressions that are prvalues.
    return Expr.Classification.Kinds.CL_PRValue;
   case SubstNonTypeTemplateParmExprClass:
    
    // Next come the complicated cases.
    return ClassifyInternal(Ctx, 
        cast_SubstNonTypeTemplateParmExpr(E).getReplacement());
   case ArraySubscriptExprClass:
    
    // C++ [expr.sub]p1: The result is an lvalue of type "T".
    // However, subscripting vector types is more like member access.
    if (cast_ArraySubscriptExpr(E).getBase$Const().getType().$arrow().isVectorType()) {
      return ClassifyInternal(Ctx, cast_ArraySubscriptExpr(E).getBase$Const());
    }
    return Expr.Classification.Kinds.CL_LValue;
   case DeclRefExprClass:
    
    // C++ [expr.prim.general]p3: The result is an lvalue if the entity is a
    //   function or variable and a prvalue otherwise.
    if ($eq_QualType$C(E.getType(), Ctx.UnknownAnyTy.$QualType())) {
      return isa_FunctionDecl(cast_DeclRefExpr(E).getDecl$Const()) ? Expr.Classification.Kinds.CL_PRValue : Expr.Classification.Kinds.CL_LValue;
    }
    return ClassifyDecl(Ctx, cast_DeclRefExpr(E).getDecl$Const());
   case MemberExprClass:
    
    // Member access is complex.
    return ClassifyMemberExpr(Ctx, cast_MemberExpr(E));
   case UnaryOperatorClass:
    switch (cast_UnaryOperator(E).getOpcode()) {
     case UO_Deref:
      // C++ [expr.unary.op]p1: The unary * operator performs indirection:
      //   [...] the result is an lvalue referring to the object or function
      //   to which the expression points.
      return Expr.Classification.Kinds.CL_LValue;
     case UO_Extension:
      
      // GNU extensions, simply look through them.
      return ClassifyInternal(Ctx, cast_UnaryOperator(E).getSubExpr());
     case UO_Real:
     case UO_Imag:
      {
        /*const*/ Expr /*P*/ Op = cast_UnaryOperator(E).getSubExpr().IgnoreParens();
        Expr.Classification.Kinds K = ClassifyInternal(Ctx, Op);
        if (K != Expr.Classification.Kinds.CL_LValue) {
          return K;
        }
        if (isa_ObjCPropertyRefExpr(Op)) {
          return Expr.Classification.Kinds.CL_SubObjCPropertySetting;
        }
        return Expr.Classification.Kinds.CL_LValue;
      }
     case UO_PreInc:
     case UO_PreDec:
      
      // C++ [expr.pre.incr]p1: The result is the updated operand; it is an
      //   lvalue, [...]
      // Not so in C.
      return Lang.CPlusPlus ? Expr.Classification.Kinds.CL_LValue : Expr.Classification.Kinds.CL_PRValue;
     default:
      return Expr.Classification.Kinds.CL_PRValue;
    }
   case OpaqueValueExprClass:
    return ClassifyExprValueKind(Lang, E, E.getValueKind());
   case PseudoObjectExprClass:
    
    // Pseudo-object expressions can produce l-values with reference magic.
    return ClassifyExprValueKind(Lang, E, 
        cast_PseudoObjectExpr(E).getValueKind());
   case ImplicitCastExprClass:
    
    // Implicit casts are lvalues if they're lvalue casts. Other than that, we
    // only specifically record class temporaries.
    return ClassifyExprValueKind(Lang, E, E.getValueKind());
   case ParenExprClass:
    
    // C++ [expr.prim.general]p4: The presence of parentheses does not affect
    //   whether the expression is an lvalue.
    return ClassifyInternal(Ctx, cast_ParenExpr(E).getSubExpr$Const());
   case GenericSelectionExprClass:
    
    // C11 6.5.1.1p4: [A generic selection] is an lvalue, a function designator,
    // or a void expression if its result expression is, respectively, an
    // lvalue, a function designator, or a void expression.
    if (cast_GenericSelectionExpr(E).isResultDependent()) {
      return Expr.Classification.Kinds.CL_PRValue;
    }
    return ClassifyInternal(Ctx, cast_GenericSelectionExpr(E).getResultExpr$Const());
   case BinaryOperatorClass:
   case CompoundAssignOperatorClass:
    // C doesn't have any binary expressions that are lvalues.
    if (Lang.CPlusPlus) {
      return ClassifyBinaryOp(Ctx, cast_BinaryOperator(E));
    }
    return Expr.Classification.Kinds.CL_PRValue;
   case CallExprClass:
   case CXXOperatorCallExprClass:
   case CXXMemberCallExprClass:
   case UserDefinedLiteralClass:
   case CUDAKernelCallExprClass:
    return ClassifyUnnamed(Ctx, cast_CallExpr(E).getCallReturnType(Ctx));
   case ChooseExprClass:
    
    // __builtin_choose_expr is equivalent to the chosen expression.
    return ClassifyInternal(Ctx, cast_ChooseExpr(E).getChosenSubExpr());
   case ExtVectorElementExprClass:
    
    // Extended vector element access is an lvalue unless there are duplicates
    // in the shuffle expression.
    if (cast_ExtVectorElementExpr(E).containsDuplicateElements()) {
      return Expr.Classification.Kinds.CL_DuplicateVectorComponents;
    }
    if (cast_ExtVectorElementExpr(E).isArrow()) {
      return Expr.Classification.Kinds.CL_LValue;
    }
    return ClassifyInternal(Ctx, cast_ExtVectorElementExpr(E).getBase$Const());
   case CXXDefaultArgExprClass:
    
    // Simply look at the actual default argument.
    return ClassifyInternal(Ctx, cast_CXXDefaultArgExpr(E).getExpr$Const());
   case CXXDefaultInitExprClass:
    
    // Same idea for default initializers.
    return ClassifyInternal(Ctx, cast_CXXDefaultInitExpr(E).getExpr$Const());
   case CXXBindTemporaryExprClass:
    
    // Same idea for temporary binding.
    return ClassifyInternal(Ctx, cast_CXXBindTemporaryExpr(E).getSubExpr$Const());
   case ExprWithCleanupsClass:
    
    // And the cleanups guard.
    return ClassifyInternal(Ctx, cast_ExprWithCleanups(E).getSubExpr$Const());
   case CStyleCastExprClass:
   case CXXFunctionalCastExprClass:
   case CXXStaticCastExprClass:
   case CXXDynamicCastExprClass:
   case CXXReinterpretCastExprClass:
   case CXXConstCastExprClass:
   case ObjCBridgedCastExprClass:
    // Only in C++ can casts be interesting at all.
    if (!Lang.CPlusPlus) {
      return Expr.Classification.Kinds.CL_PRValue;
    }
    return ClassifyUnnamed(Ctx, cast_ExplicitCastExpr(E).getTypeAsWritten());
   case CXXUnresolvedConstructExprClass:
    return ClassifyUnnamed(Ctx, 
        cast_CXXUnresolvedConstructExpr(E).getTypeAsWritten());
   case BinaryConditionalOperatorClass:
    {
      if (!Lang.CPlusPlus) {
        return Expr.Classification.Kinds.CL_PRValue;
      }
      /*const*/ BinaryConditionalOperator /*P*/ co = cast_BinaryConditionalOperator(E);
      return ClassifyConditional(Ctx, co.getTrueExpr(), co.getFalseExpr());
    }
   case ConditionalOperatorClass:
    {
      // Once again, only C++ is interesting.
      if (!Lang.CPlusPlus) {
        return Expr.Classification.Kinds.CL_PRValue;
      }
      /*const*/ ConditionalOperator /*P*/ co = cast_ConditionalOperator(E);
      return ClassifyConditional(Ctx, co.getTrueExpr(), co.getFalseExpr());
    }
   case ObjCMessageExprClass:
    {
      
      // ObjC message sends are effectively function calls, if the target function
      // is known.
      /*const*/ ObjCMethodDecl /*P*/ Method = cast_ObjCMessageExpr(E).getMethodDecl$Const();
      if ((Method != null)) {
        Expr.Classification.Kinds kind = ClassifyUnnamed(Ctx, Method.getReturnType());
        return (kind == Expr.Classification.Kinds.CL_PRValue) ? Expr.Classification.Kinds.CL_ObjCMessageRValue : kind;
      }
    }
    return Expr.Classification.Kinds.CL_PRValue;
   case CXXConstructExprClass:
   case CXXInheritedCtorInitExprClass:
   case CXXTemporaryObjectExprClass:
   case LambdaExprClass:
   case CXXStdInitializerListExprClass:
    
    // Some C++ expressions are always class temporaries.
    return Expr.Classification.Kinds.CL_ClassTemporary;
   case VAArgExprClass:
    return ClassifyUnnamed(Ctx, E.getType());
   case DesignatedInitExprClass:
    return ClassifyInternal(Ctx, cast_DesignatedInitExpr(E).getInit());
   case StmtExprClass:
    {
      /*const*/ CompoundStmt /*P*/ S = cast_StmtExpr(E).getSubStmt$Const();
      {
        /*const*/ Expr /*P*/ LastExpr = dyn_cast_or_null_Expr(S.body_back$Const());
        if ((LastExpr != null)) {
          return ClassifyUnnamed(Ctx, LastExpr.getType());
        }
      }
      return Expr.Classification.Kinds.CL_PRValue;
    }
   case CXXUuidofExprClass:
    return Expr.Classification.Kinds.CL_LValue;
   case PackExpansionExprClass:
    return ClassifyInternal(Ctx, cast_PackExpansionExpr(E).getPattern$Const());
   case MaterializeTemporaryExprClass:
    return cast_MaterializeTemporaryExpr(E).isBoundToLvalueReference() ? Expr.Classification.Kinds.CL_LValue : Expr.Classification.Kinds.CL_XValue;
   case InitListExprClass:
    // An init list can be an lvalue if it is bound to a reference and
    // contains only one element. In that case, we look at that element
    // for an exact classification. Init list creation takes care of the
    // value kind for us, so we only need to fine-tune.
    if (E.isRValue()) {
      return ClassifyExprValueKind(Lang, E, E.getValueKind());
    }
    assert (cast_InitListExpr(E).getNumInits() == 1) : "Only 1-element init lists can be glvalues.";
    return ClassifyInternal(Ctx, cast_InitListExpr(E).getInit$Const(0));
   case CoawaitExprClass:
    return ClassifyInternal(Ctx, cast_CoawaitExpr(E).getResumeExpr());
  }
  throw new llvm_unreachable("unhandled expression kind in classification");
}


/// ClassifyDecl - Return the classification of an expression referencing the
/// given declaration.
//<editor-fold defaultstate="collapsed" desc="ClassifyDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 414,
 FQN="ClassifyDecl", NM="_ZL12ClassifyDeclRN5clang10ASTContextEPKNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL12ClassifyDeclRN5clang10ASTContextEPKNS_4DeclE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyDecl(final ASTContext /*&*/ Ctx, /*const*/ Decl /*P*/ D) {
  // C++ [expr.prim.general]p6: The result is an lvalue if the entity is a
  //   function, variable, or data member and a prvalue otherwise.
  // In C, functions are not lvalues.
  // In addition, NonTypeTemplateParmDecl derives from VarDecl but isn't an
  // lvalue unless it's a reference type (C++ [temp.param]p6), so we need to
  // special-case this.
  if (isa_CXXMethodDecl(D) && cast_CXXMethodDecl(D).isInstance()) {
    return Expr.Classification.Kinds.CL_MemberFunction;
  }
  
  boolean islvalue;
  {
    /*const*/ NonTypeTemplateParmDecl /*P*/ NTTParm = dyn_cast_NonTypeTemplateParmDecl(D);
    if ((NTTParm != null)) {
      islvalue = NTTParm.getType().$arrow().isReferenceType();
    } else {
      islvalue = isa_VarDecl(D) || isa_FieldDecl(D)
         || isa_IndirectFieldDecl(D)
         || (Ctx.getLangOpts().CPlusPlus
         && (isa_FunctionDecl(D) || isa_MSPropertyDecl(D)
         || isa_FunctionTemplateDecl(D)));
    }
  }
  
  return islvalue ? Expr.Classification.Kinds.CL_LValue : Expr.Classification.Kinds.CL_PRValue;
}


/// ClassifyUnnamed - Return the classification of an expression yielding an
/// unnamed value of the given type. This applies in particular to function
/// calls and casts.
//<editor-fold defaultstate="collapsed" desc="ClassifyUnnamed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 442,
 FQN="ClassifyUnnamed", NM="_ZL15ClassifyUnnamedRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL15ClassifyUnnamedRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyUnnamed(final ASTContext /*&*/ Ctx, QualType T) {
  // In C, function calls are always rvalues.
  if (!Ctx.getLangOpts().CPlusPlus) {
    return Expr.Classification.Kinds.CL_PRValue;
  }
  
  // C++ [expr.call]p10: A function call is an lvalue if the result type is an
  //   lvalue reference type or an rvalue reference to function type, an xvalue
  //   if the result type is an rvalue reference to object type, and a prvalue
  //   otherwise.
  if (T.$arrow().isLValueReferenceType()) {
    return Expr.Classification.Kinds.CL_LValue;
  }
  /*const*/ RValueReferenceType /*P*/ RV = T.$arrow().getAs(RValueReferenceType.class);
  if (!(RV != null)) { // Could still be a class temporary, though.
    return ClassifyTemporary(new QualType(T));
  }
  
  return RV.getPointeeType().$arrow().isFunctionType() ? Expr.Classification.Kinds.CL_LValue : Expr.Classification.Kinds.CL_XValue;
}

//<editor-fold defaultstate="collapsed" desc="ClassifyMemberExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 459,
 FQN="ClassifyMemberExpr", NM="_ZL18ClassifyMemberExprRN5clang10ASTContextEPKNS_10MemberExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL18ClassifyMemberExprRN5clang10ASTContextEPKNS_10MemberExprE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyMemberExpr(final ASTContext /*&*/ Ctx, /*const*/ MemberExpr /*P*/ E) {
  if ($eq_QualType$C(E.getType(), Ctx.UnknownAnyTy.$QualType())) {
    return (isa_FunctionDecl(E.getMemberDecl()) ? Expr.Classification.Kinds.CL_PRValue : Expr.Classification.Kinds.CL_LValue);
  }
  
  // Handle C first, it's easier.
  if (!Ctx.getLangOpts().CPlusPlus) {
    // C99 6.5.2.3p3
    // For dot access, the expression is an lvalue if the first part is. For
    // arrow access, it always is an lvalue.
    if (E.isArrow()) {
      return Expr.Classification.Kinds.CL_LValue;
    }
    // ObjC property accesses are not lvalues, but get special treatment.
    Expr /*P*/ Base = E.getBase().IgnoreParens();
    if (isa_ObjCPropertyRefExpr(Base)) {
      return Expr.Classification.Kinds.CL_SubObjCPropertySetting;
    }
    return ClassifyInternal(Ctx, Base);
  }
  
  NamedDecl /*P*/ Member = E.getMemberDecl();
  {
    // C++ [expr.ref]p3: E1->E2 is converted to the equivalent form (*(E1)).E2.
    // C++ [expr.ref]p4: If E2 is declared to have type "reference to T", then
    //   E1.E2 is an lvalue.
    ValueDecl /*P*/ Value = dyn_cast_ValueDecl(Member);
    if ((Value != null)) {
      if (Value.getType().$arrow().isReferenceType()) {
        return Expr.Classification.Kinds.CL_LValue;
      }
    }
  }
  
  //   Otherwise, one of the following rules applies.
  //   -- If E2 is a static member [...] then E1.E2 is an lvalue.
  if (isa_VarDecl(Member) && Member.getDeclContext().isRecord()) {
    return Expr.Classification.Kinds.CL_LValue;
  }
  
  //   -- If E2 is a non-static data member [...]. If E1 is an lvalue, then
  //      E1.E2 is an lvalue; if E1 is an xvalue, then E1.E2 is an xvalue;
  //      otherwise, it is a prvalue.
  if (isa_FieldDecl(Member)) {
    // *E1 is an lvalue
    if (E.isArrow()) {
      return Expr.Classification.Kinds.CL_LValue;
    }
    Expr /*P*/ Base = E.getBase().IgnoreParenImpCasts();
    if (isa_ObjCPropertyRefExpr(Base)) {
      return Expr.Classification.Kinds.CL_SubObjCPropertySetting;
    }
    return ClassifyInternal(Ctx, E.getBase());
  }
  {
    
    //   -- If E2 is a [...] member function, [...]
    //      -- If it refers to a static member function [...], then E1.E2 is an
    //         lvalue; [...]
    //      -- Otherwise [...] E1.E2 is a prvalue.
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Member);
    if ((Method != null)) {
      return Method.isStatic() ? Expr.Classification.Kinds.CL_LValue : Expr.Classification.Kinds.CL_MemberFunction;
    }
  }
  
  //   -- If E2 is a member enumerator [...], the expression E1.E2 is a prvalue.
  // So is everything else we haven't handled yet.
  return Expr.Classification.Kinds.CL_PRValue;
}

//<editor-fold defaultstate="collapsed" desc="ClassifyBinaryOp">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 516,
 FQN="ClassifyBinaryOp", NM="_ZL16ClassifyBinaryOpRN5clang10ASTContextEPKNS_14BinaryOperatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL16ClassifyBinaryOpRN5clang10ASTContextEPKNS_14BinaryOperatorE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyBinaryOp(final ASTContext /*&*/ Ctx, /*const*/ BinaryOperator /*P*/ E) {
  assert (Ctx.getLangOpts().CPlusPlus) : "This is only relevant for C++.";
  // C++ [expr.ass]p1: All [...] return an lvalue referring to the left operand.
  // Except we override this for writes to ObjC properties.
  if (E.isAssignmentOp()) {
    return (E.getLHS().getObjectKind() == ExprObjectKind.OK_ObjCProperty ? Expr.Classification.Kinds.CL_PRValue : Expr.Classification.Kinds.CL_LValue);
  }
  
  // C++ [expr.comma]p1: the result is of the same value category as its right
  //   operand, [...].
  if (E.getOpcode() == BinaryOperatorKind.BO_Comma) {
    return ClassifyInternal(Ctx, E.getRHS());
  }
  
  // C++ [expr.mptr.oper]p6: The result of a .* expression whose second operand
  //   is a pointer to a data member is of the same value category as its first
  //   operand.
  if (E.getOpcode() == BinaryOperatorKind.BO_PtrMemD) {
    return (E.getType().$arrow().isFunctionType()
       || E.hasPlaceholderType(BuiltinType.Kind.BoundMember)) ? Expr.Classification.Kinds.CL_MemberFunction : ClassifyInternal(Ctx, E.getLHS());
  }
  
  // C++ [expr.mptr.oper]p6: The result of an ->* expression is an lvalue if its
  //   second operand is a pointer to data member and a prvalue otherwise.
  if (E.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
    return (E.getType().$arrow().isFunctionType()
       || E.hasPlaceholderType(BuiltinType.Kind.BoundMember)) ? Expr.Classification.Kinds.CL_MemberFunction : Expr.Classification.Kinds.CL_LValue;
  }
  
  // All other binary operations are prvalues.
  return Expr.Classification.Kinds.CL_PRValue;
}

//<editor-fold defaultstate="collapsed" desc="ClassifyConditional">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 551,
 FQN="ClassifyConditional", NM="_ZL19ClassifyConditionalRN5clang10ASTContextEPKNS_4ExprES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL19ClassifyConditionalRN5clang10ASTContextEPKNS_4ExprES4_")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyConditional(final ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ True, 
                   /*const*/ Expr /*P*/ False) {
  assert (Ctx.getLangOpts().CPlusPlus) : "This is only relevant for C++.";
  
  // C++ [expr.cond]p2
  //   If either the second or the third operand has type (cv) void,
  //   one of the following shall hold:
  if (True.getType().$arrow().isVoidType() || False.getType().$arrow().isVoidType()) {
    // The second or the third operand (but not both) is a (possibly
    // parenthesized) throw-expression; the result is of the [...] value
    // category of the other.
    boolean TrueIsThrow = isa_CXXThrowExpr(True.IgnoreParenImpCasts$Const());
    boolean FalseIsThrow = isa_CXXThrowExpr(False.IgnoreParenImpCasts$Const());
    {
      /*const*/ Expr /*P*/ NonThrow = TrueIsThrow ? (FalseIsThrow ? null : False) : (FalseIsThrow ? True : null);
      if ((NonThrow != null)) {
        return ClassifyInternal(Ctx, NonThrow);
      }
    }
    
    //   [Otherwise] the result [...] is a prvalue.
    return Expr.Classification.Kinds.CL_PRValue;
  }
  
  // Note that at this point, we have already performed all conversions
  // according to [expr.cond]p3.
  // C++ [expr.cond]p4: If the second and third operands are glvalues of the
  //   same value category [...], the result is of that [...] value category.
  // C++ [expr.cond]p5: Otherwise, the result is a prvalue.
  Expr.Classification.Kinds LCl = ClassifyInternal(Ctx, True);
  Expr.Classification.Kinds RCl = ClassifyInternal(Ctx, False);
  return LCl == RCl ? LCl : Expr.Classification.Kinds.CL_PRValue;
}

//<editor-fold defaultstate="collapsed" desc="IsModifiable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 583,
 FQN="IsModifiable", NM="_ZL12IsModifiableRN5clang10ASTContextEPKNS_4ExprENS2_14Classification5KindsERNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL12IsModifiableRN5clang10ASTContextEPKNS_4ExprENS2_14Classification5KindsERNS_14SourceLocationE")
//</editor-fold>
public static Expr.Classification.ModifiableType IsModifiable(final ASTContext /*&*/ Ctx, /*const*/ Expr /*P*/ E, 
            Expr.Classification.Kinds Kind, final SourceLocation /*&*/ Loc) {
  // As a general rule, we only care about lvalues. But there are some rvalues
  // for which we want to generate special results.
  if (Kind == Expr.Classification.Kinds.CL_PRValue) {
    {
      // For the sake of better diagnostics, we want to specifically recognize
      // use of the GCC cast-as-lvalue extension.
      /*const*/ ExplicitCastExpr /*P*/ CE = dyn_cast_ExplicitCastExpr(E.IgnoreParens$Const());
      if ((CE != null)) {
        if (CE.getSubExpr$Const().IgnoreParenImpCasts$Const().isLValue()) {
          Loc.$assignMove(CE.getExprLoc());
          return Expr.Classification.ModifiableType.CM_LValueCast;
        }
      }
    }
  }
  if (Kind != Expr.Classification.Kinds.CL_LValue) {
    return Expr.Classification.ModifiableType.CM_RValue;
  }
  
  // This is the lvalue case.
  // Functions are lvalues in C++, but not modifiable. (C++ [basic.lval]p6)
  if (Ctx.getLangOpts().CPlusPlus && E.getType().$arrow().isFunctionType()) {
    return Expr.Classification.ModifiableType.CM_Function;
  }
  {
    
    // Assignment to a property in ObjC is an implicit setter access. But a
    // setter might not exist.
    /*const*/ ObjCPropertyRefExpr /*P*/ _Expr = dyn_cast_ObjCPropertyRefExpr(E);
    if ((_Expr != null)) {
      if (_Expr.isImplicitProperty()
         && _Expr.getImplicitPropertySetter() == null) {
        return Expr.Classification.ModifiableType.CM_NoSetterProperty;
      }
    }
  }
  
  CanQual<Type> CT = Ctx.getCanonicalType(E.getType());
  // Const stuff is obviously not modifiable.
  if (CT.isConstQualified()) {
    return Expr.Classification.ModifiableType.CM_ConstQualified;
  }
  if (CT.getQualifiers().getAddressSpace() == LangAS.ID.opencl_constant) {
    return Expr.Classification.ModifiableType.CM_ConstAddrSpace;
  }
  
  // Arrays are not modifiable, only their elements are.
  if (((CanProxyType)CT.$arrow()).$arrow().isArrayType()) {
    return Expr.Classification.ModifiableType.CM_ArrayType;
  }
  // Incomplete types are not modifiable.
  if (((CanProxyType)CT.$arrow()).$arrow().isIncompleteType()) {
    return Expr.Classification.ModifiableType.CM_IncompleteType;
  }
  {
    
    // Records with any const fields (recursively) are not modifiable.
    /*const*/ RecordType /*P*/ R = ((CanProxyRecordType)((CanProxyType)CT.$arrow()).$arrow().getAs(RecordType.class)).$T$C$P();
    if ((R != null)) {
      if (R.hasConstFields()) {
        return Expr.Classification.ModifiableType.CM_ConstQualified;
      }
    }
  }
  
  return Expr.Classification.ModifiableType.CM_Modifiable;
}


/// Classify an expression which creates a temporary, based on its type.
//<editor-fold defaultstate="collapsed" desc="ClassifyTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 77,
 FQN="ClassifyTemporary", NM="_ZL17ClassifyTemporaryN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL17ClassifyTemporaryN5clang8QualTypeE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyTemporary(QualType T) {
  if (T.$arrow().isRecordType()) {
    return Expr.Classification.Kinds.CL_ClassTemporary;
  }
  if (T.$arrow().isArrayType()) {
    return Expr.Classification.Kinds.CL_ArrayTemporary;
  }
  
  // No special classification: these don't behave differently from normal
  // prvalues.
  return Expr.Classification.Kinds.CL_PRValue;
}

//<editor-fold defaultstate="collapsed" desc="ClassifyExprValueKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp", line = 88,
 FQN="ClassifyExprValueKind", NM="_ZL21ClassifyExprValueKindRKN5clang11LangOptionsEPKNS_4ExprENS_13ExprValueKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp -nm=_ZL21ClassifyExprValueKindRKN5clang11LangOptionsEPKNS_4ExprENS_13ExprValueKindE")
//</editor-fold>
public static Expr.Classification.Kinds ClassifyExprValueKind(final /*const*/ LangOptions /*&*/ Lang, 
                     /*const*/ Expr /*P*/ E, 
                     ExprValueKind Kind) {
  switch (Kind) {
   case VK_RValue:
    return Lang.CPlusPlus ? ClassifyTemporary(E.getType()) : Expr.Classification.Kinds.CL_PRValue;
   case VK_LValue:
    return Expr.Classification.Kinds.CL_LValue;
   case VK_XValue:
    return Expr.Classification.Kinds.CL_XValue;
  }
  throw new llvm_unreachable("Invalid value category of implicit cast.");
}

} // END OF class ExprClassificationStatics
