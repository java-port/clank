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
import org.clang.ast.llvm.*;
import org.clang.ast.FunctionProtoType.*;
import org.clang.basic.*;
import org.clang.sema.impl.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.sema.java.SemaRTTI.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaExprCXXStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaExprCXX">
@Converted(kind = Converted.Kind.AUTO,
 NM="org.clang.sema.Sema_SemaExprCXX",
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaExpr ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema11ActOnCXXNewENS_14SourceLocationEbS1_N4llvm15MutableArrayRefIPNS_4ExprEEES1_NS_11SourceRangeERNS_10DeclaratorES5_;_ZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_b;_ZN5clang4Sema12ActOnCXXThisENS_14SourceLocationE;_ZN5clang4Sema13ActOnCXXThrowEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE;_ZN5clang4Sema13BuildCXXThrowENS_14SourceLocationEPNS_4ExprEb;_ZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprE;_ZN5clang4Sema14ActOnCXXTypeidENS_14SourceLocationES1_bPvS1_;_ZN5clang4Sema14ActOnCXXUuidofENS_14SourceLocationES1_bPvS1_;_ZN5clang4Sema14ActOnTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEES2_;_ZN5clang4Sema14BuildCXXTypeIdENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES2_;_ZN5clang4Sema14BuildCXXTypeIdENS_8QualTypeENS_14SourceLocationEPNS_4ExprES2_;_ZN5clang4Sema14BuildCXXUuidofENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES2_;_ZN5clang4Sema14BuildCXXUuidofENS_8QualTypeENS_14SourceLocationEPNS_4ExprES2_;_ZN5clang4Sema14BuildTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_;_ZN5clang4Sema17ActOnNoexceptExprENS_14SourceLocationES1_PNS_4ExprES1_;_ZN5clang4Sema17getDestructorNameENS_14SourceLocationERNS_14IdentifierInfoES1_PNS_5ScopeERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEEb;_ZN5clang4Sema17getDestructorTypeERKNS_8DeclSpecENS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang4Sema18CheckAllocatedTypeENS_8QualTypeENS_14SourceLocationENS_11SourceRangeE;_ZN5clang4Sema18getCurrentThisTypeEv;_ZN5clang4Sema19ActOnArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprES2_;_ZN5clang4Sema19ActOnCXXBoolLiteralENS_14SourceLocationENS_3tok9TokenKindE;_ZN5clang4Sema19ActOnFinishFullExprEPNS_4ExprENS_14SourceLocationEbbb;_ZN5clang4Sema19ActOnFinishFullStmtEPNS_4StmtE;_ZN5clang4Sema19BuildArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationEPNS_14TypeSourceInfoEPNS_4ExprES2_;_ZN5clang4Sema19CheckCXXThisCaptureENS_14SourceLocationEbbPKjb;_ZN5clang4Sema20ActOnExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES2_;_ZN5clang4Sema20BuildCXXNoexceptExprENS_14SourceLocationEPNS_4ExprES1_;_ZN5clang4Sema20BuildExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES2_;_ZN5clang4Sema20CheckCXXThrowOperandENS_14SourceLocationENS_8QualTypeEPNS_4ExprE;_ZN5clang4Sema20CheckVirtualDtorCallEPNS_17CXXDestructorDeclENS_14SourceLocationEbbbS3_;_ZN5clang4Sema20MaybeBindToTemporaryEPNS_4ExprE;_ZN5clang4Sema22ActOnCXXNullPtrLiteralENS_14SourceLocationE;_ZN5clang4Sema22ActOnConditionVariableEPNS_4DeclENS_14SourceLocationENS0_13ConditionKindE;_ZN5clang4Sema22BuildCXXMemberCallExprEPNS_4ExprEPNS_9NamedDeclEPNS_17CXXConversionDeclEb;_ZN5clang4Sema22CheckConditionVariableEPNS_7VarDeclENS_14SourceLocationENS0_13ConditionKindE;_ZN5clang4Sema22DeclareGlobalNewDeleteEv;_ZN5clang4Sema22FindAllocationOverloadENS_14SourceLocationENS_11SourceRangeENS_15DeclarationNameEN4llvm15MutableArrayRefIPNS_4ExprEEEPNS_11DeclContextEbRPNS_12FunctionDeclEb;_ZN5clang4Sema22checkLiteralOperatorIdERKNS_12CXXScopeSpecERKNS_13UnqualifiedIdE;_ZN5clang4Sema23ActOnDecltypeExpressionEPNS_4ExprE;_ZN5clang4Sema23FindAllocationFunctionsENS_14SourceLocationENS_11SourceRangeEbNS_8QualTypeEbN4llvm15MutableArrayRefIPNS_4ExprEEERPNS_12FunctionDeclESB_;_ZN5clang4Sema23IgnoredValueConversionsEPNS_4ExprE;_ZN5clang4Sema24CheckCXXBooleanConditionEPNS_4ExprEb;_ZN5clang4Sema24FindCompositePointerTypeENS_14SourceLocationERPNS_4ExprES4_Pb;_ZN5clang4Sema24FindDeallocationFunctionENS_14SourceLocationEPNS_13CXXRecordDeclENS_15DeclarationNameERPNS_12FunctionDeclEb;_ZN5clang4Sema25ActOnCXXTypeConstructExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_;_ZN5clang4Sema25ActOnPseudoDestructorExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecERNS_13UnqualifiedIdES5_S5_SB_;_ZN5clang4Sema25ActOnPseudoDestructorExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindES5_RKNS_8DeclSpecE;_ZN5clang4Sema25AnalyzeDeleteExprMismatchEPKNS_13CXXDeleteExprE;_ZN5clang4Sema25AnalyzeDeleteExprMismatchEPNS_9FieldDeclENS_14SourceLocationEb;_ZN5clang4Sema25BuildCXXTypeConstructExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES3_;_ZN5clang4Sema25BuildPseudoDestructorExprEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERKNS_12CXXScopeSpecEPNS_14TypeSourceInfoES3_S3_NS_27PseudoDestructorTypeStorageE;_ZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEPNS_7VarDeclEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEE;_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeERKNS_26ImplicitConversionSequenceENS0_16AssignmentActionENS0_21CheckedConversionKindE;_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeERKNS_26StandardConversionSequenceENS0_16AssignmentActionENS0_21CheckedConversionKindE;_ZN5clang4Sema27CXXCheckConditionalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_S5_RNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationE;_ZN5clang4Sema27MaybeCreateExprWithCleanupsENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema27MaybeCreateExprWithCleanupsEPNS_4ExprE;_ZN5clang4Sema27MaybeCreateStmtWithCleanupsEPNS_4StmtE;_ZN5clang4Sema28ActOnStartCXXMemberReferenceEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_9OpaquePtrINS_8QualTypeEEERb;_ZN5clang4Sema28CheckMicrosoftIfExistsSymbolEPNS_5ScopeENS_14SourceLocationEbRNS_12CXXScopeSpecERNS_13UnqualifiedIdE;_ZN5clang4Sema28CheckMicrosoftIfExistsSymbolEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE;_ZN5clang4Sema28CheckPointerToMemberOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_RNS_13ExprValueKindENS_14SourceLocationEb;_ZN5clang4Sema28getInheritingConstructorNameERNS_12CXXScopeSpecENS_14SourceLocationERNS_14IdentifierInfoE;_ZN5clang4Sema29FindUsualDeallocationFunctionENS_14SourceLocationEbNS_15DeclarationNameE;_ZN5clang4Sema31DeclareGlobalAllocationFunctionENS_15DeclarationNameENS_8QualTypeES2_S2_;_ZN5clang4Sema31isThisOutsideMemberFunctionBodyENS_8QualTypeE;_ZN5clang4Sema42IsStringLiteralToNonConstPointerConversionEPNS_4ExprENS_8QualTypeE; -static-type=Sema_SemaExprCXX -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaExprCXX extends Sema_SemaExpr {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::checkLiteralOperatorId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 342,
 FQN="clang::Sema::checkLiteralOperatorId", NM="_ZN5clang4Sema22checkLiteralOperatorIdERKNS_12CXXScopeSpecERKNS_13UnqualifiedIdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22checkLiteralOperatorIdERKNS_12CXXScopeSpecERKNS_13UnqualifiedIdE")
//</editor-fold>
public final boolean checkLiteralOperatorId(final /*const*/ CXXScopeSpec /*&*/ SS, 
                      final /*const*/ UnqualifiedId /*&*/ Name) {
  assert (Name.getKind() == UnqualifiedId.IdKind.IK_LiteralOperatorId);
  if (!SS.isValid()) {
    return false;
  }
  switch (SS.getScopeRep().getKind()) {
   case Identifier:
   case TypeSpec:
   case TypeSpecWithTemplate:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Per C++11 [over.literal]p2, literal operators can only be declared at
        // namespace scope. Therefore, this unqualified-id cannot name anything.
        // Reject it early, because we have no AST representation for this in the
        // case where the scope is dependent.
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_NestedNameSpec($c$.track($this().Diag(Name.getLocStart(), diag.err_literal_operator_id_outside_namespace)), 
            SS.getScopeRep()));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
   case Global:
   case Super:
   case Namespace:
   case NamespaceAlias:
    return false;
  }
  throw new llvm_unreachable("unknown nested name specifier kind");
}


/// \brief Process any TypoExprs in the given Expr and its children,
/// generating diagnostics as appropriate and returning a new Expr if there
/// were typos that were all successfully corrected and ExprError if one or
/// more typos could not be corrected.
///
/// \param E The Expr to check for TypoExprs.
///
/// \param InitDecl A VarDecl to avoid because the Expr being corrected is its
/// initializer.
///
/// \param Filter A function applied to a newly rebuilt Expr to determine if
/// it is an acceptable/usable result from a single combination of typo
/// corrections. As long as the filter returns ExprError, different
/// combinations of corrections will be tried until all are exhausted.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CorrectDelayedTyposInExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6947,
 FQN="clang::Sema::CorrectDelayedTyposInExpr", NM="_ZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEPNS_7VarDeclEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25CorrectDelayedTyposInExprEPNS_4ExprEPNS_7VarDeclEN4llvm12function_refIFNS_12ActionResultIS2_Lb1EEES2_EEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(Expr /*P*/ E) {
  return CorrectDelayedTyposInExpr(E, (VarDecl /*P*/ )null, 
                         /*FuncArg*//*[]*/ (Expr /*P*/ E$1) -> {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E$1);
    });
}
public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(Expr /*P*/ E, VarDecl /*P*/ InitDecl/*= null*/) {
  return CorrectDelayedTyposInExpr(E, InitDecl, 
                         /*FuncArg*//*[]*/ (Expr /*P*/ E$1) -> {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E$1);
    });
}
public final ActionResultTTrue<Expr /*P*/ > CorrectDelayedTyposInExpr(Expr /*P*/ E, VarDecl /*P*/ InitDecl/*= null*/, 
                         Expr2ExprResult Filter/*= FuncArg[] (Expr * E$1) -> ExprResult{
      return E;
    }*/) {
  // If the current evaluation context indicates there are uncorrected typos
  // and the current expression isn't guaranteed to not have typos, try to
  // resolve any TypoExpr nodes that might be in the expression.
  if ((E != null) && !$this().ExprEvalContexts.empty() && ($this().ExprEvalContexts.back().NumTypos != 0)
     && (E.isTypeDependent() || E.isValueDependent()
     || E.isInstantiationDependent())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      /*uint*/int TyposInContext = $this().ExprEvalContexts.back().NumTypos;
      assert ($less_uint(TyposInContext, ~0/*U*/)) : "Recursive call of CorrectDelayedTyposInExpr";
      $this().ExprEvalContexts.back().NumTypos = ~0/*U*/;
      /*size_t*/int TyposResolved = $this().DelayedTypos.size();
      ActionResultTTrue<Expr /*P*/ /*P*/> Result = $c$.clean($c$.track(new TransformTypos(/*Deref*/$this(), InitDecl, /*FuncArg*/Filter)).Transform(E));
      $this().ExprEvalContexts.back().NumTypos = TyposInContext;
      TyposResolved -= $this().DelayedTypos.size();
      if (Result.isInvalid() || Result.get() != E) {
        $this().ExprEvalContexts.back().NumTypos -= TyposResolved;
        return Result;
      }
      assert (TyposResolved == 0) : "Corrected typo but got same Expr back?";
    } finally {
      $c$.$destroy();
    }
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMicrosoftIfExistsSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 7083,
 FQN="clang::Sema::CheckMicrosoftIfExistsSymbol", NM="_ZN5clang4Sema28CheckMicrosoftIfExistsSymbolEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema28CheckMicrosoftIfExistsSymbolEPNS_5ScopeERNS_12CXXScopeSpecERKNS_19DeclarationNameInfoE")
//</editor-fold>
public final Sema.IfExistsResult CheckMicrosoftIfExistsSymbol(Scope /*P*/ S, 
                            final CXXScopeSpec /*&*/ SS, 
                            final /*const*/ DeclarationNameInfo /*&*/ TargetNameInfo) {
  LookupResult R = null;
  try {
    DeclarationName TargetName = TargetNameInfo.getName();
    if (!TargetName.$bool()) {
      return IfExistsResult.IER_DoesNotExist;
    }
    
    // If the name itself is dependent, then the result is dependent.
    if (TargetName.isDependentName()) {
      return IfExistsResult.IER_Dependent;
    }
    
    // Do the redeclaration lookup in the current scope.
    R/*J*/= new LookupResult(/*Deref*/$this(), TargetNameInfo, Sema.LookupNameKind.LookupAnyName, 
        Sema.RedeclarationKind.NotForRedeclaration);
    $this().LookupParsedName(R, S, $AddrOf(SS));
    R.suppressDiagnostics();
    switch (R.getResultKind()) {
     case Found:
     case FoundOverloaded:
     case FoundUnresolvedValue:
     case Ambiguous:
      return IfExistsResult.IER_Exists;
     case NotFound:
      return IfExistsResult.IER_DoesNotExist;
     case NotFoundInCurrentInstantiation:
      return IfExistsResult.IER_Dependent;
    }
    throw new llvm_unreachable("Invalid LookupResult Kind!");
  } finally {
    if (R != null) { R.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckMicrosoftIfExistsSymbol">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 7118,
 FQN="clang::Sema::CheckMicrosoftIfExistsSymbol", NM="_ZN5clang4Sema28CheckMicrosoftIfExistsSymbolEPNS_5ScopeENS_14SourceLocationEbRNS_12CXXScopeSpecERNS_13UnqualifiedIdE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema28CheckMicrosoftIfExistsSymbolEPNS_5ScopeENS_14SourceLocationEbRNS_12CXXScopeSpecERNS_13UnqualifiedIdE")
//</editor-fold>
public final Sema.IfExistsResult CheckMicrosoftIfExistsSymbol(Scope /*P*/ S, SourceLocation KeywordLoc, 
                            boolean IsIfExists, final CXXScopeSpec /*&*/ SS, 
                            final UnqualifiedId /*&*/ Name) {
  DeclarationNameInfo TargetNameInfo = $this().GetNameFromUnqualifiedId(Name);
  
  // Check for unexpanded parameter packs.
  SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>> Unexpanded/*J*/= new SmallVector<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(4, new std.pairTypeType<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>(new PointerUnion(TemplateTypeParmType.class), new SourceLocation()));
  $this().collectUnexpandedParameterPacks_CXXScopeSpec(SS, Unexpanded);
  $this().collectUnexpandedParameterPacks_DeclarationNameInfo(TargetNameInfo, Unexpanded);
  if (!Unexpanded.empty()) {
    $this().DiagnoseUnexpandedParameterPacks(new SourceLocation(KeywordLoc), 
        IsIfExists ? UnexpandedParameterPackContext.UPPC_IfExists : UnexpandedParameterPackContext.UPPC_IfNotExists, 
        new ArrayRef<std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation>>(Unexpanded, false));
    return IfExistsResult.IER_Error;
  }
  
  return $this().CheckMicrosoftIfExistsSymbol(S, SS, TargetNameInfo);
}


/// MaybeBindToTemporary - If the passed in expression has a record type with
/// a non-trivial destructor, this will return CXXBindTemporaryExpr. Otherwise
/// it simply returns the passed in expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MaybeBindToTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5585,
 FQN="clang::Sema::MaybeBindToTemporary", NM="_ZN5clang4Sema20MaybeBindToTemporaryEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema20MaybeBindToTemporaryEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > MaybeBindToTemporary(Expr /*P*/ E) {
  if (!(E != null)) {
    return SemaClangGlobals.ExprError();
  }
  assert (!isa_CXXBindTemporaryExpr(E)) : "Double-bound temporary?";
  
  // If the result is a glvalue, we shouldn't bind it.
  if (!E.isRValue()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  // In ARC, calls that return a retainable type can return retained,
  // in which case we have to insert a consuming cast.
  if ($this().getLangOpts().ObjCAutoRefCount
     && E.getType().$arrow().isObjCRetainableType()) {
    
    boolean ReturnsRetained;
    {
      
      // For actual calls, we compute this by examining the type of the
      // called value.
      CallExpr /*P*/ Call = dyn_cast_CallExpr(E);
      if ((Call != null)) {
        Expr /*P*/ Callee = Call.getCallee().IgnoreParens();
        QualType T = Callee.getType();
        if (QualType.$eq_QualType$C(T, $this().Context.BoundMemberTy.$QualType())) {
          {
            // Handle pointer-to-members.
            BinaryOperator /*P*/ BinOp = dyn_cast_BinaryOperator(Callee);
            if ((BinOp != null)) {
              T.$assignMove(BinOp.getRHS().getType());
            } else {
              MemberExpr /*P*/ Mem = dyn_cast_MemberExpr(Callee);
              if ((Mem != null)) {
                T.$assignMove(Mem.getMemberDecl().getType());
              }
            }
          }
        }
        {
          
          /*const*/ PointerType /*P*/ Ptr = T.$arrow().getAs(PointerType.class);
          if ((Ptr != null)) {
            T.$assignMove(Ptr.getPointeeType());
          } else {
            /*const*/ BlockPointerType /*P*/ Ptr$1 = T.$arrow().getAs(BlockPointerType.class);
            if ((Ptr$1 != null)) {
              T.$assignMove(Ptr$1.getPointeeType());
            } else {
              /*const*/ MemberPointerType /*P*/ MemPtr = T.$arrow().getAs(MemberPointerType.class);
              if ((MemPtr != null)) {
                T.$assignMove(MemPtr.getPointeeType());
              }
            }
          }
        }
        
        /*const*/ FunctionType /*P*/ FTy = T.$arrow().getAs(FunctionType.class);
        assert ((FTy != null)) : "call to value not of function type?";
        ReturnsRetained = FTy.getExtInfo().getProducesResult();
        // ActOnStmtExpr arranges things so that StmtExprs of retainable
        // type always produce a +1 object.
      } else if (isa_StmtExpr(E)) {
        ReturnsRetained = true;
        // We hit this case with the lambda conversion-to-block optimization;
        // we don't want any extra casts here.
      } else if (isa_CastExpr(E)
         && isa_BlockExpr(cast_CastExpr(E).getSubExpr())) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        // For message sends and property references, we try to find an
        // actual method.  FIXME: we should infer retention by selector in
        // cases where we don't have an actual method.
      } else {
        ObjCMethodDecl /*P*/ D = null;
        {
          ObjCMessageExpr /*P*/ Send = dyn_cast_ObjCMessageExpr(E);
          if ((Send != null)) {
            D = Send.getMethodDecl();
          } else {
            ObjCBoxedExpr /*P*/ BoxedExpr = dyn_cast_ObjCBoxedExpr(E);
            if ((BoxedExpr != null)) {
              D = BoxedExpr.getBoxingMethod();
            } else {
              ObjCArrayLiteral /*P*/ ArrayLit = dyn_cast_ObjCArrayLiteral(E);
              if ((ArrayLit != null)) {
                D = ArrayLit.getArrayWithObjectsMethod();
              } else {
                ObjCDictionaryLiteral /*P*/ DictLit = dyn_cast_ObjCDictionaryLiteral(E);
                if ((DictLit != null)) {
                  D = DictLit.getDictWithObjectsMethod();
                }
              }
            }
          }
        }
        
        ReturnsRetained = ((D != null) && D.hasAttr(NSReturnsRetainedAttr.class));
        
        // Don't do reclaims on performSelector calls; despite their
        // return type, the invoked method doesn't necessarily actually
        // return an object.
        if (!ReturnsRetained
           && (D != null) && D.getMethodFamily() == ObjCMethodFamily.OMF_performSelector) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
      }
    }
    
    // Don't reclaim an object of Class type.
    if (!ReturnsRetained && E.getType().$arrow().isObjCARCImplicitlyUnretainedType()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    
    $this().Cleanup.setExprNeedsCleanups(true);
    
    CastKind ck = (ReturnsRetained ? CastKind.CK_ARCConsumeObject : CastKind.CK_ARCReclaimReturnedObject);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ImplicitCastExpr.Create($this().Context, E.getType(), ck, E, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, 
            ExprValueKind.VK_RValue));
  }
  if (!$this().getLangOpts().CPlusPlus) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  // Search for the base element type (cf. ASTContext::getBaseElementType) with
  // a fast path for the common case that the type is directly a RecordType.
  /*const*/ Type /*P*/ T = $this().Context.getCanonicalType(E.getType().getTypePtr());
  /*const*/ RecordType /*P*/ RT = null;
  while (!(RT != null)) {
    switch (T.getTypeClass()) {
     case Record:
      RT = cast_RecordType(T);
      break;
     case ConstantArray:
     case IncompleteArray:
     case VariableArray:
     case DependentSizedArray:
      T = cast_ArrayType(T).getElementType().getTypePtr();
      break;
     default:
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
  }
  
  // That should be enough to guarantee that this type is complete, if we're
  // not processing a decltype expression.
  CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(RT.getDecl());
  if (RD.isInvalidDecl() || RD.isDependentContext()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  boolean IsDecltype = $this().ExprEvalContexts.back().IsDecltype;
  CXXDestructorDecl /*P*/ Destructor = IsDecltype ? null : $this().LookupDestructor(RD);
  if ((Destructor != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $this().MarkFunctionReferenced(E.getExprLoc(), Destructor);
      $c$.clean($this().CheckDestructorAccess(E.getExprLoc(), Destructor, 
          $out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor_temp)), 
              E.getType())));
      if ($this().DiagnoseUseOfDecl(Destructor, E.getExprLoc())) {
        return SemaClangGlobals.ExprError();
      }
      
      // If destructor is trivial, we can avoid the extra copy.
      if (Destructor.isTrivial()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      
      // We need a cleanup, but we don't need to remember the temporary.
      $this().Cleanup.setExprNeedsCleanups(true);
    } finally {
      $c$.$destroy();
    }
  }
  
  CXXTemporary /*P*/ Temp = CXXTemporary.Create($this().Context, Destructor);
  CXXBindTemporaryExpr /*P*/ Bind = CXXBindTemporaryExpr.Create($this().Context, Temp, E);
  if (IsDecltype) {
    $this().ExprEvalContexts.back().DelayedDecltypeBinds.push_back(Bind);
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Bind);
}


/// \brief Handle the result of the special case name lookup for inheriting
/// constructor declarations. 'NS::X::X' and 'NS::X<...>::X' are treated as
/// constructor names in member using declarations, even if 'X' is not the
/// name of the corresponding type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getInheritingConstructorName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 48,
 FQN="clang::Sema::getInheritingConstructorName", NM="_ZN5clang4Sema28getInheritingConstructorNameERNS_12CXXScopeSpecENS_14SourceLocationERNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema28getInheritingConstructorNameERNS_12CXXScopeSpecENS_14SourceLocationERNS_14IdentifierInfoE")
//</editor-fold>
public final OpaquePtr<QualType> getInheritingConstructorName(final CXXScopeSpec /*&*/ SS, 
                            SourceLocation NameLoc, 
                            final IdentifierInfo /*&*/ Name) {
  NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
  
  // Convert the nested-name-specifier into a type.
  QualType Type/*J*/= new QualType();
  switch (NNS.getKind()) {
   case TypeSpec:
   case TypeSpecWithTemplate:
    Type.$assignMove(new QualType(NNS.getAsType(), 0));
    break;
   case Identifier:
    // Strip off the last layer of the nested-name-specifier and build a
    // typename type for it.
    assert (NNS.getAsIdentifier() == $AddrOf(Name)) : "not a constructor name";
    Type.$assignMove($this().Context.getDependentNameType(ElaboratedTypeKeyword.ETK_None, NNS.getPrefix(), 
            NNS.getAsIdentifier()));
    break;
   case Global:
   case Super:
   case Namespace:
   case NamespaceAlias:
    throw new llvm_unreachable("Nested name specifier is not a type for inheriting ctor");
  }
  
  // This reference to the type is located entirely at the location of the
  // final identifier in the qualified-id.
  return $this().CreateParsedType(new QualType(Type), 
      $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/Type, /*NO_COPY*/NameLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getDestructorName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 82,
 FQN="clang::Sema::getDestructorName", NM="_ZN5clang4Sema17getDestructorNameENS_14SourceLocationERNS_14IdentifierInfoES1_PNS_5ScopeERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema17getDestructorNameENS_14SourceLocationERNS_14IdentifierInfoES1_PNS_5ScopeERNS_12CXXScopeSpecENS_9OpaquePtrINS_8QualTypeEEEb")
//</editor-fold>
public final OpaquePtr<QualType> getDestructorName(SourceLocation TildeLoc, 
                 final IdentifierInfo /*&*/ II, 
                 SourceLocation NameLoc, 
                 Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                 OpaquePtr<QualType> ObjectTypePtr, 
                 boolean EnteringContext) {
  LookupResult Found = null;
  try {
    // Determine where to perform name lookup.
    
    // FIXME: This area of the standard is very messy, and the current
    // wording is rather unclear about which scopes we search for the
    // destructor name; see core issues 399 and 555. Issue 399 in
    // particular shows where the current description of destructor name
    // lookup is completely out of line with existing practice, e.g.,
    // this appears to be ill-formed:
    //
    //   namespace N {
    //     template <typename T> struct S {
    //       ~S();
    //     };
    //   }
    //
    //   void f(N::S<int>* s) {
    //     s->N::S<int>::~S();
    //   }
    //
    // See also PR6358 and PR6359.
    // For this reason, we're currently only doing the C++03 version of this
    // code; the C++0x version has to wait until we get a proper spec.
    QualType SearchType/*J*/= new QualType();
    DeclContext /*P*/ LookupCtx = null;
    boolean isDependent = false;
    boolean LookInScope = false;
    if (SS.isInvalid()) {
      return new OpaquePtr<QualType>(null);
    }
    
    // If we have an object type, it's because we are in a
    // pseudo-destructor-expression or a member access expression, and
    // we know what type we're looking for.
    if (ObjectTypePtr.$bool()) {
      SearchType.$assignMove(GetTypeFromParser(new OpaquePtr<QualType>(ObjectTypePtr)));
    }
    if (SS.isSet()) {
      NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
      
      boolean AlreadySearched = false;
      boolean LookAtPrefix = true;
      // C++11 [basic.lookup.qual]p6:
      //   If a pseudo-destructor-name (5.2.4) contains a nested-name-specifier,
      //   the type-names are looked up as types in the scope designated by the
      //   nested-name-specifier. Similarly, in a qualified-id of the form:
      //
      //     nested-name-specifier[opt] class-name :: ~ class-name
      //
      //   the second class-name is looked up in the same scope as the first.
      //
      // Here, we determine whether the code below is permitted to look at the
      // prefix of the nested-name-specifier.
      DeclContext /*P*/ DC = $this().computeDeclContext(SS, EnteringContext);
      if ((DC != null) && DC.isFileContext()) {
        AlreadySearched = true;
        LookupCtx = DC;
        isDependent = false;
      } else if ((DC != null) && isa_CXXRecordDecl(DC)) {
        LookAtPrefix = false;
        LookInScope = true;
      }
      
      // The second case from the C++03 rules quoted further above.
      NestedNameSpecifier /*P*/ Prefix = null;
      if (AlreadySearched) {
        // Nothing left to do.
      } else if (LookAtPrefix && ((Prefix = NNS.getPrefix()) != null)) {
        CXXScopeSpec PrefixSS = null;
        try {
          PrefixSS/*J*/= new CXXScopeSpec();
          PrefixSS.Adopt(new NestedNameSpecifierLoc(Prefix, SS.location_data()));
          LookupCtx = $this().computeDeclContext(PrefixSS, EnteringContext);
          isDependent = $this().isDependentScopeSpecifier(PrefixSS);
        } finally {
          if (PrefixSS != null) { PrefixSS.$destroy(); }
        }
      } else if (ObjectTypePtr.$bool()) {
        LookupCtx = $this().computeDeclContext(new QualType(SearchType));
        isDependent = SearchType.$arrow().isDependentType();
      } else {
        LookupCtx = $this().computeDeclContext(SS, EnteringContext);
        isDependent = (LookupCtx != null) && LookupCtx.isDependentContext();
      }
    } else if (ObjectTypePtr.$bool()) {
      // C++ [basic.lookup.classref]p3:
      //   If the unqualified-id is ~type-name, the type-name is looked up
      //   in the context of the entire postfix-expression. If the type T
      //   of the object expression is of a class type C, the type-name is
      //   also looked up in the scope of class C. At least one of the
      //   lookups shall find a name that refers to (possibly
      //   cv-qualified) T.
      LookupCtx = $this().computeDeclContext(new QualType(SearchType));
      isDependent = SearchType.$arrow().isDependentType();
      assert ((isDependent || !SearchType.$arrow().isIncompleteType())) : "Caller should have completed object type";
      
      LookInScope = true;
    } else {
      // Perform lookup into the current scope (only).
      LookInScope = true;
    }
    
    TypeDecl /*P*/ NonMatchingTypeDecl = null;
    Found/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName($AddrOf(II)), new SourceLocation(NameLoc), LookupNameKind.LookupOrdinaryName);
    for (/*uint*/int Step = 0; Step != 2; ++Step) {
      // Look for the name first in the computed lookup context (if we
      // have one) and, if that fails to find a match, in the scope (if
      // we're allowed to look there).
      Found.clear();
      if (Step == 0 && (LookupCtx != null)) {
        $this().LookupQualifiedName(Found, LookupCtx);
      } else if (Step == 1 && LookInScope && (S != null)) {
        $this().LookupName(Found, S);
      } else {
        continue;
      }
      
      // FIXME: Should we be suppressing ambiguities here?
      if (Found.isAmbiguous()) {
        return new OpaquePtr<QualType>(null);
      }
      {
        
        TypeDecl /*P*/ Type = Found.<TypeDecl>getAsSingle(TypeDecl.class);
        if ((Type != null)) {
          QualType T = $this().Context.getTypeDeclType(Type);
          $this().MarkAnyDeclReferenced(Type.getLocation(), Type, /*OdrUse=*/ false);
          if (SearchType.isNull() || SearchType.$arrow().isDependentType()
             || $this().Context.hasSameUnqualifiedType(new QualType(T), new QualType(SearchType))) {
            // We found our type!
            return $this().CreateParsedType(new QualType(T), 
                $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T, /*NO_COPY*/NameLoc));
          }
          if (!SearchType.isNull()) {
            NonMatchingTypeDecl = Type;
          }
        }
      }
      {
        
        // If the name that we found is a class template name, and it is
        // the same name as the template name in the last part of the
        // nested-name-specifier (if present) or the object type, then
        // this is the destructor for that class.
        // FIXME: This is a workaround until we get real drafting for core
        // issue 399, for which there isn't even an obvious direction.
        ClassTemplateDecl /*P*/ Template = Found.<ClassTemplateDecl>getAsSingle(ClassTemplateDecl.class);
        if ((Template != null)) {
          QualType MemberOfType/*J*/= new QualType();
          if (SS.isSet()) {
            {
              DeclContext /*P*/ Ctx = $this().computeDeclContext(SS, EnteringContext);
              if ((Ctx != null)) {
                {
                  // Figure out the type of the context, if it has one.
                  CXXRecordDecl /*P*/ Record = dyn_cast_CXXRecordDecl(Ctx);
                  if ((Record != null)) {
                    MemberOfType.$assignMove($this().Context.getTypeDeclType(Record));
                  }
                }
              }
            }
          }
          if (MemberOfType.isNull()) {
            MemberOfType.$assign(SearchType);
          }
          if (MemberOfType.isNull()) {
            continue;
          }
          {
            
            // We're referring into a class template specialization. If the
            // class template we found is the same as the template being
            // specialized, we found what we are looking for.
            /*const*/ RecordType /*P*/ Record = MemberOfType.$arrow().getAs$RecordType();
            if ((Record != null)) {
              {
                ClassTemplateSpecializationDecl /*P*/ Spec = dyn_cast_ClassTemplateSpecializationDecl(Record.getDecl());
                if ((Spec != null)) {
                  if (Spec.getSpecializedTemplate().getCanonicalDecl()
                     == Template.getCanonicalDecl()) {
                    return $this().CreateParsedType(new QualType(MemberOfType), 
                        $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/MemberOfType, /*NO_COPY*/NameLoc));
                  }
                }
              }
              
              continue;
            }
          }
          {
            
            // We're referring to an unresolved class template
            // specialization. Determine whether we class template we found
            // is the same as the template being specialized or, if we don't
            // know which template is being specialized, that it at least
            // has the same name.
            /*const*/ TemplateSpecializationType /*P*/ SpecType = MemberOfType.$arrow().getAs$TemplateSpecializationType();
            if ((SpecType != null)) {
              TemplateName SpecName = SpecType.getTemplateName();
              {
                
                // The class template we found is the same template being
                // specialized.
                TemplateDecl /*P*/ SpecTemplate = SpecName.getAsTemplateDecl();
                if ((SpecTemplate != null)) {
                  if (SpecTemplate.getCanonicalDecl() == Template.getCanonicalDecl()) {
                    return $this().CreateParsedType(new QualType(MemberOfType), 
                        $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/MemberOfType, /*NO_COPY*/NameLoc));
                  }
                  
                  continue;
                }
              }
              {
                
                // The class template we found has the same name as the
                // (dependent) template name being specialized.
                DependentTemplateName /*P*/ DepTemplate = SpecName.getAsDependentTemplateName();
                if ((DepTemplate != null)) {
                  if (DepTemplate.isIdentifier()
                     && DepTemplate.getIdentifier() == Template.getIdentifier()) {
                    return $this().CreateParsedType(new QualType(MemberOfType), 
                        $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/MemberOfType, /*NO_COPY*/NameLoc));
                  }
                  
                  continue;
                }
              }
            }
          }
        }
      }
    }
    if (isDependent) {
      // We didn't find our type, but that's okay: it's dependent
      // anyway.
      
      // FIXME: What if we have no nested-name-specifier?
      QualType T = $this().CheckTypenameType(ElaboratedTypeKeyword.ETK_None, new SourceLocation(), 
          SS.getWithLocInContext($this().Context), 
          II, new SourceLocation(NameLoc));
      return OpaquePtr.<QualType>make(new QualType(T));
    }
    if ((NonMatchingTypeDecl != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        QualType T = $this().Context.getTypeDeclType(NonMatchingTypeDecl);
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_destructor_expr_type_mismatch)), 
                T), SearchType));
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(NonMatchingTypeDecl.getLocation(), diag.note_destructor_type_here)), 
            T));
      } finally {
        $c$.$destroy();
      }
    } else if (ObjectTypePtr.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(NameLoc), diag.err_ident_in_dtor_not_a_type)), 
            $AddrOf(II)));
      } finally {
        $c$.$destroy();
      }
    } else {
      SemaDiagnosticBuilder DtorDiag = null;
      try {
        DtorDiag = $this().Diag(new SourceLocation(NameLoc), 
            diag.err_destructor_class_name);
        if ((S != null)) {
          /*const*/ DeclContext /*P*/ Ctx = S.getEntity();
          {
            /*const*/ CXXRecordDecl /*P*/ Class = dyn_cast_or_null_CXXRecordDecl(Ctx);
            if ((Class != null)) {
              SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(DtorDiag, FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/NameLoc), 
                      new StringRef(Class.getNameAsString())));
            }
          }
        }
      } finally {
        if (DtorDiag != null) { DtorDiag.$destroy(); }
      }
    }
    
    return new OpaquePtr<QualType>(null);
  } finally {
    if (Found != null) { Found.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::getDestructorType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 326,
 FQN="clang::Sema::getDestructorType", NM="_ZN5clang4Sema17getDestructorTypeERKNS_8DeclSpecENS_9OpaquePtrINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema17getDestructorTypeERKNS_8DeclSpecENS_9OpaquePtrINS_8QualTypeEEE")
//</editor-fold>
public final OpaquePtr<QualType> getDestructorType(final /*const*/ DeclSpec /*&*/ DS, OpaquePtr<QualType> ObjectType) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (DS.getTypeSpecType() == DeclSpec.TST_error || !ObjectType.$bool()) {
      return new OpaquePtr<QualType>(null);
    }
    assert (DS.getTypeSpecType() == DeclSpec.TST_decltype) : "only get destructor types from declspecs";
    QualType T = $this().BuildDecltypeType(DS.getRepAsExpr(), DS.getTypeSpecTypeLoc());
    QualType SearchType = GetTypeFromParser(new OpaquePtr<QualType>(ObjectType));
    if (SearchType.$arrow().isDependentType() || $this().Context.hasSameUnqualifiedType(new QualType(SearchType), new QualType(T))) {
      return OpaquePtr.<QualType>make(new QualType(T));
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(DS.getTypeSpecTypeLoc(), diag.err_destructor_expr_type_mismatch)), 
            T), SearchType));
    return new OpaquePtr<QualType>(null);
  } finally {
    $c$.$destroy();
  }
}


/// \brief Build a C++ typeid expression with a type operand.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXTypeId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 372,
 FQN="clang::Sema::BuildCXXTypeId", NM="_ZN5clang4Sema14BuildCXXTypeIdENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14BuildCXXTypeIdENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXTypeId(QualType TypeInfoType, 
              SourceLocation TypeidLoc, 
              TypeSourceInfo /*P*/ Operand, 
              SourceLocation RParenLoc) {
  // C++ [expr.typeid]p4:
  //   The top-level cv-qualifiers of the lvalue expression or the type-id
  //   that is the operand of typeid are always ignored.
  //   If the type of the type-id is a class type or a reference to a class
  //   type, the class shall be completely-defined.
  Qualifiers Quals/*J*/= new Qualifiers();
  QualType T = $this().Context.getUnqualifiedArrayType(Operand.getType().getNonReferenceType(), 
      Quals);
  if ((T.$arrow().getAs$RecordType() != null)
     && $this().RequireCompleteType(new SourceLocation(TypeidLoc), new QualType(T), diag.err_incomplete_typeid)) {
    return SemaClangGlobals.ExprError();
  }
  if (T.$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(TypeidLoc), diag.err_variably_modified_typeid)), T)));
    } finally {
      $c$.$destroy();
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXTypeidExpr(TypeInfoType.withConst(), Operand, 
                  new SourceRange(/*NO_COPY*/TypeidLoc, /*NO_COPY*/RParenLoc));
       }));
}


/// \brief Build a C++ typeid expression with an expression operand.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXTypeId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 397,
 FQN="clang::Sema::BuildCXXTypeId", NM="_ZN5clang4Sema14BuildCXXTypeIdENS_8QualTypeENS_14SourceLocationEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14BuildCXXTypeIdENS_8QualTypeENS_14SourceLocationEPNS_4ExprES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXTypeId(QualType TypeInfoType, 
              SourceLocation TypeidLoc, 
              Expr /*P*/ E, 
              SourceLocation RParenLoc) {
  boolean WasEvaluated = false;
  if ((E != null) && !E.isTypeDependent()) {
    if (E.getType().$arrow().isPlaceholderType()) {
      ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(E);
      if (result.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      E = result.get();
    }
    
    QualType T = E.getType();
    {
      /*const*/ RecordType /*P*/ RecordT = T.$arrow().getAs$RecordType();
      if ((RecordT != null)) {
        CXXRecordDecl /*P*/ RecordD = cast_CXXRecordDecl(RecordT.getDecl());
        // C++ [expr.typeid]p3:
        //   [...] If the type of the expression is a class type, the class
        //   shall be completely-defined.
        if ($this().RequireCompleteType(new SourceLocation(TypeidLoc), new QualType(T), diag.err_incomplete_typeid)) {
          return SemaClangGlobals.ExprError();
        }
        
        // C++ [expr.typeid]p3:
        //   When typeid is applied to an expression other than an glvalue of a
        //   polymorphic class type [...] [the] expression is an unevaluated
        //   operand. [...]
        if (RecordD.isPolymorphic() && E.isGLValue()) {
          // The subexpression is potentially evaluated; switch the context
          // and recheck the subexpression.
          ActionResultTTrue<Expr /*P*/ > Result = $this().TransformToPotentiallyEvaluated(E);
          if (Result.isInvalid()) {
            return SemaClangGlobals.ExprError();
          }
          E = Result.get();
          
          // We require a vtable to query the type at run time.
          $this().MarkVTableUsed(new SourceLocation(TypeidLoc), RecordD);
          WasEvaluated = true;
        }
      }
    }
    
    // C++ [expr.typeid]p4:
    //   [...] If the type of the type-id is a reference to a possibly
    //   cv-qualified type, the result of the typeid expression refers to a
    //   std::type_info object representing the cv-unqualified referenced
    //   type.
    Qualifiers Quals/*J*/= new Qualifiers();
    QualType UnqualT = $this().Context.getUnqualifiedArrayType(new QualType(T), Quals);
    if (!$this().Context.hasSameType(new QualType(T), new QualType(UnqualT))) {
      T.$assign(UnqualT);
      E = $this().ImpCastExprToType(E, new QualType(UnqualT), CastKind.CK_NoOp, E.getValueKind()).get();
    }
  }
  if (E.getType().$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(TypeidLoc), diag.err_variably_modified_typeid)), 
              E.getType())));
    } finally {
      $c$.$destroy();
    }
  } else if ($this().ActiveTemplateInstantiations.empty()
     && E.HasSideEffects($this().Context, WasEvaluated)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The expression operand for typeid is in an unevaluated expression
      // context, so side effects could result in unintended consequences.
      $c$.clean($c$.track($this().Diag(E.getExprLoc(), WasEvaluated ? diag.warn_side_effects_typeid : diag.warn_side_effects_unevaluated_context)));
    } finally {
      $c$.$destroy();
    }
  }
  
  final Expr/*P*/ L$E = E;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXTypeidExpr(TypeInfoType.withConst(), L$E, 
                  new SourceRange(/*NO_COPY*/TypeidLoc, /*NO_COPY*/RParenLoc));
       }));
}


/// ActOnCXXTypeid - Parse typeid( something ).

/// ActOnCXXTypeidOfType - Parse typeid( type-id ) or typeid (expression);
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXTypeid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 465,
 FQN="clang::Sema::ActOnCXXTypeid", NM="_ZN5clang4Sema14ActOnCXXTypeidENS_14SourceLocationES1_bPvS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14ActOnCXXTypeidENS_14SourceLocationES1_bPvS1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXTypeid(SourceLocation OpLoc, SourceLocation LParenLoc, 
              boolean isType, Object/*void P*/ TyOrExpr, SourceLocation RParenLoc) {
  // Find the std::type_info type.
  if (!($this().getStdNamespace() != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_need_header_before_typeid))));
    } finally {
      $c$.$destroy();
    }
  }
  if (!($this().CXXTypeInfoDecl != null)) {
    LookupResult R = null;
    try {
      IdentifierInfo /*P*/ TypeInfoII = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"type_info")));
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(TypeInfoII), new SourceLocation(), LookupNameKind.LookupTagName);
      $this().LookupQualifiedName(R, $this().getStdNamespace());
      $this().CXXTypeInfoDecl = R.<RecordDecl>getAsSingle(RecordDecl.class);
      // Microsoft's typeinfo doesn't have type_info in std but in the global
      // namespace if _HAS_EXCEPTIONS is defined to 0. See PR13153.
      if (!($this().CXXTypeInfoDecl != null) && $this().LangOpts.MSVCCompat) {
        $this().LookupQualifiedName(R, $this().Context.getTranslationUnitDecl());
        $this().CXXTypeInfoDecl = R.<RecordDecl>getAsSingle(RecordDecl.class);
      }
      if (!($this().CXXTypeInfoDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_need_header_before_typeid))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }
  if (!$this().getLangOpts().RTTI) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_no_typeid_with_fno_rtti))));
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType TypeInfoType = $this().Context.getTypeDeclType($this().CXXTypeInfoDecl);
  if (isType) {
    // The operand is a type; handle it as such.
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    QualType T = GetTypeFromParser(OpaquePtr.<QualType>getFromOpaquePtr(TyOrExpr), 
        $AddrOf(TInfo));
    if (T.isNull()) {
      return SemaClangGlobals.ExprError();
    }
    if (!(TInfo.$star() != null)) {
      TInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T, /*NO_COPY*/OpLoc));
    }
    
    return $this().BuildCXXTypeId(new QualType(TypeInfoType), new SourceLocation(OpLoc), TInfo.$star(), new SourceLocation(RParenLoc));
  }
  
  // The operand is an expression.
  return $this().BuildCXXTypeId(new QualType(TypeInfoType), new SourceLocation(OpLoc), (Expr /*P*/ )TyOrExpr, new SourceLocation(RParenLoc));
}


/// \brief Build a Microsoft __uuidof expression with a type operand.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXUuidof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 549,
 FQN="clang::Sema::BuildCXXUuidof", NM="_ZN5clang4Sema14BuildCXXUuidofENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14BuildCXXUuidofENS_8QualTypeENS_14SourceLocationEPNS_14TypeSourceInfoES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXUuidof(QualType TypeInfoType, 
              SourceLocation TypeidLoc, 
              TypeSourceInfo /*P*/ Operand, 
              SourceLocation RParenLoc) {
  StringRef UuidStr/*J*/= new StringRef();
  if (!Operand.getType().$arrow().isDependentType()) {
    SmallSetVector</*const*/ UuidAttr /*P*/ > UuidAttrs/*J*/= new SmallSetVector</*const*/ UuidAttr /*P*/ >(1, (/*const*/ UuidAttr /*P*/ ) null);
    SemaExprCXXStatics.getUuidAttrOfType(/*Deref*/$this(), Operand.getType(), UuidAttrs);
    if (UuidAttrs.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(TypeidLoc), diag.err_uuidof_without_guid))));
      } finally {
        $c$.$destroy();
      }
    }
    if ($greater_uint(UuidAttrs.size(), 1)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(TypeidLoc), diag.err_uuidof_with_multiple_guids))));
      } finally {
        $c$.$destroy();
      }
    }
    UuidStr.$assignMove(UuidAttrs.back().getGuid());
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXUuidofExpr(TypeInfoType.withConst(), Operand, new StringRef(UuidStr), 
                  new SourceRange(/*NO_COPY*/TypeidLoc, /*NO_COPY*/RParenLoc));
       }));
}


/// \brief Build a Microsoft __uuidof expression with an expression operand.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXUuidof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 569,
 FQN="clang::Sema::BuildCXXUuidof", NM="_ZN5clang4Sema14BuildCXXUuidofENS_8QualTypeENS_14SourceLocationEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14BuildCXXUuidofENS_8QualTypeENS_14SourceLocationEPNS_4ExprES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXUuidof(QualType TypeInfoType, 
              SourceLocation TypeidLoc, 
              Expr /*P*/ E, 
              SourceLocation RParenLoc) {
  StringRef UuidStr/*J*/= new StringRef();
  if (!E.getType().$arrow().isDependentType()) {
    if ((E.isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
      UuidStr.$assignMove(/*STRINGREF_STR*/"00000000-0000-0000-0000-000000000000");
    } else {
      SmallSetVector</*const*/ UuidAttr /*P*/ > UuidAttrs/*J*/= new SmallSetVector</*const*/ UuidAttr /*P*/ >(1, (/*const*/ UuidAttr /*P*/ ) null);
      SemaExprCXXStatics.getUuidAttrOfType(/*Deref*/$this(), E.getType(), UuidAttrs);
      if (UuidAttrs.empty()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(TypeidLoc), diag.err_uuidof_without_guid))));
        } finally {
          $c$.$destroy();
        }
      }
      if ($greater_uint(UuidAttrs.size(), 1)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(TypeidLoc), diag.err_uuidof_with_multiple_guids))));
        } finally {
          $c$.$destroy();
        }
      }
      UuidStr.$assignMove(UuidAttrs.back().getGuid());
    }
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXUuidofExpr(TypeInfoType.withConst(), E, new StringRef(UuidStr), 
                  new SourceRange(/*NO_COPY*/TypeidLoc, /*NO_COPY*/RParenLoc));
       }));
}


/// ActOnCXXUuidof - Parse __uuidof( something ).

/// ActOnCXXUuidof - Parse __uuidof( type-id ) or __uuidof (expression);
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXUuidof">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 593,
 FQN="clang::Sema::ActOnCXXUuidof", NM="_ZN5clang4Sema14ActOnCXXUuidofENS_14SourceLocationES1_bPvS1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14ActOnCXXUuidofENS_14SourceLocationES1_bPvS1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXUuidof(SourceLocation OpLoc, SourceLocation LParenLoc, 
              boolean isType, Object/*void P*/ TyOrExpr, SourceLocation RParenLoc) {
  // If MSVCGuidDecl has not been cached, do the lookup.
  if (!($this().MSVCGuidDecl != null)) {
    LookupResult R = null;
    try {
      IdentifierInfo /*P*/ GuidII = $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"_GUID")));
      R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(GuidII), new SourceLocation(), LookupNameKind.LookupTagName);
      $this().LookupQualifiedName(R, $this().Context.getTranslationUnitDecl());
      $this().MSVCGuidDecl = R.<RecordDecl>getAsSingle(RecordDecl.class);
      if (!($this().MSVCGuidDecl != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_need_header_before_ms_uuidof))));
        } finally {
          $c$.$destroy();
        }
      }
    } finally {
      if (R != null) { R.$destroy(); }
    }
  }
  
  QualType GuidType = $this().Context.getTypeDeclType($this().MSVCGuidDecl);
  if (isType) {
    // The operand is a type; handle it as such.
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr(null);
    QualType T = GetTypeFromParser(OpaquePtr.<QualType>getFromOpaquePtr(TyOrExpr), 
        $AddrOf(TInfo));
    if (T.isNull()) {
      return SemaClangGlobals.ExprError();
    }
    if (!(TInfo.$star() != null)) {
      TInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T, /*NO_COPY*/OpLoc));
    }
    
    return $this().BuildCXXUuidof(new QualType(GuidType), new SourceLocation(OpLoc), TInfo.$star(), new SourceLocation(RParenLoc));
  }
  
  // The operand is an expression.
  return $this().BuildCXXUuidof(new QualType(GuidType), new SourceLocation(OpLoc), (Expr /*P*/ )TyOrExpr, new SourceLocation(RParenLoc));
}


//// ActOnCXXThis -  Parse 'this' pointer.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXThis">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1182,
 FQN="clang::Sema::ActOnCXXThis", NM="_ZN5clang4Sema12ActOnCXXThisENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema12ActOnCXXThisENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXThis(SourceLocation Loc) {
  /// C++ 9.3.2: In the body of a non-static member function, the keyword this
  /// is a non-lvalue expression whose value is the address of the object for
  /// which the function is called.
  QualType ThisTy = $this().getCurrentThisType();
  if (ThisTy.isNull()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($c$.track($this().Diag(new SourceLocation(Loc), diag.err_invalid_this_use))));
    } finally {
      $c$.$destroy();
    }
  }
  
  $this().CheckCXXThisCapture(new SourceLocation(Loc));
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXThisExpr(new SourceLocation(Loc), new QualType(ThisTy), /*isImplicit=*/ false);
       }));
}


/// \brief Try to retrieve the type of the 'this' pointer.
///
/// \returns The type of 'this', if possible. Otherwise, returns a NULL type.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::getCurrentThisType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 961,
 FQN="clang::Sema::getCurrentThisType", NM="_ZN5clang4Sema18getCurrentThisTypeEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema18getCurrentThisTypeEv")
//</editor-fold>
public final QualType getCurrentThisType() {
  DeclContext /*P*/ DC = $this().getFunctionLevelDeclContext();
  QualType ThisTy = new QualType($this().CXXThisTypeOverride);
  {
    
    CXXMethodDecl /*P*/ method = dyn_cast_CXXMethodDecl(DC);
    if ((method != null)) {
      if ((method != null) && method.isInstance()) {
        ThisTy.$assignMove(method.getThisType($this().Context));
      }
    }
  }
  if (ThisTy.isNull() && isLambdaCallOperator($this().CurContext)
     && !$this().ActiveTemplateInstantiations.empty()) {
    assert (isa_CXXRecordDecl(DC)) : "Trying to get 'this' type from static method?";
    
    // This is a lambda call operator that is being instantiated as a default
    // initializer. DC must point to the enclosing class type, so we can recover
    // the 'this' type from it.
    QualType ClassTy = $this().Context.getTypeDeclType(cast_CXXRecordDecl(DC));
    // There are no cv-qualifiers for 'this' within default initializers,
    // per [expr.prim.general]p4.
    ThisTy.$assignMove($this().Context.getPointerType(/*NO_COPY*/ClassTy));
  }
  
  // If we are within a lambda's call operator, the cv-qualifiers of 'this'
  // might need to be adjusted if the lambda or any of its enclosing lambda's
  // captures '*this' by copy.
  if (!ThisTy.isNull() && isLambdaCallOperator($this().CurContext)) {
    return SemaExprCXXStatics.adjustCVQualifiersForCXXThisWithinLambda(new ArrayRef<FunctionScopeInfo /*P*/ >($this().FunctionScopes, true), new QualType(ThisTy), 
        $this().CurContext, $this().Context);
  }
  return ThisTy;
}


/// \brief Make sure the value of 'this' is actually available in the current
/// context, if it is a potentially evaluated context.
///
/// \param Loc The location at which the capture of 'this' occurs.
///
/// \param Explicit Whether 'this' is explicitly captured in a lambda
/// capture list.
///
/// \param FunctionScopeIndexToStopAt If non-null, it points to the index
/// of the FunctionScopeInfo stack beyond which we do not attempt to capture.
/// This is useful when enclosing lambdas must speculatively capture 
/// 'this' that may or may not be used in certain specializations of
/// a nested generic lambda (depending on whether the name resolves to 
/// a non-static member function or a static function).
/// \return returns 'true' if failed, 'false' if success.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCXXThisCapture">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1068,
 FQN="clang::Sema::CheckCXXThisCapture", NM="_ZN5clang4Sema19CheckCXXThisCaptureENS_14SourceLocationEbbPKjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema19CheckCXXThisCaptureENS_14SourceLocationEbbPKjb")
//</editor-fold>
public final boolean CheckCXXThisCapture(SourceLocation Loc) {
  return CheckCXXThisCapture(Loc, false, 
                   true, (/*const*/uint$ptr/*uint P*//*const*/)null, 
                   false);
}
public final boolean CheckCXXThisCapture(SourceLocation Loc, /*const*/boolean Explicit/*= false*/) {
  return CheckCXXThisCapture(Loc, Explicit, 
                   true, (/*const*/uint$ptr/*uint P*//*const*/)null, 
                   false);
}
public final boolean CheckCXXThisCapture(SourceLocation Loc, /*const*/boolean Explicit/*= false*/, 
                   boolean BuildAndDiagnose/*= true*/) {
  return CheckCXXThisCapture(Loc, Explicit, 
                   BuildAndDiagnose, (/*const*/uint$ptr/*uint P*//*const*/)null, 
                   false);
}
public final boolean CheckCXXThisCapture(SourceLocation Loc, /*const*/boolean Explicit/*= false*/, 
                   boolean BuildAndDiagnose/*= true*/, /*const*/uint$ptr/*uint P*//*const*/ FunctionScopeIndexToStopAt/*= null*/) {
  return CheckCXXThisCapture(Loc, Explicit, 
                   BuildAndDiagnose, FunctionScopeIndexToStopAt, 
                   false);
}
public final boolean CheckCXXThisCapture(SourceLocation Loc, /*const*/boolean Explicit/*= false*/, 
                   boolean BuildAndDiagnose/*= true*/, /*const*/uint$ptr/*uint P*//*const*/ FunctionScopeIndexToStopAt/*= null*/, 
                   /*const*/boolean ByCopy/*= false*/) {
  // We don't need to capture this in an unevaluated context.
  if ($this().isUnevaluatedContext() && !Explicit) {
    return true;
  }
  assert ((!ByCopy || Explicit)) : "cannot implicitly capture *this by value";
  
  /*const*//*uint*/int MaxFunctionScopesIndex = Native.$bool(FunctionScopeIndexToStopAt) ? FunctionScopeIndexToStopAt.$star() : $this().FunctionScopes.size() - 1;
  
  // Check that we can capture the *enclosing object* (referred to by '*this')
  // by the capturing-entity/closure (lambda/block/etc) at 
  // MaxFunctionScopesIndex-deep on the FunctionScopes stack.  
  
  // Note: The *enclosing object* can only be captured by-value by a 
  // closure that is a lambda, using the explicit notation: 
  //    [*this] { ... }.
  // Every other capture of the *enclosing object* results in its by-reference
  // capture.
  
  // For a closure 'L' (at MaxFunctionScopesIndex in the FunctionScopes
  // stack), we can capture the *enclosing object* only if:
  // - 'L' has an explicit byref or byval capture of the *enclosing object*
  // -  or, 'L' has an implicit capture.
  // AND 
  //   -- there is no enclosing closure
  //   -- or, there is some enclosing closure 'E' that has already captured the 
  //      *enclosing object*, and every intervening closure (if any) between 'E' 
  //      and 'L' can implicitly capture the *enclosing object*.
  //   -- or, every enclosing closure can implicitly capture the 
  //      *enclosing object*
  /*uint*/int NumCapturingClosures = 0;
  for (/*uint*/int idx = MaxFunctionScopesIndex; idx != 0; idx--) {
    {
      CapturingScopeInfo /*P*/ CSI = dyn_cast_CapturingScopeInfo($this().FunctionScopes.$at(idx));
      if ((CSI != null)) {
        if (CSI.CXXThisCaptureIndex != 0) {
          // 'this' is already being captured; there isn't anything more to do.
          break;
        }
        LambdaScopeInfo /*P*/ LSI = dyn_cast_LambdaScopeInfo(CSI);
        if ((LSI != null) && isGenericLambdaCallOperatorSpecialization(LSI.CallOperator)) {
          // This context can't implicitly capture 'this'; fail out.
          if (BuildAndDiagnose) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(new SourceLocation(Loc), diag.err_this_capture)), 
                  (Explicit && idx == MaxFunctionScopesIndex)));
            } finally {
              $c$.$destroy();
            }
          }
          return true;
        }
        if (CSI.ImpCaptureStyle == CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByref
           || CSI.ImpCaptureStyle == CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_LambdaByval
           || CSI.ImpCaptureStyle == CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_Block
           || CSI.ImpCaptureStyle == CapturingScopeInfo.ImplicitCaptureStyle.ImpCap_CapturedRegion
           || (Explicit && idx == MaxFunctionScopesIndex)) {
          // Regarding (Explicit && idx == MaxFunctionScopesIndex): only the first
          // iteration through can be an explicit capture, all enclosing closures,
          // if any, must perform implicit captures.
          
          // This closure can capture 'this'; continue looking upwards.
          NumCapturingClosures++;
          continue;
        }
        // This context can't implicitly capture 'this'; fail out.
        if (BuildAndDiagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(new SourceLocation(Loc), diag.err_this_capture)), 
                (Explicit && idx == MaxFunctionScopesIndex)));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
    }
    break;
  }
  if (!BuildAndDiagnose) {
    return false;
  }
  
  // If we got here, then the closure at MaxFunctionScopesIndex on the
  // FunctionScopes stack, can capture the *enclosing object*, so capture it
  // (including implicit by-reference captures in any enclosing closures).
  
  // In the loop below, respect the ByCopy flag only for the closure requesting
  // the capture (i.e. first iteration through the loop below).  Ignore it for
  // all enclosing closure's upto NumCapturingClosures (since they must be
  // implicitly capturing the *enclosing  object* by reference (see loop
  // above)).
  assert ((!ByCopy || (dyn_cast_LambdaScopeInfo($this().FunctionScopes.$at(MaxFunctionScopesIndex)) != null))) : "Only a lambda can capture the enclosing object (referred to by *this) by copy";
  // FIXME: We need to delay this marking in PotentiallyPotentiallyEvaluated
  // contexts.
  QualType ThisTy = $this().getCurrentThisType();
  for (/*uint*/int idx = MaxFunctionScopesIndex; (NumCapturingClosures != 0);
       --idx , --NumCapturingClosures) {
    CapturingScopeInfo /*P*/ CSI = cast_CapturingScopeInfo($this().FunctionScopes.$at(idx));
    Expr /*P*/ ThisExpr = null;
    {
      
      LambdaScopeInfo /*P*/ LSI = dyn_cast_LambdaScopeInfo(CSI);
      if ((LSI != null)) {
        // For lambda expressions, build a field and an initializing expression,
        // and capture the *enclosing object* by copy only if this is the first
        // iteration.
        ThisExpr = SemaExprCXXStatics.captureThis(/*Deref*/$this(), $this().Context, LSI.Lambda, new QualType(ThisTy), new SourceLocation(Loc), 
            ByCopy && idx == MaxFunctionScopesIndex);
      } else {
        CapturedRegionScopeInfo /*P*/ RSI = dyn_cast_CapturedRegionScopeInfo($this().FunctionScopes.$at(idx));
        if ((RSI != null)) {
          ThisExpr
             = SemaExprCXXStatics.captureThis(/*Deref*/$this(), $this().Context, RSI.TheRecordDecl, new QualType(ThisTy), new SourceLocation(Loc), 
              false/*ByCopy*/);
        }
      }
    }
    
    boolean isNested = $greater_uint(NumCapturingClosures, 1);
    CSI.addThisCapture(isNested, new SourceLocation(Loc), ThisExpr, ByCopy);
  }
  return false;
}


/// \brief Determine whether the given type is the type of *this that is used
/// outside of the body of a member function for a type that is currently
/// being defined.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::isThisOutsideMemberFunctionBody">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1194,
 FQN="clang::Sema::isThisOutsideMemberFunctionBody", NM="_ZN5clang4Sema31isThisOutsideMemberFunctionBodyENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema31isThisOutsideMemberFunctionBodyENS_8QualTypeE")
//</editor-fold>
public final boolean isThisOutsideMemberFunctionBody(QualType BaseType) {
  // If we're outside the body of a member function, then we'll have a specified
  // type for 'this'.
  if ($this().CXXThisTypeOverride.isNull()) {
    return false;
  }
  
  // Determine whether we're looking into a class that's currently being
  // defined.
  CXXRecordDecl /*P*/ Class = BaseType.$arrow().getAsCXXRecordDecl();
  return (Class != null) && Class.isBeingDefined();
}


/// ActOnCXXBoolLiteral - Parse {true,false} literals.

/// ActOnCXXBoolLiteral - Parse {true,false} literals.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXBoolLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 627,
 FQN="clang::Sema::ActOnCXXBoolLiteral", NM="_ZN5clang4Sema19ActOnCXXBoolLiteralENS_14SourceLocationENS_3tok9TokenKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema19ActOnCXXBoolLiteralENS_14SourceLocationENS_3tok9TokenKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXBoolLiteral(SourceLocation OpLoc, /*tok.TokenKind*/char Kind) {
  assert ((Kind == tok.TokenKind.kw_true || Kind == tok.TokenKind.kw_false)) : "Unknown C++ Boolean value!";
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXBoolLiteralExpr(Kind == tok.TokenKind.kw_true, $this().Context.BoolTy.$QualType(), new SourceLocation(OpLoc));
       }));
}


/// ActOnCXXNullPtrLiteral - Parse 'nullptr'.

/// ActOnCXXNullPtrLiteral - Parse 'nullptr'.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXNullPtrLiteral">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 636,
 FQN="clang::Sema::ActOnCXXNullPtrLiteral", NM="_ZN5clang4Sema22ActOnCXXNullPtrLiteralENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22ActOnCXXNullPtrLiteralENS_14SourceLocationE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXNullPtrLiteral(SourceLocation Loc) {
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXNullPtrLiteralExpr($this().Context.NullPtrTy.$QualType(), new SourceLocation(Loc));
       }));
}


//// ActOnCXXThrow -  Parse throw expressions.

/// ActOnCXXThrow - Parse throw expressions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 642,
 FQN="clang::Sema::ActOnCXXThrow", NM="_ZN5clang4Sema13ActOnCXXThrowEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema13ActOnCXXThrowEPNS_5ScopeENS_14SourceLocationEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXThrow(Scope /*P*/ S, SourceLocation OpLoc, Expr /*P*/ Ex) {
  boolean IsThrownVarInScope = false;
  if ((Ex != null)) {
    {
      // C++0x [class.copymove]p31:
      //   When certain criteria are met, an implementation is allowed to omit the
      //   copy/move construction of a class object [...]
      //
      //     - in a throw-expression, when the operand is the name of a
      //       non-volatile automatic object (other than a function or catch-
      //       clause parameter) whose scope does not extend beyond the end of the
      //       innermost enclosing try-block (if there is one), the copy/move
      //       operation from the operand to the exception object (15.1) can be
      //       omitted by constructing the automatic object directly into the
      //       exception object
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Ex.IgnoreParens());
      if ((DRE != null)) {
        {
          VarDecl /*P*/ Var = dyn_cast_VarDecl(DRE.getDecl());
          if ((Var != null)) {
            if (Var.hasLocalStorage() && !Var.getType().isVolatileQualified()) {
              for (; (S != null); S = S.getParent()) {
                if (S.isDeclScope(Var)) {
                  IsThrownVarInScope = true;
                  break;
                }
                if (((S.getFlags()
                   & (Scope.ScopeFlags.FnScope | Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.BlockScope
                   | Scope.ScopeFlags.FunctionPrototypeScope | Scope.ScopeFlags.ObjCMethodScope
                   | Scope.ScopeFlags.TryScope)) != 0)) {
                  break;
                }
              }
            }
          }
        }
      }
    }
  }
  
  return $this().BuildCXXThrow(new SourceLocation(OpLoc), Ex, IsThrownVarInScope);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXThrow">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 679,
 FQN="clang::Sema::BuildCXXThrow", NM="_ZN5clang4Sema13BuildCXXThrowENS_14SourceLocationEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema13BuildCXXThrowENS_14SourceLocationEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXThrow(SourceLocation OpLoc, Expr /*P*/ Ex, 
             boolean IsThrownVarInScope) {
  // Don't report an error if 'throw' is used in system headers.
  if (!$this().getLangOpts().CXXExceptions
     && !$this().getSourceManager().isInSystemHeader(/*NO_COPY*/OpLoc)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_exceptions_disabled)), /*KEEP_STR*/"throw"));
    } finally {
      $c$.$destroy();
    }
  }
  if (($this().getCurScope() != null) && $this().getCurScope().isOpenMPSimdDirectiveScope()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_omp_simd_region_cannot_use_stmt)), /*KEEP_STR*/"throw"));
    } finally {
      $c$.$destroy();
    }
  }
  if ((Ex != null) && !Ex.isTypeDependent()) {
    QualType ExceptionObjectTy = $this().Context.getExceptionObjectType(Ex.getType());
    if ($this().CheckCXXThrowOperand(new SourceLocation(OpLoc), new QualType(ExceptionObjectTy), Ex)) {
      return SemaClangGlobals.ExprError();
    }
    
    // Initialize the exception result.  This implicitly weeds out
    // abstract types or types with inaccessible copy constructors.
    
    // C++0x [class.copymove]p31:
    //   When certain criteria are met, an implementation is allowed to omit the
    //   copy/move construction of a class object [...]
    //
    //     - in a throw-expression, when the operand is the name of a
    //       non-volatile automatic object (other than a function or
    //       catch-clause
    //       parameter) whose scope does not extend beyond the end of the
    //       innermost enclosing try-block (if there is one), the copy/move
    //       operation from the operand to the exception object (15.1) can be
    //       omitted by constructing the automatic object directly into the
    //       exception object
    /*const*/ VarDecl /*P*/ NRVOVariable = null;
    if (IsThrownVarInScope) {
      NRVOVariable = $this().getCopyElisionCandidate(new QualType(), Ex, false);
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeException(new SourceLocation(OpLoc), new QualType(ExceptionObjectTy), 
        /*NRVO=*/ NRVOVariable != (/*const*/ VarDecl /*P*/ )null);
    ActionResultTTrue<Expr /*P*/ > Res = $this().PerformMoveOrCopyInitialization(Entity, NRVOVariable, new QualType(), Ex, IsThrownVarInScope);
    if (Res.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    Ex = Res.get();
  }
  
  final Expr /*P*/ L$Ex = Ex;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXThrowExpr(L$Ex, $this().Context.VoidTy.$QualType(), new SourceLocation(OpLoc), IsThrownVarInScope);
       }));
}


/// CheckCXXThrowOperand - Validate the operand of a throw.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCXXThrowOperand">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 777,
 FQN="clang::Sema::CheckCXXThrowOperand", NM="_ZN5clang4Sema20CheckCXXThrowOperandENS_14SourceLocationENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema20CheckCXXThrowOperandENS_14SourceLocationENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public final boolean CheckCXXThrowOperand(SourceLocation ThrowLoc, 
                    QualType ExceptionObjectTy, Expr /*P*/ E) {
  //   If the type of the exception would be an incomplete type or a pointer
  //   to an incomplete type other than (cv) void the program is ill-formed.
  QualType Ty = new QualType(ExceptionObjectTy);
  boolean isPointer = false;
  {
    /*const*/ PointerType /*P*/ Ptr = Ty.$arrow().getAs(PointerType.class);
    if ((Ptr != null)) {
      Ty.$assignMove(Ptr.getPointeeType());
      isPointer = true;
    }
  }
  if (!isPointer || !Ty.$arrow().isVoidType()) {
    if ($this().RequireCompleteType$T(new SourceLocation(ThrowLoc), new QualType(Ty), 
        isPointer ? diag.err_throw_incomplete_ptr : diag.err_throw_incomplete, 
        E.getSourceRange())) {
      return true;
    }
    if ($this().RequireNonAbstractType$T(new SourceLocation(ThrowLoc), new QualType(ExceptionObjectTy), 
        diag.err_throw_abstract_type, E)) {
      return true;
    }
  }
  
  // If the exception has class type, we need additional handling.
  CXXRecordDecl /*P*/ RD = Ty.$arrow().getAsCXXRecordDecl();
  if (!(RD != null)) {
    return false;
  }
  
  // If we are throwing a polymorphic class type or pointer thereof,
  // exception handling will make use of the vtable.
  $this().MarkVTableUsed(new SourceLocation(ThrowLoc), RD);
  
  // If a pointer is thrown, the referenced object will not be destroyed.
  if (isPointer) {
    return false;
  }
  
  // If the class has a destructor, we must be able to call it.
  if (!RD.hasIrrelevantDestructor()) {
    {
      CXXDestructorDecl /*P*/ Destructor = $this().LookupDestructor(RD);
      if ((Destructor != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $this().MarkFunctionReferenced(E.getExprLoc(), Destructor);
          $c$.clean($this().CheckDestructorAccess(E.getExprLoc(), Destructor, 
              $out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor_exception)), /*NO_COPY*/Ty)));
          if ($this().DiagnoseUseOfDecl(Destructor, E.getExprLoc())) {
            return true;
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  // The MSVC ABI creates a list of all types which can catch the exception
  // object.  This list also references the appropriate copy constructor to call
  // if the object is caught by value and has a non-trivial copy constructor.
  if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
    // We are only interested in the public, unambiguous bases contained within
    // the exception object.  Bases which are ambiguous or otherwise
    // inaccessible are not catchable types.
    SmallVector<CXXRecordDecl /*P*/ > UnambiguousPublicSubobjects/*J*/= new SmallVector<CXXRecordDecl /*P*/ >(2, (CXXRecordDecl /*P*/ )null);
    SemaExprCXXStatics.getUnambiguousPublicSubobjects(RD, UnambiguousPublicSubobjects);
    
    for (CXXRecordDecl /*P*/ Subobject : UnambiguousPublicSubobjects) {
      // Attempt to lookup the copy constructor.  Various pieces of machinery
      // will spring into action, like template instantiation, which means this
      // cannot be a simple walk of the class's decls.  Instead, we must perform
      // lookup and overload resolution.
      CXXConstructorDecl /*P*/ CD = $this().LookupCopyingConstructor(Subobject, 0);
      if (!(CD != null)) {
        continue;
      }
      
      // Mark the constructor referenced as it is used by this throw expression.
      $this().MarkFunctionReferenced(E.getExprLoc(), CD);
      
      // Skip this copy constructor if it is trivial, we don't need to record it
      // in the catchable type data.
      if (CD.isTrivial()) {
        continue;
      }
      
      // The copy constructor is non-trivial, create a mapping from this class
      // type to this constructor.
      // N.B.  The selection of copy constructor is not sensitive to this
      // particular throw-site.  Lookup will be performed at the catch-site to
      // ensure that the copy constructor is, in fact, accessible (via
      // friendship or any other means).
      $this().Context.addCopyConstructorForExceptionObject(Subobject, CD);
      
      // We don't keep the instantiated default argument expressions around so
      // we must rebuild them here.
      for (/*uint*/int I = 1, E$1 = CD.getNumParams(); I != E$1; ++I) {
        // Skip any default arguments that we've already instantiated.
        if (($this().Context.getDefaultArgExprForConstructor(CD, I) != null)) {
          continue;
        }
        
        Expr /*P*/ DefaultArg = $this().BuildCXXDefaultArgExpr(new SourceLocation(ThrowLoc), CD, CD.getParamDecl(I)).get();
        $this().Context.addDefaultArgExprForConstructor(CD, I, DefaultArg);
      }
    }
  }
  
  return false;
}


/// ActOnCXXTypeConstructExpr - Parse construction of a specified type.
/// Can be interpreted either as function-style casting ("int(x)")
/// or class type construction ("ClassType(x,y,z)")
/// or creation of a value-initialized type ("int()").
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXTypeConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1206,
 FQN="clang::Sema::ActOnCXXTypeConstructExpr", NM="_ZN5clang4Sema25ActOnCXXTypeConstructExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25ActOnCXXTypeConstructExprENS_9OpaquePtrINS_8QualTypeEEENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES4_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXTypeConstructExpr(OpaquePtr<QualType> TypeRep, 
                         SourceLocation LParenLoc, 
                         MutableArrayRef<Expr /*P*/ > exprs, 
                         SourceLocation RParenLoc) {
  if (!TypeRep.$bool()) {
    return SemaClangGlobals.ExprError();
  }
  
  type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
  QualType Ty = GetTypeFromParser(new OpaquePtr<QualType>(TypeRep), $AddrOf(TInfo));
  if (!(TInfo.$star() != null)) {
    TInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/Ty, new SourceLocation()));
  }
  
  ActionResultTTrue<Expr /*P*/ /*P*/> Result = $this().BuildCXXTypeConstructExpr(TInfo.$star(), new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(exprs), new SourceLocation(RParenLoc));
  // Avoid creating a non-type-dependent expression that contains typos.
  // Non-type-dependent expressions are liable to be discarded without
  // checking for embedded typos.
  if (!Result.isInvalid() && Result.get().isInstantiationDependent()
     && !Result.get().isTypeDependent()) {
    Result.$assignMove($this().CorrectDelayedTyposInExpr(Result.get()));
  }
  return Result;
}


/// ActOnCXXTypeConstructExpr - Parse construction of a specified type.
/// Can be interpreted either as function-style casting ("int(x)")
/// or class type construction ("ClassType(x,y,z)")
/// or creation of a value-initialized type ("int()").
//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXTypeConstructExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1233,
 FQN="clang::Sema::BuildCXXTypeConstructExpr", NM="_ZN5clang4Sema25BuildCXXTypeConstructExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25BuildCXXTypeConstructExprEPNS_14TypeSourceInfoENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES3_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXTypeConstructExpr(TypeSourceInfo /*P*/ TInfo, 
                         SourceLocation LParenLoc, 
                         MutableArrayRef<Expr /*P*/ > Exprs, 
                         SourceLocation RParenLoc) {
  InitializationSequence InitSeq = null;
  try {
    QualType Ty = TInfo.getType();
    SourceLocation TyBeginLoc = TInfo.getTypeLoc().getBeginLoc();
    if (Ty.$arrow().isDependentType() || CallExpr.hasAnyTypeDependentArguments(new ArrayRef<Expr /*P*/ >(Exprs))) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CXXUnresolvedConstructExpr.Create($this().Context, TInfo, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Exprs), 
              new SourceLocation(RParenLoc)));
    }
    
    boolean ListInitialization = LParenLoc.isInvalid();
    assert ((!ListInitialization || (Exprs.size() == 1 && isa_InitListExpr(Exprs.$at(0))))) : "List initialization must have initializer list as expression.";
    SourceRange FullRange = new SourceRange(/*NO_COPY*/TyBeginLoc, 
        ListInitialization ? Exprs.$at(0).getSourceRange().getEnd() : new SourceLocation(RParenLoc));
    
    // C++ [expr.type.conv]p1:
    // If the expression list is a single expression, the type conversion
    // expression is equivalent (in definedness, and if defined in meaning) to the
    // corresponding cast expression.
    if (Exprs.size() == 1 && !ListInitialization) {
      Expr /*P*/ Arg = Exprs.$at(0);
      return $this().BuildCXXFunctionalCastExpr(TInfo, new SourceLocation(LParenLoc), Arg, new SourceLocation(RParenLoc));
    }
    
    // C++14 [expr.type.conv]p2: The expression T(), where T is a
    //   simple-type-specifier or typename-specifier for a non-array complete
    //   object type or the (possibly cv-qualified) void type, creates a prvalue
    //   of the specified type, whose value is that produced by value-initializing
    //   an object of type T.
    QualType ElemTy = new QualType(Ty);
    if (Ty.$arrow().isArrayType()) {
      if (!ListInitialization) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(TyBeginLoc), 
                      diag.err_value_init_for_array_type)), FullRange)));
        } finally {
          $c$.$destroy();
        }
      }
      ElemTy.$assignMove($this().Context.getBaseElementType(new QualType(Ty)));
    }
    if (!ListInitialization && Ty.$arrow().isFunctionType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(TyBeginLoc), diag.err_value_init_for_function_type)), 
                FullRange)));
      } finally {
        $c$.$destroy();
      }
    }
    if (!Ty.$arrow().isVoidType()
       && $this().RequireCompleteType$T(new SourceLocation(TyBeginLoc), new QualType(ElemTy), 
        diag.err_invalid_incomplete_type_use, FullRange)) {
      return SemaClangGlobals.ExprError();
    }
    if ($this().RequireNonAbstractType$T(new SourceLocation(TyBeginLoc), new QualType(Ty), 
        diag.err_allocation_of_abstract_type)) {
      return SemaClangGlobals.ExprError();
    }
    
    InitializedEntity Entity = InitializedEntity.InitializeTemporary(TInfo);
    InitializationKind Kind = (Exprs.size() != 0) ? ListInitialization ? InitializationKind.CreateDirectList(new SourceLocation(TyBeginLoc)) : InitializationKind.CreateDirect(new SourceLocation(TyBeginLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc)) : InitializationKind.CreateValue(new SourceLocation(TyBeginLoc), new SourceLocation(LParenLoc), new SourceLocation(RParenLoc));
    InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Exprs));
    ActionResultTTrue<Expr /*P*/ > Result = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Exprs));
    if (Result.isInvalid() || !ListInitialization) {
      return Result;
    }
    
    Expr /*P*/ Inner = Result.get();
    {
      CXXBindTemporaryExpr /*P*/ BTE = dyn_cast_or_null_CXXBindTemporaryExpr(Inner);
      if ((BTE != null)) {
        Inner = BTE.getSubExpr();
      }
    }
    if (!isa_CXXTemporaryObjectExpr(Inner)) {
      // If we created a CXXTemporaryObjectExpr, that node also represents the
      // functional cast. Otherwise, create an explicit cast to represent
      // the syntactic form of a functional-style cast that was used here.
      //
      // FIXME: Creating a CXXFunctionalCastExpr around a CXXConstructExpr
      // would give a more consistent AST representation than using a
      // CXXTemporaryObjectExpr. It's also weird that the functional cast
      // is sometimes handled by initialization and sometimes not.
      QualType ResultType = Result.get().getType();
      Result.$assign(CXXFunctionalCastExpr.Create($this().Context, new QualType(ResultType), Expr.getValueKindForType(TInfo.getType()), TInfo, 
              CastKind.CK_NoOp, Result.get(), /*Path=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, new SourceLocation(LParenLoc), new SourceLocation(RParenLoc)));
    }
    
    return Result;
  } finally {
    if (InitSeq != null) { InitSeq.$destroy(); }
  }
}


/// ActOnCXXNew - Parsed a C++ 'new' expression.

/// \brief Parsed a C++ 'new' expression (C++ 5.3.4).
///
/// E.g.:
/// @code new (memory) int[size][4] @endcode
/// or
/// @code ::new Foo(23, "hello") @endcode
///
/// \param StartLoc The first location of the expression.
/// \param UseGlobal True if 'new' was prefixed with '::'.
/// \param PlacementLParen Opening paren of the placement arguments.
/// \param PlacementArgs Placement new arguments.
/// \param PlacementRParen Closing paren of the placement arguments.
/// \param TypeIdParens If the type is in parens, the source range.
/// \param D The type to be allocated, as well as array dimensions.
/// \param Initializer The initializing expression or initializer-list, or null
///   if there is none.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXNew">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1392,
 FQN="clang::Sema::ActOnCXXNew", NM="_ZN5clang4Sema11ActOnCXXNewENS_14SourceLocationEbS1_N4llvm15MutableArrayRefIPNS_4ExprEEES1_NS_11SourceRangeERNS_10DeclaratorES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema11ActOnCXXNewENS_14SourceLocationEbS1_N4llvm15MutableArrayRefIPNS_4ExprEEES1_NS_11SourceRangeERNS_10DeclaratorES5_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXNew(SourceLocation StartLoc, boolean UseGlobal, 
           SourceLocation PlacementLParen, MutableArrayRef<Expr /*P*/ > PlacementArgs, 
           SourceLocation PlacementRParen, SourceRange TypeIdParens, 
           final Declarator /*&*/ D, Expr /*P*/ Initializer) {
  boolean TypeContainsAuto = D.getDeclSpec().containsPlaceholderType();
  
  Expr /*P*/ ArraySize = null;
  // If the specified type is an array, unwrap it and save the expression.
  if ($greater_uint(D.getNumTypeObjects(), 0)
     && D.getTypeObject(0).Kind == DeclaratorChunk.Unnamed_enum.Array) {
    final DeclaratorChunk /*&*/ Chunk = D.getTypeObject(0);
    if (TypeContainsAuto) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(Chunk.Loc), diag.err_new_array_of_auto)), 
                D.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    if (Chunk.Unnamed_field3.Arr.hasStatic) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(Chunk.Loc), diag.err_static_illegal_in_new)), 
                D.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    if (!(Chunk.Unnamed_field3.Arr.NumElts != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(Chunk.Loc), diag.err_array_new_needs_size)), 
                D.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    
    ArraySize = ((/*static_cast*/Expr /*P*/ )(Chunk.Unnamed_field3.Arr.NumElts));
    D.DropFirstTypeObject();
  }
  
  // Every dimension shall be of constant size.
  if ((ArraySize != null)) {
    for (/*uint*/int I = 0, N = D.getNumTypeObjects(); $less_uint(I, N); ++I) {
      if (D.getTypeObject(I).Kind != DeclaratorChunk.Unnamed_enum.Array) {
        break;
      }
      
      final DeclaratorChunk.ArrayTypeInfo /*&*/ Array = D.getTypeObject(I).Unnamed_field3.Arr;
      {
        Expr /*P*/ NumElts = (Expr /*P*/ )Array.NumElts;
        if ((NumElts != null)) {
          if (!NumElts.isTypeDependent() && !NumElts.isValueDependent()) {
            if ($this().getLangOpts().CPlusPlus14) {
              // C++1y [expr.new]p6: Every constant-expression in a noptr-new-declarator
              //   shall be a converted constant expression (5.19) of type std::size_t
              //   and shall evaluate to a strictly positive value.
              /*uint*/int IntWidth = $this().Context.getTargetInfo().getIntWidth();
              assert ((IntWidth != 0)) : "Builtin type of size 0?";
              APSInt Value/*J*/= new APSInt(IntWidth);
              Array.NumElts
                 = $this().CheckConvertedConstantExpression(NumElts, $this().Context.getSizeType().$QualType(), Value, 
                  CCEKind.CCEK_NewExpr).
                  get();
            } else {
              Array.NumElts
                 = $this().VerifyIntegerConstantExpression(NumElts, (APSInt /*P*/ )null, 
                  diag.err_new_array_nonconst).
                  get();
            }
            if (!(Array.NumElts != null)) {
              return SemaClangGlobals.ExprError();
            }
          }
        }
      }
    }
  }
  
  TypeSourceInfo /*P*/ TInfo = $this().GetTypeForDeclarator(D, /*Scope=*/ (Scope /*P*/ )null);
  QualType AllocType = TInfo.getType();
  if (D.isInvalidType()) {
    return SemaClangGlobals.ExprError();
  }
  
  SourceRange DirectInitRange/*J*/= new SourceRange();
  {
    ParenListExpr /*P*/ List = dyn_cast_or_null_ParenListExpr(Initializer);
    if ((List != null)) {
      DirectInitRange.$assignMove(List.getSourceRange());
    }
  }
  
  return $this().BuildCXXNew(new SourceRange(/*NO_COPY*/StartLoc, D.getLocEnd()), UseGlobal, 
      new SourceLocation(PlacementLParen), 
      new MutableArrayRef<Expr /*P*/ >(PlacementArgs), 
      new SourceLocation(PlacementRParen), 
      new SourceRange(TypeIdParens), 
      new QualType(AllocType), 
      TInfo, 
      ArraySize, 
      new SourceRange(DirectInitRange), 
      Initializer, 
      TypeContainsAuto);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION/*local ptr-var and moved class*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1492,
 FQN="clang::Sema::BuildCXXNew", NM="_ZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_b")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXNew(SourceRange Range, boolean UseGlobal, 
           SourceLocation PlacementLParen, 
           MutableArrayRef<Expr /*P*/ > PlacementArgs, 
           SourceLocation PlacementRParen, 
           SourceRange TypeIdParens, 
           QualType AllocType, 
           TypeSourceInfo /*P*/ AllocTypeInfo, 
           Expr /*P*/ ArraySize, 
           SourceRange DirectInitRange, 
           Expr /*P*/ Initializer) {
  return BuildCXXNew(Range, UseGlobal, 
           PlacementLParen, 
           PlacementArgs, 
           PlacementRParen, 
           TypeIdParens, 
           AllocType, 
           AllocTypeInfo, 
           ArraySize, 
           DirectInitRange, 
           Initializer, 
           true);
}
public final ActionResultTTrue<Expr /*P*/ > BuildCXXNew(SourceRange Range, boolean UseGlobal, 
           SourceLocation PlacementLParen, 
           MutableArrayRef<Expr /*P*/ > PlacementArgs, 
           SourceLocation PlacementRParen, 
           SourceRange TypeIdParens, 
           QualType AllocType, 
           TypeSourceInfo /*P*/ AllocTypeInfo, 
           Expr /*P*/ ArraySize, 
           SourceRange DirectInitRange, 
           final Expr /*P*/ _Initializer, 
           boolean TypeMayContainAuto/*= true*/) {
  type$ptr<Expr> Initializer = create_type$ptr(_Initializer);
  SourceRange TypeRange = AllocTypeInfo.getTypeLoc().getSourceRange();
  SourceLocation StartLoc = Range.getBegin();
  
  CXXNewExpr.InitializationStyle initStyle;
  if (DirectInitRange.isValid()) {
    assert ((Initializer.$star() != null)) : "Have parens but no initializer.";
    initStyle = CXXNewExpr.InitializationStyle.CallInit;
  } else if ((Initializer.$star() != null) && isa_InitListExpr(Initializer)) {
    initStyle = CXXNewExpr.InitializationStyle.ListInit;
  } else {
    assert ((!(Initializer.$star() != null) || isa_ImplicitValueInitExpr(Initializer) || isa_CXXConstructExpr(Initializer))) : "Initializer expression that cannot have been implicitly created.";
    initStyle = CXXNewExpr.InitializationStyle.NoInit;
  }
  
  type$ptr<Expr /*P*/ /*P*/> Inits = $tryClone($AddrOf(Initializer));
  /*uint*/int NumInits = (Initializer.$star() != null) ? 1 : 0;
  {
    ParenListExpr /*P*/ List = dyn_cast_or_null_ParenListExpr(Initializer.$star());
    if ((List != null)) {
      assert (initStyle == CXXNewExpr.InitializationStyle.CallInit) : "paren init for non-call init";
      Inits = $tryClone(List.getExprs());
      NumInits = List.getNumExprs();
    }
  }
  
  // C++11 [dcl.spec.auto]p6. Deduce the type which 'auto' stands in for.
  if (TypeMayContainAuto && AllocType.$arrow().isUndeducedType()) {
    if (initStyle == CXXNewExpr.InitializationStyle.NoInit || NumInits == 0) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_auto_new_requires_ctor_arg)), 
                    AllocType), TypeRange)));
      } finally {
        $c$.$destroy();
      }
    }
    if (initStyle == CXXNewExpr.InitializationStyle.ListInit
       || (NumInits == 1 && isa_InitListExpr(Inits.$at(0)))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(Inits.$at(0).getLocStart(), 
                        diag.err_auto_new_list_init)), 
                    AllocType), TypeRange)));
      } finally {
        $c$.$destroy();
      }
    }
    if ($greater_uint(NumInits, 1)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        Expr /*P*/ FirstBad = Inits.$at(1);
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(FirstBad.getLocStart(), 
                        diag.err_auto_new_ctor_multiple_expressions)), 
                    AllocType), TypeRange)));
      } finally {
        $c$.$destroy();
      }
    }
    type$ref<Expr /*P*/ > Deduce = create_type$ref(Inits.$at(0));
    QualType DeducedType/*J*/= new QualType();
    if ($this().DeduceAutoType(AllocTypeInfo, Deduce, DeducedType) == DeduceAutoResult.DAR_Failed) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_auto_new_deduction_failure)), 
                            AllocType), Deduce.$deref().getType()), 
                    TypeRange), Deduce.$deref().getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
    if (DeducedType.isNull()) {
      return SemaClangGlobals.ExprError();
    }
    AllocType.$assign(DeducedType);
  }
  
  // Per C++0x [expr.new]p5, the type being constructed may be a
  // typedef of an array type.
  if (!(ArraySize != null)) {
    {
      /*const*/ ConstantArrayType /*P*/ Array = $this().Context.getAsConstantArrayType(new QualType(AllocType));
      if ((Array != null)) {
        ArraySize = IntegerLiteral.Create($this().Context, Array.getSize(), 
            $this().Context.getSizeType().$QualType(), 
            TypeRange.getEnd());
        AllocType.$assignMove(Array.getElementType());
      }
    }
  }
  if ($this().CheckAllocatedType(new QualType(AllocType), TypeRange.getBegin(), new SourceRange(TypeRange))) {
    return SemaClangGlobals.ExprError();
  }
  if (initStyle == CXXNewExpr.InitializationStyle.ListInit
     && $this().isStdInitializerList(new QualType(AllocType), (type$ptr<QualType /*P*/> )null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(AllocTypeInfo.getTypeLoc().getBeginLoc(), 
                  diag.warn_dangling_std_initializer_list)), 
              /*at end of FE*/ 0), Inits.$at(0).getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  // In ARC, infer 'retaining' for the allocated 
  if ($this().getLangOpts().ObjCAutoRefCount
     && AllocType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None
     && AllocType.$arrow().isObjCLifetimeType()) {
    AllocType.$assignMove($this().Context.getLifetimeQualifiedType(new QualType(AllocType), 
            AllocType.$arrow().getObjCARCImplicitLifetime()));
  }
  
  QualType ResultType = $this().Context.getPointerType(/*NO_COPY*/AllocType);
  if ((ArraySize != null) && ArraySize.getType().$arrow().isNonOverloadPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(ArraySize);
    if (result.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    ArraySize = result.get();
  }
  // C++98 5.3.4p6: "The expression in a direct-new-declarator shall have
  //   integral or enumeration type with a non-negative value."
  // C++11 [expr.new]p6: The expression [...] shall be of integral or unscoped
  //   enumeration type, or a class type for which a single non-explicit
  //   conversion function to integral or unscoped enumeration type exists.
  // C++1y [expr.new]p6: The expression [...] is implicitly converted to
  //   std::size_t.
  if ((ArraySize != null) && !ArraySize.isTypeDependent()) {
    ActionResultTTrue<Expr /*P*/ > ConvertedSize/*J*/= new ActionResultTTrue<Expr /*P*/ >();
    if ($this().getLangOpts().CPlusPlus14) {
      assert (($this().Context.getTargetInfo().getIntWidth() != 0)) : "Builtin type of size 0?";
      
      ConvertedSize.$assignMove($this().PerformImplicitConversion(ArraySize, $this().Context.getSizeType().$QualType(), 
              AssignmentAction.AA_Converting));
      if (!ConvertedSize.isInvalid()
         && (ArraySize.getType().$arrow().getAs$RecordType() != null)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Diagnose the compatibility of this conversion.
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_cxx98_compat_array_size_conversion)), 
                      ArraySize.getType()), 0), /*KEEP_STR*/"'size_t'"));
        } finally {
          $c$.$destroy();
        }
      }
    } else {
      BuildCXXNew$$.SizeConvertDiagnoser SizeDiagnoser = null;
      try {        
        SizeDiagnoser/*J*/= new  BuildCXXNew$$.SizeConvertDiagnoser(ArraySize);
        
        ConvertedSize.$assignMove($this().PerformContextualImplicitConversion(new SourceLocation(StartLoc), ArraySize, 
                SizeDiagnoser));
      } finally {
        if (SizeDiagnoser != null) { SizeDiagnoser.$destroy(); }
      }
    }
    if (ConvertedSize.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    
    ArraySize = ConvertedSize.get();
    QualType SizeType = ArraySize.getType();
    if (!SizeType.$arrow().isIntegralOrUnscopedEnumerationType()) {
      return SemaClangGlobals.ExprError();
    }
    
    // C++98 [expr.new]p7:
    //   The expression in a direct-new-declarator shall have integral type
    //   with a non-negative value.
    //
    // Let's see if this is a constant < 0. If so, we reject it out of
    // hand. Otherwise, if it's not a constant, we must have an unparenthesized
    // array type.
    //
    // Note: such a construct has well-defined semantics in C++11: it throws
    // std::bad_array_new_length.
    if (!ArraySize.isValueDependent()) {
      APSInt Value/*J*/= new APSInt();
      // We've already performed any required implicit conversion to integer or
      // unscoped enumeration type.
      if (ArraySize.isIntegerConstantExpr(Value, $this().Context)) {
        if (Value.$less(new APSInt(APInt.getNullValue(Value.getBitWidth()), 
                Value.isUnsigned()))) {
          if ($this().getLangOpts().CPlusPlus11) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(ArraySize.getLocStart(), 
                      diag.warn_typecheck_negative_array_new_size)), 
                  ArraySize.getSourceRange()));
            } finally {
              $c$.$destroy();
            }
          } else {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(ArraySize.getLocStart(), 
                          diag.err_typecheck_negative_array_size)), 
                      ArraySize.getSourceRange())));
            } finally {
              $c$.$destroy();
            }
          }
        } else if (!AllocType.$arrow().isDependentType()) {
          /*uint*/int ActiveSizeBits = ConstantArrayType.getNumAddressingBits($this().Context, new QualType(AllocType), Value);
          if ($greater_uint(ActiveSizeBits, ConstantArrayType.getMaxSizeBits($this().Context))) {
            if ($this().getLangOpts().CPlusPlus11) {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), 
                            diag.warn_array_new_too_large)), 
                        Value.__toString(10)), 
                    ArraySize.getSourceRange()));
              } finally {
                $c$.$destroy();
              }
            } else {
              JavaCleaner $c$ = $createJavaCleaner();
              try {
                return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R($c$.track($this().Diag(ArraySize.getLocStart(), 
                                diag.err_array_too_large)), 
                            Value.__toString(10)), 
                        ArraySize.getSourceRange())));
              } finally {
                $c$.$destroy();
              }
            }
          }
        }
      } else if (TypeIdParens.isValid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // Can't have dynamic array size when the type-id is in parentheses.
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(ArraySize.getLocStart(), diag.ext_new_paren_array_nonconst)), 
                      ArraySize.getSourceRange()), 
                  FixItHint.CreateRemoval(new SourceRange(TypeIdParens.getBegin()))), 
              FixItHint.CreateRemoval(new SourceRange(TypeIdParens.getEnd()))));
          
          TypeIdParens.$assignMove(new SourceRange());
        } finally {
          $c$.$destroy();
        }
      }
    }
    // Note that we do *not* convert the argument in any way.  It can
    // be signed, larger than size_t, whatever.
  }
  
  type$ref<FunctionDecl /*P*/ > OperatorNew = create_type$null$ref(null);
  type$ref<FunctionDecl /*P*/ > OperatorDelete = create_type$null$ref(null);
  if (!AllocType.$arrow().isDependentType()
     && !Expr.hasAnyTypeDependentArguments(new ArrayRef<Expr /*P*/ >(PlacementArgs))
     && $this().FindAllocationFunctions(new SourceLocation(StartLoc), 
      new SourceRange(/*NO_COPY*/PlacementLParen, /*NO_COPY*/PlacementRParen), 
      UseGlobal, new QualType(AllocType), (ArraySize != null), new MutableArrayRef<Expr /*P*/ >(PlacementArgs), 
      OperatorNew, OperatorDelete)) {
    return SemaClangGlobals.ExprError();
  }
  
  // If this is an array allocation, compute whether the usual array
  // deallocation function for the type has a size_t parameter.
  boolean UsualArrayDeleteWantsSize = false;
  if ((ArraySize != null) && !AllocType.$arrow().isDependentType()) {
    UsualArrayDeleteWantsSize
       = SemaExprCXXStatics.doesUsualArrayDeleteWantSize(/*Deref*/$this(), new SourceLocation(StartLoc), new QualType(AllocType));
  }
  
  SmallVector<Expr /*P*/ > AllPlaceArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  if ((OperatorNew.$deref() != null)) {
    /*const*/ FunctionProtoType /*P*/ Proto = OperatorNew.$deref().getType().$arrow().getAs(FunctionProtoType.class);
    VariadicCallType CallType = Proto.isVariadic() ? VariadicCallType.VariadicFunction : VariadicCallType.VariadicDoesNotApply;
    
    // We've already converted the placement args, just fill in any default
    // arguments. Skip the first parameter because we don't have a corresponding
    // argument.
    if ($this().GatherArgumentsForCall(new SourceLocation(PlacementLParen), OperatorNew.$deref(), Proto, 1, 
        new ArrayRef<Expr /*P*/ >(PlacementArgs), AllPlaceArgs, CallType)) {
      return SemaClangGlobals.ExprError();
    }
    if (!AllPlaceArgs.empty()) {
      PlacementArgs.$assignMove(new MutableArrayRef<Expr /*P*/ >(AllPlaceArgs, true));
    }
    
    // FIXME: This is wrong: PlacementArgs misses out the first (size) argument.
    $this().DiagnoseSentinelCalls(OperatorNew.$deref(), new SourceLocation(PlacementLParen), new ArrayRef<Expr /*P*/ >(PlacementArgs));
    // FIXME: Missing call to CheckFunctionCall or equivalent
  }
  
  // Warn if the type is over-aligned and is being allocated by global operator
  // new.
  if (PlacementArgs.empty() && (OperatorNew.$deref() != null)
     && (OperatorNew.$deref().isImplicit()
     || (OperatorNew.$deref().getLocStart().isValid()
     && $this().getSourceManager().isInSystemHeader(OperatorNew.$deref().getLocStart())))) {
    {
      /*uint*/int Align = $this().Context.getPreferredTypeAlign(AllocType.getTypePtr());
      if ((Align != 0)) {
        /*uint*/int SuitableAlign = $this().Context.getTargetInfo().getSuitableAlign();
        if ($greater_uint(Align, SuitableAlign)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_overaligned_type)), 
                        AllocType), 
                    ((/*uint*/int)($ullong2uint($div_uint_ulong(Align, $this().Context.getCharWidth()))))), 
                ((/*uint*/int)($ullong2uint($div_uint_ulong(SuitableAlign, $this().Context.getCharWidth()))))));
          } finally {
            $c$.$destroy();
          }
        }
      }
    }
  }
  
  QualType InitType = new QualType(AllocType);
  // Array 'new' can't have any initializers except empty parentheses.
  // Initializer lists are also allowed, in C++11. Rely on the parser for the
  // dialect distinction.
  if (ResultType.$arrow().isArrayType() || (ArraySize != null)) {
    if (!SemaExprCXXStatics.isLegalArrayNewInitializer(initStyle, Initializer.$star())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        SourceRange InitRange/*J*/= new SourceRange(Inits.$at(0).getLocStart(), 
            Inits.$at(NumInits - 1).getLocEnd());
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_new_array_init_args)), InitRange));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
    {
      InitListExpr /*P*/ ILE = dyn_cast_or_null_InitListExpr(Initializer.$star());
      if ((ILE != null)) {
        // We do the initialization typechecking against the array type
        // corresponding to the number of initializers + 1 (to also check
        // default-initialization).
        /*uint*/int NumElements = ILE.getNumInits() + 1;
        InitType.$assignMove($this().Context.getConstantArrayType(new QualType(AllocType), 
                new APInt(JD$UInt_ULong.INSTANCE, $ulong2uint($this().Context.getTypeSize($this().Context.getSizeType().$QualType())), $uint2ulong(NumElements)), 
                ArrayType.ArraySizeModifier.Normal, 0));
      }
    }
  }
  
  // If we can perform the initialization, and we've not already done so,
  // do it now.
  if (!AllocType.$arrow().isDependentType()
     && !Expr.hasAnyTypeDependentArguments(llvm.makeArrayRef(Inits, NumInits, true))) {
    InitializationSequence InitSeq = null;
    try {
      // C++11 [expr.new]p15:
      //   A new-expression that creates an object of type T initializes that
      //   object as follows:
      InitializationKind Kind = initStyle == CXXNewExpr.InitializationStyle.NoInit ? InitializationKind.CreateDefault(TypeRange.getBegin()) : initStyle == CXXNewExpr.InitializationStyle.ListInit ? InitializationKind.CreateDirectList(TypeRange.getBegin()) : InitializationKind.CreateDirect(TypeRange.getBegin(), 
          DirectInitRange.getBegin(), 
          DirectInitRange.getEnd());
      
      InitializedEntity Entity = InitializedEntity.InitializeNew(new SourceLocation(StartLoc), new QualType(InitType));
      InitSeq/*J*/= new InitializationSequence(/*Deref*/$this(), Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Inits, NumInits, true));
      ActionResultTTrue<Expr /*P*/ > FullInit = InitSeq.Perform(/*Deref*/$this(), Entity, Kind, 
          new MutableArrayRef<Expr /*P*/ >(Inits, NumInits, true));
      if (FullInit.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      {
        
        // FullInit is our initializer; strip off CXXBindTemporaryExprs, because
        // we don't want the initialized object to be destructed.
        CXXBindTemporaryExpr /*P*/ Binder = dyn_cast_or_null_CXXBindTemporaryExpr(FullInit.get());
        if ((Binder != null)) {
          FullInit.$assign(Binder.getSubExpr());
        }
      }
      
      Initializer.$set(FullInit.get());
    } finally {
      if (InitSeq != null) { InitSeq.$destroy(); }
    }
  }
  
  // Mark the new and delete operators as referenced.
  if ((OperatorNew.$deref() != null)) {
    if ($this().DiagnoseUseOfDecl(OperatorNew.$deref(), new SourceLocation(StartLoc))) {
      return SemaClangGlobals.ExprError();
    }
    $this().MarkFunctionReferenced(new SourceLocation(StartLoc), OperatorNew.$deref());
  }
  if ((OperatorDelete.$deref() != null)) {
    if ($this().DiagnoseUseOfDecl(OperatorDelete.$deref(), new SourceLocation(StartLoc))) {
      return SemaClangGlobals.ExprError();
    }
    $this().MarkFunctionReferenced(new SourceLocation(StartLoc), OperatorDelete.$deref());
  }
  
  // C++0x [expr.new]p17:
  //   If the new expression creates an array of objects of class type,
  //   access and ambiguity control are done for the destructor.
  QualType BaseAllocType = $this().Context.getBaseElementType(new QualType(AllocType));
  if ((ArraySize != null) && !BaseAllocType.$arrow().isDependentType()) {
    {
      /*const*/ RecordType /*P*/ BaseRecordType = BaseAllocType.$arrow().getAs$RecordType();
      if ((BaseRecordType != null)) {
        {
          CXXDestructorDecl /*P*/ dtor = $this().LookupDestructor(cast_CXXRecordDecl(BaseRecordType.getDecl()));
          if ((dtor != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $this().MarkFunctionReferenced(new SourceLocation(StartLoc), dtor);
              $c$.clean($this().CheckDestructorAccess(new SourceLocation(StartLoc), dtor, 
                  $out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor)), 
                      /*NO_COPY*/BaseAllocType)));
              if ($this().DiagnoseUseOfDecl(dtor, new SourceLocation(StartLoc))) {
                return SemaClangGlobals.ExprError();
              }
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  final boolean L$UsualArrayDeleteWantsSize = UsualArrayDeleteWantsSize;
  final Expr /*P*/ L$ArraySize = ArraySize;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
         return new CXXNewExpr($this().Context, UseGlobal, OperatorNew.$deref(), OperatorDelete.$deref(), 
                  L$UsualArrayDeleteWantsSize, new ArrayRef<Expr /*P*/ >(PlacementArgs), new SourceRange(TypeIdParens), 
                  L$ArraySize, initStyle, Initializer.$star(), new QualType(ResultType), AllocTypeInfo, 
                  new SourceRange(Range), new SourceRange(DirectInitRange));
       }));
}
private static final class BuildCXXNew$$ {
  static //<editor-fold defaultstate="collapsed" desc="SizeConvertDiagnoser">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1613,
   FQN="SizeConvertDiagnoser", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bE20SizeConvertDiagnoser",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bE20SizeConvertDiagnoser")
  //</editor-fold>
   class SizeConvertDiagnoser extends /*public*/ ICEConvertDiagnoser implements Destructors.ClassWithDestructor {
  /*protected:*/
    protected Expr /*P*/ ArraySize;
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::SizeConvertDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1618,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::SizeConvertDiagnoser", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoserC1ES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoserC1ES6_")
    //</editor-fold>
    public SizeConvertDiagnoser(Expr /*P*/ ArraySize) {
      // : ICEConvertDiagnoser(/*AllowScopedEnumerations*/ false, false, false), ArraySize(ArraySize) 
      //START JInit
      super(false, false, false);
      this.ArraySize = ArraySize;
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseNotInt">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1622,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseNotInt", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser14diagnoseNotIntERS0_S2_S8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser14diagnoseNotIntERS0_S2_S8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseNotInt(final Sema /*&*/ S, SourceLocation Loc, 
                  QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track(S.Diag(new SourceLocation(Loc), diag.err_array_size_not_integral)), 
                    S.getLangOpts().CPlusPlus11), T)));
      } finally {
        $c$.$destroy();
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseIncomplete">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1628,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseIncomplete", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser18diagnoseIncompleteERS0_S2_S8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser18diagnoseIncompleteERS0_S2_S8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseIncomplete(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_array_size_incomplete_type)), 
                    T), ArraySize.getSourceRange())));
      } finally {
        $c$.$destroy();
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1634,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseExplicitConv", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser20diagnoseExplicitConvERS0_S2_S8_S8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser20diagnoseExplicitConvERS0_S2_S8_S8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseExplicitConv(final Sema /*&*/ S, SourceLocation Loc, QualType T, QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_array_size_explicit_conversion)), T), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::noteExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1639,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::noteExplicitConv", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclES8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser16noteExplicitConvERS0_PNS_17CXXConversionDeclES8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteExplicitConv(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track(S.Diag(Conv.getLocation(), diag.note_array_size_conversion)), 
                    ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1645,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseAmbiguous", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser17diagnoseAmbiguousERS0_S2_S8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser17diagnoseAmbiguousERS0_S2_S8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseAmbiguous(final Sema /*&*/ S, SourceLocation Loc, QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_array_size_ambiguous_conversion)), T)));
      } finally {
        $c$.$destroy();
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::noteAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1650,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::noteAmbiguous", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclES8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser13noteAmbiguousERS0_PNS_17CXXConversionDeclES8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteAmbiguous(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track(S.Diag(Conv.getLocation(), diag.note_array_size_conversion)), 
                    ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }
  
    
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseConversion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1656,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::diagnoseConversion", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser18diagnoseConversionERS0_S2_S8_S8_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoser18diagnoseConversionERS0_S2_S8_S8_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseConversion(final Sema /*&*/ S, SourceLocation Loc, 
                      QualType T, 
                      QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), 
                            S.getLangOpts().CPlusPlus11 ? diag.warn_cxx98_compat_array_size_conversion : diag.ext_array_size_conversion)), 
                        T), ConvTy.$arrow().isEnumeralType()), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }
  
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::~SizeConvertDiagnoser">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1613,
     FQN="clang::Sema::BuildCXXNew(SourceRange, bool, SourceLocation, MultiExprArg, SourceLocation, SourceRange, QualType, TypeSourceInfo * , Expr * , SourceRange, Expr * , bool)::SizeConvertDiagnoser::~SizeConvertDiagnoser", NM="_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoserD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema11BuildCXXNewENS_11SourceRangeEbNS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEES2_S1_NS_8QualTypeEPNS_14TypeSourceInfoES6_S1_S6_bEN20SizeConvertDiagnoserD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }
  
    
    @Override public String toString() {
      return "" + "ArraySize=" + "[Expr]" // NOI18N
                + super.toString(); // NOI18N
    }
  };
}


/// \brief Checks that a type is suitable as the allocated type
/// in a new-expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckAllocatedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1893,
 FQN="clang::Sema::CheckAllocatedType", NM="_ZN5clang4Sema18CheckAllocatedTypeENS_8QualTypeENS_14SourceLocationENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema18CheckAllocatedTypeENS_8QualTypeENS_14SourceLocationENS_11SourceRangeE")
//</editor-fold>
public final boolean CheckAllocatedType(QualType AllocType, SourceLocation Loc, 
                  SourceRange R) {
  // C++ 5.3.4p1: "[The] type shall be a complete object type, but not an
  //   abstract class type or array thereof.
  if (AllocType.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_new_type)), 
                  AllocType), 0), R).$bool());
    } finally {
      $c$.$destroy();
    }
  } else if (AllocType.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_new_type)), 
                  AllocType), 1), R).$bool());
    } finally {
      $c$.$destroy();
    }
  } else if (!AllocType.$arrow().isDependentType()
     && $this().RequireCompleteType$T(new SourceLocation(Loc), new QualType(AllocType), diag.err_new_incomplete_type, R)) {
    return true;
  } else if ($this().RequireNonAbstractType$T(new SourceLocation(Loc), new QualType(AllocType), 
      diag.err_allocation_of_abstract_type)) {
    return true;
  } else if (AllocType.$arrow().isVariablyModifiedType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_variably_modified_new_type)), 
          AllocType).$bool());
    } finally {
      $c$.$destroy();
    }
  } else {
    /*uint*/int AddressSpace = AllocType.getAddressSpace();
    if ((AddressSpace != 0)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_address_space_qualified_new)), 
                AllocType.getUnqualifiedType()), AddressSpace).$bool());
      } finally {
        $c$.$destroy();
      }
    } else if ($this().getLangOpts().ObjCAutoRefCount) {
      {
        /*const*/ ArrayType /*P*/ AT = $this().Context.getAsArrayType(new QualType(AllocType));
        if ((AT != null)) {
          QualType BaseAllocType = $this().Context.getBaseElementType(AT);
          if (BaseAllocType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None
             && BaseAllocType.$arrow().isObjCLifetimeType()) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_arc_new_array_without_ownership)), 
                  BaseAllocType).$bool());
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    }
  }
  
  return false;
}


/// FindAllocationFunctions - Finds the overloads of operator new and delete
/// that are appropriate for the allocation.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindAllocationFunctions">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 1951,
 FQN="clang::Sema::FindAllocationFunctions", NM="_ZN5clang4Sema23FindAllocationFunctionsENS_14SourceLocationENS_11SourceRangeEbNS_8QualTypeEbN4llvm15MutableArrayRefIPNS_4ExprEEERPNS_12FunctionDeclESB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema23FindAllocationFunctionsENS_14SourceLocationENS_11SourceRangeEbNS_8QualTypeEbN4llvm15MutableArrayRefIPNS_4ExprEEERPNS_12FunctionDeclESB_")
//</editor-fold>
public final boolean FindAllocationFunctions(SourceLocation StartLoc, SourceRange Range, 
                       boolean UseGlobal, QualType AllocType, 
                       boolean IsArray, MutableArrayRef<Expr /*P*/ > PlaceArgs, 
                       final type$ref<FunctionDecl /*P*/ /*&*/> OperatorNew, 
                       final type$ref<FunctionDecl /*P*/ /*&*/> OperatorDelete) {
  LookupResult FoundDelete = null;
  try {
    // --- Choosing an allocation function ---
    // C++ 5.3.4p8 - 14 & 18
    // 1) If UseGlobal is true, only look in the global scope. Else, also look
    //   in the scope of the allocated class.
    // 2) If an array size is given, look for operator new[], else look for
    //   operator new.
    // 3) The first argument is always size_t. Append the arguments from the
    //   placement form.
    SmallVector<Expr /*P*/ > AllocArgs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 8, 1 + PlaceArgs.size(), (Expr /*P*/ )null);
    // We don't care about the actual value of this argument.
    // FIXME: Should the Sema create the expression and embed it in the syntax
    // tree? Or should the consumer just recalculate the value?
    IntegerLiteral Size/*J*/= new IntegerLiteral($this().Context, APInt.getNullValue($ulong2uint($this().Context.getTargetInfo().getPointerWidth(0))), 
        $this().Context.getSizeType().$QualType(), 
        new SourceLocation());
    AllocArgs.$set(0, $AddrOf(Size));
    std.copy(PlaceArgs.begin(), PlaceArgs.end(), AllocArgs.begin().$add(1));
    
    // C++ [expr.new]p8:
    //   If the allocated type is a non-array type, the allocation
    //   function's name is operator new and the deallocation function's
    //   name is operator delete. If the allocated type is an array
    //   type, the allocation function's name is operator new[] and the
    //   deallocation function's name is operator delete[].
    DeclarationName NewName = $this().Context.DeclarationNames.getCXXOperatorName(IsArray ? OverloadedOperatorKind.OO_Array_New : OverloadedOperatorKind.OO_New);
    DeclarationName DeleteName = $this().Context.DeclarationNames.getCXXOperatorName(IsArray ? OverloadedOperatorKind.OO_Array_Delete : OverloadedOperatorKind.OO_Delete);
    
    QualType AllocElemType = $this().Context.getBaseElementType(new QualType(AllocType));
    if (AllocElemType.$arrow().isRecordType() && !UseGlobal) {
      CXXRecordDecl /*P*/ Record = cast_CXXRecordDecl(AllocElemType.$arrow().getAs$RecordType().getDecl());
      if ($this().FindAllocationOverload(new SourceLocation(StartLoc), new SourceRange(Range), new DeclarationName(NewName), new MutableArrayRef<Expr /*P*/ >(AllocArgs, true), Record, 
          /*AllowMissing=*/ true, OperatorNew)) {
        return true;
      }
    }
    if (!(OperatorNew.$deref() != null)) {
      // Didn't find a member overload. Look for a global one.
      $this().DeclareGlobalNewDelete();
      DeclContext /*P*/ TUDecl = $this().Context.getTranslationUnitDecl();
      boolean FallbackEnabled = IsArray && $this().Context.getLangOpts().MSVCCompat;
      if ($this().FindAllocationOverload(new SourceLocation(StartLoc), new SourceRange(Range), new DeclarationName(NewName), new MutableArrayRef<Expr /*P*/ >(AllocArgs, true), TUDecl, 
          /*AllowMissing=*/ FallbackEnabled, OperatorNew, 
          /*Diagnose=*/ !FallbackEnabled)) {
        if (!FallbackEnabled) {
          return true;
        }
        
        // MSVC will fall back on trying to find a matching global operator new
        // if operator new[] cannot be found.  Also, MSVC will leak by not
        // generating a call to operator delete or operator delete[], but we
        // will not replicate that bug.
        NewName.$assignMove($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_New));
        DeleteName.$assignMove($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Delete));
        if ($this().FindAllocationOverload(new SourceLocation(StartLoc), new SourceRange(Range), new DeclarationName(NewName), new MutableArrayRef<Expr /*P*/ >(AllocArgs, true), TUDecl, 
            /*AllowMissing=*/ false, OperatorNew)) {
          return true;
        }
      }
    }
    
    // We don't need an operator delete if we're running under
    // -fno-exceptions.
    if (!$this().getLangOpts().Exceptions) {
      OperatorDelete.$set(null);
      return false;
    }
    
    // C++ [expr.new]p19:
    //
    //   If the new-expression begins with a unary :: operator, the
    //   deallocation function's name is looked up in the global
    //   scope. Otherwise, if the allocated type is a class type T or an
    //   array thereof, the deallocation function's name is looked up in
    //   the scope of T. If this lookup fails to find the name, or if
    //   the allocated type is not a class type or array thereof, the
    //   deallocation function's name is looked up in the global scope.
    FoundDelete/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(DeleteName), new SourceLocation(StartLoc), LookupNameKind.LookupOrdinaryName);
    if (AllocElemType.$arrow().isRecordType() && !UseGlobal) {
      CXXRecordDecl /*P*/ RD = cast_CXXRecordDecl(AllocElemType.$arrow().getAs$RecordType().getDecl());
      $this().LookupQualifiedName(FoundDelete, RD);
    }
    if (FoundDelete.isAmbiguous()) {
      return true; // FIXME: clean up expressions?
    }
    if (FoundDelete.empty()) {
      $this().DeclareGlobalNewDelete();
      $this().LookupQualifiedName(FoundDelete, $this().Context.getTranslationUnitDecl());
    }
    
    FoundDelete.suppressDiagnostics();
    
    SmallVector<std.pair<DeclAccessPair, FunctionDecl /*P*/ >> Matches/*J*/= new SmallVector<std.pair<DeclAccessPair, FunctionDecl /*P*/ >>(2, new std.pairTypePtr<DeclAccessPair, FunctionDecl /*P*/ >(new DeclAccessPair(), null));
    
    // Whether we're looking for a placement operator delete is dictated
    // by whether we selected a placement operator new, not by whether
    // we had explicit placement arguments.  This matters for things like
    //   struct A { void *operator new(size_t, int = 0); ... };
    //   A *a = new A()
    boolean isPlacementNew = (!PlaceArgs.empty() || OperatorNew.$deref().param_size() != 1);
    if (isPlacementNew) {
      // C++ [expr.new]p20:
      //   A declaration of a placement deallocation function matches the
      //   declaration of a placement allocation function if it has the
      //   same number of parameters and, after parameter transformations
      //   (8.3.5), all parameter types except the first are
      //   identical. [...]
      //
      // To perform this comparison, we compute the function type that
      // the deallocation function should have, and use that type both
      // for template argument deduction and for comparison purposes.
      //
      // FIXME: this comparison should ignore CC and the like.
      QualType ExpectedFunctionType/*J*/= new QualType();
      {
        /*const*/ FunctionProtoType /*P*/ Proto = OperatorNew.$deref().getType().$arrow().getAs(FunctionProtoType.class);
        
        SmallVector<QualType> ArgTypes/*J*/= new SmallVector<QualType>(4, new QualType());
        ArgTypes.push_back($this().Context.VoidPtrTy.$QualType());
        for (/*uint*/int I = 1, N = Proto.getNumParams(); $less_uint(I, N); ++I)  {
          ArgTypes.push_back(Proto.getParamType(I));
        }
        
        FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
        EPI.Variadic = Proto.isVariadic();
        
        ExpectedFunctionType.$assignMove(
            $this().Context.getFunctionType($this().Context.VoidTy.$QualType(), new ArrayRef<QualType>(ArgTypes, false), EPI)
        );
      }
      
      for (UnresolvedSetIterator D = FoundDelete.begin(), 
          DEnd = FoundDelete.end();
           D.$noteq(DEnd); D.$preInc()) {
        type$ref<FunctionDecl /*P*/ > Fn = create_type$null$ref(null);
        {
          FunctionTemplateDecl /*P*/ FnTmpl = dyn_cast_FunctionTemplateDecl((D.$star()).getUnderlyingDecl());
          if ((FnTmpl != null)) {
            TemplateDeductionInfo Info = null;
            try {
              // Perform template argument deduction to try to match the
              // expected function type.
              Info/*J*/= new TemplateDeductionInfo(new SourceLocation(StartLoc));
              if (($this().DeduceTemplateArguments3(FnTmpl, (TemplateArgumentListInfo /*P*/ )null, new QualType(ExpectedFunctionType), Fn, 
                  Info).getValue() != 0)) {
                continue;
              }
            } finally {
              if (Info != null) { Info.$destroy(); }
            }
          } else {
            Fn.$set(cast_FunctionDecl((D.$star()).getUnderlyingDecl()));
          }
        }
        if ($this().Context.hasSameType(Fn.$deref().getType(), new QualType(ExpectedFunctionType))) {
          Matches.push_back(std.make_pair_T_Ptr($Clone(D.getPair()), Fn.$deref()));
        }
      }
    } else {
      // C++ [expr.new]p20:
      //   [...] Any non-placement deallocation function matches a
      //   non-placement allocation function. [...]
      for (UnresolvedSetIterator D = FoundDelete.begin(), 
          DEnd = FoundDelete.end();
           D.$noteq(DEnd); D.$preInc()) {
        {
          FunctionDecl /*P*/ Fn = dyn_cast_FunctionDecl((D.$star()).getUnderlyingDecl());
          if ((Fn != null)) {
            if (SemaExprCXXStatics.isNonPlacementDeallocationFunction(/*Deref*/$this(), Fn)) {
              Matches.push_back(std.make_pair_T_Ptr($Clone(D.getPair()), Fn));
            }
          }
        }
      }
      
      // C++1y [expr.new]p22:
      //   For a non-placement allocation function, the normal deallocation
      //   function lookup is used
      // C++1y [expr.delete]p?:
      //   If [...] deallocation function lookup finds both a usual deallocation
      //   function with only a pointer parameter and a usual deallocation
      //   function with both a pointer parameter and a size parameter, then the
      //   selected deallocation function shall be the one with two parameters.
      //   Otherwise, the selected deallocation function shall be the function
      //   with one parameter.
      if ($this().getLangOpts().SizedDeallocation && Matches.size() == 2) {
        if (Matches.$at(0).second.getNumParams() == 1) {
          Matches.erase(Matches.begin());
        } else {
          Matches.erase(Matches.begin().$add(1));
        }
        assert (Matches.$at(0).second.getNumParams() == 2) : "found an unexpected usual deallocation function";
      }
    }
    
    // C++ [expr.new]p20:
    //   [...] If the lookup finds a single matching deallocation
    //   function, that function will be called; otherwise, no
    //   deallocation function will be called.
    if (Matches.size() == 1) {
      OperatorDelete.$set(Matches.$at(0).second);
      
      // C++0x [expr.new]p20:
      //   If the lookup finds the two-parameter form of a usual
      //   deallocation function (3.7.4.2) and that function, considered
      //   as a placement deallocation function, would have been
      //   selected as a match for the allocation function, the program
      //   is ill-formed.
      if (!PlaceArgs.empty() && $this().getLangOpts().CPlusPlus11
         && SemaExprCXXStatics.isNonPlacementDeallocationFunction(/*Deref*/$this(), OperatorDelete.$deref())) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_placement_new_non_placement_delete)), 
              new SourceRange(PlaceArgs.front().getLocStart(), 
                  PlaceArgs.back().getLocEnd())));
          if (!OperatorDelete.$deref().isImplicit()) {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(OperatorDelete.$deref().getLocation(), diag.note_previous_decl)), 
                DeleteName));
          }
        } finally {
          $c$.$destroy();
        }
      } else {
        $this().CheckAllocationAccess(new SourceLocation(StartLoc), new SourceRange(Range), FoundDelete.getNamingClass(), 
            new DeclAccessPair(Matches.$at(0).first));
      }
    }
    
    return false;
  } finally {
    if (FoundDelete != null) { FoundDelete.$destroy(); }
  }
}


/// \brief Find an fitting overload for the allocation function
/// in the specified scope.
///
/// \param StartLoc The location of the 'new' token.
/// \param Range The range of the placement arguments.
/// \param Name The name of the function ('operator new' or 'operator new[]').
/// \param Args The placement arguments specified.
/// \param Ctx The scope in which we should search; either a class scope or the
///        translation unit.
/// \param AllowMissing If \c true, report an error if we can't find any
///        allocation functions. Otherwise, succeed but don't fill in \p
///        Operator.
/// \param Operator Filled in with the found allocation function. Unchanged if
///        no allocation function was found.
/// \param Diagnose If \c true, issue errors if the allocation function is not
///        usable.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindAllocationOverload">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2187,
 FQN="clang::Sema::FindAllocationOverload", NM="_ZN5clang4Sema22FindAllocationOverloadENS_14SourceLocationENS_11SourceRangeENS_15DeclarationNameEN4llvm15MutableArrayRefIPNS_4ExprEEEPNS_11DeclContextEbRPNS_12FunctionDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22FindAllocationOverloadENS_14SourceLocationENS_11SourceRangeENS_15DeclarationNameEN4llvm15MutableArrayRefIPNS_4ExprEEEPNS_11DeclContextEbRPNS_12FunctionDeclEb")
//</editor-fold>
public final boolean FindAllocationOverload(SourceLocation StartLoc, SourceRange Range, 
                      DeclarationName Name, MutableArrayRef<Expr /*P*/ > Args, 
                      DeclContext /*P*/ Ctx, 
                      boolean AllowMissing, final type$ref<FunctionDecl /*P*/ /*&*/> Operator) {
  return FindAllocationOverload(StartLoc, Range, 
                      Name, Args, 
                      Ctx, 
                      AllowMissing, Operator, 
                      true);
}
public final boolean FindAllocationOverload(SourceLocation StartLoc, SourceRange Range, 
                      DeclarationName Name, MutableArrayRef<Expr /*P*/ > Args, 
                      DeclContext /*P*/ Ctx, 
                      boolean AllowMissing, final type$ref<FunctionDecl /*P*/ /*&*/> Operator, 
                      boolean Diagnose/*= true*/) {
  LookupResult R = null;
  OverloadCandidateSet Candidates = null;
  try {
    R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(StartLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupQualifiedName(R, Ctx);
    if (R.empty()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        if (AllowMissing || !Diagnose) {
          return false;
        }
        return $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_ovl_no_viable_function_in_call)), 
                Name), Range).$bool());
      } finally {
        $c$.$destroy();
      }
    }
    if (R.isAmbiguous()) {
      return true;
    }
    
    R.suppressDiagnostics();
    
    Candidates/*J*/= new OverloadCandidateSet(new SourceLocation(StartLoc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    for (UnresolvedSetIterator Alloc = R.begin(), AllocEnd = R.end();
         Alloc.$noteq(AllocEnd); Alloc.$preInc()) {
      // Even member operator new/delete are implicitly treated as
      // static, so don't use AddMemberCandidate.
      NamedDecl /*P*/ D = (Alloc.$star()).getUnderlyingDecl();
      {
        
        FunctionTemplateDecl /*P*/ FnTemplate = dyn_cast_FunctionTemplateDecl(D);
        if ((FnTemplate != null)) {
          $this().AddTemplateOverloadCandidate(FnTemplate, new DeclAccessPair(Alloc.getPair()), 
              /*ExplicitTemplateArgs=*/ (TemplateArgumentListInfo /*P*/ )null, 
              new ArrayRef<Expr /*P*/ >(Args), Candidates, 
              /*SuppressUserConversions=*/ false);
          continue;
        }
      }
      
      FunctionDecl /*P*/ Fn = cast_FunctionDecl(D);
      $this().AddOverloadCandidate(Fn, new DeclAccessPair(Alloc.getPair()), new ArrayRef<Expr /*P*/ >(Args), Candidates, 
          /*SuppressUserConversions=*/ false);
    }
    
    // Do the resolution.
    type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (Candidates.BestViableFunction(/*Deref*/$this(), new SourceLocation(StartLoc), Best)) {
     case OR_Success:
      {
        // Got one!
        FunctionDecl /*P*/ FnDecl = Best./*->*/$star().Function;
        if ($this().CheckAllocationAccess(new SourceLocation(StartLoc), new SourceRange(Range), R.getNamingClass(), 
            new DeclAccessPair(Best./*->*/$star().FoundDecl), Diagnose) == AccessResult.AR_inaccessible) {
          return true;
        }
        
        Operator.$set(FnDecl);
        return false;
      }
     case OR_No_Viable_Function:
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_ovl_no_viable_function_in_call)), 
                  Name), Range));
          Candidates.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
     case OR_Ambiguous:
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_ovl_ambiguous_call)), 
                  Name), Range));
          Candidates.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args));
        } finally {
          $c$.$destroy();
        }
      }
      return true;
     case OR_Deleted:
      {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_ovl_deleted_call)), 
                            Best./*->*/$star().Function.isDeleted()), 
                        Name), 
                    $this().getDeletedOrUnavailableSuffix(Best./*->*/$star().Function)), 
                Range));
            Candidates.NoteCandidates(/*Deref*/$this(), OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
    }
    throw new llvm_unreachable("Unreachable, bad result from BestViableFunction");
  } finally {
    if (Candidates != null) { Candidates.$destroy(); }
    if (R != null) { R.$destroy(); }
  }
}


/// DeclareGlobalNewDelete - Declare the global forms of operator new and
/// delete. These are:
/// @code
///   // C++03:
///   void* operator new(std::size_t) throw(std::bad_alloc);
///   void* operator new[](std::size_t) throw(std::bad_alloc);
///   void operator delete(void *) throw();
///   void operator delete[](void *) throw();
///   // C++11:
///   void* operator new(std::size_t);
///   void* operator new[](std::size_t);
///   void operator delete(void *) noexcept;
///   void operator delete[](void *) noexcept;
///   // C++1y:
///   void* operator new(std::size_t);
///   void* operator new[](std::size_t);
///   void operator delete(void *) noexcept;
///   void operator delete[](void *) noexcept;
///   void operator delete(void *, std::size_t) noexcept;
///   void operator delete[](void *, std::size_t) noexcept;
/// @endcode
/// Note that the placement and nothrow forms of new are *not* implicitly
/// declared. Their use requires including \<new\>.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareGlobalNewDelete">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2295,
 FQN="clang::Sema::DeclareGlobalNewDelete", NM="_ZN5clang4Sema22DeclareGlobalNewDeleteEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22DeclareGlobalNewDeleteEv")
//</editor-fold>
public final void DeclareGlobalNewDelete() {
  if ($this().GlobalNewDeleteDeclared) {
    return;
  }
  
  // C++ [basic.std.dynamic]p2:
  //   [...] The following allocation and deallocation functions (18.4) are
  //   implicitly declared in global scope in each translation unit of a
  //   program
  //
  //     C++03:
  //     void* operator new(std::size_t) throw(std::bad_alloc);
  //     void* operator new[](std::size_t) throw(std::bad_alloc);
  //     void  operator delete(void*) throw();
  //     void  operator delete[](void*) throw();
  //     C++11:
  //     void* operator new(std::size_t);
  //     void* operator new[](std::size_t);
  //     void  operator delete(void*) noexcept;
  //     void  operator delete[](void*) noexcept;
  //     C++1y:
  //     void* operator new(std::size_t);
  //     void* operator new[](std::size_t);
  //     void  operator delete(void*) noexcept;
  //     void  operator delete[](void*) noexcept;
  //     void  operator delete(void*, std::size_t) noexcept;
  //     void  operator delete[](void*, std::size_t) noexcept;
  //
  //   These implicit declarations introduce only the function names operator
  //   new, operator new[], operator delete, operator delete[].
  //
  // Here, we need to refer to std::bad_alloc, so we will implicitly declare
  // "std" or "bad_alloc" as necessary to form the exception specification.
  // However, we do not make these implicit declarations visible to name
  // lookup.
  if (!$this().StdBadAlloc.$bool() && !$this().getLangOpts().CPlusPlus11) {
    // The "std::bad_alloc" class has not yet been declared, so build it
    // implicitly.
    $this().StdBadAlloc.$assign(CXXRecordDecl.Create($this().Context, TagTypeKind.TTK_Class, 
            $this().getOrCreateStdNamespace(), 
            new SourceLocation(), new SourceLocation(), 
            $AddrOf($this().PP.getIdentifierTable().get(new StringRef(/*KEEP_STR*/"bad_alloc"))), 
            (CXXRecordDecl /*P*/ )null));
    $this().getStdBadAlloc().setImplicit(true);
  }
  
  $this().GlobalNewDeleteDeclared = true;
  
  QualType VoidPtr = $this().Context.getPointerType(/*NO_COPY*/$this().Context.VoidTy).$QualType();
  QualType SizeT = $this().Context.getSizeType().$QualType();
  
  $this().DeclareGlobalAllocationFunction($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_New), 
      new QualType(VoidPtr), new QualType(SizeT), new QualType());
  $this().DeclareGlobalAllocationFunction($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Array_New), 
      new QualType(VoidPtr), new QualType(SizeT), new QualType());
  $this().DeclareGlobalAllocationFunction($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Delete), 
      $this().Context.VoidTy.$QualType(), new QualType(VoidPtr));
  $this().DeclareGlobalAllocationFunction($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Array_Delete), 
      $this().Context.VoidTy.$QualType(), new QualType(VoidPtr));
  if ($this().getLangOpts().SizedDeallocation) {
    $this().DeclareGlobalAllocationFunction($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Delete), 
        $this().Context.VoidTy.$QualType(), new QualType(VoidPtr), $this().Context.getSizeType().$QualType());
    $this().DeclareGlobalAllocationFunction($this().Context.DeclarationNames.getCXXOperatorName(OverloadedOperatorKind.OO_Array_Delete), 
        $this().Context.VoidTy.$QualType(), new QualType(VoidPtr), $this().Context.getSizeType().$QualType());
  }
}


/// DeclareGlobalAllocationFunction - Declares a single implicit global
/// allocation function if it doesn't already exist.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::DeclareGlobalAllocationFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2369,
 FQN="clang::Sema::DeclareGlobalAllocationFunction", NM="_ZN5clang4Sema31DeclareGlobalAllocationFunctionENS_15DeclarationNameENS_8QualTypeES2_S2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema31DeclareGlobalAllocationFunctionENS_15DeclarationNameENS_8QualTypeES2_S2_")
//</editor-fold>
public final void DeclareGlobalAllocationFunction(DeclarationName Name, 
                               QualType Return, 
                               QualType Param1) {
  DeclareGlobalAllocationFunction(Name, 
                               Return, 
                               Param1, new QualType());
}
public final void DeclareGlobalAllocationFunction(DeclarationName Name, 
                               QualType Return, 
                               QualType Param1, QualType Param2/*= QualType()*/) {
  DeclContext /*P*/ GlobalCtx = $this().Context.getTranslationUnitDecl();
  /*uint*/int NumParams = Param2.isNull() ? 1 : 2;
  
  // Check if this function is already declared.
  DeclContextLookupResult R = GlobalCtx.lookup(new DeclarationName(Name));
  for (DeclContextLookupResult.iterator Alloc = R.begin(), AllocEnd = R.end();
       Alloc.$noteq(AllocEnd); Alloc.$preInc()) {
    {
      // Only look at non-template functions, as it is the predefined,
      // non-templated allocation function we are trying to declare here.
      FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(Alloc.$star());
      if ((Func != null)) {
        if (Func.getNumParams() == NumParams) {
          QualType InitialParam1Type = $this().Context.getCanonicalType(Func.getParamDecl(0).
                  getType().getUnqualifiedType()).$QualType();
          QualType InitialParam2Type = NumParams == 2 ? $this().Context.getCanonicalType(Func.getParamDecl(1).
                  getType().getUnqualifiedType()).$QualType() : new QualType();
          // FIXME: Do we need to check for default arguments here?
          if (QualType.$eq_QualType$C(InitialParam1Type, Param1)
             && (NumParams == 1 || QualType.$eq_QualType$C(InitialParam2Type, Param2))) {
            // Make the function visible to name lookup, even if we found it in
            // an unimported module. It either is an implicitly-declared global
            // allocation function, or is suppressing that function.
            Func.setHidden(false);
            return;
          }
        }
      }
    }
  }
  
  FunctionProtoType.ExtProtoInfo EPI/*J*/= new FunctionProtoType.ExtProtoInfo();
  
  QualType BadAllocType/*J*/= new QualType();
  boolean HasBadAllocExceptionSpec = (Name.getCXXOverloadedOperator() == OverloadedOperatorKind.OO_New
     || Name.getCXXOverloadedOperator() == OverloadedOperatorKind.OO_Array_New);
  if (HasBadAllocExceptionSpec) {
    if (!$this().getLangOpts().CPlusPlus11) {
      BadAllocType.$assignMove($this().Context.getTypeDeclType($this().getStdBadAlloc()));
      assert ($this().StdBadAlloc.$bool()) : "Must have std::bad_alloc declared";
      EPI.ExceptionSpec.Type = ExceptionSpecificationType.EST_Dynamic;
      EPI.ExceptionSpec.Exceptions.$assignMove(llvm.makeArrayRef(BadAllocType, false));
    }
  } else {
    EPI.ExceptionSpec.$assignMove(
        new FunctionProtoType.ExceptionSpecInfo($this().getLangOpts().CPlusPlus11 ? ExceptionSpecificationType.EST_BasicNoexcept : ExceptionSpecificationType.EST_DynamicNone)
    );
  }
  
  QualType Params[/*2*/] = new QualType [/*2*/] {Param1, Param2};
  
  QualType FnType = $this().Context.getFunctionType(new QualType(Return), llvm.makeArrayRef(create_type$ptr(Params), NumParams, false), EPI);
  FunctionDecl /*P*/ Alloc = FunctionDecl.Create($this().Context, GlobalCtx, new SourceLocation(), 
      new SourceLocation(), new DeclarationName(Name), 
      new QualType(FnType), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, StorageClass.SC_None, false, true);
  Alloc.setImplicit();
  
  // Implicit sized deallocation functions always have default visibility.
  Alloc.addAttr(VisibilityAttr.CreateImplicit($this().Context, 
          VisibilityAttr.VisibilityType.Default));
  
  ParmVarDecl /*P*/ ParamDecls[/*2*/] = new ParmVarDecl /*P*/  [2];
  for (/*uint*/int I = 0; I != NumParams; ++I) {
    ParamDecls[I] = ParmVarDecl.Create($this().Context, Alloc, new SourceLocation(), 
        new SourceLocation(), (IdentifierInfo /*P*/ )null, 
        new QualType(Params[I]), /*TInfo=*/ (TypeSourceInfo /*P*/ )null, 
        StorageClass.SC_None, (Expr /*P*/ )null);
    ParamDecls[I].setImplicit();
  }
  Alloc.setParams(llvm.makeArrayRef(create_type$ptr(ParamDecls), NumParams, true));
  
  $this().Context.getTranslationUnitDecl().addDecl(Alloc);
  $this().IdResolver.tryAddTopLevelDecl(Alloc, new DeclarationName(Name));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindDeallocationFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2495,
 FQN="clang::Sema::FindDeallocationFunction", NM="_ZN5clang4Sema24FindDeallocationFunctionENS_14SourceLocationEPNS_13CXXRecordDeclENS_15DeclarationNameERPNS_12FunctionDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema24FindDeallocationFunctionENS_14SourceLocationEPNS_13CXXRecordDeclENS_15DeclarationNameERPNS_12FunctionDeclEb")
//</editor-fold>
public final boolean FindDeallocationFunction(SourceLocation StartLoc, CXXRecordDecl /*P*/ RD, 
                        DeclarationName Name, 
                        final type$ref<FunctionDecl /*P*/ /*&*/> Operator) {
  return FindDeallocationFunction(StartLoc, RD, 
                        Name, 
                        Operator, true);
}
public final boolean FindDeallocationFunction(SourceLocation StartLoc, CXXRecordDecl /*P*/ RD, 
                        DeclarationName Name, 
                        final type$ref<FunctionDecl /*P*/ /*&*/> Operator, boolean Diagnose/*= true*/) {
  LookupResult Found = null;
  try {
    Found/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(StartLoc), LookupNameKind.LookupOrdinaryName);
    // Try to find operator delete/operator delete[] in class scope.
    $this().LookupQualifiedName(Found, RD);
    if (Found.isAmbiguous()) {
      return true;
    }
    
    Found.suppressDiagnostics();
    
    SmallVector<DeclAccessPair> Matches/*J*/= new SmallVector<DeclAccessPair>(4, new DeclAccessPair());
    for (UnresolvedSetIterator F = Found.begin(), FEnd = Found.end();
         F.$noteq(FEnd); F.$preInc()) {
      NamedDecl /*P*/ ND = (F.$star()).getUnderlyingDecl();
      
      // Ignore template operator delete members from the check for a usual
      // deallocation function.
      if (isa_FunctionTemplateDecl(ND)) {
        continue;
      }
      if (cast_CXXMethodDecl(ND).isUsualDeallocationFunction()) {
        Matches.push_back(F.getPair());
      }
    }
    if ($this().getLangOpts().CUDA) {
      $this().EraseUnwantedCUDAMatches_FunctionDecl$C$P_SmallVectorImpl$DeclAccessPair(dyn_cast_FunctionDecl($this().CurContext), Matches);
    }
    
    // There's exactly one suitable operator;  pick it.
    if (Matches.size() == 1) {
      Operator.$set(cast_CXXMethodDecl(Matches.$at(0).$arrow().getUnderlyingDecl()));
      if (Operator.$deref().isDeleted()) {
        if (Diagnose) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_deleted_function_use)));
            $this().NoteDeletedFunction(Operator.$deref());
          } finally {
            $c$.$destroy();
          }
        }
        return true;
      }
      if ($this().CheckAllocationAccess(new SourceLocation(StartLoc), new SourceRange(), Found.getNamingClass(), 
          new DeclAccessPair(Matches.$at(0)), Diagnose) == AccessResult.AR_inaccessible) {
        return true;
      }
      
      return false;
      // We found multiple suitable operators;  complain about the ambiguity.
    } else if (!Matches.empty()) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_ambiguous_suitable_delete_member_function_found)), 
                  Name), RD));
          
          for (type$ptr<DeclAccessPair> F = $tryClone(Matches.begin()), /*P*/ FEnd = $tryClone(Matches.end()); $noteq_ptr(F, FEnd); F.$preInc())  {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag((F.$star()).$arrow().getUnderlyingDecl().getLocation(), 
                    diag.note_member_declared_here)), Name));
          }
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    // We did find operator delete/operator delete[] declarations, but
    // none of them were suitable.
    if (!Found.empty()) {
      if (Diagnose) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_no_suitable_delete_member_function_found)), 
                  Name), RD));
          
          for (UnresolvedSetIterator F = Found.begin(), FEnd = Found.end();
               F.$noteq(FEnd); F.$preInc())  {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_DeclarationName($c$.track($this().Diag((F.$star()).getUnderlyingDecl().getLocation(), 
                    diag.note_member_declared_here)), Name));
          }
        } finally {
          $c$.$destroy();
        }
      }
      return true;
    }
    
    Operator.$set(null);
    return false;
  } finally {
    if (Found != null) { Found.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindUsualDeallocationFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2450,
 FQN="clang::Sema::FindUsualDeallocationFunction", NM="_ZN5clang4Sema29FindUsualDeallocationFunctionENS_14SourceLocationEbNS_15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema29FindUsualDeallocationFunctionENS_14SourceLocationEbNS_15DeclarationNameE")
//</editor-fold>
public final FunctionDecl /*P*/ FindUsualDeallocationFunction(SourceLocation StartLoc, 
                             boolean CanProvideSize, 
                             DeclarationName Name) {
  LookupResult FoundDelete = null;
  try {
    $this().DeclareGlobalNewDelete();
    
    FoundDelete/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(Name), new SourceLocation(StartLoc), LookupNameKind.LookupOrdinaryName);
    $this().LookupQualifiedName(FoundDelete, $this().Context.getTranslationUnitDecl());
    
    // C++ [expr.new]p20:
    //   [...] Any non-placement deallocation function matches a
    //   non-placement allocation function. [...]
    SmallVector<FunctionDecl /*P*/ > Matches/*J*/= new SmallVector<FunctionDecl /*P*/ >(2, (FunctionDecl /*P*/ )null);
    for (UnresolvedSetIterator D = FoundDelete.begin(), 
        DEnd = FoundDelete.end();
         D.$noteq(DEnd); D.$preInc()) {
      {
        FunctionDecl /*P*/ Fn = dyn_cast_FunctionDecl(D.$star());
        if ((Fn != null)) {
          if (SemaExprCXXStatics.isNonPlacementDeallocationFunction(/*Deref*/$this(), Fn)) {
            Matches.push_back(Fn);
          }
        }
      }
    }
    
    // C++1y [expr.delete]p?:
    //   If the type is complete and deallocation function lookup finds both a
    //   usual deallocation function with only a pointer parameter and a usual
    //   deallocation function with both a pointer parameter and a size
    //   parameter, then the selected deallocation function shall be the one
    //   with two parameters.  Otherwise, the selected deallocation function
    //   shall be the function with one parameter.
    if ($this().getLangOpts().SizedDeallocation && Matches.size() == 2) {
      /*uint*/int NumArgs = CanProvideSize ? 2 : 1;
      if (Matches.$at(0).getNumParams() != NumArgs) {
        Matches.erase(Matches.begin());
      } else {
        Matches.erase(Matches.begin().$add(1));
      }
      assert (Matches.$at(0).getNumParams() == NumArgs) : "found an unexpected usual deallocation function";
    }
    if ($this().getLangOpts().CUDA) {
      $this().EraseUnwantedCUDAMatches_FunctionDecl$C$P_SmallVectorImpl$FunctionDecl$P(dyn_cast_FunctionDecl($this().CurContext), Matches);
    }
    assert (Matches.size() == 1) : "unexpectedly have multiple usual deallocation functions";
    return Matches.front();
  } finally {
    if (FoundDelete != null) { FoundDelete.$destroy(); }
  }
}


/// ActOnCXXDelete - Parsed a C++ 'delete' expression

/// ActOnCXXDelete - Parsed a C++ 'delete' expression (C++ 5.3.5), as in:
/// @code ::delete ptr; @endcode
/// or
/// @code delete [] ptr; @endcode
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2835,
 FQN="clang::Sema::ActOnCXXDelete", NM="_ZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnCXXDelete(SourceLocation StartLoc, boolean UseGlobal, 
              boolean ArrayForm, Expr /*P*/ ExE) {
  // C++ [expr.delete]p1:
  //   The operand shall have a pointer type, or a class type having a single
  //   non-explicit conversion function to a pointer type. The result has type
  //   void.
  //
  // DR599 amends "pointer type" to "pointer to object type" in both cases.
  ActionResultTTrue<Expr /*P*/ > Ex = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, ExE);
  type$ref<FunctionDecl /*P*/ > OperatorDelete = create_type$null$ref(null);
  boolean ArrayFormAsWritten = ArrayForm;
  boolean UsualArrayDeleteWantsSize = false;
  if (!Ex.get().isTypeDependent()) {
    ActOnCXXDelete$$.DeleteConverter Converter = null;
    try {
      // Perform lvalue-to-rvalue cast, if needed.
      Ex.$assignMove($this().DefaultLvalueConversion(Ex.get()));
      if (Ex.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      
      QualType Type = Ex.get().getType();
      
      Converter/*J*/= new  ActOnCXXDelete$$.DeleteConverter();
      
      Ex.$assignMove($this().PerformContextualImplicitConversion(new SourceLocation(StartLoc), Ex.get(), Converter));
      if (Ex.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      Type.$assignMove(Ex.get().getType());
      if (!Converter.match(/*NO_COPY*/Type)) {
        // FIXME: PerformContextualImplicitConversion should return ExprError
        //        itself in this case.
        return SemaClangGlobals.ExprError();
      }
      
      QualType Pointee = Type.$arrow().getAs(PointerType.class).getPointeeType();
      QualType PointeeElem = $this().Context.getBaseElementType(new QualType(Pointee));
      {
        
        /*uint*/int AddressSpace = Pointee.getAddressSpace();
        if ((AddressSpace != 0)) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            return $c$.clean(new ActionResultTTrue<Expr /*P*/ >(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(Ex.get().getLocStart(), 
                            diag.err_address_space_qualified_delete)), 
                        Pointee.getUnqualifiedType()), AddressSpace)));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      CXXRecordDecl /*P*/ PointeeRD = null;
      if (Pointee.$arrow().isVoidType() && !$this().isSFINAEContext().$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          // The C++ standard bans deleting a pointer to a non-object type, which
          // effectively bans deletion of "void*". However, most compilers support
          // this, so we treat it as a warning unless we're in a SFINAE context.
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.ext_delete_void_ptr_operand)), 
                  Type), Ex.get().getSourceRange()));
        } finally {
          $c$.$destroy();
        }
      } else if (Pointee.$arrow().isFunctionType() || Pointee.$arrow().isVoidType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.err_delete_operand)), 
                      Type), Ex.get().getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      } else if (!Pointee.$arrow().isDependentType()) {
        // FIXME: This can result in errors if the definition was imported from a
        // module but is hidden.
        if (!$this().RequireCompleteType$T(new SourceLocation(StartLoc), new QualType(Pointee), 
            diag.warn_delete_incomplete, Ex.get())) {
          {
            /*const*/ RecordType /*P*/ RT = PointeeElem.$arrow().getAs$RecordType();
            if ((RT != null)) {
              PointeeRD = cast_CXXRecordDecl(RT.getDecl());
            }
          }
        }
      }
      if (Pointee.$arrow().isArrayType() && !ArrayForm) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(StartLoc), diag.warn_delete_array_type)), 
                      Type), Ex.get().getSourceRange()), 
              FixItHint.CreateInsertion($this().getLocForEndOfToken(new SourceLocation(StartLoc)), new StringRef(/*KEEP_STR*/$LSQUARE_RSQUARE))));
          ArrayForm = true;
        } finally {
          $c$.$destroy();
        }
      }
      
      DeclarationName DeleteName = $this().Context.DeclarationNames.getCXXOperatorName(ArrayForm ? OverloadedOperatorKind.OO_Array_Delete : OverloadedOperatorKind.OO_Delete);
      if ((PointeeRD != null)) {
        if (!UseGlobal
           && $this().FindDeallocationFunction(new SourceLocation(StartLoc), PointeeRD, new DeclarationName(DeleteName), 
            OperatorDelete)) {
          return SemaClangGlobals.ExprError();
        }
        
        // If we're allocating an array of records, check whether the
        // usual operator delete[] has a size_t parameter.
        if (ArrayForm) {
          // If the user specifically asked to use the global allocator,
          // we'll need to do the lookup into the class.
          if (UseGlobal) {
            UsualArrayDeleteWantsSize
               = SemaExprCXXStatics.doesUsualArrayDeleteWantSize(/*Deref*/$this(), new SourceLocation(StartLoc), new QualType(PointeeElem));
          } else 
          // Otherwise, the usual operator delete[] should be the
          // function we just found.
          if ((OperatorDelete.$deref() != null) && isa_CXXMethodDecl(OperatorDelete)) {
            UsualArrayDeleteWantsSize = (OperatorDelete.$deref().getNumParams() == 2);
          }
        }
        if (!PointeeRD.hasIrrelevantDestructor()) {
          {
            CXXDestructorDecl /*P*/ Dtor = $this().LookupDestructor(PointeeRD);
            if ((Dtor != null)) {
              $this().MarkFunctionReferenced(new SourceLocation(StartLoc), 
                  ((/*const_cast*/CXXDestructorDecl /*P*/ )(Dtor)));
              if ($this().DiagnoseUseOfDecl(Dtor, new SourceLocation(StartLoc))) {
                return SemaClangGlobals.ExprError();
              }
            }
          }
        }
        
        $this().CheckVirtualDtorCall(PointeeRD.getDestructor(), new SourceLocation(StartLoc), 
            /*IsDelete=*/ true, /*CallCanBeVirtual=*/ true, 
            /*WarnOnNonAbstractTypes=*/ !ArrayForm, 
            new SourceLocation());
      }
      if (!(OperatorDelete.$deref() != null)) {
        // Look for a global declaration.
        OperatorDelete.$set($this().FindUsualDeallocationFunction(new SourceLocation(StartLoc), $this().isCompleteType(new SourceLocation(StartLoc), new QualType(Pointee))
               && (!ArrayForm || UsualArrayDeleteWantsSize
               || (Pointee.isDestructedType().getValue() != 0)), 
            new DeclarationName(DeleteName)));
      }
      
      $this().MarkFunctionReferenced(new SourceLocation(StartLoc), OperatorDelete.$deref());
      
      // Check access and ambiguity of operator delete and destructor.
      if ((PointeeRD != null)) {
        {
          CXXDestructorDecl /*P*/ Dtor = $this().LookupDestructor(PointeeRD);
          if ((Dtor != null)) {
            JavaCleaner $c$ = $createJavaCleaner();
            try {
              $c$.clean($this().CheckDestructorAccess(Ex.get().getExprLoc(), Dtor, 
                  $out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor)), /*NO_COPY*/PointeeElem)));
            } finally {
              $c$.$destroy();
            }
          }
        }
      }
    } finally {
      if (Converter != null) { Converter.$destroy(); }
    }
  }
  final boolean L$ArrayForm = ArrayForm;
  final boolean L$UsualArrayDeleteWantsSize = UsualArrayDeleteWantsSize;
  CXXDeleteExpr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CXXDeleteExpr($this().Context.VoidTy.$QualType(), UseGlobal, L$ArrayForm, ArrayFormAsWritten, 
              L$UsualArrayDeleteWantsSize, OperatorDelete.$deref(), Ex.get(), new SourceLocation(StartLoc));
   });
  $this().AnalyzeDeleteExprMismatch(Result);
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
}
private static final class ActOnCXXDelete$$ {
  static //<editor-fold defaultstate="collapsed" desc="DeleteConverter">
  @Converted(kind = Converted.Kind.AUTO,
   source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2858,
   FQN="DeleteConverter", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEE15DeleteConverter",
   cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEE15DeleteConverter")
  //</editor-fold>
   class DeleteConverter extends /*public*/ ContextualImplicitConverter implements Destructors.ClassWithDestructor {
  /*public:*/
    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::DeleteConverter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2860,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::DeleteConverter", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverterC1Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverterC1Ev")
    //</editor-fold>
    public DeleteConverter() {
      // : ContextualImplicitConverter(false, true) 
      //START JInit
      super(false, true);
      //END JInit
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::match">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2862,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::match", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter5matchENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter5matchENS_8QualTypeE")
    //</editor-fold>
    @Override public boolean match(QualType ConvType)/* override*/ {
      {
        // FIXME: If we have an operator T* and an operator void*, we must pick
        // the operator T*.
        /*const*/ PointerType /*P*/ ConvPtrType = ConvType.$arrow().getAs(PointerType.class);
        if ((ConvPtrType != null)) {
          if (ConvPtrType.getPointeeType().$arrow().isIncompleteOrObjectType()) {
            return true;
          }
        }
      }
      return false;
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseNoMatch">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2871,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseNoMatch", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter15diagnoseNoMatchERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter15diagnoseNoMatchERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseNoMatch(final Sema /*&*/ S, SourceLocation Loc, 
                   QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_delete_operand)), T)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseIncomplete">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2876,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseIncomplete", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter18diagnoseIncompleteERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter18diagnoseIncompleteERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseIncomplete(final Sema /*&*/ S, SourceLocation Loc, 
                      QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_delete_incomplete_class_type)), T)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2881,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseExplicitConv", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter20diagnoseExplicitConvERS0_S1_NS_8QualTypeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter20diagnoseExplicitConvERS0_S1_NS_8QualTypeES6_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseExplicitConv(final Sema /*&*/ S, SourceLocation Loc, 
                        QualType T, 
                        QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_delete_explicit_conversion)), T), ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::noteExplicitConv">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2887,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::noteExplicitConv", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter16noteExplicitConvERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteExplicitConv(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, 
                    QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(Conv.getLocation(), diag.note_delete_conversion)), 
                ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2893,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseAmbiguous", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter17diagnoseAmbiguousERS0_S1_NS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter17diagnoseAmbiguousERS0_S1_NS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseAmbiguous(final Sema /*&*/ S, SourceLocation Loc, 
                     QualType T)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(new SourceLocation(Loc), diag.err_ambiguous_delete_operand)), T)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::noteAmbiguous">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2898,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::noteAmbiguous", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter13noteAmbiguousERS0_PNS_17CXXConversionDeclENS_8QualTypeE")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder noteAmbiguous(final Sema /*&*/ S, CXXConversionDecl /*P*/ Conv, 
                 QualType ConvTy)/* override*/ {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new SemaDiagnosticBuilder(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track(S.Diag(Conv.getLocation(), diag.note_delete_conversion)), 
                ConvTy)));
      } finally {
        $c$.$destroy();
      }
    }


    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseConversion">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2904,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::diagnoseConversion", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter18diagnoseConversionERS0_S1_NS_8QualTypeES6_",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverter18diagnoseConversionERS0_S1_NS_8QualTypeES6_")
    //</editor-fold>
    @Override public SemaDiagnosticBuilder diagnoseConversion(final Sema /*&*/ S, SourceLocation Loc, 
                      QualType T, 
                      QualType ConvTy)/* override*/ {
      throw new llvm_unreachable("conversion functions are permitted");
    }

    //<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::~DeleteConverter">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2858,
     FQN="clang::Sema::ActOnCXXDelete(SourceLocation, bool, bool, Expr * )::DeleteConverter::~DeleteConverter", NM="_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverterD0Ev",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZZN5clang4Sema14ActOnCXXDeleteENS_14SourceLocationEbbPNS_4ExprEEN15DeleteConverterD0Ev")
    //</editor-fold>
    @Override public /*inline*/ void $destroy() {
      super.$destroy();
    }


    @Override public String toString() {
      return "" + super.toString(); // NOI18N
    }
  };
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckVirtualDtorCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3019,
 FQN="clang::Sema::CheckVirtualDtorCall", NM="_ZN5clang4Sema20CheckVirtualDtorCallEPNS_17CXXDestructorDeclENS_14SourceLocationEbbbS3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema20CheckVirtualDtorCallEPNS_17CXXDestructorDeclENS_14SourceLocationEbbbS3_")
//</editor-fold>
public final void CheckVirtualDtorCall(CXXDestructorDecl /*P*/ dtor, SourceLocation Loc, 
                    boolean IsDelete, boolean CallCanBeVirtual, 
                    boolean WarnOnNonAbstractTypes, 
                    SourceLocation DtorLoc) {
  if (!(dtor != null) || dtor.isVirtual() || !CallCanBeVirtual) {
    return;
  }
  
  // C++ [expr.delete]p3:
  //   In the first alternative (delete object), if the static type of the
  //   object to be deleted is different from its dynamic type, the static
  //   type shall be a base class of the dynamic type of the object to be
  //   deleted and the static type shall have a virtual destructor or the
  //   behavior is undefined.
  //
  /*const*/ CXXRecordDecl /*P*/ PointeeRD = dtor.getParent();
  // Note: a final class cannot be derived from, no issue there
  if (!PointeeRD.isPolymorphic() || PointeeRD.hasAttr(FinalAttr.class)) {
    return;
  }
  
  QualType ClassType = dtor.getThisType($this().Context).$arrow().getPointeeType();
  if (PointeeRD.isAbstract()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // If the class is abstract, we warn by default, because we're
      // sure the code has undefined behavior.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_delete_abstract_non_virtual_dtor)), (IsDelete ? 0 : 1)), 
          ClassType));
    } finally {
      $c$.$destroy();
    }
  } else if (WarnOnNonAbstractTypes) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Otherwise, if this is not an array delete, it's a bit suspect,
      // but not necessarily wrong.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int($c$.track($this().Diag(new SourceLocation(Loc), diag.warn_delete_non_virtual_dtor)), (IsDelete ? 0 : 1)), 
          ClassType));
    } finally {
      $c$.$destroy();
    }
  }
  if (!IsDelete) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string TypeStr/*J*/= new std.string();
      ClassType.getAsStringInternal(TypeStr, $this().getPrintingPolicy());
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint($c$.track($this().Diag(new SourceLocation(DtorLoc), diag.note_delete_non_virtual)), 
          FixItHint.CreateInsertion(/*NO_COPY*/DtorLoc, new StringRef($add_string$C_T$C$P(TypeStr, /*KEEP_STR*/"::")))));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnNoexceptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6420,
 FQN="clang::Sema::ActOnNoexceptExpr", NM="_ZN5clang4Sema17ActOnNoexceptExprENS_14SourceLocationES1_PNS_4ExprES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema17ActOnNoexceptExprENS_14SourceLocationES1_PNS_4ExprES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnNoexceptExpr(SourceLocation KeyLoc, SourceLocation $Prm1, 
                 Expr /*P*/ Operand, SourceLocation RParen) {
  return $this().BuildCXXNoexceptExpr(new SourceLocation(KeyLoc), Operand, new SourceLocation(RParen));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXNoexceptExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6396,
 FQN="clang::Sema::BuildCXXNoexceptExpr", NM="_ZN5clang4Sema20BuildCXXNoexceptExprENS_14SourceLocationEPNS_4ExprES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema20BuildCXXNoexceptExprENS_14SourceLocationEPNS_4ExprES1_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXNoexceptExpr(SourceLocation KeyLoc, Expr /*P*/ Operand, 
                    SourceLocation RParen) {
  // If the operand is an unresolved lookup expression, the expression is ill-
  // formed per [over.over]p1, because overloaded function names cannot be used
  // without arguments except in explicit contexts.
  ActionResultTTrue<Expr /*P*/ > R = $this().CheckPlaceholderExpr(Operand);
  if (R.isInvalid()) {
    return R;
  }
  
  // The operand may have been modified when checking the placeholder type.
  Operand = R.get();
  if ($this().ActiveTemplateInstantiations.empty()
     && Operand.HasSideEffects($this().Context, false)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // The expression operand for noexcept is in an unevaluated expression
      // context, so side effects could result in unintended consequences.
      $c$.clean($c$.track($this().Diag(Operand.getExprLoc(), diag.warn_side_effects_unevaluated_context)));
    } finally {
      $c$.$destroy();
    }
  }
  
  CanThrowResult CanThrow = $this().canThrow(Operand);
  final Expr /*P*/ L$Operand = Operand;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new CXXNoexceptExpr($this().Context.BoolTy.$QualType(), L$Operand, CanThrow, new SourceLocation(KeyLoc), new SourceLocation(RParen));
       }));
}


/// \brief Parsed one of the type trait support pseudo-functions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnTypeTrait">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4456,
 FQN="clang::Sema::ActOnTypeTrait", NM="_ZN5clang4Sema14ActOnTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14ActOnTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefINS_9OpaquePtrINS_8QualTypeEEEEES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnTypeTrait(TypeTrait Kind, SourceLocation KWLoc, 
              ArrayRef<OpaquePtr<QualType>> Args, 
              SourceLocation RParenLoc) {
  SmallVector<TypeSourceInfo /*P*/ > ConvertedArgs/*J*/= new SmallVector<TypeSourceInfo /*P*/ >(4, (TypeSourceInfo /*P*/ )null);
  ConvertedArgs.reserve(Args.size());
  
  for (/*uint*/int I = 0, N = Args.size(); I != N; ++I) {
    type$ptr<TypeSourceInfo /*P*/ > TInfo = create_type$null$ptr();
    QualType T = GetTypeFromParser(new OpaquePtr<QualType>(Args.$at(I)), $AddrOf(TInfo));
    if (!(TInfo.$star() != null)) {
      TInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T, /*NO_COPY*/KWLoc));
    }
    
    ConvertedArgs.push_back(TInfo.$star());
  }
  
  return $this().BuildTypeTrait(Kind, new SourceLocation(KWLoc), new ArrayRef<TypeSourceInfo /*P*/ >(ConvertedArgs, true), new SourceLocation(RParenLoc));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4431,
 FQN="clang::Sema::BuildTypeTrait", NM="_ZN5clang4Sema14BuildTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema14BuildTypeTraitENS_9TypeTraitENS_14SourceLocationEN4llvm8ArrayRefIPNS_14TypeSourceInfoEEES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildTypeTrait(TypeTrait Kind, SourceLocation KWLoc, 
              ArrayRef<TypeSourceInfo /*P*/ > Args, 
              SourceLocation RParenLoc) {
  QualType ResultType = $this().Context.getLogicalOperationType();
  if (Kind.getValue() <= TypeTrait.UTT_Last.getValue() && !SemaExprCXXStatics.CheckUnaryTypeTraitTypeCompleteness(/*Deref*/$this(), Kind, new SourceLocation(KWLoc), Args.$at(0).getType())) {
    return SemaClangGlobals.ExprError();
  }
  
  boolean Dependent = false;
  for (/*uint*/int I = 0, N = Args.size(); I != N; ++I) {
    if (Args.$at(I).getType().$arrow().isDependentType()) {
      Dependent = true;
      break;
    }
  }
  
  boolean Result = false;
  if (!Dependent) {
    Result = SemaExprCXXStatics.evaluateTypeTrait(/*Deref*/$this(), Kind, new SourceLocation(KWLoc), new ArrayRef<TypeSourceInfo /*P*/ >(Args), new SourceLocation(RParenLoc));
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, TypeTraitExpr.Create($this().Context, new QualType(ResultType), new SourceLocation(KWLoc), Kind, new ArrayRef<TypeSourceInfo /*P*/ >(Args), 
          new SourceLocation(RParenLoc), Result));
}


/// ActOnArrayTypeTrait - Parsed one of the bianry type trait support
/// pseudo-functions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnArrayTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4650,
 FQN="clang::Sema::ActOnArrayTypeTrait", NM="_ZN5clang4Sema19ActOnArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema19ActOnArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationENS_9OpaquePtrINS_8QualTypeEEEPNS_4ExprES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnArrayTypeTrait(ArrayTypeTrait ATT, 
                   SourceLocation KWLoc, 
                   OpaquePtr<QualType> Ty, 
                   Expr /*P*/ DimExpr, 
                   SourceLocation RParen) {
  type$ptr<TypeSourceInfo /*P*/ > TSInfo = create_type$null$ptr();
  QualType T = GetTypeFromParser(new OpaquePtr<QualType>(Ty), $AddrOf(TSInfo));
  if (!(TSInfo.$star() != null)) {
    TSInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/T));
  }
  
  return $this().BuildArrayTypeTrait(ATT, new SourceLocation(KWLoc), TSInfo.$star(), DimExpr, new SourceLocation(RParen));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildArrayTypeTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4717,
 FQN="clang::Sema::BuildArrayTypeTrait", NM="_ZN5clang4Sema19BuildArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationEPNS_14TypeSourceInfoEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema19BuildArrayTypeTraitENS_14ArrayTypeTraitENS_14SourceLocationEPNS_14TypeSourceInfoEPNS_4ExprES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildArrayTypeTrait(ArrayTypeTrait ATT, 
                   SourceLocation KWLoc, 
                   TypeSourceInfo /*P*/ TSInfo, 
                   Expr /*P*/ DimExpr, 
                   SourceLocation RParen) {
  QualType T = TSInfo.getType();
  
  // FIXME: This should likely be tracked as an APInt to remove any host
  // assumptions about the width of size_t on the target.
  long/*uint64_t*/ Value = $int2ulong(0);
  if (!T.$arrow().isDependentType()) {
    Value = SemaExprCXXStatics.EvaluateArrayTypeTrait(/*Deref*/$this(), ATT, new QualType(T), DimExpr, new SourceLocation(KWLoc));
  }
  
  // While the specification for these traits from the Embarcadero C++
  // compiler's documentation says the return type is 'unsigned int', Clang
  // returns 'size_t'. On Windows, the primary platform for the Embarcadero
  // compiler, there is no difference. On several other platforms this is an
  // important distinction.
  final long L$Value = Value;
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ArrayTypeTraitExpr(new SourceLocation(KWLoc), ATT, TSInfo, L$Value, DimExpr, 
                  new SourceLocation(RParen), $this().Context.getSizeType().$QualType());
       }));
}


/// ActOnExpressionTrait - Parsed one of the unary type trait support
/// pseudo-functions.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnExpressionTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4739,
 FQN="clang::Sema::ActOnExpressionTrait", NM="_ZN5clang4Sema20ActOnExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema20ActOnExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnExpressionTrait(ExpressionTrait ET, 
                    SourceLocation KWLoc, 
                    Expr /*P*/ Queried, 
                    SourceLocation RParen) {
  // If error parsing the expression, ignore.
  if (!(Queried != null)) {
    return SemaClangGlobals.ExprError();
  }
  
  ActionResultTTrue<Expr /*P*/ > Result = $this().BuildExpressionTrait(ET, new SourceLocation(KWLoc), Queried, new SourceLocation(RParen));
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildExpressionTrait">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4760,
 FQN="clang::Sema::BuildExpressionTrait", NM="_ZN5clang4Sema20BuildExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema20BuildExpressionTraitENS_15ExpressionTraitENS_14SourceLocationEPNS_4ExprES2_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildExpressionTrait(ExpressionTrait ET, 
                    SourceLocation KWLoc, 
                    Expr /*P*/ Queried, 
                    SourceLocation RParen) {
  if (Queried.isTypeDependent()) {
    // Delay type-checking for type-dependent expressions.
  } else if (Queried.getType().$arrow().isPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > PE = $this().CheckPlaceholderExpr(Queried);
    if (PE.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    return $this().BuildExpressionTrait(ET, new SourceLocation(KWLoc), PE.get(), new SourceLocation(RParen));
  }
  
  boolean Value = SemaExprCXXStatics.EvaluateExpressionTrait(ET, Queried);
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
          return new ExpressionTraitExpr(new SourceLocation(KWLoc), ET, Queried, Value, new SourceLocation(RParen), $this().Context.BoolTy.$QualType());
       }));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnStartCXXMemberReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5907,
 FQN="clang::Sema::ActOnStartCXXMemberReference", NM="_ZN5clang4Sema28ActOnStartCXXMemberReferenceEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_9OpaquePtrINS_8QualTypeEEERb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema28ActOnStartCXXMemberReferenceEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_9OpaquePtrINS_8QualTypeEEERb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnStartCXXMemberReference(Scope /*P*/ S, Expr /*P*/ Base, 
                            SourceLocation OpLoc, 
                            /*tok.TokenKind*/char OpKind, 
                            final OpaquePtr<QualType> /*&*/ ObjectType, 
                            final bool$ref/*bool &*/ MayBePseudoDestructor) {
  // Since this might be a postfix expression, get rid of ParenListExprs.
  ActionResultTTrue<Expr /*P*/ > Result = $this().MaybeConvertParenListExprToParenExpr(S, Base);
  if (Result.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  Base = Result.get();
  
  Result.$assignMove($this().CheckPlaceholderExpr(Base));
  if (Result.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  Base = Result.get();
  
  QualType BaseType = Base.getType();
  MayBePseudoDestructor.$set(false);
  if (BaseType.$arrow().isDependentType()) {
    // If we have a pointer to a dependent type and are using the -> operator,
    // the object type is the type that the pointer points to. We might still
    // have enough information about that type to do something useful.
    if (OpKind == tok.TokenKind.arrow) {
      {
        /*const*/ PointerType /*P*/ Ptr = BaseType.$arrow().getAs(PointerType.class);
        if ((Ptr != null)) {
          BaseType.$assignMove(Ptr.getPointeeType());
        }
      }
    }
    
    ObjectType.$assignMove(OpaquePtr.<QualType>make(new QualType(BaseType)));
    MayBePseudoDestructor.$set(true);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Base);
  }
  
  // C++ [over.match.oper]p8:
  //   [...] When operator->returns, the operator-> is applied  to the value
  //   returned, with the original second operand.
  if (OpKind == tok.TokenKind.arrow) {
    QualType StartingType = new QualType(BaseType);
    bool$ptr NoArrowOperatorFound = create_bool$ptr(false);
    boolean FirstIteration = true;
    FunctionDecl /*P*/ CurFD = dyn_cast_FunctionDecl($this().CurContext);
    // The set of types we've considered so far.
    SmallPtrSet<CanQual<Type>> CTypes/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 8);
    SmallVector<FunctionDecl /*P*/ > OperatorArrows/*J*/= new SmallVector<FunctionDecl /*P*/ >(8, (FunctionDecl /*P*/ )null);
    CTypes.insert($this().Context.getCanonicalType(/*NO_COPY*/BaseType));
    while (BaseType.$arrow().isRecordType()) {
      if ($greatereq_uint(OperatorArrows.size(), $this().getLangOpts().ArrowDepth)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_operator_arrow_depth_exceeded)), 
                      StartingType), $this().getLangOpts().ArrowDepth), Base.getSourceRange()));
          SemaExprCXXStatics.noteOperatorArrows(/*Deref*/$this(), new ArrayRef<FunctionDecl /*P*/ >(OperatorArrows, true));
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_uint($c$.track($this().Diag(new SourceLocation(OpLoc), diag.note_operator_arrow_depth)), 
              $this().getLangOpts().ArrowDepth));
          return SemaClangGlobals.ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      
      Result.$assignMove($this().BuildOverloadedArrowExpr(S, Base, new SourceLocation(OpLoc), 
              // When in a template specialization and on the first loop iteration,
              // potentially give the default diagnostic (with the fixit in a
              // separate note) instead of having the error reported back to here
              // and giving a diagnostic with a fixit attached to the error itself.
              (FirstIteration && (CurFD != null) && CurFD.isFunctionTemplateSpecialization()) ? (bool$ptr/*bool P*/ )null : $AddrOf(NoArrowOperatorFound)));
      if (Result.isInvalid()) {
        if (NoArrowOperatorFound.$star()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            if (FirstIteration) {
              $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_suggestion)), 
                              BaseType), 1), Base.getSourceRange()), 
                  FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/OpLoc), new StringRef(/*KEEP_STR*/$DOT))));
              OpKind = tok.TokenKind.period;
              break;
            }
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_typecheck_member_reference_arrow)), 
                    BaseType), Base.getSourceRange()));
            CallExpr /*P*/ CE = dyn_cast_CallExpr(Base);
            {
              Decl /*P*/ CD = ((CE != null) ? CE.getCalleeDecl() : null);
              if ((CD != null)) {
                $c$.clean($c$.track($this().Diag(CD.getLocStart(), 
                    diag.note_member_reference_arrow_from_operator_arrow)));
              }
            }
          } finally {
            $c$.$destroy();
          }
        }
        return SemaClangGlobals.ExprError();
      }
      Base = Result.get();
      {
        CXXOperatorCallExpr /*P*/ OpCall = dyn_cast_CXXOperatorCallExpr(Base);
        if ((OpCall != null)) {
          OperatorArrows.push_back(OpCall.getDirectCallee());
        }
      }
      BaseType.$assignMove(Base.getType());
      CanQual<Type> CBaseType = $this().Context.getCanonicalType(/*NO_COPY*/BaseType);
      if (!CTypes.insert(new CanQual<Type>(CBaseType)).second) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_operator_arrow_circular)), StartingType));
          SemaExprCXXStatics.noteOperatorArrows(/*Deref*/$this(), new ArrayRef<FunctionDecl /*P*/ >(OperatorArrows, true));
          return SemaClangGlobals.ExprError();
        } finally {
          $c$.$destroy();
        }
      }
      FirstIteration = false;
    }
    if (OpKind == tok.TokenKind.arrow
       && (BaseType.$arrow().isPointerType() || BaseType.$arrow().isObjCObjectPointerType())) {
      BaseType.$assignMove(BaseType.$arrow().getPointeeType());
    }
  }
  
  // Objective-C properties allow "." access on Objective-C pointer types,
  // so adjust the base type to the object type itself.
  if (BaseType.$arrow().isObjCObjectPointerType()) {
    BaseType.$assignMove(BaseType.$arrow().getPointeeType());
  }
  
  // C++ [basic.lookup.classref]p2:
  //   [...] If the type of the object expression is of pointer to scalar
  //   type, the unqualified-id is looked up in the context of the complete
  //   postfix-expression.
  //
  // This also indicates that we could be parsing a pseudo-destructor-name.
  // Note that Objective-C class and object types can be pseudo-destructor
  // expressions or normal member (ivar or property) access expressions, and
  // it's legal for the type to be incomplete if this is a pseudo-destructor
  // call.  We'll do more incomplete-type checks later in the lookup process,
  // so just skip this check for ObjC types.
  if (BaseType.$arrow().isObjCObjectOrInterfaceType()) {
    ObjectType.$assignMove(OpaquePtr.<QualType>make(new QualType(BaseType)));
    MayBePseudoDestructor.$set(true);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Base);
  } else if (!BaseType.$arrow().isRecordType()) {
    ObjectType.$assignMove(new OpaquePtr<QualType>(null));
    MayBePseudoDestructor.$set(true);
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Base);
  }
  
  // The object type must be complete (or dependent), or
  // C++11 [expr.prim.general]p3:
  //   Unlike the object expression in other contexts, *this is not required to
  //   be of complete type for purposes of class member access (5.2.5) outside 
  //   the member function body.
  if (!BaseType.$arrow().isDependentType()
     && !$this().isThisOutsideMemberFunctionBody(new QualType(BaseType))
     && $this().RequireCompleteType(new SourceLocation(OpLoc), new QualType(BaseType), diag.err_incomplete_member_access)) {
    return SemaClangGlobals.ExprError();
  }
  
  // C++ [basic.lookup.classref]p2:
  //   If the id-expression in a class member access (5.2.5) is an
  //   unqualified-id, and the type of the object expression is of a class
  //   type C (or of pointer to a class type C), the unqualified-id is looked
  //   up in the scope of class C. [...]
  ObjectType.$assignMove(OpaquePtr.<QualType>make(new QualType(BaseType)));
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Base);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildPseudoDestructorExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6083,
 FQN="clang::Sema::BuildPseudoDestructorExpr", NM="_ZN5clang4Sema25BuildPseudoDestructorExprEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERKNS_12CXXScopeSpecEPNS_14TypeSourceInfoES3_S3_NS_27PseudoDestructorTypeStorageE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25BuildPseudoDestructorExprEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERKNS_12CXXScopeSpecEPNS_14TypeSourceInfoES3_S3_NS_27PseudoDestructorTypeStorageE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildPseudoDestructorExpr(Expr /*P*/ _Base, 
                         SourceLocation OpLoc, 
                         /*tok.TokenKind*/char _OpKind, 
                         final /*const*/ CXXScopeSpec /*&*/ SS, 
                         TypeSourceInfo /*P*/ ScopeTypeInfo, 
                         SourceLocation CCLoc, 
                         SourceLocation TildeLoc, 
                         PseudoDestructorTypeStorage Destructed) {
  type$ref<Expr /*P*/> Base = create_type$ref(_Base);
  ushort$ref OpKind = create_ushort$ref(_OpKind);
  TypeSourceInfo /*P*/ DestructedTypeInfo = Destructed.getTypeSourceInfo();
  
  QualType ObjectType/*J*/= new QualType();
  if (SemaExprCXXStatics.CheckArrow(/*Deref*/$this(), ObjectType, Base, OpKind, new SourceLocation(OpLoc))) {
    return SemaClangGlobals.ExprError();
  }
  if (!ObjectType.$arrow().isDependentType() && !ObjectType.$arrow().isScalarType()
     && !ObjectType.$arrow().isVectorType()) {
    if ($this().getLangOpts().MSVCCompat && ObjectType.$arrow().isVoidType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(new SourceLocation(OpLoc), diag.ext_pseudo_dtor_on_void)), Base.$deref().getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(OpLoc), diag.err_pseudo_dtor_base_not_scalar)), 
                ObjectType), Base.$deref().getSourceRange()));
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // C++ [expr.pseudo]p2:
  //   [...] The cv-unqualified versions of the object type and of the type
  //   designated by the pseudo-destructor-name shall be the same type.
  if ((DestructedTypeInfo != null)) {
    QualType DestructedType = DestructedTypeInfo.getType();
    SourceLocation DestructedTypeStart = DestructedTypeInfo.getTypeLoc().getLocalSourceRange().getBegin();
    if (!DestructedType.$arrow().isDependentType() && !ObjectType.$arrow().isDependentType()) {
      if (!$this().Context.hasSameUnqualifiedType(new QualType(DestructedType), new QualType(ObjectType))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(DestructedTypeStart), diag.err_pseudo_dtor_type_mismatch)), 
                          ObjectType), DestructedType), Base.$deref().getSourceRange()), 
              DestructedTypeInfo.getTypeLoc().getLocalSourceRange()));
          
          // Recover by setting the destructed type to the object type.
          DestructedType.$assign(ObjectType);
          DestructedTypeInfo = $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/ObjectType, 
              /*NO_COPY*/DestructedTypeStart);
          Destructed.$assignMove(new PseudoDestructorTypeStorage(DestructedTypeInfo));
        } finally {
          $c$.$destroy();
        }
      } else if (DestructedType.getObjCLifetime()
         != ObjectType.getObjCLifetime()) {
        if (DestructedType.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None) {
          // Okay: just pretend that the user provided the correctly-qualified
          // type.
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(DestructedTypeStart), diag.err_arc_pseudo_dtor_inconstant_quals)), 
                            ObjectType), DestructedType), Base.$deref().getSourceRange()), 
                DestructedTypeInfo.getTypeLoc().getLocalSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        
        // Recover by setting the destructed type to the object type.
        DestructedType.$assign(ObjectType);
        DestructedTypeInfo = $this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/ObjectType, 
            /*NO_COPY*/DestructedTypeStart);
        Destructed.$assignMove(new PseudoDestructorTypeStorage(DestructedTypeInfo));
      }
    }
  }
  
  // C++ [expr.pseudo]p2:
  //   [...] Furthermore, the two type-names in a pseudo-destructor-name of the
  //   form
  //
  //     ::[opt] nested-name-specifier[opt] type-name :: ~ type-name
  //
  //   shall designate the same scalar type.
  if ((ScopeTypeInfo != null)) {
    QualType ScopeType = ScopeTypeInfo.getType();
    if (!ScopeType.$arrow().isDependentType() && !ObjectType.$arrow().isDependentType()
       && !$this().Context.hasSameUnqualifiedType(new QualType(ScopeType), new QualType(ObjectType))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(ScopeTypeInfo.getTypeLoc().getLocalSourceRange().getBegin(), 
                            diag.err_pseudo_dtor_type_mismatch)), 
                        ObjectType), ScopeType), Base.$deref().getSourceRange()), 
            ScopeTypeInfo.getTypeLoc().getLocalSourceRange()));
        
        ScopeType.$assignMove(new QualType());
        ScopeTypeInfo = null;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  final TypeSourceInfo /*P*/ L$ScopeTypeInfo = ScopeTypeInfo;
  Expr /*P*/ Result = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CXXPseudoDestructorExpr($this().Context, Base.$deref(), 
              OpKind.$deref() == tok.TokenKind.arrow, new SourceLocation(OpLoc), 
              SS.getWithLocInContext($this().Context), 
              L$ScopeTypeInfo, 
              new SourceLocation(CCLoc), 
              new SourceLocation(TildeLoc), 
              new PseudoDestructorTypeStorage(Destructed));
   });
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, Result);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPseudoDestructorExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6181,
 FQN="clang::Sema::ActOnPseudoDestructorExpr", NM="_ZN5clang4Sema25ActOnPseudoDestructorExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecERNS_13UnqualifiedIdES5_S5_SB_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25ActOnPseudoDestructorExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindERNS_12CXXScopeSpecERNS_13UnqualifiedIdES5_S5_SB_")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnPseudoDestructorExpr(Scope /*P*/ S, Expr /*P*/ _Base, 
                         SourceLocation OpLoc, 
                         /*tok.TokenKind*/char _OpKind, 
                         final CXXScopeSpec /*&*/ SS, 
                         final UnqualifiedId /*&*/ FirstTypeName, 
                         SourceLocation CCLoc, 
                         SourceLocation TildeLoc, 
                         final UnqualifiedId /*&*/ SecondTypeName) {
  type$ref<Expr /*P*/> Base = create_type$ref(_Base);
  ushort$ref OpKind = create_ushort$ref(_OpKind);
  assert ((FirstTypeName.getKind() == UnqualifiedId.IdKind.IK_TemplateId || FirstTypeName.getKind() == UnqualifiedId.IdKind.IK_Identifier)) : "Invalid first type name in pseudo-destructor";
  assert ((SecondTypeName.getKind() == UnqualifiedId.IdKind.IK_TemplateId || SecondTypeName.getKind() == UnqualifiedId.IdKind.IK_Identifier)) : "Invalid second type name in pseudo-destructor";
  
  QualType ObjectType/*J*/= new QualType();
  if (SemaExprCXXStatics.CheckArrow(/*Deref*/$this(), ObjectType, Base, OpKind, new SourceLocation(OpLoc))) {
    return SemaClangGlobals.ExprError();
  }
  
  // Compute the object type that we should use for name lookup purposes. Only
  // record types and dependent types matter.
  OpaquePtr<QualType> ObjectTypePtrForLookup/*J*/= new OpaquePtr<QualType>();
  if (!SS.isSet()) {
    if (ObjectType.$arrow().isRecordType()) {
      ObjectTypePtrForLookup.$assignMove(OpaquePtr.<QualType>make(new QualType(ObjectType)));
    } else if (ObjectType.$arrow().isDependentType()) {
      ObjectTypePtrForLookup.$assignMove(OpaquePtr.<QualType>make($this().Context.DependentTy.$QualType()));
    }
  }
  
  // Convert the name of the type being destructed (following the ~) into a
  // type (with source-location information).
  QualType DestructedType/*J*/= new QualType();
  type$ptr<TypeSourceInfo /*P*/ > DestructedTypeInfo = create_type$null$ptr(null);
  PseudoDestructorTypeStorage Destructed/*J*/= new PseudoDestructorTypeStorage();
  if (SecondTypeName.getKind() == UnqualifiedId.IdKind.IK_Identifier) {
    OpaquePtr<QualType> T = $this().getTypeName($Deref(SecondTypeName.Unnamed_field1.Identifier), 
        new SourceLocation(SecondTypeName.StartLocation), 
        S, $AddrOf(SS), true, false, new OpaquePtr<QualType>(ObjectTypePtrForLookup));
    if (!T.$bool()
       && ((SS.isSet() && !($this().computeDeclContext(SS, false) != null))
       || (!SS.isSet() && ObjectType.$arrow().isDependentType()))) {
      // The name of the type being destroyed is a dependent name, and we
      // couldn't find anything useful in scope. Just store the identifier and
      // it's location, and we'll perform (qualified) name lookup again at
      // template instantiation time.
      Destructed.$assignMove(new PseudoDestructorTypeStorage(SecondTypeName.Unnamed_field1.Identifier, 
              new SourceLocation(SecondTypeName.StartLocation)));
    } else if (!T.$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(SecondTypeName.StartLocation), 
                    diag.err_pseudo_dtor_destructor_non_type)), 
                SecondTypeName.Unnamed_field1.Identifier), ObjectType));
        if ($this().isSFINAEContext().$bool()) {
          return SemaClangGlobals.ExprError();
        }
        
        // Recover by assuming we had the right type all along.
        DestructedType.$assign(ObjectType);
      } finally {
        $c$.$destroy();
      }
    } else {
      DestructedType.$assignMove(GetTypeFromParser(new OpaquePtr<QualType>(T), $AddrOf(DestructedTypeInfo)));
    }
  } else {
    // Resolve the template-id to a type.
    TemplateIdAnnotation /*P*/ TemplateId = SecondTypeName.Unnamed_field1.TemplateId;
    MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
        TemplateId.NumArgs, false);
    ActionResult<OpaquePtr<QualType> > T = $this().ActOnTemplateIdType(TemplateId.SS, 
        new SourceLocation(TemplateId.TemplateKWLoc), 
        new OpaquePtr<TemplateName>(TemplateId.Template), 
        new SourceLocation(TemplateId.TemplateNameLoc), 
        new SourceLocation(TemplateId.LAngleLoc), 
        new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
        new SourceLocation(TemplateId.RAngleLoc));
    if (T.isInvalid() || !T.get().$bool()) {
      // Recover by assuming we had the right type all along.
      DestructedType.$assign(ObjectType);
    } else {
      DestructedType.$assignMove(GetTypeFromParser(T.get(), $AddrOf(DestructedTypeInfo)));
    }
  }
  
  // If we've performed some kind of recovery, (re-)build the type source
  // information.
  if (!DestructedType.isNull()) {
    if (!(DestructedTypeInfo.$star() != null)) {
      DestructedTypeInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/DestructedType, 
          /*NO_COPY*/SecondTypeName.StartLocation));
    }
    Destructed.$assignMove(new PseudoDestructorTypeStorage(DestructedTypeInfo.$star()));
  }
  
  // Convert the name of the scope type (the type prior to '::') into a type.
  type$ptr<TypeSourceInfo /*P*/ > ScopeTypeInfo = create_type$null$ptr(null);
  QualType ScopeType/*J*/= new QualType();
  if (FirstTypeName.getKind() == UnqualifiedId.IdKind.IK_TemplateId
     || (FirstTypeName.Unnamed_field1.Identifier != null)) {
    if (FirstTypeName.getKind() == UnqualifiedId.IdKind.IK_Identifier) {
      OpaquePtr<QualType> T = $this().getTypeName($Deref(FirstTypeName.Unnamed_field1.Identifier), 
          new SourceLocation(FirstTypeName.StartLocation), 
          S, $AddrOf(SS), true, false, new OpaquePtr<QualType>(ObjectTypePtrForLookup));
      if (!T.$bool()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_II($c$.track($this().Diag(new SourceLocation(FirstTypeName.StartLocation), 
                      diag.err_pseudo_dtor_destructor_non_type)), 
                  FirstTypeName.Unnamed_field1.Identifier), ObjectType));
          if ($this().isSFINAEContext().$bool()) {
            return SemaClangGlobals.ExprError();
          }
          
          // Just drop this type. It's unnecessary anyway.
          ScopeType.$assignMove(new QualType());
        } finally {
          $c$.$destroy();
        }
      } else {
        ScopeType.$assignMove(GetTypeFromParser(new OpaquePtr<QualType>(T), $AddrOf(ScopeTypeInfo)));
      }
    } else {
      // Resolve the template-id to a type.
      TemplateIdAnnotation /*P*/ TemplateId = FirstTypeName.Unnamed_field1.TemplateId;
      MutableArrayRef<ParsedTemplateArgument> TemplateArgsPtr/*J*/= new MutableArrayRef<ParsedTemplateArgument>(TemplateId.getTemplateArgs(), 
          TemplateId.NumArgs, false);
      ActionResult<OpaquePtr<QualType> > T = $this().ActOnTemplateIdType(TemplateId.SS, 
          new SourceLocation(TemplateId.TemplateKWLoc), 
          new OpaquePtr<TemplateName>(TemplateId.Template), 
          new SourceLocation(TemplateId.TemplateNameLoc), 
          new SourceLocation(TemplateId.LAngleLoc), 
          new MutableArrayRef<ParsedTemplateArgument>(TemplateArgsPtr), 
          new SourceLocation(TemplateId.RAngleLoc));
      if (T.isInvalid() || !T.get().$bool()) {
        // Recover by dropping this type.
        ScopeType.$assignMove(new QualType());
      } else {
        ScopeType.$assignMove(GetTypeFromParser(T.get(), $AddrOf(ScopeTypeInfo)));
      }
    }
  }
  if (!ScopeType.isNull() && !(ScopeTypeInfo.$star() != null)) {
    ScopeTypeInfo.$set($this().Context.getTrivialTypeSourceInfo(/*NO_COPY*/ScopeType, 
        /*NO_COPY*/FirstTypeName.StartLocation));
  }
  
  return $this().BuildPseudoDestructorExpr(Base.$deref(), new SourceLocation(OpLoc), OpKind.$deref(), SS, 
      ScopeTypeInfo.$star(), new SourceLocation(CCLoc), new SourceLocation(TildeLoc), 
      new PseudoDestructorTypeStorage(Destructed));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnPseudoDestructorExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6318,
 FQN="clang::Sema::ActOnPseudoDestructorExpr", NM="_ZN5clang4Sema25ActOnPseudoDestructorExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindES5_RKNS_8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25ActOnPseudoDestructorExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationENS_3tok9TokenKindES5_RKNS_8DeclSpecE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnPseudoDestructorExpr(Scope /*P*/ S, Expr /*P*/ _Base, 
                         SourceLocation OpLoc, 
                         /*tok.TokenKind*/char _OpKind, 
                         SourceLocation TildeLoc, 
                         final /*const*/ DeclSpec /*&*/ DS) {
  type$ref<Expr /*P*/> Base = create_type$ref(_Base);
  ushort$ref OpKind = create_ushort$ref(_OpKind);
  TypeLocBuilder TLB = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    QualType ObjectType/*J*/= new QualType();
    if (SemaExprCXXStatics.CheckArrow(/*Deref*/$this(), ObjectType, Base, OpKind, new SourceLocation(OpLoc))) {
      return SemaClangGlobals.ExprError();
    }
    
    QualType T = $this().BuildDecltypeType(DS.getRepAsExpr(), DS.getTypeSpecTypeLoc(), 
        false);
    
    TLB/*J*/= new TypeLocBuilder();
    DecltypeTypeLoc DecltypeTL = TLB.push(DecltypeTypeLoc.class, new QualType(T));
    DecltypeTL.setNameLoc(DS.getTypeSpecTypeLoc());
    TypeSourceInfo /*P*/ DestructedTypeInfo = TLB.getTypeSourceInfo($this().Context, new QualType(T));
    PseudoDestructorTypeStorage Destructed/*J*/= new PseudoDestructorTypeStorage(DestructedTypeInfo);
    
    return $c$.clean($this().BuildPseudoDestructorExpr(Base.$deref(), new SourceLocation(OpLoc), OpKind.$deref(), $c$.track(new CXXScopeSpec()), 
        (TypeSourceInfo /*P*/ )null, new SourceLocation(), new SourceLocation(TildeLoc), 
        new PseudoDestructorTypeStorage(Destructed)));
  } finally {
    if (TLB != null) { TLB.$destroy(); }
    $c$.$destroy();
  }
}


/// MaybeCreateExprWithCleanups - If the current full-expression
/// requires any cleanups, surround it with a ExprWithCleanups node.
/// Otherwise, just returns the passed-in expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::MaybeCreateExprWithCleanups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5741,
 FQN="clang::Sema::MaybeCreateExprWithCleanups", NM="_ZN5clang4Sema27MaybeCreateExprWithCleanupsEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema27MaybeCreateExprWithCleanupsEPNS_4ExprE")
//</editor-fold>
public final Expr /*P*/ MaybeCreateExprWithCleanups(Expr /*P*/ SubExpr) {
  assert ((SubExpr != null)) : "subexpression can't be null!";
  
  $this().CleanupVarDeclMarking();
  
  /*uint*/int FirstCleanup = $this().ExprEvalContexts.back().NumCleanupObjects;
  assert ($greatereq_uint($this().ExprCleanupObjects.size(), FirstCleanup));
  assert ($this().Cleanup.exprNeedsCleanups() || $this().ExprCleanupObjects.size() == FirstCleanup);
  if (!$this().Cleanup.exprNeedsCleanups()) {
    return SubExpr;
  }
  
  ArrayRef<BlockDecl /*P*/ > Cleanups = llvm.makeArrayRef($this().ExprCleanupObjects.begin().$add(FirstCleanup), 
      $this().ExprCleanupObjects.size() - FirstCleanup, true);
  
  ExprWithCleanups /*P*/ E = ExprWithCleanups.Create($this().Context, SubExpr, $this().Cleanup.cleanupsHaveSideEffects(), new ArrayRef<BlockDecl /*P*/ >(Cleanups));
  $this().DiscardCleanupsInEvaluationContext();
  
  return E;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::MaybeCreateStmtWithCleanups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5763,
 FQN="clang::Sema::MaybeCreateStmtWithCleanups", NM="_ZN5clang4Sema27MaybeCreateStmtWithCleanupsEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema27MaybeCreateStmtWithCleanupsEPNS_4StmtE")
//</editor-fold>
public final Stmt /*P*/ MaybeCreateStmtWithCleanups(Stmt /*P*/ SubStmt) {
  assert ((SubStmt != null)) : "sub-statement can't be null!";
  
  $this().CleanupVarDeclMarking();
  if (!$this().Cleanup.exprNeedsCleanups()) {
    return SubStmt;
  }
  
  // FIXME: In order to attach the temporaries, wrap the statement into
  // a StmtExpr; currently this is only used for asm statements.
  // This is hacky, either create a new CXXStmtWithTemporaries statement or
  // a new AsmStmtWithTemporaries.
  CompoundStmt /*P*/ CompStmt = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CompoundStmt($this().Context, new ArrayRef<Stmt /*P*/ >(SubStmt, true), 
              new SourceLocation(), 
              new SourceLocation());
   });
  Expr /*P*/ E = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new StmtExpr(CompStmt, $this().Context.VoidTy.$QualType(), new SourceLocation(), 
              new SourceLocation());
   });
  return $this().MaybeCreateExprWithCleanups(E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::MaybeCreateExprWithCleanups">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5733,
 FQN="clang::Sema::MaybeCreateExprWithCleanups", NM="_ZN5clang4Sema27MaybeCreateExprWithCleanupsENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema27MaybeCreateExprWithCleanupsENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > MaybeCreateExprWithCleanups(ActionResultTTrue<Expr /*P*/ > SubExpr) {
  if (SubExpr.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, $this().MaybeCreateExprWithCleanups(SubExpr.get()));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishFullExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6972,
 FQN="clang::Sema::ActOnFinishFullExpr", NM="_ZN5clang4Sema19ActOnFinishFullExprEPNS_4ExprENS_14SourceLocationEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema19ActOnFinishFullExprEPNS_4ExprENS_14SourceLocationEbbb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnFinishFullExpr(Expr /*P*/ FE, SourceLocation CC) {
  return ActOnFinishFullExpr(FE, CC, 
                   false, 
                   false, 
                   false);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnFinishFullExpr(Expr /*P*/ FE, SourceLocation CC, 
                   boolean DiscardedValue/*= false*/) {
  return ActOnFinishFullExpr(FE, CC, 
                   DiscardedValue, 
                   false, 
                   false);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnFinishFullExpr(Expr /*P*/ FE, SourceLocation CC, 
                   boolean DiscardedValue/*= false*/, 
                   boolean IsConstexpr/*= false*/) {
  return ActOnFinishFullExpr(FE, CC, 
                   DiscardedValue, 
                   IsConstexpr, 
                   false);
}
public final ActionResultTTrue<Expr /*P*/ > ActOnFinishFullExpr(Expr /*P*/ FE, SourceLocation CC, 
                   boolean DiscardedValue/*= false*/, 
                   boolean IsConstexpr/*= false*/, 
                   boolean IsLambdaInitCaptureInitializer/*= false*/) {
  ActionResultTTrue<Expr /*P*/ > FullExpr = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, FE);
  if (!(FullExpr.get() != null)) {
    return SemaClangGlobals.ExprError();
  }
  
  // If we are an init-expression in a lambdas init-capture, we should not 
  // diagnose an unexpanded pack now (will be diagnosed once lambda-expr 
  // containing full-expression is done).
  // template<class ... Ts> void test(Ts ... t) {
  //   test([&a(t)]() { <-- (t) is an init-expr that shouldn't be diagnosed now.
  //     return a;
  //   }() ...);
  // }
  // FIXME: This is a hack. It would be better if we pushed the lambda scope
  // when we parse the lambda introducer, and teach capturing (but not
  // unexpanded pack detection) to walk over LambdaScopeInfos which don't have a
  // corresponding class yet (that is, have LambdaScopeInfo either represent a
  // lambda where we've entered the introducer but not the body, or represent a
  // lambda where we've entered the body, depending on where the
  // parser/instantiation has got to).
  if (!IsLambdaInitCaptureInitializer
     && $this().DiagnoseUnexpandedParameterPack(FullExpr.get())) {
    return SemaClangGlobals.ExprError();
  }
  
  // Top-level expressions default to 'id' when we're in a debugger.
  if (DiscardedValue && $this().getLangOpts().DebuggerCastResultToId
     && QualType.$eq_QualType$C(FullExpr.get().getType(), $this().Context.UnknownAnyTy.$QualType())) {
    FullExpr.$assignMove($this().forceUnknownAnyToType(FullExpr.get(), $this().Context.getObjCIdType()));
    if (FullExpr.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
  }
  if (DiscardedValue) {
    FullExpr.$assignMove($this().CheckPlaceholderExpr(FullExpr.get()));
    if (FullExpr.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
    
    FullExpr.$assignMove($this().IgnoredValueConversions(FullExpr.get()));
    if (FullExpr.isInvalid()) {
      return SemaClangGlobals.ExprError();
    }
  }
  
  FullExpr.$assignMove($this().CorrectDelayedTyposInExpr(FullExpr.get()));
  if (FullExpr.isInvalid()) {
    return SemaClangGlobals.ExprError();
  }
  
  $this().CheckCompletedExpr(FullExpr.get(), new SourceLocation(CC), IsConstexpr);
  
  // At the end of this full expression (which could be a deeply nested 
  // lambda), if there is a potential capture within the nested lambda, 
  // have the outer capture-able lambda try and capture it.
  // Consider the following code:
  // void f(int, int);
  // void f(const int&, double);
  // void foo() {   
  //  const int x = 10, y = 20;
  //  auto L = [=](auto a) {
  //      auto M = [=](auto b) {
  //         f(x, b); <-- requires x to be captured by L and M
  //         f(y, a); <-- requires y to be captured by L, but not all Ms
  //      };
  //   };
  // }
  
  // FIXME: Also consider what happens for something like this that involves 
  // the gnu-extension statement-expressions or even lambda-init-captures:   
  //   void f() {
  //     const int n = 0;
  //     auto L =  [&](auto a) {
  //       +n + ({ 0; a; });
  //     };
  //   }
  // 
  // Here, we see +n, and then the full-expression 0; ends, so we don't 
  // capture n (and instead remove it from our list of potential captures), 
  // and then the full-expression +n + ({ 0; }); ends, but it's too late 
  // for us to see that we need to capture n after all.
  LambdaScopeInfo /*P*/ /*const*/ CurrentLSI = $this().getCurLambda();
  // FIXME: PR 17877 showed that getCurLambda() can return a valid pointer 
  // even if CurContext is not a lambda call operator. Refer to that Bug Report
  // for an example of the code that might cause this asynchrony.  
  // By ensuring we are in the context of a lambda's call operator
  // we can fix the bug (we only need to check whether we need to capture
  // if we are within a lambda's body); but per the comments in that 
  // PR, a proper fix would entail :
  //   "Alternative suggestion:
  //   - Add to Sema an integer holding the smallest (outermost) scope 
  //     index that we are *lexically* within, and save/restore/set to 
  //     FunctionScopes.size() in InstantiatingTemplate's 
  //     constructor/destructor.
  //  - Teach the handful of places that iterate over FunctionScopes to 
  //    stop at the outermost enclosing lexical scope."
  /*const*/boolean IsInLambdaDeclContext = isLambdaCallOperator($this().CurContext);
  if (IsInLambdaDeclContext && (CurrentLSI != null)
     && CurrentLSI.hasPotentialCaptures() && !FullExpr.isInvalid()) {
    SemaExprCXXStatics.CheckIfAnyEnclosingLambdasMustCaptureAnyPotentialCaptures(FE, CurrentLSI, 
        /*Deref*/$this());
  }
  return $this().MaybeCreateExprWithCleanups(new ActionResultTTrue<Expr /*P*/ >(FullExpr));
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnFinishFullStmt">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 7077,
 FQN="clang::Sema::ActOnFinishFullStmt", NM="_ZN5clang4Sema19ActOnFinishFullStmtEPNS_4StmtE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema19ActOnFinishFullStmtEPNS_4StmtE")
//</editor-fold>
public final ActionResultTTrue<Stmt /*P*/ > ActOnFinishFullStmt(Stmt /*P*/ FullStmt) {
  if (!(FullStmt != null)) {
    return SemaClangGlobals.StmtError();
  }
  
  return new ActionResultTTrue<Stmt /*P*/ >(JD$T.INSTANCE, $this().MaybeCreateStmtWithCleanups(FullStmt));
}


/// Process the expression contained within a decltype. For such expressions,
/// certain semantic checks on temporaries are delayed until this point, and
/// are omitted for the 'topmost' call in the decltype expression. If the
/// topmost call bound a temporary, strip that temporary off the expression.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnDecltypeExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5787,
 FQN="clang::Sema::ActOnDecltypeExpression", NM="_ZN5clang4Sema23ActOnDecltypeExpressionEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema23ActOnDecltypeExpressionEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > ActOnDecltypeExpression(Expr /*P*/ E) {
  assert ($this().ExprEvalContexts.back().IsDecltype) : "not in a decltype expression";
  {
    
    // C++11 [expr.call]p11:
    //   If a function call is a prvalue of object type,
    // -- if the function call is either
    //   -- the operand of a decltype-specifier, or
    //   -- the right operand of a comma operator that is the operand of a
    //      decltype-specifier,
    //   a temporary object is not introduced for the prvalue.
    
    // Recursively rebuild ParenExprs and comma expressions to strip out the
    // outermost CXXBindTemporaryExpr, if any.
    ParenExpr /*P*/ PE = dyn_cast_ParenExpr(E);
    if ((PE != null)) {
      ActionResultTTrue<Expr /*P*/ > SubExpr = $this().ActOnDecltypeExpression(PE.getSubExpr());
      if (SubExpr.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      if (SubExpr.get() == PE.getSubExpr()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      return $this().ActOnParenExpr(PE.getLParen(), PE.getRParen(), SubExpr.get());
    }
  }
  {
    BinaryOperator /*P*/ BO = dyn_cast_BinaryOperator(E);
    if ((BO != null)) {
      if (BO.getOpcode() == BinaryOperatorKind.BO_Comma) {
        ActionResultTTrue<Expr /*P*/ > RHS = $this().ActOnDecltypeExpression(BO.getRHS());
        if (RHS.isInvalid()) {
          return SemaClangGlobals.ExprError();
        }
        if (RHS.get() == BO.getRHS()) {
          return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
        }
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
                return new BinaryOperator(BO.getLHS(), RHS.get(), BinaryOperatorKind.BO_Comma, BO.getType(), BO.getValueKind(), 
                        BO.getObjectKind(), BO.getOperatorLoc(), BO.isFPContractable());
             }));
      }
    }
  }
  
  CXXBindTemporaryExpr /*P*/ TopBind = dyn_cast_CXXBindTemporaryExpr(E);
  CallExpr /*P*/ TopCall = (TopBind != null) ? dyn_cast_CallExpr(TopBind.getSubExpr()) : null;
  if ((TopCall != null)) {
    E = TopCall;
  } else {
    TopBind = null;
  }
  
  // Disable the special decltype handling now.
  $this().ExprEvalContexts.back().IsDecltype = false;
  
  // In MS mode, don't perform any extra checking of call return types within a
  // decltype expression.
  if ($this().getLangOpts().MSVCCompat) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  
  // Perform the semantic checks we delayed until this point.
  for (/*uint*/int I = 0, N = $this().ExprEvalContexts.back().DelayedDecltypeCalls.size();
       I != N; ++I) {
    CallExpr /*P*/ Call = $this().ExprEvalContexts.back().DelayedDecltypeCalls.$at(I);
    if (Call == TopCall) {
      continue;
    }
    if ($this().CheckCallReturnType(Call.getCallReturnType($this().Context), 
        Call.getLocStart(), 
        Call, Call.getDirectCallee())) {
      return SemaClangGlobals.ExprError();
    }
  }
  
  // Now all relevant types are complete, check the destructors are accessible
  // and non-deleted, and annotate them on the temporaries.
  for (/*uint*/int I = 0, N = $this().ExprEvalContexts.back().DelayedDecltypeBinds.size();
       I != N; ++I) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      CXXBindTemporaryExpr /*P*/ Bind = $this().ExprEvalContexts.back().DelayedDecltypeBinds.$at(I);
      if (Bind == TopBind) {
        continue;
      }
      
      CXXTemporary /*P*/ Temp = Bind.getTemporary();
      
      CXXRecordDecl /*P*/ RD = Bind.getType().$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
      CXXDestructorDecl /*P*/ Destructor = $this().LookupDestructor(RD);
      Temp.setDestructor(Destructor);
      
      $this().MarkFunctionReferenced(Bind.getExprLoc(), Destructor);
      $c$.clean($this().CheckDestructorAccess(Bind.getExprLoc(), Destructor, 
          $out_PartialDiagnostic$C_QualType($c$.track($this().PDiag(diag.err_access_dtor_temp)), 
              Bind.getType())));
      if ($this().DiagnoseUseOfDecl(Destructor, Bind.getExprLoc())) {
        return SemaClangGlobals.ExprError();
      }
      
      // We need a cleanup, but we don't need to remember the temporary.
      $this().Cleanup.setExprNeedsCleanups(true);
    } finally {
      $c$.$destroy();
    }
  }
  
  // Possibly strip off the top CXXBindTemporaryExpr.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::BuildCXXMemberCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6341,
 FQN="clang::Sema::BuildCXXMemberCallExpr", NM="_ZN5clang4Sema22BuildCXXMemberCallExprEPNS_4ExprEPNS_9NamedDeclEPNS_17CXXConversionDeclEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22BuildCXXMemberCallExprEPNS_4ExprEPNS_9NamedDeclEPNS_17CXXConversionDeclEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > BuildCXXMemberCallExpr(Expr /*P*/ E, NamedDecl /*P*/ FoundDecl, 
                      CXXConversionDecl /*P*/ Method, 
                      boolean HadMultipleCandidates) {
  if (Method.getParent().isLambda()
     && Method.getConversionType().$arrow().isBlockPointerType()) {
    // This is a lambda coversion to block pointer; check if the argument
    // is a LambdaExpr.
    Expr /*P*/ SubE = E;
    CastExpr /*P*/ CE = dyn_cast_CastExpr(SubE);
    if ((CE != null) && CE.getCastKind() == CastKind.CK_NoOp) {
      SubE = CE.getSubExpr();
    }
    SubE = SubE.IgnoreParens();
    {
      CXXBindTemporaryExpr /*P*/ BE = dyn_cast_CXXBindTemporaryExpr(SubE);
      if ((BE != null)) {
        SubE = BE.getSubExpr();
      }
    }
    if (isa_LambdaExpr(SubE)) {
      // For the conversion to block pointer on a lambda expression, we
      // construct a special BlockLiteral instead; this doesn't really make
      // a difference in ARC, but outside of ARC the resulting block literal
      // follows the normal lifetime rules for block literals instead of being
      // autoreleased.
      DiagnosticErrorTrap Trap/*J*/= new DiagnosticErrorTrap($this().Diags);
      $this().PushExpressionEvaluationContext(ExpressionEvaluationContext.PotentiallyEvaluated);
      ActionResultTTrue<Expr /*P*/ > Exp = $this().BuildBlockForLambdaConversion(E.getExprLoc(), 
          E.getExprLoc(), 
          Method, E);
      $this().PopExpressionEvaluationContext();
      if (Exp.isInvalid()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track($this().Diag(E.getExprLoc(), diag.note_lambda_to_block_conv)));
        } finally {
          $c$.$destroy();
        }
      }
      return Exp;
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > Exp = $this().PerformObjectArgumentInitialization(E, /*Qualifier=*/ (NestedNameSpecifier /*P*/ )null, 
      FoundDecl, Method);
  if (Exp.isInvalid()) {
    return new ActionResultTTrue<Expr /*P*/ >(true);
  }
  
  MemberExpr /*P*/ ME = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new MemberExpr(Exp.get(), /*IsArrow=*/ false, new SourceLocation(), Method, new SourceLocation(), 
              $this().Context.BoundMemberTy.$QualType(), ExprValueKind.VK_RValue, ExprObjectKind.OK_Ordinary);
   });
  if (HadMultipleCandidates) {
    ME.setHadMultipleCandidates(true);
  }
  $this().MarkMemberReferenced(ME);
  
  QualType ResultType = Method.getReturnType();
  ExprValueKind VK = Expr.getValueKindForType(new QualType(ResultType));
  ResultType.$assignMove(ResultType.getNonLValueExprType($this().Context));
  
  CXXMemberCallExpr /*P*/ CE = /*NEW_EXPR [Stmt::new]*//*new (Context)*/ Stmt.$new_uint_ASTContext$C_uint($this().Context, (type$ptr<?> New$Mem)->{
      return new CXXMemberCallExpr($this().Context, ME, new ArrayRef<Expr /*P*/ >(None, true), new QualType(ResultType), VK, 
              Exp.get().getLocEnd());
   });
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CE);
}


/// IgnoredValueConversions - Given that an expression's result is
/// syntactically ignored, perform any conversions that are
/// required.

/// Perform the conversions required for an expression used in a
/// context that ignores the result.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IgnoredValueConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 6482,
 FQN="clang::Sema::IgnoredValueConversions", NM="_ZN5clang4Sema23IgnoredValueConversionsEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema23IgnoredValueConversionsEPNS_4ExprE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > IgnoredValueConversions(Expr /*P*/ E) {
  if (E.hasPlaceholderType()) {
    ActionResultTTrue<Expr /*P*/ > result = $this().CheckPlaceholderExpr(E);
    if (result.isInvalid()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
    }
    E = result.get();
  }
  
  // C99 6.3.2.1:
  //   [Except in specific positions,] an lvalue that does not have
  //   array type is converted to the value stored in the
  //   designated object (and is no longer an lvalue).
  if (E.isRValue()) {
    // In C, function designators (i.e. expressions of function type)
    // are r-values, but we still want to do function-to-pointer decay
    // on them.  This is both technically correct and convenient for
    // some clients.
    if (!$this().getLangOpts().CPlusPlus && E.getType().$arrow().isFunctionType()) {
      return $this().DefaultFunctionArrayConversion(E);
    }
    
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  if ($this().getLangOpts().CPlusPlus) {
    // The C++11 standard defines the notion of a discarded-value expression;
    // normally, we don't need to do anything to handle it, but if it is a
    // volatile lvalue with a special form, we perform an lvalue-to-rvalue
    // conversion.
    if ($this().getLangOpts().CPlusPlus11 && E.isGLValue()
       && E.getType().isVolatileQualified()
       && SemaExprCXXStatics.IsSpecialDiscardedValue(E)) {
      ActionResultTTrue<Expr /*P*/ > Res = $this().DefaultLvalueConversion(E);
      if (Res.isInvalid()) {
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
      E = Res.get();
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  {
    
    // GCC seems to also exclude expressions of incomplete enum type.
    /*const*/ EnumType /*P*/ T = E.getType().$arrow().getAs$EnumType();
    if ((T != null)) {
      if (!T.getDecl().isComplete()) {
        // FIXME: stupid workaround for a codegen bug!
        E = $this().ImpCastExprToType(E, $this().Context.VoidTy.$QualType(), CastKind.CK_ToVoid).get();
        return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
      }
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > Res = $this().DefaultFunctionArrayLvalueConversion(E);
  if (Res.isInvalid()) {
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
  }
  E = Res.get();
  if (!E.getType().$arrow().isVoidType()) {
    $this().RequireCompleteType(E.getExprLoc(), E.getType(), 
        diag.err_incomplete_type);
  }
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, E);
}


/// Helper function to determine whether this is the (deprecated) C++
/// conversion from a string literal to a pointer to non-const char or
/// non-const wchar_t (for narrow and wide string literals,
/// respectively).
//<editor-fold defaultstate="collapsed" desc="clang::Sema::IsStringLiteralToNonConstPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3133,
 FQN="clang::Sema::IsStringLiteralToNonConstPointerConversion", NM="_ZN5clang4Sema42IsStringLiteralToNonConstPointerConversionEPNS_4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema42IsStringLiteralToNonConstPointerConversionEPNS_4ExprENS_8QualTypeE")
//</editor-fold>
public final boolean IsStringLiteralToNonConstPointerConversion(Expr /*P*/ From, QualType ToType) {
  {
    // Look inside the implicit cast, if it exists.
    ImplicitCastExpr /*P*/ Cast = dyn_cast_ImplicitCastExpr(From);
    if ((Cast != null)) {
      From = Cast.getSubExpr();
    }
  }
  {
    
    // A string literal (2.13.4) that is not a wide string literal can
    // be converted to an rvalue of type "pointer to char"; a wide
    // string literal can be converted to an rvalue of type "pointer
    // to wchar_t" (C++ 4.2p2).
    StringLiteral /*P*/ StrLit = dyn_cast_StringLiteral(From.IgnoreParens());
    if ((StrLit != null)) {
      {
        /*const*/ PointerType /*P*/ ToPtrType = ToType.$arrow().getAs(PointerType.class);
        if ((ToPtrType != null)) {
          {
            /*const*/ BuiltinType /*P*/ ToPointeeType = ToPtrType.getPointeeType().$arrow().getAs$BuiltinType();
            if ((ToPointeeType != null)) {
              // This conversion is considered only when there is an
              // explicit appropriate pointer target type (C++ 4.2p2).
              if (!ToPtrType.getPointeeType().hasQualifiers()) {
                switch (StrLit.getKind()) {
                 case UTF8:
                 case UTF16:
                 case UTF32:
                  // We don't allow UTF literals to be implicitly converted
                  break;
                 case Ascii:
                  return (ToPointeeType.getKind() == BuiltinType.Kind.Char_U
                     || ToPointeeType.getKind() == BuiltinType.Kind.Char_S);
                 case Wide:
                  return $this().Context.typesAreCompatible($this().Context.getWideCharType(), 
                      new QualType(ToPointeeType, 0));
                }
              }
            }
          }
        }
      }
    }
  }
  
  return false;
}


/// PerformImplicitConversion - Perform an implicit conversion of the
/// expression From to the type ToType using the pre-computed implicit
/// conversion sequence ICS. Returns the converted
/// expression. Action is the kind of conversion we're performing,
/// used in the error message.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformImplicitConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3234,
 FQN="clang::Sema::PerformImplicitConversion", NM="_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeERKNS_26ImplicitConversionSequenceENS0_16AssignmentActionENS0_21CheckedConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeERKNS_26ImplicitConversionSequenceENS0_16AssignmentActionENS0_21CheckedConversionKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformImplicitConversion(Expr /*P*/ From, QualType ToType, 
                         final /*const*/ ImplicitConversionSequence /*&*/ ICS, 
                         AssignmentAction Action) {
  return PerformImplicitConversion(From, ToType, 
                         ICS, 
                         Action, 
                         CheckedConversionKind.CCK_ImplicitConversion);
}
public final ActionResultTTrue<Expr /*P*/ > PerformImplicitConversion(Expr /*P*/ From, QualType ToType, 
                         final /*const*/ ImplicitConversionSequence /*&*/ ICS, 
                         AssignmentAction Action, 
                         CheckedConversionKind CCK/*= CCK_ImplicitConversion*/) {
  switch (ICS.getKind()) {
   case StandardConversion:
    {
      ActionResultTTrue<Expr /*P*/ > Res = $this().PerformImplicitConversion(From, new QualType(ToType), ICS.Unnamed_field2.Standard, 
          Action, CCK);
      if (Res.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      From = Res.get();
      break;
    }
   case UserDefinedConversion:
    {
      
      FunctionDecl /*P*/ FD = ICS.Unnamed_field2.UserDefined.ConversionFunction;
      CastKind $CastKind;
      QualType BeforeToType/*J*/= new QualType();
      assert ((FD != null)) : "no conversion function for user-defined conversion seq";
      {
        /*const*/ CXXConversionDecl /*P*/ Conv = dyn_cast_CXXConversionDecl(FD);
        if ((Conv != null)) {
          $CastKind = CastKind.CK_UserDefinedConversion;
          
          // If the user-defined conversion is specified by a conversion function,
          // the initial standard conversion sequence converts the source type to
          // the implicit object parameter of the conversion function.
          BeforeToType.$assignMove($this().Context.getTagDeclType(Conv.getParent$Const()));
        } else {
          /*const*/ CXXConstructorDecl /*P*/ Ctor = cast_CXXConstructorDecl(FD);
          $CastKind = CastKind.CK_ConstructorConversion;
          // Do no conversion if dealing with ... for the first conversion.
          if (!ICS.Unnamed_field2.UserDefined.EllipsisConversion) {
            // If the user-defined conversion is specified by a constructor, the
            // initial standard conversion sequence converts the source type to
            // the type required by the argument of the constructor
            BeforeToType.$assignMove(Ctor.getParamDecl$Const(0).getType().getNonReferenceType());
          }
        }
      }
      // Watch out for ellipsis conversion.
      if (!ICS.Unnamed_field2.UserDefined.EllipsisConversion) {
        ActionResultTTrue<Expr /*P*/ > Res = $this().PerformImplicitConversion(From, new QualType(BeforeToType), 
            ICS.Unnamed_field2.UserDefined.Before, AssignmentAction.AA_Converting, 
            CCK);
        if (Res.isInvalid()) {
          return SemaClangGlobals.ExprError();
        }
        From = Res.get();
      }
      
      ActionResultTTrue<Expr /*P*/ > CastArg = SemaExprCXXStatics.BuildCXXCastArgument(/*Deref*/$this(), 
          From.getLocStart(), 
          ToType.getNonReferenceType(), 
          $CastKind, cast_CXXMethodDecl(FD), 
          new DeclAccessPair(ICS.Unnamed_field2.UserDefined.FoundConversionFunction), 
          ICS.Unnamed_field2.UserDefined.HadMultipleCandidates, 
          From);
      if (CastArg.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      
      From = CastArg.get();
      
      return $this().PerformImplicitConversion(From, new QualType(ToType), ICS.Unnamed_field2.UserDefined.After, 
          AssignmentAction.AA_Converting, CCK);
    }
   case AmbiguousConversion:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        ICS.DiagnoseAmbiguousConversion(/*Deref*/$this(), From.getExprLoc(), 
            PartialDiagnostic.$out_PartialDiagnostic$C_SourceRange($c$.track($this().PDiag(diag.err_typecheck_ambiguous_condition)), 
                From.getSourceRange())); $c$.clean();
        return SemaClangGlobals.ExprError();
      } finally {
        $c$.$destroy();
      }
    }
   case EllipsisConversion:
    throw new llvm_unreachable("Cannot perform an ellipsis conversion");
   case BadConversion:
    return SemaClangGlobals.ExprError();
  }
  
  // Everything went well.
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
}


/// PerformImplicitConversion - Perform an implicit conversion of the
/// expression From to the type ToType by following the standard
/// conversion sequence SCS. Returns the converted
/// expression. Flavor is the context in which we're performing this
/// conversion, for use in error messages.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::PerformImplicitConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3324,
 FQN="clang::Sema::PerformImplicitConversion", NM="_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeERKNS_26StandardConversionSequenceENS0_16AssignmentActionENS0_21CheckedConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25PerformImplicitConversionEPNS_4ExprENS_8QualTypeERKNS_26StandardConversionSequenceENS0_16AssignmentActionENS0_21CheckedConversionKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > PerformImplicitConversion(Expr /*P*/ _From, QualType ToType, 
                         final /*const*/ StandardConversionSequence /*&*/ SCS, 
                         AssignmentAction Action, 
                         CheckedConversionKind CCK) {
  type$ref<Expr /*P*/ > From = create_type$ref(_From);
  boolean CStyle = (CCK == CheckedConversionKind.CCK_CStyleCast || CCK == CheckedConversionKind.CCK_FunctionalCast);
  
  // Overall FIXME: we are recomputing too many types here and doing far too
  // much extra work. What this means is that we need to keep track of more
  // information that is computed when we try the implicit conversion initially,
  // so that we don't need to recompute anything here.
  QualType FromType = From.$deref().getType();
  if ((SCS.CopyConstructor != null)) {
    // FIXME: When can ToType be a reference type?
    assert (!ToType.$arrow().isReferenceType());
    if (SCS.Second == ImplicitConversionKind.ICK_Derived_To_Base) {
      SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
      if ($this().CompleteConstructorCall(cast_CXXConstructorDecl(SCS.CopyConstructor), 
          new MutableArrayRef<Expr /*P*/ >(From.$deref(), true), /*FIXME:ConstructLoc*/ new SourceLocation(), 
          ConstructorArgs)) {
        return SemaClangGlobals.ExprError();
      }
      return $this().BuildCXXConstructExpr(/*FIXME:ConstructLoc*/ new SourceLocation(), new QualType(ToType), 
          SCS.FoundCopyConstructor.$NamedDecl$P(), SCS.CopyConstructor, 
          new MutableArrayRef<Expr /*P*/ >(ConstructorArgs, true), /*HadMultipleCandidates*/ false, 
          /*ListInit*/ false, /*StdInitListInit*/ false, /*ZeroInit*/ false, 
          CXXConstructExpr.ConstructionKind.CK_Complete.getValue(), new SourceRange());
    }
    return $this().BuildCXXConstructExpr(/*FIXME:ConstructLoc*/ new SourceLocation(), new QualType(ToType), 
        SCS.FoundCopyConstructor.$NamedDecl$P(), SCS.CopyConstructor, 
        new MutableArrayRef<Expr /*P*/ >(From.$deref(), true), /*HadMultipleCandidates*/ false, 
        /*ListInit*/ false, /*StdInitListInit*/ false, /*ZeroInit*/ false, 
        CXXConstructExpr.ConstructionKind.CK_Complete.getValue(), new SourceRange());
  }
  
  // Resolve overloaded function references.
  if ($this().Context.hasSameType(new QualType(FromType), $this().Context.OverloadTy.$QualType())) {
    DeclAccessPair Found/*J*/= new DeclAccessPair();
    FunctionDecl /*P*/ Fn = $this().ResolveAddressOfOverloadedFunction(From.$deref(), new QualType(ToType), 
        true, Found);
    if (!(Fn != null)) {
      return SemaClangGlobals.ExprError();
    }
    if ($this().DiagnoseUseOfDecl(Fn, From.$deref().getLocStart())) {
      return SemaClangGlobals.ExprError();
    }
    
    From.$set($this().FixOverloadedFunctionReference(From.$deref(), new DeclAccessPair(Found), Fn));
    FromType.$assignMove(From.$deref().getType());
  }
  
  // If we're converting to an atomic type, first convert to the corresponding
  // non-atomic type.
  QualType ToAtomicType/*J*/= new QualType();
  {
    /*const*/ AtomicType /*P*/ ToAtomic = ToType.$arrow().getAs(AtomicType.class);
    if ((ToAtomic != null)) {
      ToAtomicType.$assign(ToType);
      ToType.$assignMove(ToAtomic.getValueType());
    }
  }
  
  QualType InitialFromType = new QualType(FromType);
  // Perform the first implicit conversion.
  switch (SCS.First) {
   case ICK_Identity:
    {
      /*const*/ AtomicType /*P*/ FromAtomic = FromType.$arrow().getAs(AtomicType.class);
      if ((FromAtomic != null)) {
        FromType.$assignMove(FromAtomic.getValueType().getUnqualifiedType());
        From.$set(ImplicitCastExpr.Create($this().Context, new QualType(FromType), CastKind.CK_AtomicToNonAtomic, 
            From.$deref(), /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, ExprValueKind.VK_RValue));
      }
    }
    break;
   case ICK_Lvalue_To_Rvalue:
    {
      assert (From.$deref().getObjectKind() != ExprObjectKind.OK_ObjCProperty);
      ActionResultTTrue<Expr /*P*/ > FromRes = $this().DefaultLvalueConversion(From.$deref());
      assert (!FromRes.isInvalid()) : "Can't perform deduced conversion?!";
      From.$set(FromRes.get());
      FromType.$assignMove(From.$deref().getType());
      break;
    }
   case ICK_Array_To_Pointer:
    FromType.$assignMove($this().Context.getArrayDecayedType(new QualType(FromType)));
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(FromType), CastKind.CK_ArrayToPointerDecay, 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   case ICK_Function_To_Pointer:
    FromType.$assignMove($this().Context.getPointerType(/*NO_COPY*/FromType));
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(FromType), CastKind.CK_FunctionToPointerDecay, 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   default:
    throw new llvm_unreachable("Improper first standard conversion");
  }
  
  // Perform the second implicit conversion
  switch (SCS.Second) {
   case ICK_Identity:
    // C++ [except.spec]p5:
    //   [For] assignment to and initialization of pointers to functions,
    //   pointers to member functions, and references to functions: the
    //   target entity shall allow at least the exceptions allowed by the
    //   source value in the assignment or initialization.
    switch (Action) {
     case AA_Assigning:
     case AA_Initializing:
     case AA_Passing:
     case AA_Returning:
     case AA_Sending:
     case AA_Passing_CFAudited:
      // Note, function argument passing and returning are initialization.
      if ($this().CheckExceptionSpecCompatibility(From.$deref(), new QualType(ToType))) {
        return SemaClangGlobals.ExprError();
      }
      break;
     case AA_Casting:
     case AA_Converting:
      // Casts and implicit conversions are not initialization, so are not
      // checked for exception specification mismatches.
      break;
    }
    // Nothing else to do.
    break;
   case ICK_NoReturn_Adjustment:
    // If both sides are functions (or pointers/references to them), there could
    // be incompatible exception declarations.
    if ($this().CheckExceptionSpecCompatibility(From.$deref(), new QualType(ToType))) {
      return SemaClangGlobals.ExprError();
    }
    
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_NoOp, 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   case ICK_Integral_Promotion:
   case ICK_Integral_Conversion:
    if (ToType.$arrow().isBooleanType()) {
      assert (FromType.$arrow().castAs$EnumType().getDecl().isFixed() && SCS.Second == ImplicitConversionKind.ICK_Integral_Promotion) : "only enums with fixed underlying type can promote to bool";
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_IntegralToBoolean, 
          ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    } else {
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_IntegralCast, 
          ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    }
    break;
   case ICK_Floating_Promotion:
   case ICK_Floating_Conversion:
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_FloatingCast, 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   case ICK_Complex_Promotion:
   case ICK_Complex_Conversion:
    {
      QualType FromEl = From.$deref().getType().$arrow().getAs(ComplexType.class).getElementType();
      QualType ToEl = ToType.$arrow().getAs(ComplexType.class).getElementType();
      CastKind CK;
      if (FromEl.$arrow().isRealFloatingType()) {
        if (ToEl.$arrow().isRealFloatingType()) {
          CK = CastKind.CK_FloatingComplexCast;
        } else {
          CK = CastKind.CK_FloatingComplexToIntegralComplex;
        }
      } else if (ToEl.$arrow().isRealFloatingType()) {
        CK = CastKind.CK_IntegralComplexToFloatingComplex;
      } else {
        CK = CastKind.CK_IntegralComplexCast;
      }
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CK, 
          ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
      break;
    }
   case ICK_Floating_Integral:
    if (ToType.$arrow().isRealFloatingType()) {
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_IntegralToFloating, 
          ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    } else {
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_FloatingToIntegral, 
          ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    }
    break;
   case ICK_Compatible_Conversion:
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_NoOp, 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   case ICK_Writeback_Conversion:
   case ICK_Pointer_Conversion:
    {
      if (SCS.IncompatibleObjC && Action != AssignmentAction.AA_Casting) {
        // Diagnose incompatible Objective-C conversions
        if (Action == AssignmentAction.AA_Initializing || Action == AssignmentAction.AA_Assigning) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(From.$deref().getLocStart(), 
                                    diag.ext_typecheck_convert_incompatible_pointer)), 
                                ToType), From.$deref().getType()), Action), 
                    From.$deref().getSourceRange()), 0));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder$C_T$C$R(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(From.$deref().getLocStart(), 
                                    diag.ext_typecheck_convert_incompatible_pointer)), 
                                From.$deref().getType()), ToType), Action), 
                    From.$deref().getSourceRange()), 0));
          } finally {
            $c$.$destroy();
          }
        }
        if (From.$deref().getType().$arrow().isObjCObjectPointerType()
           && ToType.$arrow().isObjCObjectPointerType()) {
          $this().EmitRelatedResultTypeNote(From.$deref());
        }
      } else if ($this().getLangOpts().ObjCAutoRefCount
         && !$this().CheckObjCARCUnavailableWeakConversion(new QualType(ToType), 
          From.$deref().getType())) {
        if (Action == AssignmentAction.AA_Initializing) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean($c$.track($this().Diag(From.$deref().getLocStart(), 
                diag.err_arc_weak_unavailable_assign)));
          } finally {
            $c$.$destroy();
          }
        } else {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(From.$deref().getLocStart(), 
                                diag.err_arc_convesion_of_weak_unavailable)), 
                            (Action == AssignmentAction.AA_Casting)), From.$deref().getType()), ToType), 
                From.$deref().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
      }
      
      type$ref<CastKind> Kind = create_type$ref(CK_Invalid);
      SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      if ($this().CheckPointerConversion(From.$deref(), new QualType(ToType), Kind, BasePath, CStyle)) {
        return SemaClangGlobals.ExprError();
      }
      
      // Make sure we extend blocks if necessary.
      // FIXME: doing this here is really ugly.
      if (Kind.$deref() == CastKind.CK_BlockPointerToObjCPointerCast) {
        ActionResultTTrue<Expr /*P*/ > E = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From.$deref());
        /*J:(void)*/$this().PrepareCastToObjCObjectPointer(E);
        From.$set(E.get());
      }
      if ($this().getLangOpts().ObjCAutoRefCount) {
        $this().CheckObjCARCConversion(new SourceRange(), new QualType(ToType), From, CCK);
      }
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), Kind.$deref(), ExprValueKind.VK_RValue, $AddrOf(BasePath), CCK).
          get());
      break;
    }
   case ICK_Pointer_Member:
    {
      type$ref<CastKind> Kind = create_type$ref(CK_Invalid);
      SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      if ($this().CheckMemberPointerConversion(From.$deref(), new QualType(ToType), Kind, BasePath, CStyle)) {
        return SemaClangGlobals.ExprError();
      }
      if ($this().CheckExceptionSpecCompatibility(From.$deref(), new QualType(ToType))) {
        return SemaClangGlobals.ExprError();
      }
      
      // We may not have been able to figure out what this member pointer resolved
      // to up until this exact point.  Attempt to lock-in it's inheritance model.
      if ($this().Context.getTargetInfo().getCXXABI().isMicrosoft()) {
        /*J:(void)*/$this().isCompleteType(From.$deref().getExprLoc(), From.$deref().getType());
        /*J:(void)*/$this().isCompleteType(From.$deref().getExprLoc(), new QualType(ToType));
      }
      
      From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), Kind.$deref(), ExprValueKind.VK_RValue, $AddrOf(BasePath), CCK).
          get());
      break;
    }
   case ICK_Boolean_Conversion:
    // Perform half-to-boolean conversion via float.
    if (From.$deref().getType().$arrow().isHalfType()) {
      From.$set($this().ImpCastExprToType(From.$deref(), $this().Context.FloatTy.$QualType(), CastKind.CK_FloatingCast).get());
      FromType.$assignMove($this().Context.FloatTy.$QualType());
    }
    
    From.$set($this().ImpCastExprToType(From.$deref(), $this().Context.BoolTy.$QualType(), 
        ScalarTypeToBooleanCastKind(new QualType(FromType)), 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   case ICK_Derived_To_Base:
    {
      SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
      if ($this().CheckDerivedToBaseConversion(From.$deref().getType(), 
          ToType.getNonReferenceType(), 
          From.$deref().getLocStart(), 
          From.$deref().getSourceRange(), 
          $AddrOf(BasePath), 
          CStyle)) {
        return SemaClangGlobals.ExprError();
      }
      
      From.$set($this().ImpCastExprToType(From.$deref(), ToType.getNonReferenceType(), 
          CastKind.CK_DerivedToBase, From.$deref().getValueKind(), 
          $AddrOf(BasePath), CCK).get());
      break;
    }
   case ICK_Vector_Conversion:
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), CastKind.CK_BitCast, 
        ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
    break;
   case ICK_Vector_Splat:
    {
      // Vector splat from any arithmetic type to a vector.
      Expr /*P*/ Elem = $this().prepareVectorSplat(new QualType(ToType), From.$deref()).get();
      From.$set($this().ImpCastExprToType(Elem, new QualType(ToType), CastKind.CK_VectorSplat, ExprValueKind.VK_RValue, 
          /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
      break;
    }
   case ICK_Complex_Real:
    {
      // Case 1.  x -> _Complex y
      /*const*/ ComplexType /*P*/ ToComplex = ToType.$arrow().getAs(ComplexType.class);
      if ((ToComplex != null)) {
        QualType ElType = ToComplex.getElementType();
        boolean isFloatingComplex = ElType.$arrow().isRealFloatingType();
        
        // x -> y
        if ($this().Context.hasSameUnqualifiedType(new QualType(ElType), From.$deref().getType())) {
          // do nothing
        } else if (From.$deref().getType().$arrow().isRealFloatingType()) {
          From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ElType), 
              isFloatingComplex ? CastKind.CK_FloatingCast : CastKind.CK_FloatingToIntegral).get());
        } else {
          assert (From.$deref().getType().$arrow().isIntegerType());
          From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ElType), 
              isFloatingComplex ? CastKind.CK_IntegralToFloating : CastKind.CK_IntegralCast).get());
        }
        // y -> _Complex y
        From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), 
            isFloatingComplex ? CastKind.CK_FloatingRealToComplex : CastKind.CK_IntegralRealToComplex).get());
        // Case 2.  _Complex x -> y
      } else {
        /*const*/ ComplexType /*P*/ FromComplex = From.$deref().getType().$arrow().getAs(ComplexType.class);
        assert Native.$bool(FromComplex);
        
        QualType ElType = FromComplex.getElementType();
        boolean isFloatingComplex = ElType.$arrow().isRealFloatingType();
        
        // _Complex x -> x
        From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ElType), 
            isFloatingComplex ? CastKind.CK_FloatingComplexToReal : CastKind.CK_IntegralComplexToReal, 
            ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
        
        // x -> y
        if ($this().Context.hasSameUnqualifiedType(new QualType(ElType), new QualType(ToType))) {
          // do nothing
        } else if (ToType.$arrow().isRealFloatingType()) {
          From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), 
              isFloatingComplex ? CastKind.CK_FloatingCast : CastKind.CK_IntegralToFloating, 
              ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
        } else {
          assert (ToType.$arrow().isIntegerType());
          From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), 
              isFloatingComplex ? CastKind.CK_FloatingToIntegral : CastKind.CK_IntegralCast, 
              ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
        }
      }
    }
    break;
   case ICK_Block_Pointer_Conversion:
    {
      From.$set($this().ImpCastExprToType(From.$deref(), ToType.getUnqualifiedType(), CastKind.CK_BitCast, 
          ExprValueKind.VK_RValue, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
      break;
    }
   case ICK_TransparentUnionConversion:
    {
      ActionResultTTrue<Expr /*P*/ > FromRes = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From.$deref());
      Sema.AssignConvertType ConvTy = $this().CheckTransparentUnionArgumentConstraints(new QualType(ToType), FromRes);
      if (FromRes.isInvalid()) {
        return SemaClangGlobals.ExprError();
      }
      From.$set(FromRes.get());
      assert ((ConvTy == Sema.AssignConvertType.Compatible)) : "Improper transparent union conversion";
      ///*J:(void)*/ConvTy;
      break;
    }
   case ICK_Zero_Event_Conversion:
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToType), 
        CastKind.CK_ZeroToOCLEvent, 
        From.$deref().getValueKind()).get());
    break;
   case ICK_Lvalue_To_Rvalue:
   case ICK_Array_To_Pointer:
   case ICK_Function_To_Pointer:
   case ICK_Qualification:
   case ICK_Num_Conversion_Kinds:
   case ICK_C_Only_Conversion:
    throw new llvm_unreachable("Improper second standard conversion");
  }
  switch (SCS.Third) {
   case ICK_Identity:
    // Nothing to do.
    break;
   case ICK_Qualification:
    {
      // The qualification keeps the category of the inner expression, unless the
      // target type isn't a reference.
      ExprValueKind VK = ToType.$arrow().isReferenceType() ? From.$deref().getValueKind() : ExprValueKind.VK_RValue;
      From.$set($this().ImpCastExprToType(From.$deref(), ToType.getNonLValueExprType($this().Context), 
          CastKind.CK_NoOp, VK, /*BasePath=*/ (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
      if (SCS.DeprecatedStringLiteralToCharPtr
         && !$this().getLangOpts().WritableStrings) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(From.$deref().getLocStart(), $this().getLangOpts().CPlusPlus11 ? diag.ext_deprecated_string_literal_conversion : diag.warn_deprecated_string_literal_conversion)), 
              ToType.getNonReferenceType()));
        } finally {
          $c$.$destroy();
        }
      }
      
      break;
    }
   default:
    throw new llvm_unreachable("Improper third standard conversion");
  }
  
  // If this conversion sequence involved a scalar -> atomic conversion, perform
  // that conversion now.
  if (!ToAtomicType.isNull()) {
    assert ($this().Context.hasSameType(ToAtomicType.$arrow().castAs(AtomicType.class).getValueType(), From.$deref().getType()));
    From.$set($this().ImpCastExprToType(From.$deref(), new QualType(ToAtomicType), CastKind.CK_NonAtomicToAtomic, 
        ExprValueKind.VK_RValue, (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, CCK).get());
  }
  
  // If this conversion sequence succeeded and involved implicitly converting a
  // _Nullable type to a _Nonnull one, complain.
  if (CCK == CheckedConversionKind.CCK_ImplicitConversion) {
    $this().diagnoseNullableToNonnullConversion(new QualType(ToType), new QualType(InitialFromType), 
        From.$deref().getLocStart());
  }
  
  return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From.$deref());
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckPointerToMemberOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 4778,
 FQN="clang::Sema::CheckPointerToMemberOperands", NM="_ZN5clang4Sema28CheckPointerToMemberOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_RNS_13ExprValueKindENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema28CheckPointerToMemberOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_RNS_13ExprValueKindENS_14SourceLocationEb")
//</editor-fold>
public final QualType CheckPointerToMemberOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, 
                            final type$ref<ExprValueKind /*&*/> VK, 
                            SourceLocation Loc, 
                            boolean isIndirect) {
  assert (!LHS.get().getType().$arrow().isPlaceholderType() && !RHS.get().getType().$arrow().isPlaceholderType()) : "placeholders should have been weeded out by now";
  
  // The LHS undergoes lvalue conversions if this is ->*.
  if (isIndirect) {
    LHS.$assignMove($this().DefaultLvalueConversion(LHS.get()));
    if (LHS.isInvalid()) {
      return new QualType();
    }
  }
  
  // The RHS always undergoes lvalue conversions.
  RHS.$assignMove($this().DefaultLvalueConversion(RHS.get()));
  if (RHS.isInvalid()) {
    return new QualType();
  }
  
  /*const*/char$ptr/*char P*/ OpSpelling = $tryClone(isIndirect ? $ARROW_STAR : $DOT_STAR);
  // C++ 5.5p2
  //   The binary operator .* [p3: ->*] binds its second operand, which shall
  //   be of type "pointer to member of T" (where T is a completely-defined
  //   class type) [...]
  QualType RHSType = RHS.get().getType();
  /*const*/ MemberPointerType /*P*/ MemPtr = RHSType.$arrow().getAs(MemberPointerType.class);
  if (!(MemPtr != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_memptr_rhs)), 
                  OpSpelling), RHSType), RHS.get().getSourceRange()));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  QualType Class/*J*/= new QualType(MemPtr.__getClass(), 0);
  
  // Note: C++ [expr.mptr.oper]p2-3 says that the class type into which the
  // member pointer points must be completely-defined. However, there is no
  // reason for this semantic distinction, and the rule is not enforced by
  // other compilers. Therefore, we do not check this property, as it is
  // likely to be considered a defect.
  
  // C++ 5.5p2
  //   [...] to its first operand, which shall be of class T or of a class of
  //   which T is an unambiguous and accessible base class. [p3: a pointer to
  //   such a class]
  QualType LHSType = LHS.get().getType();
  if (isIndirect) {
    {
      /*const*/ PointerType /*P*/ Ptr = LHSType.$arrow().getAs(PointerType.class);
      if ((Ptr != null)) {
        LHSType.$assignMove(Ptr.getPointeeType());
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_FixItHint(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_memptr_lhs)), 
                          OpSpelling), 1), LHSType), 
              FixItHint.CreateReplacement(new SourceRange(/*NO_COPY*/Loc), new StringRef(/*KEEP_STR*/$DOT_STAR))));
          return new QualType();
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  if (!$this().Context.hasSameUnqualifiedType(new QualType(Class), new QualType(LHSType))) {
    // If we want to check the hierarchy, we need a complete type.
    if ($this().RequireCompleteType$T(new SourceLocation(Loc), new QualType(LHSType), diag.err_bad_memptr_lhs, 
        OpSpelling, (int)(isIndirect ? 1 : 0))) {
      return new QualType();
    }
    if (!$this().IsDerivedFrom(new SourceLocation(Loc), new QualType(LHSType), new QualType(Class))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_char$ptr$C($c$.track($this().Diag(new SourceLocation(Loc), diag.err_bad_memptr_lhs)), OpSpelling), 
                (int)(isIndirect ? 1 : 0)), LHS.get().getType()));
        return new QualType();
      } finally {
        $c$.$destroy();
      }
    }
    
    SmallVector<CXXBaseSpecifier /*P*/> BasePath/*J*/= new SmallVector<CXXBaseSpecifier /*P*/>(4, null);
    if ($this().CheckDerivedToBaseConversion(new QualType(LHSType), new QualType(Class), new SourceLocation(Loc), 
        new SourceRange(LHS.get().getLocStart(), 
            RHS.get().getLocEnd()), 
        $AddrOf(BasePath))) {
      return new QualType();
    }
    
    // Cast LHS to type of use.
    QualType UseType = isIndirect ? $this().Context.getPointerType(/*NO_COPY*/Class) : new QualType(Class);
    ExprValueKind VK$1 = isIndirect ? ExprValueKind.VK_RValue : LHS.get().getValueKind();
    LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(UseType), CastKind.CK_DerivedToBase, VK$1, 
            $AddrOf(BasePath)));
  }
  if (isa_CXXScalarValueInitExpr(RHS.get().IgnoreParens())) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Diagnose use of pointer-to-member type which when used as
      // the functional cast in a pointer-to-member expression.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_bool($c$.track($this().Diag(new SourceLocation(Loc), diag.err_pointer_to_member_type)), isIndirect));
      return new QualType();
    } finally {
      $c$.$destroy();
    }
  }
  
  // C++ 5.5p2
  //   The result is an object or a function of the type specified by the
  //   second operand.
  // The cv qualifiers are the union of those in the pointer and the left side,
  // in accordance with 5.5p5 and 5.2.5.
  QualType Result = MemPtr.getPointeeType();
  Result.$assignMove($this().Context.getCVRQualifiedType(new QualType(Result), LHSType.getCVRQualifiers()));
  {
    
    // C++0x [expr.mptr.oper]p6:
    //   In a .* expression whose object expression is an rvalue, the program is
    //   ill-formed if the second operand is a pointer to member function with
    //   ref-qualifier &. In a ->* expression or in a .* expression whose object
    //   expression is an lvalue, the program is ill-formed if the second operand
    //   is a pointer to member function with ref-qualifier &&.
    /*const*/ FunctionProtoType /*P*/ Proto = Result.$arrow().getAs(FunctionProtoType.class);
    if ((Proto != null)) {
      switch (Proto.getRefQualifier()) {
       case RQ_None:
        // Do nothing
        break;
       case RQ_LValue:
        if (!isIndirect && !LHS.get().Classify($this().Context).isLValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_pointer_to_member_oper_value_classify)), 
                        RHSType), 1), LHS.get().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        break;
       case RQ_RValue:
        if (isIndirect || !LHS.get().Classify($this().Context).isRValue()) {
          JavaCleaner $c$ = $createJavaCleaner();
          try {
            $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(Loc), diag.err_pointer_to_member_oper_value_classify)), 
                        RHSType), 0), LHS.get().getSourceRange()));
          } finally {
            $c$.$destroy();
          }
        }
        break;
      }
    }
  }
  
  // C++ [expr.mptr.oper]p6:
  //   The result of a .* expression whose second operand is a pointer
  //   to a data member is of the same value category as its
  //   first operand. The result of a .* expression whose second
  //   operand is a pointer to a member function is a prvalue. The
  //   result of an ->* expression is an lvalue if its second operand
  //   is a pointer to data member and a prvalue otherwise.
  if (Result.$arrow().isFunctionType()) {
    VK.$set(ExprValueKind.VK_RValue);
    return $this().Context.BoundMemberTy.$QualType();
  } else if (isIndirect) {
    VK.$set(ExprValueKind.VK_LValue);
  } else {
    VK.$set(LHS.get().getValueKind());
  }
  
  return Result;
}


/// \brief Check the operands of ?: under C++ semantics.
///
/// See C++ [expr.cond]. Note that LHS is never null, even for the GNU x ?: y
/// extension. In this case, LHS == Cond. (But they're not aliases.)
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CXXCheckConditionalOperands">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5097,
 FQN="clang::Sema::CXXCheckConditionalOperands", NM="_ZN5clang4Sema27CXXCheckConditionalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_S5_RNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema27CXXCheckConditionalOperandsERNS_12ActionResultIPNS_4ExprELb1EEES5_S5_RNS_13ExprValueKindERNS_14ExprObjectKindENS_14SourceLocationE")
//</editor-fold>
public final QualType CXXCheckConditionalOperands(final ActionResultTTrue<Expr /*P*/ > /*&*/ Cond, final ActionResultTTrue<Expr /*P*/ > /*&*/ LHS, 
                           final ActionResultTTrue<Expr /*P*/ > /*&*/ RHS, final type$ref<ExprValueKind /*&*/> VK, 
                           final type$ref<ExprObjectKind /*&*/> OK, 
                           SourceLocation QuestionLoc) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // FIXME: Handle C99's complex types, vector types, block pointers and Obj-C++
    // interface pointers.
    
    // C++11 [expr.cond]p1
    //   The first expression is contextually converted to bool.
    if (!Cond.get().isTypeDependent()) {
      ActionResultTTrue<Expr /*P*/ > CondRes = $this().CheckCXXBooleanCondition(Cond.get());
      if (CondRes.isInvalid()) {
        return new QualType();
      }
      Cond.$assign(CondRes);
    }
    
    // Assume r-value.
    VK.$set(ExprValueKind.VK_RValue);
    OK.$set(ExprObjectKind.OK_Ordinary);
    
    // Either of the arguments dependent?
    if (LHS.get().isTypeDependent() || RHS.get().isTypeDependent()) {
      return $this().Context.DependentTy.$QualType();
    }
    
    // C++11 [expr.cond]p2
    //   If either the second or the third operand has type (cv) void, ...
    QualType LTy = LHS.get().getType();
    QualType RTy = RHS.get().getType();
    boolean LVoid = LTy.$arrow().isVoidType();
    boolean RVoid = RTy.$arrow().isVoidType();
    if (LVoid || RVoid) {
      //   ... one of the following shall hold:
      //   -- The second or the third operand (but not both) is a (possibly
      //      parenthesized) throw-expression; the result is of the type
      //      and value category of the other.
      boolean LThrow = isa_CXXThrowExpr(LHS.get().IgnoreParenImpCasts());
      boolean RThrow = isa_CXXThrowExpr(RHS.get().IgnoreParenImpCasts());
      if (LThrow != RThrow) {
        Expr /*P*/ NonThrow = LThrow ? RHS.get() : LHS.get();
        VK.$set(NonThrow.getValueKind());
        // DR (no number yet): the result is a bit-field if the
        // non-throw-expression operand is a bit-field.
        OK.$set(NonThrow.getObjectKind());
        return NonThrow.getType();
      }
      
      //   -- Both the second and third operands have type void; the result is of
      //      type void and is a prvalue.
      if (LVoid && RVoid) {
        return $this().Context.VoidTy.$QualType();
      }
      
      // Neither holds, error.
      $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_int(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_conditional_void_nonvoid)), 
                      (LVoid ? RTy : LTy)), (LVoid ? 0 : 1)), 
              LHS.get().getSourceRange()), RHS.get().getSourceRange()));
      return new QualType();
    }
    
    // Neither is void.
    
    // C++11 [expr.cond]p3
    //   Otherwise, if the second and third operand have different types, and
    //   either has (cv) class type [...] an attempt is made to convert each of
    //   those operands to the type of the other.
    if (!$this().Context.hasSameType(new QualType(LTy), new QualType(RTy))
       && (LTy.$arrow().isRecordType() || RTy.$arrow().isRecordType())) {
      // These return true if a single direction is already ambiguous.
      QualType L2RType/*J*/= new QualType();
      QualType R2LType/*J*/= new QualType();
      bool$ref HaveL2R = create_bool$ref();
      bool$ref HaveR2L = create_bool$ref();
      if (SemaExprCXXStatics.TryClassUnification(/*Deref*/$this(), LHS.get(), RHS.get(), new SourceLocation(QuestionLoc), HaveL2R, L2RType)) {
        return new QualType();
      }
      if (SemaExprCXXStatics.TryClassUnification(/*Deref*/$this(), RHS.get(), LHS.get(), new SourceLocation(QuestionLoc), HaveR2L, R2LType)) {
        return new QualType();
      }
      
      //   If both can be converted, [...] the program is ill-formed.
      if (HaveL2R.$deref() && HaveR2L.$deref()) {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_conditional_ambiguous)), 
                        LTy), RTy), LHS.get().getSourceRange()), RHS.get().getSourceRange()));
        return new QualType();
      }
      
      //   If exactly one conversion is possible, that conversion is applied to
      //   the chosen operand and the converted operands are used in place of the
      //   original operands for the remainder of this section.
      if (HaveL2R.$deref()) {
        if (SemaExprCXXStatics.ConvertForConditional(/*Deref*/$this(), LHS, new QualType(L2RType)) || LHS.isInvalid()) {
          return new QualType();
        }
        LTy.$assignMove(LHS.get().getType());
      } else if (HaveR2L.$deref()) {
        if (SemaExprCXXStatics.ConvertForConditional(/*Deref*/$this(), RHS, new QualType(R2LType)) || RHS.isInvalid()) {
          return new QualType();
        }
        RTy.$assignMove(RHS.get().getType());
      }
    }
    
    // C++11 [expr.cond]p3
    //   if both are glvalues of the same value category and the same type except
    //   for cv-qualification, an attempt is made to convert each of those
    //   operands to the type of the other.
    ExprValueKind LVK = LHS.get().getValueKind();
    ExprValueKind RVK = RHS.get().getValueKind();
    if (!$this().Context.hasSameType(new QualType(LTy), new QualType(RTy))
       && $this().Context.hasSameUnqualifiedType(new QualType(LTy), new QualType(RTy))
       && LVK == RVK && LVK != ExprValueKind.VK_RValue) {
      // Since the unqualified types are reference-related and we require the
      // result to be as if a reference bound directly, the only conversion
      // we can perform is to add cv-qualifiers.
      Qualifiers LCVR = Qualifiers.fromCVRMask(LTy.getCVRQualifiers());
      Qualifiers RCVR = Qualifiers.fromCVRMask(RTy.getCVRQualifiers());
      if (RCVR.isStrictSupersetOf(new Qualifiers(LCVR))) {
        LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(RTy), CastKind.CK_NoOp, LVK));
        LTy.$assignMove(LHS.get().getType());
      } else if (LCVR.isStrictSupersetOf(new Qualifiers(RCVR))) {
        RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(LTy), CastKind.CK_NoOp, RVK));
        RTy.$assignMove(RHS.get().getType());
      }
    }
    
    // C++11 [expr.cond]p4
    //   If the second and third operands are glvalues of the same value
    //   category and have the same type, the result is of that type and
    //   value category and it is a bit-field if the second or the third
    //   operand is a bit-field, or if both are bit-fields.
    // We only extend this to bitfields, not to the crazy other kinds of
    // l-values.
    boolean Same = $this().Context.hasSameType(new QualType(LTy), new QualType(RTy));
    if (Same && LVK == RVK && LVK != ExprValueKind.VK_RValue
       && LHS.get().isOrdinaryOrBitFieldObject()
       && RHS.get().isOrdinaryOrBitFieldObject()) {
      VK.$set(LHS.get().getValueKind());
      if (LHS.get().getObjectKind() == ExprObjectKind.OK_BitField
         || RHS.get().getObjectKind() == ExprObjectKind.OK_BitField) {
        OK.$set(ExprObjectKind.OK_BitField);
      }
      return LTy;
    }
    
    // C++11 [expr.cond]p5
    //   Otherwise, the result is a prvalue. If the second and third operands
    //   do not have the same type, and either has (cv) class type, ...
    if (!Same && (LTy.$arrow().isRecordType() || RTy.$arrow().isRecordType())) {
      //   ... overload resolution is used to determine the conversions (if any)
      //   to be applied to the operands. If the overload resolution fails, the
      //   program is ill-formed.
      if (SemaExprCXXStatics.FindConditionalOverload(/*Deref*/$this(), LHS, RHS, new SourceLocation(QuestionLoc))) {
        return new QualType();
      }
    }
    
    // C++11 [expr.cond]p6
    //   Lvalue-to-rvalue, array-to-pointer, and function-to-pointer standard
    //   conversions are performed on the second and third operands.
    LHS.$assignMove($this().DefaultFunctionArrayLvalueConversion(LHS.get()));
    RHS.$assignMove($this().DefaultFunctionArrayLvalueConversion(RHS.get()));
    if (LHS.isInvalid() || RHS.isInvalid()) {
      return new QualType();
    }
    LTy.$assignMove(LHS.get().getType());
    RTy.$assignMove(RHS.get().getType());
    
    //   After those conversions, one of the following shall hold:
    //   -- The second and third operands have the same type; the result
    //      is of that type. If the operands have class type, the result
    //      is a prvalue temporary of the result type, which is
    //      copy-initialized from either the second operand or the third
    //      operand depending on the value of the first operand.
    if ($eq_CanQual$T_CanQual$U($this().Context.getCanonicalType(/*NO_COPY*/LTy), $this().Context.getCanonicalType(/*NO_COPY*/RTy))) {
      if (LTy.$arrow().isRecordType()) {
        // The operands have class type. Make a temporary copy.
        if ($this().RequireNonAbstractType$T(new SourceLocation(QuestionLoc), new QualType(LTy), 
            diag.err_allocation_of_abstract_type)) {
          return new QualType();
        }
        InitializedEntity Entity = InitializedEntity.InitializeTemporary(new QualType(LTy));
        
        ActionResultTTrue<Expr /*P*/ > LHSCopy = $this().PerformCopyInitialization(Entity, 
            new SourceLocation(), 
            new ActionResultTTrue<Expr /*P*/ >(LHS));
        if (LHSCopy.isInvalid()) {
          return new QualType();
        }
        
        ActionResultTTrue<Expr /*P*/ > RHSCopy = $this().PerformCopyInitialization(Entity, 
            new SourceLocation(), 
            new ActionResultTTrue<Expr /*P*/ >(RHS));
        if (RHSCopy.isInvalid()) {
          return new QualType();
        }
        
        LHS.$assign(LHSCopy);
        RHS.$assign(RHSCopy);
      }
      
      return LTy;
    }
    
    // Extension: conditional operator involving vector types.
    if (LTy.$arrow().isVectorType() || RTy.$arrow().isVectorType()) {
      return $this().CheckVectorOperands(LHS, RHS, new SourceLocation(QuestionLoc), /*isCompAssign*/ false, 
          /*AllowBothBool*/ true, 
          /*AllowBoolConversions*/ false);
    }
    
    //   -- The second and third operands have arithmetic or enumeration type;
    //      the usual arithmetic conversions are performed to bring them to a
    //      common type, and the result is of that type.
    if (LTy.$arrow().isArithmeticType() && RTy.$arrow().isArithmeticType()) {
      QualType ResTy = $this().UsualArithmeticConversions(LHS, RHS);
      if (LHS.isInvalid() || RHS.isInvalid()) {
        return new QualType();
      }
      if (ResTy.isNull()) {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(QuestionLoc), 
                            diag.err_typecheck_cond_incompatible_operands)), LTy), RTy), 
                LHS.get().getSourceRange()), RHS.get().getSourceRange()));
        return new QualType();
      }
      
      LHS.$assignMove($this().ImpCastExprToType(LHS.get(), new QualType(ResTy), $this().PrepareScalarCast(LHS, new QualType(ResTy))));
      RHS.$assignMove($this().ImpCastExprToType(RHS.get(), new QualType(ResTy), $this().PrepareScalarCast(RHS, new QualType(ResTy))));
      
      return ResTy;
    }
    
    //   -- The second and third operands have pointer type, or one has pointer
    //      type and the other is a null pointer constant, or both are null
    //      pointer constants, at least one of which is non-integral; pointer
    //      conversions and qualification conversions are performed to bring them
    //      to their composite pointer type. The result is of the composite
    //      pointer type.
    //   -- The second and third operands have pointer to member type, or one has
    //      pointer to member type and the other is a null pointer constant;
    //      pointer to member conversions and qualification conversions are
    //      performed to bring them to a common type, whose cv-qualification
    //      shall match the cv-qualification of either the second or the third
    //      operand. The result is of the common type.
    bool$ptr NonStandardCompositeType = create_bool$ptr(false);
    QualType Composite = $this().FindCompositePointerType(new SourceLocation(QuestionLoc), LHS, RHS, 
        $this().isSFINAEContext().$bool() ? (bool$ptr/*bool P*/ )null : $AddrOf(NonStandardCompositeType));
    if (!Composite.isNull()) {
      if (NonStandardCompositeType.$star()) {
        $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(QuestionLoc), 
                                diag.ext_typecheck_cond_incompatible_operands_nonstandard)), 
                            LTy), RTy), Composite), 
                LHS.get().getSourceRange()), RHS.get().getSourceRange()));
      }
      
      return Composite;
    }
    
    // Similarly, attempt to find composite type of two objective-c pointers.
    Composite.$assignMove($this().FindCompositeObjCPointerType(LHS, RHS, new SourceLocation(QuestionLoc)));
    if (!Composite.isNull()) {
      return Composite;
    }
    
    // Check if we are using a null with a non-pointer type.
    if ($this().DiagnoseConditionalForNull(LHS.get(), RHS.get(), new SourceLocation(QuestionLoc))) {
      return new QualType();
    }
    
    $c$.clean(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_CanQual($c$.track($this().Diag(new SourceLocation(QuestionLoc), diag.err_typecheck_cond_incompatible_operands)), 
                    LHS.get().getType()), RHS.get().getType()), 
            LHS.get().getSourceRange()), RHS.get().getSourceRange()));
    return new QualType();
  } finally {
    $c$.$destroy();
  }
}


/// \brief Find a merged pointer type and convert the two expressions to it.
///
/// This finds the composite pointer type (or member pointer type) for @p E1
/// and @p E2 according to C++11 5.9p2. It converts both expressions to this
/// type and returns it.
/// It does not emit diagnostics.
///
/// \param Loc The location of the operator requiring these two expressions to
/// be converted to the composite pointer type.
///
/// If \p NonStandardCompositeType is non-NULL, then we are permitted to find
/// a non-standard (but still sane) composite type to which both expressions
/// can be converted. When such a type is chosen, \c *NonStandardCompositeType
/// will be set true.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::FindCompositePointerType">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*make_pair*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 5369,
 FQN="clang::Sema::FindCompositePointerType", NM="_ZN5clang4Sema24FindCompositePointerTypeENS_14SourceLocationERPNS_4ExprES4_Pb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema24FindCompositePointerTypeENS_14SourceLocationERPNS_4ExprES4_Pb")
//</editor-fold>
public final QualType FindCompositePointerType(SourceLocation Loc, 
                        final type$ref<Expr /*P*/ /*&*/> E1, final type$ref<Expr /*P*/ /*&*/> E2) {
  return FindCompositePointerType(Loc, 
                        E1, E2, 
                        (bool$ptr/*bool P*/ )null);
}
public final QualType FindCompositePointerType(SourceLocation Loc, 
                        final type$ref<Expr /*P*/ /*&*/> E1, final type$ref<Expr /*P*/ /*&*/> E2, 
                        bool$ptr/*bool P*/ NonStandardCompositeType/*= null*/) {
  InitializationSequence E1ToC1 = null;
  InitializationSequence E2ToC1 = null;
  InitializationSequence E1ToC2 = null;
  InitializationSequence E2ToC2 = null;
  try {
    if (Native.$bool(NonStandardCompositeType)) {
      NonStandardCompositeType.$set(false);
    }
    assert ($this().getLangOpts().CPlusPlus) : "This function assumes C++";
    QualType T1 = E1.$deref().getType();
    QualType T2 = E2.$deref().getType();
    
    // C++11 5.9p2
    //   Pointer conversions and qualification conversions are performed on
    //   pointer operands to bring them to their composite pointer type. If
    //   one operand is a null pointer constant, the composite pointer type is
    //   std::nullptr_t if the other operand is also a null pointer constant or,
    //   if the other operand is a pointer, the type of the other operand.
    if (!T1.$arrow().isAnyPointerType() && !T1.$arrow().isMemberPointerType()
       && !T2.$arrow().isAnyPointerType() && !T2.$arrow().isMemberPointerType()) {
      if (T1.$arrow().isNullPtrType()
         && (E2.$deref().isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
        E2.$set($this().ImpCastExprToType(E2.$deref(), new QualType(T1), CastKind.CK_NullToPointer).get());
        return T1;
      }
      if (T2.$arrow().isNullPtrType()
         && (E1.$deref().isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
        E1.$set($this().ImpCastExprToType(E1.$deref(), new QualType(T2), CastKind.CK_NullToPointer).get());
        return T2;
      }
      return new QualType();
    }
    if ((E1.$deref().isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
      if (T2.$arrow().isMemberPointerType()) {
        E1.$set($this().ImpCastExprToType(E1.$deref(), new QualType(T2), CastKind.CK_NullToMemberPointer).get());
      } else {
        E1.$set($this().ImpCastExprToType(E1.$deref(), new QualType(T2), CastKind.CK_NullToPointer).get());
      }
      return T2;
    }
    if ((E2.$deref().isNullPointerConstant($this().Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0)) {
      if (T1.$arrow().isMemberPointerType()) {
        E2.$set($this().ImpCastExprToType(E2.$deref(), new QualType(T1), CastKind.CK_NullToMemberPointer).get());
      } else {
        E2.$set($this().ImpCastExprToType(E2.$deref(), new QualType(T1), CastKind.CK_NullToPointer).get());
      }
      return T1;
    }
    
    // Now both have to be pointers or member pointers.
    if ((!T1.$arrow().isPointerType() && !T1.$arrow().isMemberPointerType())
       || (!T2.$arrow().isPointerType() && !T2.$arrow().isMemberPointerType())) {
      return new QualType();
    }
    
    //   Otherwise, of one of the operands has type "pointer to cv1 void," then
    //   the other has type "pointer to cv2 T" and the composite pointer type is
    //   "pointer to cv12 void," where cv12 is the union of cv1 and cv2.
    //   Otherwise, the composite pointer type is a pointer type similar to the
    //   type of one of the operands, with a cv-qualification signature that is
    //   the union of the cv-qualification signatures of the operand types.
    // In practice, the first part here is redundant; it's subsumed by the second.
    // What we do here is, we build the two possible composite types, and try the
    // conversions in both directions. If only one works, or if the two composite
    // types are the same, we have succeeded.
    // FIXME: extended qualifiers?
    // JAVA: typedef SmallVector<unsigned int, 4> QualifierVector
//    final class QualifierVector extends SmallVectorUInt{ };
    SmallVectorUInt QualifierUnion/*J*/= new SmallVectorUInt(4, 0);
    // JAVA: typedef SmallVector<std::pair<const Type *, const Type *>, 4> ContainingClassVector
//    final class ContainingClassVector extends SmallVector<std.pair</*const*/ Type /*P*/ , /*const*/ Type /*P*/ >>{ };
    SmallVector<std.pair</*const*/ Type /*P*/ , /*const*/ Type /*P*/ >> MemberOfClass/*J*/= new SmallVector<std.pair</*const*/ Type /*P*/ , /*const*/ Type /*P*/ >>(4, new std.pairPtrPtr</*const*/ Type /*P*/ , /*const*/ Type /*P*/ >());
    QualType Composite1 = $this().Context.getCanonicalType(/*NO_COPY*/T1).$QualType();
    QualType Composite2 = $this().Context.getCanonicalType(/*NO_COPY*/T2).$QualType();
    /*uint*/int NeedConstBefore = 0;
    do {
      /*const*/ PointerType /*P*/ Ptr1;
      /*const*/ PointerType /*P*/ Ptr2;
      if (((Ptr1 = Composite1.$arrow().getAs(PointerType.class)) != null)
         && ((Ptr2 = Composite2.$arrow().getAs(PointerType.class)) != null)) {
        Composite1.$assignMove(Ptr1.getPointeeType());
        Composite2.$assignMove(Ptr2.getPointeeType());
        
        // If we're allowed to create a non-standard composite type, keep track
        // of where we need to fill in additional 'const' qualifiers.
        if (Native.$bool(NonStandardCompositeType)
           && Composite1.getCVRQualifiers() != Composite2.getCVRQualifiers()) {
          NeedConstBefore = QualifierUnion.size();
        }
        
        QualifierUnion.push_back(Composite1.getCVRQualifiers() | Composite2.getCVRQualifiers());
        MemberOfClass.push_back(new std.pairPtrPtr</*const*/ Type /*P*/ , /*const*/ Type /*P*/ >(JD$Pair$_U1$_U2.INSTANCE, (/*const*/ Type /*P*/ )null, (/*const*/ Type /*P*/ )null));
        continue;
      }
      
      /*const*/ MemberPointerType /*P*/ MemPtr1;
      /*const*/ MemberPointerType /*P*/ MemPtr2;
      if (((MemPtr1 = Composite1.$arrow().getAs(MemberPointerType.class)) != null)
         && ((MemPtr2 = Composite2.$arrow().getAs(MemberPointerType.class)) != null)) {
        Composite1.$assignMove(MemPtr1.getPointeeType());
        Composite2.$assignMove(MemPtr2.getPointeeType());
        
        // If we're allowed to create a non-standard composite type, keep track
        // of where we need to fill in additional 'const' qualifiers.
        if (Native.$bool(NonStandardCompositeType)
           && Composite1.getCVRQualifiers() != Composite2.getCVRQualifiers()) {
          NeedConstBefore = QualifierUnion.size();
        }
        
        QualifierUnion.push_back(Composite1.getCVRQualifiers() | Composite2.getCVRQualifiers());
        MemberOfClass.push_back(std.make_pair_Ptr_Ptr(MemPtr1.__getClass(), MemPtr2.__getClass()
                ));
        continue;
      }
      
      // FIXME: block pointer types?
      
      // Cannot unwrap any more types.
      break;
    } while (true);
    if ((NeedConstBefore != 0) && Native.$bool(NonStandardCompositeType)) {
      // Extension: Add 'const' to qualifiers that come before the first qualifier
      // mismatch, so that our (non-standard!) composite type meets the
      // requirements of C++ [conv.qual]p4 bullet 3.
      for (/*uint*/int I = 0; I != NeedConstBefore; ++I) {
        if ((QualifierUnion.$at(I) & Qualifiers.TQ.Const) == 0) {
          QualifierUnion.$set(I, QualifierUnion.$at(I) | Qualifiers.TQ.Const);
          NonStandardCompositeType.$set(true);
        }
      }
    }
    
    // Rewrap the composites as pointers or member pointers with the union CVRs.
    std.reverse_iterator<pair</*const*/ Type /*P*/ , /*const*/ Type /*P*/ > > MOC = MemberOfClass.rbegin();
    for (std.reverse_iteratorUInt I = QualifierUnion.rbegin(), 
        E = QualifierUnion.rend();
         $noteq_reverse_iterator$C(I, E); /*J:(void)*/I.$preInc() , MOC.$preInc()) {
      Qualifiers Quals = Qualifiers.fromCVRMask(I.$star());
      if ((MOC.$arrow().first != null) && (MOC.$arrow().second != null)) {
        // Rebuild member pointer type
        Composite1.$assignMove($this().Context.getMemberPointerType($this().Context.getQualifiedType(new QualType(Composite1), new Qualifiers(Quals)), 
                MOC.$arrow().first));
        Composite2.$assignMove($this().Context.getMemberPointerType($this().Context.getQualifiedType(new QualType(Composite2), new Qualifiers(Quals)), 
                MOC.$arrow().second));
      } else {
        // Rebuild pointer type
        Composite1.$assignMove(
            $this().Context.getPointerType($this().Context.getQualifiedType(new QualType(Composite1), new Qualifiers(Quals)))
        );
        Composite2.$assignMove(
            $this().Context.getPointerType($this().Context.getQualifiedType(new QualType(Composite2), new Qualifiers(Quals)))
        );
      }
    }
    
    // Try to convert to the first composite pointer type.
    InitializedEntity Entity1 = InitializedEntity.InitializeTemporary(new QualType(Composite1));
    InitializationKind Kind = InitializationKind.CreateCopy(new SourceLocation(Loc), new SourceLocation());
    E1ToC1/*J*/= new InitializationSequence(/*Deref*/$this(), Entity1, Kind, new MutableArrayRef<Expr /*P*/ >(E1.$deref(), true));
    E2ToC1/*J*/= new InitializationSequence(/*Deref*/$this(), Entity1, Kind, new MutableArrayRef<Expr /*P*/ >(E2.$deref(), true));
    if (E1ToC1.$bool() && E2ToC1.$bool()) {
      // Conversion to Composite1 is viable.
      if (!$this().Context.hasSameType(new QualType(Composite1), new QualType(Composite2))) {
        InitializationSequence E1ToC2$1 = null;
        InitializationSequence E2ToC2$1 = null;
        try {
          // Composite2 is a different type from Composite1. Check whether
          // Composite2 is also viable.
          InitializedEntity Entity2 = InitializedEntity.InitializeTemporary(new QualType(Composite2));
          E1ToC2$1/*J*/= new InitializationSequence(/*Deref*/$this(), Entity2, Kind, new MutableArrayRef<Expr /*P*/ >(E1.$deref(), true));
          E2ToC2$1/*J*/= new InitializationSequence(/*Deref*/$this(), Entity2, Kind, new MutableArrayRef<Expr /*P*/ >(E2.$deref(), true));
          if (E1ToC2$1.$bool() && E2ToC2$1.$bool()) {
            // Both Composite1 and Composite2 are viable and are different;
            // this is an ambiguity.
            return new QualType();
          }
        } finally {
          if (E2ToC2$1 != null) { E2ToC2$1.$destroy(); }
          if (E1ToC2$1 != null) { E1ToC2$1.$destroy(); }
        }
      }
      
      // Convert E1 to Composite1
      ActionResultTTrue<Expr /*P*/ > E1Result = E1ToC1.Perform(/*Deref*/$this(), Entity1, Kind, new MutableArrayRef<Expr /*P*/ >(E1.$deref(), true));
      if (E1Result.isInvalid()) {
        return new QualType();
      }
      E1.$set(E1Result.getAs(Expr.class));
      
      // Convert E2 to Composite1
      ActionResultTTrue<Expr /*P*/ > E2Result = E2ToC1.Perform(/*Deref*/$this(), Entity1, Kind, new MutableArrayRef<Expr /*P*/ >(E2.$deref(), true));
      if (E2Result.isInvalid()) {
        return new QualType();
      }
      E2.$set(E2Result.getAs(Expr.class));
      
      return Composite1;
    }
    
    // Check whether Composite2 is viable.
    InitializedEntity Entity2 = InitializedEntity.InitializeTemporary(new QualType(Composite2));
    E1ToC2/*J*/= new InitializationSequence(/*Deref*/$this(), Entity2, Kind, new MutableArrayRef<Expr /*P*/ >(E1.$deref(), true));
    E2ToC2/*J*/= new InitializationSequence(/*Deref*/$this(), Entity2, Kind, new MutableArrayRef<Expr /*P*/ >(E2.$deref(), true));
    if (!E1ToC2.$bool() || !E2ToC2.$bool()) {
      return new QualType();
    }
    
    // Convert E1 to Composite2
    ActionResultTTrue<Expr /*P*/ > E1Result = E1ToC2.Perform(/*Deref*/$this(), Entity2, Kind, new MutableArrayRef<Expr /*P*/ >(E1.$deref(), true));
    if (E1Result.isInvalid()) {
      return new QualType();
    }
    E1.$set(E1Result.getAs(Expr.class));
    
    // Convert E2 to Composite2
    ActionResultTTrue<Expr /*P*/ > E2Result = E2ToC2.Perform(/*Deref*/$this(), Entity2, Kind, new MutableArrayRef<Expr /*P*/ >(E2.$deref(), true));
    if (E2Result.isInvalid()) {
      return new QualType();
    }
    E2.$set(E2Result.getAs(Expr.class));
    
    return Composite2;
  } finally {
    if (E2ToC2 != null) { E2ToC2.$destroy(); }
    if (E1ToC2 != null) { E1ToC2.$destroy(); }
    if (E2ToC1 != null) { E2ToC1.$destroy(); }
    if (E1ToC1 != null) { E1ToC1.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::ActOnConditionVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3058,
 FQN="clang::Sema::ActOnConditionVariable", NM="_ZN5clang4Sema22ActOnConditionVariableEPNS_4DeclENS_14SourceLocationENS0_13ConditionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22ActOnConditionVariableEPNS_4DeclENS_14SourceLocationENS0_13ConditionKindE")
//</editor-fold>
public final Sema.ConditionResult ActOnConditionVariable(Decl /*P*/ ConditionVar, 
                      SourceLocation StmtLoc, 
                      ConditionKind CK) {
  ActionResultTTrue<Expr /*P*/ > E = $this().CheckConditionVariable(cast_VarDecl(ConditionVar), new SourceLocation(StmtLoc), CK);
  if (E.isInvalid()) {
    return Sema.ConditionError();
  }
  return new ConditionResult(/*Deref*/$this(), ConditionVar, $this().MakeFullExpr(E.get(), new SourceLocation(StmtLoc)), 
      CK == ConditionKind.ConstexprIf);
}


/// \brief Check the use of the given variable as a C++ condition in an if,
/// while, do-while, or switch statement.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckConditionVariable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3071,
 FQN="clang::Sema::CheckConditionVariable", NM="_ZN5clang4Sema22CheckConditionVariableEPNS_7VarDeclENS_14SourceLocationENS0_13ConditionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema22CheckConditionVariableEPNS_7VarDeclENS_14SourceLocationENS0_13ConditionKindE")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckConditionVariable(VarDecl /*P*/ ConditionVar, 
                      SourceLocation StmtLoc, 
                      ConditionKind CK) {
  if (ConditionVar.isInvalidDecl()) {
    return SemaClangGlobals.ExprError();
  }
  
  QualType T = ConditionVar.getType();
  
  // C++ [stmt.select]p2:
  //   The declarator shall not specify a function or an array.
  if (T.$arrow().isFunctionType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(ConditionVar.getLocation(), 
                  diag.err_invalid_use_of_function_type)), 
              ConditionVar.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  } else if (T.$arrow().isArrayType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(SemaClangGlobals.ExprError(SemaDiagnosticBuilder.$out_SemaDiagnosticBuilder_SourceRange($c$.track($this().Diag(ConditionVar.getLocation(), 
                  diag.err_invalid_use_of_array_type)), 
              ConditionVar.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > Condition = new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, DeclRefExpr.Create($this().Context, new NestedNameSpecifierLoc(), new SourceLocation(), ConditionVar, 
          /*enclosing*/ false, ConditionVar.getLocation(), 
          ConditionVar.getType().getNonReferenceType(), ExprValueKind.VK_LValue));
  
  $this().MarkDeclRefReferenced(cast_DeclRefExpr(Condition.get()));
  switch (CK) {
   case Boolean:
    return $this().CheckBooleanCondition(new SourceLocation(StmtLoc), Condition.get());
   case ConstexprIf:
    return $this().CheckBooleanCondition(new SourceLocation(StmtLoc), Condition.get(), true);
   case Switch:
    return $this().CheckSwitchCondition(new SourceLocation(StmtLoc), Condition.get());
  }
  throw new llvm_unreachable("unexpected condition kind");
}


/// CheckCXXBooleanCondition - Returns true if conversion to bool is invalid.

/// CheckCXXBooleanCondition - Returns true if a conversion to bool is invalid.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CheckCXXBooleanCondition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 3112,
 FQN="clang::Sema::CheckCXXBooleanCondition", NM="_ZN5clang4Sema24CheckCXXBooleanConditionEPNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema24CheckCXXBooleanConditionEPNS_4ExprEb")
//</editor-fold>
public final ActionResultTTrue<Expr /*P*/ > CheckCXXBooleanCondition(Expr /*P*/ CondExpr) {
  return CheckCXXBooleanCondition(CondExpr, false);
}
public final ActionResultTTrue<Expr /*P*/ > CheckCXXBooleanCondition(Expr /*P*/ CondExpr, boolean IsConstexpr/*= false*/) {
  // C++ 6.4p4:
  // The value of a condition that is an initialized declaration in a statement
  // other than a switch statement is the value of the declared variable
  // implicitly converted to type bool. If that conversion is ill-formed, the
  // program is ill-formed.
  // The value of a condition that is an expression is the value of the
  // expression, implicitly converted to bool.
  //
  // FIXME: Return this value to the caller so they don't need to recompute it.
  APSInt Value/*J*/= new APSInt(/*BitWidth*/ 1);
  return (IsConstexpr && !CondExpr.isValueDependent()) ? $this().CheckConvertedConstantExpression(CondExpr, $this().Context.BoolTy.$QualType(), Value, 
      CCEKind.CCEK_ConstexprIf) : $this().PerformContextuallyConvertToBool(CondExpr);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::AnalyzeDeleteExprMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2794,
 FQN="clang::Sema::AnalyzeDeleteExprMismatch", NM="_ZN5clang4Sema25AnalyzeDeleteExprMismatchEPKNS_13CXXDeleteExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25AnalyzeDeleteExprMismatchEPKNS_13CXXDeleteExprE")
//</editor-fold>
protected/*private*/ final void AnalyzeDeleteExprMismatch(/*const*/ CXXDeleteExpr /*P*/ DE) {
  MismatchingNewDeleteDetector Detector = null;
  try {
    if ($this().Diags.isIgnored(diag.warn_mismatched_delete_new, new SourceLocation())) {
      return;
    }
    Detector/*J*/= new MismatchingNewDeleteDetector(/*EndOfTU=*/ false);
    switch (Detector.analyzeDeleteExpr(DE)) {
     case VarInitMismatches:
     case MemberInitMismatches:
      {
        SemaExprCXXStatics.DiagnoseMismatchedNewDelete(/*Deref*/$this(), DE.getLocStart(), Detector);
        break;
      }
     case AnalyzeLater:
      {
        $this().DeleteExprs.$at(Detector.Field).push_back(std.make_pair_T_bool($Move(DE.getLocStart()), DE.isArrayForm()));
        break;
      }
     case NoMismatch:
      break;
    }
  } finally {
    if (Detector != null) { Detector.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::AnalyzeDeleteExprMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp", line = 2814,
 FQN="clang::Sema::AnalyzeDeleteExprMismatch", NM="_ZN5clang4Sema25AnalyzeDeleteExprMismatchEPNS_9FieldDeclENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaExprCXX.cpp -nm=_ZN5clang4Sema25AnalyzeDeleteExprMismatchEPNS_9FieldDeclENS_14SourceLocationEb")
//</editor-fold>
protected/*private*/ final void AnalyzeDeleteExprMismatch(FieldDecl /*P*/ Field, SourceLocation DeleteLoc, 
                         boolean DeleteWasArrayForm) {
  MismatchingNewDeleteDetector Detector = null;
  try {
    Detector/*J*/= new MismatchingNewDeleteDetector(/*EndOfTU=*/ true);
    switch (Detector.analyzeField(Field, DeleteWasArrayForm)) {
     case VarInitMismatches:
      throw new llvm_unreachable("This analysis should have been done for class members.");
     case AnalyzeLater:
      throw new llvm_unreachable("Analysis cannot be postponed any point beyond end of translation unit.");
     case MemberInitMismatches:
      SemaExprCXXStatics.DiagnoseMismatchedNewDelete(/*Deref*/$this(), new SourceLocation(DeleteLoc), Detector);
      break;
     case NoMismatch:
      break;
    }
  } finally {
    if (Detector != null) { Detector.$destroy(); }
  }
}

} // END OF class Sema_SemaExprCXX
