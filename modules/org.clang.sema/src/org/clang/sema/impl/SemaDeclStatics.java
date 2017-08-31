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
package org.clang.sema.impl;

import static org.clank.support.Native.$AddrOf;
import org.clank.java.*;
import org.clank.support.*;
import org.clank.support.aliases.*;
import org.clank.support.JavaDifferentiators.*;
import static org.clank.java.std.*;
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstFunctionPointers.*;
import static org.clang.ast.DeclContext.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaDeclStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaDeclStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL22checkUsingShadowRedeclRN5clang4SemaEPNS_15UsingShadowDeclEPT_;Tpl__ZL23isIncompleteDeclExternCRN5clang4SemaEPKT_;Tpl__ZL28checkGlobalOrExternCConflictRN5clang4SemaEPKT_bRNS_12LookupResultE;Tpl__ZL32haveIncompatibleLanguageLinkagesPKT_S1_;Tpl__ZL34getNoteDiagForInvalidRedeclarationPKT_S1_;Tpl__ZL37checkForConflictWithNonVisibleExternCRN5clang4SemaEPKT_RNS_12LookupResultE;Tpl__ZL9isExternCPT_;_ZL11DeclHasAttrPKN5clang4DeclEPKNS_4AttrE;_ZL11getCoreTypeN5clang8QualTypeE;_ZL11isUsingDeclPN5clang9NamedDeclE;_ZL12hasAttributePKN5clang4DeclENS_4attr4KindE;_ZL13getDefinitionPKN5clang4DeclE;_ZL13getHeaderNameN5clang10ASTContext19GetBuiltinTypeErrorE;_ZL13hasParsedAttrPN5clang5ScopeEPKNS_13AttributeListENS2_4KindE;_ZL13hasParsedAttrPN5clang5ScopeERKNS_10DeclaratorENS_13AttributeList4KindE;_ZL13isDeclExternCPKN5clang4DeclE;_ZL13isMainFileLocRKN5clang4SemaENS_14SourceLocationE;_ZL15ReportOverridesRN5clang4SemaEjPKNS_13CXXMethodDeclEN12_GLOBAL__N_117OverrideErrorKindE;_ZL15buildNestedTypeRN5clang4SemaERNS_12CXXScopeSpecENS_8QualTypeENS_14SourceLocationE;_ZL16CheckPoppedLabelPN5clang9LabelDeclERNS_4SemaE;_ZL16RemoveUsingDeclsRN5clang12LookupResultE;_ZL17mergeAlignedAttrsRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclE;_ZL18ValidDuplicateEnumPN5clang16EnumConstantDeclEPNS_8EnumDeclE;_ZL18mergeDeclAttributeRN5clang4SemaEPNS_9NamedDeclEPKNS_15InheritableAttrENS0_21AvailabilityMergeKindE;_ZL19canRedefineFunctionPKN5clang12FunctionDeclERKNS_11LangOptionsE;_ZL19getMSManglingNumberRKN5clang11LangOptionsEPNS_5ScopeE;_ZL19mergeParamDeclTypesPN5clang11ParmVarDeclEPKS0_RNS_4SemaE;_ZL20getTagInjectionScopePN5clang5ScopeERKNS_11LangOptionsE;_ZL20hasSimilarParametersRN5clang10ASTContextEPNS_12FunctionDeclES3_RN4llvm15SmallVectorImplIjEE;_ZL20isClassCompatTagKindN5clang11TagTypeKindE;_ZL21CreateNewFunctionDeclRN5clang4SemaERNS_10DeclaratorEPNS_11DeclContextERNS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassERb;_ZL21hasDependentAlignmentPN5clang7VarDeclE;_ZL21mergeTypeWithPreviousRN5clang4SemaEPNS_7VarDeclES3_RNS_12LookupResultE;_ZL21shouldConsiderLinkagePKN5clang12FunctionDeclE;_ZL21shouldConsiderLinkagePKN5clang7VarDeclE;_ZL22RebuildLambdaScopeInfoPN5clang13CXXMethodDeclERNS_4SemaE;_ZL22SetNestedNameSpecifierPN5clang14DeclaratorDeclERNS_10DeclaratorE;_ZL22findDefaultInitializerPKN5clang13CXXRecordDeclE;_ZL22getTagInjectionContextPN5clang11DeclContextE;_ZL22isResultTypeOrTemplateRN5clang12LookupResultERKNS_5TokenE;_ZL23TranslateIvarVisibilityN5clang3tok15ObjCKeywordKindE;_ZL23computeShadowedDeclKindPKN5clang9NamedDeclEPKNS_11DeclContextE;_ZL23createFriendTagNNSFixItRN5clang4SemaEPNS_9NamedDeclEPNS_5ScopeENS_14SourceLocationE;_ZL23getFunctionStorageClassRN5clang4SemaERNS_10DeclaratorE;_ZL23isTagTypeWithMissingTagRN5clang4SemaERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecERPNS_14IdentifierInfoENS_14SourceLocationE;_ZL24GenerateFixForUnusedDeclPKN5clang9NamedDeclERNS_10ASTContextERNS_9FixItHintE;_ZL24IsDisallowedCopyOrAssignPKN5clang13CXXMethodDeclE;_ZL24ShouldDiagnoseUnusedDeclPKN5clang9NamedDeclE;_ZL24checkModuleImportContextRN5clang4SemaEPNS_6ModuleENS_14SourceLocationEPNS_11DeclContextEb;_ZL24getRedeclDiagFromTagKindN5clang11TagTypeKindE;_ZL24mergeParamDeclAttributesPN5clang11ParmVarDeclEPKS0_RNS_4SemaE;_ZL25checkDuplicateDefaultInitRN5clang4SemaEPNS_13CXXRecordDeclENS_14SourceLocationE;_ZL25checkDuplicateDefaultInitRN5clang4SemaEPNS_13CXXRecordDeclES3_;_ZL25getNextLargerIntegralTypeRN5clang10ASTContextENS_8QualTypeE;_ZL26AllowOverloadingOfFunctionRN5clang12LookupResultERNS_10ASTContextE;_ZL26checkNewAttributesAfterDefRN5clang4SemaEPNS_4DeclEPKS2_;_ZL27CheckForDuplicateEnumValuesRN5clang4SemaEN4llvm8ArrayRefIPNS_4DeclEEEPNS_8EnumDeclENS_8QualTypeE;_ZL27LookupPredefedObjCSuperTypeRN5clang4SemaEPNS_5ScopeEPNS_14IdentifierInfoE;_ZL27checkAttributesAfterMergingRN5clang4SemaERNS_9NamedDeclE;_ZL27diagnoseVarDeclTypeMismatchRN5clang4SemaEPNS_7VarDeclES3_;_ZL27isRepresentableIntegerValueRN5clang10ASTContextERN4llvm6APSIntENS_8QualTypeE;_ZL28CheckAnonMemberRedeclarationRN5clang4SemaEPNS_5ScopeEPNS_11DeclContextENS_15DeclarationNameENS_14SourceLocationEb;_ZL28DiagnoseInvalidRedeclarationRN5clang4SemaERNS_12LookupResultEPNS_12FunctionDeclERN12_GLOBAL__N_111ActOnFDArgsEbPNS_5ScopeE;_ZL28GetDiagnosticTypeSpecifierIDN5clang17TypeSpecifierTypeE;_ZL28getOpenCLKernelParameterTypeN5clang8QualTypeE;_ZL28isAcceptableTagRedeclContextRN5clang4SemaEPNS_11DeclContextES3_;_ZL28isAttributeTargetADefinitionPN5clang4DeclE;_ZL29isFunctionDefinitionDiscardedRN5clang4SemaEPNS_12FunctionDeclE;_ZL30checkDLLAttributeRedeclarationRN5clang4SemaEPNS_9NamedDeclES3_bb;_ZL31ShouldWarnAboutMissingPrototypePKN5clang12FunctionDeclERS2_;_ZL31hasIdenticalPassObjectSizeAttrsPKN5clang12FunctionDeclES2_;_ZL31isOutOfScopePreviousDeclarationPN5clang9NamedDeclEPNS_11DeclContextERNS_10ASTContextE;_ZL31lookupUnqualifiedTypeNameInBaseRN5clang4SemaERKNS_14IdentifierInfoENS_14SourceLocationEPKNS_13CXXRecordDeclE;_ZL33FixInvalidVariablyModifiedTypeLocN5clang7TypeLocES0_;_ZL33checkIsValidOpenCLKernelParameterRN5clang4SemaERNS_10DeclaratorEPNS_11ParmVarDeclERN4llvm15SmallPtrSetImplIPKNS_4TypeEEE;_ZL35InjectAnonymousStructOrUnionMembersRN5clang4SemaEPNS_5ScopeEPNS_11DeclContextEPNS_10RecordDeclENS_15AccessSpecifierERN4llvm15SmallVectorImplIPNS_9NamedDeclEEE;_ZL35TryToFixInvalidVariablyModifiedTypeN5clang8QualTypeERNS_10ASTContextERbRN4llvm6APSIntE;_ZL35recoverFromTypeInKnownDependentBaseRN5clang4SemaERKNS_14IdentifierInfoENS_14SourceLocationE;_ZL36synthesizeCurrentNestedNameSpecifierRN5clang10ASTContextEPNS_11DeclContextE;_ZL37StorageClassSpecToVarDeclStorageClassRKN5clang8DeclSpecE;_ZL39RebuildDeclaratorInCurrentInstantiationRN5clang4SemaERNS_10DeclaratorENS_15DeclarationNameE;_ZL40filterNonConflictingPreviousTypedefDeclsRN5clang4SemaEPNS_15TypedefNameDeclERNS_12LookupResultE;_ZL45TryToFixInvalidVariablyModifiedTypeSourceInfoPN5clang14TypeSourceInfoERNS_10ASTContextERbRN4llvm6APSIntE;_ZL45findRecordWithDependentBasesOfEnclosingMethodPKN5clang11DeclContextE;_ZL9isExternCPN5clang15VarTemplateDeclE;_ZN12_GLOBAL__N_1L18CheckSelfReferenceERN5clang4SemaEPNS0_4DeclEPNS0_4ExprEb;_ZN12_GLOBAL__N_1L9GetDupKeyERKN4llvm6APSIntE; -static-type=SemaDeclStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaDeclStatics {

// end anonymous namespace

/// \brief Tries to perform unqualified lookup of the type decls in bases for
/// dependent class.
/// \return \a NotFound if no any decls is found, \a FoundNotType if found not a
/// type decl, \a FoundType if only type decls are found.
//<editor-fold defaultstate="collapsed" desc="lookupUnqualifiedTypeNameInBase">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 145,
 FQN="lookupUnqualifiedTypeNameInBase", NM="_ZL31lookupUnqualifiedTypeNameInBaseRN5clang4SemaERKNS_14IdentifierInfoENS_14SourceLocationEPKNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL31lookupUnqualifiedTypeNameInBaseRN5clang4SemaERKNS_14IdentifierInfoENS_14SourceLocationEPKNS_13CXXRecordDeclE")
//</editor-fold>
public static UnqualifiedTypeNameLookupResult lookupUnqualifiedTypeNameInBase(final Sema /*&*/ S, final /*const*/ IdentifierInfo /*&*/ II, 
                               SourceLocation NameLoc, 
                               /*const*/ CXXRecordDecl /*P*/ RD) {
  if (!RD.hasDefinition()) {
    return UnqualifiedTypeNameLookupResult.NotFound;
  }
  // Look for type decls in base classes.
  UnqualifiedTypeNameLookupResult FoundTypeDecl = UnqualifiedTypeNameLookupResult.NotFound;
  for (final /*const*/ CXXBaseSpecifier /*&*/ Base : RD.bases$Const()) {
    /*const*/ CXXRecordDecl /*P*/ BaseRD = null;
    {
      /*const*/ TagType /*P*/ BaseTT = Base.getType().$arrow().getAs(TagType.class);
      if ((BaseTT != null)) {
        BaseRD = BaseTT.getAsCXXRecordDecl();
      } else {
        /*const*/ TemplateSpecializationType /*P*/ TST = Base.getType().$arrow().<TemplateSpecializationType>getAs$TemplateSpecializationType();
        if ((TST != null)) {
          // Look for type decls in dependent base classes that have known primary
          // templates.
          if (!(TST != null) || !TST.isDependentType()) {
            continue;
          }
          TemplateDecl /*P*/ TD = TST.getTemplateName().getAsTemplateDecl();
          if (!(TD != null)) {
            continue;
          }
          {
            CXXRecordDecl /*P*/ BasePrimaryTemplate = dyn_cast_or_null_CXXRecordDecl(TD.getTemplatedDecl());
            if ((BasePrimaryTemplate != null)) {
              if (BasePrimaryTemplate.getCanonicalDecl() != RD.getCanonicalDecl$Const()) {
                BaseRD = BasePrimaryTemplate;
              } else {
                ClassTemplateDecl /*P*/ CTD = dyn_cast_ClassTemplateDecl(TD);
                if ((CTD != null)) {
                  {
                    /*const*/ ClassTemplatePartialSpecializationDecl /*P*/ PS = CTD.findPartialSpecialization(Base.getType());
                    if ((PS != null)) {
                      if (PS.getCanonicalDecl$Const() != RD.getCanonicalDecl$Const()) {
                        BaseRD = PS;
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    if ((BaseRD != null)) {
      for (NamedDecl /*P*/ ND : BaseRD.lookup(new DeclarationName($AddrOf(II)))) {
        if (!isa_TypeDecl(ND)) {
          return UnqualifiedTypeNameLookupResult.FoundNonType;
        }
        FoundTypeDecl = UnqualifiedTypeNameLookupResult.FoundType;
      }
      if (FoundTypeDecl == UnqualifiedTypeNameLookupResult.NotFound) {
        switch (/*UnqualifiedTypeNameLookupResult.valueOf(*/lookupUnqualifiedTypeNameInBase(S, II, new SourceLocation(NameLoc), BaseRD)/*)*/) {
         case FoundNonType:
          return UnqualifiedTypeNameLookupResult.FoundNonType;
         case FoundType:
          FoundTypeDecl = UnqualifiedTypeNameLookupResult.FoundType;
          break;
         case NotFound:
          break;
        }
      }
    }
  }
  
  return FoundTypeDecl;
}

//<editor-fold defaultstate="collapsed" desc="recoverFromTypeInKnownDependentBase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 201,
 FQN="recoverFromTypeInKnownDependentBase", NM="_ZL35recoverFromTypeInKnownDependentBaseRN5clang4SemaERKNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL35recoverFromTypeInKnownDependentBaseRN5clang4SemaERKNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public static OpaquePtr<QualType> recoverFromTypeInKnownDependentBase(final Sema /*&*/ S, 
                                   final /*const*/ IdentifierInfo /*&*/ II, 
                                   SourceLocation NameLoc) {
  CXXScopeSpec SS = null;
  TypeLocBuilder Builder = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Lookup in the parent class template context, if any.
    /*const*/ CXXRecordDecl /*P*/ RD = null;
    UnqualifiedTypeNameLookupResult FoundTypeDecl = UnqualifiedTypeNameLookupResult.NotFound;
    for (DeclContext /*P*/ DC = S.CurContext;
         (DC != null) && FoundTypeDecl == UnqualifiedTypeNameLookupResult.NotFound;
         DC = DC.getParent()) {
      // Look for type decls in dependent base classes that have known primary
      // templates.
      RD = dyn_cast_CXXRecordDecl(DC);
      if ((RD != null) && (RD.getDescribedClassTemplate() != null)) {
        FoundTypeDecl = lookupUnqualifiedTypeNameInBase(S, II, new SourceLocation(NameLoc), RD);
      }
    }
    if (FoundTypeDecl != UnqualifiedTypeNameLookupResult.FoundType) {
      return new OpaquePtr<QualType>(null);
    }
    
    // We found some types in dependent base classes.  Recover as if the user
    // wrote 'typename MyClass::II' instead of 'II'.  We'll fully resolve the
    // lookup during template instantiation.
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(NameLoc), diag.ext_found_via_dependent_bases_lookup)), $AddrOf(II)));
    
    final ASTContext /*&*/ Context = S.Context;
    NestedNameSpecifier /*P*/ NNS = NestedNameSpecifier.Create(Context, (NestedNameSpecifier /*P*/ )null, false, 
        cast_Type(Context.getRecordType(RD)));
    QualType T = Context.getDependentNameType(ElaboratedTypeKeyword.ETK_Typename, NNS, $AddrOf(II));
    
    SS/*J*/= new CXXScopeSpec();
    SS.MakeTrivial(Context, NNS, new SourceRange(/*NO_COPY*/NameLoc));
    
    Builder/*J*/= new TypeLocBuilder();
    DependentNameTypeLoc DepTL = Builder.push(DependentNameTypeLoc.class, new QualType(T));
    DepTL.setNameLoc(new SourceLocation(NameLoc));
    DepTL.setElaboratedKeywordLoc(new SourceLocation());
    DepTL.setQualifierLoc(SS.getWithLocInContext(Context));
    return S.CreateParsedType(new QualType(T), Builder.getTypeSourceInfo(Context, new QualType(T)));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (SS != null) { SS.$destroy(); }
    $c$.$destroy();
  }
}


// Builds a fake NNS for the given decl context.
//<editor-fold defaultstate="collapsed" desc="synthesizeCurrentNestedNameSpecifier">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 466,
 FQN="synthesizeCurrentNestedNameSpecifier", NM="_ZL36synthesizeCurrentNestedNameSpecifierRN5clang10ASTContextEPNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL36synthesizeCurrentNestedNameSpecifierRN5clang10ASTContextEPNS_11DeclContextE")
//</editor-fold>
public static NestedNameSpecifier /*P*/ synthesizeCurrentNestedNameSpecifier(final ASTContext /*&*/ Context, DeclContext /*P*/ DC) {
  for (;; DC = DC.getLookupParent()) {
    DC = DC.getPrimaryContext();
    NamespaceDecl /*P*/ ND = dyn_cast_NamespaceDecl(DC);
    if ((ND != null) && !ND.isInline() && !ND.isAnonymousNamespace()) {
      return NestedNameSpecifier.Create(Context, (NestedNameSpecifier /*P*/ )null, ND);
    } else {
      CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(DC);
      if ((RD != null)) {
        return NestedNameSpecifier.Create(Context, (NestedNameSpecifier /*P*/ )null, RD.isTemplateDecl(), 
            RD.getTypeForDecl());
      } else if (isa_TranslationUnitDecl(DC)) {
        return NestedNameSpecifier.GlobalSpecifier(Context);
      }
    }
  }
  //throw new llvm_unreachable("something isn't in TU scope?");
}


/// Find the parent class with dependent bases of the innermost enclosing method
/// context. Do not look for enclosing CXXRecordDecls directly, or we will end
/// up allowing unqualified dependent type names at class-level, which MSVC
/// correctly rejects.
//<editor-fold defaultstate="collapsed" desc="findRecordWithDependentBasesOfEnclosingMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 486,
 FQN="findRecordWithDependentBasesOfEnclosingMethod", NM="_ZL45findRecordWithDependentBasesOfEnclosingMethodPKN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL45findRecordWithDependentBasesOfEnclosingMethodPKN5clang11DeclContextE")
//</editor-fold>
public static /*const*/ CXXRecordDecl /*P*/ findRecordWithDependentBasesOfEnclosingMethod(/*const*/ DeclContext /*P*/ DC) {
  for (; (DC != null) && DC.isDependentContext(); DC = DC.getLookupParent$Const()) {
    DC = DC.getPrimaryContext$Const();
    {
      /*const*/ CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(DC);
      if ((MD != null)) {
        if (MD.getParent$Const().hasAnyDependentBases()) {
          return MD.getParent$Const();
        }
      }
    }
  }
  return null;
}


/// \brief Determine whether the given result set contains either a type name
/// or
//<editor-fold defaultstate="collapsed" desc="isResultTypeOrTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 695,
 FQN="isResultTypeOrTemplate", NM="_ZL22isResultTypeOrTemplateRN5clang12LookupResultERKNS_5TokenE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL22isResultTypeOrTemplateRN5clang12LookupResultERKNS_5TokenE")
//</editor-fold>
public static boolean isResultTypeOrTemplate(final LookupResult /*&*/ R, final /*const*/ Token /*&*/ NextToken) {
  boolean CheckTemplate = R.getSema().getLangOpts().CPlusPlus
     && NextToken.is(tok.TokenKind.less);
  
  for (UnresolvedSetIterator I = R.begin(), IEnd = R.end(); I.$noteq(IEnd); I.$preInc()) {
    if (isa_TypeDecl(I.$star()) || isa_ObjCInterfaceDecl(I.$star())) {
      return true;
    }
    if (CheckTemplate && isa_TemplateDecl(I.$star())) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isTagTypeWithMissingTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 710,
 FQN="isTagTypeWithMissingTag", NM="_ZL23isTagTypeWithMissingTagRN5clang4SemaERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecERPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL23isTagTypeWithMissingTagRN5clang4SemaERNS_12LookupResultEPNS_5ScopeERNS_12CXXScopeSpecERPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public static boolean isTagTypeWithMissingTag(final Sema /*&*/ SemaRef, final LookupResult /*&*/ Result, 
                       Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                       final type$ref<IdentifierInfo> Name, 
                       SourceLocation NameLoc) {
  LookupResult R = null;
  try {
    R/*J*/= new LookupResult(SemaRef, new DeclarationName(Name.$deref()), new SourceLocation(NameLoc), Sema.LookupNameKind.LookupTagName);
    SemaRef.LookupParsedName(R, S, $AddrOf(SS));
    {
      TagDecl /*P*/ Tag = R.<TagDecl>getAsSingle(TagDecl.class);
      if ((Tag != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          StringRef FixItTagName/*J*/= new StringRef();
          switch (Tag.getTagKind()) {
           case TTK_Class:
            FixItTagName.$assignMove(/*STRINGREF_STR*/"class ");
            break;
           case TTK_Enum:
            FixItTagName.$assignMove(/*STRINGREF_STR*/"enum ");
            break;
           case TTK_Struct:
            FixItTagName.$assignMove(/*STRINGREF_STR*/"struct ");
            break;
           case TTK_Interface:
            FixItTagName.$assignMove(/*STRINGREF_STR*/"__interface ");
            break;
           case TTK_Union:
            FixItTagName.$assignMove(/*STRINGREF_STR*/"union ");
            break;
          }
          
          StringRef TagName = FixItTagName.drop_back();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_II($c$.track(SemaRef.Diag(new SourceLocation(NameLoc), diag.err_use_of_tag_name_without_tag)), 
                          Name), TagName), SemaRef.getLangOpts().CPlusPlus), 
              FixItHint.CreateInsertion(/*NO_COPY*/NameLoc, /*NO_COPY*/FixItTagName)));
          
          for (UnresolvedSetIterator I = Result.begin(), IEnd = Result.end();
               I.$noteq(IEnd); I.$preInc())  {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_II($c$.track(SemaRef.Diag((I.$star()).getLocation(), diag.note_decl_hiding_tag_type)), 
                    Name), TagName));
          }
          
          // Replace lookup results with just the tag decl.
          Result.clear(Sema.LookupNameKind.LookupTagName);
          SemaRef.LookupParsedName(Result, S, $AddrOf(SS));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    return false;
  } finally {
    if (R != null) { R.$destroy(); }
  }
}


/// Build a ParsedType for a simple-type-specifier with a nested-name-specifier.
//<editor-fold defaultstate="collapsed" desc="buildNestedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 760,
 FQN="buildNestedType", NM="_ZL15buildNestedTypeRN5clang4SemaERNS_12CXXScopeSpecENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL15buildNestedTypeRN5clang4SemaERNS_12CXXScopeSpecENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public static OpaquePtr<QualType> buildNestedType(final Sema /*&*/ S, final CXXScopeSpec /*&*/ SS, 
               QualType T, SourceLocation NameLoc) {
  TypeLocBuilder Builder = null;
  try {
    final ASTContext /*&*/ Context = S.Context;
    
    Builder/*J*/= new TypeLocBuilder();
    Builder.pushTypeSpec(new QualType(T)).setNameLoc(new SourceLocation(NameLoc));
    
    T.$assignMove(S.getElaboratedType(ElaboratedTypeKeyword.ETK_None, SS, new QualType(T)));
    ElaboratedTypeLoc ElabTL = Builder.push(ElaboratedTypeLoc.class, new QualType(T));
    ElabTL.setElaboratedKeywordLoc(new SourceLocation());
    ElabTL.setQualifierLoc(SS.getWithLocInContext(Context));
    return S.CreateParsedType(new QualType(T), Builder.getTypeSourceInfo(Context, new QualType(T)));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}


/// \brief Determine whether we allow overloading of the function
/// PrevDecl with another declaration.
///
/// This routine determines whether overloading is possible, not
/// whether some new function is actually an overload. It will return
/// true in C++ (where we can always provide overloads) or, as an
/// extension, in C when the previous function is already an
/// overloaded function declaration or has the "overloadable"
/// attribute.
//<editor-fold defaultstate="collapsed" desc="AllowOverloadingOfFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1231,
 FQN="AllowOverloadingOfFunction", NM="_ZL26AllowOverloadingOfFunctionRN5clang12LookupResultERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL26AllowOverloadingOfFunctionRN5clang12LookupResultERNS_10ASTContextE")
//</editor-fold>
public static boolean AllowOverloadingOfFunction(final LookupResult /*&*/ Previous, 
                          final ASTContext /*&*/ Context) {
  if (Context.getLangOpts().CPlusPlus) {
    return true;
  }
  if (Previous.getResultKind() == LookupResult.LookupResultKind.FoundOverloaded) {
    return true;
  }
  
  return (Previous.getResultKind() == LookupResult.LookupResultKind.Found
     && Previous.getFoundDecl().hasAttr(OverloadableAttr.class));
}


/// \brief Determines whether the given declaration is an out-of-scope
/// previous declaration.
///
/// This routine should be invoked when name lookup has found a
/// previous declaration (PrevDecl) that is not in the scope where a
/// new declaration by the same name is being introduced. If the new
/// declaration occurs in a local scope, previous declarations with
/// linkage may still be considered previous declarations (C99
/// 6.2.2p4-5, C++ [basic.link]p6).
///
/// \param PrevDecl the previous declaration found by name
/// lookup
///
/// \param DC the context in which the new declaration is being
/// declared.
///
/// \returns true if PrevDecl is an out-of-scope previous declaration
/// for a new delcaration with the same name.
//<editor-fold defaultstate="collapsed" desc="isOutOfScopePreviousDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5441,
 FQN="isOutOfScopePreviousDeclaration", NM="_ZL31isOutOfScopePreviousDeclarationPN5clang9NamedDeclEPNS_11DeclContextERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL31isOutOfScopePreviousDeclarationPN5clang9NamedDeclEPNS_11DeclContextERNS_10ASTContextE")
//</editor-fold>
public static boolean isOutOfScopePreviousDeclaration(NamedDecl /*P*/ PrevDecl, DeclContext /*P*/ DC, 
                               final ASTContext /*&*/ Context) {
  if (!(PrevDecl != null)) {
    return false;
  }
  if (!PrevDecl.hasLinkage()) {
    return false;
  }
  if (Context.getLangOpts().CPlusPlus) {
    // C++ [basic.link]p6:
    //   If there is a visible declaration of an entity with linkage
    //   having the same name and type, ignoring entities declared
    //   outside the innermost enclosing namespace scope, the block
    //   scope declaration declares that same entity and receives the
    //   linkage of the previous declaration.
    DeclContext /*P*/ OuterContext = DC.getRedeclContext();
    if (!OuterContext.isFunctionOrMethod()) {
      // This rule only applies to block-scope declarations.
      return false;
    }
    
    DeclContext /*P*/ PrevOuterContext = PrevDecl.getDeclContext();
    if (PrevOuterContext.isRecord()) {
      // We found a member function: ignore it.
      return false;
    }
    
    // Find the innermost enclosing namespace for the new and
    // previous declarations.
    OuterContext = OuterContext.getEnclosingNamespaceContext();
    PrevOuterContext = PrevOuterContext.getEnclosingNamespaceContext();
    
    // The previous declaration is in a different namespace, so it
    // isn't the same function.
    if (!OuterContext.Equals(PrevOuterContext)) {
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isUsingDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1350,
 FQN="isUsingDecl", NM="_ZL11isUsingDeclPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL11isUsingDeclPN5clang9NamedDeclE")
//</editor-fold>
public static boolean isUsingDecl(NamedDecl /*P*/ D) {
  return isa_UsingShadowDecl(D)
     || isa_UnresolvedUsingTypenameDecl(D)
     || isa_UnresolvedUsingValueDecl(D);
}


/// Removes using shadow declarations from the lookup results.
//<editor-fold defaultstate="collapsed" desc="RemoveUsingDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1357,
 FQN="RemoveUsingDecls", NM="_ZL16RemoveUsingDeclsRN5clang12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL16RemoveUsingDeclsRN5clang12LookupResultE")
//</editor-fold>
public static void RemoveUsingDecls(final LookupResult /*&*/ R) {
  LookupResult.Filter F = null;
  try {
    F = R.makeFilter();
    while (F.hasNext()) {
      if (isUsingDecl(F.next())) {
        F.erase();
      }
    }
    
    F.done();
  } finally {
    if (F != null) { F.$destroy(); }
  }
}


/// \brief Check for this common pattern:
/// @code
/// class S {
///   S(const S&); // DO NOT IMPLEMENT
///   void operator=(const S&); // DO NOT IMPLEMENT
/// };
/// @endcode
//<editor-fold defaultstate="collapsed" desc="IsDisallowedCopyOrAssign">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1373,
 FQN="IsDisallowedCopyOrAssign", NM="_ZL24IsDisallowedCopyOrAssignPKN5clang13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL24IsDisallowedCopyOrAssignPKN5clang13CXXMethodDeclE")
//</editor-fold>
public static boolean IsDisallowedCopyOrAssign(/*const*/ CXXMethodDecl /*P*/ D) {
  // FIXME: Should check for private access too but access is set after we get
  // the decl here.
  if (D.doesThisDeclarationHaveABody()) {
    return false;
  }
  {
    
    /*const*/ CXXConstructorDecl /*P*/ CD = dyn_cast_CXXConstructorDecl(D);
    if ((CD != null)) {
      return CD.isCopyConstructor();
    }
  }
  {
    /*const*/ CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(D);
    if ((Method != null)) {
      return Method.isCopyAssignmentOperator();
    }
  }
  return false;
}


// FIXME: This needs to be refactored; some other isInMainFile users want
// these semantics.
//<editor-fold defaultstate="collapsed" desc="isMainFileLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1413,
 FQN="isMainFileLoc", NM="_ZL13isMainFileLocRKN5clang4SemaENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL13isMainFileLocRKN5clang4SemaENS_14SourceLocationE")
//</editor-fold>
public static boolean isMainFileLoc(final /*const*/ Sema /*&*/ S, SourceLocation Loc) {
  if (S.TUKind != TranslationUnitKind.TU_Complete) {
    return false;
  }
  return S.SourceMgr.isInMainFile(/*NO_COPY*/Loc);
}

//<editor-fold defaultstate="collapsed" desc="ShouldDiagnoseUnusedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1493,
 FQN="ShouldDiagnoseUnusedDecl", NM="_ZL24ShouldDiagnoseUnusedDeclPKN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL24ShouldDiagnoseUnusedDeclPKN5clang9NamedDeclE")
//</editor-fold>
public static boolean ShouldDiagnoseUnusedDecl(/*const*/ NamedDecl /*P*/ D) {
  if (D.isInvalidDecl()) {
    return false;
  }
  if (D.isReferenced() || D.isUsed() || D.hasAttr(UnusedAttr.class)
     || D.hasAttr(ObjCPreciseLifetimeAttr.class)) {
    return false;
  }
  if (isa_LabelDecl(D)) {
    return true;
  }
  
  // Except for labels, we only care about unused decls that are local to
  // functions.
  boolean WithinFunction = D.getDeclContext$Const().isFunctionOrMethod();
  {
    /*const*/ CXXRecordDecl /*P*/ R = dyn_cast_CXXRecordDecl(D.getDeclContext$Const());
    if ((R != null)) {
      // For dependent types, the diagnostic is deferred.
      WithinFunction
         = WithinFunction || ((R.isLocalClass$Const() != null) && !R.isDependentType());
    }
  }
  if (!WithinFunction) {
    return false;
  }
  if (isa_TypedefNameDecl(D)) {
    return true;
  }
  
  // White-list anything that isn't a local variable.
  if (!isa_VarDecl(D) || isa_ParmVarDecl(D) || isa_ImplicitParamDecl(D)) {
    return false;
  }
  {
    
    // Types of valid local variables should be complete, so this should succeed.
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      
      // White-list anything with an __attribute__((unused)) type.
      QualType Ty = VD.getType();
      {
        
        // Only look at the outermost level of typedef.
        /*const*/ TypedefType /*P*/ TT = Ty.$arrow().<TypedefType>getAs$TypedefType();
        if ((TT != null)) {
          if (TT.getDecl().hasAttr(UnusedAttr.class)) {
            return false;
          }
        }
      }
      
      // If we failed to complete the type for some reason, or if the type is
      // dependent, don't diagnose the variable.
      if (Ty.$arrow().isIncompleteType() || Ty.$arrow().isDependentType()) {
        return false;
      }
      {
        
        /*const*/ TagType /*P*/ TT = Ty.$arrow().getAs(TagType.class);
        if ((TT != null)) {
          /*const*/ TagDecl /*P*/ Tag = TT.getDecl();
          if (Tag.hasAttr(UnusedAttr.class)) {
            return false;
          }
          {
            
            /*const*/ CXXRecordDecl /*P*/ RD = dyn_cast_CXXRecordDecl(Tag);
            if ((RD != null)) {
              if (!RD.hasTrivialDestructor() && !RD.hasAttr(WarnUnusedAttr.class)) {
                return false;
              }
              {
                
                /*const*/ Expr /*P*/ Init = VD.getInit$Const();
                if ((Init != null)) {
                  {
                    /*const*/ ExprWithCleanups /*P*/ Cleanups = dyn_cast_ExprWithCleanups(Init);
                    if ((Cleanups != null)) {
                      Init = Cleanups.getSubExpr$Const();
                    }
                  }
                  /*const*/ CXXConstructExpr /*P*/ Construct = dyn_cast_CXXConstructExpr(Init);
                  if ((Construct != null) && !Construct.isElidable()) {
                    CXXConstructorDecl /*P*/ CD = Construct.getConstructor();
                    if (!CD.isTrivial() && !RD.hasAttr(WarnUnusedAttr.class)) {
                      return false;
                    }
                  }
                }
              }
            }
          }
        }
      }
      // TODO: __attribute__((unused)) templates?
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="GenerateFixForUnusedDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1568,
 FQN="GenerateFixForUnusedDecl", NM="_ZL24GenerateFixForUnusedDeclPKN5clang9NamedDeclERNS_10ASTContextERNS_9FixItHintE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL24GenerateFixForUnusedDeclPKN5clang9NamedDeclERNS_10ASTContextERNS_9FixItHintE")
//</editor-fold>
public static void GenerateFixForUnusedDecl(/*const*/ NamedDecl /*P*/ D, final ASTContext /*&*/ Ctx, 
                        final FixItHint /*&*/ Hint) {
  if (isa_LabelDecl(D)) {
    SourceLocation AfterColon = Lexer.findLocationAfterToken(D.getLocEnd(), 
        tok.TokenKind.colon, Ctx.getSourceManager(), Ctx.getLangOpts(), true);
    if (AfterColon.isInvalid()) {
      return;
    }
    Hint.$assignMove(FixItHint.CreateRemoval(CharSourceRange.getCharRange(D.getLocStart(), /*NO_COPY*/AfterColon)));
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckPoppedLabel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1619,
 FQN="CheckPoppedLabel", NM="_ZL16CheckPoppedLabelPN5clang9LabelDeclERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL16CheckPoppedLabelPN5clang9LabelDeclERNS_4SemaE")
//</editor-fold>
public static void CheckPoppedLabel(LabelDecl /*P*/ L, final Sema /*&*/ S) {
  // Verify that we have no forward references left.  If so, there was a goto
  // or address of a label taken, but no definition of it.  Label fwd
  // definitions are indicated with a null substmt which is also not a resolved
  // MS inline assembly label name.
  boolean Diagnose = false;
  if (L.isMSAsmLabel()) {
    Diagnose = !L.isResolvedMSAsmLabel();
  } else {
    Diagnose = L.getStmt() == null;
  }
  if (Diagnose) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(L.getLocation(), diag.err_undeclared_label_use)), L.getDeclName()));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Looks up the declaration of "struct objc_super" and
/// saves it for later use in building builtin declaration of
/// objc_msgSendSuper and objc_msgSendSuper_stret. If no such
/// pre-existing declaration exists no action takes place.
//<editor-fold defaultstate="collapsed" desc="LookupPredefedObjCSuperType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1748,
 FQN="LookupPredefedObjCSuperType", NM="_ZL27LookupPredefedObjCSuperTypeRN5clang4SemaEPNS_5ScopeEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL27LookupPredefedObjCSuperTypeRN5clang4SemaEPNS_5ScopeEPNS_14IdentifierInfoE")
//</editor-fold>
public static void LookupPredefedObjCSuperType(final Sema /*&*/ ThisSema, Scope /*P*/ S, 
                           IdentifierInfo /*P*/ II) {
  LookupResult Result = null;
  try {
    if (!II.isStr(/*KEEP_STR*/"objc_msgSendSuper")) {
      return;
    }
    final ASTContext /*&*/ Context = ThisSema.Context;
    
    Result/*J*/= new LookupResult(ThisSema, new DeclarationName($AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"objc_super")))), 
        new SourceLocation(), Sema.LookupNameKind.LookupTagName);
    ThisSema.LookupName(Result, S);
    if (Result.getResultKind() == LookupResult.LookupResultKind.Found) {
      {
        /*const*/ TagDecl /*P*/ TD = Result.<TagDecl>getAsSingle(TagDecl.class);
        if ((TD != null)) {
          Context.setObjCSuperType(Context.getTagDeclType(TD));
        }
      }
    }
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="getHeaderName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1762,
 FQN="getHeaderName", NM="_ZL13getHeaderNameN5clang10ASTContext19GetBuiltinTypeErrorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL13getHeaderNameN5clang10ASTContext19GetBuiltinTypeErrorE")
//</editor-fold>
public static StringRef getHeaderName(ASTContext.GetBuiltinTypeError Error) {
  switch (Error) {
   case GE_None:
    return new StringRef(/*KEEP_STR*/$EMPTY);
   case GE_Missing_stdio:
    return new StringRef(/*KEEP_STR*/"stdio.h");
   case GE_Missing_setjmp:
    return new StringRef(/*KEEP_STR*/"setjmp.h");
   case GE_Missing_ucontext:
    return new StringRef(/*KEEP_STR*/"ucontext.h");
  }
  throw new llvm_unreachable("unhandled error kind");
}


/// Typedef declarations don't have linkage, but they still denote the same
/// entity if their types are the same.
/// FIXME: This is notionally doing the same thing as ASTReaderDecl's
/// isSameEntity.
//<editor-fold defaultstate="collapsed" desc="filterNonConflictingPreviousTypedefDecls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 1858,
 FQN="filterNonConflictingPreviousTypedefDecls", NM="_ZL40filterNonConflictingPreviousTypedefDeclsRN5clang4SemaEPNS_15TypedefNameDeclERNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL40filterNonConflictingPreviousTypedefDeclsRN5clang4SemaEPNS_15TypedefNameDeclERNS_12LookupResultE")
//</editor-fold>
public static void filterNonConflictingPreviousTypedefDecls(final Sema /*&*/ S, 
                                        TypedefNameDecl /*P*/ Decl, 
                                        final LookupResult /*&*/ Previous) {
  LookupResult.Filter Filter = null;
  try {
    // This is only interesting when modules are enabled.
    if (!S.getLangOpts().Modules && !S.getLangOpts().ModulesLocalVisibility) {
      return;
    }
    
    // Empty sets are uninteresting.
    if (Previous.empty()) {
      return;
    }
    
    Filter = Previous.makeFilter();
    while (Filter.hasNext()) {
      NamedDecl /*P*/ Old = Filter.next();
      
      // Non-hidden declarations are never ignored.
      if (S.isVisible(Old)) {
        continue;
      }
      {
        
        // Declarations of the same entity are not ignored, even if they have
        // different linkages.
        TypedefNameDecl /*P*/ OldTD = dyn_cast_TypedefNameDecl(Old);
        if ((OldTD != null)) {
          if (S.Context.hasSameType(OldTD.getUnderlyingType(), 
              Decl.getUnderlyingType())) {
            continue;
          }
          
          // If both declarations give a tag declaration a typedef name for linkage
          // purposes, then they declare the same entity.
          if (S.getLangOpts().CPlusPlus
             && (OldTD.getAnonDeclWithTypedefName(/*AnyRedecl*/ true) != null)
             && (Decl.getAnonDeclWithTypedefName() != null)) {
            continue;
          }
        }
      }
      
      Filter.erase();
    }
    
    Filter.done();
  } finally {
    if (Filter != null) { Filter.$destroy(); }
  }
}


/// DeclhasAttr - returns true if decl Declaration already has the target
/// attribute.
//<editor-fold defaultstate="collapsed" desc="DeclHasAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2108,
 FQN="DeclHasAttr", NM="_ZL11DeclHasAttrPKN5clang4DeclEPKNS_4AttrE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL11DeclHasAttrPKN5clang4DeclEPKNS_4AttrE")
//</editor-fold>
public static boolean DeclHasAttr(/*const*/ Decl /*P*/ D, /*const*/ Attr /*P*/ A) {
  /*const*/ OwnershipAttr /*P*/ OA = dyn_cast_OwnershipAttr(A);
  /*const*/ AnnotateAttr /*P*/ Ann = dyn_cast_AnnotateAttr(A);
  for (/*const*/ Attr /*P*/ i : D.attrs())  {
    if (i.getKind() == A.getKind()) {
      if ((Ann != null)) {
        if ($eq_StringRef(Ann.getAnnotation(), cast_AnnotateAttr(i).getAnnotation())) {
          return true;
        }
        continue;
      }
      // FIXME: Don't hardcode this check
      if ((OA != null) && isa_OwnershipAttr(i)) {
        return OA.getOwnKind() == cast_OwnershipAttr(i).getOwnKind();
      }
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isAttributeTargetADefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2127,
 FQN="isAttributeTargetADefinition", NM="_ZL28isAttributeTargetADefinitionPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL28isAttributeTargetADefinitionPN5clang4DeclE")
//</editor-fold>
public static boolean isAttributeTargetADefinition(Decl /*P*/ D) {
  {
    VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      return (VD.isThisDeclarationADefinition().getValue() != 0);
    }
  }
  {
    TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
    if ((TD != null)) {
      return TD.isCompleteDefinition() || TD.isBeingDefined();
    }
  }
  return true;
}


/// Merge alignment attributes from \p Old to \p New, taking into account the
/// special semantics of C11's _Alignas specifier and C++11's alignas attribute.
///
/// \return \c true if any attributes were added to \p New.
//<editor-fold defaultstate="collapsed" desc="mergeAlignedAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2139,
 FQN="mergeAlignedAttrs", NM="_ZL17mergeAlignedAttrsRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL17mergeAlignedAttrsRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclE")
//</editor-fold>
public static boolean mergeAlignedAttrs(final Sema /*&*/ S, NamedDecl /*P*/ New, Decl /*P*/ Old) {
  // Look for alignas attributes on Old, and pick out whichever attribute
  // specifies the strictest alignment requirement.
  AlignedAttr /*P*/ OldAlignasAttr = null;
  AlignedAttr /*P*/ OldStrictestAlignAttr = null;
  /*uint*/int OldAlign = 0;
  for (AlignedAttr /*P*/ I : Old.specific_attrs(AlignedAttr.class)) {
    // FIXME: We have no way of representing inherited dependent alignments
    // in a case like:
    //   template<int A, int B> struct alignas(A) X;
    //   template<int A, int B> struct alignas(B) X {};
    // For now, we just ignore any alignas attributes which are not on the
    // definition in such a case.
    if (I.isAlignmentDependent()) {
      return false;
    }
    if (I.isAlignas()) {
      OldAlignasAttr = I;
    }
    
    /*uint*/int Align = I.getAlignment(S.Context);
    if ($greater_uint(Align, OldAlign)) {
      OldAlign = Align;
      OldStrictestAlignAttr = I;
    }
  }
  
  // Look for alignas attributes on New.
  AlignedAttr /*P*/ NewAlignasAttr = null;
  /*uint*/int NewAlign = 0;
  for (AlignedAttr /*P*/ I : New.specific_attrs(AlignedAttr.class)) {
    if (I.isAlignmentDependent()) {
      return false;
    }
    if (I.isAlignas()) {
      NewAlignasAttr = I;
    }
    
    /*uint*/int Align = I.getAlignment(S.Context);
    if ($greater_uint(Align, NewAlign)) {
      NewAlign = Align;
    }
  }
  if ((OldAlignasAttr != null) && (NewAlignasAttr != null) && OldAlign != NewAlign) {
    // Both declarations have 'alignas' attributes. We require them to match.
    // C++11 [dcl.align]p6 and C11 6.7.5/7 both come close to saying this, but
    // fall short. (If two declarations both have alignas, they must both match
    // every definition, and so must match each other if there is a definition.)
    
    // If either declaration only contains 'alignas(0)' specifiers, then it
    // specifies the natural alignment for the type.
    if (OldAlign == 0 || NewAlign == 0) {
      QualType Ty/*J*/= new QualType();
      {
        ValueDecl /*P*/ VD = dyn_cast_ValueDecl(New);
        if ((VD != null)) {
          Ty.$assignMove(VD.getType());
        } else {
          Ty.$assignMove(S.Context.getTagDeclType(cast_TagDecl(New)));
        }
      }
      if (OldAlign == 0) {
        OldAlign = S.Context.getTypeAlign(new QualType(Ty));
      }
      if (NewAlign == 0) {
        NewAlign = S.Context.getTypeAlign(new QualType(Ty));
      }
    }
    if (OldAlign != NewAlign) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewAlignasAttr.getLocation(), diag.err_alignas_mismatch)), 
                (/*uint*/int)$long2uint(S.Context.toCharUnitsFromBits($uint2long(OldAlign)).getQuantity())), 
            (/*uint*/int)$long2uint(S.Context.toCharUnitsFromBits($uint2long(NewAlign)).getQuantity())));
        $c$.clean($c$.track(S.Diag(OldAlignasAttr.getLocation(), diag.note_previous_declaration)));
      } finally {
        $c$.$destroy();
      }
    }
  }
  if ((OldAlignasAttr != null) && !(NewAlignasAttr != null) && isAttributeTargetADefinition(New)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // C++11 [dcl.align]p6:
      //   if any declaration of an entity has an alignment-specifier,
      //   every defining declaration of that entity shall specify an
      //   equivalent alignment.
      // C11 6.7.5/7:
      //   If the definition of an object does not have an alignment
      //   specifier, any other declaration of that object shall also
      //   have no alignment specifier.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(New.getLocation(), diag.err_alignas_missing_on_definition)), 
          OldAlignasAttr));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OldAlignasAttr.getLocation(), diag.note_alignas_on_declaration)), 
          OldAlignasAttr));
    } finally {
      $c$.$destroy();
    }
  }
  
  boolean AnyAdded = false;
  
  // Ensure we have an attribute representing the strictest alignment.
  if ($greater_uint(OldAlign, NewAlign)) {
    AlignedAttr /*P*/ Clone = OldStrictestAlignAttr.clone(S.Context);
    Clone.setInherited(true);
    New.addAttr(Clone);
    AnyAdded = true;
  }
  
  // Ensure we have an alignas attribute if the old declaration had one.
  if ((OldAlignasAttr != null) && !(NewAlignasAttr != null)
     && !(AnyAdded && OldStrictestAlignAttr.isAlignas())) {
    AlignedAttr /*P*/ Clone = OldAlignasAttr.clone(S.Context);
    Clone.setInherited(true);
    New.addAttr(Clone);
    AnyAdded = true;
  }
  
  return AnyAdded;
}

//<editor-fold defaultstate="collapsed" desc="mergeDeclAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2246,
 FQN="mergeDeclAttribute", NM="_ZL18mergeDeclAttributeRN5clang4SemaEPNS_9NamedDeclEPKNS_15InheritableAttrENS0_21AvailabilityMergeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL18mergeDeclAttributeRN5clang4SemaEPNS_9NamedDeclEPKNS_15InheritableAttrENS0_21AvailabilityMergeKindE")
//</editor-fold>
public static boolean mergeDeclAttribute(final Sema /*&*/ S, NamedDecl /*P*/ D, 
                  /*const*/ InheritableAttr /*P*/ Attr, 
                  Sema.AvailabilityMergeKind AMK) {
  InheritableAttr /*P*/ NewAttr = null;
  /*uint*/int AttrSpellingListIndex = Attr.getSpellingListIndex();
  {
    /*const*/ AvailabilityAttr /*P*/ AA = dyn_cast_AvailabilityAttr(Attr);
    if ((AA != null)) {
      NewAttr = S.mergeAvailabilityAttr(D, AA.getRange(), AA.getPlatform(), 
          AA.isImplicit(), AA.getIntroduced(), 
          AA.getDeprecated(), 
          AA.getObsoleted(), AA.getUnavailable(), 
          AA.getMessage(), AA.getStrict(), 
          AA.getReplacement(), AMK, 
          AttrSpellingListIndex);
    } else {
      /*const*/ VisibilityAttr /*P*/ VA = dyn_cast_VisibilityAttr(Attr);
      if ((VA != null)) {
        NewAttr = S.mergeVisibilityAttr(D, VA.getRange(), VA.getVisibility(), 
            AttrSpellingListIndex);
      } else {
        /*const*/ TypeVisibilityAttr /*P*/ VA$1 = dyn_cast_TypeVisibilityAttr(Attr);
        if ((VA$1 != null)) {
          NewAttr = S.mergeTypeVisibilityAttr(D, VA$1.getRange(), VA$1.getVisibility(), 
              AttrSpellingListIndex);
        } else {
          /*const*/ DLLImportAttr /*P*/ ImportA = dyn_cast_DLLImportAttr(Attr);
          if ((ImportA != null)) {
            NewAttr = S.mergeDLLImportAttr(D, ImportA.getRange(), 
                AttrSpellingListIndex);
          } else {
            /*const*/ DLLExportAttr /*P*/ ExportA = dyn_cast_DLLExportAttr(Attr);
            if ((ExportA != null)) {
              NewAttr = S.mergeDLLExportAttr(D, ExportA.getRange(), 
                  AttrSpellingListIndex);
            } else {
              /*const*/ FormatAttr /*P*/ FA = dyn_cast_FormatAttr(Attr);
              if ((FA != null)) {
                NewAttr = S.mergeFormatAttr(D, FA.getRange(), FA.getType(), 
                    FA.getFormatIdx(), FA.getFirstArg(), 
                    AttrSpellingListIndex);
              } else {
                /*const*/ SectionAttr /*P*/ SA = dyn_cast_SectionAttr(Attr);
                if ((SA != null)) {
                  NewAttr = S.mergeSectionAttr(D, SA.getRange(), SA.getName(), 
                      AttrSpellingListIndex);
                } else {
                  /*const*/ MSInheritanceAttr /*P*/ IA = dyn_cast_MSInheritanceAttr(Attr);
                  if ((IA != null)) {
                    NewAttr = S.mergeMSInheritanceAttr(D, IA.getRange(), IA.getBestCase(), 
                        AttrSpellingListIndex, 
                        IA.getSemanticSpelling());
                  } else {
                    /*const*/ AlwaysInlineAttr /*P*/ AA$1 = dyn_cast_AlwaysInlineAttr(Attr);
                    if ((AA$1 != null)) {
                      NewAttr = S.mergeAlwaysInlineAttr(D, AA$1.getRange(), 
                          $AddrOf(S.Context.Idents.get(new StringRef(AA$1.getSpelling()))), 
                          AttrSpellingListIndex);
                    } else {
                      /*const*/ MinSizeAttr /*P*/ MA = dyn_cast_MinSizeAttr(Attr);
                      if ((MA != null)) {
                        NewAttr = S.mergeMinSizeAttr(D, MA.getRange(), AttrSpellingListIndex);
                      } else {
                        /*const*/ OptimizeNoneAttr /*P*/ OA = dyn_cast_OptimizeNoneAttr(Attr);
                        if ((OA != null)) {
                          NewAttr = S.mergeOptimizeNoneAttr(D, OA.getRange(), AttrSpellingListIndex);
                        } else {
                          /*const*/ InternalLinkageAttr /*P*/ InternalLinkageA = dyn_cast_InternalLinkageAttr(Attr);
                          if ((InternalLinkageA != null)) {
                            NewAttr = S.mergeInternalLinkageAttr(D, InternalLinkageA.getRange(), 
                                $AddrOf(S.Context.Idents.get(new StringRef(InternalLinkageA.getSpelling()))), 
                                AttrSpellingListIndex);
                          } else {
                            /*const*/ CommonAttr /*P*/ CommonA = dyn_cast_CommonAttr(Attr);
                            if ((CommonA != null)) {
                              NewAttr = S.mergeCommonAttr(D, CommonA.getRange(), 
                                  $AddrOf(S.Context.Idents.get(new StringRef(CommonA.getSpelling()))), 
                                  AttrSpellingListIndex);
                            } else if (isa_AlignedAttr(Attr)) {
                              // AlignedAttrs are handled separately, because we need to handle all
                              // such attributes on a declaration at the same time.
                              NewAttr = null;
                            } else if ((isa_DeprecatedAttr(Attr) || isa_UnavailableAttr(Attr))
                               && (AMK == Sema.AvailabilityMergeKind.AMK_Override
                               || AMK == Sema.AvailabilityMergeKind.AMK_ProtocolImplementation)) {
                              NewAttr = null;
                            } else if (Attr.duplicatesAllowed() || !DeclHasAttr(D, Attr)) {
                              NewAttr = cast_InheritableAttr(Attr.clone(S.Context));
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  if ((NewAttr != null)) {
    NewAttr.setInherited(true);
    D.addAttr(NewAttr);
    if (isa_MSInheritanceAttr(NewAttr)) {
      S.Consumer.AssignInheritanceModel(cast_CXXRecordDecl(D));
    }
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="getDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2321,
 FQN="getDefinition", NM="_ZL13getDefinitionPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL13getDefinitionPKN5clang4DeclE")
//</editor-fold>
public static /*const*/ Decl /*P*/ getDefinition(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ TagDecl /*P*/ TD = dyn_cast_TagDecl(D);
    if ((TD != null)) {
      return TD.getDefinition();
    }
  }
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      /*const*/ VarDecl /*P*/ Def = VD.getDefinition$Const();
      if ((Def != null)) {
        return Def;
      }
      return VD.getActingDefinition$Const();
    }
  }
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      return FD.getDefinition$Const();
    }
  }
  return null;
}

//<editor-fold defaultstate="collapsed" desc="hasAttribute">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2335,
 FQN="hasAttribute", NM="_ZL12hasAttributePKN5clang4DeclENS_4attr4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL12hasAttributePKN5clang4DeclENS_4attr4KindE")
//</editor-fold>
public static boolean hasAttribute(/*const*/ Decl /*P*/ D, attr.Kind Kind) {
  for (/*const*/ Attr /*P*/ Attribute : D.attrs())  {
    if (Attribute.getKind() == Kind) {
      return true;
    }
  }
  return false;
}


/// checkNewAttributesAfterDef - If we already have a definition, check that
/// there are no new attributes in this declaration.
//<editor-fold defaultstate="collapsed" desc="checkNewAttributesAfterDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2344,
 FQN="checkNewAttributesAfterDef", NM="_ZL26checkNewAttributesAfterDefRN5clang4SemaEPNS_4DeclEPKS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL26checkNewAttributesAfterDefRN5clang4SemaEPNS_4DeclEPKS2_")
//</editor-fold>
public static void checkNewAttributesAfterDef(final Sema /*&*/ S, Decl /*P*/ New, /*const*/ Decl /*P*/ Old) {
  if (!New.hasAttrs()) {
    return;
  }
  
  /*const*/ Decl /*P*/ Def = getDefinition(Old);
  if (!(Def != null) || Def == New) {
    return;
  }
  
  final SmallVector<Attr /*P*/>/*&*/ NewAttributes = New.getAttrs();
  for (/*uint*/int I = 0, E = NewAttributes.size(); I != E;) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*const*/ Attr /*P*/ NewAttribute = NewAttributes.$at(I);
      if (isa_AliasAttr(NewAttribute) || isa_IFuncAttr(NewAttribute)) {
        {
          FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(New);
          if ((FD != null)) {
            Sema.SkipBodyInfo SkipBody/*J*/= new Sema.SkipBodyInfo();
            S.CheckForFunctionRedefinition(FD, cast_FunctionDecl(Def), $AddrOf(SkipBody));
            
            // If we're skipping this definition, drop the "alias" attribute.
            if (SkipBody.ShouldSkip) {
              NewAttributes.erase(NewAttributes.begin().$add(I));
              --E;
              continue;
            }
          } else {
            VarDecl /*P*/ VD = cast_VarDecl(New);
            /*uint*/int Diag = cast_VarDecl(Def).isThisDeclarationADefinition()
               == VarDecl.DefinitionKind.TentativeDefinition ? diag.err_alias_after_tentative : diag.err_redefinition;
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(VD.getLocation(), Diag)), VD.getDeclName()));
            $c$.clean($c$.track(S.Diag(Def.getLocation(), diag.note_previous_definition)));
            VD.setInvalidDecl();
          }
        }
        ++I;
        continue;
      }
      {
        
        /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(Def);
        if ((VD != null)) {
          // Tentative definitions are only interesting for the alias check above.
          if (VD.isThisDeclarationADefinition() != VarDecl.DefinitionKind.Definition) {
            ++I;
            continue;
          }
        }
      }
      if (hasAttribute(Def, NewAttribute.getKind())) {
        ++I;
        continue; // regular attr merging will take care of validating this.
      }
      if (isa_C11NoReturnAttr(NewAttribute)) {
        // C's _Noreturn is allowed to be added to a function after it is defined.
        ++I;
        continue;
      } else {
        /*const*/ AlignedAttr /*P*/ AA = dyn_cast_AlignedAttr(NewAttribute);
        if ((AA != null)) {
          if (AA.isAlignas()) {
            // C++11 [dcl.align]p6:
            //   if any declaration of an entity has an alignment-specifier,
            //   every defining declaration of that entity shall specify an
            //   equivalent alignment.
            // C11 6.7.5/7:
            //   If the definition of an object does not have an alignment
            //   specifier, any other declaration of that object shall also
            //   have no alignment specifier.
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Def.getLocation(), diag.err_alignas_missing_on_definition)), 
                AA));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewAttribute.getLocation(), diag.note_alignas_on_declaration)), 
                AA));
            NewAttributes.erase(NewAttributes.begin().$add(I));
            --E;
            continue;
          }
        }
      }
      
      $c$.clean($c$.track(S.Diag(NewAttribute.getLocation(), 
          diag.warn_attribute_precede_definition)));
      $c$.clean($c$.track(S.Diag(Def.getLocation(), diag.note_previous_definition)));
      NewAttributes.erase(NewAttributes.begin().$add(I));
      --E;
    } finally {
      $c$.$destroy();
    }
  }
}


/// mergeParamDeclAttributes - Copy attributes from the old parameter
/// to the new one.
//<editor-fold defaultstate="collapsed" desc="mergeParamDeclAttributes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2517,
 FQN="mergeParamDeclAttributes", NM="_ZL24mergeParamDeclAttributesPN5clang11ParmVarDeclEPKS0_RNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL24mergeParamDeclAttributesPN5clang11ParmVarDeclEPKS0_RNS_4SemaE")
//</editor-fold>
public static void mergeParamDeclAttributes(ParmVarDecl /*P*/ newDecl, 
                        /*const*/ ParmVarDecl /*P*/ oldDecl, 
                        final Sema /*&*/ S) {
  // C++11 [dcl.attr.depend]p2:
  //   The first declaration of a function shall specify the
  //   carries_dependency attribute for its declarator-id if any declaration
  //   of the function specifies the carries_dependency attribute.
  /*const*/ CarriesDependencyAttr /*P*/ CDA = newDecl.getAttr(CarriesDependencyAttr.class);
  if ((CDA != null) && !oldDecl.hasAttr(CarriesDependencyAttr.class)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(CDA.getLocation(), 
              diag.err_carries_dependency_missing_on_first_decl)), 1/*Param*/));
      // Find the first declaration of the parameter.
      // FIXME: Should we build redeclaration chains for function parameters?
      /*const*/ FunctionDecl /*P*/ FirstFD = cast_FunctionDecl(oldDecl.getDeclContext$Const()).getFirstDecl$Const();
      /*const*/ ParmVarDecl /*P*/ FirstVD = FirstFD.getParamDecl$Const(oldDecl.getFunctionScopeIndex());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FirstVD.getLocation(), 
              diag.note_carries_dependency_missing_first_decl)), 1/*Param*/));
    } finally {
      $c$.$destroy();
    }
  }
  if (!oldDecl.hasAttrs()) {
    return;
  }
  
  boolean foundAny = newDecl.hasAttrs();
  
  // Ensure that any moving of objects within the allocated map is
  // done before we process them.
  if (!foundAny) {
    newDecl.setAttrs(new SmallVector<Attr /*P*/>(4, null));
  }
  
  for (/*const*/ InheritableParamAttr /*P*/ I : oldDecl.specific_attrs(InheritableParamAttr.class)) {
    if (!DeclHasAttr(newDecl, I)) {
      InheritableAttr /*P*/ newAttr = cast_InheritableParamAttr(I.clone(S.Context));
      newAttr.setInherited(true);
      newDecl.addAttr(newAttr);
      foundAny = true;
    }
  }
  if (!foundAny) {
    newDecl.dropAttrs();
  }
}

//<editor-fold defaultstate="collapsed" desc="mergeParamDeclTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2560,
 FQN="mergeParamDeclTypes", NM="_ZL19mergeParamDeclTypesPN5clang11ParmVarDeclEPKS0_RNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL19mergeParamDeclTypesPN5clang11ParmVarDeclEPKS0_RNS_4SemaE")
//</editor-fold>
public static void mergeParamDeclTypes(ParmVarDecl /*P*/ NewParam, 
                   /*const*/ ParmVarDecl /*P*/ OldParam, 
                   final Sema /*&*/ S) {
  {
    Optional<NullabilityKind> Oldnullability = OldParam.getType().$arrow().getNullability(S.Context);
    if (Oldnullability.$bool()) {
      {
        Optional<NullabilityKind> Newnullability = NewParam.getType().$arrow().getNullability(S.Context);
        if (Newnullability.$bool()) {
          if (Oldnullability.$star() != Newnullability.$star()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewParam.getLocation(), diag.warn_mismatched_nullability_attr)), 
                      new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, Newnullability.$star(), 
                          ((NewParam.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
                             != 0))), 
                  new std.pairTypeBool<NullabilityKind>(JD$T$RR_T1$RR.INSTANCE, Oldnullability.$star(), 
                      ((OldParam.getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability)
                         != 0))));
              $c$.clean($c$.track(S.Diag(OldParam.getLocation(), diag.note_previous_declaration)));
            } finally {
              $c$.$destroy();
            }
          }
        } else {
          QualType NewT = NewParam.getType();
          NewT.$assignMove(S.Context.getAttributedType(AttributedType.getNullabilityAttrKind(Oldnullability.$star()), 
                  new QualType(NewT), new QualType(NewT)));
          NewParam.setType(new QualType(NewT));
        }
      }
    }
  }
}


// Determine whether the previous declaration was a definition, implicit
// declaration, or a declaration.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="getNoteDiagForInvalidRedeclaration">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2624,
 FQN="getNoteDiagForInvalidRedeclaration", NM="Tpl__ZL34getNoteDiagForInvalidRedeclarationPKT_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL34getNoteDiagForInvalidRedeclarationPKT_S1_")
//</editor-fold>
public static </*typename*/ T extends Decl> std.pairUIntType<SourceLocation> getNoteDiagForInvalidRedeclaration(/*const*/ T /*P*/ Old, /*const*/ T /*P*/ New) {
  /*uint*/int PrevDiag;
  if (Old instanceof VarDecl) {
    SourceLocation OldLocation = Old.getLocation();
    if (((VarDecl)Old).isThisDeclarationADefinition() != VarDecl.DefinitionKind.DeclarationOnly) {
      PrevDiag = diag.note_previous_definition;
    } else if (Old.isImplicit()) {
      PrevDiag = diag.note_previous_implicit_declaration;
      if (OldLocation.isInvalid()) {
        OldLocation = New.getLocation();
      }
    } else {
      PrevDiag = diag.note_previous_declaration;
    }
    return std.make_pair_uint_T(PrevDiag, OldLocation);
  } else if (Old instanceof FunctionDecl) {
    SourceLocation OldLocation = Old.getLocation();
    if (((FunctionDecl)Old).isThisDeclarationADefinition()) {
      PrevDiag = diag.note_previous_definition;
    } else if (Old.isImplicit()) {
      PrevDiag = diag.note_previous_implicit_declaration;
      if (OldLocation.isInvalid()) {
        OldLocation = New.getLocation();
      }
    } else {
      PrevDiag = diag.note_previous_declaration;
    }
    return std.make_pair_uint_T(PrevDiag, OldLocation);
  } else {
    assert false : "" + Old.getClass();
    return null;
  }
}


/// canRedefineFunction - checks if a function can be redefined. Currently,
/// only extern inline functions can be redefined, and even then only in
/// GNU89 mode.
//<editor-fold defaultstate="collapsed" desc="canRedefineFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2642,
 FQN="canRedefineFunction", NM="_ZL19canRedefineFunctionPKN5clang12FunctionDeclERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL19canRedefineFunctionPKN5clang12FunctionDeclERKNS_11LangOptionsE")
//</editor-fold>
public static boolean canRedefineFunction(/*const*/ FunctionDecl /*P*/ FD, 
                   final /*const*/ LangOptions /*&*/ LangOpts) {
  return ((FD.hasAttr(GNUInlineAttr.class) || LangOpts.GNUInline)
     && !LangOpts.CPlusPlus
     && FD.isInlineSpecified()
     && FD.getStorageClass() == StorageClass.SC_Extern);
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="haveIncompatibleLanguageLinkages">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2658,
 FQN="haveIncompatibleLanguageLinkages", NM="Tpl__ZL32haveIncompatibleLanguageLinkagesPKT_S1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL32haveIncompatibleLanguageLinkagesPKT_S1_")
//</editor-fold>
public static </*typename*/ T extends Decl> boolean haveIncompatibleLanguageLinkages(/*const*/ T /*P*/ Old, /*const*/ T /*P*/ New) {
  /*const*/ DeclContext /*P*/ DC = Old.getDeclContext();
  if (DC.isRecord()) {
    return false;
  }
  if (Old instanceof VarDecl) {
    LanguageLinkage OldLinkage = ((VarDecl)Old).getLanguageLinkage();
    if (OldLinkage == LanguageLinkage.CXXLanguageLinkage && ((VarDecl)New).isInExternCContext()) {
      return true;
    }
    if (OldLinkage == LanguageLinkage.CLanguageLinkage && ((VarDecl)New).isInExternCXXContext()) {
      return true;
    }
  } else if (Old instanceof FunctionDecl) {
    LanguageLinkage OldLinkage = ((FunctionDecl)Old).getLanguageLinkage();
    if (OldLinkage == LanguageLinkage.CXXLanguageLinkage && ((FunctionDecl)New).isInExternCContext()) {
      return true;
    }
    if (OldLinkage == LanguageLinkage.CLanguageLinkage && ((FunctionDecl)New).isInExternCXXContext()) {
      return true;
    }
  } else {
    assert false : "" + Old.getClass();
  }
  return false;
}

/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isExternC">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2671,
 FQN="isExternC", NM="Tpl__ZL9isExternCPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL9isExternCPT_")
//</editor-fold>
public static </*typename*/ T extends Decl> boolean isExternC(T /*P*/ D) {
  if (D instanceof VarDecl) {
    return ((VarDecl)D).isExternC();
  } else if (D instanceof FunctionDecl) {
    return ((FunctionDecl)D).isExternC();
  } else if (D instanceof VarTemplateDecl) {
    return isExternC((VarTemplateDecl)D);
  } else {
    assert false : "" + D.getClass();
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="isExternC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2672,
 FQN="isExternC", NM="_ZL9isExternCPN5clang15VarTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL9isExternCPN5clang15VarTemplateDeclE")
//</editor-fold>
public static boolean isExternC(VarTemplateDecl /*P*/ $Prm0) {
  return false;
}


/// \brief Check whether a redeclaration of an entity introduced by a
/// using-declaration is valid, given that we know it's not an overload
/// (nor a hidden tag declaration).
/*template <typename ExpectedDecl> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="checkUsingShadowRedecl">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2678,
 FQN="checkUsingShadowRedecl", NM="Tpl__ZL22checkUsingShadowRedeclRN5clang4SemaEPNS_15UsingShadowDeclEPT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL22checkUsingShadowRedeclRN5clang4SemaEPNS_15UsingShadowDeclEPT_")
//</editor-fold>
public static </*typename*/ ExpectedDecl extends Decl> boolean checkUsingShadowRedecl(Class<ExpectedDecl> ExpectedDeclClass, final Sema /*&*/ S, UsingShadowDecl /*P*/ OldS, 
                      ExpectedDecl /*P*/ New) {
  // C++11 [basic.scope.declarative]p4:
  //   Given a set of declarations in a single declarative region, each of
  //   which specifies the same unqualified name,
  //   -- they shall all refer to the same entity, or all refer to functions
  //      and function templates; or
  //   -- exactly one declaration shall declare a class name or enumeration
  //      name that is not a typedef name and the other declarations shall all
  //      refer to the same variable or enumerator, or all refer to functions
  //      and function templates; in this case the class name or enumeration
  //      name is hidden (3.3.10).
  
  // C++11 [namespace.udecl]p14:
  //   If a function declaration in namespace scope or block scope has the
  //   same name and the same parameter-type-list as a function introduced
  //   by a using-declaration, and the declarations do not declare the same
  //   function, the program is ill-formed.
  ExpectedDecl /*P*/ Old = dyn_cast(ExpectedDeclClass, OldS.getTargetDecl());
  if (Native.$bool(Native.$bool(Old)
     && Native.$not(Old.getDeclContext().getRedeclContext().Equals(New.getDeclContext().getRedeclContext())))
     && Native.$not((Native.$bool(isExternC(Old)) && Native.$bool(isExternC(New))))) {
    Old = null;
  }
  if (Native.$not(Old)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($c$.track(S.Diag(New.getLocation(), diag.err_using_decl_conflict_reverse)));
      $c$.clean($c$.track(S.Diag(OldS.getTargetDecl().getLocation(), diag.note_using_decl_target)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OldS.getUsingDecl().getLocation(), diag.note_using_decl)), 0));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasIdenticalPassObjectSizeAttrs">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 2713,
 FQN="hasIdenticalPassObjectSizeAttrs", NM="_ZL31hasIdenticalPassObjectSizeAttrsPKN5clang12FunctionDeclES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL31hasIdenticalPassObjectSizeAttrsPKN5clang12FunctionDeclES2_")
//</editor-fold>
public static boolean hasIdenticalPassObjectSizeAttrs(/*const*/ FunctionDecl /*P*/ A, 
                               /*const*/ FunctionDecl /*P*/ B) {
  assert (A.getNumParams() == B.getNumParams());
  
  ParmVarDeclPtrParmVarDeclPtr2Bool AttrEq = /*[]*/ (/*const*/ ParmVarDecl /*P*/ _A, /*const*/ ParmVarDecl /*P*/ _B) -> {
        /*const*/ PassObjectSizeAttr /*P*/ AttrA = _A.getAttr(PassObjectSizeAttr.class);
        /*const*/ PassObjectSizeAttr /*P*/ AttrB = _B.getAttr(PassObjectSizeAttr.class);
        if (AttrA == AttrB) {
          return true;
        }
        return (AttrA != null) && (AttrB != null) && AttrA.getType() == AttrB.getType();
      };
  
  return std.equal(A.param_begin$Const(), A.param_end$Const(), B.param_begin$Const(), AttrEq);
}

//<editor-fold defaultstate="collapsed" desc="diagnoseVarDeclTypeMismatch">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3321,
 FQN="diagnoseVarDeclTypeMismatch", NM="_ZL27diagnoseVarDeclTypeMismatchRN5clang4SemaEPNS_7VarDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL27diagnoseVarDeclTypeMismatchRN5clang4SemaEPNS_7VarDeclES3_")
//</editor-fold>
public static void diagnoseVarDeclTypeMismatch(final Sema /*&*/ S, VarDecl /*P*/ New, VarDecl /*P*/ Old) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (!S.Context.hasSameType(New.getType(), Old.getType()));
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(New.getLocation(), (New.isThisDeclarationADefinition().getValue() != 0) ? diag.err_redefinition_different_type : diag.err_redeclaration_different_type)), 
                New.getDeclName()), New.getType()), Old.getType()));
    
    pairUIntType<SourceLocation> tie = getNoteDiagForInvalidRedeclaration(Old, New);
    /*uint*/int PrevDiag = tie.first;
    SourceLocation OldLocation/*J*/= new SourceLocation(tie.second);
    $c$.clean($c$.track(S.Diag(new SourceLocation(OldLocation), PrevDiag)));
    New.setInvalidDecl();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="mergeTypeWithPrevious">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3431,
 FQN="mergeTypeWithPrevious", NM="_ZL21mergeTypeWithPreviousRN5clang4SemaEPNS_7VarDeclES3_RNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL21mergeTypeWithPreviousRN5clang4SemaEPNS_7VarDeclES3_RNS_12LookupResultE")
//</editor-fold>
public static boolean mergeTypeWithPrevious(final Sema /*&*/ S, VarDecl /*P*/ NewVD, VarDecl /*P*/ OldVD, 
                     final LookupResult /*&*/ Previous) {
  // C11 6.2.7p4:
  //   For an identifier with internal or external linkage declared
  //   in a scope in which a prior declaration of that identifier is
  //   visible, if the prior declaration specifies internal or
  //   external linkage, the type of the identifier at the later
  //   declaration becomes the composite type.
  //
  // If the variable isn't visible, we do not merge with its type.
  if (Previous.isShadowed()) {
    return false;
  }
  if (S.getLangOpts().CPlusPlus) {
    // C++11 [dcl.array]p3:
    //   If there is a preceding declaration of the entity in the same
    //   scope in which the bound was specified, an omitted array bound
    //   is taken to be the same as in that earlier declaration.
    return NewVD.isPreviousDeclInSameBlockScope()
       || (!OldVD.getLexicalDeclContext().isFunctionOrMethod()
       && !NewVD.getLexicalDeclContext().isFunctionOrMethod());
  } else {
    // If the old declaration was function-local, don't merge with its
    // type unless we're in the same function.
    return !OldVD.getLexicalDeclContext().isFunctionOrMethod()
       || OldVD.getLexicalDeclContext() == NewVD.getLexicalDeclContext();
  }
}


// The MS ABI changed between VS2013 and VS2015 with regard to numbers used to
// disambiguate entities defined in different scopes.
// While the VS2015 ABI fixes potential miscompiles, it is also breaks
// compatibility.
// We will pick our mangling number depending on which version of MSVC is being
// targeted.
//<editor-fold defaultstate="collapsed" desc="getMSManglingNumber">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3726,
 FQN="getMSManglingNumber", NM="_ZL19getMSManglingNumberRKN5clang11LangOptionsEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL19getMSManglingNumberRKN5clang11LangOptionsEPNS_5ScopeE")
//</editor-fold>
public static /*uint*/int getMSManglingNumber(final /*const*/ LangOptions /*&*/ LO, Scope /*P*/ S) {
  return LO.isCompatibleWithMSVC(LangOptions.MSVCMajorVersion.MSVC2015) ? S.getMSCurManglingNumber() : S.getMSLastManglingNumber();
}

//<editor-fold defaultstate="collapsed" desc="GetDiagnosticTypeSpecifierID">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 3803,
 FQN="GetDiagnosticTypeSpecifierID", NM="_ZL28GetDiagnosticTypeSpecifierIDN5clang17TypeSpecifierTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL28GetDiagnosticTypeSpecifierIDN5clang17TypeSpecifierTypeE")
//</editor-fold>
public static /*uint*/int GetDiagnosticTypeSpecifierID(TypeSpecifierType T) {
  switch (T) {
   case TST_class:
    return 0;
   case TST_struct:
    return 1;
   case TST_interface:
    return 2;
   case TST_union:
    return 3;
   case TST_enum:
    return 4;
   default:
    throw new llvm_unreachable("unexpected type specifier");
  }
}


/// We are trying to inject an anonymous member into the given scope;
/// check if there's an existing declaration that can't be overloaded.
///
/// \return true if this is a forbidden redeclaration
//<editor-fold defaultstate="collapsed" desc="CheckAnonMemberRedeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4088,
 FQN="CheckAnonMemberRedeclaration", NM="_ZL28CheckAnonMemberRedeclarationRN5clang4SemaEPNS_5ScopeEPNS_11DeclContextENS_15DeclarationNameENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL28CheckAnonMemberRedeclarationRN5clang4SemaEPNS_5ScopeEPNS_11DeclContextENS_15DeclarationNameENS_14SourceLocationEb")
//</editor-fold>
public static boolean CheckAnonMemberRedeclaration(final Sema /*&*/ SemaRef, 
                            Scope /*P*/ S, 
                            DeclContext /*P*/ Owner, 
                            DeclarationName Name, 
                            SourceLocation NameLoc, 
                            boolean IsUnion) {
  LookupResult R = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    R/*J*/= new LookupResult(SemaRef, new DeclarationName(Name), new SourceLocation(NameLoc), Sema.LookupNameKind.LookupMemberName, 
        Sema.RedeclarationKind.ForRedeclaration);
    if (!SemaRef.LookupName(R, S)) {
      return false;
    }
    
    // Pick a representative declaration.
    NamedDecl /*P*/ PrevDecl = R.getRepresentativeDecl().getUnderlyingDecl();
    assert ((PrevDecl != null)) : "Expected a non-null Decl";
    if (!SemaRef.isDeclInScope(PrevDecl, Owner, S)) {
      return false;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(NameLoc), diag.err_anonymous_record_member_redecl)), 
            IsUnion), Name));
    $c$.clean($c$.track(SemaRef.Diag(PrevDecl.getLocation(), diag.note_previous_declaration)));
    
    return true;
  } finally {
    if (R != null) { R.$destroy(); }
    $c$.$destroy();
  }
}


/// InjectAnonymousStructOrUnionMembers - Inject the members of the
/// anonymous struct or union AnonRecord into the owning context Owner
/// and scope S. This routine will be invoked just after we realize
/// that an unnamed union or struct is actually an anonymous union or
/// struct, e.g.,
///
/// @code
/// union {
///   int i;
///   float f;
/// }; // InjectAnonymousStructOrUnionMembers called here to inject i and
///    // f into the surrounding scope.x
/// @endcode
///
/// This routine is recursive, injecting the names of nested anonymous
/// structs/unions into the owning context and scope as well.
//<editor-fold defaultstate="collapsed" desc="InjectAnonymousStructOrUnionMembers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4128,
 FQN="InjectAnonymousStructOrUnionMembers", NM="_ZL35InjectAnonymousStructOrUnionMembersRN5clang4SemaEPNS_5ScopeEPNS_11DeclContextEPNS_10RecordDeclENS_15AccessSpecifierERN4llvm15SmallVectorImplIPNS_9NamedDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL35InjectAnonymousStructOrUnionMembersRN5clang4SemaEPNS_5ScopeEPNS_11DeclContextEPNS_10RecordDeclENS_15AccessSpecifierERN4llvm15SmallVectorImplIPNS_9NamedDeclEEE")
//</editor-fold>
public static boolean InjectAnonymousStructOrUnionMembers(final Sema /*&*/ SemaRef, Scope /*P*/ S, DeclContext /*P*/ Owner, 
                                   RecordDecl /*P*/ AnonRecord, AccessSpecifier AS, 
                                   final SmallVectorImpl<NamedDecl /*P*/ > /*&*/ Chaining) {
  boolean Invalid = false;
  
  // Look every FieldDecl and IndirectFieldDecl with a name.
  for (Decl /*P*/ D : AnonRecord.decls()) {
    if ((isa_FieldDecl(D) || isa_IndirectFieldDecl(D))
       && cast_NamedDecl(D).getDeclName().$bool()) {
      ValueDecl /*P*/ VD = cast_ValueDecl(D);
      if (CheckAnonMemberRedeclaration(SemaRef, S, Owner, VD.getDeclName(), 
          VD.getLocation(), 
          AnonRecord.isUnion())) {
        // C++ [class.union]p2:
        //   The names of the members of an anonymous union shall be
        //   distinct from the names of any other entity in the
        //   scope in which the anonymous union is declared.
        Invalid = true;
      } else {
        // C++ [class.union]p2:
        //   For the purpose of name lookup, after the anonymous union
        //   definition, the members of the anonymous union are
        //   considered to have been defined in the scope in which the
        //   anonymous union is declared.
        /*uint*/int OldChainingSize = Chaining.size();
        {
          IndirectFieldDecl /*P*/ IF = dyn_cast_IndirectFieldDecl(VD);
          if ((IF != null)) {
            Chaining.append_T(IF.chain_begin(), IF.chain_end());
          } else {
            Chaining.push_back(VD);
          }
        }
        assert ($greatereq_uint(Chaining.size(), 2));
        NamedDecl /*P*/ /*P*/ NamedChain[] = /*FIXME:NEW_EXPR*//*new (SemaRef.Context)*/ new NamedDecl /*P*/ [Chaining.size()];
        for (/*uint*/int i = 0; $less_uint(i, Chaining.size()); i++)  {
          NamedChain[i] = Chaining.$at(i);
        }
        
        IndirectFieldDecl /*P*/ IndirectField = IndirectFieldDecl.Create(SemaRef.Context, Owner, VD.getLocation(), VD.getIdentifier(), 
            VD.getType(), /*{ */new MutableArrayRef<NamedDecl /*P*/ >(NamedChain, Chaining.size(), true)/* }*/);
        
        for (/*const*/ Attr /*P*/ $Attr : VD.attrs())  {
          IndirectField.addAttr($Attr.clone(SemaRef.Context));
        }
        
        IndirectField.setAccess(AS);
        IndirectField.setImplicit();
        SemaRef.PushOnScopeChains(IndirectField, S);
        
        // That includes picking up the appropriate access specifier.
        if (AS != AccessSpecifier.AS_none) {
          IndirectField.setAccess(AS);
        }
        
        Chaining.resize(OldChainingSize);
      }
    }
  }
  
  return Invalid;
}


/// StorageClassSpecToVarDeclStorageClass - Maps a DeclSpec::SCS to
/// a VarDecl::StorageClass. Any error reporting is up to the caller:
/// illegal input values are mapped to SC_None.
//<editor-fold defaultstate="collapsed" desc="StorageClassSpecToVarDeclStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4190,
 FQN="StorageClassSpecToVarDeclStorageClass", NM="_ZL37StorageClassSpecToVarDeclStorageClassRKN5clang8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL37StorageClassSpecToVarDeclStorageClassRKN5clang8DeclSpecE")
//</editor-fold>
public static StorageClass StorageClassSpecToVarDeclStorageClass(final /*const*/ DeclSpec /*&*/ DS) {
  DeclSpec.SCS StorageClassSpec = DS.getStorageClassSpec();
  assert (StorageClassSpec != DeclSpec.SCS.SCS_typedef) : "Parser allowed 'typedef' as storage class VarDecl.";
  switch (StorageClassSpec) {
   case SCS_unspecified:
    return StorageClass.SC_None;
   case SCS_extern:
    if (DS.isExternInLinkageSpec()) {
      return StorageClass.SC_None;
    }
    return StorageClass.SC_Extern;
   case SCS_static:
    return StorageClass.SC_Static;
   case SCS_auto:
    return StorageClass.SC_Auto;
   case SCS_register:
    return StorageClass.SC_Register;
   case SCS_private_extern:
    return StorageClass.SC_PrivateExtern;
   case SCS_mutable: // Fall through.
   case SCS_typedef:
    return StorageClass.SC_None;
  }
  throw new llvm_unreachable("unknown storage class specifier");
}

//<editor-fold defaultstate="collapsed" desc="findDefaultInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4212,
 FQN="findDefaultInitializer", NM="_ZL22findDefaultInitializerPKN5clang13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL22findDefaultInitializerPKN5clang13CXXRecordDeclE")
//</editor-fold>
public static SourceLocation findDefaultInitializer(/*const*/ CXXRecordDecl /*P*/ Record) {
  assert (Record.hasInClassInitializer());
  
  for (/*const*/ Decl /*P*/ I : Record.decls()) {
    /*const*/ FieldDecl /*P*/ FD = dyn_cast_FieldDecl(I);
    {
      /*const*/ IndirectFieldDecl /*P*/ IFD = dyn_cast_IndirectFieldDecl(I);
      if ((IFD != null)) {
        FD = IFD.getAnonField();
      }
    }
    if ((FD != null) && FD.hasInClassInitializer()) {
      return FD.getLocation();
    }
  }
  throw new llvm_unreachable("couldn't find in-class initializer");
}

//<editor-fold defaultstate="collapsed" desc="checkDuplicateDefaultInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4226,
 FQN="checkDuplicateDefaultInit", NM="_ZL25checkDuplicateDefaultInitRN5clang4SemaEPNS_13CXXRecordDeclENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL25checkDuplicateDefaultInitRN5clang4SemaEPNS_13CXXRecordDeclENS_14SourceLocationE")
//</editor-fold>
public static void checkDuplicateDefaultInit(final Sema /*&*/ S, CXXRecordDecl /*P*/ Parent, 
                         SourceLocation DefaultInitLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!Parent.isUnion() || !Parent.hasInClassInitializer()) {
      return;
    }
    
    $c$.clean($c$.track(S.Diag(new SourceLocation(DefaultInitLoc), diag.err_multiple_mem_union_initialization)));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(findDefaultInitializer(Parent), diag.note_previous_initializer)), 0));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="checkDuplicateDefaultInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4235,
 FQN="checkDuplicateDefaultInit", NM="_ZL25checkDuplicateDefaultInitRN5clang4SemaEPNS_13CXXRecordDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL25checkDuplicateDefaultInitRN5clang4SemaEPNS_13CXXRecordDeclES3_")
//</editor-fold>
public static void checkDuplicateDefaultInit(final Sema /*&*/ S, CXXRecordDecl /*P*/ Parent, 
                         CXXRecordDecl /*P*/ AnonUnion) {
  if (!Parent.isUnion() || !Parent.hasInClassInitializer()) {
    return;
  }
  
  checkDuplicateDefaultInit(S, Parent, findDefaultInitializer(AnonUnion));
}

//<editor-fold defaultstate="collapsed" desc="getCoreType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4666,
 FQN="getCoreType", NM="_ZL11getCoreTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL11getCoreTypeN5clang8QualTypeE")
//</editor-fold>
public static QualType getCoreType(QualType Ty) {
  do {
    if (Ty.$arrow().isPointerType() || Ty.$arrow().isReferenceType()) {
      Ty.$assignMove(Ty.$arrow().getPointeeType());
    } else if (Ty.$arrow().isArrayType()) {
      Ty.$assignMove(Ty.$arrow().castAsArrayTypeUnsafe().getElementType());
    } else {
      return Ty.withoutLocalFastQualifiers();
    }
  } while (true);
}


/// hasSimilarParameters - Determine whether the C++ functions Declaration
/// and Definition have "nearly" matching parameters. This heuristic is
/// used to improve diagnostics in the case where an out-of-line function
/// definition doesn't match any declaration within the class or namespace.
/// Also sets Params to the list of indices to the parameters that differ
/// between the declaration and the definition. If hasSimilarParameters
/// returns true and Params is empty, then all of the parameters match.
//<editor-fold defaultstate="collapsed" desc="hasSimilarParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4684,
 FQN="hasSimilarParameters", NM="_ZL20hasSimilarParametersRN5clang10ASTContextEPNS_12FunctionDeclES3_RN4llvm15SmallVectorImplIjEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL20hasSimilarParametersRN5clang10ASTContextEPNS_12FunctionDeclES3_RN4llvm15SmallVectorImplIjEE")
//</editor-fold>
public static boolean hasSimilarParameters(final ASTContext /*&*/ Context, 
                    FunctionDecl /*P*/ Declaration, 
                    FunctionDecl /*P*/ Definition, 
                    final SmallVectorImplUInt/*&*/ Params) {
  Params.clear();
  if (Declaration.param_size() != Definition.param_size()) {
    return false;
  }
  for (/*uint*/int Idx = 0; $less_uint(Idx, Declaration.param_size()); ++Idx) {
    QualType DeclParamTy = Declaration.getParamDecl(Idx).getType();
    QualType DefParamTy = Definition.getParamDecl(Idx).getType();
    
    // The parameter types are identical
    if (Context.hasSameType(new QualType(DefParamTy), new QualType(DeclParamTy))) {
      continue;
    }
    
    QualType DeclParamBaseTy = getCoreType(new QualType(DeclParamTy));
    QualType DefParamBaseTy = getCoreType(new QualType(DefParamTy));
    /*const*/ IdentifierInfo /*P*/ DeclTyName = DeclParamBaseTy.getBaseTypeIdentifier();
    /*const*/ IdentifierInfo /*P*/ DefTyName = DefParamBaseTy.getBaseTypeIdentifier();
    if (Context.hasSameUnqualifiedType(new QualType(DeclParamBaseTy), new QualType(DefParamBaseTy))
       || ((DeclTyName != null) && DeclTyName == DefTyName)) {
      Params.push_back(Idx);
    } else { // The two parameters aren't even close
      return false;
    }
  }
  
  return true;
}


/// NeedsRebuildingInCurrentInstantiation - Checks whether the given
/// declarator needs to be rebuilt in the current instantiation.
/// Any bits of declarator which appear before the name are valid for
/// consideration here.  That's specifically the type in the decl spec
/// and the base type in any member-pointer chunks.
//<editor-fold defaultstate="collapsed" desc="RebuildDeclaratorInCurrentInstantiation">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 4719,
 FQN="RebuildDeclaratorInCurrentInstantiation", NM="_ZL39RebuildDeclaratorInCurrentInstantiationRN5clang4SemaERNS_10DeclaratorENS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL39RebuildDeclaratorInCurrentInstantiationRN5clang4SemaERNS_10DeclaratorENS_15DeclarationNameE")
//</editor-fold>
public static boolean RebuildDeclaratorInCurrentInstantiation(final Sema /*&*/ S, final Declarator /*&*/ D, 
                                       DeclarationName Name) {
  // The types we specifically need to rebuild are:
  //   - typenames, typeofs, and decltypes
  //   - types which will become injected class names
  // Of course, we also need to rebuild any type referencing such a
  // type.  It's safest to just say "dependent", but we call out a
  // few cases here.
  final DeclSpec /*&*/ DS = D.getMutableDeclSpec();
  switch (DS.getTypeSpecType()) {
   case TST_typename:
   case TST_typeofType:
   case TST_underlyingType:
   case TST_atomic:
    {
      // Grab the type from the parser.
      type$ptr<TypeSourceInfo /*P*/ > TSI = create_type$null$ptr(null);
      QualType T = S.GetTypeFromParser(DS.getRepAsType(), $AddrOf(TSI));
      if (T.isNull() || !T.$arrow().isDependentType()) {
        break;
      }
      
      // Make sure there's a type source info.  This isn't really much
      // of a waste; most dependent types should have type source info
      // attached already.
      if (!(TSI.$star() != null)) {
        TSI.$set(S.Context.getTrivialTypeSourceInfo(new QualType(T), DS.getTypeSpecTypeLoc()));
      }
      
      // Rebuild the type in the current instantiation.
      TSI.$set(S.RebuildTypeInCurrentInstantiation(TSI.$star(), D.getIdentifierLoc(), new DeclarationName(Name)));
      if (!(TSI.$star() != null)) {
        return true;
      }
      
      // Store the new type back in the decl spec.
      OpaquePtr<QualType> LocType = S.CreateParsedType(TSI.$star().getType(), TSI.$star());
      DS.UpdateTypeRep(new OpaquePtr<QualType>(LocType));
      break;
    }
   case TST_decltype:
   case TST_typeofExpr:
    {
      Expr /*P*/ E = DS.getRepAsExpr();
      ActionResultTTrue<Expr /*P*/ > Result = S.RebuildExprInCurrentInstantiation(E);
      if (Result.isInvalid()) {
        return true;
      }
      DS.UpdateExprRep(Result.get());
      break;
    }
   default:
    // Nothing to do for these decl specs.
    break;
  }
  
  // It doesn't matter what order we do this in.
  for (/*uint*/int I = 0, E = D.getNumTypeObjects(); I != E; ++I) {
    final DeclaratorChunk /*&*/ Chunk = D.getTypeObject(I);
    
    // The only type information in the declarator which can come
    // before the declaration name is the base type of a member
    // pointer.
    if (Chunk.Kind != DeclaratorChunk.Unnamed_enum.MemberPointer) {
      continue;
    }
    
    // Rebuild the scope specifier in-place.
    final CXXScopeSpec /*&*/ SS = Chunk.Unnamed_field3.Mem.Scope();
    if (S.RebuildNestedNameSpecifierInCurrentInstantiation(SS)) {
      return true;
    }
  }
  
  return false;
}


/// Helper method to turn variable array types into constant array
/// types in certain situations which would otherwise be errors (for
/// GCC compatibility).
//<editor-fold defaultstate="collapsed" desc="TryToFixInvalidVariablyModifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5154,
 FQN="TryToFixInvalidVariablyModifiedType", NM="_ZL35TryToFixInvalidVariablyModifiedTypeN5clang8QualTypeERNS_10ASTContextERbRN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL35TryToFixInvalidVariablyModifiedTypeN5clang8QualTypeERNS_10ASTContextERbRN4llvm6APSIntE")
//</editor-fold>
public static QualType TryToFixInvalidVariablyModifiedType(QualType T, 
                                   final ASTContext /*&*/ Context, 
                                   final bool$ref/*bool &*/ SizeIsNegative, 
                                   final APSInt /*&*/ Oversized) {
  // This method tries to turn a variable array into a constant
  // array even when the size isn't an ICE.  This is necessary
  // for compatibility with code that depends on gcc's buggy
  // constant expression folding, like struct {char x[(int)(char*)2];}
  SizeIsNegative.$set(false);
  Oversized.$assign(0);
  if (T.$arrow().isDependentType()) {
    return new QualType();
  }
  
  QualifierCollector Qs/*J*/= new QualifierCollector();
  /*const*/ Type /*P*/ Ty = Qs.strip(new QualType(T));
  {
    
    /*const*/ PointerType /*P*/ PTy = dyn_cast_PointerType(Ty);
    if ((PTy != null)) {
      QualType Pointee = PTy.getPointeeType();
      QualType FixedType = TryToFixInvalidVariablyModifiedType(new QualType(Pointee), Context, SizeIsNegative, 
          Oversized);
      if (FixedType.isNull()) {
        return FixedType;
      }
      FixedType.$assignMove(Context.getPointerType(new QualType(FixedType)));
      return Qs.apply(Context, new QualType(FixedType));
    }
  }
  {
    /*const*/ ParenType /*P*/ PTy = dyn_cast_ParenType(Ty);
    if ((PTy != null)) {
      QualType Inner = PTy.getInnerType();
      QualType FixedType = TryToFixInvalidVariablyModifiedType(new QualType(Inner), Context, SizeIsNegative, 
          Oversized);
      if (FixedType.isNull()) {
        return FixedType;
      }
      FixedType.$assignMove(Context.getParenType(new QualType(FixedType)));
      return Qs.apply(Context, new QualType(FixedType));
    }
  }
  
  /*const*/ VariableArrayType /*P*/ VLATy = dyn_cast_VariableArrayType(T);
  if (!(VLATy != null)) {
    return new QualType();
  }
  // FIXME: We should probably handle this case
  if (VLATy.getElementType().$arrow().isVariablyModifiedType()) {
    return new QualType();
  }
  
  APSInt Res/*J*/= new APSInt();
  if (!(VLATy.getSizeExpr() != null)
     || !VLATy.getSizeExpr().EvaluateAsInt(Res, Context)) {
    return new QualType();
  }
  
  // Check whether the array size is negative.
  if (Res.isSigned() && Res.isNegative()) {
    SizeIsNegative.$set(true);
    return new QualType();
  }
  
  // Check whether the array is too large to be addressed.
  /*uint*/int ActiveSizeBits = ConstantArrayType.getNumAddressingBits(Context, VLATy.getElementType(), 
      Res);
  if ($greater_uint(ActiveSizeBits, ConstantArrayType.getMaxSizeBits(Context))) {
    Oversized.$assign(Res);
    return new QualType();
  }
  
  return Context.getConstantArrayType(VLATy.getElementType(), 
      Res, ArrayType.ArraySizeModifier.Normal, 0);
}

//<editor-fold defaultstate="collapsed" desc="FixInvalidVariablyModifiedTypeLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5221,
 FQN="FixInvalidVariablyModifiedTypeLoc", NM="_ZL33FixInvalidVariablyModifiedTypeLocN5clang7TypeLocES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL33FixInvalidVariablyModifiedTypeLocN5clang7TypeLocES0_")
//</editor-fold>
public static void FixInvalidVariablyModifiedTypeLoc(TypeLoc SrcTL, TypeLoc DstTL) {
  SrcTL.$assignMove(SrcTL.getUnqualifiedLoc());
  DstTL.$assignMove(DstTL.getUnqualifiedLoc());
  {
    PointerTypeLoc SrcPTL = SrcTL.getAs(PointerTypeLoc.class);
    if (SrcPTL.$bool()) {
      PointerTypeLoc DstPTL = DstTL.castAs(PointerTypeLoc.class);
      FixInvalidVariablyModifiedTypeLoc(SrcPTL.getPointeeLoc(), 
          DstPTL.getPointeeLoc());
      DstPTL.setStarLoc(SrcPTL.getStarLoc());
      return;
    }
  }
  {
    ParenTypeLoc SrcPTL = SrcTL.getAs(ParenTypeLoc.class);
    if (SrcPTL.$bool()) {
      ParenTypeLoc DstPTL = DstTL.castAs(ParenTypeLoc.class);
      FixInvalidVariablyModifiedTypeLoc(SrcPTL.getInnerLoc(), 
          DstPTL.getInnerLoc());
      DstPTL.setLParenLoc(SrcPTL.getLParenLoc());
      DstPTL.setRParenLoc(SrcPTL.getRParenLoc());
      return;
    }
  }
  ArrayTypeLoc SrcATL = SrcTL.castAs(ArrayTypeLoc.class);
  ArrayTypeLoc DstATL = DstTL.castAs(ArrayTypeLoc.class);
  TypeLoc SrcElemTL = SrcATL.getElementLoc();
  TypeLoc DstElemTL = DstATL.getElementLoc();
  DstElemTL.initializeFullCopy(new TypeLoc(SrcElemTL));
  DstATL.setLBracketLoc(SrcATL.getLBracketLoc());
  DstATL.setSizeExpr(SrcATL.getSizeExpr());
  DstATL.setRBracketLoc(SrcATL.getRBracketLoc());
}


/// Helper method to turn variable array types into constant array
/// types in certain situations which would otherwise be errors (for
/// GCC compatibility).
//<editor-fold defaultstate="collapsed" desc="TryToFixInvalidVariablyModifiedTypeSourceInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5253,
 FQN="TryToFixInvalidVariablyModifiedTypeSourceInfo", NM="_ZL45TryToFixInvalidVariablyModifiedTypeSourceInfoPN5clang14TypeSourceInfoERNS_10ASTContextERbRN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL45TryToFixInvalidVariablyModifiedTypeSourceInfoPN5clang14TypeSourceInfoERNS_10ASTContextERbRN4llvm6APSIntE")
//</editor-fold>
public static TypeSourceInfo /*P*/ TryToFixInvalidVariablyModifiedTypeSourceInfo(TypeSourceInfo /*P*/ TInfo, 
                                             final ASTContext /*&*/ Context, 
                                             final bool$ref/*bool &*/ SizeIsNegative, 
                                             final APSInt /*&*/ Oversized) {
  QualType FixedTy = TryToFixInvalidVariablyModifiedType(TInfo.getType(), Context, 
      SizeIsNegative, Oversized);
  if (FixedTy.isNull()) {
    return null;
  }
  TypeSourceInfo /*P*/ FixedTInfo = Context.getTrivialTypeSourceInfo(new QualType(FixedTy));
  FixInvalidVariablyModifiedTypeLoc(TInfo.getTypeLoc(), 
      FixedTInfo.getTypeLoc());
  return FixedTInfo;
}

//<editor-fold defaultstate="collapsed" desc="SetNestedNameSpecifier">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5481,
 FQN="SetNestedNameSpecifier", NM="_ZL22SetNestedNameSpecifierPN5clang14DeclaratorDeclERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL22SetNestedNameSpecifierPN5clang14DeclaratorDeclERNS_10DeclaratorE")
//</editor-fold>
public static void SetNestedNameSpecifier(DeclaratorDecl /*P*/ DD, final Declarator /*&*/ D) {
  final CXXScopeSpec /*&*/ SS = D.getCXXScopeSpec();
  if (!SS.isSet()) {
    return;
  }
  DD.setQualifierInfo(SS.getWithLocInContext(DD.getASTContext()));
}

//<editor-fold defaultstate="collapsed" desc="checkAttributesAfterMerging">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5531,
 FQN="checkAttributesAfterMerging", NM="_ZL27checkAttributesAfterMergingRN5clang4SemaERNS_9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL27checkAttributesAfterMergingRN5clang4SemaERNS_9NamedDeclE")
//</editor-fold>
public static void checkAttributesAfterMerging(final Sema /*&*/ S, final NamedDecl /*&*/ ND) {
  // Ensure that an auto decl is deduced otherwise the checks below might cache
  // the wrong linkage.
  assert (S.ParsingInitForAutoVars.count($AddrOf(ND)) == 0);
  {
    
    // 'weak' only applies to declarations with external linkage.
    WeakAttr /*P*/ Attr = ND.getAttr(WeakAttr.class);
    if ((Attr != null)) {
      if (!ND.isExternallyVisible()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Attr.getLocation(), diag.err_attribute_weak_static)));
          ND.dropAttr(WeakAttr.class);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    WeakRefAttr /*P*/ Attr = ND.getAttr(WeakRefAttr.class);
    if ((Attr != null)) {
      if (ND.isExternallyVisible()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Attr.getLocation(), diag.err_attribute_weakref_not_static)));
          ND.dropAttr(WeakRefAttr.class);
          ND.dropAttr(AliasAttr.class);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    
    VarDecl /*P*/ VD = dyn_cast_VarDecl($AddrOf(ND));
    if ((VD != null)) {
      if (VD.hasInit()) {
        {
          /*const*/ AliasAttr /*P*/ Attr = VD.getAttr(AliasAttr.class);
          if ((Attr != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              assert ((VD.isThisDeclarationADefinition().getValue() != 0) && !VD.isExternallyVisible()) : "Broken AliasAttr handled late!";
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Attr.getLocation(), diag.err_alias_is_definition)), VD), 0));
              VD.dropAttr(AliasAttr.class);
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  {
    
    // 'selectany' only applies to externally visible variable declarations.
    // It does not apply to functions.
    SelectAnyAttr /*P*/ Attr = ND.getAttr(SelectAnyAttr.class);
    if ((Attr != null)) {
      if (isa_FunctionDecl(ND) || !ND.isExternallyVisible()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(Attr.getLocation(), 
              diag.err_attribute_selectany_non_extern_data)));
          ND.dropAttr(SelectAnyAttr.class);
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    
    /*const*/ InheritableAttr /*P*/ Attr = getDLLAttr($AddrOf(ND));
    if ((Attr != null)) {
      // dll attributes require external linkage. Static locals may have external
      // linkage but still cannot be explicitly imported or exported.
      VarDecl /*P*/ VD = dyn_cast_VarDecl($AddrOf(ND));
      if (!ND.isExternallyVisible() || ((VD != null) && VD.isStaticLocal())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), diag.err_attribute_dll_not_extern)), 
                  $AddrOf(ND)), Attr));
          ND.setInvalidDecl();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  {
    
    // Virtual functions cannot be marked as 'notail'.
    NotTailCalledAttr /*P*/ Attr = ND.getAttr(NotTailCalledAttr.class);
    if ((Attr != null)) {
      {
        CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl($AddrOf(ND));
        if ((MD != null)) {
          if (MD.isVirtual()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), 
                      diag.err_invalid_attribute_on_virtual_function)), 
                  Attr));
              ND.dropAttr(NotTailCalledAttr.class);
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="checkDLLAttributeRedeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5594,
 FQN="checkDLLAttributeRedeclaration", NM="_ZL30checkDLLAttributeRedeclarationRN5clang4SemaEPNS_9NamedDeclES3_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL30checkDLLAttributeRedeclarationRN5clang4SemaEPNS_9NamedDeclES3_bb")
//</editor-fold>
public static void checkDLLAttributeRedeclaration(final Sema /*&*/ S, NamedDecl /*P*/ OldDecl, 
                              NamedDecl /*P*/ NewDecl, 
                              boolean IsSpecialization, 
                              boolean IsDefinition) {
  {
    TemplateDecl /*P*/ OldTD = dyn_cast_TemplateDecl(OldDecl);
    if ((OldTD != null)) {
      OldDecl = OldTD.getTemplatedDecl();
      if (!IsSpecialization) {
        IsDefinition = false;
      }
    }
  }
  {
    TemplateDecl /*P*/ NewTD = dyn_cast_TemplateDecl(NewDecl);
    if ((NewTD != null)) {
      NewDecl = NewTD.getTemplatedDecl();
    }
  }
  if (!(OldDecl != null) || !(NewDecl != null)) {
    return;
  }
  
  /*const*/ DLLImportAttr /*P*/ OldImportAttr = OldDecl.getAttr(DLLImportAttr.class);
  /*const*/ DLLExportAttr /*P*/ OldExportAttr = OldDecl.getAttr(DLLExportAttr.class);
  /*const*/ DLLImportAttr /*P*/ NewImportAttr = NewDecl.getAttr(DLLImportAttr.class);
  /*const*/ DLLExportAttr /*P*/ NewExportAttr = NewDecl.getAttr(DLLExportAttr.class);
  
  // dllimport and dllexport are inheritable attributes so we have to exclude
  // inherited attribute instances.
  boolean HasNewAttr = ((NewImportAttr != null) && !NewImportAttr.isInherited())
     || ((NewExportAttr != null) && !NewExportAttr.isInherited());
  
  // A redeclaration is not allowed to add a dllimport or dllexport attribute,
  // the only exception being explicit specializations.
  // Implicitly generated declarations are also excluded for now because there
  // is no other way to switch these to use dllimport or dllexport.
  boolean AddsAttr = !((OldImportAttr != null) || (OldExportAttr != null)) && HasNewAttr;
  if (AddsAttr && !IsSpecialization && !OldDecl.isImplicit()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Allow with a warning for free functions and global variables.
      boolean JustWarn = false;
      if (!OldDecl.isCXXClassMember()) {
        VarDecl /*P*/ VD = dyn_cast_VarDecl(OldDecl);
        if ((VD != null) && !(VD.getDescribedVarTemplate() != null)) {
          JustWarn = true;
        }
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(OldDecl);
        if ((FD != null) && FD.getTemplatedKind() == FunctionDecl.TemplatedKind.TK_NonTemplate) {
          JustWarn = true;
        }
      }
      
      // We cannot change a declaration that's been used because IR has already
      // been emitted. Dllimported functions will still work though (modulo
      // address equality) as they can use the thunk.
      if (OldDecl.isUsed()) {
        if (!isa_FunctionDecl(OldDecl) || !(NewImportAttr != null)) {
          JustWarn = false;
        }
      }
      
      /*uint*/int DiagID = JustWarn ? diag.warn_attribute_dll_redeclaration : diag.err_attribute_dll_redeclaration;
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewDecl.getLocation(), DiagID)), 
              NewDecl), 
          ((NewImportAttr != null) ? (/*const*/ Attr /*P*/ )NewImportAttr : NewExportAttr)));
      $c$.clean($c$.track(S.Diag(OldDecl.getLocation(), diag.note_previous_declaration)));
      if (!JustWarn) {
        NewDecl.setInvalidDecl();
        return;
      }
    } finally {
      $c$.$destroy();
    }
  }
  
  // A redeclaration is not allowed to drop a dllimport attribute, the only
  // exceptions being inline function definitions, local extern declarations,
  // qualified friend declarations or special MSVC extension: in the last case,
  // the declaration is treated as if it were marked dllexport.
  boolean IsInline = false, IsStaticDataMember = false, IsQualifiedFriend = false;
  boolean IsMicrosoft = S.Context.getTargetInfo().getCXXABI().isMicrosoft();
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(NewDecl);
    if ((VD != null)) {
      // Ignore static data because out-of-line definitions are diagnosed
      // separately.
      IsStaticDataMember = VD.isStaticDataMember();
      IsDefinition = VD.isThisDeclarationADefinition(S.Context)
         != VarDecl.DefinitionKind.DeclarationOnly;
    } else {
      /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(NewDecl);
      if ((FD != null)) {
        IsInline = FD.isInlined();
        IsQualifiedFriend = (FD.getQualifier() != null)
           && FD.getFriendObjectKind() == Decl.FriendObjectKind.FOK_Declared;
      }
    }
  }
  if ((OldImportAttr != null) && !HasNewAttr && !IsInline && !IsStaticDataMember
     && !NewDecl.isLocalExternDecl() && !IsQualifiedFriend) {
    if (IsMicrosoft && IsDefinition) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewDecl.getLocation(), 
                diag.warn_redeclaration_without_import_attribute)), 
            NewDecl));
        $c$.clean($c$.track(S.Diag(OldDecl.getLocation(), diag.note_previous_declaration)));
        NewDecl.dropAttr(DLLImportAttr.class);
        NewDecl.addAttr(/*FIXME:NEW_EXPR*//*::*//*new (S.Context)*/ new DLLExportAttr(NewImportAttr.getRange(), S.Context, 
                NewImportAttr.getSpellingListIndex()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewDecl.getLocation(), 
                    diag.warn_redeclaration_without_attribute_prev_attribute_ignored)), 
                NewDecl), OldImportAttr));
        $c$.clean($c$.track(S.Diag(OldDecl.getLocation(), diag.note_previous_declaration)));
        $c$.clean($c$.track(S.Diag(OldImportAttr.getLocation(), diag.note_previous_attribute)));
        OldDecl.dropAttr(DLLImportAttr.class);
        NewDecl.dropAttr(DLLImportAttr.class);
      } finally {
        $c$.$destroy();
      }
    }
  } else if (IsInline && (OldImportAttr != null) && !IsMicrosoft) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // In MinGW, seeing a function declared inline drops the dllimport attribute.
      OldDecl.dropAttr(DLLImportAttr.class);
      NewDecl.dropAttr(DLLImportAttr.class);
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(NewDecl.getLocation(), 
                  diag.warn_dllimport_dropped_from_inline_function)), 
              NewDecl), OldImportAttr));
    } finally {
      $c$.$destroy();
    }
  }
}


/// Given that we are within the definition of the given function,
/// will that definition behave like C99's 'inline', where the
/// definition is discarded except for optimization purposes?
//<editor-fold defaultstate="collapsed" desc="isFunctionDefinitionDiscarded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5707,
 FQN="isFunctionDefinitionDiscarded", NM="_ZL29isFunctionDefinitionDiscardedRN5clang4SemaEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL29isFunctionDefinitionDiscardedRN5clang4SemaEPNS_12FunctionDeclE")
//</editor-fold>
public static boolean isFunctionDefinitionDiscarded(final Sema /*&*/ S, FunctionDecl /*P*/ FD) {
  // Try to avoid calling GetGVALinkageForFunction.
  
  // All cases of this require the 'inline' keyword.
  if (!FD.isInlined()) {
    return false;
  }
  
  // This is only possible in C++ with the gnu_inline attribute.
  if (S.getLangOpts().CPlusPlus && !FD.hasAttr(GNUInlineAttr.class)) {
    return false;
  }
  // AST quite reasonably asserts that it's working on a function
  // definition.  We don't really have a way to tell it that we're
  // currently defining the function, so just lie to it in +Asserts
  // builds.  This is an awful hack.
  FD.setLazyBody(1);
  
  boolean isC99Inline = S.Context.GetGVALinkageForFunction(FD) == GVALinkage.GVA_AvailableExternally;
  FD.setLazyBody(0);
  
  return isC99Inline;
}


/// Determine whether a variable is extern "C" prior to attaching
/// an initializer. We can't just call isExternC() here, because that
/// will also compute and cache whether the declaration is externally
/// visible, which might change when we attach the initializer.
///
/// This can only be used if the declaration is known to not be a
/// redeclaration of an internal linkage declaration.
///
/// For instance:
///
///   auto x = []{};
///
/// Attaching the initializer here makes this declaration not externally
/// visible, because its type has internal linkage.
///
/// FIXME: This is a hack.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="isIncompleteDeclExternC">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5754,
 FQN="isIncompleteDeclExternC", NM="Tpl__ZL23isIncompleteDeclExternCRN5clang4SemaEPKT_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL23isIncompleteDeclExternCRN5clang4SemaEPKT_")
//</editor-fold>
public static </*typename*/ T extends Decl> boolean isIncompleteDeclExternC(final Sema /*&*/ S, /*const*/ T /*P*/ _D) {
  if (_D instanceof VarDecl) {
    VarDecl D = (VarDecl)_D;
    if (S.getLangOpts().CPlusPlus) {
      // In C++, the overloadable attribute negates the effects of extern "C".
      if (Native.$not(D.isInExternCContext()) || Native.$bool(D./*template <OverloadableAttr>*/hasAttr(OverloadableAttr.class))) {
        return false;
      }

      // So do CUDA's host/device attributes.
      if (Native.$bool(S.getLangOpts().CUDA) && (Native.$bool(D./*template <CUDADeviceAttr>*/hasAttr(CUDADeviceAttr.class))
         || Native.$bool(D./*template <CUDAHostAttr>*/hasAttr(CUDAHostAttr.class)))) {
        return false;
      }
    }
    return D.isExternC();
  } else {
    FunctionDecl D = (FunctionDecl)_D;
    if (S.getLangOpts().CPlusPlus) {
      // In C++, the overloadable attribute negates the effects of extern "C".
      if (Native.$not(D.isInExternCContext()) || Native.$bool(D./*template <OverloadableAttr>*/hasAttr(OverloadableAttr.class))) {
        return false;
      }

      // So do CUDA's host/device attributes.
      if (Native.$bool(S.getLangOpts().CUDA) && (Native.$bool(D./*template <CUDADeviceAttr>*/hasAttr(CUDADeviceAttr.class))
         || Native.$bool(D./*template <CUDAHostAttr>*/hasAttr(CUDAHostAttr.class)))) {
        return false;
      }
    }
    return D.isExternC();
  }
}

//<editor-fold defaultstate="collapsed" desc="shouldConsiderLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5768,
 FQN="shouldConsiderLinkage", NM="_ZL21shouldConsiderLinkagePKN5clang7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL21shouldConsiderLinkagePKN5clang7VarDeclE")
//</editor-fold>
public static boolean shouldConsiderLinkage(/*const*/ VarDecl /*P*/ VD) {
  /*const*/ DeclContext /*P*/ DC = VD.getDeclContext$Const().getRedeclContext$Const();
  if (DC.isFunctionOrMethod() || isa_OMPDeclareReductionDecl(DC)) {
    return VD.hasExternalStorage();
  }
  if (DC.isFileContext()) {
    return true;
  }
  if (DC.isRecord()) {
    return false;
  }
  throw new llvm_unreachable("Unexpected context");
}

//<editor-fold defaultstate="collapsed" desc="shouldConsiderLinkage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5779,
 FQN="shouldConsiderLinkage", NM="_ZL21shouldConsiderLinkagePKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL21shouldConsiderLinkagePKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean shouldConsiderLinkage(/*const*/ FunctionDecl /*P*/ FD) {
  /*const*/ DeclContext /*P*/ DC = FD.getDeclContext$Const().getRedeclContext$Const();
  if (DC.isFileContext() || DC.isFunctionOrMethod()
     || isa_OMPDeclareReductionDecl(DC)) {
    return true;
  }
  if (DC.isRecord()) {
    return false;
  }
  throw new llvm_unreachable("Unexpected context");
}

//<editor-fold defaultstate="collapsed" desc="hasParsedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5789,
 FQN="hasParsedAttr", NM="_ZL13hasParsedAttrPN5clang5ScopeEPKNS_13AttributeListENS2_4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL13hasParsedAttrPN5clang5ScopeEPKNS_13AttributeListENS2_4KindE")
//</editor-fold>
public static boolean hasParsedAttr(Scope /*P*/ S, /*const*/ AttributeList /*P*/ AttrList, 
             AttributeList.Kind Kind) {
  for (/*const*/ AttributeList /*P*/ L = AttrList; (L != null); L = L.getNext())  {
    if (L.getKind() == Kind) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasParsedAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5797,
 FQN="hasParsedAttr", NM="_ZL13hasParsedAttrPN5clang5ScopeERKNS_10DeclaratorENS_13AttributeList4KindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL13hasParsedAttrPN5clang5ScopeERKNS_10DeclaratorENS_13AttributeList4KindE")
//</editor-fold>
public static boolean hasParsedAttr(Scope /*P*/ S, final /*const*/ Declarator /*&*/ PD, 
             AttributeList.Kind Kind) {
  // Check decl attributes on the DeclSpec.
  if (hasParsedAttr(S, PD.getDeclSpec().getAttributes$Const().getList(), Kind)) {
    return true;
  }
  
  // Walk the declarator structure, checking decl attributes that were in a type
  // position to the decl itself.
  for (/*uint*/int I = 0, E = PD.getNumTypeObjects(); I != E; ++I) {
    if (hasParsedAttr(S, PD.getTypeObject$Const(I).getAttrs(), Kind)) {
      return true;
    }
  }
  
  // Finally, check attributes on the decl itself.
  return hasParsedAttr(S, PD.getAttributes$Const(), Kind);
}


/// \brief Returns true if given declaration has external C language linkage.
//<editor-fold defaultstate="collapsed" desc="isDeclExternC">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 5839,
 FQN="isDeclExternC", NM="_ZL13isDeclExternCPKN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL13isDeclExternCPKN5clang4DeclE")
//</editor-fold>
public static boolean isDeclExternC(/*const*/ Decl /*P*/ D) {
  {
    /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
    if ((FD != null)) {
      return FD.isExternC();
    }
  }
  {
    /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(D);
    if ((VD != null)) {
      return VD.isExternC();
    }
  }
  throw new llvm_unreachable("Unknown type of decl!");
}


/// Determine what kind of declaration we're shadowing.
//<editor-fold defaultstate="collapsed" desc="computeShadowedDeclKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6518,
 FQN="computeShadowedDeclKind", NM="_ZL23computeShadowedDeclKindPKN5clang9NamedDeclEPKNS_11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL23computeShadowedDeclKindPKN5clang9NamedDeclEPKNS_11DeclContextE")
//</editor-fold>
public static ShadowedDeclKind computeShadowedDeclKind(/*const*/ NamedDecl /*P*/ ShadowedDecl, 
                       /*const*/ DeclContext /*P*/ OldDC) {
  if (isa_RecordDecl(OldDC)) {
    return isa_FieldDecl(ShadowedDecl) ? ShadowedDeclKind.SDK_Field : ShadowedDeclKind.SDK_StaticMember;
  }
  return OldDC.isFileContext() ? ShadowedDeclKind.SDK_Global : ShadowedDeclKind.SDK_Local;
}


/// Check for conflict between this global or extern "C" declaration and
/// previous global or extern "C" declarations. This is only used in C++.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="checkGlobalOrExternCConflict">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6646,
 FQN="checkGlobalOrExternCConflict", NM="Tpl__ZL28checkGlobalOrExternCConflictRN5clang4SemaEPKT_bRNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL28checkGlobalOrExternCConflictRN5clang4SemaEPKT_bRNS_12LookupResultE")
//</editor-fold>
public static </*typename*/ T extends NamedDecl> boolean checkGlobalOrExternCConflict(final Sema /*&*/ S, /*const*/ T /*P*/ ND, boolean IsGlobal, final LookupResult /*&*/ Previous) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (S.getLangOpts().CPlusPlus) : "only C++ has extern \"C\"";
    NamedDecl /*P*/ Prev = S.findLocallyScopedExternCDecl(ND.getDeclName());
    if (!(Prev != null) && IsGlobal && Native.$not(isIncompleteDeclExternC(S, ND))) {
      // The common case: this global doesn't conflict with any extern "C"
      // declaration.
      return false;
    }
    if ((Prev != null)) {
      if (!IsGlobal || isIncompleteDeclExternC(S, ND)) {
        // Both the old and new declarations have C language linkage. This is a
        // redeclaration.
        Previous.clear();
        Previous.addDecl(Prev);
        return true;
      }
      
      // This is a global, non-extern "C" declaration, and there is a previous
      // non-global extern "C" declaration. Diagnose if this is a variable
      // declaration.
      if (Native.$not(isa_VarDecl(ND))) {
        return false;
      }
    } else {
      // The declaration is extern "C". Check for any declaration in the
      // translation unit which might conflict.
      if (IsGlobal) {
        // We have already performed the lookup into the translation unit.
        IsGlobal = false;
        for (UnresolvedSetIterator I = Previous.begin(), E = Previous.end();
             I.$noteq(E); I.$preInc()) {
          if (isa_VarDecl(I.$star())) {
            Prev = I.$star();
            break;
          }
        }
      } else {
        DeclContextLookupResult R = S.Context.getTranslationUnitDecl().lookup(ND.getDeclName());
        for (DeclContextLookupResult.iterator I = R.begin(), E = R.end();
             I.$noteq(E); I.$preInc()) {
          if (isa_VarDecl(I.$star())) {
            Prev = I.$star();
            break;
          }
          // FIXME: If we have any other entity with this name in global scope,
          // the declaration is ill-formed, but that is a defect: it breaks the
          // 'stat' hack, for instance. Only variables can have mangled name
          // clashes with extern "C" declarations, so only they deserve a
          // diagnostic.
        }
      }
      if (!(Prev != null)) {
        return false;
      }
    }
    
    // Use the first declaration's location to ensure we point at something which
    // is lexically inside an extern "C" linkage-spec.
    assert ((Prev != null)) : "should have found a previous declaration to diagnose";
    {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Prev);
      if ((FD != null)) {
        Prev = FD.getFirstDecl();
      } else {
        Prev = cast_VarDecl(Prev).getFirstDecl();
      }
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ND.getLocation(), diag.err_extern_c_global_conflict)), 
            IsGlobal), ND));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Prev.getLocation(), diag.note_extern_c_global_conflict)), 
        IsGlobal));
    return false;
  } finally {
    $c$.$destroy();
  }
}


/// Apply special rules for handling extern "C" declarations. Returns \c true
/// if we have found that this is a redeclaration of some prior entity.
///
/// Per C++ [dcl.link]p6:
///   Two declarations [for a function or variable] with C language linkage
///   with the same name that appear in different scopes refer to the same
///   [entity]. An entity with C language linkage shall not be declared with
///   the same name as an entity in global scope.
/*template <typename T> TEMPLATE*/
//<editor-fold defaultstate="collapsed" desc="checkForConflictWithNonVisibleExternC">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 6729,
 FQN="checkForConflictWithNonVisibleExternC", NM="Tpl__ZL37checkForConflictWithNonVisibleExternCRN5clang4SemaEPKT_RNS_12LookupResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=Tpl__ZL37checkForConflictWithNonVisibleExternCRN5clang4SemaEPKT_RNS_12LookupResultE")
//</editor-fold>
public static </*typename*/ T extends NamedDecl> boolean checkForConflictWithNonVisibleExternC(final Sema /*&*/ S, /*const*/ T /*P*/ ND, 
                                     final LookupResult /*&*/ Previous) {
  if (!S.getLangOpts().CPlusPlus) {
    // In C, when declaring a global variable, look for a corresponding 'extern'
    // variable declared in function scope. We don't need this in C++, because
    // we find local extern decls in the surrounding file-scope DeclContext.
    if (ND.getDeclContext().getRedeclContext().isTranslationUnit()) {
      {
        NamedDecl /*P*/ Prev = S.findLocallyScopedExternCDecl(ND.getDeclName());
        if ((Prev != null)) {
          Previous.clear();
          Previous.addDecl(Prev);
          return true;
        }
      }
    }
    return false;
  }
  
  // A declaration in the translation unit can conflict with an extern "C"
  // declaration.
  if (ND.getDeclContext().getRedeclContext().isTranslationUnit()) {
    return checkGlobalOrExternCConflict(S, ND, /*IsGlobal*/ true, Previous);
  }
  
  // An extern "C" declaration can conflict with a declaration in the
  // translation unit or can be a redeclaration of an extern "C" declaration
  // in another scope.
  if (isIncompleteDeclExternC(S, ND)) {
    return checkGlobalOrExternCConflict(S, ND, /*IsGlobal*/ false, Previous);
  }
  
  // Neither global nor extern "C": nothing to do.
  return false;
}

// end anonymous namespace

/// \brief Report an error regarding overriding, along with any relevant
/// overriden methods.
///
/// \param DiagID the primary error to report.
/// \param MD the overriding method.
/// \param OEK which overrides to include as notes.
//<editor-fold defaultstate="collapsed" desc="ReportOverrides">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7046,
 FQN="ReportOverrides", NM="_ZL15ReportOverridesRN5clang4SemaEjPKNS_13CXXMethodDeclEN12_GLOBAL__N_117OverrideErrorKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL15ReportOverridesRN5clang4SemaEjPKNS_13CXXMethodDeclEN12_GLOBAL__N_117OverrideErrorKindE")
//</editor-fold>
public static void ReportOverrides(final Sema /*&*/ S, /*uint*/int DiagID, /*const*/ CXXMethodDecl /*P*/ MD) {
  ReportOverrides(S, DiagID, MD, 
               OverrideErrorKind.OEK_All);
}
public static void ReportOverrides(final Sema /*&*/ S, /*uint*/int DiagID, /*const*/ CXXMethodDecl /*P*/ MD, 
               OverrideErrorKind OEK/*= OEK_All*/) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(MD.getLocation(), DiagID)), MD.getDeclName()));
    for (type$ptr<CXXMethodDecl>/*method_iterator*/ I = $tryClone(MD.begin_overridden_methods()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(MD.end_overridden_methods());
         $noteq_ptr(I, E); I.$preInc()) {
      // This check (& the OEK parameter) could be replaced by a predicate, but
      // without lambdas that would be overkill. This is still nicer than writing
      // out the diag loop 3 times.
      if ((OEK == OverrideErrorKind.OEK_All)
         || (OEK == OverrideErrorKind.OEK_NonDeleted && !(I.$star()).isDeleted())
         || (OEK == OverrideErrorKind.OEK_Deleted && (I.$star()).isDeleted())) {
        $c$.clean($c$.track(S.Diag((I.$star()).getLocation(), diag.note_overridden_virtual_function)));
      }
    }
  } finally {
    $c$.$destroy();
  }
}

// end anonymous namespace

/// \brief Generate diagnostics for an invalid function redeclaration.
///
/// This routine handles generating the diagnostic messages for an invalid
/// function redeclaration, including finding possible similar declarations
/// or performing typo correction if there are no previous declarations with
/// the same name.
///
/// Returns a NamedDecl iff typo correction was performed and substituting in
/// the new declaration name does not cause new errors.
//<editor-fold defaultstate="collapsed" desc="DiagnoseInvalidRedeclaration">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7163,
 FQN="DiagnoseInvalidRedeclaration", NM="_ZL28DiagnoseInvalidRedeclarationRN5clang4SemaERNS_12LookupResultEPNS_12FunctionDeclERN12_GLOBAL__N_111ActOnFDArgsEbPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL28DiagnoseInvalidRedeclarationRN5clang4SemaERNS_12LookupResultEPNS_12FunctionDeclERN12_GLOBAL__N_111ActOnFDArgsEbPNS_5ScopeE")
//</editor-fold>
public static NamedDecl /*P*/ DiagnoseInvalidRedeclaration(final Sema /*&*/ SemaRef, final LookupResult /*&*/ Previous, FunctionDecl /*P*/ NewFD, 
                            final ActOnFDArgs /*&*/ ExtraArgs, boolean IsLocalFriend, Scope /*P*/ S) {
  TypoCorrection Correction = null;
  LookupResult Prev = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DeclarationName Name = NewFD.getDeclName();
    DeclContext /*P*/ NewDC = NewFD.getDeclContext();
    SmallVectorUInt MismatchedParams/*J*/= new SmallVectorUInt(1, 0);
    SmallVector<std.pairTypeUInt<FunctionDecl /*P*/ >> NearMatches/*J*/= new SmallVector<std.pairTypeUInt<FunctionDecl /*P*/ >>(1, new std.pairPtrUInt<FunctionDecl /*P*/ >());
    Correction/*J*/= new TypoCorrection();
    boolean IsDefinition = ExtraArgs.D.isFunctionDefinition();
    /*uint*/int DiagMsg = IsLocalFriend ? diag.err_no_matching_local_friend : diag.err_member_decl_does_not_match;
    Prev/*J*/= new LookupResult(SemaRef, new DeclarationName(Name), NewFD.getLocation(), 
        IsLocalFriend ? Sema.LookupNameKind.LookupLocalFriendName : Sema.LookupNameKind.LookupOrdinaryName, 
        Sema.RedeclarationKind.ForRedeclaration);
    
    NewFD.setInvalidDecl();
    if (IsLocalFriend) {
      SemaRef.LookupName(Prev, S);
    } else {
      SemaRef.LookupQualifiedName(Prev, NewDC);
    }
    assert (!Prev.isAmbiguous()) : "Cannot have an ambiguity in previous-declaration lookup";
    CXXMethodDecl /*P*/ MD = dyn_cast_CXXMethodDecl(NewFD);
    if (!Prev.empty()) {
      for (UnresolvedSetIterator Func = Prev.begin(), FuncEnd = Prev.end();
           Func.$noteq(FuncEnd); Func.$preInc()) {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(Func.$star());
        if ((FD != null)
           && hasSimilarParameters(SemaRef.Context, FD, NewFD, MismatchedParams)) {
          // Add 1 to the index so that 0 can mean the mismatch didn't
          // involve a parameter
          /*uint*/int ParamNum = MismatchedParams.empty() ? 0 : MismatchedParams.front() + 1;
          NearMatches.push_back(std.make_pair_Ptr_uint(FD, ParamNum));
        }
      }
      // If the qualified name lookup yielded nothing, try typo correction
    } else if ($c$.clean((Correction.$assignMove($c$.track(SemaRef.CorrectTypo(Prev.getLookupNameInfo(), Prev.getLookupKind(), S, 
            $AddrOf(ExtraArgs.D.getCXXScopeSpec()), 
            $c$.track(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new DifferentNameValidatorCCC(SemaRef.Context, NewFD, (MD != null) ? MD.getParent() : (CXXRecordDecl /*P*/ )null))))), 
            Sema.CorrectTypoKind.CTK_ErrorRecovery, IsLocalFriend ? (DeclContext /*P*/ )null : NewDC)))).$bool())) {
      // Set up everything for the call to ActOnFunctionDeclarator
      ExtraArgs.D.SetIdentifier(Correction.getCorrectionAsIdentifierInfo(), 
          ExtraArgs.D.getIdentifierLoc());
      Previous.clear();
      Previous.setLookupName(Correction.getCorrection());
      for (type$ptr<NamedDecl /*P*/ /*P*/> CDecl = Correction.begin(), 
          /*P*/ CDeclEnd = Correction.end();
           $noteq_iter(CDecl, CDeclEnd); CDecl.$preInc()) {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(CDecl.$star());
        if ((FD != null) && !FD.hasBody()
           && hasSimilarParameters(SemaRef.Context, FD, NewFD, MismatchedParams)) {
          Previous.addDecl(FD);
        }
      }
      boolean wasRedeclaration = ExtraArgs.D.isRedeclaration();
      
      NamedDecl /*P*/ Result;
      {
        Sema.SFINAETrap Trap = null;
        try {
          // Trap errors.
          Trap/*J*/= new Sema.SFINAETrap(SemaRef);
          
          // TODO: Refactor ActOnFunctionDeclarator so that we can call only the
          // pieces need to verify the typo-corrected C++ declaration and hopefully
          // eliminate the need for the parameter pack ExtraArgs.
          Result = SemaRef.ActOnFunctionDeclarator(ExtraArgs.S, ExtraArgs.D, 
              Correction.getCorrectionDecl().getDeclContext(), 
              NewFD.getTypeSourceInfo(), Previous, new MutableArrayRef<TemplateParameterList /*P*/ >(ExtraArgs.TemplateParamLists), 
              ExtraArgs.AddToScope$Ref);
          if (Trap.hasErrorOccurred()) {
            Result = null;
          }
        } finally {
          if (Trap != null) { Trap.$destroy(); }
        }
      }
      if ((Result != null)) {
        // Determine which correction we picked.
        Decl /*P*/ Canonical = Result.getCanonicalDecl();
        for (UnresolvedSetIterator I = Previous.begin(), E = Previous.end();
             I.$noteq(E); I.$preInc())  {
          if ((I.$star()).getCanonicalDecl() == Canonical) {
            Correction.setCorrectionDecl(I.$star());
          }
        }
        
        SemaRef.diagnoseTypo(Correction, 
            $out_PartialDiagnostic$C_int($out$Same2DeclContext($out_PartialDiagnostic$C_DeclarationName($c$.track(SemaRef.PDiag(IsLocalFriend ? diag.err_no_matching_local_friend_suggest : diag.err_member_decl_does_not_match_suggest)), 
                        /*NO_COPY*/Name), NewDC), (IsDefinition ? 1 : 0))); $c$.clean();
        return Result;
      }
      
      // Pretend the typo correction never occurred
      ExtraArgs.D.SetIdentifier(Name.getAsIdentifierInfo(), 
          ExtraArgs.D.getIdentifierLoc());
      ExtraArgs.D.setRedeclaration(wasRedeclaration);
      Previous.clear();
      Previous.setLookupName(new DeclarationName(Name));
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(NewFD.getLocation(), DiagMsg)), 
                    Name), NewDC), IsDefinition), NewFD.getLocation()));
    
    boolean NewFDisConst = false;
    {
      CXXMethodDecl /*P*/ NewMD = dyn_cast_CXXMethodDecl(NewFD);
      if ((NewMD != null)) {
        NewFDisConst = NewMD.isConst();
      }
    }
    for (type$ptr<std.pairTypeUInt<FunctionDecl /*P*/ >>  /*P*/ NearMatch = NearMatches.begin(), /*P*/ NearMatchEnd = NearMatches.end();
         NearMatch.$noteq(NearMatchEnd); NearMatch.$preInc()) {
      FunctionDecl /*P*/ FD = NearMatch.$star().first;
      CXXMethodDecl /*P*/ MD$1 = dyn_cast_CXXMethodDecl(FD);
      boolean FDisConst = (MD$1 != null) && MD$1.isConst();
      boolean IsMember = (MD$1 != null) || !IsLocalFriend;
      {
        
        // FIXME: These notes are poorly worded for the local friend case.
        /*uint*/int Idx = NearMatch.$star().second;
        if ((Idx != 0)) {
          ParmVarDecl /*P*/ FDParam = FD.getParamDecl(Idx - 1);
          SourceLocation Loc = FDParam.getTypeSpecStartLoc();
          if (Loc.isInvalid()) {
            Loc.$assignMove(FD.getLocation());
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(new SourceLocation(Loc), IsMember ? diag.note_member_def_close_param_match : diag.note_local_decl_close_param_match)), 
                      Idx), FDParam.getType()), 
              NewFD.getParamDecl(Idx - 1).getType()));
        } else if (FDisConst != NewFDisConst) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(FD.getLocation(), diag.note_member_def_close_const_match)), 
                  NewFDisConst), FD.getSourceRange().getEnd()));
        } else {
          $c$.clean($c$.track(SemaRef.Diag(FD.getLocation(), 
              IsMember ? diag.note_member_def_close_match : diag.note_local_decl_close_match)));
        }
      }
    }
    return null;
  } finally {
    if (Prev != null) { Prev.$destroy(); }
    if (Correction != null) { Correction.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="getFunctionStorageClass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7303,
 FQN="getFunctionStorageClass", NM="_ZL23getFunctionStorageClassRN5clang4SemaERNS_10DeclaratorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL23getFunctionStorageClassRN5clang4SemaERNS_10DeclaratorE")
//</editor-fold>
public static StorageClass getFunctionStorageClass(final Sema /*&*/ SemaRef, final Declarator /*&*/ D) {
  switch (D.getDeclSpec().getStorageClassSpec()) {
   default:
    throw new llvm_unreachable("Unknown storage class!");
   case SCS_auto:
   case SCS_register:
   case SCS_mutable:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(SemaRef.Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
            diag.err_typecheck_sclass_func)));
        D.setInvalidType();
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case SCS_unspecified:
    break;
   case SCS_extern:
    if (D.getDeclSpec().isExternInLinkageSpec()) {
      return StorageClass.SC_None;
    }
    return StorageClass.SC_Extern;
   case SCS_static:
    {
      if (SemaRef.CurContext.getRedeclContext().isFunctionOrMethod()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C99 6.7.1p5:
          //   The declaration of an identifier for a function that has
          //   block scope shall have no explicit storage-class specifier
          //   other than extern
          // See also (C++ [dcl.stc]p4).
          $c$.clean($c$.track(SemaRef.Diag(D.getDeclSpec().getStorageClassSpecLoc(), 
              diag.err_static_block_func)));
          break;
        } finally {
          $c$.$destroy();
        }
      } else {
        return StorageClass.SC_Static;
      }
    }
   case SCS_private_extern:
    return StorageClass.SC_PrivateExtern;
  }
  
  // No explicit storage class has already been returned
  return StorageClass.SC_None;
}

//<editor-fold defaultstate="collapsed" desc="CreateNewFunctionDecl">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7338,
 FQN="CreateNewFunctionDecl", NM="_ZL21CreateNewFunctionDeclRN5clang4SemaERNS_10DeclaratorEPNS_11DeclContextERNS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL21CreateNewFunctionDeclRN5clang4SemaERNS_10DeclaratorEPNS_11DeclContextERNS_8QualTypeEPNS_14TypeSourceInfoENS_12StorageClassERb")
//</editor-fold>
public static FunctionDecl /*P*/ CreateNewFunctionDecl(final Sema /*&*/ SemaRef, final Declarator /*&*/ D, 
                     DeclContext /*P*/ DC, final QualType /*&*/ R, 
                     TypeSourceInfo /*P*/ TInfo, 
                     StorageClass _SC, 
                     final bool$ref/*bool &*/ IsVirtualOkay) {
  final type$ref<StorageClass> SC = create_type$ref(_SC);
  DeclarationNameInfo NameInfo = SemaRef.GetNameForDeclarator(D);
  DeclarationName Name = NameInfo.getName();
  
  FunctionDecl /*P*/ NewFD = null;
  boolean isInline = D.getDeclSpec().isInlineSpecified();
  if (!SemaRef.getLangOpts().CPlusPlus) {
    // Determine whether the function was written with a
    // prototype. This true when:
    //   - there is a prototype in the declarator, or
    //   - the type R of the function is some kind of typedef or other reference
    //     to a type name (which eventually refers to a function type).
    boolean HasPrototype = (D.isFunctionDeclarator() && D.getFunctionTypeInfo().hasPrototype)
       || (!isa_FunctionType(R.getTypePtr()) && R.$arrow().isFunctionProtoType());
    
    NewFD = FunctionDecl.Create(SemaRef.Context, DC, 
        D.getLocStart(), NameInfo, new QualType(R), 
        TInfo, SC.$deref(), isInline, 
        HasPrototype, false);
    if (D.isInvalidType()) {
      NewFD.setInvalidDecl();
    }
    
    return NewFD;
  }
  
  boolean isExplicit = D.getDeclSpec().isExplicitSpecified();
  boolean isConstexpr = D.getDeclSpec().isConstexprSpecified();
  
  // Check that the return type is not an abstract class type.
  // For record types, this is done by the AbstractClassUsageDiagnoser once
  // the class has been completely parsed.
  if (!DC.isRecord()
     && SemaRef.RequireNonAbstractType$T(D.getIdentifierLoc(), R.$arrow().getAs(FunctionType.class).getReturnType(), 
      diag.err_abstract_type_in_decl, Sema.AbstractDiagSelID.AbstractReturnType)) {
    D.setInvalidType();
  }
  if (Name.getNameKind() == DeclarationName.NameKind.CXXConstructorName) {
    // This is a C++ constructor declaration.
    assert (DC.isRecord()) : "Constructors can only be declared in a member context";
    
    R.$assignMove(SemaRef.CheckConstructorDeclarator(D, new QualType(R), SC));
    return CXXConstructorDecl.Create(SemaRef.Context, cast_CXXRecordDecl(DC), 
        D.getLocStart(), NameInfo, 
        new QualType(R), TInfo, isExplicit, isInline, 
        /*isImplicitlyDeclared=*/ false, 
        isConstexpr);
  } else if (Name.getNameKind() == DeclarationName.NameKind.CXXDestructorName) {
    // This is a C++ destructor declaration.
    if (DC.isRecord()) {
      R.$assignMove(SemaRef.CheckDestructorDeclarator(D, new QualType(R), SC));
      CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(DC);
      CXXDestructorDecl /*P*/ NewDD = CXXDestructorDecl.Create(SemaRef.Context, Record, 
          D.getLocStart(), 
          NameInfo, new QualType(R), TInfo, isInline, 
          /*isImplicitlyDeclared=*/ false);
      
      // If the class is complete, then we now create the implicit exception
      // specification. If the class is incomplete or dependent, we can't do
      // it yet.
      if (SemaRef.getLangOpts().CPlusPlus11 && !Record.isDependentType()
         && (Record.getDefinition() != null) && !Record.isBeingDefined()
         && R.$arrow().getAs(FunctionProtoType.class).getExceptionSpecType() == ExceptionSpecificationType.EST_None) {
        SemaRef.AdjustDestructorExceptionSpec(Record, NewDD);
      }
      
      IsVirtualOkay.$set(true);
      return NewDD;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(SemaRef.Diag(D.getIdentifierLoc(), diag.err_destructor_not_member)));
        D.setInvalidType();
        
        // Create a FunctionDecl to satisfy the function definition parsing
        // code path.
        return FunctionDecl.Create(SemaRef.Context, DC, 
            D.getLocStart(), 
            D.getIdentifierLoc(), new DeclarationName(Name), new QualType(R), TInfo, 
            SC.$deref(), isInline, 
            /*hasPrototype=*/ true, isConstexpr);
      } finally {
        $c$.$destroy();
      }
    }
  } else if (Name.getNameKind() == DeclarationName.NameKind.CXXConversionFunctionName) {
    if (!DC.isRecord()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(SemaRef.Diag(D.getIdentifierLoc(), 
            diag.err_conv_function_not_member)));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    SemaRef.CheckConversionDeclarator(D, R, SC);
    IsVirtualOkay.$set(true);
    return CXXConversionDecl.Create(SemaRef.Context, cast_CXXRecordDecl(DC), 
        D.getLocStart(), NameInfo, 
        new QualType(R), TInfo, isInline, isExplicit, 
        isConstexpr, new SourceLocation());
  } else if (DC.isRecord()) {
    // If the name of the function is the same as the name of the record,
    // then this must be an invalid constructor that has a return type.
    // (The parser checks for a return type and makes the declarator a
    // constructor if it has no return type).
    if ((Name.getAsIdentifierInfo() != null)
       && Name.getAsIdentifierInfo() == cast_CXXRecordDecl(DC).getIdentifier()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(D.getIdentifierLoc(), diag.err_constructor_return_type)), 
                new SourceRange(D.getDeclSpec().getTypeSpecTypeLoc())), 
            new SourceRange(D.getIdentifierLoc())));
        return null;
      } finally {
        $c$.$destroy();
      }
    }
    
    // This is a C++ method declaration.
    CXXMethodDecl /*P*/ Ret = CXXMethodDecl.Create(SemaRef.Context, 
        cast_CXXRecordDecl(DC), 
        D.getLocStart(), NameInfo, new QualType(R), 
        TInfo, SC.$deref(), isInline, 
        isConstexpr, new SourceLocation());
    IsVirtualOkay.$set(!Ret.isStatic());
    return Ret;
  } else {
    boolean isFriend = SemaRef.getLangOpts().CPlusPlus && D.getDeclSpec().isFriendSpecified();
    if (!isFriend && SemaRef.CurContext.isRecord()) {
      return null;
    }
    
    // Determine whether the function was written with a
    // prototype. This true when:
    //   - we're in C++ (where every function has a prototype),
    return FunctionDecl.Create(SemaRef.Context, DC, 
        D.getLocStart(), 
        NameInfo, new QualType(R), TInfo, SC.$deref(), isInline, 
        true/*HasPrototype*/, isConstexpr);
  }
}

//<editor-fold defaultstate="collapsed" desc="getOpenCLKernelParameterType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7489,
 FQN="getOpenCLKernelParameterType", NM="_ZL28getOpenCLKernelParameterTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL28getOpenCLKernelParameterTypeN5clang8QualTypeE")
//</editor-fold>
public static OpenCLParamType getOpenCLKernelParameterType(QualType PT) {
  if (PT.$arrow().isPointerType()) {
    QualType PointeeType = PT.$arrow().getPointeeType();
    if (PointeeType.$arrow().isPointerType()) {
      return OpenCLParamType.PtrPtrKernelParam;
    }
    return PointeeType.getAddressSpace() == 0 ? OpenCLParamType.PrivatePtrKernelParam : OpenCLParamType.PtrKernelParam;
  }
  
  // TODO: Forbid the other integer types (size_t, ptrdiff_t...) when they can
  // be used as builtin types.
  if (PT.$arrow().isImageType()) {
    return OpenCLParamType.PtrKernelParam;
  }
  if (PT.$arrow().isBooleanType()) {
    return OpenCLParamType.InvalidKernelParam;
  }
  if (PT.$arrow().isEventT()) {
    return OpenCLParamType.InvalidKernelParam;
  }
  if (PT.$arrow().isHalfType()) {
    return OpenCLParamType.InvalidKernelParam;
  }
  if (PT.$arrow().isRecordType()) {
    return OpenCLParamType.RecordKernelParam;
  }
  
  return OpenCLParamType.ValidKernelParam;
}

//<editor-fold defaultstate="collapsed" desc="checkIsValidOpenCLKernelParameter">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 7519,
 FQN="checkIsValidOpenCLKernelParameter", NM="_ZL33checkIsValidOpenCLKernelParameterRN5clang4SemaERNS_10DeclaratorEPNS_11ParmVarDeclERN4llvm15SmallPtrSetImplIPKNS_4TypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL33checkIsValidOpenCLKernelParameterRN5clang4SemaERNS_10DeclaratorEPNS_11ParmVarDeclERN4llvm15SmallPtrSetImplIPKNS_4TypeEEE")
//</editor-fold>
public static void checkIsValidOpenCLKernelParameter(final Sema /*&*/ S, 
                                 final Declarator /*&*/ D, 
                                 ParmVarDecl /*P*/ Param, 
                                 final SmallPtrSetImpl</*const*/ Type /*P*/ > /*&*/ ValidTypes) {
  QualType PT = Param.getType();
  
  // Cache the valid types we encounter to avoid rechecking structs that are
  // used again
  if ((ValidTypes.count(PT.getTypePtr()) != 0)) {
    return;
  }
  switch (getOpenCLKernelParameterType(new QualType(PT))) {
   case PtrPtrKernelParam:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // OpenCL v1.2 s6.9.a:
        // A kernel function argument cannot be declared as a
        // pointer to a pointer type.
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.err_opencl_ptrptr_kernel_param)));
        D.setInvalidType();
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case PrivatePtrKernelParam:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // OpenCL v1.2 s6.9.a:
        // A kernel function argument cannot be declared as a
        // pointer to the private address space.
        $c$.clean($c$.track(S.Diag(Param.getLocation(), diag.err_opencl_private_ptr_kernel_param)));
        D.setInvalidType();
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case InvalidKernelParam:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // OpenCL v1.2 s6.8 n:
        // A kernel function argument cannot be declared
        // of event_t type.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Param.getLocation(), diag.err_bad_kernel_param_type)), PT));
        D.setInvalidType();
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case PtrKernelParam:
   case ValidKernelParam:
    ValidTypes.insert(PT.getTypePtr());
    return;
   case RecordKernelParam:
    break;
  }
  
  // Track nested structs we will inspect
  SmallVector</*const*/ Decl /*P*/ > VisitStack/*J*/= new SmallVector</*const*/ Decl /*P*/ >(4, (/*const*/ Decl /*P*/ )null);
  
  // Track where we are in the nested structs. Items will migrate from
  // VisitStack to HistoryStack as we do the DFS for bad field.
  SmallVector</*const*/ FieldDecl /*P*/ > HistoryStack/*J*/= new SmallVector</*const*/ FieldDecl /*P*/ >(4, (/*const*/ FieldDecl /*P*/ )null);
  HistoryStack.push_back((/*const*/ FieldDecl /*P*/ /*const*/)null);
  
  /*const*/ RecordDecl /*P*/ PD = PT.$arrow().<RecordType>castAs$RecordType().getDecl();
  VisitStack.push_back(PD);
  assert ((VisitStack.back() != null)) : "First decl null?";
  
  do {
    /*const*/ Decl /*P*/ Next = VisitStack.pop_back_val();
    if (!(Next != null)) {
      assert (!HistoryStack.empty());
      {
        // Found a marker, we have gone up a level
        /*const*/ FieldDecl /*P*/ Hist = HistoryStack.pop_back_val();
        if ((Hist != null)) {
          ValidTypes.insert(Hist.getType().getTypePtr());
        }
      }
      
      continue;
    }
    
    // Adds everything except the original parameter declaration (which is not a
    // field itself) to the history stack.
    /*const*/ RecordDecl /*P*/ RD;
    {
      /*const*/ FieldDecl /*P*/ Field = dyn_cast_FieldDecl(Next);
      if ((Field != null)) {
        HistoryStack.push_back(Field);
        RD = Field.getType().$arrow().<RecordType>castAs$RecordType().getDecl();
      } else {
        RD = cast_RecordDecl(Next);
      }
    }
    
    // Add a null marker so we know when we've gone back up a level
    VisitStack.push_back((/*const*/ Decl /*P*/ /*const*/)null);
    
    for (/*const*/ FieldDecl /*P*/ FD : RD.fields()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        QualType QT = FD.getType();
        if ((ValidTypes.count(QT.getTypePtr()) != 0)) {
          continue;
        }
        
        OpenCLParamType ParamType = getOpenCLKernelParameterType(new QualType(QT));
        if (ParamType == OpenCLParamType.ValidKernelParam) {
          continue;
        }
        if (ParamType == OpenCLParamType.RecordKernelParam) {
          VisitStack.push_back(FD);
          continue;
        }
        
        // OpenCL v1.2 s6.9.p:
        // Arguments to kernel functions that are declared to be a struct or union
        // do not allow OpenCL objects to be passed as elements of the struct or
        // union.
        if (ParamType == OpenCLParamType.PtrKernelParam || ParamType == OpenCLParamType.PtrPtrKernelParam
           || ParamType == OpenCLParamType.PrivatePtrKernelParam) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Param.getLocation(), 
                      diag.err_record_with_pointers_kernel_param)), 
                  PT.$arrow().isUnionType()), 
              PT));
        } else {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Param.getLocation(), diag.err_bad_kernel_param_type)), PT));
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PD.getLocation(), diag.note_within_field_of_type)), 
            PD.getDeclName()));
        
        // We have an error, now let's go back up through history and show where
        // the offending field came from
        for (type$ptr</*const*/ FieldDecl /*P*/ /*P*/> I = HistoryStack.begin().$preInc(), 
            /*P*/ E = HistoryStack.end();
             $noteq_ptr(I, E); I.$preInc()) {
          /*const*/ FieldDecl /*P*/ OuterField = I.$star();
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(OuterField.getLocation(), diag.note_within_field_of_type)), 
              OuterField.getType()));
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), diag.note_illegal_field_declared_here)), 
                QT.$arrow().isPointerType()), 
            QT));
        D.setInvalidType();
        return;
      } finally {
        $c$.$destroy();
      }
    }
  } while (!VisitStack.empty());
}


/// CheckSelfReference - Warns if OrigDecl is used in expression E.
//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::CheckSelfReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 9402,
 FQN="(anonymous namespace)::CheckSelfReference", NM="_ZN12_GLOBAL__N_1L18CheckSelfReferenceERN5clang4SemaEPNS0_4DeclEPNS0_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_1L18CheckSelfReferenceERN5clang4SemaEPNS0_4DeclEPNS0_4ExprEb")
//</editor-fold>
public static void CheckSelfReference(final Sema /*&*/ S, Decl /*P*/ OrigDecl, Expr /*P*/ E, 
                  boolean DirectInit) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Parameters arguments are occassionially constructed with itself,
    // for instance, in recursive functions.  Skip them.
    if (isa_ParmVarDecl(OrigDecl)) {
      return;
    }
    
    E = E.IgnoreParens();
    
    // Skip checking T a = a where T is not a record or reference type.
    // Doing so is a way to silence uninitialized warnings.
    if (!DirectInit && !cast_VarDecl(OrigDecl).getType().$arrow().isRecordType()) {
      {
        ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
        if ((ICE != null)) {
          if (ICE.getCastKind() == CastKind.CK_LValueToRValue) {
            {
              DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(ICE.getSubExpr());
              if ((DRE != null)) {
                if (DRE.getDecl() == OrigDecl) {
                  return;
                }
              }
            }
          }
        }
      }
    }
    
    $c$.track(new SelfReferenceChecker(S, OrigDecl)).CheckExpr(E); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determines if a variable's alignment is dependent.
//<editor-fold defaultstate="collapsed" desc="hasDependentAlignment">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 10479,
 FQN="hasDependentAlignment", NM="_ZL21hasDependentAlignmentPN5clang7VarDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL21hasDependentAlignmentPN5clang7VarDeclE")
//</editor-fold>
public static boolean hasDependentAlignment(VarDecl /*P*/ VD) {
  if (VD.getType().$arrow().isDependentType()) {
    return true;
  }
  for (AlignedAttr /*P*/ I : VD.specific_attrs(AlignedAttr.class))  {
    if (I.isAlignmentDependent()) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="ShouldWarnAboutMissingPrototype">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11091,
 FQN="ShouldWarnAboutMissingPrototype", NM="_ZL31ShouldWarnAboutMissingPrototypePKN5clang12FunctionDeclERS2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL31ShouldWarnAboutMissingPrototypePKN5clang12FunctionDeclERS2_")
//</editor-fold>
public static boolean ShouldWarnAboutMissingPrototype(/*const*/ FunctionDecl /*P*/ FD, 
                               final /*const*/type$ref<FunctionDecl /*P*/> PossibleZeroParamPrototype) {
  // Don't warn about invalid declarations.
  if (FD.isInvalidDecl()) {
    return false;
  }
  
  // Or declarations that aren't global.
  if (!FD.isGlobal()) {
    return false;
  }
  
  // Don't warn about C++ member functions.
  if (isa_CXXMethodDecl(FD)) {
    return false;
  }
  
  // Don't warn about 'main'.
  if (FD.isMain()) {
    return false;
  }
  
  // Don't warn about inline functions.
  if (FD.isInlined()) {
    return false;
  }
  
  // Don't warn about function templates.
  if ((FD.getDescribedFunctionTemplate() != null)) {
    return false;
  }
  
  // Don't warn about function template specializations.
  if (FD.isFunctionTemplateSpecialization()) {
    return false;
  }
  
  // Don't warn for OpenCL kernels.
  if (FD.hasAttr(OpenCLKernelAttr.class)) {
    return false;
  }
  
  // Don't warn on explicitly deleted functions.
  if (FD.isDeleted()) {
    return false;
  }
  
  boolean MissingPrototype = true;
  for (/*const*/ FunctionDecl /*P*/ Prev = FD.getPreviousDecl$Const();
       (Prev != null); Prev = Prev.getPreviousDecl$Const()) {
    // Ignore any declarations that occur in function or method
    // scope, because they aren't visible from the header.
    if (Prev.getLexicalDeclContext$Const().isFunctionOrMethod()) {
      continue;
    }
    
    MissingPrototype = !Prev.getType().$arrow().isFunctionProtoType();
    if (FD.getNumParams() == 0) {
      PossibleZeroParamPrototype.$set(Prev);
    }
    break;
  }
  
  return MissingPrototype;
}

//<editor-fold defaultstate="collapsed" desc="RebuildLambdaScopeInfo">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 11187,
 FQN="RebuildLambdaScopeInfo", NM="_ZL22RebuildLambdaScopeInfoPN5clang13CXXMethodDeclERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL22RebuildLambdaScopeInfoPN5clang13CXXMethodDeclERNS_4SemaE")
//</editor-fold>
public static void RebuildLambdaScopeInfo(CXXMethodDecl /*P*/ CallOperator, 
                      final Sema /*&*/ S) {
  CXXRecordDecl /*P*/ /*const*/ LambdaClass = CallOperator.getParent();
  
  LambdaScopeInfo /*P*/ LSI = S.PushLambdaScope();
  LSI.CallOperator = CallOperator;
  LSI.Lambda = LambdaClass;
  LSI.ReturnType.$assignMove(CallOperator.getReturnType());
  /*const*/ LambdaCaptureDefault LCD = LambdaClass.getLambdaCaptureDefault();
  if (LCD == LambdaCaptureDefault.LCD_None) {
    LSI.ImpCaptureStyle = CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_None;
  } else if (LCD == LambdaCaptureDefault.LCD_ByCopy) {
    LSI.ImpCaptureStyle = CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByval;
  } else if (LCD == LambdaCaptureDefault.LCD_ByRef) {
    LSI.ImpCaptureStyle = CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByref;
  }
  DeclarationNameInfo DNI = CallOperator.getNameInfo();
  
  LSI.IntroducerRange.$assignMove(DNI.getCXXOperatorNameRange());
  LSI.Mutable = !CallOperator.isConst();
  
  // Add the captures to the LSI so they can be noted as already
  // captured within tryCaptureVar.
  specific_decl_iterator<FieldDecl> I = LambdaClass.field_begin();
  for (final /*const*/ LambdaCapture /*&*/ C : LambdaClass.captures()) {
    if (C.capturesVariable()) {
      VarDecl /*P*/ VD = C.getCapturedVar();
      if (VD.isInitCapture()) {
        S.CurrentInstantiationScope.InstantiatedLocal(VD, VD);
      }
      QualType CaptureType = VD.getType();
      /*const*/boolean ByRef = C.getCaptureKind() == LambdaCaptureKind.LCK_ByRef;
      LSI.addCapture(VD, /*IsBlock*/ false, ByRef, 
          /*RefersToEnclosingVariableOrCapture*/ true, C.getLocation(), 
          /*EllipsisLoc*/ C.isPackExpansion() ? C.getEllipsisLoc() : new SourceLocation(), 
          new QualType(CaptureType), /*Expr*/ (Expr /*P*/ )null);
    } else if (C.capturesThis()) {
      LSI.addThisCapture(/*Nested*/ false, C.getLocation(), 
          /*Expr*/ (Expr /*P*/ )null, 
          C.getCaptureKind() == LambdaCaptureKind.LCK_StarThis);
    } else {
      LSI.addVLATypeCapture(C.getLocation(), I.$arrow().getType());
    }
    I.$preInc();
  }
}


/// \brief Get diagnostic %select index for tag kind for
/// redeclaration diagnostic message.
/// WARNING: Indexes apply to particular diagnostics only!
///
/// \returns diagnostic %select index.
//<editor-fold defaultstate="collapsed" desc="getRedeclDiagFromTagKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12053,
 FQN="getRedeclDiagFromTagKind", NM="_ZL24getRedeclDiagFromTagKindN5clang11TagTypeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL24getRedeclDiagFromTagKindN5clang11TagTypeKindE")
//</editor-fold>
public static /*uint*/int getRedeclDiagFromTagKind(TagTypeKind Tag) {
  switch (Tag) {
   case TTK_Struct:
    return 0;
   case TTK_Interface:
    return 1;
   case TTK_Class:
    return 2;
   default:
    throw new llvm_unreachable("Invalid tag kind for redecl diagnostic!");
  }
}


/// \brief Determine if tag kind is a class-key compatible with
/// class for redeclaration (class, struct, or __interface).
///
/// \returns true iff the tag kind is compatible.
//<editor-fold defaultstate="collapsed" desc="isClassCompatTagKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12066,
 FQN="isClassCompatTagKind", NM="_ZL20isClassCompatTagKindN5clang11TagTypeKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL20isClassCompatTagKindN5clang11TagTypeKindE")
//</editor-fold>
public static boolean isClassCompatTagKind(TagTypeKind Tag) {
  return Tag == TagTypeKind.TTK_Struct || Tag == TagTypeKind.TTK_Class || Tag == TagTypeKind.TTK_Interface;
}


/// Add a minimal nested name specifier fixit hint to allow lookup of a tag name
/// from an outer enclosing namespace or file scope inside a friend declaration.
/// This should provide the commented out code in the following snippet:
///   namespace N {
///     struct X;
///     namespace M {
///       struct Y { friend struct /*N::*/ X; };
///     }
///   }
//<editor-fold defaultstate="collapsed" desc="createFriendTagNNSFixIt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12174,
 FQN="createFriendTagNNSFixIt", NM="_ZL23createFriendTagNNSFixItRN5clang4SemaEPNS_9NamedDeclEPNS_5ScopeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL23createFriendTagNNSFixItRN5clang4SemaEPNS_9NamedDeclEPNS_5ScopeENS_14SourceLocationE")
//</editor-fold>
public static FixItHint createFriendTagNNSFixIt(final Sema /*&*/ SemaRef, NamedDecl /*P*/ ND, Scope /*P*/ S, 
                       SourceLocation NameLoc) {
  raw_svector_ostream OS = null;
  try {
    // While the decl is in a namespace, do repeated lookup of that name and see
    // if we get the same namespace back.  If we do not, continue until
    // translation unit scope, at which point we have a fully qualified NNS.
    SmallVector<IdentifierInfo /*P*/> Namespaces/*J*/= new SmallVector<IdentifierInfo /*P*/>(4, (IdentifierInfo /*P*/)null);
    DeclContext /*P*/ DC = ND.getDeclContext().getRedeclContext();
    for (; !DC.isTranslationUnit(); DC = DC.getParent()) {
      // This tag should be declared in a namespace, which can only be enclosed by
      // other namespaces.  Bail if there's an anonymous namespace in the chain.
      NamespaceDecl /*P*/ Namespace = dyn_cast_NamespaceDecl(DC);
      if (!(Namespace != null) || Namespace.isAnonymousNamespace()) {
        return new FixItHint();
      }
      IdentifierInfo /*P*/ II = Namespace.getIdentifier();
      Namespaces.push_back(II);
      NamedDecl /*P*/ Lookup = SemaRef.LookupSingleName(S, new DeclarationName(II), new SourceLocation(NameLoc), Sema.LookupNameKind.LookupNestedNameSpecifierName);
      if (Lookup == Namespace) {
        break;
      }
    }
    
    // Once we have all the namespaces, reverse them to go outermost first, and
    // build an NNS.
    SmallString/*64*/ Insertion/*J*/= new SmallString/*64*/(64);
    OS/*J*/= new raw_svector_ostream(Insertion);
    if (DC.isTranslationUnit()) {
      OS.$out(/*KEEP_STR*/$COLON_COLON);
    }
    std.reverse(Namespaces.begin(), Namespaces.end());
    for (IdentifierInfo /*P*/ II : Namespaces)  {
      OS.$out(II.getName()).$out(/*KEEP_STR*/$COLON_COLON);
    }
    return FixItHint.CreateInsertion(/*NO_COPY*/NameLoc, Insertion.$StringRef());
  } finally {
    if (OS != null) { OS.$destroy(); }
  }
}


/// \brief Determine whether a tag originally declared in context \p OldDC can
/// be redeclared with an unqualfied name in \p NewDC (assuming name lookup
/// found a declaration in \p OldDC as a previous decl, perhaps through a
/// using-declaration).
//<editor-fold defaultstate="collapsed" desc="isAcceptableTagRedeclContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12211,
 FQN="isAcceptableTagRedeclContext", NM="_ZL28isAcceptableTagRedeclContextRN5clang4SemaEPNS_11DeclContextES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL28isAcceptableTagRedeclContextRN5clang4SemaEPNS_11DeclContextES3_")
//</editor-fold>
public static boolean isAcceptableTagRedeclContext(final Sema /*&*/ S, DeclContext /*P*/ OldDC, 
                            DeclContext /*P*/ NewDC) {
  OldDC = OldDC.getRedeclContext();
  NewDC = NewDC.getRedeclContext();
  if (OldDC.Equals(NewDC)) {
    return true;
  }
  
  // In MSVC mode, we allow a redeclaration if the contexts are related (either
  // encloses the other).
  if (S.getLangOpts().MSVCCompat
     && (OldDC.Encloses(NewDC) || NewDC.Encloses(OldDC))) {
    return true;
  }
  
  return false;
}


/// Find the DeclContext in which a tag is implicitly declared if we see an
/// elaborated type specifier in the specified context, and lookup finds
/// nothing.
//<editor-fold defaultstate="collapsed" desc="getTagInjectionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12231,
 FQN="getTagInjectionContext", NM="_ZL22getTagInjectionContextPN5clang11DeclContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL22getTagInjectionContextPN5clang11DeclContextE")
//</editor-fold>
public static DeclContext /*P*/ getTagInjectionContext(DeclContext /*P*/ DC) {
  while (!DC.isFileContext() && !DC.isFunctionOrMethod()) {
    DC = DC.getParent();
  }
  return DC;
}


/// Find the Scope in which a tag is implicitly declared if we see an
/// elaborated type specifier in the specified context, and lookup finds
/// nothing.
//<editor-fold defaultstate="collapsed" desc="getTagInjectionScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 12240,
 FQN="getTagInjectionScope", NM="_ZL20getTagInjectionScopePN5clang5ScopeERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL20getTagInjectionScopePN5clang5ScopeERKNS_11LangOptionsE")
//</editor-fold>
public static Scope /*P*/ getTagInjectionScope(Scope /*P*/ S, final /*const*/ LangOptions /*&*/ LangOpts) {
  while (S.isClassScope()
     || (LangOpts.CPlusPlus
     && S.isFunctionPrototypeScope())
     || ((S.getFlags() & Scope.ScopeFlags.DeclScope) == 0)
     || ((S.getEntity() != null) && S.getEntity().isTransparentContext())) {
    S = S.getParent();
  }
  return S;
}


/// TranslateIvarVisibility - Translate visibility from a token ID to an
///  AST enum value.
//<editor-fold defaultstate="collapsed" desc="TranslateIvarVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 13693,
 FQN="TranslateIvarVisibility", NM="_ZL23TranslateIvarVisibilityN5clang3tok15ObjCKeywordKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL23TranslateIvarVisibilityN5clang3tok15ObjCKeywordKindE")
//</editor-fold>
public static ObjCIvarDecl.AccessControl TranslateIvarVisibility(/*tok.ObjCKeywordKind*/char ivarVisibility) {
  switch (ivarVisibility) {
   default:
    throw new llvm_unreachable("Unknown visitibility kind");
   case tok.ObjCKeywordKind.objc_private:
    return ObjCIvarDecl.AccessControl.Private;
   case tok.ObjCKeywordKind.objc_public:
    return ObjCIvarDecl.AccessControl.Public;
   case tok.ObjCKeywordKind.objc_protected:
    return ObjCIvarDecl.AccessControl.Protected;
   case tok.ObjCKeywordKind.objc_package:
    return ObjCIvarDecl.AccessControl.Package;
  }
}


/// \brief Determine whether the given integral value is representable within
/// the given type T.
//<editor-fold defaultstate="collapsed" desc="isRepresentableIntegerValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14269,
 FQN="isRepresentableIntegerValue", NM="_ZL27isRepresentableIntegerValueRN5clang10ASTContextERN4llvm6APSIntENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL27isRepresentableIntegerValueRN5clang10ASTContextERN4llvm6APSIntENS_8QualTypeE")
//</editor-fold>
public static boolean isRepresentableIntegerValue(final ASTContext /*&*/ Context, 
                           final APSInt /*&*/ Value, 
                           QualType T) {
  assert (T.$arrow().isIntegralType(Context)) : "Integral type required!";
  /*uint*/int BitWidth = Context.getIntWidth(new QualType(T));
  if (Value.isUnsigned() || Value.isNonNegative()) {
    if (T.$arrow().isSignedIntegerOrEnumerationType()) {
      --BitWidth;
    }
    return $lesseq_uint(Value.getActiveBits(), BitWidth);
  }
  return $lesseq_uint(Value.getMinSignedBits(), BitWidth);
}


// \brief Given an integral type, return the next larger integral type
// (or a NULL type of no such type exists).
//<editor-fold defaultstate="collapsed" desc="getNextLargerIntegralType">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14285,
 FQN="getNextLargerIntegralType", NM="_ZL25getNextLargerIntegralTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL25getNextLargerIntegralTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static QualType getNextLargerIntegralType(final ASTContext /*&*/ Context, QualType T) {
  // FIXME: Int128/UInt128 support, which also needs to be introduced into
  // enum checking below.
  assert (T.$arrow().isIntegralType(Context)) : "Integral type required!";
  /*const*//*uint*/int NumTypes = 4;
  QualType SignedIntegralTypes[/*4*/] = new QualType [/*4*/] {
    Context.ShortTy.$QualType(), Context.IntTy.$QualType(), Context.LongTy.$QualType(), Context.LongLongTy.$QualType()
  };
  QualType UnsignedIntegralTypes[/*4*/] = new QualType [/*4*/] {
    Context.UnsignedShortTy.$QualType(), Context.UnsignedIntTy.$QualType(), Context.UnsignedLongTy.$QualType(), 
    Context.UnsignedLongLongTy.$QualType()
  };
  
  /*uint*/int BitWidth = $ulong2uint(Context.getTypeSize(new QualType(T)));
  QualType[] /*P*/ Types = T.$arrow().isSignedIntegerOrEnumerationType() ? SignedIntegralTypes : UnsignedIntegralTypes;
  for (/*uint*/int I = 0; I != NumTypes; ++I)  {
    if ($greater_ulong_uint(Context.getTypeSize(new QualType(Types[I])), BitWidth)) {
      return new QualType(Types[I]);
    }
  }
  
  return new QualType();
}


// Returns true when the enum initial expression does not trigger the
// duplicate enum warning.  A few common cases are exempted as follows:
// Element2 = Element1
// Element2 = Element1 + 1
// Element2 = Element1 - 1
// Where Element2 and Element1 are from the same enum.
//<editor-fold defaultstate="collapsed" desc="ValidDuplicateEnum">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14579,
 FQN="ValidDuplicateEnum", NM="_ZL18ValidDuplicateEnumPN5clang16EnumConstantDeclEPNS_8EnumDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL18ValidDuplicateEnumPN5clang16EnumConstantDeclEPNS_8EnumDeclE")
//</editor-fold>
public static boolean ValidDuplicateEnum(EnumConstantDecl /*P*/ ECD, EnumDecl /*P*/ Enum) {
  Expr /*P*/ InitExpr = ECD.getInitExpr();
  if (!(InitExpr != null)) {
    return true;
  }
  InitExpr = InitExpr.IgnoreImpCasts();
  {
    
    BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(InitExpr);
    if ((BO != null)) {
      if (!BO.isAdditiveOp()) {
        return true;
      }
      IntegerLiteral /*P*/ IL = dyn_cast_IntegerLiteral(BO.getRHS());
      if (!(IL != null)) {
        return true;
      }
      if (IL.getValue().$noteq(1)) {
        return true;
      }
      
      InitExpr = BO.getLHS();
    }
  }
  
  // This checks if the elements are from the same enum.
  DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(InitExpr);
  if (!(DRE != null)) {
    return true;
  }
  
  EnumConstantDecl /*P*/ EnumConstant = dyn_cast_EnumConstantDecl(DRE.getDecl());
  if (!(EnumConstant != null)) {
    return true;
  }
  if (cast_EnumDecl(TagDecl.castFromDeclContext(ECD.getDeclContext()))
     != Enum) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::GetDupKey">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14621,
 FQN="(anonymous namespace)::GetDupKey", NM="_ZN12_GLOBAL__N_1L9GetDupKeyERKN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZN12_GLOBAL__N_1L9GetDupKeyERKN4llvm6APSIntE")
//</editor-fold>
public static DupKey GetDupKey(final /*const*/ APSInt /*&*/ Val) {
  return new DupKey(Val.isSigned() ? Val.getSExtValue() : Val.getZExtValue(), 
      false);
}

// end anonymous namespace

// Emits a warning when an element is implicitly set a value that
// a previous element has already been set to.
//<editor-fold defaultstate="collapsed" desc="CheckForDuplicateEnumValues">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 14641,
 FQN="CheckForDuplicateEnumValues", NM="_ZL27CheckForDuplicateEnumValuesRN5clang4SemaEN4llvm8ArrayRefIPNS_4DeclEEEPNS_8EnumDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL27CheckForDuplicateEnumValuesRN5clang4SemaEN4llvm8ArrayRefIPNS_4DeclEEEPNS_8EnumDeclENS_8QualTypeE")
//</editor-fold>
public static void CheckForDuplicateEnumValues(final Sema /*&*/ S, ArrayRef<Decl /*P*/ > Elements, 
                           EnumDecl /*P*/ Enum, 
                           QualType EnumType) {
  if (S.Diags.isIgnored(diag.warn_duplicate_enum_values, Enum.getLocation())) {
    return;
  }
  // Avoid anonymous enums
  if (!(Enum.getIdentifier() != null)) {
    return;
  }
  
  // Only check for small enums.
  if ($greater_uint(Enum.getNumPositiveBits(), 63) || $greater_uint(Enum.getNumNegativeBits(), 64)) {
    return;
  }
  
  /*typedef SmallVector<EnumConstantDecl *, 3> ECDVector*/
//  final class ECDVector extends SmallVector<EnumConstantDecl /*P*/ >{ };
  /*typedef SmallVector<ECDVector *, 3> DuplicatesVector*/
//  final class DuplicatesVector extends SmallVector<SmallVector<EnumConstantDecl /*P*/ > /*P*/>{ };
  
  /*typedef llvm::PointerUnion<EnumConstantDecl *, ECDVector *> DeclOrVector*/
//  final class DeclOrVector extends PointerUnion<EnumConstantDecl /*P*/ , SmallVector<EnumConstantDecl /*P*/ > /*P*/>{ };
  /*typedef llvm::DenseMap<DupKey, DeclOrVector, DenseMapInfoDupKey> ValueToVectorMap*/
//  final class ValueToVectorMap extends DenseMap<DupKey, PointerUnion<EnumConstantDecl /*P*/ , SmallVector<EnumConstantDecl /*P*/ > /*P*/>>{ };
  
  SmallVector<SmallVector<EnumConstantDecl /*P*/ > /*P*/> DupVector/*J*/= new SmallVector<SmallVector<EnumConstantDecl /*P*/ > /*P*/>(3, (SmallVector<EnumConstantDecl /*P*/ > /*P*/)null);
  DenseMap<DupKey, PointerUnion<EnumConstantDecl /*P*/ , SmallVector<EnumConstantDecl /*P*/ > /*P*/>> EnumMap/*J*/= new DenseMap<DupKey, PointerUnion<EnumConstantDecl /*P*/ , SmallVector<EnumConstantDecl /*P*/ > /*P*/>>(DenseMapInfoDupKey.$Info(), new PointerUnion(EnumConstantDecl /*P*/.class));
  
  // Populate the EnumMap with all values represented by enum constants without
  // an initialier.
  for (/*uint*/int i = 0, e = Elements.size(); i != e; ++i) {
    EnumConstantDecl /*P*/ ECD = cast_or_null_EnumConstantDecl(Elements.$at(i));
    
    // Null EnumConstantDecl means a previous diagnostic has been emitted for
    // this constant.  Skip this enum since it may be ill-formed.
    if (!(ECD != null)) {
      return;
    }
    if ((ECD.getInitExpr() != null)) {
      continue;
    }
    
    DupKey Key = GetDupKey(ECD.getInitVal());
    final PointerUnion<EnumConstantDecl /*P*/ , SmallVector<EnumConstantDecl /*P*/ > /*P*/> /*&*/ Entry = EnumMap.$at_T1$C$R(Key);
    
    // First time encountering this value.
    if (Entry.isNull()) {
      Entry.$assign_T$C$R(EnumConstantDecl /*P*/.class, ECD);
    }
  }
  
  // Create vectors for any values that has duplicates.
  for (/*uint*/int i = 0, e = Elements.size(); i != e; ++i) {
    EnumConstantDecl /*P*/ ECD = cast_EnumConstantDecl(Elements.$at(i));
    if (!ValidDuplicateEnum(ECD, Enum)) {
      continue;
    }
    
    DupKey Key = GetDupKey(ECD.getInitVal());
    
    final PointerUnion<EnumConstantDecl /*P*/ , SmallVector<EnumConstantDecl /*P*/ > /*P*/> /*&*/ Entry = EnumMap.$at_T1$C$R(Key);
    if (Entry.isNull()) {
      continue;
    }
    {
      
      EnumConstantDecl /*P*/ D = Entry.dyn_cast(EnumConstantDecl /*P*/.class);
      if ((D != null)) {
        // Ensure constants are different.
        if (D == ECD) {
          continue;
        }
        
        // Create new vector and push values onto it.
        SmallVector<EnumConstantDecl /*P*/ > /*P*/ Vec = new SmallVector<EnumConstantDecl /*P*/ >(3, (EnumConstantDecl /*P*/ )null);
        Vec.push_back(D);
        Vec.push_back(ECD);
        
        // Update entry to point to the duplicates vector.
        ((PointerUnion)Entry).$assign_T1$C$R(SmallVector/*P*/.class, Vec);
        
        // Store the vector somewhere we can consult later for quick emission of
        // diagnostics.
        DupVector.push_back(Vec);
        continue;
      }
    }
    
    SmallVector<EnumConstantDecl /*P*/ > /*P*/ Vec = Entry.get(SmallVector /*P*/.class);
    // Make sure constants are not added more than once.
    if (Vec.begin().$star() == ECD) {
      continue;
    }
    
    Vec.push_back(ECD);
  }
  
  // Emit diagnostics.
  for (type$ptr<SmallVector<EnumConstantDecl /*P*/> /*P*/ /*P*/ >  DupVectorIter = $tryClone(DupVector.begin()), 
      /*P*/ DupVectorEnd = $tryClone(DupVector.end());
       $noteq_ptr(DupVectorIter, DupVectorEnd); DupVectorIter.$preInc()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SmallVector<EnumConstantDecl /*P*/ > /*P*/ Vec = DupVectorIter.$star();
      assert ($greater_uint(Vec.size(), 1)) : "ECDVector should have at least 2 elements.";
      
      // Emit warning for one enum constant.
      type$ptr<EnumConstantDecl /*P*/ /*P*/ > I = $tryClone(Vec.begin());
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag((I.$star()).getLocation(), diag.warn_duplicate_enum_values)), 
                  (I.$star()).getName()), (I.$star()).getInitVal().__toString(10)), 
          (I.$star()).getSourceRange()));
      I.$preInc();
      
      // Emit one note for each of the remaining enum constants with
      // the same value.
      for ( type$ptr<EnumConstantDecl /*P*/ /*P*/ > E = $tryClone(Vec.end()); $noteq_ptr(I, E); I.$preInc())  {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag((I.$star()).getLocation(), diag.note_duplicate_element)), 
                    (I.$star()).getName()), (I.$star()).getInitVal().__toString(10)), 
            (I.$star()).getSourceRange()));
      }
      if (Vec != null) { Vec.$destroy();};
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="checkModuleImportContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp", line = 15026,
 FQN="checkModuleImportContext", NM="_ZL24checkModuleImportContextRN5clang4SemaEPNS_6ModuleENS_14SourceLocationEPNS_11DeclContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaDecl.cpp -nm=_ZL24checkModuleImportContextRN5clang4SemaEPNS_6ModuleENS_14SourceLocationEPNS_11DeclContextEb")
//</editor-fold>
public static void checkModuleImportContext(final Sema /*&*/ S, Module /*P*/ M, 
                        SourceLocation ImportLoc, DeclContext /*P*/ DC) {
  checkModuleImportContext(S, M, 
                        ImportLoc, DC, 
                        false);
}
public static void checkModuleImportContext(final Sema /*&*/ S, Module /*P*/ M, 
                        SourceLocation ImportLoc, DeclContext /*P*/ DC, 
                        boolean FromInclude/*= false*/) {
  SourceLocation ExternCLoc/*J*/= new SourceLocation();
  {
    
    LinkageSpecDecl /*P*/ LSD = dyn_cast_LinkageSpecDecl(DC);
    if ((LSD != null)) {
      switch (LSD.getLanguage()) {
       case LinkageSpecDecl.LanguageIDs.lang_c:
        if (ExternCLoc.isInvalid()) {
          ExternCLoc.$assignMove(LSD.getLocStart());
        }
        break;
       case LinkageSpecDecl.LanguageIDs.lang_cxx:
        break;
      }
      DC = LSD.getParent();
    }
  }
  while (isa_LinkageSpecDecl(DC)) {
    DC = DC.getParent();
  }
  if (!isa_TranslationUnitDecl(DC)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ImportLoc), (FromInclude && S.isModuleVisible(M)) ? diag.ext_module_import_not_at_top_level_noop : diag.err_module_import_not_at_top_level_fatal)), 
              M.getFullModuleName()), DC));
      $c$.clean($out_SemaDiagnosticBuilder_DeclContext($c$.track(S.Diag(cast_Decl(DC).getLocStart(), 
              diag.note_module_import_not_at_top_level)), DC));
    } finally {
      $c$.$destroy();
    }
  } else if (!M.IsExternC && ExternCLoc.isValid()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(ImportLoc), diag.ext_module_import_in_extern_c)), 
          M.getFullModuleName()));
      $c$.clean($c$.track(S.Diag(new SourceLocation(ExternCLoc), diag.note_module_import_in_extern_c)));
    } finally {
      $c$.$destroy();
    }
  }
}

} // END OF class SemaDeclStatics
