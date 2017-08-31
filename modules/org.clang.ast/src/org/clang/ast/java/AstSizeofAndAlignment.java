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

import org.clank.support.NativeTrace;
import org.clank.support.NativeType;

/**
 *
 * @author Vladimir Voskresensky
 */
public interface AstSizeofAndAlignment {

  public static int $sizeof_TypeSpecLocInfo() {
    return NativeType.BYTES_IN_JAVA_OBJECT_HEADER
            + NativeType.BYTES_IN_UINT;
  }

  public static int $AlignOf_TypeSpecLocInfo() {
    return 0;
  }

  public static int $sizeof_QualType() {
    return NativeType.BYTES_IN_JAVA_OBJECT_REF;
  }
  
  public static int $sizeof_TypeSourceInfo() {
    return $sizeof_QualType();
  }
          
  public static int $sizeof_TemplateArgumentLocInfo() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_GCCAsmStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MSAsmStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_AttributedStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_BreakStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXCatchStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXForRangeStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXTryStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CapturedStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CompoundStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ContinueStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CoreturnStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CoroutineBodyStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DeclStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DoStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_BinaryConditionalOperator() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ConditionalOperator() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_AddrLabelExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ArraySubscriptExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ArrayTypeTraitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_AsTypeExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_AtomicExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_BinaryOperator() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CompoundAssignOperator() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_BlockExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXBindTemporaryExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXBoolLiteralExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXConstructExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXTemporaryObjectExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXDefaultArgExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXDefaultInitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXDeleteExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXDependentScopeMemberExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXFoldExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXInheritedCtorInitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXNewExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXNoexceptExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXNullPtrLiteralExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXPseudoDestructorExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXScalarValueInitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXStdInitializerListExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXThisExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXThrowExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXTypeidExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXUnresolvedConstructExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXUuidofExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CallExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CUDAKernelCallExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXMemberCallExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXOperatorCallExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UserDefinedLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CStyleCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXFunctionalCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXConstCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXDynamicCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXReinterpretCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXStaticCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCBridgedCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ImplicitCastExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CharacterLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ChooseExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CompoundLiteralExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ConvertVectorExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CoawaitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CoyieldExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DeclRefExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DependentScopeDeclRefExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DesignatedInitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DesignatedInitUpdateExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ExprWithCleanups() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ExpressionTraitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ExtVectorElementExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FloatingLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FunctionParmPackExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_GNUNullExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_GenericSelectionExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ImaginaryLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ImplicitValueInitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_InitListExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_IntegerLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_LambdaExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MSPropertyRefExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MSPropertySubscriptExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MaterializeTemporaryExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MemberExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_NoInitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPArraySectionExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCArrayLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAvailabilityCheckExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCBoolLiteralExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCBoxedExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCDictionaryLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCEncodeExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCIndirectCopyRestoreExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCIsaExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCIvarRefExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCMessageExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCPropertyRefExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCProtocolExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCSelectorExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCStringLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCSubscriptRefExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OffsetOfExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OpaqueValueExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UnresolvedLookupExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UnresolvedMemberExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_PackExpansionExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ParenExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ParenListExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_PredefinedExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_PseudoObjectExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ShuffleVectorExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SizeOfPackExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_StmtExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_StringLiteral() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SubstNonTypeTemplateParmExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SubstNonTypeTemplateParmPackExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TypeTraitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TypoExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UnaryExprOrTypeTraitExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UnaryOperator() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_VAArgExpr() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ForStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_GotoStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_IfStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_IndirectGotoStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_LabelStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MSDependentExistsStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_NullStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPAtomicDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPBarrierDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPCancelDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPCancellationPointDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPCriticalDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPFlushDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPDistributeDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPDistributeParallelForDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPDistributeParallelForSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPDistributeSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPForDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPForSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPParallelForDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPParallelForSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetParallelForSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTaskLoopDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTaskLoopSimdDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPMasterDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPOrderedDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPParallelDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPParallelSectionsDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPSectionDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPSectionsDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPSingleDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetDataDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetEnterDataDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetExitDataDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetParallelDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetParallelForDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTargetUpdateDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTaskDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTaskgroupDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTaskwaitDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTaskyieldDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPTeamsDirective() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAtCatchStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAtFinallyStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAtSynchronizedStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAtThrowStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAtTryStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAutoreleasePoolStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCForCollectionStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ReturnStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SEHExceptStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SEHFinallyStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SEHLeaveStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SEHTryStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CaseStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_DefaultStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_SwitchStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_WhileStmt() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_AccessSpecDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_BlockDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CapturedDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ClassScopeFunctionSpecializationDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_EmptyDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ExternCContextDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FileScopeAsmDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FriendDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FriendTemplateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ImportDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_LinkageSpecDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_LabelDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_NamespaceDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_NamespaceAliasDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCCompatibleAliasDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCCategoryDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCCategoryImplDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCImplementationDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCInterfaceDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCProtocolDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCMethodDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCPropertyDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_BuiltinTemplateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ClassTemplateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FunctionTemplateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TypeAliasTemplateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_VarTemplateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TemplateTemplateParmDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_EnumDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_RecordDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXRecordDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ClassTemplateSpecializationDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ClassTemplatePartialSpecializationDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TemplateTypeParmDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCTypeParamDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TypeAliasDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TypedefDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UnresolvedUsingTypenameDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UsingDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UsingDirectiveDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UsingShadowDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ConstructorUsingShadowDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FieldDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCAtDefsFieldDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCIvarDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_FunctionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXMethodDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXConstructorDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXConversionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_CXXDestructorDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_MSPropertyDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_NonTypeTemplateParmDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_VarDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ImplicitParamDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPCapturedExprDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ParmVarDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_VarTemplateSpecializationDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_VarTemplatePartialSpecializationDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_EnumConstantDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_IndirectFieldDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPDeclareReductionDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_UnresolvedUsingValueDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_OMPThreadPrivateDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_ObjCPropertyImplDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_PragmaCommentDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_PragmaDetectMismatchDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_StaticAssertDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }

  public static int $sizeof_TranslationUnitDecl() {
    throw new UnsupportedOperationException("EmptyBody");
  }
  
  public static int $sizeof_VarDeclBitfields() {
    NativeTrace.traceNotImplemented("$sizeof_VarDeclBitfields");
    return 1;
  }
  
  public static int $sizeof_ParmVarDeclBitfields() {
    NativeTrace.traceNotImplemented("$sizeof_ParmVarDeclBitfields");
    return 1;
  }
  
  public static int $sizeof_NonParmVarDeclBitfields() {
    NativeTrace.traceNotImplemented("$sizeof_NonParmVarDeclBitfields");
    return 1;
  }

  public static int $sizeof_LambdaCapture() {
    NativeTrace.traceNotImplemented("$sizeof_LambdaCapture");
    return 1;
  }
  
  public static int $sizeof_DeclAccessPair() {
    NativeTrace.traceNotImplemented("$sizeof_DeclAccessPair");
    return 1;
  }
  
  public static int $sizeof_Capture() {
    NativeTrace.traceNotImplemented("$sizeof_Capture");
    return 1;
  }
  
  public static int $sizeof_WrittenBuiltinSpecs() {
    NativeTrace.traceNotImplemented("$sizeof_WrittenBuiltinSpecs");
    return 1;
  }  
  
  public static int $sizeof_ObjCObjectTypeImpl() {
    NativeTrace.traceNotImplemented("$sizeof_ObjCObjectTypeImpl");
    return 1;
  }  
  
  public static int $sizeof_ObjCObjectPointerType() {
    NativeTrace.traceNotImplemented("$sizeof_ObjCObjectPointerType");
    return 1;
  }  
  
  public static int $sizeof_ObjCInterfaceType() {
    NativeTrace.traceNotImplemented("$sizeof_ObjCInterfaceType");
    return 1;
  }  
  
  public static int $sizeof_SmallVector$Attr$P() {
    throw new UnsupportedOperationException("EmptyBody");
  }  

  public static int $sizeof_BuiltinType() {
    NativeTrace.traceNotImplemented("$sizeof_BuiltinType");
    return 1;
  }
  public static int $sizeof_ComplexType() {
    NativeTrace.traceNotImplemented("$sizeof_ComplexType");
    return 1;
  }
  public static int $sizeof_PointerType() {
    NativeTrace.traceNotImplemented("$sizeof_PointerType");
    return 1;
  }
  public static int $sizeof_BlockPointerType() {
    NativeTrace.traceNotImplemented("$sizeof_BlockPointerType");
    return 1;
  }
  public static int $sizeof_LValueReferenceType() {
    NativeTrace.traceNotImplemented("$sizeof_LValueReferenceType");
    return 1;
  }
  public static int $sizeof_RValueReferenceType() {
    NativeTrace.traceNotImplemented("$sizeof_RValueReferenceType");
    return 1;
  }
  public static int $sizeof_MemberPointerType() {
    NativeTrace.traceNotImplemented("$sizeof_MemberPointerType");
    return 1;
  }
  public static int $sizeof_ConstantArrayType() {
    NativeTrace.traceNotImplemented("$sizeof_ConstantArrayType");
    return 1;
  }
  public static int $sizeof_IncompleteArrayType() {
    NativeTrace.traceNotImplemented("$sizeof_IncompleteArrayType");
    return 1;
  }
  public static int $sizeof_VariableArrayType() {
    NativeTrace.traceNotImplemented("$sizeof_VariableArrayType");
    return 1;
  }
  public static int $sizeof_DependentSizedArrayType() {
    NativeTrace.traceNotImplemented("$sizeof_DependentSizedArrayType");
    return 1;
  }
  public static int $sizeof_DependentSizedExtVectorType() {
    NativeTrace.traceNotImplemented("$sizeof_DependentSizedExtVectorType");
    return 1;
  }
  public static int $sizeof_VectorType() {
    NativeTrace.traceNotImplemented("$sizeof_VectorType");
    return 1;
  }
  public static int $sizeof_ExtVectorType() {
    NativeTrace.traceNotImplemented("$sizeof_ExtVectorType");
    return 1;
  }
  public static int $sizeof_FunctionProtoType() {
    NativeTrace.traceNotImplemented("$sizeof_FunctionProtoType");
    return 1;
  }
  public static int $sizeof_FunctionNoProtoType() {
    NativeTrace.traceNotImplemented("$sizeof_FunctionNoProtoType");
    return 1;
  }
  public static int $sizeof_UnresolvedUsingType() {
    NativeTrace.traceNotImplemented("$sizeof_UnresolvedUsingType");
    return 1;
  }
  public static int $sizeof_ParenType() {
    NativeTrace.traceNotImplemented("$sizeof_ParenType");
    return 1;
  }
  public static int $sizeof_TypedefType() {
    NativeTrace.traceNotImplemented("$sizeof_TypedefType");
    return 1;
  }
  public static int $sizeof_AdjustedType() {
    NativeTrace.traceNotImplemented("$sizeof_AdjustedType");
    return 1;
  }
  public static int $sizeof_DecayedType() {
    NativeTrace.traceNotImplemented("$sizeof_DecayedType");
    return 1;
  }
  public static int $sizeof_TypeOfExprType() {
    NativeTrace.traceNotImplemented("$sizeof_TypeOfExprType");
    return 1;
  }
  public static int $sizeof_TypeOfType() {
    NativeTrace.traceNotImplemented("$sizeof_TypeOfType");
    return 1;
  }
  public static int $sizeof_DecltypeType() {
    NativeTrace.traceNotImplemented("$sizeof_DecltypeType");
    return 1;
  }
  public static int $sizeof_UnaryTransformType() {
    NativeTrace.traceNotImplemented("$sizeof_UnaryTransformType");
    return 1;
  }
  public static int $sizeof_RecordType() {
    NativeTrace.traceNotImplemented("$sizeof_RecordType");
    return 1;
  }
  public static int $sizeof_EnumType() {
    NativeTrace.traceNotImplemented("$sizeof_EnumType");
    return 1;
  }
  public static int $sizeof_ElaboratedType() {
    NativeTrace.traceNotImplemented("$sizeof_ElaboratedType");
    return 1;
  }
  public static int $sizeof_AttributedType() {
    NativeTrace.traceNotImplemented("$sizeof_AttributedType");
    return 1;
  }
  public static int $sizeof_TemplateTypeParmType() {
    NativeTrace.traceNotImplemented("$sizeof_TemplateTypeParmType");
    return 1;
  }
  public static int $sizeof_SubstTemplateTypeParmType() {
    NativeTrace.traceNotImplemented("$sizeof_SubstTemplateTypeParmType");
    return 1;
  }
  public static int $sizeof_SubstTemplateTypeParmPackType() {
    NativeTrace.traceNotImplemented("$sizeof_SubstTemplateTypeParmPackType");
    return 1;
  }
  public static int $sizeof_TemplateSpecializationType() {
    NativeTrace.traceNotImplemented("$sizeof_TemplateSpecializationType");
    return 1;
  }
  public static int $sizeof_AutoType() {
    NativeTrace.traceNotImplemented("$sizeof_AutoType");
    return 1;
  }
  public static int $sizeof_InjectedClassNameType() {
    NativeTrace.traceNotImplemented("$sizeof_InjectedClassNameType");
    return 1;
  }
  public static int $sizeof_DependentNameType() {
    NativeTrace.traceNotImplemented("$sizeof_DependentNameType");
    return 1;
  }
  public static int $sizeof_DependentTemplateSpecializationType() {
    NativeTrace.traceNotImplemented("$sizeof_DependentTemplateSpecializationType");
    return 1;
  }
  public static int $sizeof_PackExpansionType() {
    NativeTrace.traceNotImplemented("$sizeof_PackExpansionType");
    return 1;
  }
  public static int $sizeof_ObjCObjectType() {
    NativeTrace.traceNotImplemented("$sizeof_ObjCObjectType");
    return 1;
  }
  public static int $sizeof_PipeType() {
    NativeTrace.traceNotImplemented("$sizeof_PipeType");
    return 1;
  }
  public static int $sizeof_AtomicType() {
    NativeTrace.traceNotImplemented("$sizeof_AtomicType");
    return 1;
  }
  public static int $sizeof_ExtParameterInfo() {
    NativeTrace.traceNotImplemented("$sizeof_ExtParameterInfo");
    return 1;
  }
  public static int $sizeof_TemplateArgument() {
    NativeTrace.traceNotImplemented("$sizeof_TemplateArgument");
    return 1;
  }
  public static int $sizeof_OverloadedTemplateStorage() {
    NativeTrace.traceNotImplemented("$sizeof_OverloadedTemplateStorage");
    return 1;
  }
}
