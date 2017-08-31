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


/// \brief Record codes for each kind of declaration.
///
/// These constants describe the declaration records that can occur within
/// a declarations block (identified by DECLTYPES_BLOCK_ID). Each
/// constant describes a record for a specific declaration class
/// in the AST. Note that TypeCode values share this code space.
//<editor-fold defaultstate="collapsed" desc="clang::serialization::DeclCode">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Serialization/ASTBitCodes.h", line = 1011,
 FQN="clang::serialization::DeclCode", NM="_ZN5clang13serialization8DeclCodeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.serialization/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Serialization/ASTCommon.cpp -nm=_ZN5clang13serialization8DeclCodeE")
//</editor-fold>
public final class/*enum*/ DeclCode {
  /// \brief A TypedefDecl record.
  public static final int DECL_TYPEDEF = 51;
  /// \brief A TypeAliasDecl record.
  public static final int DECL_TYPEALIAS = DECL_TYPEDEF + 1;
  /// \brief An EnumDecl record.
  public static final int DECL_ENUM = DECL_TYPEALIAS + 1;
  /// \brief A RecordDecl record.
  public static final int DECL_RECORD = DECL_ENUM + 1;
  /// \brief An EnumConstantDecl record.
  public static final int DECL_ENUM_CONSTANT = DECL_RECORD + 1;
  /// \brief A FunctionDecl record.
  public static final int DECL_FUNCTION = DECL_ENUM_CONSTANT + 1;
  /// \brief A ObjCMethodDecl record.
  public static final int DECL_OBJC_METHOD = DECL_FUNCTION + 1;
  /// \brief A ObjCInterfaceDecl record.
  public static final int DECL_OBJC_INTERFACE = DECL_OBJC_METHOD + 1;
  /// \brief A ObjCProtocolDecl record.
  public static final int DECL_OBJC_PROTOCOL = DECL_OBJC_INTERFACE + 1;
  /// \brief A ObjCIvarDecl record.
  public static final int DECL_OBJC_IVAR = DECL_OBJC_PROTOCOL + 1;
  /// \brief A ObjCAtDefsFieldDecl record.
  public static final int DECL_OBJC_AT_DEFS_FIELD = DECL_OBJC_IVAR + 1;
  /// \brief A ObjCCategoryDecl record.
  public static final int DECL_OBJC_CATEGORY = DECL_OBJC_AT_DEFS_FIELD + 1;
  /// \brief A ObjCCategoryImplDecl record.
  public static final int DECL_OBJC_CATEGORY_IMPL = DECL_OBJC_CATEGORY + 1;
  /// \brief A ObjCImplementationDecl record.
  public static final int DECL_OBJC_IMPLEMENTATION = DECL_OBJC_CATEGORY_IMPL + 1;
  /// \brief A ObjCCompatibleAliasDecl record.
  public static final int DECL_OBJC_COMPATIBLE_ALIAS = DECL_OBJC_IMPLEMENTATION + 1;
  /// \brief A ObjCPropertyDecl record.
  public static final int DECL_OBJC_PROPERTY = DECL_OBJC_COMPATIBLE_ALIAS + 1;
  /// \brief A ObjCPropertyImplDecl record.
  public static final int DECL_OBJC_PROPERTY_IMPL = DECL_OBJC_PROPERTY + 1;
  /// \brief A FieldDecl record.
  public static final int DECL_FIELD = DECL_OBJC_PROPERTY_IMPL + 1;
  /// \brief A MSPropertyDecl record.
  public static final int DECL_MS_PROPERTY = DECL_FIELD + 1;
  /// \brief A VarDecl record.
  public static final int DECL_VAR = DECL_MS_PROPERTY + 1;
  /// \brief An ImplicitParamDecl record.
  public static final int DECL_IMPLICIT_PARAM = DECL_VAR + 1;
  /// \brief A ParmVarDecl record.
  public static final int DECL_PARM_VAR = DECL_IMPLICIT_PARAM + 1;
  /// \brief A FileScopeAsmDecl record.
  public static final int DECL_FILE_SCOPE_ASM = DECL_PARM_VAR + 1;
  /// \brief A BlockDecl record.
  public static final int DECL_BLOCK = DECL_FILE_SCOPE_ASM + 1;
  /// \brief A CapturedDecl record.
  public static final int DECL_CAPTURED = DECL_BLOCK + 1;
  /// \brief A record that stores the set of declarations that are
  /// lexically stored within a given DeclContext.
  ///
  /// The record itself is a blob that is an array of declaration IDs,
  /// in the order in which those declarations were added to the
  /// declaration context. This data is used when iterating over
  /// the contents of a DeclContext, e.g., via
  /// DeclContext::decls_begin() and DeclContext::decls_end().
  public static final int DECL_CONTEXT_LEXICAL = DECL_CAPTURED + 1;
  /// \brief A record that stores the set of declarations that are
  /// visible from a given DeclContext.
  ///
  /// The record itself stores a set of mappings, each of which
  /// associates a declaration name with one or more declaration
  /// IDs. This data is used when performing qualified name lookup
  /// into a DeclContext via DeclContext::lookup.
  public static final int DECL_CONTEXT_VISIBLE = DECL_CONTEXT_LEXICAL + 1;
  /// \brief A LabelDecl record.
  public static final int DECL_LABEL = DECL_CONTEXT_VISIBLE + 1;
  /// \brief A NamespaceDecl record.
  public static final int DECL_NAMESPACE = DECL_LABEL + 1;
  /// \brief A NamespaceAliasDecl record.
  public static final int DECL_NAMESPACE_ALIAS = DECL_NAMESPACE + 1;
  /// \brief A UsingDecl record.
  public static final int DECL_USING = DECL_NAMESPACE_ALIAS + 1;
  /// \brief A UsingShadowDecl record.
  public static final int DECL_USING_SHADOW = DECL_USING + 1;
  /// \brief A ConstructorUsingShadowDecl record.
  public static final int DECL_CONSTRUCTOR_USING_SHADOW = DECL_USING_SHADOW + 1;
  /// \brief A UsingDirecitveDecl record.
  public static final int DECL_USING_DIRECTIVE = DECL_CONSTRUCTOR_USING_SHADOW + 1;
  /// \brief An UnresolvedUsingValueDecl record.
  public static final int DECL_UNRESOLVED_USING_VALUE = DECL_USING_DIRECTIVE + 1;
  /// \brief An UnresolvedUsingTypenameDecl record.
  public static final int DECL_UNRESOLVED_USING_TYPENAME = DECL_UNRESOLVED_USING_VALUE + 1;
  /// \brief A LinkageSpecDecl record.
  public static final int DECL_LINKAGE_SPEC = DECL_UNRESOLVED_USING_TYPENAME + 1;
  /// \brief A CXXRecordDecl record.
  public static final int DECL_CXX_RECORD = DECL_LINKAGE_SPEC + 1;
  /// \brief A CXXMethodDecl record.
  public static final int DECL_CXX_METHOD = DECL_CXX_RECORD + 1;
  /// \brief A CXXConstructorDecl record.
  public static final int DECL_CXX_CONSTRUCTOR = DECL_CXX_METHOD + 1;
  /// \brief A CXXConstructorDecl record for an inherited constructor.
  public static final int DECL_CXX_INHERITED_CONSTRUCTOR = DECL_CXX_CONSTRUCTOR + 1;
  /// \brief A CXXDestructorDecl record.
  public static final int DECL_CXX_DESTRUCTOR = DECL_CXX_INHERITED_CONSTRUCTOR + 1;
  /// \brief A CXXConversionDecl record.
  public static final int DECL_CXX_CONVERSION = DECL_CXX_DESTRUCTOR + 1;
  /// \brief An AccessSpecDecl record.
  public static final int DECL_ACCESS_SPEC = DECL_CXX_CONVERSION + 1;
  
  /// \brief A FriendDecl record.
  public static final int DECL_FRIEND = DECL_ACCESS_SPEC + 1;
  /// \brief A FriendTemplateDecl record.
  public static final int DECL_FRIEND_TEMPLATE = DECL_FRIEND + 1;
  /// \brief A ClassTemplateDecl record.
  public static final int DECL_CLASS_TEMPLATE = DECL_FRIEND_TEMPLATE + 1;
  /// \brief A ClassTemplateSpecializationDecl record.
  public static final int DECL_CLASS_TEMPLATE_SPECIALIZATION = DECL_CLASS_TEMPLATE + 1;
  /// \brief A ClassTemplatePartialSpecializationDecl record.
  public static final int DECL_CLASS_TEMPLATE_PARTIAL_SPECIALIZATION = DECL_CLASS_TEMPLATE_SPECIALIZATION + 1;
  /// \brief A VarTemplateDecl record.
  public static final int DECL_VAR_TEMPLATE = DECL_CLASS_TEMPLATE_PARTIAL_SPECIALIZATION + 1;
  /// \brief A VarTemplateSpecializationDecl record.
  public static final int DECL_VAR_TEMPLATE_SPECIALIZATION = DECL_VAR_TEMPLATE + 1;
  /// \brief A VarTemplatePartialSpecializationDecl record.
  public static final int DECL_VAR_TEMPLATE_PARTIAL_SPECIALIZATION = DECL_VAR_TEMPLATE_SPECIALIZATION + 1;
  /// \brief A FunctionTemplateDecl record.
  public static final int DECL_FUNCTION_TEMPLATE = DECL_VAR_TEMPLATE_PARTIAL_SPECIALIZATION + 1;
  /// \brief A TemplateTypeParmDecl record.
  public static final int DECL_TEMPLATE_TYPE_PARM = DECL_FUNCTION_TEMPLATE + 1;
  /// \brief A NonTypeTemplateParmDecl record.
  public static final int DECL_NON_TYPE_TEMPLATE_PARM = DECL_TEMPLATE_TYPE_PARM + 1;
  /// \brief A TemplateTemplateParmDecl record.
  public static final int DECL_TEMPLATE_TEMPLATE_PARM = DECL_NON_TYPE_TEMPLATE_PARM + 1;
  /// \brief A TypeAliasTemplateDecl record.
  public static final int DECL_TYPE_ALIAS_TEMPLATE = DECL_TEMPLATE_TEMPLATE_PARM + 1;
  /// \brief A StaticAssertDecl record.
  public static final int DECL_STATIC_ASSERT = DECL_TYPE_ALIAS_TEMPLATE + 1;
  /// \brief A record containing CXXBaseSpecifiers.
  public static final int DECL_CXX_BASE_SPECIFIERS = DECL_STATIC_ASSERT + 1;
  /// \brief A record containing CXXCtorInitializers.
  public static final int DECL_CXX_CTOR_INITIALIZERS = DECL_CXX_BASE_SPECIFIERS + 1;
  /// \brief A IndirectFieldDecl record.
  public static final int DECL_INDIRECTFIELD = DECL_CXX_CTOR_INITIALIZERS + 1;
  /// \brief A NonTypeTemplateParmDecl record that stores an expanded
  /// non-type template parameter pack.
  public static final int DECL_EXPANDED_NON_TYPE_TEMPLATE_PARM_PACK = DECL_INDIRECTFIELD + 1;
  /// \brief A TemplateTemplateParmDecl record that stores an expanded
  /// template template parameter pack.
  public static final int DECL_EXPANDED_TEMPLATE_TEMPLATE_PARM_PACK = DECL_EXPANDED_NON_TYPE_TEMPLATE_PARM_PACK + 1;
  /// \brief A ClassScopeFunctionSpecializationDecl record a class scope
  /// function specialization. (Microsoft extension).
  public static final int DECL_CLASS_SCOPE_FUNCTION_SPECIALIZATION = DECL_EXPANDED_TEMPLATE_TEMPLATE_PARM_PACK + 1;
  /// \brief An ImportDecl recording a module import.
  public static final int DECL_IMPORT = DECL_CLASS_SCOPE_FUNCTION_SPECIALIZATION + 1;
  /// \brief An OMPThreadPrivateDecl record.
  public static final int DECL_OMP_THREADPRIVATE = DECL_IMPORT + 1;
  /// \brief An EmptyDecl record.
  public static final int DECL_EMPTY = DECL_OMP_THREADPRIVATE + 1;
  /// \brief An ObjCTypeParamDecl record.
  public static final int DECL_OBJC_TYPE_PARAM = DECL_EMPTY + 1;
  /// \brief An OMPCapturedExprDecl record.
  public static final int DECL_OMP_CAPTUREDEXPR = DECL_OBJC_TYPE_PARAM + 1;
  /// \brief A PragmaCommentDecl record.
  public static final int DECL_PRAGMA_COMMENT = DECL_OMP_CAPTUREDEXPR + 1;
  /// \brief A PragmaDetectMismatchDecl record.
  public static final int DECL_PRAGMA_DETECT_MISMATCH = DECL_PRAGMA_COMMENT + 1;
  /// \brief An OMPDeclareReductionDecl record.
  public static final int DECL_OMP_DECLARE_REDUCTION = DECL_PRAGMA_DETECT_MISMATCH + 1;
}
