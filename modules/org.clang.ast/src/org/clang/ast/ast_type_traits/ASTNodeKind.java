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

package org.clang.ast.ast_type_traits;

import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.ast.*;
import org.clang.ast.ast_type_traits.*;
import static org.clang.ast.ast_type_traits.ASTNodeKind.*;
import org.clang.ast.java.AstKindToKindIdRegistry;


/// \brief Kind identifier.
///
/// It can be constructed from any node kind and allows for runtime type
/// hierarchy checks.
/// Use getFromNodeKind<T>() to construct them.
//<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 46,
 FQN="clang::ast_type_traits::ASTNodeKind", NM="_ZN5clang15ast_type_traits11ASTNodeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindE")
//</editor-fold>
public class ASTNodeKind implements NativePOD<ASTNodeKind> {
/*public:*/
  /// \brief Empty identifier. It matches nothing.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::ASTNodeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 49,
   FQN="clang::ast_type_traits::ASTNodeKind::ASTNodeKind", NM="_ZN5clang15ast_type_traits11ASTNodeKindC1Ev",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindC1Ev")
  //</editor-fold>
  public ASTNodeKind() {
    // : KindId(NKI_None) 
    //START JInit
    this.KindId = NodeKindId.NKI_None;
    //END JInit
  }

  
  /// \brief Construct an identifier for T.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::getFromNodeKind">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 53,
   FQN="clang::ast_type_traits::ASTNodeKind::getFromNodeKind", NM="Tpl__ZN5clang15ast_type_traits11ASTNodeKind15getFromNodeKindEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=Tpl__ZN5clang15ast_type_traits11ASTNodeKind15getFromNodeKindEv")
  //</editor-fold>
  public static </*class*/ T> ASTNodeKind getFromNodeKind(Class<T> clazz) {
    return getFromNodeKindImplByClass(clazz);
//    return ASTNodeKind(KindToKindId<T>.Id);
  }

  
  /// \{
  /// \brief Construct an identifier for the dynamic type of the node
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::getFromNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 77,
   FQN="clang::ast_type_traits::ASTNodeKind::getFromNode", NM="_ZN5clang15ast_type_traits11ASTNodeKind11getFromNodeERKNS_4DeclE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind11getFromNodeERKNS_4DeclE")
  //</editor-fold>
  public static ASTNodeKind getFromNode(final /*const*/ Decl /*&*/ D) {
    switch (D.getKind()) {
     case AccessSpec:
      return new ASTNodeKind(NodeKindId.NKI_AccessSpecDecl);
     case Block:
      return new ASTNodeKind(NodeKindId.NKI_BlockDecl);
     case Captured:
      return new ASTNodeKind(NodeKindId.NKI_CapturedDecl);
     case ClassScopeFunctionSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_ClassScopeFunctionSpecializationDecl);
     case Empty:
      return new ASTNodeKind(NodeKindId.NKI_EmptyDecl);
     case ExternCContext:
      return new ASTNodeKind(NodeKindId.NKI_ExternCContextDecl);
     case FileScopeAsm:
      return new ASTNodeKind(NodeKindId.NKI_FileScopeAsmDecl);
     case Friend:
      return new ASTNodeKind(NodeKindId.NKI_FriendDecl);
     case FriendTemplate:
      return new ASTNodeKind(NodeKindId.NKI_FriendTemplateDecl);
     case Import:
      return new ASTNodeKind(NodeKindId.NKI_ImportDecl);
     case LinkageSpec:
      return new ASTNodeKind(NodeKindId.NKI_LinkageSpecDecl);
     case Label:
      return new ASTNodeKind(NodeKindId.NKI_LabelDecl);
     case Namespace:
      return new ASTNodeKind(NodeKindId.NKI_NamespaceDecl);
     case NamespaceAlias:
      return new ASTNodeKind(NodeKindId.NKI_NamespaceAliasDecl);
     case ObjCCompatibleAlias:
      return new ASTNodeKind(NodeKindId.NKI_ObjCCompatibleAliasDecl);
     case ObjCCategory:
      return new ASTNodeKind(NodeKindId.NKI_ObjCCategoryDecl);
     case ObjCCategoryImpl:
      return new ASTNodeKind(NodeKindId.NKI_ObjCCategoryImplDecl);
     case ObjCImplementation:
      return new ASTNodeKind(NodeKindId.NKI_ObjCImplementationDecl);
     case ObjCInterface:
      return new ASTNodeKind(NodeKindId.NKI_ObjCInterfaceDecl);
     case ObjCProtocol:
      return new ASTNodeKind(NodeKindId.NKI_ObjCProtocolDecl);
     case ObjCMethod:
      return new ASTNodeKind(NodeKindId.NKI_ObjCMethodDecl);
     case ObjCProperty:
      return new ASTNodeKind(NodeKindId.NKI_ObjCPropertyDecl);
     case BuiltinTemplate:
      return new ASTNodeKind(NodeKindId.NKI_BuiltinTemplateDecl);
     case ClassTemplate:
      return new ASTNodeKind(NodeKindId.NKI_ClassTemplateDecl);
     case FunctionTemplate:
      return new ASTNodeKind(NodeKindId.NKI_FunctionTemplateDecl);
     case TypeAliasTemplate:
      return new ASTNodeKind(NodeKindId.NKI_TypeAliasTemplateDecl);
     case VarTemplate:
      return new ASTNodeKind(NodeKindId.NKI_VarTemplateDecl);
     case TemplateTemplateParm:
      return new ASTNodeKind(NodeKindId.NKI_TemplateTemplateParmDecl);
     case Enum:
      return new ASTNodeKind(NodeKindId.NKI_EnumDecl);
     case Record:
      return new ASTNodeKind(NodeKindId.NKI_RecordDecl);
     case CXXRecord:
      return new ASTNodeKind(NodeKindId.NKI_CXXRecordDecl);
     case ClassTemplateSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_ClassTemplateSpecializationDecl);
     case ClassTemplatePartialSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_ClassTemplatePartialSpecializationDecl);
     case TemplateTypeParm:
      return new ASTNodeKind(NodeKindId.NKI_TemplateTypeParmDecl);
     case ObjCTypeParam:
      return new ASTNodeKind(NodeKindId.NKI_ObjCTypeParamDecl);
     case TypeAlias:
      return new ASTNodeKind(NodeKindId.NKI_TypeAliasDecl);
     case Typedef:
      return new ASTNodeKind(NodeKindId.NKI_TypedefDecl);
     case UnresolvedUsingTypename:
      return new ASTNodeKind(NodeKindId.NKI_UnresolvedUsingTypenameDecl);
     case Using:
      return new ASTNodeKind(NodeKindId.NKI_UsingDecl);
     case UsingDirective:
      return new ASTNodeKind(NodeKindId.NKI_UsingDirectiveDecl);
     case UsingShadow:
      return new ASTNodeKind(NodeKindId.NKI_UsingShadowDecl);
     case ConstructorUsingShadow:
      return new ASTNodeKind(NodeKindId.NKI_ConstructorUsingShadowDecl);
     case Field:
      return new ASTNodeKind(NodeKindId.NKI_FieldDecl);
     case ObjCAtDefsField:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAtDefsFieldDecl);
     case ObjCIvar:
      return new ASTNodeKind(NodeKindId.NKI_ObjCIvarDecl);
     case Function:
      return new ASTNodeKind(NodeKindId.NKI_FunctionDecl);
     case CXXMethod:
      return new ASTNodeKind(NodeKindId.NKI_CXXMethodDecl);
     case CXXConstructor:
      return new ASTNodeKind(NodeKindId.NKI_CXXConstructorDecl);
     case CXXConversion:
      return new ASTNodeKind(NodeKindId.NKI_CXXConversionDecl);
     case CXXDestructor:
      return new ASTNodeKind(NodeKindId.NKI_CXXDestructorDecl);
     case MSProperty:
      return new ASTNodeKind(NodeKindId.NKI_MSPropertyDecl);
     case NonTypeTemplateParm:
      return new ASTNodeKind(NodeKindId.NKI_NonTypeTemplateParmDecl);
     case Var:
      return new ASTNodeKind(NodeKindId.NKI_VarDecl);
     case ImplicitParam:
      return new ASTNodeKind(NodeKindId.NKI_ImplicitParamDecl);
     case OMPCapturedExpr:
      return new ASTNodeKind(NodeKindId.NKI_OMPCapturedExprDecl);
     case ParmVar:
      return new ASTNodeKind(NodeKindId.NKI_ParmVarDecl);
     case VarTemplateSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_VarTemplateSpecializationDecl);
     case VarTemplatePartialSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_VarTemplatePartialSpecializationDecl);
     case EnumConstant:
      return new ASTNodeKind(NodeKindId.NKI_EnumConstantDecl);
     case IndirectField:
      return new ASTNodeKind(NodeKindId.NKI_IndirectFieldDecl);
     case OMPDeclareReduction:
      return new ASTNodeKind(NodeKindId.NKI_OMPDeclareReductionDecl);
     case UnresolvedUsingValue:
      return new ASTNodeKind(NodeKindId.NKI_UnresolvedUsingValueDecl);
     case OMPThreadPrivate:
      return new ASTNodeKind(NodeKindId.NKI_OMPThreadPrivateDecl);
     case ObjCPropertyImpl:
      return new ASTNodeKind(NodeKindId.NKI_ObjCPropertyImplDecl);
     case PragmaComment:
      return new ASTNodeKind(NodeKindId.NKI_PragmaCommentDecl);
     case PragmaDetectMismatch:
      return new ASTNodeKind(NodeKindId.NKI_PragmaDetectMismatchDecl);
     case StaticAssert:
      return new ASTNodeKind(NodeKindId.NKI_StaticAssertDecl);
     case TranslationUnit:
      return new ASTNodeKind(NodeKindId.NKI_TranslationUnitDecl);
    }
    /*JSKIP;*/
    throw new llvm_unreachable("invalid decl kind");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::getFromNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 87,
   FQN="clang::ast_type_traits::ASTNodeKind::getFromNode", NM="_ZN5clang15ast_type_traits11ASTNodeKind11getFromNodeERKNS_4StmtE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind11getFromNodeERKNS_4StmtE")
  //</editor-fold>
  public static ASTNodeKind getFromNode(final /*const*/ Stmt /*&*/ S) {
    switch (S.getStmtClass()) {
     case NoStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_None);
     case GCCAsmStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_GCCAsmStmt);
     case MSAsmStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_MSAsmStmt);
     case AttributedStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_AttributedStmt);
     case BreakStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_BreakStmt);
     case CXXCatchStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXCatchStmt);
     case CXXForRangeStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXForRangeStmt);
     case CXXTryStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXTryStmt);
     case CapturedStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CapturedStmt);
     case CompoundStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CompoundStmt);
     case ContinueStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ContinueStmt);
     case CoreturnStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CoreturnStmt);
     case CoroutineBodyStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CoroutineBodyStmt);
     case DeclStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_DeclStmt);
     case DoStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_DoStmt);
     case BinaryConditionalOperatorClass:
      return new ASTNodeKind(NodeKindId.NKI_BinaryConditionalOperator);
     case ConditionalOperatorClass:
      return new ASTNodeKind(NodeKindId.NKI_ConditionalOperator);
     case AddrLabelExprClass:
      return new ASTNodeKind(NodeKindId.NKI_AddrLabelExpr);
     case ArraySubscriptExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ArraySubscriptExpr);
     case ArrayTypeTraitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ArrayTypeTraitExpr);
     case AsTypeExprClass:
      return new ASTNodeKind(NodeKindId.NKI_AsTypeExpr);
     case AtomicExprClass:
      return new ASTNodeKind(NodeKindId.NKI_AtomicExpr);
     case BinaryOperatorClass:
      return new ASTNodeKind(NodeKindId.NKI_BinaryOperator);
     case CompoundAssignOperatorClass:
      return new ASTNodeKind(NodeKindId.NKI_CompoundAssignOperator);
     case BlockExprClass:
      return new ASTNodeKind(NodeKindId.NKI_BlockExpr);
     case CXXBindTemporaryExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXBindTemporaryExpr);
     case CXXBoolLiteralExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXBoolLiteralExpr);
     case CXXConstructExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXConstructExpr);
     case CXXTemporaryObjectExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXTemporaryObjectExpr);
     case CXXDefaultArgExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXDefaultArgExpr);
     case CXXDefaultInitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXDefaultInitExpr);
     case CXXDeleteExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXDeleteExpr);
     case CXXDependentScopeMemberExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXDependentScopeMemberExpr);
     case CXXFoldExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXFoldExpr);
     case CXXInheritedCtorInitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXInheritedCtorInitExpr);
     case CXXNewExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXNewExpr);
     case CXXNoexceptExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXNoexceptExpr);
     case CXXNullPtrLiteralExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXNullPtrLiteralExpr);
     case CXXPseudoDestructorExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXPseudoDestructorExpr);
     case CXXScalarValueInitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXScalarValueInitExpr);
     case CXXStdInitializerListExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXStdInitializerListExpr);
     case CXXThisExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXThisExpr);
     case CXXThrowExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXThrowExpr);
     case CXXTypeidExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXTypeidExpr);
     case CXXUnresolvedConstructExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXUnresolvedConstructExpr);
     case CXXUuidofExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXUuidofExpr);
     case CallExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CallExpr);
     case CUDAKernelCallExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CUDAKernelCallExpr);
     case CXXMemberCallExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXMemberCallExpr);
     case CXXOperatorCallExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXOperatorCallExpr);
     case UserDefinedLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_UserDefinedLiteral);
     case CStyleCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CStyleCastExpr);
     case CXXFunctionalCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXFunctionalCastExpr);
     case CXXConstCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXConstCastExpr);
     case CXXDynamicCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXDynamicCastExpr);
     case CXXReinterpretCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXReinterpretCastExpr);
     case CXXStaticCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CXXStaticCastExpr);
     case ObjCBridgedCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCBridgedCastExpr);
     case ImplicitCastExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ImplicitCastExpr);
     case CharacterLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_CharacterLiteral);
     case ChooseExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ChooseExpr);
     case CompoundLiteralExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CompoundLiteralExpr);
     case ConvertVectorExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ConvertVectorExpr);
     case CoawaitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CoawaitExpr);
     case CoyieldExprClass:
      return new ASTNodeKind(NodeKindId.NKI_CoyieldExpr);
     case DeclRefExprClass:
      return new ASTNodeKind(NodeKindId.NKI_DeclRefExpr);
     case DependentScopeDeclRefExprClass:
      return new ASTNodeKind(NodeKindId.NKI_DependentScopeDeclRefExpr);
     case DesignatedInitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_DesignatedInitExpr);
     case DesignatedInitUpdateExprClass:
      return new ASTNodeKind(NodeKindId.NKI_DesignatedInitUpdateExpr);
     case ExprWithCleanupsClass:
      return new ASTNodeKind(NodeKindId.NKI_ExprWithCleanups);
     case ExpressionTraitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ExpressionTraitExpr);
     case ExtVectorElementExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ExtVectorElementExpr);
     case FloatingLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_FloatingLiteral);
     case FunctionParmPackExprClass:
      return new ASTNodeKind(NodeKindId.NKI_FunctionParmPackExpr);
     case GNUNullExprClass:
      return new ASTNodeKind(NodeKindId.NKI_GNUNullExpr);
     case GenericSelectionExprClass:
      return new ASTNodeKind(NodeKindId.NKI_GenericSelectionExpr);
     case ImaginaryLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_ImaginaryLiteral);
     case ImplicitValueInitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ImplicitValueInitExpr);
     case InitListExprClass:
      return new ASTNodeKind(NodeKindId.NKI_InitListExpr);
     case IntegerLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_IntegerLiteral);
     case LambdaExprClass:
      return new ASTNodeKind(NodeKindId.NKI_LambdaExpr);
     case MSPropertyRefExprClass:
      return new ASTNodeKind(NodeKindId.NKI_MSPropertyRefExpr);
     case MSPropertySubscriptExprClass:
      return new ASTNodeKind(NodeKindId.NKI_MSPropertySubscriptExpr);
     case MaterializeTemporaryExprClass:
      return new ASTNodeKind(NodeKindId.NKI_MaterializeTemporaryExpr);
     case MemberExprClass:
      return new ASTNodeKind(NodeKindId.NKI_MemberExpr);
     case NoInitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_NoInitExpr);
     case OMPArraySectionExprClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPArraySectionExpr);
     case ObjCArrayLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCArrayLiteral);
     case ObjCAvailabilityCheckExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAvailabilityCheckExpr);
     case ObjCBoolLiteralExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCBoolLiteralExpr);
     case ObjCBoxedExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCBoxedExpr);
     case ObjCDictionaryLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCDictionaryLiteral);
     case ObjCEncodeExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCEncodeExpr);
     case ObjCIndirectCopyRestoreExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCIndirectCopyRestoreExpr);
     case ObjCIsaExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCIsaExpr);
     case ObjCIvarRefExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCIvarRefExpr);
     case ObjCMessageExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCMessageExpr);
     case ObjCPropertyRefExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCPropertyRefExpr);
     case ObjCProtocolExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCProtocolExpr);
     case ObjCSelectorExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCSelectorExpr);
     case ObjCStringLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCStringLiteral);
     case ObjCSubscriptRefExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCSubscriptRefExpr);
     case OffsetOfExprClass:
      return new ASTNodeKind(NodeKindId.NKI_OffsetOfExpr);
     case OpaqueValueExprClass:
      return new ASTNodeKind(NodeKindId.NKI_OpaqueValueExpr);
     case UnresolvedLookupExprClass:
      return new ASTNodeKind(NodeKindId.NKI_UnresolvedLookupExpr);
     case UnresolvedMemberExprClass:
      return new ASTNodeKind(NodeKindId.NKI_UnresolvedMemberExpr);
     case PackExpansionExprClass:
      return new ASTNodeKind(NodeKindId.NKI_PackExpansionExpr);
     case ParenExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ParenExpr);
     case ParenListExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ParenListExpr);
     case PredefinedExprClass:
      return new ASTNodeKind(NodeKindId.NKI_PredefinedExpr);
     case PseudoObjectExprClass:
      return new ASTNodeKind(NodeKindId.NKI_PseudoObjectExpr);
     case ShuffleVectorExprClass:
      return new ASTNodeKind(NodeKindId.NKI_ShuffleVectorExpr);
     case SizeOfPackExprClass:
      return new ASTNodeKind(NodeKindId.NKI_SizeOfPackExpr);
     case StmtExprClass:
      return new ASTNodeKind(NodeKindId.NKI_StmtExpr);
     case StringLiteralClass:
      return new ASTNodeKind(NodeKindId.NKI_StringLiteral);
     case SubstNonTypeTemplateParmExprClass:
      return new ASTNodeKind(NodeKindId.NKI_SubstNonTypeTemplateParmExpr);
     case SubstNonTypeTemplateParmPackExprClass:
      return new ASTNodeKind(NodeKindId.NKI_SubstNonTypeTemplateParmPackExpr);
     case TypeTraitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_TypeTraitExpr);
     case TypoExprClass:
      return new ASTNodeKind(NodeKindId.NKI_TypoExpr);
     case UnaryExprOrTypeTraitExprClass:
      return new ASTNodeKind(NodeKindId.NKI_UnaryExprOrTypeTraitExpr);
     case UnaryOperatorClass:
      return new ASTNodeKind(NodeKindId.NKI_UnaryOperator);
     case VAArgExprClass:
      return new ASTNodeKind(NodeKindId.NKI_VAArgExpr);
     case ForStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ForStmt);
     case GotoStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_GotoStmt);
     case IfStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_IfStmt);
     case IndirectGotoStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_IndirectGotoStmt);
     case LabelStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_LabelStmt);
     case MSDependentExistsStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_MSDependentExistsStmt);
     case NullStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_NullStmt);
     case OMPAtomicDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPAtomicDirective);
     case OMPBarrierDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPBarrierDirective);
     case OMPCancelDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPCancelDirective);
     case OMPCancellationPointDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPCancellationPointDirective);
     case OMPCriticalDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPCriticalDirective);
     case OMPFlushDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPFlushDirective);
     case OMPDistributeDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPDistributeDirective);
     case OMPDistributeParallelForDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPDistributeParallelForDirective);
     case OMPDistributeParallelForSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPDistributeParallelForSimdDirective);
     case OMPDistributeSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPDistributeSimdDirective);
     case OMPForDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPForDirective);
     case OMPForSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPForSimdDirective);
     case OMPParallelForDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPParallelForDirective);
     case OMPParallelForSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPParallelForSimdDirective);
     case OMPSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPSimdDirective);
     case OMPTargetParallelForSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetParallelForSimdDirective);
     case OMPTaskLoopDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTaskLoopDirective);
     case OMPTaskLoopSimdDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTaskLoopSimdDirective);
     case OMPMasterDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPMasterDirective);
     case OMPOrderedDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPOrderedDirective);
     case OMPParallelDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPParallelDirective);
     case OMPParallelSectionsDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPParallelSectionsDirective);
     case OMPSectionDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPSectionDirective);
     case OMPSectionsDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPSectionsDirective);
     case OMPSingleDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPSingleDirective);
     case OMPTargetDataDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetDataDirective);
     case OMPTargetDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetDirective);
     case OMPTargetEnterDataDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetEnterDataDirective);
     case OMPTargetExitDataDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetExitDataDirective);
     case OMPTargetParallelDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetParallelDirective);
     case OMPTargetParallelForDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetParallelForDirective);
     case OMPTargetUpdateDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTargetUpdateDirective);
     case OMPTaskDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTaskDirective);
     case OMPTaskgroupDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTaskgroupDirective);
     case OMPTaskwaitDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTaskwaitDirective);
     case OMPTaskyieldDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTaskyieldDirective);
     case OMPTeamsDirectiveClass:
      return new ASTNodeKind(NodeKindId.NKI_OMPTeamsDirective);
     case ObjCAtCatchStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAtCatchStmt);
     case ObjCAtFinallyStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAtFinallyStmt);
     case ObjCAtSynchronizedStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAtSynchronizedStmt);
     case ObjCAtThrowStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAtThrowStmt);
     case ObjCAtTryStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAtTryStmt);
     case ObjCAutoreleasePoolStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCAutoreleasePoolStmt);
     case ObjCForCollectionStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ObjCForCollectionStmt);
     case ReturnStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_ReturnStmt);
     case SEHExceptStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_SEHExceptStmt);
     case SEHFinallyStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_SEHFinallyStmt);
     case SEHLeaveStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_SEHLeaveStmt);
     case SEHTryStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_SEHTryStmt);
     case CaseStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_CaseStmt);
     case DefaultStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_DefaultStmt);
     case SwitchStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_SwitchStmt);
     case WhileStmtClass:
      return new ASTNodeKind(NodeKindId.NKI_WhileStmt);
    }
    throw new llvm_unreachable("invalid stmt kind");
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::getFromNode">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 98,
   FQN="clang::ast_type_traits::ASTNodeKind::getFromNode", NM="_ZN5clang15ast_type_traits11ASTNodeKind11getFromNodeERKNS_4TypeE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind11getFromNodeERKNS_4TypeE")
  //</editor-fold>
  public static ASTNodeKind getFromNode(final /*const*/ Type /*&*/ T) {
    switch (T.getTypeClass()) {
     case Builtin:
      return new ASTNodeKind(NodeKindId.NKI_BuiltinType);
     case Complex:
      return new ASTNodeKind(NodeKindId.NKI_ComplexType);
     case Pointer:
      return new ASTNodeKind(NodeKindId.NKI_PointerType);
     case BlockPointer:
      return new ASTNodeKind(NodeKindId.NKI_BlockPointerType);
     case LValueReference:
      return new ASTNodeKind(NodeKindId.NKI_LValueReferenceType);
     case RValueReference:
      return new ASTNodeKind(NodeKindId.NKI_RValueReferenceType);
     case MemberPointer:
      return new ASTNodeKind(NodeKindId.NKI_MemberPointerType);
     case ConstantArray:
      return new ASTNodeKind(NodeKindId.NKI_ConstantArrayType);
     case IncompleteArray:
      return new ASTNodeKind(NodeKindId.NKI_IncompleteArrayType);
     case VariableArray:
      return new ASTNodeKind(NodeKindId.NKI_VariableArrayType);
     case DependentSizedArray:
      return new ASTNodeKind(NodeKindId.NKI_DependentSizedArrayType);
     case DependentSizedExtVector:
      return new ASTNodeKind(NodeKindId.NKI_DependentSizedExtVectorType);
     case Vector:
      return new ASTNodeKind(NodeKindId.NKI_VectorType);
     case ExtVector:
      return new ASTNodeKind(NodeKindId.NKI_ExtVectorType);
     case FunctionProto:
      return new ASTNodeKind(NodeKindId.NKI_FunctionProtoType);
     case FunctionNoProto:
      return new ASTNodeKind(NodeKindId.NKI_FunctionNoProtoType);
     case UnresolvedUsing:
      return new ASTNodeKind(NodeKindId.NKI_UnresolvedUsingType);
     case Paren:
      return new ASTNodeKind(NodeKindId.NKI_ParenType);
     case Typedef:
      return new ASTNodeKind(NodeKindId.NKI_TypedefType);
     case Adjusted:
      return new ASTNodeKind(NodeKindId.NKI_AdjustedType);
     case Decayed:
      return new ASTNodeKind(NodeKindId.NKI_DecayedType);
     case TypeOfExpr:
      return new ASTNodeKind(NodeKindId.NKI_TypeOfExprType);
     case TypeOf:
      return new ASTNodeKind(NodeKindId.NKI_TypeOfType);
     case Decltype:
      return new ASTNodeKind(NodeKindId.NKI_DecltypeType);
     case UnaryTransform:
      return new ASTNodeKind(NodeKindId.NKI_UnaryTransformType);
     case Record:
      return new ASTNodeKind(NodeKindId.NKI_RecordType);
     case Enum:
      return new ASTNodeKind(NodeKindId.NKI_EnumType);
     case Elaborated:
      return new ASTNodeKind(NodeKindId.NKI_ElaboratedType);
     case Attributed:
      return new ASTNodeKind(NodeKindId.NKI_AttributedType);
     case TemplateTypeParm:
      return new ASTNodeKind(NodeKindId.NKI_TemplateTypeParmType);
     case SubstTemplateTypeParm:
      return new ASTNodeKind(NodeKindId.NKI_SubstTemplateTypeParmType);
     case SubstTemplateTypeParmPack:
      return new ASTNodeKind(NodeKindId.NKI_SubstTemplateTypeParmPackType);
     case TemplateSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_TemplateSpecializationType);
     case Auto:
      return new ASTNodeKind(NodeKindId.NKI_AutoType);
     case InjectedClassName:
      return new ASTNodeKind(NodeKindId.NKI_InjectedClassNameType);
     case DependentName:
      return new ASTNodeKind(NodeKindId.NKI_DependentNameType);
     case DependentTemplateSpecialization:
      return new ASTNodeKind(NodeKindId.NKI_DependentTemplateSpecializationType);
     case PackExpansion:
      return new ASTNodeKind(NodeKindId.NKI_PackExpansionType);
     case ObjCObject:
      return new ASTNodeKind(NodeKindId.NKI_ObjCObjectType);
     case ObjCInterface:
      return new ASTNodeKind(NodeKindId.NKI_ObjCInterfaceType);
     case ObjCObjectPointer:
      return new ASTNodeKind(NodeKindId.NKI_ObjCObjectPointerType);
     case Pipe:
      return new ASTNodeKind(NodeKindId.NKI_PipeType);
     case Atomic:
      return new ASTNodeKind(NodeKindId.NKI_AtomicType);
    }
    throw new llvm_unreachable("invalid type kind");
  }

  /// \}
  
  /// \brief Returns \c true if \c this and \c Other represent the same kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::isSame">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 65,
   FQN="clang::ast_type_traits::ASTNodeKind::isSame", NM="_ZNK5clang15ast_type_traits11ASTNodeKind6isSameES1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits11ASTNodeKind6isSameES1_")
  //</editor-fold>
  public boolean isSame(ASTNodeKind Other) /*const*/ {
    return KindId != NodeKindId.NKI_None && KindId == Other.KindId;
  }

  
  /// \brief Returns \c true only for the default \c ASTNodeKind()
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::isNone">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 70,
   FQN="clang::ast_type_traits::ASTNodeKind::isNone", NM="_ZNK5clang15ast_type_traits11ASTNodeKind6isNoneEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits11ASTNodeKind6isNoneEv")
  //</editor-fold>
  public boolean isNone() /*const*/ {
    return KindId == NodeKindId.NKI_None;
  }

  
  /// \brief Returns \c true if \c this is a base kind of (or same as) \c Other.
  /// \param Distance If non-null, used to return the distance between \c this
  /// and \c Other in the class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::isBaseOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 42,
   FQN="clang::ast_type_traits::ASTNodeKind::isBaseOf", NM="_ZNK5clang15ast_type_traits11ASTNodeKind8isBaseOfES1_Pj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits11ASTNodeKind8isBaseOfES1_Pj")
  //</editor-fold>
  public boolean isBaseOf(ASTNodeKind Other) /*const*/ {
    return isBaseOf(Other, (uint$ptr/*uint P*/ )null);
  }
  public boolean isBaseOf(ASTNodeKind Other, uint$ptr/*uint P*/ Distance/*= null*/) /*const*/ {
    return isBaseOf(KindId, Other.KindId, Distance);
  }

  
  /// \brief String representation of the kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::asStringRef">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 59,
   FQN="clang::ast_type_traits::ASTNodeKind::asStringRef", NM="_ZNK5clang15ast_type_traits11ASTNodeKind11asStringRefEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits11ASTNodeKind11asStringRefEv")
  //</editor-fold>
  public StringRef asStringRef() /*const*/ {
    return new StringRef(AllKindInfo[KindId.getValue()].Name);
  }

  
  /// \brief Strict weak ordering for ASTNodeKind.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::operator<">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 81,
   FQN="clang::ast_type_traits::ASTNodeKind::operator<", NM="_ZNK5clang15ast_type_traits11ASTNodeKindltERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits11ASTNodeKindltERKS1_")
  //</editor-fold>
  public boolean $less(final /*const*/ ASTNodeKind /*&*/ Other) /*const*/ {
    return KindId.getValue() < Other.KindId.getValue();
  }

  
  /// \brief Return the most derived type between \p Kind1 and \p Kind2.
  ///
  /// Return ASTNodeKind() if they are not related.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::getMostDerivedType">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 61,
   FQN="clang::ast_type_traits::ASTNodeKind::getMostDerivedType", NM="_ZN5clang15ast_type_traits11ASTNodeKind18getMostDerivedTypeES1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind18getMostDerivedTypeES1_S1_")
  //</editor-fold>
  public static ASTNodeKind getMostDerivedType(ASTNodeKind Kind1, 
                    ASTNodeKind Kind2) {
    if (Kind1.isBaseOf(new ASTNodeKind(Kind2))) {
      return new ASTNodeKind(JD$Move.INSTANCE, Kind2);
    }
    if (Kind2.isBaseOf(new ASTNodeKind(Kind1))) {
      return new ASTNodeKind(JD$Move.INSTANCE, Kind1);
    }
    return new ASTNodeKind();
  }

  
  /// \brief Return the most derived common ancestor between Kind1 and Kind2.
  ///
  /// Return ASTNodeKind() if they are not related.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::getMostDerivedCommonAncestor">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 68,
   FQN="clang::ast_type_traits::ASTNodeKind::getMostDerivedCommonAncestor", NM="_ZN5clang15ast_type_traits11ASTNodeKind28getMostDerivedCommonAncestorES1_S1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind28getMostDerivedCommonAncestorES1_S1_")
  //</editor-fold>
  public static ASTNodeKind getMostDerivedCommonAncestor(ASTNodeKind Kind1, 
                              ASTNodeKind Kind2) {
    NodeKindId Parent = Kind1.KindId;
    while (!isBaseOf(Parent, Kind2.KindId, (uint$ptr/*uint P*/ )null) && Parent != NodeKindId.NKI_None) {
      Parent = AllKindInfo[Parent.getValue()].ParentId;
    }
    return new ASTNodeKind(Parent);
  }

  
  /// \brief Hooks for using ASTNodeKind as a key in a DenseMap.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::DenseMapInfo">
  @Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*implement adt.DenseMapInfo*/ ,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 97,
   FQN="clang::ast_type_traits::ASTNodeKind::DenseMapInfo", NM="_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfoE")
  //</editor-fold>
  public static class/*struct*/ DenseMapInfo implements org.llvm.adt.DenseMapInfo<ASTNodeKind> {
    private static final DenseMapInfo $INFO = new DenseMapInfo();
    public static DenseMapInfo $Info() { return $INFO; }
    private static final ASTNodeKind emptyKey = new ASTNodeKind();
    private static final ASTNodeKind tombstoneKey = new ASTNodeKind(NodeKindId.NKI_NumberOfKinds);
    
    // ASTNodeKind() is a good empty key because it is represented as a 0.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::getEmptyKey">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 99,
     FQN="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::getEmptyKey", NM="_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo11getEmptyKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo11getEmptyKeyEv")
    //</editor-fold>
    public /*inline*/ ASTNodeKind getEmptyKey() {
      return emptyKey;
    }

    // NKI_NumberOfKinds is not a valid value, so it is good for a
    // tombstone key.
    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::getTombstoneKey">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 102,
     FQN="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::getTombstoneKey", NM="_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo15getTombstoneKeyEv",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo15getTombstoneKeyEv")
    //</editor-fold>
    public /*inline*/ ASTNodeKind getTombstoneKey() {
      return tombstoneKey;
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::getHashValue">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 105,
     FQN="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::getHashValue", NM="_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo12getHashValueERKS1_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo12getHashValueERKS1_")
    //</editor-fold>
    public /*uint*/int getHashValue(final /*const*/ ASTNodeKind /*&*/ Val) {
      assert Val != emptyKey : "must not be called for emptyKey";
      assert Val != tombstoneKey : "must not be called for tombstoneKey";          
      return Val.KindId.getValue();
    }

    //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::isEqual">
    @Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
     source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 106,
     FQN="clang::ast_type_traits::ASTNodeKind::DenseMapInfo::isEqual", NM="_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo7isEqualERKS1_S4_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12DenseMapInfo7isEqualERKS1_S4_")
    //</editor-fold>
    public boolean isEqual(final /*const*/ ASTNodeKind /*&*/ LHS, final /*const*/ ASTNodeKind /*&*/ RHS) {
      assert LHS != emptyKey : "LHS: must not be called for emptyKey";
      assert LHS != tombstoneKey : "LHS: must not be called for tombstoneKey";    
      assert RHS != emptyKey : "RHS: must not be called for emptyKey";
      assert RHS != tombstoneKey : "RHS: must not be called for tombstoneKey";           
      return LHS.KindId == RHS.KindId;
    }

    @Override
    public boolean isKeyPointerLike() {
      return false;
    }
  
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  
  /// Check if the given ASTNodeKind identifies a type that offers pointer
  /// identity. This is useful for the fast path in DynTypedNode.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::hasPointerIdentity">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 113,
   FQN="clang::ast_type_traits::ASTNodeKind::hasPointerIdentity", NM="_ZNK5clang15ast_type_traits11ASTNodeKind18hasPointerIdentityEv",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZNK5clang15ast_type_traits11ASTNodeKind18hasPointerIdentityEv")
  //</editor-fold>
  public boolean hasPointerIdentity() /*const*/ {
    return KindId.getValue() > NodeKindId.NKI_LastKindWithoutPointerIdentity.getValue();
  }

/*private:*/
  /// \brief Kind ids.
  ///
  /// Includes all possible base and derived kinds.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::NodeKindId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 121,
   FQN="clang::ast_type_traits::ASTNodeKind::NodeKindId", NM="_ZN5clang15ast_type_traits11ASTNodeKind10NodeKindIdE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind10NodeKindIdE")
  //</editor-fold>
  /*friend*/public/*private*/ enum NodeKindId implements Native.ComparableLower {
    NKI_None(0),
    NKI_TemplateArgument(NKI_None.getValue() + 1),
    NKI_NestedNameSpecifierLoc(NKI_TemplateArgument.getValue() + 1),
    NKI_QualType(NKI_NestedNameSpecifierLoc.getValue() + 1),
    NKI_TypeLoc(NKI_QualType.getValue() + 1),
    NKI_LastKindWithoutPointerIdentity(NodeKindId.NKI_TypeLoc.getValue()),
    NKI_CXXCtorInitializer(NKI_LastKindWithoutPointerIdentity.getValue() + 1),
    NKI_NestedNameSpecifier(NKI_CXXCtorInitializer.getValue() + 1),
    NKI_Decl(NKI_NestedNameSpecifier.getValue() + 1),
    NKI_AccessSpecDecl(NKI_Decl.getValue() + 1),
    NKI_BlockDecl(NKI_AccessSpecDecl.getValue() + 1),
    NKI_CapturedDecl(NKI_BlockDecl.getValue() + 1),
    NKI_ClassScopeFunctionSpecializationDecl(NKI_CapturedDecl.getValue() + 1),
    NKI_EmptyDecl(NKI_ClassScopeFunctionSpecializationDecl.getValue() + 1),
    NKI_ExternCContextDecl(NKI_EmptyDecl.getValue() + 1),
    NKI_FileScopeAsmDecl(NKI_ExternCContextDecl.getValue() + 1),
    NKI_FriendDecl(NKI_FileScopeAsmDecl.getValue() + 1),
    NKI_FriendTemplateDecl(NKI_FriendDecl.getValue() + 1),
    NKI_ImportDecl(NKI_FriendTemplateDecl.getValue() + 1),
    NKI_LinkageSpecDecl(NKI_ImportDecl.getValue() + 1),
    NKI_NamedDecl(NKI_LinkageSpecDecl.getValue() + 1),
    NKI_LabelDecl(NKI_NamedDecl.getValue() + 1),
    NKI_NamespaceDecl(NKI_LabelDecl.getValue() + 1),
    NKI_NamespaceAliasDecl(NKI_NamespaceDecl.getValue() + 1),
    NKI_ObjCCompatibleAliasDecl(NKI_NamespaceAliasDecl.getValue() + 1),
    NKI_ObjCContainerDecl(NKI_ObjCCompatibleAliasDecl.getValue() + 1),
    NKI_ObjCCategoryDecl(NKI_ObjCContainerDecl.getValue() + 1),
    NKI_ObjCImplDecl(NKI_ObjCCategoryDecl.getValue() + 1),
    NKI_ObjCCategoryImplDecl(NKI_ObjCImplDecl.getValue() + 1),
    NKI_ObjCImplementationDecl(NKI_ObjCCategoryImplDecl.getValue() + 1),
    NKI_ObjCInterfaceDecl(NKI_ObjCImplementationDecl.getValue() + 1),
    NKI_ObjCProtocolDecl(NKI_ObjCInterfaceDecl.getValue() + 1),
    NKI_ObjCMethodDecl(NKI_ObjCProtocolDecl.getValue() + 1),
    NKI_ObjCPropertyDecl(NKI_ObjCMethodDecl.getValue() + 1),
    NKI_TemplateDecl(NKI_ObjCPropertyDecl.getValue() + 1),
    NKI_BuiltinTemplateDecl(NKI_TemplateDecl.getValue() + 1),
    NKI_RedeclarableTemplateDecl(NKI_BuiltinTemplateDecl.getValue() + 1),
    NKI_ClassTemplateDecl(NKI_RedeclarableTemplateDecl.getValue() + 1),
    NKI_FunctionTemplateDecl(NKI_ClassTemplateDecl.getValue() + 1),
    NKI_TypeAliasTemplateDecl(NKI_FunctionTemplateDecl.getValue() + 1),
    NKI_VarTemplateDecl(NKI_TypeAliasTemplateDecl.getValue() + 1),
    NKI_TemplateTemplateParmDecl(NKI_VarTemplateDecl.getValue() + 1),
    NKI_TypeDecl(NKI_TemplateTemplateParmDecl.getValue() + 1),
    NKI_TagDecl(NKI_TypeDecl.getValue() + 1),
    NKI_EnumDecl(NKI_TagDecl.getValue() + 1),
    NKI_RecordDecl(NKI_EnumDecl.getValue() + 1),
    NKI_CXXRecordDecl(NKI_RecordDecl.getValue() + 1),
    NKI_ClassTemplateSpecializationDecl(NKI_CXXRecordDecl.getValue() + 1),
    NKI_ClassTemplatePartialSpecializationDecl(NKI_ClassTemplateSpecializationDecl.getValue() + 1),
    NKI_TemplateTypeParmDecl(NKI_ClassTemplatePartialSpecializationDecl.getValue() + 1),
    NKI_TypedefNameDecl(NKI_TemplateTypeParmDecl.getValue() + 1),
    NKI_ObjCTypeParamDecl(NKI_TypedefNameDecl.getValue() + 1),
    NKI_TypeAliasDecl(NKI_ObjCTypeParamDecl.getValue() + 1),
    NKI_TypedefDecl(NKI_TypeAliasDecl.getValue() + 1),
    NKI_UnresolvedUsingTypenameDecl(NKI_TypedefDecl.getValue() + 1),
    NKI_UsingDecl(NKI_UnresolvedUsingTypenameDecl.getValue() + 1),
    NKI_UsingDirectiveDecl(NKI_UsingDecl.getValue() + 1),
    NKI_UsingShadowDecl(NKI_UsingDirectiveDecl.getValue() + 1),
    NKI_ConstructorUsingShadowDecl(NKI_UsingShadowDecl.getValue() + 1),
    NKI_ValueDecl(NKI_ConstructorUsingShadowDecl.getValue() + 1),
    NKI_DeclaratorDecl(NKI_ValueDecl.getValue() + 1),
    NKI_FieldDecl(NKI_DeclaratorDecl.getValue() + 1),
    NKI_ObjCAtDefsFieldDecl(NKI_FieldDecl.getValue() + 1),
    NKI_ObjCIvarDecl(NKI_ObjCAtDefsFieldDecl.getValue() + 1),
    NKI_FunctionDecl(NKI_ObjCIvarDecl.getValue() + 1),
    NKI_CXXMethodDecl(NKI_FunctionDecl.getValue() + 1),
    NKI_CXXConstructorDecl(NKI_CXXMethodDecl.getValue() + 1),
    NKI_CXXConversionDecl(NKI_CXXConstructorDecl.getValue() + 1),
    NKI_CXXDestructorDecl(NKI_CXXConversionDecl.getValue() + 1),
    NKI_MSPropertyDecl(NKI_CXXDestructorDecl.getValue() + 1),
    NKI_NonTypeTemplateParmDecl(NKI_MSPropertyDecl.getValue() + 1),
    NKI_VarDecl(NKI_NonTypeTemplateParmDecl.getValue() + 1),
    NKI_ImplicitParamDecl(NKI_VarDecl.getValue() + 1),
    NKI_OMPCapturedExprDecl(NKI_ImplicitParamDecl.getValue() + 1),
    NKI_ParmVarDecl(NKI_OMPCapturedExprDecl.getValue() + 1),
    NKI_VarTemplateSpecializationDecl(NKI_ParmVarDecl.getValue() + 1),
    NKI_VarTemplatePartialSpecializationDecl(NKI_VarTemplateSpecializationDecl.getValue() + 1),
    NKI_EnumConstantDecl(NKI_VarTemplatePartialSpecializationDecl.getValue() + 1),
    NKI_IndirectFieldDecl(NKI_EnumConstantDecl.getValue() + 1),
    NKI_OMPDeclareReductionDecl(NKI_IndirectFieldDecl.getValue() + 1),
    NKI_UnresolvedUsingValueDecl(NKI_OMPDeclareReductionDecl.getValue() + 1),
    NKI_OMPThreadPrivateDecl(NKI_UnresolvedUsingValueDecl.getValue() + 1),
    NKI_ObjCPropertyImplDecl(NKI_OMPThreadPrivateDecl.getValue() + 1),
    NKI_PragmaCommentDecl(NKI_ObjCPropertyImplDecl.getValue() + 1),
    NKI_PragmaDetectMismatchDecl(NKI_PragmaCommentDecl.getValue() + 1),
    NKI_StaticAssertDecl(NKI_PragmaDetectMismatchDecl.getValue() + 1),
    NKI_TranslationUnitDecl(NKI_StaticAssertDecl.getValue() + 1),
    NKI_Stmt(NKI_TranslationUnitDecl.getValue() + 1),
    NKI_AsmStmt(NKI_Stmt.getValue() + 1),
    NKI_GCCAsmStmt(NKI_AsmStmt.getValue() + 1),
    NKI_MSAsmStmt(NKI_GCCAsmStmt.getValue() + 1),
    NKI_AttributedStmt(NKI_MSAsmStmt.getValue() + 1),
    NKI_BreakStmt(NKI_AttributedStmt.getValue() + 1),
    NKI_CXXCatchStmt(NKI_BreakStmt.getValue() + 1),
    NKI_CXXForRangeStmt(NKI_CXXCatchStmt.getValue() + 1),
    NKI_CXXTryStmt(NKI_CXXForRangeStmt.getValue() + 1),
    NKI_CapturedStmt(NKI_CXXTryStmt.getValue() + 1),
    NKI_CompoundStmt(NKI_CapturedStmt.getValue() + 1),
    NKI_ContinueStmt(NKI_CompoundStmt.getValue() + 1),
    NKI_CoreturnStmt(NKI_ContinueStmt.getValue() + 1),
    NKI_CoroutineBodyStmt(NKI_CoreturnStmt.getValue() + 1),
    NKI_DeclStmt(NKI_CoroutineBodyStmt.getValue() + 1),
    NKI_DoStmt(NKI_DeclStmt.getValue() + 1),
    NKI_Expr(NKI_DoStmt.getValue() + 1),
    NKI_AbstractConditionalOperator(NKI_Expr.getValue() + 1),
    NKI_BinaryConditionalOperator(NKI_AbstractConditionalOperator.getValue() + 1),
    NKI_ConditionalOperator(NKI_BinaryConditionalOperator.getValue() + 1),
    NKI_AddrLabelExpr(NKI_ConditionalOperator.getValue() + 1),
    NKI_ArraySubscriptExpr(NKI_AddrLabelExpr.getValue() + 1),
    NKI_ArrayTypeTraitExpr(NKI_ArraySubscriptExpr.getValue() + 1),
    NKI_AsTypeExpr(NKI_ArrayTypeTraitExpr.getValue() + 1),
    NKI_AtomicExpr(NKI_AsTypeExpr.getValue() + 1),
    NKI_BinaryOperator(NKI_AtomicExpr.getValue() + 1),
    NKI_CompoundAssignOperator(NKI_BinaryOperator.getValue() + 1),
    NKI_BlockExpr(NKI_CompoundAssignOperator.getValue() + 1),
    NKI_CXXBindTemporaryExpr(NKI_BlockExpr.getValue() + 1),
    NKI_CXXBoolLiteralExpr(NKI_CXXBindTemporaryExpr.getValue() + 1),
    NKI_CXXConstructExpr(NKI_CXXBoolLiteralExpr.getValue() + 1),
    NKI_CXXTemporaryObjectExpr(NKI_CXXConstructExpr.getValue() + 1),
    NKI_CXXDefaultArgExpr(NKI_CXXTemporaryObjectExpr.getValue() + 1),
    NKI_CXXDefaultInitExpr(NKI_CXXDefaultArgExpr.getValue() + 1),
    NKI_CXXDeleteExpr(NKI_CXXDefaultInitExpr.getValue() + 1),
    NKI_CXXDependentScopeMemberExpr(NKI_CXXDeleteExpr.getValue() + 1),
    NKI_CXXFoldExpr(NKI_CXXDependentScopeMemberExpr.getValue() + 1),
    NKI_CXXInheritedCtorInitExpr(NKI_CXXFoldExpr.getValue() + 1),
    NKI_CXXNewExpr(NKI_CXXInheritedCtorInitExpr.getValue() + 1),
    NKI_CXXNoexceptExpr(NKI_CXXNewExpr.getValue() + 1),
    NKI_CXXNullPtrLiteralExpr(NKI_CXXNoexceptExpr.getValue() + 1),
    NKI_CXXPseudoDestructorExpr(NKI_CXXNullPtrLiteralExpr.getValue() + 1),
    NKI_CXXScalarValueInitExpr(NKI_CXXPseudoDestructorExpr.getValue() + 1),
    NKI_CXXStdInitializerListExpr(NKI_CXXScalarValueInitExpr.getValue() + 1),
    NKI_CXXThisExpr(NKI_CXXStdInitializerListExpr.getValue() + 1),
    NKI_CXXThrowExpr(NKI_CXXThisExpr.getValue() + 1),
    NKI_CXXTypeidExpr(NKI_CXXThrowExpr.getValue() + 1),
    NKI_CXXUnresolvedConstructExpr(NKI_CXXTypeidExpr.getValue() + 1),
    NKI_CXXUuidofExpr(NKI_CXXUnresolvedConstructExpr.getValue() + 1),
    NKI_CallExpr(NKI_CXXUuidofExpr.getValue() + 1),
    NKI_CUDAKernelCallExpr(NKI_CallExpr.getValue() + 1),
    NKI_CXXMemberCallExpr(NKI_CUDAKernelCallExpr.getValue() + 1),
    NKI_CXXOperatorCallExpr(NKI_CXXMemberCallExpr.getValue() + 1),
    NKI_UserDefinedLiteral(NKI_CXXOperatorCallExpr.getValue() + 1),
    NKI_CastExpr(NKI_UserDefinedLiteral.getValue() + 1),
    NKI_ExplicitCastExpr(NKI_CastExpr.getValue() + 1),
    NKI_CStyleCastExpr(NKI_ExplicitCastExpr.getValue() + 1),
    NKI_CXXFunctionalCastExpr(NKI_CStyleCastExpr.getValue() + 1),
    NKI_CXXNamedCastExpr(NKI_CXXFunctionalCastExpr.getValue() + 1),
    NKI_CXXConstCastExpr(NKI_CXXNamedCastExpr.getValue() + 1),
    NKI_CXXDynamicCastExpr(NKI_CXXConstCastExpr.getValue() + 1),
    NKI_CXXReinterpretCastExpr(NKI_CXXDynamicCastExpr.getValue() + 1),
    NKI_CXXStaticCastExpr(NKI_CXXReinterpretCastExpr.getValue() + 1),
    NKI_ObjCBridgedCastExpr(NKI_CXXStaticCastExpr.getValue() + 1),
    NKI_ImplicitCastExpr(NKI_ObjCBridgedCastExpr.getValue() + 1),
    NKI_CharacterLiteral(NKI_ImplicitCastExpr.getValue() + 1),
    NKI_ChooseExpr(NKI_CharacterLiteral.getValue() + 1),
    NKI_CompoundLiteralExpr(NKI_ChooseExpr.getValue() + 1),
    NKI_ConvertVectorExpr(NKI_CompoundLiteralExpr.getValue() + 1),
    NKI_CoroutineSuspendExpr(NKI_ConvertVectorExpr.getValue() + 1),
    NKI_CoawaitExpr(NKI_CoroutineSuspendExpr.getValue() + 1),
    NKI_CoyieldExpr(NKI_CoawaitExpr.getValue() + 1),
    NKI_DeclRefExpr(NKI_CoyieldExpr.getValue() + 1),
    NKI_DependentScopeDeclRefExpr(NKI_DeclRefExpr.getValue() + 1),
    NKI_DesignatedInitExpr(NKI_DependentScopeDeclRefExpr.getValue() + 1),
    NKI_DesignatedInitUpdateExpr(NKI_DesignatedInitExpr.getValue() + 1),
    NKI_ExprWithCleanups(NKI_DesignatedInitUpdateExpr.getValue() + 1),
    NKI_ExpressionTraitExpr(NKI_ExprWithCleanups.getValue() + 1),
    NKI_ExtVectorElementExpr(NKI_ExpressionTraitExpr.getValue() + 1),
    NKI_FloatingLiteral(NKI_ExtVectorElementExpr.getValue() + 1),
    NKI_FunctionParmPackExpr(NKI_FloatingLiteral.getValue() + 1),
    NKI_GNUNullExpr(NKI_FunctionParmPackExpr.getValue() + 1),
    NKI_GenericSelectionExpr(NKI_GNUNullExpr.getValue() + 1),
    NKI_ImaginaryLiteral(NKI_GenericSelectionExpr.getValue() + 1),
    NKI_ImplicitValueInitExpr(NKI_ImaginaryLiteral.getValue() + 1),
    NKI_InitListExpr(NKI_ImplicitValueInitExpr.getValue() + 1),
    NKI_IntegerLiteral(NKI_InitListExpr.getValue() + 1),
    NKI_LambdaExpr(NKI_IntegerLiteral.getValue() + 1),
    NKI_MSPropertyRefExpr(NKI_LambdaExpr.getValue() + 1),
    NKI_MSPropertySubscriptExpr(NKI_MSPropertyRefExpr.getValue() + 1),
    NKI_MaterializeTemporaryExpr(NKI_MSPropertySubscriptExpr.getValue() + 1),
    NKI_MemberExpr(NKI_MaterializeTemporaryExpr.getValue() + 1),
    NKI_NoInitExpr(NKI_MemberExpr.getValue() + 1),
    NKI_OMPArraySectionExpr(NKI_NoInitExpr.getValue() + 1),
    NKI_ObjCArrayLiteral(NKI_OMPArraySectionExpr.getValue() + 1),
    NKI_ObjCAvailabilityCheckExpr(NKI_ObjCArrayLiteral.getValue() + 1),
    NKI_ObjCBoolLiteralExpr(NKI_ObjCAvailabilityCheckExpr.getValue() + 1),
    NKI_ObjCBoxedExpr(NKI_ObjCBoolLiteralExpr.getValue() + 1),
    NKI_ObjCDictionaryLiteral(NKI_ObjCBoxedExpr.getValue() + 1),
    NKI_ObjCEncodeExpr(NKI_ObjCDictionaryLiteral.getValue() + 1),
    NKI_ObjCIndirectCopyRestoreExpr(NKI_ObjCEncodeExpr.getValue() + 1),
    NKI_ObjCIsaExpr(NKI_ObjCIndirectCopyRestoreExpr.getValue() + 1),
    NKI_ObjCIvarRefExpr(NKI_ObjCIsaExpr.getValue() + 1),
    NKI_ObjCMessageExpr(NKI_ObjCIvarRefExpr.getValue() + 1),
    NKI_ObjCPropertyRefExpr(NKI_ObjCMessageExpr.getValue() + 1),
    NKI_ObjCProtocolExpr(NKI_ObjCPropertyRefExpr.getValue() + 1),
    NKI_ObjCSelectorExpr(NKI_ObjCProtocolExpr.getValue() + 1),
    NKI_ObjCStringLiteral(NKI_ObjCSelectorExpr.getValue() + 1),
    NKI_ObjCSubscriptRefExpr(NKI_ObjCStringLiteral.getValue() + 1),
    NKI_OffsetOfExpr(NKI_ObjCSubscriptRefExpr.getValue() + 1),
    NKI_OpaqueValueExpr(NKI_OffsetOfExpr.getValue() + 1),
    NKI_OverloadExpr(NKI_OpaqueValueExpr.getValue() + 1),
    NKI_UnresolvedLookupExpr(NKI_OverloadExpr.getValue() + 1),
    NKI_UnresolvedMemberExpr(NKI_UnresolvedLookupExpr.getValue() + 1),
    NKI_PackExpansionExpr(NKI_UnresolvedMemberExpr.getValue() + 1),
    NKI_ParenExpr(NKI_PackExpansionExpr.getValue() + 1),
    NKI_ParenListExpr(NKI_ParenExpr.getValue() + 1),
    NKI_PredefinedExpr(NKI_ParenListExpr.getValue() + 1),
    NKI_PseudoObjectExpr(NKI_PredefinedExpr.getValue() + 1),
    NKI_ShuffleVectorExpr(NKI_PseudoObjectExpr.getValue() + 1),
    NKI_SizeOfPackExpr(NKI_ShuffleVectorExpr.getValue() + 1),
    NKI_StmtExpr(NKI_SizeOfPackExpr.getValue() + 1),
    NKI_StringLiteral(NKI_StmtExpr.getValue() + 1),
    NKI_SubstNonTypeTemplateParmExpr(NKI_StringLiteral.getValue() + 1),
    NKI_SubstNonTypeTemplateParmPackExpr(NKI_SubstNonTypeTemplateParmExpr.getValue() + 1),
    NKI_TypeTraitExpr(NKI_SubstNonTypeTemplateParmPackExpr.getValue() + 1),
    NKI_TypoExpr(NKI_TypeTraitExpr.getValue() + 1),
    NKI_UnaryExprOrTypeTraitExpr(NKI_TypoExpr.getValue() + 1),
    NKI_UnaryOperator(NKI_UnaryExprOrTypeTraitExpr.getValue() + 1),
    NKI_VAArgExpr(NKI_UnaryOperator.getValue() + 1),
    NKI_ForStmt(NKI_VAArgExpr.getValue() + 1),
    NKI_GotoStmt(NKI_ForStmt.getValue() + 1),
    NKI_IfStmt(NKI_GotoStmt.getValue() + 1),
    NKI_IndirectGotoStmt(NKI_IfStmt.getValue() + 1),
    NKI_LabelStmt(NKI_IndirectGotoStmt.getValue() + 1),
    NKI_MSDependentExistsStmt(NKI_LabelStmt.getValue() + 1),
    NKI_NullStmt(NKI_MSDependentExistsStmt.getValue() + 1),
    NKI_OMPExecutableDirective(NKI_NullStmt.getValue() + 1),
    NKI_OMPAtomicDirective(NKI_OMPExecutableDirective.getValue() + 1),
    NKI_OMPBarrierDirective(NKI_OMPAtomicDirective.getValue() + 1),
    NKI_OMPCancelDirective(NKI_OMPBarrierDirective.getValue() + 1),
    NKI_OMPCancellationPointDirective(NKI_OMPCancelDirective.getValue() + 1),
    NKI_OMPCriticalDirective(NKI_OMPCancellationPointDirective.getValue() + 1),
    NKI_OMPFlushDirective(NKI_OMPCriticalDirective.getValue() + 1),
    NKI_OMPLoopDirective(NKI_OMPFlushDirective.getValue() + 1),
    NKI_OMPDistributeDirective(NKI_OMPLoopDirective.getValue() + 1),
    NKI_OMPDistributeParallelForDirective(NKI_OMPDistributeDirective.getValue() + 1),
    NKI_OMPDistributeParallelForSimdDirective(NKI_OMPDistributeParallelForDirective.getValue() + 1),
    NKI_OMPDistributeSimdDirective(NKI_OMPDistributeParallelForSimdDirective.getValue() + 1),
    NKI_OMPForDirective(NKI_OMPDistributeSimdDirective.getValue() + 1),
    NKI_OMPForSimdDirective(NKI_OMPForDirective.getValue() + 1),
    NKI_OMPParallelForDirective(NKI_OMPForSimdDirective.getValue() + 1),
    NKI_OMPParallelForSimdDirective(NKI_OMPParallelForDirective.getValue() + 1),
    NKI_OMPSimdDirective(NKI_OMPParallelForSimdDirective.getValue() + 1),
    NKI_OMPTargetParallelForSimdDirective(NKI_OMPSimdDirective.getValue() + 1),
    NKI_OMPTaskLoopDirective(NKI_OMPTargetParallelForSimdDirective.getValue() + 1),
    NKI_OMPTaskLoopSimdDirective(NKI_OMPTaskLoopDirective.getValue() + 1),
    NKI_OMPMasterDirective(NKI_OMPTaskLoopSimdDirective.getValue() + 1),
    NKI_OMPOrderedDirective(NKI_OMPMasterDirective.getValue() + 1),
    NKI_OMPParallelDirective(NKI_OMPOrderedDirective.getValue() + 1),
    NKI_OMPParallelSectionsDirective(NKI_OMPParallelDirective.getValue() + 1),
    NKI_OMPSectionDirective(NKI_OMPParallelSectionsDirective.getValue() + 1),
    NKI_OMPSectionsDirective(NKI_OMPSectionDirective.getValue() + 1),
    NKI_OMPSingleDirective(NKI_OMPSectionsDirective.getValue() + 1),
    NKI_OMPTargetDataDirective(NKI_OMPSingleDirective.getValue() + 1),
    NKI_OMPTargetDirective(NKI_OMPTargetDataDirective.getValue() + 1),
    NKI_OMPTargetEnterDataDirective(NKI_OMPTargetDirective.getValue() + 1),
    NKI_OMPTargetExitDataDirective(NKI_OMPTargetEnterDataDirective.getValue() + 1),
    NKI_OMPTargetParallelDirective(NKI_OMPTargetExitDataDirective.getValue() + 1),
    NKI_OMPTargetParallelForDirective(NKI_OMPTargetParallelDirective.getValue() + 1),
    NKI_OMPTargetUpdateDirective(NKI_OMPTargetParallelForDirective.getValue() + 1),
    NKI_OMPTaskDirective(NKI_OMPTargetUpdateDirective.getValue() + 1),
    NKI_OMPTaskgroupDirective(NKI_OMPTaskDirective.getValue() + 1),
    NKI_OMPTaskwaitDirective(NKI_OMPTaskgroupDirective.getValue() + 1),
    NKI_OMPTaskyieldDirective(NKI_OMPTaskwaitDirective.getValue() + 1),
    NKI_OMPTeamsDirective(NKI_OMPTaskyieldDirective.getValue() + 1),
    NKI_ObjCAtCatchStmt(NKI_OMPTeamsDirective.getValue() + 1),
    NKI_ObjCAtFinallyStmt(NKI_ObjCAtCatchStmt.getValue() + 1),
    NKI_ObjCAtSynchronizedStmt(NKI_ObjCAtFinallyStmt.getValue() + 1),
    NKI_ObjCAtThrowStmt(NKI_ObjCAtSynchronizedStmt.getValue() + 1),
    NKI_ObjCAtTryStmt(NKI_ObjCAtThrowStmt.getValue() + 1),
    NKI_ObjCAutoreleasePoolStmt(NKI_ObjCAtTryStmt.getValue() + 1),
    NKI_ObjCForCollectionStmt(NKI_ObjCAutoreleasePoolStmt.getValue() + 1),
    NKI_ReturnStmt(NKI_ObjCForCollectionStmt.getValue() + 1),
    NKI_SEHExceptStmt(NKI_ReturnStmt.getValue() + 1),
    NKI_SEHFinallyStmt(NKI_SEHExceptStmt.getValue() + 1),
    NKI_SEHLeaveStmt(NKI_SEHFinallyStmt.getValue() + 1),
    NKI_SEHTryStmt(NKI_SEHLeaveStmt.getValue() + 1),
    NKI_SwitchCase(NKI_SEHTryStmt.getValue() + 1),
    NKI_CaseStmt(NKI_SwitchCase.getValue() + 1),
    NKI_DefaultStmt(NKI_CaseStmt.getValue() + 1),
    NKI_SwitchStmt(NKI_DefaultStmt.getValue() + 1),
    NKI_WhileStmt(NKI_SwitchStmt.getValue() + 1),
    NKI_Type(NKI_WhileStmt.getValue() + 1),
    NKI_BuiltinType(NKI_Type.getValue() + 1),
    NKI_ComplexType(NKI_BuiltinType.getValue() + 1),
    NKI_PointerType(NKI_ComplexType.getValue() + 1),
    NKI_BlockPointerType(NKI_PointerType.getValue() + 1),
    NKI_ReferenceType(NKI_BlockPointerType.getValue() + 1),
    NKI_LValueReferenceType(NKI_ReferenceType.getValue() + 1),
    NKI_RValueReferenceType(NKI_LValueReferenceType.getValue() + 1),
    NKI_MemberPointerType(NKI_RValueReferenceType.getValue() + 1),
    NKI_ArrayType(NKI_MemberPointerType.getValue() + 1),
    NKI_ConstantArrayType(NKI_ArrayType.getValue() + 1),
    NKI_IncompleteArrayType(NKI_ConstantArrayType.getValue() + 1),
    NKI_VariableArrayType(NKI_IncompleteArrayType.getValue() + 1),
    NKI_DependentSizedArrayType(NKI_VariableArrayType.getValue() + 1),
    NKI_DependentSizedExtVectorType(NKI_DependentSizedArrayType.getValue() + 1),
    NKI_VectorType(NKI_DependentSizedExtVectorType.getValue() + 1),
    NKI_ExtVectorType(NKI_VectorType.getValue() + 1),
    NKI_FunctionType(NKI_ExtVectorType.getValue() + 1),
    NKI_FunctionProtoType(NKI_FunctionType.getValue() + 1),
    NKI_FunctionNoProtoType(NKI_FunctionProtoType.getValue() + 1),
    NKI_UnresolvedUsingType(NKI_FunctionNoProtoType.getValue() + 1),
    NKI_ParenType(NKI_UnresolvedUsingType.getValue() + 1),
    NKI_TypedefType(NKI_ParenType.getValue() + 1),
    NKI_AdjustedType(NKI_TypedefType.getValue() + 1),
    NKI_DecayedType(NKI_AdjustedType.getValue() + 1),
    NKI_TypeOfExprType(NKI_DecayedType.getValue() + 1),
    NKI_TypeOfType(NKI_TypeOfExprType.getValue() + 1),
    NKI_DecltypeType(NKI_TypeOfType.getValue() + 1),
    NKI_UnaryTransformType(NKI_DecltypeType.getValue() + 1),
    NKI_TagType(NKI_UnaryTransformType.getValue() + 1),
    NKI_RecordType(NKI_TagType.getValue() + 1),
    NKI_EnumType(NKI_RecordType.getValue() + 1),
    NKI_ElaboratedType(NKI_EnumType.getValue() + 1),
    NKI_AttributedType(NKI_ElaboratedType.getValue() + 1),
    NKI_TemplateTypeParmType(NKI_AttributedType.getValue() + 1),
    NKI_SubstTemplateTypeParmType(NKI_TemplateTypeParmType.getValue() + 1),
    NKI_SubstTemplateTypeParmPackType(NKI_SubstTemplateTypeParmType.getValue() + 1),
    NKI_TemplateSpecializationType(NKI_SubstTemplateTypeParmPackType.getValue() + 1),
    NKI_AutoType(NKI_TemplateSpecializationType.getValue() + 1),
    NKI_InjectedClassNameType(NKI_AutoType.getValue() + 1),
    NKI_DependentNameType(NKI_InjectedClassNameType.getValue() + 1),
    NKI_DependentTemplateSpecializationType(NKI_DependentNameType.getValue() + 1),
    NKI_PackExpansionType(NKI_DependentTemplateSpecializationType.getValue() + 1),
    NKI_ObjCObjectType(NKI_PackExpansionType.getValue() + 1),
    NKI_ObjCInterfaceType(NKI_ObjCObjectType.getValue() + 1),
    NKI_ObjCObjectPointerType(NKI_ObjCInterfaceType.getValue() + 1),
    NKI_PipeType(NKI_ObjCObjectPointerType.getValue() + 1),
    NKI_AtomicType(NKI_PipeType.getValue() + 1),
    NKI_NumberOfKinds(NKI_AtomicType.getValue() + 1);

    //<editor-fold defaultstate="collapsed" desc="hidden">
    public static NodeKindId valueOf(int val) {
      NodeKindId out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
      assert out != null : "no value for " + val;
      assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
      return out;
    }

    private static final class Values {
      private static final NodeKindId[] VALUES;
      private static final NodeKindId[] _VALUES; // [0] not used
      static {
        int max = 0;
        int min = 0;
        for (NodeKindId kind : NodeKindId.values()) {
          if (kind.value > max) { max = kind.value; }
          if (kind.value < min) { min = kind.value; }
        }
        _VALUES = new NodeKindId[min < 0 ? (1-min) : 0];
        VALUES = new NodeKindId[max >= 0 ? (1+max) : 0];
        for (NodeKindId kind : NodeKindId.values()) {
          if (kind.value < 0) {
            _VALUES[-kind.value] = kind;
          } else {
            VALUES[kind.value] = kind;
          }
        }
      }
    }

    private final /*uint*/int value;
    private NodeKindId(int val) { this.value = (/*uint*/int)val;}
    public /*uint*/int getValue() { return value;}
    @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((NodeKindId)obj).value);}
    @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((NodeKindId)obj).value);}
    //</editor-fold>
  };
  
  /// \brief Use getFromNodeKind<T>() to construct the kind.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::ASTNodeKind">
  @Converted(kind = Converted.Kind.MANUAL/*assert*/,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 143,
   FQN="clang::ast_type_traits::ASTNodeKind::ASTNodeKind", NM="_ZN5clang15ast_type_traits11ASTNodeKindC1ENS1_10NodeKindIdE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindC1ENS1_10NodeKindIdE")
  //</editor-fold>
  private ASTNodeKind(NodeKindId KindId) {
    // : KindId(KindId) 
    //START JInit
    this.KindId = KindId;
    //END JInit
    assert this.KindId != null;
  }

  
  /// \brief Returns \c true if \c Base is a base kind of (or same as) \c
  ///   Derived.
  /// \param Distance If non-null, used to return the distance between \c Base
  /// and \c Derived in the class hierarchy.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::isBaseOf">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp", line = 46,
   FQN="clang::ast_type_traits::ASTNodeKind::isBaseOf", NM="_ZN5clang15ast_type_traits11ASTNodeKind8isBaseOfENS1_10NodeKindIdES2_Pj",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind8isBaseOfENS1_10NodeKindIdES2_Pj")
  //</editor-fold>
  private static boolean isBaseOf(NodeKindId Base, NodeKindId Derived, 
          uint$ptr/*uint P*/ Distance) {
    if (Base == NodeKindId.NKI_None || Derived == NodeKindId.NKI_None) {
      return false;
    }
    /*uint*/int Dist = 0;
    while (Derived != Base && Derived != NodeKindId.NKI_None) {
      Derived = AllKindInfo[Derived.getValue()].ParentId;
      ++Dist;
    }
    if ((Distance != null)) {
      Distance.$set(Dist);
    }
    return Derived == Base;
  }

  
  /// \brief Helper meta-function to convert a kind T to its enum value.
  ///
  /// This struct is specialized below for all known kinds.
  /*template <class T> TEMPLATE*/
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::KindToKindId">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 154,
   FQN="clang::ast_type_traits::ASTNodeKind::KindToKindId", NM="_ZN5clang15ast_type_traits11ASTNodeKind12KindToKindIdE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12KindToKindIdE")
  //</editor-fold>
  public static class/*struct*/ KindToKindId</*class*/ T>  {
    public static /*const*/ NodeKindId Id = NodeKindId.NKI_None;
    
    @Override public String toString() {
      return ""; // NOI18N
    }
  };
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::KindToKindId<const type-parameter-0-0>">
  @Converted(kind = Converted.Kind.MANUAL_COMPILATION,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 157,
   FQN="clang::ast_type_traits::ASTNodeKind::KindToKindId<const type-parameter-0-0>", NM="_ZN5clang15ast_type_traits11ASTNodeKind12KindToKindIdIKT_EE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind12KindToKindIdIKT_EE")
  //</editor-fold>
  public static class/*struct*/ KindToKindIdT$C<T> extends /**/ KindToKindId<T> {
    
    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
  
  /// \brief Per kind info.
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::KindInfo">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 161,
   FQN="clang::ast_type_traits::ASTNodeKind::KindInfo", NM="_ZN5clang15ast_type_traits11ASTNodeKind8KindInfoE",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKind8KindInfoE")
  //</editor-fold>
  private static class/*struct*/ KindInfo {
    /// \brief The id of the parent kind, or None if it has no parent.
    public final/*public*/ NodeKindId ParentId;
    /// \brief Name of the kind.
    public final/*public*/ /*const*/char$ptr/*char P*/ Name;
    //////////////////////////////////////////////////////////////
    // EXTRA MEMBERS: BEGIN

    public KindInfo(NodeKindId ParentId, String ClassName) {
      this.ParentId = ParentId;
      this.Name = $(ClassName);
    }

    // EXTRA MEMBERS: END
    //////////////////////////////////////////////////////////////
    
    @Override public String toString() {
      return "" + "ParentId=" + ParentId // NOI18N
                + ", Name=" + Name; // NOI18N
    }
  };
  private static /*const*/ KindInfo AllKindInfo[/*327*/] = new /*const*/ KindInfo [/*327*/] {
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"<None>"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"TemplateArgument"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"NestedNameSpecifierLoc"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"QualType"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"TypeLoc"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"CXXCtorInitializer"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"NestedNameSpecifier"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"Decl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"AccessSpecDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"BlockDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"CapturedDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"ClassScopeFunctionSpecializationDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"EmptyDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"ExternCContextDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"FileScopeAsmDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"FriendDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"FriendTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"ImportDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"LinkageSpecDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"NamedDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"LabelDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"NamespaceDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"NamespaceAliasDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"ObjCCompatibleAliasDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"ObjCContainerDecl"), 
    new KindInfo(NodeKindId.NKI_ObjCContainerDecl, /*KEEP_STR*/"ObjCCategoryDecl"), 
    new KindInfo(NodeKindId.NKI_ObjCContainerDecl, /*KEEP_STR*/"ObjCImplDecl"), 
    new KindInfo(NodeKindId.NKI_ObjCImplDecl, /*KEEP_STR*/"ObjCCategoryImplDecl"), 
    new KindInfo(NodeKindId.NKI_ObjCImplDecl, /*KEEP_STR*/"ObjCImplementationDecl"), 
    new KindInfo(NodeKindId.NKI_ObjCContainerDecl, /*KEEP_STR*/"ObjCInterfaceDecl"), 
    new KindInfo(NodeKindId.NKI_ObjCContainerDecl, /*KEEP_STR*/"ObjCProtocolDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"ObjCMethodDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"ObjCPropertyDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"TemplateDecl"), 
    new KindInfo(NodeKindId.NKI_TemplateDecl, /*KEEP_STR*/"BuiltinTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_TemplateDecl, /*KEEP_STR*/"RedeclarableTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_RedeclarableTemplateDecl, /*KEEP_STR*/"ClassTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_RedeclarableTemplateDecl, /*KEEP_STR*/"FunctionTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_RedeclarableTemplateDecl, /*KEEP_STR*/"TypeAliasTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_RedeclarableTemplateDecl, /*KEEP_STR*/"VarTemplateDecl"), 
    new KindInfo(NodeKindId.NKI_TemplateDecl, /*KEEP_STR*/"TemplateTemplateParmDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"TypeDecl"), 
    new KindInfo(NodeKindId.NKI_TypeDecl, /*KEEP_STR*/"TagDecl"), 
    new KindInfo(NodeKindId.NKI_TagDecl, /*KEEP_STR*/"EnumDecl"), 
    new KindInfo(NodeKindId.NKI_TagDecl, /*KEEP_STR*/"RecordDecl"), 
    new KindInfo(NodeKindId.NKI_RecordDecl, /*KEEP_STR*/"CXXRecordDecl"), 
    new KindInfo(NodeKindId.NKI_CXXRecordDecl, /*KEEP_STR*/"ClassTemplateSpecializationDecl"), 
    new KindInfo(NodeKindId.NKI_ClassTemplateSpecializationDecl, /*KEEP_STR*/"ClassTemplatePartialSpecializationDecl"), 
    new KindInfo(NodeKindId.NKI_TypeDecl, /*KEEP_STR*/"TemplateTypeParmDecl"), 
    new KindInfo(NodeKindId.NKI_TypeDecl, /*KEEP_STR*/"TypedefNameDecl"), 
    new KindInfo(NodeKindId.NKI_TypedefNameDecl, /*KEEP_STR*/"ObjCTypeParamDecl"), 
    new KindInfo(NodeKindId.NKI_TypedefNameDecl, /*KEEP_STR*/"TypeAliasDecl"), 
    new KindInfo(NodeKindId.NKI_TypedefNameDecl, /*KEEP_STR*/"TypedefDecl"), 
    new KindInfo(NodeKindId.NKI_TypeDecl, /*KEEP_STR*/"UnresolvedUsingTypenameDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"UsingDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"UsingDirectiveDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"UsingShadowDecl"), 
    new KindInfo(NodeKindId.NKI_UsingShadowDecl, /*KEEP_STR*/"ConstructorUsingShadowDecl"), 
    new KindInfo(NodeKindId.NKI_NamedDecl, /*KEEP_STR*/"ValueDecl"), 
    new KindInfo(NodeKindId.NKI_ValueDecl, /*KEEP_STR*/"DeclaratorDecl"), 
    new KindInfo(NodeKindId.NKI_DeclaratorDecl, /*KEEP_STR*/"FieldDecl"), 
    new KindInfo(NodeKindId.NKI_FieldDecl, /*KEEP_STR*/"ObjCAtDefsFieldDecl"), 
    new KindInfo(NodeKindId.NKI_FieldDecl, /*KEEP_STR*/"ObjCIvarDecl"), 
    new KindInfo(NodeKindId.NKI_DeclaratorDecl, /*KEEP_STR*/"FunctionDecl"), 
    new KindInfo(NodeKindId.NKI_FunctionDecl, /*KEEP_STR*/"CXXMethodDecl"), 
    new KindInfo(NodeKindId.NKI_CXXMethodDecl, /*KEEP_STR*/"CXXConstructorDecl"), 
    new KindInfo(NodeKindId.NKI_CXXMethodDecl, /*KEEP_STR*/"CXXConversionDecl"), 
    new KindInfo(NodeKindId.NKI_CXXMethodDecl, /*KEEP_STR*/"CXXDestructorDecl"), 
    new KindInfo(NodeKindId.NKI_DeclaratorDecl, /*KEEP_STR*/"MSPropertyDecl"), 
    new KindInfo(NodeKindId.NKI_DeclaratorDecl, /*KEEP_STR*/"NonTypeTemplateParmDecl"), 
    new KindInfo(NodeKindId.NKI_DeclaratorDecl, /*KEEP_STR*/"VarDecl"), 
    new KindInfo(NodeKindId.NKI_VarDecl, /*KEEP_STR*/"ImplicitParamDecl"), 
    new KindInfo(NodeKindId.NKI_VarDecl, /*KEEP_STR*/"OMPCapturedExprDecl"), 
    new KindInfo(NodeKindId.NKI_VarDecl, /*KEEP_STR*/"ParmVarDecl"), 
    new KindInfo(NodeKindId.NKI_VarDecl, /*KEEP_STR*/"VarTemplateSpecializationDecl"), 
    new KindInfo(NodeKindId.NKI_VarTemplateSpecializationDecl, /*KEEP_STR*/"VarTemplatePartialSpecializationDecl"), 
    new KindInfo(NodeKindId.NKI_ValueDecl, /*KEEP_STR*/"EnumConstantDecl"), 
    new KindInfo(NodeKindId.NKI_ValueDecl, /*KEEP_STR*/"IndirectFieldDecl"), 
    new KindInfo(NodeKindId.NKI_ValueDecl, /*KEEP_STR*/"OMPDeclareReductionDecl"), 
    new KindInfo(NodeKindId.NKI_ValueDecl, /*KEEP_STR*/"UnresolvedUsingValueDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"OMPThreadPrivateDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"ObjCPropertyImplDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"PragmaCommentDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"PragmaDetectMismatchDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"StaticAssertDecl"), 
    new KindInfo(NodeKindId.NKI_Decl, /*KEEP_STR*/"TranslationUnitDecl"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"Stmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"AsmStmt"), 
    new KindInfo(NodeKindId.NKI_AsmStmt, /*KEEP_STR*/"GCCAsmStmt"), 
    new KindInfo(NodeKindId.NKI_AsmStmt, /*KEEP_STR*/"MSAsmStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"AttributedStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"BreakStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CXXCatchStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CXXForRangeStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CXXTryStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CapturedStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CompoundStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ContinueStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CoreturnStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"CoroutineBodyStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"DeclStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"DoStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"Expr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"AbstractConditionalOperator"), 
    new KindInfo(NodeKindId.NKI_AbstractConditionalOperator, /*KEEP_STR*/"BinaryConditionalOperator"), 
    new KindInfo(NodeKindId.NKI_AbstractConditionalOperator, /*KEEP_STR*/"ConditionalOperator"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"AddrLabelExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ArraySubscriptExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ArrayTypeTraitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"AsTypeExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"AtomicExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"BinaryOperator"), 
    new KindInfo(NodeKindId.NKI_BinaryOperator, /*KEEP_STR*/"CompoundAssignOperator"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"BlockExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXBindTemporaryExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXBoolLiteralExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXConstructExpr"), 
    new KindInfo(NodeKindId.NKI_CXXConstructExpr, /*KEEP_STR*/"CXXTemporaryObjectExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXDefaultArgExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXDefaultInitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXDeleteExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXDependentScopeMemberExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXFoldExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXInheritedCtorInitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXNewExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXNoexceptExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXNullPtrLiteralExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXPseudoDestructorExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXScalarValueInitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXStdInitializerListExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXThisExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXThrowExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXTypeidExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXUnresolvedConstructExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CXXUuidofExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CallExpr"), 
    new KindInfo(NodeKindId.NKI_CallExpr, /*KEEP_STR*/"CUDAKernelCallExpr"), 
    new KindInfo(NodeKindId.NKI_CallExpr, /*KEEP_STR*/"CXXMemberCallExpr"), 
    new KindInfo(NodeKindId.NKI_CallExpr, /*KEEP_STR*/"CXXOperatorCallExpr"), 
    new KindInfo(NodeKindId.NKI_CallExpr, /*KEEP_STR*/"UserDefinedLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CastExpr"), 
    new KindInfo(NodeKindId.NKI_CastExpr, /*KEEP_STR*/"ExplicitCastExpr"), 
    new KindInfo(NodeKindId.NKI_ExplicitCastExpr, /*KEEP_STR*/"CStyleCastExpr"), 
    new KindInfo(NodeKindId.NKI_ExplicitCastExpr, /*KEEP_STR*/"CXXFunctionalCastExpr"), 
    new KindInfo(NodeKindId.NKI_ExplicitCastExpr, /*KEEP_STR*/"CXXNamedCastExpr"), 
    new KindInfo(NodeKindId.NKI_CXXNamedCastExpr, /*KEEP_STR*/"CXXConstCastExpr"), 
    new KindInfo(NodeKindId.NKI_CXXNamedCastExpr, /*KEEP_STR*/"CXXDynamicCastExpr"), 
    new KindInfo(NodeKindId.NKI_CXXNamedCastExpr, /*KEEP_STR*/"CXXReinterpretCastExpr"), 
    new KindInfo(NodeKindId.NKI_CXXNamedCastExpr, /*KEEP_STR*/"CXXStaticCastExpr"), 
    new KindInfo(NodeKindId.NKI_ExplicitCastExpr, /*KEEP_STR*/"ObjCBridgedCastExpr"), 
    new KindInfo(NodeKindId.NKI_CastExpr, /*KEEP_STR*/"ImplicitCastExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CharacterLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ChooseExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CompoundLiteralExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ConvertVectorExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"CoroutineSuspendExpr"), 
    new KindInfo(NodeKindId.NKI_CoroutineSuspendExpr, /*KEEP_STR*/"CoawaitExpr"), 
    new KindInfo(NodeKindId.NKI_CoroutineSuspendExpr, /*KEEP_STR*/"CoyieldExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"DeclRefExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"DependentScopeDeclRefExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"DesignatedInitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"DesignatedInitUpdateExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ExprWithCleanups"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ExpressionTraitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ExtVectorElementExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"FloatingLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"FunctionParmPackExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"GNUNullExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"GenericSelectionExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ImaginaryLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ImplicitValueInitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"InitListExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"IntegerLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"LambdaExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"MSPropertyRefExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"MSPropertySubscriptExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"MaterializeTemporaryExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"MemberExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"NoInitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"OMPArraySectionExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCArrayLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCAvailabilityCheckExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCBoolLiteralExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCBoxedExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCDictionaryLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCEncodeExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCIndirectCopyRestoreExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCIsaExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCIvarRefExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCMessageExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCPropertyRefExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCProtocolExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCSelectorExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCStringLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ObjCSubscriptRefExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"OffsetOfExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"OpaqueValueExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"OverloadExpr"), 
    new KindInfo(NodeKindId.NKI_OverloadExpr, /*KEEP_STR*/"UnresolvedLookupExpr"), 
    new KindInfo(NodeKindId.NKI_OverloadExpr, /*KEEP_STR*/"UnresolvedMemberExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"PackExpansionExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ParenExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ParenListExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"PredefinedExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"PseudoObjectExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"ShuffleVectorExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"SizeOfPackExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"StmtExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"StringLiteral"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"SubstNonTypeTemplateParmExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"SubstNonTypeTemplateParmPackExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"TypeTraitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"TypoExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"UnaryExprOrTypeTraitExpr"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"UnaryOperator"), 
    new KindInfo(NodeKindId.NKI_Expr, /*KEEP_STR*/"VAArgExpr"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ForStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"GotoStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"IfStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"IndirectGotoStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"LabelStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"MSDependentExistsStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"NullStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"OMPExecutableDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPAtomicDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPBarrierDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPCancelDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPCancellationPointDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPCriticalDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPFlushDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPLoopDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPDistributeDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPDistributeParallelForDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPDistributeParallelForSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPDistributeSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPForDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPForSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPParallelForDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPParallelForSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPTargetParallelForSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPTaskLoopDirective"), 
    new KindInfo(NodeKindId.NKI_OMPLoopDirective, /*KEEP_STR*/"OMPTaskLoopSimdDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPMasterDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPOrderedDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPParallelDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPParallelSectionsDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPSectionDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPSectionsDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPSingleDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetDataDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetEnterDataDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetExitDataDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetParallelDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetParallelForDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTargetUpdateDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTaskDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTaskgroupDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTaskwaitDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTaskyieldDirective"), 
    new KindInfo(NodeKindId.NKI_OMPExecutableDirective, /*KEEP_STR*/"OMPTeamsDirective"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCAtCatchStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCAtFinallyStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCAtSynchronizedStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCAtThrowStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCAtTryStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCAutoreleasePoolStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ObjCForCollectionStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"ReturnStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"SEHExceptStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"SEHFinallyStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"SEHLeaveStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"SEHTryStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"SwitchCase"), 
    new KindInfo(NodeKindId.NKI_SwitchCase, /*KEEP_STR*/"CaseStmt"), 
    new KindInfo(NodeKindId.NKI_SwitchCase, /*KEEP_STR*/"DefaultStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"SwitchStmt"), 
    new KindInfo(NodeKindId.NKI_Stmt, /*KEEP_STR*/"WhileStmt"), 
    new KindInfo(NodeKindId.NKI_None, /*KEEP_STR*/"Type"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"BuiltinType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ComplexType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"PointerType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"BlockPointerType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ReferenceType"), 
    new KindInfo(NodeKindId.NKI_ReferenceType, /*KEEP_STR*/"LValueReferenceType"), 
    new KindInfo(NodeKindId.NKI_ReferenceType, /*KEEP_STR*/"RValueReferenceType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"MemberPointerType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ArrayType"), 
    new KindInfo(NodeKindId.NKI_ArrayType, /*KEEP_STR*/"ConstantArrayType"), 
    new KindInfo(NodeKindId.NKI_ArrayType, /*KEEP_STR*/"IncompleteArrayType"), 
    new KindInfo(NodeKindId.NKI_ArrayType, /*KEEP_STR*/"VariableArrayType"), 
    new KindInfo(NodeKindId.NKI_ArrayType, /*KEEP_STR*/"DependentSizedArrayType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"DependentSizedExtVectorType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"VectorType"), 
    new KindInfo(NodeKindId.NKI_VectorType, /*KEEP_STR*/"ExtVectorType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"FunctionType"), 
    new KindInfo(NodeKindId.NKI_FunctionType, /*KEEP_STR*/"FunctionProtoType"), 
    new KindInfo(NodeKindId.NKI_FunctionType, /*KEEP_STR*/"FunctionNoProtoType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"UnresolvedUsingType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ParenType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"TypedefType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"AdjustedType"), 
    new KindInfo(NodeKindId.NKI_AdjustedType, /*KEEP_STR*/"DecayedType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"TypeOfExprType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"TypeOfType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"DecltypeType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"UnaryTransformType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"TagType"), 
    new KindInfo(NodeKindId.NKI_TagType, /*KEEP_STR*/"RecordType"), 
    new KindInfo(NodeKindId.NKI_TagType, /*KEEP_STR*/"EnumType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ElaboratedType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"AttributedType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"TemplateTypeParmType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"SubstTemplateTypeParmType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"SubstTemplateTypeParmPackType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"TemplateSpecializationType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"AutoType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"InjectedClassNameType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"DependentNameType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"DependentTemplateSpecializationType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"PackExpansionType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ObjCObjectType"), 
    new KindInfo(NodeKindId.NKI_ObjCObjectType, /*KEEP_STR*/"ObjCInterfaceType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"ObjCObjectPointerType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"PipeType"), 
    new KindInfo(NodeKindId.NKI_Type, /*KEEP_STR*/"AtomicType")
  };
  
  private NodeKindId KindId;
  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::ASTNodeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 46,
   FQN="clang::ast_type_traits::ASTNodeKind::ASTNodeKind", NM="_ZN5clang15ast_type_traits11ASTNodeKindC1ERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindC1ERKS1_")
  //</editor-fold>
  public /*inline*/ ASTNodeKind(final /*const*/ ASTNodeKind /*&*/ $Prm0) {
    // : KindId(.KindId) 
    //START JInit
    this.KindId = $Prm0.KindId;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::ASTNodeKind">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 46,
   FQN="clang::ast_type_traits::ASTNodeKind::ASTNodeKind", NM="_ZN5clang15ast_type_traits11ASTNodeKindC1EOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindC1EOS1_")
  //</editor-fold>
  public /*inline*/ ASTNodeKind(JD$Move _dparam, final ASTNodeKind /*&&*/$Prm0) {
    // : KindId(static_cast<ASTNodeKind &&>().KindId) 
    //START JInit
    this.KindId = $Prm0.KindId;
    //END JInit
  }

  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 46,
   FQN="clang::ast_type_traits::ASTNodeKind::operator=", NM="_ZN5clang15ast_type_traits11ASTNodeKindaSEOS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTTypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindaSEOS1_")
  //</editor-fold>
  public /*inline*/ ASTNodeKind /*&*/ $assignMove(final ASTNodeKind /*&&*/$Prm0) {
    this.KindId = $Prm0.KindId;
    return /*Deref*/this;
  }


  //<editor-fold defaultstate="collapsed" desc="clang::ast_type_traits::ASTNodeKind::operator=">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTTypeTraits.h", line = 46,
   FQN="clang::ast_type_traits::ASTNodeKind::operator=", NM="_ZN5clang15ast_type_traits11ASTNodeKindaSERKS1_",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/utils/TypeTraits.cpp -nm=_ZN5clang15ast_type_traits11ASTNodeKindaSERKS1_")
  //</editor-fold>
  public /*inline*/ ASTNodeKind /*&*/ $assign(final /*const*/ ASTNodeKind /*&*/ $Prm0) {
    this.KindId = $Prm0.KindId;
    return /*Deref*/this;
  }

  //////////////////////////////////////////////////////////////
  // EXTRA MEMBERS: BEGIN

  private static ASTNodeKind getFromNodeKindImplByClass(Class<?> clazz) {
    NodeKindId kind = AstKindToKindIdRegistry.Class2NodeKindId.get(clazz);
    if (kind == null) {
      throw new IllegalStateException("not registered kind-id for " + clazz);
    }
    return new ASTNodeKind(kind);
  }

  @Override public ASTNodeKind clone() {
    return new ASTNodeKind(this);
  }
  
  // EXTRA MEMBERS: END
  //////////////////////////////////////////////////////////////
  
  @Override public String toString() {
    return "" + "KindId=" + KindId; // NOI18N
  }
}
