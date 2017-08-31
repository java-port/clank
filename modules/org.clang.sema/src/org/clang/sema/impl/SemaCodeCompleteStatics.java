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
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.Preprocessor_NestedClasses.*;
import org.clang.sema.*;
import org.clang.clangc.*;
import static org.clang.basic.BasicClangGlobals.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.impl.SemaCodeCompleteStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import static org.clang.ast.java.AstTypesRTTI.*;
import static org.clang.ast.java.AstExpressionsRTTI.*;


//<editor-fold defaultstate="collapsed" desc="static type SemaCodeCompleteStatics">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL12getParamTypeRN5clang4SemaEN4llvm8ArrayRefINS_20CodeCompleteConsumer17OverloadCandidateEEEj;_ZL14AddObjCMethodsPN5clang17ObjCContainerDeclEb14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEPNS_11DeclContextERNS3_11SmallPtrSetINS_8SelectorELj16EEEbRN12_GLOBAL__N_113ResultBuilderEb;_ZL14isReservedNamePKN5clang14IdentifierInfoEb;_ZL15AddMacroResultsRN5clang12PreprocessorERN12_GLOBAL__N_113ResultBuilderEbb;_ZL15getContainerDefPN5clang17ObjCContainerDeclE;_ZL16AddTypedefResultRN12_GLOBAL__N_113ResultBuilderE;_ZL16MaybeAddSentinelRN5clang12PreprocessorEPKNS_9NamedDeclERNS_21CodeCompletionBuilderE;_ZL16anyNullArgumentsN4llvm8ArrayRefIPN5clang4ExprEEE;_ZL16isNamespaceScopePN5clang5ScopeE;_ZL17AddObjCPropertiesRKN5clang21CodeCompletionContextEPNS_17ObjCContainerDeclEbbPNS_11DeclContextERN4llvm11SmallPtrSetIPNS_14IdentifierInfoELj16EEERN12_GLOBAL__N_113ResultBuilderE;_ZL17AddTypedNameChunkRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_9NamedDeclERNS_21CodeCompletionBuilderE;_ZL17addThisCompletionRN5clang4SemaERN12_GLOBAL__N_113ResultBuilderE;_ZL18AddProtocolResultsPN5clang11DeclContextES1_bRN12_GLOBAL__N_113ResultBuilderE;_ZL18AddResultTypeChunkRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_9NamedDeclENS_8QualTypeERNS_21CodeCompletionBuilderE;_ZL18WantTypesInContextN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsE;_ZL18isObjCReceiverTypeRN5clang10ASTContextENS_8QualTypeE;_ZL19AddInterfaceResultsPN5clang11DeclContextES1_bbRN12_GLOBAL__N_113ResultBuilderE;_ZL20AddStorageSpecifiersN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsERN12_GLOBAL__N_113ResultBuilderE;_ZL21AddFunctionSpecifiersN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsERN12_GLOBAL__N_113ResultBuilderE;_ZL21MaybeAddOverrideCallsRN5clang4SemaEPNS_11DeclContextERN12_GLOBAL__N_113ResultBuilderE;_ZL22AddObjCTopLevelResultsRN12_GLOBAL__N_113ResultBuilderEb;_ZL22AddOrdinaryNameResultsN5clang4Sema23ParserCompletionContextEPNS_5ScopeERS0_RN12_GLOBAL__N_113ResultBuilderE;_ZL22AddSuperSendCompletionRN5clang4SemaEbN4llvm8ArrayRefIPNS_14IdentifierInfoEEERN12_GLOBAL__N_113ResultBuilderE;_ZL22InheritsFromClassNamedPN5clang17ObjCInterfaceDeclEN4llvm9StringRefE;_ZL22isAcceptableObjCMethodPN5clang14ObjCMethodDeclE14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb;_ZL23AddObjCInterfaceResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb;_ZL23AddObjCPassingTypeChunkN5clang8QualTypeEjRNS_10ASTContextERKNS_14PrintingPolicyERNS_21CodeCompletionBuilderE;_ZL23AddObjCStatementResultsRN12_GLOBAL__N_113ResultBuilderEb;_ZL23AddTypeSpecifierResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderE;_ZL23FormatFunctionParameterRKN5clang14PrintingPolicyEPKNS_11ParmVarDeclEbbN4llvm8OptionalINS6_8ArrayRefINS_8QualTypeEEEEE;_ZL23GetCompletionTypeStringN5clang8QualTypeERNS_10ASTContextERKNS_14PrintingPolicyERNS_23CodeCompletionAllocatorE;_ZL24AddObjCExpressionResultsRN12_GLOBAL__N_113ResultBuilderEb;_ZL24AddObjCVisibilityResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb;_ZL24AddPrettyFunctionResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderE;_ZL24FindImplementableMethodsRN5clang10ASTContextEPNS_17ObjCContainerDeclEbNS_8QualTypeERN4llvm8DenseMapINS_8SelectorENS5_14PointerIntPairIPNS_14ObjCMethodDeclELj1EbNS5_21PointerLikeTypeTraitsISA_EENS5_18PointerIntPairInfoISA_Lj1ESC_EEEENS5_12DenseMapInfoIS7_EENS5_6detail12DenseMapPairIS7_SF_EEEEb;_ZL24getRequiredQualificationRN5clang10ASTContextEPKNS_11DeclContextES4_;_ZL24isAcceptableObjCSelectorN5clang8SelectorE14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb;_ZL24mapCodeCompletionContextRN5clang4SemaENS0_23ParserCompletionContextE;_ZL25HandleCodeCompleteResultsPN5clang4SemaEPNS_20CodeCompleteConsumerENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj;_ZL25ObjCPropertyFlagConflictsjj;_ZL25formatObjCParamQualifiersjRN5clang8QualTypeE;_ZL26AddClassMessageCompletionsRN5clang4SemaEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbbRN12_GLOBAL__N_113ResultBuilderE;_ZL26AddFunctionParameterChunksRN5clang12PreprocessorERKNS_14PrintingPolicyEPKNS_12FunctionDeclERNS_21CodeCompletionBuilderEjb;_ZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderE;_ZL26AddOverloadParameterChunksRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_12FunctionDeclEPKNS_17FunctionProtoTypeERNS_21CodeCompletionBuilderEjjb;_ZL26AddTemplateParameterChunksRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_12TemplateDeclERNS_21CodeCompletionBuilderEjjb;_ZL26mergeCandidatesWithResultsRN5clang4SemaERN4llvm15SmallVectorImplINS_20CodeCompleteConsumer17OverloadCandidateEEERNS_20OverloadCandidateSetENS_14SourceLocationE;_ZL27CodeCompleteOverloadResultsRN5clang4SemaEPNS_5ScopeEN4llvm15MutableArrayRefINS_20CodeCompleteConsumer17OverloadCandidateEEEjb;_ZL27getCompletionPrintingPolicyRKN5clang10ASTContextERKNS_12PreprocessorE;_ZL27getCompletionPrintingPolicyRN5clang4SemaE;_ZL28AddObjCImplementationResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb;_ZL29GetAssumedMessageSendExprTypePN5clang4ExprE;_ZL29shouldIgnoreDueToReservedNamePKN5clang9NamedDeclERNS_4SemaE;_ZL30AddQualifierToCompletionStringRN5clang21CodeCompletionBuilderEPNS_19NestedNameSpecifierEbRNS_10ASTContextERKNS_14PrintingPolicyE;_ZL38AddFunctionTypeQualsToCompletionStringRN5clang21CodeCompletionBuilderEPKNS_12FunctionDeclE;_ZL38getPreferredArgumentTypeForMessageSendRN12_GLOBAL__N_113ResultBuilderEj; -static-type=SemaCodeCompleteStatics -package=org.clang.sema.impl")
//</editor-fold>
public final class SemaCodeCompleteStatics {


/// \brief Compute the qualification required to get from the current context
/// (\p CurContext) to the target context (\p TargetContext).
///
/// \param Context the AST context in which the qualification will be used.
///
/// \param CurContext the context where an entity is being named, which is
/// typically based on the current scope.
///
/// \param TargetContext the context in which the named entity actually 
/// resides.
///
/// \returns a nested name specifier that refers into the target context, or
/// NULL if no qualification is needed.
//<editor-fold defaultstate="collapsed" desc="getRequiredQualification">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 448,
 FQN="getRequiredQualification", NM="_ZL24getRequiredQualificationRN5clang10ASTContextEPKNS_11DeclContextES4_",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24getRequiredQualificationRN5clang10ASTContextEPKNS_11DeclContextES4_")
//</editor-fold>
public static NestedNameSpecifier /*P*/ getRequiredQualification(final ASTContext /*&*/ Context, 
                        /*const*/ DeclContext /*P*/ CurContext, 
                        /*const*/ DeclContext /*P*/ TargetContext) {
  SmallVector</*const*/ DeclContext /*P*/ > TargetParents/*J*/= new SmallVector</*const*/ DeclContext /*P*/ >(4, (/*const*/ DeclContext /*P*/ )null);
  
  for (/*const*/ DeclContext /*P*/ CommonAncestor = TargetContext;
       (CommonAncestor != null) && !CommonAncestor.Encloses(CurContext);
       CommonAncestor = CommonAncestor.getLookupParent$Const()) {
    if (CommonAncestor.isTransparentContext()
       || CommonAncestor.isFunctionOrMethod()) {
      continue;
    }
    
    TargetParents.push_back(CommonAncestor);
  }
  
  NestedNameSpecifier /*P*/ Result = null;
  while (!TargetParents.empty()) {
    /*const*/ DeclContext /*P*/ Parent = TargetParents.pop_back_val();
    {
      
      /*const*/ NamespaceDecl /*P*/ Namespace = dyn_cast_NamespaceDecl(Parent);
      if ((Namespace != null)) {
        if (!(Namespace.getIdentifier() != null)) {
          continue;
        }
        
        Result = NestedNameSpecifier.Create(Context, Result, Namespace);
      } else {
        /*const*/ TagDecl /*P*/ TD = dyn_cast_TagDecl(Parent);
        if ((TD != null)) {
          Result = NestedNameSpecifier.Create(Context, Result, 
              false, 
              Context.getTypeDeclType(TD).getTypePtr());
        }
      }
    }
  }
  return Result;
}


/// Determine whether \p Id is a name reserved for the implementation (C99
/// 7.1.3, C++ [lib.global.names]).
//<editor-fold defaultstate="collapsed" desc="isReservedName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 484,
 FQN="isReservedName", NM="_ZL14isReservedNamePKN5clang14IdentifierInfoEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL14isReservedNamePKN5clang14IdentifierInfoEb")
//</editor-fold>
public static boolean isReservedName(/*const*/ IdentifierInfo /*P*/ Id) {
  return isReservedName(Id, 
              false);
}
public static boolean isReservedName(/*const*/ IdentifierInfo /*P*/ Id, 
              boolean doubleUnderscoreOnly/*= false*/) {
  if ($less_uint(Id.getLength(), 2)) {
    return false;
  }
  /*const*/char$ptr/*char P*/ Name = $tryClone(Id.getNameStart());
  return Name.$at(0) == $$UNDERSCORE
     && (Name.$at(1) == $$UNDERSCORE || (Name.$at(1) >= $$A && Name.$at(1) <= $$Z
     && !doubleUnderscoreOnly));
}


// Some declarations have reserved names that we don't want to ever show.
// Filter out names reserved for the implementation if they come from a
// system header.
//<editor-fold defaultstate="collapsed" desc="shouldIgnoreDueToReservedName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 497,
 FQN="shouldIgnoreDueToReservedName", NM="_ZL29shouldIgnoreDueToReservedNamePKN5clang9NamedDeclERNS_4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL29shouldIgnoreDueToReservedNamePKN5clang9NamedDeclERNS_4SemaE")
//</editor-fold>
public static boolean shouldIgnoreDueToReservedName(/*const*/ NamedDecl /*P*/ ND, final Sema /*&*/ SemaRef) {
  /*const*/ IdentifierInfo /*P*/ Id = ND.getIdentifier();
  if (!(Id != null)) {
    return false;
  }
  
  // Ignore reserved names for compiler provided decls.
  if (isReservedName(Id) && ND.getLocation().isInvalid()) {
    return true;
  }
  
  // For system headers ignore only double-underscore names.
  // This allows for system headers providing private symbols with a single
  // underscore.
  if (isReservedName(Id, /*doubleUnderscoreOnly=*/ true)
     && SemaRef.SourceMgr.isInSystemHeader(SemaRef.SourceMgr.getSpellingLoc(ND.getLocation()))) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isObjCReceiverType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1180,
 FQN="isObjCReceiverType", NM="_ZL18isObjCReceiverTypeRN5clang10ASTContextENS_8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL18isObjCReceiverTypeRN5clang10ASTContextENS_8QualTypeE")
//</editor-fold>
public static boolean isObjCReceiverType(final ASTContext /*&*/ C, QualType T) {
  T.$assignMove(C.getCanonicalType(new QualType(T)).$QualType());
  switch (T.$arrow().getTypeClass()) {
   case ObjCObject:
   case ObjCInterface:
   case ObjCObjectPointer:
    return true;
   case Builtin:
    switch (cast_BuiltinType(T).getKind()) {
     case ObjCId:
     case ObjCClass:
     case ObjCSel:
      return true;
     default:
      break;
    }
    return false;
   default:
    break;
  }
  if (!C.getLangOpts().CPlusPlus) {
    return false;
  }
  
  // FIXME: We could perform more analysis here to determine whether a 
  // particular class type has any conversions to Objective-C types. For now,
  // just accept all class types.
  return T.$arrow().isDependentType() || T.$arrow().isRecordType();
}


/// \brief Add type specifiers for the current language as keyword results.
//<editor-fold defaultstate="collapsed" desc="AddTypeSpecifierResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1283,
 FQN="AddTypeSpecifierResults", NM="_ZL23AddTypeSpecifierResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL23AddTypeSpecifierResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddTypeSpecifierResults(final /*const*/ LangOptions /*&*/ LangOpts, 
                       final ResultBuilder /*&*/ Results) {
  CodeCompletionBuilder Builder = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results.AddResult(new CodeCompletionResult($short, CCP_Type));
    Results.AddResult(new CodeCompletionResult($long, CCP_Type));
    Results.AddResult(new CodeCompletionResult($signed, CCP_Type));
    Results.AddResult(new CodeCompletionResult($unsigned, CCP_Type));
    Results.AddResult(new CodeCompletionResult($void, CCP_Type));
    Results.AddResult(new CodeCompletionResult($char, CCP_Type));
    Results.AddResult(new CodeCompletionResult($int, CCP_Type));
    Results.AddResult(new CodeCompletionResult($float, CCP_Type));
    Results.AddResult(new CodeCompletionResult($double, CCP_Type));
    Results.AddResult(new CodeCompletionResult($enum, CCP_Type));
    Results.AddResult(new CodeCompletionResult($struct, CCP_Type));
    Results.AddResult(new CodeCompletionResult($union, CCP_Type));
    Results.AddResult(new CodeCompletionResult($const, CCP_Type));
    Results.AddResult(new CodeCompletionResult($volatile, CCP_Type));
    if (LangOpts.C99) {
      // C99-specific
      Results.AddResult(new CodeCompletionResult($_Complex, CCP_Type));
      Results.AddResult(new CodeCompletionResult($_Imaginary, CCP_Type));
      Results.AddResult(new CodeCompletionResult($_Bool, CCP_Type));
      Results.AddResult(new CodeCompletionResult($restrict, CCP_Type));
    }
    
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    if (LangOpts.CPlusPlus) {
      // C++-specific
      Results.AddResult(new CodeCompletionResult($bool, CCP_Type
                 + (LangOpts.ObjC1 ? CCD_bool_in_ObjC : 0)));
      Results.AddResult(new CodeCompletionResult($class, CCP_Type));
      Results.AddResult(new CodeCompletionResult($wchar_t, CCP_Type));
      
      // typename qualified-id
      Builder.AddTypedTextChunk($typename);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("qualifier"));
      Builder.AddTextChunk($COLON_COLON);
      Builder.AddPlaceholderChunk($("name"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      if (LangOpts.CPlusPlus11) {
        Results.AddResult(new CodeCompletionResult($auto, CCP_Type));
        Results.AddResult(new CodeCompletionResult($char16_t, CCP_Type));
        Results.AddResult(new CodeCompletionResult($char32_t, CCP_Type));
        
        Builder.AddTypedTextChunk($decltype);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("expression"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      }
    }
    
    // GNU extensions
    if (LangOpts.GNUMode) {
      // FIXME: Enable when we actually support decimal floating point.
      //    Results.AddResult(Result("_Decimal32"));
      //    Results.AddResult(Result("_Decimal64"));
      //    Results.AddResult(Result("_Decimal128"));
      Builder.AddTypedTextChunk($typeof);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("expression"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      Builder.AddTypedTextChunk($typeof);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      Builder.AddPlaceholderChunk($("type"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
    
    // Nullability
    Results.AddResult(new CodeCompletionResult($_Nonnull, CCP_Type));
    Results.AddResult(new CodeCompletionResult($_Null_unspecified, CCP_Type));
    Results.AddResult(new CodeCompletionResult($_Nullable, CCP_Type));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddStorageSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1364,
 FQN="AddStorageSpecifiers", NM="_ZL20AddStorageSpecifiersN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL20AddStorageSpecifiersN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddStorageSpecifiers(Sema.ParserCompletionContext CCC, 
                    final /*const*/ LangOptions /*&*/ LangOpts, 
                    final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  // Note: we don't suggest either "auto" or "register", because both
  // are pointless as storage specifiers. Elsewhere, we suggest "auto"
  // in C++0x as a type specifier.
  Results.AddResult(new CodeCompletionResult($extern));
  Results.AddResult(new CodeCompletionResult($static));
}

//<editor-fold defaultstate="collapsed" desc="AddFunctionSpecifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1375,
 FQN="AddFunctionSpecifiers", NM="_ZL21AddFunctionSpecifiersN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL21AddFunctionSpecifiersN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddFunctionSpecifiers(Sema.ParserCompletionContext CCC, 
                     final /*const*/ LangOptions /*&*/ LangOpts, 
                     final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  switch (CCC) {
   case PCC_Class:
   case PCC_MemberTemplate:
    if (LangOpts.CPlusPlus) {
      Results.AddResult(new CodeCompletionResult($explicit));
      Results.AddResult(new CodeCompletionResult($friend));
      Results.AddResult(new CodeCompletionResult($mutable));
      Results.AddResult(new CodeCompletionResult($virtual));
    }
   case PCC_ObjCInterface:
   case PCC_ObjCImplementation:
   case PCC_Namespace:
   case PCC_Template:
    // Fall through
    if (LangOpts.CPlusPlus || LangOpts.C99) {
      Results.AddResult(new CodeCompletionResult($inline));
    }
    break;
   case PCC_ObjCInstanceVariableList:
   case PCC_Expression:
   case PCC_Statement:
   case PCC_ForInit:
   case PCC_Condition:
   case PCC_RecoveryInFunction:
   case PCC_Type:
   case PCC_ParenthesizedExpression:
   case PCC_LocalDeclarationSpecifiers:
    break;
  }
}

//<editor-fold defaultstate="collapsed" desc="AddObjCExpressionResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4713,
 FQN="AddObjCExpressionResults", NM="_ZL24AddObjCExpressionResultsRN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24AddObjCExpressionResultsRN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCExpressionResults(final ResultBuilder /*&*/ Results, boolean NeedAt) {
  CodeCompletionBuilder Builder = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    
    // @encode ( type-name )
    /*const*/char$ptr/*char P*/ EncodeType = $("char[]");
    if (Results.getSema().getLangOpts().CPlusPlus
       || Results.getSema().getLangOpts().ConstStrings) {
      EncodeType = $tryClone($("const char[]"));
    }
    Builder.AddResultTypeChunk(EncodeType);
    Builder.AddTypedTextChunk(((NeedAt) ? $("@encode") : $("encode")));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
    Builder.AddPlaceholderChunk($("type-name"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // @protocol ( protocol-name )
    Builder.AddResultTypeChunk($("Protocol *"));
    Builder.AddTypedTextChunk(((NeedAt) ? $("@protocol") : $("protocol")));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
    Builder.AddPlaceholderChunk($("protocol-name"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // @selector ( selector )
    Builder.AddResultTypeChunk($("SEL"));
    Builder.AddTypedTextChunk(((NeedAt) ? $("@selector") : $("selector")));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
    Builder.AddPlaceholderChunk($("selector"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // @"string"
    Builder.AddResultTypeChunk($("NSString *"));
    Builder.AddTypedTextChunk(((NeedAt) ? $("@\"") : $DBL_QUOTE));
    Builder.AddPlaceholderChunk($("string"));
    Builder.AddTextChunk($DBL_QUOTE);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // @[objects, ...]
    Builder.AddResultTypeChunk($("NSArray *"));
    Builder.AddTypedTextChunk(((NeedAt) ? $("@[") : $LSQUARE));
    Builder.AddPlaceholderChunk($("objects, ..."));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBracket);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // @{key : object, ...}
    Builder.AddResultTypeChunk($("NSDictionary *"));
    Builder.AddTypedTextChunk(((NeedAt) ? $("@{") : $LCURLY));
    Builder.AddPlaceholderChunk($("key"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("object, ..."));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // @(expression)
    Builder.AddResultTypeChunk($("id"));
    Builder.AddTypedTextChunk(((NeedAt) ? $("@(") : $LPAREN));
    Builder.AddPlaceholderChunk($("expression"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddObjCStatementResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4778,
 FQN="AddObjCStatementResults", NM="_ZL23AddObjCStatementResultsRN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL23AddObjCStatementResultsRN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCStatementResults(final ResultBuilder /*&*/ Results, boolean NeedAt) {
  CodeCompletionBuilder Builder = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    if (Results.includeCodePatterns()) {
      // @try { statements } @catch ( declaration ) { statements } @finally
      //   { statements }
      Builder.AddTypedTextChunk(((NeedAt) ? $("@try") : $try));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
      Builder.AddPlaceholderChunk($("statements"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
      Builder.AddTextChunk($("@catch"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      Builder.AddPlaceholderChunk($("parameter"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
      Builder.AddPlaceholderChunk($("statements"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
      Builder.AddTextChunk($("@finally"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
      Builder.AddPlaceholderChunk($("statements"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
    
    // @throw
    Builder.AddTypedTextChunk(((NeedAt) ? $("@throw") : $throw));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("expression"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    if (Results.includeCodePatterns()) {
      // @synchronized ( expression ) { statements }
      Builder.AddTypedTextChunk(((NeedAt) ? $("@synchronized") : $("synchronized")));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      Builder.AddPlaceholderChunk($("expression"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
      Builder.AddPlaceholderChunk($("statements"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddObjCVisibilityResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4824,
 FQN="AddObjCVisibilityResults", NM="_ZL24AddObjCVisibilityResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24AddObjCVisibilityResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCVisibilityResults(final /*const*/ LangOptions /*&*/ LangOpts, 
                        final ResultBuilder /*&*/ Results, 
                        boolean NeedAt) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@private") : $private)));
  Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@protected") : $protected)));
  Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@public") : $public)));
  if (LangOpts.ObjC2) {
    Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@package") : $("package"))));
  }
}

//<editor-fold defaultstate="collapsed" desc="AddObjCImplementationResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4602,
 FQN="AddObjCImplementationResults", NM="_ZL28AddObjCImplementationResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL28AddObjCImplementationResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCImplementationResults(final /*const*/ LangOptions /*&*/ LangOpts, 
                            final ResultBuilder /*&*/ Results, 
                            boolean NeedAt) {
  CodeCompletionBuilder Builder = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    // Since we have an implementation, we can end it.
    Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@end") : $("end"))));
    
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    if (LangOpts.ObjC2) {
      // @dynamic
      Builder.AddTypedTextChunk(((NeedAt) ? $("@dynamic") : $("dynamic")));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("property"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      // @synthesize
      Builder.AddTypedTextChunk(((NeedAt) ? $("@synthesize") : $("synthesize")));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("property"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddObjCInterfaceResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4626,
 FQN="AddObjCInterfaceResults", NM="_ZL23AddObjCInterfaceResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL23AddObjCInterfaceResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCInterfaceResults(final /*const*/ LangOptions /*&*/ LangOpts, 
                       final ResultBuilder /*&*/ Results, 
                       boolean NeedAt) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  
  // Since we have an interface or protocol, we can end it.
  Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@end") : $("end"))));
  if (LangOpts.ObjC2) {
    // @property
    Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@property") : $("property"))));
    
    // @required
    Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@required") : $("required"))));
    
    // @optional
    Results.AddResult(new CodeCompletionResult(((NeedAt) ? $("@optional") : $("optional"))));
  }
}

//<editor-fold defaultstate="collapsed" desc="AddObjCTopLevelResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4646,
 FQN="AddObjCTopLevelResults", NM="_ZL22AddObjCTopLevelResultsRN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL22AddObjCTopLevelResultsRN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCTopLevelResults(final ResultBuilder /*&*/ Results, boolean NeedAt) {
  CodeCompletionBuilder Builder = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    
    // @class name ;
    Builder.AddTypedTextChunk(((NeedAt) ? $("@class") : $class));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("name"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    if (Results.includeCodePatterns()) {
      // @interface name 
      // FIXME: Could introduce the whole pattern, including superclasses and 
      // such.
      Builder.AddTypedTextChunk(((NeedAt) ? $("@interface") : $("interface")));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($class);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      // @protocol name
      Builder.AddTypedTextChunk(((NeedAt) ? $("@protocol") : $("protocol")));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("protocol"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      // @implementation name
      Builder.AddTypedTextChunk(((NeedAt) ? $("@implementation") : $("implementation")));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($class);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
    
    // @compatibility_alias name
    Builder.AddTypedTextChunk(((NeedAt) ? $("@compatibility_alias") : $("compatibility_alias")));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("alias"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($class);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    if (Results.getSema().getLangOpts().Modules) {
      // @import name
      Builder.AddTypedTextChunk(((NeedAt) ? $("@import") : $import));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("module"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddTypedefResult">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1424,
 FQN="AddTypedefResult", NM="_ZL16AddTypedefResultRN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL16AddTypedefResultRN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddTypedefResult(final ResultBuilder /*&*/ Results) {
  CodeCompletionBuilder Builder = null;
  try {
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    Builder.AddTypedTextChunk($typedef);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("type"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("name"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="WantTypesInContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1435,
 FQN="WantTypesInContext", NM="_ZL18WantTypesInContextN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL18WantTypesInContextN5clang4Sema23ParserCompletionContextERKNS_11LangOptionsE")
//</editor-fold>
public static boolean WantTypesInContext(Sema.ParserCompletionContext CCC, 
                  final /*const*/ LangOptions /*&*/ LangOpts) {
  switch (CCC) {
   case PCC_Namespace:
   case PCC_Class:
   case PCC_ObjCInstanceVariableList:
   case PCC_Template:
   case PCC_MemberTemplate:
   case PCC_Statement:
   case PCC_RecoveryInFunction:
   case PCC_Type:
   case PCC_ParenthesizedExpression:
   case PCC_LocalDeclarationSpecifiers:
    return true;
   case PCC_Expression:
   case PCC_Condition:
    return LangOpts.CPlusPlus;
   case PCC_ObjCInterface:
   case PCC_ObjCImplementation:
    return false;
   case PCC_ForInit:
    return LangOpts.CPlusPlus || LangOpts.ObjC1 || LangOpts.C99;
  }
  throw new llvm_unreachable("Invalid ParserCompletionContext!");
}

//<editor-fold defaultstate="collapsed" desc="getCompletionPrintingPolicy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1465,
 FQN="getCompletionPrintingPolicy", NM="_ZL27getCompletionPrintingPolicyRKN5clang10ASTContextERKNS_12PreprocessorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL27getCompletionPrintingPolicyRKN5clang10ASTContextERKNS_12PreprocessorE")
//</editor-fold>
public static PrintingPolicy getCompletionPrintingPolicy(final /*const*/ ASTContext /*&*/ Context, 
                           final /*const*/ Preprocessor /*&*/ PP) {
  PrintingPolicy Policy = Sema.getPrintingPolicy(Context, PP);
  Policy.AnonymousTagLocations = false;
  Policy.SuppressStrongLifetime = true;
  Policy.SuppressUnwrittenScope = true;
  return Policy;
}


/// \brief Retrieve a printing policy suitable for code completion.
//<editor-fold defaultstate="collapsed" desc="getCompletionPrintingPolicy">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1475,
 FQN="getCompletionPrintingPolicy", NM="_ZL27getCompletionPrintingPolicyRN5clang4SemaE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL27getCompletionPrintingPolicyRN5clang4SemaE")
//</editor-fold>
public static PrintingPolicy getCompletionPrintingPolicy(final Sema /*&*/ S) {
  return getCompletionPrintingPolicy(S.Context, S.PP);
}


/// \brief Retrieve the string representation of the given type as a string
/// that has the appropriate lifetime for code completion.
///
/// This routine provides a fast path where we provide constant strings for
/// common type names.
//<editor-fold defaultstate="collapsed" desc="GetCompletionTypeString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1484,
 FQN="GetCompletionTypeString", NM="_ZL23GetCompletionTypeStringN5clang8QualTypeERNS_10ASTContextERKNS_14PrintingPolicyERNS_23CodeCompletionAllocatorE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL23GetCompletionTypeStringN5clang8QualTypeERNS_10ASTContextERKNS_14PrintingPolicyERNS_23CodeCompletionAllocatorE")
//</editor-fold>
public static /*const*/char$ptr/*char P*/ GetCompletionTypeString(QualType T, 
                       final ASTContext /*&*/ Context, 
                       final /*const*/ PrintingPolicy /*&*/ Policy, 
                       final CodeCompletionAllocator /*&*/ Allocator) {
  if (!T.getLocalQualifiers().$bool()) {
    {
      // Built-in type names are constant strings.
      /*const*/ BuiltinType /*P*/ BT = dyn_cast_BuiltinType(T);
      if ((BT != null)) {
        return BT.getNameAsCString(Policy);
      }
    }
    {
      
      // Anonymous tag types are constant strings.
      /*const*/ TagType /*P*/ TagT = dyn_cast_TagType(T);
      if ((TagT != null)) {
        {
          TagDecl /*P*/ Tag = TagT.getDecl();
          if ((Tag != null)) {
            if (!Tag.hasNameForLinkage()) {
              switch (Tag.getTagKind()) {
               case TTK_Struct:
                return $("struct <anonymous>");
               case TTK_Interface:
                return $("__interface <anonymous>");
               case TTK_Class:
                return $("class <anonymous>");
               case TTK_Union:
                return $("union <anonymous>");
               case TTK_Enum:
                return $("enum <anonymous>");
              }
            }
          }
        }
      }
    }
  }
  
  // Slow path: format the type as a string.
  std.string Result/*J*/= new std.string();
  T.getAsStringInternal(Result, Policy);
  return Allocator.CopyString(new Twine(Result));
}


/// \brief Add a completion for "this", if we're in a member function.
//<editor-fold defaultstate="collapsed" desc="addThisCompletion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1514,
 FQN="addThisCompletion", NM="_ZL17addThisCompletionRN5clang4SemaERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL17addThisCompletionRN5clang4SemaERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void addThisCompletion(final Sema /*&*/ S, final ResultBuilder /*&*/ Results) {
  CodeCompletionBuilder Builder = null;
  try {
    QualType ThisTy = S.getCurrentThisType();
    if (ThisTy.isNull()) {
      return;
    }
    
    final CodeCompletionAllocator /*&*/ Allocator = Results.getAllocator();
    Builder/*J*/= new CodeCompletionBuilder(Allocator, Results.getCodeCompletionTUInfo());
    PrintingPolicy Policy = getCompletionPrintingPolicy(S);
    Builder.AddResultTypeChunk(GetCompletionTypeString(new QualType(ThisTy), 
            S.Context, 
            Policy, 
            Allocator));
    Builder.AddTypedTextChunk($this);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}


/// \brief Add language constructs that show up for "ordinary" names.
//<editor-fold defaultstate="collapsed" desc="AddOrdinaryNameResults">
@Converted(kind = Converted.Kind.MANUAL,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 1531,
 FQN="AddOrdinaryNameResults", NM="_ZL22AddOrdinaryNameResultsN5clang4Sema23ParserCompletionContextEPNS_5ScopeERS0_RN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL22AddOrdinaryNameResultsN5clang4Sema23ParserCompletionContextEPNS_5ScopeERS0_RN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddOrdinaryNameResults(Sema.ParserCompletionContext CCC, 
                      Scope /*P*/ S, 
                      final Sema /*&*/ SemaRef, 
                      final ResultBuilder /*&*/ Results) {
  CodeCompletionBuilder Builder = null;
  try {
    final CodeCompletionAllocator /*&*/ Allocator = Results.getAllocator();
    Builder/*J*/= new CodeCompletionBuilder(Allocator, Results.getCodeCompletionTUInfo());
    
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    switch (CCC) {
     case PCC_Namespace:
      if (SemaRef.getLangOpts().CPlusPlus) {
        if (Results.includeCodePatterns()) {
          // namespace <identifier> { declarations }
          Builder.AddTypedTextChunk($namespace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($identifier);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddPlaceholderChunk($("declarations"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        
        // namespace identifier = identifier ;
        Builder.AddTypedTextChunk($namespace);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($("name"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Equal);
        Builder.AddPlaceholderChunk($namespace);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // Using directives
        Builder.AddTypedTextChunk($using);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTextChunk($namespace);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($identifier);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // asm(string-literal)      
        Builder.AddTypedTextChunk($asm);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("string-literal"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        if (Results.includeCodePatterns()) {
          // Explicit template instantiation
          Builder.AddTypedTextChunk($template);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("declaration"));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
      }
      if (SemaRef.getLangOpts().ObjC1) {
        AddObjCTopLevelResults(Results, true);
      }
      
      AddTypedefResult(Results);
     case PCC_Class:
      // Fall through
      if (SemaRef.getLangOpts().CPlusPlus) {
        // Using declaration
        Builder.AddTypedTextChunk($using);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($("qualifier"));
        Builder.AddTextChunk($COLON_COLON);
        Builder.AddPlaceholderChunk($("name"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // using typename qualifier::name (only in a dependent context)
        if (SemaRef.CurContext.isDependentContext()) {
          Builder.AddTypedTextChunk($using);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddTextChunk($typename);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("qualifier"));
          Builder.AddTextChunk($COLON_COLON);
          Builder.AddPlaceholderChunk($("name"));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        if (CCC == Sema.ParserCompletionContext.PCC_Class) {
          AddTypedefResult(Results);
          
          // public:
          Builder.AddTypedTextChunk($public);
          if (Results.includeCodePatterns()) {
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
          }
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // protected:
          Builder.AddTypedTextChunk($protected);
          if (Results.includeCodePatterns()) {
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
          }
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // private:
          Builder.AddTypedTextChunk($private);
          if (Results.includeCodePatterns()) {
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
          }
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
      }
     case PCC_Template:
     case PCC_MemberTemplate:
      // Fall through
      if (SemaRef.getLangOpts().CPlusPlus && Results.includeCodePatterns()) {
        // template < parameters >
        Builder.AddTypedTextChunk($template);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
        Builder.AddPlaceholderChunk($("parameters"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      }
      
      AddStorageSpecifiers(CCC, SemaRef.getLangOpts(), Results);
      AddFunctionSpecifiers(CCC, SemaRef.getLangOpts(), Results);
      break;
     case PCC_ObjCInterface:
      AddObjCInterfaceResults(SemaRef.getLangOpts(), Results, true);
      AddStorageSpecifiers(CCC, SemaRef.getLangOpts(), Results);
      AddFunctionSpecifiers(CCC, SemaRef.getLangOpts(), Results);
      break;
     case PCC_ObjCImplementation:
      AddObjCImplementationResults(SemaRef.getLangOpts(), Results, true);
      AddStorageSpecifiers(CCC, SemaRef.getLangOpts(), Results);
      AddFunctionSpecifiers(CCC, SemaRef.getLangOpts(), Results);
      break;
     case PCC_ObjCInstanceVariableList:
      AddObjCVisibilityResults(SemaRef.getLangOpts(), Results, true);
      break;
     case PCC_RecoveryInFunction:
     case PCC_Statement:
      {
        AddTypedefResult(Results);
        if (SemaRef.getLangOpts().CPlusPlus && Results.includeCodePatterns()
           && SemaRef.getLangOpts().CXXExceptions) {
          Builder.AddTypedTextChunk($try);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddPlaceholderChunk($("statements"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Builder.AddTextChunk($catch);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("declaration"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddPlaceholderChunk($("statements"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        if (SemaRef.getLangOpts().ObjC1) {
          AddObjCStatementResults(Results, true);
        }
        if (Results.includeCodePatterns()) {
          // if (condition) { statements }
          Builder.AddTypedTextChunk($if);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          if (SemaRef.getLangOpts().CPlusPlus) {
            Builder.AddPlaceholderChunk($("condition"));
          } else {
            Builder.AddPlaceholderChunk($("expression"));
          }
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddPlaceholderChunk($("statements"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // switch (condition) { }
          Builder.AddTypedTextChunk($switch);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          if (SemaRef.getLangOpts().CPlusPlus) {
            Builder.AddPlaceholderChunk($("condition"));
          } else {
            Builder.AddPlaceholderChunk($("expression"));
          }
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        
        // Switch-specific statements.
        if (!SemaRef.getCurFunction().SwitchStack.empty()) {
          // case expression:
          Builder.AddTypedTextChunk($case);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("expression"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // default:
          Builder.AddTypedTextChunk($default);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        if (Results.includeCodePatterns()) {
          /// while (condition) { statements }
          Builder.AddTypedTextChunk($while);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          if (SemaRef.getLangOpts().CPlusPlus) {
            Builder.AddPlaceholderChunk($("condition"));
          } else {
            Builder.AddPlaceholderChunk($("expression"));
          }
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddPlaceholderChunk($("statements"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // do { statements } while ( expression );
          Builder.AddTypedTextChunk($do);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddPlaceholderChunk($("statements"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Builder.AddTextChunk($while);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("expression"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // for ( for-init-statement ; condition ; expression ) { statements }
          Builder.AddTypedTextChunk($for);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          if (SemaRef.getLangOpts().CPlusPlus || SemaRef.getLangOpts().C99) {
            Builder.AddPlaceholderChunk($("init-statement"));
          } else {
            Builder.AddPlaceholderChunk($("init-expression"));
          }
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_SemiColon);
          Builder.AddPlaceholderChunk($("condition"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_SemiColon);
          Builder.AddPlaceholderChunk($("inc-expression"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddPlaceholderChunk($("statements"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        if ((S.getContinueParent() != null)) {
          // continue ;
          Builder.AddTypedTextChunk($continue);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        if ((S.getBreakParent() != null)) {
          // break ;
          Builder.AddTypedTextChunk($break);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        
        // "return expression ;" or "return ;", depending on whether we
        // know the function is void or not.
        boolean isVoid = false;
        {
          FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl(SemaRef.CurContext);
          if ((Function != null)) {
            isVoid = Function.getReturnType().$arrow().isVoidType();
          } else {
            ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(SemaRef.CurContext);
            if ((Method != null)) {
              isVoid = Method.getReturnType().$arrow().isVoidType();
            } else if ((SemaRef.getCurBlock() != null)
               && !SemaRef.getCurBlock().ReturnType.isNull()) {
              isVoid = SemaRef.getCurBlock().ReturnType.$arrow().isVoidType();
            }
          }
        }
        Builder.AddTypedTextChunk($return);
        if (!isVoid) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("expression"));
        }
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // goto identifier ;
        Builder.AddTypedTextChunk($goto);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($("label"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // Using directives
        Builder.AddTypedTextChunk($using);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTextChunk($namespace);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($identifier);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      }
     case PCC_ForInit:
     case PCC_Condition:
      
      // Fall through (for statement expressions).
      AddStorageSpecifiers(CCC, SemaRef.getLangOpts(), Results);
     case PCC_ParenthesizedExpression:
      // Fall through: conditions and statements can have expressions.
      if (SemaRef.getLangOpts().ObjCAutoRefCount
         && CCC == Sema.ParserCompletionContext.PCC_ParenthesizedExpression) {
        // (__bridge <type>)<expression>
        Builder.AddTypedTextChunk($__bridge);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($("type"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddPlaceholderChunk($("expression"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // (__bridge_transfer <Objective-C type>)<expression>
        Builder.AddTypedTextChunk($__bridge_transfer);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($("Objective-C type"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddPlaceholderChunk($("expression"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        
        // (__bridge_retained <CF type>)<expression>
        Builder.AddTypedTextChunk($__bridge_retained);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddPlaceholderChunk($("CF type"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddPlaceholderChunk($("expression"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      }
     case PCC_Expression:
      {
        if (SemaRef.getLangOpts().CPlusPlus) {
          // 'this', if we're in a non-static member function.
          addThisCompletion(SemaRef, Results);
          
          // true
          Builder.AddResultTypeChunk($bool);
          Builder.AddTypedTextChunk($true);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // false
          Builder.AddResultTypeChunk($bool);
          Builder.AddTypedTextChunk($false);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          if (SemaRef.getLangOpts().RTTI) {
            // dynamic_cast < type-id > ( expression )
            Builder.AddTypedTextChunk($dynamic_cast);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
            Builder.AddPlaceholderChunk($("type"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
            Builder.AddPlaceholderChunk($("expression"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          }
          
          // static_cast < type-id > ( expression )
          Builder.AddTypedTextChunk($static_cast);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
          Builder.AddPlaceholderChunk($("type"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("expression"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // reinterpret_cast < type-id > ( expression )
          Builder.AddTypedTextChunk($reinterpret_cast);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
          Builder.AddPlaceholderChunk($("type"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("expression"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // const_cast < type-id > ( expression )
          Builder.AddTypedTextChunk($const_cast);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
          Builder.AddPlaceholderChunk($("type"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("expression"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          if (SemaRef.getLangOpts().RTTI) {
            // typeid ( expression-or-type )
            Builder.AddResultTypeChunk($("std::type_info"));
            Builder.AddTypedTextChunk($typeid);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
            Builder.AddPlaceholderChunk($("expression-or-type"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          }
          
          // new T ( ... )
          Builder.AddTypedTextChunk($new);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("type"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("expressions"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // new T [ ] ( ... )
          Builder.AddTypedTextChunk($new);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("type"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBracket);
          Builder.AddPlaceholderChunk($("size"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBracket);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("expressions"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // delete expression
          Builder.AddResultTypeChunk($void);
          Builder.AddTypedTextChunk($delete);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("expression"));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          
          // delete [] expression
          Builder.AddResultTypeChunk($void);
          Builder.AddTypedTextChunk($delete);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBracket);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBracket);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddPlaceholderChunk($("expression"));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          if (SemaRef.getLangOpts().CXXExceptions) {
            // throw expression
            Builder.AddResultTypeChunk($void);
            Builder.AddTypedTextChunk($throw);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
            Builder.AddPlaceholderChunk($("expression"));
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          }
          
          // FIXME: Rethrow?
          if (SemaRef.getLangOpts().CPlusPlus11) {
            // nullptr
            Builder.AddResultTypeChunk($("std::nullptr_t"));
            Builder.AddTypedTextChunk($nullptr);
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
            
            // alignof
            Builder.AddResultTypeChunk($("size_t"));
            Builder.AddTypedTextChunk($alignof);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
            Builder.AddPlaceholderChunk($("type"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
            
            // noexcept
            Builder.AddResultTypeChunk($bool);
            Builder.AddTypedTextChunk($noexcept);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
            Builder.AddPlaceholderChunk($("expression"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
            
            // sizeof... expression
            Builder.AddResultTypeChunk($("size_t"));
            Builder.AddTypedTextChunk($("sizeof..."));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
            Builder.AddPlaceholderChunk($("parameter-pack"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
            Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          }
        }
        if (SemaRef.getLangOpts().ObjC1) {
          {
            // Add "super", if we're in an Objective-C class with a superclass.
            ObjCMethodDecl /*P*/ Method = SemaRef.getCurMethodDecl();
            if ((Method != null)) {
              {
                // The interface can be NULL.
                ObjCInterfaceDecl /*P*/ ID = Method.getClassInterface();
                if ((ID != null)) {
                  if ((ID.getSuperClass() != null)) {
                    std.string SuperType/*J*/= new std.string();
                    SuperType.$assignMove(ID.getSuperClass().getNameAsString());
                    if (Method.isInstanceMethod()) {
                      SuperType.$addassign_T$C$P(/*KEEP_STR*/" *");
                    }
                    
                    Builder.AddResultTypeChunk(Allocator.CopyString(new Twine(SuperType)));
                    Builder.AddTypedTextChunk($("super"));
                    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
                  }
                }
              }
            }
          }
          
          AddObjCExpressionResults(Results, true);
        }
        if (SemaRef.getLangOpts().C11) {
          // _Alignof
          Builder.AddResultTypeChunk($("size_t"));
          if (SemaRef.PP.isMacroDefined(new StringRef(/*JAVA*/"alignof"))) {
            Builder.AddTypedTextChunk($alignof);
          } else {
            Builder.AddTypedTextChunk($_Alignof);
          }
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("type"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        }
        
        // sizeof expression
        Builder.AddResultTypeChunk($("size_t"));
        Builder.AddTypedTextChunk($sizeof);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("expression-or-type"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
        break;
      }
     case PCC_Type:
     case PCC_LocalDeclarationSpecifiers:
      break;
    }
    if (WantTypesInContext(CCC, SemaRef.getLangOpts())) {
      AddTypeSpecifierResults(SemaRef.getLangOpts(), Results);
    }
    if (SemaRef.getLangOpts().CPlusPlus && CCC != Sema.ParserCompletionContext.PCC_Type) {
      Results.AddResult(new CodeCompletionResult($operator));
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}


/// \brief If the given declaration has an associated type, add it as a result 
/// type chunk.
//<editor-fold defaultstate="collapsed" desc="AddResultTypeChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2069,
 FQN="AddResultTypeChunk", NM="_ZL18AddResultTypeChunkRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_9NamedDeclENS_8QualTypeERNS_21CodeCompletionBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL18AddResultTypeChunkRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_9NamedDeclENS_8QualTypeERNS_21CodeCompletionBuilderE")
//</editor-fold>
public static void AddResultTypeChunk(final ASTContext /*&*/ Context, 
                  final /*const*/ PrintingPolicy /*&*/ Policy, 
                  /*const*/ NamedDecl /*P*/ ND, 
                  QualType BaseType, 
                  final CodeCompletionBuilder /*&*/ Result) {
  if (!(ND != null)) {
    return;
  }
  
  // Skip constructors and conversion functions, which have their return types
  // built into their names.
  if (isa_CXXConstructorDecl(ND) || isa_CXXConversionDecl(ND)) {
    return;
  }
  
  // Determine the type of the declaration (if it has a type).
  QualType T/*J*/= new QualType();
  {
    /*const*/ FunctionDecl /*P*/ Function = ND.getAsFunction$Const();
    if ((Function != null)) {
      T.$assignMove(Function.getReturnType());
    } else {
      /*const*/ ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl(ND);
      if ((Method != null)) {
        if (!BaseType.isNull()) {
          T.$assignMove(Method.getSendResultType(new QualType(BaseType)));
        } else {
          T.$assignMove(Method.getReturnType());
        }
      } else {
        /*const*/ EnumConstantDecl /*P*/ Enumerator = dyn_cast_EnumConstantDecl(ND);
        if ((Enumerator != null)) {
          T.$assignMove(Context.getTypeDeclType(cast_TypeDecl(Enumerator.getDeclContext$Const())));
        } else if (isa_UnresolvedUsingValueDecl(ND)) {
          /* Do nothing: ignore unresolved using declarations*/
        } else {
          /*const*/ ObjCIvarDecl /*P*/ Ivar = dyn_cast_ObjCIvarDecl(ND);
          if ((Ivar != null)) {
            if (!BaseType.isNull()) {
              T.$assignMove(Ivar.getUsageType(new QualType(BaseType)));
            } else {
              T.$assignMove(Ivar.getType());
            }
          } else {
            /*const*/ ValueDecl /*P*/ Value = dyn_cast_ValueDecl(ND);
            if ((Value != null)) {
              T.$assignMove(Value.getType());
            } else {
              /*const*/ ObjCPropertyDecl /*P*/ Property = dyn_cast_ObjCPropertyDecl(ND);
              if ((Property != null)) {
                if (!BaseType.isNull()) {
                  T.$assignMove(Property.getUsageType(new QualType(BaseType)));
                } else {
                  T.$assignMove(Property.getType());
                }
              }
            }
          }
        }
      }
    }
  }
  if (T.isNull() || Context.hasSameType(new QualType(T), Context.DependentTy.$QualType())) {
    return;
  }
  
  Result.AddResultTypeChunk(GetCompletionTypeString(new QualType(T), Context, Policy, 
          Result.getAllocator()));
}

//<editor-fold defaultstate="collapsed" desc="MaybeAddSentinel">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2116,
 FQN="MaybeAddSentinel", NM="_ZL16MaybeAddSentinelRN5clang12PreprocessorEPKNS_9NamedDeclERNS_21CodeCompletionBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL16MaybeAddSentinelRN5clang12PreprocessorEPKNS_9NamedDeclERNS_21CodeCompletionBuilderE")
//</editor-fold>
public static void MaybeAddSentinel(final Preprocessor /*&*/ PP, 
                /*const*/ NamedDecl /*P*/ FunctionOrMethod, 
                final CodeCompletionBuilder /*&*/ Result) {
  {
    SentinelAttr /*P*/ Sentinel = FunctionOrMethod.getAttr(SentinelAttr.class);
    if ((Sentinel != null)) {
      if (Sentinel.getSentinel() == 0) {
        if (PP.getLangOpts().ObjC1 && PP.isMacroDefined(new StringRef(/*KEEP_STR*/"nil"))) {
          Result.AddTextChunk($(", nil"));
        } else if (PP.isMacroDefined(new StringRef(/*KEEP_STR*/"NULL"))) {
          Result.AddTextChunk($(", NULL"));
        } else {
          Result.AddTextChunk($(", (void*)0"));
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="formatObjCParamQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2130,
 FQN="formatObjCParamQualifiers", NM="_ZL25formatObjCParamQualifiersjRN5clang8QualTypeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL25formatObjCParamQualifiersjRN5clang8QualTypeE")
//</editor-fold>
public static std.string formatObjCParamQualifiers(/*uint*/int ObjCQuals, 
                         final QualType /*&*/ Type) {
  std.string Result/*J*/= new std.string();
  if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_In) != 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"in ");
  } else if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_Inout) != 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"inout ");
  } else if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_Out) != 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"out ");
  }
  if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_Bycopy) != 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"bycopy ");
  } else if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_Byref) != 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"byref ");
  }
  if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_Oneway) != 0)) {
    Result.$addassign_T$C$P(/*KEEP_STR*/"oneway ");
  }
  if (((ObjCQuals & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0)) {
    {
      Optional<NullabilityKind> nullability = AttributedType.stripOuterNullability(Type);
      if (nullability.$bool()) {
        switch (nullability.$star()) {
         case NonNull:
          Result.$addassign_T$C$P(/*KEEP_STR*/"nonnull ");
          break;
         case Nullable:
          Result.$addassign_T$C$P(/*KEEP_STR*/"nullable ");
          break;
         case Unspecified:
          Result.$addassign_T$C$P(/*KEEP_STR*/"null_unspecified ");
          break;
        }
      }
    }
  }
  return Result;
}

//<editor-fold defaultstate="collapsed" desc="FormatFunctionParameter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2165,
 FQN="FormatFunctionParameter", NM="_ZL23FormatFunctionParameterRKN5clang14PrintingPolicyEPKNS_11ParmVarDeclEbbN4llvm8OptionalINS6_8ArrayRefINS_8QualTypeEEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL23FormatFunctionParameterRKN5clang14PrintingPolicyEPKNS_11ParmVarDeclEbbN4llvm8OptionalINS6_8ArrayRefINS_8QualTypeEEEEE")
//</editor-fold>
public static std.string FormatFunctionParameter(final /*const*/ PrintingPolicy /*&*/ Policy, 
                       /*const*/ ParmVarDecl /*P*/ Param) {
  return FormatFunctionParameter(Policy, 
                       Param, 
                       false, 
                       false, 
                       new Optional<ArrayRef<QualType> >(None));
}
public static std.string FormatFunctionParameter(final /*const*/ PrintingPolicy /*&*/ Policy, 
                       /*const*/ ParmVarDecl /*P*/ Param, 
                       boolean SuppressName/*= false*/) {
  return FormatFunctionParameter(Policy, 
                       Param, 
                       SuppressName, 
                       false, 
                       new Optional<ArrayRef<QualType> >(None));
}
public static std.string FormatFunctionParameter(final /*const*/ PrintingPolicy /*&*/ Policy, 
                       /*const*/ ParmVarDecl /*P*/ Param, 
                       boolean SuppressName/*= false*/, 
                       boolean SuppressBlock/*= false*/) {
  return FormatFunctionParameter(Policy, 
                       Param, 
                       SuppressName, 
                       SuppressBlock, 
                       new Optional<ArrayRef<QualType> >(None));
}
public static std.string FormatFunctionParameter(final /*const*/ PrintingPolicy /*&*/ Policy, 
                       /*const*/ ParmVarDecl /*P*/ Param, 
                       boolean SuppressName/*= false*/, 
                       boolean SuppressBlock/*= false*/, 
                       Optional<ArrayRef<QualType> > ObjCSubsts/*= None*/) {
  boolean ObjCMethodParam = isa_ObjCMethodDecl(Param.getDeclContext$Const());
  if (Param.getType().$arrow().isDependentType()
     || !Param.getType().$arrow().isBlockPointerType()) {
    // The argument for a dependent or non-block parameter is a placeholder 
    // containing that parameter's type.
    std.string Result/*J*/= new std.string();
    if ((Param.getIdentifier() != null) && !ObjCMethodParam && !SuppressName) {
      Result.$assignMove(Param.getIdentifier().getName().$string());
    }
    
    QualType Type = Param.getType();
    if (ObjCSubsts.$bool()) {
      Type.$assignMove(Type.substObjCTypeArgs(Param.getASTContext(), new ArrayRef<QualType>(ObjCSubsts.$star()), 
              ObjCSubstitutionContext.Parameter));
    }
    if (ObjCMethodParam) {
      Result.$assignMove($add_T$C$P_string(/*KEEP_STR*/"(", formatObjCParamQualifiers(Param.getObjCDeclQualifier(), 
                  Type)));
      Result.$addassign($add_string_T$C$P(Type.getAsString(Policy), /*KEEP_STR*/")"));
      if ((Param.getIdentifier() != null) && !SuppressName) {
        $addassign_string_StringRef(Result, Param.getIdentifier().getName());
      }
    } else {
      Type.getAsStringInternal(Result, Policy);
    }
    return Result;
  }
  
  // The argument for a block pointer parameter is a block literal with
  // the appropriate type.
  FunctionTypeLoc Block/*J*/= new FunctionTypeLoc();
  FunctionProtoTypeLoc BlockProto/*J*/= new FunctionProtoTypeLoc();
  TypeLoc TL/*J*/= new TypeLoc();
  {
    TypeSourceInfo /*P*/ TSInfo = Param.getTypeSourceInfo();
    if ((TSInfo != null)) {
      TL.$assignMove(TSInfo.getTypeLoc().getUnqualifiedLoc());
      while (true) {
        // Look through typedefs.
        if (!SuppressBlock) {
          {
            TypedefTypeLoc TypedefTL = TL.getAs(TypedefTypeLoc.class);
            if (TypedefTL.$bool()) {
              {
                TypeSourceInfo /*P*/ InnerTSInfo = TypedefTL.getTypedefNameDecl().getTypeSourceInfo();
                if ((InnerTSInfo != null)) {
                  TL.$assignMove(InnerTSInfo.getTypeLoc().getUnqualifiedLoc());
                  continue;
                }
              }
            }
          }
          {
            
            // Look through qualified types
            QualifiedTypeLoc QualifiedTL = TL.getAs(QualifiedTypeLoc.class);
            if (QualifiedTL.$bool()) {
              TL.$assignMove(QualifiedTL.getUnqualifiedLoc());
              continue;
            }
          }
          {
            
            AttributedTypeLoc AttrTL = TL.getAs(AttributedTypeLoc.class);
            if (AttrTL.$bool()) {
              TL.$assignMove(AttrTL.getModifiedLoc());
              continue;
            }
          }
        }
        {
          
          // Try to get the function prototype behind the block pointer type,
          // then we're done.
          BlockPointerTypeLoc BlockPtr = TL.getAs(BlockPointerTypeLoc.class);
          if (BlockPtr.$bool()) {
            TL.$assignMove(BlockPtr.getPointeeLoc().IgnoreParens());
            Block.$assignMove(TL.getAs(FunctionTypeLoc.class));
            BlockProto.$assignMove(TL.getAs(FunctionProtoTypeLoc.class));
          }
        }
        break;
      }
    }
  }
  if (!Block.$bool()) {
    // We were unable to find a FunctionProtoTypeLoc with parameter names
    // for the block; just use the parameter type as a placeholder.
    std.string Result/*J*/= new std.string();
    if (!ObjCMethodParam && (Param.getIdentifier() != null)) {
      Result.$assignMove(Param.getIdentifier().getName().$string());
    }
    
    QualType Type = Param.getType().getUnqualifiedType();
    if (ObjCMethodParam) {
      Result.$assignMove($add_T$C$P_string(/*KEEP_STR*/"(", formatObjCParamQualifiers(Param.getObjCDeclQualifier(), 
                  Type)));
      Result.$addassign($add_string_T$C$P($add_string_string$C(Type.getAsString(Policy), Result), /*KEEP_STR*/")"));
      if ((Param.getIdentifier() != null)) {
        $addassign_string_StringRef(Result, Param.getIdentifier().getName());
      }
    } else {
      Type.getAsStringInternal(Result, Policy);
    }
    
    return Result;
  }
  
  // We have the function prototype behind the block pointer type, as it was
  // written in the source.
  std.string Result/*J*/= new std.string();
  QualType ResultType = Block.getTypePtr().getReturnType();
  if (ObjCSubsts.$bool()) {
    ResultType.$assignMove(ResultType.substObjCTypeArgs(Param.getASTContext(), 
            new ArrayRef<QualType>(ObjCSubsts.$star()), 
            ObjCSubstitutionContext.Result));
  }
  if (!ResultType.$arrow().isVoidType() || SuppressBlock) {
    ResultType.getAsStringInternal(Result, Policy);
  }
  
  // Format the parameter list.
  std.string Params/*J*/= new std.string();
  if (!BlockProto.$bool() || Block.getNumParams() == 0) {
    if (BlockProto.$bool() && BlockProto.getTypePtr().isVariadic()) {
      Params.$assign_T$C$P(/*KEEP_STR*/"(...)");
    } else {
      Params.$assign_T$C$P(/*KEEP_STR*/"(void)");
    }
  } else {
    Params.$addassign_T$C$P(/*KEEP_STR*/"(");
    for (/*uint*/int I = 0, N = Block.getNumParams(); I != N; ++I) {
      if ((I != 0)) {
        Params.$addassign_T$C$P(/*KEEP_STR*/", ");
      }
      Params.$addassign(FormatFunctionParameter(Policy, Block.getParam(I), 
              /*SuppressName=*/ false, 
              /*SuppressBlock=*/ true, 
              new Optional<ArrayRef<QualType> >(ObjCSubsts)));
      if (I == N - 1 && BlockProto.getTypePtr().isVariadic()) {
        Params.$addassign_T$C$P(/*KEEP_STR*/", ...");
      }
    }
    Params.$addassign_T$C$P(/*KEEP_STR*/")");
  }
  if (SuppressBlock) {
    // Format as a parameter.
    Result.$assignMove($add_string$C_T$C$P(Result, /*KEEP_STR*/" (^"));
    if ((Param.getIdentifier() != null)) {
      $addassign_string_StringRef(Result, Param.getIdentifier().getName());
    }
    Result.$addassign_T$C$P(/*KEEP_STR*/")");
    Result.$addassign(Params);
  } else {
    // Format as a block literal argument.
    Result.$assignMove($add_T_string$C($$CARET, Result));
    Result.$addassign(Params);
    if ((Param.getIdentifier() != null)) {
      $addassign_string_StringRef(Result, Param.getIdentifier().getName());
    }
  }
  
  return Result;
}


/// \brief Add function parameter chunks to the given code completion string.
//<editor-fold defaultstate="collapsed" desc="AddFunctionParameterChunks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2313,
 FQN="AddFunctionParameterChunks", NM="_ZL26AddFunctionParameterChunksRN5clang12PreprocessorERKNS_14PrintingPolicyEPKNS_12FunctionDeclERNS_21CodeCompletionBuilderEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL26AddFunctionParameterChunksRN5clang12PreprocessorERKNS_14PrintingPolicyEPKNS_12FunctionDeclERNS_21CodeCompletionBuilderEjb")
//</editor-fold>
public static void AddFunctionParameterChunks(final Preprocessor /*&*/ PP, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ FunctionDecl /*P*/ Function, 
                          final CodeCompletionBuilder /*&*/ Result) {
  AddFunctionParameterChunks(PP, 
                          Policy, 
                          Function, 
                          Result, 
                          0, 
                          false);
}
public static void AddFunctionParameterChunks(final Preprocessor /*&*/ PP, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ FunctionDecl /*P*/ Function, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int Start/*= 0*/) {
  AddFunctionParameterChunks(PP, 
                          Policy, 
                          Function, 
                          Result, 
                          Start, 
                          false);
}
public static void AddFunctionParameterChunks(final Preprocessor /*&*/ PP, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ FunctionDecl /*P*/ Function, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int Start/*= 0*/, 
                          boolean InOptional/*= false*/) {
  boolean FirstParameter = true;
  
  for (/*uint*/int P = Start, N = Function.getNumParams(); P != N; ++P) {
    /*const*/ ParmVarDecl /*P*/ Param = Function.getParamDecl$Const(P);
    if (Param.hasDefaultArg() && !InOptional) {
      CodeCompletionBuilder Opt = null;
      try {
        // When we see an optional default argument, put that argument and
        // the remaining default arguments into a new, optional string.
        Opt/*J*/= new CodeCompletionBuilder(Result.getAllocator(), 
            Result.getCodeCompletionTUInfo());
        if (!FirstParameter) {
          Opt.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
        }
        AddFunctionParameterChunks(PP, Policy, Function, Opt, P, true);
        Result.AddOptionalChunk(Opt.TakeString());
        break;
      } finally {
        if (Opt != null) { Opt.$destroy(); }
      }
    }
    if (FirstParameter) {
      FirstParameter = false;
    } else {
      Result.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
    }
    
    InOptional = false;
    
    // Format the placeholder string.
    std.string PlaceholderStr = FormatFunctionParameter(Policy, Param);
    if (Function.isVariadic() && P == N - 1) {
      PlaceholderStr.$addassign_T$C$P(/*KEEP_STR*/", ...");
    }
    
    // Add the placeholder string.
    Result.AddPlaceholderChunk(Result.getAllocator().CopyString(new Twine(PlaceholderStr)));
  }
  {
    
    /*const*/ FunctionProtoType /*P*/ Proto = Function.getType().$arrow().getAs(FunctionProtoType.class);
    if ((Proto != null)) {
      if (Proto.isVariadic()) {
        if (Proto.getNumParams() == 0) {
          Result.AddPlaceholderChunk($ELLIPSIS);
        }
        
        MaybeAddSentinel(PP, Function, Result);
      }
    }
  }
}


/// \brief Add template parameter chunks to the given code completion string.
//<editor-fold defaultstate="collapsed" desc="AddTemplateParameterChunks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2365,
 FQN="AddTemplateParameterChunks", NM="_ZL26AddTemplateParameterChunksRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_12TemplateDeclERNS_21CodeCompletionBuilderEjjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL26AddTemplateParameterChunksRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_12TemplateDeclERNS_21CodeCompletionBuilderEjjb")
//</editor-fold>
public static void AddTemplateParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ TemplateDecl /*P*/ Template, 
                          final CodeCompletionBuilder /*&*/ Result) {
  AddTemplateParameterChunks(Context, 
                          Policy, 
                          Template, 
                          Result, 
                          0, 
                          0, 
                          false);
}
public static void AddTemplateParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ TemplateDecl /*P*/ Template, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int MaxParameters/*= 0*/) {
  AddTemplateParameterChunks(Context, 
                          Policy, 
                          Template, 
                          Result, 
                          MaxParameters, 
                          0, 
                          false);
}
public static void AddTemplateParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ TemplateDecl /*P*/ Template, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int MaxParameters/*= 0*/, 
                          /*uint*/int Start/*= 0*/) {
  AddTemplateParameterChunks(Context, 
                          Policy, 
                          Template, 
                          Result, 
                          MaxParameters, 
                          Start, 
                          false);
}
public static void AddTemplateParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ TemplateDecl /*P*/ Template, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int MaxParameters/*= 0*/, 
                          /*uint*/int Start/*= 0*/, 
                          boolean InDefaultArg/*= false*/) {
  boolean FirstParameter = true;
  
  // Prefer to take the template parameter names from the first declaration of
  // the template.
  Template = cast_TemplateDecl(Template.getCanonicalDecl$Const());
  
  TemplateParameterList /*P*/ Params = Template.getTemplateParameters();
  type$ptr<NamedDecl /*P*/ /*P*/ > PEnd = $tryClone(Params.end());
  if ((MaxParameters != 0)) {
    PEnd = $tryClone(Params.begin().$add(MaxParameters));
  }
  for (type$ptr<NamedDecl /*P*/ /*P*/ > P = $tryClone(Params.begin().$add(Start));
       $noteq_ptr(P, PEnd); P.$preInc()) {
    boolean HasDefaultArg = false;
    std.string PlaceholderStr/*J*/= new std.string();
    {
      TemplateTypeParmDecl /*P*/ TTP = dyn_cast_TemplateTypeParmDecl(P.$star());
      if ((TTP != null)) {
        if (TTP.wasDeclaredWithTypename()) {
          PlaceholderStr.$assign_T$C$P(/*KEEP_STR*/"typename");
        } else {
          PlaceholderStr.$assign_T$C$P(/*KEEP_STR*/"class");
        }
        if ((TTP.getIdentifier() != null)) {
          PlaceholderStr.$addassign_T($$SPACE);
          $addassign_string_StringRef(PlaceholderStr, TTP.getIdentifier().getName());
        }
        
        HasDefaultArg = TTP.hasDefaultArgument();
      } else {
        NonTypeTemplateParmDecl /*P*/ NTTP = dyn_cast_NonTypeTemplateParmDecl(P.$star());
        if ((NTTP != null)) {
          if ((NTTP.getIdentifier() != null)) {
            PlaceholderStr.$assignMove(NTTP.getIdentifier().getName().$string());
          }
          NTTP.getType().getAsStringInternal(PlaceholderStr, Policy);
          HasDefaultArg = NTTP.hasDefaultArgument();
        } else {
          assert (isa_TemplateTemplateParmDecl(P.$star()));
          TemplateTemplateParmDecl /*P*/ TTP$1 = cast_TemplateTemplateParmDecl(P.$star());
          
          // Since putting the template argument list into the placeholder would
          // be very, very long, we just use an abbreviation.
          PlaceholderStr.$assign_T$C$P(/*KEEP_STR*/"template<...> class");
          if ((TTP$1.getIdentifier() != null)) {
            PlaceholderStr.$addassign_T($$SPACE);
            $addassign_string_StringRef(PlaceholderStr, TTP$1.getIdentifier().getName());
          }
          
          HasDefaultArg = TTP$1.hasDefaultArgument();
        }
      }
    }
    if (HasDefaultArg && !InDefaultArg) {
      CodeCompletionBuilder Opt = null;
      try {
        // When we see an optional default argument, put that argument and
        // the remaining default arguments into a new, optional string.
        Opt/*J*/= new CodeCompletionBuilder(Result.getAllocator(), 
            Result.getCodeCompletionTUInfo());
        if (!FirstParameter) {
          Opt.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
        }
        AddTemplateParameterChunks(Context, Policy, Template, Opt, MaxParameters, 
            P.$sub(Params.begin()), true);
        Result.AddOptionalChunk(Opt.TakeString());
        break;
      } finally {
        if (Opt != null) { Opt.$destroy(); }
      }
    }
    
    InDefaultArg = false;
    if (FirstParameter) {
      FirstParameter = false;
    } else {
      Result.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
    }
    
    // Add the placeholder string.
    Result.AddPlaceholderChunk(Result.getAllocator().CopyString(new Twine(PlaceholderStr)));
  }
}


/// \brief Add a qualifier to the given code-completion string, if the
/// provided nested-name-specifier is non-NULL.
//<editor-fold defaultstate="collapsed" desc="AddQualifierToCompletionString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2447,
 FQN="AddQualifierToCompletionString", NM="_ZL30AddQualifierToCompletionStringRN5clang21CodeCompletionBuilderEPNS_19NestedNameSpecifierEbRNS_10ASTContextERKNS_14PrintingPolicyE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL30AddQualifierToCompletionStringRN5clang21CodeCompletionBuilderEPNS_19NestedNameSpecifierEbRNS_10ASTContextERKNS_14PrintingPolicyE")
//</editor-fold>
public static void AddQualifierToCompletionString(final CodeCompletionBuilder /*&*/ Result, 
                              NestedNameSpecifier /*P*/ Qualifier, 
                              boolean QualifierIsInformative, 
                              final ASTContext /*&*/ Context, 
                              final /*const*/ PrintingPolicy /*&*/ Policy) {
  if (!(Qualifier != null)) {
    return;
  }
  
  std.string PrintedNNS/*J*/= new std.string();
  {
    raw_string_ostream OS = null;
    try {
      OS/*J*/= new raw_string_ostream(PrintedNNS);
      Qualifier.print(OS, Policy);
    } finally {
      if (OS != null) { OS.$destroy(); }
    }
  }
  if (QualifierIsInformative) {
    Result.AddInformativeChunk(Result.getAllocator().CopyString(new Twine(PrintedNNS)));
  } else {
    Result.AddTextChunk(Result.getAllocator().CopyString(new Twine(PrintedNNS)));
  }
}

//<editor-fold defaultstate="collapsed" desc="AddFunctionTypeQualsToCompletionString">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2467,
 FQN="AddFunctionTypeQualsToCompletionString", NM="_ZL38AddFunctionTypeQualsToCompletionStringRN5clang21CodeCompletionBuilderEPKNS_12FunctionDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL38AddFunctionTypeQualsToCompletionStringRN5clang21CodeCompletionBuilderEPKNS_12FunctionDeclE")
//</editor-fold>
public static void AddFunctionTypeQualsToCompletionString(final CodeCompletionBuilder /*&*/ Result, 
                                      /*const*/ FunctionDecl /*P*/ Function) {
  /*const*/ FunctionProtoType /*P*/ Proto = Function.getType().$arrow().getAs(FunctionProtoType.class);
  if (!(Proto != null) || !(Proto.getTypeQuals() != 0)) {
    return;
  }
  
  // FIXME: Add ref-qualifier!
  
  // Handle single qualifiers without copying
  if (Proto.getTypeQuals() == Qualifiers.TQ.Const) {
    Result.AddInformativeChunk($(" const"));
    return;
  }
  if (Proto.getTypeQuals() == Qualifiers.TQ.Volatile) {
    Result.AddInformativeChunk($(" volatile"));
    return;
  }
  if (Proto.getTypeQuals() == Qualifiers.TQ.Restrict) {
    Result.AddInformativeChunk($(" restrict"));
    return;
  }
  
  // Handle multiple qualifiers.
  std.string QualsStr/*J*/= new std.string();
  if (Proto.isConst()) {
    QualsStr.$addassign_T$C$P(/*KEEP_STR*/" const");
  }
  if (Proto.isVolatile()) {
    QualsStr.$addassign_T$C$P(/*KEEP_STR*/" volatile");
  }
  if (Proto.isRestrict()) {
    QualsStr.$addassign_T$C$P(/*KEEP_STR*/" restrict");
  }
  Result.AddInformativeChunk(Result.getAllocator().CopyString(new Twine(QualsStr)));
}


/// \brief Add the name of the given declaration 
//<editor-fold defaultstate="collapsed" desc="AddTypedNameChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2505,
 FQN="AddTypedNameChunk", NM="_ZL17AddTypedNameChunkRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_9NamedDeclERNS_21CodeCompletionBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL17AddTypedNameChunkRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_9NamedDeclERNS_21CodeCompletionBuilderE")
//</editor-fold>
public static void AddTypedNameChunk(final ASTContext /*&*/ Context, final /*const*/ PrintingPolicy /*&*/ Policy, 
                 /*const*/ NamedDecl /*P*/ ND, 
                 final CodeCompletionBuilder /*&*/ Result) {
  DeclarationName Name = ND.getDeclName();
  if (!Name.$bool()) {
    return;
  }
  switch (Name.getNameKind()) {
   case CXXOperatorName:
    {
      /*const*/char$ptr/*char P*/ OperatorName = null;
      switch (Name.getCXXOverloadedOperator()) {
       case OO_None:
       case OO_Conditional:
       case NUM_OVERLOADED_OPERATORS:
        OperatorName = $tryClone($operator);
        break;
       case OO_Plus:
        OperatorName = $tryClone($("operator+"));
        break;
       case OO_Minus:
        OperatorName = $tryClone($("operator-"));
        break;
       case OO_Star:
        OperatorName = $tryClone($("operator*"));
        break;
       case OO_Slash:
        OperatorName = $tryClone($("operator/"));
        break;
       case OO_Percent:
        OperatorName = $tryClone($("operator%"));
        break;
       case OO_Caret:
        OperatorName = $tryClone($("operator^"));
        break;
       case OO_Amp:
        OperatorName = $tryClone($("operator&"));
        break;
       case OO_Pipe:
        OperatorName = $tryClone($("operator|"));
        break;
       case OO_Tilde:
        OperatorName = $tryClone($("operator~"));
        break;
       case OO_Exclaim:
        OperatorName = $tryClone($("operator!"));
        break;
       case OO_Equal:
        OperatorName = $tryClone($("operator="));
        break;
       case OO_Less:
        OperatorName = $tryClone($("operator<"));
        break;
       case OO_Greater:
        OperatorName = $tryClone($("operator>"));
        break;
       case OO_PlusEqual:
        OperatorName = $tryClone($("operator+="));
        break;
       case OO_MinusEqual:
        OperatorName = $tryClone($("operator-="));
        break;
       case OO_StarEqual:
        OperatorName = $tryClone($("operator*="));
        break;
       case OO_SlashEqual:
        OperatorName = $tryClone($("operator/="));
        break;
       case OO_PercentEqual:
        OperatorName = $tryClone($("operator%="));
        break;
       case OO_CaretEqual:
        OperatorName = $tryClone($("operator^="));
        break;
       case OO_AmpEqual:
        OperatorName = $tryClone($("operator&="));
        break;
       case OO_PipeEqual:
        OperatorName = $tryClone($("operator|="));
        break;
       case OO_LessLess:
        OperatorName = $tryClone($("operator<<"));
        break;
       case OO_GreaterGreater:
        OperatorName = $tryClone($("operator>>"));
        break;
       case OO_LessLessEqual:
        OperatorName = $tryClone($("operator<<="));
        break;
       case OO_GreaterGreaterEqual:
        OperatorName = $tryClone($("operator>>="));
        break;
       case OO_EqualEqual:
        OperatorName = $tryClone($("operator=="));
        break;
       case OO_ExclaimEqual:
        OperatorName = $tryClone($("operator!="));
        break;
       case OO_LessEqual:
        OperatorName = $tryClone($("operator<="));
        break;
       case OO_GreaterEqual:
        OperatorName = $tryClone($("operator>="));
        break;
       case OO_AmpAmp:
        OperatorName = $tryClone($("operator&&"));
        break;
       case OO_PipePipe:
        OperatorName = $tryClone($("operator||"));
        break;
       case OO_PlusPlus:
        OperatorName = $tryClone($("operator++"));
        break;
       case OO_MinusMinus:
        OperatorName = $tryClone($("operator--"));
        break;
       case OO_Comma:
        OperatorName = $tryClone($("operator,"));
        break;
       case OO_ArrowStar:
        OperatorName = $tryClone($("operator->*"));
        break;
       case OO_Arrow:
        OperatorName = $tryClone($("operator->"));
        break;
       case OO_Coawait:
        OperatorName = $tryClone($("operatorco_await"));
        break;
       case OO_New:
        OperatorName = $tryClone($("operator new"));
        break;
       case OO_Delete:
        OperatorName = $tryClone($("operator delete"));
        break;
       case OO_Array_New:
        OperatorName = $tryClone($("operator new[]"));
        break;
       case OO_Array_Delete:
        OperatorName = $tryClone($("operator delete[]"));
        break;
       case OO_Call:
        OperatorName = $tryClone($("operator()"));
        break;
       case OO_Subscript:
        OperatorName = $tryClone($("operator[]"));
        break;
      }
      Result.AddTypedTextChunk(OperatorName);
      break;
    }
   case Identifier:
   case CXXConversionFunctionName:
   case CXXDestructorName:
   case CXXLiteralOperatorName:
    Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(ND.getNameAsString())));
    break;
   case CXXUsingDirective:
   case ObjCZeroArgSelector:
   case ObjCOneArgSelector:
   case ObjCMultiArgSelector:
    break;
   case CXXConstructorName:
    {
      CXXRecordDecl /*P*/ Record = null;
      QualType Ty = Name.getCXXNameType();
      {
        /*const*/ RecordType /*P*/ RecordTy = Ty.$arrow().<RecordType>getAs$RecordType();
        if ((RecordTy != null)) {
          Record = cast_CXXRecordDecl(RecordTy.getDecl());
        } else {
          /*const*/ InjectedClassNameType /*P*/ InjectedTy = Ty.$arrow().<InjectedClassNameType>getAs$InjectedClassNameType();
          if ((InjectedTy != null)) {
            Record = InjectedTy.getDecl();
          } else {
            Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(ND.getNameAsString())));
            break;
          }
        }
      }
      
      Result.AddTypedTextChunk(Result.getAllocator().CopyString(new Twine(Record.getNameAsString())));
      {
        ClassTemplateDecl /*P*/ Template = Record.getDescribedClassTemplate();
        if ((Template != null)) {
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_LeftAngle);
          AddTemplateParameterChunks(Context, Policy, Template, Result);
          Result.AddChunk(CodeCompletionString.ChunkKind.CK_RightAngle);
        }
      }
      break;
    }
  }
}


/// \brief Add function overload parameter chunks to the given code completion
/// string.
//<editor-fold defaultstate="collapsed" desc="AddOverloadParameterChunks">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 2889,
 FQN="AddOverloadParameterChunks", NM="_ZL26AddOverloadParameterChunksRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_12FunctionDeclEPKNS_17FunctionProtoTypeERNS_21CodeCompletionBuilderEjjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL26AddOverloadParameterChunksRN5clang10ASTContextERKNS_14PrintingPolicyEPKNS_12FunctionDeclEPKNS_17FunctionProtoTypeERNS_21CodeCompletionBuilderEjjb")
//</editor-fold>
public static void AddOverloadParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ FunctionDecl /*P*/ Function, 
                          /*const*/ FunctionProtoType /*P*/ Prototype, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int CurrentArg) {
  AddOverloadParameterChunks(Context, 
                          Policy, 
                          Function, 
                          Prototype, 
                          Result, 
                          CurrentArg, 
                          0, 
                          false);
}
public static void AddOverloadParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ FunctionDecl /*P*/ Function, 
                          /*const*/ FunctionProtoType /*P*/ Prototype, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int CurrentArg, 
                          /*uint*/int Start/*= 0*/) {
  AddOverloadParameterChunks(Context, 
                          Policy, 
                          Function, 
                          Prototype, 
                          Result, 
                          CurrentArg, 
                          Start, 
                          false);
}
public static void AddOverloadParameterChunks(final ASTContext /*&*/ Context, 
                          final /*const*/ PrintingPolicy /*&*/ Policy, 
                          /*const*/ FunctionDecl /*P*/ Function, 
                          /*const*/ FunctionProtoType /*P*/ Prototype, 
                          final CodeCompletionBuilder /*&*/ Result, 
                          /*uint*/int CurrentArg, 
                          /*uint*/int Start/*= 0*/, 
                          boolean InOptional/*= false*/) {
  boolean FirstParameter = true;
  /*uint*/int NumParams = (Function != null) ? Function.getNumParams() : Prototype.getNumParams();
  
  for (/*uint*/int P = Start; P != NumParams; ++P) {
    if ((Function != null) && Function.getParamDecl$Const(P).hasDefaultArg() && !InOptional) {
      CodeCompletionBuilder Opt = null;
      try {
        // When we see an optional default argument, put that argument and
        // the remaining default arguments into a new, optional string.
        Opt/*J*/= new CodeCompletionBuilder(Result.getAllocator(), 
            Result.getCodeCompletionTUInfo());
        if (!FirstParameter) {
          Opt.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
        }
        // Optional sections are nested.
        AddOverloadParameterChunks(Context, Policy, Function, Prototype, Opt, 
            CurrentArg, P, /*InOptional=*/ true);
        Result.AddOptionalChunk(Opt.TakeString());
        return;
      } finally {
        if (Opt != null) { Opt.$destroy(); }
      }
    }
    if (FirstParameter) {
      FirstParameter = false;
    } else {
      Result.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
    }
    
    InOptional = false;
    
    // Format the placeholder string.
    std.string Placeholder/*J*/= new std.string();
    if ((Function != null)) {
      Placeholder.$assignMove(FormatFunctionParameter(Policy, Function.getParamDecl$Const(P)));
    } else {
      Placeholder.$assignMove(Prototype.getParamType(P).getAsString(Policy));
    }
    if (P == CurrentArg) {
      Result.AddCurrentParameterChunk(Result.getAllocator().CopyString(new Twine(Placeholder)));
    } else {
      Result.AddPlaceholderChunk(Result.getAllocator().CopyString(new Twine(Placeholder)));
    }
  }
  if ((Prototype != null) && Prototype.isVariadic()) {
    CodeCompletionBuilder Opt = null;
    try {
      Opt/*J*/= new CodeCompletionBuilder(Result.getAllocator(), 
          Result.getCodeCompletionTUInfo());
      if (!FirstParameter) {
        Opt.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
      }
      if ($less_uint(CurrentArg, NumParams)) {
        Opt.AddPlaceholderChunk($ELLIPSIS);
      } else {
        Opt.AddCurrentParameterChunk($ELLIPSIS);
      }
      
      Result.AddOptionalChunk(Opt.TakeString());
    } finally {
      if (Opt != null) { Opt.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddMacroResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3101,
 FQN="AddMacroResults", NM="_ZL15AddMacroResultsRN5clang12PreprocessorERN12_GLOBAL__N_113ResultBuilderEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL15AddMacroResultsRN5clang12PreprocessorERN12_GLOBAL__N_113ResultBuilderEbb")
//</editor-fold>
public static void AddMacroResults(final Preprocessor /*&*/ PP, final ResultBuilder /*&*/ Results, 
               boolean IncludeUndefined) {
  AddMacroResults(PP, Results, 
               IncludeUndefined, 
               false);
}
public static void AddMacroResults(final Preprocessor /*&*/ PP, final ResultBuilder /*&*/ Results, 
               boolean IncludeUndefined, 
               boolean TargetTypeIsPointer/*= false*/) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  
  Results.EnterNewScope();
  
  for (DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> M = PP.macro_begin(), 
      MEnd = PP.macro_end();
       M.$noteq(MEnd); M.$preInc()) {
    MacroDefinition MD = PP.getMacroDefinition(M.$arrow().first);
    if (IncludeUndefined || MD.$bool()) {
      {
        MacroInfo /*P*/ MI = MD.getMacroInfo();
        if ((MI != null)) {
          if (MI.isUsedForHeaderGuard()) {
            continue;
          }
        }
      }
      
      Results.AddResult(new CodeCompletionResult(M.$arrow().first, 
              getMacroUsagePriority(M.$arrow().first.getName(), 
                  PP.getLangOpts(), 
                  TargetTypeIsPointer)));
    }
  }
  
  Results.ExitScope();
}

//<editor-fold defaultstate="collapsed" desc="AddPrettyFunctionResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3128,
 FQN="AddPrettyFunctionResults", NM="_ZL24AddPrettyFunctionResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24AddPrettyFunctionResultsRKN5clang11LangOptionsERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddPrettyFunctionResults(final /*const*/ LangOptions /*&*/ LangOpts, 
                        final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  
  Results.EnterNewScope();
  
  Results.AddResult(new CodeCompletionResult($__PRETTY_FUNCTION__, CCP_Constant));
  Results.AddResult(new CodeCompletionResult($__FUNCTION__, CCP_Constant));
  if (LangOpts.C99 || LangOpts.CPlusPlus11) {
    Results.AddResult(new CodeCompletionResult($__func__, CCP_Constant));
  }
  Results.ExitScope();
}

//<editor-fold defaultstate="collapsed" desc="HandleCodeCompleteResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3141,
 FQN="HandleCodeCompleteResults", NM="_ZL25HandleCodeCompleteResultsPN5clang4SemaEPNS_20CodeCompleteConsumerENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL25HandleCodeCompleteResultsPN5clang4SemaEPNS_20CodeCompleteConsumerENS_21CodeCompletionContextEPNS_20CodeCompletionResultEj")
//</editor-fold>
public static void HandleCodeCompleteResults(Sema /*P*/ S, 
                         CodeCompleteConsumer /*P*/ CodeCompleter, 
                         CodeCompletionContext Context, 
                         type$ptr<CodeCompletionResult/*P*/> Results, 
                         /*uint*/int NumResults) {
  if ((CodeCompleter != null)) {
    CodeCompleter.ProcessCodeCompleteResults($Deref(S), new CodeCompletionContext(Context), Results, NumResults);
  }
}

//<editor-fold defaultstate="collapsed" desc="mapCodeCompletionContext">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3150,
 FQN="mapCodeCompletionContext", NM="_ZL24mapCodeCompletionContextRN5clang4SemaENS0_23ParserCompletionContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24mapCodeCompletionContextRN5clang4SemaENS0_23ParserCompletionContextE")
//</editor-fold>
public static  CodeCompletionContext.Kind mapCodeCompletionContext(final Sema /*&*/ S, 
                        Sema.ParserCompletionContext PCC) {
  switch (PCC) {
   case PCC_Namespace:
    return CodeCompletionContext.Kind.CCC_TopLevel;
   case PCC_Class:
    return CodeCompletionContext.Kind.CCC_ClassStructUnion;
   case PCC_ObjCInterface:
    return CodeCompletionContext.Kind.CCC_ObjCInterface;
   case PCC_ObjCImplementation:
    return CodeCompletionContext.Kind.CCC_ObjCImplementation;
   case PCC_ObjCInstanceVariableList:
    return CodeCompletionContext.Kind.CCC_ObjCIvarList;
   case PCC_Template:
   case PCC_MemberTemplate:
    if (S.CurContext.isFileContext()) {
      return CodeCompletionContext.Kind.CCC_TopLevel;
    }
    if (S.CurContext.isRecord()) {
      return CodeCompletionContext.Kind.CCC_ClassStructUnion;
    }
    return CodeCompletionContext.Kind.CCC_Other;
   case PCC_RecoveryInFunction:
    return CodeCompletionContext.Kind.CCC_Recovery;
   case PCC_ForInit:
    if (S.getLangOpts().CPlusPlus || S.getLangOpts().C99
       || S.getLangOpts().ObjC1) {
      return CodeCompletionContext.Kind.CCC_ParenthesizedExpression;
    } else {
      return CodeCompletionContext.Kind.CCC_Expression;
    }
   case PCC_Expression:
   case PCC_Condition:
    return CodeCompletionContext.Kind.CCC_Expression;
   case PCC_Statement:
    return CodeCompletionContext.Kind.CCC_Statement;
   case PCC_Type:
    return CodeCompletionContext.Kind.CCC_Type;
   case PCC_ParenthesizedExpression:
    return CodeCompletionContext.Kind.CCC_ParenthesizedExpression;
   case PCC_LocalDeclarationSpecifiers:
    return CodeCompletionContext.Kind.CCC_Type;
  }
  throw new llvm_unreachable("Invalid ParserCompletionContext!");
}


/// \brief If we're in a C++ virtual member function, add completion results
/// that invoke the functions we override, since it's common to invoke the 
/// overridden function as well as adding new functionality.
///
/// \param S The semantic analysis object for which we are generating results.
///
/// \param InContext This context in which the nested-name-specifier preceding
/// the code-completion point 
//<editor-fold defaultstate="collapsed" desc="MaybeAddOverrideCalls">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3214,
 FQN="MaybeAddOverrideCalls", NM="_ZL21MaybeAddOverrideCallsRN5clang4SemaEPNS_11DeclContextERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL21MaybeAddOverrideCallsRN5clang4SemaEPNS_11DeclContextERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void MaybeAddOverrideCalls(final Sema /*&*/ S, DeclContext /*P*/ InContext, 
                     final ResultBuilder /*&*/ Results) {
  // Look through blocks.
  DeclContext /*P*/ CurContext = S.CurContext;
  while (isa_BlockDecl(CurContext)) {
    CurContext = CurContext.getParent();
  }
  
  CXXMethodDecl /*P*/ Method = dyn_cast_CXXMethodDecl(CurContext);
  if (!(Method != null) || !Method.isVirtual()) {
    return;
  }
  
  // We need to have names for all of the parameters, if we're going to 
  // generate a forwarding call.
  for (ParmVarDecl /*P*/ P : Method.parameters())  {
    if (!P.getDeclName().$bool()) {
      return;
    }
  }
  
  PrintingPolicy Policy = getCompletionPrintingPolicy(S);
  for (type$ptr<CXXMethodDecl>/*method_iterator*/ M = $tryClone(Method.begin_overridden_methods()), 
      /*P*/ /*const*/ /*P*/ MEnd = $tryClone(Method.end_overridden_methods());
       $noteq_ptr(M, MEnd); M.$preInc()) {
    CodeCompletionBuilder Builder = null;
    try {
      Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
          Results.getCodeCompletionTUInfo());
      /*const*/ CXXMethodDecl /*P*/ Overridden = M.$star();
      if (Overridden.getCanonicalDecl$Const() == Method.getCanonicalDecl()) {
        continue;
      }
      
      // If we need a nested-name-specifier, add one now.
      if (!(InContext != null)) {
        NestedNameSpecifier /*P*/ NNS = getRequiredQualification(S.Context, CurContext, 
            Overridden.getDeclContext$Const());
        if ((NNS != null)) {
          raw_string_ostream OS = null;
          try {
            std.string Str/*J*/= new std.string();
            OS/*J*/= new raw_string_ostream(Str);
            NNS.print(OS, Policy);
            Builder.AddTextChunk(Results.getAllocator().CopyString(new Twine(OS.str())));
          } finally {
            if (OS != null) { OS.$destroy(); }
          }
        }
      } else if (!InContext.Equals(Overridden.getDeclContext$Const())) {
        continue;
      }
      
      Builder.AddTypedTextChunk(Results.getAllocator().CopyString(new Twine(Overridden.getNameAsString())));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      boolean FirstParam = true;
      for (ParmVarDecl /*P*/ P : Method.parameters()) {
        if (FirstParam) {
          FirstParam = false;
        } else {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
        }
        
        Builder.AddPlaceholderChunk(Results.getAllocator().CopyString(new Twine(P.getIdentifier().getName())));
      }
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
              CCP_SuperCompletion, 
              CXCursorKind.CXCursor_CXXMethod, 
              CXAvailabilityKind.CXAvailability_Available, 
              Overridden));
      Results.Ignore(Overridden);
    } finally {
      if (Builder != null) { Builder.$destroy(); }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="AddClassMessageCompletions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5585,
 FQN="AddClassMessageCompletions", NM="_ZL26AddClassMessageCompletionsRN5clang4SemaEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbbRN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL26AddClassMessageCompletionsRN5clang4SemaEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbbRN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddClassMessageCompletions(final Sema /*&*/ SemaRef, Scope /*P*/ S, 
                          OpaquePtr<QualType> Receiver, 
                          ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                          boolean AtArgumentExpression, 
                          boolean IsSuper, 
                          final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  ObjCInterfaceDecl /*P*/ CDecl = null;
  
  // If the given name refers to an interface type, retrieve the
  // corresponding declaration.
  if (Receiver.$bool()) {
    QualType T = SemaRef.GetTypeFromParser(new OpaquePtr<QualType>(Receiver), (type$ptr<TypeSourceInfo/*P*/>/*P*/ )null);
    if (!T.isNull()) {
      {
        /*const*/ ObjCObjectType /*P*/ Interface = T.$arrow().getAs(ObjCObjectType.class);
        if ((Interface != null)) {
          CDecl = Interface.getInterface();
        }
      }
    }
  }
  
  // Add all of the factory methods in this Objective-C class, its protocols,
  // superclasses, categories, implementation, etc.
  Results.EnterNewScope();
  
  // If this is a send-to-super, try to add the special "super" send 
  // completion.
  if (IsSuper) {
    {
      ObjCMethodDecl /*P*/ SuperMethod = AddSuperSendCompletion(SemaRef, false, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), Results);
      if ((SuperMethod != null)) {
        Results.Ignore(SuperMethod);
      }
    }
  }
  {
    
    // If we're inside an Objective-C method definition, prefer its selector to
    // others.
    ObjCMethodDecl /*P*/ CurMethod = SemaRef.getCurMethodDecl();
    if ((CurMethod != null)) {
      Results.setPreferredSelector(CurMethod.getSelector());
    }
  }
  
  SmallPtrSet<Selector> Selectors/*J*/= new SmallPtrSet<Selector>(DenseMapInfo$LikePtr.$Info(), 16);
  if ((CDecl != null)) {
    AddObjCMethods(CDecl, false, ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
        SemaRef.CurContext, Selectors, AtArgumentExpression, 
        Results);
  } else {
    // We're messaging "id" as a type; provide all class/factory methods.
    
    // If we have an external source, load the entire class method
    // pool from the AST file.
    if ((SemaRef.getExternalSource() != null)) {
      for (/*uint32_t*/int I = 0, 
          N = SemaRef.getExternalSource().GetNumExternalSelectors();
           I != N; ++I) {
        Selector Sel = SemaRef.getExternalSource().GetExternalSelector(I);
        if (Sel.isNull() || (SemaRef.MethodPool.count(Sel) != 0)) {
          continue;
        }
        
        SemaRef.ReadMethodPool(new Selector(Sel));
      }
    }
    
    for (DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> M = SemaRef.MethodPool.begin(), 
        MEnd = SemaRef.MethodPool.end();
         M.$noteq(/*NO_ITER_COPY*/MEnd); M.$preInc()) {
      for (ObjCMethodList /*P*/ MethList = $AddrOf(M.$arrow().second.second);
           (MethList != null) && (MethList.getMethod() != null);
           MethList = MethList.getNext()) {
        if (!isAcceptableObjCMethod(MethList.getMethod(), ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents))) {
          continue;
        }
        
        CodeCompletionResult R/*J*/= new CodeCompletionResult(MethList.getMethod(), 
            Results.getBasePriority(MethList.getMethod()), (NestedNameSpecifier /*P*/ )null);
        R.StartParameter = SelIdents.size();
        R.AllParametersAreInformative = false;
        Results.MaybeAddResult(new CodeCompletionResult(R), SemaRef.CurContext);
      }
    }
  }
  
  Results.ExitScope();
}


/// \brief Retrieve the container definition, if any?
//<editor-fold defaultstate="collapsed" desc="getContainerDef">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3559,
 FQN="getContainerDef", NM="_ZL15getContainerDefPN5clang17ObjCContainerDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL15getContainerDefPN5clang17ObjCContainerDeclE")
//</editor-fold>
public static ObjCContainerDecl /*P*/ getContainerDef(ObjCContainerDecl /*P*/ Container) {
  {
    ObjCInterfaceDecl /*P*/ Interface = dyn_cast_ObjCInterfaceDecl(Container);
    if ((Interface != null)) {
      if (Interface.hasDefinition()) {
        return Interface.getDefinition();
      }
      
      return Interface;
    }
  }
  {
    
    ObjCProtocolDecl /*P*/ Protocol = dyn_cast_ObjCProtocolDecl(Container);
    if ((Protocol != null)) {
      if (Protocol.hasDefinition()) {
        return Protocol.getDefinition();
      }
      
      return Protocol;
    }
  }
  return Container;
}

//<editor-fold defaultstate="collapsed" desc="AddObjCProperties">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3576,
 FQN="AddObjCProperties", NM="_ZL17AddObjCPropertiesRKN5clang21CodeCompletionContextEPNS_17ObjCContainerDeclEbbPNS_11DeclContextERN4llvm11SmallPtrSetIPNS_14IdentifierInfoELj16EEERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL17AddObjCPropertiesRKN5clang21CodeCompletionContextEPNS_17ObjCContainerDeclEbbPNS_11DeclContextERN4llvm11SmallPtrSetIPNS_14IdentifierInfoELj16EEERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddObjCProperties(final /*const*/ CodeCompletionContext /*&*/ CCContext, 
                 ObjCContainerDecl /*P*/ Container, 
                 boolean AllowCategories, 
                 boolean AllowNullaryMethods, 
                 DeclContext /*P*/ CurContext, 
                 final SmallPtrSet<IdentifierInfo /*P*/ > /*&*/ AddedProperties, 
                 final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  
  // Retrieve the definition.
  Container = getContainerDef(Container);
  
  // Add properties in this container.
  for (/*const*/ ObjCPropertyDecl /*P*/ P : Container.instance_properties())  {
    if (AddedProperties.insert(P.getIdentifier()).second) {
      Results.MaybeAddResult(new CodeCompletionResult(P, Results.getBasePriority(P), (NestedNameSpecifier /*P*/ )null), 
          CurContext);
    }
  }
  
  // Add nullary methods
  if (AllowNullaryMethods) {
    final ASTContext /*&*/ Context = Container.getASTContext();
    PrintingPolicy Policy = getCompletionPrintingPolicy(Results.getSema());
    for (ObjCMethodDecl /*P*/ M : Container.methods()) {
      if (M.getSelector().isUnarySelector()) {
        {
          IdentifierInfo /*P*/ Name = M.getSelector().getIdentifierInfoForSlot(0);
          if ((Name != null)) {
            if (AddedProperties.insert(Name).second) {
              CodeCompletionBuilder Builder = null;
              try {
                Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
                    Results.getCodeCompletionTUInfo());
                AddResultTypeChunk(Context, Policy, M, CCContext.getBaseType(), 
                    Builder);
                Builder.AddTypedTextChunk(Results.getAllocator().CopyString(new Twine(Name.getName())));
                
                Results.MaybeAddResult(new CodeCompletionResult(Builder.TakeString(), M, 
                        CCP_MemberDeclaration + CCD_MethodAsProperty), 
                    CurContext);
              } finally {
                if (Builder != null) { Builder.$destroy(); }
              }
            }
          }
        }
      }
    }
  }
  {
    
    // Add properties in referenced protocols.
    ObjCProtocolDecl /*P*/ Protocol = dyn_cast_ObjCProtocolDecl(Container);
    if ((Protocol != null)) {
      for (ObjCProtocolDecl /*P*/ P : Protocol.protocols())  {
        AddObjCProperties(CCContext, P, AllowCategories, AllowNullaryMethods, 
            CurContext, AddedProperties, Results);
      }
    } else {
      ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(Container);
      if ((IFace != null)) {
        if (AllowCategories) {
          // Look through categories.
          for (ObjCCategoryDecl /*P*/ Cat : IFace.known_categories())  {
            AddObjCProperties(CCContext, Cat, AllowCategories, AllowNullaryMethods, 
                CurContext, AddedProperties, Results);
          }
        }
        
        // Look through protocols.
        for (ObjCProtocolDecl /*P*/ I : IFace.all_referenced_protocols())  {
          AddObjCProperties(CCContext, I, AllowCategories, AllowNullaryMethods, 
              CurContext, AddedProperties, Results);
        }
        
        // Look in the superclass.
        if ((IFace.getSuperClass() != null)) {
          AddObjCProperties(CCContext, IFace.getSuperClass(), AllowCategories, 
              AllowNullaryMethods, CurContext, 
              AddedProperties, Results);
        }
      } else {
        /*const*/ ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(Container);
        if ((Category != null)) {
          // Look through protocols.
          for (ObjCProtocolDecl /*P*/ P : Category.protocols())  {
            AddObjCProperties(CCContext, P, AllowCategories, AllowNullaryMethods, 
                CurContext, AddedProperties, Results);
          }
        }
      }
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="anyNullArguments">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3936,
 FQN="anyNullArguments", NM="_ZL16anyNullArgumentsN4llvm8ArrayRefIPN5clang4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL16anyNullArgumentsN4llvm8ArrayRefIPN5clang4ExprEEE")
//</editor-fold>
public static boolean anyNullArguments(ArrayRef<Expr /*P*/ > Args) {
  if ((Args.size() != 0) && !(Args.data() != null)) {
    return true;
  }
  
  for (/*uint*/int I = 0; I != Args.size(); ++I)  {
    if (!(Args.$at(I) != null)) {
      return true;
    }
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="mergeCandidatesWithResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3949,
 FQN="mergeCandidatesWithResults", NM="_ZL26mergeCandidatesWithResultsRN5clang4SemaERN4llvm15SmallVectorImplINS_20CodeCompleteConsumer17OverloadCandidateEEERNS_20OverloadCandidateSetENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL26mergeCandidatesWithResultsRN5clang4SemaERN4llvm15SmallVectorImplINS_20CodeCompleteConsumer17OverloadCandidateEEERNS_20OverloadCandidateSetENS_14SourceLocationE")
//</editor-fold>
public static void mergeCandidatesWithResults(final Sema /*&*/ SemaRef, 
                          final SmallVectorImpl<CodeCompleteConsumer.OverloadCandidate> /*&*/ Results, 
                          final OverloadCandidateSet /*&*/ CandidateSet, 
                          SourceLocation Loc) {
  if (!CandidateSet.empty()) {
    // Sort the overload candidate set by placing the best overloads first.
    std.stable_sort(CandidateSet.begin(), CandidateSet.end(), 
         (X, Y) -> 
          {
            return isBetterOverloadCandidate(SemaRef, X, Y, new SourceLocation(Loc));
          }
);
    
    // Add the remaining viable overload candidates as code-completion results.
    for (final OverloadCandidate /*&*/ Candidate : CandidateSet)  {
      if (Candidate.Viable) {
        Results.push_back(new CodeCompleteConsumer.OverloadCandidate(Candidate.Function));
      }
    }
  }
}


/// \brief Get the type of the Nth parameter from a given set of overload
/// candidates.
//<editor-fold defaultstate="collapsed" desc="getParamType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3970,
 FQN="getParamType", NM="_ZL12getParamTypeRN5clang4SemaEN4llvm8ArrayRefINS_20CodeCompleteConsumer17OverloadCandidateEEEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL12getParamTypeRN5clang4SemaEN4llvm8ArrayRefINS_20CodeCompleteConsumer17OverloadCandidateEEEj")
//</editor-fold>
public static QualType getParamType(final Sema /*&*/ SemaRef, 
            ArrayRef<CodeCompleteConsumer.OverloadCandidate> Candidates, 
            /*uint*/int N) {
  
  // Given the overloads 'Candidates' for a function call matching all arguments
  // up to N, return the type of the Nth parameter if it is the same for all
  // overload candidates.
  QualType ParamType/*J*/= new QualType();
  for (final /*const*/ CodeCompleteConsumer.OverloadCandidate /*&*/ Candidate : Candidates) {
    {
      /*const*/ FunctionType /*P*/ FType = Candidate.getFunctionType();
      if ((FType != null)) {
        {
          /*const*/ FunctionProtoType /*P*/ Proto = dyn_cast_FunctionProtoType(FType);
          if ((Proto != null)) {
            if ($less_uint(N, Proto.getNumParams())) {
              if (ParamType.isNull()) {
                ParamType.$assignMove(Proto.getParamType(N));
              } else if (!SemaRef.Context.hasSameUnqualifiedType(ParamType.getNonReferenceType(), 
                  Proto.getParamType(N).getNonReferenceType())) {
                // Otherwise return a default-constructed QualType.
                return new QualType();
              }
            }
          }
        }
      }
    }
  }
  
  return ParamType;
}

//<editor-fold defaultstate="collapsed" desc="CodeCompleteOverloadResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3995,
 FQN="CodeCompleteOverloadResults", NM="_ZL27CodeCompleteOverloadResultsRN5clang4SemaEPNS_5ScopeEN4llvm15MutableArrayRefINS_20CodeCompleteConsumer17OverloadCandidateEEEjb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL27CodeCompleteOverloadResultsRN5clang4SemaEPNS_5ScopeEN4llvm15MutableArrayRefINS_20CodeCompleteConsumer17OverloadCandidateEEEjb")
//</editor-fold>
public static void CodeCompleteOverloadResults(final Sema /*&*/ SemaRef, Scope /*P*/ S, 
                           MutableArrayRef<CodeCompleteConsumer.OverloadCandidate> Candidates, 
                           /*uint*/int CurrentArg) {
  CodeCompleteOverloadResults(SemaRef, S, 
                           Candidates, 
                           CurrentArg, 
                           true);
}
public static void CodeCompleteOverloadResults(final Sema /*&*/ SemaRef, Scope /*P*/ S, 
                           MutableArrayRef<CodeCompleteConsumer.OverloadCandidate> Candidates, 
                           /*uint*/int CurrentArg, 
                           boolean CompleteExpressionWithCurrentArg/*= true*/) {
  QualType ParamType/*J*/= new QualType();
  if (CompleteExpressionWithCurrentArg) {
    ParamType.$assignMove(getParamType(SemaRef, new ArrayRef<CodeCompleteConsumer.OverloadCandidate>(Candidates), CurrentArg));
  }
  if (ParamType.isNull()) {
    SemaRef.CodeCompleteOrdinaryName(S, Sema.ParserCompletionContext.PCC_Expression);
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      SemaRef.CodeCompleteExpression(S, $c$.track(new Sema.CodeCompleteExpressionData(new QualType(ParamType)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
  if (!Candidates.empty()) {
    SemaRef.CodeCompleter.ProcessOverloadCandidates(SemaRef, CurrentArg, 
        Candidates.data(), 
        Candidates.size());
  }
}


/// \brief Determine whether this scope denotes a namespace.
//<editor-fold defaultstate="collapsed" desc="isNamespaceScope">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4546,
 FQN="isNamespaceScope", NM="_ZL16isNamespaceScopePN5clang5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL16isNamespaceScopePN5clang5ScopeE")
//</editor-fold>
public static boolean isNamespaceScope(Scope /*P*/ S) {
  DeclContext /*P*/ DC = S.getEntity();
  if (!(DC != null)) {
    return false;
  }
  
  return DC.isFileContext();
}


/// \brief Determine whether the addition of the given flag to an Objective-C
/// property's attributes will cause a conflict.
//<editor-fold defaultstate="collapsed" desc="ObjCPropertyFlagConflicts">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4874,
 FQN="ObjCPropertyFlagConflicts", NM="_ZL25ObjCPropertyFlagConflictsjj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL25ObjCPropertyFlagConflictsjj")
//</editor-fold>
public static boolean ObjCPropertyFlagConflicts(/*uint*/int Attributes, /*uint*/int NewFlag) {
  // Check if we've already added this flag.
  if (((Attributes & NewFlag) != 0)) {
    return true;
  }
  
  Attributes |= NewFlag;
  
  // Check for collisions with "readonly".
  if (((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly) != 0)
     && ((Attributes & ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite) != 0)) {
    return true;
  }
  
  // Check for more than one of { assign, copy, retain, strong, weak }.
  /*uint*/int AssignCopyRetMask = Attributes & (ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong
     | ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak);
  if ((AssignCopyRetMask != 0)
     && AssignCopyRetMask != ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign
     && AssignCopyRetMask != ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained
     && AssignCopyRetMask != ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy
     && AssignCopyRetMask != ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain
     && AssignCopyRetMask != ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong
     && AssignCopyRetMask != ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak) {
    return true;
  }
  
  return false;
}

//<editor-fold defaultstate="collapsed" desc="isAcceptableObjCSelector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4976,
 FQN="isAcceptableObjCSelector", NM="_ZL24isAcceptableObjCSelectorN5clang8SelectorE14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24isAcceptableObjCSelectorN5clang8SelectorE14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb")
//</editor-fold>
public static boolean isAcceptableObjCSelector(Selector Sel, 
                        ObjCMethodKind WantKind, 
                        ArrayRef<IdentifierInfo /*P*/ > SelIdents) {
  return isAcceptableObjCSelector(Sel, 
                        WantKind, 
                        SelIdents, 
                        true);
}
public static boolean isAcceptableObjCSelector(Selector Sel, 
                        ObjCMethodKind WantKind, 
                        ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                        boolean AllowSameLength/*= true*/) {
  /*uint*/int NumSelIdents = SelIdents.size();
  if ($greater_uint(NumSelIdents, Sel.getNumArgs())) {
    return false;
  }
  switch (WantKind) {
   case MK_Any:
    break;
   case MK_ZeroArgSelector:
    return Sel.isUnarySelector();
   case MK_OneArgSelector:
    return Sel.getNumArgs() == 1;
  }
  if (!AllowSameLength && (NumSelIdents != 0) && NumSelIdents == Sel.getNumArgs()) {
    return false;
  }
  
  for (/*uint*/int I = 0; I != NumSelIdents; ++I)  {
    if (SelIdents.$at(I) != Sel.getIdentifierInfoForSlot(I)) {
      return false;
    }
  }
  
  return true;
}

//<editor-fold defaultstate="collapsed" desc="isAcceptableObjCMethod">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5000,
 FQN="isAcceptableObjCMethod", NM="_ZL22isAcceptableObjCMethodPN5clang14ObjCMethodDeclE14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL22isAcceptableObjCMethodPN5clang14ObjCMethodDeclE14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb")
//</editor-fold>
public static boolean isAcceptableObjCMethod(ObjCMethodDecl /*P*/ Method, 
                      ObjCMethodKind WantKind, 
                      ArrayRef<IdentifierInfo /*P*/ > SelIdents) {
  return isAcceptableObjCMethod(Method, 
                      WantKind, 
                      SelIdents, 
                      true);
}
public static boolean isAcceptableObjCMethod(ObjCMethodDecl /*P*/ Method, 
                      ObjCMethodKind WantKind, 
                      ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                      boolean AllowSameLength/*= true*/) {
  return isAcceptableObjCSelector(Method.getSelector(), WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
      AllowSameLength);
}


/// \brief Add all of the Objective-C methods in the given Objective-C 
/// container to the set of results.
///
/// The container will be a class, protocol, category, or implementation of 
/// any of the above. This mether will recurse to include methods from 
/// the superclasses of classes along with their categories, protocols, and
/// implementations.
///
/// \param Container the container in which we'll look to find methods.
///
/// \param WantInstanceMethods Whether to add instance methods (only); if
/// false, this routine will add factory methods (only).
///
/// \param CurContext the context in which we're performing the lookup that
/// finds methods.
///
/// \param AllowSameLength Whether we allow a method to be added to the list
/// when it has the same number of parameters as we have selector identifiers.
///
/// \param Results the structure into which we'll add results.
//<editor-fold defaultstate="collapsed" desc="AddObjCMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5034,
 FQN="AddObjCMethods", NM="_ZL14AddObjCMethodsPN5clang17ObjCContainerDeclEb14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEPNS_11DeclContextERNS3_11SmallPtrSetINS_8SelectorELj16EEEbRN12_GLOBAL__N_113ResultBuilderEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL14AddObjCMethodsPN5clang17ObjCContainerDeclEb14ObjCMethodKindN4llvm8ArrayRefIPNS_14IdentifierInfoEEEPNS_11DeclContextERNS3_11SmallPtrSetINS_8SelectorELj16EEEbRN12_GLOBAL__N_113ResultBuilderEb")
//</editor-fold>
public static void AddObjCMethods(ObjCContainerDecl /*P*/ Container, 
              boolean WantInstanceMethods, 
              ObjCMethodKind WantKind, 
              ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
              DeclContext /*P*/ CurContext, 
              final SmallPtrSet<Selector> /*&*/ Selectors, 
              boolean AllowSameLength, 
              final ResultBuilder /*&*/ Results) {
  AddObjCMethods(Container, 
              WantInstanceMethods, 
              WantKind, 
              SelIdents, 
              CurContext, 
              Selectors, 
              AllowSameLength, 
              Results, 
              true);
}
public static void AddObjCMethods(ObjCContainerDecl /*P*/ Container, 
              boolean WantInstanceMethods, 
              ObjCMethodKind WantKind, 
              ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
              DeclContext /*P*/ CurContext, 
              final SmallPtrSet<Selector> /*&*/ Selectors, 
              boolean AllowSameLength, 
              final ResultBuilder /*&*/ Results, 
              boolean InOriginalClass/*= true*/) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  Container = getContainerDef(Container);
  ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(Container);
  boolean isRootClass = (IFace != null) && !(IFace.getSuperClass() != null);
  for (ObjCMethodDecl /*P*/ M : Container.methods()) {
    // The instance methods on the root class can be messaged via the
    // metaclass.
    if (M.isInstanceMethod() == WantInstanceMethods
       || (isRootClass && !WantInstanceMethods)) {
      // Check whether the selector identifiers we've been given are a 
      // subset of the identifiers for this particular method.
      if (!isAcceptableObjCMethod(M, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), AllowSameLength)) {
        continue;
      }
      if (!Selectors.insert(M.getSelector()).second) {
        continue;
      }
      
      CodeCompletionResult R = new CodeCompletionResult(M, Results.getBasePriority(M), (NestedNameSpecifier /*P*/ )null);
      R.StartParameter = SelIdents.size();
      R.AllParametersAreInformative = (WantKind != ObjCMethodKind.MK_Any);
      if (!InOriginalClass) {
        R.Priority += CCD_InBaseClass;
      }
      Results.MaybeAddResult(new CodeCompletionResult(R), CurContext);
    }
  }
  {
    
    // Visit the protocols of protocols.
    ObjCProtocolDecl /*P*/ Protocol = dyn_cast_ObjCProtocolDecl(Container);
    if ((Protocol != null)) {
      if (Protocol.hasDefinition()) {
        final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = Protocol.getReferencedProtocols();
        for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
            /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end());
             $noteq_ptr(I, E); I.$preInc())  {
          AddObjCMethods(I.$star(), WantInstanceMethods, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
              CurContext, Selectors, AllowSameLength, Results, false);
        }
      }
    }
  }
  if (!(IFace != null) || !IFace.hasDefinition()) {
    return;
  }
  
  // Add methods in protocols.
  for (ObjCProtocolDecl /*P*/ I : IFace.protocols())  {
    AddObjCMethods(I, WantInstanceMethods, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
        CurContext, Selectors, AllowSameLength, Results, false);
  }
  
  // Add methods in categories.
  for (ObjCCategoryDecl /*P*/ CatDecl : IFace.known_categories()) {
    AddObjCMethods(CatDecl, WantInstanceMethods, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
        CurContext, Selectors, AllowSameLength, 
        Results, InOriginalClass);
    
    // Add a categories protocol methods.
    final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = CatDecl.getReferencedProtocols();
    for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
        /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end());
         $noteq_ptr(I, E); I.$preInc())  {
      AddObjCMethods(I.$star(), WantInstanceMethods, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
          CurContext, Selectors, AllowSameLength, 
          Results, false);
    }
    {
      
      // Add methods in category implementations.
      ObjCCategoryImplDecl /*P*/ Impl = CatDecl.getImplementation();
      if ((Impl != null)) {
        AddObjCMethods(Impl, WantInstanceMethods, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
            CurContext, Selectors, AllowSameLength, 
            Results, InOriginalClass);
      }
    }
  }
  
  // Add methods in superclass.
  if ((IFace.getSuperClass() != null)) {
    AddObjCMethods(IFace.getSuperClass(), WantInstanceMethods, WantKind, 
        new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), CurContext, Selectors, 
        AllowSameLength, Results, false);
  }
  {
    
    // Add methods in our implementation, if any.
    ObjCImplementationDecl /*P*/ Impl = IFace.getImplementation();
    if ((Impl != null)) {
      AddObjCMethods(Impl, WantInstanceMethods, WantKind, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
          CurContext, Selectors, AllowSameLength, 
          Results, InOriginalClass);
    }
  }
}


/// \brief When we have an expression with type "id", we may assume
/// that it has some more-specific class type based on knowledge of
/// common uses of Objective-C. This routine returns that class type,
/// or NULL if no better result could be determined.
//<editor-fold defaultstate="collapsed" desc="GetAssumedMessageSendExprType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5264,
 FQN="GetAssumedMessageSendExprType", NM="_ZL29GetAssumedMessageSendExprTypePN5clang4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL29GetAssumedMessageSendExprTypePN5clang4ExprE")
//</editor-fold>
public static ObjCInterfaceDecl /*P*/ GetAssumedMessageSendExprType(Expr /*P*/ E) {
  ObjCMessageExpr /*P*/ Msg = dyn_cast_or_null_ObjCMessageExpr(E);
  if (!(Msg != null)) {
    return null;
  }
  
  Selector Sel = Msg.getSelector();
  if (Sel.isNull()) {
    return null;
  }
  
  IdentifierInfo /*P*/ Id = Sel.getIdentifierInfoForSlot(0);
  if (!(Id != null)) {
    return null;
  }
  
  ObjCMethodDecl /*P*/ Method = Msg.getMethodDecl();
  if (!(Method != null)) {
    return null;
  }
  
  // Determine the class that we're sending the message to.
  ObjCInterfaceDecl /*P*/ IFace = null;
  switch (Msg.getReceiverKind()) {
   case Class:
    {
      /*const*/ ObjCObjectType /*P*/ ObjType = Msg.getClassReceiver().$arrow().getAs(ObjCObjectType.class);
      if ((ObjType != null)) {
        IFace = ObjType.getInterface();
      }
    }
    break;
   case Instance:
    {
      QualType T = Msg.getInstanceReceiver().getType();
      {
        /*const*/ ObjCObjectPointerType /*P*/ Ptr = T.$arrow().getAs(ObjCObjectPointerType.class);
        if ((Ptr != null)) {
          IFace = Ptr.getInterfaceDecl();
        }
      }
      break;
    }
   case SuperInstance:
   case SuperClass:
    break;
  }
  if (!(IFace != null)) {
    return null;
  }
  
  ObjCInterfaceDecl /*P*/ Super = IFace.getSuperClass();
  if (Method.isInstanceMethod()) {
    return new StringSwitch<ObjCInterfaceDecl /*P*/ >(Id.getName()).
        Case(/*KEEP_STR*/"retain", IFace).
        Case(/*KEEP_STR*/"strong", IFace).
        Case(/*KEEP_STR*/"autorelease", IFace).
        Case(/*KEEP_STR*/"copy", IFace).
        Case(/*KEEP_STR*/"copyWithZone", IFace).
        Case(/*KEEP_STR*/"mutableCopy", IFace).
        Case(/*KEEP_STR*/"mutableCopyWithZone", IFace).
        Case(/*KEEP_STR*/"awakeFromCoder", IFace).
        Case(/*KEEP_STR*/"replacementObjectFromCoder", IFace).
        Case(/*KEEP_STR*/"class", IFace).
        Case(/*KEEP_STR*/"classForCoder", IFace).
        Case(/*KEEP_STR*/"superclass", Super).
        Default((ObjCInterfaceDecl /*P*/ /*const*/)null);
  }
  
  return new StringSwitch<ObjCInterfaceDecl /*P*/ >(Id.getName()).
      Case(/*KEEP_STR*/"new", IFace).
      Case(/*KEEP_STR*/"alloc", IFace).
      Case(/*KEEP_STR*/"allocWithZone", IFace).
      Case(/*KEEP_STR*/"class", IFace).
      Case(/*KEEP_STR*/"superclass", Super).
      Default((ObjCInterfaceDecl /*P*/ /*const*/)null);
}


// Add a special completion for a message send to "super", which fills in the
// most likely case of forwarding all of our arguments to the superclass 
// function.
///
/// \param S The semantic analysis object.
///
/// \param NeedSuperKeyword Whether we need to prefix this completion with
/// the "super" keyword. Otherwise, we just need to provide the arguments.
///
/// \param SelIdents The identifiers in the selector that have already been
/// provided as arguments for a send to "super".
///
/// \param Results The set of results to augment.
///
/// \returns the Objective-C method declaration that would be invoked by 
/// this "super" completion. If NULL, no completion was added.
//<editor-fold defaultstate="collapsed" desc="AddSuperSendCompletion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5347,
 FQN="AddSuperSendCompletion", NM="_ZL22AddSuperSendCompletionRN5clang4SemaEbN4llvm8ArrayRefIPNS_14IdentifierInfoEEERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL22AddSuperSendCompletionRN5clang4SemaEbN4llvm8ArrayRefIPNS_14IdentifierInfoEEERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static ObjCMethodDecl /*P*/ AddSuperSendCompletion(final Sema /*&*/ S, boolean NeedSuperKeyword, 
                      ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                      final ResultBuilder /*&*/ Results) {
  CodeCompletionBuilder Builder = null;
  try {
    ObjCMethodDecl /*P*/ CurMethod = S.getCurMethodDecl();
    if (!(CurMethod != null)) {
      return null;
    }
    
    ObjCInterfaceDecl /*P*/ Class = CurMethod.getClassInterface();
    if (!(Class != null)) {
      return null;
    }
    
    // Try to find a superclass method with the same selector.
    ObjCMethodDecl /*P*/ SuperMethod = null;
    while (((Class = Class.getSuperClass()) != null) && !(SuperMethod != null)) {
      // Check in the class
      SuperMethod = Class.getMethod(CurMethod.getSelector(), 
          CurMethod.isInstanceMethod());
      
      // Check in categories or class extensions.
      if (!(SuperMethod != null)) {
        for (/*const*/ ObjCCategoryDecl /*P*/ Cat : Class.known_categories()) {
          if (((SuperMethod = Cat.getMethod(CurMethod.getSelector(), 
              CurMethod.isInstanceMethod())) != null)) {
            break;
          }
        }
      }
    }
    if (!(SuperMethod != null)) {
      return null;
    }
    
    // Check whether the superclass method has the same signature.
    if (CurMethod.param_size() != SuperMethod.param_size()
       || CurMethod.isVariadic() != SuperMethod.isVariadic()) {
      return null;
    }
    
    for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/ > CurP = $tryClone(CurMethod.param_begin()), 
        /*P*/ /*const*/ /*P*/ CurPEnd = $tryClone(CurMethod.param_end()), 
        /*P*/ /*const*/ /*P*/ SuperP = $tryClone(SuperMethod.param_begin());
         $noteq_ptr(CurP, CurPEnd); CurP.$preInc() , SuperP.$preInc()) {
      // Make sure the parameter types are compatible.
      if (!S.Context.hasSameUnqualifiedType((CurP.$star()).getType(), 
          (SuperP.$star()).getType())) {
        return null;
      }
      
      // Make sure we have a parameter name to forward!
      if (!((CurP.$star()).getIdentifier() != null)) {
        return null;
      }
    }
    
    // We have a superclass method. Now, form the send-to-super completion.
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    
    // Give this completion a return type.
    AddResultTypeChunk(S.Context, getCompletionPrintingPolicy(S), SuperMethod, 
        Results.getCompletionContext().getBaseType(), 
        Builder);
    
    // If we need the "super" keyword, add it (plus some spacing).
    if (NeedSuperKeyword) {
      Builder.AddTypedTextChunk($("super"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    }
    
    Selector Sel = CurMethod.getSelector();
    if (Sel.isUnarySelector()) {
      if (NeedSuperKeyword) {
        Builder.AddTextChunk(Builder.getAllocator().CopyString(new Twine(Sel.getNameForSlot(0))));
      } else {
        Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Sel.getNameForSlot(0))));
      }
    } else {
      type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/ > CurP = $tryClone(CurMethod.param_begin());
      for (/*uint*/int I = 0, N = Sel.getNumArgs(); I != N; ++I , CurP.$preInc()) {
        if ($greater_uint(I, SelIdents.size())) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        }
        if ($less_uint(I, SelIdents.size())) {
          Builder.AddInformativeChunk(Builder.getAllocator().CopyString($add_StringRef$C_char$ptr$C(Sel.getNameForSlot(I), /*KEEP_STR*/$COLON)));
        } else if (NeedSuperKeyword || $greater_uint(I, SelIdents.size())) {
          Builder.AddTextChunk(Builder.getAllocator().CopyString($add_StringRef$C_char$ptr$C(Sel.getNameForSlot(I), /*KEEP_STR*/$COLON)));
          Builder.AddPlaceholderChunk(Builder.getAllocator().CopyString(new Twine((CurP.$star()).getIdentifier().getName())));
        } else {
          Builder.AddTypedTextChunk(Builder.getAllocator().CopyString($add_StringRef$C_char$ptr$C(Sel.getNameForSlot(I), /*KEEP_STR*/$COLON)));
          Builder.AddPlaceholderChunk(Builder.getAllocator().CopyString(new Twine((CurP.$star()).getIdentifier().getName())));
        }
      }
    }
    
    Results.AddResult(new CodeCompletionResult(Builder.TakeString(), SuperMethod, 
            CCP_SuperCompletion));
    return SuperMethod;
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}


/// \brief Given a set of code-completion results for the argument of a message
/// send, determine the preferred type (if any) for that argument expression.
//<editor-fold defaultstate="collapsed" desc="getPreferredArgumentTypeForMessageSend">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5553,
 FQN="getPreferredArgumentTypeForMessageSend", NM="_ZL38getPreferredArgumentTypeForMessageSendRN12_GLOBAL__N_113ResultBuilderEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL38getPreferredArgumentTypeForMessageSendRN12_GLOBAL__N_113ResultBuilderEj")
//</editor-fold>
public static QualType getPreferredArgumentTypeForMessageSend(final ResultBuilder /*&*/ Results, 
                                      /*uint*/int NumSelIdents) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  final ASTContext /*&*/ Context = Results.getSema().Context;
  
  QualType PreferredType/*J*/= new QualType();
  /*uint*/int BestPriority = CCP_Unlikely * 2;
  type$ptr<CodeCompletionResult/*P*/> ResultsData = $tryClone(Results.data());
  for (/*uint*/int I = 0, N = Results.size(); I != N; ++I) {
    final CodeCompletionResult /*&*/ R = ResultsData.$at(I);
    if (R.Kind == CodeCompletionResult.ResultKind.RK_Declaration
       && isa_ObjCMethodDecl(R.Declaration)) {
      if ($lesseq_uint(R.Priority, BestPriority)) {
        /*const*/ ObjCMethodDecl /*P*/ Method = cast_ObjCMethodDecl(R.Declaration);
        if ($lesseq_uint(NumSelIdents, Method.param_size())) {
          QualType MyPreferredType = Method.parameters().$at(NumSelIdents - 1).
              getType();
          if ($less_uint(R.Priority, BestPriority) || PreferredType.isNull()) {
            BestPriority = R.Priority;
            PreferredType.$assign(MyPreferredType);
          } else if (!Context.hasSameUnqualifiedType(new QualType(PreferredType), 
              new QualType(MyPreferredType))) {
            PreferredType.$assignMove(new QualType());
          }
        }
      }
    }
  }
  
  return PreferredType;
}


/// \brief Add all of the protocol declarations that we find in the given
/// (translation unit) context.
//<editor-fold defaultstate="collapsed" desc="AddProtocolResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5935,
 FQN="AddProtocolResults", NM="_ZL18AddProtocolResultsPN5clang11DeclContextES1_bRN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL18AddProtocolResultsPN5clang11DeclContextES1_bRN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddProtocolResults(DeclContext /*P*/ Ctx, DeclContext /*P*/ CurContext, 
                  boolean OnlyForwardDeclarations, 
                  final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  
  for (/*const*/ Decl /*P*/ D : Ctx.decls()) {
    {
      // Record any protocols we find.
      /*const*/ ObjCProtocolDecl /*P*/ Proto = dyn_cast_ObjCProtocolDecl(D);
      if ((Proto != null)) {
        if (!OnlyForwardDeclarations || !Proto.hasDefinition()) {
          Results.AddResult(new CodeCompletionResult(Proto, Results.getBasePriority(Proto), (NestedNameSpecifier /*P*/ )null), 
              CurContext, (NamedDecl /*P*/ )null, false);
        }
      }
    }
  }
}


/// \brief Add all of the Objective-C interface declarations that we find in
/// the given (translation unit) context.
//<editor-fold defaultstate="collapsed" desc="AddInterfaceResults">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6000,
 FQN="AddInterfaceResults", NM="_ZL19AddInterfaceResultsPN5clang11DeclContextES1_bbRN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL19AddInterfaceResultsPN5clang11DeclContextES1_bbRN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddInterfaceResults(DeclContext /*P*/ Ctx, DeclContext /*P*/ CurContext, 
                   boolean OnlyForwardDeclarations, 
                   boolean OnlyUnimplemented, 
                   final ResultBuilder /*&*/ Results) {
  /*typedef CodeCompletionResult Result*/
//  final class Result extends CodeCompletionResult{ };
  
  for (/*const*/ Decl /*P*/ D : Ctx.decls()) {
    {
      // Record any interfaces we find.
      /*const*/ ObjCInterfaceDecl /*P*/ Class = dyn_cast_ObjCInterfaceDecl(D);
      if ((Class != null)) {
        if ((!OnlyForwardDeclarations || !Class.hasDefinition())
           && (!OnlyUnimplemented || !(Class.getImplementation() != null))) {
          Results.AddResult(new CodeCompletionResult(Class, Results.getBasePriority(Class), (NestedNameSpecifier /*P*/ )null), 
              CurContext, (NamedDecl /*P*/ )null, false);
        }
      }
    }
  }
}


/// \brief Find all of the methods that reside in the given container
/// (and its superclasses, protocols, etc.) that meet the given
/// criteria. Insert those methods into the map of known methods,
/// indexed by selector so they can be easily found.
//<editor-fold defaultstate="collapsed" desc="FindImplementableMethods">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6299,
 FQN="FindImplementableMethods", NM="_ZL24FindImplementableMethodsRN5clang10ASTContextEPNS_17ObjCContainerDeclEbNS_8QualTypeERN4llvm8DenseMapINS_8SelectorENS5_14PointerIntPairIPNS_14ObjCMethodDeclELj1EbNS5_21PointerLikeTypeTraitsISA_EENS5_18PointerIntPairInfoISA_Lj1ESC_EEEENS5_12DenseMapInfoIS7_EENS5_6detail12DenseMapPairIS7_SF_EEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL24FindImplementableMethodsRN5clang10ASTContextEPNS_17ObjCContainerDeclEbNS_8QualTypeERN4llvm8DenseMapINS_8SelectorENS5_14PointerIntPairIPNS_14ObjCMethodDeclELj1EbNS5_21PointerLikeTypeTraitsISA_EENS5_18PointerIntPairInfoISA_Lj1ESC_EEEENS5_12DenseMapInfoIS7_EENS5_6detail12DenseMapPairIS7_SF_EEEEb")
//</editor-fold>
public static void FindImplementableMethods(final ASTContext /*&*/ Context, 
                        ObjCContainerDecl /*P*/ Container, 
                        boolean WantInstanceMethods, 
                        QualType ReturnType, 
                        final DenseMap<Selector, PointerBoolPair<ObjCMethodDecl /*P*/ >> /*&*/ KnownMethods) {
  FindImplementableMethods(Context, 
                        Container, 
                        WantInstanceMethods, 
                        ReturnType, 
                        KnownMethods, 
                        true);
}
public static void FindImplementableMethods(final ASTContext /*&*/ Context, 
                        ObjCContainerDecl /*P*/ Container, 
                        boolean WantInstanceMethods, 
                        QualType ReturnType, 
                        final DenseMap<Selector, PointerBoolPair<ObjCMethodDecl /*P*/ >> /*&*/ KnownMethods, 
                        boolean InOriginalClass/*= true*/) {
  {
    ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(Container);
    if ((IFace != null)) {
      // Make sure we have a definition; that's what we'll walk.
      if (!IFace.hasDefinition()) {
        return;
      }
      
      IFace = IFace.getDefinition();
      Container = IFace;
      
      final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = IFace.getReferencedProtocols();
      for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end());
           $noteq_ptr(I, E); I.$preInc())  {
        FindImplementableMethods(Context, I.$star(), WantInstanceMethods, new QualType(ReturnType), 
            KnownMethods, InOriginalClass);
      }
      
      // Add methods from any class extensions and categories.
      for (ObjCCategoryDecl /*P*/ Cat : IFace.visible_categories()) {
        FindImplementableMethods(Context, Cat, WantInstanceMethods, new QualType(ReturnType), 
            KnownMethods, false);
      }
      
      // Visit the superclass.
      if ((IFace.getSuperClass() != null)) {
        FindImplementableMethods(Context, IFace.getSuperClass(), 
            WantInstanceMethods, new QualType(ReturnType), 
            KnownMethods, false);
      }
    }
  }
  {
    
    ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(Container);
    if ((Category != null)) {
      // Recurse into protocols.
      final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = Category.getReferencedProtocols();
      for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end());
           $noteq_ptr(I, E); I.$preInc())  {
        FindImplementableMethods(Context, I.$star(), WantInstanceMethods, new QualType(ReturnType), 
            KnownMethods, InOriginalClass);
      }
      
      // If this category is the original class, jump to the interface.
      if (InOriginalClass && (Category.getClassInterface() != null)) {
        FindImplementableMethods(Context, Category.getClassInterface(), 
            WantInstanceMethods, new QualType(ReturnType), KnownMethods, 
            false);
      }
    }
  }
  {
    
    ObjCProtocolDecl /*P*/ Protocol = dyn_cast_ObjCProtocolDecl(Container);
    if ((Protocol != null)) {
      // Make sure we have a definition; that's what we'll walk.
      if (!Protocol.hasDefinition()) {
        return;
      }
      Protocol = Protocol.getDefinition();
      Container = Protocol;
      
      // Recurse into protocols.
      final /*const*/ ObjCList<ObjCProtocolDecl> /*&*/ Protocols = Protocol.getReferencedProtocols();
      for (type$ptr<ObjCProtocolDecl> I = $tryClone(Protocols.begin()), 
          /*P*/ /*const*/ /*P*/ E = $tryClone(Protocols.end());
           $noteq_ptr(I, E); I.$preInc())  {
        FindImplementableMethods(Context, I.$star(), WantInstanceMethods, new QualType(ReturnType), 
            KnownMethods, false);
      }
    }
  }
  
  // Add methods in this container. This operation occurs last because
  // we want the methods from this container to override any methods
  // we've previously seen with the same selector.
  for (ObjCMethodDecl /*P*/ M : Container.methods()) {
    if (M.isInstanceMethod() == WantInstanceMethods) {
      if (!ReturnType.isNull()
         && !Context.hasSameUnqualifiedType(new QualType(ReturnType), M.getReturnType())) {
        continue;
      }
      
      KnownMethods.$at_T1$RR(M.getSelector()).$assignMove(
          new PointerBoolPair<ObjCMethodDecl /*P*/ >(M, InOriginalClass)
      );
    }
  }
}


/// \brief Add the parenthesized return or parameter type chunk to a code 
/// completion string.
//<editor-fold defaultstate="collapsed" desc="AddObjCPassingTypeChunk">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6385,
 FQN="AddObjCPassingTypeChunk", NM="_ZL23AddObjCPassingTypeChunkN5clang8QualTypeEjRNS_10ASTContextERKNS_14PrintingPolicyERNS_21CodeCompletionBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL23AddObjCPassingTypeChunkN5clang8QualTypeEjRNS_10ASTContextERKNS_14PrintingPolicyERNS_21CodeCompletionBuilderE")
//</editor-fold>
public static void AddObjCPassingTypeChunk(QualType Type, 
                       /*uint*/int ObjCDeclQuals, 
                       final ASTContext /*&*/ Context, 
                       final /*const*/ PrintingPolicy /*&*/ Policy, 
                       final CodeCompletionBuilder /*&*/ Builder) {
  Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
  std.string Quals = formatObjCParamQualifiers(ObjCDeclQuals, Type);
  if (!Quals.empty()) {
    Builder.AddTextChunk(Builder.getAllocator().CopyString(new Twine(Quals)));
  }
  Builder.AddTextChunk(GetCompletionTypeString(new QualType(Type), Context, Policy, 
          Builder.getAllocator()));
  Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
}


/// \brief Determine whether the given class is or inherits from a class by
/// the given name.
//<editor-fold defaultstate="collapsed" desc="InheritsFromClassNamed">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6401,
 FQN="InheritsFromClassNamed", NM="_ZL22InheritsFromClassNamedPN5clang17ObjCInterfaceDeclEN4llvm9StringRefE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL22InheritsFromClassNamedPN5clang17ObjCInterfaceDeclEN4llvm9StringRefE")
//</editor-fold>
public static boolean InheritsFromClassNamed(ObjCInterfaceDecl /*P*/ Class, 
                      StringRef Name) {
  if (!(Class != null)) {
    return false;
  }
  if ((Class.getIdentifier() != null) && $eq_StringRef(Class.getIdentifier().getName(), /*NO_COPY*/Name)) {
    return true;
  }
  
  return InheritsFromClassNamed(Class.getSuperClass(), new StringRef(Name));
}


/// \brief Add code completions for Objective-C Key-Value Coding (KVC) and
/// Key-Value Observing (KVO).
//<editor-fold defaultstate="collapsed" desc="AddObjCKeyValueCompletions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6414,
 FQN="AddObjCKeyValueCompletions", NM="_ZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderE")
//</editor-fold>
public static void AddObjCKeyValueCompletions(ObjCPropertyDecl /*P*/ Property, 
                          boolean IsInstanceMethod, 
                          QualType ReturnType, 
                          final ASTContext /*&*/ Context, 
                          final SmallPtrSet<Selector> /*&*/ KnownSelectors, 
                          final ResultBuilder /*&*/ Results) {
  CodeCompletionBuilder Builder = null;
  try {
    IdentifierInfo /*P*/ PropName = Property.getIdentifier();
    if (!(PropName != null) || PropName.getLength() == 0) {
      return;
    }
    
    PrintingPolicy Policy = getCompletionPrintingPolicy(Results.getSema());
    
    // Builder that will create each code completion.
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    final CodeCompletionAllocator /*&*/ Allocator = Results.getAllocator();
    Builder/*J*/= new CodeCompletionBuilder(Allocator, Results.getCodeCompletionTUInfo());
    
    // The selector table.
    final SelectorTable /*&*/ Selectors = Context.Selectors;
    
    // The property name, copied into the code completion allocation region
    // on demand.
    //<editor-fold defaultstate="collapsed" desc="KeyHolder">
    @Converted(kind = Converted.Kind.AUTO,
     source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6436,
     FQN="KeyHolder", NM="_ZZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderEE9KeyHolder",
     cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderEE9KeyHolder")
    //</editor-fold>
     class/*struct*/ KeyHolder {
      public final CodeCompletionAllocator /*&*/ Allocator;
      public StringRef Key;
      public /*const*/char$ptr/*char P*/ CopiedKey;
      
      //<editor-fold defaultstate="collapsed" desc="AddObjCKeyValueCompletions(ObjCPropertyDecl * , bool, QualType, ASTContext & , VisitedSelectorSet & , ResultBuilder & )::KeyHolder::KeyHolder">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6441,
       FQN="AddObjCKeyValueCompletions(ObjCPropertyDecl * , bool, QualType, ASTContext & , VisitedSelectorSet & , ResultBuilder & )::KeyHolder::KeyHolder", NM="_ZZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderEEN9KeyHolderC1ERNS_23CodeCompletionAllocatorENS5_9StringRefE",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderEEN9KeyHolderC1ERNS_23CodeCompletionAllocatorENS5_9StringRefE")
      //</editor-fold>
      public KeyHolder(final CodeCompletionAllocator /*&*/ Allocator, StringRef Key) {
        // : Allocator(Allocator), Key(Key), CopiedKey(null) 
        //START JInit
        this./*&*/Allocator=/*&*/Allocator;
        this.Key = new StringRef(Key);
        this.CopiedKey = null;
        //END JInit
      }

      
      //<editor-fold defaultstate="collapsed" desc="AddObjCKeyValueCompletions(ObjCPropertyDecl * , bool, QualType, ASTContext & , VisitedSelectorSet & , ResultBuilder & )::KeyHolder::operator const char * ">
      @Converted(kind = Converted.Kind.AUTO,
       source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6444,
       FQN="AddObjCKeyValueCompletions(ObjCPropertyDecl * , bool, QualType, ASTContext & , VisitedSelectorSet & , ResultBuilder & )::KeyHolder::operator const char * ", NM="_ZZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderEEN9KeyHoldercvPKcEv",
       cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZZL26AddObjCKeyValueCompletionsPN5clang16ObjCPropertyDeclEbNS_8QualTypeERNS_10ASTContextERN4llvm11SmallPtrSetINS_8SelectorELj16EEERN12_GLOBAL__N_113ResultBuilderEEN9KeyHoldercvPKcEv")
      //</editor-fold>
      public /*const*/char$ptr/*char P*/ $char$ptr$C() {
        if ((CopiedKey != null)) {
          return CopiedKey;
        }
        
        return CopiedKey = $tryClone(Allocator.CopyString(new Twine(Key)));
      }

      
      @Override public String toString() {
        return "" + "Allocator=" + "[CodeCompletionAllocator]" // NOI18N
                  + ", Key=" + Key // NOI18N
                  + ", CopiedKey=" + CopiedKey; // NOI18N
      }
    } KeyHolder Key/*J*/= new KeyHolder(Allocator, PropName.getName());
    
    // The uppercased name of the property name.
    std.string UpperKey = PropName.getName().$string();
    if (!UpperKey.empty()) {
      UpperKey.$set(0, toUppercase(UpperKey.$at(0)));
    }
    
    boolean ReturnTypeMatchesProperty = ReturnType.isNull()
       || Context.hasSameUnqualifiedType(ReturnType.getNonReferenceType(), 
        Property.getType());
    boolean ReturnTypeMatchesVoid = ReturnType.isNull() || ReturnType.$arrow().isVoidType();
    
    // Add the normal accessor -(type)key.
    if (IsInstanceMethod
       && KnownSelectors.insert(Selectors.getNullarySelector(PropName)).second
       && ReturnTypeMatchesProperty && !(Property.getGetterMethodDecl() != null)) {
      if (ReturnType.isNull()) {
        AddObjCPassingTypeChunk(Property.getType(), /*Quals=*/ 0, 
            Context, Policy, Builder);
      }
      
      Builder.AddTypedTextChunk(Key.$char$ptr$C());
      Results.AddResult(new CodeCompletionResult(Builder.TakeString(), CCP_CodePattern, 
              CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
    }
    
    // If we have an integral or boolean property (or the user has provided
    // an integral or boolean return type), add the accessor -(type)isKey.
    if (IsInstanceMethod
       && ((!ReturnType.isNull()
       && (ReturnType.$arrow().isIntegerType() || ReturnType.$arrow().isBooleanType()))
       || (ReturnType.isNull()
       && (Property.getType().$arrow().isIntegerType()
       || Property.getType().$arrow().isBooleanType())))) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"is"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getNullarySelector(SelectorId)).
          second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("BOOL"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(SelectorId.getName())));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), CCP_CodePattern, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Add the normal mutator.
    if (IsInstanceMethod && ReturnTypeMatchesVoid
       && !(Property.getSetterMethodDecl() != null)) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"set"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(SelectorId.getName())));
        Builder.AddTypedTextChunk($COLON);
        AddObjCPassingTypeChunk(Property.getType(), /*Quals=*/ 0, 
            Context, Policy, Builder);
        Builder.AddTextChunk(Key.$char$ptr$C());
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), CCP_CodePattern, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Indexed and unordered accessors
    /*uint*/int IndexedGetterPriority = CCP_CodePattern;
    /*uint*/int IndexedSetterPriority = CCP_CodePattern;
    /*uint*/int UnorderedGetterPriority = CCP_CodePattern;
    /*uint*/int UnorderedSetterPriority = CCP_CodePattern;
    {
      /*const*/ ObjCObjectPointerType /*P*/ ObjCPointer = Property.getType().$arrow().getAs(ObjCObjectPointerType.class);
      if ((ObjCPointer != null)) {
        {
          ObjCInterfaceDecl /*P*/ IFace = ObjCPointer.getInterfaceDecl();
          if ((IFace != null)) {
            // If this interface type is not provably derived from a known
            // collection, penalize the corresponding completions.
            if (!InheritsFromClassNamed(IFace, new StringRef(/*KEEP_STR*/"NSMutableArray"))) {
              IndexedSetterPriority += CCD_ProbablyNotObjCCollection;
              if (!InheritsFromClassNamed(IFace, new StringRef(/*KEEP_STR*/"NSArray"))) {
                IndexedGetterPriority += CCD_ProbablyNotObjCCollection;
              }
            }
            if (!InheritsFromClassNamed(IFace, new StringRef(/*KEEP_STR*/"NSMutableSet"))) {
              UnorderedSetterPriority += CCD_ProbablyNotObjCCollection;
              if (!InheritsFromClassNamed(IFace, new StringRef(/*KEEP_STR*/"NSSet"))) {
                UnorderedGetterPriority += CCD_ProbablyNotObjCCollection;
              }
            }
          }
        }
      } else {
        IndexedGetterPriority += CCD_ProbablyNotObjCCollection;
        IndexedSetterPriority += CCD_ProbablyNotObjCCollection;
        UnorderedGetterPriority += CCD_ProbablyNotObjCCollection;
        UnorderedSetterPriority += CCD_ProbablyNotObjCCollection;
      }
    }
    
    // Add -(NSUInteger)countOf<key>
    if (IsInstanceMethod
       && (ReturnType.isNull() || ReturnType.$arrow().isIntegerType())) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"countOf"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getNullarySelector(SelectorId)).
          second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("NSUInteger"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(SelectorId.getName())));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
                std.min_uint(IndexedGetterPriority, 
                    UnorderedGetterPriority), 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Indexed getters
    // Add -(id)objectInKeyAtIndex:(NSUInteger)index
    if (IsInstanceMethod
       && (ReturnType.isNull() || ReturnType.$arrow().isObjCObjectPointerType())) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"objectIn"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"AtIndex"))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("id"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSUInteger"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("index"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedGetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Add -(NSArray *)keyAtIndexes:(NSIndexSet *)indexes
    if (IsInstanceMethod
       && (ReturnType.isNull()
       || (ReturnType.$arrow().isObjCObjectPointerType()
       && (ReturnType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl() != null)
       && $eq_StringRef(ReturnType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl().
            getName(), /*STRINGREF_STR*/"NSArray")))) {
      std.string SelectorName = ($add_Twine$C(new Twine(Property.getName()), new Twine(/*KEEP_STR*/"AtIndexes"))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("NSArray *"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSIndexSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("indexes"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedGetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Add -(void)getKey:(type **)buffer range:(NSRange)inRange
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"get"), new Twine(UpperKey))).str();
      type$ptr<IdentifierInfo> /*P*/ SelectorIds = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(Context.Idents.get(new StringRef(SelectorName))), 
        $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"range")))
      });
      if (KnownSelectors.insert(Selectors.getSelector(2, SelectorIds)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("object-type"));
        Builder.AddTextChunk($(" **"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("buffer"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTypedTextChunk($("range:"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSRange"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("inRange"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedGetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Mutable indexed accessors
    
    // - (void)insertObject:(type *)object inKeyAtIndex:(NSUInteger)index
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"in"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"AtIndex"))).str();
      type$ptr<IdentifierInfo> /*P*/ SelectorIds = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"insertObject"))), 
        $AddrOf(Context.Idents.get(new StringRef(SelectorName)))
      });
      if (KnownSelectors.insert(Selectors.getSelector(2, SelectorIds)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk($("insertObject:"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("object-type"));
        Builder.AddTextChunk($(" *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("object"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("NSUInteger"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("index"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)insertKey:(NSArray *)array atIndexes:(NSIndexSet *)indexes
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"insert"), new Twine(UpperKey))).str();
      type$ptr<IdentifierInfo> /*P*/ SelectorIds = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(Context.Idents.get(new StringRef(SelectorName))), 
        $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"atIndexes")))
      });
      if (KnownSelectors.insert(Selectors.getSelector(2, SelectorIds)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSArray *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("array"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTypedTextChunk($("atIndexes:"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("NSIndexSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("indexes"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // -(void)removeObjectFromKeyAtIndex:(NSUInteger)index
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"removeObjectFrom"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"AtIndex"))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSUInteger"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("index"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // -(void)removeKeyAtIndexes:(NSIndexSet *)indexes
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"remove"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"AtIndexes"))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSIndexSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("indexes"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)replaceObjectInKeyAtIndex:(NSUInteger)index withObject:(id)object
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"replaceObjectIn"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"AtIndex"))).str();
      type$ptr<IdentifierInfo> /*P*/ SelectorIds = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(Context.Idents.get(new StringRef(SelectorName))), 
        $AddrOf(Context.Idents.get(new StringRef(/*KEEP_STR*/"withObject")))
      });
      if (KnownSelectors.insert(Selectors.getSelector(2, SelectorIds)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("NSUInteger"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("index"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTypedTextChunk($("withObject:"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("id"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("object"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)replaceKeyAtIndexes:(NSIndexSet *)indexes withKey:(NSArray *)array
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName1 = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"replace"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"AtIndexes"))).str();
      std.string SelectorName2 = ($add_Twine$C(new Twine(/*KEEP_STR*/"with"), new Twine(UpperKey))).str();
      type$ptr<IdentifierInfo> /*P*/ SelectorIds = create_type$ptr(new IdentifierInfo /*P*/ [/*2*/] {
        $AddrOf(Context.Idents.get(new StringRef(SelectorName1))), 
        $AddrOf(Context.Idents.get(new StringRef(SelectorName2)))
      });
      if (KnownSelectors.insert(Selectors.getSelector(2, SelectorIds)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName1, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("NSIndexSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("indexes"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName2, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSArray *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("array"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), IndexedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Unordered getters
    // - (NSEnumerator *)enumeratorOfKey
    if (IsInstanceMethod
       && (ReturnType.isNull()
       || (ReturnType.$arrow().isObjCObjectPointerType()
       && (ReturnType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl() != null)
       && $eq_StringRef(ReturnType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl().
            getName(), /*STRINGREF_STR*/"NSEnumerator")))) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"enumeratorOf"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getNullarySelector(SelectorId)).
          second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("NSEnumerator *"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(SelectorName)));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedGetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (type *)memberOfKey:(type *)object
    if (IsInstanceMethod
       && (ReturnType.isNull() || ReturnType.$arrow().isObjCObjectPointerType())) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"memberOf"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddPlaceholderChunk($("object-type"));
          Builder.AddTextChunk($(" *"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        if (ReturnType.isNull()) {
          Builder.AddPlaceholderChunk($("object-type"));
          Builder.AddTextChunk($(" *"));
        } else {
          Builder.AddTextChunk(GetCompletionTypeString(new QualType(ReturnType), Context, 
                  Policy, 
                  Builder.getAllocator()));
        }
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("object"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedGetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Mutable unordered accessors
    // - (void)addKeyObject:(type *)object
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"add"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"Object"))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("object-type"));
        Builder.AddTextChunk($(" *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("object"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)addKey:(NSSet *)objects
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"add"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("objects"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)removeKeyObject:(type *)object
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C($add_Twine$C(new Twine(/*KEEP_STR*/"remove"), new Twine(UpperKey)), new Twine(/*KEEP_STR*/"Object"))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddPlaceholderChunk($("object-type"));
        Builder.AddTextChunk($(" *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("object"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)removeKey:(NSSet *)objects
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"remove"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("objects"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // - (void)intersectKey:(NSSet *)objects
    if (IsInstanceMethod && ReturnTypeMatchesVoid) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"intersect"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getUnarySelector(SelectorId)).second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($void);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine($add_string$C_T$C$P(SelectorName, /*KEEP_STR*/":"))));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("NSSet *"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("objects"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), UnorderedSetterPriority, 
                CXCursorKind.CXCursor_ObjCInstanceMethodDecl));
      }
    }
    
    // Key-Value Observing
    // + (NSSet *)keyPathsForValuesAffectingKey
    if (!IsInstanceMethod
       && (ReturnType.isNull()
       || (ReturnType.$arrow().isObjCObjectPointerType()
       && (ReturnType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl() != null)
       && $eq_StringRef(ReturnType.$arrow().getAs(ObjCObjectPointerType.class).getInterfaceDecl().
            getName(), /*STRINGREF_STR*/"NSSet")))) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"keyPathsForValuesAffecting"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getNullarySelector(SelectorId)).
          second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("NSSet *"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(SelectorName)));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), CCP_CodePattern, 
                CXCursorKind.CXCursor_ObjCClassMethodDecl));
      }
    }
    
    // + (BOOL)automaticallyNotifiesObserversForKey
    if (!IsInstanceMethod
       && (ReturnType.isNull()
       || ReturnType.$arrow().isIntegerType()
       || ReturnType.$arrow().isBooleanType())) {
      std.string SelectorName = ($add_Twine$C(new Twine(/*KEEP_STR*/"automaticallyNotifiesObserversOf"), new Twine(UpperKey))).str();
      IdentifierInfo /*P*/ SelectorId = $AddrOf(Context.Idents.get(new StringRef(SelectorName)));
      if (KnownSelectors.insert(Selectors.getNullarySelector(SelectorId)).
          second) {
        if (ReturnType.isNull()) {
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
          Builder.AddTextChunk($("BOOL"));
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        }
        
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(SelectorName)));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), CCP_CodePattern, 
                CXCursorKind.CXCursor_ObjCClassMethodDecl));
      }
    }
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

} // END OF class SemaCodeCompleteStatics
