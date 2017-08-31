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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.ast.aliases.*;
import static org.clang.ast.Qualifiers.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.specific_attr_iterator.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaOverload">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaOpenMP ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema10IsOverloadEPNS_12FunctionDeclES2_bb;_ZN5clang4Sema13CheckEnableIfEPNS_12FunctionDeclEN4llvm8ArrayRefIPNS_4ExprEEEb;_ZN5clang4Sema13CheckOverloadEPNS_5ScopeEPNS_12FunctionDeclERKNS_12LookupResultERPNS_9NamedDeclEb;_ZN5clang4Sema16SelectBestMethodENS_8SelectorEN4llvm15MutableArrayRefIPNS_4ExprEEEbRNS2_15SmallVectorImplIPNS_14ObjCMethodDeclEEE;_ZN5clang4Sema18AddMethodCandidateENS_14DeclAccessPairENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS3_EERNS_20OverloadCandidateSetEb;_ZN5clang4Sema18AddMethodCandidateEPNS_13CXXMethodDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS7_EERNS_20OverloadCandidateSetEbb;_ZN5clang4Sema18IsComplexPromotionENS_8QualTypeES1_;_ZN5clang4Sema19AddBuiltinCandidateENS_8QualTypeEPS1_N4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbj;_ZN5clang4Sema19IsIntegralPromotionEPNS_4ExprENS_8QualTypeES3_;_ZN5clang4Sema19IsPointerConversionEPNS_4ExprENS_8QualTypeES3_bRS3_Rb;_ZN5clang4Sema20AddOverloadCandidateEPNS_12FunctionDeclENS_14DeclAccessPairEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbbb;_ZN5clang4Sema20IsNoReturnConversionENS_8QualTypeES1_RS1_;_ZN5clang4Sema21AddFunctionCandidatesERKNS_17UnresolvedSetImplEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEPNS_24TemplateArgumentListInfoEbb;_ZN5clang4Sema21AddSurrogateCandidateEPNS_17CXXConversionDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPNS_4ExprEN4llvm8ArrayRefISA_EERNS_20OverloadCandidateSetE;_ZN5clang4Sema21CreateOverloadedBinOpENS_14SourceLocationENS_18BinaryOperatorKindERKNS_17UnresolvedSetImplEPNS_4ExprES7_;_ZN5clang4Sema21NoteOverloadCandidateEPNS_9NamedDeclEPNS_12FunctionDeclENS_8QualTypeEb;_ZN5clang4Sema21TryImplicitConversionEPNS_4ExprENS_8QualTypeEbbbbb;_ZN5clang4Sema22AddConversionCandidateEPNS_17CXXConversionDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_4ExprENS_8QualTypeERNS_20OverloadCandidateSetEb;_ZN5clang4Sema22CheckPointerConversionEPNS_4ExprENS_8QualTypeERNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEbb;_ZN5clang4Sema22buildOverloadedCallSetEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprEN4llvm15MutableArrayRefIS4_EENS_14SourceLocationEPNS_20OverloadCandidateSetEPNS_12ActionResultIS4_Lb1EEE;_ZN5clang4Sema23BuildOverloadedCallExprEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES7_S4_bb;_ZN5clang4Sema23CreateOverloadedUnaryOpENS_14SourceLocationENS_17UnaryOperatorKindERKNS_17UnresolvedSetImplEPNS_4ExprE;_ZN5clang4Sema23isObjCPointerConversionENS_8QualTypeES1_RS1_Rb;_ZN5clang4Sema24BuildLiteralOperatorCallERNS_12LookupResultERNS_19DeclarationNameInfoEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationEPNS_24TemplateArgumentListInfoE;_ZN5clang4Sema24BuildOverloadedArrowExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEPb;_ZN5clang4Sema24IsBlockPointerConversionENS_8QualTypeES1_RS1_;_ZN5clang4Sema24IsFloatingPointPromotionENS_8QualTypeES1_;_ZN5clang4Sema25BuildCallToMemberFunctionEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_;_ZN5clang4Sema25BuildForRangeBeginEndCallENS_14SourceLocationES1_RKNS_19DeclarationNameInfoERNS_12LookupResultEPNS_20OverloadCandidateSetEPNS_4ExprEPNS_12ActionResultISA_Lb1EEE;_ZN5clang4Sema25IsMemberPointerConversionEPNS_4ExprENS_8QualTypeES3_bRS3_;_ZN5clang4Sema25IsQualificationConversionENS_8QualTypeES1_bRb;_ZN5clang4Sema25NoteAllOverloadCandidatesEPNS_4ExprENS_8QualTypeEb;_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeENS0_16AssignmentActionEb;_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeENS0_16AssignmentActionEbRNS_26ImplicitConversionSequenceE;_ZN5clang4Sema25isObjCWritebackConversionENS_8QualTypeES1_RS1_;_ZN5clang4Sema26AddMethodTemplateCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_24TemplateArgumentListInfoENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS9_EERNS_20OverloadCandidateSetEbb;_ZN5clang4Sema26FunctionParamTypesAreEqualEPKNS_17FunctionProtoTypeES3_Pj;_ZN5clang4Sema26HandleFunctionTypeMismatchERNS_17PartialDiagnosticENS_8QualTypeES3_;_ZN5clang4Sema27AddMemberOperatorCandidatesENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetENS_11SourceRangeE;_ZN5clang4Sema27AddOverloadedCallCandidatesEPNS_20UnresolvedLookupExprEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEb;_ZN5clang4Sema28AddBuiltinOperatorCandidatesENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetE;_ZN5clang4Sema28AddTemplateOverloadCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbb;_ZN5clang4Sema28BuildCallToObjectOfClassTypeEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_;_ZN5clang4Sema28CheckMemberPointerConversionEPNS_4ExprENS_8QualTypeERNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb;_ZN5clang4Sema28CompareReferenceRelationshipENS_14SourceLocationENS_8QualTypeES2_RbS3_S3_;_ZN5clang4Sema30AddTemplateConversionCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_4ExprENS_8QualTypeERNS_20OverloadCandidateSetEb;_ZN5clang4Sema30ExtractUnqualifiedFunctionTypeENS_8QualTypeE;_ZN5clang4Sema30FixOverloadedFunctionReferenceENS_12ActionResultIPNS_4ExprELb1EEENS_14DeclAccessPairEPNS_12FunctionDeclE;_ZN5clang4Sema30FixOverloadedFunctionReferenceEPNS_4ExprENS_14DeclAccessPairEPNS_12FunctionDeclE;_ZN5clang4Sema31isFunctionConsideredUnavailableEPNS_12FunctionDeclE;_ZN5clang4Sema32CheckConvertedConstantExpressionEPNS_4ExprENS_8QualTypeERN4llvm6APSIntENS0_7CCEKindE;_ZN5clang4Sema32CheckConvertedConstantExpressionEPNS_4ExprENS_8QualTypeERNS_7APValueENS0_7CCEKindE;_ZN5clang4Sema32PerformContextuallyConvertToBoolEPNS_4ExprE;_ZN5clang4Sema33checkAddressOfFunctionIsAvailableEPKNS_12FunctionDeclEbNS_14SourceLocationE;_ZN5clang4Sema34CreateOverloadedArraySubscriptExprENS_14SourceLocationES1_PNS_4ExprES3_;_ZN5clang4Sema34ResolveAddressOfOverloadedFunctionEPNS_4ExprENS_8QualTypeEbRNS_14DeclAccessPairEPb;_ZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterE;_ZN5clang4Sema35PerformObjectArgumentInitializationEPNS_4ExprEPNS_19NestedNameSpecifierEPNS_9NamedDeclEPNS_13CXXMethodDeclE;_ZN5clang4Sema36AddArgumentDependentLookupCandidatesENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEEPNS_24TemplateArgumentListInfoERNS_20OverloadCandidateSetEb;_ZN5clang4Sema37DiagnoseMultipleUserDefinedConversionEPNS_4ExprENS_8QualTypeE;_ZN5clang4Sema38isEquivalentInternalLinkageDeclarationEPKNS_9NamedDeclES3_;_ZN5clang4Sema39PerformContextuallyConvertToObjCPointerEPNS_4ExprE;_ZN5clang4Sema43ResolveSingleFunctionTemplateSpecializationEPNS_12OverloadExprEbPNS_14DeclAccessPairE;_ZN5clang4Sema43resolveAddressOfOnlyViableOverloadCandidateEPNS_4ExprERNS_14DeclAccessPairE;_ZN5clang4Sema45diagnoseEquivalentInternalLinkageDeclarationsENS_14SourceLocationEPKNS_9NamedDeclEN4llvm8ArrayRefIS4_EE;_ZN5clang4Sema49ResolveAndFixSingleFunctionTemplateSpecializationERNS_12ActionResultIPNS_4ExprELb1EEEbbNS_11SourceRangeENS_8QualTypeEj;_ZN5clang4Sema49resolveAndFixAddressOfOnlyViableOverloadCandidateERNS_12ActionResultIPNS_4ExprELb1EEE; -static-type=Sema_SemaOverload -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaOverload extends Sema_SemaOpenMP {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }


/// Determine if \p A and \p B are equivalent internal linkage declarations
/// from different modules, and thus an ambiguity error can be downgraded to
/// an extension warning.

/// Determine whether two declarations are "equivalent" for the purposes of
/// name lookup and overload resolution. This applies when the same internal/no
/// linkage entity is defined by two modules (probably by textually including
/// the same header). In such a case, we don't consider the declarations to
/// declare the same entity, but we also don't want lookups with both
/// declarations visible to be ambiguous in some cases (this happens when using
/// a modularized libstdc++).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isEquivalentInternalLinkageDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8699,
 FQN="clang::Sema::isEquivalentInternalLinkageDeclaration", NM="_ZN5clang4Sema38isEquivalentInternalLinkageDeclarationEPKNS_9NamedDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema38isEquivalentInternalLinkageDeclarationEPKNS_9NamedDeclES3_")
//</editor-fold>
public final boolean isEquivalentInternalLinkageDeclaration(/*const*/ NamedDecl /*P*/ A, 
                                      /*const*/ NamedDecl /*P*/ B) {
  /*const*/ ValueDecl /*P*/ VA = dyn_cast_or_null_ValueDecl(A);
  /*const*/ ValueDecl /*P*/ VB = dyn_cast_or_null_ValueDecl(B);
  if (!(VA != null) || !(VB != null)) {
    return false;
  }
  
  // The declarations must be declaring the same name as an internal linkage
  // entity in different modules.
  if (!VA.getDeclContext$Const().getRedeclContext$Const().Equals(VB.getDeclContext$Const().getRedeclContext$Const())
     || $this().getOwningModule(((/*const_cast*/ValueDecl /*P*/ )(VA)))
     == $this().getOwningModule(((/*const_cast*/ValueDecl /*P*/ )(VB)))
     || VA.isExternallyVisible() || VB.isExternallyVisible()) {
    return false;
  }
  
  // Check that the declarations appear to be equivalent.
  //
  // FIXME: Checking the type isn't really enough to resolve the ambiguity.
  // For constants and functions, we should check the initializer or body is
  // the same. For non-constant variables, we shouldn't allow it at all.
  if ($this().Context.hasSameType(VA.getType(), VB.getType())) {
    return true;
  }
  {
    
    // Enum constants within unnamed enumerations will have different types, but
    // may still be similar enough to be interchangeable for our purposes.
    /*const*/ EnumConstantDecl /*P*/ EA = dyn_cast_EnumConstantDecl(VA);
    if ((EA != null)) {
      {
        /*const*/ EnumConstantDecl /*P*/ EB = dyn_cast_EnumConstantDecl(VB);
        if ((EB != null)) {
          // Only handle anonymous enums. If the enumerations were named and
          // equivalent, they would have been merged to the same type.
          /*const*/ EnumDecl /*P*/ EnumA = cast_EnumDecl(EA.getDeclContext$Const());
          /*const*/ EnumDecl /*P*/ EnumB = cast_EnumDecl(EB.getDeclContext$Const());
          if (EnumA.hasNameForLinkage() || EnumB.hasNameForLinkage()
             || !$this().Context.hasSameType(EnumA.getIntegerType(), 
              EnumB.getIntegerType())) {
            return false;
          }
          // Allow this only if the value is the same for both enumerators.
          return APSInt.isSameValue(EA.getInitVal(), EB.getInitVal());
        }
      }
    }
  }
  
  // Nothing else is sufficiently similar.
  return false;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::diagnoseEquivalentInternalLinkageDeclarations">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8744,
 FQN="clang::Sema::diagnoseEquivalentInternalLinkageDeclarations", NM="_ZN5clang4Sema45diagnoseEquivalentInternalLinkageDeclarationsENS_14SourceLocationEPKNS_9NamedDeclEN4llvm8ArrayRefIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema45diagnoseEquivalentInternalLinkageDeclarationsENS_14SourceLocationEPKNS_9NamedDeclEN4llvm8ArrayRefIS4_EE")
//</editor-fold>
public final void diagnoseEquivalentInternalLinkageDeclarations(SourceLocation Loc, /*const*/ NamedDecl /*P*/ D, ArrayRef</*const*/ NamedDecl /*P*/ > Equiv) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(Loc), diag.ext_equivalent_internal_linkage_decl_in_modules)), D));
    
    Module /*P*/ M = $this().getOwningModule(((/*const_cast*/NamedDecl /*P*/ )(D)));
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(D.getLocation(), diag.note_equivalent_internal_linkage_decl)), 
            !(M != null)), ((M != null) ? M.getFullModuleName() : new std.string(/*KEEP_STR*/$EMPTY))));
    
    for (/*const*/ NamedDecl /*P*/ E : Equiv) {
      Module /*P*/ M$1 = $this().getOwningModule(((/*const_cast*/NamedDecl /*P*/ )(E)));
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(E.getLocation(), diag.note_equivalent_internal_linkage_decl)), 
              !(M$1 != null)), ((M$1 != null) ? M$1.getFullModuleName() : new std.string(/*KEEP_STR*/$EMPTY))));
    }
  } finally {
    $c$.$destroy();
  }
}


// IsOverload - Determine whether the given New declaration is an
// overload of the declarations in Old. This routine returns false if
// New and Old cannot be overloaded, e.g., if New has the same
// signature as some function in Old (C++ 1.3.10) or if the Old
// declarations aren't functions (or function templates) at all. When
// it does return false, MatchedDecl will point to the decl that New
// cannot be overloaded with.  This decl may be a UsingShadowDecl on
// top of the underlying declaration.
//
// Example: Given the following input:
//
//   void f(int, float); // #1
//   void f(int, int); // #2
//   int f(int, int); // #3
//
// When we process #1, there is no previous declaration of "f",
// so IsOverload will not be used.
//
// When we process #2, Old contains only the FunctionDecl for #1.  By
// comparing the parameter types, we see that #1 and #2 are overloaded
// (since they have different signatures), so this routine returns
// false; MatchedDecl is unchanged.
//
// When we process #3, Old is an overload set containing #1 and #2. We
// compare the signatures of #3 to #1 (they're overloaded, so we do
// nothing) and then #3 to #2. Since the signatures of #3 and #2 are
// identical (return types of functions are not part of the
// signature), IsOverload returns false and MatchedDecl will be set to
// point to the FunctionDecl for #2.
//
// 'NewIsUsingShadowDecl' indicates that 'New' is being introduced
// into a class by a using declaration.  The rules for whether to hide
// shadow declarations ignore some properties which otherwise figure
// into a function template's signature.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckOverload">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 926,
 FQN="clang::Sema::CheckOverload", NM="_ZN5clang4Sema13CheckOverloadEPNS_5ScopeEPNS_12FunctionDeclERKNS_12LookupResultERPNS_9NamedDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema13CheckOverloadEPNS_5ScopeEPNS_12FunctionDeclERKNS_12LookupResultERPNS_9NamedDeclEb")
//</editor-fold>
public final Sema.OverloadKind CheckOverload(Scope /*P*/ S, FunctionDecl /*P*/ New, final /*const*/ LookupResult /*&*/ Old, 
             final type$ref<NamedDecl /*P*/ /*&*/> Match, boolean NewIsUsingDecl) {
  for (UnresolvedSetIterator I = Old.begin(), E = Old.end();
       I.$noteq(E); I.$preInc()) {
    NamedDecl /*P*/ OldD = I.$star();
    
    boolean OldIsUsingDecl = false;
    if (isa_UsingShadowDecl(OldD)) {
      OldIsUsingDecl = true;
      
      // We can always introduce two using declarations into the same
      // context, even if they have identical signatures.
      if (NewIsUsingDecl) {
        continue;
      }
      
      OldD = cast_UsingShadowDecl(OldD).getTargetDecl();
    }
    
    // A using-declaration does not conflict with another declaration
    // if one of them is hidden.
    if ((OldIsUsingDecl || NewIsUsingDecl) && !$this().isVisible(I.$star())) {
      continue;
    }
    
    // If either declaration was introduced by a using declaration,
    // we'll need to use slightly different rules for matching.
    // Essentially, these rules are the normal rules, except that
    // function templates hide function templates with different
    // return types or template parameter lists.
    boolean UseMemberUsingDeclRules = (OldIsUsingDecl || NewIsUsingDecl) && $this().CurContext.isRecord()
       && !(New.getFriendObjectKind().getValue() != 0);
    {
      
      FunctionDecl /*P*/ OldF = OldD.getAsFunction();
      if ((OldF != null)) {
        if (!$this().IsOverload(New, OldF, UseMemberUsingDeclRules)) {
          if (UseMemberUsingDeclRules && OldIsUsingDecl) {
            $this().HideUsingShadowDecl(S, cast_UsingShadowDecl(I.$star()));
            continue;
          }
          if (!isa_FunctionTemplateDecl(OldD)
             && !$this().shouldLinkPossiblyHiddenDecl(I.$star(), New)) {
            continue;
          }
          
          Match.$set(I.$star());
          return OverloadKind.Ovl_Match;
        }
      } else if (isa_UsingDecl(OldD)) {
        // We can overload with these, which can show up when doing
        // redeclaration checks for UsingDecls.
        assert (Old.getLookupKind() == LookupNameKind.LookupUsingDeclName);
      } else if (isa_TagDecl(OldD)) {
        // We can always overload with tags by hiding them.
      } else if (isa_UnresolvedUsingValueDecl(OldD)) {
        // Optimistically assume that an unresolved using decl will
        // overload; if it doesn't, we'll have to diagnose during
        // template instantiation.
      } else {
        // (C++ 13p1):
        //   Only function declarations can be overloaded; object and type
        //   declarations cannot be overloaded.
        Match.$set(I.$star());
        return OverloadKind.Ovl_NonFunction;
      }
    }
  }
  
  return OverloadKind.Ovl_Overload;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsOverload">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 994,
 FQN="clang::Sema::IsOverload", NM="_ZN5clang4Sema10IsOverloadEPNS_12FunctionDeclES2_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema10IsOverloadEPNS_12FunctionDeclES2_bb")
//</editor-fold>
public final boolean IsOverload(FunctionDecl /*P*/ New, FunctionDecl /*P*/ Old, 
          boolean UseMemberUsingDeclRules) {
  return IsOverload(New, Old, 
          UseMemberUsingDeclRules, true);
}
public final boolean IsOverload(FunctionDecl /*P*/ New, FunctionDecl /*P*/ Old, 
          boolean UseMemberUsingDeclRules, boolean ConsiderCudaAttrs/*= true*/) {
  // C++ [basic.start.main]p2: This function shall not be overloaded.
  if (New.isMain()) {
    return false;
  }
  
  // MSVCRT user defined entry points cannot be overloaded.
  if (New.isMSVCRTEntryPoint()) {
    return false;
  }
  
  FunctionTemplateDecl /*P*/ OldTemplate = Old.getDescribedFunctionTemplate();
  FunctionTemplateDecl /*P*/ NewTemplate = New.getDescribedFunctionTemplate();
  
  // C++ [temp.fct]p2:
  //   A function template can be overloaded with other function templates
  //   and with normal (non-template) functions.
  if ((OldTemplate == null) != (NewTemplate == null)) {
    return true;
  }
  
  // Is the function New an overload of the function Old?
  QualType OldQType = $this().Context.getCanonicalType(Old.getType()).$QualType();
  QualType NewQType = $this().Context.getCanonicalType(New.getType()).$QualType();
  
  // Compare the signatures (C++ 1.3.10) of the two functions to
  // determine whether they are overloads. If we find any mismatch
  // in the signature, they are overloads.
  
  // If either of these functions is a K&R-style function (no
  // prototype), then we consider them to have matching signatures.
  if (isa_FunctionNoProtoType(OldQType.getTypePtr())
     || isa_FunctionNoProtoType(NewQType.getTypePtr())) {
    return false;
  }
  
  /*const*/ FunctionProtoType /*P*/ OldType = cast_FunctionProtoType(OldQType);
  /*const*/ FunctionProtoType /*P*/ NewType = cast_FunctionProtoType(NewQType);
  
  // The signature of a function includes the types of its
  // parameters (C++ 1.3.10), which includes the presence or absence
  // of the ellipsis; see C++ DR 357).
  if ($noteq_QualType$C(OldQType, NewQType)
     && (OldType.getNumParams() != NewType.getNumParams()
     || OldType.isVariadic() != NewType.isVariadic()
     || !$this().FunctionParamTypesAreEqual(OldType, NewType))) {
    return true;
  }
  
  // C++ [temp.over.link]p4:
  //   The signature of a function template consists of its function
  //   signature, its return type and its template parameter list. The names
  //   of the template parameters are significant only for establishing the
  //   relationship between the template parameters and the rest of the
  //   signature.
  //
  // We check the return type and template parameter lists for function
  // templates first; the remaining checks follow.
  //
  // However, we don't consider either of these when deciding whether
  // a member introduced by a shadow declaration is hidden.
  if (!UseMemberUsingDeclRules && (NewTemplate != null)
     && (!$this().TemplateParameterListsAreEqual(NewTemplate.getTemplateParameters(), 
      OldTemplate.getTemplateParameters(), 
      false, TemplateParameterListEqualKind.TPL_TemplateMatch)
     || $noteq_QualType$C(OldType.getReturnType(), NewType.getReturnType()))) {
    return true;
  }
  
  // If the function is a class member, its signature includes the
  // cv-qualifiers (if any) and ref-qualifier (if any) on the function itself.
  //
  // As part of this, also check whether one of the member functions
  // is static, in which case they are not overloads (C++
  // 13.1p2). While not part of the definition of the signature,
  // this check is important to determine whether these functions
  // can be overloaded.
  CXXMethodDecl /*P*/ OldMethod = dyn_cast_CXXMethodDecl(Old);
  CXXMethodDecl /*P*/ NewMethod = dyn_cast_CXXMethodDecl(New);
  if ((OldMethod != null) && (NewMethod != null)
     && !OldMethod.isStatic() && !NewMethod.isStatic()) {
    if (OldMethod.getRefQualifier() != NewMethod.getRefQualifier()) {
      if (!UseMemberUsingDeclRules
         && (OldMethod.getRefQualifier() == RefQualifierKind.RQ_None
         || NewMethod.getRefQualifier() == RefQualifierKind.RQ_None)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // C++0x [over.load]p2:
          //   - Member function declarations with the same name and the same
          //     parameter-type-list as well as member function template
          //     declarations with the same name, the same parameter-type-list, and
          //     the same template parameter lists cannot be overloaded if any of
          //     them, but not all, have a ref-qualifier (8.3.5).
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(NewMethod.getLocation(), diag.err_ref_qualifier_overload)), 
                  NewMethod.getRefQualifier()), OldMethod.getRefQualifier()));
          $c$.clean($c$.track($this().Diag(OldMethod.getLocation(), diag.note_previous_declaration)));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    // We may not have applied the implicit const for a constexpr member
    // function yet (because we haven't yet resolved whether this is a static
    // or non-static member function). Add it now, on the assumption that this
    // is a redeclaration of OldMethod.
    /*uint*/int OldQuals = OldMethod.getTypeQualifiers();
    /*uint*/int NewQuals = NewMethod.getTypeQualifiers();
    if (!$this().getLangOpts().CPlusPlus14 && NewMethod.isConstexpr()
       && !isa_CXXConstructorDecl(NewMethod)) {
      NewQuals |= Qualifiers.TQ.Const;
    }
    
    // We do not allow overloading based off of '__restrict'.
    OldQuals &= ~Qualifiers.TQ.Restrict;
    NewQuals &= ~Qualifiers.TQ.Restrict;
    if (OldQuals != NewQuals) {
      return true;
    }
  }
  
  // Though pass_object_size is placed on parameters and takes an argument, we
  // consider it to be a function-level modifier for the sake of function
  // identity. Either the function has one or more parameters with
  // pass_object_size or it doesn't.
  if (functionHasPassObjectSizeParams(New)
     != functionHasPassObjectSizeParams(Old)) {
    return true;
  }
  
  // enable_if attributes are an order-sensitive part of the signature.
  for (specific_attr_iterator<EnableIfAttr> NewI = New.specific_attr_begin(EnableIfAttr.class), 
      NewE = New.specific_attr_end(EnableIfAttr.class), 
      OldI = Old.specific_attr_begin(EnableIfAttr.class), 
      OldE = Old.specific_attr_end(EnableIfAttr.class);
       $noteq_specific_attr_iterator$SpecificAttr/*$Container*/(/*NO_COPY*/NewI, /*NO_COPY*/NewE) || $noteq_specific_attr_iterator$SpecificAttr/*$Container*/(/*NO_COPY*/OldI, /*NO_COPY*/OldE); NewI.$preInc() , OldI.$preInc()) {
    if ($eq_specific_attr_iterator$SpecificAttr/*$Container*/(/*NO_COPY*/NewI, /*NO_COPY*/NewE) || $eq_specific_attr_iterator$SpecificAttr/*$Container*/(/*NO_COPY*/OldI, /*NO_COPY*/OldE)) {
      return true;
    }
    FoldingSetNodeID NewID/*J*/= new FoldingSetNodeID();
    FoldingSetNodeID OldID/*J*/= new FoldingSetNodeID();
    NewI.$arrow().getCond().Profile(NewID, $this().Context, true);
    OldI.$arrow().getCond().Profile(OldID, $this().Context, true);
    if (NewID.$noteq(OldID)) {
      return true;
    }
  }
  if ($this().getLangOpts().CUDA && ConsiderCudaAttrs) {
    CUDAFunctionTarget NewTarget = $this().IdentifyCUDATarget(New);
    CUDAFunctionTarget OldTarget = $this().IdentifyCUDATarget(Old);
    if (NewTarget == CUDAFunctionTarget.CFT_InvalidTarget || NewTarget == CUDAFunctionTarget.CFT_Global) {
      return false;
    }
    assert ((OldTarget != CUDAFunctionTarget.CFT_InvalidTarget)) : "Unexpected invalid target.";
    
    // Don't allow mixing of HD with other kinds. This guarantees that
    // we have only one viable function with this signature on any
    // side of CUDA compilation .
    // __global__ functions can't be overloaded based on attribute
    // difference because, like HD, they also exist on both sides.
    if ((NewTarget == CUDAFunctionTarget.CFT_HostDevice) || (OldTarget == CUDAFunctionTarget.CFT_HostDevice)
       || (NewTarget == CUDAFunctionTarget.CFT_Global) || (OldTarget == CUDAFunctionTarget.CFT_Global)) {
      return false;
    }
    
    // Allow overloading of functions with same signature, but
    // different CUDA target attributes.
    return NewTarget != OldTarget;
  }
  
  // The signatures match; this is not an overload.
  return false;
}


/// \brief Checks availability of the function depending on the current
/// function context.Inside an unavailable function,unavailability is ignored.
///
/// \returns true if \p FD is unavailable and current context is inside
/// an available function, false otherwise.

/// \brief Checks availability of the function depending on the current
/// function context. Inside an unavailable function, unavailability is ignored.
///
/// \returns true if \arg FD is unavailable and current context is inside
/// an available function, false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isFunctionConsideredUnavailable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1159,
 FQN="clang::Sema::isFunctionConsideredUnavailable", NM="_ZN5clang4Sema31isFunctionConsideredUnavailableEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema31isFunctionConsideredUnavailableEPNS_12FunctionDeclE")
//</editor-fold>
public final boolean isFunctionConsideredUnavailable(FunctionDecl /*P*/ FD) {
  if (!FD.isUnavailable()) {
    return false;
  }
  
  // Walk up the context of the caller.
  Decl /*P*/ C = cast_Decl($this().CurContext);
  do {
    if (C.isUnavailable()) {
      return false;
    }
  } while (((C = cast_or_null_Decl(C.getDeclContext())) != null));
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::TryImplicitConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1335,
 FQN="clang::Sema::TryImplicitConversion", NM="_ZN5clang4Sema21TryImplicitConversionEPNS_4ExprENS_8QualTypeEbbbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema21TryImplicitConversionEPNS_4ExprENS_8QualTypeEbbbbb")
//</editor-fold>
public final ImplicitConversionSequence TryImplicitConversion(Expr /*P*/ From, QualType ToType, 
                     boolean SuppressUserConversions, 
                     boolean AllowExplicit, 
                     boolean InOverloadResolution, 
                     boolean CStyle, 
                     boolean AllowObjCWritebackConversion) {
  return SemaOverloadStatics./*::*/TryImplicitConversion(/*Deref*/$this(), From, new QualType(ToType), 
      SuppressUserConversions, AllowExplicit, 
      InOverloadResolution, CStyle, 
      AllowObjCWritebackConversion, 
      /*AllowObjCConversionOnExplicit=*/ false);
}


/// IsIntegralPromotion - Determines whether the conversion from the
/// expression From (whose potentially-adjusted type is FromType) to
/// ToType is an integral promotion (C++ 4.5). If so, returns true and
/// sets PromotedType to the promoted type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsIntegralPromotion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1829,
 FQN="clang::Sema::IsIntegralPromotion", NM="_ZN5clang4Sema19IsIntegralPromotionEPNS_4ExprENS_8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema19IsIntegralPromotionEPNS_4ExprENS_8QualTypeES3_")
//</editor-fold>
public final boolean IsIntegralPromotion(Expr /*P*/ From, QualType FromType, QualType ToType) {
  /*const*/ BuiltinType /*P*/ To = ToType.$arrow().getAs$BuiltinType();
  // All integers are built-in.
  if (!(To != null)) {
    return false;
  }
  
  // An rvalue of type char, signed char, unsigned char, short int, or
  // unsigned short int can be converted to an rvalue of type int if
  // int can represent all the values of the source type; otherwise,
  // the source rvalue can be converted to an rvalue of type unsigned
  // int (C++ 4.5p1).
  if (FromType.$arrow().isPromotableIntegerType() && !FromType.$arrow().isBooleanType()
     && !FromType.$arrow().isEnumeralType()) {
    if ((FromType.$arrow().isSignedIntegerType()
      // We can promote any unsigned integer type whose size is
      // less than int to an int.
       || $less_ulong($this().Context.getTypeSize(new QualType(FromType)), $this().Context.getTypeSize(new QualType(ToType))))) {
      return To.getKind() == BuiltinType.Kind.Int;
    }
    
    return To.getKind() == BuiltinType.Kind.UInt;
  }
  {
    
    // C++11 [conv.prom]p3:
    //   A prvalue of an unscoped enumeration type whose underlying type is not
    //   fixed (7.2) can be converted to an rvalue a prvalue of the first of the
    //   following types that can represent all the values of the enumeration
    //   (i.e., the values in the range bmin to bmax as described in 7.2): int,
    //   unsigned int, long int, unsigned long int, long long int, or unsigned
    //   long long int. If none of the types in that list can represent all the
    //   values of the enumeration, an rvalue a prvalue of an unscoped enumeration
    //   type can be converted to an rvalue a prvalue of the extended integer type
    //   with lowest integer conversion rank (4.13) greater than the rank of long
    //   long in which all the values of the enumeration can be represented. If
    //   there are two such extended types, the signed one is chosen.
    // C++11 [conv.prom]p4:
    //   A prvalue of an unscoped enumeration type whose underlying type is fixed
    //   can be converted to a prvalue of its underlying type. Moreover, if
    //   integral promotion can be applied to its underlying type, a prvalue of an
    //   unscoped enumeration type whose underlying type is fixed can also be
    //   converted to a prvalue of the promoted underlying type.
    /*const*/ EnumType /*P*/ FromEnumType = FromType.$arrow().getAs$EnumType();
    if ((FromEnumType != null)) {
      // C++0x 7.2p9: Note that this implicit enum to int conversion is not
      // provided for a scoped enumeration.
      if (FromEnumType.getDecl().isScoped()) {
        return false;
      }
      
      // We can perform an integral promotion to the underlying type of the enum,
      // even if that's not the promoted type. Note that the check for promoting
      // the underlying type is based on the type alone, and does not consider
      // the bitfield-ness of the actual source expression.
      if (FromEnumType.getDecl().isFixed()) {
        QualType Underlying = FromEnumType.getDecl().getIntegerType();
        return $this().Context.hasSameUnqualifiedType(new QualType(Underlying), new QualType(ToType))
           || $this().IsIntegralPromotion((Expr /*P*/ )null, new QualType(Underlying), new QualType(ToType));
      }
      
      // We have already pre-calculated the promotion type, so this is trivial.
      if (ToType.$arrow().isIntegerType()
         && $this().isCompleteType(From.getLocStart(), new QualType(FromType))) {
        return $this().Context.hasSameUnqualifiedType(new QualType(ToType), FromEnumType.getDecl().getPromotionType());
      }
    }
  }
  
  // C++0x [conv.prom]p2:
  //   A prvalue of type char16_t, char32_t, or wchar_t (3.9.1) can be converted
  //   to an rvalue a prvalue of the first of the following types that can
  //   represent all the values of its underlying type: int, unsigned int,
  //   long int, unsigned long int, long long int, or unsigned long long int.
  //   If none of the types in that list can represent all the values of its
  //   underlying type, an rvalue a prvalue of type char16_t, char32_t,
  //   or wchar_t can be converted to an rvalue a prvalue of its underlying
  //   type.
  if (FromType.$arrow().isAnyCharacterType() && !FromType.$arrow().isCharType()
     && ToType.$arrow().isIntegerType()) {
    // Determine whether the type we're converting from is signed or
    // unsigned.
    boolean FromIsSigned = FromType.$arrow().isSignedIntegerType();
    long/*uint64_t*/ FromSize = $this().Context.getTypeSize(new QualType(FromType));
    
    // The types we'll try to promote to, in the appropriate
    // order. Try each of these types.
    QualType PromoteTypes[/*6*/] = new QualType [/*6*/] {
      $this().Context.IntTy.$QualType(), $this().Context.UnsignedIntTy.$QualType(), 
      $this().Context.LongTy.$QualType(), $this().Context.UnsignedLongTy.$QualType(), 
      $this().Context.LongLongTy.$QualType(), $this().Context.UnsignedLongLongTy.$QualType()
    };
    for (int Idx = 0; Idx < 6; ++Idx) {
      long/*uint64_t*/ ToSize = $this().Context.getTypeSize(new QualType(PromoteTypes[Idx]));
      if ($less_ulong(FromSize, ToSize)
         || (FromSize == ToSize
         && FromIsSigned == PromoteTypes[Idx].$arrow().isSignedIntegerType())) {
        // We found the type that we can promote to. If this is the
        // type we wanted, we have a promotion. Otherwise, no
        // promotion.
        return $this().Context.hasSameUnqualifiedType(new QualType(ToType), new QualType(PromoteTypes[Idx]));
      }
    }
  }
  
  // An rvalue for an integral bit-field (9.6) can be converted to an
  // rvalue of type int if int can represent all the values of the
  // bit-field; otherwise, it can be converted to unsigned int if
  // unsigned int can represent all the values of the bit-field. If
  // the bit-field is larger yet, no integral promotion applies to
  // it. If the bit-field has an enumerated type, it is treated as any
  // other value of that type for promotion purposes (C++ 4.5p3).
  // FIXME: We should delay checking of bit-fields until we actually perform the
  // conversion.
  if ((From != null)) {
    {
      FieldDecl /*P*/ MemberDecl = From.getSourceBitField();
      if ((MemberDecl != null)) {
        APSInt BitWidth/*J*/= new APSInt();
        if (FromType.$arrow().isIntegralType($this().Context)
           && MemberDecl.getBitWidth().isIntegerConstantExpr(BitWidth, $this().Context)) {
          APSInt ToSize/*J*/= new APSInt(BitWidth.getBitWidth(), BitWidth.isUnsigned());
          ToSize.$assign($this().Context.getTypeSize(new QualType(ToType)));
          
          // Are we promoting to an int from a bitfield that fits in an int?
          if (BitWidth.$less(ToSize)
             || (FromType.$arrow().isSignedIntegerType() && BitWidth.$lesseq(ToSize))) {
            return To.getKind() == BuiltinType.Kind.Int;
          }
          
          // Are we promoting to an unsigned int from an unsigned bitfield
          // that fits into an unsigned int?
          if (FromType.$arrow().isUnsignedIntegerType() && BitWidth.$lesseq(ToSize)) {
            return To.getKind() == BuiltinType.Kind.UInt;
          }
          
          return false;
        }
      }
    }
  }
  
  // An rvalue of type bool can be converted to an rvalue of type int,
  // with false becoming zero and true becoming one (C++ 4.5p4).
  if (FromType.$arrow().isBooleanType() && To.getKind() == BuiltinType.Kind.Int) {
    return true;
  }
  
  return false;
}


/// IsFloatingPointPromotion - Determines whether the conversion from
/// FromType to ToType is a floating point promotion (C++ 4.6). If so,
/// returns true and sets PromotedType to the promoted type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsFloatingPointPromotion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1977,
 FQN="clang::Sema::IsFloatingPointPromotion", NM="_ZN5clang4Sema24IsFloatingPointPromotionENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema24IsFloatingPointPromotionENS_8QualTypeES1_")
//</editor-fold>
public final boolean IsFloatingPointPromotion(QualType FromType, QualType ToType) {
  {
    /*const*/ BuiltinType /*P*/ FromBuiltin = FromType.$arrow().getAs$BuiltinType();
    if ((FromBuiltin != null)) {
      {
        /*const*/ BuiltinType /*P*/ ToBuiltin = ToType.$arrow().getAs$BuiltinType();
        if ((ToBuiltin != null)) {
          /// An rvalue of type float can be converted to an rvalue of type
          /// double. (C++ 4.6p1).
          if (FromBuiltin.getKind() == BuiltinType.Kind.Float
             && ToBuiltin.getKind() == BuiltinType.Kind.Double) {
            return true;
          }
          
          // C99 6.3.1.5p1:
          //   When a float is promoted to double or long double, or a
          //   double is promoted to long double [...].
          if (!$this().getLangOpts().CPlusPlus
             && (FromBuiltin.getKind() == BuiltinType.Kind.Float
             || FromBuiltin.getKind() == BuiltinType.Kind.Double)
             && (ToBuiltin.getKind() == BuiltinType.Kind.LongDouble
             || ToBuiltin.getKind() == BuiltinType.Kind.Float128)) {
            return true;
          }
          
          // Half can be promoted to float.
          if (!$this().getLangOpts().NativeHalfType
             && FromBuiltin.getKind() == BuiltinType.Kind.Half
             && ToBuiltin.getKind() == BuiltinType.Kind.Float) {
            return true;
          }
        }
      }
    }
  }
  
  return false;
}


/// \brief Determine if a conversion is a complex promotion.
///
/// A complex promotion is defined as a complex -> complex conversion
/// where the conversion between the underlying real types is a
/// floating-point or integral promotion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsComplexPromotion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2011,
 FQN="clang::Sema::IsComplexPromotion", NM="_ZN5clang4Sema18IsComplexPromotionENS_8QualTypeES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema18IsComplexPromotionENS_8QualTypeES1_")
//</editor-fold>
public final boolean IsComplexPromotion(QualType FromType, QualType ToType) {
  /*const*/ ComplexType /*P*/ FromComplex = FromType.$arrow().getAs(ComplexType.class);
  if (!(FromComplex != null)) {
    return false;
  }
  
  /*const*/ ComplexType /*P*/ ToComplex = ToType.$arrow().getAs(ComplexType.class);
  if (!(ToComplex != null)) {
    return false;
  }
  
  return $this().IsFloatingPointPromotion(FromComplex.getElementType(), 
      ToComplex.getElementType())
     || $this().IsIntegralPromotion((Expr /*P*/ )null, FromComplex.getElementType(), 
      ToComplex.getElementType());
}


/// IsPointerConversion - Determines whether the conversion of the
/// expression From, which has the (possibly adjusted) type FromType,
/// can be converted to the type ToType via a pointer conversion (C++
/// 4.10). If so, returns true and places the converted type (that
/// might differ from ToType in its cv-qualifiers at some level) into
/// ConvertedType.
///
/// This routine also supports conversions to and from block pointers
/// and conversions with Objective-C's 'id', 'id<protocols...>', and
/// pointers to interfaces. FIXME: Once we've determined the
/// appropriate overloading rules for Objective-C, we may want to
/// split the Objective-C checks into a different routine; however,
/// GCC seems to consider all of these conversions to be pointer
/// conversions, so for now they live here. IncompatibleObjC will be
/// set if the conversion is an allowed Objective-C conversion that
/// should result in a warning.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2105,
 FQN="clang::Sema::IsPointerConversion", NM="_ZN5clang4Sema19IsPointerConversionEPNS_4ExprENS_8QualTypeES3_bRS3_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema19IsPointerConversionEPNS_4ExprENS_8QualTypeES3_bRS3_Rb")
//</editor-fold>
public final boolean IsPointerConversion(Expr /*P*/ From, QualType FromType, QualType ToType, 
                   boolean InOverloadResolution, 
                   final QualType /*&*/ ConvertedType, 
                   final bool$ref/*bool &*/ IncompatibleObjC) {
  IncompatibleObjC.$set(false);
  if ($this().isObjCPointerConversion(new QualType(FromType), new QualType(ToType), ConvertedType, 
      IncompatibleObjC)) {
    return true;
  }
  
  // Conversion from a null pointer constant to any Objective-C pointer type.
  if (ToType.$arrow().isObjCObjectPointerType()
     && isNullPointerConstantForConversion(From, InOverloadResolution, $this().Context)) {
    ConvertedType.$assign(ToType);
    return true;
  }
  
  // Blocks: Block pointers can be converted to void*.
  if (FromType.$arrow().isBlockPointerType() && ToType.$arrow().isPointerType()
     && ToType.$arrow().getAs(PointerType.class).getPointeeType().$arrow().isVoidType()) {
    ConvertedType.$assign(ToType);
    return true;
  }
  // Blocks: A null pointer constant can be converted to a block
  // pointer type.
  if (ToType.$arrow().isBlockPointerType()
     && isNullPointerConstantForConversion(From, InOverloadResolution, $this().Context)) {
    ConvertedType.$assign(ToType);
    return true;
  }
  
  // If the left-hand-side is nullptr_t, the right side can be a null
  // pointer constant.
  if (ToType.$arrow().isNullPtrType()
     && isNullPointerConstantForConversion(From, InOverloadResolution, $this().Context)) {
    ConvertedType.$assign(ToType);
    return true;
  }
  
  /*const*/ PointerType /*P*/ ToTypePtr = ToType.$arrow().getAs(PointerType.class);
  if (!(ToTypePtr != null)) {
    return false;
  }
  
  // A null pointer constant can be converted to a pointer type (C++ 4.10p1).
  if (isNullPointerConstantForConversion(From, InOverloadResolution, $this().Context)) {
    ConvertedType.$assign(ToType);
    return true;
  }
  
  // Beyond this point, both types need to be pointers
  // , including objective-c pointers.
  QualType ToPointeeType = ToTypePtr.getPointeeType();
  if (FromType.$arrow().isObjCObjectPointerType() && ToPointeeType.$arrow().isVoidType()
     && !$this().getLangOpts().ObjCAutoRefCount) {
    ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromType.$arrow().getAs(ObjCObjectPointerType.class), 
            new QualType(ToPointeeType), 
            new QualType(ToType), $this().Context));
    return true;
  }
  /*const*/ PointerType /*P*/ FromTypePtr = FromType.$arrow().getAs(PointerType.class);
  if (!(FromTypePtr != null)) {
    return false;
  }
  
  QualType FromPointeeType = FromTypePtr.getPointeeType();
  
  // If the unqualified pointee types are the same, this can't be a
  // pointer conversion, so don't do all of the work below.
  if ($this().Context.hasSameUnqualifiedType(new QualType(FromPointeeType), new QualType(ToPointeeType))) {
    return false;
  }
  
  // An rvalue of type "pointer to cv T," where T is an object type,
  // can be converted to an rvalue of type "pointer to cv void" (C++
  // 4.10p2).
  if (FromPointeeType.$arrow().isIncompleteOrObjectType()
     && ToPointeeType.$arrow().isVoidType()) {
    ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromTypePtr, 
            new QualType(ToPointeeType), 
            new QualType(ToType), $this().Context, 
            /*StripObjCLifetime=*/ true));
    return true;
  }
  
  // MSVC allows implicit function to void* type conversion.
  if ($this().getLangOpts().MSVCCompat && FromPointeeType.$arrow().isFunctionType()
     && ToPointeeType.$arrow().isVoidType()) {
    ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromTypePtr, 
            new QualType(ToPointeeType), 
            new QualType(ToType), $this().Context));
    return true;
  }
  
  // When we're overloading in C, we allow a special kind of pointer
  // conversion for compatible-but-not-identical pointee types.
  if (!$this().getLangOpts().CPlusPlus
     && $this().Context.typesAreCompatible(new QualType(FromPointeeType), new QualType(ToPointeeType))) {
    ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromTypePtr, 
            new QualType(ToPointeeType), 
            new QualType(ToType), $this().Context));
    return true;
  }
  
  // C++ [conv.ptr]p3:
  //
  //   An rvalue of type "pointer to cv D," where D is a class type,
  //   can be converted to an rvalue of type "pointer to cv B," where
  //   B is a base class (clause 10) of D. If B is an inaccessible
  //   (clause 11) or ambiguous (10.2) base class of D, a program that
  //   necessitates this conversion is ill-formed. The result of the
  //   conversion is a pointer to the base class sub-object of the
  //   derived class object. The null pointer value is converted to
  //   the null pointer value of the destination type.
  //
  // Note that we do not check for ambiguity or inaccessibility
  // here. That is handled by CheckPointerConversion.
  if ($this().getLangOpts().CPlusPlus
     && FromPointeeType.$arrow().isRecordType() && ToPointeeType.$arrow().isRecordType()
     && !$this().Context.hasSameUnqualifiedType(new QualType(FromPointeeType), new QualType(ToPointeeType))
     && $this().IsDerivedFrom(From.getLocStart(), new QualType(FromPointeeType), new QualType(ToPointeeType))) {
    ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromTypePtr, 
            new QualType(ToPointeeType), 
            new QualType(ToType), $this().Context));
    return true;
  }
  if (FromPointeeType.$arrow().isVectorType() && ToPointeeType.$arrow().isVectorType()
     && $this().Context.areCompatibleVectorTypes(new QualType(FromPointeeType), new QualType(ToPointeeType))) {
    ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromTypePtr, 
            new QualType(ToPointeeType), 
            new QualType(ToType), $this().Context));
    return true;
  }
  
  return false;
}


/// isObjCPointerConversion - Determines whether this is an
/// Objective-C pointer conversion. Subroutine of IsPointerConversion,
/// with the same arguments and return values.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isObjCPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2257,
 FQN="clang::Sema::isObjCPointerConversion", NM="_ZN5clang4Sema23isObjCPointerConversionENS_8QualTypeES1_RS1_Rb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema23isObjCPointerConversionENS_8QualTypeES1_RS1_Rb")
//</editor-fold>
public final boolean isObjCPointerConversion(QualType FromType, QualType ToType, 
                       final QualType /*&*/ ConvertedType, 
                       final bool$ref/*bool &*/ IncompatibleObjC) {
  if (!$this().getLangOpts().ObjC1) {
    return false;
  }
  
  // The set of qualifiers on the type we're converting from.
  Qualifiers FromQualifiers = FromType.getQualifiers();
  
  // First, we handle all conversions on ObjC object pointer types.
  /*const*/ ObjCObjectPointerType /*P*/ ToObjCPtr = ToType.$arrow().getAs(ObjCObjectPointerType.class);
  /*const*/ ObjCObjectPointerType /*P*/ FromObjCPtr = FromType.$arrow().getAs(ObjCObjectPointerType.class);
  if ((ToObjCPtr != null) && (FromObjCPtr != null)) {
    // If the pointee types are the same (ignoring qualifications),
    // then this is not a pointer conversion.
    if ($this().Context.hasSameUnqualifiedType(ToObjCPtr.getPointeeType(), 
        FromObjCPtr.getPointeeType())) {
      return false;
    }
    
    // Conversion between Objective-C pointers.
    if ($this().Context.canAssignObjCInterfaces(ToObjCPtr, FromObjCPtr)) {
      /*const*/ ObjCInterfaceType /*P*/ LHS = ToObjCPtr.getInterfaceType();
      /*const*/ ObjCInterfaceType /*P*/ RHS = FromObjCPtr.getInterfaceType();
      if ($this().getLangOpts().CPlusPlus && (LHS != null) && (RHS != null)
         && !ToObjCPtr.getPointeeType().isAtLeastAsQualifiedAs(FromObjCPtr.getPointeeType())) {
        return false;
      }
      ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromObjCPtr, 
              ToObjCPtr.getPointeeType(), 
              new QualType(ToType), $this().Context));
      ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ConvertedType), new Qualifiers(FromQualifiers)));
      return true;
    }
    if ($this().Context.canAssignObjCInterfaces(FromObjCPtr, ToObjCPtr)) {
      // Okay: this is some kind of implicit downcast of Objective-C
      // interfaces, which is permitted. However, we're going to
      // complain about it.
      IncompatibleObjC.$set(true);
      ConvertedType.$assignMove(BuildSimilarlyQualifiedPointerType(FromObjCPtr, 
              ToObjCPtr.getPointeeType(), 
              new QualType(ToType), $this().Context));
      ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ConvertedType), new Qualifiers(FromQualifiers)));
      return true;
    }
  }
  // Beyond this point, both types need to be C pointers or block pointers.
  QualType ToPointeeType/*J*/= new QualType();
  {
    /*const*/ PointerType /*P*/ ToCPtr = ToType.$arrow().getAs(PointerType.class);
    if ((ToCPtr != null)) {
      ToPointeeType.$assignMove(ToCPtr.getPointeeType());
    } else {
      /*const*/ BlockPointerType /*P*/ ToBlockPtr = ToType.$arrow().getAs(BlockPointerType.class);
      if ((ToBlockPtr != null)) {
        // Objective C++: We're able to convert from a pointer to any object
        // to a block pointer type.
        if ((FromObjCPtr != null) && FromObjCPtr.isObjCBuiltinType()) {
          ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ToType), new Qualifiers(FromQualifiers)));
          return true;
        }
        ToPointeeType.$assignMove(ToBlockPtr.getPointeeType());
      } else if ((FromType.$arrow().getAs(BlockPointerType.class) != null)
         && (ToObjCPtr != null) && ToObjCPtr.isObjCBuiltinType()) {
        // Objective C++: We're able to convert from a block pointer type to a
        // pointer to any object.
        ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ToType), new Qualifiers(FromQualifiers)));
        return true;
      } else {
        return false;
      }
    }
  }
  
  QualType FromPointeeType/*J*/= new QualType();
  {
    /*const*/ PointerType /*P*/ FromCPtr = FromType.$arrow().getAs(PointerType.class);
    if ((FromCPtr != null)) {
      FromPointeeType.$assignMove(FromCPtr.getPointeeType());
    } else {
      /*const*/ BlockPointerType /*P*/ FromBlockPtr = FromType.$arrow().getAs(BlockPointerType.class);
      if ((FromBlockPtr != null)) {
        FromPointeeType.$assignMove(FromBlockPtr.getPointeeType());
      } else {
        return false;
      }
    }
  }
  
  // If we have pointers to pointers, recursively check whether this
  // is an Objective-C conversion.
  if (FromPointeeType.$arrow().isPointerType() && ToPointeeType.$arrow().isPointerType()
     && $this().isObjCPointerConversion(new QualType(FromPointeeType), new QualType(ToPointeeType), ConvertedType, 
      IncompatibleObjC)) {
    // We always complain about this conversion.
    IncompatibleObjC.$set(true);
    ConvertedType.$assignMove($this().Context.getPointerType(new QualType(ConvertedType)));
    ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ConvertedType), new Qualifiers(FromQualifiers)));
    return true;
  }
  // Allow conversion of pointee being objective-c pointer to another one;
  // as in I* to id.
  if ((FromPointeeType.$arrow().getAs(ObjCObjectPointerType.class) != null)
     && (ToPointeeType.$arrow().getAs(ObjCObjectPointerType.class) != null)
     && $this().isObjCPointerConversion(new QualType(FromPointeeType), new QualType(ToPointeeType), ConvertedType, 
      IncompatibleObjC)) {
    
    ConvertedType.$assignMove($this().Context.getPointerType(new QualType(ConvertedType)));
    ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ConvertedType), new Qualifiers(FromQualifiers)));
    return true;
  }
  
  // If we have pointers to functions or blocks, check whether the only
  // differences in the argument and result types are in Objective-C
  // pointer conversions. If so, we permit the conversion (but
  // complain about it).
  /*const*/ FunctionProtoType /*P*/ FromFunctionType = FromPointeeType.$arrow().getAs(FunctionProtoType.class);
  /*const*/ FunctionProtoType /*P*/ ToFunctionType = ToPointeeType.$arrow().getAs(FunctionProtoType.class);
  if ((FromFunctionType != null) && (ToFunctionType != null)) {
    // If the function types are exactly the same, this isn't an
    // Objective-C pointer conversion.
    if ($eq_CanQual$T_CanQual$U($this().Context.getCanonicalType(new QualType(FromPointeeType)), 
        $this().Context.getCanonicalType(new QualType(ToPointeeType)))) {
      return false;
    }
    
    // Perform the quick checks that will tell us whether these
    // function types are obviously different.
    if (FromFunctionType.getNumParams() != ToFunctionType.getNumParams()
       || FromFunctionType.isVariadic() != ToFunctionType.isVariadic()
       || FromFunctionType.getTypeQuals() != ToFunctionType.getTypeQuals()) {
      return false;
    }
    
    boolean HasObjCConversion = false;
    if ($eq_CanQual$T_CanQual$U($this().Context.getCanonicalType(FromFunctionType.getReturnType()), 
        $this().Context.getCanonicalType(ToFunctionType.getReturnType()))) {
      // Okay, the types match exactly. Nothing to do.
    } else if ($this().isObjCPointerConversion(FromFunctionType.getReturnType(), 
        ToFunctionType.getReturnType(), 
        ConvertedType, IncompatibleObjC)) {
      // Okay, we have an Objective-C pointer conversion.
      HasObjCConversion = true;
    } else {
      // Function types are too different. Abort.
      return false;
    }
    
    // Check argument types.
    for (/*uint*/int ArgIdx = 0, NumArgs = FromFunctionType.getNumParams();
         ArgIdx != NumArgs; ++ArgIdx) {
      QualType FromArgType = FromFunctionType.getParamType(ArgIdx);
      QualType ToArgType = ToFunctionType.getParamType(ArgIdx);
      if ($eq_CanQual$T_CanQual$U($this().Context.getCanonicalType(new QualType(FromArgType)), 
          $this().Context.getCanonicalType(new QualType(ToArgType)))) {
        // Okay, the types match exactly. Nothing to do.
      } else if ($this().isObjCPointerConversion(new QualType(FromArgType), new QualType(ToArgType), 
          ConvertedType, IncompatibleObjC)) {
        // Okay, we have an Objective-C pointer conversion.
        HasObjCConversion = true;
      } else {
        // Argument types are too different. Abort.
        return false;
      }
    }
    if (HasObjCConversion) {
      // We had an Objective-C conversion. Allow this pointer
      // conversion, but complain about it.
      ConvertedType.$assignMove(AdoptQualifiers($this().Context, new QualType(ToType), new Qualifiers(FromQualifiers)));
      IncompatibleObjC.$set(true);
      return true;
    }
  }
  
  return false;
}


/// \brief Determine whether this is an Objective-C writeback conversion,
/// used for parameter passing when performing automatic reference counting.
///
/// \param FromType The type we're converting form.
///
/// \param ToType The type we're converting to.
///
/// \param ConvertedType The type that will be produced after applying
/// this conversion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isObjCWritebackConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2437,
 FQN="clang::Sema::isObjCWritebackConversion", NM="_ZN5clang4Sema25isObjCWritebackConversionENS_8QualTypeES1_RS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25isObjCWritebackConversionENS_8QualTypeES1_RS1_")
//</editor-fold>
public final boolean isObjCWritebackConversion(QualType FromType, QualType ToType, 
                         final QualType /*&*/ ConvertedType) {
  if (!$this().getLangOpts().ObjCAutoRefCount
     || $this().Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType))) {
    return false;
  }
  
  // Parameter must be a pointer to __autoreleasing (with no other qualifiers).
  QualType ToPointee/*J*/= new QualType();
  {
    /*const*/ PointerType /*P*/ ToPointer = ToType.$arrow().getAs(PointerType.class);
    if ((ToPointer != null)) {
      ToPointee.$assignMove(ToPointer.getPointeeType());
    } else {
      return false;
    }
  }
  
  Qualifiers ToQuals = ToPointee.getQualifiers();
  if (!ToPointee.$arrow().isObjCLifetimeType()
     || ToQuals.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Autoreleasing
     || !ToQuals.withoutObjCLifetime().empty()) {
    return false;
  }
  
  // Argument must be a pointer to __strong to __weak.
  QualType FromPointee/*J*/= new QualType();
  {
    /*const*/ PointerType /*P*/ FromPointer = FromType.$arrow().getAs(PointerType.class);
    if ((FromPointer != null)) {
      FromPointee.$assignMove(FromPointer.getPointeeType());
    } else {
      return false;
    }
  }
  
  Qualifiers FromQuals = FromPointee.getQualifiers();
  if (!FromPointee.$arrow().isObjCLifetimeType()
     || (FromQuals.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Strong
     && FromQuals.getObjCLifetime() != Qualifiers.ObjCLifetime.OCL_Weak)) {
    return false;
  }
  
  // Make sure that we have compatible qualifiers.
  FromQuals.setObjCLifetime(Qualifiers.ObjCLifetime.OCL_Autoreleasing);
  if (!ToQuals.compatiblyIncludes(new Qualifiers(FromQuals))) {
    return false;
  }
  
  // Remove qualifiers from the pointee type we're converting from; they
  // aren't used in the compatibility check belong, and we'll be adding back
  // qualifiers (with __autoreleasing) if the compatibility check succeeds.
  FromPointee.$assignMove(FromPointee.getUnqualifiedType());
  
  // The unqualified form of the pointee types must be compatible.
  ToPointee.$assignMove(ToPointee.getUnqualifiedType());
  bool$ref IncompatibleObjC = create_bool$ref();
  if ($this().Context.typesAreCompatible(new QualType(FromPointee), new QualType(ToPointee))) {
    FromPointee.$assign(ToPointee);
  } else if (!$this().isObjCPointerConversion(new QualType(FromPointee), new QualType(ToPointee), FromPointee, 
      IncompatibleObjC)) {
    return false;
  }
  
  /// \brief Construct the type we're converting to, which is a pointer to
  /// __autoreleasing pointee.
  FromPointee.$assignMove($this().Context.getQualifiedType(new QualType(FromPointee), new Qualifiers(FromQuals)));
  ConvertedType.$assignMove($this().Context.getPointerType(new QualType(FromPointee)));
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsBlockPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2495,
 FQN="clang::Sema::IsBlockPointerConversion", NM="_ZN5clang4Sema24IsBlockPointerConversionENS_8QualTypeES1_RS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema24IsBlockPointerConversionENS_8QualTypeES1_RS1_")
//</editor-fold>
public final boolean IsBlockPointerConversion(QualType FromType, QualType ToType, 
                        final QualType /*&*/ ConvertedType) {
  QualType ToPointeeType/*J*/= new QualType();
  {
    /*const*/ BlockPointerType /*P*/ ToBlockPtr = ToType.$arrow().getAs(BlockPointerType.class);
    if ((ToBlockPtr != null)) {
      ToPointeeType.$assignMove(ToBlockPtr.getPointeeType());
    } else {
      return false;
    }
  }
  
  QualType FromPointeeType/*J*/= new QualType();
  {
    /*const*/ BlockPointerType /*P*/ FromBlockPtr = FromType.$arrow().getAs(BlockPointerType.class);
    if ((FromBlockPtr != null)) {
      FromPointeeType.$assignMove(FromBlockPtr.getPointeeType());
    } else {
      return false;
    }
  }
  // We have pointer to blocks, check whether the only
  // differences in the argument and result types are in Objective-C
  // pointer conversions. If so, we permit the conversion.
  /*const*/ FunctionProtoType /*P*/ FromFunctionType = FromPointeeType.$arrow().getAs(FunctionProtoType.class);
  /*const*/ FunctionProtoType /*P*/ ToFunctionType = ToPointeeType.$arrow().getAs(FunctionProtoType.class);
  if (!(FromFunctionType != null) || !(ToFunctionType != null)) {
    return false;
  }
  if ($this().Context.hasSameType(new QualType(FromPointeeType), new QualType(ToPointeeType))) {
    return true;
  }
  
  // Perform the quick checks that will tell us whether these
  // function types are obviously different.
  if (FromFunctionType.getNumParams() != ToFunctionType.getNumParams()
     || FromFunctionType.isVariadic() != ToFunctionType.isVariadic()) {
    return false;
  }
  
  FunctionType.ExtInfo FromEInfo = FromFunctionType.getExtInfo();
  FunctionType.ExtInfo ToEInfo = ToFunctionType.getExtInfo();
  if (FromEInfo.$noteq(/*NO_COPY*/ToEInfo)) {
    return false;
  }
  
  bool$ref IncompatibleObjC = create_bool$ref(false);
  if ($this().Context.hasSameType(FromFunctionType.getReturnType(), 
      ToFunctionType.getReturnType())) {
    // Okay, the types match exactly. Nothing to do.
  } else {
    QualType RHS = FromFunctionType.getReturnType();
    QualType LHS = ToFunctionType.getReturnType();
    if ((!$this().getLangOpts().CPlusPlus || !RHS.$arrow().isRecordType())
       && !RHS.hasQualifiers() && LHS.hasQualifiers()) {
      LHS.$assignMove(LHS.getUnqualifiedType());
    }
    if ($this().Context.hasSameType(new QualType(RHS), new QualType(LHS))) {
      // OK exact match.
    } else if ($this().isObjCPointerConversion(new QualType(RHS), new QualType(LHS), 
        ConvertedType, IncompatibleObjC)) {
      if (IncompatibleObjC.$deref()) {
        return false;
      }
      // Okay, we have an Objective-C pointer conversion.
    } else {
      return false;
    }
  }
  
  // Check argument types.
  for (/*uint*/int ArgIdx = 0, NumArgs = FromFunctionType.getNumParams();
       ArgIdx != NumArgs; ++ArgIdx) {
    IncompatibleObjC.$set(false);
    QualType FromArgType = FromFunctionType.getParamType(ArgIdx);
    QualType ToArgType = ToFunctionType.getParamType(ArgIdx);
    if ($this().Context.hasSameType(new QualType(FromArgType), new QualType(ToArgType))) {
      // Okay, the types match exactly. Nothing to do.
    } else if ($this().isObjCPointerConversion(new QualType(ToArgType), new QualType(FromArgType), 
        ConvertedType, IncompatibleObjC)) {
      if (IncompatibleObjC.$deref()) {
        return false;
      }
      // Okay, we have an Objective-C pointer conversion.
    } else {
      // Argument types are too different. Abort.
      return false;
    }
  }
  if (!$this().Context.doFunctionTypesMatchOnExtParameterInfos(FromFunctionType, 
      ToFunctionType)) {
    return false;
  }
  
  ConvertedType.$assign(ToType);
  return true;
}


/// FunctionParamTypesAreEqual - This routine checks two function proto types
/// for equality of their argument types. Caller has already checked that
/// they have same number of arguments.  If the parameters are different,
/// ArgPos will have the parameter index of the first different parameter.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FunctionParamTypesAreEqual">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2698,
 FQN="clang::Sema::FunctionParamTypesAreEqual", NM="_ZN5clang4Sema26FunctionParamTypesAreEqualEPKNS_17FunctionProtoTypeES3_Pj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema26FunctionParamTypesAreEqualEPKNS_17FunctionProtoTypeES3_Pj")
//</editor-fold>
public final boolean FunctionParamTypesAreEqual(/*const*/ FunctionProtoType /*P*/ OldType, 
                          /*const*/ FunctionProtoType /*P*/ NewType) {
  return FunctionParamTypesAreEqual(OldType, 
                          NewType, 
                          (uint$ptr/*uint P*/ )null);
}
public final boolean FunctionParamTypesAreEqual(/*const*/ FunctionProtoType /*P*/ OldType, 
                          /*const*/ FunctionProtoType /*P*/ NewType, 
                          uint$ptr/*uint P*/ ArgPos/*= null*/) {
  for (type$ptr<QualType> O = $tryClone(OldType.param_type_begin()), 
      /*P*/ N = $tryClone(NewType.param_type_begin()), 
      /*P*/ E = $tryClone(OldType.param_type_end());
       Native.$bool(O) && ($noteq_ptr(O, E)); O.$preInc() , N.$preInc()) {
    if (!$this().Context.hasSameType(O./*->*/$star().getUnqualifiedType(), 
        N./*->*/$star().getUnqualifiedType())) {
      if (Native.$bool(ArgPos)) {
        ArgPos.$set(O.$sub(OldType.param_type_begin()));
      }
      return false;
    }
  }
  return true;
}


/// HandleFunctionTypeMismatch - Gives diagnostic information for differeing
/// function types.  Catches different number of parameter, mismatch in
/// parameter types, and different return types.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::HandleFunctionTypeMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2608,
 FQN="clang::Sema::HandleFunctionTypeMismatch", NM="_ZN5clang4Sema26HandleFunctionTypeMismatchERNS_17PartialDiagnosticENS_8QualTypeES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema26HandleFunctionTypeMismatchERNS_17PartialDiagnosticENS_8QualTypeES3_")
//</editor-fold>
public final void HandleFunctionTypeMismatch(final PartialDiagnostic /*&*/ PDiag, 
                          QualType FromType, QualType ToType) {
  // If either type is not valid, include no extra info.
  if (FromType.isNull() || ToType.isNull()) {
    $out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_default.getValue());
    return;
  }
  
  // Get the function type from the pointers.
  if (FromType.$arrow().isMemberPointerType() && ToType.$arrow().isMemberPointerType()) {
    /*const*/ MemberPointerType /*P*/ FromMember = FromType.$arrow().getAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ ToMember = ToType.$arrow().getAs(MemberPointerType.class);
    if (!$this().Context.hasSameType(FromMember.__getClass(), ToMember.__getClass())) {
      $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_different_class.getValue()), new QualType(ToMember.__getClass(), 0)), 
          new QualType(FromMember.__getClass(), 0));
      return;
    }
    FromType.$assignMove(FromMember.getPointeeType());
    ToType.$assignMove(ToMember.getPointeeType());
  }
  if (FromType.$arrow().isPointerType()) {
    FromType.$assignMove(FromType.$arrow().getPointeeType());
  }
  if (ToType.$arrow().isPointerType()) {
    ToType.$assignMove(ToType.$arrow().getPointeeType());
  }
  
  // Remove references.
  FromType.$assignMove(FromType.getNonReferenceType());
  ToType.$assignMove(ToType.getNonReferenceType());
  
  // Don't print extra info for non-specialized template functions.
  if (FromType.$arrow().isInstantiationDependentType()
     && !(FromType.$arrow().getAs$TemplateSpecializationType() != null)) {
    $out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_default.getValue());
    return;
  }
  
  // No extra info for same types.
  if ($this().Context.hasSameType(new QualType(FromType), new QualType(ToType))) {
    $out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_default.getValue());
    return;
  }
  
  /*const*/ FunctionProtoType /*P*/ FromFunction = tryGetFunctionProtoType(new QualType(FromType));
  /*const*/ FunctionProtoType /*P*/ ToFunction = tryGetFunctionProtoType(new QualType(ToType));
  
  // Both types need to be function types.
  if (!(FromFunction != null) || !(ToFunction != null)) {
    $out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_default.getValue());
    return;
  }
  if (FromFunction.getNumParams() != ToFunction.getNumParams()) {
    $out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_parameter_arity.getValue()), ToFunction.getNumParams()), 
        FromFunction.getNumParams());
    return;
  }
  
  // Handle different parameter types.
  uint$ptr ArgPos = create_uint$ptr();
  if (!$this().FunctionParamTypesAreEqual(FromFunction, ToFunction, $AddrOf(ArgPos))) {
    $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_parameter_mismatch.getValue()), ArgPos.$star() + 1), 
            ToFunction.getParamType(ArgPos.$star())), 
        FromFunction.getParamType(ArgPos.$star()));
    return;
  }
  
  // Handle different return type.
  if (!$this().Context.hasSameType(FromFunction.getReturnType(), 
      ToFunction.getReturnType())) {
    $out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_return_type.getValue()), ToFunction.getReturnType()), 
        FromFunction.getReturnType());
    return;
  }
  
  /*uint*/int FromQuals = FromFunction.getTypeQuals();
  /*uint*/int ToQuals = ToFunction.getTypeQuals();
  if (FromQuals != ToQuals) {
    $out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_qualifer_mismatch.getValue()), ToQuals), FromQuals);
    return;
  }
  
  // Unable to find a difference, so add no extra info.
  $out_PartialDiagnostic$C_int(PDiag, SemaOverload_cpp_Unnamed_enum.ft_default.getValue());
}


/// CheckPointerConversion - Check the pointer conversion from the
/// expression From to the type ToType. This routine checks for
/// ambiguous or inaccessible derived-to-base pointer
/// conversions for which IsPointerConversion has already returned
/// true. It returns true and produces a diagnostic if there was an
/// error, or returns false otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2721,
 FQN="clang::Sema::CheckPointerConversion", NM="_ZN5clang4Sema22CheckPointerConversionEPNS_4ExprENS_8QualTypeERNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema22CheckPointerConversionEPNS_4ExprENS_8QualTypeERNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEbb")
//</editor-fold>
public final boolean CheckPointerConversion(Expr /*P*/ From, QualType ToType, 
                      final type$ref<CastKind /*&*/> Kind, 
                      final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath, 
                      boolean IgnoreBaseAccess) {
  return CheckPointerConversion(From, ToType, 
                      Kind, 
                      BasePath, 
                      IgnoreBaseAccess, 
                      true);
}
public final boolean CheckPointerConversion(Expr /*P*/ From, QualType ToType, 
                      final type$ref<CastKind /*&*/> Kind, 
                      final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath, 
                      boolean IgnoreBaseAccess, 
                      boolean Diagnose/*= true*/) {
  QualType FromType = From.getType();
  boolean IsCStyleOrFunctionalCast = IgnoreBaseAccess;
  
  Kind.$set(CastKind.CK_BitCast);
  if (Diagnose && !IsCStyleOrFunctionalCast && !FromType.$arrow().isAnyPointerType()
     && From.isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull)
     == Expr.NullPointerConstantKind.NPCK_ZeroExpression) {
    if ($this().Context.hasSameUnqualifiedType(From.getType(), $this().Context.BoolTy.$QualType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($this().DiagRuntimeBehavior(From.getExprLoc(), From, 
            $out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.warn_impcast_bool_to_null_pointer)), 
                    /*NO_COPY*/ToType), From.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    } else if (!$this().isUnevaluatedContext()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getExprLoc(), diag.warn_non_literal_null_pointer)), 
                ToType), From.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  {
    /*const*/ PointerType /*P*/ ToPtrType = ToType.$arrow().getAs(PointerType.class);
    if ((ToPtrType != null)) {
      {
        /*const*/ PointerType /*P*/ FromPtrType = FromType.$arrow().getAs(PointerType.class);
        if ((FromPtrType != null)) {
          QualType FromPointeeType = FromPtrType.getPointeeType();
          QualType ToPointeeType = ToPtrType.getPointeeType();
          if (FromPointeeType.$arrow().isRecordType() && ToPointeeType.$arrow().isRecordType()
             && !$this().Context.hasSameUnqualifiedType(new QualType(FromPointeeType), new QualType(ToPointeeType))) {
            // We must have a derived-to-base conversion. Check an
            // ambiguous or inaccessible conversion.
            /*uint*/int InaccessibleID = 0;
            /*uint*/int AmbigiousID = 0;
            if (Diagnose) {
              InaccessibleID = diag.err_upcast_to_inaccessible_base;
              AmbigiousID = diag.err_ambiguous_derived_to_base_conv;
            }
            if ($this().CheckDerivedToBaseConversion(new QualType(FromPointeeType), new QualType(ToPointeeType), InaccessibleID, AmbigiousID, 
                From.getExprLoc(), From.getSourceRange(), new DeclarationName(), 
                $AddrOf(BasePath), IgnoreBaseAccess)) {
              return true;
            }
            
            // The conversion was successful.
            Kind.$set(CastKind.CK_DerivedToBase);
          }
          if (Diagnose && !IsCStyleOrFunctionalCast
             && FromPointeeType.$arrow().isFunctionType() && ToPointeeType.$arrow().isVoidType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              assert ($this().getLangOpts().MSVCCompat) : "this should only be possible with MSVCCompat!";
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getExprLoc(), diag.ext_ms_impcast_fn_obj)), 
                  From.getSourceRange()));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    } else {
      /*const*/ ObjCObjectPointerType /*P*/ ToPtrType$1 = ToType.$arrow().getAs(ObjCObjectPointerType.class);
      if ((ToPtrType$1 != null)) {
        {
          /*const*/ ObjCObjectPointerType /*P*/ FromPtrType = FromType.$arrow().getAs(ObjCObjectPointerType.class);
          if ((FromPtrType != null)) {
            // Objective-C++ conversions are always okay.
            // FIXME: We should have a different class of conversions for the
            // Objective-C++ implicit conversions.
            if (FromPtrType.isObjCBuiltinType() || ToPtrType$1.isObjCBuiltinType()) {
              return false;
            }
          } else if (FromType.$arrow().isBlockPointerType()) {
            Kind.$set(CastKind.CK_BlockPointerToObjCPointerCast);
          } else {
            Kind.$set(CastKind.CK_CPointerToObjCPointerCast);
          }
        }
      } else if (ToType.$arrow().isBlockPointerType()) {
        if (!FromType.$arrow().isBlockPointerType()) {
          Kind.$set(CastKind.CK_AnyPointerToBlockPointerCast);
        }
      }
    }
  }
  
  // We shouldn't fall into this case unless it's valid for other
  // reasons.
  if ((From.isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
    Kind.$set(CastKind.CK_NullToPointer);
  }
  
  return false;
}


/// IsMemberPointerConversion - Determines whether the conversion of the
/// expression From, which has the (possibly adjusted) type FromType, can be
/// converted to the type ToType via a member pointer conversion (C++ 4.11).
/// If so, returns true and places the converted type (that might differ from
/// ToType in its cv-qualifiers at some level) into ConvertedType.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsMemberPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2807,
 FQN="clang::Sema::IsMemberPointerConversion", NM="_ZN5clang4Sema25IsMemberPointerConversionEPNS_4ExprENS_8QualTypeES3_bRS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25IsMemberPointerConversionEPNS_4ExprENS_8QualTypeES3_bRS3_")
//</editor-fold>
public final boolean IsMemberPointerConversion(Expr /*P*/ From, QualType FromType, 
                         QualType ToType, 
                         boolean InOverloadResolution, 
                         final QualType /*&*/ ConvertedType) {
  /*const*/ MemberPointerType /*P*/ ToTypePtr = ToType.$arrow().getAs(MemberPointerType.class);
  if (!(ToTypePtr != null)) {
    return false;
  }
  
  // A null pointer constant can be converted to a member pointer (C++ 4.11p1)
  if ((From.isNullPointerConstant($this().Context, 
      InOverloadResolution ? Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull : Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
    ConvertedType.$assign(ToType);
    return true;
  }
  
  // Otherwise, both types have to be member pointers.
  /*const*/ MemberPointerType /*P*/ FromTypePtr = FromType.$arrow().getAs(MemberPointerType.class);
  if (!(FromTypePtr != null)) {
    return false;
  }
  
  // A pointer to member of B can be converted to a pointer to member of D,
  // where D is derived from B (C++ 4.11p2).
  QualType FromClass/*J*/= new QualType(FromTypePtr.__getClass(), 0);
  QualType ToClass/*J*/= new QualType(ToTypePtr.__getClass(), 0);
  if (!$this().Context.hasSameUnqualifiedType(new QualType(FromClass), new QualType(ToClass))
     && $this().IsDerivedFrom(From.getLocStart(), new QualType(ToClass), new QualType(FromClass))) {
    ConvertedType.$assignMove($this().Context.getMemberPointerType(FromTypePtr.getPointeeType(), 
            ToClass.getTypePtr()));
    return true;
  }
  
  return false;
}


/// CheckMemberPointerConversion - Check the member pointer conversion from the
/// expression From to the type ToType. This routine checks for ambiguous or
/// virtual or inaccessible base-to-derived member pointer conversions
/// for which IsMemberPointerConversion has already returned true. It returns
/// true and produces a diagnostic if there was an error, or returns false
/// otherwise.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMemberPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2849,
 FQN="clang::Sema::CheckMemberPointerConversion", NM="_ZN5clang4Sema28CheckMemberPointerConversionEPNS_4ExprENS_8QualTypeERNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema28CheckMemberPointerConversionEPNS_4ExprENS_8QualTypeERNS_8CastKindERN4llvm11SmallVectorIPNS_16CXXBaseSpecifierELj4EEEb")
//</editor-fold>
public final boolean CheckMemberPointerConversion(Expr /*P*/ From, QualType ToType, 
                            final type$ref<CastKind /*&*/> Kind, 
                            final SmallVector<CXXBaseSpecifier /*P*/> /*&*/ BasePath, 
                            boolean IgnoreBaseAccess) {
  CXXBasePaths Paths = null;
  try {
    QualType FromType = From.getType();
    /*const*/ MemberPointerType /*P*/ FromPtrType = FromType.$arrow().getAs(MemberPointerType.class);
    if (!(FromPtrType != null)) {
      // This must be a null pointer to member pointer conversion
      assert ((From.isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) : "Expr must be null pointer constant!";
      Kind.$set(CastKind.CK_NullToMemberPointer);
      return false;
    }
    
    /*const*/ MemberPointerType /*P*/ ToPtrType = ToType.$arrow().getAs(MemberPointerType.class);
    assert ((ToPtrType != null)) : "No member pointer cast has a target type that is not a member pointer.";
    
    QualType FromClass = new QualType(FromPtrType.__getClass(), 0);
    QualType ToClass = new QualType(ToPtrType.__getClass(), 0);
    
    // FIXME: What about dependent types?
    assert (FromClass.$arrow().isRecordType()) : "Pointer into non-class.";
    assert (ToClass.$arrow().isRecordType()) : "Pointer into non-class.";
    
    Paths/*J*/= new CXXBasePaths(/*FindAmbiguities=*/ true, /*RecordPaths=*/ true, 
        /*DetectVirtual=*/ true);
    boolean DerivationOkay = $this().IsDerivedFrom(From.getLocStart(), new QualType(ToClass), new QualType(FromClass), Paths);
    assert (DerivationOkay) : "Should not have been called if derivation isn't OK.";
    ///*J:(void)*/DerivationOkay;
    if (Paths.isAmbiguous($this().Context.getCanonicalType(new QualType(FromClass)).
            getUnqualifiedType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        std.string PathDisplayStr = $this().getAmbiguousPathsDisplayString(Paths);
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getExprLoc(), diag.err_ambiguous_memptr_conv)), 
                            0), FromClass), ToClass), PathDisplayStr), From.getSourceRange()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    {
      
      /*const*/ RecordType /*P*/ VBase = Paths.getDetectedVirtual();
      if ((VBase != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getExprLoc(), diag.err_memptr_conv_via_virtual)), 
                          FromClass), ToClass), new QualType(VBase, 0)), 
              From.getSourceRange()));
          return true;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if (!IgnoreBaseAccess) {
      $this().CheckBaseClassAccess(From.getExprLoc(), new QualType(FromClass), new QualType(ToClass), 
          Paths.front(), 
          diag.err_downcast_from_inaccessible_base);
    }
    
    // Must be a base to derived member conversion.
    $this().BuildBasePathArray(Paths, BasePath);
    Kind.$set(CastKind.CK_BaseToDerivedMemberPointer);
    return false;
  } finally {
    if (Paths != null) { Paths.$destroy(); }
  }
}


/// IsQualificationConversion - Determines whether the conversion from
/// an rvalue of type FromType to ToType is a qualification conversion
/// (C++ 4.4).
///
/// \param ObjCLifetimeConversion Output parameter that will be set to indicate
/// when the qualification conversion involves a change in the Objective-C
/// object lifetime.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsQualificationConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2928,
 FQN="clang::Sema::IsQualificationConversion", NM="_ZN5clang4Sema25IsQualificationConversionENS_8QualTypeES1_bRb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25IsQualificationConversionENS_8QualTypeES1_bRb")
//</editor-fold>
public final boolean IsQualificationConversion(QualType FromType, QualType ToType, 
                         boolean CStyle, final bool$ref/*bool &*/ ObjCLifetimeConversion) {
  FromType.$assignMove($this().Context.getCanonicalType(new QualType(FromType)).$QualType());
  ToType.$assignMove($this().Context.getCanonicalType(new QualType(ToType)).$QualType());
  ObjCLifetimeConversion.$set(false);
  
  // If FromType and ToType are the same type, this is not a
  // qualification conversion.
  if ($eq_QualType$C(FromType.getUnqualifiedType(), ToType.getUnqualifiedType())) {
    return false;
  }
  
  // (C++ 4.4p4):
  //   A conversion can add cv-qualifiers at levels other than the first
  //   in multi-level pointers, subject to the following rules: [...]
  boolean PreviousToQualsIncludeConst = true;
  boolean UnwrappedAnyPointer = false;
  while ($this().Context.UnwrapSimilarPointerTypes(FromType, ToType)) {
    // Within each iteration of the loop, we check the qualifiers to
    // determine if this still looks like a qualification
    // conversion. Then, if all is well, we unwrap one more level of
    // pointers or pointers-to-members and do it all again
    // until there are no more pointers or pointers-to-members left to
    // unwrap.
    UnwrappedAnyPointer = true;
    
    Qualifiers FromQuals = FromType.getQualifiers();
    Qualifiers ToQuals = ToType.getQualifiers();
    
    // Ignore __unaligned qualifier if this type is void.
    if (ToType.getUnqualifiedType().$arrow().isVoidType()) {
      FromQuals.removeUnaligned();
    }
    
    // Objective-C ARC:
    //   Check Objective-C lifetime conversions.
    if (FromQuals.getObjCLifetime() != ToQuals.getObjCLifetime()
       && UnwrappedAnyPointer) {
      if (ToQuals.compatiblyIncludesObjCLifetime(new Qualifiers(FromQuals))) {
        if (isNonTrivialObjCLifetimeConversion(new Qualifiers(FromQuals), new Qualifiers(ToQuals))) {
          ObjCLifetimeConversion.$set(true);
        }
        FromQuals.removeObjCLifetime();
        ToQuals.removeObjCLifetime();
      } else {
        // Qualification conversions cannot cast between different
        // Objective-C lifetime qualifiers.
        return false;
      }
    }
    
    // Allow addition/removal of GC attributes but not changing GC attributes.
    if (FromQuals.getObjCGCAttr() != ToQuals.getObjCGCAttr()
       && (!FromQuals.hasObjCGCAttr() || !ToQuals.hasObjCGCAttr())) {
      FromQuals.removeObjCGCAttr();
      ToQuals.removeObjCGCAttr();
    }
    
    //   -- for every j > 0, if const is in cv 1,j then const is in cv
    //      2,j, and similarly for volatile.
    if (!CStyle && !ToQuals.compatiblyIncludes(new Qualifiers(FromQuals))) {
      return false;
    }
    
    //   -- if the cv 1,j and cv 2,j are different, then const is in
    //      every cv for 0 < k < j.
    if (!CStyle && FromQuals.getCVRQualifiers() != ToQuals.getCVRQualifiers()
       && !PreviousToQualsIncludeConst) {
      return false;
    }
    
    // Keep track of whether all prior cv-qualifiers in the "to" type
    // include const.
    PreviousToQualsIncludeConst
       = PreviousToQualsIncludeConst && ToQuals.hasConst();
  }
  
  // We are left with FromType and ToType being the pointee types
  // after unwrapping the original FromType and ToType the same number
  // of types. If we unwrapped any pointers, and if FromType and
  // ToType have the same unqualified type (since we checked
  // qualifiers above), then this is a qualification conversion.
  return UnwrappedAnyPointer && $this().Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType));
}


/// \brief Determine whether the conversion from FromType to ToType is a valid
/// conversion that strips "noreturn" off the nested function type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsNoReturnConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1387,
 FQN="clang::Sema::IsNoReturnConversion", NM="_ZN5clang4Sema20IsNoReturnConversionENS_8QualTypeES1_RS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema20IsNoReturnConversionENS_8QualTypeES1_RS1_")
//</editor-fold>
public final boolean IsNoReturnConversion(QualType FromType, QualType ToType, 
                    final QualType /*&*/ ResultTy) {
  if ($this().Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType))) {
    return false;
  }
  
  // Permit the conversion F(t __attribute__((noreturn))) -> F(t)
  // where F adds one of the following at most once:
  //   - a pointer
  //   - a member pointer
  //   - a block pointer
  CanQual<Type> CanTo = $this().Context.getCanonicalType(new QualType(ToType));
  CanQual<Type> CanFrom = $this().Context.getCanonicalType(new QualType(FromType));
  Type.TypeClass TyClass = ((CanProxyType)CanTo.$arrow()).$arrow().getTypeClass();
  if (TyClass != ((CanProxyType)CanFrom.$arrow()).$arrow().getTypeClass()) {
    return false;
  }
  if (TyClass != Type.TypeClass.FunctionProto && TyClass != Type.TypeClass.FunctionNoProto) {
    if (TyClass == Type.TypeClass.Pointer) {
      CanTo.$assignMove(((CanProxyPointerType)CanTo.getAs(PointerType.class)).$arrow().getPointeeType());
      CanFrom.$assignMove(((CanProxyPointerType)CanFrom.getAs(PointerType.class)).$arrow().getPointeeType());
    } else if (TyClass == Type.TypeClass.BlockPointer) {
      CanTo.$assignMove(((CanProxyBlockPointerType)CanTo.getAs(BlockPointerType.class)).$arrow().getPointeeType());
      CanFrom.$assignMove(((CanProxyBlockPointerType)CanFrom.getAs(BlockPointerType.class)).$arrow().getPointeeType());
    } else if (TyClass == Type.TypeClass.MemberPointer) {
      CanTo.$assignMove(((CanProxyMemberPointerType)CanTo.getAs(MemberPointerType.class)).$arrow().getPointeeType());
      CanFrom.$assignMove(((CanProxyMemberPointerType)CanFrom.getAs(MemberPointerType.class)).$arrow().getPointeeType());
    } else {
      return false;
    }
    
    TyClass = ((CanProxyType)CanTo.$arrow()).$arrow().getTypeClass();
    if (TyClass != ((CanProxyType)CanFrom.$arrow()).$arrow().getTypeClass()) {
      return false;
    }
    if (TyClass != Type.TypeClass.FunctionProto && TyClass != Type.TypeClass.FunctionNoProto) {
      return false;
    }
  }
  
  /*const*/ FunctionType /*P*/ FromFn = cast_FunctionType(CanFrom);
  FunctionType.ExtInfo EInfo = FromFn.getExtInfo();
  if (!EInfo.getNoReturn()) {
    return false;
  }
  
  FromFn = $this().Context.adjustFunctionType(FromFn, EInfo.withNoReturn(false));
  assert (new QualType(FromFn, 0).isCanonical());
  if ($noteq_QualType$C(new QualType(FromFn, 0), CanTo.$QualType())) {
    return false;
  }
  
  ResultTy.$assign(ToType);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::DiagnoseMultipleUserDefinedConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3326,
 FQN="clang::Sema::DiagnoseMultipleUserDefinedConversion", NM="_ZN5clang4Sema37DiagnoseMultipleUserDefinedConversionEPNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema37DiagnoseMultipleUserDefinedConversionEPNS_4ExprENS_8QualTypeE")
//</editor-fold>
public final boolean DiagnoseMultipleUserDefinedConversion(Expr /*P*/ From, QualType ToType) {
  ImplicitConversionSequence ICS = null;
  OverloadCandidateSet CandidateSet = null;
  try {
    ICS/*J*/= new ImplicitConversionSequence();
    CandidateSet/*J*/= new OverloadCandidateSet(From.getExprLoc(), 
        OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    OverloadingResult OvResult = IsUserDefinedConversion(/*Deref*/$this(), From, new QualType(ToType), ICS.Unnamed_field2.UserDefined, 
        CandidateSet, false, false);
    if (OvResult == OverloadingResult.OR_Ambiguous) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getLocStart(), diag.err_typecheck_ambiguous_condition)), 
                    From.getType()), ToType), From.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else if (OvResult == OverloadingResult.OR_No_Viable_Function && !CandidateSet.empty()) {
      if (!$this().RequireCompleteType$T(From.getLocStart(), new QualType(ToType), 
          diag.err_typecheck_nonviable_condition_incomplete, 
          From.getType(), From.getSourceRange())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getLocStart(), diag.err_typecheck_nonviable_condition)), 
                          false), From.getType()), From.getSourceRange()), ToType));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      return false;
    }
    CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(From, true));
    return true;
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// PerformObjectArgumentInitialization - Perform initialization of
/// the implicit object parameter for the given Method with the given
/// expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformObjectArgumentInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4972,
 FQN="clang::Sema::PerformObjectArgumentInitialization", NM="_ZN5clang4Sema35PerformObjectArgumentInitializationEPNS_4ExprEPNS_19NestedNameSpecifierEPNS_9NamedDeclEPNS_13CXXMethodDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema35PerformObjectArgumentInitializationEPNS_4ExprEPNS_19NestedNameSpecifierEPNS_9NamedDeclEPNS_13CXXMethodDeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformObjectArgumentInitialization(Expr /*P*/ From, 
                                   NestedNameSpecifier /*P*/ Qualifier, 
                                   NamedDecl /*P*/ FoundDecl, 
                                   CXXMethodDecl /*P*/ Method) {
  ImplicitConversionSequence ICS = null;
  try {
    QualType FromRecordType/*J*/= new QualType();
    QualType DestType/*J*/= new QualType();
    QualType ImplicitParamRecordType = Method.getThisType($this().Context).$arrow().getAs(PointerType.class).getPointeeType();
    
    Expr.Classification FromClassification/*J*/= new Expr.Classification();
    {
      /*const*/ PointerType /*P*/ PT = From.getType().$arrow().getAs(PointerType.class);
      if ((PT != null)) {
        FromRecordType.$assignMove(PT.getPointeeType());
        DestType.$assignMove(Method.getThisType($this().Context));
        FromClassification.$assignMove(Expr.Classification.makeSimpleLValue());
      } else {
        FromRecordType.$assignMove(From.getType());
        DestType.$assign(ImplicitParamRecordType);
        FromClassification.$assignMove(From.Classify($this().Context));
      }
    }
    
    // Note that we always use the true parent context when performing
    // the actual argument initialization.
    ICS = TryObjectArgumentInitialization(/*Deref*/$this(), From.getLocStart(), From.getType(), new Expr.Classification(FromClassification), Method, 
        Method.getParent());
    if (ICS.isBad()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (ICS.Unnamed_field2.Bad.Kind == BadConversionSequence.FailureKind.bad_qualifiers) {
          Qualifiers FromQs = FromRecordType.getQualifiers();
          Qualifiers ToQs = DestType.getQualifiers();
          /*uint*/int CVR = FromQs.getCVRQualifiers() & ~ToQs.getCVRQualifiers();
          if ((CVR != 0)) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getLocStart(), 
                                diag.err_member_function_call_bad_cvr)), 
                            Method.getDeclName()), FromRecordType), (CVR - 1)), 
                From.getSourceRange()));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), diag.note_previous_decl)), 
                Method.getDeclName()));
            return ExprError();
          }
        }
        
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getLocStart(), 
                            diag.err_implicit_object_parameter_init)), 
                        ImplicitParamRecordType), FromRecordType), From.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    if (ICS.Unnamed_field2.Standard.Second == ImplicitConversionKind.ICK_Derived_To_Base) {
      ActionResultTTrue<Expr /*P*/ > FromRes = $this().PerformObjectMemberConversion(From, Qualifier, FoundDecl, Method);
      if (FromRes.isInvalid()) {
        return ExprError();
      }
      From = FromRes.get();
    }
    if (!$this().Context.hasSameType(From.getType(), new QualType(DestType))) {
      From = $this().ImpCastExprToType(From, new QualType(DestType), CastKind.CK_NoOp, 
          From.getValueKind()).get();
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// PerformContextuallyConvertToBool - Perform a contextual conversion
/// of the expression From to bool (C++0x [conv]p3).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformContextuallyConvertToBool">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5047,
 FQN="clang::Sema::PerformContextuallyConvertToBool", NM="_ZN5clang4Sema32PerformContextuallyConvertToBoolEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema32PerformContextuallyConvertToBoolEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformContextuallyConvertToBool(Expr /*P*/ From) {
  ImplicitConversionSequence ICS = null;
  try {
    if (checkPlaceholderForOverload(/*Deref*/$this(), create_type$ref(From))) {
      return ExprError();
    }
    
    ICS = TryContextuallyConvertToBool(/*Deref*/$this(), From);
    if (!ICS.isBad()) {
      return $this().PerformImplicitConversion(From, $this().Context.BoolTy.$QualType(), ICS, AssignmentAction.AA_Converting);
    }
    if (!$this().DiagnoseMultipleUserDefinedConversion(From, $this().Context.BoolTy.$QualType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(From.getLocStart(), 
                        diag.err_typecheck_bool_condition)), 
                    From.getType()), From.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    return ExprError();
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// PerformContextuallyConvertToObjCPointer - Perform a contextual
/// conversion of the expression From to an Objective-C pointer type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformContextuallyConvertToObjCPointer">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5313,
 FQN="clang::Sema::PerformContextuallyConvertToObjCPointer", NM="_ZN5clang4Sema39PerformContextuallyConvertToObjCPointerEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema39PerformContextuallyConvertToObjCPointerEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformContextuallyConvertToObjCPointer(Expr /*P*/ From) {
  ImplicitConversionSequence ICS = null;
  try {
    if (checkPlaceholderForOverload(/*Deref*/$this(), create_type$ref(From))) {
      return ExprError();
    }
    
    QualType Ty = $this().Context.getObjCIdType();
    ICS = TryContextuallyConvertToObjCPointer(/*Deref*/$this(), From);
    if (!ICS.isBad()) {
      return $this().PerformImplicitConversion(From, new QualType(Ty), ICS, AssignmentAction.AA_Converting);
    }
    return ExprError();
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConvertedConstantExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5252,
 FQN="clang::Sema::CheckConvertedConstantExpression", NM="_ZN5clang4Sema32CheckConvertedConstantExpressionEPNS_4ExprENS_8QualTypeERN4llvm6APSIntENS0_7CCEKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema32CheckConvertedConstantExpressionEPNS_4ExprENS_8QualTypeERN4llvm6APSIntENS0_7CCEKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckConvertedConstantExpression(Expr /*P*/ From, QualType T, 
                                final APSInt /*&*/ Value, 
                                CCEKind CCE) {
  APValue V = null;
  try {
    assert (T.$arrow().isIntegralOrEnumerationType()) : "unexpected converted const type";
    
    V/*J*/= new APValue();
    ActionResultTTrue<Expr /*P*/ > R = SemaOverloadStatics./*::*/CheckConvertedConstantExpression(/*Deref*/$this(),From, new QualType(T), V, CCE, true);
    if (!R.isInvalid()) {
      Value.$assign(V.getInt());
    }
    return R;
  } finally {
    if (V != null) { V.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConvertedConstantExpression">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5247,
 FQN="clang::Sema::CheckConvertedConstantExpression", NM="_ZN5clang4Sema32CheckConvertedConstantExpressionEPNS_4ExprENS_8QualTypeERNS_7APValueENS0_7CCEKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema32CheckConvertedConstantExpressionEPNS_4ExprENS_8QualTypeERNS_7APValueENS0_7CCEKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckConvertedConstantExpression(Expr /*P*/ From, QualType T, 
                                final APValue /*&*/ Value, CCEKind CCE) {
  return SemaOverloadStatics./*::*/CheckConvertedConstantExpression(/*Deref*/$this(), From, new QualType(T), Value, CCE, false);
}


/// Perform a contextual implicit conversion.

/// \brief Attempt to convert the given expression to a type which is accepted
/// by the given converter.
///
/// This routine will attempt to convert an expression of class type to a
/// type accepted by the specified converter. In C++11 and before, the class
/// must have a single non-explicit conversion function converting to a matching
/// type. In C++1y, there can be multiple such conversion functions, but only
/// one target type.
///
/// \param Loc The source location of the construct that requires the
/// conversion.
///
/// \param From The expression we're converting from.
///
/// \param Converter Used to control and diagnose the conversion process.
///
/// \returns The expression, converted to an integral or enumeration type if
/// successful.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformContextualImplicitConversion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5476,
 FQN="clang::Sema::PerformContextualImplicitConversion", NM="_ZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformContextualImplicitConversion(SourceLocation Loc, Expr /*P*/ _From, final ContextualImplicitConverter /*&*/ Converter) {
  // We must have a complete class type.
  //<editor-fold defaultstate="collapsed" desc="TypeDiagnoserPartialDiag">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5507,
   FQN="TypeDiagnoserPartialDiag", NM="_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEE24TypeDiagnoserPartialDiag",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEE24TypeDiagnoserPartialDiag")
  //</editor-fold>
   class/*struct*/ TypeDiagnoserPartialDiag extends /**/ TypeDiagnoser implements Destructors.ClassWithDestructor {
    public final ContextualImplicitConverter /*&*/ Converter;
    public Expr /*P*/ From;

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformContextualImplicitConversion(SourceLocation, Expr * , ContextualImplicitConverter & )::TypeDiagnoserPartialDiag::TypeDiagnoserPartialDiag">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5511,
     FQN="clang::Sema::PerformContextualImplicitConversion(SourceLocation, Expr * , ContextualImplicitConverter & )::TypeDiagnoserPartialDiag::TypeDiagnoserPartialDiag", NM="_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEEN24TypeDiagnoserPartialDiagC1ES5_S3_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEEN24TypeDiagnoserPartialDiagC1ES5_S3_")
    //</editor-fold>
    public TypeDiagnoserPartialDiag(final ContextualImplicitConverter /*&*/ Converter, Expr /*P*/ From) {
      // : TypeDiagnoser(), Converter(Converter), From(From) 
      //START JInit
      super();
      this./*&*/Converter=/*&*/Converter;
      this.From = From;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformContextualImplicitConversion(SourceLocation, Expr * , ContextualImplicitConverter & )::TypeDiagnoserPartialDiag::diagnose">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5514,
     FQN="clang::Sema::PerformContextualImplicitConversion(SourceLocation, Expr * , ContextualImplicitConverter & )::TypeDiagnoserPartialDiag::diagnose", NM="_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEEN24TypeDiagnoserPartialDiag8diagnoseERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEEN24TypeDiagnoserPartialDiag8diagnoseERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public void diagnose(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Converter.diagnoseIncomplete(S, new SourceLocation(Loc), new QualType(T))), From.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformContextualImplicitConversion(SourceLocation, Expr * , ContextualImplicitConverter & )::TypeDiagnoserPartialDiag::~TypeDiagnoserPartialDiag">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5507,
     FQN="clang::Sema::PerformContextualImplicitConversion(SourceLocation, Expr * , ContextualImplicitConverter & )::TypeDiagnoserPartialDiag::~TypeDiagnoserPartialDiag", NM="_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEEN24TypeDiagnoserPartialDiagD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZZN5clang4Sema35PerformContextualImplicitConversionENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterEEN24TypeDiagnoserPartialDiagD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    @Override public String toString() {
      return "" + "Converter=" + Converter // NOI18N
                + ", From=" + From // NOI18N
                + super.toString(); // NOI18N
    }
  }
  type$ptr<Expr /*P*/> From = create_type$ptr(_From);
  TypeDiagnoserPartialDiag IncompleteDiagnoser = null;
  try {
    // We can't perform any more checking for type-dependent expressions.
    if (From.$star().isTypeDependent()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From.$star());
    }
    
    // Process placeholders immediately.
    if (From.$star().hasPlaceholderType()) {
      ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(From.$star());
      if (result.isInvalid()) {
        return result;
      }
      From.$set(result.get());
    }
    
    // If the expression already has a matching type, we're golden.
    QualType T = From.$star().getType();
    if (Converter.match(/*NO_COPY*/T)) {
      return $this().DefaultLvalueConversion(From.$star());
    }
    
    // FIXME: Check for missing '()' if T is a function type?
    
    // We can only perform contextual implicit conversions on objects of class
    // type.
    /*const*/ RecordType /*P*/ RecordTy = T.$arrow().getAs$RecordType();
    if (!(RecordTy != null) || !$this().getLangOpts().CPlusPlus) {
      if (!Converter.Suppress) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Converter.diagnoseNoMatch(/*Deref*/$this(), new SourceLocation(Loc), new QualType(T))), From.$star().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From.$star());
    }
    
    IncompleteDiagnoser/*J*/= new  TypeDiagnoserPartialDiag(Converter, From.$star());
    if (Converter.Suppress ? !$this().isCompleteType(new SourceLocation(Loc), new QualType(T)) : $this().RequireCompleteType(new SourceLocation(Loc), new QualType(T), IncompleteDiagnoser)) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From.$star());
    }
    
    // Look for a conversion to an integral or enumeration type.
    UnresolvedSet ViableConversions/*J*/= new UnresolvedSet(4); // These are *potentially* viable in C++1y.
    UnresolvedSet ExplicitConversions/*J*/= new UnresolvedSet(4);
    final /*const*/ iterator_range<NamedDecl /*P*/ > /*&*/ Conversions = cast_CXXRecordDecl(RecordTy.getDecl()).getVisibleConversionFunctions();
    
    boolean HadMultipleCandidates = std.distance(Conversions.begin(), Conversions.end()) > 1;//(std.distance(((UnresolvedSetIterator)Conversions.begin()), ((UnresolvedSetIterator)Conversions.end())).$greater(1));
    
    // To check that there is only one target type, in C++1y:
    QualType ToType/*J*/= new QualType();
    boolean HasUniqueTargetType = true;
    
    // Collect explicit or viable (potentially in C++1y) conversions.
    for (UnresolvedSetIterator I = ((UnresolvedSetIterator)Conversions.begin()), E = ((UnresolvedSetIterator)Conversions.end()); I.$noteq(E); I.$preInc()) {
      NamedDecl /*P*/ D = (I.$star()).getUnderlyingDecl();
      CXXConversionDecl /*P*/ Conversion;
      FunctionTemplateDecl /*P*/ ConvTemplate = dyn_cast_FunctionTemplateDecl(D);
      if ((ConvTemplate != null)) {
        if ($this().getLangOpts().CPlusPlus14) {
          Conversion = cast_CXXConversionDecl(ConvTemplate.getTemplatedDecl());
        } else {
          continue; // C++11 does not consider conversion operator templates(?).
        }
      } else {
        Conversion = cast_CXXConversionDecl(D);
      }
      assert ((!(ConvTemplate != null) || $this().getLangOpts().CPlusPlus14)) : "Conversion operator templates are considered potentially viable in C++1y";
      
      QualType CurToType = Conversion.getConversionType().getNonReferenceType();
      if (Converter.match(/*NO_COPY*/CurToType) || (ConvTemplate != null)) {
        if (Conversion.isExplicit()) {
          // FIXME: For C++1y, do we need this restriction?
          // cf. diagnoseNoViableConversion()
          if (!(ConvTemplate != null)) {
            ExplicitConversions.addDecl(I.getDecl(), I.getAccess());
          }
        } else {
          if (!(ConvTemplate != null) && $this().getLangOpts().CPlusPlus14) {
            if (ToType.isNull()) {
              ToType.$assignMove(CurToType.getUnqualifiedType());
            } else if (HasUniqueTargetType
               && ($noteq_QualType$C(CurToType.getUnqualifiedType(), ToType))) {
              HasUniqueTargetType = false;
            }
          }
          ViableConversions.addDecl(I.getDecl(), I.getAccess());
        }
      }
    }
    if ($this().getLangOpts().CPlusPlus14) {
      OverloadCandidateSet CandidateSet = null;
      try {
        // C++1y [conv]p6:
        // ... An expression e of class type E appearing in such a context
        // is said to be contextually implicitly converted to a specified
        // type T and is well-formed if and only if e can be implicitly
        // converted to a type T that is determined as follows: E is searched
        // for conversion functions whose return type is cv T or reference to
        // cv T such that T is allowed by the context. There shall be
        // exactly one such T.
        
        // If no unique T is found:
        if (ToType.isNull()) {
          if (diagnoseNoViableConversion(/*Deref*/$this(), new SourceLocation(Loc), From, Converter, new QualType(T), 
              HadMultipleCandidates, 
              ExplicitConversions)) {
            return ExprError();
          }
          return finishContextualImplicitConversion(/*Deref*/$this(), new SourceLocation(Loc), From.$star(), Converter);
        }
        
        // If more than one unique Ts are found:
        if (!HasUniqueTargetType) {
          return diagnoseAmbiguousConversion(/*Deref*/$this(), new SourceLocation(Loc), From.$star(), Converter, new QualType(T), 
              ViableConversions);
        }
        
        // If one unique T is found:
        // First, build a candidate set from the previously recorded
        // potentially viable conversions.
        CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(Loc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
        collectViableConversionCandidates(/*Deref*/$this(), From.$star(), new QualType(ToType), ViableConversions, 
            CandidateSet);
        
        // Then, perform overload resolution over the candidate set.
        type$ptr<OverloadCandidate> Best = create_type$ptr();
        switch (CandidateSet.BestViableFunction(/*Deref*/$this(), new SourceLocation(Loc), Best)) {
         case OR_Success:
          {
            // Apply this conversion.
            DeclAccessPair Found = DeclAccessPair.make(Best./*->*/$star().Function, Best./*->*/$star().FoundDecl.getAccess());
            if (recordConversion(/*Deref*/$this(), new SourceLocation(Loc), From, Converter, new QualType(T), 
                HadMultipleCandidates, Found)) {
              return ExprError();
            }
            break;
          }
         case OR_Ambiguous:
          return diagnoseAmbiguousConversion(/*Deref*/$this(), new SourceLocation(Loc), From.$star(), Converter, new QualType(T), 
              ViableConversions);
         case OR_No_Viable_Function:
          if (diagnoseNoViableConversion(/*Deref*/$this(), new SourceLocation(Loc), From, Converter, new QualType(T), 
              HadMultipleCandidates, 
              ExplicitConversions)) {
            return ExprError();
          }
         case OR_Deleted:
          // We'll complain below about a non-integral condition type.
          break;
        }
      } finally {
        if (CandidateSet != null) { CandidateSet.$destroy(); }
      }
    } else {
      switch (ViableConversions.size()) {
       case 0:
        {
          if (diagnoseNoViableConversion(/*Deref*/$this(), new SourceLocation(Loc), From, Converter, new QualType(T), 
              HadMultipleCandidates, 
              ExplicitConversions)) {
            return ExprError();
          }
          
          // We'll complain below about a non-integral condition type.
          break;
        }
       case 1:
        {
          // Apply this conversion.
          DeclAccessPair Found = new DeclAccessPair(ViableConversions.$at(0));
          if (recordConversion(/*Deref*/$this(), new SourceLocation(Loc), From, Converter, new QualType(T), 
              HadMultipleCandidates, Found)) {
            return ExprError();
          }
          break;
        }
       default:
        return diagnoseAmbiguousConversion(/*Deref*/$this(), new SourceLocation(Loc), From.$star(), Converter, new QualType(T), 
            ViableConversions);
      }
    }
    
    return finishContextualImplicitConversion(/*Deref*/$this(), new SourceLocation(Loc), From.$star(), Converter);
  } finally {
    if (IncompleteDiagnoser != null) { IncompleteDiagnoser.$destroy(); }
  }
}


/// AddOverloadCandidate - Adds the given function to the set of
/// candidate functions, using the given function call arguments.  If
/// @p SuppressUserConversions, then don't allow user-defined
/// conversions via constructors or conversion operators.
///
/// \param PartialOverloading true if we are performing "partial" overloading
/// based on an incomplete set of function arguments. This feature is used by
/// code completion.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddOverloadCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5706,
 FQN="clang::Sema::AddOverloadCandidate", NM="_ZN5clang4Sema20AddOverloadCandidateEPNS_12FunctionDeclENS_14DeclAccessPairEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema20AddOverloadCandidateEPNS_12FunctionDeclENS_14DeclAccessPairEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbbb")
//</editor-fold>
public final void AddOverloadCandidate(FunctionDecl /*P*/ Function, 
                    DeclAccessPair FoundDecl, 
                    ArrayRef<Expr /*P*/ > Args, 
                    final OverloadCandidateSet /*&*/ CandidateSet) {
  AddOverloadCandidate(Function, 
                    FoundDecl, 
                    Args, 
                    CandidateSet, 
                    false, 
                    false, 
                    false);
}
public final void AddOverloadCandidate(FunctionDecl /*P*/ Function, 
                    DeclAccessPair FoundDecl, 
                    ArrayRef<Expr /*P*/ > Args, 
                    final OverloadCandidateSet /*&*/ CandidateSet, 
                    boolean SuppressUserConversions/*= false*/) {
  AddOverloadCandidate(Function, 
                    FoundDecl, 
                    Args, 
                    CandidateSet, 
                    SuppressUserConversions, 
                    false, 
                    false);
}
public final void AddOverloadCandidate(FunctionDecl /*P*/ Function, 
                    DeclAccessPair FoundDecl, 
                    ArrayRef<Expr /*P*/ > Args, 
                    final OverloadCandidateSet /*&*/ CandidateSet, 
                    boolean SuppressUserConversions/*= false*/, 
                    boolean PartialOverloading/*= false*/) {
  AddOverloadCandidate(Function, 
                    FoundDecl, 
                    Args, 
                    CandidateSet, 
                    SuppressUserConversions, 
                    PartialOverloading, 
                    false);
}
public final void AddOverloadCandidate(FunctionDecl /*P*/ Function, 
                    DeclAccessPair FoundDecl, 
                    ArrayRef<Expr /*P*/ > Args, 
                    final OverloadCandidateSet /*&*/ CandidateSet, 
                    boolean SuppressUserConversions/*= false*/, 
                    boolean PartialOverloading/*= false*/, 
                    boolean AllowExplicit/*= false*/) {
  EnterExpressionEvaluationContext Unevaluated = null;
  try {
    /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(Function.getType().$arrow().getAs(FunctionType.class));
    assert ((Proto != null)) : "Functions without a prototype cannot be overloaded";
    assert (!(Function.getDescribedFunctionTemplate() != null)) : "Use AddTemplateOverloadCandidate for function templates";
    {
      
      CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Function);
      if ((Method != null)) {
        if (!isa_CXXConstructorDecl(Method)) {
          // If we get here, it's because we're calling a member function
          // that is named without a member access expression (e.g.,
          // "this->f") that was either written explicitly or created
          // implicitly. This can happen with a qualified call to a member
          // function, e.g., X::f(). We use an empty type for the implied
          // object argument (C++ [over.call.func]p3), and the acting context
          // is irrelevant.
          $this().AddMethodCandidate(Method, new DeclAccessPair(FoundDecl), Method.getParent(), 
              new QualType(), Expr.Classification.makeSimpleLValue(), 
              new ArrayRef<Expr /*P*/ >(Args), CandidateSet, SuppressUserConversions, 
              PartialOverloading);
          return;
        }
        // We treat a constructor like a non-member function, since its object
        // argument doesn't participate in overload resolution.
      }
    }
    if (!CandidateSet.isNewCandidate(Function)) {
      return;
    }
    
    // C++ [over.match.oper]p3:
    //   if no operand has a class type, only those non-member functions in the
    //   lookup set that have a first parameter of type T1 or "reference to
    //   (possibly cv-qualified) T1", when T1 is an enumeration type, or (if there
    //   is a right operand) a second parameter of type T2 or "reference to
    //   (possibly cv-qualified) T2", when T2 is an enumeration type, are
    //   candidate functions.
    if (CandidateSet.getKind() == OverloadCandidateSet.CandidateSetKind.CSK_Operator
       && !IsAcceptableNonMemberOperatorCandidate($this().Context, Function, new ArrayRef<Expr /*P*/ >(Args))) {
      return;
    }
    
    // C++11 [class.copy]p11: [DR1402]
    //   A defaulted move constructor that is defined as deleted is ignored by
    //   overload resolution.
    CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(Function);
    if ((Constructor != null) && Constructor.isDefaulted() && Constructor.isDeleted()
       && Constructor.isMoveConstructor()) {
      return;
    }
    
    // Overload resolution is always an unevaluated context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    
    // Add this candidate
    final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate(Args.size());
    Candidate.FoundDecl.$assign(FoundDecl);
    Candidate.Function = Function;
    Candidate.Viable = true;
    Candidate.IsSurrogate = false;
    Candidate.IgnoreObjectArgument = false;
    Candidate.ExplicitCallArguments = Args.size();
    if ((Constructor != null)) {
      // C++ [class.copy]p3:
      //   A member function template is never instantiated to perform the copy
      //   of a class object to an object of its class type.
      QualType ClassType = $this().Context.getTypeDeclType(Constructor.getParent());
      if (Args.size() == 1 && Constructor.isSpecializationCopyingObject()
         && ($this().Context.hasSameUnqualifiedType(new QualType(ClassType), Args.$at(0).getType())
         || $this().IsDerivedFrom(Args.$at(0).getLocStart(), Args.$at(0).getType(), 
          new QualType(ClassType)))) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_illegal_constructor.getValue();
        return;
      }
    }
    
    /*uint*/int NumParams = Proto.getNumParams();
    
    // (C++ 13.3.2p2): A candidate function having fewer than m
    // parameters is viable only if it has an ellipsis in its parameter
    // list (8.3.5).
    if (TooManyArguments(NumParams, Args.size(), PartialOverloading)
       && !Proto.isVariadic()) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_too_many_arguments.getValue();
      return;
    }
    
    // (C++ 13.3.2p2): A candidate function having more than m parameters
    // is viable only if the (m+1)st parameter has a default argument
    // (8.3.6). For the purposes of overload resolution, the
    // parameter list is truncated on the right, so that there are
    // exactly m parameters.
    /*uint*/int MinRequiredArgs = Function.getMinRequiredArguments();
    if ($less_uint(Args.size(), MinRequiredArgs) && !PartialOverloading) {
      // Not enough arguments.
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_too_few_arguments.getValue();
      return;
    }
    
    // (CUDA B.1): Check for invalid calls between targets.
    if ($this().getLangOpts().CUDA) {
      {
        /*const*/ FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl($this().CurContext);
        if ((Caller != null)) {
          // Skip the check for callers that are implicit members, because in this
          // case we may not yet know what the member's target is; the target is
          // inferred for the member automatically, based on the bases and fields of
          // the class.
          if (!Caller.isImplicit() && $this().CheckCUDATarget(Caller, Function)) {
            Candidate.Viable = false;
            Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_target.getValue();
            return;
          }
        }
      }
    }
    
    // Determine the implicit conversion sequences for each of the
    // arguments.
    for (/*uint*/int ArgIdx = 0; $less_uint(ArgIdx, Args.size()); ++ArgIdx) {
      if ($less_uint(ArgIdx, NumParams)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // (C++ 13.3.2p3): for F to be a viable function, there shall
          // exist for each argument an implicit conversion sequence
          // (13.3.3.1) that converts that argument to the corresponding
          // parameter of F.
          QualType ParamType = Proto.getParamType(ArgIdx);
          $c$.clean(Candidate.Conversions[ArgIdx].$assign(
              $c$.track(TryCopyInitialization(/*Deref*/$this(), Args.$at(ArgIdx), new QualType(ParamType), 
                  SuppressUserConversions, 
                  /*InOverloadResolution=*/ true, 
                  /*AllowObjCWritebackConversion=*/
                  $this().getLangOpts().ObjCAutoRefCount, 
                  AllowExplicit))
          ));
          if (Candidate.Conversions[ArgIdx].isBad()) {
            Candidate.Viable = false;
            Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
            return;
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        // (C++ 13.3.2p2): For the purposes of overload resolution, any
        // argument for which there is no corresponding parameter is
        // considered to ""match the ellipsis" (C+ 13.3.3.1.3).
        Candidate.Conversions[ArgIdx].setEllipsis();
      }
    }
    {
      
      EnableIfAttr /*P*/ FailedAttr = $this().CheckEnableIf(Function, new ArrayRef<Expr /*P*/ >(Args));
      if ((FailedAttr != null)) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_enable_if.getValue();
        Candidate.Unnamed_field12.DeductionFailure.Data = FailedAttr;
        return;
      }
    }
  } finally {
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}


/// \brief Add all of the function declarations in the given function set to
/// the overload candidate set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddFunctionCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6045,
 FQN="clang::Sema::AddFunctionCandidates", NM="_ZN5clang4Sema21AddFunctionCandidatesERKNS_17UnresolvedSetImplEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEPNS_24TemplateArgumentListInfoEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema21AddFunctionCandidatesERKNS_17UnresolvedSetImplEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEPNS_24TemplateArgumentListInfoEbb")
//</editor-fold>
public final void AddFunctionCandidates(final /*const*/ UnresolvedSetImpl /*&*/ Fns, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet) {
  AddFunctionCandidates(Fns, 
                     Args, 
                     CandidateSet, 
                     (TemplateArgumentListInfo /*P*/ )null, 
                     false, 
                     false);
}
public final void AddFunctionCandidates(final /*const*/ UnresolvedSetImpl /*&*/ Fns, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet, 
                     TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs/*= null*/) {
  AddFunctionCandidates(Fns, 
                     Args, 
                     CandidateSet, 
                     ExplicitTemplateArgs, 
                     false, 
                     false);
}
public final void AddFunctionCandidates(final /*const*/ UnresolvedSetImpl /*&*/ Fns, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet, 
                     TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs/*= null*/, 
                     boolean SuppressUserConversions/*= false*/) {
  AddFunctionCandidates(Fns, 
                     Args, 
                     CandidateSet, 
                     ExplicitTemplateArgs, 
                     SuppressUserConversions, 
                     false);
}
public final void AddFunctionCandidates(final /*const*/ UnresolvedSetImpl /*&*/ Fns, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet, 
                     TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs/*= null*/, 
                     boolean SuppressUserConversions/*= false*/, 
                     boolean PartialOverloading/*= false*/) {
  for (UnresolvedSetIterator F = Fns.begin$Const(), E = Fns.end$Const(); F.$noteq(E); F.$preInc()) {
    NamedDecl /*P*/ D = F.getDecl().getUnderlyingDecl();
    {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(D);
      if ((FD != null)) {
        if (isa_CXXMethodDecl(FD) && !cast_CXXMethodDecl(FD).isStatic()) {
          $this().AddMethodCandidate(cast_CXXMethodDecl(FD), new DeclAccessPair(F.getPair()), 
              cast_CXXMethodDecl(FD).getParent(), 
              Args.$at(0).getType(), Args.$at(0).Classify($this().Context), 
              Args.slice(1), CandidateSet, 
              SuppressUserConversions, PartialOverloading);
        } else {
          $this().AddOverloadCandidate(FD, new DeclAccessPair(F.getPair()), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              SuppressUserConversions, PartialOverloading);
        }
      } else {
        FunctionTemplateDecl /*P*/ FunTmpl = cast_FunctionTemplateDecl(D);
        if (isa_CXXMethodDecl(FunTmpl.getTemplatedDecl())
           && !cast_CXXMethodDecl(FunTmpl.getTemplatedDecl()).isStatic()) {
          $this().AddMethodTemplateCandidate(FunTmpl, new DeclAccessPair(F.getPair()), 
              cast_CXXRecordDecl(FunTmpl.getDeclContext()), 
              ExplicitTemplateArgs, 
              Args.$at(0).getType(), 
              Args.$at(0).Classify($this().Context), Args.slice(1), 
              CandidateSet, SuppressUserConversions, 
              PartialOverloading);
        } else {
          $this().AddTemplateOverloadCandidate(FunTmpl, new DeclAccessPair(F.getPair()), 
              ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), 
              CandidateSet, SuppressUserConversions, 
              PartialOverloading);
        }
      }
    }
  }
}


/// AddMethodCandidate - Adds a named decl (which is some kind of
/// method) as a method candidate to the given overload set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddMethodCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6085,
 FQN="clang::Sema::AddMethodCandidate", NM="_ZN5clang4Sema18AddMethodCandidateENS_14DeclAccessPairENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS3_EERNS_20OverloadCandidateSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema18AddMethodCandidateENS_14DeclAccessPairENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS3_EERNS_20OverloadCandidateSetEb")
//</editor-fold>
public final void AddMethodCandidate(DeclAccessPair FoundDecl, 
                  QualType ObjectType, 
                  Expr.Classification ObjectClassification, 
                  ArrayRef<Expr /*P*/ > Args, 
                  final OverloadCandidateSet /*&*/ CandidateSet) {
  AddMethodCandidate(FoundDecl, 
                  ObjectType, 
                  ObjectClassification, 
                  Args, 
                  CandidateSet, 
                  false);
}
public final void AddMethodCandidate(DeclAccessPair FoundDecl, 
                  QualType ObjectType, 
                  Expr.Classification ObjectClassification, 
                  ArrayRef<Expr /*P*/ > Args, 
                  final OverloadCandidateSet /*&*/ CandidateSet, 
                  boolean SuppressUserConversions/*= false*/) {
  NamedDecl /*P*/ Decl = FoundDecl.getDecl();
  CXXRecordDecl /*P*/ ActingContext = cast_CXXRecordDecl(Decl.getDeclContext());
  if (isa_UsingShadowDecl(Decl)) {
    Decl = cast_UsingShadowDecl(Decl).getTargetDecl();
  }
  {
    
    FunctionTemplateDecl /*P*/ TD = dyn_cast_FunctionTemplateDecl(Decl);
    if ((TD != null)) {
      assert (isa_CXXMethodDecl(TD.getTemplatedDecl())) : "Expected a member function template";
      $this().AddMethodTemplateCandidate(TD, new DeclAccessPair(FoundDecl), ActingContext, 
          /*ExplicitArgs*/ (TemplateArgumentListInfo /*P*/ )null, 
          new QualType(ObjectType), new Expr.Classification(ObjectClassification), 
          new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
          SuppressUserConversions);
    } else {
      $this().AddMethodCandidate(cast_CXXMethodDecl(Decl), new DeclAccessPair(FoundDecl), ActingContext, 
          new QualType(ObjectType), new Expr.Classification(ObjectClassification), 
          new ArrayRef<Expr /*P*/ >(Args), 
          CandidateSet, SuppressUserConversions);
    }
  }
}


/// AddMethodCandidate - Adds the given C++ member function to the set
/// of candidate functions, using the given function call arguments
/// and the object argument (@c Object). For example, in a call
/// @c o.f(a1,a2), @c Object will contain @c o and @c Args will contain
/// both @c a1 and @c a2. If @p SuppressUserConversions, then don't
/// allow user-defined conversions via constructors or conversion
/// operators.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddMethodCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6120,
 FQN="clang::Sema::AddMethodCandidate", NM="_ZN5clang4Sema18AddMethodCandidateEPNS_13CXXMethodDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS7_EERNS_20OverloadCandidateSetEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema18AddMethodCandidateEPNS_13CXXMethodDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS7_EERNS_20OverloadCandidateSetEbb")
//</editor-fold>
public final void AddMethodCandidate(CXXMethodDecl /*P*/ Method, DeclAccessPair FoundDecl, 
                  CXXRecordDecl /*P*/ ActingContext, QualType ObjectType, 
                  Expr.Classification ObjectClassification, 
                  ArrayRef<Expr /*P*/ > Args, 
                  final OverloadCandidateSet /*&*/ CandidateSet) {
  AddMethodCandidate(Method, FoundDecl, 
                  ActingContext, ObjectType, 
                  ObjectClassification, 
                  Args, 
                  CandidateSet, 
                  false, 
                  false);
}
public final void AddMethodCandidate(CXXMethodDecl /*P*/ Method, DeclAccessPair FoundDecl, 
                  CXXRecordDecl /*P*/ ActingContext, QualType ObjectType, 
                  Expr.Classification ObjectClassification, 
                  ArrayRef<Expr /*P*/ > Args, 
                  final OverloadCandidateSet /*&*/ CandidateSet, 
                  boolean SuppressUserConversions/*= false*/) {
  AddMethodCandidate(Method, FoundDecl, 
                  ActingContext, ObjectType, 
                  ObjectClassification, 
                  Args, 
                  CandidateSet, 
                  SuppressUserConversions, 
                  false);
}
public final void AddMethodCandidate(CXXMethodDecl /*P*/ Method, DeclAccessPair FoundDecl, 
                  CXXRecordDecl /*P*/ ActingContext, QualType ObjectType, 
                  Expr.Classification ObjectClassification, 
                  ArrayRef<Expr /*P*/ > Args, 
                  final OverloadCandidateSet /*&*/ CandidateSet, 
                  boolean SuppressUserConversions/*= false*/, 
                  boolean PartialOverloading/*= false*/) {
  EnterExpressionEvaluationContext Unevaluated = null;
  try {
    /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(Method.getType().$arrow().getAs(FunctionType.class));
    assert ((Proto != null)) : "Methods without a prototype cannot be overloaded";
    assert (!isa_CXXConstructorDecl(Method)) : "Use AddOverloadCandidate for constructors";
    if (!CandidateSet.isNewCandidate(Method)) {
      return;
    }
    
    // C++11 [class.copy]p23: [DR1402]
    //   A defaulted move assignment operator that is defined as deleted is
    //   ignored by overload resolution.
    if (Method.isDefaulted() && Method.isDeleted()
       && Method.isMoveAssignmentOperator()) {
      return;
    }
    
    // Overload resolution is always an unevaluated context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    
    // Add this candidate
    final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate(Args.size() + 1);
    Candidate.FoundDecl.$assign(FoundDecl);
    Candidate.Function = Method;
    Candidate.IsSurrogate = false;
    Candidate.IgnoreObjectArgument = false;
    Candidate.ExplicitCallArguments = Args.size();
    
    /*uint*/int NumParams = Proto.getNumParams();
    
    // (C++ 13.3.2p2): A candidate function having fewer than m
    // parameters is viable only if it has an ellipsis in its parameter
    // list (8.3.5).
    if (TooManyArguments(NumParams, Args.size(), PartialOverloading)
       && !Proto.isVariadic()) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_too_many_arguments.getValue();
      return;
    }
    
    // (C++ 13.3.2p2): A candidate function having more than m parameters
    // is viable only if the (m+1)st parameter has a default argument
    // (8.3.6). For the purposes of overload resolution, the
    // parameter list is truncated on the right, so that there are
    // exactly m parameters.
    /*uint*/int MinRequiredArgs = Method.getMinRequiredArguments();
    if ($less_uint(Args.size(), MinRequiredArgs) && !PartialOverloading) {
      // Not enough arguments.
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_too_few_arguments.getValue();
      return;
    }
    
    Candidate.Viable = true;
    if (Method.isStatic() || ObjectType.isNull()) {
      // The implicit object argument is ignored.
      Candidate.IgnoreObjectArgument = true;
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Determine the implicit conversion sequence for the object
        // parameter.
        $c$.clean(Candidate.Conversions[0].$assign($c$.track(TryObjectArgumentInitialization(/*Deref*/$this(), CandidateSet.getLocation(), new QualType(ObjectType), new Expr.Classification(ObjectClassification), 
                Method, ActingContext))));
        if (Candidate.Conversions[0].isBad()) {
          Candidate.Viable = false;
          Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
          return;
        }
      } finally {
        $c$.$destroy();
      }
    }
    
    // (CUDA B.1): Check for invalid calls between targets.
    if ($this().getLangOpts().CUDA) {
      {
        /*const*/ FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl($this().CurContext);
        if ((Caller != null)) {
          if ($this().CheckCUDATarget(Caller, Method)) {
            Candidate.Viable = false;
            Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_target.getValue();
            return;
          }
        }
      }
    }
    
    // Determine the implicit conversion sequences for each of the
    // arguments.
    for (/*uint*/int ArgIdx = 0; $less_uint(ArgIdx, Args.size()); ++ArgIdx) {
      if ($less_uint(ArgIdx, NumParams)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // (C++ 13.3.2p3): for F to be a viable function, there shall
          // exist for each argument an implicit conversion sequence
          // (13.3.3.1) that converts that argument to the corresponding
          // parameter of F.
          QualType ParamType = Proto.getParamType(ArgIdx);
          $c$.clean(Candidate.Conversions[ArgIdx + 1].$assign(
              $c$.track(TryCopyInitialization(/*Deref*/$this(), Args.$at(ArgIdx), new QualType(ParamType), 
                  SuppressUserConversions, 
                  /*InOverloadResolution=*/ true, 
                  /*AllowObjCWritebackConversion=*/
                  $this().getLangOpts().ObjCAutoRefCount))
          ));
          if (Candidate.Conversions[ArgIdx + 1].isBad()) {
            Candidate.Viable = false;
            Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
            return;
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        // (C++ 13.3.2p2): For the purposes of overload resolution, any
        // argument for which there is no corresponding parameter is
        // considered to "match the ellipsis" (C+ 13.3.3.1.3).
        Candidate.Conversions[ArgIdx + 1].setEllipsis();
      }
    }
    {
      
      EnableIfAttr /*P*/ FailedAttr = $this().CheckEnableIf(Method, new ArrayRef<Expr /*P*/ >(Args), true);
      if ((FailedAttr != null)) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_enable_if.getValue();
        Candidate.Unnamed_field12.DeductionFailure.Data = FailedAttr;
        return;
      }
    }
  } finally {
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}


/// \brief Add a C++ member function template as a candidate to the candidate
/// set, using template argument deduction to produce an appropriate member
/// function template specialization.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddMethodTemplateCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6246,
 FQN="clang::Sema::AddMethodTemplateCandidate", NM="_ZN5clang4Sema26AddMethodTemplateCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_24TemplateArgumentListInfoENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS9_EERNS_20OverloadCandidateSetEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema26AddMethodTemplateCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_24TemplateArgumentListInfoENS_8QualTypeENS_4Expr14ClassificationEN4llvm8ArrayRefIPS9_EERNS_20OverloadCandidateSetEbb")
//</editor-fold>
public final void AddMethodTemplateCandidate(FunctionTemplateDecl /*P*/ MethodTmpl, 
                          DeclAccessPair FoundDecl, 
                          CXXRecordDecl /*P*/ ActingContext, 
                          TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                          QualType ObjectType, 
                          Expr.Classification ObjectClassification, 
                          ArrayRef<Expr /*P*/ > Args, 
                          final OverloadCandidateSet /*&*/ CandidateSet) {
  AddMethodTemplateCandidate(MethodTmpl, 
                          FoundDecl, 
                          ActingContext, 
                          ExplicitTemplateArgs, 
                          ObjectType, 
                          ObjectClassification, 
                          Args, 
                          CandidateSet, 
                          false, 
                          false);
}
public final void AddMethodTemplateCandidate(FunctionTemplateDecl /*P*/ MethodTmpl, 
                          DeclAccessPair FoundDecl, 
                          CXXRecordDecl /*P*/ ActingContext, 
                          TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                          QualType ObjectType, 
                          Expr.Classification ObjectClassification, 
                          ArrayRef<Expr /*P*/ > Args, 
                          final OverloadCandidateSet /*&*/ CandidateSet, 
                          boolean SuppressUserConversions/*= false*/) {
  AddMethodTemplateCandidate(MethodTmpl, 
                          FoundDecl, 
                          ActingContext, 
                          ExplicitTemplateArgs, 
                          ObjectType, 
                          ObjectClassification, 
                          Args, 
                          CandidateSet, 
                          SuppressUserConversions, 
                          false);
}
public final void AddMethodTemplateCandidate(FunctionTemplateDecl /*P*/ MethodTmpl, 
                          DeclAccessPair FoundDecl, 
                          CXXRecordDecl /*P*/ ActingContext, 
                          TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                          QualType ObjectType, 
                          Expr.Classification ObjectClassification, 
                          ArrayRef<Expr /*P*/ > Args, 
                          final OverloadCandidateSet /*&*/ CandidateSet, 
                          boolean SuppressUserConversions/*= false*/, 
                          boolean PartialOverloading/*= false*/) {
  TemplateDeductionInfo Info = null;
  try {
    if (!CandidateSet.isNewCandidate(MethodTmpl)) {
      return;
    }
    
    // C++ [over.match.funcs]p7:
    //   In each case where a candidate is a function template, candidate
    //   function template specializations are generated using template argument
    //   deduction (14.8.3, 14.8.2). Those candidates are then handled as
    //   candidate functions in the usual way.113) A given name can refer to one
    //   or more function templates and also to a set of overloaded non-template
    //   functions. In such a case, the candidate functions generated from each
    //   function template are combined with the set of non-template candidate
    //   functions.
    Info/*J*/= new TemplateDeductionInfo(CandidateSet.getLocation());
    type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
    {
      TemplateDeductionResult Result = $this().DeduceTemplateArguments(MethodTmpl, ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), 
          Specialization, Info, PartialOverloading);
      if ((Result.getValue() != 0)) {
        final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate();
        Candidate.FoundDecl.$assign(FoundDecl);
        Candidate.Function = MethodTmpl.getTemplatedDecl();
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_deduction.getValue();
        Candidate.IsSurrogate = false;
        Candidate.IgnoreObjectArgument = false;
        Candidate.ExplicitCallArguments = Args.size();
        Candidate.Unnamed_field12.DeductionFailure.$assignMove(MakeDeductionFailureInfo($this().Context, Result, 
                Info));
        return;
      }
    }
    
    // Add the function template specialization produced by template argument
    // deduction as a candidate.
    assert ((Specialization.$deref() != null)) : "Missing member function template specialization?";
    assert (isa_CXXMethodDecl(Specialization)) : "Specialization is not a member function?";
    $this().AddMethodCandidate(cast_CXXMethodDecl(Specialization.$deref()), new DeclAccessPair(FoundDecl), 
        ActingContext, new QualType(ObjectType), new Expr.Classification(ObjectClassification), new ArrayRef<Expr /*P*/ >(Args), 
        CandidateSet, SuppressUserConversions, PartialOverloading);
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// \brief Add a C++ function template specialization as a candidate
/// in the candidate set, using template argument deduction to produce
/// an appropriate function template specialization.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddTemplateOverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6300,
 FQN="clang::Sema::AddTemplateOverloadCandidate", NM="_ZN5clang4Sema28AddTemplateOverloadCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema28AddTemplateOverloadCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbb")
//</editor-fold>
public final void AddTemplateOverloadCandidate(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                            DeclAccessPair FoundDecl, 
                            TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                            ArrayRef<Expr /*P*/ > Args, 
                            final OverloadCandidateSet /*&*/ CandidateSet) {
  AddTemplateOverloadCandidate(FunctionTemplate, 
                            FoundDecl, 
                            ExplicitTemplateArgs, 
                            Args, 
                            CandidateSet, 
                            false, 
                            false);
}
public final void AddTemplateOverloadCandidate(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                            DeclAccessPair FoundDecl, 
                            TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                            ArrayRef<Expr /*P*/ > Args, 
                            final OverloadCandidateSet /*&*/ CandidateSet, 
                            boolean SuppressUserConversions/*= false*/) {
  AddTemplateOverloadCandidate(FunctionTemplate, 
                            FoundDecl, 
                            ExplicitTemplateArgs, 
                            Args, 
                            CandidateSet, 
                            SuppressUserConversions, 
                            false);
}
public final void AddTemplateOverloadCandidate(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                            DeclAccessPair FoundDecl, 
                            TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                            ArrayRef<Expr /*P*/ > Args, 
                            final OverloadCandidateSet /*&*/ CandidateSet, 
                            boolean SuppressUserConversions/*= false*/, 
                            boolean PartialOverloading/*= false*/) {
  TemplateDeductionInfo Info = null;
  try {
    if (!CandidateSet.isNewCandidate(FunctionTemplate)) {
      return;
    }
    
    // C++ [over.match.funcs]p7:
    //   In each case where a candidate is a function template, candidate
    //   function template specializations are generated using template argument
    //   deduction (14.8.3, 14.8.2). Those candidates are then handled as
    //   candidate functions in the usual way.113) A given name can refer to one
    //   or more function templates and also to a set of overloaded non-template
    //   functions. In such a case, the candidate functions generated from each
    //   function template are combined with the set of non-template candidate
    //   functions.
    Info/*J*/= new TemplateDeductionInfo(CandidateSet.getLocation());
    type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
    {
      TemplateDeductionResult Result = $this().DeduceTemplateArguments(FunctionTemplate, ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), 
          Specialization, Info, PartialOverloading);
      if ((Result.getValue() != 0)) {
        final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate();
        Candidate.FoundDecl.$assign(FoundDecl);
        Candidate.Function = FunctionTemplate.getTemplatedDecl();
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_deduction.getValue();
        Candidate.IsSurrogate = false;
        Candidate.IgnoreObjectArgument = false;
        Candidate.ExplicitCallArguments = Args.size();
        Candidate.Unnamed_field12.DeductionFailure.$assignMove(MakeDeductionFailureInfo($this().Context, Result, 
                Info));
        return;
      }
    }
    
    // Add the function template specialization produced by template argument
    // deduction as a candidate.
    assert ((Specialization.$deref() != null)) : "Missing function template specialization?";
    $this().AddOverloadCandidate(Specialization.$deref(), new DeclAccessPair(FoundDecl), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
        SuppressUserConversions, PartialOverloading);
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// AddConversionCandidate - Add a C++ conversion function as a
/// candidate in the candidate set (C++ [over.match.conv],
/// C++ [over.match.copy]). From is the expression we're converting from,
/// and ToType is the type that we're eventually trying to convert to
/// (which may or may not be the same type as the type that the
/// conversion function produces).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddConversionCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6390,
 FQN="clang::Sema::AddConversionCandidate", NM="_ZN5clang4Sema22AddConversionCandidateEPNS_17CXXConversionDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_4ExprENS_8QualTypeERNS_20OverloadCandidateSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema22AddConversionCandidateEPNS_17CXXConversionDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_4ExprENS_8QualTypeERNS_20OverloadCandidateSetEb")
//</editor-fold>
public final void AddConversionCandidate(CXXConversionDecl /*P*/ Conversion, 
                      DeclAccessPair FoundDecl, 
                      CXXRecordDecl /*P*/ ActingContext, 
                      Expr /*P*/ From, QualType ToType, 
                      final OverloadCandidateSet /*&*/ CandidateSet, 
                      boolean AllowObjCConversionOnExplicit) {
  EnterExpressionEvaluationContext Unevaluated = null;
  ImplicitConversionSequence ICS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (!(Conversion.getDescribedFunctionTemplate() != null)) : "Conversion function templates use AddTemplateConversionCandidate";
    QualType ConvType = Conversion.getConversionType().getNonReferenceType();
    if (!CandidateSet.isNewCandidate(Conversion)) {
      return;
    }
    
    // If the conversion function has an undeduced return type, trigger its
    // deduction now.
    if ($this().getLangOpts().CPlusPlus14 && ConvType.$arrow().isUndeducedType()) {
      if ($this().DeduceReturnType(Conversion, From.getExprLoc())) {
        return;
      }
      ConvType.$assignMove(Conversion.getConversionType().getNonReferenceType());
    }
    
    // Per C++ [over.match.conv]p1, [over.match.ref]p1, an explicit conversion
    // operator is only a candidate if its return type is the target type or
    // can be converted to the target type with a qualification conversion.
    if (Conversion.isExplicit()
       && !isAllowableExplicitConversion(/*Deref*/$this(), new QualType(ConvType), new QualType(ToType), 
        AllowObjCConversionOnExplicit)) {
      return;
    }
    
    // Overload resolution is always an unevaluated context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    
    // Add this candidate
    final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate(1);
    Candidate.FoundDecl.$assign(FoundDecl);
    Candidate.Function = Conversion;
    Candidate.IsSurrogate = false;
    Candidate.IgnoreObjectArgument = false;
    Candidate.Unnamed_field12.FinalConversion.setAsIdentityConversion();
    Candidate.Unnamed_field12.FinalConversion.setFromType(new QualType(ConvType));
    Candidate.Unnamed_field12.FinalConversion.setAllToTypes(new QualType(ToType));
    Candidate.Viable = true;
    Candidate.ExplicitCallArguments = 1;
    
    // C++ [over.match.funcs]p4:
    //   For conversion functions, the function is considered to be a member of
    //   the class of the implicit implied object argument for the purpose of
    //   defining the type of the implicit object parameter.
    //
    // Determine the implicit conversion sequence for the implicit
    // object parameter.
    QualType ImplicitParamType = From.getType();
    {
      /*const*/ PointerType /*P*/ FromPtrType = ImplicitParamType.$arrow().getAs(PointerType.class);
      if ((FromPtrType != null)) {
        ImplicitParamType.$assignMove(FromPtrType.getPointeeType());
      }
    }
    CXXRecordDecl /*P*/ ConversionContext = cast_CXXRecordDecl(ImplicitParamType.$arrow().getAs$RecordType().getDecl());
    
    $c$.clean(Candidate.Conversions[0].$assign($c$.track(TryObjectArgumentInitialization(/*Deref*/$this(), CandidateSet.getLocation(), From.getType(), 
            From.Classify($this().Context), Conversion, ConversionContext))));
    if (Candidate.Conversions[0].isBad()) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
      return;
    }
    
    // We won't go through a user-defined type conversion function to convert a
    // derived to base as such conversions are given Conversion Rank. They only
    // go through a copy constructor. 13.3.3.1.2-p4 [over.ics.user]
    QualType FromCanon = $this().Context.getCanonicalType(From.getType().getUnqualifiedType()).$QualType();
    QualType ToCanon = $this().Context.getCanonicalType(new QualType(ToType)).getUnqualifiedType().$QualType();
    if ($eq_QualType$C(FromCanon, ToCanon)
       || $this().IsDerivedFrom(CandidateSet.getLocation(), new QualType(FromCanon), new QualType(ToCanon))) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_trivial_conversion.getValue();
      return;
    }
    
    // To determine what the conversion from the result of calling the
    // conversion function to the type we're eventually trying to
    // convert to (ToType), we need to synthesize a call to the
    // conversion function and attempt copy initialization from it. This
    // makes sure that we get the right semantics with respect to
    // lvalues/rvalues and the type. Fortunately, we can allocate this
    // call on the stack and we don't need its arguments to be
    // well-formed.
    DeclRefExpr ConversionRef/*J*/= new DeclRefExpr(Conversion, false, Conversion.getType(), 
        ExprValueKind.VK_LValue, From.getLocStart());
    ImplicitCastExpr ConversionFn/*J*/= new ImplicitCastExpr(ImplicitCastExpr.OnStack_t.OnStack, 
        $this().Context.getPointerType(Conversion.getType()), 
        CastKind.CK_FunctionToPointerDecay, 
        $AddrOf(ConversionRef), ExprValueKind.VK_RValue);
    
    QualType ConversionType = Conversion.getConversionType();
    if (!$this().isCompleteType(From.getLocStart(), new QualType(ConversionType))) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_final_conversion.getValue();
      return;
    }
    
    ExprValueKind VK = Expr.getValueKindForType(new QualType(ConversionType));
    
    // Note that it is safe to allocate CallExpr on the stack here because
    // there are 0 arguments (i.e., nothing is allocated using ASTContext's
    // allocator).
    QualType CallResultType = ConversionType.getNonLValueExprType($this().Context);
    CallExpr Call/*J*/= new CallExpr($this().Context, $AddrOf(ConversionFn), new ArrayRef<Expr /*P*/ >(None, true), new QualType(CallResultType), VK, 
        From.getLocStart());
    ICS = TryCopyInitialization(/*Deref*/$this(), $AddrOf(Call), new QualType(ToType), 
        /*SuppressUserConversions=*/ true, 
        /*InOverloadResolution=*/ false, 
        /*AllowObjCWritebackConversion=*/ false);
    switch (ICS.getKind()) {
     case StandardConversion:
      Candidate.Unnamed_field12.FinalConversion.$assign(ICS.Unnamed_field2.Standard);
      
      // C++ [over.ics.user]p3:
      //   If the user-defined conversion is specified by a specialization of a
      //   conversion function template, the second standard conversion sequence
      //   shall have exact match rank.
      if ((Conversion.getPrimaryTemplate() != null)
         && GetConversionRank(ICS.Unnamed_field2.Standard.Second) != ImplicitConversionRank.ICR_Exact_Match) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_final_conversion_not_exact.getValue();
        return;
      }
      
      // C++0x [dcl.init.ref]p5:
      //    In the second case, if the reference is an rvalue reference and
      //    the second standard conversion sequence of the user-defined
      //    conversion sequence includes an lvalue-to-rvalue conversion, the
      //    program is ill-formed.
      if (ToType.$arrow().isRValueReferenceType()
         && ICS.Unnamed_field2.Standard.First == ImplicitConversionKind.ICK_Lvalue_To_Rvalue) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_final_conversion.getValue();
        return;
      }
      break;
     case BadConversion:
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_final_conversion.getValue();
      return;
     default:
      throw new llvm_unreachable("Can only end up with a standard conversion sequence or failure");
    }
    {
      
      EnableIfAttr /*P*/ FailedAttr = $this().CheckEnableIf(Conversion, new ArrayRef<Expr /*P*/ >(None, true));
      if ((FailedAttr != null)) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_enable_if.getValue();
        Candidate.Unnamed_field12.DeductionFailure.Data = FailedAttr;
        return;
      }
    }
  } finally {
    if (ICS != null) { ICS.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Adds a conversion function template specialization
/// candidate to the overload set, using template argument deduction
/// to deduce the template arguments of the conversion function
/// template from the type that we are converting to (C++
/// [temp.deduct.conv]).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddTemplateConversionCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6557,
 FQN="clang::Sema::AddTemplateConversionCandidate", NM="_ZN5clang4Sema30AddTemplateConversionCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_4ExprENS_8QualTypeERNS_20OverloadCandidateSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema30AddTemplateConversionCandidateEPNS_20FunctionTemplateDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPNS_4ExprENS_8QualTypeERNS_20OverloadCandidateSetEb")
//</editor-fold>
public final void AddTemplateConversionCandidate(FunctionTemplateDecl /*P*/ FunctionTemplate, 
                              DeclAccessPair FoundDecl, 
                              CXXRecordDecl /*P*/ ActingDC, 
                              Expr /*P*/ From, QualType ToType, 
                              final OverloadCandidateSet /*&*/ CandidateSet, 
                              boolean AllowObjCConversionOnExplicit) {
  TemplateDeductionInfo Info = null;
  try {
    assert (isa_CXXConversionDecl(FunctionTemplate.getTemplatedDecl())) : "Only conversion function templates permitted here";
    if (!CandidateSet.isNewCandidate(FunctionTemplate)) {
      return;
    }
    
    Info/*J*/= new TemplateDeductionInfo(CandidateSet.getLocation());
    type$ptr<CXXConversionDecl /*P*/ > Specialization = create_type$null$ptr(null);
    {
      TemplateDeductionResult Result = $this().DeduceTemplateArguments(FunctionTemplate, new QualType(ToType), 
          Specialization, Info);
      if ((Result.getValue() != 0)) {
        final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate();
        Candidate.FoundDecl.$assign(FoundDecl);
        Candidate.Function = FunctionTemplate.getTemplatedDecl();
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_deduction.getValue();
        Candidate.IsSurrogate = false;
        Candidate.IgnoreObjectArgument = false;
        Candidate.ExplicitCallArguments = 1;
        Candidate.Unnamed_field12.DeductionFailure.$assignMove(MakeDeductionFailureInfo($this().Context, Result, 
                Info));
        return;
      }
    }
    
    // Add the conversion function template specialization produced by
    // template argument deduction as a candidate.
    assert ((Specialization.$star() != null)) : "Missing function template specialization?";
    $this().AddConversionCandidate(Specialization.$star(), new DeclAccessPair(FoundDecl), ActingDC, From, new QualType(ToType), 
        CandidateSet, AllowObjCConversionOnExplicit);
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// AddSurrogateCandidate - Adds a "surrogate" candidate function that
/// converts the given @c Object to a function pointer via the
/// conversion function @c Conversion, and then attempts to call it
/// with the given arguments (C++ [over.call.object]p2-4). Proto is
/// the type of function that we'll eventually be calling.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddSurrogateCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6600,
 FQN="clang::Sema::AddSurrogateCandidate", NM="_ZN5clang4Sema21AddSurrogateCandidateEPNS_17CXXConversionDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPNS_4ExprEN4llvm8ArrayRefISA_EERNS_20OverloadCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema21AddSurrogateCandidateEPNS_17CXXConversionDeclENS_14DeclAccessPairEPNS_13CXXRecordDeclEPKNS_17FunctionProtoTypeEPNS_4ExprEN4llvm8ArrayRefISA_EERNS_20OverloadCandidateSetE")
//</editor-fold>
public final void AddSurrogateCandidate(CXXConversionDecl /*P*/ Conversion, 
                     DeclAccessPair FoundDecl, 
                     CXXRecordDecl /*P*/ ActingContext, 
                     /*const*/ FunctionProtoType /*P*/ Proto, 
                     Expr /*P*/ Object, 
                     ArrayRef<Expr /*P*/ > Args, 
                     final OverloadCandidateSet /*&*/ CandidateSet) {
  EnterExpressionEvaluationContext Unevaluated = null;
  ImplicitConversionSequence ObjectInit = null;
  try {
    if (!CandidateSet.isNewCandidate(Conversion)) {
      return;
    }
    
    // Overload resolution is always an unevaluated context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    
    final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate(Args.size() + 1);
    Candidate.FoundDecl.$assign(FoundDecl);
    Candidate.Function = null;
    Candidate.Surrogate = Conversion;
    Candidate.Viable = true;
    Candidate.IsSurrogate = true;
    Candidate.IgnoreObjectArgument = false;
    Candidate.ExplicitCallArguments = Args.size();
    
    // Determine the implicit conversion sequence for the implicit
    // object parameter.
    ObjectInit = TryObjectArgumentInitialization(/*Deref*/$this(), CandidateSet.getLocation(), Object.getType(), 
        Object.Classify($this().Context), Conversion, ActingContext);
    if (ObjectInit.isBad()) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
      Candidate.Conversions[0].$assign(ObjectInit);
      return;
    }
    
    // The first conversion is actually a user-defined conversion whose
    // first conversion is ObjectInit's standard conversion (which is
    // effectively a reference binding). Record it as such.
    Candidate.Conversions[0].setUserDefined();
    Candidate.Conversions[0].Unnamed_field2.UserDefined.Before.$assign(ObjectInit.Unnamed_field2.Standard);
    Candidate.Conversions[0].Unnamed_field2.UserDefined.EllipsisConversion = false;
    Candidate.Conversions[0].Unnamed_field2.UserDefined.HadMultipleCandidates = false;
    Candidate.Conversions[0].Unnamed_field2.UserDefined.ConversionFunction = Conversion;
    Candidate.Conversions[0].Unnamed_field2.UserDefined.FoundConversionFunction.$assign(FoundDecl);
    Candidate.Conversions[0].Unnamed_field2.UserDefined.After.$assign(
        Candidate.Conversions[0].Unnamed_field2.UserDefined.Before
    );
    Candidate.Conversions[0].Unnamed_field2.UserDefined.After.setAsIdentityConversion();
    
    // Find the
    /*uint*/int NumParams = Proto.getNumParams();
    
    // (C++ 13.3.2p2): A candidate function having fewer than m
    // parameters is viable only if it has an ellipsis in its parameter
    // list (8.3.5).
    if ($greater_uint(Args.size(), NumParams) && !Proto.isVariadic()) {
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_too_many_arguments.getValue();
      return;
    }
    
    // Function types don't have any default arguments, so just check if
    // we have enough arguments.
    if ($less_uint(Args.size(), NumParams)) {
      // Not enough arguments.
      Candidate.Viable = false;
      Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_too_few_arguments.getValue();
      return;
    }
    
    // Determine the implicit conversion sequences for each of the
    // arguments.
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      if ($less_uint(ArgIdx, NumParams)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // (C++ 13.3.2p3): for F to be a viable function, there shall
          // exist for each argument an implicit conversion sequence
          // (13.3.3.1) that converts that argument to the corresponding
          // parameter of F.
          QualType ParamType = Proto.getParamType(ArgIdx);
          $c$.clean(Candidate.Conversions[ArgIdx + 1].$assign(
              $c$.track(TryCopyInitialization(/*Deref*/$this(), Args.$at(ArgIdx), new QualType(ParamType), 
                  /*SuppressUserConversions=*/ false, 
                  /*InOverloadResolution=*/ false, 
                  /*AllowObjCWritebackConversion=*/
                  $this().getLangOpts().ObjCAutoRefCount))
          ));
          if (Candidate.Conversions[ArgIdx + 1].isBad()) {
            Candidate.Viable = false;
            Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
            return;
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        // (C++ 13.3.2p2): For the purposes of overload resolution, any
        // argument for which there is no corresponding parameter is
        // considered to ""match the ellipsis" (C+ 13.3.3.1.3).
        Candidate.Conversions[ArgIdx + 1].setEllipsis();
      }
    }
    {
      
      EnableIfAttr /*P*/ FailedAttr = $this().CheckEnableIf(Conversion, new ArrayRef<Expr /*P*/ >(None, true));
      if ((FailedAttr != null)) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_enable_if.getValue();
        Candidate.Unnamed_field12.DeductionFailure.Data = FailedAttr;
        return;
      }
    }
  } finally {
    if (ObjectInit != null) { ObjectInit.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}


/// \brief Add overload candidates for overloaded operators that are
/// member functions.
///
/// Add the overloaded operator candidates that are member functions
/// for the operator Op that was used in an operator expression such
/// as "x Op y". , Args/NumArgs provides the operator arguments, and
/// CandidateSet will store the added overload candidates. (C++
/// [over.match.oper]).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddMemberOperatorCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6712,
 FQN="clang::Sema::AddMemberOperatorCandidates", NM="_ZN5clang4Sema27AddMemberOperatorCandidatesENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema27AddMemberOperatorCandidatesENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetENS_11SourceRangeE")
//</editor-fold>
public final void AddMemberOperatorCandidates(OverloadedOperatorKind Op, 
                           SourceLocation OpLoc, 
                           ArrayRef<Expr /*P*/ > Args, 
                           final OverloadCandidateSet /*&*/ CandidateSet) {
  AddMemberOperatorCandidates(Op, 
                           OpLoc, 
                           Args, 
                           CandidateSet, 
                           new SourceRange());
}
public final void AddMemberOperatorCandidates(OverloadedOperatorKind Op, 
                           SourceLocation OpLoc, 
                           ArrayRef<Expr /*P*/ > Args, 
                           final OverloadCandidateSet /*&*/ CandidateSet, 
                           SourceRange OpRange/*= SourceRange()*/) {
  DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(Op);
  
  // C++ [over.match.oper]p3:
  //   For a unary operator @ with an operand of a type whose
  //   cv-unqualified version is T1, and for a binary operator @ with
  //   a left operand of a type whose cv-unqualified version is T1 and
  //   a right operand of a type whose cv-unqualified version is T2,
  //   three sets of candidate functions, designated member
  //   candidates, non-member candidates and built-in candidates, are
  //   constructed as follows:
  QualType T1 = Args.$at(0).getType();
  {
    
    //     -- If T1 is a complete class type or a class currently being
    //        defined, the set of member candidates is the result of the
    //        qualified lookup of T1::operator@ (13.3.1.1.1); otherwise,
    //        the set of member candidates is empty.
    /*const*/ RecordType /*P*/ T1Rec = T1.$arrow().getAs$RecordType();
    if ((T1Rec != null)) {
      LookupResult Operators = null;
      try {
        // Complete the type if it can be completed.
        if (!$this().isCompleteType(new SourceLocation(OpLoc), new QualType(T1)) && !T1Rec.isBeingDefined()) {
          return;
        }
        // If the type is neither complete nor being defined, bail out now.
        if (!(T1Rec.getDecl().getDefinition() != null)) {
          return;
        }
        
        Operators/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(OpLoc), LookupNameKind.LookupOrdinaryName);
        $this().LookupQualifiedName(Operators, T1Rec.getDecl());
        Operators.suppressDiagnostics();
        
        for (UnresolvedSetIterator Oper = Operators.begin(), 
            OperEnd = Operators.end();
             Oper.$noteq(OperEnd);
             Oper.$preInc())  {
          $this().AddMethodCandidate(new DeclAccessPair(Oper.getPair()), Args.$at(0).getType(), 
              Args.$at(0).Classify($this().Context), 
              Args.slice(1), 
              CandidateSet, 
              /* SuppressUserConversions = */ false);
        }
      } finally {
        if (Operators != null) { Operators.$destroy(); }
      }
    }
  }
}


/// AddBuiltinCandidate - Add a candidate for a built-in
/// operator. ResultTy and ParamTys are the result and parameter types
/// of the built-in candidate, respectively. Args and NumArgs are the
/// arguments being passed to the candidate. IsAssignmentOperator
/// should be true when this built-in candidate is an assignment
/// operator. NumContextualBoolArguments is the number of arguments
/// (at the beginning of the argument list) that will be contextually
/// converted to bool.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddBuiltinCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6765,
 FQN="clang::Sema::AddBuiltinCandidate", NM="_ZN5clang4Sema19AddBuiltinCandidateENS_8QualTypeEPS1_N4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema19AddBuiltinCandidateENS_8QualTypeEPS1_N4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbj")
//</editor-fold>
public final void AddBuiltinCandidate(QualType ResultTy, type$ptr<QualType /*P*/> ParamTys, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet) {
  AddBuiltinCandidate(ResultTy, ParamTys, 
                   Args, 
                   CandidateSet, 
                   false, 
                   0);
}
public final void AddBuiltinCandidate(QualType ResultTy, type$ptr<QualType /*P*/> ParamTys, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet, 
                   boolean IsAssignmentOperator/*= false*/) {
  AddBuiltinCandidate(ResultTy, ParamTys, 
                   Args, 
                   CandidateSet, 
                   IsAssignmentOperator, 
                   0);
}
public final void AddBuiltinCandidate(QualType ResultTy, type$ptr<QualType /*P*/> ParamTys, 
                   ArrayRef<Expr /*P*/ > Args, 
                   final OverloadCandidateSet /*&*/ CandidateSet, 
                   boolean IsAssignmentOperator/*= false*/, 
                   /*uint*/int NumContextualBoolArguments/*= 0*/) {
  EnterExpressionEvaluationContext Unevaluated = null;
  try {
    // Overload resolution is always an unevaluated context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(/*Deref*/$this(), Sema.ExpressionEvaluationContext.Unevaluated);
    
    // Add this candidate
    final OverloadCandidate /*&*/ Candidate = CandidateSet.addCandidate(Args.size());
    Candidate.FoundDecl.$assignMove(DeclAccessPair.make((NamedDecl /*P*/ )null, AccessSpecifier.AS_none));
    Candidate.Function = null;
    Candidate.IsSurrogate = false;
    Candidate.IgnoreObjectArgument = false;
    Candidate.BuiltinTypes.ResultTy.$assign(ResultTy);
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx)  {
      Candidate.BuiltinTypes.ParamTypes[ArgIdx].$assign(ParamTys.$at(ArgIdx));
    }
    
    // Determine the implicit conversion sequences for each of the
    // arguments.
    Candidate.Viable = true;
    Candidate.ExplicitCallArguments = Args.size();
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      // C++ [over.match.oper]p4:
      //   For the built-in assignment operators, conversions of the
      //   left operand are restricted as follows:
      //     -- no temporaries are introduced to hold the left operand, and
      //     -- no user-defined conversions are applied to the left
      //        operand to achieve a type match with the left-most
      //        parameter of a built-in candidate.
      //
      // We block these conversions by turning off user-defined
      // conversions, since that is the only way that initialization of
      // a reference to a non-class type can occur from something that
      // is not of the same type.
      if ($less_uint(ArgIdx, NumContextualBoolArguments)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          assert ($eq_QualType$C(ParamTys.$at(ArgIdx), $this().Context.BoolTy.$QualType())) : "Contextual conversion to bool requires bool type";
          $c$.clean(Candidate.Conversions[ArgIdx].$assign(
              $c$.track(TryContextuallyConvertToBool(/*Deref*/$this(), Args.$at(ArgIdx)))
          ));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Candidate.Conversions[ArgIdx].$assign(
              $c$.track(TryCopyInitialization(/*Deref*/$this(), Args.$at(ArgIdx), new QualType(ParamTys.$at(ArgIdx)), 
                  ArgIdx == 0 && IsAssignmentOperator, 
                  /*InOverloadResolution=*/ false, 
                  /*AllowObjCWritebackConversion=*/
                  $this().getLangOpts().ObjCAutoRefCount))
          ));
        } finally {
          $c$.$destroy();
        }
      }
      if (Candidate.Conversions[ArgIdx].isBad()) {
        Candidate.Viable = false;
        Candidate.FailureKind = (byte)OverloadFailureKind.ovl_fail_bad_conversion.getValue();
        break;
      }
    }
  } finally {
    if (Unevaluated != null) { Unevaluated.$destroy(); }
  }
}

// end anonymous namespace

/// AddBuiltinOperatorCandidates - Add the appropriate built-in
/// operator overloads to the candidate set (C++ [over.built]), based
/// on the operator @p Op and the arguments given. For example, if the
/// operator is a binary '+', this routine might add "int
/// operator+(int, int)" to cover integer addition.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddBuiltinOperatorCandidates">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8257,
 FQN="clang::Sema::AddBuiltinOperatorCandidates", NM="_ZN5clang4Sema28AddBuiltinOperatorCandidatesENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema28AddBuiltinOperatorCandidatesENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetE")
//</editor-fold>
public final void AddBuiltinOperatorCandidates(OverloadedOperatorKind Op, 
                            SourceLocation OpLoc, 
                            ArrayRef<Expr /*P*/ > Args, 
                            final OverloadCandidateSet /*&*/ CandidateSet) {
  SmallVector<BuiltinCandidateTypeSet> CandidateTypes = null;
  try {
    // Find all of the types that the arguments can convert to, but only
    // if the operator we're looking at has built-in operator candidates
    // that make use of these types. Also record whether we encounter non-record
    // candidate types or either arithmetic or enumeral candidate types.
    Qualifiers VisibleTypeConversionsQuals/*J*/= new Qualifiers();
    VisibleTypeConversionsQuals.addConst();
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx)  {
      VisibleTypeConversionsQuals.$addassign(CollectVRQualifiers($this().Context, Args.$at(ArgIdx)));
    }
    
    boolean HasNonRecordCandidateType = false;
    boolean HasArithmeticOrEnumeralCandidateType = false;
    CandidateTypes/*J*/= new SmallVector<BuiltinCandidateTypeSet>(2, /*new BuiltinCandidateTypeSet()*/null);
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      CandidateTypes.emplace_back(new BuiltinCandidateTypeSet(/*Deref*/$this()));
      CandidateTypes.$at(ArgIdx).AddTypesConvertedFrom(Args.$at(ArgIdx).getType(), 
          new SourceLocation(OpLoc), 
          true, 
          (Op == OverloadedOperatorKind.OO_Exclaim
             || Op == OverloadedOperatorKind.OO_AmpAmp
             || Op == OverloadedOperatorKind.OO_PipePipe), 
          VisibleTypeConversionsQuals);
      HasNonRecordCandidateType = HasNonRecordCandidateType
         || CandidateTypes.$at(ArgIdx).hasNonRecordTypes();
      HasArithmeticOrEnumeralCandidateType
         = HasArithmeticOrEnumeralCandidateType
         || CandidateTypes.$at(ArgIdx).hasArithmeticOrEnumeralTypes();
    }
    
    // Exit early when no non-record types have been added to the candidate set
    // for any of the arguments to the operator.
    //
    // We can't exit early for !, ||, or &&, since there we have always have
    // 'bool' overloads.
    if (!HasNonRecordCandidateType
       && !(Op == OverloadedOperatorKind.OO_Exclaim || Op == OverloadedOperatorKind.OO_AmpAmp || Op == OverloadedOperatorKind.OO_PipePipe)) {
      return;
    }
    
    // Setup an object to manage the common state for building overloads.
    BuiltinOperatorOverloadBuilder OpBuilder/*J*/= new BuiltinOperatorOverloadBuilder(/*Deref*/$this(), new ArrayRef<Expr /*P*/ >(Args), 
        new Qualifiers(VisibleTypeConversionsQuals), 
        HasArithmeticOrEnumeralCandidateType, 
        CandidateTypes, CandidateSet);
    
    // Dispatch over the operation to add in only those overloads which apply.
    switch (Op) {
     case OO_None:
     case NUM_OVERLOADED_OPERATORS:
      throw new llvm_unreachable("Expected an overloaded operator");
     case OO_New:
     case OO_Delete:
     case OO_Array_New:
     case OO_Array_Delete:
     case OO_Call:
      throw new llvm_unreachable("Special operators don't use AddBuiltinOperatorCandidates");
     case OO_Comma:
     case OO_Arrow:
     case OO_Coawait:
      // C++ [over.match.oper]p3:
      //   -- For the operator ',', the unary operator '&', the
      //      operator '->', or the operator 'co_await', the
      //      built-in candidates set is empty.
      break;
     case OO_Plus: // '+' is either unary or binary
      if (Args.size() == 1) {
        OpBuilder.addUnaryPlusPointerOverloads();
      }
     case OO_Minus: // '-' is either unary or binary
      if (Args.size() == 1) {
        OpBuilder.addUnaryPlusOrMinusArithmeticOverloads();
      } else {
        OpBuilder.addBinaryPlusOrMinusPointerOverloads(Op);
        OpBuilder.addGenericBinaryArithmeticOverloads(/*isComparison=*/ false);
      }
      break;
     case OO_Star: // '*' is either unary or binary
      if (Args.size() == 1) {
        OpBuilder.addUnaryStarPointerOverloads();
      } else {
        OpBuilder.addGenericBinaryArithmeticOverloads(/*isComparison=*/ false);
      }
      break;
     case OO_Slash:
      OpBuilder.addGenericBinaryArithmeticOverloads(/*isComparison=*/ false);
      break;
     case OO_PlusPlus:
     case OO_MinusMinus:
      OpBuilder.addPlusPlusMinusMinusArithmeticOverloads(Op);
      OpBuilder.addPlusPlusMinusMinusPointerOverloads();
      break;
     case OO_EqualEqual:
     case OO_ExclaimEqual:
      OpBuilder.addEqualEqualOrNotEqualMemberPointerOverloads();
     case OO_Less:
     case OO_Greater:
     case OO_LessEqual:
     case OO_GreaterEqual:
      // Fall through.
      OpBuilder.addRelationalPointerOrEnumeralOverloads();
      OpBuilder.addGenericBinaryArithmeticOverloads(/*isComparison=*/ true);
      break;
     case OO_Percent:
     case OO_Caret:
     case OO_Pipe:
     case OO_LessLess:
     case OO_GreaterGreater:
      OpBuilder.addBinaryBitwiseArithmeticOverloads(Op);
      break;
     case OO_Amp: // '&' is either unary or binary
      if (Args.size() == 1) {
        // C++ [over.match.oper]p3:
        //   -- For the operator ',', the unary operator '&', or the
        //      operator '->', the built-in candidates set is empty.
        break;
      }
      
      OpBuilder.addBinaryBitwiseArithmeticOverloads(Op);
      break;
     case OO_Tilde:
      OpBuilder.addUnaryTildePromotedIntegralOverloads();
      break;
     case OO_Equal:
      OpBuilder.addAssignmentMemberPointerOrEnumeralOverloads();
     case OO_PlusEqual:
     case OO_MinusEqual:
      // Fall through.
      OpBuilder.addAssignmentPointerOverloads(Op == OverloadedOperatorKind.OO_Equal);
     case OO_StarEqual:
     case OO_SlashEqual:
      // Fall through.
      OpBuilder.addAssignmentArithmeticOverloads(Op == OverloadedOperatorKind.OO_Equal);
      break;
     case OO_PercentEqual:
     case OO_LessLessEqual:
     case OO_GreaterGreaterEqual:
     case OO_AmpEqual:
     case OO_CaretEqual:
     case OO_PipeEqual:
      OpBuilder.addAssignmentIntegralOverloads();
      break;
     case OO_Exclaim:
      OpBuilder.addExclaimOverload();
      break;
     case OO_AmpAmp:
     case OO_PipePipe:
      OpBuilder.addAmpAmpOrPipePipeOverload();
      break;
     case OO_Subscript:
      OpBuilder.addSubscriptOverloads();
      break;
     case OO_ArrowStar:
      OpBuilder.addArrowStarOverloads();
      break;
     case OO_Conditional:
      OpBuilder.addConditionalOperatorOverloads();
      OpBuilder.addGenericBinaryArithmeticOverloads(/*isComparison=*/ false);
      break;
    }
  } finally {
    if (CandidateTypes != null) { CandidateTypes.$destroy(); }
  }
}


/// \brief Add function candidates found via argument-dependent lookup
/// to the set of overloading candidates.
///
/// This routine performs argument-dependent name lookup based on the
/// given function name (which may also be an operator name) and adds
/// all of the overload candidates found by ADL to the overload
/// candidate set (C++ [basic.lookup.argdep]).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddArgumentDependentLookupCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8447,
 FQN="clang::Sema::AddArgumentDependentLookupCandidates", NM="_ZN5clang4Sema36AddArgumentDependentLookupCandidatesENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEEPNS_24TemplateArgumentListInfoERNS_20OverloadCandidateSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema36AddArgumentDependentLookupCandidatesENS_15DeclarationNameENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEEPNS_24TemplateArgumentListInfoERNS_20OverloadCandidateSetEb")
//</editor-fold>
public final void AddArgumentDependentLookupCandidates(DeclarationName Name, 
                                    SourceLocation Loc, 
                                    ArrayRef<Expr /*P*/ > Args, 
                                    TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                                    final OverloadCandidateSet /*&*/ CandidateSet) {
  AddArgumentDependentLookupCandidates(Name, 
                                    Loc, 
                                    Args, 
                                    ExplicitTemplateArgs, 
                                    CandidateSet, 
                                    false);
}
public final void AddArgumentDependentLookupCandidates(DeclarationName Name, 
                                    SourceLocation Loc, 
                                    ArrayRef<Expr /*P*/ > Args, 
                                    TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                                    final OverloadCandidateSet /*&*/ CandidateSet, 
                                    boolean PartialOverloading/*= false*/) {
  ADLResult Fns/*J*/= new ADLResult();
  
  // FIXME: This approach for uniquing ADL results (and removing
  // redundant candidates from the set) relies on pointer-equality,
  // which means we need to key off the canonical decl.  However,
  // always going back to the canonical decl might not get us the
  // right set of default arguments.  What default arguments are
  // we supposed to consider on ADL candidates, anyway?
  
  // FIXME: Pass in the explicit template arguments?
  $this().ArgumentDependentLookup(new DeclarationName(Name), new SourceLocation(Loc), new ArrayRef<Expr /*P*/ >(Args), Fns);
  
  // Erase all of the candidates we already knew about.
  for (type$ptr<OverloadCandidate> Cand = $tryClone(CandidateSet.begin()), 
      /*P*/ CandEnd = $tryClone(CandidateSet.end());
       $noteq_ptr(Cand, CandEnd); Cand.$preInc())  {
    if ((Cand./*->*/$star().Function != null)) {
      Fns.erase(Cand./*->*/$star().Function);
      {
        FunctionTemplateDecl /*P*/ FunTmpl = Cand./*->*/$star().Function.getPrimaryTemplate();
        if ((FunTmpl != null)) {
          Fns.erase(FunTmpl);
        }
      }
    }
  }
  
  // For each of the ADL candidates we found, add it to the overload
  // set.
  for (mapped_iterator<std.pairPtrPtr<NamedDecl /*P*/ , NamedDecl /*P*/ >, NamedDecl /*P*/> I = Fns.begin(), E = Fns.end(); I.$noteq(E); I.$preInc()) {
    DeclAccessPair FoundDecl = DeclAccessPair.make(I.$star(), AccessSpecifier.AS_none);
    {
      FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(I.$star());
      if ((FD != null)) {
        if ((ExplicitTemplateArgs != null)) {
          continue;
        }
        
        $this().AddOverloadCandidate(FD, new DeclAccessPair(FoundDecl), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, false, 
            PartialOverloading);
      } else {
        $this().AddTemplateOverloadCandidate(cast_FunctionTemplateDecl(I.$star()), 
            new DeclAccessPair(FoundDecl), ExplicitTemplateArgs, 
            new ArrayRef<Expr /*P*/ >(Args), CandidateSet, PartialOverloading);
      }
    }
  }
}


// Emit as a 'note' the specific overload candidate

// Notes the location of an overload candidate.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::NoteOverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8998,
 FQN="clang::Sema::NoteOverloadCandidate", NM="_ZN5clang4Sema21NoteOverloadCandidateEPNS_9NamedDeclEPNS_12FunctionDeclENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema21NoteOverloadCandidateEPNS_9NamedDeclEPNS_12FunctionDeclENS_8QualTypeEb")
//</editor-fold>
public final void NoteOverloadCandidate(NamedDecl /*P*/ Found, FunctionDecl /*P*/ Fn) {
  NoteOverloadCandidate(Found, Fn, 
                     new QualType(), false);
}
public final void NoteOverloadCandidate(NamedDecl /*P*/ Found, FunctionDecl /*P*/ Fn, 
                     QualType DestType/*= QualType()*/) {
  NoteOverloadCandidate(Found, Fn, 
                     DestType, false);
}
public final void NoteOverloadCandidate(NamedDecl /*P*/ Found, FunctionDecl /*P*/ Fn, 
                     QualType DestType/*= QualType()*/, boolean TakingAddress/*= false*/) {
  PartialDiagnostic PD = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (TakingAddress && !checkAddressOfCandidateIsAvailable(/*Deref*/$this(), Fn)) {
      return;
    }
    
    std.string FnDesc/*J*/= new std.string();
    OverloadCandidateKind K = ClassifyOverloadCandidate(/*Deref*/$this(), Found, Fn, FnDesc);
    /*FIXME: Initializer produces not destroyed temporary!*/PD = $c$.clean(new PartialDiagnostic($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_uint($c$.track($this().PDiag(diag.note_ovl_candidate)), 
                (/*uint*/int)K.getValue()), new StringRef(FnDesc))));
    
    $this().HandleFunctionTypeMismatch(PD, Fn.getType(), new QualType(DestType));
    $c$.clean($c$.track($this().Diag(Fn.getLocation(), PD)));
    MaybeEmitInheritedConstructorNote(/*Deref*/$this(), Found);
  } finally {
    if (PD != null) { PD.$destroy(); }
    $c$.$destroy();
  }
}


// Emit as a series of 'note's all template and non-templates identified by
// the expression Expr

// Notes the location of all overload candidates designated through
// OverloadedExpr
//<editor-fold defaultstate="collapsed" desc="clang::Sema::NoteAllOverloadCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9015,
 FQN="clang::Sema::NoteAllOverloadCandidates", NM="_ZN5clang4Sema25NoteAllOverloadCandidatesEPNS_4ExprENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25NoteAllOverloadCandidatesEPNS_4ExprENS_8QualTypeEb")
//</editor-fold>
public final void NoteAllOverloadCandidates(Expr /*P*/ OverloadedExpr) {
  NoteAllOverloadCandidates(OverloadedExpr, new QualType(), 
                         false);
}
public final void NoteAllOverloadCandidates(Expr /*P*/ OverloadedExpr, QualType DestType/*= QualType()*/) {
  NoteAllOverloadCandidates(OverloadedExpr, DestType, 
                         false);
}
public final void NoteAllOverloadCandidates(Expr /*P*/ OverloadedExpr, QualType DestType/*= QualType()*/, 
                         boolean TakingAddress/*= false*/) {
  assert ($eq_QualType$C(OverloadedExpr.getType(), $this().Context.OverloadTy.$QualType()));
  
  OverloadExpr.FindResult Ovl = OverloadExpr.find(OverloadedExpr);
  OverloadExpr /*P*/ OvlExpr = Ovl.Expression;
  
  for (UnresolvedSetIterator I = OvlExpr.decls_begin(), 
      IEnd = OvlExpr.decls_end();
       I.$noteq(IEnd); I.$preInc()) {
    {
      FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl((I.$star()).getUnderlyingDecl());
      if ((FunTmpl != null)) {
        $this().NoteOverloadCandidate(I.$star(), FunTmpl.getTemplatedDecl(), new QualType(DestType), 
            TakingAddress);
      } else {
        FunctionDecl /*P*/ Fun = dyn_cast_FunctionDecl((I.$star()).getUnderlyingDecl());
        if ((Fun != null)) {
          $this().NoteOverloadCandidate(I.$star(), Fun, new QualType(DestType), TakingAddress);
        }
      }
    }
  }
}


/// Check the enable_if expressions on the given function. Returns the first
/// failing attribute, or NULL if they were all successful.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckEnableIf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5968,
 FQN="clang::Sema::CheckEnableIf", NM="_ZN5clang4Sema13CheckEnableIfEPNS_12FunctionDeclEN4llvm8ArrayRefIPNS_4ExprEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema13CheckEnableIfEPNS_12FunctionDeclEN4llvm8ArrayRefIPNS_4ExprEEEb")
//</editor-fold>
public final EnableIfAttr /*P*/ CheckEnableIf(FunctionDecl /*P*/ Function, ArrayRef<Expr /*P*/ > Args) {
  return CheckEnableIf(Function, Args, 
             false);
}
public final EnableIfAttr /*P*/ CheckEnableIf(FunctionDecl /*P*/ Function, ArrayRef<Expr /*P*/ > Args, 
             boolean MissingImplicitThis/*= false*/) {
  SFINAETrap Trap = null;
  try {
    SmallVector<EnableIfAttr /*P*/ > EnableIfAttrs = getOrderedEnableIfAttrs(Function);
    if (EnableIfAttrs.empty()) {
      return null;
    }
    
    Trap/*J*/= new SFINAETrap(/*Deref*/$this());
    SmallVector<Expr /*P*/ > ConvertedArgs/*J*/= new SmallVector<Expr /*P*/ >(16, (Expr /*P*/ )null);
    boolean InitializationFailed = false;
    
    // Ignore any variadic parameters. Converting them is pointless, since the
    // user can't refer to them in the enable_if condition.
    /*uint*/int ArgSizeNoVarargs = std.min_uint(Function.param_size(), Args.size());
    
    // Convert the arguments.
    for (/*uint*/int I = 0; I != ArgSizeNoVarargs; ++I) {
      ActionResultTTrue<Expr /*P*/ > R/*J*/= new ActionResultTTrue<Expr /*P*/ >();
      if (I == 0 && !MissingImplicitThis && isa_CXXMethodDecl(Function)
         && !cast_CXXMethodDecl(Function).isStatic()
         && !isa_CXXConstructorDecl(Function)) {
        CXXMethodDecl /*P*/ Method = cast_CXXMethodDecl(Function);
        R.$assignMove($this().PerformObjectArgumentInitialization(Args.$at(0), /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
                Method, Method));
      } else {
        R.$assignMove($this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, Function.getParamDecl(I)), 
                new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args.$at(I))));
      }
      if (R.isInvalid()) {
        InitializationFailed = true;
        break;
      }
      
      ConvertedArgs.push_back(R.get());
    }
    if (InitializationFailed || Trap.hasErrorOccurred()) {
      return EnableIfAttrs.$at(0);
    }
    
    // Push default arguments if needed.
    if (!Function.isVariadic() && $less_uint(Args.size(), Function.getNumParams())) {
      for (/*uint*/int i = Args.size(), e = Function.getNumParams(); i != e; ++i) {
        ParmVarDecl /*P*/ P = Function.getParamDecl(i);
        ActionResultTTrue<Expr /*P*/ > R = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                Function.getParamDecl(i)), 
            new SourceLocation(), 
            new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, P.hasUninstantiatedDefaultArg() ? P.getUninstantiatedDefaultArg() : P.getDefaultArg()));
        if (R.isInvalid()) {
          InitializationFailed = true;
          break;
        }
        ConvertedArgs.push_back(R.get());
      }
      if (InitializationFailed || Trap.hasErrorOccurred()) {
        return EnableIfAttrs.$at(0);
      }
    }
    
    for (EnableIfAttr /*P*/ EIA : EnableIfAttrs) {
      APValue Result = null;
      try {
        Result/*J*/= new APValue();
        // FIXME: This doesn't consider value-dependent cases, because doing so is
        // very difficult. Ideally, we should handle them more gracefully.
        if (!EIA.getCond().EvaluateWithSubstitution(Result, $this().Context, Function, new ArrayRef</*const*/ Expr /*P*/ >(JD$Convertible.INSTANCE, llvm.makeArrayRef(ConvertedArgs), true))) {
          return EIA;
        }
        if (!Result.isInt() || !Result.getInt().getBoolValue()) {
          return EIA;
        }
      } finally {
        if (Result != null) { Result.$destroy(); }
      }
    }
    return null;
  } finally {
    if (Trap != null) { Trap.$destroy(); }
  }
}


/// Returns whether the given function's address can be taken or not,
/// optionally emitting a diagnostic if the address can't be taken.
///
/// Returns false if taking the address of the function is illegal.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkAddressOfFunctionIsAvailable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8989,
 FQN="clang::Sema::checkAddressOfFunctionIsAvailable", NM="_ZN5clang4Sema33checkAddressOfFunctionIsAvailableEPKNS_12FunctionDeclEbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema33checkAddressOfFunctionIsAvailableEPKNS_12FunctionDeclEbNS_14SourceLocationE")
//</editor-fold>
public final boolean checkAddressOfFunctionIsAvailable(/*const*/ FunctionDecl /*P*/ Function) {
  return checkAddressOfFunctionIsAvailable(Function, 
                                 false, 
                                 new SourceLocation());
}
public final boolean checkAddressOfFunctionIsAvailable(/*const*/ FunctionDecl /*P*/ Function, 
                                 boolean Complain/*= false*/) {
  return checkAddressOfFunctionIsAvailable(Function, 
                                 Complain, 
                                 new SourceLocation());
}
public final boolean checkAddressOfFunctionIsAvailable(/*const*/ FunctionDecl /*P*/ Function, 
                                 boolean Complain/*= false*/, 
                                 SourceLocation Loc/*= SourceLocation()*/) {
  return SemaOverloadStatics./*::*/checkAddressOfFunctionIsAvailable(/*Deref*/$this(), Function, Complain, 
      /*InOverloadResolution=*/ false, 
      new SourceLocation(Loc));
}


// [PossiblyAFunctionType]  -->   [Return]
// NonFunctionType --> NonFunctionType
// R (A) --> R(A)
// R (*)(A) --> R (A)
// R (&)(A) --> R (A)
// R (S::*)(A) --> R (A)

// [PossiblyAFunctionType]  -->   [Return]
// NonFunctionType --> NonFunctionType
// R (A) --> R(A)
// R (*)(A) --> R (A)
// R (&)(A) --> R (A)
// R (S::*)(A) --> R (A)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ExtractUnqualifiedFunctionType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10256,
 FQN="clang::Sema::ExtractUnqualifiedFunctionType", NM="_ZN5clang4Sema30ExtractUnqualifiedFunctionTypeENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema30ExtractUnqualifiedFunctionTypeENS_8QualTypeE")
//</editor-fold>
public final QualType ExtractUnqualifiedFunctionType(QualType PossiblyAFunctionType) {
  QualType Ret = new QualType(PossiblyAFunctionType);
  {
    /*const*/ PointerType /*P*/ ToTypePtr = PossiblyAFunctionType.$arrow().getAs(PointerType.class);
    if ((ToTypePtr != null)) {
      Ret.$assignMove(ToTypePtr.getPointeeType());
    } else {
      /*const*/ ReferenceType /*P*/ ToTypeRef = PossiblyAFunctionType.$arrow().getAs(ReferenceType.class);
      if ((ToTypeRef != null)) {
        Ret.$assignMove(ToTypeRef.getPointeeType());
      } else {
        /*const*/ MemberPointerType /*P*/ MemTypePtr = PossiblyAFunctionType.$arrow().getAs(MemberPointerType.class);
        if ((MemTypePtr != null)) {
          Ret.$assignMove(MemTypePtr.getPointeeType());
        }
      }
    }
  }
  Ret.$assignMove(
      $this().Context.getCanonicalType(new QualType(Ret)).getUnqualifiedType().$QualType()
  );
  return Ret;
}


/// ResolveAddressOfOverloadedFunction - Try to resolve the address of
/// an overloaded function (C++ [over.over]), where @p From is an
/// expression with overloaded function type and @p ToType is the type
/// we're trying to resolve to. For example:
///
/// @code
/// int f(double);
/// int f(int);
///
/// int (*pfd)(double) = f; // selects f(double)
/// @endcode
///
/// This routine returns the resulting FunctionDecl if it could be
/// resolved, and NULL otherwise. When @p Complain is true, this
/// routine will emit diagnostics if there is an error.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ResolveAddressOfOverloadedFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10683,
 FQN="clang::Sema::ResolveAddressOfOverloadedFunction", NM="_ZN5clang4Sema34ResolveAddressOfOverloadedFunctionEPNS_4ExprENS_8QualTypeEbRNS_14DeclAccessPairEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema34ResolveAddressOfOverloadedFunctionEPNS_4ExprENS_8QualTypeEbRNS_14DeclAccessPairEPb")
//</editor-fold>
public final FunctionDecl /*P*/ ResolveAddressOfOverloadedFunction(Expr /*P*/ AddressOfExpr, 
                                  QualType TargetType, 
                                  boolean Complain, 
                                  final DeclAccessPair /*&*/ FoundResult) {
  return ResolveAddressOfOverloadedFunction(AddressOfExpr, 
                                  TargetType, 
                                  Complain, 
                                  FoundResult, 
                                  (bool$ptr/*bool P*/ )null);
}
public final FunctionDecl /*P*/ ResolveAddressOfOverloadedFunction(Expr /*P*/ AddressOfExpr, 
                                  QualType TargetType, 
                                  boolean Complain, 
                                  final DeclAccessPair /*&*/ FoundResult, 
                                  bool$ptr/*bool P*/ pHadMultipleCandidates/*= null*/) {
  AddressOfFunctionResolver Resolver = null;
  try {
    assert ($eq_QualType$C(AddressOfExpr.getType(), $this().Context.OverloadTy.$QualType()));
    
    Resolver/*J*/= new AddressOfFunctionResolver(/*Deref*/$this(), AddressOfExpr, TargetType, 
        Complain);
    int NumMatches = Resolver.getNumMatches();
    FunctionDecl /*P*/ Fn = null;
    boolean ShouldComplain = Complain && !Resolver.hasComplained();
    if (NumMatches == 0 && ShouldComplain) {
      if (Resolver.IsInvalidFormOfPointerToMemberFunction()) {
        Resolver.ComplainIsInvalidFormOfPointerToMemberFunction();
      } else {
        Resolver.ComplainNoMatchesFound();
      }
    } else if (NumMatches > 1 && ShouldComplain) {
      Resolver.ComplainMultipleMatchesFound();
    } else if (NumMatches == 1) {
      Fn = Resolver.getMatchingFunctionDecl();
      assert Native.$bool(Fn);
      FoundResult.$assign($Deref(Resolver.getMatchingFunctionAccessPair()));
      if (Complain) {
        if (Resolver.IsStaticMemberFunctionFromBoundPointer()) {
          Resolver.ComplainIsStaticMemberFunctionFromBoundPointer();
        } else {
          $this().CheckAddressOfMemberAccess(AddressOfExpr, new DeclAccessPair(FoundResult));
        }
      }
    }
    if (Native.$bool(pHadMultipleCandidates)) {
      pHadMultipleCandidates.$set(Resolver.hadMultipleCandidates());
    }
    return Fn;
  } finally {
    if (Resolver != null) { Resolver.$destroy(); }
  }
}


/// \brief Given an expression that refers to an overloaded function, try to
/// resolve that function to a single function that can have its address taken.
/// This will modify `Pair` iff it returns non-null.
///
/// This routine can only realistically succeed if all but one candidates in the
/// overload set for SrcExpr cannot have their addresses taken.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::resolveAddressOfOnlyViableOverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10727,
 FQN="clang::Sema::resolveAddressOfOnlyViableOverloadCandidate", NM="_ZN5clang4Sema43resolveAddressOfOnlyViableOverloadCandidateEPNS_4ExprERNS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema43resolveAddressOfOnlyViableOverloadCandidateEPNS_4ExprERNS_14DeclAccessPairE")
//</editor-fold>
public final FunctionDecl /*P*/ resolveAddressOfOnlyViableOverloadCandidate(Expr /*P*/ E, 
                                           final DeclAccessPair /*&*/ Pair) {
  OverloadExpr.FindResult R = OverloadExpr.find(E);
  OverloadExpr /*P*/ Ovl = R.Expression;
  FunctionDecl /*P*/ Result = null;
  DeclAccessPair DAP/*J*/= new DeclAccessPair();
  // Don't use the AddressOfResolver because we're specifically looking for
  // cases where we have one overload candidate that lacks
  // enable_if/pass_object_size/...
  for (UnresolvedSetIterator I = Ovl.decls_begin(), E$1 = Ovl.decls_end(); I.$noteq(E$1); I.$preInc()) {
    FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(I.$arrow().getUnderlyingDecl());
    if (!(FD != null)) {
      return null;
    }
    if (!$this().checkAddressOfFunctionIsAvailable(FD)) {
      continue;
    }
    
    // We have more than one result; quit.
    if ((Result != null)) {
      return null;
    }
    DAP.$assign(I.getPair());
    Result = FD;
  }
  if ((Result != null)) {
    Pair.$assign(DAP);
  }
  return Result;
}


/// \brief Given an overloaded function, tries to turn it into a non-overloaded
/// function reference using resolveAddressOfOnlyViableOverloadCandidate. This
/// will perform access checks, diagnose the use of the resultant decl, and, if
/// necessary, perform a function-to-pointer decay.
///
/// Returns false if resolveAddressOfOnlyViableOverloadCandidate fails.
/// Otherwise, returns true. This may emit diagnostics and return true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::resolveAndFixAddressOfOnlyViableOverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10764,
 FQN="clang::Sema::resolveAndFixAddressOfOnlyViableOverloadCandidate", NM="_ZN5clang4Sema49resolveAndFixAddressOfOnlyViableOverloadCandidateERNS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema49resolveAndFixAddressOfOnlyViableOverloadCandidateERNS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final boolean resolveAndFixAddressOfOnlyViableOverloadCandidate(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr) {
  Expr /*P*/ E = SrcExpr.get();
  assert ($eq_QualType$C(E.getType(), $this().Context.OverloadTy.$QualType())) : "SrcExpr must be an overload";
  
  DeclAccessPair DAP/*J*/= new DeclAccessPair();
  FunctionDecl /*P*/ Found = $this().resolveAddressOfOnlyViableOverloadCandidate(E, DAP);
  if (!(Found != null)) {
    return false;
  }
  
  // Emitting multiple diagnostics for a function that is both inaccessible and
  // unavailable is consistent with our behavior elsewhere. So, always check
  // for both.
  $this().DiagnoseUseOfDecl(Found, E.getExprLoc());
  $this().CheckAddressOfMemberAccess(E, new DeclAccessPair(DAP));
  Expr /*P*/ Fixed = $this().FixOverloadedFunctionReference(E, new DeclAccessPair(DAP), Found);
  if (Fixed.getType().$arrow().isFunctionType()) {
    SrcExpr.$assignMove($this().DefaultFunctionArrayConversion(Fixed, /*Diagnose=*/ false));
  } else {
    SrcExpr.$assign(Fixed);
  }
  return true;
}


/// \brief Given an expression that refers to an overloaded function, try to
/// resolve that overloaded function expression down to a single function.
///
/// This routine can only resolve template-ids that refer to a single function
/// template, where that template-id refers to a single template whose template
/// arguments are either provided by the template-id or have defaults,
/// as described in C++0x [temp.arg.explicit]p3.
///
/// If no template-ids are found, no diagnostics are emitted and NULL is
/// returned.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ResolveSingleFunctionTemplateSpecialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10797,
 FQN="clang::Sema::ResolveSingleFunctionTemplateSpecialization", NM="_ZN5clang4Sema43ResolveSingleFunctionTemplateSpecializationEPNS_12OverloadExprEbPNS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema43ResolveSingleFunctionTemplateSpecializationEPNS_12OverloadExprEbPNS_14DeclAccessPairE")
//</editor-fold>
public final FunctionDecl /*P*/ ResolveSingleFunctionTemplateSpecialization(OverloadExpr /*P*/ ovl) {
  return ResolveSingleFunctionTemplateSpecialization(ovl, 
                                           false, 
                                           (DeclAccessPair /*P*/ )null);
}
public final FunctionDecl /*P*/ ResolveSingleFunctionTemplateSpecialization(OverloadExpr /*P*/ ovl, 
                                           boolean Complain/*= false*/) {
  return ResolveSingleFunctionTemplateSpecialization(ovl, 
                                           Complain, 
                                           (DeclAccessPair /*P*/ )null);
}
public final FunctionDecl /*P*/ ResolveSingleFunctionTemplateSpecialization(OverloadExpr /*P*/ ovl, 
                                           boolean Complain/*= false*/, 
                                           DeclAccessPair /*P*/ FoundResult/*= null*/) {
  TemplateArgumentListInfo ExplicitTemplateArgs = null;
  TemplateSpecCandidateSet FailedCandidates = null;
  try {
    // C++ [over.over]p1:
    //   [...] [Note: any redundant set of parentheses surrounding the
    //   overloaded function name is ignored (5.1). ]
    // C++ [over.over]p1:
    //   [...] The overloaded function name can be preceded by the &
    //   operator.
    
    // If we didn't actually find any template-ids, we're done.
    if (!ovl.hasExplicitTemplateArgs()) {
      return null;
    }
    
    ExplicitTemplateArgs/*J*/= new TemplateArgumentListInfo();
    ovl.copyTemplateArgumentsInto(ExplicitTemplateArgs);
    FailedCandidates/*J*/= new TemplateSpecCandidateSet(ovl.getNameLoc());
    
    // Look through all of the overloaded functions, searching for one
    // whose type matches exactly.
    FunctionDecl /*P*/ Matched = null;
    for (UnresolvedSetIterator I = ovl.decls_begin(), 
        E = ovl.decls_end(); I.$noteq(E); I.$preInc()) {
      TemplateDeductionInfo Info = null;
      try {
        // C++0x [temp.arg.explicit]p3:
        //   [...] In contexts where deduction is done and fails, or in contexts
        //   where deduction is not done, if a template argument list is
        //   specified and it, along with any default template arguments,
        //   identifies a single function template specialization, then the
        //   template-id is an lvalue for the function template specialization.
        FunctionTemplateDecl /*P*/ FunctionTemplate = cast_FunctionTemplateDecl((I.$star()).getUnderlyingDecl());
        
        // C++ [over.over]p2:
        //   If the name is a function template, template argument deduction is
        //   done (14.8.2.2), and if the argument deduction succeeds, the
        //   resulting template argument list is used to generate a single
        //   function template specialization, which is added to the set of
        //   overloaded functions considered.
        type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
        Info/*J*/= new TemplateDeductionInfo(FailedCandidates.getLocation());
        {
          TemplateDeductionResult Result = $this().DeduceTemplateArguments(FunctionTemplate, $AddrOf(ExplicitTemplateArgs), 
              Specialization, Info, 
              /*InOverloadResolution=*/ true);
          if ((Result.getValue() != 0)) {
            // Make a note of the failed deduction for diagnostics.
            // TODO: Actually use the failed-deduction info?
            FailedCandidates.addCandidate().
                set(new DeclAccessPair(I.getPair()), FunctionTemplate.getTemplatedDecl(), 
                MakeDeductionFailureInfo($this().Context, Result, Info));
            continue;
          }
        }
        assert ((Specialization.$deref() != null)) : "no specialization and no error?";
        
        // Multiple matches; we can't resolve to a single declaration.
        if ((Matched != null)) {
          if (Complain) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ovl.getExprLoc(), diag.err_addr_ovl_ambiguous)), 
                  ovl.getName()));
              $this().NoteAllOverloadCandidates(ovl);
            } finally {
              $c$.$destroy();
            }
          }
          return null;
        }
        
        Matched = Specialization.$deref();
        if ((FoundResult != null)) {
          /*Deref*/FoundResult.$assign(I.getPair());
        }
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    if ((Matched != null) && $this().getLangOpts().CPlusPlus14
       && Matched.getReturnType().$arrow().isUndeducedType()
       && $this().DeduceReturnType(Matched, ovl.getExprLoc(), Complain)) {
      return null;
    }
    
    return Matched;
  } finally {
    if (FailedCandidates != null) { FailedCandidates.$destroy(); }
    if (ExplicitTemplateArgs != null) { ExplicitTemplateArgs.$destroy(); }
  }
}


// Resolve and fix an overloaded expression that can be resolved
// because it identifies a single function template specialization.
//
// Last three arguments should only be supplied if Complain = true
//
// Return true if it was logically possible to so resolve the
// expression, regardless of whether or not it succeeded.  Always
// returns true if 'complain' is set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ResolveAndFixSingleFunctionTemplateSpecialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10885,
 FQN="clang::Sema::ResolveAndFixSingleFunctionTemplateSpecialization", NM="_ZN5clang4Sema49ResolveAndFixSingleFunctionTemplateSpecializationERNS_12ActionResultIPNS_4ExprELb1EEEbbNS_11SourceRangeENS_8QualTypeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema49ResolveAndFixSingleFunctionTemplateSpecializationERNS_12ActionResultIPNS_4ExprELb1EEEbbNS_11SourceRangeENS_8QualTypeEj")
//</editor-fold>
public final boolean ResolveAndFixSingleFunctionTemplateSpecialization(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr) {
  return ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, false, 
                                                 false, new SourceRange(), 
                                                 new QualType(), 
                                                 0);
}
public final boolean ResolveAndFixSingleFunctionTemplateSpecialization(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, boolean doFunctionPointerConverion/*= false*/) {
  return ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, doFunctionPointerConverion, 
                                                 false, new SourceRange(), 
                                                 new QualType(), 
                                                 0);
}
public final boolean ResolveAndFixSingleFunctionTemplateSpecialization(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, boolean doFunctionPointerConverion/*= false*/, 
                                                 boolean complain/*= false*/) {
  return ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, doFunctionPointerConverion, 
                                                 complain, new SourceRange(), 
                                                 new QualType(), 
                                                 0);
}
public final boolean ResolveAndFixSingleFunctionTemplateSpecialization(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, boolean doFunctionPointerConverion/*= false*/, 
                                                 boolean complain/*= false*/, SourceRange OpRangeForComplaining/*= SourceRange()*/) {
  return ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, doFunctionPointerConverion, 
                                                 complain, OpRangeForComplaining, 
                                                 new QualType(), 
                                                 0);
}
public final boolean ResolveAndFixSingleFunctionTemplateSpecialization(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, boolean doFunctionPointerConverion/*= false*/, 
                                                 boolean complain/*= false*/, SourceRange OpRangeForComplaining/*= SourceRange()*/, 
                                                 QualType DestTypeForComplaining/*= QualType()*/) {
  return ResolveAndFixSingleFunctionTemplateSpecialization(SrcExpr, doFunctionPointerConverion, 
                                                 complain, OpRangeForComplaining, 
                                                 DestTypeForComplaining, 
                                                 0);
}
public final boolean ResolveAndFixSingleFunctionTemplateSpecialization(final ActionResultTTrue<Expr /*P*/ > /*&*/ SrcExpr, boolean doFunctionPointerConverion/*= false*/, 
                                                 boolean complain/*= false*/, SourceRange OpRangeForComplaining/*= SourceRange()*/, 
                                                 QualType DestTypeForComplaining/*= QualType()*/, 
                                                 /*uint*/int DiagIDForComplaining/*= 0*/) {
  assert ($eq_QualType$C(SrcExpr.get().getType(), $this().Context.OverloadTy.$QualType()));
  
  OverloadExpr.FindResult ovl = OverloadExpr.find(SrcExpr.get());
  
  DeclAccessPair found/*J*/= new DeclAccessPair();
  ActionResultTTrue<Expr /*P*/ > SingleFunctionExpression/*J*/= new ActionResultTTrue<Expr /*P*/ >();
  {
    FunctionDecl /*P*/ fn = $this().ResolveSingleFunctionTemplateSpecialization(ovl.Expression, /*complain*/ false, $AddrOf(found));
    if ((fn != null)) {
      if ($this().DiagnoseUseOfDecl(fn, SrcExpr.get().getLocStart())) {
        SrcExpr.$assignMove(ExprError());
        return true;
      }
      
      // It is only correct to resolve to an instance method if we're
      // resolving a form that's permitted to be a pointer to member.
      // Otherwise we'll end up making a bound member expression, which
      // is illegal in all the contexts we resolve like this.
      if (!ovl.HasFormOfMemberPointer
         && isa_CXXMethodDecl(fn)
         && cast_CXXMethodDecl(fn).isInstance()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          if (!complain) {
            return false;
          }
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ovl.Expression.getExprLoc(), 
                      diag.err_bound_member_function)), 
                  0), ovl.Expression.getSourceRange()));
          
          // TODO: I believe we only end up here if there's a mix of
          // static and non-static candidates (otherwise the expression
          // would have 'bound member' type, not 'overload' type).
          // Ideally we would note which candidate was chosen and why
          // the static candidates were rejected.
          SrcExpr.$assignMove(ExprError());
          return true;
        } finally {
          $c$.$destroy();
        }
      }
      
      // Fix the expression to refer to 'fn'.
      SingleFunctionExpression.$assign(
          $this().FixOverloadedFunctionReference(SrcExpr.get(), new DeclAccessPair(found), fn)
      );
      
      // If desired, do function-to-pointer decay.
      if (doFunctionPointerConverion) {
        SingleFunctionExpression.$assignMove(
            $this().DefaultFunctionArrayLvalueConversion(SingleFunctionExpression.get())
        );
        if (SingleFunctionExpression.isInvalid()) {
          SrcExpr.$assignMove(ExprError());
          return true;
        }
      }
    }
  }
  if (!SingleFunctionExpression.isUsable()) {
    if (complain) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(OpRangeForComplaining.getBegin(), DiagIDForComplaining)), 
                        ovl.Expression.getName()), 
                    DestTypeForComplaining), 
                OpRangeForComplaining), 
            ovl.Expression.getQualifierLoc().getSourceRange()));
        $this().NoteAllOverloadCandidates(SrcExpr.get());
        
        SrcExpr.$assignMove(ExprError());
        return true;
      } finally {
        $c$.$destroy();
      }
    }
    
    return false;
  }
  
  SrcExpr.$assign(SingleFunctionExpression);
  return true;
}


/// FixOverloadedFunctionReference - E is an expression that refers to
/// a C++ overloaded function (possibly with some parentheses and
/// perhaps a '&' around it). We have resolved the overloaded function
/// to the function declaration Fn, so patch up the expression E to
/// refer (possibly indirectly) to Fn. Returns the new expr.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FixOverloadedFunctionReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 12972,
 FQN="clang::Sema::FixOverloadedFunctionReference", NM="_ZN5clang4Sema30FixOverloadedFunctionReferenceEPNS_4ExprENS_14DeclAccessPairEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema30FixOverloadedFunctionReferenceEPNS_4ExprENS_14DeclAccessPairEPNS_12FunctionDeclE")
//</editor-fold>
public final Expr /*P*/ FixOverloadedFunctionReference(Expr /*P*/ E, DeclAccessPair Found, 
                              FunctionDecl /*P*/ Fn) {
  {
    ParenExpr /*P*/ PE = dyn_cast_ParenExpr(E);
    if ((PE != null)) {
      Expr /*P*/ SubExpr = $this().FixOverloadedFunctionReference(PE.getSubExpr(), 
          new DeclAccessPair(Found), Fn);
      if (SubExpr == PE.getSubExpr()) {
        return PE;
      }
      
      return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new ParenExpr(PE.getLParen(), PE.getRParen(), SubExpr));
    }
  }
  {
    
    ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
    if ((ICE != null)) {
      Expr /*P*/ SubExpr = $this().FixOverloadedFunctionReference(ICE.getSubExpr(), 
          new DeclAccessPair(Found), Fn);
      assert ($this().Context.hasSameType(ICE.getSubExpr().getType(), SubExpr.getType())) : "Implicit cast type cannot be determined from overload";
      assert (ICE.path_empty()) : "fixing up hierarchy conversion?";
      if (SubExpr == ICE.getSubExpr()) {
        return ICE;
      }
      
      return ImplicitCastExpr.Create($this().Context, ICE.getType(), 
          ICE.getCastKind(), 
          SubExpr, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
          ICE.getValueKind());
    }
  }
  {
    
    UnaryOperator /*P*/ UnOp = dyn_cast_UnaryOperator(E);
    if ((UnOp != null)) {
      assert (UnOp.getOpcode() == UnaryOperatorKind.UO_AddrOf) : "Can only take the address of an overloaded function";
      {
        CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Fn);
        if ((Method != null)) {
          if (Method.isStatic()) {
            // Do nothing: static member functions aren't any different
            // from non-member functions.
          } else {
            // Fix the subexpression, which really has to be an
            // UnresolvedLookupExpr holding an overloaded member function
            // or template.
            Expr /*P*/ SubExpr = $this().FixOverloadedFunctionReference(UnOp.getSubExpr(), 
                new DeclAccessPair(Found), Fn);
            if (SubExpr == UnOp.getSubExpr()) {
              return UnOp;
            }
            assert (isa_DeclRefExpr(SubExpr)) : "fixed to something other than a decl ref";
            assert ((cast_DeclRefExpr(SubExpr).getQualifier() != null)) : "fixed to a member ref with no nested name qualifier";
            
            // We have taken the address of a pointer to member
            // function. Perform the computation here so that we get the
            // appropriate pointer to member type.
            QualType ClassType = $this().Context.getTypeDeclType(cast_RecordDecl(Method.getDeclContext()));
            QualType MemPtrType = $this().Context.getMemberPointerType(Fn.getType(), ClassType.getTypePtr());
            // Under the MS ABI, lock down the inheritance model now.
            if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
              /*J:(void)*/$this().isCompleteType(UnOp.getOperatorLoc(), new QualType(MemPtrType));
            }
            
            return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new UnaryOperator(SubExpr, UnaryOperatorKind.UO_AddrOf, new QualType(MemPtrType), 
                ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
                UnOp.getOperatorLoc()));
          }
        }
      }
      Expr /*P*/ SubExpr = $this().FixOverloadedFunctionReference(UnOp.getSubExpr(), 
          new DeclAccessPair(Found), Fn);
      if (SubExpr == UnOp.getSubExpr()) {
        return UnOp;
      }
      
      return /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new UnaryOperator(SubExpr, UnaryOperatorKind.UO_AddrOf, 
          $this().Context.getPointerType(SubExpr.getType()), 
          ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
          UnOp.getOperatorLoc()));
    }
  }
  {
    
    UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(E);
    if ((ULE != null)) {
      TemplateArgumentListInfo TemplateArgsBuffer = null;
      try {
        // FIXME: avoid copy.
        TemplateArgsBuffer/*J*/= new TemplateArgumentListInfo();
        TemplateArgumentListInfo /*P*/ TemplateArgs = null;
        if (ULE.hasExplicitTemplateArgs()) {
          ULE.copyTemplateArgumentsInto(TemplateArgsBuffer);
          TemplateArgs = $AddrOf(TemplateArgsBuffer);
        }
        
        DeclRefExpr /*P*/ DRE = DeclRefExpr.Create($this().Context, 
            ULE.getQualifierLoc(), 
            ULE.getTemplateKeywordLoc(), 
            Fn, 
            /*enclosing*/ false,  // FIXME?
            ULE.getNameLoc(), 
            Fn.getType(), 
            ExprValueKind.VK_LValue, 
            Found.getDecl(), 
            TemplateArgs);
        $this().MarkDeclRefReferenced(DRE);
        DRE.setHadMultipleCandidates($greater_uint(ULE.getNumDecls(), 1));
        return DRE;
      } finally {
        if (TemplateArgsBuffer != null) { TemplateArgsBuffer.$destroy(); }
      }
    }
  }
  {
    
    UnresolvedMemberExpr /*P*/ MemExpr = dyn_cast_UnresolvedMemberExpr(E);
    if ((MemExpr != null)) {
      TemplateArgumentListInfo TemplateArgsBuffer = null;
      try {
        // FIXME: avoid copy.
        TemplateArgsBuffer/*J*/= new TemplateArgumentListInfo();
        TemplateArgumentListInfo /*P*/ TemplateArgs = null;
        if (MemExpr.hasExplicitTemplateArgs()) {
          MemExpr.copyTemplateArgumentsInto(TemplateArgsBuffer);
          TemplateArgs = $AddrOf(TemplateArgsBuffer);
        }
        
        Expr /*P*/ Base;
        
        // If we're filling in a static method where we used to have an
        // implicit member access, rewrite to a simple decl ref.
        if (MemExpr.isImplicitAccess()) {
          if (cast_CXXMethodDecl(Fn).isStatic()) {
            DeclRefExpr /*P*/ DRE = DeclRefExpr.Create($this().Context, 
                MemExpr.getQualifierLoc(), 
                MemExpr.getTemplateKeywordLoc(), 
                Fn, 
                /*enclosing*/ false, 
                MemExpr.getMemberLoc(), 
                Fn.getType(), 
                ExprValueKind.VK_LValue, 
                Found.getDecl(), 
                TemplateArgs);
            $this().MarkDeclRefReferenced(DRE);
            DRE.setHadMultipleCandidates($greater_uint(MemExpr.getNumDecls(), 1));
            return DRE;
          } else {
            SourceLocation Loc = MemExpr.getMemberLoc();
            if ((MemExpr.getQualifier() != null)) {
              Loc.$assignMove(MemExpr.getQualifierLoc().getBeginLoc());
            }
            $this().CheckCXXThisCapture(new SourceLocation(Loc));
            Base = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXThisExpr(new SourceLocation(Loc), 
                MemExpr.getBaseType(), 
                /*isImplicit=*/ true));
          }
        } else {
          Base = MemExpr.getBase();
        }
        
        ExprValueKind valueKind;
        QualType type/*J*/= new QualType();
        if (cast_CXXMethodDecl(Fn).isStatic()) {
          valueKind = ExprValueKind.VK_LValue;
          type.$assignMove(Fn.getType());
        } else {
          valueKind = ExprValueKind.VK_RValue;
          type.$assignMove($this().Context.BoundMemberTy.$QualType());
        }
        
        MemberExpr /*P*/ ME = MemberExpr.Create($this().Context, Base, MemExpr.isArrow(), MemExpr.getOperatorLoc(), 
            MemExpr.getQualifierLoc(), MemExpr.getTemplateKeywordLoc(), Fn, new DeclAccessPair(Found), 
            new DeclarationNameInfo(MemExpr.getMemberNameInfo()), TemplateArgs, new QualType(type), valueKind, 
            ExprObjectKind.OK_Ordinary);
        ME.setHadMultipleCandidates(true);
        $this().MarkMemberReferenced(ME);
        return ME;
      } finally {
        if (TemplateArgsBuffer != null) { TemplateArgsBuffer.$destroy(); }
      }
    }
  }
  throw new llvm_unreachable("Invalid reference to overloaded function");
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::FixOverloadedFunctionReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 13132,
 FQN="clang::Sema::FixOverloadedFunctionReference", NM="_ZN5clang4Sema30FixOverloadedFunctionReferenceENS_12ActionResultIPNS_4ExprELb1EEENS_14DeclAccessPairEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema30FixOverloadedFunctionReferenceENS_12ActionResultIPNS_4ExprELb1EEENS_14DeclAccessPairEPNS_12FunctionDeclE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > FixOverloadedFunctionReference(ActionResultTTrue<Expr /*P*/ > E, 
                              DeclAccessPair Found, 
                              FunctionDecl /*P*/ Fn) {
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, $this().FixOverloadedFunctionReference(E.get(), new DeclAccessPair(Found), Fn));
}


/// \brief Add the overload candidates named by callee and/or found by argument
/// dependent lookup to the given overload set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::AddOverloadedCallCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10997,
 FQN="clang::Sema::AddOverloadedCallCandidates", NM="_ZN5clang4Sema27AddOverloadedCallCandidatesEPNS_20UnresolvedLookupExprEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema27AddOverloadedCallCandidatesEPNS_20UnresolvedLookupExprEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEb")
//</editor-fold>
public final void AddOverloadedCallCandidates(UnresolvedLookupExpr /*P*/ ULE, 
                           ArrayRef<Expr /*P*/ > Args, 
                           final OverloadCandidateSet /*&*/ CandidateSet) {
  AddOverloadedCallCandidates(ULE, 
                           Args, 
                           CandidateSet, 
                           false);
}
public final void AddOverloadedCallCandidates(UnresolvedLookupExpr /*P*/ ULE, 
                           ArrayRef<Expr /*P*/ > Args, 
                           final OverloadCandidateSet /*&*/ CandidateSet, 
                           boolean PartialOverloading/*= false*/) {
  TemplateArgumentListInfo TABuffer = null;
  try {
    // Verify that ArgumentDependentLookup is consistent with the rules
    // in C++0x [basic.lookup.argdep]p3:
    //
    //   Let X be the lookup set produced by unqualified lookup (3.4.1)
    //   and let Y be the lookup set produced by argument dependent
    //   lookup (defined as follows). If X contains
    //
    //     -- a declaration of a class member, or
    //
    //     -- a block-scope function declaration that is not a
    //        using-declaration, or
    //
    //     -- a declaration that is neither a function or a function
    //        template
    //
    //   then Y is empty.
    if (ULE.requiresADL()) {
      for (UnresolvedSetIterator I = ULE.decls_begin(), 
          E = ULE.decls_end(); I.$noteq(E); I.$preInc()) {
        assert (!(I.$star()).getDeclContext().isRecord());
        assert (isa_UsingShadowDecl(I.$star()) || !(I.$star()).getDeclContext().isFunctionOrMethod());
        assert ((I.$star()).getUnderlyingDecl().isFunctionOrFunctionTemplate());
      }
    }
    
    // It would be nice to avoid this copy.
    TABuffer/*J*/= new TemplateArgumentListInfo();
    TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs = null;
    if (ULE.hasExplicitTemplateArgs()) {
      ULE.copyTemplateArgumentsInto(TABuffer);
      ExplicitTemplateArgs = $AddrOf(TABuffer);
    }
    
    for (UnresolvedSetIterator I = ULE.decls_begin(), 
        E = ULE.decls_end(); I.$noteq(E); I.$preInc())  {
      AddOverloadedCallCandidate(/*Deref*/$this(), new DeclAccessPair(I.getPair()), ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), 
          CandidateSet, PartialOverloading, 
          /*KnownValid*/ true);
    }
    if (ULE.requiresADL()) {
      $this().AddArgumentDependentLookupCandidates(ULE.getName(), ULE.getExprLoc(), 
          new ArrayRef<Expr /*P*/ >(Args), ExplicitTemplateArgs, 
          CandidateSet, PartialOverloading);
    }
  } finally {
    if (TABuffer != null) { TABuffer.$destroy(); }
  }
}


/// Build a call to 'begin' or 'end' for a C++11 for-range statement. If the
/// given LookupResult is non-empty, it is assumed to describe a member which
/// will be invoked. Otherwise, the function will be found via argument
/// dependent lookup.
/// CallExpr is set to a valid expression and FRS_Success returned on success,
/// otherwise CallExpr is set to ExprError() and some non-success value
/// is returned.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildForRangeBeginEndCall">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 12905,
 FQN="clang::Sema::BuildForRangeBeginEndCall", NM="_ZN5clang4Sema25BuildForRangeBeginEndCallENS_14SourceLocationES1_RKNS_19DeclarationNameInfoERNS_12LookupResultEPNS_20OverloadCandidateSetEPNS_4ExprEPNS_12ActionResultISA_Lb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25BuildForRangeBeginEndCallENS_14SourceLocationES1_RKNS_19DeclarationNameInfoERNS_12LookupResultEPNS_20OverloadCandidateSetEPNS_4ExprEPNS_12ActionResultISA_Lb1EEE")
//</editor-fold>
public final Sema.ForRangeStatus BuildForRangeBeginEndCall(SourceLocation Loc, 
                         SourceLocation RangeLoc, 
                         final /*const*/ DeclarationNameInfo /*&*/ NameInfo, 
                         final LookupResult /*&*/ MemberLookup, 
                         OverloadCandidateSet /*P*/ CandidateSet, 
                         Expr /*P*/ Range, ActionResultTTrue<Expr /*P*/ > /*P*/ CallExpr) {
  Scope /*P*/ S = null;
  
  CandidateSet.clear();
  if (!MemberLookup.empty()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      ActionResultTTrue<Expr /*P*/ > MemberRef = $c$.clean($this().BuildMemberReferenceExpr2(Range, Range.getType(), new SourceLocation(Loc), 
          /*IsPtr=*/ false, $c$.track(new CXXScopeSpec()), 
          /*TemplateKWLoc=*/ new SourceLocation(), 
          /*FirstQualifierInScope=*/ (NamedDecl /*P*/ )null, 
          MemberLookup, 
          /*TemplateArgs=*/ (/*const*/ TemplateArgumentListInfo /*P*/ )null, S));
      if (MemberRef.isInvalid()) {
        /*Deref*/CallExpr.$assignMove(ExprError());
        return ForRangeStatus.FRS_DiagnosticIssued;
      }
      /*Deref*/CallExpr.$assignMove($this().ActOnCallExpr(S, MemberRef.get(), new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(None, true), new SourceLocation(Loc), (Expr /*P*/ )null));
      if (CallExpr.isInvalid()) {
        /*Deref*/CallExpr.$assignMove(ExprError());
        return ForRangeStatus.FRS_DiagnosticIssued;
      }
    } finally {
      $c$.$destroy();
    }
  } else {
    UnresolvedSet FoundNames/*J*/= new UnresolvedSet(0);
    UnresolvedLookupExpr /*P*/ Fn = UnresolvedLookupExpr.Create($this().Context, /*NamingClass=*/ (CXXRecordDecl /*P*/ )null, 
        new NestedNameSpecifierLoc(), NameInfo, 
        /*NeedsADL=*/ true, /*Overloaded=*/ false, 
        FoundNames.begin(), FoundNames.end());
    
    boolean CandidateSetError = $this().buildOverloadedCallSet(S, Fn, Fn, new MutableArrayRef<Expr /*P*/ >(Range, true), new SourceLocation(Loc), 
        CandidateSet, CallExpr);
    if (CandidateSet.empty() || CandidateSetError) {
      /*Deref*/CallExpr.$assignMove(ExprError());
      return ForRangeStatus.FRS_NoViableFunction;
    }
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    OverloadingResult OverloadResult = CandidateSet.BestViableFunction(/*Deref*/$this(), Fn.getLocStart(), Best);
    if (OverloadResult == OverloadingResult.OR_No_Viable_Function) {
      /*Deref*/CallExpr.$assignMove(ExprError());
      return ForRangeStatus.FRS_NoViableFunction;
    }
    /*Deref*/CallExpr.$assignMove(FinishOverloadedCallExpr(/*Deref*/$this(), S, Fn, Fn, new SourceLocation(Loc), new MutableArrayRef<Expr /*P*/ >(Range, true), 
            new SourceLocation(Loc), (Expr /*P*/ )null, CandidateSet, Best, 
            OverloadResult, 
            /*AllowTypoCorrection=*/ false));
    if (CallExpr.isInvalid() || OverloadResult != OverloadingResult.OR_Success) {
      /*Deref*/CallExpr.$assignMove(ExprError());
      return ForRangeStatus.FRS_DiagnosticIssued;
    }
  }
  return ForRangeStatus.FRS_Success;
}


/// BuildOverloadedCallExpr - Given the call expression that calls Fn
/// (which eventually refers to the declaration Func) and the call
/// arguments Args/NumArgs, attempt to resolve the function call down
/// to a specific function. If overload resolution succeeds, returns
/// the call expression produced by overload resolution.
/// Otherwise, emits diagnostics and returns ExprError.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildOverloadedCallExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11451,
 FQN="clang::Sema::BuildOverloadedCallExpr", NM="_ZN5clang4Sema23BuildOverloadedCallExprEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES7_S4_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema23BuildOverloadedCallExprEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES7_S4_bb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildOverloadedCallExpr(Scope /*P*/ S, Expr /*P*/ Fn, 
                       UnresolvedLookupExpr /*P*/ ULE, 
                       SourceLocation LParenLoc, 
                       MutableArrayRef<Expr /*P*/ > Args, 
                       SourceLocation RParenLoc, 
                       Expr /*P*/ ExecConfig) {
  return BuildOverloadedCallExpr(S, Fn, 
                       ULE, 
                       LParenLoc, 
                       Args, 
                       RParenLoc, 
                       ExecConfig, 
                       true, 
                       false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildOverloadedCallExpr(Scope /*P*/ S, Expr /*P*/ Fn, 
                       UnresolvedLookupExpr /*P*/ ULE, 
                       SourceLocation LParenLoc, 
                       MutableArrayRef<Expr /*P*/ > Args, 
                       SourceLocation RParenLoc, 
                       Expr /*P*/ ExecConfig, 
                       boolean AllowTypoCorrection/*= true*/) {
  return BuildOverloadedCallExpr(S, Fn, 
                       ULE, 
                       LParenLoc, 
                       Args, 
                       RParenLoc, 
                       ExecConfig, 
                       AllowTypoCorrection, 
                       false);
}
public final ActionResultTTrue<Expr /*P*/ > BuildOverloadedCallExpr(Scope /*P*/ S, Expr /*P*/ Fn, 
                       UnresolvedLookupExpr /*P*/ ULE, 
                       SourceLocation LParenLoc, 
                       MutableArrayRef<Expr /*P*/ > Args, 
                       SourceLocation RParenLoc, 
                       Expr /*P*/ ExecConfig, 
                       boolean AllowTypoCorrection/*= true*/, 
                       boolean CalleesAddressIsTaken/*= false*/) {
  OverloadCandidateSet CandidateSet = null;
  try {
    CandidateSet/*J*/= new OverloadCandidateSet(Fn.getExprLoc(), 
        OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    ActionResultTTrue<Expr /*P*/ > result/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ($this().buildOverloadedCallSet(S, Fn, ULE, new MutableArrayRef<Expr /*P*/ >(Args), new SourceLocation(LParenLoc), $AddrOf(CandidateSet), 
        $AddrOf(result))) {
      return result;
    }
    
    // If the user handed us something like `(&Foo)(Bar)`, we need to ensure that
    // functions that aren't addressible are considered unviable.
    if (CalleesAddressIsTaken) {
      markUnaddressableCandidatesUnviable(/*Deref*/$this(), CandidateSet);
    }
    
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    OverloadingResult OverloadResult = CandidateSet.BestViableFunction(/*Deref*/$this(), Fn.getLocStart(), Best);
    
    return FinishOverloadedCallExpr(/*Deref*/$this(), S, Fn, ULE, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(Args), 
        new SourceLocation(RParenLoc), ExecConfig, $AddrOf(CandidateSet), 
        Best, OverloadResult, 
        AllowTypoCorrection);
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}


/// \brief Constructs and populates an OverloadedCandidateSet from
/// the given function.
/// \returns true when an the ExprResult output parameter has been set.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::buildOverloadedCallSet">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11284,
 FQN="clang::Sema::buildOverloadedCallSet", NM="_ZN5clang4Sema22buildOverloadedCallSetEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprEN4llvm15MutableArrayRefIS4_EENS_14SourceLocationEPNS_20OverloadCandidateSetEPNS_12ActionResultIS4_Lb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema22buildOverloadedCallSetEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprEN4llvm15MutableArrayRefIS4_EENS_14SourceLocationEPNS_20OverloadCandidateSetEPNS_12ActionResultIS4_Lb1EEE")
//</editor-fold>
public final boolean buildOverloadedCallSet(Scope /*P*/ S, Expr /*P*/ Fn, 
                      UnresolvedLookupExpr /*P*/ ULE, 
                      MutableArrayRef<Expr /*P*/ > Args, 
                      SourceLocation RParenLoc, 
                      OverloadCandidateSet /*P*/ CandidateSet, 
                      ActionResultTTrue<Expr /*P*/ > /*P*/ Result) {
  UnbridgedCastsSet UnbridgedCasts = null;
  try {
    if (ULE.requiresADL()) {
      // To do ADL, we must have found an unqualified name.
      assert (!(ULE.getQualifier() != null)) : "qualified name with ADL";
      
      // We don't perform ADL for implicit declarations of builtins.
      // Verify that this was correctly set up.
      FunctionDecl /*P*/ F;
      if (ULE.decls_begin().$add(1).$eq(ULE.decls_end())
         && ((F = dyn_cast_FunctionDecl(ULE.decls_begin().$star())) != null)
         && (F.getBuiltinID() != 0) && F.isImplicit()) {
        throw new llvm_unreachable("performing ADL for builtin");
      }
      
      // We don't perform ADL in C.
      assert ($this().getLangOpts().CPlusPlus) : "ADL enabled in C";
    }
    
    UnbridgedCasts/*J*/= new UnbridgedCastsSet();
    if (checkArgPlaceholdersForOverload(/*Deref*/$this(), new MutableArrayRef<Expr /*P*/ >(Args), UnbridgedCasts)) {
      /*Deref*/Result.$assignMove(ExprError());
      return true;
    }
    
    // Add the functions denoted by the callee to the set of candidate
    // functions, including those from argument-dependent lookup.
    $this().AddOverloadedCallCandidates(ULE, new ArrayRef<Expr /*P*/ >(Args), $Deref(CandidateSet));
    if ($this().getLangOpts().MSVCCompat
       && $this().CurContext.isDependentContext() && !$this().isSFINAEContext().$bool()
       && (isa_FunctionDecl($this().CurContext) || isa_CXXRecordDecl($this().CurContext))) {
      
      type$ptr<OverloadCandidate> Best = create_type$ptr();
      if (CandidateSet.empty()
         || CandidateSet.BestViableFunction(/*Deref*/$this(), Fn.getLocStart(), Best)
         == OverloadingResult.OR_No_Viable_Function) {
        // In Microsoft mode, if we are inside a template class member function then
        // create a type dependent CallExpr. The goal is to postpone name lookup
        // to instantiation time to be able to search into type dependent base
        // classes.
        CallExpr /*P*/ CE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CallExpr($this().Context, Fn, new ArrayRef<Expr /*P*/ >(Args), $this().Context.DependentTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(RParenLoc)));
        CE.setTypeDependent(true);
        CE.setValueDependent(true);
        CE.setInstantiationDependent(true);
        /*Deref*/Result.$assign(CE);
        return true;
      }
    }
    if (CandidateSet.empty()) {
      return false;
    }
    
    UnbridgedCasts.restore();
    return false;
  } finally {
    if (UnbridgedCasts != null) { UnbridgedCasts.$destroy(); }
  }
}


/// \brief Create a unary operation that may resolve to an overloaded
/// operator.
///
/// \param OpLoc The location of the operator itself (e.g., '*').
///
/// \param Opc The UnaryOperatorKind that describes this operator.
///
/// \param Fns The set of non-member functions that will be
/// considered by overload resolution. The caller needs to build this
/// set based on the context using, e.g.,
/// LookupOverloadedOperatorName() and ArgumentDependentLookup(). This
/// set should not contain any member functions; those will be added
/// by CreateOverloadedUnaryOp().
///
/// \param Input The input argument.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateOverloadedUnaryOp">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11502,
 FQN="clang::Sema::CreateOverloadedUnaryOp", NM="_ZN5clang4Sema23CreateOverloadedUnaryOpENS_14SourceLocationENS_17UnaryOperatorKindERKNS_17UnresolvedSetImplEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema23CreateOverloadedUnaryOpENS_14SourceLocationENS_17UnaryOperatorKindERKNS_17UnresolvedSetImplEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateOverloadedUnaryOp(SourceLocation OpLoc, UnaryOperatorKind Opc, 
                       final /*const*/ UnresolvedSetImpl /*&*/ Fns, 
                       Expr /*P*/ _Input) {
  type$ref<Expr /*P*/> Input = create_type$ref(_Input);
  OverloadCandidateSet CandidateSet = null;
  try {
    OverloadedOperatorKind Op = UnaryOperator.getOverloadedOperator(Opc);
    assert (Op != OverloadedOperatorKind.OO_None) : "Invalid opcode for overloaded unary operator";
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(Op);
    // TODO: provide better source location info.
    DeclarationNameInfo OpNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(OpLoc));
    if (checkPlaceholderForOverload(/*Deref*/$this(), Input)) {
      return ExprError();
    }
    
    Expr /*P*/ Args[/*2*/] = new Expr /*P*/  [/*2*/] {Input.$deref(), (Expr /*P*/ )null};
    /*uint*/int NumArgs = 1;
    
    // For post-increment and post-decrement, add the implicit '0' as
    // the second argument, so that we know this is a post-increment or
    // post-decrement.
    if (Opc == UnaryOperatorKind.UO_PostInc || Opc == UnaryOperatorKind.UO_PostDec) {
      APSInt Zero/*J*/= new APSInt($ulong2uint($this().Context.getTypeSize($this().Context.IntTy.$QualType())), false);
      Args[1] = IntegerLiteral.Create($this().Context, Zero, $this().Context.IntTy.$QualType(), 
          new SourceLocation());
      NumArgs = 2;
    }
    
    ArrayRef<Expr /*P*/ > ArgsArray/*J*/= new ArrayRef<Expr /*P*/ >(create_type$ptr(Args), NumArgs, true);
    if (Input.$deref().isTypeDependent()) {
      if (Fns.empty()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new UnaryOperator(Input.$deref(), Opc, $this().Context.DependentTy.$QualType(), 
                ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, new SourceLocation(OpLoc))));
      }
      
      CXXRecordDecl /*P*/ NamingClass = null; // lookup ignores member operators
      UnresolvedLookupExpr /*P*/ Fn = UnresolvedLookupExpr.Create($this().Context, NamingClass, 
          new NestedNameSpecifierLoc(), OpNameInfo, 
          /*ADL*/ true, IsOverloaded(Fns), 
          Fns.begin$Const(), Fns.end$Const());
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, Op, Fn, new ArrayRef<Expr /*P*/ >(ArgsArray), $this().Context.DependentTy.$QualType(), 
              ExprValueKind.VK_RValue, new SourceLocation(OpLoc), false)));
    }
    
    // Build an empty overload set.
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(OpLoc), OverloadCandidateSet.CandidateSetKind.CSK_Operator);
    
    // Add the candidates from the given function set.
    $this().AddFunctionCandidates(Fns, new ArrayRef<Expr /*P*/ >(ArgsArray), CandidateSet);
    
    // Add operator candidates that are member functions.
    $this().AddMemberOperatorCandidates(Op, new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(ArgsArray), CandidateSet);
    
    // Add candidates from ADL.
    $this().AddArgumentDependentLookupCandidates(new DeclarationName(OpName), new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(ArgsArray), 
        /*ExplicitTemplateArgs*/ (TemplateArgumentListInfo /*P*/ )null, 
        CandidateSet);
    
    // Add builtin operator candidates.
    $this().AddBuiltinOperatorCandidates(Op, new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(ArgsArray), CandidateSet);
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    // Perform overload resolution.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(/*Deref*/$this(), new SourceLocation(OpLoc), Best)) {
     case OR_Success:
      {
        // We found a built-in operator or an overloaded operator.
        FunctionDecl /*P*/ FnDecl = Best./*->*/$star().Function;
        if ((FnDecl != null)) {
          {
            // We matched an overloaded operator. Build a call to that
            // operator.
            
            // Convert the arguments.
            CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(FnDecl);
            if ((Method != null)) {
              $this().CheckMemberOperatorAccess(new SourceLocation(OpLoc), Args[0], (Expr /*P*/ )null, new DeclAccessPair(Best./*->*/$star().FoundDecl));
              
              ActionResultTTrue<Expr /*P*/ > InputRes = $this().PerformObjectArgumentInitialization(Input.$deref(), /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
                  Best./*->*/$star().FoundDecl.$NamedDecl$P(), Method);
              if (InputRes.isInvalid()) {
                return ExprError();
              }
              Input.$set(InputRes.get());
            } else {
              // Convert the arguments.
              ActionResultTTrue<Expr /*P*/ > InputInit = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                      FnDecl.getParamDecl(0)), 
                  new SourceLocation(), 
                  new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Input.$deref()));
              if (InputInit.isInvalid()) {
                return ExprError();
              }
              Input.$set(InputInit.get());
            }
          }
          
          // Build the actual expression node.
          ActionResultTTrue<Expr /*P*/ > FnExpr = CreateFunctionRefExpr(/*Deref*/$this(), FnDecl, Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
              HadMultipleCandidates, new SourceLocation(OpLoc));
          if (FnExpr.isInvalid()) {
            return ExprError();
          }
          
          // Determine the result type.
          QualType ResultTy = FnDecl.getReturnType();
          ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultTy));
          ResultTy.$assignMove(ResultTy.getNonLValueExprType($this().Context));
          
          Args[0] = Input.$deref();
          CallExpr /*P*/ TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, Op, FnExpr.get(), new ArrayRef<Expr /*P*/ >(ArgsArray), 
              new QualType(ResultTy), VK, new SourceLocation(OpLoc), false));
          if ($this().CheckCallReturnType(FnDecl.getReturnType(), new SourceLocation(OpLoc), TheCall, FnDecl)) {
            return ExprError();
          }
          
          return $this().MaybeBindToTemporary(TheCall);
        } else {
          // We matched a built-in operator. Convert the arguments, then
          // break out so that we will build the appropriate built-in
          // operator node.
          ActionResultTTrue<Expr /*P*/ > InputRes = $this().PerformImplicitConversion(Input.$deref(), new QualType(Best./*->*/$star().BuiltinTypes.ParamTypes[0]), 
              Best./*->*/$star().Conversions[0], AssignmentAction.AA_Passing);
          if (InputRes.isInvalid()) {
            return ExprError();
          }
          Input.$set(InputRes.get());
          break;
        }
      }
     case OR_No_Viable_Function:
      // This is an erroneous use of an operator which can be overloaded by
      // a non-member function. Check for non-member operators which were
      // defined too late to be candidates.
      if (DiagnoseTwoPhaseOperatorLookup(/*Deref*/$this(), Op, new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(ArgsArray))) {
        // FIXME: Recover by calling the found function.
        return ExprError();
      }
      
      // No viable function; fall through to handling this as a
      // built-in operator, which will produce an error message for us.
      break;
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_ambiguous_oper_unary)), 
                      UnaryOperator.getOpcodeStr(Opc)), 
                  Input.$deref().getType()), 
              Input.$deref().getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(ArgsArray), 
              UnaryOperator.getOpcodeStr(Opc), new SourceLocation(OpLoc));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_deleted_oper)), 
                          Best./*->*/$star().Function.isDeleted()), 
                      UnaryOperator.getOpcodeStr(Opc)), 
                  $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
              Input.$deref().getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(ArgsArray), 
              UnaryOperator.getOpcodeStr(Opc), new SourceLocation(OpLoc));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Either we found no viable overloaded operator or we matched a
    // built-in operator. In either case, fall through to trying to
    // build a built-in operation.
    return $this().CreateBuiltinUnaryOp(new SourceLocation(OpLoc), Opc, Input.$deref());
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}


/// \brief Create a binary operation that may resolve to an overloaded
/// operator.
///
/// \param OpLoc The location of the operator itself (e.g., '+').
///
/// \param Opc The BinaryOperatorKind that describes this operator.
///
/// \param Fns The set of non-member functions that will be
/// considered by overload resolution. The caller needs to build this
/// set based on the context using, e.g.,
/// LookupOverloadedOperatorName() and ArgumentDependentLookup(). This
/// set should not contain any member functions; those will be added
/// by CreateOverloadedBinOp().
///
/// \param LHS Left-hand argument.
/// \param RHS Right-hand argument.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateOverloadedBinOp">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11687,
 FQN="clang::Sema::CreateOverloadedBinOp", NM="_ZN5clang4Sema21CreateOverloadedBinOpENS_14SourceLocationENS_18BinaryOperatorKindERKNS_17UnresolvedSetImplEPNS_4ExprES7_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema21CreateOverloadedBinOpENS_14SourceLocationENS_18BinaryOperatorKindERKNS_17UnresolvedSetImplEPNS_4ExprES7_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateOverloadedBinOp(SourceLocation OpLoc, 
                     BinaryOperatorKind Opc, 
                     final /*const*/ UnresolvedSetImpl /*&*/ Fns, 
                     Expr /*P*/ LHS, Expr /*P*/ RHS) {
  OverloadCandidateSet CandidateSet = null;
  try {
    Expr /*P*/ Args[/*2*/] = new Expr /*P*/  [/*2*/] {LHS, RHS};
    LHS = RHS = null; // Please use only Args instead of LHS/RHS couple
    
    OverloadedOperatorKind Op = BinaryOperator.getOverloadedOperator(Opc);
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(Op);
    
    // If either side is type-dependent, create an appropriate dependent
    // expression.
    if (Args[0].isTypeDependent() || Args[1].isTypeDependent()) {
      if (Fns.empty()) {
        // If there are no functions to store, just build a dependent
        // BinaryOperator or CompoundAssignment.
        if (Opc.getValue() <= BinaryOperatorKind.BO_Assign.getValue() || Opc.getValue() > BinaryOperatorKind.BO_OrAssign.getValue()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new BinaryOperator(Args[0], Args[1], Opc, $this().Context.DependentTy.$QualType(), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary, 
                  new SourceLocation(OpLoc), $this().FPFeatures.fp_contract)));
        }
        
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CompoundAssignOperator(Args[0], Args[1], Opc, $this().Context.DependentTy.$QualType(), ExprValueKind.VK_LValue, ExprObjectKind.OK_Ordinary, 
                $this().Context.DependentTy.$QualType(), $this().Context.DependentTy.$QualType(), new SourceLocation(OpLoc), 
                $this().FPFeatures.fp_contract)));
      }
      
      // FIXME: save results of ADL from here?
      CXXRecordDecl /*P*/ NamingClass = null; // lookup ignores member operators
      // TODO: provide better source location info in DNLoc component.
      DeclarationNameInfo OpNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(OpLoc));
      UnresolvedLookupExpr /*P*/ Fn = UnresolvedLookupExpr.Create($this().Context, NamingClass, 
          new NestedNameSpecifierLoc(), OpNameInfo, 
          /*ADL*/ true, IsOverloaded(Fns), 
          Fns.begin$Const(), Fns.end$Const());
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, Op, Fn, new ArrayRef<Expr /*P*/ >(Args, true), $this().Context.DependentTy.$QualType(), 
              ExprValueKind.VK_RValue, new SourceLocation(OpLoc), $this().FPFeatures.fp_contract)));
    }
    
    // Always do placeholder-like conversions on the RHS.
    if (checkPlaceholderForOverload(/*Deref*/$this(), create_type$ptr(Args).$add(1).star$ref())) {
      return ExprError();
    }
            
    // Do placeholder-like conversion on the LHS; note that we should
    // not get here with a PseudoObject LHS.
    assert (Args[0].getObjectKind() != ExprObjectKind.OK_ObjCProperty);
    if (checkPlaceholderForOverload(/*Deref*/$this(), create_type$ptr(Args).star$ref())) {
      return ExprError();
    }
    
    // If this is the assignment operator, we only perform overload resolution
    // if the left-hand side is a class or enumeration type. This is actually
    // a hack. The standard requires that we do overload resolution between the
    // various built-in candidates, but as DR507 points out, this can lead to
    // problems. So we do it this way, which pretty much follows what GCC does.
    // Note that we go the traditional code path for compound assignment forms.
    if (Opc == BinaryOperatorKind.BO_Assign && !Args[0].getType().$arrow().isOverloadableType()) {
      return $this().CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, Args[0], Args[1]);
    }
    
    // If this is the .* operator, which is not overloadable, just
    // create a built-in binary operator.
    if (Opc == BinaryOperatorKind.BO_PtrMemD) {
      return $this().CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, Args[0], Args[1]);
    }
    
    // Build an empty overload set.
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(OpLoc), OverloadCandidateSet.CandidateSetKind.CSK_Operator);
    
    // Add the candidates from the given function set.
    $this().AddFunctionCandidates(Fns, new ArrayRef<Expr /*P*/ >(Args, true), CandidateSet);
    
    // Add operator candidates that are member functions.
    $this().AddMemberOperatorCandidates(Op, new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(Args, true), CandidateSet);
    
    // Add candidates from ADL. Per [over.match.oper]p2, this lookup is not
    // performed for an assignment operator (nor for operator[] nor operator->,
    // which don't get here).
    if (Opc != BinaryOperatorKind.BO_Assign) {
      $this().AddArgumentDependentLookupCandidates(new DeclarationName(OpName), new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(Args, true), 
          /*ExplicitTemplateArgs*/ (TemplateArgumentListInfo /*P*/ )null, 
          CandidateSet);
    }
    
    // Add builtin operator candidates.
    $this().AddBuiltinOperatorCandidates(Op, new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(Args, true), CandidateSet);
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    // Perform overload resolution.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(/*Deref*/$this(), new SourceLocation(OpLoc), Best)) {
     case OR_Success:
      {
        // We found a built-in operator or an overloaded operator.
        FunctionDecl /*P*/ FnDecl = Best./*->*/$star().Function;
        if ((FnDecl != null)) {
          {
            // We matched an overloaded operator. Build a call to that
            // operator.
            
            // Convert the arguments.
            CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(FnDecl);
            if ((Method != null)) {
              // Best->Access is only meaningful for class members.
              $this().CheckMemberOperatorAccess(new SourceLocation(OpLoc), Args[0], Args[1], new DeclAccessPair(Best./*->*/$star().FoundDecl));
              
              ActionResultTTrue<Expr /*P*/ > Arg1 = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                      FnDecl.getParamDecl(0)), 
                  new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args[1]));
              if (Arg1.isInvalid()) {
                return ExprError();
              }
              
              ActionResultTTrue<Expr /*P*/ > Arg0 = $this().PerformObjectArgumentInitialization(Args[0], /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
                  Best./*->*/$star().FoundDecl.$NamedDecl$P(), Method);
              if (Arg0.isInvalid()) {
                return ExprError();
              }
              Args[0] = Arg0.getAs(Expr.class);
              Args[1] = RHS = Arg1.getAs(Expr.class);
            } else {
              // Convert the arguments.
              ActionResultTTrue<Expr /*P*/ > Arg0 = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                      FnDecl.getParamDecl(0)), 
                  new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args[0]));
              if (Arg0.isInvalid()) {
                return ExprError();
              }
              
              ActionResultTTrue<Expr /*P*/ > Arg1 = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                      FnDecl.getParamDecl(1)), 
                  new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args[1]));
              if (Arg1.isInvalid()) {
                return ExprError();
              }
              Args[0] = LHS = Arg0.getAs(Expr.class);
              Args[1] = RHS = Arg1.getAs(Expr.class);
            }
          }
          
          // Build the actual expression node.
          ActionResultTTrue<Expr /*P*/ > FnExpr = CreateFunctionRefExpr(/*Deref*/$this(), FnDecl, 
              Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
              HadMultipleCandidates, new SourceLocation(OpLoc));
          if (FnExpr.isInvalid()) {
            return ExprError();
          }
          
          // Determine the result type.
          QualType ResultTy = FnDecl.getReturnType();
          ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultTy));
          ResultTy.$assignMove(ResultTy.getNonLValueExprType($this().Context));
          
          CXXOperatorCallExpr /*P*/ TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, Op, FnExpr.get(), 
              new ArrayRef<Expr /*P*/ >(Args, true), new QualType(ResultTy), VK, new SourceLocation(OpLoc), 
              $this().FPFeatures.fp_contract));
          if ($this().CheckCallReturnType(FnDecl.getReturnType(), new SourceLocation(OpLoc), TheCall, 
              FnDecl)) {
            return ExprError();
          }
          
          ArrayRef</*const*/ Expr /*P*/ > ArgsArray/*J*/= new ArrayRef</*const*/ Expr /*P*/ >(create_type$ptr(Args), 2, true);
          // Cut off the implicit 'this'.
          if (isa_CXXMethodDecl(FnDecl)) {
            ArgsArray.$assignMove(ArgsArray.slice(1));
          }
          
          // Check for a self move.
          if (Op == OverloadedOperatorKind.OO_Equal) {
            $this().DiagnoseSelfMove(Args[0], Args[1], new SourceLocation(OpLoc));
          }
          
          $this().checkCall(FnDecl, (/*const*/ FunctionProtoType /*P*/ )null, new ArrayRef</*const*/ Expr /*P*/ >(ArgsArray), isa_CXXMethodDecl(FnDecl), new SourceLocation(OpLoc), 
              TheCall.getSourceRange(), VariadicCallType.VariadicDoesNotApply);
          
          return $this().MaybeBindToTemporary(TheCall);
        } else {
          // We matched a built-in operator. Convert the arguments, then
          // break out so that we will build the appropriate built-in
          // operator node.
          ActionResultTTrue<Expr /*P*/ > ArgsRes0 = $this().PerformImplicitConversion(Args[0], new QualType(Best./*->*/$star().BuiltinTypes.ParamTypes[0]), 
              Best./*->*/$star().Conversions[0], AssignmentAction.AA_Passing);
          if (ArgsRes0.isInvalid()) {
            return ExprError();
          }
          Args[0] = ArgsRes0.get();
          
          ActionResultTTrue<Expr /*P*/ > ArgsRes1 = $this().PerformImplicitConversion(Args[1], new QualType(Best./*->*/$star().BuiltinTypes.ParamTypes[1]), 
              Best./*->*/$star().Conversions[1], AssignmentAction.AA_Passing);
          if (ArgsRes1.isInvalid()) {
            return ExprError();
          }
          Args[1] = ArgsRes1.get();
          break;
        }
      }
     case OR_No_Viable_Function:
      {
        // C++ [over.match.oper]p9:
        //   If the operator is the operator , [...] and there are no
        //   viable functions, then the operator is assumed to be the
        //   built-in operator and interpreted according to clause 5.
        if (Opc == BinaryOperatorKind.BO_Comma) {
          break;
        }
        
        // For class as left operand for assignment or compound assigment
        // operator do not fall through to handling in built-in, but report that
        // no overloaded assignment operator found
        ActionResultTTrue<Expr /*P*/ > Result = ExprError();
        if (Args[0].getType().$arrow().isRecordType()
           && Opc.getValue() >= BinaryOperatorKind.BO_Assign.getValue() && Opc.getValue() <= BinaryOperatorKind.BO_OrAssign.getValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_no_viable_oper)), 
                        BinaryOperator.getOpcodeStr(Opc)), 
                    Args[0].getSourceRange()), Args[1].getSourceRange()));
            if (Args[0].getType().$arrow().isIncompleteType()) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.note_assign_lhs_incomplete)), 
                          Args[0].getType()), 
                      Args[0].getSourceRange()), Args[1].getSourceRange()));
            }
          } finally {
            $c$.$destroy();
          }
        } else {
          // This is an erroneous use of an operator which can be overloaded by
          // a non-member function. Check for non-member operators which were
          // defined too late to be candidates.
          if (DiagnoseTwoPhaseOperatorLookup(/*Deref*/$this(), Op, new SourceLocation(OpLoc), new ArrayRef<Expr /*P*/ >(Args, true))) {
            // FIXME: Recover by calling the found function.
            return ExprError();
          }
          
          // No viable function; try to create a built-in operation, which will
          // produce an error. Then, show the non-viable candidates.
          Result.$assignMove($this().CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, Args[0], Args[1]));
        }
        assert (Result.isInvalid()) : "C++ binary operator overloading is missing candidates!";
        if (Result.isInvalid()) {
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args, true), 
              BinaryOperator.getOpcodeStr(Opc), new SourceLocation(OpLoc));
        }
        return Result;
      }
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_ambiguous_oper_binary)), 
                              BinaryOperator.getOpcodeStr(Opc)), 
                          Args[0].getType()), Args[1].getType()), 
                  Args[0].getSourceRange()), Args[1].getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args, true), 
              BinaryOperator.getOpcodeStr(Opc), new SourceLocation(OpLoc));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      if ($this().isImplicitlyDeleted(Best./*->*/$star().Function)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          CXXMethodDecl /*P*/ Method = cast_CXXMethodDecl(Best./*->*/$star().Function);
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_deleted_special_oper)), 
                  $this().Context.getRecordType(Method.getParent())), 
              $this().getSpecialMember(Method)));
          
          // The user probably meant to call this special member. Just
          // explain why it's deleted.
          $this().NoteDeletedFunction(Method);
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_deleted_oper)), 
                              Best./*->*/$star().Function.isDeleted()), 
                          BinaryOperator.getOpcodeStr(Opc)), 
                      $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
                  Args[0].getSourceRange()), Args[1].getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args, true), 
          BinaryOperator.getOpcodeStr(Opc), new SourceLocation(OpLoc));
      return ExprError();
    }
    
    // We matched a built-in operator; build it.
    return $this().CreateBuiltinBinOp(new SourceLocation(OpLoc), Opc, Args[0], Args[1]);
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CreateOverloadedArraySubscriptExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11959,
 FQN="clang::Sema::CreateOverloadedArraySubscriptExpr", NM="_ZN5clang4Sema34CreateOverloadedArraySubscriptExprENS_14SourceLocationES1_PNS_4ExprES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema34CreateOverloadedArraySubscriptExprENS_14SourceLocationES1_PNS_4ExprES3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CreateOverloadedArraySubscriptExpr(SourceLocation LLoc, 
                                  SourceLocation RLoc, 
                                  Expr /*P*/ Base, Expr /*P*/ Idx) {
  OverloadCandidateSet CandidateSet = null;
  try {
    Expr /*P*/ Args[/*2*/] = new Expr /*P*/  [/*2*/] {Base, Idx};
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Subscript);
    
    // If either side is type-dependent, create an appropriate dependent
    // expression.
    if (Args[0].isTypeDependent() || Args[1].isTypeDependent()) {
      
      CXXRecordDecl /*P*/ NamingClass = null; // lookup ignores member operators
      // CHECKME: no 'operator' keyword?
      DeclarationNameInfo OpNameInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(LLoc));
      OpNameInfo.setCXXOperatorNameRange(new SourceRange(/*NO_COPY*/LLoc, /*NO_COPY*/RLoc));
      UnresolvedLookupExpr /*P*/ Fn = UnresolvedLookupExpr.Create($this().Context, NamingClass, 
          new NestedNameSpecifierLoc(), OpNameInfo, 
          /*ADL*/ true, /*Overloaded*/ false, 
          new UnresolvedSetIterator(), 
          new UnresolvedSetIterator());
      // Can't add any actual overloads yet
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, OverloadedOperatorKind.OO_Subscript, Fn, new ArrayRef<Expr /*P*/ >(Args, true), 
              $this().Context.DependentTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(RLoc), false)));
    }
    
    // Handle placeholders on both operands.
    if (checkPlaceholderForOverload(/*Deref*/$this(), create_type$ptr(Args).star$ref())) {
      return ExprError();
    }
    if (checkPlaceholderForOverload(/*Deref*/$this(), create_type$ptr(Args).$add(1).star$ref())) {
      return ExprError();
    }
    
    // Build an empty overload set.
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(LLoc), OverloadCandidateSet.CandidateSetKind.CSK_Operator);
    
    // Subscript can only be overloaded as a member function.
    
    // Add operator candidates that are member functions.
    $this().AddMemberOperatorCandidates(OverloadedOperatorKind.OO_Subscript, new SourceLocation(LLoc), new ArrayRef<Expr /*P*/ >(Args, true), CandidateSet);
    
    // Add builtin operator candidates.
    $this().AddBuiltinOperatorCandidates(OverloadedOperatorKind.OO_Subscript, new SourceLocation(LLoc), new ArrayRef<Expr /*P*/ >(Args, true), CandidateSet);
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    // Perform overload resolution.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(/*Deref*/$this(), new SourceLocation(LLoc), Best)) {
     case OR_Success:
      {
        // We found a built-in operator or an overloaded operator.
        FunctionDecl /*P*/ FnDecl = Best./*->*/$star().Function;
        if ((FnDecl != null)) {
          // We matched an overloaded operator. Build a call to that
          // operator.
          $this().CheckMemberOperatorAccess(new SourceLocation(LLoc), Args[0], Args[1], new DeclAccessPair(Best./*->*/$star().FoundDecl));
          
          // Convert the arguments.
          CXXMethodDecl /*P*/ Method = cast_CXXMethodDecl(FnDecl);
          ActionResultTTrue<Expr /*P*/ > Arg0 = $this().PerformObjectArgumentInitialization(Args[0], /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
              Best./*->*/$star().FoundDecl.$NamedDecl$P(), Method);
          if (Arg0.isInvalid()) {
            return ExprError();
          }
          Args[0] = Arg0.get();
          
          // Convert the arguments.
          ActionResultTTrue<Expr /*P*/ > InputInit = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                  FnDecl.getParamDecl(0)), 
              new SourceLocation(), 
              new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args[1]));
          if (InputInit.isInvalid()) {
            return ExprError();
          }
          
          Args[1] = InputInit.getAs(Expr.class);
          
          // Build the actual expression node.
          DeclarationNameInfo OpLocInfo/*J*/= new DeclarationNameInfo(new DeclarationName(OpName), new SourceLocation(LLoc));
          OpLocInfo.setCXXOperatorNameRange(new SourceRange(/*NO_COPY*/LLoc, /*NO_COPY*/RLoc));
          ActionResultTTrue<Expr /*P*/ > FnExpr = CreateFunctionRefExpr(/*Deref*/$this(), FnDecl, 
              Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
              HadMultipleCandidates, 
              OpLocInfo.getLoc(), 
              OpLocInfo.getInfo());
          if (FnExpr.isInvalid()) {
            return ExprError();
          }
          
          // Determine the result type
          QualType ResultTy = FnDecl.getReturnType();
          ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultTy));
          ResultTy.$assignMove(ResultTy.getNonLValueExprType($this().Context));
          
          CXXOperatorCallExpr /*P*/ TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, OverloadedOperatorKind.OO_Subscript, 
              FnExpr.get(), new ArrayRef<Expr /*P*/ >(Args, true), 
              new QualType(ResultTy), VK, new SourceLocation(RLoc), 
              false));
          if ($this().CheckCallReturnType(FnDecl.getReturnType(), new SourceLocation(LLoc), TheCall, FnDecl)) {
            return ExprError();
          }
          
          return $this().MaybeBindToTemporary(TheCall);
        } else {
          // We matched a built-in operator. Convert the arguments, then
          // break out so that we will build the appropriate built-in
          // operator node.
          ActionResultTTrue<Expr /*P*/ > ArgsRes0 = $this().PerformImplicitConversion(Args[0], new QualType(Best./*->*/$star().BuiltinTypes.ParamTypes[0]), 
              Best./*->*/$star().Conversions[0], AssignmentAction.AA_Passing);
          if (ArgsRes0.isInvalid()) {
            return ExprError();
          }
          Args[0] = ArgsRes0.get();
          
          ActionResultTTrue<Expr /*P*/ > ArgsRes1 = $this().PerformImplicitConversion(Args[1], new QualType(Best./*->*/$star().BuiltinTypes.ParamTypes[1]), 
              Best./*->*/$star().Conversions[1], AssignmentAction.AA_Passing);
          if (ArgsRes1.isInvalid()) {
            return ExprError();
          }
          Args[1] = ArgsRes1.get();
          
          break;
        }
      }
     case OR_No_Viable_Function:
      {
        if (CandidateSet.empty()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_ovl_no_oper)), 
                            Args[0].getType()), /*subscript*/ 0), 
                    Args[0].getSourceRange()), Args[1].getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_ovl_no_viable_subscript)), 
                        Args[0].getType()), 
                    Args[0].getSourceRange()), Args[1].getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args, true), 
            new StringRef(/*KEEP_STR*/$LSQUARE_RSQUARE), new SourceLocation(LLoc));
        return ExprError();
      }
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_ovl_ambiguous_oper_binary)), 
                              /*KEEP_STR*/"[]"), 
                          Args[0].getType()), Args[1].getType()), 
                  Args[0].getSourceRange()), Args[1].getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args, true), 
              new StringRef(/*KEEP_STR*/$LSQUARE_RSQUARE), new SourceLocation(LLoc));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LLoc), diag.err_ovl_deleted_oper)), 
                              Best./*->*/$star().Function.isDeleted()), /*KEEP_STR*/"[]"), 
                      $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
                  Args[0].getSourceRange()), Args[1].getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args, true), 
              new StringRef(/*KEEP_STR*/$LSQUARE_RSQUARE), new SourceLocation(LLoc));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // We matched a built-in operator; build it.
    return $this().CreateBuiltinArraySubscriptExpr(Args[0], new SourceLocation(LLoc), Args[1], new SourceLocation(RLoc));
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}


/// BuildCallToMemberFunction - Build a call to a member
/// function. MemExpr is the expression that refers to the member
/// function (and includes the object parameter), Args/NumArgs are the
/// arguments to the function call (not including the object
/// parameter). The caller needs to validate that the member
/// expression refers to a non-static member function or an overloaded
/// member function.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCallToMemberFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 12133,
 FQN="clang::Sema::BuildCallToMemberFunction", NM="_ZN5clang4Sema25BuildCallToMemberFunctionEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25BuildCallToMemberFunctionEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCallToMemberFunction(Scope /*P*/ S, Expr /*P*/ MemExprE, 
                         SourceLocation LParenLoc, 
                         MutableArrayRef<Expr /*P*/ > Args, 
                         SourceLocation RParenLoc) {
  UnbridgedCastsSet UnbridgedCasts = null;
  try {
    assert ($eq_QualType$C(MemExprE.getType(), $this().Context.BoundMemberTy.$QualType()) || $eq_QualType$C(MemExprE.getType(), $this().Context.OverloadTy.$QualType()));
    
    // Dig out the member expression. This holds both the object
    // argument and the member function we're referring to.
    Expr /*P*/ NakedMemExpr = MemExprE.IgnoreParens();
    {
      
      // Determine whether this is a call to a pointer-to-member function.
      BinaryOperator /*P*/ op = dyn_cast_BinaryOperator(NakedMemExpr);
      if ((op != null)) {
        assert ($eq_QualType$C(op.getType(), $this().Context.BoundMemberTy.$QualType()));
        assert (op.getOpcode() == BinaryOperatorKind.BO_PtrMemD || op.getOpcode() == BinaryOperatorKind.BO_PtrMemI);
        
        QualType fnType = op.getRHS().getType().$arrow().castAs(MemberPointerType.class).getPointeeType();
        
        /*const*/ FunctionProtoType /*P*/ proto = fnType.$arrow().castAs(FunctionProtoType.class);
        QualType resultType = proto.getCallResultType($this().Context);
        ExprValueKind valueKind = Expr.getValueKindForType(proto.getReturnType());
        
        // Check that the object type isn't more qualified than the
        // member function we're calling.
        Qualifiers funcQuals = Qualifiers.fromCVRMask(proto.getTypeQuals());
        
        QualType objectType = op.getLHS().getType();
        if (op.getOpcode() == BinaryOperatorKind.BO_PtrMemI) {
          objectType.$assignMove(objectType.$arrow().castAs(PointerType.class).getPointeeType());
        }
        Qualifiers objectQuals = objectType.getQualifiers();
        
        Qualifiers difference = $sub_Qualifiers(/*NO_COPY*/objectQuals, /*NO_COPY*/funcQuals);
        difference.removeObjCGCAttr();
        difference.removeAddressSpace();
        if (difference.$bool()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            std.string qualsString = difference.getAsString();
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(LParenLoc), diag.err_pointer_to_member_call_drops_quals)), 
                        fnType.getUnqualifiedType()), 
                    qualsString), 
                (qualsString.find_T_rebind$_CharT($$SPACE) == std.string.npos ? 1 : 2)));
          } finally {
            $c$.$destroy();
          }
        }
        
        final Expr /*P*/ $MemExprE = MemExprE;
        CXXMemberCallExpr /*P*/ call = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXMemberCallExpr($this().Context, $MemExprE, new ArrayRef<Expr /*P*/ >(Args), 
            new QualType(resultType), valueKind, new SourceLocation(RParenLoc)));
        if ($this().CheckCallReturnType(proto.getReturnType(), op.getRHS().getLocStart(), 
            call, (FunctionDecl /*P*/ )null)) {
          return ExprError();
        }
        if ($this().ConvertArgumentsForCall(call, op, (FunctionDecl /*P*/ )null, proto, new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc))) {
          return ExprError();
        }
        if ($this().CheckOtherCall(call, proto)) {
          return ExprError();
        }
        
        return $this().MaybeBindToTemporary(call);
      }
    }
    if (isa_CXXPseudoDestructorExpr(NakedMemExpr)) {
      final Expr /*P*/ $MemExprE = MemExprE;
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CallExpr($this().Context, $MemExprE, new ArrayRef<Expr /*P*/ >(Args), $this().Context.VoidTy.$QualType(), ExprValueKind.VK_RValue, new SourceLocation(RParenLoc))));
    }
    
    UnbridgedCasts/*J*/= new UnbridgedCastsSet();
    if (checkArgPlaceholdersForOverload(/*Deref*/$this(), new MutableArrayRef<Expr /*P*/ >(Args), UnbridgedCasts)) {
      return ExprError();
    }
    
    MemberExpr /*P*/ MemExpr;
    CXXMethodDecl /*P*/ Method = null;
    DeclAccessPair FoundDecl = DeclAccessPair.make((NamedDecl /*P*/ )null, AccessSpecifier.AS_public);
    NestedNameSpecifier /*P*/ Qualifier = null;
    if (isa_MemberExpr(NakedMemExpr)) {
      MemExpr = cast_MemberExpr(NakedMemExpr);
      Method = cast_CXXMethodDecl(MemExpr.getMemberDecl());
      FoundDecl.$assignMove(MemExpr.getFoundDecl());
      Qualifier = MemExpr.getQualifier();
      UnbridgedCasts.restore();
    } else {
      OverloadCandidateSet CandidateSet = null;
      TemplateArgumentListInfo TemplateArgsBuffer = null;
      try {
        UnresolvedMemberExpr /*P*/ UnresExpr = cast_UnresolvedMemberExpr(NakedMemExpr);
        Qualifier = UnresExpr.getQualifier();
        
        QualType ObjectType = UnresExpr.getBaseType();
        Expr.Classification ObjectClassification = UnresExpr.isArrow() ? Expr.Classification.makeSimpleLValue() : UnresExpr.getBase().Classify($this().Context);
        
        // Add overload candidates
        CandidateSet/*J*/= new OverloadCandidateSet(UnresExpr.getMemberLoc(), 
            OverloadCandidateSet.CandidateSetKind.CSK_Normal);
        
        // FIXME: avoid copy.
        TemplateArgsBuffer/*J*/= new TemplateArgumentListInfo();
        TemplateArgumentListInfo /*P*/ TemplateArgs = null;
        if (UnresExpr.hasExplicitTemplateArgs()) {
          UnresExpr.copyTemplateArgumentsInto(TemplateArgsBuffer);
          TemplateArgs = $AddrOf(TemplateArgsBuffer);
        }
        
        for (UnresolvedSetIterator I = UnresExpr.decls_begin(), 
            E = UnresExpr.decls_end(); I.$noteq(E); I.$preInc()) {
          
          NamedDecl /*P*/ Func = I.$star();
          CXXRecordDecl /*P*/ ActingDC = cast_CXXRecordDecl(Func.getDeclContext());
          if (isa_UsingShadowDecl(Func)) {
            Func = cast_UsingShadowDecl(Func).getTargetDecl();
          }
          
          // Microsoft supports direct constructor calls.
          if ($this().getLangOpts().MicrosoftExt && isa_CXXConstructorDecl(Func)) {
            $this().AddOverloadCandidate(cast_CXXConstructorDecl(Func), new DeclAccessPair(I.getPair()), 
                new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
          } else if (((Method = dyn_cast_CXXMethodDecl(Func)) != null)) {
            // If explicit template arguments were provided, we can't call a
            // non-template member function.
            if ((TemplateArgs != null)) {
              continue;
            }
            
            $this().AddMethodCandidate(Method, new DeclAccessPair(I.getPair()), ActingDC, new QualType(ObjectType), 
                new Expr.Classification(ObjectClassification), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
                /*SuppressUserConversions=*/ false);
          } else {
            $this().AddMethodTemplateCandidate(cast_FunctionTemplateDecl(Func), 
                new DeclAccessPair(I.getPair()), ActingDC, TemplateArgs, 
                new QualType(ObjectType), new Expr.Classification(ObjectClassification), 
                new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
                /*SuppressUsedConversions=*/ false);
          }
        }
        
        DeclarationName DeclName = UnresExpr.getMemberName();
        
        UnbridgedCasts.restore();
        
        type$ptr<OverloadCandidate> Best = create_type$ptr();
        switch (CandidateSet.BestViableFunction(/*Deref*/$this(), UnresExpr.getLocStart(), 
            Best)) {
         case OR_Success:
          Method = cast_CXXMethodDecl(Best./*->*/$star().Function);
          FoundDecl.$assign(Best./*->*/$star().FoundDecl);
          $this().CheckUnresolvedMemberAccess(UnresExpr, new DeclAccessPair(Best./*->*/$star().FoundDecl));
          if ($this().DiagnoseUseOfDecl(Best./*->*/$star().FoundDecl.$NamedDecl$P(), UnresExpr.getNameLoc())) {
            return ExprError();
          }
          // If FoundDecl is different from Method (such as if one is a template
          // and the other a specialization), make sure DiagnoseUseOfDecl is 
          // called on both.
          // FIXME: This would be more comprehensively addressed by modifying
          // DiagnoseUseOfDecl to accept both the FoundDecl and the decl
          // being used.
          if (Method != FoundDecl.getDecl()
             && $this().DiagnoseUseOfDecl(Method, UnresExpr.getNameLoc())) {
            return ExprError();
          }
          break;
         case OR_No_Viable_Function:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UnresExpr.getMemberLoc(), 
                          diag.err_ovl_no_viable_member_function_in_call)), 
                      DeclName), MemExprE.getSourceRange()));
              CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
              // FIXME: Leaking incoming expressions!
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
         case OR_Ambiguous:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UnresExpr.getMemberLoc(), diag.err_ovl_ambiguous_member_call)), 
                      DeclName), MemExprE.getSourceRange()));
              CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
              // FIXME: Leaking incoming expressions!
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
         case OR_Deleted:
          {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(UnresExpr.getMemberLoc(), diag.err_ovl_deleted_member_call)), 
                              Best./*->*/$star().Function.isDeleted()), 
                          DeclName), 
                      $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
                  MemExprE.getSourceRange()));
              CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
              // FIXME: Leaking incoming expressions!
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
        }
        
        MemExprE = $this().FixOverloadedFunctionReference(MemExprE, new DeclAccessPair(FoundDecl), Method);
        
        // If overload resolution picked a static member, build a
        // non-member call based on that function.
        if (Method.isStatic()) {
          return $this().BuildResolvedCallExpr(MemExprE, Method, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args), 
              new SourceLocation(RParenLoc));
        }
        
        MemExpr = cast_MemberExpr(MemExprE.IgnoreParens());
      } finally {
        if (TemplateArgsBuffer != null) { TemplateArgsBuffer.$destroy(); }
        if (CandidateSet != null) { CandidateSet.$destroy(); }
      }
    }
    
    QualType ResultType = Method.getReturnType();
    ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultType));
    ResultType.$assignMove(ResultType.getNonLValueExprType($this().Context));
    assert ((Method != null)) : "Member call to something that isn't a method?";
    final Expr /*P*/ $MemExprE = MemExprE;
    CXXMemberCallExpr /*P*/ TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXMemberCallExpr($this().Context, $MemExprE, new ArrayRef<Expr /*P*/ >(Args), 
        new QualType(ResultType), VK, new SourceLocation(RParenLoc)));
    
    // (CUDA B.1): Check for invalid calls between targets.
    if ($this().getLangOpts().CUDA) {
      {
        /*const*/ FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl($this().CurContext);
        if ((Caller != null)) {
          if ($this().CheckCUDATarget(Caller, Method)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemExpr.getMemberLoc(), diag.err_ref_bad_target)), 
                          $this().IdentifyCUDATarget(Method)), Method.getIdentifier()), 
                  $this().IdentifyCUDATarget(Caller)));
              return ExprError();
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
    
    // Check for a valid return type.
    if ($this().CheckCallReturnType(Method.getReturnType(), MemExpr.getMemberLoc(), 
        TheCall, Method)) {
      return ExprError();
    }
    
    // Convert the object argument (for a non-static member function call).
    // We only need to do this if there was actually an overload; otherwise
    // it was done at lookup.
    if (!Method.isStatic()) {
      ActionResultTTrue<Expr /*P*/ > ObjectArg = $this().PerformObjectArgumentInitialization(MemExpr.getBase(), Qualifier, 
          FoundDecl.$NamedDecl$P(), Method);
      if (ObjectArg.isInvalid()) {
        return ExprError();
      }
      MemExpr.setBase(ObjectArg.get());
    }
    
    // Convert the rest of the arguments
    /*const*/ FunctionProtoType /*P*/ Proto = Method.getType().$arrow().getAs(FunctionProtoType.class);
    if ($this().ConvertArgumentsForCall(TheCall, MemExpr, Method, Proto, new ArrayRef<Expr /*P*/ >(Args), 
        new SourceLocation(RParenLoc))) {
      return ExprError();
    }
    
    $this().DiagnoseSentinelCalls(Method, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args));
    if ($this().CheckFunctionCall(Method, TheCall, Proto)) {
      return ExprError();
    }
    
    // In the case the method to call was not selected by the overloading
    // resolution process, we still need to handle the enable_if attribute. Do
    // that here, so it will not hide previous -- and more relevant -- errors
    if (isa_MemberExpr(NakedMemExpr)) {
      {
        /*const*/ EnableIfAttr /*P*/ Attr = $this().CheckEnableIf(Method, new ArrayRef<Expr /*P*/ >(Args), true);
        if ((Attr != null)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemExprE.getLocStart(), 
                        diag.err_ovl_no_viable_member_function_in_call)), 
                    Method), Method.getSourceRange()));
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Method.getLocation(), 
                        diag.note_ovl_candidate_disabled_by_enable_if_attr)), 
                    Attr.getCond().getSourceRange()), Attr.getMessage()));
            return ExprError();
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
    if ((isa_CXXConstructorDecl($this().CurContext)
       || isa_CXXDestructorDecl($this().CurContext))
       && TheCall.getMethodDecl().isPure()) {
      /*const*/ CXXMethodDecl /*P*/ MD = TheCall.getMethodDecl();
      if (isa_CXXThisExpr(MemExpr.getBase().IgnoreParenCasts())
         && MemExpr.performsVirtualDispatch($this().getLangOpts())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemExpr.getLocStart(), 
                          diag.warn_call_to_pure_virtual_member_function_from_ctor_dtor)), 
                      MD.getDeclName()), isa_CXXDestructorDecl($this().CurContext)), 
              MD.getParent$Const().getDeclName()));
          
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MD.getLocStart(), diag.note_previous_decl)), MD.getDeclName()));
          if ($this().getLangOpts().AppleKext) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(MemExpr.getLocStart(), 
                        diag.note_pure_qualified_call_kext)), 
                    MD.getParent$Const().getDeclName()), 
                MD.getDeclName()));
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
    {
      
      CXXDestructorDecl /*P*/ DD = dyn_cast_CXXDestructorDecl(TheCall.getMethodDecl());
      if ((DD != null)) {
        // a->A::f() doesn't go through the vtable, except in AppleKext mode.
        boolean CallCanBeVirtual = !MemExpr.hasQualifier() || $this().getLangOpts().AppleKext;
        $this().CheckVirtualDtorCall(DD, MemExpr.getLocStart(), /*IsDelete=*/ false, 
            CallCanBeVirtual, /*WarnOnNonAbstractTypes=*/ true, 
            MemExpr.getMemberLoc());
      }
    }
    
    return $this().MaybeBindToTemporary(TheCall);
  } finally {
    if (UnbridgedCasts != null) { UnbridgedCasts.$destroy(); }
  }
}


/// BuildCallToObjectOfClassType - Build a call to an object of class
/// type (C++ [over.call.object]), which can end up invoking an
/// overloaded function call operator (@c operator()) or performing a
/// user-defined conversion on the object argument.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCallToObjectOfClassType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 12427,
 FQN="clang::Sema::BuildCallToObjectOfClassType", NM="_ZN5clang4Sema28BuildCallToObjectOfClassTypeEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema28BuildCallToObjectOfClassTypeEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEN4llvm15MutableArrayRefIS4_EES5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCallToObjectOfClassType(Scope /*P*/ S, Expr /*P*/ _Obj, 
                            SourceLocation LParenLoc, 
                            MutableArrayRef<Expr /*P*/ > Args, 
                            SourceLocation RParenLoc) {
  type$ref<Expr /*P*/> Obj = create_type$ref(_Obj);
  UnbridgedCastsSet UnbridgedCasts = null;
  OverloadCandidateSet CandidateSet = null;
  LookupResult R = null;
  unique_ptr_array<Expr /*P*/ /*[]*/> MethodArgs = null;
  try {
    if (checkPlaceholderForOverload(/*Deref*/$this(), Obj)) {
      return ExprError();
    }
    ActionResultTTrue<Expr /*P*/ > Object = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Obj.$deref());
    
    UnbridgedCasts/*J*/= new UnbridgedCastsSet();
    if (checkArgPlaceholdersForOverload(/*Deref*/$this(), new MutableArrayRef<Expr /*P*/ >(Args), UnbridgedCasts)) {
      return ExprError();
    }
    assert (Object.get().getType().$arrow().isRecordType()) : "Requires object type argument";
    /*const*/ RecordType /*P*/ Record = Object.get().getType().$arrow().getAs$RecordType();
    
    // C++ [over.call.object]p1:
    //  If the primary-expression E in the function call syntax
    //  evaluates to a class object of type "cv T", then the set of
    //  candidate functions includes at least the function call
    //  operators of T. The function call operators of T are obtained by
    //  ordinary lookup of the name operator() in the context of
    //  (E).operator().
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(LParenLoc), 
        OverloadCandidateSet.CandidateSetKind.CSK_Operator);
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Call);
    if ($this().RequireCompleteType$T(new SourceLocation(LParenLoc), Object.get().getType(), 
        diag.err_incomplete_object_call, Object.get())) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(LParenLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupQualifiedName(R, Record.getDecl());
    R.suppressDiagnostics();
    
    for (UnresolvedSetIterator Oper = R.begin(), OperEnd = R.end();
         Oper.$noteq(OperEnd); Oper.$preInc()) {
      $this().AddMethodCandidate(new DeclAccessPair(Oper.getPair()), Object.get().getType(), 
          Object.get().Classify($this().Context), 
          new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
          /*SuppressUserConversions=*/ false);
    }
    
    // C++ [over.call.object]p2:
    //   In addition, for each (non-explicit in C++0x) conversion function 
    //   declared in T of the form
    //
    //        operator conversion-type-id () cv-qualifier;
    //
    //   where cv-qualifier is the same cv-qualification as, or a
    //   greater cv-qualification than, cv, and where conversion-type-id
    //   denotes the type "pointer to function of (P1,...,Pn) returning
    //   R", or the type "reference to pointer to function of
    //   (P1,...,Pn) returning R", or the type "reference to function
    //   of (P1,...,Pn) returning R", a surrogate call function [...]
    //   is also considered as a candidate function. Similarly,
    //   surrogate call functions are added to the set of candidate
    //   functions for each conversion function declared in an
    //   accessible base class provided the function is not hidden
    //   within T by another intervening declaration.
    final /*const*/ iterator_range<NamedDecl /*P*/ > /*&*/ Conversions = cast_CXXRecordDecl(Record.getDecl()).getVisibleConversionFunctions();
    for (UnresolvedSetIterator I = ((UnresolvedSetIterator)Conversions.begin()), E = ((UnresolvedSetIterator)Conversions.end()); I.$noteq(E); I.$preInc()) {
      NamedDecl /*P*/ D = I.$star();
      CXXRecordDecl /*P*/ ActingContext = cast_CXXRecordDecl(D.getDeclContext());
      if (isa_UsingShadowDecl(D)) {
        D = cast_UsingShadowDecl(D).getTargetDecl();
      }
      
      // Skip over templated conversion functions; they aren't
      // surrogates.
      if (isa_FunctionTemplateDecl(D)) {
        continue;
      }
      
      CXXConversionDecl /*P*/ Conv = cast_CXXConversionDecl(D);
      if (!Conv.isExplicit()) {
        // Strip the reference type (if any) and then the pointer type (if
        // any) to get down to what might be a function type.
        QualType ConvType = Conv.getConversionType().getNonReferenceType();
        {
          /*const*/ PointerType /*P*/ ConvPtrType = ConvType.$arrow().getAs(PointerType.class);
          if ((ConvPtrType != null)) {
            ConvType.$assignMove(ConvPtrType.getPointeeType());
          }
        }
        {
          
          /*const*/ FunctionProtoType /*P*/ Proto = ConvType.$arrow().getAs(FunctionProtoType.class);
          if ((Proto != null)) {
            $this().AddSurrogateCandidate(Conv, new DeclAccessPair(I.getPair()), ActingContext, Proto, 
                Object.get(), new ArrayRef<Expr /*P*/ >(Args), CandidateSet);
          }
        }
      }
    }
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    // Perform overload resolution.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(/*Deref*/$this(), Object.get().getLocStart(), 
        Best)) {
     case OR_Success:
      // Overload resolution succeeded; we'll build the appropriate call
      // below.
      break;
     case OR_No_Viable_Function:
      if (CandidateSet.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Object.get().getLocStart(), diag.err_ovl_no_oper)), 
                      Object.get().getType()), /*call*/ 1), 
              Object.get().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Object.get().getLocStart(), 
                      diag.err_ovl_no_viable_object_call)), 
                  Object.get().getType()), Object.get().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
      break;
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Object.get().getLocStart(), 
                      diag.err_ovl_ambiguous_object_call)), 
                  Object.get().getType()), Object.get().getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(Object.get().getLocStart(), 
                              diag.err_ovl_deleted_object_call)), 
                          Best./*->*/$star().Function.isDeleted()), 
                      Object.get().getType()), 
                  $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
              Object.get().getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    if ($eq_ptr(Best, CandidateSet.end())) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    UnbridgedCasts.restore();
    if (Best./*->*/$star().Function == null) {
      // Since there is no function declaration, this is one of the
      // surrogate candidates. Dig out the conversion function.
      CXXConversionDecl /*P*/ Conv = cast_CXXConversionDecl(Best./*->*/$star().Conversions[0].Unnamed_field2.UserDefined.ConversionFunction);
      
      $this().CheckMemberOperatorAccess(new SourceLocation(LParenLoc), Object.get(), (Expr /*P*/ )null, 
          new DeclAccessPair(Best./*->*/$star().FoundDecl));
      if ($this().DiagnoseUseOfDecl(Best./*->*/$star().FoundDecl.$NamedDecl$P(), new SourceLocation(LParenLoc))) {
        return ExprError();
      }
      assert (Conv == Best./*->*/$star().FoundDecl.getDecl()) : "Found Decl & conversion-to-functionptr should be same, right?!";
      // We selected one of the surrogate functions that converts the
      // object parameter to a function pointer. Perform the conversion
      // on the object argument, then let ActOnCallExpr finish the job.
      
      // Create an implicit member expr to refer to the conversion operator.
      // and then call it.
      ActionResultTTrue<Expr /*P*/ > Call = $this().BuildCXXMemberCallExpr(Object.get(), Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
          Conv, HadMultipleCandidates);
      if (Call.isInvalid()) {
        return ExprError();
      }
      // Record usage of conversion in an implicit cast.
      Call.$assign(ImplicitCastExpr.Create($this().Context, Call.get().getType(), 
              CastKind.CK_UserDefinedConversion, Call.get(), 
              (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
      
      return $this().ActOnCallExpr(S, Call.get(), new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc));
    }
    
    $this().CheckMemberOperatorAccess(new SourceLocation(LParenLoc), Object.get(), (Expr /*P*/ )null, new DeclAccessPair(Best./*->*/$star().FoundDecl));
    
    // We found an overloaded operator(). Build a CXXOperatorCallExpr
    // that calls this method, using Object for the implicit object
    // parameter and passing along the remaining arguments.
    CXXMethodDecl /*P*/ Method = cast_CXXMethodDecl(Best./*->*/$star().Function);
    
    // An error diagnostic has already been printed when parsing the declaration.
    if (Method.isInvalidDecl()) {
      return ExprError();
    }
    
    /*const*/ FunctionProtoType /*P*/ Proto = Method.getType().$arrow().getAs(FunctionProtoType.class);
    
    /*uint*/int NumParams = Proto.getNumParams();
    
    DeclarationNameInfo OpLocInfo/*J*/= new DeclarationNameInfo($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Call), new SourceLocation(LParenLoc));
    OpLocInfo.setCXXOperatorNameRange(new SourceRange(/*NO_COPY*/LParenLoc, /*NO_COPY*/RParenLoc));
    ActionResultTTrue<Expr /*P*/ > NewFn = CreateFunctionRefExpr(/*Deref*/$this(), Method, Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
        HadMultipleCandidates, 
        OpLocInfo.getLoc(), 
        OpLocInfo.getInfo());
    if (NewFn.isInvalid()) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    // Build the full argument list for the method call (the implicit object
    // parameter is placed at the beginning of the list).
    MethodArgs/*J*/= new unique_ptr_array<Expr /*P*/ /*[]*/>(new Expr /*P*/ [Args.size() + 1]);
    MethodArgs.$set(0, Object.get());
    std.copy(Args.begin(), Args.end(), $AddrOf(MethodArgs.ptr$at(1)));
    
    // Once we've built TheCall, all of the expressions are properly
    // owned.
    QualType ResultTy = Method.getReturnType();
    ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultTy));
    ResultTy.$assignMove(ResultTy.getNonLValueExprType($this().Context));
    
    final unique_ptr_array<Expr /*P*/ /*[]*/> $MethodArgs = MethodArgs;
    CXXOperatorCallExpr /*P*/ TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, OverloadedOperatorKind.OO_Call, NewFn.get(), 
        llvm.makeArrayRef($MethodArgs.get(), Args.size() + 1), 
        new QualType(ResultTy), VK, new SourceLocation(RParenLoc), false));
    MethodArgs.reset();
    if ($this().CheckCallReturnType(Method.getReturnType(), new SourceLocation(LParenLoc), TheCall, Method)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    // We may have default arguments. If so, we need to allocate more
    // slots in the call for them.
    if ($less_uint(Args.size(), NumParams)) {
      TheCall.setNumArgs($this().Context, NumParams + 1);
    }
    
    boolean IsError = false;
    
    // Initialize the implicit object parameter.
    ActionResultTTrue<Expr /*P*/ > ObjRes = $this().PerformObjectArgumentInitialization(Object.get(), /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
        Best./*->*/$star().FoundDecl.$NamedDecl$P(), Method);
    if (ObjRes.isInvalid()) {
      IsError = true;
    } else {
      Object.$assign(ObjRes);
    }
    TheCall.setArg(0, Object.get());
    
    // Check the argument types.
    for (/*uint*/int i = 0; i != NumParams; i++) {
      Expr /*P*/ Arg;
      if ($less_uint(i, Args.size())) {
        Arg = Args.$at(i);
        
        // Pass the argument.
        ActionResultTTrue<Expr /*P*/ > InputInit = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, 
                Method.getParamDecl(i)), 
            new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Arg));
        
        IsError |= InputInit.isInvalid();
        Arg = InputInit.getAs(Expr.class);
      } else {
        ActionResultTTrue<Expr /*P*/ > DefArg = $this().BuildCXXDefaultArgExpr(new SourceLocation(LParenLoc), Method, Method.getParamDecl(i));
        if (DefArg.isInvalid()) {
          IsError = true;
          break;
        }
        
        Arg = DefArg.getAs(Expr.class);
      }
      
      TheCall.setArg(i + 1, Arg);
    }
    
    // If this is a variadic call, handle args passed through "...".
    if (Proto.isVariadic()) {
      // Promote the arguments (C99 6.5.2.2p7).
      for (/*uint*/int i = NumParams, e = Args.size(); $less_uint(i, e); i++) {
        ActionResultTTrue<Expr /*P*/ > Arg = $this().DefaultVariadicArgumentPromotion(Args.$at(i), VariadicCallType.VariadicMethod, 
            (FunctionDecl /*P*/ )null);
        IsError |= Arg.isInvalid();
        TheCall.setArg(i + 1, Arg.get());
      }
    }
    if (IsError) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    $this().DiagnoseSentinelCalls(Method, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args));
    if ($this().CheckFunctionCall(Method, TheCall, Proto)) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    return $this().MaybeBindToTemporary(TheCall);
  } finally {
    if (MethodArgs != null) { MethodArgs.$destroy(); }
    if (R != null) { R.$destroy(); }
    if (CandidateSet != null) { CandidateSet.$destroy(); }
    if (UnbridgedCasts != null) { UnbridgedCasts.$destroy(); }
  }
}


/// BuildOverloadedArrowExpr - Build a call to an overloaded @c operator->
///  (if one exists), where @c Base is an expression of class type and
/// @c Member is the name of the member we're trying to find.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildOverloadedArrowExpr">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 12712,
 FQN="clang::Sema::BuildOverloadedArrowExpr", NM="_ZN5clang4Sema24BuildOverloadedArrowExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema24BuildOverloadedArrowExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEPb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildOverloadedArrowExpr(Scope /*P*/ S, Expr /*P*/ Base, SourceLocation OpLoc) {
  return BuildOverloadedArrowExpr(S, Base, OpLoc, 
                        (bool$ptr/*bool P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildOverloadedArrowExpr(Scope /*P*/ S, Expr /*P*/ _Base, SourceLocation OpLoc, 
                        bool$ptr/*bool P*/ NoArrowOperatorFound/*= null*/) {
  type$ref<Expr /*P*/> Base = create_type$ref(_Base);
  OverloadCandidateSet CandidateSet = null;
  LookupResult R = null;
  try {
    assert (Base.$deref().getType().$arrow().isRecordType()) : "left-hand side must have class type";
    if (checkPlaceholderForOverload(/*Deref*/$this(), Base)) {
      return ExprError();
    }
    
    SourceLocation Loc = Base.$deref().getExprLoc();
    
    // C++ [over.ref]p1:
    //
    //   [...] An expression x->m is interpreted as (x.operator->())->m
    //   for a class object x of type T if T::operator->() exists and if
    //   the operator is selected as the best match function by the
    //   overload resolution mechanism (13.3).
    DeclarationName OpName = $this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Arrow);
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(Loc), OverloadCandidateSet.CandidateSetKind.CSK_Operator);
    /*const*/ RecordType /*P*/ BaseRecord = Base.$deref().getType().$arrow().getAs$RecordType();
    if ($this().RequireCompleteType$T(new SourceLocation(Loc), Base.$deref().getType(), 
        diag.err_typecheck_incomplete_tag, Base.$deref())) {
      return ExprError();
    }
    
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(OpLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupQualifiedName(R, BaseRecord.getDecl());
    R.suppressDiagnostics();
    
    for (UnresolvedSetIterator Oper = R.begin(), OperEnd = R.end();
         Oper.$noteq(OperEnd); Oper.$preInc()) {
      $this().AddMethodCandidate(new DeclAccessPair(Oper.getPair()), Base.$deref().getType(), Base.$deref().Classify($this().Context), 
          new ArrayRef<Expr /*P*/ >(None, true), CandidateSet, /*SuppressUserConversions=*/ false);
    }
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    // Perform overload resolution.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(/*Deref*/$this(), new SourceLocation(OpLoc), Best)) {
     case OR_Success:
      // Overload resolution succeeded; we'll build the call below.
      break;
     case OR_No_Viable_Function:
      if (CandidateSet.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          QualType BaseType = Base.$deref().getType();
          if (Native.$bool(NoArrowOperatorFound)) {
            // Report this specific error to the caller instead of emitting a
            // diagnostic, as requested.
            NoArrowOperatorFound.$set(true);
            return ExprError();
          }
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_arrow)), 
                  BaseType), Base.$deref().getSourceRange()));
          if (BaseType.$arrow().isRecordType() && !BaseType.$arrow().isPointerType()) {
            $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.note_typecheck_member_reference_suggestion)), 
                FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$DOT))));
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_no_viable_oper)), 
                  /*KEEP_STR*/"operator->"), Base.$deref().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      }
      CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Base.$deref(), true));
      return ExprError();
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_ambiguous_oper_unary)), 
                      /*KEEP_STR*/"->"), Base.$deref().getType()), Base.$deref().getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Base.$deref(), true));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_ovl_deleted_oper)), 
                          Best./*->*/$star().Function.isDeleted()), 
                      /*KEEP_STR*/"->"), 
                  $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
              Base.$deref().getSourceRange()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Base.$deref(), true));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    $this().CheckMemberOperatorAccess(new SourceLocation(OpLoc), Base.$deref(), (Expr /*P*/ )null, new DeclAccessPair(Best./*->*/$star().FoundDecl));
    
    // Convert the object parameter.
    CXXMethodDecl /*P*/ Method = cast_CXXMethodDecl(Best./*->*/$star().Function);
    ActionResultTTrue<Expr /*P*/ > BaseResult = $this().PerformObjectArgumentInitialization(Base.$deref(), /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
        Best./*->*/$star().FoundDecl.$NamedDecl$P(), Method);
    if (BaseResult.isInvalid()) {
      return ExprError();
    }
    Base.$set(BaseResult.get());
    
    // Build the operator call.
    ActionResultTTrue<Expr /*P*/ > FnExpr = CreateFunctionRefExpr(/*Deref*/$this(), Method, Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
        HadMultipleCandidates, new SourceLocation(OpLoc));
    if (FnExpr.isInvalid()) {
      return ExprError();
    }
    
    QualType ResultTy = Method.getReturnType();
    ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultTy));
    ResultTy.$assignMove(ResultTy.getNonLValueExprType($this().Context));
    CXXOperatorCallExpr /*P*/ TheCall = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->new CXXOperatorCallExpr($this().Context, OverloadedOperatorKind.OO_Arrow, FnExpr.get(), 
        new ArrayRef<Expr /*P*/ >(Base.$deref(), true), new QualType(ResultTy), VK, new SourceLocation(OpLoc), false));
    if ($this().CheckCallReturnType(Method.getReturnType(), new SourceLocation(OpLoc), TheCall, Method)) {
      return ExprError();
    }
    
    return $this().MaybeBindToTemporary(TheCall);
  } finally {
    if (R != null) { R.$destroy(); }
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}

/// \brief - Returns a selector which best matches given argument list or
/// nullptr if none could be found
//<editor-fold defaultstate="collapsed" desc="clang::Sema::SelectBestMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5863,
 FQN="clang::Sema::SelectBestMethod", NM="_ZN5clang4Sema16SelectBestMethodENS_8SelectorEN4llvm15MutableArrayRefIPNS_4ExprEEEbRNS2_15SmallVectorImplIPNS_14ObjCMethodDeclEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema16SelectBestMethodENS_8SelectorEN4llvm15MutableArrayRefIPNS_4ExprEEEbRNS2_15SmallVectorImplIPNS_14ObjCMethodDeclEEE")
//</editor-fold>
protected/*private*/ final ObjCMethodDecl /*P*/ SelectBestMethod(Selector Sel, MutableArrayRef<Expr /*P*/ > Args, boolean IsInstance, 
                final SmallVectorImpl<ObjCMethodDecl /*P*/ > /*&*/ Methods) {
  if ($lesseq_uint(Methods.size(), 1)) {
    return null;
  }
  
  for (/*uint*/int b = 0, e = Methods.size(); $less_uint(b, e); b++) {
    boolean Match = true;
    ObjCMethodDecl /*P*/ Method = Methods.$at(b);
    /*uint*/int NumNamedArgs = Sel.getNumArgs();
    // Method might have more arguments than selector indicates. This is due
    // to addition of c-style arguments in method.
    if ($greater_uint(Method.param_size(), NumNamedArgs)) {
      NumNamedArgs = Method.param_size();
    }
    if ($less_uint(Args.size(), NumNamedArgs)) {
      continue;
    }
    
    for (/*uint*/int i = 0; $less_uint(i, NumNamedArgs); i++) {
      ImplicitConversionSequence ConversionState = null;
      try {
        // We can't do any type-checking on a type-dependent argument.
        if (Args.$at(i).isTypeDependent()) {
          Match = false;
          break;
        }
        
        ParmVarDecl /*P*/ param = Method.parameters().$at(i);
        Expr /*P*/ argExpr = Args.$at(i);
        assert ((argExpr != null)) : "SelectBestMethod(): missing expression";
        
        // Strip the unbridged-cast placeholder expression off unless it's
        // a consumed argument.
        if (argExpr.hasPlaceholderType(BuiltinType.Kind.ARCUnbridgedCast)
           && !param.hasAttr(CFConsumedAttr.class)) {
          argExpr = $this().stripARCUnbridgedCast(argExpr);
        }
        
        // If the parameter is __unknown_anytype, move on to the next method.
        if ($eq_QualType$C(param.getType(), $this().Context.UnknownAnyTy.$QualType())) {
          Match = false;
          break;
        }
        
        ConversionState = TryCopyInitialization(/*Deref*/$this(), argExpr, param.getType(), 
            /*SuppressUserConversions*/ false, 
            /*InOverloadResolution=*/ true, 
            /*AllowObjCWritebackConversion=*/
            $this().getLangOpts().ObjCAutoRefCount, 
            /*AllowExplicit*/ false);
        if (ConversionState.isBad()) {
          Match = false;
          break;
        }
      } finally {
        if (ConversionState != null) { ConversionState.$destroy(); }
      }
    }
    // Promote additional arguments to variadic methods.
    if (Match && Method.isVariadic()) {
      for (/*uint*/int i = NumNamedArgs, e$1 = Args.size(); $less_uint(i, e$1); ++i) {
        if (Args.$at(i).isTypeDependent()) {
          Match = false;
          break;
        }
        ActionResultTTrue<Expr /*P*/ > Arg = $this().DefaultVariadicArgumentPromotion(Args.$at(i), VariadicCallType.VariadicMethod, 
            (FunctionDecl /*P*/ )null);
        if (Arg.isInvalid()) {
          Match = false;
          break;
        }
      }
    } else {
      // Check for extra arguments to non-variadic methods.
      if (Args.size() != NumNamedArgs) {
        Match = false;
      } else if (Match && NumNamedArgs == 0 && $greater_uint(Methods.size(), 1)) {
        // Special case when selectors have no argument. In this case, select
        // one with the most general result type of 'id'.
        for (/*uint*/int b$1 = 0, e$1 = Methods.size(); $less_uint(b$1, e$1); b$1++) {
          QualType ReturnT = Methods.$at(b$1).getReturnType();
          if (ReturnT.$arrow().isObjCIdType()) {
            return Methods.$at(b$1);
          }
        }
      }
    }
    if (Match) {
      return Method;
    }
  }
  return null;
}


/// BuildLiteralOperatorCall - Build a UserDefinedLiteral by creating a call to
/// a literal operator described by the provided lookup results.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildLiteralOperatorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 12826,
 FQN="clang::Sema::BuildLiteralOperatorCall", NM="_ZN5clang4Sema24BuildLiteralOperatorCallERNS_12LookupResultERNS_19DeclarationNameInfoEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationEPNS_24TemplateArgumentListInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema24BuildLiteralOperatorCallERNS_12LookupResultERNS_19DeclarationNameInfoEN4llvm8ArrayRefIPNS_4ExprEEENS_14SourceLocationEPNS_24TemplateArgumentListInfoE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildLiteralOperatorCall(final LookupResult /*&*/ R, 
                        final DeclarationNameInfo /*&*/ SuffixInfo, 
                        ArrayRef<Expr /*P*/ > Args, 
                        SourceLocation LitEndLoc) {
  return BuildLiteralOperatorCall(R, 
                        SuffixInfo, 
                        Args, 
                        LitEndLoc, 
                        (TemplateArgumentListInfo /*P*/ )null);
}
public final ActionResultTTrue<Expr /*P*/ > BuildLiteralOperatorCall(final LookupResult /*&*/ R, 
                        final DeclarationNameInfo /*&*/ SuffixInfo, 
                        ArrayRef<Expr /*P*/ > Args, 
                        SourceLocation LitEndLoc, 
                        TemplateArgumentListInfo /*P*/ TemplateArgs/*= null*/) {
  OverloadCandidateSet CandidateSet = null;
  try {
    SourceLocation UDSuffixLoc = SuffixInfo.getCXXLiteralOperatorNameLoc();
    
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(UDSuffixLoc), 
        OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    $this().AddFunctionCandidates(R.asUnresolvedSet(), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, TemplateArgs, 
        /*SuppressUserConversions=*/ true);
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    // Perform overload resolution. This will usually be trivial, but might need
    // to perform substitutions for a literal operator template.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(/*Deref*/$this(), new SourceLocation(UDSuffixLoc), Best)) {
     case OR_Success:
     case OR_Deleted:
      break;
     case OR_No_Viable_Function:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(UDSuffixLoc), diag.err_ovl_no_viable_function_in_call)), 
              R.getLookupName()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(R.getNameLoc(), diag.err_ovl_ambiguous_call)), R.getLookupName()));
          CandidateSet.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    FunctionDecl /*P*/ FD = Best./*->*/$star().Function;
    ActionResultTTrue<Expr /*P*/ > Fn = CreateFunctionRefExpr(/*Deref*/$this(), FD, Best./*->*/$star().FoundDecl.$NamedDecl$P(), 
        HadMultipleCandidates, 
        SuffixInfo.getLoc(), 
        SuffixInfo.getInfo());
    if (Fn.isInvalid()) {
      return new ActionResultTTrue<Expr /*P*/ >(true);
    }
    
    // Check the argument types. This should almost always be a no-op, except
    // that array-to-pointer decay is applied to string literals.
    Expr /*P*/ ConvArgs[/*2*/] = new Expr /*P*/  [2];
    for (/*uint*/int ArgIdx = 0, N = Args.size(); ArgIdx != N; ++ArgIdx) {
      ActionResultTTrue<Expr /*P*/ > InputInit = $this().PerformCopyInitialization(InitializedEntity.InitializeParameter($this().Context, FD.getParamDecl(ArgIdx)), 
          new SourceLocation(), new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Args.$at(ArgIdx)));
      if (InputInit.isInvalid()) {
        return new ActionResultTTrue<Expr /*P*/ >(true);
      }
      ConvArgs[ArgIdx] = InputInit.get();
    }
    
    QualType ResultTy = FD.getReturnType();
    ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultTy));
    ResultTy.$assignMove(ResultTy.getNonLValueExprType($this().Context));
    
    UserDefinedLiteral /*P*/ UDL = /*FIXME:NEW_EXPR*//*new (Context)*/ new UserDefinedLiteral($this().Context, Fn.get(), 
        llvm.makeArrayRef(create_type$ptr(ConvArgs), Args.size()), 
        new QualType(ResultTy), VK, new SourceLocation(LitEndLoc), new SourceLocation(UDSuffixLoc));
    if ($this().CheckCallReturnType(FD.getReturnType(), new SourceLocation(UDSuffixLoc), UDL, FD)) {
      return ExprError();
    }
    if ($this().CheckFunctionCall(FD, UDL, (/*const*/ FunctionProtoType /*P*/ )null)) {
      return ExprError();
    }
    
    return $this().MaybeBindToTemporary(UDL);
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}


/// PerformImplicitConversion - Perform an implicit conversion of the
/// expression From to the type ToType. Returns the
/// converted expression. Flavor is the kind of conversion we're
/// performing, used in the error message. If @p AllowExplicit,
/// explicit user-defined conversions are permitted.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformImplicitConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1354,
 FQN="clang::Sema::PerformImplicitConversion", NM="_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeENS0_16AssignmentActionEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeENS0_16AssignmentActionEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformImplicitConversion(Expr /*P*/ From, QualType ToType, 
                         AssignmentAction Action) {
  return PerformImplicitConversion(From, ToType, 
                         Action, false);
}
public final ActionResultTTrue<Expr /*P*/ > PerformImplicitConversion(Expr /*P*/ From, QualType ToType, 
                         AssignmentAction Action, boolean AllowExplicit/*= false*/) {
  ImplicitConversionSequence ICS = null;
  try {
    ICS/*J*/= new ImplicitConversionSequence();
    return $this().PerformImplicitConversion(From, new QualType(ToType), Action, AllowExplicit, ICS);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformImplicitConversion">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1361,
 FQN="clang::Sema::PerformImplicitConversion", NM="_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeENS0_16AssignmentActionEbRNS_26ImplicitConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeENS0_16AssignmentActionEbRNS_26ImplicitConversionSequenceE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformImplicitConversion(Expr /*P*/ _From, QualType ToType, 
                         AssignmentAction Action, boolean AllowExplicit, 
                         final ImplicitConversionSequence /*&*/ ICS) {
  type$ref<Expr /*P*/> From = create_type$ref(_From);
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (checkPlaceholderForOverload(/*Deref*/$this(), From)) {
      return ExprError();
    }
    
    // Objective-C ARC: Determine whether we will allow the writeback conversion.
    boolean AllowObjCWritebackConversion = $this().getLangOpts().ObjCAutoRefCount
       && (Action == AssignmentAction.AA_Passing || Action == AssignmentAction.AA_Sending);
    if ($this().getLangOpts().ObjC1) {
      $this().CheckObjCBridgeRelatedConversions(From.$deref().getLocStart(), 
          new QualType(ToType), From.$deref().getType(), From);
    }
    $c$.clean(ICS.$assign($c$.track(SemaOverloadStatics./*::*/TryImplicitConversion(/*Deref*/$this(), From.$deref(), new QualType(ToType), 
            /*SuppressUserConversions=*/ false, 
            AllowExplicit, 
            /*InOverloadResolution=*/ false, 
            /*CStyle=*/ false, 
            AllowObjCWritebackConversion, 
            /*AllowObjCConversionOnExplicit=*/ false))));
    return $this().PerformImplicitConversion(From.$deref(), new QualType(ToType), ICS, Action);
  } finally {
    $c$.$destroy();
  }
}


/// CompareReferenceRelationship - Compare the two types T1 and T2 to
/// determine whether they are reference-related,
/// reference-compatible, reference-compatible with added
/// qualification, or incompatible, for use in C++ initialization by
/// reference (C++ [dcl.ref.init]p4). Neither type can be a reference
/// type, and the first type (T1) is the pointee type of the reference
/// type being initialized.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CompareReferenceRelationship">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4078,
 FQN="clang::Sema::CompareReferenceRelationship", NM="_ZN5clang4Sema28CompareReferenceRelationshipENS_14SourceLocationENS_8QualTypeES2_RbS3_S3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang4Sema28CompareReferenceRelationshipENS_14SourceLocationENS_8QualTypeES2_RbS3_S3_")
//</editor-fold>
public final Sema.ReferenceCompareResult CompareReferenceRelationship(SourceLocation Loc, 
                            QualType OrigT1, QualType OrigT2, 
                            final bool$ref/*bool &*/ DerivedToBase, 
                            final bool$ref/*bool &*/ ObjCConversion, 
                            final bool$ref/*bool &*/ ObjCLifetimeConversion) {
  assert (!OrigT1.$arrow().isReferenceType()) : "T1 must be the pointee type of the reference type";
  assert (!OrigT2.$arrow().isReferenceType()) : "T2 cannot be a reference type";
  
  QualType T1 = $this().Context.getCanonicalType(new QualType(OrigT1)).$QualType();
  QualType T2 = $this().Context.getCanonicalType(new QualType(OrigT2)).$QualType();
  Qualifiers T1Quals/*J*/= new Qualifiers();
  Qualifiers T2Quals/*J*/= new Qualifiers();
  QualType UnqualT1 = $this().Context.getUnqualifiedArrayType(new QualType(T1), T1Quals);
  QualType UnqualT2 = $this().Context.getUnqualifiedArrayType(new QualType(T2), T2Quals);
  
  // C++ [dcl.init.ref]p4:
  //   Given types "cv1 T1" and "cv2 T2," "cv1 T1" is
  //   reference-related to "cv2 T2" if T1 is the same type as T2, or
  //   T1 is a base class of T2.
  DerivedToBase.$set(false);
  ObjCConversion.$set(false);
  ObjCLifetimeConversion.$set(false);
  if ($eq_QualType$C(UnqualT1, UnqualT2)) {
    // Nothing to do.
  } else if ($this().isCompleteType(new SourceLocation(Loc), new QualType(OrigT2))
     && isTypeValid(new QualType(UnqualT1)) && isTypeValid(new QualType(UnqualT2))
     && $this().IsDerivedFrom(new SourceLocation(Loc), new QualType(UnqualT2), new QualType(UnqualT1))) {
    DerivedToBase.$set(true);
  } else if (UnqualT1.$arrow().isObjCObjectOrInterfaceType()
     && UnqualT2.$arrow().isObjCObjectOrInterfaceType()
     && $this().Context.canBindObjCObjectType(new QualType(UnqualT1), new QualType(UnqualT2))) {
    ObjCConversion.$set(true);
  } else {
    return ReferenceCompareResult.Ref_Incompatible;
  }
  
  // At this point, we know that T1 and T2 are reference-related (at
  // least).
  
  // If the type is an array type, promote the element qualifiers to the type
  // for comparison.
  if (isa_ArrayType(T1) && T1Quals.$bool()) {
    T1.$assignMove($this().Context.getQualifiedType(new QualType(UnqualT1), new Qualifiers(T1Quals)));
  }
  if (isa_ArrayType(T2) && T2Quals.$bool()) {
    T2.$assignMove($this().Context.getQualifiedType(new QualType(UnqualT2), new Qualifiers(T2Quals)));
  }
  
  // C++ [dcl.init.ref]p4:
  //   "cv1 T1" is reference-compatible with "cv2 T2" if T1 is
  //   reference-related to T2 and cv1 is the same cv-qualification
  //   as, or greater cv-qualification than, cv2. For purposes of
  //   overload resolution, cases for which cv1 is greater
  //   cv-qualification than cv2 are identified as
  //   reference-compatible with added qualification (see 13.3.3.2).
  //
  // Note that we also require equivalence of Objective-C GC and address-space
  // qualifiers when performing these computations, so that e.g., an int in
  // address space 1 is not reference-compatible with an int in address
  // space 2.
  if (T1Quals.getObjCLifetime() != T2Quals.getObjCLifetime()
     && T1Quals.compatiblyIncludesObjCLifetime(new Qualifiers(T2Quals))) {
    if (isNonTrivialObjCLifetimeConversion(new Qualifiers(T2Quals), new Qualifiers(T1Quals))) {
      ObjCLifetimeConversion.$set(true);
    }
    
    T1Quals.removeObjCLifetime();
    T2Quals.removeObjCLifetime();
  }
  
  // MS compiler ignores __unaligned qualifier for references; do the same.
  T1Quals.removeUnaligned();
  T2Quals.removeUnaligned();
  if (T1Quals.$eq(/*NO_COPY*/T2Quals)) {
    return ReferenceCompareResult.Ref_Compatible;
  } else if (T1Quals.compatiblyIncludes(new Qualifiers(T2Quals))) {
    return ReferenceCompareResult.Ref_Compatible_With_Added_Qualification;
  } else {
    return ReferenceCompareResult.Ref_Related;
  }
}

} // END OF class Sema_SemaOverload
