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
package org.clang.basic;

import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.clang.basic.*;
import static org.clang.basic.BasicClangGlobals.*;
import org.clang.basic.target.TargetInfo;
import org.llvm.adt.aliases.ArrayRef;
import org.clang.basic.declcontext.DeclContextImplementation;

//<editor-fold defaultstate="collapsed" desc="static type BasicClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -body-delegate -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticOptions.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/ExprClassification.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Tooling/FixIt.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OperatorPrecedence.cpp ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/PathDiagnostic.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceLocation.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp ${LLVM_SRC}/llvm/tools/clang/lib/AST/VTTBuilder.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Warnings.cpp -nm=Tpl__ZN5clanglsERKNS_17DiagnosticBuilderEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameINSt12remove_constIT_E4typeEN5clang11DeclContextEEE5valueERKNS4_17DiagnosticBuilderEE4typeE;Tpl__ZN5clanglsERKNS_17DiagnosticBuilderET_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_bEE5valueERKN5clang17DiagnosticBuilderEE4typeE;_Z5clang_IdentifierTable_h_Unnamed_enum1;_Z5clang_IdentifierTable_h_Unnamed_enum2;_ZN5clang10minLinkageENS_7LinkageES0_;_ZN5clang12hasAttributeENS_10AttrSyntaxEPKNS_14IdentifierInfoES3_RKNS_10TargetInfoERKNS_11LangOptionsE;_ZN5clang13mergeCanThrowENS_14CanThrowResultES0_;_ZN5clang13minVisibilityENS_10VisibilityES0_;_ZN5clang15getLLVMRevisionEv;_ZN5clang15isOpenMPPrivateENS_16OpenMPClauseKindE;_ZN5clang16CudaArchToStringENS_8CudaArchE;_ZN5clang16StringToCudaArchEN4llvm9StringRefE;_ZN5clang16getClangRevisionEv;_ZN5clang16getFormalLinkageENS_7LinkageE;_ZN5clang18getBinOpPrecedenceENS_3tok9TokenKindEbb;_ZN5clang18isLegalForFunctionENS_12StorageClassE;_ZN5clang18isLegalForVariableENS_12StorageClassE;_ZN5clang19CudaVersionToStringENS_11CudaVersionE;_ZN5clang19getClangFullVersionEv;_ZN5clang19getOpenMPClauseKindEN4llvm9StringRefE;_ZN5clang19getOpenMPClauseNameENS_16OpenMPClauseKindE;_ZN5clang19getOperatorSpellingENS_22OverloadedOperatorKindE;_ZN5clang19isExternallyVisibleENS_7LinkageE;_ZN5clang19parseSanitizerValueEN4llvm9StringRefEb;_ZN5clang20supportsVariadicCallENS_11CallingConvE;_ZN5clang21MinVersionForCudaArchENS_8CudaArchE;_ZN5clang21ProcessWarningOptionsERNS_17DiagnosticsEngineERKNS_17DiagnosticOptionsEb;_ZN5clang21expandSanitizerGroupsEy;_ZN5clang21getLLVMRepositoryPathEv;_ZN5clang21isOpenMPLoopDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang21isOpenMPSimdDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang21isOpenMPThreadPrivateENS_16OpenMPClauseKindE;_ZN5clang22VirtualArchForCudaArchENS_8CudaArchE;_ZN5clang22getClangFullCPPVersionEv;_ZN5clang22getClangRepositoryPathEv;_ZN5clang22getNullabilitySpellingENS_15NullabilityKindEb;_ZN5clang22getOpenMPDirectiveKindEN4llvm9StringRefE;_ZN5clang22getOpenMPDirectiveNameENS_19OpenMPDirectiveKindE;_ZN5clang22isDynamicExceptionSpecENS_26ExceptionSpecificationTypeE;_ZN5clang22isOpenMPTeamsDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang23CudaVirtualArchToStringENS_15CudaVirtualArchE;_ZN5clang23StringToCudaVirtualArchEN4llvm9StringRefE;_ZN5clang23getClangToolFullVersionEN4llvm9StringRefE;_ZN5clang23getParameterABISpellingENS_12ParameterABIE;_ZN5clang23isExternalFormalLinkageENS_7LinkageE;_ZN5clang23isNoexceptExceptionSpecENS_26ExceptionSpecificationTypeE;_ZN5clang23isTemplateInstantiationENS_26TemplateSpecializationKindE;_ZN5clang24isOpenMPTaskingDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang25getOpenMPSimpleClauseTypeENS_16OpenMPClauseKindEN4llvm9StringRefE;_ZN5clang25isOpenMPParallelDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang25isOpenMPTaskLoopDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang25isUnresolvedExceptionSpecENS_26ExceptionSpecificationTypeE;_ZN5clang27isAllowedClauseForDirectiveENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE;_ZN5clang27isOpenMPDistributeDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang28isOpenMPWorksharingDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang29getClangFullRepositoryVersionEv;_ZN5clang29getOpenMPSimpleClauseTypeNameENS_16OpenMPClauseKindEj;_ZN5clang32isOpenMPTargetExecutionDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang33isOpenMPLoopBoundSharingDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang37isOpenMPTargetDataManagementDirectiveENS_19OpenMPDirectiveKindE;_ZN5clang47isTemplateExplicitInstantiationOrSpecializationENS_26TemplateSpecializationKindE;_ZN5clangL10isHexDigitEh;_ZN5clangL11isLowercaseEh;_ZN5clangL11isPrintableEh;_ZN5clangL11isUppercaseEh;_ZN5clangL11toLowercaseEc;_ZN5clangL11toUppercaseEc;_ZN5clangL12isWhitespaceEh;_ZN5clangL13isPunctuationEh;_ZN5clangL14isAlphanumericEh;_ZN5clangL15ToggleHighlightE;_ZN5clangL16isIdentifierBodyEhb;_ZN5clangL16isIdentifierHeadEhb;_ZN5clangL17isValidIdentifierEN4llvm9StringRefE;_ZN5clangL20isRawStringDelimBodyEh;_ZN5clangL20isVerticalWhitespaceEh;_ZN5clangL22isHorizontalWhitespaceEh;_ZN5clangL25isPreprocessingNumberBodyEh;_ZN5clangL7isASCIIEc;_ZN5clangL7isDigitEh;_ZN5clangL8isLetterEh;_ZN5clanganENS_19DiagnosticLevelMaskES0_;_ZN5clangcoENS_19DiagnosticLevelMaskE;_ZN5clangeqERKNS_14SourceLocationES2_;_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_11SourceRangeEEE;_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_9FixItHintEEE;_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm9StringRefE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_11SourceRangeE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_12AddFlagValueE;_ZN5clanglsERKNS_17DiagnosticBuilderENS_3tok9TokenKindE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_14IdentifierInfoE;_ZN5clanglsERKNS_17DiagnosticBuilderEPKc;_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_15CharSourceRangeE;_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_17PartialDiagnosticE;_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_9FixItHintE;_ZN5clanglsERKNS_17DiagnosticBuilderESt4pairINS_15NullabilityKindEbE;_ZN5clanglsERKNS_17DiagnosticBuilderEi;_ZN5clanglsERKNS_17DiagnosticBuilderEj;_ZN5clanglsERN4llvm11raw_ostreamENS_19DiagnosticLevelMaskE;_ZN5clanglsERN4llvm11raw_ostreamERKNS_11ObjCRuntimeE;_ZN5clanglsERN4llvm11raw_ostreamERKNS_12VersionTupleE;_ZN5clangltERKNS_14SourceLocationES2_;_ZN5clangltERKNS_9LineEntryES2_;_ZN5clangltERKNS_9LineEntryEj;_ZN5clangltEjRKNS_9LineEntryE;_ZN5clangneERKNS_14SourceLocationES2_;_ZN5clangorENS_19DiagnosticLevelMaskES0_; -static-type=BasicClangGlobals -package=org.clang.basic")
//</editor-fold>
public final class BasicClangGlobals  extends JavaBasicGlobals {

//<editor-fold defaultstate="collapsed" desc="clang::isExternallyVisible">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 72,
 FQN="clang::isExternallyVisible", NM="_ZN5clang19isExternallyVisibleENS_7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang19isExternallyVisibleENS_7LinkageE")
//</editor-fold>
public static /*inline*/ boolean isExternallyVisible(Linkage L) {
  return /*delegate*/org.clang.basic.impl.LinkageClangGlobals.
    isExternallyVisible(L);
}

//<editor-fold defaultstate="collapsed" desc="clang::getFormalLinkage">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 76,
 FQN="clang::getFormalLinkage", NM="_ZN5clang16getFormalLinkageENS_7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang16getFormalLinkageENS_7LinkageE")
//</editor-fold>
public static /*inline*/ Linkage getFormalLinkage(Linkage L) {
  return /*delegate*/org.clang.basic.impl.LinkageClangGlobals.
    getFormalLinkage(L);
}

//<editor-fold defaultstate="collapsed" desc="clang::isExternalFormalLinkage">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 84,
 FQN="clang::isExternalFormalLinkage", NM="_ZN5clang23isExternalFormalLinkageENS_7LinkageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang23isExternalFormalLinkageENS_7LinkageE")
//</editor-fold>
public static /*inline*/ boolean isExternalFormalLinkage(Linkage L) {
  return /*delegate*/org.clang.basic.impl.LinkageClangGlobals.
    isExternalFormalLinkage(L);
}


/// \brief Compute the minimum linkage given two linkages.
///
/// The linkage can be interpreted as a pair formed by the formal linkage and
/// a boolean for external visibility. This is just what getFormalLinkage and
/// isExternallyVisible return. We want the minimum of both components. The
/// Linkage enum is defined in an order that makes this simple, we just need
/// special cases for when VisibleNoLinkage would lose the visible bit and
/// become NoLinkage.
//<editor-fold defaultstate="collapsed" desc="clang::minLinkage">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Linkage.h", line = 96,
 FQN="clang::minLinkage", NM="_ZN5clang10minLinkageENS_7LinkageES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang10minLinkageENS_7LinkageES0_")
//</editor-fold>
public static /*inline*/ Linkage minLinkage(Linkage L1, Linkage L2) {
  return /*delegate*/org.clang.basic.impl.LinkageClangGlobals.
    minLinkage(L1, L2);
}

//<editor-fold defaultstate="collapsed" desc="clang::minVisibility">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Visibility.h", line = 47,
 FQN="clang::minVisibility", NM="_ZN5clang13minVisibilityENS_10VisibilityES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang13minVisibilityENS_10VisibilityES0_")
//</editor-fold>
public static /*inline*/ Visibility minVisibility(Visibility L, Visibility R) {
  return /*delegate*/org.clang.basic.impl.VisibilityClangGlobals.
    minVisibility(L, R);
}


/// \brief Determine whether this template specialization kind refers
/// to an instantiation of an entity (as opposed to a non-template or
/// an explicit specialization).
//<editor-fold defaultstate="collapsed" desc="clang::isTemplateInstantiation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 165,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 162,
 FQN="clang::isTemplateInstantiation", NM="_ZN5clang23isTemplateInstantiationENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang23isTemplateInstantiationENS_26TemplateSpecializationKindE")
//</editor-fold>
public static /*inline*/ boolean isTemplateInstantiation(TemplateSpecializationKind Kind) {
  return /*delegate*/org.clang.basic.impl.SpecifiersClangGlobals.
    isTemplateInstantiation(Kind);
}


/// \brief True if this template specialization kind is an explicit
/// specialization, explicit instantiation declaration, or explicit
/// instantiation definition.
//<editor-fold defaultstate="collapsed" desc="clang::isTemplateExplicitInstantiationOrSpecialization">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 172,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 169,
 FQN="clang::isTemplateExplicitInstantiationOrSpecialization", NM="_ZN5clang47isTemplateExplicitInstantiationOrSpecializationENS_26TemplateSpecializationKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang47isTemplateExplicitInstantiationOrSpecializationENS_26TemplateSpecializationKindE")
//</editor-fold>
public static /*inline*/ boolean isTemplateExplicitInstantiationOrSpecialization(TemplateSpecializationKind Kind) {
  return /*delegate*/org.clang.basic.impl.SpecifiersClangGlobals.
    isTemplateExplicitInstantiationOrSpecialization(Kind);
}


/// \brief Checks whether the given storage class is legal for functions.
//<editor-fold defaultstate="collapsed" desc="clang::isLegalForFunction">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 214,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 211,
 FQN="clang::isLegalForFunction", NM="_ZN5clang18isLegalForFunctionENS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang18isLegalForFunctionENS_12StorageClassE")
//</editor-fold>
public static /*inline*/ boolean isLegalForFunction(StorageClass SC) {
  return /*delegate*/org.clang.basic.impl.SpecifiersClangGlobals.
    isLegalForFunction(SC);
}


/// \brief Checks whether the given storage class is legal for variables.
//<editor-fold defaultstate="collapsed" desc="clang::isLegalForVariable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 219,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 216,
 FQN="clang::isLegalForVariable", NM="_ZN5clang18isLegalForVariableENS_12StorageClassE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang18isLegalForVariableENS_12StorageClassE")
//</editor-fold>
public static /*inline*/ boolean isLegalForVariable(StorageClass SC) {
  return /*delegate*/org.clang.basic.impl.SpecifiersClangGlobals.
    isLegalForVariable(SC);
}


/// \brief Checks whether the given calling convention supports variadic
/// calls. Unprototyped calls also use the variadic call rules.
//<editor-fold defaultstate="collapsed" desc="clang::supportsVariadicCall">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", line = 252,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Specifiers.h", old_line = 246,
 FQN="clang::supportsVariadicCall", NM="_ZN5clang20supportsVariadicCallENS_11CallingConvE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang20supportsVariadicCallENS_11CallingConvE")
//</editor-fold>
public static /*inline*/ boolean supportsVariadicCall(CallingConv CC) {
  return /*delegate*/org.clang.basic.impl.SpecifiersClangGlobals.
    supportsVariadicCall(CC);
}


/// \brief Return the version number associated with the attribute if we
/// recognize and implement the attribute specified by the given information.
//<editor-fold defaultstate="collapsed" desc="clang::hasAttribute">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp", line = 6,
 FQN="clang::hasAttribute", NM="_ZN5clang12hasAttributeENS_10AttrSyntaxEPKNS_14IdentifierInfoES3_RKNS_10TargetInfoERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_ZN5clang12hasAttributeENS_10AttrSyntaxEPKNS_14IdentifierInfoES3_RKNS_10TargetInfoERKNS_11LangOptionsE")
//</editor-fold>
public static int hasAttribute(AttrSyntax Syntax, /*const*/ IdentifierInfo /*P*/ Scope, 
            /*const*/ IdentifierInfo /*P*/ Attr, /*const*/ TargetInfo /*&*/ Target, 
            /*const*/ LangOptions /*&*/ LangOpts) {
  return /*delegate*/org.clang.basic.impl.AttributesClangGlobals.
    hasAttribute(Syntax, Scope, 
            Attr, Target, 
            LangOpts);
}


/// Enough bits to store any enumerator in ObjCMethodFamily or
/// InvalidObjCMethodFamily.
//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 597,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 582,
 FQN="clang::(anonymous)", NM="_Z5clang_IdentifierTable_h_Unnamed_enum1",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_Z5clang_IdentifierTable_h_Unnamed_enum1")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int ObjCMethodFamilyBitWidth = 4;
/*}*/

/// \brief An invalid value of ObjCMethodFamily.
//<editor-fold defaultstate="collapsed" desc="clang::(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", line = 600,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/IdentifierTable.h", old_line = 585,
 FQN="clang::(anonymous)", NM="_Z5clang_IdentifierTable_h_Unnamed_enum2",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Attributes.cpp -nm=_Z5clang_IdentifierTable_h_Unnamed_enum2")
//</editor-fold>
/*enum ANONYMOUS_INT_CONSTANTS {*/
  public static final /*uint*/int InvalidObjCMethodFamily = (1 << ObjCMethodFamilyBitWidth) - 1;
/*}*/
// end namespace charinfo

/// Returns true if this is an ASCII character.
//<editor-fold defaultstate="collapsed" desc="clang::isASCII">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 43,
 FQN="clang::isASCII", NM="_ZN5clangL7isASCIIEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL7isASCIIEc")
//</editor-fold>
public static /*inline*/ boolean isASCII(/*char*/byte c)/* __attribute__((const))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isASCII(c);
}
/// Returns true if this is an ASCII character.
//<editor-fold defaultstate="collapsed" desc="clang::isASCII">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, 
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 43,
 FQN="clang::isASCII", NM="_ZN5clangL7isASCIIEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL7isASCIIEc")
//</editor-fold>
public static /*inline*/ boolean isASCII(/*char*/char c)/* __attribute__((const))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isASCII(c);
}


/// Returns true if this is a valid first character of a C identifier,
/// which is [a-zA-Z_].
//<editor-fold defaultstate="collapsed" desc="clang::isIdentifierHead">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 49,
 FQN="clang::isIdentifierHead", NM="_ZN5clangL16isIdentifierHeadEhb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL16isIdentifierHeadEhb")
//</editor-fold>
public static /*inline*/ boolean isIdentifierHead(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return isIdentifierHead(c, 
                false);
}
public static /*inline*/ boolean isIdentifierHead(/*uchar*/byte c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isIdentifierHead(c, 
                AllowDollar);
}
public static /*inline*/ boolean isIdentifierHead(/*uchar*/char c)/* __attribute__((pure))*/ {
  return isIdentifierHead(c, 
                false);
}
public static /*inline*/ boolean isIdentifierHead(/*uchar*/char c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isIdentifierHead(c, 
                AllowDollar);
}


/// Returns true if this is a body character of a C identifier,
/// which is [a-zA-Z0-9_].
//<editor-fold defaultstate="collapsed" desc="clang::isIdentifierBody">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 59,
 FQN="clang::isIdentifierBody", NM="_ZN5clangL16isIdentifierBodyEhb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL16isIdentifierBodyEhb")
//</editor-fold>
public static /*inline*/ boolean isIdentifierBody(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return isIdentifierBody(c, 
                false);
}
public static /*inline*/ boolean isIdentifierBody(/*uchar*/byte c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isIdentifierBody(c, 
                AllowDollar);
}
public static /*inline*/ boolean isIdentifierBody(/*uchar*/char c)/* __attribute__((pure))*/ {
  return isIdentifierBody(c, 
                false);
}
public static /*inline*/ boolean isIdentifierBody(/*uchar*/char c, 
                boolean AllowDollar/*= false*/)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isIdentifierBody(c, 
                AllowDollar);
}


/// Returns true if this character is horizontal ASCII whitespace:
/// ' ', '\\t', '\\f', '\\v'.
///
/// Note that this returns false for '\\0'.
//<editor-fold defaultstate="collapsed" desc="clang::isHorizontalWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 71,
 FQN="clang::isHorizontalWhitespace", NM="_ZN5clangL22isHorizontalWhitespaceEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL22isHorizontalWhitespaceEh")
//</editor-fold>
public static /*inline*/ boolean isHorizontalWhitespace(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isHorizontalWhitespace(c);
}
public static /*inline*/ boolean isHorizontalWhitespace(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isHorizontalWhitespace(c);
}


/// Returns true if this character is vertical ASCII whitespace: '\\n', '\\r'.
///
/// Note that this returns false for '\\0'.
//<editor-fold defaultstate="collapsed" desc="clang::isVerticalWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 79,
 FQN="clang::isVerticalWhitespace", NM="_ZN5clangL20isVerticalWhitespaceEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL20isVerticalWhitespaceEh")
//</editor-fold>
public static /*inline*/ boolean isVerticalWhitespace(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isVerticalWhitespace(c);
}
public static /*inline*/ boolean isVerticalWhitespace(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isVerticalWhitespace(c);
}


/// Return true if this character is horizontal or vertical ASCII whitespace:
/// ' ', '\\t', '\\f', '\\v', '\\n', '\\r'.
///
/// Note that this returns false for '\\0'.
//<editor-fold defaultstate="collapsed" desc="clang::isWhitespace">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 88,
 FQN="clang::isWhitespace", NM="_ZN5clangL12isWhitespaceEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL12isWhitespaceEh")
//</editor-fold>
public static /*inline*/ boolean isWhitespace(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isWhitespace(c);
}
public static /*inline*/ boolean isWhitespace(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isWhitespace(c);
}


/// Return true if this character is an ASCII digit: [0-9]
//<editor-fold defaultstate="collapsed" desc="clang::isDigit">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 94,
 FQN="clang::isDigit", NM="_ZN5clangL7isDigitEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL7isDigitEh")
//</editor-fold>
public static /*inline*/ boolean isDigit(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isDigit(c);
}
public static /*inline*/ boolean isDigit(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isDigit(c);
}


/// Return true if this character is a lowercase ASCII letter: [a-z]
//<editor-fold defaultstate="collapsed" desc="clang::isLowercase">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 100,
 FQN="clang::isLowercase", NM="_ZN5clangL11isLowercaseEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11isLowercaseEh")
//</editor-fold>
public static /*inline*/ boolean isLowercase(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isLowercase(c);
}
public static /*inline*/ boolean isLowercase(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isLowercase(c);
}


/// Return true if this character is an uppercase ASCII letter: [A-Z]
//<editor-fold defaultstate="collapsed" desc="clang::isUppercase">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 106,
 FQN="clang::isUppercase", NM="_ZN5clangL11isUppercaseEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11isUppercaseEh")
//</editor-fold>
public static /*inline*/ boolean isUppercase(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isUppercase(c);
}
public static /*inline*/ boolean isUppercase(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isUppercase(c);
}


/// Return true if this character is an ASCII letter: [a-zA-Z]
//<editor-fold defaultstate="collapsed" desc="clang::isLetter">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 112,
 FQN="clang::isLetter", NM="_ZN5clangL8isLetterEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL8isLetterEh")
//</editor-fold>
public static /*inline*/ boolean isLetter(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isLetter(c);
}
public static /*inline*/ boolean isLetter(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isLetter(c);
}


/// Return true if this character is an ASCII letter or digit: [a-zA-Z0-9]
//<editor-fold defaultstate="collapsed" desc="clang::isAlphanumeric">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 118,
 FQN="clang::isAlphanumeric", NM="_ZN5clangL14isAlphanumericEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL14isAlphanumericEh")
//</editor-fold>
public static /*inline*/ boolean isAlphanumeric(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isAlphanumeric(c);
}
public static /*inline*/ boolean isAlphanumeric(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isAlphanumeric(c);
}


/// Return true if this character is an ASCII hex digit: [0-9a-fA-F]
//<editor-fold defaultstate="collapsed" desc="clang::isHexDigit">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 124,
 FQN="clang::isHexDigit", NM="_ZN5clangL10isHexDigitEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL10isHexDigitEh")
//</editor-fold>
public static /*inline*/ boolean isHexDigit(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isHexDigit(c);
}
public static /*inline*/ boolean isHexDigit(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isHexDigit(c);
}


/// Return true if this character is an ASCII punctuation character.
///
/// Note that '_' is both a punctuation character and an identifier character!
//<editor-fold defaultstate="collapsed" desc="clang::isPunctuation">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 132,
 FQN="clang::isPunctuation", NM="_ZN5clangL13isPunctuationEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL13isPunctuationEh")
//</editor-fold>
public static /*inline*/ boolean isPunctuation(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isPunctuation(c);
}
public static /*inline*/ boolean isPunctuation(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isPunctuation(c);
}


/// Return true if this character is an ASCII printable character; that is, a
/// character that should take exactly one column to print in a fixed-width
/// terminal.
//<editor-fold defaultstate="collapsed" desc="clang::isPrintable">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 140,
 FQN="clang::isPrintable", NM="_ZN5clangL11isPrintableEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11isPrintableEh")
//</editor-fold>
public static /*inline*/ boolean isPrintable(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isPrintable(c);
}
public static /*inline*/ boolean isPrintable(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isPrintable(c);
}


/// Return true if this is the body character of a C preprocessing number,
/// which is [a-zA-Z0-9_.].
//<editor-fold defaultstate="collapsed" desc="clang::isPreprocessingNumberBody">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 148,
 FQN="clang::isPreprocessingNumberBody", NM="_ZN5clangL25isPreprocessingNumberBodyEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL25isPreprocessingNumberBodyEh")
//</editor-fold>
public static /*inline*/ boolean isPreprocessingNumberBody(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isPreprocessingNumberBody(c);
}
public static /*inline*/ boolean isPreprocessingNumberBody(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isPreprocessingNumberBody(c);
}


/// Return true if this is the body character of a C++ raw string delimiter.
//<editor-fold defaultstate="collapsed" desc="clang::isRawStringDelimBody">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 155,
 FQN="clang::isRawStringDelimBody", NM="_ZN5clangL20isRawStringDelimBodyEh",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL20isRawStringDelimBodyEh")
//</editor-fold>
public static /*inline*/ boolean isRawStringDelimBody(/*uchar*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isRawStringDelimBody(c);
}
public static /*inline*/ boolean isRawStringDelimBody(/*uchar*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isRawStringDelimBody(c);
}


/// Converts the given ASCII character to its lowercase equivalent.
///
/// If the character is not an uppercase character, it is returned as is.
//<editor-fold defaultstate="collapsed" desc="clang::toLowercase">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 165,
 FQN="clang::toLowercase", NM="_ZN5clangL11toLowercaseEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11toLowercaseEc")
//</editor-fold>
public static /*inline*/ /*char*/byte toLowercase(/*char*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    toLowercase(c);
}
public static /*inline*/ /*char*/byte toLowercase(/*char*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    toLowercase(c);
}


/// Converts the given ASCII character to its uppercase equivalent.
///
/// If the character is not a lowercase character, it is returned as is.
//<editor-fold defaultstate="collapsed" desc="clang::toUppercase">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 174,
 FQN="clang::toUppercase", NM="_ZN5clangL11toUppercaseEc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL11toUppercaseEc")
//</editor-fold>
public static /*inline*/ /*char*/byte toUppercase(/*char*/byte c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    toUppercase(c);
}
public static /*inline*/ /*char*/byte toUppercase(/*char*/char c)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    toUppercase(c);
}


/// Return true if this is a valid ASCII identifier.
///
/// Note that this is a very simple check; it does not accept '$' or UCNs as
/// valid identifier characters.
//<editor-fold defaultstate="collapsed" desc="clang::isValidIdentifier">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/CharInfo.h", line = 185,
 FQN="clang::isValidIdentifier", NM="_ZN5clangL17isValidIdentifierEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/CharInfo.cpp -nm=_ZN5clangL17isValidIdentifierEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ boolean isValidIdentifier(StringRef S)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isValidIdentifier(S);
}
public static /*inline*/ boolean isValidIdentifier(String S)/* __attribute__((pure))*/ {
  return /*delegate*/org.clang.basic.impl.CharInfoClangGlobals.
    isValidIdentifier(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator~">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 39,
 FQN="clang::operator~", NM="_ZN5clangcoENS_19DiagnosticLevelMaskE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangcoENS_19DiagnosticLevelMaskE")
//</editor-fold>
public static /*inline*/ /*DiagnosticLevelMask*//*uint*/int $bitnot_DiagnosticLevelMask(/*DiagnosticLevelMask*//*uint*/int M) {
  return /*delegate*/org.clang.basic.impl.DiagnosticOptionsClangGlobals.
    $bitnot_DiagnosticLevelMask(M);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator|">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 44,
 FQN="clang::operator|", NM="_ZN5clangorENS_19DiagnosticLevelMaskES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangorENS_19DiagnosticLevelMaskES0_")
//</editor-fold>
public static /*inline*/ /*DiagnosticLevelMask*//*uint*/int $bitor_DiagnosticLevelMask(/*DiagnosticLevelMask*//*uint*/int LHS, 
                          /*DiagnosticLevelMask*//*uint*/int RHS) {
  return /*delegate*/org.clang.basic.impl.DiagnosticOptionsClangGlobals.
    $bitor_DiagnosticLevelMask(LHS, 
                          RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator&">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/DiagnosticOptions.h", line = 51,
 FQN="clang::operator&", NM="_ZN5clanganENS_19DiagnosticLevelMaskES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanganENS_19DiagnosticLevelMaskES0_")
//</editor-fold>
public static /*inline*/ /*DiagnosticLevelMask*//*uint*/int $bitand_DiagnosticLevelMask(/*DiagnosticLevelMask*//*uint*/int LHS, 
                           /*DiagnosticLevelMask*//*uint*/int RHS) {
  return /*delegate*/org.clang.basic.impl.DiagnosticOptionsClangGlobals.
    $bitand_DiagnosticLevelMask(LHS, 
                           RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator==">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 180,
 FQN="clang::operator==", NM="_ZN5clangeqERKNS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangeqERKNS_14SourceLocationES2_")
//</editor-fold>
public static /*inline*/ boolean $eq_SourceLocation$C(/*const*/ SourceLocation /*&*/ LHS, /*const*/ SourceLocation /*&*/ RHS) {
  return /*delegate*/org.clang.basic.impl.SourceLocationClangGlobals.
          $eq_SourceLocation$C(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator!=">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 184,
 FQN="clang::operator!=", NM="_ZN5clangneERKNS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangneERKNS_14SourceLocationES2_")
//</editor-fold>
public static /*inline*/ boolean $noteq_SourceLocation$C(/*const*/ SourceLocation /*&*/ LHS, /*const*/ SourceLocation /*&*/ RHS) {
  return /*delegate*/org.clang.basic.impl.SourceLocationClangGlobals.
          $noteq_SourceLocation$C(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 188,
 FQN="clang::operator<", NM="_ZN5clangltERKNS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangltERKNS_14SourceLocationES2_")
//</editor-fold>
public static /*inline*/ boolean $less_SourceLocation$C(/*const*/ SourceLocation /*&*/ LHS, /*const*/ SourceLocation /*&*/ RHS) {
  return /*delegate*/org.clang.basic.impl.SourceLocationClangGlobals.
          $less_SourceLocation$C(LHS, RHS);
}
//<editor-fold defaultstate="collapsed" desc="clang::operator==">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 180,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 179,
 FQN="clang::operator==", NM="_ZN5clangeqERKNS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangeqERKNS_14SourceLocationES2_")
//</editor-fold>
public static /*inline*/ boolean $eq_SourceLocation$C(/*const*//*SourceLocation*/int /*&*/ LHS, /*const*//*SourceLocation*/int /*&*/ RHS) {
  return /*delegate*/org.clang.basic.impl.SourceLocationClangGlobals.
          $eq_SourceLocation$C(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator!=">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 184,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 183,
 FQN="clang::operator!=", NM="_ZN5clangneERKNS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangneERKNS_14SourceLocationES2_")
//</editor-fold>
public static /*inline*/ boolean $noteq_SourceLocation$C(/*const*//*SourceLocation*/int /*&*/ LHS, /*const*//*SourceLocation*/int /*&*/ RHS) {
  return /*delegate*/org.clang.basic.impl.SourceLocationClangGlobals.
          $noteq_SourceLocation$C(LHS, RHS);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED, source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", line = 188,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceLocation.h", old_line = 187,
 FQN="clang::operator<", NM="_ZN5clangltERKNS_14SourceLocationES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangltERKNS_14SourceLocationES2_")
//</editor-fold>
public static /*inline*/ boolean $less_SourceLocation$C(/*const*//*SourceLocation*/int /*&*/ LHS, /*const*//*SourceLocation*/int /*&*/ RHS) {
  return /*delegate*/org.clang.basic.impl.SourceLocationClangGlobals.
          $less_SourceLocation$C(LHS, RHS);
}


/// \brief Register a value for the flag in the current diagnostic. This
/// value will be shown as the suffix "=value" after the flag name. It is
/// useful in cases where the diagnostic flag accepts values (e.g.,
/// -Rpass or -Wframe-larger-than).
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1017,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1010,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_12AddFlagValueE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_12AddFlagValueE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_AddFlagValue$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                   /*const*/ AddFlagValue V) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_AddFlagValue$C(DB, 
                                   V);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1023,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1016,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm9StringRefE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_StringRef(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                StringRef S) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_StringRef(DB, 
                                S);
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_StringRef(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                String S) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_StringRef(DB, 
                                S);
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_StringRef(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                std.string S) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_StringRef(DB, 
                                S);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1029,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1022,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKc")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_char$ptr$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                 /*const*/char$ptr/*char P*/ Str) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_char$ptr$C(DB, 
                                 Str);
}
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.MANUAL_DUPLICATED,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1029,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1022,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKc",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKc")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_char$ptr$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                               /*const*/String/*char P*/ Str) {
  return org.clang.basic.impl.DiagnosticClangGlobals.$out_DiagnosticBuilder$C_char$ptr$C(DB, 
                               Str);
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_char$ptr$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                               /*const*/std.string/*char P*/ Str) {
  return org.clang.basic.impl.DiagnosticClangGlobals.$out_DiagnosticBuilder$C_StringRef(DB, 
                               Str);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1036,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1029,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEi",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEi")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_int(/*const*/ DiagnosticBuilder /*&*/ DB, int I) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_int(DB, I);
}


// We use enable_if here to prevent that this overload is selected for
// pointers or other arguments that are implicitly convertible to bool.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1044,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1036,
 FQN="clang::operator<<", NM="Tpl__ZN5clanglsERKNS_17DiagnosticBuilderET_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_bEE5valueERKN5clang17DiagnosticBuilderEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=Tpl__ZN5clanglsERKNS_17DiagnosticBuilderET_R_ZTSNSt9enable_ifIXsr3std7is_sameIT_bEE5valueERKN5clang17DiagnosticBuilderEE4typeE")
//</editor-fold>
public static /*inline*/ /*<typename T>*/ /*std::enable_if<std::is_same<T, boolean>::value,  DiagnosticBuilder  >::type*//*const*/ DiagnosticBuilder /*&*/ $out$Same2Bool(/*const*/ DiagnosticBuilder /*&*/ DB, boolean I) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out$Same2Bool(DB, I);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1052,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1045,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEj")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_uint(/*const*/ DiagnosticBuilder /*&*/ DB, 
                           /*uint*/int I) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_uint(DB, 
                           I);
}
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_uint(/*const*/ DiagnosticBuilder /*&*/ DB, 
                           /*uint*/boolean I) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_uint(DB, 
                           I);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1058,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1051,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_3tok9TokenKindE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_TokenKind(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                /*tok.TokenKind*/char I) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_TokenKind(DB, 
                                I);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1064,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1057,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEPKNS_14IdentifierInfoE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_IdentifierInfo$C$P(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                     /*const*/ IdentifierInfo /*P*/ II) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_IdentifierInfo$C$P(DB, 
                                     II);
}


// Adds a DeclContext to the diagnostic. The enable_if template magic is here
// so that we only match those arguments that are (statically) DeclContexts;
// other arguments that derive from DeclContext (e.g., RecordDecls) will not
// match.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1076,
 FQN="clang::operator<<", NM="Tpl__ZN5clanglsERKNS_17DiagnosticBuilderEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameINSt12remove_constIT_E4typeEN5clang11DeclContextEEE5valueERKNS4_17DiagnosticBuilderEE4typeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=Tpl__ZN5clanglsERKNS_17DiagnosticBuilderEPT_R_ZTSNSt9enable_ifIXsr3std7is_sameINSt12remove_constIT_E4typeEN5clang11DeclContextEEE5valueERKNS4_17DiagnosticBuilderEE4typeE")
//</editor-fold>
public static /*inline*/ </*typename*/ T> /*std::enable_if<std::is_same< std.remove_const<T>.type, DeclContext>::value,  DiagnosticBuilder  >::type*//*const*/ DiagnosticBuilder /*&*/ $out$Same2DeclContext(/*const*/ DiagnosticBuilder /*&*/ DB, DeclContextImplementation /*P*/ DC) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out$Same2DeclContext(DB, DC);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1085,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1078,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderENS_11SourceRangeE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_SourceRange(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                  SourceRange R) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_SourceRange(DB, 
                                  R);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1091,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1084,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_11SourceRangeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_11SourceRangeEEE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_ArrayRef$SourceRange(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                           ArrayRef<SourceRange> Ranges) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_ArrayRef$SourceRange(DB, 
                                           Ranges);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1098,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1091,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_15CharSourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_15CharSourceRangeE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_CharSourceRange$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                      /*const*/ CharSourceRange /*&*/ R) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_CharSourceRange$C(DB, 
                                      R);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1104,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1097,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_9FixItHintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_9FixItHintE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_FixItHint$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                /*const*/ FixItHint /*&*/ Hint) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_FixItHint$C(DB, 
                                Hint);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1110,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1103,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_9FixItHintEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderEN4llvm8ArrayRefINS_9FixItHintEEE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_ArrayRef$FixItHint(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                         ArrayRef<FixItHint> Hints) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_ArrayRef$FixItHint(DB, 
                                         Hints);
}


/// Special character that the diagnostic printer will use to toggle the bold
/// attribute.  The character itself will be not be printed.
//<editor-fold defaultstate="collapsed" desc="clang::ToggleHighlight">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", line = 1410,
 old_source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/Diagnostic.h", old_line = 1403,
 FQN="clang::ToggleHighlight", NM="_ZN5clangL15ToggleHighlightE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clangL15ToggleHighlightE")
//</editor-fold>
public static /*const*//*char*/byte ToggleHighlight = 127;
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/PartialDiagnostic.h", line = 399,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_17PartialDiagnosticE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderERKNS_17PartialDiagnosticE")
//</editor-fold>
public static /*inline*/ /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_PartialDiagnostic$C(/*const*/ DiagnosticBuilder /*&*/ DB, 
                                        /*const*/ PartialDiagnostic /*&*/ PD) {
  return /*delegate*/org.clang.basic.impl.PartialDiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_PartialDiagnostic$C(DB, 
                                        PD);
}

//<editor-fold defaultstate="collapsed" desc="clang::isDynamicExceptionSpec">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 33,
 FQN="clang::isDynamicExceptionSpec", NM="_ZN5clang22isDynamicExceptionSpecENS_26ExceptionSpecificationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang22isDynamicExceptionSpecENS_26ExceptionSpecificationTypeE")
//</editor-fold>
public static /*inline*/ boolean isDynamicExceptionSpec(ExceptionSpecificationType ESpecType) {
  return /*delegate*/org.clang.basic.impl.ExceptionSpecificationTypeClangGlobals.
    isDynamicExceptionSpec(ESpecType);
}

//<editor-fold defaultstate="collapsed" desc="clang::isNoexceptExceptionSpec">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 37,
 FQN="clang::isNoexceptExceptionSpec", NM="_ZN5clang23isNoexceptExceptionSpecENS_26ExceptionSpecificationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang23isNoexceptExceptionSpecENS_26ExceptionSpecificationTypeE")
//</editor-fold>
public static /*inline*/ boolean isNoexceptExceptionSpec(ExceptionSpecificationType ESpecType) {
  return /*delegate*/org.clang.basic.impl.ExceptionSpecificationTypeClangGlobals.
    isNoexceptExceptionSpec(ESpecType);
}

//<editor-fold defaultstate="collapsed" desc="clang::isUnresolvedExceptionSpec">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 41,
 FQN="clang::isUnresolvedExceptionSpec", NM="_ZN5clang25isUnresolvedExceptionSpecENS_26ExceptionSpecificationTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang25isUnresolvedExceptionSpecENS_26ExceptionSpecificationTypeE")
//</editor-fold>
public static /*inline*/ boolean isUnresolvedExceptionSpec(ExceptionSpecificationType ESpecType) {
  return /*delegate*/org.clang.basic.impl.ExceptionSpecificationTypeClangGlobals.
    isUnresolvedExceptionSpec(ESpecType);
}

//<editor-fold defaultstate="collapsed" desc="clang::mergeCanThrow">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/ExceptionSpecificationType.h", line = 52,
 FQN="clang::mergeCanThrow", NM="_ZN5clang13mergeCanThrowENS_14CanThrowResultES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/StaticAnalyzer/Core/Checker.cpp -nm=_ZN5clang13mergeCanThrowENS_14CanThrowResultES0_")
//</editor-fold>
public static /*inline*/ CanThrowResult mergeCanThrow(CanThrowResult CT1, CanThrowResult CT2) {
  return /*delegate*/org.clang.basic.impl.ExceptionSpecificationTypeClangGlobals.
    mergeCanThrow(CT1, CT2);
}

//<editor-fold defaultstate="collapsed" desc="clang::CudaVersionToString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 9,
 FQN="clang::CudaVersionToString", NM="_ZN5clang19CudaVersionToStringENS_11CudaVersionE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang19CudaVersionToStringENS_11CudaVersionE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CudaVersionToString(CudaVersion V) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    CudaVersionToString(V);
}

//<editor-fold defaultstate="collapsed" desc="clang::CudaArchToString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 23,
 FQN="clang::CudaArchToString", NM="_ZN5clang16CudaArchToStringENS_8CudaArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang16CudaArchToStringENS_8CudaArchE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CudaArchToString(CudaArch A) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    CudaArchToString(A);
}


// The input should have the form "sm_20".
//<editor-fold defaultstate="collapsed" desc="clang::StringToCudaArch">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 55,
 FQN="clang::StringToCudaArch", NM="_ZN5clang16StringToCudaArchEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang16StringToCudaArchEN4llvm9StringRefE")
//</editor-fold>
public static CudaArch StringToCudaArch(StringRef S) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    StringToCudaArch(S);
}

//<editor-fold defaultstate="collapsed" desc="clang::CudaVirtualArchToString">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 72,
 FQN="clang::CudaVirtualArchToString", NM="_ZN5clang23CudaVirtualArchToStringENS_15CudaVirtualArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang23CudaVirtualArchToStringENS_15CudaVirtualArchE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ CudaVirtualArchToString(CudaVirtualArch A) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    CudaVirtualArchToString(A);
}


// The input should have the form "compute_20".
//<editor-fold defaultstate="collapsed" desc="clang::StringToCudaVirtualArch">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 102,
 FQN="clang::StringToCudaVirtualArch", NM="_ZN5clang23StringToCudaVirtualArchEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang23StringToCudaVirtualArchEN4llvm9StringRefE")
//</editor-fold>
public static CudaVirtualArch StringToCudaVirtualArch(StringRef S) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    StringToCudaVirtualArch(S);
}


/// Get the compute_xx corresponding to an sm_yy.
//<editor-fold defaultstate="collapsed" desc="clang::VirtualArchForCudaArch">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 118,
 FQN="clang::VirtualArchForCudaArch", NM="_ZN5clang22VirtualArchForCudaArchENS_8CudaArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang22VirtualArchForCudaArchENS_8CudaArchE")
//</editor-fold>
public static CudaVirtualArch VirtualArchForCudaArch(CudaArch A) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    VirtualArchForCudaArch(A);
}


/// Get the earliest CudaVersion that supports the given CudaArch.
//<editor-fold defaultstate="collapsed" desc="clang::MinVersionForCudaArch">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp", line = 149,
 FQN="clang::MinVersionForCudaArch", NM="_ZN5clang21MinVersionForCudaArchENS_8CudaArchE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Cuda.cpp -nm=_ZN5clang21MinVersionForCudaArchENS_8CudaArchE")
//</editor-fold>
public static CudaVersion MinVersionForCudaArch(CudaArch A) {
  return /*delegate*/org.clang.basic.impl.CudaClangGlobals.
    MinVersionForCudaArch(A);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp", line = 27,
 FQN="clang::operator<<", NM="_ZN5clanglsERKNS_17DiagnosticBuilderESt4pairINS_15NullabilityKindEbE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Diagnostic.cpp -nm=_ZN5clanglsERKNS_17DiagnosticBuilderESt4pairINS_15NullabilityKindEbE")
//</editor-fold>
public static /*const*/ DiagnosticBuilder /*&*/ $out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind(/*const*/ DiagnosticBuilder /*&*/ DB, 
                           std.pairTypeBool<NullabilityKind> nullability) {
  return /*delegate*/org.clang.basic.impl.DiagnosticClangGlobals.
    $out_DiagnosticBuilder$C_pairTypeBool$NullabilityKind(DB, 
                           nullability);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticOptions.cpp", line = 19,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamENS_19DiagnosticLevelMaskE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/DiagnosticOptions.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamENS_19DiagnosticLevelMaskE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_DiagnosticLevelMask(raw_ostream /*&*/ Out, /*DiagnosticLevelMask*//*uint*/int M) {
  return /*delegate*/org.clang.basic.impl.DiagnosticOptionsClangGlobals.
    $out_raw_ostream_DiagnosticLevelMask(Out, M);
}


/// \brief Retrieve the spelling of the given overloaded operator, without 
/// the preceding "operator" keyword.
//<editor-fold defaultstate="collapsed" desc="clang::getOperatorSpelling">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 637,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 636,
 FQN="clang::getOperatorSpelling", NM="_ZN5clang19getOperatorSpellingENS_22OverloadedOperatorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang19getOperatorSpellingENS_22OverloadedOperatorKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOperatorSpelling(OverloadedOperatorKind Operator) {
  return /*delegate*/org.clang.basic.impl.IdentifierTableClangGlobals.
    getOperatorSpelling(Operator);
}


/// Retrieve the spelling of the given nullability kind.
//<editor-fold defaultstate="collapsed" desc="clang::getNullabilitySpelling">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", line = 651,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp", old_line = 650,
 FQN="clang::getNullabilitySpelling", NM="_ZN5clang22getNullabilitySpellingENS_15NullabilityKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/IdentifierTable.cpp -nm=_ZN5clang22getNullabilitySpellingENS_15NullabilityKindEb")
//</editor-fold>
public static StringRef getNullabilitySpelling(NullabilityKind kind) {
  return getNullabilitySpelling(kind, 
                      false);
}
public static StringRef getNullabilitySpelling(NullabilityKind kind, 
                      boolean isContextSensitive/*= false*/) {
  return /*delegate*/org.clang.basic.impl.IdentifierTableClangGlobals.
    getNullabilitySpelling(kind, 
                      isContextSensitive);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp", line = 28,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_11ObjCRuntimeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/ObjCRuntime.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_11ObjCRuntimeE")
//</editor-fold>
public static raw_ostream /*&*/ $out_raw_ostream_ObjCRuntime$C(raw_ostream /*&*/ out, /*const*/ ObjCRuntime /*&*/ value) {
  return /*delegate*/org.clang.basic.impl.ObjCRuntimeClangGlobals.
    $out_raw_ostream_ObjCRuntime$C(out, value);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPDirectiveKind">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 23,
 FQN="clang::getOpenMPDirectiveKind", NM="_ZN5clang22getOpenMPDirectiveKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang22getOpenMPDirectiveKindEN4llvm9StringRefE")
//</editor-fold>
public static OpenMPDirectiveKind getOpenMPDirectiveKind(StringRef Str) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    getOpenMPDirectiveKind(Str);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPDirectiveName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 31,
 FQN="clang::getOpenMPDirectiveName", NM="_ZN5clang22getOpenMPDirectiveNameENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang22getOpenMPDirectiveNameENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOpenMPDirectiveName(OpenMPDirectiveKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    getOpenMPDirectiveName(Kind);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPClauseKind">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 48,
 FQN="clang::getOpenMPClauseKind", NM="_ZN5clang19getOpenMPClauseKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang19getOpenMPClauseKindEN4llvm9StringRefE")
//</editor-fold>
public static OpenMPClauseKind getOpenMPClauseKind(StringRef Str) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    getOpenMPClauseKind(Str);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPClauseName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 62,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 61,
 FQN="clang::getOpenMPClauseName", NM="_ZN5clang19getOpenMPClauseNameENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang19getOpenMPClauseNameENS_16OpenMPClauseKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOpenMPClauseName(OpenMPClauseKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    getOpenMPClauseName(Kind);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPSimpleClauseType">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 79,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 76,
 FQN="clang::getOpenMPSimpleClauseType", NM="_ZN5clang25getOpenMPSimpleClauseTypeENS_16OpenMPClauseKindEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang25getOpenMPSimpleClauseTypeENS_16OpenMPClauseKindEN4llvm9StringRefE")
//</editor-fold>
public static /*uint*/int getOpenMPSimpleClauseType(OpenMPClauseKind Kind, 
                         StringRef Str) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    getOpenMPSimpleClauseType(Kind, 
                         Str);
}

//<editor-fold defaultstate="collapsed" desc="clang::getOpenMPSimpleClauseTypeName">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 174,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 153,
 FQN="clang::getOpenMPSimpleClauseTypeName", NM="_ZN5clang29getOpenMPSimpleClauseTypeNameENS_16OpenMPClauseKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang29getOpenMPSimpleClauseTypeNameENS_16OpenMPClauseKindEj")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ getOpenMPSimpleClauseTypeName(OpenMPClauseKind Kind, 
                             /*uint*/int Type) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    getOpenMPSimpleClauseTypeName(Kind, 
                             Type);
}

//<editor-fold defaultstate="collapsed" desc="clang::isAllowedClauseForDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 313,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 263,
 FQN="clang::isAllowedClauseForDirective", NM="_ZN5clang27isAllowedClauseForDirectiveENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang27isAllowedClauseForDirectiveENS_19OpenMPDirectiveKindENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean isAllowedClauseForDirective(OpenMPDirectiveKind DKind, 
                           OpenMPClauseKind CKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isAllowedClauseForDirective(DKind, 
                           CKind);
}


/// \brief Checks if the specified directive is a directive with an associated
/// loop construct.
/// \param DKind Specified directive.
/// \return true - the directive is a loop-associated directive like 'omp simd'
/// or 'omp for' directive, otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPLoopDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 630,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 485,
 FQN="clang::isOpenMPLoopDirective", NM="_ZN5clang21isOpenMPLoopDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang21isOpenMPLoopDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPLoopDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPLoopDirective(DKind);
}


/// \brief Checks if the specified directive is a worksharing directive.
/// \param DKind Specified directive.
/// \return true - the directive is a worksharing directive like 'omp for',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPWorksharingDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 642,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 493,
 FQN="clang::isOpenMPWorksharingDirective", NM="_ZN5clang28isOpenMPWorksharingDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang28isOpenMPWorksharingDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPWorksharingDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPWorksharingDirective(DKind);
}


/// \brief Checks if the specified directive is a taskloop directive.
/// \param DKind Specified directive.
/// \return true - the directive is a worksharing directive like 'omp taskloop',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTaskLoopDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 654,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 501,
 FQN="clang::isOpenMPTaskLoopDirective", NM="_ZN5clang25isOpenMPTaskLoopDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang25isOpenMPTaskLoopDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTaskLoopDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPTaskLoopDirective(DKind);
}


/// \brief Checks if the specified directive is a parallel-kind directive.
/// \param DKind Specified directive.
/// \return true - the directive is a parallel-like directive like 'omp
/// parallel', otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPParallelDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 658,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 505,
 FQN="clang::isOpenMPParallelDirective", NM="_ZN5clang25isOpenMPParallelDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang25isOpenMPParallelDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPParallelDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPParallelDirective(DKind);
}


/// \brief Checks if the specified directive is a target code offload directive.
/// \param DKind Specified directive.
/// \return true - the directive is a target code offload directive like
/// 'omp target', 'omp target parallel', 'omp target xxx'
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTargetExecutionDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 668,
 FQN="clang::isOpenMPTargetExecutionDirective", NM="_ZN5clang32isOpenMPTargetExecutionDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang32isOpenMPTargetExecutionDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTargetExecutionDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPTargetExecutionDirective(DKind);
}


/// \brief Checks if the specified directive is a target data offload directive.
/// \param DKind Specified directive.
/// \return true - the directive is a target data offload directive like
/// 'omp target data', 'omp target update', 'omp target enter data',
/// 'omp target exit data'
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTargetDataManagementDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 675,
 FQN="clang::isOpenMPTargetDataManagementDirective", NM="_ZN5clang37isOpenMPTargetDataManagementDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang37isOpenMPTargetDataManagementDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTargetDataManagementDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPTargetDataManagementDirective(DKind);
}


/// \brief Checks if the specified directive is a teams-kind directive.
/// \param DKind Specified directive.
/// \return true - the directive is a teams-like directive like 'omp teams',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTeamsDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 680,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 515,
 FQN="clang::isOpenMPTeamsDirective", NM="_ZN5clang22isOpenMPTeamsDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang22isOpenMPTeamsDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTeamsDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPTeamsDirective(DKind);
}


/// \brief Checks if the specified directive is a simd directive.
/// \param DKind Specified directive.
/// \return true - the directive is a simd directive like 'omp simd',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPSimdDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 684,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 519,
 FQN="clang::isOpenMPSimdDirective", NM="_ZN5clang21isOpenMPSimdDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang21isOpenMPSimdDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPSimdDirective(OpenMPDirectiveKind DKind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPSimdDirective(DKind);
}


/// \brief Checks if the specified directive is a distribute directive.
/// \param DKind Specified directive.
/// \return true - the directive is a distribute-directive like 'omp
/// distribute',
/// otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPDistributeDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 692,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 525,
 FQN="clang::isOpenMPDistributeDirective", NM="_ZN5clang27isOpenMPDistributeDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang27isOpenMPDistributeDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPDistributeDirective(OpenMPDirectiveKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPDistributeDirective(Kind);
}


/// \brief Checks if the specified clause is one of private clauses like
/// 'private', 'firstprivate', 'reduction' etc..
/// \param Kind Clause kind.
/// \return true - the clause is a private clause, otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPPrivate">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 699,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 529,
 FQN="clang::isOpenMPPrivate", NM="_ZN5clang15isOpenMPPrivateENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang15isOpenMPPrivateENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean isOpenMPPrivate(OpenMPClauseKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPPrivate(Kind);
}


/// \brief Checks if the specified clause is one of threadprivate clauses like
/// 'threadprivate', 'copyin' or 'copyprivate'.
/// \param Kind Clause kind.
/// \return true - the clause is a threadprivate clause, otherwise - false.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPThreadPrivate">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 705,
 old_source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", old_line = 535,
 FQN="clang::isOpenMPThreadPrivate", NM="_ZN5clang21isOpenMPThreadPrivateENS_16OpenMPClauseKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang21isOpenMPThreadPrivateENS_16OpenMPClauseKindE")
//</editor-fold>
public static boolean isOpenMPThreadPrivate(OpenMPClauseKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPThreadPrivate(Kind);
}


/// Checks if the specified directive kind is one of tasking directives - task,
/// taskloop or taksloop simd.
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPTaskingDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 709,
 FQN="clang::isOpenMPTaskingDirective", NM="_ZN5clang24isOpenMPTaskingDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang24isOpenMPTaskingDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPTaskingDirective(OpenMPDirectiveKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPTaskingDirective(Kind);
}


/// Checks if the specified directive kind is one of the composite or combined
/// directives that need loop bound sharing across loops outlined in nested
/// functions
//<editor-fold defaultstate="collapsed" desc="clang::isOpenMPLoopBoundSharingDirective">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp", line = 713,
 FQN="clang::isOpenMPLoopBoundSharingDirective", NM="_ZN5clang33isOpenMPLoopBoundSharingDirectiveENS_19OpenMPDirectiveKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OpenMPKinds.cpp -nm=_ZN5clang33isOpenMPLoopBoundSharingDirectiveENS_19OpenMPDirectiveKindE")
//</editor-fold>
public static boolean isOpenMPLoopBoundSharingDirective(OpenMPDirectiveKind Kind) {
  return /*delegate*/org.clang.basic.impl.OpenMPKindsClangGlobals.
    isOpenMPLoopBoundSharingDirective(Kind);
}


/// \brief Return the precedence of the specified binary operator token.
//<editor-fold defaultstate="collapsed" desc="clang::getBinOpPrecedence">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/OperatorPrecedence.cpp", line = 18,
 FQN="clang::getBinOpPrecedence", NM="_ZN5clang18getBinOpPrecedenceENS_3tok9TokenKindEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/OperatorPrecedence.cpp -nm=_ZN5clang18getBinOpPrecedenceENS_3tok9TokenKindEbb")
//</editor-fold>
public static prec.Level getBinOpPrecedence(/*tok.TokenKind*/char Kind, boolean GreaterThanIsOperator, 
                  boolean CPlusPlus11) {
  return /*delegate*/org.clang.basic.impl.OperatorPrecedenceClangGlobals.
    getBinOpPrecedence(Kind, GreaterThanIsOperator, 
                  CPlusPlus11);
}


/// Parse a single value from a -fsanitize= or -fno-sanitize= value list.
/// Returns a non-zero SanitizerMask, or \c 0 if \p Value is not known.
//<editor-fold defaultstate="collapsed" desc="clang::parseSanitizerValue">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp", line = 20,
 FQN="clang::parseSanitizerValue", NM="_ZN5clang19parseSanitizerValueEN4llvm9StringRefEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang19parseSanitizerValueEN4llvm9StringRefEb")
//</editor-fold>
public static long/*uint64_t*/ parseSanitizerValue(StringRef Value, boolean AllowGroups) {
  return /*delegate*/org.clang.basic.impl.SanitizersClangGlobals.
    parseSanitizerValue(Value, AllowGroups);
}


/// For each sanitizer group bit set in \p Kinds, set the bits for sanitizers
/// this group enables.
//<editor-fold defaultstate="collapsed" desc="clang::expandSanitizerGroups">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp", line = 30,
 FQN="clang::expandSanitizerGroups", NM="_ZN5clang21expandSanitizerGroupsEy",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Sanitizers.cpp -nm=_ZN5clang21expandSanitizerGroupsEy")
//</editor-fold>
public static long/*uint64_t*/ expandSanitizerGroups(long/*uint64_t*/ Kinds) {
  return /*delegate*/org.clang.basic.impl.SanitizersClangGlobals.
    expandSanitizerGroups(Kinds);
}


// needed for FindNearestLineEntry (upper_bound of LineEntry)
//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 63,
 FQN="clang::operator<", NM="_ZN5clangltERKNS_9LineEntryES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clangltERKNS_9LineEntryES2_")
//</editor-fold>
public static /*inline*/ boolean $less_LineEntry$C(/*const*/ LineEntry /*&*/ lhs, /*const*/ LineEntry /*&*/ rhs) {
  return /*delegate*/org.clang.basic.impl.SourceManagerInternalsClangGlobals.
    $less_LineEntry$C(lhs, rhs);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 68,
 FQN="clang::operator<", NM="_ZN5clangltERKNS_9LineEntryEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clangltERKNS_9LineEntryEj")
//</editor-fold>
public static /*inline*/ boolean $less_LineEntry$C_uint(/*const*/ LineEntry /*&*/ E, /*uint*/int Offset) {
  return /*delegate*/org.clang.basic.impl.SourceManagerInternalsClangGlobals.
    $less_LineEntry$C_uint(E, Offset);
}

//<editor-fold defaultstate="collapsed" desc="clang::operator<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/include/clang/Basic/SourceManagerInternals.h", line = 72,
 FQN="clang::operator<", NM="_ZN5clangltEjRKNS_9LineEntryE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/SourceManager.cpp -nm=_ZN5clangltEjRKNS_9LineEntryE")
//</editor-fold>
public static /*inline*/ boolean $less_uint_LineEntry$C(/*uint*/int Offset, /*const*/ LineEntry /*&*/ E) {
  return /*delegate*/org.clang.basic.impl.SourceManagerInternalsClangGlobals.
    $less_uint_LineEntry$C(Offset, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::getParameterABISpelling">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp", line = 636,
 FQN="clang::getParameterABISpelling", NM="_ZN5clang23getParameterABISpellingENS_12ParameterABIE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/AST/TypePrinter.cpp -nm=_ZN5clang23getParameterABISpellingENS_12ParameterABIE")
//</editor-fold>
public static StringRef getParameterABISpelling(ParameterABI ABI) {
  return /*delegate*/org.clang.basic.impl.SpecifiersClangGlobals.
    getParameterABISpelling(ABI);
}

/// \brief Retrieves the repository path (e.g., Subversion path) that
/// identifies the particular Clang branch, tag, or trunk from which this
/// Clang was built.
//<editor-fold defaultstate="collapsed" desc="clang::getClangRepositoryPath">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 27,
 FQN="clang::getClangRepositoryPath", NM="_ZN5clang22getClangRepositoryPathEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang22getClangRepositoryPathEv")
//</editor-fold>
public static std.string getClangRepositoryPath() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getClangRepositoryPath();
}


/// \brief Retrieves the repository path from which LLVM was built.
///
/// This supports LLVM residing in a separate repository from clang.
//<editor-fold defaultstate="collapsed" desc="clang::getLLVMRepositoryPath">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 57,
 FQN="clang::getLLVMRepositoryPath", NM="_ZN5clang21getLLVMRepositoryPathEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang21getLLVMRepositoryPathEv")
//</editor-fold>
public static std.string getLLVMRepositoryPath() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getLLVMRepositoryPath();
}


/// \brief Retrieves the repository revision number (or identifer) from which
/// this Clang was built.
//<editor-fold defaultstate="collapsed" desc="clang::getClangRevision">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 74,
 FQN="clang::getClangRevision", NM="_ZN5clang16getClangRevisionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang16getClangRevisionEv")
//</editor-fold>
public static std.string getClangRevision() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getClangRevision();
}


/// \brief Retrieves the repository revision number (or identifer) from which
/// LLVM was built.
///
/// If Clang and LLVM are in the same repository, this returns the same
/// string as getClangRevision.
//<editor-fold defaultstate="collapsed" desc="clang::getLLVMRevision">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 82,
 FQN="clang::getLLVMRevision", NM="_ZN5clang15getLLVMRevisionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang15getLLVMRevisionEv")
//</editor-fold>
public static std.string getLLVMRevision() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getLLVMRevision();
}


/// \brief Retrieves the full repository version that is an amalgamation of
/// the information in getClangRepositoryPath() and getClangRevision().
//<editor-fold defaultstate="collapsed" desc="clang::getClangFullRepositoryVersion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 90,
 FQN="clang::getClangFullRepositoryVersion", NM="_ZN5clang29getClangFullRepositoryVersionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang29getClangFullRepositoryVersionEv")
//</editor-fold>
public static std.string getClangFullRepositoryVersion() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getClangFullRepositoryVersion();
}


/// \brief Retrieves a string representing the complete clang version,
/// which includes the clang version number, the repository version,
/// and the vendor tag.
//<editor-fold defaultstate="collapsed" desc="clang::getClangFullVersion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 118,
 FQN="clang::getClangFullVersion", NM="_ZN5clang19getClangFullVersionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang19getClangFullVersionEv")
//</editor-fold>
public static std.string getClangFullVersion() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getClangFullVersion();
}


/// \brief Like getClangFullVersion(), but with a custom tool name.
//<editor-fold defaultstate="collapsed" desc="clang::getClangToolFullVersion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 122,
 FQN="clang::getClangToolFullVersion", NM="_ZN5clang23getClangToolFullVersionEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang23getClangToolFullVersionEN4llvm9StringRefE")
//</editor-fold>
public static std.string getClangToolFullVersion(StringRef ToolName) {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getClangToolFullVersion(ToolName);
}


/// \brief Retrieves a string representing the complete clang version suitable
/// for use in the CPP __VERSION__ macro, which includes the clang version
/// number, the repository version, and the vendor tag.
//<editor-fold defaultstate="collapsed" desc="clang::getClangFullCPPVersion">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp", line = 139,
 FQN="clang::getClangFullCPPVersion", NM="_ZN5clang22getClangFullCPPVersionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Version.cpp -nm=_ZN5clang22getClangFullCPPVersionEv")
//</editor-fold>
public static std.string getClangFullCPPVersion() {
  return /*delegate*/org.clang.basic.impl.VersionClangGlobals.
    getClangFullCPPVersion();
}


/// \brief Print a version number.
//<editor-fold defaultstate="collapsed" desc="clang::operator<<">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp", line = 28,
 FQN="clang::operator<<", NM="_ZN5clanglsERN4llvm11raw_ostreamERKNS_12VersionTupleE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/VersionTuple.cpp -nm=_ZN5clanglsERN4llvm11raw_ostreamERKNS_12VersionTupleE")
//</editor-fold>
public static raw_ostream /*&*/$out_raw_ostream_VersionTuple$C(raw_ostream /*&*/ Out, 
                             /*const*/ VersionTuple /*&*/ V) {
  return /*delegate*/org.clang.basic.impl.VersionTupleClangGlobals.
   $out_raw_ostream_VersionTuple$C(Out, 
                             V);
}


/// ProcessWarningOptions - Initialize the diagnostic client and process the
/// warning options specified on the command line.
//<editor-fold defaultstate="collapsed" desc="clang::ProcessWarningOptions">
@Converted(kind = Converted.Kind.BODY_DELEGATE,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Basic/Warnings.cpp", line = 44,
 FQN="clang::ProcessWarningOptions", NM="_ZN5clang21ProcessWarningOptionsERNS_17DiagnosticsEngineERKNS_17DiagnosticOptionsEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.basic/llvmToClangType -body-delegate ${LLVM_SRC}/llvm/tools/clang/lib/Basic/Warnings.cpp -nm=_ZN5clang21ProcessWarningOptionsERNS_17DiagnosticsEngineERKNS_17DiagnosticOptionsEb")
//</editor-fold>
public static void ProcessWarningOptions(DiagnosticsEngine /*&*/ Diags, 
                     /*const*/ DiagnosticOptions /*&*/ Opts) {
  ProcessWarningOptions(Diags, 
                     Opts, 
                     true);
}
public static void ProcessWarningOptions(DiagnosticsEngine /*&*/ Diags, 
                     /*const*/ DiagnosticOptions /*&*/ Opts, 
                     boolean ReportDiags/*= true*/) {
  /*delegate*/org.clang.basic.impl.WarningsClangGlobals.
    ProcessWarningOptions(Diags, 
                     Opts, 
                     ReportDiags);
}

} // END OF class BasicClangGlobals
