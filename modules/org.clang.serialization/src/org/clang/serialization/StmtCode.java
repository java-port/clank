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

package org.clang.serialization;

import org.clank.support.*;


/// \brief Record codes for each kind of statement or expression.
///
/// These constants describe the records that describe statements
/// or expressions. These records  occur within type and declarations
/// block, so they begin with record values of 128.  Each constant 
/// describes a record for a specific statement or expression class in the
/// AST.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::StmtCode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1182,
 FQN="clang::serialization::StmtCode", NM="_ZN5clang13serialization8StmtCodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization8StmtCodeE")
//</editor-fold>
public final class/*enum*/ StmtCode {
  /// \brief A marker record that indicates that we are at the end
  /// of an expression.
  public static final int STMT_STOP = 128;
  /// \brief A NULL expression.
  public static final int STMT_NULL_PTR = STMT_STOP + 1;
  /// \brief A reference to a previously [de]serialized Stmt record.
  public static final int STMT_REF_PTR = STMT_NULL_PTR + 1;
  /// \brief A NullStmt record.
  public static final int STMT_NULL = STMT_REF_PTR + 1;
  /// \brief A CompoundStmt record.
  public static final int STMT_COMPOUND = STMT_NULL + 1;
  /// \brief A CaseStmt record.
  public static final int STMT_CASE = STMT_COMPOUND + 1;
  /// \brief A DefaultStmt record.
  public static final int STMT_DEFAULT = STMT_CASE + 1;
  /// \brief A LabelStmt record.
  public static final int STMT_LABEL = STMT_DEFAULT + 1;
  /// \brief An AttributedStmt record.
  public static final int STMT_ATTRIBUTED = STMT_LABEL + 1;
  /// \brief An IfStmt record.
  public static final int STMT_IF = STMT_ATTRIBUTED + 1;
  /// \brief A SwitchStmt record.
  public static final int STMT_SWITCH = STMT_IF + 1;
  /// \brief A WhileStmt record.
  public static final int STMT_WHILE = STMT_SWITCH + 1;
  /// \brief A DoStmt record.
  public static final int STMT_DO = STMT_WHILE + 1;
  /// \brief A ForStmt record.
  public static final int STMT_FOR = STMT_DO + 1;
  /// \brief A GotoStmt record.
  public static final int STMT_GOTO = STMT_FOR + 1;
  /// \brief An IndirectGotoStmt record.
  public static final int STMT_INDIRECT_GOTO = STMT_GOTO + 1;
  /// \brief A ContinueStmt record.
  public static final int STMT_CONTINUE = STMT_INDIRECT_GOTO + 1;
  /// \brief A BreakStmt record.
  public static final int STMT_BREAK = STMT_CONTINUE + 1;
  /// \brief A ReturnStmt record.
  public static final int STMT_RETURN = STMT_BREAK + 1;
  /// \brief A DeclStmt record.
  public static final int STMT_DECL = STMT_RETURN + 1;
  /// \brief A CapturedStmt record.
  public static final int STMT_CAPTURED = STMT_DECL + 1;
  /// \brief A GCC-style AsmStmt record.
  public static final int STMT_GCCASM = STMT_CAPTURED + 1;
  /// \brief A MS-style AsmStmt record.
  public static final int STMT_MSASM = STMT_GCCASM + 1;
  /// \brief A PredefinedExpr record.
  public static final int EXPR_PREDEFINED = STMT_MSASM + 1;
  /// \brief A DeclRefExpr record.
  public static final int EXPR_DECL_REF = EXPR_PREDEFINED + 1;
  /// \brief An IntegerLiteral record.
  public static final int EXPR_INTEGER_LITERAL = EXPR_DECL_REF + 1;
  /// \brief A FloatingLiteral record.
  public static final int EXPR_FLOATING_LITERAL = EXPR_INTEGER_LITERAL + 1;
  /// \brief An ImaginaryLiteral record.
  public static final int EXPR_IMAGINARY_LITERAL = EXPR_FLOATING_LITERAL + 1;
  /// \brief A StringLiteral record.
  public static final int EXPR_STRING_LITERAL = EXPR_IMAGINARY_LITERAL + 1;
  /// \brief A CharacterLiteral record.
  public static final int EXPR_CHARACTER_LITERAL = EXPR_STRING_LITERAL + 1;
  /// \brief A ParenExpr record.
  public static final int EXPR_PAREN = EXPR_CHARACTER_LITERAL + 1;
  /// \brief A ParenListExpr record.
  public static final int EXPR_PAREN_LIST = EXPR_PAREN + 1;
  /// \brief A UnaryOperator record.
  public static final int EXPR_UNARY_OPERATOR = EXPR_PAREN_LIST + 1;
  /// \brief An OffsetOfExpr record.
  public static final int EXPR_OFFSETOF = EXPR_UNARY_OPERATOR + 1;
  /// \brief A SizefAlignOfExpr record.
  public static final int EXPR_SIZEOF_ALIGN_OF = EXPR_OFFSETOF + 1;
  /// \brief An ArraySubscriptExpr record.
  public static final int EXPR_ARRAY_SUBSCRIPT = EXPR_SIZEOF_ALIGN_OF + 1;
  /// \brief A CallExpr record.
  public static final int EXPR_CALL = EXPR_ARRAY_SUBSCRIPT + 1;
  /// \brief A MemberExpr record.
  public static final int EXPR_MEMBER = EXPR_CALL + 1;
  /// \brief A BinaryOperator record.
  public static final int EXPR_BINARY_OPERATOR = EXPR_MEMBER + 1;
  /// \brief A CompoundAssignOperator record.
  public static final int EXPR_COMPOUND_ASSIGN_OPERATOR = EXPR_BINARY_OPERATOR + 1;
  /// \brief A ConditionOperator record.
  public static final int EXPR_CONDITIONAL_OPERATOR = EXPR_COMPOUND_ASSIGN_OPERATOR + 1;
  /// \brief An ImplicitCastExpr record.
  public static final int EXPR_IMPLICIT_CAST = EXPR_CONDITIONAL_OPERATOR + 1;
  /// \brief A CStyleCastExpr record.
  public static final int EXPR_CSTYLE_CAST = EXPR_IMPLICIT_CAST + 1;
  /// \brief A CompoundLiteralExpr record.
  public static final int EXPR_COMPOUND_LITERAL = EXPR_CSTYLE_CAST + 1;
  /// \brief An ExtVectorElementExpr record.
  public static final int EXPR_EXT_VECTOR_ELEMENT = EXPR_COMPOUND_LITERAL + 1;
  /// \brief An InitListExpr record.
  public static final int EXPR_INIT_LIST = EXPR_EXT_VECTOR_ELEMENT + 1;
  /// \brief A DesignatedInitExpr record.
  public static final int EXPR_DESIGNATED_INIT = EXPR_INIT_LIST + 1;
  /// \brief A DesignatedInitUpdateExpr record.
  public static final int EXPR_DESIGNATED_INIT_UPDATE = EXPR_DESIGNATED_INIT + 1;
  /// \brief An ImplicitValueInitExpr record.
  public static final int EXPR_IMPLICIT_VALUE_INIT = EXPR_DESIGNATED_INIT_UPDATE + 1;
  /// \brief An NoInitExpr record.
  public static final int EXPR_NO_INIT = EXPR_IMPLICIT_VALUE_INIT + 1;
  /// \brief A VAArgExpr record.
  public static final int EXPR_VA_ARG = EXPR_NO_INIT + 1;
  /// \brief An AddrLabelExpr record.
  public static final int EXPR_ADDR_LABEL = EXPR_VA_ARG + 1;
  /// \brief A StmtExpr record.
  public static final int EXPR_STMT = EXPR_ADDR_LABEL + 1;
  /// \brief A ChooseExpr record.
  public static final int EXPR_CHOOSE = EXPR_STMT + 1;
  /// \brief A GNUNullExpr record.
  public static final int EXPR_GNU_NULL = EXPR_CHOOSE + 1;
  /// \brief A ShuffleVectorExpr record.
  public static final int EXPR_SHUFFLE_VECTOR = EXPR_GNU_NULL + 1;
  /// \brief A ConvertVectorExpr record.
  public static final int EXPR_CONVERT_VECTOR = EXPR_SHUFFLE_VECTOR + 1;
  /// \brief BlockExpr
  public static final int EXPR_BLOCK = EXPR_CONVERT_VECTOR + 1;
  /// \brief A GenericSelectionExpr record.
  public static final int EXPR_GENERIC_SELECTION = EXPR_BLOCK + 1;
  /// \brief A PseudoObjectExpr record.
  public static final int EXPR_PSEUDO_OBJECT = EXPR_GENERIC_SELECTION + 1;
  /// \brief An AtomicExpr record.
  public static final int EXPR_ATOMIC = EXPR_PSEUDO_OBJECT + 1;
  
  // Objective-C
  
  /// \brief An ObjCStringLiteral record.
  public static final int EXPR_OBJC_STRING_LITERAL = EXPR_ATOMIC + 1;
  
  public static final int EXPR_OBJC_BOXED_EXPRESSION = EXPR_OBJC_STRING_LITERAL + 1;
  public static final int EXPR_OBJC_ARRAY_LITERAL = EXPR_OBJC_BOXED_EXPRESSION + 1;
  public static final int EXPR_OBJC_DICTIONARY_LITERAL = EXPR_OBJC_ARRAY_LITERAL + 1;
  
  /// \brief An ObjCEncodeExpr record.
  public static final int EXPR_OBJC_ENCODE = EXPR_OBJC_DICTIONARY_LITERAL + 1;
  /// \brief An ObjCSelectorExpr record.
  public static final int EXPR_OBJC_SELECTOR_EXPR = EXPR_OBJC_ENCODE + 1;
  /// \brief An ObjCProtocolExpr record.
  public static final int EXPR_OBJC_PROTOCOL_EXPR = EXPR_OBJC_SELECTOR_EXPR + 1;
  /// \brief An ObjCIvarRefExpr record.
  public static final int EXPR_OBJC_IVAR_REF_EXPR = EXPR_OBJC_PROTOCOL_EXPR + 1;
  /// \brief An ObjCPropertyRefExpr record.
  public static final int EXPR_OBJC_PROPERTY_REF_EXPR = EXPR_OBJC_IVAR_REF_EXPR + 1;
  /// \brief An ObjCSubscriptRefExpr record.
  public static final int EXPR_OBJC_SUBSCRIPT_REF_EXPR = EXPR_OBJC_PROPERTY_REF_EXPR + 1;
  /// \brief UNUSED
  public static final int EXPR_OBJC_KVC_REF_EXPR = EXPR_OBJC_SUBSCRIPT_REF_EXPR + 1;
  /// \brief An ObjCMessageExpr record.
  public static final int EXPR_OBJC_MESSAGE_EXPR = EXPR_OBJC_KVC_REF_EXPR + 1;
  /// \brief An ObjCIsa Expr record.
  public static final int EXPR_OBJC_ISA = EXPR_OBJC_MESSAGE_EXPR + 1;
  /// \brief An ObjCIndirectCopyRestoreExpr record.
  public static final int EXPR_OBJC_INDIRECT_COPY_RESTORE = EXPR_OBJC_ISA + 1;
  
  /// \brief An ObjCForCollectionStmt record.
  public static final int STMT_OBJC_FOR_COLLECTION = EXPR_OBJC_INDIRECT_COPY_RESTORE + 1;
  /// \brief An ObjCAtCatchStmt record.
  public static final int STMT_OBJC_CATCH = STMT_OBJC_FOR_COLLECTION + 1;
  /// \brief An ObjCAtFinallyStmt record.
  public static final int STMT_OBJC_FINALLY = STMT_OBJC_CATCH + 1;
  /// \brief An ObjCAtTryStmt record.
  public static final int STMT_OBJC_AT_TRY = STMT_OBJC_FINALLY + 1;
  /// \brief An ObjCAtSynchronizedStmt record.
  public static final int STMT_OBJC_AT_SYNCHRONIZED = STMT_OBJC_AT_TRY + 1;
  /// \brief An ObjCAtThrowStmt record.
  public static final int STMT_OBJC_AT_THROW = STMT_OBJC_AT_SYNCHRONIZED + 1;
  /// \brief An ObjCAutoreleasePoolStmt record.
  public static final int STMT_OBJC_AUTORELEASE_POOL = STMT_OBJC_AT_THROW + 1;
  /// \brief An ObjCBoolLiteralExpr record.
  public static final int EXPR_OBJC_BOOL_LITERAL = STMT_OBJC_AUTORELEASE_POOL + 1;
  /// \brief An ObjCAvailabilityCheckExpr record.
  public static final int EXPR_OBJC_AVAILABILITY_CHECK = EXPR_OBJC_BOOL_LITERAL + 1;
  
  // C++
  
  /// \brief A CXXCatchStmt record.
  public static final int STMT_CXX_CATCH = EXPR_OBJC_AVAILABILITY_CHECK + 1;
  /// \brief A CXXTryStmt record.
  public static final int STMT_CXX_TRY = STMT_CXX_CATCH + 1;
  /// \brief A CXXForRangeStmt record.
  public static final int STMT_CXX_FOR_RANGE = STMT_CXX_TRY + 1;
  
  /// \brief A CXXOperatorCallExpr record.
  public static final int EXPR_CXX_OPERATOR_CALL = STMT_CXX_FOR_RANGE + 1;
  /// \brief A CXXMemberCallExpr record.
  public static final int EXPR_CXX_MEMBER_CALL = EXPR_CXX_OPERATOR_CALL + 1;
  /// \brief A CXXConstructExpr record.
  public static final int EXPR_CXX_CONSTRUCT = EXPR_CXX_MEMBER_CALL + 1;
  /// \brief A CXXInheritedCtorInitExpr record.
  public static final int EXPR_CXX_INHERITED_CTOR_INIT = EXPR_CXX_CONSTRUCT + 1;
  /// \brief A CXXTemporaryObjectExpr record.
  public static final int EXPR_CXX_TEMPORARY_OBJECT = EXPR_CXX_INHERITED_CTOR_INIT + 1;
  /// \brief A CXXStaticCastExpr record.
  public static final int EXPR_CXX_STATIC_CAST = EXPR_CXX_TEMPORARY_OBJECT + 1;
  /// \brief A CXXDynamicCastExpr record.
  public static final int EXPR_CXX_DYNAMIC_CAST = EXPR_CXX_STATIC_CAST + 1;
  /// \brief A CXXReinterpretCastExpr record.
  public static final int EXPR_CXX_REINTERPRET_CAST = EXPR_CXX_DYNAMIC_CAST + 1;
  /// \brief A CXXConstCastExpr record.
  public static final int EXPR_CXX_CONST_CAST = EXPR_CXX_REINTERPRET_CAST + 1;
  /// \brief A CXXFunctionalCastExpr record.
  public static final int EXPR_CXX_FUNCTIONAL_CAST = EXPR_CXX_CONST_CAST + 1;
  /// \brief A UserDefinedLiteral record.
  public static final int EXPR_USER_DEFINED_LITERAL = EXPR_CXX_FUNCTIONAL_CAST + 1;
  /// \brief A CXXStdInitializerListExpr record.
  public static final int EXPR_CXX_STD_INITIALIZER_LIST = EXPR_USER_DEFINED_LITERAL + 1;
  /// \brief A CXXBoolLiteralExpr record.
  public static final int EXPR_CXX_BOOL_LITERAL = EXPR_CXX_STD_INITIALIZER_LIST + 1;
  public static final int EXPR_CXX_NULL_PTR_LITERAL = EXPR_CXX_BOOL_LITERAL + 1; // CXXNullPtrLiteralExpr
  public static final int EXPR_CXX_TYPEID_EXPR = EXPR_CXX_NULL_PTR_LITERAL + 1; // CXXTypeidExpr (of expr).
  public static final int EXPR_CXX_TYPEID_TYPE = EXPR_CXX_TYPEID_EXPR + 1; // CXXTypeidExpr (of type).
  public static final int EXPR_CXX_THIS = EXPR_CXX_TYPEID_TYPE + 1; // CXXThisExpr
  public static final int EXPR_CXX_THROW = EXPR_CXX_THIS + 1; // CXXThrowExpr
  public static final int EXPR_CXX_DEFAULT_ARG = EXPR_CXX_THROW + 1; // CXXDefaultArgExpr
  public static final int EXPR_CXX_DEFAULT_INIT = EXPR_CXX_DEFAULT_ARG + 1; // CXXDefaultInitExpr
  public static final int EXPR_CXX_BIND_TEMPORARY = EXPR_CXX_DEFAULT_INIT + 1; // CXXBindTemporaryExpr
  
  public static final int EXPR_CXX_SCALAR_VALUE_INIT = EXPR_CXX_BIND_TEMPORARY + 1; // CXXScalarValueInitExpr
  public static final int EXPR_CXX_NEW = EXPR_CXX_SCALAR_VALUE_INIT + 1; // CXXNewExpr
  public static final int EXPR_CXX_DELETE = EXPR_CXX_NEW + 1; // CXXDeleteExpr
  public static final int EXPR_CXX_PSEUDO_DESTRUCTOR = EXPR_CXX_DELETE + 1; // CXXPseudoDestructorExpr
  
  public static final int EXPR_EXPR_WITH_CLEANUPS = EXPR_CXX_PSEUDO_DESTRUCTOR + 1; // ExprWithCleanups
  
  public static final int EXPR_CXX_DEPENDENT_SCOPE_MEMBER = EXPR_EXPR_WITH_CLEANUPS + 1; // CXXDependentScopeMemberExpr
  public static final int EXPR_CXX_DEPENDENT_SCOPE_DECL_REF = EXPR_CXX_DEPENDENT_SCOPE_MEMBER + 1; // DependentScopeDeclRefExpr
  public static final int EXPR_CXX_UNRESOLVED_CONSTRUCT = EXPR_CXX_DEPENDENT_SCOPE_DECL_REF + 1; // CXXUnresolvedConstructExpr
  public static final int EXPR_CXX_UNRESOLVED_MEMBER = EXPR_CXX_UNRESOLVED_CONSTRUCT + 1; // UnresolvedMemberExpr
  public static final int EXPR_CXX_UNRESOLVED_LOOKUP = EXPR_CXX_UNRESOLVED_MEMBER + 1; // UnresolvedLookupExpr
  
  public static final int EXPR_CXX_EXPRESSION_TRAIT = EXPR_CXX_UNRESOLVED_LOOKUP + 1; // ExpressionTraitExpr
  public static final int EXPR_CXX_NOEXCEPT = EXPR_CXX_EXPRESSION_TRAIT + 1; // CXXNoexceptExpr
  
  public static final int EXPR_OPAQUE_VALUE = EXPR_CXX_NOEXCEPT + 1; // OpaqueValueExpr
  public static final int EXPR_BINARY_CONDITIONAL_OPERATOR = EXPR_OPAQUE_VALUE + 1; // BinaryConditionalOperator
  public static final int EXPR_TYPE_TRAIT = EXPR_BINARY_CONDITIONAL_OPERATOR + 1; // TypeTraitExpr
  public static final int EXPR_ARRAY_TYPE_TRAIT = EXPR_TYPE_TRAIT + 1; // ArrayTypeTraitIntExpr
  
  public static final int EXPR_PACK_EXPANSION = EXPR_ARRAY_TYPE_TRAIT + 1; // PackExpansionExpr
  public static final int EXPR_SIZEOF_PACK = EXPR_PACK_EXPANSION + 1; // SizeOfPackExpr
  public static final int EXPR_SUBST_NON_TYPE_TEMPLATE_PARM = EXPR_SIZEOF_PACK + 1; // SubstNonTypeTemplateParmExpr
  public static final int EXPR_SUBST_NON_TYPE_TEMPLATE_PARM_PACK = EXPR_SUBST_NON_TYPE_TEMPLATE_PARM + 1; // SubstNonTypeTemplateParmPackExpr
  public static final int EXPR_FUNCTION_PARM_PACK = EXPR_SUBST_NON_TYPE_TEMPLATE_PARM_PACK + 1; // FunctionParmPackExpr
  public static final int EXPR_MATERIALIZE_TEMPORARY = EXPR_FUNCTION_PARM_PACK + 1; // MaterializeTemporaryExpr
  public static final int EXPR_CXX_FOLD = EXPR_MATERIALIZE_TEMPORARY + 1; // CXXFoldExpr
  
  // CUDA
  public static final int EXPR_CUDA_KERNEL_CALL = EXPR_CXX_FOLD + 1; // CUDAKernelCallExpr      
  
  // OpenCL
  public static final int EXPR_ASTYPE = EXPR_CUDA_KERNEL_CALL + 1; // AsTypeExpr
  
  // Microsoft
  public static final int EXPR_CXX_PROPERTY_REF_EXPR = EXPR_ASTYPE + 1; // MSPropertyRefExpr
  public static final int EXPR_CXX_PROPERTY_SUBSCRIPT_EXPR = EXPR_CXX_PROPERTY_REF_EXPR + 1; // MSPropertySubscriptExpr
  public static final int EXPR_CXX_UUIDOF_EXPR = EXPR_CXX_PROPERTY_SUBSCRIPT_EXPR + 1; // CXXUuidofExpr (of expr).
  public static final int EXPR_CXX_UUIDOF_TYPE = EXPR_CXX_UUIDOF_EXPR + 1; // CXXUuidofExpr (of type).
  public static final int STMT_SEH_LEAVE = EXPR_CXX_UUIDOF_TYPE + 1; // SEHLeaveStmt
  public static final int STMT_SEH_EXCEPT = STMT_SEH_LEAVE + 1; // SEHExceptStmt
  public static final int STMT_SEH_FINALLY = STMT_SEH_EXCEPT + 1; // SEHFinallyStmt
  public static final int STMT_SEH_TRY = STMT_SEH_FINALLY + 1; // SEHTryStmt
  
  // OpenMP directives
  public static final int STMT_OMP_PARALLEL_DIRECTIVE = STMT_SEH_TRY + 1;
  public static final int STMT_OMP_SIMD_DIRECTIVE = STMT_OMP_PARALLEL_DIRECTIVE + 1;
  public static final int STMT_OMP_FOR_DIRECTIVE = STMT_OMP_SIMD_DIRECTIVE + 1;
  public static final int STMT_OMP_FOR_SIMD_DIRECTIVE = STMT_OMP_FOR_DIRECTIVE + 1;
  public static final int STMT_OMP_SECTIONS_DIRECTIVE = STMT_OMP_FOR_SIMD_DIRECTIVE + 1;
  public static final int STMT_OMP_SECTION_DIRECTIVE = STMT_OMP_SECTIONS_DIRECTIVE + 1;
  public static final int STMT_OMP_SINGLE_DIRECTIVE = STMT_OMP_SECTION_DIRECTIVE + 1;
  public static final int STMT_OMP_MASTER_DIRECTIVE = STMT_OMP_SINGLE_DIRECTIVE + 1;
  public static final int STMT_OMP_CRITICAL_DIRECTIVE = STMT_OMP_MASTER_DIRECTIVE + 1;
  public static final int STMT_OMP_PARALLEL_FOR_DIRECTIVE = STMT_OMP_CRITICAL_DIRECTIVE + 1;
  public static final int STMT_OMP_PARALLEL_FOR_SIMD_DIRECTIVE = STMT_OMP_PARALLEL_FOR_DIRECTIVE + 1;
  public static final int STMT_OMP_PARALLEL_SECTIONS_DIRECTIVE = STMT_OMP_PARALLEL_FOR_SIMD_DIRECTIVE + 1;
  public static final int STMT_OMP_TASK_DIRECTIVE = STMT_OMP_PARALLEL_SECTIONS_DIRECTIVE + 1;
  public static final int STMT_OMP_TASKYIELD_DIRECTIVE = STMT_OMP_TASK_DIRECTIVE + 1;
  public static final int STMT_OMP_BARRIER_DIRECTIVE = STMT_OMP_TASKYIELD_DIRECTIVE + 1;
  public static final int STMT_OMP_TASKWAIT_DIRECTIVE = STMT_OMP_BARRIER_DIRECTIVE + 1;
  public static final int STMT_OMP_FLUSH_DIRECTIVE = STMT_OMP_TASKWAIT_DIRECTIVE + 1;
  public static final int STMT_OMP_ORDERED_DIRECTIVE = STMT_OMP_FLUSH_DIRECTIVE + 1;
  public static final int STMT_OMP_ATOMIC_DIRECTIVE = STMT_OMP_ORDERED_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_DIRECTIVE = STMT_OMP_ATOMIC_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_DATA_DIRECTIVE = STMT_OMP_TARGET_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_ENTER_DATA_DIRECTIVE = STMT_OMP_TARGET_DATA_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_EXIT_DATA_DIRECTIVE = STMT_OMP_TARGET_ENTER_DATA_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_PARALLEL_DIRECTIVE = STMT_OMP_TARGET_EXIT_DATA_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_PARALLEL_FOR_DIRECTIVE = STMT_OMP_TARGET_PARALLEL_DIRECTIVE + 1;
  public static final int STMT_OMP_TEAMS_DIRECTIVE = STMT_OMP_TARGET_PARALLEL_FOR_DIRECTIVE + 1;
  public static final int STMT_OMP_TASKGROUP_DIRECTIVE = STMT_OMP_TEAMS_DIRECTIVE + 1;
  public static final int STMT_OMP_CANCELLATION_POINT_DIRECTIVE = STMT_OMP_TASKGROUP_DIRECTIVE + 1;
  public static final int STMT_OMP_CANCEL_DIRECTIVE = STMT_OMP_CANCELLATION_POINT_DIRECTIVE + 1;
  public static final int STMT_OMP_TASKLOOP_DIRECTIVE = STMT_OMP_CANCEL_DIRECTIVE + 1;
  public static final int STMT_OMP_TASKLOOP_SIMD_DIRECTIVE = STMT_OMP_TASKLOOP_DIRECTIVE + 1;
  public static final int STMT_OMP_DISTRIBUTE_DIRECTIVE = STMT_OMP_TASKLOOP_SIMD_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_UPDATE_DIRECTIVE = STMT_OMP_DISTRIBUTE_DIRECTIVE + 1;
  public static final int STMT_OMP_DISTRIBUTE_PARALLEL_FOR_DIRECTIVE = STMT_OMP_TARGET_UPDATE_DIRECTIVE + 1;
  public static final int STMT_OMP_DISTRIBUTE_PARALLEL_FOR_SIMD_DIRECTIVE = STMT_OMP_DISTRIBUTE_PARALLEL_FOR_DIRECTIVE + 1;
  public static final int STMT_OMP_DISTRIBUTE_SIMD_DIRECTIVE = STMT_OMP_DISTRIBUTE_PARALLEL_FOR_SIMD_DIRECTIVE + 1;
  public static final int STMT_OMP_TARGET_PARALLEL_FOR_SIMD_DIRECTIVE = STMT_OMP_DISTRIBUTE_SIMD_DIRECTIVE + 1;
  public static final int EXPR_OMP_ARRAY_SECTION = STMT_OMP_TARGET_PARALLEL_FOR_SIMD_DIRECTIVE + 1;
  
  // ARC
  public static final int EXPR_OBJC_BRIDGED_CAST = EXPR_OMP_ARRAY_SECTION + 1; // ObjCBridgedCastExpr
  
  public static final int STMT_MS_DEPENDENT_EXISTS = EXPR_OBJC_BRIDGED_CAST + 1; // MSDependentExistsStmt
  public static final int EXPR_LAMBDA = STMT_MS_DEPENDENT_EXISTS + 1; // LambdaExpr
}
