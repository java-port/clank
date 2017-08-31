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
package org.clang.ast;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import static org.clank.support.Native.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.basic.*;
import static org.clang.ast.AstClangGlobals.*;


//<editor-fold defaultstate="collapsed" desc="static type AstClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp ${LLVM_SRC}/llvm/tools/clang/lib/CodeGen/CGAtomic.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclBase.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Expr.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/NestedNameSpecifier.cpp ${LLVM_SRC}/llvm/tools/clang/tools/extra/clang-tidy/utils/OptionsUtils.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaLambda.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/StmtIterator.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/Type.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=Tpl__ZN5clang15getSpecificAttrERKT0_;Tpl__ZN5clang15hasSpecificAttrERKT0_;Tpl__ZN5clang17specific_attr_endERKT0_;Tpl__ZN5clang19specific_attr_beginERKT0_;Tpl__ZN5clangeqENS_7CanQualIT_EENS0_IT0_EE;Tpl__ZN5clangneENS_7CanQualIT_EENS0_IT0_EE;_Z5clang_Type_h_Unnamed_enum;_ZN5clang16IsEnumDeclScopedEPNS_8EnumDeclE;_ZN5clang18IsEnumDeclCompleteEPNS_8EnumDeclE;_ZN5clang18declaresSameEntityEPKNS_4DeclES2_;_ZN5clang18getFunctionExtInfoENS_8QualTypeE;_ZN5clang18getFunctionExtInfoERKNS_4TypeE;_ZN5clang20getPrimaryMergedDeclEPNS_4DeclE;_ZN5clang20isLambdaCallOperatorEPKNS_11DeclContextE;_ZN5clang20isLambdaCallOperatorEPKNS_13CXXMethodDeclE;_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_14SourceLocationE;_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationE;_ZN5clang23getParameterABISpellingENS_12ParameterABIE;_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_11ParmVarDeclEEES3_;_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_4ExprEEES3_;_ZN5clang26getLambdaStaticInvokerNameEv;_ZN5clang26isLambdaConversionOperatorEPNS_17CXXConversionDeclE;_ZN5clang26isLambdaConversionOperatorEPNS_4DeclE;_ZN5clang30allocateDefaultArgStorageChainERKNS_10ASTContextE;_ZN5clang31FormatASTNodeDiagnosticArgumentENS_17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE;_ZN5clang33getLambdaAwareParentOfDeclContextEPNS_11DeclContextE;_ZN5clang41isGenericLambdaCallOperatorSpecializationEPKNS_13CXXMethodDeclE;_ZN5clang41isGenericLambdaCallOperatorSpecializationEPNS_11DeclContextE;_ZN5clangL10CK_InvalidE;_ZN5clangL16GetUnarySelectorEN4llvm9StringRefERNS_10ASTContextE;_ZN5clangL18GetNullarySelectorEN4llvm9StringRefERNS_10ASTContextE;_ZN5clanggeENS_15DeclarationNameES0_;_ZN5clanggtENS_15DeclarationNameES0_;_ZN5clangleENS_15DeclarationNameES0_;_ZN5clanglsERKNS_17DiagnosticBuilderENS_12TemplateNameE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_15AccessSpecifierE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_15DeclarationNameE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_7CanQualINS_4TypeEEE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_8QualTypeE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_4AttrE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_9NamedDeclE;_ZN5clanglsERKNS_17DiagnosticBuilderEPNS_19NestedNameSpecifierE;_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_16TemplateArgumentE;_ZN5clanglsERKNS_17PartialDiagnosticENS_15AccessSpecifierE;_ZN5clanglsERKNS_17PartialDiagnosticENS_15DeclarationNameE;_ZN5clanglsERKNS_17PartialDiagnosticENS_8QualTypeE;_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_4AttrE;_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_9NamedDeclE;_ZN5clanglsERN4llvm11raw_ostreamENS_15DeclarationNameE;_ZN5clanglsERN4llvm11raw_ostreamENS_19DeclarationNameInfoE;_ZN5clanglsERN4llvm11raw_ostreamERKNS_20ObjCCategoryImplDeclE;_ZN5clanglsERN4llvm11raw_ostreamERKNS_22ObjCImplementationDeclE;_ZN5clanglsERN4llvm11raw_ostreamERKNS_9NamedDeclE;_ZN5clangltENS_15DeclarationNameES0_; -static-type=AstClangGlobals -package=org.clang.ast")
//</editor-fold>
public final class AstClangGlobals {

/*template <typename SpecificAttr, typename Container> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::specific_attr_begin">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 115,
 FQN="clang::specific_attr_begin", NM="Tpl__ZN5clang19specific_attr_beginERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clang19specific_attr_beginERKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ SpecificAttr extends Attr, /*typename*/ Container extends NativeIterable<type$ptr<Attr>>> specific_attr_iterator<SpecificAttr> specific_attr_begin(Class<SpecificAttr> attrClass, final /*const*/ Container /*&*/ container) {
  return /*delegate*/org.clang.ast.impl.AttrIteratorClangGlobals.
    specific_attr_begin(attrClass, container);
}

/*template <typename SpecificAttr, typename Container> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::specific_attr_end">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 120,
 FQN="clang::specific_attr_end", NM="Tpl__ZN5clang17specific_attr_endERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clang17specific_attr_endERKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ SpecificAttr extends Attr, /*typename*/ Container extends NativeIterable<type$ptr<Attr>>> specific_attr_iterator<SpecificAttr> specific_attr_end(Class<SpecificAttr> attrClass, final /*const*/ Container /*&*/ container) {
  return /*delegate*/org.clang.ast.impl.AttrIteratorClangGlobals.
    specific_attr_end(attrClass, container);
}

/*template <typename SpecificAttr, typename Container> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::hasSpecificAttr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 126,
 FQN="clang::hasSpecificAttr", NM="Tpl__ZN5clang15hasSpecificAttrERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clang15hasSpecificAttrERKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ SpecificAttr extends Attr, /*typename*/ Container extends NativeIterable<type$ptr<Attr>>> boolean hasSpecificAttr(Class<SpecificAttr> attrClass, final /*const*/ Container /*&*/ container) {
  return /*delegate*/org.clang.ast.impl.AttrIteratorClangGlobals.
    hasSpecificAttr(attrClass, container);
}

/*template <typename SpecificAttr, typename Container> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::getSpecificAttr">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/AttrIterator.h", line = 131,
 FQN="clang::getSpecificAttr", NM="Tpl__ZN5clang15getSpecificAttrERKT0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clang15getSpecificAttrERKT0_")
//</editor-fold>
public static /*inline*/ </*typename*/ SpecificAttr extends Attr, /*typename*/ Container extends NativeIterable<type$ptr<Attr>>> SpecificAttr /*P*/ getSpecificAttr(Class<SpecificAttr> attrClass, final /*const*/ Container /*&*/ container) {
  return /*delegate*/org.clang.ast.impl.AttrIteratorClangGlobals.
    getSpecificAttr(attrClass, container);
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 316,
 FQN="clang::operator<", NM="_ZN5clangltENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangltENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $less_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $less_DeclarationName(LHS, RHS);
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator>">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 322,
 FQN="clang::operator>", NM="_ZN5clanggtENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanggtENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $greater_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $greater_DeclarationName(LHS, RHS);
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator<=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 328,
 FQN="clang::operator<=", NM="_ZN5clangleENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangleENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $lesseq_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $lesseq_DeclarationName(LHS, RHS);
}


/// Ordering on two declaration names. If both names are identifiers,
/// this provides a lexicographical ordering.
//<editor-fold defaultstate="collapsed" desc="clang::operator>=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 334,
 FQN="clang::operator>=", NM="_ZN5clanggeENS_15DeclarationNameES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanggeENS_15DeclarationNameES0_")
//</editor-fold>
public static /*inline*/ boolean $greatereq_DeclarationName(DeclarationName LHS, DeclarationName RHS) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $greatereq_DeclarationName(LHS, RHS);
}


/// Insertion operator for diagnostics.  This allows sending DeclarationName's
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 549,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_15DeclarationNameE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_DeclarationName(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                        DeclarationName N) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $out_DiagnosticBuilder$C_DeclarationName(DB, 
                                        N);
}


/// Insertion operator for partial diagnostics.  This allows binding
/// DeclarationName's into a partial diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 558,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticENS_15DeclarationNameE")
//</editor-fold>
public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_DeclarationName(final /*const*/ PartialDiagnostic /*&*/ PD, 
                                        DeclarationName N) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $out_PartialDiagnostic$C_DeclarationName(PD, 
                                        N);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclarationName.h", line = 565,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamENS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamENS_19DeclarationNameInfoE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_DeclarationNameInfo(final raw_ostream /*&*/ OS, 
                                    DeclarationNameInfo DNInfo) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $out_raw_ostream_DeclarationNameInfo(OS, 
                                    DNInfo);
}


/// \brief Determine whether two declarations declare the same entity.
//<editor-fold defaultstate="collapsed" desc="clang::declaresSameEntity">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/DeclBase.h", line = 1039,
 FQN="clang::declaresSameEntity", NM="_ZN5clang18declaresSameEntityEPKNS_4DeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang18declaresSameEntityEPKNS_4DeclES2_")
//</editor-fold>
public static /*inline*/ boolean declaresSameEntity(/*const*/ Decl /*P*/ D1, /*const*/ Decl /*P*/ D2) {
  return /*delegate*/org.clang.ast.impl.DeclBaseClangGlobals.
    declaresSameEntity(D1, D2);
}


/// Insertion operator for diagnostics.  This allows sending
/// NestedNameSpecifiers into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/NestedNameSpecifier.h", line = 507,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPNS_19NestedNameSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPNS_19NestedNameSpecifierE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_NestedNameSpecifier$P(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                              NestedNameSpecifier /*P*/ NNS) {
  return /*delegate*/org.clang.ast.impl.NestedNameSpecifierClangGlobals.
    $out_DiagnosticBuilder$C_NestedNameSpecifier$P(DB, 
                                              NNS);
}

//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 40,
 FQN="clang::(anonymous)", NM="_Z5clang_Type_h_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_Z5clang_Type_h_Unnamed_enum")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int TypeAlignmentInBits = 4;
  public static final /*uint*/int TypeAlignment = 1/*JAVA: no extra alignment << TypeAlignmentInBits*/;
  public static final /*uint*/int TypeAlignment$Native = 1 << TypeAlignmentInBits;
/*}*/
//<editor-fold defaultstate="collapsed" desc="clang::getFunctionExtInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5384,
 FQN="clang::getFunctionExtInfo", NM="_ZN5clang18getFunctionExtInfoERKNS_4TypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang18getFunctionExtInfoERKNS_4TypeE")
//</editor-fold>
public static /*inline*/ FunctionType.ExtInfo getFunctionExtInfo(final /*const*/ Type /*&*/ t) {
  return /*delegate*/org.clang.ast.impl.TypeClangGlobals.
    getFunctionExtInfo(t);
}

//<editor-fold defaultstate="collapsed" desc="clang::getFunctionExtInfo">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5394,
 FQN="clang::getFunctionExtInfo", NM="_ZN5clang18getFunctionExtInfoENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang18getFunctionExtInfoENS_8QualTypeE")
//</editor-fold>
public static /*inline*/ FunctionType.ExtInfo getFunctionExtInfo(QualType t) {
  return /*delegate*/org.clang.ast.impl.TypeClangGlobals.
    getFunctionExtInfo(t);
}


// Inline function definitions.

/// \brief Check if the given decl is complete.
///
/// We use this function to break a cycle between the inline definitions in
/// Type.h and Decl.h.
//<editor-fold defaultstate="collapsed" desc="clang::IsEnumDeclComplete">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3856,
 FQN="clang::IsEnumDeclComplete", NM="_ZN5clang18IsEnumDeclCompleteEPNS_8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang18IsEnumDeclCompleteEPNS_8EnumDeclE")
//</editor-fold>
public static /*inline*/ boolean IsEnumDeclComplete(EnumDecl /*P*/ ED) {
  return /*delegate*/org.clang.ast.impl.DeclClangGlobals.
    IsEnumDeclComplete(ED);
}


/// \brief Check if the given decl is scoped.
///
/// We use this function to break a cycle between the inline definitions in
/// Type.h and Decl.h.
//<editor-fold defaultstate="collapsed" desc="clang::IsEnumDeclScoped">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3864,
 FQN="clang::IsEnumDeclScoped", NM="_ZN5clang16IsEnumDeclScopedEPNS_8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clang16IsEnumDeclScopedEPNS_8EnumDeclE")
//</editor-fold>
public static /*inline*/ boolean IsEnumDeclScoped(EnumDecl /*P*/ ED) {
  return /*delegate*/org.clang.ast.impl.DeclClangGlobals.
    IsEnumDeclScoped(ED);
}


/// Insertion operator for diagnostics.  This allows sending QualType's into a
/// diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5792,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_8QualTypeE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_QualType(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                 QualType T) {
  return /*delegate*/org.clang.ast.impl.TypeClangGlobals.
    $out_DiagnosticBuilder$C_QualType(DB, 
                                 T);
}


/// Insertion operator for partial diagnostics.  This allows sending QualType's
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Type.h", line = 5801,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticENS_8QualTypeE")
//</editor-fold>
public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_QualType(final /*const*/ PartialDiagnostic /*&*/ PD, 
                                 QualType T) {
  return /*delegate*/org.clang.ast.impl.TypeClangGlobals.
    $out_PartialDiagnostic$C_QualType(PD, 
                                 T);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 414,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ raw_ostream /*&*/ $out_raw_ostream_NamedDecl$C(final raw_ostream /*&*/ OS, final /*const*/ NamedDecl /*&*/ ND) {
  return /*delegate*/org.clang.ast.impl.DeclClangGlobals.
    $out_raw_ostream_NamedDecl$C(OS, ND);
}


/// Insertion operator for diagnostics.  This allows sending NamedDecl's
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3804,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_NamedDecl$C$P(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                      /*const*/ NamedDecl /*P*/ ND) {
  return /*delegate*/org.clang.ast.impl.DeclClangGlobals.
    $out_DiagnosticBuilder$C_NamedDecl$C$P(DB, 
                                      ND);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Decl.h", line = 3810,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_9NamedDeclE")
//</editor-fold>
public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_NamedDecl$C$P(final /*const*/ PartialDiagnostic /*&*/ PD, 
                                      /*const*/ NamedDecl /*P*/ ND) {
  return /*delegate*/org.clang.ast.impl.DeclClangGlobals.
    $out_PartialDiagnostic$C_NamedDecl$C$P(PD, 
                                      ND);
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::operator==">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 188,
 FQN="clang::operator==", NM="Tpl__ZN5clangeqENS_7CanQualIT_EENS0_IT0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clangeqENS_7CanQualIT_EENS0_IT0_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T extends Type, /*typename*/ U extends Type> boolean $eq_CanQual$T_CanQual$U(CanQual<T> x, CanQual<U> y) {
  return /*delegate*/org.clang.ast.impl.CanonicalTypeClangGlobals.
    $eq_CanQual$T_CanQual$U(x, y);
}

/*template <typename T, typename U> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::operator!=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 193,
 FQN="clang::operator!=", NM="Tpl__ZN5clangneENS_7CanQualIT_EENS0_IT0_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=Tpl__ZN5clangneENS_7CanQualIT_EENS0_IT0_EE")
//</editor-fold>
public static /*inline*/ </*typename*/ T extends Type, /*typename*/ U extends Type> boolean $noteq_CanQual$T_CanQual$U(CanQual<T> x, CanQual<U> y) {
  return /*delegate*/org.clang.ast.impl.CanonicalTypeClangGlobals.
    $noteq_CanQual$T_CanQual$U(x, y);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/CanonicalType.h", line = 204,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_7CanQualINS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_7CanQualINS_4TypeEEE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_CanQual$Type(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                     CanQual<?> T) {
  return /*delegate*/org.clang.ast.impl.CanonicalTypeClangGlobals.
    $out_DiagnosticBuilder$C_CanQual$Type(DB, 
                                     T);
}


/// \brief Utility function for constructing a nullary selector.
//<editor-fold defaultstate="collapsed" desc="clang::GetNullarySelector">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2605,
 FQN="clang::GetNullarySelector", NM="_ZN5clangL18GetNullarySelectorEN4llvm9StringRefERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangL18GetNullarySelectorEN4llvm9StringRefERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ Selector GetNullarySelector(StringRef name, final ASTContext /*&*/ Ctx) {
  return /*delegate*/org.clang.ast.impl.ASTContextClangGlobals.
    GetNullarySelector(name, Ctx);
}


/// \brief Utility function for constructing an unary selector.
//<editor-fold defaultstate="collapsed" desc="clang::GetUnarySelector">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTContext.h", line = 2611,
 FQN="clang::GetUnarySelector", NM="_ZN5clangL16GetUnarySelectorEN4llvm9StringRefERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangL16GetUnarySelectorEN4llvm9StringRefERNS_10ASTContextE")
//</editor-fold>
public static /*inline*/ Selector GetUnarySelector(StringRef name, final ASTContext /*&*/ Ctx) {
  return /*delegate*/org.clang.ast.impl.ASTContextClangGlobals.
    GetUnarySelector(name, Ctx);
}

//<editor-fold defaultstate="collapsed" desc="clang::CK_Invalid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/OperationKinds.h", line = 26,
 FQN="clang::CK_Invalid", NM="_ZN5clangL10CK_InvalidE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clangL10CK_InvalidE")
//</editor-fold>
public static /*const*/ CastKind CK_Invalid = /*static_cast*/CastKind.valueOf(-1);
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 198,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_4AttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_4AttrE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_Attr$C$P(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                 /*const*/ Attr /*P*/ At) {
  return /*delegate*/org.clang.ast.impl.AttrClangGlobals.
    $out_DiagnosticBuilder$C_Attr$C$P(DB, 
                                 At);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/Attr.h", line = 205,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_4AttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTContext.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticEPKNS_4AttrE")
//</editor-fold>
public static /*inline*/ /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_Attr$C$P(final /*const*/ PartialDiagnostic /*&*/ PD, 
                                 /*const*/ Attr /*P*/ At) {
  return /*delegate*/org.clang.ast.impl.AttrClangGlobals.
    $out_PartialDiagnostic$C_Attr$C$P(PD, 
                                 At);
}

// end namespace diag

/// \brief DiagnosticsEngine argument formatting function for diagnostics that
/// involve AST nodes.
///
/// This function formats diagnostic arguments for various AST nodes, 
/// including types, declaration names, nested name specifiers, and
/// declaration contexts, into strings that can be printed as part of
/// diagnostics. It is meant to be used as the argument to
/// \c DiagnosticsEngine::SetArgToStringFn(), where the cookie is an \c
/// ASTContext pointer.
//<editor-fold defaultstate="collapsed" desc="clang::FormatASTNodeDiagnosticArgument">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp", line = 321,
 FQN="clang::FormatASTNodeDiagnosticArgument", NM="_ZN5clang31FormatASTNodeDiagnosticArgumentENS_17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang31FormatASTNodeDiagnosticArgumentENS_17DiagnosticsEngine12ArgumentKindEiN4llvm9StringRefES3_NS2_8ArrayRefISt4pairIS1_iEEERNS2_15SmallVectorImplIcEEPvNS4_IiEE")
//</editor-fold>
public static void FormatASTNodeDiagnosticArgument(DiagnosticsEngine.ArgumentKind Kind, 
                               Object/*intptr_t*/ Val, 
                               StringRef Modifier, 
                               StringRef Argument, 
                               ArrayRef<std.pair<DiagnosticsEngine.ArgumentKind, ?/*,intptr_t*/>> PrevArgs, 
                               final SmallString/*&*/ Output, 
                               Object/*void P*/ Cookie, 
                               ArrayRef<Object/*intptr_t*/> QualTypeVals) {
  /*delegate*/org.clang.ast.impl.ASTDiagnosticClangGlobals.
    FormatASTNodeDiagnosticArgument(Kind, 
                               Val, 
                               Modifier, 
                               Argument, 
                               PrevArgs, 
                               Output, 
                               Cookie, 
                               QualTypeVals);
}

//<editor-fold defaultstate="collapsed" desc="clang::getLambdaStaticInvokerName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 23,
 FQN="clang::getLambdaStaticInvokerName", NM="_ZN5clang26getLambdaStaticInvokerNameEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang26getLambdaStaticInvokerNameEv")
//</editor-fold>
public static /*inline*/ StringRef getLambdaStaticInvokerName() {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    getLambdaStaticInvokerName();
}

// This function returns true if M is a specialization, a template,
// or a non-generic lambda call operator.
//<editor-fold defaultstate="collapsed" desc="clang::isLambdaCallOperator">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 28,
 FQN="clang::isLambdaCallOperator", NM="_ZN5clang20isLambdaCallOperatorEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang20isLambdaCallOperatorEPKNS_13CXXMethodDeclE")
//</editor-fold>
public static /*inline*/ boolean isLambdaCallOperator(/*const*/ CXXMethodDecl /*P*/ MD) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    isLambdaCallOperator(MD);
}

//<editor-fold defaultstate="collapsed" desc="clang::isLambdaCallOperator">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 34,
 FQN="clang::isLambdaCallOperator", NM="_ZN5clang20isLambdaCallOperatorEPKNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang20isLambdaCallOperatorEPKNS_11DeclContextE")
//</editor-fold>
public static /*inline*/ boolean isLambdaCallOperator(/*const*/ DeclContext /*P*/ DC) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    isLambdaCallOperator(DC);
}

//<editor-fold defaultstate="collapsed" desc="clang::isGenericLambdaCallOperatorSpecialization">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 39,
 FQN="clang::isGenericLambdaCallOperatorSpecialization", NM="_ZN5clang41isGenericLambdaCallOperatorSpecializationEPKNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang41isGenericLambdaCallOperatorSpecializationEPKNS_13CXXMethodDeclE")
//</editor-fold>
public static /*inline*/ boolean isGenericLambdaCallOperatorSpecialization(/*const*/ CXXMethodDecl /*P*/ MD) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    isGenericLambdaCallOperatorSpecialization(MD);
}

//<editor-fold defaultstate="collapsed" desc="clang::isLambdaConversionOperator">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 48,
 FQN="clang::isLambdaConversionOperator", NM="_ZN5clang26isLambdaConversionOperatorEPNS_17CXXConversionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang26isLambdaConversionOperatorEPNS_17CXXConversionDeclE")
//</editor-fold>
public static /*inline*/ boolean isLambdaConversionOperator(CXXConversionDecl /*P*/ C) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    isLambdaConversionOperator(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::isLambdaConversionOperator">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 52,
 FQN="clang::isLambdaConversionOperator", NM="_ZN5clang26isLambdaConversionOperatorEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang26isLambdaConversionOperatorEPNS_4DeclE")
//</editor-fold>
public static /*inline*/ boolean isLambdaConversionOperator(Decl /*P*/ D) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    isLambdaConversionOperator(D);
}

//<editor-fold defaultstate="collapsed" desc="clang::isGenericLambdaCallOperatorSpecialization">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 63,
 FQN="clang::isGenericLambdaCallOperatorSpecialization", NM="_ZN5clang41isGenericLambdaCallOperatorSpecializationEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang41isGenericLambdaCallOperatorSpecializationEPNS_11DeclContextE")
//</editor-fold>
public static /*inline*/ boolean isGenericLambdaCallOperatorSpecialization(DeclContext /*P*/ DC) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    isGenericLambdaCallOperatorSpecialization(DC);
}


// This returns the parent DeclContext ensuring that the correct
// parent DeclContext is returned for Lambdas
//<editor-fold defaultstate="collapsed" desc="clang::getLambdaAwareParentOfDeclContext">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/AST/ASTLambda.h", line = 71,
 FQN="clang::getLambdaAwareParentOfDeclContext", NM="_ZN5clang33getLambdaAwareParentOfDeclContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/ASTDiagnostic.cpp -nm=_ZN5clang33getLambdaAwareParentOfDeclContextEPNS_11DeclContextE")
//</editor-fold>
public static /*inline*/ DeclContext /*P*/ getLambdaAwareParentOfDeclContext(DeclContext /*P*/ DC) {
  return /*delegate*/org.clang.ast.impl.ASTLambdaClangGlobals.
    getLambdaAwareParentOfDeclContext(DC);
}


/// \brief Get the primary declaration for a declaration from an AST file. That
/// will be the first-loaded declaration.
//<editor-fold defaultstate="collapsed" desc="clang::getPrimaryMergedDecl">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp", line = 39,
 FQN="clang::getPrimaryMergedDecl", NM="_ZN5clang20getPrimaryMergedDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/Decl.cpp -nm=_ZN5clang20getPrimaryMergedDeclEPNS_4DeclE")
//</editor-fold>
public static Decl /*P*/ getPrimaryMergedDecl(Decl /*P*/ D) {
  return /*delegate*/org.clang.ast.impl.DeclClangGlobals.
    getPrimaryMergedDecl(D);
}


/// Insertion operator for diagnostics.  This allows sending an AccessSpecifier
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2350,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_15AccessSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_15AccessSpecifierE")
//</editor-fold>
public static /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_AccessSpecifier(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                        AccessSpecifier AS) {
  return /*delegate*/org.clang.ast.impl.DeclCXXClangGlobals.
    $out_DiagnosticBuilder$C_AccessSpecifier(DB, 
                                        AS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp", line = 2355,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17PartialDiagnosticENS_15AccessSpecifierE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclCXX.cpp -nm=_ZN5clanglsERKNS_17PartialDiagnosticENS_15AccessSpecifierE")
//</editor-fold>
public static /*const*/ PartialDiagnostic /*&*/ $out_PartialDiagnostic$C_AccessSpecifier(final /*const*/ PartialDiagnostic /*&*/ DB, 
                                        AccessSpecifier AS) {
  return /*delegate*/org.clang.ast.impl.DeclCXXClangGlobals.
    $out_PartialDiagnostic$C_AccessSpecifier(DB, 
                                        AS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2076,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_20ObjCCategoryImplDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_20ObjCCategoryImplDeclE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_ObjCCategoryImplDecl$C(final raw_ostream /*&*/ OS, 
                                       final /*const*/ ObjCCategoryImplDecl /*&*/ CID) {
  return /*delegate*/org.clang.ast.impl.DeclObjCClangGlobals.
    $out_raw_ostream_ObjCCategoryImplDecl$C(OS, 
                                       CID);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp", line = 2128,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_22ObjCImplementationDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclObjC.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_22ObjCImplementationDeclE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_ObjCImplementationDecl$C(final raw_ostream /*&*/ OS, 
                                         final /*const*/ ObjCImplementationDecl /*&*/ ID) {
  return /*delegate*/org.clang.ast.impl.DeclObjCClangGlobals.
    $out_raw_ostream_ObjCImplementationDecl$C(OS, 
                                         ID);
}

//<editor-fold defaultstate="collapsed" desc="clang::allocateDefaultArgStorageChain">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp", line = 120,
 FQN="clang::allocateDefaultArgStorageChain", NM="_ZN5clang30allocateDefaultArgStorageChainERKNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclTemplate.cpp -nm=_ZN5clang30allocateDefaultArgStorageChainERKNS_10ASTContextE")
//</editor-fold>
public static Object/*void P*/ allocateDefaultArgStorageChain(final /*const*/ ASTContext /*&*/ C) {
  return /*delegate*/org.clang.ast.impl.DeclTemplateClangGlobals.
    allocateDefaultArgStorageChain(C);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp", line = 219,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/DeclarationName.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamENS_15DeclarationNameE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_DeclarationName(final raw_ostream /*&*/ OS, DeclarationName N) {
  return /*delegate*/org.clang.ast.impl.DeclarationNameClangGlobals.
    $out_raw_ostream_DeclarationName(OS, N);
}


/// \brief Returns true if all \p SelLocs are in a "standard" location.
// anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::hasStandardSelectorLocs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 96,
 FQN="clang::hasStandardSelectorLocs", NM="_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_4ExprEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_4ExprEEES3_")
//</editor-fold>
public static SelectorLocationsKind hasStandardSelectorLocsExprs(Selector Sel, 
                            ArrayRef<SourceLocation> SelLocs, 
                            ArrayRef<Expr /*P*/ > Args, 
                            SourceLocation EndLoc) {
  return /*delegate*/org.clang.ast.impl.SelectorLocationsKindClangGlobals.
    hasStandardSelectorLocsExprs(Sel, 
                            SelLocs, 
                            Args, 
                            EndLoc);
}


/// \brief Get the "standard" location of a selector identifier, e.g:
/// For nullary selectors, immediately before ']': "[foo release]"
///
/// \param WithArgSpace if true the standard location is with a space apart
/// before arguments: "[foo first: 1 second: 2]"
/// If false: "[foo first:1 second:2]"
//<editor-fold defaultstate="collapsed" desc="clang::getStandardSelectorLoc">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 104,
 FQN="clang::getStandardSelectorLoc", NM="_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationE")
//</editor-fold>
public static SourceLocation getStandardSelectorLocExprs(/*uint*/int Index, 
                           Selector Sel, 
                           boolean WithArgSpace, 
                           ArrayRef<Expr /*P*/ > Args, 
                           SourceLocation EndLoc) {
  return /*delegate*/org.clang.ast.impl.SelectorLocationsKindClangGlobals.
    getStandardSelectorLocExprs(Index, 
                           Sel, 
                           WithArgSpace, 
                           Args, 
                           EndLoc);
}


/// \brief Returns true if all \p SelLocs are in a "standard" location.
//<editor-fold defaultstate="collapsed" desc="clang::hasStandardSelectorLocs">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 113,
 FQN="clang::hasStandardSelectorLocs", NM="_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_11ParmVarDeclEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang23hasStandardSelectorLocsENS_8SelectorEN4llvm8ArrayRefINS_14SourceLocationEEENS2_IPNS_11ParmVarDeclEEES3_")
//</editor-fold>
public static SelectorLocationsKind hasStandardSelectorLocsParmVarDecls(Selector Sel, 
                                   ArrayRef<SourceLocation> SelLocs, 
                                   ArrayRef<ParmVarDecl /*P*/ > Args, 
                                   SourceLocation EndLoc) {
  return /*delegate*/org.clang.ast.impl.SelectorLocationsKindClangGlobals.
    hasStandardSelectorLocsParmVarDecls(Sel, 
                                   SelLocs, 
                                   Args, 
                                   EndLoc);
}


/// \brief Get the "standard" location of a selector identifier, e.g:
/// For nullary selectors, immediately before ']': "[foo release]"
///
/// \param WithArgSpace if true the standard location is with a space apart
/// before arguments: "-(id)first: (int)x second: (int)y;"
/// If false: "-(id)first:(int)x second:(int)y;"
//<editor-fold defaultstate="collapsed" desc="clang::getStandardSelectorLoc">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp", line = 121,
 FQN="clang::getStandardSelectorLoc", NM="_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/SelectorLocationsKind.cpp -nm=_ZN5clang22getStandardSelectorLocEjNS_8SelectorEbN4llvm8ArrayRefIPNS_11ParmVarDeclEEENS_14SourceLocationE")
//</editor-fold>
public static SourceLocation getStandardSelectorLocParmVarDecls(/*uint*/int Index, 
                                  Selector Sel, 
                                  boolean WithArgSpace, 
                                  ArrayRef<ParmVarDecl /*P*/ > Args, 
                                  SourceLocation EndLoc) {
  return /*delegate*/org.clang.ast.impl.SelectorLocationsKindClangGlobals.
    getStandardSelectorLocParmVarDecls(Index, 
                                  Sel, 
                                  WithArgSpace, 
                                  Args, 
                                  EndLoc);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp", line = 475,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_16TemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateBase.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_16TemplateArgumentE")
//</editor-fold>
public static /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_TemplateArgument$C(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                           final /*const*/ TemplateArgument /*&*/ Arg) {
  return /*delegate*/org.clang.ast.impl.TemplateBaseClangGlobals.
    $out_DiagnosticBuilder$C_TemplateArgument$C(DB, 
                                           Arg);
}


/// Insertion operator for diagnostics.  This allows sending TemplateName's
/// into a diagnostic with <<.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp", line = 209,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_12TemplateNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/TemplateName.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_12TemplateNameE")
//</editor-fold>
public static /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_TemplateName(final /*const*/ DiagnosticBuilder /*&*/ DB, 
                                     TemplateName N) {
  return /*delegate*/org.clang.ast.impl.TemplateNameClangGlobals.
    $out_DiagnosticBuilder$C_TemplateName(DB, 
                                     N);
}

// JAVA: getParameterABISpelling method exists in BasicClangGlobals, comment out to resolve ambiguity 
////<editor-fold defaultstate="collapsed" desc="clang::getParameterABISpelling">
//@Converted(kind = Converted.Kind.BODY_DELEGATE,
// source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 636,
// FQN="clang::getParameterABISpelling", NM="_ZN5clang23getParameterABISpellingENS_12ParameterABIE",
// cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.ast/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang23getParameterABISpellingENS_12ParameterABIE")
////</editor-fold>
//public static StringRef getParameterABISpelling(ParameterABI ABI) {
//  return /*delegate*/org.clang.ast.impl.TypePrinterClangGlobals.
//    getParameterABISpelling(ABI);
//}

} // END OF class AstClangGlobals
