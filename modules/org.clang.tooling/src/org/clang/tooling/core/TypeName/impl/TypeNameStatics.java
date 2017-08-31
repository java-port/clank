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
package org.clang.tooling.core.TypeName.impl;

import org.clank.support.*;
import org.clang.ast.*;


//<editor-fold defaultstate="collapsed" desc="static type TypeNameStatics">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -empty-body -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL14createOuterNNSERKNS_10ASTContextEPKNS_4DeclEbb;_ZN5clang8TypeNameL21getFullyQualifiedTypeENS_8QualTypeERKNS_10ASTContextEb;_ZN5clang8TypeNameL25createNestedNameSpecifierERKNS_10ASTContextEPKNS_13NamespaceDeclEb;_ZN5clang8TypeNameL25createNestedNameSpecifierERKNS_10ASTContextEPKNS_8TypeDeclEbb;_ZN5clang8TypeNameL29getFullyQualifiedTemplateNameERKNS_10ASTContextERNS_12TemplateNameEb;_ZN5clang8TypeNameL29getFullyQualifiedTemplateTypeERKNS_10ASTContextEPKNS_4TypeEb;_ZN5clang8TypeNameL33getFullyQualifiedTemplateArgumentERKNS_10ASTContextERNS_16TemplateArgumentEb;_ZN5clang8TypeNameL35createNestedNameSpecifierForScopeOfERKNS_10ASTContextEPKNS_4DeclEbb;_ZN5clang8TypeNameL35createNestedNameSpecifierForScopeOfERKNS_10ASTContextEPKNS_4TypeEbb;_ZN5clang8TypeNameL36getFullyQualifiedNestedNameSpecifierERKNS_10ASTContextEPNS_19NestedNameSpecifierEb; -static-type=TypeNameStatics -package=org.clang.tooling.core.TypeName.impl")
//</editor-fold>
public final class TypeNameStatics {

/// \brief Generates a QualType that can be used to name the same type
/// if used at the end of the current translation unit. This ignores
/// issues such as type shadowing.
///
/// \param[in] QT - the type for which the fully qualified type will be
/// returned.
/// \param[in] Ctx - the ASTContext to be used.
/// \param[in] WithGlobalNsPrefix - Indicate whether the global namespace
/// specifier "::" should be prepended or not.

/// \brief Return the fully qualified type, including fully-qualified
/// versions of any template parameters.
//<editor-fold defaultstate="collapsed" desc="clang::TypeName::getFullyQualifiedType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 384,
 FQN="clang::TypeName::getFullyQualifiedType", NM="_ZN5clang8TypeNameL21getFullyQualifiedTypeENS_8QualTypeERKNS_10ASTContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL21getFullyQualifiedTypeENS_8QualTypeERKNS_10ASTContextEb")
//</editor-fold>
public static QualType getFullyQualifiedType(QualType QT, final /*const*/ ASTContext /*&*/ Ctx, 
                     boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Create a NestedNameSpecifier for Namesp and its enclosing
/// scopes.
///
/// \param[in] Ctx - the AST Context to be used.
/// \param[in] Namesp - the NamespaceDecl for which a NestedNameSpecifier
/// is requested.
/// \param[in] WithGlobalNsPrefix - Indicate whether the global namespace
/// specifier "::" should be prepended or not.
//<editor-fold defaultstate="collapsed" desc="clang::TypeName::createNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 355,
 FQN="clang::TypeName::createNestedNameSpecifier", NM="_ZN5clang8TypeNameL25createNestedNameSpecifierERKNS_10ASTContextEPKNS_13NamespaceDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL25createNestedNameSpecifierERKNS_10ASTContextEPKNS_13NamespaceDeclEb")
//</editor-fold>
public static NestedNameSpecifier /*P*/ createNestedNameSpecifier(final /*const*/ ASTContext /*&*/ Ctx, 
                         /*const*/ NamespaceDecl /*P*/ Namespace, 
                         boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Create a NestedNameSpecifier for TagDecl and its enclosing
/// scopes.
///
/// \param[in] Ctx - the AST Context to be used.
/// \param[in] TD - the TagDecl for which a NestedNameSpecifier is
/// requested.
/// \param[in] FullyQualify - Convert all template arguments into fully
/// qualified names.
/// \param[in] WithGlobalNsPrefix - Indicate whether the global namespace
/// specifier "::" should be prepended or not.
//<editor-fold defaultstate="collapsed" desc="clang::TypeName::createNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 371,
 FQN="clang::TypeName::createNestedNameSpecifier", NM="_ZN5clang8TypeNameL25createNestedNameSpecifierERKNS_10ASTContextEPKNS_8TypeDeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL25createNestedNameSpecifierERKNS_10ASTContextEPKNS_8TypeDeclEbb")
//</editor-fold>
public static NestedNameSpecifier /*P*/ createNestedNameSpecifier(final /*const*/ ASTContext /*&*/ Ctx, 
                         /*const*/ TypeDecl /*P*/ TD, 
                         boolean FullyQualify, 
                         boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Create a nested name specifier for the declaring context of
/// the type.
//<editor-fold defaultstate="collapsed" desc="clang::TypeName::createNestedNameSpecifierForScopeOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 280,
 FQN="clang::TypeName::createNestedNameSpecifierForScopeOf", NM="_ZN5clang8TypeNameL35createNestedNameSpecifierForScopeOfERKNS_10ASTContextEPKNS_4DeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL35createNestedNameSpecifierForScopeOfERKNS_10ASTContextEPKNS_4DeclEbb")
//</editor-fold>
public static NestedNameSpecifier /*P*/ createNestedNameSpecifierForScopeOf(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Decl /*P*/ Decl, 
                                   boolean FullyQualified, boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Return a fully qualified version of this name specifier.
//<editor-fold defaultstate="collapsed" desc="clang::TypeName::getFullyQualifiedNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 227,
 FQN="clang::TypeName::getFullyQualifiedNestedNameSpecifier", NM="_ZN5clang8TypeNameL36getFullyQualifiedNestedNameSpecifierERKNS_10ASTContextEPNS_19NestedNameSpecifierEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL36getFullyQualifiedNestedNameSpecifierERKNS_10ASTContextEPNS_19NestedNameSpecifierEb")
//</editor-fold>
public static NestedNameSpecifier /*P*/ getFullyQualifiedNestedNameSpecifier(final /*const*/ ASTContext /*&*/ Ctx, NestedNameSpecifier /*P*/ Scope, 
                                    boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::TypeName::getFullyQualifiedTemplateName">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 72,
 FQN="clang::TypeName::getFullyQualifiedTemplateName", NM="_ZN5clang8TypeNameL29getFullyQualifiedTemplateNameERKNS_10ASTContextERNS_12TemplateNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL29getFullyQualifiedTemplateNameERKNS_10ASTContextERNS_12TemplateNameEb")
//</editor-fold>
public static boolean getFullyQualifiedTemplateName(final /*const*/ ASTContext /*&*/ Ctx, 
                             final TemplateName /*&*/ TName, 
                             boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::TypeName::getFullyQualifiedTemplateArgument">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 106,
 FQN="clang::TypeName::getFullyQualifiedTemplateArgument", NM="_ZN5clang8TypeNameL33getFullyQualifiedTemplateArgumentERKNS_10ASTContextERNS_16TemplateArgumentEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL33getFullyQualifiedTemplateArgumentERKNS_10ASTContextERNS_16TemplateArgumentEb")
//</editor-fold>
public static boolean getFullyQualifiedTemplateArgument(final /*const*/ ASTContext /*&*/ Ctx, 
                                 final TemplateArgument /*&*/ Arg, 
                                 boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::TypeName::getFullyQualifiedTemplateType">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 132,
 FQN="clang::TypeName::getFullyQualifiedTemplateType", NM="_ZN5clang8TypeNameL29getFullyQualifiedTemplateTypeERKNS_10ASTContextEPKNS_4TypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL29getFullyQualifiedTemplateTypeERKNS_10ASTContextEPKNS_4TypeEb")
//</editor-fold>
public static /*const*/ Type /*P*/ getFullyQualifiedTemplateType(final /*const*/ ASTContext /*&*/ Ctx, 
                             /*const*/ Type /*P*/ TypePtr, 
                             boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}

//<editor-fold defaultstate="collapsed" desc="clang::TypeName::createOuterNNS">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 202,
 FQN="clang::TypeName::createOuterNNS", NM="_ZN5clang8TypeNameL14createOuterNNSERKNS_10ASTContextEPKNS_4DeclEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL14createOuterNNSERKNS_10ASTContextEPKNS_4DeclEbb")
//</editor-fold>
public static NestedNameSpecifier /*P*/ createOuterNNS(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Decl /*P*/ D, 
              boolean FullyQualify, 
              boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}


/// \brief Create a nested name specifier for the declaring context of
/// the type.
//<editor-fold defaultstate="collapsed" desc="clang::TypeName::createNestedNameSpecifierForScopeOf">
@Converted(kind = Converted.Kind.AUTO_NO_BODY,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp", line = 332,
 FQN="clang::TypeName::createNestedNameSpecifierForScopeOf", NM="_ZN5clang8TypeNameL35createNestedNameSpecifierForScopeOfERKNS_10ASTContextEPKNS_4TypeEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.tooling/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/Core/QualTypeNames.cpp -nm=_ZN5clang8TypeNameL35createNestedNameSpecifierForScopeOfERKNS_10ASTContextEPKNS_4TypeEbb")
//</editor-fold>
public static NestedNameSpecifier /*P*/ createNestedNameSpecifierForScopeOf(final /*const*/ ASTContext /*&*/ Ctx, /*const*/ Type /*P*/ TypePtr, 
                                   boolean FullyQualified, boolean WithGlobalNsPrefix) {
  throw new UnsupportedOperationException("EmptyBody");
}

} // END OF class TypeNameStatics
