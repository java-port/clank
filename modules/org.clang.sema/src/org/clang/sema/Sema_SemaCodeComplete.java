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
import org.clang.basic.*;
import org.clang.lex.*;
import org.clang.lex.Preprocessor_NestedClasses.*;
import org.clang.lex.llvm.*;
import org.clang.sema.impl.*;
import org.clang.clangc.*;
import static org.clang.sema.Sema.*;
import static org.clang.sema.SemaClangGlobals.*;
import static org.clang.sema.java.SemaMemberPointers.*;
import static org.clang.ast.DeclContext.specific_decl_iterator.*;
import static org.clang.sema.impl.SemaCodeCompleteStatics.*;
import static org.clang.ast.java.AstDeclarationsRTTI.*;
import org.clang.basic.llvm.DenseMapInfoSelector;
import static org.clang.ast.java.AstExpressionsRTTI.*;
import static org.clang.ast.java.AstStatementsRTTI.*;

//<editor-fold defaultstate="collapsed" desc="static type Sema_SemaCodeComplete">
@Converted(kind = Converted.Kind.AUTO,
 cmd="jclank.sh -java-options=${SPUTNIK}/contrib/JConvert/llvmToClankType -print -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this -extends=Sema_SemaChecking ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema15CodeCompleteTagEPNS_5ScopeEj;_ZN5clang4Sema16CodeCompleteCallEPNS_5ScopeEPNS_4ExprEN4llvm8ArrayRefIS4_EE;_ZN5clang4Sema16CodeCompleteCaseEPNS_5ScopeE;_ZN5clang4Sema17CodeCompleteUsingEPNS_5ScopeE;_ZN5clang4Sema18CodeCompleteReturnEPNS_5ScopeE;_ZN5clang4Sema19CodeCompleteAfterIfEPNS_5ScopeE;_ZN5clang4Sema20CodeCompleteDeclSpecEPNS_5ScopeERNS_8DeclSpecEbb;_ZN5clang4Sema22CodeCompleteExpressionEPNS_5ScopeERKNS0_26CodeCompleteExpressionDataE;_ZN5clang4Sema23CodeCompleteConstructorEPNS_5ScopeENS_8QualTypeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE;_ZN5clang4Sema23CodeCompleteInitializerEPNS_5ScopeEPNS_4DeclE;_ZN5clang4Sema23CodeCompleteQualifiedIdEPNS_5ScopeERNS_12CXXScopeSpecEb;_ZN5clang4Sema24CodeCompleteModuleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEE;_ZN5clang4Sema24CodeCompleteObjCSelectorEPNS_5ScopeEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE;_ZN5clang4Sema24CodeCompleteOperatorNameEPNS_5ScopeE;_ZN5clang4Sema24CodeCompleteOrdinaryNameEPNS_5ScopeENS0_23ParserCompletionContextE;_ZN5clang4Sema25CodeCompleteAssignmentRHSEPNS_5ScopeEPNS_4ExprE;_ZN5clang4Sema25CodeCompleteNamespaceDeclEPNS_5ScopeE;_ZN5clang4Sema26CodeCompleteObjCMethodDeclEPNS_5ScopeEbNS_9OpaquePtrINS_8QualTypeEEE;_ZN5clang4Sema26CodeCompleteObjCSuperclassEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema26CodeCompleteTypeQualifiersERNS_8DeclSpecE;_ZN5clang4Sema26CodeCompleteUsingDirectiveEPNS_5ScopeE;_ZN5clang4Sema27CodeCompleteNaturalLanguageEv;_ZN5clang4Sema27CodeCompleteObjCAtDirectiveEPNS_5ScopeE;_ZN5clang4Sema27CodeCompleteObjCAtStatementEPNS_5ScopeE;_ZN5clang4Sema27CodeCompleteObjCPassingTypeEPNS_5ScopeERNS_12ObjCDeclSpecEb;_ZN5clang4Sema27GatherGlobalCodeCompletionsERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoERN4llvm15SmallVectorImplINS_20CodeCompletionResultEEE;_ZN5clang4Sema28CodeCompleteLambdaIntroducerEPNS_5ScopeERNS_16LambdaIntroducerEb;_ZN5clang4Sema28CodeCompleteObjCAtExpressionEPNS_5ScopeE;_ZN5clang4Sema28CodeCompleteObjCAtVisibilityEPNS_5ScopeE;_ZN5clang4Sema28CodeCompleteObjCClassMessageEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbb;_ZN5clang4Sema28CodeCompleteObjCProtocolDeclEPNS_5ScopeE;_ZN5clang4Sema28CodeCompleteObjCSuperMessageEPNS_5ScopeENS_14SourceLocationEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb;_ZN5clang4Sema29CodeCompleteBracketDeclaratorEPNS_5ScopeE;_ZN5clang4Sema29CodeCompleteObjCForCollectionEPNS_5ScopeENS_9OpaquePtrINS_12DeclGroupRefEEE;_ZN5clang4Sema29CodeCompleteObjCInterfaceDeclEPNS_5ScopeE;_ZN5clang4Sema29CodeCompleteObjCPropertyFlagsEPNS_5ScopeERNS_12ObjCDeclSpecE;_ZN5clang4Sema29CodeCompletePostfixExpressionEPNS_5ScopeENS_12ActionResultIPNS_4ExprELb1EEE;_ZN5clang4Sema30CodeCompleteNamespaceAliasDeclEPNS_5ScopeE;_ZN5clang4Sema30CodeCompleteObjCPropertyGetterEPNS_5ScopeE;_ZN5clang4Sema30CodeCompleteObjCPropertySetterEPNS_5ScopeE;_ZN5clang4Sema31CodeCompleteMemberReferenceExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEb;_ZN5clang4Sema31CodeCompleteObjCInstanceMessageEPNS_5ScopeEPNS_4ExprEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbPNS_17ObjCInterfaceDeclE;_ZN5clang4Sema31CodeCompleteObjCMessageReceiverEPNS_5ScopeE;_ZN5clang4Sema33CodeCompleteObjCInterfaceCategoryEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema33CodeCompletePreprocessorDirectiveEb;_ZN5clang4Sema33CodeCompletePreprocessorMacroNameEb;_ZN5clang4Sema34CodeCompleteConstructorInitializerEPNS_4DeclEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE;_ZN5clang4Sema34CodeCompleteObjCImplementationDeclEPNS_5ScopeE;_ZN5clang4Sema34CodeCompleteObjCMethodDeclSelectorEPNS_5ScopeEbbNS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE;_ZN5clang4Sema34CodeCompleteObjCPropertyDefinitionEPNS_5ScopeE;_ZN5clang4Sema34CodeCompleteObjCProtocolReferencesEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoENS_14SourceLocationEEEE;_ZN5clang4Sema34CodeCompletePreprocessorExpressionEv;_ZN5clang4Sema37CodeCompletePreprocessorMacroArgumentEPNS_5ScopeEPNS_14IdentifierInfoEPNS_9MacroInfoEj;_ZN5clang4Sema38CodeCompleteObjCImplementationCategoryEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE;_ZN5clang4Sema38CodeCompleteObjCPropertySynthesizeIvarEPNS_5ScopeEPNS_14IdentifierInfoE;_ZN5clang4Sema46CodeCompleteInPreprocessorConditionalExclusionEPNS_5ScopeE; -static-type=Sema_SemaCodeComplete -package=org.clang.sema")
//</editor-fold>
public class Sema_SemaCodeComplete extends Sema_SemaChecking {
private final /*split clang::Sema*/ Sema $this() { return (Sema)this; }

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteModuleImport">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3279,
 FQN="clang::Sema::CodeCompleteModuleImport", NM="_ZN5clang4Sema24CodeCompleteModuleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema24CodeCompleteModuleImportENS_14SourceLocationEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoES1_EEE")
//</editor-fold>
public final void CodeCompleteModuleImport(SourceLocation ImportLoc, 
                        ModuleIdPath Path) {
  ResultBuilder Results = null;
  CodeCompletionBuilder Builder = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    
    final CodeCompletionAllocator /*&*/ Allocator = Results.getAllocator();
    Builder/*J*/= new CodeCompletionBuilder(Allocator, Results.getCodeCompletionTUInfo());
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    if (Path.empty()) {
      // Enumerate all top-level modules.
      SmallVector<Module /*P*/> Modules/*J*/= new SmallVector<Module /*P*/>(8, (Module /*P*/)null);
      $this().PP.getHeaderSearchInfo().collectAllModules(Modules);
      for (/*uint*/int I = 0, N = Modules.size(); I != N; ++I) {
        Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Modules.$at(I).Name)));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
                CCP_Declaration, 
                CXCursorKind.CXCursor_ModuleImportDecl, 
                Modules.$at(I).isAvailable() ? CXAvailabilityKind.CXAvailability_Available : CXAvailabilityKind.CXAvailability_NotAvailable));
      }
    } else if ($this().getLangOpts().Modules) {
      // Load the named module.
      Module /*P*/ Mod = $this().PP.getModuleLoader().loadModule(/*NO_COPY*/ImportLoc, /*NO_COPY*/Path, 
          Module.NameVisibilityKind.AllVisible, 
          /*IsInclusionDirective=*/ false).$ModulePtr();
      // Enumerate submodules.
      if ((Mod != null)) {
        for (std.vector.iterator<Module /*P*/ > Sub = Mod.submodule_begin(), 
            SubEnd = Mod.submodule_end();
             $noteq___normal_iterator$C(Sub, SubEnd); Sub.$preInc()) {
          
          Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine((Sub.$star()).Name)));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
                  CCP_Declaration, 
                  CXCursorKind.CXCursor_ModuleImportDecl, 
                  (Sub.$star()).isAvailable() ? CXAvailabilityKind.CXAvailability_Available : CXAvailabilityKind.CXAvailability_NotAvailable));
        }
      }
    }
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteOrdinaryName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3331,
 FQN="clang::Sema::CodeCompleteOrdinaryName", NM="_ZN5clang4Sema24CodeCompleteOrdinaryNameEPNS_5ScopeENS0_23ParserCompletionContextE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema24CodeCompleteOrdinaryNameEPNS_5ScopeENS0_23ParserCompletionContextE")
//</editor-fold>
public final void CodeCompleteOrdinaryName(Scope /*P*/ S, 
                        ParserCompletionContext CompletionContext) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(mapCodeCompletionContext(/*Deref*/$this(), CompletionContext)));
    Results.EnterNewScope();
    
    // Determine how to filter results, e.g., so that the names of
    // values (functions, enumerators, function templates, etc.) are
    // only allowed where we can have an expression.
    switch (CompletionContext) {
     case PCC_Namespace:
     case PCC_Class:
     case PCC_ObjCInterface:
     case PCC_ObjCImplementation:
     case PCC_ObjCInstanceVariableList:
     case PCC_Template:
     case PCC_MemberTemplate:
     case PCC_Type:
     case PCC_LocalDeclarationSpecifiers:
      Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryNonValueName);
      break;
     case PCC_Statement:
     case PCC_ParenthesizedExpression:
     case PCC_Expression:
     case PCC_ForInit:
     case PCC_Condition:
      if (WantTypesInContext(CompletionContext, $this().getLangOpts())) {
        Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryName);
      } else {
        Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryNonTypeName);
      }
      if ($this().getLangOpts().CPlusPlus) {
        MaybeAddOverrideCalls(/*Deref*/$this(), /*InContext=*/ (DeclContext /*P*/ )null, Results);
      }
      break;
     case PCC_RecoveryInFunction:
      // Unfiltered
      break;
    }
    {
      
      // If we are in a C++ non-static member function, check the qualifiers on
      // the member function to filter/prioritize the results list.
      CXXMethodDecl /*P*/ CurMethod = dyn_cast_CXXMethodDecl($this().CurContext);
      if ((CurMethod != null)) {
        if (CurMethod.isInstance()) {
          Results.setObjectTypeQualifiers(Qualifiers.fromCVRMask(CurMethod.getTypeQualifiers()));
        }
      }
    }
    
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    
    AddOrdinaryNameResults(CompletionContext, S, /*Deref*/$this(), Results);
    Results.ExitScope();
    switch (CompletionContext) {
     case PCC_ParenthesizedExpression:
     case PCC_Expression:
     case PCC_Statement:
     case PCC_RecoveryInFunction:
      if ((S.getFnParent() != null)) {
        AddPrettyFunctionResults($this().getLangOpts(), Results);
      }
      break;
     case PCC_Namespace:
     case PCC_Class:
     case PCC_ObjCInterface:
     case PCC_ObjCImplementation:
     case PCC_ObjCInstanceVariableList:
     case PCC_Template:
     case PCC_MemberTemplate:
     case PCC_ForInit:
     case PCC_Condition:
     case PCC_Type:
     case PCC_LocalDeclarationSpecifiers:
      break;
    }
    if ($this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, false);
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteDeclSpec">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3424,
 FQN="clang::Sema::CodeCompleteDeclSpec", NM="_ZN5clang4Sema20CodeCompleteDeclSpecEPNS_5ScopeERNS_8DeclSpecEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema20CodeCompleteDeclSpecEPNS_5ScopeERNS_8DeclSpecEbb")
//</editor-fold>
public final void CodeCompleteDeclSpec(Scope /*P*/ S, final DeclSpec /*&*/ DS, 
                    boolean AllowNonIdentifiers, 
                    boolean AllowNestedNameSpecifiers) {
  ResultBuilder Results = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(AllowNestedNameSpecifiers ? CodeCompletionContext.Kind.CCC_PotentiallyQualifiedName : CodeCompletionContext.Kind.CCC_Name));
    Results.EnterNewScope();
    
    // Type qualifiers can come after names.
    Results.AddResult(new CodeCompletionResult($const));
    Results.AddResult(new CodeCompletionResult($volatile));
    if ($this().getLangOpts().C99) {
      Results.AddResult(new CodeCompletionResult($restrict));
    }
    if ($this().getLangOpts().CPlusPlus) {
      if (AllowNonIdentifiers) {
        Results.AddResult(new CodeCompletionResult($operator));
      }
      
      // Add nested-name-specifiers.
      if (AllowNestedNameSpecifiers) {
        CodeCompletionDeclConsumer Consumer = null;
        try {
          Results.allowNestedNameSpecifiers();
          Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsImpossibleToSatisfy);
          Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
          $this().LookupVisibleDecls(S, LookupNameKind.LookupNestedNameSpecifierName, Consumer, 
              $this().CodeCompleter.includeGlobals());
          Results.setFilter((ResultBuilder$LookupFilter)null);
        } finally {
          if (Consumer != null) { Consumer.$destroy(); }
        }
      }
    }
    Results.ExitScope();
    
    // If we're in a context where we might have an expression (rather than a
    // declaration), and what we've seen so far is an Objective-C type that could
    // be a receiver of a class message, this may be a class message send with
    // the initial opening bracket '[' missing. Add appropriate completions.
    if (AllowNonIdentifiers && !AllowNestedNameSpecifiers
       && DS.getParsedSpecifiers() == DeclSpec.ParsedSpecifiers.PQ_TypeSpecifier.getValue()
       && DS.getTypeSpecType() == DeclSpec.TST_typename
       && DS.getTypeSpecComplex() == DeclSpec.TSC.TSC_unspecified
       && DS.getTypeSpecSign() == DeclSpec.TSS_unspecified
       && !DS.isTypeAltiVecVector()
       && (S != null)
       && (S.getFlags() & Scope.ScopeFlags.DeclScope) != 0
       && (S.getFlags() & (Scope.ScopeFlags.ClassScope | Scope.ScopeFlags.TemplateParamScope
       | Scope.ScopeFlags.FunctionPrototypeScope
       | Scope.ScopeFlags.AtCatchScope)) == 0) {
      OpaquePtr<QualType> T = DS.getRepAsType();
      if (!T.getQualType().isNull() && T.getQualType().$arrow().isObjCObjectOrInterfaceType()) {
        AddClassMessageCompletions(/*Deref*/$this(), S, new OpaquePtr<QualType>(T), new ArrayRef<IdentifierInfo /*P*/ >(None, true), false, false, Results);
      }
    }
    
    // Note that we intentionally suppress macro results here, since we do not
    // encourage using macros to produce the names of entities.
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}


/// \brief Perform code-completion in an expression context when we know what
/// type we're looking for.
//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3499,
 FQN="clang::Sema::CodeCompleteExpression", NM="_ZN5clang4Sema22CodeCompleteExpressionEPNS_5ScopeERKNS0_26CodeCompleteExpressionDataE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema22CodeCompleteExpressionEPNS_5ScopeERKNS0_26CodeCompleteExpressionDataE")
//</editor-fold>
public final void CodeCompleteExpression(Scope /*P*/ S, 
                      final /*const*/ CodeCompleteExpressionData /*&*/ Data) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Expression));
    if (Data.ObjCCollection) {
      Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsObjCCollection);
    } else if (Data.IntegralConstantExpression) {
      Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsIntegralConstantValue);
    } else if (WantTypesInContext(ParserCompletionContext.PCC_Expression, $this().getLangOpts())) {
      Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryName);
    } else {
      Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryNonTypeName);
    }
    if (!Data.PreferredType.isNull()) {
      Results.setPreferredType(Data.PreferredType.getNonReferenceType());
    }
    
    // Ignore any declarations that we were told that we don't care about.
    for (/*uint*/int I = 0, N = Data.IgnoreDecls.size(); I != N; ++I)  {
      Results.Ignore(Data.IgnoreDecls.$at$Const(I));
    }
    
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    
    Results.EnterNewScope();
    AddOrdinaryNameResults(ParserCompletionContext.PCC_Expression, S, /*Deref*/$this(), Results);
    Results.ExitScope();
    
    boolean PreferredTypeIsPointer = false;
    if (!Data.PreferredType.isNull()) {
      PreferredTypeIsPointer = Data.PreferredType.$arrow().isAnyPointerType()
         || Data.PreferredType.$arrow().isMemberPointerType()
         || Data.PreferredType.$arrow().isBlockPointerType();
    }
    if ((S.getFnParent() != null)
       && !Data.ObjCCollection
       && !Data.IntegralConstantExpression) {
      AddPrettyFunctionResults($this().getLangOpts(), Results);
    }
    if ($this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, false, PreferredTypeIsPointer);
    }
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Expression, 
            new QualType(Data.PreferredType)), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteMemberReferenceExpr">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3649,
 FQN="clang::Sema::CodeCompleteMemberReferenceExpr", NM="_ZN5clang4Sema31CodeCompleteMemberReferenceExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema31CodeCompleteMemberReferenceExprEPNS_5ScopeEPNS_4ExprENS_14SourceLocationEb")
//</editor-fold>
public final void CodeCompleteMemberReferenceExpr(Scope /*P*/ S, Expr /*P*/ Base, 
                               SourceLocation OpLoc, 
                               boolean IsArrow) {
  ResultBuilder Results = null;
  try {
    if (!(Base != null) || !($this().CodeCompleter != null)) {
      return;
    }
    
    ActionResultTTrue<Expr /*P*/ > ConvertedBase = $this().PerformMemberExprBaseConversion(Base, IsArrow);
    if (ConvertedBase.isInvalid()) {
      return;
    }
    Base = ConvertedBase.get();
    
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    
    QualType BaseType = Base.getType();
    if (IsArrow) {
      {
        /*const*/ PointerType /*P*/ Ptr = BaseType.$arrow().getAs(PointerType.class);
        if ((Ptr != null)) {
          BaseType.$assignMove(Ptr.getPointeeType());
        } else if (BaseType.$arrow().isObjCObjectPointerType()) {
/*Do nothing*/           ;
        } else {
          return;
        }
      }
    }
    
     CodeCompletionContext.Kind contextKind;
    if (IsArrow) {
      contextKind = CodeCompletionContext.Kind.CCC_ArrowMemberAccess;
    } else {
      if (BaseType.$arrow().isObjCObjectPointerType()
         || BaseType.$arrow().isObjCObjectOrInterfaceType()) {
        contextKind = CodeCompletionContext.Kind.CCC_ObjCPropertyAccess;
      } else {
        contextKind = CodeCompletionContext.Kind.CCC_DotMemberAccess;
      }
    }
    
    CodeCompletionContext CCContext/*J*/= new CodeCompletionContext(contextKind, new QualType(BaseType));
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        CCContext, 
        /*AddrOf*//*FPtr*/ResultBuilder::IsMember);
    Results.EnterNewScope();
    {
      /*const*/ RecordType /*P*/ Record = BaseType.$arrow().getAs$RecordType();
      if ((Record != null)) {
        CodeCompletionDeclConsumer Consumer = null;
        try {
          // Indicate that we are performing a member access, and the cv-qualifiers
          // for the base object type.
          Results.setObjectTypeQualifiers(BaseType.getQualifiers());
          
          // Access to a C/C++ class, struct, or union.
          Results.allowNestedNameSpecifiers();
          Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
          $this().LookupVisibleDecls(Record.getDecl(), LookupNameKind.LookupMemberName, Consumer, 
              $this().CodeCompleter.includeGlobals());
          if ($this().getLangOpts().CPlusPlus) {
            if (!Results.empty()) {
              // The "template" keyword can follow "->" or "." in the grammar.
              // However, we only want to suggest the template keyword if something
              // is dependent.
              boolean IsDependent = BaseType.$arrow().isDependentType();
              if (!IsDependent) {
                for (Scope /*P*/ DepScope = S; (DepScope != null); DepScope = DepScope.getParent())  {
                  {
                    DeclContext /*P*/ Ctx = DepScope.getEntity();
                    if ((Ctx != null)) {
                      IsDependent = Ctx.isDependentContext();
                      break;
                    }
                  }
                }
              }
              if (IsDependent) {
                Results.AddResult(new CodeCompletionResult($template));
              }
            }
          }
        } finally {
          if (Consumer != null) { Consumer.$destroy(); }
        }
      } else if (!IsArrow && (BaseType.$arrow().getAsObjCInterfacePointerType() != null)) {
        // Objective-C property reference.
        SmallPtrSet<IdentifierInfo /*P*/ > AddedProperties/*J*/= new SmallPtrSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
        
        // Add property results based on our interface.
        /*const*/ ObjCObjectPointerType /*P*/ ObjCPtr = BaseType.$arrow().getAsObjCInterfacePointerType();
        assert ((ObjCPtr != null)) : "Non-NULL pointer guaranteed above!";
        AddObjCProperties(CCContext, ObjCPtr.getInterfaceDecl(), true, 
            /*AllowNullaryMethods=*/ true, $this().CurContext, 
            AddedProperties, Results);
        
        // Add properties from the protocols in a qualified interface.
        for (ObjCProtocolDecl /*P*/ I : ObjCPtr.quals())  {
          AddObjCProperties(CCContext, I, true, /*AllowNullaryMethods=*/ true, 
              $this().CurContext, AddedProperties, Results);
        }
      } else if ((IsArrow && BaseType.$arrow().isObjCObjectPointerType())
         || (!IsArrow && BaseType.$arrow().isObjCObjectType())) {
        // Objective-C instance variable access.
        ObjCInterfaceDecl /*P*/ Class = null;
        {
          /*const*/ ObjCObjectPointerType /*P*/ ObjCPtr = BaseType.$arrow().getAs(ObjCObjectPointerType.class);
          if ((ObjCPtr != null)) {
            Class = ObjCPtr.getInterfaceDecl();
          } else {
            Class = BaseType.$arrow().getAs(ObjCObjectType.class).getInterface();
          }
        }
        
        // Add all ivars from this class and its superclasses.
        if ((Class != null)) {
          CodeCompletionDeclConsumer Consumer = null;
          try {
            Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
            Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsObjCIvar);
            $this().LookupVisibleDecls(Class, LookupNameKind.LookupMemberName, Consumer, 
                $this().CodeCompleter.includeGlobals());
          } finally {
            if (Consumer != null) { Consumer.$destroy(); }
          }
        }
      }
    }
    
    // FIXME: How do we cope with isa?
    Results.ExitScope();
    
    // Hand off the results found for code completion.
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompletePostfixExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3547,
 FQN="clang::Sema::CodeCompletePostfixExpression", NM="_ZN5clang4Sema29CodeCompletePostfixExpressionEPNS_5ScopeENS_12ActionResultIPNS_4ExprELb1EEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema29CodeCompletePostfixExpressionEPNS_5ScopeENS_12ActionResultIPNS_4ExprELb1EEE")
//</editor-fold>
public final void CodeCompletePostfixExpression(Scope /*P*/ S, ActionResultTTrue<Expr /*P*/ > E) {
  if (E.isInvalid()) {
    $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_RecoveryInFunction);
  } else if ($this().getLangOpts().ObjC1) {
    $this().CodeCompleteObjCInstanceMessage(S, E.get(), new ArrayRef<IdentifierInfo /*P*/ >(None, true), false);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteTag">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3768,
 FQN="clang::Sema::CodeCompleteTag", NM="_ZN5clang4Sema15CodeCompleteTagEPNS_5ScopeEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema15CodeCompleteTagEPNS_5ScopeEj")
//</editor-fold>
public final void CodeCompleteTag(Scope /*P*/ S, /*uint*/int TagSpec) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    ResultBuilder$LookupFilter Filter = null;
     CodeCompletionContext.Kind ContextKind = CodeCompletionContext.Kind.CCC_Other;
    switch (TypeSpecifierType.valueOf(TagSpec)) {
     case TST_enum:
      Filter = /*AddrOf*//*FPtr*/ResultBuilder::IsEnum;
      ContextKind = CodeCompletionContext.Kind.CCC_EnumTag;
      break;
     case TST_union:
      Filter = /*AddrOf*//*FPtr*/ResultBuilder::IsUnion;
      ContextKind = CodeCompletionContext.Kind.CCC_UnionTag;
      break;
     case TST_struct:
     case TST_class:
     case TST_interface:
      Filter = /*AddrOf*//*FPtr*/ResultBuilder::IsClassOrStruct;
      ContextKind = CodeCompletionContext.Kind.CCC_ClassOrStructTag;
      break;
     default:
      throw new llvm_unreachable("Unknown type specifier kind in CodeCompleteTag");
    }
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), new CodeCompletionContext(ContextKind));
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    
    // First pass: look for tags.
    Results.setFilter(Filter);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupTagName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    if ($this().CodeCompleter.includeGlobals()) {
      // Second pass: look for nested name specifiers.
      Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsNestedNameSpecifier);
      $this().LookupVisibleDecls(S, LookupNameKind.LookupNestedNameSpecifierName, Consumer);
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteTypeQualifiers">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3816,
 FQN="clang::Sema::CodeCompleteTypeQualifiers", NM="_ZN5clang4Sema26CodeCompleteTypeQualifiersERNS_8DeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteTypeQualifiersERNS_8DeclSpecE")
//</editor-fold>
public final void CodeCompleteTypeQualifiers(final DeclSpec /*&*/ DS) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_TypeQualifiers));
    Results.EnterNewScope();
    if (!((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_const.getValue()) != 0)) {
      Results.AddResult(new CodeCompletionResult($const));
    }
    if (!((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_volatile.getValue()) != 0)) {
      Results.AddResult(new CodeCompletionResult($volatile));
    }
    if ($this().getLangOpts().C99
       && !((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_restrict.getValue()) != 0)) {
      Results.AddResult(new CodeCompletionResult($restrict));
    }
    if ($this().getLangOpts().C11
       && !((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_atomic.getValue()) != 0)) {
      Results.AddResult(new CodeCompletionResult($_Atomic));
    }
    if ($this().getLangOpts().MSVCCompat
       && !((DS.getTypeQualifiers() & DeclSpec.TQ.TQ_unaligned.getValue()) != 0)) {
      Results.AddResult(new CodeCompletionResult($__unaligned));
    }
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteBracketDeclarator">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3840,
 FQN="clang::Sema::CodeCompleteBracketDeclarator", NM="_ZN5clang4Sema29CodeCompleteBracketDeclaratorEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema29CodeCompleteBracketDeclaratorEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteBracketDeclarator(Scope /*P*/ S) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData($this().getASTContext().getSizeType().$QualType()))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteCase">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 3844,
 FQN="clang::Sema::CodeCompleteCase", NM="_ZN5clang4Sema16CodeCompleteCaseEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema16CodeCompleteCaseEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteCase(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    if ($this().getCurFunction().SwitchStack.empty() || !($this().CodeCompleter != null)) {
      return;
    }
    
    SwitchStmt /*P*/ Switch = $this().getCurFunction().SwitchStack.back();
    QualType type = Switch.getCond().IgnoreImplicit().getType();
    if (!type.$arrow().isEnumeralType()) {
      CodeCompleteExpressionData Data = null;
      try {
        Data/*J*/= new CodeCompleteExpressionData(new QualType(type));
        Data.IntegralConstantExpression = true;
        $this().CodeCompleteExpression(S, Data);
        return;
      } finally {
        if (Data != null) { Data.$destroy(); }
      }
    }
    
    // Code-complete the cases of a switch statement over an enumeration type
    // by providing the list of 
    EnumDecl /*P*/ Enum = type.$arrow().castAs$EnumType().getDecl();
    {
      EnumDecl /*P*/ Def = Enum.getDefinition();
      if ((Def != null)) {
        Enum = Def;
      }
    }
    
    // Determine which enumerators we have already seen in the switch statement.
    // FIXME: Ideally, we would also be able to look *past* the code-completion
    // token, in case we are code-completing in the middle of the switch and not
    // at the end. However, we aren't able to do so at the moment.
    SmallPtrSet<EnumConstantDecl /*P*/ > EnumeratorsSeen/*J*/= new SmallPtrSet<EnumConstantDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 8);
    NestedNameSpecifier /*P*/ Qualifier = null;
    for (SwitchCase /*P*/ SC = Switch.getSwitchCaseList(); (SC != null);
         SC = SC.getNextSwitchCase()) {
      CaseStmt /*P*/ Case = dyn_cast_CaseStmt(SC);
      if (!(Case != null)) {
        continue;
      }
      
      Expr /*P*/ CaseVal = Case.getLHS().IgnoreParenCasts();
      {
        DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(CaseVal);
        if ((DRE != null)) {
          {
            EnumConstantDecl /*P*/ Enumerator = dyn_cast_EnumConstantDecl(DRE.getDecl());
            if ((Enumerator != null)) {
              // We look into the AST of the case statement to determine which 
              // enumerator was named. Alternatively, we could compute the value of 
              // the integral constant expression, then compare it against the
              // values of each enumerator. However, value-based approach would not 
              // work as well with C++ templates where enumerators declared within a 
              // template are type- and value-dependent.
              EnumeratorsSeen.insert(Enumerator);
              
              // If this is a qualified-id, keep track of the nested-name-specifier
              // so that we can reproduce it as part of code completion, e.g.,
              //
              //   switch (TagD.getKind()) {
              //     case TagDecl::TK_enum:
              //       break;
              //     case XXX
              //
              // At the XXX, our completions are TagDecl::TK_union,
              // TagDecl::TK_struct, and TagDecl::TK_class, rather than TK_union,
              // TK_struct, and TK_class.
              Qualifier = DRE.getQualifier();
            }
          }
        }
      }
    }
    if ($this().getLangOpts().CPlusPlus && !(Qualifier != null) && EnumeratorsSeen.empty()) {
      // If there are no prior enumerators in C++, check whether we have to 
      // qualify the names of the enumerators that we suggest, because they
      // may not be visible in this scope.
      Qualifier = getRequiredQualification($this().Context, $this().CurContext, Enum);
    }
    
    // Add any enumerators that have not yet been mentioned.
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Expression));
    Results.EnterNewScope();
    for (EnumConstantDecl /*P*/ E : Enum.enumerators()) {
      if ((EnumeratorsSeen.count(E) != 0)) {
        continue;
      }
      
      CodeCompletionResult R/*J*/= new CodeCompletionResult(E, CCP_EnumInCase, Qualifier);
      Results.AddResult(new CodeCompletionResult(R), $this().CurContext, (NamedDecl /*P*/ )null, false);
    }
    Results.ExitScope();
    
    //We need to make sure we're setting the right context, 
    //so only say we include macros if the code completer says we do
     CodeCompletionContext.Kind kind = CodeCompletionContext.Kind.CCC_Other;
    if ($this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, false);
      kind = CodeCompletionContext.Kind.CCC_OtherWithMacros;
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(kind), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteCall">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4014,
 FQN="clang::Sema::CodeCompleteCall", NM="_ZN5clang4Sema16CodeCompleteCallEPNS_5ScopeEPNS_4ExprEN4llvm8ArrayRefIS4_EE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema16CodeCompleteCallEPNS_5ScopeEPNS_4ExprEN4llvm8ArrayRefIS4_EE")
//</editor-fold>
public final void CodeCompleteCall(Scope /*P*/ S, Expr /*P*/ Fn, ArrayRef<Expr /*P*/ > Args) {
  OverloadCandidateSet CandidateSet = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    // When we're code-completing for a call, we fall back to ordinary
    // name code-completion whenever we can't produce specific
    // results. We may want to revisit this strategy in the future,
    // e.g., by merging the two kinds of results.
    
    // FIXME: Provide support for variadic template functions.
    
    // Ignore type-dependent call expressions entirely.
    if (!(Fn != null) || Fn.isTypeDependent() || anyNullArguments(new ArrayRef<Expr /*P*/ >(Args))
       || Expr.hasAnyTypeDependentArguments(new ArrayRef<Expr /*P*/ >(Args))) {
      $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_Expression);
      return;
    }
    
    // Build an overload candidate set based on the functions we find.
    SourceLocation Loc = Fn.getExprLoc();
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(Loc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    
    SmallVector<CodeCompleteConsumer.OverloadCandidate> Results/*J*/= new SmallVector<CodeCompleteConsumer.OverloadCandidate>(8, new CodeCompleteConsumer.OverloadCandidate());
    
    Expr /*P*/ NakedFn = Fn.IgnoreParenCasts();
    {
      UnresolvedLookupExpr /*P*/ ULE = dyn_cast_UnresolvedLookupExpr(NakedFn);
      if ((ULE != null)) {
        $this().AddOverloadedCallCandidates(ULE, new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
            /*PartialOverloading=*/ true);
      } else {
        UnresolvedMemberExpr /*P*/ UME = dyn_cast_UnresolvedMemberExpr(NakedFn);
        if ((UME != null)) {
          TemplateArgumentListInfo TemplateArgsBuffer = null;
          try {
            TemplateArgsBuffer/*J*/= new TemplateArgumentListInfo();
            TemplateArgumentListInfo /*P*/ TemplateArgs = null;
            if (UME.hasExplicitTemplateArgs()) {
              UME.copyTemplateArgumentsInto(TemplateArgsBuffer);
              TemplateArgs = $AddrOf(TemplateArgsBuffer);
            }
            SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 12, 1, UME.getBase(), (Expr /*P*/ )null);
            ArgExprs.append_T(Args.begin(), Args.end());
            UnresolvedSet Decls/*J*/= new UnresolvedSet(8);
            Decls.append(UME.decls_begin(), UME.decls_end());
            $this().AddFunctionCandidates(Decls, new ArrayRef<Expr /*P*/ >(ArgExprs, true), CandidateSet, TemplateArgs, 
                /*SuppressUsedConversions=*/ false, 
                /*PartialOverloading=*/ true);
          } finally {
            if (TemplateArgsBuffer != null) { TemplateArgsBuffer.$destroy(); }
          }
        } else {
          FunctionDecl /*P*/ FD = null;
          {
            MemberExpr /*P*/ MCE = dyn_cast_MemberExpr(NakedFn);
            if ((MCE != null)) {
              FD = dyn_cast_FunctionDecl(MCE.getMemberDecl());
            } else {
              DeclRefExpr /*P*/ DRE = dyn_cast_DeclRefExpr(NakedFn);
              if ((DRE != null)) {
                FD = dyn_cast_FunctionDecl(DRE.getDecl());
              }
            }
          }
          if ((FD != null)) { // We check whether it's a resolved function declaration.
            if (!$this().getLangOpts().CPlusPlus
               || !(FD.getType().$arrow().getAs(FunctionProtoType.class) != null)) {
              Results.push_back(new CodeCompleteConsumer.OverloadCandidate(FD));
            } else {
              $this().AddOverloadCandidate(FD, DeclAccessPair.make(FD, FD.getAccess()), 
                  new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
                  /*SuppressUsedConversions=*/ false, 
                  /*PartialOverloading=*/ true);
            }
          } else {
            CXXRecordDecl /*P*/ DC = NakedFn.getType().$arrow().getAsCXXRecordDecl();
            if ((DC != null)) {
              // If expression's type is CXXRecordDecl, it may overload the function
              // call operator, so we check if it does and add them as candidates.
              // A complete type is needed to lookup for member function call operators.
              if ($this().isCompleteType(new SourceLocation(Loc), NakedFn.getType())) {
                LookupResult R = null;
                try {
                  DeclarationName OpName = $this().Context.DeclarationNames.
                      getCXXOperatorName(OverloadedOperatorKind.OO_Call);
                  R/*J*/= new LookupResult(/*Deref*/$this(), new DeclarationName(OpName), new SourceLocation(Loc), LookupNameKind.LookupOrdinaryName);
                  $this().LookupQualifiedName(R, DC);
                  R.suppressDiagnostics();
                  SmallVector<Expr /*P*/ > ArgExprs/*J*/= new SmallVector<Expr /*P*/ >(JD$UInt_T$C$R.INSTANCE, 12, 1, NakedFn, (Expr /*P*/ )null);
                  ArgExprs.append_T(Args.begin(), Args.end());
                  $this().AddFunctionCandidates(R.asUnresolvedSet(), new ArrayRef<Expr /*P*/ >(ArgExprs, true), CandidateSet, 
                      /*ExplicitArgs=*/ (TemplateArgumentListInfo /*P*/ )null, 
                      /*SuppressUsedConversions=*/ false, 
                      /*PartialOverloading=*/ true);
                } finally {
                  if (R != null) { R.$destroy(); }
                }
              }
            } else {
              // Lastly we check whether expression's type is function pointer or
              // function.
              QualType T = NakedFn.getType();
              if (!T.$arrow().getPointeeType().isNull()) {
                T.$assignMove(T.$arrow().getPointeeType());
              }
              {
                
                /*const*/ FunctionProtoType /*P*/ FP = T.$arrow().getAs(FunctionProtoType.class);
                if ((FP != null)) {
                  if (!TooManyArguments(FP.getNumParams(), Args.size(), 
                      /*PartialOverloading=*/ true)
                     || FP.isVariadic()) {
                    Results.push_back(new CodeCompleteConsumer.OverloadCandidate(FP));
                  }
                } else {
                  /*const*/ FunctionType /*P*/ FT = T.$arrow().getAs(FunctionType.class);
                  if ((FT != null)) {
                    // No prototype and declaration, it may be a K & R style function.
                    Results.push_back(new CodeCompleteConsumer.OverloadCandidate(FT));
                  }
                }
              }
            }
          }
        }
      }
    }
    
    mergeCandidatesWithResults(/*Deref*/$this(), Results, CandidateSet, new SourceLocation(Loc));
    CodeCompleteOverloadResults(/*Deref*/$this(), S, new MutableArrayRef<CodeCompleteConsumer.OverloadCandidate>(Results, false), Args.size(), 
        !CandidateSet.empty());
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteConstructor">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4111,
 FQN="clang::Sema::CodeCompleteConstructor", NM="_ZN5clang4Sema23CodeCompleteConstructorEPNS_5ScopeENS_8QualTypeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema23CodeCompleteConstructorEPNS_5ScopeENS_8QualTypeENS_14SourceLocationEN4llvm8ArrayRefIPNS_4ExprEEE")
//</editor-fold>
public final void CodeCompleteConstructor(Scope /*P*/ S, QualType Type, SourceLocation Loc, 
                       ArrayRef<Expr /*P*/ > Args) {
  OverloadCandidateSet CandidateSet = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    // A complete type is needed to lookup for constructors.
    if (!$this().isCompleteType(new SourceLocation(Loc), new QualType(Type))) {
      return;
    }
    
    CXXRecordDecl /*P*/ RD = Type.$arrow().getAsCXXRecordDecl();
    if (!(RD != null)) {
      JavaCleaner $c$ = $createJavaCleaner();
      try {
        $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData(new QualType(Type)))); $c$.clean();
        return;
      } finally {
        $c$.$destroy();
      }
    }
    
    // FIXME: Provide support for member initializers.
    // FIXME: Provide support for variadic template constructors.
    CandidateSet/*J*/= new OverloadCandidateSet(new SourceLocation(Loc), OverloadCandidateSet.CandidateSetKind.CSK_Normal);
    
    for (NamedDecl /*P*/ C : $this().LookupConstructors(RD)) {
      {
        FunctionDecl /*P*/ FD = dyn_cast_FunctionDecl(C);
        if ((FD != null)) {
          $this().AddOverloadCandidate(FD, DeclAccessPair.make(FD, C.getAccess()), 
              new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
              /*SuppressUsedConversions=*/ false, 
              /*PartialOverloading=*/ true);
        } else {
          FunctionTemplateDecl /*P*/ FTD = dyn_cast_FunctionTemplateDecl(C);
          if ((FTD != null)) {
            $this().AddTemplateOverloadCandidate(FTD, 
                DeclAccessPair.make(FTD, C.getAccess()), 
                /*ExplicitTemplateArgs=*/ (TemplateArgumentListInfo /*P*/ )null, 
                new ArrayRef<Expr /*P*/ >(Args), CandidateSet, 
                /*SuppressUsedConversions=*/ false, 
                /*PartialOverloading=*/ true);
          }
        }
      }
    }
    
    SmallVector<CodeCompleteConsumer.OverloadCandidate> Results/*J*/= new SmallVector<CodeCompleteConsumer.OverloadCandidate>(8, new CodeCompleteConsumer.OverloadCandidate());
    mergeCandidatesWithResults(/*Deref*/$this(), Results, CandidateSet, new SourceLocation(Loc));
    CodeCompleteOverloadResults(/*Deref*/$this(), S, new MutableArrayRef<CodeCompleteConsumer.OverloadCandidate>(Results, false), Args.size());
  } finally {
    if (CandidateSet != null) { CandidateSet.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4152,
 FQN="clang::Sema::CodeCompleteInitializer", NM="_ZN5clang4Sema23CodeCompleteInitializerEPNS_5ScopeEPNS_4DeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema23CodeCompleteInitializerEPNS_5ScopeEPNS_4DeclE")
//</editor-fold>
public final void CodeCompleteInitializer(Scope /*P*/ S, Decl /*P*/ D) {
  JavaCleaner $c$ = $createJavaCleaner();
  try {
    ValueDecl /*P*/ VD = dyn_cast_or_null_ValueDecl(D);
    if (!(VD != null)) {
      $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_Expression);
      return;
    }
    
    $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData(VD.getType()))); $c$.clean();
  } finally {
    $c$.$destroy();
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteReturn">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4162,
 FQN="clang::Sema::CodeCompleteReturn", NM="_ZN5clang4Sema18CodeCompleteReturnEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema18CodeCompleteReturnEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteReturn(Scope /*P*/ S) {
  QualType ResultType/*J*/= new QualType();
  if (isa_BlockDecl($this().CurContext)) {
    {
      BlockScopeInfo /*P*/ BSI = $this().getCurBlock();
      if ((BSI != null)) {
        ResultType.$assign(BSI.ReturnType);
      }
    }
  } else {
    FunctionDecl /*P*/ Function = dyn_cast_FunctionDecl($this().CurContext);
    if ((Function != null)) {
      ResultType.$assignMove(Function.getReturnType());
    } else {
      ObjCMethodDecl /*P*/ Method = dyn_cast_ObjCMethodDecl($this().CurContext);
      if ((Method != null)) {
        ResultType.$assignMove(Method.getReturnType());
      }
    }
  }
  if (ResultType.isNull()) {
    $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_Expression);
  } else {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData(new QualType(ResultType)))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteAfterIf">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4178,
 FQN="clang::Sema::CodeCompleteAfterIf", NM="_ZN5clang4Sema19CodeCompleteAfterIfEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema19CodeCompleteAfterIfEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteAfterIf(Scope /*P*/ S) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  CodeCompletionBuilder Builder = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(mapCodeCompletionContext(/*Deref*/$this(), ParserCompletionContext.PCC_Statement)));
    Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryName);
    Results.EnterNewScope();
    
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    
    AddOrdinaryNameResults(ParserCompletionContext.PCC_Statement, S, /*Deref*/$this(), Results);
    
    // "else" block
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    Builder.AddTypedTextChunk($else);
    if (Results.includeCodePatterns()) {
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
      Builder.AddPlaceholderChunk($("statements"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
    }
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // "else if" block
    Builder.AddTypedTextChunk($else);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddTextChunk($if);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
    if ($this().getLangOpts().CPlusPlus) {
      Builder.AddPlaceholderChunk($("condition"));
    } else {
      Builder.AddPlaceholderChunk($("expression"));
    }
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    if (Results.includeCodePatterns()) {
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
      Builder.AddPlaceholderChunk($("statements"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
    }
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    Results.ExitScope();
    if ((S.getFnParent() != null)) {
      AddPrettyFunctionResults($this().getLangOpts(), Results);
    }
    if ($this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, false);
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteAssignmentRHS">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4238,
 FQN="clang::Sema::CodeCompleteAssignmentRHS", NM="_ZN5clang4Sema25CodeCompleteAssignmentRHSEPNS_5ScopeEPNS_4ExprE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema25CodeCompleteAssignmentRHSEPNS_5ScopeEPNS_4ExprE")
//</editor-fold>
public final void CodeCompleteAssignmentRHS(Scope /*P*/ S, Expr /*P*/ LHS) {
  if ((LHS != null)) {
    JavaCleaner $c$ = $createJavaCleaner();
    try {
      $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData(((/*static_cast*/Expr /*P*/ )(LHS)).getType()))); $c$.clean();
    } finally {
      $c$.$destroy();
    }
  } else {
    $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_Expression);
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteQualifiedId">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4245,
 FQN="clang::Sema::CodeCompleteQualifiedId", NM="_ZN5clang4Sema23CodeCompleteQualifiedIdEPNS_5ScopeERNS_12CXXScopeSpecEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema23CodeCompleteQualifiedIdEPNS_5ScopeERNS_12CXXScopeSpecEb")
//</editor-fold>
public final void CodeCompleteQualifiedId(Scope /*P*/ S, final CXXScopeSpec /*&*/ SS, 
                       boolean EnteringContext) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    if (!(SS.getScopeRep() != null) || !($this().CodeCompleter != null)) {
      return;
    }
    
    DeclContext /*P*/ Ctx = $this().computeDeclContext(SS, EnteringContext);
    if (!(Ctx != null)) {
      return;
    }
    
    // Try to instantiate any non-dependent declaration contexts before
    // we look in them.
    if (!$this().isDependentScopeSpecifier(SS) && $this().RequireCompleteDeclContext(SS, Ctx)) {
      return;
    }
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Name));
    Results.EnterNewScope();
    
    // The "template" keyword can follow "::" in the grammar, but only
    // put it into the grammar if the nested-name-specifier is dependent.
    NestedNameSpecifier /*P*/ NNS = SS.getScopeRep();
    if (!Results.empty() && NNS.isDependent()) {
      Results.AddResult(new CodeCompletionResult($template));
    }
    
    // Add calls to overridden virtual functions, if there are any.
    //
    // FIXME: This isn't wonderful, because we don't know whether we're actually
    // in a context that permits expressions. This is a general issue with
    // qualified-id completions.
    if (!EnteringContext) {
      MaybeAddOverrideCalls(/*Deref*/$this(), Ctx, Results);
    }
    Results.ExitScope();
    
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(Ctx, LookupNameKind.LookupOrdinaryName, Consumer);
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteUsing">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4287,
 FQN="clang::Sema::CodeCompleteUsing", NM="_ZN5clang4Sema17CodeCompleteUsingEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema17CodeCompleteUsingEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteUsing(Scope /*P*/ S) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PotentiallyQualifiedName), 
        /*AddrOf*//*FPtr*/ResultBuilder::IsNestedNameSpecifier);
    Results.EnterNewScope();
    
    // If we aren't in class scope, we could see the "namespace" keyword.
    if (!S.isClassScope()) {
      Results.AddResult(new CodeCompletionResult($namespace));
    }
    
    // After "using", we can see anything that would start a 
    // nested-name-specifier.
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PotentiallyQualifiedName), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteUsingDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4313,
 FQN="clang::Sema::CodeCompleteUsingDirective", NM="_ZN5clang4Sema26CodeCompleteUsingDirectiveEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteUsingDirectiveEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteUsingDirective(Scope /*P*/ S) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    // After "using namespace", we expect to see a namespace name or namespace
    // alias.
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Namespace), 
        /*AddrOf*//*FPtr*/ResultBuilder::IsNamespaceOrAlias);
    Results.EnterNewScope();
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Namespace), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteNamespaceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4333,
 FQN="clang::Sema::CodeCompleteNamespaceDecl", NM="_ZN5clang4Sema25CodeCompleteNamespaceDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema25CodeCompleteNamespaceDeclEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteNamespaceDecl(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    DeclContext /*P*/ Ctx = S.getEntity();
    if (!(S.getParent() != null)) {
      Ctx = $this().Context.getTranslationUnitDecl();
    }
    
    boolean SuppressedGlobalResults = (Ctx != null) && !$this().CodeCompleter.includeGlobals() && isa_TranslationUnitDecl(Ctx);
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(SuppressedGlobalResults ? CodeCompletionContext.Kind.CCC_Namespace : CodeCompletionContext.Kind.CCC_Other), 
        /*AddrOf*//*FPtr*/ResultBuilder::IsNamespace);
    if ((Ctx != null) && Ctx.isFileContext() && !SuppressedGlobalResults) {
      std.mapPtrPtr<NamespaceDecl /*P*/ , NamespaceDecl /*P*/ > OrigToLatest = null;
      try {
        // We only want to see those namespaces that have already been defined
        // within this scope, because its likely that the user is creating an
        // extended namespace declaration. Keep track of the most recent 
        // definition of each namespace.
        OrigToLatest/*J*/= new std.mapPtrPtr<NamespaceDecl /*P*/ , NamespaceDecl /*P*/ >();
        for (DeclContext.specific_decl_iterator<NamespaceDecl> NS/*J*/= new DeclContext.specific_decl_iterator<NamespaceDecl>(NamespaceDecl.class, Ctx.decls_begin()), 
                NSEnd/*J*/= new DeclContext.specific_decl_iterator<NamespaceDecl>(NamespaceDecl.class, Ctx.decls_end());
             $noteq_specific_decl_iterator$SpecificDecl$C(NS, NSEnd); NS.$preInc())  {
          OrigToLatest.$set(NS.$arrow().getOriginalNamespace(), NS.$star());
        }
        
        // Add the most recent definition (or extended definition) of each 
        // namespace to the list of results.
        Results.EnterNewScope();
        for (std.mapPtrPtr.iterator<NamespaceDecl /*P*/ , NamespaceDecl /*P*/> NS = OrigToLatest.begin(), 
            NSEnd = OrigToLatest.end();
             NS.$noteq(NSEnd); NS.$preInc())  {
          Results.AddResult(new CodeCompletionResult(NS.$arrow().second, Results.getBasePriority(NS.$arrow().second), 
                  (NestedNameSpecifier /*P*/ )null), 
              $this().CurContext, (NamedDecl /*P*/ )null, false);
        }
        Results.ExitScope();
      } finally {
        if (OrigToLatest != null) { OrigToLatest.$destroy(); }
      }
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteNamespaceAliasDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4381,
 FQN="clang::Sema::CodeCompleteNamespaceAliasDecl", NM="_ZN5clang4Sema30CodeCompleteNamespaceAliasDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema30CodeCompleteNamespaceAliasDeclEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteNamespaceAliasDecl(Scope /*P*/ S) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    // After "namespace", we expect to see a namespace or alias.
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Namespace), 
        /*AddrOf*//*FPtr*/ResultBuilder::IsNamespaceOrAlias);
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteOperatorName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4398,
 FQN="clang::Sema::CodeCompleteOperatorName", NM="_ZN5clang4Sema24CodeCompleteOperatorNameEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema24CodeCompleteOperatorNameEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteOperatorName(Scope /*P*/ S) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Type), 
        /*AddrOf*//*FPtr*/ResultBuilder::IsType);
    Results.EnterNewScope();
    if ((std.strcmp(/*KEEP_STR*/"new", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($new));
    }
    if ((std.strcmp(/*KEEP_STR*/"delete", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($delete));
    }
    if ((std.strcmp(/*KEEP_STR*/"new[]", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($new_LSQUARE_RSQUARE));
    }
    if ((std.strcmp(/*KEEP_STR*/"delete[]", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($delete_LSQUARE_RSQUARE));
    }
    if ((std.strcmp(/*KEEP_STR*/"+", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PLUS));
    }
    if ((std.strcmp(/*KEEP_STR*/"-", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($MINUS));
    }
    if ((std.strcmp(/*KEEP_STR*/"*", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($STAR));
    }
    if ((std.strcmp(/*KEEP_STR*/"/", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($SLASH));
    }
    if ((std.strcmp(/*KEEP_STR*/"%", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PERCENT));
    }
    if ((std.strcmp(/*KEEP_STR*/"^", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($CARET));
    }
    if ((std.strcmp(/*KEEP_STR*/"&", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($AMP));
    }
    if ((std.strcmp(/*KEEP_STR*/"|", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PIPE));
    }
    if ((std.strcmp(/*KEEP_STR*/"~", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($TILDE));
    }
    if ((std.strcmp(/*KEEP_STR*/"!", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($EXCLAIM));
    }
    if ((std.strcmp(/*KEEP_STR*/"=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"<", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($LT));
    }
    if ((std.strcmp(/*KEEP_STR*/">", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($GT));
    }
    if ((std.strcmp(/*KEEP_STR*/"+=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PLUS_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"-=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($MINUS_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"*=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($STAR_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"/=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($SLASH_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"%=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PERCENT_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"^=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($CARET_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"&=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($AMP_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"|=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PIPE_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"<<", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($LT_LT));
    }
    if ((std.strcmp(/*KEEP_STR*/">>", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($GT_GT));
    }
    if ((std.strcmp(/*KEEP_STR*/"<<=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($LT_LT_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/">>=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($GT_GT_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"==", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($EQ_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"!=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($EXCLAIM_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"<=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($LT_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/">=", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($GT_EQ));
    }
    if ((std.strcmp(/*KEEP_STR*/"&&", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($AMP_AMP));
    }
    if ((std.strcmp(/*KEEP_STR*/"||", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PIPE_PIPE));
    }
    if ((std.strcmp(/*KEEP_STR*/"++", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($PLUS_PLUS));
    }
    if ((std.strcmp(/*KEEP_STR*/"--", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($MINUS_MINUS));
    }
    if ((std.strcmp(/*KEEP_STR*/",", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($COMMA));
    }
    if ((std.strcmp(/*KEEP_STR*/"->*", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($ARROW_STAR));
    }
    if ((std.strcmp(/*KEEP_STR*/"->", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($ARROW));
    }
    if ((std.strcmp(/*KEEP_STR*/"()", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($LPAREN_RPAREN));
    }
    if ((std.strcmp(/*KEEP_STR*/"[]", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($LSQUARE_RSQUARE));
    }
    // ?: can *not* be overloaded, but we need the overload
    // resolution machinery for it.
    if ((std.strcmp(/*KEEP_STR*/"?", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($QMARK));
    }
    if ((std.strcmp(/*KEEP_STR*/"co_await", /*KEEP_STR*/"?") != 0)) {
      Results.AddResult(new CodeCompletionResult($co_await));
    }
    
    // Add any type names visible from the current scope
    Results.allowNestedNameSpecifiers();
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    
    // Add any type specifiers
    AddTypeSpecifierResults($this().getLangOpts(), Results);
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Type), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteConstructorInitializer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4430,
 FQN="clang::Sema::CodeCompleteConstructorInitializer", NM="_ZN5clang4Sema34CodeCompleteConstructorInitializerEPNS_4DeclEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema34CodeCompleteConstructorInitializerEPNS_4DeclEN4llvm8ArrayRefIPNS_18CXXCtorInitializerEEE")
//</editor-fold>
public final void CodeCompleteConstructorInitializer(Decl /*P*/ ConstructorD, 
                                  ArrayRef<CXXCtorInitializer /*P*/ > Initializers) {
  ResultBuilder Results = null;
  CodeCompletionBuilder Builder = null;
  try {    
    if (!(ConstructorD != null)) {
      return;
    }
    
    type$ref<Decl> ConstructorD_Ptr = create_type$ref(ConstructorD);
    $this().AdjustDeclIfTemplate(ConstructorD_Ptr);
    ConstructorD = ConstructorD_Ptr.$deref();
    
    CXXConstructorDecl /*P*/ Constructor = dyn_cast_CXXConstructorDecl(ConstructorD);
    if (!(Constructor != null)) {
      return;
    }
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PotentiallyQualifiedName));
    Results.EnterNewScope();
    
    // Fill in any already-initialized fields or base classes.
    SmallPtrSet<FieldDecl /*P*/ > InitializedFields/*J*/= new SmallPtrSet<FieldDecl /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    SmallPtrSet<CanQual<Type>> InitializedBases/*J*/= new SmallPtrSet<CanQual<Type>>(DenseMapInfoCanQual$Type.$Info(), 4);
    for (/*uint*/int I = 0, E = Initializers.size(); I != E; ++I) {
      if (Initializers.$at(I).isBaseInitializer()) {
        InitializedBases.insert($this().Context.getCanonicalType(new QualType(Initializers.$at(I).getBaseClass(), 0)));
      } else {
        InitializedFields.insert(cast_FieldDecl(Initializers.$at(I).getAnyMember()));
      }
    }
    
    // Add completions for base classes.
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    PrintingPolicy Policy = getCompletionPrintingPolicy(/*Deref*/$this());
    boolean SawLastInitializer = Initializers.empty();
    CXXRecordDecl /*P*/ ClassDecl = Constructor.getParent();
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.bases()) {
      if (!InitializedBases.insert($this().Context.getCanonicalType(Base.getType())).
          second) {
        SawLastInitializer
           = !Initializers.empty()
           && Initializers.back().isBaseInitializer()
           && $this().Context.hasSameUnqualifiedType(Base.getType(), 
            new QualType(Initializers.back().getBaseClass(), 0));
        continue;
      }
      
      Builder.AddTypedTextChunk(Results.getAllocator().CopyString(new Twine(Base.getType().getAsString(Policy))));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      Builder.AddPlaceholderChunk($("args"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
              SawLastInitializer ? CCP_NextInitializer : CCP_MemberDeclaration));
      SawLastInitializer = false;
    }
    
    // Add completions for virtual base classes.
    for (final /*const*/ CXXBaseSpecifier /*&*/ Base : ClassDecl.vbases()) {
      if (!InitializedBases.insert($this().Context.getCanonicalType(Base.getType())).
          second) {
        SawLastInitializer
           = !Initializers.empty()
           && Initializers.back().isBaseInitializer()
           && $this().Context.hasSameUnqualifiedType(Base.getType(), 
            new QualType(Initializers.back().getBaseClass(), 0));
        continue;
      }
      
      Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Base.getType().getAsString(Policy))));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      Builder.AddPlaceholderChunk($("args"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
              SawLastInitializer ? CCP_NextInitializer : CCP_MemberDeclaration));
      SawLastInitializer = false;
    }
    
    // Add completions for members.
    for (FieldDecl /*P*/ Field : ClassDecl.fields()) {
      if (!InitializedFields.insert(cast_FieldDecl(Field.getCanonicalDecl())).
          second) {
        SawLastInitializer
           = !Initializers.empty()
           && Initializers.back().isAnyMemberInitializer()
           && Initializers.back().getAnyMember() == Field;
        continue;
      }
      if (!Field.getDeclName().$bool()) {
        continue;
      }
      
      Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Field.getIdentifier().getName())));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
      Builder.AddPlaceholderChunk($("args"));
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
              SawLastInitializer ? CCP_NextInitializer : CCP_MemberDeclaration, 
              CXCursorKind.CXCursor_MemberRef, 
              CXAvailabilityKind.CXAvailability_Available, 
              Field));
      SawLastInitializer = false;
    }
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteLambdaIntroducer">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4554,
 FQN="clang::Sema::CodeCompleteLambdaIntroducer", NM="_ZN5clang4Sema28CodeCompleteLambdaIntroducerEPNS_5ScopeERNS_16LambdaIntroducerEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema28CodeCompleteLambdaIntroducerEPNS_5ScopeERNS_16LambdaIntroducerEb")
//</editor-fold>
public final void CodeCompleteLambdaIntroducer(Scope /*P*/ S, final LambdaIntroducer /*&*/ Intro, 
                            boolean AfterAmpersand) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    
    // Note what has already been captured.
    SmallPtrSet<IdentifierInfo /*P*/ > Known/*J*/= new SmallPtrSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 4);
    boolean IncludedThis = false;
    for (final /*const*/ LambdaIntroducer.LambdaCapture /*&*/ C : Intro.Captures) {
      if (C.Kind == LambdaCaptureKind.LCK_This) {
        IncludedThis = true;
        continue;
      }
      
      Known.insert(C.Id);
    }
    
    // Look for other capturable variables.
    for (; (S != null) && !isNamespaceScope(S); S = S.getParent()) {
      for (/*const*/ Decl /*P*/ D : S.decls()) {
        /*const*/ VarDecl /*P*/ Var = dyn_cast_VarDecl(D);
        if (!(Var != null)
           || !Var.hasLocalStorage()
           || Var.hasAttr(BlocksAttr.class)) {
          continue;
        }
        if (Known.insert(Var.getIdentifier()).second) {
          Results.AddResult(new CodeCompletionResult(Var, CCP_LocalDeclaration), 
              $this().CurContext, (NamedDecl /*P*/ )null, false);
        }
      }
    }
    
    // Add 'this', if it would be valid.
    if (!IncludedThis && !AfterAmpersand && Intro.Default != LambdaCaptureDefault.LCD_ByCopy) {
      addThisCompletion(/*Deref*/$this(), Results);
    }
    
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCAtDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4696,
 FQN="clang::Sema::CodeCompleteObjCAtDirective", NM="_ZN5clang4Sema27CodeCompleteObjCAtDirectiveEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema27CodeCompleteObjCAtDirectiveEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCAtDirective(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    if (isa_ObjCImplDecl($this().CurContext)) {
      AddObjCImplementationResults($this().getLangOpts(), Results, false);
    } else if ($this().CurContext.isObjCContainer()) {
      AddObjCInterfaceResults($this().getLangOpts(), Results, false);
    } else {
      AddObjCTopLevelResults(Results, false);
    }
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCAtVisibility">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4835,
 FQN="clang::Sema::CodeCompleteObjCAtVisibility", NM="_ZN5clang4Sema28CodeCompleteObjCAtVisibilityEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema28CodeCompleteObjCAtVisibilityEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCAtVisibility(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    AddObjCVisibilityResults($this().getLangOpts(), Results, false);
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCAtStatement">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4847,
 FQN="clang::Sema::CodeCompleteObjCAtStatement", NM="_ZN5clang4Sema27CodeCompleteObjCAtStatementEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema27CodeCompleteObjCAtStatementEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCAtStatement(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    AddObjCStatementResults(Results, false);
    AddObjCExpressionResults(Results, false);
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCAtExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4860,
 FQN="clang::Sema::CodeCompleteObjCAtExpression", NM="_ZN5clang4Sema28CodeCompleteObjCAtExpressionEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema28CodeCompleteObjCAtExpressionEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCAtExpression(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    AddObjCExpressionResults(Results, false);
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCPropertyFlags">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 4905,
 FQN="clang::Sema::CodeCompleteObjCPropertyFlags", NM="_ZN5clang4Sema29CodeCompleteObjCPropertyFlagsEPNS_5ScopeERNS_12ObjCDeclSpecE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema29CodeCompleteObjCPropertyFlagsEPNS_5ScopeERNS_12ObjCDeclSpecE")
//</editor-fold>
public final void CodeCompleteObjCPropertyFlags(Scope /*P*/ S, final ObjCDeclSpec /*&*/ ODS) {
  ResultBuilder Results = null;
  try {
    if (!($this().CodeCompleter != null)) {
      return;
    }
    
    /*uint*/int Attributes = ODS.getPropertyAttributes();
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readonly)) {
      Results.AddResult(new CodeCompletionResult($("readonly")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_assign)) {
      Results.AddResult(new CodeCompletionResult($("assign")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, 
        ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_unsafe_unretained)) {
      Results.AddResult(new CodeCompletionResult($("unsafe_unretained")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_readwrite)) {
      Results.AddResult(new CodeCompletionResult($("readwrite")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_retain)) {
      Results.AddResult(new CodeCompletionResult($("retain")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_strong)) {
      Results.AddResult(new CodeCompletionResult($("strong")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_copy)) {
      Results.AddResult(new CodeCompletionResult($("copy")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nonatomic)) {
      Results.AddResult(new CodeCompletionResult($("nonatomic")));
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_atomic)) {
      Results.AddResult(new CodeCompletionResult($("atomic")));
    }
    
    // Only suggest "weak" if we're compiling for ARC-with-weak-references or GC.
    if ($this().getLangOpts().ObjCWeak || $this().getLangOpts().getGC() != LangOptions.GCMode.NonGC) {
      if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_weak)) {
        Results.AddResult(new CodeCompletionResult($("weak")));
      }
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_setter)) {
      CodeCompletionBuilder Setter = null;
      try {
        Setter/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
            Results.getCodeCompletionTUInfo());
        Setter.AddTypedTextChunk($("setter"));
        Setter.AddTextChunk($EQ);
        Setter.AddPlaceholderChunk($("method"));
        Results.AddResult(new CodeCompletionResult(Setter.TakeString()));
      } finally {
        if (Setter != null) { Setter.$destroy(); }
      }
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_getter)) {
      CodeCompletionBuilder Getter = null;
      try {
        Getter/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
            Results.getCodeCompletionTUInfo());
        Getter.AddTypedTextChunk($("getter"));
        Getter.AddTextChunk($EQ);
        Getter.AddPlaceholderChunk($("method"));
        Results.AddResult(new CodeCompletionResult(Getter.TakeString()));
      } finally {
        if (Getter != null) { Getter.$destroy(); }
      }
    }
    if (!ObjCPropertyFlagConflicts(Attributes, ObjCDeclSpec.ObjCPropertyAttributeKind.DQ_PR_nullability)) {
      Results.AddResult(new CodeCompletionResult($nonnull));
      Results.AddResult(new CodeCompletionResult($nullable));
      Results.AddResult(new CodeCompletionResult($null_unspecified));
      Results.AddResult(new CodeCompletionResult($("null_resettable")));
    }
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCPropertyGetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5127,
 FQN="clang::Sema::CodeCompleteObjCPropertyGetter", NM="_ZN5clang4Sema30CodeCompleteObjCPropertyGetterEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema30CodeCompleteObjCPropertyGetterEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCPropertyGetter(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    // Try to find the interface where getters might live.
    ObjCInterfaceDecl /*P*/ Class = dyn_cast_or_null_ObjCInterfaceDecl($this().CurContext);
    if (!(Class != null)) {
      {
        ObjCCategoryDecl /*P*/ Category = dyn_cast_or_null_ObjCCategoryDecl($this().CurContext);
        if ((Category != null)) {
          Class = Category.getClassInterface();
        }
      }
      if (!(Class != null)) {
        return;
      }
    }
    
    // Find all of the potential getters.
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    
    SmallPtrSet<Selector> Selectors/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 16);
    AddObjCMethods(Class, true, ObjCMethodKind.MK_ZeroArgSelector, new ArrayRef<IdentifierInfo /*P*/ >(None, true), $this().CurContext, Selectors, 
        /*AllowSameLength=*/ true, Results);
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCPropertySetter">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5154,
 FQN="clang::Sema::CodeCompleteObjCPropertySetter", NM="_ZN5clang4Sema30CodeCompleteObjCPropertySetterEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema30CodeCompleteObjCPropertySetterEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCPropertySetter(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    // Try to find the interface where setters might live.
    ObjCInterfaceDecl /*P*/ Class = dyn_cast_or_null_ObjCInterfaceDecl($this().CurContext);
    if (!(Class != null)) {
      {
        ObjCCategoryDecl /*P*/ Category = dyn_cast_or_null_ObjCCategoryDecl($this().CurContext);
        if ((Category != null)) {
          Class = Category.getClassInterface();
        }
      }
      if (!(Class != null)) {
        return;
      }
    }
    
    // Find all of the potential getters.
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    
    SmallPtrSet<Selector> Selectors/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 16);
    AddObjCMethods(Class, true, ObjCMethodKind.MK_OneArgSelector, new ArrayRef<IdentifierInfo /*P*/ >(None, true), $this().CurContext, 
        Selectors, /*AllowSameLength=*/ true, Results);
    
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCPassingType">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5183,
 FQN="clang::Sema::CodeCompleteObjCPassingType", NM="_ZN5clang4Sema27CodeCompleteObjCPassingTypeEPNS_5ScopeERNS_12ObjCDeclSpecEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema27CodeCompleteObjCPassingTypeEPNS_5ScopeERNS_12ObjCDeclSpecEb")
//</editor-fold>
public final void CodeCompleteObjCPassingType(Scope /*P*/ S, final ObjCDeclSpec /*&*/ DS, 
                           boolean IsParameter) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Type));
    Results.EnterNewScope();
    
    // Add context-sensitive, Objective-C parameter-passing keywords.
    boolean AddedInOut = false;
    if ((DS.getObjCDeclQualifier()
       & (ObjCDeclSpec.ObjCDeclQualifier.DQ_In | ObjCDeclSpec.ObjCDeclQualifier.DQ_Inout)) == 0) {
      Results.AddResult(new CodeCompletionResult($("in")));
      Results.AddResult(new CodeCompletionResult($("inout")));
      AddedInOut = true;
    }
    if ((DS.getObjCDeclQualifier()
       & (ObjCDeclSpec.ObjCDeclQualifier.DQ_Out | ObjCDeclSpec.ObjCDeclQualifier.DQ_Inout)) == 0) {
      Results.AddResult(new CodeCompletionResult($("out")));
      if (!AddedInOut) {
        Results.AddResult(new CodeCompletionResult($("inout")));
      }
    }
    if ((DS.getObjCDeclQualifier()
       & (ObjCDeclSpec.ObjCDeclQualifier.DQ_Bycopy | ObjCDeclSpec.ObjCDeclQualifier.DQ_Byref
       | ObjCDeclSpec.ObjCDeclQualifier.DQ_Oneway)) == 0) {
      Results.AddResult(new CodeCompletionResult($("bycopy")));
      Results.AddResult(new CodeCompletionResult($("byref")));
      Results.AddResult(new CodeCompletionResult($("oneway")));
    }
    if ((DS.getObjCDeclQualifier() & ObjCDeclSpec.ObjCDeclQualifier.DQ_CSNullability) == 0) {
      Results.AddResult(new CodeCompletionResult($nonnull));
      Results.AddResult(new CodeCompletionResult($nullable));
      Results.AddResult(new CodeCompletionResult($null_unspecified));
    }
    
    // If we're completing the return type of an Objective-C method and the 
    // identifier IBAction refers to a macro, provide a completion item for
    // an action, e.g.,
    //   IBAction)<#selector#>:(id)sender
    if (DS.getObjCDeclQualifier() == 0 && !IsParameter
       && $this().PP.isMacroDefined(new StringRef(/*KEEP_STR*/"IBAction"))) {
      CodeCompletionBuilder Builder = null;
      try {
        Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
            Results.getCodeCompletionTUInfo(), 
            CCP_CodePattern, CXAvailabilityKind.CXAvailability_Available);
        Builder.AddTypedTextChunk($("IBAction"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddPlaceholderChunk($("selector"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Colon);
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
        Builder.AddTextChunk($("id"));
        Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
        Builder.AddTextChunk($("sender"));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
    
    // If we're completing the return type, provide 'instancetype'.
    if (!IsParameter) {
      Results.AddResult(new CodeCompletionResult($("instancetype")));
    }
    
    // Add various builtin type names and specifiers.
    AddOrdinaryNameResults(ParserCompletionContext.PCC_Type, S, /*Deref*/$this(), Results);
    Results.ExitScope();
    
    // Add the various type names
    Results.setFilter(/*AddrOf*//*FPtr*/ResultBuilder::IsOrdinaryNonValueName);
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    if ($this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, false);
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Type), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCMessageReceiver">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5452,
 FQN="clang::Sema::CodeCompleteObjCMessageReceiver", NM="_ZN5clang4Sema31CodeCompleteObjCMessageReceiverEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema31CodeCompleteObjCMessageReceiverEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCMessageReceiver(Scope /*P*/ S) {
  ResultBuilder Results = null;
  CodeCompletionDeclConsumer Consumer = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCMessageReceiver), 
        $this().getLangOpts().CPlusPlus11 ? /*AddrOf*//*FPtr*/ResultBuilder::IsObjCMessageReceiverOrLambdaCapture : /*AddrOf*//*FPtr*/ResultBuilder::IsObjCMessageReceiver);
    
    Consumer/*J*/= new CodeCompletionDeclConsumer(Results, $this().CurContext);
    Results.EnterNewScope();
    $this().LookupVisibleDecls(S, LookupNameKind.LookupOrdinaryName, Consumer, 
        $this().CodeCompleter.includeGlobals());
    {
      
      // If we are in an Objective-C method inside a class that has a superclass,
      // add "super" as an option.
      ObjCMethodDecl /*P*/ Method = $this().getCurMethodDecl();
      if ((Method != null)) {
        {
          ObjCInterfaceDecl /*P*/ Iface = Method.getClassInterface();
          if ((Iface != null)) {
            if ((Iface.getSuperClass() != null)) {
              Results.AddResult(new CodeCompletionResult($("super")));
              
              AddSuperSendCompletion(/*Deref*/$this(), /*NeedSuperKeyword=*/ true, new ArrayRef<IdentifierInfo /*P*/ >(None, true), Results);
            }
          }
        }
      }
    }
    if ($this().getLangOpts().CPlusPlus11) {
      addThisCompletion(/*Deref*/$this(), Results);
    }
    
    Results.ExitScope();
    if ($this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, false);
    }
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Consumer != null) { Consumer.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCSuperMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5488,
 FQN="clang::Sema::CodeCompleteObjCSuperMessage", NM="_ZN5clang4Sema28CodeCompleteObjCSuperMessageEPNS_5ScopeENS_14SourceLocationEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema28CodeCompleteObjCSuperMessageEPNS_5ScopeENS_14SourceLocationEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEb")
//</editor-fold>
public final void CodeCompleteObjCSuperMessage(Scope /*P*/ S, SourceLocation SuperLoc, 
                            ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                            boolean AtArgumentExpression) {
  ObjCInterfaceDecl /*P*/ CDecl = null;
  {
    ObjCMethodDecl /*P*/ CurMethod = $this().getCurMethodDecl();
    if ((CurMethod != null)) {
      // Figure out which interface we're in.
      CDecl = CurMethod.getClassInterface();
      if (!(CDecl != null)) {
        return;
      }
      
      // Find the superclass of this class.
      CDecl = CDecl.getSuperClass();
      if (!(CDecl != null)) {
        return;
      }
      if (CurMethod.isInstanceMethod()) {
        // We are inside an instance method, which means that the message
        // send [super ...] is actually calling an instance method on the
        // current object.
        $this().CodeCompleteObjCInstanceMessage(S, (Expr /*P*/ )null, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
            AtArgumentExpression, 
            CDecl);
        /*JAVA:return*/return;
      }
      // Fall through to send to the superclass in CDecl.
    } else {
      // "super" may be the name of a type or variable. Figure out which
      // it is.
      IdentifierInfo /*P*/ Super = $this().getSuperIdentifier();
      NamedDecl /*P*/ ND = $this().LookupSingleName(S, new DeclarationName(Super), new SourceLocation(SuperLoc), 
          LookupNameKind.LookupOrdinaryName);
      if (((CDecl = dyn_cast_or_null_ObjCInterfaceDecl(ND)) != null)) {
        // "super" names an interface. Use it.
      } else {
        TypeDecl /*P*/ TD = dyn_cast_or_null_TypeDecl(ND);
        if ((TD != null)) {
          {
            /*const*/ ObjCObjectType /*P*/ Iface = $this().Context.getTypeDeclType(TD).$arrow().getAs(ObjCObjectType.class);
            if ((Iface != null)) {
              CDecl = Iface.getInterface();
            }
          }
        } else if ((ND != null) && isa_UnresolvedUsingTypenameDecl(ND)) {
          // "super" names an unresolved type; we can't be more specific.
        } else {
          CXXScopeSpec SS = null;
          try {
            // Assume that "super" names some kind of value and parse that way.
            SS/*J*/= new CXXScopeSpec();
            SourceLocation TemplateKWLoc/*J*/= new SourceLocation();
            UnqualifiedId id/*J*/= new UnqualifiedId();
            id.setIdentifier(Super, new SourceLocation(SuperLoc));
            ActionResultTTrue<Expr /*P*/ > SuperExpr = $this().ActOnIdExpression(S, SS, new SourceLocation(TemplateKWLoc), id, 
                false, false);
            $this().CodeCompleteObjCInstanceMessage(S, (Expr /*P*/ )SuperExpr.get(), 
                new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
                AtArgumentExpression);
            /*JAVA:return*/return;
          } finally {
            if (SS != null) { SS.$destroy(); }
          }
        }
      }
      // Fall through
    }
  }
  
  OpaquePtr<QualType> Receiver/*J*/= new OpaquePtr<QualType>();
  if ((CDecl != null)) {
    Receiver.$assignMove(OpaquePtr.<QualType>make($this().Context.getObjCInterfaceType(CDecl)));
  }
  $this().CodeCompleteObjCClassMessage(S, new OpaquePtr<QualType>(Receiver), new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
      AtArgumentExpression, 
      /*IsSuper=*/ true);
  /*JAVA:return*/return;
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCClassMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5663,
 FQN="clang::Sema::CodeCompleteObjCClassMessage", NM="_ZN5clang4Sema28CodeCompleteObjCClassMessageEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema28CodeCompleteObjCClassMessageEPNS_5ScopeENS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbb")
//</editor-fold>
public final void CodeCompleteObjCClassMessage(Scope /*P*/ S, OpaquePtr<QualType> Receiver, 
                            ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                            boolean AtArgumentExpression) {
  CodeCompleteObjCClassMessage(S, Receiver, 
                            SelIdents, 
                            AtArgumentExpression, 
                            false);
}
public final void CodeCompleteObjCClassMessage(Scope /*P*/ S, OpaquePtr<QualType> Receiver, 
                            ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                            boolean AtArgumentExpression, 
                            boolean IsSuper/*= false*/) {
  ResultBuilder Results = null;
  try {
    
    QualType T = $this().GetTypeFromParser(new OpaquePtr<QualType>(Receiver));
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCClassMessage, 
            new QualType(T), new ArrayRef<IdentifierInfo /*P*/ >(SelIdents)));
    
    AddClassMessageCompletions(/*Deref*/$this(), S, new OpaquePtr<QualType>(Receiver), new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
        AtArgumentExpression, IsSuper, Results);
    
    // If we're actually at the argument expression (rather than prior to the 
    // selector), we're actually performing code completion for an expression.
    // Determine whether we have a single, best method. If so, we can 
    // code-complete the expression using the corresponding parameter type as
    // our preferred type, improving completion results.
    if (AtArgumentExpression) {
      QualType PreferredType = getPreferredArgumentTypeForMessageSend(Results, 
          SelIdents.size());
      if (PreferredType.isNull()) {
        $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_Expression);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData(new QualType(PreferredType)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCInstanceMessage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5698,
 FQN="clang::Sema::CodeCompleteObjCInstanceMessage", NM="_ZN5clang4Sema31CodeCompleteObjCInstanceMessageEPNS_5ScopeEPNS_4ExprEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbPNS_17ObjCInterfaceDeclE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema31CodeCompleteObjCInstanceMessageEPNS_5ScopeEPNS_4ExprEN4llvm8ArrayRefIPNS_14IdentifierInfoEEEbPNS_17ObjCInterfaceDeclE")
//</editor-fold>
public final void CodeCompleteObjCInstanceMessage(Scope /*P*/ S, Expr /*P*/ Receiver, 
                               ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                               boolean AtArgumentExpression) {
  CodeCompleteObjCInstanceMessage(S, Receiver, 
                               SelIdents, 
                               AtArgumentExpression, 
                               (ObjCInterfaceDecl /*P*/ )null);
}
public final void CodeCompleteObjCInstanceMessage(Scope /*P*/ S, Expr /*P*/ Receiver, 
                               ArrayRef<IdentifierInfo /*P*/ > SelIdents, 
                               boolean AtArgumentExpression, 
                               ObjCInterfaceDecl /*P*/ Super/*= null*/) {
  ResultBuilder Results = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    
    Expr /*P*/ RecExpr = ((/*static_cast*/Expr /*P*/ )(Receiver));
    
    // If necessary, apply function/array conversion to the receiver.
    // C99 6.7.5.3p[7,8].
    if ((RecExpr != null)) {
      ActionResultTTrue<Expr /*P*/ > Conv = $this().DefaultFunctionArrayLvalueConversion(RecExpr);
      if (Conv.isInvalid()) { // conversion failed. bail.
        return;
      }
      RecExpr = Conv.get();
    }
    QualType ReceiverType = (RecExpr != null) ? RecExpr.getType() : (Super != null) ? $this().Context.getObjCObjectPointerType($this().Context.getObjCInterfaceType(Super)) : $this().Context.getObjCIdType();
    
    // If we're messaging an expression with type "id" or "Class", check
    // whether we know something special about the receiver that allows
    // us to assume a more-specific receiver type.
    if (ReceiverType.$arrow().isObjCIdType() || ReceiverType.$arrow().isObjCClassType()) {
      {
        ObjCInterfaceDecl /*P*/ IFace = GetAssumedMessageSendExprType(RecExpr);
        if ((IFace != null)) {
          if (ReceiverType.$arrow().isObjCClassType()) {
            $this().CodeCompleteObjCClassMessage(S, 
                OpaquePtr.<QualType>make($this().Context.getObjCInterfaceType(IFace)), 
                new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
                AtArgumentExpression, (Super != null));
            /*JAVA:return*/return;
          }
          
          ReceiverType.$assignMove($this().Context.getObjCObjectPointerType($this().Context.getObjCInterfaceType(IFace)));
        }
      }
    } else if ((RecExpr != null) && $this().getLangOpts().CPlusPlus) {
      ActionResultTTrue<Expr /*P*/ > Conv = $this().PerformContextuallyConvertToObjCPointer(RecExpr);
      if (Conv.isUsable()) {
        RecExpr = Conv.get();
        ReceiverType.$assignMove(RecExpr.getType());
      }
    }
    
    // Build the set of methods we can see.
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCInstanceMessage, 
            new QualType(ReceiverType), new ArrayRef<IdentifierInfo /*P*/ >(SelIdents)));
    
    Results.EnterNewScope();
    
    // If this is a send-to-super, try to add the special "super" send 
    // completion.
    if ((Super != null)) {
      {
        ObjCMethodDecl /*P*/ SuperMethod = AddSuperSendCompletion(/*Deref*/$this(), false, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), Results);
        if ((SuperMethod != null)) {
          Results.Ignore(SuperMethod);
        }
      }
    }
    {
      
      // If we're inside an Objective-C method definition, prefer its selector to
      // others.
      ObjCMethodDecl /*P*/ CurMethod = $this().getCurMethodDecl();
      if ((CurMethod != null)) {
        Results.setPreferredSelector(CurMethod.getSelector());
      }
    }
    
    // Keep track of the selectors we've already added.
    SmallPtrSet<Selector> Selectors/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 16);
    
    // Handle messages to Class. This really isn't a message to an instance
    // method, so we treat it the same way we would treat a message send to a
    // class method.
    if (ReceiverType.$arrow().isObjCClassType()
       || ReceiverType.$arrow().isObjCQualifiedClassType()) {
      {
        ObjCMethodDecl /*P*/ CurMethod = $this().getCurMethodDecl();
        if ((CurMethod != null)) {
          {
            ObjCInterfaceDecl /*P*/ ClassDecl = CurMethod.getClassInterface();
            if ((ClassDecl != null)) {
              AddObjCMethods(ClassDecl, false, ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
                  $this().CurContext, Selectors, AtArgumentExpression, Results);
            }
          }
        }
      }
    } else {
      // Handle messages to a qualified ID ("id<foo>").
      /*const*/ ObjCObjectPointerType /*P*/ QualID = ReceiverType.$arrow().getAsObjCQualifiedIdType();
      if ((QualID != null)) {
        // Search protocols for instance methods.
        for (ObjCProtocolDecl /*P*/ I : QualID.quals())  {
          AddObjCMethods(I, true, ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), $this().CurContext, 
              Selectors, AtArgumentExpression, Results);
        }
      } else {
        // Handle messages to a pointer to interface type.
        /*const*/ ObjCObjectPointerType /*P*/ IFacePtr = ReceiverType.$arrow().getAsObjCInterfacePointerType();
        if ((IFacePtr != null)) {
          // Search the class, its superclasses, etc., for instance methods.
          AddObjCMethods(IFacePtr.getInterfaceDecl(), true, ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), 
              $this().CurContext, Selectors, AtArgumentExpression, 
              Results);
          
          // Search protocols for instance methods.
          for (ObjCProtocolDecl /*P*/ I : IFacePtr.quals())  {
            AddObjCMethods(I, true, ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents), $this().CurContext, 
                Selectors, AtArgumentExpression, Results);
          }
        } else // Handle messages to "id".
        if (ReceiverType.$arrow().isObjCIdType()) {
          // We're messaging "id", so provide all instance methods we know
          // about as code-completion results.
          
          // If we have an external source, load the entire class method
          // pool from the AST file.
          if (($this().ExternalSource != null)) {
            for (/*uint32_t*/int I = 0, N = $this().ExternalSource.GetNumExternalSelectors();
                 I != N; ++I) {
              Selector Sel = $this().ExternalSource.GetExternalSelector(I);
              if (Sel.isNull() || ($this().MethodPool.count(Sel) != 0)) {
                continue;
              }
              
              $this().ReadMethodPool(new Selector(Sel));
            }
          }
          
          for (DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> M = $this().MethodPool.begin(), 
              MEnd = $this().MethodPool.end();
               M.$noteq(/*NO_ITER_COPY*/MEnd); M.$preInc()) {
            for (ObjCMethodList /*P*/ MethList = $AddrOf(M.$arrow().second.first);
                 (MethList != null) && (MethList.getMethod() != null);
                 MethList = MethList.getNext()) {
              if (!isAcceptableObjCMethod(MethList.getMethod(), ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents))) {
                continue;
              }
              if (!Selectors.insert(MethList.getMethod().getSelector()).second) {
                continue;
              }
              
              CodeCompletionResult R/*J*/= new CodeCompletionResult(MethList.getMethod(), 
                  Results.getBasePriority(MethList.getMethod()), (NestedNameSpecifier /*P*/ )null);
              R.StartParameter = SelIdents.size();
              R.AllParametersAreInformative = false;
              Results.MaybeAddResult(new CodeCompletionResult(R), $this().CurContext);
            }
          }
        }
      }
    }
    Results.ExitScope();
    
    // If we're actually at the argument expression (rather than prior to the 
    // selector), we're actually performing code completion for an expression.
    // Determine whether we have a single, best method. If so, we can 
    // code-complete the expression using the corresponding parameter type as
    // our preferred type, improving completion results.
    if (AtArgumentExpression) {
      QualType PreferredType = getPreferredArgumentTypeForMessageSend(Results, 
          SelIdents.size());
      if (PreferredType.isNull()) {
        $this().CodeCompleteOrdinaryName(S, ParserCompletionContext.PCC_Expression);
      } else {
        JavaCleaner $c$ = $createJavaCleaner();
        try {
          $this().CodeCompleteExpression(S, $c$.track(new CodeCompleteExpressionData(new QualType(PreferredType)))); $c$.clean();
        } finally {
          $c$.$destroy();
        }
      }
      return;
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCForCollection">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5858,
 FQN="clang::Sema::CodeCompleteObjCForCollection", NM="_ZN5clang4Sema29CodeCompleteObjCForCollectionEPNS_5ScopeENS_9OpaquePtrINS_12DeclGroupRefEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema29CodeCompleteObjCForCollectionEPNS_5ScopeENS_9OpaquePtrINS_12DeclGroupRefEEE")
//</editor-fold>
public final void CodeCompleteObjCForCollection(Scope /*P*/ S, 
                             OpaquePtr<DeclGroupRef> IterationVar) {
  CodeCompleteExpressionData Data = null;
  try {
    Data/*J*/= new CodeCompleteExpressionData();
    Data.ObjCCollection = true;
    if ((IterationVar.getAsOpaquePtr() != null)) {
      DeclGroupRef DG = IterationVar.getDeclGroupRef();
      for (type$ptr<Decl/*P*/>/*iterator*/ I = $tryClone(DG.begin()), /*P*/ /*P*/ End = $tryClone(DG.end()); $noteq_ptr(I, End); I.$preInc()) {
        if ((I.$star() != null)) {
          Data.IgnoreDecls.push_back(I.$star());
        }
      }
    }
    
    $this().CodeCompleteExpression(S, Data);
  } finally {
    if (Data != null) { Data.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCSelector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5874,
 FQN="clang::Sema::CodeCompleteObjCSelector", NM="_ZN5clang4Sema24CodeCompleteObjCSelectorEPNS_5ScopeEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema24CodeCompleteObjCSelectorEPNS_5ScopeEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE")
//</editor-fold>
public final void CodeCompleteObjCSelector(Scope /*P*/ S, 
                        ArrayRef<IdentifierInfo /*P*/ > SelIdents) {
  ResultBuilder Results = null;
  try {
    // If we have an external source, load the entire class method
    // pool from the AST file.
    if (($this().ExternalSource != null)) {
      for (/*uint32_t*/int I = 0, N = $this().ExternalSource.GetNumExternalSelectors();
           I != N; ++I) {
        Selector Sel = $this().ExternalSource.GetExternalSelector(I);
        if (Sel.isNull() || ($this().MethodPool.count(Sel) != 0)) {
          continue;
        }
        
        $this().ReadMethodPool(new Selector(Sel));
      }
    }
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_SelectorName));
    Results.EnterNewScope();
    for (DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> M = $this().MethodPool.begin(), 
        MEnd = $this().MethodPool.end();
         M.$noteq(/*NO_ITER_COPY*/MEnd); M.$preInc()) {
      CodeCompletionBuilder Builder = null;
      try {
        
        Selector Sel = new Selector(M.$arrow().first);
        if (!isAcceptableObjCSelector(new Selector(Sel), ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents))) {
          continue;
        }
        
        Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
            Results.getCodeCompletionTUInfo());
        if (Sel.isUnarySelector()) {
          Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Sel.getNameForSlot(0))));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
          continue;
        }
        
        std.string Accumulator/*J*/= new std.string();
        for (/*uint*/int I = 0, N = Sel.getNumArgs(); I != N; ++I) {
          if (I == SelIdents.size()) {
            if (!Accumulator.empty()) {
              Builder.AddInformativeChunk(Builder.getAllocator().CopyString(new Twine(Accumulator)));
              Accumulator.clear();
            }
          }
          
          $addassign_string_StringRef(Accumulator, Sel.getNameForSlot(I));
          Accumulator.$addassign_T($$COLON);
        }
        Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Accumulator)));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_SelectorName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCProtocolReferences">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5949,
 FQN="clang::Sema::CodeCompleteObjCProtocolReferences", NM="_ZN5clang4Sema34CodeCompleteObjCProtocolReferencesEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoENS_14SourceLocationEEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema34CodeCompleteObjCProtocolReferencesEN4llvm8ArrayRefISt4pairIPNS_14IdentifierInfoENS_14SourceLocationEEEE")
//</editor-fold>
public final void CodeCompleteObjCProtocolReferences(ArrayRef<std.pair<IdentifierInfo /*P*/ , SourceLocation>> Protocols) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCProtocolName));
    if (($this().CodeCompleter != null) && $this().CodeCompleter.includeGlobals()) {
      Results.EnterNewScope();
      
      // Tell the result set to ignore all of the protocols we have
      // already seen.
      // FIXME: This doesn't work when caching code-completion results.
      for (final /*const*/ std.pair<IdentifierInfo /*P*/ , SourceLocation> /*&*/ Pair : Protocols)  {
        {
          ObjCProtocolDecl /*P*/ Protocol = $this().LookupProtocol(Pair.first, 
              new SourceLocation(Pair.second));
          if ((Protocol != null)) {
            Results.Ignore(Protocol);
          }
        }
      }
      
      // Add all protocols.
      AddProtocolResults($this().Context.getTranslationUnitDecl(), $this().CurContext, false, 
          Results);
      
      Results.ExitScope();
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCProtocolName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCProtocolDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 5978,
 FQN="clang::Sema::CodeCompleteObjCProtocolDecl", NM="_ZN5clang4Sema28CodeCompleteObjCProtocolDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema28CodeCompleteObjCProtocolDeclEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCProtocolDecl(Scope /*P*/ $Prm0) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCProtocolName));
    if (($this().CodeCompleter != null) && $this().CodeCompleter.includeGlobals()) {
      Results.EnterNewScope();
      
      // Add all protocols.
      AddProtocolResults($this().Context.getTranslationUnitDecl(), $this().CurContext, true, 
          Results);
      
      Results.ExitScope();
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCProtocolName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCInterfaceDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6016,
 FQN="clang::Sema::CodeCompleteObjCInterfaceDecl", NM="_ZN5clang4Sema29CodeCompleteObjCInterfaceDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema29CodeCompleteObjCInterfaceDeclEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCInterfaceDecl(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    if ($this().CodeCompleter.includeGlobals()) {
      // Add all classes.
      AddInterfaceResults($this().Context.getTranslationUnitDecl(), $this().CurContext, false, 
          false, Results);
    }
    
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCInterfaceName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCSuperclass">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6035,
 FQN="clang::Sema::CodeCompleteObjCSuperclass", NM="_ZN5clang4Sema26CodeCompleteObjCSuperclassEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteObjCSuperclassEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final void CodeCompleteObjCSuperclass(Scope /*P*/ S, IdentifierInfo /*P*/ ClassName, 
                          SourceLocation ClassNameLoc) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCInterfaceName));
    Results.EnterNewScope();
    
    // Make sure that we ignore the class we're currently defining.
    NamedDecl /*P*/ CurClass = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassNameLoc), LookupNameKind.LookupOrdinaryName);
    if ((CurClass != null) && isa_ObjCInterfaceDecl(CurClass)) {
      Results.Ignore(CurClass);
    }
    if ($this().CodeCompleter.includeGlobals()) {
      // Add all classes.
      AddInterfaceResults($this().Context.getTranslationUnitDecl(), $this().CurContext, false, 
          false, Results);
    }
    
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCInterfaceName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCImplementationDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6061,
 FQN="clang::Sema::CodeCompleteObjCImplementationDecl", NM="_ZN5clang4Sema34CodeCompleteObjCImplementationDeclEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema34CodeCompleteObjCImplementationDeclEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCImplementationDecl(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    if ($this().CodeCompleter.includeGlobals()) {
      // Add all unimplemented classes.
      AddInterfaceResults($this().Context.getTranslationUnitDecl(), $this().CurContext, false, 
          true, Results);
    }
    
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCInterfaceName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCInterfaceCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6080,
 FQN="clang::Sema::CodeCompleteObjCInterfaceCategory", NM="_ZN5clang4Sema33CodeCompleteObjCInterfaceCategoryEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema33CodeCompleteObjCInterfaceCategoryEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final void CodeCompleteObjCInterfaceCategory(Scope /*P*/ S, 
                                 IdentifierInfo /*P*/ ClassName, 
                                 SourceLocation ClassNameLoc) {
  ResultBuilder Results = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCCategoryName));
    
    // Ignore any categories we find that have already been implemented by this
    // interface.
    SmallPtrSet<IdentifierInfo /*P*/ > CategoryNames/*J*/= new SmallPtrSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    NamedDecl /*P*/ CurClass = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassNameLoc), LookupNameKind.LookupOrdinaryName);
    {
      ObjCInterfaceDecl /*P*/ Class = dyn_cast_or_null_ObjCInterfaceDecl(CurClass);
      if ((Class != null)) {
        for (/*const*/ ObjCCategoryDecl /*P*/ Cat : Class.visible_categories())  {
          CategoryNames.insert(Cat.getIdentifier());
        }
      }
    }
    
    // Add all of the categories we know about.
    Results.EnterNewScope();
    TranslationUnitDecl /*P*/ TU = $this().Context.getTranslationUnitDecl();
    for (/*const*/ Decl /*P*/ D : TU.decls())  {
      {
        /*const*/ ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(D);
        if ((Category != null)) {
          if (CategoryNames.insert(Category.getIdentifier()).second) {
            Results.AddResult(new CodeCompletionResult(Category, Results.getBasePriority(Category), 
                    (NestedNameSpecifier /*P*/ )null), 
                $this().CurContext, (NamedDecl /*P*/ )null, false);
          }
        }
      }
    }
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCCategoryName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCImplementationCategory">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6115,
 FQN="clang::Sema::CodeCompleteObjCImplementationCategory", NM="_ZN5clang4Sema38CodeCompleteObjCImplementationCategoryEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema38CodeCompleteObjCImplementationCategoryEPNS_5ScopeEPNS_14IdentifierInfoENS_14SourceLocationE")
//</editor-fold>
public final void CodeCompleteObjCImplementationCategory(Scope /*P*/ S, 
                                      IdentifierInfo /*P*/ ClassName, 
                                      SourceLocation ClassNameLoc) {
  ResultBuilder Results = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    
    // Find the corresponding interface. If we couldn't find the interface, the
    // program itself is ill-formed. However, we'll try to be helpful still by
    // providing the list of all of the categories we know about.
    NamedDecl /*P*/ CurClass = $this().LookupSingleName($this().TUScope, new DeclarationName(ClassName), new SourceLocation(ClassNameLoc), LookupNameKind.LookupOrdinaryName);
    ObjCInterfaceDecl /*P*/ Class = dyn_cast_or_null_ObjCInterfaceDecl(CurClass);
    if (!(Class != null)) {
      $this().CodeCompleteObjCInterfaceCategory(S, ClassName, new SourceLocation(ClassNameLoc));
      /*JAVA:return*/return;
    }
    
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCCategoryName));
    
    // Add all of the categories that have have corresponding interface 
    // declarations in this class and any of its superclasses, except for
    // already-implemented categories in the class itself.
    SmallPtrSet<IdentifierInfo /*P*/ > CategoryNames/*J*/= new SmallPtrSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    Results.EnterNewScope();
    boolean IgnoreImplemented = true;
    while ((Class != null)) {
      for (/*const*/ ObjCCategoryDecl /*P*/ Cat : Class.visible_categories()) {
        if ((!IgnoreImplemented || !(Cat.getImplementation() != null))
           && CategoryNames.insert(Cat.getIdentifier()).second) {
          Results.AddResult(new CodeCompletionResult(Cat, Results.getBasePriority(Cat), (NestedNameSpecifier /*P*/ )null), 
              $this().CurContext, (NamedDecl /*P*/ )null, false);
        }
      }
      
      Class = Class.getSuperClass();
      IgnoreImplemented = false;
    }
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_ObjCCategoryName), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCPropertyDefinition">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6157,
 FQN="clang::Sema::CodeCompleteObjCPropertyDefinition", NM="_ZN5clang4Sema34CodeCompleteObjCPropertyDefinitionEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema34CodeCompleteObjCPropertyDefinitionEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteObjCPropertyDefinition(Scope /*P*/ S) {
  ResultBuilder Results = null;
  try {
    CodeCompletionContext CCContext/*J*/= new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other);
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        CCContext);
    
    // Figure out where this @synthesize lives.
    ObjCContainerDecl /*P*/ Container = dyn_cast_or_null_ObjCContainerDecl($this().CurContext);
    if (!(Container != null)
       || (!isa_ObjCImplementationDecl(Container)
       && !isa_ObjCCategoryImplDecl(Container))) {
      return;
    }
    
    // Ignore any properties that have already been implemented.
    Container = getContainerDef(Container);
    for (/*const*/ Decl /*P*/ D : Container.decls())  {
      {
        /*const*/ ObjCPropertyImplDecl /*P*/ PropertyImpl = dyn_cast_ObjCPropertyImplDecl(D);
        if ((PropertyImpl != null)) {
          Results.Ignore(PropertyImpl.getPropertyDecl());
        }
      }
    }
    
    // Add any properties that we find.
    SmallPtrSet<IdentifierInfo /*P*/ > AddedProperties/*J*/= new SmallPtrSet<IdentifierInfo /*P*/ >(DenseMapInfo$LikePtr.$Info(), 16);
    Results.EnterNewScope();
    {
      ObjCImplementationDecl /*P*/ ClassImpl = dyn_cast_ObjCImplementationDecl(Container);
      if ((ClassImpl != null)) {
        AddObjCProperties(CCContext, ClassImpl.getClassInterface(), false, 
            /*AllowNullaryMethods=*/ false, $this().CurContext, 
            AddedProperties, Results);
      } else {
        AddObjCProperties(CCContext, 
            cast_ObjCCategoryImplDecl(Container).getCategoryDecl(), 
            false, /*AllowNullaryMethods=*/ false, $this().CurContext, 
            AddedProperties, Results);
      }
    }
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCPropertySynthesizeIvar">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 6197,
 FQN="clang::Sema::CodeCompleteObjCPropertySynthesizeIvar", NM="_ZN5clang4Sema38CodeCompleteObjCPropertySynthesizeIvarEPNS_5ScopeEPNS_14IdentifierInfoE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema38CodeCompleteObjCPropertySynthesizeIvarEPNS_5ScopeEPNS_14IdentifierInfoE")
//</editor-fold>
public final void CodeCompleteObjCPropertySynthesizeIvar(Scope /*P*/ S, 
                                      IdentifierInfo /*P*/ PropertyName) {
  ResultBuilder Results = null;
  try {
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    
    // Figure out where this @synthesize lives.
    ObjCContainerDecl /*P*/ Container = dyn_cast_or_null_ObjCContainerDecl($this().CurContext);
    if (!(Container != null)
       || (!isa_ObjCImplementationDecl(Container)
       && !isa_ObjCCategoryImplDecl(Container))) {
      return;
    }
    
    // Figure out which interface we're looking into.
    ObjCInterfaceDecl /*P*/ Class = null;
    {
      ObjCImplementationDecl /*P*/ ClassImpl = dyn_cast_ObjCImplementationDecl(Container);
      if ((ClassImpl != null)) {
        Class = ClassImpl.getClassInterface();
      } else {
        Class = cast_ObjCCategoryImplDecl(Container).getCategoryDecl().
            getClassInterface();
      }
    }
    
    // Determine the type of the property we're synthesizing.
    QualType PropertyType = $this().Context.getObjCIdType();
    if ((Class != null)) {
      {
        ObjCPropertyDecl /*P*/ Property = Class.FindPropertyDeclaration(PropertyName, ObjCPropertyQueryKind.OBJC_PR_query_instance);
        if ((Property != null)) {
          PropertyType.$assignMove(
              Property.getType().getNonReferenceType().getUnqualifiedType()
          );
          
          // Give preference to ivars 
          Results.setPreferredType(new QualType(PropertyType));
        }
      }
    }
    
    // Add all of the instance variables in this class and its superclasses.
    Results.EnterNewScope();
    boolean SawSimilarlyNamedIvar = false;
    std.string NameWithPrefix/*J*/= new std.string();
    NameWithPrefix.$addassign_T($$UNDERSCORE);
    $addassign_string_StringRef(NameWithPrefix, PropertyName.getName());
    std.string NameWithSuffix = PropertyName.getName().str();
    NameWithSuffix.$addassign_T($$UNDERSCORE);
    for (; (Class != null); Class = Class.getSuperClass()) {
      for (ObjCIvarDecl /*P*/ Ivar = Class.all_declared_ivar_begin(); (Ivar != null);
           Ivar = Ivar.getNextIvar()) {
        Results.AddResult(new CodeCompletionResult(Ivar, Results.getBasePriority(Ivar), (NestedNameSpecifier /*P*/ )null), 
            $this().CurContext, (NamedDecl /*P*/ )null, false);
        
        // Determine whether we've seen an ivar with a name similar to the 
        // property.
        if ((PropertyName == Ivar.getIdentifier()
           || $eq_StringRef(new StringRef(NameWithPrefix), Ivar.getName())
           || $eq_StringRef(new StringRef(NameWithSuffix), Ivar.getName()))) {
          SawSimilarlyNamedIvar = true;
          
          // Reduce the priority of this result by one, to give it a slight
          // advantage over other results whose names don't match so closely.
          if ((Results.size() != 0)
             && Results.data().$at(Results.size() - 1).Kind
             == CodeCompletionResult.ResultKind.RK_Declaration
             && Results.data().$at(Results.size() - 1).Declaration == Ivar) {
            Results.data().$at(Results.size() - 1).Priority--;
          }
        }
      }
    }
    if (!SawSimilarlyNamedIvar) {
      CodeCompletionBuilder Builder = null;
      try {
        // Create ivar result _propName, that the user can use to synthesize
        // an ivar of the appropriate type.    
        /*uint*/int Priority = CCP_MemberDeclaration + 1;
        /*typedef CodeCompletionResult Result*/
//        final class Result extends CodeCompletionResult{ };
        final CodeCompletionAllocator /*&*/ Allocator = Results.getAllocator();
        Builder/*J*/= new CodeCompletionBuilder(Allocator, Results.getCodeCompletionTUInfo(), 
            Priority, CXAvailabilityKind.CXAvailability_Available);
        
        PrintingPolicy Policy = getCompletionPrintingPolicy(/*Deref*/$this());
        Builder.AddResultTypeChunk(GetCompletionTypeString(new QualType(PropertyType), $this().Context, 
                Policy, Allocator));
        Builder.AddTypedTextChunk(Allocator.CopyString(new Twine(NameWithPrefix)));
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), Priority, 
                CXCursorKind.CXCursor_ObjCIvarDecl));
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
    
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCMethodDecl">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7044,
 FQN="clang::Sema::CodeCompleteObjCMethodDecl", NM="_ZN5clang4Sema26CodeCompleteObjCMethodDeclEPNS_5ScopeEbNS_9OpaquePtrINS_8QualTypeEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema26CodeCompleteObjCMethodDeclEPNS_5ScopeEbNS_9OpaquePtrINS_8QualTypeEEE")
//</editor-fold>
public final void CodeCompleteObjCMethodDecl(Scope /*P*/ S, 
                          boolean IsInstanceMethod, 
                          OpaquePtr<QualType> ReturnTy) {
  ResultBuilder Results = null;
  try {
    // Determine the return type of the method we're declaring, if
    // provided.
    QualType ReturnType = GetTypeFromParser(new OpaquePtr<QualType>(ReturnTy));
    Decl /*P*/ IDecl = null;
    if ($this().CurContext.isObjCContainer()) {
      ObjCContainerDecl /*P*/ OCD = dyn_cast_ObjCContainerDecl($this().CurContext);
      IDecl = cast_Decl(OCD);
    }
    // Determine where we should start searching for methods.
    ObjCContainerDecl /*P*/ SearchDecl = null;
    boolean IsInImplementation = false;
    {
      Decl /*P*/ D = IDecl;
      if ((D != null)) {
        {
          ObjCImplementationDecl /*P*/ Impl = dyn_cast_ObjCImplementationDecl(D);
          if ((Impl != null)) {
            SearchDecl = Impl.getClassInterface();
            IsInImplementation = true;
          } else {
            ObjCCategoryImplDecl /*P*/ CatImpl = dyn_cast_ObjCCategoryImplDecl(D);
            if ((CatImpl != null)) {
              SearchDecl = CatImpl.getCategoryDecl();
              IsInImplementation = true;
            } else {
              SearchDecl = dyn_cast_ObjCContainerDecl(D);
            }
          }
        }
      }
    }
    if (!(SearchDecl != null) && (S != null)) {
      {
        DeclContext /*P*/ DC = S.getEntity();
        if ((DC != null)) {
          SearchDecl = dyn_cast_ObjCContainerDecl(DC);
        }
      }
    }
    if (!(SearchDecl != null)) {
      HandleCodeCompleteResults($this(), $this().CodeCompleter, 
          new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
          (type$ptr<CodeCompletionResult/*P*/> )null, 0);
      return;
    }
    
    // Find all of the methods that we could declare/implement here.
    DenseMap<Selector, PointerBoolPair<ObjCMethodDecl /*P*/ >> KnownMethods/*J*/= new DenseMap<Selector, PointerBoolPair<ObjCMethodDecl /*P*/ >>(DenseMapInfoSelector.$Info(), new PointerBoolPair<ObjCMethodDecl /*P*/ >());
    FindImplementableMethods($this().Context, SearchDecl, IsInstanceMethod, 
        new QualType(ReturnType), KnownMethods);
    
    // Add declarations or definitions for each of the known methods.
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    Results.EnterNewScope();
    PrintingPolicy Policy = getCompletionPrintingPolicy(/*Deref*/$this());
    for (DenseMapIterator<Selector, PointerBoolPair<ObjCMethodDecl /*P*/ >> M = KnownMethods.begin(), 
        MEnd = KnownMethods.end();
         M.$noteq(/*NO_ITER_COPY*/MEnd); M.$preInc()) {
      CodeCompletionBuilder Builder = null;
      try {
        ObjCMethodDecl /*P*/ Method = M.$arrow().second.getPointer();
        Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
            Results.getCodeCompletionTUInfo());
        
        // If the result type was not already provided, add it to the
        // pattern as (type).
        if (ReturnType.isNull()) {
          QualType ResTy = Method.getSendResultType().stripObjCKindOfType($this().Context);
          AttributedType.stripOuterNullability(ResTy);
          AddObjCPassingTypeChunk(new QualType(ResTy), 
              Method.getObjCDeclQualifier(), $this().Context, Policy, 
              Builder);
        }
        
        Selector Sel = Method.getSelector();
        
        // Add the first part of the selector to the pattern.
        Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Sel.getNameForSlot(0))));
        
        // Add parameters to the pattern.
        /*uint*/int I = 0;
        for (type$ptr<ParmVarDecl /*P*/ /*const*/ /*P*/> P = $tryClone(Method.param_begin()), 
            /*P*/ /*const*/ /*P*/ PEnd = $tryClone(Method.param_end());
             $noteq_ptr(P, PEnd); /*J:(void)*/P.$preInc() , ++I) {
          // Add the part of the selector name.
          if (I == 0) {
            Builder.AddTypedTextChunk($COLON);
          } else if ($less_uint(I, Sel.getNumArgs())) {
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
            Builder.AddTypedTextChunk(Builder.getAllocator().CopyString($add_StringRef$C_char$ptr$C(Sel.getNameForSlot(I), /*KEEP_STR*/$COLON)));
          } else {
            break;
          }
          
          // Add the parameter type.
          QualType ParamType/*J*/= new QualType();
          if ((((P.$star()).getObjCDeclQualifier() & Decl.ObjCDeclQualifier.OBJC_TQ_CSNullability) != 0)) {
            ParamType.$assignMove((P.$star()).getType());
          } else {
            ParamType.$assignMove((P.$star()).getOriginalType());
          }
          ParamType.$assignMove(ParamType.substObjCTypeArgs($this().Context, /*{ */new ArrayRef<QualType>(false)/* }*/, 
                  ObjCSubstitutionContext.Parameter));
          AttributedType.stripOuterNullability(ParamType);
          AddObjCPassingTypeChunk(new QualType(ParamType), 
              (P.$star()).getObjCDeclQualifier(), 
              $this().Context, Policy, 
              Builder);
          {
            
            IdentifierInfo /*P*/ Id = (P.$star()).getIdentifier();
            if ((Id != null)) {
              Builder.AddTextChunk(Builder.getAllocator().CopyString(new Twine(Id.getName())));
            }
          }
        }
        if (Method.isVariadic()) {
          if ($greater_uint(Method.param_size(), 0)) {
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_Comma);
          }
          Builder.AddTextChunk($ELLIPSIS);
        }
        if (IsInImplementation && Results.includeCodePatterns()) {
          // We will be defining the method here, so add a compound statement.
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftBrace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          if (!Method.getReturnType().$arrow().isVoidType()) {
            // If the result type is not void, add a return clause.
            Builder.AddTextChunk($return);
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
            Builder.AddPlaceholderChunk($("expression"));
            Builder.AddChunk(CodeCompletionString.ChunkKind.CK_SemiColon);
          } else {
            Builder.AddPlaceholderChunk($("statements"));
          }
          
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_VerticalSpace);
          Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightBrace);
        }
        
        /*uint*/int Priority = CCP_CodePattern;
        if (!M.$arrow().second.getInt()) {
          Priority += CCD_InBaseClass;
        }
        
        Results.AddResult(new CodeCompletionResult(Builder.TakeString(), Method, Priority));
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    }
    
    // Add Key-Value-Coding and Key-Value-Observing accessor methods for all of 
    // the properties in this class and its categories.
    if ($this().Context.getLangOpts().ObjC2) {
      SmallVector<ObjCContainerDecl /*P*/ > Containers/*J*/= new SmallVector<ObjCContainerDecl /*P*/ >(4, (ObjCContainerDecl /*P*/ )null);
      Containers.push_back(SearchDecl);
      
      SmallPtrSet<Selector> KnownSelectors/*J*/= new SmallPtrSet<Selector>(DenseMapInfoSelector.$Info(), 16);
      for (DenseMapIterator<Selector, PointerBoolPair<ObjCMethodDecl /*P*/ >> M = KnownMethods.begin(), 
          MEnd = KnownMethods.end();
           M.$noteq(/*NO_ITER_COPY*/MEnd); M.$preInc())  {
        KnownSelectors.insert(new Selector(M.$arrow().first));
      }
      
      ObjCInterfaceDecl /*P*/ IFace = dyn_cast_ObjCInterfaceDecl(SearchDecl);
      if (!(IFace != null)) {
        {
          ObjCCategoryDecl /*P*/ Category = dyn_cast_ObjCCategoryDecl(SearchDecl);
          if ((Category != null)) {
            IFace = Category.getClassInterface();
          }
        }
      }
      if ((IFace != null)) {
        for (ObjCCategoryDecl /*P*/ Cat : IFace.visible_categories())  {
          Containers.push_back(Cat);
        }
      }
      
      for (/*uint*/int I = 0, N = Containers.size(); I != N; ++I)  {
        for (ObjCPropertyDecl /*P*/ P : Containers.$at(I).instance_properties())  {
          AddObjCKeyValueCompletions(P, IsInstanceMethod, new QualType(ReturnType), $this().Context, 
              KnownSelectors, Results);
        }
      }
    }
    
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteObjCMethodDeclSelector">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7216,
 FQN="clang::Sema::CodeCompleteObjCMethodDeclSelector", NM="_ZN5clang4Sema34CodeCompleteObjCMethodDeclSelectorEPNS_5ScopeEbbNS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema34CodeCompleteObjCMethodDeclSelectorEPNS_5ScopeEbbNS_9OpaquePtrINS_8QualTypeEEEN4llvm8ArrayRefIPNS_14IdentifierInfoEEE")
//</editor-fold>
public final void CodeCompleteObjCMethodDeclSelector(Scope /*P*/ S, 
                                  boolean IsInstanceMethod, 
                                  boolean AtParameterName, 
                                  OpaquePtr<QualType> ReturnTy, 
                                  ArrayRef<IdentifierInfo /*P*/ > SelIdents) {
  ResultBuilder Results = null;
  try {
    // If we have an external source, load the entire class method
    // pool from the AST file.
    if (($this().ExternalSource != null)) {
      for (/*uint32_t*/int I = 0, N = $this().ExternalSource.GetNumExternalSelectors();
           I != N; ++I) {
        Selector Sel = $this().ExternalSource.GetExternalSelector(I);
        if (Sel.isNull() || ($this().MethodPool.count(Sel) != 0)) {
          continue;
        }
        
        $this().ReadMethodPool(new Selector(Sel));
      }
    }
    
    // Build the set of methods we can see.
    /*typedef CodeCompletionResult Result*/
//    final class Result extends CodeCompletionResult{ };
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other));
    if (ReturnTy.$bool()) {
      Results.setPreferredType(GetTypeFromParser(new OpaquePtr<QualType>(ReturnTy)).getNonReferenceType());
    }
    
    Results.EnterNewScope();
    for (DenseMapIterator<Selector, pair<ObjCMethodList, ObjCMethodList>> M = $this().MethodPool.begin(), 
        MEnd = $this().MethodPool.end();
         M.$noteq(/*NO_ITER_COPY*/MEnd); M.$preInc()) {
      for (ObjCMethodList /*P*/ MethList = IsInstanceMethod ? $AddrOf(M.$arrow().second.first) : $AddrOf(M.$arrow().second.second);
           (MethList != null) && (MethList.getMethod() != null);
           MethList = MethList.getNext()) {
        if (!isAcceptableObjCMethod(MethList.getMethod(), ObjCMethodKind.MK_Any, new ArrayRef<IdentifierInfo /*P*/ >(SelIdents))) {
          continue;
        }
        if (AtParameterName) {
          // Suggest parameter names we've seen before.
          /*uint*/int NumSelIdents = SelIdents.size();
          if ((NumSelIdents != 0)
             && $lesseq_uint(NumSelIdents, MethList.getMethod().param_size())) {
            ParmVarDecl /*P*/ Param = MethList.getMethod().parameters().$at(NumSelIdents - 1);
            if ((Param.getIdentifier() != null)) {
              CodeCompletionBuilder Builder = null;
              try {
                Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
                    Results.getCodeCompletionTUInfo());
                Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(Param.getIdentifier().getName())));
                Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
              } finally {
                if (Builder != null) { Builder.$destroy(); }
              }
            }
          }
          
          continue;
        }
        
        CodeCompletionResult R/*J*/= new CodeCompletionResult(MethList.getMethod(), 
            Results.getBasePriority(MethList.getMethod()), (NestedNameSpecifier /*P*/ )null);
        R.StartParameter = SelIdents.size();
        R.AllParametersAreInformative = false;
        R.DeclaringEntity = true;
        Results.MaybeAddResult(new CodeCompletionResult(R), $this().CurContext);
      }
    }
    
    Results.ExitScope();
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Other), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompletePreprocessorDirective">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7288,
 FQN="clang::Sema::CodeCompletePreprocessorDirective", NM="_ZN5clang4Sema33CodeCompletePreprocessorDirectiveEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema33CodeCompletePreprocessorDirectiveEb")
//</editor-fold>
public final void CodeCompletePreprocessorDirective(boolean InConditional) {
  ResultBuilder Results = null;
  CodeCompletionBuilder Builder = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PreprocessorDirective));
    Results.EnterNewScope();
    
    // #if <condition>
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    Builder.AddTypedTextChunk($if);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("condition"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #ifdef <macro>
    Builder.AddTypedTextChunk($ifdef);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("macro"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #ifndef <macro>
    Builder.AddTypedTextChunk($ifndef);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("macro"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    if (InConditional) {
      // #elif <condition>
      Builder.AddTypedTextChunk($elif);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddPlaceholderChunk($("condition"));
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      // #else
      Builder.AddTypedTextChunk($else);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      // #endif
      Builder.AddTypedTextChunk($endif);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
    
    // #include "header"
    Builder.AddTypedTextChunk($include);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddTextChunk($DBL_QUOTE);
    Builder.AddPlaceholderChunk($("header"));
    Builder.AddTextChunk($DBL_QUOTE);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #include <header>
    Builder.AddTypedTextChunk($include);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddTextChunk($LT);
    Builder.AddPlaceholderChunk($("header"));
    Builder.AddTextChunk($GT);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #define <macro>
    Builder.AddTypedTextChunk($define);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("macro"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #define <macro>(<args>)
    Builder.AddTypedTextChunk($define);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("macro"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
    Builder.AddPlaceholderChunk($("args"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #undef <macro>
    Builder.AddTypedTextChunk($undef);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("macro"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #line <number>
    Builder.AddTypedTextChunk($line);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("number"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #line <number> "filename"
    Builder.AddTypedTextChunk($line);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("number"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddTextChunk($DBL_QUOTE);
    Builder.AddPlaceholderChunk($("filename"));
    Builder.AddTextChunk($DBL_QUOTE);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #error <message>
    Builder.AddTypedTextChunk($error);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("message"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #pragma <arguments>
    Builder.AddTypedTextChunk($pragma);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("arguments"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    if ($this().getLangOpts().ObjC1) {
      // #import "header"
      Builder.AddTypedTextChunk($import);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddTextChunk($DBL_QUOTE);
      Builder.AddPlaceholderChunk($("header"));
      Builder.AddTextChunk($DBL_QUOTE);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
      
      // #import <header>
      Builder.AddTypedTextChunk($import);
      Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
      Builder.AddTextChunk($LT);
      Builder.AddPlaceholderChunk($("header"));
      Builder.AddTextChunk($GT);
      Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    }
    
    // #include_next "header"
    Builder.AddTypedTextChunk($include_next);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddTextChunk($DBL_QUOTE);
    Builder.AddPlaceholderChunk($("header"));
    Builder.AddTextChunk($DBL_QUOTE);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #include_next <header>
    Builder.AddTypedTextChunk($include_next);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddTextChunk($LT);
    Builder.AddPlaceholderChunk($("header"));
    Builder.AddTextChunk($GT);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // #warning <message>
    Builder.AddTypedTextChunk($warning);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddPlaceholderChunk($("message"));
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    
    // Note: #ident and #sccs are such crazy anachronisms that we don't provide
    // completions for them. And __include_macros is a Clang-internal extension
    // that we don't want to encourage anyone to use.
    
    // FIXME: we don't support #assert or #unassert, so don't suggest them.
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PreprocessorDirective), 
        Results.data(), Results.size());
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteInPreprocessorConditionalExclusion">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7447,
 FQN="clang::Sema::CodeCompleteInPreprocessorConditionalExclusion", NM="_ZN5clang4Sema46CodeCompleteInPreprocessorConditionalExclusionEPNS_5ScopeE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema46CodeCompleteInPreprocessorConditionalExclusionEPNS_5ScopeE")
//</editor-fold>
public final void CodeCompleteInPreprocessorConditionalExclusion(Scope /*P*/ S) {
  $this().CodeCompleteOrdinaryName(S, 
      (S.getFnParent() != null) ? Sema.ParserCompletionContext.PCC_RecoveryInFunction : Sema.ParserCompletionContext.PCC_Namespace);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompletePreprocessorMacroName">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7453,
 FQN="clang::Sema::CodeCompletePreprocessorMacroName", NM="_ZN5clang4Sema33CodeCompletePreprocessorMacroNameEb",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema33CodeCompletePreprocessorMacroNameEb")
//</editor-fold>
public final void CodeCompletePreprocessorMacroName(boolean IsDefinition) {
  ResultBuilder Results = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(IsDefinition ? CodeCompletionContext.Kind.CCC_MacroName : CodeCompletionContext.Kind.CCC_MacroNameUse));
    if (!IsDefinition && (!($this().CodeCompleter != null) || $this().CodeCompleter.includeMacros())) {
      CodeCompletionBuilder Builder = null;
      try {
        // Add just the names of macros, not their arguments.    
        Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
            Results.getCodeCompletionTUInfo());
        Results.EnterNewScope();
        for (DenseMapIterator</*const*/ IdentifierInfo /*P*/ , MacroState> M = $this().PP.macro_begin(), 
            MEnd = $this().PP.macro_end();
             M.$noteq(MEnd); M.$preInc()) {
          Builder.AddTypedTextChunk(Builder.getAllocator().CopyString(new Twine(M.$arrow().first.getName())));
          Results.AddResult(new CodeCompletionResult(Builder.TakeString(), 
                  CCP_CodePattern, 
                  CXCursorKind.CXCursor_MacroDefinition));
        }
        Results.ExitScope();
      } finally {
        if (Builder != null) { Builder.$destroy(); }
      }
    } else if (IsDefinition) {
      // FIXME: Can we detect when the user just wrote an include guard above?
    }
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, new CodeCompletionContext(Results.getCompletionContext()), 
        Results.data(), Results.size());
  } finally {
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompletePreprocessorExpression">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7481,
 FQN="clang::Sema::CodeCompletePreprocessorExpression", NM="_ZN5clang4Sema34CodeCompletePreprocessorExpressionEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema34CodeCompletePreprocessorExpressionEv")
//</editor-fold>
public final void CodeCompletePreprocessorExpression() {
  ResultBuilder Results = null;
  CodeCompletionBuilder Builder = null;
  try {
    Results/*J*/= new ResultBuilder(/*Deref*/$this(), $this().CodeCompleter.getAllocator(), 
        $this().CodeCompleter.getCodeCompletionTUInfo(), 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PreprocessorExpression));
    if (!($this().CodeCompleter != null) || $this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Results, true);
    }
    
    // defined (<macro>)
    Results.EnterNewScope();
    Builder/*J*/= new CodeCompletionBuilder(Results.getAllocator(), 
        Results.getCodeCompletionTUInfo());
    Builder.AddTypedTextChunk($("defined"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_HorizontalSpace);
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_LeftParen);
    Builder.AddPlaceholderChunk($("macro"));
    Builder.AddChunk(CodeCompletionString.ChunkKind.CK_RightParen);
    Results.AddResult(new CodeCompletionResult(Builder.TakeString()));
    Results.ExitScope();
    
    HandleCodeCompleteResults($this(), $this().CodeCompleter, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_PreprocessorExpression), 
        Results.data(), Results.size());
  } finally {
    if (Builder != null) { Builder.$destroy(); }
    if (Results != null) { Results.$destroy(); }
  }
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompletePreprocessorMacroArgument">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7506,
 FQN="clang::Sema::CodeCompletePreprocessorMacroArgument", NM="_ZN5clang4Sema37CodeCompletePreprocessorMacroArgumentEPNS_5ScopeEPNS_14IdentifierInfoEPNS_9MacroInfoEj",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema37CodeCompletePreprocessorMacroArgumentEPNS_5ScopeEPNS_14IdentifierInfoEPNS_9MacroInfoEj")
//</editor-fold>
public final void CodeCompletePreprocessorMacroArgument(Scope /*P*/ S, 
                                     IdentifierInfo /*P*/ Macro, 
                                     MacroInfo /*P*/ $MacroInfo, 
                                     /*uint*/int Argument) {

  // FIXME: In the future, we could provide "overload" results, much like we
  // do for function calls.

  // Now just ignore this. There will be another code-completion callback
  // for the expanded tokens.
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::CodeCompleteNaturalLanguage">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7517,
 FQN="clang::Sema::CodeCompleteNaturalLanguage", NM="_ZN5clang4Sema27CodeCompleteNaturalLanguageEv",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema27CodeCompleteNaturalLanguageEv")
//</editor-fold>
public final void CodeCompleteNaturalLanguage() {
  HandleCodeCompleteResults($this(), $this().CodeCompleter, 
      new CodeCompletionContext(CodeCompletionContext.Kind.CCC_NaturalLanguage), 
      (type$ptr<CodeCompletionResult/*P*/> )null, 0);
}

//<editor-fold defaultstate="collapsed" desc="clang::Sema::GatherGlobalCodeCompletions">
@Converted(kind = Converted.Kind.AUTO,
 source = "${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp", line = 7523,
 FQN="clang::Sema::GatherGlobalCodeCompletions", NM="_ZN5clang4Sema27GatherGlobalCodeCompletionsERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoERN4llvm15SmallVectorImplINS_20CodeCompletionResultEEE",
 cmd="jclank.sh -java-options=${SPUTNIK}/modules/org.clang.sema/llvmToClangType -split-class=clang::Sema@this ${LLVM_SRC}/llvm/tools/clang/lib/Sema/SemaCodeComplete.cpp -nm=_ZN5clang4Sema27GatherGlobalCodeCompletionsERNS_23CodeCompletionAllocatorERNS_20CodeCompletionTUInfoERN4llvm15SmallVectorImplINS_20CodeCompletionResultEEE")
//</editor-fold>
public final void GatherGlobalCodeCompletions(final CodeCompletionAllocator /*&*/ Allocator, 
                           final CodeCompletionTUInfo /*&*/ CCTUInfo, 
                           final SmallVectorImpl<CodeCompletionResult> /*&*/ Results) {
  ResultBuilder Builder = null;
  try {
    Builder/*J*/= new ResultBuilder(/*Deref*/$this(), Allocator, CCTUInfo, 
        new CodeCompletionContext(CodeCompletionContext.Kind.CCC_Recovery));
    if (!($this().CodeCompleter != null) || $this().CodeCompleter.includeGlobals()) {
      CodeCompletionDeclConsumer Consumer = null;
      try {
        Consumer/*J*/= new CodeCompletionDeclConsumer(Builder, 
            $this().Context.getTranslationUnitDecl());
        $this().LookupVisibleDecls($this().Context.getTranslationUnitDecl(), LookupNameKind.LookupAnyName, 
            Consumer);
      } finally {
        if (Consumer != null) { Consumer.$destroy(); }
      }
    }
    if (!($this().CodeCompleter != null) || $this().CodeCompleter.includeMacros()) {
      AddMacroResults($this().PP, Builder, true);
    }
    
    Results.clear();
    Results.insert$T$value_T(Results.end(), 
        Builder.data(), Builder.data().$add(Builder.size()));
  } finally {
    if (Builder != null) { Builder.$destroy(); }
  }
}

} // END OF class Sema_SemaCodeComplete
