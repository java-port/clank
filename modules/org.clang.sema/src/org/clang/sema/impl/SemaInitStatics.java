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
import static org.llvm.support.llvm.*;
import static org.clank.support.NativePointer.*;
import static org.clank.support.Native.*;
import static org.clank.support.Unsigned.*;
import org.llvm.support.*;
import org.llvm.adt.*;
import org.llvm.adt.aliases.*;
import org.clang.ast.*;
import org.clang.basic.*;
import org.clang.sema.*;
import static org.clang.basic.PartialDiagnostic.*;
import static org.clang.sema.Sema_NestedClasses.SemaDiagnosticBuilder.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.ast.java.AstRTTI.*;
import static org.clang.ast.AstClangGlobals.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaInitStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL10CopyObjectRN5clang4SemaENS_8QualTypeERKNS_17InitializedEntityENS_12ActionResultIPNS_4ExprELb1EEEb;_ZL12IsStringInitPN5clang4ExprENS_8QualTypeERNS_10ASTContextE;_ZL12IsStringInitPN5clang4ExprEPKNS_9ArrayTypeERNS_10ASTContextE;_ZL15CheckStringInitPN5clang4ExprERNS_8QualTypeEPKNS_9ArrayTypeERNS_4SemaE;_ZL16diagnoseListInitRN5clang4SemaERKNS_17InitializedEntityEPNS_12InitListExprE;_ZL18isInvalidICRSourceRN5clang10ASTContextEPNS_4ExprEbRb;_ZL18isReferenceBindingRKN5clang22InitializationSequence4StepE;_ZL19getAssignmentActionRKN5clang17InitializedEntityEb;_ZL19isExplicitTemporaryRKN5clang17InitializedEntityERKNS_18InitializationKindEj;_ZL20IsWideCharCompatibleN5clang8QualTypeERNS_10ASTContextE;_ZL20getInitializationLocRKN5clang17InitializedEntityEPNS_4ExprE;_ZL20warnBracedScalarInitRN5clang4SemaERKNS_17InitializedEntityENS_11SourceRangeE;_ZL21TryListInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_12InitListExprERNS_22InitializationSequenceEb;_ZL21shouldBindAsTemporaryRKN5clang17InitializedEntityE;_ZL22MaybeProduceObjCObjectRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityE;_ZL22TryValueInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindERNS_22InitializationSequenceEPNS_12InitListExprE;_ZL22emitBadConversionNotesRN5clang4SemaERKNS_17InitializedEntityEPNS_4ExprE;_ZL22shouldDestroyTemporaryRKN5clang17InitializedEntityE;_ZL23CheckMoveOnConstructionRN5clang4SemaEPKNS_4ExprEb;_ZL23CloneDesignatedInitExprRN5clang4SemaEPNS_18DesignatedInitExprE;_ZL23hasCompatibleArrayTypesRN5clang10ASTContextEPKNS_9ArrayTypeES4_;_ZL23updateStringLiteralTypePN5clang4ExprENS_8QualTypeE;_ZL23warnOnLifetimeExtensionRN5clang4SemaERKNS_17InitializedEntityEPKNS_4ExprEbPKNS_9ValueDeclE;_ZL24CheckArrayDesignatorExprRN5clang4SemaEPNS_4ExprERN4llvm6APSIntE;_ZL24TryDefaultInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindERNS_22InitializationSequenceE;_ZL24TryUserDefinedConversionRN5clang4SemaENS_8QualTypeERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceEb;_ZL24performLifetimeExtensionPN5clang4ExprEPKNS_17InitializedEntityE;_ZL25performReferenceExtensionPN5clang4ExprEPKNS_17InitializedEntityE;_ZL26ResolveConstructorOverloadRN5clang4SemaENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetENS_23DeclContextLookupResultERPNS_17OverloadCandidateEbbbb;_ZL26TryReferenceInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceE;_ZL26tryObjCWritebackConversionRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityEPNS_4ExprE;_ZL27DiagnoseNarrowingInInitListRN5clang4SemaERKNS_26ImplicitConversionSequenceENS_8QualTypeES5_PKNS_4ExprE;_ZL27TryOCLSamplerInitializationRN5clang4SemaERNS_22InitializationSequenceENS_8QualTypeEPNS_4ExprE;_ZL28TryConstructorInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8QualTypeERNS_22InitializationSequenceEbb;_ZL29LookupCopyAndMoveConstructorsRN5clang4SemaERNS_20OverloadCandidateSetEPNS_13CXXRecordDeclEPNS_4ExprE;_ZL29TryOCLZeroEventInitializationRN5clang4SemaERNS_22InitializationSequenceENS_8QualTypeEPNS_4ExprE;_ZL29isExprAnUnaddressableFunctionRN5clang4SemaEPKNS_4ExprE;_ZL30CheckCXX98CompatAccessibleCopyRN5clang4SemaERKNS_17InitializedEntityEPNS_4ExprE;_ZL30CheckForNullPointerDereferenceRN5clang4SemaEPKNS_4ExprE;_ZL30DiagnoseUninitializedReferenceRN5clang4SemaENS_14SourceLocationENS_8QualTypeE;_ZL30ExpandAnonymousFieldDesignatorRN5clang4SemaEPNS_18DesignatedInitExprEjPNS_17IndirectFieldDeclE;_ZL30TryInitializerListConstructionRN5clang4SemaEPNS_12InitListExprENS_8QualTypeERNS_22InitializationSequenceEb;_ZL30TryReferenceInitializationCoreRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprENS_8QualTypeESA_NS_10QualifiersESA_SA_SB_RNS_22InitializationSequenceE;_ZL30TryReferenceListInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_12InitListExprERNS_22InitializationSequenceEb;_ZL30TryStringLiteralInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceE;_ZL30checkIndirectCopyRestoreSourceRN5clang4SemaEPNS_4ExprE;_ZL32PerformConstructorInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEERKNS_22InitializationSequence4StepERbbbNS_14SourceLocationESI_;_ZL32TryRefInitWithConversionFunctionRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprEbRNS_22InitializationSequenceE;_ZL33isLibstdcxxPointerReturnFalseHackRN5clang4SemaERKNS_17InitializedEntityEPKNS_4ExprE;_ZL34maybeRecoverWithZeroInitializationRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityE;_ZL38getEntityForTemporaryLifetimeExtensionPKN5clang17InitializedEntityES2_;_ZL39InitializedEntityOutlivesFullExpressionRKN5clang17InitializedEntityE;_ZL40convertQualifiersAndValueKindIfNecessaryRN5clang4SemaERNS_22InitializationSequenceEPNS_4ExprENS_8QualTypeENS_10QualifiersES7_b;_ZL44ResolveOverloadedFunctionForReferenceBindingRN5clang4SemaEPNS_4ExprERNS_8QualTypeES5_S4_RNS_22InitializationSequenceE; -static-type=SemaInitStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaInitStatics {


//===----------------------------------------------------------------------===//
// Sema Initialization Checking
//===----------------------------------------------------------------------===//

/// \brief Check whether T is compatible with a wide character type (wchar_t,
/// char16_t or char32_t).
//<editor-fold defaultstate="collapsed" desc="IsWideCharCompatible">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 38,
 FQN="IsWideCharCompatible", NM="_ZL20IsWideCharCompatibleN5clang8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL20IsWideCharCompatibleN5clang8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static boolean IsWideCharCompatible(QualType T, final ASTContext /*&*/ Context) {
  if (Context.typesAreCompatible(Context.getWideCharType(), new QualType(T))) {
    return true;
  }
  if (Context.getLangOpts().CPlusPlus || Context.getLangOpts().C11) {
    return Context.typesAreCompatible(Context.Char16Ty.$QualType(), new QualType(T))
       || Context.typesAreCompatible(Context.Char32Ty.$QualType(), new QualType(T));
  }
  return false;
}


/// \brief Check whether the array of type AT can be initialized by the Init
/// expression by means of string initialization. Returns SIF_None if so,
/// otherwise returns a StringInitFailureKind that describes why the
/// initialization would not work.
//<editor-fold defaultstate="collapsed" desc="IsStringInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 60,
 FQN="IsStringInit", NM="_ZL12IsStringInitPN5clang4ExprEPKNS_9ArrayTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL12IsStringInitPN5clang4ExprEPKNS_9ArrayTypeERNS_10ASTContextE")
//</editor-fold>
public static StringInitFailureKind IsStringInit(Expr /*P*/ Init, /*const*/ ArrayType /*P*/ AT, 
            final ASTContext /*&*/ Context) {
  if (!isa_ConstantArrayType(AT) && !isa_IncompleteArrayType(AT)) {
    return StringInitFailureKind.SIF_Other;
  }
  
  // See if this is a string literal or @encode.
  Init = Init.IgnoreParens();
  
  // Handle @encode, which is a narrow string.
  if (isa_ObjCEncodeExpr(Init) && AT.getElementType().$arrow().isCharType()) {
    return StringInitFailureKind.SIF_None;
  }
  
  // Otherwise we can only handle string literals.
  StringLiteral /*P*/ SL = dyn_cast_StringLiteral(Init);
  if (!(SL != null)) {
    return StringInitFailureKind.SIF_Other;
  }
  
  /*const*/ QualType ElemTy = Context.getCanonicalType(AT.getElementType()).getUnqualifiedType().$QualType();
  switch (SL.getKind()) {
   case Ascii:
   case UTF8:
    // char array can be initialized with a narrow string.
    // Only allow char x[] = "foo";  not char x[] = L"foo";
    if (ElemTy.$arrow().isCharType()) {
      return StringInitFailureKind.SIF_None;
    }
    if (IsWideCharCompatible(new QualType(ElemTy), Context)) {
      return StringInitFailureKind.SIF_NarrowStringIntoWideChar;
    }
    return StringInitFailureKind.SIF_Other;
   case UTF16:
    // C99 6.7.8p15 (with correction from DR343), or C11 6.7.9p15:
    // "An array with element type compatible with a qualified or unqualified
    // version of wchar_t, char16_t, or char32_t may be initialized by a wide
    // string literal with the corresponding encoding prefix (L, u, or U,
    // respectively), optionally enclosed in braces.
    if (Context.typesAreCompatible(Context.Char16Ty.$QualType(), new QualType(ElemTy))) {
      return StringInitFailureKind.SIF_None;
    }
    if (ElemTy.$arrow().isCharType()) {
      return StringInitFailureKind.SIF_WideStringIntoChar;
    }
    if (IsWideCharCompatible(new QualType(ElemTy), Context)) {
      return StringInitFailureKind.SIF_IncompatWideStringIntoWideChar;
    }
    return StringInitFailureKind.SIF_Other;
   case UTF32:
    if (Context.typesAreCompatible(Context.Char32Ty.$QualType(), new QualType(ElemTy))) {
      return StringInitFailureKind.SIF_None;
    }
    if (ElemTy.$arrow().isCharType()) {
      return StringInitFailureKind.SIF_WideStringIntoChar;
    }
    if (IsWideCharCompatible(new QualType(ElemTy), Context)) {
      return StringInitFailureKind.SIF_IncompatWideStringIntoWideChar;
    }
    return StringInitFailureKind.SIF_Other;
   case Wide:
    if (Context.typesAreCompatible(Context.getWideCharType(), new QualType(ElemTy))) {
      return StringInitFailureKind.SIF_None;
    }
    if (ElemTy.$arrow().isCharType()) {
      return StringInitFailureKind.SIF_WideStringIntoChar;
    }
    if (IsWideCharCompatible(new QualType(ElemTy), Context)) {
      return StringInitFailureKind.SIF_IncompatWideStringIntoWideChar;
    }
    return StringInitFailureKind.SIF_Other;
  }
  throw new llvm_unreachable("missed a StringLiteral kind?");
}

//<editor-fold defaultstate="collapsed" desc="IsStringInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 124,
 FQN="IsStringInit", NM="_ZL12IsStringInitPN5clang4ExprENS_8QualTypeERNS_10ASTContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL12IsStringInitPN5clang4ExprENS_8QualTypeERNS_10ASTContextE")
//</editor-fold>
public static StringInitFailureKind IsStringInit(Expr /*P*/ init, QualType declType, 
            final ASTContext /*&*/ Context) {
  /*const*/ ArrayType /*P*/ arrayType = Context.getAsArrayType(new QualType(declType));
  if (!(arrayType != null)) {
    return StringInitFailureKind.SIF_Other;
  }
  return IsStringInit(init, arrayType, Context);
}


/// Update the type of a string literal, including any surrounding parentheses,
/// to match the type of the object which it is initializing.
//<editor-fold defaultstate="collapsed" desc="updateStringLiteralType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 134,
 FQN="updateStringLiteralType", NM="_ZL23updateStringLiteralTypePN5clang4ExprENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL23updateStringLiteralTypePN5clang4ExprENS_8QualTypeE")
//</editor-fold>
public static void updateStringLiteralType(Expr /*P*/ E, QualType Ty) {
  while (true) {
    E.setType(new QualType(Ty));
    if (isa_StringLiteral(E) || isa_ObjCEncodeExpr(E)) {
      break;
    } else {
      ParenExpr /*P*/ PE = dyn_cast_ParenExpr(E);
      if ((PE != null)) {
        E = PE.getSubExpr();
      } else {
        UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E);
        if ((UO != null)) {
          E = UO.getSubExpr();
        } else {
          GenericSelectionExpr /*P*/ GSE = dyn_cast_GenericSelectionExpr(E);
          if ((GSE != null)) {
            E = GSE.getResultExpr();
          } else {
            throw new llvm_unreachable("unexpected expr in string literal init");
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckStringInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 150,
 FQN="CheckStringInit", NM="_ZL15CheckStringInitPN5clang4ExprERNS_8QualTypeEPKNS_9ArrayTypeERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL15CheckStringInitPN5clang4ExprERNS_8QualTypeEPKNS_9ArrayTypeERNS_4SemaE")
//</editor-fold>
public static void CheckStringInit(Expr /*P*/ Str, final QualType /*&*/ DeclT, /*const*/ ArrayType /*P*/ AT, 
               final Sema /*&*/ S) {
  // Get the length of the string as parsed.
  /*const*/ ConstantArrayType /*P*/ ConstantArrayTy = cast_ConstantArrayType(Str.getType().$arrow().getAsArrayTypeUnsafe());
  long/*uint64_t*/ StrLength = ConstantArrayTy.getSize().getZExtValue();
  {
    
    /*const*/ IncompleteArrayType /*P*/ IAT = dyn_cast_IncompleteArrayType(AT);
    if ((IAT != null)) {
      // C99 6.7.8p14. We have an array of character type with unknown size
      // being initialized to a string literal.
      APInt ConstVal/*J*/= new APInt(32, StrLength);
      // Return a new array type (C99 6.7.8p22).
      DeclT.$assignMove(S.Context.getConstantArrayType(IAT.getElementType(), 
              ConstVal, 
              ArrayType.ArraySizeModifier.Normal, 0));
      updateStringLiteralType(Str, new QualType(DeclT));
      return;
    }
  }
  
  /*const*/ ConstantArrayType /*P*/ CAT = cast_ConstantArrayType(AT);
  
  // We have an array of character type with known size.  However,
  // the size may be smaller or larger than the string we are initializing.
  // FIXME: Avoid truncation for 64-bit length strings.
  if (S.getLangOpts().CPlusPlus) {
    {
      StringLiteral /*P*/ SL = dyn_cast_StringLiteral(Str.IgnoreParens());
      if ((SL != null)) {
        // For Pascal strings it's OK to strip off the terminating null character,
        // so the example below is valid:
        //
        // unsigned char a[2] = "\pa";
        if (SL.isPascal()) {
          StrLength--;
        }
      }
    }
    
    // [dcl.init.string]p2
    if ($greater_ulong(StrLength, CAT.getSize().getZExtValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Str.getLocStart(), 
                diag.err_initializer_string_for_char_array_too_long)), 
            Str.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  } else {
    // C99 6.7.8p14.
    if ($greater_ullong_ulong(StrLength - 1, CAT.getSize().getZExtValue())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Str.getLocStart(), 
                diag.ext_initializer_string_for_char_array_too_long)), 
            Str.getSourceRange()));
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  // Set the type to the actual size that we are initializing.  If we have
  // something like:
  //   char x[1] = "foo";
  // then this will set the string literal's type to char[1].
  updateStringLiteralType(Str, new QualType(DeclT));
}


/// Warn that \p Entity was of scalar type and was initialized by a
/// single-element braced initializer list.
//<editor-fold defaultstate="collapsed" desc="warnBracedScalarInit">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 892,
 FQN="warnBracedScalarInit", NM="_ZL20warnBracedScalarInitRN5clang4SemaERKNS_17InitializedEntityENS_11SourceRangeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL20warnBracedScalarInitRN5clang4SemaERKNS_17InitializedEntityENS_11SourceRangeE")
//</editor-fold>
public static void warnBracedScalarInit(final Sema /*&*/ S, final /*const*/ InitializedEntity /*&*/ Entity, 
                    SourceRange Braces) {
  // Don't warn during template instantiation. If the initialization was
  // non-dependent, we warned during the initial parse; otherwise, the
  // type might not be scalar in some uses of the template.
  if (!S.ActiveTemplateInstantiations.empty()) {
    return;
  }
  
  /*uint*/int DiagID = 0;
  switch (Entity.getKind()) {
   case EK_VectorElement:
   case EK_ComplexElement:
   case EK_ArrayElement:
   case EK_Parameter:
   case EK_Parameter_CF_Audited:
   case EK_Result:
    // Extra braces here are suspicious.
    DiagID = diag.warn_braces_around_scalar_init;
    break;
   case EK_Member:
    // Warn on aggregate initialization but not on ctor init list or
    // default member initializer.
    if ((Entity.getParent() != null)) {
      DiagID = diag.warn_braces_around_scalar_init;
    }
    break;
   case EK_Variable:
   case EK_LambdaCapture:
    // No warning, might be direct-list-initialization.
    // FIXME: Should we warn for copy-list-initialization in these cases?
    break;
   case EK_New:
   case EK_Temporary:
   case EK_CompoundLiteralInit:
    // No warning, braces are part of the syntax of the underlying construct.
    break;
   case EK_RelatedResult:
    // No warning, we already warned when initializing the result.
    break;
   case EK_Exception:
   case EK_Base:
   case EK_Delegating:
   case EK_BlockElement:
    throw new llvm_unreachable("unexpected braced scalar init");
  }
  if ((DiagID != 0)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Braces.getBegin(), DiagID)), 
                  Braces), 
              FixItHint.CreateRemoval(new SourceRange(Braces.getBegin()))), 
          FixItHint.CreateRemoval(new SourceRange(Braces.getEnd()))));
    } finally {
      $c$.$destroy();
    }
  }
}


/// \brief Expand a field designator that refers to a member of an
/// anonymous struct or union into a series of field designators that
/// refers to the field within the appropriate subobject.
///
//<editor-fold defaultstate="collapsed" desc="ExpandAnonymousFieldDesignator">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1945,
 FQN="ExpandAnonymousFieldDesignator", NM="_ZL30ExpandAnonymousFieldDesignatorRN5clang4SemaEPNS_18DesignatedInitExprEjPNS_17IndirectFieldDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30ExpandAnonymousFieldDesignatorRN5clang4SemaEPNS_18DesignatedInitExprEjPNS_17IndirectFieldDeclE")
//</editor-fold>
public static void ExpandAnonymousFieldDesignator(final Sema /*&*/ SemaRef, 
                              DesignatedInitExpr /*P*/ DIE, 
                              /*uint*/int DesigIdx, 
                              IndirectFieldDecl /*P*/ IndirectField) {
  /*typedef DesignatedInitExpr::Designator Designator*/
//  final class Designator extends DesignatedInitExpr.Designator{ };
  
  // Build the replacement designators.
  SmallVector< DesignatedInitExpr.Designator> Replacements/*J*/= new SmallVector< DesignatedInitExpr.Designator>(4, new  DesignatedInitExpr.Designator());
  for (type$ptr<NamedDecl /*P*/ /*P*/> PI = $tryClone(IndirectField.chain_begin()), 
      /*P*/ PE = $tryClone(IndirectField.chain_end()); $noteq_ptr(PI, PE); PI.$preInc()) {
    if ($eq_ptr(PI.$add(1), PE)) {
      Replacements.push_back(new DesignatedInitExpr.Designator((IdentifierInfo /*P*/ )(IdentifierInfo /*P*/ )null, 
              DIE.getDesignator(DesigIdx).getDotLoc(), 
              DIE.getDesignator(DesigIdx).getFieldLoc()));
    } else {
      Replacements.push_back(new DesignatedInitExpr.Designator((IdentifierInfo /*P*/ )(IdentifierInfo /*P*/ )null, 
              new SourceLocation(), new SourceLocation()));
    }
    assert (isa_FieldDecl(PI.$star()));
    Replacements.back().setField(cast_FieldDecl(PI.$star()));
  }
  
  // Expand the current designator into the set of replacement
  // designators, so we have a full subobject path down to where the
  // member of the anonymous struct/union is actually stored.
  DIE.ExpandDesignator(SemaRef.Context, DesigIdx, $AddrOf(Replacements.ptr$at(0)), 
      $AddrOf(Replacements.ptr$at(0 + Replacements.size())));
}

//<editor-fold defaultstate="collapsed" desc="CloneDesignatedInitExpr">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 1973,
 FQN="CloneDesignatedInitExpr", NM="_ZL23CloneDesignatedInitExprRN5clang4SemaEPNS_18DesignatedInitExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL23CloneDesignatedInitExprRN5clang4SemaEPNS_18DesignatedInitExprE")
//</editor-fold>
public static DesignatedInitExpr /*P*/ CloneDesignatedInitExpr(final Sema /*&*/ SemaRef, 
                       DesignatedInitExpr /*P*/ DIE) {
  /*uint*/int NumIndexExprs = DIE.getNumSubExprs() - 1;
  SmallVector<Expr /*P*/ > IndexExprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 4, NumIndexExprs, (Expr /*P*/ )null);
  for (/*uint*/int I = 0; $less_uint(I, NumIndexExprs); ++I)  {
    IndexExprs.$set(I, DIE.getSubExpr(I + 1));
  }
  return DesignatedInitExpr.Create(SemaRef.Context, new ArrayRef<DesignatedInitExpr.Designator>(JD$Move.INSTANCE, DIE.designators()), 
      new ArrayRef<Expr /*P*/ >(IndexExprs, true), 
      DIE.getEqualOrColonLoc(), 
      DIE.usesGNUSyntax(), DIE.getInit());
}


/// Check that the given Index expression is a valid array designator
/// value. This is essentially just a wrapper around
/// VerifyIntegerConstantExpression that also checks for negative values
/// and produces a reasonable diagnostic if there is a
/// failure. Returns the index expression, possibly with an implicit cast
/// added, on success.  If everything went okay, Value will receive the
/// value of the constant expression.
//<editor-fold defaultstate="collapsed" desc="CheckArrayDesignatorExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 2735,
 FQN="CheckArrayDesignatorExpr", NM="_ZL24CheckArrayDesignatorExprRN5clang4SemaEPNS_4ExprERN4llvm6APSIntE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL24CheckArrayDesignatorExprRN5clang4SemaEPNS_4ExprERN4llvm6APSIntE")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > CheckArrayDesignatorExpr(final Sema /*&*/ S, Expr /*P*/ Index, final APSInt /*&*/ Value) {
  SourceLocation Loc = Index.getLocStart();
  
  // Make sure this is an integer constant expression.
  ActionResultTTrue<Expr /*P*/ > Result = S.VerifyIntegerConstantExpression(Index, $AddrOf(Value));
  if (Result.isInvalid()) {
    return Result;
  }
  if (Value.isSigned() && Value.isNegative()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      return $c$.clean(new ActionResultTTrue<Expr /*P*/ >($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_array_designator_negative)), 
                  Value.__toString(10)), Index.getSourceRange())));
    } finally {
      $c$.$destroy();
    }
  }
  
  Value.setIsUnsigned(true);
  return Result;
}


//===----------------------------------------------------------------------===//
// Attempt initialization
//===----------------------------------------------------------------------===//

/// Tries to add a zero initializer. Returns true if that worked.
//<editor-fold defaultstate="collapsed" desc="maybeRecoverWithZeroInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3347,
 FQN="maybeRecoverWithZeroInitialization", NM="_ZL34maybeRecoverWithZeroInitializationRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL34maybeRecoverWithZeroInitializationRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityE")
//</editor-fold>
public static boolean maybeRecoverWithZeroInitialization(final Sema /*&*/ S, final InitializationSequence /*&*/ Sequence, 
                                  final /*const*/ InitializedEntity /*&*/ Entity) {
  if (Entity.getKind() != InitializedEntity.EntityKind.EK_Variable) {
    return false;
  }
  
  VarDecl /*P*/ VD = cast_VarDecl(Entity.getDecl());
  if ((VD.getInit() != null) || VD.getLocEnd().isMacroID()) {
    return false;
  }
  
  QualType VariableTy = VD.getType().getCanonicalType();
  SourceLocation Loc = S.getLocForEndOfToken(VD.getLocEnd());
  std.string Init = S.getFixItZeroInitializerForType(new QualType(VariableTy), new SourceLocation(Loc));
  if (!Init.empty()) {
    Sequence.AddZeroInitializationStep(Entity.getType());
    Sequence.SetZeroInitializationFixit(Init, new SourceLocation(Loc));
    return true;
  }
  return false;
}

//<editor-fold defaultstate="collapsed" desc="MaybeProduceObjCObject">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3368,
 FQN="MaybeProduceObjCObject", NM="_ZL22MaybeProduceObjCObjectRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL22MaybeProduceObjCObjectRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityE")
//</editor-fold>
public static void MaybeProduceObjCObject(final Sema /*&*/ S, 
                      final InitializationSequence /*&*/ Sequence, 
                      final /*const*/ InitializedEntity /*&*/ Entity) {
  if (!S.getLangOpts().ObjCAutoRefCount) {
    return;
  }
  
  /// When initializing a parameter, produce the value if it's marked
  /// __attribute__((ns_consumed)).
  if (Entity.isParameterKind()) {
    if (!Entity.isParameterConsumed()) {
      return;
    }
    assert (Entity.getType().$arrow().isObjCRetainableType()) : "consuming an object of unretainable type?";
    Sequence.AddProduceObjCObjectStep(Entity.getType());
    /// When initializing a return value, if the return type is a
    /// retainable type, then returns need to immediately retain the
    /// object.  If an autorelease is required, it will be done at the
    /// last instant.
  } else if (Entity.getKind() == InitializedEntity.EntityKind.EK_Result) {
    if (!Entity.getType().$arrow().isObjCRetainableType()) {
      return;
    }
    
    Sequence.AddProduceObjCObjectStep(Entity.getType());
  }
}


/// \brief Attempt list initialization (C++0x [dcl.init.list])
//<editor-fold defaultstate="collapsed" desc="TryListInitialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3750,
 FQN="TryListInitialization", NM="_ZL21TryListInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_12InitListExprERNS_22InitializationSequenceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL21TryListInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_12InitListExprERNS_22InitializationSequenceEb")
//</editor-fold>
public static void TryListInitialization(final Sema /*&*/ S, 
                     final /*const*/ InitializedEntity /*&*/ Entity, 
                     final /*const*/ InitializationKind /*&*/ Kind, 
                     InitListExpr /*P*/ InitList, 
                     final InitializationSequence /*&*/ Sequence, 
                     boolean TreatUnavailableAsInvalid) {
  InitListChecker CheckInitList = null;
  try {
    QualType DestType = Entity.getType();
    
    // C++ doesn't allow scalar initialization with more than one argument.
    // But C99 complex numbers are scalars and it makes sense there.
    if (S.getLangOpts().CPlusPlus && DestType.$arrow().isScalarType()
       && !DestType.$arrow().isAnyComplexType() && $greater_uint(InitList.getNumInits(), 1)) {
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_TooManyInitsForScalar);
      return;
    }
    if (DestType.$arrow().isReferenceType()) {
      TryReferenceListInitialization(S, Entity, Kind, InitList, Sequence, 
          TreatUnavailableAsInvalid);
      return;
    }
    if (DestType.$arrow().isRecordType()
       && !S.isCompleteType(InitList.getLocStart(), new QualType(DestType))) {
      Sequence.setIncompleteTypeFailure(new QualType(DestType));
      return;
    }
    
    // C++11 [dcl.init.list]p3, per DR1467:
    // - If T is a class type and the initializer list has a single element of
    //   type cv U, where U is T or a class derived from T, the object is
    //   initialized from that element (by copy-initialization for
    //   copy-list-initialization, or by direct-initialization for
    //   direct-list-initialization).
    // - Otherwise, if T is a character array and the initializer list has a
    //   single element that is an appropriately-typed string literal
    //   (8.5.2 [dcl.init.string]), initialization is performed as described
    //   in that section.
    // - Otherwise, if T is an aggregate, [...] (continue below).
    if (S.getLangOpts().CPlusPlus11 && InitList.getNumInits() == 1) {
      if (DestType.$arrow().isRecordType()) {
        QualType InitType = InitList.getInit(0).getType();
        if (S.Context.hasSameUnqualifiedType(new QualType(InitType), new QualType(DestType))
           || S.IsDerivedFrom(InitList.getLocStart(), new QualType(InitType), new QualType(DestType))) {
          Expr /*P*/ InitAsExpr = InitList.getInit(0);
          TryConstructorInitialization(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitAsExpr, true), new QualType(DestType), 
              Sequence, /*InitListSyntax*/ false, 
              /*IsInitListCopy*/ true);
          return;
        }
      }
      {
        /*const*/ ArrayType /*P*/ DestAT = S.Context.getAsArrayType(new QualType(DestType));
        if ((DestAT != null)) {
          Expr /*P*/ SubInit[/*1*/] = new Expr /*P*/ [/*1*/] {InitList.getInit(0)};
          if (!isa_VariableArrayType(DestAT)
             && IsStringInit(SubInit[0], DestAT, S.Context) == StringInitFailureKind.SIF_None) {
            InitializationKind SubKind = Kind.getKind() == InitializationKind.InitKind.IK_DirectList ? InitializationKind.CreateDirect(Kind.getLocation(), 
                InitList.getLBraceLoc(), 
                InitList.getRBraceLoc()) : new InitializationKind(Kind);
            Sequence.InitializeFrom(S, Entity, SubKind, new MutableArrayRef<Expr /*P*/ >(SubInit, true), 
                /*TopLevelOfInitList*/ true, 
                TreatUnavailableAsInvalid);
            
            // TryStringLiteralInitialization() (in InitializeFrom()) will fail if
            // the element is not an appropriately-typed string literal, in which
            // case we should proceed as in C++11 (below).
            if (Sequence.$bool()) {
              Sequence.RewrapReferenceInitList(Entity.getType(), InitList);
              return;
            }
          }
        }
      }
    }
    
    // C++11 [dcl.init.list]p3:
    //   - If T is an aggregate, aggregate initialization is performed.
    if ((DestType.$arrow().isRecordType() && !DestType.$arrow().isAggregateType())
       || (S.getLangOpts().CPlusPlus11
       && S.isStdInitializerList(new QualType(DestType), (type$ptr<QualType /*P*/> )null))) {
      if (S.getLangOpts().CPlusPlus11) {
        //   - Otherwise, if the initializer list has no elements and T is a
        //     class type with a default constructor, the object is
        //     value-initialized.
        if (InitList.getNumInits() == 0) {
          CXXRecordDecl /*P*/ RD = DestType.$arrow().getAsCXXRecordDecl();
          if (RD.hasDefaultConstructor()) {
            TryValueInitialization(S, Entity, Kind, Sequence, InitList);
            return;
          }
        }
        
        //   - Otherwise, if T is a specialization of std::initializer_list<E>,
        //     an initializer_list object constructed [...]
        if (TryInitializerListConstruction(S, InitList, new QualType(DestType), Sequence, 
            TreatUnavailableAsInvalid)) {
          return;
        }
        
        //   - Otherwise, if T is a class type, constructors are considered.
        Expr /*P*/ InitListAsExpr = InitList;
        TryConstructorInitialization(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(InitListAsExpr, true), new QualType(DestType), 
            Sequence, /*InitListSyntax*/ true);
      } else {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_InitListBadDestinationType);
      }
      return;
    }
    if (S.getLangOpts().CPlusPlus && !DestType.$arrow().isAggregateType()
       && InitList.getNumInits() == 1) {
      Expr /*P*/ E = InitList.getInit(0);
      
      //   - Otherwise, if T is an enumeration with a fixed underlying type,
      //     the initializer-list has a single element v, and the initialization
      //     is direct-list-initialization, the object is initialized with the
      //     value T(v); if a narrowing conversion is required to convert v to
      //     the underlying type of T, the program is ill-formed.
      /*const*/ EnumType /*P*/ ET = DestType.$arrow().<EnumType>getAs$EnumType();
      if (S.getLangOpts().CPlusPlus1z
         && Kind.getKind() == InitializationKind.InitKind.IK_DirectList
         && (ET != null) && ET.getDecl().isFixed()
         && !S.Context.hasSameUnqualifiedType(E.getType(), new QualType(DestType))
         && (E.getType().$arrow().isIntegralOrEnumerationType()
         || E.getType().$arrow().isFloatingType())) {
        ImplicitConversionSequence ICS = null;
        try {
          // There are two ways that T(v) can work when T is an enumeration type.
          // If there is either an implicit conversion sequence from v to T or
          // a conversion function that can convert from v to T, then we use that.
          // Otherwise, if v is of integral, enumeration, or floating-point type,
          // it is converted to the enumeration type via its underlying type.
          // There is no overlap possible between these two cases (except when the
          // source value is already of the destination type), and the first
          // case is handled by the general case for single-element lists below.
          ICS/*J*/= new ImplicitConversionSequence();
          ICS.setStandard();
          ICS.Unnamed_field2.Standard.setAsIdentityConversion();
          // If E is of a floating-point type, then the conversion is ill-formed
          // due to narrowing, but go through the motions in order to produce the
          // right diagnostic.
          ICS.Unnamed_field2.Standard.Second = E.getType().$arrow().isFloatingType() ? ImplicitConversionKind.ICK_Floating_Integral : ImplicitConversionKind.ICK_Integral_Conversion;
          ICS.Unnamed_field2.Standard.setFromType(E.getType());
          ICS.Unnamed_field2.Standard.setToType(0, E.getType());
          ICS.Unnamed_field2.Standard.setToType(1, new QualType(DestType));
          ICS.Unnamed_field2.Standard.setToType(2, new QualType(DestType));
          Sequence.AddConversionSequenceStep(ICS, ICS.Unnamed_field2.Standard.getToType(2), 
              /*TopLevelOfInitList*/ true);
          Sequence.RewrapReferenceInitList(Entity.getType(), InitList);
          return;
        } finally {
          if (ICS != null) { ICS.$destroy(); }
        }
      }
      
      //   - Otherwise, if the initializer list has a single element of type E
      //     [...references are handled above...], the object or reference is
      //     initialized from that element (by copy-initialization for
      //     copy-list-initialization, or by direct-initialization for
      //     direct-list-initialization); if a narrowing conversion is required
      //     to convert the element to T, the program is ill-formed.
      //
      // Per core-24034, this is direct-initialization if we were performing
      // direct-list-initialization and copy-initialization otherwise.
      // We can't use InitListChecker for this, because it always performs
      // copy-initialization. This only matters if we might use an 'explicit'
      // conversion operator, so we only need to handle the cases where the source
      // is of record type.
      if (InitList.getInit(0).getType().$arrow().isRecordType()) {
        InitializationKind SubKind = Kind.getKind() == InitializationKind.InitKind.IK_DirectList ? InitializationKind.CreateDirect(Kind.getLocation(), 
            InitList.getLBraceLoc(), 
            InitList.getRBraceLoc()) : new InitializationKind(Kind);
        Expr /*P*/ SubInit[/*1*/] = new Expr /*P*/ [/*1*/] {InitList.getInit(0)};
        Sequence.InitializeFrom(S, Entity, SubKind, new MutableArrayRef<Expr /*P*/ >(SubInit, true), 
            /*TopLevelOfInitList*/ true, 
            TreatUnavailableAsInvalid);
        if (Sequence.$bool()) {
          Sequence.RewrapReferenceInitList(Entity.getType(), InitList);
        }
        return;
      }
    }
    
    CheckInitList/*J*/= new InitListChecker(S, Entity, InitList, 
        DestType, /*VerifyOnly=*/ true, TreatUnavailableAsInvalid);
    if (CheckInitList.HadError()) {
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_ListInitializationFailed);
      return;
    }
    
    // Add the list initialization step with the built init list.
    Sequence.AddListInitializationStep(new QualType(DestType));
  } finally {
    if (CheckInitList != null) { CheckInitList.$destroy(); }
  }
}


/// \brief When initializing from init list via constructor, handle
/// initialization of an object of type std::initializer_list<T>.
///
/// \return true if we have handled initialization of an object of type
/// std::initializer_list<T>, false otherwise.
//<editor-fold defaultstate="collapsed" desc="TryInitializerListConstruction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3407,
 FQN="TryInitializerListConstruction", NM="_ZL30TryInitializerListConstructionRN5clang4SemaEPNS_12InitListExprENS_8QualTypeERNS_22InitializationSequenceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30TryInitializerListConstructionRN5clang4SemaEPNS_12InitListExprENS_8QualTypeERNS_22InitializationSequenceEb")
//</editor-fold>
public static boolean TryInitializerListConstruction(final Sema /*&*/ S, 
                              InitListExpr /*P*/ List, 
                              QualType DestType, 
                              final InitializationSequence /*&*/ Sequence, 
                              boolean TreatUnavailableAsInvalid) {
  QualType E/*J*/= new QualType();
  if (!S.isStdInitializerList(new QualType(DestType), $AddrOf(create_type$ptr(E)))) {
    return false;
  }
  if (!S.isCompleteType(List.getExprLoc(), new QualType(E))) {
    Sequence.setIncompleteTypeFailure(new QualType(E));
    return true;
  }
  
  // Try initializing a temporary array from the init list.
  QualType ArrayType = S.Context.getConstantArrayType(E.withConst(), new APInt($ulong2uint(S.Context.getTypeSize(S.Context.getSizeType().$QualType())), 
          $uint2ulong(List.getNumInits())), 
      org.clang.ast.ArrayType.ArraySizeModifier.Normal, 0);
  InitializedEntity HiddenArray = InitializedEntity.InitializeTemporary(new QualType(ArrayType));
  InitializationKind Kind = InitializationKind.CreateDirectList(List.getExprLoc());
  TryListInitialization(S, HiddenArray, Kind, List, Sequence, 
      TreatUnavailableAsInvalid);
  if (Sequence.$bool()) {
    Sequence.AddStdInitializerListConstructionStep(new QualType(DestType));
  }
  return true;
}

//<editor-fold defaultstate="collapsed" desc="ResolveConstructorOverload">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3437,
 FQN="ResolveConstructorOverload", NM="_ZL26ResolveConstructorOverloadRN5clang4SemaENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetENS_23DeclContextLookupResultERPNS_17OverloadCandidateEbbbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL26ResolveConstructorOverloadRN5clang4SemaENS_14SourceLocationEN4llvm15MutableArrayRefIPNS_4ExprEEERNS_20OverloadCandidateSetENS_23DeclContextLookupResultERPNS_17OverloadCandidateEbbbb")
//</editor-fold>
public static OverloadingResult ResolveConstructorOverload(final Sema /*&*/ S, SourceLocation DeclLoc, 
                          MutableArrayRef<Expr /*P*/ > Args, 
                          final OverloadCandidateSet /*&*/ CandidateSet, 
                          DeclContextLookupResult Ctors, 
                          final type$ptr<OverloadCandidate>/*&*/ Best, 
                          boolean CopyInitializing, boolean AllowExplicit, 
                          boolean OnlyListConstructors, boolean IsListInit) {
  CandidateSet.clear();
  
  for (NamedDecl /*P*/ D : Ctors) {
    ConstructorInfo Info = getConstructorInfo(D);
    if (!(Info.Constructor != null)) {
      continue;
    }
    
    boolean SuppressUserConversions = false;
    if (!(Info.ConstructorTmpl != null)) {
      // C++11 [over.best.ics]p4:
      //   ... and the constructor or user-defined conversion function is a
      //   candidate by
      //   - 13.3.1.3, when the argument is the temporary in the second step
      //     of a class copy-initialization, or
      //   - 13.3.1.4, 13.3.1.5, or 13.3.1.6 (in all cases),
      //   user-defined conversion sequences are not considered.
      // FIXME: This breaks backward compatibility, e.g. PR12117. As a
      //        temporary fix, let's re-instate the third bullet above until
      //        there is a resolution in the standard, i.e.,
      //   - 13.3.1.7 when the initializer list has exactly one element that is
      //     itself an initializer list and a conversion to some class X or
      //     reference to (possibly cv-qualified) X is considered for the first
      //     parameter of a constructor of X.
      if ((CopyInitializing
         || (IsListInit && Args.size() == 1 && isa_InitListExpr(Args.$at(0))))
         && Info.Constructor.isCopyOrMoveConstructor()) {
        SuppressUserConversions = true;
      }
    }
    if (!Info.Constructor.isInvalidDecl()
       && (AllowExplicit || !Info.Constructor.isExplicit())
       && (!OnlyListConstructors || S.isInitListConstructor(Info.Constructor))) {
      if ((Info.ConstructorTmpl != null)) {
        S.AddTemplateOverloadCandidate(Info.ConstructorTmpl, new DeclAccessPair(Info.FoundDecl), 
            /*ExplicitArgs*/ (TemplateArgumentListInfo /*P*/ )null, new ArrayRef<Expr /*P*/ >(Args), 
            CandidateSet, SuppressUserConversions);
      } else {
        // C++ [over.match.copy]p1:
        //   - When initializing a temporary to be bound to the first parameter 
        //     of a constructor that takes a reference to possibly cv-qualified 
        //     T as its first argument, called with a single argument in the 
        //     context of direct-initialization, explicit conversion functions
        //     are also considered.
        boolean AllowExplicitConv = AllowExplicit && !CopyInitializing
           && Args.size() == 1
           && Info.Constructor.isCopyOrMoveConstructor();
        S.AddOverloadCandidate(Info.Constructor, new DeclAccessPair(Info.FoundDecl), new ArrayRef<Expr /*P*/ >(Args), 
            CandidateSet, SuppressUserConversions, 
            /*PartialOverloading=*/ false, 
            /*AllowExplicit=*/ AllowExplicitConv);
      }
    }
  }
  
  // Perform overload resolution and return the result.
  return CandidateSet.BestViableFunction(S, new SourceLocation(DeclLoc), Best);
}


/// \brief Attempt initialization by constructor (C++ [dcl.init]), which
/// enumerates the constructors of the initialized entity and performs overload
/// resolution to select the best.
/// \param IsListInit     Is this list-initialization?
/// \param IsInitListCopy Is this non-list-initialization resulting from a
///                       list-initialization from {x} where x is the same
///                       type as the entity?
//<editor-fold defaultstate="collapsed" desc="TryConstructorInitialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3511,
 FQN="TryConstructorInitialization", NM="_ZL28TryConstructorInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8QualTypeERNS_22InitializationSequenceEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL28TryConstructorInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEENS_8QualTypeERNS_22InitializationSequenceEbb")
//</editor-fold>
public static void TryConstructorInitialization(final Sema /*&*/ S, 
                            final /*const*/ InitializedEntity /*&*/ Entity, 
                            final /*const*/ InitializationKind /*&*/ Kind, 
                            MutableArrayRef<Expr /*P*/ > Args, QualType DestType, 
                            final InitializationSequence /*&*/ Sequence) {
  TryConstructorInitialization(S, 
                            Entity, 
                            Kind, 
                            Args, DestType, 
                            Sequence, 
                            false, 
                            false);
}
public static void TryConstructorInitialization(final Sema /*&*/ S, 
                            final /*const*/ InitializedEntity /*&*/ Entity, 
                            final /*const*/ InitializationKind /*&*/ Kind, 
                            MutableArrayRef<Expr /*P*/ > Args, QualType DestType, 
                            final InitializationSequence /*&*/ Sequence, 
                            boolean IsListInit/*= false*/) {
  TryConstructorInitialization(S, 
                            Entity, 
                            Kind, 
                            Args, DestType, 
                            Sequence, 
                            IsListInit, 
                            false);
}
public static void TryConstructorInitialization(final Sema /*&*/ S, 
                            final /*const*/ InitializedEntity /*&*/ Entity, 
                            final /*const*/ InitializationKind /*&*/ Kind, 
                            MutableArrayRef<Expr /*P*/ > Args, QualType DestType, 
                            final InitializationSequence /*&*/ Sequence, 
                            boolean IsListInit/*= false*/, 
                            boolean IsInitListCopy/*= false*/) {
  assert ((!IsListInit || (Args.size() == 1 && isa_InitListExpr(Args.$at(0))))) : "IsListInit must come with a single initializer list argument.";
  
  // The type we're constructing needs to be complete.
  if (!S.isCompleteType(Kind.getLocation(), new QualType(DestType))) {
    Sequence.setIncompleteTypeFailure(new QualType(DestType));
    return;
  }
  
  /*const*/ RecordType /*P*/ DestRecordType = DestType.$arrow().<RecordType>getAs$RecordType();
  assert ((DestRecordType != null)) : "Constructor initialization requires record type";
  CXXRecordDecl /*P*/ DestRecordDecl = cast_CXXRecordDecl(DestRecordType.getDecl());
  
  // Build the candidate set directly in the initialization sequence
  // structure, so that it will persist if we fail.
  final OverloadCandidateSet /*&*/ CandidateSet = Sequence.getFailedCandidateSet();
  
  // Determine whether we are allowed to call explicit constructors or
  // explicit conversion operators.
  boolean AllowExplicit = Kind.AllowExplicit() || IsListInit;
  boolean CopyInitialization = Kind.getKind() == InitializationKind.InitKind.IK_Copy;
  
  //   - Otherwise, if T is a class type, constructors are considered. The
  //     applicable constructors are enumerated, and the best one is chosen
  //     through overload resolution.
  DeclContextLookupResult Ctors = S.LookupConstructors(DestRecordDecl);
  
  OverloadingResult Result = OverloadingResult.OR_No_Viable_Function;
  final type$ptr<OverloadCandidate> Best = create_type$ptr();
  boolean AsInitializerList = false;
  
  // C++11 [over.match.list]p1, per DR1467:
  //   When objects of non-aggregate type T are list-initialized, such that
  //   8.5.4 [dcl.init.list] specifies that overload resolution is performed
  //   according to the rules in this section, overload resolution selects
  //   the constructor in two phases:
  //
  //   - Initially, the candidate functions are the initializer-list
  //     constructors of the class T and the argument list consists of the
  //     initializer list as a single argument.
  if (IsListInit) {
    InitListExpr /*P*/ ILE = cast_InitListExpr(Args.$at(0));
    AsInitializerList = true;
    
    // If the initializer list has no elements and T has a default constructor,
    // the first phase is omitted.
    if (ILE.getNumInits() != 0 || !DestRecordDecl.hasDefaultConstructor()) {
      Result = ResolveConstructorOverload(S, Kind.getLocation(), new MutableArrayRef<Expr /*P*/ >(Args), 
          CandidateSet, new DeclContextLookupResult(Ctors), Best, 
          CopyInitialization, AllowExplicit, 
          /*OnlyListConstructor=*/ true, 
          IsListInit);
    }
    
    // Time to unwrap the init list.
    Args.$assignMove(new MutableArrayRef<Expr /*P*/ >(ILE.getInits(), ILE.getNumInits(), true));
  }
  
  // C++11 [over.match.list]p1:
  //   - If no viable initializer-list constructor is found, overload resolution
  //     is performed again, where the candidate functions are all the
  //     constructors of the class T and the argument list consists of the
  //     elements of the initializer list.
  if (Result == OverloadingResult.OR_No_Viable_Function) {
    AsInitializerList = false;
    Result = ResolveConstructorOverload(S, Kind.getLocation(), new MutableArrayRef<Expr /*P*/ >(Args), 
        CandidateSet, new DeclContextLookupResult(Ctors), Best, 
        CopyInitialization, AllowExplicit, 
        /*OnlyListConstructors=*/ false, 
        IsListInit);
  }
  if ((Result.getValue() != 0)) {
    Sequence.SetOverloadFailure(IsListInit ? InitializationSequence.FailureKind.FK_ListConstructorOverloadFailed : InitializationSequence.FailureKind.FK_ConstructorOverloadFailed, 
        Result);
    return;
  }
  
  // C++11 [dcl.init]p6:
  //   If a program calls for the default initialization of an object
  //   of a const-qualified type T, T shall be a class type with a
  //   user-provided default constructor.
  // C++ core issue 253 proposal:
  //   If the implicit default constructor initializes all subobjects, no
  //   initializer should be required.
  // The 253 proposal is for example needed to process libstdc++ headers in 5.x.
  CXXConstructorDecl /*P*/ CtorDecl = cast_CXXConstructorDecl(Best.$star().Function);
  if (Kind.getKind() == InitializationKind.InitKind.IK_Default
     && Entity.getType().isConstQualified()) {
    if (!CtorDecl.getParent().allowConstDefaultInit()) {
      if (!maybeRecoverWithZeroInitialization(S, Sequence, Entity)) {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_DefaultInitOfConst);
      }
      return;
    }
  }
  
  // C++11 [over.match.list]p1:
  //   In copy-list-initialization, if an explicit constructor is chosen, the
  //   initializer is ill-formed.
  if (IsListInit && !Kind.AllowExplicit() && CtorDecl.isExplicit()) {
    Sequence.SetFailed(InitializationSequence.FailureKind.FK_ExplicitConstructor);
    return;
  }
  
  // Add the constructor initialization step. Any cv-qualification conversion is
  // subsumed by the initialization.
  boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
  Sequence.AddConstructorInitializationStep(new DeclAccessPair(Best.$star().FoundDecl), CtorDecl, new QualType(DestType), HadMultipleCandidates, 
      ((IsListInit | IsInitListCopy)/* != 0*/), AsInitializerList);
}

//<editor-fold defaultstate="collapsed" desc="ResolveOverloadedFunctionForReferenceBinding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3631,
 FQN="ResolveOverloadedFunctionForReferenceBinding", NM="_ZL44ResolveOverloadedFunctionForReferenceBindingRN5clang4SemaEPNS_4ExprERNS_8QualTypeES5_S4_RNS_22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL44ResolveOverloadedFunctionForReferenceBindingRN5clang4SemaEPNS_4ExprERNS_8QualTypeES5_S4_RNS_22InitializationSequenceE")
//</editor-fold>
public static boolean ResolveOverloadedFunctionForReferenceBinding(final Sema /*&*/ S, 
                                            Expr /*P*/ Initializer, 
                                            final QualType /*&*/ SourceType, 
                                            final QualType /*&*/ UnqualifiedSourceType, 
                                            QualType UnqualifiedTargetType, 
                                            final InitializationSequence /*&*/ Sequence) {
  if ($eq_CanQual$T_CanQual$U(S.Context.getCanonicalType(new QualType(UnqualifiedSourceType)), 
      /*NO_COPY*/S.Context.OverloadTy)) {
    DeclAccessPair Found/*J*/= new DeclAccessPair();
    bool$ptr HadMultipleCandidates = create_bool$ptr(false);
    {
      FunctionDecl /*P*/ Fn = S.ResolveAddressOfOverloadedFunction(Initializer, 
          new QualType(UnqualifiedTargetType), 
          false, Found, 
          $AddrOf(HadMultipleCandidates));
      if ((Fn != null)) {
        Sequence.AddAddressOverloadResolutionStep(Fn, new DeclAccessPair(Found), 
            HadMultipleCandidates.$star());
        SourceType.$assignMove(Fn.getType());
        UnqualifiedSourceType.$assignMove(SourceType.getUnqualifiedType());
      } else if (!UnqualifiedTargetType.$arrow().isRecordType()) {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_AddressOfOverloadFailed);
        return true;
      }
    }
  }
  return false;
}


/// \brief Reference initialization without resolving overloaded functions.
//<editor-fold defaultstate="collapsed" desc="TryReferenceInitializationCore">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4200,
 FQN="TryReferenceInitializationCore", NM="_ZL30TryReferenceInitializationCoreRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprENS_8QualTypeESA_NS_10QualifiersESA_SA_SB_RNS_22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30TryReferenceInitializationCoreRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprENS_8QualTypeESA_NS_10QualifiersESA_SA_SB_RNS_22InitializationSequenceE")
//</editor-fold>
public static void TryReferenceInitializationCore(final Sema /*&*/ S, 
                              final /*const*/ InitializedEntity /*&*/ Entity, 
                              final /*const*/ InitializationKind /*&*/ Kind, 
                              Expr /*P*/ Initializer, 
                              QualType cv1T1, QualType T1, 
                              Qualifiers T1Quals, 
                              QualType cv2T2, QualType T2, 
                              Qualifiers T2Quals, 
                              final InitializationSequence /*&*/ Sequence) {
  ImplicitConversionSequence ICS = null;
  try {
    QualType DestType = Entity.getType();
    SourceLocation DeclLoc = Initializer.getLocStart();
    // Compute some basic properties of the types and the initializer.
    boolean isLValueRef = DestType.$arrow().isLValueReferenceType();
    boolean isRValueRef = !isLValueRef;
    bool$ref DerivedToBase = create_bool$ref(false);
    bool$ref ObjCConversion = create_bool$ref(false);
    bool$ref ObjCLifetimeConversion = create_bool$ref(false);
    Expr.Classification InitCategory = Initializer.Classify(S.Context);
    Sema.ReferenceCompareResult RefRelationship = S.CompareReferenceRelationship(new SourceLocation(DeclLoc), new QualType(cv1T1), new QualType(cv2T2), DerivedToBase, 
        ObjCConversion, ObjCLifetimeConversion);
    
    // C++0x [dcl.init.ref]p5:
    //   A reference to type "cv1 T1" is initialized by an expression of type
    //   "cv2 T2" as follows:
    //
    //     - If the reference is an lvalue reference and the initializer
    //       expression
    // Note the analogous bullet points for rvalue refs to functions. Because
    // there are no function rvalues in C++, rvalue refs to functions are treated
    // like lvalue refs.
    OverloadingResult ConvOvlResult = OverloadingResult.OR_Success;
    boolean T1Function = T1.$arrow().isFunctionType();
    if (isLValueRef || T1Function) {
      if (InitCategory.isLValue()
         && (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Compatible_With_Added_Qualification.getValue()
         || (Kind.isCStyleOrFunctionalCast()
         && RefRelationship == Sema.ReferenceCompareResult.Ref_Related))) {
        //   - is an lvalue (but is not a bit-field), and "cv1 T1" is
        //     reference-compatible with "cv2 T2," or
        //
        // Per C++ [over.best.ics]p2, we don't diagnose whether the lvalue is a
        // bit-field when we're determining whether the reference initialization
        // can occur. However, we do pay attention to whether it is a bit-field
        // to decide whether we're actually binding to a temporary created from
        // the bit-field.
        if (DerivedToBase.$deref()) {
          Sequence.AddDerivedToBaseCastStep(S.Context.getQualifiedType(new QualType(T1), new Qualifiers(T2Quals)), 
              ExprValueKind.VK_LValue);
        } else if (ObjCConversion.$deref()) {
          Sequence.AddObjCObjectConversionStep(S.Context.getQualifiedType(new QualType(T1), new Qualifiers(T2Quals)));
        }
        
        ExprValueKind ValueKind = convertQualifiersAndValueKindIfNecessary(S, Sequence, Initializer, 
            new QualType(cv1T1), new Qualifiers(T1Quals), new Qualifiers(T2Quals), 
            isLValueRef);
        Sequence.AddReferenceBindingStep(new QualType(cv1T1), ValueKind == ExprValueKind.VK_RValue);
        return;
      }
      
      //     - has a class type (i.e., T2 is a class type), where T1 is not
      //       reference-related to T2, and can be implicitly converted to an
      //       lvalue of type "cv3 T3," where "cv1 T1" is reference-compatible
      //       with "cv3 T3" (this conversion is selected by enumerating the
      //       applicable conversion functions (13.3.1.6) and choosing the best
      //       one through overload resolution (13.3)),
      // If we have an rvalue ref to function type here, the rhs must be
      // an rvalue. DR1287 removed the "implicitly" here.
      if (RefRelationship == Sema.ReferenceCompareResult.Ref_Incompatible && T2.$arrow().isRecordType()
         && (isLValueRef || InitCategory.isRValue())) {
        ConvOvlResult = TryRefInitWithConversionFunction(S, Entity, Kind, Initializer, /*AllowRValues*/ isRValueRef, Sequence);
        if (ConvOvlResult == OverloadingResult.OR_Success) {
          return;
        }
        if (ConvOvlResult != OverloadingResult.OR_No_Viable_Function) {
          Sequence.SetOverloadFailure(InitializationSequence.FailureKind.FK_ReferenceInitOverloadFailed, 
              ConvOvlResult);
        }
      }
    }
    
    //     - Otherwise, the reference shall be an lvalue reference to a
    //       non-volatile const type (i.e., cv1 shall be const), or the reference
    //       shall be an rvalue reference.
    if (isLValueRef && !(T1Quals.hasConst() && !T1Quals.hasVolatile())) {
      if ($eq_CanQual$T_CanQual$U(S.Context.getCanonicalType(new QualType(T2)), /*NO_COPY*/S.Context.OverloadTy)) {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_AddressOfOverloadFailed);
      } else if ((ConvOvlResult.getValue() != 0) && !Sequence.getFailedCandidateSet().empty()) {
        Sequence.SetOverloadFailure(InitializationSequence.FailureKind.FK_ReferenceInitOverloadFailed, 
            ConvOvlResult);
      } else {
        Sequence.SetFailed(InitCategory.isLValue() ? (RefRelationship == Sema.ReferenceCompareResult.Ref_Related ? InitializationSequence.FailureKind.FK_ReferenceInitDropsQualifiers : InitializationSequence.FailureKind.FK_NonConstLValueReferenceBindingToUnrelated) : InitializationSequence.FailureKind.FK_NonConstLValueReferenceBindingToTemporary);
      }
      
      return;
    }
    
    //    - If the initializer expression
    //      - is an xvalue, class prvalue, array prvalue, or function lvalue and
    //        "cv1 T1" is reference-compatible with "cv2 T2"
    // Note: functions are handled below.
    if (!T1Function
       && (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Compatible_With_Added_Qualification.getValue()
       || (Kind.isCStyleOrFunctionalCast()
       && RefRelationship == Sema.ReferenceCompareResult.Ref_Related))
       && (InitCategory.isXValue()
       || (InitCategory.isPRValue() && T2.$arrow().isRecordType())
       || (InitCategory.isPRValue() && T2.$arrow().isArrayType()))) {
      ExprValueKind ValueKind = InitCategory.isXValue() ? ExprValueKind.VK_XValue : ExprValueKind.VK_RValue;
      if (InitCategory.isPRValue() && T2.$arrow().isRecordType()) {
        // The corresponding bullet in C++03 [dcl.init.ref]p5 gives the
        // compiler the freedom to perform a copy here or bind to the
        // object, while C++0x requires that we bind directly to the
        // object. Hence, we always bind to the object without making an
        // extra copy. However, in C++03 requires that we check for the
        // presence of a suitable copy constructor:
        //
        //   The constructor that would be used to make the copy shall
        //   be callable whether or not the copy is actually done.
        if (!S.getLangOpts().CPlusPlus11 && !S.getLangOpts().MicrosoftExt) {
          Sequence.AddExtraneousCopyToTemporary(new QualType(cv2T2));
        } else if (S.getLangOpts().CPlusPlus11) {
          CheckCXX98CompatAccessibleCopy(S, Entity, Initializer);
        }
      }
      if (DerivedToBase.$deref()) {
        Sequence.AddDerivedToBaseCastStep(S.Context.getQualifiedType(new QualType(T1), new Qualifiers(T2Quals)), 
            ValueKind);
      } else if (ObjCConversion.$deref()) {
        Sequence.AddObjCObjectConversionStep(S.Context.getQualifiedType(new QualType(T1), new Qualifiers(T2Quals)));
      }
      
      ValueKind = convertQualifiersAndValueKindIfNecessary(S, Sequence, 
          Initializer, new QualType(cv1T1), 
          new Qualifiers(T1Quals), new Qualifiers(T2Quals), 
          isLValueRef);
      
      Sequence.AddReferenceBindingStep(new QualType(cv1T1), ValueKind == ExprValueKind.VK_RValue);
      return;
    }
    
    //       - has a class type (i.e., T2 is a class type), where T1 is not
    //         reference-related to T2, and can be implicitly converted to an
    //         xvalue, class prvalue, or function lvalue of type "cv3 T3",
    //         where "cv1 T1" is reference-compatible with "cv3 T3",
    //
    // DR1287 removes the "implicitly" here.
    if (T2.$arrow().isRecordType()) {
      if (RefRelationship == Sema.ReferenceCompareResult.Ref_Incompatible) {
        ConvOvlResult = TryRefInitWithConversionFunction(S, Entity, Kind, Initializer, /*AllowRValues*/ true, Sequence);
        if ((ConvOvlResult.getValue() != 0)) {
          Sequence.SetOverloadFailure(InitializationSequence.FailureKind.FK_ReferenceInitOverloadFailed, 
              ConvOvlResult);
        }
        
        return;
      }
      if ((RefRelationship == Sema.ReferenceCompareResult.Ref_Compatible
         || RefRelationship == Sema.ReferenceCompareResult.Ref_Compatible_With_Added_Qualification)
         && isRValueRef && InitCategory.isLValue()) {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_RValueReferenceBindingToLValue);
        return;
      }
      
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_ReferenceInitDropsQualifiers);
      return;
    }
    
    //      - Otherwise, a temporary of type "cv1 T1" is created and initialized
    //        from the initializer expression using the rules for a non-reference
    //        copy-initialization (8.5). The reference is then bound to the
    //        temporary. [...]
    InitializedEntity TempEntity = InitializedEntity.InitializeTemporary(new QualType(cv1T1));
    
    // FIXME: Why do we use an implicit conversion here rather than trying
    // copy-initialization?
    ICS = S.TryImplicitConversion(Initializer, TempEntity.getType(), 
        /*SuppressUserConversions=*/ false, 
        /*AllowExplicit=*/ false, 
        /*FIXME:InOverloadResolution=*/ false, 
        /*CStyle=*/ Kind.isCStyleOrFunctionalCast(), 
        /*AllowObjCWritebackConversion=*/ false);
    if (ICS.isBad()) {
      // FIXME: Use the conversion function set stored in ICS to turn
      // this into an overloading ambiguity diagnostic. However, we need
      // to keep that set as an OverloadCandidateSet rather than as some
      // other kind of set.
      if ((ConvOvlResult.getValue() != 0) && !Sequence.getFailedCandidateSet().empty()) {
        Sequence.SetOverloadFailure(InitializationSequence.FailureKind.FK_ReferenceInitOverloadFailed, 
            ConvOvlResult);
      } else if ($eq_CanQual$T_CanQual$U(S.Context.getCanonicalType(new QualType(T2)), /*NO_COPY*/S.Context.OverloadTy)) {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_AddressOfOverloadFailed);
      } else {
        Sequence.SetFailed(InitializationSequence.FailureKind.FK_ReferenceInitFailed);
      }
      return;
    } else {
      Sequence.AddConversionSequenceStep(ICS, TempEntity.getType());
    }
    
    //        [...] If T1 is reference-related to T2, cv1 must be the
    //        same cv-qualification as, or greater cv-qualification
    //        than, cv2; otherwise, the program is ill-formed.
    /*uint*/int T1CVRQuals = T1Quals.getCVRQualifiers();
    /*uint*/int T2CVRQuals = T2Quals.getCVRQualifiers();
    if (RefRelationship == Sema.ReferenceCompareResult.Ref_Related
       && (T1CVRQuals | T2CVRQuals) != T1CVRQuals) {
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_ReferenceInitDropsQualifiers);
      return;
    }
    
    //   [...] If T1 is reference-related to T2 and the reference is an rvalue
    //   reference, the initializer expression shall not be an lvalue.
    if (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Related.getValue() && !isLValueRef
       && InitCategory.isLValue()) {
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_RValueReferenceBindingToLValue);
      return;
    }
    
    Sequence.AddReferenceBindingStep(new QualType(cv1T1), /*bindingTemporary=*/ true);
  } finally {
    if (ICS != null) { ICS.$destroy(); }
  }
}


/// \brief Attempt value initialization (C++ [dcl.init]p7).
//<editor-fold defaultstate="collapsed" desc="TryValueInitialization">
@Converted(kind = Converted.Kind.MANUAL_SEMANTIC,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4446,
 FQN="TryValueInitialization", NM="_ZL22TryValueInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindERNS_22InitializationSequenceEPNS_12InitListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL22TryValueInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindERNS_22InitializationSequenceEPNS_12InitListExprE")
//</editor-fold>
public static void TryValueInitialization(final Sema /*&*/ S, 
                      final /*const*/ InitializedEntity /*&*/ Entity, 
                      final /*const*/ InitializationKind /*&*/ Kind, 
                      final InitializationSequence /*&*/ Sequence) {
  TryValueInitialization(S, 
                      Entity, 
                      Kind, 
                      Sequence, 
                      (InitListExpr /*P*/ )null);
}
public static void TryValueInitialization(final Sema /*&*/ S, 
                      final /*const*/ InitializedEntity /*&*/ Entity, 
                      final /*const*/ InitializationKind /*&*/ Kind, 
                      final InitializationSequence /*&*/ Sequence, 
                      InitListExpr /*P*/ InitList/*= null*/) {
  assert ((!(InitList != null) || InitList.getNumInits() == 0)) : "Shouldn't use value-init for non-empty init lists";
  
  // C++98 [dcl.init]p5, C++11 [dcl.init]p7:
  //
  //   To value-initialize an object of type T means:
  QualType T = Entity.getType();
  
  //     -- if T is an array type, then each element is value-initialized;
  T.$assignMove(S.Context.getBaseElementType(new QualType(T)));
  {
    
    /*const*/ RecordType /*P*/ RT = T.$arrow().<RecordType>getAs$RecordType();
    if ((RT != null)) {
      {
        CXXRecordDecl /*P*/ ClassDecl = dyn_cast_CXXRecordDecl(RT.getDecl());
        if ((ClassDecl != null)) {
          boolean NeedZeroInitialization = true;
          if (!S.getLangOpts().CPlusPlus11) {
            // C++98:
            // -- if T is a class type (clause 9) with a user-declared constructor
            //    (12.1), then the default constructor for T is called (and the
            //    initialization is ill-formed if T has no accessible default
            //    constructor);
            if (ClassDecl.hasUserDeclaredConstructor()) {
              NeedZeroInitialization = false;
            }
          } else {
            // C++11:
            // -- if T is a class type (clause 9) with either no default constructor
            //    (12.1 [class.ctor]) or a default constructor that is user-provided
            //    or deleted, then the object is default-initialized;
            CXXConstructorDecl /*P*/ CD = S.LookupDefaultConstructor(ClassDecl);
            if (!(CD != null) || !CD.getCanonicalDecl().isDefaulted() || CD.isDeleted()) {
              NeedZeroInitialization = false;
            }
          }
          
          // -- if T is a (possibly cv-qualified) non-union class type without a
          //    user-provided or deleted default constructor, then the object is
          //    zero-initialized and, if T has a non-trivial default constructor,
          //    default-initialized;
          // The 'non-union' here was removed by DR1502. The 'non-trivial default
          // constructor' part was removed by DR1507.
          if (NeedZeroInitialization) {
            Sequence.AddZeroInitializationStep(Entity.getType());
          }
          
          // C++03:
          // -- if T is a non-union class type without a user-declared constructor,
          //    then every non-static data member and base class component of T is
          //    value-initialized;
          // [...] A program that calls for [...] value-initialization of an
          // entity of reference type is ill-formed.
          //
          // C++11 doesn't need this handling, because value-initialization does not
          // occur recursively there, and the implicit default constructor is
          // defined as deleted in the problematic cases.
          if (!S.getLangOpts().CPlusPlus11
             && ClassDecl.hasUninitializedReferenceMember()) {
            Sequence.SetFailed(InitializationSequence.FailureKind.FK_TooManyInitsForReference);
            return;
          }
          
          // If this is list-value-initialization, pass the empty init list on when
          // building the constructor call. This affects the semantics of a few
          // things (such as whether an explicit default constructor can be called).
          Expr /*P*/ InitListAsExpr = InitList;
          MutableArrayRef<Expr /*P*/ > Args/*J*/= new MutableArrayRef<Expr /*P*/ >(/*JAVA*/$AddrOf(create_type$ptr(InitListAsExpr)), (InitList != null) ? 1 : 0, true);
          boolean InitListSyntax = (InitList != null);
          
          TryConstructorInitialization(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(Args), new QualType(T), Sequence, 
              InitListSyntax);
          /*JAVA:return*/return;
        }
      }
    }
  }
  
  Sequence.AddZeroInitializationStep(Entity.getType());
}


/// \brief Attempt list initialization of a reference.
//<editor-fold defaultstate="collapsed" desc="TryReferenceListInitialization">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3676,
 FQN="TryReferenceListInitialization", NM="_ZL30TryReferenceListInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_12InitListExprERNS_22InitializationSequenceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30TryReferenceListInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_12InitListExprERNS_22InitializationSequenceEb")
//</editor-fold>
public static void TryReferenceListInitialization(final Sema /*&*/ S, 
                              final /*const*/ InitializedEntity /*&*/ Entity, 
                              final /*const*/ InitializationKind /*&*/ Kind, 
                              InitListExpr /*P*/ InitList, 
                              final InitializationSequence /*&*/ Sequence, 
                              boolean TreatUnavailableAsInvalid) {
  // First, catch C++03 where this isn't possible.
  if (!S.getLangOpts().CPlusPlus11) {
    Sequence.SetFailed(InitializationSequence.FailureKind.FK_ReferenceBindingToInitList);
    return;
  }
  // Can't reference initialize a compound literal.
  if (Entity.getKind() == InitializedEntity.EntityKind.EK_CompoundLiteralInit) {
    Sequence.SetFailed(InitializationSequence.FailureKind.FK_ReferenceBindingToInitList);
    return;
  }
  
  QualType DestType = Entity.getType();
  QualType cv1T1 = DestType.$arrow().getAs(ReferenceType.class).getPointeeType();
  Qualifiers T1Quals/*J*/= new Qualifiers();
  QualType T1 = S.Context.getUnqualifiedArrayType(new QualType(cv1T1), T1Quals);
  
  // Reference initialization via an initializer list works thus:
  // If the initializer list consists of a single element that is
  // reference-related to the referenced type, bind directly to that element
  // (possibly creating temporaries).
  // Otherwise, initialize a temporary with the initializer list and
  // bind to that.
  if (InitList.getNumInits() == 1) {
    Expr /*P*/ Initializer = InitList.getInit(0);
    QualType cv2T2 = Initializer.getType();
    Qualifiers T2Quals/*J*/= new Qualifiers();
    QualType T2 = S.Context.getUnqualifiedArrayType(new QualType(cv2T2), T2Quals);
    
    // If this fails, creating a temporary wouldn't work either.
    if (ResolveOverloadedFunctionForReferenceBinding(S, Initializer, cv2T2, T2, 
        new QualType(T1), Sequence)) {
      return;
    }
    
    SourceLocation DeclLoc = Initializer.getLocStart();
    bool$ref dummy1 = create_bool$ref(), dummy2 = create_bool$ref(), dummy3 = create_bool$ref();
    Sema.ReferenceCompareResult RefRelationship = S.CompareReferenceRelationship(new SourceLocation(DeclLoc), new QualType(cv1T1), new QualType(cv2T2), dummy1, 
        dummy2, dummy3);
    if (RefRelationship.getValue() >= Sema.ReferenceCompareResult.Ref_Related.getValue()) {
      // Try to bind the reference here.
      TryReferenceInitializationCore(S, Entity, Kind, Initializer, new QualType(cv1T1), new QualType(T1), 
          new Qualifiers(T1Quals), new QualType(cv2T2), new QualType(T2), new Qualifiers(T2Quals), Sequence);
      if (Sequence.$bool()) {
        Sequence.RewrapReferenceInitList(new QualType(cv1T1), InitList);
      }
      return;
    }
    
    // Update the initializer if we've resolved an overloaded function.
    if ($noteq_iter(Sequence.step_begin(), Sequence.step_end())) {
      Sequence.RewrapReferenceInitList(new QualType(cv1T1), InitList);
    }
  }
  
  // Not reference-related. Create a temporary and bind to that.
  InitializedEntity TempEntity = InitializedEntity.InitializeTemporary(new QualType(cv1T1));
  
  TryListInitialization(S, TempEntity, Kind, InitList, Sequence, 
      TreatUnavailableAsInvalid);
  if (Sequence.$bool()) {
    if (DestType.$arrow().isRValueReferenceType()
       || (T1Quals.hasConst() && !T1Quals.hasVolatile())) {
      Sequence.AddReferenceBindingStep(new QualType(cv1T1), /*bindingTemporary=*/ true);
    } else {
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_NonConstLValueReferenceBindingToTemporary);
    }
  }
}


/// \brief Try a reference initialization that involves calling a conversion
/// function.
//<editor-fold defaultstate="collapsed" desc="TryRefInitWithConversionFunction">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 3943,
 FQN="TryRefInitWithConversionFunction", NM="_ZL32TryRefInitWithConversionFunctionRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprEbRNS_22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL32TryRefInitWithConversionFunctionRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprEbRNS_22InitializationSequenceE")
//</editor-fold>
public static OverloadingResult TryRefInitWithConversionFunction(final Sema /*&*/ S, 
                                final /*const*/ InitializedEntity /*&*/ Entity, 
                                final /*const*/ InitializationKind /*&*/ Kind, 
                                Expr /*P*/ Initializer, 
                                boolean AllowRValues, 
                                final InitializationSequence /*&*/ Sequence) {
  QualType DestType = Entity.getType();
  QualType cv1T1 = DestType.$arrow().getAs(ReferenceType.class).getPointeeType();
  QualType T1 = cv1T1.getUnqualifiedType();
  QualType cv2T2 = Initializer.getType();
  QualType T2 = cv2T2.getUnqualifiedType();
  
  bool$ref DerivedToBase = create_bool$ref();
  bool$ref ObjCConversion = create_bool$ref();
  bool$ref ObjCLifetimeConversion = create_bool$ref();
  assert (!(S.CompareReferenceRelationship(Initializer.getLocStart(), new QualType(T1), new QualType(T2), DerivedToBase, ObjCConversion, ObjCLifetimeConversion).getValue() != 0)) : "Must have incompatible references when binding via conversion";
  ///*J:(void)*/DerivedToBase;
  ///*J:(void)*/ObjCConversion;
  ///*J:(void)*/ObjCLifetimeConversion;
  
  // Build the candidate set directly in the initialization sequence
  // structure, so that it will persist if we fail.
  final OverloadCandidateSet /*&*/ CandidateSet = Sequence.getFailedCandidateSet();
  CandidateSet.clear();
  
  // Determine whether we are allowed to call explicit constructors or
  // explicit conversion operators.
  boolean AllowExplicit = Kind.AllowExplicit();
  boolean AllowExplicitConvs = Kind.allowExplicitConversionFunctionsInRefBinding();
  
  /*const*/ RecordType /*P*/ T1RecordType = null;
  if (AllowRValues && ((T1RecordType = T1.$arrow().<RecordType>getAs$RecordType()) != null)
     && S.isCompleteType(Kind.getLocation(), new QualType(T1))) {
    // The type we're converting to is a class type. Enumerate its constructors
    // to see if there is a suitable conversion.
    CXXRecordDecl /*P*/ T1RecordDecl = cast_CXXRecordDecl(T1RecordType.getDecl());
    
    for (NamedDecl /*P*/ D : S.LookupConstructors(T1RecordDecl)) {
      ConstructorInfo Info = getConstructorInfo(D);
      if (!(Info.Constructor != null)) {
        continue;
      }
      if (!Info.Constructor.isInvalidDecl()
         && Info.Constructor.isConvertingConstructor(AllowExplicit)) {
        if ((Info.ConstructorTmpl != null)) {
          S.AddTemplateOverloadCandidate(Info.ConstructorTmpl, new DeclAccessPair(Info.FoundDecl), 
              /*ExplicitArgs*/ (TemplateArgumentListInfo /*P*/ )null, 
              new ArrayRef<Expr /*P*/ >(Initializer, true), CandidateSet, 
              /*SuppressUserConversions=*/ true);
        } else {
          S.AddOverloadCandidate(Info.Constructor, new DeclAccessPair(Info.FoundDecl), 
              new ArrayRef<Expr /*P*/ >(Initializer, true), CandidateSet, 
              /*SuppressUserConversions=*/ true);
        }
      }
    }
  }
  if ((T1RecordType != null) && T1RecordType.getDecl().isInvalidDecl()) {
    return OverloadingResult.OR_No_Viable_Function;
  }
  
  /*const*/ RecordType /*P*/ T2RecordType = null;
  if (((T2RecordType = T2.$arrow().<RecordType>getAs$RecordType()) != null)
     && S.isCompleteType(Kind.getLocation(), new QualType(T2))) {
    // The type we're converting from is a class type, enumerate its conversion
    // functions.
    CXXRecordDecl /*P*/ T2RecordDecl = cast_CXXRecordDecl(T2RecordType.getDecl());
    
    final /*const*/ iterator_range<NamedDecl> /*&*/ Conversions = T2RecordDecl.getVisibleConversionFunctions();
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
      
      // If the conversion function doesn't return a reference type,
      // it can't be considered for this conversion unless we're allowed to
      // consider rvalues.
      // FIXME: Do we need to make sure that we only consider conversion
      // candidates with reference-compatible results? That might be needed to
      // break recursion.
      if ((AllowExplicitConvs || !Conv.isExplicit())
         && (AllowRValues || Conv.getConversionType().$arrow().isLValueReferenceType())) {
        if ((ConvTemplate != null)) {
          S.AddTemplateConversionCandidate(ConvTemplate, new DeclAccessPair(I.getPair()), 
              ActingDC, Initializer, 
              new QualType(DestType), CandidateSet, 
              /*AllowObjCConversionOnExplicit=*/
              false);
        } else {
          S.AddConversionCandidate(Conv, new DeclAccessPair(I.getPair()), ActingDC, 
              Initializer, new QualType(DestType), CandidateSet, 
              /*AllowObjCConversionOnExplicit=*/ false);
        }
      }
    }
  }
  if ((T2RecordType != null) && T2RecordType.getDecl().isInvalidDecl()) {
    return OverloadingResult.OR_No_Viable_Function;
  }
  
  SourceLocation DeclLoc = Initializer.getLocStart();
  
  // Perform overload resolution. If it fails, return the failed result.
  final type$ptr<OverloadCandidate> Best = create_type$ptr();
  {
    OverloadingResult Result = CandidateSet.BestViableFunction(S, new SourceLocation(DeclLoc), Best, true);
    if ((Result.getValue() != 0)) {
      return Result;
    }
  }
  
  FunctionDecl /*P*/ Function = Best.$star().Function;
  // This is the overload that will be used for this initialization step if we
  // use this initialization. Mark it as referenced.
  Function.setReferenced();
  
  // Compute the returned type of the conversion.
  if (isa_CXXConversionDecl(Function)) {
    T2.$assignMove(Function.getReturnType());
  } else {
    T2.$assign(cv1T1);
  }
  
  // Add the user-defined conversion step.
  boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
  Sequence.AddUserConversionStep(Function, new DeclAccessPair(Best.$star().FoundDecl), 
      T2.getNonLValueExprType(S.Context), 
      HadMultipleCandidates);
  
  // Determine whether we need to perform derived-to-base or
  // cv-qualification adjustments.
  ExprValueKind VK = ExprValueKind.VK_RValue;
  if (T2.$arrow().isLValueReferenceType()) {
    VK = ExprValueKind.VK_LValue;
  } else {
    /*const*/ RValueReferenceType /*P*/ RRef = T2.$arrow().getAs(RValueReferenceType.class);
    if ((RRef != null)) {
      VK = RRef.getPointeeType().$arrow().isFunctionType() ? ExprValueKind.VK_LValue : ExprValueKind.VK_XValue;
    }
  }
  
  bool$ref NewDerivedToBase = create_bool$ref(false);
  bool$ref NewObjCConversion = create_bool$ref(false);
  bool$ref NewObjCLifetimeConversion = create_bool$ref(false);
  Sema.ReferenceCompareResult NewRefRelationship = S.CompareReferenceRelationship(new SourceLocation(DeclLoc), new QualType(T1), 
      T2.getNonLValueExprType(S.Context), 
      NewDerivedToBase, NewObjCConversion, 
      NewObjCLifetimeConversion);
  if (NewRefRelationship == Sema.ReferenceCompareResult.Ref_Incompatible) {
    ImplicitConversionSequence ICS = null;
    try {
      // If the type we've converted to is not reference-related to the
      // type we're looking for, then there is another conversion step
      // we need to perform to produce a temporary of the right type
      // that we'll be binding to.
      ICS/*J*/= new ImplicitConversionSequence();
      ICS.setStandard();
      ICS.Unnamed_field2.Standard.$assign(Best.$star().Unnamed_field12.FinalConversion);
      T2.$assignMove(ICS.Unnamed_field2.Standard.getToType(2));
      Sequence.AddConversionSequenceStep(ICS, new QualType(T2));
    } finally {
      if (ICS != null) { ICS.$destroy(); }
    }
  } else if (NewDerivedToBase.$deref()) {
    Sequence.AddDerivedToBaseCastStep(S.Context.getQualifiedType(new QualType(T1), 
            T2.getNonReferenceType().getQualifiers()), 
        VK);
  } else if (NewObjCConversion.$deref()) {
    Sequence.AddObjCObjectConversionStep(S.Context.getQualifiedType(new QualType(T1), 
            T2.getNonReferenceType().getQualifiers()));
  }
  if (cv1T1.getQualifiers().$noteq(T2.getNonReferenceType().getQualifiers())) {
    Sequence.AddQualificationConversionStep(new QualType(cv1T1), VK);
  }
  
  Sequence.AddReferenceBindingStep(new QualType(cv1T1), !T2.$arrow().isReferenceType());
  return OverloadingResult.OR_Success;
}


/// \brief Check whether elidable copy construction for binding a reference to
/// a temporary would have succeeded if we were building in C++98 mode, for
/// -Wc++98-compat.
//<editor-fold defaultstate="collapsed" desc="CheckCXX98CompatAccessibleCopy">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5577,
 FQN="CheckCXX98CompatAccessibleCopy", NM="_ZL30CheckCXX98CompatAccessibleCopyRN5clang4SemaERKNS_17InitializedEntityEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30CheckCXX98CompatAccessibleCopyRN5clang4SemaERKNS_17InitializedEntityEPNS_4ExprE")
//</editor-fold>
public static void CheckCXX98CompatAccessibleCopy(final Sema /*&*/ S, 
                              final /*const*/ InitializedEntity /*&*/ Entity, 
                              Expr /*P*/ CurInitExpr) {
  OverloadCandidateSet CandidateSet = null;
  PartialDiagnostic Diag = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert Native.$bool(S.getLangOpts().CPlusPlus11);
    
    /*const*/ RecordType /*P*/ Record = CurInitExpr.getType().$arrow().<RecordType>getAs$RecordType();
    if (!(Record != null)) {
      return;
    }
    
    SourceLocation Loc = getInitializationLoc(Entity, CurInitExpr);
    if (S.Diags.isIgnored(diag.warn_cxx98_compat_temp_copy, /*NO_COPY*/Loc)) {
      return;
    }
    
    // Find constructors which would have been considered.
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(Loc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    LookupCopyAndMoveConstructors(S, CandidateSet, cast_CXXRecordDecl(Record.getDecl()), CurInitExpr);
    
    // Perform overload resolution.
    final type$ptr<OverloadCandidate> Best = create_type$ptr();
    OverloadingResult OR = CandidateSet.BestViableFunction(S, new SourceLocation(Loc), Best);
    
    /*FIXME: Initializer produces not destroyed temporary!*/Diag = $c$.clean(new PartialDiagnostic($out_PartialDiagnostic$C_SourceRange($out_PartialDiagnostic$C_QualType($out_PartialDiagnostic$C_int($out_PartialDiagnostic$C_int($c$.track(S.PDiag(diag.warn_cxx98_compat_temp_copy)), 
                        OR.getValue()), (int)Entity.getKind().getValue()), CurInitExpr.getType()), 
            CurInitExpr.getSourceRange())));
    switch (OR) {
     case OR_Success:
      S.CheckConstructorAccess(new SourceLocation(Loc), cast_CXXConstructorDecl(Best.$star().Function), 
          new DeclAccessPair(Best.$star().FoundDecl), Entity, Diag);
      // FIXME: Check default arguments as far as that's possible.
      break;
     case OR_No_Viable_Function:
      $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), Diag)));
      CandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(CurInitExpr, true));
      break;
     case OR_Ambiguous:
      $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), Diag)));
      CandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(CurInitExpr, true));
      break;
     case OR_Deleted:
      $c$.clean($c$.track(S.Diag(new SourceLocation(Loc), Diag)));
      S.NoteDeletedFunction(Best.$star().Function);
      break;
    }
  } finally {
    if (Diag != null) { Diag.$destroy(); }
    if (CandidateSet != null) { CandidateSet.$destroy(); }
    $c$.$destroy();
  }
}


/// \brief Attempt reference initialization (C++0x [dcl.init.ref])
//<editor-fold defaultstate="collapsed" desc="TryReferenceInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4124,
 FQN="TryReferenceInitialization", NM="_ZL26TryReferenceInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL26TryReferenceInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceE")
//</editor-fold>
public static void TryReferenceInitialization(final Sema /*&*/ S, 
                          final /*const*/ InitializedEntity /*&*/ Entity, 
                          final /*const*/ InitializationKind /*&*/ Kind, 
                          Expr /*P*/ Initializer, 
                          final InitializationSequence /*&*/ Sequence) {
  QualType DestType = Entity.getType();
  QualType cv1T1 = DestType.$arrow().getAs(ReferenceType.class).getPointeeType();
  Qualifiers T1Quals/*J*/= new Qualifiers();
  QualType T1 = S.Context.getUnqualifiedArrayType(new QualType(cv1T1), T1Quals);
  QualType cv2T2 = Initializer.getType();
  Qualifiers T2Quals/*J*/= new Qualifiers();
  QualType T2 = S.Context.getUnqualifiedArrayType(new QualType(cv2T2), T2Quals);
  
  // If the initializer is the address of an overloaded function, try
  // to resolve the overloaded function. If all goes well, T2 is the
  // type of the resulting function.
  if (ResolveOverloadedFunctionForReferenceBinding(S, Initializer, cv2T2, T2, 
      new QualType(T1), Sequence)) {
    return;
  }
  
  // Delegate everything else to a subfunction.
  TryReferenceInitializationCore(S, Entity, Kind, Initializer, new QualType(cv1T1), new QualType(T1), 
      new Qualifiers(T1Quals), new QualType(cv2T2), new QualType(T2), new Qualifiers(T2Quals), Sequence);
}


/// Converts the target of reference initialization so that it has the
/// appropriate qualifiers and value kind.
///
/// In this case, 'x' is an 'int' lvalue, but it needs to be 'const int'.
/// \code
///   int x;
///   const int &r = x;
/// \endcode
///
/// In this case the reference is binding to a bitfield lvalue, which isn't
/// valid. Perform a load to create a lifetime-extended temporary instead.
/// \code
///   const int &r = someStruct.bitfield;
/// \endcode
//<editor-fold defaultstate="collapsed" desc="convertQualifiersAndValueKindIfNecessary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4163,
 FQN="convertQualifiersAndValueKindIfNecessary", NM="_ZL40convertQualifiersAndValueKindIfNecessaryRN5clang4SemaERNS_22InitializationSequenceEPNS_4ExprENS_8QualTypeENS_10QualifiersES7_b",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL40convertQualifiersAndValueKindIfNecessaryRN5clang4SemaERNS_22InitializationSequenceEPNS_4ExprENS_8QualTypeENS_10QualifiersES7_b")
//</editor-fold>
public static ExprValueKind convertQualifiersAndValueKindIfNecessary(final Sema /*&*/ S, 
                                        final InitializationSequence /*&*/ Sequence, 
                                        Expr /*P*/ Initializer, 
                                        QualType cv1T1, 
                                        Qualifiers T1Quals, 
                                        Qualifiers T2Quals, 
                                        boolean IsLValueRef) {
  boolean IsNonAddressableType = Initializer.refersToBitField()
     || Initializer.refersToVectorElement();
  if (IsNonAddressableType) {
    // C++11 [dcl.init.ref]p5: [...] Otherwise, the reference shall be an
    // lvalue reference to a non-volatile const type, or the reference shall be
    // an rvalue reference.
    //
    // If not, we can't make a temporary and bind to that. Give up and allow the
    // error to be diagnosed later.
    if (IsLValueRef && (!T1Quals.hasConst() || T1Quals.hasVolatile())) {
      assert (Initializer.isGLValue());
      return Initializer.getValueKind();
    }
    
    // Force a load so we can materialize a temporary.
    Sequence.AddLValueToRValueStep(cv1T1.getUnqualifiedType());
    return ExprValueKind.VK_RValue;
  }
  if (T1Quals.$noteq(/*NO_COPY*/T2Quals)) {
    Sequence.AddQualificationConversionStep(new QualType(cv1T1), 
        Initializer.getValueKind());
  }
  
  return Initializer.getValueKind();
}


/// \brief Attempt character array initialization from a string literal
/// (C++ [dcl.init.string], C99 6.7.8).
//<editor-fold defaultstate="collapsed" desc="TryStringLiteralInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4437,
 FQN="TryStringLiteralInitialization", NM="_ZL30TryStringLiteralInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30TryStringLiteralInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceE")
//</editor-fold>
public static void TryStringLiteralInitialization(final Sema /*&*/ S, 
                              final /*const*/ InitializedEntity /*&*/ Entity, 
                              final /*const*/ InitializationKind /*&*/ Kind, 
                              Expr /*P*/ Initializer, 
                              final InitializationSequence /*&*/ Sequence) {
  Sequence.AddStringInitStep(Entity.getType());
}


/// \brief Attempt default initialization (C++ [dcl.init]p6).
//<editor-fold defaultstate="collapsed" desc="TryDefaultInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4524,
 FQN="TryDefaultInitialization", NM="_ZL24TryDefaultInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindERNS_22InitializationSequenceE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL24TryDefaultInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindERNS_22InitializationSequenceE")
//</editor-fold>
public static void TryDefaultInitialization(final Sema /*&*/ S, 
                        final /*const*/ InitializedEntity /*&*/ Entity, 
                        final /*const*/ InitializationKind /*&*/ Kind, 
                        final InitializationSequence /*&*/ Sequence) {
  assert (Kind.getKind() == InitializationKind.InitKind.IK_Default);
  
  // C++ [dcl.init]p6:
  //   To default-initialize an object of type T means:
  //     - if T is an array type, each element is default-initialized;
  QualType DestType = S.Context.getBaseElementType(Entity.getType());
  
  //     - if T is a (possibly cv-qualified) class type (Clause 9), the default
  //       constructor for T is called (and the initialization is ill-formed if
  //       T has no accessible default constructor);
  if (DestType.$arrow().isRecordType() && S.getLangOpts().CPlusPlus) {
    TryConstructorInitialization(S, Entity, Kind, new MutableArrayRef<Expr /*P*/ >(None, true), new QualType(DestType), Sequence);
    return;
  }
  
  //     - otherwise, no initialization is performed.
  
  //   If a program calls for the default initialization of an object of
  //   a const-qualified type T, T shall be a class type with a user-provided
  //   default constructor.
  if (DestType.isConstQualified() && S.getLangOpts().CPlusPlus) {
    if (!maybeRecoverWithZeroInitialization(S, Sequence, Entity)) {
      Sequence.SetFailed(InitializationSequence.FailureKind.FK_DefaultInitOfConst);
    }
    return;
  }
  
  // If the destination type has a lifetime property, zero-initialize it.
  if (DestType.getQualifiers().hasObjCLifetime()) {
    Sequence.AddZeroInitializationStep(Entity.getType());
    return;
  }
}


/// \brief Attempt a user-defined conversion between two types (C++ [dcl.init]),
/// which enumerates all conversion functions and performs overload resolution
/// to select the best.
//<editor-fold defaultstate="collapsed" desc="TryUserDefinedConversion">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4564,
 FQN="TryUserDefinedConversion", NM="_ZL24TryUserDefinedConversionRN5clang4SemaENS_8QualTypeERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL24TryUserDefinedConversionRN5clang4SemaENS_8QualTypeERKNS_18InitializationKindEPNS_4ExprERNS_22InitializationSequenceEb")
//</editor-fold>
public static void TryUserDefinedConversion(final Sema /*&*/ S, 
                        QualType DestType, 
                        final /*const*/ InitializationKind /*&*/ Kind, 
                        Expr /*P*/ Initializer, 
                        final InitializationSequence /*&*/ Sequence, 
                        boolean TopLevelOfInitList) {
  assert (!DestType.$arrow().isReferenceType()) : "References are handled elsewhere";
  QualType SourceType = Initializer.getType();
  assert ((DestType.$arrow().isRecordType() || SourceType.$arrow().isRecordType())) : "Must have a class type to perform a user-defined conversion";
  
  // Build the candidate set directly in the initialization sequence
  // structure, so that it will persist if we fail.
  final OverloadCandidateSet /*&*/ CandidateSet = Sequence.getFailedCandidateSet();
  CandidateSet.clear();
  
  // Determine whether we are allowed to call explicit constructors or
  // explicit conversion operators.
  boolean AllowExplicit = Kind.AllowExplicit();
  {
    
    /*const*/ RecordType /*P*/ DestRecordType = DestType.$arrow().<RecordType>getAs$RecordType();
    if ((DestRecordType != null)) {
      // The type we're converting to is a class type. Enumerate its constructors
      // to see if there is a suitable conversion.
      CXXRecordDecl /*P*/ DestRecordDecl = cast_CXXRecordDecl(DestRecordType.getDecl());
      
      // Try to complete the type we're converting to.
      if (S.isCompleteType(Kind.getLocation(), new QualType(DestType))) {
        DeclContextLookupResult R = S.LookupConstructors(DestRecordDecl);
        // The container holding the constructors can under certain conditions
        // be changed while iterating. To be safe we copy the lookup results
        // to a new container.
        SmallVector<NamedDecl /*P*/ > CopyOfCon/*J*/= new SmallVector<NamedDecl /*P*/ >(JD$T.INSTANCE, 8, R.begin(), R.end(), (NamedDecl /*P*/ )null);
        for (type$ptr<NamedDecl /*P*/ /*P*/> Con = $tryClone(CopyOfCon.begin()), /*P*/ ConEnd = $tryClone(CopyOfCon.end());
             $noteq_iter(Con, ConEnd); Con.$preInc()) {
          NamedDecl /*P*/ D = Con.$star();
          ConstructorInfo Info = getConstructorInfo(D);
          if (!(Info.Constructor != null)) {
            continue;
          }
          if (!Info.Constructor.isInvalidDecl()
             && Info.Constructor.isConvertingConstructor(AllowExplicit)) {
            if ((Info.ConstructorTmpl != null)) {
              S.AddTemplateOverloadCandidate(Info.ConstructorTmpl, new DeclAccessPair(Info.FoundDecl), 
                  /*ExplicitArgs*/ (TemplateArgumentListInfo /*P*/ )null, 
                  new ArrayRef<Expr /*P*/ >(Initializer, true), CandidateSet, 
                  /*SuppressUserConversions=*/ true);
            } else {
              S.AddOverloadCandidate(Info.Constructor, new DeclAccessPair(Info.FoundDecl), 
                  new ArrayRef<Expr /*P*/ >(Initializer, true), CandidateSet, 
                  /*SuppressUserConversions=*/ true);
            }
          }
        }
      }
    }
  }
  
  SourceLocation DeclLoc = Initializer.getLocStart();
  {
    
    /*const*/ RecordType /*P*/ SourceRecordType = SourceType.$arrow().<RecordType>getAs$RecordType();
    if ((SourceRecordType != null)) {
      // The type we're converting from is a class type, enumerate its conversion
      // functions.
      
      // We can only enumerate the conversion functions for a complete type; if
      // the type isn't complete, simply skip this step.
      if (S.isCompleteType(new SourceLocation(DeclLoc), new QualType(SourceType))) {
        CXXRecordDecl /*P*/ SourceRecordDecl = cast_CXXRecordDecl(SourceRecordType.getDecl());
        
        final /*const*/ iterator_range<NamedDecl> /*&*/ Conversions = SourceRecordDecl.getVisibleConversionFunctions();
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
          if (AllowExplicit || !Conv.isExplicit()) {
            if ((ConvTemplate != null)) {
              S.AddTemplateConversionCandidate(ConvTemplate, new DeclAccessPair(I.getPair()), 
                  ActingDC, Initializer, new QualType(DestType), 
                  CandidateSet, AllowExplicit);
            } else {
              S.AddConversionCandidate(Conv, new DeclAccessPair(I.getPair()), ActingDC, 
                  Initializer, new QualType(DestType), CandidateSet, 
                  AllowExplicit);
            }
          }
        }
      }
    }
  }
  
  // Perform overload resolution. If it fails, return the failed result.
  final type$ptr<OverloadCandidate> Best = create_type$ptr();
  {
    OverloadingResult Result = CandidateSet.BestViableFunction(S, new SourceLocation(DeclLoc), Best, true);
    if ((Result.getValue() != 0)) {
      Sequence.SetOverloadFailure(InitializationSequence.FailureKind.FK_UserConversionOverloadFailed, 
          Result);
      return;
    }
  }
  
  FunctionDecl /*P*/ Function = Best.$star().Function;
  Function.setReferenced();
  boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
  if (isa_CXXConstructorDecl(Function)) {
    // Add the user-defined conversion step. Any cv-qualification conversion is
    // subsumed by the initialization. Per DR5, the created temporary is of the
    // cv-unqualified type of the destination.
    Sequence.AddUserConversionStep(Function, new DeclAccessPair(Best.$star().FoundDecl), 
        DestType.getUnqualifiedType(), 
        HadMultipleCandidates);
    return;
  }
  
  // Add the user-defined conversion step that calls the conversion function.
  QualType ConvType = Function.getCallResultType();
  if ((ConvType.$arrow().<RecordType>getAs$RecordType() != null)) {
    // If we're converting to a class type, there may be an copy of
    // the resulting temporary object (possible to create an object of
    // a base class type). That copy is not a separate conversion, so
    // we just make a note of the actual destination type (possibly a
    // base class of the type returned by the conversion function) and
    // let the user-defined conversion step handle the conversion.
    Sequence.AddUserConversionStep(Function, new DeclAccessPair(Best.$star().FoundDecl), new QualType(DestType), 
        HadMultipleCandidates);
    return;
  }
  
  Sequence.AddUserConversionStep(Function, new DeclAccessPair(Best.$star().FoundDecl), new QualType(ConvType), 
      HadMultipleCandidates);
  
  // If the conversion following the call to the conversion function
  // is interesting, add it as a separate step.
  if ((Best.$star().Unnamed_field12.FinalConversion.First.getValue() != 0) || (Best.$star().Unnamed_field12.FinalConversion.Second.getValue() != 0)
     || (Best.$star().Unnamed_field12.FinalConversion.Third.getValue() != 0)) {
    ImplicitConversionSequence ICS = null;
    try {
      ICS/*J*/= new ImplicitConversionSequence();
      ICS.setStandard();
      ICS.Unnamed_field2.Standard.$assign(Best.$star().Unnamed_field12.FinalConversion);
      Sequence.AddConversionSequenceStep(ICS, new QualType(DestType), TopLevelOfInitList);
    } finally {
      if (ICS != null) { ICS.$destroy(); }
    }
  }
}


/// An egregious hack for compatibility with libstdc++-4.2: in <tr1/hashtable>,
/// a function with a pointer return type contains a 'return false;' statement.
/// In C++11, 'false' is not a null pointer, so this breaks the build of any
/// code using that header.
///
/// Work around this by treating 'return false;' as zero-initializing the result
/// if it's used in a pointer-returning function in a system header.
//<editor-fold defaultstate="collapsed" desc="isLibstdcxxPointerReturnFalseHack">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4721,
 FQN="isLibstdcxxPointerReturnFalseHack", NM="_ZL33isLibstdcxxPointerReturnFalseHackRN5clang4SemaERKNS_17InitializedEntityEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL33isLibstdcxxPointerReturnFalseHackRN5clang4SemaERKNS_17InitializedEntityEPKNS_4ExprE")
//</editor-fold>
public static boolean isLibstdcxxPointerReturnFalseHack(final Sema /*&*/ S, 
                                 final /*const*/ InitializedEntity /*&*/ Entity, 
                                 /*const*/ Expr /*P*/ Init) {
  return S.getLangOpts().CPlusPlus11
     && Entity.getKind() == InitializedEntity.EntityKind.EK_Result
     && Entity.getType().$arrow().isPointerType()
     && isa_CXXBoolLiteralExpr(Init)
     && !cast_CXXBoolLiteralExpr(Init).getValue()
     && S.getSourceManager().isInSystemHeader(Init.getExprLoc());
}


/// Determines whether this expression is an acceptable ICR source.
//<editor-fold defaultstate="collapsed" desc="isInvalidICRSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4736,
 FQN="isInvalidICRSource", NM="_ZL18isInvalidICRSourceRN5clang10ASTContextEPNS_4ExprEbRb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL18isInvalidICRSourceRN5clang10ASTContextEPNS_4ExprEbRb")
//</editor-fold>
public static InvalidICRKind isInvalidICRSource(final ASTContext /*&*/ C, Expr /*P*/ e, 
                  boolean isAddressOf, final bool$ref/*bool &*/ isWeakAccess) {
  // Skip parens.
  e = e.IgnoreParens();
  {
    
    // Skip address-of nodes.
    UnaryOperator /*P*/ op = dyn_cast_UnaryOperator(e);
    if ((op != null)) {
      if (op.getOpcode() == UnaryOperatorKind.UO_AddrOf) {
        return isInvalidICRSource(C, op.getSubExpr(), /*addressof*/ true, 
            isWeakAccess);
      }
      // Skip certain casts.
    } else {
      CastExpr /*P*/ ce = dyn_cast_CastExpr(e);
      if ((ce != null)) {
        switch (ce.getCastKind()) {
         case CK_Dependent:
         case CK_BitCast:
         case CK_LValueBitCast:
         case CK_NoOp:
          return isInvalidICRSource(C, ce.getSubExpr(), isAddressOf, isWeakAccess);
         case CK_ArrayToPointerDecay:
          return InvalidICRKind.IIK_nonscalar;
         case CK_NullToPointer:
          return InvalidICRKind.IIK_okay;
         default:
          break;
        }
        // If we have a declaration reference, it had better be a local variable.
      } else if (isa_DeclRefExpr(e)) {
        // set isWeakAccess to true, to mean that there will be an implicit 
        // load which requires a cleanup.
        if (e.getType().getObjCLifetime() == Qualifiers.ObjCLifetime.OCL_Weak) {
          isWeakAccess.$set(true);
        }
        if (!isAddressOf) {
          return InvalidICRKind.IIK_nonlocal;
        }
        
        VarDecl /*P*/ var = dyn_cast_VarDecl(cast_DeclRefExpr(e).getDecl());
        if (!(var != null)) {
          return InvalidICRKind.IIK_nonlocal;
        }
        
        return (var.hasLocalStorage() ? InvalidICRKind.IIK_okay : InvalidICRKind.IIK_nonlocal);
        // If we have a conditional operator, check both sides.
      } else {
        ConditionalOperator /*P*/ cond = dyn_cast_ConditionalOperator(e);
        if ((cond != null)) {
          {
            InvalidICRKind iik = isInvalidICRSource(C, cond.getLHS(), isAddressOf, 
                isWeakAccess);
            if ((iik.getValue() != 0)) {
              return iik;
            }
          }
          
          return isInvalidICRSource(C, cond.getRHS(), isAddressOf, isWeakAccess);
          // These are never scalar.
        } else if (isa_ArraySubscriptExpr(e)) {
          return InvalidICRKind.IIK_nonscalar;
          // Otherwise, it needs to be a null pointer constant.
        } else {
          return ((e.isNullPointerConstant(C, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNull).getValue() != 0) ? InvalidICRKind.IIK_okay : InvalidICRKind.IIK_nonlocal);
        }
      }
    }
  }
  
  return InvalidICRKind.IIK_nonlocal;
}


/// Check whether the given expression is a valid operand for an
/// indirect copy/restore.
//<editor-fold defaultstate="collapsed" desc="checkIndirectCopyRestoreSource">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4803,
 FQN="checkIndirectCopyRestoreSource", NM="_ZL30checkIndirectCopyRestoreSourceRN5clang4SemaEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30checkIndirectCopyRestoreSourceRN5clang4SemaEPNS_4ExprE")
//</editor-fold>
public static void checkIndirectCopyRestoreSource(final Sema /*&*/ S, Expr /*P*/ src) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    assert (src.isRValue());
    bool$ref isWeakAccess = create_bool$ref(false);
    InvalidICRKind iik = isInvalidICRSource(S.Context, src, false, isWeakAccess);
    // If isWeakAccess to true, there will be an implicit 
    // load which requires a cleanup.
    if (S.getLangOpts().ObjCAutoRefCount && isWeakAccess.$deref()) {
      S.Cleanup.setExprNeedsCleanups(true);
    }
    if (iik == InvalidICRKind.IIK_okay) {
      return;
    }
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(src.getExprLoc(), diag.err_arc_nonlocal_writeback)), 
            ((/*uint*/int)iik.getValue() - 1)),  // shift index into diagnostic explanations
        src.getSourceRange()));
  } finally {
    $c$.$destroy();
  }
}


/// \brief Determine whether we have compatible array types for the
/// purposes of GNU by-copy array initialization.
//<editor-fold defaultstate="collapsed" desc="hasCompatibleArrayTypes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4821,
 FQN="hasCompatibleArrayTypes", NM="_ZL23hasCompatibleArrayTypesRN5clang10ASTContextEPKNS_9ArrayTypeES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL23hasCompatibleArrayTypesRN5clang10ASTContextEPKNS_9ArrayTypeES4_")
//</editor-fold>
public static boolean hasCompatibleArrayTypes(final ASTContext /*&*/ Context, /*const*/ ArrayType /*P*/ Dest, 
                       /*const*/ ArrayType /*P*/ Source) {
  // If the source and destination array types are equivalent, we're
  // done.
  if (Context.hasSameType(new QualType(Dest, 0), new QualType(Source, 0))) {
    return true;
  }
  
  // Make sure that the element types are the same.
  if (!Context.hasSameType(Dest.getElementType(), Source.getElementType())) {
    return false;
  }
  
  // The only mismatch we allow is when the destination is an
  // incomplete array type and the source is a constant array type.
  return Source.isConstantArrayType() && Dest.isIncompleteArrayType();
}

//<editor-fold defaultstate="collapsed" desc="tryObjCWritebackConversion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4837,
 FQN="tryObjCWritebackConversion", NM="_ZL26tryObjCWritebackConversionRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL26tryObjCWritebackConversionRN5clang4SemaERNS_22InitializationSequenceERKNS_17InitializedEntityEPNS_4ExprE")
//</editor-fold>
public static boolean tryObjCWritebackConversion(final Sema /*&*/ S, 
                          final InitializationSequence /*&*/ Sequence, 
                          final /*const*/ InitializedEntity /*&*/ Entity, 
                          Expr /*P*/ Initializer) {
  boolean ArrayDecay = false;
  QualType ArgType = Initializer.getType();
  QualType ArgPointee/*J*/= new QualType();
  {
    /*const*/ ArrayType /*P*/ ArgArrayType = S.Context.getAsArrayType(new QualType(ArgType));
    if ((ArgArrayType != null)) {
      ArrayDecay = true;
      ArgPointee.$assignMove(ArgArrayType.getElementType());
      ArgType.$assignMove(S.Context.getPointerType(new QualType(ArgPointee)));
    }
  }
  
  // Handle write-back conversion.
  QualType ConvertedArgType/*J*/= new QualType();
  if (!S.isObjCWritebackConversion(new QualType(ArgType), Entity.getType(), 
      ConvertedArgType)) {
    return false;
  }
  
  // We should copy unless we're passing to an argument explicitly
  // marked 'out'.
  boolean ShouldCopy = true;
  {
    ParmVarDecl /*P*/ param = cast_or_null_ParmVarDecl(Entity.getDecl());
    if ((param != null)) {
      ShouldCopy = (param.getObjCDeclQualifier() != ParmVarDecl.ObjCDeclQualifier.OBJC_TQ_Out);
    }
  }
  
  // Do we need an lvalue conversion?
  if (ArrayDecay || Initializer.isGLValue()) {
    ImplicitConversionSequence ICS = null;
    try {
      ICS/*J*/= new ImplicitConversionSequence();
      ICS.setStandard();
      ICS.Unnamed_field2.Standard.setAsIdentityConversion();
      
      QualType ResultType/*J*/= new QualType();
      if (ArrayDecay) {
        ICS.Unnamed_field2.Standard.First = ImplicitConversionKind.ICK_Array_To_Pointer;
        ResultType.$assignMove(S.Context.getPointerType(new QualType(ArgPointee)));
      } else {
        ICS.Unnamed_field2.Standard.First = ImplicitConversionKind.ICK_Lvalue_To_Rvalue;
        ResultType.$assignMove(Initializer.getType().getNonLValueExprType(S.Context));
      }
      
      Sequence.AddConversionSequenceStep(ICS, new QualType(ResultType));
    } finally {
      if (ICS != null) { ICS.$destroy(); }
    }
  }
  
  Sequence.AddPassByIndirectCopyRestoreStep(Entity.getType(), ShouldCopy);
  return true;
}

//<editor-fold defaultstate="collapsed" desc="TryOCLSamplerInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4884,
 FQN="TryOCLSamplerInitialization", NM="_ZL27TryOCLSamplerInitializationRN5clang4SemaERNS_22InitializationSequenceENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL27TryOCLSamplerInitializationRN5clang4SemaERNS_22InitializationSequenceENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public static boolean TryOCLSamplerInitialization(final Sema /*&*/ S, 
                           final InitializationSequence /*&*/ Sequence, 
                           QualType DestType, 
                           Expr /*P*/ Initializer) {
  if (!S.getLangOpts().OpenCL || !DestType.$arrow().isSamplerT()
     || !Initializer.isIntegerConstantExpr(S.getASTContext())) {
    return false;
  }
  
  Sequence.AddOCLSamplerInitStep(new QualType(DestType));
  return true;
}


//
// OpenCL 1.2 spec, s6.12.10
//
// The event argument can also be used to associate the
// async_work_group_copy with a previous async copy allowing
// an event to be shared by multiple async copies; otherwise
// event should be zero.
//
//<editor-fold defaultstate="collapsed" desc="TryOCLZeroEventInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4904,
 FQN="TryOCLZeroEventInitialization", NM="_ZL29TryOCLZeroEventInitializationRN5clang4SemaERNS_22InitializationSequenceENS_8QualTypeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL29TryOCLZeroEventInitializationRN5clang4SemaERNS_22InitializationSequenceENS_8QualTypeEPNS_4ExprE")
//</editor-fold>
public static boolean TryOCLZeroEventInitialization(final Sema /*&*/ S, 
                             final InitializationSequence /*&*/ Sequence, 
                             QualType DestType, 
                             Expr /*P*/ Initializer) {
  if (!S.getLangOpts().OpenCL || !DestType.$arrow().isEventT()
     || !Initializer.isIntegerConstantExpr(S.getASTContext())
     || (Initializer.EvaluateKnownConstInt(S.getASTContext()).$noteq(0))) {
    return false;
  }
  
  Sequence.AddOCLZeroEventStep(new QualType(DestType));
  return true;
}


/// Tries to get a FunctionDecl out of `E`. If it succeeds and we can take the
/// address of that function, this returns true. Otherwise, it returns false.
//<editor-fold defaultstate="collapsed" desc="isExprAnUnaddressableFunction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 4930,
 FQN="isExprAnUnaddressableFunction", NM="_ZL29isExprAnUnaddressableFunctionRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL29isExprAnUnaddressableFunctionRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static boolean isExprAnUnaddressableFunction(final Sema /*&*/ S, /*const*/ Expr /*P*/ E) {
  /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(E);
  if (!(DRE != null) || !isa_FunctionDecl(DRE.getDecl$Const())) {
    return false;
  }
  
  return !S.checkAddressOfFunctionIsAvailable(cast_FunctionDecl(DRE.getDecl$Const()));
}


//===----------------------------------------------------------------------===//
// Perform initialization
//===----------------------------------------------------------------------===//
//<editor-fold defaultstate="collapsed" desc="getAssignmentAction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5240,
 FQN="getAssignmentAction", NM="_ZL19getAssignmentActionRKN5clang17InitializedEntityEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL19getAssignmentActionRKN5clang17InitializedEntityEb")
//</editor-fold>
public static Sema.AssignmentAction getAssignmentAction(final /*const*/ InitializedEntity /*&*/ Entity) {
  return getAssignmentAction(Entity, false);
}
public static Sema.AssignmentAction getAssignmentAction(final /*const*/ InitializedEntity /*&*/ Entity, boolean Diagnose/*= false*/) {
  switch (Entity.getKind()) {
   case EK_Variable:
   case EK_New:
   case EK_Exception:
   case EK_Base:
   case EK_Delegating:
    return Sema.AssignmentAction.AA_Initializing;
   case EK_Parameter:
    if ((Entity.getDecl() != null)
       && isa_ObjCMethodDecl(Entity.getDecl().getDeclContext())) {
      return Sema.AssignmentAction.AA_Sending;
    }
    
    return Sema.AssignmentAction.AA_Passing;
   case EK_Parameter_CF_Audited:
    if ((Entity.getDecl() != null)
       && isa_ObjCMethodDecl(Entity.getDecl().getDeclContext())) {
      return Sema.AssignmentAction.AA_Sending;
    }
    
    return !Diagnose ? Sema.AssignmentAction.AA_Passing : Sema.AssignmentAction.AA_Passing_CFAudited;
   case EK_Result:
    return Sema.AssignmentAction.AA_Returning;
   case EK_Temporary:
   case EK_RelatedResult:
    // FIXME: Can we tell apart casting vs. converting?
    return Sema.AssignmentAction.AA_Casting;
   case EK_Member:
   case EK_ArrayElement:
   case EK_VectorElement:
   case EK_ComplexElement:
   case EK_BlockElement:
   case EK_LambdaCapture:
   case EK_CompoundLiteralInit:
    return Sema.AssignmentAction.AA_Initializing;
  }
  throw new llvm_unreachable("Invalid EntityKind!");
}


/// \brief Whether we should bind a created object as a temporary when
/// initializing the given entity.
//<editor-fold defaultstate="collapsed" desc="shouldBindAsTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5287,
 FQN="shouldBindAsTemporary", NM="_ZL21shouldBindAsTemporaryRKN5clang17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL21shouldBindAsTemporaryRKN5clang17InitializedEntityE")
//</editor-fold>
public static boolean shouldBindAsTemporary(final /*const*/ InitializedEntity /*&*/ Entity) {
  switch (Entity.getKind()) {
   case EK_ArrayElement:
   case EK_Member:
   case EK_Result:
   case EK_New:
   case EK_Variable:
   case EK_Base:
   case EK_Delegating:
   case EK_VectorElement:
   case EK_ComplexElement:
   case EK_Exception:
   case EK_BlockElement:
   case EK_LambdaCapture:
   case EK_CompoundLiteralInit:
    return false;
   case EK_Parameter:
   case EK_Parameter_CF_Audited:
   case EK_Temporary:
   case EK_RelatedResult:
    return true;
  }
  throw new llvm_unreachable("missed an InitializedEntity kind?");
}


/// \brief Whether the given entity, when initialized with an object
/// created for that initialization, requires destruction.
//<editor-fold defaultstate="collapsed" desc="shouldDestroyTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5316,
 FQN="shouldDestroyTemporary", NM="_ZL22shouldDestroyTemporaryRKN5clang17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL22shouldDestroyTemporaryRKN5clang17InitializedEntityE")
//</editor-fold>
public static boolean shouldDestroyTemporary(final /*const*/ InitializedEntity /*&*/ Entity) {
  switch (Entity.getKind()) {
   case EK_Result:
   case EK_New:
   case EK_Base:
   case EK_Delegating:
   case EK_VectorElement:
   case EK_ComplexElement:
   case EK_BlockElement:
   case EK_LambdaCapture:
    return false;
   case EK_Member:
   case EK_Variable:
   case EK_Parameter:
   case EK_Parameter_CF_Audited:
   case EK_Temporary:
   case EK_ArrayElement:
   case EK_Exception:
   case EK_CompoundLiteralInit:
   case EK_RelatedResult:
    return true;
  }
  throw new llvm_unreachable("missed an InitializedEntity kind?");
}


/// \brief Look for copy and move constructors and constructor templates, for
/// copying an object via direct-initialization (per C++11 [dcl.init]p16).
//<editor-fold defaultstate="collapsed" desc="LookupCopyAndMoveConstructors">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5345,
 FQN="LookupCopyAndMoveConstructors", NM="_ZL29LookupCopyAndMoveConstructorsRN5clang4SemaERNS_20OverloadCandidateSetEPNS_13CXXRecordDeclEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL29LookupCopyAndMoveConstructorsRN5clang4SemaERNS_20OverloadCandidateSetEPNS_13CXXRecordDeclEPNS_4ExprE")
//</editor-fold>
public static void LookupCopyAndMoveConstructors(final Sema /*&*/ S, 
                             final OverloadCandidateSet /*&*/ CandidateSet, 
                             CXXRecordDecl /*P*/ Class, 
                             Expr /*P*/ CurInitExpr) {
  DeclContextLookupResult R = S.LookupConstructors(Class);
  // The container holding the constructors can under certain conditions
  // be changed while iterating (e.g. because of deserialization).
  // To be safe we copy the lookup results to a new container.
  SmallVector<NamedDecl /*P*/ > Ctors/*J*/= new SmallVector<NamedDecl /*P*/ >(JD$T.INSTANCE, 16, R.begin(), R.end(), (NamedDecl /*P*/ )null);
  for (type$ptr<NamedDecl /*P*/ /*P*/> CI = $tryClone(Ctors.begin()), /*P*/ CE = $tryClone(Ctors.end()); $noteq_iter(CI, CE); CI.$preInc()) {
    NamedDecl /*P*/ D = CI.$star();
    ConstructorInfo Info = getConstructorInfo(D);
    if (!(Info.Constructor != null)) {
      continue;
    }
    if (!(Info.ConstructorTmpl != null)) {
      // Handle copy/move constructors, only.
      if (Info.Constructor.isInvalidDecl()
         || !Info.Constructor.isCopyOrMoveConstructor()
         || !Info.Constructor.isConvertingConstructor(/*AllowExplicit=*/ true)) {
        continue;
      }
      
      S.AddOverloadCandidate(Info.Constructor, new DeclAccessPair(Info.FoundDecl), 
          new ArrayRef<Expr /*P*/ >(CurInitExpr, true), CandidateSet);
      continue;
    }
    
    // Handle constructor templates.
    if (Info.ConstructorTmpl.isInvalidDecl()) {
      continue;
    }
    if (!Info.Constructor.isConvertingConstructor(/*AllowExplicit=*/ true)) {
      continue;
    }
    
    // FIXME: Do we need to limit this to copy-constructor-like
    // candidates?
    S.AddTemplateOverloadCandidate(Info.ConstructorTmpl, new DeclAccessPair(Info.FoundDecl), 
        (TemplateArgumentListInfo /*P*/ )null, new ArrayRef<Expr /*P*/ >(CurInitExpr, true), CandidateSet, true);
  }
}


/// \brief Get the location at which initialization diagnostics should appear.
//<editor-fold defaultstate="collapsed" desc="getInitializationLoc">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5388,
 FQN="getInitializationLoc", NM="_ZL20getInitializationLocRKN5clang17InitializedEntityEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL20getInitializationLocRKN5clang17InitializedEntityEPNS_4ExprE")
//</editor-fold>
public static SourceLocation getInitializationLoc(final /*const*/ InitializedEntity /*&*/ Entity, 
                    Expr /*P*/ Initializer) {
  switch (Entity.getKind()) {
   case EK_Result:
    return Entity.getReturnLoc();
   case EK_Exception:
    return Entity.getThrowLoc();
   case EK_Variable:
    return Entity.getDecl().getLocation();
   case EK_LambdaCapture:
    return Entity.getCaptureLoc();
   case EK_ArrayElement:
   case EK_Member:
   case EK_Parameter:
   case EK_Parameter_CF_Audited:
   case EK_Temporary:
   case EK_New:
   case EK_Base:
   case EK_Delegating:
   case EK_VectorElement:
   case EK_ComplexElement:
   case EK_BlockElement:
   case EK_CompoundLiteralInit:
   case EK_RelatedResult:
    return Initializer.getLocStart();
  }
  throw new llvm_unreachable("missed an InitializedEntity kind?");
}


/// \brief Make a (potentially elidable) temporary copy of the object
/// provided by the given initializer by calling the appropriate copy
/// constructor.
///
/// \param S The Sema object used for type-checking.
///
/// \param T The type of the temporary object, which must either be
/// the type of the initializer expression or a superclass thereof.
///
/// \param Entity The entity being initialized.
///
/// \param CurInit The initializer expression.
///
/// \param IsExtraneousCopy Whether this is an "extraneous" copy that
/// is permitted in C++03 (but not C++0x) when binding a reference to
/// an rvalue.
///
/// \returns An expression that copies the initializer expression into
/// a temporary object, or an error expression if a copy could not be
/// created.
//<editor-fold defaultstate="collapsed" desc="CopyObject">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5441,
 FQN="CopyObject", NM="_ZL10CopyObjectRN5clang4SemaENS_8QualTypeERKNS_17InitializedEntityENS_12ActionResultIPNS_4ExprELb1EEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL10CopyObjectRN5clang4SemaENS_8QualTypeERKNS_17InitializedEntityENS_12ActionResultIPNS_4ExprELb1EEEb")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > CopyObject(final Sema /*&*/ S, 
          QualType T, 
          final /*const*/ InitializedEntity /*&*/ Entity, 
          ActionResultTTrue<Expr /*P*/ > CurInit, 
          boolean IsExtraneousCopy) {
  OverloadCandidateSet CandidateSet = null;
  try {
    if (CurInit.isInvalid()) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, CurInit);
    }
    // Determine which class type we're copying to.
    Expr /*P*/ CurInitExpr = (Expr /*P*/ )CurInit.get();
    CXXRecordDecl /*P*/ Class = null;
    {
      /*const*/ RecordType /*P*/ Record = T.$arrow().<RecordType>getAs$RecordType();
      if ((Record != null)) {
        Class = cast_CXXRecordDecl(Record.getDecl());
      }
    }
    if (!(Class != null)) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, CurInit);
    }
    
    // C++0x [class.copy]p32:
    //   When certain criteria are met, an implementation is allowed to
    //   omit the copy/move construction of a class object, even if the
    //   copy/move constructor and/or destructor for the object have
    //   side effects. [...]
    //     - when a temporary class object that has not been bound to a
    //       reference (12.2) would be copied/moved to a class object
    //       with the same cv-unqualified type, the copy/move operation
    //       can be omitted by constructing the temporary object
    //       directly into the target of the omitted copy/move
    //
    // Note that the other three bullets are handled elsewhere. Copy
    // elision for return statements and throw expressions are handled as part
    // of constructor initialization, while copy elision for exception handlers
    // is handled by the run-time.
    boolean Elidable = CurInitExpr.isTemporaryObject(S.Context, Class);
    SourceLocation Loc = getInitializationLoc(Entity, CurInit.get());
    
    // Make sure that the type we are copying is complete.
    if (S.RequireCompleteType(new SourceLocation(Loc), new QualType(T), diag.err_temp_copy_incomplete)) {
      return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, CurInit);
    }
    
    // Perform overload resolution using the class's copy/move constructors.
    // Only consider constructors and constructor templates. Per
    // C++0x [dcl.init]p16, second bullet to class types, this initialization
    // is direct-initialization.
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(Loc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    LookupCopyAndMoveConstructors(S, CandidateSet, Class, CurInitExpr);
    
    boolean HadMultipleCandidates = ($greater_uint(CandidateSet.size(), 1));
    
    final type$ptr<OverloadCandidate> Best = create_type$ptr();
    switch (CandidateSet.BestViableFunction(S, new SourceLocation(Loc), Best)) {
     case OR_Success:
      break;
     case OR_No_Viable_Function:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), IsExtraneousCopy && !S.isSFINAEContext().$bool() ? diag.ext_rvalue_to_reference_temp_copy_no_viable : diag.err_temp_copy_no_viable)), 
                      (int)Entity.getKind().getValue()), CurInitExpr.getType()), 
              CurInitExpr.getSourceRange()));
          CandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_AllCandidates, new ArrayRef<Expr /*P*/ >(CurInitExpr, true));
          if (!IsExtraneousCopy || S.isSFINAEContext().$bool()) {
            return ExprError();
          }
          return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, CurInit);
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Ambiguous:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_temp_copy_ambiguous)), 
                      (int)Entity.getKind().getValue()), CurInitExpr.getType()), 
              CurInitExpr.getSourceRange()));
          CandidateSet.NoteCandidates(S, OverloadCandidateDisplayKind.OCD_ViableCandidates, new ArrayRef<Expr /*P*/ >(CurInitExpr, true));
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
     case OR_Deleted:
      {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_temp_copy_deleted)), 
                      (int)Entity.getKind().getValue()), CurInitExpr.getType()), 
              CurInitExpr.getSourceRange()));
          S.NoteDeletedFunction(Best.$star().Function);
          return ExprError();
        } finally {
          $c$.$destroy();
        }
      }
    }
    
    CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(Best.$star().Function);
    SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
    CurInit.get(); // Ownership transferred into MultiExprArg, below.
    
    S.CheckConstructorAccess(new SourceLocation(Loc), Constructor, new DeclAccessPair(Best.$star().FoundDecl), Entity, 
        IsExtraneousCopy);
    if (IsExtraneousCopy) {
      // If this is a totally extraneous copy for C++03 reference
      // binding purposes, just return the original initialization
      // expression. We don't generate an (elided) copy operation here
      // because doing so would require us to pass down a flag to avoid
      // infinite recursion, where each step adds another extraneous,
      // elidable copy.
      
      // Instantiate the default arguments of any extra parameters in
      // the selected copy constructor, as if we were going to create a
      // proper call to the copy constructor.
      for (/*uint*/int I = 1, N = Constructor.getNumParams(); I != N; ++I) {
        ParmVarDecl /*P*/ Parm = Constructor.getParamDecl(I);
        if (S.RequireCompleteType(new SourceLocation(Loc), Parm.getType(), 
            diag.err_call_incomplete_argument)) {
          break;
        }
        
        // Build the default argument expression; we don't actually care
        // if this succeeds or not, because this routine will complain
        // if there was a problem.
        S.BuildCXXDefaultArgExpr(new SourceLocation(Loc), Constructor, Parm);
      }
      
      return new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, CurInitExpr);
    }
    
    // Determine the arguments required to actually perform the
    // constructor call (we might have derived-to-base conversions, or
    // the copy constructor may have default arguments).
    if (S.CompleteConstructorCall(Constructor, new MutableArrayRef<Expr /*P*/ >(CurInitExpr, true), new SourceLocation(Loc), ConstructorArgs)) {
      return ExprError();
    }
    
    // Actually perform the constructor call.
    CurInit.$assignMove(S.BuildCXXConstructExpr(new SourceLocation(Loc), new QualType(T), Best.$star().FoundDecl.$NamedDecl$P(), Constructor, 
            Elidable, 
            new MutableArrayRef<Expr /*P*/ >(ConstructorArgs, true), 
            HadMultipleCandidates, 
            /*ListInit*/ false, 
            /*StdInitListInit*/ false, 
            /*ZeroInit*/ false, 
            CXXConstructExpr.ConstructionKind.CK_Complete.getValue(), 
            new SourceRange()));
    
    // If we're supposed to bind temporaries, do so.
    if (!CurInit.isInvalid() && shouldBindAsTemporary(Entity)) {
      CurInit.$assignMove(S.MaybeBindToTemporary(CurInit.getAs(Expr.class)));
    }
    return new ActionResultTTrue<Expr /*P*/ >(JD$Move.INSTANCE, CurInit);
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="isReferenceBinding">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5646,
 FQN="isReferenceBinding", NM="_ZL18isReferenceBindingRKN5clang22InitializationSequence4StepE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL18isReferenceBindingRKN5clang22InitializationSequence4StepE")
//</editor-fold>
public static boolean isReferenceBinding(final /*const*/ InitializationSequence.Step /*&*/ s) {
  return s.Kind == InitializationSequence.StepKind.SK_BindReference
     || s.Kind == InitializationSequence.StepKind.SK_BindReferenceToTemporary;
}


/// Returns true if the parameters describe a constructor initialization of
/// an explicit temporary object, e.g. "Point(x, y)".
//<editor-fold defaultstate="collapsed" desc="isExplicitTemporary">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5653,
 FQN="isExplicitTemporary", NM="_ZL19isExplicitTemporaryRKN5clang17InitializedEntityERKNS_18InitializationKindEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL19isExplicitTemporaryRKN5clang17InitializedEntityERKNS_18InitializationKindEj")
//</editor-fold>
public static boolean isExplicitTemporary(final /*const*/ InitializedEntity /*&*/ Entity, 
                   final /*const*/ InitializationKind /*&*/ Kind, 
                   /*uint*/int NumArgs) {
  switch (Entity.getKind()) {
   case EK_Temporary:
   case EK_CompoundLiteralInit:
   case EK_RelatedResult:
    break;
   default:
    return false;
  }
  switch (Kind.getKind()) {
   case IK_DirectList:
    return true;
   case IK_Direct:
   case IK_Value:
    // FIXME: Hack to work around cast weirdness.
    return NumArgs != 1;
   default:
    return false;
  }
}

//<editor-fold defaultstate="collapsed" desc="PerformConstructorInitialization">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5677,
 FQN="PerformConstructorInitialization", NM="_ZL32PerformConstructorInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEERKNS_22InitializationSequence4StepERbbbNS_14SourceLocationESI_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL32PerformConstructorInitializationRN5clang4SemaERKNS_17InitializedEntityERKNS_18InitializationKindEN4llvm15MutableArrayRefIPNS_4ExprEEERKNS_22InitializationSequence4StepERbbbNS_14SourceLocationESI_")
//</editor-fold>
public static ActionResultTTrue<Expr /*P*/ > PerformConstructorInitialization(final Sema /*&*/ S, 
                                final /*const*/ InitializedEntity /*&*/ Entity, 
                                final /*const*/ InitializationKind /*&*/ Kind, 
                                MutableArrayRef<Expr /*P*/ > Args, 
                                final /*const*/ InitializationSequence.Step /*&*/ Step, 
                                final bool$ref/*bool &*/ ConstructorInitRequiresZeroInit, 
                                boolean IsListInitialization, 
                                boolean IsStdInitListInitialization, 
                                SourceLocation LBraceLoc, 
                                SourceLocation RBraceLoc) {
  /*uint*/int NumArgs = Args.size();
  CXXConstructorDecl /*P*/ Constructor = cast_CXXConstructorDecl(Step.Unnamed_field2.Function.Function);
  boolean HadMultipleCandidates = Step.Unnamed_field2.Function.HadMultipleCandidates;
  
  // Build a call to the selected constructor.
  SmallVector<Expr /*P*/ > ConstructorArgs/*J*/= new SmallVector<Expr /*P*/ >(8, (Expr /*P*/ )null);
  SourceLocation Loc = (Kind.isCopyInit() && Kind.getEqualLoc().isValid()) ? Kind.getEqualLoc() : Kind.getLocation();
  if (Kind.getKind() == InitializationKind.InitKind.IK_Default) {
    // Force even a trivial, implicit default constructor to be
    // semantically checked. We do this explicitly because we don't build
    // the definition for completely trivial constructors.
    assert ((Constructor.getParent() != null)) : "No parent class for constructor.";
    if (Constructor.isDefaulted() && Constructor.isDefaultConstructor()
       && Constructor.isTrivial() && !Constructor.isUsed(false)) {
      S.DefineImplicitDefaultConstructor(new SourceLocation(Loc), Constructor);
    }
  }
  
  ActionResultTTrue<Expr /*P*/ > CurInit/*J*/= new ActionResultTTrue<Expr /*P*/ >(JD$T.INSTANCE, (Expr /*P*/ )(Expr /*P*/ )null);
  
  // C++ [over.match.copy]p1:
  //   - When initializing a temporary to be bound to the first parameter 
  //     of a constructor that takes a reference to possibly cv-qualified 
  //     T as its first argument, called with a single argument in the 
  //     context of direct-initialization, explicit conversion functions
  //     are also considered.
  boolean AllowExplicitConv = Kind.AllowExplicit() && !Kind.isCopyInit()
     && Args.size() == 1
     && Constructor.isCopyOrMoveConstructor();
  
  // Determine the arguments required to actually perform the constructor
  // call.
  if (S.CompleteConstructorCall(Constructor, new MutableArrayRef<Expr /*P*/ >(Args), 
      new SourceLocation(Loc), ConstructorArgs, 
      AllowExplicitConv, 
      IsListInitialization)) {
    return ExprError();
  }
  if (isExplicitTemporary(Entity, Kind, NumArgs)) {
    // An explicitly-constructed temporary, e.g., X(1, 2).
    if (S.DiagnoseUseOfDecl(Constructor, new SourceLocation(Loc))) {
      return ExprError();
    }
    
    TypeSourceInfo /*P*/ TSInfo = Entity.getTypeSourceInfo();
    if (!(TSInfo != null)) {
      TSInfo = S.Context.getTrivialTypeSourceInfo(Entity.getType(), new SourceLocation(Loc));
    }
    SourceRange ParenOrBraceRange = (Kind.getKind() == InitializationKind.InitKind.IK_DirectList) ? new SourceRange(/*NO_COPY*/LBraceLoc, /*NO_COPY*/RBraceLoc) : Kind.getParenRange();
    {
      
      ConstructorUsingShadowDecl /*P*/ Shadow = dyn_cast_ConstructorUsingShadowDecl(Step.Unnamed_field2.Function.FoundDecl.getDecl());
      if ((Shadow != null)) {
        Constructor = S.findInheritingConstructor(new SourceLocation(Loc), Constructor, Shadow);
        if (S.DiagnoseUseOfDecl(Constructor, new SourceLocation(Loc))) {
          return ExprError();
        }
      }
    }
    S.MarkFunctionReferenced(new SourceLocation(Loc), Constructor);
    
    final CXXConstructorDecl /*P*/ L$Constructor = Constructor;
    final TypeSourceInfo /*P*/ L$TSInfo = TSInfo;
    CurInit.$assign(/*NEW_EXPR [Stmt::new]*//*new (S.Context)*/ Stmt.$new_uint_ASTContext$C_uint(S.Context, (type$ptr<?> New$Mem)->new CXXTemporaryObjectExpr(S.Context, L$Constructor, L$TSInfo, 
            new ArrayRef<Expr /*P*/ >(ConstructorArgs, true), new SourceRange(ParenOrBraceRange), HadMultipleCandidates, 
            IsListInitialization, IsStdInitListInitialization, 
            ConstructorInitRequiresZeroInit.$deref())));
  } else {
    CXXConstructExpr.ConstructionKind ConstructKind = CXXConstructExpr.ConstructionKind.CK_Complete;
    if (Entity.getKind() == InitializedEntity.EntityKind.EK_Base) {
      ConstructKind = Entity.getBaseSpecifier().isVirtual() ? CXXConstructExpr.ConstructionKind.CK_VirtualBase : CXXConstructExpr.ConstructionKind.CK_NonVirtualBase;
    } else if (Entity.getKind() == InitializedEntity.EntityKind.EK_Delegating) {
      ConstructKind = CXXConstructExpr.ConstructionKind.CK_Delegating;
    }
    
    // Only get the parenthesis or brace range if it is a list initialization or
    // direct construction.
    SourceRange ParenOrBraceRange/*J*/= new SourceRange();
    if (IsListInitialization) {
      ParenOrBraceRange.$assignMove(new SourceRange(/*NO_COPY*/LBraceLoc, /*NO_COPY*/RBraceLoc));
    } else if (Kind.getKind() == InitializationKind.InitKind.IK_Direct) {
      ParenOrBraceRange.$assignMove(Kind.getParenRange());
    }
    
    // If the entity allows NRVO, mark the construction as elidable
    // unconditionally.
    if (Entity.allowsNRVO()) {
      CurInit.$assignMove(S.BuildCXXConstructExpr(new SourceLocation(Loc), Entity.getType(), 
              Step.Unnamed_field2.Function.FoundDecl.$NamedDecl$P(), 
              Constructor, /*Elidable=*/ true, 
              new MutableArrayRef<Expr /*P*/ >(ConstructorArgs, true), 
              HadMultipleCandidates, 
              IsListInitialization, 
              IsStdInitListInitialization, 
              ConstructorInitRequiresZeroInit.$deref(), 
              ConstructKind.getValue(), 
              new SourceRange(ParenOrBraceRange)));
    } else {
      CurInit.$assignMove(S.BuildCXXConstructExpr(new SourceLocation(Loc), Entity.getType(), 
              Step.Unnamed_field2.Function.FoundDecl.$NamedDecl$P(), 
              Constructor, 
              new MutableArrayRef<Expr /*P*/ >(ConstructorArgs, true), 
              HadMultipleCandidates, 
              IsListInitialization, 
              IsStdInitListInitialization, 
              ConstructorInitRequiresZeroInit.$deref(), 
              ConstructKind.getValue(), 
              new SourceRange(ParenOrBraceRange)));
    }
  }
  if (CurInit.isInvalid()) {
    return ExprError();
  }
  
  // Only check access if all of that succeeded.
  S.CheckConstructorAccess(new SourceLocation(Loc), Constructor, new DeclAccessPair(Step.Unnamed_field2.Function.FoundDecl), Entity);
  if (S.DiagnoseUseOfDecl(Step.Unnamed_field2.Function.FoundDecl.$NamedDecl$P(), new SourceLocation(Loc))) {
    return ExprError();
  }
  if (shouldBindAsTemporary(Entity)) {
    CurInit.$assignMove(S.MaybeBindToTemporary(CurInit.get()));
  }
  
  return CurInit;
}


/// Determine whether the specified InitializedEntity definitely has a lifetime
/// longer than the current full-expression. Conservatively returns false if
/// it's unclear.
//<editor-fold defaultstate="collapsed" desc="InitializedEntityOutlivesFullExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5818,
 FQN="InitializedEntityOutlivesFullExpression", NM="_ZL39InitializedEntityOutlivesFullExpressionRKN5clang17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL39InitializedEntityOutlivesFullExpressionRKN5clang17InitializedEntityE")
//</editor-fold>
public static boolean InitializedEntityOutlivesFullExpression(final /*const*/ InitializedEntity /*&*/ Entity) {
  /*const*/ InitializedEntity /*P*/ Top = $AddrOf(Entity);
  while ((Top.getParent() != null)) {
    Top = Top.getParent();
  }
  switch (Top.getKind()) {
   case EK_Variable:
   case EK_Result:
   case EK_Exception:
   case EK_Member:
   case EK_New:
   case EK_Base:
   case EK_Delegating:
    return true;
   case EK_ArrayElement:
   case EK_VectorElement:
   case EK_BlockElement:
   case EK_ComplexElement:
    // Could not determine what the full initialization is. Assume it might not
    // outlive the full-expression.
    return false;
   case EK_Parameter:
   case EK_Parameter_CF_Audited:
   case EK_Temporary:
   case EK_LambdaCapture:
   case EK_CompoundLiteralInit:
   case EK_RelatedResult:
    // The entity being initialized might not outlive the full-expression.
    return false;
  }
  throw new llvm_unreachable("unknown entity kind");
}


/// Determine the declaration which an initialized entity ultimately refers to,
/// for the purpose of lifetime-extending a temporary bound to a reference in
/// the initialization of \p Entity.
//<editor-fold defaultstate="collapsed" desc="getEntityForTemporaryLifetimeExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5858,
 FQN="getEntityForTemporaryLifetimeExtension", NM="_ZL38getEntityForTemporaryLifetimeExtensionPKN5clang17InitializedEntityES2_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL38getEntityForTemporaryLifetimeExtensionPKN5clang17InitializedEntityES2_")
//</editor-fold>
public static /*const*/ InitializedEntity /*P*/ getEntityForTemporaryLifetimeExtension(/*const*/ InitializedEntity /*P*/ Entity) {
  return getEntityForTemporaryLifetimeExtension(Entity, 
                                      (/*const*/ InitializedEntity /*P*/ )null);
}
public static /*const*/ InitializedEntity /*P*/ getEntityForTemporaryLifetimeExtension(/*const*/ InitializedEntity /*P*/ Entity, 
                                      /*const*/ InitializedEntity /*P*/ FallbackDecl/*= null*/) {
  // C++11 [class.temporary]p5:
  switch (Entity.getKind()) {
   case EK_Variable:
    //   The temporary [...] persists for the lifetime of the reference
    return Entity;
   case EK_Member:
    // For subobjects, we look at the complete object.
    if ((Entity.getParent() != null)) {
      return getEntityForTemporaryLifetimeExtension(Entity.getParent(), 
          Entity);
    }
    
    //   except:
    //   -- A temporary bound to a reference member in a constructor's
    //      ctor-initializer persists until the constructor exits.
    return Entity;
   case EK_Parameter:
   case EK_Parameter_CF_Audited:
   case EK_Result:
   case EK_New:
    //   -- A temporary bound to a reference in a new-initializer persists
    //      until the completion of the full-expression containing the
    //      new-initializer.
    return null;
   case EK_Temporary:
   case EK_CompoundLiteralInit:
   case EK_RelatedResult:
    // We don't yet know the storage duration of the surrounding temporary.
    // Assume it's got full-expression duration for now, it will patch up our
    // storage duration if that's not correct.
    return null;
   case EK_ArrayElement:
    // For subobjects, we look at the complete object.
    return getEntityForTemporaryLifetimeExtension(Entity.getParent(), 
        FallbackDecl);
   case EK_Base:
    // For subobjects, we look at the complete object.
    if ((Entity.getParent() != null)) {
      return getEntityForTemporaryLifetimeExtension(Entity.getParent(), 
          Entity);
    }
   case EK_Delegating:
    // We can reach this case for aggregate initialization in a constructor:
    //   struct A { int &&r; };
    //   struct B : A { B() : A{0} {} };
    // In this case, use the innermost field decl as the context.
    return FallbackDecl;
   case EK_BlockElement:
   case EK_LambdaCapture:
   case EK_Exception:
   case EK_VectorElement:
   case EK_ComplexElement:
    return null;
  }
  throw new llvm_unreachable("unknown entity kind");
}


/// Update a prvalue expression that is going to be materialized as a
/// lifetime-extended temporary.
//<editor-fold defaultstate="collapsed" desc="performLifetimeExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5982,
 FQN="performLifetimeExtension", NM="_ZL24performLifetimeExtensionPN5clang4ExprEPKNS_17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL24performLifetimeExtensionPN5clang4ExprEPKNS_17InitializedEntityE")
//</editor-fold>
public static void performLifetimeExtension(Expr /*P*/ Init, 
                        /*const*/ InitializedEntity /*P*/ ExtendingEntity) {
  // Dig out the expression which constructs the extended temporary.
  SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
  SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
  Init = ((/*const_cast*/Expr /*P*/ )(Init.skipRValueSubobjectAdjustments(CommaLHSs, Adjustments)));
  {
    
    CXXBindTemporaryExpr /*P*/ BTE = dyn_cast_CXXBindTemporaryExpr(Init);
    if ((BTE != null)) {
      Init = BTE.getSubExpr();
    }
  }
  {
    
    CXXStdInitializerListExpr /*P*/ ILE = dyn_cast_CXXStdInitializerListExpr(Init);
    if ((ILE != null)) {
      performReferenceExtension(ILE.getSubExpr(), ExtendingEntity);
      return;
    }
  }
  {
    
    InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Init);
    if ((ILE != null)) {
      if (ILE.getType().$arrow().isArrayType()) {
        for (/*uint*/int I = 0, N = ILE.getNumInits(); I != N; ++I)  {
          performLifetimeExtension(ILE.getInit(I), ExtendingEntity);
        }
        return;
      }
      {
        
        CXXRecordDecl /*P*/ RD = ILE.getType().$arrow().getAsCXXRecordDecl();
        if ((RD != null)) {
          assert (RD.isAggregate()) : "aggregate init on non-aggregate";
          
          // If we lifetime-extend a braced initializer which is initializing an
          // aggregate, and that aggregate contains reference members which are
          // bound to temporaries, those temporaries are also lifetime-extended.
          if (RD.isUnion() && (ILE.getInitializedFieldInUnion() != null)
             && ILE.getInitializedFieldInUnion().getType().$arrow().isReferenceType()) {
            performReferenceExtension(ILE.getInit(0), ExtendingEntity);
          } else {
            /*uint*/int Index = 0;
            for (/*const*/ FieldDecl /*P*/ I : RD.fields()) {
              if ($greatereq_uint(Index, ILE.getNumInits())) {
                break;
              }
              if (I.isUnnamedBitfield()) {
                continue;
              }
              Expr /*P*/ SubInit = ILE.getInit(Index);
              if (I.getType().$arrow().isReferenceType()) {
                performReferenceExtension(SubInit, ExtendingEntity);
              } else if (isa_InitListExpr(SubInit)
                 || isa_CXXStdInitializerListExpr(SubInit)) {
                // This may be either aggregate-initialization of a member or
                // initialization of a std::initializer_list object. Either way,
                // we should recursively lifetime-extend that initializer.
                performLifetimeExtension(SubInit, ExtendingEntity);
              }
              ++Index;
            }
          }
        }
      }
    }
  }
}


/// Update a glvalue expression that is used as the initializer of a reference
/// to note that its lifetime is extended.
/// \return \c true if any temporary had its lifetime extended.
//<editor-fold defaultstate="collapsed" desc="performReferenceExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 5935,
 FQN="performReferenceExtension", NM="_ZL25performReferenceExtensionPN5clang4ExprEPKNS_17InitializedEntityE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL25performReferenceExtensionPN5clang4ExprEPKNS_17InitializedEntityE")
//</editor-fold>
public static boolean performReferenceExtension(Expr /*P*/ Init, 
                         /*const*/ InitializedEntity /*P*/ ExtendingEntity) {
  // Walk past any constructs which we can lifetime-extend across.
  Expr /*P*/ Old;
  do {
    Old = Init;
    {
      
      InitListExpr /*P*/ ILE = dyn_cast_InitListExpr(Init);
      if ((ILE != null)) {
        if (ILE.getNumInits() == 1 && ILE.isGLValue()) {
          // This is just redundant braces around an initializer. Step over it.
          Init = ILE.getInit(0);
        }
      }
    }
    
    // Step over any subobject adjustments; we may have a materialized
    // temporary inside them.
    SmallVector</*const*/ Expr /*P*/ > CommaLHSs/*J*/= new SmallVector</*const*/ Expr /*P*/ >(2, (/*const*/ Expr /*P*/ )null);
    SmallVector<SubobjectAdjustment> Adjustments/*J*/= new SmallVector<SubobjectAdjustment>(2, new SubobjectAdjustment());
    Init = ((/*const_cast*/Expr /*P*/ )(Init.skipRValueSubobjectAdjustments(CommaLHSs, Adjustments)));
    {
      
      // Per current approach for DR1376, look through casts to reference type
      // when performing lifetime extension.
      CastExpr /*P*/ CE = dyn_cast_CastExpr(Init);
      if ((CE != null)) {
        if (CE.getSubExpr().isGLValue()) {
          Init = CE.getSubExpr();
        }
      }
    }
    // FIXME: Per DR1213, subscripting on an array temporary produces an xvalue.
    // It's unclear if binding a reference to that xvalue extends the array
    // temporary.
  } while (Init != Old);
  {
    
    MaterializeTemporaryExpr /*P*/ ME = dyn_cast_MaterializeTemporaryExpr(Init);
    if ((ME != null)) {
      // Update the storage duration of the materialized temporary.
      // FIXME: Rebuild the expression instead of mutating it.
      ME.setExtendingDecl(ExtendingEntity.getDecl(), 
          ExtendingEntity.allocateManglingNumber());
      performLifetimeExtension(ME.GetTemporaryExpr(), ExtendingEntity);
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="warnOnLifetimeExtension">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6038,
 FQN="warnOnLifetimeExtension", NM="_ZL23warnOnLifetimeExtensionRN5clang4SemaERKNS_17InitializedEntityEPKNS_4ExprEbPKNS_9ValueDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL23warnOnLifetimeExtensionRN5clang4SemaERKNS_17InitializedEntityEPKNS_4ExprEbPKNS_9ValueDeclE")
//</editor-fold>
public static void warnOnLifetimeExtension(final Sema /*&*/ S, final /*const*/ InitializedEntity /*&*/ Entity, 
                       /*const*/ Expr /*P*/ Init, boolean IsInitializerList, 
                       /*const*/ ValueDecl /*P*/ ExtendingDecl) {
  // Warn if a field lifetime-extends a temporary.
  if (isa_FieldDecl(ExtendingDecl)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      if (IsInitializerList) {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getExprLoc(), diag.warn_dangling_std_initializer_list)), 
            /*at end of constructor*/ true));
        return;
      }
      
      boolean IsSubobjectMember = false;
      for (/*const*/ InitializedEntity /*P*/ Ent = Entity.getParent(); (Ent != null);
           Ent = Ent.getParent()) {
        if (Ent.getKind() != InitializedEntity.EntityKind.EK_Base) {
          IsSubobjectMember = true;
          break;
        }
      }
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(Init.getExprLoc(), 
                          diag.warn_bind_ref_member_to_temporary)), 
                      ExtendingDecl), Init.getSourceRange()), 
              IsSubobjectMember), IsInitializerList));
      if (IsSubobjectMember) {
        $c$.clean($c$.track(S.Diag(ExtendingDecl.getLocation(), 
            diag.note_ref_subobject_of_member_declared_here)));
      } else {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(ExtendingDecl.getLocation(), 
                diag.note_ref_or_ptr_member_declared_here)), 
            /*is pointer*/ false));
      }
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="DiagnoseNarrowingInInitList">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7728,
 FQN="DiagnoseNarrowingInInitList", NM="_ZL27DiagnoseNarrowingInInitListRN5clang4SemaERKNS_26ImplicitConversionSequenceENS_8QualTypeES5_PKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL27DiagnoseNarrowingInInitListRN5clang4SemaERKNS_26ImplicitConversionSequenceENS_8QualTypeES5_PKNS_4ExprE")
//</editor-fold>
public static void DiagnoseNarrowingInInitList(final Sema /*&*/ S, 
                           final /*const*/ ImplicitConversionSequence /*&*/ ICS, 
                           QualType PreNarrowingType, 
                           QualType EntityType, 
                           /*const*/ Expr /*P*/ PostInit) {
  APValue ConstantValue = null;
  raw_svector_ostream OS = null;
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    /*const*/ StandardConversionSequence /*P*/ SCS = null;
    switch (ICS.getKind()) {
     case StandardConversion:
      SCS = $AddrOf(ICS.Unnamed_field2.Standard);
      break;
     case UserDefinedConversion:
      SCS = $AddrOf(ICS.Unnamed_field2.UserDefined.After);
      break;
     case AmbiguousConversion:
     case EllipsisConversion:
     case BadConversion:
      return;
    }
    
    // C++11 [dcl.init.list]p7: Check whether this is a narrowing conversion.
    ConstantValue/*J*/= new APValue();
    QualType ConstantType/*J*/= new QualType();
    switch (SCS.getNarrowingKind(S.Context, PostInit, ConstantValue, 
        ConstantType)) {
     case NK_Not_Narrowing:
      // No narrowing occurred.
      return;
     case NK_Type_Narrowing:
      // This was a floating-to-integer conversion, which is always considered a
      // narrowing conversion even if the value is a constant and can be
      // represented exactly as an integer.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PostInit.getLocStart(), 
                      (S.getLangOpts().MicrosoftExt || !S.getLangOpts().CPlusPlus11) ? diag.warn_init_list_type_narrowing : diag.ext_init_list_type_narrowing)), 
                  PostInit.getSourceRange()), 
              PreNarrowingType.getLocalUnqualifiedType()), 
          EntityType.getLocalUnqualifiedType()));
      break;
     case NK_Constant_Narrowing:
      // A constant value was narrowed.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PostInit.getLocStart(), 
                      (S.getLangOpts().MicrosoftExt || !S.getLangOpts().CPlusPlus11) ? diag.warn_init_list_constant_narrowing : diag.ext_init_list_constant_narrowing)), 
                  PostInit.getSourceRange()), 
              ConstantValue.getAsString(S.getASTContext(), new QualType(ConstantType))), 
          EntityType.getLocalUnqualifiedType()));
      break;
     case NK_Variable_Narrowing:
      // A variable's value may have been narrowed.
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PostInit.getLocStart(), 
                      (S.getLangOpts().MicrosoftExt || !S.getLangOpts().CPlusPlus11) ? diag.warn_init_list_variable_narrowing : diag.ext_init_list_variable_narrowing)), 
                  PostInit.getSourceRange()), 
              PreNarrowingType.getLocalUnqualifiedType()), 
          EntityType.getLocalUnqualifiedType()));
      break;
    }
    
    SmallString/*128*/ StaticCast/*J*/= new SmallString/*128*/(128);
    OS/*J*/= new raw_svector_ostream(StaticCast);
    OS.$out(/*KEEP_STR*/"static_cast<");
    {
      /*const*/ TypedefType /*P*/ TT = EntityType.$arrow().<TypedefType>getAs$TypedefType();
      if ((TT != null)) {
        // It's important to use the typedef's name if there is one so that the
        // fixit doesn't break code using types like int64_t.
        //
        // FIXME: This will break if the typedef requires qualification.  But
        // getQualifiedNameAsString() includes non-machine-parsable components.
        $out_raw_ostream_NamedDecl$C(OS, $Deref(TT.getDecl()));
      } else {
        /*const*/ BuiltinType /*P*/ BT = EntityType.$arrow().<BuiltinType>getAs$BuiltinType();
        if ((BT != null)) {
          OS.$out(BT.getName(new PrintingPolicy(S.getLangOpts())));
        } else {
          // Oops, we didn't find the actual type of the variable.  Don't emit a fixit
          // with a broken cast.
          return;
        }
      }
    }
    OS.$out(/*KEEP_STR*/">(");
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(PostInit.getLocStart(), diag.note_init_list_narrowing_silence)), 
                PostInit.getSourceRange()), 
            FixItHint.CreateInsertion(PostInit.getLocStart(), OS.str())), 
        FixItHint.CreateInsertion(S.getLocForEndOfToken(PostInit.getLocEnd()), new StringRef(/*KEEP_STR*/$RPAREN))));
  } finally {
    if (OS != null) { OS.$destroy(); }
    if (ConstantValue != null) { ConstantValue.$destroy(); }
    $c$.$destroy();
  }
}


/// Provide warnings when std::move is used on construction.
//<editor-fold defaultstate="collapsed" desc="CheckMoveOnConstruction">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6078,
 FQN="CheckMoveOnConstruction", NM="_ZL23CheckMoveOnConstructionRN5clang4SemaEPKNS_4ExprEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL23CheckMoveOnConstructionRN5clang4SemaEPKNS_4ExprEb")
//</editor-fold>
public static void CheckMoveOnConstruction(final Sema /*&*/ S, /*const*/ Expr /*P*/ InitExpr, 
                       boolean IsReturnStmt) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    if (!(InitExpr != null)) {
      return;
    }
    if (!S.ActiveTemplateInstantiations.empty()) {
      return;
    }
    
    QualType DestType = InitExpr.getType();
    if (!DestType.$arrow().isRecordType()) {
      return;
    }
    
    /*uint*/int DiagID = 0;
    if (IsReturnStmt) {
      /*const*/ CXXConstructExpr /*P*/ CCE = dyn_cast_CXXConstructExpr(InitExpr.IgnoreParens$Const());
      if (!(CCE != null) || CCE.getNumArgs() != 1) {
        return;
      }
      if (!CCE.getConstructor().isCopyOrMoveConstructor()) {
        return;
      }
      
      InitExpr = CCE.getArg$Const(0).IgnoreImpCasts$Const();
    }
    
    // Find the std::move call and get the argument.
    /*const*/ CallExpr /*P*/ CE = dyn_cast_CallExpr(InitExpr.IgnoreParens$Const());
    if (!(CE != null) || CE.getNumArgs() != 1) {
      return;
    }
    
    /*const*/ FunctionDecl /*P*/ MoveFunction = CE.getDirectCallee$Const();
    if (!(MoveFunction != null) || !MoveFunction.isInStdNamespace()
       || !(MoveFunction.getIdentifier() != null)
       || !MoveFunction.getIdentifier().isStr(/*KEEP_STR*/"move")) {
      return;
    }
    
    /*const*/ Expr /*P*/ Arg = CE.getArg$Const(0).IgnoreImplicit$Const();
    if (IsReturnStmt) {
      /*const*/ DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(Arg.IgnoreParenImpCasts$Const());
      if (!(DRE != null) || DRE.refersToEnclosingVariableOrCapture()) {
        return;
      }
      
      /*const*/ VarDecl /*P*/ VD = dyn_cast_VarDecl(DRE.getDecl$Const());
      if (!(VD != null) || !VD.hasLocalStorage()) {
        return;
      }
      
      QualType SourceType = VD.getType();
      if (!SourceType.$arrow().isRecordType()) {
        return;
      }
      if (!S.Context.hasSameUnqualifiedType(new QualType(DestType), new QualType(SourceType))) {
        return;
      }
      
      // If we're returning a function parameter, copy elision
      // is not possible.
      if (isa_ParmVarDecl(VD)) {
        DiagID = diag.warn_redundant_move_on_return;
      } else {
        DiagID = diag.warn_pessimizing_move_on_return;
      }
    } else {
      DiagID = diag.warn_pessimizing_move_on_initialization;
      /*const*/ Expr /*P*/ ArgStripped = Arg.IgnoreImplicit$Const().IgnoreParens$Const();
      if (!ArgStripped.isRValue() || !ArgStripped.getType().$arrow().isRecordType()) {
        return;
      }
    }
    
    $c$.clean($c$.track(S.Diag(CE.getLocStart(), DiagID)));
    
    // Get all the locations for a fix-it.  Don't emit the fix-it if any location
    // is within a macro.
    SourceLocation CallBegin = CE.getCallee$Const().getLocStart();
    if (CallBegin.isMacroID()) {
      return;
    }
    SourceLocation RParen = CE.getRParenLoc();
    if (RParen.isMacroID()) {
      return;
    }
    SourceLocation LParen/*J*/= new SourceLocation();
    SourceLocation ArgLoc = Arg.getLocStart();
    
    // Special testing for the argument location.  Since the fix-it needs the
    // location right before the argument, the argument location can be in a
    // macro only if it is at the beginning of the macro.
    while (ArgLoc.isMacroID()
       && S.getSourceManager().isAtStartOfImmediateMacroExpansion(/*NO_COPY*/ArgLoc)) {
      ArgLoc.$assignMove(S.getSourceManager().getImmediateExpansionRange(/*NO_COPY*/ArgLoc).first);
    }
    if (LParen.isMacroID()) {
      return;
    }
    
    LParen.$assignMove(ArgLoc.getLocWithOffset(-1));
    
    $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(CE.getLocStart(), diag.note_remove_move)), 
            FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/CallBegin, /*NO_COPY*/LParen))), 
        FixItHint.CreateRemoval(new SourceRange(/*NO_COPY*/RParen, /*NO_COPY*/RParen))));
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="CheckForNullPointerDereference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6177,
 FQN="CheckForNullPointerDereference", NM="_ZL30CheckForNullPointerDereferenceRN5clang4SemaEPKNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30CheckForNullPointerDereferenceRN5clang4SemaEPKNS_4ExprE")
//</editor-fold>
public static void CheckForNullPointerDereference(final Sema /*&*/ S, /*const*/ Expr /*P*/ E) {
  {
    // Check to see if we are dereferencing a null pointer.  If so, this is
    // undefined behavior, so warn about it.  This only handles the pattern
    // "*null", which is a very syntactic check.
    /*const*/ UnaryOperator /*P*/ UO = dyn_cast_UnaryOperator(E.IgnoreParenCasts$Const());
    if ((UO != null)) {
      if (UO.getOpcode() == UnaryOperatorKind.UO_Deref
         && (UO.getSubExpr().IgnoreParenCasts().
          isNullPointerConstant(S.Context, Expr.NullPointerConstantValueDependence.NPC_ValueDependentIsNotNull).getValue() != 0)) {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $c$.clean(S.DiagRuntimeBehavior(UO.getOperatorLoc(), UO, 
              $out_PartialDiagnostic$C_SourceRange($c$.track(S.PDiag(diag.warn_binding_null_to_reference)), 
                  UO.getSubExpr().getSourceRange())));
        } finally {
          $c$.$destroy();
        }
      }
    }
  }
}


/// Somewhere within T there is an uninitialized reference subobject.
/// Dig it out and diagnose it.
//<editor-fold defaultstate="collapsed" desc="DiagnoseUninitializedReference">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6952,
 FQN="DiagnoseUninitializedReference", NM="_ZL30DiagnoseUninitializedReferenceRN5clang4SemaENS_14SourceLocationENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL30DiagnoseUninitializedReferenceRN5clang4SemaENS_14SourceLocationENS_8QualTypeE")
//</editor-fold>
public static boolean DiagnoseUninitializedReference(final Sema /*&*/ S, SourceLocation Loc, 
                              QualType T) {
  if (T.$arrow().isReferenceType()) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.err_reference_without_init)), 
          T.getNonReferenceType()));
      return true;
    } finally {
      $c$.$destroy();
    }
  }
  
  CXXRecordDecl /*P*/ RD = T.$arrow().getBaseElementTypeUnsafe().getAsCXXRecordDecl();
  if (!(RD != null) || !RD.hasUninitializedReferenceMember()) {
    return false;
  }
  
  for (/*const*/ FieldDecl /*P*/ FI : RD.fields()) {
    if (FI.isUnnamedBitfield()) {
      continue;
    }
    if (DiagnoseUninitializedReference(S, FI.getLocation(), FI.getType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_value_initialization_here)), RD));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  for (final /*const*/ CXXBaseSpecifier /*&*/ BI : RD.bases()) {
    if (DiagnoseUninitializedReference(S, BI.getLocStart(), BI.getType())) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_value_initialization_here)), RD));
        return true;
      } finally {
        $c$.$destroy();
      }
    }
  }
  
  return false;
}


//===----------------------------------------------------------------------===//
// Diagnose initialization failures
//===----------------------------------------------------------------------===//

/// Emit notes associated with an initialization that failed due to a
/// "simple" conversion failure.
//<editor-fold defaultstate="collapsed" desc="emitBadConversionNotes">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 6991,
 FQN="emitBadConversionNotes", NM="_ZL22emitBadConversionNotesRN5clang4SemaERKNS_17InitializedEntityEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL22emitBadConversionNotesRN5clang4SemaERKNS_17InitializedEntityEPNS_4ExprE")
//</editor-fold>
public static void emitBadConversionNotes(final Sema /*&*/ S, final /*const*/ InitializedEntity /*&*/ entity, 
                      Expr /*P*/ op) {
  QualType destType = entity.getType();
  if (destType.getNonReferenceType().$arrow().isObjCObjectPointerType()
     && op.getType().$arrow().isObjCObjectPointerType()) {
    
    // Emit a possible note about the conversion failing because the
    // operand is a message send with a related result type.
    S.EmitRelatedResultTypeNote(op);
    
    // Emit a possible note about a return failing because we're
    // expecting a related result type.
    if (entity.getKind() == InitializedEntity.EntityKind.EK_Result) {
      S.EmitRelatedResultTypeNoteForReturn(new QualType(destType));
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="diagnoseListInit">
@Converted(kind = Converted.Kind.MANUAL_COMPILATION,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp", line = 7008,
 FQN="diagnoseListInit", NM="_ZL16diagnoseListInitRN5clang4SemaERKNS_17InitializedEntityEPNS_12InitListExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaInit.cpp -nm=_ZL16diagnoseListInitRN5clang4SemaERKNS_17InitializedEntityEPNS_12InitListExprE")
//</editor-fold>
public static void diagnoseListInit(final Sema /*&*/ S, final /*const*/ InitializedEntity /*&*/ Entity, 
                InitListExpr /*P*/ InitList) {
  InitListChecker DiagnoseInitList = null;
  try {
    QualType DestType = Entity.getType();
    
    QualType E/*J*/= new QualType();
    if (S.getLangOpts().CPlusPlus11 && S.isStdInitializerList(new QualType(DestType), $AddrOf(create_type$ptr(E)))) {
      QualType ArrayType = S.Context.getConstantArrayType(E.withConst(), 
          new APInt($ulong2uint(S.Context.getTypeSize(S.Context.getSizeType().$QualType())), 
              $uint2ulong(InitList.getNumInits())), 
          org.clang.ast.ArrayType.ArraySizeModifier.Normal, 0);
      InitializedEntity HiddenArray = InitializedEntity.InitializeTemporary(new QualType(ArrayType));
      diagnoseListInit(S, HiddenArray, InitList);
      /*JAVA:return*/return;
    }
    if (DestType.$arrow().isReferenceType()) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        // A list-initialization failure for a reference means that we tried to
        // create a temporary of the inner type (per [dcl.init.list]p3.6) and the
        // inner initialization failed.
        QualType T = DestType.$arrow().getAs(ReferenceType.class).getPointeeType();
        diagnoseListInit(S, InitializedEntity.InitializeTemporary(new QualType(T)), InitList);
        SourceLocation Loc = InitList.getLocStart();
        {
          DeclaratorDecl /*P*/ D = Entity.getDecl();
          if ((D != null)) {
            Loc.$assignMove(D.getLocation());
          }
        }
        $c$.clean($out_SemaDiagnosticBuilder$C_T$C$R($c$.track(S.Diag(new SourceLocation(Loc), diag.note_in_reference_temporary_list_initializer)), T));
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    DiagnoseInitList/*J*/= new InitListChecker(S, Entity, InitList, DestType, 
        /*VerifyOnly=*/ false, 
        /*TreatUnavailableAsInvalid=*/ false);
    assert (DiagnoseInitList.HadError()) : "Inconsistent init list check result.";
  } finally {
    if (DiagnoseInitList != null) { DiagnoseInitList.$destroy(); }
  }
}

} // END OF class SemaInitStatics
