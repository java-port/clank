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
import org.clang.basic.*;
import org.clang.sema.*;
import org.clank.java.stdimpl.aliases.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstAttributesRTTI.*;
import org.clang.basic.java.OptionalNotes;


//<editor-fold defaultstate="collapsed" desc="static type SemaOverloadStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_SemaOverload_cpp_Unnamed_enum;_ZL11isTypeValidN5clang8QualTypeE;_ZL12IsOverloadedRKN5clang17UnresolvedSetImplE;_ZL13MakeValidatorRN5clang4SemaEPNS_10MemberExprEjbb;_ZL14hasSimilarTypeRN5clang10ASTContextENS_8QualTypeES2_;_ZL15AdoptQualifiersRN5clang10ASTContextENS_8QualTypeENS_10QualifiersE;_ZL16TryReferenceInitRN5clang4SemaEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbb;_ZL16recordConversionRN5clang4SemaENS_14SourceLocationERPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeEbRNS_14DeclAccessPairE;_ZL17DiagnoseBadTargetRN5clang4SemaEPNS_17OverloadCandidateE;_ZL17TryListConversionRN5clang4SemaEPNS_12InitListExprENS_8QualTypeEbbb;_ZL18CheckArityMismatchRN5clang4SemaEPNS_17OverloadCandidateEj;_ZL18IsVectorConversionRN5clang4SemaENS_8QualTypeES2_RNS_22ImplicitConversionKindE;_ZL19CollectVRQualifiersRN5clang10ASTContextEPNS_4ExprE;_ZL19tryAtomicConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_26StandardConversionSequenceEb;_ZL20DiagnoseBadDeductionRN5clang4SemaEPNS_17OverloadCandidateEjb;_ZL20DiagnoseBadDeductionRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclERNS_20DeductionFailureInfoEjb;_ZL20IsStandardConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_26StandardConversionSequenceEbb;_ZL20RankDeductionFailureRKN5clang20DeductionFailureInfoE;_ZL20compareEnableIfAttrsRKN5clang4SemaEPKNS_12FunctionDeclES5_;_ZL20getDescribedTemplatePN5clang4DeclE;_ZL21BuildRecoveryCallExprRN5clang4SemaEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES8_bb;_ZL21CreateFunctionRefExprRN5clang4SemaEPNS_12FunctionDeclEPNS_9NamedDeclEbNS_14SourceLocationERKNS_18DeclarationNameLocE;_ZL21DiagnoseArityMismatchRN5clang4SemaEPNS_17OverloadCandidateEj;_ZL21DiagnoseArityMismatchRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclEj;_ZL21DiagnoseBadConversionRN5clang4SemaEPNS_17OverloadCandidateEjb;_ZL21NoteFunctionCandidateRN5clang4SemaEPNS_17OverloadCandidateEjb;_ZL21TryCopyInitializationN5clang7CanQualINS_4TypeEEES2_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindE;_ZL21TryCopyInitializationRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbb;_ZL21TryImplicitConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbbbb;_ZL21dropPointerConversionRN5clang26StandardConversionSequenceE;_ZL22DiagnoseTwoPhaseLookupRN5clang4SemaENS_14SourceLocationERKNS_12CXXScopeSpecERNS_12LookupResultENS_20OverloadCandidateSet16CandidateSetKindEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEEPb;_ZL22NoteSurrogateCandidateRN5clang4SemaEPNS_17OverloadCandidateE;_ZL23GetLocationForCandidatePKN5clang17OverloadCandidateE;_ZL23GetLocationForCandidatePKN5clang21TemplateSpecCandidateE;_ZL23IsUserDefinedConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_29UserDefinedConversionSequenceERNS_20OverloadCandidateSetEbb;_ZL23getOrderedEnableIfAttrsPKN5clang12FunctionDeclE;_ZL23isFunctionAlwaysEnabledRKN5clang10ASTContextEPKNS_12FunctionDeclE;_ZL23tryGetFunctionProtoTypeN5clang8QualTypeE;_ZL24FindConversionForRefInitRN5clang4SemaERNS_26ImplicitConversionSequenceENS_8QualTypeENS_14SourceLocationEPNS_4ExprES4_bb;_ZL24FinishOverloadedCallExprRN5clang4SemaEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES8_S5_PNS_20OverloadCandidateSetEPPNS_17OverloadCandidateENS_17OverloadingResultEb;_ZL24TryUserDefinedConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbbbb;_ZL24canBeDeclaredInNamespaceRKN5clang15DeclarationNameE;_ZL25GetImplicitConversionNameN5clang22ImplicitConversionKindE;_ZL25IgnoreNarrowingConversionPKN5clang4ExprE;_ZL26AddOverloadedCallCandidateRN5clang4SemaENS_14DeclAccessPairEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbb;_ZL26CompleteNonViableCandidateRN5clang4SemaEPNS_17OverloadCandidateEN4llvm8ArrayRefIPNS_4ExprEEE;_ZL26DiagnoseFailedEnableIfAttrRN5clang4SemaEPNS_17OverloadCandidateE;_ZL26compareConversionFunctionsRN5clang4SemaEPNS_12FunctionDeclES3_;_ZL26diagnoseNoViableConversionRN5clang4SemaENS_14SourceLocationERPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeEbRNS_17UnresolvedSetImplE;_ZL27checkPlaceholderForOverloadRN5clang4SemaERPNS_4ExprEPN12_GLOBAL__N_117UnbridgedCastsSetE;_ZL27diagnoseAmbiguousConversionRN5clang4SemaENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeERNS_17UnresolvedSetImplE;_ZL28NoteAmbiguousUserConversionsRN5clang4SemaENS_14SourceLocationEPNS_17OverloadCandidateE;_ZL28NoteBuiltinOperatorCandidateRN5clang4SemaEN4llvm9StringRefENS_14SourceLocationEPNS_17OverloadCandidateE;_ZL28TryContextuallyConvertToBoolRN5clang4SemaEPNS_4ExprE;_ZL28isBetterReferenceBindingKindRKN5clang26StandardConversionSequenceES2_;_ZL29isAllowableExplicitConversionRN5clang4SemaENS_8QualTypeES2_b;_ZL30DiagnoseTwoPhaseOperatorLookupRN5clang4SemaENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE;_ZL31CompareDerivedToBaseConversionsRN5clang4SemaENS_14SourceLocationERKNS_26StandardConversionSequenceES5_;_ZL31CompareQualificationConversionsRN5clang4SemaERKNS_26StandardConversionSequenceES4_;_ZL31TryObjectArgumentInitializationRN5clang4SemaENS_14SourceLocationENS_8QualTypeENS_4Expr14ClassificationEPNS_13CXXMethodDeclEPNS_13CXXRecordDeclE;_ZL31checkArgPlaceholdersForOverloadRN5clang4SemaEN4llvm15MutableArrayRefIPNS_4ExprEEERN12_GLOBAL__N_117UnbridgedCastsSetE;_ZL31functionHasPassObjectSizeParamsPKN5clang12FunctionDeclE;_ZL32CheckConvertedConstantExpressionRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_7APValueENS0_7CCEKindEb;_ZL32compareStandardConversionSubsetsRN5clang10ASTContextERKNS_26StandardConversionSequenceES4_;_ZL33CheckConvertedConstantConversionsRN5clang4SemaERNS_26StandardConversionSequenceE;_ZL33checkAddressOfFunctionIsAvailableRN5clang4SemaEPKNS_12FunctionDeclEbbNS_14SourceLocationE;_ZL33collectViableConversionCandidatesRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_17UnresolvedSetImplERNS_20OverloadCandidateSetE;_ZL33isFirstArgumentCompatibleWithTypeRN5clang10ASTContextEPNS_18CXXConstructorDeclENS_8QualTypeE;_ZL34BuildSimilarlyQualifiedPointerTypePKN5clang4TypeENS_8QualTypeES3_RNS_10ASTContextEb;_ZL34CompareImplicitConversionSequencesRN5clang4SemaENS_14SourceLocationERKNS_26ImplicitConversionSequenceES5_;_ZL34CompareStandardConversionSequencesRN5clang4SemaENS_14SourceLocationERKNS_26StandardConversionSequenceES5_;_ZL34checkAddressOfCandidateIsAvailableRN5clang4SemaEPKNS_12FunctionDeclE;_ZL34finishContextualImplicitConversionRN5clang4SemaENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterE;_ZL34isNonTrivialObjCLifetimeConversionN5clang10QualifiersES0_;_ZL34isNullPointerConstantForConversionPN5clang4ExprEbRNS_10ASTContextE;_ZL35TryContextuallyConvertToObjCPointerRN5clang4SemaEPNS_4ExprE;_ZL35markUnaddressableCandidatesUnviableRN5clang4SemaERNS_20OverloadCandidateSetE;_ZL36IsTransparentUnionStandardConversionRN5clang4SemaEPNS_4ExprERNS_8QualTypeEbRNS_26StandardConversionSequenceEb;_ZL38AddBuiltinAssignmentOperatorCandidatesRN5clang4SemaENS_8QualTypeEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetE;_ZL38IsAcceptableNonMemberOperatorCandidateRN5clang10ASTContextEPNS_12FunctionDeclEN4llvm8ArrayRefIPNS_4ExprEEE;_ZL38IsInitializerListConstructorConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEPNS_13CXXRecordDeclERNS_29UserDefinedConversionSequenceERNS_20OverloadCandidateSetEb;_ZL45hasDeprecatedStringLiteralToCharPtrConversionRKN5clang26ImplicitConversionSequenceE;_ZN12_GLOBAL__N_125ClassifyOverloadCandidateERN5clang4SemaEPNS0_9NamedDeclEPNS0_12FunctionDeclERSs;_ZN12_GLOBAL__N_133MaybeEmitInheritedConstructorNoteERN5clang4SemaEPNS0_4DeclE; -static-type=SemaOverloadStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaOverloadStatics {

//<editor-fold defaultstate="collapsed" desc="functionHasPassObjectSizeParams">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 41,
 FQN="functionHasPassObjectSizeParams", NM="_ZL31functionHasPassObjectSizeParamsPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL31functionHasPassObjectSizeParamsPKN5clang12FunctionDeclE")
//</editor-fold>
public static boolean functionHasPassObjectSizeParams(/*const*/ FunctionDecl /*P*/ FD) {
  return llvm.any_of(FD.parameters$Const(), 
      //std.mem_fn(/*AddrOf*//*FPtr*/ParmVarDecl::<PassObjectSizeAttr>hasAttr)
      (ParmVarDecl param) -> param.hasAttr(PassObjectSizeAttr.class)
  );
}


/// A convenience routine for creating a decayed reference to a function.
//<editor-fold defaultstate="collapsed" desc="CreateFunctionRefExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 47,
 FQN="CreateFunctionRefExpr", NM="_ZL21CreateFunctionRefExprRN5clang4SemaEPNS_12FunctionDeclEPNS_9NamedDeclEbNS_14SourceLocationERKNS_18DeclarationNameLocE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21CreateFunctionRefExprRN5clang4SemaEPNS_12FunctionDeclEPNS_9NamedDeclEbNS_14SourceLocationERKNS_18DeclarationNameLocE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > CreateFunctionRefExpr(final Sema /*&*/ S, FunctionDecl /*P*/ Fn, NamedDecl /*P*/ FoundDecl, 
                     boolean HadMultipleCandidates) {
  return CreateFunctionRefExpr(S, Fn, FoundDecl, 
                     HadMultipleCandidates, 
                     new SourceLocation(), 
                     new DeclarationNameLoc());
}
public static ActionResultTTrue<Expr /*P*/ > CreateFunctionRefExpr(final Sema /*&*/ S, FunctionDecl /*P*/ Fn, NamedDecl /*P*/ FoundDecl, 
                     boolean HadMultipleCandidates, 
                     SourceLocation Loc/*= SourceLocation()*/) {
  return CreateFunctionRefExpr(S, Fn, FoundDecl, 
                     HadMultipleCandidates, 
                     Loc, 
                     new DeclarationNameLoc());
}
public static ActionResultTTrue<Expr /*P*/ > CreateFunctionRefExpr(final Sema /*&*/ S, FunctionDecl /*P*/ Fn, NamedDecl /*P*/ FoundDecl, 
                     boolean HadMultipleCandidates, 
                     SourceLocation Loc/*= SourceLocation()*/, 
                     final /*const*/ DeclarationNameLoc /*&*/ LocInfo/*= DeclarationNameLoc()*/) {
  if (S.DiagnoseUseOfDecl(FoundDecl, new SourceLocation(Loc))) {
    return ExprError();
  }
  // If FoundDecl is different from Fn (such as if one is a template
  // and the other a specialization), make sure DiagnoseUseOfDecl is 
  // called on both.
  // FIXME: This would be more comprehensively addressed by modifying
  // DiagnoseUseOfDecl to accept both the FoundDecl and the decl
  // being used.
  if (FoundDecl != Fn && S.DiagnoseUseOfDecl(Fn, new SourceLocation(Loc))) {
    return ExprError();
  }
  DeclRefExpr /*P*/ DRE = /*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->{
      return new DeclRefExpr(Fn, false, Fn.getType(), 
              ExprValueKind.VK_LValue, new SourceLocation(Loc), LocInfo);
   });
  if (HadMultipleCandidates) {
    DRE.setHadMultipleCandidates(true);
  }
  
  S.MarkDeclRefReferenced(DRE);
  return S.ImpCastExprToType(DRE, S.Context.getPointerType(DRE.getType()), 
      CastKind.CK_FunctionToPointerDecay);
}


/// IsStandardConversion - Determines whether there is a standard
/// conversion sequence (C++ [conv], C++ [over.ics.scs]) from the
/// expression From to the type ToType. Standard conversion sequences
/// only consider non-class types; for conversions that involve class
/// types, use TryImplicitConversion. If a conversion exists, SCS will
/// contain the standard conversion sequence required to perform this
/// conversion and this routine will return true. Otherwise, this
/// routine will return false and the value of SCS is unspecified.
//<editor-fold defaultstate="collapsed" desc="IsStandardConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1491,
 FQN="IsStandardConversion", NM="_ZL20IsStandardConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_26StandardConversionSequenceEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL20IsStandardConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_26StandardConversionSequenceEbb")
//</editor-fold>
public static boolean IsStandardConversion(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                    boolean InOverloadResolution, 
                    final StandardConversionSequence /*&*/ SCS, 
                    boolean CStyle, 
                    boolean AllowObjCWritebackConversion) {
  QualType FromType = From.getType();
  
  // Standard conversions (C++ [conv])
  SCS.setAsIdentityConversion();
  SCS.IncompatibleObjC = false;
  SCS.setFromType(new QualType(FromType));
  SCS.CopyConstructor = null;
  
  // There are no standard conversions for class types in C++, so
  // abort early. When overloading in C, however, we do permit them.
  if (S.getLangOpts().CPlusPlus
     && (FromType.$arrow().isRecordType() || ToType.$arrow().isRecordType())) {
    return false;
  }
  
  // The first conversion can be an lvalue-to-rvalue conversion,
  // array-to-pointer conversion, or function-to-pointer conversion
  // (C++ 4p1).
  if ($eq_QualType$C(FromType, S.Context.OverloadTy.$QualType())) {
    DeclAccessPair AccessPair/*J*/= new DeclAccessPair();
    {
      FunctionDecl /*P*/ Fn = S.ResolveAddressOfOverloadedFunction(From, new QualType(ToType), false, 
          AccessPair);
      if ((Fn != null)) {
        // We were able to resolve the address of the overloaded function,
        // so we can convert to the type of that function.
        FromType.$assignMove(Fn.getType());
        SCS.setFromType(new QualType(FromType));
        
        // we can sometimes resolve &foo<int> regardless of ToType, so check
        // if the type matches (identity) or we are converting to bool
        if (!S.Context.hasSameUnqualifiedType(S.ExtractUnqualifiedFunctionType(new QualType(ToType)), new QualType(FromType))) {
          QualType resultTy/*J*/= new QualType();
          // if the function type matches except for [[noreturn]], it's ok
          if (!S.IsNoReturnConversion(new QualType(FromType), 
              S.ExtractUnqualifiedFunctionType(new QualType(ToType)), resultTy)) {
            // otherwise, only a boolean conversion is standard   
            if (!ToType.$arrow().isBooleanType()) {
              return false;
            }
          }
        }
        
        // Check if the "from" expression is taking the address of an overloaded
        // function and recompute the FromType accordingly. Take advantage of the
        // fact that non-static member functions *must* have such an address-of
        // expression. 
        CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Fn);
        if ((Method != null) && !Method.isStatic()) {
          assert (isa_UnaryOperator(From.IgnoreParens())) : "Non-unary operator on non-static member address";
          assert (cast_UnaryOperator(From.IgnoreParens()).getOpcode() == UnaryOperatorKind.UO_AddrOf) : "Non-address-of operator on non-static member address";
          /*const*/ Type /*P*/ ClassType = S.Context.getTypeDeclType(Method.getParent()).getTypePtr();
          FromType.$assignMove(S.Context.getMemberPointerType(new QualType(FromType), ClassType));
        } else if (isa_UnaryOperator(From.IgnoreParens())) {
          assert (cast_UnaryOperator(From.IgnoreParens()).getOpcode() == UnaryOperatorKind.UO_AddrOf) : "Non-address-of operator for overloaded function expression";
          FromType.$assignMove(S.Context.getPointerType(new QualType(FromType)));
        }
        
        // Check that we've computed the proper type after overload resolution.
        assert (S.Context.hasSameType(new QualType(FromType), S.FixOverloadedFunctionReference(From, new DeclAccessPair(AccessPair), Fn).getType()));
      } else {
        return false;
      }
    }
  }
  // Lvalue-to-rvalue conversion (C++11 4.1):
  //   A glvalue (3.10) of a non-function, non-array type T can
  //   be converted to a prvalue.
  boolean argIsLValue = From.isGLValue();
  if (argIsLValue
     && !FromType.$arrow().isFunctionType() && !FromType.$arrow().isArrayType()
     && $noteq_CanQual$T_CanQual$U(S.Context.getCanonicalType(new QualType(FromType)), /*NO_COPY*/S.Context.OverloadTy)) {
    SCS.First = ImplicitConversionKind.ICK_Lvalue_To_Rvalue;
    {
      
      // C11 6.3.2.1p2:
      //   ... if the lvalue has atomic type, the value has the non-atomic version 
      //   of the type of the lvalue ...
      /*const*/ AtomicType /*P*/ Atomic = FromType.$arrow().getAs(AtomicType.class);
      if ((Atomic != null)) {
        FromType.$assignMove(Atomic.getValueType());
      }
    }
    
    // If T is a non-class type, the type of the rvalue is the
    // cv-unqualified version of T. Otherwise, the type of the rvalue
    // is T (C++ 4.1p1). C++ can't get here with class types; in C, we
    // just strip the qualifiers because they don't matter.
    FromType.$assignMove(FromType.getUnqualifiedType());
  } else if (FromType.$arrow().isArrayType()) {
    // Array-to-pointer conversion (C++ 4.2)
    SCS.First = ImplicitConversionKind.ICK_Array_To_Pointer;
    
    // An lvalue or rvalue of type "array of N T" or "array of unknown
    // bound of T" can be converted to an rvalue of type "pointer to
    // T" (C++ 4.2p1).
    FromType.$assignMove(S.Context.getArrayDecayedType(new QualType(FromType)));
    if (S.IsStringLiteralToNonConstPointerConversion(From, new QualType(ToType))) {
      // This conversion is deprecated in C++03 (D.4)
      SCS.DeprecatedStringLiteralToCharPtr = true;
      
      // For the purpose of ranking in overload resolution
      // (13.3.3.1.1), this conversion is considered an
      // array-to-pointer conversion followed by a qualification
      // conversion (4.4). (C++ 4.2p2)
      SCS.Second = ImplicitConversionKind.ICK_Identity;
      SCS.Third = ImplicitConversionKind.ICK_Qualification;
      SCS.QualificationIncludesObjCLifetime = false;
      SCS.setAllToTypes(new QualType(FromType));
      return true;
    }
  } else if (FromType.$arrow().isFunctionType() && argIsLValue) {
    // Function-to-pointer conversion (C++ 4.3).
    SCS.First = ImplicitConversionKind.ICK_Function_To_Pointer;
    {
      
      DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(From.IgnoreParenCasts());
      if ((DRE != null)) {
        {
          FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DRE.getDecl());
          if ((FD != null)) {
            if (!S.checkAddressOfFunctionIsAvailable(FD)) {
              return false;
            }
          }
        }
      }
    }
    
    // An lvalue of function type T can be converted to an rvalue of
    // type "pointer to T." The result is a pointer to the
    // function. (C++ 4.3p1).
    FromType.$assignMove(S.Context.getPointerType(new QualType(FromType)));
  } else {
    // We don't require any conversions for the first step.
    SCS.First = ImplicitConversionKind.ICK_Identity;
  }
  SCS.setToType(0, new QualType(FromType));
  
  // The second conversion can be an integral promotion, floating
  // point promotion, integral conversion, floating point conversion,
  // floating-integral conversion, pointer conversion,
  // pointer-to-member conversion, or boolean conversion (C++ 4p1).
  // For overloading in C, this can also be a "compatible-type"
  // conversion.
  bool$ref IncompatibleObjC = create_bool$ref(false);
  type$ref<ImplicitConversionKind> SecondICK = create_type$ref(ImplicitConversionKind.ICK_Identity);
  if (S.Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType))) {
    // The unqualified versions of the types are the same: there's no
    // conversion to do.
    SCS.Second = ImplicitConversionKind.ICK_Identity;
  } else if (S.IsIntegralPromotion(From, new QualType(FromType), new QualType(ToType))) {
    // Integral promotion (C++ 4.5).
    SCS.Second = ImplicitConversionKind.ICK_Integral_Promotion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (S.IsFloatingPointPromotion(new QualType(FromType), new QualType(ToType))) {
    // Floating point promotion (C++ 4.6).
    SCS.Second = ImplicitConversionKind.ICK_Floating_Promotion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (S.IsComplexPromotion(new QualType(FromType), new QualType(ToType))) {
    // Complex promotion (Clang extension)
    SCS.Second = ImplicitConversionKind.ICK_Complex_Promotion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (ToType.$arrow().isBooleanType()
     && (FromType.$arrow().isArithmeticType()
     || FromType.$arrow().isAnyPointerType()
     || FromType.$arrow().isBlockPointerType()
     || FromType.$arrow().isMemberPointerType()
     || FromType.$arrow().isNullPtrType())) {
    // Boolean conversions (C++ 4.12).
    SCS.Second = ImplicitConversionKind.ICK_Boolean_Conversion;
    FromType.$assignMove(S.Context.BoolTy.$QualType());
  } else if (FromType.$arrow().isIntegralOrUnscopedEnumerationType()
     && ToType.$arrow().isIntegralType(S.Context)) {
    // Integral conversions (C++ 4.7).
    SCS.Second = ImplicitConversionKind.ICK_Integral_Conversion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (FromType.$arrow().isAnyComplexType() && ToType.$arrow().isAnyComplexType()) {
    // Complex conversions (C99 6.3.1.6)
    SCS.Second = ImplicitConversionKind.ICK_Complex_Conversion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if ((FromType.$arrow().isAnyComplexType() && ToType.$arrow().isArithmeticType())
     || (ToType.$arrow().isAnyComplexType() && FromType.$arrow().isArithmeticType())) {
    // Complex-real conversions (C99 6.3.1.7)
    SCS.Second = ImplicitConversionKind.ICK_Complex_Real;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (FromType.$arrow().isRealFloatingType() && ToType.$arrow().isRealFloatingType()) {
    // FIXME: disable conversions between long double and __float128 if
    // their representation is different until there is back end support
    // We of course allow this conversion if long double is really double.
    if ($AddrOf(S.Context.getFloatTypeSemantics(new QualType(FromType)))
       != $AddrOf(S.Context.getFloatTypeSemantics(new QualType(ToType)))) {
      boolean Float128AndLongDouble = (($eq_QualType$C(FromType, S.Context.Float128Ty.$QualType())
         && $eq_QualType$C(ToType, S.Context.LongDoubleTy.$QualType()))
         || ($eq_QualType$C(FromType, S.Context.LongDoubleTy.$QualType())
         && $eq_QualType$C(ToType, S.Context.Float128Ty.$QualType())));
      if (Float128AndLongDouble
         && ($AddrOf(S.Context.getFloatTypeSemantics(S.Context.LongDoubleTy.$QualType()))
         != $AddrOf(APFloat.IEEEdouble))) {
        return false;
      }
    }
    // Floating point conversions (C++ 4.8).
    SCS.Second = ImplicitConversionKind.ICK_Floating_Conversion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if ((FromType.$arrow().isRealFloatingType()
     && ToType.$arrow().isIntegralType(S.Context))
     || (FromType.$arrow().isIntegralOrUnscopedEnumerationType()
     && ToType.$arrow().isRealFloatingType())) {
    // Floating-integral conversions (C++ 4.9).
    SCS.Second = ImplicitConversionKind.ICK_Floating_Integral;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (S.IsBlockPointerConversion(new QualType(FromType), new QualType(ToType), FromType)) {
    SCS.Second = ImplicitConversionKind.ICK_Block_Pointer_Conversion;
  } else if (AllowObjCWritebackConversion
     && S.isObjCWritebackConversion(new QualType(FromType), new QualType(ToType), FromType)) {
    SCS.Second = ImplicitConversionKind.ICK_Writeback_Conversion;
  } else if (S.IsPointerConversion(From, new QualType(FromType), new QualType(ToType), InOverloadResolution, 
      FromType, IncompatibleObjC)) {
    // Pointer conversions (C++ 4.10).
    SCS.Second = ImplicitConversionKind.ICK_Pointer_Conversion;
    SCS.IncompatibleObjC = IncompatibleObjC.$deref();
    FromType.$assignMove(FromType.getUnqualifiedType());
  } else if (S.IsMemberPointerConversion(From, new QualType(FromType), new QualType(ToType), 
      InOverloadResolution, FromType)) {
    // Pointer to member conversions (4.11).
    SCS.Second = ImplicitConversionKind.ICK_Pointer_Member;
  } else if (IsVectorConversion(S, new QualType(FromType), new QualType(ToType), SecondICK)) {
    SCS.Second = SecondICK.$deref();
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (!S.getLangOpts().CPlusPlus
     && S.Context.typesAreCompatible(new QualType(ToType), new QualType(FromType))) {
    // Compatible conversions (Clang extension for C function overloading)
    SCS.Second = ImplicitConversionKind.ICK_Compatible_Conversion;
    FromType.$assignMove(ToType.getUnqualifiedType());
  } else if (S.IsNoReturnConversion(new QualType(FromType), new QualType(ToType), FromType)) {
    // Treat a conversion that strips "noreturn" as an identity conversion.
    SCS.Second = ImplicitConversionKind.ICK_NoReturn_Adjustment;
  } else if (IsTransparentUnionStandardConversion(S, From, ToType, 
      InOverloadResolution, 
      SCS, CStyle)) {
    SCS.Second = ImplicitConversionKind.ICK_TransparentUnionConversion;
    FromType.$assign(ToType);
  } else if (tryAtomicConversion(S, From, new QualType(ToType), InOverloadResolution, SCS, 
      CStyle)) {
    // tryAtomicConversion has updated the standard conversion sequence
    // appropriately.
    return true;
  } else if (ToType.$arrow().isEventT()
     && From.isIntegerConstantExpr(S.getASTContext())
     && From.EvaluateKnownConstInt(S.getASTContext()).$eq(0)) {
    SCS.Second = ImplicitConversionKind.ICK_Zero_Event_Conversion;
    FromType.$assign(ToType);
  } else {
    // No second conversion required.
    SCS.Second = ImplicitConversionKind.ICK_Identity;
  }
  SCS.setToType(1, new QualType(FromType));
  
  QualType CanonFrom/*J*/= new QualType();
  QualType CanonTo/*J*/= new QualType();
  // The third conversion can be a qualification conversion (C++ 4p1).
  bool$ref ObjCLifetimeConversion = create_bool$ref();
  if (S.IsQualificationConversion(new QualType(FromType), new QualType(ToType), CStyle, 
      ObjCLifetimeConversion)) {
    SCS.Third = ImplicitConversionKind.ICK_Qualification;
    SCS.QualificationIncludesObjCLifetime = ObjCLifetimeConversion.$deref();
    FromType.$assign(ToType);
    CanonFrom.$assignMove(S.Context.getCanonicalType(new QualType(FromType)).$QualType());
    CanonTo.$assignMove(S.Context.getCanonicalType(new QualType(ToType)).$QualType());
  } else {
    // No conversion required
    SCS.Third = ImplicitConversionKind.ICK_Identity;
    
    // C++ [over.best.ics]p6:
    //   [...] Any difference in top-level cv-qualification is
    //   subsumed by the initialization itself and does not constitute
    //   a conversion. [...]
    CanonFrom.$assignMove(S.Context.getCanonicalType(new QualType(FromType)).$QualType());
    CanonTo.$assignMove(S.Context.getCanonicalType(new QualType(ToType)).$QualType());
    if ($eq_QualType$C(CanonFrom.getLocalUnqualifiedType(), 
        CanonTo.getLocalUnqualifiedType())
       && CanonFrom.getLocalQualifiers().$noteq(CanonTo.getLocalQualifiers())) {
      FromType.$assign(ToType);
      CanonFrom.$assign(CanonTo);
    }
  }
  SCS.setToType(2, new QualType(FromType));
  if ($eq_QualType$C(CanonFrom, CanonTo)) {
    return true;
  }
  
  // If we have not converted the argument type to the parameter type,
  // this is a bad conversion sequence, unless we're resolving an overload in C.
  if (S.getLangOpts().CPlusPlus || !InOverloadResolution) {
    return false;
  }
  
  ActionResultTTrue<Expr /*P*/ > ER = /*{ */new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From)/* }*/;
  Sema.AssignConvertType Conv = S.CheckSingleAssignmentConstraints(new QualType(ToType), ER, 
      /*Diagnose=*/ false, 
      /*DiagnoseCFAudited=*/ false, 
      /*ConvertRHS=*/ false);
  if (Conv != Sema.AssignConvertType.Compatible) {
    return false;
  }
  
  SCS.setAllToTypes(new QualType(ToType));
  // We need to set all three because we want this conversion to rank terribly,
  // and we don't know what conversions it may overlap with.
  SCS.First = ImplicitConversionKind.ICK_C_Only_Conversion;
  SCS.Second = ImplicitConversionKind.ICK_C_Only_Conversion;
  SCS.Third = ImplicitConversionKind.ICK_C_Only_Conversion;
  return true;
}

//<editor-fold defaultstate="collapsed" desc="IsTransparentUnionStandardConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1802,
 FQN="IsTransparentUnionStandardConversion", NM="_ZL36IsTransparentUnionStandardConversionRN5clang4SemaEPNS_4ExprERNS_8QualTypeEbRNS_26StandardConversionSequenceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL36IsTransparentUnionStandardConversionRN5clang4SemaEPNS_4ExprERNS_8QualTypeEbRNS_26StandardConversionSequenceEb")
//</editor-fold>
public static boolean IsTransparentUnionStandardConversion(final Sema /*&*/ S, Expr /*P*/ From, 
                                    final QualType /*&*/ ToType, 
                                    boolean InOverloadResolution, 
                                    final StandardConversionSequence /*&*/ SCS, 
                                    boolean CStyle) {
  
  /*const*/ RecordType /*P*/ UT = ToType.$arrow().getAsUnionType();
  if (!(UT != null) || !UT.getDecl().hasAttr(TransparentUnionAttr.class)) {
    return false;
  }
  // The field to initialize within the transparent union.
  RecordDecl /*P*/ UD = UT.getDecl();
  // It's compatible if the expression matches any of the fields.
  for (/*const*/ FieldDecl /*P*/ it : UD.fields()) {
    if (IsStandardConversion(S, From, it.getType(), InOverloadResolution, SCS, 
        CStyle, /*ObjCWritebackConversion=*/ false)) {
      ToType.$assignMove(it.getType());
      return true;
    }
  }
  return false;
}


/// Determines whether there is a user-defined conversion sequence
/// (C++ [over.ics.user]) that converts expression From to the type
/// ToType. If such a conversion exists, User will contain the
/// user-defined conversion sequence that performs such a conversion
/// and this routine will return true. Otherwise, this routine returns
/// false and User is unspecified.
///
/// \param AllowExplicit  true if the conversion should consider C++0x
/// "explicit" conversion functions as well as non-explicit conversion
/// functions (C++0x [class.conv.fct]p2).
///
/// \param AllowObjCConversionOnExplicit true if the conversion should
/// allow an extra Objective-C pointer conversion on uses of explicit
/// constructors. Requires \c AllowExplicit to also be set.
//<editor-fold defaultstate="collapsed" desc="IsUserDefinedConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3124,
 FQN="IsUserDefinedConversion", NM="_ZL23IsUserDefinedConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_29UserDefinedConversionSequenceERNS_20OverloadCandidateSetEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL23IsUserDefinedConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_29UserDefinedConversionSequenceERNS_20OverloadCandidateSetEbb")
//</editor-fold>
public static OverloadingResult IsUserDefinedConversion(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                       final UserDefinedConversionSequence /*&*/ User, 
                       final OverloadCandidateSet /*&*/ CandidateSet, 
                       boolean AllowExplicit, 
                       boolean AllowObjCConversionOnExplicit) {
  assert (AllowExplicit || !AllowObjCConversionOnExplicit);
  
  // Whether we will only visit constructors.
  boolean ConstructorsOnly = false;
  {
    
    // If the type we are conversion to is a class type, enumerate its
    // constructors.
    /*const*/ RecordType /*P*/ ToRecordType = ToType.$arrow().<RecordType>getAs$RecordType();
    if ((ToRecordType != null)) {
      // C++ [over.match.ctor]p1:
      //   When objects of class type are direct-initialized (8.5), or
      //   copy-initialized from an expression of the same or a
      //   derived class type (8.5), overload resolution selects the
      //   constructor. [...] For copy-initialization, the candidate
      //   functions are all the converting constructors (12.3.1) of
      //   that class. The argument list is the expression-list within
      //   the parentheses of the initializer.
      if (S.Context.hasSameUnqualifiedType(new QualType(ToType), From.getType())
         || ((From.getType().$arrow().<RecordType>getAs$RecordType() != null)
         && S.IsDerivedFrom(From.getLocStart(), From.getType(), new QualType(ToType)))) {
        ConstructorsOnly = true;
      }
      if (!S.isCompleteType(From.getExprLoc(), new QualType(ToType))) {
        // We're not going to find any constructors.
      } else {
        CXXRecordDecl /*P*/ ToRecordDecl = dyn_cast_CXXRecordDecl(ToRecordType.getDecl());
        if ((ToRecordDecl != null)) {
          
          type$ptr<Expr/*P*/> Args = create_type$ptr($tryClone($AddrOf(From)));
          /*uint*/int NumArgs = 1;
          boolean ListInitializing = false;
          {
            InitListExpr /*P*/ InitList = dyn_cast_InitListExpr(From);
            if ((InitList != null)) {
              // But first, see if there is an init-list-constructor that will work.
              OverloadingResult Result = IsInitializerListConstructorConversion(S, From, new QualType(ToType), ToRecordDecl, User, CandidateSet, AllowExplicit);
              if (Result != OverloadingResult.OR_No_Viable_Function) {
                return Result;
              }
              // Never mind.
              CandidateSet.clear();
              
              // If we're list-initializing, we pass the individual elements as
              // arguments, not the entire list.
              Args = $tryClone(InitList.getInits());
              NumArgs = InitList.getNumInits();
              ListInitializing = true;
            }
          }
          
          for (NamedDecl /*P*/ D : S.LookupConstructors(ToRecordDecl)) {
            ConstructorInfo Info = getConstructorInfo(D);
            if (!Info.$bool()) {
              continue;
            }
            
            boolean Usable = !Info.Constructor.isInvalidDecl();
            if (ListInitializing) {
              Usable = Usable && (AllowExplicit || !Info.Constructor.isExplicit());
            } else {
              Usable = Usable
                 && Info.Constructor.isConvertingConstructor(AllowExplicit);
            }
            if (Usable) {
              boolean SuppressUserConversions = !ConstructorsOnly;
              if (SuppressUserConversions && ListInitializing) {
                SuppressUserConversions = false;
                if (NumArgs == 1) {
                  // If the first argument is (a reference to) the target type,
                  // suppress conversions.
                  SuppressUserConversions = isFirstArgumentCompatibleWithType(S.Context, Info.Constructor, new QualType(ToType));
                }
              }
              if ((Info.ConstructorTmpl != null)) {
                S.AddTemplateOverloadCandidate(Info.ConstructorTmpl, new DeclAccessPair(Info.FoundDecl), 
                    /*ExplicitArgs*/ (TemplateArgumentListInfo /*P*/ )null, llvm.makeArrayRef(Args, NumArgs), 
                    CandidateSet, SuppressUserConversions);
              } else {
                // Allow one user-defined conversion when user specifies a
                // From->ToType conversion via an static cast (c-style, etc).
                S.AddOverloadCandidate(Info.Constructor, new DeclAccessPair(Info.FoundDecl), 
                    llvm.makeArrayRef(Args, NumArgs), 
                    CandidateSet, SuppressUserConversions);
              }
            }
          }
        }
      }
    }
  }
  
  // Enumerate conversion functions, if we're allowed to.
  if (ConstructorsOnly || isa_InitListExpr(From)) {
  } else if (!S.isCompleteType(From.getLocStart(), From.getType())) {
    // No conversion functions from incomplete types.
  } else {
    /*const*/ RecordType /*P*/ FromRecordType = From.getType().$arrow().<RecordType>getAs$RecordType();
    if ((FromRecordType != null)) {
      {
        CXXRecordDecl /*P*/ FromRecordDecl = dyn_cast_CXXRecordDecl(FromRecordType.getDecl());
        if ((FromRecordDecl != null)) {
          // Add all of the conversion functions as candidates.
          final /*const*/ iterator_range<NamedDecl /*P*/ > /*&*/ Conversions = FromRecordDecl.getVisibleConversionFunctions();
          for (UnresolvedSetIterator I = (UnresolvedSetIterator)Conversions.begin(), E = (UnresolvedSetIterator)Conversions.end(); I.$noteq(E); I.$preInc()) {
            DeclAccessPair FoundDecl = new DeclAccessPair(I.getPair());
            NamedDecl /*P*/ D = FoundDecl.getDecl();
            CXXRecordDecl /*P*/ ActingContext = cast_CXXRecordDecl(D.getDeclContext());
            if (isa_UsingShadowDecl(D)) {
              D = cast_UsingShadowDecl(D).getTargetDecl();
            }
            
            CXXConversionDecl /*P*/ Conv;
            FunctionTemplateDecl /*P*/ ConvTemplate;
            if (((ConvTemplate = dyn_cast_FunctionTemplateDecl(D)) != null)) {
              Conv = cast_CXXConversionDecl(ConvTemplate.getTemplatedDecl());
            } else {
              Conv = cast_CXXConversionDecl(D);
            }
            if (AllowExplicit || !Conv.isExplicit()) {
              if ((ConvTemplate != null)) {
                S.AddTemplateConversionCandidate(ConvTemplate, new DeclAccessPair(FoundDecl), 
                    ActingContext, From, new QualType(ToType), 
                    CandidateSet, 
                    AllowObjCConversionOnExplicit);
              } else {
                S.AddConversionCandidate(Conv, new DeclAccessPair(FoundDecl), ActingContext, 
                    From, new QualType(ToType), CandidateSet, 
                    AllowObjCConversionOnExplicit);
              }
            }
          }
        }
      }
    }
  }
  
  boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
  
  final type$ptr<OverloadCandidate> Best = create_type$ptr();
  {
    OverloadingResult Result = CandidateSet.BestViableFunction(S, From.getLocStart(), 
        Best, true);
    switch (Result) {
     case OR_Success:
     case OR_Deleted:
      {
        // Record the standard conversion we used and the conversion function.
        CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(Best./*->*/$star().Function);
        if ((Constructor != null)) {
          // C++ [over.ics.user]p1:
          //   If the user-defined conversion is specified by a
          //   constructor (12.3.1), the initial standard conversion
          //   sequence converts the source type to the type required by
          //   the argument of the constructor.
          //
          QualType ThisType = Constructor.getThisType(S.Context);
          if (isa_InitListExpr(From)) {
            // Initializer lists don't have conversions as such.
            User.Before.setAsIdentityConversion();
          } else {
            if (Best./*->*/$star().Conversions[0].isEllipsis()) {
              User.EllipsisConversion = true;
            } else {
              User.Before.$assign(Best./*->*/$star().Conversions[0].Unnamed_field2.Standard);
              User.EllipsisConversion = false;
            }
          }
          User.HadMultipleCandidates = HadMultipleCandidates;
          User.ConversionFunction = Constructor;
          User.FoundConversionFunction.$assign(Best./*->*/$star().FoundDecl);
          User.After.setAsIdentityConversion();
          User.After.setFromType(ThisType.$arrow().getAs(PointerType.class).getPointeeType());
          User.After.setAllToTypes(new QualType(ToType));
          return Result;
        }
      }
      {
        CXXConversionDecl /*P*/ Conversion = dyn_cast_CXXConversionDecl(Best./*->*/$star().Function);
        if ((Conversion != null)) {
          // C++ [over.ics.user]p1:
          //
          //   [...] If the user-defined conversion is specified by a
          //   conversion function (12.3.2), the initial standard
          //   conversion sequence converts the source type to the
          //   implicit object parameter of the conversion function.
          User.Before.$assign(Best./*->*/$star().Conversions[0].Unnamed_field2.Standard);
          User.HadMultipleCandidates = HadMultipleCandidates;
          User.ConversionFunction = Conversion;
          User.FoundConversionFunction.$assign(Best./*->*/$star().FoundDecl);
          User.EllipsisConversion = false;
          
          // C++ [over.ics.user]p2:
          //   The second standard conversion sequence converts the
          //   result of the user-defined conversion to the target type
          //   for the sequence. Since an implicit conversion sequence
          //   is an initialization, the special rules for
          //   initialization by user-defined conversion apply when
          //   selecting the best user-defined conversion for a
          //   user-defined conversion sequence (see 13.3.3 and
          //   13.3.3.1).
          User.After.$assign(Best./*->*/$star().Unnamed_field12.FinalConversion);
          return Result;
        }
      }
      throw new llvm_unreachable("Not a constructor or conversion function?");
     case OR_No_Viable_Function:
      return OverloadingResult.OR_No_Viable_Function;
     case OR_Ambiguous:
      return OverloadingResult.OR_Ambiguous;
    }
  }
  throw new llvm_unreachable("Invalid OverloadResult!");
}


/// CompareStandardConversionSequences - Compare two standard
/// conversion sequences to determine whether one is better than the
/// other or if they are indistinguishable (C++ 13.3.3.2p3).
//<editor-fold defaultstate="collapsed" desc="CompareStandardConversionSequences">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3582,
 FQN="CompareStandardConversionSequences", NM="_ZL34CompareStandardConversionSequencesRN5clang4SemaENS_14SourceLocationERKNS_26StandardConversionSequenceES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34CompareStandardConversionSequencesRN5clang4SemaENS_14SourceLocationERKNS_26StandardConversionSequenceES5_")
//</editor-fold>
public static ImplicitConversionSequence.CompareKind CompareStandardConversionSequences(final Sema /*&*/ S, SourceLocation Loc, 
                                  final /*const*/ StandardConversionSequence /*&*/ SCS1, 
                                  final /*const*/ StandardConversionSequence /*&*/ SCS2) {
  {
    // Standard conversion sequence S1 is a better conversion sequence
    // than standard conversion sequence S2 if (C++ 13.3.3.2p3):
    
    //  -- S1 is a proper subsequence of S2 (comparing the conversion
    //     sequences in the canonical form defined by 13.3.3.1.1,
    //     excluding any Lvalue Transformation; the identity conversion
    //     sequence is considered to be a subsequence of any
    //     non-identity conversion sequence) or, if not that,
    ImplicitConversionSequence.CompareKind CK = compareStandardConversionSubsets(S.Context, SCS1, SCS2);
    if ((CK.getValue() != 0)) {
      return CK;
    }
  }
  
  //  -- the rank of S1 is better than the rank of S2 (by the rules
  //     defined below), or, if not that,
  ImplicitConversionRank Rank1 = SCS1.getRank();
  ImplicitConversionRank Rank2 = SCS2.getRank();
  if (Rank1.getValue() < Rank2.getValue()) {
    return ImplicitConversionSequence.CompareKind.Better;
  } else if (Rank2.getValue() < Rank1.getValue()) {
    return ImplicitConversionSequence.CompareKind.Worse;
  }
  
  // (C++ 13.3.3.2p4): Two conversion sequences with the same rank
  // are indistinguishable unless one of the following rules
  // applies:
  
  //   A conversion that is not a conversion of a pointer, or
  //   pointer to member, to bool is better than another conversion
  //   that is such a conversion.
  if (SCS1.isPointerConversionToBool() != SCS2.isPointerConversionToBool()) {
    return SCS2.isPointerConversionToBool() ? ImplicitConversionSequence.CompareKind.Better : ImplicitConversionSequence.CompareKind.Worse;
  }
  
  // C++ [over.ics.rank]p4b2:
  //
  //   If class B is derived directly or indirectly from class A,
  //   conversion of B* to A* is better than conversion of B* to
  //   void*, and conversion of A* to void* is better than conversion
  //   of B* to void*.
  boolean SCS1ConvertsToVoid = SCS1.isPointerConversionToVoidPointer(S.Context);
  boolean SCS2ConvertsToVoid = SCS2.isPointerConversionToVoidPointer(S.Context);
  if (SCS1ConvertsToVoid != SCS2ConvertsToVoid) {
    // Exactly one of the conversion sequences is a conversion to
    // a void pointer; it's the worse conversion.
    return SCS2ConvertsToVoid ? ImplicitConversionSequence.CompareKind.Better : ImplicitConversionSequence.CompareKind.Worse;
  } else if (!SCS1ConvertsToVoid && !SCS2ConvertsToVoid) {
    {
      // Neither conversion sequence converts to a void pointer; compare
      // their derived-to-base conversions.
      ImplicitConversionSequence.CompareKind DerivedCK = CompareDerivedToBaseConversions(S, new SourceLocation(Loc), SCS1, SCS2);
      if ((DerivedCK.getValue() != 0)) {
        return DerivedCK;
      }
    }
  } else if (SCS1ConvertsToVoid && SCS2ConvertsToVoid
     && !S.Context.hasSameType(SCS1.getFromType(), SCS2.getFromType())) {
    // Both conversion sequences are conversions to void
    // pointers. Compare the source types to determine if there's an
    // inheritance relationship in their sources.
    QualType FromType1 = SCS1.getFromType();
    QualType FromType2 = SCS2.getFromType();
    
    // Adjust the types we're converting from via the array-to-pointer
    // conversion, if we need to.
    if (SCS1.First == ImplicitConversionKind.ICK_Array_To_Pointer) {
      FromType1.$assignMove(S.Context.getArrayDecayedType(new QualType(FromType1)));
    }
    if (SCS2.First == ImplicitConversionKind.ICK_Array_To_Pointer) {
      FromType2.$assignMove(S.Context.getArrayDecayedType(new QualType(FromType2)));
    }
    
    QualType FromPointee1 = FromType1.$arrow().getPointeeType().getUnqualifiedType();
    QualType FromPointee2 = FromType2.$arrow().getPointeeType().getUnqualifiedType();
    if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromPointee2), new QualType(FromPointee1))) {
      return ImplicitConversionSequence.CompareKind.Better;
    } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromPointee1), new QualType(FromPointee2))) {
      return ImplicitConversionSequence.CompareKind.Worse;
    }
    
    // Objective-C++: If one interface is more specific than the
    // other, it is the better one.
    /*const*/ ObjCObjectPointerType /*P*/ FromObjCPtr1 = FromType1.$arrow().getAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ FromObjCPtr2 = FromType2.$arrow().getAs(ObjCObjectPointerType.class);
    if ((FromObjCPtr1 != null) && (FromObjCPtr2 != null)) {
      boolean AssignLeft = S.Context.canAssignObjCInterfaces(FromObjCPtr1, 
          FromObjCPtr2);
      boolean AssignRight = S.Context.canAssignObjCInterfaces(FromObjCPtr2, 
          FromObjCPtr1);
      if (AssignLeft != AssignRight) {
        return AssignLeft ? ImplicitConversionSequence.CompareKind.Better : ImplicitConversionSequence.CompareKind.Worse;
      }
    }
  }
  {
    
    // Compare based on qualification conversions (C++ 13.3.3.2p3,
    // bullet 3).
    ImplicitConversionSequence.CompareKind QualCK = CompareQualificationConversions(S, SCS1, SCS2);
    if ((QualCK.getValue() != 0)) {
      return QualCK;
    }
  }
  if (SCS1.ReferenceBinding && SCS2.ReferenceBinding) {
    // Check for a better reference binding based on the kind of bindings.
    if (isBetterReferenceBindingKind(SCS1, SCS2)) {
      return ImplicitConversionSequence.CompareKind.Better;
    } else if (isBetterReferenceBindingKind(SCS2, SCS1)) {
      return ImplicitConversionSequence.CompareKind.Worse;
    }
    
    // C++ [over.ics.rank]p3b4:
    //   -- S1 and S2 are reference bindings (8.5.3), and the types to
    //      which the references refer are the same type except for
    //      top-level cv-qualifiers, and the type to which the reference
    //      initialized by S2 refers is more cv-qualified than the type
    //      to which the reference initialized by S1 refers.
    QualType T1 = SCS1.getToType(2);
    QualType T2 = SCS2.getToType(2);
    T1.$assignMove(S.Context.getCanonicalType(new QualType(T1)).$QualType());
    T2.$assignMove(S.Context.getCanonicalType(new QualType(T2)).$QualType());
    Qualifiers T1Quals/*J*/= new Qualifiers(), T2Quals/*J*/= new Qualifiers();
    QualType UnqualT1 = S.Context.getUnqualifiedArrayType(new QualType(T1), T1Quals);
    QualType UnqualT2 = S.Context.getUnqualifiedArrayType(new QualType(T2), T2Quals);
    if ($eq_QualType$C(UnqualT1, UnqualT2)) {
      // Objective-C++ ARC: If the references refer to objects with different
      // lifetimes, prefer bindings that don't change lifetime.
      if (SCS1.ObjCLifetimeConversionBinding
         != SCS2.ObjCLifetimeConversionBinding) {
        return SCS1.ObjCLifetimeConversionBinding ? ImplicitConversionSequence.CompareKind.Worse : ImplicitConversionSequence.CompareKind.Better;
      }
      
      // If the type is an array type, promote the element qualifiers to the
      // type for comparison.
      if (isa_ArrayType(T1) && T1Quals.$bool()) {
        T1.$assignMove(S.Context.getQualifiedType(new QualType(UnqualT1), new Qualifiers(T1Quals)));
      }
      if (isa_ArrayType(T2) && T2Quals.$bool()) {
        T2.$assignMove(S.Context.getQualifiedType(new QualType(UnqualT2), new Qualifiers(T2Quals)));
      }
      if (T2.isMoreQualifiedThan(new QualType(T1))) {
        return ImplicitConversionSequence.CompareKind.Better;
      } else if (T1.isMoreQualifiedThan(new QualType(T2))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
    }
  }
  
  // In Microsoft mode, prefer an integral conversion to a
  // floating-to-integral conversion if the integral conversion
  // is between types of the same size.
  // For example:
  // void f(float);
  // void f(int);
  // int main {
  //    long a;
  //    f(a);
  // }
  // Here, MSVC will call f(int) instead of generating a compile error
  // as clang will do in standard mode.
  if (S.getLangOpts().MSVCCompat && SCS1.Second == ImplicitConversionKind.ICK_Integral_Conversion
     && SCS2.Second == ImplicitConversionKind.ICK_Floating_Integral
     && S.Context.getTypeSize(SCS1.getFromType())
     == S.Context.getTypeSize(SCS1.getToType(2))) {
    return ImplicitConversionSequence.CompareKind.Better;
  }
  
  return ImplicitConversionSequence.CompareKind.Indistinguishable;
}


/// CompareQualificationConversions - Compares two standard conversion
/// sequences to determine whether they can be ranked based on their
/// qualification conversions (C++ 13.3.3.2p3 bullet 3).
//<editor-fold defaultstate="collapsed" desc="CompareQualificationConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3755,
 FQN="CompareQualificationConversions", NM="_ZL31CompareQualificationConversionsRN5clang4SemaERKNS_26StandardConversionSequenceES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL31CompareQualificationConversionsRN5clang4SemaERKNS_26StandardConversionSequenceES4_")
//</editor-fold>
public static ImplicitConversionSequence.CompareKind CompareQualificationConversions(final Sema /*&*/ S, 
                               final /*const*/ StandardConversionSequence /*&*/ SCS1, 
                               final /*const*/ StandardConversionSequence /*&*/ SCS2) {
  // C++ 13.3.3.2p3:
  //  -- S1 and S2 differ only in their qualification conversion and
  //     yield similar types T1 and T2 (C++ 4.4), respectively, and the
  //     cv-qualification signature of type T1 is a proper subset of
  //     the cv-qualification signature of type T2, and S1 is not the
  //     deprecated string literal array-to-pointer conversion (4.2).
  if (SCS1.First != SCS2.First || SCS1.Second != SCS2.Second
     || SCS1.Third != SCS2.Third || SCS1.Third != ImplicitConversionKind.ICK_Qualification) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  
  // FIXME: the example in the standard doesn't use a qualification
  // conversion (!)
  QualType T1 = SCS1.getToType(2);
  QualType T2 = SCS2.getToType(2);
  T1.$assignMove(S.Context.getCanonicalType(new QualType(T1)).$QualType());
  T2.$assignMove(S.Context.getCanonicalType(new QualType(T2)).$QualType());
  Qualifiers T1Quals/*J*/= new Qualifiers(), T2Quals/*J*/= new Qualifiers();
  QualType UnqualT1 = S.Context.getUnqualifiedArrayType(new QualType(T1), T1Quals);
  QualType UnqualT2 = S.Context.getUnqualifiedArrayType(new QualType(T2), T2Quals);
  
  // If the types are the same, we won't learn anything by unwrapped
  // them.
  if ($eq_QualType$C(UnqualT1, UnqualT2)) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  
  // If the type is an array type, promote the element qualifiers to the type
  // for comparison.
  if (isa_ArrayType(T1) && T1Quals.$bool()) {
    T1.$assignMove(S.Context.getQualifiedType(new QualType(UnqualT1), new Qualifiers(T1Quals)));
  }
  if (isa_ArrayType(T2) && T2Quals.$bool()) {
    T2.$assignMove(S.Context.getQualifiedType(new QualType(UnqualT2), new Qualifiers(T2Quals)));
  }
  
  ImplicitConversionSequence.CompareKind Result = ImplicitConversionSequence.CompareKind.Indistinguishable;
  
  // Objective-C++ ARC:
  //   Prefer qualification conversions not involving a change in lifetime
  //   to qualification conversions that do not change lifetime.
  if (SCS1.QualificationIncludesObjCLifetime
     != SCS2.QualificationIncludesObjCLifetime) {
    Result = SCS1.QualificationIncludesObjCLifetime ? ImplicitConversionSequence.CompareKind.Worse : ImplicitConversionSequence.CompareKind.Better;
  }
  while (S.Context.UnwrapSimilarPointerTypes(T1, T2)) {
    // Within each iteration of the loop, we check the qualifiers to
    // determine if this still looks like a qualification
    // conversion. Then, if all is well, we unwrap one more level of
    // pointers or pointers-to-members and do it all again
    // until there are no more pointers or pointers-to-members left
    // to unwrap. This essentially mimics what
    // IsQualificationConversion does, but here we're checking for a
    // strict subset of qualifiers.
    if (T1.getCVRQualifiers() == T2.getCVRQualifiers()) {
      // The qualifiers are the same, so this doesn't tell us anything
      // about how the sequences rank.
      ;
    } else if (T2.isMoreQualifiedThan(new QualType(T1))) {
      // T1 has fewer qualifiers, so it could be the better sequence.
      if (Result == ImplicitConversionSequence.CompareKind.Worse) {
        // Neither has qualifiers that are a subset of the other's
        // qualifiers.
        return ImplicitConversionSequence.CompareKind.Indistinguishable;
      }
      
      Result = ImplicitConversionSequence.CompareKind.Better;
    } else if (T1.isMoreQualifiedThan(new QualType(T2))) {
      // T2 has fewer qualifiers, so it could be the better sequence.
      if (Result == ImplicitConversionSequence.CompareKind.Better) {
        // Neither has qualifiers that are a subset of the other's
        // qualifiers.
        return ImplicitConversionSequence.CompareKind.Indistinguishable;
      }
      
      Result = ImplicitConversionSequence.CompareKind.Worse;
    } else {
      // Qualifiers are disjoint.
      return ImplicitConversionSequence.CompareKind.Indistinguishable;
    }
    
    // If the types after this point are equivalent, we're done.
    if (S.Context.hasSameUnqualifiedType(new QualType(T1), new QualType(T2))) {
      break;
    }
  }
  
  // Check that the winning standard conversion sequence isn't using
  // the deprecated string literal array to pointer conversion.
  switch (Result) {
   case Better:
    if (SCS1.DeprecatedStringLiteralToCharPtr) {
      Result = ImplicitConversionSequence.CompareKind.Indistinguishable;
    }
    break;
   case Indistinguishable:
    break;
   case Worse:
    if (SCS2.DeprecatedStringLiteralToCharPtr) {
      Result = ImplicitConversionSequence.CompareKind.Indistinguishable;
    }
    break;
  }
  
  return Result;
}


/// CompareDerivedToBaseConversions - Compares two standard conversion
/// sequences to determine whether they can be ranked based on their
/// various kinds of derived-to-base conversions (C++
/// [over.ics.rank]p4b3).  As part of these checks, we also look at
/// conversions between Objective-C interface types.
//<editor-fold defaultstate="collapsed" desc="CompareDerivedToBaseConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3868,
 FQN="CompareDerivedToBaseConversions", NM="_ZL31CompareDerivedToBaseConversionsRN5clang4SemaENS_14SourceLocationERKNS_26StandardConversionSequenceES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL31CompareDerivedToBaseConversionsRN5clang4SemaENS_14SourceLocationERKNS_26StandardConversionSequenceES5_")
//</editor-fold>
public static ImplicitConversionSequence.CompareKind CompareDerivedToBaseConversions(final Sema /*&*/ S, SourceLocation Loc, 
                               final /*const*/ StandardConversionSequence /*&*/ SCS1, 
                               final /*const*/ StandardConversionSequence /*&*/ SCS2) {
  QualType FromType1 = SCS1.getFromType();
  QualType ToType1 = SCS1.getToType(1);
  QualType FromType2 = SCS2.getFromType();
  QualType ToType2 = SCS2.getToType(1);
  
  // Adjust the types we're converting from via the array-to-pointer
  // conversion, if we need to.
  if (SCS1.First == ImplicitConversionKind.ICK_Array_To_Pointer) {
    FromType1.$assignMove(S.Context.getArrayDecayedType(new QualType(FromType1)));
  }
  if (SCS2.First == ImplicitConversionKind.ICK_Array_To_Pointer) {
    FromType2.$assignMove(S.Context.getArrayDecayedType(new QualType(FromType2)));
  }
  
  // Canonicalize all of the types.
  FromType1.$assignMove(S.Context.getCanonicalType(new QualType(FromType1)).$QualType());
  ToType1.$assignMove(S.Context.getCanonicalType(new QualType(ToType1)).$QualType());
  FromType2.$assignMove(S.Context.getCanonicalType(new QualType(FromType2)).$QualType());
  ToType2.$assignMove(S.Context.getCanonicalType(new QualType(ToType2)).$QualType());
  
  // C++ [over.ics.rank]p4b3:
  //
  //   If class B is derived directly or indirectly from class A and
  //   class C is derived directly or indirectly from B,
  //
  // Compare based on pointer conversions.
  if (SCS1.Second == ImplicitConversionKind.ICK_Pointer_Conversion
     && SCS2.Second == ImplicitConversionKind.ICK_Pointer_Conversion
    /*FIXME: Remove if Objective-C id conversions get their own rank*/
     && FromType1.$arrow().isPointerType() && FromType2.$arrow().isPointerType()
     && ToType1.$arrow().isPointerType() && ToType2.$arrow().isPointerType()) {
    QualType FromPointee1 = FromType1.$arrow().getAs(PointerType.class).getPointeeType().getUnqualifiedType();
    QualType ToPointee1 = ToType1.$arrow().getAs(PointerType.class).getPointeeType().getUnqualifiedType();
    QualType FromPointee2 = FromType2.$arrow().getAs(PointerType.class).getPointeeType().getUnqualifiedType();
    QualType ToPointee2 = ToType2.$arrow().getAs(PointerType.class).getPointeeType().getUnqualifiedType();
    
    //   -- conversion of C* to B* is better than conversion of C* to A*,
    if ($eq_QualType$C(FromPointee1, FromPointee2) && $noteq_QualType$C(ToPointee1, ToPointee2)) {
      if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(ToPointee1), new QualType(ToPointee2))) {
        return ImplicitConversionSequence.CompareKind.Better;
      } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(ToPointee2), new QualType(ToPointee1))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
    }
    
    //   -- conversion of B* to A* is better than conversion of C* to A*,
    if ($noteq_QualType$C(FromPointee1, FromPointee2) && $eq_QualType$C(ToPointee1, ToPointee2)) {
      if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromPointee2), new QualType(FromPointee1))) {
        return ImplicitConversionSequence.CompareKind.Better;
      } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromPointee1), new QualType(FromPointee2))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
    }
  } else if (SCS1.Second == ImplicitConversionKind.ICK_Pointer_Conversion
     && SCS2.Second == ImplicitConversionKind.ICK_Pointer_Conversion) {
    /*const*/ ObjCObjectPointerType /*P*/ FromPtr1 = FromType1.$arrow().getAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ FromPtr2 = FromType2.$arrow().getAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ ToPtr1 = ToType1.$arrow().getAs(ObjCObjectPointerType.class);
    /*const*/ ObjCObjectPointerType /*P*/ ToPtr2 = ToType2.$arrow().getAs(ObjCObjectPointerType.class);
    if ((FromPtr1 != null) && (FromPtr2 != null) && (ToPtr1 != null) && (ToPtr2 != null)) {
      // Apply the same conversion ranking rules for Objective-C pointer types
      // that we do for C++ pointers to class types. However, we employ the
      // Objective-C pseudo-subtyping relationship used for assignment of
      // Objective-C pointer types.
      boolean FromAssignLeft = S.Context.canAssignObjCInterfaces(FromPtr1, FromPtr2);
      boolean FromAssignRight = S.Context.canAssignObjCInterfaces(FromPtr2, FromPtr1);
      boolean ToAssignLeft = S.Context.canAssignObjCInterfaces(ToPtr1, ToPtr2);
      boolean ToAssignRight = S.Context.canAssignObjCInterfaces(ToPtr2, ToPtr1);
      
      // A conversion to an a non-id object pointer type or qualified 'id' 
      // type is better than a conversion to 'id'.
      if (ToPtr1.isObjCIdType()
         && (ToPtr2.isObjCQualifiedIdType() || (ToPtr2.getInterfaceDecl() != null))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
      if (ToPtr2.isObjCIdType()
         && (ToPtr1.isObjCQualifiedIdType() || (ToPtr1.getInterfaceDecl() != null))) {
        return ImplicitConversionSequence.CompareKind.Better;
      }
      
      // A conversion to a non-id object pointer type is better than a 
      // conversion to a qualified 'id' type 
      if (ToPtr1.isObjCQualifiedIdType() && (ToPtr2.getInterfaceDecl() != null)) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
      if (ToPtr2.isObjCQualifiedIdType() && (ToPtr1.getInterfaceDecl() != null)) {
        return ImplicitConversionSequence.CompareKind.Better;
      }
      
      // A conversion to an a non-Class object pointer type or qualified 'Class' 
      // type is better than a conversion to 'Class'.
      if (ToPtr1.isObjCClassType()
         && (ToPtr2.isObjCQualifiedClassType() || (ToPtr2.getInterfaceDecl() != null))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
      if (ToPtr2.isObjCClassType()
         && (ToPtr1.isObjCQualifiedClassType() || (ToPtr1.getInterfaceDecl() != null))) {
        return ImplicitConversionSequence.CompareKind.Better;
      }
      
      // A conversion to a non-Class object pointer type is better than a 
      // conversion to a qualified 'Class' type.
      if (ToPtr1.isObjCQualifiedClassType() && (ToPtr2.getInterfaceDecl() != null)) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
      if (ToPtr2.isObjCQualifiedClassType() && (ToPtr1.getInterfaceDecl() != null)) {
        return ImplicitConversionSequence.CompareKind.Better;
      }
      
      //   -- "conversion of C* to B* is better than conversion of C* to A*,"
      if (S.Context.hasSameType(new QualType(FromType1), new QualType(FromType2))
         && !FromPtr1.isObjCIdType() && !FromPtr1.isObjCClassType()
         && (ToAssignLeft != ToAssignRight)) {
        return ToAssignLeft ? ImplicitConversionSequence.CompareKind.Worse : ImplicitConversionSequence.CompareKind.Better;
      }
      
      //   -- "conversion of B* to A* is better than conversion of C* to A*,"
      if (S.Context.hasSameUnqualifiedType(new QualType(ToType1), new QualType(ToType2))
         && (FromAssignLeft != FromAssignRight)) {
        return FromAssignLeft ? ImplicitConversionSequence.CompareKind.Better : ImplicitConversionSequence.CompareKind.Worse;
      }
    }
  }
  
  // Ranking of member-pointer types.
  if (SCS1.Second == ImplicitConversionKind.ICK_Pointer_Member && SCS2.Second == ImplicitConversionKind.ICK_Pointer_Member
     && FromType1.$arrow().isMemberPointerType() && FromType2.$arrow().isMemberPointerType()
     && ToType1.$arrow().isMemberPointerType() && ToType2.$arrow().isMemberPointerType()) {
    /*const*/ MemberPointerType /*P*/ FromMemPointer1 = FromType1.$arrow().getAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ ToMemPointer1 = ToType1.$arrow().getAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ FromMemPointer2 = FromType2.$arrow().getAs(MemberPointerType.class);
    /*const*/ MemberPointerType /*P*/ ToMemPointer2 = ToType2.$arrow().getAs(MemberPointerType.class);
    /*const*/ Type /*P*/ FromPointeeType1 = FromMemPointer1.__getClass();
    /*const*/ Type /*P*/ ToPointeeType1 = ToMemPointer1.__getClass();
    /*const*/ Type /*P*/ FromPointeeType2 = FromMemPointer2.__getClass();
    /*const*/ Type /*P*/ ToPointeeType2 = ToMemPointer2.__getClass();
    QualType FromPointee1 = new QualType(FromPointeeType1, 0).getUnqualifiedType();
    QualType ToPointee1 = new QualType(ToPointeeType1, 0).getUnqualifiedType();
    QualType FromPointee2 = new QualType(FromPointeeType2, 0).getUnqualifiedType();
    QualType ToPointee2 = new QualType(ToPointeeType2, 0).getUnqualifiedType();
    // conversion of A::* to B::* is better than conversion of A::* to C::*,
    if ($eq_QualType$C(FromPointee1, FromPointee2) && $noteq_QualType$C(ToPointee1, ToPointee2)) {
      if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(ToPointee1), new QualType(ToPointee2))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(ToPointee2), new QualType(ToPointee1))) {
        return ImplicitConversionSequence.CompareKind.Better;
      }
    }
    // conversion of B::* to C::* is better than conversion of A::* to C::*
    if ($eq_QualType$C(ToPointee1, ToPointee2) && $noteq_QualType$C(FromPointee1, FromPointee2)) {
      if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromPointee1), new QualType(FromPointee2))) {
        return ImplicitConversionSequence.CompareKind.Better;
      } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromPointee2), new QualType(FromPointee1))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
    }
  }
  if (SCS1.Second == ImplicitConversionKind.ICK_Derived_To_Base) {
    //   -- conversion of C to B is better than conversion of C to A,
    //   -- binding of an expression of type C to a reference of type
    //      B& is better than binding an expression of type C to a
    //      reference of type A&,
    if (S.Context.hasSameUnqualifiedType(new QualType(FromType1), new QualType(FromType2))
       && !S.Context.hasSameUnqualifiedType(new QualType(ToType1), new QualType(ToType2))) {
      if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(ToType1), new QualType(ToType2))) {
        return ImplicitConversionSequence.CompareKind.Better;
      } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(ToType2), new QualType(ToType1))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
    }
    
    //   -- conversion of B to A is better than conversion of C to A.
    //   -- binding of an expression of type B to a reference of type
    //      A& is better than binding an expression of type C to a
    //      reference of type A&,
    if (!S.Context.hasSameUnqualifiedType(new QualType(FromType1), new QualType(FromType2))
       && S.Context.hasSameUnqualifiedType(new QualType(ToType1), new QualType(ToType2))) {
      if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromType2), new QualType(FromType1))) {
        return ImplicitConversionSequence.CompareKind.Better;
      } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromType1), new QualType(FromType2))) {
        return ImplicitConversionSequence.CompareKind.Worse;
      }
    }
  }
  
  return ImplicitConversionSequence.CompareKind.Indistinguishable;
}


/// GetImplicitConversionName - Return the name of this kind of
/// implicit conversion.
//<editor-fold defaultstate="collapsed" desc="GetImplicitConversionName">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 145,
 FQN="GetImplicitConversionName", NM="_ZL25GetImplicitConversionNameN5clang22ImplicitConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL25GetImplicitConversionNameN5clang22ImplicitConversionKindE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ GetImplicitConversionName(ImplicitConversionKind Kind) {
  final/*static*/ /*const*/char$ptr/*char P*//*const*/ Name[/*26*/] = GetImplicitConversionName$$.Name;
  return Name[Kind.getValue()];
}
private static final class GetImplicitConversionName$$ {
  static final/*static*/ /*const*/char$ptr/*char P*//*const*/ Name[/*26*/] = (new /*const*/char$ptr/*char P*//*const*/ [/*26*/] {
  $("No conversion"), 
  $("Lvalue-to-rvalue"), 
  $("Array-to-pointer"), 
  $("Function-to-pointer"), 
  $("Noreturn adjustment"), 
  $("Qualification"), 
  $("Integral promotion"), 
  $("Floating point promotion"), 
  $("Complex promotion"), 
  $("Integral conversion"), 
  $("Floating conversion"), 
  $("Complex conversion"), 
  $("Floating-integral conversion"), 
  $("Pointer conversion"), 
  $("Pointer-to-member conversion"), 
  $("Boolean conversion"), 
  $("Compatible-types conversion"), 
  $("Derived-to-base conversion"), 
  $("Vector conversion"), 
  $("Vector splat"), 
  $("Complex-real conversion"), 
  $("Block Pointer conversion"), 
  $("Transparent Union Conversion"), 
  $("Writeback conversion"), 
  $("OpenCL Zero Event Conversion"), 
  $("C specific type conversion")
});
}


/// Skip any implicit casts which could be either part of a narrowing conversion
/// or after one in an implicit conversion.
//<editor-fold defaultstate="collapsed" desc="IgnoreNarrowingConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 254,
 FQN="IgnoreNarrowingConversion", NM="_ZL25IgnoreNarrowingConversionPKN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL25IgnoreNarrowingConversionPKN5clang4ExprE")
//</editor-fold>
public static /*const*/ Expr /*P*/ IgnoreNarrowingConversion(/*const*/ Expr /*P*/ _Converted) {
  {
    /*const*/ ImplicitCastExpr /*P*/ ICE;
    while (((/*P*/ ICE = dyn_cast_ImplicitCastExpr(_Converted)) != null)) {
      switch (ICE.getCastKind()) {
       case CK_NoOp:
       case CK_IntegralCast:
       case CK_IntegralToBoolean:
       case CK_IntegralToFloating:
       case CK_BooleanToSignedIntegral:
       case CK_FloatingToIntegral:
       case CK_FloatingToBoolean:
       case CK_FloatingCast:
        _Converted = ICE.getSubExpr$Const();
        continue;
       default:
        return _Converted;
      }
    }
  }
  
  return _Converted;
}


/// checkPlaceholderForOverload - Do any interesting placeholder-like
/// preprocessing on the given expression.
///
/// \param unbridgedCasts a collection to which to add unbridged casts;
///   without this, they will be immediately diagnosed as errors
///
/// Return true on unrecoverable error.
//<editor-fold defaultstate="collapsed" desc="checkPlaceholderForOverload">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 851,
 FQN="checkPlaceholderForOverload", NM="_ZL27checkPlaceholderForOverloadRN5clang4SemaERPNS_4ExprEPN12_GLOBAL__N_117UnbridgedCastsSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL27checkPlaceholderForOverloadRN5clang4SemaERPNS_4ExprEPN12_GLOBAL__N_117UnbridgedCastsSetE")
//</editor-fold>
public static boolean checkPlaceholderForOverload(final Sema /*&*/ S, final type$ref<Expr /*P*/ /*&*/> E) {
  return checkPlaceholderForOverload(S, E, 
                           (UnbridgedCastsSet /*P*/ )null);
}
public static boolean checkPlaceholderForOverload(final Sema /*&*/ S, final type$ref<Expr /*P*/ /*&*/> E, 
                           UnbridgedCastsSet /*P*/ unbridgedCasts/*= null*/) {
  {
    /*const*/ BuiltinType /*P*/ placeholder = E.$deref().getType().$arrow().getAsPlaceholderType();
    if ((placeholder != null)) {
      // We can't handle overloaded expressions here because overload
      // resolution might reasonably tweak them.
      if (placeholder.getKind() == BuiltinType.Kind.Overload) {
        return false;
      }
      
      // If the context potentially accepts unbridged ARC casts, strip
      // the unbridged cast and add it to the collection for later restoration.
      if (placeholder.getKind() == BuiltinType.Kind.ARCUnbridgedCast
         && (unbridgedCasts != null)) {
        unbridgedCasts.save(S, E);
        return false;
      }
      
      // Go ahead and check everything else.
      ActionResultTTrue<Expr /*P*/ > result = S.CheckPlaceholderExpr(E.$deref());
      if (result.isInvalid()) {
        return true;
      }
      
      E.$set(result.get());
      return false;
    }
  }
  
  // Nothing to do.
  return false;
}


/// checkArgPlaceholdersForOverload - Check a set of call operands for
/// placeholders.
//<editor-fold defaultstate="collapsed" desc="checkArgPlaceholdersForOverload">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 882,
 FQN="checkArgPlaceholdersForOverload", NM="_ZL31checkArgPlaceholdersForOverloadRN5clang4SemaEN4llvm15MutableArrayRefIPNS_4ExprEEERN12_GLOBAL__N_117UnbridgedCastsSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL31checkArgPlaceholdersForOverloadRN5clang4SemaEN4llvm15MutableArrayRefIPNS_4ExprEEERN12_GLOBAL__N_117UnbridgedCastsSetE")
//</editor-fold>
public static boolean checkArgPlaceholdersForOverload(final Sema /*&*/ S, 
                               MutableArrayRef<Expr /*P*/ > Args, 
                               final UnbridgedCastsSet /*&*/ unbridged) {
  for (/*uint*/int i = 0, e = Args.size(); i != e; ++i)  {
    if (checkPlaceholderForOverload(S, Args.ref$at(i), $AddrOf(unbridged))) {
      return true;
    }
  }
  
  return false;
}


/// \brief Tries a user-defined conversion from From to ToType.
///
/// Produces an implicit conversion sequence for when a standard conversion
/// is not an option. See TryImplicitConversion for more information.
//<editor-fold defaultstate="collapsed" desc="TryUserDefinedConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1176,
 FQN="TryUserDefinedConversion", NM="_ZL24TryUserDefinedConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL24TryUserDefinedConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbbbb")
//</editor-fold>
public static ImplicitConversionSequence TryUserDefinedConversion(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                        boolean SuppressUserConversions, 
                        boolean AllowExplicit, 
                        boolean InOverloadResolution, 
                        boolean CStyle, 
                        boolean AllowObjCWritebackConversion, 
                        boolean AllowObjCConversionOnExplicit) {
  ImplicitConversionSequence ICS = null;
  OverloadCandidateSet Conversions = null;
  try {
    ICS/*J*/= new ImplicitConversionSequence();
    if (SuppressUserConversions) {
      // We're not in the case above, so there is no conversion that
      // we can perform.
      ICS.setBad(BadConversionSequence.FailureKind.no_conversion, From, new QualType(ToType));
      return new ImplicitConversionSequence(ICS);
    }
    
    // Attempt user-defined conversion.
    Conversions/*J*/= new OverloadCandidateSet(From.getExprLoc(), 
        OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    switch (IsUserDefinedConversion(S, From, new QualType(ToType), ICS.Unnamed_field2.UserDefined, 
        Conversions, AllowExplicit, 
        AllowObjCConversionOnExplicit)) {
     case OR_Success:
     case OR_Deleted:
      ICS.setUserDefined();
      ICS.Unnamed_field2.UserDefined.Before.setAsIdentityConversion();
      {
        // C++ [over.ics.user]p4:
        //   A conversion of an expression of class type to the same class
        //   type is given Exact Match rank, and a conversion of an
        //   expression of class type to a base class of that type is
        //   given Conversion rank, in spite of the fact that a copy
        //   constructor (i.e., a user-defined conversion function) is
        //   called for those cases.
        CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(ICS.Unnamed_field2.UserDefined.ConversionFunction);
        if ((Constructor != null)) {
          QualType FromCanon = S.Context.getCanonicalType(From.getType().getUnqualifiedType()).$QualType();
          QualType ToCanon = S.Context.getCanonicalType(new QualType(ToType)).getUnqualifiedType().$QualType();
          if (Constructor.isCopyConstructor()
             && ($eq_QualType$C(FromCanon, ToCanon)
             || S.IsDerivedFrom(From.getLocStart(), new QualType(FromCanon), new QualType(ToCanon)))) {
            // Turn this into a "standard" conversion sequence, so that it
            // gets ranked with standard conversion sequences.
            DeclAccessPair Found = new DeclAccessPair(ICS.Unnamed_field2.UserDefined.FoundConversionFunction);
            ICS.setStandard();
            ICS.Unnamed_field2.Standard.setAsIdentityConversion();
            ICS.Unnamed_field2.Standard.setFromType(From.getType());
            ICS.Unnamed_field2.Standard.setAllToTypes(new QualType(ToType));
            ICS.Unnamed_field2.Standard.CopyConstructor = Constructor;
            ICS.Unnamed_field2.Standard.FoundCopyConstructor.$assign(Found);
            if ($noteq_QualType$C(ToCanon, FromCanon)) {
              ICS.Unnamed_field2.Standard.Second = ImplicitConversionKind.ICK_Derived_To_Base;
            }
          }
        }
      }
      break;
     case OR_Ambiguous:
      ICS.setAmbiguous();
      ICS.Unnamed_field2.Ambiguous.setFromType(From.getType());
      ICS.Unnamed_field2.Ambiguous.setToType(new QualType(ToType));
      for (type$ptr<OverloadCandidate> Cand = Conversions.begin();
           $noteq_iter(Cand, Conversions.end()); Cand.$preInc())  {
        if (Cand./*->*/$star().Viable) {
          ICS.Unnamed_field2.Ambiguous.addConversion(Cand./*->*/$star().FoundDecl.$NamedDecl$P(), Cand./*->*/$star().Function);
        }
      }
      break;
     case OR_No_Viable_Function:
      
      // Fall through.
      ICS.setBad(BadConversionSequence.FailureKind.no_conversion, From, new QualType(ToType));
      break;
    }
    
    return new ImplicitConversionSequence(ICS);
  } finally {
    if (Conversions != null) { Conversions.$destroy(); }
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// TryImplicitConversion - Attempt to perform an implicit conversion
/// from the given expression (Expr) to the given type (ToType). This
/// function returns an implicit conversion sequence that can be used
/// to perform the initialization. Given
///
///   void f(float f);
///   void g(int i) { f(i); }
///
/// this routine would produce an implicit conversion sequence to
/// describe the initialization of f from i, which will be a standard
/// conversion sequence containing an lvalue-to-rvalue conversion (C++
/// 4.1) followed by a floating-integral conversion (C++ 4.9).
//
/// Note that this routine only determines how the conversion can be
/// performed; it does not actually perform the conversion. As such,
/// it will not produce any diagnostics if no conversion is available,
/// but will instead return an implicit conversion sequence of kind
/// "BadConversion".
///
/// If @p SuppressUserConversions, then user-defined conversions are
/// not permitted.
/// If @p AllowExplicit, then explicit user-defined conversions are
/// permitted.
///
/// \param AllowObjCWritebackConversion Whether we allow the Objective-C
/// writeback conversion, which allows __autoreleasing id* parameters to
/// be initialized with __strong id* or __weak id* arguments.
//<editor-fold defaultstate="collapsed" desc="TryImplicitConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1280,
 FQN="TryImplicitConversion", NM="_ZL21TryImplicitConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21TryImplicitConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbbbb")
//</editor-fold>
public static ImplicitConversionSequence TryImplicitConversion(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                     boolean SuppressUserConversions, 
                     boolean AllowExplicit, 
                     boolean InOverloadResolution, 
                     boolean CStyle, 
                     boolean AllowObjCWritebackConversion, 
                     boolean AllowObjCConversionOnExplicit) {
  ImplicitConversionSequence ICS = null;
  try {
    ICS/*J*/= new ImplicitConversionSequence();
    if (IsStandardConversion(S, From, new QualType(ToType), InOverloadResolution, 
        ICS.Unnamed_field2.Standard, CStyle, AllowObjCWritebackConversion)) {
      ICS.setStandard();
      return new ImplicitConversionSequence(ICS);
    }
    if (!S.getLangOpts().CPlusPlus) {
      ICS.setBad(BadConversionSequence.FailureKind.no_conversion, From, new QualType(ToType));
      return new ImplicitConversionSequence(ICS);
    }
    
    // C++ [over.ics.user]p4:
    //   A conversion of an expression of class type to the same class
    //   type is given Exact Match rank, and a conversion of an
    //   expression of class type to a base class of that type is
    //   given Conversion rank, in spite of the fact that a copy/move
    //   constructor (i.e., a user-defined conversion function) is
    //   called for those cases.
    QualType FromType = From.getType();
    if ((ToType.$arrow().<RecordType>getAs$RecordType() != null) && (FromType.$arrow().<RecordType>getAs$RecordType() != null)
       && (S.Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType))
       || S.IsDerivedFrom(From.getLocStart(), new QualType(FromType), new QualType(ToType)))) {
      ICS.setStandard();
      ICS.Unnamed_field2.Standard.setAsIdentityConversion();
      ICS.Unnamed_field2.Standard.setFromType(new QualType(FromType));
      ICS.Unnamed_field2.Standard.setAllToTypes(new QualType(ToType));
      
      // We don't actually check at this point whether there is a valid
      // copy/move constructor, since overloading just assumes that it
      // exists. When we actually perform initialization, we'll find the
      // appropriate constructor to copy the returned object, if needed.
      ICS.Unnamed_field2.Standard.CopyConstructor = null;
      
      // Determine whether this is considered a derived-to-base conversion.
      if (!S.Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType))) {
        ICS.Unnamed_field2.Standard.Second = ImplicitConversionKind.ICK_Derived_To_Base;
      }
      
      return new ImplicitConversionSequence(ICS);
    }
    
    return TryUserDefinedConversion(S, From, new QualType(ToType), SuppressUserConversions, 
        AllowExplicit, InOverloadResolution, CStyle, 
        AllowObjCWritebackConversion, 
        AllowObjCConversionOnExplicit);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// \brief Determine whether the conversion from FromType to ToType is a valid
/// vector conversion.
///
/// \param ICK Will be set to the vector conversion kind, if this is a vector
/// conversion.
//<editor-fold defaultstate="collapsed" desc="IsVectorConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 1438,
 FQN="IsVectorConversion", NM="_ZL18IsVectorConversionRN5clang4SemaENS_8QualTypeES2_RNS_22ImplicitConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL18IsVectorConversionRN5clang4SemaENS_8QualTypeES2_RNS_22ImplicitConversionKindE")
//</editor-fold>
public static boolean IsVectorConversion(final Sema /*&*/ S, QualType FromType, 
                  QualType ToType, final type$ref<ImplicitConversionKind /*&*/> ICK) {
  // We need at least one of these types to be a vector type to have a vector
  // conversion.
  if (!ToType.$arrow().isVectorType() && !FromType.$arrow().isVectorType()) {
    return false;
  }
  
  // Identical types require no conversions.
  if (S.Context.hasSameUnqualifiedType(new QualType(FromType), new QualType(ToType))) {
    return false;
  }
  
  // There are no conversions between extended vector types, only identity.
  if (ToType.$arrow().isExtVectorType()) {
    // There are no conversions between extended vector types other than the
    // identity conversion.
    if (FromType.$arrow().isExtVectorType()) {
      return false;
    }
    
    // Vector splat from any arithmetic type to a vector.
    if (FromType.$arrow().isArithmeticType()) {
      ICK.$set(ImplicitConversionKind.ICK_Vector_Splat);
      return true;
    }
  }
  
  // We can perform the conversion between vector types in the following cases:
  // 1)vector types are equivalent AltiVec and GCC vector types
  // 2)lax vector conversions are permitted and the vector types are of the
  //   same size
  if (ToType.$arrow().isVectorType() && FromType.$arrow().isVectorType()) {
    if (S.Context.areCompatibleVectorTypes(new QualType(FromType), new QualType(ToType))
       || S.isLaxVectorConversion(new QualType(FromType), new QualType(ToType))) {
      ICK.$set(ImplicitConversionKind.ICK_Vector_Conversion);
      return true;
    }
  }
  
  return false;
}


/// \brief - Determine whether this is a conversion from a scalar type to an
/// atomic type.
///
/// If successful, updates \c SCS's second and third steps in the conversion
/// sequence to finish the conversion.
//<editor-fold defaultstate="collapsed" desc="tryAtomicConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3014,
 FQN="tryAtomicConversion", NM="_ZL19tryAtomicConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_26StandardConversionSequenceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL19tryAtomicConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEbRNS_26StandardConversionSequenceEb")
//</editor-fold>
public static boolean tryAtomicConversion(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                   boolean InOverloadResolution, 
                   final StandardConversionSequence /*&*/ SCS, 
                   boolean CStyle) {
  /*const*/ AtomicType /*P*/ ToAtomic = ToType.$arrow().getAs(AtomicType.class);
  if (!(ToAtomic != null)) {
    return false;
  }
  
  StandardConversionSequence InnerSCS/*J*/= new StandardConversionSequence();
  if (!IsStandardConversion(S, From, ToAtomic.getValueType(), 
      InOverloadResolution, InnerSCS, 
      CStyle, /*AllowObjCWritebackConversion=*/ false)) {
    return false;
  }
  
  SCS.Second = InnerSCS.Second;
  SCS.setToType(1, InnerSCS.getToType(1));
  SCS.Third = InnerSCS.Third;
  SCS.QualificationIncludesObjCLifetime
     = InnerSCS.QualificationIncludesObjCLifetime;
  SCS.setToType(2, InnerSCS.getToType(2));
  return true;
}


/// BuildSimilarlyQualifiedPointerType - In a pointer conversion from
/// the pointer type FromPtr to a pointer to type ToPointee, with the
/// same type qualifiers as FromPtr has on its pointee type. ToType,
/// if non-empty, will be a pointer to ToType that may or may not have
/// the right set of qualifiers on its pointee.
///
//<editor-fold defaultstate="collapsed" desc="BuildSimilarlyQualifiedPointerType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2032,
 FQN="BuildSimilarlyQualifiedPointerType", NM="_ZL34BuildSimilarlyQualifiedPointerTypePKN5clang4TypeENS_8QualTypeES3_RNS_10ASTContextEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34BuildSimilarlyQualifiedPointerTypePKN5clang4TypeENS_8QualTypeES3_RNS_10ASTContextEb")
//</editor-fold>
public static QualType BuildSimilarlyQualifiedPointerType(/*const*/ Type /*P*/ FromPtr, 
                                  QualType ToPointee, QualType ToType, 
                                  final ASTContext /*&*/ Context) {
  return BuildSimilarlyQualifiedPointerType(FromPtr, 
                                  ToPointee, ToType, 
                                  Context, 
                                  false);
}
public static QualType BuildSimilarlyQualifiedPointerType(/*const*/ Type /*P*/ FromPtr, 
                                  QualType ToPointee, QualType ToType, 
                                  final ASTContext /*&*/ Context, 
                                  boolean StripObjCLifetime/*= false*/) {
  assert ((FromPtr.getTypeClass() == Type.TypeClass.Pointer || FromPtr.getTypeClass() == Type.TypeClass.ObjCObjectPointer)) : "Invalid similarly-qualified pointer type";
  
  /// Conversions to 'id' subsume cv-qualifier conversions.
  if (ToType.$arrow().isObjCIdType() || ToType.$arrow().isObjCQualifiedIdType()) {
    return ToType.getUnqualifiedType();
  }
  
  QualType CanonFromPointee = Context.getCanonicalType(FromPtr.getPointeeType()).$QualType();
  QualType CanonToPointee = Context.getCanonicalType(new QualType(ToPointee)).$QualType();
  Qualifiers Quals = CanonFromPointee.getQualifiers();
  if (StripObjCLifetime) {
    Quals.removeObjCLifetime();
  }
  
  // Exact qualifier match -> return the pointer type we're converting to.
  if (CanonToPointee.getLocalQualifiers().$eq(/*NO_COPY*/Quals)) {
    // ToType is exactly what we need. Return it.
    if (!ToType.isNull()) {
      return ToType.getUnqualifiedType();
    }
    
    // Build a pointer to ToPointee. It has the right qualifiers
    // already.
    if (isa_ObjCObjectPointerType(ToType)) {
      return Context.getObjCObjectPointerType(new QualType(ToPointee));
    }
    return Context.getPointerType(new QualType(ToPointee));
  }
  
  // Just build a canonical type that has the right qualifiers.
  QualType QualifiedCanonToPointee = Context.getQualifiedType(CanonToPointee.getLocalUnqualifiedType(), new Qualifiers(Quals));
  if (isa_ObjCObjectPointerType(ToType)) {
    return Context.getObjCObjectPointerType(new QualType(QualifiedCanonToPointee));
  }
  return Context.getPointerType(new QualType(QualifiedCanonToPointee));
}

//<editor-fold defaultstate="collapsed" desc="isNullPointerConstantForConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2075,
 FQN="isNullPointerConstantForConversion", NM="_ZL34isNullPointerConstantForConversionPN5clang4ExprEbRNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34isNullPointerConstantForConversionPN5clang4ExprEbRNS_10ASTContextE")
//</editor-fold>
public static boolean isNullPointerConstantForConversion(Expr /*P*/ $Expr, 
                                  boolean InOverloadResolution, 
                                  final ASTContext /*&*/ Context) {
  // Handle value-dependent integral null pointer constants correctly.
  // http://www.open-std.org/jtc1/sc22/wg21/docs/cwg_active.html#903
  if ($Expr.isValueDependent() && !$Expr.isTypeDependent()
     && $Expr.getType().$arrow().isIntegerType() && !$Expr.getType().$arrow().isEnumeralType()) {
    return !InOverloadResolution;
  }
  
  return ($Expr.isNullPointerConstant(Context, 
      InOverloadResolution ? Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull : Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0);
}


/// \brief Adopt the given qualifiers for the given type.
//<editor-fold defaultstate="collapsed" desc="AdoptQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2241,
 FQN="AdoptQualifiers", NM="_ZL15AdoptQualifiersRN5clang10ASTContextENS_8QualTypeENS_10QualifiersE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL15AdoptQualifiersRN5clang10ASTContextENS_8QualTypeENS_10QualifiersE")
//</editor-fold>
public static QualType AdoptQualifiers(final ASTContext /*&*/ Context, QualType T, Qualifiers Qs) {
  Qualifiers TQs = T.getQualifiers();
  
  // Check whether qualifiers already match.
  if (TQs.$eq(/*NO_COPY*/Qs)) {
    return new QualType(JD$Move.INSTANCE, T);
  }
  if (Qs.compatiblyIncludes(new Qualifiers(TQs))) {
    return Context.getQualifiedType(new QualType(T), new Qualifiers(Qs));
  }
  
  return Context.getQualifiedType(T.getUnqualifiedType(), new Qualifiers(Qs));
}

//<editor-fold defaultstate="collapsed" desc="(anonymous)">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2584,
 FQN="(anonymous)", NM="_SemaOverload_cpp_Unnamed_enum",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_SemaOverload_cpp_Unnamed_enum")
//</editor-fold>
public enum SemaOverload_cpp_Unnamed_enum implements Native.ComparableLower {
  ft_default(0),
  ft_different_class(ft_default.getValue() + 1),
  ft_parameter_arity(ft_different_class.getValue() + 1),
  ft_parameter_mismatch(ft_parameter_arity.getValue() + 1),
  ft_return_type(ft_parameter_mismatch.getValue() + 1),
  ft_qualifer_mismatch(ft_return_type.getValue() + 1);

  //<editor-fold defaultstate="collapsed" desc="hidden">
  public static SemaOverload_cpp_Unnamed_enum valueOf(int val) {
    SemaOverload_cpp_Unnamed_enum out = (val < 0) ? Values._VALUES[-val] : Values.VALUES[val];
    assert out != null : "no value for " + val;
    assert out.value == val : "asked [" + val + "] got " + out + ":" + out.value + "]";
    return out;
  }

  private static final class Values {
    private static final SemaOverload_cpp_Unnamed_enum[] VALUES;
    private static final SemaOverload_cpp_Unnamed_enum[] _VALUES; // [0] not used
    static {
      int max = 0;
      int min = 0;
      for (SemaOverload_cpp_Unnamed_enum kind : SemaOverload_cpp_Unnamed_enum.values()) {
        if (kind.value > max) { max = kind.value; }
        if (kind.value < min) { min = kind.value; }
      }
      _VALUES = new SemaOverload_cpp_Unnamed_enum[min < 0 ? (1-min) : 0];
      VALUES = new SemaOverload_cpp_Unnamed_enum[max >= 0 ? (1+max) : 0];
      for (SemaOverload_cpp_Unnamed_enum kind : SemaOverload_cpp_Unnamed_enum.values()) {
        if (kind.value < 0) {
          _VALUES[-kind.value] = kind;
        } else {
          VALUES[kind.value] = kind;
        }
      }
    }
  }

  private final /*uint*/int value;
  private SemaOverload_cpp_Unnamed_enum(int val) { this.value = (/*uint*/int)val;}
  public /*uint*/int getValue() { return value;}
  @Override public boolean $less(Object obj) { return Unsigned.$less_uint(value, ((SemaOverload_cpp_Unnamed_enum)obj).value);}
  @Override public boolean $lesseq(Object obj) { return Unsigned.$lesseq_uint(value, ((SemaOverload_cpp_Unnamed_enum)obj).value);}
  //</editor-fold>
}

/// Attempts to get the FunctionProtoType from a Type. Handles
/// MemberFunctionPointers properly.
//<editor-fold defaultstate="collapsed" desc="tryGetFunctionProtoType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2595,
 FQN="tryGetFunctionProtoType", NM="_ZL23tryGetFunctionProtoTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL23tryGetFunctionProtoTypeN5clang8QualTypeE")
//</editor-fold>
public static /*const*/ FunctionProtoType /*P*/ tryGetFunctionProtoType(QualType FromType) {
  {
    /*const*/ FunctionProtoType /*P*/ FPT = FromType.$arrow().getAs(FunctionProtoType.class);
    if ((FPT != null)) {
      return FPT;
    }
  }
  {
    
    /*const*/ MemberPointerType /*P*/ MPT = FromType.$arrow().getAs(MemberPointerType.class);
    if ((MPT != null)) {
      return MPT.getPointeeType().$arrow().getAs(FunctionProtoType.class);
    }
  }
  
  return null;
}


/// Determine whether the lifetime conversion between the two given
/// qualifiers sets is nontrivial.
//<editor-fold defaultstate="collapsed" desc="isNonTrivialObjCLifetimeConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 2911,
 FQN="isNonTrivialObjCLifetimeConversion", NM="_ZL34isNonTrivialObjCLifetimeConversionN5clang10QualifiersES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34isNonTrivialObjCLifetimeConversionN5clang10QualifiersES0_")
//</editor-fold>
public static boolean isNonTrivialObjCLifetimeConversion(Qualifiers FromQuals, 
                                  Qualifiers ToQuals) {
  // Converting anything to const __unsafe_unretained is trivial.
  if (ToQuals.hasConst()
     && ToQuals.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_ExplicitNone) {
    return false;
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isFirstArgumentCompatibleWithType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3037,
 FQN="isFirstArgumentCompatibleWithType", NM="_ZL33isFirstArgumentCompatibleWithTypeRN5clang10ASTContextEPNS_18CXXConstructorDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL33isFirstArgumentCompatibleWithTypeRN5clang10ASTContextEPNS_18CXXConstructorDeclENS_8QualTypeE")
//</editor-fold>
public static boolean isFirstArgumentCompatibleWithType(final ASTContext /*&*/ Context, 
                                 CXXConstructorDecl /*P*/ Constructor, 
                                 QualType Type) {
  /*const*/ FunctionProtoType /*P*/ CtorType = Constructor.getType().$arrow().getAs(FunctionProtoType.class);
  if ($greater_uint(CtorType.getNumParams(), 0)) {
    QualType FirstArg = CtorType.getParamType(0);
    if (Context.hasSameUnqualifiedType(new QualType(Type), FirstArg.getNonReferenceType())) {
      return true;
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="IsInitializerListConstructorConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3050,
 FQN="IsInitializerListConstructorConversion", NM="_ZL38IsInitializerListConstructorConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEPNS_13CXXRecordDeclERNS_29UserDefinedConversionSequenceERNS_20OverloadCandidateSetEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL38IsInitializerListConstructorConversionRN5clang4SemaEPNS_4ExprENS_8QualTypeEPNS_13CXXRecordDeclERNS_29UserDefinedConversionSequenceERNS_20OverloadCandidateSetEb")
//</editor-fold>
public static OverloadingResult IsInitializerListConstructorConversion(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                                      CXXRecordDecl /*P*/ To, 
                                      final UserDefinedConversionSequence /*&*/ User, 
                                      final OverloadCandidateSet /*&*/ CandidateSet, 
                                      boolean AllowExplicit) {
  for (NamedDecl /*P*/ D : S.LookupConstructors(To)) {
    ConstructorInfo Info = getConstructorInfo(D);
    if (!Info.$bool()) {
      continue;
    }
    
    boolean Usable = !Info.Constructor.isInvalidDecl()
       && S.isInitListConstructor(Info.Constructor)
       && (AllowExplicit || !Info.Constructor.isExplicit());
    if (Usable) {
      // If the first argument is (a reference to) the target type,
      // suppress conversions.
      boolean SuppressUserConversions = isFirstArgumentCompatibleWithType(S.Context, Info.Constructor, new QualType(ToType));
      if ((Info.ConstructorTmpl != null)) {
        S.AddTemplateOverloadCandidate(Info.ConstructorTmpl, new DeclAccessPair(Info.FoundDecl), 
            /*ExplicitArgs*/ (TemplateArgumentListInfo /*P*/ )null, new ArrayRef<Expr /*P*/ >(From, true), 
            CandidateSet, SuppressUserConversions);
      } else {
        S.AddOverloadCandidate(Info.Constructor, new DeclAccessPair(Info.FoundDecl), new ArrayRef<Expr /*P*/ >(From, true), 
            CandidateSet, SuppressUserConversions);
      }
    }
  }
  
  boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
  
  final type$ptr<OverloadCandidate> Best = create_type$ptr();
  {
    OverloadingResult Result = CandidateSet.BestViableFunction(S, From.getLocStart(), 
        Best, true);
    switch (Result) {
     case OR_Deleted:
     case OR_Success:
      {
        // Record the standard conversion we used and the conversion function.
        CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(Best./*->*/$star().Function);
        QualType ThisType = Constructor.getThisType(S.Context);
        // Initializer lists don't have conversions as such.
        User.Before.setAsIdentityConversion();
        User.HadMultipleCandidates = HadMultipleCandidates;
        User.ConversionFunction = Constructor;
        User.FoundConversionFunction.$assign(Best./*->*/$star().FoundDecl);
        User.After.setAsIdentityConversion();
        User.After.setFromType(ThisType.$arrow().getAs(PointerType.class).getPointeeType());
        User.After.setAllToTypes(new QualType(ToType));
        return Result;
      }
     case OR_No_Viable_Function:
      return OverloadingResult.OR_No_Viable_Function;
     case OR_Ambiguous:
      return OverloadingResult.OR_Ambiguous;
    }
  }
  throw new llvm_unreachable("Invalid OverloadResult!");
}


/// \brief Compare the user-defined conversion functions or constructors
/// of two user-defined conversion sequences to determine whether any ordering
/// is possible.
//<editor-fold defaultstate="collapsed" desc="compareConversionFunctions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3352,
 FQN="compareConversionFunctions", NM="_ZL26compareConversionFunctionsRN5clang4SemaEPNS_12FunctionDeclES3_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL26compareConversionFunctionsRN5clang4SemaEPNS_12FunctionDeclES3_")
//</editor-fold>
public static ImplicitConversionSequence.CompareKind compareConversionFunctions(final Sema /*&*/ S, FunctionDecl /*P*/ Function1, 
                          FunctionDecl /*P*/ Function2) {
  if (!S.getLangOpts().ObjC1 || !S.getLangOpts().CPlusPlus11) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  
  // Objective-C++:
  //   If both conversion functions are implicitly-declared conversions from
  //   a lambda closure type to a function pointer and a block pointer,
  //   respectively, always prefer the conversion to a function pointer,
  //   because the function pointer is more lightweight and is more likely
  //   to keep code working.
  CXXConversionDecl /*P*/ Conv1 = dyn_cast_or_null_CXXConversionDecl(Function1);
  if (!(Conv1 != null)) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  
  CXXConversionDecl /*P*/ Conv2 = dyn_cast_CXXConversionDecl(Function2);
  if (!(Conv2 != null)) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  if (Conv1.getParent().isLambda() && Conv2.getParent().isLambda()) {
    boolean Block1 = Conv1.getConversionType().$arrow().isBlockPointerType();
    boolean Block2 = Conv2.getConversionType().$arrow().isBlockPointerType();
    if (Block1 != Block2) {
      return Block1 ? ImplicitConversionSequence.CompareKind.Worse : ImplicitConversionSequence.CompareKind.Better;
    }
  }
  
  return ImplicitConversionSequence.CompareKind.Indistinguishable;
}

//<editor-fold defaultstate="collapsed" desc="hasDeprecatedStringLiteralToCharPtrConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3383,
 FQN="hasDeprecatedStringLiteralToCharPtrConversion", NM="_ZL45hasDeprecatedStringLiteralToCharPtrConversionRKN5clang26ImplicitConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL45hasDeprecatedStringLiteralToCharPtrConversionRKN5clang26ImplicitConversionSequenceE")
//</editor-fold>
public static boolean hasDeprecatedStringLiteralToCharPtrConversion(final /*const*/ ImplicitConversionSequence /*&*/ ICS) {
  return (ICS.isStandard() && ICS.Unnamed_field2.Standard.DeprecatedStringLiteralToCharPtr)
     || (ICS.isUserDefined()
     && ICS.Unnamed_field2.UserDefined.Before.DeprecatedStringLiteralToCharPtr);
}


/// CompareImplicitConversionSequences - Compare two implicit
/// conversion sequences to determine whether one is better than the
/// other or if they are indistinguishable (C++ 13.3.3.2).
//<editor-fold defaultstate="collapsed" desc="CompareImplicitConversionSequences">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3393,
 FQN="CompareImplicitConversionSequences", NM="_ZL34CompareImplicitConversionSequencesRN5clang4SemaENS_14SourceLocationERKNS_26ImplicitConversionSequenceES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34CompareImplicitConversionSequencesRN5clang4SemaENS_14SourceLocationERKNS_26ImplicitConversionSequenceES5_")
//</editor-fold>
public static ImplicitConversionSequence.CompareKind CompareImplicitConversionSequences(final Sema /*&*/ S, SourceLocation Loc, 
                                  final /*const*/ ImplicitConversionSequence /*&*/ ICS1, 
                                  final /*const*/ ImplicitConversionSequence /*&*/ ICS2) {
  // (C++ 13.3.3.2p2): When comparing the basic forms of implicit
  // conversion sequences (as defined in 13.3.3.1)
  //   -- a standard conversion sequence (13.3.3.1.1) is a better
  //      conversion sequence than a user-defined conversion sequence or
  //      an ellipsis conversion sequence, and
  //   -- a user-defined conversion sequence (13.3.3.1.2) is a better
  //      conversion sequence than an ellipsis conversion sequence
  //      (13.3.3.1.3).
  //
  // C++0x [over.best.ics]p10:
  //   For the purpose of ranking implicit conversion sequences as
  //   described in 13.3.3.2, the ambiguous conversion sequence is
  //   treated as a user-defined sequence that is indistinguishable
  //   from any other user-defined conversion sequence.
  
  // String literal to 'char *' conversion has been deprecated in C++03. It has
  // been removed from C++11. We still accept this conversion, if it happens at
  // the best viable function. Otherwise, this conversion is considered worse
  // than ellipsis conversion. Consider this as an extension; this is not in the
  // standard. For example:
  //
  // int &f(...);    // #1
  // void f(char*);  // #2
  // void g() { int &r = f("foo"); }
  //
  // In C++03, we pick #2 as the best viable function.
  // In C++11, we pick #1 as the best viable function, because ellipsis
  // conversion is better than string-literal to char* conversion (since there
  // is no such conversion in C++11). If there was no #1 at all or #1 couldn't
  // convert arguments, #2 would be the best viable function in C++11.
  // If the best viable function has this conversion, a warning will be issued
  // in C++03, or an ExtWarn (+SFINAE failure) will be issued in C++11.
  if (S.getLangOpts().CPlusPlus11 && !S.getLangOpts().WritableStrings
     && hasDeprecatedStringLiteralToCharPtrConversion(ICS1)
     != hasDeprecatedStringLiteralToCharPtrConversion(ICS2)) {
    return hasDeprecatedStringLiteralToCharPtrConversion(ICS1) ? ImplicitConversionSequence.CompareKind.Worse : ImplicitConversionSequence.CompareKind.Better;
  }
  if ($less_uint(ICS1.getKindRank(), ICS2.getKindRank())) {
    return ImplicitConversionSequence.CompareKind.Better;
  }
  if ($less_uint(ICS2.getKindRank(), ICS1.getKindRank())) {
    return ImplicitConversionSequence.CompareKind.Worse;
  }
  
  // The following checks require both conversion sequences to be of
  // the same kind.
  if (ICS1.getKind() != ICS2.getKind()) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  
  ImplicitConversionSequence.CompareKind Result = ImplicitConversionSequence.CompareKind.Indistinguishable;
  
  // Two implicit conversion sequences of the same form are
  // indistinguishable conversion sequences unless one of the
  // following rules apply: (C++ 13.3.3.2p3):
  
  // List-initialization sequence L1 is a better conversion sequence than
  // list-initialization sequence L2 if:
  // - L1 converts to std::initializer_list<X> for some X and L2 does not, or,
  //   if not that,
  // - L1 converts to type "array of N1 T", L2 converts to type "array of N2 T",
  //   and N1 is smaller than N2.,
  // even if one of the other rules in this paragraph would otherwise apply.
  if (!ICS1.isBad()) {
    if (ICS1.isStdInitializerListElement()
       && !ICS2.isStdInitializerListElement()) {
      return ImplicitConversionSequence.CompareKind.Better;
    }
    if (!ICS1.isStdInitializerListElement()
       && ICS2.isStdInitializerListElement()) {
      return ImplicitConversionSequence.CompareKind.Worse;
    }
  }
  if (ICS1.isStandard()) {
    // Standard conversion sequence S1 is a better conversion sequence than
    // standard conversion sequence S2 if [...]
    Result = CompareStandardConversionSequences(S, new SourceLocation(Loc), 
        ICS1.Unnamed_field2.Standard, ICS2.Unnamed_field2.Standard);
  } else if (ICS1.isUserDefined()) {
    // User-defined conversion sequence U1 is a better conversion
    // sequence than another user-defined conversion sequence U2 if
    // they contain the same user-defined conversion function or
    // constructor and if the second standard conversion sequence of
    // U1 is better than the second standard conversion sequence of
    // U2 (C++ 13.3.3.2p3).
    if (ICS1.Unnamed_field2.UserDefined.ConversionFunction
       == ICS2.Unnamed_field2.UserDefined.ConversionFunction) {
      Result = CompareStandardConversionSequences(S, new SourceLocation(Loc), 
          ICS1.Unnamed_field2.UserDefined.After, 
          ICS2.Unnamed_field2.UserDefined.After);
    } else {
      Result = compareConversionFunctions(S, 
          ICS1.Unnamed_field2.UserDefined.ConversionFunction, 
          ICS2.Unnamed_field2.UserDefined.ConversionFunction);
    }
  }
  
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="hasSimilarType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3497,
 FQN="hasSimilarType", NM="_ZL14hasSimilarTypeRN5clang10ASTContextENS_8QualTypeES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL14hasSimilarTypeRN5clang10ASTContextENS_8QualTypeES2_")
//</editor-fold>
public static boolean hasSimilarType(final ASTContext /*&*/ Context, QualType T1, QualType T2) {
  while (Context.UnwrapSimilarPointerTypes(T1, T2)) {
    Qualifiers Quals/*J*/= new Qualifiers();
    T1.$assignMove(Context.getUnqualifiedArrayType(new QualType(T1), Quals));
    T2.$assignMove(Context.getUnqualifiedArrayType(new QualType(T2), Quals));
  }
  
  return Context.hasSameUnqualifiedType(new QualType(T1), new QualType(T2));
}


// Per 13.3.3.2p3, compare the given standard conversion sequences to
// determine if one is a proper subset of the other.
//<editor-fold defaultstate="collapsed" desc="compareStandardConversionSubsets">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3509,
 FQN="compareStandardConversionSubsets", NM="_ZL32compareStandardConversionSubsetsRN5clang10ASTContextERKNS_26StandardConversionSequenceES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL32compareStandardConversionSubsetsRN5clang10ASTContextERKNS_26StandardConversionSequenceES4_")
//</editor-fold>
public static ImplicitConversionSequence.CompareKind compareStandardConversionSubsets(final ASTContext /*&*/ Context, 
                                final /*const*/ StandardConversionSequence /*&*/ SCS1, 
                                final /*const*/ StandardConversionSequence /*&*/ SCS2) {
  ImplicitConversionSequence.CompareKind Result = ImplicitConversionSequence.CompareKind.Indistinguishable;
  
  // the identity conversion sequence is considered to be a subsequence of
  // any non-identity conversion sequence
  if (SCS1.isIdentityConversion() && !SCS2.isIdentityConversion()) {
    return ImplicitConversionSequence.CompareKind.Better;
  } else if (!SCS1.isIdentityConversion() && SCS2.isIdentityConversion()) {
    return ImplicitConversionSequence.CompareKind.Worse;
  }
  if (SCS1.Second != SCS2.Second) {
    if (SCS1.Second == ImplicitConversionKind.ICK_Identity) {
      Result = ImplicitConversionSequence.CompareKind.Better;
    } else if (SCS2.Second == ImplicitConversionKind.ICK_Identity) {
      Result = ImplicitConversionSequence.CompareKind.Worse;
    } else {
      return ImplicitConversionSequence.CompareKind.Indistinguishable;
    }
  } else if (!hasSimilarType(Context, SCS1.getToType(1), SCS2.getToType(1))) {
    return ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  if (SCS1.Third == SCS2.Third) {
    return Context.hasSameType(SCS1.getToType(2), SCS2.getToType(2)) ? Result : ImplicitConversionSequence.CompareKind.Indistinguishable;
  }
  if (SCS1.Third == ImplicitConversionKind.ICK_Identity) {
    return Result == ImplicitConversionSequence.CompareKind.Worse ? ImplicitConversionSequence.CompareKind.Indistinguishable : ImplicitConversionSequence.CompareKind.Better;
  }
  if (SCS2.Third == ImplicitConversionKind.ICK_Identity) {
    return Result == ImplicitConversionSequence.CompareKind.Better ? ImplicitConversionSequence.CompareKind.Indistinguishable : ImplicitConversionSequence.CompareKind.Worse;
  }
  
  return ImplicitConversionSequence.CompareKind.Indistinguishable;
}


/// \brief Determine whether one of the given reference bindings is better
/// than the other based on what kind of bindings they are.
//<editor-fold defaultstate="collapsed" desc="isBetterReferenceBindingKind">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 3553,
 FQN="isBetterReferenceBindingKind", NM="_ZL28isBetterReferenceBindingKindRKN5clang26StandardConversionSequenceES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL28isBetterReferenceBindingKindRKN5clang26StandardConversionSequenceES2_")
//</editor-fold>
public static boolean isBetterReferenceBindingKind(final /*const*/ StandardConversionSequence /*&*/ SCS1, 
                            final /*const*/ StandardConversionSequence /*&*/ SCS2) {
  // C++0x [over.ics.rank]p3b4:
  //   -- S1 and S2 are reference bindings (8.5.3) and neither refers to an
  //      implicit object parameter of a non-static member function declared
  //      without a ref-qualifier, and *either* S1 binds an rvalue reference
  //      to an rvalue and S2 binds an lvalue reference *or S1 binds an
  //      lvalue reference to a function lvalue and S2 binds an rvalue
  //      reference*.
  //
  // FIXME: Rvalue references. We're going rogue with the above edits,
  // because the semantics in the current C++0x working paper (N3225 at the
  // time of this writing) break the standard definition of std::forward
  // and std::reference_wrapper when dealing with references to functions.
  // Proposed wording changes submitted to CWG for consideration.
  if (SCS1.BindsImplicitObjectArgumentWithoutRefQualifier
     || SCS2.BindsImplicitObjectArgumentWithoutRefQualifier) {
    return false;
  }
  
  return (!SCS1.IsLvalueReference && SCS1.BindsToRvalue
     && SCS2.IsLvalueReference)
     || (SCS1.IsLvalueReference && SCS1.BindsToFunctionLvalue
     && !SCS2.IsLvalueReference && SCS2.BindsToFunctionLvalue);
}


/// \brief Determine whether the given type is valid, e.g., it is not an invalid
/// C++ class.
//<editor-fold defaultstate="collapsed" desc="isTypeValid">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4064,
 FQN="isTypeValid", NM="_ZL11isTypeValidN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL11isTypeValidN5clang8QualTypeE")
//</editor-fold>
public static boolean isTypeValid(QualType T) {
  {
    CXXRecordDecl /*P*/ Record = T.$arrow().getAsCXXRecordDecl();
    if ((Record != null)) {
      return !Record.isInvalidDecl();
    }
  }
  
  return true;
}


/// \brief Look for a user-defined conversion to an value reference-compatible
///        with DeclType. Return true if something definite is found.
//<editor-fold defaultstate="collapsed" desc="FindConversionForRefInit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4159,
 FQN="FindConversionForRefInit", NM="_ZL24FindConversionForRefInitRN5clang4SemaERNS_26ImplicitConversionSequenceENS_8QualTypeENS_14SourceLocationEPNS_4ExprES4_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL24FindConversionForRefInitRN5clang4SemaERNS_26ImplicitConversionSequenceENS_8QualTypeENS_14SourceLocationEPNS_4ExprES4_bb")
//</editor-fold>
public static boolean FindConversionForRefInit(final Sema /*&*/ S, final ImplicitConversionSequence /*&*/ ICS, 
                        QualType DeclType, SourceLocation DeclLoc, 
                        Expr /*P*/ Init, QualType T2, boolean AllowRvalues, 
                        boolean AllowExplicit) {
  OverloadCandidateSet CandidateSet = null;
  try {
    assert (T2.$arrow().isRecordType()) : "Can only find conversions of record types.";
    CXXRecordDecl /*P*/ T2RecordDecl = dyn_cast_CXXRecordDecl(T2.$arrow().<RecordType>getAs$RecordType().getDecl());
    
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(DeclLoc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    final /*const*/ iterator_range<NamedDecl /*P*/ > /*&*/ Conversions = T2RecordDecl.getVisibleConversionFunctions();
    for (UnresolvedSetIterator I = (UnresolvedSetIterator)Conversions.begin(), E = (UnresolvedSetIterator)Conversions.end(); I.$noteq(E); I.$preInc()) {
      NamedDecl /*P*/ D = I.$star();
      CXXRecordDecl /*P*/ ActingDC = cast_CXXRecordDecl(D.getDeclContext());
      if (isa_UsingShadowDecl(D)) {
        D = cast_UsingShadowDecl(D).getTargetDecl();
      }
      
      FunctionTemplateDecl /*P*/ ConvTemplate = dyn_cast_FunctionTemplateDecl(D);
      CXXConversionDecl /*P*/ Conv;
      if ((ConvTemplate != null)) {
        Conv = cast_CXXConversionDecl(ConvTemplate.getTemplatedDecl());
      } else {
        Conv = cast_CXXConversionDecl(D);
      }
      
      // If this is an explicit conversion, and we're not allowed to consider
      // explicit conversions, skip it.
      if (!AllowExplicit && Conv.isExplicit()) {
        continue;
      }
      if (AllowRvalues) {
        bool$ref DerivedToBase = create_bool$ref(false);
        bool$ref ObjCConversion = create_bool$ref(false);
        bool$ref ObjCLifetimeConversion = create_bool$ref(false);
        
        // If we are initializing an rvalue reference, don't permit conversion
        // functions that return lvalues.
        if (!(ConvTemplate != null) && DeclType.$arrow().isRValueReferenceType()) {
          /*const*/ ReferenceType /*P*/ RefType = Conv.getConversionType().$arrow().getAs(LValueReferenceType.class);
          if ((RefType != null) && !RefType.getPointeeType().$arrow().isFunctionType()) {
            continue;
          }
        }
        if (!(ConvTemplate != null)
           && S.CompareReferenceRelationship(new SourceLocation(DeclLoc), 
            Conv.getConversionType().getNonReferenceType().
                getUnqualifiedType(), 
            DeclType.getNonReferenceType().getUnqualifiedType(), 
            DerivedToBase, ObjCConversion, ObjCLifetimeConversion)
           == Sema.ReferenceCompareResult.Ref_Incompatible) {
          continue;
        }
      } else {
        // If the conversion function doesn't return a reference type,
        // it can't be considered for this conversion. An rvalue reference
        // is only acceptable if its referencee is a function type.
        /*const*/ ReferenceType /*P*/ RefType = Conv.getConversionType().$arrow().getAs(ReferenceType.class);
        if (!(RefType != null)
           || (!RefType.isLValueReferenceType()
           && !RefType.getPointeeType().$arrow().isFunctionType())) {
          continue;
        }
      }
      if ((ConvTemplate != null)) {
        S.AddTemplateConversionCandidate(ConvTemplate, new DeclAccessPair(I.getPair()), ActingDC, 
            Init, new QualType(DeclType), CandidateSet, 
            /*AllowObjCConversionOnExplicit=*/ false);
      } else {
        S.AddConversionCandidate(Conv, new DeclAccessPair(I.getPair()), ActingDC, Init, 
            new QualType(DeclType), CandidateSet, 
            /*AllowObjCConversionOnExplicit=*/ false);
      }
    }
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    final type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(S, new SourceLocation(DeclLoc), Best, true)) {
     case OR_Success:
      // C++ [over.ics.ref]p1:
      //
      //   [...] If the parameter binds directly to the result of
      //   applying a conversion function to the argument
      //   expression, the implicit conversion sequence is a
      //   user-defined conversion sequence (13.3.3.1.2), with the
      //   second standard conversion sequence either an identity
      //   conversion or, if the conversion function returns an
      //   entity of a type that is a derived class of the parameter
      //   type, a derived-to-base Conversion.
      if (!Best./*->*/$star().Unnamed_field12.FinalConversion.DirectBinding) {
        return false;
      }
      
      ICS.setUserDefined();
      ICS.Unnamed_field2.UserDefined.Before.$assign(Best./*->*/$star().Conversions[0].Unnamed_field2.Standard);
      ICS.Unnamed_field2.UserDefined.After.$assign(Best./*->*/$star().Unnamed_field12.FinalConversion);
      ICS.Unnamed_field2.UserDefined.HadMultipleCandidates = HadMultipleCandidates;
      ICS.Unnamed_field2.UserDefined.ConversionFunction = Best./*->*/$star().Function;
      ICS.Unnamed_field2.UserDefined.FoundConversionFunction.$assign(Best./*->*/$star().FoundDecl);
      ICS.Unnamed_field2.UserDefined.EllipsisConversion = false;
      assert (ICS.Unnamed_field2.UserDefined.After.ReferenceBinding && ICS.Unnamed_field2.UserDefined.After.DirectBinding) : "Expected a direct reference binding!";
      return true;
     case OR_Ambiguous:
      ICS.setAmbiguous();
      for (type$ptr<OverloadCandidate> Cand = CandidateSet.begin();
           $noteq_iter(Cand, CandidateSet.end()); Cand.$preInc())  {
        if (Cand./*->*/$star().Viable) {
          ICS.Unnamed_field2.Ambiguous.addConversion(Cand./*->*/$star().FoundDecl.$NamedDecl$P(), Cand./*->*/$star().Function);
        }
      }
      return true;
     case OR_No_Viable_Function:
     case OR_Deleted:
      // There was no suitable conversion, or we found a deleted
      // conversion; continue with other checks.
      return false;
    }
    throw new llvm_unreachable("Invalid OverloadResult!");
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}


/// \brief Compute an implicit conversion sequence for reference
/// initialization.
//<editor-fold defaultstate="collapsed" desc="TryReferenceInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4285,
 FQN="TryReferenceInit", NM="_ZL16TryReferenceInitRN5clang4SemaEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL16TryReferenceInitRN5clang4SemaEPNS_4ExprENS_8QualTypeENS_14SourceLocationEbb")
//</editor-fold>
public static ImplicitConversionSequence TryReferenceInit(final Sema /*&*/ S, Expr /*P*/ Init, QualType DeclType, 
                SourceLocation DeclLoc, 
                boolean SuppressUserConversions, 
                boolean AllowExplicit) {
  ImplicitConversionSequence ICS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (DeclType.$arrow().isReferenceType()) : "Reference init needs a reference";
    
    // Most paths end in a failed conversion.
    ICS/*J*/= new ImplicitConversionSequence();
    ICS.setBad(BadConversionSequence.FailureKind.no_conversion, Init, new QualType(DeclType));
    
    QualType T1 = DeclType.$arrow().getAs(ReferenceType.class).getPointeeType();
    QualType T2 = Init.getType();
    
    // If the initializer is the address of an overloaded function, try
    // to resolve the overloaded function. If all goes well, T2 is the
    // type of the resulting function.
    if ($eq_CanQual$T_CanQual$U(S.Context.getCanonicalType(new QualType(T2)), /*NO_COPY*/S.Context.OverloadTy)) {
      DeclAccessPair Found/*J*/= new DeclAccessPair();
      {
        FunctionDecl /*P*/ Fn = S.ResolveAddressOfOverloadedFunction(Init, new QualType(DeclType), 
            false, Found);
        if ((Fn != null)) {
          T2.$assignMove(Fn.getType());
        }
      }
    }
    
    // Compute some basic properties of the types and the initializer.
    boolean isRValRef = DeclType.$arrow().isRValueReferenceType();
    bool$ref DerivedToBase = create_bool$ref(false);
    bool$ref ObjCConversion = create_bool$ref(false);
    bool$ref ObjCLifetimeConversion = create_bool$ref(false);
    Expr.Classification InitCategory = Init.Classify(S.Context);
    Sema.ReferenceCompareResult RefRelationship = S.CompareReferenceRelationship(new SourceLocation(DeclLoc), new QualType(T1), new QualType(T2), DerivedToBase, 
        ObjCConversion, ObjCLifetimeConversion);
    
    // C++0x [dcl.init.ref]p5:
    //   A reference to type "cv1 T1" is initialized by an expression
    //   of type "cv2 T2" as follows:
    
    //     -- If reference is an lvalue reference and the initializer expression
    if (!isRValRef) {
      //     -- is an lvalue (but is not a bit-field), and "cv1 T1" is
      //        reference-compatible with "cv2 T2," or
      //
      // Per C++ [over.ics.ref]p4, we don't check the bit-field property here.
      if (InitCategory.isLValue()
         && RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Compatible_With_Added_Qualification.getValue()) {
        // C++ [over.ics.ref]p1:
        //   When a parameter of reference type binds directly (8.5.3)
        //   to an argument expression, the implicit conversion sequence
        //   is the identity conversion, unless the argument expression
        //   has a type that is a derived class of the parameter type,
        //   in which case the implicit conversion sequence is a
        //   derived-to-base Conversion (13.3.3.1).
        ICS.setStandard();
        ICS.Unnamed_field2.Standard.First = ImplicitConversionKind.ICK_Identity;
        ICS.Unnamed_field2.Standard.Second = DerivedToBase.$deref() ? ImplicitConversionKind.ICK_Derived_To_Base : ObjCConversion.$deref() ? ImplicitConversionKind.ICK_Compatible_Conversion : ImplicitConversionKind.ICK_Identity;
        ICS.Unnamed_field2.Standard.Third = ImplicitConversionKind.ICK_Identity;
        ICS.Unnamed_field2.Standard.FromTypePtr = T2.getAsOpaquePtr();
        ICS.Unnamed_field2.Standard.setToType(0, new QualType(T2));
        ICS.Unnamed_field2.Standard.setToType(1, new QualType(T1));
        ICS.Unnamed_field2.Standard.setToType(2, new QualType(T1));
        ICS.Unnamed_field2.Standard.ReferenceBinding = true;
        ICS.Unnamed_field2.Standard.DirectBinding = true;
        ICS.Unnamed_field2.Standard.IsLvalueReference = !isRValRef;
        ICS.Unnamed_field2.Standard.BindsToFunctionLvalue = T2.$arrow().isFunctionType();
        ICS.Unnamed_field2.Standard.BindsToRvalue = false;
        ICS.Unnamed_field2.Standard.BindsImplicitObjectArgumentWithoutRefQualifier = false;
        ICS.Unnamed_field2.Standard.ObjCLifetimeConversionBinding = ObjCLifetimeConversion.$deref();
        ICS.Unnamed_field2.Standard.CopyConstructor = null;
        ICS.Unnamed_field2.Standard.DeprecatedStringLiteralToCharPtr = false;
        
        // Nothing more to do: the inaccessibility/ambiguity check for
        // derived-to-base conversions is suppressed when we're
        // computing the implicit conversion sequence (C++
        // [over.best.ics]p2).
        return new ImplicitConversionSequence(ICS);
      }
      
      //       -- has a class type (i.e., T2 is a class type), where T1 is
      //          not reference-related to T2, and can be implicitly
      //          converted to an lvalue of type "cv3 T3," where "cv1 T1"
      //          is reference-compatible with "cv3 T3" 92) (this
      //          conversion is selected by enumerating the applicable
      //          conversion functions (13.3.1.6) and choosing the best
      //          one through overload resolution (13.3)),
      if (!SuppressUserConversions && T2.$arrow().isRecordType()
         && S.isCompleteType(new SourceLocation(DeclLoc), new QualType(T2))
         && RefRelationship == Sema.ReferenceCompareResult.Ref_Incompatible) {
        if (FindConversionForRefInit(S, ICS, new QualType(DeclType), new SourceLocation(DeclLoc), 
            Init, new QualType(T2), /*AllowRvalues=*/ false, 
            AllowExplicit)) {
          return new ImplicitConversionSequence(ICS);
        }
      }
    }
    
    //     -- Otherwise, the reference shall be an lvalue reference to a
    //        non-volatile const type (i.e., cv1 shall be const), or the reference
    //        shall be an rvalue reference.
    if (!isRValRef && (!T1.isConstQualified() || T1.isVolatileQualified())) {
      return new ImplicitConversionSequence(ICS);
    }
    
    //       -- If the initializer expression
    //
    //            -- is an xvalue, class prvalue, array prvalue or function
    //               lvalue and "cv1 T1" is reference-compatible with "cv2 T2", or
    if (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Compatible_With_Added_Qualification.getValue()
       && (InitCategory.isXValue()
       || (InitCategory.isPRValue() && (T2.$arrow().isRecordType() || T2.$arrow().isArrayType()))
       || (InitCategory.isLValue() && T2.$arrow().isFunctionType()))) {
      ICS.setStandard();
      ICS.Unnamed_field2.Standard.First = ImplicitConversionKind.ICK_Identity;
      ICS.Unnamed_field2.Standard.Second = DerivedToBase.$deref() ? ImplicitConversionKind.ICK_Derived_To_Base : ObjCConversion.$deref() ? ImplicitConversionKind.ICK_Compatible_Conversion : ImplicitConversionKind.ICK_Identity;
      ICS.Unnamed_field2.Standard.Third = ImplicitConversionKind.ICK_Identity;
      ICS.Unnamed_field2.Standard.FromTypePtr = T2.getAsOpaquePtr();
      ICS.Unnamed_field2.Standard.setToType(0, new QualType(T2));
      ICS.Unnamed_field2.Standard.setToType(1, new QualType(T1));
      ICS.Unnamed_field2.Standard.setToType(2, new QualType(T1));
      ICS.Unnamed_field2.Standard.ReferenceBinding = true;
      // In C++0x, this is always a direct binding. In C++98/03, it's a direct
      // binding unless we're binding to a class prvalue.
      // Note: Although xvalues wouldn't normally show up in C++98/03 code, we
      // allow the use of rvalue references in C++98/03 for the benefit of
      // standard library implementors; therefore, we need the xvalue check here.
      ICS.Unnamed_field2.Standard.DirectBinding
         = S.getLangOpts().CPlusPlus11
         || !(InitCategory.isPRValue() || T2.$arrow().isRecordType());
      ICS.Unnamed_field2.Standard.IsLvalueReference = !isRValRef;
      ICS.Unnamed_field2.Standard.BindsToFunctionLvalue = T2.$arrow().isFunctionType();
      ICS.Unnamed_field2.Standard.BindsToRvalue = InitCategory.isRValue();
      ICS.Unnamed_field2.Standard.BindsImplicitObjectArgumentWithoutRefQualifier = false;
      ICS.Unnamed_field2.Standard.ObjCLifetimeConversionBinding = ObjCLifetimeConversion.$deref();
      ICS.Unnamed_field2.Standard.CopyConstructor = null;
      ICS.Unnamed_field2.Standard.DeprecatedStringLiteralToCharPtr = false;
      return new ImplicitConversionSequence(ICS);
    }
    
    //            -- has a class type (i.e., T2 is a class type), where T1 is not
    //               reference-related to T2, and can be implicitly converted to
    //               an xvalue, class prvalue, or function lvalue of type
    //               "cv3 T3", where "cv1 T1" is reference-compatible with
    //               "cv3 T3",
    //
    //          then the reference is bound to the value of the initializer
    //          expression in the first case and to the result of the conversion
    //          in the second case (or, in either case, to an appropriate base
    //          class subobject).
    if (!SuppressUserConversions && RefRelationship == Sema.ReferenceCompareResult.Ref_Incompatible
       && T2.$arrow().isRecordType() && S.isCompleteType(new SourceLocation(DeclLoc), new QualType(T2))
       && FindConversionForRefInit(S, ICS, new QualType(DeclType), new SourceLocation(DeclLoc), 
        Init, new QualType(T2), /*AllowRvalues=*/ true, 
        AllowExplicit)) {
      // In the second case, if the reference is an rvalue reference
      // and the second standard conversion sequence of the
      // user-defined conversion sequence includes an lvalue-to-rvalue
      // conversion, the program is ill-formed.
      if (ICS.isUserDefined() && isRValRef
         && ICS.Unnamed_field2.UserDefined.After.First == ImplicitConversionKind.ICK_Lvalue_To_Rvalue) {
        ICS.setBad(BadConversionSequence.FailureKind.no_conversion, Init, new QualType(DeclType));
      }
      
      return new ImplicitConversionSequence(ICS);
    }
    
    // A temporary of function type cannot be created; don't even try.
    if (T1.$arrow().isFunctionType()) {
      return new ImplicitConversionSequence(ICS);
    }
    
    //       -- Otherwise, a temporary of type "cv1 T1" is created and
    //          initialized from the initializer expression using the
    //          rules for a non-reference copy initialization (8.5). The
    //          reference is then bound to the temporary. If T1 is
    //          reference-related to T2, cv1 must be the same
    //          cv-qualification as, or greater cv-qualification than,
    //          cv2; otherwise, the program is ill-formed.
    if (RefRelationship == Sema.ReferenceCompareResult.Ref_Related) {
      // If cv1 == cv2 or cv1 is a greater cv-qualified than cv2, then
      // we would be reference-compatible or reference-compatible with
      // added qualification. But that wasn't the case, so the reference
      // initialization fails.
      //
      // Note that we only want to check address spaces and cvr-qualifiers here.
      // ObjC GC, lifetime and unaligned qualifiers aren't important.
      Qualifiers T1Quals = T1.getQualifiers();
      Qualifiers T2Quals = T2.getQualifiers();
      T1Quals.removeObjCGCAttr();
      T1Quals.removeObjCLifetime();
      T2Quals.removeObjCGCAttr();
      T2Quals.removeObjCLifetime();
      // MS compiler ignores __unaligned qualifier for references; do the same.
      T1Quals.removeUnaligned();
      T2Quals.removeUnaligned();
      if (!T1Quals.compatiblyIncludes(new Qualifiers(T2Quals))) {
        return new ImplicitConversionSequence(ICS);
      }
    }
    
    // If at least one of the types is a class type, the types are not
    // related, and we aren't allowed any user conversions, the
    // reference binding fails. This case is important for breaking
    // recursion, since TryImplicitConversion below will attempt to
    // create a temporary through the use of a copy constructor.
    if (SuppressUserConversions && RefRelationship == Sema.ReferenceCompareResult.Ref_Incompatible
       && (T1.$arrow().isRecordType() || T2.$arrow().isRecordType())) {
      return new ImplicitConversionSequence(ICS);
    }
    
    // If T1 is reference-related to T2 and the reference is an rvalue
    // reference, the initializer expression shall not be an lvalue.
    if (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Related.getValue()
       && isRValRef && Init.Classify(S.Context).isLValue()) {
      return new ImplicitConversionSequence(ICS);
    }
    
    // C++ [over.ics.ref]p2:
    //   When a parameter of reference type is not bound directly to
    //   an argument expression, the conversion sequence is the one
    //   required to convert the argument expression to the
    //   underlying type of the reference according to
    //   13.3.3.1. Conceptually, this conversion sequence corresponds
    //   to copy-initializing a temporary of the underlying type with
    //   the argument expression. Any difference in top-level
    //   cv-qualification is subsumed by the initialization itself
    //   and does not constitute a conversion.
    $c$.clean(ICS.$assign($c$.track(TryImplicitConversion(S, Init, new QualType(T1), SuppressUserConversions, 
            /*AllowExplicit=*/ false, 
            /*InOverloadResolution=*/ false, 
            /*CStyle=*/ false, 
            /*AllowObjCWritebackConversion=*/ false, 
            /*AllowObjCConversionOnExplicit=*/ false))));
    
    // Of course, that's still a reference binding.
    if (ICS.isStandard()) {
      ICS.Unnamed_field2.Standard.ReferenceBinding = true;
      ICS.Unnamed_field2.Standard.IsLvalueReference = !isRValRef;
      ICS.Unnamed_field2.Standard.BindsToFunctionLvalue = false;
      ICS.Unnamed_field2.Standard.BindsToRvalue = true;
      ICS.Unnamed_field2.Standard.BindsImplicitObjectArgumentWithoutRefQualifier = false;
      ICS.Unnamed_field2.Standard.ObjCLifetimeConversionBinding = false;
    } else if (ICS.isUserDefined()) {
      /*const*/ ReferenceType /*P*/ LValRefType = ICS.Unnamed_field2.UserDefined.ConversionFunction.getReturnType().$arrow().getAs(LValueReferenceType.class);
      
      // C++ [over.ics.ref]p3:
      //   Except for an implicit object parameter, for which see 13.3.1, a
      //   standard conversion sequence cannot be formed if it requires [...]
      //   binding an rvalue reference to an lvalue other than a function
      //   lvalue.
      // Note that the function case is not possible here.
      if (DeclType.$arrow().isRValueReferenceType() && (LValRefType != null)) {
        // FIXME: This is the wrong BadConversionSequence. The problem is binding
        // an rvalue reference to a (non-function) lvalue, not binding an lvalue
        // reference to an rvalue!
        ICS.setBad(BadConversionSequence.FailureKind.lvalue_ref_to_rvalue, Init, new QualType(DeclType));
        return new ImplicitConversionSequence(ICS);
      }
      
      ICS.Unnamed_field2.UserDefined.Before.setAsIdentityConversion();
      ICS.Unnamed_field2.UserDefined.After.ReferenceBinding = true;
      ICS.Unnamed_field2.UserDefined.After.IsLvalueReference = !isRValRef;
      ICS.Unnamed_field2.UserDefined.After.BindsToFunctionLvalue = false;
      ICS.Unnamed_field2.UserDefined.After.BindsToRvalue = !(LValRefType != null);
      ICS.Unnamed_field2.UserDefined.After.BindsImplicitObjectArgumentWithoutRefQualifier = false;
      ICS.Unnamed_field2.UserDefined.After.ObjCLifetimeConversionBinding = false;
    }
    
    return new ImplicitConversionSequence(ICS);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
    $c$.$destroy();
  }
}


/// TryCopyInitialization - Try to copy-initialize a value of type
/// ToType from the expression From. Return the implicit conversion
/// sequence required to pass this argument, which may be a bad
/// conversion sequence (meaning that the argument cannot be passed to
/// a parameter of this type). If @p SuppressUserConversions, then we
/// do not permit any user-defined conversion sequences.
//<editor-fold defaultstate="collapsed" desc="TryCopyInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4819,
 FQN="TryCopyInitialization", NM="_ZL21TryCopyInitializationRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21TryCopyInitializationRN5clang4SemaEPNS_4ExprENS_8QualTypeEbbbb")
//</editor-fold>
public static ImplicitConversionSequence TryCopyInitialization(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                     boolean SuppressUserConversions, 
                     boolean InOverloadResolution, 
                     boolean AllowObjCWritebackConversion) {
  return TryCopyInitialization(S, From, ToType, 
                     SuppressUserConversions, 
                     InOverloadResolution, 
                     AllowObjCWritebackConversion, 
                     false);
}
public static ImplicitConversionSequence TryCopyInitialization(final Sema /*&*/ S, Expr /*P*/ From, QualType ToType, 
                     boolean SuppressUserConversions, 
                     boolean InOverloadResolution, 
                     boolean AllowObjCWritebackConversion, 
                     boolean AllowExplicit/*= false*/) {
  {
    InitListExpr /*P*/ FromInitList = dyn_cast_InitListExpr(From);
    if ((FromInitList != null)) {
      return TryListConversion(S, FromInitList, new QualType(ToType), SuppressUserConversions, 
          InOverloadResolution, AllowObjCWritebackConversion);
    }
  }
  if (ToType.$arrow().isReferenceType()) {
    return TryReferenceInit(S, From, new QualType(ToType), 
        /*FIXME:*/ From.getLocStart(), 
        SuppressUserConversions, 
        AllowExplicit);
  }
  
  return TryImplicitConversion(S, From, new QualType(ToType), 
      SuppressUserConversions, 
      /*AllowExplicit=*/ false, 
      InOverloadResolution, 
      /*CStyle=*/ false, 
      AllowObjCWritebackConversion, 
      /*AllowObjCConversionOnExplicit=*/ false);
}


/// TryListConversion - Try to copy-initialize a value of type ToType from the
/// initializer list From.
//<editor-fold defaultstate="collapsed" desc="TryListConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4564,
 FQN="TryListConversion", NM="_ZL17TryListConversionRN5clang4SemaEPNS_12InitListExprENS_8QualTypeEbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL17TryListConversionRN5clang4SemaEPNS_12InitListExprENS_8QualTypeEbbb")
//</editor-fold>
public static ImplicitConversionSequence TryListConversion(final Sema /*&*/ S, InitListExpr /*P*/ From, QualType ToType, 
                 boolean SuppressUserConversions, 
                 boolean InOverloadResolution, 
                 boolean AllowObjCWritebackConversion) {
  ImplicitConversionSequence Result = null;
  try {
    // C++11 [over.ics.list]p1:
    //   When an argument is an initializer list, it is not an expression and
    //   special rules apply for converting it to a parameter type.
    Result/*J*/= new ImplicitConversionSequence();
    Result.setBad(BadConversionSequence.FailureKind.no_conversion, From, new QualType(ToType));
    
    // We need a complete type for what follows. Incomplete types can never be
    // initialized from init lists.
    if (!S.isCompleteType(From.getLocStart(), new QualType(ToType))) {
      return new ImplicitConversionSequence(Result);
    }
    
    // Per DR1467:
    //   If the parameter type is a class X and the initializer list has a single
    //   element of type cv U, where U is X or a class derived from X, the
    //   implicit conversion sequence is the one required to convert the element
    //   to the parameter type.
    //
    //   Otherwise, if the parameter type is a character array [... ]
    //   and the initializer list has a single element that is an
    //   appropriately-typed string literal (8.5.2 [dcl.init.string]), the
    //   implicit conversion sequence is the identity conversion.
    if (From.getNumInits() == 1) {
      if (ToType.$arrow().isRecordType()) {
        QualType InitType = From.getInit(0).getType();
        if (S.Context.hasSameUnqualifiedType(new QualType(InitType), new QualType(ToType))
           || S.IsDerivedFrom(From.getLocStart(), new QualType(InitType), new QualType(ToType))) {
          return TryCopyInitialization(S, From.getInit(0), new QualType(ToType), 
              SuppressUserConversions, 
              InOverloadResolution, 
              AllowObjCWritebackConversion);
        }
      }
      // FIXME: Check the other conditions here: array of character type,
      // initializer is a string literal.
      if (ToType.$arrow().isArrayType()) {
        InitializedEntity Entity = InitializedEntity.InitializeParameter(S.Context, new QualType(ToType), 
            /*Consumed=*/ false);
        if (S.CanPerformCopyInitialization(Entity, new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From))) {
          Result.setStandard();
          Result.Unnamed_field2.Standard.setAsIdentityConversion();
          Result.Unnamed_field2.Standard.setFromType(new QualType(ToType));
          Result.Unnamed_field2.Standard.setAllToTypes(new QualType(ToType));
          return new ImplicitConversionSequence(Result);
        }
      }
    }
    
    // C++14 [over.ics.list]p2: Otherwise, if the parameter type [...] (below).
    // C++11 [over.ics.list]p2:
    //   If the parameter type is std::initializer_list<X> or "array of X" and
    //   all the elements can be implicitly converted to X, the implicit
    //   conversion sequence is the worst conversion necessary to convert an
    //   element of the list to X.
    //
    // C++14 [over.ics.list]p3:
    //   Otherwise, if the parameter type is "array of N X", if the initializer
    //   list has exactly N elements or if it has fewer than N elements and X is
    //   default-constructible, and if all the elements of the initializer list
    //   can be implicitly converted to X, the implicit conversion sequence is
    //   the worst conversion necessary to convert an element of the list to X.
    //
    // FIXME: We're missing a lot of these checks.
    boolean toStdInitializerList = false;
    QualType X/*J*/= new QualType();
    if (ToType.$arrow().isArrayType()) {
      X.$assignMove(S.Context.getAsArrayType(new QualType(ToType)).getElementType());
    } else {
      toStdInitializerList = S.isStdInitializerList(new QualType(ToType), $AddrOf(create_type$ptr(X)));
    }
    if (!X.isNull()) {
      for (/*uint*/int i = 0, e = From.getNumInits(); $less_uint(i, e); ++i) {
        ImplicitConversionSequence ICS = null;
        try {
          Expr /*P*/ Init = From.getInit(i);
          ICS = TryCopyInitialization(S, Init, new QualType(X), SuppressUserConversions, 
              InOverloadResolution, 
              AllowObjCWritebackConversion);
          // If a single element isn't convertible, fail.
          if (ICS.isBad()) {
            Result.$assign(ICS);
            break;
          }
          // Otherwise, look for the worst conversion.
          if (Result.isBad()
             || CompareImplicitConversionSequences(S, From.getLocStart(), ICS, 
              Result)
             == ImplicitConversionSequence.CompareKind.Worse) {
            Result.$assign(ICS);
          }
        } finally {
          if (ICS != null) { ICS.$destroy(); }
        }
      }
      
      // For an empty list, we won't have computed any conversion sequence.
      // Introduce the identity conversion sequence.
      if (From.getNumInits() == 0) {
        Result.setStandard();
        Result.Unnamed_field2.Standard.setAsIdentityConversion();
        Result.Unnamed_field2.Standard.setFromType(new QualType(ToType));
        Result.Unnamed_field2.Standard.setAllToTypes(new QualType(ToType));
      }
      
      Result.setStdInitializerListElement(toStdInitializerList);
      return new ImplicitConversionSequence(Result);
    }
    
    // C++14 [over.ics.list]p4:
    // C++11 [over.ics.list]p3:
    //   Otherwise, if the parameter is a non-aggregate class X and overload
    //   resolution chooses a single best constructor [...] the implicit
    //   conversion sequence is a user-defined conversion sequence. If multiple
    //   constructors are viable but none is better than the others, the
    //   implicit conversion sequence is a user-defined conversion sequence.
    if (ToType.$arrow().isRecordType() && !ToType.$arrow().isAggregateType()) {
      // This function can deal with initializer lists.
      return TryUserDefinedConversion(S, From, new QualType(ToType), SuppressUserConversions, 
          /*AllowExplicit=*/ false, 
          InOverloadResolution, /*CStyle=*/ false, 
          AllowObjCWritebackConversion, 
          /*AllowObjCConversionOnExplicit=*/ false);
    }
    
    // C++14 [over.ics.list]p5:
    // C++11 [over.ics.list]p4:
    //   Otherwise, if the parameter has an aggregate type which can be
    //   initialized from the initializer list [...] the implicit conversion
    //   sequence is a user-defined conversion sequence.
    if (ToType.$arrow().isAggregateType()) {
      // Type is an aggregate, argument is an init list. At this point it comes
      // down to checking whether the initialization works.
      // FIXME: Find out whether this parameter is consumed or not.
      InitializedEntity Entity = InitializedEntity.InitializeParameter(S.Context, new QualType(ToType), 
          /*Consumed=*/ false);
      if (S.CanPerformCopyInitialization(Entity, new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From))) {
        Result.setUserDefined();
        Result.Unnamed_field2.UserDefined.Before.setAsIdentityConversion();
        // Initializer lists don't have a type.
        Result.Unnamed_field2.UserDefined.Before.setFromType(new QualType());
        Result.Unnamed_field2.UserDefined.Before.setAllToTypes(new QualType());
        
        Result.Unnamed_field2.UserDefined.After.setAsIdentityConversion();
        Result.Unnamed_field2.UserDefined.After.setFromType(new QualType(ToType));
        Result.Unnamed_field2.UserDefined.After.setAllToTypes(new QualType(ToType));
        Result.Unnamed_field2.UserDefined.ConversionFunction = null;
      }
      return new ImplicitConversionSequence(Result);
    }
    
    // C++14 [over.ics.list]p6:
    // C++11 [over.ics.list]p5:
    //   Otherwise, if the parameter is a reference, see 13.3.3.1.4.
    if (ToType.$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // The standard is notoriously unclear here, since 13.3.3.1.4 doesn't
        // mention initializer lists in any way. So we go by what list-
        // initialization would do and try to extrapolate from that.
        QualType T1 = ToType.$arrow().getAs(ReferenceType.class).getPointeeType();
        
        // If the initializer list has a single element that is reference-related
        // to the parameter type, we initialize the reference from that.
        if (From.getNumInits() == 1) {
          Expr /*P*/ Init = From.getInit(0);
          
          QualType T2 = Init.getType();
          
          // If the initializer is the address of an overloaded function, try
          // to resolve the overloaded function. If all goes well, T2 is the
          // type of the resulting function.
          if ($eq_CanQual$T_CanQual$U(S.Context.getCanonicalType(new QualType(T2)), /*NO_COPY*/S.Context.OverloadTy)) {
            DeclAccessPair Found/*J*/= new DeclAccessPair();
            {
              FunctionDecl /*P*/ Fn = S.ResolveAddressOfOverloadedFunction(Init, new QualType(ToType), false, Found);
              if ((Fn != null)) {
                T2.$assignMove(Fn.getType());
              }
            }
          }
          
          // Compute some basic properties of the types and the initializer.
          bool$ref dummy1 = create_bool$ref(false);
          bool$ref dummy2 = create_bool$ref(false);
          bool$ref dummy3 = create_bool$ref(false);
          Sema.ReferenceCompareResult RefRelationship = S.CompareReferenceRelationship(From.getLocStart(), new QualType(T1), new QualType(T2), dummy1, 
              dummy2, dummy3);
          if (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Related.getValue()) {
            return TryReferenceInit(S, Init, new QualType(ToType), /*FIXME*/ From.getLocStart(), 
                SuppressUserConversions, 
                /*AllowExplicit=*/ false);
          }
        }
        
        // Otherwise, we bind the reference to a temporary created from the
        // initializer list.
        $c$.clean(Result.$assign($c$.track(TryListConversion(S, From, new QualType(T1), SuppressUserConversions, 
                InOverloadResolution, 
                AllowObjCWritebackConversion))));
        if (Result.isFailure()) {
          return new ImplicitConversionSequence(Result);
        }
        assert (!Result.isEllipsis()) : "Sub-initialization cannot result in ellipsis conversion.";
        
        // Can we even bind to a temporary?
        if (ToType.$arrow().isRValueReferenceType()
           || (T1.isConstQualified() && !T1.isVolatileQualified())) {
          final StandardConversionSequence /*&*/ SCS = Result.isStandard() ? Result.Unnamed_field2.Standard : Result.Unnamed_field2.UserDefined.After;
          SCS.ReferenceBinding = true;
          SCS.IsLvalueReference = ToType.$arrow().isLValueReferenceType();
          SCS.BindsToRvalue = true;
          SCS.BindsToFunctionLvalue = false;
          SCS.BindsImplicitObjectArgumentWithoutRefQualifier = false;
          SCS.ObjCLifetimeConversionBinding = false;
        } else {
          Result.setBad(BadConversionSequence.FailureKind.lvalue_ref_to_rvalue, 
              From, new QualType(ToType));
        }
        return new ImplicitConversionSequence(Result);
      } finally {
        $c$.$destroy();
      }
    }
    
    // C++14 [over.ics.list]p7:
    // C++11 [over.ics.list]p6:
    //   Otherwise, if the parameter type is not a class:
    if (!ToType.$arrow().isRecordType()) {
      //    - if the initializer list has one element that is not itself an
      //      initializer list, the implicit conversion sequence is the one
      //      required to convert the element to the parameter type.
      /*uint*/int NumInits = From.getNumInits();
      if (NumInits == 1 && !isa_InitListExpr(From.getInit(0))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(Result.$assign($c$.track(TryCopyInitialization(S, From.getInit(0), new QualType(ToType), 
                  SuppressUserConversions, 
                  InOverloadResolution, 
                  AllowObjCWritebackConversion))));
        } finally {
          $c$.$destroy();
        }
      } else //    - if the initializer list has no elements, the implicit conversion
      //      sequence is the identity conversion.
      if (NumInits == 0) {
        Result.setStandard();
        Result.Unnamed_field2.Standard.setAsIdentityConversion();
        Result.Unnamed_field2.Standard.setFromType(new QualType(ToType));
        Result.Unnamed_field2.Standard.setAllToTypes(new QualType(ToType));
      }
      return new ImplicitConversionSequence(Result);
    }
    
    // C++14 [over.ics.list]p8:
    // C++11 [over.ics.list]p7:
    //   In all cases other than those enumerated above, no conversion is possible
    return new ImplicitConversionSequence(Result);
  } finally {
    if (Result != null) { Result.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="TryCopyInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4844,
 FQN="TryCopyInitialization", NM="_ZL21TryCopyInitializationN5clang7CanQualINS_4TypeEEES2_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21TryCopyInitializationN5clang7CanQualINS_4TypeEEES2_RNS_4SemaENS_14SourceLocationENS_13ExprValueKindE")
//</editor-fold>
public static boolean TryCopyInitialization(/*const*/ CanQual<Type> FromQTy, 
                     /*const*/ CanQual<Type> ToQTy, 
                     final Sema /*&*/ S, 
                     SourceLocation Loc, 
                     ExprValueKind FromVK) {
  ImplicitConversionSequence ICS = null;
  try {
    OpaqueValueExpr TmpExpr/*J*/= new OpaqueValueExpr(new SourceLocation(Loc), FromQTy.$QualType(), FromVK);
    ICS = TryCopyInitialization(S, $AddrOf(TmpExpr), ToQTy.$QualType(), true, true, false);
    
    return !ICS.isBad();
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// TryObjectArgumentInitialization - Try to initialize the object
/// parameter of the given member function (@c Method) from the
/// expression @p From.
//<editor-fold defaultstate="collapsed" desc="TryObjectArgumentInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 4859,
 FQN="TryObjectArgumentInitialization", NM="_ZL31TryObjectArgumentInitializationRN5clang4SemaENS_14SourceLocationENS_8QualTypeENS_4Expr14ClassificationEPNS_13CXXMethodDeclEPNS_13CXXRecordDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL31TryObjectArgumentInitializationRN5clang4SemaENS_14SourceLocationENS_8QualTypeENS_4Expr14ClassificationEPNS_13CXXMethodDeclEPNS_13CXXRecordDeclE")
//</editor-fold>
public static ImplicitConversionSequence TryObjectArgumentInitialization(final Sema /*&*/ S, SourceLocation Loc, QualType FromType, 
                               Expr.Classification FromClassification, 
                               CXXMethodDecl /*P*/ Method, 
                               CXXRecordDecl /*P*/ ActingContext) {
  ImplicitConversionSequence ICS = null;
  try {
    QualType ClassType = S.Context.getTypeDeclType(ActingContext);
    // [class.dtor]p2: A destructor can be invoked for a const, volatile or
    //                 const volatile object.
    /*uint*/int Quals = isa_CXXDestructorDecl(Method) ? Qualifiers.TQ.Const | Qualifiers.TQ.Volatile : Method.getTypeQualifiers();
    QualType ImplicitParamType = S.Context.getCVRQualifiedType(new QualType(ClassType), Quals);
    
    // Set up the conversion sequence as a "bad" conversion, to allow us
    // to exit early.
    ICS/*J*/= new ImplicitConversionSequence();
    {
      
      // We need to have an object of class type.
      /*const*/ PointerType /*P*/ PT = FromType.$arrow().getAs(PointerType.class);
      if ((PT != null)) {
        FromType.$assignMove(PT.getPointeeType());
        
        // When we had a pointer, it's implicitly dereferenced, so we
        // better have an lvalue.
        assert (FromClassification.isLValue());
      }
    }
    assert (FromType.$arrow().isRecordType());
    
    // C++0x [over.match.funcs]p4:
    //   For non-static member functions, the type of the implicit object
    //   parameter is
    //
    //     - "lvalue reference to cv X" for functions declared without a
    //        ref-qualifier or with the & ref-qualifier
    //     - "rvalue reference to cv X" for functions declared with the &&
    //        ref-qualifier
    //
    // where X is the class of which the function is a member and cv is the
    // cv-qualification on the member function declaration.
    //
    // However, when finding an implicit conversion sequence for the argument, we
    // are not allowed to create temporaries or perform user-defined conversions
    // (C++ [over.match.funcs]p5). We perform a simplified version of
    // reference binding here, that allows class rvalues to bind to
    // non-constant references.
    
    // First check the qualifiers.
    QualType FromTypeCanon = S.Context.getCanonicalType(new QualType(FromType)).$QualType();
    if (ImplicitParamType.getCVRQualifiers()
       != FromTypeCanon.getLocalCVRQualifiers()
       && !ImplicitParamType.isAtLeastAsQualifiedAs(new QualType(FromTypeCanon))) {
      ICS.setBad(BadConversionSequence.FailureKind.bad_qualifiers, 
          new QualType(FromType), new QualType(ImplicitParamType));
      return new ImplicitConversionSequence(ICS);
    }
    
    // Check that we have either the same type or a derived type. It
    // affects the conversion rank.
    QualType ClassTypeCanon = S.Context.getCanonicalType(new QualType(ClassType)).$QualType();
    ImplicitConversionKind SecondKind;
    if ($eq_QualType$C(ClassTypeCanon, FromTypeCanon.getLocalUnqualifiedType())) {
      SecondKind = ImplicitConversionKind.ICK_Identity;
    } else if (S.IsDerivedFrom(new SourceLocation(Loc), new QualType(FromType), new QualType(ClassType))) {
      SecondKind = ImplicitConversionKind.ICK_Derived_To_Base;
    } else {
      ICS.setBad(BadConversionSequence.FailureKind.unrelated_class, 
          new QualType(FromType), new QualType(ImplicitParamType));
      return new ImplicitConversionSequence(ICS);
    }
    
    // Check the ref-qualifier.
    switch (Method.getRefQualifier()) {
     case RQ_None:
      // Do nothing; we don't care about lvalueness or rvalueness.
      break;
     case RQ_LValue:
      if (!FromClassification.isLValue() && Quals != Qualifiers.TQ.Const) {
        // non-const lvalue reference cannot bind to an rvalue
        ICS.setBad(BadConversionSequence.FailureKind.lvalue_ref_to_rvalue, new QualType(FromType), 
            new QualType(ImplicitParamType));
        return new ImplicitConversionSequence(ICS);
      }
      break;
     case RQ_RValue:
      if (!FromClassification.isRValue()) {
        // rvalue reference cannot bind to an lvalue
        ICS.setBad(BadConversionSequence.FailureKind.rvalue_ref_to_lvalue, new QualType(FromType), 
            new QualType(ImplicitParamType));
        return new ImplicitConversionSequence(ICS);
      }
      break;
    }
    
    // Success. Mark this as a reference binding.
    ICS.setStandard();
    ICS.Unnamed_field2.Standard.setAsIdentityConversion();
    ICS.Unnamed_field2.Standard.Second = SecondKind;
    ICS.Unnamed_field2.Standard.setFromType(new QualType(FromType));
    ICS.Unnamed_field2.Standard.setAllToTypes(new QualType(ImplicitParamType));
    ICS.Unnamed_field2.Standard.ReferenceBinding = true;
    ICS.Unnamed_field2.Standard.DirectBinding = true;
    ICS.Unnamed_field2.Standard.IsLvalueReference = Method.getRefQualifier() != RefQualifierKind.RQ_RValue;
    ICS.Unnamed_field2.Standard.BindsToFunctionLvalue = false;
    ICS.Unnamed_field2.Standard.BindsToRvalue = FromClassification.isRValue();
    ICS.Unnamed_field2.Standard.BindsImplicitObjectArgumentWithoutRefQualifier
       = (Method.getRefQualifier() == RefQualifierKind.RQ_None);
    return new ImplicitConversionSequence(ICS);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// TryContextuallyConvertToBool - Attempt to contextually convert the
/// expression From to bool (C++0x [conv]p3).
//<editor-fold defaultstate="collapsed" desc="TryContextuallyConvertToBool">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5034,
 FQN="TryContextuallyConvertToBool", NM="_ZL28TryContextuallyConvertToBoolRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL28TryContextuallyConvertToBoolRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static ImplicitConversionSequence TryContextuallyConvertToBool(final Sema /*&*/ S, Expr /*P*/ From) {
  return TryImplicitConversion(S, From, S.Context.BoolTy.$QualType(), 
      /*SuppressUserConversions=*/ false, 
      /*AllowExplicit=*/ true, 
      /*InOverloadResolution=*/ false, 
      /*CStyle=*/ false, 
      /*AllowObjCWritebackConversion=*/ false, 
      /*AllowObjCConversionOnExplicit=*/ false);
}


/// Check that the specified conversion is permitted in a converted constant
/// expression, according to C++11 [expr.const]p3. Return true if the conversion
/// is acceptable.
//<editor-fold defaultstate="collapsed" desc="CheckConvertedConstantConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5065,
 FQN="CheckConvertedConstantConversions", NM="_ZL33CheckConvertedConstantConversionsRN5clang4SemaERNS_26StandardConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL33CheckConvertedConstantConversionsRN5clang4SemaERNS_26StandardConversionSequenceE")
//</editor-fold>
public static boolean CheckConvertedConstantConversions(final Sema /*&*/ S, 
                                 final StandardConversionSequence /*&*/ SCS) {
  // Since we know that the target type is an integral or unscoped enumeration
  // type, most conversion kinds are impossible. All possible First and Third
  // conversions are fine.
  switch (SCS.Second) {
   case ICK_Identity:
   case ICK_NoReturn_Adjustment:
   case ICK_Integral_Promotion:
   case ICK_Integral_Conversion: // Narrowing conversions are checked elsewhere.
    return true;
   case ICK_Boolean_Conversion:
    // Conversion from an integral or unscoped enumeration type to bool is
    // classified as ICK_Boolean_Conversion, but it's also arguably an integral
    // conversion, so we allow it in a converted constant expression.
    //
    // FIXME: Per core issue 1407, we should not allow this, but that breaks
    // a lot of popular code. We should at least add a warning for this
    // (non-conforming) extension.
    return SCS.getFromType().$arrow().isIntegralOrUnscopedEnumerationType()
       && SCS.getToType(2).$arrow().isBooleanType();
   case ICK_Pointer_Conversion:
   case ICK_Pointer_Member:
    // C++1z: null pointer conversions and null member pointer conversions are
    // only permitted if the source type is std::nullptr_t.
    return SCS.getFromType().$arrow().isNullPtrType();
   case ICK_Floating_Promotion:
   case ICK_Complex_Promotion:
   case ICK_Floating_Conversion:
   case ICK_Complex_Conversion:
   case ICK_Floating_Integral:
   case ICK_Compatible_Conversion:
   case ICK_Derived_To_Base:
   case ICK_Vector_Conversion:
   case ICK_Vector_Splat:
   case ICK_Complex_Real:
   case ICK_Block_Pointer_Conversion:
   case ICK_TransparentUnionConversion:
   case ICK_Writeback_Conversion:
   case ICK_Zero_Event_Conversion:
   case ICK_C_Only_Conversion:
    return false;
   case ICK_Lvalue_To_Rvalue:
   case ICK_Array_To_Pointer:
   case ICK_Function_To_Pointer:
    throw new llvm_unreachable("found a first conversion kind in Second");
   case ICK_Qualification:
    throw new llvm_unreachable("found a third conversion kind in Second");
   case ICK_Num_Conversion_Kinds:
    break;
  }
  throw new llvm_unreachable("unknown conversion kind");
}


/// CheckConvertedConstantExpression - Check that the expression From is a
/// converted constant expression of type T, perform the conversion and produce
/// the converted expression, per C++11 [expr.const]p3.
//<editor-fold defaultstate="collapsed" desc="CheckConvertedConstantExpression">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5129,
 FQN="CheckConvertedConstantExpression", NM="_ZL32CheckConvertedConstantExpressionRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_7APValueENS0_7CCEKindEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL32CheckConvertedConstantExpressionRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_7APValueENS0_7CCEKindEb")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > CheckConvertedConstantExpression(final Sema /*&*/ S, Expr /*P*/ From, 
                                QualType T, final APValue /*&*/ Value, 
                                Sema.CCEKind CCE, 
                                boolean RequireInt) {
  ImplicitConversionSequence ICS = null;
  APValue PreNarrowingValue = null;
  OptionalNotes Notes = null;
  Expr.EvalResult Eval = null;
  try {
    assert (S.getLangOpts().CPlusPlus11) : "converted constant expression outside C++11";
    if (checkPlaceholderForOverload(S, create_type$ref(From))) {
      return ExprError();
    }
    
    // C++1z [expr.const]p3:
    //  A converted constant expression of type T is an expression,
    //  implicitly converted to type T, where the converted
    //  expression is a constant expression and the implicit conversion
    //  sequence contains only [... list of conversions ...].
    ICS = TryCopyInitialization(S, From, new QualType(T), 
        /*SuppressUserConversions=*/ false, 
        /*InOverloadResolution=*/ false, 
        /*AllowObjcWritebackConversion=*/ false, 
        /*AllowExplicit=*/ false);
    StandardConversionSequence /*P*/ SCS = null;
    switch (ICS.getKind()) {
     case StandardConversion:
      SCS = $AddrOf(ICS.Unnamed_field2.Standard);
      break;
     case UserDefinedConversion:
      // We are converting to a non-class type, so the Before sequence
      // must be trivial.
      SCS = $AddrOf(ICS.Unnamed_field2.UserDefined.After);
      break;
     case AmbiguousConversion:
     case BadConversion:
      if (!S.DiagnoseMultipleUserDefinedConversion(From, new QualType(T))) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(From.getLocStart(), 
                              diag.err_typecheck_converted_constant_expression)), 
                          From.getType()), From.getSourceRange()), T)));
        } finally {
          $c$.$destroy();
        }
      }
      return ExprError();
     case EllipsisConversion:
      throw new llvm_unreachable("ellipsis conversion in converted constant expression");
    }
    
    // Check that we would only use permitted conversions.
    if (!CheckConvertedConstantConversions(S, $Deref(SCS))) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(From.getLocStart(), 
                            diag.err_typecheck_converted_constant_expression_disallowed)), 
                        From.getType()), From.getSourceRange()), T)));
      } finally {
        $c$.$destroy();
      }
    }
    // [...] and where the reference binding (if any) binds directly.
    if (SCS.ReferenceBinding && !SCS.DirectBinding) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(From.getLocStart(), 
                            diag.err_typecheck_converted_constant_expression_indirect)), 
                        From.getType()), From.getSourceRange()), T)));
      } finally {
        $c$.$destroy();
      }
    }
    
    ActionResultTTrue<Expr /*P*/ > Result = S.PerformImplicitConversion(From, new QualType(T), ICS, Sema.AssignmentAction.AA_Converting);
    if (Result.isInvalid()) {
      return Result;
    }
    
    // Check for a narrowing implicit conversion.
    PreNarrowingValue/*J*/= new APValue();
    QualType PreNarrowingType/*J*/= new QualType();
    switch (SCS.getNarrowingKind(S.Context, Result.get(), PreNarrowingValue, 
        PreNarrowingType)) {
     case NK_Variable_Narrowing:
     case NK_Not_Narrowing:
      // Implicit conversion to a narrower type, and the value is not a constant
      // expression. We'll diagnose this in a moment.
      break;
     case NK_Constant_Narrowing:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(From.getLocStart(), diag.ext_cce_narrowing)), 
                          CCE), /*Constant*/ 1), 
                  PreNarrowingValue.getAsString(S.Context, new QualType(PreNarrowingType))), T));
          break;
        } finally {
          $c$.$destroy();
        }
      }
     case NK_Type_Narrowing:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(From.getLocStart(), diag.ext_cce_narrowing)), 
                          CCE), /*Constant*/ 0), From.getType()), T));
          break;
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    // Check the expression is a constant expression.
    Notes/*J*/= new OptionalNotes(8);
    Eval/*J*/= new Expr.EvalResult();
    Eval.Diag = $AddrOf(Notes);
    if ((T.$arrow().isReferenceType() ? !Result.get().EvaluateAsLValue(Eval, S.Context) : !Result.get().EvaluateAsRValue(Eval, S.Context))
       || (RequireInt && !Eval.Val.isInt())) {
      // The expression can't be folded, so we can't keep it at this position in
      // the AST.
      Result.$assignMove(ExprError());
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Value.$assign($c$.track(new APValue(Eval.Val))));
        if (Notes.empty()) {
          // It's a constant expression.
          return Result;
        }
      } finally {
        $c$.$destroy();
      }
    }
    
    // It's not a constant expression. Produce an appropriate diagnostic.
    if (Notes.size() == 1
       && Notes.$at(0).second.getDiagID() == diag.note_invalid_subexpr_in_const_expr) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Notes.$at(0).first), diag.err_expr_not_cce)), CCE));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(From.getLocStart(), diag.err_expr_not_cce)), 
                CCE), From.getSourceRange()));
        for (/*uint*/int I = 0; $less_uint(I, Notes.size()); ++I)  {
          $c$.clean($c$.track(S.Diag(new SourceLocation(Notes.$at(I).first), Notes.$at(I).second)));
        }
      } finally {
        $c$.$destroy();
      }
    }
    return ExprError();
  } finally {
    if (Eval != null) { Eval.$destroy(); }
    if (Notes != null) { Notes.$destroy(); }
    if (PreNarrowingValue != null) { PreNarrowingValue.$destroy(); }
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// dropPointerConversions - If the given standard conversion sequence
/// involves any pointer conversions, remove them.  This may change
/// the result type of the conversion sequence.
//<editor-fold defaultstate="collapsed" desc="dropPointerConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5268,
 FQN="dropPointerConversion", NM="_ZL21dropPointerConversionRN5clang26StandardConversionSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21dropPointerConversionRN5clang26StandardConversionSequenceE")
//</editor-fold>
public static void dropPointerConversion(final StandardConversionSequence /*&*/ SCS) {
  if (SCS.Second == ImplicitConversionKind.ICK_Pointer_Conversion) {
    SCS.Second = ImplicitConversionKind.ICK_Identity;
    SCS.Third = ImplicitConversionKind.ICK_Identity;
    SCS.ToTypePtrs[2] = SCS.ToTypePtrs[1] = SCS.ToTypePtrs[0];
  }
}


/// TryContextuallyConvertToObjCPointer - Attempt to contextually
/// convert the expression From to an Objective-C pointer type.
//<editor-fold defaultstate="collapsed" desc="TryContextuallyConvertToObjCPointer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5278,
 FQN="TryContextuallyConvertToObjCPointer", NM="_ZL35TryContextuallyConvertToObjCPointerRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL35TryContextuallyConvertToObjCPointerRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static ImplicitConversionSequence TryContextuallyConvertToObjCPointer(final Sema /*&*/ S, Expr /*P*/ From) {
  ImplicitConversionSequence ICS = null;
  try {
    // Do an implicit conversion to 'id'.
    QualType Ty = S.Context.getObjCIdType();
    ICS = TryImplicitConversion(S, From, new QualType(Ty), 
        // FIXME: Are these flags correct?
        /*SuppressUserConversions=*/ false, 
        /*AllowExplicit=*/ true, 
        /*InOverloadResolution=*/ false, 
        /*CStyle=*/ false, 
        /*AllowObjCWritebackConversion=*/ false, 
        /*AllowObjCConversionOnExplicit=*/ true);
    
    // Strip off any final conversions to 'id'.
    switch (ICS.getKind()) {
     case BadConversion:
     case AmbiguousConversion:
     case EllipsisConversion:
      break;
     case UserDefinedConversion:
      dropPointerConversion(ICS.Unnamed_field2.UserDefined.After);
      break;
     case StandardConversion:
      dropPointerConversion(ICS.Unnamed_field2.Standard);
      break;
    }
    
    return new ImplicitConversionSequence(ICS);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="diagnoseAmbiguousConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5332,
 FQN="diagnoseAmbiguousConversion", NM="_ZL27diagnoseAmbiguousConversionRN5clang4SemaENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeERNS_17UnresolvedSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL27diagnoseAmbiguousConversionRN5clang4SemaENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeERNS_17UnresolvedSetImplE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > diagnoseAmbiguousConversion(final Sema /*&*/ SemaRef, SourceLocation Loc, Expr /*P*/ From, 
                           final Sema.ContextualImplicitConverter /*&*/ Converter, 
                           QualType T, final UnresolvedSetImpl /*&*/ ViableConversions) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (Converter.Suppress) {
      return ExprError();
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Converter.diagnoseAmbiguous(SemaRef, new SourceLocation(Loc), new QualType(T))), From.getSourceRange()));
    for (/*uint*/int I = 0, N = ViableConversions.size(); I != N; ++I) {
      CXXConversionDecl /*P*/ Conv = cast_CXXConversionDecl(ViableConversions.$at(I).$arrow().getUnderlyingDecl());
      QualType ConvTy = Conv.getConversionType().getNonReferenceType();
      $c$.clean($c$.track(Converter.noteAmbiguous(SemaRef, Conv, new QualType(ConvTy))));
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, From);
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="diagnoseNoViableConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5350,
 FQN="diagnoseNoViableConversion", NM="_ZL26diagnoseNoViableConversionRN5clang4SemaENS_14SourceLocationERPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeEbRNS_17UnresolvedSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL26diagnoseNoViableConversionRN5clang4SemaENS_14SourceLocationERPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeEbRNS_17UnresolvedSetImplE")
//</editor-fold>
public static boolean diagnoseNoViableConversion(final Sema /*&*/ SemaRef, SourceLocation Loc, final type$ptr<Expr /*P*/ /*&*/> From, 
                          final Sema.ContextualImplicitConverter /*&*/ Converter, 
                          QualType T, boolean HadMultipleCandidates, 
                          final UnresolvedSetImpl /*&*/ ExplicitConversions) {
  if (ExplicitConversions.size() == 1 && !Converter.Suppress) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      DeclAccessPair Found = new DeclAccessPair(ExplicitConversions.$at(0));
      CXXConversionDecl /*P*/ Conversion = cast_CXXConversionDecl(Found.$arrow().getUnderlyingDecl());
      
      // The user probably meant to invoke the given explicit
      // conversion; use it.
      QualType ConvTy = Conversion.getConversionType().getNonReferenceType();
      std.string TypeStr/*J*/= new std.string();
      ConvTy.getAsStringInternal(TypeStr, SemaRef.getPrintingPolicy());
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Converter.diagnoseExplicitConv(SemaRef, new SourceLocation(Loc), new QualType(T), new QualType(ConvTy))), 
              FixItHint.CreateInsertion(From./*->*/$star().getLocStart(), 
                  new StringRef($add_string_T$C$P($add_T$C$P_string$C(/*KEEP_STR*/"static_cast<", TypeStr), /*KEEP_STR*/">(")))), 
          FixItHint.CreateInsertion(SemaRef.getLocForEndOfToken(From./*->*/$star().getLocEnd()), new StringRef(/*KEEP_STR*/$RPAREN))));
      $c$.clean($c$.track(Converter.noteExplicitConv(SemaRef, Conversion, new QualType(ConvTy))));
      
      // If we aren't in a SFINAE context, build a call to the
      // explicit conversion function.
      if (SemaRef.isSFINAEContext().$bool()) {
        return true;
      }
      
      SemaRef.CheckMemberOperatorAccess(From./*->*/$star().getExprLoc(), From.$star(), (Expr /*P*/ )null, new DeclAccessPair(Found));
      ActionResultTTrue<Expr /*P*/ > Result = SemaRef.BuildCXXMemberCallExpr(From.$star(), Found.$NamedDecl$P(), Conversion, 
          HadMultipleCandidates);
      if (Result.isInvalid()) {
        return true;
      }
      // Record usage of conversion in an implicit cast.
      From.$set(ImplicitCastExpr.Create(SemaRef.Context, Result.get().getType(), 
          CastKind.CK_UserDefinedConversion, Result.get(), 
          (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, Result.get().getValueKind()));
    } finally {
      $c$.$destroy();
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="recordConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5391,
 FQN="recordConversion", NM="_ZL16recordConversionRN5clang4SemaENS_14SourceLocationERPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeEbRNS_14DeclAccessPairE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL16recordConversionRN5clang4SemaENS_14SourceLocationERPNS_4ExprERNS0_27ContextualImplicitConverterENS_8QualTypeEbRNS_14DeclAccessPairE")
//</editor-fold>
public static boolean recordConversion(final Sema /*&*/ SemaRef, SourceLocation Loc, final type$ptr<Expr /*P*/ /*&*/> From, 
                final Sema.ContextualImplicitConverter /*&*/ Converter, 
                QualType T, boolean HadMultipleCandidates, 
                final DeclAccessPair /*&*/ Found) {
  CXXConversionDecl /*P*/ Conversion = cast_CXXConversionDecl(Found.$arrow().getUnderlyingDecl());
  SemaRef.CheckMemberOperatorAccess(From./*->*/$star().getExprLoc(), From.$star(), (Expr /*P*/ )null, new DeclAccessPair(Found));
  
  QualType ToType = Conversion.getConversionType().getNonReferenceType();
  if (!Converter.SuppressConversion) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (SemaRef.isSFINAEContext().$bool()) {
        return true;
      }
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Converter.diagnoseConversion(SemaRef, new SourceLocation(Loc), new QualType(T), new QualType(ToType))), 
          From./*->*/$star().getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > Result = SemaRef.BuildCXXMemberCallExpr(From.$star(), Found.$NamedDecl$P(), Conversion, 
      HadMultipleCandidates);
  if (Result.isInvalid()) {
    return true;
  }
  // Record usage of conversion in an implicit cast.
  From.$set(ImplicitCastExpr.Create(SemaRef.Context, Result.get().getType(), 
      CastKind.CK_UserDefinedConversion, Result.get(), 
      (/*const*/SmallVector<CXXBaseSpecifier /*P*/> /*P*/)null, Result.get().getValueKind()));
  return false;
}

//<editor-fold defaultstate="collapsed" desc="finishContextualImplicitConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5419,
 FQN="finishContextualImplicitConversion", NM="_ZL34finishContextualImplicitConversionRN5clang4SemaENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34finishContextualImplicitConversionRN5clang4SemaENS_14SourceLocationEPNS_4ExprERNS0_27ContextualImplicitConverterE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > finishContextualImplicitConversion(final Sema /*&*/ SemaRef, SourceLocation Loc, Expr /*P*/ From, 
                                  final Sema.ContextualImplicitConverter /*&*/ Converter) {
  if (!Converter.match(From.getType()) && !Converter.Suppress) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(Converter.diagnoseNoMatch(SemaRef, new SourceLocation(Loc), From.getType())), 
          From.getSourceRange()));
    } finally {
      $c$.$destroy();
    }
  }
  
  return SemaRef.DefaultLvalueConversion(From);
}

//<editor-fold defaultstate="collapsed" desc="collectViableConversionCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5429,
 FQN="collectViableConversionCandidates", NM="_ZL33collectViableConversionCandidatesRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_17UnresolvedSetImplERNS_20OverloadCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL33collectViableConversionCandidatesRN5clang4SemaEPNS_4ExprENS_8QualTypeERNS_17UnresolvedSetImplERNS_20OverloadCandidateSetE")
//</editor-fold>
public static void collectViableConversionCandidates(final Sema /*&*/ SemaRef, Expr /*P*/ From, QualType ToType, 
                                 final UnresolvedSetImpl /*&*/ ViableConversions, 
                                 final OverloadCandidateSet /*&*/ CandidateSet) {
  for (/*uint*/int I = 0, N = ViableConversions.size(); I != N; ++I) {
    DeclAccessPair FoundDecl = new DeclAccessPair(ViableConversions.$at(I));
    NamedDecl /*P*/ D = FoundDecl.getDecl();
    CXXRecordDecl /*P*/ ActingContext = cast_CXXRecordDecl(D.getDeclContext());
    if (isa_UsingShadowDecl(D)) {
      D = cast_UsingShadowDecl(D).getTargetDecl();
    }
    
    CXXConversionDecl /*P*/ Conv;
    FunctionTemplateDecl /*P*/ ConvTemplate;
    if (((ConvTemplate = dyn_cast_FunctionTemplateDecl(D)) != null)) {
      Conv = cast_CXXConversionDecl(ConvTemplate.getTemplatedDecl());
    } else {
      Conv = cast_CXXConversionDecl(D);
    }
    if ((ConvTemplate != null)) {
      SemaRef.AddTemplateConversionCandidate(ConvTemplate, new DeclAccessPair(FoundDecl), ActingContext, From, new QualType(ToType), CandidateSet, 
          /*AllowObjCConversionOnExplicit=*/ false);
    } else {
      SemaRef.AddConversionCandidate(Conv, new DeclAccessPair(FoundDecl), ActingContext, From, 
          new QualType(ToType), CandidateSet, 
          /*AllowObjCConversionOnExplicit=*/ false);
    }
  }
}


/// IsAcceptableNonMemberOperatorCandidate - Determine whether Fn is
/// an acceptable non-member overloaded operator for a call whose
/// arguments have types T1 (and, if non-empty, T2). This routine
/// implements the check in C++ [over.match.oper]p3b2 concerning
/// enumeration types.
//<editor-fold defaultstate="collapsed" desc="IsAcceptableNonMemberOperatorCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5664,
 FQN="IsAcceptableNonMemberOperatorCandidate", NM="_ZL38IsAcceptableNonMemberOperatorCandidateRN5clang10ASTContextEPNS_12FunctionDeclEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL38IsAcceptableNonMemberOperatorCandidateRN5clang10ASTContextEPNS_12FunctionDeclEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static boolean IsAcceptableNonMemberOperatorCandidate(final ASTContext /*&*/ Context, 
                                      FunctionDecl /*P*/ Fn, 
                                      ArrayRef<Expr /*P*/ > Args) {
  QualType T1 = Args.$at(0).getType();
  QualType T2 = $greater_uint(Args.size(), 1) ? Args.$at(1).getType() : new QualType();
  if (T1.$arrow().isDependentType() || (!T2.isNull() && T2.$arrow().isDependentType())) {
    return true;
  }
  if (T1.$arrow().isRecordType() || (!T2.isNull() && T2.$arrow().isRecordType())) {
    return true;
  }
  
  /*const*/ FunctionProtoType /*P*/ Proto = Fn.getType().$arrow().getAs(FunctionProtoType.class);
  if ($less_uint(Proto.getNumParams(), 1)) {
    return false;
  }
  if (T1.$arrow().isEnumeralType()) {
    QualType ArgType = Proto.getParamType(0).getNonReferenceType();
    if (Context.hasSameUnqualifiedType(new QualType(T1), new QualType(ArgType))) {
      return true;
    }
  }
  if ($less_uint(Proto.getNumParams(), 2)) {
    return false;
  }
  if (!T2.isNull() && T2.$arrow().isEnumeralType()) {
    QualType ArgType = Proto.getParamType(1).getNonReferenceType();
    if (Context.hasSameUnqualifiedType(new QualType(T2), new QualType(ArgType))) {
      return true;
    }
  }
  
  return false;
}


// specific_attr_iterator iterates over enable_if attributes in reverse, and
// enable_if is order-sensitive. As a result, we need to reverse things
// sometimes. Size of 4 elements is arbitrary.
//<editor-fold defaultstate="collapsed" desc="getOrderedEnableIfAttrs">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 5953,
 FQN="getOrderedEnableIfAttrs", NM="_ZL23getOrderedEnableIfAttrsPKN5clang12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL23getOrderedEnableIfAttrsPKN5clang12FunctionDeclE")
//</editor-fold>
public static SmallVector<EnableIfAttr /*P*/ > getOrderedEnableIfAttrs(/*const*/ FunctionDecl /*P*/ Function) {
  SmallVector<EnableIfAttr /*P*/ > Result/*J*/= new SmallVector<EnableIfAttr /*P*/ >(4, (EnableIfAttr /*P*/ )null);
  if (!Function.hasAttrs()) {
    return Result;
  }
  
  final /*const*/SmallVector<Attr /*P*/>/*&*/ FuncAttrs = Function.getAttrs$Const();
  for (Attr /*P*/ $Attr : FuncAttrs)  {
    {
      EnableIfAttr /*P*/ EnableIf = dyn_cast_EnableIfAttr($Attr);
      if ((EnableIf != null)) {
        Result.push_back(EnableIf);
      }
    }
  }
  
  std.reverse(Result.begin(), Result.end());
  return Result;
}


/// Determine whether this is an allowable conversion from the result
/// of an explicit conversion operator to the expected type, per C++
/// [over.match.conv]p1 and [over.match.ref]p1.
///
/// \param ConvType The return type of the conversion function.
///
/// \param ToType The type we are converting to.
///
/// \param AllowObjCPointerConversion Allow a conversion from one
/// Objective-C pointer to another.
///
/// \returns true if the conversion is allowable, false otherwise.
//<editor-fold defaultstate="collapsed" desc="isAllowableExplicitConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 6357,
 FQN="isAllowableExplicitConversion", NM="_ZL29isAllowableExplicitConversionRN5clang4SemaENS_8QualTypeES2_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL29isAllowableExplicitConversionRN5clang4SemaENS_8QualTypeES2_b")
//</editor-fold>
public static boolean isAllowableExplicitConversion(final Sema /*&*/ S, 
                             QualType ConvType, QualType ToType, 
                             boolean AllowObjCPointerConversion) {
  QualType ToNonRefType = ToType.getNonReferenceType();
  
  // Easy case: the types are the same.
  if (S.Context.hasSameUnqualifiedType(new QualType(ConvType), new QualType(ToNonRefType))) {
    return true;
  }
  
  // Allow qualification conversions.
  bool$ref ObjCLifetimeConversion = create_bool$ref();
  if (S.IsQualificationConversion(new QualType(ConvType), new QualType(ToNonRefType), /*CStyle*/ false, 
      ObjCLifetimeConversion)) {
    return true;
  }
  
  // If we're not allowed to consider Objective-C pointer conversions,
  // we're done.
  if (!AllowObjCPointerConversion) {
    return false;
  }
  
  // Is this an Objective-C pointer conversion?
  bool$ref IncompatibleObjC = create_bool$ref(false);
  QualType ConvertedType/*J*/= new QualType();
  return S.isObjCPointerConversion(new QualType(ConvType), new QualType(ToNonRefType), ConvertedType, 
      IncompatibleObjC);
}


/// \brief Helper function for AddBuiltinOperatorCandidates() that adds
/// the volatile- and non-volatile-qualified assignment operators for the
/// given type to the candidate set.
//<editor-fold defaultstate="collapsed" desc="AddBuiltinAssignmentOperatorCandidates">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7111,
 FQN="AddBuiltinAssignmentOperatorCandidates", NM="_ZL38AddBuiltinAssignmentOperatorCandidatesRN5clang4SemaENS_8QualTypeEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL38AddBuiltinAssignmentOperatorCandidatesRN5clang4SemaENS_8QualTypeEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetE")
//</editor-fold>
public static void AddBuiltinAssignmentOperatorCandidates(final Sema /*&*/ S, 
                                      QualType T, 
                                      ArrayRef<Expr /*P*/ > Args, 
                                      final OverloadCandidateSet /*&*/ CandidateSet) {
  QualType ParamTypes[/*2*/]/*J*/= new$T(new QualType [2], ()->new QualType());
  
  // T& operator=(T&, T)
  ParamTypes[0].$assignMove(S.Context.getLValueReferenceType(new QualType(T)));
  ParamTypes[1].$assign(T);
  S.AddBuiltinCandidate(new QualType(ParamTypes[0]), create_type$ptr(ParamTypes), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
      /*IsAssignmentOperator=*/ true);
  if (!S.Context.getCanonicalType(new QualType(T)).isVolatileQualified()) {
    // volatile T& operator=(volatile T&, T)
    ParamTypes[0].$assignMove(
        S.Context.getLValueReferenceType(S.Context.getVolatileType(new QualType(T)))
    );
    ParamTypes[1].$assign(T);
    S.AddBuiltinCandidate(new QualType(ParamTypes[0]), create_type$ptr(ParamTypes), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
        /*IsAssignmentOperator=*/ true);
  }
}


/// CollectVRQualifiers - This routine returns Volatile/Restrict qualifiers,
/// if any, found in visible type conversion functions found in ArgExpr's type.
//<editor-fold defaultstate="collapsed" desc="CollectVRQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 7135,
 FQN="CollectVRQualifiers", NM="_ZL19CollectVRQualifiersRN5clang10ASTContextEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL19CollectVRQualifiersRN5clang10ASTContextEPNS_4ExprE")
//</editor-fold>
public static Qualifiers CollectVRQualifiers(final ASTContext /*&*/ Context, Expr /*P*/ ArgExpr) {
  Qualifiers VRQuals/*J*/= new Qualifiers();
  /*const*/ RecordType /*P*/ TyRec;
  {
    /*const*/ MemberPointerType /*P*/ RHSMPType = ArgExpr.getType().$arrow().getAs(MemberPointerType.class);
    if ((RHSMPType != null)) {
      TyRec = RHSMPType.__getClass().<RecordType>getAs$RecordType();
    } else {
      TyRec = ArgExpr.getType().$arrow().<RecordType>getAs$RecordType();
    }
  }
  if (!(TyRec != null)) {
    // Just to be safe, assume the worst case.
    VRQuals.addVolatile();
    VRQuals.addRestrict();
    return VRQuals;
  }
  
  CXXRecordDecl /*P*/ ClassDecl = cast_CXXRecordDecl(TyRec.getDecl());
  if (!ClassDecl.hasDefinition()) {
    return VRQuals;
  }
  
  for (NamedDecl /*P*/ D : ClassDecl.getVisibleConversionFunctions()) {
    if (isa_UsingShadowDecl(D)) {
      D = cast_UsingShadowDecl(D).getTargetDecl();
    }
    {
      CXXConversionDecl /*P*/ Conv = dyn_cast_CXXConversionDecl(D);
      if ((Conv != null)) {
        QualType CanTy = Context.getCanonicalType(Conv.getConversionType()).$QualType();
        {
          /*const*/ ReferenceType /*P*/ ResTypeRef = CanTy.$arrow().getAs(ReferenceType.class);
          if ((ResTypeRef != null)) {
            CanTy.$assignMove(ResTypeRef.getPointeeType());
          }
        }
        // Need to go down the pointer/mempointer chain and add qualifiers
        // as see them.
        boolean done = false;
        while (!done) {
          if (CanTy.isRestrictQualified()) {
            VRQuals.addRestrict();
          }
          {
            /*const*/ PointerType /*P*/ ResTypePtr = CanTy.$arrow().getAs(PointerType.class);
            if ((ResTypePtr != null)) {
              CanTy.$assignMove(ResTypePtr.getPointeeType());
            } else {
              /*const*/ MemberPointerType /*P*/ ResTypeMPtr = CanTy.$arrow().getAs(MemberPointerType.class);
              if ((ResTypeMPtr != null)) {
                CanTy.$assignMove(ResTypeMPtr.getPointeeType());
              } else {
                done = true;
              }
            }
          }
          if (CanTy.isVolatileQualified()) {
            VRQuals.addVolatile();
          }
          if (VRQuals.hasRestrict() && VRQuals.hasVolatile()) {
            return VRQuals;
          }
        }
      }
    }
  }
  return VRQuals;
}


/// Compares the enable_if attributes of two FunctionDecls, for the purposes of
/// overload resolution.
///
/// Cand1's set of enable_if attributes are said to be "better" than Cand2's iff
/// Cand1's first N enable_if attributes have precisely the same conditions as
/// Cand2's first N enable_if attributes (where N = the number of enable_if
/// attributes on Cand2), and Cand1 has more than N enable_if attributes.
///
/// Note that you can have a pair of candidates such that Cand1's enable_if
/// attributes are worse than Cand2's, and Cand2's enable_if attributes are
/// worse than Cand1's.
//<editor-fold defaultstate="collapsed" desc="compareEnableIfAttrs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8508,
 FQN="compareEnableIfAttrs", NM="_ZL20compareEnableIfAttrsRKN5clang4SemaEPKNS_12FunctionDeclES5_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL20compareEnableIfAttrsRKN5clang4SemaEPKNS_12FunctionDeclES5_")
//</editor-fold>
public static Comparison compareEnableIfAttrs(final /*const*/ Sema /*&*/ S, /*const*/ FunctionDecl /*P*/ Cand1, 
                    /*const*/ FunctionDecl /*P*/ Cand2) {
  FoldingSetNodeID Cand1ID = null;
  FoldingSetNodeID Cand2ID = null;
  try {
    // Common case: One (or both) decls don't have enable_if attrs.
    boolean Cand1Attr = Cand1.hasAttr(EnableIfAttr.class);
    boolean Cand2Attr = Cand2.hasAttr(EnableIfAttr.class);
    if (!Cand1Attr || !Cand2Attr) {
      if (Cand1Attr == Cand2Attr) {
        return Comparison.Equal;
      }
      return Cand1Attr ? Comparison.Better : Comparison.Worse;
    }
    
    // FIXME: The next several lines are just
    // specific_attr_iterator<EnableIfAttr> but going in declaration order,
    // instead of reverse order which is how they're stored in the AST.
    SmallVector<EnableIfAttr /*P*/ > Cand1Attrs = getOrderedEnableIfAttrs(Cand1);
    SmallVector<EnableIfAttr /*P*/ > Cand2Attrs = getOrderedEnableIfAttrs(Cand2);
    
    // It's impossible for Cand1 to be better than (or equal to) Cand2 if Cand1
    // has fewer enable_if attributes than Cand2.
    if ($less_uint(Cand1Attrs.size(), Cand2Attrs.size())) {
      return Comparison.Worse;
    }

    type$ptr<EnableIfAttr> Cand1I = $tryClone(Cand1Attrs.begin());
    Cand1ID/*J*/= new FoldingSetNodeID(); Cand2ID/*J*/= new FoldingSetNodeID();
    for (EnableIfAttr Cand2A : Cand2Attrs) {
      Cand1ID.clear();
      Cand2ID.clear();
      
      EnableIfAttr Cand1A = Cand1I.$postInc().$star();
      Cand1A.getCond().Profile(Cand1ID, S.getASTContext(), true);
      Cand2A.getCond().Profile(Cand2ID, S.getASTContext(), true);
      if (Cand1ID.$noteq(Cand2ID)) {
        return Comparison.Worse;
      }
    }
    
    return $eq_ptr(Cand1I, Cand1Attrs.end()) ? Comparison.Equal : Comparison.Better;
  } finally {
    if (Cand2ID != null) { Cand2ID.$destroy(); }
    if (Cand1ID != null) { Cand1ID.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::ClassifyOverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8867,
 FQN="(anonymous namespace)::ClassifyOverloadCandidate", NM="_ZN12_GLOBAL__N_125ClassifyOverloadCandidateERN5clang4SemaEPNS0_9NamedDeclEPNS0_12FunctionDeclERSs",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_125ClassifyOverloadCandidateERN5clang4SemaEPNS0_9NamedDeclEPNS0_12FunctionDeclERSs")
//</editor-fold>
public static OverloadCandidateKind ClassifyOverloadCandidate(final Sema /*&*/ S, 
                         NamedDecl /*P*/ Found, 
                         FunctionDecl /*P*/ Fn, 
                         final std.string/*&*/ Description) {
  boolean isTemplate = false;
  {
    
    FunctionTemplateDecl /*P*/ FunTmpl = Fn.getPrimaryTemplate();
    if ((FunTmpl != null)) {
      isTemplate = true;
      Description.$assignMove(S.getTemplateArgumentBindingsText(FunTmpl.getTemplateParameters(), $Deref(Fn.getTemplateSpecializationArgs())));
    }
  }
  {
    
    CXXConstructorDecl /*P*/ Ctor = dyn_cast_CXXConstructorDecl(Fn);
    if ((Ctor != null)) {
      if (!Ctor.isImplicit()) {
        if (isa_ConstructorUsingShadowDecl(Found)) {
          return isTemplate ? OverloadCandidateKind.oc_inherited_constructor_template : OverloadCandidateKind.oc_inherited_constructor;
        } else {
          return isTemplate ? OverloadCandidateKind.oc_constructor_template : OverloadCandidateKind.oc_constructor;
        }
      }
      if (Ctor.isDefaultConstructor()) {
        return OverloadCandidateKind.oc_implicit_default_constructor;
      }
      if (Ctor.isMoveConstructor()) {
        return OverloadCandidateKind.oc_implicit_move_constructor;
      }
      assert (Ctor.isCopyConstructor()) : "unexpected sort of implicit constructor";
      return OverloadCandidateKind.oc_implicit_copy_constructor;
    }
  }
  {
    
    CXXMethodDecl /*P*/ Meth = dyn_cast_CXXMethodDecl(Fn);
    if ((Meth != null)) {
      // This actually gets spelled 'candidate function' for now, but
      // it doesn't hurt to split it out.
      if (!Meth.isImplicit()) {
        return isTemplate ? OverloadCandidateKind.oc_method_template : OverloadCandidateKind.oc_method;
      }
      if (Meth.isMoveAssignmentOperator()) {
        return OverloadCandidateKind.oc_implicit_move_assignment;
      }
      if (Meth.isCopyAssignmentOperator()) {
        return OverloadCandidateKind.oc_implicit_copy_assignment;
      }
      assert (isa_CXXConversionDecl(Meth)) : "expected conversion";
      return OverloadCandidateKind.oc_method;
    }
  }
  
  return isTemplate ? OverloadCandidateKind.oc_function_template : OverloadCandidateKind.oc_function;
}

//<editor-fold defaultstate="collapsed" desc="(anonymous namespace)::MaybeEmitInheritedConstructorNote">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8918,
 FQN="(anonymous namespace)::MaybeEmitInheritedConstructorNote", NM="_ZN12_GLOBAL__N_133MaybeEmitInheritedConstructorNoteERN5clang4SemaEPNS0_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN12_GLOBAL__N_133MaybeEmitInheritedConstructorNoteERN5clang4SemaEPNS0_4DeclE")
//</editor-fold>
public static void MaybeEmitInheritedConstructorNote(final Sema /*&*/ S, Decl /*P*/ FoundDecl) {
  {
    // FIXME: It'd be nice to only emit a note once per using-decl per overload
    // set.
    ConstructorUsingShadowDecl /*P*/ Shadow = dyn_cast_ConstructorUsingShadowDecl(FoundDecl);
    if ((Shadow != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FoundDecl.getLocation(), 
                diag.note_ovl_candidate_inherited_constructor)), 
            Shadow.getNominatedBaseClass()));
      } finally {
        $c$.$destroy();
      }
    }
  }
}

// end anonymous namespace
//<editor-fold defaultstate="collapsed" desc="isFunctionAlwaysEnabled">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8929,
 FQN="isFunctionAlwaysEnabled", NM="_ZL23isFunctionAlwaysEnabledRKN5clang10ASTContextEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL23isFunctionAlwaysEnabledRKN5clang10ASTContextEPKNS_12FunctionDeclE")
//</editor-fold>
public static boolean isFunctionAlwaysEnabled(final /*const*/ ASTContext /*&*/ Ctx, 
                       /*const*/ FunctionDecl /*P*/ FD) {
  for (EnableIfAttr /*P*/ EnableIf : FD.specific_attrs(EnableIfAttr.class)) {
    bool$ref AlwaysTrue = create_bool$ref();
    if (!EnableIf.getCond().EvaluateAsBooleanCondition(AlwaysTrue, Ctx)) {
      return false;
    }
    if (!AlwaysTrue.$deref()) {
      return false;
    }
  }
  return true;
}


/// \brief Returns true if we can take the address of the function.
///
/// \param Complain - If true, we'll emit a diagnostic
/// \param InOverloadResolution - For the purposes of emitting a diagnostic, are
///   we in overload resolution?
/// \param Loc - The location of the statement we're complaining about. Ignored
///   if we're not complaining, or if we're in overload resolution.
//<editor-fold defaultstate="collapsed" desc="checkAddressOfFunctionIsAvailable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8948,
 FQN="checkAddressOfFunctionIsAvailable", NM="_ZL33checkAddressOfFunctionIsAvailableRN5clang4SemaEPKNS_12FunctionDeclEbbNS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL33checkAddressOfFunctionIsAvailableRN5clang4SemaEPKNS_12FunctionDeclEbbNS_14SourceLocationE")
//</editor-fold>
public static boolean checkAddressOfFunctionIsAvailable(final Sema /*&*/ S, /*const*/ FunctionDecl /*P*/ FD, 
                                 boolean Complain, 
                                 boolean InOverloadResolution, 
                                 SourceLocation Loc) {
  if (!isFunctionAlwaysEnabled(S.Context, FD)) {
    if (Complain) {
      if (InOverloadResolution) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($c$.track(S.Diag(FD.getLocStart(), 
              diag.note_addrof_ovl_candidate_disabled_by_enable_if_attr)));
        } finally {
          $c$.$destroy();
        }
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_addrof_function_disabled_by_enable_if_attr)), FD));
        } finally {
          $c$.$destroy();
        }
      }
    }
    return false;
  }
  type$ptr<ParmVarDecl> I = $tryClone(llvm.find_if(FD.parameters$Const(), //std.mem_fn(/*AddrOf*//*FPtr*/ParmVarDecl::<PassObjectSizeAttr>hasAttr)
          (ParmVarDecl param) -> param.hasAttr(PassObjectSizeAttr.class)));
  if ($eq_ptr(I, FD.param_end$Const())) {
    return true;
  }
  if (Complain) {
    // Add one to ParamNo because it's user-facing
    /*uint*/int ParamNo = std.distance(FD.param_begin$Const(), I) + 1;
    if (InOverloadResolution) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(FD.getLocation(), 
                diag.note_ovl_candidate_has_pass_object_size_params)), 
            ParamNo));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_address_of_function_with_pass_object_size_params)), 
                FD), ParamNo));
      } finally {
        $c$.$destroy();
      }
    }
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="checkAddressOfCandidateIsAvailable">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8982,
 FQN="checkAddressOfCandidateIsAvailable", NM="_ZL34checkAddressOfCandidateIsAvailableRN5clang4SemaEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL34checkAddressOfCandidateIsAvailableRN5clang4SemaEPKNS_12FunctionDeclE")
//</editor-fold>
public static boolean checkAddressOfCandidateIsAvailable(final Sema /*&*/ S, 
                                  /*const*/ FunctionDecl /*P*/ FD) {
  return checkAddressOfFunctionIsAvailable(S, FD, /*Complain=*/ true, 
      /*InOverloadResolution=*/ true, 
      /*Loc=*/ new SourceLocation());
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseBadConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9061,
 FQN="DiagnoseBadConversion", NM="_ZL21DiagnoseBadConversionRN5clang4SemaEPNS_17OverloadCandidateEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21DiagnoseBadConversionRN5clang4SemaEPNS_17OverloadCandidateEjb")
//</editor-fold>
public static void DiagnoseBadConversion(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand, 
                     /*uint*/int I, boolean TakingCandidateAddress) {
  PartialDiagnostic FDiag = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    final /*const*/ ImplicitConversionSequence /*&*/ Conv = Cand.Conversions[I];
    assert (Conv.isBad());
    assert ((Cand.Function != null)) : "for now, candidate must be a function";
    FunctionDecl /*P*/ Fn = Cand.Function;
    
    // There's a conversion slot for the object argument if this is a
    // non-constructor method.  Note that 'I' corresponds the
    // conversion-slot index.
    boolean isObjectArgument = false;
    if (isa_CXXMethodDecl(Fn) && !isa_CXXConstructorDecl(Fn)) {
      if (I == 0) {
        isObjectArgument = true;
      } else {
        I--;
      }
    }
    
    std.string FnDesc/*J*/= new std.string();
    OverloadCandidateKind FnKind = ClassifyOverloadCandidate(S, Cand.FoundDecl.$NamedDecl$P(), Fn, FnDesc);
    
    Expr /*P*/ FromExpr = Conv.Unnamed_field2.Bad.FromExpr;
    QualType FromTy = Conv.Unnamed_field2.Bad.getFromType();
    QualType ToTy = Conv.Unnamed_field2.Bad.getToType();
    if ($eq_QualType$C(FromTy, S.Context.OverloadTy.$QualType())) {
      assert ((FromExpr != null)) : "overload set argument came from implicit argument?";
      Expr /*P*/ E = FromExpr.IgnoreParens();
      if (isa_UnaryOperator(E)) {
        E = cast_UnaryOperator(E).getSubExpr().IgnoreParens();
      }
      DeclarationName Name = cast_OverloadExpr(E).getName();
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_overload)), 
                              (/*uint*/int)FnKind.getValue()), FnDesc), 
                      ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                  ToTy), Name), I + 1));
      MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
      return;
    }
    
    // Do some hand-waving analysis to see if the non-viability is due
    // to a qualifier mismatch.
    CanQual<Type> CFromTy = S.Context.getCanonicalType(new QualType(FromTy));
    CanQual<Type> CToTy = S.Context.getCanonicalType(new QualType(ToTy));
    {
      CanQual<ReferenceType> RT = ((CanProxyReferenceType)((CanProxyType)CToTy.$arrow()).$arrow().getAs(ReferenceType.class)).$CanQual$T();
      if (RT.$bool()) {
        CToTy.$assignMove(((CanProxyReferenceType)RT.$arrow(ReferenceType.class)).$arrow().getPointeeType());
      } else {
        {
          // TODO: detect and diagnose the full richness of const mismatches.
          CanQual<PointerType> FromPT = ((CanProxyPointerType)((CanProxyType)CFromTy.$arrow()).$arrow().getAs(PointerType.class)).$CanQual$T();
          if (FromPT.$bool()) {
            {
              CanQual<PointerType> ToPT = ((CanProxyPointerType)((CanProxyType)CToTy.$arrow()).$arrow().getAs(PointerType.class)).$CanQual$T();
              if (ToPT.$bool()) {
                CFromTy.$assignMove(((CanProxyPointerType)FromPT.$arrow(PointerType.class)).$arrow().getPointeeType());
                CToTy.$assignMove(((CanProxyPointerType)ToPT.$arrow(PointerType.class)).$arrow().getPointeeType());
              }
            }
          }
        }
      }
    }
    if ($eq_CanQual$T_CanQual$U(CToTy.getUnqualifiedType(), CFromTy.getUnqualifiedType())
       && !CToTy.isAtLeastAsQualifiedAs(new CanQual<Type>(CFromTy))) {
      Qualifiers FromQs = CFromTy.getQualifiers();
      Qualifiers ToQs = CToTy.getQualifiers();
      if (FromQs.getAddressSpace() != ToQs.getAddressSpace()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_addrspace)), 
                                        (/*uint*/int)FnKind.getValue()), FnDesc), 
                                ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                            FromTy), 
                        FromQs.getAddressSpace()), ToQs.getAddressSpace()), 
                (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1));
        MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
        return;
      }
      if (FromQs.getObjCLifetime() != ToQs.getObjCLifetime()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_ownership)), 
                                        (/*uint*/int)FnKind.getValue()), FnDesc), 
                                ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                            FromTy), 
                        FromQs.getObjCLifetime()), ToQs.getObjCLifetime()), 
                (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1));
        MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
        return;
      }
      if (FromQs.getObjCGCAttr() != ToQs.getObjCGCAttr()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_gc)), 
                                        (/*uint*/int)FnKind.getValue()), FnDesc), 
                                ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                            FromTy), 
                        FromQs.getObjCGCAttr()), ToQs.getObjCGCAttr()), 
                (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1));
        MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
        return;
      }
      if (FromQs.hasUnaligned() != ToQs.hasUnaligned()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_unaligned)), 
                                (/*uint*/int)FnKind.getValue()), FnDesc), 
                        ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                    FromTy), FromQs.hasUnaligned()), I + 1));
        MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
        return;
      }
      
      /*uint*/int CVR = FromQs.getCVRQualifiers() & ~ToQs.getCVRQualifiers();
      assert ((CVR != 0)) : "unexpected qualifiers mismatch";
      if (isObjectArgument) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_cvr_this)), 
                            (/*uint*/int)FnKind.getValue()), FnDesc), 
                    ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                FromTy), (CVR - 1)));
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_cvr)), 
                                (/*uint*/int)FnKind.getValue()), FnDesc), 
                        ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                    FromTy), (CVR - 1)), I + 1));
      }
      MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
      return;
    }
    
    // Special diagnostic for failure to convert an initializer list, since
    // telling the user that it has type void is not useful.
    if ((FromExpr != null) && isa_InitListExpr(FromExpr)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_list_argument)), 
                                  (/*uint*/int)FnKind.getValue()), FnDesc), 
                          ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                      FromTy), ToTy), (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1));
      MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
      return;
    }
    
    // Diagnose references or pointers to incomplete types differently,
    // since it's far from impossible that the incompleteness triggered
    // the failure.
    QualType TempFromTy = FromTy.getNonReferenceType();
    {
      /*const*/ PointerType /*P*/ PTy = TempFromTy.$arrow().getAs(PointerType.class);
      if ((PTy != null)) {
        TempFromTy.$assignMove(PTy.getPointeeType());
      }
    }
    if (TempFromTy.$arrow().isIncompleteType()) {
      // Emit the generic diagnostic and, optionally, add the hints to it.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_conv_incomplete)), 
                                      (/*uint*/int)FnKind.getValue()), FnDesc), 
                              ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                          FromTy), ToTy), (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1), 
          (/*uint*/int)(Cand.Fix.Kind).getValue()));
      
      MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
      return;
    }
    
    // Diagnose base -> derived pointer conversions.
    /*uint*/int BaseToDerivedConversion = 0;
    {
      /*const*/ PointerType /*P*/ FromPtrTy = FromTy.$arrow().getAs(PointerType.class);
      if ((FromPtrTy != null)) {
        {
          /*const*/ PointerType /*P*/ ToPtrTy = ToTy.$arrow().getAs(PointerType.class);
          if ((ToPtrTy != null)) {
            if (ToPtrTy.getPointeeType().isAtLeastAsQualifiedAs(FromPtrTy.getPointeeType())
               && !FromPtrTy.getPointeeType().$arrow().isIncompleteType()
               && !ToPtrTy.getPointeeType().$arrow().isIncompleteType()
               && S.IsDerivedFrom(new SourceLocation(), ToPtrTy.getPointeeType(), 
                FromPtrTy.getPointeeType())) {
              BaseToDerivedConversion = 1;
            }
          }
        }
      } else {
        /*const*/ ObjCObjectPointerType /*P*/ FromPtrTy$1 = FromTy.$arrow().getAs(ObjCObjectPointerType.class);
        if ((FromPtrTy$1 != null)) {
          {
            /*const*/ ObjCObjectPointerType /*P*/ ToPtrTy = ToTy.$arrow().getAs(ObjCObjectPointerType.class);
            if ((ToPtrTy != null)) {
              {
                /*const*/ ObjCInterfaceDecl /*P*/ FromIface = FromPtrTy$1.getInterfaceDecl();
                if ((FromIface != null)) {
                  {
                    /*const*/ ObjCInterfaceDecl /*P*/ ToIface = ToPtrTy.getInterfaceDecl();
                    if ((ToIface != null)) {
                      if (ToPtrTy.getPointeeType().isAtLeastAsQualifiedAs(FromPtrTy$1.getPointeeType())
                         && FromIface.isSuperClassOf(ToIface)) {
                        BaseToDerivedConversion = 2;
                      }
                    }
                  }
                }
              }
            }
          }
        } else {
          /*const*/ ReferenceType /*P*/ ToRefTy = ToTy.$arrow().getAs(ReferenceType.class);
          if ((ToRefTy != null)) {
            if (ToRefTy.getPointeeType().isAtLeastAsQualifiedAs(new QualType(FromTy))
               && !FromTy.$arrow().isIncompleteType()
               && !ToRefTy.getPointeeType().$arrow().isIncompleteType()
               && S.IsDerivedFrom(new SourceLocation(), ToRefTy.getPointeeType(), new QualType(FromTy))) {
              BaseToDerivedConversion = 3;
            } else if (ToTy.$arrow().isLValueReferenceType() && !FromExpr.isLValue()
               && $eq_QualType$C(ToTy.getNonReferenceType().getCanonicalType(), 
                FromTy.getNonReferenceType().getCanonicalType())) {
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_lvalue)), 
                                  (/*uint*/int)FnKind.getValue()), FnDesc), 
                          ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                      (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1));
              MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
              return;
            }
          }
        }
      }
    }
    if ((BaseToDerivedConversion != 0)) {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), 
                                      diag.note_ovl_candidate_bad_base_to_derived_conv)), 
                                  (/*uint*/int)FnKind.getValue()), FnDesc), 
                          ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                      (BaseToDerivedConversion - 1)), 
                  FromTy), ToTy), I + 1));
      MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
      return;
    }
    if (isa_ObjCObjectPointerType(CFromTy)
       && isa_PointerType(CToTy)) {
      Qualifiers FromQs = CFromTy.getQualifiers();
      Qualifiers ToQs = CToTy.getQualifiers();
      if (FromQs.getObjCLifetime() != ToQs.getObjCLifetime()) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_bad_arc_conv)), 
                                    (/*uint*/int)FnKind.getValue()), FnDesc), 
                            ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                        FromTy), ToTy), (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1));
        MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
        return;
      }
    }
    if (TakingCandidateAddress
       && !checkAddressOfCandidateIsAvailable(S, Cand.Function)) {
      return;
    }
    
    // Emit the generic diagnostic and, optionally, add the hints to it.
    FDiag = S.PDiag(diag.note_ovl_candidate_bad_conv);
    $out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_uint($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_StringRef($out_PartialDiagnostic$C_uint(FDiag, (/*uint*/int)FnKind.getValue()), new StringRef(FnDesc)), 
                            ((FromExpr != null) ? FromExpr.getSourceRange() : new SourceRange())), 
                        /*NO_COPY*/FromTy), /*NO_COPY*/ToTy), (/*uint*/int)(isObjectArgument ? 1 : 0)), I + 1), 
        (/*uint*/int)(Cand.Fix.Kind).getValue());
    
    // If we can fix the conversion, suggest the FixIts.
    for (StdVector.iterator<FixItHint> HI = Cand.Fix.Hints.begin(), 
        HE = Cand.Fix.Hints.end(); $noteq___normal_iterator$C(HI, HE); HI.$preInc())  {
      $out_PartialDiagnostic$C_FixItHint$C(FDiag, HI.$star());
    }
    $c$.clean($c$.track(S.Diag(Fn.getLocation(), FDiag)));
    
    MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
  } finally {
    if (FDiag != null) { FDiag.$destroy(); }
    $c$.$destroy();
  }
}


/// Additional arity mismatch diagnosis specific to a function overload
/// candidates. This is not covered by the more general DiagnoseArityMismatch()
/// over a candidate in any candidate set.
//<editor-fold defaultstate="collapsed" desc="CheckArityMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9299,
 FQN="CheckArityMismatch", NM="_ZL18CheckArityMismatchRN5clang4SemaEPNS_17OverloadCandidateEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL18CheckArityMismatchRN5clang4SemaEPNS_17OverloadCandidateEj")
//</editor-fold>
public static boolean CheckArityMismatch(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand, 
                  /*uint*/int NumArgs) {
  FunctionDecl /*P*/ Fn = Cand.Function;
  /*uint*/int MinParams = Fn.getMinRequiredArguments();
  
  // With invalid overloaded operators, it's possible that we think we
  // have an arity mismatch when in fact it looks like we have the
  // right number of arguments, because only overloaded operators have
  // the weird behavior of overloading member and non-member functions.
  // Just don't report anything.
  if (Fn.isInvalidDecl()
     && Fn.getDeclName().getNameKind() == DeclarationName.NameKind.CXXOperatorName) {
    return true;
  }
  if ($less_uint(NumArgs, MinParams)) {
    assert (($uchar2int(Cand.FailureKind) == OverloadFailureKind.ovl_fail_too_few_arguments.getValue()) || ($uchar2int(Cand.FailureKind) == OverloadFailureKind.ovl_fail_bad_deduction.getValue() && Cand.Unnamed_field12.DeductionFailure.Result == $int2uint_8bits(Sema.TemplateDeductionResult.TDK_TooFewArguments.getValue())));
  } else {
    assert (($uchar2int(Cand.FailureKind) == OverloadFailureKind.ovl_fail_too_many_arguments.getValue()) || ($uchar2int(Cand.FailureKind) == OverloadFailureKind.ovl_fail_bad_deduction.getValue() && Cand.Unnamed_field12.DeductionFailure.Result == $int2uint_8bits(Sema.TemplateDeductionResult.TDK_TooManyArguments.getValue())));
  }
  
  return false;
}


/// General arity mismatch diagnosis over a candidate in a candidate set.
//<editor-fold defaultstate="collapsed" desc="DiagnoseArityMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9327,
 FQN="DiagnoseArityMismatch", NM="_ZL21DiagnoseArityMismatchRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21DiagnoseArityMismatchRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclEj")
//</editor-fold>
public static void DiagnoseArityMismatch(final Sema /*&*/ S, NamedDecl /*P*/ Found, Decl /*P*/ D, 
                     /*uint*/int NumFormalArgs) {
  assert (isa_FunctionDecl(D)) : "The templated declaration should at least be a function when diagnosing bad template argument deduction due to too many or too few arguments";
  
  FunctionDecl /*P*/ Fn = cast_FunctionDecl(D);
  
  // TODO: treat calls to a missing default constructor as a special case
  /*const*/ FunctionProtoType /*P*/ FnTy = Fn.getType().$arrow().getAs(FunctionProtoType.class);
  /*uint*/int MinParams = Fn.getMinRequiredArguments();
  
  // at least / at most / exactly
  /*uint*/int mode, modeCount;
  if ($less_uint(NumFormalArgs, MinParams)) {
    if (MinParams != FnTy.getNumParams() || FnTy.isVariadic()
       || FnTy.isTemplateVariadic()) {
      mode = 0; // "at least"
    } else {
      mode = 2; // "exactly"
    }
    modeCount = MinParams;
  } else {
    if (MinParams != FnTy.getNumParams()) {
      mode = 1; // "at most"
    } else {
      mode = 2; // "exactly"
    }
    modeCount = FnTy.getNumParams();
  }
  
  std.string Description/*J*/= new std.string();
  OverloadCandidateKind FnKind = ClassifyOverloadCandidate(S, Found, Fn, Description);
  if (modeCount == 1 && Fn.getParamDecl(0).getDeclName().$bool()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_arity_one)), 
                          (/*uint*/int)FnKind.getValue()), (Fn.getDescribedFunctionTemplate() != (FunctionTemplateDecl /*P*/ )null)), 
                  mode), Fn.getParamDecl(0)), NumFormalArgs));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_arity)), 
                          (/*uint*/int)FnKind.getValue()), (Fn.getDescribedFunctionTemplate() != (FunctionTemplateDecl /*P*/ )null)), 
                  mode), modeCount), NumFormalArgs));
    } finally {
      $c$.$destroy();
    }
  }
  MaybeEmitInheritedConstructorNote(S, Found);
}


/// Arity mismatch diagnosis specific to a function overload candidate.
//<editor-fold defaultstate="collapsed" desc="DiagnoseArityMismatch">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9373,
 FQN="DiagnoseArityMismatch", NM="_ZL21DiagnoseArityMismatchRN5clang4SemaEPNS_17OverloadCandidateEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21DiagnoseArityMismatchRN5clang4SemaEPNS_17OverloadCandidateEj")
//</editor-fold>
public static void DiagnoseArityMismatch(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand, 
                     /*uint*/int NumFormalArgs) {
  if (!CheckArityMismatch(S, Cand, NumFormalArgs)) {
    DiagnoseArityMismatch(S, Cand.FoundDecl.$NamedDecl$P(), Cand.Function, NumFormalArgs);
  }
}

//<editor-fold defaultstate="collapsed" desc="getDescribedTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9379,
 FQN="getDescribedTemplate", NM="_ZL20getDescribedTemplatePN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL20getDescribedTemplatePN5clang4DeclE")
//</editor-fold>
public static TemplateDecl /*P*/ getDescribedTemplate(Decl /*P*/ Templated) {
  {
    TemplateDecl /*P*/ TD = Templated.getDescribedTemplate();
    if ((TD != null)) {
      return TD;
    }
  }
  throw new llvm_unreachable("Unsupported: Getting the described template declaration for bad deduction diagnosis");
}


/// Diagnose a failed template-argument deduction.
//<editor-fold defaultstate="collapsed" desc="DiagnoseBadDeduction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9387,
 FQN="DiagnoseBadDeduction", NM="_ZL20DiagnoseBadDeductionRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclERNS_20DeductionFailureInfoEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL20DiagnoseBadDeductionRN5clang4SemaEPNS_9NamedDeclEPNS_4DeclERNS_20DeductionFailureInfoEjb")
//</editor-fold>
public static void DiagnoseBadDeduction(final Sema /*&*/ S, NamedDecl /*P*/ Found, Decl /*P*/ Templated, 
                    final DeductionFailureInfo /*&*/ DeductionFailure, 
                    /*uint*/int NumArgs, 
                    boolean TakingCandidateAddress) {
  PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ > Param = DeductionFailure.getTemplateParameter();
  NamedDecl /*P*/ ParamD;
  boolean dummy = ((ParamD = Param.dyn_cast(TemplateTypeParmDecl.class)) != null)
               || ((ParamD = Param.dyn_cast(NonTypeTemplateParmDecl.class)) != null)
               || ((ParamD = Param.dyn_cast(TemplateTemplateParmDecl.class)) != null);
  switch (Sema.TemplateDeductionResult.valueOf(DeductionFailure.Result)) {
   case TDK_Success:
    throw new llvm_unreachable("TDK_success while diagnosing bad deduction");
   case TDK_Incomplete:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert ((ParamD != null)) : "no parameter found for incomplete deduction result";
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                diag.note_ovl_candidate_incomplete_deduction)), 
            ParamD.getDeclName()));
        MaybeEmitInheritedConstructorNote(S, Found);
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_Underqualified:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert ((ParamD != null)) : "no parameter found for bad qualifiers deduction result";
        TemplateTypeParmDecl /*P*/ TParam = cast_TemplateTypeParmDecl(ParamD);
        
        QualType Param$1 = DeductionFailure.getFirstArg().getAsType();
        
        // Param will have been canonicalized, but it should just be a
        // qualified version of ParamD, so move the qualifiers to that.
        QualifierCollector Qs/*J*/= new QualifierCollector();
        Qs.strip(new QualType(Param$1));
        QualType NonCanonParam = Qs.apply(S.Context, TParam.getTypeForDecl());
        assert (S.Context.hasSameType(new QualType(Param$1), new QualType(NonCanonParam)));
        
        // Arg has also been canonicalized, but there's nothing we can do
        // about that.  It also doesn't matter as much, because it won't
        // have any template parameters in it (because deduction isn't
        // done on dependent types).
        QualType Arg = DeductionFailure.getSecondArg().getAsType();
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), diag.note_ovl_candidate_underqualified)), 
                    ParamD.getDeclName()), Arg), NonCanonParam));
        MaybeEmitInheritedConstructorNote(S, Found);
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_Inconsistent:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        assert ((ParamD != null)) : "no parameter found for inconsistent deduction result";
        int which = 0;
        if (isa_TemplateTypeParmDecl(ParamD)) {
          which = 0;
        } else if (isa_NonTypeTemplateParmDecl(ParamD)) {
          which = 1;
        } else {
          which = 2;
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_TemplateArgument($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                            diag.note_ovl_candidate_inconsistent_deduction)), 
                        which), ParamD.getDeclName()), $Deref(DeductionFailure.getFirstArg())), 
            $Deref(DeductionFailure.getSecondArg())));
        MaybeEmitInheritedConstructorNote(S, Found);
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_InvalidExplicitArguments:
    assert ((ParamD != null)) : "no parameter found for invalid explicit arguments";
    if (ParamD.getDeclName().$bool()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                diag.note_ovl_candidate_explicit_arg_mismatch_named)), 
            ParamD.getDeclName()));
      } finally {
        $c$.$destroy();
      }
    } else {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        int index = 0;
        {
          TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(ParamD);
          if ((TTP != null)) {
            index = TTP.getIndex();
          } else {
            NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(ParamD);
            if ((NTTP != null)) {
              index = NTTP.getIndex();
            } else {
              index = cast_TemplateTemplateParmDecl(ParamD).getIndex();
            }
          }
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                diag.note_ovl_candidate_explicit_arg_mismatch_unnamed)), 
            (index + 1)));
      } finally {
        $c$.$destroy();
      }
    }
    MaybeEmitInheritedConstructorNote(S, Found);
    return;
   case TDK_TooManyArguments:
   case TDK_TooFewArguments:
    DiagnoseArityMismatch(S, Found, Templated, NumArgs);
    return;
   case TDK_InstantiationDepth:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($c$.track(S.Diag(Templated.getLocation(), 
            diag.note_ovl_candidate_instantiation_depth)));
        MaybeEmitInheritedConstructorNote(S, Found);
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_SubstitutionFailure:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Format the template argument list into the argument string.
        SmallString/*128*/ TemplateArgString/*J*/= new SmallString/*128*/(128);
        {
          TemplateArgumentList /*P*/ Args = DeductionFailure.getTemplateArgumentList();
          if ((Args != null)) {
            TemplateArgString.$assign(/*STRINGREF_STR*/" ");
            TemplateArgString.$addassign(new StringRef(S.getTemplateArgumentBindingsText(getDescribedTemplate(Templated).getTemplateParameters(), $Deref(Args))));
          }
        }
        
        // If this candidate was disabled by enable_if, say so.
        std.pair<SourceLocation, PartialDiagnostic> /*P*/ PDiag = DeductionFailure.getSFINAEDiagnostic();
        if ((PDiag != null) && PDiag.second.getDiagID()
           == diag.err_typename_nested_not_found_enable_if) {
          // FIXME: Use the source range of the condition, and the fully-qualified
          //        name of the enable_if template. These are both present in PDiag.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(PDiag.first), diag.note_ovl_candidate_disabled_by_enable_if)), 
                  /*KEEP_STR*/"'enable_if'"), TemplateArgString));
          return;
        }
        
        // Format the SFINAE diagnostic into the argument string.
        // FIXME: Add a general mechanism to include a PartialDiagnostic *'s
        //        formatted message in another diagnostic.
        SmallString/*128*/ SFINAEArgString/*J*/= new SmallString/*128*/(128);
        SourceRange R/*J*/= new SourceRange();
        if ((PDiag != null)) {
          SFINAEArgString.$assign(/*STRINGREF_STR*/": ");
          R.$assignMove(new SourceRange(/*NO_COPY*/PDiag.first, /*NO_COPY*/PDiag.first));
          PDiag.second.EmitToString(S.getDiagnostics(), SFINAEArgString);
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                        diag.note_ovl_candidate_substitution_failure)), 
                    TemplateArgString), SFINAEArgString), R));
        MaybeEmitInheritedConstructorNote(S, Found);
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_FailedOverloadResolution:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        OverloadExpr.FindResult R = OverloadExpr.find(DeductionFailure.getExpr());
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                diag.note_ovl_candidate_failed_overload_resolution)), 
            R.Expression.getName()));
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_DeducedMismatch:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Format the template argument list into the argument string.
        SmallString/*128*/ TemplateArgString/*J*/= new SmallString/*128*/(128);
        {
          TemplateArgumentList /*P*/ Args = DeductionFailure.getTemplateArgumentList();
          if ((Args != null)) {
            TemplateArgString.$assign(/*STRINGREF_STR*/" ");
            TemplateArgString.$addassign(new StringRef(S.getTemplateArgumentBindingsText(getDescribedTemplate(Templated).getTemplateParameters(), $Deref(Args))));
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_TemplateArgument($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), diag.note_ovl_candidate_deduced_mismatch)), 
                        (DeductionFailure.getCallArgIndex().$star() + 1)), 
                    $Deref(DeductionFailure.getFirstArg())), $Deref(DeductionFailure.getSecondArg())), 
            TemplateArgString));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_NonDeducedMismatch:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // FIXME: Provide a source location to indicate what we couldn't match.
        TemplateArgument FirstTA = new TemplateArgument($Deref(DeductionFailure.getFirstArg()));
        TemplateArgument SecondTA = new TemplateArgument($Deref(DeductionFailure.getSecondArg()));
        if (FirstTA.getKind() == TemplateArgument.ArgKind.Template
           && SecondTA.getKind() == TemplateArgument.ArgKind.Template) {
          TemplateName FirstTN = FirstTA.getAsTemplate();
          TemplateName SecondTN = SecondTA.getAsTemplate();
          if (FirstTN.getKind() == TemplateName.NameKind.Template
             && SecondTN.getKind() == TemplateName.NameKind.Template) {
            if ($eq_StringRef(FirstTN.getAsTemplateDecl().getName(), 
                SecondTN.getAsTemplateDecl().getName())) {
              // FIXME: This fixes a bad diagnostic where both templates are named
              // the same.  This particular case is a bit difficult since:
              // 1) It is passed as a string to the diagnostic printer.
              // 2) The diagnostic printer only attempts to find a better
              //    name for types, not decls.
              // Ideally, this should folded into the diagnostic printer.
              $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Templated.getLocation(), 
                          diag.note_ovl_candidate_non_deduced_mismatch_qualified)), 
                      FirstTN.getAsTemplateDecl()), SecondTN.getAsTemplateDecl()));
              return;
            }
          }
        }
        if (TakingCandidateAddress && isa_FunctionDecl(Templated)
           && !checkAddressOfCandidateIsAvailable(S, cast_FunctionDecl(Templated))) {
          return;
        }
        
        // FIXME: For generic lambda parameters, check if the function is a lambda
        // call operator, and if so, emit a prettier and more informative 
        // diagnostic that mentions 'auto' and lambda in addition to 
        // (or instead of?) the canonical template type parameters.
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder_TemplateArgument($c$.track(S.Diag(Templated.getLocation(), 
                    diag.note_ovl_candidate_non_deduced_mismatch)), 
                FirstTA), SecondTA));
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case TDK_MiscellaneousDeductionFailure:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // TODO: diagnose these individually, then kill off
        // note_ovl_candidate_bad_deduction, which is uselessly vague.
        $c$.clean($c$.track(S.Diag(Templated.getLocation(), diag.note_ovl_candidate_bad_deduction)));
        MaybeEmitInheritedConstructorNote(S, Found);
        return;
      } finally {
        $c$.$destroy();
      }
    }
  }
}


/// Diagnose a failed template-argument deduction, for function calls.
//<editor-fold defaultstate="collapsed" desc="DiagnoseBadDeduction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9599,
 FQN="DiagnoseBadDeduction", NM="_ZL20DiagnoseBadDeductionRN5clang4SemaEPNS_17OverloadCandidateEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL20DiagnoseBadDeductionRN5clang4SemaEPNS_17OverloadCandidateEjb")
//</editor-fold>
public static void DiagnoseBadDeduction(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand, 
                    /*uint*/int NumArgs, 
                    boolean TakingCandidateAddress) {
  /*uint*/int TDK = Cand.Unnamed_field12.DeductionFailure.Result;
  if (TDK == Sema.TemplateDeductionResult.TDK_TooFewArguments.getValue() || TDK == Sema.TemplateDeductionResult.TDK_TooManyArguments.getValue()) {
    if (CheckArityMismatch(S, Cand, NumArgs)) {
      return;
    }
  }
  DiagnoseBadDeduction(S, Cand.FoundDecl.$NamedDecl$P(), Cand.Function,  // pattern
      Cand.Unnamed_field12.DeductionFailure, NumArgs, TakingCandidateAddress);
}


/// CUDA: diagnose an invalid call across targets.
//<editor-fold defaultstate="collapsed" desc="DiagnoseBadTarget">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9612,
 FQN="DiagnoseBadTarget", NM="_ZL17DiagnoseBadTargetRN5clang4SemaEPNS_17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL17DiagnoseBadTargetRN5clang4SemaEPNS_17OverloadCandidateE")
//</editor-fold>
public static void DiagnoseBadTarget(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FunctionDecl /*P*/ Caller = cast_FunctionDecl(S.CurContext);
    FunctionDecl /*P*/ Callee = Cand.Function;
    
    Sema.CUDAFunctionTarget CallerTarget = S.IdentifyCUDATarget(Caller), 
        CalleeTarget = S.IdentifyCUDATarget(Callee);
    
    std.string FnDesc/*J*/= new std.string();
    OverloadCandidateKind FnKind = ClassifyOverloadCandidate(S, Cand.FoundDecl.$NamedDecl$P(), Callee, FnDesc);
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Callee.getLocation(), diag.note_ovl_candidate_bad_target)), 
                (/*uint*/int)FnKind.getValue()), CalleeTarget), CallerTarget));
    
    // This could be an implicit constructor for which we could not infer the
    // target due to a collsion. Diagnose that case.
    CXXMethodDecl /*P*/ Meth = dyn_cast_CXXMethodDecl(Callee);
    if (Meth != null && Meth.isImplicit()) {
      CXXRecordDecl /*P*/ ParentClass = Meth.getParent();
      Sema.CXXSpecialMember CSM;
      switch (FnKind) {
       default:
        return;
       case oc_implicit_default_constructor:
        CSM = Sema.CXXSpecialMember.CXXDefaultConstructor;
        break;
       case oc_implicit_copy_constructor:
        CSM = Sema.CXXSpecialMember.CXXCopyConstructor;
        break;
       case oc_implicit_move_constructor:
        CSM = Sema.CXXSpecialMember.CXXMoveConstructor;
        break;
       case oc_implicit_copy_assignment:
        CSM = Sema.CXXSpecialMember.CXXCopyAssignment;
        break;
       case oc_implicit_move_assignment:
        CSM = Sema.CXXSpecialMember.CXXMoveAssignment;
        break;
      }
      /*JSKIP;*/
      
      boolean ConstRHS = false;
      if ((Meth.getNumParams() != 0)) {
        {
          /*const*/ ReferenceType /*P*/ RT = Meth.getParamDecl(0).getType().$arrow().getAs(ReferenceType.class);
          if ((RT != null)) {
            ConstRHS = RT.getPointeeType().isConstQualified();
          }
        }
      }
      
      S.inferCUDATargetForImplicitSpecialMember(ParentClass, CSM, Meth, 
          /* ConstRHS */ ConstRHS, 
          /* Diagnose */ true);
    }
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseFailedEnableIfAttr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9667,
 FQN="DiagnoseFailedEnableIfAttr", NM="_ZL26DiagnoseFailedEnableIfAttrRN5clang4SemaEPNS_17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL26DiagnoseFailedEnableIfAttrRN5clang4SemaEPNS_17OverloadCandidateE")
//</editor-fold>
public static void DiagnoseFailedEnableIfAttr(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    FunctionDecl /*P*/ Callee = Cand.Function;
    EnableIfAttr /*P*/ Attr = ((/*static_cast*/EnableIfAttr /*P*/ )(Cand.Unnamed_field12.DeductionFailure.Data));
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Callee.getLocation(), 
                diag.note_ovl_candidate_disabled_by_enable_if_attr)), 
            Attr.getCond().getSourceRange()), Attr.getMessage()));
  } finally {
    $c$.$destroy();
  }
}


/// Generates a 'note' diagnostic for an overload candidate.  We've
/// already generated a primary error at the call site.
///
/// It really does need to be a single diagnostic with its caret
/// pointed at the candidate declaration.  Yes, this creates some
/// major challenges of technical writing.  Yes, this makes pointing
/// out problems with specific arguments quite awkward.  It's still
/// better than generating twenty screens of text for every failed
/// overload.
///
/// It would be great to be able to express per-candidate problems
/// more richly for those diagnostic clients that cared, but we'd
/// still have to be just as careful with the default diagnostics.
//<editor-fold defaultstate="collapsed" desc="NoteFunctionCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9689,
 FQN="NoteFunctionCandidate", NM="_ZL21NoteFunctionCandidateRN5clang4SemaEPNS_17OverloadCandidateEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21NoteFunctionCandidateRN5clang4SemaEPNS_17OverloadCandidateEjb")
//</editor-fold>
public static void NoteFunctionCandidate(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand, 
                     /*uint*/int NumArgs, 
                     boolean TakingCandidateAddress) {
  FunctionDecl /*P*/ Fn = Cand.Function;
  
  // Note deleted candidates, but only if they're viable.
  if (Cand.Viable && (Fn.isDeleted()
     || S.isFunctionConsideredUnavailable(Fn))) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      std.string FnDesc/*J*/= new std.string();
      OverloadCandidateKind FnKind = ClassifyOverloadCandidate(S, Cand.FoundDecl.$NamedDecl$P(), Fn, FnDesc);
      
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_deleted)), 
                  FnKind), FnDesc), 
          (Fn.isDeleted() ? (Fn.isDeletedAsWritten() ? 1 : 2) : 0)));
      MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // We don't really have anything else to say about viable candidates.
  if (Cand.Viable) {
    S.NoteOverloadCandidate(Cand.FoundDecl.$NamedDecl$P(), Fn);
    return;
  }
  switch (OverloadFailureKind.valueOf($uchar2int(Cand.FailureKind))) {
   case ovl_fail_too_many_arguments:
   case ovl_fail_too_few_arguments:
    DiagnoseArityMismatch(S, Cand, NumArgs);
    /*JAVA:return*/return;
   case ovl_fail_bad_deduction:
    DiagnoseBadDeduction(S, Cand, NumArgs, 
        TakingCandidateAddress);
    /*JAVA:return*/return;
   case ovl_fail_illegal_constructor:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Fn.getLocation(), diag.note_ovl_candidate_illegal_constructor)), 
            ((Fn.getPrimaryTemplate() != null) ? 1 : 0)));
        MaybeEmitInheritedConstructorNote(S, Cand.FoundDecl.$NamedDecl$P());
        return;
      } finally {
        $c$.$destroy();
      }
    }
   case ovl_fail_trivial_conversion:
   case ovl_fail_bad_final_conversion:
   case ovl_fail_final_conversion_not_exact:
    S.NoteOverloadCandidate(Cand.FoundDecl.$NamedDecl$P(), Fn);
    /*JAVA:return*/return;
   case ovl_fail_bad_conversion:
    {
      /*uint*/int I = (Cand.IgnoreObjectArgument ? 1 : 0);
      for (/*uint*/int N = Cand.NumConversions; I != N; ++I)  {
        if (Cand.Conversions[I].isBad()) {
          DiagnoseBadConversion(S, Cand, I, TakingCandidateAddress);
          /*JAVA:return*/return;
        }
      }
      
      // FIXME: this currently happens when we're called from SemaInit
      // when user-conversion overload fails.  Figure out how to handle
      // those conditions and diagnose them well.
      S.NoteOverloadCandidate(Cand.FoundDecl.$NamedDecl$P(), Fn);
      /*JAVA:return*/return;
    }
   case ovl_fail_bad_target:
    DiagnoseBadTarget(S, Cand);
    /*JAVA:return*/return;
   case ovl_fail_enable_if:
    DiagnoseFailedEnableIfAttr(S, Cand);
    /*JAVA:return*/return;
   case ovl_fail_addr_not_available:
    {
      boolean Available = checkAddressOfCandidateIsAvailable(S, Cand.Function);
      ///*J:(void)*/Available;
      assert (!Available);
      break;
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="NoteSurrogateCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9762,
 FQN="NoteSurrogateCandidate", NM="_ZL22NoteSurrogateCandidateRN5clang4SemaEPNS_17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL22NoteSurrogateCandidateRN5clang4SemaEPNS_17OverloadCandidateE")
//</editor-fold>
public static void NoteSurrogateCandidate(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Desugar the type of the surrogate down to a function type,
    // retaining as many typedefs as possible while still showing
    // the function type (and, therefore, its parameter types).
    QualType FnType = Cand.Surrogate.getConversionType();
    boolean isLValueReference = false;
    boolean isRValueReference = false;
    boolean isPointer = false;
    {
      /*const*/ LValueReferenceType /*P*/ FnTypeRef = FnType.$arrow().getAs(LValueReferenceType.class);
      if ((FnTypeRef != null)) {
        FnType.$assignMove(FnTypeRef.getPointeeType());
        isLValueReference = true;
      } else {
        /*const*/ RValueReferenceType /*P*/ FnTypeRef$1 = FnType.$arrow().getAs(RValueReferenceType.class);
        if ((FnTypeRef$1 != null)) {
          FnType.$assignMove(FnTypeRef$1.getPointeeType());
          isRValueReference = true;
        }
      }
    }
    {
      /*const*/ PointerType /*P*/ FnTypePtr = FnType.$arrow().getAs(PointerType.class);
      if ((FnTypePtr != null)) {
        FnType.$assignMove(FnTypePtr.getPointeeType());
        isPointer = true;
      }
    }
    // Desugar down to a function type.
    FnType.$assignMove(new QualType(FnType.$arrow().getAs(FunctionType.class), 0));
    // Reconstruct the pointer/reference as appropriate.
    if (isPointer) {
      FnType.$assignMove(S.Context.getPointerType(new QualType(FnType)));
    }
    if (isRValueReference) {
      FnType.$assignMove(S.Context.getRValueReferenceType(new QualType(FnType)));
    }
    if (isLValueReference) {
      FnType.$assignMove(S.Context.getLValueReferenceType(new QualType(FnType)));
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Cand.Surrogate.getLocation(), diag.note_ovl_surrogate_cand)), 
        FnType));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="NoteBuiltinOperatorCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9794,
 FQN="NoteBuiltinOperatorCandidate", NM="_ZL28NoteBuiltinOperatorCandidateRN5clang4SemaEN4llvm9StringRefENS_14SourceLocationEPNS_17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL28NoteBuiltinOperatorCandidateRN5clang4SemaEN4llvm9StringRefENS_14SourceLocationEPNS_17OverloadCandidateE")
//</editor-fold>
public static void NoteBuiltinOperatorCandidate(final Sema /*&*/ S, StringRef Opc, 
                            SourceLocation OpLoc, 
                            OverloadCandidate /*P*/ Cand) {
  assert ($lesseq_uint(Cand.NumConversions, 2)) : "builtin operator is not binary";
  std.string TypeStr/*J*/= new std.string(/*KEEP_STR*/$operator);
  $addassign_string_StringRef(TypeStr, /*NO_COPY*/Opc);
  TypeStr.$addassign_T$C$P(/*KEEP_STR*/"(");
  TypeStr.$addassign(Cand.BuiltinTypes.ParamTypes[0].getAsString());
  if (Cand.NumConversions == 1) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      TypeStr.$addassign_T$C$P(/*KEEP_STR*/")");
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.note_ovl_builtin_unary_candidate)), TypeStr));
    } finally {
      $c$.$destroy();
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      TypeStr.$addassign_T$C$P(/*KEEP_STR*/", ");
      TypeStr.$addassign(Cand.BuiltinTypes.ParamTypes[1].getAsString());
      TypeStr.$addassign_T$C$P(/*KEEP_STR*/")");
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(OpLoc), diag.note_ovl_builtin_binary_candidate)), TypeStr));
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="NoteAmbiguousUserConversions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9813,
 FQN="NoteAmbiguousUserConversions", NM="_ZL28NoteAmbiguousUserConversionsRN5clang4SemaENS_14SourceLocationEPNS_17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL28NoteAmbiguousUserConversionsRN5clang4SemaENS_14SourceLocationEPNS_17OverloadCandidateE")
//</editor-fold>
public static void NoteAmbiguousUserConversions(final Sema /*&*/ S, SourceLocation OpLoc, 
                            OverloadCandidate /*P*/ Cand) {
  /*uint*/int NoOperands = Cand.NumConversions;
  for (/*uint*/int ArgIdx = 0; $less_uint(ArgIdx, NoOperands); ++ArgIdx) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      final /*const*/ ImplicitConversionSequence /*&*/ ICS = Cand.Conversions[ArgIdx];
      if (ICS.isBad()) {
        break; // all meaningless after first invalid
      }
      if (!ICS.isAmbiguous()) {
        continue;
      }
      
      ICS.DiagnoseAmbiguousConversion(S, new SourceLocation(OpLoc), $c$.track(S.PDiag(diag.note_ambiguous_type_conversion))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="GetLocationForCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9826,
 FQN="GetLocationForCandidate", NM="_ZL23GetLocationForCandidatePKN5clang17OverloadCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL23GetLocationForCandidatePKN5clang17OverloadCandidateE")
//</editor-fold>
public static SourceLocation GetLocationForCandidate(/*const*/ OverloadCandidate /*P*/ Cand) {
  if ((Cand.Function != null)) {
    return Cand.Function.getLocation();
  }
  if (Cand.IsSurrogate) {
    return Cand.Surrogate.getLocation();
  }
  return new SourceLocation();
}

//<editor-fold defaultstate="collapsed" desc="RankDeductionFailure">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9834,
 FQN="RankDeductionFailure", NM="_ZL20RankDeductionFailureRKN5clang20DeductionFailureInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL20RankDeductionFailureRKN5clang20DeductionFailureInfoE")
//</editor-fold>
public static /*uint*/int RankDeductionFailure(final /*const*/ DeductionFailureInfo /*&*/ DFI) {
  switch (Sema.TemplateDeductionResult.valueOf(DFI.Result)) {
   case TDK_Success:
    throw new llvm_unreachable("TDK_success while diagnosing bad deduction");
   case TDK_Invalid:
   case TDK_Incomplete:
    return 1;
   case TDK_Underqualified:
   case TDK_Inconsistent:
    return 2;
   case TDK_SubstitutionFailure:
   case TDK_DeducedMismatch:
   case TDK_NonDeducedMismatch:
   case TDK_MiscellaneousDeductionFailure:
    return 3;
   case TDK_InstantiationDepth:
   case TDK_FailedOverloadResolution:
    return 4;
   case TDK_InvalidExplicitArguments:
    return 5;
   case TDK_TooManyArguments:
   case TDK_TooFewArguments:
    return 6;
  }
  throw new llvm_unreachable("Unhandled deduction result");
}


/// CompleteNonViableCandidate - Normally, overload resolution only
/// computes up to the first. Produces the FixIt set if possible.
//<editor-fold defaultstate="collapsed" desc="CompleteNonViableCandidate">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 9993,
 FQN="CompleteNonViableCandidate", NM="_ZL26CompleteNonViableCandidateRN5clang4SemaEPNS_17OverloadCandidateEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL26CompleteNonViableCandidateRN5clang4SemaEPNS_17OverloadCandidateEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static void CompleteNonViableCandidate(final Sema /*&*/ S, OverloadCandidate /*P*/ Cand, 
                          ArrayRef<Expr /*P*/ > Args) {
  assert (!Cand.Viable);
  
  // Don't do anything on failures other than bad conversion.
  if ($uchar2int(Cand.FailureKind) != OverloadFailureKind.ovl_fail_bad_conversion.getValue()) {
    return;
  }
  
  // We only want the FixIts if all the arguments can be corrected.
  boolean Unfixable = false;
  // Use a implicit copy initialization to check conversion fixes.
  Cand.Fix.setConversionChecker(/*FuncRef*/SemaOverloadStatics::TryCopyInitialization);
  
  // Skip forward to the first bad conversion.
  /*uint*/int ConvIdx = (Cand.IgnoreObjectArgument ? 1 : 0);
  /*uint*/int ConvCount = Cand.NumConversions;
  while (true) {
    assert (ConvIdx != ConvCount) : "no bad conversion in candidate";
    ConvIdx++;
    if (Cand.Conversions[ConvIdx - 1].isBad()) {
      Unfixable = !Cand.TryToFixBadConversion(ConvIdx - 1, S);
      break;
    }
  }
  if (ConvIdx == ConvCount) {
    return;
  }
  assert (!Cand.Conversions[ConvIdx].isInitialized()) : "remaining conversion is initialized?";
  
  // FIXME: this should probably be preserved from the overload
  // operation somehow.
  boolean SuppressUserConversions = false;
  
  /*const*/ FunctionProtoType /*P*/ Proto;
  /*uint*/int ArgIdx = ConvIdx;
  if (Cand.IsSurrogate) {
    QualType ConvType = Cand.Surrogate.getConversionType().getNonReferenceType();
    {
      /*const*/ PointerType /*P*/ ConvPtrType = ConvType.$arrow().getAs(PointerType.class);
      if ((ConvPtrType != null)) {
        ConvType.$assignMove(ConvPtrType.getPointeeType());
      }
    }
    Proto = ConvType.$arrow().getAs(FunctionProtoType.class);
    ArgIdx--;
  } else if ((Cand.Function != null)) {
    Proto = Cand.Function.getType().$arrow().getAs(FunctionProtoType.class);
    if (isa_CXXMethodDecl(Cand.Function)
       && !isa_CXXConstructorDecl(Cand.Function)) {
      ArgIdx--;
    }
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      // Builtin binary operator with a bad first conversion.
      assert ($lesseq_uint(ConvCount, 3));
      for (; ConvIdx != ConvCount; ++ConvIdx)  {
        $c$.clean(Cand.Conversions[ConvIdx].$assign(
            $c$.track(TryCopyInitialization(S, Args.$at(ConvIdx), 
                new QualType(Cand.BuiltinTypes.ParamTypes[ConvIdx]), 
                SuppressUserConversions, 
                /*InOverloadResolution*/ true, 
                /*AllowObjCWritebackConversion=*/
                S.getLangOpts().ObjCAutoRefCount))
        ));
      }
      return;
    } finally {
      $c$.$destroy();
    }
  }
  
  // Fill in the rest of the conversions.
  /*uint*/int NumParams = Proto.getNumParams();
  for (; ConvIdx != ConvCount; ++ConvIdx , ++ArgIdx) {
    if ($less_uint(ArgIdx, NumParams)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean(Cand.Conversions[ConvIdx].$assign($c$.track(TryCopyInitialization(S, Args.$at(ArgIdx), Proto.getParamType(ArgIdx), SuppressUserConversions, 
                /*InOverloadResolution=*/ true, 
                /*AllowObjCWritebackConversion=*/
                S.getLangOpts().ObjCAutoRefCount))));
        // Store the FixIt in the candidate if it exists.
        if (!Unfixable && Cand.Conversions[ConvIdx].isBad()) {
          Unfixable = !Cand.TryToFixBadConversion(ConvIdx, S);
        }
      } finally {
        $c$.$destroy();
      }
    } else {
      Cand.Conversions[ConvIdx].setEllipsis();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="GetLocationForCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10145,
 FQN="GetLocationForCandidate", NM="_ZL23GetLocationForCandidatePKN5clang21TemplateSpecCandidateE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL23GetLocationForCandidatePKN5clang21TemplateSpecCandidateE")
//</editor-fold>
public static SourceLocation GetLocationForCandidate(/*const*/ TemplateSpecCandidate /*P*/ Cand) {
  return (Cand.Specialization != null) ? Cand.Specialization.getLocation() : new SourceLocation();
}


/// \brief Add a single candidate to the overload set.
//<editor-fold defaultstate="collapsed" desc="AddOverloadedCallCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 10961,
 FQN="AddOverloadedCallCandidate", NM="_ZL26AddOverloadedCallCandidateRN5clang4SemaENS_14DeclAccessPairEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL26AddOverloadedCallCandidateRN5clang4SemaENS_14DeclAccessPairEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetEbb")
//</editor-fold>
public static void AddOverloadedCallCandidate(final Sema /*&*/ S, 
                          DeclAccessPair FoundDecl, 
                          TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                          ArrayRef<Expr /*P*/ > Args, 
                          final OverloadCandidateSet /*&*/ CandidateSet, 
                          boolean PartialOverloading, 
                          boolean KnownValid) {
  NamedDecl /*P*/ Callee = FoundDecl.getDecl();
  if (isa_UsingShadowDecl(Callee)) {
    Callee = cast_UsingShadowDecl(Callee).getTargetDecl();
  }
  {
    
    FunctionDecl /*P*/ Func = dyn_cast_FunctionDecl(Callee);
    if ((Func != null)) {
      if ((ExplicitTemplateArgs != null)) {
        assert (!KnownValid) : "Explicit template arguments?";
        return;
      }
      S.AddOverloadCandidate(Func, new DeclAccessPair(FoundDecl), new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
          /*SuppressUsedConversions=*/ false, 
          PartialOverloading);
      return;
    }
  }
  {
    
    FunctionTemplateDecl /*P*/ FuncTemplate = dyn_cast_FunctionTemplateDecl(Callee);
    if ((FuncTemplate != null)) {
      S.AddTemplateOverloadCandidate(FuncTemplate, new DeclAccessPair(FoundDecl), 
          ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
          /*SuppressUsedConversions=*/ false, 
          PartialOverloading);
      return;
    }
  }
  assert (!KnownValid) : "unhandled case in overloaded call candidate";
}


/// Determine whether a declaration with the specified name could be moved into
/// a different namespace.
//<editor-fold defaultstate="collapsed" desc="canBeDeclaredInNamespace">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11053,
 FQN="canBeDeclaredInNamespace", NM="_ZL24canBeDeclaredInNamespaceRKN5clang15DeclarationNameE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL24canBeDeclaredInNamespaceRKN5clang15DeclarationNameE")
//</editor-fold>
public static boolean canBeDeclaredInNamespace(final /*const*/ DeclarationName /*&*/ Name) {
  switch (Name.getCXXOverloadedOperator()) {
   case OO_New:
   case OO_Array_New:
   case OO_Delete:
   case OO_Array_Delete:
    return false;
   default:
    return true;
  }
}


/// Attempt to recover from an ill-formed use of a non-dependent name in a
/// template, where the non-dependent name was declared after the template
/// was defined. This is common in code written for a compilers which do not
/// correctly implement two-stage name lookup.
///
/// Returns true if a viable candidate was found and a diagnostic was issued.
//<editor-fold defaultstate="collapsed" desc="DiagnoseTwoPhaseLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11070,
 FQN="DiagnoseTwoPhaseLookup", NM="_ZL22DiagnoseTwoPhaseLookupRN5clang4SemaENS_14SourceLocationERKNS_12CXXScopeSpecERNS_12LookupResultENS_20OverloadCandidateSet16CandidateSetKindEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEEPb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL22DiagnoseTwoPhaseLookupRN5clang4SemaENS_14SourceLocationERKNS_12CXXScopeSpecERNS_12LookupResultENS_20OverloadCandidateSet16CandidateSetKindEPNS_24TemplateArgumentListInfoEN4llvm8ArrayRefIPNS_4ExprEEEPb")
//</editor-fold>
public static boolean DiagnoseTwoPhaseLookup(final Sema /*&*/ SemaRef, SourceLocation FnLoc, 
                      final /*const*/ CXXScopeSpec /*&*/ SS, final LookupResult /*&*/ R, 
                      OverloadCandidateSet.CandidateSetKind CSK, 
                      TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                      ArrayRef<Expr /*P*/ > Args) {
  return DiagnoseTwoPhaseLookup(SemaRef, FnLoc, 
                      SS, R, 
                      CSK, 
                      ExplicitTemplateArgs, 
                      Args, 
                      (bool$ptr/*bool P*/ )null);
}
public static boolean DiagnoseTwoPhaseLookup(final Sema /*&*/ SemaRef, SourceLocation FnLoc, 
                      final /*const*/ CXXScopeSpec /*&*/ SS, final LookupResult /*&*/ R, 
                      OverloadCandidateSet.CandidateSetKind CSK, 
                      TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs, 
                      ArrayRef<Expr /*P*/ > Args, 
                      bool$ptr/*bool P*/ DoDiagnoseEmptyLookup/*= null*/) {
  if (SemaRef.ActiveTemplateInstantiations.empty() || !SS.isEmpty()) {
    return false;
  }
  
  for (DeclContext /*P*/ DC = SemaRef.CurContext; (DC != null); DC = DC.getParent()) {
    if (DC.isTransparentContext()) {
      continue;
    }
    
    SemaRef.LookupQualifiedName(R, DC);
    if (!R.empty()) {
      OverloadCandidateSet Candidates = null;
      SmallSetVector<DeclContext /*P*/ > AssociatedNamespaces = null;
      SmallSetVector<CXXRecordDecl /*P*/ > AssociatedClasses = null;
      SmallSetVector<DeclContext /*P*/ > SuggestedNamespaces = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        R.suppressDiagnostics();
        if (isa_CXXRecordDecl(DC)) {
          // Don't diagnose names we find in classes; we get much better
          // diagnostics for these from DiagnoseEmptyLookup.
          R.clear();
          if ((DoDiagnoseEmptyLookup != null)) {
            DoDiagnoseEmptyLookup.$set(true);
          }
          return false;
        }
        
        Candidates/*J*/= new OverloadCandidateSet(new SourceLocation(FnLoc), CSK);
        for (UnresolvedSetIterator I = R.begin(), E = R.end(); I.$noteq(E); I.$preInc())  {
          AddOverloadedCallCandidate(SemaRef, new DeclAccessPair(I.getPair()), 
              ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), 
              Candidates, false, /*KnownValid*/ false);
        }
        
        final type$ptr<OverloadCandidate> Best = create_type$ptr();
        if (Candidates.BestViableFunction(SemaRef, new SourceLocation(FnLoc), Best) != OverloadingResult.OR_Success) {
          // No viable functions. Don't bother the user with notes for functions
          // which don't work and shouldn't be found anyway.
          R.clear();
          return false;
        }
        
        // Find the namespaces where ADL would have looked, and suggest
        // declaring the function there instead.
        AssociatedNamespaces/*J*/= new SmallSetVector<DeclContext /*P*/ >(16, (DeclContext /*P*/ ) null);
        AssociatedClasses/*J*/= new SmallSetVector<CXXRecordDecl /*P*/ >(16, (CXXRecordDecl /*P*/ ) null);
        SemaRef.FindAssociatedClassesAndNamespaces(new SourceLocation(FnLoc), new ArrayRef<Expr /*P*/ >(Args), 
            AssociatedNamespaces, 
            AssociatedClasses);
        SuggestedNamespaces/*J*/= new SmallSetVector<DeclContext /*P*/ >(16, (DeclContext /*P*/ ) null);
        if (canBeDeclaredInNamespace(R.getLookupName())) {
          DeclContext /*P*/ Std = SemaRef.getStdNamespace();
          for (StdVector.iterator<DeclContext> it = $tryClone(AssociatedNamespaces.begin()), 
              /*P*/ end = $tryClone(AssociatedNamespaces.end()); $noteq_ptr(it, end); it.$preInc()) {
            // Never suggest declaring a function within namespace 'std'.
            if ((Std != null) && Std.Encloses(it.$star())) {
              continue;
            }
            
            // Never suggest declaring a function within a namespace with a
            // reserved name, like __gnu_cxx.
            NamespaceDecl /*P*/ NS = dyn_cast_NamespaceDecl(it.$star());
            if ((NS != null)
               && NS.getQualifiedNameAsString().find_T$C$P_rebind$_CharT(/*KEEP_STR*/"__") != std.string.npos) {
              continue;
            }
            
            SuggestedNamespaces.insert(it.$star());
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(R.getNameLoc(), diag.err_not_found_by_two_phase_lookup)), 
            R.getLookupName()));
        if (SuggestedNamespaces.empty()) {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Best./*->*/$star().Function.getLocation(), 
                      diag.note_not_found_by_two_phase_lookup)), 
                  R.getLookupName()), 0));
        } else if (SuggestedNamespaces.size() == 1) {
          $c$.clean($out_SemaDiagnosticBuilder_DeclContext($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Best./*->*/$star().Function.getLocation(), 
                          diag.note_not_found_by_two_phase_lookup)), 
                      R.getLookupName()), 1), SuggestedNamespaces.begin().$star()));
        } else {
          // FIXME: It would be useful to list the associated namespaces here,
          // but the diagnostics infrastructure doesn't provide a way to produce
          // a localized representation of a list of items.
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Best./*->*/$star().Function.getLocation(), 
                      diag.note_not_found_by_two_phase_lookup)), 
                  R.getLookupName()), 2));
        }
        
        // Try to recover by calling this function.
        return true;
      } finally {
        if (SuggestedNamespaces != null) { SuggestedNamespaces.$destroy(); }
        if (AssociatedClasses != null) { AssociatedClasses.$destroy(); }
        if (AssociatedNamespaces != null) { AssociatedNamespaces.$destroy(); }
        if (Candidates != null) { Candidates.$destroy(); }
        $c$.$destroy();
      }
    }
    
    R.clear();
  }
  
  return false;
}


/// Attempt to recover from ill-formed use of a non-dependent operator in a
/// template, where the non-dependent operator was declared after the template
/// was defined.
///
/// Returns true if a viable candidate was found and a diagnostic was issued.
//<editor-fold defaultstate="collapsed" desc="DiagnoseTwoPhaseOperatorLookup">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11174,
 FQN="DiagnoseTwoPhaseOperatorLookup", NM="_ZL30DiagnoseTwoPhaseOperatorLookupRN5clang4SemaENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL30DiagnoseTwoPhaseOperatorLookupRN5clang4SemaENS_22OverloadedOperatorKindENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public static boolean DiagnoseTwoPhaseOperatorLookup(final Sema /*&*/ SemaRef, OverloadedOperatorKind Op, 
                              SourceLocation OpLoc, 
                              ArrayRef<Expr /*P*/ > Args) {
  LookupResult R = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    DeclarationName OpName = SemaRef.Context.DeclarationNames.getCXXOperatorName(Op);
    R/*J*/= new LookupResult(SemaRef, new DeclarationName(OpName), new SourceLocation(OpLoc), Sema.LookupNameKind.LookupOperatorName);
    return $c$.clean(DiagnoseTwoPhaseLookup(SemaRef, new SourceLocation(OpLoc), $c$.track(new CXXScopeSpec()), R, 
        OverloadCandidateSet.CandidateSetKind.CSK_Operator, 
        /*ExplicitTemplateArgs=*/ (TemplateArgumentListInfo /*P*/ )null, new ArrayRef<Expr /*P*/ >(Args)));
  } finally {
    if (R != null) { R.$destroy(); }
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="MakeValidator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11202,
 FQN="MakeValidator", NM="_ZL13MakeValidatorRN5clang4SemaEPNS_10MemberExprEjbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL13MakeValidatorRN5clang4SemaEPNS_10MemberExprEjbb")
//</editor-fold>
public static std.unique_ptr<CorrectionCandidateCallback> MakeValidator(final Sema /*&*/ SemaRef, MemberExpr /*P*/ ME, /*size_t*/int NumArgs, 
             boolean HasTemplateArgs, boolean AllowTypoCorrection) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!AllowTypoCorrection) {
      return $c$.clean(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new NoTypoCorrectionCCC()))));
    }
    return $c$.clean(new std.unique_ptr<CorrectionCandidateCallback>(JD$Unique_ptr$_Up$_Ep.INSTANCE, $c$.track(llvm.make_unique(new FunctionCallFilterCCC(SemaRef, NumArgs, 
            HasTemplateArgs, ME)))));
  } finally {
    $c$.$destroy();
  }
}


/// Attempts to recover from a call where no functions were found.
///
/// Returns true if new candidates were found.
//<editor-fold defaultstate="collapsed" desc="BuildRecoveryCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11214,
 FQN="BuildRecoveryCallExpr", NM="_ZL21BuildRecoveryCallExprRN5clang4SemaEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES8_bb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL21BuildRecoveryCallExprRN5clang4SemaEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES8_bb")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > BuildRecoveryCallExpr(final Sema /*&*/ SemaRef, Scope /*P*/ S, Expr /*P*/ Fn, 
                     UnresolvedLookupExpr /*P*/ ULE, 
                     SourceLocation LParenLoc, 
                     MutableArrayRef<Expr /*P*/ > Args, 
                     SourceLocation RParenLoc, 
                     boolean EmptyLookup, boolean AllowTypoCorrection) {
  BuildRecoveryCallExprRAII RCE = null;
  CXXScopeSpec SS = null;
  TemplateArgumentListInfo TABuffer = null;
  LookupResult R = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Do not try to recover if it is already building a recovery call.
    // This stops infinite loops for template instantiations like
    //
    // template <typename T> auto foo(T t) -> decltype(foo(t)) {}
    // template <typename T> auto foo(T t) -> decltype(foo(&t)) {}
    //
    if (SemaRef.IsBuildingRecoveryCallExpr) {
      return ExprError();
    }
    RCE/*J*/= new BuildRecoveryCallExprRAII(SemaRef);
    
    SS/*J*/= new CXXScopeSpec();
    SS.Adopt(ULE.getQualifierLoc());
    SourceLocation TemplateKWLoc = ULE.getTemplateKeywordLoc();
    
    TABuffer/*J*/= new TemplateArgumentListInfo();
    TemplateArgumentListInfo /*P*/ ExplicitTemplateArgs = null;
    if (ULE.hasExplicitTemplateArgs()) {
      ULE.copyTemplateArgumentsInto(TABuffer);
      ExplicitTemplateArgs = $AddrOf(TABuffer);
    }
    
    R/*J*/= new LookupResult(SemaRef, ULE.getName(), ULE.getNameLoc(), 
        Sema.LookupNameKind.LookupOrdinaryName);
    bool$ptr DoDiagnoseEmptyLookup = create_bool$ptr(EmptyLookup);
    if ($c$.clean(!DiagnoseTwoPhaseLookup(SemaRef, Fn.getExprLoc(), SS, R, 
        OverloadCandidateSet.CandidateSetKind.CSK_Normal, 
        ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args), 
        $AddrOf(DoDiagnoseEmptyLookup))
       && (!DoDiagnoseEmptyLookup.$star() || SemaRef.DiagnoseEmptyLookup(S, SS, R, 
        $c$.track(MakeValidator(SemaRef, dyn_cast_MemberExpr(Fn), Args.size(), 
            ExplicitTemplateArgs != (TemplateArgumentListInfo /*P*/ )null, AllowTypoCorrection)), 
        ExplicitTemplateArgs, new ArrayRef<Expr /*P*/ >(Args))))) {
      return ExprError();
    }
    assert (!R.empty()) : "lookup results empty despite recovery";
    
    // Build an implicit member call if appropriate.  Just drop the
    // casts and such from the call, we don't really care.
    ActionResultTTrue<Expr /*P*/ > NewFn = ExprError();
    if ((R.begin().$star()).isCXXClassMember()) {
      NewFn.$assignMove(SemaRef.BuildPossibleImplicitMemberExpr(SS, new SourceLocation(TemplateKWLoc), R, 
              ExplicitTemplateArgs, S));
    } else if ((ExplicitTemplateArgs != null) || TemplateKWLoc.isValid()) {
      NewFn.$assignMove(SemaRef.BuildTemplateIdExpr(SS, new SourceLocation(TemplateKWLoc), R, false, 
              ExplicitTemplateArgs));
    } else {
      NewFn.$assignMove(SemaRef.BuildDeclarationNameExpr(SS, R, false));
    }
    if (NewFn.isInvalid()) {
      return ExprError();
    }
    
    // This shouldn't cause an infinite loop because we're giving it
    // an expression with viable lookup results, which should never
    // end up here.
    return SemaRef.ActOnCallExpr(/*Scope*/ (Scope /*P*/ )null, NewFn.get(), new SourceLocation(LParenLoc), 
        new MutableArrayRef<Expr /*P*/ >(Args.data(), Args.size(), true), 
        new SourceLocation(RParenLoc));
  } finally {
    if (R != null) { R.$destroy(); }
    if (TABuffer != null) { TABuffer.$destroy(); }
    if (SS != null) { SS.$destroy(); }
    if (RCE != null) { RCE.$destroy(); }
    $c$.$destroy();
  }
}


/// FinishOverloadedCallExpr - given an OverloadCandidateSet, builds and returns
/// the completed call expression. If overload resolution fails, emits
/// diagnostics and returns ExprError()
//<editor-fold defaultstate="collapsed" desc="FinishOverloadedCallExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11350,
 FQN="FinishOverloadedCallExpr", NM="_ZL24FinishOverloadedCallExprRN5clang4SemaEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES8_S5_PNS_20OverloadCandidateSetEPPNS_17OverloadCandidateENS_17OverloadingResultEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL24FinishOverloadedCallExprRN5clang4SemaEPNS_5ScopeEPNS_4ExprEPNS_20UnresolvedLookupExprENS_14SourceLocationEN4llvm15MutableArrayRefIS5_EES8_S5_PNS_20OverloadCandidateSetEPPNS_17OverloadCandidateENS_17OverloadingResultEb")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > FinishOverloadedCallExpr(final Sema /*&*/ SemaRef, Scope /*P*/ S, Expr /*P*/ Fn, 
                        UnresolvedLookupExpr /*P*/ ULE, 
                        SourceLocation LParenLoc, 
                        MutableArrayRef<Expr /*P*/ > Args, 
                        SourceLocation RParenLoc, 
                        Expr /*P*/ ExecConfig, 
                        OverloadCandidateSet /*P*/ CandidateSet, 
                        type$ptr<OverloadCandidate> /*P*/ Best, 
                        OverloadingResult OverloadResult, 
                        boolean AllowTypoCorrection) {
  if (CandidateSet.empty()) {
    return BuildRecoveryCallExpr(SemaRef, S, Fn, ULE, new SourceLocation(LParenLoc), new MutableArrayRef<Expr /*P*/ >(Args), 
        new SourceLocation(RParenLoc), /*EmptyLookup=*/ true, 
        AllowTypoCorrection);
  }
  switch (OverloadResult) {
   case OR_Success:
    {
      FunctionDecl /*P*/ FDecl = (Best.$star()).Function;
      SemaRef.CheckUnresolvedLookupAccess(ULE, new DeclAccessPair((Best.$star()).FoundDecl));
      if (SemaRef.DiagnoseUseOfDecl(FDecl, ULE.getNameLoc())) {
        return ExprError();
      }
      Fn = SemaRef.FixOverloadedFunctionReference(Fn, new DeclAccessPair((Best.$star()).FoundDecl), FDecl);
      return SemaRef.BuildResolvedCallExpr(Fn, FDecl, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc), 
          ExecConfig);
    }
   case OR_No_Viable_Function:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Try to recover by looking for viable functions which the user might
        // have meant to call.
        ActionResultTTrue<Expr /*P*/ > Recovery = BuildRecoveryCallExpr(SemaRef, S, Fn, ULE, new SourceLocation(LParenLoc), 
            new MutableArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc), 
            /*EmptyLookup=*/ false, 
            AllowTypoCorrection);
        if (!Recovery.isInvalid()) {
          return Recovery;
        }
        
        // If the user passes in a function that we can't take the address of, we
        // generally end up emitting really bad error messages. Here, we attempt to
        // emit better ones.
        for (/*const*/ Expr /*P*/ Arg : Args) {
          if (!Arg.getType().$arrow().isFunctionType()) {
            continue;
          }
          {
            /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Arg.IgnoreParenImpCasts$Const());
            if ((DRE != null)) {
              /*const*/ FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(DRE.getDecl$Const());
              if ((FD != null)
                 && !SemaRef.checkAddressOfFunctionIsAvailable(FD, /*Complain=*/ true, 
                  Arg.getExprLoc())) {
                return ExprError();
              }
            }
          }
        }
        
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Fn.getLocStart(), diag.err_ovl_no_viable_function_in_call)), 
                ULE.getName()), Fn.getSourceRange()));
        CandidateSet.NoteCandidates(SemaRef, OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case OR_Ambiguous:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Fn.getLocStart(), diag.err_ovl_ambiguous_call)), 
                ULE.getName()), Fn.getSourceRange()));
        CandidateSet.NoteCandidates(SemaRef, OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(Args));
        break;
      } finally {
        $c$.$destroy();
      }
    }
   case OR_Deleted:
    {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(SemaRef.Diag(Fn.getLocStart(), diag.err_ovl_deleted_call)), 
                        (Best.$star()).Function.isDeleted()), 
                    ULE.getName()), 
                SemaRef.getDeletedOrUnavailableSuffix((Best.$star()).Function)), 
            Fn.getSourceRange()));
        CandidateSet.NoteCandidates(SemaRef, OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(Args));
        
        // We emitted an error for the unvailable/deleted function call but keep
        // the call in the AST.
        FunctionDecl /*P*/ FDecl = (Best.$star()).Function;
        Fn = SemaRef.FixOverloadedFunctionReference(Fn, new DeclAccessPair((Best.$star()).FoundDecl), FDecl);
        return SemaRef.BuildResolvedCallExpr(Fn, FDecl, new SourceLocation(LParenLoc), new ArrayRef<Expr /*P*/ >(Args), new SourceLocation(RParenLoc), 
            ExecConfig);
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Overload resolution failed.
  return ExprError();
}

//<editor-fold defaultstate="collapsed" desc="markUnaddressableCandidatesUnviable">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11434,
 FQN="markUnaddressableCandidatesUnviable", NM="_ZL35markUnaddressableCandidatesUnviableRN5clang4SemaERNS_20OverloadCandidateSetE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL35markUnaddressableCandidatesUnviableRN5clang4SemaERNS_20OverloadCandidateSetE")
//</editor-fold>
public static void markUnaddressableCandidatesUnviable(final Sema /*&*/ S, 
                                   final OverloadCandidateSet /*&*/ CS) {
  for (type$ptr<OverloadCandidate> I = CS.begin(), /*P*/ E = CS.end(); $noteq_iter(I, E); I.$preInc()) {
    if (I./*->*/$star().Viable
       && !S.checkAddressOfFunctionIsAvailable(I./*->*/$star().Function, /*Complain=*/ false)) {
      I./*->*/$star().Viable = false;
      I./*->*/$star().FailureKind = (byte)OverloadFailureKind.ovl_fail_addr_not_available.getValue();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="IsOverloaded">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 11482,
 FQN="IsOverloaded", NM="_ZL12IsOverloadedRKN5clang17UnresolvedSetImplE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZL12IsOverloadedRKN5clang17UnresolvedSetImplE")
//</editor-fold>
public static boolean IsOverloaded(final /*const*/ UnresolvedSetImpl /*&*/ Functions) {
  return $greater_uint(Functions.size(), 1)
     || (Functions.size() == 1 && isa_FunctionTemplateDecl(Functions.begin$Const().$star()));
}

} // END OF class SemaOverloadStatics
