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
import static org.llvm.adt.ADTAliases.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.java.AstJavaDifferentiators.*;
import org.clang.basic.*;
import org.clang.lex.llvm.*;
import org.clang.sema.impl.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.basic.java.BasicFunctionPointers.*;
import org.clang.sema.java.SemaJavaDifferentiators.*;
import static org.clang.sema.impl.SemaTemplateStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaTemplate">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaStmtAttr ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema14isTemplateNameEPNS_5ScopeERNS_12CXXScopeSpecEbRNS_13UnqualifiedIdENS_9OpaquePtrINS_8QualTypeEEEbRNS7_INS_12TemplateNameEEERb;_ZN5clang4Sema17ActOnDependentTagEPNS_5ScopeEjNS0_10TagUseKindERKNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_14SourceLocationES9_;_ZN5clang4Sema17ActOnTypenameTypeEPNS_5ScopeENS_14SourceLocationERKNS_12CXXScopeSpecERKNS_14IdentifierInfoES3_;_ZN5clang4Sema17ActOnTypenameTypeEPNS_5ScopeENS_14SourceLocationERKNS_12CXXScopeSpecES3_NS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_;_ZN5clang4Sema17CheckTypenameTypeENS_21ElaboratedTypeKeywordENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_14IdentifierInfoES2_;_ZN5clang4Sema18ActOnTypeParameterEPNS_5ScopeEbNS_14SourceLocationES3_PNS_14IdentifierInfoES3_jjS3_NS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang4Sema18CheckClassTemplateEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationERNS_12CXXScopeSpecEPNS_14IdentifierInfoES4_PNS_13AttributeListEPNS_21TemplateParameterListENS_15AccessSpecifierES4_S4_jPSC_PNS0_12SkipBodyInfoE;_ZN5clang4Sema18CheckVarTemplateIdEPNS_15VarTemplateDeclENS_14SourceLocationES3_RKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema18CheckVarTemplateIdERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEPNS_15VarTemplateDeclENS_14SourceLocationEPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema18LookupTemplateNameERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecENS_8QualTypeEbRb;_ZN5clang4Sema19ActOnTemplateIdTypeERNS_12CXXScopeSpecENS_14SourceLocationENS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_b;_ZN5clang4Sema19BuildTemplateIdExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEbPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema19CheckTemplateIdTypeENS_12TemplateNameENS_14SourceLocationERNS_24TemplateArgumentListInfoE;_ZN5clang4Sema20AdjustDeclIfTemplateERPNS_4DeclE;_ZN5clang4Sema21CheckTemplateArgumentEPNS_20TemplateTypeParmDeclEPNS_14TypeSourceInfoE;_ZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindE;_ZN5clang4Sema21CheckTemplateArgumentEPNS_24TemplateTemplateParmDeclERNS_19TemplateArgumentLocEj;_ZN5clang4Sema21CheckTemplateArgumentEPNS_9NamedDeclERNS_19TemplateArgumentLocES2_NS_14SourceLocationES5_jRN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS0_25CheckTemplateArgumentKindE;_ZN5clang4Sema21NoteAllFoundTemplatesENS_12TemplateNameE;_ZN5clang4Sema22ActOnTagTemplateIdTypeENS0_10TagUseKindENS_17TypeSpecifierTypeENS_14SourceLocationERNS_12CXXScopeSpecES3_NS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_;_ZN5clang4Sema22CheckTemplateDeclScopeEPNS_5ScopeEPNS_21TemplateParameterListE;_ZN5clang4Sema23ActOnTemplateDeclaratorEPNS_5ScopeEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERNS_10DeclaratorE;_ZN5clang4Sema24MarkAsLateParsedTemplateEPNS_12FunctionDeclEPNS_4DeclERN4llvm11SmallVectorINS_5TokenELj4EEE;_ZN5clang4Sema25BuildDependentDeclRefExprERKNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema25CheckMemberSpecializationEPNS_9NamedDeclERNS_12LookupResultE;_ZN5clang4Sema25CheckTemplateArgumentListEPNS_12TemplateDeclENS_14SourceLocationERNS_24TemplateArgumentListInfoEbRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE;_ZN5clang4Sema25CheckTemplateTypeArgumentEPNS_20TemplateTypeParmDeclERNS_19TemplateArgumentLocERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE;_ZN5clang4Sema26ActOnDependentIdExpressionERKNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEbPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema26ActOnDependentTemplateNameEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdENS_9OpaquePtrINS_8QualTypeEEEbRNS8_INS_12TemplateNameEEE;_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_RNS_10DeclaratorE;_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_jS3_RKNS_12CXXScopeSpecENS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_PNS_13AttributeListE;_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_jS3_RNS_12CXXScopeSpecEPNS_14IdentifierInfoES3_PNS_13AttributeListE;_ZN5clang4Sema26ActOnTemplateParameterListEjNS_14SourceLocationES1_S1_N4llvm8ArrayRefIPNS_4DeclEEES1_PNS_4ExprE;_ZN5clang4Sema26CheckTemplateParameterListEPNS_21TemplateParameterListES2_NS0_24TemplateParamListContextE;_ZN5clang4Sema26UnmarkAsLateParsedTemplateEPNS_12FunctionDeclE;_ZN5clang4Sema26translateTemplateArgumentsERKN4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEERNS_24TemplateArgumentListInfoE;_ZN5clang4Sema27DiagnoseUnknownTemplateNameERKNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPKNS_12CXXScopeSpecERNS_9OpaquePtrINS_12TemplateNameEEERNS_16TemplateNameKindE;_ZN5clang4Sema28BuildQualifiedTemplateIdExprERNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE;_ZN5clang4Sema29ActOnNonTypeTemplateParameterEPNS_5ScopeERNS_10DeclaratorEjjNS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema29FilterAcceptableTemplateNamesERNS_12LookupResultEb;_ZN5clang4Sema29checkSpecializationVisibilityENS_14SourceLocationEPNS_9NamedDeclE;_ZN5clang4Sema29hasAnyAcceptableTemplateNamesERNS_12LookupResultEb;_ZN5clang4Sema30ActOnTemplateTemplateParameterEPNS_5ScopeENS_14SourceLocationEPNS_21TemplateParameterListES3_PNS_14IdentifierInfoES3_jjS3_NS_22ParsedTemplateArgumentE;_ZN5clang4Sema30ActOnVarTemplateSpecializationEPNS_5ScopeERNS_10DeclaratorEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_21TemplateParameterListENS_12StorageClassEb;_ZN5clang4Sema30TemplateParameterListsAreEqualEPNS_21TemplateParameterListES2_bNS0_30TemplateParameterListEqualKindENS_14SourceLocationE;_ZN5clang4Sema31DiagnoseTemplateParameterShadowENS_14SourceLocationEPNS_4DeclE;_ZN5clang4Sema31getTemplateArgumentBindingsTextEPKNS_21TemplateParameterListEPKNS_16TemplateArgumentEj;_ZN5clang4Sema31getTemplateArgumentBindingsTextEPKNS_21TemplateParameterListERKNS_20TemplateArgumentListE;_ZN5clang4Sema32ActOnClassTemplateSpecializationEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationES4_RNS_20TemplateIdAnnotationEPNS_13AttributeListEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS0_12SkipBodyInfoE;_ZN5clang4Sema33CheckNonTypeTemplateParameterTypeENS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema33RebuildExprInCurrentInstantiationEPNS_4ExprE;_ZN5clang4Sema33RebuildTypeInCurrentInstantiationEPNS_14TypeSourceInfoENS_14SourceLocationENS_15DeclarationNameE;_ZN5clang4Sema35CheckFunctionTemplateSpecializationEPNS_12FunctionDeclEPNS_24TemplateArgumentListInfoERNS_12LookupResultE;_ZN5clang4Sema36checkPartialSpecializationVisibilityENS_14SourceLocationEPNS_9NamedDeclE;_ZN5clang4Sema38CheckSpecializationInstantiationRedeclENS_14SourceLocationENS_26TemplateSpecializationKindEPNS_9NamedDeclES2_S1_Rb;_ZN5clang4Sema39BuildExpressionFromDeclTemplateArgumentERKNS_16TemplateArgumentENS_8QualTypeENS_14SourceLocationE;_ZN5clang4Sema39MatchTemplateParametersToScopeSpecifierENS_14SourceLocationES1_RKNS_12CXXScopeSpecEPNS_20TemplateIdAnnotationEN4llvm8ArrayRefIPNS_21TemplateParameterListEEEbRbSC_;_ZN5clang4Sema39SubstDefaultTemplateArgumentIfAvailableEPNS_12TemplateDeclENS_14SourceLocationES3_PNS_4DeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERb;_ZN5clang4Sema42IsInsideALocalClassWithinATemplateFunctionEv;_ZN5clang4Sema43BuildExpressionFromIntegralTemplateArgumentERKNS_16TemplateArgumentENS_14SourceLocationE;_ZN5clang4Sema43RebuildTemplateParamsInCurrentInstantiationEPNS_21TemplateParameterListE;_ZN5clang4Sema44CheckDependentFunctionTemplateSpecializationEPNS_12FunctionDeclERKNS_24TemplateArgumentListInfoERNS_12LookupResultE;_ZN5clang4Sema48RebuildNestedNameSpecifierInCurrentInstantiationERNS_12CXXScopeSpecE; -static-type=Sema_SemaTemplate -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaTemplate extends Sema_SemaStmtAttr {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// \brief We've found a use of a templated declaration that would trigger an
/// implicit instantiation. Check that any relevant explicit specializations
/// and partial specializations are visible, and diagnose if not.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkSpecializationVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8739,
 FQN="clang::Sema::checkSpecializationVisibility", NM="_ZN5clang4Sema29checkSpecializationVisibilityENS_14SourceLocationEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema29checkSpecializationVisibilityENS_14SourceLocationEPNS_9NamedDeclE")
//</editor-fold>
public final void checkSpecializationVisibility(SourceLocation Loc, NamedDecl /*P*/ Spec) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!$this().getLangOpts().Modules) {
      return;
    }
    
    $c$.track(new ExplicitSpecializationVisibilityChecker(/*Deref*/$this(), new SourceLocation(Loc))).check(Spec); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// \brief We've found a use of a template specialization that would select a
/// partial specialization. Check that the partial specialization is visible,
/// and diagnose if not.

/// \brief Check whether a template partial specialization that we've discovered
/// is hidden, and produce suitable diagnostics if so.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkPartialSpecializationVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8748,
 FQN="clang::Sema::checkPartialSpecializationVisibility", NM="_ZN5clang4Sema36checkPartialSpecializationVisibilityENS_14SourceLocationEPNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema36checkPartialSpecializationVisibilityENS_14SourceLocationEPNS_9NamedDeclE")
//</editor-fold>
public final void checkPartialSpecializationVisibility(SourceLocation Loc, 
                                    NamedDecl /*P*/ Spec) {
  SmallVector<Module /*P*/> Modules/*J*/= new SmallVector<Module /*P*/>(8, (Module /*P*/)null);
  if (!$this().hasVisibleDeclaration(Spec, $AddrOf(Modules))) {
    $this().diagnoseMissingImport(new SourceLocation(Loc), Spec, Spec.getLocation(), new ArrayRef<Module /*P*/ >(Modules, true), 
        MissingImportKind.PartialSpecialization, 
        /*Recover*/ true);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDependentTag">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8109,
 FQN="clang::Sema::ActOnDependentTag", NM="_ZN5clang4Sema17ActOnDependentTagEPNS_5ScopeEjNS0_10TagUseKindERKNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_14SourceLocationES9_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema17ActOnDependentTagEPNS_5ScopeEjNS0_10TagUseKindERKNS_12CXXScopeSpecEPNS_14IdentifierInfoENS_14SourceLocationES9_")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnDependentTag(Scope /*P*/ S, /*uint*/int TagSpec, TagUseKind TUK, 
                 final /*const*/ CXXScopeSpec /*&*/ SS, IdentifierInfo /*P*/ Name, 
                 SourceLocation TagLoc, SourceLocation NameLoc) {
  TypeLocBuilder TLB = null;
  try {
    // This has to hold, because SS is expected to be defined.
    assert ((Name != null)) : "Expected a name in a dependent tag";
    
    NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
    if (!(NNS != null)) {
      return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
    }
    
    TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec);
    if (TUK == TagUseKind.TUK_Declaration || TUK == TagUseKind.TUK_Definition) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_dependent_tag_decl)), 
                    (TUK == TagUseKind.TUK_Definition)), Kind), SS.getRange()));
        return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
      } finally {
        $c$.$destroy();
      }
    }
    
    // Create the resulting type.
    ElaboratedTypeKeyword Kwd = TypeWithKeyword.getKeywordForTagTypeKind(Kind);
    QualType Result = $this().Context.getDependentNameType(Kwd, NNS, Name);
    
    // Create type-source location information for this type.
    TLB/*J*/= new TypeLocBuilder();
    DependentNameTypeLoc TL = TLB.<DependentNameTypeLoc>push(DependentNameTypeLoc.class, new QualType(Result));
    TL.setElaboratedKeywordLoc(new SourceLocation(TagLoc));
    TL.setQualifierLoc(SS.getWithLocInContext($this().Context));
    TL.setNameLoc(new SourceLocation(NameLoc));
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(Result), TLB.getTypeSourceInfo($this().Context, new QualType(Result))));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
  }
}


/// ActOnDependentIdExpression - Handle a dependent id-expression that
/// was just parsed.  This is only possible with an explicit scope
/// specifier naming a dependent type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDependentIdExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 410,
 FQN="clang::Sema::ActOnDependentIdExpression", NM="_ZN5clang4Sema26ActOnDependentIdExpressionERKNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEbPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26ActOnDependentIdExpressionERKNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEbPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnDependentIdExpression(final /*const*/ CXXScopeSpec /*&*/ SS, 
                          SourceLocation TemplateKWLoc, 
                          final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                          boolean isAddressOfOperand, 
                          /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  DeclContext /*P*/ DC = $this().getFunctionLevelDeclContext();
  
  // C++11 [expr.prim.general]p12:
  //   An id-expression that denotes a non-static data member or non-static
  //   member function of a class can only be used:
  //   (...)
  //   - if that id-expression denotes a non-static data member and it
  //     appears in an unevaluated operand.
  //
  // If this might be the case, form a DependentScopeDeclRefExpr instead of a
  // CXXDependentScopeMemberExpr. The former can instantiate to either
  // DeclRefExpr or MemberExpr depending on lookup results, while the latter is
  // always a MemberExpr.
  boolean MightBeCxx11UnevalField = $this().getLangOpts().CPlusPlus11 && $this().isUnevaluatedContext();
  if (!MightBeCxx11UnevalField && !isAddressOfOperand
     && isa_CXXMethodDecl(DC) && cast_CXXMethodDecl(DC).isInstance()) {
    QualType ThisType = cast_CXXMethodDecl(DC).getThisType($this().Context);
    
    // Since the 'this' expression is synthesized, we don't need to
    // perform the double-lookup check.
    NamedDecl /*P*/ FirstQualifierInScope = null;
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXDependentScopeMemberExpr.Create($this().Context, /*This*/ (Expr /*P*/ )null, new QualType(ThisType), /*IsArrow*/ true, 
            /*Op*/ new SourceLocation(), SS.getWithLocInContext($this().Context), new SourceLocation(TemplateKWLoc), 
            FirstQualifierInScope, new DeclarationNameInfo(NameInfo), TemplateArgs));
  }
  
  return $this().BuildDependentDeclRefExpr(SS, new SourceLocation(TemplateKWLoc), NameInfo, TemplateArgs);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildDependentDeclRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 449,
 FQN="clang::Sema::BuildDependentDeclRefExpr", NM="_ZN5clang4Sema25BuildDependentDeclRefExprERKNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema25BuildDependentDeclRefExprERKNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildDependentDeclRefExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                         SourceLocation TemplateKWLoc, 
                         final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                         /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DependentScopeDeclRefExpr.Create($this().Context, SS.getWithLocInContext($this().Context), new SourceLocation(TemplateKWLoc), NameInfo, 
          TemplateArgs));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::MarkAsLateParsedTemplate">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair and other*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8575,
 FQN="clang::Sema::MarkAsLateParsedTemplate", NM="_ZN5clang4Sema24MarkAsLateParsedTemplateEPNS_12FunctionDeclEPNS_4DeclERN4llvm11SmallVectorINS_5TokenELj4EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema24MarkAsLateParsedTemplateEPNS_12FunctionDeclEPNS_4DeclERN4llvm11SmallVectorINS_5TokenELj4EEE")
//</editor-fold>
public final void MarkAsLateParsedTemplate(FunctionDecl /*P*/ FD, Decl /*P*/ FnD, 
                        final SmallVectorToken /*&*/ Toks) {
  if (!(FD != null)) {
    return;
  }
  
  LateParsedTemplate /*P*/ LPT = new LateParsedTemplate();
  
  // Take tokens to avoid allocations
  LPT.Toks.swap(Toks);
  LPT.D = FnD;
  $this().LateParsedTemplateMap.insert(std.make_pair_Ptr_Ptr(FD, LPT));
  
  FD.setLateTemplateParsed(true);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::UnmarkAsLateParsedTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8590,
 FQN="clang::Sema::UnmarkAsLateParsedTemplate", NM="_ZN5clang4Sema26UnmarkAsLateParsedTemplateEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26UnmarkAsLateParsedTemplateEPNS_12FunctionDeclE")
//</editor-fold>
public final void UnmarkAsLateParsedTemplate(FunctionDecl /*P*/ FD) {
  if (!(FD != null)) {
    return;
  }
  FD.setLateTemplateParsed(false);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsInsideALocalClassWithinATemplateFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8596,
 FQN="clang::Sema::IsInsideALocalClassWithinATemplateFunction", NM="_ZN5clang4Sema42IsInsideALocalClassWithinATemplateFunctionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema42IsInsideALocalClassWithinATemplateFunctionEv")
//</editor-fold>
public final boolean IsInsideALocalClassWithinATemplateFunction() {
  DeclContext /*P*/ DC = $this().CurContext;
  while ((DC != null)) {
    {
      CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl($this().CurContext);
      if ((RD != null)) {
        /*const*/ FunctionDecl /*P*/ FD = RD.isLocalClass();
        return ((FD != null) && FD.getTemplatedKind() != FunctionDecl.TemplatedKind.TK_NonTemplate);
      } else if (DC.isTranslationUnit() || DC.isNamespace()) {
        return false;
      }
    }
    
    DC = DC.getParent();
  }
  return false;
}


//===--------------------------------------------------------------------===//
// C++ Templates [C++ 14]
//
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FilterAcceptableTemplateNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 91,
 FQN="clang::Sema::FilterAcceptableTemplateNames", NM="_ZN5clang4Sema29FilterAcceptableTemplateNamesERNS_12LookupResultEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema29FilterAcceptableTemplateNamesERNS_12LookupResultEb")
//</editor-fold>
public final void FilterAcceptableTemplateNames(final LookupResult /*&*/ R) {
  FilterAcceptableTemplateNames(R, 
                             true);
}
public final void FilterAcceptableTemplateNames(final LookupResult /*&*/ R, 
                             boolean AllowFunctionTemplates/*= true*/) {
  LookupResult.Filter filter = null;
  try {
    // The set of class templates we've already seen.
    SmallPtrSet<ClassTemplateDecl /*P*/ > ClassTemplates/*J*/= new SmallPtrSet<ClassTemplateDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    filter = R.makeFilter();
    while (filter.hasNext()) {
      NamedDecl /*P*/ Orig = filter.next();
      NamedDecl /*P*/ Repl = isAcceptableTemplateName($this().Context, Orig, 
          AllowFunctionTemplates);
      if (!(Repl != null)) {
        filter.erase();
      } else if (Repl != Orig) {
        {
          
          // C++ [temp.local]p3:
          //   A lookup that finds an injected-class-name (10.2) can result in an
          //   ambiguity in certain cases (for example, if it is found in more than
          //   one base class). If all of the injected-class-names that are found
          //   refer to specializations of the same class template, and if the name
          //   is used as a template-name, the reference refers to the class
          //   template itself and not a specialization thereof, and is not
          //   ambiguous.
          ClassTemplateDecl /*P*/ ClassTmpl = dyn_cast_ClassTemplateDecl(Repl);
          if ((ClassTmpl != null)) {
            if (!ClassTemplates.insert(ClassTmpl).second) {
              filter.erase();
              continue;
            }
          }
        }
        
        // FIXME: we promote access to public here as a workaround to
        // the fact that LookupResult doesn't let us remember that we
        // found this template through a particular injected class name,
        // which means we end up doing nasty things to the invariants.
        // Pretending that access is public is *much* safer.
        filter.replace(Repl, AccessSpecifier.AS_public);
      }
    }
    filter.done();
  } finally {
    if (filter != null) { filter.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::hasAnyAcceptableTemplateNames">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 129,
 FQN="clang::Sema::hasAnyAcceptableTemplateNames", NM="_ZN5clang4Sema29hasAnyAcceptableTemplateNamesERNS_12LookupResultEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema29hasAnyAcceptableTemplateNamesERNS_12LookupResultEb")
//</editor-fold>
public final boolean hasAnyAcceptableTemplateNames(final LookupResult /*&*/ R) {
  return hasAnyAcceptableTemplateNames(R, 
                             true);
}
public final boolean hasAnyAcceptableTemplateNames(final LookupResult /*&*/ R, 
                             boolean AllowFunctionTemplates/*= true*/) {
  for (UnresolvedSetIterator I = R.begin(), IEnd = R.end(); I.$noteq(IEnd); I.$preInc())  {
    if ((isAcceptableTemplateName($this().Context, I.$star(), AllowFunctionTemplates) != null)) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::LookupTemplateName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 250,
 FQN="clang::Sema::LookupTemplateName", NM="_ZN5clang4Sema18LookupTemplateNameERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecENS_8QualTypeEbRb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema18LookupTemplateNameERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecENS_8QualTypeEbRb")
//</editor-fold>
public final void LookupTemplateName(final LookupResult /*&*/ Found, 
                  Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                  QualType ObjectType, 
                  boolean EnteringContext, 
                  final bool$ref/*bool &*/ MemberOfUnknownSpecialization) {
  // Determine where to perform name lookup
  MemberOfUnknownSpecialization.$set(false);
  DeclContext /*P*/ LookupCtx = null;
  boolean isDependent = false;
  if (!ObjectType.isNull()) {
    // This nested-name-specifier occurs in a member access expression, e.g.,
    // x->B::f, and we are looking into the type of the object.
    assert (!SS.isSet()) : "ObjectType and scope specifier cannot coexist";
    LookupCtx = $this().computeDeclContext(new QualType(ObjectType));
    isDependent = ObjectType.$arrow().isDependentType();
    assert ((isDependent || !ObjectType.$arrow().isIncompleteType() || ObjectType.$arrow().castAs(TagType.class).isBeingDefined())) : "Caller should have completed object type";
    
    // Template names cannot appear inside an Objective-C class or object type.
    if (ObjectType.$arrow().isObjCObjectOrInterfaceType()) {
      Found.clear();
      return;
    }
  } else if (SS.isSet()) {
    // This nested-name-specifier occurs after another nested-name-specifier,
    // so long into the context associated with the prior nested-name-specifier.
    LookupCtx = $this().computeDeclContext(SS, EnteringContext);
    isDependent = $this().isDependentScopeSpecifier(SS);
    
    // The declaration context must be complete.
    if ((LookupCtx != null) && $this().RequireCompleteDeclContext(SS, LookupCtx)) {
      return;
    }
  }
  
  boolean ObjectTypeSearchedInScope = false;
  boolean AllowFunctionTemplatesInLookup = true;
  if ((LookupCtx != null)) {
    // Perform "qualified" name lookup into the declaration context we
    // computed, which is either the type of the base of a member access
    // expression or the declaration context associated with a prior
    // nested-name-specifier.
    $this().LookupQualifiedName(Found, LookupCtx);
    if (!ObjectType.isNull() && Found.empty()) {
      // C++ [basic.lookup.classref]p1:
      //   In a class member access expression (5.2.5), if the . or -> token is
      //   immediately followed by an identifier followed by a <, the
      //   identifier must be looked up to determine whether the < is the
      //   beginning of a template argument list (14.2) or a less-than operator.
      //   The identifier is first looked up in the class of the object
      //   expression. If the identifier is not found, it is then looked up in
      //   the context of the entire postfix-expression and shall name a class
      //   or function template.
      if ((S != null)) {
        $this().LookupName(Found, S);
      }
      ObjectTypeSearchedInScope = true;
      AllowFunctionTemplatesInLookup = false;
    }
  } else if (isDependent && (!(S != null) || ObjectType.isNull())) {
    // We cannot look into a dependent object type or nested nme
    // specifier.
    MemberOfUnknownSpecialization.$set(true);
    return;
  } else {
    // Perform unqualified name lookup in the current scope.
    $this().LookupName(Found, S);
    if (!ObjectType.isNull()) {
      AllowFunctionTemplatesInLookup = false;
    }
  }
  if (Found.empty() && !isDependent) {
    unique_ptr<CorrectionCandidateCallback> FilterCCC = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If we did not find any names, attempt to correct any typos.
      DeclarationName Name = Found.getLookupName();
      Found.clear();
      // Simple filter callback that, for keywords, only accepts the C++ *_cast
      FilterCCC = llvm.make_unique(new CorrectionCandidateCallback());
      FilterCCC.$arrow().WantTypeSpecifiers = false;
      FilterCCC.$arrow().WantExpressionKeywords = false;
      FilterCCC.$arrow().WantRemainingKeywords = false;
      FilterCCC.$arrow().WantCXXNamedCasts = true;
      {
        TypoCorrection Corrected = null;
        try {
          Corrected = $c$.clean($this().CorrectTypo(Found.getLookupNameInfo(), Found.getLookupKind(), S, $AddrOf(SS), 
              $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Move.INSTANCE, std.move(FilterCCC))), CorrectTypoKind.CTK_ErrorRecovery, LookupCtx));
          if (Corrected.$bool()) {
            Found.setLookupName(Corrected.getCorrection());
            {
              NamedDecl /*P*/ ND = Corrected.getFoundDecl();
              if ((ND != null)) {
                Found.addDecl(ND);
              }
            }
            $this().FilterAcceptableTemplateNames(Found);
            if (!Found.empty()) {
              if ((LookupCtx != null)) {
                std.string CorrectedStr/*J*/= Corrected.getAsString($this().getLangOpts());
                boolean DroppedSpecifier = Corrected.WillReplaceSpecifier()
                   && $eq_str$C(Name.getAsString(), CorrectedStr);
                $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_no_member_template_suggest)), 
                                    /*NO_COPY*/Name), LookupCtx), (DroppedSpecifier ? 1 : 0)), 
                        SS.getRange())); $c$.clean();
              } else {
                $this().diagnoseTypo(Corrected, $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_no_template_suggest)), /*NO_COPY*/Name)); $c$.clean();
              }
            }
          } else {
            Found.setLookupName(new DeclarationName(Name));
          }
        } finally {
          if (Corrected != null) { Corrected.$destroy(); }
        }
      }
    } finally {
      if (FilterCCC != null) { FilterCCC.$destroy(); }
      $c$.$destroy();
    }
  }
  
  $this().FilterAcceptableTemplateNames(Found, AllowFunctionTemplatesInLookup);
  if (Found.empty()) {
    if (isDependent) {
      MemberOfUnknownSpecialization.$set(true);
    }
    return;
  }
  if ((S != null) && !ObjectType.isNull() && !ObjectTypeSearchedInScope
     && !$this().getLangOpts().CPlusPlus11) {
    LookupResult FoundOuter = null;
    try {
      // C++03 [basic.lookup.classref]p1:
      //   [...] If the lookup in the class of the object expression finds a
      //   template, the name is also looked up in the context of the entire
      //   postfix-expression and [...]
      //
      // Note: C++11 does not perform this second lookup.
      FoundOuter/*J*/= new LookupResult(/*Deref*/$this(), Found.getLookupName(), Found.getNameLoc(), 
          LookupNameKind.LookupOrdinaryName);
      $this().LookupName(FoundOuter, S);
      $this().FilterAcceptableTemplateNames(FoundOuter, /*AllowFunctionTemplates=*/ false);
      if (FoundOuter.empty()) {
        //   - if the name is not found, the name found in the class of the
        //     object expression is used, otherwise
      } else if (!(FoundOuter.<ClassTemplateDecl>getAsSingle(ClassTemplateDecl.class) != null)
         || FoundOuter.isAmbiguous()) {
        //   - if the name is found in the context of the entire
        //     postfix-expression and does not name a class template, the name
        //     found in the class of the object expression is used, otherwise
        FoundOuter.clear();
      } else if (!Found.isSuppressingDiagnostics()) {
        //   - if the name found is a class template, it must refer to the same
        //     entity as the one found in the class of the object expression,
        //     otherwise the program is ill-formed.
        if (!Found.isSingleResult()
           || Found.getFoundDecl().getCanonicalDecl()
           != FoundOuter.getFoundDecl().getCanonicalDecl()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Found.getNameLoc(), 
                        diag.ext_nested_name_member_ref_lookup_ambiguous)), 
                    Found.getLookupName()), 
                ObjectType));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Found.getRepresentativeDecl().getLocation(), 
                    diag.note_ambig_member_ref_object_type)), 
                ObjectType));
            $c$.clean($c$.track($this().Diag(FoundOuter.getFoundDecl().getLocation(), 
                diag.note_ambig_member_ref_scope)));
          } finally {
            $c$.$destroy();
          }
          // Recover by taking the template that we found in the object
          // expression's type.
        }
      }
    } finally {
      if (FoundOuter != null) { FoundOuter.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::isTemplateName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 138,
 FQN="clang::Sema::isTemplateName", NM="_ZN5clang4Sema14isTemplateNameEPNS_5ScopeERNS_12CXXScopeSpecEbRNS_13UnqualifiedIdENS_9OpaquePtrINS_8QualTypeEEEbRNS7_INS_12TemplateNameEEERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema14isTemplateNameEPNS_5ScopeERNS_12CXXScopeSpecEbRNS_13UnqualifiedIdENS_9OpaquePtrINS_8QualTypeEEEbRNS7_INS_12TemplateNameEEERb")
//</editor-fold>
public final TemplateNameKind isTemplateName(Scope /*P*/ S, 
              final CXXScopeSpec /*&*/ SS, 
              boolean hasTemplateKeyword, 
              final UnqualifiedId /*&*/ Name, 
              OpaquePtr<QualType> ObjectTypePtr, 
              boolean EnteringContext, 
              final OpaquePtr<TemplateName> /*&*/ TemplateResult, 
              final bool$ref/*bool &*/ MemberOfUnknownSpecialization) {
  LookupResult R = null;
  try {
    assert ($this().getLangOpts().CPlusPlus) : "No template names in C!";
    
    DeclarationName TName/*J*/= new DeclarationName();
    MemberOfUnknownSpecialization.$set(false);
    switch (Name.getKind()) {
     case IK_Identifier:
      TName.$assignMove(new DeclarationName(Name.Unnamed_field1.Identifier));
      break;
     case IK_OperatorFunctionId:
      TName.$assignMove($this().Context.DeclarationNames.getCXXOperatorName(Name.Unnamed_field1.OperatorFunctionId.Operator));
      break;
     case IK_LiteralOperatorId:
      TName.$assignMove($this().Context.DeclarationNames.getCXXLiteralOperatorName(Name.Unnamed_field1.Identifier));
      break;
     default:
      return TemplateNameKind.TNK_Non_template;
    }
    
    QualType ObjectType = ObjectTypePtr.getQualType();
  
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(TName), Name.getLocStart(), LookupNameKind.LookupOrdinaryName);
    $this().LookupTemplateName(R, S, SS, new QualType(ObjectType), EnteringContext, 
        MemberOfUnknownSpecialization);
    if (R.empty()) {
      return TemplateNameKind.TNK_Non_template;
    }
    if (R.isAmbiguous()) {
      // Suppress diagnostics;  we'll redo this lookup later.
      R.suppressDiagnostics();
      
      // FIXME: we might have ambiguous templates, in which case we
      // should at least parse them properly!
      return TemplateNameKind.TNK_Non_template;
    }
    
    TemplateName Template/*J*/= new TemplateName();
    TemplateNameKind TemplateKind;
    
    /*uint*/int ResultCount = R.end().$sub(R.begin());
    if ($greater_uint(ResultCount, 1)) {
      // We assume that we'll preserve the qualifier from a function
      // template name in other ways.
      Template.$assignMove($this().Context.getOverloadedTemplateName(R.begin(), R.end()));
      TemplateKind = TemplateNameKind.TNK_Function_template;
      
      // We'll do this lookup again later.
      R.suppressDiagnostics();
    } else {
      TemplateDecl /*P*/ TD = cast_TemplateDecl((R.begin().$star()).getUnderlyingDecl());
      if (SS.isSet() && !SS.isInvalid()) {
        NestedNameSpecifier /*P*/ Qualifier = SS.getScopeRep();
        Template.$assignMove($this().Context.getQualifiedTemplateName(Qualifier, 
                hasTemplateKeyword, TD));
      } else {
        Template.$assignMove(new TemplateName(TD));
      }
      if (isa_FunctionTemplateDecl(TD)) {
        TemplateKind = TemplateNameKind.TNK_Function_template;
        
        // We'll do this lookup again later.
        R.suppressDiagnostics();
      } else {
        assert (isa_ClassTemplateDecl(TD) || isa_TemplateTemplateParmDecl(TD) || isa_TypeAliasTemplateDecl(TD) || isa_VarTemplateDecl(TD) || isa_BuiltinTemplateDecl(TD));
        TemplateKind
           = isa_VarTemplateDecl(TD) ? TemplateNameKind.TNK_Var_template : TemplateNameKind.TNK_Type_template;
      }
    }
    TemplateResult.$assignMove(OpaquePtr.<TemplateName>make(new TemplateName(Template)));
    return TemplateKind;
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseUnknownTemplateName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 225,
 FQN="clang::Sema::DiagnoseUnknownTemplateName", NM="_ZN5clang4Sema27DiagnoseUnknownTemplateNameERKNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPKNS_12CXXScopeSpecERNS_9OpaquePtrINS_12TemplateNameEEERNS_16TemplateNameKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema27DiagnoseUnknownTemplateNameERKNS_14IdentifierInfoENS_14SourceLocationEPNS_5ScopeEPKNS_12CXXScopeSpecERNS_9OpaquePtrINS_12TemplateNameEEERNS_16TemplateNameKindE")
//</editor-fold>
public final boolean DiagnoseUnknownTemplateName(final /*const*/ IdentifierInfo /*&*/ II, 
                           SourceLocation IILoc, 
                           Scope /*P*/ S, 
                           /*const*/ CXXScopeSpec /*P*/ SS, 
                           final OpaquePtr<TemplateName> /*&*/ SuggestedTemplate, 
                           final type$ref<TemplateNameKind /*&*/> SuggestedKind) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // We can't recover unless there's a dependent scope specifier preceding the
    // template name.
    // FIXME: Typo correction?
    if (!(SS != null) || !SS.isSet() || !$this().isDependentScopeSpecifier($Deref(SS))
       || ($this().computeDeclContext($Deref(SS)) != null)) {
      return false;
    }
    
    // The code is missing a 'template' keyword prior to the dependent template
    // name.
    NestedNameSpecifier /*P*/ Qualifier = (NestedNameSpecifier /*P*/ )SS.getScopeRep();
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(new SourceLocation(IILoc), diag.err_template_kw_missing)), 
                Qualifier), II.getName()), 
        FixItHint.CreateInsertion(/*NO_COPY*/IILoc, new StringRef(/*KEEP_STR*/"template "))));
    SuggestedTemplate.$assignMove(
        OpaquePtr.<TemplateName>make($this().Context.getDependentTemplateName(Qualifier, $AddrOf(II)))
    );
    SuggestedKind.$set(TemplateNameKind.TNK_Dependent_template_name);
    return true;
  } finally {
    $c$.$destroy();
  }
}


/// DiagnoseTemplateParameterShadow - Produce a diagnostic complaining
/// that the template parameter 'PrevDecl' is being shadowed by a new
/// declaration at location Loc. Returns true to indicate that this is
/// an error, and false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseTemplateParameterShadow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 463,
 FQN="clang::Sema::DiagnoseTemplateParameterShadow", NM="_ZN5clang4Sema31DiagnoseTemplateParameterShadowENS_14SourceLocationEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema31DiagnoseTemplateParameterShadowENS_14SourceLocationEPNS_4DeclE")
//</editor-fold>
public final void DiagnoseTemplateParameterShadow(SourceLocation Loc, Decl /*P*/ PrevDecl) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (PrevDecl.isTemplateParameter()) : "Not a template parameter";
    
    // Microsoft Visual C++ permits template parameters to be shadowed.
    if ($this().getLangOpts().MicrosoftExt) {
      return;
    }
    
    // C++ [temp.local]p4:
    //   A template-parameter shall not be redeclared within its
    //   scope (including nested scopes).
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_template_param_shadow)), 
        cast_NamedDecl(PrevDecl).getDeclName()));
    $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_template_param_here)));
  } finally {
    $c$.$destroy();
  }
}


/// AdjustDeclIfTemplate - If the given decl happens to be a template, reset
/// the parameter D to reference the templated declaration and return a pointer
/// to the template declaration. Otherwise, do nothing to D and return null.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AdjustDeclIfTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 481,
 FQN="clang::Sema::AdjustDeclIfTemplate", NM="_ZN5clang4Sema20AdjustDeclIfTemplateERPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema20AdjustDeclIfTemplateERPNS_4DeclE")
//</editor-fold>
public final TemplateDecl /*P*/ AdjustDeclIfTemplate(final type$ref<Decl /*P*/ /*&*/> D) {
  {
    TemplateDecl /*P*/ Temp = dyn_cast_or_null_TemplateDecl(D.$deref());
    if ((Temp != null)) {
      D.$set(Temp.getTemplatedDecl());
      return Temp;
    }
  }
  return null;
}


/// ActOnTypeParameter - Called when a C++ template type parameter
/// (e.g., "typename T") has been parsed. Typename specifies whether
/// the keyword "typename" was used to declare the type parameter
/// (otherwise, "class" was used), and KeyLoc is the location of the
/// "class" or "typename" keyword. ParamName is the name of the
/// parameter (NULL indicates an unnamed template parameter) and
/// ParamNameLoc is the location of the parameter name (if any).
/// If the type parameter has a default argument, it will be added
/// later via ActOnTypeParameterDefault.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypeParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 562,
 FQN="clang::Sema::ActOnTypeParameter", NM="_ZN5clang4Sema18ActOnTypeParameterEPNS_5ScopeEbNS_14SourceLocationES3_PNS_14IdentifierInfoES3_jjS3_NS_9OpaquePtrINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema18ActOnTypeParameterEPNS_5ScopeEbNS_14SourceLocationES3_PNS_14IdentifierInfoES3_jjS3_NS_9OpaquePtrINS_8QualTypeEEE")
//</editor-fold>
public final Decl /*P*/ ActOnTypeParameter(Scope /*P*/ S, boolean Typename, 
                  SourceLocation EllipsisLoc, 
                  SourceLocation KeyLoc, 
                  IdentifierInfo /*P*/ ParamName, 
                  SourceLocation ParamNameLoc, 
                  /*uint*/int Depth, /*uint*/int Position, 
                  SourceLocation EqualLoc, 
                  OpaquePtr<QualType> DefaultArg) {
  assert (S.isTemplateParamScope()) : "Template type parameter not in template parameter scope!";
  
  SourceLocation Loc = new SourceLocation(ParamNameLoc);
  if (!(ParamName != null)) {
    Loc.$assign(KeyLoc);
  }
  
  boolean IsParameterPack = EllipsisLoc.isValid();
  TemplateTypeParmDecl /*P*/ Param = TemplateTypeParmDecl.Create($this().Context, $this().Context.getTranslationUnitDecl(), 
      new SourceLocation(KeyLoc), new SourceLocation(Loc), Depth, Position, ParamName, 
      Typename, IsParameterPack);
  Param.setAccess(AccessSpecifier.AS_public);
  if ((ParamName != null)) {
    maybeDiagnoseTemplateParameterShadow(/*Deref*/$this(), S, new SourceLocation(ParamNameLoc), ParamName);
    
    // Add the template parameter into the current scope.
    S.AddDecl(Param);
    $this().IdResolver.AddDecl(Param);
  }
  
  // C++0x [temp.param]p9:
  //   A default template-argument may be specified for any kind of
  //   template-parameter that is not a template parameter pack.
  if (DefaultArg.$bool() && IsParameterPack) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(EqualLoc), diag.err_template_param_pack_default_arg)));
      DefaultArg.$assignMove(new OpaquePtr<QualType>(null));
    } finally {
      $c$.$destroy();
    }
  }
  
  // Handle the default argument, if provided.
  if (DefaultArg.$bool()) {
    type$ptr<TypeSourceInfo /*P*/ > DefaultTInfo = create_type$null$ptr();
    GetTypeFromParser(new OpaquePtr<QualType>(DefaultArg), $AddrOf(DefaultTInfo));
    assert ((DefaultTInfo.$star() != null)) : "expected source information for type";
    
    // Check for unexpanded parameter packs.
    if ($this().DiagnoseUnexpandedParameterPack(new SourceLocation(Loc), DefaultTInfo.$star(), 
        UnexpandedParameterPackContext.UPPC_DefaultArgument)) {
      return Param;
    }
    
    // Check the template argument itself.
    if ($this().CheckTemplateArgument(Param, DefaultTInfo.$star())) {
      Param.setInvalidDecl();
      return Param;
    }
    
    Param.setDefaultArgument(DefaultTInfo.$star());
  }
  
  return Param;
}


/// \brief Check that the type of a non-type template parameter is
/// well-formed.
///
/// \returns the (possibly-promoted) parameter type if valid;
/// otherwise, produces a diagnostic and returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckNonTypeTemplateParameterType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 629,
 FQN="clang::Sema::CheckNonTypeTemplateParameterType", NM="_ZN5clang4Sema33CheckNonTypeTemplateParameterTypeENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema33CheckNonTypeTemplateParameterTypeENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final QualType CheckNonTypeTemplateParameterType(QualType T, SourceLocation Loc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // We don't allow variably-modified types as the type of non-type template
    // parameters.
    if (T.$arrow().isVariablyModifiedType()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_variably_modified_nontype_template_param)), 
          T));
      return new QualType();
    }
    
    // C++ [temp.param]p4:
    //
    // A non-type template-parameter shall have one of the following
    // (optionally cv-qualified) types:
    //
    //       -- integral or enumeration type,
    if (T.$arrow().isIntegralOrEnumerationType()
      //   -- pointer to object or pointer to function,
       || T.$arrow().isPointerType()
      //   -- reference to object or reference to function,
       || T.$arrow().isReferenceType()
      //   -- pointer to member,
       || T.$arrow().isMemberPointerType()
      //   -- std::nullptr_t.
       || T.$arrow().isNullPtrType()
      // If T is a dependent type, we can't do the check now, so we
      // assume that it is well-formed.
       || T.$arrow().isDependentType()) {
      // C++ [temp.param]p5: The top-level cv-qualifiers on the template-parameter
      // are ignored when determining its type.
      return T.getUnqualifiedType();
    } else 
    // C++ [temp.param]p8:
    //
    //   A non-type template-parameter of type "array of T" or
    //   "function returning T" is adjusted to be of type "pointer to
    //   T" or "pointer to function returning T", respectively.
    if (T.$arrow().isArrayType() || T.$arrow().isFunctionType()) {
      return $this().Context.getDecayedType(new QualType(T));
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.err_template_nontype_parm_bad_type)), 
        T));
    
    return new QualType();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnNonTypeTemplateParameter">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 676,
 FQN="clang::Sema::ActOnNonTypeTemplateParameter", NM="_ZN5clang4Sema29ActOnNonTypeTemplateParameterEPNS_5ScopeERNS_10DeclaratorEjjNS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema29ActOnNonTypeTemplateParameterEPNS_5ScopeERNS_10DeclaratorEjjNS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final Decl /*P*/ ActOnNonTypeTemplateParameter(Scope /*P*/ S, final Declarator /*&*/ D, 
                             /*uint*/int Depth, 
                             /*uint*/int Position, 
                             SourceLocation EqualLoc, 
                             Expr /*P*/ Default) {
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, S);
  QualType T = TInfo.getType();
  assert (S.isTemplateParamScope()) : "Non-type template parameter not in template parameter scope!";
  boolean Invalid = false;
  
  T.$assignMove($this().CheckNonTypeTemplateParameterType(new QualType(T), D.getIdentifierLoc()));
  if (T.isNull()) {
    T.$assignMove($this().Context.IntTy.$QualType()); // Recover with an 'int' type.
    Invalid = true;
  }
  
  IdentifierInfo /*P*/ ParamName = D.getIdentifier();
  boolean IsParameterPack = D.hasEllipsis();
  NonTypeTemplateParmDecl /*P*/ Param = NonTypeTemplateParmDecl.Create($this().Context, $this().Context.getTranslationUnitDecl(), 
      D.getLocStart(), 
      D.getIdentifierLoc(), 
      Depth, Position, ParamName, new QualType(T), 
      IsParameterPack, TInfo);
  Param.setAccess(AccessSpecifier.AS_public);
  if (Invalid) {
    Param.setInvalidDecl();
  }
  if ((ParamName != null)) {
    maybeDiagnoseTemplateParameterShadow(/*Deref*/$this(), S, D.getIdentifierLoc(), 
        ParamName);
    
    // Add the template parameter into the current scope.
    S.AddDecl(Param);
    $this().IdResolver.AddDecl(Param);
  }
  
  // C++0x [temp.param]p9:
  //   A default template-argument may be specified for any kind of
  //   template-parameter that is not a template parameter pack.
  if ((Default != null) && IsParameterPack) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(EqualLoc), diag.err_template_param_pack_default_arg)));
      Default = null;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check the well-formedness of the default template argument, if provided.
  if ((Default != null)) {
    // Check for unexpanded parameter packs.
    if ($this().DiagnoseUnexpandedParameterPack(Default, UnexpandedParameterPackContext.UPPC_DefaultArgument)) {
      return Param;
    }
    
    TemplateArgument _Converted/*J*/= new TemplateArgument();
    ActionResultTTrue<Expr /*P*/ > DefaultRes = $this().CheckTemplateArgument(Param, Param.getType(), create_type$ptr(Default), _Converted);
    if (DefaultRes.isInvalid()) {
      Param.setInvalidDecl();
      return Param;
    }
    Default = DefaultRes.get();
    
    Param.setDefaultArgument(Default);
  }
  
  return Param;
}


/// ActOnTemplateTemplateParameter - Called when a C++ template template
/// parameter (e.g. T in template <template \<typename> class T> class array)
/// has been parsed. S is the current scope.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTemplateTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 748,
 FQN="clang::Sema::ActOnTemplateTemplateParameter", NM="_ZN5clang4Sema30ActOnTemplateTemplateParameterEPNS_5ScopeENS_14SourceLocationEPNS_21TemplateParameterListES3_PNS_14IdentifierInfoES3_jjS3_NS_22ParsedTemplateArgumentE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema30ActOnTemplateTemplateParameterEPNS_5ScopeENS_14SourceLocationEPNS_21TemplateParameterListES3_PNS_14IdentifierInfoES3_jjS3_NS_22ParsedTemplateArgumentE")
//</editor-fold>
public final Decl /*P*/ ActOnTemplateTemplateParameter(Scope /*P*/ S, 
                              SourceLocation TmpLoc, 
                              TemplateParameterList /*P*/ Params, 
                              SourceLocation EllipsisLoc, 
                              IdentifierInfo /*P*/ Name, 
                              SourceLocation NameLoc, 
                              /*uint*/int Depth, 
                              /*uint*/int Position, 
                              SourceLocation EqualLoc, 
                              ParsedTemplateArgument Default) {
  assert (S.isTemplateParamScope()) : "Template template parameter not in template parameter scope!";
  
  // Construct the parameter object.
  boolean IsParameterPack = EllipsisLoc.isValid();
  TemplateTemplateParmDecl /*P*/ Param = TemplateTemplateParmDecl.Create($this().Context, $this().Context.getTranslationUnitDecl(), 
      new SourceLocation(NameLoc.isInvalid() ? TmpLoc : NameLoc), 
      Depth, Position, IsParameterPack, 
      Name, Params);
  Param.setAccess(AccessSpecifier.AS_public);
  
  // If the template template parameter has a name, then link the identifier
  // into the scope and lookup mechanisms.
  if ((Name != null)) {
    maybeDiagnoseTemplateParameterShadow(/*Deref*/$this(), S, new SourceLocation(NameLoc), Name);
    
    S.AddDecl(Param);
    $this().IdResolver.AddDecl(Param);
  }
  if (Params.size() == 0) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), diag.err_template_template_parm_no_parms)), 
          new SourceRange(Params.getLAngleLoc(), Params.getRAngleLoc())));
      Param.setInvalidDecl();
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++0x [temp.param]p9:
  //   A default template-argument may be specified for any kind of
  //   template-parameter that is not a template parameter pack.
  if (IsParameterPack && !Default.isInvalid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(EqualLoc), diag.err_template_param_pack_default_arg)));
      $c$.clean(Default.$assignMove($c$.track(new ParsedTemplateArgument())));
    } finally {
      $c$.$destroy();
    }
  }
  if (!Default.isInvalid()) {
    // Check only that we have a template template argument. We don't want to
    // try to check well-formedness now, because our template template parameter
    // might have dependent types in its template parameters, which we wouldn't
    // be able to match now.
    //
    // If none of the template template parameter's template arguments mention
    // other template parameters, we could actually perform more checking here.
    // However, it isn't worth doing.
    TemplateArgumentLoc DefaultArg = translateTemplateArgument(/*Deref*/$this(), Default);
    if (DefaultArg.getArgument().getAsTemplate().isNull()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(DefaultArg.getLocation(), diag.err_template_arg_not_valid_template)), 
            DefaultArg.getSourceRange()));
        return Param;
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check for unexpanded parameter packs.
    if ($this().DiagnoseUnexpandedParameterPack(DefaultArg.getLocation(), 
        DefaultArg.getArgument().getAsTemplate(), 
        UnexpandedParameterPackContext.UPPC_DefaultArgument)) {
      return Param;
    }
    
    Param.setDefaultArgument($this().Context, DefaultArg);
  }
  
  return Param;
}


/// ActOnTemplateParameterList - Builds a TemplateParameterList, optionally
/// constrained by RequiresClause, that contains the template parameters in
/// Params.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTemplateParameterList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 824,
 FQN="clang::Sema::ActOnTemplateParameterList", NM="_ZN5clang4Sema26ActOnTemplateParameterListEjNS_14SourceLocationES1_S1_N4llvm8ArrayRefIPNS_4DeclEEES1_PNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26ActOnTemplateParameterListEjNS_14SourceLocationES1_S1_N4llvm8ArrayRefIPNS_4DeclEEES1_PNS_4ExprE")
//</editor-fold>
public final TemplateParameterList /*P*/ ActOnTemplateParameterList(/*uint*/int Depth, 
                          SourceLocation ExportLoc, 
                          SourceLocation TemplateLoc, 
                          SourceLocation LAngleLoc, 
                          ArrayRef<Decl /*P*/ > Params, 
                          SourceLocation RAngleLoc, 
                          Expr /*P*/ RequiresClause) {
  if (ExportLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track($this().Diag(new SourceLocation(ExportLoc), diag.warn_template_export_unsupported)));
    } finally {
      $c$.$destroy();
    }
  }
  
  // FIXME: store RequiresClause
  return TemplateParameterList.Create($this().Context, new SourceLocation(TemplateLoc), new SourceLocation(LAngleLoc), 
      llvm.<NamedDecl /*P*/ /*const*/ /*P*/>makeArrayRef((type$ptr)Params.data(), Params.size()), 
      new SourceLocation(RAngleLoc));
}


/// \brief Checks the validity of a template parameter list, possibly
/// considering the template parameter list from a previous
/// declaration.
///
/// If an "old" template parameter list is provided, it must be
/// equivalent (per TemplateParameterListsAreEqual) to the "new"
/// template parameter list.
///
/// \param NewParams Template parameter list for a new template
/// declaration. This template parameter list will be updated with any
/// default arguments that are carried through from the previous
/// template parameter list.
///
/// \param OldParams If provided, template parameter list from a
/// previous declaration of the same template. Default template
/// arguments will be merged from the old template parameter list to
/// the new template parameter list.
///
/// \param TPC Describes the context in which we are checking the given
/// template parameter list.
///
/// \returns true if an error occurred, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateParameterList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1310,
 FQN="clang::Sema::CheckTemplateParameterList", NM="_ZN5clang4Sema26CheckTemplateParameterListEPNS_21TemplateParameterListES2_NS0_24TemplateParamListContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26CheckTemplateParameterListEPNS_21TemplateParameterListES2_NS0_24TemplateParamListContextE")
//</editor-fold>
public final boolean CheckTemplateParameterList(TemplateParameterList /*P*/ NewParams, 
                          TemplateParameterList /*P*/ OldParams, 
                          TemplateParamListContext TPC) {
  boolean Invalid = false;
  
  // C++ [temp.param]p10:
  //   The set of default template-arguments available for use with a
  //   template declaration or definition is obtained by merging the
  //   default arguments from the definition (if in scope) and all
  //   declarations in scope in the same way default function
  //   arguments are (8.3.6).
  boolean SawDefaultArgument = false;
  SourceLocation PreviousDefaultArgLoc/*J*/= new SourceLocation();
  
  // Dummy initialization to avoid warnings.
  type$ptr<NamedDecl /*P*/ /*P*/> OldParam = $tryClone(NewParams.end());
  if ((OldParams != null)) {
    OldParam = $tryClone(OldParams.begin());
  }
  
  boolean RemoveDefaultArguments = false;
  for (type$ptr<NamedDecl /*P*/ /*P*/> NewParam = $tryClone(NewParams.begin()), 
      /*P*/ /*P*/ NewParamEnd = $tryClone(NewParams.end());
       $noteq_ptr(NewParam, NewParamEnd); NewParam.$preInc()) {
    // Variables used to diagnose redundant default arguments
    boolean RedundantDefaultArg = false;
    SourceLocation OldDefaultLoc/*J*/= new SourceLocation();
    SourceLocation NewDefaultLoc/*J*/= new SourceLocation();
    
    // Variable used to diagnose missing default arguments
    boolean MissingDefaultArg = false;
    
    // Variable used to diagnose non-final parameter packs
    boolean SawParameterPack = false;
    {
      
      TemplateTypeParmDecl /*P*/ NewTypeParm = dyn_cast_TemplateTypeParmDecl(NewParam.$star());
      if ((NewTypeParm != null)) {
        // Check the presence of a default argument here.
        if (NewTypeParm.hasDefaultArgument()
           && DiagnoseDefaultTemplateArgument(/*Deref*/$this(), TPC, 
            NewTypeParm.getLocation(), 
            NewTypeParm.getDefaultArgumentInfo().getTypeLoc().
                getSourceRange())) {
          NewTypeParm.removeDefaultArgument();
        }
        
        // Merge default arguments for template type parameters.
        TemplateTypeParmDecl /*P*/ OldTypeParm = (OldParams != null) ? cast_TemplateTypeParmDecl(OldParam.$star()) : null;
        if (NewTypeParm.isParameterPack()) {
          assert (!NewTypeParm.hasDefaultArgument()) : "Parameter packs can't have a default argument!";
          SawParameterPack = true;
        } else if ((OldTypeParm != null) && $this().hasVisibleDefaultArgument(OldTypeParm)
           && NewTypeParm.hasDefaultArgument()) {
          OldDefaultLoc.$assignMove(OldTypeParm.getDefaultArgumentLoc());
          NewDefaultLoc.$assignMove(NewTypeParm.getDefaultArgumentLoc());
          SawDefaultArgument = true;
          RedundantDefaultArg = true;
          PreviousDefaultArgLoc.$assign(NewDefaultLoc);
        } else if ((OldTypeParm != null) && OldTypeParm.hasDefaultArgument()) {
          // Merge the default argument from the old declaration to the
          // new declaration.
          NewTypeParm.setInheritedDefaultArgument($this().Context, OldTypeParm);
          PreviousDefaultArgLoc.$assignMove(OldTypeParm.getDefaultArgumentLoc());
        } else if (NewTypeParm.hasDefaultArgument()) {
          SawDefaultArgument = true;
          PreviousDefaultArgLoc.$assignMove(NewTypeParm.getDefaultArgumentLoc());
        } else if (SawDefaultArgument) {
          MissingDefaultArg = true;
        }
      } else {
        NonTypeTemplateParmDecl /*P*/ NewNonTypeParm = dyn_cast_NonTypeTemplateParmDecl(NewParam.$star());
        if ((NewNonTypeParm != null)) {
          // Check for unexpanded parameter packs.
          if (!NewNonTypeParm.isParameterPack()
             && $this().DiagnoseUnexpandedParameterPack(NewNonTypeParm.getLocation(), 
              NewNonTypeParm.getTypeSourceInfo(), 
              UnexpandedParameterPackContext.UPPC_NonTypeTemplateParameterType)) {
            Invalid = true;
            continue;
          }
          
          // Check the presence of a default argument here.
          if (NewNonTypeParm.hasDefaultArgument()
             && DiagnoseDefaultTemplateArgument(/*Deref*/$this(), TPC, 
              NewNonTypeParm.getLocation(), 
              NewNonTypeParm.getDefaultArgument().getSourceRange())) {
            NewNonTypeParm.removeDefaultArgument();
          }
          
          // Merge default arguments for non-type template parameters
          NonTypeTemplateParmDecl /*P*/ OldNonTypeParm = (OldParams != null) ? cast_NonTypeTemplateParmDecl(OldParam.$star()) : null;
          if (NewNonTypeParm.isParameterPack()) {
            assert (!NewNonTypeParm.hasDefaultArgument()) : "Parameter packs can't have a default argument!";
            if (!NewNonTypeParm.isPackExpansion()) {
              SawParameterPack = true;
            }
          } else if ((OldNonTypeParm != null) && $this().hasVisibleDefaultArgument(OldNonTypeParm)
             && NewNonTypeParm.hasDefaultArgument()) {
            OldDefaultLoc.$assignMove(OldNonTypeParm.getDefaultArgumentLoc());
            NewDefaultLoc.$assignMove(NewNonTypeParm.getDefaultArgumentLoc());
            SawDefaultArgument = true;
            RedundantDefaultArg = true;
            PreviousDefaultArgLoc.$assign(NewDefaultLoc);
          } else if ((OldNonTypeParm != null) && OldNonTypeParm.hasDefaultArgument()) {
            // Merge the default argument from the old declaration to the
            // new declaration.
            NewNonTypeParm.setInheritedDefaultArgument($this().Context, OldNonTypeParm);
            PreviousDefaultArgLoc.$assignMove(OldNonTypeParm.getDefaultArgumentLoc());
          } else if (NewNonTypeParm.hasDefaultArgument()) {
            SawDefaultArgument = true;
            PreviousDefaultArgLoc.$assignMove(NewNonTypeParm.getDefaultArgumentLoc());
          } else if (SawDefaultArgument) {
            MissingDefaultArg = true;
          }
        } else {
          TemplateTemplateParmDecl /*P*/ NewTemplateParm = cast_TemplateTemplateParmDecl(NewParam.$star());
          
          // Check for unexpanded parameter packs, recursively.
          if (/*::*/DiagnoseUnexpandedParameterPacks(/*Deref*/$this(), NewTemplateParm)) {
            Invalid = true;
            continue;
          }
          
          // Check the presence of a default argument here.
          if (NewTemplateParm.hasDefaultArgument()
             && DiagnoseDefaultTemplateArgument(/*Deref*/$this(), TPC, 
              NewTemplateParm.getLocation(), 
              NewTemplateParm.getDefaultArgument().getSourceRange())) {
            NewTemplateParm.removeDefaultArgument();
          }
          
          // Merge default arguments for template template parameters
          TemplateTemplateParmDecl /*P*/ OldTemplateParm = (OldParams != null) ? cast_TemplateTemplateParmDecl(OldParam.$star()) : null;
          if (NewTemplateParm.isParameterPack()) {
            assert (!NewTemplateParm.hasDefaultArgument()) : "Parameter packs can't have a default argument!";
            if (!NewTemplateParm.isPackExpansion()) {
              SawParameterPack = true;
            }
          } else if ((OldTemplateParm != null)
             && $this().hasVisibleDefaultArgument(OldTemplateParm)
             && NewTemplateParm.hasDefaultArgument()) {
            OldDefaultLoc.$assignMove(OldTemplateParm.getDefaultArgument().getLocation());
            NewDefaultLoc.$assignMove(NewTemplateParm.getDefaultArgument().getLocation());
            SawDefaultArgument = true;
            RedundantDefaultArg = true;
            PreviousDefaultArgLoc.$assign(NewDefaultLoc);
          } else if ((OldTemplateParm != null) && OldTemplateParm.hasDefaultArgument()) {
            // Merge the default argument from the old declaration to the
            // new declaration.
            NewTemplateParm.setInheritedDefaultArgument($this().Context, OldTemplateParm);
            PreviousDefaultArgLoc.$assignMove(
                OldTemplateParm.getDefaultArgument().getLocation()
            );
          } else if (NewTemplateParm.hasDefaultArgument()) {
            SawDefaultArgument = true;
            PreviousDefaultArgLoc.$assignMove(
                NewTemplateParm.getDefaultArgument().getLocation()
            );
          } else if (SawDefaultArgument) {
            MissingDefaultArg = true;
          }
        }
      }
    }
    
    // C++11 [temp.param]p11:
    //   If a template parameter of a primary class template or alias template
    //   is a template parameter pack, it shall be the last template parameter.
    if (SawParameterPack && $noteq_ptr((NewParam.$add(1)), NewParamEnd)
       && (TPC == TemplateParamListContext.TPC_ClassTemplate || TPC == TemplateParamListContext.TPC_VarTemplate
       || TPC == TemplateParamListContext.TPC_TypeAliasTemplate)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag((NewParam.$star()).getLocation(), 
            diag.err_template_param_pack_must_be_last_template_parameter)));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    }
    if (RedundantDefaultArg) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++ [temp.param]p12:
        //   A template-parameter shall not be given default arguments
        //   by two different declarations in the same scope.
        $c$.clean($c$.track($this().Diag(new SourceLocation(NewDefaultLoc), diag.err_template_param_default_arg_redefinition)));
        $c$.clean($c$.track($this().Diag(new SourceLocation(OldDefaultLoc), diag.note_template_param_prev_default_arg)));
        Invalid = true;
      } finally {
        $c$.$destroy();
      }
    } else if (MissingDefaultArg && TPC != TemplateParamListContext.TPC_FunctionTemplate) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++ [temp.param]p11:
        //   If a template-parameter of a class template has a default
        //   template-argument, each subsequent template-parameter shall either
        //   have a default template-argument supplied or be a template parameter
        //   pack.
        $c$.clean($c$.track($this().Diag((NewParam.$star()).getLocation(), 
            diag.err_template_param_default_arg_missing)));
        $c$.clean($c$.track($this().Diag(new SourceLocation(PreviousDefaultArgLoc), diag.note_template_param_prev_default_arg)));
        Invalid = true;
        RemoveDefaultArguments = true;
      } finally {
        $c$.$destroy();
      }
    }
    
    // If we have an old template parameter list that we're merging
    // in, move on to the next parameter.
    if ((OldParams != null)) {
      OldParam.$preInc();
    }
  }
  
  // We were missing some default arguments at the end of the list, so remove
  // all of the default arguments.
  if (RemoveDefaultArguments) {
    for (type$ptr<NamedDecl /*P*/ /*P*/> NewParam = $tryClone(NewParams.begin()), 
        /*P*/ /*P*/ NewParamEnd = $tryClone(NewParams.end());
         $noteq_ptr(NewParam, NewParamEnd); NewParam.$preInc()) {
      {
        TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(NewParam.$star());
        if ((TTP != null)) {
          TTP.removeDefaultArgument();
        } else {
          NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(NewParam.$star());
          if ((NTTP != null)) {
            NTTP.removeDefaultArgument();
          } else {
            cast_TemplateTemplateParmDecl(NewParam.$star()).removeDefaultArgument();
          }
        }
      }
    }
  }
  
  return Invalid;
}


/// \brief Match the given template parameter lists to the given scope
/// specifier, returning the template parameter list that applies to the
/// name.
///
/// \param DeclStartLoc the start of the declaration that has a scope
/// specifier or a template parameter list.
///
/// \param DeclLoc The location of the declaration itself.
///
/// \param SS the scope specifier that will be matched to the given template
/// parameter lists. This scope specifier precedes a qualified name that is
/// being declared.
///
/// \param TemplateId The template-id following the scope specifier, if there
/// is one. Used to check for a missing 'template<>'.
///
/// \param ParamLists the template parameter lists, from the outermost to the
/// innermost template parameter lists.
///
/// \param IsFriend Whether to apply the slightly different rules for
/// matching template parameters to scope specifiers in friend
/// declarations.
///
/// \param IsExplicitSpecialization will be set true if the entity being
/// declared is an explicit specialization, false otherwise.
///
/// \returns the template parameter list, if any, that corresponds to the
/// name that is preceded by the scope specifier @p SS. This template
/// parameter list may have template parameters (if we're declaring a
/// template) or may have no template parameters (if we're declaring a
/// template specialization), or may be NULL (if what we're declaring isn't
/// itself a template).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MatchTemplateParametersToScopeSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 1658,
 FQN="clang::Sema::MatchTemplateParametersToScopeSpecifier", NM="_ZN5clang4Sema39MatchTemplateParametersToScopeSpecifierENS_14SourceLocationES1_RKNS_12CXXScopeSpecEPNS_20TemplateIdAnnotationEN4llvm8ArrayRefIPNS_21TemplateParameterListEEEbRbSC_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema39MatchTemplateParametersToScopeSpecifierENS_14SourceLocationES1_RKNS_12CXXScopeSpecEPNS_20TemplateIdAnnotationEN4llvm8ArrayRefIPNS_21TemplateParameterListEEEbRbSC_")
//</editor-fold>
public final TemplateParameterList /*P*/ MatchTemplateParametersToScopeSpecifier(SourceLocation DeclStartLoc, SourceLocation DeclLoc, final /*const*/ CXXScopeSpec /*&*/ SS, 
                                       TemplateIdAnnotation /*P*/ TemplateId, 
                                       ArrayRef<TemplateParameterList /*P*/ > ParamLists, boolean IsFriend, 
                                       final bool$ref/*bool &*/ IsExplicitSpecialization, final bool$ref/*bool &*/ Invalid) {
  IsExplicitSpecialization.$set(false);
  Invalid.$set(false);
  
  // The sequence of nested types to which we will match up the template
  // parameter lists. We first build this list by starting with the type named
  // by the nested-name-specifier and walking out until we run out of types.
  SmallVector<QualType> NestedTypes/*J*/= new SmallVector<QualType>(4, new QualType());
  QualType T/*J*/= new QualType();
  if ((SS.getScopeRep() != null)) {
    {
      CXXRecordDecl /*P*/ Record = dyn_cast_or_null_CXXRecordDecl($this().computeDeclContext(SS, true));
      if ((Record != null)) {
        T.$assignMove($this().Context.getTypeDeclType(Record));
      } else {
        T.$assignMove(new QualType(SS.getScopeRep().getAsType(), 0));
      }
    }
  }
  
  // If we found an explicit specialization that prevents us from needing
  // 'template<>' headers, this will be set to the location of that
  // explicit specialization.
  SourceLocation ExplicitSpecLoc/*J*/= new SourceLocation();
  while (!T.isNull()) {
    NestedTypes.push_back(T);
    {
      
      // Retrieve the parent of a record type.
      CXXRecordDecl /*P*/ Record = T.$arrow().getAsCXXRecordDecl();
      if ((Record != null)) {
        {
          // If this type is an explicit specialization, we're done.
          ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Record);
          if ((Spec != null)) {
            if (!isa_ClassTemplatePartialSpecializationDecl(Spec)
               && Spec.getSpecializationKind() == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
              ExplicitSpecLoc.$assignMove(Spec.getLocation());
              break;
            }
          } else if (Record.getTemplateSpecializationKind()
             == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
            ExplicitSpecLoc.$assignMove(Record.getLocation());
            break;
          }
        }
        {
          
          TypeDecl /*P*/ Parent = dyn_cast_TypeDecl(Record.getParent());
          if ((Parent != null)) {
            T.$assignMove($this().Context.getTypeDeclType(Parent));
          } else {
            T.$assignMove(new QualType());
          }
        }
        continue;
      }
    }
    {
      
      /*const*/ TemplateSpecializationType /*P*/ TST = T.$arrow().getAs$TemplateSpecializationType();
      if ((TST != null)) {
        {
          TemplateDecl /*P*/ Template = TST.getTemplateName().getAsTemplateDecl();
          if ((Template != null)) {
            {
              TypeDecl /*P*/ Parent = dyn_cast_TypeDecl(Template.getDeclContext());
              if ((Parent != null)) {
                T.$assignMove($this().Context.getTypeDeclType(Parent));
              } else {
                T.$assignMove(new QualType());
              }
            }
            continue;
          }
        }
      }
    }
    {
      
      // Look one step prior in a dependent template specialization type.
      /*const*/ DependentTemplateSpecializationType /*P*/ DependentTST = T.$arrow().getAs(DependentTemplateSpecializationType.class);
      if ((DependentTST != null)) {
        {
          NestedNameSpecifier /*P*/ NNS = DependentTST.getQualifier();
          if ((NNS != null)) {
            T.$assignMove(new QualType(NNS.getAsType(), 0));
          } else {
            T.$assignMove(new QualType());
          }
        }
        continue;
      }
    }
    {
      
      // Look one step prior in a dependent name type.
      /*const*/ DependentNameType /*P*/ DependentName = T.$arrow().getAs(DependentNameType.class);
      if ((DependentName != null)) {
        {
          NestedNameSpecifier /*P*/ NNS = DependentName.getQualifier();
          if ((NNS != null)) {
            T.$assignMove(new QualType(NNS.getAsType(), 0));
          } else {
            T.$assignMove(new QualType());
          }
        }
        continue;
      }
    }
    {
      
      // Retrieve the parent of an enumeration type.
      /*const*/ EnumType /*P*/ EnumT = T.$arrow().getAs$EnumType();
      if ((EnumT != null)) {
        // FIXME: Forward-declared enums require a TSK_ExplicitSpecialization
        // check here.
        EnumDecl /*P*/ Enum = EnumT.getDecl();
        {
          
          // Get to the parent type.
          TypeDecl /*P*/ Parent = dyn_cast_TypeDecl(Enum.getParent());
          if ((Parent != null)) {
            T.$assignMove($this().Context.getTypeDeclType(Parent));
          } else {
            T.$assignMove(new QualType());
          }
        }
        continue;
      }
    }
    
    T.$assignMove(new QualType());
  }
  // Reverse the nested types list, since we want to traverse from the outermost
  // to the innermost while checking template-parameter-lists.
  std.reverse(NestedTypes.begin(), NestedTypes.end());
  
  // C++0x [temp.expl.spec]p17:
  //   A member or a member template may be nested within many
  //   enclosing class templates. In an explicit specialization for
  //   such a member, the member declaration shall be preceded by a
  //   template<> for each enclosing class template that is
  //   explicitly specialized.
  bool$ref SawNonEmptyTemplateParameterList = create_bool$ref(false);
  
  SourceRangeBool2Bool CheckExplicitSpecialization = /*[&, &SawNonEmptyTemplateParameterList, this, &DeclLoc, &Invalid, &IsExplicitSpecialization]*/ (SourceRange Range, boolean Recovery) -> {
        if (SawNonEmptyTemplateParameterList.$deref()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DeclLoc), diag.err_specialize_member_of_template)), 
                    !Recovery), Range));
            Invalid.$set(true);
            IsExplicitSpecialization.$set(false);
            return true;
          } finally {
            $c$.$destroy();
          }
        }
        
        return false;
      };
  
  SourceRange2Bool DiagnoseMissingExplicitSpecialization = /*[&, &CheckExplicitSpecialization, &ParamLists, &DeclStartLoc, this, &DeclLoc]*/ (SourceRange Range) -> {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Check that we can have an explicit specialization here.
          if (CheckExplicitSpecialization.$call(new SourceRange(Range), /*KEEP_BOOL*/true)) {
            return true;
          }
          
          // We don't have a template header, but we should.
          SourceLocation ExpectedTemplateLoc/*J*/= new SourceLocation();
          if (!ParamLists.empty()) {
            ExpectedTemplateLoc.$assignMove(ParamLists.$at(0).getTemplateLoc());
          } else {
            ExpectedTemplateLoc.$assign(DeclStartLoc);
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DeclLoc), diag.err_template_spec_needs_header)), 
                  Range), 
              FixItHint.CreateInsertion(/*NO_COPY*/ExpectedTemplateLoc, new StringRef(/*KEEP_STR*/"template<> "))));
          return false;
        } finally {
          $c$.$destroy();
        }
      };
  
  /*uint*/int ParamIdx = 0;
  for (/*uint*/int TypeIdx = 0, NumTypes = NestedTypes.size(); TypeIdx != NumTypes;
       ++TypeIdx) {
    T.$assign(NestedTypes.$at(TypeIdx));
    
    // Whether we expect a 'template<>' header.
    boolean NeedEmptyTemplateHeader = false;
    
    // Whether we expect a template header with parameters.
    boolean NeedNonemptyTemplateHeader = false;
    
    // For a dependent type, the set of template parameters that we
    // expect to see.
    TemplateParameterList /*P*/ ExpectedTemplateParams = null;
    {
      
      // C++0x [temp.expl.spec]p15:
      //   A member or a member template may be nested within many enclosing 
      //   class templates. In an explicit specialization for such a member, the 
      //   member declaration shall be preceded by a template<> for each 
      //   enclosing class template that is explicitly specialized.
      CXXRecordDecl /*P*/ Record = T.$arrow().getAsCXXRecordDecl();
      if ((Record != null)) {
        {
          ClassTemplatePartialSpecializationDecl /*P*/ Partial = dyn_cast_ClassTemplatePartialSpecializationDecl(Record);
          if ((Partial != null)) {
            ExpectedTemplateParams = Partial.getTemplateParameters();
            NeedNonemptyTemplateHeader = true;
          } else if (Record.isDependentType()) {
            if ((Record.getDescribedClassTemplate() != null)) {
              ExpectedTemplateParams = Record.getDescribedClassTemplate().
                  getTemplateParameters();
              NeedNonemptyTemplateHeader = true;
            }
          } else {
            ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Record);
            if ((Spec != null)) {
              // C++0x [temp.expl.spec]p4:
              //   Members of an explicitly specialized class template are defined
              //   in the same manner as members of normal classes, and not using 
              //   the template<> syntax. 
              if (Spec.getSpecializationKind() != TemplateSpecializationKind.TSK_ExplicitSpecialization) {
                NeedEmptyTemplateHeader = true;
              } else {
                continue;
              }
            } else if ((Record.getTemplateSpecializationKind().getValue() != 0)) {
              if (Record.getTemplateSpecializationKind()
                 != TemplateSpecializationKind.TSK_ExplicitSpecialization
                 && TypeIdx == NumTypes - 1) {
                IsExplicitSpecialization.$set(true);
              }
              
              continue;
            }
          }
        }
      } else {
        /*const*/ TemplateSpecializationType /*P*/ TST = T.$arrow().getAs$TemplateSpecializationType();
        if ((TST != null)) {
          {
            TemplateDecl /*P*/ Template = TST.getTemplateName().getAsTemplateDecl();
            if ((Template != null)) {
              ExpectedTemplateParams = Template.getTemplateParameters();
              NeedNonemptyTemplateHeader = true;
            }
          }
        } else if ((T.$arrow().getAs(DependentTemplateSpecializationType.class) != null)) {
          // FIXME:  We actually could/should check the template arguments here
          // against the corresponding template parameter list.
          NeedNonemptyTemplateHeader = false;
        }
      }
    }
    
    // C++ [temp.expl.spec]p16:
    //   In an explicit specialization declaration for a member of a class 
    //   template or a member template that ap- pears in namespace scope, the 
    //   member template and some of its enclosing class templates may remain 
    //   unspecialized, except that the declaration shall not explicitly 
    //   specialize a class member template if its en- closing class templates 
    //   are not explicitly specialized as well.
    if ($less_uint(ParamIdx, ParamLists.size())) {
      if (ParamLists.$at(ParamIdx).size() == 0) {
        if (CheckExplicitSpecialization.$call(ParamLists.$at(ParamIdx).getSourceRange(), 
            /*KEEP_BOOL*/false
        )) {
          return null;
        }
      } else {
        SawNonEmptyTemplateParameterList.$set(true);
      }
    }
    if (NeedEmptyTemplateHeader) {
      // If we're on the last of the types, and we need a 'template<>' header
      // here, then it's an explicit specialization.
      if (TypeIdx == NumTypes - 1) {
        IsExplicitSpecialization.$set(true);
      }
      if ($less_uint(ParamIdx, ParamLists.size())) {
        if ($greater_uint(ParamLists.$at(ParamIdx).size(), 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // The header has template parameters when it shouldn't. Complain.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ParamLists.$at(ParamIdx).getTemplateLoc(), 
                            diag.err_template_param_list_matches_nontemplate)), 
                        T), 
                    new SourceRange(ParamLists.$at(ParamIdx).getLAngleLoc(), 
                        ParamLists.$at(ParamIdx).getRAngleLoc())), 
                getRangeOfTypeInNestedNameSpecifier($this().Context, new QualType(T), SS)));
            Invalid.$set(true);
            return null;
          } finally {
            $c$.$destroy();
          }
        }
        
        // Consume this template header.
        ++ParamIdx;
        continue;
      }
      if (!IsFriend) {
        if (DiagnoseMissingExplicitSpecialization.$call(
            getRangeOfTypeInNestedNameSpecifier($this().Context, new QualType(T), SS)
        )) {
          return null;
        }
      }
      
      continue;
    }
    if (NeedNonemptyTemplateHeader) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // In friend declarations we can have template-ids which don't
        // depend on the corresponding template parameter lists.  But
        // assume that empty parameter lists are supposed to match this
        // template-id.
        if (IsFriend && T.$arrow().isDependentType()) {
          if ($less_uint(ParamIdx, ParamLists.size())
             && DependsOnTemplateParameters(new QualType(T), ParamLists.$at(ParamIdx))) {
            ExpectedTemplateParams = null;
          } else {
            continue;
          }
        }
        if ($less_uint(ParamIdx, ParamLists.size())) {
          // Check the template parameter list, if we can.
          if ((ExpectedTemplateParams != null)
             && !$this().TemplateParameterListsAreEqual(ParamLists.$at(ParamIdx), 
              ExpectedTemplateParams, 
              true, TemplateParameterListEqualKind.TPL_TemplateMatch)) {
            Invalid.$set(true);
          }
          if (!Invalid.$deref()
             && $this().CheckTemplateParameterList(ParamLists.$at(ParamIdx), (TemplateParameterList /*P*/ )null, 
              TemplateParamListContext.TPC_ClassTemplateMember)) {
            Invalid.$set(true);
          }
          
          ++ParamIdx;
          continue;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(DeclLoc), diag.err_template_spec_needs_template_parameters)), 
                T), 
            getRangeOfTypeInNestedNameSpecifier($this().Context, new QualType(T), SS)));
        Invalid.$set(true);
        continue;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // If there were at least as many template-ids as there were template
  // parameter lists, then there are no template parameter lists remaining for
  // the declaration itself.
  if ($greatereq_uint(ParamIdx, ParamLists.size())) {
    if ((TemplateId != null) && !IsFriend) {
      // We don't have a template header for the declaration itself, but we
      // should.
      IsExplicitSpecialization.$set(true);
      DiagnoseMissingExplicitSpecialization.$call(new SourceRange(/*NO_COPY*/TemplateId.LAngleLoc, 
              /*NO_COPY*/TemplateId.RAngleLoc));
      
      // Fabricate an empty template parameter list for the invented header.
      return TemplateParameterList.Create($this().Context, new SourceLocation(), 
          new SourceLocation(), new ArrayRef<NamedDecl /*P*/ >(None, true), 
          new SourceLocation());
    }
    
    return null;
  }
  
  // If there were too many template parameter lists, complain about that now.
  if ($less_uint(ParamIdx, ParamLists.size() - 1)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      boolean HasAnyExplicitSpecHeader = false;
      boolean AllExplicitSpecHeaders = true;
      for (/*uint*/int I = ParamIdx, E = ParamLists.size() - 1; I != E; ++I) {
        if (ParamLists.$at(I).size() == 0) {
          HasAnyExplicitSpecHeader = true;
        } else {
          AllExplicitSpecHeaders = false;
        }
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ParamLists.$at(ParamIdx).getTemplateLoc(), 
              AllExplicitSpecHeaders ? diag.warn_template_spec_extra_headers : diag.err_template_spec_extra_headers)), 
          new SourceRange(ParamLists.$at(ParamIdx).getTemplateLoc(), 
              ParamLists.$at(ParamLists.size() - 2).getRAngleLoc())));
      
      // If there was a specialization somewhere, such that 'template<>' is
      // not required, and there were any 'template<>' headers, note where the
      // specialization occurred.
      if (ExplicitSpecLoc.isValid() && HasAnyExplicitSpecHeader) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(ExplicitSpecLoc), 
                diag.note_explicit_template_spec_does_not_need_header)), 
            NestedTypes.back()));
      }
      
      // We have a template parameter list with no corresponding scope, which
      // means that the resulting template declaration can't be instantiated
      // properly (we'll end up with dependent nodes when we shouldn't).
      if (!AllExplicitSpecHeaders) {
        Invalid.$set(true);
      }
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [temp.expl.spec]p16:
  //   In an explicit specialization declaration for a member of a class 
  //   template or a member template that ap- pears in namespace scope, the 
  //   member template and some of its enclosing class templates may remain 
  //   unspecialized, except that the declaration shall not explicitly 
  //   specialize a class member template if its en- closing class templates 
  //   are not explicitly specialized as well.
  if (ParamLists.back().size() == 0
     && CheckExplicitSpecialization.$call(ParamLists.$at(ParamIdx).getSourceRange(), 
      /*KEEP_BOOL*/false
  )) {
    return null;
  }
  
  // Return the last template parameter list, which corresponds to the
  // entity being declared.
  return ParamLists.back();
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckClassTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 847,
 FQN="clang::Sema::CheckClassTemplate", NM="_ZN5clang4Sema18CheckClassTemplateEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationERNS_12CXXScopeSpecEPNS_14IdentifierInfoES4_PNS_13AttributeListEPNS_21TemplateParameterListENS_15AccessSpecifierES4_S4_jPSC_PNS0_12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema18CheckClassTemplateEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationERNS_12CXXScopeSpecEPNS_14IdentifierInfoES4_PNS_13AttributeListEPNS_21TemplateParameterListENS_15AccessSpecifierES4_S4_jPSC_PNS0_12SkipBodyInfoE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > CheckClassTemplate(Scope /*P*/ S, /*uint*/int TagSpec, TagUseKind TUK, 
                  SourceLocation KWLoc, final CXXScopeSpec /*&*/ SS, 
                  IdentifierInfo /*P*/ Name, SourceLocation NameLoc, 
                  AttributeList /*P*/ Attr, 
                  TemplateParameterList /*P*/ TemplateParams, 
                  AccessSpecifier AS, SourceLocation ModulePrivateLoc, 
                  SourceLocation FriendLoc, 
                  /*uint*/int NumOuterTemplateParamLists, 
                  type$ptr<TemplateParameterList /*P*/ /*P*/> OuterTemplateParamLists) {
  return CheckClassTemplate(S, TagSpec, TUK, 
                  KWLoc, SS, 
                  Name, NameLoc, 
                  Attr, 
                  TemplateParams, 
                  AS, ModulePrivateLoc, 
                  FriendLoc, 
                  NumOuterTemplateParamLists, 
                  OuterTemplateParamLists, 
                  (SkipBodyInfo /*P*/ )null);
}
public final ActionResult<Decl /*P*/ > CheckClassTemplate(Scope /*P*/ S, /*uint*/int TagSpec, TagUseKind TUK, 
                  SourceLocation KWLoc, final CXXScopeSpec /*&*/ SS, 
                  IdentifierInfo /*P*/ Name, SourceLocation NameLoc, 
                  AttributeList /*P*/ Attr, 
                  TemplateParameterList /*P*/ TemplateParams, 
                  AccessSpecifier AS, SourceLocation ModulePrivateLoc, 
                  SourceLocation FriendLoc, 
                  /*uint*/int NumOuterTemplateParamLists, 
                  type$ptr<TemplateParameterList /*P*/ /*P*/> OuterTemplateParamLists, 
                  SkipBodyInfo /*P*/ SkipBody/*= null*/) {
  LookupResult Previous = null;
  try {
    assert ((TemplateParams != null) && $greater_uint(TemplateParams.size(), 0)) : "No template parameters";
    assert (TUK != TagUseKind.TUK_Reference) : "Can only declare or define class templates";
    boolean Invalid = false;
    
    // Check that we can declare a template here.
    if ($this().CheckTemplateDeclScope(S, TemplateParams)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec);
    assert (Kind != TagTypeKind.TTK_Enum) : "can't build template of enumerated type";
    
    // There is no such thing as an unnamed class template.
    if (!(Name != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_template_unnamed_class)));
        return new ActionResult<Decl /*P*/ >(true);
      } finally {
        $c$.$destroy();
      }
    }
    
    // Find any previous declaration with this name. For a friend with no
    // scope explicitly specified, we only look for tag declarations (per
    // C++11 [basic.lookup.elab]p2).
    DeclContext /*P*/ SemanticContext;
    Previous/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(NameLoc), 
        (SS.isEmpty() && TUK == TagUseKind.TUK_Friend) ? LookupNameKind.LookupTagName : LookupNameKind.LookupOrdinaryName, 
        RedeclarationKind.ForRedeclaration);
    if (SS.isNotEmpty() && !SS.isInvalid()) {
      SemanticContext = $this().computeDeclContext(SS, true);
      if (!(SemanticContext != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // FIXME: Horrible, horrible hack! We can't currently represent this
          // in the AST, and historically we have just ignored such friend
          // class templates, so don't complain here.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(new SourceLocation(NameLoc), TUK == TagUseKind.TUK_Friend ? diag.warn_template_qualified_friend_ignored : diag.err_template_qualified_declarator_no_match)), 
                  SS.getScopeRep()), SS.getRange()));
          return new ActionResult<Decl /*P*/ >(TUK != TagUseKind.TUK_Friend);
        } finally {
          $c$.$destroy();
        }
      }
      if ($this().RequireCompleteDeclContext(SS, SemanticContext)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      // If we're adding a template to a dependent context, we may need to 
      // rebuilding some of the types used within the template parameter list, 
      // now that we know what the current instantiation is.
      if (SemanticContext.isDependentContext()) {
        ContextRAII SavedContext = null;
        try {
          SavedContext/*J*/= new ContextRAII(/*Deref*/$this(), SemanticContext);
          if ($this().RebuildTemplateParamsInCurrentInstantiation(TemplateParams)) {
            Invalid = true;
          }
        } finally {
          if (SavedContext != null) { SavedContext.$destroy(); }
        }
      } else if (TUK != TagUseKind.TUK_Friend && TUK != TagUseKind.TUK_Reference) {
        $this().diagnoseQualifiedDeclaration(SS, SemanticContext, new DeclarationName(Name), new SourceLocation(NameLoc));
      }
      
      $this().LookupQualifiedName(Previous, SemanticContext);
    } else {
      SemanticContext = $this().CurContext;
      
      // C++14 [class.mem]p14:
      //   If T is the name of a class, then each of the following shall have a
      //   name different from T:
      //    -- every member template of class T
      if (TUK != TagUseKind.TUK_Friend
         && $this().DiagnoseClassNameShadow(SemanticContext, 
          new DeclarationNameInfo(new DeclarationName(Name), new SourceLocation(NameLoc)))) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      $this().LookupName(Previous, S);
    }
    if (Previous.isAmbiguous()) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    NamedDecl /*P*/ PrevDecl = null;
    if (Previous.begin().$noteq(Previous.end())) {
      PrevDecl = (Previous.begin().$star()).getUnderlyingDecl();
    }
    if ((PrevDecl != null) && PrevDecl.isTemplateParameter()) {
      // Maybe we will complain about the shadowed template parameter.
      $this().DiagnoseTemplateParameterShadow(new SourceLocation(NameLoc), PrevDecl);
      // Just pretend that we didn't see the previous declaration.
      PrevDecl = null;
    }
    
    // If there is a previous declaration with the same name, check
    // whether this is a valid redeclaration.
    ClassTemplateDecl /*P*/ PrevClassTemplate = dyn_cast_or_null_ClassTemplateDecl(PrevDecl);
    
    // We may have found the injected-class-name of a class template,
    // class template partial specialization, or class template specialization.
    // In these cases, grab the template that is being defined or specialized.
    if (!(PrevClassTemplate != null) && (PrevDecl != null) && isa_CXXRecordDecl(PrevDecl)
       && cast_CXXRecordDecl(PrevDecl).isInjectedClassName()) {
      PrevDecl = cast_CXXRecordDecl(PrevDecl.getDeclContext());
      PrevClassTemplate
         = cast_CXXRecordDecl(PrevDecl).getDescribedClassTemplate();
      if (!(PrevClassTemplate != null) && isa_ClassTemplateSpecializationDecl(PrevDecl)) {
        PrevClassTemplate
           = cast_ClassTemplateSpecializationDecl(PrevDecl).
            getSpecializedTemplate();
      }
    }
    if (TUK == TagUseKind.TUK_Friend) {
      // C++ [namespace.memdef]p3:
      //   [...] When looking for a prior declaration of a class or a function
      //   declared as a friend, and when the name of the friend class or
      //   function is neither a qualified name nor a template-id, scopes outside
      //   the innermost enclosing namespace scope are not considered.
      if (!SS.isSet()) {
        DeclContext /*P*/ OutermostContext = $this().CurContext;
        while (!OutermostContext.isFileContext()) {
          OutermostContext = OutermostContext.getLookupParent();
        }
        if ((PrevDecl != null)
           && (OutermostContext.Equals(PrevDecl.getDeclContext())
           || OutermostContext.Encloses(PrevDecl.getDeclContext()))) {
          SemanticContext = PrevDecl.getDeclContext();
        } else {
          // Declarations in outer scopes don't matter. However, the outermost
          // context we computed is the semantic context for our new
          // declaration.
          PrevDecl = PrevClassTemplate = null;
          SemanticContext = OutermostContext;
          
          // Check that the chosen semantic context doesn't already contain a
          // declaration of this name as a non-tag type.
          Previous.clear(LookupNameKind.LookupOrdinaryName);
          DeclContext /*P*/ LookupContext = SemanticContext;
          while (LookupContext.isTransparentContext()) {
            LookupContext = LookupContext.getLookupParent();
          }
          $this().LookupQualifiedName(Previous, LookupContext);
          if (Previous.isAmbiguous()) {
            return new ActionResult<Decl /*P*/ >(true);
          }
          if (Previous.begin().$noteq(Previous.end())) {
            PrevDecl = (Previous.begin().$star()).getUnderlyingDecl();
          }
        }
      }
    } else if ((PrevDecl != null)
       && !$this().isDeclInScope(Previous.getRepresentativeDecl(), SemanticContext, 
        S, SS.isValid())) {
      PrevDecl = PrevClassTemplate = null;
    }
    {
      
      UsingShadowDecl /*P*/ Shadow = dyn_cast_or_null_UsingShadowDecl((PrevDecl != null) ? Previous.getRepresentativeDecl() : null);
      if ((Shadow != null)) {
        if (SS.isEmpty()
           && !((PrevClassTemplate != null)
           && PrevClassTemplate.getDeclContext().getRedeclContext().Equals(SemanticContext.getRedeclContext()))) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_using_decl_conflict_reverse)));
            $c$.clean($c$.track($this().Diag(Shadow.getTargetDecl().getLocation(), 
                diag.note_using_decl_target)));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Shadow.getUsingDecl().getLocation(), diag.note_using_decl)), 0));
            // Recover by ignoring the old declaration.
            PrevDecl = PrevClassTemplate = null;
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if ((PrevClassTemplate != null)) {
      // Ensure that the template parameter lists are compatible. Skip this check
      // for a friend in a dependent context: the template parameter list itself
      // could be dependent.
      if (!(TUK == TagUseKind.TUK_Friend && $this().CurContext.isDependentContext())
         && !$this().TemplateParameterListsAreEqual(TemplateParams, 
          PrevClassTemplate.getTemplateParameters(), 
          /*Complain=*/ true, 
          TemplateParameterListEqualKind.TPL_TemplateMatch)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      // C++ [temp.class]p4:
      //   In a redeclaration, partial specialization, explicit
      //   specialization or explicit instantiation of a class template,
      //   the class-key shall agree in kind with the original class
      //   template declaration (7.1.5.3).
      RecordDecl /*P*/ PrevRecordDecl = PrevClassTemplate.getTemplatedDecl();
      if (!$this().isAcceptableTagRedeclaration(PrevRecordDecl, Kind, 
          TUK == TagUseKind.TUK_Definition, new SourceLocation(KWLoc), Name)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_use_with_wrong_tag)), 
                  Name), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/KWLoc), PrevRecordDecl.getKindName())));
          $c$.clean($c$.track($this().Diag(PrevRecordDecl.getLocation(), diag.note_previous_use)));
          Kind = PrevRecordDecl.getTagKind();
        } finally {
          $c$.$destroy();
        }
      }
      
      // Check for redefinition of this class template.
      if (TUK == TagUseKind.TUK_Definition) {
        {
          TagDecl /*P*/ Def = PrevRecordDecl.getDefinition();
          if ((Def != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // If we have a prior definition that is not visible, treat this as
              // simply making that previous definition visible.
              type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr(null);
              if ((SkipBody != null) && !$this().hasVisibleDefinition(Def, $AddrOf(Hidden))) {
                SkipBody.ShouldSkip = true;
                ClassTemplateDecl /*P*/ Tmpl = cast_CXXRecordDecl(Hidden.$star()).getDescribedClassTemplate();
                assert ((Tmpl != null)) : "original definition of a class template is not a class template?";
                $this().makeMergedDefinitionVisible(Hidden.$star(), new SourceLocation(KWLoc));
                $this().makeMergedDefinitionVisible(Tmpl, new SourceLocation(KWLoc));
                return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Def);
              }
              
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_redefinition)), Name));
              $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
              // FIXME: Would it make sense to try to "forget" the previous
              // definition, as part of error recovery?
              return new ActionResult<Decl /*P*/ >(true);
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    } else if ((PrevDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // C++ [temp]p5:
        //   A class template shall not have the same name as any other
        //   template, class, function, object, enumeration, enumerator,
        //   namespace, or type in the same scope (3.3), except as specified
        //   in (14.5.4).
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_redefinition_different_kind)), Name));
        $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), diag.note_previous_definition)));
        return new ActionResult<Decl /*P*/ >(true);
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check the template parameter list of this declaration, possibly
    // merging in the template parameter list from the previous class
    // template declaration. Skip this check for a friend in a dependent
    // context, because the template parameter list might be dependent.
    if (!(TUK == TagUseKind.TUK_Friend && $this().CurContext.isDependentContext())
       && $this().CheckTemplateParameterList(TemplateParams, 
        (PrevClassTemplate != null) ? PrevClassTemplate.getTemplateParameters() : (TemplateParameterList /*P*/ )null, 
        (SS.isSet() && (SemanticContext != null) && SemanticContext.isRecord()
           && SemanticContext.isDependentContext()) ? TemplateParamListContext.TPC_ClassTemplateMember : TUK == TagUseKind.TUK_Friend ? TemplateParamListContext.TPC_FriendClassTemplate : TemplateParamListContext.TPC_ClassTemplate)) {
      Invalid = true;
    }
    if (SS.isSet()) {
      // If the name of the template was qualified, we must be defining the
      // template out-of-line.
      if (!SS.isInvalid() && !Invalid && !(PrevClassTemplate != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NameLoc), TUK == TagUseKind.TUK_Friend ? diag.err_friend_decl_does_not_match : diag.err_member_decl_does_not_match)), 
                          Name), SemanticContext), /*IsDefinition*/ true), SS.getRange()));
          Invalid = true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    CXXRecordDecl /*P*/ NewClass = CXXRecordDecl.Create($this().Context, Kind, SemanticContext, new SourceLocation(KWLoc), new SourceLocation(NameLoc), Name, 
        (PrevClassTemplate != null) ? PrevClassTemplate.getTemplatedDecl() : (CXXRecordDecl /*P*/ )null, 
        /*DelayTypeCreation=*/ true);
    SetNestedNameSpecifier(NewClass, SS);
    if ($greater_uint(NumOuterTemplateParamLists, 0)) {
      NewClass.setTemplateParameterListsInfo($this().Context, llvm.makeArrayRef(OuterTemplateParamLists, 
              NumOuterTemplateParamLists));
    }
    
    // Add alignment attributes if necessary; these attributes are checked when
    // the ASTContext lays out the structure.
    if (TUK == TagUseKind.TUK_Definition) {
      $this().AddAlignmentAttributesForRecord(NewClass);
      $this().AddMsStructLayoutForRecord(NewClass);
    }
    
    ClassTemplateDecl /*P*/ NewTemplate = ClassTemplateDecl.Create($this().Context, SemanticContext, new SourceLocation(NameLoc), 
        new DeclarationName(Name), TemplateParams, 
        NewClass, PrevClassTemplate);
    NewClass.setDescribedClassTemplate(NewTemplate);
    if (ModulePrivateLoc.isValid()) {
      NewTemplate.setModulePrivate();
    }
    
    // Build the type for the class template declaration now.
    QualType T = NewTemplate.getInjectedClassNameSpecialization();
    T.$assignMove($this().Context.getInjectedClassNameType(NewClass, new QualType(T)));
    assert (T.$arrow().isDependentType()) : "Class template type is not dependent?";
    ///*J:(void)*/T;
    
    // If we are providing an explicit specialization of a member that is a
    // class template, make a note of that.
    if ((PrevClassTemplate != null)
       && (PrevClassTemplate.getInstantiatedFromMemberTemplate() != null)) {
      PrevClassTemplate.setMemberSpecialization();
    }
    
    // Set the access specifier.
    if (!Invalid && TUK != TagUseKind.TUK_Friend && NewTemplate.getDeclContext().isRecord()) {
      $this().SetMemberAccessSpecifier(NewTemplate, PrevClassTemplate, AS);
    }
    
    // Set the lexical context of these templates
    NewClass.setLexicalDeclContext($this().CurContext);
    NewTemplate.setLexicalDeclContext($this().CurContext);
    if (TUK == TagUseKind.TUK_Definition) {
      NewClass.startDefinition();
    }
    if ((Attr != null)) {
      $this().ProcessDeclAttributeList(S, NewClass, Attr);
    }
    if ((PrevClassTemplate != null)) {
      $this().mergeDeclAttributes(NewClass, PrevClassTemplate.getTemplatedDecl());
    }
    
    $this().AddPushedVisibilityAttribute(NewClass);
    if (TUK != TagUseKind.TUK_Friend) {
      // Per C++ [basic.scope.temp]p2, skip the template parameter scopes.
      Scope /*P*/ Outer = S;
      while ((Outer.getFlags() & Scope.ScopeFlags.TemplateParamScope) != 0) {
        Outer = Outer.getParent();
      }
      $this().PushOnScopeChains(NewTemplate, Outer);
    } else {
      if ((PrevClassTemplate != null) && PrevClassTemplate.getAccess() != AccessSpecifier.AS_none) {
        NewTemplate.setAccess(PrevClassTemplate.getAccess());
        NewClass.setAccess(PrevClassTemplate.getAccess());
      }
      
      NewTemplate.setObjectOfFriendDecl();
      
      // Friend templates are visible in fairly strange ways.
      if (!$this().CurContext.isDependentContext()) {
        DeclContext /*P*/ DC = SemanticContext.getRedeclContext();
        DC.makeDeclVisibleInContext(NewTemplate);
        {
          Scope /*P*/ EnclosingScope = getScopeForDeclContext(S, DC);
          if ((EnclosingScope != null)) {
            $this().PushOnScopeChains(NewTemplate, EnclosingScope, 
                /* AddToContext = */ false);
          }
        }
      }
      
      FriendDecl /*P*/ Friend = FriendDecl.Create($this().Context, $this().CurContext, NewClass.getLocation(), new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T.INSTANCE, NamedDecl /*P*/ .class,  NewTemplate), new SourceLocation(FriendLoc));
      Friend.setAccess(AccessSpecifier.AS_public);
      $this().CurContext.addDecl(Friend);
    }
    if (Invalid) {
      NewTemplate.setInvalidDecl();
      NewClass.setInvalidDecl();
    }
    
    $this().ActOnDocumentableDecl(NewTemplate);
    
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, NewTemplate);
  } finally {
    if (Previous != null) { Previous.$destroy(); }
  }
}


/// \brief Translates template arguments as provided by the parser
/// into template arguments used by semantic analysis.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::translateTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 537,
 FQN="clang::Sema::translateTemplateArguments", NM="_ZN5clang4Sema26translateTemplateArgumentsERKN4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEERNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26translateTemplateArgumentsERKN4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEERNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final void translateTemplateArguments(final /*const*/MutableArrayRef<ParsedTemplateArgument> /*&*/ TemplateArgsIn, 
                          final TemplateArgumentListInfo /*&*/ TemplateArgs) {
  for (/*uint*/int I = 0, Last = TemplateArgsIn.size(); I != Last; ++I)  {
    TemplateArgs.addArgument(translateTemplateArgument(/*Deref*/$this(), 
            TemplateArgsIn.$at(I)));
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::NoteAllFoundTemplates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2014,
 FQN="clang::Sema::NoteAllFoundTemplates", NM="_ZN5clang4Sema21NoteAllFoundTemplatesENS_12TemplateNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema21NoteAllFoundTemplatesENS_12TemplateNameE")
//</editor-fold>
public final void NoteAllFoundTemplates(TemplateName Name) {
  {
    TemplateDecl /*P*/ Template = Name.getAsTemplateDecl();
    if ((Template != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Template.getLocation(), diag.note_template_declared_here)), 
                (isa_FunctionTemplateDecl(Template) ? 0 : isa_ClassTemplateDecl(Template) ? 1 : isa_VarTemplateDecl(Template) ? 2 : isa_TypeAliasTemplateDecl(Template) ? 3 : 4)), 
            Template.getDeclName()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    
    OverloadedTemplateStorage /*P*/ OST = Name.getAsOverloadedTemplate();
    if ((OST != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        for (type$ptr<NamedDecl /*P*/ /*const*/ /*P*/> I = $tryClone(OST.begin()), 
            /*P*/ /*const*/ /*P*/ IEnd = $tryClone(OST.end());
             $noteq_ptr(I, IEnd); I.$preInc())  {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag((I.$star()).getLocation(), diag.note_template_declared_here)), 
                  0), (I.$star()).getDeclName()));
        }
        
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateIdType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2114,
 FQN="clang::Sema::CheckTemplateIdType", NM="_ZN5clang4Sema19CheckTemplateIdTypeENS_12TemplateNameENS_14SourceLocationERNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema19CheckTemplateIdTypeENS_12TemplateNameENS_14SourceLocationERNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final QualType CheckTemplateIdType(TemplateName Name, 
                   SourceLocation TemplateLoc, 
                   final TemplateArgumentListInfo /*&*/ TemplateArgs) {
  DependentTemplateName /*P*/ DTN = Name.getUnderlying().getAsDependentTemplateName();
  if ((DTN != null) && DTN.isIdentifier()) {
    // When building a template-id where the template-name is dependent,
    // assume the template is a type template. Either our assumption is
    // correct, or the code is ill-formed and will be diagnosed when the
    // dependent name is substituted.
    return $this().Context.getDependentTemplateSpecializationType(ElaboratedTypeKeyword.ETK_None, 
        DTN.getQualifier(), 
        DTN.getIdentifier(), 
        TemplateArgs);
  }
  
  TemplateDecl /*P*/ Template = Name.getAsTemplateDecl();
  if (!(Template != null) || isa_FunctionTemplateDecl(Template)
     || isa_VarTemplateDecl(Template)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // We might have a substituted template template parameter pack. If so,
      // build a template specialization type for it.
      if ((Name.getAsSubstTemplateTemplateParmPack() != null)) {
        return $this().Context.getTemplateSpecializationType(new TemplateName(Name), TemplateArgs);
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateLoc), diag.err_template_id_not_a_type)), 
          Name));
      $this().NoteAllFoundTemplates(new TemplateName(Name));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // Check that the template argument list is well-formed for this
  // template.
  SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
  if ($this().CheckTemplateArgumentList(Template, new SourceLocation(TemplateLoc), TemplateArgs, 
      false, _Converted)) {
    return new QualType();
  }
  
  QualType CanonType/*J*/= new QualType();
  
  bool$ref InstantiationDependent = create_bool$ref(false);
  {
    TypeAliasTemplateDecl /*P*/ AliasTemplate = dyn_cast_TypeAliasTemplateDecl(Template);
    if ((AliasTemplate != null)) {
      MultiLevelTemplateArgumentList TemplateArgLists = null;
      LocalInstantiationScope Scope = null;
      InstantiatingTemplate Inst = null;
      try {
        // Find the canonical type for this type alias template specialization.
        TypeAliasDecl /*P*/ Pattern = AliasTemplate.getTemplatedDecl();
        if (Pattern.isInvalidDecl()) {
          return new QualType();
        }
        
        TemplateArgumentList TemplateArgs$1/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, 
            new ArrayRef<TemplateArgument>(_Converted, false));
        
        // Only substitute for the innermost template argument list.
        TemplateArgLists/*J*/= new MultiLevelTemplateArgumentList();
        TemplateArgLists.addOuterTemplateArguments($AddrOf(TemplateArgs$1));
        /*uint*/int Depth = AliasTemplate.getTemplateParameters().getDepth();
        for (/*uint*/int I = 0; $less_uint(I, Depth); ++I)  {
          TemplateArgLists.addOuterTemplateArguments(new ArrayRef<TemplateArgument>(None, false));
        }
        
        Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
        Inst/*J*/= new InstantiatingTemplate(/*Deref*/$this(), new SourceLocation(TemplateLoc), Template);
        if (Inst.isInvalid()) {
          return new QualType();
        }
        
        CanonType.$assignMove($this().SubstType(Pattern.getUnderlyingType(), 
                TemplateArgLists, AliasTemplate.getLocation(), 
                AliasTemplate.getDeclName()));
        if (CanonType.isNull()) {
          return new QualType();
        }
      } finally {
        if (Inst != null) { Inst.$destroy(); }
        if (Scope != null) { Scope.$destroy(); }
        if (TemplateArgLists != null) { TemplateArgLists.$destroy(); }
      }
    } else if (Name.isDependent()
       || TemplateSpecializationType.anyDependentTemplateArguments(TemplateArgs, InstantiationDependent)) {
      // This class template specialization is a dependent
      // type. Therefore, its canonical type is another class template
      // specialization type that contains all of the converted
      // arguments in canonical form. This ensures that, e.g., A<T> and
      // A<T, T> have identical types when A is declared as:
      //
      //   template<typename T, typename U = T> struct A;
      TemplateName CanonName = $this().Context.getCanonicalTemplateName(new TemplateName(Name));
      CanonType.$assignMove($this().Context.getTemplateSpecializationType(new TemplateName(CanonName), 
              new ArrayRef<TemplateArgument>(_Converted, false)));
      
      // FIXME: CanonType is not actually the canonical type, and unfortunately
      // it is a TemplateSpecializationType that we will never use again.
      // In the future, we need to teach getTemplateSpecializationType to only
      // build the canonical type and return that to us.
      CanonType.$assignMove($this().Context.getCanonicalType(new QualType(CanonType)).$QualType());
      
      // This might work out to be a current instantiation, in which
      // case the canonical type needs to be the InjectedClassNameType.
      //
      // TODO: in theory this could be a simple hashtable lookup; most
      // changes to CurContext don't change the set of current
      // instantiations.
      if (isa_ClassTemplateDecl(Template)) {
        for (DeclContext /*P*/ Ctx = $this().CurContext; (Ctx != null); Ctx = Ctx.getLookupParent()) {
          // If we get out to a namespace, we're done.
          if (Ctx.isFileContext()) {
            break;
          }
          
          // If this isn't a record, keep looking.
          CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(Ctx);
          if (!(Record != null)) {
            continue;
          }
          
          // Look for one of the two cases with InjectedClassNameTypes
          // and check whether it's the same template.
          if (!isa_ClassTemplatePartialSpecializationDecl(Record)
             && !(Record.getDescribedClassTemplate() != null)) {
            continue;
          }
          
          // Fetch the injected class name type and check whether its
          // injected type is equal to the type we just built.
          QualType ICNT = $this().Context.getTypeDeclType(Record);
          QualType Injected = cast_InjectedClassNameType(ICNT).
              getInjectedSpecializationType();
          if ($noteq_QualType$C(CanonType, Injected.$arrow().getCanonicalTypeInternal())) {
            continue;
          }
          
          // If so, the canonical type of this TST is the injected
          // class name type of the record we just found.
          assert (ICNT.isCanonical());
          CanonType.$assign(ICNT);
          break;
        }
      }
    } else {
      ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(Template);
      if ((ClassTemplate != null)) {
        // Find the class template specialization declaration that
        // corresponds to these arguments.
        type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
        ClassTemplateSpecializationDecl /*P*/ Decl = ClassTemplate.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
        if (!(Decl != null)) {
          // This is the first time we have referenced this class template
          // specialization. Create the canonical declaration and add it to
          // the set of specializations.
          Decl = ClassTemplateSpecializationDecl.Create($this().Context, 
              ClassTemplate.getTemplatedDecl().getTagKind(), 
              ClassTemplate.getDeclContext(), 
              ClassTemplate.getTemplatedDecl().getLocStart(), 
              ClassTemplate.getLocation(), 
              ClassTemplate, 
              new ArrayRef<TemplateArgument>(_Converted, false), (ClassTemplateSpecializationDecl /*P*/ )null);
          ClassTemplate.AddSpecialization(Decl, InsertPos.$deref());
          if (ClassTemplate.isOutOfLine()) {
            Decl.setLexicalDeclContext(ClassTemplate.getLexicalDeclContext());
          }
        }
        
        // Diagnose uses of this specialization.
        /*J:(void)*/$this().DiagnoseUseOfDecl(Decl, new SourceLocation(TemplateLoc));
        
        CanonType.$assignMove($this().Context.getTypeDeclType(Decl));
        assert (isa_RecordType(CanonType)) : "type of non-dependent specialization is not a RecordType";
      } else {
        BuiltinTemplateDecl /*P*/ BTD = dyn_cast_BuiltinTemplateDecl(Template);
        if ((BTD != null)) {
          CanonType.$assignMove(checkBuiltinTemplateIdType(/*Deref*/$this(), BTD, _Converted, new SourceLocation(TemplateLoc), 
                  TemplateArgs));
        }
      }
    }
  }
  
  // Build the fully-sugared type for this class template
  // specialization, which refers back to the class template
  // specialization we created or found.
  return $this().Context.getTemplateSpecializationType(new TemplateName(Name), TemplateArgs, new QualType(CanonType));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTemplateIdType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2277,
 FQN="clang::Sema::ActOnTemplateIdType", NM="_ZN5clang4Sema19ActOnTemplateIdTypeERNS_12CXXScopeSpecENS_14SourceLocationENS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema19ActOnTemplateIdTypeERNS_12CXXScopeSpecENS_14SourceLocationENS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_b")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnTemplateIdType(final CXXScopeSpec /*&*/ SS, SourceLocation TemplateKWLoc, 
                   OpaquePtr<TemplateName> TemplateD, SourceLocation TemplateLoc, 
                   SourceLocation LAngleLoc, 
                   MutableArrayRef<ParsedTemplateArgument> TemplateArgsIn, 
                   SourceLocation RAngleLoc) {
  return ActOnTemplateIdType(SS, TemplateKWLoc, 
                   TemplateD, TemplateLoc, 
                   LAngleLoc, 
                   TemplateArgsIn, 
                   RAngleLoc, 
                   false);
}
public final ActionResult<OpaquePtr<QualType> > ActOnTemplateIdType(final CXXScopeSpec /*&*/ SS, SourceLocation TemplateKWLoc, 
                   OpaquePtr<TemplateName> TemplateD, SourceLocation TemplateLoc, 
                   SourceLocation LAngleLoc, 
                   MutableArrayRef<ParsedTemplateArgument> TemplateArgsIn, 
                   SourceLocation RAngleLoc, 
                   boolean IsCtorOrDtorName/*= false*/) {
  TemplateArgumentListInfo TemplateArgs = null;
  TypeLocBuilder TLB = null;
  try {
    if (SS.isInvalid()) {
      return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
    }
    
    TemplateName Template = TemplateD.getTemplateName();
    
    // Translate the parser's template argument list in our AST format.
    TemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
    $this().translateTemplateArguments(TemplateArgsIn, TemplateArgs);
    {
      
      DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
      if ((DTN != null)) {
        TypeLocBuilder TLB$1 = null;
        try {
          QualType T = $this().Context.getDependentTemplateSpecializationType(ElaboratedTypeKeyword.ETK_None, 
              DTN.getQualifier(), 
              DTN.getIdentifier(), 
              TemplateArgs);
          // Build type-source information.
          TLB$1/*J*/= new TypeLocBuilder();
          DependentTemplateSpecializationTypeLoc SpecTL = TLB$1.<DependentTemplateSpecializationTypeLoc>push(DependentTemplateSpecializationTypeLoc.class, new QualType(T));
          SpecTL.setElaboratedKeywordLoc(new SourceLocation());
          SpecTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
          SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
          SpecTL.setTemplateNameLoc(new SourceLocation(TemplateLoc));
          SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
          SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
          for (/*uint*/int I = 0, N = SpecTL.getNumArgs(); I != N; ++I)  {
            SpecTL.setArgLocInfo(I, TemplateArgs.$at(I).getLocInfo());
          }
          return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(T), TLB$1.getTypeSourceInfo($this().Context, new QualType(T))));
        } finally {
          if (TLB$1 != null) { TLB$1.$destroy(); }
        }
      }
    }
    
    QualType Result = $this().CheckTemplateIdType(new TemplateName(Template), new SourceLocation(TemplateLoc), TemplateArgs);
    if (Result.isNull()) {
      return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
    }
    
    // Build type-source information.
    TLB/*J*/= new TypeLocBuilder();
    TemplateSpecializationTypeLoc SpecTL = TLB.<TemplateSpecializationTypeLoc>push(TemplateSpecializationTypeLoc.class, new QualType(Result));
    SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
    SpecTL.setTemplateNameLoc(new SourceLocation(TemplateLoc));
    SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
    SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
    for (/*uint*/int i = 0, e = SpecTL.getNumArgs(); i != e; ++i)  {
      SpecTL.setArgLocInfo(i, TemplateArgs.$at(i).getLocInfo());
    }
    
    // NOTE: avoid constructing an ElaboratedTypeLoc if this is a
    // constructor or destructor name (in such a case, the scope specifier
    // will be attached to the enclosing Decl or Expr node).
    if (SS.isNotEmpty() && !IsCtorOrDtorName) {
      // Create an elaborated-type-specifier containing the nested-name-specifier.
      Result.$assignMove($this().Context.getElaboratedType(ElaboratedTypeKeyword.ETK_None, SS.getScopeRep(), new QualType(Result)));
      ElaboratedTypeLoc ElabTL = TLB.<ElaboratedTypeLoc>push(ElaboratedTypeLoc.class, new QualType(Result));
      ElabTL.setElaboratedKeywordLoc(new SourceLocation());
      ElabTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
    }
    
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(Result), TLB.getTypeSourceInfo($this().Context, new QualType(Result))));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}


/// \brief Parsed an elaborated-type-specifier that refers to a template-id,
/// such as \c class T::template apply<U>.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTagTemplateIdType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2344,
 FQN="clang::Sema::ActOnTagTemplateIdType", NM="_ZN5clang4Sema22ActOnTagTemplateIdTypeENS0_10TagUseKindENS_17TypeSpecifierTypeENS_14SourceLocationERNS_12CXXScopeSpecES3_NS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema22ActOnTagTemplateIdTypeENS0_10TagUseKindENS_17TypeSpecifierTypeENS_14SourceLocationERNS_12CXXScopeSpecES3_NS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnTagTemplateIdType(TagUseKind TUK, 
                      TypeSpecifierType TagSpec, 
                      SourceLocation TagLoc, 
                      final CXXScopeSpec /*&*/ SS, 
                      SourceLocation TemplateKWLoc, 
                      OpaquePtr<TemplateName> TemplateD, 
                      SourceLocation TemplateLoc, 
                      SourceLocation LAngleLoc, 
                      MutableArrayRef<ParsedTemplateArgument> TemplateArgsIn, 
                      SourceLocation RAngleLoc) {
  TemplateArgumentListInfo TemplateArgs = null;
  TypeLocBuilder TLB = null;
  try {
    TemplateName Template = TemplateD.getTemplateName();
    
    // Translate the parser's template argument list in our AST format.
    TemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
    $this().translateTemplateArguments(TemplateArgsIn, TemplateArgs);
    
    // Determine the tag kind
    TagTypeKind TagKind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec.getValue());
    ElaboratedTypeKeyword Keyword = TypeWithKeyword.getKeywordForTagTypeKind(TagKind);
    {
      
      DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
      if ((DTN != null)) {
        TypeLocBuilder TLB$1 = null;
        try {
          QualType T = $this().Context.getDependentTemplateSpecializationType(Keyword, 
              DTN.getQualifier(), 
              DTN.getIdentifier(), 
              TemplateArgs);
          
          // Build type-source information.    
          TLB$1/*J*/= new TypeLocBuilder();
          DependentTemplateSpecializationTypeLoc SpecTL = TLB$1.<DependentTemplateSpecializationTypeLoc>push(DependentTemplateSpecializationTypeLoc.class, new QualType(T));
          SpecTL.setElaboratedKeywordLoc(new SourceLocation(TagLoc));
          SpecTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
          SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
          SpecTL.setTemplateNameLoc(new SourceLocation(TemplateLoc));
          SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
          SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
          for (/*uint*/int I = 0, N = SpecTL.getNumArgs(); I != N; ++I)  {
            SpecTL.setArgLocInfo(I, TemplateArgs.$at(I).getLocInfo());
          }
          return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(T), TLB$1.getTypeSourceInfo($this().Context, new QualType(T))));
        } finally {
          if (TLB$1 != null) { TLB$1.$destroy(); }
        }
      }
    }
    {
      
      TypeAliasTemplateDecl /*P*/ TAT = dyn_cast_or_null_TypeAliasTemplateDecl(Template.getAsTemplateDecl());
      if ((TAT != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++0x [dcl.type.elab]p2:
          //   If the identifier resolves to a typedef-name or the simple-template-id
          //   resolves to an alias template specialization, the
          //   elaborated-type-specifier is ill-formed.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateLoc), diag.err_tag_reference_non_tag)), 4));
          $c$.clean($c$.track($this().Diag(TAT.getLocation(), diag.note_declared_at)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    QualType Result = $this().CheckTemplateIdType(new TemplateName(Template), new SourceLocation(TemplateLoc), TemplateArgs);
    if (Result.isNull()) {
      return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
    }
    {
      
      // Check the tag kind
      /*const*/ RecordType /*P*/ RT = Result.$arrow().getAs$RecordType();
      if ((RT != null)) {
        RecordDecl /*P*/ D = RT.getDecl();
        
        IdentifierInfo /*P*/ Id = D.getIdentifier();
        assert ((Id != null)) : "templated class must have an identifier";
        if (!$this().isAcceptableTagRedeclaration(D, TagKind, TUK == TagUseKind.TUK_Definition, 
            new SourceLocation(TagLoc), Id)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TagLoc), diag.err_use_with_wrong_tag)), 
                    Result), 
                FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/TagLoc), D.getKindName())));
            $c$.clean($c$.track($this().Diag(D.getLocation(), diag.note_previous_use)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // Provide source-location information for the template specialization.
    TLB/*J*/= new TypeLocBuilder();
    TemplateSpecializationTypeLoc SpecTL = TLB.<TemplateSpecializationTypeLoc>push(TemplateSpecializationTypeLoc.class, new QualType(Result));
    SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
    SpecTL.setTemplateNameLoc(new SourceLocation(TemplateLoc));
    SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
    SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
    for (/*uint*/int i = 0, e = SpecTL.getNumArgs(); i != e; ++i)  {
      SpecTL.setArgLocInfo(i, TemplateArgs.$at(i).getLocInfo());
    }
    
    // Construct an elaborated type containing the nested-name-specifier (if any)
    // and tag keyword.
    Result.$assignMove($this().Context.getElaboratedType(Keyword, SS.getScopeRep(), new QualType(Result)));
    ElaboratedTypeLoc ElabTL = TLB.<ElaboratedTypeLoc>push(ElaboratedTypeLoc.class, new QualType(Result));
    ElabTL.setElaboratedKeywordLoc(new SourceLocation(TagLoc));
    ElabTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(Result), TLB.getTypeSourceInfo($this().Context, new QualType(Result))));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnVarTemplateSpecialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2521,
 FQN="clang::Sema::ActOnVarTemplateSpecialization", NM="_ZN5clang4Sema30ActOnVarTemplateSpecializationEPNS_5ScopeERNS_10DeclaratorEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_21TemplateParameterListENS_12StorageClassEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema30ActOnVarTemplateSpecializationEPNS_5ScopeERNS_10DeclaratorEPNS_14TypeSourceInfoENS_14SourceLocationEPNS_21TemplateParameterListENS_12StorageClassEb")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnVarTemplateSpecialization(Scope /*P*/ S, final Declarator /*&*/ D, TypeSourceInfo /*P*/ DI, SourceLocation TemplateKWLoc, 
                              TemplateParameterList /*P*/ TemplateParams, StorageClass SC, 
                              boolean IsPartialSpecialization) {
  TemplateArgumentListInfo TemplateArgs = null;
  try {
    // D must be variable template id.
    assert (D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId) : "Variable template specialization is declared with a template it.";
    
    TemplateIdAnnotation /*P*/ TemplateId = D.getName().Unnamed_field1.TemplateId;
    TemplateArgs = makeTemplateArgumentListInfo(/*Deref*/$this(), $Deref(TemplateId));
    SourceLocation TemplateNameLoc = D.getIdentifierLoc();
    SourceLocation LAngleLoc = new SourceLocation(TemplateId.LAngleLoc);
    SourceLocation RAngleLoc = new SourceLocation(TemplateId.RAngleLoc);
    
    TemplateName Name = TemplateId.Template.getTemplateName();
    
    // The template-id must name a variable template.
    VarTemplateDecl /*P*/ VarTemplate = dyn_cast_or_null_VarTemplateDecl(Name.getAsTemplateDecl());
    if (!(VarTemplate != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        NamedDecl /*P*/ FnTemplate;
        {
          OverloadedTemplateStorage /*P*/ OTS = Name.getAsOverloadedTemplate();
          if ((OTS != null)) {
            FnTemplate = OTS.begin().$star();
          } else {
            FnTemplate = dyn_cast_or_null_FunctionTemplateDecl(Name.getAsTemplateDecl());
          }
        }
        if ((FnTemplate != null)) {
          return $c$.clean(new ActionResult<Decl /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_var_spec_no_template_but_method)), 
                  FnTemplate.getDeclName())));
        }
        return $c$.clean(new ActionResult<Decl /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_var_spec_no_template)), 
                IsPartialSpecialization)));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Check for unexpanded parameter packs in any of the template arguments.
    for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
      if ($this().DiagnoseUnexpandedParameterPack(new TemplateArgumentLoc(TemplateArgs.$at(I)), 
          UnexpandedParameterPackContext.UPPC_PartialSpecialization)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
    }
    
    // Check that the template argument list is well-formed for this
    // template.
    SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    if ($this().CheckTemplateArgumentList(VarTemplate, new SourceLocation(TemplateNameLoc), TemplateArgs, 
        false, _Converted)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // Find the variable template (partial) specialization declaration that
    // corresponds to these arguments.
    if (IsPartialSpecialization) {
      if (CheckTemplatePartialSpecializationArgs(/*Deref*/$this(), new SourceLocation(TemplateNameLoc), VarTemplate.getTemplateParameters(), 
          TemplateArgs.size(), _Converted)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      bool$ref InstantiationDependent = create_bool$ref();
      if (!Name.isDependent()
         && !TemplateSpecializationType.anyDependentTemplateArguments(TemplateArgs.arguments(), 
          InstantiationDependent)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_partial_spec_fully_specialized)), 
              VarTemplate.getDeclName()));
          IsPartialSpecialization = false;
        } finally {
          $c$.$destroy();
        }
      }
      if (isSameAsPrimaryTemplate(VarTemplate.getTemplateParameters(), 
          new ArrayRef<TemplateArgument>(_Converted, false))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [temp.class.spec]p9b3:
          //
          //   -- The argument list of the specialization shall not be identical
          //      to the implicit argument list of the primary template.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_partial_spec_args_match_primary_template)), 
                      /*variable template*/ 1), 
                  /*is definition*/ (SC != StorageClass.SC_Extern && !$this().CurContext.isRecord())), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc))));
          // FIXME: Recover from this by treating the declaration as a redeclaration
          // of the primary template.
          return new ActionResult<Decl /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    VarTemplateSpecializationDecl /*P*/ PrevDecl = null;
    if (IsPartialSpecialization) {
      // FIXME: Template parameter list matters too
      PrevDecl = VarTemplate.findPartialSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), (type$ref<type$ptr<VarTemplatePartialSpecializationDecl /*P*/>/*void P*/ >)(type$ref)InsertPos);
    } else {
      PrevDecl = VarTemplate.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
    }
    
    VarTemplateSpecializationDecl /*P*/ Specialization = null;
    
    // Check whether we can declare a variable template specialization in
    // the current scope.
    if (CheckTemplateSpecializationScope(/*Deref*/$this(), VarTemplate, PrevDecl, 
        new SourceLocation(TemplateNameLoc), 
        IsPartialSpecialization)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    if ((PrevDecl != null) && PrevDecl.getSpecializationKind() == TemplateSpecializationKind.TSK_Undeclared) {
      // Since the only prior variable template specialization with these
      // arguments was referenced but not declared,  reuse that
      // declaration node as our own, updating its source location and
      // the list of outer template parameters to reflect our new declaration.
      Specialization = PrevDecl;
      Specialization.setLocation(new SourceLocation(TemplateNameLoc));
      PrevDecl = null;
    } else if (IsPartialSpecialization) {
      // Create a new class template partial specialization declaration node.
      VarTemplatePartialSpecializationDecl /*P*/ PrevPartial = cast_or_null_VarTemplatePartialSpecializationDecl(PrevDecl);
      VarTemplatePartialSpecializationDecl /*P*/ Partial = VarTemplatePartialSpecializationDecl.Create($this().Context, VarTemplate.getDeclContext(), new SourceLocation(TemplateKWLoc), 
          new SourceLocation(TemplateNameLoc), TemplateParams, VarTemplate, DI.getType(), DI, SC, 
          new ArrayRef<TemplateArgument>(_Converted, false), TemplateArgs);
      if (!(PrevPartial != null)) {
        VarTemplate.AddPartialSpecialization(Partial, (type$ptr<VarTemplatePartialSpecializationDecl /*P*/>)(type$ptr)InsertPos.$deref());
      }
      Specialization = Partial;

      // If we are providing an explicit specialization of a member variable
      // template specialization, make a note of that.
      if ((PrevPartial != null) && (PrevPartial.getInstantiatedFromMember() != null)) {
        PrevPartial.setMemberSpecialization();
      }

      // Check that all of the template parameters of the variable template
      // partial specialization are deducible from the template
      // arguments. If not, this variable template partial specialization
      // will never be used.
      SmallBitVector DeducibleParams/*J*/= new SmallBitVector(TemplateParams.size());
      $this().MarkUsedTemplateParameters(Partial.getTemplateArgs(), true, 
          TemplateParams.getDepth(), DeducibleParams);
      if (!DeducibleParams.all()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int NumNonDeducible = DeducibleParams.size() - DeducibleParams.count();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.warn_partial_specs_not_deducible)), 
                      /*variable template*/ 1), ($greater_uint(NumNonDeducible, 1))), 
              new SourceRange(/*NO_COPY*/TemplateNameLoc, /*NO_COPY*/RAngleLoc)));
          for (/*uint*/int I = 0, N = DeducibleParams.size(); I != N; ++I) {
            if (!DeducibleParams.$at$Const(I)/*.$bool()*/) {
              NamedDecl /*P*/ Param = cast_NamedDecl(TemplateParams.getParam(I));
              if (Param.getDeclName().$bool()) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), diag.note_partial_spec_unused_parameter)), 
                    Param.getDeclName()));
              } else {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), diag.note_partial_spec_unused_parameter)), 
                    /*KEEP_STR*/"(anonymous)"));
              }
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      // Create a new class template specialization declaration node for
      // this explicit specialization or friend declaration.
      Specialization = VarTemplateSpecializationDecl.Create($this().Context, VarTemplate.getDeclContext(), new SourceLocation(TemplateKWLoc), new SourceLocation(TemplateNameLoc), 
          VarTemplate, DI.getType(), DI, SC, new ArrayRef<TemplateArgument>(_Converted, false));
      Specialization.setTemplateArgsInfo(TemplateArgs);
      if (!(PrevDecl != null)) {
        VarTemplate.AddSpecialization(Specialization, InsertPos.$deref());
      }
    }
    
    // C++ [temp.expl.spec]p6:
    //   If a template, a member template or the member of a class template is
    //   explicitly specialized then that specialization shall be declared
    //   before the first use of that specialization that would cause an implicit
    //   instantiation to take place, in every translation unit in which such a
    //   use occurs; no diagnostic is required.
    if ((PrevDecl != null) && PrevDecl.getPointOfInstantiation().isValid()) {
      boolean Okay = false;
      for (Decl /*P*/ Prev = PrevDecl; (Prev != null); Prev = Prev.getPreviousDecl()) {
        // Is there any previous explicit specialization declaration?
        if (getTemplateSpecializationKind(Prev) == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
          Okay = true;
          break;
        }
      }
      if (!Okay) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/TemplateNameLoc, /*NO_COPY*/RAngleLoc);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_specialization_after_instantiation)), 
                  Name), Range));
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevDecl.getPointOfInstantiation(), 
                  diag.note_instantiation_required_here)), 
              (PrevDecl.getTemplateSpecializationKind()
                 != TemplateSpecializationKind.TSK_ImplicitInstantiation)));
          return new ActionResult<Decl /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    Specialization.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
    Specialization.setLexicalDeclContext($this().CurContext);
    
    // Add the specialization into its lexical context, so that it can
    // be seen when iterating through the list of declarations in that
    // context. However, specializations are not found by name lookup.
    $this().CurContext.addDecl(Specialization);
    
    // Note that this is an explicit specialization.
    Specialization.setSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
    if ((PrevDecl != null)) {
      LookupResult PrevSpec = null;
      try {
        // Check that this isn't a redefinition of this specialization,
        // merging with previous declarations.
        PrevSpec/*J*/= new LookupResult(/*Deref*/$this(), $this().GetNameForDeclarator(D), LookupNameKind.LookupOrdinaryName, 
            RedeclarationKind.ForRedeclaration);
        PrevSpec.addDecl(PrevDecl);
        D.setRedeclaration($this().CheckVariableDeclaration(Specialization, PrevSpec));
      } finally {
        if (PrevSpec != null) { PrevSpec.$destroy(); }
      }
    } else if (Specialization.isStaticDataMember()
       && Specialization.isOutOfLine()) {
      Specialization.setAccess(VarTemplate.getAccess());
    }
    
    // Link instantiations of static data members back to the template from
    // which they were instantiated.
    if (Specialization.isStaticDataMember()) {
      Specialization.setInstantiationOfStaticDataMember(VarTemplate.getTemplatedDecl(), 
          Specialization.getSpecializationKind());
    }
    
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Specialization);
  } finally {
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVarTemplateId">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2755,
 FQN="clang::Sema::CheckVarTemplateId", NM="_ZN5clang4Sema18CheckVarTemplateIdEPNS_15VarTemplateDeclENS_14SourceLocationES3_RKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema18CheckVarTemplateIdEPNS_15VarTemplateDeclENS_14SourceLocationES3_RKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > CheckVarTemplateId(VarTemplateDecl /*P*/ Template, SourceLocation TemplateLoc, 
                  SourceLocation TemplateNameLoc, 
                  final /*const*/ TemplateArgumentListInfo /*&*/ TemplateArgs) {
  TemplateSpecCandidateSet FailedCandidates = null;
  try {
    assert ((Template != null)) : "A variable template id without template?";
    
    // Check that the template argument list is well-formed for this template.
    SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    if ($this().CheckTemplateArgumentList(Template, new SourceLocation(TemplateNameLoc), 
        ((/*const_cast*/TemplateArgumentListInfo /*&*/ )(TemplateArgs)), false, 
        _Converted)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // Find the variable template specialization declaration that
    // corresponds to these arguments.
    final type$ref<type$ptr<VarTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    {
      VarTemplateSpecializationDecl /*P*/ Spec = Template.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
      if ((Spec != null)) {
        $this().checkSpecializationVisibility(new SourceLocation(TemplateNameLoc), Spec);
        // If we already have a variable template specialization, return it.
        return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Spec);
      }
    }
    
    // This is the first time we have referenced this variable template
    // specialization. Create the canonical declaration and add it to
    // the set of specializations, based on the closest partial specialization
    // that it represents. That is,
    VarDecl /*P*/ InstantiationPattern = Template.getTemplatedDecl();
    TemplateArgumentList TemplateArgList/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, 
        new ArrayRef<TemplateArgument>(_Converted, false));
    TemplateArgumentList /*P*/ InstantiationArgs = $AddrOf(TemplateArgList);
    boolean AmbiguousPartialSpec = false;
    /*typedef PartialSpecMatchResult MatchResult*/
//    final class MatchResult extends PartialSpecMatchResult{ };
    SmallVector<SemaTemplateStatics.PartialSpecMatchResult> Matched/*J*/= new SmallVector<SemaTemplateStatics.PartialSpecMatchResult>(4, new SemaTemplateStatics.PartialSpecMatchResult());
    SourceLocation PointOfInstantiation = new SourceLocation(TemplateNameLoc);
    FailedCandidates/*J*/= new TemplateSpecCandidateSet(new SourceLocation(PointOfInstantiation), 
        /*ForTakingAddress=*/ false);
    
    // 1. Attempt to find the closest partial specialization that this
    // specializes, if any.
    // If any of the template arguments is dependent, then this is probably
    // a placeholder for an incomplete declarative context; which must be
    // complete by instantiation time. Thus, do not search through the partial
    // specializations yet.
    // TODO: Unify with InstantiateClassTemplateSpecialization()?
    //       Perhaps better after unification of DeduceTemplateArguments() and
    //       getMoreSpecializedPartialSpecialization().
    bool$ref InstantiationDependent = create_bool$ref(false);
    if (!TemplateSpecializationType.anyDependentTemplateArguments(TemplateArgs, InstantiationDependent)) {
      
      SmallVector<VarTemplatePartialSpecializationDecl /*P*/ > PartialSpecs/*J*/= new SmallVector<VarTemplatePartialSpecializationDecl /*P*/ >(4, (VarTemplatePartialSpecializationDecl /*P*/ )null);
      Template.getPartialSpecializations(PartialSpecs);
      
      for (/*uint*/int I = 0, N = PartialSpecs.size(); I != N; ++I) {
        TemplateDeductionInfo Info = null;
        try {
          VarTemplatePartialSpecializationDecl /*P*/ Partial = PartialSpecs.$at(I);
          Info/*J*/= new TemplateDeductionInfo(FailedCandidates.getLocation());
          {
            
            TemplateDeductionResult Result = $this().DeduceTemplateArguments(Partial, TemplateArgList, Info);
            if ((Result.getValue() != 0)) {
              // Store the failed-deduction information for use in diagnostics, later.
              // TODO: Actually use the failed-deduction info?
              FailedCandidates.addCandidate().set(DeclAccessPair.make(Template, AccessSpecifier.AS_public), Partial, 
                  MakeDeductionFailureInfo($this().Context, Result, Info));
              ///*J:(void)*/Result;
            } else {
              Matched.push_back(new SemaTemplateStatics.PartialSpecMatchResult());
              Matched.back().Partial = Partial;
              Matched.back().Args = Info.take();
            }
          }
        } finally {
          if (Info != null) { Info.$destroy(); }
        }
      }
      if ($greatereq_uint(Matched.size(), 1)) {
        type$ptr<SemaTemplateStatics.PartialSpecMatchResult> Best = $tryClone(Matched.begin());
        if (Matched.size() == 1) {
          //   -- If exactly one matching specialization is found, the
          //      instantiation is generated from that specialization.
          // We don't need to do anything for this.
        } else {
          //   -- If more than one matching specialization is found, the
          //      partial order rules (14.5.4.2) are used to determine
          //      whether one of the specializations is more specialized
          //      than the others. If none of the specializations is more
          //      specialized than all of the other matching
          //      specializations, then the use of the variable template is
          //      ambiguous and the program is ill-formed.
          for (type$ptr<SemaTemplateStatics.PartialSpecMatchResult> P = $tryClone(Best.$add(1)), 
              /*P*/ PEnd = $tryClone(Matched.end());
               $noteq_ptr(P, PEnd); P.$preInc()) {
            if ($this().getMoreSpecializedPartialSpecialization(P./*->*/$star().Partial, Best./*->*/$star().Partial, 
                new SourceLocation(PointOfInstantiation))
               == P./*->*/$star().Partial) {
              Best = $tryClone(P);
            }
          }
          
          // Determine if the best partial specialization is more specialized than
          // the others.
          for (type$ptr<SemaTemplateStatics.PartialSpecMatchResult> P = $tryClone(Matched.begin()), 
              /*P*/ PEnd = $tryClone(Matched.end());
               $noteq_ptr(P, PEnd); P.$preInc()) {
            if ($noteq_ptr(P, Best) && $this().getMoreSpecializedPartialSpecialization(P./*->*/$star().Partial, Best./*->*/$star().Partial, 
                new SourceLocation(PointOfInstantiation)) != Best./*->*/$star().Partial) {
              AmbiguousPartialSpec = true;
              break;
            }
          }
        }
        
        // Instantiate using the best variable template partial specialization.
        InstantiationPattern = Best./*->*/$star().Partial;
        InstantiationArgs = Best./*->*/$star().Args;
      } else {
        //   -- If no match is found, the instantiation is generated
        //      from the primary template.
        // InstantiationPattern = Template->getTemplatedDecl();
      }
    }
    
    // 2. Create the canonical declaration.
    // Note that we do not instantiate a definition until we see an odr-use
    // in DoMarkVarDeclReferenced().
    // FIXME: LateAttrs et al.?
    VarTemplateSpecializationDecl /*P*/ Decl = $this().BuildVarTemplateInstantiation(Template, InstantiationPattern, $Deref(InstantiationArgs), TemplateArgs, 
        _Converted, new SourceLocation(TemplateNameLoc), InsertPos/*, LateAttrs, StartingScope*/.$deref());
    if (!(Decl != null)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    if (AmbiguousPartialSpec) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Partial ordering did not produce a clear winner. Complain.
        Decl.setInvalidDecl();
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PointOfInstantiation), diag.err_partial_spec_ordering_ambiguous)), 
            Decl));
        
        // Print the matching partial specializations.
        for (type$ptr<SemaTemplateStatics.PartialSpecMatchResult> P = $tryClone(Matched.begin()), 
            /*P*/ PEnd = $tryClone(Matched.end());
             $noteq_ptr(P, PEnd); P.$preInc())  {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(P./*->*/$star().Partial.getLocation(), diag.note_partial_spec_match)), 
              $this().getTemplateArgumentBindingsText(P./*->*/$star().Partial.getTemplateParameters(), $Deref(P./*->*/$star().Args))));
        }
        return new ActionResult<Decl /*P*/ >(true);
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      VarTemplatePartialSpecializationDecl /*P*/ D = dyn_cast_VarTemplatePartialSpecializationDecl(InstantiationPattern);
      if ((D != null)) {
        Decl.setInstantiationOf(D, InstantiationArgs);
      }
    }
    
    $this().checkSpecializationVisibility(new SourceLocation(TemplateNameLoc), Decl);
    assert ((Decl != null)) : "No variable template specialization?";
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Decl);
  } finally {
    if (FailedCandidates != null) { FailedCandidates.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVarTemplateId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2912,
 FQN="clang::Sema::CheckVarTemplateId", NM="_ZN5clang4Sema18CheckVarTemplateIdERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEPNS_15VarTemplateDeclENS_14SourceLocationEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema18CheckVarTemplateIdERKNS_12CXXScopeSpecERKNS_19DeclarationNameInfoEPNS_15VarTemplateDeclENS_14SourceLocationEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckVarTemplateId(final /*const*/ CXXScopeSpec /*&*/ SS, 
                  final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                  VarTemplateDecl /*P*/ Template, SourceLocation TemplateLoc, 
                  /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  
  ActionResult<Decl /*P*/ > Decl = $this().CheckVarTemplateId(Template, new SourceLocation(TemplateLoc), NameInfo.getLoc(), 
      $Deref(TemplateArgs));
  if (Decl.isInvalid()) {
    return ExprError();
  }
  
  VarDecl /*P*/ Var = cast_VarDecl(Decl.get());
  if (!(Var.getTemplateSpecializationKind().getValue() != 0)) {
    Var.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ImplicitInstantiation, 
        NameInfo.getLoc());
  }
  
  // Build an ordinary singleton decl ref.
  return $this().BuildDeclarationNameExpr(SS, NameInfo, Var, 
      /*FoundD=*/ (NamedDecl /*P*/ )null, TemplateArgs);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildTemplateIdExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2933,
 FQN="clang::Sema::BuildTemplateIdExpr", NM="_ZN5clang4Sema19BuildTemplateIdExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEbPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema19BuildTemplateIdExprERKNS_12CXXScopeSpecENS_14SourceLocationERNS_12LookupResultEbPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildTemplateIdExpr(final /*const*/ CXXScopeSpec /*&*/ SS, 
                   SourceLocation TemplateKWLoc, 
                   final LookupResult /*&*/ R, 
                   boolean RequiresADL, 
                   /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  // FIXME: Can we do any checking at this point? I guess we could check the
  // template arguments that we have against the template name, if the template
  // name refers to a single template. That's not a terribly common case,
  // though.
  // foo<int> could identify a single function unambiguously
  // This approach does NOT work, since f<int>(1);
  // gets resolved prior to resorting to overload resolution
  // i.e., template<class T> void f(double);
  //       vs template<class T, class U> void f(U);
  
  // These should be filtered out by our callers.
  assert (!R.empty()) : "empty lookup results when building templateid";
  assert (!R.isAmbiguous()) : "ambiguous lookup when building templateid";
  
  // In C++1y, check variable template ids.
  bool$ref InstantiationDependent = create_bool$ref();
  if ((R.<VarTemplateDecl>getAsSingle(VarTemplateDecl.class) != null)
     && !TemplateSpecializationType.anyDependentTemplateArguments($Deref(TemplateArgs), InstantiationDependent)) {
    return $this().CheckVarTemplateId(SS, R.getLookupNameInfo(), 
        R.<VarTemplateDecl>getAsSingle(VarTemplateDecl.class), 
        new SourceLocation(TemplateKWLoc), TemplateArgs);
  }
  
  // We don't want lookup warnings at this point.
  R.suppressDiagnostics();
  
  UnresolvedLookupExpr /*P*/ ULE = UnresolvedLookupExpr.Create($this().Context, R.getNamingClass(), 
      SS.getWithLocInContext($this().Context), 
      new SourceLocation(TemplateKWLoc), 
      R.getLookupNameInfo(), 
      RequiresADL, TemplateArgs, 
      R.begin(), R.end());
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ULE);
}


// We actually only call this from template instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildQualifiedTemplateIdExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 2977,
 FQN="clang::Sema::BuildQualifiedTemplateIdExpr", NM="_ZN5clang4Sema28BuildQualifiedTemplateIdExprERNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema28BuildQualifiedTemplateIdExprERNS_12CXXScopeSpecENS_14SourceLocationERKNS_19DeclarationNameInfoEPKNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildQualifiedTemplateIdExpr(final CXXScopeSpec /*&*/ SS, 
                            SourceLocation TemplateKWLoc, 
                            final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                            /*const*/ TemplateArgumentListInfo /*P*/ TemplateArgs) {
  LookupResult R = null;
  try {
    assert ((TemplateArgs != null) || TemplateKWLoc.isValid());
    DeclContext /*P*/ DC;
    if (!((DC = $this().computeDeclContext(SS, false)) != null)
       || DC.isDependentContext()
       || $this().RequireCompleteDeclContext(SS, DC)) {
      return $this().BuildDependentDeclRefExpr(SS, new SourceLocation(TemplateKWLoc), NameInfo, TemplateArgs);
    }
    
    bool$ref MemberOfUnknownSpecialization = create_bool$ref();
    R/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName);
    $this().LookupTemplateName(R, (Scope /*P*/ )(Scope /*P*/ )null, SS, new QualType(), /*Entering*/ false, 
        MemberOfUnknownSpecialization);
    if (R.isAmbiguous()) {
      return ExprError();
    }
    if (R.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NameInfo.getLoc(), diag.err_template_kw_refers_to_non_template)), 
                NameInfo.getName()), SS.getRange()));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      ClassTemplateDecl /*P*/ Temp = R.<ClassTemplateDecl>getAsSingle(ClassTemplateDecl.class);
      if ((Temp != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(NameInfo.getLoc(), diag.err_template_kw_refers_to_class_template)), 
                      SS.getScopeRep()), 
                  NameInfo.getName().getAsString()), SS.getRange()));
          $c$.clean($c$.track($this().Diag(Temp.getLocation(), diag.note_referenced_class_template)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return $this().BuildTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), R, /*ADL*/ false, TemplateArgs);
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// \brief Form a dependent template name.
///
/// This action forms a dependent template name given the template
/// name and its (presumably dependent) scope specifier. For
/// example, given "MetaFun::template apply", the scope specifier \p
/// SS will be "MetaFun::", \p TemplateKWLoc contains the location
/// of the "template" keyword, and "apply" is the \p Name.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDependentTemplateName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3022,
 FQN="clang::Sema::ActOnDependentTemplateName", NM="_ZN5clang4Sema26ActOnDependentTemplateNameEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdENS_9OpaquePtrINS_8QualTypeEEEbRNS8_INS_12TemplateNameEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26ActOnDependentTemplateNameEPNS_5ScopeERNS_12CXXScopeSpecENS_14SourceLocationERNS_13UnqualifiedIdENS_9OpaquePtrINS_8QualTypeEEEbRNS8_INS_12TemplateNameEEE")
//</editor-fold>
public final TemplateNameKind ActOnDependentTemplateName(Scope /*P*/ S, 
                          final CXXScopeSpec /*&*/ SS, 
                          SourceLocation TemplateKWLoc, 
                          final UnqualifiedId /*&*/ Name, 
                          OpaquePtr<QualType> ObjectType, 
                          boolean EnteringContext, 
                          final OpaquePtr<TemplateName> /*&*/ Result) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (TemplateKWLoc.isValid() && (S != null) && !(S.getTemplateParamParent() != null)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateKWLoc), 
              $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_template_outside_of_template : diag.ext_template_outside_of_template)), 
          FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TemplateKWLoc))));
    }
    
    DeclContext /*P*/ LookupCtx = null;
    if (SS.isSet()) {
      LookupCtx = $this().computeDeclContext(SS, EnteringContext);
    }
    if (!(LookupCtx != null) && ObjectType.$bool()) {
      LookupCtx = $this().computeDeclContext(ObjectType.getQualType());
    }
    if ((LookupCtx != null)) {
      // C++0x [temp.names]p5:
      //   If a name prefixed by the keyword template is not the name of
      //   a template, the program is ill-formed. [Note: the keyword
      //   template may not be applied to non-template members of class
      //   templates. -end note ] [ Note: as is the case with the
      //   typename prefix, the template prefix is allowed in cases
      //   where it is not strictly necessary; i.e., when the
      //   nested-name-specifier or the expression on the left of the ->
      //   or . is not dependent on a template-parameter, or the use
      //   does not appear in the scope of a template. -end note]
      //
      // Note: C++03 was more strict here, because it banned the use of
      // the "template" keyword prior to a template-name that was not a
      // dependent name. C++ DR468 relaxed this requirement (the
      // "template" keyword is now permitted). We follow the C++0x
      // rules, even in C++03 mode with a warning, retroactively applying the DR.
      bool$ref MemberOfUnknownSpecialization = create_bool$ref();
      TemplateNameKind TNK = $this().isTemplateName(S, SS, TemplateKWLoc.isValid(), Name, 
          new OpaquePtr<QualType>(ObjectType), EnteringContext, Result, 
          MemberOfUnknownSpecialization);
      if (TNK == TemplateNameKind.TNK_Non_template && LookupCtx.isDependentContext()
         && isa_CXXRecordDecl(LookupCtx)
         && (!cast_CXXRecordDecl(LookupCtx).hasDefinition()
         || cast_CXXRecordDecl(LookupCtx).hasAnyDependentBases())) {
        // This is a dependent template. Handle it below.
      } else if (TNK == TemplateNameKind.TNK_Non_template) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Name.getLocStart(), 
                        diag.err_template_kw_refers_to_non_template)), 
                    $this().GetNameFromUnqualifiedId(Name).getName()), 
                Name.getSourceRange()), 
            TemplateKWLoc));
        return TemplateNameKind.TNK_Non_template;
      } else {
        // We found something; return it.
        return TNK;
      }
    }
    
    NestedNameSpecifier /*P*/ Qualifier = SS.getScopeRep();
    switch (Name.getKind()) {
     case IK_Identifier:
      Result.$assignMove(OpaquePtr.<TemplateName>make($this().Context.getDependentTemplateName(Qualifier, 
                  Name.Unnamed_field1.Identifier)));
      return TemplateNameKind.TNK_Dependent_template_name;
     case IK_OperatorFunctionId:
      Result.$assignMove(OpaquePtr.<TemplateName>make($this().Context.getDependentTemplateName(Qualifier, 
                  Name.Unnamed_field1.OperatorFunctionId.Operator)));
      return TemplateNameKind.TNK_Function_template;
     case IK_LiteralOperatorId:
      throw new llvm_unreachable("literal operator id cannot have a dependent scope");
     default:
      break;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Name.getLocStart(), 
                    diag.err_template_kw_refers_to_non_template)), 
                $this().GetNameFromUnqualifiedId(Name).getName()), 
            Name.getSourceRange()), 
        TemplateKWLoc));
    return TemplateNameKind.TNK_Non_template;
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnClassTemplateSpecialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6177,
 FQN="clang::Sema::ActOnClassTemplateSpecialization", NM="_ZN5clang4Sema32ActOnClassTemplateSpecializationEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationES4_RNS_20TemplateIdAnnotationEPNS_13AttributeListEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS0_12SkipBodyInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema32ActOnClassTemplateSpecializationEPNS_5ScopeEjNS0_10TagUseKindENS_14SourceLocationES4_RNS_20TemplateIdAnnotationEPNS_13AttributeListEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEEPNS0_12SkipBodyInfoE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnClassTemplateSpecialization(Scope /*P*/ S, /*uint*/int TagSpec, 
                                TagUseKind TUK, 
                                SourceLocation KWLoc, 
                                SourceLocation ModulePrivateLoc, 
                                final TemplateIdAnnotation /*&*/ TemplateId, 
                                AttributeList /*P*/ Attr, 
                                MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists) {
  return ActOnClassTemplateSpecialization(S, TagSpec, 
                                TUK, 
                                KWLoc, 
                                ModulePrivateLoc, 
                                TemplateId, 
                                Attr, 
                                TemplateParameterLists, 
                                (SkipBodyInfo /*P*/ )null);
}
public final ActionResult<Decl /*P*/ > ActOnClassTemplateSpecialization(Scope /*P*/ S, /*uint*/int TagSpec, 
                                TagUseKind TUK, 
                                SourceLocation KWLoc, 
                                SourceLocation ModulePrivateLoc, 
                                final TemplateIdAnnotation /*&*/ TemplateId, 
                                AttributeList /*P*/ Attr, 
                                MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists, 
                                SkipBodyInfo /*P*/ SkipBody/*= null*/) {
  TemplateArgumentListInfo TemplateArgs = null;
  try {
    assert (TUK != TagUseKind.TUK_Reference) : "References are not specializations";
    
    final CXXScopeSpec /*&*/ SS = TemplateId.SS;
    
    // NOTE: KWLoc is the location of the tag keyword. This will instead
    // store the location of the outermost template keyword in the declaration.
    SourceLocation TemplateKWLoc = $greater_uint(TemplateParameterLists.size(), 0) ? TemplateParameterLists.$at(0).getTemplateLoc() : new SourceLocation(KWLoc);
    SourceLocation TemplateNameLoc = new SourceLocation(TemplateId.TemplateNameLoc);
    SourceLocation LAngleLoc = new SourceLocation(TemplateId.LAngleLoc);
    SourceLocation RAngleLoc = new SourceLocation(TemplateId.RAngleLoc);
    
    // Find the class template we're specializing
    TemplateName Name = TemplateId.Template.getTemplateName();
    ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_or_null_ClassTemplateDecl(Name.getAsTemplateDecl());
    if (!(ClassTemplate != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_not_class_template_specialization)), 
            ((Name.getAsTemplateDecl() != null)
               && isa_TemplateTemplateParmDecl(Name.getAsTemplateDecl()))));
        return new ActionResult<Decl /*P*/ >(true);
      } finally {
        $c$.$destroy();
      }
    }
    
    bool$ref isExplicitSpecialization = create_bool$ref(false);
    boolean isPartialSpecialization = false;
    
    // Check the validity of the template headers that introduce this
    // template.
    // FIXME: We probably shouldn't complain about these headers for
    // friend declarations.
    bool$ref Invalid = create_bool$ref(false);
    TemplateParameterList /*P*/ TemplateParams = $this().MatchTemplateParametersToScopeSpecifier(new SourceLocation(KWLoc), new SourceLocation(TemplateNameLoc), SS, $AddrOf(TemplateId), 
        new ArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists), TUK == TagUseKind.TUK_Friend, isExplicitSpecialization, 
        Invalid);
    if (Invalid.$deref()) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    if ((TemplateParams != null) && $greater_uint(TemplateParams.size(), 0)) {
      isPartialSpecialization = true;
      if (TUK == TagUseKind.TUK_Friend) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_partial_specialization_friend)), 
              new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc)));
          return new ActionResult<Decl /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
      
      // C++ [temp.class.spec]p10:
      //   The template parameter list of a specialization shall not
      //   contain default template argument values.
      for (/*uint*/int I = 0, N = TemplateParams.size(); I != N; ++I) {
        Decl /*P*/ Param = TemplateParams.getParam(I);
        {
          TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Param);
          if ((TTP != null)) {
            if (TTP.hasDefaultArgument()) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean($c$.track($this().Diag(TTP.getDefaultArgumentLoc(), 
                    diag.err_default_arg_in_partial_spec)));
                TTP.removeDefaultArgument();
              } finally {
                $c$.$destroy();
              }
            }
          } else {
            NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
            if ((NTTP != null)) {
              {
                Expr /*P*/ DefArg = NTTP.getDefaultArgument();
                if ((DefArg != null)) {
                  JavaCleaner $c$ = $createJavaCleaner();
                  try {
                    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NTTP.getDefaultArgumentLoc(), 
                            diag.err_default_arg_in_partial_spec)), 
                        DefArg.getSourceRange()));
                    NTTP.removeDefaultArgument();
                  } finally {
                    $c$.$destroy();
                  }
                }
              }
            } else {
              TemplateTemplateParmDecl /*P*/ TTP$1 = cast_TemplateTemplateParmDecl(Param);
              if (TTP$1.hasDefaultArgument()) {
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TTP$1.getDefaultArgument().getLocation(), 
                          diag.err_default_arg_in_partial_spec)), 
                      TTP$1.getDefaultArgument().getSourceRange()));
                  TTP$1.removeDefaultArgument();
                } finally {
                  $c$.$destroy();
                }
              }
            }
          }
        }
      }
    } else if ((TemplateParams != null)) {
      if (TUK == TagUseKind.TUK_Friend) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_template_spec_friend)), 
                  FixItHint.CreateRemoval(new SourceRange(TemplateParams.getTemplateLoc(), 
                          TemplateParams.getRAngleLoc()))), 
              new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc)));
        } finally {
          $c$.$destroy();
        }
      } else {
        isExplicitSpecialization.$set(true);
      }
    } else {
      assert (TUK == TagUseKind.TUK_Friend) : "should have a 'template<>' for this decl";
    }
    
    // Check that the specialization uses the same tag kind as the
    // original template.
    TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec);
    assert (Kind != TagTypeKind.TTK_Enum) : "Invalid enum tag in class template spec!";
    if (!$this().isAcceptableTagRedeclaration(ClassTemplate.getTemplatedDecl(), 
        Kind, TUK == TagUseKind.TUK_Definition, new SourceLocation(KWLoc), 
        ClassTemplate.getIdentifier())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_use_with_wrong_tag)), 
                ClassTemplate), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/KWLoc), 
                ClassTemplate.getTemplatedDecl().getKindName())));
        $c$.clean($c$.track($this().Diag(ClassTemplate.getTemplatedDecl().getLocation(), 
            diag.note_previous_use)));
        Kind = ClassTemplate.getTemplatedDecl().getTagKind();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Translate the parser's template argument list in our AST format.
    TemplateArgs = makeTemplateArgumentListInfo(/*Deref*/$this(), TemplateId);
    
    // Check for unexpanded parameter packs in any of the template arguments.
    for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
      if ($this().DiagnoseUnexpandedParameterPack(new TemplateArgumentLoc(TemplateArgs.$at(I)), 
          UnexpandedParameterPackContext.UPPC_PartialSpecialization)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
    }
    
    // Check that the template argument list is well-formed for this
    // template.
    SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    if ($this().CheckTemplateArgumentList(ClassTemplate, new SourceLocation(TemplateNameLoc), 
        TemplateArgs, false, _Converted)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // Find the class template (partial) specialization declaration that
    // corresponds to these arguments.
    if (isPartialSpecialization) {
      if (CheckTemplatePartialSpecializationArgs(/*Deref*/$this(), new SourceLocation(TemplateNameLoc), ClassTemplate.getTemplateParameters(), 
          TemplateArgs.size(), _Converted)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      bool$ref InstantiationDependent = create_bool$ref();
      if (!Name.isDependent()
         && !TemplateSpecializationType.anyDependentTemplateArguments(TemplateArgs.arguments(), InstantiationDependent)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_partial_spec_fully_specialized)), 
              ClassTemplate.getDeclName()));
          isPartialSpecialization = false;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    final type$ref<type$ptr<ClassTemplateSpecializationDecl/*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    ClassTemplateSpecializationDecl /*P*/ PrevDecl = null;
    if (isPartialSpecialization) {
      // FIXME: Template parameter list matters, too
      PrevDecl = ClassTemplate.findPartialSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), (type$ref<type$ptr<ClassTemplatePartialSpecializationDecl/*P*/>/*void P*/ >)(type$ref)InsertPos);
    } else {
      PrevDecl = ClassTemplate.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
    }
    
    ClassTemplateSpecializationDecl /*P*/ Specialization = null;
    
    // Check whether we can declare a class template specialization in
    // the current scope.
    if (TUK != TagUseKind.TUK_Friend
       && CheckTemplateSpecializationScope(/*Deref*/$this(), ClassTemplate, PrevDecl, 
        new SourceLocation(TemplateNameLoc), 
        isPartialSpecialization)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // The canonical type
    QualType CanonType/*J*/= new QualType();
    if (isPartialSpecialization) {
      // Build the canonical type that describes the converted template
      // arguments of the class template partial specialization.
      TemplateName CanonTemplate = $this().Context.getCanonicalTemplateName(new TemplateName(Name));
      CanonType.$assignMove($this().Context.getTemplateSpecializationType(new TemplateName(CanonTemplate), 
              new ArrayRef<TemplateArgument>(_Converted, false)));
      if ($this().Context.hasSameType(new QualType(CanonType), 
          ClassTemplate.getInjectedClassNameSpecialization())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ [temp.class.spec]p9b3:
          //
          //   -- The argument list of the specialization shall not be identical
          //      to the implicit argument list of the primary template.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_partial_spec_args_match_primary_template)), 
                      /*class template*/ 0), (TUK == TagUseKind.TUK_Definition)), 
              FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/LAngleLoc, /*NO_COPY*/RAngleLoc))));
          return $this().CheckClassTemplate(S, TagSpec, TUK, new SourceLocation(KWLoc), SS, 
              ClassTemplate.getIdentifier(), 
              new SourceLocation(TemplateNameLoc), 
              Attr, 
              TemplateParams, 
              AccessSpecifier.AS_none, /*ModulePrivateLoc=*/ new SourceLocation(), 
              /*FriendLoc*/ new SourceLocation(), 
              TemplateParameterLists.size() - 1, 
              TemplateParameterLists.data());
        } finally {
          $c$.$destroy();
        }
      }

      // Create a new class template partial specialization declaration node.
      ClassTemplatePartialSpecializationDecl /*P*/ PrevPartial = cast_or_null_ClassTemplatePartialSpecializationDecl(PrevDecl);
      ClassTemplatePartialSpecializationDecl /*P*/ Partial = ClassTemplatePartialSpecializationDecl.Create($this().Context, Kind, 
          ClassTemplate.getDeclContext(), 
          new SourceLocation(KWLoc), new SourceLocation(TemplateNameLoc), 
          TemplateParams, 
          ClassTemplate, 
          new ArrayRef<TemplateArgument>(_Converted, false), 
          TemplateArgs, 
          new QualType(CanonType), 
          PrevPartial);
      SetNestedNameSpecifier(Partial, SS);
      if ($greater_uint(TemplateParameterLists.size(), 1) && SS.isSet()) {
        Partial.setTemplateParameterListsInfo($this().Context, new ArrayRef<TemplateParameterList /*P*/ >(JD$Move.INSTANCE, TemplateParameterLists.drop_back(1)));
      }
      if (!(PrevPartial != null)) {
        ClassTemplate.AddPartialSpecialization(Partial, (type$ptr<ClassTemplatePartialSpecializationDecl/*P*/>)(type$ptr)InsertPos.$deref());
      }
      Specialization = Partial;

      // If we are providing an explicit specialization of a member class
      // template specialization, make a note of that.
      if ((PrevPartial != null) && (PrevPartial.getInstantiatedFromMember() != null)) {
        PrevPartial.setMemberSpecialization();
      }

      // Check that all of the template parameters of the class template
      // partial specialization are deducible from the template
      // arguments. If not, this class template partial specialization
      // will never be used.
      SmallBitVector DeducibleParams/*J*/= new SmallBitVector(TemplateParams.size());
      $this().MarkUsedTemplateParameters(Partial.getTemplateArgs(), true, 
          TemplateParams.getDepth(), 
          DeducibleParams);
      if (!DeducibleParams.all()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          /*uint*/int NumNonDeducible = DeducibleParams.size() - DeducibleParams.count();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.warn_partial_specs_not_deducible)), 
                      /*class template*/ 0), ($greater_uint(NumNonDeducible, 1))), 
              new SourceRange(/*NO_COPY*/TemplateNameLoc, /*NO_COPY*/RAngleLoc)));
          for (/*uint*/int I = 0, N = DeducibleParams.size(); I != N; ++I) {
            if (!DeducibleParams.$at$Const(I)/*.$bool()*/) {
              NamedDecl /*P*/ Param = cast_NamedDecl(TemplateParams.getParam(I));
              if (Param.getDeclName().$bool()) {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), 
                        diag.note_partial_spec_unused_parameter)), 
                    Param.getDeclName()));
              } else {
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Param.getLocation(), 
                        diag.note_partial_spec_unused_parameter)), 
                    /*KEEP_STR*/"(anonymous)"));
              }
            }
          }
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      // Create a new class template specialization declaration node for
      // this explicit specialization or friend declaration.
      Specialization
         = ClassTemplateSpecializationDecl.Create($this().Context, Kind, 
          ClassTemplate.getDeclContext(), 
          new SourceLocation(KWLoc), new SourceLocation(TemplateNameLoc), 
          ClassTemplate, 
          new ArrayRef<TemplateArgument>(_Converted, false), 
          PrevDecl);
      SetNestedNameSpecifier(Specialization, SS);
      if ($greater_uint(TemplateParameterLists.size(), 0)) {
        Specialization.setTemplateParameterListsInfo($this().Context, 
            new ArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists));
      }
      if (!(PrevDecl != null)) {
        ClassTemplate.AddSpecialization(Specialization, InsertPos.$deref());
      }
      if ($this().CurContext.isDependentContext()) {
        // -fms-extensions permits specialization of nested classes without
        // fully specializing the outer class(es).
        assert ($this().getLangOpts().MicrosoftExt) : "Only possible with -fms-extensions!";
        TemplateName CanonTemplate = $this().Context.getCanonicalTemplateName(new TemplateName(Name));
        CanonType.$assignMove($this().Context.getTemplateSpecializationType(new TemplateName(CanonTemplate), new ArrayRef<TemplateArgument>(_Converted, false)));
      } else {
        CanonType.$assignMove($this().Context.getTypeDeclType(Specialization));
      }
    }
    
    // C++ [temp.expl.spec]p6:
    //   If a template, a member template or the member of a class template is
    //   explicitly specialized then that specialization shall be declared
    //   before the first use of that specialization that would cause an implicit
    //   instantiation to take place, in every translation unit in which such a
    //   use occurs; no diagnostic is required.
    if ((PrevDecl != null) && PrevDecl.getPointOfInstantiation().isValid()) {
      boolean Okay = false;
      for (Decl /*P*/ Prev = PrevDecl; (Prev != null); Prev = Prev.getPreviousDecl()) {
        // Is there any previous explicit specialization declaration?
        if (getTemplateSpecializationKind(Prev) == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
          Okay = true;
          break;
        }
      }
      if (!Okay) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/TemplateNameLoc, /*NO_COPY*/RAngleLoc);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_specialization_after_instantiation)), 
                  $this().Context.getTypeDeclType(Specialization)), Range));
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevDecl.getPointOfInstantiation(), 
                  diag.note_instantiation_required_here)), 
              (PrevDecl.getTemplateSpecializationKind()
                 != TemplateSpecializationKind.TSK_ImplicitInstantiation)));
          return new ActionResult<Decl /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // If this is not a friend, note that this is an explicit specialization.
    if (TUK != TagUseKind.TUK_Friend) {
      Specialization.setSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
    }
    
    // Check that this isn't a redefinition of this specialization.
    if (TUK == TagUseKind.TUK_Definition) {
      RecordDecl /*P*/ Def = Specialization.getDefinition();
      type$ptr<NamedDecl /*P*/ > Hidden = create_type$null$ptr(null);
      if ((Def != null) && (SkipBody != null) && !$this().hasVisibleDefinition(Def, $AddrOf(Hidden))) {
        SkipBody.ShouldSkip = true;
        $this().makeMergedDefinitionVisible(Hidden.$star(), new SourceLocation(KWLoc));
        // From here on out, treat this as just a redeclaration.
        TUK = TagUseKind.TUK_Declaration;
      } else if ((Def != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          SourceRange Range/*J*/= new SourceRange(/*NO_COPY*/TemplateNameLoc, /*NO_COPY*/RAngleLoc);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_redefinition)), 
                  $this().Context.getTypeDeclType(Specialization)), Range));
          $c$.clean($c$.track($this().Diag(Def.getLocation(), diag.note_previous_definition)));
          Specialization.setInvalidDecl();
          return new ActionResult<Decl /*P*/ >(true);
        } finally {
          $c$.$destroy();
        }
      }
    }
    if ((Attr != null)) {
      $this().ProcessDeclAttributeList(S, Specialization, Attr);
    }
    
    // Add alignment attributes if necessary; these attributes are checked when
    // the ASTContext lays out the structure.
    if (TUK == TagUseKind.TUK_Definition) {
      $this().AddAlignmentAttributesForRecord(Specialization);
      $this().AddMsStructLayoutForRecord(Specialization);
    }
    if (ModulePrivateLoc.isValid()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Specialization.getLocation(), diag.err_module_private_specialization)), 
                (isPartialSpecialization ? 1 : 0)), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/ModulePrivateLoc))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Build the fully-sugared type for this class template
    // specialization as the user wrote in the specialization
    // itself. This means that we'll pretty-print the type retrieved
    // from the specialization's declaration the way that the user
    // actually wrote the specialization, rather than formatting the
    // name based on the "canonical" representation used to store the
    // template arguments in the specialization.
    TypeSourceInfo /*P*/ WrittenTy = $this().Context.getTemplateSpecializationTypeInfo(new TemplateName(Name), new SourceLocation(TemplateNameLoc), 
        TemplateArgs, new QualType(CanonType));
    if (TUK != TagUseKind.TUK_Friend) {
      Specialization.setTypeAsWritten(WrittenTy);
      Specialization.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
    }
    
    // C++ [temp.expl.spec]p9:
    //   A template explicit specialization is in the scope of the
    //   namespace in which the template was defined.
    //
    // We actually implement this paragraph where we set the semantic
    // context (in the creation of the ClassTemplateSpecializationDecl),
    // but we also maintain the lexical context where the actual
    // definition occurs.
    Specialization.setLexicalDeclContext($this().CurContext);
    
    // We may be starting the definition of this specialization.
    if (TUK == TagUseKind.TUK_Definition) {
      Specialization.startDefinition();
    }
    if (TUK == TagUseKind.TUK_Friend) {
      FriendDecl /*P*/ Friend = FriendDecl.Create($this().Context, $this().CurContext, 
          new SourceLocation(TemplateNameLoc), 
          new PointerUnion<NamedDecl /*P*/ , TypeSourceInfo /*P*/ >(JD$T1.INSTANCE, TypeSourceInfo /*P*/ .class, WrittenTy), 
          /*FIXME:*/ new SourceLocation(KWLoc));
      Friend.setAccess(AccessSpecifier.AS_public);
      $this().CurContext.addDecl(Friend);
    } else {
      // Add the specialization into its lexical context, so that it can
      // be seen when iterating through the list of declarations in that
      // context. However, specializations are not found by name lookup.
      $this().CurContext.addDecl(Specialization);
    }
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Specialization);
  } finally {
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTemplateDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6577,
 FQN="clang::Sema::ActOnTemplateDeclarator", NM="_ZN5clang4Sema23ActOnTemplateDeclaratorEPNS_5ScopeEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema23ActOnTemplateDeclaratorEPNS_5ScopeEN4llvm15MutableArrayRefIPNS_21TemplateParameterListEEERNS_10DeclaratorE")
//</editor-fold>
public final Decl /*P*/ ActOnTemplateDeclarator(Scope /*P*/ S, 
                       MutableArrayRef<TemplateParameterList /*P*/ > TemplateParameterLists, 
                       final Declarator /*&*/ D) {
  Decl /*P*/ NewDecl = $this().HandleDeclarator(S, D, new MutableArrayRef<TemplateParameterList /*P*/ >(TemplateParameterLists));
  $this().ActOnDocumentableDecl(NewDecl);
  return NewDecl;
}


/// \brief Diagnose cases where we have an explicit template specialization
/// before/after an explicit template instantiation, producing diagnostics
/// for those cases where they are required and determining whether the
/// new specialization/instantiation will have any effect.
///
/// \param NewLoc the location of the new explicit specialization or
/// instantiation.
///
/// \param NewTSK the kind of the new explicit specialization or instantiation.
///
/// \param PrevDecl the previous declaration of the entity.
///
/// \param PrevTSK the kind of the old explicit specialization or instantiatin.
///
/// \param PrevPointOfInstantiation if valid, indicates where the previus
/// declaration was instantiated (either implicitly or explicitly).
///
/// \param HasNoEffect will be set to true to indicate that the new
/// specialization or instantiation has no effect and should be ignored.
///
/// \returns true if there was an error that should prevent the introduction of
/// the new declaration into the AST, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckSpecializationInstantiationRedecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6634,
 FQN="clang::Sema::CheckSpecializationInstantiationRedecl", NM="_ZN5clang4Sema38CheckSpecializationInstantiationRedeclENS_14SourceLocationENS_26TemplateSpecializationKindEPNS_9NamedDeclES2_S1_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema38CheckSpecializationInstantiationRedeclENS_14SourceLocationENS_26TemplateSpecializationKindEPNS_9NamedDeclES2_S1_Rb")
//</editor-fold>
public final boolean CheckSpecializationInstantiationRedecl(SourceLocation NewLoc, 
                                      TemplateSpecializationKind NewTSK, 
                                      NamedDecl /*P*/ PrevDecl, 
                                      TemplateSpecializationKind PrevTSK, 
                                      SourceLocation PrevPointOfInstantiation, 
                                      final bool$ref/*bool &*/ HasNoEffect) {
  HasNoEffect.$set(false);
  switch (NewTSK) {
   case TSK_Undeclared:
   case TSK_ImplicitInstantiation:
    assert ((PrevTSK == TemplateSpecializationKind.TSK_Undeclared || PrevTSK == TemplateSpecializationKind.TSK_ImplicitInstantiation)) : "previous declaration must be implicit!";
    return false;
   case TSK_ExplicitSpecialization:
    switch (PrevTSK) {
     case TSK_Undeclared:
     case TSK_ExplicitSpecialization:
      // Okay, we're just specializing something that is either already
      // explicitly specialized or has merely been mentioned without any
      // instantiation.
      return false;
     case TSK_ImplicitInstantiation:
      if (PrevPointOfInstantiation.isInvalid()) {
        // The declaration itself has not actually been instantiated, so it is
        // still okay to specialize it.
        StripImplicitInstantiation(PrevDecl);
        return false;
      }
     case TSK_ExplicitInstantiationDeclaration:
     case TSK_ExplicitInstantiationDefinition:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Fall through
          assert ((PrevTSK == TemplateSpecializationKind.TSK_ImplicitInstantiation || PrevPointOfInstantiation.isValid())) : "Explicit instantiation without point of instantiation?";
          
          // C++ [temp.expl.spec]p6:
          //   If a template, a member template or the member of a class template
          //   is explicitly specialized then that specialization shall be declared
          //   before the first use of that specialization that would cause an
          //   implicit instantiation to take place, in every translation unit in
          //   which such a use occurs; no diagnostic is required.
          for (Decl /*P*/ Prev = PrevDecl; (Prev != null); Prev = Prev.getPreviousDecl()) {
            // Is there any previous explicit specialization declaration?
            if (getTemplateSpecializationKind(Prev) == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
              return false;
            }
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewLoc), diag.err_specialization_after_instantiation)), 
              PrevDecl));
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(PrevPointOfInstantiation), diag.note_instantiation_required_here)), 
              (PrevTSK != TemplateSpecializationKind.TSK_ImplicitInstantiation)));
          
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
   case TSK_ExplicitInstantiationDeclaration:
    switch (PrevTSK) {
     case TSK_ExplicitInstantiationDeclaration:
      // This explicit instantiation declaration is redundant (that's okay).
      HasNoEffect.$set(true);
      return false;
     case TSK_Undeclared:
     case TSK_ImplicitInstantiation:
      // We're explicitly instantiating something that may have already been
      // implicitly instantiated; that's fine.
      return false;
     case TSK_ExplicitSpecialization:
      // C++0x [temp.explicit]p4:
      //   For a given set of template parameters, if an explicit instantiation
      //   of a template appears after a declaration of an explicit
      //   specialization for that template, the explicit instantiation has no
      //   effect.
      HasNoEffect.$set(true);
      return false;
     case TSK_ExplicitInstantiationDefinition:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++0x [temp.explicit]p10:
          //   If an entity is the subject of both an explicit instantiation
          //   declaration and an explicit instantiation definition in the same
          //   translation unit, the definition shall follow the declaration.
          $c$.clean($c$.track($this().Diag(new SourceLocation(NewLoc), 
              diag.err_explicit_instantiation_declaration_after_definition)));
          
          // Explicit instantiations following a specialization have no effect and
          // hence no PrevPointOfInstantiation. In that case, walk decl backwards
          // until a valid name loc is found.
          $c$.clean($c$.track($this().Diag(DiagLocForExplicitInstantiation(PrevDecl, new SourceLocation(PrevPointOfInstantiation)), 
              diag.note_explicit_instantiation_definition_here)));
          HasNoEffect.$set(true);
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
   case TSK_ExplicitInstantiationDefinition:
    switch (PrevTSK) {
     case TSK_Undeclared:
     case TSK_ImplicitInstantiation:
      // We're explicitly instantiating something that may have already been
      // implicitly instantiated; that's fine.
      return false;
     case TSK_ExplicitSpecialization:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++ DR 259, C++0x [temp.explicit]p4:
          //   For a given set of template parameters, if an explicit
          //   instantiation of a template appears after a declaration of
          //   an explicit specialization for that template, the explicit
          //   instantiation has no effect.
          //
          // In C++98/03 mode, we only give an extension warning here, because it
          // is not harmful to try to explicitly instantiate something that
          // has been explicitly specialized.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewLoc), $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_explicit_instantiation_after_specialization : diag.ext_explicit_instantiation_after_specialization)), 
              PrevDecl));
          $c$.clean($c$.track($this().Diag(PrevDecl.getLocation(), 
              diag.note_previous_template_specialization)));
          HasNoEffect.$set(true);
          return false;
        } finally {
          $c$.$destroy();
        }
      }
     case TSK_ExplicitInstantiationDeclaration:
      // We're explicity instantiating a definition for something for which we
      // were previously asked to suppress instantiations. That's fine.
      
      // C++0x [temp.explicit]p4:
      //   For a given set of template parameters, if an explicit instantiation
      //   of a template appears after a declaration of an explicit
      //   specialization for that template, the explicit instantiation has no
      //   effect.
      for (Decl /*P*/ Prev = PrevDecl; (Prev != null); Prev = Prev.getPreviousDecl()) {
        // Is there any previous explicit specialization declaration?
        if (getTemplateSpecializationKind(Prev) == TemplateSpecializationKind.TSK_ExplicitSpecialization) {
          HasNoEffect.$set(true);
          break;
        }
      }
      
      return false;
     case TSK_ExplicitInstantiationDefinition:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++0x [temp.spec]p5:
          //   For a given template and a given set of template-arguments,
          //     - an explicit instantiation definition shall appear at most once
          //       in a program,
          
          // MSVCCompat: MSVC silently ignores duplicate explicit instantiations.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(NewLoc), ($this().getLangOpts().MSVCCompat) ? diag.ext_explicit_instantiation_duplicate : diag.err_explicit_instantiation_duplicate)), 
              PrevDecl));
          $c$.clean($c$.track($this().Diag(DiagLocForExplicitInstantiation(PrevDecl, new SourceLocation(PrevPointOfInstantiation)), 
              diag.note_previous_explicit_instantiation)));
          HasNoEffect.$set(true);
          return false;
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  throw new llvm_unreachable("Missing specialization/instantiation case?");
}


/// \brief Perform semantic analysis for the given dependent function
/// template specialization.
///
/// The only possible way to get a dependent function template specialization
/// is with a friend declaration, like so:
///
/// \code
///   template \<class T> void foo(T);
///   template \<class T> class A {
///     friend void foo<>(T);
///   };
/// \endcode
///
/// There really isn't any useful analysis we can do here, so we
/// just store the information.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckDependentFunctionTemplateSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6816,
 FQN="clang::Sema::CheckDependentFunctionTemplateSpecialization", NM="_ZN5clang4Sema44CheckDependentFunctionTemplateSpecializationEPNS_12FunctionDeclERKNS_24TemplateArgumentListInfoERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema44CheckDependentFunctionTemplateSpecializationEPNS_12FunctionDeclERKNS_24TemplateArgumentListInfoERNS_12LookupResultE")
//</editor-fold>
public final boolean CheckDependentFunctionTemplateSpecialization(FunctionDecl /*P*/ FD, 
                                            final /*const*/ TemplateArgumentListInfo /*&*/ ExplicitTemplateArgs, 
                                            final LookupResult /*&*/ Previous) {
  LookupResult.Filter F = null;
  try {
    // Remove anything from Previous that isn't a function template in
    // the correct context.
    DeclContext /*P*/ FDLookupContext = FD.getDeclContext().getRedeclContext();
    F = Previous.makeFilter();
    while (F.hasNext()) {
      NamedDecl /*P*/ D = F.next().getUnderlyingDecl();
      if (!isa_FunctionTemplateDecl(D)
         || !FDLookupContext.InEnclosingNamespaceSetOf(D.getDeclContext().getRedeclContext())) {
        F.erase();
      }
    }
    F.done();
    
    // Should this be diagnosed here?
    if (Previous.empty()) {
      return true;
    }
    
    FD.setDependentTemplateSpecialization($this().Context, Previous.asUnresolvedSet(), 
        ExplicitTemplateArgs);
    return false;
  } finally {
    if (F != null) { F.$destroy(); }
  }
}


/// \brief Perform semantic analysis for the given function template
/// specialization.
///
/// This routine performs all of the semantic analysis required for an
/// explicit function template specialization. On successful completion,
/// the function declaration \p FD will become a function template
/// specialization.
///
/// \param FD the function declaration, which will be updated to become a
/// function template specialization.
///
/// \param ExplicitTemplateArgs the explicitly-provided template arguments,
/// if any. Note that this may be valid info even when 0 arguments are
/// explicitly provided as in, e.g., \c void sort<>(char*, char*);
/// as it anyway contains info on the angle brackets locations.
///
/// \param Previous the set of declarations that may be specialized by
/// this function specialization.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckFunctionTemplateSpecialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 6859,
 FQN="clang::Sema::CheckFunctionTemplateSpecialization", NM="_ZN5clang4Sema35CheckFunctionTemplateSpecializationEPNS_12FunctionDeclEPNS_24TemplateArgumentListInfoERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema35CheckFunctionTemplateSpecializationEPNS_12FunctionDeclEPNS_24TemplateArgumentListInfoERNS_12LookupResultE")
//</editor-fold>
public final boolean CheckFunctionTemplateSpecialization(FunctionDecl /*P*/ FD, TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                                   final LookupResult /*&*/ Previous) {
  TemplateSpecCandidateSet FailedCandidates = null;
  SmallDenseMap<FunctionDecl /*P*/ , TemplateArgumentListInfo> ConvertedTemplateArgs = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // The set of function template specializations that could match this
    // explicit function template specialization.
    UnresolvedSet Candidates/*J*/= new UnresolvedSet(8);
    FailedCandidates/*J*/= new TemplateSpecCandidateSet(FD.getLocation(), 
        /*ForTakingAddress=*/ false);
    
    ConvertedTemplateArgs/*J*/= new SmallDenseMap<FunctionDecl /*P*/ , TemplateArgumentListInfo>(DenseMapInfo$LikePtr.$Info(), 8, new TemplateArgumentListInfo());
    
    DeclContext /*P*/ FDLookupContext = FD.getDeclContext().getRedeclContext();
    for (UnresolvedSetIterator I = Previous.begin(), E = Previous.end();
         I.$noteq(E); I.$preInc()) {
      NamedDecl /*P*/ Ovl = (I.$star()).getUnderlyingDecl();
      {
        FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(Ovl);
        if ((FunTmpl != null)) {
          TemplateArgumentListInfo Args = null;
          TemplateDeductionInfo Info = null;
          try {
            // Only consider templates found within the same semantic lookup scope as
            // FD.
            if (!FDLookupContext.InEnclosingNamespaceSetOf(Ovl.getDeclContext().getRedeclContext())) {
              continue;
            }
            
            // When matching a constexpr member function template specialization
            // against the primary template, we don't yet know whether the
            // specialization has an implicit 'const' (because we don't know whether
            // it will be a static member function until we know which template it
            // specializes), so adjust it now assuming it specializes this template.
            QualType FT = FD.getType();
            if (FD.isConstexpr()) {
              CXXMethodDecl /*P*/ OldMD = dyn_cast_CXXMethodDecl(FunTmpl.getTemplatedDecl());
              if ((OldMD != null) && OldMD.isConst()) {
                /*const*/ FunctionProtoType /*P*/ FPT = FT.$arrow().castAs(FunctionProtoType.class);
                FunctionProtoType.ExtProtoInfo EPI = FPT.getExtProtoInfo();
                EPI.TypeQuals |= Qualifiers.TQ.Const;
                FT.$assignMove($this().Context.getFunctionType(FPT.getReturnType(), 
                        FPT.getParamTypes(), EPI));
              }
            }
            
            Args/*J*/= new TemplateArgumentListInfo();
            if ((ExplicitTemplateArgs != null)) {
              Args.$assign($Deref(ExplicitTemplateArgs));
            }
            
            // C++ [temp.expl.spec]p11:
            //   A trailing template-argument can be left unspecified in the
            //   template-id naming an explicit function template specialization
            //   provided it can be deduced from the function argument type.
            // Perform template argument deduction to determine whether we may be
            // specializing this template.
            // FIXME: It is somewhat wasteful to build
            Info/*J*/= new TemplateDeductionInfo(FailedCandidates.getLocation());
            type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
            {
              TemplateDeductionResult TDK = $this().DeduceTemplateArguments3(cast_FunctionTemplateDecl(FunTmpl.getFirstDecl()), 
                  (ExplicitTemplateArgs != null) ? $AddrOf(Args) : (TemplateArgumentListInfo /*P*/ )null, new QualType(FT), Specialization, 
                  Info);
              if ((TDK.getValue() != 0)) {
                // Template argument deduction failed; record why it failed, so
                // that we can provide nifty diagnostics.
                FailedCandidates.addCandidate().set(new DeclAccessPair(I.getPair()), FunTmpl.getTemplatedDecl(), 
                    MakeDeductionFailureInfo($this().Context, TDK, Info));
                ///*J:(void)*/TDK;
                continue;
              }
            }
            
            // Record this candidate.
            if ((ExplicitTemplateArgs != null)) {
              ConvertedTemplateArgs.$at_T1$C$R(Specialization.$deref()).$assignMove(std.move(Args));
            }
            Candidates.addDecl(Specialization.$deref(), I.getAccess());
          } finally {
            if (Info != null) { Info.$destroy(); }
            if (Args != null) { Args.$destroy(); }
          }
        }
      }
    }
    
    // Find the most specialized function template.
    UnresolvedSetIterator Result = $c$.clean($this().getMostSpecialized(Candidates.begin(), Candidates.end(), FailedCandidates, 
        FD.getLocation(), 
        $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_function_template_spec_no_match)), FD.getDeclName()), 
        $out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_function_template_spec_ambiguous)), 
                FD.getDeclName()), ((ExplicitTemplateArgs != (TemplateArgumentListInfo /*P*/ )null) ? 1 : 0)), 
        $c$.track($this().PDiag(diag.note_function_template_spec_matched))));
    if (Result.$eq(Candidates.end())) {
      return true;
    }
    
    // Ignore access information;  it doesn't figure into redeclaration checking.
    FunctionDecl /*P*/ Specialization = cast_FunctionDecl(Result.$star());
    
    // C++ Concepts TS [dcl.spec.concept]p7: A program shall not declare [...]
    // an explicit specialization (14.8.3) [...] of a concept definition.
    if (Specialization.getPrimaryTemplate().isConcept()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(FD.getLocation(), diag.err_concept_specialized)), 
              0/*function*/), 1/*explicitly specialized*/));
      $c$.clean($c$.track($this().Diag(Specialization.getLocation(), diag.note_previous_declaration)));
      return true;
    }
    
    FunctionTemplateSpecializationInfo /*P*/ SpecInfo = Specialization.getTemplateSpecializationInfo();
    assert ((SpecInfo != null)) : "Function template specialization info missing?";
    
    // Note: do not overwrite location info if previous template
    // specialization kind was explicit.
    TemplateSpecializationKind TSK = SpecInfo.getTemplateSpecializationKind();
    if (TSK == TemplateSpecializationKind.TSK_Undeclared || TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      Specialization.setLocation(FD.getLocation());
      // C++11 [dcl.constexpr]p1: An explicit specialization of a constexpr
      // function can differ from the template declaration with respect to
      // the constexpr specifier.
      Specialization.setConstexpr(FD.isConstexpr());
    }
    
    // FIXME: Check if the prior specialization has a point of instantiation.
    // If so, we have run afoul of .
    
    // If this is a friend declaration, then we're not really declaring
    // an explicit specialization.
    boolean isFriend = (FD.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None);
    
    // Check the scope of this explicit specialization.
    if (!isFriend
       && CheckTemplateSpecializationScope(/*Deref*/$this(), 
        Specialization.getPrimaryTemplate(), 
        Specialization, FD.getLocation(), 
        false)) {
      return true;
    }
    
    // C++ [temp.expl.spec]p6:
    //   If a template, a member template or the member of a class template is
    //   explicitly specialized then that specialization shall be declared
    //   before the first use of that specialization that would cause an implicit
    //   instantiation to take place, in every translation unit in which such a
    //   use occurs; no diagnostic is required.
    bool$ref HasNoEffect = create_bool$ref(false);
    if (!isFriend
       && $this().CheckSpecializationInstantiationRedecl(FD.getLocation(), 
        TemplateSpecializationKind.TSK_ExplicitSpecialization, 
        Specialization, 
        SpecInfo.getTemplateSpecializationKind(), 
        SpecInfo.getPointOfInstantiation(), 
        HasNoEffect)) {
      return true;
    }
    
    // Mark the prior declaration as an explicit specialization, so that later
    // clients know that this is an explicit specialization.
    if (!isFriend) {
      // Since explicit specializations do not inherit '=delete' from their
      // primary function template - check if the 'specialization' that was
      // implicitly generated (during template argument deduction for partial
      // ordering) from the most specialized of all the function templates that
      // 'FD' could have been specializing, has a 'deleted' definition.  If so,
      // first check that it was implicitly generated during template argument
      // deduction by making sure it wasn't referenced, and then reset the deleted
      // flag to not-deleted, so that we can inherit that information from 'FD'.
      if (Specialization.isDeleted() && !SpecInfo.isExplicitSpecialization()
         && !Specialization.getCanonicalDecl().isReferenced()) {
        assert (Specialization.getCanonicalDecl() == Specialization) : "This must be the only existing declaration of this specialization";
        Specialization.setDeletedAsWritten(false);
      }
      SpecInfo.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
      $this().MarkUnusedFileScopedDecl(Specialization);
    }
    
    // Turn the given function declaration into a function template
    // specialization, with the template arguments from the previous
    // specialization.
    // Take copies of (semantic and syntactic) template argument lists.
    /*const*/ TemplateArgumentList /*P*/ TemplArgs = /*FIXME:NEW_EXPR*//*new (Context)*/ new TemplateArgumentList(JD$TemplateArgumentList$C$P.INSTANCE, Specialization.getTemplateSpecializationArgs());
    FD.setFunctionTemplateSpecialization(Specialization.getPrimaryTemplate(), TemplArgs, /*InsertPos=*/ (type$ptr<FunctionTemplateSpecializationInfo /*P*/>/*void P*/ )null, 
        SpecInfo.getTemplateSpecializationKind(), 
        (ExplicitTemplateArgs != null) ? $AddrOf(ConvertedTemplateArgs.$at_T1$C$R(Specialization)) : (TemplateArgumentListInfo /*P*/ )null);
    
    // The "previous declaration" for this function template specialization is
    // the prior function template specialization.
    Previous.clear();
    Previous.addDecl(Specialization);
    return false;
  } finally {
    if (ConvertedTemplateArgs != null) { ConvertedTemplateArgs.$destroy(); }
    if (FailedCandidates != null) { FailedCandidates.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Perform semantic analysis for the given non-template member
/// specialization.
///
/// This routine performs all of the semantic analysis required for an
/// explicit member function specialization. On successful completion,
/// the function declaration \p FD will become a member function
/// specialization.
///
/// \param Member the member declaration, which will be updated to become a
/// specialization.
///
/// \param Previous the set of declarations, one of which may be specialized
/// by this function specialization;  the set will be modified to contain the
/// redeclared member.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMemberSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 7057,
 FQN="clang::Sema::CheckMemberSpecialization", NM="_ZN5clang4Sema25CheckMemberSpecializationEPNS_9NamedDeclERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema25CheckMemberSpecializationEPNS_9NamedDeclERNS_12LookupResultE")
//</editor-fold>
public final boolean CheckMemberSpecialization(NamedDecl /*P*/ Member, final LookupResult /*&*/ Previous) {
  assert (!isa_TemplateDecl(Member)) : "Only for non-template members";
  
  // Try to find the member we are instantiating.
  NamedDecl /*P*/ FoundInstantiation = null;
  NamedDecl /*P*/ Instantiation = null;
  NamedDecl /*P*/ InstantiatedFrom = null;
  MemberSpecializationInfo /*P*/ MSInfo = null;
  if (Previous.empty()) {
    // Nowhere to look anyway.
  } else {
    FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(Member);
    if ((Function != null)) {
      for (UnresolvedSetIterator I = Previous.begin(), E = Previous.end();
           I.$noteq(E); I.$preInc()) {
        NamedDecl /*P*/ D = (I.$star()).getUnderlyingDecl();
        {
          CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
          if ((Method != null)) {
            QualType Adjusted = Function.getType();
            if (!$this().hasExplicitCallingConv(Adjusted)) {
              Adjusted.$assignMove($this().adjustCCAndNoReturn(new QualType(Adjusted), Method.getType()));
            }
            if ($this().Context.hasSameType(new QualType(Adjusted), Method.getType())) {
              FoundInstantiation = I.$star();
              Instantiation = Method;
              InstantiatedFrom = Method.getInstantiatedFromMemberFunction();
              MSInfo = Method.getMemberSpecializationInfo();
              break;
            }
          }
        }
      }
    } else if (isa_VarDecl(Member)) {
      VarDecl /*P*/ PrevVar;
      if (Previous.isSingleResult()
         && ((PrevVar = dyn_cast_VarDecl(Previous.getFoundDecl())) != null)) {
        if (PrevVar.isStaticDataMember()) {
          FoundInstantiation = Previous.getRepresentativeDecl();
          Instantiation = PrevVar;
          InstantiatedFrom = PrevVar.getInstantiatedFromStaticDataMember();
          MSInfo = PrevVar.getMemberSpecializationInfo();
        }
      }
    } else if (isa_RecordDecl(Member)) {
      CXXRecordDecl /*P*/ PrevRecord;
      if (Previous.isSingleResult()
         && ((PrevRecord = dyn_cast_CXXRecordDecl(Previous.getFoundDecl())) != null)) {
        FoundInstantiation = Previous.getRepresentativeDecl();
        Instantiation = PrevRecord;
        InstantiatedFrom = PrevRecord.getInstantiatedFromMemberClass();
        MSInfo = PrevRecord.getMemberSpecializationInfo();
      }
    } else if (isa_EnumDecl(Member)) {
      EnumDecl /*P*/ PrevEnum;
      if (Previous.isSingleResult()
         && ((PrevEnum = dyn_cast_EnumDecl(Previous.getFoundDecl())) != null)) {
        FoundInstantiation = Previous.getRepresentativeDecl();
        Instantiation = PrevEnum;
        InstantiatedFrom = PrevEnum.getInstantiatedFromMemberEnum();
        MSInfo = PrevEnum.getMemberSpecializationInfo();
      }
    }
  }
  if (!(Instantiation != null)) {
    // There is no previous declaration that matches. Since member
    // specializations are always out-of-line, the caller will complain about
    // this mismatch later.
    return false;
  }
  
  // If this is a friend, just bail out here before we start turning
  // things into explicit specializations.
  if (Member.getFriendObjectKind() != Decl.FriendObjectKind.FOK_None) {
    // Preserve instantiation information.
    if ((InstantiatedFrom != null) && isa_CXXMethodDecl(Member)) {
      cast_CXXMethodDecl(Member).setInstantiationOfMemberFunction(cast_CXXMethodDecl(InstantiatedFrom), 
          cast_CXXMethodDecl(Instantiation).getTemplateSpecializationKind());
    } else if ((InstantiatedFrom != null) && isa_CXXRecordDecl(Member)) {
      cast_CXXRecordDecl(Member).setInstantiationOfMemberClass(cast_CXXRecordDecl(InstantiatedFrom), 
          cast_CXXRecordDecl(Instantiation).getTemplateSpecializationKind());
    }
    
    Previous.clear();
    Previous.addDecl(FoundInstantiation);
    return false;
  }
  
  // Make sure that this is a specialization of a member.
  if (!(InstantiatedFrom != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Member.getLocation(), diag.err_spec_member_not_instantiated)), 
          Member));
      $c$.clean($c$.track($this().Diag(Instantiation.getLocation(), diag.note_specialized_decl)));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ [temp.expl.spec]p6:
  //   If a template, a member template or the member of a class template is
  //   explicitly specialized then that specialization shall be declared
  //   before the first use of that specialization that would cause an implicit
  //   instantiation to take place, in every translation unit in which such a
  //   use occurs; no diagnostic is required.
  assert ((MSInfo != null)) : "Member specialization info missing?";
  
  bool$ref HasNoEffect = create_bool$ref(false);
  if ($this().CheckSpecializationInstantiationRedecl(Member.getLocation(), 
      TemplateSpecializationKind.TSK_ExplicitSpecialization, 
      Instantiation, 
      MSInfo.getTemplateSpecializationKind(), 
      MSInfo.getPointOfInstantiation(), 
      HasNoEffect)) {
    return true;
  }
  
  // Check the scope of this explicit specialization.
  if (CheckTemplateSpecializationScope(/*Deref*/$this(), 
      InstantiatedFrom, 
      Instantiation, Member.getLocation(), 
      false)) {
    return true;
  }
  
  // Note that this is an explicit instantiation of a member.
  // the original declaration to note that it is an explicit specialization
  // (if it was previously an implicit instantiation). This latter step
  // makes bookkeeping easier.
  if (isa_FunctionDecl(Member)) {
    FunctionDecl /*P*/ InstantiationFunction = cast_FunctionDecl(Instantiation);
    if (InstantiationFunction.getTemplateSpecializationKind()
       == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      InstantiationFunction.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
      InstantiationFunction.setLocation(Member.getLocation());
      // Explicit specializations of member functions of class templates do not
      // inherit '=delete' from the member function they are specializing.
      if (InstantiationFunction.isDeleted()) {
        assert (InstantiationFunction.getCanonicalDecl() == InstantiationFunction);
        InstantiationFunction.setDeletedAsWritten(false);
      }
    }
    
    cast_FunctionDecl(Member).setInstantiationOfMemberFunction(cast_CXXMethodDecl(InstantiatedFrom), 
        TemplateSpecializationKind.TSK_ExplicitSpecialization);
    $this().MarkUnusedFileScopedDecl(InstantiationFunction);
  } else if (isa_VarDecl(Member)) {
    VarDecl /*P*/ InstantiationVar = cast_VarDecl(Instantiation);
    if (InstantiationVar.getTemplateSpecializationKind()
       == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      InstantiationVar.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
      InstantiationVar.setLocation(Member.getLocation());
    }
    
    cast_VarDecl(Member).setInstantiationOfStaticDataMember(cast_VarDecl(InstantiatedFrom), TemplateSpecializationKind.TSK_ExplicitSpecialization);
    $this().MarkUnusedFileScopedDecl(InstantiationVar);
  } else if (isa_CXXRecordDecl(Member)) {
    CXXRecordDecl /*P*/ InstantiationClass = cast_CXXRecordDecl(Instantiation);
    if (InstantiationClass.getTemplateSpecializationKind()
       == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      InstantiationClass.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
      InstantiationClass.setLocation(Member.getLocation());
    }
    
    cast_CXXRecordDecl(Member).setInstantiationOfMemberClass(cast_CXXRecordDecl(InstantiatedFrom), 
        TemplateSpecializationKind.TSK_ExplicitSpecialization);
  } else {
    assert (isa_EnumDecl(Member)) : "Only member enums remain";
    EnumDecl /*P*/ InstantiationEnum = cast_EnumDecl(Instantiation);
    if (InstantiationEnum.getTemplateSpecializationKind()
       == TemplateSpecializationKind.TSK_ImplicitInstantiation) {
      InstantiationEnum.setTemplateSpecializationKind(TemplateSpecializationKind.TSK_ExplicitSpecialization);
      InstantiationEnum.setLocation(Member.getLocation());
    }
    
    cast_EnumDecl(Member).setInstantiationOfMemberEnum(cast_EnumDecl(InstantiatedFrom), TemplateSpecializationKind.TSK_ExplicitSpecialization);
  }
  
  // Save the caller the trouble of having to figure out which declaration
  // this specialization matches.
  Previous.clear();
  Previous.addDecl(FoundInstantiation);
  return false;
}


// Explicit instantiation of a class template specialization
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExplicitInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 7319,
 FQN="clang::Sema::ActOnExplicitInstantiation", NM="_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_jS3_RKNS_12CXXScopeSpecENS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_jS3_RKNS_12CXXScopeSpecENS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_PNS_13AttributeListE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnExplicitInstantiation(Scope /*P*/ S, 
                          SourceLocation ExternLoc, 
                          SourceLocation TemplateLoc, 
                          /*uint*/int TagSpec, 
                          SourceLocation KWLoc, 
                          final /*const*/ CXXScopeSpec /*&*/ SS, 
                          OpaquePtr<TemplateName> TemplateD, 
                          SourceLocation TemplateNameLoc, 
                          SourceLocation LAngleLoc, 
                          MutableArrayRef<ParsedTemplateArgument> TemplateArgsIn, 
                          SourceLocation RAngleLoc, 
                          AttributeList /*P*/ Attr) {
  TemplateArgumentListInfo TemplateArgs = null;
  try {
    // Find the class template we're specializing
    TemplateName Name = TemplateD.getTemplateName();
    TemplateDecl /*P*/ TD = Name.getAsTemplateDecl();
    // Check that the specialization uses the same tag kind as the
    // original template.
    TagTypeKind Kind = TypeWithKeyword.getTagTypeKindForTypeSpec(TagSpec);
    assert (Kind != TagTypeKind.TTK_Enum) : "Invalid enum tag in class template explicit instantiation!";
    
    ClassTemplateDecl /*P*/ ClassTemplate = dyn_cast_ClassTemplateDecl(TD);
    if (!(ClassTemplate != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        /*uint*/int ErrorKind = 0;
        if (isa_TypeAliasTemplateDecl(TD)) {
          ErrorKind = 4;
        } else if (isa_TemplateTemplateParmDecl(TD)) {
          ErrorKind = 5;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateNameLoc), diag.err_tag_reference_non_tag)), ErrorKind));
        $c$.clean($c$.track($this().Diag(TD.getLocation(), diag.note_previous_use)));
        return new ActionResult<Decl /*P*/ >(true);
      } finally {
        $c$.$destroy();
      }
    }
    if (!$this().isAcceptableTagRedeclaration(ClassTemplate.getTemplatedDecl(), 
        Kind, /*isDefinition*/ false, new SourceLocation(KWLoc), 
        ClassTemplate.getIdentifier())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(KWLoc), diag.err_use_with_wrong_tag)), 
                ClassTemplate), 
            FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/KWLoc), 
                ClassTemplate.getTemplatedDecl().getKindName())));
        $c$.clean($c$.track($this().Diag(ClassTemplate.getTemplatedDecl().getLocation(), 
            diag.note_previous_use)));
        Kind = ClassTemplate.getTemplatedDecl().getTagKind();
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++0x [temp.explicit]p2:
    //   There are two forms of explicit instantiation: an explicit instantiation
    //   definition and an explicit instantiation declaration. An explicit
    //   instantiation declaration begins with the extern keyword. [...]
    TemplateSpecializationKind TSK = ExternLoc.isInvalid() ? TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition : TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration;
    if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration) {
      // Check for dllexport class template instantiation declarations.
      for (AttributeList /*P*/ A = Attr; (A != null); A = A.getNext()) {
        if (A.getKind() == AttributeList.Kind.AT_DLLExport) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ExternLoc), 
                diag.warn_attribute_dllexport_explicit_instantiation_decl)));
            $c$.clean($c$.track($this().Diag(A.getLoc(), diag.note_attribute)));
            break;
          } finally {
            $c$.$destroy();
          }
        }
      }
      {
        
        DLLExportAttr /*P*/ A = ClassTemplate.getTemplatedDecl().getAttr(DLLExportAttr.class);
        if ((A != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(ExternLoc), 
                diag.warn_attribute_dllexport_explicit_instantiation_decl)));
            $c$.clean($c$.track($this().Diag(A.getLocation(), diag.note_attribute)));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    
    // In MSVC mode, dllimported explicit instantiation definitions are treated as
    // instantiation declarations for most purposes.
    boolean DLLImportExplicitInstantiationDef = false;
    if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition
       && $this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
      // Check for dllimport class template instantiation definitions.
      boolean DLLImport = (ClassTemplate.getTemplatedDecl().getAttr(DLLImportAttr.class) != null);
      for (AttributeList /*P*/ A = Attr; (A != null); A = A.getNext()) {
        if (A.getKind() == AttributeList.Kind.AT_DLLImport) {
          DLLImport = true;
        }
        if (A.getKind() == AttributeList.Kind.AT_DLLExport) {
          // dllexport trumps dllimport here.
          DLLImport = false;
          break;
        }
      }
      if (DLLImport) {
        TSK = TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration;
        DLLImportExplicitInstantiationDef = true;
      }
    }
    
    // Translate the parser's template argument list in our AST format.
    TemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
    $this().translateTemplateArguments(TemplateArgsIn, TemplateArgs);
    
    // Check that the template argument list is well-formed for this
    // template.
    SmallVector<TemplateArgument> _Converted/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    if ($this().CheckTemplateArgumentList(ClassTemplate, new SourceLocation(TemplateNameLoc), 
        TemplateArgs, false, _Converted)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // Find the class template specialization declaration that
    // corresponds to these arguments.
    final type$ref<type$ptr<ClassTemplateSpecializationDecl /*P*/>/*void P*/ > InsertPos = create_type$null$ref(null);
    ClassTemplateSpecializationDecl /*P*/ PrevDecl = ClassTemplate.findSpecialization(new ArrayRef<TemplateArgument>(_Converted, false), InsertPos);
    
    TemplateSpecializationKind PrevDecl_TSK = (PrevDecl != null) ? PrevDecl.getTemplateSpecializationKind() : TemplateSpecializationKind.TSK_Undeclared;
    
    // C++0x [temp.explicit]p2:
    //   [...] An explicit instantiation shall appear in an enclosing
    //   namespace of its template. [...]
    //
    // This is C++ DR 275.
    if (CheckExplicitInstantiationScope(/*Deref*/$this(), ClassTemplate, new SourceLocation(TemplateNameLoc), 
        SS.isSet())) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    ClassTemplateSpecializationDecl /*P*/ Specialization = null;
    
    bool$ref HasNoEffect = create_bool$ref(false);
    if ((PrevDecl != null)) {
      if ($this().CheckSpecializationInstantiationRedecl(new SourceLocation(TemplateNameLoc), TSK, 
          PrevDecl, PrevDecl_TSK, 
          PrevDecl.getPointOfInstantiation(), 
          HasNoEffect)) {
        return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, PrevDecl);
      }
      
      // Even though HasNoEffect == true means that this explicit instantiation
      // has no effect on semantics, we go on to put its syntax in the AST.
      if (PrevDecl_TSK == TemplateSpecializationKind.TSK_ImplicitInstantiation
         || PrevDecl_TSK == TemplateSpecializationKind.TSK_Undeclared) {
        // Since the only prior class template specialization with these
        // arguments was referenced but not declared, reuse that
        // declaration node as our own, updating the source location
        // for the template name to reflect our new declaration.
        // (Other source locations will be updated later.)
        Specialization = PrevDecl;
        Specialization.setLocation(new SourceLocation(TemplateNameLoc));
        PrevDecl = null;
      }
      if (PrevDecl_TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
         && DLLImportExplicitInstantiationDef) {
        // The new specialization might add a dllimport attribute.
        HasNoEffect.$set(false);
      }
    }
    if (!(Specialization != null)) {
      // Create a new class template specialization declaration node for
      // this explicit specialization.
      Specialization
         = ClassTemplateSpecializationDecl.Create($this().Context, Kind, 
          ClassTemplate.getDeclContext(), 
          new SourceLocation(KWLoc), new SourceLocation(TemplateNameLoc), 
          ClassTemplate, 
          new ArrayRef<TemplateArgument>(_Converted, false), 
          PrevDecl);
      SetNestedNameSpecifier(Specialization, SS);
      if (!HasNoEffect.$deref() && !(PrevDecl != null)) {
        // Insert the new specialization.
        ClassTemplate.AddSpecialization(Specialization, InsertPos.$deref());
      }
    }
    
    // Build the fully-sugared type for this explicit instantiation as
    // the user wrote in the explicit instantiation itself. This means
    // that we'll pretty-print the type retrieved from the
    // specialization's declaration the way that the user actually wrote
    // the explicit instantiation, rather than formatting the name based
    // on the "canonical" representation used to store the template
    // arguments in the specialization.
    TypeSourceInfo /*P*/ WrittenTy = $this().Context.getTemplateSpecializationTypeInfo(new TemplateName(Name), new SourceLocation(TemplateNameLoc), 
        TemplateArgs, 
        $this().Context.getTypeDeclType(Specialization));
    Specialization.setTypeAsWritten(WrittenTy);
    
    // Set source locations for keywords.
    Specialization.setExternLoc(new SourceLocation(ExternLoc));
    Specialization.setTemplateKeywordLoc(new SourceLocation(TemplateLoc));
    Specialization.setBraceRange(new SourceRange());
    if ((Attr != null)) {
      $this().ProcessDeclAttributeList(S, Specialization, Attr);
    }
    
    // Add the explicit instantiation into its lexical context. However,
    // since explicit instantiations are never found by name lookup, we
    // just put it into the declaration context directly.
    Specialization.setLexicalDeclContext($this().CurContext);
    $this().CurContext.addDecl(Specialization);
    
    // Syntax is now OK, so return if it has no other effect on semantics.
    if (HasNoEffect.$deref()) {
      // Set the template specialization kind.
      Specialization.setTemplateSpecializationKind(TSK);
      return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Specialization);
    }
    
    // C++ [temp.explicit]p3:
    //   A definition of a class template or class member template
    //   shall be in scope at the point of the explicit instantiation of
    //   the class template or class member template.
    //
    // This check comes when we actually try to perform the
    // instantiation.
    ClassTemplateSpecializationDecl /*P*/ Def = cast_or_null_ClassTemplateSpecializationDecl(Specialization.getDefinition());
    if (!(Def != null)) {
      $this().InstantiateClassTemplateSpecialization(new SourceLocation(TemplateNameLoc), Specialization, TSK);
    } else if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
      $this().MarkVTableUsed(new SourceLocation(TemplateNameLoc), Specialization, true);
      Specialization.setPointOfInstantiation(Def.getPointOfInstantiation());
    }
    
    // Instantiate the members of this class template specialization.
    Def = cast_or_null_ClassTemplateSpecializationDecl(Specialization.getDefinition());
    if ((Def != null)) {
      TemplateSpecializationKind Old_TSK = Def.getTemplateSpecializationKind();
      // Fix a TSK_ExplicitInstantiationDeclaration followed by a
      // TSK_ExplicitInstantiationDefinition
      if (Old_TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration
         && (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition
         || DLLImportExplicitInstantiationDef)) {
        // FIXME: Need to notify the ASTMutationListener that we did this.
        Def.setTemplateSpecializationKind(TSK);
        if (!(getDLLAttr(Def) != null) && (getDLLAttr(Specialization) != null)
           && $this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
          // In the MS ABI, an explicit instantiation definition can add a dll
          // attribute to a template with a previous instantiation declaration.
          // MinGW doesn't allow this.
          InheritableAttr /*P*/ A = cast_InheritableAttr(getDLLAttr(Specialization).clone($this().getASTContext()));
          A.setInherited(true);
          Def.addAttr(A);
          
          // We reject explicit instantiations in class scope, so there should
          // never be any delayed exported classes to worry about.
          assert ($this().DelayedDllExportClasses.empty()) : "delayed exports present at explicit instantiation";
          $this().checkClassLevelDLLAttribute(Def);
          $this().referenceDLLExportedClassMethods();
          
          // Propagate attribute to base class templates.
          for (final CXXBaseSpecifier /*&*/ B : Def.bases()) {
            {
              ClassTemplateSpecializationDecl /*P*/ BT = dyn_cast_or_null_ClassTemplateSpecializationDecl(B.getType().$arrow().getAsCXXRecordDecl());
              if ((BT != null)) {
                $this().propagateDLLAttrToBaseClassTemplate(Def, A, BT, B.getLocStart());
              }
            }
          }
        }
      }
      
      // Set the template specialization kind. Make sure it is set before
      // instantiating the members which will trigger ASTConsumer callbacks.
      Specialization.setTemplateSpecializationKind(TSK);
      $this().InstantiateClassTemplateSpecializationMembers(new SourceLocation(TemplateNameLoc), Def, TSK);
    } else {
      
      // Set the template specialization kind.
      Specialization.setTemplateSpecializationKind(TSK);
    }
    
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, Specialization);
  } finally {
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}


// Explicit instantiation of a member class of a class template.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExplicitInstantiation">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 7600,
 FQN="clang::Sema::ActOnExplicitInstantiation", NM="_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_jS3_RNS_12CXXScopeSpecEPNS_14IdentifierInfoES3_PNS_13AttributeListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_jS3_RNS_12CXXScopeSpecEPNS_14IdentifierInfoES3_PNS_13AttributeListE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnExplicitInstantiation(Scope /*P*/ S, 
                          SourceLocation ExternLoc, 
                          SourceLocation TemplateLoc, 
                          /*uint*/int TagSpec, 
                          SourceLocation KWLoc, 
                          final CXXScopeSpec /*&*/ SS, 
                          IdentifierInfo /*P*/ Name, 
                          SourceLocation NameLoc, 
                          AttributeList /*P*/ Attr) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    
    bool$ref Owned = create_bool$ref(false);
    bool$ref IsDependent = create_bool$ref(false);
    Decl /*P*/ TagD = $this().ActOnTag(S, TagSpec, Sema.TagUseKind.TUK_Reference, 
        new SourceLocation(KWLoc), SS, Name, new SourceLocation(NameLoc), Attr, AccessSpecifier.AS_none, 
        /*ModulePrivateLoc=*/ new SourceLocation(), 
        new MutableArrayRef<TemplateParameterList /*P*/ >(true), Owned, IsDependent, 
        new SourceLocation(), false, new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, new OpaquePtr<QualType>()), // ActionResult for POD type must be initied
        /*IsTypeSpecifier*/ false);
    assert (!IsDependent.$deref()) : "explicit instantiation of dependent name not yet handled";
    if (!(TagD != null)) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    TagDecl /*P*/ Tag = cast_TagDecl(TagD);
    assert (!Tag.isEnum()) : "shouldn't see enumerations here";
    if (Tag.isInvalidDecl()) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(Tag);
    CXXRecordDecl /*P*/ Pattern = Record.getInstantiatedFromMemberClass();
    if (!(Pattern != null)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateLoc), diag.err_explicit_instantiation_nontemplate_type)), 
          $this().Context.getTypeDeclType(Record)));
      $c$.clean($c$.track($this().Diag(Record.getLocation(), diag.note_nontemplate_decl_here)));
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // C++0x [temp.explicit]p2:
    //   If the explicit instantiation is for a class or member class, the
    //   elaborated-type-specifier in the declaration shall include a
    //   simple-template-id.
    //
    // C++98 has the same restriction, just worded differently.
    if (!ScopeSpecifierHasTemplateId(SS)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateLoc), diag.ext_explicit_instantiation_without_qualified_id)), 
              Record), SS.getRange()));
    }
    
    // C++0x [temp.explicit]p2:
    //   There are two forms of explicit instantiation: an explicit instantiation
    //   definition and an explicit instantiation declaration. An explicit
    //   instantiation declaration begins with the extern keyword. [...]
    TemplateSpecializationKind TSK = ExternLoc.isInvalid() ? TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition : TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration;
    
    // C++0x [temp.explicit]p2:
    //   [...] An explicit instantiation shall appear in an enclosing
    //   namespace of its template. [...]
    //
    // This is C++ DR 275.
    CheckExplicitInstantiationScope(/*Deref*/$this(), Record, new SourceLocation(NameLoc), true);
    
    // Verify that it is okay to explicitly instantiate here.
    CXXRecordDecl /*P*/ PrevDecl = cast_or_null_CXXRecordDecl(Record.getPreviousDecl());
    if (!(PrevDecl != null) && (Record.getDefinition() != null)) {
      PrevDecl = Record;
    }
    if ((PrevDecl != null)) {
      MemberSpecializationInfo /*P*/ MSInfo = PrevDecl.getMemberSpecializationInfo();
      bool$ref HasNoEffect = create_bool$ref(false);
      assert ((MSInfo != null)) : "No member specialization information?";
      if ($this().CheckSpecializationInstantiationRedecl(new SourceLocation(TemplateLoc), TSK, 
          PrevDecl, 
          MSInfo.getTemplateSpecializationKind(), 
          MSInfo.getPointOfInstantiation(), 
          HasNoEffect)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      if (HasNoEffect.$deref()) {
        return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, TagD);
      }
    }
    
    CXXRecordDecl /*P*/ RecordDef = cast_or_null_CXXRecordDecl(Record.getDefinition());
    if (!(RecordDef != null)) {
      // C++ [temp.explicit]p3:
      //   A definition of a member class of a class template shall be in scope
      //   at the point of an explicit instantiation of the member class.
      CXXRecordDecl /*P*/ Def = cast_or_null_CXXRecordDecl(Pattern.getDefinition());
      if (!(Def != null)) {
        $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateLoc), diag.err_explicit_instantiation_undefined_member)), 
                    0), Record.getDeclName()), Record.getDeclContext()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Pattern.getLocation(), diag.note_forward_declaration)), 
            Pattern));
        return new ActionResult<Decl /*P*/ >(true);
      } else {
        if ($c$.clean($this().InstantiateClass(new SourceLocation(NameLoc), Record, Def, 
            $c$.track($this().getTemplateInstantiationArgs(Record)), 
            TSK))) {
          return new ActionResult<Decl /*P*/ >(true);
        }
        
        RecordDef = cast_or_null_CXXRecordDecl(Record.getDefinition());
        if (!(RecordDef != null)) {
          return new ActionResult<Decl /*P*/ >(true);
        }
      }
    }
    
    // Instantiate all of the members of the class.
    $this().InstantiateClassMembers(new SourceLocation(NameLoc), RecordDef, 
        $c$.track($this().getTemplateInstantiationArgs(Record)), TSK); $c$.clean();
    if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
      $this().MarkVTableUsed(new SourceLocation(NameLoc), RecordDef, true);
    }
    
    // FIXME: We don't have any representation for explicit instantiations of
    // member classes. Such a representation is not needed for compilation, but it
    // should be available for clients that want to see all of the declarations in
    // the source code.
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, TagD);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExplicitInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 7723,
 FQN="clang::Sema::ActOnExplicitInstantiation", NM="_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_RNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema26ActOnExplicitInstantiationEPNS_5ScopeENS_14SourceLocationES3_RNS_10DeclaratorE")
//</editor-fold>
public final ActionResult<Decl /*P*/ > ActOnExplicitInstantiation(Scope /*P*/ S, 
                          SourceLocation ExternLoc, 
                          SourceLocation TemplateLoc, 
                          final Declarator /*&*/ D) {
  LookupResult Previous = null;
  TemplateArgumentListInfo TemplateArgs = null;
  TemplateSpecCandidateSet FailedCandidates = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Explicit instantiations always require a name.
    // TODO: check if/when DNInfo should replace Name.
    DeclarationNameInfo NameInfo = $this().GetNameForDeclarator(D);
    DeclarationName Name = NameInfo.getName();
    if (!Name.$bool()) {
      if (!D.isInvalidType()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getLocStart(), 
                    diag.err_explicit_instantiation_requires_name)), 
                D.getDeclSpec().getSourceRange()), 
            D.getSourceRange()));
      }
      
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // The scope passed in may not be a decl scope.  Zip up the scope tree until
    // we find one that is.
    while ((S.getFlags() & Scope.ScopeFlags.DeclScope) == 0
       || (S.getFlags() & Scope.ScopeFlags.TemplateParamScope) != 0) {
      S = S.getParent();
    }
    
    // Determine the type of the declaration.
    TypeSourceInfo /*P*/ T = $this().GetTypeForDeclarator(D, S);
    QualType R = T.getType();
    if (R.isNull()) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // C++ [dcl.stc]p1:
    //   A storage-class-specifier shall not be specified in [...] an explicit 
    //   instantiation (14.7.2) directive.
    if (D.getDeclSpec().getStorageClassSpec() == DeclSpec.SCS.SCS_typedef) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_explicit_instantiation_of_typedef)), 
          Name));
      return new ActionResult<Decl /*P*/ >(true);
    } else if (D.getDeclSpec().getStorageClassSpec()
       != DeclSpec.SCS.SCS_unspecified) {
      // Complain about then remove the storage class specifier.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_explicit_instantiation_storage_class)), 
          FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getStorageClassSpecLoc()))));
      
      D.getMutableDeclSpec().ClearStorageClassSpecs();
    }
    
    // C++0x [temp.explicit]p1:
    //   [...] An explicit instantiation of a function template shall not use the
    //   inline or constexpr specifiers.
    // Presumably, this also applies to member functions of class templates as
    // well.
    if (D.getDeclSpec().isInlineSpecified()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getInlineSpecLoc(), 
              $this().getLangOpts().CPlusPlus11 ? diag.err_explicit_instantiation_inline : diag.warn_explicit_instantiation_inline_0x)), 
          FixItHint.CreateRemoval(new SourceRange(D.getDeclSpec().getInlineSpecLoc()))));
    }
    if (D.getDeclSpec().isConstexprSpecified() && R.$arrow().isFunctionType()) {
      // FIXME: Add a fix-it to remove the 'constexpr' and add a 'const' if one is
      // not already specified.
      $c$.clean($c$.track($this().Diag(D.getDeclSpec().getConstexprSpecLoc(), 
          diag.err_explicit_instantiation_constexpr)));
    }
    
    // C++ Concepts TS [dcl.spec.concept]p1: The concept specifier shall be
    // applied only to the definition of a function template or variable template,
    // declared in namespace scope.
    if (D.getDeclSpec().isConceptSpecified()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getDeclSpec().getConceptSpecLoc(), 
              diag.err_concept_specified_specialization)), 0));
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // C++0x [temp.explicit]p2:
    //   There are two forms of explicit instantiation: an explicit instantiation
    //   definition and an explicit instantiation declaration. An explicit
    //   instantiation declaration begins with the extern keyword. [...]
    TemplateSpecializationKind TSK = ExternLoc.isInvalid() ? TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition : TemplateSpecializationKind.TSK_ExplicitInstantiationDeclaration;
    
    Previous/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName);
    $this().LookupParsedName(Previous, S, $AddrOf(D.getCXXScopeSpec()));
    if (!R.$arrow().isFunctionType()) {
      // C++ [temp.explicit]p1:
      //   A [...] static data member of a class template can be explicitly
      //   instantiated from the member definition associated with its class
      //   template.
      // C++1y [temp.explicit]p1:
      //   A [...] variable [...] template specialization can be explicitly
      //   instantiated from its template.
      if (Previous.isAmbiguous()) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      VarDecl /*P*/ Prev = Previous.<VarDecl>getAsSingle(VarDecl.class);
      VarTemplateDecl /*P*/ PrevTemplate = Previous.<VarTemplateDecl>getAsSingle(VarTemplateDecl.class);
      if (!(PrevTemplate != null)) {
        if (!(Prev != null) || !Prev.isStaticDataMember()) {
          // We expect to see a data data member here.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_explicit_instantiation_not_known)), 
              Name));
          for (UnresolvedSetIterator P = Previous.begin(), PEnd = Previous.end();
               P.$noteq(PEnd); P.$preInc())  {
            $c$.clean($c$.track($this().Diag((P.$star()).getLocation(), diag.note_explicit_instantiation_here)));
          }
          return new ActionResult<Decl /*P*/ >(true);
        }
        if (!(Prev.getInstantiatedFromStaticDataMember() != null)) {
          // FIXME: Check for explicit specialization?
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                  diag.err_explicit_instantiation_data_member_not_instantiated)), 
              Prev));
          $c$.clean($c$.track($this().Diag(Prev.getLocation(), diag.note_explicit_instantiation_here)));
          // FIXME: Can we provide a note showing where this was declared?
          return new ActionResult<Decl /*P*/ >(true);
        }
      } else {
        TemplateArgumentListInfo TemplateArgs$1 = null;
        try {
          // Explicitly instantiate a variable template.
          
          // C++1y [dcl.spec.auto]p6:
          //   ... A program that uses auto or decltype(auto) in a context not
          //   explicitly allowed in this section is ill-formed.
          //
          // This includes auto-typed variable template instantiations.
          if (R.$arrow().isUndeducedType()) {
            $c$.clean($c$.track($this().Diag(T.getTypeLoc().getLocStart(), 
                diag.err_auto_not_allowed_var_inst)));
            return new ActionResult<Decl /*P*/ >(true);
          }
          if (D.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId) {
            // C++1y [temp.explicit]p3:
            //   If the explicit instantiation is for a variable, the unqualified-id
            //   in the declaration shall be a template-id.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                    diag.err_explicit_instantiation_without_template_id)), 
                PrevTemplate));
            $c$.clean($c$.track($this().Diag(PrevTemplate.getLocation(), 
                diag.note_explicit_instantiation_here)));
            return new ActionResult<Decl /*P*/ >(true);
          }
          
          // C++ Concepts TS [dcl.spec.concept]p7: A program shall not declare an
          // explicit instantiation (14.8.2) [...] of a concept definition.
          if (PrevTemplate.isConcept()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_concept_specialized)), 
                    1/*variable*/), 0/*explicitly instantiated*/));
            $c$.clean($c$.track($this().Diag(PrevTemplate.getLocation(), diag.note_previous_declaration)));
            return new ActionResult<Decl /*P*/ >(true);
          }
          
          // Translate the parser's template argument list into our AST format.
          TemplateArgs$1 = makeTemplateArgumentListInfo(/*Deref*/$this(), $Deref(D.getName().Unnamed_field1.TemplateId));
          
          ActionResult<Decl /*P*/ > Res = $this().CheckVarTemplateId(PrevTemplate, new SourceLocation(TemplateLoc), 
              D.getIdentifierLoc(), TemplateArgs$1);
          if (Res.isInvalid()) {
            return new ActionResult<Decl /*P*/ >(true);
          }
          
          // Ignore access control bits, we don't need them for redeclaration
          // checking.
          Prev = cast_VarDecl(Res.get());
        } finally {
          if (TemplateArgs$1 != null) { TemplateArgs$1.$destroy(); }
        }
      }
      
      // C++0x [temp.explicit]p2:
      //   If the explicit instantiation is for a member function, a member class
      //   or a static data member of a class template specialization, the name of
      //   the class template specialization in the qualified-id for the member
      //   name shall be a simple-template-id.
      //
      // C++98 has the same restriction, just worded differently.
      //
      // This does not apply to variable template specializations, where the
      // template-id is in the unqualified-id instead.
      if (!ScopeSpecifierHasTemplateId(D.getCXXScopeSpec()) && !(PrevTemplate != null)) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                    diag.ext_explicit_instantiation_without_qualified_id)), 
                Prev), D.getCXXScopeSpec().getRange()));
      }
      
      // Check the scope of this explicit instantiation.
      CheckExplicitInstantiationScope(/*Deref*/$this(), Prev, D.getIdentifierLoc(), true);
      
      // Verify that it is okay to explicitly instantiate here.
      TemplateSpecializationKind PrevTSK = Prev.getTemplateSpecializationKind();
      SourceLocation POI = Prev.getPointOfInstantiation();
      bool$ref HasNoEffect = create_bool$ref(false);
      if ($this().CheckSpecializationInstantiationRedecl(D.getIdentifierLoc(), TSK, Prev, 
          PrevTSK, new SourceLocation(POI), HasNoEffect)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      if (!HasNoEffect.$deref()) {
        // Instantiate static data member or variable template.
        Prev.setTemplateSpecializationKind(TSK, D.getIdentifierLoc());
        if ((PrevTemplate != null)) {
          {
            // Merge attributes.
            AttributeList /*P*/ Attr = D.getDeclSpec().getAttributes$Const().getList();
            if ((Attr != null)) {
              $this().ProcessDeclAttributeList(S, Prev, Attr);
            }
          }
        }
        if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
          $this().InstantiateVariableDefinition(D.getIdentifierLoc(), Prev);
        }
      }
      
      // Check the new variable specialization against the parsed input.
      if ((PrevTemplate != null) && (Prev != null) && !$this().Context.hasSameType(Prev.getType(), new QualType(R))) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(T.getTypeLoc().getLocStart(), 
                            diag.err_invalid_var_template_spec_type)), 
                        0), PrevTemplate), R), Prev.getType()));
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(PrevTemplate.getLocation(), diag.note_template_declared_here)), 
                2), PrevTemplate.getDeclName()));
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      // FIXME: Create an ExplicitInstantiation node?
      return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, (Decl /*P*/ )(Decl /*P*/ )null);
    }
    
    // If the declarator is a template-id, translate the parser's template
    // argument list into our AST format.
    boolean HasExplicitTemplateArgs = false;
    TemplateArgs/*J*/= new TemplateArgumentListInfo();
    if (D.getName().getKind() == UnqualifiedId.IdKind.IK_TemplateId) {
      $c$.clean(TemplateArgs.$assignMove($c$.track(makeTemplateArgumentListInfo(/*Deref*/$this(), $Deref(D.getName().Unnamed_field1.TemplateId)))));
      HasExplicitTemplateArgs = true;
    }
    
    // C++ [temp.explicit]p1:
    //   A [...] function [...] can be explicitly instantiated from its template.
    //   A member function [...] of a class template can be explicitly
    //  instantiated from the member definition associated with its class
    //  template.
    UnresolvedSet Matches/*J*/= new UnresolvedSet(8);
    FailedCandidates/*J*/= new TemplateSpecCandidateSet(D.getIdentifierLoc());
    for (UnresolvedSetIterator P = Previous.begin(), PEnd = Previous.end();
         P.$noteq(PEnd); P.$preInc()) {
      TemplateDeductionInfo Info = null;
      try {
        NamedDecl /*P*/ Prev = P.$star();
        if (!HasExplicitTemplateArgs) {
          {
            CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Prev);
            if ((Method != null)) {
              QualType Adjusted = $this().adjustCCAndNoReturn(new QualType(R), Method.getType());
              if ($this().Context.hasSameUnqualifiedType(Method.getType(), new QualType(Adjusted))) {
                Matches.clear();
                
                Matches.addDecl(Method, P.getAccess());
                if (Method.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_Undeclared) {
                  break;
                }
              }
            }
          }
        }
        
        FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(Prev);
        if (!(FunTmpl != null)) {
          continue;
        }
        
        Info/*J*/= new TemplateDeductionInfo(FailedCandidates.getLocation());
        type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
        {
          TemplateDeductionResult TDK = $this().DeduceTemplateArguments3(FunTmpl, 
              (HasExplicitTemplateArgs ? $AddrOf(TemplateArgs) : (TemplateArgumentListInfo /*P*/ )null), 
              new QualType(R), Specialization, Info);
          if ((TDK.getValue() != 0)) {
            // Keep track of almost-matches.
            FailedCandidates.addCandidate().
                set(new DeclAccessPair(P.getPair()), FunTmpl.getTemplatedDecl(), 
                MakeDeductionFailureInfo($this().Context, TDK, Info));
            ///*J:(void)*/TDK;
            continue;
          }
        }
        
        Matches.addDecl(Specialization.$deref(), P.getAccess());
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    // Find the most specialized function template specialization.
    UnresolvedSetIterator Result = $c$.clean($this().getMostSpecialized(Matches.begin(), Matches.end(), FailedCandidates, 
        D.getIdentifierLoc(), 
        $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_explicit_instantiation_not_known)), /*NO_COPY*/Name), 
        $out_PartialDiagnostic$C_DeclarationName($c$.track($this().PDiag(diag.err_explicit_instantiation_ambiguous)), /*NO_COPY*/Name), 
        $c$.track($this().PDiag(diag.note_explicit_instantiation_candidate))));
    if (Result.$eq(Matches.end())) {
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    // Ignore access control bits, we don't need them for redeclaration checking.
    FunctionDecl /*P*/ Specialization = cast_FunctionDecl(Result.$star());
    {
      
      // C++11 [except.spec]p4
      // In an explicit instantiation an exception-specification may be specified,
      // but is not required.
      // If an exception-specification is specified in an explicit instantiation
      // directive, it shall be compatible with the exception-specifications of
      // other declarations of that function.
      /*const*/ FunctionProtoType /*P*/ FPT = R.$arrow().getAs(FunctionProtoType.class);
      if ((FPT != null)) {
        if (FPT.hasExceptionSpec()) {
          /*uint*/int DiagID = diag.err_mismatched_exception_spec_explicit_instantiation;
          if ($this().getLangOpts().MicrosoftExt) {
            DiagID = diag.ext_mismatched_exception_spec_explicit_instantiation;
          }
          boolean Result$1 = $c$.clean($this().CheckEquivalentExceptionSpec($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(DiagID)), Specialization.getType()), 
              $c$.track($this().PDiag(diag.note_explicit_instantiation_here)), 
              Specialization.getType().$arrow().getAs(FunctionProtoType.class), 
              Specialization.getLocation(), FPT, D.getLocStart()));
          // In Microsoft mode, mismatching exception specifications just cause a
          // warning.
          if (!$this().getLangOpts().MicrosoftExt && Result$1) {
            return new ActionResult<Decl /*P*/ >(true);
          }
        }
      }
    }
    if (Specialization.getTemplateSpecializationKind() == TemplateSpecializationKind.TSK_Undeclared) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                  diag.err_explicit_instantiation_member_function_not_instantiated)), 
              Specialization), 
          (Specialization.getTemplateSpecializationKind()
             == TemplateSpecializationKind.TSK_ExplicitSpecialization)));
      $c$.clean($c$.track($this().Diag(Specialization.getLocation(), diag.note_explicit_instantiation_here)));
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    FunctionDecl /*P*/ PrevDecl = Specialization.getPreviousDecl();
    if (!(PrevDecl != null) && Specialization.isThisDeclarationADefinition()) {
      PrevDecl = Specialization;
    }
    if ((PrevDecl != null)) {
      bool$ref HasNoEffect = create_bool$ref(false);
      if ($this().CheckSpecializationInstantiationRedecl(D.getIdentifierLoc(), TSK, 
          PrevDecl, 
          PrevDecl.getTemplateSpecializationKind(), 
          PrevDecl.getPointOfInstantiation(), 
          HasNoEffect)) {
        return new ActionResult<Decl /*P*/ >(true);
      }
      
      // FIXME: We may still want to build some representation of this
      // explicit specialization.
      if (HasNoEffect.$deref()) {
        return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, (Decl /*P*/ )(Decl /*P*/ )null);
      }
    }
    
    Specialization.setTemplateSpecializationKind(TSK, D.getIdentifierLoc());
    AttributeList /*P*/ Attr = D.getDeclSpec().getAttributes$Const().getList();
    if ((Attr != null)) {
      $this().ProcessDeclAttributeList(S, Specialization, Attr);
    }
    if (Specialization.isDefined()) {
      // Let the ASTConsumer know that this function has been explicitly
      // instantiated now, and its linkage might have changed.
      $this().Consumer.HandleTopLevelDecl(new DeclGroupRef(Specialization));
    } else if (TSK == TemplateSpecializationKind.TSK_ExplicitInstantiationDefinition) {
      $this().InstantiateFunctionDefinition(D.getIdentifierLoc(), Specialization);
    }
    
    // C++0x [temp.explicit]p2:
    //   If the explicit instantiation is for a member function, a member class
    //   or a static data member of a class template specialization, the name of
    //   the class template specialization in the qualified-id for the member
    //   name shall be a simple-template-id.
    //
    // C++98 has the same restriction, just worded differently.
    FunctionTemplateDecl /*P*/ FunTmpl = Specialization.getPrimaryTemplate();
    if (D.getName().getKind() != UnqualifiedId.IdKind.IK_TemplateId && !(FunTmpl != null)
       && D.getCXXScopeSpec().isSet()
       && !ScopeSpecifierHasTemplateId(D.getCXXScopeSpec())) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), 
                  diag.ext_explicit_instantiation_without_qualified_id)), 
              Specialization), D.getCXXScopeSpec().getRange()));
    }
    
    // C++ Concepts TS [dcl.spec.concept]p7: A program shall not declare an
    // explicit instantiation (14.8.2) [...] of a concept definition.
    if ((FunTmpl != null) && FunTmpl.isConcept()
       && !D.getDeclSpec().isConceptSpecified()) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getIdentifierLoc(), diag.err_concept_specialized)), 
              0/*function*/), 0/*explicitly instantiated*/));
      $c$.clean($c$.track($this().Diag(FunTmpl.getLocation(), diag.note_previous_declaration)));
      return new ActionResult<Decl /*P*/ >(true);
    }
    
    CheckExplicitInstantiationScope(/*Deref*/$this(), 
        (FunTmpl != null) ? (NamedDecl /*P*/ )FunTmpl : Specialization.getInstantiatedFromMemberFunction(), 
        D.getIdentifierLoc(), 
        D.getCXXScopeSpec().isSet());
    
    // FIXME: Create some kind of ExplicitInstantiationDecl here.
    return new ActionResult<Decl /*P*/ >(JD$T.INSTANCE, (Decl /*P*/ )(Decl /*P*/ )null);
  } finally {
    if (FailedCandidates != null) { FailedCandidates.$destroy(); }
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
    if (Previous != null) { Previous.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief If the given template parameter has a default template
/// argument, substitute into that default template argument and
/// return the corresponding template argument.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SubstDefaultTemplateArgumentIfAvailable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3395,
 FQN="clang::Sema::SubstDefaultTemplateArgumentIfAvailable", NM="_ZN5clang4Sema39SubstDefaultTemplateArgumentIfAvailableEPNS_12TemplateDeclENS_14SourceLocationES3_PNS_4DeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema39SubstDefaultTemplateArgumentIfAvailableEPNS_12TemplateDeclENS_14SourceLocationES3_PNS_4DeclERN4llvm15SmallVectorImplINS_16TemplateArgumentEEERb")
//</editor-fold>
public final TemplateArgumentLoc SubstDefaultTemplateArgumentIfAvailable(TemplateDecl /*P*/ Template, 
                                       SourceLocation TemplateLoc, 
                                       SourceLocation RAngleLoc, 
                                       Decl /*P*/ Param, 
                                       final SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                                       final bool$ref/*bool &*/ HasDefaultArg) {
  HasDefaultArg.$set(false);
  {
    
    TemplateTypeParmDecl /*P*/ TypeParm = dyn_cast_TemplateTypeParmDecl(Param);
    if ((TypeParm != null)) {
      if (!$this().hasVisibleDefaultArgument(TypeParm)) {
        return new TemplateArgumentLoc();
      }
      
      HasDefaultArg.$set(true);
      TypeSourceInfo /*P*/ DI = SubstDefaultTemplateArgument1(/*Deref*/$this(), Template, 
          new SourceLocation(TemplateLoc), 
          new SourceLocation(RAngleLoc), 
          TypeParm, 
          _Converted);
      if ((DI != null)) {
        return new TemplateArgumentLoc(new TemplateArgument(DI.getType()), DI);
      }
      
      return new TemplateArgumentLoc();
    }
  }
  {
    
    NonTypeTemplateParmDecl /*P*/ NonTypeParm = dyn_cast_NonTypeTemplateParmDecl(Param);
    if ((NonTypeParm != null)) {
      if (!$this().hasVisibleDefaultArgument(NonTypeParm)) {
        return new TemplateArgumentLoc();
      }
      
      HasDefaultArg.$set(true);
      ActionResultTTrue<Expr /*P*/ > Arg = SubstDefaultTemplateArgument2(/*Deref*/$this(), Template, 
          new SourceLocation(TemplateLoc), 
          new SourceLocation(RAngleLoc), 
          NonTypeParm, 
          _Converted);
      if (Arg.isInvalid()) {
        return new TemplateArgumentLoc();
      }
      
      Expr /*P*/ ArgE = Arg.getAs(Expr.class);
      return new TemplateArgumentLoc(new TemplateArgument(ArgE), ArgE);
    }
  }
  
  TemplateTemplateParmDecl /*P*/ TempTempParm = cast_TemplateTemplateParmDecl(Param);
  if (!$this().hasVisibleDefaultArgument(TempTempParm)) {
    return new TemplateArgumentLoc();
  }
  
  HasDefaultArg.$set(true);
  NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
  TemplateName TName = SubstDefaultTemplateArgument(/*Deref*/$this(), Template, 
      new SourceLocation(TemplateLoc), 
      new SourceLocation(RAngleLoc), 
      TempTempParm, 
      _Converted, 
      QualifierLoc);
  if (TName.isNull()) {
    return new TemplateArgumentLoc();
  }
  
  return new TemplateArgumentLoc(new TemplateArgument(new TemplateName(TName)), 
      TempTempParm.getDefaultArgument().getTemplateQualifierLoc(), 
      TempTempParm.getDefaultArgument().getTemplateNameLoc());
}


/// \brief Check that the given template argument corresponds to the given
/// template parameter.
///
/// \param Param The template parameter against which the argument will be
/// checked.
///
/// \param Arg The template argument, which may be updated due to conversions.
///
/// \param Template The template in which the template argument resides.
///
/// \param TemplateLoc The location of the template name for the template
/// whose argument list we're matching.
///
/// \param RAngleLoc The location of the right angle bracket ('>') that closes
/// the template argument list.
///
/// \param ArgumentPackIndex The index into the argument pack where this
/// argument will be placed. Only valid if the parameter is a parameter pack.
///
/// \param Converted The checked, converted argument will be added to the
/// end of this small vector.
///
/// \param CTAK Describes how we arrived at this particular template argument:
/// explicitly written, deduced, etc.
///
/// \returns true on error, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3486,
 FQN="clang::Sema::CheckTemplateArgument", NM="_ZN5clang4Sema21CheckTemplateArgumentEPNS_9NamedDeclERNS_19TemplateArgumentLocES2_NS_14SourceLocationES5_jRN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS0_25CheckTemplateArgumentKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema21CheckTemplateArgumentEPNS_9NamedDeclERNS_19TemplateArgumentLocES2_NS_14SourceLocationES5_jRN4llvm15SmallVectorImplINS_16TemplateArgumentEEENS0_25CheckTemplateArgumentKindE")
//</editor-fold>
public final boolean CheckTemplateArgument(NamedDecl /*P*/ Param, 
                     final TemplateArgumentLoc /*&*/ Arg, 
                     NamedDecl /*P*/ Template, 
                     SourceLocation TemplateLoc, 
                     SourceLocation RAngleLoc, 
                     /*uint*/int ArgumentPackIndex, 
                     final SmallVectorImpl<TemplateArgument> /*&*/ _Converted) {
  return CheckTemplateArgument(Param, 
                     Arg, 
                     Template, 
                     TemplateLoc, 
                     RAngleLoc, 
                     ArgumentPackIndex, 
                     _Converted, 
                     CheckTemplateArgumentKind.CTAK_Specified);
}
public final boolean CheckTemplateArgument(NamedDecl /*P*/ Param, 
                     final TemplateArgumentLoc /*&*/ Arg, 
                     NamedDecl /*P*/ Template, 
                     SourceLocation TemplateLoc, 
                     SourceLocation RAngleLoc, 
                     /*uint*/int ArgumentPackIndex, 
                     final SmallVectorImpl<TemplateArgument> /*&*/ _Converted, 
                     CheckTemplateArgumentKind CTAK/*= CTAK_Specified*/) {
  {
    // Check template type parameters.
    TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Param);
    if ((TTP != null)) {
      return $this().CheckTemplateTypeArgument(TTP, Arg, _Converted);
    }
  }
  {
    
    // Check non-type template parameters.
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
    if ((NTTP != null)) {
      // Do substitution on the type of the non-type template parameter
      // with the template arguments we've seen thus far.  But if the
      // template has a dependent context then we cannot substitute yet.
      QualType NTTPType = NTTP.getType();
      if (NTTP.isParameterPack() && NTTP.isExpandedParameterPack()) {
        NTTPType.$assignMove(NTTP.getExpansionType(ArgumentPackIndex));
      }
      if (NTTPType.$arrow().isDependentType()
         && !isa_TemplateTemplateParmDecl(Template)
         && !Template.getDeclContext().isDependentContext()) {
        InstantiatingTemplate Inst = null;
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Do substitution on the type of the non-type template parameter.
          Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_NamedDecl$P_NonTypeTemplateParmDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(TemplateLoc), Template, 
              NTTP, new ArrayRef<TemplateArgument>(_Converted, false), 
              new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc));
          if (Inst.isInvalid()) {
            return true;
          }
          
          TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, 
              new ArrayRef<TemplateArgument>(_Converted, false));
          $c$.clean(NTTPType.$assignMove($this().SubstType(new QualType(NTTPType), 
                  $c$.track(new MultiLevelTemplateArgumentList(TemplateArgs)), 
                  NTTP.getLocation(), 
                  NTTP.getDeclName())));
          // If that worked, check the non-type template parameter type
          // for validity.
          if (!NTTPType.isNull()) {
            NTTPType.$assignMove($this().CheckNonTypeTemplateParameterType(new QualType(NTTPType), 
                    NTTP.getLocation()));
          }
          if (NTTPType.isNull()) {
            return true;
          }
        } finally {
          if (Inst != null) { Inst.$destroy(); }
          $c$.$destroy();
        }
      }
      switch (Arg.getArgument().getKind()) {
       case Null:
        throw new llvm_unreachable("Should never see a NULL template argument here");
       case Expression:
        {
          TemplateArgument Result/*J*/= new TemplateArgument();
          ActionResultTTrue<Expr /*P*/ > Res = $this().CheckTemplateArgument(NTTP, new QualType(NTTPType), create_type$ptr(Arg.getArgument().getAsExpr()), 
              Result, CTAK);
          if (Res.isInvalid()) {
            return true;
          }
          
          // If the resulting expression is new, then use it in place of the
          // old expression in the template argument.
          if (Res.get() != Arg.getArgument().getAsExpr()) {
            TemplateArgument TA/*J*/= new TemplateArgument(Res.get());
            Arg.$assignMove(new TemplateArgumentLoc(TA, Res.get()));
          }
          
          _Converted.push_back(Result);
          break;
        }
       case Declaration:
       case Integral:
       case NullPtr:
        // We've already checked this template argument, so just copy
        // it to the list of converted arguments.
        _Converted.push_back(Arg.getArgument());
        break;
       case Template:
       case TemplateExpansion:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            {
              // We were given a template template argument. It may not be ill-formed;
              // see below.
              DependentTemplateName /*P*/ DTN = Arg.getArgument().getAsTemplateOrTemplatePattern().
                  getAsDependentTemplateName();
              if ((DTN != null)) {
                CXXScopeSpec SS = null;
                try {
                  // We have a template argument such as \c T::template X, which we
                  // parsed as a template template argument. However, since we now
                  // know that we need a non-type template argument, convert this
                  // template name into an expression.
                  DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(DTN.getIdentifier()), 
                      Arg.getTemplateNameLoc());
                  
                  SS/*J*/= new CXXScopeSpec();
                  SS.Adopt(Arg.getTemplateQualifierLoc());
                  // FIXME: the template-template arg was a DependentTemplateName,
                  // so it was provided with a template keyword. However, its source
                  // location is not stored in the template argument structure.
                  SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
                  ActionResultTTrue<Expr /*P*/ > E = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DependentScopeDeclRefExpr.Create($this().Context, SS.getWithLocInContext($this().Context), new SourceLocation(TemplateKWLoc), NameInfo, 
                          (/*const*/ TemplateArgumentListInfo /*P*/ )null));
                  
                  // If we parsed the template argument as a pack expansion, create a
                  // pack expansion expression.
                  if (Arg.getArgument().getKind() == TemplateArgument.ArgKind.TemplateExpansion) {
                    E.$assignMove($this().ActOnPackExpansion(E.get(), Arg.getTemplateEllipsisLoc()));
                    if (E.isInvalid()) {
                      return true;
                    }
                  }
                  
                  TemplateArgument Result/*J*/= new TemplateArgument();
                  E.$assignMove($this().CheckTemplateArgument(NTTP, new QualType(NTTPType), create_type$ptr(E.get()), Result));
                  if (E.isInvalid()) {
                    return true;
                  }
                  
                  _Converted.push_back(Result);
                  break;
                } finally {
                  if (SS != null) { SS.$destroy(); }
                }
              }
            }
            
            // We have a template argument that actually does refer to a class
            // template, alias template, or template template parameter, and
            // therefore cannot be a non-type template argument.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.getLocation(), diag.err_template_arg_must_be_expr)), 
                Arg.getSourceRange()));
            
            $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
       case Type:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            // We have a non-type template parameter but the template
            // argument is a type.
            
            // C++ [temp.arg]p2:
            //   In a template-argument, an ambiguity between a type-id and
            //   an expression is resolved to a type-id, regardless of the
            //   form of the corresponding template-parameter.
            //
            // We warn specifically about this case, since it can be rather
            // confusing for users.
            QualType T = Arg.getArgument().getAsType();
            SourceRange SR = Arg.getSourceRange();
            if (T.$arrow().isFunctionType()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_template_arg_nontype_ambig)), SR), T));
            } else {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_template_arg_must_be_expr)), SR));
            }
            $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
            return true;
          } finally {
            $c$.$destroy();
          }
        }
       case Pack:
        throw new llvm_unreachable("Caller must expand template argument packs");
      }
      
      return false;
    }
  }
  
  // Check template template parameters.
  TemplateTemplateParmDecl /*P*/ TempParm = cast_TemplateTemplateParmDecl(Param);
  {
    LocalInstantiationScope Scope = null;
    InstantiatingTemplate Inst = null;
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Set up a template instantiation context.
      Scope/*J*/= new LocalInstantiationScope(/*Deref*/$this());
      Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_NamedDecl$P_TemplateTemplateParmDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(TemplateLoc), Template, 
          TempParm, new ArrayRef<TemplateArgument>(_Converted, false), 
          new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc));
      if (Inst.isInvalid()) {
        return true;
      }
      
      TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, new ArrayRef<TemplateArgument>(_Converted, false));
      $c$.clean(TempParm = cast_or_null_TemplateTemplateParmDecl($this().SubstDecl(TempParm, $this().CurContext, 
    $c$.track(new MultiLevelTemplateArgumentList(TemplateArgs)))));
      if (!(TempParm != null)) {
        return true;
      }
    } finally {
      if (Inst != null) { Inst.$destroy(); }
      if (Scope != null) { Scope.$destroy(); }
      $c$.$destroy();
    }
  }
  switch (Arg.getArgument().getKind()) {
   case Null:
    throw new llvm_unreachable("Should never see a NULL template argument here");
   case Template:
   case TemplateExpansion:
    if ($this().CheckTemplateArgument(TempParm, Arg, ArgumentPackIndex)) {
      return true;
    }
    
    _Converted.push_back(Arg.getArgument());
    break;
   case Expression:
   case Type:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We have a template template parameter but the template
        // argument does not refer to a template.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.getLocation(), diag.err_template_arg_must_be_template)), 
            $this().getLangOpts().CPlusPlus11));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
   case Declaration:
    throw new llvm_unreachable("Declaration argument with template template parameter");
   case Integral:
    throw new llvm_unreachable("Integral argument with template template parameter");
   case NullPtr:
    throw new llvm_unreachable("Null pointer argument with template template parameter");
   case Pack:
    throw new llvm_unreachable("Caller must expand template argument packs");
  }
  
  return false;
}


/// \brief Check that the given template arguments can be be provided to
/// the given template, converting the arguments along the way.
///
/// \param Template The template to which the template arguments are being
/// provided.
///
/// \param TemplateLoc The location of the template name in the source.
///
/// \param TemplateArgs The list of template arguments. If the template is
/// a template template parameter, this function may extend the set of
/// template arguments to also include substituted, defaulted template
/// arguments.
///
/// \param PartialTemplateArgs True if the list of template arguments is
/// intentionally partial, e.g., because we're checking just the initial
/// set of template arguments.
///
/// \param Converted Will receive the converted, canonicalized template
/// arguments.
///
/// \returns true if an error occurred, false otherwise.

/// \brief Check that the given template argument list is well-formed
/// for specializing the given template.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgumentList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3781,
 FQN="clang::Sema::CheckTemplateArgumentList", NM="_ZN5clang4Sema25CheckTemplateArgumentListEPNS_12TemplateDeclENS_14SourceLocationERNS_24TemplateArgumentListInfoEbRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema25CheckTemplateArgumentListEPNS_12TemplateDeclENS_14SourceLocationERNS_24TemplateArgumentListInfoEbRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE")
//</editor-fold>
public final boolean CheckTemplateArgumentList(TemplateDecl /*P*/ Template, 
                         SourceLocation TemplateLoc, 
                         final TemplateArgumentListInfo /*&*/ TemplateArgs, 
                         boolean PartialTemplateArgs, 
                         final SmallVectorImpl<TemplateArgument> /*&*/ _Converted) {
  LocalInstantiationScope InstScope = null;
  try {
    // Make a copy of the template arguments for processing.  Only make the
    // changes at the end when successful in matching the arguments to the
    // template.
    TemplateArgumentListInfo NewArgs = new TemplateArgumentListInfo(TemplateArgs);
    
    TemplateParameterList /*P*/ Params = Template.getTemplateParameters();
    
    SourceLocation RAngleLoc = NewArgs.getRAngleLoc();
    
    // C++ [temp.arg]p1:
    //   [...] The type and form of each template-argument specified in
    //   a template-id shall match the type and form specified for the
    //   corresponding parameter declared by the template in its
    //   template-parameter-list.
    boolean isTemplateTemplateParameter = isa_TemplateTemplateParmDecl(Template);
    SmallVector<TemplateArgument> ArgumentPack/*J*/= new SmallVector<TemplateArgument>(2, new TemplateArgument());
    /*uint*/int ArgIdx = 0;
    /*uint*/int NumArgs = NewArgs.size();
    InstScope/*J*/= new LocalInstantiationScope(/*Deref*/$this(), true);
    for (type$ptr<NamedDecl /*P*/ /*P*/> Param = $tryClone(Params.begin()), 
        /*P*/ /*P*/ ParamEnd = $tryClone(Params.end());
         $noteq_ptr(Param, ParamEnd);) {
      InstantiatingTemplate Inst = null;
      try {
        {
          // If we have an expanded parameter pack, make sure we don't have too
          // many arguments.
          OptionalUInt Expansions = getExpandedPackSize(Param.$star());
          if (Expansions.$bool()) {
            if (Expansions.$star() == ArgumentPack.size()) {
              // We're done with this parameter pack. Pack up its arguments and add
              // them to the list.
              _Converted.push_back(TemplateArgument.CreatePackCopy($this().Context, new ArrayRef<TemplateArgument>(ArgumentPack, false)));
              ArgumentPack.clear();
              
              // This argument is assigned to the next parameter.
              Param.$preInc();
              continue;
            } else if (ArgIdx == NumArgs && !PartialTemplateArgs) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                // Not enough arguments for this parameter pack.
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TemplateLoc), diag.err_template_arg_list_different_arity)), 
                            false), 
                        (isa_ClassTemplateDecl(Template) ? 0 : isa_FunctionTemplateDecl(Template) ? 1 : isa_TemplateTemplateParmDecl(Template) ? 2 : 3)), 
                    Template));
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Template.getLocation(), diag.note_template_decl_here)), 
                    Params.getSourceRange()));
                return true;
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
        if ($less_uint(ArgIdx, NumArgs)) {
          // Check the template argument we were given.
          if ($this().CheckTemplateArgument(Param.$star(), NewArgs.$at(ArgIdx), Template, 
              new SourceLocation(TemplateLoc), new SourceLocation(RAngleLoc), 
              ArgumentPack.size(), _Converted)) {
            return true;
          }
          
          boolean PackExpansionIntoNonPack = NewArgs.$at(ArgIdx).getArgument().isPackExpansion()
             && (!(Param.$star()).isTemplateParameterPack() || getExpandedPackSize(Param.$star()).$bool());
          if (PackExpansionIntoNonPack && isa_TypeAliasTemplateDecl(Template)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              // Core issue 1430: we have a pack expansion as an argument to an
              // alias template, and it's not part of a parameter pack. This
              // can't be canonicalized, so reject it now.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewArgs.$at(ArgIdx).getLocation(), 
                      diag.err_alias_template_expansion_into_fixed_list)), 
                  NewArgs.$at(ArgIdx).getSourceRange()));
              $c$.clean($c$.track($this().Diag((Param.$star()).getLocation(), diag.note_template_param_here)));
              return true;
            } finally {
              $c$.$destroy();
            }
          }
          
          // We're now done with this argument.
          ++ArgIdx;
          if ((Param.$star()).isTemplateParameterPack()) {
            // The template parameter was a template parameter pack, so take the
            // deduced argument and place it on the argument pack. Note that we
            // stay on the same template parameter so that we can deduce more
            // arguments.
            ArgumentPack.push_back(_Converted.pop_back_val());
          } else {
            // Move to the next template parameter.
            Param.$preInc();
          }
          
          // If we just saw a pack expansion into a non-pack, then directly convert
          // the remaining arguments, because we don't know what parameters they'll
          // match up with.
          if (PackExpansionIntoNonPack) {
            if (!ArgumentPack.empty()) {
              // If we were part way through filling in an expanded parameter pack,
              // fall back to just producing individual arguments.
              _Converted.insert$T$value_T(_Converted.end(), 
                  ArgumentPack.begin(), ArgumentPack.end());
              ArgumentPack.clear();
            }
            while ($less_uint(ArgIdx, NumArgs)) {
              _Converted.push_back(NewArgs.$at(ArgIdx).getArgument());
              ++ArgIdx;
            }
            
            return false;
          }
          
          continue;
        }
        
        // If we're checking a partial template argument list, we're done.
        if (PartialTemplateArgs) {
          if ((Param.$star()).isTemplateParameterPack() && !ArgumentPack.empty()) {
            _Converted.push_back(TemplateArgument.CreatePackCopy($this().Context, new ArrayRef<TemplateArgument>(ArgumentPack, false)));
          }
          
          return false;
        }
        
        // If we have a template parameter pack with no more corresponding
        // arguments, just break out now and we'll fill in the argument pack below.
        if ((Param.$star()).isTemplateParameterPack()) {
          assert (!getExpandedPackSize(Param.$star()).$bool()) : "Should have dealt with this already";
          
          // A non-expanded parameter pack before the end of the parameter list
          // only occurs for an ill-formed template parameter list, unless we've
          // got a partial argument list for a function template, so just bail out.
          if ($noteq_ptr(Param.$add(1), ParamEnd)) {
            return true;
          }
          
          _Converted.push_back(TemplateArgument.CreatePackCopy($this().Context, new ArrayRef<TemplateArgument>(ArgumentPack, false)));
          ArgumentPack.clear();
          
          Param.$preInc();
          continue;
        }
        
        // Check whether we have a default argument.
        TemplateArgumentLoc Arg/*J*/= new TemplateArgumentLoc();
        {
          
          // Retrieve the default template argument from the template
          // parameter. For each kind of template parameter, we substitute the
          // template arguments provided thus far and any "outer" template arguments
          // (when the template parameter was part of a nested template) into
          // the default argument.
          TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(Param.$star());
          if ((TTP != null)) {
            if (!$this().hasVisibleDefaultArgument(TTP)) {
              return diagnoseMissingArgument(TemplateTypeParmDecl.class, /*Deref*/$this(), new SourceLocation(TemplateLoc), Template, TTP, 
                  NewArgs);
            }
            
            TypeSourceInfo /*P*/ ArgType = SubstDefaultTemplateArgument1(/*Deref*/$this(), 
                Template, 
                new SourceLocation(TemplateLoc), 
                new SourceLocation(RAngleLoc), 
                TTP, 
                _Converted);
            if (!(ArgType != null)) {
              return true;
            }
            
            Arg.$assignMove(new TemplateArgumentLoc(new TemplateArgument(ArgType.getType()), 
                    ArgType));
          } else {
            NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param.$star());
            if ((NTTP != null)) {
              if (!$this().hasVisibleDefaultArgument(NTTP)) {
                return diagnoseMissingArgument(NonTypeTemplateParmDecl.class, /*Deref*/$this(), new SourceLocation(TemplateLoc), Template, NTTP, 
                    NewArgs);
              }
              
              ActionResultTTrue<Expr /*P*/ > E = SubstDefaultTemplateArgument2(/*Deref*/$this(), Template, 
                  new SourceLocation(TemplateLoc), 
                  new SourceLocation(RAngleLoc), 
                  NTTP, 
                  _Converted);
              if (E.isInvalid()) {
                return true;
              }
              
              Expr /*P*/ Ex = E.getAs(Expr.class);
              Arg.$assignMove(new TemplateArgumentLoc(new TemplateArgument(Ex), Ex));
            } else {
              TemplateTemplateParmDecl /*P*/ TempParm = cast_TemplateTemplateParmDecl(Param.$star());
              if (!$this().hasVisibleDefaultArgument(TempParm)) {
                return diagnoseMissingArgument(TemplateTemplateParmDecl.class, /*Deref*/$this(), new SourceLocation(TemplateLoc), Template, TempParm, 
                    NewArgs);
              }
              
              NestedNameSpecifierLoc QualifierLoc/*J*/= new NestedNameSpecifierLoc();
              TemplateName Name = SubstDefaultTemplateArgument(/*Deref*/$this(), Template, 
                  new SourceLocation(TemplateLoc), 
                  new SourceLocation(RAngleLoc), 
                  TempParm, 
                  _Converted, 
                  QualifierLoc);
              if (Name.isNull()) {
                return true;
              }
              
              Arg.$assignMove(new TemplateArgumentLoc(new TemplateArgument(new TemplateName(Name)), new NestedNameSpecifierLoc(QualifierLoc), 
                      TempParm.getDefaultArgument().getTemplateNameLoc()));
            }
          }
        }
        
        // Introduce an instantiation record that describes where we are using
        // the default template argument.
        Inst/*J*/= new InstantiatingTemplate(JD$Sema_SourceLocation_TemplateDecl$P_NamedDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, /*Deref*/$this(), new SourceLocation(RAngleLoc), Template, Param.$star(), new ArrayRef<TemplateArgument>(_Converted, false), 
            new SourceRange(/*NO_COPY*/TemplateLoc, /*NO_COPY*/RAngleLoc));
        if (Inst.isInvalid()) {
          return true;
        }
        
        // Check the default template argument.
        if ($this().CheckTemplateArgument(Param.$star(), Arg, Template, new SourceLocation(TemplateLoc), 
            new SourceLocation(RAngleLoc), 0, _Converted)) {
          return true;
        }
        
        // Core issue 150 (assumed resolution): if this is a template template
        // parameter, keep track of the default template arguments from the
        // template definition.
        if (isTemplateTemplateParameter) {
          NewArgs.addArgument(Arg);
        }
        
        // Move to the next template parameter and argument.
        Param.$preInc();
        ++ArgIdx;
      } finally {
        if (Inst != null) { Inst.$destroy(); }
      }
    }
    
    // If we're performing a partial argument substitution, allow any trailing
    // pack expansions; they might be empty. This can happen even if
    // PartialTemplateArgs is false (the list of arguments is complete but
    // still dependent).
    if ($less_uint(ArgIdx, NumArgs) && ($this().CurrentInstantiationScope != null)
       && ($this().CurrentInstantiationScope.getPartiallySubstitutedPack() != null)) {
      while ($less_uint(ArgIdx, NumArgs) && NewArgs.$at(ArgIdx).getArgument().isPackExpansion()) {
        _Converted.push_back(NewArgs.$at(ArgIdx++).getArgument());
      }
    }
    
    // If we have any leftover arguments, then there were too many arguments.
    // Complain and fail.
    if ($less_uint(ArgIdx, NumArgs)) {
      return diagnoseArityMismatch(/*Deref*/$this(), Template, new SourceLocation(TemplateLoc), NewArgs);
    }
    
    // No problems found with the new argument list, propagate changes back
    // to caller.
    TemplateArgs.$assignMove(std.move(NewArgs));
    
    return false;
  } finally {
    if (InstScope != null) { InstScope.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateTypeArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 3108,
 FQN="clang::Sema::CheckTemplateTypeArgument", NM="_ZN5clang4Sema25CheckTemplateTypeArgumentEPNS_20TemplateTypeParmDeclERNS_19TemplateArgumentLocERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema25CheckTemplateTypeArgumentEPNS_20TemplateTypeParmDeclERNS_19TemplateArgumentLocERN4llvm15SmallVectorImplINS_16TemplateArgumentEEE")
//</editor-fold>
public final boolean CheckTemplateTypeArgument(TemplateTypeParmDecl /*P*/ Param, 
                         final TemplateArgumentLoc /*&*/ AL, 
                         final SmallVectorImpl<TemplateArgument> /*&*/ _Converted) {
  final /*const*/ TemplateArgument /*&*/ Arg = AL.getArgument();
  QualType ArgType/*J*/= new QualType();
  TypeSourceInfo /*P*/ TSI = null;
  
  // Check template type parameter.
  switch (Arg.getKind()) {
   case Type:
    // C++ [temp.arg.type]p1:
    //   A template-argument for a template-parameter which is a
    //   type shall be a type-id.
    ArgType.$assignMove(Arg.getAsType());
    TSI = AL.getTypeSourceInfo();
    break;
   case Template:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We have a template type parameter but the template argument
        // is a template without any arguments.
        SourceRange SR = AL.getSourceRange();
        TemplateName Name = Arg.getAsTemplate();
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_template_missing_args)), 
                Name), SR));
        {
          TemplateDecl /*P*/ Decl = Name.getAsTemplateDecl();
          if ((Decl != null)) {
            $c$.clean($c$.track($this().Diag(Decl.getLocation(), diag.note_template_decl_here)));
          }
        }
        
        return true;
      } finally {
        $c$.$destroy();
      }
    }
   case Expression:
    {
      CXXScopeSpec SS = null;
      try {
        // We have a template type parameter but the template argument is an
        // expression; see if maybe it is missing the "typename" keyword.
        SS/*J*/= new CXXScopeSpec();
        DeclarationNameInfo NameInfo/*J*/= new DeclarationNameInfo();
        {
          
          DeclRefExpr /*P*/ ArgExpr = dyn_cast_DeclRefExpr(Arg.getAsExpr());
          if ((ArgExpr != null)) {
            SS.Adopt(ArgExpr.getQualifierLoc());
            NameInfo.$assignMove(ArgExpr.getNameInfo());
          } else {
            DependentScopeDeclRefExpr /*P*/ ArgExpr$1 = dyn_cast_DependentScopeDeclRefExpr(Arg.getAsExpr());
            if ((ArgExpr$1 != null)) {
              SS.Adopt(ArgExpr$1.getQualifierLoc());
              NameInfo.$assign(ArgExpr$1.getNameInfo());
            } else {
              CXXDependentScopeMemberExpr /*P*/ ArgExpr$2 = dyn_cast_CXXDependentScopeMemberExpr(Arg.getAsExpr());
              if ((ArgExpr$2 != null)) {
                if (ArgExpr$2.isImplicitAccess()) {
                  SS.Adopt(ArgExpr$2.getQualifierLoc());
                  NameInfo.$assign(ArgExpr$2.getMemberNameInfo());
                }
              }
            }
          }
        }
        {
          
          IdentifierInfo /*P*/ II = NameInfo.getName().getAsIdentifierInfo();
          if ((II != null)) {
            LookupResult Result = null;
            try {
              Result/*J*/= new LookupResult(/*Deref*/$this(), NameInfo, LookupNameKind.LookupOrdinaryName);
              $this().LookupParsedName(Result, $this().CurScope, $AddrOf(SS));
              if ((Result.<TypeDecl>getAsSingle(TypeDecl.class) != null)
                 || Result.getResultKind()
                 == LookupResult.LookupResultKind.NotFoundInCurrentInstantiation) {
                TypeLocBuilder TLB = null;
                JavaCleaner $c$ = $createJavaCleaner();
                try {
                  // Suggest that the user add 'typename' before the NNS.
                  SourceLocation Loc = AL.getSourceRange().getBegin();
                  $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), $this().getLangOpts().MSVCCompat ? diag.ext_ms_template_type_arg_missing_typename : diag.err_template_arg_must_be_type_suggest)), 
                      FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/"typename "))));
                  $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
                  
                  // Recover by synthesizing a type using the location information that we
                  // already have.
                  ArgType.$assignMove(
                      $this().Context.getDependentNameType(ElaboratedTypeKeyword.ETK_Typename, SS.getScopeRep(), II)
                  );
                  TLB/*J*/= new TypeLocBuilder();
                  DependentNameTypeLoc TL = TLB.<DependentNameTypeLoc>push(DependentNameTypeLoc.class, new QualType(ArgType));
                  TL.setElaboratedKeywordLoc(new SourceLocation());
                  TL.setQualifierLoc(SS.getWithLocInContext($this().Context));
                  TL.setNameLoc(NameInfo.getLoc());
                  TSI = TLB.getTypeSourceInfo($this().Context, new QualType(ArgType));
                  
                  // Overwrite our input TemplateArgumentLoc so that we can recover
                  // properly.
                  AL.$assignMove(new TemplateArgumentLoc(new TemplateArgument(new QualType(ArgType)), 
                          new TemplateArgumentLocInfo(TSI)));
                  
                  break;
                } finally {
                  if (TLB != null) { TLB.$destroy(); }
                  $c$.$destroy();
                }
              }
            } finally {
              if (Result != null) { Result.$destroy(); }
            }
          }
        }
      } finally {
        if (SS != null) { SS.$destroy(); }
      }
      // fallthrough
    }
   default:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We have a template type parameter but the template argument
        // is not a type.
        SourceRange SR = AL.getSourceRange();
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_template_arg_must_be_type)), SR));
        $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
        
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ($this().CheckTemplateArgument(Param, TSI)) {
    return true;
  }
  
  // Add the converted template type argument.
  ArgType.$assignMove($this().Context.getCanonicalType(new QualType(ArgType)).$QualType());
  
  // Objective-C ARC:
  //   If an explicitly-specified template argument type is a lifetime type
  //   with no lifetime qualifier, the __strong lifetime qualifier is inferred.
  if ($this().getLangOpts().ObjCAutoRefCount
     && ArgType.$arrow().isObjCLifetimeType()
     && !(ArgType.getObjCLifetime().getValue() != 0)) {
    Qualifiers Qs/*J*/= new Qualifiers();
    Qs.setObjCLifetime(Qualifiers.ObjCLifetime.OCL_Strong);
    ArgType.$assignMove($this().Context.getQualifiedType(new QualType(ArgType), new Qualifiers(Qs)));
  }
  
  _Converted.push_back(new TemplateArgument(new QualType(ArgType)));
  return false;
}


/// \brief Check a template argument against its corresponding
/// template type parameter.
///
/// This routine implements the semantics of C++ [temp.arg.type]. It
/// returns true if an error occurred, and false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4275,
 FQN="clang::Sema::CheckTemplateArgument", NM="_ZN5clang4Sema21CheckTemplateArgumentEPNS_20TemplateTypeParmDeclEPNS_14TypeSourceInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema21CheckTemplateArgumentEPNS_20TemplateTypeParmDeclEPNS_14TypeSourceInfoE")
//</editor-fold>
public final boolean CheckTemplateArgument(TemplateTypeParmDecl /*P*/ Param, 
                     TypeSourceInfo /*P*/ ArgInfo) {
  assert ((ArgInfo != null)) : "invalid TypeSourceInfo";
  QualType Arg = ArgInfo.getType();
  SourceRange SR = ArgInfo.getTypeLoc().getSourceRange();
  if (Arg.$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_variably_modified_template_arg)), Arg).$bool());
    } finally {
      $c$.$destroy();
    }
  } else if ($this().Context.hasSameUnqualifiedType(new QualType(Arg), $this().Context.OverloadTy.$QualType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(SR.getBegin(), diag.err_template_arg_overload_type)), SR).$bool());
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++03 [temp.arg.type]p2:
  //   A local type, a type with no linkage, an unnamed type or a type
  //   compounded from any of these types shall not be used as a
  //   template-argument for a template type-parameter.
  //
  // C++11 allows these, and even in C++03 we allow them as an extension with
  // a warning.
  boolean NeedsCheck;
  if ($this().LangOpts.CPlusPlus11) {
    NeedsCheck
       = !$this().Diags.isIgnored(diag.warn_cxx98_compat_template_arg_unnamed_type, 
        SR.getBegin())
       || !$this().Diags.isIgnored(diag.warn_cxx98_compat_template_arg_local_type, 
        SR.getBegin());
  } else {
    NeedsCheck = Arg.$arrow().hasUnnamedOrLocalType();
  }
  if (NeedsCheck) {
    UnnamedLocalNoLinkageFinder Finder/*J*/= new UnnamedLocalNoLinkageFinder(/*Deref*/$this(), new SourceRange(SR));
    /*J:(void)*/Finder.Visit($this().Context.getCanonicalType(new QualType(Arg)).$QualType());
  }
  
  return false;
}


/// \brief Check a template argument against its corresponding
/// non-type template parameter.
///
/// This routine implements the semantics of C++ [temp.arg.nontype].
/// If an error occurred, it returns ExprError(); otherwise, it
/// returns the converted template argument. \p ParamType is the
/// type of the non-type template parameter after it has been instantiated.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 4896,
 FQN="clang::Sema::CheckTemplateArgument", NM="_ZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckTemplateArgument(NonTypeTemplateParmDecl /*P*/ Param, 
                     QualType ParamType, type$ptr<Expr /*P*/> Arg, 
                     final TemplateArgument /*&*/ _Converted) {
  return CheckTemplateArgument(Param, 
                     ParamType, Arg, 
                     _Converted, 
                     CheckTemplateArgumentKind.CTAK_Specified);
}
public final ActionResultTTrue<Expr /*P*/ > CheckTemplateArgument(NonTypeTemplateParmDecl /*P*/ Param, 
                     QualType ParamType, type$ptr<Expr /*P*/> Arg, 
                     final TemplateArgument /*&*/ _Converted, 
                     CheckTemplateArgumentKind CTAK/*= CTAK_Specified*/) {
  SourceLocation StartLoc = Arg.$star().getLocStart();
  
  // If either the parameter has a dependent type or the argument is
  // type-dependent, there's nothing we can check now.
  if (ParamType.$arrow().isDependentType() || Arg.$star().isTypeDependent()) {
    // FIXME: Produce a cloned, canonical expression?
    _Converted.$assignMove(new TemplateArgument(Arg.$star()));
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
  }
  
  // We should have already dropped all cv-qualifiers by now.
  assert (!ParamType.hasQualifiers()) : "non-type template parameter type cannot be qualified";
  if (CTAK == CheckTemplateArgumentKind.CTAK_Deduced
     && !$this().Context.hasSameUnqualifiedType(new QualType(ParamType), Arg.$star().getType())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++ [temp.deduct.type]p17:
      //   If, in the declaration of a function template with a non-type
      //   template-parameter, the non-type template-parameter is used
      //   in an expression in the function parameter-list and, if the
      //   corresponding template-argument is deduced, the
      //   template-argument type shall match the type of the
      //   template-parameter exactly, except that a template-argument
      //   deduced from an array bound may be of any integral type.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_deduced_non_type_template_arg_type_mismatch)), 
              Arg.$star().getType().getUnqualifiedType()), 
          ParamType.getUnqualifiedType()));
      $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
      return ExprError();
    } finally {
      $c$.$destroy();
    }
  }
  if ($this().getLangOpts().CPlusPlus1z) {
    APValue Value = null;
    try {
      // FIXME: We can do some limited checking for a value-dependent but not
      // type-dependent argument.
      if (Arg.$star().isValueDependent()) {
        _Converted.$assignMove(new TemplateArgument(Arg.$star()));
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
      }
      
      // C++1z [temp.arg.nontype]p1:
      //   A template-argument for a non-type template parameter shall be
      //   a converted constant expression of the type of the template-parameter.
      Value/*J*/= new APValue();
      ActionResultTTrue<Expr /*P*/ > ArgResult = $this().CheckConvertedConstantExpression(Arg.$star(), new QualType(ParamType), Value, CCEKind.CCEK_TemplateArg);
      if (ArgResult.isInvalid()) {
        return ExprError();
      }
      
      QualType CanonParamType = $this().Context.getCanonicalType(new QualType(ParamType)).$QualType();
      
      // Convert the APValue to a TemplateArgument.
      switch (Value.getKind()) {
       case Uninitialized:
        assert (ParamType.$arrow().isNullPtrType());
        _Converted.$assignMove(new TemplateArgument(new QualType(CanonParamType), /*isNullPtr*/ true));
        break;
       case Int:
        assert (ParamType.$arrow().isIntegralOrEnumerationType());
        _Converted.$assignMove(new TemplateArgument($this().Context, Value.getInt(), new QualType(CanonParamType)));
        break;
       case MemberPointer:
        {
          assert (ParamType.$arrow().isMemberPointerType());
          
          // FIXME: We need TemplateArgument representation and mangling for these.
          if (!Value.getMemberPointerPath().empty()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getLocStart(), 
                              diag.err_template_arg_member_ptr_base_derived_not_supported)), 
                          Value.getMemberPointerDecl()), ParamType), 
                  Arg.$star().getSourceRange()));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          
          ValueDecl /*P*/ VD = ((/*const_cast*/ValueDecl /*P*/ )(Value.getMemberPointerDecl()));
          _Converted.$assignMove((VD != null) ? new TemplateArgument(VD, new QualType(CanonParamType)) : new TemplateArgument(new QualType(CanonParamType), /*isNullPtr*/ true));
          break;
        }
       case LValue:
        {
          //   For a non-type template-parameter of pointer or reference type,
          //   the value of the constant expression shall not refer to
          assert (ParamType.$arrow().isPointerType() || ParamType.$arrow().isReferenceType() || ParamType.$arrow().isNullPtrType());
          {
            // -- a temporary object
            // -- a string literal
            // -- the result of a typeid expression, or
            // -- a predefind __func__ variable
            /*const*/ Expr /*P*/ E = Value.getLValueBase().dyn_cast(/*const*/ Expr /*P*/.class);
            if ((E != null)) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                if (isa_CXXUuidofExpr(E)) {
                  _Converted.$assignMove(new TemplateArgument(((/*const_cast*/Expr /*P*/ )(E))));
                  break;
                }
                $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getLocStart(), diag.err_template_arg_not_decl_ref)), 
                    Arg.$star().getSourceRange()));
                return ExprError();
              } finally {
                $c$.$destroy();
              }
            }
          }
          ValueDecl /*P*/ VD = ((/*const_cast*/ValueDecl /*P*/ )(Value.getLValueBase().dyn_cast(/*const*/ ValueDecl /*P*/.class)));
          // -- a subobject
          if (Value.hasLValuePath() && Value.getLValuePath().size() == 1
             && (VD != null) && VD.getType().$arrow().isArrayType()
             && Value.getLValuePath().$at(0).ArrayIndex == 0
             && !Value.isLValueOnePastTheEnd() && ParamType.$arrow().isPointerType()) {
            // Per defect report (no number yet):
            //   ... other than a pointer to the first element of a complete array
            //       object.
          } else if (!Value.hasLValuePath() || (Value.getLValuePath().size() != 0)
             || Value.isLValueOnePastTheEnd()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_non_type_template_arg_subobject)), 
                  Value.getAsString($this().Context, new QualType(ParamType))));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
          assert (((VD != null) || !ParamType.$arrow().isReferenceType())) : "null reference should not be a constant expression";
          assert ((!(VD != null) || !ParamType.$arrow().isNullPtrType())) : "non-null value of type nullptr_t?";
          _Converted.$assignMove((VD != null) ? new TemplateArgument(VD, new QualType(CanonParamType)) : new TemplateArgument(new QualType(CanonParamType), /*isNullPtr*/ true));
          break;
        }
       case AddrLabelDiff:
        {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_non_type_template_arg_addr_label_diff))));
          } finally {
            $c$.$destroy();
          }
        }
       case Float:
       case ComplexInt:
       case ComplexFloat:
       case Vector:
       case Array:
       case Struct:
       case Union:
        throw new llvm_unreachable("invalid kind for template argument");
      }
      
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ArgResult.get());
    } finally {
      if (Value != null) { Value.$destroy(); }
    }
  }
  
  // C++ [temp.arg.nontype]p5:
  //   The following conversions are performed on each expression used
  //   as a non-type template-argument. If a non-type
  //   template-argument cannot be converted to the type of the
  //   corresponding template-parameter then the program is
  //   ill-formed.
  if (ParamType.$arrow().isIntegralOrEnumerationType()) {
    // C++11:
    //   -- for a non-type template-parameter of integral or
    //      enumeration type, conversions permitted in a converted
    //      constant expression are applied.
    //
    // C++98:
    //   -- for a non-type template-parameter of integral or
    //      enumeration type, integral promotions (4.5) and integral
    //      conversions (4.7) are applied.
    if ($this().getLangOpts().CPlusPlus11) {
      // We can't check arbitrary value-dependent arguments.
      // FIXME: If there's no viable conversion to the template parameter type,
      // we should be able to diagnose that prior to instantiation.
      if (Arg.$star().isValueDependent()) {
        _Converted.$assignMove(new TemplateArgument(Arg.$star()));
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
      }
      
      // C++ [temp.arg.nontype]p1:
      //   A template-argument for a non-type, non-template template-parameter
      //   shall be one of:
      //
      //     -- for a non-type template-parameter of integral or enumeration
      //        type, a converted constant expression of the type of the
      //        template-parameter; or
      APSInt Value/*J*/= new APSInt();
      ActionResultTTrue<Expr /*P*/ > ArgResult = $this().CheckConvertedConstantExpression(Arg.$star(), new QualType(ParamType), Value, 
          CCEKind.CCEK_TemplateArg);
      if (ArgResult.isInvalid()) {
        return ExprError();
      }
      
      // Widen the argument value to sizeof(parameter type). This is almost
      // always a no-op, except when the parameter type is bool. In
      // that case, this may extend the argument from 1 bit to 8 bits.
      QualType IntegerType = new QualType(ParamType);
      {
        /*const*/ EnumType /*P*/ Enum = IntegerType.$arrow().getAs$EnumType();
        if ((Enum != null)) {
          IntegerType.$assignMove(Enum.getDecl().getIntegerType());
        }
      }
      Value.$assignMove(Value.extOrTrunc($ulong2uint($this().Context.getTypeSize(new QualType(IntegerType)))));
      
      _Converted.$assignMove(new TemplateArgument($this().Context, Value, 
              $this().Context.getCanonicalType(new QualType(ParamType)).$QualType()));
      return ArgResult;
    }
    
    ActionResultTTrue<Expr /*P*/ > ArgResult = $this().DefaultLvalueConversion(Arg.$star());
    if (ArgResult.isInvalid()) {
      return ExprError();
    }
    Arg.$set(ArgResult.get());
    
    QualType ArgType = Arg.$star().getType();
    
    // C++ [temp.arg.nontype]p1:
    //   A template-argument for a non-type, non-template
    //   template-parameter shall be one of:
    //
    //     -- an integral constant-expression of integral or enumeration
    //        type; or
    //     -- the name of a non-type template-parameter; or
    SourceLocation NonConstantLoc/*J*/= new SourceLocation();
    APSInt Value/*J*/= new APSInt();
    if (!ArgType.$arrow().isIntegralOrEnumerationType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getLocStart(), 
                    diag.err_template_arg_not_integral_or_enumeral)), 
                ArgType), Arg.$star().getSourceRange()));
        $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    } else if (!Arg.$star().isValueDependent()) {
      //<editor-fold defaultstate="collapsed" desc="TmplArgICEDiagnoser">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5110,
       FQN="TmplArgICEDiagnoser", NM="_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEE19TmplArgICEDiagnoser",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEE19TmplArgICEDiagnoser")
      //</editor-fold>
       class TmplArgICEDiagnoser extends /*public*/ VerifyICEDiagnoser implements Destructors.ClassWithDestructor {
        protected/*private*/ QualType T;
      /*public:*/
        //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument(NonTypeTemplateParmDecl * , QualType, Expr * , TemplateArgument & , CheckTemplateArgumentKind)::TmplArgICEDiagnoser::TmplArgICEDiagnoser">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5114,
         FQN="clang::Sema::CheckTemplateArgument(NonTypeTemplateParmDecl * , QualType, Expr * , TemplateArgument & , CheckTemplateArgumentKind)::TmplArgICEDiagnoser::TmplArgICEDiagnoser", NM="_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEEN19TmplArgICEDiagnoserC1ES3_",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEEN19TmplArgICEDiagnoserC1ES3_")
        //</editor-fold>
        public TmplArgICEDiagnoser(QualType T) {
          // : VerifyICEDiagnoser(), T(T) 
          //START JInit
          super();
          this.T = new QualType(T);
          //END JInit
        }


        //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument(NonTypeTemplateParmDecl * , QualType, Expr * , TemplateArgument & , CheckTemplateArgumentKind)::TmplArgICEDiagnoser::diagnoseNotICE">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5116,
         FQN="clang::Sema::CheckTemplateArgument(NonTypeTemplateParmDecl * , QualType, Expr * , TemplateArgument & , CheckTemplateArgumentKind)::TmplArgICEDiagnoser::diagnoseNotICE", NM="_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEEN19TmplArgICEDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEEN19TmplArgICEDiagnoser14diagnoseNotICEERS0_NS_14SourceLocationENS_11SourceRangeE")
        //</editor-fold>
        @Override public void diagnoseNotICE(final Sema /*&*/ S, SourceLocation Loc, 
                      SourceRange SR)/* override*/ {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_template_arg_not_ice)), T), SR));
          } finally {
            $c$.$destroy();
          }
        }

        //<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument(NonTypeTemplateParmDecl * , QualType, Expr * , TemplateArgument & , CheckTemplateArgumentKind)::TmplArgICEDiagnoser::~TmplArgICEDiagnoser">
        @Converted(kind = Converted.Kind.AUTO,
         source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5110,
         FQN="clang::Sema::CheckTemplateArgument(NonTypeTemplateParmDecl * , QualType, Expr * , TemplateArgument & , CheckTemplateArgumentKind)::TmplArgICEDiagnoser::~TmplArgICEDiagnoser", NM="_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEEN19TmplArgICEDiagnoserD0Ev",
         cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZZN5clang4Sema21CheckTemplateArgumentEPNS_23NonTypeTemplateParmDeclENS_8QualTypeEPNS_4ExprERNS_16TemplateArgumentENS0_25CheckTemplateArgumentKindEEN19TmplArgICEDiagnoserD0Ev")
        //</editor-fold>
        @Override public /*inline*/ void $destroy() {
          super.$destroy();
        }


        @Override public String toString() {
          return "" + "T=" + T // NOI18N
                    + super.toString(); // NOI18N
        }
      }
      TmplArgICEDiagnoser Diagnoser = null;
      try {
        Diagnoser/*J*/= new  TmplArgICEDiagnoser(new QualType(ArgType));
        
        Arg.$set($this().VerifyIntegerConstantExpression(Arg.$star(), $AddrOf(Value), Diagnoser, 
            false).get());
        if (!(Arg.$star() != null)) {
          return ExprError();
        }
      } finally {
        if (Diagnoser != null) { Diagnoser.$destroy(); }
      }
    }
    
    // From here on out, all we care about is the unqualified form
    // of the argument type.
    ArgType.$assignMove(ArgType.getUnqualifiedType());
    
    // Try to convert the argument to the parameter's type.
    if ($this().Context.hasSameType(new QualType(ParamType), new QualType(ArgType))) {
      // Okay: no conversion necessary
    } else if (ParamType.$arrow().isBooleanType()) {
      // This is an integral-to-boolean conversion.
      Arg.$set($this().ImpCastExprToType(Arg.$star(), new QualType(ParamType), CastKind.CK_IntegralToBoolean).get());
    } else if ($this().IsIntegralPromotion(Arg.$star(), new QualType(ArgType), new QualType(ParamType))
       || !ParamType.$arrow().isEnumeralType()) {
      // This is an integral promotion or conversion.
      Arg.$set($this().ImpCastExprToType(Arg.$star(), new QualType(ParamType), CastKind.CK_IntegralCast).get());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // We can't perform this conversion.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getLocStart(), 
                        diag.err_template_arg_not_convertible)), 
                    Arg.$star().getType()), ParamType), Arg.$star().getSourceRange()));
        $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
        return ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    
    // Add the value of this argument to the list of converted
    // arguments. We use the bitwidth and signedness of the template
    // parameter.
    if (Arg.$star().isValueDependent()) {
      // The argument is value-dependent. Create a new
      // TemplateArgument with the converted expression.
      _Converted.$assignMove(new TemplateArgument(Arg.$star()));
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
    }
    
    QualType IntegerType = $this().Context.getCanonicalType(new QualType(ParamType)).$QualType();
    {
      /*const*/ EnumType /*P*/ Enum = IntegerType.$arrow().getAs$EnumType();
      if ((Enum != null)) {
        IntegerType.$assignMove($this().Context.getCanonicalType(Enum.getDecl().getIntegerType()).$QualType());
      }
    }
    if (ParamType.$arrow().isBooleanType()) {
      // Value must be zero or one.
      Value.$assign(/*KEEP_BOOL*/Value.$noteq(0));
      /*uint*/int AllowedBits = $ulong2uint($this().Context.getTypeSize(new QualType(IntegerType)));
      if (Value.getBitWidth() != AllowedBits) {
        Value.$assignMove(Value.extOrTrunc(AllowedBits));
      }
      Value.setIsSigned(IntegerType.$arrow().isSignedIntegerOrEnumerationType());
    } else {
      APSInt OldValue = new APSInt(Value);
      
      // Coerce the template argument's value to the value it will have
      // based on the template parameter's type.
      /*uint*/int AllowedBits = $ulong2uint($this().Context.getTypeSize(new QualType(IntegerType)));
      if (Value.getBitWidth() != AllowedBits) {
        Value.$assignMove(Value.extOrTrunc(AllowedBits));
      }
      Value.setIsSigned(IntegerType.$arrow().isSignedIntegerOrEnumerationType());
      
      // Complain if an unsigned parameter received a negative value.
      if (IntegerType.$arrow().isUnsignedIntegerOrEnumerationType()
         && (OldValue.isSigned() && OldValue.isNegative())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getLocStart(), diag.warn_template_arg_negative)), 
                          OldValue.__toString(10)), Value.__toString(10)), Param.getType()), 
              Arg.$star().getSourceRange()));
          $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
        } finally {
          $c$.$destroy();
        }
      }
      
      // Complain if we overflowed the template parameter's type.
      /*uint*/int RequiredBits;
      if (IntegerType.$arrow().isUnsignedIntegerOrEnumerationType()) {
        RequiredBits = OldValue.getActiveBits();
      } else if (OldValue.isUnsigned()) {
        RequiredBits = OldValue.getActiveBits() + 1;
      } else {
        RequiredBits = OldValue.getMinSignedBits();
      }
      if ($greater_uint(RequiredBits, AllowedBits)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getLocStart(), 
                              diag.warn_template_arg_too_large)), 
                          OldValue.__toString(10)), Value.__toString(10)), Param.getType()), 
              Arg.$star().getSourceRange()));
          $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    _Converted.$assignMove(new TemplateArgument($this().Context, Value, 
            ParamType.$arrow().isEnumeralType() ? $this().Context.getCanonicalType(new QualType(ParamType)).$QualType() : new QualType(IntegerType)));
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
  }
  
  QualType ArgType = Arg.$star().getType();
  DeclAccessPair FoundResult/*J*/= new DeclAccessPair(); // temporary for ResolveOverloadedFunction
  
  // Handle pointer-to-function, reference-to-function, and
  // pointer-to-member-function all in (roughly) the same way.
  if ((ParamType.$arrow().isPointerType()
     && ParamType.$arrow().getAs(PointerType.class).getPointeeType().$arrow().isFunctionType())
    // -- For a non-type template-parameter of type reference to
    //    function, no conversions apply. If the template-argument
    //    represents a set of overloaded functions, the matching
    //    function is selected from the set (13.4).
     || (ParamType.$arrow().isReferenceType()
     && ParamType.$arrow().getAs(ReferenceType.class).getPointeeType().$arrow().isFunctionType())
    // -- For a non-type template-parameter of type pointer to
    //    member function, no conversions apply. If the
    //    template-argument represents a set of overloaded member
    //    functions, the matching member function is selected from
    //    the set (13.4).
     || (ParamType.$arrow().isMemberPointerType()
     && ParamType.$arrow().getAs(MemberPointerType.class).getPointeeType().$arrow().
      isFunctionType())) {
    if ($eq_QualType$C(Arg.$star().getType(), $this().Context.OverloadTy.$QualType())) {
      {
        FunctionDecl /*P*/ Fn = $this().ResolveAddressOfOverloadedFunction(Arg.$star(), new QualType(ParamType), 
            true, 
            FoundResult);
        if ((Fn != null)) {
          if ($this().DiagnoseUseOfDecl(Fn, Arg.$star().getLocStart())) {
            return ExprError();
          }
          
          Arg.$set($this().FixOverloadedFunctionReference(Arg.$star(), new DeclAccessPair(FoundResult), Fn));
          ArgType.$assignMove(Arg.$star().getType());
        } else {
          return ExprError();
        }
      }
    }
    if (!ParamType.$arrow().isMemberPointerType()) {
      if (CheckTemplateArgumentAddressOfObjectOrFunction(/*Deref*/$this(), Param, 
          new QualType(ParamType), 
          Arg.$star(), _Converted)) {
        return ExprError();
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
    }
    if (CheckTemplateArgumentPointerToMember(/*Deref*/$this(), Param, new QualType(ParamType), Arg, 
        _Converted)) {
      return ExprError();
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
  }
  if (ParamType.$arrow().isPointerType()) {
    //   -- for a non-type template-parameter of type pointer to
    //      object, qualification conversions (4.4) and the
    //      array-to-pointer conversion (4.2) are applied.
    // C++0x also allows a value of std::nullptr_t.
    assert (ParamType.$arrow().getPointeeType().$arrow().isIncompleteOrObjectType()) : "Only object pointers allowed here";
    if (CheckTemplateArgumentAddressOfObjectOrFunction(/*Deref*/$this(), Param, 
        new QualType(ParamType), 
        Arg.$star(), _Converted)) {
      return ExprError();
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
  }
  {
    
    /*const*/ ReferenceType /*P*/ ParamRefType = ParamType.$arrow().getAs(ReferenceType.class);
    if ((ParamRefType != null)) {
      //   -- For a non-type template-parameter of type reference to
      //      object, no conversions apply. The type referred to by the
      //      reference may be more cv-qualified than the (otherwise
      //      identical) type of the template-argument. The
      //      template-parameter is bound directly to the
      //      template-argument, which must be an lvalue.
      assert (ParamRefType.getPointeeType().$arrow().isIncompleteOrObjectType()) : "Only object references allowed here";
      if ($eq_QualType$C(Arg.$star().getType(), $this().Context.OverloadTy.$QualType())) {
        {
          FunctionDecl /*P*/ Fn = $this().ResolveAddressOfOverloadedFunction(Arg.$star(), 
              ParamRefType.getPointeeType(), 
              true, 
              FoundResult);
          if ((Fn != null)) {
            if ($this().DiagnoseUseOfDecl(Fn, Arg.$star().getLocStart())) {
              return ExprError();
            }
            
            Arg.$set($this().FixOverloadedFunctionReference(Arg.$star(), new DeclAccessPair(FoundResult), Fn));
            ArgType.$assignMove(Arg.$star().getType());
          } else {
            return ExprError();
          }
        }
      }
      if (CheckTemplateArgumentAddressOfObjectOrFunction(/*Deref*/$this(), Param, 
          new QualType(ParamType), 
          Arg.$star(), _Converted)) {
        return ExprError();
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
    }
  }
  
  // Deal with parameters of type std::nullptr_t.
  if (ParamType.$arrow().isNullPtrType()) {
    if (Arg.$star().isTypeDependent() || Arg.$star().isValueDependent()) {
      _Converted.$assignMove(new TemplateArgument(Arg.$star()));
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
    }
    switch (isNullPointerValueTemplateArgument(/*Deref*/$this(), Param, new QualType(ParamType), Arg.$star())) {
     case NPV_NotNullPointer:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Arg.$star().getExprLoc(), diag.err_template_arg_not_convertible)), 
                  Arg.$star().getType()), ParamType));
          $c$.clean($c$.track($this().Diag(Param.getLocation(), diag.note_template_param_here)));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case NPV_Error:
      return ExprError();
     case NPV_NullPointer:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(Arg.$star().getExprLoc(), diag.warn_cxx98_compat_template_arg_null)));
          _Converted.$assignMove(new TemplateArgument($this().Context.getCanonicalType(new QualType(ParamType)).$QualType(), 
                  /*isNullPtr*/ true));
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  //     -- For a non-type template-parameter of type pointer to data
  //        member, qualification conversions (4.4) are applied.
  assert (ParamType.$arrow().isMemberPointerType()) : "Only pointers to members remain";
  if (CheckTemplateArgumentPointerToMember(/*Deref*/$this(), Param, new QualType(ParamType), Arg, 
      _Converted)) {
    return ExprError();
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg.$star());
}


/// \brief Check a template argument against its corresponding
/// template template parameter.
///
/// This routine implements the semantics of C++ [temp.arg.template].
/// It returns true if an error occurred, and false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5355,
 FQN="clang::Sema::CheckTemplateArgument", NM="_ZN5clang4Sema21CheckTemplateArgumentEPNS_24TemplateTemplateParmDeclERNS_19TemplateArgumentLocEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema21CheckTemplateArgumentEPNS_24TemplateTemplateParmDeclERNS_19TemplateArgumentLocEj")
//</editor-fold>
public final boolean CheckTemplateArgument(TemplateTemplateParmDecl /*P*/ Param, 
                     final TemplateArgumentLoc /*&*/ Arg, 
                     /*uint*/int ArgumentPackIndex) {
  TemplateName Name = Arg.getArgument().getAsTemplateOrTemplatePattern();
  TemplateDecl /*P*/ Template = Name.getAsTemplateDecl();
  if (!(Template != null)) {
    // Any dependent template name is fine.
    assert (Name.isDependent()) : "Non-dependent template isn't a declaration?";
    return false;
  }
  
  // C++0x [temp.arg.template]p1:
  //   A template-argument for a template template-parameter shall be
  //   the name of a class template or an alias template, expressed as an
  //   id-expression. When the template-argument names a class template, only
  //   primary class templates are considered when matching the
  //   template template argument with the corresponding parameter;
  //   partial specializations are not considered even if their
  //   parameter lists match that of the template template parameter.
  //
  // Note that we also allow template template parameters here, which
  // will happen when we are dealing with, e.g., class template
  // partial specializations.
  if (!isa_ClassTemplateDecl(Template)
     && !isa_TemplateTemplateParmDecl(Template)
     && !isa_TypeAliasTemplateDecl(Template)
     && !isa_BuiltinTemplateDecl(Template)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      assert (isa_FunctionTemplateDecl(Template)) : "Only function templates are possible here";
      $c$.clean($c$.track($this().Diag(Arg.getLocation(), diag.err_template_arg_not_valid_template)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Template.getLocation(), diag.note_template_arg_refers_here_func)), 
          Template));
    } finally {
      $c$.$destroy();
    }
  }
  
  TemplateParameterList /*P*/ Params = Param.getTemplateParameters();
  if (Param.isExpandedParameterPack()) {
    Params = Param.getExpansionTemplateParameters(ArgumentPackIndex);
  }
  
  return !$this().TemplateParameterListsAreEqual(Template.getTemplateParameters(), 
      Params, 
      true, 
      TemplateParameterListEqualKind.TPL_TemplateTemplateArgumentMatch, 
      Arg.getLocation());
}


/// \brief Given a non-type template argument that refers to a
/// declaration and the type of its corresponding non-type template
/// parameter, produce an expression that properly refers to that
/// declaration.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildExpressionFromDeclTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5404,
 FQN="clang::Sema::BuildExpressionFromDeclTemplateArgument", NM="_ZN5clang4Sema39BuildExpressionFromDeclTemplateArgumentERKNS_16TemplateArgumentENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema39BuildExpressionFromDeclTemplateArgumentERKNS_16TemplateArgumentENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildExpressionFromDeclTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg, 
                                       QualType ParamType, 
                                       SourceLocation Loc) {
  // C++ [temp.param]p8:
  //
  //   A non-type template-parameter of type "array of T" or
  //   "function returning T" is adjusted to be of type "pointer to
  //   T" or "pointer to function returning T", respectively.
  if (ParamType.$arrow().isArrayType()) {
    ParamType.$assignMove($this().Context.getArrayDecayedType(new QualType(ParamType)));
  } else if (ParamType.$arrow().isFunctionType()) {
    ParamType.$assignMove($this().Context.getPointerType(new QualType(ParamType)));
  }
  
  // For a NULL non-type template argument, return nullptr casted to the
  // parameter's type.
  if (Arg.getKind() == TemplateArgument.ArgKind.NullPtr) {
    return $this().ImpCastExprToType(/*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXNullPtrLiteralExpr($this().Context.NullPtrTy.$QualType(), new SourceLocation(Loc))), 
        new QualType(ParamType), 
        (ParamType.$arrow().getAs(MemberPointerType.class) != null) ? CastKind.CK_NullToMemberPointer : CastKind.CK_NullToPointer);
  }
  assert (Arg.getKind() == TemplateArgument.ArgKind.Declaration) : "Only declaration template arguments permitted here";
  
  ValueDecl /*P*/ VD = cast_ValueDecl(Arg.getAsDecl());
  if (VD.getDeclContext().isRecord()
     && (isa_CXXMethodDecl(VD) || isa_FieldDecl(VD)
     || isa_IndirectFieldDecl(VD))) {
    // If the value is a class member, we might have a pointer-to-member.
    // Determine whether the non-type template template parameter is of
    // pointer-to-member type. If so, we need to build an appropriate
    // expression for a pointer-to-member, since a "normal" DeclRefExpr
    // would refer to the member itself.
    if (ParamType.$arrow().isMemberPointerType()) {
      CXXScopeSpec SS = null;
      try {
        QualType ClassType = $this().Context.getTypeDeclType(cast_RecordDecl(VD.getDeclContext()));
        NestedNameSpecifier /*P*/ Qualifier = NestedNameSpecifier.Create($this().Context, (NestedNameSpecifier /*P*/ )null, false, 
            ClassType.getTypePtr());
        SS/*J*/= new CXXScopeSpec();
        SS.MakeTrivial($this().Context, Qualifier, new SourceRange(/*NO_COPY*/Loc));
        
        // The actual value-ness of this is unimportant, but for
        // internal consistency's sake, references to instance methods
        // are r-values.
        ExprValueKind VK = ExprValueKind.VK_LValue;
        if (isa_CXXMethodDecl(VD) && cast_CXXMethodDecl(VD).isInstance()) {
          VK = ExprValueKind.VK_RValue;
        }
        
        ActionResultTTrue<Expr /*P*/ > RefExpr = $this().BuildDeclRefExpr(VD, 
            VD.getType().getNonReferenceType(), 
            VK, 
            new SourceLocation(Loc), 
            $AddrOf(SS));
        if (RefExpr.isInvalid()) {
          return ExprError();
        }
        
        RefExpr.$assignMove($this().CreateBuiltinUnaryOp(new SourceLocation(Loc), UnaryOperatorKind.UO_AddrOf, RefExpr.get()));
        
        // We might need to perform a trailing qualification conversion, since
        // the element type on the parameter could be more qualified than the
        // element type in the expression we constructed.
        bool$ref ObjCLifetimeConversion = create_bool$ref();
        if ($this().IsQualificationConversion(((Expr /*P*/ )RefExpr.get()).getType(), 
            ParamType.getUnqualifiedType(), false, 
            ObjCLifetimeConversion)) {
          RefExpr.$assignMove($this().ImpCastExprToType(RefExpr.get(), ParamType.getUnqualifiedType(), CastKind.CK_NoOp));
        }
        assert (!RefExpr.isInvalid() && $this().Context.hasSameType(((Expr /*P*/ )RefExpr.get()).getType(), ParamType.getUnqualifiedType()));
        return RefExpr;
      } finally {
        if (SS != null) { SS.$destroy(); }
      }
    }
  }
  
  QualType T = VD.getType().getNonReferenceType();
  if (ParamType.$arrow().isPointerType()) {
    // When the non-type template parameter is a pointer, take the
    // address of the declaration.
    ActionResultTTrue<Expr /*P*/ > RefExpr = $this().BuildDeclRefExpr(VD, new QualType(T), ExprValueKind.VK_LValue, new SourceLocation(Loc));
    if (RefExpr.isInvalid()) {
      return ExprError();
    }
    if (T.$arrow().isFunctionType() || T.$arrow().isArrayType()) {
      // Decay functions and arrays.
      RefExpr.$assignMove($this().DefaultFunctionArrayConversion(RefExpr.get()));
      if (RefExpr.isInvalid()) {
        return ExprError();
      }
      
      return RefExpr;
    }
    
    // Take the address of everything else
    return $this().CreateBuiltinUnaryOp(new SourceLocation(Loc), UnaryOperatorKind.UO_AddrOf, RefExpr.get());
  }
  
  ExprValueKind VK = ExprValueKind.VK_RValue;
  {
    
    // If the non-type template parameter has reference type, qualify the
    // resulting declaration reference with the extra qualifiers on the
    // type that the reference refers to.
    /*const*/ ReferenceType /*P*/ TargetRef = ParamType.$arrow().getAs(ReferenceType.class);
    if ((TargetRef != null)) {
      VK = ExprValueKind.VK_LValue;
      T.$assignMove($this().Context.getQualifiedType(new QualType(T), 
              TargetRef.getPointeeType().getQualifiers()));
    } else if (isa_FunctionDecl(VD)) {
      // References to functions are always lvalues.
      VK = ExprValueKind.VK_LValue;
    }
  }
  
  return $this().BuildDeclRefExpr(VD, new QualType(T), VK, new SourceLocation(Loc));
}


/// \brief Construct a new expression that refers to the given
/// integral template argument with the given source-location
/// information.
///
/// This routine takes care of the mapping from an integral template
/// argument (which may have any integral type) to the appropriate
/// literal value.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildExpressionFromIntegralTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5529,
 FQN="clang::Sema::BuildExpressionFromIntegralTemplateArgument", NM="_ZN5clang4Sema43BuildExpressionFromIntegralTemplateArgumentERKNS_16TemplateArgumentENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema43BuildExpressionFromIntegralTemplateArgumentERKNS_16TemplateArgumentENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildExpressionFromIntegralTemplateArgument(final /*const*/ TemplateArgument /*&*/ Arg, 
                                           SourceLocation Loc) {
  assert (Arg.getKind() == TemplateArgument.ArgKind.Integral) : "Operation is only valid for integral template arguments";
  QualType OrigT = Arg.getIntegralType();
  
  // If this is an enum type that we're instantiating, we need to use an integer
  // type the same size as the enumerator.  We don't want to build an
  // IntegerLiteral with enum type.  The integer type of an enum type can be of
  // any integral type with C++11 enum classes, make sure we create the right
  // type of literal for it.
  QualType T = new QualType(OrigT);
  {
    /*const*/ EnumType /*P*/ ET = OrigT.$arrow().getAs$EnumType();
    if ((ET != null)) {
      T.$assignMove(ET.getDecl().getIntegerType());
    }
  }
  
  Expr /*P*/ E;
  if (T.$arrow().isAnyCharacterType()) {
    // This does not need to handle u8 character literals because those are
    // of type char, and so can also be covered by an ASCII character literal.
    CharacterLiteral.CharacterKind Kind;
    if (T.$arrow().isWideCharType()) {
      Kind = CharacterLiteral.CharacterKind.Wide;
    } else if (T.$arrow().isChar16Type()) {
      Kind = CharacterLiteral.CharacterKind.UTF16;
    } else if (T.$arrow().isChar32Type()) {
      Kind = CharacterLiteral.CharacterKind.UTF32;
    } else {
      Kind = CharacterLiteral.CharacterKind.Ascii;
    }
    
    E = /*FIXME:NEW_EXPR*//*new (Context)*/ new CharacterLiteral($ulong2uint(Arg.getAsIntegral().getZExtValue()), 
        Kind, new QualType(T), new SourceLocation(Loc));
  } else if (T.$arrow().isBooleanType()) {
    E = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXBoolLiteralExpr(Arg.getAsIntegral().getBoolValue(), 
        new QualType(T), new SourceLocation(Loc)));
  } else if (T.$arrow().isNullPtrType()) {
    E = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXNullPtrLiteralExpr($this().Context.NullPtrTy.$QualType(), new SourceLocation(Loc)));
  } else {
    E = IntegerLiteral.Create($this().Context, Arg.getAsIntegral(), new QualType(T), new SourceLocation(Loc));
  }
  if (OrigT.$arrow().isEnumeralType()) {
    // FIXME: This is a hack. We need a better way to handle substituted
    // non-type template parameters.
    E = CStyleCastExpr.Create($this().Context, new QualType(OrigT), ExprValueKind.VK_RValue, CastKind.CK_IntegralCast, E, 
        (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
        $this().Context.getTrivialTypeSourceInfo(new QualType(OrigT), new SourceLocation(Loc)), 
        new SourceLocation(Loc), new SourceLocation(Loc));
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}


/// \brief Determine whether the given template parameter lists are
/// equivalent.
///
/// \param New  The new template parameter list, typically written in the
/// source code as part of a new template declaration.
///
/// \param Old  The old template parameter list, typically found via
/// name lookup of the template declared with this template parameter
/// list.
///
/// \param Complain  If true, this routine will produce a diagnostic if
/// the template parameter lists are not equivalent.
///
/// \param Kind describes how we are to match the template parameter lists.
///
/// \param TemplateArgLoc If this source location is valid, then we
/// are actually checking the template parameter list of a template
/// argument (New) against the template parameter list of its
/// corresponding template template parameter (Old). We produce
/// slightly different diagnostics in this scenario.
///
/// \returns True if the template parameter lists are equal, false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::TemplateParameterListsAreEqual">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5730,
 FQN="clang::Sema::TemplateParameterListsAreEqual", NM="_ZN5clang4Sema30TemplateParameterListsAreEqualEPNS_21TemplateParameterListES2_bNS0_30TemplateParameterListEqualKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema30TemplateParameterListsAreEqualEPNS_21TemplateParameterListES2_bNS0_30TemplateParameterListEqualKindENS_14SourceLocationE")
//</editor-fold>
public final boolean TemplateParameterListsAreEqual(TemplateParameterList /*P*/ New, 
                              TemplateParameterList /*P*/ Old, 
                              boolean Complain, 
                              TemplateParameterListEqualKind Kind) {
  return TemplateParameterListsAreEqual(New, 
                              Old, 
                              Complain, 
                              Kind, 
                              new SourceLocation());
}
public final boolean TemplateParameterListsAreEqual(TemplateParameterList /*P*/ New, 
                              TemplateParameterList /*P*/ Old, 
                              boolean Complain, 
                              TemplateParameterListEqualKind Kind, 
                              SourceLocation TemplateArgLoc/*= SourceLocation()*/) {
  if (Old.size() != New.size() && Kind != TemplateParameterListEqualKind.TPL_TemplateTemplateArgumentMatch) {
    if (Complain) {
      DiagnoseTemplateParameterListArityMismatch(/*Deref*/$this(), New, Old, Kind, 
          new SourceLocation(TemplateArgLoc));
    }
    
    return false;
  }
  
  // C++0x [temp.arg.template]p3:
  //   A template-argument matches a template template-parameter (call it P)
  //   when each of the template parameters in the template-parameter-list of
  //   the template-argument's corresponding class template or alias template
  //   (call it A) matches the corresponding template parameter in the
  //   template-parameter-list of P. [...]
  type$ptr<NamedDecl /*P*/ /*P*/> NewParm = $tryClone(New.begin());
  type$ptr<NamedDecl /*P*/ /*P*/> NewParmEnd = $tryClone(New.end());
  for (type$ptr<NamedDecl /*P*/ /*P*/> OldParm = $tryClone(Old.begin()), 
      /*P*/ /*P*/ OldParmEnd = $tryClone(Old.end());
       $noteq_ptr(OldParm, OldParmEnd); OldParm.$preInc()) {
    if (Kind != TemplateParameterListEqualKind.TPL_TemplateTemplateArgumentMatch
       || !(OldParm.$star()).isTemplateParameterPack()) {
      if ($eq_ptr(NewParm, NewParmEnd)) {
        if (Complain) {
          DiagnoseTemplateParameterListArityMismatch(/*Deref*/$this(), New, Old, Kind, 
              new SourceLocation(TemplateArgLoc));
        }
        
        return false;
      }
      if (!MatchTemplateParameterKind(/*Deref*/$this(), NewParm.$star(), OldParm.$star(), Complain, 
          Kind, new SourceLocation(TemplateArgLoc))) {
        return false;
      }
      
      NewParm.$preInc();
      continue;
    }
    
    // C++0x [temp.arg.template]p3:
    //   [...] When P's template- parameter-list contains a template parameter
    //   pack (14.5.3), the template parameter pack will match zero or more
    //   template parameters or template parameter packs in the
    //   template-parameter-list of A with the same type and form as the
    //   template parameter pack in P (ignoring whether those template
    //   parameters are template parameter packs).
    for (; $noteq_ptr(NewParm, NewParmEnd); NewParm.$preInc()) {
      if (!MatchTemplateParameterKind(/*Deref*/$this(), NewParm.$star(), OldParm.$star(), Complain, 
          Kind, new SourceLocation(TemplateArgLoc))) {
        return false;
      }
    }
  }
  
  // Make sure we exhausted all of the arguments.
  if ($noteq_ptr(NewParm, NewParmEnd)) {
    if (Complain) {
      DiagnoseTemplateParameterListArityMismatch(/*Deref*/$this(), New, Old, Kind, 
          new SourceLocation(TemplateArgLoc));
    }
    
    return false;
  }
  
  return true;
}


/// \brief Check whether a template can be declared within this scope.
///
/// If the template declaration is valid in this scope, returns
/// false. Otherwise, issues a diagnostic and returns true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTemplateDeclScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 5803,
 FQN="clang::Sema::CheckTemplateDeclScope", NM="_ZN5clang4Sema22CheckTemplateDeclScopeEPNS_5ScopeEPNS_21TemplateParameterListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema22CheckTemplateDeclScopeEPNS_5ScopeEPNS_21TemplateParameterListE")
//</editor-fold>
public final boolean CheckTemplateDeclScope(Scope /*P*/ S, TemplateParameterList /*P*/ TemplateParams) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!(S != null)) {
      return false;
    }
    
    // Find the nearest enclosing declaration scope.
    while ((S.getFlags() & Scope.ScopeFlags.DeclScope) == 0
       || (S.getFlags() & Scope.ScopeFlags.TemplateParamScope) != 0) {
      S = S.getParent();
    }
    
    // C++ [temp]p4:
    //   A template [...] shall not have C linkage.
    DeclContext /*P*/ Ctx = S.getEntity();
    if ((Ctx != null) && Ctx.isExternCContext()) {
      return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TemplateParams.getTemplateLoc(), diag.err_template_linkage)), 
          TemplateParams.getSourceRange()).$bool());
    }
    while ((Ctx != null) && isa_LinkageSpecDecl(Ctx)) {
      Ctx = Ctx.getParent();
    }
    
    // C++ [temp]p2:
    //   A template-declaration can appear only as a namespace scope or
    //   class scope declaration.
    if ((Ctx != null)) {
      if (Ctx.isFileContext()) {
        return false;
      }
      {
        CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(Ctx);
        if ((RD != null)) {
          // C++ [temp.mem]p2:
          //   A local class shall not have member templates.
          if ((RD.isLocalClass() != null)) {
            return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TemplateParams.getTemplateLoc(), 
                    diag.err_template_inside_local_class)), 
                TemplateParams.getSourceRange()).$bool());
          } else {
            return false;
          }
        }
      }
    }
    
    return $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(TemplateParams.getTemplateLoc(), 
            diag.err_template_outside_namespace_or_class_scope)), 
        TemplateParams.getSourceRange()).$bool());
  } finally {
    $c$.$destroy();
  }
}


/// \brief Called when the parser has parsed a C++ typename
/// specifier, e.g., "typename T::type".
///
/// \param S The scope in which this typename type occurs.
/// \param TypenameLoc the location of the 'typename' keyword
/// \param SS the nested-name-specifier following the typename (e.g., 'T::').
/// \param II the identifier we're retrieving (e.g., 'type' in the example).
/// \param IdLoc the location of the identifier.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypenameType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8141,
 FQN="clang::Sema::ActOnTypenameType", NM="_ZN5clang4Sema17ActOnTypenameTypeEPNS_5ScopeENS_14SourceLocationERKNS_12CXXScopeSpecERKNS_14IdentifierInfoES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema17ActOnTypenameTypeEPNS_5ScopeENS_14SourceLocationERKNS_12CXXScopeSpecERKNS_14IdentifierInfoES3_")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnTypenameType(Scope /*P*/ S, SourceLocation TypenameLoc, 
                 final /*const*/ CXXScopeSpec /*&*/ SS, final /*const*/ IdentifierInfo /*&*/ II, 
                 SourceLocation IdLoc) {
  if (SS.isInvalid()) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
  }
  if (TypenameLoc.isValid() && (S != null) && !(S.getTemplateParamParent() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TypenameLoc), 
              $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_typename_outside_of_template : diag.ext_typename_outside_of_template)), 
          FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TypenameLoc))));
    } finally {
      $c$.$destroy();
    }
  }
  
  NestedNameSpecifierLoc QualifierLoc = SS.getWithLocInContext($this().Context);
  QualType T = $this().CheckTypenameType(TypenameLoc.isValid() ? ElaboratedTypeKeyword.ETK_Typename : ElaboratedTypeKeyword.ETK_None, 
      new SourceLocation(TypenameLoc), new NestedNameSpecifierLoc(QualifierLoc), II, new SourceLocation(IdLoc));
  if (T.isNull()) {
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
  }
  
  TypeSourceInfo /*P*/ TSI = $this().Context.CreateTypeSourceInfo(new QualType(T));
  if (isa_DependentNameType(T)) {
    DependentNameTypeLoc TL = TSI.getTypeLoc().castAs(DependentNameTypeLoc.class);
    TL.setElaboratedKeywordLoc(new SourceLocation(TypenameLoc));
    TL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
    TL.setNameLoc(new SourceLocation(IdLoc));
  } else {
    ElaboratedTypeLoc TL = TSI.getTypeLoc().castAs(ElaboratedTypeLoc.class);
    TL.setElaboratedKeywordLoc(new SourceLocation(TypenameLoc));
    TL.setQualifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
    TL.getNamedTypeLoc().castAs(TypeSpecTypeLoc.class).setNameLoc(new SourceLocation(IdLoc));
  }
  
  return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(T), TSI));
}


/// \brief Called when the parser has parsed a C++ typename
/// specifier that ends in a template-id, e.g.,
/// "typename MetaFun::template apply<T1, T2>".
///
/// \param S The scope in which this typename type occurs.
/// \param TypenameLoc the location of the 'typename' keyword
/// \param SS the nested-name-specifier following the typename (e.g., 'T::').
/// \param TemplateLoc the location of the 'template' keyword, if any.
/// \param TemplateName The template name.
/// \param TemplateNameLoc The location of the template name.
/// \param LAngleLoc The location of the opening angle bracket  ('<').
/// \param TemplateArgs The template arguments.
/// \param RAngleLoc The location of the closing angle bracket  ('>').
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypenameType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8177,
 FQN="clang::Sema::ActOnTypenameType", NM="_ZN5clang4Sema17ActOnTypenameTypeEPNS_5ScopeENS_14SourceLocationERKNS_12CXXScopeSpecES3_NS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema17ActOnTypenameTypeEPNS_5ScopeENS_14SourceLocationERKNS_12CXXScopeSpecES3_NS_9OpaquePtrINS_12TemplateNameEEES3_S3_N4llvm15MutableArrayRefINS_22ParsedTemplateArgumentEEES3_")
//</editor-fold>
public final ActionResult<OpaquePtr<QualType> > ActOnTypenameType(Scope /*P*/ S, 
                 SourceLocation TypenameLoc, 
                 final /*const*/ CXXScopeSpec /*&*/ SS, 
                 SourceLocation TemplateKWLoc, 
                 OpaquePtr<TemplateName> TemplateIn, 
                 SourceLocation TemplateNameLoc, 
                 SourceLocation LAngleLoc, 
                 MutableArrayRef<ParsedTemplateArgument> TemplateArgsIn, 
                 SourceLocation RAngleLoc) {
  TemplateArgumentListInfo TemplateArgs = null;
  TypeLocBuilder Builder = null;
  try {
    if (TypenameLoc.isValid() && (S != null) && !(S.getTemplateParamParent() != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(TypenameLoc), 
                $this().getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_typename_outside_of_template : diag.ext_typename_outside_of_template)), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/TypenameLoc))));
      } finally {
        $c$.$destroy();
      }
    }
    
    // Translate the parser's template argument list in our AST format.
    TemplateArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(LAngleLoc), new SourceLocation(RAngleLoc));
    $this().translateTemplateArguments(TemplateArgsIn, TemplateArgs);
    
    TemplateName Template = TemplateIn.getTemplateName();
    {
      DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
      if ((DTN != null)) {
        TypeLocBuilder Builder$1 = null;
        try {
          // Construct a dependent template specialization type.
          assert ((DTN != null)) : "dependent template has non-dependent name?";
          assert (DTN.getQualifier() == SS.getScopeRep());
          QualType T = $this().Context.getDependentTemplateSpecializationType(ElaboratedTypeKeyword.ETK_Typename, 
              DTN.getQualifier(), 
              DTN.getIdentifier(), 
              TemplateArgs);
          
          // Create source-location information for this type.
          Builder$1/*J*/= new TypeLocBuilder();
          DependentTemplateSpecializationTypeLoc SpecTL = Builder$1.<DependentTemplateSpecializationTypeLoc>push(DependentTemplateSpecializationTypeLoc.class, new QualType(T));
          SpecTL.setElaboratedKeywordLoc(new SourceLocation(TypenameLoc));
          SpecTL.setQualifierLoc(SS.getWithLocInContext($this().Context));
          SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
          SpecTL.setTemplateNameLoc(new SourceLocation(TemplateNameLoc));
          SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
          SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
          for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
            SpecTL.setArgLocInfo(I, TemplateArgs.$at(I).getLocInfo());
          }
          return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(T), Builder$1.getTypeSourceInfo($this().Context, new QualType(T))));
        } finally {
          if (Builder$1 != null) { Builder$1.$destroy(); }
        }
      }
    }
    
    QualType T = $this().CheckTemplateIdType(new TemplateName(Template), new SourceLocation(TemplateNameLoc), TemplateArgs);
    if (T.isNull()) {
      return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, true, new OpaquePtr<QualType>());
    }
    
    // Provide source-location information for the template specialization type.
    Builder/*J*/= new TypeLocBuilder();
    TemplateSpecializationTypeLoc SpecTL = Builder.<TemplateSpecializationTypeLoc>push(TemplateSpecializationTypeLoc.class, new QualType(T));
    SpecTL.setTemplateKeywordLoc(new SourceLocation(TemplateKWLoc));
    SpecTL.setTemplateNameLoc(new SourceLocation(TemplateNameLoc));
    SpecTL.setLAngleLoc(new SourceLocation(LAngleLoc));
    SpecTL.setRAngleLoc(new SourceLocation(RAngleLoc));
    for (/*uint*/int I = 0, N = TemplateArgs.size(); I != N; ++I)  {
      SpecTL.setArgLocInfo(I, TemplateArgs.$at(I).getLocInfo());
    }
    
    T.$assignMove($this().Context.getElaboratedType(ElaboratedTypeKeyword.ETK_Typename, SS.getScopeRep(), new QualType(T)));
    ElaboratedTypeLoc TL = Builder.<ElaboratedTypeLoc>push(ElaboratedTypeLoc.class, new QualType(T));
    TL.setElaboratedKeywordLoc(new SourceLocation(TypenameLoc));
    TL.setQualifierLoc(SS.getWithLocInContext($this().Context));
    
    TypeSourceInfo /*P*/ TSI = Builder.getTypeSourceInfo($this().Context, new QualType(T));
    return new ActionResult<OpaquePtr<QualType> >(JD$T.INSTANCE, $this().CreateParsedType(new QualType(T), TSI));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (TemplateArgs != null) { TemplateArgs.$destroy(); }
  }
}


/// \brief Build the type that describes a C++ typename specifier,
/// e.g., "typename T::type".
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckTypenameType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8286,
 FQN="clang::Sema::CheckTypenameType", NM="_ZN5clang4Sema17CheckTypenameTypeENS_21ElaboratedTypeKeywordENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_14IdentifierInfoES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema17CheckTypenameTypeENS_21ElaboratedTypeKeywordENS_14SourceLocationENS_22NestedNameSpecifierLocERKNS_14IdentifierInfoES2_")
//</editor-fold>
public final QualType CheckTypenameType(ElaboratedTypeKeyword Keyword, 
                 SourceLocation KeywordLoc, 
                 NestedNameSpecifierLoc QualifierLoc, 
                 final /*const*/ IdentifierInfo /*&*/ II, 
                 SourceLocation IILoc) {
  CXXScopeSpec SS = null;
  LookupResult Result = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    SS/*J*/= new CXXScopeSpec();
    SS.Adopt(new NestedNameSpecifierLoc(QualifierLoc));
    
    DeclContext /*P*/ Ctx = $this().computeDeclContext(SS);
    if (!(Ctx != null)) {
      // If the nested-name-specifier is dependent and couldn't be
      // resolved to a type, build a typename type.
      assert (QualifierLoc.getNestedNameSpecifier().isDependent());
      return $this().Context.getDependentNameType(Keyword, 
          QualifierLoc.getNestedNameSpecifier(), 
          $AddrOf(II));
    }
    
    // If the nested-name-specifier refers to the current instantiation,
    // the "typename" keyword itself is superfluous. In C++03, the
    // program is actually ill-formed. However, DR 382 (in C++0x CD1)
    // allows such extraneous "typename" keywords, and we retroactively
    // apply this DR to C++03 code with only a warning. In any case we continue.
    if ($this().RequireCompleteDeclContext(SS, Ctx)) {
      return new QualType();
    }
    
    DeclarationName Name/*J*/= new DeclarationName($AddrOf(II));
    Result/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(IILoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupQualifiedName(Result, Ctx, SS);
    /*uint*/int DiagID = 0;
    Decl /*P*/ Referenced = null;
    switch (Result.getResultKind()) {
     case NotFound:
      {
        // If we're looking up 'type' within a template named 'enable_if', produce
        // a more specific diagnostic.
        SourceRange CondRange/*J*/= new SourceRange();
        if (isEnableIf(new NestedNameSpecifierLoc(QualifierLoc), II, CondRange)) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($c$.track($this().Diag(CondRange.getBegin(), diag.err_typename_nested_not_found_enable_if)), 
                  Ctx), CondRange));
          return new QualType();
        }
        
        DiagID = diag.err_typename_nested_not_found;
        break;
      }
     case FoundUnresolvedValue:
      {
        // We found a using declaration that is a value. Most likely, the using
        // declaration itself is meant to have the 'typename' keyword.
        SourceRange FullRange/*J*/= new SourceRange(KeywordLoc.isValid() ? new SourceLocation(KeywordLoc) : SS.getBeginLoc(), 
            /*NO_COPY*/IILoc);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IILoc), diag.err_typename_refers_to_using_value_decl)), 
                    Name), Ctx), FullRange));
        {
          UnresolvedUsingValueDecl /*P*/ Using = dyn_cast_UnresolvedUsingValueDecl(Result.getRepresentativeDecl());
          if ((Using != null)) {
            SourceLocation Loc = Using.getQualifierLoc().getBeginLoc();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.note_using_value_decl_missing_typename)), 
                FixItHint.CreateInsertion(/*NO_COPY*/Loc, new StringRef(/*KEEP_STR*/"typename "))));
          }
        }
      }
     case NotFoundInCurrentInstantiation:
      // Okay, it's a member of an unknown instantiation.
      return $this().Context.getDependentNameType(Keyword, 
          QualifierLoc.getNestedNameSpecifier(), 
          $AddrOf(II));
     case Found:
      {
        TypeDecl /*P*/ Type = dyn_cast_TypeDecl(Result.getFoundDecl());
        if ((Type != null)) {
          // We found a type. Build an ElaboratedType, since the
          // typename-specifier was just sugar.
          $this().MarkAnyDeclReferenced(Type.getLocation(), Type, /*OdrUse=*/ false);
          return $this().Context.getElaboratedType(ElaboratedTypeKeyword.ETK_Typename, 
              QualifierLoc.getNestedNameSpecifier(), 
              $this().Context.getTypeDeclType(Type));
        }
      }
      
      DiagID = diag.err_typename_nested_not_type;
      Referenced = Result.getFoundDecl();
      break;
     case FoundOverloaded:
      DiagID = diag.err_typename_nested_not_type;
      Referenced = Result.begin().$star();
      break;
     case Ambiguous:
      return new QualType();
    }
    
    // If we get here, it's because name lookup did not find a
    // type. Emit an appropriate diagnostic and return an error.
    SourceRange FullRange/*J*/= new SourceRange(KeywordLoc.isValid() ? new SourceLocation(KeywordLoc) : SS.getBeginLoc(), 
        /*NO_COPY*/IILoc);
    $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(IILoc), DiagID)), FullRange), Name), Ctx));
    if ((Referenced != null)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Referenced.getLocation(), diag.note_typename_refers_here)), 
          Name));
    }
    return new QualType();
  } finally {
    if (Result != null) { Result.$destroy(); }
    if (SS != null) { SS.$destroy(); }
    $c$.$destroy();
  }
}

// end anonymous namespace

/// \brief Rebuilds a type within the context of the current instantiation.
///
/// The type \p T is part of the type of an out-of-line member definition of
/// a class template (or class template partial specialization) that was parsed
/// and constructed before we entered the scope of the class template (or
/// partial specialization thereof). This routine will rebuild that type now
/// that we have entered the declarator's scope, which may produce different
/// canonical types, e.g.,
///
/// \code
/// template<typename T>
/// struct X {
///   typedef T* pointer;
///   pointer data();
/// };
///
/// template<typename T>
/// typename X<T>::pointer X<T>::data() { ... }
/// \endcode
///
/// Here, the type "typename X<T>::pointer" will be created as a DependentNameType,
/// since we do not know that we can look into X<T> when we parsed the type.
/// This function will rebuild the type, performing the lookup of "pointer"
/// in X<T> and returning an ElaboratedType whose canonical type is the same
/// as the canonical type of T*, allowing the return types of the out-of-line
/// definition and the declaration to match.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RebuildTypeInCurrentInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8463,
 FQN="clang::Sema::RebuildTypeInCurrentInstantiation", NM="_ZN5clang4Sema33RebuildTypeInCurrentInstantiationEPNS_14TypeSourceInfoENS_14SourceLocationENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema33RebuildTypeInCurrentInstantiationEPNS_14TypeSourceInfoENS_14SourceLocationENS_15DeclarationNameE")
//</editor-fold>
public final TypeSourceInfo /*P*/ RebuildTypeInCurrentInstantiation(TypeSourceInfo /*P*/ T, 
                                 SourceLocation Loc, 
                                 DeclarationName Name) {
  CurrentInstantiationRebuilder Rebuilder = null;
  try {
    if (!(T != null) || !T.getType().$arrow().isDependentType()) {
      return T;
    }
    
    Rebuilder/*J*/= new CurrentInstantiationRebuilder(/*Deref*/$this(), new SourceLocation(Loc), new DeclarationName(Name));
    return Rebuilder.TransformType(T);
  } finally {
    if (Rebuilder != null) { Rebuilder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::RebuildNestedNameSpecifierInCurrentInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8479,
 FQN="clang::Sema::RebuildNestedNameSpecifierInCurrentInstantiation", NM="_ZN5clang4Sema48RebuildNestedNameSpecifierInCurrentInstantiationERNS_12CXXScopeSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema48RebuildNestedNameSpecifierInCurrentInstantiationERNS_12CXXScopeSpecE")
//</editor-fold>
public final boolean RebuildNestedNameSpecifierInCurrentInstantiation(final CXXScopeSpec /*&*/ SS) {
  CurrentInstantiationRebuilder Rebuilder = null;
  try {
    if (SS.isInvalid()) {
      return true;
    }
    
    NestedNameSpecifierLoc QualifierLoc = SS.getWithLocInContext($this().Context);
    Rebuilder/*J*/= new CurrentInstantiationRebuilder(/*Deref*/$this(), SS.getRange().getBegin(), 
        new DeclarationName());
    NestedNameSpecifierLoc Rebuilt = Rebuilder.TransformNestedNameSpecifierLoc(new NestedNameSpecifierLoc(QualifierLoc));
    if (!Rebuilt.$bool()) {
      return true;
    }
    
    SS.Adopt(new NestedNameSpecifierLoc(Rebuilt));
    return false;
  } finally {
    if (Rebuilder != null) { Rebuilder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::RebuildExprInCurrentInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8473,
 FQN="clang::Sema::RebuildExprInCurrentInstantiation", NM="_ZN5clang4Sema33RebuildExprInCurrentInstantiationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema33RebuildExprInCurrentInstantiationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > RebuildExprInCurrentInstantiation(Expr /*P*/ E) {
  CurrentInstantiationRebuilder Rebuilder = null;
  try {
    Rebuilder/*J*/= new CurrentInstantiationRebuilder(/*Deref*/$this(), E.getExprLoc(), 
        new DeclarationName());
    return Rebuilder.TransformExpr(E);
  } finally {
    if (Rebuilder != null) { Rebuilder.$destroy(); }
  }
}


/// \brief Rebuild the template parameters now that we know we're in a current
/// instantiation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::RebuildTemplateParamsInCurrentInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8497,
 FQN="clang::Sema::RebuildTemplateParamsInCurrentInstantiation", NM="_ZN5clang4Sema43RebuildTemplateParamsInCurrentInstantiationEPNS_21TemplateParameterListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema43RebuildTemplateParamsInCurrentInstantiationEPNS_21TemplateParameterListE")
//</editor-fold>
public final boolean RebuildTemplateParamsInCurrentInstantiation(TemplateParameterList /*P*/ Params) {
  for (/*uint*/int I = 0, N = Params.size(); I != N; ++I) {
    Decl /*P*/ Param = Params.getParam(I);
    
    // There is nothing to rebuild in a type parameter.
    if (isa_TemplateTypeParmDecl(Param)) {
      continue;
    }
    {
      
      // Rebuild the template parameter list of a template template parameter.
      TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Param);
      if ((TTP != null)) {
        if ($this().RebuildTemplateParamsInCurrentInstantiation(TTP.getTemplateParameters())) {
          return true;
        }
        
        continue;
      }
    }
    
    // Rebuild the type of a non-type template parameter.
    NonTypeTemplateParmDecl /*P*/ NTTP = cast_NonTypeTemplateParmDecl(Param);
    TypeSourceInfo /*P*/ NewTSI = $this().RebuildTypeInCurrentInstantiation(NTTP.getTypeSourceInfo(), 
        NTTP.getLocation(), 
        NTTP.getDeclName());
    if (!(NewTSI != null)) {
      return true;
    }
    if (NewTSI != NTTP.getTypeSourceInfo()) {
      NTTP.setTypeSourceInfo(NewTSI);
      NTTP.setType(NewTSI.getType());
    }
  }
  
  return false;
}


/// \brief Produces a formatted string that describes the binding of
/// template parameters to template arguments.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getTemplateArgumentBindingsText">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8536,
 FQN="clang::Sema::getTemplateArgumentBindingsText", NM="_ZN5clang4Sema31getTemplateArgumentBindingsTextEPKNS_21TemplateParameterListERKNS_20TemplateArgumentListE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema31getTemplateArgumentBindingsTextEPKNS_21TemplateParameterListERKNS_20TemplateArgumentListE")
//</editor-fold>
public final std.string getTemplateArgumentBindingsText(/*const*/ TemplateParameterList /*P*/ Params, 
                               final /*const*/ TemplateArgumentList /*&*/ Args) {
  return $this().getTemplateArgumentBindingsText(Params, Args.data(), Args.size());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getTemplateArgumentBindingsText">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp", line = 8542,
 FQN="clang::Sema::getTemplateArgumentBindingsText", NM="_ZN5clang4Sema31getTemplateArgumentBindingsTextEPKNS_21TemplateParameterListEPKNS_16TemplateArgumentEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplate.cpp -nm=_ZN5clang4Sema31getTemplateArgumentBindingsTextEPKNS_21TemplateParameterListEPKNS_16TemplateArgumentEj")
//</editor-fold>
public final std.string getTemplateArgumentBindingsText(/*const*/ TemplateParameterList /*P*/ Params, 
                               /*const*/ type$ptr<TemplateArgument /*P*/> Args, 
                               /*uint*/int NumArgs) {
  raw_svector_ostream Out = null;
  try {
    SmallString/*128*/ Str/*J*/= new SmallString/*128*/(128);
    Out/*J*/= new raw_svector_ostream(Str);
    if (!(Params != null) || Params.size() == 0 || NumArgs == 0) {
      return new std.string();
    }
    
    for (/*uint*/int I = 0, N = Params.size(); I != N; ++I) {
      if ($greatereq_uint(I, NumArgs)) {
        break;
      }
      if (I == 0) {
        Out.$out(/*KEEP_STR*/"[with ");
      } else {
        Out.$out(/*KEEP_STR*/$COMMA_SPACE);
      }
      {
        
        /*const*/ IdentifierInfo /*P*/ Id = Params.getParam$Const(I).getIdentifier();
        if ((Id != null)) {
          Out.$out(Id.getName());
        } else {
          Out.$out_char($$DOLLAR).$out_uint(I);
        }
      }
      
      Out.$out(/*KEEP_STR*/" = ");
      Args.$at(I).print($this().getPrintingPolicy(), Out);
    }
    
    Out.$out_char($$RSQUARE);
    return Out.str().$string();
  } finally {
    if (Out != null) { Out.$destroy(); }
  }
}

} // END OF class Sema_SemaTemplate
