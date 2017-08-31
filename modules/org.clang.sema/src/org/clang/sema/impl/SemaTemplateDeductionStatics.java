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
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.java.SemaFunctionPointers.*;
import static org.clang.ast.QualType.*;
import static org.clang.ast.AstClangGlobals.*;
import org.clang.sema.java.SemaJavaDifferentiators.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaTemplateDeductionStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL14isSameTemplatePN5clang12TemplateDeclES1_;_ZL16getDepthAndIndexPN5clang9NamedDeclE;_ZL16getDepthAndIndexSt4pairIN4llvm12PointerUnionIPKN5clang20TemplateTypeParmTypeEPNS2_9NamedDeclEEENS2_14SourceLocationEE;_ZL17GetTypeOfFunctionRN5clang4SemaERKNS_12OverloadExpr10FindResultEPNS_12FunctionDeclE;_ZL17isSameDeclarationPN5clang4DeclES1_;_ZL17isSameTemplateArgRN5clang10ASTContextERKNS_16TemplateArgumentES4_;_ZL20hasSameExtendedValueN4llvm6APSIntES0_;_ZL21makeTemplateParameterPN5clang4DeclE;_ZL22isSimpleTemplateIdTypeN5clang8QualTypeE;_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListENS_12TemplateNameES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_16TemplateArgumentEjS6_jRNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEb;_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_26TemplateSpecializationTypeENS_8QualTypeERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_8QualTypeEjS6_jRNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjb;_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListERKNS_16TemplateArgumentES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListERKNS_20TemplateArgumentListES6_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL24isAtLeastAsSpecializedAsRN5clang4SemaENS_14SourceLocationEPNS_20FunctionTemplateDeclES4_NS_30TemplatePartialOrderingContextEj;_ZL25DeduceFromInitializerListRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeEPNS_12InitListExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjRNS0_23TemplateDeductionResultE;_ZL25hasPackExpansionBeforeEndPKN5clang16TemplateArgumentEj;_ZL26MarkUsedTemplateParametersRN5clang10ASTContextENS_12TemplateNameEbjRN4llvm14SmallBitVectorE;_ZL26MarkUsedTemplateParametersRN5clang10ASTContextENS_8QualTypeEbjRN4llvm14SmallBitVectorE;_ZL26MarkUsedTemplateParametersRN5clang10ASTContextEPKNS_4ExprEbjRN4llvm14SmallBitVectorE;_ZL26MarkUsedTemplateParametersRN5clang10ASTContextEPNS_19NestedNameSpecifierEbjRN4llvm14SmallBitVectorE;_ZL26MarkUsedTemplateParametersRN5clang10ASTContextERKNS_16TemplateArgumentEbjRN4llvm14SmallBitVectorE;_ZL26isVariadicFunctionTemplatePN5clang20FunctionTemplateDeclE;_ZL27ResolveOverloadForDeductionRN5clang4SemaEPNS_21TemplateParameterListEPNS_4ExprENS_8QualTypeEb;_ZL27getDeducedParameterFromExprPN5clang4ExprE;_ZL29CheckOriginalCallArgDeductionRN5clang4SemaENS0_15OriginalCallArgENS_8QualTypeE;_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclEPNS_4ExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclEPNS_9ValueDeclERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclERKN4llvm6APSIntENS_8QualTypeEbRNS_4sema21TemplateDeductionInfoERNS4_15SmallVectorImplINS_23DeducedTemplateArgumentEEE;_ZL29checkDeducedTemplateArgumentsRN5clang10ASTContextERKNS_23DeducedTemplateArgumentES4_;_ZL29getTrivialTemplateArgumentLocRN5clang4SemaERKNS_16TemplateArgumentENS_8QualTypeENS_14SourceLocationE;_ZL30AddImplicitObjectParameterTypeRN5clang10ASTContextEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplINS_8QualTypeEEE;_ZL30ConvertDeducedTemplateArgumentRN5clang4SemaEPNS_9NamedDeclENS_23DeducedTemplateArgumentES3_RNS_4sema21TemplateDeductionInfoEbRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE;_ZL30hasDeducibleTemplateParametersRN5clang4SemaEPNS_20FunctionTemplateDeclENS_8QualTypeE;_ZL31FinishTemplateArgumentDeductionRN5clang4SemaEPNS_36VarTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS_4sema21TemplateDeductionInfoE;_ZL31FinishTemplateArgumentDeductionRN5clang4SemaEPNS_38ClassTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS_4sema21TemplateDeductionInfoE;_ZL31IsPossiblyOpaquelyQualifiedTypeN5clang8QualTypeE;_ZL31hasTemplateArgumentForDeductionRPKN5clang16TemplateArgumentERjS4_;_ZL33SubstAutoWithinFunctionReturnTypePN5clang12FunctionDeclENS_8QualTypeERNS_4SemaE;_ZL34DeduceTemplateArgumentsByTypeMatchRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjb;_ZL35DeduceTemplateArgumentByListElementRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeEPNS_4ExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEj;_ZL37hasInconsistentOrSupersetQualifiersOfN5clang8QualTypeES0_;_ZL41AdjustFunctionParmAndArgTypesForDeductionRN5clang4SemaEPNS_21TemplateParameterListERNS_8QualTypeES5_PNS_4ExprERj;_ZL51SpecializeCorrespondingLambdaCallOperatorAndInvokerPN5clang17CXXConversionDeclERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEENS_8QualTypeERNS_4sema21TemplateDeductionInfoERNS_4SemaE; -static-type=SemaTemplateDeductionStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaTemplateDeductionStatics {


/// \brief Compare two APSInts, extending and switching the sign as
/// necessary to compare their values regardless of underlying type.
//<editor-fold defaultstate="collapsed" desc="hasSameExtendedValue">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 67,
 FQN="hasSameExtendedValue", NM="_ZL20hasSameExtendedValueN4llvm6APSIntES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL20hasSameExtendedValueN4llvm6APSIntES0_")
//</editor-fold>
public static boolean hasSameExtendedValue(APSInt X, APSInt Y) {
  if ($greater_uint(Y.getBitWidth(), X.getBitWidth())) {
    X.$assignMove(X.extend(Y.getBitWidth()));
  } else if ($less_uint(Y.getBitWidth(), X.getBitWidth())) {
    Y.$assignMove(Y.extend(X.getBitWidth()));
  }
  
  // If there is a signedness mismatch, correct it.
  if (X.isSigned() != Y.isSigned()) {
    // If the signed value is negative, then the values cannot be the same.
    if ((Y.isSigned() && Y.isNegative()) || (X.isSigned() && X.isNegative())) {
      return false;
    }
    
    Y.setIsSigned(true);
    X.setIsSigned(true);
  }
  
  return X.$eq(Y);
}

//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 1675,
 FQN="DeduceTemplateArguments", NM="_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListERKNS_16TemplateArgumentES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListERKNS_16TemplateArgumentES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArguments1(final Sema /*&*/ S, 
                        TemplateParameterList /*P*/ TemplateParams, 
                        final /*const*/ TemplateArgument /*&*/ Param, 
                        TemplateArgument Arg, 
                        final TemplateDeductionInfo /*&*/ Info, 
                        final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  // If the template argument is a pack expansion, perform template argument
  // deduction against the pattern of that expansion. This only occurs during
  // partial ordering.
  if (Arg.isPackExpansion()) {
    Arg.$assignMove(Arg.getPackExpansionPattern());
  }
  switch (Param.getKind()) {
   case Null:
    throw new llvm_unreachable("Null template argument in parameter list");
   case Type:
    if (Arg.getKind() == TemplateArgument.ArgKind.Type) {
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          Param.getAsType(), 
          Arg.getAsType(), 
          Info, Deduced, 0);
    }
    Info.FirstArg.$assign(Param);
    Info.SecondArg.$assign(Arg);
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case Template:
    if (Arg.getKind() == TemplateArgument.ArgKind.Template) {
      return DeduceTemplateArguments(S, TemplateParams, 
          Param.getAsTemplate(), 
          Arg.getAsTemplate(), Info, Deduced);
    }
    Info.FirstArg.$assign(Param);
    Info.SecondArg.$assign(Arg);
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case TemplateExpansion:
    throw new llvm_unreachable("caller should handle pack expansions");
   case Declaration:
    if (Arg.getKind() == TemplateArgument.ArgKind.Declaration
       && isSameDeclaration(Param.getAsDecl(), Arg.getAsDecl())) {
      return Sema.TemplateDeductionResult.TDK_Success;
    }
    
    Info.FirstArg.$assign(Param);
    Info.SecondArg.$assign(Arg);
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case NullPtr:
    if (Arg.getKind() == TemplateArgument.ArgKind.NullPtr
       && S.Context.hasSameType(Param.getNullPtrType(), Arg.getNullPtrType())) {
      return Sema.TemplateDeductionResult.TDK_Success;
    }
    
    Info.FirstArg.$assign(Param);
    Info.SecondArg.$assign(Arg);
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case Integral:
    if (Arg.getKind() == TemplateArgument.ArgKind.Integral) {
      if (hasSameExtendedValue(Param.getAsIntegral(), Arg.getAsIntegral())) {
        return Sema.TemplateDeductionResult.TDK_Success;
      }
      
      Info.FirstArg.$assign(Param);
      Info.SecondArg.$assign(Arg);
      return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
    }
    if (Arg.getKind() == TemplateArgument.ArgKind.Expression) {
      Info.FirstArg.$assign(Param);
      Info.SecondArg.$assign(Arg);
      return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
    }
    
    Info.FirstArg.$assign(Param);
    Info.SecondArg.$assign(Arg);
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case Expression:
    {
      {
        NonTypeTemplateParmDecl /*P*/ NTTP = getDeducedParameterFromExpr(Param.getAsExpr());
        if ((NTTP != null)) {
          if (Arg.getKind() == TemplateArgument.ArgKind.Integral) {
            return DeduceNonTypeTemplateArgument(S, NTTP, 
                Arg.getAsIntegral(), 
                Arg.getIntegralType(), 
                /*ArrayBound=*/ false, 
                Info, Deduced);
          }
          if (Arg.getKind() == TemplateArgument.ArgKind.Expression) {
            return DeduceNonTypeTemplateArgument1(S, NTTP, Arg.getAsExpr(), 
                Info, Deduced);
          }
          if (Arg.getKind() == TemplateArgument.ArgKind.Declaration) {
            return DeduceNonTypeTemplateArgument2(S, NTTP, Arg.getAsDecl(), 
                Info, Deduced);
          }
          
          Info.FirstArg.$assign(Param);
          Info.SecondArg.$assign(Arg);
          return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
        }
      }
      
      // Can't deduce anything, but that's okay.
      return Sema.TemplateDeductionResult.TDK_Success;
    }
   case Pack:
    throw new llvm_unreachable("Argument packs should be expanded by the caller!");
  }
  throw new llvm_unreachable("Invalid TemplateArgument Kind!");
}


/// \brief Deduce the template arguments by comparing the parameter type and
/// the argument type (C++ [temp.deduct.type]).
///
/// \param S the semantic analysis object within which we are deducing
///
/// \param TemplateParams the template parameters that we are deducing
///
/// \param ParamIn the parameter type
///
/// \param ArgIn the argument type
///
/// \param Info information about the template argument deduction itself
///
/// \param Deduced the deduced template arguments
///
/// \param TDF bitwise OR of the TemplateDeductionFlags bits that describe
/// how template argument deduction is performed.
///
/// \param PartialOrdering Whether we're performing template argument deduction
/// in the context of partial ordering (C++0x [temp.deduct.partial]).
///
/// \returns the result of template argument deduction so far. Note that a
/// "success" result means that template argument deduction has not yet failed,
/// but it may still fail, later, for other reasons.
//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArgumentsByTypeMatch">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 938,
 FQN="DeduceTemplateArgumentsByTypeMatch", NM="_ZL34DeduceTemplateArgumentsByTypeMatchRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL34DeduceTemplateArgumentsByTypeMatchRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjb")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArgumentsByTypeMatch(final Sema /*&*/ S, 
                                  TemplateParameterList /*P*/ TemplateParams, 
                                  QualType ParamIn, QualType ArgIn, 
                                  final TemplateDeductionInfo /*&*/ Info, 
                                  final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                                  /*uint*/int TDF) {
  return DeduceTemplateArgumentsByTypeMatch(S, 
                                  TemplateParams, 
                                  ParamIn, ArgIn, 
                                  Info, 
                                  Deduced, 
                                  TDF, 
                                  false);
}
public static Sema.TemplateDeductionResult DeduceTemplateArgumentsByTypeMatch(final Sema /*&*/ S, 
                                  TemplateParameterList /*P*/ TemplateParams, 
                                  QualType ParamIn, QualType ArgIn, 
                                  final TemplateDeductionInfo /*&*/ Info, 
                                  final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                                  /*uint*/int TDF, 
                                  boolean PartialOrdering/*= false*/) {
  // We only want to look at the canonical types, since typedefs and
  // sugar are not part of template argument deduction.
  QualType Param = S.Context.getCanonicalType(new QualType(ParamIn)).$QualType();
  QualType Arg = S.Context.getCanonicalType(new QualType(ArgIn)).$QualType();
  {
    
    // If the argument type is a pack expansion, look at its pattern.
    // This isn't explicitly called out
    /*const*/ PackExpansionType /*P*/ ArgExpansion = dyn_cast_PackExpansionType(Arg);
    if ((ArgExpansion != null)) {
      Arg.$assignMove(ArgExpansion.getPattern());
    }
  }
  if (PartialOrdering) {
    // C++11 [temp.deduct.partial]p5:
    //   Before the partial ordering is done, certain transformations are
    //   performed on the types used for partial ordering:
    //     - If P is a reference type, P is replaced by the type referred to.
    /*const*/ ReferenceType /*P*/ ParamRef = Param.$arrow().getAs(ReferenceType.class);
    if ((ParamRef != null)) {
      Param.$assignMove(ParamRef.getPointeeType());
    }
    
    //     - If A is a reference type, A is replaced by the type referred to.
    /*const*/ ReferenceType /*P*/ ArgRef = Arg.$arrow().getAs(ReferenceType.class);
    if ((ArgRef != null)) {
      Arg.$assignMove(ArgRef.getPointeeType());
    }
    if ((ParamRef != null) && (ArgRef != null) && S.Context.hasSameUnqualifiedType(new QualType(Param), new QualType(Arg))) {
      // C++11 [temp.deduct.partial]p9:
      //   If, for a given type, deduction succeeds in both directions (i.e.,
      //   the types are identical after the transformations above) and both
      //   P and A were reference types [...]:
      //     - if [one type] was an lvalue reference and [the other type] was
      //       not, [the other type] is not considered to be at least as
      //       specialized as [the first type]
      //     - if [one type] is more cv-qualified than [the other type],
      //       [the other type] is not considered to be at least as specialized
      //       as [the first type]
      // Objective-C ARC adds:
      //     - [one type] has non-trivial lifetime, [the other type] has
      //       __unsafe_unretained lifetime, and the types are otherwise
      //       identical
      //
      // A is "considered to be at least as specialized" as P iff deduction
      // succeeds, so we model this as a deduction failure. Note that
      // [the first type] is P and [the other type] is A here; the standard
      // gets this backwards.
      Qualifiers ParamQuals = Param.getQualifiers();
      Qualifiers ArgQuals = Arg.getQualifiers();
      if ((ParamRef.isLValueReferenceType()
         && !ArgRef.isLValueReferenceType())
         || ParamQuals.isStrictSupersetOf(new Qualifiers(ArgQuals))
         || (ParamQuals.hasNonTrivialObjCLifetime()
         && ArgQuals.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_ExplicitNone
         && ParamQuals.withoutObjCLifetime().$eq(
          ArgQuals.withoutObjCLifetime()
      ))) {
        Info.FirstArg.$assignMove(new TemplateArgument(new QualType(ParamIn)));
        Info.SecondArg.$assignMove(new TemplateArgument(new QualType(ArgIn)));
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
    }
    
    // C++11 [temp.deduct.partial]p7:
    //   Remove any top-level cv-qualifiers:
    //     - If P is a cv-qualified type, P is replaced by the cv-unqualified
    //       version of P.
    Param.$assignMove(Param.getUnqualifiedType());
    //     - If A is a cv-qualified type, A is replaced by the cv-unqualified
    //       version of A.
    Arg.$assignMove(Arg.getUnqualifiedType());
  } else {
    // C++0x [temp.deduct.call]p4 bullet 1:
    //   - If the original P is a reference type, the deduced A (i.e., the type
    //     referred to by the reference) can be more cv-qualified than the
    //     transformed A.
    if (((TDF & TemplateDeductionFlags.TDF_ParamWithReferenceType) != 0)) {
      Qualifiers Quals/*J*/= new Qualifiers();
      QualType UnqualParam = S.Context.getUnqualifiedArrayType(new QualType(Param), Quals);
      Quals.setCVRQualifiers(Quals.getCVRQualifiers()
             & Arg.getCVRQualifiers());
      Param.$assignMove(S.Context.getQualifiedType(new QualType(UnqualParam), new Qualifiers(Quals)));
    }
    if (((TDF & TemplateDeductionFlags.TDF_TopLevelParameterTypeList) != 0) && !Param.$arrow().isFunctionType()) {
      // C++0x [temp.deduct.type]p10:
      //   If P and A are function types that originated from deduction when
      //   taking the address of a function template (14.8.2.2) or when deducing
      //   template arguments from a function declaration (14.8.2.6) and Pi and
      //   Ai are parameters of the top-level parameter-type-list of P and A,
      //   respectively, Pi is adjusted if it is an rvalue reference to a
      //   cv-unqualified template parameter and Ai is an lvalue reference, in
      //   which case the type of Pi is changed to be the template parameter
      //   type (i.e., T&& is changed to simply T). [ Note: As a result, when
      //   Pi is T&& and Ai is X&, the adjusted Pi will be T, causing T to be
      //   deduced as X&. - end note ]
      TDF &= ~TemplateDeductionFlags.TDF_TopLevelParameterTypeList;
      {
        
        /*const*/ RValueReferenceType /*P*/ ParamRef = Param.$arrow().getAs(RValueReferenceType.class);
        if ((ParamRef != null)) {
          if (isa_TemplateTypeParmType(ParamRef.getPointeeType())
             && !ParamRef.getPointeeType().getQualifiers().$bool()) {
            if (Arg.$arrow().isLValueReferenceType()) {
              Param.$assignMove(ParamRef.getPointeeType());
            }
          }
        }
      }
    }
  }
  {
    
    // C++ [temp.deduct.type]p9:
    //   A template type argument T, a template template argument TT or a
    //   template non-type argument i can be deduced if P and A have one of
    //   the following forms:
    //
    //     T
    //     cv-list T
    /*const*/ TemplateTypeParmType /*P*/ TemplateTypeParm = Param.$arrow().<TemplateTypeParmType>getAs$TemplateTypeParmType();
    if ((TemplateTypeParm != null)) {
      // Just skip any attempts to deduce from a placeholder type.
      if (Arg.$arrow().isPlaceholderType()) {
        return Sema.TemplateDeductionResult.TDK_Success;
      }
      
      /*uint*/int Index = TemplateTypeParm.getIndex();
      boolean RecanonicalizeArg = false;
      
      // If the argument type is an array type, move the qualifiers up to the
      // top level, so they can be matched with the qualifiers on the parameter.
      if (isa_ArrayType(Arg)) {
        Qualifiers Quals/*J*/= new Qualifiers();
        Arg.$assignMove(S.Context.getUnqualifiedArrayType(new QualType(Arg), Quals));
        if (Quals.$bool()) {
          Arg.$assignMove(S.Context.getQualifiedType(new QualType(Arg), new Qualifiers(Quals)));
          RecanonicalizeArg = true;
        }
      }
      
      // The argument type can not be less qualified than the parameter
      // type.
      if (!((TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers) != 0)
         && hasInconsistentOrSupersetQualifiersOf(new QualType(Param), new QualType(Arg))) {
        Info.Param.$assign_T$C$R(TemplateTypeParmDecl /*P*/.class, cast_TemplateTypeParmDecl(TemplateParams.getParam(Index)));
        Info.FirstArg.$assignMove(new TemplateArgument(new QualType(Param)));
        Info.SecondArg.$assignMove(new TemplateArgument(new QualType(Arg)));
        return Sema.TemplateDeductionResult.TDK_Underqualified;
      }
      assert (TemplateTypeParm.getDepth() == 0) : "Can't deduce with depth > 0";
      assert ($noteq_QualType$C(Arg, S.Context.OverloadTy.$QualType())) : "Unresolved overloaded function";
      QualType DeducedType = new QualType(Arg);
      
      // Remove any qualifiers on the parameter from the deduced type.
      // We checked the qualifiers for consistency above.
      Qualifiers DeducedQs = DeducedType.getQualifiers();
      Qualifiers ParamQs = Param.getQualifiers();
      DeducedQs.removeCVRQualifiers(ParamQs.getCVRQualifiers());
      if (ParamQs.hasObjCGCAttr()) {
        DeducedQs.removeObjCGCAttr();
      }
      if (ParamQs.hasAddressSpace()) {
        DeducedQs.removeAddressSpace();
      }
      if (ParamQs.hasObjCLifetime()) {
        DeducedQs.removeObjCLifetime();
      }
      
      // Objective-C ARC:
      //   If template deduction would produce a lifetime qualifier on a type
      //   that is not a lifetime type, template argument deduction fails.
      if (ParamQs.hasObjCLifetime() && !DeducedType.$arrow().isObjCLifetimeType()
         && !DeducedType.$arrow().isDependentType()) {
        Info.Param.$assign_T$C$R(TemplateTypeParmDecl /*P*/.class, cast_TemplateTypeParmDecl(TemplateParams.getParam(Index)));
        Info.FirstArg.$assignMove(new TemplateArgument(new QualType(Param)));
        Info.SecondArg.$assignMove(new TemplateArgument(new QualType(Arg)));
        return Sema.TemplateDeductionResult.TDK_Underqualified;
      }
      
      // Objective-C ARC:
      //   If template deduction would produce an argument type with lifetime type
      //   but no lifetime qualifier, the __strong lifetime qualifier is inferred.
      if (S.getLangOpts().ObjCAutoRefCount
         && DeducedType.$arrow().isObjCLifetimeType()
         && !DeducedQs.hasObjCLifetime()) {
        DeducedQs.setObjCLifetime(Qualifiers.ObjCLifetime.OCL_Strong);
      }
      
      DeducedType.$assignMove(S.Context.getQualifiedType(DeducedType.getUnqualifiedType(), 
              new Qualifiers(DeducedQs)));
      if (RecanonicalizeArg) {
        DeducedType.$assignMove(S.Context.getCanonicalType(new QualType(DeducedType)).$QualType());
      }
      
      DeducedTemplateArgument NewDeduced/*J*/= new DeducedTemplateArgument(new TemplateArgument(new QualType(DeducedType)));
      DeducedTemplateArgument Result = checkDeducedTemplateArguments(S.Context, 
          Deduced.$at(Index), 
          NewDeduced);
      if (Result.isNull()) {
        Info.Param.$assign_T$C$R(TemplateTypeParmDecl /*P*/.class, cast_TemplateTypeParmDecl(TemplateParams.getParam(Index)));
        Info.FirstArg.$assign(Deduced.$at(Index));
        Info.SecondArg.$assign(NewDeduced);
        return Sema.TemplateDeductionResult.TDK_Inconsistent;
      }
      
      Deduced.$at(Index).$assign(Result);
      return Sema.TemplateDeductionResult.TDK_Success;
    }
  }
  
  // Set up the template argument deduction information for a failure.
  Info.FirstArg.$assignMove(new TemplateArgument(new QualType(ParamIn)));
  Info.SecondArg.$assignMove(new TemplateArgument(new QualType(ArgIn)));
  
  // If the parameter is an already-substituted template parameter
  // pack, do nothing: we don't know which of its arguments to look
  // at, so we have to wait until all of the parameter packs in this
  // expansion have arguments.
  if (isa_SubstTemplateTypeParmPackType(Param)) {
    return Sema.TemplateDeductionResult.TDK_Success;
  }
  
  // Check the cv-qualifiers on the parameter and argument types.
  CanQual<Type> CanParam = S.Context.getCanonicalType(new QualType(Param));
  CanQual<Type> CanArg = S.Context.getCanonicalType(new QualType(Arg));
  if (!((TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers) != 0)) {
    if (((TDF & TemplateDeductionFlags.TDF_ParamWithReferenceType) != 0)) {
      if (hasInconsistentOrSupersetQualifiersOf(new QualType(Param), new QualType(Arg))) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
    } else if (!IsPossiblyOpaquelyQualifiedType(new QualType(Param))) {
      if (Param.getCVRQualifiers() != Arg.getCVRQualifiers()) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
    }
    
    // If the parameter type is not dependent, there is nothing to deduce.
    if (!Param.$arrow().isDependentType()) {
      if (!((TDF & TemplateDeductionFlags.TDF_SkipNonDependent) != 0)) {
        boolean NonDeduced = ((TDF & TemplateDeductionFlags.TDF_InOverloadResolution) != 0) ? !S.isSameOrCompatibleFunctionType(new CanQual<Type>(CanParam), new CanQual<Type>(CanArg)) : $noteq_QualType$C(Param, Arg);
        if (NonDeduced) {
          return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
        }
      }
      return Sema.TemplateDeductionResult.TDK_Success;
    }
  } else if (!Param.$arrow().isDependentType()) {
    CanQual<Type> ParamUnqualType = CanParam.getUnqualifiedType(), 
        ArgUnqualType = CanArg.getUnqualifiedType();
    boolean Success = ((TDF & TemplateDeductionFlags.TDF_InOverloadResolution) != 0) ? S.isSameOrCompatibleFunctionType(new CanQual<Type>(ParamUnqualType), 
        new CanQual<Type>(ArgUnqualType)) : $eq_CanQual$T_CanQual$U(/*NO_COPY*/ParamUnqualType, /*NO_COPY*/ArgUnqualType);
    if (Success) {
      return Sema.TemplateDeductionResult.TDK_Success;
    }
  }
  switch (Param.$arrow().getTypeClass()) {
   case Paren:
    throw new llvm_unreachable("deducing non-canonical type: Paren");
   case Typedef:
    throw new llvm_unreachable("deducing non-canonical type: Typedef");
   case Adjusted:
    throw new llvm_unreachable("deducing non-canonical type: Adjusted");
   case Decayed:
    throw new llvm_unreachable("deducing non-canonical type: Decayed");
   case Elaborated:
    throw new llvm_unreachable("deducing non-canonical type: Elaborated");
   case Attributed:
    throw new llvm_unreachable("deducing non-canonical type: Attributed");
   case SubstTemplateTypeParm:
    throw new llvm_unreachable("deducing non-canonical type: SubstTemplateTypeParm");
   case TemplateTypeParm:
   case SubstTemplateTypeParmPack:
    throw new llvm_unreachable("Type nodes handled above");
   case Builtin:
   case VariableArray:
   case Vector:
   case FunctionNoProto:
   case Record:
   case Enum:
   case ObjCObject:
   case ObjCInterface:
   case ObjCObjectPointer:
    {
      if (((TDF & TemplateDeductionFlags.TDF_SkipNonDependent) != 0)) {
        return Sema.TemplateDeductionResult.TDK_Success;
      }
      if (((TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers) != 0)) {
        Param.$assignMove(Param.getUnqualifiedType());
        Arg.$assignMove(Arg.getUnqualifiedType());
      }
      
      return $eq_QualType$C(Param, Arg) ? Sema.TemplateDeductionResult.TDK_Success : Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
    }
   case Complex:
    {
      
      //     _Complex T   [placeholder extension]  
      /*const*/ ComplexType /*P*/ ComplexArg = Arg.$arrow().getAs(ComplexType.class);
      if ((ComplexArg != null)) {
        return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
            cast_ComplexType(Param).getElementType(), 
            ComplexArg.getElementType(), 
            Info, Deduced, TDF);
      }
    }
    
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case Atomic:
    {
      
      //     _Atomic T   [extension]
      /*const*/ AtomicType /*P*/ AtomicArg = Arg.$arrow().getAs(AtomicType.class);
      if ((AtomicArg != null)) {
        return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
            cast_AtomicType(Param).getValueType(), 
            AtomicArg.getValueType(), 
            Info, Deduced, TDF);
      }
    }
    
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
   case Pointer:
    {
      QualType PointeeType/*J*/= new QualType();
      {
        /*const*/ PointerType /*P*/ PointerArg = Arg.$arrow().getAs(PointerType.class);
        if ((PointerArg != null)) {
          PointeeType.$assignMove(PointerArg.getPointeeType());
        } else {
          /*const*/ ObjCObjectPointerType /*P*/ PointerArg$1 = Arg.$arrow().getAs(ObjCObjectPointerType.class);
          if ((PointerArg$1 != null)) {
            PointeeType.$assignMove(PointerArg$1.getPointeeType());
          } else {
            return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
          }
        }
      }
      
      /*uint*/int SubTDF = TDF & (TemplateDeductionFlags.TDF_IgnoreQualifiers | TemplateDeductionFlags.TDF_DerivedClass);
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          cast_PointerType(Param).getPointeeType(), 
          new QualType(PointeeType), 
          Info, Deduced, SubTDF);
    }
   case LValueReference:
    {
      /*const*/ LValueReferenceType /*P*/ ReferenceArg = Arg.$arrow().getAs(LValueReferenceType.class);
      if (!(ReferenceArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          cast_LValueReferenceType(Param).getPointeeType(), 
          ReferenceArg.getPointeeType(), Info, Deduced, 0);
    }
   case RValueReference:
    {
      /*const*/ RValueReferenceType /*P*/ ReferenceArg = Arg.$arrow().getAs(RValueReferenceType.class);
      if (!(ReferenceArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          cast_RValueReferenceType(Param).getPointeeType(), 
          ReferenceArg.getPointeeType(), 
          Info, Deduced, 0);
    }
   case IncompleteArray:
    {
      /*const*/ IncompleteArrayType /*P*/ IncompleteArrayArg = S.Context.getAsIncompleteArrayType(new QualType(Arg));
      if (!(IncompleteArrayArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      /*uint*/int SubTDF = TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers;
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          S.Context.getAsIncompleteArrayType(new QualType(Param)).getElementType(), 
          IncompleteArrayArg.getElementType(), 
          Info, Deduced, SubTDF);
    }
   case ConstantArray:
    {
      /*const*/ ConstantArrayType /*P*/ ConstantArrayArg = S.Context.getAsConstantArrayType(new QualType(Arg));
      if (!(ConstantArrayArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      /*const*/ ConstantArrayType /*P*/ ConstantArrayParm = S.Context.getAsConstantArrayType(new QualType(Param));
      if (ConstantArrayArg.getSize().$noteq(ConstantArrayParm.getSize())) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      /*uint*/int SubTDF = TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers;
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          ConstantArrayParm.getElementType(), 
          ConstantArrayArg.getElementType(), 
          Info, Deduced, SubTDF);
    }
   case DependentSizedArray:
    {
      /*const*/ ArrayType /*P*/ ArrayArg = S.Context.getAsArrayType(new QualType(Arg));
      if (!(ArrayArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      /*uint*/int SubTDF = TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers;
      
      // Check the element type of the arrays
      /*const*/ DependentSizedArrayType /*P*/ DependentArrayParm = S.Context.getAsDependentSizedArrayType(new QualType(Param));
      {
        Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
            DependentArrayParm.getElementType(), 
            ArrayArg.getElementType(), 
            Info, Deduced, SubTDF);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
      
      // Determine the array bound is something we can deduce.
      NonTypeTemplateParmDecl /*P*/ NTTP = getDeducedParameterFromExpr(DependentArrayParm.getSizeExpr());
      if (!(NTTP != null)) {
        return Sema.TemplateDeductionResult.TDK_Success;
      }
      
      // We can perform template argument deduction for the given non-type
      // template parameter.
      assert (NTTP.getDepth() == 0) : "Cannot deduce non-type template argument at depth > 0";
      {
        /*const*/ ConstantArrayType /*P*/ ConstantArrayArg = dyn_cast_ConstantArrayType(ArrayArg);
        if ((ConstantArrayArg != null)) {
          APSInt Size/*J*/= new APSInt(new APInt(ConstantArrayArg.getSize()));
          return DeduceNonTypeTemplateArgument(S, NTTP, Size, 
              S.Context.getSizeType().$QualType(), 
              /*ArrayBound=*/ true, 
              Info, Deduced);
        }
      }
      {
        /*const*/ DependentSizedArrayType /*P*/ DependentArrayArg = dyn_cast_DependentSizedArrayType(ArrayArg);
        if ((DependentArrayArg != null)) {
          if ((DependentArrayArg.getSizeExpr() != null)) {
            return DeduceNonTypeTemplateArgument1(S, NTTP, 
                DependentArrayArg.getSizeExpr(), 
                Info, Deduced);
          }
        }
      }
      
      // Incomplete type does not match a dependently-sized array type
      return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
    }
   case FunctionProto:
    {
      /*uint*/int SubTDF = TDF & TemplateDeductionFlags.TDF_TopLevelParameterTypeList;
      /*const*/ FunctionProtoType /*P*/ FunctionProtoArg = dyn_cast_FunctionProtoType(Arg);
      if (!(FunctionProtoArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      /*const*/ FunctionProtoType /*P*/ FunctionProtoParam = cast_FunctionProtoType(Param);
      if (FunctionProtoParam.getTypeQuals()
         != FunctionProtoArg.getTypeQuals()
         || FunctionProtoParam.getRefQualifier()
         != FunctionProtoArg.getRefQualifier()
         || FunctionProtoParam.isVariadic() != FunctionProtoArg.isVariadic()) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      {
        
        // Check return types.
        Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, FunctionProtoParam.getReturnType(), 
            FunctionProtoArg.getReturnType(), Info, Deduced, 0);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
      
      return DeduceTemplateArguments(S, TemplateParams, FunctionProtoParam.param_type_begin(), 
          FunctionProtoParam.getNumParams(), 
          FunctionProtoArg.param_type_begin(), 
          FunctionProtoArg.getNumParams(), Info, Deduced, SubTDF);
    }
   case InjectedClassName:
    {
      // Treat a template's injected-class-name as if the template
      // specialization type had been used.
      Param.$assignMove(cast_InjectedClassNameType(Param).
              getInjectedSpecializationType());
      assert (isa_TemplateSpecializationType(Param)) : "injected class name is not a template specialization type";
      // fall through
    }
   case TemplateSpecialization:
    {
      /*const*/ TemplateSpecializationType /*P*/ SpecParam = cast_TemplateSpecializationType(Param);
      
      // When Arg cannot be a derived class, we can just try to deduce template
      // arguments from the template-id.
      /*const*/ RecordType /*P*/ RecordT = Arg.$arrow().<RecordType>getAs$RecordType();
      if (!((TDF & TemplateDeductionFlags.TDF_DerivedClass) != 0) || !(RecordT != null)) {
        return DeduceTemplateArguments2(S, TemplateParams, SpecParam, new QualType(Arg), Info, 
            Deduced);
      }
      
      SmallVector<DeducedTemplateArgument> DeducedOrig/*J*/= new SmallVector<DeducedTemplateArgument>(JD$T.INSTANCE, 8, Deduced.begin(), 
          Deduced.end(), new DeducedTemplateArgument());
      
      Sema.TemplateDeductionResult Result = DeduceTemplateArguments2(S, TemplateParams, SpecParam, new QualType(Arg), Info, Deduced);
      if (Result == Sema.TemplateDeductionResult.TDK_Success) {
        return Result;
      }
      
      // We cannot inspect base classes as part of deduction when the type
      // is incomplete, so either instantiate any templates necessary to
      // complete the type, or skip over it if it cannot be completed.
      if (!S.isCompleteType(Info.getLocation(), new QualType(Arg))) {
        return Result;
      }
      
      // C++14 [temp.deduct.call] p4b3:
      //   If P is a class and P has the form simple-template-id, then the
      //   transformed A can be a derived class of the deduced A. Likewise if
      //   P is a pointer to a class of the form simple-template-id, the
      //   transformed A can be a pointer to a derived class pointed to by the
      //   deduced A.
      //
      //   These alternatives are considered only if type deduction would
      //   otherwise fail. If they yield more than one possible deduced A, the
      //   type deduction fails.
      
      // Reset the incorrectly deduced argument from above.
      Deduced.$assign(DeducedOrig);
      
      // Use data recursion to crawl through the list of base classes.
      // Visited contains the set of nodes we have already visited, while
      // ToVisit is our stack of records that we still need to visit.
      SmallPtrSet</*const*/ RecordType /*P*/ > Visited/*J*/= new SmallPtrSet</*const*/ RecordType /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
      SmallVector</*const*/ RecordType /*P*/ > ToVisit/*J*/= new SmallVector</*const*/ RecordType /*P*/ >(8, (/*const*/ RecordType /*P*/ )null);
      ToVisit.push_back(RecordT);
      boolean Successful = false;
      SmallVector<DeducedTemplateArgument> SuccessfulDeduced/*J*/= new SmallVector<DeducedTemplateArgument>(8, new DeducedTemplateArgument());
      while (!ToVisit.empty()) {
        // Retrieve the next class in the inheritance hierarchy.
        /*const*/ RecordType /*P*/ NextT = ToVisit.pop_back_val();
        
        // If we have already seen this type, skip it.
        if (!Visited.insert(NextT).second) {
          continue;
        }
        
        // If this is a base class, try to perform template argument
        // deduction from it.
        if (NextT != RecordT) {
          TemplateDeductionInfo BaseInfo = null;
          try {
            BaseInfo/*J*/= new TemplateDeductionInfo(Info.getLocation());
            Sema.TemplateDeductionResult BaseResult = DeduceTemplateArguments2(S, TemplateParams, SpecParam, 
                new QualType(NextT, 0), BaseInfo, Deduced);
            
            // If template argument deduction for this base was successful,
            // note that we had some success. Otherwise, ignore any deductions
            // from this base class.
            if (BaseResult == Sema.TemplateDeductionResult.TDK_Success) {
              // If we've already seen some success, then deduction fails due to
              // an ambiguity (temp.deduct.call p5).
              if (Successful) {
                return Sema.TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
              }
              
              Successful = true;
              /*std.swap(*/SuccessfulDeduced.swap(/*,*/ Deduced);
              
              Info.Param.$assign(BaseInfo.Param);
              Info.FirstArg.$assign(BaseInfo.FirstArg);
              Info.SecondArg.$assign(BaseInfo.SecondArg);
            }
            
            Deduced.$assign(DeducedOrig);
          } finally {
            if (BaseInfo != null) { BaseInfo.$destroy(); }
          }
        }
        
        // Visit base classes
        CXXRecordDecl /*P*/ Next = cast_CXXRecordDecl(NextT.getDecl());
        for (final /*const*/ CXXBaseSpecifier /*&*/ Base : Next.bases()) {
          assert (Base.getType().$arrow().isRecordType()) : "Base class that isn't a record?";
          ToVisit.push_back(Base.getType().$arrow().<RecordType>getAs$RecordType());
        }
      }
      if (Successful) {
        /*std.swap(*/SuccessfulDeduced.swap(/*,*/ Deduced);
        return Sema.TemplateDeductionResult.TDK_Success;
      }
      
      return Result;
    }
   case MemberPointer:
    {
      /*const*/ MemberPointerType /*P*/ MemPtrParam = cast_MemberPointerType(Param);
      /*const*/ MemberPointerType /*P*/ MemPtrArg = dyn_cast_MemberPointerType(Arg);
      if (!(MemPtrArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      QualType ParamPointeeType = MemPtrParam.getPointeeType();
      if (ParamPointeeType.$arrow().isFunctionType()) {
        S.adjustMemberFunctionCC(ParamPointeeType, /*IsStatic=*/ true, 
            /*IsCtorOrDtor=*/ false, Info.getLocation());
      }
      QualType ArgPointeeType = MemPtrArg.getPointeeType();
      if (ArgPointeeType.$arrow().isFunctionType()) {
        S.adjustMemberFunctionCC(ArgPointeeType, /*IsStatic=*/ true, 
            /*IsCtorOrDtor=*/ false, Info.getLocation());
      }
      {
        
        Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
            new QualType(ParamPointeeType), 
            new QualType(ArgPointeeType), 
            Info, Deduced, 
            TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
      
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          new QualType(MemPtrParam.__getClass(), 0), 
          new QualType(MemPtrArg.__getClass(), 0), 
          Info, Deduced, 
          TDF & TemplateDeductionFlags.TDF_IgnoreQualifiers);
    }
   case BlockPointer:
    {
      /*const*/ BlockPointerType /*P*/ BlockPtrParam = cast_BlockPointerType(Param);
      /*const*/ BlockPointerType /*P*/ BlockPtrArg = dyn_cast_BlockPointerType(Arg);
      if (!(BlockPtrArg != null)) {
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
      
      return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          BlockPtrParam.getPointeeType(), 
          BlockPtrArg.getPointeeType(), 
          Info, Deduced, 0);
    }
   case ExtVector:
    {
      /*const*/ ExtVectorType /*P*/ VectorParam = cast_ExtVectorType(Param);
      {
        /*const*/ ExtVectorType /*P*/ VectorArg = dyn_cast_ExtVectorType(Arg);
        if ((VectorArg != null)) {
          // Make sure that the vectors have the same number of elements.
          if (VectorParam.getNumElements() != VectorArg.getNumElements()) {
            return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
          }
          
          // Perform deduction on the element types.
          return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
              VectorParam.getElementType(), 
              VectorArg.getElementType(), 
              Info, Deduced, TDF);
        }
      }
      {
        
        /*const*/ DependentSizedExtVectorType /*P*/ VectorArg = dyn_cast_DependentSizedExtVectorType(Arg);
        if ((VectorArg != null)) {
          // We can't check the number of elements, since the argument has a
          // dependent number of elements. This can only occur during partial
          // ordering.
          
          // Perform deduction on the element types.
          return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
              VectorParam.getElementType(), 
              VectorArg.getElementType(), 
              Info, Deduced, TDF);
        }
      }
      
      return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
    }
   case DependentSizedExtVector:
    {
      /*const*/ DependentSizedExtVectorType /*P*/ VectorParam = cast_DependentSizedExtVectorType(Param);
      {
        
        /*const*/ ExtVectorType /*P*/ VectorArg = dyn_cast_ExtVectorType(Arg);
        if ((VectorArg != null)) {
          {
            // Perform deduction on the element types.
            Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
                VectorParam.getElementType(), 
                VectorArg.getElementType(), 
                Info, Deduced, TDF);
            if ((Result.getValue() != 0)) {
              return Result;
            }
          }
          
          // Perform deduction on the vector size, if we can.
          NonTypeTemplateParmDecl /*P*/ NTTP = getDeducedParameterFromExpr(VectorParam.getSizeExpr());
          if (!(NTTP != null)) {
            return Sema.TemplateDeductionResult.TDK_Success;
          }
          
          APSInt ArgSize/*J*/= new APSInt($ulong2uint(S.Context.getTypeSize(S.Context.IntTy.$QualType())), false);
          ArgSize.$assign($uint2ulong(VectorArg.getNumElements()));
          return DeduceNonTypeTemplateArgument(S, NTTP, ArgSize, S.Context.IntTy.$QualType(), 
              false, Info, Deduced);
        }
      }
      {
        
        /*const*/ DependentSizedExtVectorType /*P*/ VectorArg = dyn_cast_DependentSizedExtVectorType(Arg);
        if ((VectorArg != null)) {
          {
            // Perform deduction on the element types.
            Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
                VectorParam.getElementType(), 
                VectorArg.getElementType(), 
                Info, Deduced, TDF);
            if ((Result.getValue() != 0)) {
              return Result;
            }
          }
          
          // Perform deduction on the vector size, if we can.
          NonTypeTemplateParmDecl /*P*/ NTTP = getDeducedParameterFromExpr(VectorParam.getSizeExpr());
          if (!(NTTP != null)) {
            return Sema.TemplateDeductionResult.TDK_Success;
          }
          
          return DeduceNonTypeTemplateArgument1(S, NTTP, VectorArg.getSizeExpr(), 
              Info, Deduced);
        }
      }
      
      return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
    }
   case TypeOfExpr:
   case TypeOf:
   case DependentName:
   case UnresolvedUsing:
   case Decltype:
   case UnaryTransform:
   case Auto:
   case DependentTemplateSpecialization:
   case PackExpansion:
   case Pipe:
    // No template argument deduction for these types
    return Sema.TemplateDeductionResult.TDK_Success;
  }
  throw new llvm_unreachable("Invalid Type Class!");
}

//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 1835,
 FQN="DeduceTemplateArguments", NM="_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_16TemplateArgumentEjS6_jRNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_16TemplateArgumentEjS6_jRNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEb")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArguments(final Sema /*&*/ S, TemplateParameterList /*P*/ TemplateParams, 
                       /*const*/ type$ptr<TemplateArgument /*P*/> Params, /*uint*/int NumParams, 
                       /*const*/  type$ptr<TemplateArgument /*P*/> Args, /*uint*/int NumArgs, 
                       final TemplateDeductionInfo /*&*/ Info, 
                       final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                       boolean NumberOfArgumentsMustMatch) {
  // C++0x [temp.deduct.type]p9:
  //   If the template argument list of P contains a pack expansion that is not
  //   the last template argument, the entire template argument list is a
  //   non-deduced context.
  if (hasPackExpansionBeforeEnd(Params, NumParams)) {
    return Sema.TemplateDeductionResult.TDK_Success;
  }
  
  // C++0x [temp.deduct.type]p9:
  //   If P has a form that contains <T> or <i>, then each argument Pi of the
  //   respective template argument list P is compared with the corresponding
  //   argument Ai of the corresponding template argument list of A.
  uint$ref ArgIdx = create_uint$ref(0), ParamIdx = create_uint$ref(0);
  uint$ref NumParamsRef = create_uint$ref(NumParams), NumArgsRef = create_uint$ref(NumArgs);
  /*JAVA*/Params = $tryClone(Params);
  /*JAVA*/Args = $tryClone(Args);
  for (; hasTemplateArgumentForDeduction(Params, ParamIdx, NumParamsRef);
       ParamIdx.$set$preInc()) {
    PackDeductionScope PackScope = null;
    try {
      if (!Params.$at(ParamIdx.$deref()).isPackExpansion()) {
        // The simple case: deduce template arguments by matching Pi and Ai.
        
        // Check whether we have enough arguments.
        if (!hasTemplateArgumentForDeduction(Args, ArgIdx, NumArgsRef)) {
          return NumberOfArgumentsMustMatch ? Sema.TemplateDeductionResult.TDK_TooFewArguments : Sema.TemplateDeductionResult.TDK_Success;
        }
        if (Args.$at(ArgIdx.$deref()).isPackExpansion()) {
          // FIXME: We follow the logic of C++0x [temp.deduct.type]p22 here,
          // but applied to pack expansions that are template arguments.
          return Sema.TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
        }
        {
          
          // Perform deduction for this Pi/Ai pair.
          Sema.TemplateDeductionResult Result = DeduceTemplateArguments1(S, TemplateParams, 
              Params.$at(ParamIdx.$deref()), new TemplateArgument(Args.$at(ArgIdx.$deref())), 
              Info, Deduced);
          if ((Result.getValue() != 0)) {
            return Result;
          }
        }
        
        // Move to the next argument.
        ArgIdx.$set$preInc();
        continue;
      }
      
      // The parameter is a pack expansion.
      
      // C++0x [temp.deduct.type]p9:
      //   If Pi is a pack expansion, then the pattern of Pi is compared with
      //   each remaining argument in the template argument list of A. Each
      //   comparison deduces template arguments for subsequent positions in the
      //   template parameter packs expanded by Pi.
      TemplateArgument Pattern = Params.$at(ParamIdx.$deref()).getPackExpansionPattern();
      
      // FIXME: If there are no remaining arguments, we can bail out early
      // and set any deduced parameter packs to an empty argument pack.
      // The latter part of this is a (minor) correctness issue.
      
      // Prepare to deduce the packs within the pattern.
      PackScope/*J*/= new PackDeductionScope(S, TemplateParams, Deduced, Info, new TemplateArgument(Pattern));
      
      // Keep track of the deduced template arguments for each parameter pack
      // expanded by this pack expansion (the outer index) and for each
      // template argument (the inner SmallVectors).
      boolean HasAnyArguments = false;
      for (; hasTemplateArgumentForDeduction(Args, ArgIdx, NumArgsRef); ArgIdx.$set$preInc()) {
        HasAnyArguments = true;
        {
          
          // Deduce template arguments from the pattern.
          Sema.TemplateDeductionResult Result = DeduceTemplateArguments1(S, TemplateParams, Pattern, new TemplateArgument(Args.$at(ArgIdx.$deref())), 
              Info, Deduced);
          if ((Result.getValue() != 0)) {
            return Result;
          }
        }
        
        PackScope.nextPackElement();
      }
      {
        
        // Build argument packs for each of the parameter packs expanded by this
        // pack expansion.
        Sema.TemplateDeductionResult Result = PackScope.finish(HasAnyArguments);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
    } finally {
      if (PackScope != null) { PackScope.$destroy(); }
    }
  }
  
  return Sema.TemplateDeductionResult.TDK_Success;
}


/// \brief If the given expression is of a form that permits the deduction
/// of a non-type template parameter, return the declaration of that
/// non-type template parameter.
//<editor-fold defaultstate="collapsed" desc="getDeducedParameterFromExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 116,
 FQN="getDeducedParameterFromExpr", NM="_ZL27getDeducedParameterFromExprPN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL27getDeducedParameterFromExprPN5clang4ExprE")
//</editor-fold>
public static NonTypeTemplateParmDecl /*P*/ getDeducedParameterFromExpr(Expr /*P*/ E) {
  // If we are within an alias template, the expression may have undergone
  // any number of parameter substitutions already.
  while (true) {
    {
      ImplicitCastExpr /*P*/ IC = dyn_cast_ImplicitCastExpr(E);
      if ((IC != null)) {
        E = IC.getSubExpr();
      } else {
        SubstNonTypeTemplateParmExpr /*P*/ Subst = dyn_cast_SubstNonTypeTemplateParmExpr(E);
        if ((Subst != null)) {
          E = Subst.getReplacement();
        } else {
          break;
        }
      }
    }
  }
  {
    
    DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
    if ((DRE != null)) {
      return dyn_cast_NonTypeTemplateParmDecl(DRE.getDecl());
    }
  }
  
  return null;
}


/// \brief Determine whether two declaration pointers refer to the same
/// declaration.
//<editor-fold defaultstate="collapsed" desc="isSameDeclaration">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 137,
 FQN="isSameDeclaration", NM="_ZL17isSameDeclarationPN5clang4DeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL17isSameDeclarationPN5clang4DeclES1_")
//</editor-fold>
public static boolean isSameDeclaration(Decl /*P*/ X, Decl /*P*/ Y) {
  {
    NamedDecl /*P*/ NX = dyn_cast_NamedDecl(X);
    if ((NX != null)) {
      X = NX.getUnderlyingDecl();
    }
  }
  {
    NamedDecl /*P*/ NY = dyn_cast_NamedDecl(Y);
    if ((NY != null)) {
      Y = NY.getUnderlyingDecl();
    }
  }
  
  return X.getCanonicalDecl() == Y.getCanonicalDecl();
}


/// \brief Verify that the given, deduced template arguments are compatible.
///
/// \returns The deduced template argument, or a NULL template argument if
/// the deduced template arguments were incompatible.
//<editor-fold defaultstate="collapsed" desc="checkDeducedTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 150,
 FQN="checkDeducedTemplateArguments", NM="_ZL29checkDeducedTemplateArgumentsRN5clang10ASTContextERKNS_23DeducedTemplateArgumentES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL29checkDeducedTemplateArgumentsRN5clang10ASTContextERKNS_23DeducedTemplateArgumentES4_")
//</editor-fold>
public static DeducedTemplateArgument checkDeducedTemplateArguments(final ASTContext /*&*/ Context, 
                             final /*const*/ DeducedTemplateArgument /*&*/ X, 
                             final /*const*/ DeducedTemplateArgument /*&*/ Y) {
  // We have no deduction for one or both of the arguments; they're compatible.
  if (X.isNull()) {
    return new DeducedTemplateArgument(Y);
  }
  if (Y.isNull()) {
    return new DeducedTemplateArgument(X);
  }
  switch (X.getKind()) {
   case Null:
    throw new llvm_unreachable("Non-deduced template arguments handled above");
   case Type:
    // If two template type arguments have the same type, they're compatible.
    if (Y.getKind() == TemplateArgument.ArgKind.Type
       && Context.hasSameType(X.getAsType(), Y.getAsType())) {
      return new DeducedTemplateArgument(X);
    }
    
    return new DeducedTemplateArgument();
   case Integral:
    // If we deduced a constant in one case and either a dependent expression or
    // declaration in another case, keep the integral constant.
    // If both are integral constants with the same value, keep that value.
    if (Y.getKind() == TemplateArgument.ArgKind.Expression
       || Y.getKind() == TemplateArgument.ArgKind.Declaration
       || (Y.getKind() == TemplateArgument.ArgKind.Integral
       && hasSameExtendedValue(X.getAsIntegral(), Y.getAsIntegral()))) {
      return new DeducedTemplateArgument(X, 
          X.wasDeducedFromArrayBound()
             && Y.wasDeducedFromArrayBound());
    }
    
    // All other combinations are incompatible.
    return new DeducedTemplateArgument();
   case Template:
    if (Y.getKind() == TemplateArgument.ArgKind.Template
       && Context.hasSameTemplateName(X.getAsTemplate(), Y.getAsTemplate())) {
      return new DeducedTemplateArgument(X);
    }
    
    // All other combinations are incompatible.
    return new DeducedTemplateArgument();
   case TemplateExpansion:
    if (Y.getKind() == TemplateArgument.ArgKind.TemplateExpansion
       && Context.hasSameTemplateName(X.getAsTemplateOrTemplatePattern(), 
        Y.getAsTemplateOrTemplatePattern())) {
      return new DeducedTemplateArgument(X);
    }
    
    // All other combinations are incompatible.
    return new DeducedTemplateArgument();
   case Expression:
    // If we deduced a dependent expression in one case and either an integral
    // constant or a declaration in another case, keep the integral constant
    // or declaration.
    if (Y.getKind() == TemplateArgument.ArgKind.Integral
       || Y.getKind() == TemplateArgument.ArgKind.Declaration) {
      return new DeducedTemplateArgument(Y, X.wasDeducedFromArrayBound()
             && Y.wasDeducedFromArrayBound());
    }
    if (Y.getKind() == TemplateArgument.ArgKind.Expression) {
      FoldingSetNodeID ID1 = null;
      FoldingSetNodeID ID2 = null;
      try {
        // Compare the expressions for equality
        ID1/*J*/= new FoldingSetNodeID(); ID2/*J*/= new FoldingSetNodeID();
        X.getAsExpr().Profile(ID1, Context, true);
        Y.getAsExpr().Profile(ID2, Context, true);
        if (ID1.$eq(ID2)) {
          return new DeducedTemplateArgument(X);
        }
      } finally {
        if (ID2 != null) { ID2.$destroy(); }
        if (ID1 != null) { ID1.$destroy(); }
      }
    }
    
    // All other combinations are incompatible.
    return new DeducedTemplateArgument();
   case Declaration:
    // If we deduced a declaration and a dependent expression, keep the
    // declaration.
    if (Y.getKind() == TemplateArgument.ArgKind.Expression) {
      return new DeducedTemplateArgument(X);
    }
    
    // If we deduced a declaration and an integral constant, keep the
    // integral constant.
    if (Y.getKind() == TemplateArgument.ArgKind.Integral) {
      return new DeducedTemplateArgument(Y);
    }
    
    // If we deduced two declarations, make sure they they refer to the
    // same declaration.
    if (Y.getKind() == TemplateArgument.ArgKind.Declaration
       && isSameDeclaration(X.getAsDecl(), Y.getAsDecl())) {
      return new DeducedTemplateArgument(X);
    }
    
    // All other combinations are incompatible.
    return new DeducedTemplateArgument();
   case NullPtr:
    // If we deduced a null pointer and a dependent expression, keep the
    // null pointer.
    if (Y.getKind() == TemplateArgument.ArgKind.Expression) {
      return new DeducedTemplateArgument(X);
    }
    
    // If we deduced a null pointer and an integral constant, keep the
    // integral constant.
    if (Y.getKind() == TemplateArgument.ArgKind.Integral) {
      return new DeducedTemplateArgument(Y);
    }
    
    // If we deduced two null pointers, make sure they have the same type.
    if (Y.getKind() == TemplateArgument.ArgKind.NullPtr
       && Context.hasSameType(X.getNullPtrType(), Y.getNullPtrType())) {
      return new DeducedTemplateArgument(X);
    }
    
    // All other combinations are incompatible.
    return new DeducedTemplateArgument();
   case Pack:
    if (Y.getKind() != TemplateArgument.ArgKind.Pack
       || X.pack_size() != Y.pack_size()) {
      return new DeducedTemplateArgument();
    }
    
    for (type$ptr<TemplateArgument>/*pack_iterator*/ XA = $tryClone(X.pack_begin()), 
        /*P*/ XAEnd = $tryClone(X.pack_end()), 
        /*P*/ YA = $tryClone(Y.pack_begin());
         $noteq_ptr(XA, XAEnd); XA.$preInc() , YA.$preInc()) {
      // FIXME: Do we need to merge the results together here?
      if (checkDeducedTemplateArguments(Context, 
          new DeducedTemplateArgument(XA.$star(), X.wasDeducedFromArrayBound()), 
          new DeducedTemplateArgument(YA.$star(), Y.wasDeducedFromArrayBound())).
          isNull()) {
        return new DeducedTemplateArgument();
      }
    }
    
    return new DeducedTemplateArgument(X);
  }
  throw new llvm_unreachable("Invalid TemplateArgument Kind!");
}


/// \brief Deduce the value of the given non-type template parameter
/// from the given constant.
//<editor-fold defaultstate="collapsed" desc="DeduceNonTypeTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 289,
 FQN="DeduceNonTypeTemplateArgument", NM="_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclERKN4llvm6APSIntENS_8QualTypeEbRNS_4sema21TemplateDeductionInfoERNS4_15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclERKN4llvm6APSIntENS_8QualTypeEbRNS_4sema21TemplateDeductionInfoERNS4_15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceNonTypeTemplateArgument(final Sema /*&*/ S, NonTypeTemplateParmDecl /*P*/ NTTP, final /*const*/ APSInt /*&*/ Value, 
                             QualType ValueType, boolean DeducedFromArrayBound, final TemplateDeductionInfo /*&*/ Info, 
                             final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  assert (NTTP.getDepth() == 0) : "Cannot deduce non-type template argument with depth > 0";
  
  DeducedTemplateArgument NewDeduced/*J*/= new DeducedTemplateArgument(S.Context, Value, new QualType(ValueType), 
      DeducedFromArrayBound);
  DeducedTemplateArgument Result = checkDeducedTemplateArguments(S.Context, 
      Deduced.$at(NTTP.getIndex()), 
      NewDeduced);
  if (Result.isNull()) {
    Info.Param.$assign_T1$C$R(NonTypeTemplateParmDecl /*P*/.class, NTTP);
    Info.FirstArg.$assign(Deduced.$at(NTTP.getIndex()));
    Info.SecondArg.$assign(NewDeduced);
    return Sema.TemplateDeductionResult.TDK_Inconsistent;
  }
  
  Deduced.$at(NTTP.getIndex()).$assign(Result);
  return Sema.TemplateDeductionResult.TDK_Success;
}


/// \brief Deduce the value of the given non-type template parameter
/// from the given type- or value-dependent expression.
///
/// \returns true if deduction succeeded, false otherwise.
//<editor-fold defaultstate="collapsed" desc="DeduceNonTypeTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 316,
 FQN="DeduceNonTypeTemplateArgument", NM="_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclEPNS_4ExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclEPNS_4ExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceNonTypeTemplateArgument1(final Sema /*&*/ S, 
                              NonTypeTemplateParmDecl /*P*/ NTTP, 
                              Expr /*P*/ Value, 
                              final TemplateDeductionInfo /*&*/ Info, 
                              final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  assert (NTTP.getDepth() == 0) : "Cannot deduce non-type template argument with depth > 0";
  assert ((Value.isTypeDependent() || Value.isValueDependent())) : "Expression template argument must be type- or value-dependent.";
  
  DeducedTemplateArgument NewDeduced/*J*/= new DeducedTemplateArgument(new TemplateArgument(Value));
  DeducedTemplateArgument Result = checkDeducedTemplateArguments(S.Context, 
      Deduced.$at(NTTP.getIndex()), 
      NewDeduced);
  if (Result.isNull()) {
    Info.Param.$assign_T1$C$R(NonTypeTemplateParmDecl /*P*/.class, NTTP);
    Info.FirstArg.$assign(Deduced.$at(NTTP.getIndex()));
    Info.SecondArg.$assign(NewDeduced);
    return Sema.TemplateDeductionResult.TDK_Inconsistent;
  }
  
  Deduced.$at(NTTP.getIndex()).$assign(Result);
  return Sema.TemplateDeductionResult.TDK_Success;
}


/// \brief Deduce the value of the given non-type template parameter
/// from the given declaration.
///
/// \returns true if deduction succeeded, false otherwise.
//<editor-fold defaultstate="collapsed" desc="DeduceNonTypeTemplateArgument">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 347,
 FQN="DeduceNonTypeTemplateArgument", NM="_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclEPNS_9ValueDeclERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL29DeduceNonTypeTemplateArgumentRN5clang4SemaEPNS_23NonTypeTemplateParmDeclEPNS_9ValueDeclERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceNonTypeTemplateArgument2(final Sema /*&*/ S, 
                              NonTypeTemplateParmDecl /*P*/ NTTP, 
                              ValueDecl /*P*/ D, 
                              final TemplateDeductionInfo /*&*/ Info, 
                              final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  assert (NTTP.getDepth() == 0) : "Cannot deduce non-type template argument with depth > 0";
  
  D = (D != null) ? cast_ValueDecl(D.getCanonicalDecl()) : null;
  TemplateArgument New/*J*/= new TemplateArgument(D, NTTP.getType());
  DeducedTemplateArgument NewDeduced/*J*/= new DeducedTemplateArgument(New);
  DeducedTemplateArgument Result = checkDeducedTemplateArguments(S.Context, 
      Deduced.$at(NTTP.getIndex()), 
      NewDeduced);
  if (Result.isNull()) {
    Info.Param.$assign_T1$C$R(NonTypeTemplateParmDecl /*P*/.class, NTTP);
    Info.FirstArg.$assign(Deduced.$at(NTTP.getIndex()));
    Info.SecondArg.$assign(NewDeduced);
    return Sema.TemplateDeductionResult.TDK_Inconsistent;
  }
  
  Deduced.$at(NTTP.getIndex()).$assign(Result);
  return Sema.TemplateDeductionResult.TDK_Success;
}

//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 373,
 FQN="DeduceTemplateArguments", NM="_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListENS_12TemplateNameES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListENS_12TemplateNameES4_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArguments(final Sema /*&*/ S, 
                       TemplateParameterList /*P*/ TemplateParams, 
                       TemplateName Param, 
                       TemplateName Arg, 
                       final TemplateDeductionInfo /*&*/ Info, 
                       final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  TemplateDecl /*P*/ ParamDecl = Param.getAsTemplateDecl();
  if (!(ParamDecl != null)) {
    // The parameter type is dependent and is not a template template parameter,
    // so there is nothing that we can deduce.
    return Sema.TemplateDeductionResult.TDK_Success;
  }
  {
    
    TemplateTemplateParmDecl /*P*/ TempParam = dyn_cast_TemplateTemplateParmDecl(ParamDecl);
    if ((TempParam != null)) {
      DeducedTemplateArgument NewDeduced/*J*/= new DeducedTemplateArgument(new TemplateArgument(S.Context.getCanonicalTemplateName(new TemplateName(Arg))));
      DeducedTemplateArgument Result = checkDeducedTemplateArguments(S.Context, 
          Deduced.$at(TempParam.getIndex()), 
          NewDeduced);
      if (Result.isNull()) {
        Info.Param.$assign_T2$C$R(TemplateTemplateParmDecl /*P*/.class, TempParam);
        Info.FirstArg.$assign(Deduced.$at(TempParam.getIndex()));
        Info.SecondArg.$assign(NewDeduced);
        return Sema.TemplateDeductionResult.TDK_Inconsistent;
      }
      
      Deduced.$at(TempParam.getIndex()).$assign(Result);
      return Sema.TemplateDeductionResult.TDK_Success;
    }
  }
  
  // Verify that the two template names are equivalent.
  if (S.Context.hasSameTemplateName(new TemplateName(Param), new TemplateName(Arg))) {
    return Sema.TemplateDeductionResult.TDK_Success;
  }
  
  // Mismatch of non-dependent template parameter to argument.
  Info.FirstArg.$assignMove(new TemplateArgument(new TemplateName(Param)));
  Info.SecondArg.$assignMove(new TemplateArgument(new TemplateName(Arg)));
  return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
}


/// \brief Deduce the template arguments by comparing the template parameter
/// type (which is a template-id) with the template argument type.
///
/// \param S the Sema
///
/// \param TemplateParams the template parameters that we are deducing
///
/// \param Param the parameter type
///
/// \param Arg the argument type
///
/// \param Info information about the template argument deduction itself
///
/// \param Deduced the deduced template arguments
///
/// \returns the result of template argument deduction so far. Note that a
/// "success" result means that template argument deduction has not yet failed,
/// but it may still fail, later, for other reasons.
//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 432,
 FQN="DeduceTemplateArguments", NM="_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_26TemplateSpecializationTypeENS_8QualTypeERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_26TemplateSpecializationTypeENS_8QualTypeERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArguments2(final Sema /*&*/ S, 
                        TemplateParameterList /*P*/ TemplateParams, 
                        /*const*/ TemplateSpecializationType /*P*/ Param, 
                        QualType Arg, 
                        final TemplateDeductionInfo /*&*/ Info, 
                        final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  assert (Arg.isCanonical()) : "Argument type must be canonical";
  {
    
    // Check whether the template argument is a dependent template-id.
    /*const*/ TemplateSpecializationType /*P*/ SpecArg = dyn_cast_TemplateSpecializationType(Arg);
    if ((SpecArg != null)) {
      {
        // Perform template argument deduction for the template name.
        Sema.TemplateDeductionResult Result = DeduceTemplateArguments(S, TemplateParams, 
            Param.getTemplateName(), 
            SpecArg.getTemplateName(), 
            Info, Deduced);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
      
      // Perform template argument deduction on each template
      // argument. Ignore any missing/extra arguments, since they could be
      // filled in by default arguments.
      return DeduceTemplateArguments(S, TemplateParams, Param.getArgs(), 
          Param.getNumArgs(), SpecArg.getArgs(), 
          SpecArg.getNumArgs(), Info, Deduced, 
          /*NumberOfArgumentsMustMatch=*/ false);
    }
  }
  
  // If the argument type is a class template specialization, we
  // perform template argument deduction using its template
  // arguments.
  /*const*/ RecordType /*P*/ RecordArg = dyn_cast_RecordType(Arg);
  if (!(RecordArg != null)) {
    Info.FirstArg.$assignMove(new TemplateArgument(new QualType(Param, 0)));
    Info.SecondArg.$assignMove(new TemplateArgument(new QualType(Arg)));
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
  }
  
  ClassTemplateSpecializationDecl /*P*/ SpecArg = dyn_cast_ClassTemplateSpecializationDecl(RecordArg.getDecl());
  if (!(SpecArg != null)) {
    Info.FirstArg.$assignMove(new TemplateArgument(new QualType(Param, 0)));
    Info.SecondArg.$assignMove(new TemplateArgument(new QualType(Arg)));
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
  }
  {
    
    // Perform template argument deduction for the template name.
    Sema.TemplateDeductionResult Result = DeduceTemplateArguments(S, 
        TemplateParams, 
        Param.getTemplateName(), 
        new TemplateName(SpecArg.getSpecializedTemplate()), 
        Info, Deduced);
    if ((Result.getValue() != 0)) {
      return Result;
    }
  }
  
  // Perform template argument deduction for the template arguments.
  return DeduceTemplateArguments(S, TemplateParams, Param.getArgs(), Param.getNumArgs(), 
      SpecArg.getTemplateArgs().data(), SpecArg.getTemplateArgs().size(), 
      Info, Deduced, /*NumberOfArgumentsMustMatch=*/ true);
}


/// \brief Determines whether the given type is an opaque type that
/// might be more qualified when instantiated.
//<editor-fold defaultstate="collapsed" desc="IsPossiblyOpaquelyQualifiedType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 498,
 FQN="IsPossiblyOpaquelyQualifiedType", NM="_ZL31IsPossiblyOpaquelyQualifiedTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL31IsPossiblyOpaquelyQualifiedTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean IsPossiblyOpaquelyQualifiedType(QualType T) {
  switch (T.$arrow().getTypeClass()) {
   case TypeOfExpr:
   case TypeOf:
   case DependentName:
   case Decltype:
   case UnresolvedUsing:
   case TemplateTypeParm:
    return true;
   case ConstantArray:
   case IncompleteArray:
   case VariableArray:
   case DependentSizedArray:
    return IsPossiblyOpaquelyQualifiedType(cast_ArrayType(T).getElementType());
   default:
    return false;
  }
}


/// \brief Retrieve the depth and index of a template parameter.
//<editor-fold defaultstate="collapsed" desc="getDepthAndIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 521,
 FQN="getDepthAndIndex", NM="_ZL16getDepthAndIndexPN5clang9NamedDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL16getDepthAndIndexPN5clang9NamedDeclE")
//</editor-fold>
public static std.pairUIntUInt getDepthAndIndex(NamedDecl /*P*/ ND) {
  {
    TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(ND);
    if ((TTP != null)) {
      return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
    }
  }
  {
    
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(ND);
    if ((NTTP != null)) {
      return std.make_pair_uint_uint(NTTP.getDepth(), NTTP.getIndex());
    }
  }
  
  TemplateTemplateParmDecl /*P*/ TTP = cast_TemplateTemplateParmDecl(ND);
  return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
}


/// \brief Retrieve the depth and index of an unexpanded parameter pack.
//<editor-fold defaultstate="collapsed" desc="getDepthAndIndex">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 534,
 FQN="getDepthAndIndex", NM="_ZL16getDepthAndIndexSt4pairIN4llvm12PointerUnionIPKN5clang20TemplateTypeParmTypeEPNS2_9NamedDeclEEENS2_14SourceLocationEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL16getDepthAndIndexSt4pairIN4llvm12PointerUnionIPKN5clang20TemplateTypeParmTypeEPNS2_9NamedDeclEEENS2_14SourceLocationEE")
//</editor-fold>
public static std.pairUIntUInt getDepthAndIndex(std.pair<PointerUnion</*const*/ TemplateTypeParmType /*P*/ , NamedDecl /*P*/ >, SourceLocation> UPP) {
  {
    /*const*/ TemplateTypeParmType /*P*/ TTP = UPP.first.dyn_cast(/*const*/ TemplateTypeParmType /*P*/.class);
    if ((TTP != null)) {
      return std.make_pair_uint_uint(TTP.getDepth(), TTP.getIndex());
    }
  }
  
  return getDepthAndIndex(UPP.first.get(NamedDecl /*P*/.class));
}


/// \brief Helper function to build a TemplateParameter when we don't
/// know its type statically.
//<editor-fold defaultstate="collapsed" desc="makeTemplateParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 545,
 FQN="makeTemplateParameter", NM="_ZL21makeTemplateParameterPN5clang4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL21makeTemplateParameterPN5clang4DeclE")
//</editor-fold>
public static PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ > makeTemplateParameter(Decl /*P*/ D) {
  {
    TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(D);
    if ((TTP != null)) {
      return new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(JD$T.INSTANCE, TemplateTypeParmDecl /*P*/.class, TTP);
    }
  }
  {
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(D);
    if ((NTTP != null)) {
      return new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(JD$T1.INSTANCE, NonTypeTemplateParmDecl /*P*/.class, NTTP);
    }
  }
  
  return new PointerUnion3<TemplateTypeParmDecl /*P*/ , NonTypeTemplateParmDecl /*P*/ , TemplateTemplateParmDecl /*P*/ >(JD$T2.INSTANCE, TemplateTemplateParmDecl /*P*/.class, cast_TemplateTemplateParmDecl(D));
}

// namespace

/// \brief Deduce the template arguments by comparing the list of parameter
/// types to the list of argument types, as in the parameter-type-lists of
/// function types (C++ [temp.deduct.type]p10).
///
/// \param S The semantic analysis object within which we are deducing
///
/// \param TemplateParams The template parameters that we are deducing
///
/// \param Params The list of parameter types
///
/// \param NumParams The number of types in \c Params
///
/// \param Args The list of argument types
///
/// \param NumArgs The number of types in \c Args
///
/// \param Info information about the template argument deduction itself
///
/// \param Deduced the deduced template arguments
///
/// \param TDF bitwise OR of the TemplateDeductionFlags bits that describe
/// how template argument deduction is performed.
///
/// \param PartialOrdering If true, we are performing template argument
/// deduction for during partial ordering for a call
/// (C++0x [temp.deduct.partial]).
///
/// \returns the result of template argument deduction so far. Note that a
/// "success" result means that template argument deduction has not yet failed,
/// but it may still fail, later, for other reasons.
//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArguments">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 762,
 FQN="DeduceTemplateArguments", NM="_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_8QualTypeEjS6_jRNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListEPKNS_8QualTypeEjS6_jRNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjb")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArguments(final Sema /*&*/ S, 
                       TemplateParameterList /*P*/ TemplateParams, 
                       /*const*/ type$ptr<QualType /*P*/> Params, /*uint*/int NumParams, 
                       /*const*/ type$ptr<QualType /*P*/> Args, /*uint*/int NumArgs, 
                       final TemplateDeductionInfo /*&*/ Info, 
                       final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                       /*uint*/int TDF) {
  return DeduceTemplateArguments(S, 
                       TemplateParams, 
                       Params, NumParams, 
                       Args, NumArgs, 
                       Info, 
                       Deduced, 
                       TDF, 
                       false);
}
public static Sema.TemplateDeductionResult DeduceTemplateArguments(final Sema /*&*/ S, 
                       TemplateParameterList /*P*/ TemplateParams, 
                       /*const*/ type$ptr<QualType /*P*/> Params, /*uint*/int NumParams, 
                       /*const*/ type$ptr<QualType /*P*/> Args, /*uint*/int NumArgs, 
                       final TemplateDeductionInfo /*&*/ Info, 
                       final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                       /*uint*/int TDF, 
                       boolean PartialOrdering/*= false*/) {
  // Fast-path check to see if we have too many/too few arguments.
  if (NumParams != NumArgs
     && !((NumParams != 0) && isa_PackExpansionType(Params.$at(NumParams - 1)))
     && !((NumArgs != 0) && isa_PackExpansionType(Args.$at(NumArgs - 1)))) {
    return Sema.TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
  }
  
  // C++0x [temp.deduct.type]p10:
  //   Similarly, if P has a form that contains (T), then each parameter type
  //   Pi of the respective parameter-type- list of P is compared with the
  //   corresponding parameter type Ai of the corresponding parameter-type-list
  //   of A. [...]
  /*uint*/int ArgIdx = 0, ParamIdx = 0;
  for (; ParamIdx != NumParams; ++ParamIdx) {
    PackDeductionScope PackScope = null;
    try {
      // Check argument types.
      /*const*/ PackExpansionType /*P*/ Expansion = dyn_cast_PackExpansionType(Params.$at(ParamIdx));
      if (!(Expansion != null)) {
        // Simple case: compare the parameter and argument types at this point.
        
        // Make sure we have an argument.
        if ($greatereq_uint(ArgIdx, NumArgs)) {
          return Sema.TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
        }
        if (isa_PackExpansionType(Args.$at(ArgIdx))) {
          // C++0x [temp.deduct.type]p22:
          //   If the original function parameter associated with A is a function
          //   parameter pack and the function parameter associated with P is not
          //   a function parameter pack, then template argument deduction fails.
          return Sema.TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
        }
        {
          
          Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
              new QualType(Params.$at(ParamIdx)), new QualType(Args.$at(ArgIdx)), 
              Info, Deduced, TDF, 
              PartialOrdering);
          if ((Result.getValue() != 0)) {
            return Result;
          }
        }
        
        ++ArgIdx;
        continue;
      }
      
      // C++0x [temp.deduct.type]p5:
      //   The non-deduced contexts are:
      //     - A function parameter pack that does not occur at the end of the
      //       parameter-declaration-clause.
      if ($less_uint(ParamIdx + 1, NumParams)) {
        return Sema.TemplateDeductionResult.TDK_Success;
      }
      
      // C++0x [temp.deduct.type]p10:
      //   If the parameter-declaration corresponding to Pi is a function
      //   parameter pack, then the type of its declarator- id is compared with
      //   each remaining parameter type in the parameter-type-list of A. Each
      //   comparison deduces template arguments for subsequent positions in the
      //   template parameter packs expanded by the function parameter pack.
      QualType Pattern = Expansion.getPattern();
      PackScope/*J*/= new PackDeductionScope(S, TemplateParams, Deduced, Info, new TemplateArgument(new QualType(Pattern)));
      
      boolean HasAnyArguments = false;
      for (; $less_uint(ArgIdx, NumArgs); ++ArgIdx) {
        HasAnyArguments = true;
        {
          
          // Deduce template arguments from the pattern.
          Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, new QualType(Pattern), 
              new QualType(Args.$at(ArgIdx)), Info, Deduced, 
              TDF, PartialOrdering);
          if ((Result.getValue() != 0)) {
            return Result;
          }
        }
        
        PackScope.nextPackElement();
      }
      {
        
        // Build argument packs for each of the parameter packs expanded by this
        // pack expansion.
        Sema.TemplateDeductionResult Result = PackScope.finish(HasAnyArguments);
        if ((Result.getValue() != 0)) {
          return Result;
        }
      }
    } finally {
      if (PackScope != null) { PackScope.$destroy(); }
    }
  }
  
  // Make sure we don't have any extra arguments.
  if ($less_uint(ArgIdx, NumArgs)) {
    return Sema.TemplateDeductionResult.TDK_MiscellaneousDeductionFailure;
  }
  
  return Sema.TemplateDeductionResult.TDK_Success;
}


/// \brief Determine whether the parameter has qualifiers that are either
/// inconsistent with or a superset of the argument's qualifiers.
//<editor-fold defaultstate="collapsed" desc="hasInconsistentOrSupersetQualifiersOf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 859,
 FQN="hasInconsistentOrSupersetQualifiersOf", NM="_ZL37hasInconsistentOrSupersetQualifiersOfN5clang8QualTypeES0_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL37hasInconsistentOrSupersetQualifiersOfN5clang8QualTypeES0_")
//</editor-fold>
public static boolean hasInconsistentOrSupersetQualifiersOf(QualType ParamType, 
                                     QualType ArgType) {
  Qualifiers ParamQs = ParamType.getQualifiers();
  Qualifiers ArgQs = ArgType.getQualifiers();
  if (ParamQs.$eq(/*NO_COPY*/ArgQs)) {
    return false;
  }
  
  // Mismatched (but not missing) Objective-C GC attributes.
  if (ParamQs.getObjCGCAttr() != ArgQs.getObjCGCAttr()
     && ParamQs.hasObjCGCAttr()) {
    return true;
  }
  
  // Mismatched (but not missing) address spaces.
  if (ParamQs.getAddressSpace() != ArgQs.getAddressSpace()
     && ParamQs.hasAddressSpace()) {
    return true;
  }
  
  // Mismatched (but not missing) Objective-C lifetime qualifiers.
  if (ParamQs.getObjCLifetime() != ArgQs.getObjCLifetime()
     && ParamQs.hasObjCLifetime()) {
    return true;
  }
  
  // CVR qualifier superset.
  return (ParamQs.getCVRQualifiers() != ArgQs.getCVRQualifiers())
     && ((ParamQs.getCVRQualifiers() | ArgQs.getCVRQualifiers())
     == ParamQs.getCVRQualifiers());
}


/// \brief Determine whether there is a template argument to be used for
/// deduction.
///
/// This routine "expands" argument packs in-place, overriding its input
/// parameters so that \c Args[ArgIdx] will be the available template argument.
///
/// \returns true if there is another template argument (which will be at
/// \c Args[ArgIdx]), false otherwise.
//<editor-fold defaultstate="collapsed" desc="hasTemplateArgumentForDeduction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 1791,
 FQN="hasTemplateArgumentForDeduction", NM="_ZL31hasTemplateArgumentForDeductionRPKN5clang16TemplateArgumentERjS4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL31hasTemplateArgumentForDeductionRPKN5clang16TemplateArgumentERjS4_")
//</editor-fold>
public static boolean hasTemplateArgumentForDeduction(final type$ptr</*const*/ TemplateArgument /*P*/ /*&*/> Args, 
                               final uint$ref/*uint &*/ ArgIdx, 
                               final uint$ref/*uint &*/ NumArgs) {
  if (ArgIdx.$deref() == NumArgs.$deref()) {
    return false;
  }
  
  final /*const*/ TemplateArgument /*&*/ Arg = Args.$at(ArgIdx.$deref());
  if (Arg.getKind() != TemplateArgument.ArgKind.Pack) {
    return true;
  }
  assert (ArgIdx.$deref() == NumArgs.$deref() - 1) : "Pack not at the end of argument list?";
  Args.$assign(Arg.pack_begin());
  NumArgs.$set(Arg.pack_size());
  ArgIdx.$set(0);
  return $less_uint(ArgIdx.$deref(), NumArgs.$deref());
}


/// \brief Determine whether the given set of template arguments has a pack
/// expansion that is not the last template argument.
//<editor-fold defaultstate="collapsed" desc="hasPackExpansionBeforeEnd">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 1810,
 FQN="hasPackExpansionBeforeEnd", NM="_ZL25hasPackExpansionBeforeEndPKN5clang16TemplateArgumentEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL25hasPackExpansionBeforeEndPKN5clang16TemplateArgumentEj")
//</editor-fold>
public static boolean hasPackExpansionBeforeEnd(/*const*/ type$ptr<TemplateArgument /*P*/> Args, 
                         /*uint*/int NumArgs) {
  /*uint*/int ArgIdx = 0;
  while ($less_uint(ArgIdx, NumArgs)) {
    final /*const*/ TemplateArgument /*&*/ Arg = Args.$at(ArgIdx);
    
    // Unwrap argument packs.
    if (Args.$at(ArgIdx).getKind() == TemplateArgument.ArgKind.Pack) {
      Args = Arg.pack_begin();
      NumArgs = Arg.pack_size();
      ArgIdx = 0;
      continue;
    }
    
    ++ArgIdx;
    if (ArgIdx == NumArgs) {
      return false;
    }
    if (Arg.isPackExpansion()) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 1923,
 FQN="DeduceTemplateArguments", NM="_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListERKNS_20TemplateArgumentListES6_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL23DeduceTemplateArgumentsRN5clang4SemaEPNS_21TemplateParameterListERKNS_20TemplateArgumentListES6_RNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEE")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArguments(final Sema /*&*/ S, 
                       TemplateParameterList /*P*/ TemplateParams, 
                       final /*const*/ TemplateArgumentList /*&*/ ParamList, 
                       final /*const*/ TemplateArgumentList /*&*/ ArgList, 
                       final TemplateDeductionInfo /*&*/ Info, 
                       final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced) {
  return DeduceTemplateArguments(S, TemplateParams, 
      ParamList.data(), ParamList.size(), 
      ArgList.data(), ArgList.size(), 
      Info, Deduced, false);
}


/// \brief Determine whether two template arguments are the same.
//<editor-fold defaultstate="collapsed" desc="isSameTemplateArg">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 1937,
 FQN="isSameTemplateArg", NM="_ZL17isSameTemplateArgRN5clang10ASTContextERKNS_16TemplateArgumentES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL17isSameTemplateArgRN5clang10ASTContextERKNS_16TemplateArgumentES4_")
//</editor-fold>
public static boolean isSameTemplateArg(final ASTContext /*&*/ Context, 
                 final /*const*/ TemplateArgument /*&*/ X, 
                 final /*const*/ TemplateArgument /*&*/ Y) {
  if (X.getKind() != Y.getKind()) {
    return false;
  }
  switch (X.getKind()) {
   case Null:
    throw new llvm_unreachable("Comparing NULL template argument");
   case Type:
    return $eq_CanQual$T_CanQual$U(Context.getCanonicalType(X.getAsType()), 
        Context.getCanonicalType(Y.getAsType()));
   case Declaration:
    return isSameDeclaration(X.getAsDecl(), Y.getAsDecl());
   case NullPtr:
    return Context.hasSameType(X.getNullPtrType(), Y.getNullPtrType());
   case Template:
   case TemplateExpansion:
    return $eq_ptr(Context.getCanonicalTemplateName(X.getAsTemplateOrTemplatePattern()).getAsVoidPointer(), Context.getCanonicalTemplateName(Y.getAsTemplateOrTemplatePattern()).getAsVoidPointer());
   case Integral:
    return X.getAsIntegral().$eq(Y.getAsIntegral());
   case Expression:
    {
      FoldingSetNodeID XID = null;
      FoldingSetNodeID YID = null;
      try {
        XID/*J*/= new FoldingSetNodeID(); YID/*J*/= new FoldingSetNodeID();
        X.getAsExpr().Profile(XID, Context, true);
        Y.getAsExpr().Profile(YID, Context, true);
        return XID.$eq(YID);
      } finally {
        if (YID != null) { YID.$destroy(); }
        if (XID != null) { XID.$destroy(); }
      }
    }
   case Pack:
    if (X.pack_size() != Y.pack_size()) {
      return false;
    }
    
    for (type$ptr<TemplateArgument>/*pack_iterator*/ XP = $tryClone(X.pack_begin()), 
        /*P*/ XPEnd = $tryClone(X.pack_end()), 
        /*P*/ YP = $tryClone(Y.pack_begin());
         $noteq_ptr(XP, XPEnd); XP.$preInc() , YP.$preInc())  {
      if (!isSameTemplateArg(Context, XP.$star(), YP.$star())) {
        return false;
      }
    }
    
    return true;
  }
  throw new llvm_unreachable("Invalid TemplateArgument Kind!");
}


/// \brief Allocate a TemplateArgumentLoc where all locations have
/// been initialized to the given location.
///
/// \param S The semantic analysis object.
///
/// \param Arg The template argument we are producing template argument
/// location information for.
///
/// \param NTTPType For a declaration template argument, the type of
/// the non-type template parameter that corresponds to this template
/// argument.
///
/// \param Loc The source location to use for the resulting template
/// argument.
//<editor-fold defaultstate="collapsed" desc="getTrivialTemplateArgumentLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2005,
 FQN="getTrivialTemplateArgumentLoc", NM="_ZL29getTrivialTemplateArgumentLocRN5clang4SemaERKNS_16TemplateArgumentENS_8QualTypeENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL29getTrivialTemplateArgumentLocRN5clang4SemaERKNS_16TemplateArgumentENS_8QualTypeENS_14SourceLocationE")
//</editor-fold>
public static TemplateArgumentLoc getTrivialTemplateArgumentLoc(final Sema /*&*/ S, 
                             final /*const*/ TemplateArgument /*&*/ Arg, 
                             QualType NTTPType, 
                             SourceLocation Loc) {
  switch (Arg.getKind()) {
   case Null:
    throw new llvm_unreachable("Can't get a NULL template argument here");
   case Type:
    return new TemplateArgumentLoc(Arg, 
        S.Context.getTrivialTypeSourceInfo(Arg.getAsType(), new SourceLocation(Loc)));
   case Declaration:
    {
      Expr /*P*/ E = S.BuildExpressionFromDeclTemplateArgument(Arg, new QualType(NTTPType), new SourceLocation(Loc)).getAs(Expr.class);
      return new TemplateArgumentLoc(new TemplateArgument(E), E);
    }
   case NullPtr:
    {
      Expr /*P*/ E = S.BuildExpressionFromDeclTemplateArgument(Arg, new QualType(NTTPType), new SourceLocation(Loc)).getAs(Expr.class);
      return new TemplateArgumentLoc(new TemplateArgument(new QualType(NTTPType), /*isNullPtr*/ true), 
          E);
    }
   case Integral:
    {
      Expr /*P*/ E = S.BuildExpressionFromIntegralTemplateArgument(Arg, new SourceLocation(Loc)).getAs(Expr.class);
      return new TemplateArgumentLoc(new TemplateArgument(E), E);
    }
   case Template:
   case TemplateExpansion:
    {
      NestedNameSpecifierLocBuilder Builder = null;
      try {
        Builder/*J*/= new NestedNameSpecifierLocBuilder();
        TemplateName Template = Arg.getAsTemplate();
        {
          DependentTemplateName /*P*/ DTN = Template.getAsDependentTemplateName();
          if ((DTN != null)) {
            Builder.MakeTrivial(S.Context, DTN.getQualifier(), new SourceRange(/*NO_COPY*/Loc));
          } else {
            QualifiedTemplateName /*P*/ QTN = Template.getAsQualifiedTemplateName();
            if ((QTN != null)) {
              Builder.MakeTrivial(S.Context, QTN.getQualifier(), new SourceRange(/*NO_COPY*/Loc));
            }
          }
        }
        if (Arg.getKind() == TemplateArgument.ArgKind.Template) {
          return new TemplateArgumentLoc(Arg, 
              Builder.getWithLocInContext(S.Context), 
              new SourceLocation(Loc));
        }
        
        return new TemplateArgumentLoc(Arg, Builder.getWithLocInContext(S.Context), 
            new SourceLocation(Loc), new SourceLocation(Loc));
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
   case Expression:
    return new TemplateArgumentLoc(Arg, Arg.getAsExpr());
   case Pack:
    return new TemplateArgumentLoc(Arg, new TemplateArgumentLocInfo());
  }
  throw new llvm_unreachable("Invalid TemplateArgument Kind!");
}


/// \brief Convert the given deduced template argument and add it to the set of
/// fully-converted template arguments.
//<editor-fold defaultstate="collapsed" desc="ConvertDeducedTemplateArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2072,
 FQN="ConvertDeducedTemplateArgument", NM="_ZL30ConvertDeducedTemplateArgumentRN5clang4SemaEPNS_9NamedDeclENS_23DeducedTemplateArgumentES3_RNS_4sema21TemplateDeductionInfoEbRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL30ConvertDeducedTemplateArgumentRN5clang4SemaEPNS_9NamedDeclENS_23DeducedTemplateArgumentES3_RNS_4sema21TemplateDeductionInfoEbRN4llvm15SmallVectorImplINS_16TemplateArgumentEEE")
//</editor-fold>
public static boolean ConvertDeducedTemplateArgument(final Sema /*&*/ S, NamedDecl /*P*/ Param, 
                              DeducedTemplateArgument Arg, 
                              NamedDecl /*P*/ Template, 
                              final TemplateDeductionInfo /*&*/ Info, 
                              boolean InFunctionTemplate, 
                              final SmallVectorImpl<TemplateArgument> /*&*/ Output) {
  // First, for a non-type template parameter type that is
  // initialized by a declaration, we need the type of the
  // corresponding non-type template parameter.
  QualType NTTPType/*J*/= new QualType();
  {
    NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(Param);
    if ((NTTP != null)) {
      NTTPType.$assignMove(NTTP.getType());
      if (NTTPType.$arrow().isDependentType()) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, new ArrayRef<TemplateArgument>(Output, false));
          $c$.clean(NTTPType.$assignMove(S.SubstType(new QualType(NTTPType), 
                  $c$.track(new MultiLevelTemplateArgumentList(TemplateArgs)), 
                  NTTP.getLocation(), 
                  NTTP.getDeclName())));
          if (NTTPType.isNull()) {
            return true;
          }
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
  
  DeducedTemplateArgumentUint2Bool ConvertArg = /*[&, &S, &NTTPType, &Info, &Param, &Template, &Output, &InFunctionTemplate]*/ (DeducedTemplateArgument Arg$1, /*uint*/int ArgumentPackIndex) -> {
        // Convert the deduced template argument into a template
        // argument that we can check, almost as if the user had written
        // the template argument explicitly.
        TemplateArgumentLoc ArgLoc = getTrivialTemplateArgumentLoc(S, Arg$1, new QualType(NTTPType), Info.getLocation());
        
        // Check the template argument, converting it as necessary.
        return S.CheckTemplateArgument(Param, ArgLoc, Template, Template.getLocation(), 
            Template.getSourceRange().getEnd(), ArgumentPackIndex, Output, 
            InFunctionTemplate ? (Arg$1.wasDeducedFromArrayBound() ? Sema.CheckTemplateArgumentKind.CTAK_DeducedFromArrayBound : Sema.CheckTemplateArgumentKind.CTAK_Deduced) : Sema.CheckTemplateArgumentKind.CTAK_Specified);
      };
  if (Arg.getKind() == TemplateArgument.ArgKind.Pack) {
    // This is a template argument pack, so check each of its arguments against
    // the template parameter.
    SmallVector<TemplateArgument> PackedArgsBuilder/*J*/= new SmallVector<TemplateArgument>(2, new TemplateArgument());
    for (final /*const*/ TemplateArgument /*&*/ P : Arg.pack_elements()) {
      // When converting the deduced template argument, append it to the
      // general output list. We need to do this so that the template argument
      // checking logic has all of the prior template arguments available.
      DeducedTemplateArgument InnerArg/*J*/= new DeducedTemplateArgument(P);
      InnerArg.setDeducedFromArrayBound(Arg.wasDeducedFromArrayBound());
      assert (InnerArg.getKind() != TemplateArgument.ArgKind.Pack) : "deduced nested pack";
      if (ConvertArg.$call(new DeducedTemplateArgument(InnerArg), PackedArgsBuilder.size())) {
        return true;
      }
      
      // Move the converted template argument into our argument pack.
      PackedArgsBuilder.push_back(Output.pop_back_val());
    }
    
    // If the pack is empty, we still need to substitute into the parameter
    // itself, in case that substitution fails. For non-type parameters, we did
    // this above. For type parameters, no substitution is ever required.
    TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Param);
    if ((TTP != null) && PackedArgsBuilder.empty()) {
      LocalInstantiationScope Scope = null;
      Sema.InstantiatingTemplate Inst = null;
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // Set up a template instantiation context.
        Scope/*J*/= new LocalInstantiationScope(S);
        Inst/*J*/= new Sema.InstantiatingTemplate(JD$Sema_SourceLocation_NamedDecl$P_TemplateTemplateParmDecl$P_ArrayRef$TemplateArgument_SourceRange.INSTANCE, S, Template.getLocation(), Template, 
            TTP, new ArrayRef<TemplateArgument>(Output, false), 
            Template.getSourceRange());
        if (Inst.isInvalid()) {
          return true;
        }
        
        TemplateArgumentList TemplateArgs/*J*/= new TemplateArgumentList(TemplateArgumentList.OnStackType.OnStack, new ArrayRef<TemplateArgument>(Output, false));
        if ($c$.clean(!(S.SubstDecl(TTP, S.CurContext, 
            $c$.track(new MultiLevelTemplateArgumentList(TemplateArgs))) != null))) {
          return true;
        }
      } finally {
        if (Inst != null) { Inst.$destroy(); }
        if (Scope != null) { Scope.$destroy(); }
        $c$.$destroy();
      }
    }
    
    // Create the resulting argument pack.
    Output.push_back(TemplateArgument.CreatePackCopy(S.Context, new ArrayRef<TemplateArgument>(PackedArgsBuilder, false)));
    return false;
  }
  
  return ConvertArg.$call(new DeducedTemplateArgument(Arg), 0);
}


/// Complete template argument deduction for a class template partial
/// specialization.
//<editor-fold defaultstate="collapsed" desc="FinishTemplateArgumentDeduction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2164,
 FQN="FinishTemplateArgumentDeduction", NM="_ZL31FinishTemplateArgumentDeductionRN5clang4SemaEPNS_38ClassTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL31FinishTemplateArgumentDeductionRN5clang4SemaEPNS_38ClassTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public static Sema.TemplateDeductionResult FinishTemplateArgumentDeduction1(final Sema /*&*/ S, 
                                ClassTemplatePartialSpecializationDecl /*P*/ Partial, 
                                final /*const*/ TemplateArgumentList /*&*/ TemplateArgs, 
                                final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                                final TemplateDeductionInfo /*&*/ Info) {
  EnterExpressionEvaluationContext Unevaluated = null;
  Sema.SFINAETrap Trap = null;
  Sema.ContextRAII SavedContext = null;
  LocalInstantiationScope InstScope = null;
  TemplateArgumentListInfo InstArgs = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new Sema.SFINAETrap(S);
    
    SavedContext/*J*/= new Sema.ContextRAII(S, Partial);
    
    // C++ [temp.deduct.type]p2:
    //   [...] or if any template argument remains neither deduced nor
    //   explicitly specified, template argument deduction fails.
    SmallVector<TemplateArgument> Builder/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    TemplateParameterList /*P*/ PartialParams = Partial.getTemplateParameters();
    for (/*uint*/int I = 0, N = PartialParams.size(); I != N; ++I) {
      NamedDecl /*P*/ Param = PartialParams.getParam(I);
      if (Deduced.$at(I).isNull()) {
        Info.Param.$assignMove(makeTemplateParameter(Param));
        return Sema.TemplateDeductionResult.TDK_Incomplete;
      }
      
      // We have deduced this argument, so it still needs to be
      // checked and converted.
      if (ConvertDeducedTemplateArgument(S, Param, new DeducedTemplateArgument(Deduced.$at(I)), 
          Partial, Info, false, 
          Builder)) {
        Info.Param.$assignMove(makeTemplateParameter(Param));
        // FIXME: These template arguments are temporary. Free them!
        Info.reset(TemplateArgumentList.CreateCopy(S.Context, new ArrayRef<TemplateArgument>(Builder, false)));
        return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
      }
    }
    
    // Form the template argument list from the deduced template arguments.
    TemplateArgumentList /*P*/ DeducedArgumentList = TemplateArgumentList.CreateCopy(S.Context, new ArrayRef<TemplateArgument>(Builder, false));
    
    Info.reset(DeducedArgumentList);
    
    // Substitute the deduced template arguments into the template
    // arguments of the class template partial specialization, and
    // verify that the instantiated template arguments are both valid
    // and are equivalent to the template arguments originally provided
    // to the class template.
    InstScope/*J*/= new LocalInstantiationScope(S);
    ClassTemplateDecl /*P*/ ClassTemplate = Partial.getSpecializedTemplate();
    /*const*/ ASTTemplateArgumentListInfo /*P*/ PartialTemplArgInfo = Partial.getTemplateArgsAsWritten();
    /*const*/ type$ptr<TemplateArgumentLoc /*P*/> PartialTemplateArgs = PartialTemplArgInfo.getTemplateArgs();
    
    InstArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(PartialTemplArgInfo.LAngleLoc), 
        new SourceLocation(PartialTemplArgInfo.RAngleLoc));
    if ($c$.clean(S.Subst(PartialTemplateArgs, PartialTemplArgInfo.NumTemplateArgs, 
        InstArgs, $c$.track(new MultiLevelTemplateArgumentList($Deref(DeducedArgumentList)))))) {
      /*uint*/int ArgIdx = InstArgs.size(), ParamIdx = ArgIdx;
      if ($greatereq_uint(ParamIdx, Partial.getTemplateParameters().size())) {
        ParamIdx = Partial.getTemplateParameters().size() - 1;
      }
      
      Decl /*P*/ Param = ((/*const_cast*/NamedDecl /*P*/ )(Partial.getTemplateParameters().getParam(ParamIdx)));
      Info.Param.$assignMove(makeTemplateParameter(Param));
      Info.FirstArg.$assign(PartialTemplateArgs.$at(ArgIdx).getArgument());
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    SmallVector<TemplateArgument> ConvertedInstArgs/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    if (S.CheckTemplateArgumentList(ClassTemplate, Partial.getLocation(), 
        InstArgs, false, ConvertedInstArgs)) {
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    TemplateParameterList /*P*/ TemplateParams = ClassTemplate.getTemplateParameters();
    for (/*uint*/int I = 0, E = TemplateParams.size(); I != E; ++I) {
      TemplateArgument InstArg = new TemplateArgument(ConvertedInstArgs.data().$at(I));
      if (!isSameTemplateArg(S.Context, TemplateArgs.$at(I), InstArg)) {
        Info.Param.$assignMove(makeTemplateParameter(TemplateParams.getParam(I)));
        Info.FirstArg.$assign(TemplateArgs.$at(I));
        Info.SecondArg.$assign(InstArg);
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
    }
    if (Trap.hasErrorOccurred()) {
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    return Sema.TemplateDeductionResult.TDK_Success;
  } finally {
    if (InstArgs != null) { InstArgs.$destroy(); }
    if (InstScope != null) { InstScope.$destroy(); }
    if (SavedContext != null) { SavedContext.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
    $c$.$destroy();
  }
}


/// Complete template argument deduction for a variable template partial
/// specialization.
/// TODO: Unify with ClassTemplatePartialSpecializationDecl version?
///       May require unifying ClassTemplate(Partial)SpecializationDecl and
///        VarTemplate(Partial)SpecializationDecl with a new data
///        structure Template(Partial)SpecializationDecl, and
///        using Template(Partial)SpecializationDecl as input type.
//<editor-fold defaultstate="collapsed" desc="FinishTemplateArgumentDeduction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2307,
 FQN="FinishTemplateArgumentDeduction", NM="_ZL31FinishTemplateArgumentDeductionRN5clang4SemaEPNS_36VarTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL31FinishTemplateArgumentDeductionRN5clang4SemaEPNS_36VarTemplatePartialSpecializationDeclERKNS_20TemplateArgumentListERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public static Sema.TemplateDeductionResult FinishTemplateArgumentDeduction2(final Sema /*&*/ S, VarTemplatePartialSpecializationDecl /*P*/ Partial, 
                                final /*const*/ TemplateArgumentList /*&*/ TemplateArgs, 
                                final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                                final TemplateDeductionInfo /*&*/ Info) {
  EnterExpressionEvaluationContext Unevaluated = null;
  Sema.SFINAETrap Trap = null;
  LocalInstantiationScope InstScope = null;
  TemplateArgumentListInfo InstArgs = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    // Unevaluated SFINAE context.
    Unevaluated/*J*/= new EnterExpressionEvaluationContext(S, Sema.ExpressionEvaluationContext.Unevaluated);
    Trap/*J*/= new Sema.SFINAETrap(S);
    
    // C++ [temp.deduct.type]p2:
    //   [...] or if any template argument remains neither deduced nor
    //   explicitly specified, template argument deduction fails.
    SmallVector<TemplateArgument> Builder/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    TemplateParameterList /*P*/ PartialParams = Partial.getTemplateParameters();
    for (/*uint*/int I = 0, N = PartialParams.size(); I != N; ++I) {
      NamedDecl /*P*/ Param = PartialParams.getParam(I);
      if (Deduced.$at(I).isNull()) {
        Info.Param.$assignMove(makeTemplateParameter(Param));
        return Sema.TemplateDeductionResult.TDK_Incomplete;
      }
      
      // We have deduced this argument, so it still needs to be
      // checked and converted.
      if (ConvertDeducedTemplateArgument(S, Param, new DeducedTemplateArgument(Deduced.$at(I)), Partial, 
          Info, false, Builder)) {
        Info.Param.$assignMove(makeTemplateParameter(Param));
        // FIXME: These template arguments are temporary. Free them!
        Info.reset(TemplateArgumentList.CreateCopy(S.Context, new ArrayRef<TemplateArgument>(Builder, false)));
        return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
      }
    }
    
    // Form the template argument list from the deduced template arguments.
    TemplateArgumentList /*P*/ DeducedArgumentList = TemplateArgumentList.CreateCopy(S.Context, new ArrayRef<TemplateArgument>(Builder, false));
    
    Info.reset(DeducedArgumentList);
    
    // Substitute the deduced template arguments into the template
    // arguments of the class template partial specialization, and
    // verify that the instantiated template arguments are both valid
    // and are equivalent to the template arguments originally provided
    // to the class template.
    InstScope/*J*/= new LocalInstantiationScope(S);
    VarTemplateDecl /*P*/ VarTemplate = Partial.getSpecializedTemplate();
    /*const*/ ASTTemplateArgumentListInfo /*P*/ PartialTemplArgInfo = Partial.getTemplateArgsAsWritten();
    /*const*/ type$ptr<TemplateArgumentLoc /*P*/> PartialTemplateArgs = PartialTemplArgInfo.getTemplateArgs();
    
    InstArgs/*J*/= new TemplateArgumentListInfo(new SourceLocation(PartialTemplArgInfo.LAngleLoc), 
        new SourceLocation(PartialTemplArgInfo.RAngleLoc));
    if ($c$.clean(S.Subst(PartialTemplateArgs, PartialTemplArgInfo.NumTemplateArgs, 
        InstArgs, $c$.track(new MultiLevelTemplateArgumentList($Deref(DeducedArgumentList)))))) {
      /*uint*/int ArgIdx = InstArgs.size(), ParamIdx = ArgIdx;
      if ($greatereq_uint(ParamIdx, Partial.getTemplateParameters().size())) {
        ParamIdx = Partial.getTemplateParameters().size() - 1;
      }
      
      Decl /*P*/ Param = ((/*const_cast*/NamedDecl /*P*/ )(Partial.getTemplateParameters().getParam(ParamIdx)));
      Info.Param.$assignMove(makeTemplateParameter(Param));
      Info.FirstArg.$assign(PartialTemplateArgs.$at(ArgIdx).getArgument());
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    SmallVector<TemplateArgument> ConvertedInstArgs/*J*/= new SmallVector<TemplateArgument>(4, new TemplateArgument());
    if (S.CheckTemplateArgumentList(VarTemplate, Partial.getLocation(), InstArgs, 
        false, ConvertedInstArgs)) {
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    TemplateParameterList /*P*/ TemplateParams = VarTemplate.getTemplateParameters();
    for (/*uint*/int I = 0, E = TemplateParams.size(); I != E; ++I) {
      TemplateArgument InstArg = new TemplateArgument(ConvertedInstArgs.data().$at(I));
      if (!isSameTemplateArg(S.Context, TemplateArgs.$at(I), InstArg)) {
        Info.Param.$assignMove(makeTemplateParameter(TemplateParams.getParam(I)));
        Info.FirstArg.$assign(TemplateArgs.$at(I));
        Info.SecondArg.$assign(InstArg);
        return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
      }
    }
    if (Trap.hasErrorOccurred()) {
      return Sema.TemplateDeductionResult.TDK_SubstitutionFailure;
    }
    
    return Sema.TemplateDeductionResult.TDK_Success;
  } finally {
    if (InstArgs != null) { InstArgs.$destroy(); }
    if (InstScope != null) { InstScope.$destroy(); }
    if (Trap != null) { Trap.$destroy(); }
    if (Unevaluated != null) { Unevaluated.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Determine whether the given type T is a simple-template-id type.
//<editor-fold defaultstate="collapsed" desc="isSimpleTemplateIdType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2440,
 FQN="isSimpleTemplateIdType", NM="_ZL22isSimpleTemplateIdTypeN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL22isSimpleTemplateIdTypeN5clang8QualTypeE")
//</editor-fold>
public static boolean isSimpleTemplateIdType(QualType T) {
  {
    /*const*/ TemplateSpecializationType /*P*/ Spec = T.$arrow().<TemplateSpecializationType>getAs$TemplateSpecializationType();
    if ((Spec != null)) {
      return Spec.getTemplateName().getAsTemplateDecl() != null;
    }
  }
  
  return false;
}


/// \brief Check whether the deduced argument type for a call to a function
/// template matches the actual argument type per C++ [temp.deduct.call]p4.
//<editor-fold defaultstate="collapsed" desc="CheckOriginalCallArgDeduction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2648,
 FQN="CheckOriginalCallArgDeduction", NM="_ZL29CheckOriginalCallArgDeductionRN5clang4SemaENS0_15OriginalCallArgENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL29CheckOriginalCallArgDeductionRN5clang4SemaENS0_15OriginalCallArgENS_8QualTypeE")
//</editor-fold>
public static boolean CheckOriginalCallArgDeduction(final Sema /*&*/ S, Sema.OriginalCallArg OriginalArg, 
                             QualType DeducedA) {
  final ASTContext /*&*/ Context = S.Context;
  
  QualType A = new QualType(OriginalArg.OriginalArgType);
  QualType OriginalParamType = new QualType(OriginalArg.OriginalParamType);
  
  // Check for type equality (top-level cv-qualifiers are ignored).
  if (Context.hasSameUnqualifiedType(new QualType(A), new QualType(DeducedA))) {
    return false;
  }
  {
    
    // Strip off references on the argument types; they aren't needed for
    // the following checks.
    /*const*/ ReferenceType /*P*/ DeducedARef = DeducedA.$arrow().getAs(ReferenceType.class);
    if ((DeducedARef != null)) {
      DeducedA.$assignMove(DeducedARef.getPointeeType());
    }
  }
  {
    /*const*/ ReferenceType /*P*/ ARef = A.$arrow().getAs(ReferenceType.class);
    if ((ARef != null)) {
      A.$assignMove(ARef.getPointeeType());
    }
  }
  {
    
    // C++ [temp.deduct.call]p4:
    //   [...] However, there are three cases that allow a difference:
    //     - If the original P is a reference type, the deduced A (i.e., the 
    //       type referred to by the reference) can be more cv-qualified than 
    //       the transformed A.
    /*const*/ ReferenceType /*P*/ OriginalParamRef = OriginalParamType.$arrow().getAs(ReferenceType.class);
    if ((OriginalParamRef != null)) {
      // We don't want to keep the reference around any more.
      OriginalParamType.$assignMove(OriginalParamRef.getPointeeType());
      
      Qualifiers AQuals = A.getQualifiers();
      Qualifiers DeducedAQuals = DeducedA.getQualifiers();
      
      // Under Objective-C++ ARC, the deduced type may have implicitly
      // been given strong or (when dealing with a const reference)
      // unsafe_unretained lifetime. If so, update the original
      // qualifiers to include this lifetime.
      if (S.getLangOpts().ObjCAutoRefCount
         && ((DeducedAQuals.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Strong
         && AQuals.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_None)
         || (DeducedAQuals.hasConst()
         && DeducedAQuals.getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_ExplicitNone))) {
        AQuals.setObjCLifetime(DeducedAQuals.getObjCLifetime());
      }
      if (AQuals.$eq(/*NO_COPY*/DeducedAQuals)) {
        // Qualifiers match; there's nothing to do.
      } else if (!DeducedAQuals.compatiblyIncludes(new Qualifiers(AQuals))) {
        return true;
      } else {
        // Qualifiers are compatible, so have the argument type adopt the
        // deduced argument type's qualifiers as if we had performed the
        // qualification conversion.
        A.$assignMove(Context.getQualifiedType(A.getUnqualifiedType(), new Qualifiers(DeducedAQuals)));
      }
    }
  }
  
  //    - The transformed A can be another pointer or pointer to member 
  //      type that can be converted to the deduced A via a qualification 
  //      conversion.
  //
  // Also allow conversions which merely strip [[noreturn]] from function types
  // (recursively) as an extension.
  // FIXME: Currently, this doesn't play nicely with qualification conversions.
  bool$ref ObjCLifetimeConversion = create_bool$ref(false);
  QualType ResultTy/*J*/= new QualType();
  if ((A.$arrow().isAnyPointerType() || A.$arrow().isMemberPointerType())
     && (S.IsQualificationConversion(new QualType(A), new QualType(DeducedA), false, 
      ObjCLifetimeConversion)
     || S.IsNoReturnConversion(new QualType(A), new QualType(DeducedA), ResultTy))) {
    return false;
  }
  {
    
    //    - If P is a class and P has the form simple-template-id, then the 
    //      transformed A can be a derived class of the deduced A. [...]
    //     [...] Likewise, if P is a pointer to a class of the form 
    //      simple-template-id, the transformed A can be a pointer to a 
    //      derived class pointed to by the deduced A.
    /*const*/ PointerType /*P*/ OriginalParamPtr = OriginalParamType.$arrow().getAs(PointerType.class);
    if ((OriginalParamPtr != null)) {
      {
        /*const*/ PointerType /*P*/ DeducedAPtr = DeducedA.$arrow().getAs(PointerType.class);
        if ((DeducedAPtr != null)) {
          {
            /*const*/ PointerType /*P*/ APtr = A.$arrow().getAs(PointerType.class);
            if ((APtr != null)) {
              if (A.$arrow().getPointeeType().$arrow().isRecordType()) {
                OriginalParamType.$assignMove(OriginalParamPtr.getPointeeType());
                DeducedA.$assignMove(DeducedAPtr.getPointeeType());
                A.$assignMove(APtr.getPointeeType());
              }
            }
          }
        }
      }
    }
  }
  if (Context.hasSameUnqualifiedType(new QualType(A), new QualType(DeducedA))) {
    return false;
  }
  if (A.$arrow().isRecordType() && isSimpleTemplateIdType(new QualType(OriginalParamType))
     && S.IsDerivedFrom(new SourceLocation(), new QualType(A), new QualType(DeducedA))) {
    return false;
  }
  
  return true;
}


/// Gets the type of a function for template-argument-deducton
/// purposes when it's considered as part of an overload set.
//<editor-fold defaultstate="collapsed" desc="GetTypeOfFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2966,
 FQN="GetTypeOfFunction", NM="_ZL17GetTypeOfFunctionRN5clang4SemaERKNS_12OverloadExpr10FindResultEPNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL17GetTypeOfFunctionRN5clang4SemaERKNS_12OverloadExpr10FindResultEPNS_12FunctionDeclE")
//</editor-fold>
public static QualType GetTypeOfFunction(final Sema /*&*/ S, final /*const*/ OverloadExpr.FindResult /*&*/ R, 
                 FunctionDecl /*P*/ Fn) {
  // We may need to deduce the return type of the function now.
  if (S.getLangOpts().CPlusPlus14 && Fn.getReturnType().$arrow().isUndeducedType()
     && S.DeduceReturnType(Fn, R.Expression.getExprLoc(), /*Diagnose*/ false)) {
    return new QualType();
  }
  {
    
    CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(Fn);
    if ((Method != null)) {
      if (Method.isInstance()) {
        // An instance method that's referenced in a form that doesn't
        // look like a member pointer is just invalid.
        if (!R.HasFormOfMemberPointer) {
          return new QualType();
        }
        
        return S.Context.getMemberPointerType(Fn.getType(), 
            S.Context.getTypeDeclType(Method.getParent()).getTypePtr());
      }
    }
  }
  if (!R.IsAddressOfOperand) {
    return Fn.getType();
  }
  return S.Context.getPointerType(Fn.getType());
}


/// Apply the deduction rules for overload sets.
///
/// \return the null type if this argument should be treated as an
/// undeduced context
//<editor-fold defaultstate="collapsed" desc="ResolveOverloadForDeduction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 2991,
 FQN="ResolveOverloadForDeduction", NM="_ZL27ResolveOverloadForDeductionRN5clang4SemaEPNS_21TemplateParameterListEPNS_4ExprENS_8QualTypeEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL27ResolveOverloadForDeductionRN5clang4SemaEPNS_21TemplateParameterListEPNS_4ExprENS_8QualTypeEb")
//</editor-fold>
public static QualType ResolveOverloadForDeduction(final Sema /*&*/ S, TemplateParameterList /*P*/ TemplateParams, 
                           Expr /*P*/ Arg, QualType ParamType, 
                           boolean ParamWasReference) {
  TemplateArgumentListInfo ExplicitTemplateArgs = null;
  try {
    
    OverloadExpr.FindResult R = OverloadExpr.find(Arg);
    
    OverloadExpr /*P*/ Ovl = R.Expression;
    
    // C++0x [temp.deduct.call]p4
    /*uint*/int TDF = 0;
    if (ParamWasReference) {
      TDF |= TemplateDeductionFlags.TDF_ParamWithReferenceType;
    }
    if (R.IsAddressOfOperand) {
      TDF |= TemplateDeductionFlags.TDF_IgnoreQualifiers;
    }
    
    // C++0x [temp.deduct.call]p6:
    //   When P is a function type, pointer to function type, or pointer
    //   to member function type:
    if (!ParamType.$arrow().isFunctionType()
       && !ParamType.$arrow().isFunctionPointerType()
       && !ParamType.$arrow().isMemberFunctionPointerType()) {
      if (Ovl.hasExplicitTemplateArgs()) {
        {
          // But we can still look for an explicit specialization.
          FunctionDecl /*P*/ ExplicitSpec = S.ResolveSingleFunctionTemplateSpecialization(Ovl);
          if ((ExplicitSpec != null)) {
            return GetTypeOfFunction(S, R, ExplicitSpec);
          }
        }
      }
      
      DeclAccessPair DAP/*J*/= new DeclAccessPair();
      {
        FunctionDecl /*P*/ Viable = S.resolveAddressOfOnlyViableOverloadCandidate(Arg, DAP);
        if ((Viable != null)) {
          return GetTypeOfFunction(S, R, Viable);
        }
      }
      
      return new QualType();
    }
    
    // Gather the explicit template arguments, if any.
    ExplicitTemplateArgs/*J*/= new TemplateArgumentListInfo();
    if (Ovl.hasExplicitTemplateArgs()) {
      Ovl.copyTemplateArgumentsInto(ExplicitTemplateArgs);
    }
    QualType Match/*J*/= new QualType();
    for (UnresolvedSetIterator I = Ovl.decls_begin(), 
        E = Ovl.decls_end(); I.$noteq(E); I.$preInc()) {
      TemplateDeductionInfo Info = null;
      try {
        NamedDecl /*P*/ D = (I.$star()).getUnderlyingDecl();
        {
          
          FunctionTemplateDecl /*P*/ FunTmpl = dyn_cast_FunctionTemplateDecl(D);
          if ((FunTmpl != null)) {
            TemplateDeductionInfo Info$1 = null;
            try {
              //   - If the argument is an overload set containing one or more
              //     function templates, the parameter is treated as a
              //     non-deduced context.
              if (!Ovl.hasExplicitTemplateArgs()) {
                return new QualType();
              }
              
              // Otherwise, see if we can resolve a function type 
              type$ref<FunctionDecl /*P*/ > Specialization = create_type$ref();
              Info$1/*J*/= new TemplateDeductionInfo(Ovl.getNameLoc());
              if ((S.DeduceTemplateArguments(FunTmpl, $AddrOf(ExplicitTemplateArgs), 
                  Specialization, Info$1).getValue() != 0)) {
                continue;
              }
              
              D = Specialization.$deref();
            } finally {
              if (Info$1 != null) { Info$1.$destroy(); }
            }
          }
        }
        
        FunctionDecl /*P*/ Fn = cast_FunctionDecl(D);
        QualType ArgType = GetTypeOfFunction(S, R, Fn);
        if (ArgType.isNull()) {
          continue;
        }
        
        // Function-to-pointer conversion.
        if (!ParamWasReference && ParamType.$arrow().isPointerType()
           && ArgType.$arrow().isFunctionType()) {
          ArgType.$assignMove(S.Context.getPointerType(new QualType(ArgType)));
        }
        
        //   - If the argument is an overload set (not containing function
        //     templates), trial argument deduction is attempted using each
        //     of the members of the set. If deduction succeeds for only one
        //     of the overload set members, that member is used as the
        //     argument value for the deduction. If deduction succeeds for
        //     more than one member of the overload set the parameter is
        //     treated as a non-deduced context.
        
        // We do all of this in a fresh context per C++0x [temp.deduct.type]p2:
        //   Type deduction is done independently for each P/A pair, and
        //   the deduced template argument values are then combined.
        // So we do not reject deductions which were made elsewhere.
        SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(JD$UInt_T$C$R.INSTANCE, 8, TemplateParams.size(), new DeducedTemplateArgument());
        Info/*J*/= new TemplateDeductionInfo(Ovl.getNameLoc());
        Sema.TemplateDeductionResult Result = DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, new QualType(ParamType), 
            new QualType(ArgType), Info, Deduced, TDF);
        if ((Result.getValue() != 0)) {
          continue;
        }
        if (!Match.isNull()) {
          return new QualType();
        }
        Match.$assign(ArgType);
      } finally {
        if (Info != null) { Info.$destroy(); }
      }
    }
    
    return Match;
  } finally {
    if (ExplicitTemplateArgs != null) { ExplicitTemplateArgs.$destroy(); }
  }
}


/// \brief Perform the adjustments to the parameter and argument types
/// described in C++ [temp.deduct.call].
///
/// \returns true if the caller should not attempt to perform any template
/// argument deduction based on this P/A pair because the argument is an
/// overloaded function set that could not be resolved.
//<editor-fold defaultstate="collapsed" desc="AdjustFunctionParmAndArgTypesForDeduction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3096,
 FQN="AdjustFunctionParmAndArgTypesForDeduction", NM="_ZL41AdjustFunctionParmAndArgTypesForDeductionRN5clang4SemaEPNS_21TemplateParameterListERNS_8QualTypeES5_PNS_4ExprERj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL41AdjustFunctionParmAndArgTypesForDeductionRN5clang4SemaEPNS_21TemplateParameterListERNS_8QualTypeES5_PNS_4ExprERj")
//</editor-fold>
public static boolean AdjustFunctionParmAndArgTypesForDeduction(final Sema /*&*/ S, 
                                         TemplateParameterList /*P*/ TemplateParams, 
                                         final QualType /*&*/ ParamType, 
                                         final QualType /*&*/ ArgType, 
                                         Expr /*P*/ Arg, 
                                         final uint$ref/*uint &*/ TDF) {
  // C++0x [temp.deduct.call]p3:
  //   If P is a cv-qualified type, the top level cv-qualifiers of P's type
  //   are ignored for type deduction.
  if (ParamType.hasQualifiers()) {
    ParamType.$assignMove(ParamType.getUnqualifiedType());
  }
  
  //   [...] If P is a reference type, the type referred to by P is
  //   used for type deduction.
  /*const*/ ReferenceType /*P*/ ParamRefType = ParamType.$arrow().getAs(ReferenceType.class);
  if ((ParamRefType != null)) {
    ParamType.$assignMove(ParamRefType.getPointeeType());
  }
  
  // Overload sets usually make this parameter an undeduced context,
  // but there are sometimes special circumstances.  Typically
  // involving a template-id-expr.
  if ($eq_QualType$C(ArgType, S.Context.OverloadTy.$QualType())) {
    ArgType.$assignMove(ResolveOverloadForDeduction(S, TemplateParams, 
            Arg, new QualType(ParamType), 
            ParamRefType != (/*const*/ ReferenceType /*P*/ )null));
    if (ArgType.isNull()) {
      return true;
    }
  }
  if ((ParamRefType != null)) {
    // If the argument has incomplete array type, try to complete its type.
    if (ArgType.$arrow().isIncompleteArrayType()) {
      S.completeExprArrayBound(Arg);
      ArgType.$assignMove(Arg.getType());
    }
    
    // C++0x [temp.deduct.call]p3:
    //   If P is an rvalue reference to a cv-unqualified template
    //   parameter and the argument is an lvalue, the type "lvalue
    //   reference to A" is used in place of A for type deduction.
    if (ParamRefType.isRValueReferenceType()
       && !ParamType.getQualifiers().$bool()
       && isa_TemplateTypeParmType(ParamType)
       && Arg.isLValue()) {
      ArgType.$assignMove(S.Context.getLValueReferenceType(new QualType(ArgType)));
    }
  } else {
    // C++ [temp.deduct.call]p2:
    //   If P is not a reference type:
    //   - If A is an array type, the pointer type produced by the
    //     array-to-pointer standard conversion (4.2) is used in place of
    //     A for type deduction; otherwise,
    if (ArgType.$arrow().isArrayType()) {
      ArgType.$assignMove(S.Context.getArrayDecayedType(new QualType(ArgType)));
    } else //   - If A is a function type, the pointer type produced by the
    //     function-to-pointer standard conversion (4.3) is used in place
    //     of A for type deduction; otherwise,
    if (ArgType.$arrow().isFunctionType()) {
      ArgType.$assignMove(S.Context.getPointerType(new QualType(ArgType)));
    } else {
      // - If A is a cv-qualified type, the top level cv-qualifiers of A's
      //   type are ignored for type deduction.
      ArgType.$assignMove(ArgType.getUnqualifiedType());
    }
  }
  
  // C++0x [temp.deduct.call]p4:
  //   In general, the deduction process attempts to find template argument
  //   values that will make the deduced A identical to A (after the type A
  //   is transformed as described above). [...]
  TDF.$set(TemplateDeductionFlags.TDF_SkipNonDependent);
  
  //     - If the original P is a reference type, the deduced A (i.e., the
  //       type referred to by the reference) can be more cv-qualified than
  //       the transformed A.
  if ((ParamRefType != null)) {
    TDF.$set$orassign(TemplateDeductionFlags.TDF_ParamWithReferenceType);
  }
  //     - The transformed A can be another pointer or pointer to member
  //       type that can be converted to the deduced A via a qualification
  //       conversion (4.4).
  if (ArgType.$arrow().isPointerType() || ArgType.$arrow().isMemberPointerType()
     || ArgType.$arrow().isObjCObjectPointerType()) {
    TDF.$set$orassign(TemplateDeductionFlags.TDF_IgnoreQualifiers);
  }
  //     - If P is a class and P has the form simple-template-id, then the
  //       transformed A can be a derived class of the deduced A. Likewise,
  //       if P is a pointer to a class of the form simple-template-id, the
  //       transformed A can be a pointer to a derived class pointed to by
  //       the deduced A.
  if (isSimpleTemplateIdType(new QualType(ParamType))
     || (isa_PointerType(ParamType)
     && isSimpleTemplateIdType(ParamType.$arrow().getAs(PointerType.class).getPointeeType()))) {
    TDF.$set$orassign(TemplateDeductionFlags.TDF_DerivedClass);
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="hasDeducibleTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 5048,
 FQN="hasDeducibleTemplateParameters", NM="_ZL30hasDeducibleTemplateParametersRN5clang4SemaEPNS_20FunctionTemplateDeclENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL30hasDeducibleTemplateParametersRN5clang4SemaEPNS_20FunctionTemplateDeclENS_8QualTypeE")
//</editor-fold>
public static boolean hasDeducibleTemplateParameters(final Sema /*&*/ S, 
                              FunctionTemplateDecl /*P*/ FunctionTemplate, 
                              QualType T) {
  if (!T.$arrow().isDependentType()) {
    return false;
  }

  TemplateParameterList /*P*/ TemplateParams = FunctionTemplate.getTemplateParameters();
  SmallBitVector Deduced/*J*/= new SmallBitVector(TemplateParams.size());
  /*::*/MarkUsedTemplateParameters(S.Context, new QualType(T), true, TemplateParams.getDepth(), 
      Deduced);

  return Deduced.any();
}


/// \brief Perform template argument deduction by matching a parameter type
///        against a single expression, where the expression is an element of
///        an initializer list that was originally matched against a parameter
///        of type \c initializer_list\<ParamType\>.
//<editor-fold defaultstate="collapsed" desc="DeduceTemplateArgumentByListElement">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3273,
 FQN="DeduceTemplateArgumentByListElement", NM="_ZL35DeduceTemplateArgumentByListElementRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeEPNS_4ExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL35DeduceTemplateArgumentByListElementRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeEPNS_4ExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEj")
//</editor-fold>
public static Sema.TemplateDeductionResult DeduceTemplateArgumentByListElement(final Sema /*&*/ S, 
                                   TemplateParameterList /*P*/ TemplateParams, 
                                   QualType ParamType, Expr /*P*/ Arg, 
                                   final TemplateDeductionInfo /*&*/ Info, 
                                   final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                                   /*uint*/int TDF) {
  {
    // Handle the case where an init list contains another init list as the
    // element.
    InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Arg);
    if ((ILE != null)) {
      type$ref<Sema.TemplateDeductionResult> Result = create_type$ref();
      if (!DeduceFromInitializerList(S, TemplateParams, 
          ParamType.getNonReferenceType(), ILE, Info, 
          Deduced, TDF, Result)) {
        return Sema.TemplateDeductionResult.TDK_Success; // Just ignore this expression.
      }
      
      return Result.$deref();
    }
  }
  
  // For all other cases, just match by type.
  QualType ArgType = Arg.getType();
  uint$ref TDFref = create_uint$ref(TDF);
  if (AdjustFunctionParmAndArgTypesForDeduction(S, TemplateParams, ParamType, 
      ArgType, Arg, TDFref)) {
    Info.Unnamed_field7.Expression = Arg;
    return Sema.TemplateDeductionResult.TDK_FailedOverloadResolution;
  }
  return DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, new QualType(ParamType), 
      new QualType(ArgType), Info, Deduced, TDFref.$deref());
}


/// \brief Attempt template argument deduction from an initializer list
///        deemed to be an argument in a function call.
//<editor-fold defaultstate="collapsed" desc="DeduceFromInitializerList">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3203,
 FQN="DeduceFromInitializerList", NM="_ZL25DeduceFromInitializerListRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeEPNS_12InitListExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjRNS0_23TemplateDeductionResultE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL25DeduceFromInitializerListRN5clang4SemaEPNS_21TemplateParameterListENS_8QualTypeEPNS_12InitListExprERNS_4sema21TemplateDeductionInfoERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEEjRNS0_23TemplateDeductionResultE")
//</editor-fold>
public static boolean DeduceFromInitializerList(final Sema /*&*/ S, TemplateParameterList /*P*/ TemplateParams, 
                         QualType AdjustedParamType, InitListExpr /*P*/ ILE, 
                         final TemplateDeductionInfo /*&*/ Info, 
                         final SmallVectorImpl<DeducedTemplateArgument> /*&*/ Deduced, 
                         /*uint*/int TDF, final type$ref<Sema.TemplateDeductionResult /*&*/> Result) {
  
  // [temp.deduct.call] p1 (post CWG-1591)
  // If removing references and cv-qualifiers from P gives
  // std::initializer_list<P0> or P0[N] for some P0 and N and the argument is a
  // non-empty initializer list (8.5.4), then deduction is performed instead for
  // each element of the initializer list, taking P0 as a function template
  // parameter type and the initializer element as its argument, and in the
  // P0[N] case, if N is a non-type template parameter, N is deduced from the
  // length of the initializer list. Otherwise, an initializer list argument
  // causes the parameter to be considered a non-deduced context
  /*const*/boolean IsConstSizedArray = AdjustedParamType.$arrow().isConstantArrayType();
  
  /*const*/boolean IsDependentSizedArray = !IsConstSizedArray && AdjustedParamType.$arrow().isDependentSizedArrayType();
  
  QualType ElTy/*J*/= new QualType(); // The element type of the std::initializer_list or the array.
  
  /*const*/boolean IsSTDList = !IsConstSizedArray && !IsDependentSizedArray
     && S.isStdInitializerList(new QualType(AdjustedParamType), $AddrOf(create_type$ptr(ElTy)));
  if (!IsConstSizedArray && !IsDependentSizedArray && !IsSTDList) {
    return false;
  }
  
  Result.$set(Sema.TemplateDeductionResult.TDK_Success);
  // If we are not deducing against the 'T' in a std::initializer_list<T> then
  // deduce against the 'T' in T[N].
  if (ElTy.isNull()) {
    assert (!IsSTDList);
    ElTy.$assignMove(S.Context.getAsArrayType(new QualType(AdjustedParamType)).getElementType());
  }
  // Deduction only needs to be done for dependent types.
  if (ElTy.$arrow().isDependentType()) {
    for (Expr /*P*/ E : ILE.inits()) {
      if (((Result.$set(DeduceTemplateArgumentByListElement(S, TemplateParams, new QualType(ElTy), 
          E, Info, Deduced, TDF))).getValue() != 0)) {
        return true;
      }
    }
  }
  if (IsDependentSizedArray) {
    /*const*/ DependentSizedArrayType /*P*/ ArrTy = S.Context.getAsDependentSizedArrayType(new QualType(AdjustedParamType));
    {
      // Determine the array bound is something we can deduce.
      NonTypeTemplateParmDecl /*P*/ NTTP = getDeducedParameterFromExpr(ArrTy.getSizeExpr());
      if ((NTTP != null)) {
        // We can perform template argument deduction for the given non-type
        // template parameter.
        assert (NTTP.getDepth() == 0) : "Cannot deduce non-type template argument at depth > 0";
        APInt Size/*J*/= new APInt(S.Context.getIntWidth(NTTP.getType()), 
            $uint2ulong(ILE.getNumInits()));
        
        Result.$set(DeduceNonTypeTemplateArgument(S, NTTP, new APSInt(new APInt(Size)), NTTP.getType(), 
            /*ArrayBound=*/ true, Info, Deduced));
      }
    }
  }
  return true;
}


/// \brief Given a function declaration (e.g. a generic lambda conversion 
///  function) that contains an 'auto' in its result type, substitute it 
///  with TypeToReplaceAutoWith.  Be careful to pass in the type you want
///  to replace 'auto' with and not the actual result type you want
///  to set the function to.
//<editor-fold defaultstate="collapsed" desc="SubstAutoWithinFunctionReturnType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3651,
 FQN="SubstAutoWithinFunctionReturnType", NM="_ZL33SubstAutoWithinFunctionReturnTypePN5clang12FunctionDeclENS_8QualTypeERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL33SubstAutoWithinFunctionReturnTypePN5clang12FunctionDeclENS_8QualTypeERNS_4SemaE")
//</editor-fold>
public static /*inline*/ void SubstAutoWithinFunctionReturnType(FunctionDecl /*P*/ F, 
                                 QualType TypeToReplaceAutoWith, final Sema /*&*/ S) {
  assert (!(TypeToReplaceAutoWith.$arrow().getContainedAutoType() != null));
  QualType AutoResultType = F.getReturnType();
  assert Native.$bool(AutoResultType.$arrow().getContainedAutoType());
  QualType DeducedResultType = S.SubstAutoType(new QualType(AutoResultType), 
      new QualType(TypeToReplaceAutoWith));
  S.Context.adjustDeducedFunctionResultType(F, new QualType(DeducedResultType));
}


/// \brief Given a specialized conversion operator of a generic lambda 
/// create the corresponding specializations of the call operator and 
/// the static-invoker. If the return type of the call operator is auto, 
/// deduce its return type and check if that matches the 
/// return type of the destination function ptr.
//<editor-fold defaultstate="collapsed" desc="SpecializeCorrespondingLambdaCallOperatorAndInvoker">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 3668,
 FQN="SpecializeCorrespondingLambdaCallOperatorAndInvoker", NM="_ZL51SpecializeCorrespondingLambdaCallOperatorAndInvokerPN5clang17CXXConversionDeclERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEENS_8QualTypeERNS_4sema21TemplateDeductionInfoERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL51SpecializeCorrespondingLambdaCallOperatorAndInvokerPN5clang17CXXConversionDeclERN4llvm15SmallVectorImplINS_23DeducedTemplateArgumentEEENS_8QualTypeERNS_4sema21TemplateDeductionInfoERNS_4SemaE")
//</editor-fold>
public static /*inline*/ Sema.TemplateDeductionResult SpecializeCorrespondingLambdaCallOperatorAndInvoker(CXXConversionDecl /*P*/ ConversionSpecialized, 
                                                   final SmallVectorImpl<DeducedTemplateArgument> /*&*/ DeducedArguments, 
                                                   QualType ReturnTypeOfDestFunctionPtr, 
                                                   final TemplateDeductionInfo /*&*/ TDInfo, 
                                                   final Sema /*&*/ S) {
  
  CXXRecordDecl /*P*/ LambdaClass = ConversionSpecialized.getParent();
  assert ((LambdaClass != null) && LambdaClass.isGenericLambda());
  
  CXXMethodDecl /*P*/ CallOpGeneric = LambdaClass.getLambdaCallOperator();
  QualType CallOpResultType = CallOpGeneric.getReturnType();
  /*const*/boolean GenericLambdaCallOperatorHasDeducedReturnType = (CallOpResultType.$arrow().getContainedAutoType() != null);
  
  FunctionTemplateDecl /*P*/ CallOpTemplate = CallOpGeneric.getDescribedFunctionTemplate();
  
  type$ref<FunctionDecl /*P*/ > CallOpSpecialized = create_type$ref();
  {
    // Use the deduced arguments of the conversion function, to specialize our 
    // generic lambda's call operator.
    Sema.TemplateDeductionResult Result = S.FinishTemplateArgumentDeduction(CallOpTemplate, 
        DeducedArguments, 
        0, CallOpSpecialized, TDInfo);
    if ((Result.getValue() != 0)) {
      return Result;
    }
  }
  
  // If we need to deduce the return type, do so (instantiates the callop).
  if (GenericLambdaCallOperatorHasDeducedReturnType
     && CallOpSpecialized.$deref().getReturnType().$arrow().isUndeducedType()) {
    S.DeduceReturnType(CallOpSpecialized.$deref(), 
        CallOpSpecialized.$deref().getPointOfInstantiation(), 
        /*Diagnose*/ true);
  }
  
  // Check to see if the return type of the destination ptr-to-function
  // matches the return type of the call operator.
  if (!S.Context.hasSameType(CallOpSpecialized.$deref().getReturnType(), 
      new QualType(ReturnTypeOfDestFunctionPtr))) {
    return Sema.TemplateDeductionResult.TDK_NonDeducedMismatch;
  }
  // Since we have succeeded in matching the source and destination
  // ptr-to-functions (now including return type), and have successfully 
  // specialized our corresponding call operator, we are ready to
  // specialize the static invoker with the deduced arguments of our
  // ptr-to-function.
  type$ref<FunctionDecl /*P*/ > InvokerSpecialized = create_type$ref();
  FunctionTemplateDecl /*P*/ InvokerTemplate = LambdaClass.
      getLambdaStaticInvoker().getDescribedFunctionTemplate();
  Sema.TemplateDeductionResult Result = S.FinishTemplateArgumentDeduction(InvokerTemplate, DeducedArguments, 0, 
      InvokerSpecialized, TDInfo)/* __attribute__((unused))*/;
  assert (Result == Sema.TemplateDeductionResult.TDK_Success) : "If the call operator succeeded so should the invoker!";
  // Set the result type to match the corresponding call operator
  // specialization's result type.
  if (GenericLambdaCallOperatorHasDeducedReturnType
     && InvokerSpecialized.$deref().getReturnType().$arrow().isUndeducedType()) {
    // Be sure to get the type to replace 'auto' with and not
    // the full result type of the call op specialization 
    // to substitute into the 'auto' of the invoker and conversion
    // function.
    // For e.g.
    //  int* (*fp)(int*) = [](auto* a) -> auto* { return a; };
    // We don't want to subst 'int*' into 'auto' to get int**.
    QualType TypeToReplaceAutoWith = CallOpSpecialized.$deref().getReturnType().$arrow().
        getContainedAutoType().
        getDeducedType();
    SubstAutoWithinFunctionReturnType(InvokerSpecialized.$deref(), 
        new QualType(TypeToReplaceAutoWith), S);
    SubstAutoWithinFunctionReturnType(ConversionSpecialized, 
        new QualType(TypeToReplaceAutoWith), S);
  }
  
  // Ensure that static invoker doesn't have a const qualifier.
  // FIXME: When creating the InvokerTemplate in SemaLambda.cpp 
  // do not use the CallOperator's TypeSourceInfo which allows
  // the const qualifier to leak through. 
  /*const*/ FunctionProtoType /*P*/ InvokerFPT = InvokerSpecialized.$deref().
    getType().getTypePtr().castAs(FunctionProtoType.class);
  FunctionProtoType.ExtProtoInfo EPI = InvokerFPT.getExtProtoInfo();
  EPI.TypeQuals = 0;
  InvokerSpecialized.$deref().setType(S.Context.getFunctionType(InvokerFPT.getReturnType(), InvokerFPT.getParamTypes(), EPI));
  return Sema.TemplateDeductionResult.TDK_Success;
}


/// \brief Mark the template parameters that are used by the given
/// type.
//<editor-fold defaultstate="collapsed" desc="MarkUsedTemplateParameters">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4728,
 FQN="MarkUsedTemplateParameters", NM="_ZL26MarkUsedTemplateParametersRN5clang10ASTContextENS_8QualTypeEbjRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL26MarkUsedTemplateParametersRN5clang10ASTContextENS_8QualTypeEbjRN4llvm14SmallBitVectorE")
//</editor-fold>
public static void MarkUsedTemplateParameters(final ASTContext /*&*/ Ctx, QualType T, 
                          boolean OnlyDeduced, 
                          /*uint*/int Depth, 
                          final SmallBitVector /*&*/ Used) {
  if (T.isNull()) {
    return;
  }
  
  // Non-dependent types have nothing deducible
  if (!T.$arrow().isDependentType()) {
    return;
  }
  
  T.$assignMove(Ctx.getCanonicalType(new QualType(T)).$QualType());
  switch (T.$arrow().getTypeClass()) {
   case Pointer:
    MarkUsedTemplateParameters(Ctx, 
        cast_PointerType(T).getPointeeType(), 
        OnlyDeduced, 
        Depth, 
        Used);
    break;
   case BlockPointer:
    MarkUsedTemplateParameters(Ctx, 
        cast_BlockPointerType(T).getPointeeType(), 
        OnlyDeduced, 
        Depth, 
        Used);
    break;
   case LValueReference:
   case RValueReference:
    MarkUsedTemplateParameters(Ctx, 
        cast_ReferenceType(T).getPointeeType(), 
        OnlyDeduced, 
        Depth, 
        Used);
    break;
   case MemberPointer:
    {
      /*const*/ MemberPointerType /*P*/ MemPtr = cast_MemberPointerType(T.getTypePtr());
      MarkUsedTemplateParameters(Ctx, MemPtr.getPointeeType(), OnlyDeduced, 
          Depth, Used);
      MarkUsedTemplateParameters(Ctx, new QualType(MemPtr.__getClass(), 0), 
          OnlyDeduced, Depth, Used);
      break;
    }
   case DependentSizedArray:
    MarkUsedTemplateParameters(Ctx, 
        cast_DependentSizedArrayType(T).getSizeExpr(), 
        OnlyDeduced, Depth, Used);
   case ConstantArray:
   case IncompleteArray:
    // Fall through to check the element type
    MarkUsedTemplateParameters(Ctx, 
        cast_ArrayType(T).getElementType(), 
        OnlyDeduced, Depth, Used);
    break;
   case Vector:
   case ExtVector:
    MarkUsedTemplateParameters(Ctx, 
        cast_VectorType(T).getElementType(), 
        OnlyDeduced, Depth, Used);
    break;
   case DependentSizedExtVector:
    {
      /*const*/ DependentSizedExtVectorType /*P*/ VecType = cast_DependentSizedExtVectorType(T);
      MarkUsedTemplateParameters(Ctx, VecType.getElementType(), OnlyDeduced, 
          Depth, Used);
      MarkUsedTemplateParameters(Ctx, VecType.getSizeExpr(), OnlyDeduced, 
          Depth, Used);
      break;
    }
   case FunctionProto:
    {
      /*const*/ FunctionProtoType /*P*/ Proto = cast_FunctionProtoType(T);
      MarkUsedTemplateParameters(Ctx, Proto.getReturnType(), OnlyDeduced, Depth, 
          Used);
      for (/*uint*/int I = 0, N = Proto.getNumParams(); I != N; ++I)  {
        MarkUsedTemplateParameters(Ctx, Proto.getParamType(I), OnlyDeduced, 
            Depth, Used);
      }
      break;
    }
   case TemplateTypeParm:
    {
      /*const*/ TemplateTypeParmType /*P*/ TTP = cast_TemplateTypeParmType(T);
      if (TTP.getDepth() == Depth) {
        Used.set(TTP.getIndex());
      }
      break;
    }
   case SubstTemplateTypeParmPack:
    {
      /*const*/ SubstTemplateTypeParmPackType /*P*/ Subst = cast_SubstTemplateTypeParmPackType(T);
      MarkUsedTemplateParameters(Ctx, 
          new QualType(Subst.getReplacedParameter(), 0), 
          OnlyDeduced, Depth, Used);
      MarkUsedTemplateParameters(Ctx, Subst.getArgumentPack(), 
          OnlyDeduced, Depth, Used);
      break;
    }
   case InjectedClassName:
    T.$assignMove(cast_InjectedClassNameType(T).getInjectedSpecializationType());
   case TemplateSpecialization:
    {
      /*const*/ TemplateSpecializationType /*P*/ Spec = cast_TemplateSpecializationType(T);
      MarkUsedTemplateParameters(Ctx, Spec.getTemplateName(), OnlyDeduced, 
          Depth, Used);
      
      // C++0x [temp.deduct.type]p9:
      //   If the template argument list of P contains a pack expansion that is
      //   not the last template argument, the entire template argument list is a
      //   non-deduced context.
      if (OnlyDeduced
         && hasPackExpansionBeforeEnd(Spec.getArgs(), Spec.getNumArgs())) {
        break;
      }
      
      for (/*uint*/int I = 0, N = Spec.getNumArgs(); I != N; ++I)  {
        MarkUsedTemplateParameters(Ctx, Spec.getArg(I), OnlyDeduced, Depth, 
            Used);
      }
      break;
    }
   case Complex:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_ComplexType(T).getElementType(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case Atomic:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_AtomicType(T).getValueType(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case DependentName:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_DependentNameType(T).getQualifier(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case DependentTemplateSpecialization:
    {
      // C++14 [temp.deduct.type]p5:
      //   The non-deduced contexts are:
      //     -- The nested-name-specifier of a type that was specified using a
      //        qualified-id
      //
      // C++14 [temp.deduct.type]p6:
      //   When a type name is specified in a way that includes a non-deduced
      //   context, all of the types that comprise that type name are also
      //   non-deduced.
      if (OnlyDeduced) {
        break;
      }
      
      /*const*/ DependentTemplateSpecializationType /*P*/ Spec = cast_DependentTemplateSpecializationType(T);
      
      MarkUsedTemplateParameters(Ctx, Spec.getQualifier(), 
          OnlyDeduced, Depth, Used);
      
      for (/*uint*/int I = 0, N = Spec.getNumArgs(); I != N; ++I)  {
        MarkUsedTemplateParameters(Ctx, Spec.getArg(I), OnlyDeduced, Depth, 
            Used);
      }
      break;
    }
   case TypeOf:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_TypeOfType(T).getUnderlyingType(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case TypeOfExpr:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_TypeOfExprType(T).getUnderlyingExpr(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case Decltype:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_DecltypeType(T).getUnderlyingExpr(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case UnaryTransform:
    if (!OnlyDeduced) {
      MarkUsedTemplateParameters(Ctx, 
          cast_UnaryTransformType(T).getUnderlyingType(), 
          OnlyDeduced, Depth, Used);
    }
    break;
   case PackExpansion:
    MarkUsedTemplateParameters(Ctx, 
        cast_PackExpansionType(T).getPattern(), 
        OnlyDeduced, Depth, Used);
    break;
   case Auto:
    MarkUsedTemplateParameters(Ctx, 
        cast_AutoType(T).getDeducedType(), 
        OnlyDeduced, Depth, Used);
   case Builtin:
   case VariableArray:
   case FunctionNoProto:
   case Record:
   case Enum:
   case ObjCInterface:
   case ObjCObject:
   case ObjCObjectPointer:
   case UnresolvedUsing:
   case Pipe:
   case Paren:
   case Typedef:
   case Adjusted:
   case Decayed:
   case Elaborated:
   case Attributed:
   case SubstTemplateTypeParm:
    break;
  }
}


/// \brief If this is a non-static member function,
//<editor-fold defaultstate="collapsed" desc="AddImplicitObjectParameterType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4156,
 FQN="AddImplicitObjectParameterType", NM="_ZL30AddImplicitObjectParameterTypeRN5clang10ASTContextEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL30AddImplicitObjectParameterTypeRN5clang10ASTContextEPNS_13CXXMethodDeclERN4llvm15SmallVectorImplINS_8QualTypeEEE")
//</editor-fold>
public static void AddImplicitObjectParameterType(final ASTContext /*&*/ Context, 
                              CXXMethodDecl /*P*/ Method, 
                              final SmallVectorImpl<QualType> /*&*/ ArgTypes) {
  // C++11 [temp.func.order]p3:
  //   [...] The new parameter is of type "reference to cv A," where cv are
  //   the cv-qualifiers of the function template (if any) and A is
  //   the class of which the function template is a member.
  //
  // The standard doesn't say explicitly, but we pick the appropriate kind of
  // reference type based on [over.match.funcs]p4.
  QualType ArgTy = Context.getTypeDeclType(Method.getParent());
  ArgTy.$assignMove(Context.getQualifiedType(new QualType(ArgTy), 
          Qualifiers.fromCVRMask(Method.getTypeQualifiers())));
  if (Method.getRefQualifier() == RefQualifierKind.RQ_RValue) {
    ArgTy.$assignMove(Context.getRValueReferenceType(new QualType(ArgTy)));
  } else {
    ArgTy.$assignMove(Context.getLValueReferenceType(new QualType(ArgTy)));
  }
  ArgTypes.push_back(ArgTy);
}


/// \brief Determine whether the function template \p FT1 is at least as
/// specialized as \p FT2.
//<editor-fold defaultstate="collapsed" desc="isAtLeastAsSpecializedAs">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4179,
 FQN="isAtLeastAsSpecializedAs", NM="_ZL24isAtLeastAsSpecializedAsRN5clang4SemaENS_14SourceLocationEPNS_20FunctionTemplateDeclES4_NS_30TemplatePartialOrderingContextEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL24isAtLeastAsSpecializedAsRN5clang4SemaENS_14SourceLocationEPNS_20FunctionTemplateDeclES4_NS_30TemplatePartialOrderingContextEj")
//</editor-fold>
public static boolean isAtLeastAsSpecializedAs(final Sema /*&*/ S, 
                        SourceLocation Loc, 
                        FunctionTemplateDecl /*P*/ FT1, 
                        FunctionTemplateDecl /*P*/ FT2, 
                        TemplatePartialOrderingContext TPOC, 
                        /*uint*/int NumCallArguments1) {
  TemplateDeductionInfo Info = null;
  try {
    FunctionDecl /*P*/ FD1 = FT1.getTemplatedDecl();
    FunctionDecl /*P*/ FD2 = FT2.getTemplatedDecl();
    /*const*/ FunctionProtoType /*P*/ Proto1 = FD1.getType().$arrow().getAs(FunctionProtoType.class);
    /*const*/ FunctionProtoType /*P*/ Proto2 = FD2.getType().$arrow().getAs(FunctionProtoType.class);
    assert ((Proto1 != null) && (Proto2 != null)) : "Function templates must have prototypes";
    TemplateParameterList /*P*/ TemplateParams = FT2.getTemplateParameters();
    SmallVector<DeducedTemplateArgument> Deduced/*J*/= new SmallVector<DeducedTemplateArgument>(4, new DeducedTemplateArgument());
    Deduced.resize(TemplateParams.size());
    
    // C++0x [temp.deduct.partial]p3:
    //   The types used to determine the ordering depend on the context in which
    //   the partial ordering is done:
    Info/*J*/= new TemplateDeductionInfo(new SourceLocation(Loc));
    SmallVector<QualType> Args2/*J*/= new SmallVector<QualType>(4, new QualType());
    switch (TPOC.$TPOC()) {
     case TPOC_Call:
      {
        //   - In the context of a function call, the function parameter types are
        //     used.
        CXXMethodDecl /*P*/ Method1 = dyn_cast_CXXMethodDecl(FD1);
        CXXMethodDecl /*P*/ Method2 = dyn_cast_CXXMethodDecl(FD2);
        
        // C++11 [temp.func.order]p3:
        //   [...] If only one of the function templates is a non-static
        //   member, that function template is considered to have a new
        //   first parameter inserted in its function parameter list. The
        //   new parameter is of type "reference to cv A," where cv are
        //   the cv-qualifiers of the function template (if any) and A is
        //   the class of which the function template is a member.
        //
        // Note that we interpret this to mean "if one of the function
        // templates is a non-static member and the other is a non-member";
        // otherwise, the ordering rules for static functions against non-static
        // functions don't make any sense.
        //
        // C++98/03 doesn't have this provision but we've extended DR532 to cover
        // it as wording was broken prior to it.
        SmallVector<QualType> Args1/*J*/= new SmallVector<QualType>(4, new QualType());
        
        /*uint*/int NumComparedArguments = NumCallArguments1;
        if (!(Method2 != null) && (Method1 != null) && !Method1.isStatic()) {
          // Compare 'this' from Method1 against first parameter from Method2.
          AddImplicitObjectParameterType(S.Context, Method1, Args1);
          ++NumComparedArguments;
        } else if (!(Method1 != null) && (Method2 != null) && !Method2.isStatic()) {
          // Compare 'this' from Method2 against first parameter from Method1.
          AddImplicitObjectParameterType(S.Context, Method2, Args2);
        }
        
        Args1.insert$T$value_T(Args1.end(), Proto1.param_type_begin(), 
            Proto1.param_type_end());
        Args2.insert$T$value_T(Args2.end(), Proto2.param_type_begin(), 
            Proto2.param_type_end());
        
        // C++ [temp.func.order]p5:
        //   The presence of unused ellipsis and default arguments has no effect on
        //   the partial ordering of function templates.
        if ($greater_uint(Args1.size(), NumComparedArguments)) {
          Args1.resize(NumComparedArguments);
        }
        if ($greater_uint(Args2.size(), NumComparedArguments)) {
          Args2.resize(NumComparedArguments);
        }
        if ((DeduceTemplateArguments(S, TemplateParams, Args2.data(), Args2.size(), 
            Args1.data(), Args1.size(), Info, Deduced, 
            TemplateDeductionFlags.TDF_None, /*PartialOrdering=*/ true).getValue() != 0)) {
          return false;
        }
        
        break;
      }
     case TPOC_Conversion:
      //   - In the context of a call to a conversion operator, the return types
      //     of the conversion function templates are used.
      if ((DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, Proto2.getReturnType(), Proto1.getReturnType(), 
          Info, Deduced, TemplateDeductionFlags.TDF_None, 
          /*PartialOrdering=*/ true).getValue() != 0)) {
        return false;
      }
      break;
     case TPOC_Other:
      //   - In other contexts (14.6.6.2) the function template's function type
      //     is used.
      if ((DeduceTemplateArgumentsByTypeMatch(S, TemplateParams, 
          FD2.getType(), FD1.getType(), 
          Info, Deduced, TemplateDeductionFlags.TDF_None, 
          /*PartialOrdering=*/ true).getValue() != 0)) {
        return false;
      }
      break;
    }
    
    // C++0x [temp.deduct.partial]p11:
    //   In most cases, all template parameters must have values in order for
    //   deduction to succeed, but for partial ordering purposes a template
    //   parameter may remain without a value provided it is not used in the
    //   types being used for partial ordering. [ Note: a template parameter used
    //   in a non-deduced context is considered used. -end note]
    /*uint*/int ArgIdx = 0, NumArgs = Deduced.size();
    for (; ArgIdx != NumArgs; ++ArgIdx)  {
      if (Deduced.$at(ArgIdx).isNull()) {
        break;
      }
    }
    if (ArgIdx == NumArgs) {
      // All template arguments were deduced. FT1 is at least as specialized
      // as FT2.
      return true;
    }
    
    // Figure out which template parameters were used.
    SmallBitVector UsedParameters/*J*/= new SmallBitVector(TemplateParams.size());
    switch (TPOC.$TPOC()) {
     case TPOC_Call:
      for (/*uint*/int I = 0, N = Args2.size(); I != N; ++I)  {
        /*::*/MarkUsedTemplateParameters(S.Context, new QualType(Args2.$at(I)), false, 
            TemplateParams.getDepth(), 
            UsedParameters);
      }
      break;
     case TPOC_Conversion:
      /*::*/MarkUsedTemplateParameters(S.Context, Proto2.getReturnType(), false, 
          TemplateParams.getDepth(), UsedParameters);
      break;
     case TPOC_Other:
      /*::*/MarkUsedTemplateParameters(S.Context, FD2.getType(), false, 
          TemplateParams.getDepth(), 
          UsedParameters);
      break;
    }
    
    for (; ArgIdx != NumArgs; ++ArgIdx)  {
      // If this argument had no value deduced but was used in one of the types
      // used for partial ordering, then deduction fails.
      if (Deduced.$at(ArgIdx).isNull() && UsedParameters.$at$Const(ArgIdx)) {
        return false;
      }
    }
    
    return true;
  } finally {
    if (Info != null) { Info.$destroy(); }
  }
}


/// \brief Determine whether this a function template whose parameter-type-list
/// ends with a function parameter pack.
//<editor-fold defaultstate="collapsed" desc="isVariadicFunctionTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4326,
 FQN="isVariadicFunctionTemplate", NM="_ZL26isVariadicFunctionTemplatePN5clang20FunctionTemplateDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL26isVariadicFunctionTemplatePN5clang20FunctionTemplateDeclE")
//</editor-fold>
public static boolean isVariadicFunctionTemplate(FunctionTemplateDecl /*P*/ FunTmpl) {
  FunctionDecl /*P*/ Function = FunTmpl.getTemplatedDecl();
  /*uint*/int NumParams = Function.getNumParams();
  if (NumParams == 0) {
    return false;
  }
  
  ParmVarDecl /*P*/ Last = Function.getParamDecl(NumParams - 1);
  if (!Last.isParameterPack()) {
    return false;
  }
  
  // Make sure that no previous parameter is a parameter pack.
  while ($greater_uint(--NumParams, 0)) {
    if (Function.getParamDecl(NumParams - 1).isParameterPack()) {
      return false;
    }
  }
  
  return true;
}


/// \brief Determine if the two templates are equivalent.
//<editor-fold defaultstate="collapsed" desc="isSameTemplate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4393,
 FQN="isSameTemplate", NM="_ZL14isSameTemplatePN5clang12TemplateDeclES1_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL14isSameTemplatePN5clang12TemplateDeclES1_")
//</editor-fold>
public static boolean isSameTemplate(TemplateDecl /*P*/ T1, TemplateDecl /*P*/ T2) {
  if (T1 == T2) {
    return true;
  }
  if (!(T1 != null) || !(T2 != null)) {
    return false;
  }
  
  return T1.getCanonicalDecl() == T2.getCanonicalDecl();
}


/// \brief Mark the template parameters that are used by this
/// template argument.
//<editor-fold defaultstate="collapsed" desc="MarkUsedTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4965,
 FQN="MarkUsedTemplateParameters", NM="_ZL26MarkUsedTemplateParametersRN5clang10ASTContextERKNS_16TemplateArgumentEbjRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL26MarkUsedTemplateParametersRN5clang10ASTContextERKNS_16TemplateArgumentEbjRN4llvm14SmallBitVectorE")
//</editor-fold>
public static void MarkUsedTemplateParameters(final ASTContext /*&*/ Ctx, 
                          final /*const*/ TemplateArgument /*&*/ TemplateArg, 
                          boolean OnlyDeduced, 
                          /*uint*/int Depth, 
                          final SmallBitVector /*&*/ Used) {
  switch (TemplateArg.getKind()) {
   case Null:
   case Integral:
   case Declaration:
    break;
   case NullPtr:
    MarkUsedTemplateParameters(Ctx, TemplateArg.getNullPtrType(), OnlyDeduced, 
        Depth, Used);
    break;
   case Type:
    MarkUsedTemplateParameters(Ctx, TemplateArg.getAsType(), OnlyDeduced, 
        Depth, Used);
    break;
   case Template:
   case TemplateExpansion:
    MarkUsedTemplateParameters(Ctx, 
        TemplateArg.getAsTemplateOrTemplatePattern(), 
        OnlyDeduced, Depth, Used);
    break;
   case Expression:
    MarkUsedTemplateParameters(Ctx, TemplateArg.getAsExpr(), OnlyDeduced, 
        Depth, Used);
    break;
   case Pack:
    for (final /*const*/ TemplateArgument /*&*/ P : TemplateArg.pack_elements())  {
      MarkUsedTemplateParameters(Ctx, P, OnlyDeduced, Depth, Used);
    }
    break;
  }
}


/// \brief Mark the template parameters that are used by the given
/// expression.
//<editor-fold defaultstate="collapsed" desc="MarkUsedTemplateParameters">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4647,
 FQN="MarkUsedTemplateParameters", NM="_ZL26MarkUsedTemplateParametersRN5clang10ASTContextEPKNS_4ExprEbjRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL26MarkUsedTemplateParametersRN5clang10ASTContextEPKNS_4ExprEbjRN4llvm14SmallBitVectorE")
//</editor-fold>
public static void MarkUsedTemplateParameters(final ASTContext /*&*/ Ctx, 
                          /*const*/ Expr /*P*/ E, 
                          boolean OnlyDeduced, 
                          /*uint*/int Depth, 
                          final SmallBitVector /*&*/ Used) {
  {
    // We can deduce from a pack expansion.
    /*const*/ PackExpansionExpr /*P*/ Expansion = dyn_cast_PackExpansionExpr(E);
    if ((Expansion != null)) {
      E = Expansion.getPattern$Const();
    }
  }
  
  // Skip through any implicit casts we added while type-checking, and any
  // substitutions performed by template alias expansion.
  while (true) {
    {
      /*const*/ ImplicitCastExpr /*P*/ ICE = dyn_cast_ImplicitCastExpr(E);
      if ((ICE != null)) {
        E = ICE.getSubExpr$Const();
      } else {
        /*const*/ SubstNonTypeTemplateParmExpr /*P*/ Subst = dyn_cast_SubstNonTypeTemplateParmExpr(E);
        if ((Subst != null)) {
          E = Subst.getReplacement();
        } else {
          break;
        }
      }
    }
  }
  
  // FIXME: if !OnlyDeduced, we have to walk the whole subexpression to
  // find other occurrences of template parameters.
  /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
  if (!(DRE != null)) {
    return;
  }
  
  /*const*/ NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(DRE.getDecl$Const());
  if (!(NTTP != null)) {
    return;
  }
  if (NTTP.getDepth() == Depth) {
    Used.set(NTTP.getIndex());
  }
}


/// \brief Mark the template parameters that are used by the given
/// nested name specifier.
//<editor-fold defaultstate="collapsed" desc="MarkUsedTemplateParameters">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4686,
 FQN="MarkUsedTemplateParameters", NM="_ZL26MarkUsedTemplateParametersRN5clang10ASTContextEPNS_19NestedNameSpecifierEbjRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL26MarkUsedTemplateParametersRN5clang10ASTContextEPNS_19NestedNameSpecifierEbjRN4llvm14SmallBitVectorE")
//</editor-fold>
public static void MarkUsedTemplateParameters(final ASTContext /*&*/ Ctx, 
                          NestedNameSpecifier /*P*/ NNS, 
                          boolean OnlyDeduced, 
                          /*uint*/int Depth, 
                          final SmallBitVector /*&*/ Used) {
  if (!(NNS != null)) {
    return;
  }
  
  MarkUsedTemplateParameters(Ctx, NNS.getPrefix(), OnlyDeduced, Depth, 
      Used);
  MarkUsedTemplateParameters(Ctx, new QualType(NNS.getAsType(), 0), 
      OnlyDeduced, Depth, Used);
}


/// \brief Mark the template parameters that are used by the given
/// template name.
//<editor-fold defaultstate="collapsed" desc="MarkUsedTemplateParameters">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp", line = 4703,
 FQN="MarkUsedTemplateParameters", NM="_ZL26MarkUsedTemplateParametersRN5clang10ASTContextENS_12TemplateNameEbjRN4llvm14SmallBitVectorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaTemplateDeduction.cpp -nm=_ZL26MarkUsedTemplateParametersRN5clang10ASTContextENS_12TemplateNameEbjRN4llvm14SmallBitVectorE")
//</editor-fold>
public static void MarkUsedTemplateParameters(final ASTContext /*&*/ Ctx, 
                          TemplateName Name, 
                          boolean OnlyDeduced, 
                          /*uint*/int Depth, 
                          final SmallBitVector /*&*/ Used) {
  {
    TemplateDecl /*P*/ Template = Name.getAsTemplateDecl();
    if ((Template != null)) {
      {
        TemplateTemplateParmDecl /*P*/ TTP = dyn_cast_TemplateTemplateParmDecl(Template);
        if ((TTP != null)) {
          if (TTP.getDepth() == Depth) {
            Used.set(TTP.getIndex());
          }
        }
      }
      return;
    }
  }
  {
    
    QualifiedTemplateName /*P*/ QTN = Name.getAsQualifiedTemplateName();
    if ((QTN != null)) {
      MarkUsedTemplateParameters(Ctx, QTN.getQualifier(), OnlyDeduced, 
          Depth, Used);
    }
  }
  {
    DependentTemplateName /*P*/ DTN = Name.getAsDependentTemplateName();
    if ((DTN != null)) {
      MarkUsedTemplateParameters(Ctx, DTN.getQualifier(), OnlyDeduced, 
          Depth, Used);
    }
  }
}

} // END OF class SemaTemplateDeductionStatics
