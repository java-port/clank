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
import org.clank.java.*;
import org.clank.support.*;
import static org.clank.support.Unsigned.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.sema.impl.SemaOverloadStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaOverloadClangGlobals">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang17GetConversionRankENS_22ImplicitConversionKindE;_ZN5clang24MakeDeductionFailureInfoERNS_10ASTContextENS_4Sema23TemplateDeductionResultERNS_4sema21TemplateDeductionInfoE;_ZN5clang25isBetterOverloadCandidateERNS_4SemaERKNS_17OverloadCandidateES4_NS_14SourceLocationEb; -static-type=SemaOverloadClangGlobals -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaOverloadClangGlobals {


/// GetConversionRank - Retrieve the implicit conversion rank
/// corresponding to the given implicit conversion kind.
//<editor-fold defaultstate="collapsed" desc="clang::GetConversionRank">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 108,
 FQN="clang::GetConversionRank", NM="_ZN5clang17GetConversionRankENS_22ImplicitConversionKindE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang17GetConversionRankENS_22ImplicitConversionKindE")
//</editor-fold>
public static ImplicitConversionRank GetConversionRank(ImplicitConversionKind Kind) {
  final/*static*/ /*const*/ ImplicitConversionRank Rank[/*26*/] = GetConversionRank$$.Rank;
  return Rank[(int)Kind.getValue()];
}
private static final class GetConversionRank$$ {
  static final/*static*/ /*const*/ ImplicitConversionRank Rank[/*26*/] = new /*const*/ ImplicitConversionRank [/*26*/] {
  ImplicitConversionRank.ICR_Exact_Match, 
  ImplicitConversionRank.ICR_Exact_Match, 
  ImplicitConversionRank.ICR_Exact_Match, 
  ImplicitConversionRank.ICR_Exact_Match, 
  ImplicitConversionRank.ICR_Exact_Match, 
  ImplicitConversionRank.ICR_Exact_Match, 
  ImplicitConversionRank.ICR_Promotion, 
  ImplicitConversionRank.ICR_Promotion, 
  ImplicitConversionRank.ICR_Promotion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Complex_Real_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Conversion, 
  ImplicitConversionRank.ICR_Writeback_Conversion, 
  ImplicitConversionRank.ICR_Exact_Match,  // NOTE(gbiv): This may not be completely right --
  // it was omitted by the patch that added
  // ICK_Zero_Event_Conversion
  ImplicitConversionRank.ICR_C_Conversion
};
}


/// isBetterOverloadCandidate - Determines whether the first overload
/// candidate is a better candidate than the second (C++ 13.3.3p1).
//<editor-fold defaultstate="collapsed" desc="clang::isBetterOverloadCandidate">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 8548,
 FQN="clang::isBetterOverloadCandidate", NM="_ZN5clang25isBetterOverloadCandidateERNS_4SemaERKNS_17OverloadCandidateES4_NS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang25isBetterOverloadCandidateERNS_4SemaERKNS_17OverloadCandidateES4_NS_14SourceLocationEb")
//</editor-fold>
public static boolean isBetterOverloadCandidate(final Sema /*&*/ S, final /*const*/ OverloadCandidate /*&*/ Cand1, 
                         final /*const*/ OverloadCandidate /*&*/ Cand2, 
                         SourceLocation Loc) {
  return isBetterOverloadCandidate(S, Cand1, 
                         Cand2, 
                         Loc, 
                         false);
}
public static boolean isBetterOverloadCandidate(final Sema /*&*/ S, final /*const*/ OverloadCandidate /*&*/ Cand1, 
                         final /*const*/ OverloadCandidate /*&*/ Cand2, 
                         SourceLocation Loc, 
                         boolean UserDefinedConversion/*= false*/) {
  // Define viable functions to be better candidates than non-viable
  // functions.
  if (!Cand2.Viable) {
    return Cand1.Viable;
  } else if (!Cand1.Viable) {
    return false;
  }
  
  // C++ [over.match.best]p1:
  //
  //   -- if F is a static member function, ICS1(F) is defined such
  //      that ICS1(F) is neither better nor worse than ICS1(G) for
  //      any function G, and, symmetrically, ICS1(G) is neither
  //      better nor worse than ICS1(F).
  /*uint*/int StartArg = 0;
  if (Cand1.IgnoreObjectArgument || Cand2.IgnoreObjectArgument) {
    StartArg = 1;
  }
  
  // C++ [over.match.best]p1:
  //   A viable function F1 is defined to be a better function than another
  //   viable function F2 if for all arguments i, ICSi(F1) is not a worse
  //   conversion sequence than ICSi(F2), and then...
  /*uint*/int NumArgs = Cand1.NumConversions;
  assert (Cand2.NumConversions == NumArgs) : "Overload candidate mismatch";
  boolean HasBetterConversion = false;
  for (/*uint*/int ArgIdx = StartArg; $less_uint(ArgIdx, NumArgs); ++ArgIdx) {
    switch (CompareImplicitConversionSequences(S, new SourceLocation(Loc), 
        Cand1.Conversions[ArgIdx], 
        Cand2.Conversions[ArgIdx])) {
     case Better:
      // Cand1 has a better conversion sequence.
      HasBetterConversion = true;
      break;
     case Worse:
      // Cand1 can't be better than Cand2.
      return false;
     case Indistinguishable:
      // Do nothing.
      break;
    }
  }
  
  //    -- for some argument j, ICSj(F1) is a better conversion sequence than
  //       ICSj(F2), or, if not that,
  if (HasBetterConversion) {
    return true;
  }
  
  //   -- the context is an initialization by user-defined conversion
  //      (see 8.5, 13.3.1.5) and the standard conversion sequence
  //      from the return type of F1 to the destination type (i.e.,
  //      the type of the entity being initialized) is a better
  //      conversion sequence than the standard conversion sequence
  //      from the return type of F2 to the destination type.
  if (UserDefinedConversion && (Cand1.Function != null) && (Cand2.Function != null)
     && isa_CXXConversionDecl(Cand1.Function)
     && isa_CXXConversionDecl(Cand2.Function)) {
    // First check whether we prefer one of the conversion functions over the
    // other. This only distinguishes the results in non-standard, extension
    // cases such as the conversion from a lambda closure type to a function
    // pointer or block.
    ImplicitConversionSequence.CompareKind Result = compareConversionFunctions(S, Cand1.Function, Cand2.Function);
    if (Result == ImplicitConversionSequence.CompareKind.Indistinguishable) {
      Result = CompareStandardConversionSequences(S, new SourceLocation(Loc), 
          Cand1.Unnamed_field12.FinalConversion, 
          Cand2.Unnamed_field12.FinalConversion);
    }
    if (Result != ImplicitConversionSequence.CompareKind.Indistinguishable) {
      return Result == ImplicitConversionSequence.CompareKind.Better;
    }
    // FIXME: Compare kind of reference binding if conversion functions
    // convert to a reference type used in direct reference binding, per
    // C++14 [over.match.best]p1 section 2 bullet 3.
  }
  
  //    -- F1 is a non-template function and F2 is a function template
  //       specialization, or, if not that,
  boolean Cand1IsSpecialization = (Cand1.Function != null)
     && (Cand1.Function.getPrimaryTemplate() != null);
  boolean Cand2IsSpecialization = (Cand2.Function != null)
     && (Cand2.Function.getPrimaryTemplate() != null);
  if (Cand1IsSpecialization != Cand2IsSpecialization) {
    return Cand2IsSpecialization;
  }
  
  //   -- F1 and F2 are function template specializations, and the function
  //      template for F1 is more specialized than the template for F2
  //      according to the partial ordering rules described in 14.5.5.2, or,
  //      if not that,
  if (Cand1IsSpecialization && Cand2IsSpecialization) {
    {
      FunctionTemplateDecl /*P*/ BetterTemplate = S.getMoreSpecializedTemplate(Cand1.Function.getPrimaryTemplate(), 
          Cand2.Function.getPrimaryTemplate(), 
          new SourceLocation(Loc), 
          new TemplatePartialOrderingContext(isa_CXXConversionDecl(Cand1.Function) ? TPOC.TPOC_Conversion : TPOC.TPOC_Call), 
          Cand1.ExplicitCallArguments, 
          Cand2.ExplicitCallArguments);
      if ((BetterTemplate != null)) {
        return BetterTemplate == Cand1.Function.getPrimaryTemplate();
      }
    }
  }
  
  // FIXME: Work around a defect in the C++17 inheriting constructor wording.
  // A derived-class constructor beats an (inherited) base class constructor.
  boolean Cand1IsInherited = (dyn_cast_or_null_ConstructorUsingShadowDecl(Cand1.FoundDecl.getDecl()) != null);
  boolean Cand2IsInherited = (dyn_cast_or_null_ConstructorUsingShadowDecl(Cand2.FoundDecl.getDecl()) != null);
  if (Cand1IsInherited != Cand2IsInherited) {
    return Cand2IsInherited;
  } else if (Cand1IsInherited) {
    assert (Cand2IsInherited);
    CXXRecordDecl /*P*/ Cand1Class = cast_CXXRecordDecl(Cand1.Function.getDeclContext());
    CXXRecordDecl /*P*/ Cand2Class = cast_CXXRecordDecl(Cand2.Function.getDeclContext());
    if (Cand1Class.isDerivedFrom(Cand2Class)) {
      return true;
    }
    if (Cand2Class.isDerivedFrom(Cand1Class)) {
      return false;
    }
    // Inherited from sibling base classes: still ambiguous.
  }
  
  // Check for enable_if value-based overload resolution.
  if ((Cand1.Function != null) && (Cand2.Function != null)) {
    Comparison Cmp = compareEnableIfAttrs(S, Cand1.Function, Cand2.Function);
    if (Cmp != Comparison.Equal) {
      return Cmp == Comparison.Better;
    }
  }
  if (S.getLangOpts().CUDA && (Cand1.Function != null) && (Cand2.Function != null)) {
    FunctionDecl /*P*/ Caller = dyn_cast_FunctionDecl(S.CurContext);
    return S.IdentifyCUDAPreference(Caller, Cand1.Function).getValue()
       > S.IdentifyCUDAPreference(Caller, Cand2.Function).getValue();
  }
  
  boolean HasPS1 = Cand1.Function != null
     && functionHasPassObjectSizeParams(Cand1.Function);
  boolean HasPS2 = Cand2.Function != null
     && functionHasPassObjectSizeParams(Cand2.Function);
  return HasPS1 != HasPS2 && HasPS1;
}


/// \brief Convert from Sema's representation of template deduction information
/// to the form used in overload-candidate information.
//<editor-fold defaultstate="collapsed" desc="clang::MakeDeductionFailureInfo">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC/*correct initialization of Result in case of TDK_SubstitutionFailure*/,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp", line = 564,
 FQN="clang::MakeDeductionFailureInfo", NM="_ZN5clang24MakeDeductionFailureInfoERNS_10ASTContextENS_4Sema23TemplateDeductionResultERNS_4sema21TemplateDeductionInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaOverload.cpp -nm=_ZN5clang24MakeDeductionFailureInfoERNS_10ASTContextENS_4Sema23TemplateDeductionResultERNS_4sema21TemplateDeductionInfoE")
//</editor-fold>
public static DeductionFailureInfo MakeDeductionFailureInfo(final ASTContext /*&*/ Context, 
                        Sema.TemplateDeductionResult TDK, 
                        final TemplateDeductionInfo /*&*/ Info) {
  DeductionFailureInfo Result/*J*/= new DeductionFailureInfo();
  Result.Result = $uint2uint_8bits(((/*static_cast*//*uint*/int)(TDK.getValue())));
  Result.HasDiagnostic = false;
  switch (TDK) {
   case TDK_Success:
   case TDK_Invalid:
   case TDK_InstantiationDepth:
   case TDK_TooManyArguments:
   case TDK_TooFewArguments:
   case TDK_MiscellaneousDeductionFailure:
    Result.Data = null;
    break;
   case TDK_Incomplete:
   case TDK_InvalidExplicitArguments:
    Result.Data = Info.Param.getOpaqueValue();
    break;
   case TDK_DeducedMismatch:
    {
      // FIXME: Should allocate from normal heap so that we can free this later.
      DFIDeducedMismatchArgs /*P*/ Saved = /*FIXME:NEW_EXPR*//*new (Context)*/ new DFIDeducedMismatchArgs();
      Saved.FirstArg.$assign(Info.FirstArg);
      Saved.SecondArg.$assign(Info.SecondArg);
      Saved.TemplateArgs = Info.take();
      Saved.CallArgIndex = Info.Unnamed_field7.CallArgIndex;
      Result.Data = Saved;
      break;
    }
   case TDK_NonDeducedMismatch:
    {
      // FIXME: Should allocate from normal heap so that we can free this later.
      DFIArguments /*P*/ Saved = /*FIXME:NEW_EXPR*//*new (Context)*/ new DFIArguments();
      Saved.FirstArg.$assign(Info.FirstArg);
      Saved.SecondArg.$assign(Info.SecondArg);
      Result.Data = Saved;
      break;
    }
   case TDK_Inconsistent:
   case TDK_Underqualified:
    {
      // FIXME: Should allocate from normal heap so that we can free this later.
      DFIParamWithArguments /*P*/ Saved = /*FIXME:NEW_EXPR*//*new (Context)*/ new DFIParamWithArguments();
      Saved.Param.$assign(Info.Param);
      Saved.FirstArg.$assign(Info.FirstArg);
      Saved.SecondArg.$assign(Info.SecondArg);
      Result.Data = Saved;
      break;
    }
   case TDK_SubstitutionFailure:
    Result.Data = Info.take();
    if (Info.hasSFINAEDiagnostic()) {
      std.pair<SourceLocation, PartialDiagnostic> /*P*/ Diag = Result.Unnamed_field3.Diagnostic;
      Diag.first.$assign(new SourceLocation());
      Diag.second.$MemoryCopy(new PartialDiagnostic(new PartialDiagnostic.NullDiagnostic()));
      Info.takeSFINAEDiagnostic($Deref(Diag));
      Result.HasDiagnostic = true;
    }
    break;
   case TDK_FailedOverloadResolution:
    Result.Data = Info.Unnamed_field7.Expression;
    break;
  }
  
  return Result;
}

} // END OF class SemaOverloadClangGlobals
