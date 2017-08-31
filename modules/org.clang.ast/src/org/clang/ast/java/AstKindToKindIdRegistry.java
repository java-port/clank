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
package org.clang.ast.java;

import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import org.clank.support.CollectionUtils;
import static org.clang.ast.ast_type_traits.ASTNodeKind.*;
import static org.clank.java.std.*;

public final class AstKindToKindIdRegistry {

  public static final java.util.Map<Class<?>, NodeKindId> Class2NodeKindId = CollectionUtils.<Class<?>, NodeKindId>asMap(
    pair.of(AbstractConditionalOperator.class, KindToKindIdAbstractConditionalOperator.Id),
    pair.of(AccessSpecDecl.class, KindToKindIdAccessSpecDecl.Id),
    pair.of(AddrLabelExpr.class, KindToKindIdAddrLabelExpr.Id),
    pair.of(AdjustedType.class, KindToKindIdAdjustedType.Id),
    pair.of(ArraySubscriptExpr.class, KindToKindIdArraySubscriptExpr.Id),
    pair.of(ArrayType.class, KindToKindIdArrayType.Id),
    pair.of(ArrayTypeTraitExpr.class, KindToKindIdArrayTypeTraitExpr.Id),
    pair.of(AsTypeExpr.class, KindToKindIdAsTypeExpr.Id),
    pair.of(AsmStmt.class, KindToKindIdAsmStmt.Id),
    pair.of(AtomicExpr.class, KindToKindIdAtomicExpr.Id),
    pair.of(AtomicType.class, KindToKindIdAtomicType.Id),
    pair.of(AttributedStmt.class, KindToKindIdAttributedStmt.Id),
    pair.of(AttributedType.class, KindToKindIdAttributedType.Id),
    pair.of(AutoType.class, KindToKindIdAutoType.Id),
    pair.of(BinaryConditionalOperator.class, KindToKindIdBinaryConditionalOperator.Id),
    pair.of(BinaryOperator.class, KindToKindIdBinaryOperator.Id),
    pair.of(BlockDecl.class, KindToKindIdBlockDecl.Id),
    pair.of(BlockExpr.class, KindToKindIdBlockExpr.Id),
    pair.of(BlockPointerType.class, KindToKindIdBlockPointerType.Id),
    pair.of(BreakStmt.class, KindToKindIdBreakStmt.Id),
    pair.of(BuiltinTemplateDecl.class, KindToKindIdBuiltinTemplateDecl.Id),
    pair.of(BuiltinType.class, KindToKindIdBuiltinType.Id),
    pair.of(CStyleCastExpr.class, KindToKindIdCStyleCastExpr.Id),
    pair.of(CUDAKernelCallExpr.class, KindToKindIdCUDAKernelCallExpr.Id),
    pair.of(CXXBindTemporaryExpr.class, KindToKindIdCXXBindTemporaryExpr.Id),
    pair.of(CXXBoolLiteralExpr.class, KindToKindIdCXXBoolLiteralExpr.Id),
    pair.of(CXXCatchStmt.class, KindToKindIdCXXCatchStmt.Id),
    pair.of(CXXConstCastExpr.class, KindToKindIdCXXConstCastExpr.Id),
    pair.of(CXXConstructExpr.class, KindToKindIdCXXConstructExpr.Id),
    pair.of(CXXConstructorDecl.class, KindToKindIdCXXConstructorDecl.Id),
    pair.of(CXXConversionDecl.class, KindToKindIdCXXConversionDecl.Id),
    pair.of(CXXCtorInitializer.class, KindToKindIdCXXCtorInitializer.Id),
    pair.of(CXXDefaultArgExpr.class, KindToKindIdCXXDefaultArgExpr.Id),
    pair.of(CXXDefaultInitExpr.class, KindToKindIdCXXDefaultInitExpr.Id),
    pair.of(CXXDeleteExpr.class, KindToKindIdCXXDeleteExpr.Id),
    pair.of(CXXDependentScopeMemberExpr.class, KindToKindIdCXXDependentScopeMemberExpr.Id),
    pair.of(CXXDestructorDecl.class, KindToKindIdCXXDestructorDecl.Id),
    pair.of(CXXDynamicCastExpr.class, KindToKindIdCXXDynamicCastExpr.Id),
    pair.of(CXXFoldExpr.class, KindToKindIdCXXFoldExpr.Id),
    pair.of(CXXForRangeStmt.class, KindToKindIdCXXForRangeStmt.Id),
    pair.of(CXXFunctionalCastExpr.class, KindToKindIdCXXFunctionalCastExpr.Id),
    pair.of(CXXInheritedCtorInitExpr.class, KindToKindIdCXXInheritedCtorInitExpr.Id),
    pair.of(CXXMemberCallExpr.class, KindToKindIdCXXMemberCallExpr.Id),
    pair.of(CXXMethodDecl.class, KindToKindIdCXXMethodDecl.Id),
    pair.of(CXXNamedCastExpr.class, KindToKindIdCXXNamedCastExpr.Id),
    pair.of(CXXNewExpr.class, KindToKindIdCXXNewExpr.Id),
    pair.of(CXXNoexceptExpr.class, KindToKindIdCXXNoexceptExpr.Id),
    pair.of(CXXNullPtrLiteralExpr.class, KindToKindIdCXXNullPtrLiteralExpr.Id),
    pair.of(CXXOperatorCallExpr.class, KindToKindIdCXXOperatorCallExpr.Id),
    pair.of(CXXPseudoDestructorExpr.class, KindToKindIdCXXPseudoDestructorExpr.Id),
    pair.of(CXXRecordDecl.class, KindToKindIdCXXRecordDecl.Id),
    pair.of(CXXReinterpretCastExpr.class, KindToKindIdCXXReinterpretCastExpr.Id),
    pair.of(CXXScalarValueInitExpr.class, KindToKindIdCXXScalarValueInitExpr.Id),
    pair.of(CXXStaticCastExpr.class, KindToKindIdCXXStaticCastExpr.Id),
    pair.of(CXXStdInitializerListExpr.class, KindToKindIdCXXStdInitializerListExpr.Id),
    pair.of(CXXTemporaryObjectExpr.class, KindToKindIdCXXTemporaryObjectExpr.Id),
    pair.of(CXXThisExpr.class, KindToKindIdCXXThisExpr.Id),
    pair.of(CXXThrowExpr.class, KindToKindIdCXXThrowExpr.Id),
    pair.of(CXXTryStmt.class, KindToKindIdCXXTryStmt.Id),
    pair.of(CXXTypeidExpr.class, KindToKindIdCXXTypeidExpr.Id),
    pair.of(CXXUnresolvedConstructExpr.class, KindToKindIdCXXUnresolvedConstructExpr.Id),
    pair.of(CXXUuidofExpr.class, KindToKindIdCXXUuidofExpr.Id),
    pair.of(CallExpr.class, KindToKindIdCallExpr.Id),
    pair.of(CapturedDecl.class, KindToKindIdCapturedDecl.Id),
    pair.of(CapturedStmt.class, KindToKindIdCapturedStmt.Id),
    pair.of(CaseStmt.class, KindToKindIdCaseStmt.Id),
    pair.of(CastExpr.class, KindToKindIdCastExpr.Id),
    pair.of(CharacterLiteral.class, KindToKindIdCharacterLiteral.Id),
    pair.of(ChooseExpr.class, KindToKindIdChooseExpr.Id),
    pair.of(ClassScopeFunctionSpecializationDecl.class, KindToKindIdClassScopeFunctionSpecializationDecl.Id),
    pair.of(ClassTemplateDecl.class, KindToKindIdClassTemplateDecl.Id),
    pair.of(ClassTemplatePartialSpecializationDecl.class, KindToKindIdClassTemplatePartialSpecializationDecl.Id),
    pair.of(ClassTemplateSpecializationDecl.class, KindToKindIdClassTemplateSpecializationDecl.Id),
    pair.of(CoawaitExpr.class, KindToKindIdCoawaitExpr.Id),
    pair.of(ComplexType.class, KindToKindIdComplexType.Id),
    pair.of(CompoundAssignOperator.class, KindToKindIdCompoundAssignOperator.Id),
    pair.of(CompoundLiteralExpr.class, KindToKindIdCompoundLiteralExpr.Id),
    pair.of(CompoundStmt.class, KindToKindIdCompoundStmt.Id),
    pair.of(ConditionalOperator.class, KindToKindIdConditionalOperator.Id),
    pair.of(ConstantArrayType.class, KindToKindIdConstantArrayType.Id),
    pair.of(ConstructorUsingShadowDecl.class, KindToKindIdConstructorUsingShadowDecl.Id),
    pair.of(ContinueStmt.class, KindToKindIdContinueStmt.Id),
    pair.of(ConvertVectorExpr.class, KindToKindIdConvertVectorExpr.Id),
    pair.of(CoreturnStmt.class, KindToKindIdCoreturnStmt.Id),
    pair.of(CoroutineBodyStmt.class, KindToKindIdCoroutineBodyStmt.Id),
    pair.of(CoroutineSuspendExpr.class, KindToKindIdCoroutineSuspendExpr.Id),
    pair.of(CoyieldExpr.class, KindToKindIdCoyieldExpr.Id),
    pair.of(DecayedType.class, KindToKindIdDecayedType.Id),
    pair.of(Decl.class, KindToKindIdDecl.Id),
    pair.of(DeclRefExpr.class, KindToKindIdDeclRefExpr.Id),
    pair.of(DeclStmt.class, KindToKindIdDeclStmt.Id),
    pair.of(DeclaratorDecl.class, KindToKindIdDeclaratorDecl.Id),
    pair.of(DecltypeType.class, KindToKindIdDecltypeType.Id),
    pair.of(DefaultStmt.class, KindToKindIdDefaultStmt.Id),
    pair.of(DependentNameType.class, KindToKindIdDependentNameType.Id),
    pair.of(DependentScopeDeclRefExpr.class, KindToKindIdDependentScopeDeclRefExpr.Id),
    pair.of(DependentSizedArrayType.class, KindToKindIdDependentSizedArrayType.Id),
    pair.of(DependentSizedExtVectorType.class, KindToKindIdDependentSizedExtVectorType.Id),
    pair.of(DependentTemplateSpecializationType.class, KindToKindIdDependentTemplateSpecializationType.Id),
    pair.of(DesignatedInitExpr.class, KindToKindIdDesignatedInitExpr.Id),
    pair.of(DesignatedInitUpdateExpr.class, KindToKindIdDesignatedInitUpdateExpr.Id),
    pair.of(DoStmt.class, KindToKindIdDoStmt.Id),
    pair.of(ElaboratedType.class, KindToKindIdElaboratedType.Id),
    pair.of(EmptyDecl.class, KindToKindIdEmptyDecl.Id),
    pair.of(EnumConstantDecl.class, KindToKindIdEnumConstantDecl.Id),
    pair.of(EnumDecl.class, KindToKindIdEnumDecl.Id),
    pair.of(EnumType.class, KindToKindIdEnumType.Id),
    pair.of(ExplicitCastExpr.class, KindToKindIdExplicitCastExpr.Id),
    pair.of(Expr.class, KindToKindIdExpr.Id),
    pair.of(ExprWithCleanups.class, KindToKindIdExprWithCleanups.Id),
    pair.of(ExpressionTraitExpr.class, KindToKindIdExpressionTraitExpr.Id),
    pair.of(ExtVectorElementExpr.class, KindToKindIdExtVectorElementExpr.Id),
    pair.of(ExtVectorType.class, KindToKindIdExtVectorType.Id),
    pair.of(ExternCContextDecl.class, KindToKindIdExternCContextDecl.Id),
    pair.of(FieldDecl.class, KindToKindIdFieldDecl.Id),
    pair.of(FileScopeAsmDecl.class, KindToKindIdFileScopeAsmDecl.Id),
    pair.of(FloatingLiteral.class, KindToKindIdFloatingLiteral.Id),
    pair.of(ForStmt.class, KindToKindIdForStmt.Id),
    pair.of(FriendDecl.class, KindToKindIdFriendDecl.Id),
    pair.of(FriendTemplateDecl.class, KindToKindIdFriendTemplateDecl.Id),
    pair.of(FunctionDecl.class, KindToKindIdFunctionDecl.Id),
    pair.of(FunctionNoProtoType.class, KindToKindIdFunctionNoProtoType.Id),
    pair.of(FunctionParmPackExpr.class, KindToKindIdFunctionParmPackExpr.Id),
    pair.of(FunctionProtoType.class, KindToKindIdFunctionProtoType.Id),
    pair.of(FunctionTemplateDecl.class, KindToKindIdFunctionTemplateDecl.Id),
    pair.of(FunctionType.class, KindToKindIdFunctionType.Id),
    pair.of(GCCAsmStmt.class, KindToKindIdGCCAsmStmt.Id),
    pair.of(GNUNullExpr.class, KindToKindIdGNUNullExpr.Id),
    pair.of(GenericSelectionExpr.class, KindToKindIdGenericSelectionExpr.Id),
    pair.of(GotoStmt.class, KindToKindIdGotoStmt.Id),
    pair.of(IfStmt.class, KindToKindIdIfStmt.Id),
    pair.of(ImaginaryLiteral.class, KindToKindIdImaginaryLiteral.Id),
    pair.of(ImplicitCastExpr.class, KindToKindIdImplicitCastExpr.Id),
    pair.of(ImplicitParamDecl.class, KindToKindIdImplicitParamDecl.Id),
    pair.of(ImplicitValueInitExpr.class, KindToKindIdImplicitValueInitExpr.Id),
    pair.of(ImportDecl.class, KindToKindIdImportDecl.Id),
    pair.of(IncompleteArrayType.class, KindToKindIdIncompleteArrayType.Id),
    pair.of(IndirectFieldDecl.class, KindToKindIdIndirectFieldDecl.Id),
    pair.of(IndirectGotoStmt.class, KindToKindIdIndirectGotoStmt.Id),
    pair.of(InitListExpr.class, KindToKindIdInitListExpr.Id),
    pair.of(InjectedClassNameType.class, KindToKindIdInjectedClassNameType.Id),
    pair.of(IntegerLiteral.class, KindToKindIdIntegerLiteral.Id),
    pair.of(LValueReferenceType.class, KindToKindIdLValueReferenceType.Id),
    pair.of(LabelDecl.class, KindToKindIdLabelDecl.Id),
    pair.of(LabelStmt.class, KindToKindIdLabelStmt.Id),
    pair.of(LambdaExpr.class, KindToKindIdLambdaExpr.Id),
    pair.of(LinkageSpecDecl.class, KindToKindIdLinkageSpecDecl.Id),
    pair.of(MSAsmStmt.class, KindToKindIdMSAsmStmt.Id),
    pair.of(MSDependentExistsStmt.class, KindToKindIdMSDependentExistsStmt.Id),
    pair.of(MSPropertyDecl.class, KindToKindIdMSPropertyDecl.Id),
    pair.of(MSPropertyRefExpr.class, KindToKindIdMSPropertyRefExpr.Id),
    pair.of(MSPropertySubscriptExpr.class, KindToKindIdMSPropertySubscriptExpr.Id),
    pair.of(MaterializeTemporaryExpr.class, KindToKindIdMaterializeTemporaryExpr.Id),
    pair.of(MemberExpr.class, KindToKindIdMemberExpr.Id),
    pair.of(MemberPointerType.class, KindToKindIdMemberPointerType.Id),
    pair.of(NamedDecl.class, KindToKindIdNamedDecl.Id),
    pair.of(NamespaceAliasDecl.class, KindToKindIdNamespaceAliasDecl.Id),
    pair.of(NamespaceDecl.class, KindToKindIdNamespaceDecl.Id),
    pair.of(NestedNameSpecifier.class, KindToKindIdNestedNameSpecifier.Id),
    pair.of(NestedNameSpecifierLoc.class, KindToKindIdNestedNameSpecifierLoc.Id),
    pair.of(NoInitExpr.class, KindToKindIdNoInitExpr.Id),
    pair.of(NonTypeTemplateParmDecl.class, KindToKindIdNonTypeTemplateParmDecl.Id),
    pair.of(NullStmt.class, KindToKindIdNullStmt.Id),
    pair.of(OMPArraySectionExpr.class, KindToKindIdOMPArraySectionExpr.Id),
    pair.of(OMPAtomicDirective.class, KindToKindIdOMPAtomicDirective.Id),
    pair.of(OMPBarrierDirective.class, KindToKindIdOMPBarrierDirective.Id),
    pair.of(OMPCancelDirective.class, KindToKindIdOMPCancelDirective.Id),
    pair.of(OMPCancellationPointDirective.class, KindToKindIdOMPCancellationPointDirective.Id),
    pair.of(OMPCapturedExprDecl.class, KindToKindIdOMPCapturedExprDecl.Id),
    pair.of(OMPCriticalDirective.class, KindToKindIdOMPCriticalDirective.Id),
    pair.of(OMPDeclareReductionDecl.class, KindToKindIdOMPDeclareReductionDecl.Id),
    pair.of(OMPDistributeDirective.class, KindToKindIdOMPDistributeDirective.Id),
    pair.of(OMPDistributeParallelForDirective.class, KindToKindIdOMPDistributeParallelForDirective.Id),
    pair.of(OMPDistributeParallelForSimdDirective.class, KindToKindIdOMPDistributeParallelForSimdDirective.Id),
    pair.of(OMPDistributeSimdDirective.class, KindToKindIdOMPDistributeSimdDirective.Id),
    pair.of(OMPExecutableDirective.class, KindToKindIdOMPExecutableDirective.Id),
    pair.of(OMPFlushDirective.class, KindToKindIdOMPFlushDirective.Id),
    pair.of(OMPForDirective.class, KindToKindIdOMPForDirective.Id),
    pair.of(OMPForSimdDirective.class, KindToKindIdOMPForSimdDirective.Id),
    pair.of(OMPLoopDirective.class, KindToKindIdOMPLoopDirective.Id),
    pair.of(OMPMasterDirective.class, KindToKindIdOMPMasterDirective.Id),
    pair.of(OMPOrderedDirective.class, KindToKindIdOMPOrderedDirective.Id),
    pair.of(OMPParallelDirective.class, KindToKindIdOMPParallelDirective.Id),
    pair.of(OMPParallelForDirective.class, KindToKindIdOMPParallelForDirective.Id),
    pair.of(OMPParallelForSimdDirective.class, KindToKindIdOMPParallelForSimdDirective.Id),
    pair.of(OMPParallelSectionsDirective.class, KindToKindIdOMPParallelSectionsDirective.Id),
    pair.of(OMPSectionDirective.class, KindToKindIdOMPSectionDirective.Id),
    pair.of(OMPSectionsDirective.class, KindToKindIdOMPSectionsDirective.Id),
    pair.of(OMPSimdDirective.class, KindToKindIdOMPSimdDirective.Id),
    pair.of(OMPSingleDirective.class, KindToKindIdOMPSingleDirective.Id),
    pair.of(OMPTargetDataDirective.class, KindToKindIdOMPTargetDataDirective.Id),
    pair.of(OMPTargetDirective.class, KindToKindIdOMPTargetDirective.Id),
    pair.of(OMPTargetEnterDataDirective.class, KindToKindIdOMPTargetEnterDataDirective.Id),
    pair.of(OMPTargetExitDataDirective.class, KindToKindIdOMPTargetExitDataDirective.Id),
    pair.of(OMPTargetParallelDirective.class, KindToKindIdOMPTargetParallelDirective.Id),
    pair.of(OMPTargetParallelForDirective.class, KindToKindIdOMPTargetParallelForDirective.Id),
    pair.of(OMPTargetParallelForSimdDirective.class, KindToKindIdOMPTargetParallelForSimdDirective.Id),
    pair.of(OMPTargetUpdateDirective.class, KindToKindIdOMPTargetUpdateDirective.Id),
    pair.of(OMPTaskDirective.class, KindToKindIdOMPTaskDirective.Id),
    pair.of(OMPTaskLoopDirective.class, KindToKindIdOMPTaskLoopDirective.Id),
    pair.of(OMPTaskLoopSimdDirective.class, KindToKindIdOMPTaskLoopSimdDirective.Id),
    pair.of(OMPTaskgroupDirective.class, KindToKindIdOMPTaskgroupDirective.Id),
    pair.of(OMPTaskwaitDirective.class, KindToKindIdOMPTaskwaitDirective.Id),
    pair.of(OMPTaskyieldDirective.class, KindToKindIdOMPTaskyieldDirective.Id),
    pair.of(OMPTeamsDirective.class, KindToKindIdOMPTeamsDirective.Id),
    pair.of(OMPThreadPrivateDecl.class, KindToKindIdOMPThreadPrivateDecl.Id),
    pair.of(ObjCArrayLiteral.class, KindToKindIdObjCArrayLiteral.Id),
    pair.of(ObjCAtCatchStmt.class, KindToKindIdObjCAtCatchStmt.Id),
    pair.of(ObjCAtDefsFieldDecl.class, KindToKindIdObjCAtDefsFieldDecl.Id),
    pair.of(ObjCAtFinallyStmt.class, KindToKindIdObjCAtFinallyStmt.Id),
    pair.of(ObjCAtSynchronizedStmt.class, KindToKindIdObjCAtSynchronizedStmt.Id),
    pair.of(ObjCAtThrowStmt.class, KindToKindIdObjCAtThrowStmt.Id),
    pair.of(ObjCAtTryStmt.class, KindToKindIdObjCAtTryStmt.Id),
    pair.of(ObjCAutoreleasePoolStmt.class, KindToKindIdObjCAutoreleasePoolStmt.Id),
    pair.of(ObjCAvailabilityCheckExpr.class, KindToKindIdObjCAvailabilityCheckExpr.Id),
    pair.of(ObjCBoolLiteralExpr.class, KindToKindIdObjCBoolLiteralExpr.Id),
    pair.of(ObjCBoxedExpr.class, KindToKindIdObjCBoxedExpr.Id),
    pair.of(ObjCBridgedCastExpr.class, KindToKindIdObjCBridgedCastExpr.Id),
    pair.of(ObjCCategoryDecl.class, KindToKindIdObjCCategoryDecl.Id),
    pair.of(ObjCCategoryImplDecl.class, KindToKindIdObjCCategoryImplDecl.Id),
    pair.of(ObjCCompatibleAliasDecl.class, KindToKindIdObjCCompatibleAliasDecl.Id),
    pair.of(ObjCContainerDecl.class, KindToKindIdObjCContainerDecl.Id),
    pair.of(ObjCDictionaryLiteral.class, KindToKindIdObjCDictionaryLiteral.Id),
    pair.of(ObjCEncodeExpr.class, KindToKindIdObjCEncodeExpr.Id),
    pair.of(ObjCForCollectionStmt.class, KindToKindIdObjCForCollectionStmt.Id),
    pair.of(ObjCImplDecl.class, KindToKindIdObjCImplDecl.Id),
    pair.of(ObjCImplementationDecl.class, KindToKindIdObjCImplementationDecl.Id),
    pair.of(ObjCIndirectCopyRestoreExpr.class, KindToKindIdObjCIndirectCopyRestoreExpr.Id),
    pair.of(ObjCInterfaceDecl.class, KindToKindIdObjCInterfaceDecl.Id),
    pair.of(ObjCInterfaceType.class, KindToKindIdObjCInterfaceType.Id),
    pair.of(ObjCIsaExpr.class, KindToKindIdObjCIsaExpr.Id),
    pair.of(ObjCIvarDecl.class, KindToKindIdObjCIvarDecl.Id),
    pair.of(ObjCIvarRefExpr.class, KindToKindIdObjCIvarRefExpr.Id),
    pair.of(ObjCMessageExpr.class, KindToKindIdObjCMessageExpr.Id),
    pair.of(ObjCMethodDecl.class, KindToKindIdObjCMethodDecl.Id),
    pair.of(ObjCObjectPointerType.class, KindToKindIdObjCObjectPointerType.Id),
    pair.of(ObjCObjectType.class, KindToKindIdObjCObjectType.Id),
    pair.of(ObjCPropertyDecl.class, KindToKindIdObjCPropertyDecl.Id),
    pair.of(ObjCPropertyImplDecl.class, KindToKindIdObjCPropertyImplDecl.Id),
    pair.of(ObjCPropertyRefExpr.class, KindToKindIdObjCPropertyRefExpr.Id),
    pair.of(ObjCProtocolDecl.class, KindToKindIdObjCProtocolDecl.Id),
    pair.of(ObjCProtocolExpr.class, KindToKindIdObjCProtocolExpr.Id),
    pair.of(ObjCSelectorExpr.class, KindToKindIdObjCSelectorExpr.Id),
    pair.of(ObjCStringLiteral.class, KindToKindIdObjCStringLiteral.Id),
    pair.of(ObjCSubscriptRefExpr.class, KindToKindIdObjCSubscriptRefExpr.Id),
    pair.of(ObjCTypeParamDecl.class, KindToKindIdObjCTypeParamDecl.Id),
    pair.of(OffsetOfExpr.class, KindToKindIdOffsetOfExpr.Id),
    pair.of(OpaqueValueExpr.class, KindToKindIdOpaqueValueExpr.Id),
    pair.of(OverloadExpr.class, KindToKindIdOverloadExpr.Id),
    pair.of(PackExpansionExpr.class, KindToKindIdPackExpansionExpr.Id),
    pair.of(PackExpansionType.class, KindToKindIdPackExpansionType.Id),
    pair.of(ParenExpr.class, KindToKindIdParenExpr.Id),
    pair.of(ParenListExpr.class, KindToKindIdParenListExpr.Id),
    pair.of(ParenType.class, KindToKindIdParenType.Id),
    pair.of(ParmVarDecl.class, KindToKindIdParmVarDecl.Id),
    pair.of(PipeType.class, KindToKindIdPipeType.Id),
    pair.of(PointerType.class, KindToKindIdPointerType.Id),
    pair.of(PragmaCommentDecl.class, KindToKindIdPragmaCommentDecl.Id),
    pair.of(PragmaDetectMismatchDecl.class, KindToKindIdPragmaDetectMismatchDecl.Id),
    pair.of(PredefinedExpr.class, KindToKindIdPredefinedExpr.Id),
    pair.of(PseudoObjectExpr.class, KindToKindIdPseudoObjectExpr.Id),
    pair.of(QualType.class, KindToKindIdQualType.Id),
    pair.of(RValueReferenceType.class, KindToKindIdRValueReferenceType.Id),
    pair.of(RecordDecl.class, KindToKindIdRecordDecl.Id),
    pair.of(RecordType.class, KindToKindIdRecordType.Id),
    pair.of(RedeclarableTemplateDecl.class, KindToKindIdRedeclarableTemplateDecl.Id),
    pair.of(ReferenceType.class, KindToKindIdReferenceType.Id),
    pair.of(ReturnStmt.class, KindToKindIdReturnStmt.Id),
    pair.of(SEHExceptStmt.class, KindToKindIdSEHExceptStmt.Id),
    pair.of(SEHFinallyStmt.class, KindToKindIdSEHFinallyStmt.Id),
    pair.of(SEHLeaveStmt.class, KindToKindIdSEHLeaveStmt.Id),
    pair.of(SEHTryStmt.class, KindToKindIdSEHTryStmt.Id),
    pair.of(ShuffleVectorExpr.class, KindToKindIdShuffleVectorExpr.Id),
    pair.of(SizeOfPackExpr.class, KindToKindIdSizeOfPackExpr.Id),
    pair.of(StaticAssertDecl.class, KindToKindIdStaticAssertDecl.Id),
    pair.of(Stmt.class, KindToKindIdStmt.Id),
    pair.of(StmtExpr.class, KindToKindIdStmtExpr.Id),
    pair.of(StringLiteral.class, KindToKindIdStringLiteral.Id),
    pair.of(SubstNonTypeTemplateParmExpr.class, KindToKindIdSubstNonTypeTemplateParmExpr.Id),
    pair.of(SubstNonTypeTemplateParmPackExpr.class, KindToKindIdSubstNonTypeTemplateParmPackExpr.Id),
    pair.of(SubstTemplateTypeParmPackType.class, KindToKindIdSubstTemplateTypeParmPackType.Id),
    pair.of(SubstTemplateTypeParmType.class, KindToKindIdSubstTemplateTypeParmType.Id),
    pair.of(SwitchCase.class, KindToKindIdSwitchCase.Id),
    pair.of(SwitchStmt.class, KindToKindIdSwitchStmt.Id),
    pair.of(TagDecl.class, KindToKindIdTagDecl.Id),
    pair.of(TagType.class, KindToKindIdTagType.Id),
    pair.of(TemplateArgument.class, KindToKindIdTemplateArgument.Id),
    pair.of(TemplateDecl.class, KindToKindIdTemplateDecl.Id),
    pair.of(TemplateSpecializationType.class, KindToKindIdTemplateSpecializationType.Id),
    pair.of(TemplateTemplateParmDecl.class, KindToKindIdTemplateTemplateParmDecl.Id),
    pair.of(TemplateTypeParmDecl.class, KindToKindIdTemplateTypeParmDecl.Id),
    pair.of(TemplateTypeParmType.class, KindToKindIdTemplateTypeParmType.Id),
    pair.of(TranslationUnitDecl.class, KindToKindIdTranslationUnitDecl.Id),
    pair.of(Type.class, KindToKindIdType.Id),
    pair.of(TypeAliasDecl.class, KindToKindIdTypeAliasDecl.Id),
    pair.of(TypeAliasTemplateDecl.class, KindToKindIdTypeAliasTemplateDecl.Id),
    pair.of(TypeDecl.class, KindToKindIdTypeDecl.Id),
    pair.of(TypeLoc.class, KindToKindIdTypeLoc.Id),
    pair.of(TypeOfExprType.class, KindToKindIdTypeOfExprType.Id),
    pair.of(TypeOfType.class, KindToKindIdTypeOfType.Id),
    pair.of(TypeTraitExpr.class, KindToKindIdTypeTraitExpr.Id),
    pair.of(TypedefDecl.class, KindToKindIdTypedefDecl.Id),
    pair.of(TypedefNameDecl.class, KindToKindIdTypedefNameDecl.Id),
    pair.of(TypedefType.class, KindToKindIdTypedefType.Id),
    pair.of(TypoExpr.class, KindToKindIdTypoExpr.Id),
    pair.of(UnaryExprOrTypeTraitExpr.class, KindToKindIdUnaryExprOrTypeTraitExpr.Id),
    pair.of(UnaryOperator.class, KindToKindIdUnaryOperator.Id),
    pair.of(UnaryTransformType.class, KindToKindIdUnaryTransformType.Id),
    pair.of(UnresolvedLookupExpr.class, KindToKindIdUnresolvedLookupExpr.Id),
    pair.of(UnresolvedMemberExpr.class, KindToKindIdUnresolvedMemberExpr.Id),
    pair.of(UnresolvedUsingType.class, KindToKindIdUnresolvedUsingType.Id),
    pair.of(UnresolvedUsingTypenameDecl.class, KindToKindIdUnresolvedUsingTypenameDecl.Id),
    pair.of(UnresolvedUsingValueDecl.class, KindToKindIdUnresolvedUsingValueDecl.Id),
    pair.of(UserDefinedLiteral.class, KindToKindIdUserDefinedLiteral.Id),
    pair.of(UsingDecl.class, KindToKindIdUsingDecl.Id),
    pair.of(UsingDirectiveDecl.class, KindToKindIdUsingDirectiveDecl.Id),
    pair.of(UsingShadowDecl.class, KindToKindIdUsingShadowDecl.Id),
    pair.of(VAArgExpr.class, KindToKindIdVAArgExpr.Id),
    pair.of(ValueDecl.class, KindToKindIdValueDecl.Id),
    pair.of(VarDecl.class, KindToKindIdVarDecl.Id),
    pair.of(VarTemplateDecl.class, KindToKindIdVarTemplateDecl.Id),
    pair.of(VarTemplatePartialSpecializationDecl.class, KindToKindIdVarTemplatePartialSpecializationDecl.Id),
    pair.of(VarTemplateSpecializationDecl.class, KindToKindIdVarTemplateSpecializationDecl.Id),
    pair.of(VariableArrayType.class, KindToKindIdVariableArrayType.Id),
    pair.of(VectorType.class, KindToKindIdVectorType.Id),
    pair.of(WhileStmt.class, KindToKindIdWhileStmt.Id)
  );
}
